package com.tencent.ecommerce.biz.applysample;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.helper.widget.Flow;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.os.BundleKt;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ecommerce.base.fragment.ECBaseFragment;
import com.tencent.ecommerce.base.ktx.ImageViewKt;
import com.tencent.ecommerce.base.list.IStateCenterView;
import com.tencent.ecommerce.base.pageopener.api.imageselector.ECMediaInfo;
import com.tencent.ecommerce.base.ui.ECFormRowItem;
import com.tencent.ecommerce.base.ui.ECSelectionListDialog;
import com.tencent.ecommerce.base.ui.api.ECToastIcon;
import com.tencent.ecommerce.base.ui.g;
import com.tencent.ecommerce.base.ui.i;
import com.tencent.ecommerce.base.ui.imagepreviewlist.ECMediaPreviewListPresenter;
import com.tencent.ecommerce.base.ui.stateview.ECStateCenterView;
import com.tencent.ecommerce.biz.applysample.ECAbortFulfillOrderViewModel;
import com.tencent.ecommerce.biz.applysample.a;
import com.tencent.ecommerce.biz.comment.f;
import com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.viewholder.j;
import com.tencent.ecommerce.biz.util.e;
import com.tencent.ecommerce.repo.aftersale.apply.ECAfterSaleApplyOptionInfo;
import com.tencent.ecommerce.repo.aftersale.apply.OptionValue;
import com.tencent.ecommerce.repo.aftersale.common.ECAfterSaleProductCard;
import com.tencent.ecommerce.repo.aftersale.common.ECAfterSaleServiceInfo;
import com.tencent.ecommerce.repo.sampleorder.ECAbortFulfillOption;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 W2\u00020\u00012\u00020\u0002:\u0001XB\u0007\u00a2\u0006\u0004\bU\u0010VJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0003H\u0002J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\tH\u0002J\u0016\u0010\u000f\u001a\u00020\u00032\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0002J\b\u0010\u0010\u001a\u00020\u0003H\u0002J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\rH\u0002J\b\u0010\u0013\u001a\u00020\u0003H\u0002J\f\u0010\u0016\u001a\u00020\u0015*\u00020\u0014H\u0002J\u001a\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\u001b\u001a\u00020\u001aH\u0016J\b\u0010\u001c\u001a\u00020\rH\u0016J\b\u0010\u001e\u001a\u00020\u001dH\u0016J\b\u0010\u001f\u001a\u00020\u001dH\u0016J\b\u0010 \u001a\u00020\u001dH\u0016J\u0012\u0010!\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016R\u001b\u0010'\u001a\u00020\"8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00101\u001a\u00020(8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b0\u0010*R\u0016\u00103\u001a\u00020,8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b2\u0010.R\u0016\u00105\u001a\u00020,8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b4\u0010.R\u0016\u00109\u001a\u0002068\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010;\u001a\u00020,8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b:\u0010.R\u0016\u0010=\u001a\u00020,8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b<\u0010.R\u0016\u0010A\u001a\u00020>8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010E\u001a\u00020B8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bC\u0010DR\u0016\u0010I\u001a\u00020F8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bG\u0010HR\u0016\u0010M\u001a\u00020J8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bK\u0010LR\u0016\u0010Q\u001a\u00020N8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bO\u0010PR\u0016\u0010T\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bR\u0010S\u00a8\u0006Y"}, d2 = {"Lcom/tencent/ecommerce/biz/applysample/ECAbortFulfillOrderFragment;", "Lcom/tencent/ecommerce/base/fragment/ECBaseFragment;", "Landroid/view/View$OnClickListener;", "", "initArguments", "Landroid/view/View;", "view", "initView", "initData", "Lcom/tencent/ecommerce/repo/aftersale/common/ECAfterSaleProductCard;", "product", "Wh", "", "", "logisticsPolicy", "Sh", "Yh", "phone", "Vh", "Uh", "Lcom/tencent/ecommerce/repo/sampleorder/a;", "Lcom/tencent/ecommerce/biz/applysample/a$a;", "Xh", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "", "getContentLayoutId", "getBusinessDescription", "", "Eh", "Dh", "Bh", NodeProps.ON_CLICK, "Lcom/tencent/ecommerce/biz/applysample/ECAbortFulfillOrderViewModel;", "P", "Lkotlin/Lazy;", "Th", "()Lcom/tencent/ecommerce/biz/applysample/ECAbortFulfillOrderViewModel;", "viewModel", "Landroid/widget/ImageView;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Landroid/widget/ImageView;", "shopCover", "Landroid/widget/TextView;", BdhLogUtil.LogTag.Tag_Req, "Landroid/widget/TextView;", "shopName", ExifInterface.LATITUDE_SOUTH, "productCover", "T", "productName", "U", "specifications", "Landroidx/constraintlayout/widget/ConstraintLayout;", "V", "Landroidx/constraintlayout/widget/ConstraintLayout;", "logisticsContainer", "W", "unitPriceTv", "X", "quantityTv", "Lcom/tencent/ecommerce/base/ui/ECFormRowItem;", "Y", "Lcom/tencent/ecommerce/base/ui/ECFormRowItem;", "formRowItem", "Landroid/widget/Button;", "Z", "Landroid/widget/Button;", "operationBtn", "Landroid/widget/EditText;", "a0", "Landroid/widget/EditText;", "extraSupplement", "Lcom/tencent/ecommerce/base/ui/stateview/ECStateCenterView;", "b0", "Lcom/tencent/ecommerce/base/ui/stateview/ECStateCenterView;", "stateView", "Lcom/tencent/ecommerce/base/ui/imagepreviewlist/ECMediaPreviewListPresenter;", "c0", "Lcom/tencent/ecommerce/base/ui/imagepreviewlist/ECMediaPreviewListPresenter;", "mediaPreviewListPresenter", "d0", "Ljava/lang/String;", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ORDER_ID, "<init>", "()V", "e0", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECAbortFulfillOrderFragment extends ECBaseFragment implements View.OnClickListener {

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: P, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* renamed from: Q, reason: from kotlin metadata */
    private ImageView shopCover;

    /* renamed from: R, reason: from kotlin metadata */
    private TextView shopName;

    /* renamed from: S, reason: from kotlin metadata */
    private ImageView productCover;

    /* renamed from: T, reason: from kotlin metadata */
    private TextView productName;

    /* renamed from: U, reason: from kotlin metadata */
    private TextView specifications;

    /* renamed from: V, reason: from kotlin metadata */
    private ConstraintLayout logisticsContainer;

    /* renamed from: W, reason: from kotlin metadata */
    private TextView unitPriceTv;

    /* renamed from: X, reason: from kotlin metadata */
    private TextView quantityTv;

    /* renamed from: Y, reason: from kotlin metadata */
    private ECFormRowItem formRowItem;

    /* renamed from: Z, reason: from kotlin metadata */
    private Button operationBtn;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private EditText extraSupplement;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private ECStateCenterView stateView;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    private ECMediaPreviewListPresenter mediaPreviewListPresenter;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    private String orderId;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006R\u0014\u0010\n\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\rR\u0014\u0010\u000f\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u000bR\u0014\u0010\u0010\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000b\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/ecommerce/biz/applysample/ECAbortFulfillOrderFragment$a;", "", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ORDER_ID, "", "requestCode", "", "a", "ABORT_APPLY_SAMPLE_RESULT", "Ljava/lang/String;", "MAX_TEXT_LENGTH", "I", "MAX_UPLOAD_IMG", "ORDER_ID", "TAG", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.biz.applysample.ECAbortFulfillOrderFragment$a, reason: from kotlin metadata */
    /* loaded from: classes31.dex */
    public static final class Companion {
        Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(Activity activity, String orderId, int requestCode) {
            yi0.a.q(activity, ECAbortFulfillOrderFragment.class, BundleKt.bundleOf(TuplesKt.to("order_id", orderId)), requestCode, null, 16, null);
        }
    }

    public ECAbortFulfillOrderFragment() {
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.tencent.ecommerce.biz.applysample.ECAbortFulfillOrderFragment$$special$$inlined$viewModels$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(ECAbortFulfillOrderViewModel.class), new Function0<ViewModelStore>() { // from class: com.tencent.ecommerce.biz.applysample.ECAbortFulfillOrderFragment$$special$$inlined$viewModels$2
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
        this.orderId = "";
    }

    public static final /* synthetic */ EditText Lh(ECAbortFulfillOrderFragment eCAbortFulfillOrderFragment) {
        EditText editText = eCAbortFulfillOrderFragment.extraSupplement;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("extraSupplement");
        }
        return editText;
    }

    public static final /* synthetic */ ECFormRowItem Mh(ECAbortFulfillOrderFragment eCAbortFulfillOrderFragment) {
        ECFormRowItem eCFormRowItem = eCAbortFulfillOrderFragment.formRowItem;
        if (eCFormRowItem == null) {
            Intrinsics.throwUninitializedPropertyAccessException("formRowItem");
        }
        return eCFormRowItem;
    }

    public static final /* synthetic */ ECStateCenterView Oh(ECAbortFulfillOrderFragment eCAbortFulfillOrderFragment) {
        ECStateCenterView eCStateCenterView = eCAbortFulfillOrderFragment.stateView;
        if (eCStateCenterView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stateView");
        }
        return eCStateCenterView;
    }

    private final void Sh(List<String> logisticsPolicy) {
        Flow flow = new Flow(requireContext());
        flow.setLayoutParams(new ConstraintLayout.LayoutParams(0, -2));
        flow.setOrientation(0);
        flow.setHorizontalGap(e.c(8.0f));
        flow.setVerticalGap(e.c(4.0f));
        flow.setWrapMode(1);
        flow.setHorizontalStyle(2);
        flow.setHorizontalBias(0.0f);
        ConstraintLayout constraintLayout = this.logisticsContainer;
        if (constraintLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("logisticsContainer");
        }
        constraintLayout.addView(flow);
        for (String str : logisticsPolicy) {
            j jVar = j.f103370a;
            ConstraintLayout constraintLayout2 = this.logisticsContainer;
            if (constraintLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("logisticsContainer");
            }
            View a16 = jVar.a(constraintLayout2.getContext(), str);
            ConstraintLayout constraintLayout3 = this.logisticsContainer;
            if (constraintLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("logisticsContainer");
            }
            constraintLayout3.addView(a16);
            flow.addView(a16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ECAbortFulfillOrderViewModel Th() {
        return (ECAbortFulfillOrderViewModel) this.viewModel.getValue();
    }

    private final void Uh() {
        int collectionSizeOrDefault;
        ECAbortFulfillOrderViewModel.a value = Th().O1().getValue();
        if (value != null) {
            final ECAfterSaleApplyOptionInfo optionInfo = ((ECAbortFulfillOrderViewModel.a.c) value).data.getOptionInfo();
            List<OptionValue> d16 = optionInfo.d();
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(d16, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            Iterator<T> it = d16.iterator();
            while (it.hasNext()) {
                arrayList.add(((OptionValue) it.next()).getText());
            }
            String str = "\u9009\u62e9" + optionInfo.getKeyText();
            OptionValue value2 = Th().N1().getValue();
            new ECSelectionListDialog(str, arrayList, value2 != null ? value2.getText() : null).uh(getChildFragmentManager(), new Function1<ECSelectionListDialog.SelectionListDialogResult, Unit>() { // from class: com.tencent.ecommerce.biz.applysample.ECAbortFulfillOrderFragment$showAbortFullfillOrderReasonDialog$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(ECSelectionListDialog.SelectionListDialogResult selectionListDialogResult) {
                    invoke2(selectionListDialogResult);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(ECSelectionListDialog.SelectionListDialogResult selectionListDialogResult) {
                    ECAbortFulfillOrderViewModel Th;
                    if (Intrinsics.areEqual(selectionListDialogResult, ECSelectionListDialog.SelectionListDialogResult.Cancel.f101115d)) {
                        cg0.a.b("ECAbortFulfillOrderFragment", "onOptionClick result Cancel");
                    } else if (selectionListDialogResult instanceof ECSelectionListDialog.SelectionListDialogResult.SelectedResult) {
                        Th = ECAbortFulfillOrderFragment.this.Th();
                        Th.R1(optionInfo.d().get(((ECSelectionListDialog.SelectionListDialogResult.SelectedResult) selectionListDialogResult).selectedIndex));
                    }
                }
            });
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.tencent.ecommerce.biz.applysample.ECAbortFulfillOrderViewModel.State.SUCCESS");
    }

    private final void Vh(String phone) {
        g gVar = new g(requireContext());
        gVar.setTitle(requireContext().getString(R.string.wiq));
        gVar.Y(phone);
        gVar.b0("");
        gVar.f0(requireContext().getString(R.string.wo7));
        gVar.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Wh(ECAfterSaleProductCard product) {
        int collectionSizeOrDefault;
        ImageView imageView = this.shopCover;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shopCover");
        }
        ImageViewKt.b(imageView, product.shopInfo.shopImg, 0, 0, 0, 14, null);
        TextView textView = this.shopName;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shopName");
        }
        textView.setText(product.shopInfo.shopName);
        ImageView imageView2 = this.productCover;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("productCover");
        }
        ImageViewKt.b(imageView2, product.cover, 0, 0, 0, 14, null);
        TextView textView2 = this.productName;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("productName");
        }
        textView2.setText(product.productTitle);
        TextView textView3 = this.specifications;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("specifications");
        }
        textView3.setText(product.specification);
        TextView textView4 = this.unitPriceTv;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("unitPriceTv");
        }
        textView4.setText('\u00a5' + product.productPrice);
        TextView textView5 = this.quantityTv;
        if (textView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("quantityTv");
        }
        textView5.setText("\u00d7 " + product.productNumber);
        Button button = this.operationBtn;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException("operationBtn");
        }
        button.setVisibility(product.shopInfo.getMobile().length() > 0 ? 0 : 8);
        List<ECAfterSaleServiceInfo> a16 = product.a();
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(a16, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = a16.iterator();
        while (it.hasNext()) {
            arrayList.add(((ECAfterSaleServiceInfo) it.next()).title);
        }
        Sh(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final a.ProductData Xh(ECAbortFulfillOption eCAbortFulfillOption) {
        String str = this.orderId;
        ECAfterSaleProductCard eCAfterSaleProductCard = eCAbortFulfillOption.productCard;
        return new a.ProductData(eCAfterSaleProductCard.shopInfo.shopId, str, eCAfterSaleProductCard.spuId, eCAfterSaleProductCard.skuId, eCAfterSaleProductCard.productTitle, eCAfterSaleProductCard.firstCategoryId);
    }

    private final void Yh() {
        ECAbortFulfillOption eCAbortFulfillOption;
        final OptionValue value = Th().N1().getValue();
        if (value == null) {
            i.e(i.f101155b, R.string.whb, null, 0, 6, null);
            return;
        }
        g gVar = new g(requireContext());
        gVar.Y(requireContext().getString(R.string.wi7));
        gVar.e0(new ECAbortFulfillOrderFragment$tryAbortFulfillOrder$$inlined$apply$lambda$1(this, value));
        gVar.a0(new Function1<View, Unit>() { // from class: com.tencent.ecommerce.biz.applysample.ECAbortFulfillOrderFragment$tryAbortFulfillOrder$$inlined$apply$lambda$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(View view) {
                String str;
                a aVar = a.f101341a;
                str = ECAbortFulfillOrderFragment.this.orderId;
                aVar.a(str, false);
            }
        });
        gVar.show();
        ECAbortFulfillOrderViewModel.a value2 = Th().O1().getValue();
        if (!(value2 instanceof ECAbortFulfillOrderViewModel.a.c)) {
            value2 = null;
        }
        ECAbortFulfillOrderViewModel.a.c cVar = (ECAbortFulfillOrderViewModel.a.c) value2;
        if (cVar == null || (eCAbortFulfillOption = cVar.data) == null) {
            return;
        }
        a aVar = a.f101341a;
        a.ProductData Xh = Xh(eCAbortFulfillOption);
        int value3 = value.getValue();
        EditText editText = this.extraSupplement;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("extraSupplement");
        }
        String obj = editText.getText().toString();
        if (this.mediaPreviewListPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mediaPreviewListPresenter");
        }
        aVar.c(Xh, value3, obj, !r4.f().isEmpty());
    }

    private final void initArguments() {
        String str;
        Bundle arguments = getArguments();
        if (arguments == null || (str = arguments.getString("order_id")) == null) {
            str = "";
        }
        this.orderId = str;
    }

    private final void initData() {
        Lifecycle.State state = Lifecycle.State.STARTED;
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new ECAbortFulfillOrderFragment$initData$$inlined$launchAndRepeatWithViewLifecycle$1(this, state, null, this), 3, null);
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new ECAbortFulfillOrderFragment$initData$$inlined$launchAndRepeatWithViewLifecycle$2(this, state, null, this), 3, null);
        Th().Q1(this.orderId);
    }

    private final void initView(View view) {
        List mutableList;
        setTitle(requireContext().getString(R.string.f169591wh1));
        this.shopCover = (ImageView) view.findViewById(R.id.oa5);
        this.shopName = (TextView) view.findViewById(R.id.oad);
        this.productCover = (ImageView) view.findViewById(R.id.o0g);
        this.productName = (TextView) view.findViewById(R.id.o0i);
        this.specifications = (TextView) view.findViewById(R.id.o0k);
        this.logisticsContainer = (ConstraintLayout) view.findViewById(R.id.o0h);
        this.unitPriceTv = (TextView) view.findViewById(R.id.oey);
        this.quantityTv = (TextView) view.findViewById(R.id.o8h);
        Button button = (Button) view.findViewById(R.id.o0j);
        button.setText(button.getContext().getString(R.string.wip));
        button.setOnClickListener(this);
        Unit unit = Unit.INSTANCE;
        this.operationBtn = button;
        this.formRowItem = (ECFormRowItem) view.findViewById(R.id.nt8);
        ((TextView) view.findViewById(R.id.nv7)).setText(requireContext().getString(R.string.wfm, requireContext().getString(R.string.f169613wl4)));
        ((TextView) view.findViewById(R.id.o7x)).setText(requireContext().getString(R.string.wfx, requireContext().getString(R.string.f169613wl4)));
        final EditText editText = (EditText) view.findViewById(R.id.nv8);
        mutableList = ArraysKt___ArraysKt.toMutableList(editText.getFilters());
        CollectionsKt__MutableCollectionsKt.removeAll(mutableList, (Function1) new Function1<InputFilter, Boolean>() { // from class: com.tencent.ecommerce.biz.applysample.ECAbortFulfillOrderFragment$initView$1$2$inputFilters$1$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Boolean invoke(InputFilter inputFilter) {
                return Boolean.valueOf(invoke2(inputFilter));
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final boolean invoke2(InputFilter inputFilter) {
                return inputFilter instanceof InputFilter.LengthFilter;
            }
        });
        mutableList.add(new f(200, new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.applysample.ECAbortFulfillOrderFragment$$special$$inlined$apply$lambda$1
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
                i.f101155b.d(editText.getResources().getString(R.string.wtz, 200), ECToastIcon.ICON_DEFAULT, 0);
            }
        }));
        Object[] array = mutableList.toArray(new InputFilter[0]);
        if (array != null) {
            editText.setFilters((InputFilter[]) array);
            this.extraSupplement = editText;
            ECStateCenterView eCStateCenterView = (ECStateCenterView) view.findViewById(R.id.f163103ob2);
            eCStateCenterView.setRetryListener(new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.applysample.ECAbortFulfillOrderFragment$initView$$inlined$with$lambda$1
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
                    ECAbortFulfillOrderViewModel Th;
                    String str;
                    IStateCenterView.a.c(ECAbortFulfillOrderFragment.Oh(ECAbortFulfillOrderFragment.this), null, 1, null);
                    Th = ECAbortFulfillOrderFragment.this.Th();
                    str = ECAbortFulfillOrderFragment.this.orderId;
                    Th.Q1(str);
                }
            });
            this.stateView = eCStateCenterView;
            view.findViewById(R.id.oa6).setOnClickListener(this);
            view.findViewById(R.id.nt8).setOnClickListener(this);
            view.findViewById(R.id.obb).setOnClickListener(this);
            this.mediaPreviewListPresenter = new ECMediaPreviewListPresenter(requireContext(), 3, (RecyclerView) view.findViewById(R.id.o7w), requireContext().getString(R.string.wud), new Function1<List<? extends ECMediaInfo>, Unit>() { // from class: com.tencent.ecommerce.biz.applysample.ECAbortFulfillOrderFragment$initView$$inlined$with$lambda$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(List<? extends ECMediaInfo> list) {
                    invoke2((List<ECMediaInfo>) list);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(List<ECMediaInfo> list) {
                    ECAbortFulfillOrderViewModel Th;
                    Th = ECAbortFulfillOrderFragment.this.Th();
                    Th.S1(list);
                }
            });
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
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
        return "ECAbortFulfillOrderFragment";
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment
    public int getContentLayoutId() {
        return R.layout.f167323cp1;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Map mapOf;
        EventCollector.getInstance().onViewClickedBefore(view);
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        if (valueOf != null && valueOf.intValue() == R.id.o0j) {
            ECAbortFulfillOrderViewModel.a value = Th().O1().getValue();
            if (value != null) {
                String mobile = ((ECAbortFulfillOrderViewModel.a.c) value).data.productCard.shopInfo.getMobile();
                if (!(mobile.length() == 0)) {
                    Vh(mobile);
                }
            } else {
                throw new NullPointerException("null cannot be cast to non-null type com.tencent.ecommerce.biz.applysample.ECAbortFulfillOrderViewModel.State.SUCCESS");
            }
        } else if (valueOf != null && valueOf.intValue() == R.id.oa6) {
            ECAbortFulfillOrderViewModel.a value2 = Th().O1().getValue();
            if (value2 != null) {
                String str = ((ECAbortFulfillOrderViewModel.a.c) value2).data.productCard.shopInfo.shopId;
                Uri parse = Uri.parse(String.valueOf(21));
                mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("shop_id", str));
                yi0.a.t(parse, mapOf, null, null, 12, null);
            } else {
                throw new NullPointerException("null cannot be cast to non-null type com.tencent.ecommerce.biz.applysample.ECAbortFulfillOrderViewModel.State.SUCCESS");
            }
        } else if (valueOf != null && valueOf.intValue() == R.id.nt8) {
            Uh();
        } else if (valueOf != null && valueOf.intValue() == R.id.obb) {
            Yh();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initArguments();
        initView(view);
        initData();
    }
}
