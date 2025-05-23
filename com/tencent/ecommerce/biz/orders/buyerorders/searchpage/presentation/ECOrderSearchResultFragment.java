package com.tencent.ecommerce.biz.orders.buyerorders.searchpage.presentation;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.os.BundleKt;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ecommerce.base.fragment.ECBaseFragment;
import com.tencent.ecommerce.biz.orders.buyerorders.orderlist.ECOrderListFragment;
import com.tencent.ecommerce.biz.orders.buyerorders.orderlist.OrderListScene;
import com.tencent.ecommerce.biz.orders.buyerorders.searchpage.domain.ECOrderSearchScene;
import com.tencent.ecommerce.biz.orders.sampleorders.ECApplySampleOrderListFragment;
import com.tencent.ecommerce.repo.buyerorder.orderlist.ECQueryType;
import com.tencent.ecommerce.repo.sampleorder.ECApplySampleQueryType;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.QzoneIPCModule;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 *2\u00020\u0001:\u0001+B\u0007\u00a2\u0006\u0004\b(\u0010)J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\u0012\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u001a\u0010\u0010\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\"\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016R\u0016\u0010\u0018\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001f\u001a\u00020\u000e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b%\u0010&\u00a8\u0006,"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/buyerorders/searchpage/presentation/ECOrderSearchResultFragment;", "Lcom/tencent/ecommerce/base/fragment/ECBaseFragment;", "Landroidx/fragment/app/Fragment;", "Lh", "", "getContentLayoutId", "", "getBusinessDescription", "", "Eh", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "onCreate", "Landroid/view/View;", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", "P", "Ljava/lang/String;", "queryKeyword", "Lcom/tencent/ecommerce/biz/orders/buyerorders/searchpage/domain/ECOrderSearchScene;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/tencent/ecommerce/biz/orders/buyerorders/searchpage/domain/ECOrderSearchScene;", "searchScene", BdhLogUtil.LogTag.Tag_Req, "Landroid/view/View;", "searchBar", "Landroid/widget/TextView;", ExifInterface.LATITUDE_SOUTH, "Landroid/widget/TextView;", "searchQueryTextView", "Landroid/widget/FrameLayout;", "T", "Landroid/widget/FrameLayout;", "orderListContainer", "<init>", "()V", "U", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECOrderSearchResultFragment extends ECBaseFragment {

    /* renamed from: U, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: P, reason: from kotlin metadata */
    private String queryKeyword = "";

    /* renamed from: Q, reason: from kotlin metadata */
    private ECOrderSearchScene searchScene;

    /* renamed from: R, reason: from kotlin metadata */
    private View searchBar;

    /* renamed from: S, reason: from kotlin metadata */
    private TextView searchQueryTextView;

    /* renamed from: T, reason: from kotlin metadata */
    private FrameLayout orderListContainer;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006R\u0014\u0010\n\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u000bR\u0014\u0010\r\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000b\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/buyerorders/searchpage/presentation/ECOrderSearchResultFragment$a;", "", "Landroid/content/Context;", "context", "", "searchWording", "Lcom/tencent/ecommerce/biz/orders/buyerorders/searchpage/domain/ECOrderSearchScene;", "scene", "", "a", "ARG_KEY_SCENE", "Ljava/lang/String;", "ARG_KEY_SEARCH_QUERY", "TAG", "TAG_ORDER_LIST_FRAGMENT", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.biz.orders.buyerorders.searchpage.presentation.ECOrderSearchResultFragment$a, reason: from kotlin metadata */
    /* loaded from: classes31.dex */
    public static final class Companion {
        Companion() {
        }

        public final void a(Context context, String searchWording, ECOrderSearchScene scene) {
            yi0.a.q(context, ECOrderSearchResultFragment.class, BundleKt.bundleOf(TuplesKt.to("query", searchWording), TuplesKt.to("scene", Integer.valueOf(scene.ordinal()))), 0, null, 24, null);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK, "com/tencent/ecommerce/biz/orders/buyerorders/searchpage/presentation/ECOrderSearchResultFragment$onViewCreated$1$1"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    static final class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            FragmentActivity activity = ECOrderSearchResultFragment.this.getActivity();
            if (activity != null) {
                activity.finish();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    private final Fragment Lh() {
        ECOrderSearchScene eCOrderSearchScene = this.searchScene;
        if (eCOrderSearchScene == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchScene");
        }
        int i3 = com.tencent.ecommerce.biz.orders.buyerorders.searchpage.presentation.b.f103422a[eCOrderSearchScene.ordinal()];
        if (i3 == 1) {
            return ECOrderListFragment.Companion.b(ECOrderListFragment.INSTANCE, ECQueryType.ALL, this.queryKeyword, OrderListScene.ORDER_LIST_SEARCH, null, 8, null);
        }
        if (i3 == 2) {
            return ECApplySampleOrderListFragment.INSTANCE.a(ECApplySampleQueryType.ALL, this.queryKeyword, OrderListScene.ORDER_LIST_SEARCH);
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment
    public boolean Eh() {
        return true;
    }

    @Override // com.tencent.ecommerce.base.fragment.api.IECBaseFragment
    /* renamed from: getBusinessDescription */
    public String getTAG() {
        return "ECShopOrderSearchResultFragment";
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment
    public int getContentLayoutId() {
        return R.layout.crd;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        FragmentManager supportFragmentManager;
        FragmentActivity activity = getActivity();
        Fragment findFragmentByTag = (activity == null || (supportFragmentManager = activity.getSupportFragmentManager()) == null) ? null : supportFragmentManager.findFragmentByTag("order_list");
        ECOrderListFragment eCOrderListFragment = (ECOrderListFragment) (findFragmentByTag instanceof ECOrderListFragment ? findFragmentByTag : null);
        if (eCOrderListFragment != null) {
            eCOrderListFragment.onActivityResult(requestCode, resultCode, data);
        }
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        String str;
        int ordinal;
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments == null || (str = arguments.getString("query")) == null) {
            str = "";
        }
        this.queryKeyword = str;
        Bundle arguments2 = getArguments();
        if (arguments2 != null) {
            ordinal = arguments2.getInt("scene");
        } else {
            ordinal = ECOrderSearchScene.Q_SHOP.ordinal();
        }
        this.searchScene = ECOrderSearchScene.values()[ordinal];
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        FragmentManager supportFragmentManager;
        FragmentTransaction beginTransaction;
        FragmentTransaction add;
        super.onViewCreated(view, savedInstanceState);
        View findViewById = yh().findViewById(R.id.o3b);
        findViewById.setOnClickListener(new b());
        Unit unit = Unit.INSTANCE;
        this.searchBar = findViewById;
        TextView textView = (TextView) yh().findViewById(R.id.oe8);
        this.searchQueryTextView = textView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchQueryTextView");
        }
        textView.setText(this.queryKeyword);
        this.orderListContainer = (FrameLayout) yh().findViewById(R.id.o2x);
        FragmentActivity activity = getActivity();
        if (activity == null || (supportFragmentManager = activity.getSupportFragmentManager()) == null || (beginTransaction = supportFragmentManager.beginTransaction()) == null || (add = beginTransaction.add(R.id.o2x, Lh(), "order_list")) == null) {
            return;
        }
        add.commit();
    }
}
