package com.tencent.luggage.wxa.bi;

import com.tencent.luggage.wxa.md.a;
import com.tencent.luggage.wxa.nd.k;
import com.tencent.luggage.wxa.tn.q;
import com.tencent.luggage.wxa.tn.w;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
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
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public final com.tencent.luggage.wxa.zp.b f122877a = com.tencent.luggage.wxa.zp.h.f146825d.a("MicroMsg.VideoCast.VideoCastDeviceManager");

    /* renamed from: b, reason: collision with root package name */
    public final com.tencent.luggage.wxa.md.c f122878b;

    /* renamed from: c, reason: collision with root package name */
    public Func1 f122879c;

    /* renamed from: d, reason: collision with root package name */
    public final ReadWriteProperty f122880d;

    /* renamed from: e, reason: collision with root package name */
    public final ArrayList f122881e;

    /* renamed from: f, reason: collision with root package name */
    public final ArrayList f122882f;

    /* renamed from: g, reason: collision with root package name */
    public Function0 f122883g;

    /* renamed from: h, reason: collision with root package name */
    public final CompositeSubscription f122884h;

    /* renamed from: i, reason: collision with root package name */
    public Function1 f122885i;

    /* renamed from: j, reason: collision with root package name */
    public final c f122886j;

    /* renamed from: k, reason: collision with root package name */
    public final b f122887k;

    /* renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f122876m = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(i.class, "currentSelectedDevice", "getCurrentSelectedDevice()Lcom/tencent/mm/plugin/appbrand/dlna/device/MRDevice;", 0))};

    /* renamed from: l, reason: collision with root package name */
    public static final a f122875l = new a(null);

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
    public static final class b implements a.InterfaceC6469a {
        public b() {
        }

        @Override // com.tencent.luggage.wxa.md.a.InterfaceC6469a
        public void a(com.tencent.luggage.wxa.md.c device) {
            Intrinsics.checkNotNullParameter(device, "device");
            try {
                w.d("MicroMsg.VideoCast.VideoCastDeviceManager", "onUpdateDevice: " + device);
            } catch (Exception e16) {
                w.b("MicroMsg.VideoCast.VideoCastDeviceManager", "onUpdateDevice", e16);
            }
        }

        @Override // com.tencent.luggage.wxa.md.a.InterfaceC6469a
        public void b(com.tencent.luggage.wxa.md.c device) {
            String str;
            Intrinsics.checkNotNullParameter(device, "device");
            i.this.f().remove(new com.tencent.luggage.wxa.bi.e(device));
            i.this.d().remove(new com.tencent.luggage.wxa.bi.e(device));
            Function0 c16 = i.this.c();
            if (c16 != null) {
                c16.invoke();
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append("onRemoveDevice: ");
            com.tencent.luggage.wxa.md.b c17 = device.c();
            if (c17 != null) {
                str = c17.f134427g;
            } else {
                str = null;
            }
            sb5.append(str);
            w.d("MicroMsg.VideoCast.VideoCastDeviceManager", sb5.toString());
        }

        @Override // com.tencent.luggage.wxa.md.a.InterfaceC6469a
        public void c(com.tencent.luggage.wxa.md.c device) {
            String str;
            Intrinsics.checkNotNullParameter(device, "device");
            boolean z16 = false;
            try {
                w.d("MicroMsg.VideoCast.VideoCastDeviceManager", "onAddDevice: " + device);
            } catch (Exception e16) {
                w.b("MicroMsg.VideoCast.VideoCastDeviceManager", "onAddDevice", e16);
            }
            if (j.a(device)) {
                ArrayList d16 = i.this.d();
                if (!(d16 instanceof Collection) || !d16.isEmpty()) {
                    Iterator it = d16.iterator();
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
                    i.this.d().add(new com.tencent.luggage.wxa.bi.e(device));
                }
            } else {
                ArrayList f16 = i.this.f();
                if (!(f16 instanceof Collection) || !f16.isEmpty()) {
                    Iterator it5 = f16.iterator();
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
                    i.this.f().add(new com.tencent.luggage.wxa.bi.e(device));
                }
            }
            Function0 c26 = i.this.c();
            if (c26 != null) {
                c26.invoke();
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append("onAddDevice: ");
            com.tencent.luggage.wxa.md.b c27 = device.c();
            if (c27 != null) {
                str = c27.f134427g;
            } else {
                str = null;
            }
            sb5.append(str);
            w.d("MicroMsg.VideoCast.VideoCastDeviceManager", sb5.toString());
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class c implements a.InterfaceC6469a {
        public c() {
        }

        @Override // com.tencent.luggage.wxa.md.a.InterfaceC6469a
        public void a(com.tencent.luggage.wxa.md.c cVar) {
            w.d("MicroMsg.VideoCast.VideoCastDeviceManager", "reconnect: onUpdateDevice");
        }

        @Override // com.tencent.luggage.wxa.md.a.InterfaceC6469a
        public void b(com.tencent.luggage.wxa.md.c cVar) {
            w.d("MicroMsg.VideoCast.VideoCastDeviceManager", "reconnect: onRemoveDevice");
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
            w.d("MicroMsg.VideoCast.VideoCastDeviceManager", "onAddDevice: udn = " + str);
            if (cVar != null) {
                isBlank = StringsKt__StringsJVMKt.isBlank(str);
                if (!isBlank) {
                    com.tencent.luggage.wxa.md.b c17 = i.this.b().c();
                    if (c17 != null) {
                        str2 = c17.f134430j;
                    }
                    if (Intrinsics.areEqual(str, str2)) {
                        Function1 e16 = i.this.e();
                        if (e16 != null) {
                            e16.invoke(Boolean.TRUE);
                        }
                        i.this.a(cVar);
                        return;
                    }
                    return;
                }
            }
            Function1 e17 = i.this.e();
            if (e17 != null) {
                e17.invoke(Boolean.FALSE);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class d implements Action1 {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f122890a;

        public d(boolean z16) {
            this.f122890a = z16;
        }

        @Override // rx.functions.Action1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void call(Long l3) {
            k.d().a(this.f122890a);
            w.d("MicroMsg.VideoCast.VideoCastDeviceManager", "prepareAndSearchDevice: searching...");
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class f implements Action1 {
        public f() {
        }

        @Override // rx.functions.Action1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void call(Long l3) {
            w.b("MicroMsg.VideoCast.VideoCastDeviceManager", "search time out");
            i.this.g().clear();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class g extends ObservableProperty {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i f122893a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(Object obj, i iVar) {
            super(obj);
            this.f122893a = iVar;
        }

        @Override // kotlin.properties.ObservableProperty
        public void afterChange(KProperty property, Object obj, Object obj2) {
            String str;
            String str2;
            String str3;
            Intrinsics.checkNotNullParameter(property, "property");
            com.tencent.luggage.wxa.md.c cVar = (com.tencent.luggage.wxa.md.c) obj2;
            if (!Intrinsics.areEqual((com.tencent.luggage.wxa.md.c) obj, cVar) && cVar.c() != null) {
                j.b(cVar);
                Iterator it = this.f122893a.f().iterator();
                while (true) {
                    String str4 = null;
                    if (!it.hasNext()) {
                        break;
                    }
                    com.tencent.luggage.wxa.bi.e eVar = (com.tencent.luggage.wxa.bi.e) it.next();
                    eVar.c(false);
                    eVar.b(false);
                    com.tencent.luggage.wxa.md.b c16 = eVar.a().c();
                    if (c16 != null) {
                        str3 = c16.f134430j;
                    } else {
                        str3 = null;
                    }
                    com.tencent.luggage.wxa.md.b c17 = this.f122893a.b().c();
                    if (c17 != null) {
                        str4 = c17.f134430j;
                    }
                    if (Intrinsics.areEqual(str3, str4)) {
                        eVar.b(true);
                        eVar.a(false);
                        eVar.c(true);
                    }
                }
                for (com.tencent.luggage.wxa.bi.e eVar2 : this.f122893a.d()) {
                    eVar2.c(false);
                    eVar2.b(false);
                    com.tencent.luggage.wxa.md.b c18 = eVar2.a().c();
                    if (c18 != null) {
                        str = c18.f134430j;
                    } else {
                        str = null;
                    }
                    com.tencent.luggage.wxa.md.b c19 = this.f122893a.b().c();
                    if (c19 != null) {
                        str2 = c19.f134430j;
                    } else {
                        str2 = null;
                    }
                    if (Intrinsics.areEqual(str, str2)) {
                        eVar2.b(true);
                        eVar2.a(false);
                        eVar2.c(true);
                    }
                }
                Function0 c26 = this.f122893a.c();
                if (c26 != null) {
                    c26.invoke();
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class h implements Func1 {
        public h() {
        }

        @Override // rx.functions.Func1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Scheduler call(Scheduler scheduler) {
            return Schedulers.from(i.this.f122877a);
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.bi.i$i, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C6073i implements com.tencent.luggage.wxa.kd.b {
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

    public i() {
        com.tencent.luggage.wxa.md.c cVar = new com.tencent.luggage.wxa.md.c(null);
        this.f122878b = cVar;
        Delegates delegates = Delegates.INSTANCE;
        this.f122880d = new g(cVar, this);
        this.f122881e = new ArrayList();
        this.f122882f = new ArrayList();
        this.f122884h = new CompositeSubscription();
        this.f122886j = new c();
        this.f122887k = new b();
    }

    public final com.tencent.luggage.wxa.md.c b() {
        return (com.tencent.luggage.wxa.md.c) this.f122880d.getValue(this, f122876m[0]);
    }

    public final Function0 c() {
        return this.f122883g;
    }

    public final ArrayList d() {
        return this.f122882f;
    }

    public final Function1 e() {
        return this.f122885i;
    }

    public final ArrayList f() {
        return this.f122881e;
    }

    public final CompositeSubscription g() {
        return this.f122884h;
    }

    public final void h() {
        String str;
        String str2;
        String str3;
        Iterator it = this.f122881e.iterator();
        while (true) {
            String str4 = null;
            if (!it.hasNext()) {
                break;
            }
            com.tencent.luggage.wxa.bi.e eVar = (com.tencent.luggage.wxa.bi.e) it.next();
            com.tencent.luggage.wxa.md.b c16 = eVar.a().c();
            if (c16 != null) {
                str3 = c16.f134430j;
            } else {
                str3 = null;
            }
            com.tencent.luggage.wxa.md.b c17 = b().c();
            if (c17 != null) {
                str4 = c17.f134430j;
            }
            if (Intrinsics.areEqual(str3, str4)) {
                eVar.b(false);
                eVar.a(false);
                eVar.c(true);
            }
        }
        for (com.tencent.luggage.wxa.bi.e eVar2 : this.f122882f) {
            com.tencent.luggage.wxa.md.b c18 = eVar2.a().c();
            if (c18 != null) {
                str = c18.f134430j;
            } else {
                str = null;
            }
            com.tencent.luggage.wxa.md.b c19 = b().c();
            if (c19 != null) {
                str2 = c19.f134430j;
            } else {
                str2 = null;
            }
            if (Intrinsics.areEqual(str, str2)) {
                eVar2.b(false);
                eVar2.a(false);
                eVar2.c(true);
            }
        }
        Function0 function0 = this.f122883g;
        if (function0 != null) {
            function0.invoke();
        }
    }

    public final void i() {
        String str;
        String str2;
        String str3;
        Iterator it = this.f122881e.iterator();
        while (true) {
            String str4 = null;
            if (!it.hasNext()) {
                break;
            }
            com.tencent.luggage.wxa.bi.e eVar = (com.tencent.luggage.wxa.bi.e) it.next();
            com.tencent.luggage.wxa.md.b c16 = eVar.a().c();
            if (c16 != null) {
                str3 = c16.f134430j;
            } else {
                str3 = null;
            }
            com.tencent.luggage.wxa.md.b c17 = b().c();
            if (c17 != null) {
                str4 = c17.f134430j;
            }
            if (Intrinsics.areEqual(str3, str4)) {
                eVar.b(false);
                eVar.a(true);
                eVar.c(true);
            }
        }
        for (com.tencent.luggage.wxa.bi.e eVar2 : this.f122882f) {
            com.tencent.luggage.wxa.md.b c18 = eVar2.a().c();
            if (c18 != null) {
                str = c18.f134430j;
            } else {
                str = null;
            }
            com.tencent.luggage.wxa.md.b c19 = b().c();
            if (c19 != null) {
                str2 = c19.f134430j;
            } else {
                str2 = null;
            }
            if (Intrinsics.areEqual(str, str2)) {
                eVar2.b(false);
                eVar2.a(true);
                eVar2.c(true);
            }
        }
        Function0 function0 = this.f122883g;
        if (function0 != null) {
            function0.invoke();
        }
    }

    public final void j() {
        w.d("MicroMsg.VideoCast.VideoCastDeviceManager", "prepare");
        if (!l()) {
            return;
        }
        com.tencent.luggage.wxa.md.a.c().a(this.f122887k);
        k();
        a(this, null, 1, null);
    }

    public final void k() {
        boolean z16;
        String a16 = com.tencent.luggage.wxa.h6.j.a();
        String b16 = com.tencent.luggage.wxa.h6.j.b();
        if (q.a(a16) && q.a(b16)) {
            z16 = true;
        } else {
            z16 = false;
        }
        w.d("MicroMsg.VideoCast.VideoCastDeviceManager", "searchDevice: selfIp = [%s], wifiIp = [%s], ipv6 = [%b]", a16, b16, Boolean.valueOf(z16));
        this.f122884h.add(Observable.interval(0L, 1000L, TimeUnit.MILLISECONDS).take(10).observeOn(com.tencent.luggage.wxa.rd.a.a()).subscribe(new d(z16)));
    }

    public final boolean l() {
        if (RxJavaHooks.getOnIOScheduler() == null) {
            h hVar = new h();
            this.f122879c = hVar;
            RxJavaHooks.setOnIOScheduler(hVar);
        }
        try {
            com.tencent.luggage.wxa.kd.a.a("MicroMsg.VideoCast.", new C6073i());
            k.d().c();
            com.tencent.luggage.wxa.nd.e.d().c();
            return true;
        } catch (com.tencent.luggage.wxa.qd.a e16) {
            e16.printStackTrace();
            w.b("MicroMsg.VideoCast.VideoCastDeviceManager", "prepareAndSearchDevice: RouterException = " + e16.getMessage());
            return false;
        }
    }

    public final void a(com.tencent.luggage.wxa.md.c cVar) {
        Intrinsics.checkNotNullParameter(cVar, "<set-?>");
        this.f122880d.setValue(this, f122876m[0], cVar);
    }

    public final void b(Function0 function0) {
        this.f122883g = function0;
    }

    public static /* synthetic */ void a(i iVar, Function0 function0, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            function0 = e.f122891a;
        }
        iVar.a(function0);
    }

    public final void a(Function0 function0) {
        this.f122884h.add(Observable.timer(10L, TimeUnit.SECONDS).subscribe(new f()));
    }

    public final void a(Function1 callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        try {
            this.f122884h.clear();
            com.tencent.luggage.wxa.md.a c16 = com.tencent.luggage.wxa.md.a.c();
            c16.d();
            for (com.tencent.luggage.wxa.md.c cVar : c16.b()) {
                cVar.k();
                cVar.l();
                cVar.a((com.tencent.luggage.wxa.md.d) null);
            }
            c16.b(this.f122887k);
            c16.b(this.f122886j);
            c16.a();
            try {
                k.d().b();
            } catch (com.tencent.luggage.wxa.qd.a e16) {
                e16.printStackTrace();
            }
            com.tencent.luggage.wxa.nd.e.d().b();
        } catch (Exception e17) {
            w.b("MicroMsg.VideoCast.VideoCastDeviceManager", "Error happen while cleaning up " + e17.getMessage());
        }
        if (!l()) {
            w.d("MicroMsg.VideoCast.VideoCastDeviceManager", "reconnect: not enableRouter");
            return;
        }
        this.f122885i = callback;
        com.tencent.luggage.wxa.md.a.c().a(this.f122886j);
        k();
        a(this, null, 1, null);
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class e extends Lambda implements Function0 {

        /* renamed from: a, reason: collision with root package name */
        public static final e f122891a = new e();

        public e() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.INSTANCE;
        }

        public final void a() {
        }
    }

    public final void a() {
        try {
            this.f122884h.clear();
            this.f122882f.clear();
            this.f122881e.clear();
            com.tencent.luggage.wxa.md.a c16 = com.tencent.luggage.wxa.md.a.c();
            c16.d();
            for (com.tencent.luggage.wxa.md.c cVar : c16.b()) {
                cVar.k();
                cVar.l();
                cVar.a((com.tencent.luggage.wxa.md.d) null);
            }
            c16.b(this.f122887k);
            c16.b(this.f122886j);
            if (Intrinsics.areEqual(RxJavaHooks.getOnIOScheduler(), this.f122879c)) {
                RxJavaHooks.setOnIOScheduler(null);
                this.f122879c = null;
            } else {
                w.f("MicroMsg.VideoCast.VideoCastDeviceManager", "clearRxIOScheduler fail: scheduler instance is changed");
            }
            c16.a();
            try {
                k.d().b();
            } catch (com.tencent.luggage.wxa.qd.a e16) {
                e16.printStackTrace();
            }
            com.tencent.luggage.wxa.nd.e.d().b();
        } catch (Exception e17) {
            w.b("MicroMsg.VideoCast.VideoCastDeviceManager", "Error happen while cleaning up " + e17.getMessage());
        }
    }
}
