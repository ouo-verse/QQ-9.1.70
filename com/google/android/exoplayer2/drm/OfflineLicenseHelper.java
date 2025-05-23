package com.google.android.exoplayer2.drm;

import android.os.ConditionVariable;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Pair;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.drm.DefaultDrmSessionManager;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.drm.ExoMediaCrypto;
import com.google.android.exoplayer2.upstream.HttpDataSource;
import com.google.android.exoplayer2.util.Assertions;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import java.util.HashMap;
import java.util.UUID;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class OfflineLicenseHelper<T extends ExoMediaCrypto> {
    private final ConditionVariable conditionVariable;
    private final DefaultDrmSessionManager<T> drmSessionManager;
    private final HandlerThread handlerThread;

    public OfflineLicenseHelper(UUID uuid, ExoMediaDrm<T> exoMediaDrm, MediaDrmCallback mediaDrmCallback, HashMap<String, String> hashMap) {
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread("OfflineLicenseHelper");
        this.handlerThread = baseHandlerThread;
        baseHandlerThread.start();
        this.conditionVariable = new ConditionVariable();
        this.drmSessionManager = new DefaultDrmSessionManager<>(uuid, exoMediaDrm, mediaDrmCallback, hashMap, new Handler(baseHandlerThread.getLooper()), new DefaultDrmSessionManager.EventListener() { // from class: com.google.android.exoplayer2.drm.OfflineLicenseHelper.1
            @Override // com.google.android.exoplayer2.drm.DefaultDrmSessionManager.EventListener
            public void onDrmKeysLoaded() {
                OfflineLicenseHelper.this.conditionVariable.open();
            }

            @Override // com.google.android.exoplayer2.drm.DefaultDrmSessionManager.EventListener
            public void onDrmKeysRemoved() {
                OfflineLicenseHelper.this.conditionVariable.open();
            }

            @Override // com.google.android.exoplayer2.drm.DefaultDrmSessionManager.EventListener
            public void onDrmKeysRestored() {
                OfflineLicenseHelper.this.conditionVariable.open();
            }

            @Override // com.google.android.exoplayer2.drm.DefaultDrmSessionManager.EventListener
            public void onDrmSessionManagerError(Exception exc) {
                OfflineLicenseHelper.this.conditionVariable.open();
            }
        });
    }

    private byte[] blockingKeyRequest(int i3, byte[] bArr, DrmInitData drmInitData) throws DrmSession.DrmSessionException {
        DrmSession<T> openBlockingKeyRequest = openBlockingKeyRequest(i3, bArr, drmInitData);
        DrmSession.DrmSessionException error = openBlockingKeyRequest.getError();
        byte[] offlineLicenseKeySetId = openBlockingKeyRequest.getOfflineLicenseKeySetId();
        this.drmSessionManager.releaseSession(openBlockingKeyRequest);
        if (error == null) {
            return offlineLicenseKeySetId;
        }
        throw error;
    }

    public static OfflineLicenseHelper<FrameworkMediaCrypto> newWidevineInstance(String str, HttpDataSource.Factory factory) throws UnsupportedDrmException {
        return newWidevineInstance(str, false, factory, null);
    }

    private DrmSession<T> openBlockingKeyRequest(int i3, byte[] bArr, DrmInitData drmInitData) {
        this.drmSessionManager.setMode(i3, bArr);
        this.conditionVariable.close();
        DrmSession<T> acquireSession = this.drmSessionManager.acquireSession(this.handlerThread.getLooper(), drmInitData);
        this.conditionVariable.block();
        return acquireSession;
    }

    public synchronized byte[] downloadLicense(DrmInitData drmInitData) throws DrmSession.DrmSessionException {
        boolean z16;
        if (drmInitData != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        Assertions.checkArgument(z16);
        return blockingKeyRequest(2, null, drmInitData);
    }

    public synchronized Pair<Long, Long> getLicenseDurationRemainingSec(byte[] bArr) throws DrmSession.DrmSessionException {
        Assertions.checkNotNull(bArr);
        DrmSession<T> openBlockingKeyRequest = openBlockingKeyRequest(1, bArr, null);
        DrmSession.DrmSessionException error = openBlockingKeyRequest.getError();
        Pair<Long, Long> licenseDurationRemainingSec = WidevineUtil.getLicenseDurationRemainingSec(openBlockingKeyRequest);
        this.drmSessionManager.releaseSession(openBlockingKeyRequest);
        if (error != null) {
            if (error.getCause() instanceof KeysExpiredException) {
                return Pair.create(0L, 0L);
            }
            throw error;
        }
        return licenseDurationRemainingSec;
    }

    public synchronized byte[] getPropertyByteArray(String str) {
        return this.drmSessionManager.getPropertyByteArray(str);
    }

    public synchronized String getPropertyString(String str) {
        return this.drmSessionManager.getPropertyString(str);
    }

    public void release() {
        this.handlerThread.quit();
    }

    public synchronized void releaseLicense(byte[] bArr) throws DrmSession.DrmSessionException {
        Assertions.checkNotNull(bArr);
        blockingKeyRequest(3, bArr, null);
    }

    public synchronized byte[] renewLicense(byte[] bArr) throws DrmSession.DrmSessionException {
        Assertions.checkNotNull(bArr);
        return blockingKeyRequest(2, bArr, null);
    }

    public synchronized void setPropertyByteArray(String str, byte[] bArr) {
        this.drmSessionManager.setPropertyByteArray(str, bArr);
    }

    public synchronized void setPropertyString(String str, String str2) {
        this.drmSessionManager.setPropertyString(str, str2);
    }

    public static OfflineLicenseHelper<FrameworkMediaCrypto> newWidevineInstance(String str, boolean z16, HttpDataSource.Factory factory) throws UnsupportedDrmException {
        return newWidevineInstance(str, z16, factory, null);
    }

    public static OfflineLicenseHelper<FrameworkMediaCrypto> newWidevineInstance(String str, boolean z16, HttpDataSource.Factory factory, HashMap<String, String> hashMap) throws UnsupportedDrmException {
        UUID uuid = C.WIDEVINE_UUID;
        return new OfflineLicenseHelper<>(uuid, FrameworkMediaDrm.newInstance(uuid), new HttpMediaDrmCallback(str, z16, factory), hashMap);
    }
}
