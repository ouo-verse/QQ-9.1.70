package com.tencent.ecommerce.biz.commission.detail;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.ecommerce.base.ktx.ImageViewKt;
import com.tencent.ecommerce.base.report.api.IECDtReport;
import com.tencent.ecommerce.base.ui.ECSkin;
import com.tencent.ecommerce.biz.commission.ECCommissionUtils;
import com.tencent.ecommerce.biz.commission.detail.ECCommissionItemFragment;
import com.tencent.ecommerce.biz.router.ECScheme;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.pts.core.PTSComposer;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import java.util.HashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import mqq.app.Constants;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n*\u0001,\u0018\u0000 62\u00020\u0001:\u0003789B\u000f\u0012\u0006\u00103\u001a\u000200\u00a2\u0006\u0004\b4\u00105J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J&\u0010\u000e\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\u001a\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\u0010\u001a\u00020\u0004H\u0016R\u001b\u0010\u0016\u001a\u00020\u00118BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001b\u0010\u001b\u001a\u00020\u00178BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0019\u0010\u001aR\u001b\u0010 \u001a\u00020\u001c8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001d\u0010\u0013\u001a\u0004\b\u001e\u0010\u001fR\u0016\u0010#\u001a\u00020\u00028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0014\u0010/\u001a\u00020,8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0014\u00103\u001a\u0002008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b1\u00102\u00a8\u0006:"}, d2 = {"Lcom/tencent/ecommerce/biz/commission/detail/ECCommissionItemFragment;", "Landroidx/fragment/app/Fragment;", "Landroid/view/View;", "view", "", "initView", OcrConfig.CHINESE, "Ah", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreateView", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/ecommerce/biz/commission/detail/ECCommissionItemViewModel;", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/Lazy;", "yh", "()Lcom/tencent/ecommerce/biz/commission/detail/ECCommissionItemViewModel;", "viewModel", "Lcom/tencent/ecommerce/biz/commission/detail/ECCommissionDetailViewModel;", "D", "wh", "()Lcom/tencent/ecommerce/biz/commission/detail/ECCommissionDetailViewModel;", "detailViewModel", "Lcom/tencent/ecommerce/base/ui/d;", "E", "xh", "()Lcom/tencent/ecommerce/base/ui/d;", "loadingDialog", UserInfo.SEX_FEMALE, "Landroid/view/View;", "emptyView", "Landroidx/recyclerview/widget/RecyclerView;", "G", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Lcom/tencent/ecommerce/biz/commission/detail/ECCommissionItemAdapter;", "H", "Lcom/tencent/ecommerce/biz/commission/detail/ECCommissionItemAdapter;", "adapter", "com/tencent/ecommerce/biz/commission/detail/ECCommissionItemFragment$h", "I", "Lcom/tencent/ecommerce/biz/commission/detail/ECCommissionItemFragment$h;", "ptsListener", "Lcom/tencent/ecommerce/biz/commission/detail/ECCommissionItemFragment$TYPE;", "J", "Lcom/tencent/ecommerce/biz/commission/detail/ECCommissionItemFragment$TYPE;", "type", "<init>", "(Lcom/tencent/ecommerce/biz/commission/detail/ECCommissionItemFragment$TYPE;)V", "K", "a", "b", "TYPE", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECCommissionItemFragment extends Fragment {

    /* renamed from: C, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* renamed from: D, reason: from kotlin metadata */
    private final Lazy detailViewModel;

    /* renamed from: E, reason: from kotlin metadata */
    private final Lazy loadingDialog;

    /* renamed from: F, reason: from kotlin metadata */
    private View emptyView;

    /* renamed from: G, reason: from kotlin metadata */
    private RecyclerView recyclerView;

    /* renamed from: H, reason: from kotlin metadata */
    private ECCommissionItemAdapter adapter;

    /* renamed from: I, reason: from kotlin metadata */
    private final h ptsListener;

    /* renamed from: J, reason: from kotlin metadata */
    private final TYPE type;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/ecommerce/biz/commission/detail/ECCommissionItemFragment$TYPE;", "", "(Ljava/lang/String;I)V", "Remittance", "Settlement", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public enum TYPE {
        Remittance,
        Settlement
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\b\u00a2\u0006\u0004\b\f\u0010\rJ)\u0010\u0006\u001a\u00028\u0000\"\n\b\u0000\u0010\u0003*\u0004\u0018\u00010\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/ecommerce/biz/commission/detail/ECCommissionItemFragment$a;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "modelClass", OperateCustomButton.OPERATE_CREATE, "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "Lcom/tencent/ecommerce/biz/commission/detail/ECCommissionItemFragment$TYPE;", "a", "Lcom/tencent/ecommerce/biz/commission/detail/ECCommissionItemFragment$TYPE;", "type", "<init>", "(Lcom/tencent/ecommerce/biz/commission/detail/ECCommissionItemFragment$TYPE;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class a implements ViewModelProvider.Factory {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final TYPE type;

        public a(TYPE type) {
            this.type = type;
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        public <T extends ViewModel> T create(Class<T> modelClass) {
            return modelClass.getConstructor(TYPE.class).newInstance(this.type);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u00042\u001a\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0001 \u0002*\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "Lcom/tencent/ecommerce/biz/commission/detail/a;", "kotlin.jvm.PlatformType", "it", "", "a", "(Ljava/util/List;)V"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class c<T> implements Observer<List<? extends ECBill>> {
        c() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(List<ECBill> list) {
            if (list.isEmpty()) {
                ECCommissionItemFragment.th(ECCommissionItemFragment.this).setVisibility(8);
                ECCommissionItemFragment.rh(ECCommissionItemFragment.this).setVisibility(0);
            } else {
                ECCommissionItemFragment.th(ECCommissionItemFragment.this).setVisibility(0);
                ECCommissionItemFragment.rh(ECCommissionItemFragment.this).setVisibility(8);
                ECCommissionItemFragment.ph(ECCommissionItemFragment.this).l0(list, ECCommissionItemFragment.this.yh().getNoticeString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0006\u001a\u00020\u000522\u0010\u0004\u001a.\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001 \u0003*\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "Lkotlin/Pair;", "", "kotlin.jvm.PlatformType", "it", "", "a", "(Ljava/util/List;)V"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class d<T> implements Observer<List<? extends Pair<? extends String, ? extends String>>> {
        d() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(List<Pair<String, String>> list) {
            ECCommissionItemFragment.this.yh().b2(list);
            ECCommissionItemFragment.th(ECCommissionItemFragment.this).scrollToPosition(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "it", "", "a", "(Ljava/lang/Boolean;)V"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class e<T> implements Observer<Boolean> {
        e() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(Boolean bool) {
            if (bool.booleanValue()) {
                ECCommissionItemFragment.this.xh().show();
            } else {
                ECCommissionItemFragment.this.xh().dismiss();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "it", "", "a", "(Ljava/lang/String;)V"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class f<T> implements Observer<String> {

        /* renamed from: d, reason: collision with root package name */
        public static final f f101452d = new f();

        f() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(String str) {
            if (str.length() > 0) {
                ECScheme.g(str, null, 2, null);
            }
        }
    }

    public ECCommissionItemFragment(TYPE type) {
        Lazy lazy;
        this.type = type;
        Function0<ViewModelProvider.Factory> function0 = new Function0<ViewModelProvider.Factory>() { // from class: com.tencent.ecommerce.biz.commission.detail.ECCommissionItemFragment$viewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                ECCommissionItemFragment.TYPE type2;
                type2 = ECCommissionItemFragment.this.type;
                return new ECCommissionItemFragment.a(type2);
            }
        };
        final Function0<Fragment> function02 = new Function0<Fragment>() { // from class: com.tencent.ecommerce.biz.commission.detail.ECCommissionItemFragment$$special$$inlined$viewModels$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(ECCommissionItemViewModel.class), new Function0<ViewModelStore>() { // from class: com.tencent.ecommerce.biz.commission.detail.ECCommissionItemFragment$$special$$inlined$viewModels$2
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
        }, function0);
        this.detailViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(ECCommissionDetailViewModel.class), new Function0<ViewModelStore>() { // from class: com.tencent.ecommerce.biz.commission.detail.ECCommissionItemFragment$$special$$inlined$activityViewModels$1
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.tencent.ecommerce.biz.commission.detail.ECCommissionItemFragment$$special$$inlined$activityViewModels$2
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
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.ecommerce.base.ui.d>() { // from class: com.tencent.ecommerce.biz.commission.detail.ECCommissionItemFragment$loadingDialog$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.ecommerce.base.ui.d invoke() {
                com.tencent.ecommerce.base.ui.d dVar = new com.tencent.ecommerce.base.ui.d(ECCommissionItemFragment.this.requireContext(), null, 2, null);
                dVar.setCanceledOnTouchOutside(false);
                return dVar;
            }
        });
        this.loadingDialog = lazy;
        this.ptsListener = new h();
    }

    private final void Ah() {
        ECCommissionItemViewModel yh5 = yh();
        List<Pair<String, String>> value = wh().T1().getValue();
        if (value == null) {
            value = CollectionsKt__CollectionsKt.emptyList();
        }
        yh5.b2(value);
    }

    public static final /* synthetic */ ECCommissionItemAdapter ph(ECCommissionItemFragment eCCommissionItemFragment) {
        ECCommissionItemAdapter eCCommissionItemAdapter = eCCommissionItemFragment.adapter;
        if (eCCommissionItemAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        return eCCommissionItemAdapter;
    }

    public static final /* synthetic */ View rh(ECCommissionItemFragment eCCommissionItemFragment) {
        View view = eCCommissionItemFragment.emptyView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("emptyView");
        }
        return view;
    }

    public static final /* synthetic */ RecyclerView th(ECCommissionItemFragment eCCommissionItemFragment) {
        RecyclerView recyclerView = eCCommissionItemFragment.recyclerView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        }
        return recyclerView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ECCommissionDetailViewModel wh() {
        return (ECCommissionDetailViewModel) this.detailViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.ecommerce.base.ui.d xh() {
        return (com.tencent.ecommerce.base.ui.d) this.loadingDialog.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ECCommissionItemViewModel yh() {
        return (ECCommissionItemViewModel) this.viewModel.getValue();
    }

    private final void zh() {
        yh().R1().observe(getViewLifecycleOwner(), new c());
        wh().T1().observe(getViewLifecycleOwner(), new d());
        yh().T1().observe(getViewLifecycleOwner(), new e());
        yh().U1().observe(getViewLifecycleOwner(), f.f101452d);
        Ah();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        ECCommissionItemAdapter eCCommissionItemAdapter = this.adapter;
        if (eCCommissionItemAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        eCCommissionItemAdapter.destroy();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        zh();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J \u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0016R\u0016\u0010\r\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u000e"}, d2 = {"com/tencent/ecommerce/biz/commission/detail/ECCommissionItemFragment$g", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "newState", "", "onScrollStateChanged", "dx", "dy", "onScrolled", "d", "I", "lastVisiblePosition", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class g extends RecyclerView.OnScrollListener {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private int lastVisiblePosition;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ LinearLayoutManager f101455f;

        g(LinearLayoutManager linearLayoutManager) {
            this.f101455f = linearLayoutManager;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int dx5, int dy5) {
            super.onScrolled(recyclerView, dx5, dy5);
            this.lastVisiblePosition = this.f101455f.findLastVisibleItemPosition();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            if (newState != 0 || ECCommissionItemFragment.this.yh().getIsEnd() || this.f101455f.getItemCount() - this.lastVisiblePosition > 4) {
                return;
            }
            ECCommissionItemViewModel yh5 = ECCommissionItemFragment.this.yh();
            List<Pair<String, String>> value = ECCommissionItemFragment.this.wh().T1().getValue();
            if (value == null) {
                value = CollectionsKt__CollectionsKt.emptyList();
            }
            yh5.Z1(value);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JN\u0010\f\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022&\u0010\u0006\u001a\"\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0004j\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u0001`\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/ecommerce/biz/commission/detail/ECCommissionItemFragment$h", "Lcom/tencent/ecommerce/base/ui/e;", "", IECDtReport.ACTION_IDENTIFIER, "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "dataMap", "Landroid/view/View;", "view", "Lcom/tencent/pts/core/PTSComposer;", "ptsComposer", "", "onTapEventTriggered", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class h extends com.tencent.ecommerce.base.ui.e {
        h() {
        }

        @Override // com.tencent.pts.core.lite.IPTSLiteEventListener
        public void onTapEventTriggered(String identifier, HashMap<String, String> dataMap, View view, PTSComposer ptsComposer) {
            String str;
            String str2;
            String str3;
            if (dataMap == null || (str = dataMap.get("eventType")) == null) {
                return;
            }
            int hashCode = str.hashCode();
            if (hashCode != 685833743) {
                if (hashCode == 1616635359 && str.equals("showFailReason") && (str3 = dataMap.get("errorMsgBox")) != null) {
                    ECCommissionUtils.f101430a.c(ECCommissionItemFragment.this.requireContext(), new JSONObject(str3));
                    return;
                }
                return;
            }
            if (!str.equals("taxInfoClick") || (str2 = dataMap.get("taxInfoToken")) == null) {
                return;
            }
            ECCommissionItemFragment.this.yh().c2(str2);
        }
    }

    private final void initView(View view) {
        ECCommissionItemAdapter eCCommissionItemAdapter;
        this.emptyView = view.findViewById(R.id.nqg);
        this.recyclerView = (RecyclerView) view.findViewById(R.id.o8n);
        int i3 = com.tencent.ecommerce.biz.commission.detail.c.f101467a[this.type.ordinal()];
        if (i3 == 1) {
            eCCommissionItemAdapter = new ECCommissionItemAdapter(requireContext(), this.ptsListener, "remittance_card");
        } else if (i3 == 2) {
            eCCommissionItemAdapter = new ECCommissionItemAdapter(requireContext(), null, "settlement_card");
        } else {
            throw new NoWhenBranchMatchedException();
        }
        this.adapter = eCCommissionItemAdapter;
        RecyclerView recyclerView = this.recyclerView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        }
        ECCommissionItemAdapter eCCommissionItemAdapter2 = this.adapter;
        if (eCCommissionItemAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        recyclerView.setAdapter(eCCommissionItemAdapter2);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(requireContext());
        RecyclerView recyclerView2 = this.recyclerView;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        }
        recyclerView2.setLayoutManager(linearLayoutManager);
        RecyclerView recyclerView3 = this.recyclerView;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        }
        recyclerView3.addOnScrollListener(new g(linearLayoutManager));
        String url = ECSkin.INSTANCE.getUrl("qecommerce_skin_emptystate_img_dongtai");
        if (url != null) {
            ImageViewKt.b((ImageView) view.findViewById(R.id.f163034ny4), url, 0, 0, 0, 14, null);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.cpb, container, false);
    }
}
