package com.tencent.luggage.wxa.ar;

import android.content.Context;
import android.os.SystemClock;
import android.view.accessibility.AccessibilityManager;

/* compiled from: P */
/* loaded from: classes8.dex */
public class c {

    /* renamed from: c, reason: collision with root package name */
    public static AccessibilityManager f121618c;

    /* renamed from: d, reason: collision with root package name */
    public static c f121619d;

    /* renamed from: a, reason: collision with root package name */
    public boolean f121620a;

    /* renamed from: b, reason: collision with root package name */
    public long f121621b;

    public c(Context context) {
        f121618c = (AccessibilityManager) context.getApplicationContext().getSystemService("accessibility");
    }

    public static c a(Context context) {
        if (f121619d == null) {
            f121619d = new c(context);
        }
        return f121619d;
    }

    public boolean a(boolean z16) {
        AccessibilityManager accessibilityManager;
        if ((!z16 || SystemClock.uptimeMillis() - this.f121621b > 2000) && (accessibilityManager = f121618c) != null) {
            this.f121620a = accessibilityManager.isEnabled() && f121618c.isTouchExplorationEnabled();
            this.f121621b = SystemClock.uptimeMillis();
        }
        return this.f121620a;
    }

    public boolean a() {
        return a(true);
    }
}
