package com.tencent.ecommerce.biz.submitsucceed;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.weishi.WSAutoShowCommentParams;
import com.tencent.ecommerce.base.fragment.ECBaseFragment;
import com.tencent.ecommerce.base.ui.SlidingUpDialog;
import com.tencent.ecommerce.biz.comment.ECQShopReviewCommentFragment;
import com.tencent.ecommerce.biz.officialaccount.ECOfficialAccountGuideView;
import com.tencent.ecommerce.biz.orders.buyerorders.detail.model.OrderDetailEntrance;
import com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.qshop.ECShopOrderDetailFragment;
import com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.sample.ECSampleOrderDetailFragment;
import com.tencent.ecommerce.biz.recommend.models.ECProductRecommendItemData;
import com.tencent.ecommerce.biz.recommend.models.ECShopRecommendScene;
import com.tencent.ecommerce.biz.recommend.representation.ECProductRecommendAdapter;
import com.tencent.ecommerce.biz.router.ECScheme;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.request.GetAdInfoRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import mqq.app.Constants;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 S2\u00020\u0001:\u0001TB\u0007\u00a2\u0006\u0004\bQ\u0010RJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000e\u001a\u00020\fH\u0016J\b\u0010\u000f\u001a\u00020\fH\u0016J\b\u0010\u0010\u001a\u00020\bH\u0016J\b\u0010\u0011\u001a\u00020\bH\u0002J\u0010\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0004H\u0002J\u0010\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0004H\u0002J\b\u0010\u0015\u001a\u00020\bH\u0002J\b\u0010\u0016\u001a\u00020\bH\u0002J\b\u0010\u0017\u001a\u00020\bH\u0002J\b\u0010\u0018\u001a\u00020\bH\u0002R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010#\u001a\u00020\u00048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u001c\u0010+\u001a\b\u0012\u0004\u0012\u00020\n0(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00102\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0016\u00104\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00101R\u0016\u00106\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00101R\u0016\u00108\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00101R\u001b\u0010>\u001a\u0002098BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=R\u001b\u0010C\u001a\u00020?8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b@\u0010;\u001a\u0004\bA\u0010BR\u0018\u0010G\u001a\u0004\u0018\u00010D8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bE\u0010FR&\u0010L\u001a\u0014\u0012\u0004\u0012\u00020\u001d\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0I0H8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bJ\u0010KR\u0016\u0010P\u001a\u00020M8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bN\u0010O\u00a8\u0006U"}, d2 = {"Lcom/tencent/ecommerce/biz/submitsucceed/ECSubmitSucceedFragment;", "Lcom/tencent/ecommerce/base/fragment/ECBaseFragment;", "", "getContentLayoutId", "Landroid/view/View;", "view", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "", "getBusinessDescription", "", "Eh", "Dh", "Bh", "onDestroyView", "initArguments", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "initView", "ei", "di", "ci", "fi", "bi", "Lcom/tencent/ecommerce/biz/submitsucceed/SubmitSucceedUIState;", "P", "Lcom/tencent/ecommerce/biz/submitsucceed/SubmitSucceedUIState;", "uiState", "Lcom/tencent/ecommerce/biz/submitsucceed/SubmitSucceedFrom;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/tencent/ecommerce/biz/submitsucceed/SubmitSucceedFrom;", GetAdInfoRequest.SOURCE_FROM, BdhLogUtil.LogTag.Tag_Req, "Landroid/view/View;", "recommendProductTitle", "Landroidx/recyclerview/widget/RecyclerView;", ExifInterface.LATITUDE_SOUTH, "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "T", "Ljava/util/List;", "spuIds", "Lorg/json/JSONObject;", "U", "Lorg/json/JSONObject;", "extraJson", "V", "Ljava/lang/String;", "shopId", "W", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ORDER_ID, "X", WSAutoShowCommentParams.KEY_COMMENT_ID, "Y", "skuId", "Lcom/tencent/ecommerce/biz/recommend/models/ECShopRecommendScene;", "Z", "Lkotlin/Lazy;", "Zh", "()Lcom/tencent/ecommerce/biz/recommend/models/ECShopRecommendScene;", "recommendScene", "Lcom/tencent/ecommerce/biz/submitsucceed/ECSubmitSucceedViewModel;", "a0", "ai", "()Lcom/tencent/ecommerce/biz/submitsucceed/ECSubmitSucceedViewModel;", "viewModel", "Lcom/tencent/ecommerce/base/ui/SlidingUpDialog;", "b0", "Lcom/tencent/ecommerce/base/ui/SlidingUpDialog;", "officialAccountDialog", "", "Lkotlin/Function0;", "c0", "Ljava/util/Map;", "jumpActionMap", "Lcom/tencent/ecommerce/biz/recommend/representation/ECProductRecommendAdapter;", "d0", "Lcom/tencent/ecommerce/biz/recommend/representation/ECProductRecommendAdapter;", "adapter", "<init>", "()V", "e0", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECSubmitSucceedFragment extends ECBaseFragment {

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: P, reason: from kotlin metadata */
    private SubmitSucceedUIState uiState;

    /* renamed from: Q, reason: from kotlin metadata */
    private SubmitSucceedFrom sourceFrom;

    /* renamed from: R, reason: from kotlin metadata */
    private View recommendProductTitle;

    /* renamed from: S, reason: from kotlin metadata */
    private RecyclerView recyclerView;

    /* renamed from: T, reason: from kotlin metadata */
    private List<String> spuIds;

    /* renamed from: U, reason: from kotlin metadata */
    private JSONObject extraJson;

    /* renamed from: V, reason: from kotlin metadata */
    private String shopId;

    /* renamed from: W, reason: from kotlin metadata */
    private String orderId;

    /* renamed from: X, reason: from kotlin metadata */
    private String commentId;

    /* renamed from: Y, reason: from kotlin metadata */
    private String skuId;

    /* renamed from: Z, reason: from kotlin metadata */
    private final Lazy recommendScene;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private final Lazy viewModel;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private SlidingUpDialog officialAccountDialog;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    private final Map<SubmitSucceedFrom, Function0<Unit>> jumpActionMap;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    private ECProductRecommendAdapter adapter;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001d\u0010\u001eJ6\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\b\b\u0002\u0010\f\u001a\u00020\u000bR\u0014\u0010\u000f\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0010R\u0014\u0010\u0013\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0010R\u0014\u0010\u0014\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0010R\u0014\u0010\u0015\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0010R\u0014\u0010\u0016\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0010R\u0014\u0010\u0017\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0010R\u0014\u0010\u0018\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0010R\u0014\u0010\u001a\u001a\u00020\u00198\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u0010\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/ecommerce/biz/submitsucceed/ECSubmitSucceedFragment$a;", "", "Landroid/content/Context;", "context", "Lcom/tencent/ecommerce/biz/submitsucceed/SubmitSucceedUIState;", "uiState", "Lcom/tencent/ecommerce/biz/submitsucceed/SubmitSucceedFrom;", "from", "", "", "spuIdList", "Lorg/json/JSONObject;", "extra", "", "a", "BUNDLE_KEY_FROM", "Ljava/lang/String;", "BUNDLE_KEY_UI_STATE", "COMMENT_ID", "EXTRA_INFO", "ORDER_ID", "PRI_SORT_ID", "SHOP_ID", "SKU_ID", "SPU_ID_LIST", "", "START_TO_REQUEST_POSITION", "I", "TAG", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.biz.submitsucceed.ECSubmitSucceedFragment$a, reason: from kotlin metadata */
    /* loaded from: classes31.dex */
    public static final class Companion {
        Companion() {
        }

        public final void a(Context context, SubmitSucceedUIState uiState, SubmitSucceedFrom from, List<String> spuIdList, JSONObject extra) {
            Bundle bundle = new Bundle();
            bundle.putParcelable("bundle_key_ui_state", uiState);
            bundle.putInt("bundle_key_from", from.ordinal());
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.addAll(spuIdList);
            Unit unit = Unit.INSTANCE;
            bundle.putStringArrayList("spu_id_list", arrayList);
            bundle.putString("extra_info", extra.toString());
            yi0.a.q(context, ECSubmitSucceedFragment.class, bundle, 0, null, 24, null);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u00042\u001a\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0001 \u0002*\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "Lcom/tencent/ecommerce/biz/recommend/models/a;", "kotlin.jvm.PlatformType", "it", "", "a", "(Ljava/util/List;)V"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class b<T> implements Observer<List<? extends ECProductRecommendItemData>> {
        b() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(List<ECProductRecommendItemData> list) {
            if (list.isEmpty()) {
                ECSubmitSucceedFragment.Ph(ECSubmitSucceedFragment.this).setVisibility(4);
                ECSubmitSucceedFragment.Rh(ECSubmitSucceedFragment.this).setVisibility(8);
            } else {
                ECSubmitSucceedFragment.Ph(ECSubmitSucceedFragment.this).setVisibility(0);
                ECSubmitSucceedFragment.Rh(ECSubmitSucceedFragment.this).setVisibility(0);
                ECSubmitSucceedFragment.Lh(ECSubmitSucceedFragment.this).setData(list);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK, "com/tencent/ecommerce/biz/submitsucceed/ECSubmitSucceedFragment$initTopView$3$1"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            Function0 function0 = (Function0) ECSubmitSucceedFragment.this.jumpActionMap.get(ECSubmitSucceedFragment.Uh(ECSubmitSucceedFragment.this));
            if (function0 != null) {
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public ECSubmitSucceedFragment() {
        List<String> emptyList;
        Lazy lazy;
        Map<SubmitSucceedFrom, Function0<Unit>> mapOf;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        this.spuIds = emptyList;
        this.shopId = "";
        this.orderId = "";
        this.commentId = "";
        this.skuId = "";
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ECShopRecommendScene>() { // from class: com.tencent.ecommerce.biz.submitsucceed.ECSubmitSucceedFragment$recommendScene$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ECShopRecommendScene invoke() {
                return ECSubmitSucceedFragment.Uh(ECSubmitSucceedFragment.this).getRecommendScene();
            }
        });
        this.recommendScene = lazy;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.tencent.ecommerce.biz.submitsucceed.ECSubmitSucceedFragment$$special$$inlined$viewModels$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(ECSubmitSucceedViewModel.class), new Function0<ViewModelStore>() { // from class: com.tencent.ecommerce.biz.submitsucceed.ECSubmitSucceedFragment$$special$$inlined$viewModels$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                ViewModelStore viewModelStore = ((ViewModelStoreOwner) Function0.this.invoke()).getViewModelStore();
                Intrinsics.checkExpressionValueIsNotNull(viewModelStore, "ownerProducer().viewModelStore");
                return viewModelStore;
            }
        }, null);
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(SubmitSucceedFrom.PAY_IN_SUBMIT_ORDER, new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.submitsucceed.ECSubmitSucceedFragment$jumpActionMap$1
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
                String str;
                ECShopOrderDetailFragment.Companion companion = ECShopOrderDetailFragment.INSTANCE;
                Context requireContext = ECSubmitSucceedFragment.this.requireContext();
                str = ECSubmitSucceedFragment.this.orderId;
                companion.a(requireContext, str, OrderDetailEntrance.FROM_PAY_PAGE);
                c.f104810a.b();
                ECSubmitSucceedFragment.this.finish();
            }
        }), TuplesKt.to(SubmitSucceedFrom.PAY_IN_ORDER_LIST, new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.submitsucceed.ECSubmitSucceedFragment$jumpActionMap$2
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
                String str;
                ECShopOrderDetailFragment.Companion companion = ECShopOrderDetailFragment.INSTANCE;
                Context requireContext = ECSubmitSucceedFragment.this.requireContext();
                str = ECSubmitSucceedFragment.this.orderId;
                companion.a(requireContext, str, OrderDetailEntrance.FROM_PAY_PAGE);
                c.f104810a.b();
                ECSubmitSucceedFragment.this.finish();
            }
        }), TuplesKt.to(SubmitSucceedFrom.PAY_IN_ORDER_DETAIL, new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.submitsucceed.ECSubmitSucceedFragment$jumpActionMap$3
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
                c.f104810a.b();
                ECSubmitSucceedFragment.this.finish();
            }
        }), TuplesKt.to(SubmitSucceedFrom.WRITE_COMMENT, new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.submitsucceed.ECSubmitSucceedFragment$jumpActionMap$4
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
                String str;
                String str2;
                String str3;
                String str4;
                Object first;
                ECQShopReviewCommentFragment.Companion companion = ECQShopReviewCommentFragment.INSTANCE;
                Context requireContext = ECSubmitSucceedFragment.this.requireContext();
                str = ECSubmitSucceedFragment.this.commentId;
                companion.a(requireContext, str);
                com.tencent.ecommerce.biz.comment.d dVar = com.tencent.ecommerce.biz.comment.d.f101425a;
                str2 = ECSubmitSucceedFragment.this.orderId;
                if (!ECSubmitSucceedFragment.this.spuIds.isEmpty()) {
                    first = CollectionsKt___CollectionsKt.first((List<? extends Object>) ECSubmitSucceedFragment.this.spuIds);
                    str3 = (String) first;
                } else {
                    str3 = "";
                }
                str4 = ECSubmitSucceedFragment.this.skuId;
                dVar.e(str2, str3, str4);
                ECSubmitSucceedFragment.this.finish();
            }
        }), TuplesKt.to(SubmitSucceedFrom.APPLY_SAMPLE_ORDER, new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.submitsucceed.ECSubmitSucceedFragment$jumpActionMap$5
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
                String str;
                ECSampleOrderDetailFragment.Companion companion = ECSampleOrderDetailFragment.INSTANCE;
                Context requireContext = ECSubmitSucceedFragment.this.requireContext();
                str = ECSubmitSucceedFragment.this.orderId;
                companion.a(requireContext, str, OrderDetailEntrance.FROM_PAY_PAGE);
                c.f104810a.a();
                ECSubmitSucceedFragment.this.finish();
            }
        }));
        this.jumpActionMap = mapOf;
    }

    public static final /* synthetic */ ECProductRecommendAdapter Lh(ECSubmitSucceedFragment eCSubmitSucceedFragment) {
        ECProductRecommendAdapter eCProductRecommendAdapter = eCSubmitSucceedFragment.adapter;
        if (eCProductRecommendAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        return eCProductRecommendAdapter;
    }

    public static final /* synthetic */ View Ph(ECSubmitSucceedFragment eCSubmitSucceedFragment) {
        View view = eCSubmitSucceedFragment.recommendProductTitle;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recommendProductTitle");
        }
        return view;
    }

    public static final /* synthetic */ RecyclerView Rh(ECSubmitSucceedFragment eCSubmitSucceedFragment) {
        RecyclerView recyclerView = eCSubmitSucceedFragment.recyclerView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        }
        return recyclerView;
    }

    public static final /* synthetic */ SubmitSucceedFrom Uh(ECSubmitSucceedFragment eCSubmitSucceedFragment) {
        SubmitSucceedFrom submitSucceedFrom = eCSubmitSucceedFragment.sourceFrom;
        if (submitSucceedFrom == null) {
            Intrinsics.throwUninitializedPropertyAccessException(GetAdInfoRequest.SOURCE_FROM);
        }
        return submitSucceedFrom;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ECShopRecommendScene Zh() {
        return (ECShopRecommendScene) this.recommendScene.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ECSubmitSucceedViewModel ai() {
        return (ECSubmitSucceedViewModel) this.viewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void bi() {
        SlidingUpDialog slidingUpDialog;
        SlidingUpDialog slidingUpDialog2 = this.officialAccountDialog;
        if (slidingUpDialog2 == null || !slidingUpDialog2.isShowing() || (slidingUpDialog = this.officialAccountDialog) == null) {
            return;
        }
        slidingUpDialog.dismiss();
    }

    private final void ci() {
        ai().S1().observe(getViewLifecycleOwner(), new b());
        Lifecycle.State state = Lifecycle.State.STARTED;
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new ECSubmitSucceedFragment$initObserver$$inlined$launchAndRepeatWithViewLifecycle$1(this, state, null, this), 3, null);
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new ECSubmitSucceedFragment$initObserver$$inlined$launchAndRepeatWithViewLifecycle$2(this, state, null, this), 3, null);
    }

    private final void di() {
        this.recommendProductTitle = yh().findViewById(R.id.o8l);
        this.recyclerView = (RecyclerView) yh().findViewById(R.id.o8n);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, 1);
        RecyclerView recyclerView = this.recyclerView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        }
        recyclerView.setLayoutManager(staggeredGridLayoutManager);
        this.adapter = new ECProductRecommendAdapter(com.tencent.ecommerce.biz.recommend.models.b.a(Zh()), new Function1<String, Unit>() { // from class: com.tencent.ecommerce.biz.submitsucceed.ECSubmitSucceedFragment$initRecommendList$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String str) {
                if (str.length() == 0) {
                    cg0.a.a("ECQShopOpSucceedFragment", "onTapEventTriggered", "jump url is empty");
                }
                ECScheme.g(str, null, 2, null);
            }
        });
        RecyclerView recyclerView2 = this.recyclerView;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        }
        ECProductRecommendAdapter eCProductRecommendAdapter = this.adapter;
        if (eCProductRecommendAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        recyclerView2.setAdapter(eCProductRecommendAdapter);
        RecyclerView recyclerView3 = this.recyclerView;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        }
        recyclerView3.addOnScrollListener(new c(staggeredGridLayoutManager));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void fi() {
        SlidingUpDialog slidingUpDialog = this.officialAccountDialog;
        if (slidingUpDialog == null || !slidingUpDialog.isShowing()) {
            final SlidingUpDialog slidingUpDialog2 = new SlidingUpDialog(requireActivity(), true);
            slidingUpDialog2.setCanceledOnTouchOutside(false);
            ECOfficialAccountGuideView eCOfficialAccountGuideView = new ECOfficialAccountGuideView(requireContext());
            eCOfficialAccountGuideView.setOnCancelClickListener(new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.submitsucceed.ECSubmitSucceedFragment$showOfficialAccountGuideDialog$$inlined$also$lambda$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                    SlidingUpDialog.this.dismiss();
                }
            });
            eCOfficialAccountGuideView.setOnConfirmFollowListener(new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.submitsucceed.ECSubmitSucceedFragment$showOfficialAccountGuideDialog$$inlined$also$lambda$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                    this.ai().X1();
                }
            });
            SlidingUpDialog.U(slidingUpDialog2, eCOfficialAccountGuideView, null, 2, null);
            slidingUpDialog2.show();
            Unit unit = Unit.INSTANCE;
            this.officialAccountDialog = slidingUpDialog2;
            a.f104808a.g();
        }
    }

    private final void initArguments() {
        SubmitSucceedUIState submitSucceedUIState;
        List<String> emptyList;
        String jSONObject;
        Bundle arguments = getArguments();
        if (arguments == null || (submitSucceedUIState = (SubmitSucceedUIState) arguments.getParcelable("bundle_key_ui_state")) == null) {
            return;
        }
        this.uiState = submitSucceedUIState;
        SubmitSucceedFrom[] values = SubmitSucceedFrom.values();
        Bundle arguments2 = getArguments();
        this.sourceFrom = values[arguments2 != null ? arguments2.getInt("bundle_key_from") : 0];
        Bundle arguments3 = getArguments();
        if (arguments3 == null || (emptyList = arguments3.getStringArrayList("spu_id_list")) == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
        }
        this.spuIds = emptyList;
        Bundle arguments4 = getArguments();
        if (arguments4 == null || (jSONObject = arguments4.getString("extra_info")) == null) {
            jSONObject = new JSONObject().toString();
        }
        try {
            JSONObject jSONObject2 = new JSONObject(jSONObject);
            this.orderId = jSONObject2.optString("order_id");
            this.skuId = jSONObject2.optString("sku_id");
            this.shopId = jSONObject2.optString("shop_id");
            this.commentId = jSONObject2.optString("comment_id");
            Unit unit = Unit.INSTANCE;
            this.extraJson = jSONObject2;
        } catch (JSONException unused) {
            cg0.a.a("ECQShopOpSucceedFragment", "extraInfo", "extraInfo parse json error.");
        }
    }

    private final void initView(View rootView) {
        ei(rootView);
        di();
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
        return "ECQShopOpSucceedFragment";
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment
    public int getContentLayoutId() {
        return R.layout.cte;
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        ECProductRecommendAdapter eCProductRecommendAdapter = this.adapter;
        if (eCProductRecommendAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        eCProductRecommendAdapter.destroy();
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x003a, code lost:
    
        if (r3 == com.tencent.ecommerce.biz.submitsucceed.SubmitSucceedFrom.APPLY_SAMPLE_ORDER) goto L12;
     */
    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initArguments();
        setTitle("");
        initView(view);
        ci();
        ai().W1(this.shopId, this.spuIds, Zh());
        SubmitSucceedFrom submitSucceedFrom = this.sourceFrom;
        if (submitSucceedFrom == null) {
            Intrinsics.throwUninitializedPropertyAccessException(GetAdInfoRequest.SOURCE_FROM);
        }
        if (!submitSucceedFrom.isQShopOrderScene()) {
            SubmitSucceedFrom submitSucceedFrom2 = this.sourceFrom;
            if (submitSucceedFrom2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(GetAdInfoRequest.SOURCE_FROM);
            }
        }
        ai().Z1();
        com.tencent.ecommerce.biz.submitsucceed.c cVar = com.tencent.ecommerce.biz.submitsucceed.c.f104810a;
        SubmitSucceedFrom submitSucceedFrom3 = this.sourceFrom;
        if (submitSucceedFrom3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(GetAdInfoRequest.SOURCE_FROM);
        }
        JSONObject jSONObject = this.extraJson;
        if (jSONObject == null) {
            Intrinsics.throwUninitializedPropertyAccessException("extraJson");
        }
        cVar.c(submitSucceedFrom3, jSONObject);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J \u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0016R\u0016\u0010\r\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u000e"}, d2 = {"com/tencent/ecommerce/biz/submitsucceed/ECSubmitSucceedFragment$c", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "newState", "", "onScrollStateChanged", "dx", "dy", "onScrolled", "d", "I", "lastVisiblePosition", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class c extends RecyclerView.OnScrollListener {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private int lastVisiblePosition;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ StaggeredGridLayoutManager f104801f;

        c(StaggeredGridLayoutManager staggeredGridLayoutManager) {
            this.f104801f = staggeredGridLayoutManager;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int dx5, int dy5) {
            int lastIndex;
            super.onScrolled(recyclerView, dx5, dy5);
            int[] findLastVisibleItemPositions = this.f104801f.findLastVisibleItemPositions(null);
            int i3 = 1;
            if (!(findLastVisibleItemPositions.length == 0)) {
                int i16 = findLastVisibleItemPositions[0];
                lastIndex = ArraysKt___ArraysKt.getLastIndex(findLastVisibleItemPositions);
                if (1 <= lastIndex) {
                    while (true) {
                        int i17 = findLastVisibleItemPositions[i3];
                        if (i16 < i17) {
                            i16 = i17;
                        }
                        if (i3 == lastIndex) {
                            break;
                        } else {
                            i3++;
                        }
                    }
                }
                this.lastVisiblePosition = i16;
                return;
            }
            throw new NoSuchElementException();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            if (newState != 0 || ECSubmitSucceedFragment.this.ai().getIsEnd() || this.f104801f.getItemCount() - this.lastVisiblePosition > 4) {
                return;
            }
            ECSubmitSucceedFragment.this.ai().W1(ECSubmitSucceedFragment.this.shopId, ECSubmitSucceedFragment.this.spuIds, ECSubmitSucceedFragment.this.Zh());
        }
    }

    private final void ei(View rootView) {
        boolean isBlank;
        boolean isBlank2;
        TextView textView = (TextView) rootView.findViewById(R.id.obp);
        SubmitSucceedUIState submitSucceedUIState = this.uiState;
        if (submitSucceedUIState == null) {
            Intrinsics.throwUninitializedPropertyAccessException("uiState");
        }
        isBlank = StringsKt__StringsJVMKt.isBlank(submitSucceedUIState.title);
        if (isBlank) {
            textView.setVisibility(8);
        } else {
            SubmitSucceedUIState submitSucceedUIState2 = this.uiState;
            if (submitSucceedUIState2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("uiState");
            }
            textView.setText(submitSucceedUIState2.title);
        }
        TextView textView2 = (TextView) rootView.findViewById(R.id.obo);
        SubmitSucceedUIState submitSucceedUIState3 = this.uiState;
        if (submitSucceedUIState3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("uiState");
        }
        isBlank2 = StringsKt__StringsJVMKt.isBlank(submitSucceedUIState3.desc);
        if (isBlank2) {
            textView2.setVisibility(8);
        } else {
            SubmitSucceedUIState submitSucceedUIState4 = this.uiState;
            if (submitSucceedUIState4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("uiState");
            }
            textView2.setText(submitSucceedUIState4.desc);
        }
        TextView textView3 = (TextView) rootView.findViewById(R.id.f163054o22);
        SubmitSucceedUIState submitSucceedUIState5 = this.uiState;
        if (submitSucceedUIState5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("uiState");
        }
        textView3.setText(submitSucceedUIState5.buttonText);
        textView3.setOnClickListener(new d());
    }
}
