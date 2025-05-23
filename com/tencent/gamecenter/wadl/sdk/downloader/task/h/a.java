package com.tencent.gamecenter.wadl.sdk.downloader.task.h;

import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private volatile long f107544a = 0;

    /* renamed from: b, reason: collision with root package name */
    private volatile LinkedList<C1134a> f107545b = new LinkedList<>();

    /* renamed from: c, reason: collision with root package name */
    private Object f107546c = new Object();

    /* compiled from: P */
    /* renamed from: com.tencent.gamecenter.wadl.sdk.downloader.task.h.a$a, reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C1134a {

        /* renamed from: a, reason: collision with root package name */
        public int f107547a;

        /* renamed from: b, reason: collision with root package name */
        public long f107548b;

        /* renamed from: c, reason: collision with root package name */
        public byte[] f107549c;

        /* renamed from: d, reason: collision with root package name */
        public long f107550d;

        public C1134a(int i3, long j3, byte[] bArr, long j16) {
            this.f107547a = i3;
            this.f107548b = j3;
            this.f107549c = bArr;
            this.f107550d = j16;
        }
    }

    public void a() {
        synchronized (this.f107546c) {
            do {
            } while (c() != null);
        }
    }

    public long b() {
        return this.f107544a;
    }

    public C1134a c() {
        synchronized (this.f107546c) {
            if (this.f107545b.size() > 0) {
                C1134a removeFirst = this.f107545b.removeFirst();
                this.f107544a -= removeFirst.f107550d;
                return removeFirst;
            }
            return null;
        }
    }

    public static C1134a b(int i3, long j3, byte[] bArr, long j16) {
        int i16 = (int) j16;
        byte[] bArr2 = new byte[i16];
        System.arraycopy(bArr, 0, bArr2, 0, i16);
        return new C1134a(i3, j3, bArr2, j16);
    }

    public void a(int i3, long j3, byte[] bArr, long j16) {
        synchronized (this.f107546c) {
            this.f107545b.addLast(b(i3, j3, bArr, j16));
            this.f107544a += j16;
        }
    }
}
