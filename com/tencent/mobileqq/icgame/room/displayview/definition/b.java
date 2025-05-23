package com.tencent.mobileqq.icgame.room.displayview.definition;

import android.app.Activity;
import android.content.Context;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.icgame.common.api.IAegisLogApi;
import com.tencent.icgame.game.liveroom.impl.room.definition.DefinitionController;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.icgame.api.room.IAudienceRoom;
import com.tencent.mobileqq.icgame.api.room.ILiveAudienceTPPlayerRoom;
import com.tencent.mobileqq.icgame.data.room.EnterRoomInfo;
import com.tencent.mobileqq.icgame.framework.eventbroadcaster.annotation.ComponentEvent;
import com.tencent.mobileqq.icgame.framework.interfaceService.InjectService;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import rv0.DefinitionNeedChangeEvent;
import rv0.FirstFramePlayEvent;
import tl.h;

/* compiled from: P */
@ComponentEvent(eventList = {DefinitionNeedChangeEvent.class, FirstFramePlayEvent.class})
@Metadata(d1 = {"\u0000k\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001-\b\u0007\u0018\u0000 52\u00020\u0001:\u00016B\u000f\u0012\u0006\u00102\u001a\u000201\u00a2\u0006\u0004\b3\u00104J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016J\u0006\u0010\t\u001a\u00020\u0006J\u0006\u0010\n\u001a\u00020\u0006J\u0006\u0010\u000b\u001a\u00020\u0006J\u000e\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0004J\u0006\u0010\u000e\u001a\u00020\u0006J\u0006\u0010\u000f\u001a\u00020\u0006J\u000e\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0010J\u000e\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0010R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0019\u001a\u00020\u00188\u0002@\u0002X\u0083.\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001c\u001a\u00020\u001b8\u0002@\u0002X\u0083.\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010(\u001a\u00020&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010'R\u001a\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00100)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0014\u00100\u001a\u00020-8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u0010/\u00a8\u00067"}, d2 = {"Lcom/tencent/mobileqq/icgame/room/displayview/definition/b;", "Lcom/tencent/mobileqq/icgame/framework/component/b;", "Lcom/tencent/mobileqq/icgame/api/room/ILiveAudienceTPPlayerRoom;", "o", "", "p", "", "k", "i", "v", "t", "u", "roomId", "r", ReportConstant.COSTREPORT_PREFIX, HippyTKDListViewAdapter.X, "Lcom/tencent/icgame/game/liveroom/impl/room/definition/DefinitionController$c;", "listener", DomainData.DOMAIN_NAME, "w", "Lcom/tencent/icgame/common/api/IAegisLogApi;", "e", "Lcom/tencent/icgame/common/api/IAegisLogApi;", "log", "Lh22/a;", "qqLiveRoomService", "Lh22/a;", "Lcom/tencent/mobileqq/icgame/room/displayview/component/a;", "liveRoomDisplayService", "Lcom/tencent/mobileqq/icgame/room/displayview/component/a;", "", "f", "Z", "hasRegisterListener", "Lcom/tencent/icgame/game/liveroom/impl/room/definition/DefinitionController;", h.F, "Lcom/tencent/icgame/game/liveroom/impl/room/definition/DefinitionController;", "definitionController", "Lfu0/c;", "Lfu0/c;", "liveRoomService", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/List;", "listeners", "com/tencent/mobileqq/icgame/room/displayview/definition/b$b", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/icgame/room/displayview/definition/b$b;", "playerListener", "Lf32/a;", "componentContext", "<init>", "(Lf32/a;)V", "D", "a", "ic-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class b extends com.tencent.mobileqq.icgame.framework.component.b {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final C7927b playerListener;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final IAegisLogApi log;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean hasRegisterListener;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private DefinitionController definitionController;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private fu0.c liveRoomService;

    @InjectService(key = com.tencent.mobileqq.icgame.room.displayview.component.a.class)
    private com.tencent.mobileqq.icgame.room.displayview.component.a liveRoomDisplayService;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<DefinitionController.c> listeners;

    @InjectService(key = h22.a.class)
    private h22.a qqLiveRoomService;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@NotNull f32.a componentContext) {
        super(componentContext);
        Intrinsics.checkNotNullParameter(componentContext, "componentContext");
        QRouteApi api = QRoute.api(IAegisLogApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IAegisLogApi::class.java)");
        this.log = (IAegisLogApi) api;
        mm4.a b16 = qx0.a.b(fu0.c.class);
        Intrinsics.checkNotNullExpressionValue(b16, "getService(ITgLiveRoomService::class.java)");
        this.liveRoomService = (fu0.c) b16;
        this.listeners = new ArrayList();
        this.playerListener = new C7927b();
    }

    private final ILiveAudienceTPPlayerRoom o() {
        fu0.c cVar = this.liveRoomService;
        h22.a aVar = this.qqLiveRoomService;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("qqLiveRoomService");
            aVar = null;
        }
        IAudienceRoom y16 = cVar.y(aVar.getRoomId());
        if (!(y16 instanceof ILiveAudienceTPPlayerRoom)) {
            return null;
        }
        return (ILiveAudienceTPPlayerRoom) y16;
    }

    private final long p() {
        h22.a aVar = this.qqLiveRoomService;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("qqLiveRoomService");
            aVar = null;
        }
        return aVar.getRoomId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(b this$0, EnterRoomInfo.VideoDefinition videoDefinition, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int size = this$0.listeners.size();
        while (true) {
            size--;
            if (-1 < size) {
                this$0.listeners.get(size).a(videoDefinition, str);
            } else {
                return;
            }
        }
    }

    @Override // com.tencent.mobileqq.icgame.framework.component.e
    public void k() {
        Context context = getComponentContext().getContext();
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
        Activity activity = (Activity) context;
        h22.a aVar = this.qqLiveRoomService;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("qqLiveRoomService");
            aVar = null;
        }
        DefinitionController definitionController = new DefinitionController(activity, aVar.getRoomId(), getComponentContext());
        this.definitionController = definitionController;
        definitionController.y(new DefinitionController.c() { // from class: com.tencent.mobileqq.icgame.room.displayview.definition.a
            @Override // com.tencent.icgame.game.liveroom.impl.room.definition.DefinitionController.c
            public final void a(EnterRoomInfo.VideoDefinition videoDefinition, String str) {
                b.q(b.this, videoDefinition, str);
            }
        });
    }

    public final void n(@NotNull DefinitionController.c listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (!this.listeners.contains(listener)) {
            this.listeners.add(listener);
        }
    }

    public final void r(long roomId) {
        if (this.hasRegisterListener) {
            return;
        }
        DefinitionController definitionController = this.definitionController;
        if (definitionController == null) {
            Intrinsics.throwUninitializedPropertyAccessException("definitionController");
            definitionController = null;
        }
        definitionController.p();
        ILiveAudienceTPPlayerRoom o16 = o();
        if (o16 != null) {
            this.log.i("ICGameDefinitionComponent", p() + " onEnterRoom register listener");
            this.hasRegisterListener = true;
            o16.registerRoomPlayerListener(this.playerListener);
        }
    }

    public final void s() {
        ILiveAudienceTPPlayerRoom o16 = o();
        if (o16 != null) {
            o16.unRegisterRoomPlayerListener(this.playerListener);
        }
        this.hasRegisterListener = false;
        DefinitionController definitionController = this.definitionController;
        if (definitionController == null) {
            Intrinsics.throwUninitializedPropertyAccessException("definitionController");
            definitionController = null;
        }
        definitionController.q();
    }

    public final void t() {
        DefinitionController definitionController = this.definitionController;
        h22.a aVar = null;
        if (definitionController == null) {
            Intrinsics.throwUninitializedPropertyAccessException("definitionController");
            definitionController = null;
        }
        h22.a aVar2 = this.qqLiveRoomService;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("qqLiveRoomService");
        } else {
            aVar = aVar2;
        }
        definitionController.r(aVar.getRoomId());
    }

    public final void u() {
        DefinitionController definitionController = this.definitionController;
        h22.a aVar = null;
        if (definitionController == null) {
            Intrinsics.throwUninitializedPropertyAccessException("definitionController");
            definitionController = null;
        }
        h22.a aVar2 = this.qqLiveRoomService;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("qqLiveRoomService");
        } else {
            aVar = aVar2;
        }
        definitionController.s(aVar.getRoomId());
    }

    public final void v() {
        ILiveAudienceTPPlayerRoom o16 = o();
        if (o16 != null) {
            this.log.i("ICGameDefinitionComponent", p() + " onPagePreload register listener");
            this.hasRegisterListener = true;
            o16.registerRoomPlayerListener(this.playerListener);
        }
    }

    public final void w(@NotNull DefinitionController.c listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listeners.remove(listener);
    }

    public final void x() {
        boolean z16;
        if (getComponentContext().getContext().getResources().getConfiguration().orientation == 2) {
            z16 = true;
        } else {
            z16 = false;
        }
        DefinitionController definitionController = this.definitionController;
        h22.a aVar = null;
        if (definitionController == null) {
            Intrinsics.throwUninitializedPropertyAccessException("definitionController");
            definitionController = null;
        }
        h22.a aVar2 = this.qqLiveRoomService;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("qqLiveRoomService");
        } else {
            aVar = aVar2;
        }
        definitionController.A(aVar.getRoomId(), z16);
    }

    @Override // com.tencent.mobileqq.icgame.framework.component.e
    public void i() {
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J*\u0010\r\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J(\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0002H\u0016J\b\u0010\u0013\u001a\u00020\u0005H\u0016J\b\u0010\u0014\u001a\u00020\u0005H\u0016J\b\u0010\u0015\u001a\u00020\u0005H\u0016J\b\u0010\u0016\u001a\u00020\u0005H\u0016J*\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u00022\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016\u00a8\u0006\u001d"}, d2 = {"com/tencent/mobileqq/icgame/room/displayview/definition/b$b", "Lb32/a;", "", "startTime", "endTime", "", "onFirstFrameCome", "", "module", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ERROR_TYPE, "errorCode", "", "extraInfo", "onError", "totalSize", "cacheSize", "cacheDuration", "speed", "onUpdateDownloadInfo", "onStartBuffer", "onStopBuffer", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "onPlay", "what", "arg1", "arg2", "", "extra", "onInfo", "ic-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.icgame.room.displayview.definition.b$b, reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    public static final class C7927b extends b32.a {
        C7927b() {
        }

        @Override // b32.a
        public void onError(int module, int errorType, int errorCode, @Nullable String extraInfo) {
            DefinitionController definitionController = b.this.definitionController;
            if (definitionController == null) {
                Intrinsics.throwUninitializedPropertyAccessException("definitionController");
                definitionController = null;
            }
            definitionController.t();
        }

        @Override // b32.a
        public void onFirstFrameCome(long startTime, long endTime) {
            DefinitionController definitionController = b.this.definitionController;
            if (definitionController == null) {
                Intrinsics.throwUninitializedPropertyAccessException("definitionController");
                definitionController = null;
            }
            definitionController.onFirstFrameCome(startTime, endTime);
        }

        @Override // b32.a
        public void onInfo(int what, long arg1, long arg2, @Nullable Object extra) {
            DefinitionController definitionController = b.this.definitionController;
            if (definitionController == null) {
                Intrinsics.throwUninitializedPropertyAccessException("definitionController");
                definitionController = null;
            }
            definitionController.onInfo(what, arg1, arg2, extra);
        }

        @Override // b32.a
        public void onPause() {
            DefinitionController definitionController = b.this.definitionController;
            if (definitionController == null) {
                Intrinsics.throwUninitializedPropertyAccessException("definitionController");
                definitionController = null;
            }
            definitionController.u();
        }

        @Override // b32.a
        public void onPlay() {
            DefinitionController definitionController = b.this.definitionController;
            if (definitionController == null) {
                Intrinsics.throwUninitializedPropertyAccessException("definitionController");
                definitionController = null;
            }
            definitionController.v();
        }

        @Override // b32.a
        public void onStartBuffer() {
            DefinitionController definitionController = b.this.definitionController;
            if (definitionController == null) {
                Intrinsics.throwUninitializedPropertyAccessException("definitionController");
                definitionController = null;
            }
            definitionController.onStartBuffer();
        }

        @Override // b32.a
        public void onStopBuffer() {
            DefinitionController definitionController = b.this.definitionController;
            if (definitionController == null) {
                Intrinsics.throwUninitializedPropertyAccessException("definitionController");
                definitionController = null;
            }
            definitionController.onStopBuffer();
        }

        @Override // b32.a
        public void onUpdateDownloadInfo(long totalSize, long cacheSize, long cacheDuration, long speed) {
        }
    }
}
