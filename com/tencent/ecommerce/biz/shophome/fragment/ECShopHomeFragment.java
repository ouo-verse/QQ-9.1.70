package com.tencent.ecommerce.biz.shophome.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import bj0.ECShopHomeRequest;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.ecommerce.base.QQEcommerceSdk;
import com.tencent.ecommerce.base.fragment.ECBaseFragment;
import com.tencent.ecommerce.base.report.service.ECShowPageCostTimeScene;
import com.tencent.ecommerce.base.share.api.ECActionItemClickListener;
import com.tencent.ecommerce.base.share.api.ECActionItemData;
import com.tencent.ecommerce.base.share.api.IECShareProxy;
import com.tencent.ecommerce.biz.shophome.fragment.ECShopHomeFragment;
import com.tencent.ecommerce.biz.shophome.model.ECShopRoleType;
import com.tencent.ecommerce.biz.shophome.model.ECShopTabInfo;
import com.tencent.ecommerce.biz.shophome.repo.ECShareActionInfo;
import com.tencent.ecommerce.biz.shophome.ui.component.ECShopInfoComponent;
import com.tencent.ecommerce.biz.shophome.ui.component.ECShopSearchBarComponent;
import com.tencent.ecommerce.biz.shophome.ui.component.ECShopTabBarComponent;
import com.tencent.ecommerce.biz.shophome.ui.component.ECShopViewPagerComponent;
import com.tencent.ecommerce.biz.shophome.ui.component.a;
import com.tencent.ecommerce.biz.shophome.ui.dialog.ECShopRoleForbidDialog;
import com.tencent.ecommerce.biz.shophome.ui.dialog.ECShopSimpleMessageDialog;
import com.tencent.ecommerce.biz.shophome.ui.view.ECNestedScrollingParent2Layout;
import com.tencent.ecommerce.biz.shophome.util.ECShopHomePageType;
import com.tencent.ecommerce.biz.shophome.util.ECShopHomeScene;
import com.tencent.ecommerce.biz.shophome.util.ECShopReportParams;
import com.tencent.ecommerce.biz.shophome.viewmodel.ECShopHomeViewModel;
import com.tencent.ecommerce.biz.shophome.viewmodel.a;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mini.out.webPlugins.MiniAppPlugin;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import common.config.service.QzoneConfig;
import cooperation.qzone.QzoneIPCModule;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00b4\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 o2\u00020\u0001:\u0001pB\u0007\u00a2\u0006\u0004\bm\u0010nJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u001a\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\"\u0010\u0012\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010\u0013\u001a\u00020\u0004H\u0016J\b\u0010\u0014\u001a\u00020\u0004H\u0016J\b\u0010\u0015\u001a\u00020\fH\u0002J\u0010\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\bH\u0002J\b\u0010\u0018\u001a\u00020\fH\u0002J\b\u0010\u0019\u001a\u00020\fH\u0002J\b\u0010\u001a\u001a\u00020\fH\u0002J\u0010\u0010\u001c\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u0006H\u0002J\b\u0010\u001d\u001a\u00020\fH\u0002J\b\u0010\u001f\u001a\u00020\u001eH\u0002J\u0010\u0010\"\u001a\u00020\f2\u0006\u0010!\u001a\u00020 H\u0002R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010,\u001a\u00020#8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b+\u0010%R\u0016\u0010.\u001a\u00020#8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b-\u0010%R\u0016\u00102\u001a\u00020/8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0016\u00106\u001a\u0002038\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0016\u0010:\u001a\u0002078\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010>\u001a\u00020;8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010B\u001a\u00020?8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010F\u001a\u00020C8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bD\u0010ER\u0016\u0010J\u001a\u00020G8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bH\u0010IR\u0016\u0010N\u001a\u00020K8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bL\u0010MR\u0016\u0010R\u001a\u00020O8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bP\u0010QR\u0016\u0010V\u001a\u00020S8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bT\u0010UR\u0016\u0010Y\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bW\u0010XR\u0016\u0010[\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bZ\u0010XR\u0016\u0010]\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\\\u0010XR\u0016\u0010_\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b^\u0010XR\u0016\u0010b\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b`\u0010aR\u0016\u0010d\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bc\u0010XR\u0014\u0010h\u001a\u00020e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bf\u0010gR\u0014\u0010l\u001a\u00020i8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bj\u0010k\u00a8\u0006q"}, d2 = {"Lcom/tencent/ecommerce/biz/shophome/fragment/ECShopHomeFragment;", "Lcom/tencent/ecommerce/base/fragment/ECBaseFragment;", "", "getBusinessDescription", "", "Eh", "", "getContentLayoutId", "Landroid/view/View;", "view", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", "Bh", "Dh", "initArguments", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "initUI", "ei", "initViewModel", "gi", "shareAction", "fi", "hi", "Landroid/widget/LinearLayout$LayoutParams;", "ci", "Lorg/json/JSONObject;", "shopInfo", "di", "Landroid/widget/LinearLayout;", "P", "Landroid/widget/LinearLayout;", "rootContainer", "Lcom/tencent/ecommerce/biz/shophome/ui/view/ECNestedScrollingParent2Layout;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/tencent/ecommerce/biz/shophome/ui/view/ECNestedScrollingParent2Layout;", "scrollView", BdhLogUtil.LogTag.Tag_Req, "bottomContainer", ExifInterface.LATITUDE_SOUTH, "loadingContainer", "Lcom/tencent/ecommerce/biz/shophome/ui/component/f;", "T", "Lcom/tencent/ecommerce/biz/shophome/ui/component/f;", "shopHomeLoadingComponent", "Lcom/tencent/ecommerce/biz/shophome/ui/component/a;", "U", "Lcom/tencent/ecommerce/biz/shophome/ui/component/a;", "shopHomeTypeAbnormalComponent", "Lcom/tencent/ecommerce/biz/shophome/ui/component/ECShopSearchBarComponent;", "V", "Lcom/tencent/ecommerce/biz/shophome/ui/component/ECShopSearchBarComponent;", "searchBarComponent", "Lcom/tencent/ecommerce/biz/shophome/ui/component/ECShopInfoComponent;", "W", "Lcom/tencent/ecommerce/biz/shophome/ui/component/ECShopInfoComponent;", "shopInfoComponent", "Lcom/tencent/ecommerce/biz/shophome/ui/component/b;", "X", "Lcom/tencent/ecommerce/biz/shophome/ui/component/b;", "shopAnnouncementComponent", "Lcom/tencent/ecommerce/biz/shophome/ui/component/d;", "Y", "Lcom/tencent/ecommerce/biz/shophome/ui/component/d;", "shopDistributionPromoteComponent", "Lcom/tencent/ecommerce/biz/shophome/ui/component/e;", "Z", "Lcom/tencent/ecommerce/biz/shophome/ui/component/e;", "shopDividerComponent", "Lcom/tencent/ecommerce/biz/shophome/ui/component/ECShopTabBarComponent;", "a0", "Lcom/tencent/ecommerce/biz/shophome/ui/component/ECShopTabBarComponent;", "tabBarComponent", "Lcom/tencent/ecommerce/biz/shophome/ui/component/ECShopViewPagerComponent;", "b0", "Lcom/tencent/ecommerce/biz/shophome/ui/component/ECShopViewPagerComponent;", "viewPagerComponent", "Lcom/tencent/ecommerce/biz/shophome/viewmodel/ECShopHomeViewModel;", "c0", "Lcom/tencent/ecommerce/biz/shophome/viewmodel/ECShopHomeViewModel;", "viewModel", "d0", "Ljava/lang/String;", "adClickId", "e0", "shopId", "f0", "isSelect", "g0", "isDistributor", "h0", "I", "source", "i0", "couponId", "Ljava/util/concurrent/atomic/AtomicBoolean;", "j0", "Ljava/util/concurrent/atomic/AtomicBoolean;", "hasLoaded", "Lcom/tencent/ecommerce/base/report/service/k;", "k0", "Lcom/tencent/ecommerce/base/report/service/k;", "showPageCostTime", "<init>", "()V", "l0", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECShopHomeFragment extends ECBaseFragment {

    /* renamed from: l0, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: P, reason: from kotlin metadata */
    private LinearLayout rootContainer;

    /* renamed from: Q, reason: from kotlin metadata */
    private ECNestedScrollingParent2Layout scrollView;

    /* renamed from: R, reason: from kotlin metadata */
    private LinearLayout bottomContainer;

    /* renamed from: S, reason: from kotlin metadata */
    private LinearLayout loadingContainer;

    /* renamed from: T, reason: from kotlin metadata */
    private com.tencent.ecommerce.biz.shophome.ui.component.f shopHomeLoadingComponent;

    /* renamed from: U, reason: from kotlin metadata */
    private a shopHomeTypeAbnormalComponent;

    /* renamed from: V, reason: from kotlin metadata */
    private ECShopSearchBarComponent searchBarComponent;

    /* renamed from: W, reason: from kotlin metadata */
    private ECShopInfoComponent shopInfoComponent;

    /* renamed from: X, reason: from kotlin metadata */
    private com.tencent.ecommerce.biz.shophome.ui.component.b shopAnnouncementComponent;

    /* renamed from: Y, reason: from kotlin metadata */
    private com.tencent.ecommerce.biz.shophome.ui.component.d shopDistributionPromoteComponent;

    /* renamed from: Z, reason: from kotlin metadata */
    private com.tencent.ecommerce.biz.shophome.ui.component.e shopDividerComponent;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private ECShopTabBarComponent tabBarComponent;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private ECShopViewPagerComponent viewPagerComponent;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    private ECShopHomeViewModel viewModel;

    /* renamed from: h0, reason: collision with root package name and from kotlin metadata */
    private int source;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    private String adClickId = "";

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    private String shopId = "";

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    private String isSelect = "0";

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    private String isDistributor = "0";

    /* renamed from: i0, reason: collision with root package name and from kotlin metadata */
    private String couponId = "";

    /* renamed from: j0, reason: collision with root package name and from kotlin metadata */
    private final AtomicBoolean hasLoaded = new AtomicBoolean(false);

    /* renamed from: k0, reason: collision with root package name and from kotlin metadata */
    private final com.tencent.ecommerce.base.report.service.k showPageCostTime = new com.tencent.ecommerce.base.report.service.k(ECShowPageCostTimeScene.SHOW_COST_TIME_SCENE_SHOP_HOME);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0018\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bR\u0014\u0010\u000b\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\fR\u0014\u0010\u000e\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\fR\u0014\u0010\u000f\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\fR\u0014\u0010\u0010\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\fR\u0014\u0010\u0011\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\fR\u0014\u0010\u0012\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\fR\u0014\u0010\u0013\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\fR\u0014\u0010\u0014\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\fR\u0014\u0010\u0015\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\fR\u0014\u0010\u0016\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\fR\u0014\u0010\u0017\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0018R\u0014\u0010\u001a\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0018R\u0014\u0010\u001b\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0018R\u0014\u0010\u001c\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u0018R\u0014\u0010\u001d\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\f\u00a8\u0006 "}, d2 = {"Lcom/tencent/ecommerce/biz/shophome/fragment/ECShopHomeFragment$a;", "", "", "isDistribution", "", "a", "isSelect", "c", "", "roleType", "b", "ARG_KEY_CHANNEL", "Ljava/lang/String;", "ARG_KEY_COUPON_ID", "ARG_KEY_IS_DISTRIBUTOR", "ARG_KEY_IS_SELECT", "ARG_KEY_PAGE_TYPE", "ARG_KEY_ROLE", "ARG_KEY_SCENE", "ARG_KEY_SHOP_ID", "ARG_KEY_SOURCE", "IS_DISTRIBUTION", "IS_SELECT_HOST", "MARGIN_TOP_OFFSET_SEARCH_BAR", "I", "MARGIN_TOP_OFFSET_SHOP_INFO_VIEW", "MARGIN_TOP_OFFSET_TYPE_ABNORMAL_VIEW", "REQUEST_CODE_SHARE_SHOP_TO_QQ", "REQUEST_CODE_SHARE_SHOP_TO_Q_ZONE", "TAG", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.biz.shophome.fragment.ECShopHomeFragment$a, reason: from kotlin metadata */
    /* loaded from: classes31.dex */
    public static final class Companion {
        Companion() {
        }

        public final boolean a(String isDistribution) {
            return Intrinsics.areEqual(isDistribution, "1");
        }

        public final boolean b(int roleType) {
            return roleType == ECShopRoleType.ROLE_TYPE_NORMAL_USER.ordinal();
        }

        public final boolean c(String isSelect) {
            return Intrinsics.areEqual(isSelect, "1");
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/ecommerce/biz/shophome/fragment/ECShopHomeFragment$b", "Lcom/tencent/ecommerce/biz/shophome/ui/component/ECShopSearchBarComponent$ClickListener;", "", "onShareBtnClick", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class b implements ECShopSearchBarComponent.ClickListener {
        b() {
        }

        @Override // com.tencent.ecommerce.biz.shophome.ui.component.ECShopSearchBarComponent.ClickListener
        public void onShareBtnClick() {
            ECShopHomeFragment.this.hi();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/ecommerce/biz/shophome/fragment/ECShopHomeFragment$c", "Lcom/tencent/ecommerce/biz/shophome/ui/component/ECShopTabBarComponent$ITabBarItemSelectedListener;", "Lcom/tencent/ecommerce/biz/shophome/model/d;", "tabInfo", "", "onTabBarItemSelected", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class c implements ECShopTabBarComponent.ITabBarItemSelectedListener {
        c() {
        }

        @Override // com.tencent.ecommerce.biz.shophome.ui.component.ECShopTabBarComponent.ITabBarItemSelectedListener
        public void onTabBarItemSelected(ECShopTabInfo tabInfo) {
            ECShopHomeFragment.Wh(ECShopHomeFragment.this).S2(tabInfo);
            com.tencent.ecommerce.biz.shophome.util.a aVar = com.tencent.ecommerce.biz.shophome.util.a.f104379a;
            ECShopReportParams c16 = aVar.c(ECShopHomeFragment.this.getArguments());
            aVar.v(c16.role, c16.shopId, c16.source, tabInfo.id);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/ecommerce/biz/shophome/fragment/ECShopHomeFragment$d", "Lcom/tencent/ecommerce/biz/shophome/ui/component/ECShopViewPagerComponent$IViewPagerChangeListener;", "", "position", "Lcom/tencent/ecommerce/biz/shophome/model/d;", "tabInfo", "", "onPageSelected", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class d implements ECShopViewPagerComponent.IViewPagerChangeListener {
        d() {
        }

        @Override // com.tencent.ecommerce.biz.shophome.ui.component.ECShopViewPagerComponent.IViewPagerChangeListener
        public void onPageSelected(int position, ECShopTabInfo tabInfo) {
            ECShopHomeFragment.Wh(ECShopHomeFragment.this).S2(tabInfo);
            com.tencent.ecommerce.biz.shophome.util.a aVar = com.tencent.ecommerce.biz.shophome.util.a.f104379a;
            ECShopReportParams c16 = aVar.c(ECShopHomeFragment.this.getArguments());
            aVar.v(c16.role, c16.shopId, c16.source, tabInfo.id);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/tencent/ecommerce/biz/shophome/model/d;", "kotlin.jvm.PlatformType", "it", "", "a", "(Lcom/tencent/ecommerce/biz/shophome/model/d;)V"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class e<T> implements Observer<ECShopTabInfo> {
        e() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(ECShopTabInfo eCShopTabInfo) {
            ECShopHomeFragment.Vh(ECShopHomeFragment.this).e(eCShopTabInfo);
            ECShopHomeFragment.Xh(ECShopHomeFragment.this).d(eCShopTabInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "it", "", "a", "(Ljava/lang/String;)V"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class f<T> implements Observer<String> {
        f() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(String str) {
            JSONObject b16 = com.tencent.ecommerce.base.ktx.e.b(new JSONObject(), str);
            b16.put("isHomePage", 1);
            ECShopHomeFragment.Uh(ECShopHomeFragment.this).m(b16.toString());
            ECShopHomeFragment.Qh(ECShopHomeFragment.this).h(b16.toString());
            if (ECShopHomeFragment.INSTANCE.a(ECShopHomeFragment.this.isDistributor)) {
                JSONObject optJSONObject = b16.optJSONObject(WinkDaTongReportConstant.ElementParamValue.XSJ_BANNER_TYPE_PROMOTE);
                if (optJSONObject == null) {
                    optJSONObject = new JSONObject();
                }
                if (optJSONObject.length() > 0) {
                    ECShopHomeFragment.Rh(ECShopHomeFragment.this).d(b16.toString());
                    ECShopHomeFragment.Rh(ECShopHomeFragment.this).setComponentViewVisibility(0);
                } else {
                    ECShopHomeFragment.Rh(ECShopHomeFragment.this).setComponentViewVisibility(8);
                }
            }
            if (!TextUtils.isEmpty(ECShopHomeFragment.this.couponId)) {
                JSONObject optJSONObject2 = b16.optJSONObject("msg_box");
                if (optJSONObject2 == null) {
                    optJSONObject2 = new JSONObject();
                }
                boolean optBoolean = optJSONObject2.optBoolean("display", false);
                if (optJSONObject2.length() > 0 && optBoolean) {
                    ECShopSimpleMessageDialog.f104365a.a(ECShopHomeFragment.this.requireContext(), optJSONObject2);
                }
            }
            ECShopHomeFragment.this.di(b16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lorg/json/JSONObject;", "kotlin.jvm.PlatformType", "it", "", "a", "(Lorg/json/JSONObject;)V"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class g<T> implements Observer<JSONObject> {
        g() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(JSONObject jSONObject) {
            int optInt = jSONObject.optInt("abnormal_type", 0);
            ECShopHomeFragment.Ph(ECShopHomeFragment.this).f(optInt);
            if (optInt == 1) {
                ECShopHomeFragment.Qh(ECShopHomeFragment.this).setComponentViewVisibility(8);
                ECShopHomeFragment.Vh(ECShopHomeFragment.this).setComponentViewVisibility(8);
                ECShopHomeFragment.Xh(ECShopHomeFragment.this).setComponentViewVisibility(8);
                ECShopHomeFragment.Sh(ECShopHomeFragment.this).a(jSONObject);
                ECShopHomeFragment.Sh(ECShopHomeFragment.this).setComponentViewVisibility(0);
                return;
            }
            ECShopHomeFragment.Qh(ECShopHomeFragment.this).setComponentViewVisibility(0);
            ECShopHomeFragment.Vh(ECShopHomeFragment.this).setComponentViewVisibility(0);
            ECShopHomeFragment.Xh(ECShopHomeFragment.this).setComponentViewVisibility(0);
            ECShopHomeFragment.Sh(ECShopHomeFragment.this).setComponentViewVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/tencent/ecommerce/biz/shophome/viewmodel/a$b;", "kotlin.jvm.PlatformType", "it", "", "a", "(Lcom/tencent/ecommerce/biz/shophome/viewmodel/a$b;)V"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class h<T> implements Observer<a.b> {
        h() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(a.b bVar) {
            if (Intrinsics.areEqual(bVar, a.b.c.f104428a)) {
                if (ECShopHomeFragment.this.hasLoaded.compareAndSet(false, true)) {
                    ECShopHomeFragment.Oh(ECShopHomeFragment.this).setVisibility(0);
                }
            } else if (Intrinsics.areEqual(bVar, a.b.d.f104429a)) {
                ECShopHomeFragment.Oh(ECShopHomeFragment.this).setVisibility(8);
            } else if (bVar instanceof a.b.EmptyState) {
                ECShopHomeFragment.Oh(ECShopHomeFragment.this).setVisibility(8);
            } else if (bVar instanceof a.b.ErrorState) {
                ECShopHomeFragment.Oh(ECShopHomeFragment.this).setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "it", "", "a", "(Ljava/lang/Boolean;)V"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class i<T> implements Observer<Boolean> {
        i() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(Boolean bool) {
            ECShopHomeFragment.Ph(ECShopHomeFragment.this).g(bool.booleanValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/tencent/ecommerce/biz/shophome/repo/a;", "kotlin.jvm.PlatformType", "it", "", "a", "(Lcom/tencent/ecommerce/biz/shophome/repo/a;)V"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class j<T> implements Observer<ECShareActionInfo> {
        j() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(ECShareActionInfo eCShareActionInfo) {
            if (eCShareActionInfo.shareInfo == null) {
                com.tencent.ecommerce.base.ui.i.e(com.tencent.ecommerce.base.ui.i.f101155b, R.string.wvp, null, 0, 6, null);
                return;
            }
            int i3 = eCShareActionInfo.shareAction;
            if (i3 != 2) {
                if (i3 == 3) {
                    aj0.a.f26146a.d(ECShopHomeFragment.this.requireActivity(), 1002, eCShareActionInfo.shareInfo);
                    return;
                }
                if (i3 == 9) {
                    aj0.a.f26146a.e(ECShopHomeFragment.this.requireActivity(), eCShareActionInfo.shareInfo, false);
                    ECShopHomeFragment.this.fi(9);
                    return;
                } else if (i3 == 10) {
                    aj0.a.f26146a.e(ECShopHomeFragment.this.requireActivity(), eCShareActionInfo.shareInfo, true);
                    ECShopHomeFragment.this.fi(10);
                    return;
                } else if (i3 != 72 && i3 != 73) {
                    cg0.a.a("ECShopHomeFragment", "initViewModel", "can not deal share action:" + eCShareActionInfo.shareAction);
                    return;
                }
            }
            aj0.a.f26146a.c(ECShopHomeFragment.this.requireActivity(), 1001, eCShareActionInfo);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/ecommerce/biz/shophome/fragment/ECShopHomeFragment$k", "Lcom/tencent/ecommerce/base/share/api/ECActionItemClickListener;", "", "action", "Lcom/tencent/ecommerce/base/share/api/b;", "data", "", "onItemClick", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class k implements ECActionItemClickListener {
        k() {
        }

        @Override // com.tencent.ecommerce.base.share.api.ECActionItemClickListener
        public void onItemClick(int action, ECActionItemData data) {
            ECShopHomeFragment.Wh(ECShopHomeFragment.this).L2(ECShopHomeFragment.this.shopId, action, data);
        }
    }

    public static final /* synthetic */ LinearLayout Oh(ECShopHomeFragment eCShopHomeFragment) {
        LinearLayout linearLayout = eCShopHomeFragment.loadingContainer;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingContainer");
        }
        return linearLayout;
    }

    public static final /* synthetic */ ECShopSearchBarComponent Ph(ECShopHomeFragment eCShopHomeFragment) {
        ECShopSearchBarComponent eCShopSearchBarComponent = eCShopHomeFragment.searchBarComponent;
        if (eCShopSearchBarComponent == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchBarComponent");
        }
        return eCShopSearchBarComponent;
    }

    public static final /* synthetic */ com.tencent.ecommerce.biz.shophome.ui.component.b Qh(ECShopHomeFragment eCShopHomeFragment) {
        com.tencent.ecommerce.biz.shophome.ui.component.b bVar = eCShopHomeFragment.shopAnnouncementComponent;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shopAnnouncementComponent");
        }
        return bVar;
    }

    public static final /* synthetic */ com.tencent.ecommerce.biz.shophome.ui.component.d Rh(ECShopHomeFragment eCShopHomeFragment) {
        com.tencent.ecommerce.biz.shophome.ui.component.d dVar = eCShopHomeFragment.shopDistributionPromoteComponent;
        if (dVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shopDistributionPromoteComponent");
        }
        return dVar;
    }

    public static final /* synthetic */ com.tencent.ecommerce.biz.shophome.ui.component.a Sh(ECShopHomeFragment eCShopHomeFragment) {
        com.tencent.ecommerce.biz.shophome.ui.component.a aVar = eCShopHomeFragment.shopHomeTypeAbnormalComponent;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shopHomeTypeAbnormalComponent");
        }
        return aVar;
    }

    public static final /* synthetic */ ECShopInfoComponent Uh(ECShopHomeFragment eCShopHomeFragment) {
        ECShopInfoComponent eCShopInfoComponent = eCShopHomeFragment.shopInfoComponent;
        if (eCShopInfoComponent == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shopInfoComponent");
        }
        return eCShopInfoComponent;
    }

    public static final /* synthetic */ ECShopTabBarComponent Vh(ECShopHomeFragment eCShopHomeFragment) {
        ECShopTabBarComponent eCShopTabBarComponent = eCShopHomeFragment.tabBarComponent;
        if (eCShopTabBarComponent == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabBarComponent");
        }
        return eCShopTabBarComponent;
    }

    public static final /* synthetic */ ECShopHomeViewModel Wh(ECShopHomeFragment eCShopHomeFragment) {
        ECShopHomeViewModel eCShopHomeViewModel = eCShopHomeFragment.viewModel;
        if (eCShopHomeViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return eCShopHomeViewModel;
    }

    public static final /* synthetic */ ECShopViewPagerComponent Xh(ECShopHomeFragment eCShopHomeFragment) {
        ECShopViewPagerComponent eCShopViewPagerComponent = eCShopHomeFragment.viewPagerComponent;
        if (eCShopViewPagerComponent == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPagerComponent");
        }
        return eCShopViewPagerComponent;
    }

    private final LinearLayout.LayoutParams ci() {
        int i3 = (int) (r0.heightPixels / requireContext().getResources().getDisplayMetrics().density);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = ((i3 - 36) - 104) - 77;
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void di(JSONObject shopInfo) {
        JSONObject optJSONObject = shopInfo.optJSONObject(WinkDaTongReportConstant.ElementParamValue.XSJ_BANNER_TYPE_PROMOTE);
        if (optJSONObject == null) {
            optJSONObject = new JSONObject();
        }
        JSONObject optJSONObject2 = shopInfo.optJSONObject("bulletin");
        if (optJSONObject2 == null) {
            optJSONObject2 = new JSONObject();
        }
        int a16 = ECNestedScrollingParent2Layout.INSTANCE.a();
        if (INSTANCE.a(this.isDistributor) && optJSONObject.length() > 0) {
            a16 += com.tencent.ecommerce.biz.shophome.ui.component.d.INSTANCE.a();
        }
        if (optJSONObject2.length() > 0) {
            a16 += com.tencent.ecommerce.biz.shophome.ui.component.b.INSTANCE.a();
        }
        ECNestedScrollingParent2Layout eCNestedScrollingParent2Layout = this.scrollView;
        if (eCNestedScrollingParent2Layout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scrollView");
        }
        eCNestedScrollingParent2Layout.b(a16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void fi(int shareAction) {
        com.tencent.ecommerce.biz.shophome.util.a aVar = com.tencent.ecommerce.biz.shophome.util.a.f104379a;
        ECShopReportParams c16 = aVar.c(getArguments());
        aVar.d(c16.role, c16.shopId, c16.source, shareAction);
    }

    private final void gi() {
        String str = this.shopId;
        Companion companion = INSTANCE;
        ECShopHomeRequest eCShopHomeRequest = new ECShopHomeRequest(str, companion.c(this.isSelect), companion.a(this.isDistributor), this.source, this.couponId);
        ECShopHomeViewModel eCShopHomeViewModel = this.viewModel;
        if (eCShopHomeViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        eCShopHomeViewModel.H2(eCShopHomeRequest, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void hi() {
        List<Integer> emptyList;
        List<Integer> b16 = aj0.a.f26146a.b();
        IECShareProxy shareProxy = QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getShareProxy();
        k kVar = new k();
        FragmentActivity requireActivity = requireActivity();
        String string = getResources().getString(R.string.wvo);
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        shareProxy.showShareActionSheet(requireActivity, string, b16, emptyList, kVar);
    }

    private final void initArguments() {
        String str;
        String str2;
        String str3;
        String str4;
        Intent intent;
        String stringExtra;
        String string;
        Intent intent2;
        Intent intent3;
        FragmentActivity activity = getActivity();
        String str5 = "";
        if (activity == null || (intent3 = activity.getIntent()) == null || (str = intent3.getStringExtra("qz_gdt")) == null) {
            str = "";
        }
        this.adClickId = str;
        FragmentActivity activity2 = getActivity();
        if (activity2 == null || (intent2 = activity2.getIntent()) == null || (str2 = intent2.getStringExtra("shop_id")) == null) {
            str2 = "";
        }
        this.shopId = str2;
        Bundle arguments = getArguments();
        String str6 = "0";
        if (arguments == null || (str3 = arguments.getString("is_select", "")) == null) {
            str3 = "0";
        }
        this.isSelect = str3;
        Bundle arguments2 = getArguments();
        if (arguments2 != null && (string = arguments2.getString("is_distributor", "")) != null) {
            str6 = string;
        }
        this.isDistributor = str6;
        Bundle arguments3 = getArguments();
        if (arguments3 == null || (str4 = arguments3.getString("coupon_id", "")) == null) {
            str4 = "";
        }
        this.couponId = str4;
        FragmentActivity activity3 = getActivity();
        if (activity3 != null && (intent = activity3.getIntent()) != null && (stringExtra = intent.getStringExtra("source")) != null) {
            str5 = stringExtra;
        }
        try {
            this.source = Integer.parseInt(str5);
        } catch (Exception e16) {
            cg0.a.a("ECShopHomeFragment", "initArguments", "parse param source error, source string = " + str5 + " error = " + e16);
        }
        Bundle arguments4 = getArguments();
        if (arguments4 != null) {
            arguments4.putInt("scene", ECShopHomeScene.SCENE_SHOP_HOME.ordinal());
        }
        Bundle arguments5 = getArguments();
        if (arguments5 != null) {
            arguments5.putInt(MiniAppPlugin.ATTR_PAGE_TYPE, ECShopHomePageType.PAGE_TYPE_ALL.ordinal());
        }
        Bundle arguments6 = getArguments();
        if (arguments6 != null) {
            arguments6.putString("qz_gdt", this.adClickId);
        }
    }

    private final void initViewModel() {
        ECShopHomeViewModel eCShopHomeViewModel = (ECShopHomeViewModel) new ViewModelProvider(requireActivity()).get(ECShopHomeViewModel.class);
        eCShopHomeViewModel.O2(this.showPageCostTime);
        Unit unit = Unit.INSTANCE;
        this.viewModel = eCShopHomeViewModel;
        if (eCShopHomeViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        eCShopHomeViewModel.w2(this.shopId);
        ECShopHomeViewModel eCShopHomeViewModel2 = this.viewModel;
        if (eCShopHomeViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        eCShopHomeViewModel2.s2(this.source);
        ECShopHomeViewModel eCShopHomeViewModel3 = this.viewModel;
        if (eCShopHomeViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        eCShopHomeViewModel3.F2().observe(getViewLifecycleOwner(), new e());
        ECShopHomeViewModel eCShopHomeViewModel4 = this.viewModel;
        if (eCShopHomeViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        eCShopHomeViewModel4.J2().observe(getViewLifecycleOwner(), new f());
        ECShopHomeViewModel eCShopHomeViewModel5 = this.viewModel;
        if (eCShopHomeViewModel5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        eCShopHomeViewModel5.a2().observe(getViewLifecycleOwner(), new g());
        ECShopHomeViewModel eCShopHomeViewModel6 = this.viewModel;
        if (eCShopHomeViewModel6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        eCShopHomeViewModel6.b2().observe(getViewLifecycleOwner(), new Observer<Integer>() { // from class: com.tencent.ecommerce.biz.shophome.fragment.ECShopHomeFragment$initViewModel$5
            @Override // androidx.lifecycle.Observer
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final void onChanged(Integer num) {
                String str;
                Bundle arguments = ECShopHomeFragment.this.getArguments();
                if (arguments != null) {
                    arguments.putString("role", String.valueOf(num.intValue()));
                }
                com.tencent.ecommerce.biz.shophome.util.a aVar = com.tencent.ecommerce.biz.shophome.util.a.f104379a;
                ECShopReportParams c16 = aVar.c(ECShopHomeFragment.this.getArguments());
                aVar.e(c16.role, c16.shopId, c16.source, c16.getRequestId(), ECShopHomeFragment.this.couponId);
                ECShopHomeFragment.Companion companion = ECShopHomeFragment.INSTANCE;
                str = ECShopHomeFragment.this.isSelect;
                if (companion.c(str) && companion.b(num.intValue())) {
                    new ECShopRoleForbidDialog().uh(ECShopHomeFragment.this.getChildFragmentManager(), new Function1<ECShopRoleForbidDialog.ECShopRoleForbidDialogResult, Unit>() { // from class: com.tencent.ecommerce.biz.shophome.fragment.ECShopHomeFragment$initViewModel$5.1
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(ECShopRoleForbidDialog.ECShopRoleForbidDialogResult eCShopRoleForbidDialogResult) {
                            invoke2(eCShopRoleForbidDialogResult);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(ECShopRoleForbidDialog.ECShopRoleForbidDialogResult eCShopRoleForbidDialogResult) {
                            if (Intrinsics.areEqual(eCShopRoleForbidDialogResult, ECShopRoleForbidDialog.ECShopRoleForbidDialogResult.Confirm.f104363d)) {
                                cg0.a.b("ECShopHomeFragment", "roleForbidDialog confirm");
                                ECShopHomeFragment.this.requireActivity().finish();
                            }
                        }
                    });
                }
            }
        });
        ECShopHomeViewModel eCShopHomeViewModel7 = this.viewModel;
        if (eCShopHomeViewModel7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        eCShopHomeViewModel7.getPageState().observe(getViewLifecycleOwner(), new h());
        ECShopHomeViewModel eCShopHomeViewModel8 = this.viewModel;
        if (eCShopHomeViewModel8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        eCShopHomeViewModel8.M2().observe(getViewLifecycleOwner(), new i());
        ECShopHomeViewModel eCShopHomeViewModel9 = this.viewModel;
        if (eCShopHomeViewModel9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        eCShopHomeViewModel9.K2().observe(getViewLifecycleOwner(), new j());
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment
    public boolean Bh() {
        return false;
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment
    public boolean Dh() {
        return true;
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment
    public boolean Eh() {
        return true;
    }

    @Override // com.tencent.ecommerce.base.fragment.api.IECBaseFragment
    /* renamed from: getBusinessDescription */
    public String getTAG() {
        return "ECShopHomeFragment";
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment
    public int getContentLayoutId() {
        return R.layout.cr8;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if ((requestCode == 1001 || requestCode == 1002) && resultCode == -1) {
            fi(requestCode == 1001 ? 2 : 3);
        }
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initArguments();
        initUI(yh());
        ei();
        initViewModel();
        gi();
    }

    private final void ei() {
        List listOf;
        String str;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new ECShopTabInfo[]{new ECShopTabInfo("1", "\u5546\u54c1"), new ECShopTabInfo("2", QzoneConfig.DefaultValue.DEFAULT_LABEL_TEXT)});
        this.searchBarComponent = new ECShopSearchBarComponent(requireActivity(), getArguments(), this.shopId, new b());
        LinearLayout linearLayout = this.rootContainer;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rootContainer");
        }
        ECShopSearchBarComponent eCShopSearchBarComponent = this.searchBarComponent;
        if (eCShopSearchBarComponent == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchBarComponent");
        }
        linearLayout.addView(eCShopSearchBarComponent.getComponentView(), 0);
        this.shopInfoComponent = new ECShopInfoComponent(requireActivity(), getArguments(), getChildFragmentManager(), this.shopId);
        LinearLayout linearLayout2 = this.bottomContainer;
        if (linearLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bottomContainer");
        }
        ECShopInfoComponent eCShopInfoComponent = this.shopInfoComponent;
        if (eCShopInfoComponent == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shopInfoComponent");
        }
        linearLayout2.addView(eCShopInfoComponent.getComponentView());
        this.shopAnnouncementComponent = new com.tencent.ecommerce.biz.shophome.ui.component.b(requireActivity());
        LinearLayout linearLayout3 = this.bottomContainer;
        if (linearLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bottomContainer");
        }
        com.tencent.ecommerce.biz.shophome.ui.component.b bVar = this.shopAnnouncementComponent;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shopAnnouncementComponent");
        }
        linearLayout3.addView(bVar.getComponentView());
        Companion companion = INSTANCE;
        if (companion.a(this.isDistributor)) {
            com.tencent.ecommerce.biz.shophome.ui.component.d dVar = new com.tencent.ecommerce.biz.shophome.ui.component.d(requireActivity());
            this.shopDistributionPromoteComponent = dVar;
            dVar.setComponentViewVisibility(8);
            LinearLayout linearLayout4 = this.bottomContainer;
            if (linearLayout4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bottomContainer");
            }
            com.tencent.ecommerce.biz.shophome.ui.component.d dVar2 = this.shopDistributionPromoteComponent;
            if (dVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("shopDistributionPromoteComponent");
            }
            linearLayout4.addView(dVar2.getComponentView());
        }
        this.shopDividerComponent = new com.tencent.ecommerce.biz.shophome.ui.component.e(requireActivity());
        LinearLayout linearLayout5 = this.bottomContainer;
        if (linearLayout5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bottomContainer");
        }
        com.tencent.ecommerce.biz.shophome.ui.component.e eVar = this.shopDividerComponent;
        if (eVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shopDividerComponent");
        }
        linearLayout5.addView(eVar.getComponentView());
        this.tabBarComponent = new ECShopTabBarComponent(requireContext(), listOf, new c());
        LinearLayout linearLayout6 = this.bottomContainer;
        if (linearLayout6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bottomContainer");
        }
        ECShopTabBarComponent eCShopTabBarComponent = this.tabBarComponent;
        if (eCShopTabBarComponent == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabBarComponent");
        }
        linearLayout6.addView(eCShopTabBarComponent.getComponentView());
        this.viewPagerComponent = new ECShopViewPagerComponent(getArguments(), requireContext(), requireActivity(), listOf, new d());
        LinearLayout linearLayout7 = this.bottomContainer;
        if (linearLayout7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bottomContainer");
        }
        ECShopViewPagerComponent eCShopViewPagerComponent = this.viewPagerComponent;
        if (eCShopViewPagerComponent == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPagerComponent");
        }
        linearLayout7.addView(eCShopViewPagerComponent.getComponentView());
        this.shopHomeTypeAbnormalComponent = new com.tencent.ecommerce.biz.shophome.ui.component.a(requireContext());
        LinearLayout linearLayout8 = this.bottomContainer;
        if (linearLayout8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bottomContainer");
        }
        com.tencent.ecommerce.biz.shophome.ui.component.a aVar = this.shopHomeTypeAbnormalComponent;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shopHomeTypeAbnormalComponent");
        }
        linearLayout8.addView(aVar.getComponentView(), ci());
        com.tencent.ecommerce.biz.shophome.ui.component.a aVar2 = this.shopHomeTypeAbnormalComponent;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shopHomeTypeAbnormalComponent");
        }
        aVar2.getComponentView().setVisibility(8);
        Context requireContext = requireContext();
        if (companion.c(this.isSelect)) {
            str = "qshop_skeleton_listpage";
        } else {
            str = "qshop_skeleton_mainpage";
        }
        this.shopHomeLoadingComponent = new com.tencent.ecommerce.biz.shophome.ui.component.f(requireContext, str, true);
        LinearLayout linearLayout9 = this.loadingContainer;
        if (linearLayout9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingContainer");
        }
        com.tencent.ecommerce.biz.shophome.ui.component.f fVar = this.shopHomeLoadingComponent;
        if (fVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shopHomeLoadingComponent");
        }
        linearLayout9.addView(fVar.getComponentView());
        di(new JSONObject());
    }

    private final void initUI(View rootView) {
        this.rootContainer = (LinearLayout) rootView.findViewById(R.id.o3_);
        this.scrollView = (ECNestedScrollingParent2Layout) rootView.findViewById(R.id.obs);
        LinearLayout linearLayout = this.rootContainer;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rootContainer");
        }
        this.bottomContainer = (LinearLayout) linearLayout.findViewById(R.id.o2t);
        this.loadingContainer = (LinearLayout) rootView.findViewById(R.id.o3a);
    }
}
