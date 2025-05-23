package com.tencent.ecommerce.biz.shophome.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import bj0.ECShopHomeProductRequest;
import bj0.ECShopHomeSearchResultRecommendRequest;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.ecommerce.base.list.IStateCenterView;
import com.tencent.ecommerce.base.report.service.ECShowPageCostTimeScene;
import com.tencent.ecommerce.base.report.service.k;
import com.tencent.ecommerce.base.router.api.IECSchemeCallback;
import com.tencent.ecommerce.base.ui.ECSkin;
import com.tencent.ecommerce.base.ui.stateview.ECStateCenterView;
import com.tencent.ecommerce.biz.shophome.fragment.ECShopHomeFragment;
import com.tencent.ecommerce.biz.shophome.model.ECOrderByTabInfo;
import com.tencent.ecommerce.biz.shophome.model.ECSearchScene;
import com.tencent.ecommerce.biz.shophome.model.ECShopProductInfo;
import com.tencent.ecommerce.biz.shophome.ui.adapter.ECShopHomeProductListRecyclerViewAdapter;
import com.tencent.ecommerce.biz.shophome.ui.component.ECShopSortBarComponent;
import com.tencent.ecommerce.biz.shophome.util.ECShopHomePageType;
import com.tencent.ecommerce.biz.shophome.util.ECShopHomeScene;
import com.tencent.ecommerce.biz.shophome.util.ECShopReportParams;
import com.tencent.ecommerce.biz.shophome.viewmodel.ECShopHomeSearchResultViewModel;
import com.tencent.ecommerce.biz.shophome.viewmodel.a;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 =2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001>B\u0007\u00a2\u0006\u0004\b;\u0010<J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\f\u001a\u00020\u0003H\u0016J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u0010\u001a\u00020\u0003H\u0016J\b\u0010\u0011\u001a\u00020\u0003H\u0016J\b\u0010\u0012\u001a\u00020\u0003H\u0016J\b\u0010\u0013\u001a\u00020\u0002H\u0016J\b\u0010\u0014\u001a\u00020\u0003H\u0016R\u0016\u0010\u0017\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0019\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0016R\u0016\u0010\u001e\u001a\u00020\r8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010 \u001a\u00020\r8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u001dR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0014\u00104\u001a\u0002018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0014\u00106\u001a\u0002018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b5\u00103R\u0014\u0010:\u001a\u0002078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b8\u00109\u00a8\u0006?"}, d2 = {"Lcom/tencent/ecommerce/biz/shophome/fragment/ECShopHomeSearchResultFragment;", "Lcom/tencent/ecommerce/biz/shophome/fragment/ECShopHomeProductListBaseFragment;", "Lcom/tencent/ecommerce/biz/shophome/viewmodel/ECShopHomeSearchResultViewModel;", "", "xi", "wi", "", "getContentLayoutId", "", "getBusinessDescription", "", "Eh", "initArguments", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "initUI", "bi", "ai", "di", "vi", "gi", "e0", "Ljava/lang/String;", "searchQuery", "f0", "shopId", "g0", "adClickId", "h0", "Landroid/view/View;", "searchBar", "i0", "searchCancel", "Landroid/widget/TextView;", "j0", "Landroid/widget/TextView;", "searchQueryTextView", "Landroid/widget/LinearLayout;", "k0", "Landroid/widget/LinearLayout;", "loadingContainer", "Lcom/tencent/ecommerce/biz/shophome/ui/component/f;", "l0", "Lcom/tencent/ecommerce/biz/shophome/ui/component/f;", "searchLoadingComponent", "Lcom/tencent/ecommerce/base/ui/stateview/ECStateCenterView;", "m0", "Lcom/tencent/ecommerce/base/ui/stateview/ECStateCenterView;", "pageStateCenterView", "Ljava/util/concurrent/atomic/AtomicBoolean;", "n0", "Ljava/util/concurrent/atomic/AtomicBoolean;", "firstScreenRecommend", "o0", "hasLoaded", "Lcom/tencent/ecommerce/base/report/service/k;", "p0", "Lcom/tencent/ecommerce/base/report/service/k;", "showPageCostTime", "<init>", "()V", "q0", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECShopHomeSearchResultFragment extends ECShopHomeProductListBaseFragment<ECShopHomeSearchResultViewModel> {

    /* renamed from: h0, reason: collision with root package name and from kotlin metadata */
    private View searchBar;

    /* renamed from: i0, reason: collision with root package name and from kotlin metadata */
    private View searchCancel;

    /* renamed from: j0, reason: collision with root package name and from kotlin metadata */
    private TextView searchQueryTextView;

    /* renamed from: k0, reason: collision with root package name and from kotlin metadata */
    private LinearLayout loadingContainer;

    /* renamed from: l0, reason: collision with root package name and from kotlin metadata */
    private com.tencent.ecommerce.biz.shophome.ui.component.f searchLoadingComponent;

    /* renamed from: m0, reason: collision with root package name and from kotlin metadata */
    private ECStateCenterView pageStateCenterView;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    private String searchQuery = "";

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    private String shopId = "";

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    private String adClickId = "";

    /* renamed from: n0, reason: collision with root package name and from kotlin metadata */
    private final AtomicBoolean firstScreenRecommend = new AtomicBoolean(false);

    /* renamed from: o0, reason: collision with root package name and from kotlin metadata */
    private final AtomicBoolean hasLoaded = new AtomicBoolean(false);

    /* renamed from: p0, reason: collision with root package name and from kotlin metadata */
    private final k showPageCostTime = new k(ECShowPageCostTimeScene.SHOW_COST_TIME_SCENE_SHOP_SEARCH_RESULT);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/tencent/ecommerce/biz/shophome/viewmodel/a$b;", "kotlin.jvm.PlatformType", "it", "", "a", "(Lcom/tencent/ecommerce/biz/shophome/viewmodel/a$b;)V"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    static final class c<T> implements Observer<a.b> {
        c() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(a.b bVar) {
            if (Intrinsics.areEqual(bVar, a.b.c.f104428a)) {
                if (ECShopHomeSearchResultFragment.this.hasLoaded.compareAndSet(false, true)) {
                    ECShopHomeSearchResultFragment.qi(ECShopHomeSearchResultFragment.this).setVisibility(0);
                }
            } else if (Intrinsics.areEqual(bVar, a.b.d.f104429a)) {
                ECShopHomeSearchResultFragment.qi(ECShopHomeSearchResultFragment.this).setVisibility(8);
                ECShopHomeSearchResultFragment.ri(ECShopHomeSearchResultFragment.this).setSucceededState();
            } else if (bVar instanceof a.b.EmptyState) {
                ECShopHomeSearchResultFragment.qi(ECShopHomeSearchResultFragment.this).setVisibility(8);
                ECShopHomeSearchResultFragment.this.wi();
            } else if (bVar instanceof a.b.ErrorState) {
                ECShopHomeSearchResultFragment.qi(ECShopHomeSearchResultFragment.this).setVisibility(8);
                ECShopHomeSearchResultFragment.ri(ECShopHomeSearchResultFragment.this).setFailedState(((a.b.ErrorState) bVar).msg);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u00042\u001a\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0001 \u0002*\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "Lcom/tencent/ecommerce/biz/shophome/model/c;", "kotlin.jvm.PlatformType", "it", "", "a", "(Ljava/util/List;)V"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    static final class e<T> implements Observer<List<? extends ECShopProductInfo>> {
        e() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(List<ECShopProductInfo> list) {
            if (!list.isEmpty()) {
                ECShopHomeSearchResultFragment.this.Vh().H0(ECShopHomePageType.PAGE_TYPE_SEARCH_RESULT_RECOMMEND);
                ECShopHomeSearchResultFragment.this.Vh().I0(ECShopHomeScene.SCENE_SHOP_HOME_SEARCH_RESULT_RECOMMEND);
                ECShopHomeProductListRecyclerViewAdapter Vh = ECShopHomeSearchResultFragment.this.Vh();
                Boolean value = ECShopHomeSearchResultFragment.this.Xh().g2().getValue();
                if (value == null) {
                    value = Boolean.FALSE;
                }
                Vh.J0(list, value.booleanValue());
            }
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
            FragmentActivity activity = ECShopHomeSearchResultFragment.this.getActivity();
            if (activity != null) {
                activity.finish();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class g implements View.OnClickListener {
        g() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", 1);
            jSONObject.put("target", 30);
            IECSchemeCallback deliverProductCallback = ECShopHomeSearchResultFragment.this.getDeliverProductCallback();
            if (deliverProductCallback != null) {
                deliverProductCallback.onCallbackFinished(jSONObject);
            }
            FragmentActivity activity = ECShopHomeSearchResultFragment.this.getActivity();
            if (activity != null) {
                activity.finish();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public static final /* synthetic */ LinearLayout qi(ECShopHomeSearchResultFragment eCShopHomeSearchResultFragment) {
        LinearLayout linearLayout = eCShopHomeSearchResultFragment.loadingContainer;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingContainer");
        }
        return linearLayout;
    }

    public static final /* synthetic */ ECStateCenterView ri(ECShopHomeSearchResultFragment eCShopHomeSearchResultFragment) {
        ECStateCenterView eCStateCenterView = eCShopHomeSearchResultFragment.pageStateCenterView;
        if (eCStateCenterView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pageStateCenterView");
        }
        return eCStateCenterView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void wi() {
        List<ECShopProductInfo> value = Xh().S1().getValue();
        if (value == null || value.isEmpty()) {
            List<ECShopProductInfo> value2 = Xh().T1().getValue();
            if (value2 == null || value2.isEmpty()) {
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
                IStateCenterView.a.a(eCStateCenterView2, getResources().getString(R.string.woi), null, ECSkin.INSTANCE.getColor(R.color.f6471n), 2, null);
            }
        }
    }

    private final void xi() {
        View view = this.searchBar;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchBar");
        }
        view.setOnClickListener(new f());
        View view2 = this.searchCancel;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchCancel");
        }
        view2.setOnClickListener(new g());
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment
    public boolean Eh() {
        return true;
    }

    @Override // com.tencent.ecommerce.biz.shophome.fragment.ECShopHomeProductListBaseFragment
    public void ai() {
        super.ai();
        Vh().K0(new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.shophome.fragment.ECShopHomeSearchResultFragment$initProductList$1
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
                if (ECShopHomeSearchResultFragment.this.Xh().S1().getValue() != null && (!r1.isEmpty())) {
                    Boolean value = ECShopHomeSearchResultFragment.this.Xh().g2().getValue();
                    Boolean bool = Boolean.TRUE;
                    if ((!Intrinsics.areEqual(value, bool)) && (!Intrinsics.areEqual(ECShopHomeSearchResultFragment.this.Xh().h2().getValue(), bool))) {
                        if (ECShopHomeSearchResultFragment.this.Xh().getCookie().length() > 0) {
                            String str = ECShopHomeSearchResultFragment.this.shopId;
                            String str2 = ECShopHomeSearchResultFragment.this.searchQuery;
                            String cookie = ECShopHomeSearchResultFragment.this.Xh().getCookie();
                            ECOrderByTabInfo value2 = ECShopHomeSearchResultFragment.this.Xh().P1().getValue();
                            ECShopHomeFragment.Companion companion = ECShopHomeFragment.INSTANCE;
                            ECShopHomeSearchResultViewModel.F2(ECShopHomeSearchResultFragment.this.Xh(), new ECShopHomeProductRequest(str, cookie, true, null, value2, str2, companion.c(ECShopHomeSearchResultFragment.this.getIsSelectStr()), companion.a(ECShopHomeSearchResultFragment.this.getIsDistributorStr()), ECShopHomeSearchResultFragment.this.getSource(), ECShopHomeSearchResultFragment.this.getCouponId(), 8, null), false, 2, null);
                            return;
                        }
                        return;
                    }
                    return;
                }
                if (ECShopHomeSearchResultFragment.this.Xh().T1().getValue() == null || !(!r1.isEmpty())) {
                    return;
                }
                Boolean value3 = ECShopHomeSearchResultFragment.this.Xh().j2().getValue();
                Boolean bool2 = Boolean.TRUE;
                if ((!Intrinsics.areEqual(value3, bool2)) && (!Intrinsics.areEqual(ECShopHomeSearchResultFragment.this.Xh().h2().getValue(), bool2))) {
                    if (ECShopHomeSearchResultFragment.this.Xh().getCookie().length() > 0) {
                        String str3 = ECShopHomeSearchResultFragment.this.shopId;
                        ArrayList arrayList = new ArrayList();
                        int i3 = ECSearchScene.SEARCH_SCENE_QQ_SHOP_INSIDE.type;
                        String str4 = ECShopHomeSearchResultFragment.this.searchQuery;
                        String recommendCookie = ECShopHomeSearchResultFragment.this.Xh().getRecommendCookie();
                        ECShopHomeFragment.Companion companion2 = ECShopHomeFragment.INSTANCE;
                        ECShopHomeSearchResultViewModel.H2(ECShopHomeSearchResultFragment.this.Xh(), new ECShopHomeSearchResultRecommendRequest(str3, arrayList, i3, str4, recommendCookie, companion2.c(ECShopHomeSearchResultFragment.this.getIsSelectStr()), true, companion2.a(ECShopHomeSearchResultFragment.this.getIsDistributorStr()), ECShopHomeSearchResultFragment.this.getSource()), false, 2, null);
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
        Xh().getPageState().observe(getViewLifecycleOwner(), new c());
        Xh().S1().observe(getViewLifecycleOwner(), new d());
        com.tencent.ecommerce.base.ktx.f fVar = com.tencent.ecommerce.base.ktx.f.f100751a;
        fVar.a(Xh().S1());
        Xh().T1().observe(getViewLifecycleOwner(), new e());
        fVar.a(Xh().T1());
    }

    @Override // com.tencent.ecommerce.biz.shophome.fragment.ECShopHomeProductListBaseFragment, com.tencent.ecommerce.base.fragment.api.IECBaseFragment
    /* renamed from: getBusinessDescription */
    public String getTAG() {
        return "ECShopHomeSearchResultFragment";
    }

    @Override // com.tencent.ecommerce.biz.shophome.fragment.ECShopHomeProductListBaseFragment, com.tencent.ecommerce.base.fragment.ECBaseFragment
    public int getContentLayoutId() {
        return R.layout.crb;
    }

    @Override // com.tencent.ecommerce.biz.shophome.fragment.ECShopHomeProductListBaseFragment
    public void gi() {
        String str = this.shopId;
        String str2 = this.searchQuery;
        ECShopHomeFragment.Companion companion = ECShopHomeFragment.INSTANCE;
        Xh().E2(new ECShopHomeProductRequest(str, "", false, null, null, str2, companion.c(getIsSelectStr()), companion.a(getIsDistributorStr()), getSource(), getCouponId(), 24, null), true);
    }

    @Override // com.tencent.ecommerce.biz.shophome.fragment.ECShopHomeProductListBaseFragment
    public void initArguments() {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        Intent intent;
        String stringExtra;
        String string;
        Bundle arguments = getArguments();
        String str6 = "";
        if (arguments == null || (str = arguments.getString("qz_gdt")) == null) {
            str = "";
        }
        this.adClickId = str;
        Bundle arguments2 = getArguments();
        if (arguments2 == null || (str2 = arguments2.getString("query")) == null) {
            str2 = "";
        }
        this.searchQuery = str2;
        Bundle arguments3 = getArguments();
        if (arguments3 == null || (str3 = arguments3.getString("shop_id")) == null) {
            str3 = "";
        }
        this.shopId = str3;
        Bundle arguments4 = getArguments();
        ni(arguments4 != null ? arguments4.getInt("source", 0) : 0);
        Bundle arguments5 = getArguments();
        String str7 = "0";
        if (arguments5 == null || (str4 = arguments5.getString("is_distributor")) == null) {
            str4 = "0";
        }
        ki(str4);
        Bundle arguments6 = getArguments();
        if (arguments6 != null && (string = arguments6.getString("is_select")) != null) {
            str7 = string;
        }
        mi(str7);
        Bundle arguments7 = getArguments();
        if (arguments7 == null || (str5 = arguments7.getString("coupon_id", "")) == null) {
            str5 = "";
        }
        hi(str5);
        FragmentActivity activity = getActivity();
        if (activity != null && (intent = activity.getIntent()) != null && (stringExtra = intent.getStringExtra("scheme_callback_id")) != null) {
            str6 = stringExtra;
        }
        ji(str6);
        ii(ug0.a.b(getDeliverProductCallbackId()));
        cg0.a.b("ECShopHomeSearchResultFragment", "[initArguments] searchQuery = " + this.searchQuery + ", shopId = " + this.shopId + " source = " + getSource());
    }

    @Override // com.tencent.ecommerce.biz.shophome.fragment.ECShopHomeProductListBaseFragment
    /* renamed from: vi, reason: merged with bridge method [inline-methods] */
    public ECShopHomeSearchResultViewModel ci() {
        ECShopHomeSearchResultViewModel eCShopHomeSearchResultViewModel = (ECShopHomeSearchResultViewModel) new ViewModelProvider(requireActivity()).get(ECShopHomeSearchResultViewModel.class);
        eCShopHomeSearchResultViewModel.w2(eCShopHomeSearchResultViewModel.getShopId());
        eCShopHomeSearchResultViewModel.s2(eCShopHomeSearchResultViewModel.getSource());
        eCShopHomeSearchResultViewModel.n2(true);
        eCShopHomeSearchResultViewModel.J2(this.showPageCostTime);
        return eCShopHomeSearchResultViewModel;
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/ecommerce/biz/shophome/fragment/ECShopHomeSearchResultFragment$b", "Lcom/tencent/ecommerce/biz/shophome/ui/component/ECShopSortBarComponent$IOrderByTabItemSelectedListener;", "Lcom/tencent/ecommerce/biz/shophome/model/a;", "orderByTabInfo", "", "onOrderByTabItemSelected", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class b implements ECShopSortBarComponent.IOrderByTabItemSelectedListener {
        b() {
        }

        @Override // com.tencent.ecommerce.biz.shophome.ui.component.ECShopSortBarComponent.IOrderByTabItemSelectedListener
        public void onOrderByTabItemSelected(ECOrderByTabInfo orderByTabInfo) {
            IStateCenterView.a.c(ECShopHomeSearchResultFragment.ri(ECShopHomeSearchResultFragment.this), null, 1, null);
            ECShopHomeSearchResultFragment.this.Xh().n2(true);
            ECShopHomeSearchResultFragment.this.Xh().l2(orderByTabInfo);
            String str = ECShopHomeSearchResultFragment.this.shopId;
            String str2 = ECShopHomeSearchResultFragment.this.searchQuery;
            ECShopHomeFragment.Companion companion = ECShopHomeFragment.INSTANCE;
            ECShopHomeSearchResultViewModel.F2(ECShopHomeSearchResultFragment.this.Xh(), new ECShopHomeProductRequest(str, "", false, null, orderByTabInfo, str2, companion.c(ECShopHomeSearchResultFragment.this.getIsSelectStr()), companion.a(ECShopHomeSearchResultFragment.this.getIsDistributorStr()), ECShopHomeSearchResultFragment.this.getSource(), ECShopHomeSearchResultFragment.this.getCouponId(), 8, null), false, 2, null);
        }
    }

    @Override // com.tencent.ecommerce.biz.shophome.fragment.ECShopHomeProductListBaseFragment
    public void initUI(View rootView) {
        String str;
        li((ViewGroup) rootView.findViewById(R.id.o2x));
        this.searchBar = rootView.findViewById(R.id.o9d);
        this.searchCancel = rootView.findViewById(R.id.od8);
        TextView textView = (TextView) rootView.findViewById(R.id.oe8);
        this.searchQueryTextView = textView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchQueryTextView");
        }
        textView.setText(this.searchQuery);
        this.loadingContainer = (LinearLayout) rootView.findViewById(R.id.o38);
        ECStateCenterView eCStateCenterView = (ECStateCenterView) rootView.findViewById(R.id.o37);
        eCStateCenterView.setRetryListener(new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.shophome.fragment.ECShopHomeSearchResultFragment$initUI$$inlined$apply$lambda$1
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
                ECShopHomeSearchResultFragment.this.gi();
            }
        });
        Unit unit = Unit.INSTANCE;
        this.pageStateCenterView = eCStateCenterView;
        if (eCStateCenterView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pageStateCenterView");
        }
        eCStateCenterView.setBackgroundColor(getResources().getColor(R.color.f7153h));
        Context requireContext = requireContext();
        if (ECShopHomeFragment.INSTANCE.c(getIsSelectStr())) {
            str = "qshop_skeleton_listpage";
        } else {
            str = "qshop_skeleton_mainpage";
        }
        this.searchLoadingComponent = new com.tencent.ecommerce.biz.shophome.ui.component.f(requireContext, str, false);
        LinearLayout linearLayout = this.loadingContainer;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingContainer");
        }
        com.tencent.ecommerce.biz.shophome.ui.component.f fVar = this.searchLoadingComponent;
        if (fVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchLoadingComponent");
        }
        linearLayout.addView(fVar.getComponentView());
        xi();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u00042\u001a\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0001 \u0002*\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "Lcom/tencent/ecommerce/biz/shophome/model/c;", "kotlin.jvm.PlatformType", "it", "", "a", "(Ljava/util/List;)V"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    static final class d<T> implements Observer<List<? extends ECShopProductInfo>> {
        d() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(List<ECShopProductInfo> list) {
            if (!list.isEmpty()) {
                ECShopHomeSearchResultFragment.this.Wh().getComponentView().setVisibility(0);
            } else {
                ECShopHomeSearchResultFragment.this.Wh().getComponentView().setVisibility(8);
            }
            ECShopHomeFragment.Companion companion = ECShopHomeFragment.INSTANCE;
            boolean c16 = companion.c(ECShopHomeSearchResultFragment.this.getIsSelectStr());
            boolean a16 = companion.a(ECShopHomeSearchResultFragment.this.getIsDistributorStr());
            if (list.isEmpty() && !c16 && !a16) {
                ECShopHomeSearchResultFragment.this.Xh().G2(new ECShopHomeSearchResultRecommendRequest(ECShopHomeSearchResultFragment.this.shopId, new ArrayList(), ECSearchScene.SEARCH_SCENE_QQ_SHOP_INSIDE.type, ECShopHomeSearchResultFragment.this.searchQuery, "", companion.c(ECShopHomeSearchResultFragment.this.getIsSelectStr()), false, companion.a(ECShopHomeSearchResultFragment.this.getIsDistributorStr()), ECShopHomeSearchResultFragment.this.getSource()), ECShopHomeSearchResultFragment.this.firstScreenRecommend.compareAndSet(false, true));
            } else {
                ECShopHomeSearchResultFragment.this.Vh().H0(ECShopHomePageType.PAGE_TYPE_SEARCH_RESULT);
                ECShopHomeSearchResultFragment.this.Vh().I0(ECShopHomeScene.SCENE_SHOP_HOME_SEARCH_RESULT);
                ECShopHomeProductListRecyclerViewAdapter Vh = ECShopHomeSearchResultFragment.this.Vh();
                Boolean value = ECShopHomeSearchResultFragment.this.Xh().g2().getValue();
                if (value == null) {
                    value = Boolean.FALSE;
                }
                Vh.J0(list, value.booleanValue());
                if (Intrinsics.areEqual(ECShopHomeSearchResultFragment.this.Xh().i2().getValue(), Boolean.TRUE)) {
                    ECShopHomeSearchResultFragment.this.Xh().u2(true);
                }
            }
            com.tencent.ecommerce.biz.shophome.util.a aVar = com.tencent.ecommerce.biz.shophome.util.a.f104379a;
            ECShopReportParams c17 = aVar.c(ECShopHomeSearchResultFragment.this.getArguments());
            aVar.t(c17.role, c17.shopId, c17.source, !list.isEmpty() ? 1 : 0);
        }
    }
}
