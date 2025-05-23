package com.tencent.zplan.luabridge;

import android.os.IInterface;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.text.TextUtils;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.ams.dynamicwidget.report.LinkReportConstant$GlobalKey;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.zplan.utils.ZLog;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.aspectj.lang.JoinPoint;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000-\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\b*\u0001\r\u0018\u0000 \u00132\u00020\u0001:\u0001\nB\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004R&\u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\t0\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/zplan/luabridge/RemoteRegisterHelper;", "", "", AdMetricTag.EVENT_NAME, "Lcom/tencent/zplan/c;", "callback", "", "d", "", "Landroid/os/RemoteCallbackList;", "a", "Ljava/util/Map;", LinkReportConstant$GlobalKey.EVENTS, "com/tencent/zplan/luabridge/RemoteRegisterHelper$b", "b", "Lcom/tencent/zplan/luabridge/RemoteRegisterHelper$b;", "remotePlugin", "<init>", "()V", "e", "zplan_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public final class RemoteRegisterHelper {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private static final Lazy f385693c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private static final ReentrantLock f385694d;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Map<String, RemoteCallbackList<com.tencent.zplan.c>> events;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final b remotePlugin;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0007\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\t\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/zplan/luabridge/RemoteRegisterHelper$a;", "", "Lcom/tencent/zplan/luabridge/RemoteRegisterHelper;", "instance$delegate", "Lkotlin/Lazy;", "a", "()Lcom/tencent/zplan/luabridge/RemoteRegisterHelper;", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "Ljava/util/concurrent/locks/ReentrantLock;", JoinPoint.SYNCHRONIZATION_LOCK, "Ljava/util/concurrent/locks/ReentrantLock;", "b", "()Ljava/util/concurrent/locks/ReentrantLock;", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "zplan_debug"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.tencent.zplan.luabridge.RemoteRegisterHelper$a, reason: from kotlin metadata */
    /* loaded from: classes27.dex */
    public static final class Companion {
        Companion() {
        }

        @NotNull
        public final RemoteRegisterHelper a() {
            return (RemoteRegisterHelper) RemoteRegisterHelper.f385693c.getValue();
        }

        @NotNull
        public final ReentrantLock b() {
            return RemoteRegisterHelper.f385694d;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\u001a\u0010\b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0016R$\u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u0010"}, d2 = {"com/tencent/zplan/luabridge/RemoteRegisterHelper$b", "Lcom/tencent/zplan/luabridge/LuaBasePlugin;", "", "", "getEvents", AdMetricTag.EVENT_NAME, "Lp0/a;", "argument", "handleEvent", "d", "Ljava/lang/String;", "getOnlyEventName", "()Ljava/lang/String;", "a", "(Ljava/lang/String;)V", "onlyEventName", "zplan_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes27.dex */
    public static final class b extends LuaBasePlugin {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private String onlyEventName;

        b() {
        }

        public final void a(@Nullable String str) {
            this.onlyEventName = str;
        }

        @Override // com.tencent.zplan.luabridge.LuaBasePlugin, p0.d
        @NotNull
        public List<String> getEvents() {
            List<String> emptyList;
            List<String> listOf;
            String str = this.onlyEventName;
            if (str != null) {
                listOf = CollectionsKt__CollectionsJVMKt.listOf(str);
                return listOf;
            }
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }

        @Override // com.tencent.zplan.luabridge.LuaBasePlugin, p0.d
        @Nullable
        public String handleEvent(@NotNull String eventName, @NotNull p0.a argument) {
            RemoteCallbackList remoteCallbackList;
            Intrinsics.checkNotNullParameter(eventName, "eventName");
            Intrinsics.checkNotNullParameter(argument, "argument");
            Companion companion = RemoteRegisterHelper.INSTANCE;
            Map map = companion.a().events;
            synchronized (map) {
                remoteCallbackList = (RemoteCallbackList) map.get(eventName);
            }
            String str = null;
            if (remoteCallbackList == null) {
                ZLog.f386189b.k("[zplan]RemoteRegisterHelper", "no listener can handle " + eventName);
                return null;
            }
            ReentrantLock b16 = companion.b();
            b16.lock();
            try {
                int beginBroadcast = remoteCallbackList.beginBroadcast();
                for (int i3 = 0; i3 < beginBroadcast; i3++) {
                    try {
                        IInterface broadcastItem = remoteCallbackList.getBroadcastItem(i3);
                        Intrinsics.checkNotNullExpressionValue(broadcastItem, "event.getBroadcastItem(i)");
                        str = ((com.tencent.zplan.c) broadcastItem).t0(eventName, argument.getF440574c(), argument.getF440572a());
                    } catch (RemoteException e16) {
                        ZLog.f386189b.f("[zplan]RemoteRegisterHelper", "handleEvent error, " + e16);
                    }
                }
                remoteCallbackList.finishBroadcast();
                Unit unit = Unit.INSTANCE;
                return str;
            } finally {
                b16.unlock();
            }
        }
    }

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<RemoteRegisterHelper>() { // from class: com.tencent.zplan.luabridge.RemoteRegisterHelper$Companion$instance$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final RemoteRegisterHelper invoke() {
                return new RemoteRegisterHelper(null);
            }
        });
        f385693c = lazy;
        f385694d = new ReentrantLock();
    }

    RemoteRegisterHelper() {
        this.events = new LinkedHashMap();
        this.remotePlugin = new b();
    }

    public final void d(@NotNull String eventName, @Nullable com.tencent.zplan.c callback) {
        ReentrantLock reentrantLock;
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        if (TextUtils.isEmpty(eventName)) {
            ZLog.f386189b.k("[zplan]RemoteRegisterHelper", "eventName is empty!!");
            return;
        }
        this.remotePlugin.a(eventName);
        if (callback != null) {
            synchronized (this.events) {
                if (this.events.containsKey(eventName)) {
                    ZLog.f386189b.k("[zplan]RemoteRegisterHelper", eventName + " had been registered!!");
                }
                reentrantLock = f385694d;
                reentrantLock.lock();
                try {
                    RemoteCallbackList<com.tencent.zplan.c> remoteCallbackList = new RemoteCallbackList<>();
                    remoteCallbackList.register(callback);
                    reentrantLock.unlock();
                    this.events.put(eventName, remoteCallbackList);
                    ZPlanLuaBridge.INSTANCE.registerPlugin(this.remotePlugin);
                    Unit unit = Unit.INSTANCE;
                } finally {
                }
            }
            return;
        }
        synchronized (this.events) {
            if (!this.events.containsKey(eventName)) {
                ZLog.f386189b.k("[zplan]RemoteRegisterHelper", eventName + " had been unregistered!!");
                return;
            }
            reentrantLock = f385694d;
            reentrantLock.lock();
            try {
                RemoteCallbackList<com.tencent.zplan.c> remoteCallbackList2 = this.events.get(eventName);
                if (remoteCallbackList2 != null) {
                    remoteCallbackList2.kill();
                    Unit unit2 = Unit.INSTANCE;
                }
                reentrantLock.unlock();
                this.events.remove(eventName);
                ZPlanLuaBridge.INSTANCE.removePlugin(this.remotePlugin);
                Unit unit3 = Unit.INSTANCE;
            } finally {
            }
        }
    }

    public /* synthetic */ RemoteRegisterHelper(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
