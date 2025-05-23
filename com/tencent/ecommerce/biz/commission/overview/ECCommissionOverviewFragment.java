package com.tencent.ecommerce.biz.commission.overview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.ecommerce.base.fragment.ECBaseFragment;
import com.tencent.ecommerce.base.report.api.IECDtReport;
import com.tencent.ecommerce.base.ui.ECBasePtsView;
import com.tencent.ecommerce.base.ui.ECBasePtsViewData;
import com.tencent.ecommerce.base.ui.ECBaseViewController;
import com.tencent.ecommerce.base.ui.ECSkin;
import com.tencent.ecommerce.base.ui.api.IECCoreSkinApi;
import com.tencent.ecommerce.biz.commission.ECCommissionUtils;
import com.tencent.ecommerce.biz.commission.forecast.o;
import com.tencent.ecommerce.biz.commission.overview.ECCommissionOverviewViewModel;
import com.tencent.ecommerce.biz.commission.subsidy.ECSubsidyOverviewFragment;
import com.tencent.ecommerce.biz.commission.subsidy.a;
import com.tencent.ecommerce.biz.router.ECScheme;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.pts.core.PTSComposer;
import com.tencent.pts.core.lite.IPTSLiteEventListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 :2\u00020\u0001:\u0001;B\u0007\u00a2\u0006\u0004\b8\u00109J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\t\u001a\u00020\u0007H\u0002J\b\u0010\n\u001a\u00020\u0004H\u0002J\b\u0010\f\u001a\u00020\u000bH\u0016J\u001a\u0010\u0010\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u0011\u001a\u00020\u0004H\u0016J\b\u0010\u0012\u001a\u00020\u0004H\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\b\u0010\u0016\u001a\u00020\u0015H\u0016R\u001b\u0010\u001c\u001a\u00020\u00178BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001f\u001a\u00020\u00028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010-\u001a\u00020(8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b,\u0010*R\u0016\u0010/\u001a\u00020(8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b.\u0010*R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0016\u00107\u001a\u0002048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b5\u00106\u00a8\u0006<"}, d2 = {"Lcom/tencent/ecommerce/biz/commission/overview/ECCommissionOverviewFragment;", "Lcom/tencent/ecommerce/base/fragment/ECBaseFragment;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "initView", "initViewModel", "Lcom/tencent/pts/core/lite/IPTSLiteEventListener;", "Qh", "Rh", "Sh", "", "getContentLayoutId", "view", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "onResume", "", "getBusinessDescription", "", "Eh", "Lcom/tencent/ecommerce/biz/commission/overview/ECCommissionOverviewViewModel;", "P", "Lkotlin/Lazy;", "Ph", "()Lcom/tencent/ecommerce/biz/commission/overview/ECCommissionOverviewViewModel;", "viewModel", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Landroid/view/View;", "feedbackContainer", "Landroid/widget/ImageView;", BdhLogUtil.LogTag.Tag_Req, "Landroid/widget/ImageView;", "backIcon", "Landroidx/cardview/widget/CardView;", ExifInterface.LATITUDE_SOUTH, "Landroidx/cardview/widget/CardView;", "forecastCommissionCard", "Landroid/widget/TextView;", "T", "Landroid/widget/TextView;", "forecastCommissionValueTv", "U", "forecastCommissionDescTv", "V", "detailBtn", "Lcom/tencent/ecommerce/base/ui/b;", "W", "Lcom/tencent/ecommerce/base/ui/b;", "commissionDataPts", "Lcom/tencent/ecommerce/base/ui/ECBaseViewController;", "X", "Lcom/tencent/ecommerce/base/ui/ECBaseViewController;", "commissionContainerController", "<init>", "()V", "Y", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECCommissionOverviewFragment extends ECBaseFragment {

    /* renamed from: P, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* renamed from: Q, reason: from kotlin metadata */
    private View feedbackContainer;

    /* renamed from: R, reason: from kotlin metadata */
    private ImageView backIcon;

    /* renamed from: S, reason: from kotlin metadata */
    private CardView forecastCommissionCard;

    /* renamed from: T, reason: from kotlin metadata */
    private TextView forecastCommissionValueTv;

    /* renamed from: U, reason: from kotlin metadata */
    private TextView forecastCommissionDescTv;

    /* renamed from: V, reason: from kotlin metadata */
    private TextView detailBtn;

    /* renamed from: W, reason: from kotlin metadata */
    private ECBasePtsViewData commissionDataPts;

    /* renamed from: X, reason: from kotlin metadata */
    private ECBaseViewController commissionContainerController;

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
            ECSubsidyOverviewFragment.INSTANCE.a(ECCommissionOverviewFragment.this.requireContext());
            a.f101535a.d();
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
            ECCommissionOverviewFragment.this.requireActivity().finish();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class f implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        public static final f f101495d = new f();

        f() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ECScheme.g("https://support.qq.com/products/394271", null, 2, null);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class g implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        public static final g f101496d = new g();

        g() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ECScheme.g(Uri.parse("mqqapi://ecommerce/open").buildUpon().appendQueryParameter("target", "4").toString(), null, 2, null);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class h implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        public static final h f101497d = new h();

        h() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ECScheme.g(Uri.parse("mqqapi://ecommerce/open").buildUpon().appendQueryParameter("target", "29").appendQueryParameter(WadlProxyConsts.CHANNEL, String.valueOf(ug0.b.f438933d.e())).toString(), null, 2, null);
            o.f101491a.c();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lorg/json/JSONObject;", "kotlin.jvm.PlatformType", "it", "", "a", "(Lorg/json/JSONObject;)V"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class i<T> implements Observer<JSONObject> {
        i() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(JSONObject jSONObject) {
            ECCommissionOverviewFragment.Mh(ECCommissionOverviewFragment.this).d(jSONObject.toString());
            ECCommissionOverviewFragment.Lh(ECCommissionOverviewFragment.this).h(ECCommissionOverviewFragment.this.requireContext(), ECCommissionOverviewFragment.Mh(ECCommissionOverviewFragment.this));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/tencent/ecommerce/biz/commission/overview/ECCommissionOverviewViewModel$a;", "kotlin.jvm.PlatformType", "it", "", "a", "(Lcom/tencent/ecommerce/biz/commission/overview/ECCommissionOverviewViewModel$a;)V"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class j<T> implements Observer<ECCommissionOverviewViewModel.CommissionForecastInfo> {
        j() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(ECCommissionOverviewViewModel.CommissionForecastInfo commissionForecastInfo) {
            ECCommissionOverviewFragment.Oh(ECCommissionOverviewFragment.this).setText(com.tencent.ecommerce.biz.util.i.f104869a.d(commissionForecastInfo.commission));
            ECCommissionOverviewFragment.Nh(ECCommissionOverviewFragment.this).setText(commissionForecastInfo.desc);
        }
    }

    public ECCommissionOverviewFragment() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ECCommissionOverviewViewModel>() { // from class: com.tencent.ecommerce.biz.commission.overview.ECCommissionOverviewFragment$viewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ECCommissionOverviewViewModel invoke() {
                return (ECCommissionOverviewViewModel) new ViewModelProvider(ECCommissionOverviewFragment.this).get(ECCommissionOverviewViewModel.class);
            }
        });
        this.viewModel = lazy;
    }

    public static final /* synthetic */ ECBaseViewController Lh(ECCommissionOverviewFragment eCCommissionOverviewFragment) {
        ECBaseViewController eCBaseViewController = eCCommissionOverviewFragment.commissionContainerController;
        if (eCBaseViewController == null) {
            Intrinsics.throwUninitializedPropertyAccessException("commissionContainerController");
        }
        return eCBaseViewController;
    }

    public static final /* synthetic */ ECBasePtsViewData Mh(ECCommissionOverviewFragment eCCommissionOverviewFragment) {
        ECBasePtsViewData eCBasePtsViewData = eCCommissionOverviewFragment.commissionDataPts;
        if (eCBasePtsViewData == null) {
            Intrinsics.throwUninitializedPropertyAccessException("commissionDataPts");
        }
        return eCBasePtsViewData;
    }

    public static final /* synthetic */ TextView Nh(ECCommissionOverviewFragment eCCommissionOverviewFragment) {
        TextView textView = eCCommissionOverviewFragment.forecastCommissionDescTv;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("forecastCommissionDescTv");
        }
        return textView;
    }

    public static final /* synthetic */ TextView Oh(ECCommissionOverviewFragment eCCommissionOverviewFragment) {
        TextView textView = eCCommissionOverviewFragment.forecastCommissionValueTv;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("forecastCommissionValueTv");
        }
        return textView;
    }

    private final ECCommissionOverviewViewModel Ph() {
        return (ECCommissionOverviewViewModel) this.viewModel.getValue();
    }

    private final IPTSLiteEventListener Qh() {
        return new b();
    }

    private final IPTSLiteEventListener Rh() {
        return new c();
    }

    private final void Sh() {
        ImageView imageView = this.backIcon;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("backIcon");
        }
        imageView.setOnClickListener(new e());
        View view = this.feedbackContainer;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedbackContainer");
        }
        view.setOnClickListener(f.f101495d);
        TextView textView = this.detailBtn;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("detailBtn");
        }
        textView.setOnClickListener(g.f101496d);
        CardView cardView = this.forecastCommissionCard;
        if (cardView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("forecastCommissionCard");
        }
        cardView.setOnClickListener(h.f101497d);
    }

    private final void initViewModel() {
        Ph().Q1().observe(getViewLifecycleOwner(), new i());
        Ph().O1().observe(getViewLifecycleOwner(), new j());
        Ph().P1();
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment
    public boolean Eh() {
        return true;
    }

    @Override // com.tencent.ecommerce.base.fragment.api.IECBaseFragment
    /* renamed from: getBusinessDescription */
    public String getTAG() {
        return "ECCommissionOverviewFragment";
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment
    public int getContentLayoutId() {
        return R.layout.cpd;
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        ECBaseViewController eCBaseViewController = this.commissionContainerController;
        if (eCBaseViewController == null) {
            Intrinsics.throwUninitializedPropertyAccessException("commissionContainerController");
        }
        eCBaseViewController.g();
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        com.tencent.ecommerce.biz.common.d.d(com.tencent.ecommerce.biz.common.d.f101554a, String.valueOf(ug0.b.f438933d.e()), "order_income_exp", 0, 4, null);
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        initViewModel();
        Sh();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JN\u0010\f\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022&\u0010\u0006\u001a\"\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0004j\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u0001`\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/ecommerce/biz/commission/overview/ECCommissionOverviewFragment$b", "Lcom/tencent/ecommerce/base/ui/e;", "", IECDtReport.ACTION_IDENTIFIER, "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "dataMap", "Landroid/view/View;", "p2", "Lcom/tencent/pts/core/PTSComposer;", "p3", "", "onTapEventTriggered", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class b extends com.tencent.ecommerce.base.ui.e {
        b() {
        }

        @Override // com.tencent.pts.core.lite.IPTSLiteEventListener
        public void onTapEventTriggered(String identifier, HashMap<String, String> dataMap, View p26, PTSComposer p36) {
            String str = dataMap != null ? dataMap.get(WadlProxyConsts.KEY_JUMP_URL) : null;
            cg0.a.b("ECCommissionOverviewFragment", "[clickItem] jumpUrl = " + str);
            ECScheme.g(str, null, 2, null);
        }
    }

    private final void initView(View rootView) {
        Map<String, ? extends IPTSLiteEventListener> mapOf;
        final ImageView imageView = (ImageView) rootView.findViewById(R.id.o6k);
        ECSkin eCSkin = ECSkin.INSTANCE;
        IECCoreSkinApi.a.a(eCSkin, "qecommerce_icon_allowance_pdd", null, new Function1<Drawable, Unit>() { // from class: com.tencent.ecommerce.biz.commission.overview.ECCommissionOverviewFragment$initView$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Drawable drawable) {
                invoke2(drawable);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Drawable drawable) {
                if (drawable != null) {
                    imageView.setImageDrawable(drawable);
                }
            }
        }, 2, null);
        this.backIcon = (ImageView) rootView.findViewById(R.id.o0w);
        this.feedbackContainer = rootView.findViewById(R.id.f163011nu1);
        this.forecastCommissionCard = (CardView) rootView.findViewById(R.id.nzp);
        this.forecastCommissionValueTv = (TextView) rootView.findViewById(R.id.oct);
        this.forecastCommissionDescTv = (TextView) rootView.findViewById(R.id.nzq);
        this.detailBtn = (TextView) rootView.findViewById(R.id.nvb);
        CardView cardView = (CardView) rootView.findViewById(R.id.obl);
        if (((Boolean) com.tencent.ecommerce.base.config.service.b.f100655b.a(658, "show_pdd_subsidy_entrance", Boolean.FALSE)).booleanValue()) {
            cardView.setVisibility(0);
            cardView.setOnClickListener(new d());
        }
        CardView cardView2 = (CardView) rootView.findViewById(R.id.ntz);
        View findViewById = rootView.findViewById(R.id.f163010nu0);
        if (findViewById != null) {
            this.commissionContainerController = new ECBaseViewController(requireContext(), (ECBasePtsView) findViewById);
            this.commissionDataPts = new ECBasePtsViewData(null, "commission_overview", Ph().R1(), null, 9, null);
            ECBaseViewController eCBaseViewController = this.commissionContainerController;
            if (eCBaseViewController == null) {
                Intrinsics.throwUninitializedPropertyAccessException("commissionContainerController");
            }
            mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("allInOneJump", Qh()), TuplesKt.to("errorMsgClick", Rh()));
            eCBaseViewController.i(mapOf);
            ECBaseViewController eCBaseViewController2 = this.commissionContainerController;
            if (eCBaseViewController2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("commissionContainerController");
            }
            Context requireContext = requireContext();
            ECBasePtsViewData eCBasePtsViewData = this.commissionDataPts;
            if (eCBasePtsViewData == null) {
                Intrinsics.throwUninitializedPropertyAccessException("commissionDataPts");
            }
            eCBaseViewController2.h(requireContext, eCBasePtsViewData);
            Integer color = eCSkin.getColor("qecommerce_skin_color_bg_backplate");
            if (color != null) {
                int intValue = color.intValue();
                cardView.setCardBackgroundColor(intValue);
                cardView2.setCardBackgroundColor(intValue);
                CardView cardView3 = this.forecastCommissionCard;
                if (cardView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("forecastCommissionCard");
                }
                cardView3.setCardBackgroundColor(intValue);
                return;
            }
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.tencent.ecommerce.base.ui.ECBasePtsView");
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JJ\u0010\f\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\"\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0004j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002`\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016JN\u0010\u000e\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022&\u0010\r\u001a\"\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0004j\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u0001`\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016JN\u0010\u000f\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022&\u0010\r\u001a\"\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0004j\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u0001`\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016JN\u0010\u0010\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022&\u0010\r\u001a\"\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0004j\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u0001`\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016JN\u0010\u0011\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022&\u0010\r\u001a\"\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0004j\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u0001`\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016\u00a8\u0006\u0012"}, d2 = {"com/tencent/ecommerce/biz/commission/overview/ECCommissionOverviewFragment$c", "Lcom/tencent/pts/core/lite/IPTSLiteEventListener;", "", "p0", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "dataMap", "Landroid/view/View;", "p2", "Lcom/tencent/pts/core/PTSComposer;", "p3", "", "onTapEventTriggered", "p1", "onExposureTriggered", "onSwiperItemExposureTriggered", "onSwiperDragTriggered", "onScrollViewItemExposureTriggered", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class c implements IPTSLiteEventListener {
        c() {
        }

        @Override // com.tencent.pts.core.lite.IPTSLiteEventListener
        public void onTapEventTriggered(String p06, HashMap<String, String> dataMap, View p26, PTSComposer p36) {
            String str = dataMap.get("errorMsgBox");
            if (str != null) {
                ECCommissionUtils.f101430a.c(ECCommissionOverviewFragment.this.requireContext(), new JSONObject(str));
            }
        }

        @Override // com.tencent.pts.core.lite.IPTSLiteEventListener
        public void onExposureTriggered(String p06, HashMap<String, String> p16, View p26, PTSComposer p36) {
        }

        @Override // com.tencent.pts.core.lite.IPTSLiteEventListener
        public void onScrollViewItemExposureTriggered(String p06, HashMap<String, String> p16, View p26, PTSComposer p36) {
        }

        @Override // com.tencent.pts.core.lite.IPTSLiteEventListener
        public void onSwiperDragTriggered(String p06, HashMap<String, String> p16, View p26, PTSComposer p36) {
        }

        @Override // com.tencent.pts.core.lite.IPTSLiteEventListener
        public void onSwiperItemExposureTriggered(String p06, HashMap<String, String> p16, View p26, PTSComposer p36) {
        }
    }
}
