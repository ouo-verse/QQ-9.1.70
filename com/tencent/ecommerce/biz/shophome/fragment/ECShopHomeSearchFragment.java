package com.tencent.ecommerce.biz.shophome.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
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
import com.tencent.ecommerce.base.fragment.ECBaseFragment;
import com.tencent.ecommerce.base.router.api.IECSchemeCallback;
import com.tencent.ecommerce.base.ui.ECSearchBarView;
import com.tencent.ecommerce.biz.advertise.ECAdAttributionReporter;
import com.tencent.ecommerce.biz.shophome.ui.adapter.a;
import com.tencent.ecommerce.biz.shophome.util.ECShopReportParams;
import com.tencent.ecommerce.biz.shophome.util.b;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 B2\u00020\u0001:\u0001CB\u0007\u00a2\u0006\u0004\b@\u0010AJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0002J\b\u0010\t\u001a\u00020\u0002H\u0002J\b\u0010\n\u001a\u00020\u0002H\u0002J\b\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\u001a\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010\u0013\u001a\u00020\u0002H\u0016J\b\u0010\u0014\u001a\u00020\u0002H\u0016J\b\u0010\u0016\u001a\u00020\u0015H\u0016R\u001b\u0010\u001c\u001a\u00020\u00178BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0016\u00107\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0016\u00109\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00106R\u0016\u0010;\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u00106R\u0018\u0010?\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010>\u00a8\u0006D"}, d2 = {"Lcom/tencent/ecommerce/biz/shophome/fragment/ECShopHomeSearchFragment;", "Lcom/tencent/ecommerce/base/fragment/ECBaseFragment;", "", "initArguments", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Uh", "Th", "initLiveDataObserver", "Vh", "Rh", "", "getContentLayoutId", "", "Eh", "view", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "onResume", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "getBusinessDescription", "Lcom/tencent/ecommerce/biz/shophome/viewmodel/b;", "P", "Lkotlin/Lazy;", "Sh", "()Lcom/tencent/ecommerce/biz/shophome/viewmodel/b;", "viewModel", "Lcom/tencent/ecommerce/base/ui/ECSearchBarView;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/tencent/ecommerce/base/ui/ECSearchBarView;", "searchBarView", "Landroidx/recyclerview/widget/RecyclerView;", BdhLogUtil.LogTag.Tag_Req, "Landroidx/recyclerview/widget/RecyclerView;", "historyListSection", "Lcom/tencent/ecommerce/biz/shophome/ui/adapter/a;", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/ecommerce/biz/shophome/ui/adapter/a;", "historySearchAdapter", "Landroid/widget/FrameLayout;", "T", "Landroid/widget/FrameLayout;", "historyTitleSection", "Landroid/widget/TextView;", "U", "Landroid/widget/TextView;", "cancelHistorySearch", "Landroid/widget/ImageView;", "V", "Landroid/widget/ImageView;", "clearHistoryButton", "W", "Ljava/lang/String;", "shopId", "X", "isSelect", "Y", "adClickId", "Lcom/tencent/ecommerce/base/router/api/IECSchemeCallback;", "Z", "Lcom/tencent/ecommerce/base/router/api/IECSchemeCallback;", "deliverProductCallback", "<init>", "()V", "a0", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECShopHomeSearchFragment extends ECBaseFragment {

    /* renamed from: P, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* renamed from: Q, reason: from kotlin metadata */
    private ECSearchBarView searchBarView;

    /* renamed from: R, reason: from kotlin metadata */
    private RecyclerView historyListSection;

    /* renamed from: S, reason: from kotlin metadata */
    private a historySearchAdapter;

    /* renamed from: T, reason: from kotlin metadata */
    private FrameLayout historyTitleSection;

    /* renamed from: U, reason: from kotlin metadata */
    private TextView cancelHistorySearch;

    /* renamed from: V, reason: from kotlin metadata */
    private ImageView clearHistoryButton;

    /* renamed from: W, reason: from kotlin metadata */
    private String shopId;

    /* renamed from: X, reason: from kotlin metadata */
    private String isSelect;

    /* renamed from: Y, reason: from kotlin metadata */
    private String adClickId;

    /* renamed from: Z, reason: from kotlin metadata */
    private IECSchemeCallback deliverProductCallback;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u00042\u001a\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0001 \u0002*\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "", "kotlin.jvm.PlatformType", "it", "", "a", "(Ljava/util/List;)V"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class b<T> implements Observer<List<? extends String>> {
        b() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(List<String> list) {
            ECShopHomeSearchFragment.Oh(ECShopHomeSearchFragment.this).setVisibility(list.isEmpty() ^ true ? 0 : 8);
            ECShopHomeSearchFragment.Nh(ECShopHomeSearchFragment.this).setData(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            FragmentActivity activity = ECShopHomeSearchFragment.this.getActivity();
            if (activity != null) {
                activity.onBackPressed();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ECShopHomeSearchFragment.this.Sh().M1();
            com.tencent.ecommerce.biz.shophome.util.a aVar = com.tencent.ecommerce.biz.shophome.util.a.f104379a;
            ECShopReportParams c16 = aVar.c(ECShopHomeSearchFragment.this.getArguments());
            aVar.m(c16.role, c16.shopId, c16.source);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public ECShopHomeSearchFragment() {
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.tencent.ecommerce.biz.shophome.fragment.ECShopHomeSearchFragment$$special$$inlined$viewModels$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(com.tencent.ecommerce.biz.shophome.viewmodel.b.class), new Function0<ViewModelStore>() { // from class: com.tencent.ecommerce.biz.shophome.fragment.ECShopHomeSearchFragment$$special$$inlined$viewModels$2
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
        this.shopId = "";
        this.isSelect = "0";
        this.adClickId = "";
    }

    public static final /* synthetic */ RecyclerView Mh(ECShopHomeSearchFragment eCShopHomeSearchFragment) {
        RecyclerView recyclerView = eCShopHomeSearchFragment.historyListSection;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("historyListSection");
        }
        return recyclerView;
    }

    public static final /* synthetic */ a Nh(ECShopHomeSearchFragment eCShopHomeSearchFragment) {
        a aVar = eCShopHomeSearchFragment.historySearchAdapter;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("historySearchAdapter");
        }
        return aVar;
    }

    public static final /* synthetic */ FrameLayout Oh(ECShopHomeSearchFragment eCShopHomeSearchFragment) {
        FrameLayout frameLayout = eCShopHomeSearchFragment.historyTitleSection;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("historyTitleSection");
        }
        return frameLayout;
    }

    public static final /* synthetic */ ECSearchBarView Ph(ECShopHomeSearchFragment eCShopHomeSearchFragment) {
        ECSearchBarView eCSearchBarView = eCShopHomeSearchFragment.searchBarView;
        if (eCSearchBarView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchBarView");
        }
        return eCSearchBarView;
    }

    private final void Rh() {
        Sh().O1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.ecommerce.biz.shophome.viewmodel.b Sh() {
        return (com.tencent.ecommerce.biz.shophome.viewmodel.b) this.viewModel.getValue();
    }

    private final void Vh() {
        TextView textView = this.cancelHistorySearch;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cancelHistorySearch");
        }
        textView.setOnClickListener(new c());
        ImageView imageView = this.clearHistoryButton;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("clearHistoryButton");
        }
        imageView.setOnClickListener(new d());
    }

    private final void initArguments() {
        String str;
        String str2;
        String str3;
        Intent intent;
        String stringExtra;
        Bundle arguments = getArguments();
        String str4 = "";
        if (arguments == null || (str = arguments.getString("qz_gdt")) == null) {
            str = "";
        }
        this.adClickId = str;
        Bundle arguments2 = getArguments();
        if (arguments2 == null || (str2 = arguments2.getString("shop_id")) == null) {
            str2 = "";
        }
        this.shopId = str2;
        Bundle arguments3 = getArguments();
        if (arguments3 == null || (str3 = arguments3.getString("is_select", "")) == null) {
            str3 = "";
        }
        this.isSelect = str3;
        FragmentActivity activity = getActivity();
        if (activity != null && (intent = activity.getIntent()) != null && (stringExtra = intent.getStringExtra("scheme_callback_id")) != null) {
            str4 = stringExtra;
        }
        this.deliverProductCallback = ug0.a.b(str4);
    }

    private final void initLiveDataObserver() {
        Sh().N1().observe(getViewLifecycleOwner(), new b());
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment
    public boolean Eh() {
        return true;
    }

    @Override // com.tencent.ecommerce.base.fragment.api.IECBaseFragment
    /* renamed from: getBusinessDescription */
    public String getTAG() {
        return "ECShopHomeSearchFragment";
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment
    public int getContentLayoutId() {
        return R.layout.cr6;
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        ECSearchBarView eCSearchBarView = this.searchBarView;
        if (eCSearchBarView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchBarView");
        }
        eCSearchBarView.d();
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ECSearchBarView eCSearchBarView = this.searchBarView;
        if (eCSearchBarView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchBarView");
        }
        eCSearchBarView.e();
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initArguments();
        Uh(view);
        Th(view);
        initLiveDataObserver();
        Vh();
        Rh();
    }

    private final void Th(View rootView) {
        this.cancelHistorySearch = (TextView) rootView.findViewById(R.id.od8);
        this.historyTitleSection = (FrameLayout) rootView.findViewById(R.id.o0u);
        this.clearHistoryButton = (ImageView) rootView.findViewById(R.id.o1c);
        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.nzk);
        recyclerView.setLayoutManager(new LinearLayoutManager(rootView.getContext()));
        Unit unit = Unit.INSTANCE;
        this.historyListSection = recyclerView;
        a aVar = new a(requireContext());
        aVar.m0(new Function1<String, Unit>() { // from class: com.tencent.ecommerce.biz.shophome.fragment.ECShopHomeSearchFragment$initHistorySearchList$$inlined$with$lambda$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String str) {
                String str2;
                ECShopHomeSearchFragment.this.Sh().L1(str);
                ECShopHomeSearchFragment.Mh(ECShopHomeSearchFragment.this).scrollToPosition(0);
                ECShopHomeSearchFragment.Ph(ECShopHomeSearchFragment.this).setSearchText(str);
                com.tencent.ecommerce.biz.shophome.util.a aVar2 = com.tencent.ecommerce.biz.shophome.util.a.f104379a;
                ECShopReportParams c16 = aVar2.c(ECShopHomeSearchFragment.this.getArguments());
                aVar2.n(c16.role, c16.shopId, c16.source);
                b.f104380a.e(ECShopHomeSearchFragment.this.requireActivity(), ECShopHomeSearchFragment.this.getArguments(), str);
                ECAdAttributionReporter eCAdAttributionReporter = ECAdAttributionReporter.f101288c;
                str2 = ECShopHomeSearchFragment.this.adClickId;
                eCAdAttributionReporter.j(str2);
            }
        });
        aVar.n0(new Function1<String, Unit>() { // from class: com.tencent.ecommerce.biz.shophome.fragment.ECShopHomeSearchFragment$initHistorySearchList$$inlined$with$lambda$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String str) {
                ECShopHomeSearchFragment.this.Sh().P1(str);
                com.tencent.ecommerce.biz.shophome.util.a aVar2 = com.tencent.ecommerce.biz.shophome.util.a.f104379a;
                ECShopReportParams c16 = aVar2.c(ECShopHomeSearchFragment.this.getArguments());
                aVar2.o(c16.role, c16.shopId, c16.source);
            }
        });
        this.historySearchAdapter = aVar;
        RecyclerView recyclerView2 = this.historyListSection;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("historyListSection");
        }
        a aVar2 = this.historySearchAdapter;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("historySearchAdapter");
        }
        recyclerView2.setAdapter(aVar2);
    }

    private final void Uh(View rootView) {
        ECSearchBarView eCSearchBarView = (ECSearchBarView) rootView.findViewById(R.id.o9t);
        eCSearchBarView.setRequestFocusWhenAttach(true);
        eCSearchBarView.setSearchActionListener(new Function1<String, Unit>() { // from class: com.tencent.ecommerce.biz.shophome.fragment.ECShopHomeSearchFragment$initSearchBarView$$inlined$with$lambda$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String str) {
                String str2;
                ECShopHomeSearchFragment.this.Sh().L1(str);
                com.tencent.ecommerce.biz.shophome.util.a aVar = com.tencent.ecommerce.biz.shophome.util.a.f104379a;
                ECShopReportParams c16 = aVar.c(ECShopHomeSearchFragment.this.getArguments());
                aVar.l(c16.role, c16.shopId, c16.source);
                b.f104380a.e(ECShopHomeSearchFragment.this.requireActivity(), ECShopHomeSearchFragment.this.getArguments(), str);
                ECAdAttributionReporter eCAdAttributionReporter = ECAdAttributionReporter.f101288c;
                str2 = ECShopHomeSearchFragment.this.adClickId;
                eCAdAttributionReporter.j(str2);
            }
        });
        Unit unit = Unit.INSTANCE;
        this.searchBarView = eCSearchBarView;
    }
}
