package com.tencent.sqshow.zootopia.recommend.characterV2.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ads.data.AdParam;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mini.servlet.MiniAppGetNativeAppInfoServlet;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.widget.tip.a;
import com.tencent.mobileqq.zootopia.FragmentSource;
import com.tencent.mobileqq.zootopia.Source;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zplan.api.IZPlanMMKVApi;
import com.tencent.mobileqq.zplan.api.IZplanCacheApi;
import com.tencent.mobileqq.zplan.api.ZplanCacheComponentType;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.qqmini.sdk.request.GetAdInfoRequest;
import com.tencent.sqshow.zootopia.avatar.mall.AvatarRoleTitleView;
import com.tencent.sqshow.zootopia.avatar.mall.k;
import com.tencent.sqshow.zootopia.avatar.mall.l;
import com.tencent.sqshow.zootopia.nativeui.view.common.AvatarPanelErrorView;
import com.tencent.sqshow.zootopia.operation.facead.report.ZootopiaFaceAdReport;
import com.tencent.sqshow.zootopia.recommend.characterV2.controller.ZPlanRoleControllerV2;
import com.tencent.sqshow.zootopia.recommend.main.tab.ZPlanTabContentUrl;
import com.tencent.sqshow.zootopia.recommend.main.tab.a;
import com.tencent.sqshow.zootopia.scene.component.PageDataType;
import com.tencent.sqshow.zootopia.utils.CommonExKt;
import com.tencent.sqshow.zootopia.utils.ah;
import com.tencent.state.report.SquareReportConst;
import com.tencent.util.LiuHaiUtils;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.zplan.zplantracing.ZPlanSpanFactory;
import id3.d;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import lb4.b;
import mqq.app.Constants;
import n74.ck;
import qv4.bk;
import qv4.z;
import t74.u;
import uk0.e;

@Metadata(d1 = {"\u0000\u00f0\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 \u0099\u00012\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u0007:\u0002\u009a\u0001B\u0011\u0012\u0006\u0010_\u001a\u00020Z\u00a2\u0006\u0006\b\u0097\u0001\u0010\u0098\u0001J\b\u0010\t\u001a\u00020\bH\u0002J\b\u0010\n\u001a\u00020\bH\u0002J\b\u0010\u000b\u001a\u00020\bH\u0002J\b\u0010\f\u001a\u00020\bH\u0002J\b\u0010\r\u001a\u00020\bH\u0002J\b\u0010\u000e\u001a\u00020\bH\u0002J\b\u0010\u000f\u001a\u00020\bH\u0002J\b\u0010\u0010\u001a\u00020\bH\u0002J\b\u0010\u0011\u001a\u00020\bH\u0002J\b\u0010\u0012\u001a\u00020\bH\u0002J\n\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0002J\b\u0010\u0016\u001a\u00020\u0015H\u0002J\b\u0010\u0018\u001a\u00020\u0017H\u0002J\u0012\u0010\u001b\u001a\u00020\b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0002J\u0010\u0010\u001e\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u001cH\u0002J\u001c\u0010\"\u001a\u00020\b2\b\b\u0002\u0010 \u001a\u00020\u001f2\b\b\u0002\u0010!\u001a\u00020\u001fH\u0002J\b\u0010#\u001a\u00020\u0017H\u0002J\u0012\u0010&\u001a\u00020\b2\b\u0010%\u001a\u0004\u0018\u00010$H\u0016J\u0010\u0010(\u001a\u00020\b2\u0006\u0010'\u001a\u00020\u0019H\u0016J\u0012\u0010)\u001a\u00020\b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016J$\u0010/\u001a\u00020.2\u0006\u0010+\u001a\u00020*2\b\u0010-\u001a\u0004\u0018\u00010,2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016J\u001a\u00101\u001a\u00020\b2\u0006\u00100\u001a\u00020.2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u00102\u001a\u00020\bH\u0016J\b\u00103\u001a\u00020\bH\u0016J\b\u00104\u001a\u00020\bH\u0016J\b\u00105\u001a\u00020\bH\u0016J\b\u00106\u001a\u00020\bH\u0016J\b\u00107\u001a\u00020\bH\u0016J\u0010\u00109\u001a\u00020\b2\u0006\u00108\u001a\u00020\u001fH\u0016J\u0010\u0010<\u001a\u00020\b2\u0006\u0010;\u001a\u00020:H\u0016J\u0018\u0010@\u001a\u00020\b2\u0006\u0010>\u001a\u00020=2\u0006\u0010?\u001a\u00020=H\u0016J \u0010F\u001a\u00020\b2\b\u0010B\u001a\u0004\u0018\u00010A2\u000e\u0010E\u001a\n\u0012\u0004\u0012\u00020D\u0018\u00010CJ\b\u0010G\u001a\u00020\bH\u0016J\b\u0010H\u001a\u00020\bH\u0016J\b\u0010I\u001a\u00020\u001fH\u0016J\u0006\u0010J\u001a\u00020=J\b\u0010L\u001a\u00020KH\u0016J\u0006\u0010M\u001a\u00020=J\u0010\u0010O\u001a\u00020\b2\u0006\u0010N\u001a\u00020\u0017H\u0016J\u0018\u0010Q\u001a\u00020\b2\u0006\u0010N\u001a\u00020\u00172\u0006\u0010P\u001a\u00020\u001fH\u0016J\u0010\u0010R\u001a\u00020\b2\u0006\u0010N\u001a\u00020\u0017H\u0016J\b\u0010S\u001a\u00020\bH\u0016J\b\u0010T\u001a\u00020\bH\u0016J\b\u0010U\u001a\u00020\bH\u0016J\b\u0010W\u001a\u00020VH\u0016J\u000e\u0010Y\u001a\u00020\b2\u0006\u0010X\u001a\u00020\u0017R\u001a\u0010_\u001a\u00020Z8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b[\u0010\\\u001a\u0004\b]\u0010^R\u0014\u0010c\u001a\u00020`8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\ba\u0010bR\u0018\u0010g\u001a\u0004\u0018\u00010d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\be\u0010fR\u0018\u0010j\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bh\u0010iR\u0018\u0010n\u001a\u0004\u0018\u00010k8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bl\u0010mR\u0018\u0010r\u001a\u0004\u0018\u00010o8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bp\u0010qR\u0018\u0010t\u001a\u0004\u0018\u00010k8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bs\u0010mR\u0018\u0010u\u001a\u0004\u0018\u00010k8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bb\u0010mR\u0018\u0010w\u001a\u0004\u0018\u00010k8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bv\u0010mR\u0014\u0010{\u001a\u00020x8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\by\u0010zR\u0014\u0010}\u001a\u00020x8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b|\u0010zR\u001f\u0010\u0083\u0001\u001a\u00020~8BX\u0082\u0084\u0002\u00a2\u0006\u000f\n\u0005\b\u007f\u0010\u0080\u0001\u001a\u0006\b\u0081\u0001\u0010\u0082\u0001R\u001c\u0010\u0087\u0001\u001a\u0005\u0018\u00010\u0084\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0085\u0001\u0010\u0086\u0001R!\u0010\u008c\u0001\u001a\u00030\u0088\u00018BX\u0082\u0084\u0002\u00a2\u0006\u0010\n\u0006\b\u0089\u0001\u0010\u0080\u0001\u001a\u0006\b\u008a\u0001\u0010\u008b\u0001R!\u0010\u0091\u0001\u001a\u00030\u008d\u00018DX\u0084\u0084\u0002\u00a2\u0006\u0010\n\u0006\b\u008e\u0001\u0010\u0080\u0001\u001a\u0006\b\u008f\u0001\u0010\u0090\u0001R!\u0010\u0094\u0001\u001a\u00030\u008d\u00018DX\u0084\u0084\u0002\u00a2\u0006\u0010\n\u0006\b\u0092\u0001\u0010\u0080\u0001\u001a\u0006\b\u0093\u0001\u0010\u0090\u0001R\u0018\u0010\u0096\u0001\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0095\u0001\u0010s\u00a8\u0006\u009b\u0001"}, d2 = {"Lcom/tencent/sqshow/zootopia/recommend/characterV2/fragment/ZPlanRoleFragmentV2;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "Llb4/b;", "Luk0/e;", "Lcom/tencent/sqshow/zootopia/scene/component/c;", "Lcom/tencent/sqshow/zootopia/avatar/mall/k;", "Lcom/tencent/sqshow/zootopia/operation/facead/c;", "Lcom/tencent/mobileqq/zootopia/api/b;", "", "Yh", "Rh", "Qh", "Kh", "Lh", "Nh", "Ph", "Oh", "Uh", "Xh", "Lcom/tencent/mobileqq/zootopia/FragmentSource;", "Dh", "Lcom/tencent/mobileqq/zootopia/Source;", "Ch", "", "Gh", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Bh", "Ln74/ck;", "binding", OcrConfig.CHINESE, "", "withoutBlend", "withDelay", "Vh", "Eh", "Landroid/content/Intent;", "intent", "onNewIntent", "outState", "onSaveInstanceState", "onCreate", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/view/View;", "onCreateView", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, DKHippyEvent.EVENT_STOP, "onDestroyView", "dh", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "hidden", "onHiddenChanged", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "", "type", "eventData", "onEvent", "Lqv4/bk;", "noModuleInfo", "", "Lcom/tencent/sqshow/zootopia/recommend/characterV2/data/a;", "bannerInfo", "Th", "o7", AdParam.PF, "onBackPressedEvent", "getSubSource", "Landroidx/fragment/app/Fragment;", "getFragment", "getPageId", "tabIndex", "f", "refreshDataWhenDoubleCLick", "Be", "ib", "ma", "I7", "yd", "Lcom/tencent/sqshow/zootopia/scene/component/PageDataType;", "getType", "visibility", "Zh", "Lcom/tencent/sqshow/zootopia/recommend/main/tab/e;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/sqshow/zootopia/recommend/main/tab/e;", com.tencent.bugly.common.constants.Constants.BASE_IN_PLUGIN_ID, "()Lcom/tencent/sqshow/zootopia/recommend/main/tab/e;", "tabContentUrl", "", "D", "J", "startTime", "Lcom/tencent/sqshow/zootopia/recommend/characterV2/controller/ZPlanRoleControllerV2;", "E", "Lcom/tencent/sqshow/zootopia/recommend/characterV2/controller/ZPlanRoleControllerV2;", "roleController", UserInfo.SEX_FEMALE, "Ln74/ck;", "rootViewBinding", "Landroid/widget/FrameLayout;", "G", "Landroid/widget/FrameLayout;", "avatarContainer", "Lcom/tencent/sqshow/zootopia/nativeui/view/common/AvatarPanelErrorView;", "H", "Lcom/tencent/sqshow/zootopia/nativeui/view/common/AvatarPanelErrorView;", "errorView", "I", "loadingContainer", "midContainer", "K", "mallContainer", "Ljava/util/concurrent/atomic/AtomicBoolean;", "L", "Ljava/util/concurrent/atomic/AtomicBoolean;", "hasLazyInt", "M", "hasDestroy", "Lnb4/a;", "N", "Lkotlin/Lazy;", "Jh", "()Lnb4/a;", "techReporter", "Lcom/tencent/zplan/zplantracing/b;", "P", "Lcom/tencent/zplan/zplantracing/b;", "zplanPortalSpan", "Lid3/d;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Fh", "()Lid3/d;", "reporter", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", BdhLogUtil.LogTag.Tag_Req, "Ih", "()Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", GetAdInfoRequest.SOURCE_FROM, ExifInterface.LATITUDE_SOUTH, "Hh", "sourceCurrent", "T", "realStatusBarHeight", "<init>", "(Lcom/tencent/sqshow/zootopia/recommend/main/tab/e;)V", "U", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZPlanRoleFragmentV2 extends QPublicBaseFragment implements lb4.b, e, com.tencent.sqshow.zootopia.scene.component.c, k, com.tencent.sqshow.zootopia.operation.facead.c, com.tencent.mobileqq.zootopia.api.b {

    /* renamed from: C, reason: from kotlin metadata */
    private final ZPlanTabContentUrl tabContentUrl;

    /* renamed from: D, reason: from kotlin metadata */
    private final long startTime;

    /* renamed from: E, reason: from kotlin metadata */
    private ZPlanRoleControllerV2 roleController;

    /* renamed from: F, reason: from kotlin metadata */
    private ck rootViewBinding;

    /* renamed from: G, reason: from kotlin metadata */
    private FrameLayout avatarContainer;

    /* renamed from: H, reason: from kotlin metadata */
    private AvatarPanelErrorView errorView;

    /* renamed from: I, reason: from kotlin metadata */
    private FrameLayout loadingContainer;

    /* renamed from: J, reason: from kotlin metadata */
    private FrameLayout midContainer;

    /* renamed from: K, reason: from kotlin metadata */
    private FrameLayout mallContainer;

    /* renamed from: L, reason: from kotlin metadata */
    private final AtomicBoolean hasLazyInt;

    /* renamed from: M, reason: from kotlin metadata */
    private final AtomicBoolean hasDestroy;

    /* renamed from: N, reason: from kotlin metadata */
    private final Lazy techReporter;

    /* renamed from: P, reason: from kotlin metadata */
    private com.tencent.zplan.zplantracing.b zplanPortalSpan;

    /* renamed from: Q, reason: from kotlin metadata */
    private final Lazy reporter;

    /* renamed from: R, reason: from kotlin metadata */
    private final Lazy sourceFrom;

    /* renamed from: S, reason: from kotlin metadata */
    private final Lazy sourceCurrent;

    /* renamed from: T, reason: from kotlin metadata */
    private int realStatusBarHeight;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/sqshow/zootopia/recommend/characterV2/fragment/ZPlanRoleFragmentV2$b", "Lcom/tencent/sqshow/zootopia/avatar/mall/l;", "Lcom/tencent/sqshow/zootopia/recommend/characterV2/data/a;", "bannerData", "", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements l {
        b() {
        }

        @Override // com.tencent.sqshow.zootopia.avatar.mall.l
        public void a(com.tencent.sqshow.zootopia.recommend.characterV2.data.a bannerData) {
            Intrinsics.checkNotNullParameter(bannerData, "bannerData");
            ZPlanRoleControllerV2 zPlanRoleControllerV2 = ZPlanRoleFragmentV2.this.roleController;
            if (zPlanRoleControllerV2 != null) {
                zPlanRoleControllerV2.t0(bannerData);
            }
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/sqshow/zootopia/recommend/characterV2/fragment/ZPlanRoleFragmentV2$c", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lqv4/z;", "result", "", "a", "", "error", "", "message", "onResultFailure", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class c implements com.tencent.mobileqq.zootopia.api.e<z> {
        c() {
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(z result) {
            Intrinsics.checkNotNullParameter(result, "result");
            QLog.i("portal_ZPlanRoleFragmentV2", 1, "requestRoleData  onResultSuccess");
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            QLog.i("portal_ZPlanRoleFragmentV2", 1, "requestRoleData onResultFailure");
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/sqshow/zootopia/recommend/characterV2/fragment/ZPlanRoleFragmentV2$d", "Lya4/a;", "", "w0", "U", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class d implements ya4.a {
        d() {
        }

        @Override // ya4.a
        public void U() {
            QLog.i("portal_ZPlanRoleFragmentV2", 1, "onLoadingHide, cost: " + (System.currentTimeMillis() - ZPlanRoleFragmentV2.this.startTime));
            ZPlanRoleFragmentV2.this.Jh().i();
        }

        @Override // ya4.a
        public void w0() {
            QLog.i("portal_ZPlanRoleFragmentV2", 1, "onLoadingShow");
        }
    }

    public ZPlanRoleFragmentV2(ZPlanTabContentUrl tabContentUrl) {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        Intrinsics.checkNotNullParameter(tabContentUrl, "tabContentUrl");
        this.tabContentUrl = tabContentUrl;
        this.startTime = System.currentTimeMillis();
        this.hasLazyInt = new AtomicBoolean(false);
        this.hasDestroy = new AtomicBoolean(false);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<nb4.a>() { // from class: com.tencent.sqshow.zootopia.recommend.characterV2.fragment.ZPlanRoleFragmentV2$techReporter$2
            @Override // kotlin.jvm.functions.Function0
            public final nb4.a invoke() {
                return new nb4.a();
            }
        });
        this.techReporter = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<id3.d>() { // from class: com.tencent.sqshow.zootopia.recommend.characterV2.fragment.ZPlanRoleFragmentV2$reporter$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final d invoke() {
                return new d(null, 1, null);
            }
        });
        this.reporter = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<ZootopiaSource>() { // from class: com.tencent.sqshow.zootopia.recommend.characterV2.fragment.ZPlanRoleFragmentV2$sourceFrom$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ZootopiaSource invoke() {
                FragmentSource Dh;
                ZootopiaSource from;
                Dh = ZPlanRoleFragmentV2.this.Dh();
                return (Dh == null || (from = Dh.getFrom()) == null) ? ZootopiaSource.INSTANCE.i() : from;
            }
        });
        this.sourceFrom = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<ZootopiaSource>() { // from class: com.tencent.sqshow.zootopia.recommend.characterV2.fragment.ZPlanRoleFragmentV2$sourceCurrent$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ZootopiaSource invoke() {
                Source Ch;
                ZootopiaSource.Companion companion = ZootopiaSource.INSTANCE;
                Ch = ZPlanRoleFragmentV2.this.Ch();
                return companion.c(Ch, ZPlanRoleFragmentV2.this.getSubSource(), ZPlanRoleFragmentV2.this.Ih());
            }
        });
        this.sourceCurrent = lazy4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Source Ch() {
        Source current;
        FragmentSource Dh = Dh();
        return (Dh == null || (current = Dh.getCurrent()) == null) ? Source.UnSet : current;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FragmentSource Dh() {
        Intent intent;
        ZootopiaSource.Companion companion = ZootopiaSource.INSTANCE;
        FragmentSource f16 = companion.f(getArguments());
        if (f16 != null) {
            return f16;
        }
        FragmentActivity activity = getActivity();
        return companion.f((activity == null || (intent = activity.getIntent()) == null) ? null : intent.getExtras());
    }

    private final int Eh() {
        int statusBarHeight;
        if (this.realStatusBarHeight <= 0) {
            LiuHaiUtils.initLiuHaiProperty(getActivity());
            if (LiuHaiUtils.isLiuHaiUseValid()) {
                statusBarHeight = LiuHaiUtils.getNotchInScreenHeight(getActivity());
            } else {
                statusBarHeight = ImmersiveUtils.getStatusBarHeight(getActivity());
            }
            this.realStatusBarHeight = statusBarHeight;
            QLog.i("portal_ZPlanRoleFragmentV2", 1, "getRealStatusBarHeight init = " + statusBarHeight);
        }
        return this.realStatusBarHeight;
    }

    private final id3.d Fh() {
        return (id3.d) this.reporter.getValue();
    }

    private final int Gh() {
        com.tencent.sqshow.zootopia.recommend.main.tab.a aVar;
        Context context = getContext();
        if (context == null || (aVar = (com.tencent.sqshow.zootopia.recommend.main.tab.a) CommonExKt.p(context, ZplanCacheComponentType.MAIN_TAB)) == null) {
            return -1;
        }
        return aVar.a(Ah());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final nb4.a Jh() {
        return (nb4.a) this.techReporter.getValue();
    }

    private final void Kh() {
        ZPlanRoleControllerV2 zPlanRoleControllerV2;
        if (this.avatarContainer == null) {
            QLog.e("portal_ZPlanRoleFragmentV2", 1, "initAvatarView error, avatarContainer is null");
            return;
        }
        FragmentActivity activity = getActivity();
        if (activity == null || activity.isFinishing() || (zPlanRoleControllerV2 = this.roleController) == null) {
            return;
        }
        FrameLayout frameLayout = this.avatarContainer;
        Intrinsics.checkNotNull(frameLayout);
        zPlanRoleControllerV2.P(activity, this, frameLayout);
    }

    private final void Lh() {
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        AvatarPanelErrorView avatarPanelErrorView = this.errorView;
        if (avatarPanelErrorView != null) {
            String string = activity.getResources().getString(R.string.xrf);
            Intrinsics.checkNotNullExpressionValue(string, "ctx.resources.getString(\u2026ui_shop_empty_fail_title)");
            avatarPanelErrorView.f(string);
        }
        AvatarPanelErrorView avatarPanelErrorView2 = this.errorView;
        if (avatarPanelErrorView2 != null) {
            String string2 = activity.getResources().getString(R.string.xre);
            Intrinsics.checkNotNullExpressionValue(string2, "ctx.resources.getString(\u2026eui_shop_empty_fail_desc)");
            avatarPanelErrorView2.b(string2);
        }
        AvatarPanelErrorView avatarPanelErrorView3 = this.errorView;
        if (avatarPanelErrorView3 != null) {
            String string3 = activity.getResources().getString(R.string.xrd);
            Intrinsics.checkNotNullExpressionValue(string3, "ctx.resources.getString(\u2026i_shop_empty_fail_button)");
            avatarPanelErrorView3.setRetryButton(string3, new View.OnClickListener() { // from class: com.tencent.sqshow.zootopia.recommend.characterV2.fragment.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ZPlanRoleFragmentV2.Mh(ZPlanRoleFragmentV2.this, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Mh(ZPlanRoleFragmentV2 this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Uh();
        ZPlanRoleControllerV2 zPlanRoleControllerV2 = this$0.roleController;
        if (zPlanRoleControllerV2 != null) {
            zPlanRoleControllerV2.p0();
        }
        ZPlanRoleControllerV2 zPlanRoleControllerV22 = this$0.roleController;
        if (zPlanRoleControllerV22 != null) {
            zPlanRoleControllerV22.r0();
        }
    }

    private final void Nh() {
        ZPlanRoleControllerV2 zPlanRoleControllerV2;
        if (this.loadingContainer == null) {
            QLog.e("portal_ZPlanRoleFragmentV2", 1, "initLoadingView error, loadingContainer is null");
            return;
        }
        FragmentActivity activity = getActivity();
        if (activity == null || activity.isFinishing() || (zPlanRoleControllerV2 = this.roleController) == null) {
            return;
        }
        FrameLayout frameLayout = this.loadingContainer;
        Intrinsics.checkNotNull(frameLayout);
        zPlanRoleControllerV2.Q(activity, this, frameLayout);
    }

    private final void Oh() {
        CommonExKt.j(new Function0<Unit>() { // from class: com.tencent.sqshow.zootopia.recommend.characterV2.fragment.ZPlanRoleFragmentV2$initMallComponent$1
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
                FrameLayout frameLayout;
                ZPlanRoleControllerV2 zPlanRoleControllerV2;
                FrameLayout frameLayout2;
                frameLayout = ZPlanRoleFragmentV2.this.mallContainer;
                if (frameLayout == null) {
                    QLog.e("portal_ZPlanRoleFragmentV2", 1, "initMallComponent error, mallContainer is null");
                    return;
                }
                FragmentActivity activity = ZPlanRoleFragmentV2.this.getActivity();
                if (activity == null || activity.isFinishing() || (zPlanRoleControllerV2 = ZPlanRoleFragmentV2.this.roleController) == null) {
                    return;
                }
                ZPlanRoleFragmentV2 zPlanRoleFragmentV2 = ZPlanRoleFragmentV2.this;
                frameLayout2 = zPlanRoleFragmentV2.mallContainer;
                Intrinsics.checkNotNull(frameLayout2);
                zPlanRoleControllerV2.R(activity, zPlanRoleFragmentV2, frameLayout2);
            }
        });
    }

    private final void Ph() {
        CommonExKt.j(new Function0<Unit>() { // from class: com.tencent.sqshow.zootopia.recommend.characterV2.fragment.ZPlanRoleFragmentV2$initMidComponent$1
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
                FrameLayout frameLayout;
                ZPlanRoleControllerV2 zPlanRoleControllerV2;
                FrameLayout frameLayout2;
                frameLayout = ZPlanRoleFragmentV2.this.midContainer;
                if (frameLayout == null) {
                    QLog.e("portal_ZPlanRoleFragmentV2", 1, "initMidComponent error, midContainer is null");
                    return;
                }
                FragmentActivity activity = ZPlanRoleFragmentV2.this.getActivity();
                if (activity == null || activity.isFinishing() || (zPlanRoleControllerV2 = ZPlanRoleFragmentV2.this.roleController) == null) {
                    return;
                }
                ZPlanRoleFragmentV2 zPlanRoleFragmentV2 = ZPlanRoleFragmentV2.this;
                frameLayout2 = zPlanRoleFragmentV2.midContainer;
                Intrinsics.checkNotNull(frameLayout2);
                zPlanRoleControllerV2.S(activity, zPlanRoleFragmentV2, frameLayout2);
            }
        });
    }

    private final void Qh() {
        AvatarRoleTitleView avatarRoleTitleView;
        AvatarRoleTitleView avatarRoleTitleView2;
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        float statusBarHeight = ImmersiveUtils.getStatusBarHeight(activity) + activity.getResources().getDimension(R.dimen.f122771);
        ck ckVar = this.rootViewBinding;
        ViewGroup.LayoutParams layoutParams = (ckVar == null || (avatarRoleTitleView2 = ckVar.f419031g) == null) ? null : avatarRoleTitleView2.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = -1;
        }
        if (layoutParams != null) {
            layoutParams.height = (int) statusBarHeight;
        }
        ck ckVar2 = this.rootViewBinding;
        AvatarRoleTitleView avatarRoleTitleView3 = ckVar2 != null ? ckVar2.f419031g : null;
        if (avatarRoleTitleView3 != null) {
            avatarRoleTitleView3.setLayoutParams(layoutParams);
        }
        ck ckVar3 = this.rootViewBinding;
        if (ckVar3 == null || (avatarRoleTitleView = ckVar3.f419031g) == null) {
            return;
        }
        avatarRoleTitleView.T0(new b());
    }

    private final void Rh() {
        QLog.i("portal_ZPlanRoleFragmentV2", 1, "lazyInitComponent hasDestroy:" + this.hasDestroy + ", hasLazyInt:" + this.hasLazyInt.get());
        if (this.hasDestroy.get() || !this.hasLazyInt.compareAndSet(false, true)) {
            return;
        }
        Oh();
        Ph();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Sh(ZPlanRoleFragmentV2 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ck ckVar = this$0.rootViewBinding;
        if (ckVar != null) {
            this$0.zh(ckVar);
        }
    }

    private final void Uh() {
        c cVar = new c();
        ZPlanRoleControllerV2 zPlanRoleControllerV2 = this.roleController;
        if (zPlanRoleControllerV2 != null) {
            zPlanRoleControllerV2.b(cVar);
        }
    }

    private final void Vh(boolean withoutBlend, boolean withDelay) {
        ZPlanRoleControllerV2 zPlanRoleControllerV2 = this.roleController;
        if (zPlanRoleControllerV2 != null) {
            zPlanRoleControllerV2.Ya("resetRotation", withoutBlend, withDelay);
        }
    }

    private final void Xh() {
        ZPlanRoleControllerV2 zPlanRoleControllerV2 = this.roleController;
        if (zPlanRoleControllerV2 != null) {
            zPlanRoleControllerV2.P0(new d());
        }
    }

    private final void Yh() {
        final String str = "zplan_portal_settings_tips_has_show";
        if (((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).getBoolean("zplan_portal_settings_tips_has_show", false)) {
            return;
        }
        CommonExKt.j(new Function0<Unit>() { // from class: com.tencent.sqshow.zootopia.recommend.characterV2.fragment.ZPlanRoleFragmentV2$showSettingV2TipsIfNeed$1

            @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/sqshow/zootopia/recommend/characterV2/fragment/ZPlanRoleFragmentV2$showSettingV2TipsIfNeed$1$a", "Lcom/tencent/mobileqq/widget/tip/a$b;", "", "onDismiss", "onShow", "Landroid/view/View;", "v", NodeProps.ON_CLICK, "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes34.dex */
            public static final class a implements a.b {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ String f372498a;

                a(String str) {
                    this.f372498a = str;
                }

                @Override // com.tencent.mobileqq.widget.tip.a.b
                public void onShow() {
                    ((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).setBoolean(this.f372498a, true);
                }

                @Override // com.tencent.mobileqq.widget.tip.a.b
                public void onClick(View v3) {
                    QLog.d("portal_ZPlanRoleFragmentV2", 1, NodeProps.ON_CLICK);
                }

                @Override // com.tencent.mobileqq.widget.tip.a.b
                public void onDismiss() {
                    QLog.d("portal_ZPlanRoleFragmentV2", 1, "onDismiss");
                }
            }

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
                ck ckVar;
                FrameLayout mRv;
                ckVar = ZPlanRoleFragmentV2.this.rootViewBinding;
                View findViewById = (ckVar == null || (mRv = ckVar.getMRv()) == null) ? null : mRv.findViewById(R.id.r2j);
                if (findViewById == null) {
                    return;
                }
                com.tencent.mobileqq.widget.tip.a.r(findViewById.getContext()).S(findViewById).k0(1).R(2).o0("\u4e2a\u4eba\u4e2d\u5fc3\u548c\u8bbe\u7f6e\u79fb\u52a8\u5230\u8fd9\u91cc\u5566").p0(Color.parseColor("#FFFFFF")).W(Color.parseColor("#B3000000")).j0(10.0f, 8.0f, 10.0f, 8.0f).b0(10000L).f(new a(str)).s0();
            }
        });
    }

    private final void zh(ck binding) {
        String str;
        FragmentActivity activity = getActivity();
        if (activity != null) {
            HashMap hashMap = new HashMap();
            hashMap.put(SquareReportConst.Key.KEY_EXTERNAL_ENTRANCE, ah.b(Hh()));
            if (QQTheme.isNowThemeIsNight()) {
                str = "1";
            } else {
                str = "0";
            }
            hashMap.put("zplan_page_model", str);
            id3.d Fh = Fh();
            FrameLayout mRv = binding.getMRv();
            Intrinsics.checkNotNullExpressionValue(mRv, "binding.root");
            Fh.j(activity, mRv, getPageId(), hashMap);
        }
    }

    public ZPlanTabContentUrl Ah() {
        return b.a.a(this);
    }

    @Override // com.tencent.sqshow.zootopia.recommend.main.tab.g
    public void Be(int tabIndex, boolean refreshDataWhenDoubleCLick) {
        int Gh = Gh();
        if (Gh != tabIndex) {
            QLog.e("portal_ZPlanRoleFragmentV2", 1, "onTabReSelected not current index, selfIndex:" + Gh + ", tabIndex:" + tabIndex);
            return;
        }
        ZPlanRoleControllerV2 zPlanRoleControllerV2 = this.roleController;
        if (zPlanRoleControllerV2 != null) {
            zPlanRoleControllerV2.R0(true);
        }
        Wh(this, false, false, 1, null);
        QLog.i("portal_ZPlanRoleFragmentV2", 1, "onTabReSelected tabIndex:" + tabIndex + ", " + refreshDataWhenDoubleCLick);
        if (refreshDataWhenDoubleCLick) {
            Uh();
        }
    }

    @Override // lb4.b
    /* renamed from: D1, reason: from getter */
    public ZPlanTabContentUrl getTabContentUrl() {
        return this.tabContentUrl;
    }

    protected final ZootopiaSource Hh() {
        return (ZootopiaSource) this.sourceCurrent.getValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final ZootopiaSource Ih() {
        return (ZootopiaSource) this.sourceFrom.getValue();
    }

    public final void Th(bk noModuleInfo, List<com.tencent.sqshow.zootopia.recommend.characterV2.data.a> bannerInfo) {
        AvatarRoleTitleView avatarRoleTitleView;
        ck ckVar = this.rootViewBinding;
        if (ckVar == null || (avatarRoleTitleView = ckVar.f419031g) == null) {
            return;
        }
        avatarRoleTitleView.S0(noModuleInfo, bannerInfo, Hh());
    }

    public final void Zh(int visibility) {
        ck ckVar = this.rootViewBinding;
        AvatarPanelErrorView avatarPanelErrorView = ckVar != null ? ckVar.f419028d : null;
        if (avatarPanelErrorView == null) {
            return;
        }
        avatarPanelErrorView.setVisibility(visibility);
    }

    @Override // lb4.b
    public void dh() {
        ZPlanRoleControllerV2 zPlanRoleControllerV2 = this.roleController;
        if (zPlanRoleControllerV2 != null) {
            zPlanRoleControllerV2.B0();
        }
    }

    @Override // com.tencent.sqshow.zootopia.recommend.main.tab.g
    public void f(int tabIndex) {
        int Gh = Gh();
        if (Gh != tabIndex) {
            QLog.e("portal_ZPlanRoleFragmentV2", 1, "onTabSelected not current index, selfIndex:" + Gh + ", tabIndex:" + tabIndex);
            return;
        }
        ZPlanRoleControllerV2 zPlanRoleControllerV2 = this.roleController;
        if (zPlanRoleControllerV2 != null) {
            zPlanRoleControllerV2.R0(true);
        }
        Wh(this, false, true, 1, null);
        QLog.i("portal_ZPlanRoleFragmentV2", 1, "onTabSelected tabIndex:" + tabIndex);
    }

    public final String getPageId() {
        return "pg_zplan_avatar_character";
    }

    public final String getSubSource() {
        return ZootopiaSource.SUB_SOURCE_ROLE_FRAGMENT;
    }

    @Override // com.tencent.sqshow.zootopia.scene.component.c
    public PageDataType getType() {
        return PageDataType.ROLE;
    }

    @Override // com.tencent.sqshow.zootopia.recommend.main.tab.g
    public void ib(int tabIndex) {
        if (Gh() != tabIndex) {
            return;
        }
        ZPlanRoleControllerV2 zPlanRoleControllerV2 = this.roleController;
        if (zPlanRoleControllerV2 != null) {
            zPlanRoleControllerV2.R0(false);
        }
        ZPlanRoleControllerV2 zPlanRoleControllerV22 = this.roleController;
        if (zPlanRoleControllerV22 != null) {
            zPlanRoleControllerV22.b0(false);
        }
        QLog.i("portal_ZPlanRoleFragmentV2", 1, "onTabUnSelected tabIndex:" + tabIndex);
    }

    @Override // com.tencent.sqshow.zootopia.operation.facead.c
    public void o7() {
        Yh();
    }

    @Override // com.tencent.mobileqq.zootopia.api.b
    public boolean onBackPressedEvent() {
        QLog.i("portal_ZPlanRoleFragmentV2", 1, "onBackPressedEvent - " + this);
        ZPlanRoleControllerV2 zPlanRoleControllerV2 = this.roleController;
        if (zPlanRoleControllerV2 != null && zPlanRoleControllerV2.s0()) {
            return true;
        }
        ZPlanRoleControllerV2 zPlanRoleControllerV22 = this.roleController;
        if (!(zPlanRoleControllerV22 != null && zPlanRoleControllerV22.T())) {
            return false;
        }
        QLog.i("portal_ZPlanRoleFragmentV2", 1, "onBackPressedEvent but bizInterruptActivityBackPressed");
        return true;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        FrameLayout mRv;
        AvatarRoleTitleView avatarRoleTitleView;
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        Context context = getContext();
        if (context == null) {
            return;
        }
        int Eh = Eh();
        u.Companion companion = u.INSTANCE;
        int c16 = companion.c(context);
        int b16 = companion.b(context) + Eh;
        ZPlanRoleControllerV2 zPlanRoleControllerV2 = this.roleController;
        if (zPlanRoleControllerV2 != null) {
            zPlanRoleControllerV2.u0(newConfig, c16, b16);
        }
        ck ckVar = this.rootViewBinding;
        if (ckVar != null && (avatarRoleTitleView = ckVar.f419031g) != null) {
            avatarRoleTitleView.K0();
        }
        ck ckVar2 = this.rootViewBinding;
        if (ckVar2 != null && (mRv = ckVar2.getMRv()) != null) {
            mRv.requestLayout();
        }
        QLog.i("portal_ZPlanRoleFragmentV2", 1, "onConfigurationChanged - " + this);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        Intent intent;
        Intent intent2;
        super.onCreate(savedInstanceState);
        QLog.i("portal_ZPlanRoleFragmentV2", 1, "onCreate - " + this + ", cost: " + (System.currentTimeMillis() - this.startTime));
        this.roleController = new ZPlanRoleControllerV2(this, Hh(), getArguments());
        com.tencent.zplan.zplantracing.b startRootSpan = ZPlanSpanFactory.INSTANCE.startRootSpan("portalLaunch");
        if (startRootSpan != null) {
            startRootSpan.e("mainSource", Hh().getMainSource().name());
            startRootSpan.e("subSource", Hh().getSubSource());
        } else {
            startRootSpan = null;
        }
        this.zplanPortalSpan = startRootSpan;
        ZPlanRoleControllerV2 zPlanRoleControllerV2 = this.roleController;
        if (zPlanRoleControllerV2 != null) {
            zPlanRoleControllerV2.v0();
        }
        ZPlanRoleControllerV2 zPlanRoleControllerV22 = this.roleController;
        if (zPlanRoleControllerV22 != null) {
            zPlanRoleControllerV22.E0();
        }
        FragmentActivity activity = getActivity();
        Integer valueOf = (activity == null || (intent2 = activity.getIntent()) == null) ? null : Integer.valueOf(intent2.getIntExtra(MiniAppGetNativeAppInfoServlet.KEY_NATIVE_APP_ID, 0));
        ZPlanRoleControllerV2 zPlanRoleControllerV23 = this.roleController;
        if (zPlanRoleControllerV23 != null) {
            com.tencent.zplan.zplantracing.b bVar = this.zplanPortalSpan;
            zPlanRoleControllerV23.W(bVar != null ? bVar.c() : null, valueOf);
        }
        ZPlanRoleControllerV2 zPlanRoleControllerV24 = this.roleController;
        Boolean valueOf2 = zPlanRoleControllerV24 != null ? Boolean.valueOf(zPlanRoleControllerV24.V0()) : null;
        ZPlanRoleControllerV2 zPlanRoleControllerV25 = this.roleController;
        if (zPlanRoleControllerV25 != null) {
            zPlanRoleControllerV25.O0(this);
        }
        ZPlanRoleControllerV2 zPlanRoleControllerV26 = this.roleController;
        if (zPlanRoleControllerV26 != null) {
            zPlanRoleControllerV26.X();
        }
        ZPlanRoleControllerV2 zPlanRoleControllerV27 = this.roleController;
        if (zPlanRoleControllerV27 != null) {
            zPlanRoleControllerV27.a0();
        }
        ZPlanRoleControllerV2 zPlanRoleControllerV28 = this.roleController;
        if (zPlanRoleControllerV28 != null) {
            zPlanRoleControllerV28.Z();
        }
        ZPlanRoleControllerV2 zPlanRoleControllerV29 = this.roleController;
        if (zPlanRoleControllerV29 != null) {
            zPlanRoleControllerV29.N(this);
        }
        FragmentActivity activity2 = getActivity();
        if (activity2 != null && (intent = activity2.getIntent()) != null) {
            Jh().e(intent, Ih());
        }
        ZootopiaFaceAdReport.f372190a.i(getArguments());
        Jh().j(Intrinsics.areEqual(valueOf2, Boolean.TRUE));
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        QLog.i("portal_ZPlanRoleFragmentV2", 1, "onCreateView - " + this);
        ck g16 = ck.g(inflater);
        this.rootViewBinding = g16;
        this.avatarContainer = g16 != null ? g16.f419026b : null;
        this.errorView = g16 != null ? g16.f419028d : null;
        this.loadingContainer = g16 != null ? g16.f419027c : null;
        this.midContainer = g16 != null ? g16.f419030f : null;
        this.mallContainer = g16 != null ? g16.f419029e : null;
        Qh();
        Kh();
        Lh();
        Nh();
        ck ckVar = this.rootViewBinding;
        Intrinsics.checkNotNull(ckVar);
        zh(ckVar);
        ck ckVar2 = this.rootViewBinding;
        Intrinsics.checkNotNull(ckVar2);
        FrameLayout mRv = ckVar2.getMRv();
        Intrinsics.checkNotNullExpressionValue(mRv, "rootViewBinding!!.root");
        return mRv;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        ZPlanRoleControllerV2 zPlanRoleControllerV2 = this.roleController;
        if (zPlanRoleControllerV2 != null) {
            zPlanRoleControllerV2.onDestroy();
        }
        Jh().f();
        QLog.i("portal_ZPlanRoleFragmentV2", 1, "onDestroy - " + this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        AvatarRoleTitleView avatarRoleTitleView;
        this.hasDestroy.set(true);
        ck ckVar = this.rootViewBinding;
        if (ckVar != null && (avatarRoleTitleView = ckVar.f419031g) != null) {
            avatarRoleTitleView.onDestroy();
        }
        ZPlanRoleControllerV2 zPlanRoleControllerV2 = this.roleController;
        if (zPlanRoleControllerV2 != null) {
            zPlanRoleControllerV2.w0();
        }
        Context context = getContext();
        if (context != null) {
            ((IZplanCacheApi) QRoute.api(IZplanCacheApi.class)).clearCache(context);
        }
        super.onDestroyView();
    }

    @Override // uk0.e
    public void onEvent(String type, String eventData) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(eventData, "eventData");
        if (Intrinsics.areEqual(type, "onFirstFrameRenderEnd")) {
            QLog.i("portal_ZPlanRoleFragmentV2", 1, "onFirstFrameRenderEnd cost: " + (System.currentTimeMillis() - this.startTime));
            Rh();
            Jh().h();
            Jh().g();
            com.tencent.zplan.zplantracing.b bVar = this.zplanPortalSpan;
            if (bVar != null) {
                bVar.b();
            }
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        ZPlanRoleControllerV2 zPlanRoleControllerV2 = this.roleController;
        if (zPlanRoleControllerV2 != null) {
            zPlanRoleControllerV2.y0(hidden);
        }
        if (hidden) {
            return;
        }
        Wh(this, false, true, 1, null);
        ck ckVar = this.rootViewBinding;
        VideoReport.traversePage(ckVar != null ? ckVar.getMRv() : null);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        ZPlanRoleControllerV2 zPlanRoleControllerV2 = this.roleController;
        if (zPlanRoleControllerV2 != null) {
            zPlanRoleControllerV2.z0(intent);
        }
        ZPlanRoleControllerV2 zPlanRoleControllerV22 = this.roleController;
        if (zPlanRoleControllerV22 != null) {
            zPlanRoleControllerV22.E0();
        }
        QLog.i("portal_ZPlanRoleFragmentV2", 1, "onNewIntent - " + this);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        ZPlanRoleControllerV2 zPlanRoleControllerV2 = this.roleController;
        if (zPlanRoleControllerV2 != null) {
            zPlanRoleControllerV2.A0();
        }
        QLog.i("portal_ZPlanRoleFragmentV2", 1, "onPause - " + this);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        AvatarRoleTitleView avatarRoleTitleView;
        super.onResume();
        if (ImmersiveUtils.couldSetStatusTextColor()) {
            ImmersiveUtils.setStatusTextColorNew(true, requireActivity().getWindow());
        }
        FragmentActivity activity = getActivity();
        QBaseActivity qBaseActivity = activity instanceof QBaseActivity ? (QBaseActivity) activity : null;
        if (qBaseActivity != null) {
            com.tencent.sqshow.zootopia.utils.a.a(qBaseActivity);
        }
        ZPlanRoleControllerV2 zPlanRoleControllerV2 = this.roleController;
        if (zPlanRoleControllerV2 != null) {
            zPlanRoleControllerV2.onResume();
        }
        ck ckVar = this.rootViewBinding;
        if (ckVar != null && (avatarRoleTitleView = ckVar.f419031g) != null) {
            avatarRoleTitleView.onResume();
        }
        ck ckVar2 = this.rootViewBinding;
        VideoReport.traversePage(ckVar2 != null ? ckVar2.getMRv() : null);
        QLog.i("portal_ZPlanRoleFragmentV2", 1, "onResume - " + this);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle outState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        super.onSaveInstanceState(outState);
        Bh(outState);
        Bh(outState.getBundle("androidx.lifecycle.BundlableSavedStateRegistry.key"));
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        ZPlanRoleControllerV2 zPlanRoleControllerV2 = this.roleController;
        if (zPlanRoleControllerV2 != null) {
            zPlanRoleControllerV2.onStop();
        }
        QLog.i("portal_ZPlanRoleFragmentV2", 1, "onStop - " + this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        FrameLayout mRv;
        ZPlanRoleControllerV2 zPlanRoleControllerV2;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        QLog.i("portal_ZPlanRoleFragmentV2", 1, "onViewCreated - " + this);
        Xh();
        Uh();
        ck ckVar = this.rootViewBinding;
        if (ckVar != null && (mRv = ckVar.getMRv()) != null && (zPlanRoleControllerV2 = this.roleController) != null) {
            zPlanRoleControllerV2.C0(mRv);
        }
        QLog.i("portal_ZPlanRoleFragmentV2", 1, "onViewCreated cost: " + (System.currentTimeMillis() - this.startTime));
    }

    @Override // com.tencent.sqshow.zootopia.operation.facead.c
    public void pf() {
        Yh();
    }

    @Override // com.tencent.sqshow.zootopia.scene.component.c
    public void yd() {
        Uh();
    }

    @Override // lb4.b
    public void z6() {
        b.a.c(this);
    }

    @Override // com.tencent.sqshow.zootopia.avatar.mall.k
    public void I7() {
        QLog.i("portal_ZPlanRoleFragmentV2", 1, "onExitNativeUI");
        CommonExKt.j(new ZPlanRoleFragmentV2$onExitNativeUI$1(this));
        ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.sqshow.zootopia.recommend.characterV2.fragment.a
            @Override // java.lang.Runnable
            public final void run() {
                ZPlanRoleFragmentV2.Sh(ZPlanRoleFragmentV2.this);
            }
        }, 1000L);
    }

    @Override // com.tencent.sqshow.zootopia.avatar.mall.k
    public void ma() {
        QLog.i("portal_ZPlanRoleFragmentV2", 1, "onEnterNativeUI");
        CommonExKt.j(new Function0<Unit>() { // from class: com.tencent.sqshow.zootopia.recommend.characterV2.fragment.ZPlanRoleFragmentV2$onEnterNativeUI$1
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
                ck ckVar;
                AvatarRoleTitleView avatarRoleTitleView;
                ckVar = ZPlanRoleFragmentV2.this.rootViewBinding;
                if (ckVar != null && (avatarRoleTitleView = ckVar.f419031g) != null) {
                    avatarRoleTitleView.hide();
                }
                Context context = ZPlanRoleFragmentV2.this.getContext();
                com.tencent.sqshow.zootopia.recommend.main.tab.a aVar = context != null ? (com.tencent.sqshow.zootopia.recommend.main.tab.a) CommonExKt.p(context, ZplanCacheComponentType.MAIN_TAB) : null;
                if (aVar != null) {
                    a.C9836a.a(aVar, false, null, 2, null);
                }
            }
        });
    }

    private final void Bh(Bundle savedInstanceState) {
        if (savedInstanceState == null) {
            return;
        }
        savedInstanceState.remove("android:fragments");
        savedInstanceState.remove("android:support:fragments");
    }

    static /* synthetic */ void Wh(ZPlanRoleFragmentV2 zPlanRoleFragmentV2, boolean z16, boolean z17, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = false;
        }
        if ((i3 & 2) != 0) {
            z17 = true;
        }
        zPlanRoleFragmentV2.Vh(z16, z17);
    }

    @Override // lb4.b
    public Fragment getFragment() {
        return this;
    }
}
