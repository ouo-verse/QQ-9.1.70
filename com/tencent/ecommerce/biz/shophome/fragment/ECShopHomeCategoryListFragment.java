package com.tencent.ecommerce.biz.shophome.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import bj0.ECShopHomeCategoryListRequest;
import cg0.a;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.ecommerce.base.fragment.ECBaseFragment;
import com.tencent.ecommerce.base.list.IStateCenterView;
import com.tencent.ecommerce.base.router.api.IECSchemeCallback;
import com.tencent.ecommerce.base.ui.ECSkin;
import com.tencent.ecommerce.base.ui.component.ECBaseRecyclerView;
import com.tencent.ecommerce.base.ui.stateview.ECStateCenterView;
import com.tencent.ecommerce.biz.shophome.fragment.ECShopHomeFragment;
import com.tencent.ecommerce.biz.shophome.model.ECShopCategoryInfo;
import com.tencent.ecommerce.biz.shophome.model.ECShopProductInfo;
import com.tencent.ecommerce.biz.shophome.ui.view.ECCategoryItemClickListener;
import com.tencent.ecommerce.biz.shophome.util.ECShopHomePageType;
import com.tencent.ecommerce.biz.shophome.viewmodel.ECShopHomeViewModel;
import com.tencent.ecommerce.biz.shophome.viewmodel.a;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 B2\u00020\u0001:\u0001CB\u0007\u00a2\u0006\u0004\b@\u0010AJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0002J\u001a\u0010\f\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001c\u001a\u00020\u00178\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0019R\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010+\u001a\u00020\u00048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00102\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0016\u00104\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00101R\u0016\u00106\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00101R\u0016\u00108\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00101R\u0016\u0010;\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0018\u0010?\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010>\u00a8\u0006D"}, d2 = {"Lcom/tencent/ecommerce/biz/shophome/fragment/ECShopHomeCategoryListFragment;", "Lcom/tencent/ecommerce/base/fragment/ECBaseFragment;", "", "initArguments", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Sh", "initViewModel", "Th", "view", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "", "getContentLayoutId", "", "getBusinessDescription", "", "Eh", "Lcom/tencent/ecommerce/biz/shophome/viewmodel/ECShopHomeViewModel;", "P", "Lcom/tencent/ecommerce/biz/shophome/viewmodel/ECShopHomeViewModel;", "viewModel", "Lcom/tencent/ecommerce/base/ui/component/ECBaseRecyclerView;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/tencent/ecommerce/base/ui/component/ECBaseRecyclerView;", "firstCategoryList", BdhLogUtil.LogTag.Tag_Req, "secondCategoryList", "Lcom/tencent/ecommerce/biz/shophome/ui/adapter/e;", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/ecommerce/biz/shophome/ui/adapter/e;", "firstCategoryListAdapter", "Lcom/tencent/ecommerce/biz/shophome/ui/adapter/g;", "T", "Lcom/tencent/ecommerce/biz/shophome/ui/adapter/g;", "secondCategoryListAdapter", "Landroid/widget/TextView;", "U", "Landroid/widget/TextView;", "showFirstCategory", "V", "Landroid/view/View;", "showTotalItemsBtn", "Lcom/tencent/ecommerce/base/ui/stateview/ECStateCenterView;", "W", "Lcom/tencent/ecommerce/base/ui/stateview/ECStateCenterView;", "pageStateCenterView", "X", "Ljava/lang/String;", "adClickId", "Y", "shopId", "Z", "isSelectStr", "a0", "isDistributorStr", "b0", "I", "source", "Lcom/tencent/ecommerce/base/router/api/IECSchemeCallback;", "c0", "Lcom/tencent/ecommerce/base/router/api/IECSchemeCallback;", "deliverProductCallback", "<init>", "()V", "d0", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECShopHomeCategoryListFragment extends ECBaseFragment {

    /* renamed from: P, reason: from kotlin metadata */
    private ECShopHomeViewModel viewModel;

    /* renamed from: Q, reason: from kotlin metadata */
    private ECBaseRecyclerView firstCategoryList;

    /* renamed from: R, reason: from kotlin metadata */
    private ECBaseRecyclerView secondCategoryList;

    /* renamed from: S, reason: from kotlin metadata */
    private com.tencent.ecommerce.biz.shophome.ui.adapter.e firstCategoryListAdapter;

    /* renamed from: T, reason: from kotlin metadata */
    private com.tencent.ecommerce.biz.shophome.ui.adapter.g secondCategoryListAdapter;

    /* renamed from: U, reason: from kotlin metadata */
    private TextView showFirstCategory;

    /* renamed from: V, reason: from kotlin metadata */
    private View showTotalItemsBtn;

    /* renamed from: W, reason: from kotlin metadata */
    private ECStateCenterView pageStateCenterView;

    /* renamed from: X, reason: from kotlin metadata */
    private String adClickId = "";

    /* renamed from: Y, reason: from kotlin metadata */
    private String shopId = "";

    /* renamed from: Z, reason: from kotlin metadata */
    private String isSelectStr = "0";

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private String isDistributorStr = "0";

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private int source;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    private IECSchemeCallback deliverProductCallback;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0017\u00a8\u0006\b"}, d2 = {"com/tencent/ecommerce/biz/shophome/fragment/ECShopHomeCategoryListFragment$b", "Lcom/tencent/ecommerce/biz/shophome/ui/view/ECCategoryItemClickListener;", "", "position", "Lcom/tencent/ecommerce/biz/shophome/model/b;", "categoryInfo", "", "onItemClickListener", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class b implements ECCategoryItemClickListener {
        b() {
        }

        @Override // com.tencent.ecommerce.biz.shophome.ui.view.ECCategoryItemClickListener
        public void onItemClickListener(int position, ECShopCategoryInfo categoryInfo) {
            ECShopHomeCategoryListFragment.Qh(ECShopHomeCategoryListFragment.this).R2(categoryInfo);
            ECShopHomeCategoryListFragment.Lh(ECShopHomeCategoryListFragment.this).notifyDataSetChanged();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/ecommerce/biz/shophome/fragment/ECShopHomeCategoryListFragment$c", "Lcom/tencent/ecommerce/biz/shophome/ui/view/ECCategoryItemClickListener;", "", "position", "Lcom/tencent/ecommerce/biz/shophome/model/b;", "categoryInfo", "", "onItemClickListener", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class c implements ECCategoryItemClickListener {
        c() {
        }

        @Override // com.tencent.ecommerce.biz.shophome.ui.view.ECCategoryItemClickListener
        public void onItemClickListener(int position, ECShopCategoryInfo categoryInfo) {
            String str = categoryInfo.url;
            a.b("ECShopHomeCategoryListFragment", "[initCategoryList] jumpUrl = " + str);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            com.tencent.ecommerce.biz.shophome.util.b.f104380a.f(ECShopHomeCategoryListFragment.this.requireActivity(), ECShopHomeCategoryListFragment.this.requireArguments(), ECShopHomePageType.PAGE_TYPE_TWO_LEVE_CATEGORY, str);
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
            ECShopCategoryInfo value = ECShopHomeCategoryListFragment.Qh(ECShopHomeCategoryListFragment.this).E2().getValue();
            if (value != null) {
                String str = value.url;
                a.b("ECShopHomeCategoryListFragment", "[initCategoryList] jumpUrl = " + str);
                if (!TextUtils.isEmpty(str)) {
                    com.tencent.ecommerce.biz.shophome.util.b.f104380a.f(ECShopHomeCategoryListFragment.this.requireActivity(), ECShopHomeCategoryListFragment.this.requireArguments(), ECShopHomePageType.PAGE_TYPE_ONE_LEVE_CATEGORY, str);
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"<anonymous>", "", "T", "t", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Object;)V", "androidx/lifecycle/LiveDataKt$observe$wrappedObserver$1"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class e<T> implements Observer<T> {
        public e() {
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(T t16) {
            List<ECShopCategoryInfo> list = (List) t16;
            List<ECShopProductInfo> value = ECShopHomeCategoryListFragment.Qh(ECShopHomeCategoryListFragment.this).S1().getValue();
            boolean z16 = value != null && (value.isEmpty() ^ true);
            boolean z17 = !list.isEmpty();
            if (z16 && z17) {
                ECShopHomeCategoryListFragment.Lh(ECShopHomeCategoryListFragment.this).setData(list);
                return;
            }
            if (z16 && !z17) {
                IStateCenterView.a.b(ECShopHomeCategoryListFragment.Mh(ECShopHomeCategoryListFragment.this), null, 1, null);
                return;
            }
            if (!z16 && z17) {
                ECShopHomeCategoryListFragment.Lh(ECShopHomeCategoryListFragment.this).setData(list);
            } else {
                if (z16 || z17) {
                    return;
                }
                IStateCenterView.a.a(ECShopHomeCategoryListFragment.Mh(ECShopHomeCategoryListFragment.this), "\u6682\u65e0\u5546\u54c1\u5206\u7c7b", null, ECSkin.INSTANCE.getColor(R.color.f6471n), 2, null);
            }
        }
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"<anonymous>", "", "T", "t", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Object;)V", "androidx/lifecycle/LiveDataKt$observe$wrappedObserver$1"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class f<T> implements Observer<T> {
        public f() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.lifecycle.Observer
        public final void onChanged(T t16) {
            ECShopCategoryInfo eCShopCategoryInfo = (ECShopCategoryInfo) t16;
            ECShopHomeCategoryListFragment.Ph(ECShopHomeCategoryListFragment.this).setText(eCShopCategoryInfo.name);
            ECShopHomeCategoryListFragment.Oh(ECShopHomeCategoryListFragment.this).setData(eCShopCategoryInfo.a());
            ECShopHomeCategoryListFragment.Nh(ECShopHomeCategoryListFragment.this).scrollToPosition(0);
        }
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"<anonymous>", "", "T", "t", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Object;)V", "androidx/lifecycle/LiveDataKt$observe$wrappedObserver$1"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class g<T> implements Observer<T> {
        public g() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.lifecycle.Observer
        public final void onChanged(T t16) {
            a.b bVar = (a.b) t16;
            if (Intrinsics.areEqual(bVar, a.b.c.f104428a)) {
                IStateCenterView.a.c(ECShopHomeCategoryListFragment.Mh(ECShopHomeCategoryListFragment.this), null, 1, null);
            } else if (Intrinsics.areEqual(bVar, a.b.d.f104429a)) {
                ECShopHomeCategoryListFragment.Mh(ECShopHomeCategoryListFragment.this).setSucceededState();
            } else if (bVar instanceof a.b.ErrorState) {
                ECShopHomeCategoryListFragment.Mh(ECShopHomeCategoryListFragment.this).setFailedState(((a.b.ErrorState) bVar).msg);
            }
        }
    }

    public static final /* synthetic */ com.tencent.ecommerce.biz.shophome.ui.adapter.e Lh(ECShopHomeCategoryListFragment eCShopHomeCategoryListFragment) {
        com.tencent.ecommerce.biz.shophome.ui.adapter.e eVar = eCShopHomeCategoryListFragment.firstCategoryListAdapter;
        if (eVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("firstCategoryListAdapter");
        }
        return eVar;
    }

    public static final /* synthetic */ ECStateCenterView Mh(ECShopHomeCategoryListFragment eCShopHomeCategoryListFragment) {
        ECStateCenterView eCStateCenterView = eCShopHomeCategoryListFragment.pageStateCenterView;
        if (eCStateCenterView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pageStateCenterView");
        }
        return eCStateCenterView;
    }

    public static final /* synthetic */ ECBaseRecyclerView Nh(ECShopHomeCategoryListFragment eCShopHomeCategoryListFragment) {
        ECBaseRecyclerView eCBaseRecyclerView = eCShopHomeCategoryListFragment.secondCategoryList;
        if (eCBaseRecyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("secondCategoryList");
        }
        return eCBaseRecyclerView;
    }

    public static final /* synthetic */ com.tencent.ecommerce.biz.shophome.ui.adapter.g Oh(ECShopHomeCategoryListFragment eCShopHomeCategoryListFragment) {
        com.tencent.ecommerce.biz.shophome.ui.adapter.g gVar = eCShopHomeCategoryListFragment.secondCategoryListAdapter;
        if (gVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("secondCategoryListAdapter");
        }
        return gVar;
    }

    public static final /* synthetic */ TextView Ph(ECShopHomeCategoryListFragment eCShopHomeCategoryListFragment) {
        TextView textView = eCShopHomeCategoryListFragment.showFirstCategory;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("showFirstCategory");
        }
        return textView;
    }

    public static final /* synthetic */ ECShopHomeViewModel Qh(ECShopHomeCategoryListFragment eCShopHomeCategoryListFragment) {
        ECShopHomeViewModel eCShopHomeViewModel = eCShopHomeCategoryListFragment.viewModel;
        if (eCShopHomeViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return eCShopHomeViewModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Th() {
        String str = this.shopId;
        ECShopHomeFragment.Companion companion = ECShopHomeFragment.INSTANCE;
        ECShopHomeCategoryListRequest eCShopHomeCategoryListRequest = new ECShopHomeCategoryListRequest(str, companion.c(this.isSelectStr), companion.a(this.isDistributorStr), this.source);
        ECShopHomeViewModel eCShopHomeViewModel = this.viewModel;
        if (eCShopHomeViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        eCShopHomeViewModel.G2(eCShopHomeCategoryListRequest);
    }

    private final void initArguments() {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        Intent intent;
        String stringExtra;
        Intent intent2;
        Bundle arguments = getArguments();
        String str6 = "";
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
        this.isSelectStr = str3;
        Bundle arguments4 = getArguments();
        if (arguments4 == null || (str4 = arguments4.getString("is_distributor", "")) == null) {
            str4 = "";
        }
        this.isDistributorStr = str4;
        FragmentActivity activity = getActivity();
        if (activity == null || (intent2 = activity.getIntent()) == null || (str5 = intent2.getStringExtra("source")) == null) {
            str5 = "";
        }
        try {
            this.source = Integer.parseInt(str5);
        } catch (Exception e16) {
            cg0.a.a("ECShopHomeCategoryListFragment", "initArguments", "parse param source error, source string = " + str5 + " error = " + e16);
        }
        FragmentActivity activity2 = getActivity();
        if (activity2 != null && (intent = activity2.getIntent()) != null && (stringExtra = intent.getStringExtra("scheme_callback_id")) != null) {
            str6 = stringExtra;
        }
        this.deliverProductCallback = ug0.a.b(str6);
    }

    private final void initViewModel() {
        ECShopHomeViewModel eCShopHomeViewModel = (ECShopHomeViewModel) new ViewModelProvider(requireActivity()).get(ECShopHomeViewModel.class);
        this.viewModel = eCShopHomeViewModel;
        if (eCShopHomeViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        eCShopHomeViewModel.D2().observe(getViewLifecycleOwner(), new e());
        ECShopHomeViewModel eCShopHomeViewModel2 = this.viewModel;
        if (eCShopHomeViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        eCShopHomeViewModel2.E2().observe(getViewLifecycleOwner(), new f());
        ECShopHomeViewModel eCShopHomeViewModel3 = this.viewModel;
        if (eCShopHomeViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        eCShopHomeViewModel3.getPageState().observe(getViewLifecycleOwner(), new g());
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment
    public boolean Eh() {
        return true;
    }

    @Override // com.tencent.ecommerce.base.fragment.api.IECBaseFragment
    /* renamed from: getBusinessDescription */
    public String getTAG() {
        return "ECShopHomeCategoryListFragment";
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment
    public int getContentLayoutId() {
        return R.layout.cr9;
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initArguments();
        Sh(view);
        initViewModel();
    }

    private final void Sh(View rootView) {
        ECStateCenterView eCStateCenterView = (ECStateCenterView) rootView.findViewById(R.id.o2v);
        eCStateCenterView.setRetryListener(new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.shophome.fragment.ECShopHomeCategoryListFragment$initCategoryList$$inlined$apply$lambda$1
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
                ECShopHomeCategoryListFragment.this.Th();
            }
        });
        Unit unit = Unit.INSTANCE;
        this.pageStateCenterView = eCStateCenterView;
        ECBaseRecyclerView eCBaseRecyclerView = (ECBaseRecyclerView) rootView.findViewById(R.id.o9l);
        this.firstCategoryList = eCBaseRecyclerView;
        if (eCBaseRecyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("firstCategoryList");
        }
        eCBaseRecyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        com.tencent.ecommerce.biz.shophome.ui.adapter.e eVar = new com.tencent.ecommerce.biz.shophome.ui.adapter.e();
        this.firstCategoryListAdapter = eVar;
        eVar.k0(new b());
        ECBaseRecyclerView eCBaseRecyclerView2 = this.firstCategoryList;
        if (eCBaseRecyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("firstCategoryList");
        }
        com.tencent.ecommerce.biz.shophome.ui.adapter.e eVar2 = this.firstCategoryListAdapter;
        if (eVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("firstCategoryListAdapter");
        }
        eCBaseRecyclerView2.setAdapter(eVar2);
        ECBaseRecyclerView eCBaseRecyclerView3 = (ECBaseRecyclerView) rootView.findViewById(R.id.o9m);
        this.secondCategoryList = eCBaseRecyclerView3;
        if (eCBaseRecyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("secondCategoryList");
        }
        eCBaseRecyclerView3.setLayoutManager(new LinearLayoutManager(requireContext()));
        com.tencent.ecommerce.biz.shophome.ui.adapter.g gVar = new com.tencent.ecommerce.biz.shophome.ui.adapter.g();
        this.secondCategoryListAdapter = gVar;
        gVar.k0(new c());
        ECBaseRecyclerView eCBaseRecyclerView4 = this.secondCategoryList;
        if (eCBaseRecyclerView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("secondCategoryList");
        }
        com.tencent.ecommerce.biz.shophome.ui.adapter.g gVar2 = this.secondCategoryListAdapter;
        if (gVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("secondCategoryListAdapter");
        }
        eCBaseRecyclerView4.setAdapter(gVar2);
        this.showFirstCategory = (TextView) rootView.findViewById(R.id.o3g);
        View findViewById = rootView.findViewById(R.id.o3h);
        this.showTotalItemsBtn = findViewById;
        if (findViewById == null) {
            Intrinsics.throwUninitializedPropertyAccessException("showTotalItemsBtn");
        }
        findViewById.setOnClickListener(new d());
        ECBaseRecyclerView eCBaseRecyclerView5 = this.firstCategoryList;
        if (eCBaseRecyclerView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("firstCategoryList");
        }
        eCBaseRecyclerView5.setItemAnimator(null);
        ECBaseRecyclerView eCBaseRecyclerView6 = this.secondCategoryList;
        if (eCBaseRecyclerView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("secondCategoryList");
        }
        eCBaseRecyclerView6.setItemAnimator(null);
    }
}
