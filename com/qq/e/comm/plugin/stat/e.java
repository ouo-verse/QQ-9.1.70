package com.qq.e.comm.plugin.stat;

/* compiled from: P */
@Deprecated
/* loaded from: classes3.dex */
public class e {

    /* compiled from: P */
    /* loaded from: classes3.dex */
    private static class b extends a implements n {
        public b(int i3, String str) {
            super(i3, str);
        }

        @Override // com.qq.e.comm.plugin.stat.e.a, com.qq.e.comm.plugin.stat.m
        public int b() {
            return 0;
        }
    }

    public static i a(int i3, String str) {
        return new a(i3, str);
    }

    public static n b(int i3, String str) {
        return new b(i3, str);
    }

    public static i a(long j3, String str, int i3) {
        return new a(j3, str, i3);
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    private static class a implements i {

        /* renamed from: a, reason: collision with root package name */
        private int f39705a;

        /* renamed from: b, reason: collision with root package name */
        private int f39706b;

        /* renamed from: c, reason: collision with root package name */
        private long f39707c;

        /* renamed from: d, reason: collision with root package name */
        private String f39708d;

        public a(int i3, String str) {
            this.f39705a = i3;
            this.f39708d = str;
            this.f39707c = -1L;
        }

        @Override // com.qq.e.comm.plugin.stat.m
        public int a() {
            return this.f39705a;
        }

        @Override // com.qq.e.comm.plugin.stat.m
        public int b() {
            return this.f39706b;
        }

        @Override // com.qq.e.comm.plugin.stat.m
        public String c() {
            return this.f39708d;
        }

        @Override // com.qq.e.comm.plugin.stat.m
        public long d() {
            return this.f39707c;
        }

        public String toString() {
            return getClass().getSimpleName() + "{id=" + this.f39705a + ", time=" + this.f39707c + ", content='" + this.f39708d + "'}";
        }

        public a(long j3, String str, int i3) {
            this.f39705a = -1;
            this.f39707c = j3;
            this.f39708d = str;
            this.f39706b = i3;
        }
    }
}
