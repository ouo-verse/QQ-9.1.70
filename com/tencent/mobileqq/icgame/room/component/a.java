package com.tencent.mobileqq.icgame.room.component;

import a42.e;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.icgame.api.room.ILiveRoomOperation;
import com.tencent.mobileqq.icgame.base.baseroom.enterexitroom.EnterRoomSuccessEvent;
import com.tencent.mobileqq.icgame.base.baseroom.enterexitroom.ExitRoomAndRePreloadEvent;
import com.tencent.mobileqq.icgame.base.baseroom.enterexitroom.ExitRoomEvent;
import com.tencent.mobileqq.icgame.framework.component.SingleMVVMComponent;
import com.tencent.mobileqq.icgame.framework.eventbroadcaster.annotation.ComponentEvent;
import com.tencent.mobileqq.icgame.framework.interfaceService.InjectService;
import com.tencent.mobileqq.icgame.room.audience.ICGameAudienceView;
import com.tencent.mobileqq.icgame.room.displayview.horizontal.p;
import com.tencent.mobileqq.icgame.room.end.EndLiveEvent;
import com.tencent.mobileqq.icgame.room.input.component.c;
import com.tencent.mobileqq.icgame.room.likeowner.TouchEvent;
import com.tencent.mobileqq.icgame.room.touchdelegate.TouchDelegateView;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqlive.callback.message.IQQLiveMessageCallback;
import d22.f;
import d42.h;
import k22.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ov0.ConfigUpdateEvent;
import ov0.b;
import y32.ConfigurationChangeEvent;

/* compiled from: P */
@ComponentEvent(eventList = {EnterRoomSuccessEvent.class, ExitRoomEvent.class, b.class, ConfigUpdateEvent.class, h.class, ExitRoomAndRePreloadEvent.class, ConfigurationChangeEvent.class, f.class, com.tencent.icgame.game.liveroom.impl.room.roomconfig.b.class, EndLiveEvent.class, c.class, TouchEvent.class})
@Metadata(d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004B\u000f\u0012\u0006\u0010O\u001a\u00020N\u00a2\u0006\u0004\bP\u0010QJ\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\u0007\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0003H\u0016J\b\u0010\t\u001a\u00020\u0002H\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\u0006\u0010\f\u001a\u00020\u0005J\u0006\u0010\r\u001a\u00020\u0005J\u0006\u0010\u000e\u001a\u00020\u0005J\u0006\u0010\u000f\u001a\u00020\u0005J\u0006\u0010\u0010\u001a\u00020\u0005J\u0006\u0010\u0011\u001a\u00020\u0005J\u0006\u0010\u0012\u001a\u00020\u0005J\u0006\u0010\u0013\u001a\u00020\u0005J\u0006\u0010\u0014\u001a\u00020\u0005J\u0006\u0010\u0015\u001a\u00020\u0005J\u0006\u0010\u0016\u001a\u00020\u0005J\u0016\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0017J\u0006\u0010\u001b\u001a\u00020\u0005J\u000e\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u0017J\u000e\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\nJ\u0006\u0010!\u001a\u00020 J\b\u0010#\u001a\u0004\u0018\u00010\"J\b\u0010%\u001a\u0004\u0018\u00010$J\u000e\u0010(\u001a\u00020\u00052\u0006\u0010'\u001a\u00020&J\b\u0010)\u001a\u00020\u0017H\u0016J\u0010\u0010+\u001a\u00020\u00052\u0006\u0010*\u001a\u00020\u0003H\u0016J\u0006\u0010,\u001a\u00020\u0017J\b\u0010-\u001a\u0004\u0018\u00010\"J\b\u0010.\u001a\u0004\u0018\u00010\"J\b\u0010/\u001a\u0004\u0018\u00010\"J\b\u00101\u001a\u0004\u0018\u000100J\b\u00102\u001a\u0004\u0018\u00010 R\u0016\u00104\u001a\u0002038\u0002@\u0002X\u0083.\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0018\u00107\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0083\u000e\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0018\u0010:\u001a\u0004\u0018\u0001098\u0002@\u0002X\u0083\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010=\u001a\u00020<8\u0002@\u0002X\u0083.\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010@\u001a\u00020?8\u0002@\u0002X\u0083.\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010C\u001a\u0004\u0018\u00010B8\u0002X\u0083\u0004\u00a2\u0006\u0006\n\u0004\bC\u0010DR\u0016\u0010F\u001a\u00020E8\u0002@\u0002X\u0083.\u00a2\u0006\u0006\n\u0004\bF\u0010GR\u0018\u0010I\u001a\u0004\u0018\u00010H8\u0002@\u0002X\u0083\u000e\u00a2\u0006\u0006\n\u0004\bI\u0010JR\u0016\u0010L\u001a\u0004\u0018\u00010K8\u0002X\u0083\u0004\u00a2\u0006\u0006\n\u0004\bL\u0010M\u00a8\u0006R"}, d2 = {"Lcom/tencent/mobileqq/icgame/room/component/a;", "Lcom/tencent/mobileqq/icgame/framework/component/SingleMVVMComponent;", "Lcom/tencent/mobileqq/icgame/room/audience/ICGameAudienceView;", "Lcom/tencent/mobileqq/icgame/room/component/ICGameAudienceViewModel;", "Lk22/b;", "", "k", "i", "y", HippyTKDListViewAdapter.X, "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "U", "V", "T", "M", "L", "K", "N", "J", MosaicConstants$JsFunction.FUNC_ON_DESTROY, ExifInterface.LATITUDE_SOUTH, AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "", "isPageClose", "shouldExitRoom", BdhLogUtil.LogTag.Tag_Req, "W", "fullScreen", "X", "state", "O", "Landroid/view/View;", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Landroid/widget/FrameLayout;", "B", "Landroid/widget/LinearLayout;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "", "text", "P", "handleBackPressed", "vm", "I", "H", BdhLogUtil.LogTag.Tag_Conn, UserInfo.SEX_FEMALE, "E", "Lcom/tencent/mobileqq/icgame/room/touchdelegate/TouchDelegateView;", "G", "D", "Lh22/a;", "qqLiveRoomService", "Lh22/a;", "Lp22/a;", "switchRoomService", "Lp22/a;", "Lk22/e;", "switchScreenService", "Lk22/e;", "Lcom/tencent/mobileqq/icgame/room/displayview/component/a;", "liveRoomDisplayService", "Lcom/tencent/mobileqq/icgame/room/displayview/component/a;", "Lcom/tencent/mobileqq/icgame/room/displayview/horizontal/p;", "horizontalCtrlService", "Lcom/tencent/mobileqq/icgame/room/displayview/horizontal/p;", "Lb42/b;", "qqLiveAudienceSupport", "Lb42/b;", "La42/e;", "clearScreenService", "La42/e;", "Lcom/tencent/mobileqq/icgame/room/likeowner/a;", "liveLikeViewService", "Lcom/tencent/mobileqq/icgame/room/likeowner/a;", "Lcom/tencent/mobileqq/icgame/room/message/component/a;", "messageLayoutService", "Lcom/tencent/mobileqq/icgame/room/message/component/a;", "Lf32/a;", "componentContext", "<init>", "(Lf32/a;)V", "ic-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class a extends SingleMVVMComponent<ICGameAudienceView, ICGameAudienceViewModel> implements k22.b {

    @InjectService(key = e.class)
    private e clearScreenService;

    @InjectService(key = p.class)
    private p horizontalCtrlService;

    @InjectService(key = com.tencent.mobileqq.icgame.room.likeowner.a.class)
    @Nullable
    private com.tencent.mobileqq.icgame.room.likeowner.a liveLikeViewService;

    @InjectService(key = com.tencent.mobileqq.icgame.room.displayview.component.a.class)
    private com.tencent.mobileqq.icgame.room.displayview.component.a liveRoomDisplayService;

    @InjectService(key = com.tencent.mobileqq.icgame.room.message.component.a.class)
    @Nullable
    private final com.tencent.mobileqq.icgame.room.message.component.a messageLayoutService;

    @InjectService(key = b42.b.class)
    @Nullable
    private final b42.b qqLiveAudienceSupport;

    @InjectService(key = h22.a.class)
    private h22.a qqLiveRoomService;

    @InjectService(key = p22.a.class)
    @Nullable
    private p22.a switchRoomService;

    @InjectService(key = k22.e.class)
    @Nullable
    private k22.e switchScreenService;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NotNull f32.a componentContext) {
        super(componentContext);
        Intrinsics.checkNotNullParameter(componentContext, "componentContext");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    public final LinearLayout A() {
        return ((ICGameAudienceView) p()).A();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    public final FrameLayout B() {
        return ((ICGameAudienceView) p()).B();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    public final FrameLayout C() {
        return ((ICGameAudienceView) p()).D();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    public final View D() {
        return ((ICGameAudienceView) p()).E();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    public final FrameLayout E() {
        return ((ICGameAudienceView) p()).F();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    public final FrameLayout F() {
        return ((ICGameAudienceView) p()).G();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    public final TouchDelegateView G() {
        return ((ICGameAudienceView) p()).H();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean H() {
        return ((ICGameAudienceView) p()).O();
    }

    @Override // com.tencent.mobileqq.icgame.framework.component.SingleMVVMComponent
    /* renamed from: I, reason: merged with bridge method [inline-methods] */
    public void u(@NotNull ICGameAudienceViewModel vm5) {
        Intrinsics.checkNotNullParameter(vm5, "vm");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void J() {
        ((ICGameAudienceView) p()).S();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void K() {
        ((ICGameAudienceView) p()).T();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void L() {
        ((ICGameAudienceView) p()).U();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void M() {
        ((ICGameAudienceView) p()).V();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void N() {
        ((ICGameAudienceView) p()).W();
    }

    public final void P(@NotNull String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        fu0.c cVar = (fu0.c) qx0.a.b(fu0.c.class);
        h22.a aVar = this.qqLiveRoomService;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("qqLiveRoomService");
            aVar = null;
        }
        ILiveRoomOperation A = cVar.A(aVar.getRoomId());
        if (A != null) {
            A.sendMessage(text, null, new C7926a());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void Q() {
        ICGameAudienceView iCGameAudienceView = (ICGameAudienceView) p();
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
        } else {
            aVar2 = aVar3;
        }
        iCGameAudienceView.b0(roomId, aVar2.k());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void R(boolean isPageClose, boolean shouldExitRoom) {
        ICGameAudienceView iCGameAudienceView = (ICGameAudienceView) p();
        h22.a aVar = this.qqLiveRoomService;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("qqLiveRoomService");
            aVar = null;
        }
        iCGameAudienceView.c0(aVar.getRoomId(), isPageClose, shouldExitRoom);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void S() {
        ICGameAudienceView iCGameAudienceView = (ICGameAudienceView) p();
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
        String a16 = aVar3.a();
        h22.a aVar4 = this.qqLiveRoomService;
        if (aVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("qqLiveRoomService");
        } else {
            aVar2 = aVar4;
        }
        iCGameAudienceView.d0(roomId, a16, aVar2.k());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void T() {
        ((ICGameAudienceView) p()).e0();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void W() {
        ((ICGameAudienceView) p()).g0();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void X(boolean fullScreen) {
        ((ICGameAudienceView) p()).i0(fullScreen);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // k22.b
    public boolean handleBackPressed() {
        return ((ICGameAudienceView) p()).X();
    }

    @Override // com.tencent.mobileqq.icgame.framework.component.SingleMVVMComponent, com.tencent.mobileqq.icgame.framework.component.e
    public void i() {
        super.i();
        h22.a aVar = this.qqLiveRoomService;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("qqLiveRoomService");
            aVar = null;
        }
        aVar.i(this);
    }

    @Override // k22.b
    public void j() {
        b.a.b(this);
    }

    @Override // com.tencent.mobileqq.icgame.framework.component.SingleMVVMComponent, com.tencent.mobileqq.icgame.framework.component.e
    public void k() {
        h22.a aVar = this.qqLiveRoomService;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("qqLiveRoomService");
            aVar = null;
        }
        aVar.g(this);
    }

    @Override // com.tencent.mobileqq.icgame.framework.component.i
    public int m() {
        return R.id.xcv;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDestroy() {
        ((ICGameAudienceView) p()).onDestroy();
    }

    @Override // com.tencent.mobileqq.icgame.framework.component.SingleUIComponent
    @NotNull
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public ICGameAudienceView n() {
        ICGameAudienceView iCGameAudienceView = new ICGameAudienceView(getComponentContext().getContext());
        h22.a aVar = this.qqLiveRoomService;
        p pVar = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("qqLiveRoomService");
            aVar = null;
        }
        iCGameAudienceView.setQQLiveRoomService(aVar);
        iCGameAudienceView.setSwitchScreenService(this.switchScreenService);
        iCGameAudienceView.setViewModel(t());
        iCGameAudienceView.setActivityContext(getComponentContext().getContext());
        p pVar2 = this.horizontalCtrlService;
        if (pVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("horizontalCtrlService");
        } else {
            pVar = pVar2;
        }
        iCGameAudienceView.setHorizontalCtrlService(pVar);
        return iCGameAudienceView;
    }

    @Override // com.tencent.mobileqq.icgame.framework.component.SingleMVVMComponent
    @NotNull
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public ICGameAudienceViewModel s() {
        return new ICGameAudienceViewModel(getComponentContext());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public final View z() {
        View z16 = ((ICGameAudienceView) p()).z();
        Intrinsics.checkNotNullExpressionValue(z16, "view.chatMessageLayoutAboveBackgroundView");
        return z16;
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\u0004H\u0016J\u0012\u0010\r\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/icgame/room/component/a$a", "Lcom/tencent/mobileqq/qqlive/callback/message/IQQLiveMessageCallback;", "", "isLocal", "", "onSuccess", "", "errCode", "", "errMsg", "onFail", "onIllegalMsg", "msg", "onUserForbid", "ic-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.icgame.room.component.a$a, reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    public static final class C7926a implements IQQLiveMessageCallback {
        C7926a() {
        }

        @Override // com.tencent.mobileqq.qqlive.callback.message.IQQLiveMessageCallback
        public void onFail(int errCode, @NotNull String errMsg) {
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        }

        @Override // com.tencent.mobileqq.qqlive.callback.message.IQQLiveMessageCallback
        public void onIllegalMsg() {
        }

        @Override // com.tencent.mobileqq.qqlive.callback.message.IQQLiveMessageCallback
        public void onSuccess(boolean isLocal) {
        }

        @Override // com.tencent.mobileqq.qqlive.callback.message.IQQLiveMessageCallback
        public void onUserForbid(@Nullable String msg2) {
        }
    }

    public final void U() {
    }

    public final void V() {
    }

    public final void O(int state) {
    }
}
