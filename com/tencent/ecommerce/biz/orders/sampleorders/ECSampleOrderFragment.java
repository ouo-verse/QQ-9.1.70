package com.tencent.ecommerce.biz.orders.sampleorders;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.os.BundleKt;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.viewpager2.widget.ViewPager2;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.pubaccount.weishi.event.WSComboHomePageChangeEvent;
import com.tencent.ecommerce.base.ui.ECSkin;
import com.tencent.ecommerce.base.ui.tabbar.ECTabCoverInfo;
import com.tencent.ecommerce.base.ui.tabbar.ECTabLayout;
import com.tencent.ecommerce.biz.customerservice.CustomerServiceScene;
import com.tencent.ecommerce.biz.customerservice.ECCustomerServiceFragment;
import com.tencent.ecommerce.biz.orders.buyerorders.searchpage.domain.ECOrderSearchScene;
import com.tencent.ecommerce.biz.orders.buyerorders.searchpage.presentation.ECOrderSearchFragment;
import com.tencent.ecommerce.biz.orders.sampleorders.ECApplySampleOrderListFragment;
import com.tencent.ecommerce.biz.orders.sellerorders.ECAbsSellerOrderFragment;
import com.tencent.ecommerce.biz.orders.sellerorders.container.ECSellerOrderTab;
import com.tencent.ecommerce.biz.util.ECDeviceUtils;
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
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 M2\u00020\u0001:\u0001NB\u0007\u00a2\u0006\u0004\bK\u0010LJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\f\u0010\u0005\u001a\u00020\u0002*\u00020\u0004H\u0002J\f\u0010\u0006\u001a\u00020\u0002*\u00020\u0004H\u0002J\u0016\u0010\n\u001a\u00020\u00022\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0002J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\"\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u000b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010\u0016\u001a\u00020\u000bH\u0016J\b\u0010\u0018\u001a\u00020\u0017H\u0016J&\u0010\u001f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u001a\u001a\u00020\u00192\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016J\u001a\u0010!\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u00042\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016J\b\u0010\"\u001a\u00020\u0002H\u0016R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00102\u001a\u00020/8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0016\u00106\u001a\u0002038\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0016\u0010:\u001a\u0002078\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0014\u0010>\u001a\u00020;8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u001b\u0010D\u001a\u00020?8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b@\u0010A\u001a\u0004\bB\u0010CR\u001a\u0010J\u001a\u00020E8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\bF\u0010G\u001a\u0004\bH\u0010I\u00a8\u0006O"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/sampleorders/ECSampleOrderFragment;", "Lcom/tencent/ecommerce/biz/orders/sellerorders/ECAbsSellerOrderFragment;", "", "Wh", "Landroid/view/View;", "initSearchBar", "Vh", "", "Lcom/tencent/ecommerce/biz/orders/sampleorders/d;", "tabInfoList", "Yh", "", "selectedPosition", "Xh", "Landroid/content/Context;", "context", "Nh", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", "getContentLayoutId", "", "getBusinessDescription", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreateView", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "onDestroyView", "Landroid/widget/FrameLayout;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Landroid/widget/FrameLayout;", "searchBar", "Landroid/widget/TextView;", BdhLogUtil.LogTag.Tag_Req, "Landroid/widget/TextView;", "searchTextView", "Landroid/widget/HorizontalScrollView;", ExifInterface.LATITUDE_SOUTH, "Landroid/widget/HorizontalScrollView;", "tabScrollView", "Lcom/tencent/ecommerce/base/ui/tabbar/ECTabLayout;", "T", "Lcom/tencent/ecommerce/base/ui/tabbar/ECTabLayout;", "tabLayout", "Landroidx/viewpager2/widget/ViewPager2;", "U", "Landroidx/viewpager2/widget/ViewPager2;", "orderListPager", "Lcom/tencent/ecommerce/biz/orders/sampleorders/c;", "V", "Lcom/tencent/ecommerce/biz/orders/sampleorders/c;", "listAdapter", "Landroid/graphics/Paint;", "W", "Landroid/graphics/Paint;", "tabPaint", "Lcom/tencent/ecommerce/biz/orders/sampleorders/e;", "X", "Lkotlin/Lazy;", "Uh", "()Lcom/tencent/ecommerce/biz/orders/sampleorders/e;", "viewModel", "Lcom/tencent/ecommerce/biz/orders/sellerorders/container/ECSellerOrderTab;", "Y", "Lcom/tencent/ecommerce/biz/orders/sellerorders/container/ECSellerOrderTab;", "Mh", "()Lcom/tencent/ecommerce/biz/orders/sellerorders/container/ECSellerOrderTab;", "tabType", "<init>", "()V", "Z", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECSampleOrderFragment extends ECAbsSellerOrderFragment {

    /* renamed from: Q, reason: from kotlin metadata */
    private FrameLayout searchBar;

    /* renamed from: R, reason: from kotlin metadata */
    private TextView searchTextView;

    /* renamed from: S, reason: from kotlin metadata */
    private HorizontalScrollView tabScrollView;

    /* renamed from: T, reason: from kotlin metadata */
    private ECTabLayout tabLayout;

    /* renamed from: U, reason: from kotlin metadata */
    private ViewPager2 orderListPager;

    /* renamed from: V, reason: from kotlin metadata */
    private com.tencent.ecommerce.biz.orders.sampleorders.c listAdapter;

    /* renamed from: W, reason: from kotlin metadata */
    private final Paint tabPaint;

    /* renamed from: X, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* renamed from: Y, reason: from kotlin metadata */
    private final ECSellerOrderTab tabType;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK, "com/tencent/ecommerce/biz/orders/sampleorders/ECSampleOrderFragment$initSearchBar$1$1"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ECSampleOrderFragment.this.Wh();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/ecommerce/biz/orders/sampleorders/ECSampleOrderFragment$c", "Lcom/tencent/ecommerce/base/ui/tabbar/ECTabLayout$OnTabClickListener;", "Lcom/tencent/ecommerce/base/ui/tabbar/a;", "data", "", "position", "", "onTabClick", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class c implements ECTabLayout.OnTabClickListener {
        c() {
        }

        @Override // com.tencent.ecommerce.base.ui.tabbar.ECTabLayout.OnTabClickListener
        public void onTabClick(ECTabCoverInfo data, int position) {
            ECSampleOrderFragment.Oh(ECSampleOrderFragment.this).setCurrentItem(position, false);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J \u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0002H\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/ecommerce/biz/orders/sampleorders/ECSampleOrderFragment$d", "Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "", "position", "", "onPageSelected", "state", "onPageScrollStateChanged", "", "positionOffset", "positionOffsetPixels", WSComboHomePageChangeEvent.EVENT_ON_PAGE_SCROLLED, "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class d extends ViewPager2.OnPageChangeCallback {
        d() {
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrollStateChanged(int state) {
            super.onPageScrollStateChanged(state);
            ECSampleOrderFragment.Ph(ECSampleOrderFragment.this).p(state);
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            ECSampleOrderFragment.Ph(ECSampleOrderFragment.this).q(position, positionOffset);
            ECSampleOrderFragment.this.Xh(position);
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int position) {
            super.onPageSelected(position);
            ECSampleOrderFragment.Ph(ECSampleOrderFragment.this).s(position);
            ECSampleOrderFragment.this.Xh(position);
            ki0.b.f412528a.c(ECSampleOrderFragment.this.Uh().M1().getValue().get(position).type);
        }
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK, "com/tencent/ecommerce/biz/orders/sampleorders/ECSampleOrderFragment$rightNavigationBarContent$1$1"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    static final class e implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ImageView f103789d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Context f103790e;

        e(ImageView imageView, Context context) {
            this.f103789d = imageView;
            this.f103790e = context;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ECCustomerServiceFragment.INSTANCE.a(this.f103790e, CustomerServiceScene.SAMPLE_ORDER_LIST_PAGE_PLATFORM, (r13 & 4) != 0 ? "" : null, (r13 & 8) != 0 ? "" : null, (r13 & 16) != 0 ? "" : null);
            ki0.b.f412528a.b();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public ECSampleOrderFragment() {
        Paint paint = new Paint();
        paint.setTextSize(com.tencent.ecommerce.biz.util.e.c(14.0f));
        Unit unit = Unit.INSTANCE;
        this.tabPaint = paint;
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(com.tencent.ecommerce.biz.orders.sampleorders.e.class), new Function0<ViewModelStore>() { // from class: com.tencent.ecommerce.biz.orders.sampleorders.ECSampleOrderFragment$$special$$inlined$activityViewModels$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                FragmentActivity requireActivity = Fragment.this.requireActivity();
                Intrinsics.checkExpressionValueIsNotNull(requireActivity, "requireActivity()");
                ViewModelStore viewModelStore = requireActivity.get_viewModelStore();
                Intrinsics.checkExpressionValueIsNotNull(viewModelStore, "requireActivity().viewModelStore");
                return viewModelStore;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.tencent.ecommerce.biz.orders.sampleorders.ECSampleOrderFragment$$special$$inlined$activityViewModels$2
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
        this.tabType = ECSellerOrderTab.SAMPLE;
    }

    public static final /* synthetic */ ViewPager2 Oh(ECSampleOrderFragment eCSampleOrderFragment) {
        ViewPager2 viewPager2 = eCSampleOrderFragment.orderListPager;
        if (viewPager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("orderListPager");
        }
        return viewPager2;
    }

    public static final /* synthetic */ ECTabLayout Ph(ECSampleOrderFragment eCSampleOrderFragment) {
        ECTabLayout eCTabLayout = eCSampleOrderFragment.tabLayout;
        if (eCTabLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
        }
        return eCTabLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.ecommerce.biz.orders.sampleorders.e Uh() {
        return (com.tencent.ecommerce.biz.orders.sampleorders.e) this.viewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Wh() {
        yi0.a.q(requireContext(), ECOrderSearchFragment.class, BundleKt.bundleOf(TuplesKt.to("bundle_key_scene", Integer.valueOf(ECOrderSearchScene.APPLY_SAMPLE.ordinal()))), 0, null, 24, null);
        ki0.b.f412528a.d(getTabType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Xh(int selectedPosition) {
        int f16 = ECDeviceUtils.f104857e.f() / 2;
        ECTabLayout eCTabLayout = this.tabLayout;
        if (eCTabLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
        }
        View h16 = eCTabLayout.h(selectedPosition);
        if (h16 != null) {
            HorizontalScrollView horizontalScrollView = this.tabScrollView;
            if (horizontalScrollView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tabScrollView");
            }
            horizontalScrollView.smoothScrollTo((((int) h16.getX()) + (h16.getWidth() / 2)) - f16, 0);
        }
    }

    private final void initSearchBar(View view) {
        FrameLayout frameLayout = (FrameLayout) view.getRootView().findViewById(R.id.o_r);
        frameLayout.setOnClickListener(new b());
        Unit unit = Unit.INSTANCE;
        this.searchBar = frameLayout;
        this.searchTextView = (TextView) view.getRootView().findViewById(R.id.o_t);
    }

    @Override // com.tencent.ecommerce.biz.orders.sellerorders.ECAbsSellerOrderFragment
    /* renamed from: Mh, reason: from getter */
    public ECSellerOrderTab getTabType() {
        return this.tabType;
    }

    @Override // com.tencent.ecommerce.biz.orders.sellerorders.ECAbsSellerOrderFragment
    public View Nh(Context context) {
        ImageView imageView = new ImageView(context);
        imageView.setImageDrawable(ECSkin.INSTANCE.getDrawable(R.drawable.e_y));
        imageView.setLayoutParams(new ViewGroup.LayoutParams(com.tencent.ecommerce.biz.util.e.c(24.0f), com.tencent.ecommerce.biz.util.e.c(24.0f)));
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-2, -1));
        linearLayout.addView(imageView);
        linearLayout.setOnClickListener(new e(imageView, context));
        return linearLayout;
    }

    @Override // com.tencent.ecommerce.base.fragment.api.IECBaseFragment
    /* renamed from: getBusinessDescription */
    public String getTAG() {
        return "ECSampleOrderFragment";
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment
    public int getContentLayoutId() {
        return R.layout.cqz;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        com.tencent.ecommerce.biz.orders.sampleorders.c cVar = this.listAdapter;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listAdapter");
        }
        ViewPager2 viewPager2 = this.orderListPager;
        if (viewPager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("orderListPager");
        }
        ECApplySampleOrderListFragment i06 = cVar.i0(viewPager2.getCurrentItem());
        if (i06 != null) {
            i06.onActivityResult(requestCode, resultCode, data);
        }
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View onCreateView = super.onCreateView(inflater, container, savedInstanceState);
        if (onCreateView == null) {
            return null;
        }
        initSearchBar(onCreateView);
        Vh(onCreateView);
        return onCreateView;
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        a.f103795b.b();
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new ECSampleOrderFragment$onViewCreated$1(this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Yh(List<ECSampleOrderTabInfo> tabInfoList) {
        int collectionSizeOrDefault;
        int collectionSizeOrDefault2;
        ECTabLayout eCTabLayout = this.tabLayout;
        if (eCTabLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
        }
        List<ECSampleOrderTabInfo> list = tabInfoList;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        int i3 = 0;
        for (Object obj : list) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            ECSampleOrderTabInfo eCSampleOrderTabInfo = (ECSampleOrderTabInfo) obj;
            int i17 = eCSampleOrderTabInfo.type.type;
            String str = eCSampleOrderTabInfo.tabName;
            arrayList.add(new ECTabCoverInfo(i17, str, null, R.layout.cto, 0.0f, 0, false, ((int) this.tabPaint.measureText(str)) + (com.tencent.ecommerce.biz.util.e.c(15.0f) * 2), 116, null));
            i3 = i16;
        }
        eCTabLayout.x(arrayList);
        ViewPager2 viewPager2 = this.orderListPager;
        if (viewPager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("orderListPager");
        }
        viewPager2.setOffscreenPageLimit(tabInfoList.size() - 1);
        com.tencent.ecommerce.biz.orders.sampleorders.c cVar = this.listAdapter;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listAdapter");
        }
        List<ECSampleOrderTabInfo> list2 = tabInfoList;
        collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault2);
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList2.add(ECApplySampleOrderListFragment.Companion.b(ECApplySampleOrderListFragment.INSTANCE, ((ECSampleOrderTabInfo) it.next()).type, null, null, 6, null));
        }
        cVar.j0(arrayList2);
    }

    private final void Vh(View view) {
        this.tabScrollView = (HorizontalScrollView) view.findViewById(R.id.oby);
        this.tabLayout = (ECTabLayout) view.findViewById(R.id.o5s);
        this.orderListPager = (ViewPager2) view.findViewById(R.id.o5k);
        ECTabLayout eCTabLayout = this.tabLayout;
        if (eCTabLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
        }
        eCTabLayout.setOnTabClickListener(new c());
        this.listAdapter = new com.tencent.ecommerce.biz.orders.sampleorders.c(this);
        ViewPager2 viewPager2 = this.orderListPager;
        if (viewPager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("orderListPager");
        }
        com.tencent.ecommerce.biz.orders.sampleorders.c cVar = this.listAdapter;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listAdapter");
        }
        viewPager2.setAdapter(cVar);
        ViewPager2 viewPager22 = this.orderListPager;
        if (viewPager22 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("orderListPager");
        }
        viewPager22.registerOnPageChangeCallback(new d());
    }
}
