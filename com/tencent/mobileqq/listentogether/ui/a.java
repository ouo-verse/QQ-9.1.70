package com.tencent.mobileqq.listentogether.ui;

/* compiled from: P */
/* loaded from: classes33.dex */
public class a extends com.tencent.mobileqq.theme.ListenTogetherTheme.a {

    /* renamed from: h, reason: collision with root package name */
    private static a f241163h;

    /* renamed from: g, reason: collision with root package name */
    private boolean f241164g = false;

    public static a k() {
        if (f241163h == null) {
            synchronized (a.class) {
                if (f241163h == null) {
                    f241163h = new a();
                }
            }
        }
        return f241163h;
    }

    public boolean l() {
        return this.f241164g;
    }

    public void m(boolean z16) {
        this.f241164g = z16;
    }
}
