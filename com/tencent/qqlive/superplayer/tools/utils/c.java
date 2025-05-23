package com.tencent.qqlive.superplayer.tools.utils;

/* compiled from: P */
/* loaded from: classes22.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static ITVKHttpProcessor f345486a;

    c() {
    }

    public static ITVKHttpProcessor a() {
        if (f345486a == null) {
            synchronized (c.class) {
                if (f345486a == null) {
                    f345486a = b.e();
                }
            }
        }
        return f345486a;
    }
}
