package com.tencent.zplan.luabridge;

import androidx.annotation.Keep;
import com.epicgames.ue4.UE4;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.zplan.engine.service.ZPlanEngineService;
import com.tencent.zplan.luabridge.a;
import com.tencent.zplan.utils.ZLog;
import com.tencent.zplan.utils.e;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

@Keep
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010!\n\u0002\b\u0006\b\u00c7\u0002\u0018\u00002\u00020\u0001:\u0001+B\t\b\u0002\u00a2\u0006\u0004\b)\u0010*J!\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u000e\b\u0004\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0082\bJ\u0018\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\f\u001a\u00020\nH\u0002J\b\u0010\r\u001a\u00020\nH\u0002J\b\u0010\u000e\u001a\u00020\nH\u0002J\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0010J\u000e\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0010J\u001c\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00022\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0002H\u0007J\"\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00022\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0019\u001a\u00020\nH\u0016J\"\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00022\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016J*\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00022\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0019\u001a\u00020\nH\u0016J*\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u001a2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0019\u001a\u00020\nH\u0016J\u0019\u0010\u001d\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0014\u001a\u00020\u0002H\u0000\u00a2\u0006\u0004\b\u001b\u0010\u001cJ!\u0010\u001d\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0002H\u0000\u00a2\u0006\u0004\b\u001b\u0010\u001eJ!\u0010\u001d\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u001aH\u0000\u00a2\u0006\u0004\b\u001b\u0010\u001fJ\b\u0010 \u001a\u00020\nH\u0016J \u0010!\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\nH\u0016J\u0010\u0010#\u001a\u00020\u00052\b\b\u0002\u0010\"\u001a\u00020\nR\u0014\u0010$\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u001a\u0010'\u001a\b\u0012\u0004\u0012\u00020\b0&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010(\u00a8\u0006,"}, d2 = {"Lcom/tencent/zplan/luabridge/ZPlanLuaBridge;", "Lcom/tencent/zplan/luabridge/a;", "", "message", "Lkotlin/Function0;", "", "task", "doOnEngineRunning", "Lcom/tencent/zplan/luabridge/ZPlanLuaBridge$LuaRunnable;", "addToWaitList", "", "isEngineInitDone", "isLuaUnavailable", "isUE4LibraryLoaded", "isDebug", "assertDebug", "Lcom/tencent/zplan/luabridge/LuaBasePlugin;", "plugin", "registerPlugin", "removePlugin", AdMetricTag.EVENT_NAME, "params", "callLua", "Lcom/tencent/zplan/luabridge/a$b;", "listener", "bUseLog", "Lorg/json/JSONObject;", "callLuaSync$zplan_debug", "(Ljava/lang/String;)Ljava/lang/String;", "callLuaSync", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "(Ljava/lang/String;Lorg/json/JSONObject;)Ljava/lang/String;", "isAlive", "callLuaRaw", "enableLog", "evaluateWaitList", "TAG", "Ljava/lang/String;", "", "waitList", "Ljava/util/List;", "<init>", "()V", "LuaRunnable", "zplan_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public final class ZPlanLuaBridge implements com.tencent.zplan.luabridge.a {
    private static final String TAG = "[ZPlanLuaBridge]";

    @NotNull
    public static final ZPlanLuaBridge INSTANCE = new ZPlanLuaBridge();
    private static final List<LuaRunnable> waitList = new ArrayList();

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\b\u00a2\u0006\u0004\b\f\u0010\rJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/zplan/luabridge/ZPlanLuaBridge$LuaRunnable;", "Ljava/lang/Runnable;", "", TencentLocation.RUN_MODE, "", "d", "Ljava/lang/String;", "message", "Lkotlin/Function0;", "e", "Lkotlin/jvm/functions/Function0;", "task", "<init>", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "zplan_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes27.dex */
    public static final class LuaRunnable implements Runnable {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final String message;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final Function0<Unit> task;

        public LuaRunnable(@NotNull String message, @NotNull Function0<Unit> task) {
            Intrinsics.checkNotNullParameter(message, "message");
            Intrinsics.checkNotNullParameter(task, "task");
            this.message = message;
            this.task = task;
        }

        @Override // java.lang.Runnable
        public void run() {
            ZLog.f386189b.k(ZPlanLuaBridge.TAG, "LuaRunnable run, message:" + this.message);
            this.task.invoke();
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/zplan/luabridge/ZPlanLuaBridge$a", "Lp0/b;", "", "success", "", "result", "", "onLuaResult", "zplan_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes27.dex */
    public static final class a implements p0.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ WeakReference f385702a;

        a(WeakReference weakReference) {
            this.f385702a = weakReference;
        }

        @Override // p0.b
        public void onLuaResult(boolean success, @Nullable String result) {
            a.b bVar;
            WeakReference weakReference = this.f385702a;
            if (weakReference != null && (bVar = (a.b) weakReference.get()) != null) {
                bVar.onLuaResult(success, result);
            }
        }
    }

    ZPlanLuaBridge() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void addToWaitList(LuaRunnable task, String message) {
        List<LuaRunnable> list = waitList;
        synchronized (list) {
            list.add(task);
            ZLog.f386189b.k(TAG, "addToWaitList " + message + ", total:" + list.size());
            Unit unit = Unit.INSTANCE;
        }
    }

    private final void assertDebug(String message) {
        ZLog.f386189b.f(TAG, message);
    }

    public static /* synthetic */ void callLua$default(ZPlanLuaBridge zPlanLuaBridge, String str, String str2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            str2 = "{}";
        }
        zPlanLuaBridge.callLua(str, str2);
    }

    private final void doOnEngineRunning(String message, final Function0<Unit> task) {
        if (isLuaUnavailable()) {
            addToWaitList(new LuaRunnable(message, new Function0<Unit>() { // from class: com.tencent.zplan.luabridge.ZPlanLuaBridge$doOnEngineRunning$1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    Function0.this.invoke();
                }
            }), message);
            e.f386205a.b("[zplan][warn]", 0, "\u5ef6\u8fdf\u6267\u884ccalllua: \u56e0\u4e3a\u5f15\u64ce\u5f53\u524d\u672a\u6fc0\u6d3b");
        } else {
            evaluateWaitList(false);
            task.invoke();
        }
    }

    public static /* synthetic */ void evaluateWaitList$default(ZPlanLuaBridge zPlanLuaBridge, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = true;
        }
        zPlanLuaBridge.evaluateWaitList(z16);
    }

    private final boolean isDebug() {
        lx4.a aVar = (lx4.a) mx4.a.f417748a.a(lx4.a.class);
        if (aVar != null) {
            return aVar.isDebugVersion();
        }
        return false;
    }

    private final boolean isEngineInitDone() {
        return ZPlanEngineService.f385587b0.e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isLuaUnavailable() {
        boolean z16;
        ZPlanEngineService.a aVar = ZPlanEngineService.f385587b0;
        boolean c16 = aVar.c();
        boolean g16 = aVar.g();
        boolean b16 = com.tencent.zplan.engine.service.e.f385642b.b();
        boolean p16 = aVar.p();
        if (!b16 && c16 && !g16 && !p16) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            ZLog.f386189b.o(TAG, "isLuaUnavailable:" + z16 + ", isPurgeEngineHelperPurging: " + b16 + ", isEngineActive: " + c16 + " , isEnginePurged: " + g16 + ", isEnginePurging: " + p16);
        }
        return z16;
    }

    private final boolean isUE4LibraryLoaded() {
        return UE4.isLibrariesLoaded();
    }

    @Deprecated(message = "\u91cd\u6784callLua\u4e2d, \u8be5\u63a5\u53e3\u5c06\u5e9f\u5f03", replaceWith = @ReplaceWith(expression = "\u8bf7\u7528\u5176\u4ed6callLua\u4ee3\u66ff", imports = {}))
    public final void callLua(@NotNull final String eventName, @Nullable final String params) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        String str = "eventName:" + eventName + ", params:" + params;
        if (isEngineInitDone()) {
            if (isLuaUnavailable()) {
                addToWaitList(new LuaRunnable(str, new Function0<Unit>() { // from class: com.tencent.zplan.luabridge.ZPlanLuaBridge$callLua$$inlined$doOnEngineRunning$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        UE4.getLuaBridge().b(eventName, params);
                    }
                }), str);
                e.f386205a.b("[zplan][warn]", 0, "\u5ef6\u8fdf\u6267\u884ccalllua: \u56e0\u4e3a\u5f15\u64ce\u5f53\u524d\u672a\u6fc0\u6d3b");
                return;
            } else {
                evaluateWaitList(false);
                UE4.getLuaBridge().b(eventName, params);
                return;
            }
        }
        assertDebug("can't callLua on [Engine Don't Init Finish], " + str);
    }

    public void callLuaRaw(@NotNull String eventName, @NotNull String params, boolean bUseLog) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(params, "params");
        UE4.getLuaBridge().I(eventName, params, bUseLog);
    }

    @Nullable
    public final String callLuaSync$zplan_debug(@NotNull String eventName) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        return callLuaSync$zplan_debug(eventName, new JSONObject());
    }

    public final void evaluateWaitList(boolean enableLog) {
        List list;
        if (isLuaUnavailable()) {
            if (enableLog) {
                ZLog.f386189b.f(TAG, "evaluateWaitList, lua unavailable, return");
                return;
            }
            return;
        }
        List<LuaRunnable> list2 = waitList;
        synchronized (list2) {
            list = CollectionsKt___CollectionsKt.toList(list2);
            list2.clear();
        }
        if (list.isEmpty()) {
            if (enableLog) {
                ZLog.f386189b.f(TAG, "evaluateWaitList, waitList isEmpty, return");
                return;
            }
            return;
        }
        ZLog.f386189b.k(TAG, "evaluateWaitList, total:" + list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((LuaRunnable) it.next()).run();
        }
    }

    public boolean isAlive() {
        return true;
    }

    public final void registerPlugin(@NotNull LuaBasePlugin plugin) {
        Intrinsics.checkNotNullParameter(plugin, "plugin");
        UE4.getLuaBridge().c(plugin);
    }

    public final void removePlugin(@NotNull LuaBasePlugin plugin) {
        Intrinsics.checkNotNullParameter(plugin, "plugin");
        UE4.getLuaBridge().e(plugin);
    }

    @Nullable
    public final String callLuaSync$zplan_debug(@NotNull String eventName, @NotNull String params) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(params, "params");
        if (!isUE4LibraryLoaded()) {
            assertDebug("can't callLuaSync on [UE4 Library Don't Loaded], eventName:" + eventName + ", params:" + params);
            return null;
        }
        return UE4.getLuaBridge().f(eventName, params);
    }

    @Nullable
    public final String callLuaSync$zplan_debug(@NotNull String eventName, @NotNull JSONObject params) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(params, "params");
        if (!isUE4LibraryLoaded()) {
            assertDebug("can't callLuaSync on [UE4 Library Don't Loaded], eventName:" + eventName + ", params:" + params);
            return null;
        }
        return UE4.getLuaBridge().a(eventName, params);
    }

    @Override // com.tencent.zplan.luabridge.a
    public void callLua(@NotNull String eventName, @Nullable a.b listener, boolean bUseLog) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        callLua(eventName, new JSONObject(), listener, bUseLog);
    }

    @Override // com.tencent.zplan.luabridge.a
    public void callLua(@NotNull String eventName, @NotNull String params, @Nullable a.b listener) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(params, "params");
        callLua(eventName, params, listener, true);
    }

    @Override // com.tencent.zplan.luabridge.a
    public void callLua(@NotNull String eventName, @NotNull String params, @Nullable a.b listener, boolean bUseLog) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(params, "params");
        try {
            callLua(eventName, new JSONObject(params), listener, bUseLog);
        } catch (JSONException e16) {
            if (listener != null) {
                listener.onLuaResult(false, "params not json string");
            }
            assertDebug("can't callLua, params not json string, " + e16);
        }
    }

    @Override // com.tencent.zplan.luabridge.a
    public void callLua(@NotNull final String eventName, @NotNull final JSONObject params, @Nullable final a.b listener, final boolean bUseLog) {
        a.b bVar;
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(params, "params");
        String str = "eventName:" + eventName + ", params:" + params;
        if (isEngineInitDone()) {
            if (isLuaUnavailable()) {
                addToWaitList(new LuaRunnable(str, new Function0<Unit>() { // from class: com.tencent.zplan.luabridge.ZPlanLuaBridge$callLua$$inlined$doOnEngineRunning$2

                    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b\u00b8\u0006\u0000"}, d2 = {"com/tencent/zplan/luabridge/ZPlanLuaBridge$a", "Lp0/b;", "", "success", "", "result", "", "onLuaResult", "zplan_debug"}, k = 1, mv = {1, 4, 2})
                    /* loaded from: classes27.dex */
                    public static final class a implements p0.b {

                        /* renamed from: a, reason: collision with root package name */
                        final /* synthetic */ WeakReference f385699a;

                        a(WeakReference weakReference) {
                            this.f385699a = weakReference;
                        }

                        @Override // p0.b
                        public void onLuaResult(boolean success, @Nullable String result) {
                            a.b bVar;
                            WeakReference weakReference = this.f385699a;
                            if (weakReference != null && (bVar = (a.b) weakReference.get()) != null) {
                                bVar.onLuaResult(success, result);
                            }
                        }
                    }

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        a.b bVar2;
                        a.b bVar3 = a.b.this;
                        WeakReference weakReference = bVar3 != null ? new WeakReference(bVar3) : null;
                        if (weakReference != null && (bVar2 = (a.b) weakReference.get()) != null) {
                            bVar2.onExecuteLua();
                        }
                        UE4.getLuaBridge().d(eventName, params, new a(weakReference), bUseLog);
                    }
                }), str);
                e.f386205a.b("[zplan][warn]", 0, "\u5ef6\u8fdf\u6267\u884ccalllua: \u56e0\u4e3a\u5f15\u64ce\u5f53\u524d\u672a\u6fc0\u6d3b");
                return;
            }
            evaluateWaitList(false);
            WeakReference weakReference = listener != null ? new WeakReference(listener) : null;
            if (weakReference != null && (bVar = (a.b) weakReference.get()) != null) {
                bVar.onExecuteLua();
            }
            UE4.getLuaBridge().d(eventName, params, new a(weakReference), bUseLog);
            return;
        }
        if (listener != null) {
            listener.onLuaResult(false, null);
        }
        assertDebug("can't callLua on [Engine Don't Init Finish], " + str);
    }
}
