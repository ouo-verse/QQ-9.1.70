package com.tencent.luggage.wxa.a5;

import android.os.Build;
import com.tencent.luggage.wxa.tn.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Predicate;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.apache.commons.lang.StringUtils;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f120844a = new c();

    /* renamed from: b, reason: collision with root package name */
    public static final b f120845b;

    /* renamed from: c, reason: collision with root package name */
    public static final CopyOnWriteArrayList f120846c;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final String f120847a;

        /* renamed from: b, reason: collision with root package name */
        public final String f120848b;

        public a(String appId, String str) {
            Intrinsics.checkNotNullParameter(appId, "appId");
            this.f120847a = appId;
            this.f120848b = str;
        }

        public final String a() {
            return this.f120847a;
        }

        public final String b() {
            return this.f120848b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (Intrinsics.areEqual(this.f120847a, aVar.f120847a) && Intrinsics.areEqual(this.f120848b, aVar.f120848b)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int hashCode;
            int hashCode2 = this.f120847a.hashCode() * 31;
            String str = this.f120848b;
            if (str == null) {
                hashCode = 0;
            } else {
                hashCode = str.hashCode();
            }
            return hashCode2 + hashCode;
        }

        public String toString() {
            return "PendingFinishRuntimeMessage(appId=" + this.f120847a + ", instanceId=" + this.f120848b + ')';
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface b {
        boolean a(a aVar);

        boolean a(Function1 function1);
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.a5.c$c, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C5985c implements b {

        /* renamed from: a, reason: collision with root package name */
        public final CopyOnWriteArrayList f120849a = new CopyOnWriteArrayList();

        @Override // com.tencent.luggage.wxa.a5.c.b
        public boolean a(a message) {
            Intrinsics.checkNotNullParameter(message, "message");
            return this.f120849a.add(message);
        }

        @Override // com.tencent.luggage.wxa.a5.c.b
        public boolean a(Function1 predicate) {
            boolean removeIf;
            Intrinsics.checkNotNullParameter(predicate, "predicate");
            try {
                removeIf = this.f120849a.removeIf(new f(predicate));
                return removeIf;
            } catch (UnsupportedOperationException unused) {
                Iterator it = this.f120849a.iterator();
                while (it.hasNext()) {
                    a element = (a) it.next();
                    Intrinsics.checkNotNullExpressionValue(element, "element");
                    if (((Boolean) predicate.invoke(element)).booleanValue()) {
                        this.f120849a.remove(element);
                        return true;
                    }
                }
                return false;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class e extends Lambda implements Function1 {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.c5.e f120851a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(com.tencent.luggage.wxa.c5.e eVar) {
            super(1);
            this.f120851a = eVar;
        }

        /* JADX WARN: Code restructure failed: missing block: B:13:0x0040, code lost:
        
            if (org.apache.commons.lang.StringUtils.equals(r4, r0) != false) goto L18;
         */
        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Boolean invoke(a it) {
            boolean z16;
            String str;
            Intrinsics.checkNotNullParameter(it, "it");
            boolean z17 = false;
            if (StringUtils.equals(it.a(), this.f120851a.getAppId())) {
                String b16 = it.b();
                if (b16 != null && b16.length() != 0) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (!z16) {
                    String b17 = it.b();
                    com.tencent.luggage.wxa.j4.d S = this.f120851a.S();
                    if (S != null) {
                        str = S.k();
                    } else {
                        str = null;
                    }
                }
                z17 = true;
            }
            Boolean valueOf = Boolean.valueOf(z17);
            com.tencent.luggage.wxa.c5.e eVar = this.f120851a;
            if (valueOf.booleanValue()) {
                eVar.D();
            }
            return valueOf;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class f implements Predicate {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f120852a;

        public f(Function1 function1) {
            this.f120852a = function1;
        }

        @Override // java.util.function.Predicate
        public final /* synthetic */ boolean test(Object obj) {
            return ((Boolean) this.f120852a.invoke(obj)).booleanValue();
        }
    }

    static {
        b dVar;
        if (Build.VERSION.SDK_INT >= 24) {
            dVar = new C5985c();
        } else {
            dVar = new d();
        }
        f120845b = dVar;
        f120846c = new CopyOnWriteArrayList();
    }

    public final void a(com.tencent.luggage.wxa.c5.e rt5) {
        Intrinsics.checkNotNullParameter(rt5, "rt");
        Object obj = null;
        if (f120845b.a(new e(rt5))) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("register with rt(appId:");
            sb5.append(rt5.getAppId());
            sb5.append(", instanceId:");
            com.tencent.luggage.wxa.j4.d S = rt5.S();
            String k3 = S != null ? S.k() : null;
            if (k3 == null) {
                k3 = "";
            }
            sb5.append(k3);
            sb5.append("), but finished by pending message.");
            w.b("Luggage.LuggageClientProcessMessageDispatcher", sb5.toString());
            return;
        }
        w.f("Luggage.LuggageClientProcessMessageDispatcher", "register runtime:" + rt5);
        Iterator it = f120846c.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (Intrinsics.areEqual(((com.tencent.luggage.wxa.c5.e) next).getAppId(), rt5.getAppId())) {
                obj = next;
                break;
            }
        }
        com.tencent.luggage.wxa.c5.e eVar = (com.tencent.luggage.wxa.c5.e) obj;
        if (eVar != null) {
            f120844a.b(eVar);
        }
        f120846c.add(rt5);
    }

    public final void b(com.tencent.luggage.wxa.c5.e rt5) {
        Intrinsics.checkNotNullParameter(rt5, "rt");
        w.f("Luggage.LuggageClientProcessMessageDispatcher", "unregister runtime:" + rt5);
        f120846c.remove(rt5);
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class d implements b {

        /* renamed from: a, reason: collision with root package name */
        public final ArrayList f120850a = new ArrayList();

        @Override // com.tencent.luggage.wxa.a5.c.b
        public boolean a(a message) {
            boolean add;
            Intrinsics.checkNotNullParameter(message, "message");
            synchronized (this.f120850a) {
                add = this.f120850a.add(message);
            }
            return add;
        }

        @Override // com.tencent.luggage.wxa.a5.c.b
        public boolean a(Function1 predicate) {
            Intrinsics.checkNotNullParameter(predicate, "predicate");
            synchronized (this.f120850a) {
                Iterator it = this.f120850a.iterator();
                Intrinsics.checkNotNullExpressionValue(it, "queue.iterator()");
                while (it.hasNext()) {
                    Object next = it.next();
                    Intrinsics.checkNotNullExpressionValue(next, "it.next()");
                    if (((Boolean) predicate.invoke((a) next)).booleanValue()) {
                        it.remove();
                        return true;
                    }
                }
                Unit unit = Unit.INSTANCE;
                return false;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a(com.tencent.luggage.wxa.a5.b message) {
        Object obj;
        Intrinsics.checkNotNullParameter(message, "message");
        Iterator it = f120846c.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            } else {
                obj = it.next();
                if (Intrinsics.areEqual(((com.tencent.luggage.wxa.c5.e) obj).getAppId(), message.b())) {
                    break;
                }
            }
        }
        com.tencent.luggage.wxa.c5.e eVar = (com.tencent.luggage.wxa.c5.e) obj;
        boolean z16 = true;
        if (eVar != null) {
            if (message instanceof com.tencent.luggage.wxa.a5.a) {
                com.tencent.luggage.wxa.a5.a aVar = (com.tencent.luggage.wxa.a5.a) message;
                String a16 = aVar.a();
                if (!(a16 == null || a16.length() == 0)) {
                    String a17 = aVar.a();
                    com.tencent.luggage.wxa.j4.d S = eVar.S();
                    if (!StringUtils.equals(a17, S != null ? S.k() : null)) {
                        z16 = false;
                    }
                }
            }
            if (z16) {
                w.d("Luggage.LuggageClientProcessMessageDispatcher", "runtime:" + eVar + " dispatch: dispatch message[" + message + "] appId[" + message.b() + "] success");
                message.a(eVar);
                return;
            }
            return;
        }
        com.tencent.luggage.wxa.c5.b a18 = com.tencent.luggage.wxa.c5.c.a(message.b());
        if (a18 != null && (message instanceof com.tencent.luggage.wxa.a5.d)) {
            ((com.tencent.luggage.wxa.a5.d) message).a(a18);
            return;
        }
        w.h("Luggage.LuggageClientProcessMessageDispatcher", "dispatch: dispatch message[%s]appId[%s] fail", message.getClass().getSimpleName(), message.b());
        if (message instanceof com.tencent.luggage.wxa.a5.a) {
            f120845b.a(new a(message.b(), ((com.tencent.luggage.wxa.a5.a) message).a()));
        }
    }
}
