package com.tencent.luggage.wxa.tn;

import com.tencent.luggage.wxa.gq.h;
import com.tencent.luggage.wxa.lq.a;
import com.tencent.luggage.wxa.zp.a;
import com.tencent.luggage.wxa.zp.d;
import com.tencent.luggage.wxa.zp.g;
import com.tencent.qqnt.kernel.nativeinterface.JsonGrayBusiId;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* compiled from: P */
/* loaded from: classes8.dex */
public class u0 implements g.c {

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements d.b {
        public a() {
        }

        @Override // com.tencent.luggage.wxa.zp.d.b
        public void e(String str, String str2, Object... objArr) {
            w.b(str, String.format(str2, objArr));
        }

        @Override // com.tencent.luggage.wxa.zp.d.b
        public void i(String str, String str2, Object... objArr) {
            w.d(str, String.format(str2, objArr));
        }

        @Override // com.tencent.luggage.wxa.zp.d.b
        public void w(String str, String str2, Object... objArr) {
            w.f(str, String.format(str2, objArr));
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements d.g {
        public b() {
        }

        @Override // com.tencent.luggage.wxa.zp.d.g
        public void a(Thread thread, String str, long j3) {
            w.d("Luggage.ThreadBootDelegate", "[onInterrupt] name=" + str + " id=" + j3);
        }

        @Override // com.tencent.luggage.wxa.zp.d.g
        public void b(Thread thread, String str, long j3) {
            w.d("Luggage.ThreadBootDelegate", "[onThreadExit] name=" + str + " id=" + j3);
        }

        @Override // com.tencent.luggage.wxa.zp.d.g
        public void c(Thread thread, String str, long j3) {
            w.d("Luggage.ThreadBootDelegate", "[onThreadStart] name=" + str + " id=" + j3);
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static abstract class e implements com.tencent.luggage.wxa.bq.d {

        /* renamed from: a, reason: collision with root package name */
        public static final e f141724a = new a("DUMMY", 0);

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ e[] f141725b = b();

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public enum a extends e {
            public a(String str, int i3) {
                super(str, i3, null);
            }

            @Override // com.tencent.luggage.wxa.bq.d
            public void a(long j3) {
            }

            @Override // com.tencent.luggage.wxa.bq.d
            public void a(Collection collection) {
            }

            @Override // com.tencent.luggage.wxa.bq.d
            public Map a() {
                return Collections.emptyMap();
            }
        }

        public e(String str, int i3) {
        }

        public static /* synthetic */ e[] b() {
            return new e[]{f141724a};
        }

        public static e valueOf(String str) {
            return (e) Enum.valueOf(e.class, str);
        }

        public static e[] values() {
            return (e[]) f141725b.clone();
        }

        public /* synthetic */ e(String str, int i3, a aVar) {
            this(str, i3);
        }
    }

    @Override // com.tencent.luggage.wxa.zp.g.c
    public void a(g.e eVar) {
        eVar.a(new a());
        eVar.a(new b());
        eVar.a(new c());
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class d {

        /* renamed from: b, reason: collision with root package name */
        public static final d f141721b = new a("SHARED", 0);

        /* renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ d[] f141722c = a();

        /* renamed from: a, reason: collision with root package name */
        public int f141723a;

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public enum a extends d {
            public a(String str, int i3) {
                super(str, i3, null);
            }

            @Override // com.tencent.luggage.wxa.tn.u0.d
            public com.tencent.luggage.wxa.zp.a a(a.b bVar) {
                return bVar.a(c(), b()).a(d()).a(TimeUnit.DAYS.toMillis(3L)).a(false).a(h.b.FS_POLICY).a(e.f141724a).a();
            }
        }

        public d(String str, int i3) {
            this.f141723a = Math.min(4, Runtime.getRuntime().availableProcessors());
        }

        public static /* synthetic */ d[] a() {
            return new d[]{f141721b};
        }

        public static d valueOf(String str) {
            return (d) Enum.valueOf(d.class, str);
        }

        public static d[] values() {
            return (d[]) f141722c.clone();
        }

        public abstract com.tencent.luggage.wxa.zp.a a(a.b bVar);

        public int b() {
            return this.f141723a;
        }

        public int c() {
            return this.f141723a;
        }

        public int d() {
            return this.f141723a;
        }

        public /* synthetic */ d(String str, int i3, a aVar) {
            this(str, i3);
        }
    }

    @Override // com.tencent.luggage.wxa.zp.g.c
    public com.tencent.luggage.wxa.zp.a a(a.b bVar) {
        return d.f141721b.a(bVar);
    }

    @Override // com.tencent.luggage.wxa.zp.g.c
    public void a() {
        a.C6453a.a(com.tencent.luggage.wxa.lq.f.INSTANCE);
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class c implements d.f {
        public c() {
        }

        @Override // com.tencent.luggage.wxa.zp.d.f
        public void a(String str, int i3, com.tencent.luggage.wxa.zp.f fVar, long j3, long j16, String str2, boolean z16) {
            if (z16) {
                if (fVar == com.tencent.luggage.wxa.zp.f.CREATED) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("====== ");
                    sb5.append(str);
                    sb5.append("@");
                    sb5.append(i3);
                    sb5.append(" state=");
                    sb5.append(fVar);
                    sb5.append(" delay=");
                    sb5.append(j3 >= 0 ? j3 / 1000000 : 0L);
                    sb5.append("ms");
                    w.d("Luggage.ThreadBootDelegate", sb5.toString());
                    return;
                }
                if (fVar == com.tencent.luggage.wxa.zp.f.RUNNING) {
                    w.d("Luggage.ThreadBootDelegate", ">>>>>> " + str + "@" + i3 + " state=" + fVar + " pool=" + str2);
                    return;
                }
                if (fVar == com.tencent.luggage.wxa.zp.f.COMPLETE) {
                    w.d("Luggage.ThreadBootDelegate", "<<<<<< " + str + "@" + i3 + " state=" + fVar + " cost=" + j3 + "ms pool=" + str2);
                    return;
                }
                if (fVar == com.tencent.luggage.wxa.zp.f.CANCEL) {
                    w.d("Luggage.ThreadBootDelegate", "|||||| " + str + "@" + i3 + " state=" + fVar);
                    return;
                }
                if (fVar == com.tencent.luggage.wxa.zp.f.THROW) {
                    w.d("Luggage.ThreadBootDelegate", "****** " + str + "@" + i3 + " state=" + fVar);
                }
            }
        }

        @Override // com.tencent.luggage.wxa.zp.d.f
        public void a(String str, int i3, Throwable th5) {
            w.b("Luggage.ThreadBootDelegate", str + "@" + i3 + " " + th5);
        }

        @Override // com.tencent.luggage.wxa.zp.d.f
        public void a(String str, int i3, int i16, long j3, String str2) {
            w.f("Luggage.ThreadBootDelegate", "[wait] " + str + "@" + i3 + " runningCount=" + i16 + " waitFor=" + (j3 / JsonGrayBusiId.UI_RESERVE_100000_110000) + "ms pool=" + str2);
        }

        @Override // com.tencent.luggage.wxa.zp.d.f
        public void a(String str, int i3, String str2, boolean z16) {
            if (z16) {
                return;
            }
            w.f("Luggage.ThreadBootDelegate", "[rejected] " + str + " pool=" + str2);
        }
    }
}
