package com.tencent.mobileqq.zplan.minixwconnected.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.zplan.minixwconnected.c;
import com.tencent.mobileqq.zplan.minixwconnected.controller.MiniHomeConnectedController;
import com.tencent.mtt.hippy.adapter.monitor.HippyEngineMonitorEvent;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.utils.featureswitch.ZPlanQQMC;
import com.tencent.sqshow.zootopia.utils.CommonExKt;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import ri3.MapModeInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 52\u00020\u0001:\u0001\u0017B\u001f\u0012\u0006\u0010\u001b\u001a\u00020\u0016\u0012\u0006\u0010!\u001a\u00020\u001c\u0012\u0006\u0010'\u001a\u00020\"\u00a2\u0006\u0004\bF\u0010GJ\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0016J\n\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\u000b\u001a\u00020\u0006H\u0016J\u0006\u0010\f\u001a\u00020\u0006J\b\u0010\u000e\u001a\u0004\u0018\u00010\rJ\u000e\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000fJ\u000e\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0012J\u0006\u0010\u0015\u001a\u00020\u0006R\u0017\u0010\u001b\u001a\u00020\u00168\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010!\u001a\u00020\u001c8\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0017\u0010'\u001a\u00020\"8\u0006\u00a2\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u0018\u0010*\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0014\u0010.\u001a\u00020+8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00102\u001a\u00020/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101R\u001b\u00107\u001a\u00020\u00128BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u00106R\u001b\u0010;\u001a\u0002088BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0019\u00104\u001a\u0004\b9\u0010:R\u001b\u0010>\u001a\u00020<8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b%\u00104\u001a\u0004\b3\u0010=R\u001b\u0010?\u001a\u00020<8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000e\u00104\u001a\u0004\b0\u0010=R\u001b\u0010C\u001a\u00020@8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bA\u00104\u001a\u0004\bA\u0010BR\u0018\u0010E\u001a\u0004\u0018\u00010@8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010D\u00a8\u0006H"}, d2 = {"Lcom/tencent/mobileqq/zplan/minixwconnected/view/MiniHomeConnectStrangerComponent;", "Lcom/tencent/mobileqq/zplan/minixwconnected/c;", "", "msg", "", "iconType", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, HippyEngineMonitorEvent.MODULE_LOAD_EVENT_CREATE_VIEW, "Landroid/view/View;", DomainData.DOMAIN_NAME, "destroy", "p", "Lx45/h;", "j", "Lri3/b;", "modeInfo", "r", "", "peerUin", "o", ReportConstant.COSTREPORT_PREFIX, "Landroid/content/Context;", "a", "Landroid/content/Context;", tl.h.F, "()Landroid/content/Context;", "context", "Lkotlinx/coroutines/CoroutineScope;", "b", "Lkotlinx/coroutines/CoroutineScope;", "getScope", "()Lkotlinx/coroutines/CoroutineScope;", "scope", "Lcom/tencent/mobileqq/zplan/minixwconnected/controller/MiniHomeConnectedController;", "c", "Lcom/tencent/mobileqq/zplan/minixwconnected/controller/MiniHomeConnectedController;", "i", "()Lcom/tencent/mobileqq/zplan/minixwconnected/controller/MiniHomeConnectedController;", "controller", "d", "Lx45/h;", "recommendUserInfo", "Ljava/util/concurrent/atomic/AtomicBoolean;", "e", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isVisiting", "Ljava/util/concurrent/atomic/AtomicLong;", "f", "Ljava/util/concurrent/atomic/AtomicLong;", "lastRequestRecommendTime", "g", "Lkotlin/Lazy;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()J", "recommendIntervalThreshold", "Lcom/tencent/mobileqq/zplan/minixwconnected/view/MiniHomeConnectRelationLayout;", "l", "()Lcom/tencent/mobileqq/zplan/minixwconnected/view/MiniHomeConnectRelationLayout;", "profileRelationLayout", "Landroid/widget/TextView;", "()Landroid/widget/TextView;", "changePeerButton", "addPeerButton", "Landroid/widget/RelativeLayout;", "k", "()Landroid/widget/RelativeLayout;", "peerButtonLayout", "Landroid/widget/RelativeLayout;", "strangerFunctionBtnLayout", "<init>", "(Landroid/content/Context;Lkotlinx/coroutines/CoroutineScope;Lcom/tencent/mobileqq/zplan/minixwconnected/controller/MiniHomeConnectedController;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class MiniHomeConnectStrangerComponent implements com.tencent.mobileqq.zplan.minixwconnected.c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Context context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final CoroutineScope scope;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final MiniHomeConnectedController controller;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private x45.h recommendUserInfo;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final AtomicBoolean isVisiting;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private AtomicLong lastRequestRecommendTime;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final Lazy recommendIntervalThreshold;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final Lazy profileRelationLayout;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final Lazy changePeerButton;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private final Lazy addPeerButton;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private final Lazy peerButtonLayout;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private RelativeLayout strangerFunctionBtnLayout;

    public MiniHomeConnectStrangerComponent(Context context, CoroutineScope scope, MiniHomeConnectedController controller) {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        Lazy lazy5;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(controller, "controller");
        this.context = context;
        this.scope = scope;
        this.controller = controller;
        this.isVisiting = new AtomicBoolean(false);
        this.lastRequestRecommendTime = new AtomicLong(0L);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Long>() { // from class: com.tencent.mobileqq.zplan.minixwconnected.view.MiniHomeConnectStrangerComponent$recommendIntervalThreshold$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Long invoke() {
                return Long.valueOf(ZPlanQQMC.INSTANCE.getMiniHomeConnectStrangerVisitRecommendTimeInterval());
            }
        });
        this.recommendIntervalThreshold = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<MiniHomeConnectRelationLayout>() { // from class: com.tencent.mobileqq.zplan.minixwconnected.view.MiniHomeConnectStrangerComponent$profileRelationLayout$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final MiniHomeConnectRelationLayout invoke() {
                MiniHomeConnectRelationLayout miniHomeConnectRelationLayout = new MiniHomeConnectRelationLayout(MiniHomeConnectStrangerComponent.this.getContext(), MiniHomeConnectStrangerComponent.this.getController().Q());
                miniHomeConnectRelationLayout.setTag("profileRelationLayout");
                ViewGroup.LayoutParams layoutParams = miniHomeConnectRelationLayout.getLayoutParams();
                RelativeLayout.LayoutParams layoutParams2 = layoutParams instanceof RelativeLayout.LayoutParams ? (RelativeLayout.LayoutParams) layoutParams : null;
                if (layoutParams2 != null) {
                    layoutParams2.addRule(14);
                    layoutParams2.addRule(12);
                    layoutParams2.bottomMargin = ViewUtils.dpToPx(121.0f);
                }
                return miniHomeConnectRelationLayout;
            }
        });
        this.profileRelationLayout = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<TextView>() { // from class: com.tencent.mobileqq.zplan.minixwconnected.view.MiniHomeConnectStrangerComponent$changePeerButton$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                int g16 = ie0.a.f().g(MiniHomeConnectStrangerComponent.this.getContext(), R.color.qui_common_text_primary, 1001);
                TextView textView = new TextView(MiniHomeConnectStrangerComponent.this.getContext());
                textView.setTag("changePeerButton");
                textView.setBackgroundResource(R.drawable.f159904i42);
                textView.setText("\u6362\u4e00\u6362");
                textView.setTextSize(17.0f);
                textView.setTextColor(g16);
                textView.setGravity(17);
                textView.setIncludeFontPadding(false);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.addRule(9);
                textView.setLayoutParams(layoutParams);
                return textView;
            }
        });
        this.changePeerButton = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<TextView>() { // from class: com.tencent.mobileqq.zplan.minixwconnected.view.MiniHomeConnectStrangerComponent$addPeerButton$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                int g16 = ie0.a.f().g(MiniHomeConnectStrangerComponent.this.getContext(), R.color.qui_common_text_primary, 1001);
                TextView textView = new TextView(MiniHomeConnectStrangerComponent.this.getContext());
                textView.setTag("addPeerButton");
                textView.setBackgroundResource(R.drawable.f159904i42);
                textView.setText("\u52a0\u597d\u53cb");
                textView.setTextSize(17.0f);
                textView.setTextColor(g16);
                textView.setGravity(17);
                textView.setIncludeFontPadding(false);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.addRule(11);
                textView.setLayoutParams(layoutParams);
                return textView;
            }
        });
        this.addPeerButton = lazy4;
        lazy5 = LazyKt__LazyJVMKt.lazy(new Function0<RelativeLayout>() { // from class: com.tencent.mobileqq.zplan.minixwconnected.view.MiniHomeConnectStrangerComponent$peerButtonLayout$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final RelativeLayout invoke() {
                TextView g16;
                TextView f16;
                RelativeLayout relativeLayout = new RelativeLayout(MiniHomeConnectStrangerComponent.this.getContext());
                MiniHomeConnectStrangerComponent miniHomeConnectStrangerComponent = MiniHomeConnectStrangerComponent.this;
                relativeLayout.setTag("peerButtonLayout");
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ViewUtils.dpToPx(241.0f), ViewUtils.dpToPx(45.0f));
                layoutParams.addRule(14);
                layoutParams.addRule(12);
                layoutParams.bottomMargin = ViewUtils.dpToPx(48.0f);
                relativeLayout.setLayoutParams(layoutParams);
                g16 = miniHomeConnectStrangerComponent.g();
                relativeLayout.addView(g16);
                f16 = miniHomeConnectStrangerComponent.f();
                relativeLayout.addView(f16);
                return relativeLayout;
            }
        });
        this.peerButtonLayout = lazy5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TextView f() {
        return (TextView) this.addPeerButton.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TextView g() {
        return (TextView) this.changePeerButton.getValue();
    }

    private final RelativeLayout k() {
        return (RelativeLayout) this.peerButtonLayout.getValue();
    }

    private final MiniHomeConnectRelationLayout l() {
        return (MiniHomeConnectRelationLayout) this.profileRelationLayout.getValue();
    }

    private final long m() {
        return ((Number) this.recommendIntervalThreshold.getValue()).longValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q(final String msg2, final int iconType) {
        CommonExKt.j(new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.minixwconnected.view.MiniHomeConnectStrangerComponent$showToast$1
            /* JADX INFO: Access modifiers changed from: package-private */
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
                QQToast.makeText(BaseApplication.getContext(), iconType, msg2, 0).show();
            }
        });
    }

    @Override // com.tencent.mobileqq.zplan.minixwconnected.c
    public void create(Object obj) {
        c.a.a(this, obj);
    }

    @Override // com.tencent.mobileqq.zplan.minixwconnected.c
    public void createView() {
        QLog.i("MiniHomeConnectStrangerComponent", 1, HippyEngineMonitorEvent.MODULE_LOAD_EVENT_CREATE_VIEW);
        if (this.strangerFunctionBtnLayout != null) {
            QLog.i("MiniHomeConnectStrangerComponent", 1, "createView, editHomeLayout exists.");
            return;
        }
        RelativeLayout relativeLayout = new RelativeLayout(this.context);
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        relativeLayout.addView(l());
        relativeLayout.addView(k());
        this.strangerFunctionBtnLayout = relativeLayout;
    }

    @Override // com.tencent.mobileqq.zplan.minixwconnected.c
    public void destroy() {
        c.a.c(this);
        l().h();
    }

    /* renamed from: h, reason: from getter */
    public final Context getContext() {
        return this.context;
    }

    /* renamed from: i, reason: from getter */
    public final MiniHomeConnectedController getController() {
        return this.controller;
    }

    /* renamed from: j, reason: from getter */
    public final x45.h getRecommendUserInfo() {
        return this.recommendUserInfo;
    }

    public View n() {
        QLog.i("MiniHomeConnectStrangerComponent", 1, "getView, editMiniHomeLayout: " + this.strangerFunctionBtnLayout);
        return this.strangerFunctionBtnLayout;
    }

    public final void o(long peerUin) {
        l().f(peerUin);
    }

    public final void p() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.lastRequestRecommendTime.get() < m()) {
            q("\u5148\u6b47\u4f1a\u513f\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5", 0);
        } else {
            this.lastRequestRecommendTime.getAndSet(currentTimeMillis);
            CorountineFunKt.e(this.scope, "zplan_requestGetRecommendUsers_\u62c9\u53d6\u964c\u751f\u4eba\u63a8\u8350\u5217\u8868", Boolean.FALSE, null, null, new MiniHomeConnectStrangerComponent$requestRecommendUserInfo$1(this, null), 12, null);
        }
    }

    @Override // com.tencent.mobileqq.zplan.minixwconnected.c
    public void pause() {
        c.a.d(this);
    }

    public final void r(MapModeInfo modeInfo) {
        Intrinsics.checkNotNullParameter(modeInfo, "modeInfo");
        Long hostUin = modeInfo.getHostUin();
        if (hostUin != null) {
            l().i(hostUin.longValue());
        }
    }

    @Override // com.tencent.mobileqq.zplan.minixwconnected.c
    public void resume() {
        c.a.e(this);
    }

    public final void s() {
        l().k();
    }
}
