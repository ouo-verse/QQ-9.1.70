package com.google.android.exoplayer2.drm;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.drm.DefaultDrmSession;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.drm.ExoMediaCrypto;
import com.google.android.exoplayer2.drm.ExoMediaDrm;
import com.google.android.exoplayer2.extractor.mp4.PsshAtomUtil;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

/* compiled from: P */
@TargetApi(18)
/* loaded from: classes2.dex */
public class DefaultDrmSessionManager<T extends ExoMediaCrypto> implements DrmSessionManager<T>, DefaultDrmSession.ProvisioningManager<T> {
    private static final String CENC_SCHEME_MIME_TYPE = "cenc";
    public static final int INITIAL_DRM_REQUEST_RETRY_COUNT = 3;
    public static final int MODE_DOWNLOAD = 2;
    public static final int MODE_PLAYBACK = 0;
    public static final int MODE_QUERY = 1;
    public static final int MODE_RELEASE = 3;
    public static final String PLAYREADY_CUSTOM_DATA_KEY = "PRCustomData";
    private static final String TAG = "DefaultDrmSessionMgr";
    private final MediaDrmCallback callback;
    private final Handler eventHandler;
    private final EventListener eventListener;
    private final int initialDrmRequestRetryCount;
    private final ExoMediaDrm<T> mediaDrm;
    volatile DefaultDrmSessionManager<T>.MediaDrmHandler mediaDrmHandler;
    private int mode;
    private final boolean multiSession;
    private byte[] offlineLicenseKeySetId;
    private final HashMap<String, String> optionalKeyRequestParameters;
    private Looper playbackLooper;
    private final List<DefaultDrmSession<T>> provisioningSessions;
    private final List<DefaultDrmSession<T>> sessions;
    private final UUID uuid;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public interface EventListener {
        void onDrmKeysLoaded();

        void onDrmKeysRemoved();

        void onDrmKeysRestored();

        void onDrmSessionManagerError(Exception exc);
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    private class MediaDrmEventListener implements ExoMediaDrm.OnEventListener<T> {
        MediaDrmEventListener() {
        }

        @Override // com.google.android.exoplayer2.drm.ExoMediaDrm.OnEventListener
        public void onEvent(ExoMediaDrm<? extends T> exoMediaDrm, byte[] bArr, int i3, int i16, byte[] bArr2) {
            if (DefaultDrmSessionManager.this.mode == 0) {
                DefaultDrmSessionManager.this.mediaDrmHandler.obtainMessage(i3, bArr).sendToTarget();
            }
        }
    }

    /* compiled from: P */
    @SuppressLint({"HandlerLeak"})
    /* loaded from: classes2.dex */
    private class MediaDrmHandler extends Handler {
        public MediaDrmHandler(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            byte[] bArr = (byte[]) message.obj;
            for (DefaultDrmSession defaultDrmSession : DefaultDrmSessionManager.this.sessions) {
                if (defaultDrmSession.hasSessionId(bArr)) {
                    defaultDrmSession.onMediaDrmEvent(message.what);
                    return;
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class MissingSchemeDataException extends Exception {
        MissingSchemeDataException(UUID uuid) {
            super("Media does not support uuid: " + uuid);
        }
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes2.dex */
    public @interface Mode {
    }

    public DefaultDrmSessionManager(UUID uuid, ExoMediaDrm<T> exoMediaDrm, MediaDrmCallback mediaDrmCallback, HashMap<String, String> hashMap, Handler handler, EventListener eventListener) {
        this(uuid, exoMediaDrm, mediaDrmCallback, hashMap, handler, eventListener, false, 3);
    }

    private static DrmInitData.SchemeData getSchemeData(DrmInitData drmInitData, UUID uuid, boolean z16) {
        int i3;
        ArrayList arrayList = new ArrayList(drmInitData.schemeDataCount);
        int i16 = 0;
        while (true) {
            boolean z17 = true;
            if (i16 >= drmInitData.schemeDataCount) {
                break;
            }
            DrmInitData.SchemeData schemeData = drmInitData.get(i16);
            if (!schemeData.matches(uuid) && (!C.CLEARKEY_UUID.equals(uuid) || !schemeData.matches(C.COMMON_PSSH_UUID))) {
                z17 = false;
            }
            if (z17 && (schemeData.data != null || z16)) {
                arrayList.add(schemeData);
            }
            i16++;
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        if (C.WIDEVINE_UUID.equals(uuid)) {
            for (int i17 = 0; i17 < arrayList.size(); i17++) {
                DrmInitData.SchemeData schemeData2 = (DrmInitData.SchemeData) arrayList.get(i17);
                if (schemeData2.hasData()) {
                    i3 = PsshAtomUtil.parseVersion(schemeData2.data);
                } else {
                    i3 = -1;
                }
                int i18 = Util.SDK_INT;
                if (i18 < 23 && i3 == 0) {
                    return schemeData2;
                }
                if (i18 >= 23 && i3 == 1) {
                    return schemeData2;
                }
            }
        }
        return (DrmInitData.SchemeData) arrayList.get(0);
    }

    private static byte[] getSchemeInitData(DrmInitData.SchemeData schemeData, UUID uuid) {
        byte[] parseSchemeSpecificData;
        byte[] bArr = schemeData.data;
        if (Util.SDK_INT < 21 && (parseSchemeSpecificData = PsshAtomUtil.parseSchemeSpecificData(bArr, uuid)) != null) {
            return parseSchemeSpecificData;
        }
        return bArr;
    }

    private static String getSchemeMimeType(DrmInitData.SchemeData schemeData, UUID uuid) {
        String str = schemeData.mimeType;
        if (Util.SDK_INT < 26 && C.CLEARKEY_UUID.equals(uuid)) {
            if ("video/mp4".equals(str) || "audio/mp4".equals(str)) {
                return "cenc";
            }
            return str;
        }
        return str;
    }

    public static DefaultDrmSessionManager<FrameworkMediaCrypto> newFrameworkInstance(UUID uuid, MediaDrmCallback mediaDrmCallback, HashMap<String, String> hashMap, Handler handler, EventListener eventListener) throws UnsupportedDrmException {
        return new DefaultDrmSessionManager<>(uuid, FrameworkMediaDrm.newInstance(uuid), mediaDrmCallback, hashMap, handler, eventListener, false, 3);
    }

    public static DefaultDrmSessionManager<FrameworkMediaCrypto> newPlayReadyInstance(MediaDrmCallback mediaDrmCallback, String str, Handler handler, EventListener eventListener) throws UnsupportedDrmException {
        HashMap hashMap;
        if (!TextUtils.isEmpty(str)) {
            hashMap = new HashMap();
            hashMap.put(PLAYREADY_CUSTOM_DATA_KEY, str);
        } else {
            hashMap = null;
        }
        return newFrameworkInstance(C.PLAYREADY_UUID, mediaDrmCallback, hashMap, handler, eventListener);
    }

    public static DefaultDrmSessionManager<FrameworkMediaCrypto> newWidevineInstance(MediaDrmCallback mediaDrmCallback, HashMap<String, String> hashMap, Handler handler, EventListener eventListener) throws UnsupportedDrmException {
        return newFrameworkInstance(C.WIDEVINE_UUID, mediaDrmCallback, hashMap, handler, eventListener);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [com.google.android.exoplayer2.drm.DefaultDrmSessionManager$1] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3, types: [com.google.android.exoplayer2.drm.DefaultDrmSession, com.google.android.exoplayer2.drm.DrmSession<T extends com.google.android.exoplayer2.drm.ExoMediaCrypto>] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6 */
    @Override // com.google.android.exoplayer2.drm.DrmSessionManager
    public DrmSession<T> acquireSession(Looper looper, DrmInitData drmInitData) {
        boolean z16;
        byte[] bArr;
        String str;
        Looper looper2 = this.playbackLooper;
        if (looper2 != null && looper2 != looper) {
            z16 = false;
        } else {
            z16 = true;
        }
        Assertions.checkState(z16);
        if (this.sessions.isEmpty()) {
            this.playbackLooper = looper;
            if (this.mediaDrmHandler == null) {
                this.mediaDrmHandler = new MediaDrmHandler(looper);
            }
        }
        DefaultDrmSession<T> defaultDrmSession = 0;
        defaultDrmSession = 0;
        if (this.offlineLicenseKeySetId == null) {
            DrmInitData.SchemeData schemeData = getSchemeData(drmInitData, this.uuid, false);
            if (schemeData == null) {
                final MissingSchemeDataException missingSchemeDataException = new MissingSchemeDataException(this.uuid);
                Handler handler = this.eventHandler;
                if (handler != null && this.eventListener != null) {
                    handler.post(new Runnable() { // from class: com.google.android.exoplayer2.drm.DefaultDrmSessionManager.1
                        @Override // java.lang.Runnable
                        public void run() {
                            DefaultDrmSessionManager.this.eventListener.onDrmSessionManagerError(missingSchemeDataException);
                        }
                    });
                }
                return new ErrorStateDrmSession(new DrmSession.DrmSessionException(missingSchemeDataException));
            }
            byte[] schemeInitData = getSchemeInitData(schemeData, this.uuid);
            str = getSchemeMimeType(schemeData, this.uuid);
            bArr = schemeInitData;
        } else {
            bArr = null;
            str = null;
        }
        if (!this.multiSession) {
            if (!this.sessions.isEmpty()) {
                defaultDrmSession = this.sessions.get(0);
            }
        } else {
            Iterator<DefaultDrmSession<T>> it = this.sessions.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                DefaultDrmSession<T> next = it.next();
                if (next.hasInitData(bArr)) {
                    defaultDrmSession = next;
                    break;
                }
            }
        }
        if (defaultDrmSession == 0) {
            DefaultDrmSession<T> defaultDrmSession2 = new DefaultDrmSession<>(this.uuid, this.mediaDrm, this, bArr, str, this.mode, this.offlineLicenseKeySetId, this.optionalKeyRequestParameters, this.callback, looper, this.eventHandler, this.eventListener, this.initialDrmRequestRetryCount);
            this.sessions.add(defaultDrmSession2);
            defaultDrmSession = defaultDrmSession2;
        }
        ((DefaultDrmSession) defaultDrmSession).acquire();
        return (DrmSession<T>) defaultDrmSession;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSessionManager
    public boolean canAcquireSession(@NonNull DrmInitData drmInitData) {
        if (this.offlineLicenseKeySetId != null) {
            return true;
        }
        if (getSchemeData(drmInitData, this.uuid, true) == null) {
            if (drmInitData.schemeDataCount != 1 || !drmInitData.get(0).matches(C.COMMON_PSSH_UUID)) {
                return false;
            }
            Log.w(TAG, "DrmInitData only contains common PSSH SchemeData. Assuming support for: " + this.uuid);
        }
        String str = drmInitData.schemeType;
        if (str == null || "cenc".equals(str)) {
            return true;
        }
        if ((!C.CENC_TYPE_cbc1.equals(str) && !C.CENC_TYPE_cbcs.equals(str) && !C.CENC_TYPE_cens.equals(str)) || Util.SDK_INT >= 24) {
            return true;
        }
        return false;
    }

    public final byte[] getPropertyByteArray(String str) {
        return this.mediaDrm.getPropertyByteArray(str);
    }

    public final String getPropertyString(String str) {
        return this.mediaDrm.getPropertyString(str);
    }

    @Override // com.google.android.exoplayer2.drm.DefaultDrmSession.ProvisioningManager
    public void onProvisionCompleted() {
        Iterator<DefaultDrmSession<T>> it = this.provisioningSessions.iterator();
        while (it.hasNext()) {
            it.next().onProvisionCompleted();
        }
        this.provisioningSessions.clear();
    }

    @Override // com.google.android.exoplayer2.drm.DefaultDrmSession.ProvisioningManager
    public void onProvisionError(Exception exc) {
        Iterator<DefaultDrmSession<T>> it = this.provisioningSessions.iterator();
        while (it.hasNext()) {
            it.next().onProvisionError(exc);
        }
        this.provisioningSessions.clear();
    }

    @Override // com.google.android.exoplayer2.drm.DefaultDrmSession.ProvisioningManager
    public void provisionRequired(DefaultDrmSession<T> defaultDrmSession) {
        this.provisioningSessions.add(defaultDrmSession);
        if (this.provisioningSessions.size() == 1) {
            defaultDrmSession.provision();
        }
    }

    @Override // com.google.android.exoplayer2.drm.DrmSessionManager
    public void releaseSession(DrmSession<T> drmSession) {
        if (drmSession instanceof ErrorStateDrmSession) {
            return;
        }
        DefaultDrmSession<T> defaultDrmSession = (DefaultDrmSession) drmSession;
        if (defaultDrmSession.release()) {
            this.sessions.remove(defaultDrmSession);
            if (this.provisioningSessions.size() > 1 && this.provisioningSessions.get(0) == defaultDrmSession) {
                this.provisioningSessions.get(1).provision();
            }
            this.provisioningSessions.remove(defaultDrmSession);
        }
    }

    public void setMode(int i3, byte[] bArr) {
        Assertions.checkState(this.sessions.isEmpty());
        if (i3 == 1 || i3 == 3) {
            Assertions.checkNotNull(bArr);
        }
        this.mode = i3;
        this.offlineLicenseKeySetId = bArr;
    }

    public final void setPropertyByteArray(String str, byte[] bArr) {
        this.mediaDrm.setPropertyByteArray(str, bArr);
    }

    public final void setPropertyString(String str, String str2) {
        this.mediaDrm.setPropertyString(str, str2);
    }

    public DefaultDrmSessionManager(UUID uuid, ExoMediaDrm<T> exoMediaDrm, MediaDrmCallback mediaDrmCallback, HashMap<String, String> hashMap, Handler handler, EventListener eventListener, boolean z16) {
        this(uuid, exoMediaDrm, mediaDrmCallback, hashMap, handler, eventListener, z16, 3);
    }

    public DefaultDrmSessionManager(UUID uuid, ExoMediaDrm<T> exoMediaDrm, MediaDrmCallback mediaDrmCallback, HashMap<String, String> hashMap, Handler handler, EventListener eventListener, boolean z16, int i3) {
        Assertions.checkNotNull(uuid);
        Assertions.checkNotNull(exoMediaDrm);
        Assertions.checkArgument(!C.COMMON_PSSH_UUID.equals(uuid), "Use C.CLEARKEY_UUID instead");
        this.uuid = uuid;
        this.mediaDrm = exoMediaDrm;
        this.callback = mediaDrmCallback;
        this.optionalKeyRequestParameters = hashMap;
        this.eventHandler = handler;
        this.eventListener = eventListener;
        this.multiSession = z16;
        this.initialDrmRequestRetryCount = i3;
        this.mode = 0;
        this.sessions = new ArrayList();
        this.provisioningSessions = new ArrayList();
        if (z16) {
            exoMediaDrm.setPropertyString("sessionSharing", "enable");
        }
        exoMediaDrm.setOnEventListener(new MediaDrmEventListener());
    }
}
