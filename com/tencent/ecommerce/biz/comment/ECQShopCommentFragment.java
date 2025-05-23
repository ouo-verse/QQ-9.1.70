package com.tencent.ecommerce.biz.comment;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.weishi.WSAutoShowCommentParams;
import com.tencent.ecommerce.base.fragment.ECBaseFragment;
import com.tencent.ecommerce.base.ktx.ImageViewKt;
import com.tencent.ecommerce.base.pageopener.api.imageselector.ECMediaInfo;
import com.tencent.ecommerce.base.ui.api.ECToastIcon;
import com.tencent.ecommerce.base.ui.g;
import com.tencent.ecommerce.base.ui.i;
import com.tencent.ecommerce.base.ui.imagepreviewlist.ECMediaPreviewListPresenter;
import com.tencent.ecommerce.repo.comment.ECQShopOrderCommentInfo;
import com.tencent.ecommerce.repo.comment.ProductInfo;
import com.tencent.ecommerce.repo.comment.TextData;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Job;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 Q2\u00020\u00012\u00020\u0002:\u0002RSB\u0007\u00a2\u0006\u0004\bO\u0010PJ\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u001a\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0005H\u0016J\b\u0010\r\u001a\u00020\tH\u0014J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0010\u001a\u00020\tH\u0016J\b\u0010\u0011\u001a\u00020\u000eH\u0016J\b\u0010\u0012\u001a\u00020\u000eH\u0016J\b\u0010\u0013\u001a\u00020\u000eH\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0016J\b\u0010\u0016\u001a\u00020\tH\u0002J\u0010\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u0005H\u0002J\u0010\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\u001a\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\u001b\u001a\u00020\tH\u0002J\u0010\u0010\u001c\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\u001d\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\u001e\u001a\u00020\tH\u0002R\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010$\u001a\u00020\u001f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b#\u0010!R\u0016\u0010&\u001a\u00020\u001f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b%\u0010!R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00102\u001a\u00020/8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b0\u00101R\u001b\u00108\u001a\u0002038BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u00107R\u0016\u0010;\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010=\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010:R\u0016\u0010?\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010:R\u001c\u0010C\u001a\b\u0012\u0004\u0012\u00020\u00140@8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u0010BR\u0016\u0010G\u001a\u00020D8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bE\u0010FR\u0018\u0010K\u001a\u0004\u0018\u00010H8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bI\u0010JR\u0014\u0010N\u001a\u00020\u000e8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bL\u0010M\u00a8\u0006T"}, d2 = {"Lcom/tencent/ecommerce/biz/comment/ECQShopCommentFragment;", "Lcom/tencent/ecommerce/base/fragment/ECBaseFragment;", "Landroid/view/View$OnClickListener;", "", "getContentLayoutId", "Landroid/view/View;", "view", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "v", NodeProps.ON_CLICK, "Fh", "", "onBackPressed", "onDestroyView", "Bh", "Dh", "Eh", "", "getBusinessDescription", "initArguments", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Uh", "Vh", "Rh", "Xh", "Sh", "Th", "Yh", "Landroid/widget/RatingBar;", "P", "Landroid/widget/RatingBar;", "productRatingBar", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "shippingRatingBar", BdhLogUtil.LogTag.Tag_Req, "shopRatingBar", "Landroid/widget/EditText;", ExifInterface.LATITUDE_SOUTH, "Landroid/widget/EditText;", "commentEditText", "Landroidx/recyclerview/widget/RecyclerView;", "T", "Landroidx/recyclerview/widget/RecyclerView;", "mediaLayout", "Lcom/tencent/ecommerce/base/ui/imagepreviewlist/ECMediaPreviewListPresenter;", "U", "Lcom/tencent/ecommerce/base/ui/imagepreviewlist/ECMediaPreviewListPresenter;", "imagePreviewListAdapter", "Lcom/tencent/ecommerce/biz/comment/ECQShopCommentViewModel;", "V", "Lkotlin/Lazy;", "Qh", "()Lcom/tencent/ecommerce/biz/comment/ECQShopCommentViewModel;", "viewModel", "W", "Ljava/lang/String;", "spuId", "X", "skuId", "Y", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ORDER_ID, "", "Z", "Ljava/util/List;", "productSpecification", "", "a0", "J", "exposeTime", "Landroid/app/Dialog;", "b0", "Landroid/app/Dialog;", "loadingDialog", "Wh", "()Z", "isContentModified", "<init>", "()V", "c0", "a", "b", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECQShopCommentFragment extends ECBaseFragment implements View.OnClickListener {

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: P, reason: from kotlin metadata */
    private RatingBar productRatingBar;

    /* renamed from: Q, reason: from kotlin metadata */
    private RatingBar shippingRatingBar;

    /* renamed from: R, reason: from kotlin metadata */
    private RatingBar shopRatingBar;

    /* renamed from: S, reason: from kotlin metadata */
    private EditText commentEditText;

    /* renamed from: T, reason: from kotlin metadata */
    private RecyclerView mediaLayout;

    /* renamed from: U, reason: from kotlin metadata */
    private ECMediaPreviewListPresenter imagePreviewListAdapter;

    /* renamed from: V, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* renamed from: W, reason: from kotlin metadata */
    private String spuId;

    /* renamed from: X, reason: from kotlin metadata */
    private String skuId;

    /* renamed from: Y, reason: from kotlin metadata */
    private String orderId;

    /* renamed from: Z, reason: from kotlin metadata */
    private List<String> productSpecification;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private long exposeTime;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private Dialog loadingDialog;

    /* compiled from: P */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001e\u0010\u001fJN\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0016\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u00040\nj\b\u0012\u0004\u0012\u00020\u0004`\u000bR\u0014\u0010\u0010\u001a\u00020\u000f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0013\u001a\u00020\u00128\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0014R\u0014\u0010\u0016\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0017R\u0014\u0010\u0019\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0017R\u0014\u0010\u001a\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0017R\u0014\u0010\u001b\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0017R\u0014\u0010\u001c\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u0017R\u0014\u0010\u001d\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u0017\u00a8\u0006 "}, d2 = {"Lcom/tencent/ecommerce/biz/comment/ECQShopCommentFragment$a;", "", "Landroid/content/Context;", "context", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ORDER_ID, "skuId", "spuId", "productTitle", "productCoverUrl", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "productSpecification", "", "a", "", "LIMIT_RATING_MUST_WITH_TEXT", UserInfo.SEX_FEMALE, "", "MAX_SELECTED_PIC_NUM", "I", "MAX_TEXT_LENGTH", "ORDER_ID", "Ljava/lang/String;", "PRODUCT_COVER_URL", "PRODUCT_SPECIFICATION", "PRODUCT_TITLE", "SKU_ID", "SPU_ID", "TAG", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.biz.comment.ECQShopCommentFragment$a, reason: from kotlin metadata */
    /* loaded from: classes31.dex */
    public static final class Companion {
        Companion() {
        }

        public final void a(Context context, String orderId, String skuId, String spuId, String productTitle, String productCoverUrl, ArrayList<String> productSpecification) throws IllegalArgumentException {
            if (!(orderId.length() == 0)) {
                if (!(skuId.length() == 0)) {
                    if (!(spuId.length() == 0)) {
                        Bundle bundle = new Bundle();
                        bundle.putStringArrayList("productSpecification", productSpecification);
                        bundle.putString(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ORDER_ID, orderId);
                        bundle.putString("skuId", skuId);
                        bundle.putString("spuId", spuId);
                        bundle.putString("productTitle", productTitle);
                        bundle.putString("productCoverUrl", productCoverUrl);
                        yi0.a.q(context, ECQShopCommentFragment.class, bundle, 0, null, 24, null);
                        return;
                    }
                }
            }
            throw new IllegalArgumentException("orderId, skuId, spuId must not be empty");
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00060\u0001j\u0002`\u0002B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0005\u00a8\u0006\t"}, d2 = {"Lcom/tencent/ecommerce/biz/comment/ECQShopCommentFragment$b;", "", "Lcom/tencent/ecommerce/base/eventbus/EVENT;", "", "a", "Ljava/lang/String;", WSAutoShowCommentParams.KEY_COMMENT_ID, "<init>", "(Ljava/lang/String;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final String commentId;

        public b(String str) {
            this.commentId = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel", "com/tencent/ecommerce/biz/comment/ECQShopCommentFragment$publishComment$1$1"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class c implements DialogInterface.OnCancelListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Job f101380d;

        c(Job job) {
            this.f101380d = job;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public final void onCancel(DialogInterface dialogInterface) {
            Job.DefaultImpls.cancel$default(this.f101380d, (CancellationException) null, 1, (Object) null);
        }
    }

    public ECQShopCommentFragment() {
        List<String> emptyList;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.tencent.ecommerce.biz.comment.ECQShopCommentFragment$$special$$inlined$viewModels$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(ECQShopCommentViewModel.class), new Function0<ViewModelStore>() { // from class: com.tencent.ecommerce.biz.comment.ECQShopCommentFragment$$special$$inlined$viewModels$2
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
        this.spuId = "";
        this.skuId = "";
        this.orderId = "";
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        this.productSpecification = emptyList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ECQShopCommentViewModel Qh() {
        return (ECQShopCommentViewModel) this.viewModel.getValue();
    }

    private final void Sh(View view) {
        List mutableList;
        ImageSpan imageSpan = new ImageSpan(requireContext(), com.tencent.ecommerce.biz.util.a.f104864a.a(BitmapFactory.decodeResource(getResources(), R.drawable.eea), com.tencent.ecommerce.biz.util.e.c(16.0f), com.tencent.ecommerce.biz.util.e.c(16.0f)));
        SpannableString spannableString = new SpannableString(getResources().getString(R.string.f169629wq3));
        spannableString.setSpan(imageSpan, 0, 1, 17);
        EditText editText = (EditText) view.findViewById(R.id.ntj);
        editText.setHint(spannableString);
        Unit unit = Unit.INSTANCE;
        this.commentEditText = editText;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("commentEditText");
        }
        mutableList = ArraysKt___ArraysKt.toMutableList(editText.getFilters());
        mutableList.add(new e(null, new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.comment.ECQShopCommentFragment$initEditText$$inlined$apply$lambda$1
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
                i.f101155b.d(ECQShopCommentFragment.this.getResources().getString(R.string.weg), ECToastIcon.ICON_DEFAULT, 0);
            }
        }, 1, null));
        mutableList.add(new f(500, new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.comment.ECQShopCommentFragment$initEditText$$inlined$apply$lambda$2
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
                i.f101155b.d(ECQShopCommentFragment.this.getResources().getString(R.string.wq_, 500), ECToastIcon.ICON_DEFAULT, 0);
            }
        }));
        EditText editText2 = this.commentEditText;
        if (editText2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("commentEditText");
        }
        Object[] array = mutableList.toArray(new InputFilter[0]);
        if (array != null) {
            editText2.setFilters((InputFilter[]) array);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    private final void Uh(View rootView) {
        String str;
        String str2;
        String joinToString$default;
        Bundle arguments = getArguments();
        str = "";
        if (arguments == null) {
            str2 = "";
        } else {
            String string = arguments.getString("productTitle");
            if (string == null) {
                string = "";
            }
            String string2 = arguments.getString("productCoverUrl");
            str2 = string2 != null ? string2 : "";
            str = string;
        }
        ImageViewKt.b((ImageView) rootView.findViewById(R.id.o76), str2, com.tencent.ecommerce.biz.util.e.c(60.0f), com.tencent.ecommerce.biz.util.e.c(60.0f), 0, 8, null);
        ((TextView) rootView.findViewById(R.id.o7l)).setText(str);
        TextView textView = (TextView) rootView.findViewById(R.id.f163083o72);
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(this.productSpecification, "\uff1b ", null, null, 0, null, null, 62, null);
        textView.setText(joinToString$default);
    }

    private final boolean Wh() {
        RatingBar ratingBar = this.productRatingBar;
        if (ratingBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("productRatingBar");
        }
        if (((int) ratingBar.getRating()) != 0) {
            return true;
        }
        RatingBar ratingBar2 = this.shippingRatingBar;
        if (ratingBar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shippingRatingBar");
        }
        if (((int) ratingBar2.getRating()) != 0) {
            return true;
        }
        RatingBar ratingBar3 = this.shopRatingBar;
        if (ratingBar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shopRatingBar");
        }
        if (((int) ratingBar3.getRating()) != 0) {
            return true;
        }
        EditText editText = this.commentEditText;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("commentEditText");
        }
        if (editText.getText().length() > 0) {
            return true;
        }
        ECMediaPreviewListPresenter eCMediaPreviewListPresenter = this.imagePreviewListAdapter;
        if (eCMediaPreviewListPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imagePreviewListAdapter");
        }
        return eCMediaPreviewListPresenter.f().isEmpty() ^ true;
    }

    private final void Yh() {
        g gVar = new g(requireContext());
        gVar.Y(getResources().getString(R.string.f169630wq4));
        gVar.e0(new Function1<View, Unit>() { // from class: com.tencent.ecommerce.biz.comment.ECQShopCommentFragment$showBackTipsDialog$$inlined$apply$lambda$1
            /* JADX INFO: Access modifiers changed from: package-private */
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
                ECQShopCommentFragment.this.requireActivity().finish();
            }
        });
        gVar.show();
    }

    private final void initArguments() {
        String string;
        String string2;
        String string3;
        List<String> emptyList;
        Bundle arguments = getArguments();
        if (arguments != null && (string = arguments.getString("spuId")) != null) {
            this.spuId = string;
            Bundle arguments2 = getArguments();
            if (arguments2 != null && (string2 = arguments2.getString("skuId")) != null) {
                this.skuId = string2;
                Bundle arguments3 = getArguments();
                if (arguments3 != null && (string3 = arguments3.getString(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ORDER_ID)) != null) {
                    this.orderId = string3;
                    Bundle arguments4 = getArguments();
                    if (arguments4 == null || (emptyList = arguments4.getStringArrayList("productSpecification")) == null) {
                        emptyList = CollectionsKt__CollectionsKt.emptyList();
                    }
                    this.productSpecification = emptyList;
                    return;
                }
                throw new IllegalArgumentException("\u53c2\u6570\u4f20\u9012");
            }
            throw new IllegalArgumentException("\u53c2\u6570\u4f20\u9012");
        }
        throw new IllegalArgumentException("\u53c2\u6570\u4f20\u9012");
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
        if (Wh()) {
            Yh();
        } else {
            requireActivity().finish();
        }
    }

    @Override // com.tencent.ecommerce.base.fragment.api.IECBaseFragment
    /* renamed from: getBusinessDescription */
    public String getTAG() {
        return "ECQShopCommentFragment";
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment
    public int getContentLayoutId() {
        return R.layout.cti;
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, com.tencent.ecommerce.base.ui.api.IECFragmentApi
    public boolean onBackPressed() {
        super.onBackPressed();
        if (!Wh()) {
            return false;
        }
        Yh();
        return true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        if (v3.getId() == R.id.ntq) {
            Xh();
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        d.f101425a.c(this.orderId, this.spuId, this.skuId, System.currentTimeMillis() - this.exposeTime);
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initArguments();
        Uh(view);
        Sh(view);
        Th(view);
        Vh(view);
        Rh(view);
        setTitle("\u53d1\u8868\u8bc4\u4ef7");
        this.exposeTime = System.currentTimeMillis();
        d.f101425a.d(this.orderId, this.spuId, this.skuId);
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x0094, code lost:
    
        if (java.lang.Float.compare(r0.getRating(), 2.0f) <= 0) goto L38;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void Xh() {
        List listOf;
        List emptyList;
        Job launch$default;
        RatingBar ratingBar = this.productRatingBar;
        if (ratingBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("productRatingBar");
        }
        if (((int) ratingBar.getRating()) == 0) {
            i.e(i.f101155b, R.string.wq6, null, 0, 6, null);
            return;
        }
        RatingBar ratingBar2 = this.shippingRatingBar;
        if (ratingBar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shippingRatingBar");
        }
        if (((int) ratingBar2.getRating()) == 0) {
            i.e(i.f101155b, R.string.wq7, null, 0, 6, null);
            return;
        }
        RatingBar ratingBar3 = this.shopRatingBar;
        if (ratingBar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shopRatingBar");
        }
        if (((int) ratingBar3.getRating()) == 0) {
            i.e(i.f101155b, R.string.wq8, null, 0, 6, null);
            return;
        }
        RatingBar ratingBar4 = this.productRatingBar;
        if (ratingBar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("productRatingBar");
        }
        if (Float.compare(ratingBar4.getRating(), 2.0f) > 0) {
            RatingBar ratingBar5 = this.shippingRatingBar;
            if (ratingBar5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("shippingRatingBar");
            }
            if (Float.compare(ratingBar5.getRating(), 2.0f) > 0) {
                RatingBar ratingBar6 = this.shopRatingBar;
                if (ratingBar6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("shopRatingBar");
                }
            }
        }
        EditText editText = this.commentEditText;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("commentEditText");
        }
        Editable text = editText.getText();
        if (text == null || text.length() == 0) {
            i.f101155b.c(R.string.wq5, ECToastIcon.ICON_DEFAULT, 0);
            return;
        }
        ProductInfo productInfo = new ProductInfo(this.spuId, this.skuId);
        String str = this.orderId;
        EditText editText2 = this.commentEditText;
        if (editText2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("commentEditText");
        }
        listOf = CollectionsKt__CollectionsJVMKt.listOf(new TextData(editText2.getText().toString()));
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        List<String> list = this.productSpecification;
        RatingBar ratingBar7 = this.productRatingBar;
        if (ratingBar7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("productRatingBar");
        }
        float rating = ratingBar7.getRating();
        RatingBar ratingBar8 = this.shippingRatingBar;
        if (ratingBar8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shippingRatingBar");
        }
        float rating2 = ratingBar8.getRating();
        RatingBar ratingBar9 = this.shopRatingBar;
        if (ratingBar9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shopRatingBar");
        }
        launch$default = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new ECQShopCommentFragment$publishComment$$inlined$launchAndRepeatWithViewLifecycle$1(this, Lifecycle.State.STARTED, null, this, new ECQShopOrderCommentInfo(productInfo, str, listOf, emptyList, list, rating, rating2, ratingBar9.getRating())), 3, null);
        com.tencent.ecommerce.base.ui.d dVar = new com.tencent.ecommerce.base.ui.d(requireContext(), getResources().getString(R.string.wqh));
        dVar.setOnCancelListener(new c(launch$default));
        dVar.show();
        Unit unit = Unit.INSTANCE;
        this.loadingDialog = dVar;
        d dVar2 = d.f101425a;
        String str2 = this.orderId;
        String str3 = this.spuId;
        String str4 = this.skuId;
        RatingBar ratingBar10 = this.productRatingBar;
        if (ratingBar10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("productRatingBar");
        }
        int rating3 = (int) ratingBar10.getRating();
        RatingBar ratingBar11 = this.shippingRatingBar;
        if (ratingBar11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shippingRatingBar");
        }
        int rating4 = (int) ratingBar11.getRating();
        RatingBar ratingBar12 = this.shopRatingBar;
        if (ratingBar12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shopRatingBar");
        }
        int rating5 = (int) ratingBar12.getRating();
        ECMediaPreviewListPresenter eCMediaPreviewListPresenter = this.imagePreviewListAdapter;
        if (eCMediaPreviewListPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imagePreviewListAdapter");
        }
        int size = eCMediaPreviewListPresenter.f().size();
        EditText editText3 = this.commentEditText;
        if (editText3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("commentEditText");
        }
        dVar2.b(str2, str3, str4, rating3, rating4, rating5, size, editText3.getText().length() > 0);
    }

    private final void Rh(View view) {
        view.findViewById(R.id.ntq).setOnClickListener(this);
    }

    private final void Th(View view) {
        this.mediaLayout = (RecyclerView) view.findViewById(R.id.ntk);
        FragmentActivity requireActivity = requireActivity();
        RecyclerView recyclerView = this.mediaLayout;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mediaLayout");
        }
        this.imagePreviewListAdapter = new ECMediaPreviewListPresenter(requireActivity, 9, recyclerView, requireActivity().getString(R.string.whf), new Function1<List<? extends ECMediaInfo>, Unit>() { // from class: com.tencent.ecommerce.biz.comment.ECQShopCommentFragment$initMediaSelector$1
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
                ECQShopCommentViewModel Qh;
                Qh = ECQShopCommentFragment.this.Qh();
                Qh.N1(list);
            }
        });
    }

    private final void Vh(View view) {
        this.productRatingBar = (RatingBar) view.findViewById(R.id.ntl);
        this.shippingRatingBar = (RatingBar) view.findViewById(R.id.ntn);
        this.shopRatingBar = (RatingBar) view.findViewById(R.id.nto);
    }
}
