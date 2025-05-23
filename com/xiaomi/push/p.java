package com.xiaomi.push;

import android.content.Context;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes28.dex */
public class p {

    /* renamed from: a, reason: collision with root package name */
    static int f389471a;

    public static j a(Context context) {
        if (hz.i()) {
            f389471a = 1;
            return new m(context);
        }
        if (ah.g(context)) {
            f389471a = 2;
            return new ah(context);
        }
        if (ao.j(context)) {
            f389471a = 4;
            return new ao(context);
        }
        if (s.c(context)) {
            f389471a = 5;
            return new s(context);
        }
        if (l.b(context)) {
            f389471a = 3;
            return new k(context);
        }
        f389471a = 0;
        return new r();
    }
}
