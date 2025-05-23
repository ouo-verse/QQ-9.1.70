package com.tencent.ecommerce.biz.comment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.bugly.common.reporter.builder.ReportDataBuilder;
import com.tencent.ecommerce.base.fragment.ECBaseFragment;
import com.tencent.ecommerce.base.router.api.IECSchemeCallback;
import com.tencent.ecommerce.base.ui.ECBasePtsView;
import com.tencent.ecommerce.base.ui.ECBasePtsViewData;
import com.tencent.ecommerce.base.ui.ECBaseViewController;
import com.tencent.ecommerce.base.ui.api.ECToastIcon;
import com.tencent.ecommerce.base.ui.i;
import com.tencent.ecommerce.biz.util.h;
import com.tencent.ecommerce.biz.util.r;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.minigame.publicaccount.hippy.MiniGamePAHippyBaseFragment;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000b\u0018\u0000 M2\u00020\u00012\u00020\u0002:\u0001NB\u0007\u00a2\u0006\u0004\bK\u0010LJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\t\u001a\u00020\u0005H\u0002J\b\u0010\n\u001a\u00020\u0005H\u0002J\b\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\r\u001a\u00020\u0005H\u0016J\u0012\u0010\u0010\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\u001a\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u0013\u001a\u00020\u000bH\u0016J\b\u0010\u0014\u001a\u00020\u0005H\u0016J\u0010\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0003H\u0017J\b\u0010\u0018\u001a\u00020\u0017H\u0016R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001e\u001a\u00020\u00198\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001bR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00102\u001a\u00020/8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0016\u00106\u001a\u0002038\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0016\u00109\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010=\u001a\u00020:8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u001b\u0010C\u001a\u00020>8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b?\u0010@\u001a\u0004\bA\u0010BR\u0014\u0010F\u001a\u00020D8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bE\u0010?R\u0016\u0010H\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u00108R\u0016\u0010J\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bI\u00108\u00a8\u0006O"}, d2 = {"Lcom/tencent/ecommerce/biz/comment/ECBuyerOrderCommentFragment;", "Lcom/tencent/ecommerce/base/fragment/ECBaseFragment;", "Landroid/view/View$OnClickListener;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "Rh", "Sh", "Th", "showSuccessToast", "Uh", "", "uh", "onResume", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "getContentLayoutId", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "v", NodeProps.ON_CLICK, "", "getBusinessDescription", "Landroid/widget/TextView;", "P", "Landroid/widget/TextView;", "titleTv", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "ratingBarTv", "Landroid/widget/Button;", BdhLogUtil.LogTag.Tag_Req, "Landroid/widget/Button;", "submitCommentBtn", "Landroid/widget/ImageView;", ExifInterface.LATITUDE_SOUTH, "Landroid/widget/ImageView;", "backIcon", "Landroid/widget/RatingBar;", "T", "Landroid/widget/RatingBar;", "ratingBar", "Lcom/tencent/ecommerce/base/ui/b;", "U", "Lcom/tencent/ecommerce/base/ui/b;", "commentDataPts", "Lcom/tencent/ecommerce/base/ui/ECBaseViewController;", "V", "Lcom/tencent/ecommerce/base/ui/ECBaseViewController;", "commentController", "Lcom/tencent/ecommerce/base/ui/ECBasePtsView;", "W", "Lcom/tencent/ecommerce/base/ui/ECBasePtsView;", "basePtsView", "X", "Ljava/lang/String;", "productInfoData", "Lorg/json/JSONObject;", "Y", "Lorg/json/JSONObject;", "productInfoJOSN", "Lcom/tencent/ecommerce/biz/comment/b;", "Z", "Lkotlin/Lazy;", "Qh", "()Lcom/tencent/ecommerce/biz/comment/b;", "commentViewModel", "", "a0", MiniGamePAHippyBaseFragment.KEY_THEME, "b0", WadlProxyConsts.CHANNEL, "c0", "callbackId", "<init>", "()V", "d0", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECBuyerOrderCommentFragment extends ECBaseFragment implements View.OnClickListener {

    /* renamed from: P, reason: from kotlin metadata */
    private TextView titleTv;

    /* renamed from: Q, reason: from kotlin metadata */
    private TextView ratingBarTv;

    /* renamed from: R, reason: from kotlin metadata */
    private Button submitCommentBtn;

    /* renamed from: S, reason: from kotlin metadata */
    private ImageView backIcon;

    /* renamed from: T, reason: from kotlin metadata */
    private RatingBar ratingBar;

    /* renamed from: U, reason: from kotlin metadata */
    private ECBasePtsViewData commentDataPts;

    /* renamed from: V, reason: from kotlin metadata */
    private ECBaseViewController commentController;

    /* renamed from: W, reason: from kotlin metadata */
    private ECBasePtsView basePtsView;

    /* renamed from: X, reason: from kotlin metadata */
    private String productInfoData = "";

    /* renamed from: Y, reason: from kotlin metadata */
    private JSONObject productInfoJOSN = new JSONObject();

    /* renamed from: Z, reason: from kotlin metadata */
    private final Lazy commentViewModel;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private final boolean isNightMode;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private String channel;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    private String callbackId;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "it", "", "a", "(Ljava/lang/Boolean;)V"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class b<T> implements Observer<Boolean> {
        b() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(Boolean bool) {
            if (bool.booleanValue()) {
                ECBuyerOrderCommentFragment.this.showSuccessToast();
                ECBuyerOrderCommentFragment.this.requireActivity().finish();
                IECSchemeCallback b16 = ug0.a.b(ECBuyerOrderCommentFragment.this.callbackId);
                if (b16 != null) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("is_comment_success", true);
                    Unit unit = Unit.INSTANCE;
                    b16.onCallbackFinished(jSONObject);
                    return;
                }
                return;
            }
            ECBuyerOrderCommentFragment.this.Uh();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\n\u00a2\u0006\u0002\b\b"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/widget/RatingBar;", "rating", "", "<anonymous parameter 2>", "", "onRatingChanged"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class c implements RatingBar.OnRatingBarChangeListener {
        c() {
        }

        @Override // android.widget.RatingBar.OnRatingBarChangeListener
        public final void onRatingChanged(RatingBar ratingBar, float f16, boolean z16) {
            ECBuyerOrderCommentFragment eCBuyerOrderCommentFragment = ECBuyerOrderCommentFragment.this;
            ECBuyerOrderCommentFragment.Nh(eCBuyerOrderCommentFragment).setRating(f16);
            eCBuyerOrderCommentFragment.Qh().P1((int) f16);
        }
    }

    public ECBuyerOrderCommentFragment() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.ecommerce.biz.comment.b>() { // from class: com.tencent.ecommerce.biz.comment.ECBuyerOrderCommentFragment$commentViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final b invoke() {
                return (b) new ViewModelProvider(ECBuyerOrderCommentFragment.this).get(b.class);
            }
        });
        this.commentViewModel = lazy;
        this.isNightMode = fg0.a.f398587b.a();
        this.channel = "";
        this.callbackId = "";
    }

    public static final /* synthetic */ RatingBar Nh(ECBuyerOrderCommentFragment eCBuyerOrderCommentFragment) {
        RatingBar ratingBar = eCBuyerOrderCommentFragment.ratingBar;
        if (ratingBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ratingBar");
        }
        return ratingBar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.ecommerce.biz.comment.b Qh() {
        return (com.tencent.ecommerce.biz.comment.b) this.commentViewModel.getValue();
    }

    private final void Rh(View rootView) {
        if (this.productInfoData.length() > 0) {
            try {
                this.productInfoJOSN = new JSONObject(this.productInfoData);
            } catch (JSONException unused) {
                cg0.a.a("ECBuyerOrderCommentFragment", "initCommentView", "productInfoData, can not convert to JSONObject");
            }
        }
        this.commentDataPts = new ECBasePtsViewData(null, "ec_order_card", this.productInfoJOSN.toString(), null, 9, null);
        View findViewById = rootView.findViewById(R.id.nts);
        if (findViewById != null) {
            this.basePtsView = (ECBasePtsView) findViewById;
            Context requireContext = requireContext();
            ECBasePtsView eCBasePtsView = this.basePtsView;
            if (eCBasePtsView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("basePtsView");
            }
            ECBaseViewController eCBaseViewController = new ECBaseViewController(requireContext, eCBasePtsView);
            this.commentController = eCBaseViewController;
            Context requireContext2 = requireContext();
            ECBasePtsViewData eCBasePtsViewData = this.commentDataPts;
            if (eCBasePtsViewData == null) {
                Intrinsics.throwUninitializedPropertyAccessException("commentDataPts");
            }
            eCBaseViewController.h(requireContext2, eCBasePtsViewData);
            this.titleTv = (TextView) rootView.findViewById(R.id.od_);
            this.ratingBarTv = (TextView) rootView.findViewById(R.id.ntt);
            this.submitCommentBtn = (Button) rootView.findViewById(R.id.ntq);
            this.backIcon = (ImageView) rootView.findViewById(R.id.o0w);
            this.ratingBar = (RatingBar) rootView.findViewById(R.id.ntl);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.tencent.ecommerce.base.ui.ECBasePtsView");
    }

    private final void Sh() {
        Qh().N1().observe(getViewLifecycleOwner(), new b());
        RatingBar ratingBar = this.ratingBar;
        if (ratingBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ratingBar");
        }
        ratingBar.setOnRatingBarChangeListener(new c());
        Button button = this.submitCommentBtn;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException("submitCommentBtn");
        }
        button.setOnClickListener(this);
        ImageView imageView = this.backIcon;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("backIcon");
        }
        imageView.setOnClickListener(this);
    }

    private final void Th(View rootView) {
        h hVar = h.f104868a;
        hVar.a(rootView, this.isNightMode);
        TextView textView = this.titleTv;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleTv");
        }
        hVar.b(textView, -16777216, -1, this.isNightMode);
        TextView textView2 = this.ratingBarTv;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ratingBarTv");
        }
        hVar.b(textView2, -16777216, -1, this.isNightMode);
        r.f104881b.e(getActivity(), !this.isNightMode);
        if (this.isNightMode) {
            ImageView imageView = this.backIcon;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("backIcon");
            }
            imageView.setImageResource(R.drawable.a4v);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Uh() {
        i.f101155b.d(requireContext().getString(R.string.whh), ECToastIcon.ICON_ERROR, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showSuccessToast() {
        i.f101155b.d(requireContext().getString(R.string.whp), ECToastIcon.ICON_SUCCESS, 0);
    }

    @Override // com.tencent.ecommerce.base.fragment.api.IECBaseFragment
    /* renamed from: getBusinessDescription */
    public String getTAG() {
        return "ECBuyerOrderCommentFragment";
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment
    public int getContentLayoutId() {
        return R.layout.cp6;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        if (v3.getId() == R.id.ntq) {
            RatingBar ratingBar = this.ratingBar;
            if (ratingBar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("ratingBar");
            }
            if (ratingBar.getRating() > 0) {
                String optString = this.productInfoJOSN.optString("order_id");
                String optString2 = this.productInfoJOSN.optString(ReportDataBuilder.KEY_PRODUCT_ID);
                JSONObject optJSONObject = this.productInfoJOSN.optJSONObject("basic_info");
                Qh().O1(optString, optString2, optJSONObject != null ? optJSONObject.optInt("goods_type") : 0);
                com.tencent.ecommerce.biz.comment.c cVar = com.tencent.ecommerce.biz.comment.c.f101424a;
                RatingBar ratingBar2 = this.ratingBar;
                if (ratingBar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("ratingBar");
                }
                cVar.c("order_rate_submit", String.valueOf(ratingBar2.getRating()), this.channel, this.productInfoJOSN);
            }
        } else if (v3.getId() == R.id.o0w) {
            requireActivity().finish();
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        String str;
        String str2;
        Intent intent;
        Bundle extras;
        String string;
        Intent intent2;
        Intent intent3;
        super.onCreate(savedInstanceState);
        FragmentActivity activity = getActivity();
        String str3 = "";
        if (activity == null || (intent3 = activity.getIntent()) == null || (str = intent3.getStringExtra("scheme_callback_id")) == null) {
            str = "";
        }
        this.callbackId = str;
        FragmentActivity activity2 = getActivity();
        if (activity2 == null || (intent2 = activity2.getIntent()) == null || (str2 = intent2.getStringExtra(WadlProxyConsts.CHANNEL)) == null) {
            str2 = "";
        }
        this.channel = str2;
        FragmentActivity activity3 = getActivity();
        if (activity3 != null && (intent = activity3.getIntent()) != null && (extras = intent.getExtras()) != null && (string = extras.getString("productInfo")) != null) {
            str3 = string;
        }
        this.productInfoData = str3;
        cg0.a.b("ECBuyerOrderCommentFragment", "product info json get from intent product = " + this.productInfoData);
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        ECBaseViewController eCBaseViewController = this.commentController;
        if (eCBaseViewController == null) {
            Intrinsics.throwUninitializedPropertyAccessException("commentController");
        }
        eCBaseViewController.g();
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        com.tencent.ecommerce.biz.comment.c.f101424a.b("order_rate_exp", this.productInfoJOSN, this.channel);
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Rh(view);
        Th(view);
        Sh();
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment
    public int uh() {
        return 0;
    }
}
