package com.tencent.luggage.wxa.m0;

import java.io.File;
import java.io.IOException;
import java.util.NavigableSet;

/* compiled from: P */
/* loaded from: classes8.dex */
public interface a {

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.m0.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C6454a extends IOException {
        public C6454a(String str) {
            super(str);
        }

        public C6454a(IOException iOException) {
            super(iOException);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface b {
        void a(a aVar, g gVar);

        void a(a aVar, g gVar, g gVar2);

        void b(a aVar, g gVar);
    }

    long a();

    long a(String str);

    long a(String str, long j3, long j16);

    g a(String str, long j3);

    void a(g gVar);

    void a(File file);

    g b(String str, long j3);

    File b(String str, long j3, long j16);

    NavigableSet b(String str);

    void b(g gVar);

    void c(String str, long j3);
}
