package com.tencent.luggage.wxa.z4;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import com.tencent.luggage.wxa.ka.t;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.z;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.lang.StringUtils;

/* compiled from: P */
/* loaded from: classes9.dex */
public abstract class e {

    /* renamed from: g, reason: collision with root package name */
    public static final a f146274g = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final Set f146275a;

    /* renamed from: b, reason: collision with root package name */
    public AtomicBoolean f146276b;

    /* renamed from: c, reason: collision with root package name */
    public final String f146277c;

    /* renamed from: d, reason: collision with root package name */
    public i f146278d;

    /* renamed from: e, reason: collision with root package name */
    public i f146279e;

    /* renamed from: f, reason: collision with root package name */
    public final t f146280f;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class b implements t {
        public b() {
        }

        @Override // com.tencent.luggage.wxa.ka.t
        public final void a() {
            boolean j3 = e.this.j();
            if (j3) {
                new com.tencent.luggage.wxa.z4.a(e.this).c();
                e.this.l();
            }
            e.this.f146276b.set(false);
            w.d("Luggage.LuggageMiniProgramProcess", "[%s] died, isAliveBefore[%b]", e.this.e(), Boolean.valueOf(j3));
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class c implements com.tencent.luggage.wxa.ka.i {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0 f146282a;

        public c(Function0 function0) {
            this.f146282a = function0;
        }

        @Override // com.tencent.luggage.wxa.ka.i
        public final void a(com.tencent.luggage.wxa.va.e eVar) {
            Function0 function0 = this.f146282a;
            if (function0 != null) {
                function0.invoke();
            }
        }
    }

    public e() {
        Set newSetFromMap = Collections.newSetFromMap(new ConcurrentHashMap());
        Intrinsics.checkNotNullExpressionValue(newSetFromMap, "newSetFromMap(ConcurrentHashMap())");
        this.f146275a = newSetFromMap;
        this.f146276b = new AtomicBoolean(false);
        this.f146278d = i.NIL;
        this.f146279e = i.f146315a.a();
        this.f146280f = new b();
    }

    public abstract boolean a(com.tencent.luggage.wxa.z4.c cVar);

    public final Collection b() {
        int collectionSizeOrDefault;
        Set set = this.f146275a;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(set, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator it = set.iterator();
        while (it.hasNext()) {
            arrayList.add(((g) it.next()).a());
        }
        return new ArrayList(arrayList);
    }

    public abstract void b(g gVar);

    public final Collection c() {
        return new ArrayList(this.f146275a);
    }

    public abstract Class d();

    public final String e() {
        String str = this.f146277c;
        if (str == null) {
            return f146274g.a(f());
        }
        return str;
    }

    public abstract Class f();

    public final i g() {
        return this.f146278d;
    }

    public final void h() {
        String e16 = e();
        if (e16 != null) {
            AtomicBoolean atomicBoolean = this.f146276b;
            a aVar = f146274g;
            Context c16 = z.c();
            Intrinsics.checkNotNullExpressionValue(c16, "getContext()");
            atomicBoolean.set(aVar.a(c16, e16));
        }
    }

    public final boolean i() {
        return this.f146275a.isEmpty();
    }

    public final boolean j() {
        return this.f146276b.get();
    }

    public void k() {
        ActivityManager activityManager;
        Object systemService = z.c().getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
        if (systemService instanceof ActivityManager) {
            activityManager = (ActivityManager) systemService;
        } else {
            activityManager = null;
        }
        if (activityManager != null && SystemMethodProxy.getRunningAppProcesses(activityManager) != null) {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : SystemMethodProxy.getRunningAppProcesses(activityManager)) {
                String str = runningAppProcessInfo.processName;
                if (str != null && Intrinsics.areEqual(str, e())) {
                    w.d("Luggage.LuggageMiniProgramProcess", "killProcess " + runningAppProcessInfo.processName + " pid:" + runningAppProcessInfo.pid);
                    try {
                        SystemMethodProxy.killProcess(runningAppProcessInfo.pid);
                        return;
                    } catch (Exception e16) {
                        w.b("Luggage.LuggageMiniProgramProcess", "killProcess " + runningAppProcessInfo.processName + " pid:" + runningAppProcessInfo.pid + " error:" + e16.getMessage());
                        return;
                    }
                }
            }
            return;
        }
        w.f("Luggage.LuggageMiniProgramProcess", "killProcess fail, am is null or runningAppProcesses is null");
    }

    public void l() {
        this.f146278d = i.NIL;
        a();
        h();
    }

    public final void m() {
        com.tencent.luggage.wxa.ka.o.a(e(), new com.tencent.luggage.wxa.va.d(e()), com.tencent.luggage.wxa.z4.b.class);
        com.tencent.luggage.wxa.ka.o.a(e(), this.f146280f);
        this.f146276b.set(true);
    }

    public String toString() {
        return "LuggageMiniProgramProcess(appList=" + this.f146275a + ", isProcessAlive=" + this.f146276b + ", processName='" + e() + "', usedAs=" + this.f146278d + ", isNoAppAttached=" + i() + ", allAppId=" + b() + ", supportType=" + this.f146279e + ", uiClass=" + f() + ", pluginUIClass=" + d() + ')';
    }

    public final void a(i iVar) {
        Intrinsics.checkNotNullParameter(iVar, "<set-?>");
        this.f146278d = iVar;
    }

    public final void a() {
        this.f146275a.clear();
    }

    public final g a(String appId, boolean z16, int i3, String instanceId, com.tencent.luggage.wxa.fd.i initConfig) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(instanceId, "instanceId");
        Intrinsics.checkNotNullParameter(initConfig, "initConfig");
        g a16 = a(this, appId, 0, 2, (Object) null);
        if (a16 != null && a16.f() == z16 && a16.b() == i3) {
            w.d("Luggage.LuggageMiniProgramProcess", "registerApp: use existed");
        } else {
            w.d("Luggage.LuggageMiniProgramProcess", "registerApp: createRecord stack:[%s]", Log.getStackTraceString(new Throwable()));
            a16 = a(appId, i3, initConfig, z16);
        }
        w.d("Luggage.LuggageMiniProgramProcess", "registerApp: appId[%s]isPersistent[%s]record_hash[%s]instanceId[%s]", appId, Boolean.valueOf(z16), Integer.valueOf(a16.hashCode()), instanceId);
        a16.a(instanceId);
        if (!this.f146275a.add(a16)) {
            w.f("Luggage.LuggageMiniProgramProcess", "registerApp: " + a16 + " already added");
        }
        return a16;
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean a(Context context, String process) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(process, "process");
            if (StringUtils.equals(z.i(), process)) {
                return true;
            }
            try {
                Object systemService = context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
                Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
                Iterator<ActivityManager.RunningAppProcessInfo> it = SystemMethodProxy.getRunningAppProcesses((ActivityManager) systemService).iterator();
                while (it.hasNext()) {
                    String str = it.next().processName;
                    if (str != null && Intrinsics.areEqual(str, process)) {
                        return true;
                    }
                }
            } catch (Exception e16) {
                w.h("Luggage.LuggageMiniProgramProcess", "isProcessRunning: ", Log.getStackTraceString(e16));
            }
            return false;
        }

        public final String a(Class clazz) {
            Intrinsics.checkNotNullParameter(clazz, "clazz");
            try {
                PackageManager packageManager = z.c().getPackageManager();
                ActivityInfo activityInfo = packageManager != null ? packageManager.getActivityInfo(new ComponentName(z.c(), (Class<?>) clazz), 128) : null;
                if (activityInfo != null) {
                    String str = activityInfo.processName;
                    if (str != null) {
                        return str;
                    }
                }
                return "";
            } catch (PackageManager.NameNotFoundException e16) {
                w.b("Luggage.LuggageMiniProgramProcess", "processNameOfComponent: catch cmpClass[" + clazz + "] " + e16.getMessage());
                return null;
            }
        }
    }

    public final boolean b(i type) {
        Intrinsics.checkNotNullParameter(type, "type");
        return this.f146279e == i.f146315a.a() || this.f146279e == type;
    }

    public g a(String appId, int i3, String instanceId, com.tencent.luggage.wxa.fd.i initConfig, boolean z16) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(instanceId, "instanceId");
        Intrinsics.checkNotNullParameter(initConfig, "initConfig");
        return a(appId, z16, i3, instanceId, initConfig);
    }

    public g a(String appId, int i3, com.tencent.luggage.wxa.fd.i cfg, boolean z16) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(cfg, "cfg");
        return new g(appId, i3, h.INIT, cfg, z16);
    }

    public final void a(g record) {
        Intrinsics.checkNotNullParameter(record, "record");
        if (record.f()) {
            w.d("Luggage.LuggageMiniProgramProcess", "detachApp: [%s][%d] is persistent, do not detach", record.a(), Integer.valueOf(record.b()));
            return;
        }
        if (!this.f146275a.remove(record)) {
            w.h("Luggage.LuggageMiniProgramProcess", "detachApp: detach[%s] fail", record);
        }
        if (i()) {
            l();
        }
    }

    public final void a(String appId, boolean z16) {
        Set set;
        Intrinsics.checkNotNullParameter(appId, "appId");
        Set set2 = this.f146275a;
        ArrayList arrayList = new ArrayList();
        for (Object obj : set2) {
            if (Intrinsics.areEqual(((g) obj).a(), appId)) {
                arrayList.add(obj);
            }
        }
        set = CollectionsKt___CollectionsKt.toSet(arrayList);
        if (z16) {
            Iterator it = set.iterator();
            while (it.hasNext()) {
                b((g) it.next());
            }
        }
        set2.removeAll(set);
    }

    public final void a(String excludeInstanceId, String appId, boolean z16) {
        Set set;
        Intrinsics.checkNotNullParameter(excludeInstanceId, "excludeInstanceId");
        Intrinsics.checkNotNullParameter(appId, "appId");
        Set set2 = this.f146275a;
        ArrayList arrayList = new ArrayList();
        for (Object obj : set2) {
            g gVar = (g) obj;
            if (Intrinsics.areEqual(gVar.a(), appId) && !Intrinsics.areEqual(gVar.d(), excludeInstanceId)) {
                arrayList.add(obj);
            }
        }
        set = CollectionsKt___CollectionsKt.toSet(arrayList);
        if (z16) {
            Iterator it = set.iterator();
            while (it.hasNext()) {
                b((g) it.next());
            }
        }
        set2.removeAll(set);
    }

    public static /* synthetic */ g a(e eVar, String str, int i3, int i16, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: findAppRecord");
        }
        if ((i16 & 2) != 0) {
            i3 = -1;
        }
        return eVar.a(str, i3);
    }

    public final g a(String appId, int i3) {
        Object obj;
        Intrinsics.checkNotNullParameter(appId, "appId");
        Iterator it = this.f146275a.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            g gVar = (g) obj;
            if (Intrinsics.areEqual(gVar.a(), appId) && (-1 == i3 || gVar.b() == i3)) {
                break;
            }
        }
        return (g) obj;
    }

    public static /* synthetic */ void a(e eVar, com.tencent.luggage.wxa.a5.b bVar, Function0 function0, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sendMessageToLuggageProcess");
        }
        if ((i3 & 2) != 0) {
            function0 = null;
        }
        eVar.a(bVar, function0);
    }

    public final void a(com.tencent.luggage.wxa.a5.b message, Function0 function0) {
        Intrinsics.checkNotNullParameter(message, "message");
        com.tencent.luggage.wxa.ka.o.a(e(), message, o.class, new c(function0));
    }

    public final void a(com.tencent.luggage.wxa.a5.b message) {
        Intrinsics.checkNotNullParameter(message, "message");
        com.tencent.luggage.wxa.ka.o.a(e(), message, m.class);
    }
}
