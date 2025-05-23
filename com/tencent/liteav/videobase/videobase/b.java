package com.tencent.liteav.videobase.videobase;

import android.view.View;

/* compiled from: P */
/* loaded from: classes7.dex */
final /* synthetic */ class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final View f119412a;

    b(View view) {
        this.f119412a = view;
    }

    public static Runnable a(View view) {
        return new b(view);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f119412a.requestLayout();
    }
}
