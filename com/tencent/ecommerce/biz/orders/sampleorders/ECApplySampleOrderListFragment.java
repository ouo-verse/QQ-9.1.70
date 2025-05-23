package com.tencent.ecommerce.biz.orders.sampleorders;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.os.BundleKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cj0.a;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheLunarData;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.ecommerce.base.list.IStateCenterView;
import com.tencent.ecommerce.base.list.ListRepository;
import com.tencent.ecommerce.base.list.ListViewModel;
import com.tencent.ecommerce.base.list.ListViewModelLazyKt$listViewModels$1;
import com.tencent.ecommerce.base.list.ListViewModelLazyKt$listViewModels$2;
import com.tencent.ecommerce.base.ui.api.ECToastIcon;
import com.tencent.ecommerce.base.ui.g;
import com.tencent.ecommerce.base.ui.i;
import com.tencent.ecommerce.base.ui.refreshview.ECommercePullRefreshView;
import com.tencent.ecommerce.base.ui.stateview.ECStateCenterView;
import com.tencent.ecommerce.biz.applysample.ECAbortFulfillOrderFragment;
import com.tencent.ecommerce.biz.logistics.ECLogisticsTraceFragment;
import com.tencent.ecommerce.biz.orders.address.ECAddress;
import com.tencent.ecommerce.biz.orders.address.modifyorderaddress.ECModifyOrderAddressFragment;
import com.tencent.ecommerce.biz.orders.buyerorders.detail.model.OrderDetailEntrance;
import com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.sample.ECSampleOrderDetailFragment;
import com.tencent.ecommerce.biz.orders.buyerorders.orderlist.ECOrderListAdapter;
import com.tencent.ecommerce.biz.orders.buyerorders.orderlist.OrderListScene;
import com.tencent.ecommerce.biz.orders.sampleorders.ECApplySampleOrderListViewModel;
import com.tencent.ecommerce.biz.router.ECScheme;
import com.tencent.ecommerce.biz.showwindow.repo.window.ECShowWindowAddProductRsp;
import com.tencent.ecommerce.biz.showwindow.repo.window.k;
import com.tencent.ecommerce.repo.ServiceLocator;
import com.tencent.ecommerce.repo.buyerorder.orderlist.ECOrderListExtraInfo;
import com.tencent.ecommerce.repo.buyerorder.orderlist.ECOrderListItem;
import com.tencent.ecommerce.repo.sampleorder.ECApplySampleOrderListRequest;
import com.tencent.ecommerce.repo.sampleorder.ECApplySampleQueryType;
import com.tencent.ecommerce.repo.sampleorder.e;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.tuxmetersdk.impl.ruleengine.JsonRuleKey;
import common.config.service.QzoneConfig;
import cooperation.qzone.QzoneIPCModule;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import mqq.app.Constants;
import org.json.JSONObject;
import qi0.ECSelectProductAddWindowResponse;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00ca\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 m2\u00020\u0001:\u0001nB\u0007\u00a2\u0006\u0004\bk\u0010lJ&\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u001a\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\"\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\u001b\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0013H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u001b\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0017H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u001b\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u001aH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\b\u0010\u001d\u001a\u00020\u000bH\u0002J\b\u0010\u001e\u001a\u00020\u000bH\u0002J\b\u0010\u001f\u001a\u00020\u000bH\u0002J$\u0010%\u001a\u00020\u000b2\u0006\u0010!\u001a\u00020 2\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020#0\"H\u0002J$\u0010&\u001a\u00020\u000b2\u0006\u0010!\u001a\u00020 2\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020#0\"H\u0002J$\u0010'\u001a\u00020\u000b2\u0006\u0010!\u001a\u00020 2\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020#0\"H\u0002J$\u0010(\u001a\u00020\u000b2\u0006\u0010!\u001a\u00020 2\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020#0\"H\u0002J$\u0010)\u001a\u00020\u000b2\u0006\u0010!\u001a\u00020 2\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020#0\"H\u0002J$\u0010*\u001a\u00020\u000b2\u0006\u0010!\u001a\u00020 2\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020#0\"H\u0002J$\u0010+\u001a\u00020\u000b2\u0006\u0010!\u001a\u00020 2\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020#0\"H\u0002J$\u0010,\u001a\u00020\u000b2\u0006\u0010!\u001a\u00020 2\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020#0\"H\u0002J$\u0010-\u001a\u00020\u000b2\u0006\u0010!\u001a\u00020 2\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020#0\"H\u0002J$\u0010.\u001a\u00020\u000b2\u0006\u0010!\u001a\u00020 2\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020#0\"H\u0002J\b\u0010/\u001a\u00020\u000bH\u0002J\u0010\u00101\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u000200H\u0002J\u001a\u00105\u001a\u00020\u000b2\u0006\u00102\u001a\u00020#2\b\u00104\u001a\u0004\u0018\u000103H\u0002J\u0018\u00107\u001a\u00020\u000b2\u0006\u00102\u001a\u00020#2\u0006\u00106\u001a\u00020#H\u0002R\u0016\u0010;\u001a\u0002088\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010?\u001a\u00020<8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010C\u001a\u00020@8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bA\u0010BR\u0016\u0010G\u001a\u00020D8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bE\u0010FR\u0016\u0010J\u001a\u00020#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u0010IR\u0016\u0010N\u001a\u00020K8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bL\u0010MR-\u0010W\u001a\u0014\u0012\u0004\u0012\u00020P\u0012\u0004\u0012\u00020Q\u0012\u0004\u0012\u00020R0O8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bS\u0010T\u001a\u0004\bU\u0010VR\u001b\u0010\\\u001a\u00020X8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bY\u0010T\u001a\u0004\bZ\u0010[R\u001b\u0010a\u001a\u00020]8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b^\u0010T\u001a\u0004\b_\u0010`R\\\u0010g\u001aJ\u0012\u0004\u0012\u00020#\u0012@\u0012>\u0012\u0013\u0012\u00110 \u00a2\u0006\f\bc\u0012\b\bd\u0012\u0004\b\b(!\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020#0\"\u00a2\u0006\f\bc\u0012\b\bd\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u000b0b0\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\be\u0010fR\u001a\u00102\u001a\u0004\u0018\u00010#*\u00020 8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bh\u0010iR\u001a\u00106\u001a\u0004\u0018\u00010#*\u00020 8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bj\u0010i\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006o"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/sampleorders/ECApplySampleOrderListFragment;", "Landroidx/fragment/app/Fragment;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Landroid/view/View;", "onCreateView", "view", "", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", "Lcom/tencent/ecommerce/biz/orders/sampleorders/ECApplySampleOrderListViewModel$b$c;", "event", "Xh", "(Lcom/tencent/ecommerce/biz/orders/sampleorders/ECApplySampleOrderListViewModel$b$c;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/tencent/ecommerce/biz/orders/sampleorders/ECApplySampleOrderListViewModel$b$b;", "Wh", "(Lcom/tencent/ecommerce/biz/orders/sampleorders/ECApplySampleOrderListViewModel$b$b;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/tencent/ecommerce/biz/orders/sampleorders/ECApplySampleOrderListViewModel$b$d;", "Yh", "(Lcom/tencent/ecommerce/biz/orders/sampleorders/ECApplySampleOrderListViewModel$b$d;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "hi", "ii", WidgetCacheLunarData.JI, "Lorg/json/JSONObject;", "itemJSONObject", "", "", "dataMap", "bi", "ai", "Sh", "li", "mi", "ph", "Rh", "Qh", "ni", "Th", "Uh", "Lcom/tencent/ecommerce/biz/orders/sampleorders/ECApplySampleOrderListViewModel$b$e;", "Zh", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ORDER_ID, "Lqi0/a;", "addProductWindowResponse", "Vh", "spuId", "ki", "Lcom/tencent/ecommerce/base/ui/refreshview/ECommercePullRefreshView;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/ecommerce/base/ui/refreshview/ECommercePullRefreshView;", "refreshLayout", "Lcom/tencent/ecommerce/base/ui/stateview/ECStateCenterView;", "D", "Lcom/tencent/ecommerce/base/ui/stateview/ECStateCenterView;", "stateCenterView", "Lcom/tencent/ecommerce/biz/orders/buyerorders/orderlist/ECOrderListAdapter;", "E", "Lcom/tencent/ecommerce/biz/orders/buyerorders/orderlist/ECOrderListAdapter;", "adapter", "Lcom/tencent/ecommerce/repo/sampleorder/ECApplySampleQueryType;", UserInfo.SEX_FEMALE, "Lcom/tencent/ecommerce/repo/sampleorder/ECApplySampleQueryType;", "queryType", "G", "Ljava/lang/String;", "queryKeyword", "Lcom/tencent/ecommerce/biz/orders/buyerorders/orderlist/OrderListScene;", "H", "Lcom/tencent/ecommerce/biz/orders/buyerorders/orderlist/OrderListScene;", "scene", "Lcom/tencent/ecommerce/base/list/ListViewModel;", "Lcom/tencent/ecommerce/repo/sampleorder/c;", "Lcom/tencent/ecommerce/repo/buyerorder/orderlist/b;", "Lcom/tencent/ecommerce/repo/buyerorder/orderlist/a;", "I", "Lkotlin/Lazy;", "ci", "()Lcom/tencent/ecommerce/base/list/ListViewModel;", "listViewModel", "Lcom/tencent/ecommerce/biz/orders/sampleorders/ECApplySampleOrderListViewModel;", "J", "di", "()Lcom/tencent/ecommerce/biz/orders/sampleorders/ECApplySampleOrderListViewModel;", "operateViewModel", "Lcom/tencent/ecommerce/biz/orders/sampleorders/e;", "K", "fi", "()Lcom/tencent/ecommerce/biz/orders/sampleorders/e;", "orderViewModel", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "L", "Ljava/util/Map;", "ptsEventTypeToHandler", "ei", "(Lorg/json/JSONObject;)Ljava/lang/String;", "gi", "<init>", "()V", "N", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECApplySampleOrderListFragment extends Fragment {

    /* renamed from: C, reason: from kotlin metadata */
    private ECommercePullRefreshView refreshLayout;

    /* renamed from: D, reason: from kotlin metadata */
    private ECStateCenterView stateCenterView;

    /* renamed from: E, reason: from kotlin metadata */
    private ECOrderListAdapter adapter;

    /* renamed from: F, reason: from kotlin metadata */
    private ECApplySampleQueryType queryType = ECApplySampleQueryType.ALL;

    /* renamed from: G, reason: from kotlin metadata */
    private String queryKeyword = "";

    /* renamed from: H, reason: from kotlin metadata */
    private OrderListScene scene = OrderListScene.ORDER_LIST_PAGE;

    /* renamed from: I, reason: from kotlin metadata */
    private final Lazy listViewModel = new ViewModelLazy(Reflection.getOrCreateKotlinClass(ListViewModel.class), new ListViewModelLazyKt$listViewModels$1(this), new ListViewModelLazyKt$listViewModels$2(new com.tencent.ecommerce.base.list.d(new ListRepository(ServiceLocator.f104891i.c(), M, null, 4, null))));

    /* renamed from: J, reason: from kotlin metadata */
    private final Lazy operateViewModel;

    /* renamed from: K, reason: from kotlin metadata */
    private final Lazy orderViewModel;

    /* renamed from: L, reason: from kotlin metadata */
    private final Map<String, Function2<JSONObject, Map<String, String>, Unit>> ptsEventTypeToHandler;

    /* renamed from: N, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final com.tencent.ecommerce.base.list.b<ECOrderListItem> M = new com.tencent.ecommerce.base.list.b<>();

    /* compiled from: P */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b#\u0010$J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006R\u0014\u0010\n\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u000bR\u0014\u0010\r\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000bR\u0014\u0010\u000f\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u000bR\u0014\u0010\u0010\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000bR\u0014\u0010\u0011\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u000bR\u0014\u0010\u0012\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u000bR\u0014\u0010\u0013\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u000bR\u0014\u0010\u0014\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u000bR\u0014\u0010\u0015\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u000bR\u0014\u0010\u0017\u001a\u00020\u00168\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u00168\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0018R\u0014\u0010\u001a\u001a\u00020\u00168\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0018R\u0014\u0010\u001b\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u000bR\u0014\u0010\u001c\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u000bR\u0014\u0010\u001d\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u000bR\u0014\u0010\u001e\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u000bR\u001a\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"\u00a8\u0006%"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/sampleorders/ECApplySampleOrderListFragment$a;", "", "Lcom/tencent/ecommerce/repo/sampleorder/ECApplySampleQueryType;", "type", "", "searchQuery", "Lcom/tencent/ecommerce/biz/orders/buyerorders/orderlist/OrderListScene;", "scene", "Lcom/tencent/ecommerce/biz/orders/sampleorders/ECApplySampleOrderListFragment;", "a", "ABORT_CONSIGN_EVENT", "Ljava/lang/String;", "ADD_WINDOW_EVENT", "CANCEL_APPLY_ABORT_CONSIGN_EVENT", "CANCEL_APPLY_EVENT", "CONFIRM_RECEIVE_GOODS_EVENT", "ENTER_ORDER_DETAIL_PAGE_EVENT", "ENTER_SHOP_PAGE_EVENT", "ORDER_LIST_SCENE", "PTS_PAGE_NAME", "QUERY_KEYWORD", "QUERY_TYPE", "", "REQUEST_CODE_ABORT_FULFILL_ORDER", "I", "REQUEST_CODE_MODIFY_ADDRESS_FROM_ORDER_LIST", "REQUEST_CODE_MODIFY_ADDRESS_FROM_SEARCH", "TAG", "UPDATE_ADDRESS_EVENT", "VIEW_CONSIGN_DETAIL_EVENT", "VIEW_SHIPPING_EVENT", "Lcom/tencent/ecommerce/base/list/b;", "Lcom/tencent/ecommerce/repo/buyerorder/orderlist/b;", JsonRuleKey.OPERATOR, "Lcom/tencent/ecommerce/base/list/b;", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.biz.orders.sampleorders.ECApplySampleOrderListFragment$a, reason: from kotlin metadata */
    /* loaded from: classes31.dex */
    public static final class Companion {
        Companion() {
        }

        public final ECApplySampleOrderListFragment a(ECApplySampleQueryType type, String searchQuery, OrderListScene scene) {
            ECApplySampleOrderListFragment eCApplySampleOrderListFragment = new ECApplySampleOrderListFragment();
            eCApplySampleOrderListFragment.setArguments(BundleKt.bundleOf(TuplesKt.to("query_type", type), TuplesKt.to("query_keyword", searchQuery), TuplesKt.to("order_list_scene", scene)));
            return eCApplySampleOrderListFragment;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ ECApplySampleOrderListFragment b(Companion companion, ECApplySampleQueryType eCApplySampleQueryType, String str, OrderListScene orderListScene, int i3, Object obj) {
            if ((i3 & 2) != 0) {
                str = "";
            }
            if ((i3 & 4) != 0) {
                orderListScene = OrderListScene.ORDER_LIST_PAGE;
            }
            return companion.a(eCApplySampleQueryType, str, orderListScene);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\u0007\u00b8\u0006\u0000"}, d2 = {"com/tencent/ecommerce/biz/orders/sampleorders/ECApplySampleOrderListFragment$onCreateView$4$1", "Lcom/tencent/ecommerce/base/ui/refreshview/ECommercePullRefreshView$OnRefreshStateListener;", "", "tag", "", "onRefreshBegin", "onLoadMoreBegin", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class b implements ECommercePullRefreshView.OnRefreshStateListener {
        b() {
        }

        @Override // com.tencent.ecommerce.base.ui.refreshview.ECommercePullRefreshView.OnRefreshStateListener
        public void onLoadMoreBegin() {
            ECApplySampleOrderListFragment.this.ii();
        }

        @Override // com.tencent.ecommerce.base.ui.refreshview.ECommercePullRefreshView.OnRefreshStateListener
        public void onRefreshBegin(int tag) {
            ECApplySampleOrderListFragment.this.ji();
        }

        @Override // com.tencent.ecommerce.base.ui.refreshview.ECommercePullRefreshView.OnRefreshStateListener
        public void onRefreshFinished(boolean z16, int i3) {
            ECommercePullRefreshView.OnRefreshStateListener.a.a(this, z16, i3);
        }
    }

    public ECApplySampleOrderListFragment() {
        Map<String, Function2<JSONObject, Map<String, String>, Unit>> mapOf;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.tencent.ecommerce.biz.orders.sampleorders.ECApplySampleOrderListFragment$$special$$inlined$viewModels$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        this.operateViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(ECApplySampleOrderListViewModel.class), new Function0<ViewModelStore>() { // from class: com.tencent.ecommerce.biz.orders.sampleorders.ECApplySampleOrderListFragment$$special$$inlined$viewModels$2
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
        this.orderViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(e.class), new Function0<ViewModelStore>() { // from class: com.tencent.ecommerce.biz.orders.sampleorders.ECApplySampleOrderListFragment$$special$$inlined$activityViewModels$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                FragmentActivity requireActivity = Fragment.this.requireActivity();
                Intrinsics.checkExpressionValueIsNotNull(requireActivity, "requireActivity()");
                ViewModelStore viewModelStore = requireActivity.getViewModelStore();
                Intrinsics.checkExpressionValueIsNotNull(viewModelStore, "requireActivity().viewModelStore");
                return viewModelStore;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.tencent.ecommerce.biz.orders.sampleorders.ECApplySampleOrderListFragment$$special$$inlined$activityViewModels$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                FragmentActivity requireActivity = Fragment.this.requireActivity();
                Intrinsics.checkExpressionValueIsNotNull(requireActivity, "requireActivity()");
                ViewModelProvider.Factory defaultViewModelProviderFactory = requireActivity.getDefaultViewModelProviderFactory();
                Intrinsics.checkExpressionValueIsNotNull(defaultViewModelProviderFactory, "requireActivity().defaultViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("enterShopPage", new ECApplySampleOrderListFragment$ptsEventTypeToHandler$1(this)), TuplesKt.to("enterOrderDetailPage", new ECApplySampleOrderListFragment$ptsEventTypeToHandler$2(this)), TuplesKt.to("cancelApply", new ECApplySampleOrderListFragment$ptsEventTypeToHandler$3(this)), TuplesKt.to("updateAddress", new ECApplySampleOrderListFragment$ptsEventTypeToHandler$4(this)), TuplesKt.to("viewConsignDetail", new ECApplySampleOrderListFragment$ptsEventTypeToHandler$5(this)), TuplesKt.to("abortConsign", new ECApplySampleOrderListFragment$ptsEventTypeToHandler$6(this)), TuplesKt.to("cancelApplyAbortConsign", new ECApplySampleOrderListFragment$ptsEventTypeToHandler$7(this)), TuplesKt.to("addWindow", new ECApplySampleOrderListFragment$ptsEventTypeToHandler$8(this)), TuplesKt.to("viewShipping", new ECApplySampleOrderListFragment$ptsEventTypeToHandler$9(this)), TuplesKt.to("confirmReceiveGoods", new ECApplySampleOrderListFragment$ptsEventTypeToHandler$10(this)));
        this.ptsEventTypeToHandler = mapOf;
    }

    public static final /* synthetic */ ECommercePullRefreshView Hh(ECApplySampleOrderListFragment eCApplySampleOrderListFragment) {
        ECommercePullRefreshView eCommercePullRefreshView = eCApplySampleOrderListFragment.refreshLayout;
        if (eCommercePullRefreshView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
        }
        return eCommercePullRefreshView;
    }

    public static final /* synthetic */ ECStateCenterView Jh(ECApplySampleOrderListFragment eCApplySampleOrderListFragment) {
        ECStateCenterView eCStateCenterView = eCApplySampleOrderListFragment.stateCenterView;
        if (eCStateCenterView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stateCenterView");
        }
        return eCStateCenterView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0030, code lost:
    
        if (r2 != false) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void Qh(JSONObject itemJSONObject, Map<String, String> dataMap) {
        boolean isBlank;
        String str = dataMap.get("spuId");
        String ei5 = ei(itemJSONObject);
        boolean z16 = false;
        if (ei5 == null || ei5.length() == 0) {
            cg0.a.a("ECApplySampleOrderListFragment", "addProductWindow", "order id is null or empty");
            return;
        }
        if (str != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(str);
        }
        z16 = true;
        if (z16) {
            cg0.a.a("ECApplySampleOrderListFragment", "addProductWindow", "spu id is null or empty");
        } else {
            di().N1(ei5, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Rh(JSONObject itemJSONObject, Map<String, String> dataMap) {
        final String str = dataMap.get("token");
        if (str == null) {
            str = "";
        }
        final String ei5 = ei(itemJSONObject);
        if (ei5 == null || ei5.length() == 0) {
            cg0.a.a("ECApplySampleOrderListFragment", "cancelApplyAbortConsign", "order id is null or empty");
            return;
        }
        g gVar = new g(requireContext());
        gVar.Y(getString(R.string.wgx));
        gVar.e0(new Function1<View, Unit>() { // from class: com.tencent.ecommerce.biz.orders.sampleorders.ECApplySampleOrderListFragment$cancelApplyAbortConsign$$inlined$apply$lambda$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(View view) {
                ECApplySampleOrderListViewModel di5;
                di5 = ECApplySampleOrderListFragment.this.di();
                di5.O1(ei5, str);
            }
        });
        gVar.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Sh(JSONObject itemJSONObject, Map<String, String> dataMap) {
        final String str = dataMap.get("token");
        if (str == null) {
            str = "";
        }
        final String ei5 = ei(itemJSONObject);
        if (ei5 == null || ei5.length() == 0) {
            cg0.a.a("ECApplySampleOrderListFragment", "cancelApplySample", "order id is null or empty");
            return;
        }
        g gVar = new g(requireContext());
        gVar.Y(getString(R.string.wgy));
        gVar.e0(new Function1<View, Unit>() { // from class: com.tencent.ecommerce.biz.orders.sampleorders.ECApplySampleOrderListFragment$cancelApplySample$$inlined$apply$lambda$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(View view) {
                ECApplySampleOrderListViewModel di5;
                di5 = ECApplySampleOrderListFragment.this.di();
                di5.P1(ei5, str);
            }
        });
        gVar.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Th(JSONObject itemJSONObject, Map<String, String> dataMap) {
        final String str = dataMap.get("token");
        if (str == null) {
            str = "";
        }
        final String ei5 = ei(itemJSONObject);
        if (ei5 == null || ei5.length() == 0) {
            cg0.a.a("ECApplySampleOrderListFragment", "confirmReceiveGoods", "order id is null or empty");
            return;
        }
        g gVar = new g(requireContext());
        gVar.Y(getString(R.string.wid));
        gVar.e0(new Function1<View, Unit>() { // from class: com.tencent.ecommerce.biz.orders.sampleorders.ECApplySampleOrderListFragment$confirmReceiveGoods$$inlined$apply$lambda$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(View view) {
                ECApplySampleOrderListViewModel di5;
                di5 = ECApplySampleOrderListFragment.this.di();
                di5.Q1(ei5, str);
            }
        });
        gVar.show();
    }

    private final void Uh() {
        LifecycleOwnerKt.getLifecycleScope(this).launchWhenCreated(new ECApplySampleOrderListFragment$dealAbortFulfillOrder$1(this, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Zh(ECApplySampleOrderListViewModel.b.e event) {
        i.e(i.f101155b, event.result instanceof e.Succeed ? R.string.f169620wo4 : R.string.wo9, null, 0, 6, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ai(JSONObject itemJSONObject, Map<String, String> dataMap) {
        String ei5 = ei(itemJSONObject);
        if (ei5 == null || ei5.length() == 0) {
            cg0.a.a("ECApplySampleOrderListFragment", "enterOrderDetailPage", "link url is null or empty");
        } else {
            ECSampleOrderDetailFragment.INSTANCE.a(requireContext(), ei5, OrderDetailEntrance.FROM_ORDER_LIST);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void bi(JSONObject itemJSONObject, Map<String, String> dataMap) {
        String str = dataMap.get(WadlProxyConsts.KEY_JUMP_URL);
        if (str == null || str.length() == 0) {
            cg0.a.a("ECApplySampleOrderListFragment", "enterShopPage", "schema isNullOrEmpty");
        } else {
            ECScheme.g(str, null, 2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ListViewModel<ECApplySampleOrderListRequest, ECOrderListItem, ECOrderListExtraInfo> ci() {
        return (ListViewModel) this.listViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ECApplySampleOrderListViewModel di() {
        return (ECApplySampleOrderListViewModel) this.operateViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String ei(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("order");
        if (optJSONObject != null) {
            return optJSONObject.optString("order_id");
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final e fi() {
        return (e) this.orderViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String gi(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("product");
        if (optJSONObject != null) {
            return optJSONObject.optString("spu_id");
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void hi() {
        ci().X1(new ECApplySampleOrderListRequest(this.queryKeyword, this.queryType));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ii() {
        ci().Z1(new ECApplySampleOrderListRequest(this.queryKeyword, this.queryType));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ji() {
        ci().a2(new ECApplySampleOrderListRequest(this.queryKeyword, this.queryType));
    }

    private final void ki(String orderId, String spuId) {
        Object obj;
        JSONObject put;
        Iterator<T> it = ci().S1().getValue().a().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            ECOrderListItem eCOrderListItem = (ECOrderListItem) obj;
            if (Intrinsics.areEqual(ei(eCOrderListItem.getPtsJSONObject()), orderId) && Intrinsics.areEqual(gi(eCOrderListItem.getPtsJSONObject()), spuId)) {
                break;
            }
        }
        ECOrderListItem eCOrderListItem2 = (ECOrderListItem) obj;
        if (eCOrderListItem2 == null) {
            cg0.a.a("ECApplySampleOrderListFragment", "succeedAddProductToWindow", "can not find order which its orderId is " + orderId + " and spuId is " + spuId);
            return;
        }
        ECOrderListItem b16 = ECOrderListItem.b(eCOrderListItem2, null, 1, null);
        JSONObject optJSONObject = b16.getPtsJSONObject().optJSONObject("ui_data");
        if (optJSONObject != null && (put = optJSONObject.put("allow_add_window", false)) != null) {
            put.put("allow_in_window", true);
        }
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new ECApplySampleOrderListFragment$succeedAddProductToWindow$1(this, b16, orderId, spuId, null), 3, null);
        i.e(i.f101155b, R.string.wf9, ECToastIcon.ICON_SUCCESS, 0, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void li(JSONObject itemJSONObject, Map<String, String> dataMap) {
        int i3;
        String str = dataMap.get("token");
        if (str == null) {
            str = "";
        }
        final String str2 = str;
        final String ei5 = ei(itemJSONObject);
        if (ei5 == null || ei5.length() == 0) {
            cg0.a.a("ECApplySampleOrderListFragment", "updateAddress", "order id is null or empty");
            return;
        }
        JSONObject optJSONObject = itemJSONObject.optJSONObject("creative");
        JSONObject optJSONObject2 = optJSONObject != null ? optJSONObject.optJSONObject("address") : null;
        final ECAddress a16 = optJSONObject2 == null ? null : ECAddress.INSTANCE.a(optJSONObject2);
        StringBuilder sb5 = new StringBuilder();
        sb5.append("startFetchAddress, id= ");
        sb5.append(a16 != null ? Long.valueOf(a16.id) : null);
        cg0.a.b("ECApplySampleOrderListFragment", sb5.toString());
        if (a16 == null) {
            com.tencent.ecommerce.biz.orders.address.c.e(4, null, new Function1<ECAddress, Unit>() { // from class: com.tencent.ecommerce.biz.orders.sampleorders.ECApplySampleOrderListFragment$updateAddress$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(ECAddress eCAddress) {
                    invoke2(eCAddress);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(ECAddress eCAddress) {
                    ECApplySampleOrderListViewModel di5;
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append("afterFetchAddress, id= ");
                    sb6.append(eCAddress != null ? Long.valueOf(eCAddress.id) : null);
                    cg0.a.b("ECApplySampleOrderListFragment", sb6.toString());
                    if (eCAddress != null) {
                        long j3 = eCAddress.id;
                        ECAddress eCAddress2 = a16;
                        if (eCAddress2 == null || j3 != eCAddress2.id) {
                            di5 = ECApplySampleOrderListFragment.this.di();
                            di5.S1(ei5, str2, eCAddress);
                        }
                    }
                }
            });
            return;
        }
        int i16 = com.tencent.ecommerce.biz.orders.sampleorders.b.f103796a[this.scene.ordinal()];
        if (i16 == 1) {
            i3 = 1002;
        } else {
            if (i16 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            i3 = 1003;
        }
        ECModifyOrderAddressFragment.INSTANCE.a(requireActivity(), i3, str2, ei5, a16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void mi(JSONObject itemJSONObject, Map<String, String> dataMap) {
        ECScheme.g(Uri.parse("mqqapi://ecommerce/open").buildUpon().appendQueryParameter("target", QzoneConfig.DefaultValue.DEFAULT_MODEL_PHONE).appendQueryParameter(WadlProxyConsts.CHANNEL, String.valueOf(ug0.b.f438933d.e())).appendQueryParameter("page_name", "apply_sample_delivery_detail_page").appendQueryParameter("order_id", ei(itemJSONObject)).toString(), null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ni(JSONObject itemJSONObject, Map<String, String> dataMap) {
        String str;
        String ei5 = ei(itemJSONObject);
        if (ei5 == null || ei5.length() == 0) {
            cg0.a.a("ECApplySampleOrderListFragment", "viewShipping", "order id is null or empty");
            return;
        }
        JSONObject optJSONObject = itemJSONObject.optJSONObject("logistics");
        if (optJSONObject == null || (str = optJSONObject.optString("logistics_code")) == null) {
            str = "";
        }
        ECLogisticsTraceFragment.INSTANCE.a(requireContext(), ei5, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ph(JSONObject itemJSONObject, Map<String, String> dataMap) {
        String ei5 = ei(itemJSONObject);
        if (ei5 == null || ei5.length() == 0) {
            cg0.a.a("ECApplySampleOrderListFragment", "abortFullFillOrder", "order id is null or empty");
        } else {
            ECAbortFulfillOrderFragment.INSTANCE.a(requireActivity(), ei5, 1001);
        }
    }

    public static final /* synthetic */ ECOrderListAdapter zh(ECApplySampleOrderListFragment eCApplySampleOrderListFragment) {
        ECOrderListAdapter eCOrderListAdapter = eCApplySampleOrderListFragment.adapter;
        if (eCOrderListAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        return eCOrderListAdapter;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final /* synthetic */ Object Wh(ECApplySampleOrderListViewModel.b.C1079b c1079b, Continuation<? super Unit> continuation) {
        ECApplySampleOrderListFragment$dealCancelApplyAbortConsignEvent$1 eCApplySampleOrderListFragment$dealCancelApplyAbortConsignEvent$1;
        Object coroutine_suspended;
        int i3;
        Set<? extends ECApplySampleQueryType> of5;
        if (continuation instanceof ECApplySampleOrderListFragment$dealCancelApplyAbortConsignEvent$1) {
            eCApplySampleOrderListFragment$dealCancelApplyAbortConsignEvent$1 = (ECApplySampleOrderListFragment$dealCancelApplyAbortConsignEvent$1) continuation;
            int i16 = eCApplySampleOrderListFragment$dealCancelApplyAbortConsignEvent$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                eCApplySampleOrderListFragment$dealCancelApplyAbortConsignEvent$1.label = i16 - Integer.MIN_VALUE;
                Object obj = eCApplySampleOrderListFragment$dealCancelApplyAbortConsignEvent$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = eCApplySampleOrderListFragment$dealCancelApplyAbortConsignEvent$1.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    if (c1079b.com.tencent.youtu.sdkkitframework.common.StateEvent.ProcessResult.SUCCEED java.lang.String) {
                        e fi5 = fi();
                        of5 = SetsKt__SetsKt.setOf((Object[]) new ECApplySampleQueryType[]{this.queryType, ECApplySampleQueryType.ALL, ECApplySampleQueryType.FULFILLING, ECApplySampleQueryType.AUDITING});
                        eCApplySampleOrderListFragment$dealCancelApplyAbortConsignEvent$1.label = 1;
                        if (fi5.N1(of5, eCApplySampleOrderListFragment$dealCancelApplyAbortConsignEvent$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        i.e(i.f101155b, R.string.wo9, null, 0, 6, null);
                    }
                } else if (i3 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return Unit.INSTANCE;
            }
        }
        eCApplySampleOrderListFragment$dealCancelApplyAbortConsignEvent$1 = new ECApplySampleOrderListFragment$dealCancelApplyAbortConsignEvent$1(this, continuation);
        Object obj2 = eCApplySampleOrderListFragment$dealCancelApplyAbortConsignEvent$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = eCApplySampleOrderListFragment$dealCancelApplyAbortConsignEvent$1.label;
        if (i3 != 0) {
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final /* synthetic */ Object Xh(ECApplySampleOrderListViewModel.b.c cVar, Continuation<? super Unit> continuation) {
        ECApplySampleOrderListFragment$dealCancelApplySampleEvent$1 eCApplySampleOrderListFragment$dealCancelApplySampleEvent$1;
        Object coroutine_suspended;
        int i3;
        Set<? extends ECApplySampleQueryType> of5;
        if (continuation instanceof ECApplySampleOrderListFragment$dealCancelApplySampleEvent$1) {
            eCApplySampleOrderListFragment$dealCancelApplySampleEvent$1 = (ECApplySampleOrderListFragment$dealCancelApplySampleEvent$1) continuation;
            int i16 = eCApplySampleOrderListFragment$dealCancelApplySampleEvent$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                eCApplySampleOrderListFragment$dealCancelApplySampleEvent$1.label = i16 - Integer.MIN_VALUE;
                Object obj = eCApplySampleOrderListFragment$dealCancelApplySampleEvent$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = eCApplySampleOrderListFragment$dealCancelApplySampleEvent$1.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    if (cVar.com.tencent.youtu.sdkkitframework.common.StateEvent.ProcessResult.SUCCEED java.lang.String) {
                        e fi5 = fi();
                        of5 = SetsKt__SetsKt.setOf((Object[]) new ECApplySampleQueryType[]{this.queryType, ECApplySampleQueryType.ALL, ECApplySampleQueryType.CANCELLED, ECApplySampleQueryType.AUDITING});
                        eCApplySampleOrderListFragment$dealCancelApplySampleEvent$1.label = 1;
                        if (fi5.N1(of5, eCApplySampleOrderListFragment$dealCancelApplySampleEvent$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        i.e(i.f101155b, R.string.wo9, null, 0, 6, null);
                    }
                } else if (i3 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return Unit.INSTANCE;
            }
        }
        eCApplySampleOrderListFragment$dealCancelApplySampleEvent$1 = new ECApplySampleOrderListFragment$dealCancelApplySampleEvent$1(this, continuation);
        Object obj2 = eCApplySampleOrderListFragment$dealCancelApplySampleEvent$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = eCApplySampleOrderListFragment$dealCancelApplySampleEvent$1.label;
        if (i3 != 0) {
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final /* synthetic */ Object Yh(ECApplySampleOrderListViewModel.b.d dVar, Continuation<? super Unit> continuation) {
        ECApplySampleOrderListFragment$dealConfirmReceiveGoodsEvent$1 eCApplySampleOrderListFragment$dealConfirmReceiveGoodsEvent$1;
        Object coroutine_suspended;
        int i3;
        Set<? extends ECApplySampleQueryType> of5;
        if (continuation instanceof ECApplySampleOrderListFragment$dealConfirmReceiveGoodsEvent$1) {
            eCApplySampleOrderListFragment$dealConfirmReceiveGoodsEvent$1 = (ECApplySampleOrderListFragment$dealConfirmReceiveGoodsEvent$1) continuation;
            int i16 = eCApplySampleOrderListFragment$dealConfirmReceiveGoodsEvent$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                eCApplySampleOrderListFragment$dealConfirmReceiveGoodsEvent$1.label = i16 - Integer.MIN_VALUE;
                Object obj = eCApplySampleOrderListFragment$dealConfirmReceiveGoodsEvent$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = eCApplySampleOrderListFragment$dealConfirmReceiveGoodsEvent$1.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    if (dVar.com.tencent.youtu.sdkkitframework.common.StateEvent.ProcessResult.SUCCEED java.lang.String) {
                        e fi5 = fi();
                        of5 = SetsKt__SetsKt.setOf((Object[]) new ECApplySampleQueryType[]{this.queryType, ECApplySampleQueryType.ALL, ECApplySampleQueryType.FULFILLING, ECApplySampleQueryType.SIGNING});
                        eCApplySampleOrderListFragment$dealConfirmReceiveGoodsEvent$1.label = 1;
                        if (fi5.N1(of5, eCApplySampleOrderListFragment$dealConfirmReceiveGoodsEvent$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        i.e(i.f101155b, R.string.wo9, null, 0, 6, null);
                    }
                } else if (i3 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return Unit.INSTANCE;
            }
        }
        eCApplySampleOrderListFragment$dealConfirmReceiveGoodsEvent$1 = new ECApplySampleOrderListFragment$dealConfirmReceiveGoodsEvent$1(this, continuation);
        Object obj2 = eCApplySampleOrderListFragment$dealConfirmReceiveGoodsEvent$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = eCApplySampleOrderListFragment$dealConfirmReceiveGoodsEvent$1.label;
        if (i3 != 0) {
        }
        return Unit.INSTANCE;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        cg0.a.b("ECApplySampleOrderListFragment", "onViewCreated, this=" + this);
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new ECApplySampleOrderListFragment$onViewCreated$$inlined$launchAndRepeatWithViewLifecycle$1(this, Lifecycle.State.STARTED, null, this), 3, null);
        Lifecycle.State state = Lifecycle.State.CREATED;
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new ECApplySampleOrderListFragment$onViewCreated$$inlined$launchAndRepeatWithViewLifecycle$2(this, state, null, this), 3, null);
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new ECApplySampleOrderListFragment$onViewCreated$$inlined$launchAndRepeatWithViewLifecycle$3(this, state, null, this), 3, null);
        hi();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Vh(String orderId, ECSelectProductAddWindowResponse addProductWindowResponse) {
        if (addProductWindowResponse == null) {
            i.e(i.f101155b, R.string.wo9, null, 0, 6, null);
            return;
        }
        a.b respMsgInfo = addProductWindowResponse.getRespMsgInfo();
        if (respMsgInfo != null && respMsgInfo.getDisplay()) {
            ECShowWindowAddProductRsp.INSTANCE.a(requireContext(), cj0.b.a(respMsgInfo));
            return;
        }
        k result = addProductWindowResponse.getResult();
        if (result != null && result.getCom.tencent.mobileqq.vas.api.RemoteProxy.KEY_RESULT_TYPE java.lang.String() == 1) {
            ki(orderId, addProductWindowResponse.getProductId());
            return;
        }
        i iVar = i.f101155b;
        StringBuilder sb5 = new StringBuilder();
        sb5.append(getString(R.string.wf8));
        k result2 = addProductWindowResponse.getResult();
        sb5.append(result2 != null ? result2.getCom.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_CAUSE java.lang.String() : null);
        i.f(iVar, sb5.toString(), ECToastIcon.ICON_ERROR, 0, 4, null);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        String str;
        View inflate = inflater.inflate(R.layout.csp, (ViewGroup) null);
        Bundle arguments = getArguments();
        Serializable serializable = arguments != null ? arguments.getSerializable("query_type") : null;
        if (!(serializable instanceof ECApplySampleQueryType)) {
            serializable = null;
        }
        ECApplySampleQueryType eCApplySampleQueryType = (ECApplySampleQueryType) serializable;
        if (eCApplySampleQueryType != null) {
            this.queryType = eCApplySampleQueryType;
            Bundle arguments2 = getArguments();
            if (arguments2 == null || (str = arguments2.getString("query_keyword")) == null) {
                str = "";
            }
            this.queryKeyword = str;
            Bundle arguments3 = getArguments();
            Serializable serializable2 = arguments3 != null ? arguments3.getSerializable("order_list_scene") : null;
            if (!(serializable2 instanceof OrderListScene)) {
                serializable2 = null;
            }
            OrderListScene orderListScene = (OrderListScene) serializable2;
            if (orderListScene == null) {
                orderListScene = OrderListScene.ORDER_LIST_PAGE;
            }
            this.scene = orderListScene;
            this.refreshLayout = (ECommercePullRefreshView) inflate.findViewById(R.id.o8o);
            ECStateCenterView eCStateCenterView = (ECStateCenterView) inflate.findViewById(R.id.oax);
            eCStateCenterView.setRetryListener(new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.orders.sampleorders.ECApplySampleOrderListFragment$onCreateView$$inlined$apply$lambda$1
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
                    ECApplySampleOrderListFragment.this.hi();
                }
            });
            IStateCenterView.a.c(eCStateCenterView, null, 1, null);
            Unit unit = Unit.INSTANCE;
            this.stateCenterView = eCStateCenterView;
            ECOrderListAdapter eCOrderListAdapter = new ECOrderListAdapter(requireContext(), "apply_sample_order_list");
            eCOrderListAdapter.o0(new Function3<String, JSONObject, Map<String, ? extends String>, Unit>() { // from class: com.tencent.ecommerce.biz.orders.sampleorders.ECApplySampleOrderListFragment$onCreateView$$inlined$apply$lambda$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(String str2, JSONObject jSONObject, Map<String, ? extends String> map) {
                    invoke2(str2, jSONObject, (Map<String, String>) map);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(String str2, JSONObject jSONObject, Map<String, String> map) {
                    Map map2;
                    map2 = ECApplySampleOrderListFragment.this.ptsEventTypeToHandler;
                    Function2 function2 = (Function2) map2.get(str2);
                    if (function2 != null) {
                    }
                    ECSampleOrderListReport.f103793b.i(str2, jSONObject);
                }
            });
            eCOrderListAdapter.n0(new Function1<ECOrderListItem, Unit>() { // from class: com.tencent.ecommerce.biz.orders.sampleorders.ECApplySampleOrderListFragment$onCreateView$3$2
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(ECOrderListItem eCOrderListItem) {
                    invoke2(eCOrderListItem);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(ECOrderListItem eCOrderListItem) {
                    ECSampleOrderListReport.f103793b.j(eCOrderListItem.getPtsJSONObject());
                }
            });
            this.adapter = eCOrderListAdapter;
            RecyclerView recyclerView = (RecyclerView) inflate.findViewById(R.id.o8m);
            recyclerView.setLayoutManager(new LinearLayoutManager(requireContext(), 1, false));
            ECOrderListAdapter eCOrderListAdapter2 = this.adapter;
            if (eCOrderListAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
            }
            recyclerView.setAdapter(eCOrderListAdapter2);
            ECommercePullRefreshView eCommercePullRefreshView = this.refreshLayout;
            if (eCommercePullRefreshView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
            }
            eCommercePullRefreshView.setOnRefreshStateListener(new b());
            return inflate;
        }
        cg0.a.a("ECApplySampleOrderListFragment", "onCreateView", "onCreateView, no arguments");
        return null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        String str;
        String stringExtra;
        if (resultCode == -1) {
            switch (requestCode) {
                case 1001:
                    Uh();
                    return;
                case 1002:
                case 1003:
                    String str2 = "";
                    if (data == null || (str = data.getStringExtra("bundle_key_token")) == null) {
                        str = "";
                    }
                    if (data != null && (stringExtra = data.getStringExtra("bundle_key_order_id")) != null) {
                        str2 = stringExtra;
                    }
                    ECAddress eCAddress = data != null ? (ECAddress) data.getParcelableExtra("bundle_key_result_address") : null;
                    if (eCAddress != null) {
                        di().S1(str2, str, eCAddress);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
