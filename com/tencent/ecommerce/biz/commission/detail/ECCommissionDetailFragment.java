package com.tencent.ecommerce.biz.commission.detail;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.d;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ecommerce.base.fragment.ECBaseFragment;
import com.tencent.ecommerce.base.ui.ECSkin;
import com.tencent.ecommerce.biz.commission.detail.ECCommissionItemFragment;
import com.tencent.ecommerce.biz.common.ui.ECCommonFilterDialog;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import mqq.app.Constants;
import sj0.ECFilterOptionModel;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 %2\u00020\u0001:\u0002&'B\u0007\u00a2\u0006\u0004\b#\u0010$J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\u001a\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0011\u001a\u00020\u000fH\u0016R\u001b\u0010\u0017\u001a\u00020\u00128BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001a\u001a\u00020\u00028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b \u0010!\u00a8\u0006("}, d2 = {"Lcom/tencent/ecommerce/biz/commission/detail/ECCommissionDetailFragment;", "Lcom/tencent/ecommerce/base/fragment/ECBaseFragment;", "Landroid/view/View;", "view", "", "initView", "Rh", "Sh", "", "getContentLayoutId", "", "getBusinessDescription", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "", "Eh", "Dh", "Lcom/tencent/ecommerce/biz/commission/detail/ECCommissionDetailViewModel;", "P", "Lkotlin/Lazy;", "Qh", "()Lcom/tencent/ecommerce/biz/commission/detail/ECCommissionDetailViewModel;", "viewModel", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Landroid/view/View;", "filterBtn", "Landroid/widget/ImageView;", BdhLogUtil.LogTag.Tag_Req, "Landroid/widget/ImageView;", "filterImageview", "Landroid/widget/TextView;", ExifInterface.LATITUDE_SOUTH, "Landroid/widget/TextView;", "filterTextView", "<init>", "()V", "T", "a", "b", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECCommissionDetailFragment extends ECBaseFragment {

    /* renamed from: P, reason: from kotlin metadata */
    private final Lazy viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(ECCommissionDetailViewModel.class), new Function0<ViewModelStore>() { // from class: com.tencent.ecommerce.biz.commission.detail.ECCommissionDetailFragment$$special$$inlined$activityViewModels$1
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
    }, new Function0<ViewModelProvider.Factory>() { // from class: com.tencent.ecommerce.biz.commission.detail.ECCommissionDetailFragment$$special$$inlined$activityViewModels$2
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

    /* renamed from: Q, reason: from kotlin metadata */
    private View filterBtn;

    /* renamed from: R, reason: from kotlin metadata */
    private ImageView filterImageview;

    /* renamed from: S, reason: from kotlin metadata */
    private TextView filterTextView;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\f\u001a\u00020\u0005\u00a2\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0016R\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/ecommerce/biz/commission/detail/ECCommissionDetailFragment$b;", "Landroidx/viewpager2/adapter/FragmentStateAdapter;", "", "getItemCount", "position", "Landroidx/fragment/app/Fragment;", "createFragment", "", "Lcom/tencent/ecommerce/biz/commission/detail/ECCommissionItemFragment;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/List;", "list", "fragment", "<init>", "(Landroidx/fragment/app/Fragment;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class b extends FragmentStateAdapter {

        /* renamed from: m, reason: collision with root package name and from kotlin metadata */
        private final List<ECCommissionItemFragment> list;

        public b(Fragment fragment) {
            super(fragment);
            List<ECCommissionItemFragment> listOf;
            listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new ECCommissionItemFragment[]{new ECCommissionItemFragment(ECCommissionItemFragment.TYPE.Settlement), new ECCommissionItemFragment(ECCommissionItemFragment.TYPE.Remittance)});
            this.list = listOf;
        }

        @Override // androidx.viewpager2.adapter.FragmentStateAdapter
        public Fragment createFragment(int position) {
            return this.list.get(position);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: getItemCount */
        public int getNUM_BACKGOURND_ICON() {
            return 2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u00042\u001a\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0001 \u0002*\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "Lsj0/c;", "kotlin.jvm.PlatformType", "it", "", "a", "(Ljava/util/List;)V"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class c<T> implements Observer<List<? extends ECFilterOptionModel>> {
        c() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(List<ECFilterOptionModel> list) {
            ECCommissionDetailFragment.Lh(ECCommissionDetailFragment.this).setVisibility(list.isEmpty() ^ true ? 0 : 8);
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
            if (list.isEmpty()) {
                ECSkin eCSkin = ECSkin.INSTANCE;
                Drawable drawable = eCSkin.getDrawable("qecommerce_skin_icon_general_filter_primary");
                if (drawable != null) {
                    ECCommissionDetailFragment.Mh(ECCommissionDetailFragment.this).setImageDrawable(drawable);
                }
                Integer color = eCSkin.getColor("qecommerce_skin_color_text_primary");
                if (color != null) {
                    ECCommissionDetailFragment.Nh(ECCommissionDetailFragment.this).setTextColor(color.intValue());
                    return;
                }
                return;
            }
            ECSkin eCSkin2 = ECSkin.INSTANCE;
            Drawable drawable2 = eCSkin2.getDrawable("qecommerce_skin_icon_general_filter_red");
            if (drawable2 != null) {
                ECCommissionDetailFragment.Mh(ECCommissionDetailFragment.this).setImageDrawable(drawable2);
            }
            Integer color2 = eCSkin2.getColor("qecommerce_skin_color_text_red_brand");
            if (color2 != null) {
                ECCommissionDetailFragment.Nh(ECCommissionDetailFragment.this).setTextColor(color2.intValue());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class e implements View.OnClickListener {
        e() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ECCommissionDetailFragment.this.Sh();
            EventCollector.getInstance().onViewClicked(view);
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
            ECCommissionDetailFragment.this.requireActivity().finish();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n\u00a2\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/google/android/material/tabs/TabLayout$g;", "tab", "", "position", "", "a", "(Lcom/google/android/material/tabs/TabLayout$g;I)V"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class h implements d.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ List f101436a;

        h(List list) {
            this.f101436a = list;
        }

        @Override // com.google.android.material.tabs.d.b
        public final void a(TabLayout.g gVar, int i3) {
            gVar.f34288i.setGravity(80);
            gVar.f34288i.setBackground(null);
            ECCommissionTabItemView eCCommissionTabItemView = new ECCommissionTabItemView(gVar.f34288i.getContext(), (String) this.f101436a.get(i3));
            if (i3 == 0) {
                eCCommissionTabItemView.setLeftWeight(2.0f);
                eCCommissionTabItemView.setRightWeight(1.0f);
            } else {
                eCCommissionTabItemView.setLeftWeight(1.0f);
                eCCommissionTabItemView.setRightWeight(2.0f);
            }
            Unit unit = Unit.INSTANCE;
            gVar.p(eCCommissionTabItemView);
        }
    }

    public static final /* synthetic */ View Lh(ECCommissionDetailFragment eCCommissionDetailFragment) {
        View view = eCCommissionDetailFragment.filterBtn;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("filterBtn");
        }
        return view;
    }

    public static final /* synthetic */ ImageView Mh(ECCommissionDetailFragment eCCommissionDetailFragment) {
        ImageView imageView = eCCommissionDetailFragment.filterImageview;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("filterImageview");
        }
        return imageView;
    }

    public static final /* synthetic */ TextView Nh(ECCommissionDetailFragment eCCommissionDetailFragment) {
        TextView textView = eCCommissionDetailFragment.filterTextView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("filterTextView");
        }
        return textView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ECCommissionDetailViewModel Qh() {
        return (ECCommissionDetailViewModel) this.viewModel.getValue();
    }

    private final void Rh() {
        Qh().S1().observe(getViewLifecycleOwner(), new c());
        Qh().T1().observe(getViewLifecycleOwner(), new d());
        Qh().W1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Sh() {
        List<ECCommonFilterDialog.FilterItem> R1 = Qh().R1();
        new ECCommonFilterDialog(requireContext(), 0, R1, new ECCommissionDetailFragment$showFilterDialog$1(this, R1), 2, null).show();
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
        return "ECCommissionDetailFragment";
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment
    public int getContentLayoutId() {
        return R.layout.cp8;
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        Rh();
    }

    private final void initView(View view) {
        List listOf;
        this.filterBtn = view.findViewById(R.id.f163035nz0);
        this.filterTextView = (TextView) view.findViewById(R.id.f163036nz1);
        this.filterImageview = (ImageView) view.findViewById(R.id.nyz);
        View view2 = this.filterBtn;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("filterBtn");
        }
        view2.setOnClickListener(new e());
        view.findViewById(R.id.o0w).setOnClickListener(new f());
        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.f163109oc3);
        tabLayout.f(new g());
        ViewPager2 viewPager2 = (ViewPager2) view.findViewById(R.id.of5);
        viewPager2.setUserInputEnabled(false);
        viewPager2.setAdapter(new b(this));
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{getString(R.string.wel), getString(R.string.wek)});
        new com.google.android.material.tabs.d(tabLayout, viewPager2, new h(listOf)).a();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/ecommerce/biz/commission/detail/ECCommissionDetailFragment$g", "Lcom/google/android/material/tabs/TabLayout$d;", "Lcom/google/android/material/tabs/TabLayout$g;", "tab", "", "onTabSelected", "onTabUnselected", "onTabReselected", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class g implements TabLayout.d {
        g() {
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void onTabSelected(TabLayout.g tab) {
            View e16 = tab.e();
            if (e16 != null) {
                ((ECCommissionTabItemView) e16).a();
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type com.tencent.ecommerce.biz.commission.detail.ECCommissionTabItemView");
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void onTabUnselected(TabLayout.g tab) {
            View e16 = tab.e();
            if (e16 != null) {
                ((ECCommissionTabItemView) e16).b();
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type com.tencent.ecommerce.biz.commission.detail.ECCommissionTabItemView");
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void onTabReselected(TabLayout.g tab) {
        }
    }
}
