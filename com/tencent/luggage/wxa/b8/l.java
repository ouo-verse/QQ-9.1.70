package com.tencent.luggage.wxa.b8;

import android.content.SharedPreferences;
import androidx.collection.ArraySet;
import com.tencent.luggage.wxa.md.a;
import com.tencent.luggage.wxa.tn.f0;
import com.tencent.luggage.wxa.tn.w;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__MutableCollectionsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.Delegates;
import kotlin.properties.ObservableProperty;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt__StringsJVMKt;
import rx.Observable;
import rx.Scheduler;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.plugins.RxJavaHooks;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    public final String f121987a;

    /* renamed from: b, reason: collision with root package name */
    public final ReadWriteProperty f121988b;

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList f121989c;

    /* renamed from: d, reason: collision with root package name */
    public final ArrayList f121990d;

    /* renamed from: e, reason: collision with root package name */
    public Function0 f121991e;

    /* renamed from: f, reason: collision with root package name */
    public Function1 f121992f;

    /* renamed from: g, reason: collision with root package name */
    public final CompositeSubscription f121993g;

    /* renamed from: h, reason: collision with root package name */
    public final h f121994h;

    /* renamed from: i, reason: collision with root package name */
    public final c f121995i;

    /* renamed from: j, reason: collision with root package name */
    public Func1 f121996j;

    /* renamed from: k, reason: collision with root package name */
    public final com.tencent.luggage.wxa.zp.b f121997k;

    /* renamed from: l, reason: collision with root package name */
    public final Lazy f121998l;

    /* renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f121986n = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(l.class, "currentSelectedDevice", "getCurrentSelectedDevice()Lcom/tencent/mm/plugin/appbrand/dlna/device/MRDevice;", 0))};

    /* renamed from: m, reason: collision with root package name */
    public static final a f121985m = new a(null);

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b extends Lambda implements Function1 {
        public b() {
            super(1);
        }

        public final void a(com.tencent.luggage.wxa.bi.e it) {
            String str;
            Intrinsics.checkNotNullParameter(it, "it");
            it.c(false);
            it.b(false);
            com.tencent.luggage.wxa.md.b c16 = it.a().c();
            String str2 = null;
            if (c16 != null) {
                str = c16.f134430j;
            } else {
                str = null;
            }
            com.tencent.luggage.wxa.md.b c17 = l.this.c().c();
            if (c17 != null) {
                str2 = c17.f134430j;
            }
            if (Intrinsics.areEqual(str, str2)) {
                it.b(true);
                it.a(false);
                it.c(true);
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((com.tencent.luggage.wxa.bi.e) obj);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class c implements a.InterfaceC6469a {
        public c() {
        }

        @Override // com.tencent.luggage.wxa.md.a.InterfaceC6469a
        public void a(com.tencent.luggage.wxa.md.c device) {
            Intrinsics.checkNotNullParameter(device, "device");
            try {
                w.d("MicroMsg.MediaCastDeviceManager", "[search]onUpdateDevice, " + device);
            } catch (Exception e16) {
                w.b("MicroMsg.MediaCastDeviceManager", "[search]onUpdateDevice", e16);
            }
        }

        @Override // com.tencent.luggage.wxa.md.a.InterfaceC6469a
        public void b(com.tencent.luggage.wxa.md.c device) {
            String str;
            Intrinsics.checkNotNullParameter(device, "device");
            l.this.h().remove(new com.tencent.luggage.wxa.bi.e(device));
            l.this.g().remove(new com.tencent.luggage.wxa.bi.e(device));
            Function0 e16 = l.this.e();
            if (e16 != null) {
                e16.invoke();
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append("[search]onRemoveDevice, ");
            com.tencent.luggage.wxa.md.b c16 = device.c();
            if (c16 != null) {
                str = c16.f134427g;
            } else {
                str = null;
            }
            sb5.append(str);
            w.d("MicroMsg.MediaCastDeviceManager", sb5.toString());
        }

        @Override // com.tencent.luggage.wxa.md.a.InterfaceC6469a
        public void c(com.tencent.luggage.wxa.md.c device) {
            String str;
            Intrinsics.checkNotNullParameter(device, "device");
            boolean z16 = false;
            try {
                w.d("MicroMsg.MediaCastDeviceManager", "[search]onAddDevice, " + device);
            } catch (Exception e16) {
                w.b("MicroMsg.MediaCastDeviceManager", "[search]onAddDevice", e16);
            }
            if (l.this.a(device)) {
                ArrayList g16 = l.this.g();
                if (!(g16 instanceof Collection) || !g16.isEmpty()) {
                    Iterator it = g16.iterator();
                    while (it.hasNext()) {
                        com.tencent.luggage.wxa.md.b c16 = ((com.tencent.luggage.wxa.bi.e) it.next()).a().c();
                        Intrinsics.checkNotNull(c16);
                        String str2 = c16.f134430j;
                        com.tencent.luggage.wxa.md.b c17 = device.c();
                        Intrinsics.checkNotNull(c17);
                        if (Intrinsics.areEqual(str2, c17.f134430j)) {
                            break;
                        }
                    }
                }
                z16 = true;
                if (z16) {
                    l.this.g().add(new com.tencent.luggage.wxa.bi.e(device));
                }
            } else {
                ArrayList h16 = l.this.h();
                if (!(h16 instanceof Collection) || !h16.isEmpty()) {
                    Iterator it5 = h16.iterator();
                    while (it5.hasNext()) {
                        com.tencent.luggage.wxa.md.b c18 = ((com.tencent.luggage.wxa.bi.e) it5.next()).a().c();
                        Intrinsics.checkNotNull(c18);
                        String str3 = c18.f134430j;
                        com.tencent.luggage.wxa.md.b c19 = device.c();
                        Intrinsics.checkNotNull(c19);
                        if (Intrinsics.areEqual(str3, c19.f134430j)) {
                            break;
                        }
                    }
                }
                z16 = true;
                if (z16) {
                    l.this.h().add(new com.tencent.luggage.wxa.bi.e(device));
                }
            }
            Function0 e17 = l.this.e();
            if (e17 != null) {
                e17.invoke();
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append("[search]onAddDevice, ");
            com.tencent.luggage.wxa.md.b c26 = device.c();
            if (c26 != null) {
                str = c26.f134427g;
            } else {
                str = null;
            }
            sb5.append(str);
            w.d("MicroMsg.MediaCastDeviceManager", sb5.toString());
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class d implements com.tencent.luggage.wxa.kd.b {
        @Override // com.tencent.luggage.wxa.kd.b
        public void a(String tag, Throwable tr5, String format) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(tr5, "tr");
            Intrinsics.checkNotNullParameter(format, "format");
            w.a(tag, tr5, format, new Object[0]);
        }

        @Override // com.tencent.luggage.wxa.kd.b
        public void e(String tag, String msg2) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(msg2, "msg");
            w.b(tag, msg2);
        }

        @Override // com.tencent.luggage.wxa.kd.b
        public void i(String tag, String msg2) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(msg2, "msg");
            w.d(tag, msg2);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class e extends Lambda implements Function0 {

        /* renamed from: a, reason: collision with root package name */
        public static final e f122001a = new e();

        public e() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final f0 invoke() {
            return f0.g();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class f extends Lambda implements Function1 {
        public f() {
            super(1);
        }

        public final void a(com.tencent.luggage.wxa.bi.e it) {
            String str;
            Intrinsics.checkNotNullParameter(it, "it");
            com.tencent.luggage.wxa.md.b c16 = it.a().c();
            String str2 = null;
            if (c16 != null) {
                str = c16.f134430j;
            } else {
                str = null;
            }
            com.tencent.luggage.wxa.md.b c17 = l.this.c().c();
            if (c17 != null) {
                str2 = c17.f134430j;
            }
            if (Intrinsics.areEqual(str, str2)) {
                it.b(false);
                it.a(false);
                it.c(true);
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((com.tencent.luggage.wxa.bi.e) obj);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class g extends Lambda implements Function1 {
        public g() {
            super(1);
        }

        public final void a(com.tencent.luggage.wxa.bi.e it) {
            String str;
            Intrinsics.checkNotNullParameter(it, "it");
            com.tencent.luggage.wxa.md.b c16 = it.a().c();
            String str2 = null;
            if (c16 != null) {
                str = c16.f134430j;
            } else {
                str = null;
            }
            com.tencent.luggage.wxa.md.b c17 = l.this.c().c();
            if (c17 != null) {
                str2 = c17.f134430j;
            }
            if (Intrinsics.areEqual(str, str2)) {
                it.b(false);
                it.a(true);
                it.c(true);
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((com.tencent.luggage.wxa.bi.e) obj);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class h implements a.InterfaceC6469a {
        public h() {
        }

        @Override // com.tencent.luggage.wxa.md.a.InterfaceC6469a
        public void a(com.tencent.luggage.wxa.md.c cVar) {
            w.d("MicroMsg.MediaCastDeviceManager", "[reconnect]onUpdateDevice");
        }

        @Override // com.tencent.luggage.wxa.md.a.InterfaceC6469a
        public void b(com.tencent.luggage.wxa.md.c cVar) {
            w.d("MicroMsg.MediaCastDeviceManager", "[reconnect]onRemoveDevice");
        }

        @Override // com.tencent.luggage.wxa.md.a.InterfaceC6469a
        public void c(com.tencent.luggage.wxa.md.c cVar) {
            String str;
            boolean isBlank;
            com.tencent.luggage.wxa.md.b c16;
            String str2 = null;
            if (cVar != null && (c16 = cVar.c()) != null) {
                str = c16.f134430j;
            } else {
                str = null;
            }
            if (str == null) {
                str = "";
            }
            w.d("MicroMsg.MediaCastDeviceManager", "[reconnect]onAddDevice, udn = " + str);
            if (cVar != null) {
                isBlank = StringsKt__StringsJVMKt.isBlank(str);
                if (!isBlank) {
                    com.tencent.luggage.wxa.md.b c17 = l.this.c().c();
                    if (c17 != null) {
                        str2 = c17.f134430j;
                    }
                    if (Intrinsics.areEqual(str, str2)) {
                        Function1 f16 = l.this.f();
                        if (f16 != null) {
                            f16.invoke(Boolean.TRUE);
                        }
                        l.this.c(cVar);
                        return;
                    }
                    return;
                }
            }
            Function1 f17 = l.this.f();
            if (f17 != null) {
                f17.invoke(Boolean.FALSE);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class i implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.md.c f122006b;

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class a implements Comparator {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ l f122007a;

            public a(l lVar) {
                this.f122007a = lVar;
            }

            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                long j3;
                int compareValues;
                String str = (String) obj;
                f0 d16 = this.f122007a.d();
                long j16 = 0;
                if (d16 != null) {
                    j3 = d16.getLong(str, 0L);
                } else {
                    j3 = 0;
                }
                Long valueOf = Long.valueOf(j3);
                String str2 = (String) obj2;
                f0 d17 = this.f122007a.d();
                if (d17 != null) {
                    j16 = d17.getLong(str2, 0L);
                }
                compareValues = ComparisonsKt__ComparisonsKt.compareValues(valueOf, Long.valueOf(j16));
                return compareValues;
            }
        }

        public i(com.tencent.luggage.wxa.md.c cVar) {
            this.f122006b = cVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            List list;
            Set set;
            Set stringSet;
            String str = "VideoCastDeviceManager.saveDevice" + l.this.f121987a;
            f0 d16 = l.this.d();
            String str2 = null;
            if (d16 != null && (stringSet = d16.getStringSet(str, null)) != null) {
                list = CollectionsKt___CollectionsKt.toMutableList((Collection) stringSet);
            } else {
                list = null;
            }
            com.tencent.luggage.wxa.md.b c16 = this.f122006b.c();
            if (c16 != null) {
                str2 = c16.f134430j;
            }
            if (list == null) {
                f0 d17 = l.this.d();
                if (d17 != null) {
                    ArraySet arraySet = new ArraySet();
                    arraySet.add(str2);
                    Unit unit = Unit.INSTANCE;
                    SharedPreferences.Editor putStringSet = d17.putStringSet(str, arraySet);
                    if (putStringSet != null) {
                        putStringSet.putLong(str2, System.currentTimeMillis());
                        return;
                    }
                    return;
                }
                return;
            }
            if (list.contains(str2)) {
                f0 d18 = l.this.d();
                if (d18 != null) {
                    d18.putLong(str2, System.currentTimeMillis());
                    return;
                }
                return;
            }
            if (2 <= list.size()) {
                l lVar = l.this;
                if (list.size() > 1) {
                    CollectionsKt__MutableCollectionsJVMKt.sortWith(list, new a(lVar));
                }
                f0 d19 = l.this.d();
                if (d19 != null) {
                    d19.g((String) list.get(0));
                }
                list.remove(0);
            }
            list.add(str2);
            f0 d26 = l.this.d();
            if (d26 != null) {
                set = CollectionsKt___CollectionsKt.toSet(list);
                SharedPreferences.Editor putStringSet2 = d26.putStringSet(str, set);
                if (putStringSet2 != null) {
                    putStringSet2.putLong(str2, System.currentTimeMillis());
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class j implements Action1 {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f122008a;

        public j(boolean z16) {
            this.f122008a = z16;
        }

        @Override // rx.functions.Action1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void call(Long l3) {
            com.tencent.luggage.wxa.nd.k.d().a(this.f122008a);
            w.d("MicroMsg.MediaCastDeviceManager", "search, searching...");
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class k implements Action1 {
        public k() {
        }

        @Override // rx.functions.Action1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void call(Long l3) {
            w.b("MicroMsg.MediaCastDeviceManager", "searchReleaseTimer, search time out");
            l.this.i().clear();
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.b8.l$l, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C6038l extends ObservableProperty {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l f122010a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C6038l(Object obj, l lVar) {
            super(obj);
            this.f122010a = lVar;
        }

        @Override // kotlin.properties.ObservableProperty
        public void afterChange(KProperty property, Object obj, Object obj2) {
            Intrinsics.checkNotNullParameter(property, "property");
            com.tencent.luggage.wxa.md.c cVar = (com.tencent.luggage.wxa.md.c) obj2;
            if (!Intrinsics.areEqual((com.tencent.luggage.wxa.md.c) obj, cVar) && cVar.c() != null) {
                this.f122010a.b(cVar);
                b bVar = new b();
                Iterator it = this.f122010a.h().iterator();
                while (it.hasNext()) {
                    bVar.invoke(it.next());
                }
                Iterator it5 = this.f122010a.g().iterator();
                while (it5.hasNext()) {
                    bVar.invoke(it5.next());
                }
                Function0 e16 = this.f122010a.e();
                if (e16 != null) {
                    e16.invoke();
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class m implements Func1 {
        public m() {
        }

        @Override // rx.functions.Func1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Scheduler call(Scheduler scheduler) {
            return Schedulers.from(l.this.f121997k);
        }
    }

    public l(String category) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(category, "category");
        this.f121987a = category;
        Delegates delegates = Delegates.INSTANCE;
        this.f121988b = new C6038l(new com.tencent.luggage.wxa.md.c(null), this);
        this.f121989c = new ArrayList();
        this.f121990d = new ArrayList();
        this.f121993g = new CompositeSubscription();
        this.f121994h = new h();
        this.f121995i = new c();
        this.f121997k = com.tencent.luggage.wxa.zp.h.f146825d.a("MicroMsg.MediaCastDeviceManager");
        lazy = LazyKt__LazyJVMKt.lazy(e.f122001a);
        this.f121998l = lazy;
    }

    public final f0 d() {
        return (f0) this.f121998l.getValue();
    }

    public final Function0 e() {
        return this.f121991e;
    }

    public final Function1 f() {
        return this.f121992f;
    }

    public final ArrayList g() {
        return this.f121990d;
    }

    public final ArrayList h() {
        return this.f121989c;
    }

    public final CompositeSubscription i() {
        return this.f121993g;
    }

    public final boolean j() {
        try {
            com.tencent.luggage.wxa.kd.a.a("MicroMsg.MediaCazt.", new d());
            com.tencent.luggage.wxa.nd.k.d().c();
            com.tencent.luggage.wxa.nd.e.d().c();
            return false;
        } catch (com.tencent.luggage.wxa.qd.a e16) {
            w.a("MicroMsg.MediaCastDeviceManager", e16, "initDlna, RouterException = " + e16.getMessage(), new Object[0]);
            return true;
        }
    }

    public final void k() {
        f fVar = new f();
        Iterator it = this.f121989c.iterator();
        while (it.hasNext()) {
            fVar.invoke(it.next());
        }
        Iterator it5 = this.f121990d.iterator();
        while (it5.hasNext()) {
            fVar.invoke(it5.next());
        }
        Function0 function0 = this.f121991e;
        if (function0 != null) {
            function0.invoke();
        }
    }

    public final void l() {
        g gVar = new g();
        Iterator it = this.f121989c.iterator();
        while (it.hasNext()) {
            gVar.invoke(it.next());
        }
        Iterator it5 = this.f121990d.iterator();
        while (it5.hasNext()) {
            gVar.invoke(it5.next());
        }
        Function0 function0 = this.f121991e;
        if (function0 != null) {
            function0.invoke();
        }
    }

    public final void m() {
        w.d("MicroMsg.MediaCastDeviceManager", "prepareAndSearchDevice");
        if (!p()) {
            return;
        }
        com.tencent.luggage.wxa.md.a.c().a(this.f121995i);
        n();
        o();
    }

    public final void n() {
        boolean z16;
        String a16 = com.tencent.luggage.wxa.h6.j.a();
        String b16 = com.tencent.luggage.wxa.h6.j.b();
        if (com.tencent.luggage.wxa.tn.q.a(a16) && com.tencent.luggage.wxa.tn.q.a(b16)) {
            z16 = true;
        } else {
            z16 = false;
        }
        w.d("MicroMsg.MediaCastDeviceManager", "search, selfIp = [%s], wifiIp = [%s], ipv6 = [%b]", a16, b16, Boolean.valueOf(z16));
        this.f121993g.add(Observable.interval(0L, 1000L, TimeUnit.MILLISECONDS).take(10).observeOn(com.tencent.luggage.wxa.rd.a.a()).subscribe(new j(z16)));
    }

    public final void o() {
        this.f121993g.add(Observable.timer(10L, TimeUnit.SECONDS).subscribe(new k()));
    }

    public final boolean p() {
        if (RxJavaHooks.getOnIOScheduler() == null) {
            m mVar = new m();
            this.f121996j = mVar;
            RxJavaHooks.setOnIOScheduler(mVar);
        }
        if (j()) {
            return false;
        }
        return true;
    }

    public final com.tencent.luggage.wxa.md.c c() {
        return (com.tencent.luggage.wxa.md.c) this.f121988b.getValue(this, f121986n[0]);
    }

    public final void a(Function0 function0) {
        this.f121991e = function0;
    }

    public final void b() {
        com.tencent.luggage.wxa.md.a c16 = com.tencent.luggage.wxa.md.a.c();
        c16.d();
        for (com.tencent.luggage.wxa.md.c cVar : c16.b()) {
            cVar.k();
            cVar.l();
            cVar.a((com.tencent.luggage.wxa.md.d) null);
        }
        c16.b(this.f121995i);
        c16.b(this.f121994h);
        c16.a();
        try {
            com.tencent.luggage.wxa.nd.k.d().b();
        } catch (com.tencent.luggage.wxa.qd.a e16) {
            w.a("MicroMsg.MediaCastDeviceManager", e16, "deinitDlna, RouterException = " + e16.getMessage(), new Object[0]);
        }
        com.tencent.luggage.wxa.nd.e.d().b();
    }

    public final void c(com.tencent.luggage.wxa.md.c cVar) {
        Intrinsics.checkNotNullParameter(cVar, "<set-?>");
        this.f121988b.setValue(this, f121986n[0], cVar);
    }

    public final void a(Function1 onReconnectResult) {
        Intrinsics.checkNotNullParameter(onReconnectResult, "onReconnectResult");
        try {
            this.f121993g.clear();
            b();
        } catch (Exception e16) {
            w.a("MicroMsg.MediaCastDeviceManager", e16, "reconnect, Exception = " + e16.getMessage(), new Object[0]);
        }
        if (!p()) {
            w.d("MicroMsg.MediaCastDeviceManager", "reconnect, not enableRouter");
            return;
        }
        this.f121992f = onReconnectResult;
        com.tencent.luggage.wxa.md.a.c().a(this.f121994h);
        n();
        o();
    }

    public /* synthetic */ l(String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str);
    }

    public final void a() {
        try {
            this.f121993g.clear();
            b();
            this.f121990d.clear();
            this.f121989c.clear();
            if (Intrinsics.areEqual(RxJavaHooks.getOnIOScheduler(), this.f121996j)) {
                RxJavaHooks.setOnIOScheduler(null);
                this.f121996j = null;
            } else {
                w.f("MicroMsg.MediaCastDeviceManager", "clear, clearRxIOScheduler fail: scheduler instance is changed");
            }
        } catch (Exception e16) {
            w.b("MicroMsg.MediaCastDeviceManager", "clear, Error happen while cleaning up " + e16.getMessage());
        }
    }

    public final void b(com.tencent.luggage.wxa.md.c cVar) {
        com.tencent.luggage.wxa.zp.h.f146825d.execute(new i(cVar));
    }

    public final boolean a(com.tencent.luggage.wxa.md.c cVar) {
        long j3;
        f0 d16 = d();
        if (d16 != null) {
            com.tencent.luggage.wxa.md.b c16 = cVar.c();
            j3 = d16.getLong(c16 != null ? c16.f134430j : null, 0L);
        } else {
            j3 = 0;
        }
        return 0 != j3;
    }
}
