package com.tencent.liteav.sdkcommon;

import android.widget.ScrollView;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes7.dex */
public final /* synthetic */ class h implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final g f119139a;

    h(g gVar) {
        this.f119139a = gVar;
    }

    public static Runnable a(g gVar) {
        return new h(gVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        ScrollView scrollView = this.f119139a.f119128k;
        if (scrollView != null) {
            scrollView.fullScroll(130);
        }
    }
}
