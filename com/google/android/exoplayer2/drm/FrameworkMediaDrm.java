package com.google.android.exoplayer2.drm;

import android.annotation.TargetApi;
import android.media.DeniedByServerException;
import android.media.MediaCrypto;
import android.media.MediaCryptoException;
import android.media.MediaDrm;
import android.media.MediaDrmException;
import android.media.NotProvisionedException;
import android.media.UnsupportedSchemeException;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.drm.ExoMediaDrm;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/* compiled from: P */
@TargetApi(23)
/* loaded from: classes2.dex */
public final class FrameworkMediaDrm implements ExoMediaDrm<FrameworkMediaCrypto> {
    private final MediaDrm mediaDrm;
    private final UUID uuid;

    FrameworkMediaDrm(UUID uuid) throws UnsupportedSchemeException {
        Assertions.checkNotNull(uuid);
        UUID uuid2 = C.COMMON_PSSH_UUID;
        Assertions.checkArgument(!uuid2.equals(uuid), "Use C.CLEARKEY_UUID instead");
        if (Util.SDK_INT < 27 && C.CLEARKEY_UUID.equals(uuid)) {
            uuid = uuid2;
        }
        this.uuid = uuid;
        this.mediaDrm = new MediaDrm(uuid);
    }

    public static FrameworkMediaDrm newInstance(UUID uuid) throws UnsupportedDrmException {
        try {
            return new FrameworkMediaDrm(uuid);
        } catch (UnsupportedSchemeException e16) {
            throw new UnsupportedDrmException(1, e16);
        } catch (Exception e17) {
            throw new UnsupportedDrmException(2, e17);
        }
    }

    @Override // com.google.android.exoplayer2.drm.ExoMediaDrm
    public void closeSession(byte[] bArr) {
        this.mediaDrm.closeSession(bArr);
    }

    @Override // com.google.android.exoplayer2.drm.ExoMediaDrm
    public ExoMediaDrm.KeyRequest getKeyRequest(byte[] bArr, byte[] bArr2, String str, int i3, HashMap<String, String> hashMap) throws NotProvisionedException {
        MediaDrm.KeyRequest keyRequest = this.mediaDrm.getKeyRequest(bArr, bArr2, str, i3, hashMap);
        return new ExoMediaDrm.DefaultKeyRequest(keyRequest.getData(), keyRequest.getDefaultUrl());
    }

    @Override // com.google.android.exoplayer2.drm.ExoMediaDrm
    public byte[] getPropertyByteArray(String str) {
        return this.mediaDrm.getPropertyByteArray(str);
    }

    @Override // com.google.android.exoplayer2.drm.ExoMediaDrm
    public String getPropertyString(String str) {
        return this.mediaDrm.getPropertyString(str);
    }

    @Override // com.google.android.exoplayer2.drm.ExoMediaDrm
    public ExoMediaDrm.ProvisionRequest getProvisionRequest() {
        MediaDrm.ProvisionRequest provisionRequest = this.mediaDrm.getProvisionRequest();
        return new ExoMediaDrm.DefaultProvisionRequest(provisionRequest.getData(), provisionRequest.getDefaultUrl());
    }

    @Override // com.google.android.exoplayer2.drm.ExoMediaDrm
    public byte[] openSession() throws MediaDrmException {
        return this.mediaDrm.openSession();
    }

    @Override // com.google.android.exoplayer2.drm.ExoMediaDrm
    public byte[] provideKeyResponse(byte[] bArr, byte[] bArr2) throws NotProvisionedException, DeniedByServerException {
        return this.mediaDrm.provideKeyResponse(bArr, bArr2);
    }

    @Override // com.google.android.exoplayer2.drm.ExoMediaDrm
    public void provideProvisionResponse(byte[] bArr) throws DeniedByServerException {
        this.mediaDrm.provideProvisionResponse(bArr);
    }

    @Override // com.google.android.exoplayer2.drm.ExoMediaDrm
    public Map<String, String> queryKeyStatus(byte[] bArr) {
        return this.mediaDrm.queryKeyStatus(bArr);
    }

    @Override // com.google.android.exoplayer2.drm.ExoMediaDrm
    public void release() {
        this.mediaDrm.release();
    }

    @Override // com.google.android.exoplayer2.drm.ExoMediaDrm
    public void restoreKeys(byte[] bArr, byte[] bArr2) {
        this.mediaDrm.restoreKeys(bArr, bArr2);
    }

    @Override // com.google.android.exoplayer2.drm.ExoMediaDrm
    public void setOnEventListener(final ExoMediaDrm.OnEventListener<? super FrameworkMediaCrypto> onEventListener) {
        MediaDrm.OnEventListener onEventListener2;
        MediaDrm mediaDrm = this.mediaDrm;
        if (onEventListener == null) {
            onEventListener2 = null;
        } else {
            onEventListener2 = new MediaDrm.OnEventListener() { // from class: com.google.android.exoplayer2.drm.FrameworkMediaDrm.1
                @Override // android.media.MediaDrm.OnEventListener
                public void onEvent(@NonNull MediaDrm mediaDrm2, @Nullable byte[] bArr, int i3, int i16, byte[] bArr2) {
                    onEventListener.onEvent(FrameworkMediaDrm.this, bArr, i3, i16, bArr2);
                }
            };
        }
        mediaDrm.setOnEventListener(onEventListener2);
    }

    @Override // com.google.android.exoplayer2.drm.ExoMediaDrm
    public void setOnKeyStatusChangeListener(final ExoMediaDrm.OnKeyStatusChangeListener<? super FrameworkMediaCrypto> onKeyStatusChangeListener) {
        MediaDrm.OnKeyStatusChangeListener onKeyStatusChangeListener2;
        if (Util.SDK_INT >= 23) {
            MediaDrm mediaDrm = this.mediaDrm;
            if (onKeyStatusChangeListener == null) {
                onKeyStatusChangeListener2 = null;
            } else {
                onKeyStatusChangeListener2 = new MediaDrm.OnKeyStatusChangeListener() { // from class: com.google.android.exoplayer2.drm.FrameworkMediaDrm.2
                    @Override // android.media.MediaDrm.OnKeyStatusChangeListener
                    public void onKeyStatusChange(@NonNull MediaDrm mediaDrm2, @NonNull byte[] bArr, @NonNull List<MediaDrm.KeyStatus> list, boolean z16) {
                        ArrayList arrayList = new ArrayList();
                        for (MediaDrm.KeyStatus keyStatus : list) {
                            arrayList.add(new ExoMediaDrm.DefaultKeyStatus(keyStatus.getStatusCode(), keyStatus.getKeyId()));
                        }
                        onKeyStatusChangeListener.onKeyStatusChange(FrameworkMediaDrm.this, bArr, arrayList, z16);
                    }
                };
            }
            mediaDrm.setOnKeyStatusChangeListener(onKeyStatusChangeListener2, (Handler) null);
            return;
        }
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.exoplayer2.drm.ExoMediaDrm
    public void setPropertyByteArray(String str, byte[] bArr) {
        this.mediaDrm.setPropertyByteArray(str, bArr);
    }

    @Override // com.google.android.exoplayer2.drm.ExoMediaDrm
    public void setPropertyString(String str, String str2) {
        this.mediaDrm.setPropertyString(str, str2);
    }

    @Override // com.google.android.exoplayer2.drm.ExoMediaDrm
    public FrameworkMediaCrypto createMediaCrypto(byte[] bArr) throws MediaCryptoException {
        return new FrameworkMediaCrypto(new MediaCrypto(this.uuid, bArr), Util.SDK_INT < 21 && C.WIDEVINE_UUID.equals(this.uuid) && "L3".equals(getPropertyString("securityLevel")));
    }
}
