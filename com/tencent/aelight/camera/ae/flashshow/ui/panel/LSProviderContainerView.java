package com.tencent.aelight.camera.ae.flashshow.ui.panel;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import androidx.lifecycle.Observer;
import com.tencent.aelight.camera.ae.camera.ui.animator.ViewAnimator;
import com.tencent.aelight.camera.ae.camera.ui.panel.AEAbsBottomPanal;
import com.tencent.aelight.camera.ae.camera.ui.panel.AEBeautyProviderViewModel;
import com.tencent.aelight.camera.ae.camera.ui.panel.AEBodyProviderViewModel;
import com.tencent.aelight.camera.ae.camera.ui.panel.AEProviderViewModel;
import com.tencent.aelight.camera.ae.camera.ui.panel.BeautySecondarySelectedWrapper;
import com.tencent.aelight.camera.ae.camera.ui.panel.DYTabLayout;
import com.tencent.aelight.camera.ae.camera.ui.panel.SeekBarOpDataWrapper;
import com.tencent.aelight.camera.ae.camera.ui.panel.an;
import com.tencent.aelight.camera.ae.camera.ui.panel.bj;
import com.tencent.aelight.camera.ae.camera.ui.panel.bu;
import com.tencent.aelight.camera.ae.flashshow.LSMiddleCameraUnit;
import com.tencent.aelight.camera.ae.flashshow.ay;
import com.tencent.aelight.camera.ae.flashshow.filter.LSFilterProcessTex;
import com.tencent.aelight.camera.ae.flashshow.mode.LSCaptureMode;
import com.tencent.aelight.camera.ae.flashshow.mode.LSCaptureModeChangingEvent;
import com.tencent.aelight.camera.ae.flashshow.ui.LSCaptureController;
import com.tencent.aelight.camera.ae.flashshow.ui.beauty.AIBeautyFaceType;
import com.tencent.aelight.camera.ae.flashshow.ui.common.StartPointSeekBar;
import com.tencent.aelight.camera.ae.flashshow.ui.panel.LSEffectListHolder;
import com.tencent.aelight.camera.aioeditor.capture.data.QIMFilterCategoryItem;
import com.tencent.aelight.camera.struct.camera.material.AEMaterialMetaData;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.ttpic.facedetect.GenderType;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import mqq.app.Foreground;
import org.light.LightAsset;

/* loaded from: classes32.dex */
public class LSProviderContainerView extends AEAbsBottomPanal implements StartPointSeekBar.a {
    private View C;
    private TextView D;
    private View E;
    private ViewGroup F;
    private ViewGroup G;
    private View H;
    private View I;
    private TextView J;
    private LSBeautyProviderView K;
    private LSBodyProviderView L;
    private LSEffectListHolder M;
    private LSCosmeticsProviderView N;
    private StartPointSeekBar P;
    private TextView Q;
    private AEProviderViewModel R;
    private com.tencent.aelight.camera.ae.camera.ui.panel.ac S;
    private AEBeautyProviderViewModel T;
    private AEBodyProviderViewModel U;
    private com.tencent.aelight.camera.ae.camera.ui.panel.aa V;
    private com.tencent.aelight.camera.ae.e W;

    /* renamed from: a0, reason: collision with root package name */
    private com.tencent.aelight.camera.ae.camera.ui.panel.z f64973a0;

    /* renamed from: b0, reason: collision with root package name */
    private boolean f64974b0;

    /* renamed from: c0, reason: collision with root package name */
    private int f64975c0;

    /* renamed from: d0, reason: collision with root package name */
    private LSCaptureController f64976d0;

    /* renamed from: e, reason: collision with root package name */
    public int f64977e;

    /* renamed from: e0, reason: collision with root package name */
    private lq.b f64978e0;

    /* renamed from: f, reason: collision with root package name */
    private View f64979f;

    /* renamed from: f0, reason: collision with root package name */
    private LSCaptureMode f64980f0;

    /* renamed from: g0, reason: collision with root package name */
    private int f64981g0;

    /* renamed from: h, reason: collision with root package name */
    private ViewGroup f64982h;

    /* renamed from: h0, reason: collision with root package name */
    private int f64983h0;

    /* renamed from: i, reason: collision with root package name */
    private ViewGroup f64984i;

    /* renamed from: i0, reason: collision with root package name */
    private com.tencent.aelight.camera.ae.flashshow.ui.panel.e f64985i0;

    /* renamed from: j0, reason: collision with root package name */
    private boolean f64986j0;

    /* renamed from: k0, reason: collision with root package name */
    private boolean f64987k0;

    /* renamed from: l0, reason: collision with root package name */
    private int f64988l0;

    /* renamed from: m, reason: collision with root package name */
    private DYTabLayout f64989m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class a implements Observer<Boolean> {
        a() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(Boolean bool) {
            SeekBarOpDataWrapper value;
            Object opData;
            LSProviderContainerView.this.P.setVisibility(bool.booleanValue() ? 0 : 4);
            LSProviderContainerView.this.Q.setVisibility(bool.booleanValue() ? 0 : 8);
            if (!bool.booleanValue() || (value = LSProviderContainerView.this.R.A2().getValue()) == null || (opData = value.getOpData()) == null) {
                return;
            }
            LSProviderContainerView.this.m0(opData);
            int t26 = AEProviderViewModel.t2(opData);
            QLog.d("AEProviderContainerView", 2, "onProgressChanged, type = " + value.getType() + ", progress = " + t26);
            LSMiddleCameraUnit lSMiddleCameraUnit = (LSMiddleCameraUnit) LSProviderContainerView.this.f64978e0.b(65537, new Object[0]);
            if (lSMiddleCameraUnit == null || !value.getRefreshEffect()) {
                return;
            }
            lSMiddleCameraUnit.Q2(value.getType(), value.getOpData(), t26, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class c implements Observer<AIBeautyFaceType> {
        c() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(AIBeautyFaceType aIBeautyFaceType) {
            LSProviderContainerView.this.f64986j0 = AIBeautyFaceType.MALE == aIBeautyFaceType || AIBeautyFaceType.CHILD == aIBeautyFaceType;
            LSProviderContainerView.this.L();
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
            Drawable drawable;
            ms.a.f("AEProviderContainerView", "AiBeautyToggle---onChanged: " + bool);
            if (bool == null) {
                return;
            }
            if (bool.booleanValue()) {
                drawable = ResourcesCompat.getDrawable(LSProviderContainerView.this.getResources(), R.drawable.f159962iv0, null);
            } else {
                drawable = ResourcesCompat.getDrawable(LSProviderContainerView.this.getResources(), R.drawable.iuz, null);
            }
            drawable.setBounds(0, 0, LSProviderContainerView.this.N(16), LSProviderContainerView.this.N(16));
            LSProviderContainerView.this.D.setCompoundDrawables(drawable, null, null, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class f implements bq.d {
        f() {
        }

        @Override // bq.d
        public void onStop() {
            ViewUtils.setVisible(LSProviderContainerView.this.f64982h, 4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class g implements bq.c {
        g() {
        }

        @Override // bq.c
        public void onStart() {
            ViewUtils.setVisible(LSProviderContainerView.this.F, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class h implements bq.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Runnable f64999a;

        h(Runnable runnable) {
            this.f64999a = runnable;
        }

        @Override // bq.d
        public void onStop() {
            ViewUtils.setVisible(LSProviderContainerView.this.F, 4);
            Runnable runnable = this.f64999a;
            if (runnable != null) {
                LSProviderContainerView.this.post(runnable);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class i implements bq.c {
        i() {
        }

        @Override // bq.c
        public void onStart() {
            ViewUtils.setVisible(LSProviderContainerView.this.f64982h, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class j implements DYTabLayout.d {
        j() {
        }

        @Override // com.tencent.aelight.camera.ae.camera.ui.panel.DYTabLayout.d
        public void a(View view, int i3) {
            int d16 = com.tencent.aelight.camera.ae.flashshow.ui.panel.g.d(LSProviderContainerView.this.f64985i0, i3);
            if (LSProviderContainerView.this.R != null) {
                LSProviderContainerView.this.R.I2(d16);
            }
        }
    }

    /* loaded from: classes32.dex */
    class o implements bq.d {
        o() {
        }

        @Override // bq.d
        public void onStop() {
            LSProviderContainerView.this.E.setAlpha(0.4f);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class p implements View.OnClickListener {
        p() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (LSProviderContainerView.this.R != null) {
                Boolean value = LSProviderContainerView.this.R.u2().getValue();
                ms.a.f("AEProviderContainerView", "click toggle ai beauty, current state=" + value);
                if (value != null) {
                    LSProviderContainerView.this.R.J2(!value.booleanValue());
                }
            }
            LSProviderContainerView.this.X();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class q implements View.OnClickListener {
        q() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            LSProviderContainerView.this.b0();
            LSProviderContainerView.this.Y();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class r implements LSEffectListHolder.b {
        r() {
        }

        @Override // com.tencent.aelight.camera.ae.flashshow.ui.panel.LSEffectListHolder.b
        public void b(bj bjVar, int i3) {
            if (bjVar instanceof bu) {
                com.tencent.aelight.camera.ae.camera.ui.panel.f beautyConfig = ((bu) bjVar).getBeautyConfig();
                if (LSProviderContainerView.this.T != null) {
                    LSProviderContainerView.this.T.k2(beautyConfig);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class t implements Observer<com.tencent.aelight.camera.ae.camera.ui.panel.b> {
        t() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(com.tencent.aelight.camera.ae.camera.ui.panel.b bVar) {
            if (bVar.i().isEmpty()) {
                return;
            }
            LSProviderContainerView.this.l0(bVar);
            if (LSProviderContainerView.this.F.getVisibility() != 0) {
                LSProviderContainerView.this.i0();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class u implements Observer<BeautySecondarySelectedWrapper> {
        u() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(BeautySecondarySelectedWrapper beautySecondarySelectedWrapper) {
            LSProviderContainerView.this.M.k(beautySecondarySelectedWrapper.getSecondaryConfig().getType(), true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class v implements Observer<com.tencent.aelight.camera.ae.camera.ui.panel.f> {
        v() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(com.tencent.aelight.camera.ae.camera.ui.panel.f fVar) {
            LSProviderContainerView.this.M.c(true);
        }
    }

    public LSProviderContainerView(Context context) {
        this(context, null);
    }

    private Map<String, ?> O(HashMap<String, Object> hashMap) {
        String str;
        int i3 = this.f64988l0;
        if (i3 > 0) {
            if (i3 == 1) {
                str = "upright";
            } else {
                str = "bottom";
            }
            hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_BEAUTY_LOCATION, str);
        }
        return hashMap;
    }

    private void T() {
        LSMiddleCameraUnit lSMiddleCameraUnit = (LSMiddleCameraUnit) this.f64978e0.b(65537, new Object[0]);
        if (lSMiddleCameraUnit == null) {
            return;
        }
        this.S = (com.tencent.aelight.camera.ae.camera.ui.panel.ac) com.tencent.aelight.camera.ae.n.a(lSMiddleCameraUnit).get(com.tencent.aelight.camera.ae.camera.ui.panel.ac.class);
        this.V = (com.tencent.aelight.camera.ae.camera.ui.panel.aa) com.tencent.aelight.camera.ae.n.a(lSMiddleCameraUnit).get(com.tencent.aelight.camera.ae.camera.ui.panel.aa.class);
        com.tencent.aelight.camera.ae.camera.ui.panel.z zVar = (com.tencent.aelight.camera.ae.camera.ui.panel.z) com.tencent.aelight.camera.ae.n.a(lSMiddleCameraUnit).get(com.tencent.aelight.camera.ae.camera.ui.panel.z.class);
        this.f64973a0 = zVar;
        zVar.L1().observe(lSMiddleCameraUnit, new s());
        AEBeautyProviderViewModel aEBeautyProviderViewModel = (AEBeautyProviderViewModel) com.tencent.aelight.camera.ae.n.a(lSMiddleCameraUnit).get(AEBeautyProviderViewModel.class);
        this.T = aEBeautyProviderViewModel;
        aEBeautyProviderViewModel.a2().observe(lSMiddleCameraUnit, new t());
        this.T.Z1().observe(lSMiddleCameraUnit, new u());
        this.T.X1().observe(lSMiddleCameraUnit, new v());
        AEBodyProviderViewModel aEBodyProviderViewModel = (AEBodyProviderViewModel) com.tencent.aelight.camera.ae.n.a(lSMiddleCameraUnit).get(AEBodyProviderViewModel.class);
        this.U = aEBodyProviderViewModel;
        AEProviderViewModel aEProviderViewModel = (AEProviderViewModel) com.tencent.aelight.camera.ae.n.b(lSMiddleCameraUnit, new an(this.T, aEBodyProviderViewModel, this.V, this.S)).get(AEProviderViewModel.class);
        this.R = aEProviderViewModel;
        aEProviderViewModel.B2().observe(lSMiddleCameraUnit, new a());
        this.R.C2().observe(lSMiddleCameraUnit, new b());
        ((com.tencent.aelight.camera.ae.flashshow.ui.beauty.b) com.tencent.aelight.camera.ae.n.a(lSMiddleCameraUnit).get(com.tencent.aelight.camera.ae.flashshow.ui.beauty.b.class)).L1().observe(lSMiddleCameraUnit, new c());
        this.R.u2().observe(lSMiddleCameraUnit, new d());
        com.tencent.aelight.camera.ae.e eVar = (com.tencent.aelight.camera.ae.e) com.tencent.aelight.camera.ae.n.a(lSMiddleCameraUnit).get(com.tencent.aelight.camera.ae.e.class);
        this.W = eVar;
        eVar.P1().observe(lSMiddleCameraUnit, new Observer() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.panel.ac
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                LSProviderContainerView.this.W((com.tencent.aelight.camera.ae.r) obj);
            }
        });
        ((com.tencent.aelight.camera.ae.flashshow.mode.a) ay.a(lSMiddleCameraUnit).get(com.tencent.aelight.camera.ae.flashshow.mode.a.class)).f64352i.observe(lSMiddleCameraUnit, new e());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void V(String str, AEMaterialMetaData aEMaterialMetaData) {
        LightAsset lightAsset = VideoMaterial.loadLightAsset(str).getLightAsset();
        if (lightAsset != null) {
            r0 = lightAsset.forbiddenBasicReshape() ? 2 : 0;
            if (lightAsset.forbiddenBasicMakeup()) {
                r0 |= 1;
            }
        }
        this.R.K2(r0, aEMaterialMetaData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X() {
        VideoReport.setElementId(this.D, "em_xsj_beauty_ai");
        VideoReport.setElementParams(this.D, O(com.tencent.aelight.camera.ae.flashshow.ab.c().e()));
        VideoReport.reportEvent("dt_clck", this.D, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y() {
        VideoReport.setElementId(this.E, "em_xsj_beauty_ai_explain");
        VideoReport.setElementParams(this.E, O(com.tencent.aelight.camera.ae.flashshow.ab.c().e()));
        VideoReport.reportEvent("dt_clck", this.E, null);
    }

    private void Z() {
        VideoReport.setElementId(this.f64989m, "em_xsj_beauty_tab");
        VideoReport.setElementParams(this.f64989m, O(com.tencent.aelight.camera.ae.flashshow.ab.c().e()));
        VideoReport.reportEvent("dt_clck", this.f64989m, null);
        vq.a aVar = vq.a.f443174a;
        aVar.b(this.f64989m, "em_ae_beauty_tab");
        aVar.a(this.f64989m, null);
    }

    private void a0() {
        VideoReport.setElementId(this.f64989m, "em_xsj_makeup_tab");
        VideoReport.setElementParams(this.f64989m, O(com.tencent.aelight.camera.ae.flashshow.ab.c().e()));
        VideoReport.reportEvent("dt_clck", this.f64989m, null);
        vq.a aVar = vq.a.f443174a;
        aVar.b(this.f64989m, "em_ae_cosmetic_tab");
        aVar.a(this.f64989m, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b0() {
        Context context = getContext();
        if (!(context instanceof Activity)) {
            context = Foreground.getTopActivity();
            ms.a.c("AEProviderContainerView", "showAiBeautyHelpDialog---getTopActivity: " + context);
        }
        if (context != null) {
            com.tencent.aelight.camera.ae.camera.aibeauty.b bVar = new com.tencent.aelight.camera.ae.camera.aibeauty.b(context);
            bVar.setCanceledOnTouchOutside(false);
            bVar.show();
        } else {
            ms.a.c("AEProviderContainerView", "showAiBeautyHelpDialog---fail, no activity context: " + context);
        }
    }

    private void c0() {
        com.tencent.aelight.camera.ae.camera.ui.panel.b value;
        ViewUtils.setViewVisibility(this.N, 8);
        ViewUtils.setViewVisibility(this.L, 8);
        if (this.K == null) {
            LSBeautyProviderView lSBeautyProviderView = new LSBeautyProviderView(getContext(), this.f64988l0);
            this.K = lSBeautyProviderView;
            this.f64984i.addView(lSBeautyProviderView, new ViewGroup.LayoutParams(-1, -1));
            this.K.setControllerAndManager(this.f64976d0, this.f64978e0);
        }
        ViewUtils.setViewVisibility(this.K, 0);
        this.K.A();
        if (this.F.getVisibility() == 0) {
            this.M.c(true);
        }
        AEBeautyProviderViewModel aEBeautyProviderViewModel = this.T;
        if (aEBeautyProviderViewModel == null || (value = aEBeautyProviderViewModel.a2().getValue()) == null) {
            return;
        }
        m0(value);
    }

    private void d0() {
        com.tencent.aelight.camera.ae.camera.ui.panel.b value;
        ViewUtils.setViewVisibility(this.K, 8);
        ViewUtils.setViewVisibility(this.N, 8);
        if (this.L == null) {
            LSBodyProviderView lSBodyProviderView = new LSBodyProviderView(getContext(), this.f64988l0);
            this.L = lSBodyProviderView;
            this.f64984i.addView(lSBodyProviderView, new ViewGroup.LayoutParams(-1, -1));
            this.L.setControllerAndManager(this.f64976d0, this.f64978e0);
        }
        ViewUtils.setViewVisibility(this.L, 0);
        this.L.o();
        AEBodyProviderViewModel aEBodyProviderViewModel = this.U;
        if (aEBodyProviderViewModel == null || (value = aEBodyProviderViewModel.U1().getValue()) == null) {
            return;
        }
        m0(value);
    }

    private void e0() {
        bj value;
        ViewUtils.setViewVisibility(this.K, 8);
        ViewUtils.setViewVisibility(this.L, 8);
        if (this.N == null) {
            LSCosmeticsProviderView lSCosmeticsProviderView = new LSCosmeticsProviderView(getContext(), this.f64988l0);
            this.N = lSCosmeticsProviderView;
            lSCosmeticsProviderView.j(this.f64978e0);
            this.f64984i.addView(this.N, new ViewGroup.LayoutParams(-1, -1));
        }
        ViewUtils.setViewVisibility(this.N, 0);
        if (this.f64975c0 == GenderType.DEFAULT.value) {
            this.f64975c0 = this.f64973a0.L1().getValue().intValue();
        }
        this.N.setGenderType(this.f64975c0);
        this.N.x();
        com.tencent.aelight.camera.ae.camera.ui.panel.aa aaVar = this.V;
        if (aaVar == null || (value = aaVar.N1().getValue()) == null) {
            return;
        }
        m0(value);
        this.V.P1(value);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f0(int i3) {
        LSMiddleCameraUnit lSMiddleCameraUnit = (LSMiddleCameraUnit) this.f64978e0.b(65537, new Object[0]);
        if (lSMiddleCameraUnit != null) {
            if (i3 == 3) {
                switch (LSFilterProcessTex.S()) {
                    case 10001:
                        lSMiddleCameraUnit.onShowNormalTip("\u7f8e\u4f53\u6548\u679c\u53ea\u652f\u6301\u5355\u4eba\u54e6\uff01", null, 60000);
                        break;
                    case 10002:
                    case 10003:
                    case 10004:
                    case 10005:
                    case 10006:
                        lSMiddleCameraUnit.onShowNormalTip("\u672a\u8bc6\u522b\u5230\u8eab\u4f53\uff0c\u8bf7\u5168\u8eab\u5165\u955c\u54e6\uff01", null, 60000);
                        break;
                }
            } else {
                lSMiddleCameraUnit.onHideNormalTip();
            }
        }
        if (i3 == 1) {
            c0();
            Z();
        } else if (i3 == 2) {
            e0();
            a0();
        } else {
            if (i3 != 3) {
                return;
            }
            d0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h0(Runnable runnable) {
        AEBeautyProviderViewModel aEBeautyProviderViewModel = this.T;
        if (aEBeautyProviderViewModel != null) {
            aEBeautyProviderViewModel.b2().setValue(Boolean.FALSE);
        }
        ViewAnimator.j(this.f64982h).v(-250.0f, 0.0f).c(0.0f, 1.0f).d(this.F).v(0.0f, 250.0f).c(1.0f, 0.0f).h(300L).o(new i()).p(new h(runnable)).t();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i0() {
        AEBeautyProviderViewModel aEBeautyProviderViewModel = this.T;
        if (aEBeautyProviderViewModel != null) {
            aEBeautyProviderViewModel.b2().setValue(Boolean.TRUE);
        }
        ViewAnimator.j(this.f64982h).v(0.0f, -250.0f).c(1.0f, 0.0f).d(this.F).v(250.0f, 0.0f).c(0.0f, 1.0f).h(300L).o(new g()).p(new f()).t();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l0(com.tencent.aelight.camera.ae.camera.ui.panel.b bVar) {
        ArrayList arrayList = new ArrayList();
        Iterator<com.tencent.aelight.camera.ae.camera.ui.panel.f> it = bVar.i().iterator();
        while (it.hasNext()) {
            arrayList.add(new bu(it.next()));
        }
        this.M.j(arrayList);
        com.tencent.aelight.camera.ae.camera.ui.panel.f D2 = AEProviderViewModel.D2(bVar);
        if (D2 != null) {
            this.M.k(D2.getType(), false);
        }
        this.J.setText(bVar.getKey());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m0(Object obj) {
        int y26 = AEProviderViewModel.y2(obj);
        int x26 = AEProviderViewModel.x2(obj);
        int v26 = AEProviderViewModel.v2(obj);
        int t26 = AEProviderViewModel.t2(obj);
        if (t26 > x26 || t26 < y26) {
            return;
        }
        this.P.setAbsoluteMinMaxValue(y26, x26);
        this.P.setDefaultValue(v26);
        this.P.setSectionEnable(v26 < x26 && v26 > y26);
        this.P.setProgress(t26);
        StartPointSeekBar.t(this.P, t26, this.Q);
    }

    public void K() {
        View view = this.E;
        if (view == null || view.getVisibility() != 0) {
            return;
        }
        ViewAnimator.j(this.E).c(0.4f, 0.8f, 0.4f).h(1000L).s(2).r(2).m(new AccelerateDecelerateInterpolator()).t().o(new o());
    }

    public void M() {
        DYTabLayout dYTabLayout = this.f64989m;
        if (dYTabLayout == null) {
            return;
        }
        f0(com.tencent.aelight.camera.ae.flashshow.ui.panel.g.d(this.f64985i0, dYTabLayout.e()));
        g0();
    }

    public void S(Context context, boolean z16, int i3) {
        this.f64988l0 = i3;
        this.f64985i0 = com.tencent.aelight.camera.ae.flashshow.ui.panel.f.a();
        View inflate = LayoutInflater.from(context).inflate(R.layout.dop, this);
        View findViewById = inflate.findViewById(R.id.rxt);
        this.f64979f = findViewById;
        findViewById.setBackgroundResource(this.f64985i0.getPanelBgRes());
        P(inflate);
        Q(inflate);
        R(inflate);
    }

    public boolean U() {
        boolean z16;
        LSBeautyProviderView lSBeautyProviderView = this.K;
        if (lSBeautyProviderView == null && this.N == null) {
            return false;
        }
        if (lSBeautyProviderView != null) {
            z16 = (lSBeautyProviderView.getVisibility() == 0) | false;
        } else {
            z16 = false;
        }
        LSCosmeticsProviderView lSCosmeticsProviderView = this.N;
        if (lSCosmeticsProviderView != null) {
            z16 |= lSCosmeticsProviderView.getVisibility() == 0;
        }
        LSBodyProviderView lSBodyProviderView = this.L;
        if (lSBodyProviderView != null) {
            return z16 | (lSBodyProviderView.getVisibility() == 0);
        }
        return z16;
    }

    @Override // com.tencent.aelight.camera.ae.flashshow.ui.common.StartPointSeekBar.a
    public void a(StartPointSeekBar startPointSeekBar) {
        SeekBarOpDataWrapper value;
        Object opData;
        AEProviderViewModel aEProviderViewModel = this.R;
        if (aEProviderViewModel == null || (value = aEProviderViewModel.A2().getValue()) == null || (opData = value.getOpData()) == null) {
            return;
        }
        this.R.F2();
        if (opData instanceof com.tencent.aelight.camera.ae.camera.ui.panel.b) {
            com.tencent.aelight.camera.ae.camera.ui.panel.b bVar = (com.tencent.aelight.camera.ae.camera.ui.panel.b) opData;
            com.tencent.aelight.camera.ae.camera.ui.panel.f D2 = AEProviderViewModel.D2(bVar);
            if (D2 == null) {
                bVar.getKey();
                return;
            } else {
                D2.getName();
                return;
            }
        }
        if (opData instanceof bj) {
        } else if (opData instanceof QIMFilterCategoryItem) {
        }
    }

    @Override // com.tencent.aelight.camera.ae.flashshow.ui.common.StartPointSeekBar.a
    public void b(StartPointSeekBar startPointSeekBar, int i3) {
        Object opData;
        AEProviderViewModel aEProviderViewModel = this.R;
        if (aEProviderViewModel != null) {
            SeekBarOpDataWrapper value = aEProviderViewModel.A2().getValue();
            if (value == null || (opData = value.getOpData()) == null) {
                return;
            }
            AEProviderViewModel.H2(opData, i3);
            LSMiddleCameraUnit lSMiddleCameraUnit = (LSMiddleCameraUnit) this.f64978e0.b(65537, new Object[0]);
            if (lSMiddleCameraUnit != null) {
                lSMiddleCameraUnit.Q2(value.getType(), opData, i3, true);
            }
        }
        StartPointSeekBar.t(startPointSeekBar, Math.round(i3), this.Q);
    }

    @Override // com.tencent.aelight.camera.ae.flashshow.ui.common.StartPointSeekBar.a
    public void c(StartPointSeekBar startPointSeekBar) {
        SeekBarOpDataWrapper value;
        Object opData;
        AEProviderViewModel aEProviderViewModel = this.R;
        if (aEProviderViewModel == null || (value = aEProviderViewModel.A2().getValue()) == null || (opData = value.getOpData()) == null) {
            return;
        }
        int g16 = (int) startPointSeekBar.g();
        AEProviderViewModel.H2(opData, g16);
        LSBodyProviderView lSBodyProviderView = this.L;
        if (lSBodyProviderView == null || lSBodyProviderView.getVisibility() != 0) {
            AEProviderViewModel.G2(opData, g16);
        }
        AEProviderViewModel aEProviderViewModel2 = this.R;
        if (aEProviderViewModel2 != null) {
            aEProviderViewModel2.E2(opData, g16);
        }
        LSMiddleCameraUnit lSMiddleCameraUnit = (LSMiddleCameraUnit) this.f64978e0.b(65537, new Object[0]);
        if (lSMiddleCameraUnit != null) {
            lSMiddleCameraUnit.Q2(value.getType(), opData, g16, true);
        }
    }

    @Override // com.tencent.aelight.camera.ae.camera.ui.panel.AEAbsBottomPanal
    public void f(boolean z16) {
        if (this.f64974b0) {
            j0();
        }
        LSBeautyProviderView lSBeautyProviderView = this.K;
        if (lSBeautyProviderView != null) {
            lSBeautyProviderView.z();
            this.K.setVisibility(8);
        }
        LSCosmeticsProviderView lSCosmeticsProviderView = this.N;
        if (lSCosmeticsProviderView != null) {
            lSCosmeticsProviderView.w();
            this.N.setVisibility(8);
        }
        LSBodyProviderView lSBodyProviderView = this.L;
        if (lSBodyProviderView != null) {
            lSBodyProviderView.n();
            this.L.setVisibility(8);
        }
        lq.b bVar = this.f64978e0;
        if (bVar != null) {
            bVar.q(196613, new Object[0]);
            LSMiddleCameraUnit lSMiddleCameraUnit = (LSMiddleCameraUnit) this.f64978e0.b(65537, new Object[0]);
            if (lSMiddleCameraUnit != null) {
                lSMiddleCameraUnit.onHideNormalTip();
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("AEProviderContainerView", 2, "panel closed");
        }
    }

    @Override // com.tencent.aelight.camera.ae.camera.ui.panel.AEAbsBottomPanal
    public boolean g() {
        return !U();
    }

    public void k0(int i3) {
        this.f64989m.h(com.tencent.aelight.camera.ae.flashshow.ui.panel.g.c(this.f64985i0, i3));
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        TextView textView;
        super.onConfigurationChanged(configuration);
        if (this.P == null || (textView = this.Q) == null || textView.getVisibility() != 0) {
            return;
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.panel.LSProviderContainerView.15
            @Override // java.lang.Runnable
            public void run() {
                StartPointSeekBar.t(LSProviderContainerView.this.P, (int) LSProviderContainerView.this.P.g(), LSProviderContainerView.this.Q);
            }
        });
    }

    public void setCaptureMode(LSCaptureMode lSCaptureMode) {
        this.f64980f0 = lSCaptureMode;
    }

    public void setControllerAndManager(LSCaptureController lSCaptureController, lq.b bVar) {
        this.f64976d0 = lSCaptureController;
        this.f64978e0 = bVar;
        T();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class e implements Observer<LSCaptureModeChangingEvent> {
        e() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(LSCaptureModeChangingEvent lSCaptureModeChangingEvent) {
            if (lSCaptureModeChangingEvent == null || LSProviderContainerView.this.Q == null) {
                return;
            }
            LSProviderContainerView.this.Q.setTextColor(-1);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class s implements Observer<Integer> {
        s() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(Integer num) {
            if (num != null) {
                LSProviderContainerView.this.f64975c0 = num.intValue();
            }
        }
    }

    public LSProviderContainerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L() {
        ms.a.f("AEProviderContainerView", String.format("checkShowHideAIBeauty---visibleOnTab=%b, visibleOnFace=%b", Boolean.valueOf(this.f64987k0), Boolean.valueOf(this.f64986j0)));
        this.D.setVisibility((this.f64987k0 && this.f64986j0) ? 0 : 8);
        this.E.setVisibility((this.f64987k0 && this.f64986j0) ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int N(int i3) {
        return (int) TypedValue.applyDimension(1, i3, getResources().getDisplayMetrics());
    }

    private void g0() {
        this.f64974b0 = true;
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ObjectAnimator.ofFloat(this, "translationY", this.f64977e, 0.0f));
        animatorSet.addListener(new k());
        animatorSet.setDuration(300L).start();
        Animation b16 = com.tencent.aelight.camera.aioeditor.capture.util.g.b(this, 0.0f, 1.0f);
        b16.setStartOffset(200L);
        b16.setDuration(100L);
        b16.setAnimationListener(new l());
        startAnimation(b16);
    }

    private void j0() {
        this.f64974b0 = false;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "translationY", 0.0f, this.f64977e);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofFloat);
        animatorSet.addListener(new m());
        animatorSet.setDuration(300L).start();
        Animation b16 = com.tencent.aelight.camera.aioeditor.capture.util.g.b(this, 1.0f, 0.0f);
        b16.setStartOffset(0L);
        b16.setDuration(100L);
        b16.setAnimationListener(new n());
        startAnimation(b16);
    }

    @Override // com.tencent.aelight.camera.ae.camera.ui.panel.AEAbsBottomPanal
    public void e() {
        f(true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class b implements Observer<Integer> {
        b() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(Integer num) {
            if (num == null) {
                return;
            }
            LSProviderContainerView lSProviderContainerView = LSProviderContainerView.this;
            boolean z16 = true;
            if (num.intValue() != 1 && num.intValue() != 2) {
                z16 = false;
            }
            lSProviderContainerView.f64987k0 = z16;
            LSProviderContainerView.this.L();
            LSProviderContainerView.this.f0(num.intValue());
        }
    }

    public LSProviderContainerView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f64977e = com.tencent.aelight.camera.ae.flashshow.util.v.a(getContext(), 241.0f);
        this.f64974b0 = false;
        this.f64975c0 = GenderType.DEFAULT.value;
        this.f64980f0 = LSCaptureMode.NORMAL;
        this.f64981g0 = 0;
        this.f64983h0 = 0;
        this.f64988l0 = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void W(com.tencent.aelight.camera.ae.r rVar) {
        if (rVar == null || rVar.getType() != 1) {
            final AEMaterialMetaData aEMaterialMetaData = rVar == null ? null : rVar.getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.KEY_MATERIAL java.lang.String();
            if (aEMaterialMetaData != null && !TextUtils.isEmpty(aEMaterialMetaData.getLocalPath())) {
                final String localPath = aEMaterialMetaData.getLocalPath();
                ThreadManager.getFileThreadHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.panel.ad
                    @Override // java.lang.Runnable
                    public final void run() {
                        LSProviderContainerView.this.V(localPath, aEMaterialMetaData);
                    }
                });
            } else {
                this.R.K2(0, aEMaterialMetaData);
                this.T.f2();
            }
        }
    }

    private void P(View view) {
        this.f64982h = (ViewGroup) view.findViewById(R.id.rym);
        this.f64984i = (ViewGroup) view.findViewById(R.id.ryn);
        DYTabLayout dYTabLayout = (DYTabLayout) view.findViewById(R.id.ryq);
        this.f64989m = dYTabLayout;
        dYTabLayout.setupTabs(com.tencent.aelight.camera.ae.flashshow.ui.panel.g.b(this.f64985i0), new j());
        View findViewById = view.findViewById(R.id.ryp);
        this.C = findViewById;
        findViewById.setVisibility(this.f64985i0.getShowTabBarDivider() ? 0 : 4);
        TextView textView = (TextView) view.findViewById(R.id.rpf);
        this.D = textView;
        textView.setCompoundDrawablePadding(N(8));
        this.D.setOnClickListener(new p());
        View findViewById2 = view.findViewById(R.id.rtj);
        this.E = findViewById2;
        findViewById2.setAlpha(0.4f);
        this.E.setOnClickListener(new q());
    }

    private void Q(View view) {
        this.F = (ViewGroup) view.findViewById(R.id.s0g);
        this.G = (ViewGroup) view.findViewById(R.id.s0h);
        this.J = (TextView) view.findViewById(R.id.s0k);
        View findViewById = view.findViewById(R.id.s0j);
        this.H = findViewById;
        findViewById.setVisibility(this.f64985i0.getShowTabBarDivider() ? 0 : 4);
        View findViewById2 = view.findViewById(R.id.rph);
        this.I = findViewById2;
        findViewById2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.panel.LSProviderContainerView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                EventCollector.getInstance().onViewClickedBefore(view2);
                LSProviderContainerView.this.h0(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.panel.LSProviderContainerView.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (LSProviderContainerView.this.K != null) {
                            LSProviderContainerView.this.K.q();
                        }
                    }
                });
                EventCollector.getInstance().onViewClicked(view2);
            }
        });
        this.M = new LSEffectListHolder(getContext(), this.G, new r(), this.f64988l0);
    }

    private void R(View view) {
        this.Q = (TextView) view.findViewById(R.id.f163802s31);
        StartPointSeekBar startPointSeekBar = (StartPointSeekBar) view.findViewById(R.id.f163789s10);
        this.P = startPointSeekBar;
        startPointSeekBar.setOnSeekBarChangeListener(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class k extends com.tencent.mobileqq.widget.f {
        k() {
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (QLog.isColorLevel()) {
                QLog.d("AEProviderContainerView", 2, "panel opened");
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
    public class l implements Animation.AnimationListener {
        l() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            LSProviderContainerView.this.setVisibility(0);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class m extends com.tencent.mobileqq.widget.f {
        m() {
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (QLog.isColorLevel()) {
                QLog.d("AEProviderContainerView", 2, "panel closed");
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
    public class n implements Animation.AnimationListener {
        n() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            LSProviderContainerView.this.setAlpha(1.0f);
            LSProviderContainerView.this.setVisibility(8);
            if (LSProviderContainerView.this.f64978e0 != null) {
                LSProviderContainerView.this.f64978e0.q(131075, new Object[0]);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }
}
