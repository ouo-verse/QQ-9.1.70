package com.tencent.ecommerce.biz.commission.forecast;

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
import com.tencent.ecommerce.base.fragment.ECBaseFragment;
import com.tencent.ecommerce.base.ui.refreshview.ECommercePullRefreshView;
import com.tencent.ecommerce.base.ui.refreshview.RefreshableLayout;
import com.tencent.ecommerce.biz.commission.forecast.ECCommissionForecastDetailListFragment;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(d1 = {"\u0000[\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\t*\u0001'\u0018\u0000 -2\u00020\u0001:\u0001.B\u0007\u00a2\u0006\u0004\b+\u0010,J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\n\u001a\u00020\bH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u000f\u001a\u00020\rH\u0016J\u001a\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010\u0013\u001a\u00020\u0004H\u0016R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u001b\u0010\u001d\u001a\u00020\u00188BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001b\u0010\"\u001a\u00020\u001e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001f\u0010\u001a\u001a\u0004\b \u0010!R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010*\u001a\u00020'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010)\u00a8\u0006/"}, d2 = {"Lcom/tencent/ecommerce/biz/commission/forecast/ECCommissionForecastDetailListFragment;", "Lcom/tencent/ecommerce/base/fragment/ECBaseFragment;", "Landroid/view/View;", "view", "", "initView", "Rh", "initData", "", "uh", "getContentLayoutId", "", "getBusinessDescription", "", "Dh", "Eh", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "P", "J", "pageEnterTimeInMs", "Lcom/tencent/ecommerce/biz/commission/forecast/l;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lkotlin/Lazy;", "Ph", "()Lcom/tencent/ecommerce/biz/commission/forecast/l;", "adapter", "Lcom/tencent/ecommerce/biz/commission/forecast/ECCommissionForecastDetailListViewModel;", BdhLogUtil.LogTag.Tag_Req, "Qh", "()Lcom/tencent/ecommerce/biz/commission/forecast/ECCommissionForecastDetailListViewModel;", "viewModel", "Lcom/tencent/ecommerce/base/ui/refreshview/ECommercePullRefreshView;", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/ecommerce/base/ui/refreshview/ECommercePullRefreshView;", "refreshLayout", "com/tencent/ecommerce/biz/commission/forecast/ECCommissionForecastDetailListFragment$g", "T", "Lcom/tencent/ecommerce/biz/commission/forecast/ECCommissionForecastDetailListFragment$g;", "itemOperationListener", "<init>", "()V", "U", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECCommissionForecastDetailListFragment extends ECBaseFragment {

    /* renamed from: P, reason: from kotlin metadata */
    private long pageEnterTimeInMs = System.currentTimeMillis();

    /* renamed from: Q, reason: from kotlin metadata */
    private final Lazy adapter;

    /* renamed from: R, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* renamed from: S, reason: from kotlin metadata */
    private ECommercePullRefreshView refreshLayout;

    /* renamed from: T, reason: from kotlin metadata */
    private final g itemOperationListener;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u00042\u001a\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0001 \u0002*\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "Lcom/tencent/ecommerce/biz/commission/forecast/e;", "kotlin.jvm.PlatformType", "it", "", "a", "(Ljava/util/List;)V"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class b<T> implements Observer<List<? extends com.tencent.ecommerce.biz.commission.forecast.e>> {
        b() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(List<? extends com.tencent.ecommerce.biz.commission.forecast.e> list) {
            ECCommissionForecastDetailListFragment.this.Ph().k0(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "it", "", "a", "(Ljava/lang/Boolean;)V"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class d<T> implements Observer<Boolean> {
        d() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(Boolean bool) {
            ECCommissionForecastDetailListFragment.Nh(ECCommissionForecastDetailListFragment.this).setEnableLoadMore(bool.booleanValue());
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\u0007\u00b8\u0006\u0000"}, d2 = {"com/tencent/ecommerce/biz/commission/forecast/ECCommissionForecastDetailListFragment$initView$2$1", "Lcom/tencent/ecommerce/base/ui/refreshview/ECommercePullRefreshView$OnRefreshStateListener;", "", "tag", "", "onRefreshBegin", "onLoadMoreBegin", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class e implements ECommercePullRefreshView.OnRefreshStateListener {
        e() {
        }

        @Override // com.tencent.ecommerce.base.ui.refreshview.ECommercePullRefreshView.OnRefreshStateListener
        public void onLoadMoreBegin() {
            ECCommissionForecastDetailListFragment.this.Qh().loadMore();
        }

        @Override // com.tencent.ecommerce.base.ui.refreshview.ECommercePullRefreshView.OnRefreshStateListener
        public void onRefreshBegin(int tag) {
            ECCommissionForecastDetailListFragment.this.Qh().refresh();
        }

        @Override // com.tencent.ecommerce.base.ui.refreshview.ECommercePullRefreshView.OnRefreshStateListener
        public void onRefreshFinished(boolean z16, int i3) {
            ECommercePullRefreshView.OnRefreshStateListener.a.a(this, z16, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class f implements View.OnClickListener {
        f() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ECCommissionForecastDetailListFragment.this.requireActivity().finish();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/ecommerce/biz/commission/forecast/ECCommissionForecastDetailListFragment$g", "Lcom/tencent/ecommerce/biz/commission/forecast/ItemOperationListener;", "Landroid/view/View;", "view", "", "onRetryBtnClick", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class g implements ItemOperationListener {
        g() {
        }

        @Override // com.tencent.ecommerce.biz.commission.forecast.ItemOperationListener
        public void onRetryBtnClick(View view) {
            RefreshableLayout.c(ECCommissionForecastDetailListFragment.Nh(ECCommissionForecastDetailListFragment.this), true, 0, 2, null);
        }
    }

    public ECCommissionForecastDetailListFragment() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<l>() { // from class: com.tencent.ecommerce.biz.commission.forecast.ECCommissionForecastDetailListFragment$adapter$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final l invoke() {
                ECCommissionForecastDetailListFragment.g gVar;
                gVar = ECCommissionForecastDetailListFragment.this.itemOperationListener;
                return new l(gVar);
            }
        });
        this.adapter = lazy;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.tencent.ecommerce.biz.commission.forecast.ECCommissionForecastDetailListFragment$$special$$inlined$viewModels$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(ECCommissionForecastDetailListViewModel.class), new Function0<ViewModelStore>() { // from class: com.tencent.ecommerce.biz.commission.forecast.ECCommissionForecastDetailListFragment$$special$$inlined$viewModels$2
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
        this.itemOperationListener = new g();
    }

    public static final /* synthetic */ ECommercePullRefreshView Nh(ECCommissionForecastDetailListFragment eCCommissionForecastDetailListFragment) {
        ECommercePullRefreshView eCommercePullRefreshView = eCCommissionForecastDetailListFragment.refreshLayout;
        if (eCommercePullRefreshView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
        }
        return eCommercePullRefreshView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final l Ph() {
        return (l) this.adapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ECCommissionForecastDetailListViewModel Qh() {
        return (ECCommissionForecastDetailListViewModel) this.viewModel.getValue();
    }

    private final void Rh() {
        Qh().P1().observe(getViewLifecycleOwner(), new b());
        Qh().R1().observe(getViewLifecycleOwner(), new c());
        Qh().Q1().observe(getViewLifecycleOwner(), new d());
    }

    private final void initData() {
        Qh().refresh();
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
        return "ECCommissionForecastDetailListFragment";
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment
    public int getContentLayoutId() {
        return R.layout.cp_;
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        o.f101491a.a(System.currentTimeMillis() - this.pageEnterTimeInMs);
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        Rh();
        initData();
        this.pageEnterTimeInMs = o.f101491a.b();
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment
    public int uh() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/tencent/ecommerce/biz/commission/forecast/LoadingStatus;", "kotlin.jvm.PlatformType", "it", "", "a", "(Lcom/tencent/ecommerce/biz/commission/forecast/LoadingStatus;)V"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class c<T> implements Observer<LoadingStatus> {
        c() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(LoadingStatus loadingStatus) {
            if (loadingStatus == null) {
                return;
            }
            int i3 = m.f101489a[loadingStatus.ordinal()];
            if (i3 == 1) {
                ECCommissionForecastDetailListFragment.Nh(ECCommissionForecastDetailListFragment.this).finishLoadMore(true);
                return;
            }
            if (i3 == 2) {
                ECCommissionForecastDetailListFragment.Nh(ECCommissionForecastDetailListFragment.this).finishRefresh(true);
            } else if (i3 == 3) {
                ECCommissionForecastDetailListFragment.Nh(ECCommissionForecastDetailListFragment.this).finishLoadMore(false);
            } else {
                if (i3 != 4) {
                    return;
                }
                ECCommissionForecastDetailListFragment.Nh(ECCommissionForecastDetailListFragment.this).finishRefresh(false);
            }
        }
    }

    private final void initView(View view) {
        this.refreshLayout = (ECommercePullRefreshView) view.findViewById(R.id.o8p);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.o8m);
        recyclerView.setItemAnimator(null);
        recyclerView.setPadding(0, com.tencent.ecommerce.biz.util.e.c(8.0f), 0, 0);
        recyclerView.setAdapter(Ph());
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext(), 1, false));
        ECommercePullRefreshView eCommercePullRefreshView = this.refreshLayout;
        if (eCommercePullRefreshView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
        }
        eCommercePullRefreshView.setHideFooterIfNoMore(true);
        eCommercePullRefreshView.setHideFooterBeforeLoadingMore(true);
        eCommercePullRefreshView.setOnRefreshStateListener(new e());
        view.findViewById(R.id.o0w).setOnClickListener(new f());
    }
}
