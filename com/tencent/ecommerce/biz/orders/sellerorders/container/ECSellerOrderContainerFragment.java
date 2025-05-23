package com.tencent.ecommerce.biz.orders.sellerorders.container;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.d;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ecommerce.base.fragment.ECBaseFragment;
import com.tencent.ecommerce.biz.orders.sampleorders.ECSampleOrderFragment;
import com.tencent.ecommerce.biz.orders.sellerorders.ECAbsSellerOrderFragment;
import com.tencent.ecommerce.biz.orders.sellerorders.ECSellerOrderFragment;
import com.tencent.ecommerce.biz.util.ECDebugUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.QzoneIPCModule;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 M2\u00020\u0001:\u0001NB\u0007\u00a2\u0006\u0004\bK\u0010LJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0002H\u0002J\u0016\u0010\r\u001a\u00020\u00022\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0002J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u000bH\u0002J\u001e\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00102\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\nH\u0002J\u0010\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u000bH\u0002J\u0010\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0006H\u0002J\"\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u00062\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010\u001d\u001a\u00020\u0006H\u0016J\b\u0010\u001e\u001a\u00020\u000eH\u0016J\b\u0010 \u001a\u00020\u001fH\u0016J\b\u0010!\u001a\u00020\u001fH\u0016J\u001a\u0010&\u001a\u00020\u00022\u0006\u0010#\u001a\u00020\"2\b\u0010%\u001a\u0004\u0018\u00010$H\u0016J\u0010\u0010)\u001a\u00020\u00022\u0006\u0010(\u001a\u00020'H\u0016R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0016\u00105\u001a\u0002028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b3\u00104R\u001a\u00109\u001a\b\u0012\u0004\u0012\u00020\"068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010=\u001a\u00020:8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010A\u001a\u00020>8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b?\u0010@R\u001b\u0010G\u001a\u00020B8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bC\u0010D\u001a\u0004\bE\u0010FR\u0016\u0010J\u001a\u0004\u0018\u00010\u00128BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bH\u0010I\u00a8\u0006O"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/sellerorders/container/ECSellerOrderContainerFragment;", "Lcom/tencent/ecommerce/base/fragment/ECBaseFragment;", "", "initViews", "Lcom/google/android/material/tabs/TabLayout$g;", "tab", "", "position", "Th", "Sh", "", "Lcom/tencent/ecommerce/biz/orders/sellerorders/container/ECSellerOrderTab;", "tabList", "Wh", "", "Qh", "Landroid/content/Context;", "context", "Lcom/tencent/ecommerce/biz/orders/sellerorders/ECAbsSellerOrderFragment;", "fragments", "Uh", "Oh", "index", "Vh", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", "getContentLayoutId", "getBusinessDescription", "", "Eh", "Dh", "Landroid/view/View;", "view", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "Landroid/widget/ImageView;", "P", "Landroid/widget/ImageView;", "backIcon", "Lcom/google/android/material/tabs/TabLayout;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/google/android/material/tabs/TabLayout;", "tabLayout", "Landroid/widget/FrameLayout;", BdhLogUtil.LogTag.Tag_Req, "Landroid/widget/FrameLayout;", "rightIconContainer", "", ExifInterface.LATITUDE_SOUTH, "Ljava/util/List;", "rightIconViews", "Landroidx/viewpager2/widget/ViewPager2;", "T", "Landroidx/viewpager2/widget/ViewPager2;", "fragmentsPager", "Lcom/tencent/ecommerce/biz/orders/sellerorders/a;", "U", "Lcom/tencent/ecommerce/biz/orders/sellerorders/a;", "fragmentsAdapter", "Lcom/tencent/ecommerce/biz/orders/sellerorders/container/ECSellerOrderContainerViewModel;", "V", "Lkotlin/Lazy;", "Rh", "()Lcom/tencent/ecommerce/biz/orders/sellerorders/container/ECSellerOrderContainerViewModel;", "viewModel", "Ph", "()Lcom/tencent/ecommerce/biz/orders/sellerorders/ECAbsSellerOrderFragment;", "currentFragment", "<init>", "()V", "W", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECSellerOrderContainerFragment extends ECBaseFragment {

    /* renamed from: P, reason: from kotlin metadata */
    private ImageView backIcon;

    /* renamed from: Q, reason: from kotlin metadata */
    private TabLayout tabLayout;

    /* renamed from: R, reason: from kotlin metadata */
    private FrameLayout rightIconContainer;

    /* renamed from: S, reason: from kotlin metadata */
    private final List<View> rightIconViews = new ArrayList();

    /* renamed from: T, reason: from kotlin metadata */
    private ViewPager2 fragmentsPager;

    /* renamed from: U, reason: from kotlin metadata */
    private com.tencent.ecommerce.biz.orders.sellerorders.a fragmentsAdapter;

    /* renamed from: V, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u00042\u001a\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0001 \u0002*\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "Lcom/tencent/ecommerce/biz/orders/sellerorders/container/ECSellerOrderTab;", "kotlin.jvm.PlatformType", "it", "", "a", "(Ljava/util/List;)V"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class b<T> implements Observer<List<? extends ECSellerOrderTab>> {
        b() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(List<? extends ECSellerOrderTab> list) {
            cg0.a.b("ECSellerOrderContainerViewModel", "updateOrderState: " + list);
            ECSellerOrderContainerFragment.this.Wh(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK, "com/tencent/ecommerce/biz/orders/sellerorders/container/ECSellerOrderContainerFragment$initViews$1$1"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ECSellerOrderContainerFragment.this.requireActivity().finish();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/ecommerce/biz/orders/sellerorders/container/ECSellerOrderContainerFragment$d", "Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "", "position", "", "onPageSelected", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class d extends ViewPager2.OnPageChangeCallback {
        d() {
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int position) {
            super.onPageSelected(position);
            ECSellerOrderContainerFragment.this.Vh(position);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n\u00a2\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/google/android/material/tabs/TabLayout$g;", "tab", "", "position", "", "a", "(Lcom/google/android/material/tabs/TabLayout$g;I)V"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class e implements d.b {
        e() {
        }

        @Override // com.google.android.material.tabs.d.b
        public final void a(TabLayout.g gVar, int i3) {
            ECSellerOrderContainerFragment.this.Th(gVar, i3);
        }
    }

    public ECSellerOrderContainerFragment() {
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.tencent.ecommerce.biz.orders.sellerorders.container.ECSellerOrderContainerFragment$$special$$inlined$viewModels$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(ECSellerOrderContainerViewModel.class), new Function0<ViewModelStore>() { // from class: com.tencent.ecommerce.biz.orders.sellerorders.container.ECSellerOrderContainerFragment$$special$$inlined$viewModels$2
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
    }

    private final ECAbsSellerOrderFragment Oh(ECSellerOrderTab tab) {
        int i3 = a.f103839b[tab.ordinal()];
        if (i3 == 1) {
            return new ECSellerOrderFragment();
        }
        if (i3 == 2) {
            return new ECSampleOrderFragment();
        }
        throw new NoWhenBranchMatchedException();
    }

    private final ECAbsSellerOrderFragment Ph() {
        com.tencent.ecommerce.biz.orders.sellerorders.a aVar = this.fragmentsAdapter;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fragmentsAdapter");
        }
        ViewPager2 viewPager2 = this.fragmentsPager;
        if (viewPager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fragmentsPager");
        }
        return aVar.k0(viewPager2.getCurrentItem());
    }

    private final String Qh(ECSellerOrderTab tab) {
        int i3 = a.f103838a[tab.ordinal()];
        if (i3 == 1) {
            return requireContext().getString(R.string.wea);
        }
        if (i3 == 2) {
            return requireContext().getString(R.string.we_);
        }
        throw new NoWhenBranchMatchedException();
    }

    private final ECSellerOrderContainerViewModel Rh() {
        return (ECSellerOrderContainerViewModel) this.viewModel.getValue();
    }

    private final void Sh() {
        Rh().N1().observe(getViewLifecycleOwner(), new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Th(TabLayout.g tab, int position) {
        Object orNull;
        List<ECSellerOrderTab> value = Rh().N1().getValue();
        if (value != null) {
            boolean z16 = value.size() > 1;
            ViewPager2 viewPager2 = this.fragmentsPager;
            if (viewPager2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("fragmentsPager");
            }
            boolean z17 = viewPager2.getCurrentItem() == position;
            orNull = CollectionsKt___CollectionsKt.getOrNull(value, position);
            ECSellerOrderTab eCSellerOrderTab = (ECSellerOrderTab) orNull;
            if (eCSellerOrderTab != null) {
                tab.p(new ECSellerOrderContainerTabItemView(requireContext(), Qh(eCSellerOrderTab), z17, z16));
            }
        }
    }

    private final void Uh(Context context, List<? extends ECAbsSellerOrderFragment> fragments) {
        int i3 = 0;
        for (Object obj : fragments) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            this.rightIconViews.add(i3, ((ECAbsSellerOrderFragment) obj).Nh(context));
            i3 = i16;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Vh(int index) {
        FrameLayout frameLayout = this.rightIconContainer;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rightIconContainer");
        }
        frameLayout.removeAllViews();
        frameLayout.addView(this.rightIconViews.get(index));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Wh(List<? extends ECSellerOrderTab> tabList) {
        int collectionSizeOrDefault;
        List<? extends ECSellerOrderTab> list = tabList;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(Oh((ECSellerOrderTab) it.next()));
        }
        Uh(requireContext(), arrayList);
        com.tencent.ecommerce.biz.orders.sellerorders.a aVar = this.fragmentsAdapter;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fragmentsAdapter");
        }
        aVar.m0(arrayList);
    }

    private final void initViews() {
        ImageView imageView = (ImageView) yh().findViewById(R.id.o2l);
        imageView.setOnClickListener(new c());
        Unit unit = Unit.INSTANCE;
        this.backIcon = imageView;
        this.fragmentsPager = (ViewPager2) yh().findViewById(R.id.nzu);
        this.fragmentsAdapter = new com.tencent.ecommerce.biz.orders.sellerorders.a(this);
        ViewPager2 viewPager2 = this.fragmentsPager;
        if (viewPager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fragmentsPager");
        }
        com.tencent.ecommerce.biz.orders.sellerorders.a aVar = this.fragmentsAdapter;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fragmentsAdapter");
        }
        viewPager2.setAdapter(aVar);
        ViewPager2 viewPager22 = this.fragmentsPager;
        if (viewPager22 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fragmentsPager");
        }
        viewPager22.setOrientation(0);
        ViewPager2 viewPager23 = this.fragmentsPager;
        if (viewPager23 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fragmentsPager");
        }
        viewPager23.registerOnPageChangeCallback(new d());
        TabLayout tabLayout = (TabLayout) yh().findViewById(R.id.ocl);
        this.tabLayout = tabLayout;
        if (tabLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
        }
        ViewPager2 viewPager24 = this.fragmentsPager;
        if (viewPager24 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fragmentsPager");
        }
        new com.google.android.material.tabs.d(tabLayout, viewPager24, new e()).a();
        TabLayout tabLayout2 = this.tabLayout;
        if (tabLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
        }
        tabLayout2.f(new f());
        FrameLayout frameLayout = (FrameLayout) yh().findViewById(R.id.o97);
        this.rightIconContainer = frameLayout;
        ECDebugUtils eCDebugUtils = ECDebugUtils.f104852b;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rightIconContainer");
        }
        eCDebugUtils.e(frameLayout);
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
        return "ECSellerOrderContainerFragment";
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment
    public int getContentLayoutId() {
        return R.layout.cty;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        ECAbsSellerOrderFragment Ph = Ph();
        if (Ph != null) {
            Ph.onActivityResult(requestCode, resultCode, data);
        }
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        ECAbsSellerOrderFragment Ph = Ph();
        if (Ph != null) {
            Ph.onConfigurationChanged(newConfig);
        }
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews();
        Sh();
        Rh().O1();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/ecommerce/biz/orders/sellerorders/container/ECSellerOrderContainerFragment$f", "Lcom/google/android/material/tabs/TabLayout$d;", "Lcom/google/android/material/tabs/TabLayout$g;", "tab", "", "onTabSelected", "onTabUnselected", "onTabReselected", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class f implements TabLayout.d {
        f() {
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void onTabSelected(TabLayout.g tab) {
            if (tab != null) {
                View e16 = tab.e();
                if (e16 != null) {
                    ((ECSellerOrderContainerTabItemView) e16).a();
                    ECSellerOrderContainerFragment.this.Vh(tab.g());
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.tencent.ecommerce.biz.orders.sellerorders.container.ECSellerOrderContainerTabItemView");
            }
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void onTabUnselected(TabLayout.g tab) {
            View e16 = tab != null ? tab.e() : null;
            if (e16 != null) {
                ((ECSellerOrderContainerTabItemView) e16).b();
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type com.tencent.ecommerce.biz.orders.sellerorders.container.ECSellerOrderContainerTabItemView");
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void onTabReselected(TabLayout.g tab) {
        }
    }
}
