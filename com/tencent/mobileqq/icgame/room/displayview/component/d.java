package com.tencent.mobileqq.icgame.room.displayview.component;

import android.content.Intent;
import android.util.Size;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.weishi.report.WSPublicAccReport;
import com.tencent.icgame.common.api.IAegisLogApi;
import com.tencent.icgame.game.api.live.LiveRoomExtraInfo;
import com.tencent.icgame.game.liveroom.impl.room.audience.preload.ExitRoomAndPreloadSucEvent;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.richmedia.i;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.icgame.api.room.IAudienceRoom;
import com.tencent.mobileqq.icgame.api.room.ILiveAudienceTPPlayerRoom;
import com.tencent.mobileqq.icgame.framework.component.SingleUIComponent;
import com.tencent.mobileqq.icgame.framework.eventbroadcaster.annotation.ComponentEvent;
import com.tencent.mobileqq.icgame.framework.interfaceService.InjectService;
import com.tencent.mobileqq.icgame.room.displayview.ICGameDisplayView;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.utils.ViewUtils;
import d42.g;
import d42.h;
import i22.OrientationChangedEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import rv0.e;
import rv0.f;

/* compiled from: P */
@ComponentEvent(eventList = {g.class, d42.a.class, h.class, rv0.d.class, e.class, f.class})
@Metadata(d1 = {"\u0000\u00ba\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 02\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001VB\u000f\u0012\u0006\u0010S\u001a\u00020R\u00a2\u0006\u0004\bT\u0010UJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0002J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0002J\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\f\u001a\u00020\u0006H\u0002J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u0010\u001a\u00020\u0002H\u0016J\b\u0010\u0011\u001a\u00020\u0006H\u0016J\b\u0010\u0012\u001a\u00020\u0006H\u0016J\b\u0010\u0013\u001a\u00020\u0003H\u0016J\u000e\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0014J\u0006\u0010\u0017\u001a\u00020\u0006J\u0006\u0010\u0018\u001a\u00020\u0006J\u000e\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0019J\u000e\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u001bJ\u000e\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u001dJ\u000e\u0010 \u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u001fJ\u000e\u0010\"\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020!J\u0006\u0010#\u001a\u00020\u0006J\u0006\u0010$\u001a\u00020\u0006J\u0006\u0010%\u001a\u00020\u0006J\u0006\u0010&\u001a\u00020\u0006J\u0006\u0010'\u001a\u00020\u0006J\u0006\u0010(\u001a\u00020\u0006J\u0006\u0010*\u001a\u00020)J\u000e\u0010-\u001a\u00020\u00062\u0006\u0010,\u001a\u00020+J\u000e\u00100\u001a\u00020\u00062\u0006\u0010/\u001a\u00020.R\u0014\u00104\u001a\u0002018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0016\u00106\u001a\u0002058\u0002@\u0002X\u0083.\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0016\u00109\u001a\u0002088\u0002@\u0002X\u0083.\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010<\u001a\u00020;8\u0002@\u0002X\u0083.\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010?\u001a\u00020>8\u0002@\u0002X\u0083.\u00a2\u0006\u0006\n\u0004\b?\u0010@R\u0018\u0010B\u001a\u0004\u0018\u00010A8\u0002@\u0002X\u0083\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010CR\u0018\u0010E\u001a\u0004\u0018\u00010D8\u0002@\u0002X\u0083\u000e\u00a2\u0006\u0006\n\u0004\bE\u0010FR\u001c\u0010J\u001a\n H*\u0004\u0018\u00010G0G8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010IR\u0016\u0010L\u001a\u00020K8\u0002@\u0002X\u0083.\u00a2\u0006\u0006\n\u0004\bL\u0010MR\u0016\u0010N\u001a\u00020+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\fR\u0016\u0010P\u001a\u00020+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bO\u0010\fR\u0014\u0010Q\u001a\u00020\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\b\u00a8\u0006W"}, d2 = {"Lcom/tencent/mobileqq/icgame/room/displayview/component/d;", "Lcom/tencent/mobileqq/icgame/framework/component/SingleUIComponent;", "Lcom/tencent/mobileqq/icgame/room/displayview/ICGameDisplayView;", "", "width", "height", "", "B", "I", "H", "Landroid/view/ViewGroup;", "G", "Z", "", "msg", "J", "D", "k", "i", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Li22/d;", "event", BdhLogUtil.LogTag.Tag_Req, "X", "O", "Lcom/tencent/icgame/game/liveroom/impl/room/audience/preload/a;", "P", "Li22/h;", "U", "Li22/e;", ExifInterface.LATITUDE_SOUTH, "Li22/g;", "T", "Li22/b;", "N", "L", "M", "K", "V", "W", "Y", "Lcom/tencent/mobileqq/activity/richmedia/i;", UserInfo.SEX_FEMALE, "", WSPublicAccReport.SOP_NAME_FOCUS, AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Landroid/view/MotionEvent;", "ev", "E", "Lcom/tencent/icgame/common/api/IAegisLogApi;", tl.h.F, "Lcom/tencent/icgame/common/api/IAegisLogApi;", "aegisLog", "Lb42/b;", "audienceComponent", "Lb42/b;", "Lcom/tencent/mobileqq/icgame/room/gift/c;", "giftEntranceService", "Lcom/tencent/mobileqq/icgame/room/gift/c;", "Lh22/a;", "qqLiveRoomService", "Lh22/a;", "Lcom/tencent/icgame/game/liveroom/impl/room/audience/preload/c;", "preloadRoomService", "Lcom/tencent/icgame/game/liveroom/impl/room/audience/preload/c;", "Lp22/a;", "switchRoomService", "Lp22/a;", "Lk22/e;", "switchScreenService", "Lk22/e;", "Lfu0/c;", "kotlin.jvm.PlatformType", "Lfu0/c;", "liveRoomService", "Lcom/tencent/mobileqq/icgame/room/float/component/a;", "floatControlService", "Lcom/tencent/mobileqq/icgame/room/float/component/a;", "isLandScape", BdhLogUtil.LogTag.Tag_Conn, "videoLandscape", "videoLandscapeMargin", "Lf32/a;", "componentContext", "<init>", "(Lf32/a;)V", "a", "ic-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class d extends SingleUIComponent<ICGameDisplayView> {

    /* renamed from: C, reason: from kotlin metadata */
    private boolean videoLandscape;

    /* renamed from: D, reason: from kotlin metadata */
    private final int videoLandscapeMargin;

    @InjectService(key = b42.b.class)
    private b42.b audienceComponent;

    @InjectService(key = com.tencent.mobileqq.icgame.room.p006float.component.a.class)
    private com.tencent.mobileqq.icgame.room.p006float.component.a floatControlService;

    @InjectService(key = com.tencent.mobileqq.icgame.room.gift.c.class)
    private com.tencent.mobileqq.icgame.room.gift.c giftEntranceService;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final IAegisLogApi aegisLog;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final fu0.c liveRoomService;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean isLandScape;

    @InjectService(key = com.tencent.icgame.game.liveroom.impl.room.audience.preload.c.class)
    private com.tencent.icgame.game.liveroom.impl.room.audience.preload.c preloadRoomService;

    @InjectService(key = h22.a.class)
    private h22.a qqLiveRoomService;

    @InjectService(key = p22.a.class)
    @Nullable
    private p22.a switchRoomService;

    @InjectService(key = k22.e.class)
    @Nullable
    private k22.e switchScreenService;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/icgame/room/displayview/component/d$b", "Ld42/f;", "", "width", "height", "", "a", "ic-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class b implements d42.f {
        b() {
        }

        @Override // d42.f
        public void a(int width, int height) {
            boolean z16;
            k22.e eVar;
            d dVar = d.this;
            dVar.J("onVideoSizeChange, width " + width + ", height " + height + ", current videoLandscape " + dVar.videoLandscape);
            h22.a aVar = d.this.qqLiveRoomService;
            b42.b bVar = null;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("qqLiveRoomService");
                aVar = null;
            }
            if (aVar.p() && (eVar = d.this.switchScreenService) != null) {
                eVar.c(new Size(width, height));
            }
            if (width > height) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (d.this.videoLandscape == z16) {
                return;
            }
            if (d.this.isLandScape && !z16) {
                b42.b bVar2 = d.this.audienceComponent;
                if (bVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("audienceComponent");
                } else {
                    bVar = bVar2;
                }
                bVar.c(false);
            }
            d.this.videoLandscape = z16;
            d.this.B(width, height);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(@NotNull f32.a componentContext) {
        super(componentContext);
        Intrinsics.checkNotNullParameter(componentContext, "componentContext");
        QRouteApi api = QRoute.api(IAegisLogApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IAegisLogApi::class.java)");
        this.aegisLog = (IAegisLogApi) api;
        this.liveRoomService = (fu0.c) qx0.a.b(fu0.c.class);
        this.videoLandscapeMargin = ViewUtils.dpToPx(150.0f) + ViewUtils.getStatusBarHeight(componentContext.getContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void B(final int width, final int height) {
        G().post(new Runnable() { // from class: com.tencent.mobileqq.icgame.room.displayview.component.c
            @Override // java.lang.Runnable
            public final void run() {
                d.C(d.this, width, height);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C(d this$0, int i3, int i16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.J("changeLiveContainerParams, getWidth " + this$0.G().getWidth() + ", getHeight " + this$0.G().getHeight());
        if (com.tencent.icgame.game.liveroom.impl.room.util.b.a(this$0.getComponentContext().getContext())) {
            this$0.H(i3, i16);
        } else {
            this$0.I(i3, i16);
        }
    }

    private final ViewGroup G() {
        ViewParent parent = p().getParent();
        Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
        return (ViewGroup) parent;
    }

    private final void H(int width, int height) {
        J("handleFolderScreenParams, videoLandscape: " + p().getVideoLandscape());
        ViewGroup.LayoutParams layoutParams = G().getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
        if (p().getVideoLandscape()) {
            ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin = this.videoLandscapeMargin;
            ((ViewGroup.MarginLayoutParams) layoutParams2).width = -1;
            if (width != 0 && height != 0) {
                ((ViewGroup.MarginLayoutParams) layoutParams2).height = (int) ((height / width) * ViewUtils.getScreenWidth());
            } else {
                ((ViewGroup.MarginLayoutParams) layoutParams2).height = ViewUtils.getScreenWidth() * 0;
            }
        } else {
            ((ViewGroup.MarginLayoutParams) layoutParams2).width = (int) (ut0.b.a() * 0.5625f);
            ((ViewGroup.MarginLayoutParams) layoutParams2).height = -1;
            layoutParams2.startToStart = 0;
            layoutParams2.endToEnd = 0;
        }
        G().setLayoutParams(layoutParams2);
    }

    private final void I(int width, int height) {
        J("handleNormalScreenParams, isLandScape = " + this.isLandScape + ", videoLandscape = " + p().getVideoLandscape());
        ViewGroup.LayoutParams layoutParams = G().getLayoutParams();
        if (this.isLandScape) {
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = 0;
            }
            layoutParams.width = -1;
            layoutParams.height = -1;
        } else if (p().getVideoLandscape()) {
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = this.videoLandscapeMargin;
            }
            layoutParams.width = -1;
            if (width != 0 && height != 0) {
                layoutParams.height = (int) ((height / width) * ViewUtils.getScreenWidth());
            } else {
                layoutParams.height = (int) (ViewUtils.getScreenWidth() * 0.5625f);
            }
        } else {
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = 0;
            }
            layoutParams.width = -1;
            layoutParams.height = -1;
        }
        G().setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void J(String msg2) {
        IAegisLogApi iAegisLogApi = this.aegisLog;
        h22.a aVar = this.qqLiveRoomService;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("qqLiveRoomService");
            aVar = null;
        }
        iAegisLogApi.i("ICGameDisplayViewComponent", "roomId " + aVar.getRoomId() + " " + msg2);
    }

    private final void Z() {
        p().setListener(new b());
    }

    @Override // com.tencent.mobileqq.icgame.framework.component.SingleUIComponent
    @NotNull
    /* renamed from: D, reason: merged with bridge method [inline-methods] */
    public ICGameDisplayView n() {
        ICGameDisplayView iCGameDisplayView = new ICGameDisplayView(getComponentContext().getContext(), null, 0, 6, null);
        iCGameDisplayView.setQqLiveRoomService(iCGameDisplayView.getQqLiveRoomService());
        return iCGameDisplayView;
    }

    public final void E(@NotNull MotionEvent ev5) {
        Intrinsics.checkNotNullParameter(ev5, "ev");
        p().dispatchTouchEvent(ev5);
    }

    @NotNull
    public final i F() {
        fu0.c cVar = this.liveRoomService;
        h22.a aVar = this.qqLiveRoomService;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("qqLiveRoomService");
            aVar = null;
        }
        IAudienceRoom y16 = cVar.y(aVar.getRoomId());
        if (y16 != null && (y16 instanceof ILiveAudienceTPPlayerRoom)) {
            i videoSize = ((ILiveAudienceTPPlayerRoom) y16).getVideoSize();
            Intrinsics.checkNotNullExpressionValue(videoSize, "liveRoom.videoSize");
            return videoSize;
        }
        return new i(0, 0);
    }

    public final void K() {
        p().P();
    }

    public final void L() {
        p().j0();
    }

    public final void M() {
        com.tencent.mobileqq.icgame.room.p006float.component.a aVar = this.floatControlService;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("floatControlService");
            aVar = null;
        }
        p().Q(aVar.a());
    }

    public final void N(@NotNull i22.b event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (p().R()) {
            event.c(true);
        }
    }

    public final void O() {
        ICGameDisplayView p16 = p();
        h22.a aVar = this.qqLiveRoomService;
        h22.a aVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("qqLiveRoomService");
            aVar = null;
        }
        long roomId = aVar.getRoomId();
        h22.a aVar3 = this.qqLiveRoomService;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("qqLiveRoomService");
            aVar3 = null;
        }
        p16.S(roomId, aVar3.getCurLiveInfo());
        h22.a aVar4 = this.qqLiveRoomService;
        if (aVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("qqLiveRoomService");
        } else {
            aVar2 = aVar4;
        }
        Intent intent = aVar2.getIntent();
        if (intent != null) {
            intent.removeExtra("open_from_float_window");
        }
    }

    public final void P(@NotNull ExitRoomAndPreloadSucEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        J("onExitRoomAndRePreloadSucEvent");
        p().Z(event.getRoomId(), event.getVideoUrl());
    }

    public final void Q(boolean focus) {
        p().U(focus);
    }

    public final void R(@NotNull OrientationChangedEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        i F = F();
        B(F.b(), F.a());
        this.isLandScape = event.getIsLandscape();
    }

    public final void S(@NotNull i22.e event) {
        Intrinsics.checkNotNullParameter(event, "event");
        h22.a aVar = this.qqLiveRoomService;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("qqLiveRoomService");
            aVar = null;
        }
        long roomId = aVar.getRoomId();
        px0.a.f427869a.j(roomId);
        p().X(roomId);
        i F = F();
        k22.e eVar = this.switchScreenService;
        if (eVar != null) {
            eVar.c(new Size(F.b(), F.a()));
        }
    }

    public final void T(@NotNull i22.g event) {
        Intrinsics.checkNotNullParameter(event, "event");
        ICGameDisplayView p16 = p();
        h22.a aVar = this.qqLiveRoomService;
        h22.a aVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("qqLiveRoomService");
            aVar = null;
        }
        p16.T(aVar.getRoomId());
        if (event.getIsPageClose()) {
            com.tencent.mobileqq.icgame.room.p006float.component.a aVar3 = this.floatControlService;
            if (aVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("floatControlService");
                aVar3 = null;
            }
            boolean a16 = aVar3.a();
            ICGameDisplayView p17 = p();
            h22.a aVar4 = this.qqLiveRoomService;
            if (aVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("qqLiveRoomService");
            } else {
                aVar2 = aVar4;
            }
            p17.Y(aVar2.getRoomId(), a16);
            return;
        }
        p().g0();
    }

    public final void U(@NotNull i22.h event) {
        boolean z16;
        Intrinsics.checkNotNullParameter(event, "event");
        J("onPagePreload");
        ICGameDisplayView p16 = p();
        LiveRoomExtraInfo extraInfo = event.getExtraInfo();
        if (extraInfo != null) {
            p16.setLiveExtraInfo(extraInfo);
        }
        i F = F();
        J("onPagePreload videoSize:" + F);
        if (F.b() != 0 && F.a() != 0) {
            if (F.b() > F.a()) {
                z16 = true;
            } else {
                z16 = false;
            }
            p16.setVideoLandscape(z16);
            this.videoLandscape = p16.getVideoLandscape();
            p16.d0(F.b(), F.a());
        }
        B(F.b(), F.a());
        long roomId = event.getRoomId();
        com.tencent.icgame.game.liveroom.impl.room.audience.preload.c cVar = this.preloadRoomService;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("preloadRoomService");
            cVar = null;
        }
        p16.Z(roomId, cVar.a());
    }

    public final void V() {
        if (!p().K()) {
            p().j0();
        }
        p().a0();
    }

    public final void W() {
        p().b0();
    }

    public final void X() {
        p().c0();
        px0.a aVar = px0.a.f427869a;
        h22.a aVar2 = this.qqLiveRoomService;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("qqLiveRoomService");
            aVar2 = null;
        }
        aVar.j(aVar2.getRoomId());
    }

    public final void Y() {
        p().f0();
    }

    @Override // com.tencent.mobileqq.icgame.framework.component.e
    public void k() {
        ICGameDisplayView p16 = p();
        p16.setActivityContext(getComponentContext().getContext());
        p16.setEventTrigger(getComponentContext());
        Z();
        p16.setSwitchRoomService(this.switchRoomService);
    }

    @Override // com.tencent.mobileqq.icgame.framework.component.i
    public int m() {
        return R.id.f166074yl0;
    }

    @Override // com.tencent.mobileqq.icgame.framework.component.e
    public void i() {
    }
}
