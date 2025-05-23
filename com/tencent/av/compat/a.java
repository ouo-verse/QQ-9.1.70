package com.tencent.av.compat;

import android.app.Activity;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.r;

/* compiled from: P */
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private Runnable f73553a = null;

    public void a(VideoAppInterface videoAppInterface) {
        if (videoAppInterface != null && r.h0() != null) {
            AVCallCompactHelper A = r.h0().A();
            Runnable runnable = this.f73553a;
            if (runnable != null && A != null) {
                A.d(runnable, videoAppInterface);
                this.f73553a = null;
            }
        }
    }

    public void b(Activity activity, VideoAppInterface videoAppInterface) {
        AVCallCompactHelper A;
        if (activity != null && videoAppInterface != null && r.h0() != null && (A = r.h0().A()) != null) {
            this.f73553a = A.f(activity, videoAppInterface);
        }
    }
}
