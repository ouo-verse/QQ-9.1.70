package com.tencent.ecommerce.biz.productcenter.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.d;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheLunarData;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.ecommerce.base.router.api.IECSchemeCallback;
import com.tencent.ecommerce.biz.common.ECSearchBaseFragment;
import com.tencent.ecommerce.biz.productcenter.repo.ECSalesRankRepo;
import com.tencent.ecommerce.biz.productcenter.ui.view.ECFlexBoxLayoutMaxLines;
import com.tencent.ecommerce.biz.productcenter.ui.view.ECNestedScrollingParent2LayoutImpl;
import com.tencent.ecommerce.biz.productcenter.ui.view.ECSalesRankTabItemView;
import com.tencent.ecommerce.biz.productcenter.viewmodel.a;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.Constants;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 H2\u00020\u0001:\u0001IB\u0007\u00a2\u0006\u0004\bF\u0010GJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\u001a\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\r\u001a\u00020\u0002H\u0016J\b\u0010\u000e\u001a\u00020\u0006H\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0011\u001a\u00020\u0006H\u0016J\u0010\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\nH\u0002J\b\u0010\u0014\u001a\u00020\u0006H\u0002J\b\u0010\u0015\u001a\u00020\u0006H\u0002J\b\u0010\u0016\u001a\u00020\u0006H\u0002J\u0010\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u000fH\u0002J\b\u0010\u0019\u001a\u00020\u0006H\u0002J\b\u0010\u001a\u001a\u00020\u0006H\u0002J\u0010\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u000fH\u0002J\u0010\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u000fH\u0002J\b\u0010\u001d\u001a\u00020\u0006H\u0002J\b\u0010\u001e\u001a\u00020\u0006H\u0002J\b\u0010\u001f\u001a\u00020\u0006H\u0002R\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010-\u001a\u00020 8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b,\u0010\"R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0016\u00105\u001a\u0002028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0016\u00109\u001a\u0002068\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b7\u00108R\u001c\u0010>\u001a\b\u0012\u0004\u0012\u00020;0:8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010A\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010@R\u0018\u0010E\u001a\u0004\u0018\u00010B8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u0010D\u00a8\u0006J"}, d2 = {"Lcom/tencent/ecommerce/biz/productcenter/fragment/ECSelectProductSearchFragment;", "Lcom/tencent/ecommerce/biz/common/ECSearchBaseFragment;", "", "Eh", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "onCreate", "", "getContentLayoutId", "Landroid/view/View;", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "onBackPressed", "onResume", "", "getBusinessDescription", "Ph", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "initUI", "ii", "gi", "initLiveDataObserver", "searchQuery", "ci", "di", WidgetCacheLunarData.JI, "ki", "fi", "ei", "hi", "li", "Landroid/widget/ImageView;", "U", "Landroid/widget/ImageView;", "backImg", "Lcom/tencent/ecommerce/biz/productcenter/ui/view/ECNestedScrollingParent2LayoutImpl;", "V", "Lcom/tencent/ecommerce/biz/productcenter/ui/view/ECNestedScrollingParent2LayoutImpl;", "nestedScrolling", "Lcom/tencent/ecommerce/biz/productcenter/ui/view/ECFlexBoxLayoutMaxLines;", "W", "Lcom/tencent/ecommerce/biz/productcenter/ui/view/ECFlexBoxLayoutMaxLines;", "searchHistoryECFlex", "X", "clearSearchHistoryBtn", "Lcom/google/android/material/tabs/TabLayout;", "Y", "Lcom/google/android/material/tabs/TabLayout;", "salesRankTabLayout", "Landroidx/viewpager2/widget/ViewPager2;", "Z", "Landroidx/viewpager2/widget/ViewPager2;", "salesRankViewPager", "Lcom/tencent/ecommerce/biz/productcenter/viewmodel/a;", "a0", "Lcom/tencent/ecommerce/biz/productcenter/viewmodel/a;", "viewModel", "", "Lcom/tencent/ecommerce/biz/productcenter/fragment/ECSalesRankFragment;", "b0", "Ljava/util/List;", "pageList", "c0", "Ljava/lang/String;", "callbackId", "Lcom/tencent/ecommerce/base/router/api/IECSchemeCallback;", "d0", "Lcom/tencent/ecommerce/base/router/api/IECSchemeCallback;", "ecSchemeCallback", "<init>", "()V", "e0", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECSelectProductSearchFragment extends ECSearchBaseFragment {

    /* renamed from: U, reason: from kotlin metadata */
    private ImageView backImg;

    /* renamed from: V, reason: from kotlin metadata */
    private ECNestedScrollingParent2LayoutImpl nestedScrolling;

    /* renamed from: W, reason: from kotlin metadata */
    private ECFlexBoxLayoutMaxLines searchHistoryECFlex;

    /* renamed from: X, reason: from kotlin metadata */
    private ImageView clearSearchHistoryBtn;

    /* renamed from: Y, reason: from kotlin metadata */
    private TabLayout salesRankTabLayout;

    /* renamed from: Z, reason: from kotlin metadata */
    private ViewPager2 salesRankViewPager;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private a viewModel;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private List<ECSalesRankFragment> pageList = new ArrayList();

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    private String callbackId = "";

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    private IECSchemeCallback ecSchemeCallback;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class b implements View.OnClickListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f103910e;

        b(String str) {
            this.f103910e = str;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ECSelectProductSearchFragment.this.fi(this.f103910e);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "it", "", "a", "(Ljava/lang/Boolean;)V"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class c<T> implements Observer<Boolean> {
        c() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(Boolean bool) {
            ECSelectProductSearchFragment.this.Mh().setVisibility(bool.booleanValue() ? 4 : 0);
            ECSelectProductSearchFragment.this.Oh().setVisibility(bool.booleanValue() ? 0 : 4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u00042\u001a\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0001 \u0002*\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "", "kotlin.jvm.PlatformType", "it", "", "a", "(Ljava/util/List;)V"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class d<T> implements Observer<List<? extends String>> {
        d() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(List<String> list) {
            ECSelectProductSearchFragment.Xh(ECSelectProductSearchFragment.this).removeAllViews();
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                ECSelectProductSearchFragment.Xh(ECSelectProductSearchFragment.this).addView(ECSelectProductSearchFragment.this.ci(it.next()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n\u00a2\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/google/android/material/tabs/TabLayout$g;", "tab", "", "position", "", "a", "(Lcom/google/android/material/tabs/TabLayout$g;I)V"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class f implements d.b {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ List f103914b;

        f(List list) {
            this.f103914b = list;
        }

        @Override // com.google.android.material.tabs.d.b
        public final void a(TabLayout.g gVar, int i3) {
            gVar.f34288i.setGravity(80);
            gVar.f34288i.setBackground(null);
            gVar.p(new ECSalesRankTabItemView(ECSelectProductSearchFragment.this.requireContext(), (String) this.f103914b.get(i3), i3));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class h implements View.OnClickListener {
        h() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ECSelectProductSearchFragment.this.Nh().requestFocus();
            ECSelectProductSearchFragment.this.Rh(true);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class j implements View.OnClickListener {
        j() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ECSelectProductSearchFragment.Yh(ECSelectProductSearchFragment.this).M1();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class k implements View.OnClickListener {
        k() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ECSelectProductSearchFragment.this.ei();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public static final /* synthetic */ ECFlexBoxLayoutMaxLines Xh(ECSelectProductSearchFragment eCSelectProductSearchFragment) {
        ECFlexBoxLayoutMaxLines eCFlexBoxLayoutMaxLines = eCSelectProductSearchFragment.searchHistoryECFlex;
        if (eCFlexBoxLayoutMaxLines == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchHistoryECFlex");
        }
        return eCFlexBoxLayoutMaxLines;
    }

    public static final /* synthetic */ a Yh(ECSelectProductSearchFragment eCSelectProductSearchFragment) {
        a aVar = eCSelectProductSearchFragment.viewModel;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final View ci(String searchQuery) {
        View inflate = requireActivity().getLayoutInflater().inflate(R.layout.ctr, (ViewGroup) null, false);
        if (inflate != null) {
            TextView textView = (TextView) inflate;
            textView.setText(searchQuery);
            ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-2, -2);
            marginLayoutParams.bottomMargin = com.tencent.ecommerce.biz.util.e.c(12.0f);
            marginLayoutParams.rightMargin = com.tencent.ecommerce.biz.util.e.c(8.0f);
            textView.setLayoutParams(marginLayoutParams);
            textView.setMaxWidth(com.tencent.ecommerce.biz.util.e.c(350.0f));
            textView.setOnClickListener(new b(searchQuery));
            return textView;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
    }

    private final void di() {
        a aVar = this.viewModel;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        aVar.P1();
        a aVar2 = this.viewModel;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        List<String> value = aVar2.O1().getValue();
        boolean z16 = false;
        if (value != null && !value.isEmpty()) {
            z16 = true;
        }
        if (z16) {
            com.tencent.ecommerce.biz.common.f fVar = com.tencent.ecommerce.biz.common.f.f101556a;
            String Lh = Lh();
            a aVar3 = this.viewModel;
            if (aVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            fVar.c(Lh, fVar.b(aVar3.O1().getValue()), "xuanpin_search_history_query_exp");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ei() {
        IECSchemeCallback iECSchemeCallback = this.ecSchemeCallback;
        if (iECSchemeCallback != null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("is_clk_back", true);
            Unit unit = Unit.INSTANCE;
            iECSchemeCallback.onCallbackFinished(jSONObject);
        }
        new Handler().postDelayed(new Runnable() { // from class: com.tencent.ecommerce.biz.productcenter.fragment.ECSelectProductSearchFragment$handleClkBackForKTVSource$2
            @Override // java.lang.Runnable
            public final void run() {
                FragmentActivity activity = ECSelectProductSearchFragment.this.getActivity();
                if (activity != null) {
                    activity.finish();
                }
            }
        }, 300L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void fi(String searchQuery) {
        IECSchemeCallback iECSchemeCallback = this.ecSchemeCallback;
        if (iECSchemeCallback != null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("is_perform_search", true);
            jSONObject.put("query_txt", searchQuery);
            Unit unit = Unit.INSTANCE;
            iECSchemeCallback.onCallbackFinished(jSONObject);
        }
        a aVar = this.viewModel;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        aVar.L1(searchQuery);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    private final void gi() {
        ECNestedScrollingParent2LayoutImpl eCNestedScrollingParent2LayoutImpl = this.nestedScrolling;
        if (eCNestedScrollingParent2LayoutImpl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nestedScrolling");
        }
        eCNestedScrollingParent2LayoutImpl.setTopView(yh().findViewById(R.id.o0r));
        ECNestedScrollingParent2LayoutImpl eCNestedScrollingParent2LayoutImpl2 = this.nestedScrolling;
        if (eCNestedScrollingParent2LayoutImpl2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nestedScrolling");
        }
        TabLayout tabLayout = this.salesRankTabLayout;
        if (tabLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("salesRankTabLayout");
        }
        eCNestedScrollingParent2LayoutImpl2.setTabLayout(tabLayout);
        ECNestedScrollingParent2LayoutImpl eCNestedScrollingParent2LayoutImpl3 = this.nestedScrolling;
        if (eCNestedScrollingParent2LayoutImpl3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nestedScrolling");
        }
        ViewPager2 viewPager2 = this.salesRankViewPager;
        if (viewPager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("salesRankViewPager");
        }
        eCNestedScrollingParent2LayoutImpl3.setViewPager(viewPager2);
        ECNestedScrollingParent2LayoutImpl eCNestedScrollingParent2LayoutImpl4 = this.nestedScrolling;
        if (eCNestedScrollingParent2LayoutImpl4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nestedScrolling");
        }
        eCNestedScrollingParent2LayoutImpl4.setActivity(requireActivity());
    }

    private final void hi() {
        TabLayout tabLayout = this.salesRankTabLayout;
        if (tabLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("salesRankTabLayout");
        }
        tabLayout.f(new e());
    }

    private final void ii() {
        List listOf;
        List<ECSalesRankFragment> listOf2;
        hi();
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"\u65e5\u699c", "\u6708\u699c"});
        ECSalesRankFragment eCSalesRankFragment = new ECSalesRankFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("salesRankType", ECSalesRankRepo.SalesRankType.DAILY);
        bundle.putString(WadlProxyConsts.CHANNEL, Lh());
        Unit unit = Unit.INSTANCE;
        eCSalesRankFragment.setArguments(bundle);
        ECSalesRankFragment eCSalesRankFragment2 = new ECSalesRankFragment();
        Bundle bundle2 = new Bundle();
        bundle2.putSerializable("salesRankType", ECSalesRankRepo.SalesRankType.MONTHLY);
        bundle2.putString(WadlProxyConsts.CHANNEL, Lh());
        eCSalesRankFragment2.setArguments(bundle2);
        listOf2 = CollectionsKt__CollectionsKt.listOf((Object[]) new ECSalesRankFragment[]{eCSalesRankFragment, eCSalesRankFragment2});
        this.pageList = listOf2;
        ViewPager2 viewPager2 = this.salesRankViewPager;
        if (viewPager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("salesRankViewPager");
        }
        viewPager2.setAdapter(new com.tencent.ecommerce.biz.productcenter.ui.adapter.a(this, this.pageList));
        TabLayout tabLayout = this.salesRankTabLayout;
        if (tabLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("salesRankTabLayout");
        }
        ViewPager2 viewPager22 = this.salesRankViewPager;
        if (viewPager22 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("salesRankViewPager");
        }
        new com.google.android.material.tabs.d(tabLayout, viewPager22, new f(listOf)).a();
    }

    private final void initLiveDataObserver() {
        a aVar = this.viewModel;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        aVar.N1().observe(getViewLifecycleOwner(), new c());
        a aVar2 = this.viewModel;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        aVar2.O1().observe(getViewLifecycleOwner(), new d());
    }

    private final void ji() {
        String str;
        Intent intent;
        Nh().setOnClickListener(new h());
        Nh().setOnEditorActionListener(new i());
        FragmentActivity activity = getActivity();
        if (activity == null || (intent = activity.getIntent()) == null || (str = intent.getStringExtra("arg_query_string")) == null) {
            str = "";
        }
        a aVar = this.viewModel;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        aVar.Q1(TextUtils.isEmpty(str));
        Nh().addTextChangedListener(new g());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ki(String searchQuery) {
        fi(searchQuery);
        a aVar = this.viewModel;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        aVar.L1(searchQuery);
        com.tencent.ecommerce.biz.common.f fVar = com.tencent.ecommerce.biz.common.f.f101556a;
        fVar.e(Lh(), searchQuery, fVar.a(searchQuery), 1, "xuanpin_search_request");
    }

    private final void li() {
        ImageView imageView = this.clearSearchHistoryBtn;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("clearSearchHistoryBtn");
        }
        imageView.setOnClickListener(new j());
        ImageView imageView2 = this.backImg;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("backImg");
        }
        imageView2.setOnClickListener(new k());
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment
    public boolean Eh() {
        return true;
    }

    @Override // com.tencent.ecommerce.biz.common.ECSearchBaseFragment
    public void Ph() {
        String str;
        Intent intent;
        FragmentActivity activity = getActivity();
        if (activity == null || (intent = activity.getIntent()) == null || (str = intent.getStringExtra("arg_query_string")) == null) {
            str = "";
        }
        Nh().append(str);
        if (Intrinsics.areEqual(str, "")) {
            Nh().postDelayed(new Runnable() { // from class: com.tencent.ecommerce.biz.productcenter.fragment.ECSelectProductSearchFragment$initSearchEditText$1
                @Override // java.lang.Runnable
                public final void run() {
                    ECSelectProductSearchFragment.this.Nh().clearFocus();
                    ECSelectProductSearchFragment.this.Rh(false);
                }
            }, 100L);
        } else {
            Nh().postDelayed(new Runnable() { // from class: com.tencent.ecommerce.biz.productcenter.fragment.ECSelectProductSearchFragment$initSearchEditText$2
                @Override // java.lang.Runnable
                public final void run() {
                    ECSelectProductSearchFragment.this.Nh().requestFocus();
                    ECSelectProductSearchFragment.this.Rh(true);
                }
            }, 100L);
        }
    }

    @Override // com.tencent.ecommerce.biz.common.ECSearchBaseFragment, com.tencent.ecommerce.base.fragment.api.IECBaseFragment
    /* renamed from: getBusinessDescription */
    public String getTAG() {
        return "ECSelectProductSearchFragment";
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment
    public int getContentLayoutId() {
        return R.layout.f167332cr0;
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, com.tencent.ecommerce.base.ui.api.IECFragmentApi
    public boolean onBackPressed() {
        cg0.a.b("ECSelectProductSearchFragment", "[onBackPressed] isKtvProductCenter = true");
        ei();
        return true;
    }

    @Override // com.tencent.ecommerce.biz.common.ECSearchBaseFragment, com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        String str;
        Intent intent;
        super.onCreate(savedInstanceState);
        this.viewModel = (a) new ViewModelProvider(this).get(a.class);
        FragmentActivity activity = getActivity();
        if (activity == null || (intent = activity.getIntent()) == null || (str = intent.getStringExtra("scheme_callback_id")) == null) {
            str = "";
        }
        this.callbackId = str;
        this.ecSchemeCallback = ug0.a.b(str);
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ri0.c.f431472c.f(Lh());
    }

    @Override // com.tencent.ecommerce.biz.common.ECSearchBaseFragment, com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initUI(view);
        li();
        ji();
        initLiveDataObserver();
        di();
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/ecommerce/biz/productcenter/fragment/ECSelectProductSearchFragment$e", "Lcom/google/android/material/tabs/TabLayout$d;", "Lcom/google/android/material/tabs/TabLayout$g;", "tab", "", "onTabSelected", "onTabUnselected", "onTabReselected", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class e implements TabLayout.d {
        e() {
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void onTabSelected(TabLayout.g tab) {
            View e16 = tab != null ? tab.e() : null;
            if (e16 != null) {
                ((ECSalesRankTabItemView) e16).setSelected();
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type com.tencent.ecommerce.biz.productcenter.ui.view.ECSalesRankTabItemView");
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void onTabUnselected(TabLayout.g tab) {
            View e16 = tab != null ? tab.e() : null;
            if (e16 != null) {
                ((ECSalesRankTabItemView) e16).setUnselected();
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type com.tencent.ecommerce.biz.productcenter.ui.view.ECSalesRankTabItemView");
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void onTabReselected(TabLayout.g tab) {
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J*\u0010\f\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bH\u0016J*\u0010\u000e\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016\u00a8\u0006\u000f\u00b8\u0006\u0000"}, d2 = {"androidx/core/widget/TextViewKt$addTextChangedListener$textWatcher$1", "Landroid/text/TextWatcher;", "Landroid/text/Editable;", ReportConstant.COSTREPORT_PREFIX, "", "afterTextChanged", "", "text", "", "start", "count", "after", "beforeTextChanged", "before", "onTextChanged", "core-ktx_release"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class g implements TextWatcher {
        public g() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable s16) {
            String str;
            if (s16 == null || (str = s16.toString()) == null) {
                str = "";
            }
            ECSelectProductSearchFragment.Yh(ECSelectProductSearchFragment.this).Q1(TextUtils.isEmpty(str));
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence text, int start, int count, int after) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence text, int start, int before, int count) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u000e\u0010\u0007\u001a\n \u0004*\u0004\u0018\u00010\b0\bH\n\u00a2\u0006\u0002\b\t"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "actionId", "", "<anonymous parameter 2>", "Landroid/view/KeyEvent;", "onEditorAction"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class i implements TextView.OnEditorActionListener {
        i() {
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public final boolean onEditorAction(TextView textView, int i3, KeyEvent keyEvent) {
            CharSequence trim;
            if (i3 == 3) {
                String obj = ECSelectProductSearchFragment.this.Nh().getText().toString();
                if (obj.length() == 0) {
                    com.tencent.ecommerce.base.ui.i.f(com.tencent.ecommerce.base.ui.i.f101155b, "\u8bf7\u8f93\u5165\u5185\u5bb9", null, 0, 2, null);
                } else if (obj != null) {
                    trim = StringsKt__StringsKt.trim((CharSequence) obj);
                    String obj2 = trim.toString();
                    if (obj2.length() == 0) {
                        com.tencent.ecommerce.base.ui.i.f(com.tencent.ecommerce.base.ui.i.f101155b, "\u641c\u7d22\u5185\u5bb9\u4e0d\u80fd\u4e3a\u7a7a", null, 0, 2, null);
                    } else {
                        obj2 = new Regex("\\s{2,}").replace(obj2, " ");
                        ECSelectProductSearchFragment.this.Nh().clearFocus();
                        ECSelectProductSearchFragment.this.Rh(false);
                        ECSelectProductSearchFragment.this.ki(obj2);
                    }
                    ECSelectProductSearchFragment.this.Nh().setText(obj2);
                    ECSelectProductSearchFragment.this.Nh().setSelection(obj2.length());
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
                }
            }
            EventCollector.getInstance().onEditorAction(textView, i3, keyEvent);
            return true;
        }
    }

    private final void initUI(View rootView) {
        this.backImg = (ImageView) rootView.findViewById(R.id.o18);
        this.nestedScrolling = (ECNestedScrollingParent2LayoutImpl) rootView.findViewById(R.id.o9p);
        this.searchHistoryECFlex = (ECFlexBoxLayoutMaxLines) rootView.findViewById(R.id.nzj);
        this.clearSearchHistoryBtn = (ImageView) rootView.findViewById(R.id.o1c);
        this.salesRankTabLayout = (TabLayout) rootView.findViewById(R.id.o9n);
        this.salesRankViewPager = (ViewPager2) rootView.findViewById(R.id.o9o);
        ii();
        gi();
    }
}
