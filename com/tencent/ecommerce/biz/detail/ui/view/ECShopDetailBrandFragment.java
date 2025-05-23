package com.tencent.ecommerce.biz.detail.ui.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import cg0.a;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ecommerce.base.fragment.ECBaseFragment;
import com.tencent.ecommerce.base.list.IStateCenterView;
import com.tencent.ecommerce.base.report.api.IECDtReport;
import com.tencent.ecommerce.base.ui.ECBasePtsView;
import com.tencent.ecommerce.base.ui.ECBasePtsViewData;
import com.tencent.ecommerce.base.ui.ECBaseViewController;
import com.tencent.ecommerce.base.ui.ECFloatGestureLayout;
import com.tencent.ecommerce.base.ui.api.ECToastIcon;
import com.tencent.ecommerce.base.ui.i;
import com.tencent.ecommerce.base.ui.stateview.ECStateCenterView;
import com.tencent.ecommerce.biz.register.ECommerceCaptchaVerifyDialog;
import com.tencent.ecommerce.biz.util.ECDeviceUtils;
import com.tencent.ecommerce.repo.register.ECaptcha;
import com.tencent.ecommerce.repo.register.ECaptchaErrorCode;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.pts.core.PTSComposer;
import com.tencent.pts.core.lite.IPTSLiteEventListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import mqq.app.Constants;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 >2\u00020\u0001:\u0001?B\u0007\u00a2\u0006\u0004\b<\u0010=J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\fH\u0002J\u0012\u0010\u000f\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\fH\u0002J\b\u0010\u0010\u001a\u00020\tH\u0016J\u0012\u0010\u0013\u001a\u00020\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\u001a\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u0018\u001a\u00020\u0017H\u0016J\b\u0010\u0019\u001a\u00020\u0006H\u0016J\b\u0010\u001a\u001a\u00020\u0017H\u0016R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00102\u001a\u00020/8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0016\u00106\u001a\u0002038\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0016\u00109\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010;\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u00108\u00a8\u0006@"}, d2 = {"Lcom/tencent/ecommerce/biz/detail/ui/view/ECShopDetailBrandFragment;", "Lcom/tencent/ecommerce/base/fragment/ECBaseFragment;", "", "Yh", "Xh", "initUI", "", "brandInfoJson", "Zh", "", NodeProps.MARGIN_TOP, "Wh", "Lorg/json/JSONObject;", "Uh", "infoJson", "Vh", "getContentLayoutId", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "Landroid/view/View;", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "", "onBackPressed", "getBusinessDescription", "Eh", "Lcom/tencent/ecommerce/biz/register/ECommerceCaptchaVerifyDialog;", "P", "Lcom/tencent/ecommerce/biz/register/ECommerceCaptchaVerifyDialog;", "eCommerceCaptchaVerifyDialog", "Lcom/tencent/ecommerce/base/ui/ECFloatGestureLayout;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/tencent/ecommerce/base/ui/ECFloatGestureLayout;", "floatGestureLayout", "Landroid/widget/ImageView;", BdhLogUtil.LogTag.Tag_Req, "Landroid/widget/ImageView;", "closeBtn", "Lcom/tencent/ecommerce/base/ui/stateview/ECStateCenterView;", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/ecommerce/base/ui/stateview/ECStateCenterView;", "stateCenterView", "Landroid/widget/LinearLayout;", "T", "Landroid/widget/LinearLayout;", "brandInfoContainer", "Lcom/tencent/ecommerce/base/ui/ECBasePtsView;", "U", "Lcom/tencent/ecommerce/base/ui/ECBasePtsView;", "brandInfoPtsView", "Lcom/tencent/ecommerce/base/ui/ECBaseViewController;", "V", "Lcom/tencent/ecommerce/base/ui/ECBaseViewController;", "brandInfoPtsController", "W", "Ljava/lang/String;", "shopId", "X", "brandId", "<init>", "()V", "Y", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECShopDetailBrandFragment extends ECBaseFragment {

    /* renamed from: P, reason: from kotlin metadata */
    private ECommerceCaptchaVerifyDialog eCommerceCaptchaVerifyDialog;

    /* renamed from: Q, reason: from kotlin metadata */
    private ECFloatGestureLayout floatGestureLayout;

    /* renamed from: R, reason: from kotlin metadata */
    private ImageView closeBtn;

    /* renamed from: S, reason: from kotlin metadata */
    private ECStateCenterView stateCenterView;

    /* renamed from: T, reason: from kotlin metadata */
    private LinearLayout brandInfoContainer;

    /* renamed from: U, reason: from kotlin metadata */
    private ECBasePtsView brandInfoPtsView;

    /* renamed from: V, reason: from kotlin metadata */
    private ECBaseViewController brandInfoPtsController;

    /* renamed from: W, reason: from kotlin metadata */
    private String shopId = "";

    /* renamed from: X, reason: from kotlin metadata */
    private String brandId = "";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/ecommerce/biz/detail/ui/view/ECShopDetailBrandFragment$b", "Lcom/tencent/ecommerce/base/ui/c;", "", "isFromTop", "", "deltaY", "type", "", "onPageClose", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class b extends com.tencent.ecommerce.base.ui.c {
        b() {
        }

        @Override // com.tencent.ecommerce.base.ui.c, com.tencent.ecommerce.base.ui.ECFloatGestureLayout.FloatEventListener
        public void onPageClose(boolean isFromTop, int deltaY, int type) {
            FragmentActivity activity = ECShopDetailBrandFragment.this.getActivity();
            if (activity != null) {
                activity.finish();
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001R\u0014\u0010\u0005\u001a\u00020\u00028VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0006"}, d2 = {"com/tencent/ecommerce/biz/detail/ui/view/ECShopDetailBrandFragment$c", "Lcom/tencent/ecommerce/base/ui/ECFloatGestureLayout$ContentScrollListener;", "", "getPositionState", "()I", "positionState", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class c implements ECFloatGestureLayout.ContentScrollListener {
        c() {
        }

        @Override // com.tencent.ecommerce.base.ui.ECFloatGestureLayout.ContentScrollListener
        public int getPositionState() {
            return 1;
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
            ECShopDetailBrandFragment.Oh(ECShopDetailBrandFragment.this).E();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public static final /* synthetic */ ECFloatGestureLayout Oh(ECShopDetailBrandFragment eCShopDetailBrandFragment) {
        ECFloatGestureLayout eCFloatGestureLayout = eCShopDetailBrandFragment.floatGestureLayout;
        if (eCFloatGestureLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("floatGestureLayout");
        }
        return eCFloatGestureLayout;
    }

    public static final /* synthetic */ ECStateCenterView Qh(ECShopDetailBrandFragment eCShopDetailBrandFragment) {
        ECStateCenterView eCStateCenterView = eCShopDetailBrandFragment.stateCenterView;
        if (eCStateCenterView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stateCenterView");
        }
        return eCStateCenterView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int Uh(JSONObject brandInfoJson) {
        return (int) (ECDeviceUtils.f104857e.i(r0.d()) - Math.min((Vh(brandInfoJson.optJSONObject("authorization_info")) + 66) + Vh(brandInfoJson.optJSONObject("registration_info")), 600));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Wh(int marginTop) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("scroll_to_top", false);
        bundle.putBoolean("disallow_pulling", true);
        bundle.putInt("scroll_margin_top", marginTop);
        ECFloatGestureLayout eCFloatGestureLayout = new ECFloatGestureLayout(requireContext(), bundle);
        this.floatGestureLayout = eCFloatGestureLayout;
        eCFloatGestureLayout.setFloatEventListener(new b());
        ECFloatGestureLayout eCFloatGestureLayout2 = this.floatGestureLayout;
        if (eCFloatGestureLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("floatGestureLayout");
        }
        eCFloatGestureLayout2.setContentScrollListener(new c());
        ECFloatGestureLayout eCFloatGestureLayout3 = this.floatGestureLayout;
        if (eCFloatGestureLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("floatGestureLayout");
        }
        eCFloatGestureLayout3.C(this, -1, -1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Xh() {
        initUI();
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new ECShopDetailBrandFragment$initUIAndReqData$1(this, null), 3, null);
    }

    private final void Yh() {
        ECommerceCaptchaVerifyDialog eCommerceCaptchaVerifyDialog = new ECommerceCaptchaVerifyDialog();
        Bundle bundle = new Bundle();
        bundle.putString("appId", "2003043272");
        Unit unit = Unit.INSTANCE;
        eCommerceCaptchaVerifyDialog.setArguments(bundle);
        this.eCommerceCaptchaVerifyDialog = eCommerceCaptchaVerifyDialog;
        eCommerceCaptchaVerifyDialog.uh(getChildFragmentManager(), new Function1<ECommerceCaptchaVerifyDialog.CaptchaVerifyDialogResult, Unit>() { // from class: com.tencent.ecommerce.biz.detail.ui.view.ECShopDetailBrandFragment$popCaptchaVerifyDialog$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ECommerceCaptchaVerifyDialog.CaptchaVerifyDialogResult captchaVerifyDialogResult) {
                invoke2(captchaVerifyDialogResult);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ECommerceCaptchaVerifyDialog.CaptchaVerifyDialogResult captchaVerifyDialogResult) {
                ECommerceCaptchaVerifyDialog eCommerceCaptchaVerifyDialog2;
                if (Intrinsics.areEqual(captchaVerifyDialogResult, ECommerceCaptchaVerifyDialog.CaptchaVerifyDialogResult.Cancel.f103956d)) {
                    a.b("ECShopDetailBrandFragment", "[popCaptchaVerifyDialog] ECommerceCaptchaVerifyDialog onCanceled");
                    FragmentActivity activity = ECShopDetailBrandFragment.this.getActivity();
                    if (activity != null) {
                        activity.finish();
                        return;
                    }
                    return;
                }
                if (captchaVerifyDialogResult instanceof ECommerceCaptchaVerifyDialog.CaptchaVerifyDialogResult.Verified) {
                    ECaptcha eCaptcha = ((ECommerceCaptchaVerifyDialog.CaptchaVerifyDialogResult.Verified) captchaVerifyDialogResult).captcha;
                    a.b("ECShopDetailBrandFragment", "[popCaptchaVerifyDialog] errorCode " + eCaptcha.getErrorCode() + ", ticket " + eCaptcha.getTicket());
                    if (eCaptcha.getErrorCode() == ECaptchaErrorCode.DEFAULT.getErrorCode()) {
                        if (!(eCaptcha.getTicket().length() == 0)) {
                            ECShopDetailBrandFragment.this.Xh();
                            a.b("ECShopDetailBrandFragment", "[popCaptchaVerifyDialog] ECommerceCaptchaVerifyDialog onVerified");
                            return;
                        }
                    }
                    eCommerceCaptchaVerifyDialog2 = ECShopDetailBrandFragment.this.eCommerceCaptchaVerifyDialog;
                    if (eCommerceCaptchaVerifyDialog2 != null) {
                        eCommerceCaptchaVerifyDialog2.dismiss();
                    }
                    i.f101155b.d(ECShopDetailBrandFragment.this.requireContext().getString(R.string.wdl), ECToastIcon.ICON_ERROR, 0);
                    FragmentActivity activity2 = ECShopDetailBrandFragment.this.getActivity();
                    if (activity2 != null) {
                        activity2.finish();
                        return;
                    }
                    return;
                }
                if (Intrinsics.areEqual(captchaVerifyDialogResult, ECommerceCaptchaVerifyDialog.CaptchaVerifyDialogResult.PageReady.f103957d)) {
                    a.b("ECShopDetailBrandFragment", "[popCaptchaVerifyDialog] ECommerceCaptchaVerifyDialog PageReady");
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Zh(String brandInfoJson) {
        Map<String, ? extends IPTSLiteEventListener> mapOf;
        ECStateCenterView eCStateCenterView = this.stateCenterView;
        if (eCStateCenterView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stateCenterView");
        }
        eCStateCenterView.setSucceededState();
        ECStateCenterView eCStateCenterView2 = this.stateCenterView;
        if (eCStateCenterView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stateCenterView");
        }
        eCStateCenterView2.setVisibility(8);
        LinearLayout linearLayout = this.brandInfoContainer;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("brandInfoContainer");
        }
        linearLayout.setVisibility(0);
        Context requireContext = requireContext();
        ECBasePtsView eCBasePtsView = this.brandInfoPtsView;
        if (eCBasePtsView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("brandInfoPtsView");
        }
        ECBaseViewController eCBaseViewController = new ECBaseViewController(requireContext, eCBasePtsView);
        this.brandInfoPtsController = eCBaseViewController;
        eCBaseViewController.h(requireContext(), new ECBasePtsViewData(null, "qshop_brand_img", brandInfoJson, null, 9, null));
        ECBaseViewController eCBaseViewController2 = this.brandInfoPtsController;
        if (eCBaseViewController2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("brandInfoPtsController");
        }
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("showPhotoBrowser", new e()));
        eCBaseViewController2.i(mapOf);
    }

    private final void initUI() {
        yh().setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.f7153h));
        this.closeBtn = (ImageView) yh().findViewById(R.id.nti);
        this.stateCenterView = (ECStateCenterView) yh().findViewById(R.id.oaz);
        this.brandInfoContainer = (LinearLayout) yh().findViewById(R.id.nro);
        this.brandInfoPtsView = (ECBasePtsView) yh().findViewById(R.id.nrq);
        ECStateCenterView eCStateCenterView = this.stateCenterView;
        if (eCStateCenterView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stateCenterView");
        }
        IStateCenterView.a.c(eCStateCenterView, null, 1, null);
        ImageView imageView = this.closeBtn;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("closeBtn");
        }
        imageView.setOnClickListener(new d());
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment
    public boolean Eh() {
        return true;
    }

    @Override // com.tencent.ecommerce.base.fragment.api.IECBaseFragment
    /* renamed from: getBusinessDescription */
    public String getTAG() {
        return "ECShopDetailBrandFragment";
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment
    public int getContentLayoutId() {
        return R.layout.f167349cu2;
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, com.tencent.ecommerce.base.ui.api.IECFragmentApi
    public boolean onBackPressed() {
        ECFloatGestureLayout eCFloatGestureLayout = this.floatGestureLayout;
        if (eCFloatGestureLayout != null) {
            if (eCFloatGestureLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("floatGestureLayout");
            }
            eCFloatGestureLayout.E();
            return true;
        }
        ECStateCenterView eCStateCenterView = this.stateCenterView;
        if (eCStateCenterView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stateCenterView");
        }
        eCStateCenterView.setVisibility(8);
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return true;
        }
        activity.finish();
        return true;
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        String str;
        Intent intent;
        String stringExtra;
        Intent intent2;
        super.onCreate(savedInstanceState);
        FragmentActivity activity = getActivity();
        String str2 = "";
        if (activity == null || (intent2 = activity.getIntent()) == null || (str = intent2.getStringExtra("shopId")) == null) {
            str = "";
        }
        this.shopId = str;
        FragmentActivity activity2 = getActivity();
        if (activity2 != null && (intent = activity2.getIntent()) != null && (stringExtra = intent.getStringExtra("brandId")) != null) {
            str2 = stringExtra;
        }
        this.brandId = str2;
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        yh().setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.f7153h));
        Yh();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J<\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/ecommerce/biz/detail/ui/view/ECShopDetailBrandFragment$e", "Lcom/tencent/ecommerce/base/ui/e;", "", IECDtReport.ACTION_IDENTIFIER, "Ljava/util/HashMap;", "dataMap", "Landroid/view/View;", "view", "Lcom/tencent/pts/core/PTSComposer;", "ptsComposer", "", "onTapEventTriggered", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class e extends com.tencent.ecommerce.base.ui.e {
        e() {
        }

        @Override // com.tencent.pts.core.lite.IPTSLiteEventListener
        public void onTapEventTriggered(String identifier, HashMap<String, String> dataMap, View view, PTSComposer ptsComposer) {
            String str = dataMap != null ? dataMap.get("originalPhotosData") : null;
            ArrayList arrayList = new ArrayList();
            int i3 = 0;
            if (str != null) {
                try {
                    JSONArray jSONArray = new JSONArray(str);
                    int length = jSONArray.length();
                    for (int i16 = 0; i16 < length; i16++) {
                        arrayList.add(jSONArray.get(i16).toString());
                    }
                    if (identifier != null) {
                        i3 = Integer.parseInt(identifier);
                    }
                } catch (Exception e16) {
                    a.a("ECShopDetailBrandFragment", "setUIContent", "[brandInfoPtsController registerEventHandler] photo data = " + str + " error = " + e16);
                }
            }
            int i17 = i3;
            if (arrayList.size() > 0) {
                lg0.a.b(lg0.a.f414523b, arrayList, i17, null, 4, null);
            }
        }
    }

    private final int Vh(JSONObject infoJson) {
        if (infoJson == null) {
            return 0;
        }
        int i3 = infoJson.optString("link_show_name", "").length() > 0 ? 24 : 0;
        JSONArray optJSONArray = infoJson.optJSONArray("link_url");
        if (optJSONArray == null) {
            optJSONArray = new JSONArray();
        }
        return i3 + (optJSONArray.length() * 248);
    }
}
