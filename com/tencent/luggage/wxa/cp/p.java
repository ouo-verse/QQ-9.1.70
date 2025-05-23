package com.tencent.luggage.wxa.cp;

import android.util.Pair;

/* compiled from: P */
/* loaded from: classes8.dex */
public interface p {

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final String f123817a;

        /* renamed from: b, reason: collision with root package name */
        public final String f123818b;

        public a(String str, String str2) {
            this.f123817a = str;
            this.f123818b = str2;
        }

        public String toString() {
            return this.f123817a + " -> " + this.f123818b;
        }
    }

    Pair a(String str);
}
