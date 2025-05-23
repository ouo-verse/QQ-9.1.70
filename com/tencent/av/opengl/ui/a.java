package com.tencent.av.opengl.ui;

import android.os.SystemClock;

/* compiled from: P */
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static volatile long f74117a;

    public static long a() {
        return f74117a;
    }

    public static void b() {
        f74117a = SystemClock.uptimeMillis();
    }
}
