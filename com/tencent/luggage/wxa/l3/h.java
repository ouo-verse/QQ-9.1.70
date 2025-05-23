package com.tencent.luggage.wxa.l3;

import android.content.Context;
import android.content.Intent;
import com.tencent.luggage.wxa.fd.n;
import com.tencent.luggage.wxa.ka.o;
import com.tencent.luggage.wxa.r6.e;
import com.tencent.luggage.wxa.tn.f0;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.z4.k;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class h extends d {

    /* renamed from: i, reason: collision with root package name */
    public static final a f132999i = new a(null);

    /* renamed from: h, reason: collision with root package name */
    public final g[] f133000h;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final h a() {
            com.tencent.luggage.wxa.z4.f a16 = com.tencent.luggage.wxa.z4.f.f146283b.a();
            Intrinsics.checkNotNull(a16, "null cannot be cast to non-null type com.tencent.luggage.launch.task.WxaProcessManager<PROCESS of com.tencent.luggage.launch.task.WxaProcessManager.Companion.getInstance, PARAM of com.tencent.luggage.launch.task.WxaProcessManager.Companion.getInstance>");
            return (h) a16;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b implements com.tencent.luggage.wxa.ka.i {

        /* renamed from: a, reason: collision with root package name */
        public static final b f133001a = new b();

        @Override // com.tencent.luggage.wxa.ka.i
        public final void a(com.tencent.luggage.wxa.va.e eVar) {
        }
    }

    public h(g[] processes) {
        Intrinsics.checkNotNullParameter(processes, "processes");
        this.f133000h = processes;
    }

    public final List b(int i3) {
        if (i3 >= 0 && i3 <= g().size()) {
            List subList = g().subList(i3, g().size());
            ArrayList arrayList = new ArrayList();
            for (Object obj : subList) {
                if (((g) obj).j()) {
                    arrayList.add(obj);
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                o.a(((g) it.next()).e(), com.tencent.luggage.wxa.va.e.f143316a, com.tencent.luggage.wxa.l3.a.class, b.f133001a);
            }
            return g().subList(0, i3);
        }
        return g();
    }

    @Override // com.tencent.luggage.wxa.z4.f
    public void c(com.tencent.luggage.wxa.z4.g record) {
        Intrinsics.checkNotNullParameter(record, "record");
        com.tencent.luggage.wxa.z4.e.a(a(record), new e(record.a()), (Function0) null, 2, (Object) null);
    }

    @Override // com.tencent.luggage.wxa.z4.f
    public void d(com.tencent.luggage.wxa.z4.g record) {
        Intrinsics.checkNotNullParameter(record, "record");
        com.tencent.luggage.wxa.z4.e.a(a(record), new f(record.a(), record.d(), null, false, 0, 28, null), (Function0) null, 2, (Object) null);
    }

    @Override // com.tencent.luggage.wxa.z4.f
    public void e(com.tencent.luggage.wxa.z4.g record) {
        Intrinsics.checkNotNullParameter(record, "record");
        ((g) a(record)).a(new f(record.a(), record.d(), null, false, 0, 28, null));
    }

    public final String[] j() {
        List g16 = g();
        ArrayList arrayList = new ArrayList();
        Iterator it = g16.iterator();
        while (it.hasNext()) {
            String e16 = ((g) it.next()).e();
            if (e16 != null) {
                arrayList.add(e16);
            }
        }
        Object[] array = arrayList.toArray(new String[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return (String[]) array;
    }

    public final boolean k() {
        return f0.c("WxaTaskManager.permissionRequested", 2).getBoolean("WxaTaskManager.permissionRequested", false);
    }

    @Override // com.tencent.luggage.wxa.z4.f
    public boolean a(j params) {
        Intrinsics.checkNotNullParameter(params, "params");
        return params.f().f124098p;
    }

    @Override // com.tencent.luggage.wxa.z4.f
    public void a(Context context, Intent intent, j params, k strategy, com.tencent.luggage.wxa.z4.g appRecord) {
        String a16;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(strategy, "strategy");
        Intrinsics.checkNotNullParameter(appRecord, "appRecord");
        com.tencent.luggage.wxa.d6.b f16 = params.f();
        f16.f124099q = intent.getIntExtra(MiniAppCmdUtil.KEY_INDEX, -1);
        i.a(f16, intent, "action");
        com.tencent.luggage.wxa.bk.e j3 = params.j();
        if (j3 != null) {
            intent.putExtra("statObject", j3);
        }
        n i3 = params.i();
        if (i3 != null) {
            intent.putExtra(com.tencent.luggage.wxa.c8.c.f123370d0, i3);
        }
        com.tencent.luggage.wxa.ki.a a17 = com.tencent.luggage.wxa.m3.a.a(f16, params.j());
        if (params.k()) {
            intent.putExtra("fullyPreparedInitConfig", params.b());
            a16 = params.c();
        } else {
            a16 = e.a.a(com.tencent.luggage.wxa.r6.e.f139295y, a17, strategy, null, 4, null);
        }
        intent.putExtra("wxaLaunchInstanceId", a16);
        String d16 = a17.d();
        boolean z16 = false;
        if (!(d16 == null || d16.length() == 0)) {
            intent.putExtra("visitingSessionId", a17.d());
        }
        intent.putExtra("intentForStartWxa", true);
        intent.putExtra("reloadIfExist", params.h());
        if (k()) {
            com.tencent.luggage.wxa.fa.b.a(context, intent);
            context.startActivity(intent);
        } else {
            com.tencent.luggage.wxa.k0.d.a(com.tencent.luggage.wxa.h1.e.a(com.tencent.luggage.wxa.l3.b.class));
            com.tencent.luggage.wxa.fa.b.a(context, intent);
            context.startActivity(intent);
            z16 = true;
        }
        w.d("Luggage.WxaProcessManager", "startApp, appId:" + f16.f124086d + ", versionType:" + f16.f124090h + ", startByProxy:" + z16 + ", strategy:" + strategy + ", path:" + f16.f124089g + ", instanceId:" + a16);
    }

    @Override // com.tencent.luggage.wxa.z4.f
    public void a(com.tencent.luggage.wxa.z4.c killType, Set processes) {
        Intrinsics.checkNotNullParameter(killType, "killType");
        Intrinsics.checkNotNullParameter(processes, "processes");
        Iterator it = processes.iterator();
        while (it.hasNext()) {
            ((g) it.next()).k();
        }
    }
}
