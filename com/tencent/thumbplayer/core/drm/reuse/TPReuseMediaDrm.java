package com.tencent.thumbplayer.core.drm.reuse;

import android.media.DeniedByServerException;
import android.media.MediaDrm;
import android.media.MediaDrmException;
import android.media.NotProvisionedException;
import android.media.ResourceBusyException;
import android.media.UnsupportedSchemeException;
import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.tencent.thumbplayer.core.drm.ITPMediaDrm;
import com.tencent.thumbplayer.core.drm.TPDirectMediaDrm;
import com.tencent.thumbplayer.core.drm.TPMediaDrmFatalException;
import com.tencent.thumbplayer.core.drm.reuse.TPDoubleQueueCachedPool;
import com.tencent.thumbplayer.core.utils.TPNativeLog;
import com.tencent.thumbplayer.core.utils.TPThreadPool;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@RequiresApi(api = 18)
/* loaded from: classes26.dex */
public class TPReuseMediaDrm implements ITPMediaDrm {
    private static final int INIT_POOL_SIZE = 1;
    private static final int KEEP_POOL_SIZE = 2;
    private static final String TAG = "[PlayerCore][TPReuseMediaDrm]";
    private static final UUID WIDEVINE_UUID = new UUID(-1301668207276963122L, -6645017420763422227L);
    private static HashMap<UUID, TPDoubleQueueCachedPool<TPMediaDrmInfo>> mMediaDrmCachedPoolMap = null;
    private final boolean mCanReUse;
    private ITPMediaDrm.OnExpirationUpdateListener mOnExpirationUpdateListener;
    private ITPMediaDrm.OnKeyStatusChangeListener mOnKeyStatusChangeListener;
    private final ITPMediaDrm mTPMediaDrm;
    private boolean mTPMediaDrmError = false;
    private final TPMediaDrmInfo mTPMediaDrmInfo;
    private final UUID mUUID;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes26.dex */
    public static class TPMediaDrmInfo {

        @NonNull
        byte[] sessionId;

        @NonNull
        final ITPMediaDrm tpMediaDrm;

        public TPMediaDrmInfo(@NonNull ITPMediaDrm iTPMediaDrm, @NonNull byte[] bArr) {
            this.tpMediaDrm = iTPMediaDrm;
            this.sessionId = bArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes26.dex */
    public static class TPObjectLifecycleMgr implements TPDoubleQueueCachedPool.ITPObjectLifecycleMgr<TPMediaDrmInfo> {

        @NonNull
        private final UUID mUUID;

        public TPObjectLifecycleMgr(@NonNull UUID uuid) {
            this.mUUID = uuid;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.tencent.thumbplayer.core.drm.reuse.TPDoubleQueueCachedPool.ITPObjectLifecycleMgr
        @Nullable
        public TPMediaDrmInfo create(TPDoubleQueueCachedPool<TPMediaDrmInfo> tPDoubleQueueCachedPool) {
            try {
                TPDirectMediaDrm tPDirectMediaDrm = new TPDirectMediaDrm(this.mUUID);
                return new TPMediaDrmInfo(tPDirectMediaDrm, tPDirectMediaDrm.openSession());
            } catch (MediaDrmException | TPMediaDrmFatalException e16) {
                TPNativeLog.printLog(0, TPReuseMediaDrm.TAG, "createObject error:" + e16);
                return null;
            }
        }

        @Override // com.tencent.thumbplayer.core.drm.reuse.TPDoubleQueueCachedPool.ITPObjectLifecycleMgr
        public void release(TPDoubleQueueCachedPool<TPMediaDrmInfo> tPDoubleQueueCachedPool, @NonNull TPMediaDrmInfo tPMediaDrmInfo) {
            tPMediaDrmInfo.tpMediaDrm.close();
        }

        @Override // com.tencent.thumbplayer.core.drm.reuse.TPDoubleQueueCachedPool.ITPObjectLifecycleMgr
        public boolean reset(TPDoubleQueueCachedPool<TPMediaDrmInfo> tPDoubleQueueCachedPool, @NonNull TPMediaDrmInfo tPMediaDrmInfo) {
            tPMediaDrmInfo.tpMediaDrm.closeSession(tPMediaDrmInfo.sessionId);
            try {
                tPMediaDrmInfo.sessionId = tPMediaDrmInfo.tpMediaDrm.openSession();
                return true;
            } catch (MediaDrmException | TPMediaDrmFatalException e16) {
                TPNativeLog.printLog(0, TPReuseMediaDrm.TAG, "reset error:" + e16);
                return false;
            }
        }
    }

    public TPReuseMediaDrm(@NonNull UUID uuid) throws UnsupportedSchemeException, ResourceBusyException, NotProvisionedException, TPMediaDrmFatalException {
        preload();
        TPMediaDrmInfo allocTPMediaDrm = allocTPMediaDrm(uuid);
        this.mCanReUse = allocTPMediaDrm != null;
        if (allocTPMediaDrm == null) {
            TPDirectMediaDrm tPDirectMediaDrm = new TPDirectMediaDrm(uuid);
            allocTPMediaDrm = new TPMediaDrmInfo(tPDirectMediaDrm, tPDirectMediaDrm.openSession());
        }
        this.mTPMediaDrmInfo = allocTPMediaDrm;
        this.mTPMediaDrm = allocTPMediaDrm.tpMediaDrm;
        this.mUUID = uuid;
        TPNativeLog.printLog(2, TAG, "TPReuseMediaDrm constructor");
    }

    @Nullable
    private TPMediaDrmInfo allocTPMediaDrm(@NonNull UUID uuid) {
        TPDoubleQueueCachedPool<TPMediaDrmInfo> tPDoubleQueueCachedPool = mMediaDrmCachedPoolMap.get(uuid);
        if (tPDoubleQueueCachedPool == null) {
            TPNativeLog.printLog(0, TAG, "allocTPMediaDrm error, this UUID DRM is not cached");
            return null;
        }
        return tPDoubleQueueCachedPool.allocObject();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void freeTPMediaDrm(@NonNull UUID uuid, @NonNull TPMediaDrmInfo tPMediaDrmInfo, boolean z16) {
        TPDoubleQueueCachedPool<TPMediaDrmInfo> tPDoubleQueueCachedPool = mMediaDrmCachedPoolMap.get(uuid);
        if (tPDoubleQueueCachedPool == null) {
            tPMediaDrmInfo.tpMediaDrm.close();
        } else if (z16) {
            tPDoubleQueueCachedPool.freeObject(tPMediaDrmInfo);
        } else {
            tPDoubleQueueCachedPool.recycleObject(tPMediaDrmInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void preload() {
        if (mMediaDrmCachedPoolMap != null) {
            return;
        }
        UUID uuid = WIDEVINE_UUID;
        TPDoubleQueueCachedPool<TPMediaDrmInfo> tPDoubleQueueCachedPool = new TPDoubleQueueCachedPool<>(1, 2, new TPObjectLifecycleMgr(uuid));
        synchronized (TPReuseMediaDrm.class) {
            if (mMediaDrmCachedPoolMap == null) {
                HashMap<UUID, TPDoubleQueueCachedPool<TPMediaDrmInfo>> hashMap = new HashMap<>();
                mMediaDrmCachedPoolMap = hashMap;
                hashMap.put(uuid, tPDoubleQueueCachedPool);
                tPDoubleQueueCachedPool = null;
            }
        }
        if (tPDoubleQueueCachedPool != null) {
            tPDoubleQueueCachedPool.release();
        }
    }

    public static void preloadAsync() {
        TPThreadPool.getInstance().obtainThreadExecutor().execute(new Runnable() { // from class: com.tencent.thumbplayer.core.drm.reuse.TPReuseMediaDrm.1
            @Override // java.lang.Runnable
            public void run() {
                TPReuseMediaDrm.preload();
            }
        });
    }

    @Override // com.tencent.thumbplayer.core.drm.ITPMediaDrm
    public void close() {
        this.mTPMediaDrm.setOnExpirationUpdateListener(null, null);
        this.mOnExpirationUpdateListener = null;
        this.mTPMediaDrm.setOnKeyStatusChangeListener(null, null);
        this.mOnKeyStatusChangeListener = null;
        if (!this.mCanReUse) {
            this.mTPMediaDrm.close();
        } else {
            TPThreadPool.getInstance().obtainThreadExecutor().execute(new Runnable() { // from class: com.tencent.thumbplayer.core.drm.reuse.TPReuseMediaDrm.4
                @Override // java.lang.Runnable
                public void run() {
                    TPReuseMediaDrm tPReuseMediaDrm = TPReuseMediaDrm.this;
                    tPReuseMediaDrm.freeTPMediaDrm(tPReuseMediaDrm.mUUID, TPReuseMediaDrm.this.mTPMediaDrmInfo, TPReuseMediaDrm.this.mTPMediaDrmError);
                }
            });
        }
    }

    @Override // com.tencent.thumbplayer.core.drm.ITPMediaDrm
    public synchronized void closeSession(@NonNull byte[] bArr) {
        if (!Arrays.equals(bArr, this.mTPMediaDrmInfo.sessionId)) {
            this.mTPMediaDrmError = true;
        }
    }

    @Override // com.tencent.thumbplayer.core.drm.ITPMediaDrm
    @NonNull
    public MediaDrm.KeyRequest getKeyRequest(@NonNull byte[] bArr, @Nullable byte[] bArr2, @Nullable String str, int i3, @Nullable HashMap<String, String> hashMap) throws NotProvisionedException, TPMediaDrmFatalException {
        return this.mTPMediaDrm.getKeyRequest(bArr, bArr2, str, i3, hashMap);
    }

    @Override // com.tencent.thumbplayer.core.drm.ITPMediaDrm
    @NonNull
    public String getPropertyString(@NonNull String str) {
        return this.mTPMediaDrm.getPropertyString(str);
    }

    @Override // com.tencent.thumbplayer.core.drm.ITPMediaDrm
    public MediaDrm.ProvisionRequest getProvisionRequest() throws TPMediaDrmFatalException {
        return this.mTPMediaDrm.getProvisionRequest();
    }

    @Override // com.tencent.thumbplayer.core.drm.ITPMediaDrm
    @NonNull
    public synchronized byte[] openSession() throws NotProvisionedException, ResourceBusyException {
        return this.mTPMediaDrmInfo.sessionId;
    }

    @Override // com.tencent.thumbplayer.core.drm.ITPMediaDrm
    @Nullable
    public byte[] provideKeyResponse(@NonNull byte[] bArr, @NonNull byte[] bArr2) throws NotProvisionedException, DeniedByServerException, TPMediaDrmFatalException {
        return this.mTPMediaDrm.provideKeyResponse(bArr, bArr2);
    }

    @Override // com.tencent.thumbplayer.core.drm.ITPMediaDrm
    public void provideProvisionResponse(@NonNull byte[] bArr) throws DeniedByServerException {
        this.mTPMediaDrm.provideProvisionResponse(bArr);
    }

    @Override // com.tencent.thumbplayer.core.drm.ITPMediaDrm
    @NonNull
    public HashMap<String, String> queryKeyStatus(@NonNull byte[] bArr) {
        return this.mTPMediaDrm.queryKeyStatus(bArr);
    }

    @Override // com.tencent.thumbplayer.core.drm.ITPMediaDrm
    public void removeKeys(@NonNull byte[] bArr) {
        this.mTPMediaDrm.removeKeys(bArr);
    }

    @Override // com.tencent.thumbplayer.core.drm.ITPMediaDrm
    public void restoreKeys(@NonNull byte[] bArr, @NonNull byte[] bArr2) {
        this.mTPMediaDrm.restoreKeys(bArr, bArr2);
    }

    @Override // com.tencent.thumbplayer.core.drm.ITPMediaDrm
    @RequiresApi(api = 23)
    public void setOnExpirationUpdateListener(@Nullable ITPMediaDrm.OnExpirationUpdateListener onExpirationUpdateListener, @Nullable Handler handler) {
        this.mOnExpirationUpdateListener = onExpirationUpdateListener;
        this.mTPMediaDrm.setOnExpirationUpdateListener(new ITPMediaDrm.OnExpirationUpdateListener() { // from class: com.tencent.thumbplayer.core.drm.reuse.TPReuseMediaDrm.3
            @Override // com.tencent.thumbplayer.core.drm.ITPMediaDrm.OnExpirationUpdateListener
            public void onExpirationUpdate(@NonNull ITPMediaDrm iTPMediaDrm, @NonNull byte[] bArr, long j3) {
                ITPMediaDrm.OnExpirationUpdateListener onExpirationUpdateListener2 = TPReuseMediaDrm.this.mOnExpirationUpdateListener;
                if (onExpirationUpdateListener2 != null) {
                    onExpirationUpdateListener2.onExpirationUpdate(TPReuseMediaDrm.this, bArr, j3);
                }
            }
        }, handler);
    }

    @Override // com.tencent.thumbplayer.core.drm.ITPMediaDrm
    @RequiresApi(api = 23)
    public void setOnKeyStatusChangeListener(@Nullable ITPMediaDrm.OnKeyStatusChangeListener onKeyStatusChangeListener, @Nullable Handler handler) {
        this.mOnKeyStatusChangeListener = onKeyStatusChangeListener;
        this.mTPMediaDrm.setOnKeyStatusChangeListener(new ITPMediaDrm.OnKeyStatusChangeListener() { // from class: com.tencent.thumbplayer.core.drm.reuse.TPReuseMediaDrm.2
            @Override // com.tencent.thumbplayer.core.drm.ITPMediaDrm.OnKeyStatusChangeListener
            public void onKeyStatusChange(@NonNull ITPMediaDrm iTPMediaDrm, @NonNull byte[] bArr, @NonNull List<MediaDrm.KeyStatus> list, boolean z16) {
                ITPMediaDrm.OnKeyStatusChangeListener onKeyStatusChangeListener2 = TPReuseMediaDrm.this.mOnKeyStatusChangeListener;
                if (onKeyStatusChangeListener2 != null) {
                    onKeyStatusChangeListener2.onKeyStatusChange(TPReuseMediaDrm.this, bArr, list, z16);
                }
            }
        }, handler);
    }

    @Override // com.tencent.thumbplayer.core.drm.ITPMediaDrm
    public void setPropertyString(@NonNull String str, @NonNull String str2) {
        this.mTPMediaDrm.setPropertyString(str, str2);
    }
}
