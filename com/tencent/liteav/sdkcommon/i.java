package com.tencent.liteav.sdkcommon;

import android.widget.ScrollView;

/* compiled from: P */
/* loaded from: classes7.dex */
final /* synthetic */ class i implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final g f119140a;

    i(g gVar) {
        this.f119140a = gVar;
    }

    public static Runnable a(g gVar) {
        return new i(gVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        ScrollView scrollView = this.f119140a.f119128k;
        if (scrollView != null) {
            scrollView.fullScroll(130);
        }
    }
}
