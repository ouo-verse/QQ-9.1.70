package com.google.android.exoplayer2.drm;

import android.annotation.TargetApi;
import android.media.DeniedByServerException;
import android.media.MediaCryptoException;
import android.media.MediaDrmException;
import android.media.NotProvisionedException;
import com.google.android.exoplayer2.drm.ExoMediaCrypto;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
@TargetApi(18)
/* loaded from: classes2.dex */
public interface ExoMediaDrm<T extends ExoMediaCrypto> {
    public static final int EVENT_KEY_EXPIRED = 3;
    public static final int EVENT_KEY_REQUIRED = 2;
    public static final int EVENT_PROVISION_REQUIRED = 1;
    public static final int KEY_TYPE_OFFLINE = 2;
    public static final int KEY_TYPE_RELEASE = 3;
    public static final int KEY_TYPE_STREAMING = 1;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class DefaultKeyRequest implements KeyRequest {
        private final byte[] data;
        private final String defaultUrl;

        public DefaultKeyRequest(byte[] bArr, String str) {
            this.data = bArr;
            this.defaultUrl = str;
        }

        @Override // com.google.android.exoplayer2.drm.ExoMediaDrm.KeyRequest
        public byte[] getData() {
            return this.data;
        }

        @Override // com.google.android.exoplayer2.drm.ExoMediaDrm.KeyRequest
        public String getDefaultUrl() {
            return this.defaultUrl;
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class DefaultKeyStatus implements KeyStatus {
        private final byte[] keyId;
        private final int statusCode;

        /* JADX INFO: Access modifiers changed from: package-private */
        public DefaultKeyStatus(int i3, byte[] bArr) {
            this.statusCode = i3;
            this.keyId = bArr;
        }

        @Override // com.google.android.exoplayer2.drm.ExoMediaDrm.KeyStatus
        public byte[] getKeyId() {
            return this.keyId;
        }

        @Override // com.google.android.exoplayer2.drm.ExoMediaDrm.KeyStatus
        public int getStatusCode() {
            return this.statusCode;
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class DefaultProvisionRequest implements ProvisionRequest {
        private final byte[] data;
        private final String defaultUrl;

        public DefaultProvisionRequest(byte[] bArr, String str) {
            this.data = bArr;
            this.defaultUrl = str;
        }

        @Override // com.google.android.exoplayer2.drm.ExoMediaDrm.ProvisionRequest
        public byte[] getData() {
            return this.data;
        }

        @Override // com.google.android.exoplayer2.drm.ExoMediaDrm.ProvisionRequest
        public String getDefaultUrl() {
            return this.defaultUrl;
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public interface KeyRequest {
        byte[] getData();

        String getDefaultUrl();
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public interface KeyStatus {
        byte[] getKeyId();

        int getStatusCode();
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public interface OnEventListener<T extends ExoMediaCrypto> {
        void onEvent(ExoMediaDrm<? extends T> exoMediaDrm, byte[] bArr, int i3, int i16, byte[] bArr2);
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public interface OnKeyStatusChangeListener<T extends ExoMediaCrypto> {
        void onKeyStatusChange(ExoMediaDrm<? extends T> exoMediaDrm, byte[] bArr, List<KeyStatus> list, boolean z16);
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public interface ProvisionRequest {
        byte[] getData();

        String getDefaultUrl();
    }

    void closeSession(byte[] bArr);

    T createMediaCrypto(byte[] bArr) throws MediaCryptoException;

    KeyRequest getKeyRequest(byte[] bArr, byte[] bArr2, String str, int i3, HashMap<String, String> hashMap) throws NotProvisionedException;

    byte[] getPropertyByteArray(String str);

    String getPropertyString(String str);

    ProvisionRequest getProvisionRequest();

    byte[] openSession() throws MediaDrmException;

    byte[] provideKeyResponse(byte[] bArr, byte[] bArr2) throws NotProvisionedException, DeniedByServerException;

    void provideProvisionResponse(byte[] bArr) throws DeniedByServerException;

    Map<String, String> queryKeyStatus(byte[] bArr);

    void release();

    void restoreKeys(byte[] bArr, byte[] bArr2);

    void setOnEventListener(OnEventListener<? super T> onEventListener);

    void setOnKeyStatusChangeListener(OnKeyStatusChangeListener<? super T> onKeyStatusChangeListener);

    void setPropertyByteArray(String str, byte[] bArr);

    void setPropertyString(String str, String str2);
}
