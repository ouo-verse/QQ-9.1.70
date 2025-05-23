package com.tencent.ecommerce.biz.logistics;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ecommerce.base.fragment.ECBaseFragment;
import com.tencent.ecommerce.base.list.IStateCenterView;
import com.tencent.ecommerce.base.router.api.IECSchemeCallback;
import com.tencent.ecommerce.base.ui.ECSearchBarView;
import com.tencent.ecommerce.base.ui.stateview.ECStateCenterView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.Constants;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 E2\u00020\u0001:\u0001FB\u0007\u00a2\u0006\u0004\bC\u0010DJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\u0006H\u0016J\u001a\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\u0010\u001a\u00020\u000eH\u0014J\b\u0010\u0011\u001a\u00020\u0006H\u0016J \u0010\u0016\u001a\u00020\u000e2\u0016\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u00130\u0012j\b\u0012\u0004\u0012\u00020\u0013`\u0014H\u0002J\u0010\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u0004H\u0002J \u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\u00130\u0012j\b\u0012\u0004\u0012\u00020\u0013`\u00142\u0006\u0010\u0019\u001a\u00020\u0004H\u0002J\b\u0010\u001b\u001a\u00020\u000eH\u0002J\u0012\u0010\u001e\u001a\u00020\u000e2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0002R\u0018\u0010\"\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010(\u001a\u00020#8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b'\u0010%R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010/\u001a\u00020\n8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00101\u001a\u00020\n8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b0\u0010.R\u0016\u00103\u001a\u00020\n8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b2\u0010.R\u0016\u00107\u001a\u0002048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0016\u0010;\u001a\u0002088\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b9\u0010:R$\u0010>\u001a\u0012\u0012\u0004\u0012\u00020\u00130\u0012j\b\u0012\u0004\u0012\u00020\u0013`\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b<\u0010=R$\u0010@\u001a\u0012\u0012\u0004\u0012\u00020\u00130\u0012j\b\u0012\u0004\u0012\u00020\u0013`\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b?\u0010=R$\u0010B\u001a\u0012\u0012\u0004\u0012\u00020\u00130\u0012j\b\u0012\u0004\u0012\u00020\u0013`\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bA\u0010=\u00a8\u0006G"}, d2 = {"Lcom/tencent/ecommerce/biz/logistics/ECSelectExpressFragment;", "Lcom/tencent/ecommerce/base/fragment/ECBaseFragment;", "", "getContentLayoutId", "", "getBusinessDescription", "", "Bh", "Eh", "Dh", "Landroid/view/View;", "view", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "Fh", "onBackPressed", "Ljava/util/ArrayList;", "Lcom/tencent/ecommerce/biz/logistics/b;", "Lkotlin/collections/ArrayList;", "newData", "Xh", "text", "Zh", "query", "bi", "ai", "Landroid/widget/TextView;", "textView", "Yh", "Lcom/tencent/ecommerce/base/router/api/IECSchemeCallback;", "P", "Lcom/tencent/ecommerce/base/router/api/IECSchemeCallback;", "selectCallback", "Landroid/view/ViewGroup;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Landroid/view/ViewGroup;", "searchBarForground", BdhLogUtil.LogTag.Tag_Req, "searchBarLayout", "Lcom/tencent/ecommerce/base/ui/ECSearchBarView;", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/ecommerce/base/ui/ECSearchBarView;", "searchBar", "T", "Landroid/view/View;", "searchIcon", "U", "searchHint", "V", "searchCancelText", "Landroidx/recyclerview/widget/RecyclerView;", "W", "Landroidx/recyclerview/widget/RecyclerView;", "expressList", "Lcom/tencent/ecommerce/base/ui/stateview/ECStateCenterView;", "X", "Lcom/tencent/ecommerce/base/ui/stateview/ECStateCenterView;", "stateView", "Y", "Ljava/util/ArrayList;", "dataList", "Z", "originDataList", "a0", "emptyList", "<init>", "()V", "d0", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECSelectExpressFragment extends ECBaseFragment {

    /* renamed from: P, reason: from kotlin metadata */
    private IECSchemeCallback selectCallback;

    /* renamed from: Q, reason: from kotlin metadata */
    private ViewGroup searchBarForground;

    /* renamed from: R, reason: from kotlin metadata */
    private ViewGroup searchBarLayout;

    /* renamed from: S, reason: from kotlin metadata */
    private ECSearchBarView searchBar;

    /* renamed from: T, reason: from kotlin metadata */
    private View searchIcon;

    /* renamed from: U, reason: from kotlin metadata */
    private View searchHint;

    /* renamed from: V, reason: from kotlin metadata */
    private View searchCancelText;

    /* renamed from: W, reason: from kotlin metadata */
    private RecyclerView expressList;

    /* renamed from: X, reason: from kotlin metadata */
    private ECStateCenterView stateView;

    /* renamed from: Y, reason: from kotlin metadata */
    private final ArrayList<ECExpressCompany> dataList = new ArrayList<>();

    /* renamed from: Z, reason: from kotlin metadata */
    private final ArrayList<ECExpressCompany> originDataList = new ArrayList<>();

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private final ArrayList<ECExpressCompany> emptyList = new ArrayList<>();

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: b0, reason: collision with root package name */
    private static final ECExpressCompany f102862b0 = new ECExpressCompany("", "\u5176\u4ed6");

    /* renamed from: c0, reason: collision with root package name */
    private static final ArrayList<ECExpressCompany> f102863c0 = new ArrayList<>();

    /* compiled from: P */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001a\u0010\u001bJ \u0010\u0007\u001a\u00020\u00062\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004H\u0002J\u0016\u0010\n\u001a\u00020\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\bH\u0002R\u0017\u0010\u000b\u001a\u00020\u00038\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\u000f8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0013\u001a\u00020\u00128\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u00128\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0014R\u0014\u0010\u0016\u001a\u00020\u00128\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0014R\u0014\u0010\u0017\u001a\u00020\u00128\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0014R$\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/ecommerce/biz/logistics/ECSelectExpressFragment$a;", "", "Ljava/util/ArrayList;", "Lcom/tencent/ecommerce/biz/logistics/b;", "Lkotlin/collections/ArrayList;", "outList", "", "d", "", "cache", "e", "COMPANY_OTHER", "Lcom/tencent/ecommerce/biz/logistics/b;", "c", "()Lcom/tencent/ecommerce/biz/logistics/b;", "", "RETURN_CODE_ITEM_CLICK", "I", "", "SELECTED_EXPRESS_CODE", "Ljava/lang/String;", "SELECTED_EXPRESS_NAME", "SELECTED_RETURN_CODE", "TAG", "sDataList", "Ljava/util/ArrayList;", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.biz.logistics.ECSelectExpressFragment$a, reason: from kotlin metadata */
    /* loaded from: classes31.dex */
    public static final class Companion {
        Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void d(ArrayList<ECExpressCompany> outList) {
            outList.addAll(ECSelectExpressFragment.f102863c0);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void e(List<ECExpressCompany> cache) {
            ECSelectExpressFragment.f102863c0.clear();
            ECSelectExpressFragment.f102863c0.addAll(cache);
        }

        public final ECExpressCompany c() {
            return ECSelectExpressFragment.f102862b0;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    static final class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ECSelectExpressFragment.this.Yh((TextView) (!(view instanceof TextView) ? null : view));
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    static final class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ECSelectExpressFragment.Rh(ECSelectExpressFragment.this).setSearchText("");
            ECSelectExpressFragment.Sh(ECSelectExpressFragment.this).setVisibility(8);
            ECSelectExpressFragment.Th(ECSelectExpressFragment.this).setVisibility(0);
            ECSelectExpressFragment.Rh(ECSelectExpressFragment.this).e();
            ECSelectExpressFragment eCSelectExpressFragment = ECSelectExpressFragment.this;
            eCSelectExpressFragment.Xh(eCSelectExpressFragment.emptyList);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    static final class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ECSelectExpressFragment.Rh(ECSelectExpressFragment.this).setSearchText("");
            ECSelectExpressFragment.this.Zh("");
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public static final /* synthetic */ RecyclerView Oh(ECSelectExpressFragment eCSelectExpressFragment) {
        RecyclerView recyclerView = eCSelectExpressFragment.expressList;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("expressList");
        }
        return recyclerView;
    }

    public static final /* synthetic */ ECSearchBarView Rh(ECSelectExpressFragment eCSelectExpressFragment) {
        ECSearchBarView eCSearchBarView = eCSelectExpressFragment.searchBar;
        if (eCSearchBarView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchBar");
        }
        return eCSearchBarView;
    }

    public static final /* synthetic */ ViewGroup Sh(ECSelectExpressFragment eCSelectExpressFragment) {
        ViewGroup viewGroup = eCSelectExpressFragment.searchBarForground;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchBarForground");
        }
        return viewGroup;
    }

    public static final /* synthetic */ ViewGroup Th(ECSelectExpressFragment eCSelectExpressFragment) {
        ViewGroup viewGroup = eCSelectExpressFragment.searchBarLayout;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchBarLayout");
        }
        return viewGroup;
    }

    public static final /* synthetic */ ECStateCenterView Uh(ECSelectExpressFragment eCSelectExpressFragment) {
        ECStateCenterView eCStateCenterView = eCSelectExpressFragment.stateView;
        if (eCStateCenterView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stateView");
        }
        return eCStateCenterView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Xh(ArrayList<ECExpressCompany> newData) {
        this.dataList.clear();
        this.dataList.addAll(newData);
        RecyclerView recyclerView = this.expressList;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("expressList");
        }
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
        ECStateCenterView eCStateCenterView = this.stateView;
        if (eCStateCenterView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stateView");
        }
        eCStateCenterView.setSucceededState();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Zh(String text) {
        if (text.length() > 0) {
            ArrayList<ECExpressCompany> bi5 = bi(text);
            if (!bi5.isEmpty()) {
                Xh(bi5);
                return;
            }
            ECStateCenterView eCStateCenterView = this.stateView;
            if (eCStateCenterView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("stateView");
            }
            IStateCenterView.a.a(eCStateCenterView, "\u6682\u65e0\u7ed3\u679c", null, 0, 6, null);
            return;
        }
        if (this.dataList.size() != this.originDataList.size()) {
            Xh(this.originDataList);
        }
        ViewGroup viewGroup = this.searchBarForground;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchBarForground");
        }
        viewGroup.setVisibility(0);
        ViewGroup viewGroup2 = this.searchBarLayout;
        if (viewGroup2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchBarLayout");
        }
        viewGroup2.setVisibility(8);
    }

    private final void ai() {
        cg0.a.b("SelectExpressFragment", WebViewPlugin.KEY_REQUEST);
        ECStateCenterView eCStateCenterView = this.stateView;
        if (eCStateCenterView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stateView");
        }
        IStateCenterView.a.c(eCStateCenterView, null, 1, null);
        com.tencent.ecommerce.base.network.service.a.b("trpc.ecom.after_sales_svr.AfterSales", "/trpc.ecom.after_sales_svr.AfterSales/GetLogisticsCompanies", new com.tencent.ecommerce.biz.logistics.c(), new com.tencent.ecommerce.biz.logistics.d(), new ECSelectExpressFragment$requestData$1(this));
    }

    private final ArrayList<ECExpressCompany> bi(String query) {
        boolean contains$default;
        ArrayList<ECExpressCompany> arrayList = new ArrayList<>();
        Iterator<ECExpressCompany> it = this.originDataList.iterator();
        while (it.hasNext()) {
            ECExpressCompany next = it.next();
            contains$default = StringsKt__StringsKt.contains$default((CharSequence) next.name, (CharSequence) query, false, 2, (Object) null);
            if (contains$default) {
                arrayList.add(next);
            }
        }
        return arrayList;
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

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment
    protected void Fh() {
        ECSearchBarView eCSearchBarView = this.searchBar;
        if (eCSearchBarView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchBar");
        }
        eCSearchBarView.d();
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    @Override // com.tencent.ecommerce.base.fragment.api.IECBaseFragment
    /* renamed from: getBusinessDescription */
    public String getTAG() {
        return "SelectExpressFragment";
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment
    public int getContentLayoutId() {
        return R.layout.ctt;
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, com.tencent.ecommerce.base.ui.api.IECFragmentApi
    public boolean onBackPressed() {
        ECStateCenterView eCStateCenterView = this.stateView;
        if (eCStateCenterView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stateView");
        }
        if (eCStateCenterView.getVisibility() == 0) {
            Zh("");
            ECStateCenterView eCStateCenterView2 = this.stateView;
            if (eCStateCenterView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("stateView");
            }
            eCStateCenterView2.setSucceededState();
            return true;
        }
        return super.onBackPressed();
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        String str;
        Intent intent;
        super.onViewCreated(view, savedInstanceState);
        FragmentActivity activity = getActivity();
        if (activity == null || (intent = activity.getIntent()) == null || (str = intent.getStringExtra("scheme_callback_id")) == null) {
            str = "";
        }
        this.selectCallback = ug0.a.b(str);
        this.searchBarForground = (ViewGroup) view.findViewById(R.id.o_b);
        this.searchBarLayout = (ViewGroup) view.findViewById(R.id.o_c);
        this.searchBar = (ECSearchBarView) view.findViewById(R.id.o_a);
        this.searchIcon = view.findViewById(R.id.o_d);
        this.searchHint = view.findViewById(R.id.o_h);
        this.searchCancelText = view.findViewById(R.id.o_g);
        this.expressList = (RecyclerView) view.findViewById(R.id.o_e);
        this.stateView = (ECStateCenterView) view.findViewById(R.id.o_f);
        RecyclerView recyclerView = this.expressList;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("expressList");
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        RecyclerView recyclerView2 = this.expressList;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("expressList");
        }
        recyclerView2.setAdapter(new m(this.dataList, new b()));
        setTitle(R.string.wsf);
        ViewGroup viewGroup = this.searchBarForground;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchBarForground");
        }
        viewGroup.setOnClickListener(new c());
        ECSearchBarView eCSearchBarView = this.searchBar;
        if (eCSearchBarView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchBar");
        }
        eCSearchBarView.setSearchActionListener(new Function1<String, Unit>() { // from class: com.tencent.ecommerce.biz.logistics.ECSelectExpressFragment$onViewCreated$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str2) {
                invoke2(str2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String str2) {
                ECSelectExpressFragment.this.Zh(str2);
            }
        });
        View view2 = this.searchCancelText;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchCancelText");
        }
        view2.setOnClickListener(new d());
        INSTANCE.d(this.originDataList);
        cg0.a.b("SelectExpressFragment", "onViewCreated originDataList.size=" + this.originDataList.size());
        if (this.originDataList.isEmpty()) {
            ai();
            return;
        }
        Xh(this.originDataList);
        ECStateCenterView eCStateCenterView = this.stateView;
        if (eCStateCenterView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stateView");
        }
        eCStateCenterView.setSucceededState();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Yh(TextView textView) {
        if (textView != null) {
            JSONObject jSONObject = new JSONObject();
            Object tag = textView.getTag();
            if (!(tag instanceof ECExpressCompany)) {
                tag = null;
            }
            ECExpressCompany eCExpressCompany = (ECExpressCompany) tag;
            if (eCExpressCompany != null) {
                jSONObject.put("SELECTED_EXPRESS_NAME", eCExpressCompany.name);
                jSONObject.put("SELECTED_EXPRESS_CODE", eCExpressCompany.code);
                jSONObject.put("SELECTED_RETURN_CODE", 1);
                IECSchemeCallback iECSchemeCallback = this.selectCallback;
                if (iECSchemeCallback != null) {
                    iECSchemeCallback.onCallbackFinished(jSONObject);
                }
            }
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.finish();
            }
        }
    }
}
