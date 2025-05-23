package com.tencent.liteav.videobase.videobase;

import android.view.View;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes7.dex */
public final /* synthetic */ class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final View f119410a;

    /* renamed from: b, reason: collision with root package name */
    private final int f119411b;

    a(View view, int i3) {
        this.f119410a = view;
        this.f119411b = i3;
    }

    public static Runnable a(View view, int i3) {
        return new a(view, i3);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f119410a.setVisibility(this.f119411b);
    }
}
