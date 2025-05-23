package com.tencent.thumbplayer.core.drm;

import android.media.DeniedByServerException;
import android.media.MediaCrypto;
import android.media.MediaCryptoException;
import android.media.MediaDrm;
import android.media.NotProvisionedException;
import android.media.UnsupportedSchemeException;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.tencent.thumbplayer.core.utils.TPNativeLog;
import com.tencent.thumbplayer.core.utils.TPThreadPool;
import java.util.UUID;

@RequiresApi(api = 18)
/* loaded from: classes26.dex */
public class TPMediaDrmProxy {
    private static final long CREATE_MEDIA_DRM_SLICE_WAIT_TIME_MS = 100;
    private static final long CREATE_MEDIA_DRM_TIMEOUT_MS = 5000;
    private static final int ERR_API_LOW_LEVEL = 2;
    private static final int ERR_CREATE_MEDIA_DRM_FAILED = 5;
    private static final int ERR_ILLEGAL_ARGUMENT = 1;
    private static final int ERR_INTERRUPT = 3;
    private static final int ERR_NONE = 0;
    private static final int ERR_UNSUPPORTED_SCHEME = 4;
    private static final String TAG = "[PlayerCore][TPMediaDrmProxy]";
    private ITPMediaDrm mMediaDrm;
    private long mNativeContext;
    private UUID mUUID;

    /* loaded from: classes26.dex */
    public static final class DrmSessionId {
        byte[] mSessionId;
        int mStatus;

        DrmSessionId(int i3, byte[] bArr) {
            this.mStatus = i3;
            this.mSessionId = bArr;
        }
    }

    /* loaded from: classes26.dex */
    public static final class KeyRequest {
        byte[] mData;
        int mRequestType;
        int mStatus;

        KeyRequest(int i3, byte[] bArr, int i16) {
            this.mRequestType = i3;
            this.mData = bArr;
            this.mStatus = i16;
        }
    }

    /* loaded from: classes26.dex */
    public static final class MediaDrmProxyCreateResult {
        int mErrorCode;
        TPMediaDrmProxy mMediaDrmProxy;

        MediaDrmProxyCreateResult(@Nullable TPMediaDrmProxy tPMediaDrmProxy, int i3) {
            this.mMediaDrmProxy = tPMediaDrmProxy;
            this.mErrorCode = i3;
        }
    }

    /* loaded from: classes26.dex */
    public static final class ProvisionRequest {
        byte[] mData;
        String mDefaultUrl;

        ProvisionRequest(String str, byte[] bArr) {
            this.mDefaultUrl = str;
            this.mData = bArr;
        }
    }

    private static void checkInterrupt(ITPDrmInterruptCallback iTPDrmInterruptCallback) throws InterruptedException {
        if (iTPDrmInterruptCallback != null && iTPDrmInterruptCallback.isInterrupted()) {
            throw new InterruptedException();
        }
    }

    @NonNull
    private static MediaDrmProxyCreateResult createMediaDrmProxyByUUID(String str, boolean z16, TPDrmInterruptCallbackProxy tPDrmInterruptCallbackProxy) {
        int i3 = 0;
        if (str == null) {
            TPNativeLog.printLog(0, "illegal argument.");
            return new MediaDrmProxyCreateResult(null, 1);
        }
        try {
            try {
                TPMediaDrmProxy createMediaDrmProxyWithAsyncTimeout = createMediaDrmProxyWithAsyncTimeout(UUID.fromString(str), z16, tPDrmInterruptCallbackProxy);
                if (createMediaDrmProxyWithAsyncTimeout == null) {
                    i3 = 5;
                }
                return new MediaDrmProxyCreateResult(createMediaDrmProxyWithAsyncTimeout, i3);
            } catch (UnsupportedSchemeException e16) {
                TPNativeLog.printLog(0, e16.getMessage());
                return new MediaDrmProxyCreateResult(null, 4);
            } catch (InterruptedException e17) {
                TPNativeLog.printLog(0, e17.getMessage());
                return new MediaDrmProxyCreateResult(null, 3);
            }
        } catch (IllegalArgumentException e18) {
            TPNativeLog.printLog(0, e18.getMessage());
            return new MediaDrmProxyCreateResult(null, 1);
        }
    }

    private static TPMediaDrmProxy createMediaDrmProxyWithAsyncTimeout(@NonNull final UUID uuid, final boolean z16, ITPDrmInterruptCallback iTPDrmInterruptCallback) throws UnsupportedSchemeException, InterruptedException {
        TPMediaDrmProxy tPMediaDrmProxy;
        final Object obj = new Object();
        final TPMediaDrmProxy[] tPMediaDrmProxyArr = {null};
        final UnsupportedSchemeException[] unsupportedSchemeExceptionArr = {null};
        final boolean[] zArr = {false};
        TPNativeLog.printLog(2, "async create mediaDrm proxy start.");
        TPThreadPool.getInstance().obtainThreadExecutor().execute(new Runnable() { // from class: com.tencent.thumbplayer.core.drm.TPMediaDrmProxy.1
            @Override // java.lang.Runnable
            public void run() {
                boolean z17;
                TPMediaDrmProxy tPMediaDrmProxy2;
                TPNativeLog.printLog(2, "create system mediaDrm proxy start.");
                try {
                    tPMediaDrmProxyArr[0] = new TPMediaDrmProxy(uuid, z16);
                } catch (UnsupportedSchemeException e16) {
                    unsupportedSchemeExceptionArr[0] = e16;
                }
                TPNativeLog.printLog(2, "create system mediaDrm proxy end.");
                synchronized (obj) {
                    z17 = zArr[0];
                    obj.notify();
                }
                if (z17 && (tPMediaDrmProxy2 = tPMediaDrmProxyArr[0]) != null) {
                    tPMediaDrmProxy2.release();
                }
            }
        });
        long elapsedRealtime = SystemClock.elapsedRealtime();
        while (tPMediaDrmProxyArr[0] == null) {
            synchronized (obj) {
                try {
                    checkInterrupt(iTPDrmInterruptCallback);
                } catch (InterruptedException e16) {
                    zArr[0] = true;
                    throw e16;
                }
            }
            long elapsedRealtime2 = 5000 - (SystemClock.elapsedRealtime() - elapsedRealtime);
            if (elapsedRealtime2 <= 0) {
                break;
            }
            synchronized (obj) {
                try {
                    try {
                        obj.wait(Math.min(elapsedRealtime2, 100L));
                    } catch (InterruptedException e17) {
                        zArr[0] = true;
                        throw e17;
                    }
                } finally {
                }
            }
        }
        UnsupportedSchemeException unsupportedSchemeException = unsupportedSchemeExceptionArr[0];
        if (unsupportedSchemeException == null) {
            synchronized (obj) {
                TPMediaDrmProxy tPMediaDrmProxy2 = tPMediaDrmProxyArr[0];
                if (tPMediaDrmProxy2 == null) {
                    zArr[0] = true;
                    tPMediaDrmProxy = null;
                } else {
                    tPMediaDrmProxy = tPMediaDrmProxy2;
                }
            }
            TPNativeLog.printLog(2, "async create mediaDrm proxy end.");
            return tPMediaDrmProxy;
        }
        throw unsupportedSchemeException;
    }

    public static boolean isCryptoSchemeSupported(String str) {
        if (str == null) {
            TPNativeLog.printLog(2, "isCryptoSchemeSupported, illegal argument.");
            return false;
        }
        try {
            boolean isCryptoSchemeSupported = MediaDrm.isCryptoSchemeSupported(UUID.fromString(str));
            TPNativeLog.printLog(2, "isCryptoSchemeSupported, supported:" + isCryptoSchemeSupported);
            return isCryptoSchemeSupported;
        } catch (IllegalArgumentException e16) {
            TPNativeLog.printLog(0, e16.getMessage());
            return false;
        }
    }

    private native void native_mediaDrmOnEvent(byte[] bArr, int i3, int i16, @Nullable byte[] bArr2);

    public static void setMediaDrmReuseEnable(boolean z16) {
        String str;
        TPMediaDrmPool.getInstance().setMediaDrmReuseEnable(z16);
        StringBuilder sb5 = new StringBuilder();
        sb5.append("setMediaDrmReuseEnable, reuse:");
        if (z16) {
            str = "true";
        } else {
            str = "false";
        }
        sb5.append(str);
        TPNativeLog.printLog(2, TAG, sb5.toString());
    }

    public void closeSession(byte[] bArr) {
        if (bArr == null) {
            return;
        }
        this.mMediaDrm.closeSession(bArr);
    }

    public KeyRequest getKeyRequest(byte[] bArr, byte[] bArr2, String str, int i3) {
        try {
            MediaDrm.KeyRequest keyRequest = this.mMediaDrm.getKeyRequest(bArr, bArr2, str, i3, null);
            return new KeyRequest(keyRequest.getRequestType(), keyRequest.getData(), 0);
        } catch (NotProvisionedException | TPMediaDrmFatalException unused) {
            return new KeyRequest(-1, null, -1);
        }
    }

    public MediaCrypto getMediaCrypto(byte[] bArr) {
        try {
            return new MediaCrypto(this.mUUID, bArr);
        } catch (MediaCryptoException unused) {
            return null;
        }
    }

    public String getPropertyString(String str) {
        return this.mMediaDrm.getPropertyString(str);
    }

    public ProvisionRequest getProvisionRequest() {
        try {
            MediaDrm.ProvisionRequest provisionRequest = this.mMediaDrm.getProvisionRequest();
            return new ProvisionRequest(provisionRequest.getDefaultUrl(), provisionRequest.getData());
        } catch (TPMediaDrmFatalException unused) {
            return new ProvisionRequest("", new byte[0]);
        }
    }

    public DrmSessionId openSession() {
        int i3;
        byte[] bArr = null;
        try {
            bArr = this.mMediaDrm.openSession();
            i3 = 0;
        } catch (NotProvisionedException unused) {
            i3 = -1;
        } catch (Exception unused2) {
            i3 = -2;
        }
        return new DrmSessionId(i3, bArr);
    }

    public int provideKeyResponse(byte[] bArr, byte[] bArr2) {
        try {
            this.mMediaDrm.provideKeyResponse(bArr, bArr2);
            return 0;
        } catch (DeniedByServerException | TPMediaDrmFatalException unused) {
            return -2;
        } catch (NotProvisionedException unused2) {
            return -1;
        }
    }

    public int provideProvisionResponse(byte[] bArr) {
        try {
            this.mMediaDrm.provideProvisionResponse(bArr);
            return 0;
        } catch (DeniedByServerException unused) {
            return -1;
        }
    }

    public void release() {
        this.mMediaDrm.close();
    }

    public void setPropertyString(String str, String str2) {
        this.mMediaDrm.setPropertyString(str, str2);
    }

    TPMediaDrmProxy(@NonNull UUID uuid, boolean z16) throws UnsupportedSchemeException {
        ITPMediaDrm createTPDirectMediaDrm;
        if (z16) {
            createTPDirectMediaDrm = TPMediaDrmPool.getInstance().createTPMediaDrm(uuid);
        } else {
            createTPDirectMediaDrm = TPMediaDrmPool.getInstance().createTPDirectMediaDrm(uuid);
        }
        this.mMediaDrm = createTPDirectMediaDrm;
        this.mUUID = uuid;
    }
}
