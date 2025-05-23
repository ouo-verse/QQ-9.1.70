package com.tencent.ecommerce.biz.detail.fragment;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Property;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import cg0.a;
import com.qzone.preview.service.base.PictureConst;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheLunarData;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.ditto.shell.LayoutAttrDefine;
import com.tencent.ecommerce.base.QQECChannel;
import com.tencent.ecommerce.base.QQEcommerceSdk;
import com.tencent.ecommerce.base.eventbus.EventObserver;
import com.tencent.ecommerce.base.eventbus.LifecycleEventBus;
import com.tencent.ecommerce.base.eventbus.ThreadMode;
import com.tencent.ecommerce.base.fragment.ECBaseFragment;
import com.tencent.ecommerce.base.ktx.ECSchemeExtUserDataMap;
import com.tencent.ecommerce.base.list.IStateCenterView;
import com.tencent.ecommerce.base.rmonitor.service.ECRMonitorManager;
import com.tencent.ecommerce.base.ui.ECBasePtsViewData;
import com.tencent.ecommerce.base.ui.ECFloatGestureLayout;
import com.tencent.ecommerce.base.ui.component.ECBaseRecyclerView;
import com.tencent.ecommerce.base.ui.stateview.ECStateCenterView;
import com.tencent.ecommerce.base.videnevent.api.IECVideoControlDelegate;
import com.tencent.ecommerce.biz.detail.repo.shop.data.ECShopProductDetailInfo;
import com.tencent.ecommerce.biz.detail.ui.ECShopDetailItemDecoration;
import com.tencent.ecommerce.biz.detail.utils.ECDetailPageDuration;
import com.tencent.ecommerce.biz.detail.utils.ECSourceFrom;
import com.tencent.ecommerce.biz.detail.viewmodel.shop.ECShopProductDetailOffSaleViewModel;
import com.tencent.ecommerce.biz.util.r;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.qqmini.sdk.request.GetAdInfoRequest;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import cooperation.qzone.remote.logic.RemoteHandleConst;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import mqq.app.Constants;
import org.json.JSONArray;
import org.json.JSONObject;
import zi0.ECForegroundEvent;

@Metadata(d1 = {"\u0000\u00ba\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b,\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00a1\u00012\u00020\u0001:\u0002\u00a2\u0001B\t\u00a2\u0006\u0006\b\u009f\u0001\u0010\u00a0\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0006\u0010\u0006\u001a\u00020\u0004J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\b\u0010\t\u001a\u00020\u0004H\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\u001a\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\b\u0010\u0013\u001a\u00020\u000fH\u0016J\u0010\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\fH\u0002J\b\u0010\u0016\u001a\u00020\u0004H\u0002J\b\u0010\u0017\u001a\u00020\u0004H\u0002J\b\u0010\u0018\u001a\u00020\u0004H\u0003J\b\u0010\u0019\u001a\u00020\u0004H\u0002J\u0010\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u000fH\u0002J\u0018\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\fH\u0002J\b\u0010\u001f\u001a\u00020\u0004H\u0002J.\u0010%\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\u00112\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\"0!2\b\b\u0002\u0010$\u001a\u00020\u0011H\u0002J\b\u0010&\u001a\u00020\u0004H\u0002J\b\u0010'\u001a\u00020\u0004H\u0002R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0016\u00105\u001a\u0002008\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b4\u00102R\u0016\u00109\u001a\u0002068\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010=\u001a\u00020:8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010A\u001a\u00020>8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010C\u001a\u00020>8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bB\u0010@R\u0016\u0010G\u001a\u00020D8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bE\u0010FR\u0018\u0010K\u001a\u0004\u0018\u00010H8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bI\u0010JR\u0016\u0010N\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bL\u0010MR\u0016\u0010R\u001a\u00020O8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bP\u0010QR\u0016\u0010T\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bS\u0010MR\u0016\u0010W\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bU\u0010VR\u0016\u0010Y\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bX\u0010VR\u0016\u0010[\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bZ\u0010VR\u0016\u0010]\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\\\u0010VR\u0016\u0010_\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b^\u0010LR\u0016\u0010a\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b`\u0010VR\u0016\u0010c\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bb\u0010VR\u0016\u0010e\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bd\u0010VR\u0016\u0010g\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bf\u0010VR\u0016\u0010i\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bh\u0010VR\u0016\u0010k\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bj\u0010VR\u0016\u0010m\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bl\u0010VR\u0016\u0010o\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bn\u0010VR\u0016\u0010q\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bp\u0010VR\u0016\u0010s\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\br\u0010VR\u0016\u0010u\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bt\u0010VR\u0016\u0010w\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bv\u0010VR\u0016\u0010y\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bx\u0010MR\u0016\u0010{\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bz\u0010MR\u001d\u0010\u0081\u0001\u001a\u00020|8BX\u0082\u0084\u0002\u00a2\u0006\r\n\u0004\b}\u0010~\u001a\u0005\b\u007f\u0010\u0080\u0001R\u001c\u0010\u0085\u0001\u001a\u0005\u0018\u00010\u0082\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0083\u0001\u0010\u0084\u0001R\u001c\u0010\u0089\u0001\u001a\u0005\u0018\u00010\u0086\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0087\u0001\u0010\u0088\u0001R\u001c\u0010\u008d\u0001\u001a\u0005\u0018\u00010\u008a\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u008b\u0001\u0010\u008c\u0001R\u0018\u0010\u008f\u0001\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u008e\u0001\u0010LR\u0018\u0010\u0091\u0001\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0090\u0001\u0010LR\u0018\u0010\u0093\u0001\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0092\u0001\u0010MR\u0018\u0010\u0095\u0001\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0094\u0001\u0010MR\u001c\u0010\u0099\u0001\u001a\u0005\u0018\u00010\u0096\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0097\u0001\u0010\u0098\u0001R\u001f\u0010\u009e\u0001\u001a\n\u0012\u0005\u0012\u00030\u009b\u00010\u009a\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u009c\u0001\u0010\u009d\u0001\u00a8\u0006\u00a3\u0001"}, d2 = {"Lcom/tencent/ecommerce/biz/detail/fragment/ECShopProductDetailOffSaleFragment;", "Lcom/tencent/ecommerce/base/fragment/ECBaseFragment;", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "onCreate", "initViewModel", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "", "getContentLayoutId", "Landroid/view/View;", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "", "onBackPressed", "", "getBusinessDescription", "Eh", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "initUI", "ni", "qi", "pi", "mi", "targetStateIsFloatMode", "ti", "targetStateIsVisible", "targetView", "si", "initArguments", "key", "", "", "map", RemoteHandleConst.PARAM_DEFAULT_VALUE, "ki", "ri", "oi", "Lcom/tencent/ecommerce/biz/detail/viewmodel/shop/ECShopProductDetailOffSaleViewModel;", "P", "Lcom/tencent/ecommerce/biz/detail/viewmodel/shop/ECShopProductDetailOffSaleViewModel;", "viewModel", "Lcom/tencent/ecommerce/base/ui/component/ECBaseRecyclerView;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/tencent/ecommerce/base/ui/component/ECBaseRecyclerView;", "detailPageRecyclerView", "Landroid/widget/RelativeLayout;", BdhLogUtil.LogTag.Tag_Req, "Landroid/widget/RelativeLayout;", "titleBar", ExifInterface.LATITUDE_SOUTH, "titleBarPlaceHolder", "Landroid/widget/LinearLayout;", "T", "Landroid/widget/LinearLayout;", "detailPageRootLayout", "Lcom/tencent/ecommerce/biz/detail/ui/d;", "U", "Lcom/tencent/ecommerce/biz/detail/ui/d;", "ecBaseRecyclerViewAdapter", "Landroid/widget/ImageView;", "V", "Landroid/widget/ImageView;", "leftCloseButton", "W", "rightCloseButton", "Lcom/tencent/ecommerce/base/ui/stateview/ECStateCenterView;", "X", "Lcom/tencent/ecommerce/base/ui/stateview/ECStateCenterView;", "stateCenterView", "Lcom/tencent/ecommerce/biz/detail/repo/shop/data/c;", "Y", "Lcom/tencent/ecommerce/biz/detail/repo/shop/data/c;", "productDetailInfo", "Z", "I", "scrollY", "Lcom/tencent/ecommerce/base/ktx/ECSchemeExtUserDataMap;", "a0", "Lcom/tencent/ecommerce/base/ktx/ECSchemeExtUserDataMap;", "serializableMap", "b0", WadlProxyConsts.CHANNEL, "c0", "Ljava/lang/String;", "saasType", "d0", "saasProductId", "e0", "sellerId", "f0", "mediaProductID", "g0", "isProductFromWindow", "h0", "categoryName", "i0", "goodsType", "j0", "categoryId", "k0", "sealTransfer", "l0", GetAdInfoRequest.SOURCE_FROM, "m0", "roomId", "n0", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REQUEST_ID, "o0", "bizType", "p0", "shopId", "q0", "spuId", "r0", "littleWorldFeedId", "s0", "activeId", "t0", "activeType", "u0", "role", "Lkotlinx/coroutines/CoroutineScope;", "v0", "Lkotlin/Lazy;", WidgetCacheLunarData.JI, "()Lkotlinx/coroutines/CoroutineScope;", "lifecycleScope", "Lcom/tencent/ecommerce/biz/detail/utils/b;", "w0", "Lcom/tencent/ecommerce/biz/detail/utils/b;", "detailPageDurationReport", "Landroid/animation/ObjectAnimator;", "x0", "Landroid/animation/ObjectAnimator;", "animatorForAlpha", "Lcom/tencent/ecommerce/base/ui/ECFloatGestureLayout;", "y0", "Lcom/tencent/ecommerce/base/ui/ECFloatGestureLayout;", "floatGestureLayout", "z0", "isFloatMode", "A0", "currentIsFloatMode", "B0", "floatMarginTop", "C0", "scrollerState", "Lcom/tencent/ecommerce/biz/detail/utils/c;", "D0", "Lcom/tencent/ecommerce/biz/detail/utils/c;", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REPORT_PARAMS, "Lcom/tencent/ecommerce/base/eventbus/EventObserver;", "Lzi0/a;", "E0", "Lcom/tencent/ecommerce/base/eventbus/EventObserver;", "observer", "<init>", "()V", "F0", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECShopProductDetailOffSaleFragment extends ECBaseFragment {

    /* renamed from: A0, reason: from kotlin metadata */
    private boolean currentIsFloatMode;

    /* renamed from: B0, reason: from kotlin metadata */
    private int floatMarginTop;

    /* renamed from: C0, reason: from kotlin metadata */
    private int scrollerState;

    /* renamed from: D0, reason: from kotlin metadata */
    private com.tencent.ecommerce.biz.detail.utils.c reportParams;

    /* renamed from: E0, reason: from kotlin metadata */
    private final EventObserver<ECForegroundEvent> observer;

    /* renamed from: P, reason: from kotlin metadata */
    private ECShopProductDetailOffSaleViewModel viewModel;

    /* renamed from: Q, reason: from kotlin metadata */
    private ECBaseRecyclerView detailPageRecyclerView;

    /* renamed from: R, reason: from kotlin metadata */
    private RelativeLayout titleBar;

    /* renamed from: S, reason: from kotlin metadata */
    private RelativeLayout titleBarPlaceHolder;

    /* renamed from: T, reason: from kotlin metadata */
    private LinearLayout detailPageRootLayout;

    /* renamed from: U, reason: from kotlin metadata */
    private com.tencent.ecommerce.biz.detail.ui.d ecBaseRecyclerViewAdapter;

    /* renamed from: V, reason: from kotlin metadata */
    private ImageView leftCloseButton;

    /* renamed from: W, reason: from kotlin metadata */
    private ImageView rightCloseButton;

    /* renamed from: X, reason: from kotlin metadata */
    private ECStateCenterView stateCenterView;

    /* renamed from: Y, reason: from kotlin metadata */
    private ECShopProductDetailInfo productDetailInfo;

    /* renamed from: Z, reason: from kotlin metadata */
    private int scrollY;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private int channel;

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    private boolean isProductFromWindow;

    /* renamed from: t0, reason: collision with root package name and from kotlin metadata */
    private int activeType;

    /* renamed from: v0, reason: collision with root package name and from kotlin metadata */
    private final Lazy lifecycleScope;

    /* renamed from: w0, reason: collision with root package name and from kotlin metadata */
    private com.tencent.ecommerce.biz.detail.utils.b detailPageDurationReport;

    /* renamed from: x0, reason: collision with root package name and from kotlin metadata */
    private ObjectAnimator animatorForAlpha;

    /* renamed from: y0, reason: collision with root package name and from kotlin metadata */
    private ECFloatGestureLayout floatGestureLayout;

    /* renamed from: z0, reason: collision with root package name and from kotlin metadata */
    private boolean isFloatMode;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private ECSchemeExtUserDataMap serializableMap = new ECSchemeExtUserDataMap(null, 1, null);

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    private String saasType = "";

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    private String saasProductId = "";

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    private String sellerId = "";

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    private String mediaProductID = "";

    /* renamed from: h0, reason: collision with root package name and from kotlin metadata */
    private String categoryName = "";

    /* renamed from: i0, reason: collision with root package name and from kotlin metadata */
    private String goodsType = "";

    /* renamed from: j0, reason: collision with root package name and from kotlin metadata */
    private String categoryId = "";

    /* renamed from: k0, reason: collision with root package name and from kotlin metadata */
    private String sealTransfer = "";

    /* renamed from: l0, reason: collision with root package name and from kotlin metadata */
    private String sourceFrom = String.valueOf(ECSourceFrom.SOURCE_FROM_UNKNOWN.ordinal());

    /* renamed from: m0, reason: collision with root package name and from kotlin metadata */
    private String roomId = "";

    /* renamed from: n0, reason: collision with root package name and from kotlin metadata */
    private String requestId = "";

    /* renamed from: o0, reason: collision with root package name and from kotlin metadata */
    private String bizType = "";

    /* renamed from: p0, reason: collision with root package name and from kotlin metadata */
    private String shopId = "";

    /* renamed from: q0, reason: collision with root package name and from kotlin metadata */
    private String spuId = "";

    /* renamed from: r0, reason: collision with root package name and from kotlin metadata */
    private String littleWorldFeedId = "";

    /* renamed from: s0, reason: collision with root package name and from kotlin metadata */
    private String activeId = "";

    /* renamed from: u0, reason: collision with root package name and from kotlin metadata */
    private int role = 1;

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0004H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/ecommerce/biz/detail/fragment/ECShopProductDetailOffSaleFragment$b", "Lcom/tencent/ecommerce/base/ui/c;", "", "isFromTop", "", "deltaY", "type", "", "onPageClose", "state", "onStateChange", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class b extends com.tencent.ecommerce.base.ui.c {
        b() {
        }

        @Override // com.tencent.ecommerce.base.ui.c, com.tencent.ecommerce.base.ui.ECFloatGestureLayout.FloatEventListener
        public void onPageClose(boolean isFromTop, int deltaY, int type) {
            FragmentActivity activity = ECShopProductDetailOffSaleFragment.this.getActivity();
            if (activity != null) {
                activity.finish();
            }
        }

        @Override // com.tencent.ecommerce.base.ui.c, com.tencent.ecommerce.base.ui.ECFloatGestureLayout.FloatEventListener
        public void onStateChange(int state) {
            IECVideoControlDelegate videoControl;
            IECVideoControlDelegate videoControl2;
            if (state == 6) {
                if (!TextUtils.isEmpty(ECShopProductDetailOffSaleFragment.this.littleWorldFeedId) && (videoControl2 = QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getVideoControl()) != null) {
                    videoControl2.sendVideoControlEvent(ECShopProductDetailOffSaleFragment.this.littleWorldFeedId, true);
                }
                ECShopProductDetailOffSaleFragment.this.ti(false);
                ECShopProductDetailOffSaleFragment.this.currentIsFloatMode = false;
                a.b("ECShopProductDetailPageFragment", "floatGestureLayout onStateChange GESTURE_STATE_DOING_AUTO_TOP");
                return;
            }
            if (state == 7) {
                if (!TextUtils.isEmpty(ECShopProductDetailOffSaleFragment.this.littleWorldFeedId) && (videoControl = QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getVideoControl()) != null) {
                    videoControl.sendVideoControlEvent(ECShopProductDetailOffSaleFragment.this.littleWorldFeedId, false);
                }
                ECShopProductDetailOffSaleFragment.this.ti(true);
                ECShopProductDetailOffSaleFragment.this.currentIsFloatMode = true;
                a.b("ECShopProductDetailPageFragment", "floatGestureLayout onStateChange GESTURE_STATE_DOING_AUTO_SUS");
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001R\u0014\u0010\u0005\u001a\u00020\u00028VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0006"}, d2 = {"com/tencent/ecommerce/biz/detail/fragment/ECShopProductDetailOffSaleFragment$c", "Lcom/tencent/ecommerce/base/ui/ECFloatGestureLayout$ContentScrollListener;", "", "getPositionState", "()I", "positionState", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class c implements ECFloatGestureLayout.ContentScrollListener {
        c() {
        }

        @Override // com.tencent.ecommerce.base.ui.ECFloatGestureLayout.ContentScrollListener
        public int getPositionState() {
            return ECShopProductDetailOffSaleFragment.this.scrollerState;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            FragmentActivity activity = ECShopProductDetailOffSaleFragment.this.getActivity();
            if (activity != null) {
                activity.onBackPressed();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class e implements View.OnClickListener {
        e() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            FragmentActivity activity = ECShopProductDetailOffSaleFragment.this.getActivity();
            if (activity != null) {
                activity.finish();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lzi0/a;", "event", "", "a", "(Lzi0/a;)V"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    static final class g<T> implements EventObserver<ECForegroundEvent> {
        g() {
        }

        @Override // com.tencent.ecommerce.base.eventbus.EventObserver
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onEvent(ECForegroundEvent eCForegroundEvent) {
            boolean z16 = eCForegroundEvent.isForeground;
            if (z16) {
                ECShopProductDetailOffSaleFragment eCShopProductDetailOffSaleFragment = ECShopProductDetailOffSaleFragment.this;
                eCShopProductDetailOffSaleFragment.detailPageDurationReport = new com.tencent.ecommerce.biz.detail.utils.b(eCShopProductDetailOffSaleFragment.sourceFrom);
                com.tencent.ecommerce.biz.detail.utils.b bVar = ECShopProductDetailOffSaleFragment.this.detailPageDurationReport;
                if (bVar != null) {
                    bVar.d();
                }
                ECShopProductDetailOffSaleFragment.this.ri();
                return;
            }
            if (z16) {
                return;
            }
            com.tencent.ecommerce.biz.detail.utils.b bVar2 = ECShopProductDetailOffSaleFragment.this.detailPageDurationReport;
            if (bVar2 != null) {
                com.tencent.ecommerce.biz.detail.utils.b.c(bVar2, null, 1, null);
            }
            com.tencent.ecommerce.biz.detail.utils.b bVar3 = ECShopProductDetailOffSaleFragment.this.detailPageDurationReport;
            if (bVar3 != null) {
                bVar3.f();
            }
            ECShopProductDetailOffSaleFragment.this.detailPageDurationReport = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u00042\u001a\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0001 \u0002*\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "Lcom/tencent/ecommerce/base/ui/b;", "kotlin.jvm.PlatformType", "it", "", "a", "(Ljava/util/List;)V"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class h<T> implements Observer<List<? extends ECBasePtsViewData>> {
        h() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(List<ECBasePtsViewData> list) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(list);
            if (ECShopProductDetailOffSaleFragment.Zh(ECShopProductDetailOffSaleFragment.this).l2(arrayList)) {
                ECShopProductDetailOffSaleFragment.Oh(ECShopProductDetailOffSaleFragment.this).addData(arrayList);
            } else {
                ECShopProductDetailOffSaleFragment.Oh(ECShopProductDetailOffSaleFragment.this).setData(arrayList);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/tencent/ecommerce/biz/detail/repo/shop/data/c;", "kotlin.jvm.PlatformType", "it", "", "a", "(Lcom/tencent/ecommerce/biz/detail/repo/shop/data/c;)V"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class i<T> implements Observer<ECShopProductDetailInfo> {
        i() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(ECShopProductDetailInfo eCShopProductDetailInfo) {
            ECShopProductDetailOffSaleFragment.this.productDetailInfo = eCShopProductDetailInfo;
            ECShopProductDetailOffSaleFragment.this.oi();
            com.tencent.ecommerce.biz.detail.utils.d.f102466a.f(ECShopProductDetailOffSaleFragment.this.reportParams, null, "qstore_prd_detail_pg_exp");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u00042&\u0010\u0003\u001a\"\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0001 \u0002*\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "", "kotlin.jvm.PlatformType", "it", "", "a", "(Ljava/util/Map;)V"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class k<T> implements Observer<Map<String, ? extends String>> {
        k() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(Map<String, String> map) {
            String str = map.get("QSTORE_PRD_DETAIL_EVENT_CODE");
            if (str != null) {
                com.tencent.ecommerce.biz.detail.utils.d.f102466a.f(ECShopProductDetailOffSaleFragment.this.reportParams, null, str);
            }
            a.b("ECShopProductDetailPageFragment", "viewModel productDetailLiveData eventName: " + str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u00042&\u0010\u0003\u001a\"\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0001 \u0002*\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "", "kotlin.jvm.PlatformType", "it", "", "a", "(Ljava/util/Map;)V"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class l<T> implements Observer<Map<String, ? extends String>> {
        l() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(Map<String, String> map) {
            com.tencent.ecommerce.biz.detail.utils.d.f102466a.f(ECShopProductDetailOffSaleFragment.this.reportParams, map, "qstore_prd_detail_pg_recommend_ck");
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/ecommerce/biz/detail/fragment/ECShopProductDetailOffSaleFragment$m", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "", "onAnimationEnd", "onAnimationStart", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class m extends AnimatorListenerAdapter {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f102174d;

        m(View view) {
            this.f102174d = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            super.onAnimationEnd(animation);
            this.f102174d.setLayerType(0, null);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animation) {
            super.onAnimationStart(animation);
        }
    }

    public ECShopProductDetailOffSaleFragment() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<CoroutineScope>() { // from class: com.tencent.ecommerce.biz.detail.fragment.ECShopProductDetailOffSaleFragment$lifecycleScope$2
            @Override // kotlin.jvm.functions.Function0
            public final CoroutineScope invoke() {
                return CoroutineScopeKt.MainScope();
            }
        });
        this.lifecycleScope = lazy;
        this.currentIsFloatMode = this.isFloatMode;
        this.observer = new g();
    }

    public static final /* synthetic */ ECBaseRecyclerView Nh(ECShopProductDetailOffSaleFragment eCShopProductDetailOffSaleFragment) {
        ECBaseRecyclerView eCBaseRecyclerView = eCShopProductDetailOffSaleFragment.detailPageRecyclerView;
        if (eCBaseRecyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("detailPageRecyclerView");
        }
        return eCBaseRecyclerView;
    }

    public static final /* synthetic */ com.tencent.ecommerce.biz.detail.ui.d Oh(ECShopProductDetailOffSaleFragment eCShopProductDetailOffSaleFragment) {
        com.tencent.ecommerce.biz.detail.ui.d dVar = eCShopProductDetailOffSaleFragment.ecBaseRecyclerViewAdapter;
        if (dVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ecBaseRecyclerViewAdapter");
        }
        return dVar;
    }

    public static final /* synthetic */ ECStateCenterView Yh(ECShopProductDetailOffSaleFragment eCShopProductDetailOffSaleFragment) {
        ECStateCenterView eCStateCenterView = eCShopProductDetailOffSaleFragment.stateCenterView;
        if (eCStateCenterView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stateCenterView");
        }
        return eCStateCenterView;
    }

    public static final /* synthetic */ ECShopProductDetailOffSaleViewModel Zh(ECShopProductDetailOffSaleFragment eCShopProductDetailOffSaleFragment) {
        ECShopProductDetailOffSaleViewModel eCShopProductDetailOffSaleViewModel = eCShopProductDetailOffSaleFragment.viewModel;
        if (eCShopProductDetailOffSaleViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return eCShopProductDetailOffSaleViewModel;
    }

    private final void initArguments() {
        Intent intent;
        String stringExtra;
        ECSchemeExtUserDataMap a16 = com.tencent.ecommerce.base.ktx.a.a(requireArguments(), "ext_userdata");
        this.serializableMap = a16;
        Map<Object, Object> extUserDataMap = a16.getExtUserDataMap();
        this.channel = Integer.parseInt(ki(WadlProxyConsts.CHANNEL, extUserDataMap, String.valueOf(QQECChannel.CHANNEL_UNKNOWN.ordinal())));
        this.saasType = li(this, "product_type", extUserDataMap, null, 4, null);
        this.saasProductId = li(this, "saas_product_id", extUserDataMap, null, 4, null);
        this.sellerId = li(this, "seller_id", extUserDataMap, null, 4, null);
        this.mediaProductID = li(this, "media_product_id", extUserDataMap, null, 4, null);
        this.isProductFromWindow = Intrinsics.areEqual(li(this, "role", extUserDataMap, null, 4, null), "2");
        this.categoryName = li(this, "category_name", extUserDataMap, null, 4, null);
        this.goodsType = li(this, "goods_type", extUserDataMap, null, 4, null);
        this.categoryId = li(this, PictureConst.KEY_CATEGORY_ID, extUserDataMap, null, 4, null);
        this.sealTransfer = li(this, QCircleLpReportDc05507.KEY_SEAL_TRANSFER, extUserDataMap, null, 4, null);
        this.sourceFrom = ki("source_from", extUserDataMap, String.valueOf(ECSourceFrom.SOURCE_FROM_UNKNOWN.ordinal()));
        this.requestId = li(this, "request_id", extUserDataMap, null, 4, null);
        this.bizType = li(this, "biz_type", extUserDataMap, null, 4, null);
        this.shopId = li(this, "shop_id", extUserDataMap, null, 4, null);
        this.spuId = li(this, "spu_id", extUserDataMap, null, 4, null);
        String str = "";
        this.roomId = ug0.b.f438933d.f().optString("qqlive_room_id", "");
        boolean areEqual = Intrinsics.areEqual(li(this, "half", extUserDataMap, null, 4, null), "1");
        this.isFloatMode = areEqual;
        this.currentIsFloatMode = areEqual;
        this.littleWorldFeedId = li(this, "little_world_feed_id", extUserDataMap, null, 4, null);
        FragmentActivity activity = getActivity();
        if (activity != null && (intent = activity.getIntent()) != null && (stringExtra = intent.getStringExtra("active_id")) != null) {
            str = stringExtra;
        }
        this.activeId = str;
        boolean areEqual2 = Intrinsics.areEqual(ki("is_from_ec_goods", extUserDataMap, "0"), "1");
        if (areEqual2) {
            this.sourceFrom = "1";
        }
        String valueOf = String.valueOf(extUserDataMap.get(LayoutAttrDefine.MARGIN_TOP));
        try {
            this.floatMarginTop = Integer.parseInt(valueOf);
        } catch (Exception e16) {
            a.a("ECShopProductDetailPageFragment", "initArguments", "parse floatMarginTop error, floatMarginTopString = " + valueOf + ", error = " + e16);
        }
        a.b("ECShopProductDetailPageFragment", "[initArguments] channel = " + this.channel + ", sellerId = " + this.sellerId + ", mediaProductID = " + this.mediaProductID + ", sourceFrom = " + this.sourceFrom + ", requestId = " + this.requestId + ", bizType = " + this.bizType + ", shopId = " + this.shopId + ",spuId = " + this.spuId + ", littleWorldFeedId = " + this.littleWorldFeedId + ", isFromGoods = " + areEqual2 + ", isProductFromWindow = " + this.isProductFromWindow);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CoroutineScope ji() {
        return (CoroutineScope) this.lifecycleScope.getValue();
    }

    private final String ki(String key, Map<Object, ? extends Object> map, String defaultValue) {
        Intent intent;
        FragmentActivity activity = getActivity();
        String stringExtra = (activity == null || (intent = activity.getIntent()) == null) ? null : intent.getStringExtra(key);
        if (stringExtra != null) {
            return stringExtra;
        }
        if (!map.containsKey(key) || !(map.get(key) instanceof String)) {
            return defaultValue;
        }
        Object obj = map.get(key);
        if (obj != null) {
            return (String) obj;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    }

    private final void mi() {
        IECVideoControlDelegate videoControl;
        if (this.isFloatMode) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("scroll_to_top", true);
            bundle.putBoolean("status_immersive", true);
            r rVar = r.f104881b;
            bundle.putInt(LayoutAttrDefine.MARGIN_TOP, rVar.a(getActivity()));
            bundle.putInt("scroll_margin_top", com.tencent.ecommerce.biz.util.e.c(90.0f) - rVar.a(getActivity()));
            bundle.putBoolean("need_reset_view_config", true);
            ECFloatGestureLayout eCFloatGestureLayout = new ECFloatGestureLayout(requireContext(), bundle);
            this.floatGestureLayout = eCFloatGestureLayout;
            eCFloatGestureLayout.setFloatEventListener(new b());
            ECFloatGestureLayout eCFloatGestureLayout2 = this.floatGestureLayout;
            if (eCFloatGestureLayout2 != null) {
                eCFloatGestureLayout2.setContentScrollListener(new c());
            }
            ECFloatGestureLayout eCFloatGestureLayout3 = this.floatGestureLayout;
            if (eCFloatGestureLayout3 != null) {
                eCFloatGestureLayout3.C(this, -1, -1);
            }
            ECFloatGestureLayout eCFloatGestureLayout4 = this.floatGestureLayout;
            if (eCFloatGestureLayout4 != null) {
                RelativeLayout relativeLayout = this.titleBarPlaceHolder;
                if (relativeLayout == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("titleBarPlaceHolder");
                }
                eCFloatGestureLayout4.z(relativeLayout, 1.0f);
            }
            if (!TextUtils.isEmpty(this.littleWorldFeedId) && (videoControl = QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getVideoControl()) != null) {
                videoControl.sendVideoControlEvent(this.littleWorldFeedId, false);
            }
            ECFloatGestureLayout eCFloatGestureLayout5 = this.floatGestureLayout;
            if (eCFloatGestureLayout5 != null) {
                eCFloatGestureLayout5.setAutoSuctionTop(false);
            }
        }
    }

    private final void ni() {
        ImageView imageView = this.leftCloseButton;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("leftCloseButton");
        }
        imageView.setOnClickListener(new d());
        ImageView imageView2 = this.rightCloseButton;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rightCloseButton");
        }
        imageView2.setOnClickListener(new e());
        ECBaseRecyclerView eCBaseRecyclerView = this.detailPageRecyclerView;
        if (eCBaseRecyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("detailPageRecyclerView");
        }
        eCBaseRecyclerView.addOnScrollListener(new f());
        ECStateCenterView eCStateCenterView = this.stateCenterView;
        if (eCStateCenterView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stateCenterView");
        }
        eCStateCenterView.setRetryListener(new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.detail.fragment.ECShopProductDetailOffSaleFragment$initListeners$4

            /* JADX INFO: Access modifiers changed from: package-private */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 1})
            @DebugMetadata(c = "com.tencent.ecommerce.biz.detail.fragment.ECShopProductDetailOffSaleFragment$initListeners$4$1", f = "ECShopProductDetailOffSaleFragment.kt", i = {}, l = {241}, m = "invokeSuspend", n = {}, s = {})
            /* renamed from: com.tencent.ecommerce.biz.detail.fragment.ECShopProductDetailOffSaleFragment$initListeners$4$1, reason: invalid class name */
            /* loaded from: classes31.dex */
            public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                int label;

                AnonymousClass1(Continuation continuation) {
                    super(2, continuation);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new AnonymousClass1(continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    Object coroutine_suspended;
                    String str;
                    String str2;
                    String str3;
                    coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i3 = this.label;
                    if (i3 == 0) {
                        ResultKt.throwOnFailure(obj);
                        JSONArray jSONArray = new JSONArray();
                        str = ECShopProductDetailOffSaleFragment.this.spuId;
                        jSONArray.mo162put(str);
                        JSONObject jSONObject = new JSONObject();
                        str2 = ECShopProductDetailOffSaleFragment.this.spuId;
                        jSONObject.put("spu_id", str2);
                        jSONObject.put("spu_ids", jSONArray);
                        str3 = ECShopProductDetailOffSaleFragment.this.activeId;
                        jSONObject.put("active_id", str3);
                        ECShopProductDetailOffSaleViewModel Zh = ECShopProductDetailOffSaleFragment.Zh(ECShopProductDetailOffSaleFragment.this);
                        this.label = 1;
                        if (Zh.A2(jSONObject, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else if (i3 == 1) {
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    return Unit.INSTANCE;
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
                CoroutineScope ji5;
                IStateCenterView.a.c(ECShopProductDetailOffSaleFragment.Yh(ECShopProductDetailOffSaleFragment.this), null, 1, null);
                Integer value = ECShopProductDetailOffSaleFragment.Zh(ECShopProductDetailOffSaleFragment.this).d2().getValue();
                if (value != null && value.intValue() == 2) {
                    ECShopProductDetailOffSaleFragment.this.qi();
                } else if (value != null && value.intValue() == 6) {
                    ji5 = ECShopProductDetailOffSaleFragment.this.ji();
                    BuildersKt__Builders_commonKt.launch$default(ji5, null, null, new AnonymousClass1(null), 3, null);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void oi() {
        ECShopProductDetailInfo eCShopProductDetailInfo = this.productDetailInfo;
        if (eCShopProductDetailInfo != null) {
            JSONObject optJSONObject = eCShopProductDetailInfo.infoData.optJSONObject("user_right");
            if (optJSONObject == null) {
                optJSONObject = new JSONObject();
            }
            this.role = optJSONObject.optInt("role_id", 1);
            if (!TextUtils.isEmpty(eCShopProductDetailInfo.infoData.optString("spu_id"))) {
                this.spuId = eCShopProductDetailInfo.infoData.optString("spu_id");
            }
            JSONObject optJSONObject2 = eCShopProductDetailInfo.infoData.optJSONObject("shop");
            if (optJSONObject2 == null) {
                optJSONObject2 = new JSONObject();
            }
            if (!TextUtils.isEmpty(optJSONObject2.optString("id"))) {
                this.shopId = optJSONObject2.optString("id");
            }
            JSONObject optJSONObject3 = eCShopProductDetailInfo.infoData.optJSONObject("product");
            if (optJSONObject3 == null) {
                optJSONObject3 = new JSONObject();
            }
            JSONObject optJSONObject4 = optJSONObject3.optJSONObject("category");
            if (optJSONObject4 == null) {
                optJSONObject4 = new JSONObject();
            }
            if (!TextUtils.isEmpty(optJSONObject4.optString("first_cat_id"))) {
                String optString = optJSONObject4.optString("first_cat_id");
                if (optString == null) {
                    optString = this.categoryId;
                }
                this.categoryId = optString;
            }
            JSONObject optJSONObject5 = eCShopProductDetailInfo.infoData.optJSONObject("active_info");
            if (optJSONObject5 == null) {
                optJSONObject5 = new JSONObject();
            }
            this.activeId = optJSONObject5.optString("active_id", "");
            this.activeType = optJSONObject5.optInt("active_type", 0);
        }
        ri();
        com.tencent.ecommerce.biz.detail.utils.c cVar = new com.tencent.ecommerce.biz.detail.utils.c();
        cVar.g(this.isFloatMode ? 1 : 2);
        cVar.q(this.sellerId);
        cVar.r(this.shopId);
        cVar.i(this.spuId);
        cVar.t(this.spuId);
        cVar.m(this.role);
        cVar.h(this.categoryId);
        cVar.s(this.sourceFrom);
        cVar.n(this.roomId);
        cVar.o(this.saasType);
        cVar.d(this.littleWorldFeedId);
        cVar.f(1);
        cVar.a(this.activeId);
        cVar.k("");
        cVar.b(this.activeType);
        cVar.l(this.requestId);
        cVar.p(this.sealTransfer);
        Unit unit = Unit.INSTANCE;
        this.reportParams = cVar;
        com.tencent.ecommerce.biz.detail.ui.d dVar = this.ecBaseRecyclerViewAdapter;
        if (dVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ecBaseRecyclerViewAdapter");
        }
        dVar.y0(this.reportParams);
    }

    private final void pi() {
        ECShopProductDetailOffSaleViewModel eCShopProductDetailOffSaleViewModel = this.viewModel;
        if (eCShopProductDetailOffSaleViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        eCShopProductDetailOffSaleViewModel.a2().observe(getViewLifecycleOwner(), new h());
        ECShopProductDetailOffSaleViewModel eCShopProductDetailOffSaleViewModel2 = this.viewModel;
        if (eCShopProductDetailOffSaleViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        eCShopProductDetailOffSaleViewModel2.i2().observe(getViewLifecycleOwner(), new Observer<Integer>() { // from class: com.tencent.ecommerce.biz.detail.fragment.ECShopProductDetailOffSaleFragment$registerLivedataObserver$2

            /* JADX INFO: Access modifiers changed from: package-private */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 1})
            @DebugMetadata(c = "com.tencent.ecommerce.biz.detail.fragment.ECShopProductDetailOffSaleFragment$registerLivedataObserver$2$1", f = "ECShopProductDetailOffSaleFragment.kt", i = {}, l = {313}, m = "invokeSuspend", n = {}, s = {})
            /* renamed from: com.tencent.ecommerce.biz.detail.fragment.ECShopProductDetailOffSaleFragment$registerLivedataObserver$2$1, reason: invalid class name */
            /* loaded from: classes31.dex */
            public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ JSONArray $spuIdList;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(JSONArray jSONArray, Continuation continuation) {
                    super(2, continuation);
                    this.$spuIdList = jSONArray;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new AnonymousClass1(this.$spuIdList, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    Object coroutine_suspended;
                    String str;
                    coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i3 = this.label;
                    if (i3 == 0) {
                        ResultKt.throwOnFailure(obj);
                        ECShopProductDetailOffSaleViewModel Zh = ECShopProductDetailOffSaleFragment.Zh(ECShopProductDetailOffSaleFragment.this);
                        JSONObject jSONObject = new JSONObject();
                        str = ECShopProductDetailOffSaleFragment.this.spuId;
                        jSONObject.put("spu_id", str);
                        jSONObject.put("spu_ids", this.$spuIdList);
                        jSONObject.put("is_first_screen_recommend", false);
                        Unit unit = Unit.INSTANCE;
                        this.label = 1;
                        if (Zh.A2(jSONObject, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else if (i3 == 1) {
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    return Unit.INSTANCE;
                }
            }

            @Override // androidx.lifecycle.Observer
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final void onChanged(Integer num) {
                String str;
                CoroutineScope ji5;
                ECShopProductDetailOffSaleFragment eCShopProductDetailOffSaleFragment = ECShopProductDetailOffSaleFragment.this;
                int i3 = 1;
                if (num == null || num.intValue() != 0) {
                    i3 = !ECShopProductDetailOffSaleFragment.Nh(ECShopProductDetailOffSaleFragment.this).canScrollVertically(1) ? 2 : 0;
                }
                eCShopProductDetailOffSaleFragment.scrollerState = i3;
                if (ECShopProductDetailOffSaleFragment.this.scrollerState == 2) {
                    JSONArray jSONArray = new JSONArray();
                    str = ECShopProductDetailOffSaleFragment.this.spuId;
                    jSONArray.mo162put(str);
                    ji5 = ECShopProductDetailOffSaleFragment.this.ji();
                    BuildersKt__Builders_commonKt.launch$default(ji5, null, null, new AnonymousClass1(jSONArray, null), 3, null);
                }
            }
        });
        ECShopProductDetailOffSaleViewModel eCShopProductDetailOffSaleViewModel3 = this.viewModel;
        if (eCShopProductDetailOffSaleViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        eCShopProductDetailOffSaleViewModel3.e2().observe(getViewLifecycleOwner(), new i());
        ECShopProductDetailOffSaleViewModel eCShopProductDetailOffSaleViewModel4 = this.viewModel;
        if (eCShopProductDetailOffSaleViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        eCShopProductDetailOffSaleViewModel4.d2().observe(getViewLifecycleOwner(), new j());
        ECShopProductDetailOffSaleViewModel eCShopProductDetailOffSaleViewModel5 = this.viewModel;
        if (eCShopProductDetailOffSaleViewModel5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        eCShopProductDetailOffSaleViewModel5.h2().observe(getViewLifecycleOwner(), new k());
        com.tencent.ecommerce.biz.detail.ui.d dVar = this.ecBaseRecyclerViewAdapter;
        if (dVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ecBaseRecyclerViewAdapter");
        }
        dVar.u0().observe(getViewLifecycleOwner(), new l());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void qi() {
        BuildersKt__Builders_commonKt.launch$default(ji(), null, null, new ECShopProductDetailOffSaleFragment$requestData$1(this, null), 3, null);
    }

    private final void si(boolean targetStateIsVisible, View targetView) {
        ObjectAnimator ofFloat;
        targetView.setClickable(targetStateIsVisible);
        targetView.setLayerType(2, null);
        if (targetStateIsVisible) {
            ofFloat = ObjectAnimator.ofFloat(targetView, (Property<View, Float>) View.ALPHA, 0.0f, 1.0f);
        } else {
            ofFloat = ObjectAnimator.ofFloat(targetView, (Property<View, Float>) View.ALPHA, 1.0f, 0.0f);
        }
        this.animatorForAlpha = ofFloat;
        if (ofFloat != null) {
            ofFloat.addListener(new m(targetView));
        }
        ObjectAnimator objectAnimator = this.animatorForAlpha;
        if (objectAnimator != null) {
            objectAnimator.setDuration(250L);
        }
        ObjectAnimator objectAnimator2 = this.animatorForAlpha;
        if (objectAnimator2 != null) {
            objectAnimator2.setInterpolator(new LinearInterpolator());
        }
        ObjectAnimator objectAnimator3 = this.animatorForAlpha;
        if (objectAnimator3 != null) {
            objectAnimator3.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ti(boolean targetStateIsFloatMode) {
        if (targetStateIsFloatMode == this.currentIsFloatMode) {
            return;
        }
        if (targetStateIsFloatMode) {
            ImageView imageView = this.leftCloseButton;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("leftCloseButton");
            }
            si(false, imageView);
            ImageView imageView2 = this.rightCloseButton;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("rightCloseButton");
            }
            si(true, imageView2);
            return;
        }
        ImageView imageView3 = this.leftCloseButton;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("leftCloseButton");
        }
        si(true, imageView3);
        ImageView imageView4 = this.rightCloseButton;
        if (imageView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rightCloseButton");
        }
        si(false, imageView4);
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment
    public boolean Eh() {
        return true;
    }

    @Override // com.tencent.ecommerce.base.fragment.api.IECBaseFragment
    /* renamed from: getBusinessDescription */
    public String getTAG() {
        return "ECShopProductDetailPageFragment";
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment
    public int getContentLayoutId() {
        return R.layout.cud;
    }

    public final void initViewModel() {
        this.viewModel = new ECShopProductDetailOffSaleViewModel(this.bizType, getChildFragmentManager(), this.isProductFromWindow, this.sellerId);
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, com.tencent.ecommerce.base.ui.api.IECFragmentApi
    public boolean onBackPressed() {
        if (!this.isFloatMode || this.scrollerState == 0) {
            return false;
        }
        ECFloatGestureLayout eCFloatGestureLayout = this.floatGestureLayout;
        if (eCFloatGestureLayout != null) {
            eCFloatGestureLayout.E();
        }
        return true;
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        IECVideoControlDelegate videoControl;
        super.onCreate(savedInstanceState);
        initArguments();
        initViewModel();
        this.detailPageDurationReport = new com.tencent.ecommerce.biz.detail.utils.b(this.sourceFrom);
        LifecycleEventBus.f100688b.d(ThreadMode.ORIGIN, ECForegroundEvent.class, this.observer);
        if (!this.isFloatMode || (videoControl = QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getVideoControl()) == null) {
            return;
        }
        videoControl.sendQCirclePanelStateEvent(this.littleWorldFeedId, true);
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        IECVideoControlDelegate videoControl;
        super.onDestroy();
        CoroutineScopeKt.cancel$default(ji(), null, 1, null);
        LifecycleEventBus.f100688b.e(this.observer);
        com.tencent.ecommerce.biz.detail.utils.b bVar = this.detailPageDurationReport;
        if (bVar != null) {
            bVar.b("qstore_prd_detail_pg_duration");
        }
        if (!this.isFloatMode || (videoControl = QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getVideoControl()) == null) {
            return;
        }
        videoControl.sendQCirclePanelStateEvent(this.littleWorldFeedId, false);
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        ECRMonitorManager.f100953c.b("STATE_SHOP_DETAIL_PAGE_GUEST");
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ECRMonitorManager.f100953c.c("STATE_SHOP_DETAIL_PAGE_GUEST");
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initUI(view);
        mi();
        ni();
        qi();
        pi();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ri() {
        com.tencent.ecommerce.biz.detail.utils.b bVar = this.detailPageDurationReport;
        if (bVar != null) {
            bVar.e(new ECDetailPageDuration(this.isFloatMode ? 1 : 2, this.shopId, this.spuId, this.roomId, String.valueOf(ug0.b.f438933d.e()), QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getAccountManager().getCurrentAccount(), this.sellerId, "", "0", this.saasType, this.saasProductId, "", this.categoryId, 0L, 0L, this.sourceFrom, this.littleWorldFeedId, this.sealTransfer, this.requestId, this.role));
        }
    }

    private final void initUI(View rootView) {
        ImageView imageView = (ImageView) rootView.findViewById(R.id.oa8);
        this.leftCloseButton = imageView;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("leftCloseButton");
        }
        imageView.setAlpha(0.0f);
        this.rightCloseButton = (ImageView) rootView.findViewById(R.id.oa9);
        this.detailPageRecyclerView = (ECBaseRecyclerView) rootView.findViewById(R.id.nve);
        RelativeLayout relativeLayout = (RelativeLayout) rootView.findViewById(R.id.nzm);
        this.titleBar = relativeLayout;
        if (relativeLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleBar");
        }
        relativeLayout.setClickable(true);
        this.titleBarPlaceHolder = (RelativeLayout) rootView.findViewById(R.id.oci);
        this.detailPageRootLayout = (LinearLayout) rootView.findViewById(R.id.o9i);
        this.stateCenterView = (ECStateCenterView) rootView.findViewById(R.id.oa7);
        ECShopProductDetailOffSaleViewModel eCShopProductDetailOffSaleViewModel = this.viewModel;
        if (eCShopProductDetailOffSaleViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        this.ecBaseRecyclerViewAdapter = new com.tencent.ecommerce.biz.detail.ui.d(requireContext(), eCShopProductDetailOffSaleViewModel);
        ECStateCenterView eCStateCenterView = this.stateCenterView;
        if (eCStateCenterView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stateCenterView");
        }
        IStateCenterView.a.c(eCStateCenterView, null, 1, null);
        ECBaseRecyclerView eCBaseRecyclerView = this.detailPageRecyclerView;
        if (eCBaseRecyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("detailPageRecyclerView");
        }
        eCBaseRecyclerView.setItemAnimator(null);
        eCBaseRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, 1));
        com.tencent.ecommerce.biz.detail.ui.d dVar = this.ecBaseRecyclerViewAdapter;
        if (dVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ecBaseRecyclerViewAdapter");
        }
        eCBaseRecyclerView.setAdapter(dVar);
        ECBaseRecyclerView eCBaseRecyclerView2 = this.detailPageRecyclerView;
        if (eCBaseRecyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("detailPageRecyclerView");
        }
        int c16 = com.tencent.ecommerce.biz.util.e.c(12.0f);
        int c17 = com.tencent.ecommerce.biz.util.e.c(16.0f);
        int c18 = com.tencent.ecommerce.biz.util.e.c(11.0f);
        com.tencent.ecommerce.biz.detail.ui.d dVar2 = this.ecBaseRecyclerViewAdapter;
        if (dVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ecBaseRecyclerViewAdapter");
        }
        eCBaseRecyclerView2.addItemDecoration(new ECShopDetailItemDecoration(c16, c17, c18, 2, dVar2));
        if (this.isFloatMode) {
            ((RelativeLayout) rootView.findViewById(R.id.nvf)).setFitsSystemWindows(false);
            ECBaseRecyclerView eCBaseRecyclerView3 = this.detailPageRecyclerView;
            if (eCBaseRecyclerView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("detailPageRecyclerView");
            }
            ECBaseRecyclerView eCBaseRecyclerView4 = this.detailPageRecyclerView;
            if (eCBaseRecyclerView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("detailPageRecyclerView");
            }
            int paddingLeft = eCBaseRecyclerView4.getPaddingLeft();
            ECBaseRecyclerView eCBaseRecyclerView5 = this.detailPageRecyclerView;
            if (eCBaseRecyclerView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("detailPageRecyclerView");
            }
            int paddingTop = eCBaseRecyclerView5.getPaddingTop();
            ECBaseRecyclerView eCBaseRecyclerView6 = this.detailPageRecyclerView;
            if (eCBaseRecyclerView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("detailPageRecyclerView");
            }
            eCBaseRecyclerView3.setPadding(paddingLeft, paddingTop, eCBaseRecyclerView6.getPaddingRight(), com.tencent.ecommerce.biz.util.e.c(0.0f));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "it", "", "a", "(Ljava/lang/Integer;)V"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class j<T> implements Observer<Integer> {
        j() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(Integer num) {
            if (num != null && num.intValue() == 2) {
                IStateCenterView.a.b(ECShopProductDetailOffSaleFragment.Yh(ECShopProductDetailOffSaleFragment.this), null, 1, null);
                return;
            }
            if (num != null && num.intValue() == 7) {
                ECShopProductDetailOffSaleFragment.Yh(ECShopProductDetailOffSaleFragment.this).setSucceededState();
                ECFloatGestureLayout eCFloatGestureLayout = ECShopProductDetailOffSaleFragment.this.floatGestureLayout;
                if (eCFloatGestureLayout != null) {
                    eCFloatGestureLayout.setAutoSuctionTop(true);
                    return;
                }
                return;
            }
            if (num != null && num.intValue() == 6) {
                IStateCenterView.a.b(ECShopProductDetailOffSaleFragment.Yh(ECShopProductDetailOffSaleFragment.this), null, 1, null);
            } else if (num != null && num.intValue() == 5) {
                IStateCenterView.a.a(ECShopProductDetailOffSaleFragment.Yh(ECShopProductDetailOffSaleFragment.this), ECShopProductDetailOffSaleFragment.this.requireContext().getString(R.string.wth), "qecommerce_skin_emptystate_img_wenjian", 0, 4, null);
            }
        }
    }

    static /* synthetic */ String li(ECShopProductDetailOffSaleFragment eCShopProductDetailOffSaleFragment, String str, Map map, String str2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            str2 = "";
        }
        return eCShopProductDetailOffSaleFragment.ki(str, map, str2);
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0018\u0010\n\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0004H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/ecommerce/biz/detail/fragment/ECShopProductDetailOffSaleFragment$f", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "dx", "dy", "", "onScrolled", "newState", "onScrollStateChanged", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class f extends RecyclerView.OnScrollListener {
        f() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int dx5, int dy5) {
            super.onScrolled(recyclerView, dx5, dy5);
            ECShopProductDetailOffSaleFragment.this.scrollY += dy5;
            ECShopProductDetailOffSaleFragment.Zh(ECShopProductDetailOffSaleFragment.this).o2(ECShopProductDetailOffSaleFragment.this.scrollY);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
        }
    }
}
