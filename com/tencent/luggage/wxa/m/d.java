package com.tencent.luggage.wxa.m;

import java.io.IOException;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class d extends Exception {

    /* renamed from: a, reason: collision with root package name */
    public final int f133817a;

    /* renamed from: b, reason: collision with root package name */
    public final int f133818b;

    public d(int i3, String str, Throwable th5, int i16) {
        super(str, th5);
        this.f133817a = i3;
        this.f133818b = i16;
    }

    public static d a(Exception exc, int i3) {
        return new d(1, null, exc, i3);
    }

    public static d a(IOException iOException) {
        return new d(0, null, iOException, -1);
    }

    public static d a(RuntimeException runtimeException) {
        return new d(2, null, runtimeException, -1);
    }
}
