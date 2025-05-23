package com.google.android.exoplayer2.drm;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.media.NotProvisionedException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.Pair;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.drm.DefaultDrmSessionManager;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.drm.ExoMediaCrypto;
import com.google.android.exoplayer2.drm.ExoMediaDrm;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@TargetApi(18)
/* loaded from: classes2.dex */
public class DefaultDrmSession<T extends ExoMediaCrypto> implements DrmSession<T> {
    private static final int MAX_LICENSE_DURATION_TO_RENEW = 60;
    private static final int MSG_KEYS = 1;
    private static final int MSG_PROVISION = 0;
    private static final String TAG = "DefaultDrmSession";
    final MediaDrmCallback callback;
    private final Handler eventHandler;
    private final DefaultDrmSessionManager.EventListener eventListener;
    private final byte[] initData;
    private final int initialDrmRequestRetryCount;
    private DrmSession.DrmSessionException lastException;
    private T mediaCrypto;
    private final ExoMediaDrm<T> mediaDrm;
    private final String mimeType;
    private final int mode;
    private byte[] offlineLicenseKeySetId;
    private int openCount;
    private final HashMap<String, String> optionalKeyRequestParameters;
    private DefaultDrmSession<T>.PostRequestHandler postRequestHandler;
    final DefaultDrmSession<T>.PostResponseHandler postResponseHandler;
    private final ProvisioningManager<T> provisioningManager;
    private HandlerThread requestHandlerThread;
    private byte[] sessionId;
    private int state = 2;
    final UUID uuid;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @SuppressLint({"HandlerLeak"})
    /* loaded from: classes2.dex */
    public class PostRequestHandler extends Handler {
        public PostRequestHandler(Looper looper) {
            super(looper);
        }

        private long getRetryDelayMillis(int i3) {
            return Math.min((i3 - 1) * 1000, 5000);
        }

        private boolean maybeRetryRequest(Message message) {
            boolean z16;
            int i3;
            if (message.arg1 == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16 || (i3 = message.arg2 + 1) > DefaultDrmSession.this.initialDrmRequestRetryCount) {
                return false;
            }
            Message obtain = Message.obtain(message);
            obtain.arg2 = i3;
            sendMessageDelayed(obtain, getRetryDelayMillis(i3));
            return true;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            try {
                int i3 = message.what;
                if (i3 != 0) {
                    if (i3 == 1) {
                        DefaultDrmSession defaultDrmSession = DefaultDrmSession.this;
                        e = defaultDrmSession.callback.executeKeyRequest(defaultDrmSession.uuid, (ExoMediaDrm.KeyRequest) message.obj);
                    } else {
                        throw new RuntimeException();
                    }
                } else {
                    DefaultDrmSession defaultDrmSession2 = DefaultDrmSession.this;
                    e = defaultDrmSession2.callback.executeProvisionRequest(defaultDrmSession2.uuid, (ExoMediaDrm.ProvisionRequest) message.obj);
                }
            } catch (Exception e16) {
                e = e16;
                if (maybeRetryRequest(message)) {
                    return;
                }
            }
            DefaultDrmSession.this.postResponseHandler.obtainMessage(message.what, e).sendToTarget();
        }

        Message obtainMessage(int i3, Object obj, boolean z16) {
            return obtainMessage(i3, z16 ? 1 : 0, 0, obj);
        }
    }

    /* compiled from: P */
    @SuppressLint({"HandlerLeak"})
    /* loaded from: classes2.dex */
    private class PostResponseHandler extends Handler {
        public PostResponseHandler(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i3 = message.what;
            if (i3 == 0) {
                DefaultDrmSession.this.onProvisionResponse(message.obj);
            } else if (i3 == 1) {
                DefaultDrmSession.this.onKeyResponse(message.obj);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public interface ProvisioningManager<T extends ExoMediaCrypto> {
        void onProvisionCompleted();

        void onProvisionError(Exception exc);

        void provisionRequired(DefaultDrmSession<T> defaultDrmSession);
    }

    public DefaultDrmSession(UUID uuid, ExoMediaDrm<T> exoMediaDrm, ProvisioningManager<T> provisioningManager, byte[] bArr, String str, int i3, byte[] bArr2, HashMap<String, String> hashMap, MediaDrmCallback mediaDrmCallback, Looper looper, Handler handler, DefaultDrmSessionManager.EventListener eventListener, int i16) {
        this.uuid = uuid;
        this.provisioningManager = provisioningManager;
        this.mediaDrm = exoMediaDrm;
        this.mode = i3;
        this.offlineLicenseKeySetId = bArr2;
        this.optionalKeyRequestParameters = hashMap;
        this.callback = mediaDrmCallback;
        this.initialDrmRequestRetryCount = i16;
        this.eventHandler = handler;
        this.eventListener = eventListener;
        this.postResponseHandler = new PostResponseHandler(looper);
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread("DrmRequestHandler");
        this.requestHandlerThread = baseHandlerThread;
        baseHandlerThread.start();
        this.postRequestHandler = new PostRequestHandler(this.requestHandlerThread.getLooper());
        if (bArr2 == null) {
            this.initData = bArr;
            this.mimeType = str;
        } else {
            this.initData = null;
            this.mimeType = null;
        }
    }

    private void doLicense(boolean z16) {
        int i3 = this.mode;
        if (i3 != 0 && i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3 && restoreKeys()) {
                    postKeyRequest(3, z16);
                    return;
                }
                return;
            }
            if (this.offlineLicenseKeySetId == null) {
                postKeyRequest(2, z16);
                return;
            } else {
                if (restoreKeys()) {
                    postKeyRequest(2, z16);
                    return;
                }
                return;
            }
        }
        if (this.offlineLicenseKeySetId == null) {
            postKeyRequest(1, z16);
            return;
        }
        if (this.state == 4 || restoreKeys()) {
            long licenseDurationRemainingSec = getLicenseDurationRemainingSec();
            if (this.mode == 0 && licenseDurationRemainingSec <= 60) {
                Log.d(TAG, "Offline license has expired or will expire soon. Remaining seconds: " + licenseDurationRemainingSec);
                postKeyRequest(2, z16);
                return;
            }
            if (licenseDurationRemainingSec <= 0) {
                onError(new KeysExpiredException());
                return;
            }
            this.state = 4;
            Handler handler = this.eventHandler;
            if (handler != null && this.eventListener != null) {
                handler.post(new Runnable() { // from class: com.google.android.exoplayer2.drm.DefaultDrmSession.1
                    @Override // java.lang.Runnable
                    public void run() {
                        DefaultDrmSession.this.eventListener.onDrmKeysRestored();
                    }
                });
            }
        }
    }

    private long getLicenseDurationRemainingSec() {
        if (!C.WIDEVINE_UUID.equals(this.uuid)) {
            return Long.MAX_VALUE;
        }
        Pair<Long, Long> licenseDurationRemainingSec = WidevineUtil.getLicenseDurationRemainingSec(this);
        return Math.min(((Long) licenseDurationRemainingSec.first).longValue(), ((Long) licenseDurationRemainingSec.second).longValue());
    }

    private boolean isOpen() {
        int i3 = this.state;
        if (i3 != 3 && i3 != 4) {
            return false;
        }
        return true;
    }

    private void onError(final Exception exc) {
        this.lastException = new DrmSession.DrmSessionException(exc);
        Handler handler = this.eventHandler;
        if (handler != null && this.eventListener != null) {
            handler.post(new Runnable() { // from class: com.google.android.exoplayer2.drm.DefaultDrmSession.4
                @Override // java.lang.Runnable
                public void run() {
                    DefaultDrmSession.this.eventListener.onDrmSessionManagerError(exc);
                }
            });
        }
        if (this.state != 4) {
            this.state = 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onKeyResponse(Object obj) {
        if (!isOpen()) {
            return;
        }
        if (obj instanceof Exception) {
            onKeysError((Exception) obj);
            return;
        }
        try {
            byte[] bArr = (byte[]) obj;
            if (C.CLEARKEY_UUID.equals(this.uuid)) {
                bArr = ClearKeyUtil.adjustResponseData(bArr);
            }
            if (this.mode == 3) {
                this.mediaDrm.provideKeyResponse(this.offlineLicenseKeySetId, bArr);
                Handler handler = this.eventHandler;
                if (handler != null && this.eventListener != null) {
                    handler.post(new Runnable() { // from class: com.google.android.exoplayer2.drm.DefaultDrmSession.2
                        @Override // java.lang.Runnable
                        public void run() {
                            DefaultDrmSession.this.eventListener.onDrmKeysRemoved();
                        }
                    });
                    return;
                }
                return;
            }
            byte[] provideKeyResponse = this.mediaDrm.provideKeyResponse(this.sessionId, bArr);
            int i3 = this.mode;
            if ((i3 == 2 || (i3 == 0 && this.offlineLicenseKeySetId != null)) && provideKeyResponse != null && provideKeyResponse.length != 0) {
                this.offlineLicenseKeySetId = provideKeyResponse;
            }
            this.state = 4;
            Handler handler2 = this.eventHandler;
            if (handler2 != null && this.eventListener != null) {
                handler2.post(new Runnable() { // from class: com.google.android.exoplayer2.drm.DefaultDrmSession.3
                    @Override // java.lang.Runnable
                    public void run() {
                        DefaultDrmSession.this.eventListener.onDrmKeysLoaded();
                    }
                });
            }
        } catch (Exception e16) {
            onKeysError(e16);
        }
    }

    private void onKeysError(Exception exc) {
        if (exc instanceof NotProvisionedException) {
            this.provisioningManager.provisionRequired(this);
        } else {
            onError(exc);
        }
    }

    private void onKeysExpired() {
        if (this.state == 4) {
            this.state = 3;
            onError(new KeysExpiredException());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onProvisionResponse(Object obj) {
        if (this.state != 2 && !isOpen()) {
            return;
        }
        if (obj instanceof Exception) {
            this.provisioningManager.onProvisionError((Exception) obj);
            return;
        }
        try {
            this.mediaDrm.provideProvisionResponse((byte[]) obj);
            this.provisioningManager.onProvisionCompleted();
        } catch (Exception e16) {
            this.provisioningManager.onProvisionError(e16);
        }
    }

    private boolean openInternal(boolean z16) {
        if (isOpen()) {
            return true;
        }
        try {
            byte[] openSession = this.mediaDrm.openSession();
            this.sessionId = openSession;
            this.mediaCrypto = this.mediaDrm.createMediaCrypto(openSession);
            this.state = 3;
            return true;
        } catch (NotProvisionedException e16) {
            if (z16) {
                this.provisioningManager.provisionRequired(this);
                return false;
            }
            onError(e16);
            return false;
        } catch (Exception e17) {
            onError(e17);
            return false;
        }
    }

    private void postKeyRequest(int i3, boolean z16) {
        byte[] bArr;
        if (i3 == 3) {
            bArr = this.offlineLicenseKeySetId;
        } else {
            bArr = this.sessionId;
        }
        try {
            ExoMediaDrm.KeyRequest keyRequest = this.mediaDrm.getKeyRequest(bArr, this.initData, this.mimeType, i3, this.optionalKeyRequestParameters);
            if (C.CLEARKEY_UUID.equals(this.uuid)) {
                keyRequest = new ExoMediaDrm.DefaultKeyRequest(ClearKeyUtil.adjustRequestData(keyRequest.getData()), keyRequest.getDefaultUrl());
            }
            this.postRequestHandler.obtainMessage(1, keyRequest, z16).sendToTarget();
        } catch (Exception e16) {
            onKeysError(e16);
        }
    }

    private boolean restoreKeys() {
        try {
            this.mediaDrm.restoreKeys(this.sessionId, this.offlineLicenseKeySetId);
            return true;
        } catch (Exception e16) {
            Log.e(TAG, "Error trying to restore Widevine keys.", e16);
            onError(e16);
            return false;
        }
    }

    public void acquire() {
        int i3 = this.openCount + 1;
        this.openCount = i3;
        if (i3 == 1 && this.state != 1 && openInternal(true)) {
            doLicense(true);
        }
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public final DrmSession.DrmSessionException getError() {
        if (this.state == 1) {
            return this.lastException;
        }
        return null;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public final T getMediaCrypto() {
        return this.mediaCrypto;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public byte[] getOfflineLicenseKeySetId() {
        return this.offlineLicenseKeySetId;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public final int getState() {
        return this.state;
    }

    public boolean hasInitData(byte[] bArr) {
        return Arrays.equals(this.initData, bArr);
    }

    public boolean hasSessionId(byte[] bArr) {
        return Arrays.equals(this.sessionId, bArr);
    }

    public void onMediaDrmEvent(int i3) {
        if (!isOpen()) {
            return;
        }
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3) {
                    onKeysExpired();
                    return;
                }
                return;
            }
            doLicense(false);
            return;
        }
        this.state = 3;
        this.provisioningManager.provisionRequired(this);
    }

    public void onProvisionCompleted() {
        if (openInternal(false)) {
            doLicense(true);
        }
    }

    public void onProvisionError(Exception exc) {
        onError(exc);
    }

    public void provision() {
        this.postRequestHandler.obtainMessage(0, (Object) this.mediaDrm.getProvisionRequest(), true).sendToTarget();
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public Map<String, String> queryKeyStatus() {
        byte[] bArr = this.sessionId;
        if (bArr == null) {
            return null;
        }
        return this.mediaDrm.queryKeyStatus(bArr);
    }

    public boolean release() {
        int i3 = this.openCount - 1;
        this.openCount = i3;
        if (i3 != 0) {
            return false;
        }
        this.state = 0;
        this.postResponseHandler.removeCallbacksAndMessages(null);
        this.postRequestHandler.removeCallbacksAndMessages(null);
        this.postRequestHandler = null;
        this.requestHandlerThread.quit();
        this.requestHandlerThread = null;
        this.mediaCrypto = null;
        this.lastException = null;
        byte[] bArr = this.sessionId;
        if (bArr != null) {
            this.mediaDrm.closeSession(bArr);
            this.sessionId = null;
        }
        return true;
    }
}
