package com.google.android.exoplayer2.drm;

import android.annotation.TargetApi;
import android.os.Looper;
import com.google.android.exoplayer2.drm.ExoMediaCrypto;

/* compiled from: P */
@TargetApi(16)
/* loaded from: classes2.dex */
public interface DrmSessionManager<T extends ExoMediaCrypto> {
    DrmSession<T> acquireSession(Looper looper, DrmInitData drmInitData);

    boolean canAcquireSession(DrmInitData drmInitData);

    void releaseSession(DrmSession<T> drmSession);
}
