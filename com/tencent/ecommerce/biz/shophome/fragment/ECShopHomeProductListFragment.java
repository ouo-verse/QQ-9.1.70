package com.tencent.ecommerce.biz.shophome.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import bj0.ECShopHomeProductRequest;
import bj0.ECShopHomeRequest;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.ecommerce.base.list.IStateCenterView;
import com.tencent.ecommerce.base.rmonitor.service.ECRMonitorManager;
import com.tencent.ecommerce.base.ui.ECSkin;
import com.tencent.ecommerce.base.ui.stateview.ECStateCenterView;
import com.tencent.ecommerce.biz.shophome.fragment.ECShopHomeFragment;
import com.tencent.ecommerce.biz.shophome.model.ECOrderByTabInfo;
import com.tencent.ecommerce.biz.shophome.model.ECShopProductInfo;
import com.tencent.ecommerce.biz.shophome.ui.adapter.ECShopHomeProductListRecyclerViewAdapter;
import com.tencent.ecommerce.biz.shophome.ui.component.ECShopSortBarComponent;
import com.tencent.ecommerce.biz.shophome.ui.component.f;
import com.tencent.ecommerce.biz.shophome.viewmodel.ECShopHomeViewModel;
import com.tencent.ecommerce.biz.shophome.viewmodel.a;
import com.tencent.mobileqq.R;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 '2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001(B\u0007\u00a2\u0006\u0004\b%\u0010&J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\t\u001a\u00020\u0003H\u0016J\b\u0010\n\u001a\u00020\u0003H\u0016J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\u000e\u001a\u00020\u0003H\u0016J\b\u0010\u000f\u001a\u00020\u0003H\u0016J\b\u0010\u0010\u001a\u00020\u0003H\u0016J\b\u0010\u0011\u001a\u00020\u0003H\u0016J\b\u0010\u0012\u001a\u00020\u0002H\u0016J\b\u0010\u0013\u001a\u00020\u0003H\u0016J\b\u0010\u0014\u001a\u00020\u0003H\u0016R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010$\u001a\u00020!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#\u00a8\u0006)"}, d2 = {"Lcom/tencent/ecommerce/biz/shophome/fragment/ECShopHomeProductListFragment;", "Lcom/tencent/ecommerce/biz/shophome/fragment/ECShopHomeProductListBaseFragment;", "Lcom/tencent/ecommerce/biz/shophome/viewmodel/ECShopHomeViewModel;", "", "ti", "", "getContentLayoutId", "", "getBusinessDescription", "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "initUI", "ai", "Yh", "bi", "initArguments", "si", "di", "gi", "Landroid/widget/LinearLayout;", "e0", "Landroid/widget/LinearLayout;", "loadingContainer", "Lcom/tencent/ecommerce/biz/shophome/ui/component/f;", "f0", "Lcom/tencent/ecommerce/biz/shophome/ui/component/f;", "shopHomeLoadingComponent", "Lcom/tencent/ecommerce/base/ui/stateview/ECStateCenterView;", "g0", "Lcom/tencent/ecommerce/base/ui/stateview/ECStateCenterView;", "pageStateCenterView", "Ljava/util/concurrent/atomic/AtomicBoolean;", "h0", "Ljava/util/concurrent/atomic/AtomicBoolean;", "hasLoaded", "<init>", "()V", "i0", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECShopHomeProductListFragment extends ECShopHomeProductListBaseFragment<ECShopHomeViewModel> {

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    private LinearLayout loadingContainer;

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    private f shopHomeLoadingComponent;

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    private ECStateCenterView pageStateCenterView;

    /* renamed from: h0, reason: collision with root package name and from kotlin metadata */
    private final AtomicBoolean hasLoaded = new AtomicBoolean(false);

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/ecommerce/biz/shophome/fragment/ECShopHomeProductListFragment$b", "Lcom/tencent/ecommerce/biz/shophome/ui/component/ECShopSortBarComponent$IOrderByTabItemSelectedListener;", "Lcom/tencent/ecommerce/biz/shophome/model/a;", "orderByTabInfo", "", "onOrderByTabItemSelected", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class b implements ECShopSortBarComponent.IOrderByTabItemSelectedListener {
        b() {
        }

        @Override // com.tencent.ecommerce.biz.shophome.ui.component.ECShopSortBarComponent.IOrderByTabItemSelectedListener
        public void onOrderByTabItemSelected(ECOrderByTabInfo orderByTabInfo) {
            ECShopHomeProductListFragment.this.Xh().n2(true);
            ECShopHomeProductListFragment.this.Xh().l2(orderByTabInfo);
            String shopId = ECShopHomeProductListFragment.this.Xh().getShopId();
            ECShopHomeFragment.Companion companion = ECShopHomeFragment.INSTANCE;
            ECShopHomeProductListFragment.this.Xh().I2(new ECShopHomeProductRequest(shopId, "", false, null, orderByTabInfo, null, companion.c(ECShopHomeProductListFragment.this.getIsSelectStr()), companion.a(ECShopHomeProductListFragment.this.getIsDistributorStr()), ECShopHomeProductListFragment.this.getSource(), ECShopHomeProductListFragment.this.getCouponId(), 40, null));
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u00042\u001a\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0001 \u0002*\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "Lcom/tencent/ecommerce/biz/shophome/model/c;", "kotlin.jvm.PlatformType", "it", "", "a", "(Ljava/util/List;)V"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    static final class c<T> implements Observer<List<? extends ECShopProductInfo>> {
        c() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(List<ECShopProductInfo> list) {
            ECShopHomeProductListRecyclerViewAdapter Vh = ECShopHomeProductListFragment.this.Vh();
            Boolean value = ECShopHomeProductListFragment.this.Xh().g2().getValue();
            if (value == null) {
                value = Boolean.FALSE;
            }
            Vh.J0(list, value.booleanValue());
            if (Intrinsics.areEqual(ECShopHomeProductListFragment.this.Xh().i2().getValue(), Boolean.TRUE)) {
                ECShopHomeProductListFragment.this.Xh().u2(true);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/tencent/ecommerce/biz/shophome/viewmodel/a$b;", "kotlin.jvm.PlatformType", "it", "", "a", "(Lcom/tencent/ecommerce/biz/shophome/viewmodel/a$b;)V"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    static final class d<T> implements Observer<a.b> {
        d() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(a.b bVar) {
            if (Intrinsics.areEqual(bVar, a.b.c.f104428a)) {
                if (ECShopHomeProductListFragment.this.hasLoaded.compareAndSet(false, true)) {
                    ECShopHomeProductListFragment.pi(ECShopHomeProductListFragment.this).setVisibility(0);
                    return;
                } else {
                    IStateCenterView.a.c(ECShopHomeProductListFragment.qi(ECShopHomeProductListFragment.this), null, 1, null);
                    return;
                }
            }
            if (Intrinsics.areEqual(bVar, a.b.d.f104429a)) {
                ECShopHomeProductListFragment.pi(ECShopHomeProductListFragment.this).setVisibility(8);
                ECShopHomeProductListFragment.qi(ECShopHomeProductListFragment.this).setSucceededState();
            } else if (bVar instanceof a.b.EmptyState) {
                ECShopHomeProductListFragment.pi(ECShopHomeProductListFragment.this).setVisibility(8);
                ECShopHomeProductListFragment.this.ti();
            } else if (bVar instanceof a.b.ErrorState) {
                ECShopHomeProductListFragment.pi(ECShopHomeProductListFragment.this).setVisibility(8);
                ECShopHomeProductListFragment.qi(ECShopHomeProductListFragment.this).setFailedState(((a.b.ErrorState) bVar).msg);
            }
        }
    }

    public static final /* synthetic */ LinearLayout pi(ECShopHomeProductListFragment eCShopHomeProductListFragment) {
        LinearLayout linearLayout = eCShopHomeProductListFragment.loadingContainer;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingContainer");
        }
        return linearLayout;
    }

    public static final /* synthetic */ ECStateCenterView qi(ECShopHomeProductListFragment eCShopHomeProductListFragment) {
        ECStateCenterView eCStateCenterView = eCShopHomeProductListFragment.pageStateCenterView;
        if (eCStateCenterView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pageStateCenterView");
        }
        return eCStateCenterView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ti() {
        List<ECShopProductInfo> value = Xh().S1().getValue();
        if (value == null || value.isEmpty()) {
            if (getCouponId().length() > 0) {
                ECStateCenterView eCStateCenterView = this.pageStateCenterView;
                if (eCStateCenterView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("pageStateCenterView");
                }
                IStateCenterView.a.a(eCStateCenterView, getResources().getString(R.string.woe), null, ECSkin.INSTANCE.getColor(R.color.f6471n), 2, null);
                return;
            }
            ECStateCenterView eCStateCenterView2 = this.pageStateCenterView;
            if (eCStateCenterView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pageStateCenterView");
            }
            IStateCenterView.a.a(eCStateCenterView2, getResources().getString(R.string.wta), null, ECSkin.INSTANCE.getColor(R.color.f6471n), 2, null);
        }
    }

    @Override // com.tencent.ecommerce.biz.shophome.fragment.ECShopHomeProductListBaseFragment
    public void Yh() {
        String str;
        super.Yh();
        Context requireContext = requireContext();
        if (ECShopHomeFragment.INSTANCE.c(getIsSelectStr())) {
            str = "qshop_skeleton_listpage";
        } else {
            str = "qshop_skeleton_mainpage";
        }
        this.shopHomeLoadingComponent = new f(requireContext, str, false);
        LinearLayout linearLayout = this.loadingContainer;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingContainer");
        }
        f fVar = this.shopHomeLoadingComponent;
        if (fVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shopHomeLoadingComponent");
        }
        linearLayout.addView(fVar.getComponentView());
    }

    @Override // com.tencent.ecommerce.biz.shophome.fragment.ECShopHomeProductListBaseFragment
    public void ai() {
        super.ai();
        Vh().K0(new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.shophome.fragment.ECShopHomeProductListFragment$initProductList$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                Boolean value = ECShopHomeProductListFragment.this.Xh().g2().getValue();
                Boolean bool = Boolean.TRUE;
                if ((!Intrinsics.areEqual(value, bool)) && (!Intrinsics.areEqual(ECShopHomeProductListFragment.this.Xh().h2().getValue(), bool))) {
                    if (ECShopHomeProductListFragment.this.Xh().getCookie().length() > 0) {
                        String shopId = ECShopHomeProductListFragment.this.Xh().getShopId();
                        String cookie = ECShopHomeProductListFragment.this.Xh().getCookie();
                        ECOrderByTabInfo value2 = ECShopHomeProductListFragment.this.Xh().P1().getValue();
                        ECShopHomeFragment.Companion companion = ECShopHomeFragment.INSTANCE;
                        ECShopHomeProductListFragment.this.Xh().I2(new ECShopHomeProductRequest(shopId, cookie, true, null, value2, null, companion.c(ECShopHomeProductListFragment.this.getIsSelectStr()), companion.a(ECShopHomeProductListFragment.this.getIsDistributorStr()), ECShopHomeProductListFragment.this.getSource(), ECShopHomeProductListFragment.this.getCouponId(), 40, null));
                    }
                }
            }
        });
    }

    @Override // com.tencent.ecommerce.biz.shophome.fragment.ECShopHomeProductListBaseFragment
    public void bi() {
        super.bi();
        Wh().f(new b());
    }

    @Override // com.tencent.ecommerce.biz.shophome.fragment.ECShopHomeProductListBaseFragment
    public void di() {
        super.di();
        Xh().S1().observe(getViewLifecycleOwner(), new c());
        com.tencent.ecommerce.base.ktx.f.f100751a.a(Xh().S1());
        Xh().getPageState().observe(getViewLifecycleOwner(), new d());
    }

    @Override // com.tencent.ecommerce.biz.shophome.fragment.ECShopHomeProductListBaseFragment, com.tencent.ecommerce.base.fragment.api.IECBaseFragment
    /* renamed from: getBusinessDescription */
    public String getTAG() {
        return "ECShopHomeProductListFragment";
    }

    @Override // com.tencent.ecommerce.biz.shophome.fragment.ECShopHomeProductListBaseFragment, com.tencent.ecommerce.base.fragment.ECBaseFragment
    public int getContentLayoutId() {
        return R.layout.cr_;
    }

    @Override // com.tencent.ecommerce.biz.shophome.fragment.ECShopHomeProductListBaseFragment
    public void initArguments() {
        String str;
        String str2;
        String str3;
        Intent intent;
        String string;
        Bundle arguments = getArguments();
        ni(arguments != null ? arguments.getInt("source", 0) : 0);
        Bundle arguments2 = getArguments();
        String str4 = "0";
        if (arguments2 == null || (str = arguments2.getString("is_distributor")) == null) {
            str = "0";
        }
        ki(str);
        Bundle arguments3 = getArguments();
        if (arguments3 == null || (str2 = arguments3.getString("is_select")) == null) {
            str2 = "0";
        }
        mi(str2);
        Bundle arguments4 = getArguments();
        if (arguments4 != null && (string = arguments4.getString("coupon_id")) != null) {
            str4 = string;
        }
        hi(str4);
        FragmentActivity activity = getActivity();
        if (activity == null || (intent = activity.getIntent()) == null || (str3 = intent.getStringExtra("scheme_callback_id")) == null) {
            str3 = "";
        }
        ji(str3);
        ii(ug0.a.b(getDeliverProductCallbackId()));
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        if (ECShopHomeFragment.INSTANCE.c(getIsSelectStr())) {
            ECRMonitorManager.f100953c.b("EC_STAGE_SHOP_HOME_SELECT");
        } else {
            ECRMonitorManager.f100953c.b("EC_STAGE_SHOP_HOME_GUEST");
        }
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (ECShopHomeFragment.INSTANCE.c(getIsSelectStr())) {
            ECRMonitorManager.f100953c.c("EC_STAGE_SHOP_HOME_SELECT");
        } else {
            ECRMonitorManager.f100953c.c("EC_STAGE_SHOP_HOME_GUEST");
        }
    }

    @Override // com.tencent.ecommerce.biz.shophome.fragment.ECShopHomeProductListBaseFragment
    /* renamed from: si, reason: merged with bridge method [inline-methods] */
    public ECShopHomeViewModel ci() {
        return (ECShopHomeViewModel) new ViewModelProvider(requireActivity()).get(ECShopHomeViewModel.class);
    }

    @Override // com.tencent.ecommerce.biz.shophome.fragment.ECShopHomeProductListBaseFragment
    public void initUI(View rootView) {
        li((ViewGroup) rootView.findViewById(R.id.f163062o34));
        this.loadingContainer = (LinearLayout) rootView.findViewById(R.id.f163063o35);
        ECStateCenterView eCStateCenterView = (ECStateCenterView) rootView.findViewById(R.id.obr);
        eCStateCenterView.setRetryListener(new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.shophome.fragment.ECShopHomeProductListFragment$initUI$$inlined$apply$lambda$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                String shopId = ECShopHomeProductListFragment.this.Xh().getShopId();
                ECShopHomeFragment.Companion companion = ECShopHomeFragment.INSTANCE;
                ECShopHomeProductListFragment.this.Xh().H2(new ECShopHomeRequest(shopId, companion.c(ECShopHomeProductListFragment.this.getIsSelectStr()), companion.a(ECShopHomeProductListFragment.this.getIsDistributorStr()), ECShopHomeProductListFragment.this.getSource(), ECShopHomeProductListFragment.this.getCouponId()), false);
            }
        });
        Unit unit = Unit.INSTANCE;
        this.pageStateCenterView = eCStateCenterView;
        if (eCStateCenterView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pageStateCenterView");
        }
        eCStateCenterView.setBackgroundColor(getResources().getColor(R.color.f7153h));
    }

    @Override // com.tencent.ecommerce.biz.shophome.fragment.ECShopHomeProductListBaseFragment
    public void gi() {
    }
}
