package com.tencent.ecommerce.biz.orders.sellerorders;

import ak0.ECSellerOrder;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.ecommerce.base.ktx.ImageViewKt;
import com.tencent.ecommerce.base.report.api.IECDtReport;
import com.tencent.ecommerce.base.rmonitor.service.ECRMonitorManager;
import com.tencent.ecommerce.base.ui.ECSkin;
import com.tencent.ecommerce.base.ui.api.ECToastIcon;
import com.tencent.ecommerce.base.ui.refreshview.RecycleViewScrollListener;
import com.tencent.ecommerce.biz.orders.common.orderListAdapter.ECSellerOrderAdapter;
import com.tencent.ecommerce.biz.orders.sellerorders.container.ECSellerOrderTab;
import com.tencent.ecommerce.biz.orders.sellerorders.orderfilter.FilterDialog;
import com.tencent.ecommerce.biz.orders.sellerorders.orderfilter.FilterDialogSelectedOption;
import com.tencent.ecommerce.biz.orders.sellerorders.orderfilter.SellerOrderFilterOption;
import com.tencent.ecommerce.biz.orders.sellerorders.orderfilter.b;
import com.tencent.ecommerce.biz.orders.sellerorders.orderfilter.f;
import com.tencent.ecommerce.biz.orders.sellerorders.orderfilter.g;
import com.tencent.ecommerce.biz.router.ECScheme;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.pts.core.PTSComposer;
import com.tencent.pts.ui.view.PTSContainerView;
import com.tencent.qmethod.pandoraex.monitor.ClipboardMonitor;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import cooperation.qzone.QzoneIPCModule;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 f2\u00020\u00012\u00020\u0002:\u0002ghB\u0007\u00a2\u0006\u0004\bd\u0010eJ\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\f\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\r\u001a\u00020\u0003H\u0016J\u001a\u0010\u0010\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\u0011\u001a\u00020\bH\u0016J\b\u0010\u0012\u001a\u00020\bH\u0016J\b\u0010\u0013\u001a\u00020\bH\u0016J\u0010\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0010\u0010\u0017\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0019\u001a\u00020\u0018H\u0016J\b\u0010\u001b\u001a\u00020\u001aH\u0016J\u0010\u0010\u001e\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u001cH\u0016J\u0010\u0010 \u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\u000eH\u0003J\u0010\u0010!\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\u000eH\u0002J\u0010\u0010#\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\u0018H\u0002J\b\u0010$\u001a\u00020\bH\u0002J\b\u0010%\u001a\u00020\bH\u0002J\b\u0010&\u001a\u00020\bH\u0002J\u0010\u0010(\u001a\u00020\b2\u0006\u0010'\u001a\u00020\u0003H\u0002J\b\u0010)\u001a\u00020\bH\u0002J\u0010\u0010*\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\u0018H\u0002R\u001b\u00100\u001a\u00020+8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0016\u00108\u001a\u0002058\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010<\u001a\u0002098\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010>\u001a\u0002018\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b=\u00103R\u0016\u0010B\u001a\u00020?8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010F\u001a\u00020C8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bD\u0010ER\u0016\u0010H\u001a\u0002018\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bG\u00103R\u0016\u0010J\u001a\u0002018\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bI\u00103R\u0016\u0010L\u001a\u0002018\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bK\u00103R\u0016\u0010N\u001a\u0002098\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bM\u0010;R\u001c\u0010R\u001a\b\u0012\u0004\u0012\u0002010O8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bP\u0010QR\u0016\u0010U\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bS\u0010TR\u0018\u0010Y\u001a\u0004\u0018\u00010V8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bW\u0010XR\u0018\u0010]\u001a\u0004\u0018\u00010Z8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b[\u0010\\R\u001a\u0010c\u001a\u00020^8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b_\u0010`\u001a\u0004\ba\u0010b\u00a8\u0006i"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/sellerorders/ECSellerOrderFragment;", "Lcom/tencent/ecommerce/biz/orders/sellerorders/ECAbsSellerOrderFragment;", "Landroid/view/View$OnClickListener;", "", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "", "onActivityResult", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "getContentLayoutId", "Landroid/view/View;", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Landroid/content/Context;", "context", "Nh", NodeProps.ON_CLICK, "", "getBusinessDescription", "", "Eh", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "initView", "Zh", "queryText", "ei", "bi", "initViewModel", "ai", "selectedIndex", "di", "ci", "fi", "Lcom/tencent/ecommerce/biz/orders/sellerorders/ECSellerOrderViewModel;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lkotlin/Lazy;", "Yh", "()Lcom/tencent/ecommerce/biz/orders/sellerorders/ECSellerOrderViewModel;", "sellerOrderViewModel", "Landroid/widget/TextView;", BdhLogUtil.LogTag.Tag_Req, "Landroid/widget/TextView;", "filterOptionTextView", "Landroid/widget/FrameLayout;", ExifInterface.LATITUDE_SOUTH, "Landroid/widget/FrameLayout;", "searchBar", "Landroid/widget/LinearLayout;", "T", "Landroid/widget/LinearLayout;", "searchHintLayout", "U", "searchTextView", "Lcom/tencent/ecommerce/biz/orders/common/orderListAdapter/ECSellerOrderAdapter;", "V", "Lcom/tencent/ecommerce/biz/orders/common/orderListAdapter/ECSellerOrderAdapter;", "sellerOrderAdapter", "Landroidx/recyclerview/widget/RecyclerView;", "W", "Landroidx/recyclerview/widget/RecyclerView;", "sellerOrderListView", "X", "filterAllText", "Y", "filterUnSettledText", "Z", "filterSettledText", "a0", "baseViewForEmptyList", "", "b0", "Ljava/util/List;", "filterSettlementStateBtnList", "c0", "Ljava/lang/String;", "mediaId", "Landroid/widget/PopupWindow;", "d0", "Landroid/widget/PopupWindow;", "hintPopup", "Lcom/tencent/ecommerce/biz/orders/sellerorders/orderfilter/FilterDialog;", "e0", "Lcom/tencent/ecommerce/biz/orders/sellerorders/orderfilter/FilterDialog;", "filterDialog", "Lcom/tencent/ecommerce/biz/orders/sellerorders/container/ECSellerOrderTab;", "f0", "Lcom/tencent/ecommerce/biz/orders/sellerorders/container/ECSellerOrderTab;", "Mh", "()Lcom/tencent/ecommerce/biz/orders/sellerorders/container/ECSellerOrderTab;", "tabType", "<init>", "()V", "g0", "a", "b", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECSellerOrderFragment extends ECAbsSellerOrderFragment implements View.OnClickListener {

    /* renamed from: Q, reason: from kotlin metadata */
    private final Lazy sellerOrderViewModel;

    /* renamed from: R, reason: from kotlin metadata */
    private TextView filterOptionTextView;

    /* renamed from: S, reason: from kotlin metadata */
    private FrameLayout searchBar;

    /* renamed from: T, reason: from kotlin metadata */
    private LinearLayout searchHintLayout;

    /* renamed from: U, reason: from kotlin metadata */
    private TextView searchTextView;

    /* renamed from: V, reason: from kotlin metadata */
    private ECSellerOrderAdapter sellerOrderAdapter;

    /* renamed from: W, reason: from kotlin metadata */
    private RecyclerView sellerOrderListView;

    /* renamed from: X, reason: from kotlin metadata */
    private TextView filterAllText;

    /* renamed from: Y, reason: from kotlin metadata */
    private TextView filterUnSettledText;

    /* renamed from: Z, reason: from kotlin metadata */
    private TextView filterSettledText;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private LinearLayout baseViewForEmptyList;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private List<? extends TextView> filterSettlementStateBtnList;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    private String mediaId;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    private PopupWindow hintPopup;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    private FilterDialog filterDialog;

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    private final ECSellerOrderTab tabType;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J<\u0010\r\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/sellerorders/ECSellerOrderFragment$b;", "Lcom/tencent/ecommerce/base/ui/e;", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ORDER_ID, "", "a", IECDtReport.ACTION_IDENTIFIER, "Ljava/util/HashMap;", "dataMap", "Landroid/view/View;", "view", "Lcom/tencent/pts/core/PTSComposer;", "ptsComposer", "onTapEventTriggered", "<init>", "(Lcom/tencent/ecommerce/biz/orders/sellerorders/ECSellerOrderFragment;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public final class b extends com.tencent.ecommerce.base.ui.e {
        public b() {
        }

        private final void a(String orderId) {
            Object systemService = ECSellerOrderFragment.this.requireContext().getSystemService("clipboard");
            if (!(systemService instanceof ClipboardManager)) {
                systemService = null;
            }
            ClipboardManager clipboardManager = (ClipboardManager) systemService;
            ClipData newPlainText = ClipData.newPlainText(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ORDER_ID, orderId);
            if (clipboardManager != null) {
                ClipboardMonitor.setPrimaryClip(clipboardManager, newPlainText);
                com.tencent.ecommerce.base.ui.i.f101155b.d(ECSellerOrderFragment.this.getString(R.string.wu5), ECToastIcon.ICON_SUCCESS, 0);
            }
        }

        @Override // com.tencent.pts.core.lite.IPTSLiteEventListener
        public void onTapEventTriggered(String identifier, HashMap<String, String> dataMap, View view, PTSComposer ptsComposer) {
            String str;
            View childAt;
            String str2;
            String str3;
            String str4;
            cg0.a.b("ECSellerOrderFragment", "onTapEventTriggered, dataMap=" + dataMap);
            if (dataMap == null || (str = dataMap.get("eventType")) == null) {
                return;
            }
            switch (str.hashCode()) {
                case -1980859303:
                    if (str.equals("onTapIndirectHint")) {
                        if (!(view instanceof PTSContainerView)) {
                            view = null;
                        }
                        PTSContainerView pTSContainerView = (PTSContainerView) view;
                        if (pTSContainerView == null || (childAt = pTSContainerView.getChildAt(1)) == null || (str2 = dataMap.get("hintText")) == null) {
                            return;
                        }
                        if (str2.length() > 0) {
                            PopupWindow popupWindow = ECSellerOrderFragment.this.hintPopup;
                            if (popupWindow != null) {
                                popupWindow.dismiss();
                            }
                            ECSellerOrderFragment eCSellerOrderFragment = ECSellerOrderFragment.this;
                            PopupWindow popupWindow2 = new PopupWindow(ECSellerOrderFragment.this.requireContext());
                            int c16 = com.tencent.ecommerce.biz.util.e.c(248.0f);
                            View inflate = LayoutInflater.from(ECSellerOrderFragment.this.getContext()).inflate(R.layout.f167345ct3, (ViewGroup) null, false);
                            ((TextView) inflate.findViewById(R.id.o6o)).setText(str2);
                            popupWindow2.setContentView(inflate);
                            popupWindow2.setBackgroundDrawable(null);
                            popupWindow2.showAsDropDown(childAt, (childAt.getWidth() - c16) / 2, com.tencent.ecommerce.biz.util.e.c(5.0f), 17);
                            Unit unit = Unit.INSTANCE;
                            eCSellerOrderFragment.hintPopup = popupWindow2;
                            return;
                        }
                        return;
                    }
                    return;
                case -931150290:
                    if (str.equals("allInOneJump")) {
                        String str5 = dataMap.get(WadlProxyConsts.KEY_JUMP_URL);
                        if (str5 == null || str5.length() == 0) {
                            cg0.a.a("ECSellerOrderFragment", "allInOneJump", "schema isNullOrEmpty");
                            return;
                        } else {
                            ECScheme.g(str5, null, 2, null);
                            return;
                        }
                    }
                    return;
                case 204756017:
                    if (!str.equals("tapCopyOrderId") || (str3 = dataMap.get(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ORDER_ID)) == null) {
                        return;
                    }
                    a(str3);
                    return;
                case 906517311:
                    if (!str.equals("changeDetailsState") || (str4 = dataMap.get("beforeDetailState")) == null) {
                        return;
                    }
                    int parseInt = Integer.parseInt(str4);
                    ECSellerOrderViewModel Yh = ECSellerOrderFragment.this.Yh();
                    if (identifier == null) {
                        identifier = "";
                    }
                    Yh.n2(identifier, parseInt != 0);
                    return;
                default:
                    return;
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/ecommerce/biz/orders/sellerorders/ECSellerOrderFragment$c", "Lcom/tencent/ecommerce/base/ui/refreshview/RecycleViewScrollListener;", "", "e", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class c extends RecycleViewScrollListener {
        c() {
        }

        @Override // com.tencent.ecommerce.base.ui.refreshview.RecycleViewScrollListener
        public void e() {
            super.e();
            ECSellerOrderFragment.this.Yh().g2();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK, "com/tencent/ecommerce/biz/orders/sellerorders/ECSellerOrderFragment$initView$2$1"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ECSellerOrderFragment eCSellerOrderFragment = ECSellerOrderFragment.this;
            eCSellerOrderFragment.ei(ECSellerOrderFragment.Rh(eCSellerOrderFragment).getText().toString());
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u0006H\n\u00a2\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Landroid/view/MotionEvent;", "onTouch"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class e implements View.OnTouchListener {
        e() {
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View view, MotionEvent motionEvent) {
            PopupWindow popupWindow = ECSellerOrderFragment.this.hintPopup;
            if (popupWindow == null) {
                return false;
            }
            popupWindow.dismiss();
            return false;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/ecommerce/biz/orders/sellerorders/ECSellerOrderFragment$f", "Lcom/tencent/ecommerce/biz/orders/sellerorders/orderfilter/FilterDialog$OnDismissListener;", "Lcom/tencent/ecommerce/biz/orders/sellerorders/orderfilter/a;", "selectedOptions", "", "onDismiss", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class f implements FilterDialog.OnDismissListener {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ SellerOrderFilterOption f103815b;

        f(SellerOrderFilterOption sellerOrderFilterOption) {
            this.f103815b = sellerOrderFilterOption;
        }

        @Override // com.tencent.ecommerce.biz.orders.sellerorders.orderfilter.FilterDialog.OnDismissListener
        public void onDismiss(FilterDialogSelectedOption selectedOptions) {
            ECSellerOrderFragment.this.Yh().k2(SellerOrderFilterOption.b(this.f103815b, null, null, selectedOptions.timeOption, selectedOptions.d(), selectedOptions.c(), 3, null));
        }
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK, "com/tencent/ecommerce/biz/orders/sellerorders/ECSellerOrderFragment$rightNavigationBarContent$1$1"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    static final class g implements View.OnClickListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ TextView f103817e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ ImageView f103818f;

        g(TextView textView, ImageView imageView) {
            this.f103817e = textView;
            this.f103818f = imageView;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ECSellerOrderFragment.this.bi();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/sellerorders/orderfilter/d;", "kotlin.jvm.PlatformType", "it", "", "a", "(Lcom/tencent/ecommerce/biz/orders/sellerorders/orderfilter/d;)V"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class h<T> implements Observer<SellerOrderFilterOption> {
        h() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(SellerOrderFilterOption sellerOrderFilterOption) {
            int i3;
            ECSellerOrderFragment.Ph(ECSellerOrderFragment.this).setText(sellerOrderFilterOption.toString());
            com.tencent.ecommerce.biz.orders.sellerorders.orderfilter.f fVar = sellerOrderFilterOption.category;
            if (Intrinsics.areEqual(fVar, f.a.f103871c)) {
                i3 = 0;
            } else if (Intrinsics.areEqual(fVar, f.b.f103872c)) {
                i3 = 1;
            } else {
                if (!Intrinsics.areEqual(fVar, f.c.f103873c)) {
                    throw new NoWhenBranchMatchedException();
                }
                i3 = 2;
            }
            ECSellerOrderFragment.this.di(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u00042\u001a\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0001 \u0002*\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "Lak0/a;", "kotlin.jvm.PlatformType", "it", "", "a", "(Ljava/util/List;)V"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class i<T> implements Observer<List<? extends ECSellerOrder>> {
        i() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(List<ECSellerOrder> list) {
            ECSellerOrderFragment.Sh(ECSellerOrderFragment.this).setData(list);
            if (list.isEmpty()) {
                ECSellerOrderFragment.Oh(ECSellerOrderFragment.this).setVisibility(0);
            } else {
                ECSellerOrderFragment.Oh(ECSellerOrderFragment.this).setVisibility(8);
            }
        }
    }

    public ECSellerOrderFragment() {
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.tencent.ecommerce.biz.orders.sellerorders.ECSellerOrderFragment$$special$$inlined$viewModels$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        this.sellerOrderViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(ECSellerOrderViewModel.class), new Function0<ViewModelStore>() { // from class: com.tencent.ecommerce.biz.orders.sellerorders.ECSellerOrderFragment$$special$$inlined$viewModels$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                ViewModelStore viewModelStore = ((ViewModelStoreOwner) Function0.this.invoke()).getViewModelStore();
                Intrinsics.checkExpressionValueIsNotNull(viewModelStore, "ownerProducer().viewModelStore");
                return viewModelStore;
            }
        }, null);
        this.mediaId = "";
        this.tabType = ECSellerOrderTab.SAAS;
    }

    public static final /* synthetic */ LinearLayout Oh(ECSellerOrderFragment eCSellerOrderFragment) {
        LinearLayout linearLayout = eCSellerOrderFragment.baseViewForEmptyList;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("baseViewForEmptyList");
        }
        return linearLayout;
    }

    public static final /* synthetic */ TextView Ph(ECSellerOrderFragment eCSellerOrderFragment) {
        TextView textView = eCSellerOrderFragment.filterOptionTextView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("filterOptionTextView");
        }
        return textView;
    }

    public static final /* synthetic */ TextView Rh(ECSellerOrderFragment eCSellerOrderFragment) {
        TextView textView = eCSellerOrderFragment.searchTextView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchTextView");
        }
        return textView;
    }

    public static final /* synthetic */ ECSellerOrderAdapter Sh(ECSellerOrderFragment eCSellerOrderFragment) {
        ECSellerOrderAdapter eCSellerOrderAdapter = eCSellerOrderFragment.sellerOrderAdapter;
        if (eCSellerOrderAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sellerOrderAdapter");
        }
        return eCSellerOrderAdapter;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ECSellerOrderViewModel Yh() {
        return (ECSellerOrderViewModel) this.sellerOrderViewModel.getValue();
    }

    private final void Zh(View rootView) {
        rootView.setOnClickListener(this);
        TextView textView = this.filterAllText;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("filterAllText");
        }
        textView.setOnClickListener(this);
        TextView textView2 = this.filterUnSettledText;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("filterUnSettledText");
        }
        textView2.setOnClickListener(this);
        TextView textView3 = this.filterSettledText;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("filterSettledText");
        }
        textView3.setOnClickListener(this);
    }

    private final void ai() {
        RecyclerView recyclerView = this.sellerOrderListView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sellerOrderListView");
        }
        recyclerView.addOnScrollListener(new c());
    }

    private final void ci() {
        Yh().b2().observe(getViewLifecycleOwner(), new h());
        Yh().c2().observe(getViewLifecycleOwner(), new i());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void di(int selectedIndex) {
        Integer num;
        ColorDrawable colorDrawable;
        List<? extends TextView> list = this.filterSettlementStateBtnList;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("filterSettlementStateBtnList");
        }
        int i3 = 0;
        for (Object obj : list) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            TextView textView = (TextView) obj;
            int i17 = selectedIndex == i3 ? 1 : 0;
            if (i17 != 0) {
                num = ECSkin.INSTANCE.getColor("qecommerce_skin_color_icon_primary");
            } else {
                num = 0;
            }
            if (num != null) {
                colorDrawable = new ColorDrawable(num.intValue());
                colorDrawable.setBounds(0, 0, com.tencent.ecommerce.biz.util.e.e(20.0f), com.tencent.ecommerce.biz.util.e.e(3.0f));
            } else {
                colorDrawable = null;
            }
            textView.setCompoundDrawables(null, null, null, colorDrawable);
            textView.setTypeface(null, i17);
            i3 = i16;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ei(String queryText) {
        Map mapOf;
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("arg_query_string", queryText));
        yi0.a.u(requireActivity(), 0, Uri.parse(String.valueOf(15)), mapOf);
        ki0.b.f412528a.d(getTabType());
    }

    private final void fi(String queryText) {
        TextView textView = this.searchTextView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchTextView");
        }
        textView.setText(queryText);
        if (TextUtils.isEmpty(queryText)) {
            TextView textView2 = this.searchTextView;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("searchTextView");
            }
            textView2.setVisibility(4);
            LinearLayout linearLayout = this.searchHintLayout;
            if (linearLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("searchHintLayout");
            }
            linearLayout.setVisibility(0);
            return;
        }
        TextView textView3 = this.searchTextView;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchTextView");
        }
        textView3.setVisibility(0);
        LinearLayout linearLayout2 = this.searchHintLayout;
        if (linearLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchHintLayout");
        }
        linearLayout2.setVisibility(4);
    }

    private final void initViewModel() {
        ci();
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment
    public boolean Eh() {
        return true;
    }

    @Override // com.tencent.ecommerce.biz.orders.sellerorders.ECAbsSellerOrderFragment
    /* renamed from: Mh, reason: from getter */
    public ECSellerOrderTab getTabType() {
        return this.tabType;
    }

    @Override // com.tencent.ecommerce.biz.orders.sellerorders.ECAbsSellerOrderFragment
    public View Nh(Context context) {
        TextView textView = new TextView(context);
        textView.setText(R.string.f169575wc4);
        textView.setTextColor(ECSkin.INSTANCE.getColor(R.color.f6942x));
        textView.setTextSize(15.0f);
        ImageView imageView = new ImageView(context);
        imageView.setLayoutParams(new ViewGroup.LayoutParams(com.tencent.ecommerce.biz.util.e.c(18.0f), com.tencent.ecommerce.biz.util.e.c(18.0f)));
        imageView.setBackgroundResource(R.drawable.bio);
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-2, -1));
        linearLayout.addView(textView);
        linearLayout.addView(imageView);
        linearLayout.setOnClickListener(new g(textView, imageView));
        return linearLayout;
    }

    @Override // com.tencent.ecommerce.base.fragment.api.IECBaseFragment
    /* renamed from: getBusinessDescription */
    public String getTAG() {
        return "ECSellerOrderFragment";
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment
    public int getContentLayoutId() {
        return R.layout.f167335cr3;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 0 && resultCode == 1) {
            if (data != null) {
                if (data.getBooleanExtra("arg_has_clicked_search_btn", false)) {
                    String stringExtra = data.getStringExtra("arg_query_string");
                    if (stringExtra != null) {
                        Yh().k2(SellerOrderFilterOption.b(Yh().getFilterOption(), stringExtra, null, null, null, null, 30, null));
                        fi(stringExtra);
                        if (stringExtra.length() > 0) {
                            ki0.b.f412528a.e(stringExtra, 1, ECSellerOrderTab.SAAS);
                            return;
                        }
                        return;
                    }
                    return;
                }
            }
            if (TextUtils.isEmpty(Yh().getFilterOption().searchKey)) {
                return;
            }
            Yh().k2(SellerOrderFilterOption.b(Yh().getFilterOption(), "", null, null, null, null, 30, null));
            fi("");
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (id5 == R.id.f163039nz4) {
            Yh().k2(SellerOrderFilterOption.b(Yh().getFilterOption(), null, f.a.f103871c, null, null, null, 29, null));
        } else if (id5 == R.id.nz6) {
            Yh().k2(SellerOrderFilterOption.b(Yh().getFilterOption(), null, f.b.f103872c, null, null, null, 29, null));
        } else if (id5 == R.id.nz5) {
            Yh().k2(SellerOrderFilterOption.b(Yh().getFilterOption(), null, f.c.f103873c, null, null, null, 29, null));
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        FilterDialog filterDialog;
        super.onConfigurationChanged(newConfig);
        FilterDialog filterDialog2 = this.filterDialog;
        if (filterDialog2 == null || !filterDialog2.isShowing() || (filterDialog = this.filterDialog) == null) {
            return;
        }
        filterDialog.dismiss();
    }

    @Override // com.tencent.ecommerce.biz.orders.sellerorders.ECAbsSellerOrderFragment, com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        String str;
        Intent intent;
        super.onCreate(savedInstanceState);
        FragmentActivity activity = getActivity();
        if (activity == null || (intent = activity.getIntent()) == null || (str = intent.getStringExtra("media_id")) == null) {
            str = "";
        }
        this.mediaId = str;
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.MainScope(), null, null, new ECSellerOrderFragment$onDestroy$1(this, null), 3, null);
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        PopupWindow popupWindow = this.hintPopup;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
        ECRMonitorManager.f100953c.b("EC_STAGE_SELLER_ORDER");
    }

    @Override // com.tencent.ecommerce.biz.orders.sellerorders.ECAbsSellerOrderFragment, com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ECRMonitorManager.f100953c.c("EC_STAGE_SELLER_ORDER");
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        initViewModel();
        Zh(view);
        ai();
        Yh().Z1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void bi() throws IllegalStateException {
        List listOf;
        List listOf2;
        com.tencent.ecommerce.biz.orders.sellerorders.orderfilter.c cVar;
        SellerOrderFilterOption value = Yh().b2().getValue();
        if (value == null) {
            value = new SellerOrderFilterOption(null, null, null, null, null, 31, null);
        }
        Context requireContext = requireContext();
        long j3 = 1000;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new com.tencent.ecommerce.biz.orders.sellerorders.orderfilter.g[]{g.a.f103876c, g.e.f103881c, g.d.f103880c, g.c.f103879c, new g.b(System.currentTimeMillis() / j3, System.currentTimeMillis() / j3)});
        List<com.tencent.ecommerce.biz.orders.sellerorders.orderfilter.c> value2 = Yh().a2().getValue();
        int size = (value2 != null ? value2.size() : 0) + 1;
        ArrayList arrayList = new ArrayList(size);
        for (int i3 = 0; i3 < size; i3++) {
            if (i3 == 0) {
                cVar = com.tencent.ecommerce.biz.orders.sellerorders.orderfilter.e.a();
            } else {
                List<com.tencent.ecommerce.biz.orders.sellerorders.orderfilter.c> value3 = Yh().a2().getValue();
                if (value3 == null || (cVar = value3.get(i3 - 1)) == null) {
                    throw new IllegalStateException("saasPlatforms is null");
                }
            }
            arrayList.add(cVar);
        }
        listOf2 = CollectionsKt__CollectionsKt.listOf((Object[]) new com.tencent.ecommerce.biz.orders.sellerorders.orderfilter.b[]{b.a.f103855c, b.e.f103859c, b.d.f103858c, b.c.f103857c, b.C1080b.f103856c});
        FilterDialog filterDialog = new FilterDialog(requireContext, R.style.f173260z5, listOf, arrayList, listOf2, new FilterDialogSelectedOption(value.timeOption, value.d(), value.c()), new f(value));
        Window window = filterDialog.getWindow();
        if (window != null) {
            window.setGravity(80);
            window.setWindowAnimations(R.style.f173268zd);
            window.getDecorView().setPadding(0, 0, 0, 0);
            WindowManager.LayoutParams attributes = window.getAttributes();
            if (attributes != null) {
                attributes.width = -1;
            }
            WindowManager.LayoutParams attributes2 = window.getAttributes();
            if (attributes2 != null) {
                attributes2.height = -2;
            }
        }
        filterDialog.show();
        Unit unit = Unit.INSTANCE;
        this.filterDialog = filterDialog;
    }

    private final void initView(View rootView) {
        List<? extends TextView> listOf;
        this.sellerOrderListView = (RecyclerView) rootView.findViewById(R.id.f163067o43);
        this.filterOptionTextView = (TextView) rootView.findViewById(R.id.oec);
        this.filterAllText = (TextView) rootView.findViewById(R.id.f163039nz4);
        this.filterUnSettledText = (TextView) rootView.findViewById(R.id.nz5);
        this.filterSettledText = (TextView) rootView.findViewById(R.id.nz6);
        TextView[] textViewArr = new TextView[3];
        TextView textView = this.filterAllText;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("filterAllText");
        }
        textViewArr[0] = textView;
        TextView textView2 = this.filterSettledText;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("filterSettledText");
        }
        textViewArr[1] = textView2;
        TextView textView3 = this.filterUnSettledText;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("filterUnSettledText");
        }
        textViewArr[2] = textView3;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) textViewArr);
        this.filterSettlementStateBtnList = listOf;
        this.sellerOrderAdapter = new ECSellerOrderAdapter(requireContext(), getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.CHANNEL java.lang.String(), this.mediaId, new b());
        this.baseViewForEmptyList = (LinearLayout) rootView.findViewById(R.id.nqe);
        RecyclerView recyclerView = this.sellerOrderListView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sellerOrderListView");
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext(), 1, false));
        RecyclerView recyclerView2 = this.sellerOrderListView;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sellerOrderListView");
        }
        ECSellerOrderAdapter eCSellerOrderAdapter = this.sellerOrderAdapter;
        if (eCSellerOrderAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sellerOrderAdapter");
        }
        recyclerView2.setAdapter(eCSellerOrderAdapter);
        RecyclerView recyclerView3 = this.sellerOrderListView;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sellerOrderListView");
        }
        recyclerView3.setOnTouchListener(new e());
        FrameLayout frameLayout = (FrameLayout) rootView.findViewById(R.id.o_r);
        frameLayout.setOnClickListener(new d());
        Unit unit = Unit.INSTANCE;
        this.searchBar = frameLayout;
        this.searchHintLayout = (LinearLayout) rootView.findViewById(R.id.o_s);
        this.searchTextView = (TextView) rootView.findViewById(R.id.o_t);
        String url = ECSkin.INSTANCE.getUrl("qecommerce_skin_emptystate_img_dongtai");
        if (url != null) {
            ImageViewKt.b((ImageView) rootView.findViewById(R.id.f163034ny4), url, 0, 0, 0, 14, null);
        }
    }
}
