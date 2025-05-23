package com.tencent.luggage.wxa.u7;

import android.util.LongSparseArray;
import androidx.collection.ArraySet;
import com.tencent.luggage.wxa.i3.x;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxaapi.LaunchWxaAppResult;
import com.tencent.luggage.wxaapi.d;
import com.tencent.luggage.wxaapi.e;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class b {

    /* renamed from: a */
    public static final b f142127a = new b();

    /* renamed from: b */
    public static final LongSparseArray f142128b = new LongSparseArray();

    /* renamed from: c */
    public static final ArraySet f142129c = new ArraySet();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {

        /* renamed from: a */
        public final String f142130a;

        /* renamed from: b */
        public final String f142131b;

        /* renamed from: c */
        public final int f142132c;

        /* renamed from: d */
        public final d f142133d;

        public a(String str, String str2, int i3, d dVar) {
            this.f142130a = str;
            this.f142131b = str2;
            this.f142132c = i3;
            this.f142133d = dVar;
        }

        public final String a() {
            return this.f142130a;
        }

        public final int b() {
            return this.f142132c;
        }

        public final d c() {
            return this.f142133d;
        }

        public final d d() {
            return this.f142133d;
        }

        public final String e() {
            return this.f142131b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (Intrinsics.areEqual(this.f142130a, aVar.f142130a) && Intrinsics.areEqual(this.f142131b, aVar.f142131b) && this.f142132c == aVar.f142132c && Intrinsics.areEqual(this.f142133d, aVar.f142133d)) {
                return true;
            }
            return false;
        }

        public final int f() {
            return this.f142132c;
        }

        public int hashCode() {
            int hashCode;
            int hashCode2;
            String str = this.f142130a;
            int i3 = 0;
            if (str == null) {
                hashCode = 0;
            } else {
                hashCode = str.hashCode();
            }
            int i16 = hashCode * 31;
            String str2 = this.f142131b;
            if (str2 == null) {
                hashCode2 = 0;
            } else {
                hashCode2 = str2.hashCode();
            }
            int i17 = (((i16 + hashCode2) * 31) + this.f142132c) * 31;
            d dVar = this.f142133d;
            if (dVar != null) {
                i3 = dVar.hashCode();
            }
            return i17 + i3;
        }

        public String toString() {
            return "Request(wxaAppID=" + this.f142130a + ", userName=" + this.f142131b + ", versionType=" + this.f142132c + ", listener=" + this.f142133d + ')';
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.u7.b$b */
    /* loaded from: classes8.dex */
    public static final class C6787b extends Lambda implements Function1 {

        /* renamed from: a */
        public final /* synthetic */ String f142134a;

        /* renamed from: b */
        public final /* synthetic */ int f142135b;

        /* renamed from: c */
        public final /* synthetic */ long f142136c;

        /* renamed from: d */
        public final /* synthetic */ boolean f142137d;

        /* renamed from: e */
        public final /* synthetic */ boolean f142138e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C6787b(String str, int i3, long j3, boolean z16, boolean z17) {
            super(1);
            this.f142134a = str;
            this.f142135b = i3;
            this.f142136c = j3;
            this.f142137d = z16;
            this.f142138e = z17;
        }

        public final void a(com.tencent.luggage.wxaapi.c it) {
            Intrinsics.checkNotNullParameter(it, "it");
            String str = this.f142134a;
            Intrinsics.checkNotNull(str);
            it.a(str, this.f142135b, this.f142136c, true, this.f142137d, this.f142138e);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((com.tencent.luggage.wxaapi.c) obj);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class c extends Lambda implements Function1 {

        /* renamed from: a */
        public final /* synthetic */ String f142139a;

        /* renamed from: b */
        public final /* synthetic */ int f142140b;

        /* renamed from: c */
        public final /* synthetic */ long f142141c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(String str, int i3, long j3) {
            super(1);
            this.f142139a = str;
            this.f142140b = i3;
            this.f142141c = j3;
        }

        public final void a(com.tencent.luggage.wxaapi.c it) {
            Intrinsics.checkNotNullParameter(it, "it");
            String str = this.f142139a;
            Intrinsics.checkNotNull(str);
            it.a(str, this.f142140b, this.f142141c, false, false, false);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((com.tencent.luggage.wxaapi.c) obj);
            return Unit.INSTANCE;
        }
    }

    public final void a(long j3, String str, String str2) {
        LongSparseArray longSparseArray = f142128b;
        synchronized (longSparseArray) {
            a aVar = (a) longSparseArray.get(j3);
            w.d("Luggage.WxaAppLaunchListenersStore", "fixRequest old=" + aVar + " timestampNs=" + j3 + " wxaAppID=" + str + " userName=" + str2);
            if (aVar != null) {
                if (str2 == null) {
                    str2 = aVar.e();
                }
                longSparseArray.put(j3, new a(str, str2, aVar.f(), aVar.d()));
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void b(long j3) {
        w.d("Luggage.WxaAppLaunchListenersStore", "publishMiniGameUnsupported timestampNs:" + j3);
        a(j3, LaunchWxaAppResult.FailMiniGameNotSupported);
    }

    public final void c(long j3) {
        a aVar;
        e eVar;
        LongSparseArray longSparseArray = f142128b;
        synchronized (longSparseArray) {
            aVar = (a) longSparseArray.get(j3);
        }
        if (aVar != null) {
            String a16 = aVar.a();
            int b16 = aVar.b();
            d c16 = aVar.c();
            if (c16 instanceof e) {
                eVar = (e) c16;
            } else {
                eVar = null;
            }
            if (eVar != null) {
                eVar.onLaunchResourcePrepareCompleted(a16, b16, j3);
            }
        }
    }

    public final void d(long j3) {
        w.d("Luggage.WxaAppLaunchListenersStore", "publishWarmLaunchCompleted timestampNs:" + j3);
        c(j3);
        a a16 = a(j3);
        if (a16 != null) {
            String a17 = a16.a();
            int b16 = a16.b();
            d c16 = a16.c();
            w.a("Luggage.WxaAppLaunchListenersStore", "publishWarmLaunchCompleted timestampNs:" + j3 + " wxaAppID:" + a17);
            f142127a.a(new c(a17, b16, j3));
            if (c16 != null) {
                c16.onLaunchResult(a17, b16, j3, LaunchWxaAppResult.OK);
            }
        }
    }

    public final void b(com.tencent.luggage.wxaapi.c cVar) {
        if (cVar == null) {
            return;
        }
        ArraySet arraySet = f142129c;
        synchronized (arraySet) {
            arraySet.remove(cVar);
        }
    }

    public static /* synthetic */ void a(b bVar, long j3, String str, String str2, int i3, d dVar, int i16, Object obj) {
        bVar.a(j3, (i16 & 2) != 0 ? null : str, (i16 & 4) != 0 ? null : str2, (i16 & 8) != 0 ? 0 : i3, (i16 & 16) != 0 ? null : dVar);
    }

    public final void a(long j3, String str, String str2, int i3, d dVar) {
        LongSparseArray longSparseArray = f142128b;
        synchronized (longSparseArray) {
            a aVar = (a) longSparseArray.get(j3);
            if (dVar == null) {
                dVar = aVar != null ? aVar.d() : null;
            }
            longSparseArray.put(j3, new a(str, str2, i3, dVar));
            Unit unit = Unit.INSTANCE;
        }
    }

    public final a a(long j3) {
        Object obj;
        LongSparseArray longSparseArray = f142128b;
        synchronized (longSparseArray) {
            obj = longSparseArray.get(j3);
            longSparseArray.remove(j3);
            Unit unit = Unit.INSTANCE;
        }
        return (a) obj;
    }

    public final boolean a(long j3, LaunchWxaAppResult result) {
        Intrinsics.checkNotNullParameter(result, "result");
        a a16 = a(j3);
        if (a16 == null) {
            return false;
        }
        String a17 = a16.a();
        int b16 = a16.b();
        d c16 = a16.c();
        if (c16 == null) {
            return true;
        }
        c16.onLaunchResult(a17, b16, j3, result);
        return true;
    }

    public final void a(long j3, x.e eventGroup, x.d event, String str) {
        Intrinsics.checkNotNullParameter(eventGroup, "eventGroup");
        Intrinsics.checkNotNullParameter(event, "event");
        boolean z16 = false;
        if (eventGroup == x.e.START_UP && event == x.d.OK) {
            c(j3);
        } else {
            if (event == x.d.FAIL) {
                a(j3, LaunchWxaAppResult.Fail);
            } else if (event == x.d.CLOSE_BEFORE_START) {
                a(j3, LaunchWxaAppResult.Cancel);
            }
            z16 = true;
        }
        w.d("Luggage.WxaAppLaunchListenersStore", "publishTraceEvent timestampNs:" + j3 + ", group:" + eventGroup + ", event:" + event + ", message:" + str + ", hasCallback:" + z16);
    }

    public final void a(long j3, String reason, boolean z16) {
        boolean contains$default;
        Intrinsics.checkNotNullParameter(reason, "reason");
        boolean z17 = false;
        if (!z16) {
            LaunchWxaAppResult launchWxaAppResult = LaunchWxaAppResult.Fail;
            for (LaunchWxaAppResult launchWxaAppResult2 : LaunchWxaAppResult.values()) {
                contains$default = StringsKt__StringsKt.contains$default((CharSequence) reason, (CharSequence) launchWxaAppResult2.name(), false, 2, (Object) null);
                if (contains$default) {
                    launchWxaAppResult = launchWxaAppResult2;
                }
            }
            z17 = a(j3, launchWxaAppResult);
        }
        w.d("Luggage.WxaAppLaunchListenersStore", "publishExtraEvent timestampNs:" + j3 + ", reason:" + reason + ", success:" + z16 + ", hasCallback:" + z17);
    }

    public final void a(com.tencent.luggage.wxa.u7.a initReadyMetrics) {
        Intrinsics.checkNotNullParameter(initReadyMetrics, "initReadyMetrics");
        w.d("Luggage.WxaAppLaunchListenersStore", "publishColdLaunchInitReady " + initReadyMetrics);
        a a16 = a(initReadyMetrics.d());
        if (a16 != null) {
            String a17 = a16.a();
            int b16 = a16.b();
            d c16 = a16.c();
            long a18 = initReadyMetrics.a();
            f142127a.a(new C6787b(a17, b16, a18, initReadyMetrics.b(), initReadyMetrics.c()));
            if (c16 != null) {
                c16.onLaunchResult(a17, b16, a18, LaunchWxaAppResult.OK);
            }
        }
    }

    public final void a(com.tencent.luggage.wxaapi.c cVar) {
        if (cVar == null) {
            return;
        }
        ArraySet arraySet = f142129c;
        synchronized (arraySet) {
            arraySet.add(cVar);
        }
    }

    public final void a(Function1 function1) {
        ArraySet arraySet = f142129c;
        synchronized (arraySet) {
            if (arraySet.isEmpty()) {
                return;
            }
            ArraySet arraySet2 = new ArraySet(arraySet);
            Unit unit = Unit.INSTANCE;
            Iterator<E> it = arraySet2.iterator();
            while (it.hasNext()) {
                function1.invoke((com.tencent.luggage.wxaapi.c) it.next());
            }
        }
    }
}
