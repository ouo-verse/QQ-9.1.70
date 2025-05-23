package com.tencent.aelight.camera.ae.flashshow.ui.multicamera;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.gyailib.library.GYAssessPicQuality;
import com.gyailib.library.SDKDeviceConfig;
import com.tencent.aelight.camera.ae.camera.ui.topbar.AEVideoStoryTopBarViewModel;
import com.tencent.aelight.camera.ae.data.AEMaterialManager;
import com.tencent.aelight.camera.ae.data.AEQZoneMaterialMetaData;
import com.tencent.aelight.camera.ae.flashshow.LSMultiCameraUnit;
import com.tencent.aelight.camera.ae.flashshow.ax;
import com.tencent.aelight.camera.download.api.AEResInfo;
import com.tencent.aelight.camera.download.api.IAEDownloadMaterial;
import com.tencent.aelight.camera.download.api.IAEResUtil;
import com.tencent.aelight.camera.pref.api.IPrefRecorder;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qzonehub.api.IQZonePageApi;
import com.tencent.ttpic.openapi.offlineset.AEOfflineConfig;
import com.tencent.util.LoadingUtil;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00072\u00020\u0001:\u0001JB\u001f\u0012\u0006\u0010&\u001a\u00020!\u0012\u0006\u0010+\u001a\u00020\t\u0012\u0006\u00101\u001a\u00020,\u00a2\u0006\u0004\bH\u0010IJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J0\u0010\u0010\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000bH\u0002J\b\u0010\u0011\u001a\u00020\u0002H\u0016J\b\u0010\u0012\u001a\u00020\u0002H\u0016J \u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0015H\u0016J\b\u0010\u0019\u001a\u00020\u0002H\u0016J\u0010\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0015H\u0016J4\u0010\u001f\u001a\u00020\u00022*\u0010\u001e\u001a&\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\u001cj\u0012\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u0001`\u001dH\u0016J\b\u0010 \u001a\u00020\u0002H\u0016R\u0017\u0010&\u001a\u00020!8\u0006\u00a2\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u0017\u0010+\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\u0017\u00101\u001a\u00020,8\u0006\u00a2\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100R\u0016\u00105\u001a\u0002028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0016\u00107\u001a\u0002028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b6\u00104R\u0016\u00109\u001a\u0002028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b8\u00104R\u0016\u0010<\u001a\u00020:8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0005\u0010;R\u0016\u0010>\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010=R\u0016\u0010?\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010=R\u0016\u0010B\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u0018\u0010F\u001a\u0004\u0018\u00010C8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u0010ER\u0016\u0010G\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010=\u00a8\u0006K"}, d2 = {"Lcom/tencent/aelight/camera/ae/flashshow/ui/multicamera/AECameraMultiCameraTopPart;", "Lcom/tencent/aelight/camera/ae/flashshow/ui/multicamera/AECameraMultiCameraBasePart;", "", "N", "P", "M", "", "T", ExifInterface.LATITUDE_SOUTH, "Landroid/view/View;", "view", "", "eid", "pageId", "after_click_state", "current_state", "W", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/aelight/camera/ae/camera/ui/topbar/AEVideoStoryTopBarViewModel$Ratio;", "ratio", "", "cameraHeight", "cameraWith", BdhLogUtil.LogTag.Tag_Conn, QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, IPrefRecorder.MILESTONE_ON_SLEECT_CAMERA_IN_FS, HippyTKDListViewAdapter.X, "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "map", "y", "B", "Landroid/app/Activity;", "G", "Landroid/app/Activity;", "O", "()Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "H", "Landroid/view/View;", "getRootView", "()Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Llq/b;", "I", "Llq/b;", "getPartManger", "()Llq/b;", "partManger", "Landroid/widget/ImageView;", "J", "Landroid/widget/ImageView;", "beautyBtn", "K", "cancleBtn", "L", "loadingBtn", "Landroid/widget/LinearLayout;", "Landroid/widget/LinearLayout;", "applyMaterialBtn", "Z", "hasApplyMaterial", "defaultSwitchValue", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Ljava/lang/String;", "materialUrl", "Lcom/tencent/aelight/camera/ae/data/AEQZoneMaterialMetaData;", BdhLogUtil.LogTag.Tag_Req, "Lcom/tencent/aelight/camera/ae/data/AEQZoneMaterialMetaData;", "qZoneMaterial", "isDeviceSupport", "<init>", "(Landroid/app/Activity;Landroid/view/View;Llq/b;)V", "a", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class AECameraMultiCameraTopPart extends AECameraMultiCameraBasePart {

    /* renamed from: G, reason: from kotlin metadata */
    private final Activity activity;

    /* renamed from: H, reason: from kotlin metadata */
    private final View rootView;

    /* renamed from: I, reason: from kotlin metadata */
    private final lq.b partManger;

    /* renamed from: J, reason: from kotlin metadata */
    private ImageView beautyBtn;

    /* renamed from: K, reason: from kotlin metadata */
    private ImageView cancleBtn;

    /* renamed from: L, reason: from kotlin metadata */
    private ImageView loadingBtn;

    /* renamed from: M, reason: from kotlin metadata */
    private LinearLayout applyMaterialBtn;

    /* renamed from: N, reason: from kotlin metadata */
    private boolean hasApplyMaterial;

    /* renamed from: P, reason: from kotlin metadata */
    private boolean defaultSwitchValue;

    /* renamed from: Q, reason: from kotlin metadata */
    private String materialUrl;

    /* renamed from: R, reason: from kotlin metadata */
    private AEQZoneMaterialMetaData qZoneMaterial;

    /* renamed from: S, reason: from kotlin metadata */
    private boolean isDeviceSupport;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AECameraMultiCameraTopPart(Activity activity, View rootView, lq.b partManger) {
        super(activity, rootView, partManger);
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        Intrinsics.checkNotNullParameter(partManger, "partManger");
        this.activity = activity;
        this.rootView = rootView;
        this.partManger = partManger;
        this.materialUrl = "";
    }

    private final void M() {
        Boolean cangLanConfig = ((IQZonePageApi) QRoute.api(IQZonePageApi.class)).getCangLanConfig("qzone_moment_face_mask_switch", false);
        Intrinsics.checkNotNullExpressionValue(cangLanConfig, "api(IQZonePageApi::class\u2026ig(CANGLAN_SWITCH, false)");
        boolean booleanValue = cangLanConfig.booleanValue();
        this.defaultSwitchValue = booleanValue;
        ms.a.a("AECameraMultiCameraTopPart", "defaultSwitchValue is: " + booleanValue);
        String d16 = os.a.f423933a.d("face_mask_switch_last_value", "");
        if (TextUtils.isEmpty(d16)) {
            return;
        }
        boolean areEqual = Intrinsics.areEqual("true", d16);
        this.defaultSwitchValue = areEqual;
        ms.a.a("AECameraMultiCameraTopPart", "lastSwitchValue is: " + areEqual);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void N() {
        boolean S = S();
        boolean T = T();
        ms.a.a("AECameraMultiCameraTopPart", "checkSupport, opencl is: " + S + ", phoneLevel is: " + T);
        boolean z16 = S && T;
        this.isDeviceSupport = z16;
        LinearLayout linearLayout = null;
        if (!z16) {
            LinearLayout linearLayout2 = this.applyMaterialBtn;
            if (linearLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("applyMaterialBtn");
            } else {
                linearLayout = linearLayout2;
            }
            linearLayout.setVisibility(8);
            return;
        }
        LinearLayout linearLayout3 = this.applyMaterialBtn;
        if (linearLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("applyMaterialBtn");
        } else {
            linearLayout = linearLayout3;
        }
        linearLayout.setVisibility(0);
    }

    private final void P() {
        MutableLiveData<ax.d> a26 = q().a2();
        LSMultiCameraUnit mUnit = getMUnit();
        final Function1<ax.d, Unit> function1 = new Function1<ax.d, Unit>() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.multicamera.AECameraMultiCameraTopPart$initMaterialLayout$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ax.d dVar) {
                invoke2(dVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ax.d dVar) {
                boolean z16;
                LinearLayout linearLayout;
                AEQZoneMaterialMetaData aEQZoneMaterialMetaData;
                if (dVar.getStatus() == 1) {
                    AECameraMultiCameraTopPart.this.N();
                    z16 = AECameraMultiCameraTopPart.this.defaultSwitchValue;
                    if (z16) {
                        ax.c value = AECameraMultiCameraTopPart.this.q().Z1().getValue();
                        boolean z17 = false;
                        if (value != null && value.getStatus() == 2) {
                            z17 = true;
                        }
                        if (z17) {
                            linearLayout = AECameraMultiCameraTopPart.this.applyMaterialBtn;
                            if (linearLayout == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("applyMaterialBtn");
                                linearLayout = null;
                            }
                            linearLayout.setBackground(ContextCompat.getDrawable(AECameraMultiCameraTopPart.this.getActivity(), R.drawable.isi));
                            aEQZoneMaterialMetaData = AECameraMultiCameraTopPart.this.qZoneMaterial;
                            if (aEQZoneMaterialMetaData != null) {
                                AECameraMultiCameraTopPart.this.q().L1(aEQZoneMaterialMetaData.f69050id, AEMaterialManager.F(aEQZoneMaterialMetaData));
                            }
                            AECameraMultiCameraTopPart.this.hasApplyMaterial = true;
                        }
                    }
                }
            }
        };
        a26.observe(mUnit, new Observer() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.multicamera.m
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AECameraMultiCameraTopPart.Q(Function1.this, obj);
            }
        });
        final AEQZoneMaterialMetaData createAEQZoneMaterialMetaData = AEQZoneMaterialMetaData.createAEQZoneMaterialMetaData(this.materialUrl);
        this.qZoneMaterial = createAEQZoneMaterialMetaData;
        if (createAEQZoneMaterialMetaData != null) {
            LinearLayout linearLayout = null;
            if (!AEMaterialManager.j(createAEQZoneMaterialMetaData)) {
                Drawable loadingDrawable = LoadingUtil.getLoadingDrawable(this.activity, 1);
                ImageView imageView = this.loadingBtn;
                if (imageView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("loadingBtn");
                    imageView = null;
                }
                imageView.setImageDrawable(loadingDrawable);
            } else {
                q().Z1().postValue(new ax.c(2));
            }
            LinearLayout linearLayout2 = this.applyMaterialBtn;
            if (linearLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("applyMaterialBtn");
            } else {
                linearLayout = linearLayout2;
            }
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.multicamera.n
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AECameraMultiCameraTopPart.R(AECameraMultiCameraTopPart.this, createAEQZoneMaterialMetaData, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R(AECameraMultiCameraTopPart this$0, AEQZoneMaterialMetaData qZoneMaterial, View it) {
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(qZoneMaterial, "$qZoneMaterial");
        ax.c value = this$0.q().Z1().getValue();
        boolean z16 = false;
        if (value != null && value.getStatus() == 1) {
            z16 = true;
        }
        if (!z16) {
            if (this$0.hasApplyMaterial) {
                it.setBackground(ContextCompat.getDrawable(this$0.activity, R.drawable.ish));
                this$0.q().L1("", "");
                Intrinsics.checkNotNullExpressionValue(it, "it");
                this$0.W(it, "em_bas_face_blocking_effect", "pg_bas_capture", "1", "2");
            } else {
                it.setBackground(ContextCompat.getDrawable(this$0.activity, R.drawable.isi));
                this$0.q().L1(qZoneMaterial.f69050id, AEMaterialManager.F(qZoneMaterial));
                Intrinsics.checkNotNullExpressionValue(it, "it");
                this$0.W(it, "em_bas_face_blocking_effect", "pg_bas_capture", "2", "1");
            }
            boolean z17 = !this$0.hasApplyMaterial;
            this$0.hasApplyMaterial = z17;
            os.a.f423933a.h("face_mask_switch_last_value", String.valueOf(z17));
        }
        EventCollector.getInstance().onViewClicked(it);
    }

    private final boolean S() {
        if (((IAEResUtil) QRoute.api(IAEResUtil.class)).isAEResExist(AEResInfo.LIGHT_RES_BASE_PACKAGE)) {
            ms.a.a("AECameraMultiCameraTopPart", "base res is ready");
            new SDKDeviceConfig().setDevice("ARM");
            try {
                int hDROption = new GYAssessPicQuality().getHDROption();
                ms.a.a("AECameraMultiCameraTopPart", "isOpenCLSupport: " + (hDROption != 0));
                return hDROption != 0;
            } catch (UnsatisfiedLinkError e16) {
                ms.a.d("AECameraMultiCameraTopPart", "initPicQuality error: ", e16);
            }
        } else {
            ms.a.a("AECameraMultiCameraTopPart", "base res is not ready");
        }
        return false;
    }

    private final boolean T() {
        boolean z16 = AEOfflineConfig.getPhonePerfLevel() > 3;
        ms.a.a("AECameraMultiCameraTopPart", "isPhoneLevelSupport is: " + z16);
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U(AECameraMultiCameraTopPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.q().M1();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V(AECameraMultiCameraTopPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ImageView imageView = this$0.beautyBtn;
        ImageView imageView2 = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("beautyBtn");
            imageView = null;
        }
        ImageView imageView3 = this$0.beautyBtn;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("beautyBtn");
            imageView3 = null;
        }
        imageView.setSelected(!imageView3.isSelected());
        ax q16 = this$0.q();
        ImageView imageView4 = this$0.beautyBtn;
        if (imageView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("beautyBtn");
        } else {
            imageView2 = imageView4;
        }
        q16.g2(imageView2.isSelected());
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void W(View view, String eid, String pageId, String after_click_state, String current_state) {
        VideoReport.setElementId(view, eid);
        Map<String, Object> buildElementParams = WinkDTParamBuilder.buildElementParams();
        Intrinsics.checkNotNullExpressionValue(buildElementParams, "buildElementParams()");
        buildElementParams.put("xsj_eid", eid);
        buildElementParams.put("dt_pgid", pageId);
        buildElementParams.put("after_click_state", after_click_state);
        buildElementParams.put("current_state", current_state);
        VideoReport.reportEvent("dt_clck", view, buildElementParams);
    }

    @Override // com.tencent.aelight.camera.ae.flashshow.ui.multicamera.AECameraMultiCameraBasePart
    public void A() {
        ViewStub viewStub = (ViewStub) this.rootView.findViewById(R.id.s19);
        if (viewStub != null) {
            viewStub.inflate();
        }
        M();
        String cangLanConfig = ((IQZonePageApi) QRoute.api(IQZonePageApi.class)).getCangLanConfig("qzone_moment_face_mask_resource_url", IAEDownloadMaterial.QZONE_CIKE_CAMERA_DEFAULT_MATERIAL_URL);
        Intrinsics.checkNotNullExpressionValue(cangLanConfig, "api(IQZonePageApi::class\u2026ERA_DEFAULT_MATERIAL_URL)");
        this.materialUrl = cangLanConfig;
        ms.a.a("AECameraMultiCameraTopPart", "materialUrl is: " + cangLanConfig);
        View findViewById = this.rootView.findViewById(R.id.rol);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.beauty_btn)");
        this.beautyBtn = (ImageView) findViewById;
        View findViewById2 = this.rootView.findViewById(R.id.rqj);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.cancel_btn)");
        this.cancleBtn = (ImageView) findViewById2;
        View findViewById3 = this.rootView.findViewById(R.id.ro_);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.id.apply_material)");
        this.applyMaterialBtn = (LinearLayout) findViewById3;
        View findViewById4 = this.rootView.findViewById(R.id.rwu);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "rootView.findViewById(R.id.loading_icon)");
        this.loadingBtn = (ImageView) findViewById4;
        ImageView imageView = this.cancleBtn;
        ImageView imageView2 = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cancleBtn");
            imageView = null;
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.multicamera.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AECameraMultiCameraTopPart.U(AECameraMultiCameraTopPart.this, view);
            }
        });
        ImageView imageView3 = this.beautyBtn;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("beautyBtn");
            imageView3 = null;
        }
        imageView3.setSelected(true);
        ImageView imageView4 = this.beautyBtn;
        if (imageView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("beautyBtn");
        } else {
            imageView2 = imageView4;
        }
        imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.multicamera.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AECameraMultiCameraTopPart.V(AECameraMultiCameraTopPart.this, view);
            }
        });
        P();
    }

    @Override // com.tencent.aelight.camera.ae.flashshow.ui.multicamera.AECameraMultiCameraBasePart
    public void B() {
        ms.a.a("AECameraMultiCameraTopPart", "onMaterialDownloaded isDeviceSupport: " + this.isDeviceSupport);
        if (this.isDeviceSupport) {
            Drawable drawable = ContextCompat.getDrawable(this.activity, R.drawable.iuw);
            ImageView imageView = this.loadingBtn;
            LinearLayout linearLayout = null;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("loadingBtn");
                imageView = null;
            }
            imageView.setImageDrawable(drawable);
            if (this.defaultSwitchValue) {
                LinearLayout linearLayout2 = this.applyMaterialBtn;
                if (linearLayout2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("applyMaterialBtn");
                } else {
                    linearLayout = linearLayout2;
                }
                linearLayout.setBackground(ContextCompat.getDrawable(this.activity, R.drawable.isi));
                AEQZoneMaterialMetaData aEQZoneMaterialMetaData = this.qZoneMaterial;
                if (aEQZoneMaterialMetaData != null) {
                    q().L1(aEQZoneMaterialMetaData.f69050id, AEMaterialManager.F(aEQZoneMaterialMetaData));
                }
            }
        }
    }

    @Override // com.tencent.aelight.camera.ae.flashshow.ui.multicamera.AECameraMultiCameraBasePart
    public void C(AEVideoStoryTopBarViewModel.Ratio ratio, int cameraHeight, int cameraWith) {
        Intrinsics.checkNotNullParameter(ratio, "ratio");
    }

    /* renamed from: O, reason: from getter */
    public final Activity getActivity() {
        return this.activity;
    }

    @Override // com.tencent.aelight.camera.ae.flashshow.ui.multicamera.AECameraMultiCameraBasePart
    public void s() {
        ImageView imageView = this.beautyBtn;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("beautyBtn");
            imageView = null;
        }
        com.tencent.aelight.camera.aebase.c.a(imageView, "em_bas_beauty_switch");
    }

    @Override // com.tencent.aelight.camera.ae.flashshow.ui.multicamera.AECameraMultiCameraBasePart
    public void x(int selectCamera) {
        ImageView imageView = this.beautyBtn;
        LinearLayout linearLayout = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("beautyBtn");
            imageView = null;
        }
        imageView.setVisibility(8);
        ImageView imageView2 = this.cancleBtn;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cancleBtn");
            imageView2 = null;
        }
        imageView2.setVisibility(8);
        if (this.isDeviceSupport) {
            ms.a.a("AECameraMultiCameraTopPart", "onCameraCountingDownUIShow applyMaterialBtn gone");
            LinearLayout linearLayout2 = this.applyMaterialBtn;
            if (linearLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("applyMaterialBtn");
            } else {
                linearLayout = linearLayout2;
            }
            linearLayout.setVisibility(8);
        }
    }

    @Override // com.tencent.aelight.camera.ae.flashshow.ui.multicamera.AECameraMultiCameraBasePart
    public void y(HashMap<String, String> map) {
        ImageView imageView = this.beautyBtn;
        ImageView imageView2 = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("beautyBtn");
            imageView = null;
        }
        imageView.setVisibility(8);
        ImageView imageView3 = this.cancleBtn;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cancleBtn");
        } else {
            imageView2 = imageView3;
        }
        imageView2.setVisibility(0);
    }

    @Override // com.tencent.aelight.camera.ae.flashshow.ui.multicamera.AECameraMultiCameraBasePart
    public void z() {
        ImageView imageView = this.beautyBtn;
        LinearLayout linearLayout = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("beautyBtn");
            imageView = null;
        }
        imageView.setVisibility(0);
        ImageView imageView2 = this.cancleBtn;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cancleBtn");
            imageView2 = null;
        }
        imageView2.setVisibility(8);
        if (this.isDeviceSupport) {
            LinearLayout linearLayout2 = this.applyMaterialBtn;
            if (linearLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("applyMaterialBtn");
            } else {
                linearLayout = linearLayout2;
            }
            linearLayout.setVisibility(0);
        }
    }
}
