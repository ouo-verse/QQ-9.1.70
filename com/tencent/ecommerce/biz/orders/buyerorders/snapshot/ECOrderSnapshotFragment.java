package com.tencent.ecommerce.biz.orders.buyerorders.snapshot;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ecommerce.base.QQECChannel;
import com.tencent.ecommerce.base.fragment.ECBaseFragment;
import com.tencent.ecommerce.base.ui.ECBasePtsViewData;
import com.tencent.ecommerce.base.ui.SlidingUpDialog;
import com.tencent.ecommerce.base.ui.component.ECBaseRecyclerView;
import com.tencent.ecommerce.base.ui.component.IECPTSProcessor;
import com.tencent.ecommerce.biz.detail.dataprocessor.processor.ECProductDetailDataParserType;
import com.tencent.ecommerce.biz.live.SourceFrom;
import com.tencent.ecommerce.biz.router.ECScheme;
import com.tencent.ecommerce.biz.util.k;
import com.tencent.ecommerce.biz.util.r;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import mqq.app.Constants;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 G2\u00020\u0001:\u0001HB\u0007\u00a2\u0006\u0004\bE\u0010FJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0002J\u001e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\u0010\u001a\u00020\u0004H\u0002J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\u001e\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u000b2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\rH\u0002J\b\u0010\u0019\u001a\u00020\u0018H\u0016J\b\u0010\u001a\u001a\u00020\u0011H\u0016J\b\u0010\u001b\u001a\u00020\u000bH\u0016J\u001a\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010\u001f\u001a\u00020\u0004H\u0016R\u0016\u0010\"\u001a\u00020\u00028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010$\u001a\u00020\u00028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b#\u0010!R\u0016\u0010&\u001a\u00020\u00028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b%\u0010!R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010,\u001a\u00020'8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b+\u0010)R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0016\u00108\u001a\u0002058\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010\u0012\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u001b\u0010@\u001a\u00020;8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?R\u0016\u0010D\u001a\u00020A8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bB\u0010C\u00a8\u0006I"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/buyerorders/snapshot/ECOrderSnapshotFragment;", "Lcom/tencent/ecommerce/base/fragment/ECBaseFragment;", "Landroid/view/View;", "view", "", "Vh", "initTitleBar", "Sh", "initArguments", "Lorg/json/JSONObject;", "data", "", "productTitle", "", "Lcom/tencent/ecommerce/base/ui/b;", "Wh", "initClickListener", "", "scrollY", "Uh", "title", "Lcom/tencent/ecommerce/biz/orders/buyerorders/snapshot/d;", "params", "Xh", "", "Eh", "getContentLayoutId", "getBusinessDescription", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "onResume", "P", "Landroid/view/View;", "titleBarParent", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "titleBar", BdhLogUtil.LogTag.Tag_Req, "titleBarBackground", "Landroid/widget/ImageView;", ExifInterface.LATITUDE_SOUTH, "Landroid/widget/ImageView;", "backButton", "T", "blackBackButton", "Landroid/widget/TextView;", "U", "Landroid/widget/TextView;", "titleTextView", "Lcom/tencent/ecommerce/base/ui/component/ECBaseRecyclerView;", "V", "Lcom/tencent/ecommerce/base/ui/component/ECBaseRecyclerView;", "recyclerView", "Lbh0/b;", "W", "Lbh0/b;", "adapter", "X", "I", "Lcom/tencent/ecommerce/biz/orders/buyerorders/snapshot/a;", "Y", "Lkotlin/Lazy;", "Th", "()Lcom/tencent/ecommerce/biz/orders/buyerorders/snapshot/a;", "ptsHostViewModel", "Lcom/tencent/ecommerce/biz/orders/buyerorders/snapshot/OrderSnapShotData;", "Z", "Lcom/tencent/ecommerce/biz/orders/buyerorders/snapshot/OrderSnapShotData;", "snapShotData", "<init>", "()V", "a0", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECOrderSnapshotFragment extends ECBaseFragment {

    /* renamed from: P, reason: from kotlin metadata */
    private View titleBarParent;

    /* renamed from: Q, reason: from kotlin metadata */
    private View titleBar;

    /* renamed from: R, reason: from kotlin metadata */
    private View titleBarBackground;

    /* renamed from: S, reason: from kotlin metadata */
    private ImageView backButton;

    /* renamed from: T, reason: from kotlin metadata */
    private ImageView blackBackButton;

    /* renamed from: U, reason: from kotlin metadata */
    private TextView titleTextView;

    /* renamed from: V, reason: from kotlin metadata */
    private ECBaseRecyclerView recyclerView;

    /* renamed from: W, reason: from kotlin metadata */
    private bh0.b adapter;

    /* renamed from: X, reason: from kotlin metadata */
    private int scrollY;

    /* renamed from: Y, reason: from kotlin metadata */
    private final Lazy ptsHostViewModel;

    /* renamed from: Z, reason: from kotlin metadata */
    private OrderSnapShotData snapShotData;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0016J\u001e\u0010\f\u001a\u00020\u00022\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/ecommerce/biz/orders/buyerorders/snapshot/ECOrderSnapshotFragment$b", "Lcom/tencent/ecommerce/biz/orders/buyerorders/snapshot/ISnapshotClickListener;", "", "showLatestProductDetail", "showSpecDialog", "showPropertyDialog", "enterShopDetailPage", "", "", "photoUrls", "", "curIndex", "showPhotoInBrowser", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class b implements ISnapshotClickListener {
        b() {
        }

        @Override // com.tencent.ecommerce.biz.orders.buyerorders.snapshot.ISnapshotClickListener
        public void enterShopDetailPage() {
            String str = ECOrderSnapshotFragment.Nh(ECOrderSnapshotFragment.this).productInfo.shop.id;
            ECScheme.g("mqqapi://ecommerce/open?target=21&channel=" + QQECChannel.CHANNEL_QQ_ECOMMERCE_BASE.ordinal() + "&shop_id=" + str, null, 2, null);
            com.tencent.ecommerce.biz.orders.buyerorders.snapshot.c.f103434a.a(ECOrderSnapshotFragment.Nh(ECOrderSnapshotFragment.this).orderInfo.id, str);
        }

        @Override // com.tencent.ecommerce.biz.orders.buyerorders.snapshot.ISnapshotClickListener
        public void showLatestProductDetail() {
            String str = ECOrderSnapshotFragment.Nh(ECOrderSnapshotFragment.this).productInfo.spuId;
            ECScheme.g("mqqapi://ecommerce/open?target=9&channel=" + QQECChannel.CHANNEL_QQ_ECOMMERCE_BASE.ordinal() + "&spu_id=" + str + "&biz_type=1&is_select=0&source_from=" + SourceFrom.SOURCE_FROM_UNKNOWN, null, 2, null);
            com.tencent.ecommerce.biz.orders.buyerorders.snapshot.c.f103434a.b(ECOrderSnapshotFragment.Nh(ECOrderSnapshotFragment.this).orderInfo.id, str);
        }

        @Override // com.tencent.ecommerce.biz.orders.buyerorders.snapshot.ISnapshotClickListener
        public void showPhotoInBrowser(List<String> photoUrls, int curIndex) {
            lg0.a.b(lg0.a.f414523b, photoUrls, curIndex, null, 4, null);
        }

        @Override // com.tencent.ecommerce.biz.orders.buyerorders.snapshot.ISnapshotClickListener
        public void showPropertyDialog() {
            int collectionSizeOrDefault;
            ECOrderSnapshotFragment eCOrderSnapshotFragment = ECOrderSnapshotFragment.this;
            List<SnapshotProductProp> properties = ECOrderSnapshotFragment.Nh(eCOrderSnapshotFragment).productInfo.product.getProperties();
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(properties, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            for (SnapshotProductProp snapshotProductProp : properties) {
                arrayList.add(new com.tencent.ecommerce.biz.orders.buyerorders.snapshot.d(snapshotProductProp.name, snapshotProductProp.value));
            }
            eCOrderSnapshotFragment.Xh("\u4ea7\u54c1\u53c2\u6570", arrayList);
        }

        @Override // com.tencent.ecommerce.biz.orders.buyerorders.snapshot.ISnapshotClickListener
        public void showSpecDialog() {
            int collectionSizeOrDefault;
            ECOrderSnapshotFragment eCOrderSnapshotFragment = ECOrderSnapshotFragment.this;
            List<SnapshotSpecification> specifications = ECOrderSnapshotFragment.Nh(eCOrderSnapshotFragment).productInfo.product.getSpecifications();
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(specifications, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            for (SnapshotSpecification snapshotSpecification : specifications) {
                arrayList.add(new com.tencent.ecommerce.biz.orders.buyerorders.snapshot.d(snapshotSpecification.name, snapshotSpecification.value));
            }
            eCOrderSnapshotFragment.Xh("\u4ea7\u54c1\u89c4\u683c", arrayList);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/ecommerce/biz/orders/buyerorders/snapshot/ECOrderSnapshotFragment$c", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "dx", "dy", "", "onScrolled", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class c extends RecyclerView.OnScrollListener {
        c() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int dx5, int dy5) {
            super.onScrolled(recyclerView, dx5, dy5);
            ECOrderSnapshotFragment.this.scrollY += dy5;
            ECOrderSnapshotFragment eCOrderSnapshotFragment = ECOrderSnapshotFragment.this;
            eCOrderSnapshotFragment.Uh(eCOrderSnapshotFragment.scrollY);
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
            FragmentActivity activity = ECOrderSnapshotFragment.this.getActivity();
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
    public static final class e implements View.OnClickListener {
        e() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            FragmentActivity activity = ECOrderSnapshotFragment.this.getActivity();
            if (activity != null) {
                activity.finish();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public ECOrderSnapshotFragment() {
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.tencent.ecommerce.biz.orders.buyerorders.snapshot.ECOrderSnapshotFragment$$special$$inlined$viewModels$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        this.ptsHostViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(a.class), new Function0<ViewModelStore>() { // from class: com.tencent.ecommerce.biz.orders.buyerorders.snapshot.ECOrderSnapshotFragment$$special$$inlined$viewModels$2
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
    }

    public static final /* synthetic */ bh0.b Lh(ECOrderSnapshotFragment eCOrderSnapshotFragment) {
        bh0.b bVar = eCOrderSnapshotFragment.adapter;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        return bVar;
    }

    public static final /* synthetic */ OrderSnapShotData Nh(ECOrderSnapshotFragment eCOrderSnapshotFragment) {
        OrderSnapShotData orderSnapShotData = eCOrderSnapshotFragment.snapShotData;
        if (orderSnapShotData == null) {
            Intrinsics.throwUninitializedPropertyAccessException("snapShotData");
        }
        return orderSnapShotData;
    }

    private final void Sh(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        int i3 = layoutParams.height;
        r rVar = r.f104881b;
        layoutParams.height = i3 + rVar.a(getActivity());
        view.setLayoutParams(layoutParams);
        view.setPadding(view.getPaddingLeft(), rVar.a(getActivity()), view.getPaddingRight(), view.getPaddingBottom());
    }

    private final a Th() {
        return (a) this.ptsHostViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Uh(int scrollY) {
        if (scrollY > 530) {
            View view = this.titleBarBackground;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("titleBarBackground");
            }
            view.setAlpha(1.0f);
            TextView textView = this.titleTextView;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("titleTextView");
            }
            textView.setAlpha(1.0f);
            ImageView imageView = this.blackBackButton;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("blackBackButton");
            }
            imageView.setAlpha(1.0f);
            ImageView imageView2 = this.backButton;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("backButton");
            }
            imageView2.setAlpha(0.0f);
            return;
        }
        float f16 = scrollY / 530;
        View view2 = this.titleBarBackground;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleBarBackground");
        }
        view2.setAlpha(f16);
        TextView textView2 = this.titleTextView;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleTextView");
        }
        textView2.setAlpha(f16);
        ImageView imageView3 = this.blackBackButton;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("blackBackButton");
        }
        imageView3.setAlpha(f16);
        ImageView imageView4 = this.backButton;
        if (imageView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("backButton");
        }
        imageView4.setAlpha(1.0f - f16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<ECBasePtsViewData> Wh(JSONObject data, String productTitle) {
        List<ECBasePtsViewData> emptyList;
        IECPTSProcessor a16 = com.tencent.ecommerce.biz.detail.dataprocessor.processor.b.f102022b.a(ECProductDetailDataParserType.ECOrderSnapshot);
        k kVar = new k(null, 1, null);
        kVar.e(productTitle, 15, "qecommerce_skin_color_text_primary", 2);
        JSONObject optJSONObject = data.optJSONObject("product_info");
        if (optJSONObject != null) {
            optJSONObject.put("nodes", kVar.g());
        }
        List<ECBasePtsViewData> process = a16.process(a16.localPageParserParamsArray(null), data, null);
        if (process != null) {
            return process;
        }
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        return emptyList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Xh(String title, List<com.tencent.ecommerce.biz.orders.buyerorders.snapshot.d> params) {
        ProductParamDescriptionView productParamDescriptionView = new ProductParamDescriptionView(requireContext(), title, params);
        SlidingUpDialog slidingUpDialog = new SlidingUpDialog(requireActivity(), false, 2, null);
        SlidingUpDialog.U(slidingUpDialog, productParamDescriptionView, null, 2, null);
        slidingUpDialog.show();
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x0012, code lost:
    
        if (r1 != null) goto L8;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void initArguments() {
        T t16;
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        Bundle arguments = getArguments();
        if (arguments != null) {
            String string = arguments.getString("key_snapshot_data");
            t16 = string;
        }
        t16 = new JSONObject().toString();
        objectRef.element = t16;
        cg0.a.b("OrderSnapshotFragment", "input data: " + ((String) objectRef.element));
        this.snapShotData = OrderSnapShotData.INSTANCE.a((String) objectRef.element);
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new ECOrderSnapshotFragment$initArguments$1(this, objectRef, null), 3, null);
    }

    private final void initClickListener() {
        Th().Q1(new b());
    }

    private final void initTitleBar() {
        this.titleBarBackground = yh().findViewById(R.id.och);
        this.titleBarParent = yh().findViewById(R.id.nzm);
        this.titleBar = yh().findViewById(R.id.nzl);
        ImageView imageView = (ImageView) yh().findViewById(R.id.nwl);
        this.backButton = imageView;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("backButton");
        }
        imageView.setOnClickListener(new d());
        ImageView imageView2 = (ImageView) yh().findViewById(R.id.nwm);
        this.blackBackButton = imageView2;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("blackBackButton");
        }
        imageView2.setOnClickListener(new e());
        this.titleTextView = (TextView) yh().findViewById(R.id.nwx);
        View view = this.titleBar;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleBar");
        }
        Sh(view);
        View view2 = this.titleBarBackground;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleBarBackground");
        }
        Sh(view2);
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment
    public boolean Eh() {
        return true;
    }

    @Override // com.tencent.ecommerce.base.fragment.api.IECBaseFragment
    /* renamed from: getBusinessDescription */
    public String getTAG() {
        return "OrderSnapshotFragment";
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment
    public int getContentLayoutId() {
        return R.layout.csu;
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        com.tencent.ecommerce.biz.orders.buyerorders.snapshot.c cVar = com.tencent.ecommerce.biz.orders.buyerorders.snapshot.c.f103434a;
        OrderSnapShotData orderSnapShotData = this.snapShotData;
        if (orderSnapShotData == null) {
            Intrinsics.throwUninitializedPropertyAccessException("snapShotData");
        }
        cVar.c(orderSnapShotData.orderInfo.id);
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Vh(view);
        initTitleBar();
        initArguments();
        initClickListener();
    }

    private final void Vh(View view) {
        this.recyclerView = (ECBaseRecyclerView) view.findViewById(R.id.o8n);
        this.adapter = new bh0.b(requireContext(), Th());
        ECBaseRecyclerView eCBaseRecyclerView = this.recyclerView;
        if (eCBaseRecyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        }
        eCBaseRecyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        ECBaseRecyclerView eCBaseRecyclerView2 = this.recyclerView;
        if (eCBaseRecyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        }
        bh0.b bVar = this.adapter;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        eCBaseRecyclerView2.setAdapter(bVar);
        ECBaseRecyclerView eCBaseRecyclerView3 = this.recyclerView;
        if (eCBaseRecyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        }
        eCBaseRecyclerView3.addOnScrollListener(new c());
    }
}
