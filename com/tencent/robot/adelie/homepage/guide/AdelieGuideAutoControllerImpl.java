package com.tencent.robot.adelie.homepage.guide;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Rect;
import android.view.animation.AccelerateInterpolator;
import android.widget.RelativeLayout;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import com.tencent.qqnt.kernel.nativeinterface.RobotCoreInfo;
import com.tencent.qqnt.kernel.nativeinterface.RobotGuideInfo;
import com.tencent.robot.adelie.homepage.eventbus.AdelieNewOrOldGuideEvent;
import com.tencent.robot.adelie.homepage.eventbus.AdelieRobotGuideAnimationEvent;
import com.tencent.robot.adelie.homepage.eventbus.AdelieRobotGuideCompleteEvent;
import com.tencent.robot.adelie.homepage.eventbus.AdelieRobotGuideTabChangeStopAnimationEvent;
import com.tencent.robot.adelie.homepage.utils.AIOUtil;
import com.tencent.robot.adelie.homepage.utils.AdelieGuideUtil;
import com.tencent.robot.adelie.homepage.utils.i;
import com.tencent.robot.aio.background.api.IRobotBackgroundApi;
import com.tencent.robot.qqmc.RobotQQMC;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t14.f;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 B2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u001dB\u001b\u0012\u0006\u0010\"\u001a\u00020\u001f\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010#\u00a2\u0006\u0004\b@\u0010AJ&\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002J\u0016\u0010\f\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002J\u0016\u0010\r\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002J\b\u0010\u000e\u001a\u00020\tH\u0002J\b\u0010\u000f\u001a\u00020\tH\u0002J\b\u0010\u0010\u001a\u00020\tH\u0002J\b\u0010\u0011\u001a\u00020\tH\u0002J\b\u0010\u0012\u001a\u00020\tH\u0002J\b\u0010\u0013\u001a\u00020\tH\u0016J\b\u0010\u0014\u001a\u00020\tH\u0016J\u0012\u0010\u0016\u001a\u00020\t2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0003H\u0016J$\u0010\u001a\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00180\u0017j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0018`\u0019H\u0016J\u0010\u0010\u001c\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u001bH\u0016J\b\u0010\u001d\u001a\u00020\tH\u0016J\b\u0010\u001e\u001a\u00020\tH\u0016R\u0014\u0010\"\u001a\u00020\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010&\u001a\u0004\u0018\u00010#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010*\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010-\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0018\u00100\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0018\u00103\u001a\u0004\u0018\u0001018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u00102R\u0018\u00107\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0018\u0010;\u001a\u0004\u0018\u0001088\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010?\u001a\u00020<8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010>\u00a8\u0006C"}, d2 = {"Lcom/tencent/robot/adelie/homepage/guide/AdelieGuideAutoControllerImpl;", "Lcom/tencent/robot/adelie/homepage/guide/a;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "Lcom/tencent/qqnt/kernel/nativeinterface/RobotGuideInfo;", "robotGuideInfo", "Landroid/graphics/Rect;", CanvasView.ACTION_RECT, "Lkotlin/Function0;", "", "onComplete", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, ReportConstant.COSTREPORT_PREFIX, "p", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, DomainData.DOMAIN_NAME, "t", "r", "u", "b", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "Lcom/tencent/robot/adelie/homepage/eventbus/AdelieRobotGuideCompleteEvent;", "v", "a", "c", "Landroid/content/Context;", "d", "Landroid/content/Context;", "context", "Landroid/widget/RelativeLayout;", "e", "Landroid/widget/RelativeLayout;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Lcom/tencent/robot/adelie/homepage/guide/AdelieGuideAnimationContainer;", "f", "Lcom/tencent/robot/adelie/homepage/guide/AdelieGuideAnimationContainer;", "animatorContainer", h.F, "Landroid/graphics/Rect;", "adelieGuideRect", "i", "Lcom/tencent/qqnt/kernel/nativeinterface/RobotGuideInfo;", "adelieGuideInfo", "Ly14/c;", "Ly14/c;", "guideDialog", "Ljava/lang/Runnable;", BdhLogUtil.LogTag.Tag_Conn, "Ljava/lang/Runnable;", "adelieGuideExpandThenAioRunnable", "Landroid/animation/ValueAnimator;", "D", "Landroid/animation/ValueAnimator;", "adelieGuideAnimator", "", "E", "Z", "cancelAnimation", "<init>", "(Landroid/content/Context;Landroid/widget/RelativeLayout;)V", UserInfo.SEX_FEMALE, "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class AdelieGuideAutoControllerImpl extends a implements SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private Runnable adelieGuideExpandThenAioRunnable;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private ValueAnimator adelieGuideAnimator;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean cancelAnimation;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final RelativeLayout rootView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private AdelieGuideAnimationContainer animatorContainer;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Rect adelieGuideRect;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RobotGuideInfo adelieGuideInfo;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private y14.c guideDialog;

    public AdelieGuideAutoControllerImpl(@NotNull Context context, @Nullable RelativeLayout relativeLayout) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.rootView = relativeLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m() {
        AdelieGuideAnimationContainer adelieGuideAnimationContainer;
        AdelieGuideAnimationContainer adelieGuideAnimationContainer2 = this.animatorContainer;
        if (adelieGuideAnimationContainer2 != null) {
            adelieGuideAnimationContainer2.l();
        }
        RelativeLayout relativeLayout = this.rootView;
        if (relativeLayout != null) {
            relativeLayout.addView(this.animatorContainer, relativeLayout.getWidth(), this.rootView.getHeight());
        }
        ValueAnimator valueAnimator = this.adelieGuideAnimator;
        if (valueAnimator != null && (adelieGuideAnimationContainer = this.animatorContainer) != null) {
            adelieGuideAnimationContainer.j(valueAnimator, new Function0<Unit>() { // from class: com.tencent.robot.adelie.homepage.guide.AdelieGuideAutoControllerImpl$adelieGuideAnimate$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
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
                    boolean z16;
                    z16 = AdelieGuideAutoControllerImpl.this.cancelAnimation;
                    if (z16) {
                        return;
                    }
                    AdelieGuideAutoControllerImpl.this.n();
                    i.f366662a.d();
                    AdelieGuideAutoControllerImpl.this.t();
                    AdelieGuideAutoControllerImpl.this.r();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n() {
        SimpleEventBus.getInstance().dispatchEvent(new AdelieRobotGuideAnimationEvent(), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(AdelieGuideAutoControllerImpl this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ValueAnimator valueAnimator = this$0.adelieGuideAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        RelativeLayout relativeLayout = this$0.rootView;
        if (relativeLayout != null) {
            relativeLayout.removeView(this$0.animatorContainer);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p(Function0<Unit> onComplete) {
        Runnable runnable = new Runnable() { // from class: com.tencent.robot.adelie.homepage.guide.AdelieGuideAutoControllerImpl$initAnimationRunnable$$inlined$Runnable$1
            @Override // java.lang.Runnable
            public final void run() {
                boolean z16;
                z16 = AdelieGuideAutoControllerImpl.this.cancelAnimation;
                if (!z16) {
                    AdelieGuideAutoControllerImpl.this.m();
                }
            }
        };
        this.adelieGuideExpandThenAioRunnable = runnable;
        ThreadManagerV2.getUIHandlerV2().postDelayed(runnable, 1000L);
        onComplete.invoke();
    }

    private final void q(RobotGuideInfo robotGuideInfo, Rect rect, Function0<Unit> onComplete) {
        this.adelieGuideInfo = robotGuideInfo;
        this.adelieGuideRect = rect;
        AdelieGuideAnimationContainer adelieGuideAnimationContainer = new AdelieGuideAnimationContainer(this.context, rect, robotGuideInfo, null, 0, 24, null);
        this.animatorContainer = adelieGuideAnimationContainer;
        adelieGuideAnimationContainer.k();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.setDuration(600L);
        ofFloat.setInterpolator(new AccelerateInterpolator());
        this.adelieGuideAnimator = ofFloat;
        onComplete.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r() {
        RobotCoreInfo robotCoreInfo;
        String str;
        String str2;
        RobotGuideInfo robotGuideInfo = this.adelieGuideInfo;
        if (robotGuideInfo != null) {
            robotCoreInfo = robotGuideInfo.robotInfo;
        } else {
            robotCoreInfo = null;
        }
        if (robotCoreInfo != null) {
            if (QQTheme.isNowThemeIsNight()) {
                str = robotCoreInfo.bgNight;
                str2 = "data.bgNight";
            } else {
                str = robotCoreInfo.bgDay;
                str2 = "data.bgDay";
            }
            Intrinsics.checkNotNullExpressionValue(str, str2);
            QLog.i("AdelieGuideAutoControllerImpl", 1, "onJumpAio, url:" + str);
            ((IRobotBackgroundApi) QRoute.api(IRobotBackgroundApi.class)).preloadRobotBackgroundUrl(str, true);
            com.tencent.robot.profile.utils.a.v(robotCoreInfo);
            if (this.cancelAnimation) {
                return;
            }
            AIOUtil.f366629a.d(this.context, robotCoreInfo, "32", this.adelieGuideInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s(Function0<Unit> onComplete) {
        RobotGuideInfo robotGuideInfo;
        if (!this.cancelAnimation && (robotGuideInfo = this.adelieGuideInfo) != null) {
            AdelieGuideUtil adelieGuideUtil = AdelieGuideUtil.f366639a;
            String str = robotGuideInfo.fullscreenBg;
            Intrinsics.checkNotNullExpressionValue(str, "it.fullscreenBg");
            String str2 = robotGuideInfo.bannerBg;
            Intrinsics.checkNotNullExpressionValue(str2, "it.bannerBg");
            String str3 = robotGuideInfo.robotUrl;
            Intrinsics.checkNotNullExpressionValue(str3, "it.robotUrl");
            adelieGuideUtil.d(str, str2, str3, new AdelieGuideAutoControllerImpl$preLoadAnimationBackground$1$1(onComplete, this));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t() {
        VideoReport.reportEvent("ev_bas_agent_novice_boot", null, null);
    }

    private final void u() {
        if (this.adelieGuideInfo == null && !i.f366662a.b()) {
            c();
        }
    }

    @Override // com.tencent.robot.adelie.homepage.guide.a
    public void a() {
        Runnable runnable = this.adelieGuideExpandThenAioRunnable;
        if (runnable != null) {
            ThreadManagerV2.getUIHandlerV2().removeCallbacks(runnable);
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.robot.adelie.homepage.guide.c
            @Override // java.lang.Runnable
            public final void run() {
                AdelieGuideAutoControllerImpl.o(AdelieGuideAutoControllerImpl.this);
            }
        });
        this.cancelAnimation = true;
    }

    @Override // com.tencent.robot.adelie.homepage.guide.a
    public void b() {
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.robot.adelie.homepage.guide.a
    public void c() {
        Context context = this.context;
        if (QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").decodeBool("adelie_home_page_guide_switch", false)) {
            if (QLog.isColorLevel()) {
                QLog.d("AdelieHomeMainFragment", 2, "showGuide return has already shown");
            }
        } else {
            QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").encodeBool("adelie_home_page_guide_switch", true);
            y14.c cVar = new y14.c(context);
            this.guideDialog = cVar;
            cVar.show();
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayList = new ArrayList<>();
        arrayList.add(AdelieRobotGuideTabChangeStopAnimationEvent.class);
        arrayList.add(AdelieRobotGuideCompleteEvent.class);
        arrayList.add(AdelieNewOrOldGuideEvent.class);
        return arrayList;
    }

    @Override // com.tencent.robot.adelie.homepage.guide.a
    public void onDestroy() {
        this.cancelAnimation = false;
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        RelativeLayout relativeLayout = this.rootView;
        if (relativeLayout != null) {
            relativeLayout.removeView(this.animatorContainer);
        }
        ValueAnimator valueAnimator = this.adelieGuideAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        this.adelieGuideAnimator = null;
        Runnable runnable = this.adelieGuideExpandThenAioRunnable;
        if (runnable != null) {
            ThreadManagerV2.getUIHandlerV2().removeCallbacks(runnable);
        }
        this.adelieGuideExpandThenAioRunnable = null;
        y14.c cVar = this.guideDialog;
        if (cVar != null) {
            cVar.dismiss();
        }
        this.guideDialog = null;
        i iVar = i.f366662a;
        if (iVar.a() && !iVar.b()) {
            iVar.e();
        }
        iVar.f();
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        RobotGuideInfo robotGuideInfo;
        if (RobotQQMC.INSTANCE.disableHomePageRobotGuideExpandAnimation() || i.f366662a.a()) {
            return;
        }
        if (event instanceof AdelieNewOrOldGuideEvent) {
            f bannerRobotGuideInfo = ((AdelieNewOrOldGuideEvent) event).getBannerRobotGuideInfo();
            if (bannerRobotGuideInfo != null) {
                robotGuideInfo = bannerRobotGuideInfo.getAdelieGuideInfo();
            } else {
                robotGuideInfo = null;
            }
            this.adelieGuideInfo = robotGuideInfo;
            u();
        }
        if (event instanceof AdelieRobotGuideCompleteEvent) {
            v((AdelieRobotGuideCompleteEvent) event);
        }
        if (event instanceof AdelieRobotGuideTabChangeStopAnimationEvent) {
            a();
        }
    }

    public void v(@NotNull AdelieRobotGuideCompleteEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        q(event.getBannerRobotGuideInfo().getAdelieGuideInfo(), event.getRect(), new Function0<Unit>() { // from class: com.tencent.robot.adelie.homepage.guide.AdelieGuideAutoControllerImpl$startAnimation$1
            /* JADX INFO: Access modifiers changed from: package-private */
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
                final AdelieGuideAutoControllerImpl adelieGuideAutoControllerImpl = AdelieGuideAutoControllerImpl.this;
                adelieGuideAutoControllerImpl.s(new Function0<Unit>() { // from class: com.tencent.robot.adelie.homepage.guide.AdelieGuideAutoControllerImpl$startAnimation$1.1
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
                        AdelieGuideAutoControllerImpl.this.p(new Function0<Unit>() { // from class: com.tencent.robot.adelie.homepage.guide.AdelieGuideAutoControllerImpl.startAnimation.1.1.1
                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }
                        });
                    }
                });
            }
        });
    }
}
