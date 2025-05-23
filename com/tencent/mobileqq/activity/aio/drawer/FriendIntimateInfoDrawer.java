package com.tencent.mobileqq.activity.aio.drawer;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aio.data.AIOParam;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.common.config.AppSetting;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.activity.aio.IntimateInfoView;
import com.tencent.mobileqq.activity.aio.al;
import com.tencent.mobileqq.activity.aio.intimate.MainIntimateTitlePart;
import com.tencent.mobileqq.activity.aio.intimate.MainIntimateView;
import com.tencent.mobileqq.activity.aio.intimate.header.n;
import com.tencent.mobileqq.activity.aio.intimate.reborn.model.ZPlanUpgradeEvent;
import com.tencent.mobileqq.activity.aio.zplan.IntimateUpgradeBannerView;
import com.tencent.mobileqq.activity.aio.zplan.ZPlanIntimateInfoView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qui.QUIImmersiveHelper;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.zplan.aio.couple.CoupleAvatarSubScene;
import com.tencent.mobileqq.zplan.aio.couple.i;
import com.tencent.mobileqq.zplan.api.IZPlanShowGuideApi;
import com.tencent.mobileqq.zplan.couple.ZPlanCoupleSwitchChgSource;
import com.tencent.mobileqq.zplan.couple.api.IZPlanCoupleSceneHelper;
import com.tencent.mobileqq.zplan.show.IZPlanMsgService;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 P2\u00020\u00012\u00020\u00022\u00020\u00032\b\u0012\u0004\u0012\u00020\u00050\u0004:\u0001QB\u000f\u0012\u0006\u00103\u001a\u000200\u00a2\u0006\u0004\bN\u0010OJ\b\u0010\u0007\u001a\u00020\u0006H\u0002J \u0010\u000f\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u0011\u001a\u00020\u0010H\u0002J\b\u0010\u0012\u001a\u00020\u0010H\u0002J\n\u0010\u0013\u001a\u0004\u0018\u00010\u000eH\u0002J\b\u0010\u0014\u001a\u00020\u0006H\u0002J\u0010\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0010H\u0002J(\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\u00172\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u0010H\u0002J\b\u0010\u0019\u001a\u00020\u0006H\u0002J\u0010\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u0010H\u0002J\n\u0010\u001c\u001a\u0004\u0018\u00010\u000eH\u0016J\u0012\u0010\u001e\u001a\u00020\u00062\b\u0010\u001d\u001a\u0004\u0018\u00010\u0005H\u0016J$\u0010\"\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050 0\u001fj\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050 `!H\u0016J\u0018\u0010&\u001a\u00020\u00062\u0006\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020#H\u0016J\u000e\u0010'\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0010J\u0006\u0010(\u001a\u00020\u0006J\u0006\u0010)\u001a\u00020\u0006J\b\u0010*\u001a\u00020\u0006H\u0007J\b\u0010+\u001a\u00020\u0006H\u0007J\u0010\u0010.\u001a\u00020\u00062\u0006\u0010-\u001a\u00020,H\u0016J\b\u0010/\u001a\u00020\u0006H\u0007R\u0014\u00103\u001a\u0002008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u00104R\u0018\u00108\u001a\u0004\u0018\u0001058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0018\u0010<\u001a\u0004\u0018\u0001098\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0018\u0010@\u001a\u0004\u0018\u00010=8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u0018\u0010D\u001a\u0004\u0018\u00010A8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010CR\u0016\u0010G\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bE\u0010FR\u0017\u0010M\u001a\u00020H8\u0006\u00a2\u0006\f\n\u0004\bI\u0010J\u001a\u0004\bK\u0010L\u00a8\u0006R"}, d2 = {"Lcom/tencent/mobileqq/activity/aio/drawer/FriendIntimateInfoDrawer;", "Lcom/tencent/aio/frame/api/c;", "Landroidx/lifecycle/LifecycleObserver;", "Lcom/tencent/aio/frame/api/d;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/app/QBaseActivity;", "baseActivity", "Landroid/content/Context;", "context", "", "friendUin", "Landroid/view/View;", "r", "", "B", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "t", "y", "fromScroll", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Lcom/tencent/mobileqq/app/BaseActivity;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, HippyTKDListViewAdapter.X, "updateIntimate", ReportConstant.COSTREPORT_PREFIX, "j", "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "", "scrollX", "oldScrollX", "b", "w", "v", "u", "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "d", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/aio/data/AIOParam;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/aio/data/AIOParam;", "param", "Ljava/lang/String;", "Lcom/tencent/mobileqq/activity/aio/intimate/MainIntimateView;", "D", "Lcom/tencent/mobileqq/activity/aio/intimate/MainIntimateView;", "mIntimateInfoView", "Lh61/d;", "E", "Lh61/d;", "part", "Lcom/tencent/mobileqq/activity/aio/zplan/ZPlanIntimateInfoView;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/activity/aio/zplan/ZPlanIntimateInfoView;", "mCoupleAvatarView", "Landroid/widget/RelativeLayout;", "G", "Landroid/widget/RelativeLayout;", "mRootView", "H", "Z", "initialized", "Lcom/tencent/aio/api/runtime/emitter/a;", "I", "Lcom/tencent/aio/api/runtime/emitter/a;", "getOnBackEvent", "()Lcom/tencent/aio/api/runtime/emitter/a;", "onBackEvent", "<init>", "(Lcom/tencent/aio/data/AIOParam;)V", "J", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class FriendIntimateInfoDrawer extends com.tencent.aio.frame.api.c implements LifecycleObserver, com.tencent.aio.frame.api.d, SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final String friendUin;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private MainIntimateView mIntimateInfoView;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private h61.d part;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private ZPlanIntimateInfoView mCoupleAvatarView;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private RelativeLayout mRootView;

    /* renamed from: H, reason: from kotlin metadata */
    private boolean initialized;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.aio.api.runtime.emitter.a onBackEvent;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AIOParam param;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/activity/aio/drawer/FriendIntimateInfoDrawer$b", "Lcom/tencent/mobileqq/activity/aio/zplan/c;", "", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class b implements com.tencent.mobileqq.activity.aio.zplan.c {
        b() {
        }

        @Override // com.tencent.mobileqq.activity.aio.zplan.c
        public void a() {
            FriendIntimateInfoDrawer.this.s(false);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/activity/aio/drawer/FriendIntimateInfoDrawer$c", "Lcom/tencent/mobileqq/activity/aio/zplan/ZPlanIntimateInfoView;", "", "g0", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class c extends ZPlanIntimateInfoView {

        /* renamed from: e0, reason: collision with root package name */
        final /* synthetic */ FriendIntimateInfoDrawer f178615e0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(BaseActivity baseActivity, Context context, String str, boolean z16, FriendIntimateInfoDrawer friendIntimateInfoDrawer, IZPlanMsgService iZPlanMsgService) {
            super(baseActivity, context, str, iZPlanMsgService, z16);
            this.f178615e0 = friendIntimateInfoDrawer;
            Intrinsics.checkNotNullExpressionValue(iZPlanMsgService, "apply {\n                \u2026am = param)\n            }");
        }

        @Override // com.tencent.mobileqq.activity.aio.zplan.ZPlanIntimateInfoView
        public void g0() {
            com.tencent.aio.frame.api.e.g(this.f178615e0.g(), 0, 1, null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/activity/aio/drawer/FriendIntimateInfoDrawer$d", "Lcom/tencent/aio/api/runtime/emitter/a;", "", "onBackEvent", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class d implements com.tencent.aio.api.runtime.emitter.a {
        d() {
        }

        @Override // com.tencent.aio.api.runtime.emitter.a
        public boolean onBackEvent() {
            if (!FriendIntimateInfoDrawer.this.g().i()) {
                return false;
            }
            if (FriendIntimateInfoDrawer.this.A()) {
                h61.d dVar = FriendIntimateInfoDrawer.this.part;
                if (dVar == null) {
                    return false;
                }
                return dVar.s();
            }
            MainIntimateView mainIntimateView = FriendIntimateInfoDrawer.this.mIntimateInfoView;
            if (mainIntimateView == null) {
                return false;
            }
            return mainIntimateView.z();
        }
    }

    public FriendIntimateInfoDrawer(@NotNull AIOParam param) {
        Intrinsics.checkNotNullParameter(param, "param");
        this.param = param;
        this.friendUin = String.valueOf(param.l().getLong("key_peerUin", 0L));
        this.onBackEvent = new d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean A() {
        boolean z16 = !n.c();
        QLog.i("FriendIntimateInfoDrawer", 1, "showPart=" + z16);
        return z16;
    }

    private final boolean B() {
        return true;
    }

    private final void C() {
        x();
        if (this.mIntimateInfoView != null || this.part != null || !(f() instanceof QBaseActivity)) {
            return;
        }
        Context f16 = f();
        Intrinsics.checkNotNull(f16, "null cannot be cast to non-null type com.tencent.mobileqq.app.QBaseActivity");
        View r16 = r((QBaseActivity) f16, f(), this.friendUin);
        RelativeLayout relativeLayout = this.mRootView;
        if (relativeLayout != null) {
            relativeLayout.addView(r16, new ViewGroup.LayoutParams(-2, -2));
        }
    }

    private final View q(BaseActivity baseActivity, Context context, String friendUin, boolean fromScroll) {
        IZPlanMsgService iZPlanMsgService = (IZPlanMsgService) QRoute.api(IZPlanMsgService.class);
        iZPlanMsgService.init(this.param);
        c cVar = new c(baseActivity, context, friendUin, fromScroll, this, iZPlanMsgService);
        cVar.r0(i());
        this.mCoupleAvatarView = cVar;
        cVar.q0(new b());
        return cVar.getRootView();
    }

    private final View r(QBaseActivity baseActivity, final Context context, final String friendUin) {
        IntimateUpgradeBannerView intimateUpgradeBannerView;
        if (A()) {
            h61.d dVar = new h61.d(baseActivity, friendUin, i());
            this.part = dVar;
            dVar.D(g());
        } else if (B()) {
            al alVar = new al(baseActivity, context, friendUin, baseActivity.getSupportFragmentManager());
            this.mIntimateInfoView = alVar;
            alVar.m0(g());
        } else {
            IntimateInfoView intimateInfoView = new IntimateInfoView(baseActivity, context, friendUin);
            this.mIntimateInfoView = intimateInfoView;
            intimateInfoView.f0();
            intimateInfoView.g0(e());
            intimateInfoView.m0(g());
        }
        MainIntimateView mainIntimateView = this.mIntimateInfoView;
        if (mainIntimateView != null && (intimateUpgradeBannerView = mainIntimateView.f178904g0) != null) {
            intimateUpgradeBannerView.setCallback(new com.tencent.mobileqq.activity.aio.zplan.a() { // from class: com.tencent.mobileqq.activity.aio.drawer.FriendIntimateInfoDrawer$createIntimateInfoView$1
                @Override // com.tencent.mobileqq.activity.aio.zplan.a
                public void a() {
                    MainIntimateView mainIntimateView2 = FriendIntimateInfoDrawer.this.mIntimateInfoView;
                    if (mainIntimateView2 != null) {
                        String str = friendUin;
                        FriendIntimateInfoDrawer friendIntimateInfoDrawer = FriendIntimateInfoDrawer.this;
                        Context context2 = context;
                        mainIntimateView2.L("dt_clck");
                        ((IZPlanShowGuideApi) QRoute.api(IZPlanShowGuideApi.class)).onShowDialogFromUpgradeBanner(str, new FriendIntimateInfoDrawer$createIntimateInfoView$1$onClickUpgrade$1$1(friendIntimateInfoDrawer, context2));
                    }
                }
            });
        }
        MainIntimateView mainIntimateView2 = this.mIntimateInfoView;
        View view = null;
        if (mainIntimateView2 != null) {
            mainIntimateView2.P(false, null);
        }
        MainIntimateView mainIntimateView3 = this.mIntimateInfoView;
        if (mainIntimateView3 != null) {
            mainIntimateView3.R(false);
        }
        if (A()) {
            h61.d dVar2 = this.part;
            if (dVar2 != null) {
                view = dVar2.getRootView();
            }
        } else {
            MainIntimateView mainIntimateView4 = this.mIntimateInfoView;
            if (mainIntimateView4 != null) {
                view = mainIntimateView4.r();
            }
        }
        if (view == null) {
            return new View(context);
        }
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s(boolean updateIntimate) {
        if (!updateIntimate) {
            ((IZPlanCoupleSceneHelper) QRoute.api(IZPlanCoupleSceneHelper.class)).setCoupleAvatarSwitchState(this.friendUin, updateIntimate, ZPlanCoupleSwitchChgSource.INTIMATE_ACTION_SHEET);
            QRouteApi api = QRoute.api(IZPlanCoupleSceneHelper.class);
            Intrinsics.checkNotNullExpressionValue(api, "api(IZPlanCoupleSceneHelper::class.java)");
            i a16 = IZPlanCoupleSceneHelper.a.a((IZPlanCoupleSceneHelper) api, this.friendUin, null, 2, null);
            if (a16 != null) {
                a16.g();
            }
            if (a16 != null) {
                a16.d(CoupleAvatarSubScene.AIO);
            }
        }
        w(false);
        v();
        onResume();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final View t() {
        MainIntimateView intimateView;
        MainIntimateTitlePart m3;
        ZPlanIntimateInfoView zPlanIntimateInfoView = this.mCoupleAvatarView;
        if (zPlanIntimateInfoView == null || (intimateView = zPlanIntimateInfoView.getIntimateView()) == null || (m3 = intimateView.m()) == null) {
            return null;
        }
        return m3.ba();
    }

    private final void x() {
        if (this.mCoupleAvatarView == null) {
            return;
        }
        RelativeLayout relativeLayout = this.mRootView;
        if (relativeLayout != null) {
            relativeLayout.removeAllViews();
        }
        ZPlanIntimateInfoView zPlanIntimateInfoView = this.mCoupleAvatarView;
        if (zPlanIntimateInfoView != null) {
            zPlanIntimateInfoView.h0();
        }
        this.mCoupleAvatarView = null;
    }

    private final void y() {
        if (this.mIntimateInfoView == null && this.part == null) {
            return;
        }
        RelativeLayout relativeLayout = this.mRootView;
        if (relativeLayout != null) {
            relativeLayout.removeAllViews();
        }
        h61.d dVar = this.part;
        if (dVar != null) {
            dVar.onDestroy();
        }
        this.part = null;
        MainIntimateView mainIntimateView = this.mIntimateInfoView;
        if (mainIntimateView != null) {
            mainIntimateView.B();
        }
        this.mIntimateInfoView = null;
    }

    private final void z(boolean fromScroll) {
        y();
        if (this.mCoupleAvatarView != null || !(f() instanceof BaseActivity)) {
            return;
        }
        Context f16 = f();
        Intrinsics.checkNotNull(f16, "null cannot be cast to non-null type com.tencent.mobileqq.app.BaseActivity");
        View q16 = q((BaseActivity) f16, f(), this.friendUin, fromScroll);
        RelativeLayout relativeLayout = this.mRootView;
        if (relativeLayout != null) {
            relativeLayout.addView(q16, new ViewGroup.LayoutParams(-2, -2));
        }
    }

    @Override // com.tencent.aio.frame.api.d
    public void b(int scrollX, int oldScrollX) {
        boolean z16 = true;
        if (oldScrollX < scrollX && scrollX > 0 && !this.initialized) {
            w(true);
            return;
        }
        if (oldScrollX < scrollX) {
            RelativeLayout relativeLayout = this.mRootView;
            if (relativeLayout == null || scrollX != relativeLayout.getWidth()) {
                z16 = false;
            }
            if (z16) {
                v();
                return;
            }
        }
        if (oldScrollX > 0 && scrollX == 0) {
            u();
        }
    }

    @Override // com.tencent.aio.frame.api.c
    public void d(@NotNull ViewGroup container) {
        Intrinsics.checkNotNullParameter(container, "container");
        super.d(container);
        h61.d dVar = this.part;
        if (dVar != null) {
            dVar.onDestroy();
        }
        this.part = null;
        MainIntimateView mainIntimateView = this.mIntimateInfoView;
        if (mainIntimateView != null) {
            mainIntimateView.B();
        }
        this.mIntimateInfoView = null;
        ZPlanIntimateInfoView zPlanIntimateInfoView = this.mCoupleAvatarView;
        if (zPlanIntimateInfoView != null) {
            zPlanIntimateInfoView.h0();
        }
        this.mCoupleAvatarView = null;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(ZPlanUpgradeEvent.class);
        return arrayListOf;
    }

    @Override // com.tencent.aio.frame.api.c
    @Nullable
    public View j() {
        this.mRootView = new RelativeLayout(f());
        i().getLifecycle().addObserver(this);
        g().a(this);
        h().a(com.tencent.aio.api.runtime.emitter.a.class).a(this.onBackEvent);
        return this.mRootView;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestroy() {
        QLog.i("FriendIntimateInfoDrawer", 4, "onDrawerOnDestroy");
        h().a(com.tencent.aio.api.runtime.emitter.a.class).c(this.onBackEvent);
        h61.d dVar = this.part;
        if (dVar != null) {
            dVar.onDestroy();
        }
        this.part = null;
        MainIntimateView mainIntimateView = this.mIntimateInfoView;
        if (mainIntimateView != null) {
            mainIntimateView.B();
        }
        this.mIntimateInfoView = null;
        ZPlanIntimateInfoView zPlanIntimateInfoView = this.mCoupleAvatarView;
        if (zPlanIntimateInfoView != null) {
            zPlanIntimateInfoView.h0();
        }
        this.mCoupleAvatarView = null;
        i().getLifecycle().removeObserver(this);
        g().c(this);
        ZPlanIntimateInfoView zPlanIntimateInfoView2 = this.mCoupleAvatarView;
        if (zPlanIntimateInfoView2 != null) {
            zPlanIntimateInfoView2.q0(null);
        }
        RelativeLayout relativeLayout = this.mRootView;
        if (relativeLayout != null) {
            relativeLayout.removeAllViews();
        }
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("101733", false);
        QLog.i("FriendIntimateInfoDrawer", 4, "rootViewNullSwitch " + isSwitchOn);
        if (isSwitchOn) {
            this.mRootView = null;
        }
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public final void onPause() {
        h61.d dVar = this.part;
        if (dVar != null) {
            dVar.w();
        }
        MainIntimateView mainIntimateView = this.mIntimateInfoView;
        if (mainIntimateView != null) {
            mainIntimateView.F();
        }
        ZPlanIntimateInfoView zPlanIntimateInfoView = this.mCoupleAvatarView;
        if (zPlanIntimateInfoView != null) {
            zPlanIntimateInfoView.l0();
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        ((IZPlanShowGuideApi) QRoute.api(IZPlanShowGuideApi.class)).onShowDialogFromUpgradeBanner(this.friendUin, new FriendIntimateInfoDrawer$onReceiveEvent$1(this));
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public final void onResume() {
        if (!g().i()) {
            return;
        }
        h61.d dVar = this.part;
        if (dVar != null) {
            dVar.x();
        }
        MainIntimateView mainIntimateView = this.mIntimateInfoView;
        if (mainIntimateView != null) {
            mainIntimateView.G();
        }
        ZPlanIntimateInfoView zPlanIntimateInfoView = this.mCoupleAvatarView;
        if (zPlanIntimateInfoView != null) {
            zPlanIntimateInfoView.m0();
        }
    }

    public final void u() {
        QLog.d("FriendIntimateInfoDrawer", 4, "onDrawerClosed");
        this.initialized = false;
        h61.d dVar = this.part;
        if (dVar != null) {
            dVar.t();
        }
        MainIntimateView mainIntimateView = this.mIntimateInfoView;
        if (mainIntimateView != null) {
            mainIntimateView.C();
        }
        ZPlanIntimateInfoView zPlanIntimateInfoView = this.mCoupleAvatarView;
        if (zPlanIntimateInfoView != null) {
            zPlanIntimateInfoView.i0();
        }
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    public final void v() {
        QLog.d("FriendIntimateInfoDrawer", 4, "onDrawerOpened");
        h61.d dVar = this.part;
        if (dVar != null) {
            dVar.u();
        }
        MainIntimateView mainIntimateView = this.mIntimateInfoView;
        if (mainIntimateView != null) {
            mainIntimateView.D();
        }
        ZPlanIntimateInfoView zPlanIntimateInfoView = this.mCoupleAvatarView;
        if (zPlanIntimateInfoView != null) {
            zPlanIntimateInfoView.j0();
        }
        Context f16 = f();
        Intrinsics.checkNotNull(f16, "null cannot be cast to non-null type com.tencent.mobileqq.app.QBaseActivity");
        QUIImmersiveHelper.s((QBaseActivity) f16, true, true);
    }

    public final void w(boolean fromScroll) {
        QLog.d("FriendIntimateInfoDrawer", 4, "onDrawerStartOpen");
        this.initialized = true;
        boolean coupleAvatarSwitchState = ((IZPlanCoupleSceneHelper) QRoute.api(IZPlanCoupleSceneHelper.class)).getCoupleAvatarSwitchState(this.friendUin);
        boolean t16 = AppSetting.t(f());
        if (coupleAvatarSwitchState && !t16) {
            y();
            z(fromScroll);
        } else {
            x();
            C();
        }
        h61.d dVar = this.part;
        if (dVar != null) {
            dVar.v();
        }
        MainIntimateView mainIntimateView = this.mIntimateInfoView;
        if (mainIntimateView != null) {
            mainIntimateView.E();
        }
        ZPlanIntimateInfoView zPlanIntimateInfoView = this.mCoupleAvatarView;
        if (zPlanIntimateInfoView != null) {
            zPlanIntimateInfoView.k0();
        }
        SimpleEventBus.getInstance().registerReceiver(this);
    }
}
