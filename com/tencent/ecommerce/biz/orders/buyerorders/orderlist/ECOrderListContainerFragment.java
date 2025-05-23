package com.tencent.ecommerce.biz.orders.buyerorders.orderlist;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.core.os.BundleKt;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.viewpager2.widget.ViewPager2;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.pubaccount.weishi.event.WSComboHomePageChangeEvent;
import com.tencent.ecommerce.base.QQECChannel;
import com.tencent.ecommerce.base.fragment.ECBaseFragment;
import com.tencent.ecommerce.base.report.service.ECShowPageCostTimeScene;
import com.tencent.ecommerce.base.report.service.k;
import com.tencent.ecommerce.base.ui.tabbar.ECTabCoverInfo;
import com.tencent.ecommerce.base.ui.tabbar.ECTabLayout;
import com.tencent.ecommerce.biz.customerservice.CustomerServiceScene;
import com.tencent.ecommerce.biz.customerservice.ECCustomerServiceFragment;
import com.tencent.ecommerce.biz.orders.buyerorders.orderlist.ECOrderListFragment;
import com.tencent.ecommerce.biz.orders.buyerorders.searchpage.domain.ECOrderSearchScene;
import com.tencent.ecommerce.biz.orders.buyerorders.searchpage.presentation.ECOrderSearchFragment;
import com.tencent.ecommerce.repo.buyerorder.orderlist.ECQueryType;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.QzoneIPCModule;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 N2\u00020\u00012\u00020\u0002:\u0001OB\u0007\u00a2\u0006\u0004\bL\u0010MJ\u0016\u0010\u0007\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0002J\u0012\u0010\n\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J&\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\u0011\u001a\u00020\u0006H\u0016J\u001a\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u000f2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0016J\b\u0010\u0017\u001a\u00020\u0016H\u0016J\b\u0010\u0019\u001a\u00020\u0018H\u0016J\b\u0010\u001a\u001a\u00020\u0018H\u0016J\b\u0010\u001b\u001a\u00020\u0018H\u0016J\"\u0010 \u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u00142\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0016J\u0010\u0010#\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020!H\u0016J\u0018\u0010%\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020!2\u0006\u0010$\u001a\u00020\u0018H\u0016R\u001b\u0010+\u001a\u00020&8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0016\u00107\u001a\u0002048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0016\u0010;\u001a\u0002088\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010?\u001a\u00020<8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0014\u0010C\u001a\u00020@8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bA\u0010BR\u0016\u0010F\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u0010ER\u0016\u0010I\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u0010HR\u0016\u0010K\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bJ\u0010E\u00a8\u0006P"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/buyerorders/orderlist/ECOrderListContainerFragment;", "Lcom/tencent/ecommerce/base/fragment/ECBaseFragment;", "Lcom/tencent/ecommerce/biz/orders/buyerorders/orderlist/OrderListUiCallback;", "", "Lcom/tencent/ecommerce/biz/orders/buyerorders/orderlist/d;", "tabInfoList", "", "Qh", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/view/View;", "onCreateView", "onDestroyView", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "", "getContentLayoutId", "", "getBusinessDescription", "", "Eh", "Dh", "Bh", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", "Lcom/tencent/ecommerce/repo/buyerorder/orderlist/ECQueryType;", "type", "onCenterFailed", "cached", "onCenterSuccess", "Lcom/tencent/ecommerce/biz/orders/buyerorders/orderlist/b;", "P", "Lkotlin/Lazy;", "Ph", "()Lcom/tencent/ecommerce/biz/orders/buyerorders/orderlist/b;", "tabListViewModel", "Landroid/widget/LinearLayout;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Landroid/widget/LinearLayout;", "searchLayout", "Lcom/tencent/ecommerce/base/ui/tabbar/ECTabLayout;", BdhLogUtil.LogTag.Tag_Req, "Lcom/tencent/ecommerce/base/ui/tabbar/ECTabLayout;", "orderListTabLayout", "Landroidx/viewpager2/widget/ViewPager2;", ExifInterface.LATITUDE_SOUTH, "Landroidx/viewpager2/widget/ViewPager2;", "orderListViewPager", "Lcom/tencent/ecommerce/biz/orders/buyerorders/orderlist/e;", "T", "Lcom/tencent/ecommerce/biz/orders/buyerorders/orderlist/e;", "orderListViewPagerAdapter", "", "U", "J", "pageEnterTime", "Lcom/tencent/ecommerce/base/report/service/k;", "V", "Lcom/tencent/ecommerce/base/report/service/k;", "showCostTimeReporter", "W", "I", WadlProxyConsts.CHANNEL, "X", "Ljava/lang/String;", "scene", "Y", "initSelectedIndex", "<init>", "()V", "Z", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECOrderListContainerFragment extends ECBaseFragment implements OrderListUiCallback {

    /* renamed from: P, reason: from kotlin metadata */
    private final Lazy tabListViewModel;

    /* renamed from: Q, reason: from kotlin metadata */
    private LinearLayout searchLayout;

    /* renamed from: R, reason: from kotlin metadata */
    private ECTabLayout orderListTabLayout;

    /* renamed from: S, reason: from kotlin metadata */
    private ViewPager2 orderListViewPager;

    /* renamed from: T, reason: from kotlin metadata */
    private com.tencent.ecommerce.biz.orders.buyerorders.orderlist.e orderListViewPagerAdapter;

    /* renamed from: U, reason: from kotlin metadata */
    private long pageEnterTime;

    /* renamed from: V, reason: from kotlin metadata */
    private final k showCostTimeReporter;

    /* renamed from: W, reason: from kotlin metadata */
    private int channel;

    /* renamed from: X, reason: from kotlin metadata */
    private String scene;

    /* renamed from: Y, reason: from kotlin metadata */
    private int initSelectedIndex;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK, "com/tencent/ecommerce/biz/orders/buyerorders/orderlist/ECOrderListContainerFragment$onCreateView$1$1"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    static final class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            yi0.a.q(ECOrderListContainerFragment.this.requireContext(), ECOrderSearchFragment.class, BundleKt.bundleOf(TuplesKt.to("bundle_key_scene", Integer.valueOf(ECOrderSearchScene.Q_SHOP.ordinal()))), 0, null, 24, null);
            hi0.a.f404941a.b();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b\u00b8\u0006\u0000"}, d2 = {"com/tencent/ecommerce/biz/orders/buyerorders/orderlist/ECOrderListContainerFragment$onCreateView$1$2", "Lcom/tencent/ecommerce/base/ui/tabbar/ECTabLayout$OnTabClickListener;", "Lcom/tencent/ecommerce/base/ui/tabbar/a;", "data", "", "position", "", "onTabClick", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class c implements ECTabLayout.OnTabClickListener {
        c() {
        }

        @Override // com.tencent.ecommerce.base.ui.tabbar.ECTabLayout.OnTabClickListener
        public void onTabClick(ECTabCoverInfo data, int position) {
            ECOrderListContainerFragment.Lh(ECOrderListContainerFragment.this).s(position);
            ECOrderListContainerFragment.Mh(ECOrderListContainerFragment.this).setCurrentItem(position, false);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J \u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0002H\u0016\u00a8\u0006\f\u00b8\u0006\u0000"}, d2 = {"com/tencent/ecommerce/biz/orders/buyerorders/orderlist/ECOrderListContainerFragment$onCreateView$1$3", "Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "", "position", "", "onPageSelected", "state", "onPageScrollStateChanged", "", "positionOffset", "positionOffsetPixels", WSComboHomePageChangeEvent.EVENT_ON_PAGE_SCROLLED, "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class d extends ViewPager2.OnPageChangeCallback {
        d() {
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrollStateChanged(int state) {
            super.onPageScrollStateChanged(state);
            ECOrderListContainerFragment.Lh(ECOrderListContainerFragment.this).p(state);
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            ECOrderListContainerFragment.Lh(ECOrderListContainerFragment.this).q(position, positionOffset);
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int position) {
            Object orNull;
            super.onPageSelected(position);
            ECOrderListContainerFragment.Lh(ECOrderListContainerFragment.this).s(position);
            orNull = CollectionsKt___CollectionsKt.getOrNull(ECOrderListContainerFragment.this.Ph().L1().getValue(), position);
            ECOrderListTabInfo eCOrderListTabInfo = (ECOrderListTabInfo) orNull;
            if (eCOrderListTabInfo != null) {
                ECOrderListReporter.f103395b.x(eCOrderListTabInfo.type);
            }
        }
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    static final class e implements View.OnClickListener {
        e() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ECCustomerServiceFragment.INSTANCE.a(ECOrderListContainerFragment.this.requireContext(), CustomerServiceScene.MY_ORDER_LIST_PAGE_PLATFORM, (r13 & 4) != 0 ? "" : null, (r13 & 8) != 0 ? "" : null, (r13 & 16) != 0 ? "" : null);
            ECOrderListReporter.f103395b.C();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public ECOrderListContainerFragment() {
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.tencent.ecommerce.biz.orders.buyerorders.orderlist.ECOrderListContainerFragment$$special$$inlined$viewModels$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        this.tabListViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(com.tencent.ecommerce.biz.orders.buyerorders.orderlist.b.class), new Function0<ViewModelStore>() { // from class: com.tencent.ecommerce.biz.orders.buyerorders.orderlist.ECOrderListContainerFragment$$special$$inlined$viewModels$2
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
        this.showCostTimeReporter = new k(ECShowPageCostTimeScene.SHOW_COST_TIME_ORDER_LIST);
        this.channel = QQECChannel.CHANNEL_UNKNOWN.getId();
        this.scene = "";
    }

    public static final /* synthetic */ ECTabLayout Lh(ECOrderListContainerFragment eCOrderListContainerFragment) {
        ECTabLayout eCTabLayout = eCOrderListContainerFragment.orderListTabLayout;
        if (eCTabLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("orderListTabLayout");
        }
        return eCTabLayout;
    }

    public static final /* synthetic */ ViewPager2 Mh(ECOrderListContainerFragment eCOrderListContainerFragment) {
        ViewPager2 viewPager2 = eCOrderListContainerFragment.orderListViewPager;
        if (viewPager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("orderListViewPager");
        }
        return viewPager2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.ecommerce.biz.orders.buyerorders.orderlist.b Ph() {
        return (com.tencent.ecommerce.biz.orders.buyerorders.orderlist.b) this.tabListViewModel.getValue();
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
        return "ECOrderListContainerFragment";
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment
    public int getContentLayoutId() {
        return R.layout.csq;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        com.tencent.ecommerce.biz.orders.buyerorders.orderlist.e eVar = this.orderListViewPagerAdapter;
        if (eVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("orderListViewPagerAdapter");
        }
        ViewPager2 viewPager2 = this.orderListViewPager;
        if (viewPager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("orderListViewPager");
        }
        ECOrderListFragment i06 = eVar.i0(viewPager2.getCurrentItem());
        if (i06 != null) {
            i06.onActivityResult(requestCode, resultCode, data);
        }
    }

    @Override // com.tencent.ecommerce.biz.orders.buyerorders.orderlist.OrderListUiCallback
    public void onCenterFailed(ECQueryType type) {
        if (type == ECQueryType.ALL) {
            k.c(this.showCostTimeReporter, 3, null, 2, null);
        }
    }

    @Override // com.tencent.ecommerce.biz.orders.buyerorders.orderlist.OrderListUiCallback
    public void onCenterSuccess(ECQueryType type, boolean cached) {
        if (type == ECQueryType.ALL) {
            k.c(this.showCostTimeReporter, cached ? 1 : 2, null, 2, null);
        }
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        int e16;
        String str;
        String string;
        String string2;
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null && (string2 = arguments.getString(WadlProxyConsts.CHANNEL)) != null) {
            e16 = Integer.parseInt(string2);
        } else {
            e16 = ug0.b.f438933d.e();
        }
        this.channel = e16;
        Bundle arguments2 = getArguments();
        if (arguments2 == null || (str = arguments2.getString("scene")) == null) {
            str = "";
        }
        this.scene = str;
        Bundle arguments3 = getArguments();
        this.initSelectedIndex = (arguments3 == null || (string = arguments3.getString(QCircleScheme.AttrQQPublish.SELECT_TAB)) == null) ? 0 : Integer.parseInt(string);
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View onCreateView = super.onCreateView(inflater, container, savedInstanceState);
        if (onCreateView == null) {
            return null;
        }
        LinearLayout linearLayout = (LinearLayout) onCreateView.findViewById(R.id.o_5);
        this.searchLayout = linearLayout;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchLayout");
        }
        linearLayout.setOnClickListener(new b());
        this.orderListTabLayout = (ECTabLayout) onCreateView.findViewById(R.id.obu);
        this.orderListViewPager = (ViewPager2) onCreateView.findViewById(R.id.o5_);
        ECTabLayout eCTabLayout = this.orderListTabLayout;
        if (eCTabLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("orderListTabLayout");
        }
        eCTabLayout.setOnTabClickListener(new c());
        this.orderListViewPagerAdapter = new com.tencent.ecommerce.biz.orders.buyerorders.orderlist.e(this);
        ViewPager2 viewPager2 = this.orderListViewPager;
        if (viewPager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("orderListViewPager");
        }
        com.tencent.ecommerce.biz.orders.buyerorders.orderlist.e eVar = this.orderListViewPagerAdapter;
        if (eVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("orderListViewPagerAdapter");
        }
        viewPager2.setAdapter(eVar);
        ViewPager2 viewPager22 = this.orderListViewPager;
        if (viewPager22 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("orderListViewPager");
        }
        viewPager22.registerOnPageChangeCallback(new d());
        ECOrderListReporter.f103395b.B();
        this.pageEnterTime = SystemClock.uptimeMillis();
        return onCreateView;
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        if (this.pageEnterTime > 0) {
            long uptimeMillis = SystemClock.uptimeMillis() - this.pageEnterTime;
            cg0.a.b("ECOrderListContainerFragment", "onDestroyView, usageTime = " + uptimeMillis);
            ECOrderListReporter.f103395b.z(uptimeMillis);
        }
        ECOrderListReporter.f103395b.A();
        super.onDestroyView();
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setTitle(R.string.wgt);
        if (this.channel != QQECChannel.CHANNEL_QQ_VIP.getId() || (!Intrinsics.areEqual(this.scene, "1"))) {
            Jh(R.drawable.e_y);
        }
        Ih(new e());
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new ECOrderListContainerFragment$onViewCreated$2(this, null), 3, null);
        Ph().M1(this.channel, this.scene);
        ECTabLayout eCTabLayout = this.orderListTabLayout;
        if (eCTabLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("orderListTabLayout");
        }
        eCTabLayout.s(this.initSelectedIndex);
        ViewPager2 viewPager2 = this.orderListViewPager;
        if (viewPager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("orderListViewPager");
        }
        viewPager2.setCurrentItem(this.initSelectedIndex, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Qh(List<ECOrderListTabInfo> tabInfoList) {
        int collectionSizeOrDefault;
        int collectionSizeOrDefault2;
        ECTabLayout eCTabLayout = this.orderListTabLayout;
        if (eCTabLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("orderListTabLayout");
        }
        List<ECOrderListTabInfo> list = tabInfoList;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (ECOrderListTabInfo eCOrderListTabInfo : list) {
            arrayList.add(new ECTabCoverInfo(eCOrderListTabInfo.type.type, eCOrderListTabInfo.getTabName(), null, R.layout.cst, 0.0f, 0, false, 0, 244, null));
        }
        eCTabLayout.x(arrayList);
        ViewPager2 viewPager2 = this.orderListViewPager;
        if (viewPager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("orderListViewPager");
        }
        viewPager2.setOffscreenPageLimit(tabInfoList.size() - 1);
        com.tencent.ecommerce.biz.orders.buyerorders.orderlist.e eVar = this.orderListViewPagerAdapter;
        if (eVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("orderListViewPagerAdapter");
        }
        List<ECOrderListTabInfo> list2 = tabInfoList;
        collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault2);
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            ECOrderListFragment b16 = ECOrderListFragment.Companion.b(ECOrderListFragment.INSTANCE, ((ECOrderListTabInfo) it.next()).type, null, null, this.scene, 6, null);
            b16.si(this);
            arrayList2.add(b16);
        }
        eVar.j0(arrayList2);
    }
}
