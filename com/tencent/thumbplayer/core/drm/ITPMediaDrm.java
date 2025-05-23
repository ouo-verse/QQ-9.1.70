package com.tencent.thumbplayer.core.drm;

import android.media.DeniedByServerException;
import android.media.MediaDrm;
import android.media.NotProvisionedException;
import android.media.ResourceBusyException;
import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes26.dex */
public interface ITPMediaDrm {

    /* loaded from: classes26.dex */
    public interface OnEventListener {
        void onEvent(@NonNull ITPMediaDrm iTPMediaDrm, @Nullable byte[] bArr, int i3, int i16, @Nullable byte[] bArr2);
    }

    /* loaded from: classes26.dex */
    public interface OnExpirationUpdateListener {
        void onExpirationUpdate(@NonNull ITPMediaDrm iTPMediaDrm, @NonNull byte[] bArr, long j3);
    }

    /* loaded from: classes26.dex */
    public interface OnKeyStatusChangeListener {
        void onKeyStatusChange(@NonNull ITPMediaDrm iTPMediaDrm, @NonNull byte[] bArr, @NonNull List<MediaDrm.KeyStatus> list, boolean z16);
    }

    void close();

    void closeSession(@NonNull byte[] bArr);

    @NonNull
    MediaDrm.KeyRequest getKeyRequest(@NonNull byte[] bArr, @Nullable byte[] bArr2, @Nullable String str, int i3, @Nullable HashMap<String, String> hashMap) throws NotProvisionedException, TPMediaDrmFatalException;

    @NonNull
    String getPropertyString(@NonNull String str);

    MediaDrm.ProvisionRequest getProvisionRequest() throws TPMediaDrmFatalException;

    @NonNull
    byte[] openSession() throws NotProvisionedException, ResourceBusyException, TPMediaDrmFatalException;

    @Nullable
    byte[] provideKeyResponse(@NonNull byte[] bArr, @NonNull byte[] bArr2) throws NotProvisionedException, DeniedByServerException, TPMediaDrmFatalException;

    void provideProvisionResponse(@NonNull byte[] bArr) throws DeniedByServerException;

    @NonNull
    HashMap<String, String> queryKeyStatus(@NonNull byte[] bArr);

    void removeKeys(@NonNull byte[] bArr);

    void restoreKeys(@NonNull byte[] bArr, @NonNull byte[] bArr2);

    @RequiresApi(api = 23)
    void setOnExpirationUpdateListener(@Nullable OnExpirationUpdateListener onExpirationUpdateListener, @Nullable Handler handler);

    @RequiresApi(api = 23)
    void setOnKeyStatusChangeListener(@Nullable OnKeyStatusChangeListener onKeyStatusChangeListener, @Nullable Handler handler);

    void setPropertyString(@NonNull String str, @NonNull String str2);
}
