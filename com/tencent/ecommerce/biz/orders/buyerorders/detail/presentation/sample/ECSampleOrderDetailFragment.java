package com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.sample;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.constraintlayout.widget.Group;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.ecommerce.base.fragment.ECBaseFragment;
import com.tencent.ecommerce.base.list.IStateCenterView;
import com.tencent.ecommerce.base.report.service.ECShowPageCostTimeScene;
import com.tencent.ecommerce.base.report.service.k;
import com.tencent.ecommerce.base.ui.ECSkin;
import com.tencent.ecommerce.base.ui.g;
import com.tencent.ecommerce.base.ui.stateview.ECStateCenterView;
import com.tencent.ecommerce.biz.logistics.ECLogisticsTraceFragment;
import com.tencent.ecommerce.biz.orders.address.ECAddress;
import com.tencent.ecommerce.biz.orders.address.modifyorderaddress.ECModifyOrderAddressFragment;
import com.tencent.ecommerce.biz.orders.buyerorders.detail.domain.qshop.ECOrderDetailHeaderState;
import com.tencent.ecommerce.biz.orders.buyerorders.detail.domain.qshop.ECOrderDetailPayInfo;
import com.tencent.ecommerce.biz.orders.buyerorders.detail.domain.qshop.ECOrderDetailState;
import com.tencent.ecommerce.biz.orders.buyerorders.detail.domain.qshop.ECOrderDetailWidgetsVisibility;
import com.tencent.ecommerce.biz.orders.buyerorders.detail.domain.qshop.OrderDetailCheckValidData;
import com.tencent.ecommerce.biz.orders.buyerorders.detail.domain.sample.ECSampleOrderDetailViewModel;
import com.tencent.ecommerce.biz.orders.buyerorders.detail.domain.sample.RecommendFetchType;
import com.tencent.ecommerce.biz.orders.buyerorders.detail.model.OrderDetailEntrance;
import com.tencent.ecommerce.biz.orders.buyerorders.detail.model.OrderSpuDetail;
import com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.ECOrderDetailListAdapter;
import com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.ECOrderDetailOperation;
import com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.d;
import com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.f;
import com.tencent.ecommerce.biz.orders.buyerorders.submit.ECOrderSubmitViewModel;
import com.tencent.ecommerce.biz.orders.buyerorders.submit.model.OrderSkuDetail;
import com.tencent.ecommerce.biz.orders.common.LogisticsInfo;
import com.tencent.ecommerce.biz.orders.common.QShopOrderState;
import com.tencent.ecommerce.biz.recommend.models.ECProductRecommendItemData;
import com.tencent.ecommerce.biz.recommend.models.ECShopRecommendScene;
import com.tencent.ecommerce.biz.router.ECScheme;
import com.tencent.ecommerce.biz.util.ECViewUtilKt;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.data.MessageForBirthdayNotice;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import cooperation.qzone.QzoneIPCModule;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import mqq.app.Constants;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 F2\u00020\u0001:\u0002GHB\u0007\u00a2\u0006\u0004\bD\u0010EJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\f\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\nH\u0016J\u001a\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0011\u001a\u00020\u0004H\u0016J\b\u0010\u0012\u001a\u00020\u0004H\u0016J\b\u0010\u0013\u001a\u00020\u0004H\u0016J\"\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016J\f\u0010\u0019\u001a\u00020\u0006*\u00020\u0002H\u0002J\f\u0010\u001b\u001a\u00020\u001a*\u00020\u0002H\u0002J\u0010\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0010\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\b\u0010\u001e\u001a\u00020\u0004H\u0002J\u0010\u0010!\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u001fH\u0002J\b\u0010\"\u001a\u00020\u0004H\u0002J\u0010\u0010%\u001a\u00020\u00042\u0006\u0010$\u001a\u00020#H\u0002J\u0018\u0010*\u001a\u00020\u00042\u0006\u0010'\u001a\u00020&2\u0006\u0010)\u001a\u00020(H\u0002R\u0016\u0010-\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u001b\u00103\u001a\u00020.8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u00102R\u0016\u00107\u001a\u0002048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0016\u0010;\u001a\u0002088\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0014\u0010?\u001a\u00020<8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0014\u0010C\u001a\u00020@8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bA\u0010B\u00a8\u0006I"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/presentation/sample/ECSampleOrderDetailFragment;", "Lcom/tencent/ecommerce/base/fragment/ECBaseFragment;", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "onCreate", "", "getBusinessDescription", "", "getContentLayoutId", "", "Bh", "Dh", "Eh", "Landroid/view/View;", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", "Wh", "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/model/OrderDetailEntrance;", "Vh", "initViews", "Yh", "Zh", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/ECOrderSubmitViewModel$g$b;", "errorState", "Th", "Uh", "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/domain/qshop/ECOrderDetailState;", "state", "bi", "Lcom/tencent/ecommerce/biz/orders/common/QShopOrderState;", "orderState", "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/domain/qshop/f;", "headerState", "ai", "P", "Ljava/lang/String;", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ORDER_ID, "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/domain/sample/ECSampleOrderDetailViewModel;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lkotlin/Lazy;", "Xh", "()Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/domain/sample/ECSampleOrderDetailViewModel;", "viewModel", "Lcom/tencent/ecommerce/base/ui/stateview/ECStateCenterView;", BdhLogUtil.LogTag.Tag_Req, "Lcom/tencent/ecommerce/base/ui/stateview/ECStateCenterView;", "stateView", "", ExifInterface.LATITUDE_SOUTH, "J", "lastResumeTimeMs", "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/presentation/ECOrderDetailListAdapter;", "T", "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/presentation/ECOrderDetailListAdapter;", "adapter", "Lcom/tencent/ecommerce/base/report/service/k;", "U", "Lcom/tencent/ecommerce/base/report/service/k;", "showCostTimeReporter", "<init>", "()V", "V", "a", "OrderDetailListListener", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECSampleOrderDetailFragment extends ECBaseFragment {

    /* renamed from: V, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: P, reason: from kotlin metadata */
    private String orderId = "";

    /* renamed from: Q, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* renamed from: R, reason: from kotlin metadata */
    private ECStateCenterView stateView;

    /* renamed from: S, reason: from kotlin metadata */
    private long lastResumeTimeMs;

    /* renamed from: T, reason: from kotlin metadata */
    private final ECOrderDetailListAdapter adapter;

    /* renamed from: U, reason: from kotlin metadata */
    private final k showCostTimeReporter;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006R\u0014\u0010\n\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u000b\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/presentation/sample/ECSampleOrderDetailFragment$a;", "", "Landroid/content/Context;", "context", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ORDER_ID, "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/model/OrderDetailEntrance;", "from", "", "a", "PARAMS_FROM", "Ljava/lang/String;", "PARAMS_ORDER_ID", "", "REQUEST_CODE_MODIFY_ADDRESS", "I", "START_TO_REQUEST_POSITION", "TAG", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.sample.ECSampleOrderDetailFragment$a, reason: from kotlin metadata */
    /* loaded from: classes31.dex */
    public static final class Companion {
        Companion() {
        }

        public final void a(Context context, String orderId, OrderDetailEntrance from) {
            if ((orderId.length() == 0) && wg0.a.b()) {
                throw new IllegalArgumentException("must have params orderId");
            }
            Bundle bundle = new Bundle();
            bundle.putString("order_id", orderId);
            bundle.putString("from", String.valueOf(from.value));
            yi0.a.q(context, ECSampleOrderDetailFragment.class, bundle, 0, null, 24, null);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public ECSampleOrderDetailFragment() {
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.sample.ECSampleOrderDetailFragment$$special$$inlined$viewModels$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(ECSampleOrderDetailViewModel.class), new Function0<ViewModelStore>() { // from class: com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.sample.ECSampleOrderDetailFragment$$special$$inlined$viewModels$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                ViewModelStore viewModelStore = ((ViewModelStoreOwner) Function0.this.invoke()).get_viewModelStore();
                Intrinsics.checkExpressionValueIsNotNull(viewModelStore, "ownerProducer().viewModelStore");
                return viewModelStore;
            }
        }, null);
        this.adapter = new ECOrderDetailListAdapter(new OrderDetailListListener(), ECShopRecommendScene.QQ_SHOP_APPLY_SAMPLE_ORDER_DETAIL);
        this.showCostTimeReporter = new k(ECShowPageCostTimeScene.SHOW_COST_TIME_ORDER_DETAIL);
    }

    public static final /* synthetic */ ECStateCenterView Ph(ECSampleOrderDetailFragment eCSampleOrderDetailFragment) {
        ECStateCenterView eCStateCenterView = eCSampleOrderDetailFragment.stateView;
        if (eCStateCenterView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stateView");
        }
        return eCStateCenterView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Th(ECOrderSubmitViewModel.g.Error errorState) {
        cg0.a.a("ECSampleOrderDetailFragment", "dealWithErrorState", "code: " + errorState.code + ", msg: " + errorState.msg);
        ECStateCenterView eCStateCenterView = this.stateView;
        if (eCStateCenterView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stateView");
        }
        IStateCenterView.a.b(eCStateCenterView, null, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Uh() {
        Xh().f2(this.orderId);
    }

    private final OrderDetailEntrance Vh(Bundle bundle) {
        int i3;
        OrderDetailEntrance orderDetailEntrance;
        String string = bundle.getString("from");
        if (string != null) {
            i3 = Integer.parseInt(string);
        } else {
            i3 = OrderDetailEntrance.FROM_UNKNOWN.value;
        }
        OrderDetailEntrance[] values = OrderDetailEntrance.values();
        int length = values.length;
        int i16 = 0;
        while (true) {
            if (i16 >= length) {
                orderDetailEntrance = null;
                break;
            }
            orderDetailEntrance = values[i16];
            if (orderDetailEntrance.value == i3) {
                break;
            }
            i16++;
        }
        return orderDetailEntrance != null ? orderDetailEntrance : OrderDetailEntrance.FROM_UNKNOWN;
    }

    private final String Wh(Bundle bundle) {
        String string = bundle.getString("order_id");
        return string != null ? string : "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ECSampleOrderDetailViewModel Xh() {
        return (ECSampleOrderDetailViewModel) this.viewModel.getValue();
    }

    private final void Zh() {
        Lifecycle.State state = Lifecycle.State.STARTED;
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new ECSampleOrderDetailFragment$initObservers$$inlined$launchAndRepeatWithViewLifecycle$1(this, state, null, this), 3, null);
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new ECSampleOrderDetailFragment$initObservers$$inlined$launchAndRepeatWithViewLifecycle$2(this, state, null, this), 3, null);
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new ECSampleOrderDetailFragment$initObservers$$inlined$launchAndRepeatWithViewLifecycle$3(this, Lifecycle.State.CREATED, null, this), 3, null);
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new ECSampleOrderDetailFragment$initObservers$$inlined$launchAndRepeatWithViewLifecycle$4(this, state, null, this), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ai(QShopOrderState orderState, ECOrderDetailHeaderState headerState) {
        this.adapter.o0(new f.OrderStateData(orderState.value, ECSkin.INSTANCE.getColor(R.color.f59307), headerState.stateTitleStr, headerState.stateDescStr));
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment
    public boolean Bh() {
        return true;
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
        return "ECSampleOrderDetailFragment";
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment
    public int getContentLayoutId() {
        return R.layout.csh;
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        String str;
        OrderDetailEntrance orderDetailEntrance;
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments == null || (str = Wh(arguments)) == null) {
            str = "";
        }
        this.orderId = str;
        com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.sample.b bVar = com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.sample.b.f103318d;
        Bundle arguments2 = getArguments();
        if (arguments2 == null || (orderDetailEntrance = Vh(arguments2)) == null) {
            orderDetailEntrance = OrderDetailEntrance.FROM_UNKNOWN;
        }
        bVar.a(orderDetailEntrance);
        getLifecycle().addObserver(Xh());
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.adapter.destroy();
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.sample.b.f103318d.f();
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.sample.b.e(com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.sample.b.f103318d, null, 1, null);
        this.lastResumeTimeMs = System.currentTimeMillis();
        Uh();
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setTitle(R.string.wou);
        initViews(view);
        Yh(view);
        Zh();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0002H\u0016J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0002H\u0016J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0002H\u0016J\u0010\u0010\u0010\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0002H\u0016\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/presentation/sample/ECSampleOrderDetailFragment$OrderDetailListListener;", "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/presentation/a;", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ORDER_ID, "logisticsCode", "", DomainData.DOMAIN_NAME, "Lcom/tencent/ecommerce/biz/orders/address/ECAddress;", "ecAddress", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, MessageForBirthdayNotice.MSG_BIRTHDAY_NOTICE_LINK, "k", h.F, "f", "phoneNum", "e", "i", "<init>", "(Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/presentation/sample/ECSampleOrderDetailFragment;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public final class OrderDetailListListener extends com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.a {
        public OrderDetailListListener() {
        }

        @Override // com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.a
        public void e(String phoneNum) {
            com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.sample.b.f103318d.c("qstore_b_order_detail_contact_shop_clk");
            g gVar = new g(ECSampleOrderDetailFragment.this.requireContext());
            gVar.setTitle(ECSampleOrderDetailFragment.this.requireContext().getString(R.string.wiq));
            gVar.Y(phoneNum);
            gVar.b0("");
            gVar.f0(ECSampleOrderDetailFragment.this.requireContext().getString(R.string.wo7));
            gVar.show();
        }

        @Override // com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.a
        public void f(String orderId) {
            ECOrderDetailOperation.f103235a.a(ECSampleOrderDetailFragment.this.requireContext(), orderId);
        }

        @Override // com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.a
        public void m(ECAddress ecAddress) {
            OrderDetailCheckValidData modifyAddressValidData = ECSampleOrderDetailFragment.this.Xh().getModifyAddressValidData();
            if (modifyAddressValidData != null && System.currentTimeMillis() > modifyAddressValidData.exceedTimeMs) {
                ECOrderDetailOperation.f103235a.b(ECSampleOrderDetailFragment.this.requireContext(), modifyAddressValidData.exceedStr, new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.sample.ECSampleOrderDetailFragment$OrderDetailListListener$modifyAddressInfo$1
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
                        ECSampleOrderDetailFragment.this.Xh().f2(ECSampleOrderDetailFragment.this.orderId);
                    }
                });
            } else {
                ECModifyOrderAddressFragment.Companion.b(ECModifyOrderAddressFragment.INSTANCE, ECSampleOrderDetailFragment.this.requireActivity(), 1001, null, ECSampleOrderDetailFragment.this.orderId, ecAddress, 4, null);
            }
        }

        @Override // com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.a
        public void n(String orderId, String logisticsCode) {
            com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.sample.b.f103318d.c("qstore_b_order_detail_logistics_clk");
            ECLogisticsTraceFragment.INSTANCE.a(ECSampleOrderDetailFragment.this.requireContext(), orderId, logisticsCode);
        }

        @Override // com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.a
        public void h(String link) {
            ECScheme.g(link, null, 2, null);
        }

        @Override // com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.a
        public void i(String link) {
            ECScheme.g(link, null, 2, null);
        }

        @Override // com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.a
        public void k(String link) {
            ECScheme.g(link, null, 2, null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J \u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0016R\u0016\u0010\r\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u000e\u00b8\u0006\u0000"}, d2 = {"com/tencent/ecommerce/biz/orders/buyerorders/detail/presentation/sample/ECSampleOrderDetailFragment$initViews$2$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "newState", "", "onScrollStateChanged", "dx", "dy", "onScrolled", "d", "I", "lastVisiblePosition", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class b extends RecyclerView.OnScrollListener {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private int lastVisiblePosition;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ StaggeredGridLayoutManager f103312e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ ECSampleOrderDetailFragment f103313f;

        b(StaggeredGridLayoutManager staggeredGridLayoutManager, ECSampleOrderDetailFragment eCSampleOrderDetailFragment) {
            this.f103312e = staggeredGridLayoutManager;
            this.f103313f = eCSampleOrderDetailFragment;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int dx5, int dy5) {
            int lastIndex;
            super.onScrolled(recyclerView, dx5, dy5);
            int[] findLastVisibleItemPositions = this.f103312e.findLastVisibleItemPositions(null);
            int i3 = 1;
            if (!(findLastVisibleItemPositions.length == 0)) {
                int i16 = findLastVisibleItemPositions[0];
                lastIndex = ArraysKt___ArraysKt.getLastIndex(findLastVisibleItemPositions);
                if (1 <= lastIndex) {
                    while (true) {
                        int i17 = findLastVisibleItemPositions[i3];
                        if (i16 < i17) {
                            i16 = i17;
                        }
                        if (i3 == lastIndex) {
                            break;
                        } else {
                            i3++;
                        }
                    }
                }
                this.lastVisiblePosition = i16;
                return;
            }
            throw new NoSuchElementException();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            if (newState == 0 && this.f103313f.Xh().get_hasMoreRecommendData() && this.f103312e.getItemCount() - this.lastVisiblePosition <= 4) {
                this.f103313f.Xh().s2(RecommendFetchType.FETCH_MORE);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void bi(ECOrderDetailState state) {
        int collectionSizeOrDefault;
        List emptyList;
        Object first;
        Object first2;
        Object first3;
        Object first4;
        Object first5;
        List emptyList2;
        List listOf;
        List<? extends f> plus;
        List<ECProductRecommendItemData> h16 = state.h();
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(h16, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (ECProductRecommendItemData eCProductRecommendItemData : h16) {
            arrayList.add(new f.RecommendGoodsData(eCProductRecommendItemData.id, eCProductRecommendItemData.getData()));
        }
        if (!arrayList.isEmpty()) {
            emptyList = CollectionsKt__CollectionsKt.mutableListOf(f.e.f103256b, f.k.f103278b);
            emptyList.addAll(arrayList);
        } else {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
        }
        ECOrderDetailListAdapter eCOrderDetailListAdapter = this.adapter;
        LogisticsInfo logisticsInfo = state.logisticsInfo;
        String str = state.orderId;
        ECOrderDetailWidgetsVisibility eCOrderDetailWidgetsVisibility = state.widgetsVisibility;
        boolean z16 = eCOrderDetailWidgetsVisibility.showAddressInfo;
        ECAddress eCAddress = state.addressInfo;
        f.e eVar = f.e.f103256b;
        first = CollectionsKt___CollectionsKt.first((List<? extends Object>) state.orderSkuInfo);
        first2 = CollectionsKt___CollectionsKt.first((List<? extends Object>) state.orderSpuInfo);
        first3 = CollectionsKt___CollectionsKt.first((List<? extends Object>) state.orderSkuInfo);
        String string = requireContext().getString(R.string.wev);
        first4 = CollectionsKt___CollectionsKt.first((List<? extends Object>) state.orderSkuInfo);
        int i3 = ((OrderSkuDetail) first4).quantity;
        ECOrderDetailPayInfo eCOrderDetailPayInfo = state.payInfo;
        long j3 = eCOrderDetailPayInfo.orderPrice;
        long j16 = eCOrderDetailPayInfo.originalPrice;
        boolean z17 = state.widgetsVisibility.showFreightInfo;
        first5 = CollectionsKt___CollectionsKt.first((List<? extends Object>) state.orderSkuInfo);
        String str2 = ((OrderSkuDetail) first5).freight;
        emptyList2 = CollectionsKt__CollectionsKt.emptyList();
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new f[]{new f.OrderStateData(state.orderStateVal, ECSkin.INSTANCE.getColor(R.color.f59307), state.getHeaderState().stateTitleStr, state.getHeaderState().stateDescStr), new f.ShippingAndLocationData(str, eCOrderDetailWidgetsVisibility.showLogisticsInfo, logisticsInfo, z16, eCAddress, eCOrderDetailWidgetsVisibility.showModifyAddress), eVar, new f.SampleGoodsDetailData((OrderSkuDetail) first, (OrderSpuDetail) first2, ((OrderSkuDetail) first3).shop.mobile), eVar, new f.PriceDetailData(string, i3, j3, j16, z17, str2, emptyList2, false), eVar, new f.DetailInfoData(state.orderId, state.createTimestampMs, state.buyerMobile, false, null, 0L, requireContext().getString(R.string.wru), state.orderNote, null, false, 312, null)});
        plus = CollectionsKt___CollectionsKt.plus((Collection) listOf, (Iterable) emptyList);
        eCOrderDetailListAdapter.n0(plus);
    }

    private final void Yh(View view) {
        Group group = (Group) view.findViewById(R.id.nrk);
        ECViewUtilKt.b(group, R.id.nvn, R.id.nrj, R.id.f163068o44, R.id.ob8);
        group.setVisibility(8);
    }

    private final void initViews(View view) {
        ECStateCenterView eCStateCenterView = (ECStateCenterView) view.findViewById(R.id.f163103ob2);
        eCStateCenterView.setRetryListener(new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.sample.ECSampleOrderDetailFragment$initViews$$inlined$apply$lambda$1
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
                ECSampleOrderDetailFragment.this.Uh();
            }
        });
        Unit unit = Unit.INSTANCE;
        this.stateView = eCStateCenterView;
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.o5f);
        recyclerView.setAdapter(this.adapter);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, 1);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);
        recyclerView.addOnScrollListener(new b(staggeredGridLayoutManager, this));
        recyclerView.addItemDecoration(new d());
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        String str;
        if (requestCode == 1001 && resultCode == -1) {
            if (data == null || (str = data.getStringExtra("bundle_key_order_id")) == null) {
                str = "";
            }
            if (!Intrinsics.areEqual(str, this.orderId)) {
                return;
            }
            ECAddress eCAddress = data != null ? (ECAddress) data.getParcelableExtra("bundle_key_result_address") : null;
            if (eCAddress != null) {
                Xh().t2(eCAddress, str);
                return;
            }
            return;
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
