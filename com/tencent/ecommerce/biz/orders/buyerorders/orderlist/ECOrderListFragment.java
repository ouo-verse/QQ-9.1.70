package com.tencent.ecommerce.biz.orders.buyerorders.orderlist;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheLunarData;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.ecommerce.base.QQEcommerceSdk;
import com.tencent.ecommerce.base.eventbus.EventObserver;
import com.tencent.ecommerce.base.eventbus.LifecycleEventBus;
import com.tencent.ecommerce.base.eventbus.ThreadMode;
import com.tencent.ecommerce.base.list.IStateCenterView;
import com.tencent.ecommerce.base.list.ListViewModel;
import com.tencent.ecommerce.base.list.ListViewModelLazyKt$listViewModels$1;
import com.tencent.ecommerce.base.list.ListViewModelLazyKt$listViewModels$2;
import com.tencent.ecommerce.base.list.a;
import com.tencent.ecommerce.base.list.c;
import com.tencent.ecommerce.base.miniapp.api.IECMiniAppLauncher;
import com.tencent.ecommerce.base.ui.api.ECToastIcon;
import com.tencent.ecommerce.base.ui.refreshview.ECommercePullRefreshView;
import com.tencent.ecommerce.base.ui.stateview.ECStateCenterView;
import com.tencent.ecommerce.base.utils.ECThreadUtilKt;
import com.tencent.ecommerce.biz.comment.ECQShopCommentFragment;
import com.tencent.ecommerce.biz.comment.ECQShopReviewCommentFragment;
import com.tencent.ecommerce.biz.logistics.ECLogisticsTraceFragment;
import com.tencent.ecommerce.biz.orders.address.ECAddress;
import com.tencent.ecommerce.biz.orders.address.modifyorderaddress.ECModifyOrderAddressFragment;
import com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.ECOrderDetailOperation;
import com.tencent.ecommerce.biz.orders.buyerorders.submit.ECBlindBoxViewModel;
import com.tencent.ecommerce.biz.orders.span.ECOrderOperation;
import com.tencent.ecommerce.biz.orders.span.ECOrderSpan;
import com.tencent.ecommerce.biz.pay.api.IECPayApi;
import com.tencent.ecommerce.biz.router.ECScheme;
import com.tencent.ecommerce.biz.submitsucceed.ECSubmitSucceedFragment;
import com.tencent.ecommerce.biz.submitsucceed.SubmitSucceedFrom;
import com.tencent.ecommerce.biz.submitsucceed.SubmitSucceedUIState;
import com.tencent.ecommerce.biz.util.j;
import com.tencent.ecommerce.repo.ServiceLocator;
import com.tencent.ecommerce.repo.buyerorder.orderlist.ECOrderListExtraInfo;
import com.tencent.ecommerce.repo.buyerorder.orderlist.ECOrderListItem;
import com.tencent.ecommerce.repo.buyerorder.orderlist.ECOrderListRequestInfo;
import com.tencent.ecommerce.repo.buyerorder.orderlist.ECQueryType;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.qmethod.pandoraex.monitor.ClipboardMonitor;
import com.tencent.qqlive.module.videoreport.dtreport.api.DefaultTVKDataProvider;
import com.tencent.qqmini.sdk.plugins.SensorJsPlugin;
import cooperation.qzone.QzoneIPCModule;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import mqq.app.Constants;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00e4\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u008f\u00012\u00020\u0001:\u0002\u0090\u0001B\t\u00a2\u0006\u0006\b\u008d\u0001\u0010\u008e\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\u0007H\u0002J\u001c\u0010\u000e\u001a\u00020\u00072\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nH\u0002J.\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\u001c\u0010\u0016\u001a\u00020\u00072\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nH\u0002J\b\u0010\u0017\u001a\u00020\u0007H\u0002J\b\u0010\u0018\u001a\u00020\u0007H\u0002J\b\u0010\u0019\u001a\u00020\u0007H\u0002J$\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u001a2\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u001cH\u0002J$\u0010\u001f\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u001a2\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u001cH\u0002J$\u0010 \u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u001a2\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u001cH\u0002J\u0010\u0010\"\u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u0004H\u0002J$\u0010#\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u001a2\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u001cH\u0002J$\u0010$\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u001a2\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u001cH\u0002J$\u0010%\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u001a2\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u001cH\u0002J$\u0010&\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u001a2\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u001cH\u0002J$\u0010'\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u001a2\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u001cH\u0002J$\u0010(\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u001a2\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u001cH\u0002J$\u0010)\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u001a2\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u001cH\u0002J$\u0010*\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u001a2\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u001cH\u0002J$\u0010+\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u001a2\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u001cH\u0002J$\u0010,\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u001a2\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u001cH\u0002J\u0018\u0010.\u001a\u00020-*\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u001cH\u0002J\u0012\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00040\u0010*\u00020\u001aH\u0002J&\u00107\u001a\u0004\u0018\u0001062\u0006\u00101\u001a\u0002002\b\u00103\u001a\u0004\u0018\u0001022\b\u00105\u001a\u0004\u0018\u000104H\u0016J\u001a\u00109\u001a\u00020\u00072\u0006\u00108\u001a\u0002062\b\u00105\u001a\u0004\u0018\u000104H\u0016J\b\u0010:\u001a\u00020\u0007H\u0016J\"\u0010@\u001a\u00020\u00072\u0006\u0010<\u001a\u00020;2\u0006\u0010=\u001a\u00020;2\b\u0010?\u001a\u0004\u0018\u00010>H\u0016J3\u0010F\u001a\u00020-2\u0006\u0010B\u001a\u00020A2\u0006\u0010C\u001a\u00020\u001a2\u0006\u0010D\u001a\u00020\u001a2\u0006\u0010E\u001a\u00020\u0004H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\bF\u0010GJ\u001b\u0010I\u001a\u00020-2\u0006\u0010H\u001a\u00020\u001aH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\bI\u0010JJ\u001b\u0010K\u001a\u00020-2\u0006\u0010H\u001a\u00020\u001aH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\bK\u0010JR\u0016\u0010O\u001a\u00020L8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bM\u0010NR\u0016\u0010S\u001a\u00020P8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bQ\u0010RR\u0016\u0010W\u001a\u00020T8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bU\u0010VR\u0016\u0010[\u001a\u00020X8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bY\u0010ZR\u0016\u0010^\u001a\u00020\u00048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\\\u0010]R\u0016\u0010`\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b_\u0010]R\u001b\u0010f\u001a\u00020a8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bb\u0010c\u001a\u0004\bd\u0010eR\u001b\u0010k\u001a\u00020g8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bh\u0010c\u001a\u0004\bi\u0010jR\u0016\u0010n\u001a\u00020-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bl\u0010mR\u0016\u0010r\u001a\u00020o8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bp\u0010qR\u0016\u0010t\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bs\u0010]R\\\u0010z\u001aJ\u0012\u0004\u0012\u00020\u0004\u0012@\u0012>\u0012\u0013\u0012\u00110\u001a\u00a2\u0006\f\bv\u0012\b\bw\u0012\u0004\b\b(\u001b\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u001c\u00a2\u0006\f\bv\u0012\b\bw\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u00070u0\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bx\u0010yR.\u0010\u0080\u0001\u001a\u0014\u0012\u0004\u0012\u00020|\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0{8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b}\u0010c\u001a\u0004\b~\u0010\u007fR,\u0010\u0088\u0001\u001a\u0005\u0018\u00010\u0081\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u0082\u0001\u0010\u0083\u0001\u001a\u0006\b\u0084\u0001\u0010\u0085\u0001\"\u0006\b\u0086\u0001\u0010\u0087\u0001R\u001c\u0010\u008c\u0001\u001a\u0005\u0018\u00010\u0089\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u008a\u0001\u0010\u008b\u0001\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0091\u0001"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/buyerorders/orderlist/ECOrderListFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/tencent/ecommerce/biz/pay/api/IECPayApi$b;", "payResult", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ORDER_ID, "spuId", "", "Yh", "ti", "Lcom/tencent/ecommerce/base/list/h;", "Lcom/tencent/ecommerce/repo/buyerorder/orderlist/b;", "Lcom/tencent/ecommerce/repo/buyerorder/orderlist/a;", "state", "Zh", "result", "", "spuIds", "", "payPriceInFen", "pi", "uiState", "wi", "ni", "oi", "ri", "Lorg/json/JSONObject;", "itemJSONObject", "", "dataMap", "ii", "bi", "ai", "url", "ki", "Uh", "qi", WidgetCacheLunarData.YI, "ci", "xi", "Vh", "Wh", "vi", "Xh", "hi", "", WidgetCacheLunarData.JI, "gi", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Landroid/view/View;", "onCreateView", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "onResume", "", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", "Lorg/json/JSONArray;", "priorityArray", "wxMiniAppLinkInfo", "qqMiniAppLinkInfo", "h5Url", SensorJsPlugin.SENSOR_INTERVAL_UI, "(Lorg/json/JSONArray;Lorg/json/JSONObject;Lorg/json/JSONObject;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "linkInfo", "mi", "(Lorg/json/JSONObject;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "li", "Lcom/tencent/ecommerce/base/ui/refreshview/ECommercePullRefreshView;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/ecommerce/base/ui/refreshview/ECommercePullRefreshView;", "refreshLayout", "Lcom/tencent/ecommerce/base/ui/stateview/ECStateCenterView;", "D", "Lcom/tencent/ecommerce/base/ui/stateview/ECStateCenterView;", "stateCenterView", "Lcom/tencent/ecommerce/biz/orders/buyerorders/orderlist/ECOrderListAdapter;", "E", "Lcom/tencent/ecommerce/biz/orders/buyerorders/orderlist/ECOrderListAdapter;", "adapter", "Lcom/tencent/ecommerce/repo/buyerorder/orderlist/ECQueryType;", UserInfo.SEX_FEMALE, "Lcom/tencent/ecommerce/repo/buyerorder/orderlist/ECQueryType;", "queryType", "G", "Ljava/lang/String;", "queryKeyword", "H", "token", "Lcom/tencent/ecommerce/biz/orders/buyerorders/orderlist/ECOrderListOperateViewModel;", "I", "Lkotlin/Lazy;", "fi", "()Lcom/tencent/ecommerce/biz/orders/buyerorders/orderlist/ECOrderListOperateViewModel;", "operateViewModel", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/ECBlindBoxViewModel;", "J", "di", "()Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/ECBlindBoxViewModel;", "blindBoxViewModel", "K", "Z", "hasLoadDataOnResume", "Lcom/tencent/ecommerce/biz/orders/buyerorders/orderlist/OrderListScene;", "L", "Lcom/tencent/ecommerce/biz/orders/buyerorders/orderlist/OrderListScene;", "scene", "M", "fromScene", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "N", "Ljava/util/Map;", "ptsEventTypeToHandler", "Lcom/tencent/ecommerce/base/list/ListViewModel;", "Lcom/tencent/ecommerce/repo/buyerorder/orderlist/c;", "P", "ei", "()Lcom/tencent/ecommerce/base/list/ListViewModel;", "listViewModel", "Lcom/tencent/ecommerce/biz/orders/buyerorders/orderlist/OrderListUiCallback;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/tencent/ecommerce/biz/orders/buyerorders/orderlist/OrderListUiCallback;", "getOrderListUiCallback", "()Lcom/tencent/ecommerce/biz/orders/buyerorders/orderlist/OrderListUiCallback;", "si", "(Lcom/tencent/ecommerce/biz/orders/buyerorders/orderlist/OrderListUiCallback;)V", "orderListUiCallback", "Lcom/tencent/ecommerce/base/ui/d;", BdhLogUtil.LogTag.Tag_Req, "Lcom/tencent/ecommerce/base/ui/d;", "loadingDialog", "<init>", "()V", ExifInterface.LATITUDE_SOUTH, "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECOrderListFragment extends Fragment {

    /* renamed from: S, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    private ECommercePullRefreshView refreshLayout;

    /* renamed from: D, reason: from kotlin metadata */
    private ECStateCenterView stateCenterView;

    /* renamed from: E, reason: from kotlin metadata */
    private ECOrderListAdapter adapter;

    /* renamed from: F, reason: from kotlin metadata */
    private ECQueryType queryType;

    /* renamed from: G, reason: from kotlin metadata */
    private String queryKeyword;

    /* renamed from: H, reason: from kotlin metadata */
    private String token = "";

    /* renamed from: I, reason: from kotlin metadata */
    private final Lazy operateViewModel;

    /* renamed from: J, reason: from kotlin metadata */
    private final Lazy blindBoxViewModel;

    /* renamed from: K, reason: from kotlin metadata */
    private boolean hasLoadDataOnResume;

    /* renamed from: L, reason: from kotlin metadata */
    private OrderListScene scene;

    /* renamed from: M, reason: from kotlin metadata */
    private String fromScene;

    /* renamed from: N, reason: from kotlin metadata */
    private final Map<String, Function2<JSONObject, Map<String, String>, Unit>> ptsEventTypeToHandler;

    /* renamed from: P, reason: from kotlin metadata */
    private final Lazy listViewModel;

    /* renamed from: Q, reason: from kotlin metadata */
    private OrderListUiCallback orderListUiCallback;

    /* renamed from: R, reason: from kotlin metadata */
    private com.tencent.ecommerce.base.ui.d loadingDialog;

    /* compiled from: P */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000e\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001c\u0010\u001dJ,\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u0004R\u0014\u0010\u000b\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\u00108\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\r8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u000fR\u0014\u0010\u0014\u001a\u00020\r8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u000fR\u0014\u0010\u0015\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\fR\u0014\u0010\u0016\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\fR\u0014\u0010\u0017\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\fR\u0014\u0010\u0018\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\fR\u0014\u0010\u0019\u001a\u00020\r8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u000fR\u0014\u0010\u001a\u001a\u00020\r8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u000fR\u0014\u0010\u001b\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\f\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/buyerorders/orderlist/ECOrderListFragment$a;", "", "Lcom/tencent/ecommerce/repo/buyerorder/orderlist/ECQueryType;", "type", "", "searchQuery", "Lcom/tencent/ecommerce/biz/orders/buyerorders/orderlist/OrderListScene;", "scene", "fromScene", "Lcom/tencent/ecommerce/biz/orders/buyerorders/orderlist/ECOrderListFragment;", "a", "FROM_SCENE", "Ljava/lang/String;", "", "GOOD_TYPE_Q_SHOP", "I", "", "HIDE_DIALOG_TIME_MS", "J", "LINK_QQ_MINI_PROGRAM", "LINK_WECHAT_MINI_PROGRAM", "ORDER_LIST_SCENE", "PTS_PAGE_NAME", "QUERY_KEYWORD", "QUERY_TYPE", "REQUEST_CODE_MODIFY_ADDRESS_FROM_ORDER_LIST", "REQUEST_CODE_MODIFY_ADDRESS_FROM_SEARCH", "TAG", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.biz.orders.buyerorders.orderlist.ECOrderListFragment$a, reason: from kotlin metadata */
    /* loaded from: classes31.dex */
    public static final class Companion {
        Companion() {
        }

        public final ECOrderListFragment a(ECQueryType type, String searchQuery, OrderListScene scene, String fromScene) {
            ECOrderListFragment eCOrderListFragment = new ECOrderListFragment();
            Bundle bundle = new Bundle();
            bundle.putSerializable("query_type", type);
            bundle.putSerializable("query_keyword", searchQuery);
            bundle.putSerializable("order_list_scene", scene);
            bundle.putString("from_scene", fromScene);
            Unit unit = Unit.INSTANCE;
            eCOrderListFragment.setArguments(bundle);
            return eCOrderListFragment;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ ECOrderListFragment b(Companion companion, ECQueryType eCQueryType, String str, OrderListScene orderListScene, String str2, int i3, Object obj) {
            if ((i3 & 2) != 0) {
                str = "";
            }
            if ((i3 & 4) != 0) {
                orderListScene = OrderListScene.ORDER_LIST_PAGE;
            }
            if ((i3 & 8) != 0) {
                str2 = "";
            }
            return companion.a(eCQueryType, str, orderListScene, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n\u00a2\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "isSuccess", "", "<anonymous parameter 1>", "Landroid/os/Bundle;", "onLaunchResult"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class b implements IECMiniAppLauncher.LaunchListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CancellableContinuation f103388a;

        b(CancellableContinuation cancellableContinuation) {
            this.f103388a = cancellableContinuation;
        }

        @Override // com.tencent.ecommerce.base.miniapp.api.IECMiniAppLauncher.LaunchListener
        public final void onLaunchResult(boolean z16, Bundle bundle) {
            this.f103388a.resumeWith(Result.m476constructorimpl(Boolean.valueOf(z16)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n\u00a2\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "isSuccess", "", "<anonymous parameter 1>", "Landroid/os/Bundle;", "onLaunchResult"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class c implements IECMiniAppLauncher.LaunchListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CancellableContinuation f103389a;

        c(CancellableContinuation cancellableContinuation) {
            this.f103389a = cancellableContinuation;
        }

        @Override // com.tencent.ecommerce.base.miniapp.api.IECMiniAppLauncher.LaunchListener
        public final void onLaunchResult(boolean z16, Bundle bundle) {
            this.f103389a.resumeWith(Result.m476constructorimpl(Boolean.valueOf(z16)));
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\u0007\u00b8\u0006\u0000"}, d2 = {"com/tencent/ecommerce/biz/orders/buyerorders/orderlist/ECOrderListFragment$onCreateView$4$1", "Lcom/tencent/ecommerce/base/ui/refreshview/ECommercePullRefreshView$OnRefreshStateListener;", "", "tag", "", "onRefreshBegin", "onLoadMoreBegin", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class d implements ECommercePullRefreshView.OnRefreshStateListener {
        d() {
        }

        @Override // com.tencent.ecommerce.base.ui.refreshview.ECommercePullRefreshView.OnRefreshStateListener
        public void onLoadMoreBegin() {
            ECOrderListFragment.this.oi();
        }

        @Override // com.tencent.ecommerce.base.ui.refreshview.ECommercePullRefreshView.OnRefreshStateListener
        public void onRefreshBegin(int tag) {
            ECOrderListFragment.this.ri();
        }

        @Override // com.tencent.ecommerce.base.ui.refreshview.ECommercePullRefreshView.OnRefreshStateListener
        public void onRefreshFinished(boolean z16, int i3) {
            ECommercePullRefreshView.OnRefreshStateListener.a.a(this, z16, i3);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/tencent/ecommerce/biz/comment/ECQShopCommentFragment$b;", "it", "", "a", "(Lcom/tencent/ecommerce/biz/comment/ECQShopCommentFragment$b;)V"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    static final class e<T> implements EventObserver<ECQShopCommentFragment.b> {
        e() {
        }

        @Override // com.tencent.ecommerce.base.eventbus.EventObserver
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onEvent(ECQShopCommentFragment.b bVar) {
            ECOrderListFragment.this.ni();
        }
    }

    public ECOrderListFragment() {
        Map<String, Function2<JSONObject, Map<String, String>, Unit>> mapOf;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.tencent.ecommerce.biz.orders.buyerorders.orderlist.ECOrderListFragment$$special$$inlined$viewModels$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        this.operateViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(ECOrderListOperateViewModel.class), new Function0<ViewModelStore>() { // from class: com.tencent.ecommerce.biz.orders.buyerorders.orderlist.ECOrderListFragment$$special$$inlined$viewModels$2
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
        final Function0<Fragment> function02 = new Function0<Fragment>() { // from class: com.tencent.ecommerce.biz.orders.buyerorders.orderlist.ECOrderListFragment$$special$$inlined$viewModels$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        this.blindBoxViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(ECBlindBoxViewModel.class), new Function0<ViewModelStore>() { // from class: com.tencent.ecommerce.biz.orders.buyerorders.orderlist.ECOrderListFragment$$special$$inlined$viewModels$4
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
        this.scene = OrderListScene.ORDER_LIST_PAGE;
        this.fromScene = "";
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("allInOneJump", new ECOrderListFragment$ptsEventTypeToHandler$1(this)), TuplesKt.to("enterShopPage", new ECOrderListFragment$ptsEventTypeToHandler$2(this)), TuplesKt.to("enterOrderDetailPage", new ECOrderListFragment$ptsEventTypeToHandler$3(this)), TuplesKt.to("buyAgain", new ECOrderListFragment$ptsEventTypeToHandler$4(this)), TuplesKt.to("payGoods", new ECOrderListFragment$ptsEventTypeToHandler$5(this)), TuplesKt.to("viewShipping", new ECOrderListFragment$ptsEventTypeToHandler$6(this)), TuplesKt.to("evaluateGoods", new ECOrderListFragment$ptsEventTypeToHandler$7(this)), TuplesKt.to("viewComment", new ECOrderListFragment$ptsEventTypeToHandler$8(this)), TuplesKt.to("cancelOrder", new ECOrderListFragment$ptsEventTypeToHandler$9(this)), TuplesKt.to("confirmReceiveGoods", new ECOrderListFragment$ptsEventTypeToHandler$10(this)), TuplesKt.to("updateAddress", new ECOrderListFragment$ptsEventTypeToHandler$11(this)), TuplesKt.to("copyOrderId", new ECOrderListFragment$ptsEventTypeToHandler$12(this)), TuplesKt.to("goDeliveryGoods", new ECOrderListFragment$ptsEventTypeToHandler$13(this)));
        this.ptsEventTypeToHandler = mapOf;
        this.listViewModel = new ViewModelLazy(Reflection.getOrCreateKotlinClass(ListViewModel.class), new ListViewModelLazyKt$listViewModels$1(this), new ListViewModelLazyKt$listViewModels$2(new com.tencent.ecommerce.base.list.d(ServiceLocator.f104891i.j())));
    }

    public static final /* synthetic */ ECommercePullRefreshView Eh(ECOrderListFragment eCOrderListFragment) {
        ECommercePullRefreshView eCommercePullRefreshView = eCOrderListFragment.refreshLayout;
        if (eCommercePullRefreshView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
        }
        return eCommercePullRefreshView;
    }

    public static final /* synthetic */ ECStateCenterView Gh(ECOrderListFragment eCOrderListFragment) {
        ECStateCenterView eCStateCenterView = eCOrderListFragment.stateCenterView;
        if (eCStateCenterView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stateCenterView");
        }
        return eCStateCenterView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Uh(final JSONObject itemJSONObject, Map<String, String> dataMap) {
        if (ji(dataMap)) {
            cg0.a.a("OrderListFragment", "buyAgain", "q_shop not support bug Again");
            return;
        }
        String str = dataMap.get("productId");
        String str2 = dataMap.get("sellerId");
        if (!(str == null || str.length() == 0)) {
            if (!(str2 == null || str2.length() == 0)) {
                com.tencent.ecommerce.repo.buyerorder.a.f104991a.b(str, str2, itemJSONObject.toString(), new Function3<Integer, String, String, Unit>() { // from class: com.tencent.ecommerce.biz.orders.buyerorders.orderlist.ECOrderListFragment$buyAgain$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(Integer num, String str3, String str4) {
                        invoke(num.intValue(), str3, str4);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(int i3, String str3, String str4) {
                        OrderListScene orderListScene;
                        cg0.a.b("OrderListFragment", "getBuyAgainLink, code=" + i3);
                        if (str3.length() > 0) {
                            ECScheme.g(str3, null, 2, null);
                        } else {
                            com.tencent.ecommerce.base.ui.i.e(com.tencent.ecommerce.base.ui.i.f101155b, R.string.wgl, ECToastIcon.ICON_ERROR, 0, 4, null);
                        }
                        ECOrderSpan eCOrderSpan = ECOrderSpan.f103884c;
                        String optString = itemJSONObject.optString("order_id");
                        orderListScene = ECOrderListFragment.this.scene;
                        ECOrderSpan.c(eCOrderSpan, optString, g.a(orderListScene), ECOrderOperation.BuyAgain, new ECOrderSpan.OrderRequestInfo(i3, str4), null, 16, null);
                    }
                });
                return;
            }
        }
        cg0.a.a("OrderListFragment", "buyAgain", "product params error, productId: " + str + ", sellerId: " + str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Vh(final JSONObject itemJSONObject, Map<String, String> dataMap) {
        com.tencent.ecommerce.base.ui.g gVar = new com.tencent.ecommerce.base.ui.g(requireActivity());
        gVar.Y(requireContext().getString(R.string.wi8));
        gVar.Z(17);
        gVar.e0(new Function1<View, Unit>() { // from class: com.tencent.ecommerce.biz.orders.buyerorders.orderlist.ECOrderListFragment$cancelOrder$$inlined$apply$lambda$1
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
                ECOrderListOperateViewModel fi5;
                String str;
                OrderListScene orderListScene;
                fi5 = ECOrderListFragment.this.fi();
                String optString = itemJSONObject.optString("order_id");
                str = ECOrderListFragment.this.token;
                orderListScene = ECOrderListFragment.this.scene;
                fi5.S1(optString, str, orderListScene);
            }
        });
        gVar.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Wh(final JSONObject itemJSONObject, Map<String, String> dataMap) {
        com.tencent.ecommerce.base.ui.g gVar = new com.tencent.ecommerce.base.ui.g(requireActivity());
        gVar.Y(requireContext().getString(R.string.wie));
        gVar.Z(3);
        gVar.e0(new Function1<View, Unit>() { // from class: com.tencent.ecommerce.biz.orders.buyerorders.orderlist.ECOrderListFragment$confirmReceiveGoods$$inlined$apply$lambda$1
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
                ECOrderListOperateViewModel fi5;
                String str;
                OrderListScene orderListScene;
                fi5 = ECOrderListFragment.this.fi();
                String optString = itemJSONObject.optString("order_id");
                str = ECOrderListFragment.this.token;
                orderListScene = ECOrderListFragment.this.scene;
                fi5.T1(optString, str, orderListScene);
            }
        });
        gVar.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Xh(JSONObject itemJSONObject, Map<String, String> dataMap) {
        String str = dataMap.get("displayOrderId");
        if (str == null) {
            str = "";
        }
        if (str.length() == 0) {
            cg0.a.a("OrderListFragment", "copyOrderId", "orderId is empty");
            com.tencent.ecommerce.base.ui.i.f101155b.d(getString(R.string.f169650wu4), ECToastIcon.ICON_ERROR, 0);
            return;
        }
        Object systemService = wg0.a.a().getSystemService("clipboard");
        if (systemService != null) {
            ClipboardMonitor.setPrimaryClip((ClipboardManager) systemService, ClipData.newPlainText("displayOrderId", str));
            com.tencent.ecommerce.base.ui.i.f101155b.d(getString(R.string.wu5), ECToastIcon.ICON_SUCCESS, 0);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.content.ClipboardManager");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Yh(IECPayApi.PayResult payResult, String orderId, String spuId) {
        com.tencent.ecommerce.base.ui.d dVar = new com.tencent.ecommerce.base.ui.d(requireContext(), null, 2, null);
        dVar.show();
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new ECOrderListFragment$dealBlindBoxPayResult$1(this, payResult, orderId, spuId, dVar, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Zh(com.tencent.ecommerce.base.list.h<ECOrderListItem, ECOrderListExtraInfo> state) {
        OrderListUiCallback orderListUiCallback;
        if (Intrinsics.areEqual(state.listUiState, c.e.f100781a)) {
            OrderListUiCallback orderListUiCallback2 = this.orderListUiCallback;
            if (orderListUiCallback2 != null) {
                ECQueryType eCQueryType = this.queryType;
                if (eCQueryType == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("queryType");
                }
                orderListUiCallback2.onCenterFailed(eCQueryType);
                return;
            }
            return;
        }
        if ((Intrinsics.areEqual(state.listUiState, c.g.f100783a) || Intrinsics.areEqual(state.listUiState, c.d.f100780a)) && (orderListUiCallback = this.orderListUiCallback) != null) {
            ECQueryType eCQueryType2 = this.queryType;
            if (eCQueryType2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("queryType");
            }
            orderListUiCallback.onCenterSuccess(eCQueryType2, Intrinsics.areEqual(state.dataCacheLevel, a.b.f100773a) || Intrinsics.areEqual(state.dataCacheLevel, a.C1030a.f100772a));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ai(JSONObject itemJSONObject, Map<String, String> dataMap) {
        String str = dataMap.get("linkInfo");
        if (cg0.a.c()) {
            cg0.a.b("OrderListFragment", "enterOrderDetailPage, linkInfoStr=" + str);
        }
        if (str == null || str.length() == 0) {
            cg0.a.a("OrderListFragment", "enterOrderDetailPage", "linkInfoStr isNullOrEmpty");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            ECOrderListReporter.f103395b.v(itemJSONObject);
            JSONArray optJSONArray = jSONObject.optJSONArray("priority");
            String optString = jSONObject.optString("h5_url");
            if (optJSONArray != null && optJSONArray.length() != 0) {
                JSONObject optJSONObject = jSONObject.optJSONObject("wechat_link_info");
                if (optJSONObject == null) {
                    optJSONObject = new JSONObject();
                }
                JSONObject jSONObject2 = optJSONObject;
                JSONObject optJSONObject2 = jSONObject.optJSONObject("qq_link_info");
                if (optJSONObject2 == null) {
                    optJSONObject2 = new JSONObject();
                }
                JSONObject jSONObject3 = optJSONObject2;
                com.tencent.ecommerce.base.ui.d dVar = new com.tencent.ecommerce.base.ui.d(requireContext(), null, 2, null);
                dVar.show();
                Unit unit = Unit.INSTANCE;
                this.loadingDialog = dVar;
                BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new ECOrderListFragment$enterOrderDetailPage$2(this, optJSONArray, jSONObject2, jSONObject3, optString, null), 3, null);
                return;
            }
            ki(optString);
        } catch (JSONException e16) {
            cg0.a.a("OrderListFragment", "enterOrderDetailPage", "parse linkInfoStr exception, e=" + e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void bi(JSONObject itemJSONObject, Map<String, String> dataMap) {
        String str = dataMap.get(WadlProxyConsts.KEY_JUMP_URL);
        if (str == null || str.length() == 0) {
            cg0.a.a("OrderListFragment", "enterShopPage", "schema isNullOrEmpty");
        } else {
            ECOrderListReporter.f103395b.D(itemJSONObject);
            ECScheme.g(str, null, 2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ci(JSONObject itemJSONObject, Map<String, String> dataMap) {
        JSONArray jSONArray;
        String str;
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        JSONArray optJSONArray = itemJSONObject.optJSONArray("product_carts");
        JSONObject optJSONObject3 = (optJSONArray == null || (optJSONObject2 = optJSONArray.optJSONObject(0)) == null) ? null : optJSONObject2.optJSONObject("order_sku");
        JSONObject optJSONObject4 = optJSONObject3 != null ? optJSONObject3.optJSONObject("sku") : null;
        JSONObject optJSONObject5 = optJSONObject3 != null ? optJSONObject3.optJSONObject("spu") : null;
        if (optJSONObject4 != null && optJSONObject5 != null) {
            JSONObject optJSONObject6 = optJSONObject4.optJSONObject("spec");
            if (optJSONObject6 == null || (jSONArray = optJSONObject6.optJSONArray("items")) == null) {
                jSONArray = new JSONArray();
            }
            ArrayList<String> arrayList = new ArrayList<>();
            int length = jSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                String optString = jSONArray.optJSONObject(i3).optString("value");
                if (optString.length() > 0) {
                    arrayList.add(optString);
                }
            }
            ECQShopCommentFragment.Companion companion = ECQShopCommentFragment.INSTANCE;
            Context requireContext = requireContext();
            String optString2 = itemJSONObject.optString("order_id");
            String optString3 = optJSONObject4.optString("sku_id");
            String optString4 = optJSONObject5.optString("spu_id");
            String optString5 = optJSONObject5.optString("title");
            JSONArray optJSONArray2 = optJSONObject4.optJSONArray("preview_pics");
            if (optJSONArray2 == null || (optJSONObject = optJSONArray2.optJSONObject(0)) == null || (str = optJSONObject.optString("url")) == null) {
                str = "";
            }
            companion.a(requireContext, optString2, optString3, optString4, optString5, str, arrayList);
            return;
        }
        cg0.a.a("OrderListFragment", "evaluateGoods", "item data error. skuObject is null or spuObject is null");
        com.tencent.ecommerce.base.ui.i.f101155b.c(R.string.wvb, ECToastIcon.ICON_ERROR, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ECBlindBoxViewModel di() {
        return (ECBlindBoxViewModel) this.blindBoxViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ListViewModel<ECOrderListRequestInfo, ECOrderListItem, ECOrderListExtraInfo> ei() {
        return (ListViewModel) this.listViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ECOrderListOperateViewModel fi() {
        return (ECOrderListOperateViewModel) this.operateViewModel.getValue();
    }

    private final List<String> gi(JSONObject jSONObject) {
        JSONObject optJSONObject;
        String optString;
        ArrayList arrayList = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("product_carts");
        if (optJSONArray != null) {
            int length = optJSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                JSONObject optJSONObject2 = optJSONArray.optJSONObject(i3);
                if (optJSONObject2 == null) {
                    break;
                }
                JSONObject optJSONObject3 = optJSONObject2.optJSONObject("order_sku");
                if (optJSONObject3 != null && (optJSONObject = optJSONObject3.optJSONObject("sku")) != null && (optString = optJSONObject.optString("spu_id")) != null) {
                    arrayList.add(optString);
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void hi(JSONObject itemJSONObject, Map<String, String> dataMap) {
        String str = dataMap.get("linkInfo");
        if (cg0.a.c()) {
            cg0.a.b("OrderListFragment", "goDeliveryGoods, linkInfoStr=" + str);
        }
        if (str == null || str.length() == 0) {
            cg0.a.a("OrderListFragment", "goDeliveryGoods", "linkInfoStr isNullOrEmpty");
        } else {
            ECScheme.g(str, null, 2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ii(JSONObject itemJSONObject, Map<String, String> dataMap) {
        String str = dataMap.get(WadlProxyConsts.KEY_JUMP_URL);
        if (str == null || str.length() == 0) {
            cg0.a.a("OrderListFragment", "handlePtsJumpAction", "schema isNullOrEmpty");
        } else {
            ECScheme.g(str, null, 2, null);
        }
    }

    private final boolean ji(Map<String, String> map) {
        return Intrinsics.areEqual(map.get("goodsType"), "101");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ki(String url) {
        cg0.a.b("OrderListFragment", "jumpToH5: url:" + url);
        if (!Intrinsics.areEqual(url, "")) {
            ECScheme.g(url, null, 2, null);
        } else {
            com.tencent.ecommerce.base.ui.i.f101155b.d("\u6682\u4e0d\u652f\u6301\u8df3\u8f6c", ECToastIcon.ICON_ERROR, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ni() {
        ListViewModel<ECOrderListRequestInfo, ECOrderListItem, ECOrderListExtraInfo> ei5 = ei();
        String str = this.queryKeyword;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("queryKeyword");
        }
        ECQueryType eCQueryType = this.queryType;
        if (eCQueryType == null) {
            Intrinsics.throwUninitializedPropertyAccessException("queryType");
        }
        ei5.X1(new ECOrderListRequestInfo(str, eCQueryType, this.fromScene));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void oi() {
        ListViewModel<ECOrderListRequestInfo, ECOrderListItem, ECOrderListExtraInfo> ei5 = ei();
        String str = this.queryKeyword;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("queryKeyword");
        }
        ECQueryType eCQueryType = this.queryType;
        if (eCQueryType == null) {
            Intrinsics.throwUninitializedPropertyAccessException("queryType");
        }
        ei5.Z1(new ECOrderListRequestInfo(str, eCQueryType, this.fromScene));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void pi(IECPayApi.PayResult result, String orderId, List<String> spuIds, long payPriceInFen) {
        com.tencent.ecommerce.base.ui.i.f101155b.c(R.string.f169621wp0, ECToastIcon.ICON_SUCCESS, 0);
        fi().a2(orderId);
        SubmitSucceedUIState submitSucceedUIState = new SubmitSucceedUIState(getString(R.string.f169621wp0), getString(R.string.f169622wp1, com.tencent.ecommerce.biz.orders.buyerorders.submit.model.i.a(result).name(requireContext()), j.f104870a.a(payPriceInFen)), getString(R.string.wrr));
        ECSubmitSucceedFragment.Companion companion = ECSubmitSucceedFragment.INSTANCE;
        Context requireContext = requireContext();
        SubmitSucceedFrom submitSucceedFrom = SubmitSucceedFrom.PAY_IN_SUBMIT_ORDER;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("order_id", orderId);
        Unit unit = Unit.INSTANCE;
        companion.a(requireContext, submitSucceedUIState, submitSucceedFrom, spuIds, jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void qi(JSONObject itemJSONObject, Map<String, String> dataMap) {
        String str;
        if (cg0.a.c()) {
            cg0.a.b("OrderListFragment", "payGoods, dataMap=" + dataMap);
        }
        if (ji(dataMap)) {
            String optString = itemJSONObject.optString("order_id");
            String optString2 = itemJSONObject.optString("pay_url_params");
            long optLong = itemJSONObject.optLong("order_price");
            List<String> gi5 = gi(itemJSONObject);
            int optInt = itemJSONObject.optInt("trade_type");
            int optInt2 = itemJSONObject.optInt(DefaultTVKDataProvider.KEY_PAY_TYPE, 2);
            StringBuilder sb5 = new StringBuilder();
            sb5.append("pay qshop order: id = ");
            sb5.append(optString);
            if (cg0.a.c()) {
                str = "params: " + optString2;
            } else {
                str = "";
            }
            sb5.append(str);
            cg0.a.b("OrderListFragment", sb5.toString());
            fi().b2(optString, optString2, optLong, gi5, optInt, optInt2);
            return;
        }
        ai(itemJSONObject, dataMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ri() {
        ListViewModel<ECOrderListRequestInfo, ECOrderListItem, ECOrderListExtraInfo> ei5 = ei();
        String str = this.queryKeyword;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("queryKeyword");
        }
        ECQueryType eCQueryType = this.queryType;
        if (eCQueryType == null) {
            Intrinsics.throwUninitializedPropertyAccessException("queryType");
        }
        ei5.a2(new ECOrderListRequestInfo(str, eCQueryType, this.fromScene));
    }

    private final void ti() {
        ECThreadUtilKt.e(800L, new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.orders.buyerorders.orderlist.ECOrderListFragment$tryHideLoadingDialog$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX WARN: Code restructure failed: missing block: B:5:0x000f, code lost:
            
                r0 = r2.this$0.loadingDialog;
             */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void invoke2() {
                com.tencent.ecommerce.base.ui.d dVar;
                com.tencent.ecommerce.base.ui.d dVar2;
                dVar = ECOrderListFragment.this.loadingDialog;
                if (dVar == null || !dVar.isShowing() || dVar2 == null) {
                    return;
                }
                dVar2.cancel();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void vi(JSONObject itemJSONObject, Map<String, String> dataMap) {
        Long longOrNull;
        int i3;
        longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(itemJSONObject.optString("update_address_deadline"));
        if ((longOrNull != null ? longOrNull.longValue() : 0L) * 1000 < System.currentTimeMillis()) {
            ECOrderDetailOperation.c(ECOrderDetailOperation.f103235a, requireContext(), "\u4f60\u5df2\u8d85\u8fc7\u4fee\u6539\u5730\u5740\u65f6\u6548", null, 4, null);
            return;
        }
        final String optString = itemJSONObject.optString("order_id");
        JSONObject optJSONObject = itemJSONObject.optJSONObject("address");
        ECAddress a16 = optJSONObject == null ? null : ECAddress.INSTANCE.a(optJSONObject);
        StringBuilder sb5 = new StringBuilder();
        sb5.append("startFetchAddress, id= ");
        sb5.append(a16 != null ? Long.valueOf(a16.id) : null);
        cg0.a.b("OrderListFragment", sb5.toString());
        if (a16 == null) {
            com.tencent.ecommerce.biz.orders.address.c.e(4, null, new Function1<ECAddress, Unit>() { // from class: com.tencent.ecommerce.biz.orders.buyerorders.orderlist.ECOrderListFragment$updateAddress$1
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
                    ECOrderListOperateViewModel fi5;
                    String str;
                    OrderListScene orderListScene;
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append("afterFetchAddress, id= ");
                    sb6.append(eCAddress != null ? Long.valueOf(eCAddress.id) : null);
                    cg0.a.b("OrderListFragment", sb6.toString());
                    if (eCAddress != null) {
                        fi5 = ECOrderListFragment.this.fi();
                        String str2 = optString;
                        str = ECOrderListFragment.this.token;
                        orderListScene = ECOrderListFragment.this.scene;
                        fi5.c2(str2, str, eCAddress, orderListScene);
                    }
                }
            });
            return;
        }
        int i16 = com.tencent.ecommerce.biz.orders.buyerorders.orderlist.c.f103398a[this.scene.ordinal()];
        if (i16 == 1) {
            i3 = 1002;
        } else {
            if (i16 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            i3 = 1003;
        }
        ECModifyOrderAddressFragment.INSTANCE.a(requireActivity(), i3, this.token, optString, a16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void wi(com.tencent.ecommerce.base.list.h<ECOrderListItem, ECOrderListExtraInfo> uiState) {
        String token;
        Integer num = null;
        num = null;
        if (cg0.a.c()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("updateToken, token=");
            ECOrderListExtraInfo b16 = uiState.b();
            sb5.append(b16 != null ? b16.getToken() : null);
            cg0.a.b("OrderListFragment", sb5.toString());
        } else {
            StringBuilder sb6 = new StringBuilder();
            sb6.append("updateToken, tokenLength=");
            ECOrderListExtraInfo b17 = uiState.b();
            if (b17 != null && (token = b17.getToken()) != null) {
                num = Integer.valueOf(token.length());
            }
            sb6.append(num);
            cg0.a.b("OrderListFragment", sb6.toString());
        }
        ECOrderListExtraInfo b18 = uiState.b();
        if (b18 != null) {
            if (b18.getToken().length() > 0) {
                this.token = b18.getToken();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void xi(JSONObject itemJSONObject, Map<String, String> dataMap) {
        String optString = itemJSONObject.optString("order_id");
        cg0.a.b("OrderListFragment", "viewComment, orderId=" + optString + ",dataMap=" + dataMap);
        ECQShopReviewCommentFragment.Companion companion = ECQShopReviewCommentFragment.INSTANCE;
        Context requireContext = requireContext();
        String str = dataMap.get("skuId");
        if (str == null) {
            str = "";
        }
        String str2 = dataMap.get("spuId");
        companion.b(requireContext, optString, str, str2 != null ? str2 : "");
    }

    public static final /* synthetic */ ECOrderListAdapter yh(ECOrderListFragment eCOrderListFragment) {
        ECOrderListAdapter eCOrderListAdapter = eCOrderListFragment.adapter;
        if (eCOrderListAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        return eCOrderListAdapter;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void yi(JSONObject itemJSONObject, Map<String, String> dataMap) {
        String optString = itemJSONObject.optString("order_id");
        JSONArray optJSONArray = itemJSONObject.optJSONArray("shipping_info");
        JSONObject optJSONObject = optJSONArray != null ? optJSONArray.optJSONObject(0) : null;
        if (optJSONObject == null) {
            com.tencent.ecommerce.base.ui.i.f101155b.c(R.string.wsz, ECToastIcon.ICON_DEFAULT, 0);
        } else {
            ECLogisticsTraceFragment.INSTANCE.a(requireContext(), optString, optJSONObject.optString("logistics_code"));
        }
    }

    final /* synthetic */ Object li(JSONObject jSONObject, Continuation<? super Boolean> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        cg0.a.b("OrderListFragment", "jumpToQQMiniApp: linkInfo:" + jSONObject);
        String optString = jSONObject.optString("app_id");
        String optString2 = jSONObject.optString("path");
        String optString3 = jSONObject.optString("type");
        if (!(optString.length() == 0)) {
            if (!(optString2.length() == 0)) {
                intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
                CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
                cancellableContinuationImpl.initCancellability();
                QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getMiniAppLauncher().launchQQMinAppByAppId(requireContext(), optString, optString2, optString3, new b(cancellableContinuationImpl));
                Object result = cancellableContinuationImpl.getResult();
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (result == coroutine_suspended) {
                    DebugProbes.probeCoroutineSuspended(continuation);
                }
                return result;
            }
        }
        return Boxing.boxBoolean(false);
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0043, code lost:
    
        if ((r4.length() == 0) == false) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    final /* synthetic */ Object mi(JSONObject jSONObject, Continuation<? super Boolean> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        cg0.a.b("OrderListFragment", "jumpToWxMiniApp: linkInfo:" + jSONObject);
        String optString = jSONObject.optString("app_id");
        String optString2 = jSONObject.optString("path");
        String optString3 = jSONObject.optString("userName");
        if (optString.length() == 0) {
        }
        if (!(optString2.length() == 0)) {
            intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
            cancellableContinuationImpl.initCancellability();
            QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getMiniAppLauncher().launchWxMiniApp(requireContext(), optString, optString3, optString2, new c(cancellableContinuationImpl));
            Object result = cancellableContinuationImpl.getResult();
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (result == coroutine_suspended) {
                DebugProbes.probeCoroutineSuspended(continuation);
            }
            return result;
        }
        return Boxing.boxBoolean(false);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        String str;
        String string;
        cg0.a.b("OrderListFragment", "onCreateView, this=" + this);
        View inflate = LayoutInflater.from(requireContext()).inflate(R.layout.csp, (ViewGroup) null);
        Bundle arguments = getArguments();
        Serializable serializable = arguments != null ? arguments.getSerializable("query_type") : null;
        if (!(serializable instanceof ECQueryType)) {
            serializable = null;
        }
        ECQueryType eCQueryType = (ECQueryType) serializable;
        if (eCQueryType != null) {
            this.queryType = eCQueryType;
            Bundle arguments2 = getArguments();
            String str2 = "";
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
            Bundle arguments4 = getArguments();
            if (arguments4 != null && (string = arguments4.getString("from_scene")) != null) {
                str2 = string;
            }
            this.fromScene = str2;
            this.refreshLayout = (ECommercePullRefreshView) inflate.findViewById(R.id.o8o);
            ECStateCenterView eCStateCenterView = (ECStateCenterView) inflate.findViewById(R.id.oax);
            eCStateCenterView.setRetryListener(new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.orders.buyerorders.orderlist.ECOrderListFragment$onCreateView$$inlined$apply$lambda$1
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
                    ECOrderListFragment.this.ni();
                }
            });
            IStateCenterView.a.c(eCStateCenterView, null, 1, null);
            Unit unit = Unit.INSTANCE;
            this.stateCenterView = eCStateCenterView;
            ECOrderListAdapter eCOrderListAdapter = new ECOrderListAdapter(requireContext(), "q_shop_order_list");
            eCOrderListAdapter.o0(new Function3<String, JSONObject, Map<String, ? extends String>, Unit>() { // from class: com.tencent.ecommerce.biz.orders.buyerorders.orderlist.ECOrderListFragment$onCreateView$$inlined$apply$lambda$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(String str3, JSONObject jSONObject, Map<String, ? extends String> map) {
                    invoke2(str3, jSONObject, (Map<String, String>) map);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(String str3, JSONObject jSONObject, Map<String, String> map) {
                    Map map2;
                    map2 = ECOrderListFragment.this.ptsEventTypeToHandler;
                    Function2 function2 = (Function2) map2.get(str3);
                    if (function2 != null) {
                    }
                    ECOrderListReporter.f103395b.y(str3, jSONObject);
                }
            });
            eCOrderListAdapter.n0(new Function1<ECOrderListItem, Unit>() { // from class: com.tencent.ecommerce.biz.orders.buyerorders.orderlist.ECOrderListFragment$onCreateView$3$2
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(ECOrderListItem eCOrderListItem) {
                    invoke2(eCOrderListItem);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(ECOrderListItem eCOrderListItem) {
                    ECOrderListReporter.f103395b.w(eCOrderListItem.getPtsJSONObject());
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
            eCommercePullRefreshView.setOnRefreshStateListener(new d());
            return inflate;
        }
        cg0.a.a("OrderListFragment", "onCreateView", "onCreateView, no arguments");
        return null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        if (!this.hasLoadDataOnResume) {
            ni();
            this.hasLoadDataOnResume = true;
        }
        ti();
        super.onResume();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        cg0.a.b("OrderListFragment", "onViewCreated, this=" + this);
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new ECOrderListFragment$onViewCreated$$inlined$launchAndRepeatWithViewLifecycle$1(this, Lifecycle.State.STARTED, null, this), 3, null);
        Lifecycle.State state = Lifecycle.State.CREATED;
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new ECOrderListFragment$onViewCreated$$inlined$launchAndRepeatWithViewLifecycle$2(this, state, null, this), 3, null);
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new ECOrderListFragment$onViewCreated$$inlined$launchAndRepeatWithViewLifecycle$3(this, state, null, this), 3, null);
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new ECOrderListFragment$onViewCreated$$inlined$launchAndRepeatWithViewLifecycle$4(this, state, null, this), 3, null);
        LifecycleEventBus.f100688b.c(ThreadMode.ORIGIN, getViewLifecycleOwner(), ECQShopCommentFragment.b.class, new e());
    }

    public final void si(OrderListUiCallback orderListUiCallback) {
        this.orderListUiCallback = orderListUiCallback;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:13:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x00c8 -> B:11:0x00da). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x0116 -> B:16:0x011d). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final /* synthetic */ Object ui(JSONArray jSONArray, JSONObject jSONObject, JSONObject jSONObject2, String str, Continuation<? super Boolean> continuation) {
        ECOrderListFragment$tryLauncherDetailPage$1 eCOrderListFragment$tryLauncherDetailPage$1;
        ECOrderListFragment eCOrderListFragment;
        Object coroutine_suspended;
        int i3;
        String str2;
        int length;
        ECOrderListFragment$tryLauncherDetailPage$1 eCOrderListFragment$tryLauncherDetailPage$12;
        ECOrderListFragment eCOrderListFragment2;
        Object obj;
        int i16;
        JSONArray jSONArray2;
        JSONObject jSONObject3;
        JSONObject jSONObject4;
        JSONArray jSONArray3;
        JSONObject jSONObject5;
        JSONObject jSONObject6;
        String str3;
        int i17;
        int i18;
        if (continuation instanceof ECOrderListFragment$tryLauncherDetailPage$1) {
            eCOrderListFragment$tryLauncherDetailPage$1 = (ECOrderListFragment$tryLauncherDetailPage$1) continuation;
            int i19 = eCOrderListFragment$tryLauncherDetailPage$1.label;
            if ((i19 & Integer.MIN_VALUE) != 0) {
                eCOrderListFragment$tryLauncherDetailPage$1.label = i19 - Integer.MIN_VALUE;
                eCOrderListFragment = this;
                Object obj2 = eCOrderListFragment$tryLauncherDetailPage$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = eCOrderListFragment$tryLauncherDetailPage$1.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj2);
                    str2 = str;
                    length = jSONArray.length();
                    eCOrderListFragment$tryLauncherDetailPage$12 = eCOrderListFragment$tryLauncherDetailPage$1;
                    eCOrderListFragment2 = eCOrderListFragment;
                    obj = coroutine_suspended;
                    i16 = 0;
                    jSONArray2 = jSONArray;
                    jSONObject3 = jSONObject;
                    jSONObject4 = jSONObject2;
                    if (i16 < length) {
                    }
                } else if (i3 == 1) {
                    i18 = eCOrderListFragment$tryLauncherDetailPage$1.I$1;
                    i17 = eCOrderListFragment$tryLauncherDetailPage$1.I$0;
                    str3 = (String) eCOrderListFragment$tryLauncherDetailPage$1.L$4;
                    jSONObject6 = (JSONObject) eCOrderListFragment$tryLauncherDetailPage$1.L$3;
                    jSONObject5 = (JSONObject) eCOrderListFragment$tryLauncherDetailPage$1.L$2;
                    jSONArray3 = (JSONArray) eCOrderListFragment$tryLauncherDetailPage$1.L$1;
                    eCOrderListFragment2 = (ECOrderListFragment) eCOrderListFragment$tryLauncherDetailPage$1.L$0;
                    ResultKt.throwOnFailure(obj2);
                    if (((Boolean) obj2).booleanValue()) {
                    }
                    jSONArray2 = jSONArray3;
                    String str4 = str3;
                    ECOrderListFragment$tryLauncherDetailPage$1 eCOrderListFragment$tryLauncherDetailPage$13 = eCOrderListFragment$tryLauncherDetailPage$1;
                    jSONObject3 = jSONObject5;
                    int i26 = i18;
                    str2 = str4;
                    JSONObject jSONObject7 = jSONObject6;
                    Object obj3 = coroutine_suspended;
                    jSONObject4 = jSONObject7;
                    i16 = i17 + 1;
                    eCOrderListFragment$tryLauncherDetailPage$12 = eCOrderListFragment$tryLauncherDetailPage$13;
                    obj = obj3;
                    length = i26;
                    if (i16 < length) {
                    }
                } else if (i3 == 2) {
                    i18 = eCOrderListFragment$tryLauncherDetailPage$1.I$1;
                    i17 = eCOrderListFragment$tryLauncherDetailPage$1.I$0;
                    str3 = (String) eCOrderListFragment$tryLauncherDetailPage$1.L$4;
                    jSONObject6 = (JSONObject) eCOrderListFragment$tryLauncherDetailPage$1.L$3;
                    jSONObject5 = (JSONObject) eCOrderListFragment$tryLauncherDetailPage$1.L$2;
                    jSONArray3 = (JSONArray) eCOrderListFragment$tryLauncherDetailPage$1.L$1;
                    eCOrderListFragment2 = (ECOrderListFragment) eCOrderListFragment$tryLauncherDetailPage$1.L$0;
                    ResultKt.throwOnFailure(obj2);
                    if (((Boolean) obj2).booleanValue()) {
                        return Boxing.boxBoolean(true);
                    }
                    jSONArray2 = jSONArray3;
                    String str42 = str3;
                    ECOrderListFragment$tryLauncherDetailPage$1 eCOrderListFragment$tryLauncherDetailPage$132 = eCOrderListFragment$tryLauncherDetailPage$1;
                    jSONObject3 = jSONObject5;
                    int i262 = i18;
                    str2 = str42;
                    JSONObject jSONObject72 = jSONObject6;
                    Object obj32 = coroutine_suspended;
                    jSONObject4 = jSONObject72;
                    i16 = i17 + 1;
                    eCOrderListFragment$tryLauncherDetailPage$12 = eCOrderListFragment$tryLauncherDetailPage$132;
                    obj = obj32;
                    length = i262;
                    if (i16 < length) {
                        int optInt = jSONArray2.optInt(i16);
                        cg0.a.b("ECBuyerOrderViewModel", "type:" + optInt);
                        if (optInt == 2) {
                            eCOrderListFragment$tryLauncherDetailPage$12.L$0 = eCOrderListFragment2;
                            eCOrderListFragment$tryLauncherDetailPage$12.L$1 = jSONArray2;
                            eCOrderListFragment$tryLauncherDetailPage$12.L$2 = jSONObject3;
                            eCOrderListFragment$tryLauncherDetailPage$12.L$3 = jSONObject4;
                            eCOrderListFragment$tryLauncherDetailPage$12.L$4 = str2;
                            eCOrderListFragment$tryLauncherDetailPage$12.I$0 = i16;
                            eCOrderListFragment$tryLauncherDetailPage$12.I$1 = length;
                            eCOrderListFragment$tryLauncherDetailPage$12.label = 1;
                            Object mi5 = eCOrderListFragment2.mi(jSONObject3, eCOrderListFragment$tryLauncherDetailPage$12);
                            if (mi5 == obj) {
                                return obj;
                            }
                            jSONArray3 = jSONArray2;
                            obj2 = mi5;
                            int i27 = i16;
                            jSONObject5 = jSONObject3;
                            eCOrderListFragment$tryLauncherDetailPage$1 = eCOrderListFragment$tryLauncherDetailPage$12;
                            i17 = i27;
                            int i28 = length;
                            jSONObject6 = jSONObject4;
                            coroutine_suspended = obj;
                            str3 = str2;
                            i18 = i28;
                            if (((Boolean) obj2).booleanValue()) {
                                return Boxing.boxBoolean(true);
                            }
                            jSONArray2 = jSONArray3;
                            String str422 = str3;
                            ECOrderListFragment$tryLauncherDetailPage$1 eCOrderListFragment$tryLauncherDetailPage$1322 = eCOrderListFragment$tryLauncherDetailPage$1;
                            jSONObject3 = jSONObject5;
                            int i2622 = i18;
                            str2 = str422;
                            JSONObject jSONObject722 = jSONObject6;
                            Object obj322 = coroutine_suspended;
                            jSONObject4 = jSONObject722;
                            i16 = i17 + 1;
                            eCOrderListFragment$tryLauncherDetailPage$12 = eCOrderListFragment$tryLauncherDetailPage$1322;
                            obj = obj322;
                            length = i2622;
                            if (i16 < length) {
                                return Boxing.boxBoolean(false);
                            }
                        } else {
                            if (optInt != 3) {
                                eCOrderListFragment2.ki(str2);
                                return Boxing.boxBoolean(true);
                            }
                            eCOrderListFragment$tryLauncherDetailPage$12.L$0 = eCOrderListFragment2;
                            eCOrderListFragment$tryLauncherDetailPage$12.L$1 = jSONArray2;
                            eCOrderListFragment$tryLauncherDetailPage$12.L$2 = jSONObject3;
                            eCOrderListFragment$tryLauncherDetailPage$12.L$3 = jSONObject4;
                            eCOrderListFragment$tryLauncherDetailPage$12.L$4 = str2;
                            eCOrderListFragment$tryLauncherDetailPage$12.I$0 = i16;
                            eCOrderListFragment$tryLauncherDetailPage$12.I$1 = length;
                            eCOrderListFragment$tryLauncherDetailPage$12.label = 2;
                            Object li5 = eCOrderListFragment2.li(jSONObject4, eCOrderListFragment$tryLauncherDetailPage$12);
                            if (li5 == obj) {
                                return obj;
                            }
                            jSONArray3 = jSONArray2;
                            obj2 = li5;
                            int i29 = i16;
                            jSONObject5 = jSONObject3;
                            eCOrderListFragment$tryLauncherDetailPage$1 = eCOrderListFragment$tryLauncherDetailPage$12;
                            i17 = i29;
                            int i36 = length;
                            jSONObject6 = jSONObject4;
                            coroutine_suspended = obj;
                            str3 = str2;
                            i18 = i36;
                            if (((Boolean) obj2).booleanValue()) {
                            }
                            jSONArray2 = jSONArray3;
                            String str4222 = str3;
                            ECOrderListFragment$tryLauncherDetailPage$1 eCOrderListFragment$tryLauncherDetailPage$13222 = eCOrderListFragment$tryLauncherDetailPage$1;
                            jSONObject3 = jSONObject5;
                            int i26222 = i18;
                            str2 = str4222;
                            JSONObject jSONObject7222 = jSONObject6;
                            Object obj3222 = coroutine_suspended;
                            jSONObject4 = jSONObject7222;
                            i16 = i17 + 1;
                            eCOrderListFragment$tryLauncherDetailPage$12 = eCOrderListFragment$tryLauncherDetailPage$13222;
                            obj = obj3222;
                            length = i26222;
                            if (i16 < length) {
                            }
                        }
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        eCOrderListFragment = this;
        eCOrderListFragment$tryLauncherDetailPage$1 = new ECOrderListFragment$tryLauncherDetailPage$1(eCOrderListFragment, continuation);
        Object obj22 = eCOrderListFragment$tryLauncherDetailPage$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = eCOrderListFragment$tryLauncherDetailPage$1.label;
        if (i3 != 0) {
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        OrderListScene orderListScene;
        String stringExtra;
        String stringExtra2;
        if (resultCode == -1 && (requestCode == 1002 || requestCode == 1003)) {
            final String str = (data == null || (stringExtra2 = data.getStringExtra("bundle_key_token")) == null) ? "" : stringExtra2;
            final String str2 = (data == null || (stringExtra = data.getStringExtra("bundle_key_order_id")) == null) ? "" : stringExtra;
            final ECAddress eCAddress = data != null ? (ECAddress) data.getParcelableExtra("bundle_key_result_address") : null;
            if (eCAddress == null) {
                cg0.a.a("OrderListFragment", "modifyAddress", "newAddress is null while modify address");
                return;
            }
            if (requestCode == 1003) {
                orderListScene = OrderListScene.ORDER_LIST_SEARCH;
            } else {
                orderListScene = OrderListScene.ORDER_LIST_PAGE;
            }
            final OrderListScene orderListScene2 = orderListScene;
            com.tencent.ecommerce.base.ui.g gVar = new com.tencent.ecommerce.base.ui.g(requireContext());
            gVar.setTitle(requireContext().getString(R.string.wib));
            gVar.Y(requireContext().getString(R.string.f169619wo3));
            gVar.e0(new Function1<View, Unit>() { // from class: com.tencent.ecommerce.biz.orders.buyerorders.orderlist.ECOrderListFragment$onActivityResult$$inlined$apply$lambda$1
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
                    ECOrderListOperateViewModel fi5;
                    fi5 = ECOrderListFragment.this.fi();
                    fi5.c2(str2, str, eCAddress, orderListScene2);
                }
            });
            gVar.show();
            return;
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
