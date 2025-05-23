package com.tencent.luggage.wxa.bk;

import android.os.Build;
import com.tencent.luggage.wxa.hn.i8;
import com.tencent.luggage.wxa.hn.ie;
import com.tencent.luggage.wxa.hn.je;
import com.tencent.luggage.wxa.hn.pe;
import com.tencent.luggage.wxa.tn.e0;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.z;
import com.tencent.luggage.wxa.xo.e;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class b implements p {

    /* renamed from: f, reason: collision with root package name */
    public static e0 f122947f;

    /* renamed from: a, reason: collision with root package name */
    public static final b f122942a = new b();

    /* renamed from: b, reason: collision with root package name */
    public static final String f122943b = "/cgi-bin/mmbiz-bin/wxausrevent/wxaappidkeybatchreport";

    /* renamed from: c, reason: collision with root package name */
    public static final int f122944c = 50;

    /* renamed from: d, reason: collision with root package name */
    public static final long f122945d = TimeUnit.SECONDS.toMillis(30);

    /* renamed from: e, reason: collision with root package name */
    public static final LinkedList f122946e = new LinkedList();

    /* renamed from: g, reason: collision with root package name */
    public static final Object f122948g = new Object();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public static final a f122949a = new a();

        /* renamed from: b, reason: collision with root package name */
        public static final Lazy f122950b;

        /* renamed from: c, reason: collision with root package name */
        public static final Lazy f122951c;

        /* renamed from: d, reason: collision with root package name */
        public static final Lazy f122952d;

        /* renamed from: e, reason: collision with root package name */
        public static final Lazy f122953e;

        /* renamed from: f, reason: collision with root package name */
        public static final Lazy f122954f;

        /* renamed from: g, reason: collision with root package name */
        public static final Lazy f122955g;

        /* renamed from: h, reason: collision with root package name */
        public static final Lazy f122956h;

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.bk.b$a$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public static final class C6079a extends Lambda implements Function0 {

            /* renamed from: a, reason: collision with root package name */
            public static final C6079a f122957a = new C6079a();

            public C6079a() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final String invoke() {
                return Build.BRAND;
            }
        }

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.bk.b$a$b, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public static final class C6080b extends Lambda implements Function0 {

            /* renamed from: a, reason: collision with root package name */
            public static final C6080b f122958a = new C6080b();

            public C6080b() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final String invoke() {
                return com.tencent.luggage.wxa.t9.l.g() + Build.CPU_ABI;
            }
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class c extends Lambda implements Function0 {

            /* renamed from: a, reason: collision with root package name */
            public static final c f122959a = new c();

            public c() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final String invoke() {
                return Build.MANUFACTURER + '-' + com.tencent.luggage.wxa.t9.l.g();
            }
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class d extends Lambda implements Function0 {

            /* renamed from: a, reason: collision with root package name */
            public static final d f122960a = new d();

            public d() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final String invoke() {
                return "android-" + Build.VERSION.SDK_INT;
            }
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class e extends Lambda implements Function0 {

            /* renamed from: a, reason: collision with root package name */
            public static final e f122961a = new e();

            public e() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final String invoke() {
                return "android-" + Build.MANUFACTURER;
            }
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class f extends Lambda implements Function0 {

            /* renamed from: a, reason: collision with root package name */
            public static final f f122962a = new f();

            public f() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final String invoke() {
                return "android-" + Build.VERSION.SDK_INT;
            }
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class g extends Lambda implements Function0 {

            /* renamed from: a, reason: collision with root package name */
            public static final g f122963a = new g();

            public g() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final String invoke() {
                return "" + Build.VERSION.SDK_INT;
            }
        }

        static {
            Lazy lazy;
            Lazy lazy2;
            Lazy lazy3;
            Lazy lazy4;
            Lazy lazy5;
            Lazy lazy6;
            Lazy lazy7;
            lazy = LazyKt__LazyJVMKt.lazy(d.f122960a);
            f122950b = lazy;
            lazy2 = LazyKt__LazyJVMKt.lazy(C6079a.f122957a);
            f122951c = lazy2;
            lazy3 = LazyKt__LazyJVMKt.lazy(C6080b.f122958a);
            f122952d = lazy3;
            lazy4 = LazyKt__LazyJVMKt.lazy(c.f122959a);
            f122953e = lazy4;
            lazy5 = LazyKt__LazyJVMKt.lazy(f.f122962a);
            f122954f = lazy5;
            lazy6 = LazyKt__LazyJVMKt.lazy(g.f122963a);
            f122955g = lazy6;
            lazy7 = LazyKt__LazyJVMKt.lazy(e.f122961a);
            f122956h = lazy7;
        }

        public final String a() {
            Object value = f122951c.getValue();
            Intrinsics.checkNotNullExpressionValue(value, "<get-DEVICE_BRAND>(...)");
            return (String) value;
        }

        public final String b() {
            return (String) f122952d.getValue();
        }

        public final String c() {
            return (String) f122956h.getValue();
        }

        public final String d() {
            return (String) f122955g.getValue();
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.bk.b$b, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C6081b implements e.c {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f122964a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ LinkedList f122965b;

        public C6081b(String str, LinkedList linkedList) {
            this.f122964a = str;
            this.f122965b = linkedList;
        }

        @Override // com.tencent.luggage.wxa.xo.e.c
        public final void a(je jeVar) {
            w.d("Luggage.AppBrandIDKeyBatchReportNew", "reportNow, reason=" + this.f122964a + ", reportList.size=" + this.f122965b.size() + ", cgi back ok");
            this.f122965b.clear();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class c implements e.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f122966a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ LinkedList f122967b;

        public c(String str, LinkedList linkedList) {
            this.f122966a = str;
            this.f122967b = linkedList;
        }

        @Override // com.tencent.luggage.wxa.xo.e.a
        public final void a(Object obj) {
            String str;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("reportNow, reason=");
            sb5.append(this.f122966a);
            sb5.append(", reportList.size=");
            sb5.append(this.f122967b.size());
            sb5.append(", cgi error ");
            if (obj != null) {
                str = obj.toString();
            } else {
                str = null;
            }
            sb5.append(str);
            w.b("Luggage.AppBrandIDKeyBatchReportNew", sb5.toString());
            LinkedList linkedList = b.f122946e;
            LinkedList linkedList2 = this.f122967b;
            synchronized (linkedList) {
                b.f122946e.addAll(linkedList2);
            }
            this.f122967b.clear();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class d implements e0.a {
        @Override // com.tencent.luggage.wxa.tn.e0.a
        public boolean a() {
            return b.f122942a.a("onTimerExpired", false);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0011, code lost:
    
        if (r1 != false) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void b() {
        boolean z16;
        synchronized (f122948g) {
            e0 e0Var = f122947f;
            if (e0Var != null) {
                if (e0Var.g()) {
                    z16 = true;
                } else {
                    z16 = false;
                }
            }
            e0 e0Var2 = new e0("Luggage.AppBrandIDKeyBatchReportNew", (e0.a) new d(), true);
            long j3 = f122945d;
            e0Var2.a(j3, j3);
            f122947f = e0Var2;
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void c() {
        synchronized (f122948g) {
            e0 e0Var = f122947f;
            if (e0Var != null) {
                e0Var.f();
            }
            f122947f = null;
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // com.tencent.luggage.wxa.bk.p
    public void a(pe peVar) {
        int size;
        if (peVar == null) {
            return;
        }
        w.d("Luggage.AppBrandIDKeyBatchReportNew", "writeIDKeyData type:" + peVar.f128440d);
        LinkedList linkedList = f122946e;
        synchronized (linkedList) {
            linkedList.addLast(peVar);
            size = linkedList.size();
        }
        if (size >= f122944c) {
            a("writeIDKeyData", true);
        } else {
            b();
        }
    }

    public final boolean a(String reason, boolean z16) {
        LinkedList linkedList;
        Intrinsics.checkNotNullParameter(reason, "reason");
        if (z16) {
            c();
        }
        LinkedList linkedList2 = f122946e;
        synchronized (linkedList2) {
            linkedList = new LinkedList(linkedList2);
            linkedList2.clear();
        }
        w.d("Luggage.AppBrandIDKeyBatchReportNew", "reportNow, reason=" + reason + ", reportList.size=" + linkedList.size());
        if (linkedList.isEmpty()) {
            return false;
        }
        ie ieVar = new ie();
        i8 i8Var = new i8();
        i8Var.f127872d = Build.MANUFACTURER;
        i8Var.f127873e = 2;
        a aVar = a.f122949a;
        i8Var.f127874f = aVar.b();
        i8Var.f127875g = aVar.a();
        i8Var.f127876h = z.j().getDisplayMetrics().widthPixels;
        i8Var.f127877i = z.j().getDisplayMetrics().heightPixels;
        i8Var.f127878j = aVar.c();
        i8Var.f127879k = aVar.d();
        i8Var.f127880l = z.j().getConfiguration().locale.getLanguage();
        ieVar.f127900f = i8Var;
        ieVar.f127899e.addAll(linkedList);
        ((com.tencent.luggage.wxa.bj.c) com.tencent.luggage.wxa.h1.e.a(com.tencent.luggage.wxa.bj.c.class)).b(f122943b, null, ieVar, je.class).a(new C6081b(reason, linkedList)).a(new c(reason, linkedList));
        return true;
    }
}
