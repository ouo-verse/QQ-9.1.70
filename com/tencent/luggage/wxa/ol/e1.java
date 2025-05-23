package com.tencent.luggage.wxa.ol;

import android.view.View;
import android.view.ViewTreeObserver;

/* compiled from: P */
/* loaded from: classes8.dex */
public class e1 implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: a, reason: collision with root package name */
    public final View f136712a;

    /* renamed from: b, reason: collision with root package name */
    public final a f136713b;

    /* renamed from: c, reason: collision with root package name */
    public int f136714c;

    /* renamed from: d, reason: collision with root package name */
    public int f136715d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f136716e;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface a {
        void a(View view);
    }

    public e1(View view, a aVar) {
        this.f136712a = view;
        this.f136713b = aVar;
    }

    public static void a(View view, a aVar) {
        new e1(view, aVar).a();
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        if (!this.f136716e) {
            this.f136716e = true;
            this.f136714c = this.f136712a.getWidth();
            this.f136715d = this.f136712a.getHeight();
        } else if (this.f136712a.getWidth() != this.f136714c || this.f136712a.getHeight() != this.f136715d) {
            this.f136713b.a(this.f136712a);
            this.f136714c = this.f136712a.getWidth();
            this.f136715d = this.f136712a.getHeight();
        }
    }

    public final void a() {
        this.f136712a.getViewTreeObserver().addOnGlobalLayoutListener(this);
    }
}
