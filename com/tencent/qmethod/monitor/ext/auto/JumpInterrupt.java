package com.tencent.qmethod.monitor.ext.auto;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import com.tencent.qmethod.monitor.base.thread.ThreadManager;
import com.tencent.qmethod.monitor.base.util.d;
import com.tencent.qmethod.monitor.base.util.h;
import com.tencent.qmethod.monitor.config.ConfigManager;
import com.tencent.qmethod.monitor.config.bean.e;
import com.tencent.qmethod.monitor.report.PMonitorReporter;
import com.tencent.qmethod.monitor.report.SampleHelper;
import com.tencent.qmethod.pandoraex.api.n;
import com.tencent.qmethod.pandoraex.api.q;
import com.tencent.qmethod.pandoraex.api.t;
import com.tencent.qmethod.pandoraex.api.u;
import com.tencent.qmethod.pandoraex.core.o;
import com.tencent.qmethod.pandoraex.core.x;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0002\f\u0019B\t\b\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\n\u001a\u00020\tH\u0002J\u0006\u0010\u000b\u001a\u00020\u0002R\u0014\u0010\u000e\u001a\u00020\u00018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0010R\u001b\u0010\u0016\u001a\u00020\u00128FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0013\u0010\u0015\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/qmethod/monitor/ext/auto/JumpInterrupt;", "", "", "d", "Lorg/json/JSONObject;", "exInfo", "", "throwable", "f", "Lcom/tencent/qmethod/monitor/report/SampleHelper$SampleStatus;", "b", "e", "a", "Ljava/lang/Object;", "SAMPLE_LOCK", "Lcom/tencent/qmethod/monitor/ext/auto/JumpInterrupt$DispatchEvent;", "Lcom/tencent/qmethod/monitor/ext/auto/JumpInterrupt$DispatchEvent;", "dispatchEvent", "Landroid/os/Handler;", "c", "Lkotlin/Lazy;", "()Landroid/os/Handler;", "handler", "<init>", "()V", "DispatchEvent", "qmethod-privacy-monitor_tencentBuglyRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes22.dex */
public final class JumpInterrupt {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static DispatchEvent dispatchEvent;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy handler;

    /* renamed from: d, reason: collision with root package name */
    public static final JumpInterrupt f343605d = new JumpInterrupt();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static final Object SAMPLE_LOCK = new Object();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0011\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r\u00a2\u0006\u0004\b\u000f\u0010\u0010J+\u0010\b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005\u00a2\u0006\u0004\b\b\u0010\tJ+\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005\u00a2\u0006\u0004\b\u000b\u0010\f\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/qmethod/monitor/ext/auto/JumpInterrupt$DispatchEvent;", "", "activityManager", "Ljava/lang/reflect/Method;", "method", "", "args", "", "b", "(Ljava/lang/Object;Ljava/lang/reflect/Method;[Ljava/lang/Object;)Z", "", "a", "(Ljava/lang/Object;Ljava/lang/reflect/Method;[Ljava/lang/Object;)V", "Lcom/tencent/qmethod/monitor/ext/auto/b;", "process", "<init>", "(Lcom/tencent/qmethod/monitor/ext/auto/b;)V", "qmethod-privacy-monitor_tencentBuglyRelease"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes22.dex */
    public static final class DispatchEvent {
        public DispatchEvent(@Nullable b bVar) {
        }

        public final void a(@NotNull Object activityManager, @NotNull Method method, @NotNull Object[] args) {
            Intrinsics.checkParameterIsNotNull(activityManager, "activityManager");
            Intrinsics.checkParameterIsNotNull(method, "method");
            Intrinsics.checkParameterIsNotNull(args, "args");
            method.invoke(activityManager, Arrays.copyOf(args, args.length));
        }

        public final boolean b(@NotNull Object activityManager, @NotNull Method method, @NotNull Object[] args) {
            String str;
            String action;
            Intrinsics.checkParameterIsNotNull(activityManager, "activityManager");
            Intrinsics.checkParameterIsNotNull(method, "method");
            Intrinsics.checkParameterIsNotNull(args, "args");
            final JSONObject jSONObject = new JSONObject();
            boolean z16 = false;
            int i3 = 0;
            for (Object obj : args) {
                i3++;
                if (com.tencent.qmethod.monitor.a.f343451h.g().getDebug()) {
                    if (obj == null) {
                        o.a("DispatchEvent", "find null@param {" + i3 + '}');
                    } else {
                        o.a("DispatchEvent", '{' + obj.getClass().getName() + "}: " + obj);
                    }
                }
                if (obj instanceof Intent) {
                    Intent intent = (Intent) obj;
                    ComponentName component = intent.getComponent();
                    if (component != null) {
                        str = component.getPackageName();
                    } else {
                        str = null;
                    }
                    o.a("DispatchEvent", "target package=" + str);
                    if (str == null ? !((action = intent.getAction()) == null || !(!Intrinsics.areEqual(action, "android.content.pm.action.REQUEST_PERMISSIONS"))) : (!Intrinsics.areEqual(str, r6.g().getContext().getPackageName()))) {
                        z16 = true;
                    }
                    jSONObject.put("intent", obj.toString());
                }
            }
            if (z16) {
                final Throwable th5 = new Throwable();
                JumpInterrupt.f343605d.c().post(new Runnable() { // from class: com.tencent.qmethod.monitor.ext.auto.JumpInterrupt$DispatchEvent$shouldInterrupt$2
                    @Override // java.lang.Runnable
                    public final void run() {
                        JumpInterrupt.f343605d.f(JSONObject.this, th5);
                    }
                });
            }
            return false;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00132\u00020\u0001:\u0001\nB\u0017\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\r\u00a2\u0006\u0004\b\u0011\u0010\u0012J2\u0010\b\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\u0096\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\f\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/qmethod/monitor/ext/auto/JumpInterrupt$a;", "Ljava/lang/reflect/InvocationHandler;", "", "proxy", "Ljava/lang/reflect/Method;", "method", "", "args", "invoke", "(Ljava/lang/Object;Ljava/lang/reflect/Method;[Ljava/lang/Object;)Ljava/lang/Object;", "a", "Ljava/lang/Object;", "activityManager", "Lcom/tencent/qmethod/monitor/ext/auto/JumpInterrupt$DispatchEvent;", "b", "Lcom/tencent/qmethod/monitor/ext/auto/JumpInterrupt$DispatchEvent;", "dispatch", "<init>", "(Ljava/lang/Object;Lcom/tencent/qmethod/monitor/ext/auto/JumpInterrupt$DispatchEvent;)V", "c", "qmethod-privacy-monitor_tencentBuglyRelease"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes22.dex */
    public static final class a implements InvocationHandler {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final Object activityManager;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final DispatchEvent dispatch;

        public a(@NotNull Object activityManager, @NotNull DispatchEvent dispatch) {
            Intrinsics.checkParameterIsNotNull(activityManager, "activityManager");
            Intrinsics.checkParameterIsNotNull(dispatch, "dispatch");
            this.activityManager = activityManager;
            this.dispatch = dispatch;
        }

        @Override // java.lang.reflect.InvocationHandler
        @Nullable
        public Object invoke(@Nullable Object proxy, @NotNull Method method, @NotNull Object[] args) {
            Intrinsics.checkParameterIsNotNull(method, "method");
            Intrinsics.checkParameterIsNotNull(args, "args");
            o.a("AmsHookBinderInvocationHandler", "invoke " + method.getName());
            if (Intrinsics.areEqual("startActivity", method.getName()) && this.dispatch.b(this.activityManager, method, args)) {
                this.dispatch.a(this.activityManager, method, args);
                return 102;
            }
            return method.invoke(this.activityManager, Arrays.copyOf(args, args.length));
        }
    }

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0) new Function0<Handler>() { // from class: com.tencent.qmethod.monitor.ext.auto.JumpInterrupt$handler$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Handler invoke() {
                return new Handler(ThreadManager.f343506c.b());
            }
        });
        handler = lazy;
    }

    JumpInterrupt() {
    }

    private final SampleHelper.SampleStatus b() {
        double d16;
        int i3;
        ConfigManager configManager = ConfigManager.f343549h;
        e eVar = configManager.p().g().get("func_jump_interrupt");
        if (eVar != null) {
            d16 = eVar.getRate();
        } else {
            d16 = 0.0d;
        }
        double d17 = d16;
        e eVar2 = configManager.p().g().get("func_jump_interrupt");
        if (eVar2 != null) {
            i3 = eVar2.getMaxReport();
        } else {
            i3 = 0;
        }
        synchronized (SAMPLE_LOCK) {
            d dVar = d.f343534a;
            if (dVar.b(2, "KEY_JUMP_REPORT", i3)) {
                return SampleHelper.SampleStatus.GLOBAL_LIMIT;
            }
            if (!SampleHelper.z(SampleHelper.f343779l, d17, 0, 0, 6, null)) {
                return SampleHelper.SampleStatus.GLOBAL_RATE;
            }
            dVar.d(2, "KEY_JUMP_REPORT");
            Unit unit = Unit.INSTANCE;
            return SampleHelper.SampleStatus.PASS;
        }
    }

    private final void d() {
        Field declaredField;
        Class<?> cls;
        try {
            int i3 = Build.VERSION.SDK_INT;
            if (i3 <= 33) {
                if (dispatchEvent == null) {
                    return;
                }
                if (i3 >= 29) {
                    declaredField = Class.forName("android.app.ActivityTaskManager").getDeclaredField("IActivityTaskManagerSingleton");
                    Intrinsics.checkExpressionValueIsNotNull(declaredField, "activityTaskManagerClass\u2026ityTaskManagerSingleton\")");
                    cls = Class.forName("android.app.IActivityTaskManager");
                    Intrinsics.checkExpressionValueIsNotNull(cls, "Class.forName(\"android.app.IActivityTaskManager\")");
                } else if (i3 >= 26) {
                    declaredField = ActivityManager.class.getDeclaredField("IActivityManagerSingleton");
                    Intrinsics.checkExpressionValueIsNotNull(declaredField, "activityManagerClass.get\u2026ctivityManagerSingleton\")");
                    cls = Class.forName("android.app.IActivityManager");
                    Intrinsics.checkExpressionValueIsNotNull(cls, "Class.forName(\"android.app.IActivityManager\")");
                } else {
                    declaredField = Class.forName("android.app.ActivityManagerNative").getDeclaredField("gDefault");
                    Intrinsics.checkExpressionValueIsNotNull(declaredField, "activityManagerNative.getDeclaredField(\"gDefault\")");
                    cls = Class.forName("android.app.IActivityManager");
                    Intrinsics.checkExpressionValueIsNotNull(cls, "Class.forName(\"android.app.IActivityManager\")");
                }
                declaredField.setAccessible(true);
                Object obj = declaredField.get(null);
                Class<?> cls2 = Class.forName("android.util.Singleton");
                Field mInstanceField = cls2.getDeclaredField("mInstance");
                Intrinsics.checkExpressionValueIsNotNull(mInstanceField, "mInstanceField");
                mInstanceField.setAccessible(true);
                Object invoke = cls2.getDeclaredMethod("get", new Class[0]).invoke(obj, new Object[0]);
                if (invoke == null) {
                    o.a("JumpInterrupt", "get AM null!");
                    return;
                }
                DispatchEvent dispatchEvent2 = dispatchEvent;
                if (dispatchEvent2 != null) {
                    Object newProxyInstance = Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new a(invoke, dispatchEvent2));
                    if (newProxyInstance != null) {
                        mInstanceField.set(obj, newProxyInstance);
                        o.a("JumpInterrupt", "set proxy success");
                        return;
                    }
                    return;
                }
                return;
            }
            o.a("JumpInterrupt", "Unsupported Version");
        } catch (Exception e16) {
            o.d("JumpInterrupt", "Hook Failed", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f(JSONObject exInfo, Throwable throwable) {
        boolean z16;
        List<t> listOf;
        SampleHelper.SampleStatus b16 = b();
        if (SampleHelper.SampleStatus.PASS != b16) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            o.a("JumpInterrupt", "ignore report, because of " + b16);
        }
        if (!z16 && (q.j() instanceof PMonitorReporter)) {
            n j3 = q.j();
            if (j3 != null) {
                u uVar = new u("boot", "C#SA");
                uVar.f343970g = true;
                uVar.f343968e = "ban";
                uVar.f343967d = "illegal_scene";
                uVar.f343969f = false;
                t tVar = new t();
                tVar.f343962b = x.M(throwable, 2, 25);
                tVar.f343963c = 1;
                listOf = CollectionsKt__CollectionsJVMKt.listOf(tVar);
                uVar.f343980q = listOf;
                uVar.f343977n = System.currentTimeMillis();
                uVar.f343979p = com.tencent.qmethod.pandoraex.core.collector.utils.a.a();
                uVar.f343978o = "0.9.15-rc2+build.1";
                uVar.f343986w = exInfo;
                ((PMonitorReporter) j3).e(uVar);
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type com.tencent.qmethod.monitor.report.PMonitorReporter");
        }
    }

    @NotNull
    public final Handler c() {
        return (Handler) handler.getValue();
    }

    public final void e() {
        int i3;
        h hVar = h.f343541c;
        hVar.e("PMonitor#Jump");
        e eVar = ConfigManager.f343549h.p().g().get("func_jump_interrupt");
        if (eVar != null) {
            i3 = eVar.getMaxReport();
        } else {
            i3 = 0;
        }
        if (i3 == 0) {
            return;
        }
        com.tencent.qmethod.monitor.a.f343451h.g().a();
        dispatchEvent = new DispatchEvent(null);
        d();
        hVar.b("PMonitor#Jump");
    }
}
