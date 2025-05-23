package com.tencent.aelight.camera.ae.flashshow.ui;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.aelight.camera.ae.camera.ui.bubble.BubbleTextView;
import com.tencent.aelight.camera.ae.camera.ui.panel.AEProviderViewModel;
import com.tencent.aelight.camera.ae.camera.ui.panel.BeautyItem;
import com.tencent.aelight.camera.ae.camera.ui.panel.BeautySecondaryItem;
import com.tencent.aelight.camera.ae.camera.ui.topbar.AEVideoStoryTopBarViewModel;
import com.tencent.aelight.camera.ae.data.AEMaterialManager;
import com.tencent.aelight.camera.ae.download.AEResUtil;
import com.tencent.aelight.camera.ae.flashshow.AEFlashShowCameraUnit;
import com.tencent.aelight.camera.ae.flashshow.ui.AEFlashCameraCaptureButtonLayout;
import com.tencent.aelight.camera.ae.flashshow.ui.AEFlashShowBottomPart;
import com.tencent.aelight.camera.ae.flashshow.ui.AEFlashShowMaterialPanel;
import com.tencent.aelight.camera.ae.flashshow.ui.captureButton.a;
import com.tencent.aelight.camera.ae.flashshow.ui.common.StartPointSeekBar;
import com.tencent.aelight.camera.ae.flashshow.ui.panel.LSBeautyAndFilterPanelViewStubHolder;
import com.tencent.aelight.camera.ae.flashshow.ui.view.LSCountDownView;
import com.tencent.aelight.camera.ae.flashshow.util.AEMaterialUtilKt;
import com.tencent.aelight.camera.ae.util.AECameraPrefsUtil;
import com.tencent.aelight.camera.ae.util.AEGuideVideoUtil;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.aelight.camera.download.api.AEResInfo;
import com.tencent.aelight.camera.struct.camera.material.AEMaterialCategory;
import com.tencent.aelight.camera.struct.camera.material.AEMaterialMetaData;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.biz.richframework.part.utils.FastClickUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.view.PermissionRequestDialog;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.tip.QUIDefaultBubbleTip;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.editor.music.viewmodel.MusicSourceViewModel;
import com.tencent.mobileqq.wink.editor.music.viewmodel.MusicVolumeControlViewModel;
import com.tencent.mobileqq.wink.editor.music.vo.WinkEditorMusicInfo;
import com.tencent.mobileqq.wink.view.QCircleCommonLoadingDialog;
import com.tencent.mobileqq.winkpublish.report.WinkDc5507ReportData;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkDatongCurrentParams;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import cooperation.qqcircle.report.datong.WinkMaterialGuideUtils;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.DebugKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes32.dex */
public class AEFlashShowBottomPart extends lq.a implements StartPointSeekBar.a {
    private boolean A0;
    private boolean B0;
    private AEVideoStoryTopBarViewModel C;
    private boolean C0;
    private AEFlashShowBottomPanelViewModel D;
    private boolean D0;
    private LSCountDownView E;
    private AEFlashCameraCaptureButtonLayout.j E0;
    private AEFlashCameraCaptureButtonLayout F;
    private ab G;
    private com.tencent.aelight.camera.ae.part.a H;
    private AEFlashShowBottomPanelViewModel I;
    private MusicSourceViewModel J;
    private MusicVolumeControlViewModel K;
    private com.tencent.aelight.camera.ae.e L;
    private com.tencent.aelight.camera.ae.camera.ui.panel.aa M;
    private com.tencent.aelight.camera.ae.flashshow.ui.e N;
    private ImageView P;
    private boolean Q;
    private boolean R;
    private AEMaterialMetaData S;
    private AEFlashShowMaterialManager T;
    public int U;
    boolean V;
    boolean W;
    private boolean X;
    private View Y;
    private AEFlashShowMaterialFavoriteView Z;

    /* renamed from: a0, reason: collision with root package name */
    private FrameLayout f64437a0;

    /* renamed from: b0, reason: collision with root package name */
    private AEFlashShowMaterialPanel f64438b0;

    /* renamed from: c0, reason: collision with root package name */
    private RelativeLayout f64439c0;

    /* renamed from: d0, reason: collision with root package name */
    private StartPointSeekBar f64440d0;

    /* renamed from: e0, reason: collision with root package name */
    private TextView f64441e0;

    /* renamed from: f0, reason: collision with root package name */
    private View f64442f0;

    /* renamed from: g0, reason: collision with root package name */
    private BubbleTextView f64443g0;

    /* renamed from: h0, reason: collision with root package name */
    private View f64444h0;

    /* renamed from: i0, reason: collision with root package name */
    private ImageView f64445i0;

    /* renamed from: j0, reason: collision with root package name */
    private LSBeautyAndFilterPanelViewStubHolder f64446j0;

    /* renamed from: k0, reason: collision with root package name */
    private View f64447k0;

    /* renamed from: l0, reason: collision with root package name */
    private AEFlashShowFilterPanelViewHolder f64448l0;

    /* renamed from: m, reason: collision with root package name */
    private AEFlashShowCameraUnit f64449m;

    /* renamed from: m0, reason: collision with root package name */
    private String f64450m0;

    /* renamed from: n0, reason: collision with root package name */
    private String f64451n0;

    /* renamed from: o0, reason: collision with root package name */
    private boolean f64452o0;

    /* renamed from: p0, reason: collision with root package name */
    private String f64453p0;

    /* renamed from: q0, reason: collision with root package name */
    private boolean f64454q0;

    /* renamed from: r0, reason: collision with root package name */
    private boolean f64455r0;

    /* renamed from: s0, reason: collision with root package name */
    private QCircleCommonLoadingDialog f64456s0;

    /* renamed from: t0, reason: collision with root package name */
    private Dialog f64457t0;

    /* renamed from: u0, reason: collision with root package name */
    private boolean f64458u0;

    /* renamed from: v0, reason: collision with root package name */
    private boolean f64459v0;

    /* renamed from: w0, reason: collision with root package name */
    private VideoMaterial f64460w0;

    /* renamed from: x0, reason: collision with root package name */
    private boolean f64461x0;

    /* renamed from: y0, reason: collision with root package name */
    private boolean f64462y0;

    /* renamed from: z0, reason: collision with root package name */
    private EntranceRunnable f64463z0;

    /* renamed from: com.tencent.aelight.camera.ae.flashshow.ui.AEFlashShowBottomPart$27, reason: invalid class name */
    /* loaded from: classes32.dex */
    class AnonymousClass27 implements Runnable {
        final /* synthetic */ AEFlashShowBottomPart this$0;

        @Override // java.lang.Runnable
        public void run() {
            View view = this.this$0.f64442f0;
            if (view != null) {
                ViewGroup.LayoutParams layoutParams = this.this$0.f64443g0.getLayoutParams();
                if (layoutParams instanceof RelativeLayout.LayoutParams) {
                    Rect rect = new Rect();
                    view.getGlobalVisibleRect(rect);
                    ((RelativeLayout.LayoutParams) layoutParams).leftMargin = ((rect.left + rect.right) / 2) - (this.this$0.f64443g0.getMeasuredWidth() / 2);
                    this.this$0.f64443g0.setLayoutParams(layoutParams);
                    this.this$0.f64443g0.setVisibility(0);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class EntranceRunnable implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        private AEMaterialMetaData f64470d;

        /* renamed from: e, reason: collision with root package name */
        boolean f64471e;

        public EntranceRunnable(AEMaterialMetaData aEMaterialMetaData, boolean z16) {
            this.f64470d = aEMaterialMetaData;
            this.f64471e = z16;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.tencent.aelight.camera.ae.flashshow.util.e.b(this.f64470d)) {
                ms.a.a("AEFlashShowBottomPart", "initMaterialThumb = " + this.f64470d.toString());
                if (((lq.a) AEFlashShowBottomPart.this).f415377f != null) {
                    com.tencent.aelight.camera.ae.flashshow.util.v.c(AEFlashShowBottomPart.this.P, this.f64470d.iconurl, com.tencent.aelight.camera.ae.flashshow.util.v.a(AEFlashShowBottomPart.this.P.getContext(), 40.0f), com.tencent.aelight.camera.ae.flashshow.util.v.a(AEFlashShowBottomPart.this.P.getContext(), 40.0f), ((lq.a) AEFlashShowBottomPart.this).f415377f.getResources().getDrawable(R.drawable.ixm), null);
                }
                AEFlashShowBottomPart aEFlashShowBottomPart = AEFlashShowBottomPart.this;
                aEFlashShowBottomPart.N0(aEFlashShowBottomPart.P);
                if (this.f64471e) {
                    return;
                }
                AEFlashShowBottomPart.this.R = false;
                return;
            }
            AEFlashShowBottomPart.this.P.setImageResource(R.drawable.ixm);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (com.tencent.mobileqq.utils.u.a().b()) {
                ms.a.f("AEFlashShowBottomPart", "onShareCLicked too fast");
            } else {
                ms.a.f("AEFlashShowBottomPart", "mProtocolBtn  onClick");
                if (FastClickUtils.isFastDoubleClick("launchFSHybirdActivity:https://rule.tencent.com/rule/202312250003", 1500L)) {
                    ms.a.f("AEFlashShowBottomPart", "launchFSHybirdActivity is fast double click");
                } else {
                    try {
                        Intent intent = new Intent();
                        intent.putExtra("url", "https://rule.tencent.com/rule/202312250003");
                        intent.setFlags(268435456);
                        RouteUtils.startActivity(BaseApplication.getContext(), intent, RouterConstants.UI_ROUTE_BROWSER);
                    } catch (Exception e16) {
                        ms.a.b("AEFlashShowBottomPart", "startActivity error:", e16);
                    }
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class aa implements dr {
        aa() {
        }

        @Override // com.tencent.aelight.camera.ae.flashshow.ui.dr
        public void a() {
            if (o83.a.f422212a.d()) {
                AEFlashShowBottomPart.this.f64438b0.D();
            } else {
                AEFlashShowBottomPart.this.f64438b0.C();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class c implements Observer<Boolean> {
        c() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(Boolean bool) {
            ms.a.a("AEFlashShowBottomPart", "takesame: already need ");
            AEFlashShowBottomPart.this.I0(true);
            AEFlashShowBottomPart.this.F1();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class d implements Observer<Boolean> {
        d() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(Boolean bool) {
            if (bool.booleanValue()) {
                AEFlashShowBottomPart aEFlashShowBottomPart = AEFlashShowBottomPart.this;
                if (aEFlashShowBottomPart.W) {
                    aEFlashShowBottomPart.W = false;
                }
            }
        }
    }

    /* loaded from: classes32.dex */
    class e implements AEFlashCameraCaptureButtonLayout.j {
        e() {
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x006f  */
        /* JADX WARN: Removed duplicated region for block: B:15:0x0089  */
        /* JADX WARN: Removed duplicated region for block: B:18:0x00af  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x0130  */
        /* JADX WARN: Removed duplicated region for block: B:31:0x013e  */
        /* JADX WARN: Removed duplicated region for block: B:34:0x0154  */
        /* JADX WARN: Removed duplicated region for block: B:37:0x03ec  */
        /* JADX WARN: Removed duplicated region for block: B:40:0x040b  */
        /* JADX WARN: Removed duplicated region for block: B:44:0x03f0  */
        /* JADX WARN: Removed duplicated region for block: B:45:0x0157  */
        /* JADX WARN: Removed duplicated region for block: B:46:0x0132  */
        /* JADX WARN: Removed duplicated region for block: B:48:0x00b3  */
        /* JADX WARN: Removed duplicated region for block: B:49:0x0090  */
        /* JADX WARN: Removed duplicated region for block: B:50:0x0071  */
        @Override // com.tencent.aelight.camera.ae.flashshow.ui.AEFlashCameraCaptureButtonLayout.j
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void a() {
            String str;
            String str2;
            Object obj;
            WinkEditorMusicInfo currentMusic;
            boolean z16;
            String str3;
            String str4;
            com.tencent.aelight.camera.ae.r value;
            String str5;
            boolean c16;
            Object obj2;
            MetaMaterial value2;
            String str6;
            String str7;
            com.tencent.aelight.camera.ae.camera.ui.panel.bj value3;
            AEMaterialMetaData aEMaterialMetaData;
            ms.a.f("AEFlashShowBottomPart", " startCaptureCallBack");
            HashMap<String, Object> g16 = com.tencent.aelight.camera.ae.flashshow.ab.c().g();
            if (com.tencent.aelight.camera.ae.flashshow.util.a.a() == 2) {
                str = "back";
            } else {
                str = "front";
            }
            g16.put("xsj_camera", str);
            WinkDatongCurrentParams.params.put("xsj_camera", str);
            AEVideoStoryTopBarViewModel.a value4 = AEFlashShowBottomPart.this.C.M1().getValue();
            int a16 = value4 != null ? value4.a() : 0;
            String str8 = "none";
            if (a16 != 0) {
                if (a16 == 3) {
                    str2 = "3";
                } else if (a16 == 10) {
                    str2 = "10";
                }
                g16.put("xsj_countdown", str2);
                WinkDatongCurrentParams.params.put("xsj_countdown", str2);
                String str9 = "on";
                if (!com.tencent.aelight.camera.ae.flashshow.util.a.c()) {
                    obj = "on";
                } else {
                    obj = DebugKt.DEBUG_PROPERTY_VALUE_OFF;
                }
                g16.put("xsj_flash", obj);
                WinkDatongCurrentParams.params.put("xsj_flash", obj);
                currentMusic = AEFlashShowBottomPart.this.J.getCurrentMusic();
                if (currentMusic != null) {
                    z16 = false;
                    str3 = "none";
                } else {
                    str3 = currentMusic.q();
                    z16 = currentMusic.f321263m;
                }
                ms.a.f("AEFlashShowBottomPart", " startCaptureCallBack... music:" + str3);
                g16.put("xsj_music_name_camera", str3);
                if (!z16) {
                    str4 = WinkDaTongReportConstant.ElementParamValue.MUSIC_FROM_RECOMD;
                } else {
                    str4 = WinkDaTongReportConstant.ElementParamValue.MUSIC_FROM_LIBRARY;
                }
                g16.put(WinkDaTongReportConstant.ElementParamKey.XSJ_MUSIC_FROM, str4);
                g16.put(WinkDaTongReportConstant.ElementParamKey.XSJ_MUSIC_IS_DEFAULT, "0");
                g16.put(WinkDaTongReportConstant.ElementParamKey.XSJ_MUSIC_VOLUME_VALUE, String.valueOf(AEFlashShowBottomPart.this.K.T1().getValue()));
                g16.put(WinkDaTongReportConstant.ElementParamKey.XSJ_ORIGINAL_VOLUME_VALUE, String.valueOf(AEFlashShowBottomPart.this.K.h2().getValue()));
                value = AEFlashShowBottomPart.this.L.P1().getValue();
                if (value != null || value.getType() != 4 || (aEMaterialMetaData = value.getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.KEY_MATERIAL java.lang.String()) == null) {
                    str5 = "none";
                } else {
                    str5 = aEMaterialMetaData.f69050id;
                }
                g16.put(WinkDaTongReportConstant.ElementParamKey.XSJ_PROPS_NAME, str5);
                WinkDatongCurrentParams.params.put(WinkDaTongReportConstant.ElementParamKey.XSJ_PROPS_NAME, str5);
                c16 = AECameraPrefsUtil.f().c(AECameraConstants.SP_KEY_AE_CAMERA_AUTO_BEAUTY_SWITCH, false, 0);
                if (!c16) {
                    obj2 = "on";
                } else {
                    obj2 = DebugKt.DEBUG_PROPERTY_VALUE_OFF;
                }
                g16.put("xsj_beauty_ai", obj2);
                HashMap<String, Object> hashMap = WinkDatongCurrentParams.params;
                if (!c16) {
                    str9 = DebugKt.DEBUG_PROPERTY_VALUE_OFF;
                }
                hashMap.put("xsj_beauty_ai", str9);
                value2 = AEFlashShowBottomPart.this.N.U1().getValue();
                if (value2 != null) {
                    str6 = "none";
                } else {
                    str6 = value2.f30533id;
                }
                g16.put(WinkDaTongReportConstant.ElementParamKey.XSJ_FILTER_NAME_CAMERA, str6);
                WinkDatongCurrentParams.params.put(WinkDaTongReportConstant.ElementParamKey.XSJ_FILTER_NAME_CAMERA, str6);
                String valueOf = String.valueOf(AEProviderViewModel.t2(new com.tencent.aelight.camera.ae.camera.ui.panel.b(BeautyItem.SKIN)));
                g16.put("xsj_skin_value", valueOf);
                WinkDatongCurrentParams.params.put("xsj_skin_value", valueOf);
                String valueOf2 = String.valueOf(AEProviderViewModel.t2(new com.tencent.aelight.camera.ae.camera.ui.panel.b(BeautyItem.EYE)));
                g16.put("xsj_eyes_value", valueOf2);
                WinkDatongCurrentParams.params.put("xsj_eyes_value", valueOf2);
                int t26 = AEProviderViewModel.t2(new com.tencent.aelight.camera.ae.camera.ui.panel.b(BeautyItem.EYE_MAKEUP));
                g16.put("xsj_eye_makeup_value", String.valueOf(t26));
                WinkDatongCurrentParams.params.put("xsj_eye_makeup_value", String.valueOf(t26));
                int t27 = AEProviderViewModel.t2(new com.tencent.aelight.camera.ae.camera.ui.panel.b(BeautyItem.LUT_CLEAR_ALPHA));
                g16.put("xsj_qingxi_value", String.valueOf(t27));
                WinkDatongCurrentParams.params.put("xsj_qingxi_value", String.valueOf(t27));
                WinkDatongCurrentParams.params.put("xsj_clear_value", String.valueOf(t27));
                int t28 = AEProviderViewModel.t2(new com.tencent.aelight.camera.ae.camera.ui.panel.b(BeautyItem.LUT_FOUNDATION_ALPHA));
                g16.put("xsj_meibai_value", String.valueOf(t28));
                WinkDatongCurrentParams.params.put("xsj_meibai_value", String.valueOf(t28));
                int t29 = AEProviderViewModel.t2(new com.tencent.aelight.camera.ae.camera.ui.panel.b(BeautyItem.FACE_SMALLER));
                g16.put("xsj_xiaolian_value", String.valueOf(t29));
                WinkDatongCurrentParams.params.put("xsj_xiaolian_value", String.valueOf(t29));
                int t210 = AEProviderViewModel.t2(new com.tencent.aelight.camera.ae.camera.ui.panel.b(BeautyItem.FACE_THIN));
                g16.put("xsj_zhailian_value", String.valueOf(t210));
                WinkDatongCurrentParams.params.put("xsj_zhailian_value", String.valueOf(t210));
                int t211 = AEProviderViewModel.t2(new com.tencent.aelight.camera.ae.camera.ui.panel.b(BeautyItem.CHEEKBONE_THIN));
                g16.put("xsj_shouquangu_value", String.valueOf(t211));
                WinkDatongCurrentParams.params.put("xsj_shouquangu_value", String.valueOf(t211));
                int t212 = AEProviderViewModel.t2(new com.tencent.aelight.camera.ae.camera.ui.panel.b(BeautyItem.MOUTH_SHAPE));
                g16.put("xsj_zuixing_value", String.valueOf(t212));
                WinkDatongCurrentParams.params.put("xsj_zuixing_value", String.valueOf(t212));
                int t213 = AEProviderViewModel.t2(new com.tencent.aelight.camera.ae.camera.ui.panel.b(BeautyItem.FOREHEAD));
                g16.put("xsj_etou_value", String.valueOf(t213));
                WinkDatongCurrentParams.params.put("xsj_etou_value", String.valueOf(t213));
                int t214 = AEProviderViewModel.t2(new com.tencent.aelight.camera.ae.camera.ui.panel.b(BeautyItem.FACE_FEATURE_LIPS_LUT_ALPHA));
                g16.put("xsj_kouhong_value", String.valueOf(t214));
                WinkDatongCurrentParams.params.put("xsj_kouhong_value", String.valueOf(t214));
                int t215 = AEProviderViewModel.t2(new com.tencent.aelight.camera.ae.camera.ui.panel.b(BeautyItem.FACE_FEATURE_REDCHEEK));
                g16.put("xsj_saihong_value", String.valueOf(t215));
                WinkDatongCurrentParams.params.put("xsj_saihong_value", String.valueOf(t215));
                int t216 = AEProviderViewModel.t2(new com.tencent.aelight.camera.ae.camera.ui.panel.b(BeautyItem.REMOVE_WRINKLES2));
                g16.put("xsj_falingwen_value", String.valueOf(t216));
                WinkDatongCurrentParams.params.put("xsj_falingwen_value", String.valueOf(t216));
                int t217 = AEProviderViewModel.t2(new com.tencent.aelight.camera.ae.camera.ui.panel.b(BeautyItem.FACE_FEATURE_SOFT));
                g16.put("xsj_liti_value", String.valueOf(t217));
                WinkDatongCurrentParams.params.put("xsj_liti_value", String.valueOf(t217));
                int t218 = AEProviderViewModel.t2(new com.tencent.aelight.camera.ae.camera.ui.panel.b(BeautyItem.TOOTH_WHITEN));
                g16.put("xsj_baiya_value", String.valueOf(t218));
                WinkDatongCurrentParams.params.put("xsj_baiya_value", String.valueOf(t218));
                int t219 = AEProviderViewModel.t2(new com.tencent.aelight.camera.ae.camera.ui.panel.b(BeautyItem.REMOVE_POUNCH));
                g16.put("xsj_heiyanquan_value", String.valueOf(t219));
                WinkDatongCurrentParams.params.put("xsj_heiyanquan_value", String.valueOf(t219));
                int t220 = AEProviderViewModel.t2(new com.tencent.aelight.camera.ae.camera.ui.panel.b(BeautyItem.NOSE));
                g16.put("xsj_shoubi_value", String.valueOf(t220));
                WinkDatongCurrentParams.params.put("xsj_shoubi_value", String.valueOf(t220));
                int t221 = AEProviderViewModel.t2(new com.tencent.aelight.camera.ae.camera.ui.panel.f(BeautySecondaryItem.SUB_THIN_FACE_NATURE));
                g16.put("xsj_ziran_value", String.valueOf(t221));
                WinkDatongCurrentParams.params.put("xsj_ziran_value", String.valueOf(t221));
                int t222 = AEProviderViewModel.t2(new com.tencent.aelight.camera.ae.camera.ui.panel.f(BeautySecondaryItem.SUB_THIN_FACE_GIRL));
                g16.put("xsj_qizhi_value", String.valueOf(t222));
                WinkDatongCurrentParams.params.put("xsj_qizhi_value", String.valueOf(t222));
                int t223 = AEProviderViewModel.t2(new com.tencent.aelight.camera.ae.camera.ui.panel.f(BeautySecondaryItem.SUB_THIN_FACE_BOY));
                g16.put("xsj_yingjun_value", String.valueOf(t223));
                WinkDatongCurrentParams.params.put("xsj_yingjun_value", String.valueOf(t223));
                if (AEFlashShowBottomPart.this.G.f64707i.getValue() != AEFlashCameraCaptureButtonLayout.Style.VIDEO_STYLE) {
                    str7 = "video";
                } else {
                    str7 = "pic";
                }
                g16.put("xsj_shoot_type", str7);
                value3 = AEFlashShowBottomPart.this.M.N1().getValue();
                if (value3 != null) {
                    str8 = value3.getId();
                }
                g16.put("xsj_makeup_name", str8);
                VideoReport.reportEvent("ev_xsj_camera_action", AEFlashShowBottomPart.this.F, g16);
            }
            str2 = "none";
            g16.put("xsj_countdown", str2);
            WinkDatongCurrentParams.params.put("xsj_countdown", str2);
            String str92 = "on";
            if (!com.tencent.aelight.camera.ae.flashshow.util.a.c()) {
            }
            g16.put("xsj_flash", obj);
            WinkDatongCurrentParams.params.put("xsj_flash", obj);
            currentMusic = AEFlashShowBottomPart.this.J.getCurrentMusic();
            if (currentMusic != null) {
            }
            ms.a.f("AEFlashShowBottomPart", " startCaptureCallBack... music:" + str3);
            g16.put("xsj_music_name_camera", str3);
            if (!z16) {
            }
            g16.put(WinkDaTongReportConstant.ElementParamKey.XSJ_MUSIC_FROM, str4);
            g16.put(WinkDaTongReportConstant.ElementParamKey.XSJ_MUSIC_IS_DEFAULT, "0");
            g16.put(WinkDaTongReportConstant.ElementParamKey.XSJ_MUSIC_VOLUME_VALUE, String.valueOf(AEFlashShowBottomPart.this.K.T1().getValue()));
            g16.put(WinkDaTongReportConstant.ElementParamKey.XSJ_ORIGINAL_VOLUME_VALUE, String.valueOf(AEFlashShowBottomPart.this.K.h2().getValue()));
            value = AEFlashShowBottomPart.this.L.P1().getValue();
            if (value != null) {
            }
            str5 = "none";
            g16.put(WinkDaTongReportConstant.ElementParamKey.XSJ_PROPS_NAME, str5);
            WinkDatongCurrentParams.params.put(WinkDaTongReportConstant.ElementParamKey.XSJ_PROPS_NAME, str5);
            c16 = AECameraPrefsUtil.f().c(AECameraConstants.SP_KEY_AE_CAMERA_AUTO_BEAUTY_SWITCH, false, 0);
            if (!c16) {
            }
            g16.put("xsj_beauty_ai", obj2);
            HashMap<String, Object> hashMap2 = WinkDatongCurrentParams.params;
            if (!c16) {
            }
            hashMap2.put("xsj_beauty_ai", str92);
            value2 = AEFlashShowBottomPart.this.N.U1().getValue();
            if (value2 != null) {
            }
            g16.put(WinkDaTongReportConstant.ElementParamKey.XSJ_FILTER_NAME_CAMERA, str6);
            WinkDatongCurrentParams.params.put(WinkDaTongReportConstant.ElementParamKey.XSJ_FILTER_NAME_CAMERA, str6);
            String valueOf3 = String.valueOf(AEProviderViewModel.t2(new com.tencent.aelight.camera.ae.camera.ui.panel.b(BeautyItem.SKIN)));
            g16.put("xsj_skin_value", valueOf3);
            WinkDatongCurrentParams.params.put("xsj_skin_value", valueOf3);
            String valueOf22 = String.valueOf(AEProviderViewModel.t2(new com.tencent.aelight.camera.ae.camera.ui.panel.b(BeautyItem.EYE)));
            g16.put("xsj_eyes_value", valueOf22);
            WinkDatongCurrentParams.params.put("xsj_eyes_value", valueOf22);
            int t262 = AEProviderViewModel.t2(new com.tencent.aelight.camera.ae.camera.ui.panel.b(BeautyItem.EYE_MAKEUP));
            g16.put("xsj_eye_makeup_value", String.valueOf(t262));
            WinkDatongCurrentParams.params.put("xsj_eye_makeup_value", String.valueOf(t262));
            int t272 = AEProviderViewModel.t2(new com.tencent.aelight.camera.ae.camera.ui.panel.b(BeautyItem.LUT_CLEAR_ALPHA));
            g16.put("xsj_qingxi_value", String.valueOf(t272));
            WinkDatongCurrentParams.params.put("xsj_qingxi_value", String.valueOf(t272));
            WinkDatongCurrentParams.params.put("xsj_clear_value", String.valueOf(t272));
            int t282 = AEProviderViewModel.t2(new com.tencent.aelight.camera.ae.camera.ui.panel.b(BeautyItem.LUT_FOUNDATION_ALPHA));
            g16.put("xsj_meibai_value", String.valueOf(t282));
            WinkDatongCurrentParams.params.put("xsj_meibai_value", String.valueOf(t282));
            int t292 = AEProviderViewModel.t2(new com.tencent.aelight.camera.ae.camera.ui.panel.b(BeautyItem.FACE_SMALLER));
            g16.put("xsj_xiaolian_value", String.valueOf(t292));
            WinkDatongCurrentParams.params.put("xsj_xiaolian_value", String.valueOf(t292));
            int t2102 = AEProviderViewModel.t2(new com.tencent.aelight.camera.ae.camera.ui.panel.b(BeautyItem.FACE_THIN));
            g16.put("xsj_zhailian_value", String.valueOf(t2102));
            WinkDatongCurrentParams.params.put("xsj_zhailian_value", String.valueOf(t2102));
            int t2112 = AEProviderViewModel.t2(new com.tencent.aelight.camera.ae.camera.ui.panel.b(BeautyItem.CHEEKBONE_THIN));
            g16.put("xsj_shouquangu_value", String.valueOf(t2112));
            WinkDatongCurrentParams.params.put("xsj_shouquangu_value", String.valueOf(t2112));
            int t2122 = AEProviderViewModel.t2(new com.tencent.aelight.camera.ae.camera.ui.panel.b(BeautyItem.MOUTH_SHAPE));
            g16.put("xsj_zuixing_value", String.valueOf(t2122));
            WinkDatongCurrentParams.params.put("xsj_zuixing_value", String.valueOf(t2122));
            int t2132 = AEProviderViewModel.t2(new com.tencent.aelight.camera.ae.camera.ui.panel.b(BeautyItem.FOREHEAD));
            g16.put("xsj_etou_value", String.valueOf(t2132));
            WinkDatongCurrentParams.params.put("xsj_etou_value", String.valueOf(t2132));
            int t2142 = AEProviderViewModel.t2(new com.tencent.aelight.camera.ae.camera.ui.panel.b(BeautyItem.FACE_FEATURE_LIPS_LUT_ALPHA));
            g16.put("xsj_kouhong_value", String.valueOf(t2142));
            WinkDatongCurrentParams.params.put("xsj_kouhong_value", String.valueOf(t2142));
            int t2152 = AEProviderViewModel.t2(new com.tencent.aelight.camera.ae.camera.ui.panel.b(BeautyItem.FACE_FEATURE_REDCHEEK));
            g16.put("xsj_saihong_value", String.valueOf(t2152));
            WinkDatongCurrentParams.params.put("xsj_saihong_value", String.valueOf(t2152));
            int t2162 = AEProviderViewModel.t2(new com.tencent.aelight.camera.ae.camera.ui.panel.b(BeautyItem.REMOVE_WRINKLES2));
            g16.put("xsj_falingwen_value", String.valueOf(t2162));
            WinkDatongCurrentParams.params.put("xsj_falingwen_value", String.valueOf(t2162));
            int t2172 = AEProviderViewModel.t2(new com.tencent.aelight.camera.ae.camera.ui.panel.b(BeautyItem.FACE_FEATURE_SOFT));
            g16.put("xsj_liti_value", String.valueOf(t2172));
            WinkDatongCurrentParams.params.put("xsj_liti_value", String.valueOf(t2172));
            int t2182 = AEProviderViewModel.t2(new com.tencent.aelight.camera.ae.camera.ui.panel.b(BeautyItem.TOOTH_WHITEN));
            g16.put("xsj_baiya_value", String.valueOf(t2182));
            WinkDatongCurrentParams.params.put("xsj_baiya_value", String.valueOf(t2182));
            int t2192 = AEProviderViewModel.t2(new com.tencent.aelight.camera.ae.camera.ui.panel.b(BeautyItem.REMOVE_POUNCH));
            g16.put("xsj_heiyanquan_value", String.valueOf(t2192));
            WinkDatongCurrentParams.params.put("xsj_heiyanquan_value", String.valueOf(t2192));
            int t2202 = AEProviderViewModel.t2(new com.tencent.aelight.camera.ae.camera.ui.panel.b(BeautyItem.NOSE));
            g16.put("xsj_shoubi_value", String.valueOf(t2202));
            WinkDatongCurrentParams.params.put("xsj_shoubi_value", String.valueOf(t2202));
            int t2212 = AEProviderViewModel.t2(new com.tencent.aelight.camera.ae.camera.ui.panel.f(BeautySecondaryItem.SUB_THIN_FACE_NATURE));
            g16.put("xsj_ziran_value", String.valueOf(t2212));
            WinkDatongCurrentParams.params.put("xsj_ziran_value", String.valueOf(t2212));
            int t2222 = AEProviderViewModel.t2(new com.tencent.aelight.camera.ae.camera.ui.panel.f(BeautySecondaryItem.SUB_THIN_FACE_GIRL));
            g16.put("xsj_qizhi_value", String.valueOf(t2222));
            WinkDatongCurrentParams.params.put("xsj_qizhi_value", String.valueOf(t2222));
            int t2232 = AEProviderViewModel.t2(new com.tencent.aelight.camera.ae.camera.ui.panel.f(BeautySecondaryItem.SUB_THIN_FACE_BOY));
            g16.put("xsj_yingjun_value", String.valueOf(t2232));
            WinkDatongCurrentParams.params.put("xsj_yingjun_value", String.valueOf(t2232));
            if (AEFlashShowBottomPart.this.G.f64707i.getValue() != AEFlashCameraCaptureButtonLayout.Style.VIDEO_STYLE) {
            }
            g16.put("xsj_shoot_type", str7);
            value3 = AEFlashShowBottomPart.this.M.N1().getValue();
            if (value3 != null) {
            }
            g16.put("xsj_makeup_name", str8);
            VideoReport.reportEvent("ev_xsj_camera_action", AEFlashShowBottomPart.this.F, g16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class g implements Observer<Boolean> {
        g() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(Boolean bool) {
            if (!bool.booleanValue() || AEFlashShowBottomPart.this.E == null) {
                return;
            }
            AEFlashShowBottomPart.this.E.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class h implements Observer<AEMaterialMetaData> {
        h() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(AEMaterialMetaData aEMaterialMetaData) {
            ms.a.f("AEFlashShowBottomPart", "SelectMaterialLiveData Changed");
            if (aEMaterialMetaData != null && !aEMaterialMetaData.isNoneMaterial()) {
                if (!AEFlashShowBottomPart.this.f64438b0.getIsOpen()) {
                    AEFlashShowBottomPart.this.Z.setVisibility(8);
                    AEFlashShowBottomPart.this.f64437a0.setVisibility(8);
                } else {
                    AEFlashShowBottomPart.this.Z.setVisibility(0);
                }
            } else {
                AEFlashShowBottomPart.this.Z.setVisibility(8);
                AEFlashShowBottomPart.this.f64437a0.setVisibility(8);
            }
            AEFlashShowBottomPart.this.f64438b0.M();
            AEFlashShowBottomPart.this.Z.setFavorite(AEFlashShowBottomPart.this.f64438b0.x(aEMaterialMetaData));
            AEFlashShowBottomPart.this.b1(aEMaterialMetaData, 0L, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class i implements Observer<AEMaterialMetaData> {
        i() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(AEMaterialMetaData aEMaterialMetaData) {
            AEFlashShowBottomPart.this.Z.setFavorite(AEFlashShowBottomPart.this.f64438b0.x(AEFlashShowBottomPanelViewModel.n2().getValue()));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class j implements Observer<ds> {
        j() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b() {
            AEFlashShowBottomPart.this.q1();
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void onChanged(ds dsVar) {
            if (!dsVar.getShow()) {
                if (AEFlashShowBottomPart.this.f64447k0 != null) {
                    AEFlashShowBottomPart.this.f64447k0.setVisibility(0);
                }
                AEFlashShowBottomPart.this.f64438b0.f(true);
                AEFlashShowBottomPart.this.Z.setVisibility(8);
                AEFlashShowBottomPart.this.f64437a0.setVisibility(8);
                if (AEFlashShowBottomPart.this.f64461x0) {
                    AEFlashShowBottomPart.this.f64439c0.setVisibility(8);
                    return;
                }
                return;
            }
            AEFlashShowBottomPart.this.D.p2(AEFlashShowBottomPart.this.D.j2());
            if (AEFlashShowBottomPart.this.D0) {
                ms.a.f("AEFlashShowBottomPart", "cancel doOpenProviderView with ActivityPaused");
                return;
            }
            String str = dsVar.getCom.tencent.ams.dsdk.core.DKConfiguration.PreloadKeys.KEY_MATERIAL_ID java.lang.String();
            String categoryName = dsVar.getCategoryName();
            AEFlashShowBottomPart.this.f64438b0.u(categoryName, str, (str == null && categoryName == null) ? false : true, true, AEFlashShowBottomPart.this.f64452o0, new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.x
                @Override // java.lang.Runnable
                public final void run() {
                    AEFlashShowBottomPart.j.this.b();
                }
            });
            if (AEFlashShowBottomPart.this.f64461x0) {
                AEFlashShowBottomPart.this.f64439c0.setVisibility(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class k implements Observer<Boolean> {
        k() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(Boolean bool) {
            if (AEFlashShowBottomPart.this.f64446j0 == null) {
                return;
            }
            if (!bool.booleanValue()) {
                if (AEFlashShowBottomPart.this.f64447k0 != null) {
                    AEFlashShowBottomPart.this.f64447k0.setVisibility(0);
                }
                AEFlashShowBottomPart.this.f64446j0.h();
            } else {
                AEFlashShowBottomPart.this.D.p2(AEFlashShowBottomPart.this.D.d2());
                AEFlashShowBottomPart.this.f64446j0.l();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class l implements Observer<Boolean> {
        l() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(Boolean bool) {
            if (AEFlashShowBottomPart.this.f64448l0 == null) {
                return;
            }
            if (!bool.booleanValue()) {
                if (AEFlashShowBottomPart.this.f64447k0 != null) {
                    AEFlashShowBottomPart.this.f64447k0.setVisibility(0);
                }
                AEFlashShowBottomPart.this.f64448l0.f();
            } else {
                AEFlashShowBottomPart.this.D.p2(AEFlashShowBottomPart.this.D.h2());
                AEFlashShowBottomPart.this.f64448l0.show();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class m implements Observer<AEFlashCameraCaptureButtonLayout.Style> {
        m() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(AEFlashCameraCaptureButtonLayout.Style style) {
            String str;
            if (AEFlashShowBottomPart.this.F == null) {
                return;
            }
            AEFlashShowBottomPart.this.F.setCaptureBtnStyle(style);
            if (AEFlashShowBottomPart.this.f64449m.D().o()) {
                AppInterface a16 = com.tencent.aelight.camera.aebase.a.a();
                if (a16 != null) {
                    str = a16.getCurrentAccountUin();
                } else {
                    str = "none";
                }
                int i3 = style.equals(AEFlashCameraCaptureButtonLayout.Style.PIC_STYLE) ? 5 : 1;
                os.a.f423933a.f(AECameraConstants.MMKV_CAMERA_ENTRANCE_EXP_USER_ID_AND_CACHE_VALUE + str, i3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class n implements Observer<Boolean> {
        n() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(Boolean bool) {
            if (AEFlashShowBottomPart.this.Y != null) {
                AEFlashShowBottomPart.this.Y.setVisibility(bool.booleanValue() ? 0 : 8);
            }
            if (AEFlashShowBottomPart.this.f64444h0 == null) {
                AEFlashShowBottomPart.this.y1(Boolean.TRUE.equals(bool));
            } else {
                AEFlashShowBottomPart.this.f64444h0.setVisibility(bool.booleanValue() ? 0 : 8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class o implements Observer<Boolean> {
        o() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(Boolean bool) {
            if (AEFlashShowBottomPart.this.f64447k0 != null) {
                if (!bool.booleanValue()) {
                    AEFlashShowBottomPart.this.f64447k0.setVisibility(8);
                    AEFlashShowBottomPart.this.S0();
                    return;
                }
                AEFlashShowBottomPart.this.f64447k0.setVisibility(0);
                if (AEFlashShowBottomPart.this.Y != null) {
                    AEFlashShowBottomPart.this.Y.setVisibility(8);
                }
                AEFlashShowBottomPart.this.y1(false);
                AEFlashShowBottomPart.this.F.setVisibility(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class p implements Observer<String> {
        p() {
        }

        private String a() {
            com.tencent.aelight.camera.ae.r value = AEFlashShowBottomPart.this.L.P1().getValue();
            if (value == null || value.getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.KEY_MATERIAL java.lang.String() == null) {
                return null;
            }
            return value.getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.KEY_MATERIAL java.lang.String().f69050id;
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onChanged(String str) {
            String a16 = a();
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(a16) || !str.contains(a16)) {
                return;
            }
            AEFlashShowBottomPart.this.D1(str, a16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class q implements ValueAnimator.AnimatorUpdateListener {
        q() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class s implements View.OnClickListener {
        s() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ms.a.a("AEFlashShowBottomPart", "mNeedSelectFirst = " + AEFlashShowBottomPart.this.R + " isFromTakeSame = " + AEFlashShowBottomPart.this.f64458u0);
            if (!AEFlashShowBottomPart.this.R || AEFlashShowBottomPart.this.f64458u0) {
                if (AEFlashShowBottomPart.this.f64458u0) {
                    AEMaterialMetaData M1 = AEFlashShowBottomPart.this.L.M1(4);
                    if (M1 != null) {
                        AEFlashShowBottomPart.this.D.j2().setValue(new ds(true, M1.f69050id, null));
                    }
                } else {
                    AEFlashShowBottomPart.this.D.j2().setValue(new ds(true, null, null));
                }
            } else {
                AEFlashShowBottomPart.this.R = false;
                ms.a.a("AEFlashShowBottomPart", "select first item ");
                AEFlashShowBottomPart.this.S.usable = AEMaterialManager.W(AEFlashShowBottomPart.this.S);
                AEFlashShowBottomPart.this.D.j2().setValue(new ds(true, AEFlashShowBottomPart.this.S.f69050id, null));
            }
            VideoReport.reportEvent("dt_clck", AEFlashShowBottomPart.this.Y, com.tencent.aelight.camera.ae.flashshow.ab.c().e());
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class w implements LSCountDownView.b {
        w() {
        }

        @Override // com.tencent.aelight.camera.ae.flashshow.ui.view.LSCountDownView.b
        public void a() {
            AEFlashShowBottomPart.this.F.setTouchEnable(true);
        }

        @Override // com.tencent.aelight.camera.ae.flashshow.ui.view.LSCountDownView.b
        public void b() {
            AEFlashShowBottomPart.this.F.z();
            AEFlashShowBottomPart.this.F.setTouchEnable(true);
            if (AEFlashShowBottomPart.this.I != null) {
                AEFlashShowBottomPart.this.I.f2().postValue(Boolean.TRUE);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class x implements View.OnClickListener {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes32.dex */
        public class a extends QQPermission.BasePermissionsListener {
            a() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void b(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                AEFlashShowBottomPart.this.Q0();
                EventCollector.getInstance().onViewClicked(view);
            }

            @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
            public void onAllGranted() {
                super.onAllGranted();
                AEFlashShowBottomPart.this.Q0();
            }

            @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
            public void onDeniedWithoutShowDlg(List<String> list, List<Integer> list2) {
                super.onDeniedWithoutShowDlg(list, list2);
                AEFlashShowBottomPart.this.Q0();
            }

            @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
            public void onDialogShow(PermissionRequestDialog permissionRequestDialog, List<String> list) {
                super.onDialogShow(permissionRequestDialog, list);
                permissionRequestDialog.setOnDisAllowClickListener(new View.OnClickListener() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.y
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        AEFlashShowBottomPart.x.a.this.b(view);
                    }
                });
            }
        }

        x() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (AEFlashShowBottomPart.this.f64449m == null) {
                AEFlashShowBottomPart.this.Q0();
            } else if (AEFlashShowBottomPart.this.f64449m.v3(new a())) {
                AEFlashShowBottomPart.this.Q0();
            }
            VideoReport.reportEvent("dt_clck", AEFlashShowBottomPart.this.f64444h0, com.tencent.aelight.camera.ae.flashshow.ab.c().e());
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class y implements DialogInterface.OnDismissListener {
        y() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            AEFlashShowBottomPart.this.R0();
            com.tencent.aelight.camera.ae.report.b.b().J();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class z implements com.tencent.aelight.camera.download.a {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f64503d;

        z(String str) {
            this.f64503d = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b() {
            QQToast.makeText(((lq.a) AEFlashShowBottomPart.this).f415377f, HardCodeUtil.qqStr(R.string.qdx), 0).show();
        }

        @Override // com.tencent.aelight.camera.download.a
        public void onDownloadFinish(AEMaterialMetaData aEMaterialMetaData, boolean z16, int i3) {
            if (AEFlashShowBottomPart.this.f64455r0) {
                return;
            }
            AEFlashShowBottomPart.this.f64459v0 = true;
            if (AEResUtil.U(AEResInfo.LIGHT_RES_BASE_PACKAGE)) {
                ms.a.a("AEFlashShowBottomPart", "takesame: all ready ");
                AEFlashShowBottomPart.this.T0();
            }
            if (aEMaterialMetaData == null) {
                return;
            }
            ms.a.a("AEFlashShowBottomPart", "takesame: material onDownloadFinish ");
            if (z16) {
                AEFlashShowBottomPart.this.w1(this.f64503d, aEMaterialMetaData.f69050id);
            } else {
                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.z
                    @Override // java.lang.Runnable
                    public final void run() {
                        AEFlashShowBottomPart.z.this.b();
                    }
                });
            }
        }

        @Override // com.tencent.aelight.camera.download.a
        public void onProgressUpdate(AEMaterialMetaData aEMaterialMetaData, int i3) {
            AEFlashShowBottomPart.this.G1(i3);
        }
    }

    public AEFlashShowBottomPart(Activity activity, View view, lq.b bVar) {
        super(activity, view, bVar);
        this.Q = true;
        this.R = false;
        this.S = null;
        this.U = P0();
        this.V = false;
        this.W = false;
        this.X = false;
        this.f64451n0 = "";
        this.f64452o0 = false;
        this.f64455r0 = false;
        this.f64458u0 = false;
        this.f64459v0 = false;
        this.f64461x0 = false;
        this.f64462y0 = false;
        this.f64463z0 = null;
        this.C0 = false;
        this.D0 = false;
        this.E0 = new e();
        this.f64449m = (AEFlashShowCameraUnit) bVar.b(65537, new Object[0]);
        Z0();
        t1(activity);
    }

    private void A1(boolean z16) {
        ms.a.a("AEFlashShowBottomPart", "takesame:" + z16);
        if (z16) {
            B1();
        } else {
            C1();
        }
    }

    private void B1() {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.s
            @Override // java.lang.Runnable
            public final void run() {
                AEFlashShowBottomPart.this.m1();
            }
        });
    }

    private void C1() {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.t
            @Override // java.lang.Runnable
            public final void run() {
                AEFlashShowBottomPart.this.o1();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D1(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            ms.a.c("AEFlashShowBottomPart", "showVideoGuid| video path is null.");
            return;
        }
        if (AEGuideVideoUtil.b().c(QQWinkConstants.MATERIAL_GUIDED, str2)) {
            ms.a.f("AEFlashShowBottomPart", "showVideoGuid| video guid has showed.");
            R0();
            return;
        }
        dw dwVar = new dw(this.f64449m.A(), str);
        dwVar.setCanceledOnTouchOutside(false);
        dwVar.setOnDismissListener(new y());
        dwVar.show();
        AEGuideVideoUtil.b().d(QQWinkConstants.MATERIAL_GUIDED, str2);
    }

    private void E1() {
        AEFlashShowCameraUnit aEFlashShowCameraUnit = this.f64449m;
        if (aEFlashShowCameraUnit == null || !aEFlashShowCameraUnit.J3()) {
            return;
        }
        ms.a.f("AEFlashShowBottomPart", "updateAlbumThumb:will check.");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.AEFlashShowBottomPart.5
            @Override // java.lang.Runnable
            public void run() {
                try {
                    final Bitmap b16 = com.tencent.aelight.camera.aebase.f.b(((lq.a) AEFlashShowBottomPart.this).f415377f, true);
                    if (b16 != null && !b16.isRecycled()) {
                        int dip2px = ViewUtils.dip2px(40.0f);
                        Bitmap roundedCornerBitmap3 = BaseImageUtil.getRoundedCornerBitmap3(b16, ViewUtils.dip2px(5.0f), dip2px, dip2px);
                        if (!b16.isRecycled()) {
                            b16.recycle();
                        }
                        b16 = roundedCornerBitmap3;
                    }
                    if (b16 != null && !b16.isRecycled()) {
                        AEFlashShowBottomPart.this.f64462y0 = true;
                        ms.a.f("AEFlashShowBottomPart", "updateAlbumThumb:Successful");
                        ((lq.a) AEFlashShowBottomPart.this).f415377f.runOnUiThread(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.AEFlashShowBottomPart.5.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (b16 == null || AEFlashShowBottomPart.this.f64445i0 == null) {
                                    return;
                                }
                                BitmapDrawable bitmapDrawable = new BitmapDrawable(b16);
                                int dip2px2 = ViewUtils.dip2px(3.0f);
                                AEFlashShowBottomPart.this.f64445i0.setPadding(dip2px2, dip2px2, dip2px2, dip2px2);
                                AEFlashShowBottomPart.this.f64445i0.setImageDrawable(bitmapDrawable);
                            }
                        });
                        return;
                    }
                    ms.a.c("AEFlashShowBottomPart", "updateAlbumThumb:failed.thumbnail is not valid.");
                } catch (Exception e16) {
                    ms.a.c("AEFlashShowBottomPart", "updateAlbumThumb:" + e16.getMessage());
                    e16.printStackTrace();
                }
            }
        }, 64, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F1() {
        List<AEMaterialMetaData> list;
        List<AEMaterialCategory> e16 = AEMaterialUtilKt.e(this.T.A(false), this.f64450m0);
        if (e16 == null || e16.isEmpty() || e16.size() < 2 || (list = e16.get(1).f69044d) == null || list.isEmpty()) {
            return;
        }
        AEMaterialMetaData aEMaterialMetaData = list.get(0);
        if (AEFlashShowMaterialManager.U(aEMaterialMetaData)) {
            aEMaterialMetaData = list.get(1);
        }
        if (aEMaterialMetaData == null) {
            return;
        }
        if (this.S == null) {
            this.R = true;
        }
        this.S = aEMaterialMetaData;
        ms.a.a("AEFlashShowBottomPart", "updateEntranceData");
        u1();
        if (this.P != null) {
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.AEFlashShowBottomPart.1
                @Override // java.lang.Runnable
                public void run() {
                    ms.a.a("AEFlashShowBottomPart", "firstMaterialApply = " + AEFlashShowBottomPart.this.X);
                    if (AEFlashShowBottomPart.this.X) {
                        return;
                    }
                    AEFlashShowBottomPart aEFlashShowBottomPart = AEFlashShowBottomPart.this;
                    aEFlashShowBottomPart.a1(aEFlashShowBottomPart.S);
                    AEFlashShowBottomPart.this.X = true;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G1(final int i3) {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.v
            @Override // java.lang.Runnable
            public final void run() {
                AEFlashShowBottomPart.this.p1(i3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I0(boolean z16) {
        AEMaterialMetaData M0;
        String str;
        ms.a.f("AEFlashShowBottomPart", "applyPresetMaterial, " + this.f64450m0);
        if (!this.f64451n0.isEmpty()) {
            AEMaterialCategory L0 = L0(this.f64451n0);
            if (L0 == null) {
                ms.a.a("AEFlashShowBottomPart", "applyPresetMaterial presetCategory not find");
                z1(z16);
                return;
            } else {
                str = L0.f69047h;
                M0 = AEMaterialUtilKt.c(this.f64450m0, L0);
            }
        } else {
            M0 = M0(this.f64450m0);
            str = null;
        }
        J0(M0, str);
    }

    private void J0(AEMaterialMetaData aEMaterialMetaData, String str) {
        ms.a.f("AEFlashShowBottomPart", "applyPresetMaterialInner takesame material, " + aEMaterialMetaData + " presetCategoryName = " + str);
        if (aEMaterialMetaData == null) {
            if (str != null) {
                w1(str, null);
                return;
            }
            return;
        }
        this.f64451n0 = "";
        this.f64450m0 = null;
        ms.a.f("AEFlashShowBottomPart", "applyPresetMaterialInner takesame presetMaterial = " + aEMaterialMetaData);
        aEMaterialMetaData.usable = AEMaterialManager.W(aEMaterialMetaData);
        AEResInfo aEResInfo = AEResInfo.LIGHT_RES_BASE_PACKAGE;
        boolean U = AEResUtil.U(aEResInfo);
        ms.a.a("AEFlashShowBottomPart", "takesame: showPagDialog " + U);
        if (aEMaterialMetaData.usable) {
            this.f64459v0 = true;
            w1(str, aEMaterialMetaData.f69050id);
            if (AEResUtil.U(aEResInfo)) {
                return;
            }
            ms.a.a("AEFlashShowBottomPart", "takesame: sdk not ready ");
            A1(U);
            return;
        }
        this.f64459v0 = false;
        this.f64455r0 = false;
        ms.a.a("AEFlashShowBottomPart", "takesame: material do not download ");
        A1(U);
        this.T.r0(fr.b.a(), aEMaterialMetaData, new z(str));
    }

    private AEMaterialCategory L0(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return AEMaterialUtilKt.a(str, O0(str));
    }

    private AEMaterialMetaData M0(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return AEMaterialUtilKt.b(str, O0(str));
    }

    private List<AEMaterialCategory> O0(String str) {
        return AEMaterialUtilKt.e(this.T.A(false), str);
    }

    private int P0() {
        return com.tencent.aelight.camera.ae.flashshow.util.v.a(this.f415377f, 200.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R0() {
        com.tencent.aelight.camera.ae.e eVar = this.L;
        if (eVar != null) {
            eVar.X1(QQWinkConstants.MATERIAL_GUIDE_OVER, "{}");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S0() {
        BubbleTextView bubbleTextView = this.f64443g0;
        if (bubbleTextView != null) {
            bubbleTextView.clearAnimation();
            this.f64443g0.setVisibility(4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T0() {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.k
            @Override // java.lang.Runnable
            public final void run() {
                AEFlashShowBottomPart.this.U0();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U0() {
        ms.a.a("AEFlashShowBottomPart", "takesame: dismiss loading dialog ");
        QCircleCommonLoadingDialog qCircleCommonLoadingDialog = this.f64456s0;
        if (qCircleCommonLoadingDialog != null && qCircleCommonLoadingDialog.isShowing()) {
            this.f64456s0.dismiss();
        }
        Dialog dialog = this.f64457t0;
        if (dialog == null || !dialog.isShowing()) {
            return;
        }
        this.f64457t0.dismiss();
    }

    private void V0() {
        ms.a.f("AEFlashShowBottomPart", "initAlbumBtn.");
        this.f64444h0 = this.f415376e.findViewById(R.id.f163729rp1);
        this.f64445i0 = (ImageView) this.f415376e.findViewById(R.id.f163730rp2);
        this.f64444h0.setVisibility(0);
        this.f64444h0.setOnClickListener(new x());
        this.f64444h0.setOnTouchListener(dp.u());
    }

    private void W0() {
        ms.a.f("AEFlashShowBottomPart", "initBeautyBtn.");
        View findViewById = this.f415376e.findViewById(R.id.f163731rp3);
        this.f64442f0 = findViewById;
        findViewById.setVisibility(0);
        this.f64442f0.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.AEFlashShowBottomPart.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                AEFlashShowBottomPart.this.D.d2().setValue(Boolean.TRUE);
                VideoReport.reportEvent("dt_clck", AEFlashShowBottomPart.this.f64442f0, com.tencent.aelight.camera.ae.flashshow.ab.c().e());
                boolean z16 = AEFlashShowBottomPart.this.f64443g0 != null && AEFlashShowBottomPart.this.f64443g0.getVisibility() == 0;
                ms.a.f("AEFlashShowBottomPart", "openBeautyPanel---beautyBubbleShowing=" + z16);
                if (z16) {
                    ThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.AEFlashShowBottomPart.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            AEFlashShowBottomPart.this.f64446j0.i();
                        }
                    }, 250L);
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        });
        this.f64442f0.setOnTouchListener(dp.u());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X0() {
        if (this.E != null) {
            return;
        }
        LSCountDownView lSCountDownView = (LSCountDownView) ((ViewStub) this.f415376e.findViewById(R.id.rm5)).inflate().findViewById(R.id.rm8);
        this.E = lSCountDownView;
        lSCountDownView.setCountDownListener(new w());
    }

    private void Y0() {
        ms.a.f("AEFlashShowBottomPart", "initMaterialBtn");
        View findViewById = this.f415376e.findViewById(R.id.rpb);
        this.Y = findViewById;
        findViewById.setVisibility(0);
        this.Y.setOnClickListener(new s());
        this.Y.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.p
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean f16;
                f16 = AEFlashShowBottomPart.f1(view, motionEvent);
                return f16;
            }
        });
    }

    private void c1(HashMap<String, String> hashMap) {
        AEMaterialMetaData M0;
        String s16 = s1(hashMap, "meterial");
        this.f64450m0 = s16;
        this.f64453p0 = s16;
        if (s16 != null && (M0 = M0(s16)) != null && AEFlashShowMaterialManager.U(M0)) {
            ms.a.f("AEFlashShowBottomPart", "take from same need hide " + this.f64450m0);
            this.f64450m0 = null;
        }
        this.f64451n0 = s1(hashMap, QCircleScheme.AttrQQPublish.SELECT_TAB);
        this.f64452o0 = "1".equals(s1(hashMap, QCircleScheme.AttrQQPublish.HIDE_OTHER_CATE));
        this.A0 = "1".equals(s1(hashMap, QCircleScheme.AttrQQPublish.DISABLE_MOTION));
        this.B0 = "1".equals(s1(hashMap, QCircleScheme.AttrQQPublish.DISABLE_BEAUTY));
        this.f64454q0 = "1".equals(s1(hashMap, QCircleScheme.AttrQQPublish.SUPER_QQ_SHOW_IS_DRESS_OUTFIT));
    }

    private void d1() {
        this.N = (com.tencent.aelight.camera.ae.flashshow.ui.e) com.tencent.aelight.camera.ae.n.a(this.f64449m).get(com.tencent.aelight.camera.ae.flashshow.ui.e.class);
        this.M = (com.tencent.aelight.camera.ae.camera.ui.panel.aa) com.tencent.aelight.camera.ae.n.a(this.f64449m).get(com.tencent.aelight.camera.ae.camera.ui.panel.aa.class);
        this.L = (com.tencent.aelight.camera.ae.e) com.tencent.aelight.camera.ae.n.a(this.f64449m).get(com.tencent.aelight.camera.ae.e.class);
        this.K = (MusicVolumeControlViewModel) com.tencent.aelight.camera.ae.n.a(this.f64449m).get(MusicVolumeControlViewModel.class);
        this.J = (MusicSourceViewModel) com.tencent.aelight.camera.ae.n.a(this.f64449m).get(MusicSourceViewModel.class);
        AEVideoStoryTopBarViewModel aEVideoStoryTopBarViewModel = (AEVideoStoryTopBarViewModel) com.tencent.aelight.camera.ae.n.a(this.f64449m).get(AEVideoStoryTopBarViewModel.class);
        this.C = aEVideoStoryTopBarViewModel;
        aEVideoStoryTopBarViewModel.M1().observe(this.f64449m, new f());
        this.C.N1().observe(this.f64449m, new g());
        AEFlashShowBottomPanelViewModel.n2().observe(this.f64449m, new h());
        AEFlashShowBottomPanelViewModel.g2().observe(this.f64449m, new i());
        AEFlashShowBottomPanelViewModel aEFlashShowBottomPanelViewModel = (AEFlashShowBottomPanelViewModel) com.tencent.aelight.camera.ae.n.a(this.f64449m).get(AEFlashShowBottomPanelViewModel.class);
        this.D = aEFlashShowBottomPanelViewModel;
        aEFlashShowBottomPanelViewModel.j2().observe(this.f64449m, new j());
        this.D.m2().observe(this.f64449m, new Observer<Boolean>() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.AEFlashShowBottomPart.20
            @Override // androidx.lifecycle.Observer
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onChanged(Boolean bool) {
                ms.a.a("AEFlashShowBottomPart", "takesame: sdk already download");
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.AEFlashShowBottomPart.20.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (AEFlashShowBottomPart.this.f64459v0) {
                            ms.a.a("AEFlashShowBottomPart", "takesame: all ready");
                            AEFlashShowBottomPart.this.T0();
                        }
                    }
                });
            }
        });
        this.D.d2().observe(this.f64449m, new k());
        this.D.h2().observe(this.f64449m, new l());
        ab abVar = (ab) com.tencent.aelight.camera.ae.n.a(this.f64449m).get(ab.class);
        this.G = abVar;
        abVar.L1().observe(this.f64449m, new m());
        com.tencent.aelight.camera.ae.part.a aVar = (com.tencent.aelight.camera.ae.part.a) com.tencent.aelight.camera.ae.n.a(this.f64449m).get(com.tencent.aelight.camera.ae.part.a.class);
        this.H = aVar;
        aVar.M1().observe(this.f64449m, new n());
        AEFlashShowBottomPanelViewModel aEFlashShowBottomPanelViewModel2 = (AEFlashShowBottomPanelViewModel) com.tencent.aelight.camera.ae.n.a(this.f64449m).get(AEFlashShowBottomPanelViewModel.class);
        this.I = aEFlashShowBottomPanelViewModel2;
        aEFlashShowBottomPanelViewModel2.e2().observe(this.f64449m, new Observer() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.n
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AEFlashShowBottomPart.this.g1((Pair) obj);
            }
        });
        this.I.f2().observe(this.f64449m, new o());
        this.L.Q1().observe(this.f64449m, new p());
    }

    private void e1() {
        this.f64447k0 = this.f415376e.findViewById(R.id.ru9);
        AEFlashCameraCaptureButtonLayout aEFlashCameraCaptureButtonLayout = (AEFlashCameraCaptureButtonLayout) this.f415376e.findViewById(R.id.rqn);
        this.F = aEFlashCameraCaptureButtonLayout;
        aEFlashCameraCaptureButtonLayout.setStartCallBack(this.E0);
        if (!this.A0) {
            Y0();
        }
        if (!this.B0) {
            if (this.f415377f.getIntent().getBooleanExtra("AECAMERA_TAB_ALBUM_ENTRANCE", true)) {
                W0();
            } else {
                V0();
            }
        }
        View inflate = ((ViewStub) this.f415376e.findViewById(R.id.s1p)).inflate();
        this.Z = (AEFlashShowMaterialFavoriteView) inflate.findViewById(R.id.rua);
        this.f64437a0 = (FrameLayout) inflate.findViewById(R.id.rpe);
        this.Z.setListener(new aa());
        this.f64437a0.setOnClickListener(new a());
        this.f64439c0 = (RelativeLayout) inflate.findViewById(R.id.rm7);
        this.f64440d0 = (StartPointSeekBar) inflate.findViewById(R.id.rm6);
        this.f64441e0 = (TextView) inflate.findViewById(R.id.f163802s31);
        this.f64438b0 = (AEFlashShowMaterialPanel) inflate.findViewById(R.id.ru_);
        this.D = (AEFlashShowBottomPanelViewModel) com.tencent.aelight.camera.ae.n.a(this.f64449m).get(AEFlashShowBottomPanelViewModel.class);
        this.f64438b0.setPartManager(this.f415375d);
        this.f64438b0.setCaptureController(this.f64449m.z1());
        this.f64438b0.setMaterialPanelListener(new b());
        AEFlashShowBottomPanelViewModel.i2().observe(this.f64449m, new c());
        AEFlashShowBottomPanelViewModel.l2().observe(this.f64449m, new d());
        com.tencent.aelight.camera.ae.camera.ui.panel.at.b(com.tencent.aelight.camera.ae.camera.ui.panel.au.b());
        LSBeautyAndFilterPanelViewStubHolder lSBeautyAndFilterPanelViewStubHolder = new LSBeautyAndFilterPanelViewStubHolder((ViewStub) this.f415376e.findViewById(R.id.s1w), false);
        this.f64446j0 = lSBeautyAndFilterPanelViewStubHolder;
        lSBeautyAndFilterPanelViewStubHolder.k(this.f64444h0 == null ? 2 : 1);
        this.f64446j0.j(this.f64449m.z1(), this.f415375d);
        AEFlashShowFilterPanelViewHolder aEFlashShowFilterPanelViewHolder = new AEFlashShowFilterPanelViewHolder((ViewStub) this.f415376e.findViewById(R.id.s1f));
        this.f64448l0 = aEFlashShowFilterPanelViewHolder;
        aEFlashShowFilterPanelViewHolder.D(this.f64449m.z1(), this.f415375d);
        this.P = (ImageView) this.f415376e.findViewById(R.id.f163772rx4);
        VideoReport.setElementId(this.Y, "em_xsj_props_button");
        String str = "bottom";
        if (this.f64442f0 != null) {
            HashMap hashMap = new HashMap();
            hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_BEAUTY_LOCATION, "bottom");
            VideoReport.setElementParams(this.f64442f0, hashMap);
            VideoReport.setElementId(this.f64442f0, "em_xsj_beauty_button");
        }
        View view = this.f64444h0;
        if (view != null) {
            VideoReport.setElementId(view, "em_xsj_photos_icon");
        }
        VideoReport.setElementId(this.F, "em_xsj_shoot_button");
        Map<String, Object> buildElementParams = WinkDTParamBuilder.buildElementParams();
        Map<String, Object> reportArgsFromIntent = WinkMaterialGuideUtils.getReportArgsFromIntent(this.f415377f);
        for (Map.Entry<String, Object> entry : reportArgsFromIntent.entrySet()) {
            WinkDatongCurrentParams.put(entry.getKey(), entry.getValue());
        }
        buildElementParams.putAll(reportArgsFromIntent);
        if (this.f64444h0 != null) {
            str = "upright";
        }
        buildElementParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_BEAUTY_LOCATION, str);
        com.tencent.aelight.camera.ae.util.m.f65786a.a(buildElementParams);
        VideoReport.setElementParams(this.F, buildElementParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean f1(View view, MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() == 0) {
            view.setAlpha(0.5f);
        } else if (motionEvent.getActionMasked() == 1) {
            view.setAlpha(1.0f);
            view.performClick();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g1(Pair pair) {
        if (this.f64447k0 != null) {
            if (pair != null && ((Boolean) pair.getSecond()).booleanValue()) {
                K0(null);
                S0();
            } else {
                r1(null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i1() {
        ms.a.a("AEFlashShowBottomPart", "startDownloadFirstData ");
        AEFlashShowMaterialPanel aEFlashShowMaterialPanel = this.f64438b0;
        if (aEFlashShowMaterialPanel != null) {
            aEFlashShowMaterialPanel.A();
            this.f64438b0.L(null, this.S.f69050id);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j1(String str, String str2) {
        ms.a.f("AEFlashShowBottomPart", "take same selectMaterial-categroyName = " + str);
        if (TextUtils.isEmpty(str)) {
            AEFlashShowMaterialPanel aEFlashShowMaterialPanel = this.f64438b0;
            if (aEFlashShowMaterialPanel != null) {
                aEFlashShowMaterialPanel.H(str, str2);
                return;
            }
            return;
        }
        this.D.j2().setValue(new ds(true, str2, str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k1(final String str, final String str2) {
        AEFlashShowMaterialPanel aEFlashShowMaterialPanel = this.f64438b0;
        if (aEFlashShowMaterialPanel != null) {
            aEFlashShowMaterialPanel.A();
        }
        ThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.r
            @Override // java.lang.Runnable
            public final void run() {
                AEFlashShowBottomPart.this.j1(str, str2);
            }
        }, 500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m1() {
        Activity activity = this.f415377f;
        if (activity != null && !activity.isFinishing()) {
            if (this.f64456s0 == null) {
                this.f64456s0 = new QCircleCommonLoadingDialog.c(this.f415377f).p(this.f415377f.getString(R.string.y0b)).m(true).n(false).e(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.m
                    @Override // java.lang.Runnable
                    public final void run() {
                        AEFlashShowBottomPart.this.l1();
                    }
                }).a();
            }
            if (this.f64456s0.isShowing()) {
                return;
            }
            this.f64456s0.show();
            return;
        }
        ms.a.c("AEFlashShowBottomPart", "showPresetLoadingWidthPAG: mActivity.isFinishing.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o1() {
        Activity activity = this.f415377f;
        if (activity != null && !activity.isFinishing()) {
            if (this.f64457t0 == null) {
                this.f64457t0 = new QCircleCommonLoadingDialog.c(this.f415377f).p(this.f415377f.getString(R.string.y0b)).m(false).n(false).e(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.l
                    @Override // java.lang.Runnable
                    public final void run() {
                        AEFlashShowBottomPart.this.n1();
                    }
                }).a();
            }
            if (this.f64457t0.isShowing()) {
                return;
            }
            this.f64457t0.show();
            return;
        }
        ms.a.c("AEFlashShowBottomPart", "showPresetLoadingWithoutPAG: mActivity.isFinishing.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p1(int i3) {
        QCircleCommonLoadingDialog qCircleCommonLoadingDialog = this.f64456s0;
        if (qCircleCommonLoadingDialog != null) {
            qCircleCommonLoadingDialog.setProgress(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q1() {
        ms.a.f("AEFlashShowBottomPart", "onMaterialOpened");
        AEMaterialMetaData value = AEFlashShowBottomPanelViewModel.n2().getValue();
        if (value != null && !value.isNoneMaterial()) {
            this.Z.setVisibility(0);
            if (value.aigcMaterial.booleanValue()) {
                this.f64437a0.setVisibility(0);
            }
        } else {
            this.Z.setVisibility(8);
            this.f64437a0.setVisibility(8);
        }
        this.Z.setFavorite(this.f64438b0.x(value));
        Activity activity = this.f415377f;
        if (activity != null) {
            t53.a.c(activity.getIntent(), new Function1() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.u
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit h16;
                    h16 = AEFlashShowBottomPart.h1((WinkDc5507ReportData.a) obj);
                    return h16;
                }
            });
        } else {
            w53.b.c("AEFlashShowBottomPart", "mActivity is null");
        }
    }

    private void r1(Runnable runnable) {
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "translationY", this.U, 0.0f);
        ofFloat.addUpdateListener(new q());
        animatorSet.play(ofFloat);
        animatorSet.addListener(new r());
        animatorSet.setDuration(300L).start();
        Animation b16 = com.tencent.aelight.camera.aioeditor.capture.util.g.b(this.f64447k0, 1.0f, 1.0f);
        b16.setStartOffset(200L);
        b16.setDuration(100L);
        b16.setAnimationListener(new t(runnable));
        this.f64447k0.startAnimation(b16);
    }

    private String s1(HashMap<String, String> hashMap, String str) {
        String str2 = hashMap.get(str);
        ms.a.f("AEFlashShowBottomPart", "initAttrFormScheme key = " + str + " value = " + str2);
        return TextUtils.isEmpty(str2) ? "" : str2;
    }

    private void t1(Activity activity) {
        HashMap<String, String> hashMap;
        Intent intent = activity.getIntent();
        if (intent != null && (hashMap = (HashMap) intent.getSerializableExtra("key_attrs")) != null && !hashMap.isEmpty()) {
            c1(hashMap);
        }
        boolean z16 = true;
        this.f64458u0 = !TextUtils.isEmpty(this.f64450m0);
        this.A0 = this.A0 || this.f64449m.D().h();
        if (!this.B0 && !this.f64449m.D().g()) {
            z16 = false;
        }
        this.B0 = z16;
    }

    private void u1() {
        ms.a.f("AEFlashShowBottomPart", "preDownloadFirstMaterial");
        if (AEMaterialManager.W(this.S)) {
            ms.a.f("AEFlashShowBottomPart", "usable already download");
        } else if (this.f64438b0 == null) {
            ms.a.a("AEFlashShowBottomPart", "mMaterialPanel is null ");
        } else {
            this.f64449m.u2(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.q
                @Override // java.lang.Runnable
                public final void run() {
                    AEFlashShowBottomPart.this.i1();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w1(final String str, final String str2) {
        AEFlashShowCameraUnit aEFlashShowCameraUnit = this.f64449m;
        if (aEFlashShowCameraUnit == null || aEFlashShowCameraUnit.A() == null) {
            return;
        }
        ms.a.f("AEFlashShowBottomPart", "take same selectMaterial---" + str2);
        this.R = false;
        this.X = true;
        this.f64449m.u2(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.o
            @Override // java.lang.Runnable
            public final void run() {
                AEFlashShowBottomPart.this.k1(str, str2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x1() {
        View view;
        if (AECameraPrefsUtil.f().c(AECameraConstants.SP_KEY_AE_CAMERA_MATERIAL_SHOW_BUBBLE, true, 0) && (view = this.Y) != null && (view.getContext() instanceof Activity)) {
            ms.a.a("AEFlashShowBottomPart", "showGuideBubbleView");
            com.tencent.mobileqq.widget.tip.a r16 = QUIDefaultBubbleTip.r(this.Y.getContext());
            r16.o0(this.Y.getContext().getString(R.string.y18));
            r16.m0(3);
            r16.k0(0);
            r16.R(0);
            r16.S(this.Y);
            r16.s0();
            AECameraPrefsUtil.f().l(AECameraConstants.SP_KEY_AE_CAMERA_MATERIAL_SHOW_BUBBLE, false, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y1(boolean z16) {
        View view = this.f64442f0;
        if (view != null) {
            view.setVisibility(z16 ? 0 : 8);
            if (z16) {
                return;
            }
            S0();
        }
    }

    @Override // com.tencent.aelight.camera.ae.flashshow.ui.common.StartPointSeekBar.a
    public void b(StartPointSeekBar startPointSeekBar, int i3) {
        this.f64449m.t4((i3 * 1.0d) / 100.0d);
        StartPointSeekBar.t(startPointSeekBar, Math.round(i3), this.f64441e0);
    }

    public void b1(AEMaterialMetaData aEMaterialMetaData, long j3, boolean z16) {
        if (this.f64463z0 != null) {
            ThreadManager.getUIHandler().removeCallbacks(this.f64463z0);
        }
        this.f64463z0 = new EntranceRunnable(aEMaterialMetaData, z16);
        ThreadManager.getUIHandler().postDelayed(this.f64463z0, j3);
    }

    @Override // com.tencent.aelight.camera.ae.flashshow.ui.common.StartPointSeekBar.a
    public void c(StartPointSeekBar startPointSeekBar) {
        if (this.f64460w0 == null || startPointSeekBar == null) {
            return;
        }
        AECameraPrefsUtil.f().d().edit().putInt("makeup_strength_prefix_" + this.f64460w0.getId(), Math.round(startPointSeekBar.g())).apply();
    }

    @Override // lq.a
    public <T> T d(int i3, Object... objArr) {
        return (T) super.d(i3, objArr);
    }

    @Override // lq.a
    protected void e() {
        View view = this.f415376e;
        if (view == null) {
            return;
        }
        ViewStub viewStub = (ViewStub) view.findViewById(R.id.f163793s14);
        if (viewStub != null) {
            viewStub.inflate();
        }
        this.W = true;
        e1();
        d1();
        Z0();
    }

    @Override // lq.a
    public void f() {
        super.f();
        this.D0 = true;
    }

    @Override // lq.a
    public void g(int i3, int i16, Intent intent) {
        super.g(i3, i16, intent);
        ms.a.f("AEFlashShowBottomPart", "onActivityResult requestCode = " + i3 + " resultCode = " + i16);
        if (i3 == 1029 && i16 == -1) {
            intent.getStringArrayListExtra("uin_key");
            intent.getStringExtra("lua_key");
        }
    }

    @Override // lq.a
    public void h() {
        super.h();
        ms.a.f("AEFlashShowBottomPart", "onActivityResume");
        this.D0 = false;
        View view = this.f64447k0;
        if (view != null) {
            view.setVisibility(0);
        }
        F1();
        I0(!this.T.A(false).isEmpty());
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.AEFlashShowBottomPart.6
            @Override // java.lang.Runnable
            public void run() {
                AEFlashShowBottomPart.this.x1();
            }
        });
        if (this.f64444h0 == null || this.f64462y0) {
            return;
        }
        E1();
    }

    @Override // lq.a
    public void i() {
        super.i();
    }

    @Override // lq.a
    public void j() {
        super.j();
        AEFlashShowMaterialPanel aEFlashShowMaterialPanel = this.f64438b0;
        if (aEFlashShowMaterialPanel != null) {
            aEFlashShowMaterialPanel.E();
        }
    }

    @Override // lq.a
    public void k(Intent intent) {
        HashMap<String, String> hashMap;
        super.k(intent);
        if (intent == null || (hashMap = (HashMap) intent.getSerializableExtra("key_attrs")) == null || hashMap.isEmpty()) {
            return;
        }
        c1(hashMap);
    }

    @Override // lq.a
    public void l(int i3, Object... objArr) {
        super.l(i3, objArr);
        if (i3 != 983041 || objArr == null || objArr.length <= 0) {
            return;
        }
        v1((String) objArr[0]);
    }

    @Override // lq.a
    public void onDestroy() {
        super.onDestroy();
        AEFlashShowMaterialPanel aEFlashShowMaterialPanel = this.f64438b0;
        if (aEFlashShowMaterialPanel != null) {
            aEFlashShowMaterialPanel.B();
            this.f64438b0 = null;
        }
        U0();
        this.f64449m = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class b extends AEFlashShowMaterialPanel.b {
        b() {
        }

        @Override // com.tencent.aelight.camera.ae.flashshow.ui.AEFlashShowMaterialPanel.a
        public void c() {
            if (AEFlashShowBottomPart.this.L != null) {
                AEFlashShowBottomPart.this.L.S1(4, null);
            }
            AEFlashShowBottomPart.this.f64437a0.setVisibility(8);
        }

        @Override // com.tencent.aelight.camera.ae.flashshow.ui.AEFlashShowMaterialPanel.a
        public void d() {
            AEFlashShowBottomPart.this.Z.setVisibility(8);
            AEFlashShowBottomPart.this.f64437a0.setVisibility(8);
        }

        @Override // com.tencent.aelight.camera.ae.flashshow.ui.AEFlashShowMaterialPanel.a
        public void e(AEMaterialMetaData aEMaterialMetaData, boolean z16) {
            if (AEFlashShowBottomPart.this.L != null) {
                AEFlashShowBottomPart.this.L.W1(aEMaterialMetaData, false, z16);
            }
        }

        @Override // com.tencent.aelight.camera.ae.flashshow.ui.AEFlashShowMaterialPanel.a
        public void f(AEMaterialMetaData aEMaterialMetaData) {
            if (AEFlashShowBottomPart.this.L != null) {
                AEFlashShowBottomPart.this.L.W1(aEMaterialMetaData, true, false);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ Unit h(AEMaterialMetaData aEMaterialMetaData, WinkDc5507ReportData.a aVar) {
            aVar.b(1007);
            aVar.j(2);
            try {
                JSONArray jSONArray = new JSONArray();
                jSONArray.mo162put(aEMaterialMetaData.f69050id);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("meterial", jSONArray);
                aVar.e(jSONObject.toString());
                return Unit.INSTANCE;
            } catch (JSONException e16) {
                throw new RuntimeException(e16);
            }
        }

        @Override // com.tencent.aelight.camera.ae.flashshow.ui.AEFlashShowMaterialPanel.a
        public void a(final AEMaterialMetaData aEMaterialMetaData) {
            if (aEMaterialMetaData != null) {
                AEFlashShowBottomPart.this.f64450m0 = null;
                AEFlashShowBottomPart.this.f64451n0 = "";
            }
            if (aEMaterialMetaData != null && aEMaterialMetaData.aigcMaterial.booleanValue()) {
                AEFlashShowBottomPart.this.f64437a0.setVisibility(0);
            } else {
                AEFlashShowBottomPart.this.f64437a0.setVisibility(8);
            }
            if (AEFlashShowBottomPart.this.L != null) {
                AEFlashShowBottomPart.this.L.T1(4, aEMaterialMetaData, false);
            }
            if (((lq.a) AEFlashShowBottomPart.this).f415377f != null) {
                t53.a.c(((lq.a) AEFlashShowBottomPart.this).f415377f.getIntent(), new Function1() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.w
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit h16;
                        h16 = AEFlashShowBottomPart.b.h(AEMaterialMetaData.this, (WinkDc5507ReportData.a) obj);
                        return h16;
                    }
                });
            } else {
                w53.b.c("AEFlashShowBottomPart", "mActivity is null");
            }
        }
    }

    private void K0(Runnable runnable) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "translationY", 0.0f, this.U);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofFloat);
        animatorSet.addListener(new u(runnable));
        animatorSet.setDuration(300L).start();
        Animation b16 = com.tencent.aelight.camera.aioeditor.capture.util.g.b(this.f64447k0, 1.0f, 0.0f);
        b16.setStartOffset(0L);
        b16.setDuration(100L);
        b16.setAnimationListener(new v());
        this.f64447k0.startAnimation(b16);
    }

    private void Z0() {
        AEFlashShowMaterialManager aEFlashShowMaterialManager = (AEFlashShowMaterialManager) com.tencent.aelight.camera.ae.control.a.b(3);
        this.T = aEFlashShowMaterialManager;
        aEFlashShowMaterialManager.F(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l1() {
        this.f64455r0 = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n1() {
        this.f64455r0 = true;
    }

    private void v1(String str) {
        w1(null, str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class f implements Observer<AEVideoStoryTopBarViewModel.a> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes32.dex */
        public class a implements a.InterfaceC0557a {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ AEVideoStoryTopBarViewModel.a f64479a;

            a(AEVideoStoryTopBarViewModel.a aVar) {
                this.f64479a = aVar;
            }

            @Override // com.tencent.aelight.camera.ae.flashshow.ui.captureButton.a.InterfaceC0557a
            public void a() {
                if (AEFlashShowBottomPart.this.E != null) {
                    AEFlashShowBottomPart.this.E.e(this.f64479a.a(), false);
                }
                if (AEFlashShowBottomPart.this.I != null) {
                    AEFlashShowBottomPart.this.I.f2().postValue(Boolean.FALSE);
                }
                AEFlashShowBottomPart.this.F.setTouchEnable(false);
            }
        }

        f() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(AEVideoStoryTopBarViewModel.a aVar) {
            if (aVar == null) {
                return;
            }
            boolean b16 = aVar.b();
            if (b16) {
                AEFlashShowBottomPart.this.X0();
            } else if (AEFlashShowBottomPart.this.E != null) {
                AEFlashShowBottomPart.this.E.c();
            }
            AEFlashShowBottomPart.this.F.o(b16, new a(aVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N0(ImageView imageView) {
        if (imageView == null || !this.Q) {
            return;
        }
        ms.a.a("AEFlashShowBottomPart", "flashingMaterialBtn" + imageView);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageView, com.tencent.luggage.wxa.c8.c.f123400v, 1.0f, 0.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(imageView, BasicAnimation.KeyPath.SCALE_X, 1.0f, 0.5f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(imageView, BasicAnimation.KeyPath.SCALE_Y, 1.0f, 0.5f);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(imageView, com.tencent.luggage.wxa.c8.c.f123400v, 0.0f, 1.0f);
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(imageView, BasicAnimation.KeyPath.SCALE_X, 0.5f, 1.06f);
        ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(imageView, BasicAnimation.KeyPath.SCALE_Y, 0.5f, 1.06f);
        ObjectAnimator ofFloat7 = ObjectAnimator.ofFloat(imageView, BasicAnimation.KeyPath.SCALE_X, 1.06f, 1.0f);
        ObjectAnimator ofFloat8 = ObjectAnimator.ofFloat(imageView, BasicAnimation.KeyPath.SCALE_Y, 1.06f, 1.0f);
        ofFloat.setDuration(1L);
        ofFloat2.setDuration(1L);
        ofFloat3.setDuration(1L);
        ofFloat4.setDuration(300L);
        ofFloat5.setDuration(300L);
        ofFloat6.setDuration(300L);
        ofFloat7.setDuration(800L);
        ofFloat8.setDuration(800L);
        animatorSet.play(ofFloat2).with(ofFloat3).with(ofFloat);
        animatorSet.play(ofFloat2).before(ofFloat5);
        animatorSet.play(ofFloat5).with(ofFloat6).with(ofFloat4);
        animatorSet.play(ofFloat7).after(ofFloat5);
        animatorSet.play(ofFloat8).after(ofFloat6);
        animatorSet.start();
        this.Q = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Unit h1(WinkDc5507ReportData.a aVar) {
        aVar.b(1007);
        aVar.j(1);
        return Unit.INSTANCE;
    }

    private void z1(boolean z16) {
        if (!z16 || this.C0) {
            return;
        }
        this.C0 = true;
        QQToast.makeText(this.f415377f, R.string.y0q, 0).show();
    }

    public void a1(AEMaterialMetaData aEMaterialMetaData) {
        b1(aEMaterialMetaData, 2000L, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class r extends com.tencent.mobileqq.widget.f {
        r() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class t implements Animation.AnimationListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Runnable f64494d;

        t(Runnable runnable) {
            this.f64494d = runnable;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            AEFlashShowBottomPart.this.V = false;
            Runnable runnable = this.f64494d;
            if (runnable != null) {
                runnable.run();
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            AEFlashShowBottomPart aEFlashShowBottomPart = AEFlashShowBottomPart.this;
            aEFlashShowBottomPart.V = true;
            if (aEFlashShowBottomPart.f64447k0 != null) {
                AEFlashShowBottomPart.this.f64447k0.setAlpha(1.0f);
                AEFlashShowBottomPart.this.f64447k0.setVisibility(0);
            } else {
                ms.a.c("AEFlashShowBottomPart", "[openWithAnimation] alpha - onAnimationStart, mContentView == null");
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class u extends com.tencent.mobileqq.widget.f {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Runnable f64496d;

        u(Runnable runnable) {
            this.f64496d = runnable;
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Runnable runnable = this.f64496d;
            if (runnable != null) {
                runnable.run();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class v implements Animation.AnimationListener {
        v() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (AEFlashShowBottomPart.this.f64447k0 != null) {
                AEFlashShowBottomPart.this.f64447k0.setAlpha(1.0f);
                AEFlashShowBottomPart.this.f64447k0.setVisibility(8);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    @Override // com.tencent.aelight.camera.ae.flashshow.ui.common.StartPointSeekBar.a
    public void a(StartPointSeekBar startPointSeekBar) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q0() {
    }
}
