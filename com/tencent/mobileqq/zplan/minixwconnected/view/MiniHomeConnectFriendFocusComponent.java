package com.tencent.mobileqq.zplan.minixwconnected.view;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.RelativeLayout;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.filament.zplan.scene.xwconnect.data.FlowerBasicInfo;
import com.tencent.filament.zplan.scene.xwconnect.data.FlowerData;
import com.tencent.filament.zplan.scene.xwconnect.data.FlowerOpRspData;
import com.tencent.filament.zplan.scene.xwconnect.data.FlowerOpType;
import com.tencent.filament.zplan.scene.xwconnect.data.FlowerProp;
import com.tencent.filament.zplan.scene.xwconnect.data.FlowerUiData;
import com.tencent.filament.zplan.scene.xwconnect.data.ScreenCoord;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.emoticon.CommonUsedSystemEmojiManagerConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.zplan.minixwconnected.c;
import com.tencent.mobileqq.zplan.minixwconnected.controller.MiniHomeConnectedController;
import com.tencent.mobileqq.zplan.minixwconnected.report.ZPlanMiniHomeConnectReporter;
import com.tencent.mobileqq.zplan.minixwconnected.view.MiniHomeConnectFriendFocusComponent;
import com.tencent.mobileqq.zplan.minixwconnected.view.flowerpanel.controlpanel.MiniHomeFlowerControlPanel;
import com.tencent.mtt.hippy.adapter.monitor.HippyEngineMonitorEvent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.utils.featureswitch.ZPlanQQMC;
import com.tencent.util.QQToastUtil;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import mqq.util.WeakReference;
import ri3.FlowerOpRsp;
import ri3.MapModeInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00b9\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0006*\u0001f\u0018\u0000 ?2\u00020\u0001:\u0002\u001e$B%\u0012\u0006\u0010\"\u001a\u00020\u001d\u0012\u0006\u0010(\u001a\u00020#\u0012\f\u0010/\u001a\b\u0012\u0004\u0012\u00020*0)\u00a2\u0006\u0004\bi\u0010jJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\n\u001a\u00020\u0005H\u0002J\b\u0010\u000b\u001a\u00020\u0005H\u0002J\u000e\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\fJ\u000e\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000fJ\b\u0010\u0012\u001a\u00020\u0005H\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\b\u0010\u0015\u001a\u00020\u0005H\u0016J\u000e\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0016J\u000e\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0019J\u0006\u0010\u001c\u001a\u00020\u0005R\u0017\u0010\"\u001a\u00020\u001d8\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u0017\u0010(\u001a\u00020#8\u0006\u00a2\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u001d\u0010/\u001a\b\u0012\u0004\u0012\u00020*0)8\u0006\u00a2\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.R\u0018\u00103\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0018\u00106\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105R\u001b\u0010<\u001a\u0002078BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b8\u00109\u001a\u0004\b:\u0010;R\u001b\u0010A\u001a\u00020=8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b>\u00109\u001a\u0004\b?\u0010@R\u001b\u0010F\u001a\u00020B8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bC\u00109\u001a\u0004\bD\u0010ER\u001b\u0010K\u001a\u00020G8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bH\u00109\u001a\u0004\bI\u0010JR\u0018\u0010O\u001a\u0004\u0018\u00010L8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bM\u0010NR\u0018\u0010Q\u001a\u0004\u0018\u00010L8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bP\u0010NR\u0018\u0010S\u001a\u0004\u0018\u00010L8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bR\u0010NR\u0018\u0010V\u001a\u0004\u0018\u00010T8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010UR\u0016\u0010Y\u001a\u00020W8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u0010XR\u001b\u0010\\\u001a\u00020\u00198BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b \u00109\u001a\u0004\bZ\u0010[R\u0014\u0010_\u001a\u00020]8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010^R\u0018\u0010a\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010`R\u001b\u0010e\u001a\u00020b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bI\u00109\u001a\u0004\bc\u0010dR\u0014\u0010h\u001a\u00020f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bc\u0010g\u00a8\u0006k"}, d2 = {"Lcom/tencent/mobileqq/zplan/minixwconnected/view/MiniHomeConnectFriendFocusComponent;", "Lcom/tencent/mobileqq/zplan/minixwconnected/c;", "Lcom/tencent/mobileqq/zplan/minixwconnected/view/flowerpanel/controlpanel/MiniHomeFlowerControlPanel;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "", "hostHaveFlower", "E", BdhLogUtil.LogTag.Tag_Conn, "B", "Lcom/tencent/filament/zplan/scene/xwconnect/data/e;", "flowerUiData", "y", "Lri3/a;", "data", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, HippyEngineMonitorEvent.MODULE_LOAD_EVENT_CREATE_VIEW, "Landroid/view/View;", "w", "destroy", "Lri3/b;", "mapModeInfo", "D", "", "friendUin", HippyTKDListViewAdapter.X, UserInfo.SEX_FEMALE, "Landroid/content/Context;", "a", "Landroid/content/Context;", "o", "()Landroid/content/Context;", "context", "Lkotlinx/coroutines/CoroutineScope;", "b", "Lkotlinx/coroutines/CoroutineScope;", "getScope", "()Lkotlinx/coroutines/CoroutineScope;", "scope", "Lmqq/util/WeakReference;", "Lcom/tencent/mobileqq/zplan/minixwconnected/controller/MiniHomeConnectedController;", "c", "Lmqq/util/WeakReference;", "p", "()Lmqq/util/WeakReference;", "controllerRef", "Lcom/tencent/filament/zplan/scene/xwconnect/data/i;", "d", "Lcom/tencent/filament/zplan/scene/xwconnect/data/i;", "curScreenCoord", "e", "Lri3/b;", "curMapModeInfo", "Lcom/tencent/mobileqq/zplan/minixwconnected/view/MiniHomeConnectFriendFocusComponent$b;", "f", "Lkotlin/Lazy;", "v", "()Lcom/tencent/mobileqq/zplan/minixwconnected/view/MiniHomeConnectFriendFocusComponent$b;", "uiContainer", "Lcom/tencent/mobileqq/zplan/minixwconnected/view/MiniHomeConnectRelationLayout;", "g", "t", "()Lcom/tencent/mobileqq/zplan/minixwconnected/view/MiniHomeConnectRelationLayout;", "profileRelationLayout", "Lcom/tencent/mobileqq/zplan/minixwconnected/view/MiniHomeConnectIconLayout;", tl.h.F, DomainData.DOMAIN_NAME, "()Lcom/tencent/mobileqq/zplan/minixwconnected/view/MiniHomeConnectIconLayout;", "actionButtonIconLayout", "Landroid/widget/RelativeLayout;", "i", "r", "()Landroid/widget/RelativeLayout;", "friendFocusBtnLayout", "Landroid/animation/ObjectAnimator;", "j", "Landroid/animation/ObjectAnimator;", "friendFocusBtnLayoutAnimator", "k", "flowerControlPanelAnimator", "l", "plantingBubbleAnimation", "Landroid/animation/AnimatorSet;", "Landroid/animation/AnimatorSet;", "hideBubbleAnimatorSet", "Ljava/util/concurrent/atomic/AtomicLong;", "Ljava/util/concurrent/atomic/AtomicLong;", CommonUsedSystemEmojiManagerConstants.LAST_REQUEST_TIME, "u", "()J", "requestIntervalThreshold", "Lcom/tencent/mobileqq/zplan/minixwconnected/view/flowerpanel/controlpanel/a;", "Lcom/tencent/mobileqq/zplan/minixwconnected/view/flowerpanel/controlpanel/a;", "plantPanelCallback", "Lcom/tencent/mobileqq/zplan/minixwconnected/view/flowerpanel/controlpanel/MiniHomeFlowerControlPanel;", "flowerControlPanel", "Lcom/tencent/image/URLImageView;", ReportConstant.COSTREPORT_PREFIX, "()Lcom/tencent/image/URLImageView;", "plantingBubble", "com/tencent/mobileqq/zplan/minixwconnected/view/MiniHomeConnectFriendFocusComponent$d", "Lcom/tencent/mobileqq/zplan/minixwconnected/view/MiniHomeConnectFriendFocusComponent$d;", "flowerControlPanelListener", "<init>", "(Landroid/content/Context;Lkotlinx/coroutines/CoroutineScope;Lmqq/util/WeakReference;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class MiniHomeConnectFriendFocusComponent implements com.tencent.mobileqq.zplan.minixwconnected.c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Context context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final CoroutineScope scope;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final WeakReference<MiniHomeConnectedController> controllerRef;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private ScreenCoord curScreenCoord;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private MapModeInfo curMapModeInfo;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final Lazy uiContainer;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final Lazy profileRelationLayout;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final Lazy actionButtonIconLayout;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final Lazy friendFocusBtnLayout;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private ObjectAnimator friendFocusBtnLayoutAnimator;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private ObjectAnimator flowerControlPanelAnimator;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private ObjectAnimator plantingBubbleAnimation;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private AnimatorSet hideBubbleAnimatorSet;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private AtomicLong lastRequestTime;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private final Lazy requestIntervalThreshold;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    private final com.tencent.mobileqq.zplan.minixwconnected.view.flowerpanel.controlpanel.a plantPanelCallback;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    private MiniHomeFlowerControlPanel flowerControlPanel;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    private final Lazy plantingBubble;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    private final d flowerControlPanelListener;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/zplan/minixwconnected/view/MiniHomeConnectFriendFocusComponent$b;", "Landroid/widget/RelativeLayout;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b extends RelativeLayout {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Context context) {
            super(context);
            Intrinsics.checkNotNullParameter(context, "context");
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(12);
            setLayoutParams(layoutParams);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/zplan/minixwconnected/view/MiniHomeConnectFriendFocusComponent$c", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "", "onGlobalLayout", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class c implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ MiniHomeFlowerControlPanel f334563e;

        c(MiniHomeFlowerControlPanel miniHomeFlowerControlPanel) {
            this.f334563e = miniHomeFlowerControlPanel;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            ViewTreeObserver viewTreeObserver;
            ScreenCoord screenCoord = MiniHomeConnectFriendFocusComponent.this.curScreenCoord;
            if (screenCoord != null) {
                MiniHomeConnectFriendFocusComponent miniHomeConnectFriendFocusComponent = MiniHomeConnectFriendFocusComponent.this;
                MiniHomeFlowerControlPanel miniHomeFlowerControlPanel = this.f334563e;
                MiniHomeFlowerControlPanel miniHomeFlowerControlPanel2 = miniHomeConnectFriendFocusComponent.flowerControlPanel;
                ViewGroup.LayoutParams layoutParams = miniHomeFlowerControlPanel2 != null ? miniHomeFlowerControlPanel2.getLayoutParams() : null;
                RelativeLayout.LayoutParams layoutParams2 = layoutParams instanceof RelativeLayout.LayoutParams ? (RelativeLayout.LayoutParams) layoutParams : null;
                if (layoutParams2 != null) {
                    layoutParams2.topMargin = (miniHomeConnectFriendFocusComponent.v().getHeight() - screenCoord.getY()) + DisplayUtil.dip2px(miniHomeFlowerControlPanel.getContext(), 70.0f);
                    QLog.e("MiniHomeConnectFriendFocusComponent", 1, "flowerControlPanel onGlobalLayout " + miniHomeConnectFriendFocusComponent.v().getHeight() + ", topMargin: " + layoutParams2 + ".topMargin");
                }
            }
            MiniHomeFlowerControlPanel miniHomeFlowerControlPanel3 = MiniHomeConnectFriendFocusComponent.this.flowerControlPanel;
            if (miniHomeFlowerControlPanel3 == null || (viewTreeObserver = miniHomeFlowerControlPanel3.getViewTreeObserver()) == null) {
                return;
            }
            viewTreeObserver.removeOnGlobalLayoutListener(this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/zplan/minixwconnected/view/MiniHomeConnectFriendFocusComponent$e", "Lcom/tencent/mobileqq/zplan/minixwconnected/view/flowerpanel/controlpanel/a;", "Lcom/tencent/filament/zplan/scene/xwconnect/data/d;", "prop", "", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class e implements com.tencent.mobileqq.zplan.minixwconnected.view.flowerpanel.controlpanel.a {
        e() {
        }

        @Override // com.tencent.mobileqq.zplan.minixwconnected.view.flowerpanel.controlpanel.a
        public void a(FlowerProp prop) {
            Intrinsics.checkNotNullParameter(prop, "prop");
            QLog.i("MiniHomeConnectFriendFocusComponent", 1, "do action " + prop.getOp().name() + " , " + prop.getId());
            if (!NetworkUtil.isNetworkAvailable()) {
                QQToastUtil.showQQToastInUiThread(1, ZPlanQQMC.INSTANCE.getXWConnectFlowerConfig().getNetworkExceptionPromptText());
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - MiniHomeConnectFriendFocusComponent.this.lastRequestTime.get() < MiniHomeConnectFriendFocusComponent.this.u()) {
                QQToastUtil.showQQToastInUiThread(0, "\u5148\u6b47\u4f1a\u513f\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5");
                return;
            }
            MiniHomeConnectFriendFocusComponent.this.lastRequestTime.getAndSet(currentTimeMillis);
            MiniHomeConnectedController miniHomeConnectedController = MiniHomeConnectFriendFocusComponent.this.p().get();
            if (miniHomeConnectedController != null) {
                MiniHomeConnectedController.w(miniHomeConnectedController, prop.getOp(), null, 2, null);
            }
        }
    }

    public MiniHomeConnectFriendFocusComponent(Context context, CoroutineScope scope, WeakReference<MiniHomeConnectedController> controllerRef) {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        Lazy lazy5;
        Lazy lazy6;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(controllerRef, "controllerRef");
        this.context = context;
        this.scope = scope;
        this.controllerRef = controllerRef;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<b>() { // from class: com.tencent.mobileqq.zplan.minixwconnected.view.MiniHomeConnectFriendFocusComponent$uiContainer$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final MiniHomeConnectFriendFocusComponent.b invoke() {
                return new MiniHomeConnectFriendFocusComponent.b(MiniHomeConnectFriendFocusComponent.this.getContext());
            }
        });
        this.uiContainer = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<MiniHomeConnectRelationLayout>() { // from class: com.tencent.mobileqq.zplan.minixwconnected.view.MiniHomeConnectFriendFocusComponent$profileRelationLayout$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final MiniHomeConnectRelationLayout invoke() {
                Context context2 = MiniHomeConnectFriendFocusComponent.this.getContext();
                MiniHomeConnectedController miniHomeConnectedController = MiniHomeConnectFriendFocusComponent.this.p().get();
                MiniHomeConnectRelationLayout miniHomeConnectRelationLayout = new MiniHomeConnectRelationLayout(context2, miniHomeConnectedController != null ? miniHomeConnectedController.Q() : null);
                miniHomeConnectRelationLayout.setTag("profileRelationLayout");
                ViewGroup.LayoutParams layoutParams = miniHomeConnectRelationLayout.getLayoutParams();
                RelativeLayout.LayoutParams layoutParams2 = layoutParams instanceof RelativeLayout.LayoutParams ? (RelativeLayout.LayoutParams) layoutParams : null;
                if (layoutParams2 != null) {
                    layoutParams2.addRule(11);
                    layoutParams2.addRule(12);
                }
                return miniHomeConnectRelationLayout;
            }
        });
        this.profileRelationLayout = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<MiniHomeConnectIconLayout>() { // from class: com.tencent.mobileqq.zplan.minixwconnected.view.MiniHomeConnectFriendFocusComponent$actionButtonIconLayout$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final MiniHomeConnectIconLayout invoke() {
                MiniHomeConnectIconLayout miniHomeConnectIconLayout = new MiniHomeConnectIconLayout(MiniHomeConnectFriendFocusComponent.this.getContext(), c.b(MiniHomeConnectFriendFocusComponent.this.getContext(), R.drawable.qui_interaction, 0, 4, null), "\u4e92\u52a8");
                miniHomeConnectIconLayout.setTag("actionButtonIconLayout");
                ViewGroup.LayoutParams layoutParams = miniHomeConnectIconLayout.getLayoutParams();
                RelativeLayout.LayoutParams layoutParams2 = layoutParams instanceof RelativeLayout.LayoutParams ? (RelativeLayout.LayoutParams) layoutParams : null;
                if (layoutParams2 != null) {
                    layoutParams2.addRule(9);
                }
                return miniHomeConnectIconLayout;
            }
        });
        this.actionButtonIconLayout = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<RelativeLayout>() { // from class: com.tencent.mobileqq.zplan.minixwconnected.view.MiniHomeConnectFriendFocusComponent$friendFocusBtnLayout$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final RelativeLayout invoke() {
                MiniHomeConnectIconLayout n3;
                MiniHomeConnectRelationLayout t16;
                RelativeLayout relativeLayout = new RelativeLayout(MiniHomeConnectFriendFocusComponent.this.getContext());
                MiniHomeConnectFriendFocusComponent miniHomeConnectFriendFocusComponent = MiniHomeConnectFriendFocusComponent.this;
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ViewUtils.dpToPx(267.0f), ViewUtils.dpToPx(76.0f));
                layoutParams.addRule(14);
                layoutParams.addRule(12);
                layoutParams.bottomMargin = ViewUtils.dpToPx(48.0f);
                n3 = miniHomeConnectFriendFocusComponent.n();
                relativeLayout.addView(n3);
                t16 = miniHomeConnectFriendFocusComponent.t();
                relativeLayout.addView(t16);
                relativeLayout.setLayoutParams(layoutParams);
                return relativeLayout;
            }
        });
        this.friendFocusBtnLayout = lazy4;
        this.lastRequestTime = new AtomicLong(0L);
        lazy5 = LazyKt__LazyJVMKt.lazy(new Function0<Long>() { // from class: com.tencent.mobileqq.zplan.minixwconnected.view.MiniHomeConnectFriendFocusComponent$requestIntervalThreshold$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Long invoke() {
                return Long.valueOf(ZPlanQQMC.INSTANCE.getXwConnectOpRequestTimeInterval());
            }
        });
        this.requestIntervalThreshold = lazy5;
        this.plantPanelCallback = new e();
        lazy6 = LazyKt__LazyJVMKt.lazy(new MiniHomeConnectFriendFocusComponent$plantingBubble$2(this));
        this.plantingBubble = lazy6;
        this.flowerControlPanelListener = new d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void A() {
        MapModeInfo mapModeInfo = this.curMapModeInfo;
        if (mapModeInfo == null || mapModeInfo.getHostUin() == null) {
            return;
        }
        String hostName = mapModeInfo.getHostName();
        if (hostName == null || hostName.length() == 0) {
            return;
        }
        CorountineFunKt.e(this.scope, "zplan_MiniHomeConnectFriendFocusComponent_\u53d1\u9001\u9080\u8bf7\u79cd\u82b1ark", null, null, null, new MiniHomeConnectFriendFocusComponent$sendShareArk$1(mapModeInfo, this, null), 14, null);
    }

    private final void B() {
        ZPlanMiniHomeConnectReporter U;
        v().removeAllViews();
        MiniHomeConnectedController miniHomeConnectedController = this.controllerRef.get();
        boolean z16 = false;
        if (miniHomeConnectedController != null && miniHomeConnectedController.L()) {
            z16 = true;
        }
        if (z16) {
            this.flowerControlPanel = null;
            v().addView(s());
            ObjectAnimator h16 = qi3.b.f428962a.h(s());
            h16.start();
            this.plantingBubbleAnimation = h16;
            MiniHomeConnectedController miniHomeConnectedController2 = this.controllerRef.get();
            if (miniHomeConnectedController2 != null && (U = miniHomeConnectedController2.U()) != null) {
                ZPlanMiniHomeConnectReporter.f(U, s(), "em_zplan_plant", "dt_imp", null, false, false, 40, null);
            }
        }
        v().addView(r());
        this.friendFocusBtnLayoutAnimator = qi3.b.c(qi3.b.f428962a, r(), 0L, 2, null);
    }

    private final void C() {
        v().removeAllViews();
        MiniHomeConnectedController miniHomeConnectedController = this.controllerRef.get();
        boolean z16 = false;
        if (miniHomeConnectedController != null && miniHomeConnectedController.L()) {
            z16 = true;
        }
        if (z16) {
            this.flowerControlPanel = null;
            MiniHomeFlowerControlPanel q16 = q();
            if (q16 != null) {
                v().addView(q16);
                this.flowerControlPanelAnimator = qi3.b.c(qi3.b.f428962a, q16, 0L, 2, null);
                q16.addOnAttachStateChangeListener(this.flowerControlPanelListener);
            }
        }
        v().addView(r());
        this.friendFocusBtnLayoutAnimator = qi3.b.c(qi3.b.f428962a, r(), 0L, 2, null);
    }

    private final MiniHomeFlowerControlPanel m() {
        MiniHomeFlowerControlPanel miniHomeFlowerControlPanel = new MiniHomeFlowerControlPanel(this.context, this.controllerRef, true);
        miniHomeFlowerControlPanel.g();
        miniHomeFlowerControlPanel.setCallback(this.plantPanelCallback);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(14, -1);
        layoutParams.addRule(10, -1);
        layoutParams.rightMargin = ViewUtils.dpToPx(28.0f);
        layoutParams.leftMargin = ViewUtils.dpToPx(28.0f);
        layoutParams.topMargin = ViewUtils.dpToPx(70.0f);
        miniHomeFlowerControlPanel.setLayoutParams(layoutParams);
        miniHomeFlowerControlPanel.getViewTreeObserver().addOnGlobalLayoutListener(new c(miniHomeFlowerControlPanel));
        return miniHomeFlowerControlPanel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MiniHomeConnectIconLayout n() {
        return (MiniHomeConnectIconLayout) this.actionButtonIconLayout.getValue();
    }

    private final MiniHomeFlowerControlPanel q() {
        if (this.flowerControlPanel == null) {
            this.flowerControlPanel = m();
        }
        return this.flowerControlPanel;
    }

    private final RelativeLayout r() {
        return (RelativeLayout) this.friendFocusBtnLayout.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final URLImageView s() {
        return (URLImageView) this.plantingBubble.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MiniHomeConnectRelationLayout t() {
        return (MiniHomeConnectRelationLayout) this.profileRelationLayout.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long u() {
        return ((Number) this.requestIntervalThreshold.getValue()).longValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final b v() {
        return (b) this.uiContainer.getValue();
    }

    public final void D(MapModeInfo mapModeInfo) {
        Intrinsics.checkNotNullParameter(mapModeInfo, "mapModeInfo");
        this.curMapModeInfo = mapModeInfo;
        Long hostUin = mapModeInfo.getHostUin();
        if (hostUin != null) {
            t().i(hostUin.longValue());
        }
    }

    public final void F() {
        t().k();
    }

    @Override // com.tencent.mobileqq.zplan.minixwconnected.c
    public void create(Object obj) {
        c.a.a(this, obj);
    }

    @Override // com.tencent.mobileqq.zplan.minixwconnected.c
    public void destroy() {
        c.a.c(this);
        ObjectAnimator objectAnimator = this.friendFocusBtnLayoutAnimator;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
        this.friendFocusBtnLayoutAnimator = null;
        ObjectAnimator objectAnimator2 = this.flowerControlPanelAnimator;
        if (objectAnimator2 != null) {
            objectAnimator2.cancel();
        }
        this.flowerControlPanelAnimator = null;
        ObjectAnimator objectAnimator3 = this.plantingBubbleAnimation;
        if (objectAnimator3 != null) {
            objectAnimator3.cancel();
        }
        this.plantingBubbleAnimation = null;
        AnimatorSet animatorSet = this.hideBubbleAnimatorSet;
        if (animatorSet != null) {
            animatorSet.removeAllListeners();
        }
        AnimatorSet animatorSet2 = this.hideBubbleAnimatorSet;
        if (animatorSet2 != null) {
            animatorSet2.cancel();
        }
        this.hideBubbleAnimatorSet = null;
        t().h();
        MiniHomeFlowerControlPanel miniHomeFlowerControlPanel = this.flowerControlPanel;
        if (miniHomeFlowerControlPanel != null) {
            miniHomeFlowerControlPanel.setCallback(null);
        }
        MiniHomeFlowerControlPanel miniHomeFlowerControlPanel2 = this.flowerControlPanel;
        if (miniHomeFlowerControlPanel2 != null) {
            miniHomeFlowerControlPanel2.h();
        }
        v().removeAllViews();
        this.flowerControlPanel = null;
    }

    /* renamed from: o, reason: from getter */
    public final Context getContext() {
        return this.context;
    }

    public final WeakReference<MiniHomeConnectedController> p() {
        return this.controllerRef;
    }

    @Override // com.tencent.mobileqq.zplan.minixwconnected.c
    public void pause() {
        c.a.d(this);
    }

    @Override // com.tencent.mobileqq.zplan.minixwconnected.c
    public void resume() {
        c.a.e(this);
    }

    public View w() {
        QLog.i("MiniHomeConnectFriendFocusComponent", 1, "getView, uiContainer: " + v());
        return v();
    }

    public final void x(long friendUin) {
        t().f(friendUin);
    }

    public final void y(FlowerUiData flowerUiData) {
        FlowerData flowerData;
        MiniHomeFlowerControlPanel q16;
        FlowerBasicInfo basicInfo;
        Intrinsics.checkNotNullParameter(flowerUiData, "flowerUiData");
        boolean z16 = false;
        if (Intrinsics.areEqual(flowerUiData.getHostHaveFlower(), Boolean.TRUE)) {
            FlowerData flowerData2 = flowerUiData.getFlowerData();
            if (!((flowerData2 == null || (basicInfo = flowerData2.getBasicInfo()) == null || basicInfo.getFlowerId() != 0) ? false : true)) {
                z16 = true;
            }
        }
        ScreenCoord screenCoord = flowerUiData.getScreenCoord();
        this.curScreenCoord = screenCoord;
        QLog.i("MiniHomeConnectFriendFocusComponent", 1, "initProgressPanel hostHaveFlower: " + z16 + ", " + screenCoord);
        E(z16);
        if (!z16 || (flowerData = flowerUiData.getFlowerData()) == null || (q16 = q()) == null) {
            return;
        }
        q16.j(flowerData, true);
    }

    public final void z(FlowerOpRsp data) {
        MiniHomeFlowerControlPanel miniHomeFlowerControlPanel;
        Intrinsics.checkNotNullParameter(data, "data");
        QLog.i("MiniHomeConnectFriendFocusComponent", 1, "onOpResult " + data);
        FlowerOpRspData data2 = data.getData();
        if (data2 == null || (miniHomeFlowerControlPanel = this.flowerControlPanel) == null) {
            return;
        }
        miniHomeFlowerControlPanel.q(data2, data.getReqOp() != FlowerOpType.PLANT);
    }

    @Override // com.tencent.mobileqq.zplan.minixwconnected.c
    public void createView() {
        QLog.i("MiniHomeConnectFriendFocusComponent", 1, HippyEngineMonitorEvent.MODULE_LOAD_EVENT_CREATE_VIEW);
    }

    private final void E(boolean hostHaveFlower) {
        if (hostHaveFlower) {
            C();
        } else {
            B();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/zplan/minixwconnected/view/MiniHomeConnectFriendFocusComponent$d", "Landroid/view/View$OnAttachStateChangeListener;", "Landroid/view/View;", "v", "", "onViewAttachedToWindow", "onViewDetachedFromWindow", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class d implements View.OnAttachStateChangeListener {
        d() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View v3) {
            ZPlanMiniHomeConnectReporter U;
            MiniHomeFlowerControlPanel miniHomeFlowerControlPanel = MiniHomeConnectFriendFocusComponent.this.flowerControlPanel;
            if (miniHomeFlowerControlPanel == null) {
                return;
            }
            MiniHomeConnectedController miniHomeConnectedController = MiniHomeConnectFriendFocusComponent.this.p().get();
            if (miniHomeConnectedController != null && (U = miniHomeConnectedController.U()) != null) {
                ZPlanMiniHomeConnectReporter.f(U, miniHomeFlowerControlPanel, "em_zplan_plant_panel", "dt_imp", null, false, false, 40, null);
            }
            miniHomeFlowerControlPanel.o();
            miniHomeFlowerControlPanel.removeOnAttachStateChangeListener(this);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View v3) {
        }
    }
}
