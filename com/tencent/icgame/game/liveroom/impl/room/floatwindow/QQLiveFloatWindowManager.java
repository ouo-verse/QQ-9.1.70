package com.tencent.icgame.game.liveroom.impl.room.floatwindow;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.icgame.app.event.AudienceFloatOnExitEvent;
import com.tencent.icgame.common.api.IAegisLogApi;
import com.tencent.icgame.game.liveroom.impl.room.floatwindow.QQLiveFloatWindowManager;
import com.tencent.icgame.game.liveroom.impl.room.floatwindow.QQLiveFloatWindowOperateView;
import com.tencent.icgame.game.liveroom.impl.room.floatwindow.QQLiveFloatWindowView;
import com.tencent.icgame.game.ui.widget.CommonButton;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QMMKVFile;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.icgame.api.IQQLiveSDK;
import com.tencent.mobileqq.icgame.api.room.IAudienceRoom;
import com.tencent.mobileqq.icgame.api.room.ILiveAudienceTPPlayerRoom;
import com.tencent.mobileqq.icgame.api.room.ILiveRoom;
import com.tencent.mobileqq.icgame.api.room.ILiveTPPlayerRoom;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qqfloatingwindow.FloatingScreenParams;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingWindow;
import com.tencent.mobileqq.qqlive.data.record.QQLiveCurRoomInfo;
import com.tencent.mobileqq.qqlive.data.room.BaseRoomInfo;
import com.tencent.mobileqq.qqlive.data.room.realtime.EndPageRealTimeInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.app.event.AudienceFloatCloseEvent;
import com.tencent.timi.game.utils.IResultListener;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000[\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0007*\u0001=\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\bA\u0010BJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0002H\u0002J\b\u0010\u000b\u001a\u00020\u0004H\u0002J\b\u0010\f\u001a\u00020\u0004H\u0002J\b\u0010\r\u001a\u00020\u0004H\u0002J\u000e\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eJ\u0006\u0010\u0011\u001a\u00020\u0004J\u0006\u0010\u0012\u001a\u00020\u0004J\u0006\u0010\u0014\u001a\u00020\u0013J\u000e\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0013J\u0016\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0002J\u0006\u0010\u0019\u001a\u00020\u0004J\u0006\u0010\u001a\u001a\u00020\u0004J\u0006\u0010\u001b\u001a\u00020\u0004J\u0006\u0010\u001c\u001a\u00020\u0004R\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR#\u0010'\u001a\n \"*\u0004\u0018\u00010!0!8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u0018\u0010+\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0018\u0010.\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00101\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0016\u00105\u001a\u0002028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0016\u00108\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010<\u001a\u0002098\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0014\u0010@\u001a\u00020=8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b>\u0010?\u00a8\u0006C"}, d2 = {"Lcom/tencent/icgame/game/liveroom/impl/room/floatwindow/QQLiveFloatWindowManager;", "", "", "floatWindow", "", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/icgame/api/room/ILiveAudienceTPPlayerRoom;", DomainData.DOMAIN_NAME, "r", "isFloating", "D", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Lcom/tencent/icgame/game/liveroom/impl/room/floatwindow/i;", "params", "y", "p", HippyTKDListViewAdapter.X, "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "roomId", "k", "autoExitRoom", "l", ReportConstant.COSTREPORT_PREFIX, "v", "u", "t", "Lcom/tencent/icgame/common/api/IAegisLogApi;", "b", "Lcom/tencent/icgame/common/api/IAegisLogApi;", "aegisLog", "Lfu0/c;", "kotlin.jvm.PlatformType", "c", "Lkotlin/Lazy;", "o", "()Lfu0/c;", "liveRoomService", "Lcom/tencent/icgame/game/liveroom/impl/room/floatwindow/QQLiveFloatWindowView;", "d", "Lcom/tencent/icgame/game/liveroom/impl/room/floatwindow/QQLiveFloatWindowView;", "qqLiveFloatWindowView", "e", "Lcom/tencent/icgame/game/liveroom/impl/room/floatwindow/i;", "qqLiveFloatWindowParams", "f", "J", "lastClickFloatingTime", "Lki2/b;", "g", "Lki2/b;", "onKickedOutOfRoomListener", tl.h.F, "Z", "isFlowWindowShowing", "Lcom/tencent/icgame/game/liveroom/impl/room/floatwindow/QQLiveFloatWindowOperateView$a;", "i", "Lcom/tencent/icgame/game/liveroom/impl/room/floatwindow/QQLiveFloatWindowOperateView$a;", "operateCallback", "com/tencent/icgame/game/liveroom/impl/room/floatwindow/QQLiveFloatWindowManager$b", "j", "Lcom/tencent/icgame/game/liveroom/impl/room/floatwindow/QQLiveFloatWindowManager$b;", "netInfoHandler", "<init>", "()V", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class QQLiveFloatWindowManager {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final QQLiveFloatWindowManager f115256a = new QQLiveFloatWindowManager();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static IAegisLogApi aegisLog;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy liveRoomService;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static QQLiveFloatWindowView qqLiveFloatWindowView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static QQLiveFloatWindowParams qqLiveFloatWindowParams;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static long lastClickFloatingTime;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static ki2.b onKickedOutOfRoomListener;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private static boolean isFlowWindowShowing;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static QQLiveFloatWindowOperateView.a operateCallback;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final b netInfoHandler;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\t\u001a\u00020\u0004H\u0016J\b\u0010\n\u001a\u00020\u0004H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/icgame/game/liveroom/impl/room/floatwindow/QQLiveFloatWindowManager$b", "Lcom/tencent/mobileqq/msf/sdk/handler/INetInfoHandler;", "", "p0", "", "onNetNone2Mobile", "onNetWifi2Mobile", "onNetNone2Wifi", "onNetMobile2Wifi", "onNetMobile2None", "onNetWifi2None", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes7.dex */
    public static final class b implements INetInfoHandler {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void e() {
            ILiveAudienceTPPlayerRoom n3;
            if (QQLiveFloatWindowManager.isFlowWindowShowing && (n3 = QQLiveFloatWindowManager.f115256a.n()) != null) {
                n3.startPlay("");
            }
            QQLiveFloatWindowManager.f115256a.q();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void f() {
            Context context;
            QQLiveFloatWindowView qQLiveFloatWindowView = QQLiveFloatWindowManager.qqLiveFloatWindowView;
            if (qQLiveFloatWindowView != null) {
                context = qQLiveFloatWindowView.getContext();
            } else {
                context = null;
            }
            if (context == null || gv0.b.f403419a.a(context)) {
                QQLiveFloatWindowManager.f115256a.z();
                return;
            }
            QQLiveFloatWindowManager qQLiveFloatWindowManager = QQLiveFloatWindowManager.f115256a;
            ILiveAudienceTPPlayerRoom n3 = qQLiveFloatWindowManager.n();
            if (n3 != null) {
                n3.pause();
            }
            qQLiveFloatWindowManager.A();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void g() {
            ILiveAudienceTPPlayerRoom n3;
            if (QQLiveFloatWindowManager.isFlowWindowShowing && (n3 = QQLiveFloatWindowManager.f115256a.n()) != null) {
                n3.startPlay("");
            }
            QQLiveFloatWindowManager.f115256a.q();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void h() {
            Context context;
            QQLiveFloatWindowView qQLiveFloatWindowView = QQLiveFloatWindowManager.qqLiveFloatWindowView;
            if (qQLiveFloatWindowView != null) {
                context = qQLiveFloatWindowView.getContext();
            } else {
                context = null;
            }
            if (context == null || gv0.b.f403419a.a(context)) {
                QQLiveFloatWindowManager.f115256a.z();
                return;
            }
            QQLiveFloatWindowManager qQLiveFloatWindowManager = QQLiveFloatWindowManager.f115256a;
            ILiveAudienceTPPlayerRoom n3 = qQLiveFloatWindowManager.n();
            if (n3 != null) {
                n3.pause();
            }
            qQLiveFloatWindowManager.A();
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetMobile2None() {
            QQLiveFloatWindowManager.aegisLog.i("ICGameFloatWindowManager", "onNetMobile2None");
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetMobile2Wifi(@Nullable String p06) {
            QQLiveFloatWindowManager.aegisLog.i("ICGameFloatWindowManager", "onNetMobile2Wifi: " + p06 + " isFlowWindowShowing:" + QQLiveFloatWindowManager.isFlowWindowShowing);
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.icgame.game.liveroom.impl.room.floatwindow.h
                @Override // java.lang.Runnable
                public final void run() {
                    QQLiveFloatWindowManager.b.e();
                }
            });
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetNone2Mobile(@Nullable String p06) {
            QQLiveFloatWindowManager.aegisLog.i("ICGameFloatWindowManager", "onNetNone2Mobile: " + p06);
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.icgame.game.liveroom.impl.room.floatwindow.f
                @Override // java.lang.Runnable
                public final void run() {
                    QQLiveFloatWindowManager.b.f();
                }
            });
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetNone2Wifi(@Nullable String p06) {
            QQLiveFloatWindowManager.aegisLog.i("ICGameFloatWindowManager", "onNetNone2Wifi: " + p06 + " isFlowWindowShowing:" + QQLiveFloatWindowManager.isFlowWindowShowing);
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.icgame.game.liveroom.impl.room.floatwindow.e
                @Override // java.lang.Runnable
                public final void run() {
                    QQLiveFloatWindowManager.b.g();
                }
            });
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetWifi2Mobile(@Nullable String p06) {
            QQLiveFloatWindowManager.aegisLog.i("ICGameFloatWindowManager", "onNetWifi2Mobile: " + p06);
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.icgame.game.liveroom.impl.room.floatwindow.g
                @Override // java.lang.Runnable
                public final void run() {
                    QQLiveFloatWindowManager.b.h();
                }
            });
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetWifi2None() {
            QQLiveFloatWindowManager.aegisLog.i("ICGameFloatWindowManager", "onNetWifi2None");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/icgame/game/liveroom/impl/room/floatwindow/QQLiveFloatWindowManager$c", "Lcom/tencent/icgame/game/liveroom/impl/room/floatwindow/QQLiveFloatWindowOperateView$a;", "", "b", "a", "c", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes7.dex */
    public static final class c implements QQLiveFloatWindowOperateView.a {
        c() {
        }

        @Override // com.tencent.icgame.game.liveroom.impl.room.floatwindow.QQLiveFloatWindowOperateView.a
        public void a() {
            boolean z16;
            QQLiveFloatWindowManager qQLiveFloatWindowManager = QQLiveFloatWindowManager.f115256a;
            ILiveAudienceTPPlayerRoom n3 = qQLiveFloatWindowManager.n();
            if (n3 != null) {
                z16 = n3.isOutputMute();
            } else {
                z16 = false;
            }
            IAegisLogApi iAegisLogApi = QQLiveFloatWindowManager.aegisLog;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("onClickVolume, ready do mute:");
            sb5.append(!z16);
            iAegisLogApi.i("ICGameFloatWindowManager", sb5.toString());
            ILiveAudienceTPPlayerRoom n16 = qQLiveFloatWindowManager.n();
            if (n16 != null) {
                n16.setMute(!z16);
            }
            QQLiveFloatWindowView qQLiveFloatWindowView = QQLiveFloatWindowManager.qqLiveFloatWindowView;
            if (qQLiveFloatWindowView != null) {
                qQLiveFloatWindowView.setMute(!z16);
            }
        }

        @Override // com.tencent.icgame.game.liveroom.impl.room.floatwindow.QQLiveFloatWindowOperateView.a
        public void b() {
            QQLiveFloatWindowManager.aegisLog.i("ICGameFloatWindowManager", "onCloseClick");
            QQLiveFloatWindowParams qQLiveFloatWindowParams = QQLiveFloatWindowManager.qqLiveFloatWindowParams;
            if (qQLiveFloatWindowParams != null) {
                QQLiveFloatWindowManager.f115256a.k(qQLiveFloatWindowParams.getRoomId());
                SimpleEventBus.getInstance().dispatchEvent(new AudienceFloatCloseEvent(qQLiveFloatWindowParams.getRoomId()));
            }
            QQLiveFloatWindowManager.f115256a.p();
        }

        @Override // com.tencent.icgame.game.liveroom.impl.room.floatwindow.QQLiveFloatWindowOperateView.a
        public void c() {
            QQLiveFloatWindowManager.aegisLog.i("ICGameFloatWindowManager", "onEnterClick");
            QQLiveFloatWindowView qQLiveFloatWindowView = QQLiveFloatWindowManager.qqLiveFloatWindowView;
            if (qQLiveFloatWindowView != null) {
                qQLiveFloatWindowView.i();
            }
            QQLiveFloatWindowManager qQLiveFloatWindowManager = QQLiveFloatWindowManager.f115256a;
            ILiveAudienceTPPlayerRoom n3 = qQLiveFloatWindowManager.n();
            if (n3 != null) {
                n3.setMute(false);
            }
            qQLiveFloatWindowManager.p();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/icgame/game/liveroom/impl/room/floatwindow/QQLiveFloatWindowManager$d", "Lcom/tencent/icgame/game/liveroom/impl/room/floatwindow/QQLiveFloatWindowView$b;", "", "a", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes7.dex */
    public static final class d implements QQLiveFloatWindowView.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ QQLiveFloatWindowParams f115266a;

        d(QQLiveFloatWindowParams qQLiveFloatWindowParams) {
            this.f115266a = qQLiveFloatWindowParams;
        }

        @Override // com.tencent.icgame.game.liveroom.impl.room.floatwindow.QQLiveFloatWindowView.b
        public void a() {
            QQLiveFloatWindowManager.f115256a.k(this.f115266a.getRoomId());
        }
    }

    static {
        Lazy lazy;
        QRouteApi api = QRoute.api(IAegisLogApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IAegisLogApi::class.java)");
        aegisLog = (IAegisLogApi) api;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<fu0.c>() { // from class: com.tencent.icgame.game.liveroom.impl.room.floatwindow.QQLiveFloatWindowManager$liveRoomService$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final fu0.c invoke() {
                return (fu0.c) qx0.a.b(fu0.c.class);
            }
        });
        liveRoomService = lazy;
        onKickedOutOfRoomListener = new ki2.b() { // from class: com.tencent.icgame.game.liveroom.impl.room.floatwindow.c
            @Override // ki2.b
            public final void a(String str) {
                QQLiveFloatWindowManager.w(str);
            }
        };
        isFlowWindowShowing = true;
        operateCallback = new c();
        netInfoHandler = new b();
    }

    QQLiveFloatWindowManager() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void A() {
        ViewGroup viewGroup;
        aegisLog.i("ICGameFloatWindowManager", "showNetTip");
        QQLiveFloatWindowView qQLiveFloatWindowView = qqLiveFloatWindowView;
        CommonButton commonButton = null;
        if (qQLiveFloatWindowView != null) {
            viewGroup = qQLiveFloatWindowView.getNetTipViewGroup();
        } else {
            viewGroup = null;
        }
        if (viewGroup != null) {
            commonButton = (CommonButton) viewGroup.findViewById(R.id.f97635kx);
        }
        if (commonButton != null) {
            commonButton.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.icgame.game.liveroom.impl.room.floatwindow.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    QQLiveFloatWindowManager.B(view);
                }
            });
        }
        if (viewGroup != null) {
            viewGroup.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        gv0.b.f403419a.c();
        QQLiveFloatWindowManager qQLiveFloatWindowManager = f115256a;
        ILiveAudienceTPPlayerRoom n3 = qQLiveFloatWindowManager.n();
        if (n3 != null) {
            n3.startPlay("");
        }
        qQLiveFloatWindowManager.q();
        qQLiveFloatWindowManager.z();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void C(boolean floatWindow) {
        QQLiveCurRoomInfo curRoomInfo;
        IQQLiveSDK f16 = ((fu0.c) qx0.a.b(fu0.c.class)).f();
        if (f16 != null && (curRoomInfo = f16.getCurRoomInfo()) != null) {
            Intrinsics.checkNotNullExpressionValue(curRoomInfo, "curRoomInfo");
            curRoomInfo.isFloatWindow = floatWindow;
            f16.recordCurRoomInfo(curRoomInfo);
        }
        D(floatWindow);
    }

    private final void D(boolean isFloating) {
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_ICGAME);
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_ICGAME)");
        from.encodeBool("key_qqlive_float_window_is_show", isFloating);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ILiveAudienceTPPlayerRoom n() {
        IAudienceRoom N = o().N(0L);
        if (N instanceof ILiveAudienceTPPlayerRoom) {
            return (ILiveAudienceTPPlayerRoom) N;
        }
        return null;
    }

    private final fu0.c o() {
        return (fu0.c) liveRoomService.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q() {
        ViewGroup viewGroup;
        aegisLog.i("ICGameFloatWindowManager", "hideNetTip");
        QQLiveFloatWindowView qQLiveFloatWindowView = qqLiveFloatWindowView;
        if (qQLiveFloatWindowView != null) {
            viewGroup = qQLiveFloatWindowView.getNetTipViewGroup();
        } else {
            viewGroup = null;
        }
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
        }
    }

    private final boolean r() {
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_ICGAME);
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_ICGAME)");
        return from.decodeBool("key_qqlive_float_window_is_show", false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(String str) {
        BaseRoomInfo q16;
        fu0.c cVar = (fu0.c) qx0.a.b(fu0.c.class);
        long j3 = 0;
        if (cVar != null && (q16 = cVar.q(0L)) != null) {
            j3 = q16.getRoomId();
        }
        f115256a.k(j3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void z() {
        Context context;
        QQLiveFloatWindowView qQLiveFloatWindowView = qqLiveFloatWindowView;
        if (qQLiveFloatWindowView != null) {
            context = qQLiveFloatWindowView.getContext();
        } else {
            context = null;
        }
        if (context != null) {
            QQToast.makeText(context, "\u5f53\u524d\u975ewifi\u73af\u5883\uff0c\u6ce8\u610f\u6d41\u91cf\u6d88\u8017\u54e6", 0).show();
        }
    }

    public final void k(long roomId) {
        l(roomId, true);
    }

    public final void l(long roomId, boolean autoExitRoom) {
        aegisLog.i("ICGameFloatWindowManager", "destroyFloatingView  roomId:" + roomId + ", autoExitRoom:" + autoExitRoom);
        mv0.b.f417658a.a(onKickedOutOfRoomListener);
        if (autoExitRoom) {
            mm4.a b16 = qx0.a.b(fu0.c.class);
            Intrinsics.checkNotNullExpressionValue(b16, "getService(ITgLiveRoomService::class.java)");
            ((fu0.c) b16).r(roomId, new a());
            hu0.f.s().E(roomId, true);
        }
    }

    public final long m() {
        long j3 = lastClickFloatingTime;
        lastClickFloatingTime = 0L;
        return j3;
    }

    public final void p() {
        if (!r()) {
            return;
        }
        ((IQQFloatingWindow) QRoute.api(IQQFloatingWindow.class)).quitFloatingScreen(n.INSTANCE.a());
        QQLiveFloatWindowView qQLiveFloatWindowView = qqLiveFloatWindowView;
        if (qQLiveFloatWindowView != null) {
            qQLiveFloatWindowView.n();
        }
        C(false);
    }

    public final void s() {
        Context context;
        aegisLog.i("ICGameFloatWindowManager", "onFloatWindowEnter");
        isFlowWindowShowing = true;
        QQLiveFloatWindowView qQLiveFloatWindowView = qqLiveFloatWindowView;
        if (qQLiveFloatWindowView != null) {
            context = qQLiveFloatWindowView.getContext();
        } else {
            context = null;
        }
        if (context != null && !gv0.b.f403419a.a(context)) {
            A();
        }
    }

    public final void t() {
        aegisLog.i("ICGameFloatWindowManager", "onFloatWindowExit");
        isFlowWindowShowing = false;
        SimpleEventBus.getInstance().dispatchEvent(new AudienceFloatOnExitEvent());
    }

    public final void u() {
        ILiveAudienceTPPlayerRoom n3;
        aegisLog.i("ICGameFloatWindowManager", "onFloatWindowHide isFlowWindowShowing:" + isFlowWindowShowing);
        if (isFlowWindowShowing && (n3 = n()) != null) {
            n3.pause();
        }
        isFlowWindowShowing = false;
    }

    public final void v() {
        Context context;
        aegisLog.i("ICGameFloatWindowManager", "onFloatWindowShow isFlowWindowShowing:" + isFlowWindowShowing);
        if (!isFlowWindowShowing) {
            QQLiveFloatWindowView qQLiveFloatWindowView = qqLiveFloatWindowView;
            if (qQLiveFloatWindowView != null) {
                context = qQLiveFloatWindowView.getContext();
            } else {
                context = null;
            }
            if (context != null && gv0.b.f403419a.a(context)) {
                ILiveAudienceTPPlayerRoom n3 = n();
                if (n3 != null) {
                    n3.startPlay("");
                }
                q();
            } else {
                A();
            }
        }
        isFlowWindowShowing = true;
    }

    public final void x() {
        lastClickFloatingTime = System.currentTimeMillis();
    }

    public final void y(@NotNull QQLiveFloatWindowParams params) {
        int i3;
        ILiveTPPlayerRoom iLiveTPPlayerRoom;
        Intrinsics.checkNotNullParameter(params, "params");
        qqLiveFloatWindowParams = params;
        BaseApplication context = BaseApplication.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext()");
        QQLiveFloatWindowView qQLiveFloatWindowView = new QQLiveFloatWindowView(context, params, operateCallback);
        qQLiveFloatWindowView.setFloatViewUIChangedListener(new d(params));
        qqLiveFloatWindowView = qQLiveFloatWindowView;
        Intrinsics.checkNotNull(qQLiveFloatWindowView);
        if (qQLiveFloatWindowView.p()) {
            i3 = 1;
        } else {
            i3 = 2;
        }
        int enterCustomFloatingScreen = ((IQQFloatingWindow) QRoute.api(IQQFloatingWindow.class)).enterCustomFloatingScreen(BaseApplication.getContext(), qqLiveFloatWindowView, new FloatingScreenParams.FloatingBuilder().setShapeType(i3).setCanMove(true).setCanZoom(true).build(), n.INSTANCE.a(), 57);
        aegisLog.i("ICGameFloatWindowManager", "enterFloatingScreen:" + enterCustomFloatingScreen);
        com.tencent.timi.game.utils.m.a().c(netInfoHandler);
        if (enterCustomFloatingScreen == 0) {
            ILiveRoom z16 = o().z(0L);
            if (z16 instanceof ILiveTPPlayerRoom) {
                iLiveTPPlayerRoom = (ILiveTPPlayerRoom) z16;
            } else {
                iLiveTPPlayerRoom = null;
            }
            if (iLiveTPPlayerRoom != null) {
                iLiveTPPlayerRoom.setMute(params.getPlayerMute());
            }
            QQLiveFloatWindowView qQLiveFloatWindowView2 = qqLiveFloatWindowView;
            if (qQLiveFloatWindowView2 != null) {
                qQLiveFloatWindowView2.r();
            }
            C(true);
            return;
        }
        aegisLog.e("ICGameFloatWindowManager", "enter floatWindow errorCode:" + enterCustomFloatingScreen);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0012\u0010\n\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/icgame/game/liveroom/impl/room/floatwindow/QQLiveFloatWindowManager$a", "Lcom/tencent/timi/game/utils/IResultListener;", "Lcom/tencent/mobileqq/qqlive/data/room/realtime/EndPageRealTimeInfo;", "", "errorCode", "", "errorMessage", "", "onError", "result", "a", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes7.dex */
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
