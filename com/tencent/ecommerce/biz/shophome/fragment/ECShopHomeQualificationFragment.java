package com.tencent.ecommerce.biz.shophome.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import cg0.a;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.ecommerce.base.fragment.ECBaseFragment;
import com.tencent.ecommerce.base.report.api.IECDtReport;
import com.tencent.ecommerce.base.ui.ECBasePtsView;
import com.tencent.ecommerce.base.ui.ECBaseViewController;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.pts.core.PTSComposer;
import com.tencent.pts.core.lite.IPTSLiteEventListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 )2\u00020\u0001:\u0001*B\u0007\u00a2\u0006\u0004\b'\u0010(J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0003J\b\u0010\n\u001a\u00020\tH\u0002J\b\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\u001a\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010#\u001a\u00020\u00048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010&\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%\u00a8\u0006+"}, d2 = {"Lcom/tencent/ecommerce/biz/shophome/fragment/ECShopHomeQualificationFragment;", "Lcom/tencent/ecommerce/base/fragment/ECBaseFragment;", "", "initArguments", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "initUI", "Rh", "Qh", "Lcom/tencent/pts/core/lite/IPTSLiteEventListener;", "Ph", "", "getContentLayoutId", "", "getBusinessDescription", "", "Eh", "view", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "Lcom/tencent/ecommerce/base/ui/ECBasePtsView;", "P", "Lcom/tencent/ecommerce/base/ui/ECBasePtsView;", "ecBasePtsView", "Lcom/tencent/ecommerce/base/ui/ECBaseViewController;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/tencent/ecommerce/base/ui/ECBaseViewController;", "ecPtsViewController", "Landroid/widget/LinearLayout;", BdhLogUtil.LogTag.Tag_Req, "Landroid/widget/LinearLayout;", "qualificationErrorLayout", ExifInterface.LATITUDE_SOUTH, "Landroid/view/View;", "qualificationNetworkErrorRetryBtn", "T", "Ljava/lang/String;", "shopId", "<init>", "()V", "U", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECShopHomeQualificationFragment extends ECBaseFragment {

    /* renamed from: P, reason: from kotlin metadata */
    private ECBasePtsView ecBasePtsView;

    /* renamed from: Q, reason: from kotlin metadata */
    private ECBaseViewController ecPtsViewController;

    /* renamed from: R, reason: from kotlin metadata */
    private LinearLayout qualificationErrorLayout;

    /* renamed from: S, reason: from kotlin metadata */
    private View qualificationNetworkErrorRetryBtn;

    /* renamed from: T, reason: from kotlin metadata */
    private String shopId = "";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            FragmentActivity activity = ECShopHomeQualificationFragment.this.getActivity();
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
    public static final class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ECShopHomeQualificationFragment.this.Qh();
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
            ECShopHomeQualificationFragment.this.Qh();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public static final /* synthetic */ ECBaseViewController Lh(ECShopHomeQualificationFragment eCShopHomeQualificationFragment) {
        ECBaseViewController eCBaseViewController = eCShopHomeQualificationFragment.ecPtsViewController;
        if (eCBaseViewController == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ecPtsViewController");
        }
        return eCBaseViewController;
    }

    public static final /* synthetic */ LinearLayout Mh(ECShopHomeQualificationFragment eCShopHomeQualificationFragment) {
        LinearLayout linearLayout = eCShopHomeQualificationFragment.qualificationErrorLayout;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("qualificationErrorLayout");
        }
        return linearLayout;
    }

    private final IPTSLiteEventListener Ph() {
        return new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Qh() {
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new ECShopHomeQualificationFragment$initQualificationContent$1(this, null), 3, null);
    }

    private final void initArguments() {
        String str;
        Intent intent;
        FragmentActivity activity = getActivity();
        if (activity == null || (intent = activity.getIntent()) == null || (str = intent.getStringExtra("shop_id")) == null) {
            str = "";
        }
        this.shopId = str;
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment
    public boolean Eh() {
        return true;
    }

    @Override // com.tencent.ecommerce.base.fragment.api.IECBaseFragment
    /* renamed from: getBusinessDescription */
    public String getTAG() {
        return "ECShopHomeQualificationFragment";
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment
    public int getContentLayoutId() {
        return R.layout.cra;
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initArguments();
        initUI(view);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JN\u0010\f\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022&\u0010\u0006\u001a\"\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0004j\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u0001`\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/ecommerce/biz/shophome/fragment/ECShopHomeQualificationFragment$b", "Lcom/tencent/ecommerce/base/ui/e;", "", IECDtReport.ACTION_IDENTIFIER, "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "dataMap", "Landroid/view/View;", "view", "Lcom/tencent/pts/core/PTSComposer;", "ptsComposer", "", "onTapEventTriggered", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class b extends com.tencent.ecommerce.base.ui.e {
        b() {
        }

        @Override // com.tencent.pts.core.lite.IPTSLiteEventListener
        public void onTapEventTriggered(String identifier, HashMap<String, String> dataMap, View view, PTSComposer ptsComposer) {
            List mutableListOf;
            String str = dataMap != null ? dataMap.get("eventType") : null;
            String str2 = dataMap != null ? dataMap.get("picUrl") : null;
            a.b("ECShopHomeQualificationFragment", "[initPTSListener] eventType = " + str + " picUrl = " + str2);
            if (!Intrinsics.areEqual(str, "clickCertificateImage") || str2 == null) {
                return;
            }
            lg0.a aVar = lg0.a.f414523b;
            mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(str2);
            lg0.a.b(aVar, mutableListOf, 0, null, 4, null);
        }
    }

    private final void Rh(View rootView) {
        ((ImageView) rootView.findViewById(R.id.o18)).setOnClickListener(new c());
        ((TextView) rootView.findViewById(R.id.f163072o52)).setOnClickListener(new d());
        View view = this.qualificationNetworkErrorRetryBtn;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("qualificationNetworkErrorRetryBtn");
        }
        view.setOnClickListener(new e());
    }

    private final void initUI(View rootView) {
        Map<String, ? extends IPTSLiteEventListener> mapOf;
        this.ecBasePtsView = (ECBasePtsView) rootView.findViewById(R.id.o8c);
        Context requireContext = requireContext();
        ECBasePtsView eCBasePtsView = this.ecBasePtsView;
        if (eCBasePtsView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ecBasePtsView");
        }
        ECBaseViewController eCBaseViewController = new ECBaseViewController(requireContext, eCBasePtsView);
        this.ecPtsViewController = eCBaseViewController;
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("clickCertificateImage", Ph()));
        eCBaseViewController.i(mapOf);
        this.qualificationErrorLayout = (LinearLayout) rootView.findViewById(R.id.o8d);
        this.qualificationNetworkErrorRetryBtn = rootView.findViewById(R.id.f163072o52);
        Qh();
        Rh(rootView);
    }
}
