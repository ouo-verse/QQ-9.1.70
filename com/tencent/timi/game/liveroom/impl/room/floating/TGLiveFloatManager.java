package com.tencent.timi.game.liveroom.impl.room.floating;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.mqq.api.IAccountRuntime;
import com.tencent.mobileqq.perf.process.state.floating.IFloatingState;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDKManager;
import com.tencent.mobileqq.qqlive.api.room.FloatWindow;
import com.tencent.mobileqq.qqlive.api.room.HideFloatingWindowEvent;
import com.tencent.mobileqq.qqlive.api.room.ILiveRoom;
import com.tencent.mobileqq.qqlive.api.room.ILiveTPPlayerRoom;
import com.tencent.mobileqq.qqlive.api.room.QQLiveFloatWindowEvent;
import com.tencent.mobileqq.qqlive.business.QQLiveConfigConst;
import com.tencent.mobileqq.qqlive.data.anchor.room.QQLiveAnchorRecord;
import com.tencent.mobileqq.qqlive.data.room.BaseRoomInfo;
import com.tencent.mobileqq.qqlive.data.room.realtime.EndPageRealTimeInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.timi.game.liveroom.impl.ipc.TGLiveClientQIPCModule;
import com.tencent.timi.game.utils.IResultListener;
import com.tencent.timi.game.utils.w;
import cooperation.qqcircle.report.QCircleQualityReporter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import uh4.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001/B\t\b\u0002\u00a2\u0006\u0004\b-\u0010.J \u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\f\u001a\u00020\nH\u0002J\u0006\u0010\r\u001a\u00020\bJ\u000e\u0010\u0010\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000eJ\u0006\u0010\u0011\u001a\u00020\bJ\u0006\u0010\u0012\u001a\u00020\bJ\u000f\u0010\u0013\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u000e\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006J\u0016\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\nJ\u0006\u0010\u0018\u001a\u00020\bJ\u0006\u0010\u0019\u001a\u00020\bJ\u0006\u0010\u001a\u001a\u00020\bJ\u0012\u0010\u001c\u001a\u00020\b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0002H\u0016J$\u0010 \u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u001e0\u001dj\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u001e`\u001fH\u0016R\u0016\u0010#\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010&\u001a\u00020$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010%R0\u0010,\u001a\u001e\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020)0'j\u000e\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020)`*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010+\u00a8\u00060"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/floating/TGLiveFloatManager;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "status", QCircleQualityReporter.KEY_ID, "", "roomId", "", tl.h.F, "", "k", "j", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/timi/game/liveroom/impl/room/floating/a;", DownloadInfo.spKey_Config, "p", "l", "d", "i", "()Ljava/lang/Long;", "f", "autoExitRoom", "g", "o", "c", DomainData.DOMAIN_NAME, "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "e", "J", "lastClickFloatingTime", "Lki2/b;", "Lki2/b;", "onKickedOutOfRoomListener", "Ljava/util/HashMap;", "", "Lcom/tencent/timi/game/liveroom/impl/room/floating/TGLiveFloatManager$FloatShowStatus;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "floatStatusMap", "<init>", "()V", "FloatShowStatus", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class TGLiveFloatManager implements SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final TGLiveFloatManager f377649d;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static long lastClickFloatingTime;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static ki2.b onKickedOutOfRoomListener;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final HashMap<String, FloatShowStatus> floatStatusMap;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/floating/TGLiveFloatManager$FloatShowStatus;", "", "(Ljava/lang/String;I)V", "SHOW", "HIDE", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes26.dex */
    public enum FloatShowStatus {
        SHOW,
        HIDE
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/timi/game/liveroom/impl/room/floating/TGLiveFloatManager$b", "Luh4/e;", "", "roomId", "Luh4/d;", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class b implements uh4.e {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ FloatViewConfig f377653a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f377654b;

        b(FloatViewConfig floatViewConfig, long j3) {
            this.f377653a = floatViewConfig;
            this.f377654b = j3;
        }

        @Override // uh4.e
        @Nullable
        public uh4.d a(@NotNull String roomId) {
            Intrinsics.checkNotNullParameter(roomId, "roomId");
            if (this.f377653a.getIsAnchor()) {
                BaseApplication context = BaseApplication.context;
                Intrinsics.checkNotNullExpressionValue(context, "context");
                return new TGLiveAnchorFloatingNewView(context, null, 0, 6, null).n(this.f377654b);
            }
            BaseApplication context2 = BaseApplication.context;
            Intrinsics.checkNotNullExpressionValue(context2, "context");
            TGLiveAudienceFloatingView tGLiveAudienceFloatingView = new TGLiveAudienceFloatingView(context2, null, 0, 6, null);
            FloatViewConfig floatViewConfig = this.f377653a;
            long j3 = this.f377654b;
            tGLiveAudienceFloatingView.N(floatViewConfig.getResumeIntent());
            tGLiveAudienceFloatingView.setGameLive(floatViewConfig.getIsGameLive());
            tGLiveAudienceFloatingView.K(j3);
            return tGLiveAudienceFloatingView;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/timi/game/liveroom/impl/room/floating/TGLiveFloatManager$c", "Luh4/e;", "", "roomId", "Luh4/d;", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class c implements uh4.e {
        c() {
        }

        @Override // uh4.e
        @Nullable
        public uh4.d a(@NotNull String roomId) {
            Intrinsics.checkNotNullParameter(roomId, "roomId");
            BaseApplication context = BaseApplication.context;
            Intrinsics.checkNotNullExpressionValue(context, "context");
            return new TGAnchorKeepAliveFloatingWindow(context, null, 0, 6, null);
        }
    }

    static {
        TGLiveFloatManager tGLiveFloatManager = new TGLiveFloatManager();
        f377649d = tGLiveFloatManager;
        onKickedOutOfRoomListener = new ki2.b() { // from class: com.tencent.timi.game.liveroom.impl.room.floating.s
            @Override // ki2.b
            public final void a(String str) {
                TGLiveFloatManager.m(str);
            }
        };
        floatStatusMap = new HashMap<>();
        SimpleEventBus.getInstance().registerReceiver(tGLiveFloatManager);
    }

    TGLiveFloatManager() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(BaseRoomInfo it) {
        Intrinsics.checkNotNullParameter(it, "$it");
        f377649d.g(it.getRoomId(), true);
    }

    private final void h(int status, int identify, long roomId) {
        QLog.i("unknown|TGLiveFloatManager", 1, "AliveFloatView dispatchFloatStatusEvent");
        SimpleEventBus.getInstance().dispatchEvent(new QQLiveFloatWindowEvent(k(), j(), new FloatWindow(status, identify, roomId)));
    }

    private final boolean j() {
        boolean endsWith$default;
        for (Map.Entry<String, FloatShowStatus> entry : floatStatusMap.entrySet()) {
            endsWith$default = StringsKt__StringsJVMKt.endsWith$default(entry.getKey(), "_keepAlive", false, 2, null);
            if (endsWith$default && entry.getValue() == FloatShowStatus.SHOW) {
                return true;
            }
        }
        return false;
    }

    private final boolean k() {
        boolean endsWith$default;
        for (Map.Entry<String, FloatShowStatus> entry : floatStatusMap.entrySet()) {
            endsWith$default = StringsKt__StringsJVMKt.endsWith$default(entry.getKey(), "_keepAlive", false, 2, null);
            if (!endsWith$default && entry.getValue() == FloatShowStatus.SHOW) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(String str) {
        BaseRoomInfo q16;
        jg4.b bVar = (jg4.b) mm4.b.b(jg4.b.class);
        long j3 = 0;
        if (bVar != null && (q16 = bVar.q(0L)) != null) {
            j3 = q16.getRoomId();
        }
        f377649d.f(j3);
    }

    public final void c() {
        SimpleEventBus.getInstance().dispatchEvent(new QQLiveFloatWindowEvent(k(), j(), null));
    }

    public final void d() {
        final BaseRoomInfo q16 = ((jg4.b) mm4.b.b(jg4.b.class)).q(0L);
        if (q16 != null) {
            Long i3 = f377649d.i();
            AegisLogger.INSTANCE.i("unknown|TGLiveFloatManager", "destroyCurFloatingView: it.roomId:" + q16.getRoomId() + " openLiveRoomId:" + i3);
            if (q16.getRoomId() > 0) {
                long roomId = q16.getRoomId();
                if (i3 == null || roomId != i3.longValue()) {
                    w.c(new Runnable() { // from class: com.tencent.timi.game.liveroom.impl.room.floating.t
                        @Override // java.lang.Runnable
                        public final void run() {
                            TGLiveFloatManager.e(BaseRoomInfo.this);
                        }
                    });
                }
            }
        }
    }

    public final void f(long roomId) {
        g(roomId, true);
    }

    public final void g(long roomId, boolean autoExitRoom) {
        AegisLogger.INSTANCE.i("unknown|TGLiveFloatManager", "destroyFloatingView  roomId:" + roomId + ", autoExitRoom:" + autoExitRoom);
        a.Companion companion = uh4.a.INSTANCE;
        boolean e16 = companion.a().e(String.valueOf(roomId));
        boolean e17 = companion.a().e(roomId + "_keepAlive");
        if (autoExitRoom) {
            mm4.a b16 = mm4.b.b(jg4.b.class);
            Intrinsics.checkNotNullExpressionValue(b16, "getService(ITgLiveRoomService::class.java)");
            tk4.d.f436481a.B(0L);
            ((jg4.b) b16).r(roomId, new a());
            mg4.c.g().p(roomId, true);
        }
        if (e16 || e17) {
            int i3 = !e16 ? 1 : 0;
            HashMap<String, FloatShowStatus> hashMap = floatStatusMap;
            hashMap.remove(String.valueOf(roomId));
            hashMap.remove(roomId + "_keepAlive");
            h(2, i3, roomId);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayList = new ArrayList<>();
        arrayList.add(HideFloatingWindowEvent.class);
        arrayList.add(QQLiveFloatWindowEvent.class);
        return arrayList;
    }

    @Nullable
    public final Long i() {
        String str;
        String account = ((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount();
        IQQLiveSDK f16 = ((jg4.b) mm4.b.b(jg4.b.class)).f();
        if (f16 == null || (str = f16.getAppId()) == null) {
            str = QQLiveConfigConst.APP_ID;
        }
        QQLiveAnchorRecord existAnchorRecord = ((IQQLiveSDKManager) QRoute.api(IQQLiveSDKManager.class)).getExistAnchorRecord(str, account);
        if (existAnchorRecord != null) {
            return Long.valueOf(existAnchorRecord.roomId);
        }
        return null;
    }

    public final void l() {
        Long l3;
        mm4.a b16 = mm4.b.b(jg4.b.class);
        Intrinsics.checkNotNullExpressionValue(b16, "getService(ITgLiveRoomService::class.java)");
        BaseRoomInfo q16 = ((jg4.b) b16).q(0L);
        if (q16 != null) {
            l3 = Long.valueOf(q16.getRoomId());
        } else {
            l3 = null;
        }
        QLog.i("unknown|TGLiveFloatManager", 1, "hideFloatView  roomId:" + l3);
        if (l3 != null) {
            long longValue = l3.longValue();
            if (uh4.a.INSTANCE.a().d(String.valueOf(longValue))) {
                floatStatusMap.put(String.valueOf(longValue), FloatShowStatus.HIDE);
                f377649d.h(0, 0, longValue);
            }
        }
        IFloatingState iFloatingState = (IFloatingState) QRoute.api(IFloatingState.class);
        String name = TGLiveFloatManager.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "this.javaClass.name");
        iFloatingState.removeState(name);
    }

    public final void n() {
        d();
    }

    public final void o() {
        lastClickFloatingTime = System.currentTimeMillis();
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        if (event == null) {
            return;
        }
        if (event instanceof HideFloatingWindowEvent) {
            d();
        } else if (event instanceof QQLiveFloatWindowEvent) {
            QLog.i("unknown|TGLiveFloatManager", 1, "onReceiveEvent, notifyFloatWindowStatusEvent");
            TGLiveClientQIPCModule.INSTANCE.c().o((QQLiveFloatWindowEvent) event);
        }
    }

    public final void p(@NotNull FloatViewConfig config) {
        Long l3;
        Intrinsics.checkNotNullParameter(config, "config");
        mm4.a b16 = mm4.b.b(jg4.b.class);
        Intrinsics.checkNotNullExpressionValue(b16, "getService(ITgLiveRoomService::class.java)");
        BaseRoomInfo q16 = ((jg4.b) b16).q(0L);
        ILiveTPPlayerRoom iLiveTPPlayerRoom = null;
        if (q16 != null) {
            l3 = Long.valueOf(q16.getRoomId());
        } else {
            l3 = null;
        }
        QLog.i("unknown|TGLiveFloatManager", 1, "showFloatView isAnchor:" + config.getIsAnchor() + " roomId:" + l3);
        if (l3 != null) {
            long longValue = l3.longValue();
            String l16 = l3.toString();
            uh4.a.INSTANCE.a().g(l16, new b(config, longValue));
            floatStatusMap.put(l16, FloatShowStatus.SHOW);
            f377649d.h(1, 0, longValue);
        }
        ILiveRoom z16 = ((jg4.b) mm4.b.b(jg4.b.class)).z(0L);
        if (z16 instanceof ILiveTPPlayerRoom) {
            iLiveTPPlayerRoom = (ILiveTPPlayerRoom) z16;
        }
        if (iLiveTPPlayerRoom != null) {
            iLiveTPPlayerRoom.startPlay("");
        }
        IFloatingState iFloatingState = (IFloatingState) QRoute.api(IFloatingState.class);
        String name = TGLiveFloatManager.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "this.javaClass.name");
        iFloatingState.writeState(name);
    }

    public final void q() {
        Long l3;
        QLog.i("unknown|TGLiveFloatManager", 1, "showKeepAliveFloatView");
        mm4.a b16 = mm4.b.b(jg4.b.class);
        Intrinsics.checkNotNullExpressionValue(b16, "getService(ITgLiveRoomService::class.java)");
        BaseRoomInfo q16 = ((jg4.b) b16).q(0L);
        if (q16 != null) {
            l3 = Long.valueOf(q16.getRoomId());
        } else {
            l3 = null;
        }
        if (l3 != null) {
            long longValue = l3.longValue();
            String str = l3 + "_keepAlive";
            uh4.a.INSTANCE.a().g(str, new c());
            floatStatusMap.put(str, FloatShowStatus.SHOW);
            QLog.i("unknown|TGLiveFloatManager", 1, "AliveFloatView dispatchFloatStatusEvent");
            f377649d.h(1, 1, longValue);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0012\u0010\n\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/timi/game/liveroom/impl/room/floating/TGLiveFloatManager$a", "Lcom/tencent/timi/game/utils/IResultListener;", "Lcom/tencent/mobileqq/qqlive/data/room/realtime/EndPageRealTimeInfo;", "", "errorCode", "", "errorMessage", "", "onError", "result", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class a implements IResultListener<EndPageRealTimeInfo> {
        a() {
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        public void onError(int errorCode, @NotNull String errorMessage) {
            Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@Nullable EndPageRealTimeInfo result) {
        }
    }
}
