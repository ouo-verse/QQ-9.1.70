package com.tencent.zplan.luabridge;

import android.os.Handler;
import androidx.annotation.Keep;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.ams.dynamicwidget.report.LinkReportConstant$GlobalKey;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import com.tencent.zplan.luabridge.LuaBasePlugin;
import com.tencent.zplan.utils.ZLog;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;
import p0.d;
import tl.h;

@Keep
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\t\b\u0017\u0018\u0000 \u00152\u00020\u0001:\u0003\u0016\u0017\u0018B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016J\u001a\u0010\n\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0016J\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0005R\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR \u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00100\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/zplan/luabridge/LuaBasePlugin;", "Lp0/d;", "", "parseEvents", "", "", "getEvents", AdMetricTag.EVENT_NAME, "Lp0/a;", "argument", "handleEvent", "handleEventReal", "", LinkReportConstant$GlobalKey.EVENTS, "Ljava/util/List;", "", "Lcom/tencent/zplan/luabridge/LuaBasePlugin$MethodWrapper;", "handlers", "Ljava/util/Map;", "<init>", "()V", "Companion", "a", "MethodWrapper", "b", "zplan_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public class LuaBasePlugin implements d {

    @NotNull
    public static final String ASYNC = "_async_";

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = "[zplan][ZPlanLuaBridge][LuaPlugin]";
    private static final Lazy enableDefaultAsyncMode$delegate;
    private static final Lazy luaAsyncHandler$delegate;
    private final List<String> events = new ArrayList();
    private final Map<String, MethodWrapper> handlers = new LinkedHashMap();

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0014\u001a\u00020\u0006\u0012\u0006\u0010\u0017\u001a\u00020\u0015\u0012\u0006\u0010\u0019\u001a\u00020\u0010\u0012\u0006\u0010\u001a\u001a\u00020\u0010\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\tJ\t\u0010\f\u001a\u00020\u0006H\u00d6\u0001J\t\u0010\u000e\u001a\u00020\rH\u00d6\u0001J\u0013\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0014\u0010\u0014\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0017\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0016R\u0014\u0010\u0019\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0018R\u0014\u0010\u001a\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0018\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/zplan/luabridge/LuaBasePlugin$MethodWrapper;", "", "Lcom/tencent/zplan/luabridge/LuaBasePlugin$b;", "task", "", "c", "", "d", "obj", "Lp0/a;", "argument", "b", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", AdMetricTag.EVENT_NAME, "Ljava/lang/reflect/Method;", "Ljava/lang/reflect/Method;", "method", "Z", "checkAsync", "defaultAsync", "<init>", "(Ljava/lang/String;Ljava/lang/reflect/Method;ZZ)V", "zplan_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes27.dex */
    public static final /* data */ class MethodWrapper {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final String eventName;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final Method method;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean checkAsync;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean defaultAsync;

        public MethodWrapper(@NotNull String eventName, @NotNull Method method, boolean z16, boolean z17) {
            Intrinsics.checkNotNullParameter(eventName, "eventName");
            Intrinsics.checkNotNullParameter(method, "method");
            this.eventName = eventName;
            this.method = method;
            this.checkAsync = z16;
            this.defaultAsync = z17;
        }

        private final void c(final b task) {
            Companion companion = LuaBasePlugin.INSTANCE;
            Handler g16 = companion.g();
            if (g16 != null) {
                task.b(companion.h());
                g16.post(new Runnable() { // from class: com.tencent.zplan.luabridge.LuaBasePlugin$MethodWrapper$invokeAsync$1
                    @Override // java.lang.Runnable
                    public final void run() {
                        LuaBasePlugin.b bVar = LuaBasePlugin.b.this;
                        LuaBasePlugin.Companion companion2 = LuaBasePlugin.INSTANCE;
                        bVar.d(companion2.h());
                        LuaBasePlugin.b.this.a().invoke();
                        LuaBasePlugin.b.this.c(companion2.h());
                        ZLog.f386189b.i("[zplan][ZPlanLuaBridge][LuaPlugin]", 2, "async " + LuaBasePlugin.b.this);
                    }
                });
            } else {
                d(task);
            }
        }

        private final String d(b task) {
            return task.a().invoke();
        }

        @Nullable
        public final String b(@NotNull final Object obj, @NotNull final p0.a argument) {
            Intrinsics.checkNotNullParameter(obj, "obj");
            Intrinsics.checkNotNullParameter(argument, "argument");
            b bVar = new b(this.eventName, new Function0<String>() { // from class: com.tencent.zplan.luabridge.LuaBasePlugin$MethodWrapper$invoke$task$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                @Nullable
                public final String invoke() {
                    Method method;
                    method = LuaBasePlugin.MethodWrapper.this.method;
                    return (String) method.invoke(obj, argument);
                }
            });
            if (this.checkAsync) {
                if (LuaBasePlugin.INSTANCE.e(argument.getParams())) {
                    c(bVar);
                    return null;
                }
                return d(bVar);
            }
            if (LuaBasePlugin.INSTANCE.f() && this.defaultAsync) {
                c(bVar);
                return null;
            }
            return d(bVar);
        }

        public boolean equals(@Nullable Object other) {
            if (this != other) {
                if (other instanceof MethodWrapper) {
                    MethodWrapper methodWrapper = (MethodWrapper) other;
                    if (!Intrinsics.areEqual(this.eventName, methodWrapper.eventName) || !Intrinsics.areEqual(this.method, methodWrapper.method) || this.checkAsync != methodWrapper.checkAsync || this.defaultAsync != methodWrapper.defaultAsync) {
                        return false;
                    }
                    return true;
                }
                return false;
            }
            return true;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int i3;
            String str = this.eventName;
            int i16 = 0;
            if (str != null) {
                i3 = str.hashCode();
            } else {
                i3 = 0;
            }
            int i17 = i3 * 31;
            Method method = this.method;
            if (method != null) {
                i16 = method.hashCode();
            }
            int i18 = (i17 + i16) * 31;
            boolean z16 = this.checkAsync;
            int i19 = 1;
            int i26 = z16;
            if (z16 != 0) {
                i26 = 1;
            }
            int i27 = (i18 + i26) * 31;
            boolean z17 = this.defaultAsync;
            if (!z17) {
                i19 = z17 ? 1 : 0;
            }
            return i27 + i19;
        }

        @NotNull
        public String toString() {
            return "MethodWrapper(eventName=" + this.eventName + ", method=" + this.method + ", checkAsync=" + this.checkAsync + ", defaultAsync=" + this.defaultAsync + ")";
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\f\u0010\u0004\u001a\u00020\u0003*\u00020\u0002H\u0002J\"\u0010\n\u001a\u00020\t*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0003R\u0014\u0010\u000e\u001a\u00020\u000b8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\rR\u001b\u0010\u0013\u001a\u00020\u00038BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001d\u0010\u0018\u001a\u0004\u0018\u00010\u00148BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0019\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/zplan/luabridge/LuaBasePlugin$a;", "", "", "", "e", "Ljava/lang/reflect/Method;", AdMetricTag.EVENT_NAME, "checkAsync", "defaultAsync", "Lcom/tencent/zplan/luabridge/LuaBasePlugin$MethodWrapper;", "i", "", h.F, "()J", "timeMillis", "enableDefaultAsyncMode$delegate", "Lkotlin/Lazy;", "f", "()Z", "enableDefaultAsyncMode", "Landroid/os/Handler;", "luaAsyncHandler$delegate", "g", "()Landroid/os/Handler;", "luaAsyncHandler", "ASYNC", "Ljava/lang/String;", "TAG", "<init>", "()V", "zplan_debug"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.tencent.zplan.luabridge.LuaBasePlugin$a, reason: from kotlin metadata */
    /* loaded from: classes27.dex */
    public static final class Companion {
        Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean e(String str) {
            try {
                return new JSONObject(str).optBoolean(LuaBasePlugin.ASYNC, false);
            } catch (JSONException unused) {
                return false;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean f() {
            return ((Boolean) LuaBasePlugin.enableDefaultAsyncMode$delegate.getValue()).booleanValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Handler g() {
            return (Handler) LuaBasePlugin.luaAsyncHandler$delegate.getValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final long h() {
            return System.currentTimeMillis();
        }

        @NotNull
        public final MethodWrapper i(@NotNull Method wrap, @NotNull String eventName, boolean z16, boolean z17) {
            Intrinsics.checkNotNullParameter(wrap, "$this$wrap");
            Intrinsics.checkNotNullParameter(eventName, "eventName");
            return new MethodWrapper(eventName, wrap, z16, z17);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\u000e\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0014\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\"\u0010\u000b\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\u000e\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\u0006\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\"\u0010\u0011\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0006\u001a\u0004\b\u0010\u0010\b\"\u0004\b\u000f\u0010\nR\u0014\u0010\u0013\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0012R\u001f\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0005\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/zplan/luabridge/LuaBasePlugin$b;", "", "", "toString", "", "a", "J", "getCallFromScriptTime", "()J", "b", "(J)V", "callFromScriptTime", "getEvaluateStartTime", "d", "evaluateStartTime", "c", "getEvaluateEndTime", "evaluateEndTime", "Ljava/lang/String;", AdMetricTag.EVENT_NAME, "Lkotlin/Function0;", "e", "Lkotlin/jvm/functions/Function0;", "()Lkotlin/jvm/functions/Function0;", "block", "<init>", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "zplan_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes27.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private long callFromScriptTime;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private long evaluateStartTime;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private long evaluateEndTime;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final String eventName;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Function0<String> block;

        public b(@NotNull String eventName, @NotNull Function0<String> block) {
            Intrinsics.checkNotNullParameter(eventName, "eventName");
            Intrinsics.checkNotNullParameter(block, "block");
            this.eventName = eventName;
            this.block = block;
        }

        @NotNull
        public final Function0<String> a() {
            return this.block;
        }

        public final void b(long j3) {
            this.callFromScriptTime = j3;
        }

        public final void c(long j3) {
            this.evaluateEndTime = j3;
        }

        public final void d(long j3) {
            this.evaluateStartTime = j3;
        }

        @NotNull
        public String toString() {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(this.eventName + " -> ");
            sb5.append("scheduleTime:" + (this.evaluateStartTime - this.callFromScriptTime) + "ms, ");
            sb5.append("evaluateTime:" + (this.evaluateEndTime - this.evaluateStartTime) + "ms");
            String sb6 = sb5.toString();
            Intrinsics.checkNotNullExpressionValue(sb6, "StringBuilder().apply(builderAction).toString()");
            return sb6;
        }
    }

    static {
        Lazy lazy;
        Lazy lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.zplan.luabridge.LuaBasePlugin$Companion$enableDefaultAsyncMode$2
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Boolean invoke() {
                return Boolean.valueOf(invoke2());
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final boolean invoke2() {
                Object a16 = mx4.a.f417748a.a(zx4.d.class);
                Intrinsics.checkNotNull(a16);
                return ((zx4.d) a16).n();
            }
        });
        enableDefaultAsyncMode$delegate = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<Handler>() { // from class: com.tencent.zplan.luabridge.LuaBasePlugin$Companion$luaAsyncHandler$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final Handler invoke() {
                try {
                    BaseHandlerThread baseHandlerThread = new BaseHandlerThread("ZPlan-LuaBridge");
                    baseHandlerThread.setPriority(8);
                    baseHandlerThread.start();
                    return new Handler(baseHandlerThread.getLooper());
                } catch (OutOfMemoryError e16) {
                    ZLog.f386189b.g("[zplan][ZPlanLuaBridge][LuaPlugin]", "create luaAsyncHandler OOM", e16);
                    return null;
                }
            }
        });
        luaAsyncHandler$delegate = lazy2;
    }

    public LuaBasePlugin() {
        parseEvents();
    }

    private final void parseEvents() {
        Method[] declaredMethods = getClass().getDeclaredMethods();
        if (declaredMethods != null) {
            for (Method method : declaredMethods) {
                if (method.isAnnotationPresent(LuaEvent.class)) {
                    LuaEvent luaEvent = (LuaEvent) method.getAnnotation(LuaEvent.class);
                    String value = luaEvent.value();
                    boolean checkAsync = luaEvent.checkAsync();
                    boolean defaultAsync = luaEvent.defaultAsync();
                    Intrinsics.checkNotNullExpressionValue(method, "method");
                    method.setAccessible(true);
                    if (!this.handlers.containsKey(value)) {
                        this.events.add(value);
                        this.handlers.put(value, INSTANCE.i(method, value, checkAsync, defaultAsync));
                    } else {
                        throw new Exception("both " + this.handlers.get(value) + " and " + method + " can handle event:" + value);
                    }
                }
            }
            ZLog.f386189b.i(TAG, 1, this + " can handle events:" + this.events);
        }
    }

    @Override // p0.d
    @NotNull
    public List<String> getEvents() {
        return this.events;
    }

    @Override // p0.d
    @Nullable
    public String handleEvent(@NotNull String eventName, @NotNull p0.a argument) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(argument, "argument");
        ux4.b bVar = ux4.b.f440566e;
        if (bVar.k(eventName)) {
            ZLog.f386189b.i(TAG, 1, this + " handle event:" + eventName + " by rpc");
            return bVar.b(eventName, argument);
        }
        return handleEventReal(argument, eventName);
    }

    @Nullable
    public final String handleEventReal(@NotNull p0.a argument, @NotNull String eventName) {
        Intrinsics.checkNotNullParameter(argument, "argument");
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        LuaArgument luaArgument = new LuaArgument(argument);
        MethodWrapper methodWrapper = this.handlers.get(eventName);
        if (methodWrapper != null) {
            try {
                return methodWrapper.b(this, luaArgument);
            } catch (Throwable th5) {
                ZLog.f386189b.e(TAG, 1, this + " handleEvent:" + eventName + ", params:" + luaArgument.getParams() + " exception", th5);
                return luaArgument.fail();
            }
        }
        return luaArgument.fail("no plugin handle");
    }
}
