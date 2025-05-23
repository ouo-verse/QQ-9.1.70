package com.tencent.mobileqq.zplan.aigc;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheLunarData;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.qui.quipolarlight.QUIPolarLightView;
import com.tencent.biz.qui.quipolarlight.a;
import com.tencent.biz.qui.quipolarlight.render.PolarImageRender;
import com.tencent.biz.richframework.part.ImmersivePartFragment;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qcoroutine.api.i;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.zootopia.portal.aigc.preview.AigcPreviewBusinessScene;
import com.tencent.mobileqq.zplan.aigc.SuitCustomColorFragment;
import com.tencent.mobileqq.zplan.aigc.helper.ZPlanUgcDyingConfirmDialogHelper;
import com.tencent.mobileqq.zplan.aigc.helper.ZPlanUgcDyingSuitListDialogHelper;
import com.tencent.mobileqq.zplan.aigc.helper.ZplanUgcDyeingDialogHelper;
import com.tencent.mobileqq.zplan.aigc.render.ZplanFilamentSuitRender;
import com.tencent.mobileqq.zplan.aigc.vm.SuitCustomColorVewModel;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.sqshow.utils.featureswitch.ZPlanQQMC;
import com.tencent.sqshow.zootopia.aigc.view.SuitPagView;
import com.tencent.sqshow.zootopia.card.view.widget.PortalStoreCurrencyView;
import com.tencent.sqshow.zootopia.nativeui.view.history.PortalStoreHistoryControllerView;
import com.tencent.sqshow.zootopia.nativeui.view.loading.NativePanelLoadingIgv;
import com.tencent.sqshow.zootopia.utils.CommonExKt;
import com.tencent.state.report.SquareReportConst;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;
import wc3.LocalUgcPath;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00ec\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u0097\u00012\u00020\u0001:\u0004\u0098\u0001\u0099\u0001B\t\u00a2\u0006\u0006\b\u0095\u0001\u0010\u0096\u0001J\u0010\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0014J\b\u0010\u0007\u001a\u00020\u0005H\u0014J\b\u0010\t\u001a\u00020\bH\u0014J&\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\u001a\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u0015\u001a\u00020\bH\u0016J\b\u0010\u0016\u001a\u00020\u0013H\u0016J\b\u0010\u0017\u001a\u00020\u0013H\u0016J\b\u0010\u0018\u001a\u00020\u0013H\u0016J\b\u0010\u0019\u001a\u00020\u0013H\u0002J\b\u0010\u001a\u001a\u00020\u0013H\u0002J\b\u0010\u001b\u001a\u00020\u0013H\u0002J\b\u0010\u001c\u001a\u00020\u0013H\u0002J\b\u0010\u001d\u001a\u00020\u0013H\u0002J(\u0010\"\u001a\u00020\u00132\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00130 H\u0002J\b\u0010#\u001a\u00020\u0013H\u0002J\b\u0010$\u001a\u00020\u0013H\u0002J\u0010\u0010'\u001a\u00020\u00132\u0006\u0010&\u001a\u00020%H\u0002J\u0018\u0010*\u001a\u00020\u00132\u0006\u0010(\u001a\u00020\u00052\u0006\u0010)\u001a\u00020\u0005H\u0002J\b\u0010+\u001a\u00020\u0013H\u0002J\b\u0010,\u001a\u00020\u0013H\u0002J\b\u0010-\u001a\u00020\bH\u0002J\u0012\u0010/\u001a\u00020\u00132\b\b\u0002\u0010.\u001a\u00020\bH\u0002J\u0010\u00102\u001a\u00020\u00132\u0006\u00101\u001a\u000200H\u0002J\u0010\u00103\u001a\u00020\u00132\u0006\u00101\u001a\u000200H\u0002R\u001b\u00109\u001a\u0002048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b5\u00106\u001a\u0004\b7\u00108R\u001b\u0010<\u001a\u0002048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b:\u00106\u001a\u0004\b;\u00108R\u001b\u0010?\u001a\u0002048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b=\u00106\u001a\u0004\b>\u00108R\u001b\u0010D\u001a\u00020@8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bA\u00106\u001a\u0004\bB\u0010CR\u001b\u0010I\u001a\u00020E8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bF\u00106\u001a\u0004\bG\u0010HR\u001b\u0010N\u001a\u00020J8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bK\u00106\u001a\u0004\bL\u0010MR\u001b\u0010S\u001a\u00020O8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bP\u00106\u001a\u0004\bQ\u0010RR\u001b\u0010X\u001a\u00020T8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bU\u00106\u001a\u0004\bV\u0010WR\u001b\u0010]\u001a\u00020Y8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bZ\u00106\u001a\u0004\b[\u0010\\R\u001a\u0010b\u001a\b\u0012\u0004\u0012\u00020_0^8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b`\u0010aR\u001b\u0010e\u001a\u00020T8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bc\u00106\u001a\u0004\bd\u0010WR\u001b\u0010j\u001a\u00020f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bg\u00106\u001a\u0004\bh\u0010iR\u0018\u0010m\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bk\u0010lR\u0014\u0010q\u001a\u00020n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bo\u0010pR\u0016\u0010u\u001a\u00020r8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bs\u0010tR\u0016\u0010y\u001a\u00020v8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bw\u0010xR\u0016\u0010}\u001a\u00020z8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b{\u0010|R\u0018\u0010\u0081\u0001\u001a\u00020~8\u0002@\u0002X\u0082.\u00a2\u0006\u0007\n\u0005\b\u007f\u0010\u0080\u0001R\u001a\u0010\u0085\u0001\u001a\u00030\u0082\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u0083\u0001\u0010\u0084\u0001R\u0018\u0010\u0087\u0001\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0086\u0001\u0010PR\u001a\u0010\u008b\u0001\u001a\u00030\u0088\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0089\u0001\u0010\u008a\u0001R#\u0010\u008e\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00130 8\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u008c\u0001\u0010\u008d\u0001R#\u0010\u0090\u0001\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u00130 8\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u008f\u0001\u0010\u008d\u0001R\u001e\u0010\u0094\u0001\u001a\t\u0012\u0004\u0012\u00020\u00130\u0091\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0092\u0001\u0010\u0093\u0001\u00a8\u0006\u009a\u0001"}, d2 = {"Lcom/tencent/mobileqq/zplan/aigc/SuitCustomColorFragment;", "Lcom/tencent/biz/richframework/part/ImmersivePartFragment;", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "", "getContentLayoutId", "getStatusBarColor", "", "enableRootViewSetFitsSystemWindows", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Landroid/view/View;", "onCreateView", "view", "", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "onBackEvent", "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "initView", "gi", "initViewModel", "fi", "ai", "Luv4/az;", "storeItem", "Lkotlin/Function1;", "callback", "li", WidgetCacheLunarData.JI, "ki", "Lzv4/c;", "ugcStoreItem", "Oh", "itemId", "price", "oi", "ei", "ni", "Mh", "needArrow", "Lh", "", "message", "hi", "ii", "Landroid/widget/FrameLayout;", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/Lazy;", "Th", "()Landroid/widget/FrameLayout;", "filamentContainer", "D", "Sh", "dialogViewContainer", "E", "Rh", "confirmDialogViewContainer", "Lcom/tencent/sqshow/zootopia/aigc/view/SuitPagView;", UserInfo.SEX_FEMALE, "Wh", "()Lcom/tencent/sqshow/zootopia/aigc/view/SuitPagView;", "lightEffectPAG", "Landroid/widget/LinearLayout;", "G", "Uh", "()Landroid/widget/LinearLayout;", "historyLayout", "Lcom/tencent/sqshow/zootopia/nativeui/view/history/PortalStoreHistoryControllerView;", "H", "Vh", "()Lcom/tencent/sqshow/zootopia/nativeui/view/history/PortalStoreHistoryControllerView;", "historyOptView", "Lcom/tencent/sqshow/zootopia/card/view/widget/PortalStoreCurrencyView;", "I", "Qh", "()Lcom/tencent/sqshow/zootopia/card/view/widget/PortalStoreCurrencyView;", "coinArea", "Landroid/widget/ImageView;", "J", "Ph", "()Landroid/widget/ImageView;", "backBtn", "Lcom/tencent/sqshow/zootopia/nativeui/view/loading/NativePanelLoadingIgv;", "K", "Xh", "()Lcom/tencent/sqshow/zootopia/nativeui/view/loading/NativePanelLoadingIgv;", "loadingView", "Landroidx/lifecycle/Observer;", "Lcom/tencent/sqshow/zootopia/data/f;", "L", "Landroidx/lifecycle/Observer;", "coinUpdateObserver", "M", "Zh", "screenshotImageView", "Lcom/tencent/biz/qui/quipolarlight/QUIPolarLightView;", "N", "Yh", "()Lcom/tencent/biz/qui/quipolarlight/QUIPolarLightView;", "polarLightView", "P", "Landroid/view/View;", "parentView", "Lcom/tencent/mobileqq/zplan/aigc/render/ZplanFilamentSuitRender;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/tencent/mobileqq/zplan/aigc/render/ZplanFilamentSuitRender;", "filamentRender", "Lcom/tencent/mobileqq/zplan/aigc/vm/SuitCustomColorVewModel;", BdhLogUtil.LogTag.Tag_Req, "Lcom/tencent/mobileqq/zplan/aigc/vm/SuitCustomColorVewModel;", "vm", "Ljava/util/concurrent/atomic/AtomicBoolean;", ExifInterface.LATITUDE_SOUTH, "Ljava/util/concurrent/atomic/AtomicBoolean;", "slotResourceIsReady", "Lcom/tencent/mobileqq/zplan/aigc/helper/ZplanUgcDyeingDialogHelper;", "T", "Lcom/tencent/mobileqq/zplan/aigc/helper/ZplanUgcDyeingDialogHelper;", "colorPanel", "Lcom/tencent/mobileqq/zplan/aigc/helper/ZPlanUgcDyingSuitListDialogHelper;", "U", "Lcom/tencent/mobileqq/zplan/aigc/helper/ZPlanUgcDyingSuitListDialogHelper;", "suitListDialogHelper", "Lcom/tencent/mobileqq/zplan/aigc/helper/ZPlanUgcDyingConfirmDialogHelper;", "V", "Lcom/tencent/mobileqq/zplan/aigc/helper/ZPlanUgcDyingConfirmDialogHelper;", "dyeingConfirmDialogHelper", "W", "from", "Lzd3/a;", "X", "Lzd3/a;", "dtReporter", "Y", "Lkotlin/jvm/functions/Function1;", "onSaveButtonClick", "Z", "onSuitCardClick", "Lkotlin/Function0;", "a0", "Lkotlin/jvm/functions/Function0;", "onHintIconClick", "<init>", "()V", "b0", "a", "SuitUGCCustomColorFromValue", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class SuitCustomColorFragment extends ImmersivePartFragment {

    /* renamed from: C, reason: from kotlin metadata */
    private final Lazy filamentContainer;

    /* renamed from: D, reason: from kotlin metadata */
    private final Lazy dialogViewContainer;

    /* renamed from: E, reason: from kotlin metadata */
    private final Lazy confirmDialogViewContainer;

    /* renamed from: F, reason: from kotlin metadata */
    private final Lazy lightEffectPAG;

    /* renamed from: G, reason: from kotlin metadata */
    private final Lazy historyLayout;

    /* renamed from: H, reason: from kotlin metadata */
    private final Lazy historyOptView;

    /* renamed from: I, reason: from kotlin metadata */
    private final Lazy coinArea;

    /* renamed from: J, reason: from kotlin metadata */
    private final Lazy backBtn;

    /* renamed from: K, reason: from kotlin metadata */
    private final Lazy loadingView;

    /* renamed from: L, reason: from kotlin metadata */
    private final Observer<com.tencent.sqshow.zootopia.data.f> coinUpdateObserver;

    /* renamed from: M, reason: from kotlin metadata */
    private final Lazy screenshotImageView;

    /* renamed from: N, reason: from kotlin metadata */
    private final Lazy polarLightView;

    /* renamed from: P, reason: from kotlin metadata */
    private View parentView;

    /* renamed from: Q, reason: from kotlin metadata */
    private final ZplanFilamentSuitRender filamentRender;

    /* renamed from: R, reason: from kotlin metadata */
    private SuitCustomColorVewModel vm;

    /* renamed from: S, reason: from kotlin metadata */
    private AtomicBoolean slotResourceIsReady;

    /* renamed from: T, reason: from kotlin metadata */
    private ZplanUgcDyeingDialogHelper colorPanel;

    /* renamed from: U, reason: from kotlin metadata */
    private ZPlanUgcDyingSuitListDialogHelper suitListDialogHelper;

    /* renamed from: V, reason: from kotlin metadata */
    private ZPlanUgcDyingConfirmDialogHelper dyeingConfirmDialogHelper;

    /* renamed from: W, reason: from kotlin metadata */
    private int from;

    /* renamed from: X, reason: from kotlin metadata */
    private zd3.a dtReporter;

    /* renamed from: Y, reason: from kotlin metadata */
    private final Function1<Integer, Unit> onSaveButtonClick;

    /* renamed from: Z, reason: from kotlin metadata */
    private final Function1<zv4.c, Unit> onSuitCardClick;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private final Function0<Unit> onHintIconClick;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/zplan/aigc/SuitCustomColorFragment$SuitUGCCustomColorFromValue;", "", "value", "", "(Ljava/lang/String;II)V", HippyTextInputController.COMMAND_getValue, "()I", "DEFAULT", "MALL", "SCHEME", "QZONE", "LITTLE_WORLD", "zplan_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes35.dex */
    public enum SuitUGCCustomColorFromValue {
        DEFAULT(0),
        MALL(1),
        SCHEME(2),
        QZONE(3),
        LITTLE_WORLD(4);

        private final int value;

        SuitUGCCustomColorFromValue(int i3) {
            this.value = i3;
        }

        public final int getValue() {
            return this.value;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/zplan/aigc/SuitCustomColorFragment$b", "Lgl0/b;", "", "isSuccess", "downloadSo", "", "errCode", "", "errMsg", "", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b implements gl0.b {
        b() {
        }

        @Override // gl0.b
        public void a(boolean isSuccess, boolean downloadSo, int errCode, String errMsg) {
            QLog.i("SuitCustomColorFragment", 1, "onComplete after checkSoAndInitLightSdk isSuccess: " + isSuccess);
            if (SuitCustomColorFragment.this.getView() == null) {
                return;
            }
            if (!isSuccess) {
                SuitCustomColorFragment.this.hi("\u7f51\u7edc\u5f02\u5e38\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5");
                SuitCustomColorVewModel suitCustomColorVewModel = SuitCustomColorFragment.this.vm;
                if (suitCustomColorVewModel == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("vm");
                    suitCustomColorVewModel = null;
                }
                suitCustomColorVewModel.a3().postValue(Boolean.FALSE);
                return;
            }
            SuitCustomColorFragment.this.ni();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/zplan/aigc/SuitCustomColorFragment$c", "Luk0/e;", "", "type", "eventData", "", "onEvent", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class c implements uk0.e {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Function1<Boolean, Unit> f329919d;

        /* JADX WARN: Multi-variable type inference failed */
        c(Function1<? super Boolean, Unit> function1) {
            this.f329919d = function1;
        }

        @Override // uk0.e
        public void onEvent(String type, String eventData) {
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(eventData, "eventData");
            this.f329919d.invoke(Boolean.TRUE);
        }
    }

    public SuitCustomColorFragment() {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        Lazy lazy5;
        Lazy lazy6;
        Lazy lazy7;
        Lazy lazy8;
        Lazy lazy9;
        Lazy lazy10;
        Lazy lazy11;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<FrameLayout>() { // from class: com.tencent.mobileqq.zplan.aigc.SuitCustomColorFragment$filamentContainer$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final FrameLayout invoke() {
                return (FrameLayout) SuitCustomColorFragment.this.requireView().findViewById(R.id.pnz);
            }
        });
        this.filamentContainer = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<FrameLayout>() { // from class: com.tencent.mobileqq.zplan.aigc.SuitCustomColorFragment$dialogViewContainer$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final FrameLayout invoke() {
                return (FrameLayout) SuitCustomColorFragment.this.requireView().findViewById(R.id.ppq);
            }
        });
        this.dialogViewContainer = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<FrameLayout>() { // from class: com.tencent.mobileqq.zplan.aigc.SuitCustomColorFragment$confirmDialogViewContainer$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final FrameLayout invoke() {
                return (FrameLayout) SuitCustomColorFragment.this.requireView().findViewById(R.id.plo);
            }
        });
        this.confirmDialogViewContainer = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<SuitPagView>() { // from class: com.tencent.mobileqq.zplan.aigc.SuitCustomColorFragment$lightEffectPAG$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final SuitPagView invoke() {
                return (SuitPagView) SuitCustomColorFragment.this.requireView().findViewById(R.id.f163573qv1);
            }
        });
        this.lightEffectPAG = lazy4;
        lazy5 = LazyKt__LazyJVMKt.lazy(new Function0<LinearLayout>() { // from class: com.tencent.mobileqq.zplan.aigc.SuitCustomColorFragment$historyLayout$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final LinearLayout invoke() {
                return (LinearLayout) SuitCustomColorFragment.this.requireView().findViewById(R.id.pzp);
            }
        });
        this.historyLayout = lazy5;
        lazy6 = LazyKt__LazyJVMKt.lazy(new Function0<PortalStoreHistoryControllerView>() { // from class: com.tencent.mobileqq.zplan.aigc.SuitCustomColorFragment$historyOptView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final PortalStoreHistoryControllerView invoke() {
                return (PortalStoreHistoryControllerView) SuitCustomColorFragment.this.requireView().findViewById(R.id.pzq);
            }
        });
        this.historyOptView = lazy6;
        lazy7 = LazyKt__LazyJVMKt.lazy(new Function0<PortalStoreCurrencyView>() { // from class: com.tencent.mobileqq.zplan.aigc.SuitCustomColorFragment$coinArea$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final PortalStoreCurrencyView invoke() {
                return (PortalStoreCurrencyView) SuitCustomColorFragment.this.requireView().findViewById(R.id.pkn);
            }
        });
        this.coinArea = lazy7;
        lazy8 = LazyKt__LazyJVMKt.lazy(new Function0<ImageView>() { // from class: com.tencent.mobileqq.zplan.aigc.SuitCustomColorFragment$backBtn$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ImageView invoke() {
                return (ImageView) SuitCustomColorFragment.this.requireView().findViewById(R.id.f163299pd3);
            }
        });
        this.backBtn = lazy8;
        lazy9 = LazyKt__LazyJVMKt.lazy(new Function0<NativePanelLoadingIgv>() { // from class: com.tencent.mobileqq.zplan.aigc.SuitCustomColorFragment$loadingView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final NativePanelLoadingIgv invoke() {
                return (NativePanelLoadingIgv) SuitCustomColorFragment.this.requireView().findViewById(R.id.q65);
            }
        });
        this.loadingView = lazy9;
        this.coinUpdateObserver = new Observer() { // from class: com.tencent.mobileqq.zplan.aigc.v
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SuitCustomColorFragment.Nh(SuitCustomColorFragment.this, (com.tencent.sqshow.zootopia.data.f) obj);
            }
        };
        lazy10 = LazyKt__LazyJVMKt.lazy(new Function0<ImageView>() { // from class: com.tencent.mobileqq.zplan.aigc.SuitCustomColorFragment$screenshotImageView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ImageView invoke() {
                return (ImageView) SuitCustomColorFragment.this.requireView().findViewById(R.id.qja);
            }
        });
        this.screenshotImageView = lazy10;
        lazy11 = LazyKt__LazyJVMKt.lazy(new Function0<QUIPolarLightView>() { // from class: com.tencent.mobileqq.zplan.aigc.SuitCustomColorFragment$polarLightView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final QUIPolarLightView invoke() {
                return (QUIPolarLightView) SuitCustomColorFragment.this.requireView().findViewById(R.id.f163576qv4);
            }
        });
        this.polarLightView = lazy11;
        this.filamentRender = new ZplanFilamentSuitRender();
        this.slotResourceIsReady = new AtomicBoolean(false);
        this.from = SuitUGCCustomColorFromValue.DEFAULT.getValue();
        this.dtReporter = new zd3.a();
        this.onSaveButtonClick = new Function1<Integer, Unit>() { // from class: com.tencent.mobileqq.zplan.aigc.SuitCustomColorFragment$onSaveButtonClick$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i3) {
                ImageView Zh;
                ZplanFilamentSuitRender zplanFilamentSuitRender;
                ImageView Zh2;
                FrameLayout Th;
                int i16;
                if (i3 == 0) {
                    QLog.i("SuitCustomColorFragment", 1, " SaveButtonClick down");
                    Zh = SuitCustomColorFragment.this.Zh();
                    zplanFilamentSuitRender = SuitCustomColorFragment.this.filamentRender;
                    View k3 = zplanFilamentSuitRender.k();
                    Intrinsics.checkNotNull(k3, "null cannot be cast to non-null type android.view.TextureView");
                    Zh.setImageBitmap(((TextureView) k3).getBitmap());
                    Zh2 = SuitCustomColorFragment.this.Zh();
                    Zh2.setVisibility(0);
                    Th = SuitCustomColorFragment.this.Th();
                    Th.setVisibility(4);
                    return;
                }
                if (i3 == 1) {
                    QLog.i("SuitCustomColorFragment", 1, " screenshot complete");
                    SuitCustomColorFragment.this.fi();
                    return;
                }
                if (i3 != 2) {
                    return;
                }
                QLog.i("SuitCustomColorFragment", 1, " publish complete");
                if (SuitCustomColorFragment.this.getActivity() != null) {
                    com.tencent.sqshow.zootopia.nativeui.data.c.f370920a.r().e(Boolean.TRUE);
                    i16 = SuitCustomColorFragment.this.from;
                    if (i16 == SuitCustomColorFragment.SuitUGCCustomColorFromValue.MALL.getValue()) {
                        SuitCustomColorFragment.this.requireActivity().finish();
                        return;
                    }
                    String uGCJumpMyBagAllScheme = ZPlanQQMC.INSTANCE.getUGCJumpMyBagAllScheme();
                    if ((uGCJumpMyBagAllScheme.length() > 0) && SuitCustomColorFragment.this.getContext() != null) {
                        IZPlanApi iZPlanApi = (IZPlanApi) QRoute.api(IZPlanApi.class);
                        Context requireContext = SuitCustomColorFragment.this.requireContext();
                        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
                        iZPlanApi.launchScheme(requireContext, uGCJumpMyBagAllScheme);
                    }
                    SuitCustomColorFragment.this.requireActivity().finish();
                }
            }
        };
        this.onSuitCardClick = new Function1<zv4.c, Unit>() { // from class: com.tencent.mobileqq.zplan.aigc.SuitCustomColorFragment$onSuitCardClick$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(zv4.c cVar) {
                invoke2(cVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(zv4.c ugcStoreItem) {
                Intrinsics.checkNotNullParameter(ugcStoreItem, "ugcStoreItem");
                SuitCustomColorFragment.this.Oh(ugcStoreItem);
            }
        };
        this.onHintIconClick = new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.aigc.SuitCustomColorFragment$onHintIconClick$1
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
                ZPlanUgcDyingConfirmDialogHelper zPlanUgcDyingConfirmDialogHelper;
                Context context = SuitCustomColorFragment.this.getContext();
                if (context != null) {
                    zPlanUgcDyingConfirmDialogHelper = SuitCustomColorFragment.this.dyeingConfirmDialogHelper;
                    if (zPlanUgcDyingConfirmDialogHelper == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("dyeingConfirmDialogHelper");
                        zPlanUgcDyingConfirmDialogHelper = null;
                    }
                    if (zPlanUgcDyingConfirmDialogHelper != null) {
                        zPlanUgcDyingConfirmDialogHelper.h(context);
                    }
                }
            }
        };
    }

    private final boolean Mh() {
        String currentUin = MobileQQ.sMobileQQ.peekAppRuntime().getCurrentUin();
        return com.tencent.mobileqq.zplan.aigc.helper.h.f(com.tencent.mobileqq.zplan.aigc.helper.h.f330325a, "custom_color_confirm_" + currentUin, false, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Nh(SuitCustomColorFragment this$0, com.tencent.sqshow.zootopia.data.f data) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        PortalStoreCurrencyView Qh = this$0.Qh();
        Intrinsics.checkNotNullExpressionValue(data, "data");
        Qh.h(data);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Oh(final zv4.c ugcStoreItem) {
        final uv4.az subStoreItem;
        if (Xh().getVisibility() == 0) {
            return;
        }
        ji();
        uv4.az azVar = ugcStoreItem.f453570b;
        uv4.az[] azVarArr = azVar.f440289p;
        Intrinsics.checkNotNullExpressionValue(azVarArr, "ugcStoreItem.data.containStoreItems");
        if (azVarArr.length == 0) {
            subStoreItem = ugcStoreItem.f453570b;
        } else {
            subStoreItem = ugcStoreItem.f453570b.f440289p[0];
        }
        QLog.i("SuitCustomColorFragment", 1, " onSuitCardClick: " + subStoreItem.f440275b);
        int i3 = subStoreItem.f440275b;
        SuitCustomColorVewModel suitCustomColorVewModel = this.vm;
        SuitCustomColorVewModel suitCustomColorVewModel2 = null;
        if (suitCustomColorVewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
            suitCustomColorVewModel = null;
        }
        if (i3 == suitCustomColorVewModel.getCurrentItemId() && this.slotResourceIsReady.get()) {
            ZplanUgcDyeingDialogHelper zplanUgcDyeingDialogHelper = this.colorPanel;
            if (zplanUgcDyeingDialogHelper == null) {
                Intrinsics.throwUninitializedPropertyAccessException("colorPanel");
                zplanUgcDyeingDialogHelper = null;
            }
            SuitCustomColorVewModel suitCustomColorVewModel3 = this.vm;
            if (suitCustomColorVewModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("vm");
                suitCustomColorVewModel3 = null;
            }
            int slotId = suitCustomColorVewModel3.getSlotId();
            int i16 = ugcStoreItem.f453571c;
            FrameLayout Sh = Sh();
            LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
            Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "viewLifecycleOwner");
            zplanUgcDyeingDialogHelper.U(slotId, i16, Sh, viewLifecycleOwner);
            ZplanUgcDyeingDialogHelper zplanUgcDyeingDialogHelper2 = this.colorPanel;
            if (zplanUgcDyeingDialogHelper2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("colorPanel");
                zplanUgcDyeingDialogHelper2 = null;
            }
            SuitCustomColorVewModel suitCustomColorVewModel4 = this.vm;
            if (suitCustomColorVewModel4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("vm");
            } else {
                suitCustomColorVewModel2 = suitCustomColorVewModel4;
            }
            zplanUgcDyeingDialogHelper2.S(suitCustomColorVewModel2.Q2());
            ki();
            Lh(true);
            return;
        }
        if (!NetworkUtil.isNetworkAvailable()) {
            hi("\u7f51\u7edc\u5f02\u5e38\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5");
            ki();
            return;
        }
        SuitCustomColorVewModel suitCustomColorVewModel5 = this.vm;
        if (suitCustomColorVewModel5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
            suitCustomColorVewModel5 = null;
        }
        suitCustomColorVewModel5.s3(ugcStoreItem);
        SuitCustomColorVewModel suitCustomColorVewModel6 = this.vm;
        if (suitCustomColorVewModel6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
            suitCustomColorVewModel6 = null;
        }
        Intrinsics.checkNotNullExpressionValue(subStoreItem, "subStoreItem");
        suitCustomColorVewModel6.q3(subStoreItem);
        SuitCustomColorVewModel suitCustomColorVewModel7 = this.vm;
        if (suitCustomColorVewModel7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
            suitCustomColorVewModel7 = null;
        }
        suitCustomColorVewModel7.l3(subStoreItem.f440275b);
        SuitCustomColorVewModel suitCustomColorVewModel8 = this.vm;
        if (suitCustomColorVewModel8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
            suitCustomColorVewModel8 = null;
        }
        String str = azVar.f440277d;
        Intrinsics.checkNotNullExpressionValue(str, "storeItem.name");
        suitCustomColorVewModel8.r3(str);
        SuitCustomColorVewModel suitCustomColorVewModel9 = this.vm;
        if (suitCustomColorVewModel9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
            suitCustomColorVewModel9 = null;
        }
        suitCustomColorVewModel9.u3(subStoreItem.f440290q.f440324a);
        this.slotResourceIsReady.set(false);
        SuitCustomColorVewModel suitCustomColorVewModel10 = this.vm;
        if (suitCustomColorVewModel10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
            suitCustomColorVewModel10 = null;
        }
        suitCustomColorVewModel10.v3(-1L);
        SuitCustomColorVewModel suitCustomColorVewModel11 = this.vm;
        if (suitCustomColorVewModel11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
            suitCustomColorVewModel11 = null;
        }
        SuitCustomColorVewModel suitCustomColorVewModel12 = this.vm;
        if (suitCustomColorVewModel12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
        } else {
            suitCustomColorVewModel2 = suitCustomColorVewModel12;
        }
        suitCustomColorVewModel11.u2(Long.valueOf(suitCustomColorVewModel2.getCurrentItemId()), new Function2<Boolean, Long, Unit>() { // from class: com.tencent.mobileqq.zplan.aigc.SuitCustomColorFragment$enterColorEditDialog$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, Long l3) {
                invoke(bool.booleanValue(), l3.longValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16, long j3) {
                ZplanFilamentSuitRender zplanFilamentSuitRender;
                if (!z16) {
                    QLog.e("SuitCustomColorFragment", 1, "fetch item ugcId failed");
                    SuitCustomColorVewModel suitCustomColorVewModel13 = SuitCustomColorFragment.this.vm;
                    if (suitCustomColorVewModel13 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("vm");
                        suitCustomColorVewModel13 = null;
                    }
                    suitCustomColorVewModel13.l3(0);
                    SuitCustomColorFragment.this.hi("\u8be5\u670d\u88c5\u6682\u4e0d\u652f\u6301\uff0c\u8bd5\u8bd5\u522b\u7684\u5427\uff01");
                    final SuitCustomColorFragment suitCustomColorFragment = SuitCustomColorFragment.this;
                    CommonExKt.j(new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.aigc.SuitCustomColorFragment$enterColorEditDialog$1.1
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
                            SuitCustomColorFragment.this.ki();
                        }
                    });
                    return;
                }
                final SuitCustomColorFragment suitCustomColorFragment2 = SuitCustomColorFragment.this;
                final uv4.az azVar2 = subStoreItem;
                final zv4.c cVar = ugcStoreItem;
                AigcPreviewBusinessScene.a aVar = new AigcPreviewBusinessScene.a() { // from class: com.tencent.mobileqq.zplan.aigc.SuitCustomColorFragment$enterColorEditDialog$1$listener$1
                    @Override // com.tencent.mobileqq.zootopia.portal.aigc.preview.AigcPreviewBusinessScene.a
                    public void onSuccess(String slotId2, String gltfPath) {
                        Intrinsics.checkNotNullParameter(slotId2, "slotId");
                        if (SuitCustomColorFragment.this.getView() == null) {
                            return;
                        }
                        if (gltfPath != null) {
                            SuitCustomColorVewModel suitCustomColorVewModel14 = SuitCustomColorFragment.this.vm;
                            if (suitCustomColorVewModel14 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("vm");
                                suitCustomColorVewModel14 = null;
                            }
                            final SuitCustomColorFragment suitCustomColorFragment3 = SuitCustomColorFragment.this;
                            final uv4.az azVar3 = azVar2;
                            final zv4.c cVar2 = cVar;
                            suitCustomColorVewModel14.g3(gltfPath, new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.zplan.aigc.SuitCustomColorFragment$enterColorEditDialog$1$listener$1$onSuccess$2
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                                    invoke(bool.booleanValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(boolean z17) {
                                    AtomicBoolean atomicBoolean;
                                    if (!z17) {
                                        SuitCustomColorFragment.this.hi("\u8be5\u670d\u88c5\u6682\u4e0d\u652f\u6301\uff0c\u8bd5\u8bd5\u522b\u7684\u5427\uff01");
                                        final SuitCustomColorFragment suitCustomColorFragment4 = SuitCustomColorFragment.this;
                                        CommonExKt.j(new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.aigc.SuitCustomColorFragment$enterColorEditDialog$1$listener$1$onSuccess$2.1
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
                                                SuitCustomColorFragment.this.ki();
                                            }
                                        });
                                    } else {
                                        atomicBoolean = SuitCustomColorFragment.this.slotResourceIsReady;
                                        atomicBoolean.set(true);
                                        SuitCustomColorFragment.this.oi(azVar3.f440275b, cVar2.f453571c);
                                    }
                                }
                            });
                            return;
                        }
                        QLog.e("SuitCustomColorFragment", 1, "gltfPath is null");
                        SuitCustomColorFragment.this.hi("\u7f51\u7edc\u5f02\u5e38\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5");
                        final SuitCustomColorFragment suitCustomColorFragment4 = SuitCustomColorFragment.this;
                        CommonExKt.j(new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.aigc.SuitCustomColorFragment$enterColorEditDialog$1$listener$1$onSuccess$1
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
                                SuitCustomColorFragment.this.ki();
                            }
                        });
                    }
                };
                zplanFilamentSuitRender = SuitCustomColorFragment.this.filamentRender;
                AigcPreviewBusinessScene scene = zplanFilamentSuitRender.getScene();
                if (scene != null) {
                    scene.requestAvatarSlotRes(subStoreItem, aVar);
                }
            }
        });
        this.filamentRender.f(azVar);
    }

    private final ImageView Ph() {
        Object value = this.backBtn.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-backBtn>(...)");
        return (ImageView) value;
    }

    private final PortalStoreCurrencyView Qh() {
        Object value = this.coinArea.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-coinArea>(...)");
        return (PortalStoreCurrencyView) value;
    }

    private final FrameLayout Rh() {
        Object value = this.confirmDialogViewContainer.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-confirmDialogViewContainer>(...)");
        return (FrameLayout) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FrameLayout Sh() {
        Object value = this.dialogViewContainer.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-dialogViewContainer>(...)");
        return (FrameLayout) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FrameLayout Th() {
        Object value = this.filamentContainer.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-filamentContainer>(...)");
        return (FrameLayout) value;
    }

    private final LinearLayout Uh() {
        Object value = this.historyLayout.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-historyLayout>(...)");
        return (LinearLayout) value;
    }

    private final PortalStoreHistoryControllerView Vh() {
        Object value = this.historyOptView.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-historyOptView>(...)");
        return (PortalStoreHistoryControllerView) value;
    }

    private final SuitPagView Wh() {
        Object value = this.lightEffectPAG.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-lightEffectPAG>(...)");
        return (SuitPagView) value;
    }

    private final NativePanelLoadingIgv Xh() {
        Object value = this.loadingView.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-loadingView>(...)");
        return (NativePanelLoadingIgv) value;
    }

    private final QUIPolarLightView Yh() {
        Object value = this.polarLightView.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-polarLightView>(...)");
        return (QUIPolarLightView) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ImageView Zh() {
        Object value = this.screenshotImageView.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-screenshotImageView>(...)");
        return (ImageView) value;
    }

    private final void ai() {
        Context context;
        if (!NetworkUtil.isNetworkAvailable()) {
            hi("\u7f51\u7edc\u5f02\u5e38\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5");
            ki();
        }
        Context context2 = getContext();
        ZPlanUgcDyingConfirmDialogHelper zPlanUgcDyingConfirmDialogHelper = null;
        if (context2 != null) {
            ZPlanUgcDyingSuitListDialogHelper zPlanUgcDyingSuitListDialogHelper = this.suitListDialogHelper;
            if (zPlanUgcDyingSuitListDialogHelper == null) {
                Intrinsics.throwUninitializedPropertyAccessException("suitListDialogHelper");
                zPlanUgcDyingSuitListDialogHelper = null;
            }
            zPlanUgcDyingSuitListDialogHelper.j(context2, this.onSuitCardClick, this.onHintIconClick);
        }
        if (Mh() || (context = getContext()) == null) {
            return;
        }
        ZPlanUgcDyingConfirmDialogHelper zPlanUgcDyingConfirmDialogHelper2 = this.dyeingConfirmDialogHelper;
        if (zPlanUgcDyingConfirmDialogHelper2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dyeingConfirmDialogHelper");
        } else {
            zPlanUgcDyingConfirmDialogHelper = zPlanUgcDyingConfirmDialogHelper2;
        }
        zPlanUgcDyingConfirmDialogHelper.h(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bi(SuitCustomColorFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.onBackEvent();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ci(SuitCustomColorFragment this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        zd3.a aVar = this$0.dtReporter;
        Intrinsics.checkNotNullExpressionValue(it, "it");
        zd3.a.v(aVar, it, "em_zplan_recharge", null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void di(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ei() {
        SuitCustomColorVewModel suitCustomColorVewModel = this.vm;
        SuitCustomColorVewModel suitCustomColorVewModel2 = null;
        if (suitCustomColorVewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
            suitCustomColorVewModel = null;
        }
        if (!suitCustomColorVewModel.f3(null, false)) {
            QLog.i("SuitCustomColorFragment", 1, "checkSoAndInitLightSdk failed");
            SuitCustomColorVewModel suitCustomColorVewModel3 = this.vm;
            if (suitCustomColorVewModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("vm");
            } else {
                suitCustomColorVewModel2 = suitCustomColorVewModel3;
            }
            suitCustomColorVewModel2.r2(new b());
            return;
        }
        ni();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void fi() {
        this.filamentRender.i().onPause();
        this.filamentRender.n();
        this.filamentRender.p();
        QLog.i("SuitCustomColorFragment", 1, "restoreDressInfo begin");
        SuitCustomColorVewModel suitCustomColorVewModel = this.vm;
        if (suitCustomColorVewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
            suitCustomColorVewModel = null;
        }
        li(suitCustomColorVewModel.getCurrentStoreItem(), new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.zplan.aigc.SuitCustomColorFragment$restoreDressInfo$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16) {
                ZplanFilamentSuitRender zplanFilamentSuitRender;
                if (z16) {
                    SuitCustomColorVewModel suitCustomColorVewModel2 = SuitCustomColorFragment.this.vm;
                    if (suitCustomColorVewModel2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("vm");
                        suitCustomColorVewModel2 = null;
                    }
                    zplanFilamentSuitRender = SuitCustomColorFragment.this.filamentRender;
                    final SuitCustomColorFragment suitCustomColorFragment = SuitCustomColorFragment.this;
                    suitCustomColorVewModel2.j3(zplanFilamentSuitRender, new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.aigc.SuitCustomColorFragment$restoreDressInfo$1.1
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
                            final SuitCustomColorFragment suitCustomColorFragment2 = SuitCustomColorFragment.this;
                            CommonExKt.j(new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.aigc.SuitCustomColorFragment.restoreDressInfo.1.1.1
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
                                    ImageView Zh;
                                    FrameLayout Th;
                                    Zh = SuitCustomColorFragment.this.Zh();
                                    Zh.setVisibility(8);
                                    Th = SuitCustomColorFragment.this.Th();
                                    Th.setVisibility(0);
                                }
                            });
                            QLog.i("SuitCustomColorFragment", 1, "restoreDressInfo end");
                        }
                    });
                }
            }
        });
    }

    private final void gi() {
        CommonExKt.j(new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.aigc.SuitCustomColorFragment$showBackConfirmDialog$1

            /* compiled from: P */
            @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/zplan/aigc/SuitCustomColorFragment$showBackConfirmDialog$1$a", "Landroid/content/DialogInterface$OnClickListener;", "Landroid/content/DialogInterface;", "p0", "", "p1", "", NodeProps.ON_CLICK, "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes35.dex */
            public static final class a implements DialogInterface.OnClickListener {

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ SuitCustomColorFragment f329923d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ QQCustomDialog f329924e;

                a(SuitCustomColorFragment suitCustomColorFragment, QQCustomDialog qQCustomDialog) {
                    this.f329923d = suitCustomColorFragment;
                    this.f329924e = qQCustomDialog;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface p06, int p16) {
                    zd3.a aVar;
                    int i3;
                    ZplanFilamentSuitRender zplanFilamentSuitRender;
                    ZplanUgcDyeingDialogHelper zplanUgcDyeingDialogHelper;
                    ga4.f dialogController;
                    aVar = this.f329923d.dtReporter;
                    i3 = this.f329923d.from;
                    aVar.k(i3, "exit_creation");
                    SuitCustomColorVewModel suitCustomColorVewModel = this.f329923d.vm;
                    ZplanUgcDyeingDialogHelper zplanUgcDyeingDialogHelper2 = null;
                    if (suitCustomColorVewModel == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("vm");
                        suitCustomColorVewModel = null;
                    }
                    zplanFilamentSuitRender = this.f329923d.filamentRender;
                    suitCustomColorVewModel.i3(zplanFilamentSuitRender);
                    zplanUgcDyeingDialogHelper = this.f329923d.colorPanel;
                    if (zplanUgcDyeingDialogHelper == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("colorPanel");
                    } else {
                        zplanUgcDyeingDialogHelper2 = zplanUgcDyeingDialogHelper;
                    }
                    com.tencent.sqshow.zootopia.nativeui.data.j mChannel = zplanUgcDyeingDialogHelper2.getMChannel();
                    if (mChannel != null && (dialogController = mChannel.getDialogController()) != null) {
                        dialogController.a();
                    }
                    this.f329923d.Lh(false);
                    try {
                        if (this.f329924e.isShowing()) {
                            this.f329924e.dismiss();
                        }
                    } catch (Exception e16) {
                        QLog.e("SuitCustomColorFragment", 1, "exit creation exception" + e16.getMessage());
                    }
                }
            }

            /* compiled from: P */
            @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/zplan/aigc/SuitCustomColorFragment$showBackConfirmDialog$1$b", "Landroid/content/DialogInterface$OnClickListener;", "Landroid/content/DialogInterface;", "p0", "", "p1", "", NodeProps.ON_CLICK, "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes35.dex */
            public static final class b implements DialogInterface.OnClickListener {

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ SuitCustomColorFragment f329925d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ QQCustomDialog f329926e;

                b(SuitCustomColorFragment suitCustomColorFragment, QQCustomDialog qQCustomDialog) {
                    this.f329925d = suitCustomColorFragment;
                    this.f329926e = qQCustomDialog;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface p06, int p16) {
                    zd3.a aVar;
                    int i3;
                    aVar = this.f329925d.dtReporter;
                    i3 = this.f329925d.from;
                    aVar.k(i3, "continue_dyeing");
                    try {
                        if (this.f329926e.isShowing()) {
                            this.f329926e.dismiss();
                        }
                    } catch (Exception e16) {
                        QLog.e("SuitCustomColorFragment", 1, "exit creation exception" + e16.getMessage());
                    }
                }
            }

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
                zd3.a aVar;
                int i3;
                QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(SuitCustomColorFragment.this.getContext(), 230);
                createCustomDialog.setTitle(R.string.xwi);
                createCustomDialog.setNegativeButton(R.string.xwh, new a(SuitCustomColorFragment.this, createCustomDialog));
                createCustomDialog.setPositiveButton(R.string.xwg, new b(SuitCustomColorFragment.this, createCustomDialog));
                createCustomDialog.show();
                aVar = SuitCustomColorFragment.this.dtReporter;
                i3 = SuitCustomColorFragment.this.from;
                aVar.l(i3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void hi(final String message) {
        CommonExKt.j(new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.aigc.SuitCustomColorFragment$showFailedToast$1
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
                QQToast.makeText(SuitCustomColorFragment.this.getContext(), 1, message, 0).show();
            }
        });
    }

    private final void ii(final String message) {
        CommonExKt.j(new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.aigc.SuitCustomColorFragment$showNormalToast$1
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
                QQToast.makeText(SuitCustomColorFragment.this.getContext(), 0, message, 0).show();
            }
        });
    }

    private final void ji() {
        Xh().setVisibility(0);
        Xh().f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ki() {
        Xh().setVisibility(8);
        Xh().g();
    }

    private final void li(uv4.az storeItem, Function1<? super Boolean, Unit> callback) {
        List listOf;
        Context context = getContext();
        if (context != null) {
            this.filamentRender.o(context, new WeakReference<>(Th()));
        }
        this.filamentRender.i().c("onFirstFrameRenderEnd", new c(callback));
        ZplanFilamentSuitRender.a aVar = new ZplanFilamentSuitRender.a();
        if (storeItem != null) {
            listOf = CollectionsKt__CollectionsJVMKt.listOf(new LocalUgcPath("", storeItem));
            aVar.i(listOf);
        }
        aVar.h(com.tencent.sqshow.zootopia.nativeui.data.c.f370920a.e().b());
        aVar.f(1);
        SuitCustomColorVewModel suitCustomColorVewModel = this.vm;
        if (suitCustomColorVewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
            suitCustomColorVewModel = null;
        }
        aVar.g(suitCustomColorVewModel.getDefaultCamera());
        this.filamentRender.g(aVar, LifecycleOwnerKt.getLifecycleScope(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ni() {
        SuitCustomColorVewModel suitCustomColorVewModel = this.vm;
        if (suitCustomColorVewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
            suitCustomColorVewModel = null;
        }
        suitCustomColorVewModel.a3().postValue(Boolean.TRUE);
        Wh().x();
        SuitPagView.v(Wh(), "https://downv6.qq.com/shadow_qqcamera/zshow/aigc_suit_preview_up_light_loop.pag", false, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void oi(int itemId, int price) {
        CoroutineScope f16;
        SuitCustomColorVewModel suitCustomColorVewModel = this.vm;
        if (suitCustomColorVewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
            suitCustomColorVewModel = null;
        }
        int currentItemId = suitCustomColorVewModel.getCurrentItemId();
        SuitCustomColorVewModel suitCustomColorVewModel2 = this.vm;
        if (suitCustomColorVewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
            suitCustomColorVewModel2 = null;
        }
        long ugcId = suitCustomColorVewModel2.getUgcId();
        boolean z16 = this.slotResourceIsReady.get();
        SuitCustomColorVewModel suitCustomColorVewModel3 = this.vm;
        if (suitCustomColorVewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
            suitCustomColorVewModel3 = null;
        }
        QLog.i("SuitCustomColorFragment", 1, "tryShowColorDialogTask vm.currentItemId: " + currentItemId + " substoreItem.itemId: " + itemId + "ugcid: " + ugcId + " slotResourceIsReady: " + z16 + " lightSDKIsReady: " + suitCustomColorVewModel3.a3().getValue());
        SuitCustomColorVewModel suitCustomColorVewModel4 = this.vm;
        if (suitCustomColorVewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
            suitCustomColorVewModel4 = null;
        }
        if (suitCustomColorVewModel4.getCurrentItemId() == itemId && this.slotResourceIsReady.get()) {
            SuitCustomColorVewModel suitCustomColorVewModel5 = this.vm;
            if (suitCustomColorVewModel5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("vm");
                suitCustomColorVewModel5 = null;
            }
            if (Intrinsics.areEqual(suitCustomColorVewModel5.a3().getValue(), Boolean.TRUE)) {
                SuitCustomColorVewModel suitCustomColorVewModel6 = this.vm;
                if (suitCustomColorVewModel6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("vm");
                    suitCustomColorVewModel6 = null;
                }
                if (suitCustomColorVewModel6.getUgcId() <= 0 || (f16 = com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a.f(i.d.f261782e)) == null) {
                    return;
                }
                CorountineFunKt.e(f16, "SuitCustomColorFragment_generateUgcResource", null, null, null, new SuitCustomColorFragment$tryShowColorDialogTask$1(this, price, null), 14, null);
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        return new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment
    public boolean enableRootViewSetFitsSystemWindows() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.f167461dg0;
    }

    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment
    protected int getStatusBarColor() {
        return 0;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        ga4.f dialogController;
        ga4.f dialogController2;
        ZplanUgcDyeingDialogHelper zplanUgcDyeingDialogHelper = this.colorPanel;
        ZPlanUgcDyingSuitListDialogHelper zPlanUgcDyingSuitListDialogHelper = null;
        ZplanUgcDyeingDialogHelper zplanUgcDyeingDialogHelper2 = null;
        if (zplanUgcDyeingDialogHelper == null) {
            Intrinsics.throwUninitializedPropertyAccessException("colorPanel");
            zplanUgcDyeingDialogHelper = null;
        }
        boolean z16 = false;
        if (zplanUgcDyeingDialogHelper.N()) {
            ImageView Ph = Ph();
            if (Ph != null) {
                zd3.a.v(this.dtReporter, Ph, "em_zplan_back_btn", null, 4, null);
            }
            ZplanUgcDyeingDialogHelper zplanUgcDyeingDialogHelper3 = this.colorPanel;
            if (zplanUgcDyeingDialogHelper3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("colorPanel");
                zplanUgcDyeingDialogHelper3 = null;
            }
            if (zplanUgcDyeingDialogHelper3.getColorEditHistoryHelper().g()) {
                gi();
            } else {
                ZplanUgcDyeingDialogHelper zplanUgcDyeingDialogHelper4 = this.colorPanel;
                if (zplanUgcDyeingDialogHelper4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("colorPanel");
                } else {
                    zplanUgcDyeingDialogHelper2 = zplanUgcDyeingDialogHelper4;
                }
                com.tencent.sqshow.zootopia.nativeui.data.j mChannel = zplanUgcDyeingDialogHelper2.getMChannel();
                if (mChannel != null && (dialogController2 = mChannel.getDialogController()) != null) {
                    dialogController2.a();
                }
                Lh(false);
            }
            return true;
        }
        ZPlanUgcDyingSuitListDialogHelper zPlanUgcDyingSuitListDialogHelper2 = this.suitListDialogHelper;
        if (zPlanUgcDyingSuitListDialogHelper2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("suitListDialogHelper");
        } else {
            zPlanUgcDyingSuitListDialogHelper = zPlanUgcDyingSuitListDialogHelper2;
        }
        com.tencent.sqshow.zootopia.nativeui.data.j mChannel2 = zPlanUgcDyingSuitListDialogHelper.getMChannel();
        if (mChannel2 != null && (dialogController = mChannel2.getDialogController()) != null && dialogController.a()) {
            z16 = true;
        }
        if (z16) {
            ImageView Ph2 = Ph();
            if (Ph2 != null) {
                zd3.a.v(this.dtReporter, Ph2, "em_zplan_dyeing_close_btn", null, 4, null);
            }
            requireActivity().finish();
            return true;
        }
        return super.onBackEvent();
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        int value;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        Bundle arguments = getArguments();
        if (arguments != null) {
            if (arguments.containsKey("from")) {
                value = arguments.getInt("from");
            } else {
                value = SuitUGCCustomColorFromValue.DEFAULT.getValue();
            }
            this.from = value;
        }
        this.parentView = super.onCreateView(inflater, container, savedInstanceState);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(SquareReportConst.Key.KEY_SOURCE, Integer.valueOf(this.from));
        View view = this.parentView;
        if (view != null) {
            this.dtReporter.c(this, view, "pg_zplan_clothing_dyeing", linkedHashMap);
        }
        VideoReport.setPageId(this.parentView, "pg_zplan_clothing_dyeing");
        return this.parentView;
    }

    @Override // com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.filamentRender.n();
        this.filamentRender.p();
        SuitCustomColorVewModel suitCustomColorVewModel = null;
        if (this.from != SuitUGCCustomColorFromValue.MALL.getValue()) {
            SuitCustomColorVewModel suitCustomColorVewModel2 = this.vm;
            if (suitCustomColorVewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("vm");
                suitCustomColorVewModel2 = null;
            }
            suitCustomColorVewModel2.getAvatarDressDataManager().b();
        }
        SuitCustomColorVewModel suitCustomColorVewModel3 = this.vm;
        if (suitCustomColorVewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
        } else {
            suitCustomColorVewModel = suitCustomColorVewModel3;
        }
        suitCustomColorVewModel.destroy();
        gb4.a.f401894a.b().removeObserver(this.coinUpdateObserver);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        Yh().stopAnimation();
        this.filamentRender.q();
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        Yh().m();
        this.filamentRender.r();
    }

    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        QLog.i("SuitCustomColorFragment", 1, " onViewCreated");
        super.onViewCreated(view, savedInstanceState);
        initView();
        initViewModel();
    }

    private final void initView() {
        List<Integer> listOf;
        Lh(false);
        Ph().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zplan.aigc.t
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SuitCustomColorFragment.bi(SuitCustomColorFragment.this, view);
            }
        });
        QUIPolarLightView Yh = Yh();
        PolarImageRender polarLightRender = Yh != null ? Yh.getPolarLightRender() : null;
        if (polarLightRender != null) {
            polarLightRender.q(new a.b(1.0f, 0.5f, 0.5f, 0.6f, 0.0f));
        }
        QUIPolarLightView Yh2 = Yh();
        PolarImageRender polarLightRender2 = Yh2 != null ? Yh2.getPolarLightRender() : null;
        if (polarLightRender2 != null) {
            listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf(Color.parseColor("#F8FFF0")), Integer.valueOf(Color.parseColor("#FEE7CE")), Integer.valueOf(Color.parseColor("#89A6F1")), Integer.valueOf(Color.parseColor("#C9DAFA")), Integer.valueOf(Color.parseColor("#F487F0")), Integer.valueOf(Color.parseColor("#74ACFF")), Integer.valueOf(Color.parseColor("#E89AFB"))});
            polarLightRender2.s(listOf);
        }
        QUIPolarLightView Yh3 = Yh();
        PolarImageRender polarLightRender3 = Yh3 != null ? Yh3.getPolarLightRender() : null;
        if (polarLightRender3 != null) {
            polarLightRender3.r(0.3f);
        }
        QUIPolarLightView Yh4 = Yh();
        PolarImageRender polarLightRender4 = Yh4 != null ? Yh4.getPolarLightRender() : null;
        if (polarLightRender4 != null) {
            polarLightRender4.t(PolarImageRender.RenderSize.LARGE);
        }
        Qh().setCoinListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zplan.aigc.u
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SuitCustomColorFragment.ci(SuitCustomColorFragment.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Lh(boolean needArrow) {
        if (needArrow) {
            Ph().setBackgroundResource(R.drawable.h1z);
        } else {
            Ph().setBackgroundResource(R.drawable.f159858h23);
        }
    }

    private final void initViewModel() {
        SuitCustomColorVewModel suitCustomColorVewModel;
        ViewModel viewModel = new ViewModelProvider(this).get(SuitCustomColorVewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this).\u2026olorVewModel::class.java)");
        this.vm = (SuitCustomColorVewModel) viewModel;
        if (this.from != SuitUGCCustomColorFromValue.MALL.getValue()) {
            ii("\u8d44\u6e90\u52a0\u8f7d\u4e2d...");
            SuitCustomColorVewModel suitCustomColorVewModel2 = this.vm;
            if (suitCustomColorVewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("vm");
                suitCustomColorVewModel2 = null;
            }
            suitCustomColorVewModel2.getAvatarDressDataManager().e();
            SuitCustomColorVewModel suitCustomColorVewModel3 = this.vm;
            if (suitCustomColorVewModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("vm");
                suitCustomColorVewModel3 = null;
            }
            LiveData<Boolean> S2 = suitCustomColorVewModel3.S2();
            LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
            final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.zplan.aigc.SuitCustomColorFragment$initViewModel$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke2(bool);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(final Boolean bool) {
                    final SuitCustomColorFragment suitCustomColorFragment = SuitCustomColorFragment.this;
                    CommonExKt.j(new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.aigc.SuitCustomColorFragment$initViewModel$1.1
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
                            if (!bool.booleanValue()) {
                                suitCustomColorFragment.hi("\u7f51\u7edc\u5f02\u5e38\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5");
                            } else {
                                SuitCustomColorFragment.mi(suitCustomColorFragment, null, new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.zplan.aigc.SuitCustomColorFragment.initViewModel.1.1.1
                                    public final void invoke(boolean z16) {
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool2) {
                                        invoke(bool2.booleanValue());
                                        return Unit.INSTANCE;
                                    }
                                }, 1, null);
                                suitCustomColorFragment.ei();
                            }
                        }
                    });
                }
            };
            S2.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.zplan.aigc.w
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    SuitCustomColorFragment.di(Function1.this, obj);
                }
            });
            SuitCustomColorVewModel suitCustomColorVewModel4 = this.vm;
            if (suitCustomColorVewModel4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("vm");
                suitCustomColorVewModel4 = null;
            }
            SuitCustomColorVewModel.t2(suitCustomColorVewModel4, null, false, 3, null);
        } else {
            mi(this, null, new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.zplan.aigc.SuitCustomColorFragment$initViewModel$2
                public final void invoke(boolean z16) {
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return Unit.INSTANCE;
                }
            }, 1, null);
            ei();
        }
        gb4.a.f401894a.b().observe(getViewLifecycleOwner(), this.coinUpdateObserver);
        yb4.e.g(yb4.e.f450058a, null, 0, 3, null);
        if (!j74.b.f409622a.b()) {
            SuitCustomColorVewModel suitCustomColorVewModel5 = this.vm;
            if (suitCustomColorVewModel5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("vm");
                suitCustomColorVewModel5 = null;
            }
            SuitCustomColorVewModel.w2(suitCustomColorVewModel5, 0, 1, null);
        } else {
            SuitCustomColorVewModel suitCustomColorVewModel6 = this.vm;
            if (suitCustomColorVewModel6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("vm");
                suitCustomColorVewModel6 = null;
            }
            SuitCustomColorVewModel.y2(suitCustomColorVewModel6, 0, 1, null);
        }
        FrameLayout Rh = Rh();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "viewLifecycleOwner");
        this.dyeingConfirmDialogHelper = new ZPlanUgcDyingConfirmDialogHelper(Rh, viewLifecycleOwner2, this.dtReporter);
        FrameLayout Sh = Sh();
        SuitCustomColorVewModel suitCustomColorVewModel7 = this.vm;
        if (suitCustomColorVewModel7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
            suitCustomColorVewModel7 = null;
        }
        LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner3, "viewLifecycleOwner");
        this.suitListDialogHelper = new ZPlanUgcDyingSuitListDialogHelper(Sh, suitCustomColorVewModel7, viewLifecycleOwner3, this.dtReporter);
        Context context = getContext();
        SuitCustomColorVewModel suitCustomColorVewModel8 = this.vm;
        if (suitCustomColorVewModel8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
            suitCustomColorVewModel = null;
        } else {
            suitCustomColorVewModel = suitCustomColorVewModel8;
        }
        this.colorPanel = new ZplanUgcDyeingDialogHelper(context, suitCustomColorVewModel, this.filamentRender, Vh(), Uh(), this.from, this.dtReporter, new WeakReference(this.onSaveButtonClick));
        ai();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void mi(SuitCustomColorFragment suitCustomColorFragment, uv4.az azVar, Function1 function1, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            azVar = null;
        }
        suitCustomColorFragment.li(azVar, function1);
    }
}
