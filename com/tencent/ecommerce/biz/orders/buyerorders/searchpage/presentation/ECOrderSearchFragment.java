package com.tencent.ecommerce.biz.orders.buyerorders.searchpage.presentation;

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
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.ecommerce.base.fragment.ECBaseFragment;
import com.tencent.ecommerce.base.ui.ECSearchBarView;
import com.tencent.ecommerce.biz.orders.buyerorders.searchpage.domain.ECOrderSearchScene;
import com.tencent.ecommerce.biz.orders.buyerorders.searchpage.domain.SearchHistoryData;
import com.tencent.ecommerce.biz.orders.sellerorders.container.ECSellerOrderTab;
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
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 A2\u00020\u0001:\u0001BB\u0007\u00a2\u0006\u0004\b?\u0010@J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0018\u0010\r\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\u000f\u001a\u00020\u0005H\u0002J\b\u0010\u0010\u001a\u00020\u0005H\u0002J\b\u0010\u0011\u001a\u00020\u0005H\u0002J\b\u0010\u0012\u001a\u00020\u000bH\u0016J\b\u0010\u0013\u001a\u00020\u000bH\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0016J\u0012\u0010\u0018\u001a\u00020\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016J\u001a\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u00072\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010\u001b\u001a\u00020\u0005H\u0016J\b\u0010\u001c\u001a\u00020\u0003H\u0016R\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u001b\u0010&\u001a\u00020!8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00102\u001a\u00020/8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0016\u00106\u001a\u0002038\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0016\u0010:\u001a\u0002078\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010>\u001a\u00020;8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b<\u0010=\u00a8\u0006C"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/buyerorders/searchpage/presentation/ECOrderSearchFragment;", "Lcom/tencent/ecommerce/base/fragment/ECBaseFragment;", "", "", "searchHistories", "", "Xh", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Wh", "content", "", "requestType", "Yh", "Vh", "initLiveDataObserver", "Zh", "Th", "uh", "getContentLayoutId", "", "Eh", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "onResume", "getBusinessDescription", "Lcom/tencent/ecommerce/biz/orders/buyerorders/searchpage/domain/ECOrderSearchScene;", "P", "Lcom/tencent/ecommerce/biz/orders/buyerorders/searchpage/domain/ECOrderSearchScene;", "searchScene", "Lcom/tencent/ecommerce/biz/orders/buyerorders/searchpage/domain/a;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lkotlin/Lazy;", "Uh", "()Lcom/tencent/ecommerce/biz/orders/buyerorders/searchpage/domain/a;", "viewModel", "Lcom/tencent/ecommerce/base/ui/ECSearchBarView;", BdhLogUtil.LogTag.Tag_Req, "Lcom/tencent/ecommerce/base/ui/ECSearchBarView;", "searchBarView", "Landroidx/recyclerview/widget/RecyclerView;", ExifInterface.LATITUDE_SOUTH, "Landroidx/recyclerview/widget/RecyclerView;", "historyListSection", "Lcom/tencent/ecommerce/biz/shophome/ui/adapter/a;", "T", "Lcom/tencent/ecommerce/biz/shophome/ui/adapter/a;", "historySearchAdapter", "Landroid/widget/FrameLayout;", "U", "Landroid/widget/FrameLayout;", "historyTitleSection", "Landroid/widget/TextView;", "V", "Landroid/widget/TextView;", "cancelHistorySearch", "Landroid/widget/ImageView;", "W", "Landroid/widget/ImageView;", "clearHistoryButton", "<init>", "()V", "X", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECOrderSearchFragment extends ECBaseFragment {

    /* renamed from: P, reason: from kotlin metadata */
    private ECOrderSearchScene searchScene;

    /* renamed from: Q, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* renamed from: R, reason: from kotlin metadata */
    private ECSearchBarView searchBarView;

    /* renamed from: S, reason: from kotlin metadata */
    private RecyclerView historyListSection;

    /* renamed from: T, reason: from kotlin metadata */
    private com.tencent.ecommerce.biz.shophome.ui.adapter.a historySearchAdapter;

    /* renamed from: U, reason: from kotlin metadata */
    private FrameLayout historyTitleSection;

    /* renamed from: V, reason: from kotlin metadata */
    private TextView cancelHistorySearch;

    /* renamed from: W, reason: from kotlin metadata */
    private ImageView clearHistoryButton;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/buyerorders/searchpage/domain/c;", "kotlin.jvm.PlatformType", "it", "", "a", "(Lcom/tencent/ecommerce/biz/orders/buyerorders/searchpage/domain/c;)V"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class b<T> implements Observer<SearchHistoryData> {
        b() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(SearchHistoryData searchHistoryData) {
            List<String> a16 = searchHistoryData.a();
            ECOrderSearchFragment.Nh(ECOrderSearchFragment.this).setVisibility(a16.isEmpty() ^ true ? 0 : 8);
            ECOrderSearchFragment.Mh(ECOrderSearchFragment.this).setData(a16);
            if (searchHistoryData.isFirstInit && (!r2.isEmpty())) {
                ECOrderSearchFragment.this.Xh(a16);
            }
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
            FragmentActivity activity = ECOrderSearchFragment.this.getActivity();
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
            ECOrderSearchFragment.this.Uh().L1();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public ECOrderSearchFragment() {
        Function0<ViewModelProvider.Factory> function0 = new Function0<ViewModelProvider.Factory>() { // from class: com.tencent.ecommerce.biz.orders.buyerorders.searchpage.presentation.ECOrderSearchFragment$viewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return new com.tencent.ecommerce.biz.orders.buyerorders.searchpage.domain.b(ECOrderSearchFragment.Ph(ECOrderSearchFragment.this));
            }
        };
        final Function0<Fragment> function02 = new Function0<Fragment>() { // from class: com.tencent.ecommerce.biz.orders.buyerorders.searchpage.presentation.ECOrderSearchFragment$$special$$inlined$viewModels$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(com.tencent.ecommerce.biz.orders.buyerorders.searchpage.domain.a.class), new Function0<ViewModelStore>() { // from class: com.tencent.ecommerce.biz.orders.buyerorders.searchpage.presentation.ECOrderSearchFragment$$special$$inlined$viewModels$2
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

    public static final /* synthetic */ RecyclerView Lh(ECOrderSearchFragment eCOrderSearchFragment) {
        RecyclerView recyclerView = eCOrderSearchFragment.historyListSection;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("historyListSection");
        }
        return recyclerView;
    }

    public static final /* synthetic */ com.tencent.ecommerce.biz.shophome.ui.adapter.a Mh(ECOrderSearchFragment eCOrderSearchFragment) {
        com.tencent.ecommerce.biz.shophome.ui.adapter.a aVar = eCOrderSearchFragment.historySearchAdapter;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("historySearchAdapter");
        }
        return aVar;
    }

    public static final /* synthetic */ FrameLayout Nh(ECOrderSearchFragment eCOrderSearchFragment) {
        FrameLayout frameLayout = eCOrderSearchFragment.historyTitleSection;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("historyTitleSection");
        }
        return frameLayout;
    }

    public static final /* synthetic */ ECSearchBarView Oh(ECOrderSearchFragment eCOrderSearchFragment) {
        ECSearchBarView eCSearchBarView = eCOrderSearchFragment.searchBarView;
        if (eCSearchBarView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchBarView");
        }
        return eCSearchBarView;
    }

    public static final /* synthetic */ ECOrderSearchScene Ph(ECOrderSearchFragment eCOrderSearchFragment) {
        ECOrderSearchScene eCOrderSearchScene = eCOrderSearchFragment.searchScene;
        if (eCOrderSearchScene == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchScene");
        }
        return eCOrderSearchScene;
    }

    private final void Th() {
        Uh().P1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.ecommerce.biz.orders.buyerorders.searchpage.domain.a Uh() {
        return (com.tencent.ecommerce.biz.orders.buyerorders.searchpage.domain.a) this.viewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Xh(List<String> searchHistories) {
        ECOrderSearchScene eCOrderSearchScene = this.searchScene;
        if (eCOrderSearchScene == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchScene");
        }
        int i3 = a.f103420a[eCOrderSearchScene.ordinal()];
        if (i3 == 1) {
            hi0.a.f404941a.a(searchHistories);
        } else {
            if (i3 != 2) {
                return;
            }
            ki0.b.f412528a.a(searchHistories);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Yh(String content, int requestType) {
        ECOrderSearchScene eCOrderSearchScene = this.searchScene;
        if (eCOrderSearchScene == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchScene");
        }
        int i3 = a.f103421b[eCOrderSearchScene.ordinal()];
        if (i3 == 1) {
            hi0.a.f404941a.c(content, requestType);
        } else {
            if (i3 != 2) {
                return;
            }
            ki0.b.f412528a.e(content, requestType, ECSellerOrderTab.SAMPLE);
        }
    }

    private final void Zh() {
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

    private final void initLiveDataObserver() {
        Uh().O1().observe(getViewLifecycleOwner(), new b());
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment
    public boolean Eh() {
        return true;
    }

    @Override // com.tencent.ecommerce.base.fragment.api.IECBaseFragment
    /* renamed from: getBusinessDescription */
    public String getTAG() {
        return "ECShopOrderSearchFragment";
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment
    public int getContentLayoutId() {
        return R.layout.cr6;
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        int ordinal;
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            ordinal = arguments.getInt("bundle_key_scene");
        } else {
            ordinal = ECOrderSearchScene.Q_SHOP.ordinal();
        }
        this.searchScene = ECOrderSearchScene.values()[ordinal];
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        SearchHistoryData value = Uh().O1().getValue();
        List<String> a16 = value != null ? value.a() : null;
        if (a16 == null || !(!a16.isEmpty())) {
            return;
        }
        Xh(a16);
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Wh(view);
        Vh(view);
        initLiveDataObserver();
        Zh();
        Th();
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment
    public int uh() {
        return 0;
    }

    private final void Vh(View rootView) {
        this.cancelHistorySearch = (TextView) rootView.findViewById(R.id.od8);
        this.historyTitleSection = (FrameLayout) rootView.findViewById(R.id.o0u);
        this.clearHistoryButton = (ImageView) rootView.findViewById(R.id.o1c);
        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.nzk);
        recyclerView.setLayoutManager(new LinearLayoutManager(rootView.getContext()));
        Unit unit = Unit.INSTANCE;
        this.historyListSection = recyclerView;
        com.tencent.ecommerce.biz.shophome.ui.adapter.a aVar = new com.tencent.ecommerce.biz.shophome.ui.adapter.a(requireContext());
        aVar.m0(new Function1<String, Unit>() { // from class: com.tencent.ecommerce.biz.orders.buyerorders.searchpage.presentation.ECOrderSearchFragment$initHistorySearchList$$inlined$with$lambda$1
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
                ECOrderSearchFragment.this.Uh().M1(str);
                ECOrderSearchFragment.Lh(ECOrderSearchFragment.this).scrollToPosition(0);
                ECOrderSearchFragment.Oh(ECOrderSearchFragment.this).setSearchText(str);
                ECOrderSearchResultFragment.INSTANCE.a(ECOrderSearchFragment.this.requireContext(), str, ECOrderSearchFragment.Ph(ECOrderSearchFragment.this));
                ECOrderSearchFragment.this.Yh(str, 2);
            }
        });
        aVar.n0(new Function1<String, Unit>() { // from class: com.tencent.ecommerce.biz.orders.buyerorders.searchpage.presentation.ECOrderSearchFragment$initHistorySearchList$$inlined$with$lambda$2
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
                ECOrderSearchFragment.this.Uh().R1(str);
            }
        });
        this.historySearchAdapter = aVar;
        RecyclerView recyclerView2 = this.historyListSection;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("historyListSection");
        }
        com.tencent.ecommerce.biz.shophome.ui.adapter.a aVar2 = this.historySearchAdapter;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("historySearchAdapter");
        }
        recyclerView2.setAdapter(aVar2);
    }

    private final void Wh(View rootView) {
        ECSearchBarView eCSearchBarView = (ECSearchBarView) rootView.findViewById(R.id.o9t);
        eCSearchBarView.setRequestFocusWhenAttach(true);
        eCSearchBarView.setSearchActionListener(new Function1<String, Unit>() { // from class: com.tencent.ecommerce.biz.orders.buyerorders.searchpage.presentation.ECOrderSearchFragment$initSearchBarView$$inlined$with$lambda$1
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
                ECOrderSearchFragment.this.Uh().M1(str);
                ECOrderSearchResultFragment.INSTANCE.a(ECOrderSearchFragment.this.requireContext(), str, ECOrderSearchFragment.Ph(ECOrderSearchFragment.this));
                ECOrderSearchFragment.this.Yh(str, 1);
            }
        });
        Unit unit = Unit.INSTANCE;
        this.searchBarView = eCSearchBarView;
    }
}
