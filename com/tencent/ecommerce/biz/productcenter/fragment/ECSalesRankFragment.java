package com.tencent.ecommerce.biz.productcenter.fragment;

import android.os.Bundle;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.ecommerce.base.eventbus.EventObserver;
import com.tencent.ecommerce.base.eventbus.LifecycleEventBus;
import com.tencent.ecommerce.base.eventbus.ThreadMode;
import com.tencent.ecommerce.base.fragment.ECBaseFragment;
import com.tencent.ecommerce.biz.productcenter.repo.ECSalesRankRepo;
import com.tencent.ecommerce.biz.productcenter.ui.adapter.ECRankRecycleViewAdapter;
import com.tencent.ecommerce.biz.productcenter.viewmodel.ECSalesRankViewModel;
import com.tencent.ecommerce.biz.router.ECScheme;
import com.tencent.ecommerce.biz.showwindow.viewmodel.ECGlobalShowWindowViewModel;
import com.tencent.ecommerce.biz.util.q;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import java.io.Serializable;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import mqq.app.Constants;
import org.json.JSONObject;
import ri0.ECAddProductToWindowEvent;
import xj0.RankGoodsInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000]\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\t*\u0001*\u0018\u0000 02\u00020\u0001:\u00011B\u0007\u00a2\u0006\u0004\b.\u0010/J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\u0012\u0010\t\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0017J\b\u0010\r\u001a\u00020\u0002H\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016R\u0016\u0010\u0012\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u001b\u0010$\u001a\u00020\u001f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u001b\u0010)\u001a\u00020%8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b&\u0010!\u001a\u0004\b'\u0010(R\u0014\u0010-\u001a\u00020*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010,\u00a8\u00062"}, d2 = {"Lcom/tencent/ecommerce/biz/productcenter/fragment/ECSalesRankFragment;", "Lcom/tencent/ecommerce/base/fragment/ECBaseFragment;", "", "Rh", "Sh", "", "getContentLayoutId", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "Landroid/view/View;", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "getBusinessDescription", "P", "Ljava/lang/String;", WadlProxyConsts.CHANNEL, "Lcom/tencent/ecommerce/biz/productcenter/repo/ECSalesRankRepo$SalesRankType;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/tencent/ecommerce/biz/productcenter/repo/ECSalesRankRepo$SalesRankType;", "rankType", "Landroidx/recyclerview/widget/RecyclerView;", BdhLogUtil.LogTag.Tag_Req, "Landroidx/recyclerview/widget/RecyclerView;", "hotListRecycleView", "Lcom/tencent/ecommerce/biz/productcenter/ui/adapter/ECRankRecycleViewAdapter;", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/ecommerce/biz/productcenter/ui/adapter/ECRankRecycleViewAdapter;", "salesRankRecycleViewAdapter", "Lcom/tencent/ecommerce/biz/productcenter/viewmodel/ECSalesRankViewModel;", "T", "Lkotlin/Lazy;", "Qh", "()Lcom/tencent/ecommerce/biz/productcenter/viewmodel/ECSalesRankViewModel;", "viewModel", "Lcom/tencent/ecommerce/biz/showwindow/viewmodel/ECGlobalShowWindowViewModel;", "U", "Ph", "()Lcom/tencent/ecommerce/biz/showwindow/viewmodel/ECGlobalShowWindowViewModel;", "globalShowWindowViewModel", "com/tencent/ecommerce/biz/productcenter/fragment/ECSalesRankFragment$b", "V", "Lcom/tencent/ecommerce/biz/productcenter/fragment/ECSalesRankFragment$b;", "addProductEventObserve", "<init>", "()V", "W", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECSalesRankFragment extends ECBaseFragment {

    /* renamed from: P, reason: from kotlin metadata */
    private String channel = "";

    /* renamed from: Q, reason: from kotlin metadata */
    private ECSalesRankRepo.SalesRankType rankType = ECSalesRankRepo.SalesRankType.DAILY;

    /* renamed from: R, reason: from kotlin metadata */
    private RecyclerView hotListRecycleView;

    /* renamed from: S, reason: from kotlin metadata */
    private ECRankRecycleViewAdapter salesRankRecycleViewAdapter;

    /* renamed from: T, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* renamed from: U, reason: from kotlin metadata */
    private final Lazy globalShowWindowViewModel;

    /* renamed from: V, reason: from kotlin metadata */
    private final b addProductEventObserve;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/ecommerce/biz/productcenter/fragment/ECSalesRankFragment$b", "Lcom/tencent/ecommerce/base/eventbus/EventObserver;", "Lri0/a;", "event", "", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class b implements EventObserver<ECAddProductToWindowEvent> {
        b() {
        }

        @Override // com.tencent.ecommerce.base.eventbus.EventObserver
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onEvent(ECAddProductToWindowEvent event) {
            if (event.isAdded) {
                ECSalesRankFragment.Oh(ECSalesRankFragment.this).o0(event.saasProductId);
            }
            ri0.c.f431472c.c(ECSalesRankFragment.this.channel, event.getProductInfo(), ECSalesRankFragment.this.rankType);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/ecommerce/biz/productcenter/fragment/ECSalesRankFragment$d", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "dx", "dy", "", "onScrolled", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class d extends RecyclerView.OnScrollListener {
        d() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int dx5, int dy5) {
            super.onScrolled(recyclerView, dx5, dy5);
            if (dy5 >= 1) {
                q.f104879a.a(ECSalesRankFragment.this.requireActivity(), ECSalesRankFragment.this.requireContext());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u00042\u001a\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0001 \u0002*\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "Lxj0/a;", "kotlin.jvm.PlatformType", "it", "", "a", "(Ljava/util/List;)V"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class e<T> implements Observer<List<? extends RankGoodsInfo>> {
        e() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(List<RankGoodsInfo> list) {
            ECSalesRankFragment.Oh(ECSalesRankFragment.this).setData(list);
        }
    }

    public ECSalesRankFragment() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ECSalesRankViewModel>() { // from class: com.tencent.ecommerce.biz.productcenter.fragment.ECSalesRankFragment$viewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ECSalesRankViewModel invoke() {
                return new ECSalesRankViewModel(ECSalesRankFragment.this.rankType, ECSalesRankFragment.this.channel);
            }
        });
        this.viewModel = lazy;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.tencent.ecommerce.biz.productcenter.fragment.ECSalesRankFragment$$special$$inlined$viewModels$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        this.globalShowWindowViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(ECGlobalShowWindowViewModel.class), new Function0<ViewModelStore>() { // from class: com.tencent.ecommerce.biz.productcenter.fragment.ECSalesRankFragment$$special$$inlined$viewModels$2
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
        this.addProductEventObserve = new b();
    }

    public static final /* synthetic */ ECRankRecycleViewAdapter Oh(ECSalesRankFragment eCSalesRankFragment) {
        ECRankRecycleViewAdapter eCRankRecycleViewAdapter = eCSalesRankFragment.salesRankRecycleViewAdapter;
        if (eCRankRecycleViewAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("salesRankRecycleViewAdapter");
        }
        return eCRankRecycleViewAdapter;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ECGlobalShowWindowViewModel Ph() {
        return (ECGlobalShowWindowViewModel) this.globalShowWindowViewModel.getValue();
    }

    private final ECSalesRankViewModel Qh() {
        return (ECSalesRankViewModel) this.viewModel.getValue();
    }

    private final void Rh() {
        this.hotListRecycleView = (RecyclerView) yh().findViewById(R.id.o0v);
        this.salesRankRecycleViewAdapter = new ECRankRecycleViewAdapter(requireContext(), this.rankType, new c(), this.channel);
        RecyclerView recyclerView = this.hotListRecycleView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("hotListRecycleView");
        }
        ECRankRecycleViewAdapter eCRankRecycleViewAdapter = this.salesRankRecycleViewAdapter;
        if (eCRankRecycleViewAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("salesRankRecycleViewAdapter");
        }
        recyclerView.setAdapter(eCRankRecycleViewAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext(), 1, false));
        RecyclerView recyclerView2 = this.hotListRecycleView;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("hotListRecycleView");
        }
        recyclerView2.addOnScrollListener(new d());
    }

    private final void Sh() {
        Qh().O1().observe(getViewLifecycleOwner(), new e());
    }

    @Override // com.tencent.ecommerce.base.fragment.api.IECBaseFragment
    /* renamed from: getBusinessDescription */
    public String getTAG() {
        return "ECSalesRankFragment";
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment
    public int getContentLayoutId() {
        return R.layout.ctn;
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        String string;
        Bundle arguments = getArguments();
        Serializable serializable = arguments != null ? arguments.getSerializable("salesRankType") : null;
        if (serializable != null) {
            this.rankType = (ECSalesRankRepo.SalesRankType) serializable;
            Bundle arguments2 = getArguments();
            String str = "";
            if (arguments2 != null && (string = arguments2.getString(WadlProxyConsts.CHANNEL, "")) != null) {
                str = string;
            }
            this.channel = str;
            super.onCreate(savedInstanceState);
            LifecycleEventBus.f100688b.d(ThreadMode.ORIGIN, ECAddProductToWindowEvent.class, this.addProductEventObserve);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.tencent.ecommerce.biz.productcenter.repo.ECSalesRankRepo.SalesRankType");
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        LifecycleEventBus.f100688b.e(this.addProductEventObserve);
        ECSalesRankRepo eCSalesRankRepo = ECSalesRankRepo.f103920a;
        ECSalesRankRepo.SalesRankType salesRankType = this.rankType;
        ECRankRecycleViewAdapter eCRankRecycleViewAdapter = this.salesRankRecycleViewAdapter;
        if (eCRankRecycleViewAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("salesRankRecycleViewAdapter");
        }
        eCSalesRankRepo.b(salesRankType, eCRankRecycleViewAdapter.j0());
        ri0.c.f431472c.g();
        ECRankRecycleViewAdapter eCRankRecycleViewAdapter2 = this.salesRankRecycleViewAdapter;
        if (eCRankRecycleViewAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("salesRankRecycleViewAdapter");
        }
        eCRankRecycleViewAdapter2.i0();
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Rh();
        Sh();
        Qh().N1();
        Qh().P1();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/ecommerce/biz/productcenter/fragment/ECSalesRankFragment$c", "Lcom/tencent/ecommerce/biz/productcenter/ui/adapter/ECRankRecycleViewAdapter$ECRankCallback;", "", WadlProxyConsts.KEY_JUMP_URL, "Lorg/json/JSONObject;", "goodsInfo", "", "onItemClick", "onAddProductToWindow", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class c implements ECRankRecycleViewAdapter.ECRankCallback {
        c() {
        }

        @Override // com.tencent.ecommerce.biz.productcenter.ui.adapter.ECRankRecycleViewAdapter.ECRankCallback
        public void onAddProductToWindow(JSONObject goodsInfo) {
            ECSalesRankFragment.this.Ph().N1(ECSalesRankFragment.this.requireContext(), goodsInfo.optString("saas_type"), goodsInfo.optString("saas_product_id"), String.valueOf(goodsInfo.optInt("goods_type")), goodsInfo);
        }

        @Override // com.tencent.ecommerce.biz.productcenter.ui.adapter.ECRankRecycleViewAdapter.ECRankCallback
        public void onItemClick(String jumpUrl, JSONObject goodsInfo) {
            ECScheme.g(jumpUrl, null, 2, null);
            ri0.c.f431472c.d(ECSalesRankFragment.this.channel, goodsInfo, ECSalesRankFragment.this.rankType);
        }
    }
}
