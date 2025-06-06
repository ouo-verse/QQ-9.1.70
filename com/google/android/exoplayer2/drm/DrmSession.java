package com.google.android.exoplayer2.drm;

import android.annotation.TargetApi;
import com.google.android.exoplayer2.drm.ExoMediaCrypto;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Map;

/* compiled from: P */
@TargetApi(16)
/* loaded from: classes2.dex */
public interface DrmSession<T extends ExoMediaCrypto> {
    public static final int STATE_ERROR = 1;
    public static final int STATE_OPENED = 3;
    public static final int STATE_OPENED_WITH_KEYS = 4;
    public static final int STATE_OPENING = 2;
    public static final int STATE_RELEASED = 0;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class DrmSessionException extends Exception {
        public DrmSessionException(Throwable th5) {
            super(th5);
        }
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes2.dex */
    public @interface State {
    }

    DrmSessionException getError();

    T getMediaCrypto();

    byte[] getOfflineLicenseKeySetId();

    int getState();

    Map<String, String> queryKeyStatus();
}
