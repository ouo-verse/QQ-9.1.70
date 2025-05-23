package com.tencent.ecommerce.biz.detail.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.ecommerce.base.fragment.ECBaseFragment;
import com.tencent.ecommerce.base.list.IStateCenterView;
import com.tencent.ecommerce.base.ui.ECBasePtsViewData;
import com.tencent.ecommerce.base.ui.component.ECBaseRecyclerView;
import com.tencent.ecommerce.base.ui.stateview.ECStateCenterView;
import com.tencent.ecommerce.base.ui.tabbar.ECTabLayout;
import com.tencent.ecommerce.biz.detail.ProductCommentSortType;
import com.tencent.ecommerce.biz.detail.ui.ECProductCommentTabController;
import com.tencent.ecommerce.biz.detail.viewmodel.shop.ECShopProductCommentViewModel;
import com.tencent.ecommerce.biz.detail.viewmodel.shop.b;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import mqq.app.Constants;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 D2\u00020\u00012\u00020\u0002:\u0001EB\u0007\u00a2\u0006\u0004\bC\u0010<J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0003H\u0002J\u001a\u0010\f\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\tH\u0002J\u0012\u0010\u000f\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u0010\u001a\u00020\u0003H\u0016J\u001a\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\b\u0010\u0016\u001a\u00020\u0015H\u0016J\b\u0010\u0017\u001a\u00020\tH\u0016J\b\u0010\u0018\u001a\u00020\tH\u0016J\b\u0010\u0019\u001a\u00020\tH\u0016J\u0012\u0010\u001b\u001a\u00020\u00032\b\b\u0001\u0010\u001a\u001a\u00020\u0013H\u0016R\u001b\u0010!\u001a\u00020\u001c8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0016\u00105\u001a\u0002028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0016\u00108\u001a\u00020\u00158\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b6\u00107R\u001c\u0010=\u001a\u00020\u00138\u0002@\u0002X\u0083\u000e\u00a2\u0006\f\n\u0004\b9\u0010:\u0012\u0004\b;\u0010<R\u001b\u0010B\u001a\u00020>8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b?\u0010\u001e\u001a\u0004\b@\u0010A\u00a8\u0006F"}, d2 = {"Lcom/tencent/ecommerce/biz/detail/fragment/ECShopProductCommentPageFragment;", "Lcom/tencent/ecommerce/base/fragment/ECBaseFragment;", "Lcom/tencent/ecommerce/biz/detail/ui/ECProductCommentTabController$OnSortTypeChangedListener;", "", "initArguments", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "initUI", "Sh", "", "isRefreshFetch", "isFetchBackground", "Th", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "", "getContentLayoutId", "", "getBusinessDescription", "Eh", "Dh", "Bh", "sortType", "onSortTypeChanged", "Lkotlinx/coroutines/CoroutineScope;", "P", "Lkotlin/Lazy;", "Qh", "()Lkotlinx/coroutines/CoroutineScope;", "lifecycleScope", "Lcom/tencent/ecommerce/base/ui/component/ECBaseRecyclerView;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/tencent/ecommerce/base/ui/component/ECBaseRecyclerView;", "recyclerView", "Lbh0/b;", BdhLogUtil.LogTag.Tag_Req, "Lbh0/b;", "recyclerViewAdapter", "Lcom/tencent/ecommerce/base/ui/tabbar/ECTabLayout;", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/ecommerce/base/ui/tabbar/ECTabLayout;", "tabLayout", "Lcom/tencent/ecommerce/biz/detail/ui/ECProductCommentTabController;", "T", "Lcom/tencent/ecommerce/biz/detail/ui/ECProductCommentTabController;", "tabController", "Lcom/tencent/ecommerce/base/ui/stateview/ECStateCenterView;", "U", "Lcom/tencent/ecommerce/base/ui/stateview/ECStateCenterView;", "stateView", "V", "Ljava/lang/String;", "spuId", "W", "I", "getCurrentSortType$annotations", "()V", "currentSortType", "Lcom/tencent/ecommerce/biz/detail/viewmodel/shop/ECShopProductCommentViewModel;", "X", "Rh", "()Lcom/tencent/ecommerce/biz/detail/viewmodel/shop/ECShopProductCommentViewModel;", "viewModel", "<init>", "Y", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECShopProductCommentPageFragment extends ECBaseFragment implements ECProductCommentTabController.OnSortTypeChangedListener {

    /* renamed from: P, reason: from kotlin metadata */
    private final Lazy lifecycleScope;

    /* renamed from: Q, reason: from kotlin metadata */
    private ECBaseRecyclerView recyclerView;

    /* renamed from: R, reason: from kotlin metadata */
    private bh0.b recyclerViewAdapter;

    /* renamed from: S, reason: from kotlin metadata */
    private ECTabLayout tabLayout;

    /* renamed from: T, reason: from kotlin metadata */
    private ECProductCommentTabController tabController;

    /* renamed from: U, reason: from kotlin metadata */
    private ECStateCenterView stateView;

    /* renamed from: V, reason: from kotlin metadata */
    private String spuId;

    /* renamed from: W, reason: from kotlin metadata */
    private int currentSortType;

    /* renamed from: X, reason: from kotlin metadata */
    private final Lazy viewModel;

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\t\u0010\u0003\u001a\u00020\u0002H\u0096\u0002\u00a8\u0006\u0004"}, d2 = {"com/tencent/ecommerce/biz/detail/fragment/ECShopProductCommentPageFragment$b", "Lkotlin/Function0;", "", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class b implements Function0<Unit> {
        b() {
        }

        public void a() {
            ECShopProductCommentPageFragment.Uh(ECShopProductCommentPageFragment.this, true, false, 2, null);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/ecommerce/biz/detail/fragment/ECShopProductCommentPageFragment$c", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "dx", "dy", "", "onScrolled", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class c extends RecyclerView.OnScrollListener {
        c() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int dx5, int dy5) {
            super.onScrolled(recyclerView, dx5, dy5);
            if (ECShopProductCommentPageFragment.this.Rh().getIsListEnd().get()) {
                return;
            }
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            if (!(layoutManager instanceof LinearLayoutManager) || dy5 <= 0) {
                return;
            }
            if (((LinearLayoutManager) layoutManager).findLastVisibleItemPosition() >= r1.getItemCount() - 10) {
                ECShopProductCommentPageFragment.this.Th(false, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0006\u001a\u00020\u000520\u0010\u0004\u001a,\u0012\u0004\u0012\u00020\u0001 \u0003*\u0016\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0000j\n\u0012\u0004\u0012\u00020\u0001\u0018\u0001`\u00020\u0000j\b\u0012\u0004\u0012\u00020\u0001`\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Ljava/util/ArrayList;", "Lcom/tencent/ecommerce/base/ui/b;", "Lkotlin/collections/ArrayList;", "kotlin.jvm.PlatformType", "it", "", "a", "(Ljava/util/ArrayList;)V"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class d<T> implements Observer<ArrayList<ECBasePtsViewData>> {
        d() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(ArrayList<ECBasePtsViewData> arrayList) {
            ArrayList arrayList2 = new ArrayList();
            arrayList2.addAll(arrayList);
            ECShopProductCommentPageFragment.Mh(ECShopProductCommentPageFragment.this).setData(arrayList2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/tencent/ecommerce/biz/detail/viewmodel/shop/ECShopProductCommentViewModel$b;", "kotlin.jvm.PlatformType", "it", "", "a", "(Lcom/tencent/ecommerce/biz/detail/viewmodel/shop/ECShopProductCommentViewModel$b;)V"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class e<T> implements Observer<ECShopProductCommentViewModel.b> {
        e() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(ECShopProductCommentViewModel.b bVar) {
            if (Intrinsics.areEqual(bVar, ECShopProductCommentViewModel.b.c.f102480a)) {
                IStateCenterView.a.c(ECShopProductCommentPageFragment.Nh(ECShopProductCommentPageFragment.this), null, 1, null);
                return;
            }
            if (Intrinsics.areEqual(bVar, ECShopProductCommentViewModel.b.d.f102481a)) {
                ECShopProductCommentPageFragment.Nh(ECShopProductCommentPageFragment.this).setSucceededState();
            } else if (Intrinsics.areEqual(bVar, ECShopProductCommentViewModel.b.a.f102478a)) {
                IStateCenterView.a.a(ECShopProductCommentPageFragment.Nh(ECShopProductCommentPageFragment.this), null, null, 0, 7, null);
            } else if (Intrinsics.areEqual(bVar, ECShopProductCommentViewModel.b.C1054b.f102479a)) {
                IStateCenterView.a.b(ECShopProductCommentPageFragment.Nh(ECShopProductCommentPageFragment.this), null, 1, null);
            }
        }
    }

    public ECShopProductCommentPageFragment() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<CoroutineScope>() { // from class: com.tencent.ecommerce.biz.detail.fragment.ECShopProductCommentPageFragment$lifecycleScope$2
            @Override // kotlin.jvm.functions.Function0
            public final CoroutineScope invoke() {
                return CoroutineScopeKt.MainScope();
            }
        });
        this.lifecycleScope = lazy;
        this.currentSortType = 1;
        Function0<ViewModelProvider.Factory> function0 = new Function0<ViewModelProvider.Factory>() { // from class: com.tencent.ecommerce.biz.detail.fragment.ECShopProductCommentPageFragment$viewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return new b(ECShopProductCommentPageFragment.this.getArguments());
            }
        };
        final Function0<Fragment> function02 = new Function0<Fragment>() { // from class: com.tencent.ecommerce.biz.detail.fragment.ECShopProductCommentPageFragment$$special$$inlined$viewModels$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(ECShopProductCommentViewModel.class), new Function0<ViewModelStore>() { // from class: com.tencent.ecommerce.biz.detail.fragment.ECShopProductCommentPageFragment$$special$$inlined$viewModels$2
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
        }, function0);
    }

    public static final /* synthetic */ bh0.b Mh(ECShopProductCommentPageFragment eCShopProductCommentPageFragment) {
        bh0.b bVar = eCShopProductCommentPageFragment.recyclerViewAdapter;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerViewAdapter");
        }
        return bVar;
    }

    public static final /* synthetic */ ECStateCenterView Nh(ECShopProductCommentPageFragment eCShopProductCommentPageFragment) {
        ECStateCenterView eCStateCenterView = eCShopProductCommentPageFragment.stateView;
        if (eCStateCenterView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stateView");
        }
        return eCStateCenterView;
    }

    private final CoroutineScope Qh() {
        return (CoroutineScope) this.lifecycleScope.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ECShopProductCommentViewModel Rh() {
        return (ECShopProductCommentViewModel) this.viewModel.getValue();
    }

    private final void Sh() {
        Rh().S1().observe(getViewLifecycleOwner(), new d());
        Rh().T1().observe(getViewLifecycleOwner(), new e());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Th(boolean isRefreshFetch, boolean isFetchBackground) {
        BuildersKt__Builders_commonKt.launch$default(Qh(), null, null, new ECShopProductCommentPageFragment$requestData$1(this, isRefreshFetch, isFetchBackground, null), 3, null);
    }

    private final void initArguments() {
        String string;
        Bundle arguments = getArguments();
        String str = "";
        if (arguments != null && (string = arguments.getString("spu_id", "")) != null) {
            str = string;
        }
        this.spuId = str;
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
        return "ECShopProductCommentPageFragment";
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment
    public int getContentLayoutId() {
        return R.layout.cr7;
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initArguments();
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        CoroutineScopeKt.cancel$default(Qh(), null, 1, null);
    }

    @Override // com.tencent.ecommerce.biz.detail.ui.ECProductCommentTabController.OnSortTypeChangedListener
    public void onSortTypeChanged(@ProductCommentSortType int sortType) {
        this.currentSortType = sortType;
        Uh(this, true, false, 2, null);
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initUI(view);
        Sh();
        Uh(this, true, false, 2, null);
    }

    private final void initUI(View rootView) {
        setTitle(R.string.whe);
        ECStateCenterView eCStateCenterView = (ECStateCenterView) rootView.findViewById(R.id.f163012nu2);
        this.stateView = eCStateCenterView;
        if (eCStateCenterView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stateView");
        }
        eCStateCenterView.setRetryListener(new b());
        this.tabLayout = (ECTabLayout) rootView.findViewById(R.id.nxj);
        Context requireContext = requireContext();
        ECTabLayout eCTabLayout = this.tabLayout;
        if (eCTabLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
        }
        String str = this.spuId;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("spuId");
        }
        ECProductCommentTabController eCProductCommentTabController = new ECProductCommentTabController(requireContext, eCTabLayout, str);
        this.tabController = eCProductCommentTabController;
        eCProductCommentTabController.i();
        ECProductCommentTabController eCProductCommentTabController2 = this.tabController;
        if (eCProductCommentTabController2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabController");
        }
        eCProductCommentTabController2.j(this);
        this.recyclerView = (ECBaseRecyclerView) rootView.findViewById(R.id.nxk);
        this.recyclerViewAdapter = new bh0.b(requireContext(), Rh());
        ECBaseRecyclerView eCBaseRecyclerView = this.recyclerView;
        if (eCBaseRecyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        }
        bh0.b bVar = this.recyclerViewAdapter;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerViewAdapter");
        }
        eCBaseRecyclerView.setAdapter(bVar);
        ECBaseRecyclerView eCBaseRecyclerView2 = this.recyclerView;
        if (eCBaseRecyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        }
        eCBaseRecyclerView2.setLayoutManager(new LinearLayoutManager(requireContext(), 1, false));
        ECBaseRecyclerView eCBaseRecyclerView3 = this.recyclerView;
        if (eCBaseRecyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        }
        eCBaseRecyclerView3.addOnScrollListener(new c());
    }

    static /* synthetic */ void Uh(ECShopProductCommentPageFragment eCShopProductCommentPageFragment, boolean z16, boolean z17, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z17 = false;
        }
        eCShopProductCommentPageFragment.Th(z16, z17);
    }
}
