package com.tencent.liteav.sdkcommon;

import android.widget.ScrollView;

/* compiled from: P */
/* loaded from: classes7.dex */
final /* synthetic */ class l implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final g f119144a;

    l(g gVar) {
        this.f119144a = gVar;
    }

    public static Runnable a(g gVar) {
        return new l(gVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        ScrollView scrollView = this.f119144a.f119128k;
        if (scrollView != null) {
            scrollView.fullScroll(130);
        }
    }
}
