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
import cg0.a;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.ecommerce.base.list.IStateCenterView;
import com.tencent.ecommerce.base.ui.ECSkin;
import com.tencent.ecommerce.base.ui.stateview.ECStateCenterView;
import com.tencent.ecommerce.biz.shophome.fragment.ECShopHomeFragment;
import com.tencent.ecommerce.biz.shophome.model.ECOrderByTabInfo;
import com.tencent.ecommerce.biz.shophome.model.ECShopCategoryInfo;
import com.tencent.ecommerce.biz.shophome.model.ECShopProductInfo;
import com.tencent.ecommerce.biz.shophome.ui.adapter.ECShopHomeProductListRecyclerViewAdapter;
import com.tencent.ecommerce.biz.shophome.ui.component.ECShopSortBarComponent;
import com.tencent.ecommerce.biz.shophome.ui.component.f;
import com.tencent.ecommerce.biz.shophome.util.ECShopHomePageType;
import com.tencent.ecommerce.biz.shophome.util.ECShopHomeScene;
import com.tencent.ecommerce.biz.shophome.viewmodel.ECShopHomeSecondProductViewModel;
import com.tencent.ecommerce.biz.shophome.viewmodel.a;
import com.tencent.mobileqq.R;
import com.tencent.qqmini.sdk.plugins.SensorJsPlugin;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 42\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00015B\u0007\u00a2\u0006\u0004\b2\u00103J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\tH\u0016J\b\u0010\r\u001a\u00020\u0003H\u0016J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0011\u001a\u00020\u0003H\u0016J\b\u0010\u0012\u001a\u00020\u0003H\u0016J\b\u0010\u0013\u001a\u00020\u0003H\u0016J\b\u0010\u0014\u001a\u00020\u0003H\u0016J\b\u0010\u0015\u001a\u00020\u0002H\u0016J\b\u0010\u0016\u001a\u00020\u0003H\u0016R\u0016\u0010\u0019\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001b\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u0018R\u0018\u0010!\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0014\u00101\u001a\u00020.8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u00100\u00a8\u00066"}, d2 = {"Lcom/tencent/ecommerce/biz/shophome/fragment/ECShopHomeSecondProductListFragment;", "Lcom/tencent/ecommerce/biz/shophome/fragment/ECShopHomeProductListBaseFragment;", "Lcom/tencent/ecommerce/biz/shophome/viewmodel/ECShopHomeSecondProductViewModel;", "", "vi", "", "getContentLayoutId", "", "getBusinessDescription", "", "Eh", "Dh", "Bh", "initArguments", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "initUI", "Yh", "bi", "ai", "di", SensorJsPlugin.SENSOR_INTERVAL_UI, "gi", "e0", "Ljava/lang/String;", "adClickId", "f0", "shopId", "g0", "categoryName", "Lcom/tencent/ecommerce/biz/shophome/model/b;", "h0", "Lcom/tencent/ecommerce/biz/shophome/model/b;", "category", "Landroid/widget/LinearLayout;", "i0", "Landroid/widget/LinearLayout;", "loadingContainer", "Lcom/tencent/ecommerce/base/ui/stateview/ECStateCenterView;", "j0", "Lcom/tencent/ecommerce/base/ui/stateview/ECStateCenterView;", "pageStateCenterView", "Lcom/tencent/ecommerce/biz/shophome/ui/component/f;", "k0", "Lcom/tencent/ecommerce/biz/shophome/ui/component/f;", "shopHomeLoadingComponent", "Ljava/util/concurrent/atomic/AtomicBoolean;", "l0", "Ljava/util/concurrent/atomic/AtomicBoolean;", "hasLoaded", "<init>", "()V", "m0", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECShopHomeSecondProductListFragment extends ECShopHomeProductListBaseFragment<ECShopHomeSecondProductViewModel> {

    /* renamed from: h0, reason: collision with root package name and from kotlin metadata */
    private ECShopCategoryInfo category;

    /* renamed from: i0, reason: collision with root package name and from kotlin metadata */
    private LinearLayout loadingContainer;

    /* renamed from: j0, reason: collision with root package name and from kotlin metadata */
    private ECStateCenterView pageStateCenterView;

    /* renamed from: k0, reason: collision with root package name and from kotlin metadata */
    private f shopHomeLoadingComponent;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    private String adClickId = "";

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    private String shopId = "";

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    private String categoryName = "";

    /* renamed from: l0, reason: collision with root package name and from kotlin metadata */
    private final AtomicBoolean hasLoaded = new AtomicBoolean(false);

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/ecommerce/biz/shophome/fragment/ECShopHomeSecondProductListFragment$b", "Lcom/tencent/ecommerce/biz/shophome/ui/component/ECShopSortBarComponent$IOrderByTabItemSelectedListener;", "Lcom/tencent/ecommerce/biz/shophome/model/a;", "orderByTabInfo", "", "onOrderByTabItemSelected", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class b implements ECShopSortBarComponent.IOrderByTabItemSelectedListener {
        b() {
        }

        @Override // com.tencent.ecommerce.biz.shophome.ui.component.ECShopSortBarComponent.IOrderByTabItemSelectedListener
        public void onOrderByTabItemSelected(ECOrderByTabInfo orderByTabInfo) {
            ECShopHomeSecondProductListFragment.this.Xh().n2(true);
            ECShopHomeSecondProductListFragment.this.Xh().l2(orderByTabInfo);
            if (ECShopHomeSecondProductListFragment.this.category != null) {
                ECShopCategoryInfo eCShopCategoryInfo = ECShopHomeSecondProductListFragment.this.category;
                if (eCShopCategoryInfo != null) {
                    String str = ECShopHomeSecondProductListFragment.this.shopId;
                    ECShopHomeFragment.Companion companion = ECShopHomeFragment.INSTANCE;
                    ECShopHomeSecondProductViewModel.y2(ECShopHomeSecondProductListFragment.this.Xh(), new ECShopHomeProductRequest(str, "", false, eCShopCategoryInfo, orderByTabInfo, null, companion.c(ECShopHomeSecondProductListFragment.this.getIsSelectStr()), companion.a(ECShopHomeSecondProductListFragment.this.getIsDistributorStr()), ECShopHomeSecondProductListFragment.this.getSource(), ECShopHomeSecondProductListFragment.this.getCouponId(), 32, null), false, 2, null);
                    return;
                }
                return;
            }
            a.a("ECShopHomeSecondProductListFragment", "[onOrderByTabItemSelected]", "category is null.");
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
            if (!list.isEmpty()) {
                ECShopHomeProductListRecyclerViewAdapter Vh = ECShopHomeSecondProductListFragment.this.Vh();
                Boolean value = ECShopHomeSecondProductListFragment.this.Xh().g2().getValue();
                if (value == null) {
                    value = Boolean.FALSE;
                }
                Vh.J0(list, value.booleanValue());
                if (Intrinsics.areEqual(ECShopHomeSecondProductListFragment.this.Xh().i2().getValue(), Boolean.TRUE)) {
                    ECShopHomeSecondProductListFragment.this.Xh().u2(true);
                }
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
                if (ECShopHomeSecondProductListFragment.this.hasLoaded.compareAndSet(false, true)) {
                    ECShopHomeSecondProductListFragment.qi(ECShopHomeSecondProductListFragment.this).setVisibility(0);
                    return;
                } else {
                    IStateCenterView.a.c(ECShopHomeSecondProductListFragment.ri(ECShopHomeSecondProductListFragment.this), null, 1, null);
                    return;
                }
            }
            if (Intrinsics.areEqual(bVar, a.b.d.f104429a)) {
                ECShopHomeSecondProductListFragment.ri(ECShopHomeSecondProductListFragment.this).setSucceededState();
                ECShopHomeSecondProductListFragment.qi(ECShopHomeSecondProductListFragment.this).setVisibility(8);
            } else if (bVar instanceof a.b.EmptyState) {
                ECShopHomeSecondProductListFragment.qi(ECShopHomeSecondProductListFragment.this).setVisibility(8);
                ECShopHomeSecondProductListFragment.this.vi();
            } else if (bVar instanceof a.b.ErrorState) {
                ECShopHomeSecondProductListFragment.ri(ECShopHomeSecondProductListFragment.this).setFailedState(((a.b.ErrorState) bVar).msg);
                ECShopHomeSecondProductListFragment.qi(ECShopHomeSecondProductListFragment.this).setVisibility(8);
            }
        }
    }

    public static final /* synthetic */ LinearLayout qi(ECShopHomeSecondProductListFragment eCShopHomeSecondProductListFragment) {
        LinearLayout linearLayout = eCShopHomeSecondProductListFragment.loadingContainer;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingContainer");
        }
        return linearLayout;
    }

    public static final /* synthetic */ ECStateCenterView ri(ECShopHomeSecondProductListFragment eCShopHomeSecondProductListFragment) {
        ECStateCenterView eCStateCenterView = eCShopHomeSecondProductListFragment.pageStateCenterView;
        if (eCStateCenterView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pageStateCenterView");
        }
        return eCStateCenterView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void vi() {
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
        Vh().I0(ECShopHomeScene.SCENE_SHOP_HOME);
        Vh().H0(ECShopHomePageType.PAGE_TYPE_TWO_LEVE_CATEGORY);
        Vh().K0(new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.shophome.fragment.ECShopHomeSecondProductListFragment$initProductList$1
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
                ECShopCategoryInfo eCShopCategoryInfo;
                Boolean value = ECShopHomeSecondProductListFragment.this.Xh().g2().getValue();
                Boolean bool = Boolean.TRUE;
                if ((!Intrinsics.areEqual(value, bool)) && (!Intrinsics.areEqual(ECShopHomeSecondProductListFragment.this.Xh().h2().getValue(), bool))) {
                    if (!(ECShopHomeSecondProductListFragment.this.Xh().getCookie().length() > 0) || (eCShopCategoryInfo = ECShopHomeSecondProductListFragment.this.category) == null) {
                        return;
                    }
                    String str = ECShopHomeSecondProductListFragment.this.shopId;
                    String cookie = ECShopHomeSecondProductListFragment.this.Xh().getCookie();
                    ECOrderByTabInfo value2 = ECShopHomeSecondProductListFragment.this.Xh().P1().getValue();
                    ECShopHomeFragment.Companion companion = ECShopHomeFragment.INSTANCE;
                    ECShopHomeSecondProductViewModel.y2(ECShopHomeSecondProductListFragment.this.Xh(), new ECShopHomeProductRequest(str, cookie, true, eCShopCategoryInfo, value2, null, companion.c(ECShopHomeSecondProductListFragment.this.getIsSelectStr()), companion.a(ECShopHomeSecondProductListFragment.this.getIsDistributorStr()), ECShopHomeSecondProductListFragment.this.getSource(), ECShopHomeSecondProductListFragment.this.getCouponId(), 32, null), false, 2, null);
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
        Xh().getPageState().observe(getViewLifecycleOwner(), new d());
    }

    @Override // com.tencent.ecommerce.biz.shophome.fragment.ECShopHomeProductListBaseFragment, com.tencent.ecommerce.base.fragment.api.IECBaseFragment
    /* renamed from: getBusinessDescription */
    public String getTAG() {
        return "ECShopHomeSecondProductListFragment";
    }

    @Override // com.tencent.ecommerce.biz.shophome.fragment.ECShopHomeProductListBaseFragment, com.tencent.ecommerce.base.fragment.ECBaseFragment
    public int getContentLayoutId() {
        return R.layout.crc;
    }

    @Override // com.tencent.ecommerce.biz.shophome.fragment.ECShopHomeProductListBaseFragment
    public void gi() {
        ECOrderByTabInfo selectedOrderByTabInfo = Wh().getSelectedOrderByTabInfo();
        ECShopCategoryInfo eCShopCategoryInfo = this.category;
        if (eCShopCategoryInfo != null) {
            String str = this.shopId;
            ECShopHomeFragment.Companion companion = ECShopHomeFragment.INSTANCE;
            Xh().x2(new ECShopHomeProductRequest(str, "", false, eCShopCategoryInfo, selectedOrderByTabInfo, null, companion.c(getIsSelectStr()), companion.a(getIsDistributorStr()), getSource(), getCouponId(), 32, null), true);
        }
    }

    @Override // com.tencent.ecommerce.biz.shophome.fragment.ECShopHomeProductListBaseFragment
    public void initArguments() {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String string;
        Intent intent;
        Bundle arguments = getArguments();
        String str9 = "";
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
        if (arguments3 == null || (str3 = arguments3.getString("category_name")) == null) {
            str3 = "";
        }
        this.categoryName = str3;
        Bundle arguments4 = getArguments();
        if (arguments4 == null || (str4 = arguments4.getString("coupon_id")) == null) {
            str4 = "";
        }
        hi(str4);
        FragmentActivity activity = getActivity();
        if (activity == null || (intent = activity.getIntent()) == null || (str5 = intent.getStringExtra("source")) == null) {
            str5 = "";
        }
        try {
            ni(Integer.parseInt(str5));
        } catch (Exception e16) {
            cg0.a.a("ECShopHomeSecondProductListFragment", "initArguments", "parse param source error, source string = " + str5 + " error = " + e16);
        }
        Bundle arguments5 = getArguments();
        if (arguments5 == null || (str6 = arguments5.getString("is_distributor")) == null) {
            str6 = "0";
        }
        ki(str6);
        Bundle arguments6 = getArguments();
        if (arguments6 == null || (str7 = arguments6.getString("is_select")) == null) {
            str7 = "";
        }
        mi(str7);
        Bundle arguments7 = getArguments();
        if (arguments7 == null || (str8 = arguments7.getString("scheme_callback_id")) == null) {
            str8 = "";
        }
        ji(str8);
        ii(ug0.a.b(getDeliverProductCallbackId()));
        Bundle arguments8 = getArguments();
        if (arguments8 != null && (string = arguments8.getString("category_info")) != null) {
            str9 = string;
        }
        if (str9.length() > 0) {
            try {
                this.category = new ECShopCategoryInfo(this.categoryName, new JSONObject(str9), 0, null, null, false, 60, null);
            } catch (JSONException e17) {
                cg0.a.a("ECShopHomeSecondProductListFragment", "[initArguments]", e17.toString());
            }
        }
    }

    @Override // com.tencent.ecommerce.biz.shophome.fragment.ECShopHomeProductListBaseFragment
    public void initUI(View rootView) {
        setTitle(this.categoryName);
        li((ViewGroup) rootView.findViewById(R.id.o2x));
        ECStateCenterView eCStateCenterView = (ECStateCenterView) rootView.findViewById(R.id.obr);
        eCStateCenterView.setRetryListener(new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.shophome.fragment.ECShopHomeSecondProductListFragment$initUI$$inlined$apply$lambda$1
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
                ECShopHomeSecondProductListFragment.this.gi();
            }
        });
        Unit unit = Unit.INSTANCE;
        this.pageStateCenterView = eCStateCenterView;
        if (eCStateCenterView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pageStateCenterView");
        }
        eCStateCenterView.setBackgroundColor(getResources().getColor(R.color.f7153h));
        this.loadingContainer = (LinearLayout) rootView.findViewById(R.id.o3d);
    }

    @Override // com.tencent.ecommerce.biz.shophome.fragment.ECShopHomeProductListBaseFragment
    /* renamed from: ui, reason: merged with bridge method [inline-methods] */
    public ECShopHomeSecondProductViewModel ci() {
        ECShopHomeSecondProductViewModel eCShopHomeSecondProductViewModel = (ECShopHomeSecondProductViewModel) new ViewModelProvider(requireActivity()).get(ECShopHomeSecondProductViewModel.class);
        eCShopHomeSecondProductViewModel.w2(eCShopHomeSecondProductViewModel.getShopId());
        eCShopHomeSecondProductViewModel.s2(eCShopHomeSecondProductViewModel.getSource());
        eCShopHomeSecondProductViewModel.n2(true);
        return eCShopHomeSecondProductViewModel;
    }
}
