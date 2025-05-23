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
import com.tencent.filament.zplanservice.pbjava.huateng.HuatengSvr$OpPlant;
import com.tencent.filament.zplanservice.pbjava.huateng.HuatengSvr$OpReplace;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.AppConstants;
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
import com.tencent.mobileqq.zplan.minixwconnected.view.MiniHomeConnectSelfFocusComponent;
import com.tencent.mobileqq.zplan.minixwconnected.view.flowerpanel.controlpanel.MiniHomeFlowerControlPanel;
import com.tencent.mobileqq.zplan.minixwconnected.view.flowerpanel.plantingpanel.MiniHomeFlowerPlantingPanel;
import com.tencent.mobileqq.zplan.minixwconnected.view.flowerpanel.plantingpanel.MiniHomeFlowerPlantingPanelViewModel;
import com.tencent.mtt.hippy.adapter.monitor.HippyEngineMonitorEvent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.utils.featureswitch.ZPlanQQMC;
import com.tencent.sqshow.zootopia.utils.CommonExKt;
import com.tencent.util.QQToastUtil;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import mqq.util.WeakReference;
import ri3.FlowerOpRsp;
import ri3.MapModeInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00c7\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0006*\u0001v\u0018\u0000 !2\u00020\u0001:\u0002#)B%\u0012\u0006\u0010'\u001a\u00020\"\u0012\u0006\u0010-\u001a\u00020(\u0012\f\u00104\u001a\b\u0012\u0004\u0012\u00020/0.\u00a2\u0006\u0004\by\u0010zJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0006H\u0002J\b\u0010\n\u001a\u00020\u0006H\u0002J\b\u0010\u000b\u001a\u00020\u0006H\u0002J\b\u0010\f\u001a\u00020\u0006H\u0002J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0012\u0010\u0011\u001a\u00020\u00062\b\b\u0002\u0010\u0010\u001a\u00020\u0004H\u0002J\b\u0010\u0012\u001a\u00020\u0006H\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\b\u0010\u0015\u001a\u00020\u0006H\u0016J\u000e\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0016J\u000e\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u0019J\u000e\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u001cJ\u000e\u0010 \u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u001fJ\u0006\u0010!\u001a\u00020\u0006R\u0017\u0010'\u001a\u00020\"8\u0006\u00a2\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u0017\u0010-\u001a\u00020(8\u0006\u00a2\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R\u001d\u00104\u001a\b\u0012\u0004\u0012\u00020/0.8\u0006\u00a2\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u00103R\u0016\u0010\u001a\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u0010\bR\u0016\u00109\u001a\u0002068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0018\u0010=\u001a\u0004\u0018\u00010:8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0018\u0010A\u001a\u0004\u0018\u00010>8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010D\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010CR\u0018\u0010H\u001a\u0004\u0018\u00010E8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010GR\u0018\u0010K\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bI\u0010JR\u0018\u0010M\u001a\u0004\u0018\u00010>8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bL\u0010@R\u0018\u0010O\u001a\u0004\u0018\u00010:8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bN\u0010<R\u0018\u0010Q\u001a\u0004\u0018\u00010:8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bP\u0010<R\u001b\u0010W\u001a\u00020R8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bS\u0010T\u001a\u0004\bU\u0010VR\u001b\u0010\\\u001a\u00020X8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bY\u0010T\u001a\u0004\bZ\u0010[R\u0014\u0010`\u001a\u00020]8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b^\u0010_R\u0014\u0010d\u001a\u00020a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bb\u0010cR\u0018\u0010g\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\be\u0010fR\u001b\u0010l\u001a\u00020h8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bi\u0010T\u001a\u0004\bj\u0010kR\u001b\u0010q\u001a\u00020m8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bn\u0010T\u001a\u0004\bo\u0010pR\u001b\u0010u\u001a\u00020r8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010T\u001a\u0004\bs\u0010tR\u0014\u0010x\u001a\u00020v8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010w\u00a8\u0006{"}, d2 = {"Lcom/tencent/mobileqq/zplan/minixwconnected/view/MiniHomeConnectSelfFocusComponent;", "Lcom/tencent/mobileqq/zplan/minixwconnected/c;", "Lcom/tencent/mobileqq/zplan/minixwconnected/view/flowerpanel/plantingpanel/MiniHomeFlowerPlantingPanel;", "v", "", "hostHaveFlower", "", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "I", "u", "J", "K", "H", "Lcom/tencent/mobileqq/zplan/minixwconnected/view/flowerpanel/plantingpanel/MiniHomeFlowerPlantingPanelViewModel$b;", "data", "L", "refreshSelect", "M", HippyEngineMonitorEvent.MODULE_LOAD_EVENT_CREATE_VIEW, "Landroid/view/View;", "E", "destroy", "Lri3/b;", "mapModeInfo", "O", "", "plantingSource", "P", "Lcom/tencent/filament/zplan/scene/xwconnect/data/e;", "flowerUiData", UserInfo.SEX_FEMALE, "Lri3/a;", "G", "w", "Landroid/content/Context;", "a", "Landroid/content/Context;", HippyTKDListViewAdapter.X, "()Landroid/content/Context;", "context", "Lkotlinx/coroutines/CoroutineScope;", "b", "Lkotlinx/coroutines/CoroutineScope;", "getScope", "()Lkotlinx/coroutines/CoroutineScope;", "scope", "Lmqq/util/WeakReference;", "Lcom/tencent/mobileqq/zplan/minixwconnected/controller/MiniHomeConnectedController;", "c", "Lmqq/util/WeakReference;", "y", "()Lmqq/util/WeakReference;", "controllerRef", "d", "Ljava/util/concurrent/atomic/AtomicLong;", "e", "Ljava/util/concurrent/atomic/AtomicLong;", CommonUsedSystemEmojiManagerConstants.LAST_REQUEST_TIME, "Landroid/animation/ObjectAnimator;", "f", "Landroid/animation/ObjectAnimator;", "plantingBubbleAnimation", "Landroid/animation/AnimatorSet;", "g", "Landroid/animation/AnimatorSet;", "hideBubbleAnimatorSet", tl.h.F, "Z", "curHaveFlower", "Lcom/tencent/filament/zplan/scene/xwconnect/data/i;", "i", "Lcom/tencent/filament/zplan/scene/xwconnect/data/i;", "curScreenCoord", "j", "Lri3/b;", "curMapModeInfo", "k", "showFlowerPanelAnimatorSet", "l", "editHomeLayoutAnimation", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "flowerControlPanelAnimation", "", DomainData.DOMAIN_NAME, "Lkotlin/Lazy;", BdhLogUtil.LogTag.Tag_Conn, "()J", "requestIntervalThreshold", "Lcom/tencent/mobileqq/zplan/minixwconnected/view/MiniHomeConnectSelfFocusComponent$b;", "o", "D", "()Lcom/tencent/mobileqq/zplan/minixwconnected/view/MiniHomeConnectSelfFocusComponent$b;", "uiContainer", "Lcom/tencent/mobileqq/zplan/minixwconnected/view/flowerpanel/plantingpanel/a;", "p", "Lcom/tencent/mobileqq/zplan/minixwconnected/view/flowerpanel/plantingpanel/a;", "flowerPanelCallback", "Lcom/tencent/mobileqq/zplan/minixwconnected/view/flowerpanel/controlpanel/a;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/mobileqq/zplan/minixwconnected/view/flowerpanel/controlpanel/a;", "plantPanelCallback", "r", "Lcom/tencent/mobileqq/zplan/minixwconnected/view/flowerpanel/plantingpanel/MiniHomeFlowerPlantingPanel;", "flowerPlantingPanel", "Lcom/tencent/mobileqq/zplan/minixwconnected/view/flowerpanel/controlpanel/MiniHomeFlowerControlPanel;", ReportConstant.COSTREPORT_PREFIX, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "()Lcom/tencent/mobileqq/zplan/minixwconnected/view/flowerpanel/controlpanel/MiniHomeFlowerControlPanel;", "flowerControlPanel", "Lcom/tencent/image/URLImageView;", "t", "B", "()Lcom/tencent/image/URLImageView;", "plantingBubble", "Lcom/tencent/mobileqq/zplan/minixwconnected/view/MiniHomeConnectIconLayout;", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "()Lcom/tencent/mobileqq/zplan/minixwconnected/view/MiniHomeConnectIconLayout;", "editHomeLayout", "com/tencent/mobileqq/zplan/minixwconnected/view/MiniHomeConnectSelfFocusComponent$d", "Lcom/tencent/mobileqq/zplan/minixwconnected/view/MiniHomeConnectSelfFocusComponent$d;", "flowerControlPanelListener", "<init>", "(Landroid/content/Context;Lkotlinx/coroutines/CoroutineScope;Lmqq/util/WeakReference;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class MiniHomeConnectSelfFocusComponent implements com.tencent.mobileqq.zplan.minixwconnected.c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Context context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final CoroutineScope scope;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final WeakReference<MiniHomeConnectedController> controllerRef;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int plantingSource;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private AtomicLong lastRequestTime;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private ObjectAnimator plantingBubbleAnimation;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private AnimatorSet hideBubbleAnimatorSet;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean curHaveFlower;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private ScreenCoord curScreenCoord;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private MapModeInfo curMapModeInfo;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private AnimatorSet showFlowerPanelAnimatorSet;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private ObjectAnimator editHomeLayoutAnimation;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private ObjectAnimator flowerControlPanelAnimation;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private final Lazy requestIntervalThreshold;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private final Lazy uiContainer;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    private final com.tencent.mobileqq.zplan.minixwconnected.view.flowerpanel.plantingpanel.a flowerPanelCallback;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    private final com.tencent.mobileqq.zplan.minixwconnected.view.flowerpanel.controlpanel.a plantPanelCallback;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    private MiniHomeFlowerPlantingPanel flowerPlantingPanel;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    private final Lazy flowerControlPanel;

    /* renamed from: t, reason: collision with root package name and from kotlin metadata */
    private final Lazy plantingBubble;

    /* renamed from: u, reason: collision with root package name and from kotlin metadata */
    private final Lazy editHomeLayout;

    /* renamed from: v, reason: collision with root package name and from kotlin metadata */
    private final d flowerControlPanelListener;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/zplan/minixwconnected/view/MiniHomeConnectSelfFocusComponent$b;", "Landroid/widget/RelativeLayout;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
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
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/zplan/minixwconnected/view/MiniHomeConnectSelfFocusComponent$c", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "", "onGlobalLayout", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class c implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ MiniHomeFlowerPlantingPanel f334621e;

        c(MiniHomeFlowerPlantingPanel miniHomeFlowerPlantingPanel) {
            this.f334621e = miniHomeFlowerPlantingPanel;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            ViewTreeObserver viewTreeObserver;
            ScreenCoord screenCoord = MiniHomeConnectSelfFocusComponent.this.curScreenCoord;
            if (screenCoord != null) {
                MiniHomeConnectSelfFocusComponent miniHomeConnectSelfFocusComponent = MiniHomeConnectSelfFocusComponent.this;
                MiniHomeFlowerPlantingPanel miniHomeFlowerPlantingPanel = this.f334621e;
                MiniHomeFlowerPlantingPanel miniHomeFlowerPlantingPanel2 = miniHomeConnectSelfFocusComponent.flowerPlantingPanel;
                ViewGroup.LayoutParams layoutParams = miniHomeFlowerPlantingPanel2 != null ? miniHomeFlowerPlantingPanel2.getLayoutParams() : null;
                RelativeLayout.LayoutParams layoutParams2 = layoutParams instanceof RelativeLayout.LayoutParams ? (RelativeLayout.LayoutParams) layoutParams : null;
                if (layoutParams2 != null) {
                    layoutParams2.topMargin = (miniHomeConnectSelfFocusComponent.D().getHeight() - screenCoord.getY()) + DisplayUtil.dip2px(miniHomeFlowerPlantingPanel.getContext(), 35.0f);
                    QLog.e("MiniHomeConnectSelfFocusComponent", 1, "flowerPlantingPanel onGlobalLayout " + miniHomeConnectSelfFocusComponent.D().getHeight() + ", topMargin: " + layoutParams2 + ".topMargin");
                }
            }
            MiniHomeFlowerPlantingPanel miniHomeFlowerPlantingPanel3 = MiniHomeConnectSelfFocusComponent.this.flowerPlantingPanel;
            if (miniHomeFlowerPlantingPanel3 == null || (viewTreeObserver = miniHomeFlowerPlantingPanel3.getViewTreeObserver()) == null) {
                return;
            }
            viewTreeObserver.removeOnGlobalLayoutListener(this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/zplan/minixwconnected/view/MiniHomeConnectSelfFocusComponent$e", "Lcom/tencent/mobileqq/zplan/minixwconnected/view/flowerpanel/plantingpanel/a;", "", "a", "Lcom/tencent/mobileqq/zplan/minixwconnected/view/flowerpanel/plantingpanel/MiniHomeFlowerPlantingPanelViewModel$b;", "data", "c", "b", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class e implements com.tencent.mobileqq.zplan.minixwconnected.view.flowerpanel.plantingpanel.a {
        e() {
        }

        @Override // com.tencent.mobileqq.zplan.minixwconnected.view.flowerpanel.plantingpanel.a
        public void a() {
            MiniHomeConnectSelfFocusComponent.N(MiniHomeConnectSelfFocusComponent.this, false, 1, null);
            MiniHomeConnectSelfFocusComponent.this.I();
        }

        @Override // com.tencent.mobileqq.zplan.minixwconnected.view.flowerpanel.plantingpanel.a
        public void b(MiniHomeFlowerPlantingPanelViewModel.FlowerData data) {
            Intrinsics.checkNotNullParameter(data, "data");
            if (!NetworkUtil.isNetworkAvailable()) {
                QQToastUtil.showQQToastInUiThread(1, ZPlanQQMC.INSTANCE.getXWConnectFlowerConfig().getNetworkExceptionPromptText());
                return;
            }
            MiniHomeConnectSelfFocusComponent.N(MiniHomeConnectSelfFocusComponent.this, false, 1, null);
            MiniHomeConnectedController miniHomeConnectedController = MiniHomeConnectSelfFocusComponent.this.y().get();
            if (miniHomeConnectedController != null) {
                FlowerOpType flowerOpType = FlowerOpType.PLANT;
                HuatengSvr$OpPlant huatengSvr$OpPlant = new HuatengSvr$OpPlant();
                huatengSvr$OpPlant.f106424id.set(data.getId());
                Unit unit = Unit.INSTANCE;
                miniHomeConnectedController.v(flowerOpType, huatengSvr$OpPlant.toByteArray());
            }
        }

        @Override // com.tencent.mobileqq.zplan.minixwconnected.view.flowerpanel.plantingpanel.a
        public void c(MiniHomeFlowerPlantingPanelViewModel.FlowerData data) {
            Intrinsics.checkNotNullParameter(data, "data");
            MiniHomeConnectSelfFocusComponent.N(MiniHomeConnectSelfFocusComponent.this, false, 1, null);
            MiniHomeConnectSelfFocusComponent.this.L(data);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/zplan/minixwconnected/view/MiniHomeConnectSelfFocusComponent$f", "Lcom/tencent/mobileqq/zplan/minixwconnected/view/flowerpanel/controlpanel/a;", "Lcom/tencent/filament/zplan/scene/xwconnect/data/d;", "prop", "", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class f implements com.tencent.mobileqq.zplan.minixwconnected.view.flowerpanel.controlpanel.a {

        /* compiled from: P */
        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes34.dex */
        public /* synthetic */ class a {

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f334625a;

            static {
                int[] iArr = new int[FlowerOpType.values().length];
                try {
                    iArr[FlowerOpType.PLANT.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[FlowerOpType.REPLACE.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                f334625a = iArr;
            }
        }

        f() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.mobileqq.zplan.minixwconnected.view.flowerpanel.controlpanel.a
        public void a(FlowerProp prop) {
            HuatengSvr$OpPlant huatengSvr$OpPlant;
            Intrinsics.checkNotNullParameter(prop, "prop");
            QLog.i("MiniHomeConnectSelfFocusComponent", 1, "do action " + prop.getOp().name() + " , " + prop.getId());
            if (!NetworkUtil.isNetworkAvailable()) {
                QQToastUtil.showQQToastInUiThread(1, ZPlanQQMC.INSTANCE.getXWConnectFlowerConfig().getNetworkExceptionPromptText());
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - MiniHomeConnectSelfFocusComponent.this.lastRequestTime.get() < MiniHomeConnectSelfFocusComponent.this.C()) {
                QQToastUtil.showQQToastInUiThread(0, "\u5148\u6b47\u4f1a\u513f\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5");
                return;
            }
            MiniHomeConnectSelfFocusComponent.this.lastRequestTime.getAndSet(currentTimeMillis);
            if (prop.getOp() == FlowerOpType.SUPPORT) {
                MiniHomeConnectSelfFocusComponent.this.H();
            }
            MiniHomeConnectedController miniHomeConnectedController = MiniHomeConnectSelfFocusComponent.this.y().get();
            if (miniHomeConnectedController != null) {
                FlowerOpType op5 = prop.getOp();
                int i3 = a.f334625a[prop.getOp().ordinal()];
                if (i3 == 1) {
                    HuatengSvr$OpPlant huatengSvr$OpPlant2 = new HuatengSvr$OpPlant();
                    huatengSvr$OpPlant2.f106424id.set(prop.getId());
                    Unit unit = Unit.INSTANCE;
                    huatengSvr$OpPlant = huatengSvr$OpPlant2;
                } else if (i3 != 2) {
                    huatengSvr$OpPlant = null;
                } else {
                    HuatengSvr$OpReplace huatengSvr$OpReplace = new HuatengSvr$OpReplace();
                    huatengSvr$OpReplace.f106425id.set(prop.getId());
                    Unit unit2 = Unit.INSTANCE;
                    huatengSvr$OpPlant = huatengSvr$OpReplace;
                }
                miniHomeConnectedController.v(op5, huatengSvr$OpPlant != null ? huatengSvr$OpPlant.toByteArray() : null);
            }
        }
    }

    public MiniHomeConnectSelfFocusComponent(Context context, CoroutineScope scope, WeakReference<MiniHomeConnectedController> controllerRef) {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        Lazy lazy5;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(controllerRef, "controllerRef");
        this.context = context;
        this.scope = scope;
        this.controllerRef = controllerRef;
        this.plantingSource = 1;
        this.lastRequestTime = new AtomicLong(0L);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Long>() { // from class: com.tencent.mobileqq.zplan.minixwconnected.view.MiniHomeConnectSelfFocusComponent$requestIntervalThreshold$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Long invoke() {
                return Long.valueOf(ZPlanQQMC.INSTANCE.getXwConnectOpRequestTimeInterval());
            }
        });
        this.requestIntervalThreshold = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<b>() { // from class: com.tencent.mobileqq.zplan.minixwconnected.view.MiniHomeConnectSelfFocusComponent$uiContainer$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final MiniHomeConnectSelfFocusComponent.b invoke() {
                return new MiniHomeConnectSelfFocusComponent.b(MiniHomeConnectSelfFocusComponent.this.getContext());
            }
        });
        this.uiContainer = lazy2;
        this.flowerPanelCallback = new e();
        this.plantPanelCallback = new f();
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<MiniHomeFlowerControlPanel>() { // from class: com.tencent.mobileqq.zplan.minixwconnected.view.MiniHomeConnectSelfFocusComponent$flowerControlPanel$2

            @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/zplan/minixwconnected/view/MiniHomeConnectSelfFocusComponent$flowerControlPanel$2$a", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "", "onGlobalLayout", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes34.dex */
            public static final class a implements ViewTreeObserver.OnGlobalLayoutListener {

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ MiniHomeConnectSelfFocusComponent f334626d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ MiniHomeFlowerControlPanel f334627e;

                a(MiniHomeConnectSelfFocusComponent miniHomeConnectSelfFocusComponent, MiniHomeFlowerControlPanel miniHomeFlowerControlPanel) {
                    this.f334626d = miniHomeConnectSelfFocusComponent;
                    this.f334627e = miniHomeFlowerControlPanel;
                }

                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    ScreenCoord screenCoord = this.f334626d.curScreenCoord;
                    if (screenCoord != null) {
                        MiniHomeConnectSelfFocusComponent miniHomeConnectSelfFocusComponent = this.f334626d;
                        MiniHomeFlowerControlPanel miniHomeFlowerControlPanel = this.f334627e;
                        ViewGroup.LayoutParams layoutParams = miniHomeConnectSelfFocusComponent.A().getLayoutParams();
                        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
                        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                        layoutParams2.topMargin = (miniHomeConnectSelfFocusComponent.D().getHeight() - screenCoord.getY()) + DisplayUtil.dip2px(miniHomeFlowerControlPanel.getContext(), 70.0f);
                        QLog.e("MiniHomeConnectSelfFocusComponent", 1, "flowerControlPanel onGlobalLayout " + miniHomeConnectSelfFocusComponent.D().getHeight() + ", topMargin: " + layoutParams2.topMargin);
                    }
                    this.f334626d.A().getViewTreeObserver().removeOnGlobalLayoutListener(this);
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final MiniHomeFlowerControlPanel invoke() {
                com.tencent.mobileqq.zplan.minixwconnected.view.flowerpanel.controlpanel.a aVar;
                MiniHomeFlowerControlPanel miniHomeFlowerControlPanel = new MiniHomeFlowerControlPanel(MiniHomeConnectSelfFocusComponent.this.getContext(), MiniHomeConnectSelfFocusComponent.this.y(), false);
                MiniHomeConnectSelfFocusComponent miniHomeConnectSelfFocusComponent = MiniHomeConnectSelfFocusComponent.this;
                miniHomeFlowerControlPanel.g();
                aVar = miniHomeConnectSelfFocusComponent.plantPanelCallback;
                miniHomeFlowerControlPanel.setCallback(aVar);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                layoutParams.addRule(14, -1);
                layoutParams.addRule(10, -1);
                layoutParams.rightMargin = ViewUtils.dpToPx(28.0f);
                layoutParams.leftMargin = ViewUtils.dpToPx(28.0f);
                layoutParams.topMargin = ViewUtils.dpToPx(70.0f);
                miniHomeFlowerControlPanel.setLayoutParams(layoutParams);
                miniHomeFlowerControlPanel.getViewTreeObserver().addOnGlobalLayoutListener(new a(miniHomeConnectSelfFocusComponent, miniHomeFlowerControlPanel));
                return miniHomeFlowerControlPanel;
            }
        });
        this.flowerControlPanel = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new MiniHomeConnectSelfFocusComponent$plantingBubble$2(this));
        this.plantingBubble = lazy4;
        lazy5 = LazyKt__LazyJVMKt.lazy(new MiniHomeConnectSelfFocusComponent$editHomeLayout$2(this));
        this.editHomeLayout = lazy5;
        this.flowerControlPanelListener = new d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MiniHomeFlowerControlPanel A() {
        return (MiniHomeFlowerControlPanel) this.flowerControlPanel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final URLImageView B() {
        return (URLImageView) this.plantingBubble.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long C() {
        return ((Number) this.requestIntervalThreshold.getValue()).longValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final b D() {
        return (b) this.uiContainer.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void H() {
        Long hostUin;
        MapModeInfo mapModeInfo = this.curMapModeInfo;
        if (mapModeInfo == null || (hostUin = mapModeInfo.getHostUin()) == null) {
            return;
        }
        CorountineFunKt.e(this.scope, "zplan_MiniHomeConnectSelfFocusComponent_\u53d1\u9001\u52a9\u529bark", null, null, null, new MiniHomeConnectSelfFocusComponent$sendSupportArk$1$1(hostUin.longValue(), this, null), 14, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void I() {
        ZPlanMiniHomeConnectReporter U;
        QLog.i("MiniHomeConnectSelfFocusComponent", 1, "showBubble");
        D().removeAllViews();
        u();
        MiniHomeConnectedController miniHomeConnectedController = this.controllerRef.get();
        if (miniHomeConnectedController != null && miniHomeConnectedController.L()) {
            D().addView(B());
            ObjectAnimator h16 = qi3.b.f428962a.h(B());
            h16.start();
            this.plantingBubbleAnimation = h16;
            MiniHomeConnectedController miniHomeConnectedController2 = this.controllerRef.get();
            if (miniHomeConnectedController2 != null && (U = miniHomeConnectedController2.U()) != null) {
                ZPlanMiniHomeConnectReporter.f(U, B(), "em_zplan_plant", "dt_imp", null, false, false, 40, null);
            }
        }
        D().addView(z());
        this.editHomeLayoutAnimation = qi3.b.c(qi3.b.f428962a, z(), 0L, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void J() {
        QLog.i("MiniHomeConnectSelfFocusComponent", 1, "showFlowerPanel");
        MiniHomeConnectedController miniHomeConnectedController = this.controllerRef.get();
        if (miniHomeConnectedController != null && miniHomeConnectedController.L()) {
            D().removeAllViews();
            u();
            if (this.flowerPlantingPanel == null) {
                this.flowerPlantingPanel = v();
            }
            MiniHomeFlowerPlantingPanel miniHomeFlowerPlantingPanel = this.flowerPlantingPanel;
            if (miniHomeFlowerPlantingPanel != null) {
                D().addView(miniHomeFlowerPlantingPanel);
                this.showFlowerPanelAnimatorSet = qi3.b.f428962a.i(miniHomeFlowerPlantingPanel, 200L);
            }
        }
    }

    private final void K() {
        QLog.i("MiniHomeConnectSelfFocusComponent", 1, "showPlantPanel");
        D().removeAllViews();
        u();
        MiniHomeConnectedController miniHomeConnectedController = this.controllerRef.get();
        if (miniHomeConnectedController != null && miniHomeConnectedController.L()) {
            D().addView(A());
            this.flowerControlPanelAnimation = qi3.b.c(qi3.b.f428962a, A(), 0L, 2, null);
            A().addOnAttachStateChangeListener(this.flowerControlPanelListener);
        }
        D().addView(z());
        this.editHomeLayoutAnimation = qi3.b.c(qi3.b.f428962a, z(), 0L, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void L(final MiniHomeFlowerPlantingPanelViewModel.FlowerData data) {
        CommonExKt.j(new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.minixwconnected.view.MiniHomeConnectSelfFocusComponent$startFlowerPreview$1
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
                MapModeInfo mapModeInfo;
                Long hostUin;
                mapModeInfo = MiniHomeConnectSelfFocusComponent.this.curMapModeInfo;
                if (mapModeInfo == null || (hostUin = mapModeInfo.getHostUin()) == null) {
                    return;
                }
                MiniHomeConnectSelfFocusComponent miniHomeConnectSelfFocusComponent = MiniHomeConnectSelfFocusComponent.this;
                MiniHomeFlowerPlantingPanelViewModel.FlowerData flowerData = data;
                long longValue = hostUin.longValue();
                MiniHomeConnectedController miniHomeConnectedController = miniHomeConnectSelfFocusComponent.y().get();
                if (miniHomeConnectedController != null) {
                    miniHomeConnectedController.C(longValue, flowerData.getFlowerViewDataList());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void M(final boolean refreshSelect) {
        CommonExKt.j(new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.minixwconnected.view.MiniHomeConnectSelfFocusComponent$stopFlowerPreview$1
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
                MapModeInfo mapModeInfo;
                Long hostUin;
                MiniHomeFlowerPlantingPanel miniHomeFlowerPlantingPanel;
                mapModeInfo = MiniHomeConnectSelfFocusComponent.this.curMapModeInfo;
                if (mapModeInfo == null || (hostUin = mapModeInfo.getHostUin()) == null) {
                    return;
                }
                MiniHomeConnectSelfFocusComponent miniHomeConnectSelfFocusComponent = MiniHomeConnectSelfFocusComponent.this;
                boolean z16 = refreshSelect;
                long longValue = hostUin.longValue();
                MiniHomeConnectedController miniHomeConnectedController = miniHomeConnectSelfFocusComponent.y().get();
                if (miniHomeConnectedController != null) {
                    miniHomeConnectedController.D(longValue);
                }
                if (!z16 || (miniHomeFlowerPlantingPanel = miniHomeConnectSelfFocusComponent.flowerPlantingPanel) == null) {
                    return;
                }
                miniHomeFlowerPlantingPanel.v();
            }
        });
    }

    private final void Q(boolean hostHaveFlower) {
        QLog.i("MiniHomeConnectSelfFocusComponent", 1, "updateUI hostHaveFlower: " + hostHaveFlower + ", plantingSource: " + this.plantingSource);
        int i3 = this.plantingSource;
        if (i3 != 0) {
            if (i3 == 1) {
                if (hostHaveFlower) {
                    K();
                } else {
                    I();
                }
            }
        } else if (hostHaveFlower) {
            K();
        } else {
            J();
        }
        this.plantingSource = 1;
    }

    private final MiniHomeFlowerPlantingPanel v() {
        MiniHomeFlowerPlantingPanel miniHomeFlowerPlantingPanel = new MiniHomeFlowerPlantingPanel(this.context, this.controllerRef);
        miniHomeFlowerPlantingPanel.j();
        miniHomeFlowerPlantingPanel.setCallback(this.flowerPanelCallback);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, (int) (DisplayUtil.getScreenHeight() * 0.4f));
        layoutParams.addRule(14, -1);
        layoutParams.addRule(12, -1);
        layoutParams.bottomMargin = ViewUtils.dpToPx(40.0f);
        layoutParams.rightMargin = ViewUtils.dpToPx(14.0f);
        layoutParams.leftMargin = ViewUtils.dpToPx(14.0f);
        miniHomeFlowerPlantingPanel.setLayoutParams(layoutParams);
        miniHomeFlowerPlantingPanel.getViewTreeObserver().addOnGlobalLayoutListener(new c(miniHomeFlowerPlantingPanel));
        return miniHomeFlowerPlantingPanel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MiniHomeConnectIconLayout z() {
        return (MiniHomeConnectIconLayout) this.editHomeLayout.getValue();
    }

    public View E() {
        return D();
    }

    public final void F(FlowerUiData flowerUiData) {
        boolean z16;
        FlowerData flowerData;
        FlowerBasicInfo basicInfo;
        Intrinsics.checkNotNullParameter(flowerUiData, "flowerUiData");
        if (Intrinsics.areEqual(flowerUiData.getHostHaveFlower(), Boolean.TRUE)) {
            FlowerData flowerData2 = flowerUiData.getFlowerData();
            if (!((flowerData2 == null || (basicInfo = flowerData2.getBasicInfo()) == null || basicInfo.getFlowerId() != 0) ? false : true)) {
                z16 = true;
                this.curHaveFlower = z16;
                ScreenCoord screenCoord = flowerUiData.getScreenCoord();
                this.curScreenCoord = screenCoord;
                QLog.i("MiniHomeConnectSelfFocusComponent", 1, "initProgressPanel hostHaveFlower: " + z16 + ", " + screenCoord);
                Q(z16);
                if (z16 || (flowerData = flowerUiData.getFlowerData()) == null) {
                }
                MiniHomeFlowerControlPanel.k(A(), flowerData, false, 2, null);
                return;
            }
        }
        z16 = false;
        this.curHaveFlower = z16;
        ScreenCoord screenCoord2 = flowerUiData.getScreenCoord();
        this.curScreenCoord = screenCoord2;
        QLog.i("MiniHomeConnectSelfFocusComponent", 1, "initProgressPanel hostHaveFlower: " + z16 + ", " + screenCoord2);
        Q(z16);
        if (z16) {
        }
    }

    public final void G(FlowerOpRsp data) {
        FlowerData flowerData;
        FlowerBasicInfo basicInfo;
        Intrinsics.checkNotNullParameter(data, "data");
        QLog.i("MiniHomeConnectSelfFocusComponent", 1, "onOpResult " + data);
        FlowerOpRspData data2 = data.getData();
        if (data2 == null) {
            return;
        }
        FlowerData flowerData2 = data2.getFlowerData();
        boolean z16 = !((flowerData2 == null || (basicInfo = flowerData2.getBasicInfo()) == null || basicInfo.getFlowerId() != 0) ? false : true);
        if (this.curHaveFlower != z16) {
            Q(z16);
            if (z16 && (flowerData = data2.getFlowerData()) != null) {
                MiniHomeFlowerControlPanel.k(A(), flowerData, false, 2, null);
            }
            this.curHaveFlower = z16;
        }
        A().q(data2, data.getReqOp() != FlowerOpType.PLANT);
    }

    public final void O(MapModeInfo mapModeInfo) {
        Intrinsics.checkNotNullParameter(mapModeInfo, "mapModeInfo");
        this.curMapModeInfo = mapModeInfo;
        MiniHomeConnectedController miniHomeConnectedController = this.controllerRef.get();
        boolean z16 = false;
        if (miniHomeConnectedController != null && miniHomeConnectedController.L()) {
            z16 = true;
        }
        if (z16) {
            return;
        }
        CommonExKt.j(new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.minixwconnected.view.MiniHomeConnectSelfFocusComponent$updateSefFocusMapModeInfo$1
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
                MiniHomeConnectIconLayout z17;
                MiniHomeConnectIconLayout z18;
                MiniHomeConnectSelfFocusComponent.this.D().removeAllViews();
                MiniHomeConnectSelfFocusComponent.b D = MiniHomeConnectSelfFocusComponent.this.D();
                z17 = MiniHomeConnectSelfFocusComponent.this.z();
                D.addView(z17);
                MiniHomeConnectSelfFocusComponent miniHomeConnectSelfFocusComponent = MiniHomeConnectSelfFocusComponent.this;
                qi3.b bVar = qi3.b.f428962a;
                z18 = miniHomeConnectSelfFocusComponent.z();
                miniHomeConnectSelfFocusComponent.editHomeLayoutAnimation = qi3.b.c(bVar, z18, 0L, 2, null);
            }
        });
    }

    public final void P(int plantingSource) {
        this.plantingSource = plantingSource;
    }

    @Override // com.tencent.mobileqq.zplan.minixwconnected.c
    public void create(Object obj) {
        c.a.a(this, obj);
    }

    @Override // com.tencent.mobileqq.zplan.minixwconnected.c
    public void destroy() {
        ObjectAnimator objectAnimator = this.editHomeLayoutAnimation;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
        this.editHomeLayoutAnimation = null;
        ObjectAnimator objectAnimator2 = this.flowerControlPanelAnimation;
        if (objectAnimator2 != null) {
            objectAnimator2.cancel();
        }
        this.flowerControlPanelAnimation = null;
        AnimatorSet animatorSet = this.showFlowerPanelAnimatorSet;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        this.showFlowerPanelAnimatorSet = null;
        ObjectAnimator objectAnimator3 = this.plantingBubbleAnimation;
        if (objectAnimator3 != null) {
            objectAnimator3.cancel();
        }
        this.plantingBubbleAnimation = null;
        AnimatorSet animatorSet2 = this.hideBubbleAnimatorSet;
        if (animatorSet2 != null) {
            animatorSet2.removeAllListeners();
        }
        AnimatorSet animatorSet3 = this.hideBubbleAnimatorSet;
        if (animatorSet3 != null) {
            animatorSet3.cancel();
        }
        this.hideBubbleAnimatorSet = null;
        u();
        A().setCallback(null);
        A().h();
        D().removeAllViews();
    }

    @Override // com.tencent.mobileqq.zplan.minixwconnected.c
    public void pause() {
        c.a.d(this);
    }

    @Override // com.tencent.mobileqq.zplan.minixwconnected.c
    public void resume() {
        c.a.e(this);
    }

    public final void w() {
        CommonExKt.j(new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.minixwconnected.view.MiniHomeConnectSelfFocusComponent$enterGlobalMode$1
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
                MiniHomeConnectSelfFocusComponent.this.M(true);
                MiniHomeConnectSelfFocusComponent.this.D().removeAllViews();
                MiniHomeConnectSelfFocusComponent.this.u();
            }
        });
    }

    /* renamed from: x, reason: from getter */
    public final Context getContext() {
        return this.context;
    }

    public final WeakReference<MiniHomeConnectedController> y() {
        return this.controllerRef;
    }

    @Override // com.tencent.mobileqq.zplan.minixwconnected.c
    public void createView() {
        QLog.i("MiniHomeConnectSelfFocusComponent", 1, HippyEngineMonitorEvent.MODULE_LOAD_EVENT_CREATE_VIEW);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u() {
        N(this, false, 1, null);
        MiniHomeFlowerPlantingPanel miniHomeFlowerPlantingPanel = this.flowerPlantingPanel;
        if (miniHomeFlowerPlantingPanel != null) {
            miniHomeFlowerPlantingPanel.setCallback(null);
        }
        MiniHomeFlowerPlantingPanel miniHomeFlowerPlantingPanel2 = this.flowerPlantingPanel;
        if (miniHomeFlowerPlantingPanel2 != null) {
            miniHomeFlowerPlantingPanel2.k();
        }
        this.flowerPlantingPanel = null;
    }

    static /* synthetic */ void N(MiniHomeConnectSelfFocusComponent miniHomeConnectSelfFocusComponent, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = false;
        }
        miniHomeConnectSelfFocusComponent.M(z16);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/zplan/minixwconnected/view/MiniHomeConnectSelfFocusComponent$d", "Landroid/view/View$OnAttachStateChangeListener;", "Landroid/view/View;", "v", "", "onViewAttachedToWindow", "onViewDetachedFromWindow", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class d implements View.OnAttachStateChangeListener {
        d() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View v3) {
            ZPlanMiniHomeConnectReporter U;
            MiniHomeFlowerControlPanel A = MiniHomeConnectSelfFocusComponent.this.A();
            if (A == null) {
                return;
            }
            MiniHomeConnectedController miniHomeConnectedController = MiniHomeConnectSelfFocusComponent.this.y().get();
            if (miniHomeConnectedController != null && (U = miniHomeConnectedController.U()) != null) {
                ZPlanMiniHomeConnectReporter.f(U, A, "em_zplan_plant_panel", "dt_imp", null, false, false, 40, null);
            }
            A.o();
            A.removeOnAttachStateChangeListener(this);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View v3) {
        }
    }
}
