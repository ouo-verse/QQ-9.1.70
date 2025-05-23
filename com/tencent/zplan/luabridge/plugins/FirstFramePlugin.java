package com.tencent.zplan.luabridge.plugins;

import android.text.TextUtils;
import com.tencent.xweb.FileReaderHelper;
import com.tencent.zplan.engine.service.ZPlanEngineService;
import com.tencent.zplan.luabridge.LuaArgument;
import com.tencent.zplan.luabridge.LuaBasePlugin;
import com.tencent.zplan.luabridge.LuaEvent;
import com.tencent.zplan.utils.ZLog;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import lx4.f;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c0\u0002\u0018\u00002\u00020\u0001:\u0002\u0005\tB\t\b\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0007R\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0010R\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/zplan/luabridge/plugins/FirstFramePlugin;", "Lcom/tencent/zplan/luabridge/LuaBasePlugin;", "", "viewType", "", "a", "c", "Lcom/tencent/zplan/luabridge/plugins/FirstFramePlugin$a;", "listener", "b", "d", "Lcom/tencent/zplan/luabridge/LuaArgument;", "argument", "", "handleEngineFirstFrame", "", "Ljava/util/List;", "listeners", "Ljava/util/concurrent/locks/ReentrantLock;", "e", "Ljava/util/concurrent/locks/ReentrantLock;", "listenerLock", "<init>", "()V", "zplan_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public final class FirstFramePlugin extends LuaBasePlugin {

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public static final FirstFramePlugin f385718f = new FirstFramePlugin();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static final List<a> listeners = new ArrayList();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static final ReentrantLock listenerLock = new ReentrantLock();

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0010\u001a\u00020\r\u00a2\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005R\u0017\u0010\f\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u0010\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000e\u001a\u0004\b\b\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/zplan/luabridge/plugins/FirstFramePlugin$a;", "", "", "a", "I", "()I", "callLuaIndex", "Lcom/tencent/zplan/luabridge/plugins/FirstFramePlugin$b;", "b", "Lcom/tencent/zplan/luabridge/plugins/FirstFramePlugin$b;", "c", "()Lcom/tencent/zplan/luabridge/plugins/FirstFramePlugin$b;", "listener", "", "Z", "()Z", FileReaderHelper.OPEN_FILE_FROM_FORCE, "<init>", "(ILcom/tencent/zplan/luabridge/plugins/FirstFramePlugin$b;Z)V", "zplan_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes27.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final int callLuaIndex;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final b listener;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private final boolean force;

        public a(int i3, @NotNull b listener, boolean z16) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.callLuaIndex = i3;
            this.listener = listener;
            this.force = z16;
        }

        /* renamed from: a, reason: from getter */
        public final int getCallLuaIndex() {
            return this.callLuaIndex;
        }

        /* renamed from: b, reason: from getter */
        public final boolean getForce() {
            return this.force;
        }

        @NotNull
        /* renamed from: c, reason: from getter */
        public final b getListener() {
            return this.listener;
        }

        public /* synthetic */ a(int i3, b bVar, boolean z16, int i16, DefaultConstructorMarker defaultConstructorMarker) {
            this(i3, bVar, (i16 & 4) != 0 ? false : z16);
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/zplan/luabridge/plugins/FirstFramePlugin$b;", "", "", "event", "Lorg/json/JSONObject;", "params", "", "a", "zplan_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes27.dex */
    public interface b {
        void a(@NotNull String event, @NotNull JSONObject params);
    }

    FirstFramePlugin() {
    }

    private final void a(int viewType) {
        ZPlanEngineService.INSTANCE.v(viewType);
    }

    private final void c(final int viewType) {
        lx4.f fVar = (lx4.f) mx4.a.f417748a.a(lx4.f.class);
        if (fVar != null) {
            f.a.a(fVar, new Runnable() { // from class: com.tencent.zplan.luabridge.plugins.FirstFramePlugin$reportProcessmemory$1
                @Override // java.lang.Runnable
                public final void run() {
                    com.tencent.zplan.utils.c.f386201a.a(viewType);
                }
            }, 0L, 2, null);
        }
    }

    public final void b(@NotNull a listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        ReentrantLock reentrantLock = listenerLock;
        reentrantLock.lock();
        try {
            ZLog.f386189b.k("FirstFramePlugin", "registerListener : " + listener);
            listeners.add(listener);
        } finally {
            reentrantLock.unlock();
        }
    }

    public final void d(@NotNull a listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        ReentrantLock reentrantLock = listenerLock;
        reentrantLock.lock();
        try {
            ZLog.f386189b.k("FirstFramePlugin", "unRegisterListener : " + listener);
            listeners.remove(listener);
        } finally {
            reentrantLock.unlock();
        }
    }

    @LuaEvent("L2N_NotifyEngineFirstFrame")
    @NotNull
    public final String handleEngineFirstFrame(@NotNull LuaArgument argument) {
        List<a> list;
        Intrinsics.checkNotNullParameter(argument, "argument");
        ZLog.f386189b.k("FirstFramePlugin", "handleEngineFirstFrame : " + argument.getF440574c());
        JSONObject jSONObject = new JSONObject(argument.getF440574c());
        int optInt = jSONObject.optInt("ViewType", -1);
        a(optInt);
        c(optInt);
        ReentrantLock reentrantLock = listenerLock;
        reentrantLock.lock();
        try {
            list = CollectionsKt___CollectionsKt.toList(listeners);
            reentrantLock.unlock();
            for (a aVar : list) {
                ZLog zLog = ZLog.f386189b;
                zLog.k("FirstFramePlugin", "handleEngineFirstFrame, listener: " + aVar + ", " + argument.getF440574c());
                String optString = jSONObject.optString("OriginalParams");
                if (!TextUtils.isEmpty(optString)) {
                    if (aVar.getCallLuaIndex() != new JSONObject(optString).optInt("_EnterAvaterIndex_", -1) && !aVar.getForce()) {
                        zLog.f("FirstFramePlugin", "handleEngineFirstFrame, can not find index listener, do nothing");
                    } else {
                        aVar.getListener().a("L2N_NotifyEngineFirstFrame", jSONObject);
                    }
                } else {
                    zLog.k("FirstFramePlugin", "handleEngineFirstFrame, can not find index listener, send to all listener");
                    aVar.getListener().a("L2N_NotifyEngineFirstFrame", jSONObject);
                }
            }
            return argument.ok();
        } catch (Throwable th5) {
            reentrantLock.unlock();
            throw th5;
        }
    }
}
