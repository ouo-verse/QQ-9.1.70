package com.tencent.aelight.camera.ae.camera.ui.panel;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
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
import com.tencent.aelight.camera.ae.AEPituCameraUnit;
import com.tencent.aelight.camera.ae.camera.aibeauty.AIBeautyFaceType;
import com.tencent.aelight.camera.ae.camera.filter.AEFilterProcessTex;
import com.tencent.aelight.camera.ae.camera.ui.AECaptureController;
import com.tencent.aelight.camera.ae.camera.ui.animator.ViewAnimator;
import com.tencent.aelight.camera.ae.camera.ui.panel.DYAEEffectListHolder;
import com.tencent.aelight.camera.ae.camera.ui.panel.DYTabLayout;
import com.tencent.aelight.camera.ae.camera.ui.panel.StartPointSeekBar;
import com.tencent.aelight.camera.ae.mode.AECaptureMode;
import com.tencent.aelight.camera.ae.mode.AECaptureModeChangingEvent;
import com.tencent.aelight.camera.ae.report.AEBaseReportParam;
import com.tencent.aelight.camera.aioeditor.capture.data.QIMFilterCategoryItem;
import com.tencent.aelight.camera.struct.camera.material.AEMaterialMetaData;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.ttpic.facedetect.GenderType;
import com.tencent.ttpic.openapi.filter.LightNode;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.light.LightAsset;

/* loaded from: classes32.dex */
public class DYAEProviderContainerView extends AEAbsBottomPanal implements StartPointSeekBar.a {
    private View C;
    private TextView D;
    private View E;
    private ViewGroup F;
    private ViewGroup G;
    private View H;
    private View I;
    private TextView J;
    private DYAEFilterProviderView K;
    private DYAEBeautyProviderView L;
    private DYAEBodyProviderView M;
    private DYAEEffectListHolder N;
    private AECosmeticsProviderView P;
    private StartPointSeekBar Q;
    private TextView R;
    private AEProviderViewModel S;
    private ac T;
    private AEBeautyProviderViewModel U;
    private AEBodyProviderViewModel V;
    private aa W;

    /* renamed from: a0, reason: collision with root package name */
    private com.tencent.aelight.camera.ae.e f62969a0;

    /* renamed from: b0, reason: collision with root package name */
    private z f62970b0;

    /* renamed from: c0, reason: collision with root package name */
    private boolean f62971c0;

    /* renamed from: d0, reason: collision with root package name */
    private int f62972d0;

    /* renamed from: e, reason: collision with root package name */
    public int f62973e;

    /* renamed from: e0, reason: collision with root package name */
    private AECaptureController f62974e0;

    /* renamed from: f, reason: collision with root package name */
    private View f62975f;

    /* renamed from: f0, reason: collision with root package name */
    private com.tencent.aelight.camera.ae.part.c f62976f0;

    /* renamed from: g0, reason: collision with root package name */
    private AECaptureMode f62977g0;

    /* renamed from: h, reason: collision with root package name */
    private ViewGroup f62978h;

    /* renamed from: h0, reason: collision with root package name */
    private int f62979h0;

    /* renamed from: i, reason: collision with root package name */
    private ViewGroup f62980i;

    /* renamed from: i0, reason: collision with root package name */
    private int f62981i0;

    /* renamed from: j0, reason: collision with root package name */
    private as f62982j0;

    /* renamed from: k0, reason: collision with root package name */
    private boolean f62983k0;

    /* renamed from: l0, reason: collision with root package name */
    private boolean f62984l0;

    /* renamed from: m, reason: collision with root package name */
    private DYTabLayout f62985m;

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
            DYAEProviderContainerView.this.Q.setVisibility(bool.booleanValue() ? 0 : 4);
            DYAEProviderContainerView.this.R.setVisibility(bool.booleanValue() ? 0 : 8);
            if (!bool.booleanValue() || (value = DYAEProviderContainerView.this.S.A2().getValue()) == null || (opData = value.getOpData()) == null) {
                return;
            }
            DYAEProviderContainerView.this.x0(opData);
            int t26 = AEProviderViewModel.t2(opData);
            QLog.d("AEProviderContainerView", 2, "onProgressChanged, type = " + value.getType() + ", progress = " + t26);
            AEPituCameraUnit aEPituCameraUnit = (AEPituCameraUnit) DYAEProviderContainerView.this.f62976f0.b(65537, new Object[0]);
            if (aEPituCameraUnit == null || !value.getRefreshEffect()) {
                return;
            }
            aEPituCameraUnit.r3(value.getType(), value.getOpData(), t26, false);
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
            DYAEProviderContainerView.this.f62983k0 = AIBeautyFaceType.MALE == aIBeautyFaceType || AIBeautyFaceType.CHILD == aIBeautyFaceType;
            DYAEProviderContainerView.this.P();
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
                drawable = ResourcesCompat.getDrawable(DYAEProviderContainerView.this.getResources(), R.drawable.f159962iv0, null);
            } else {
                drawable = ResourcesCompat.getDrawable(DYAEProviderContainerView.this.getResources(), R.drawable.iuz, null);
            }
            drawable.setBounds(0, 0, DYAEProviderContainerView.this.R(16), DYAEProviderContainerView.this.R(16));
            DYAEProviderContainerView.this.D.setCompoundDrawables(drawable, null, null, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class f implements bq.d {
        f() {
        }

        @Override // bq.d
        public void onStop() {
            ViewUtils.setVisible(DYAEProviderContainerView.this.f62978h, 4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class g implements bq.c {
        g() {
        }

        @Override // bq.c
        public void onStart() {
            ViewUtils.setVisible(DYAEProviderContainerView.this.F, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class h implements bq.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Runnable f62995a;

        h(Runnable runnable) {
            this.f62995a = runnable;
        }

        @Override // bq.d
        public void onStop() {
            ViewUtils.setVisible(DYAEProviderContainerView.this.F, 4);
            Runnable runnable = this.f62995a;
            if (runnable != null) {
                DYAEProviderContainerView.this.post(runnable);
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
            ViewUtils.setVisible(DYAEProviderContainerView.this.f62978h, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class k implements DYTabLayout.d {
        k() {
        }

        @Override // com.tencent.aelight.camera.ae.camera.ui.panel.DYTabLayout.d
        public void a(View view, int i3) {
            int d16 = au.d(DYAEProviderContainerView.this.f62982j0, i3);
            if (DYAEProviderContainerView.this.S != null) {
                DYAEProviderContainerView.this.S.I2(d16);
            }
            if (d16 == 1) {
                com.tencent.aelight.camera.ae.report.b.b().S();
                DYAEProviderContainerView.this.i0();
                return;
            }
            if (d16 == 2) {
                com.tencent.aelight.camera.ae.report.b.b().b0();
                DYAEProviderContainerView.this.j0();
            } else if (d16 != 0) {
                if (d16 == 3) {
                    com.tencent.aelight.camera.ae.report.b.b().V();
                }
            } else {
                com.tencent.aelight.camera.ae.report.b.b().Y();
                vq.a aVar = vq.a.f443174a;
                aVar.b(DYAEProviderContainerView.this.f62985m, "em_ae_filter_tab");
                aVar.a(DYAEProviderContainerView.this.f62985m, null);
            }
        }
    }

    /* loaded from: classes32.dex */
    class o implements bq.d {
        o() {
        }

        @Override // bq.d
        public void onStop() {
            DYAEProviderContainerView.this.E.setAlpha(0.4f);
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
            if (DYAEProviderContainerView.this.S != null) {
                Boolean value = DYAEProviderContainerView.this.S.u2().getValue();
                ms.a.f("AEProviderContainerView", "click toggle ai beauty, current state=" + value);
                if (value != null) {
                    DYAEProviderContainerView.this.S.J2(!value.booleanValue());
                    AEBaseReportParam.U().B0(!value.booleanValue() ? 1 : 0);
                    com.tencent.aelight.camera.ae.report.b.b().F();
                }
            }
            DYAEProviderContainerView.this.g0();
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
            DYAEProviderContainerView.this.k0();
            com.tencent.aelight.camera.ae.report.b.b().G();
            DYAEProviderContainerView.this.h0();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class r implements DYAEEffectListHolder.b {
        r() {
        }

        @Override // com.tencent.aelight.camera.ae.camera.ui.panel.DYAEEffectListHolder.b
        public void b(bj bjVar, int i3) {
            if (bjVar instanceof bu) {
                com.tencent.aelight.camera.ae.camera.ui.panel.f beautyConfig = ((bu) bjVar).getBeautyConfig();
                if (DYAEProviderContainerView.this.U != null) {
                    DYAEProviderContainerView.this.U.k2(beautyConfig);
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
            DYAEProviderContainerView.this.w0(bVar);
            if (DYAEProviderContainerView.this.F.getVisibility() != 0) {
                DYAEProviderContainerView.this.s0();
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
            DYAEProviderContainerView.this.N.k(beautySecondarySelectedWrapper.getSecondaryConfig().getType(), true);
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
            DYAEProviderContainerView.this.N.c(true);
        }
    }

    public DYAEProviderContainerView(Context context) {
        this(context, null);
    }

    private void W() {
        AEPituCameraUnit aEPituCameraUnit = (AEPituCameraUnit) this.f62976f0.b(65537, new Object[0]);
        if (aEPituCameraUnit == null) {
            return;
        }
        this.T = (ac) com.tencent.aelight.camera.ae.n.a(aEPituCameraUnit).get(ac.class);
        this.W = (aa) com.tencent.aelight.camera.ae.n.a(aEPituCameraUnit).get(aa.class);
        z zVar = (z) com.tencent.aelight.camera.ae.n.a(aEPituCameraUnit).get(z.class);
        this.f62970b0 = zVar;
        zVar.L1().observe(aEPituCameraUnit, new s());
        AEBeautyProviderViewModel aEBeautyProviderViewModel = (AEBeautyProviderViewModel) com.tencent.aelight.camera.ae.n.a(aEPituCameraUnit).get(AEBeautyProviderViewModel.class);
        this.U = aEBeautyProviderViewModel;
        aEBeautyProviderViewModel.a2().observe(aEPituCameraUnit, new t());
        this.U.Z1().observe(aEPituCameraUnit, new u());
        this.U.X1().observe(aEPituCameraUnit, new v());
        AEBodyProviderViewModel aEBodyProviderViewModel = (AEBodyProviderViewModel) com.tencent.aelight.camera.ae.n.a(aEPituCameraUnit).get(AEBodyProviderViewModel.class);
        this.V = aEBodyProviderViewModel;
        AEProviderViewModel aEProviderViewModel = (AEProviderViewModel) com.tencent.aelight.camera.ae.n.b(aEPituCameraUnit, new an(this.U, aEBodyProviderViewModel, this.W, this.T)).get(AEProviderViewModel.class);
        this.S = aEProviderViewModel;
        aEProviderViewModel.B2().observe(aEPituCameraUnit, new a());
        this.S.C2().observe(aEPituCameraUnit, new b());
        ((com.tencent.aelight.camera.ae.camera.aibeauty.d) com.tencent.aelight.camera.ae.n.a(aEPituCameraUnit).get(com.tencent.aelight.camera.ae.camera.aibeauty.d.class)).L1().observe(aEPituCameraUnit, new c());
        this.S.u2().observe(aEPituCameraUnit, new d());
        com.tencent.aelight.camera.ae.e eVar = (com.tencent.aelight.camera.ae.e) com.tencent.aelight.camera.ae.n.a(aEPituCameraUnit).get(com.tencent.aelight.camera.ae.e.class);
        this.f62969a0 = eVar;
        eVar.P1().observe(aEPituCameraUnit, new Observer() { // from class: com.tencent.aelight.camera.ae.camera.ui.panel.bs
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                DYAEProviderContainerView.this.a0((com.tencent.aelight.camera.ae.r) obj);
            }
        });
        ((com.tencent.aelight.camera.ae.mode.c) com.tencent.aelight.camera.ae.n.a(aEPituCameraUnit).get(com.tencent.aelight.camera.ae.mode.c.class)).f65622i.observe(aEPituCameraUnit, new e());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Z(String str, AEMaterialMetaData aEMaterialMetaData) {
        LightAsset lightAsset = VideoMaterial.loadLightAsset(str).getLightAsset();
        if (lightAsset != null) {
            r0 = lightAsset.forbiddenBasicReshape() ? 2 : 0;
            if (lightAsset.forbiddenBasicMakeup()) {
                r0 |= 1;
            }
        }
        this.S.K2(r0, aEMaterialMetaData);
    }

    private void f0() {
        if (gq.a.r(((Activity) getContext()).getIntent())) {
            int m3 = AEBeautyProviderView.m();
            if (m3 != this.f62979h0) {
                HashMap hashMap = new HashMap();
                hashMap.put("ext15", String.valueOf(m3));
                com.tencent.aelight.camera.aebase.c.d(12, 3, hashMap);
            }
            int n3 = AEBeautyProviderView.n();
            if (n3 != this.f62981i0) {
                HashMap hashMap2 = new HashMap();
                hashMap2.put("ext15", String.valueOf(n3));
                com.tencent.aelight.camera.aebase.c.d(12, 4, hashMap2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g0() {
        VideoReport.setElementId(this.D, "em_xsj_beauty_ai");
        VideoReport.setElementParams(this.D, com.tencent.aelight.camera.ae.flashshow.ab.c().e());
        VideoReport.reportEvent("dt_clck", this.D, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h0() {
        VideoReport.setElementId(this.E, "em_xsj_beauty_ai_explain");
        VideoReport.setElementParams(this.E, com.tencent.aelight.camera.ae.flashshow.ab.c().e());
        VideoReport.reportEvent("dt_clck", this.E, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i0() {
        VideoReport.setElementId(this.f62985m, "em_xsj_beauty_tab");
        VideoReport.setElementParams(this.f62985m, com.tencent.aelight.camera.ae.flashshow.ab.c().e());
        VideoReport.reportEvent("dt_clck", this.f62985m, null);
        vq.a aVar = vq.a.f443174a;
        aVar.b(this.f62985m, "em_ae_beauty_tab");
        aVar.a(this.f62985m, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j0() {
        VideoReport.setElementId(this.f62985m, "em_xsj_makeup_tab");
        VideoReport.setElementParams(this.f62985m, com.tencent.aelight.camera.ae.flashshow.ab.c().e());
        VideoReport.reportEvent("dt_clck", this.f62985m, null);
        vq.a aVar = vq.a.f443174a;
        aVar.b(this.f62985m, "em_ae_cosmetic_tab");
        aVar.a(this.f62985m, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k0() {
        com.tencent.aelight.camera.ae.camera.aibeauty.b bVar = new com.tencent.aelight.camera.ae.camera.aibeauty.b(getContext());
        bVar.setCanceledOnTouchOutside(false);
        bVar.show();
    }

    private void l0() {
        com.tencent.aelight.camera.ae.camera.ui.panel.b value;
        ViewUtils.setViewVisibility(this.K, 8);
        ViewUtils.setViewVisibility(this.P, 8);
        ViewUtils.setViewVisibility(this.M, 8);
        if (this.L == null) {
            DYAEBeautyProviderView dYAEBeautyProviderView = new DYAEBeautyProviderView(getContext());
            this.L = dYAEBeautyProviderView;
            this.f62980i.addView(dYAEBeautyProviderView, new ViewGroup.LayoutParams(-1, -1));
            this.L.setControllerAndManager(this.f62974e0, this.f62976f0);
        }
        ViewUtils.setViewVisibility(this.L, 0);
        this.L.z();
        if (gq.a.r(((Activity) getContext()).getIntent())) {
            this.f62979h0 = AEBeautyProviderView.m();
            this.f62981i0 = AEBeautyProviderView.n();
            com.tencent.aelight.camera.aebase.c.c(12, null);
        }
        if (this.F.getVisibility() == 0) {
            this.N.c(true);
        }
        AEBeautyProviderViewModel aEBeautyProviderViewModel = this.U;
        if (aEBeautyProviderViewModel == null || (value = aEBeautyProviderViewModel.a2().getValue()) == null) {
            return;
        }
        x0(value);
    }

    private void m0() {
        com.tencent.aelight.camera.ae.camera.ui.panel.b value;
        ViewUtils.setViewVisibility(this.K, 8);
        ViewUtils.setViewVisibility(this.L, 8);
        ViewUtils.setViewVisibility(this.P, 8);
        if (this.M == null) {
            DYAEBodyProviderView dYAEBodyProviderView = new DYAEBodyProviderView(getContext());
            this.M = dYAEBodyProviderView;
            this.f62980i.addView(dYAEBodyProviderView, new ViewGroup.LayoutParams(-1, -1));
            this.M.setControllerAndManager(this.f62974e0, this.f62976f0);
        }
        ViewUtils.setViewVisibility(this.M, 0);
        this.M.o();
        AEBodyProviderViewModel aEBodyProviderViewModel = this.V;
        if (aEBodyProviderViewModel == null || (value = aEBodyProviderViewModel.U1().getValue()) == null) {
            return;
        }
        x0(value);
    }

    private void n0() {
        bj value;
        ViewUtils.setViewVisibility(this.K, 8);
        ViewUtils.setViewVisibility(this.L, 8);
        ViewUtils.setViewVisibility(this.M, 8);
        if (this.P == null) {
            AECosmeticsProviderView aECosmeticsProviderView = new AECosmeticsProviderView(getContext());
            this.P = aECosmeticsProviderView;
            aECosmeticsProviderView.j(this.f62976f0);
            this.f62980i.addView(this.P, new ViewGroup.LayoutParams(-1, -1));
        }
        ViewUtils.setViewVisibility(this.P, 0);
        if (this.f62972d0 == GenderType.DEFAULT.value) {
            this.f62972d0 = this.f62970b0.L1().getValue().intValue();
        }
        this.P.setGenderType(this.f62972d0);
        this.P.y();
        aa aaVar = this.W;
        if (aaVar == null || (value = aaVar.N1().getValue()) == null) {
            return;
        }
        x0(value);
    }

    private void o0() {
        QIMFilterCategoryItem value;
        ViewUtils.setViewVisibility(this.P, 8);
        ViewUtils.setViewVisibility(this.L, 8);
        ViewUtils.setViewVisibility(this.M, 8);
        if (this.K == null) {
            DYAEFilterProviderView dYAEFilterProviderView = new DYAEFilterProviderView(getContext());
            this.K = dYAEFilterProviderView;
            this.f62980i.addView(dYAEFilterProviderView, new ViewGroup.LayoutParams(-1, -1));
            this.K.setNeedTabBar(false);
            this.K.m(R(162));
            DYAEFilterProviderView dYAEFilterProviderView2 = this.K;
            if (!dYAEFilterProviderView2.I) {
                dYAEFilterProviderView2.K(this.f62976f0);
                this.K.v(null);
            }
        }
        ViewUtils.setViewVisibility(this.K, 0);
        this.K.y();
        ac acVar = this.T;
        if (acVar == null || (value = acVar.L1().getValue()) == null) {
            return;
        }
        x0(value);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p0(int i3) {
        AEPituCameraUnit aEPituCameraUnit = (AEPituCameraUnit) this.f62976f0.b(65537, new Object[0]);
        if (aEPituCameraUnit != null) {
            if (i3 == 3) {
                switch (AEFilterProcessTex.Q()) {
                    case 10001:
                        aEPituCameraUnit.onShowNormalTip("\u7f8e\u4f53\u6548\u679c\u53ea\u652f\u6301\u5355\u4eba\u54e6\uff01", null, 60000);
                        break;
                    case 10002:
                    case 10003:
                    case 10004:
                    case 10005:
                    case 10006:
                        aEPituCameraUnit.onShowNormalTip("\u672a\u8bc6\u522b\u5230\u8eab\u4f53\uff0c\u8bf7\u5168\u8eab\u5165\u955c\u54e6\uff01", null, 60000);
                        break;
                }
            } else {
                aEPituCameraUnit.onHideNormalTip();
            }
        }
        if (i3 == 0) {
            o0();
            return;
        }
        if (i3 == 1) {
            l0();
        } else if (i3 == 2) {
            n0();
        } else {
            if (i3 != 3) {
                return;
            }
            m0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r0(Runnable runnable) {
        AEBeautyProviderViewModel aEBeautyProviderViewModel = this.U;
        if (aEBeautyProviderViewModel != null) {
            aEBeautyProviderViewModel.b2().setValue(Boolean.FALSE);
        }
        ViewAnimator.j(this.f62978h).v(-250.0f, 0.0f).c(0.0f, 1.0f).d(this.F).v(0.0f, 250.0f).c(1.0f, 0.0f).h(300L).o(new i()).p(new h(runnable)).t();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s0() {
        AEBeautyProviderViewModel aEBeautyProviderViewModel = this.U;
        if (aEBeautyProviderViewModel != null) {
            aEBeautyProviderViewModel.b2().setValue(Boolean.TRUE);
        }
        ViewAnimator.j(this.f62978h).v(0.0f, -250.0f).c(1.0f, 0.0f).d(this.F).v(250.0f, 0.0f).c(0.0f, 1.0f).h(300L).o(new g()).p(new f()).t();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w0(com.tencent.aelight.camera.ae.camera.ui.panel.b bVar) {
        ArrayList arrayList = new ArrayList();
        Iterator<com.tencent.aelight.camera.ae.camera.ui.panel.f> it = bVar.i().iterator();
        while (it.hasNext()) {
            arrayList.add(new bu(it.next()));
        }
        this.N.j(arrayList);
        com.tencent.aelight.camera.ae.camera.ui.panel.f D2 = AEProviderViewModel.D2(bVar);
        if (D2 != null) {
            this.N.k(D2.getType(), false);
        }
        this.J.setText(bVar.getKey());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x0(Object obj) {
        int y26 = AEProviderViewModel.y2(obj);
        int x26 = AEProviderViewModel.x2(obj);
        int v26 = AEProviderViewModel.v2(obj);
        int t26 = AEProviderViewModel.t2(obj);
        if (t26 > x26 || t26 < y26) {
            return;
        }
        this.Q.setAbsoluteMinMaxValue(y26, x26);
        this.Q.setDefaultValue(v26);
        this.Q.setSectionEnable(v26 < x26 && v26 > y26);
        this.Q.setProgress(t26);
        StartPointSeekBar.t(this.Q, t26, this.R);
    }

    public void O() {
        View view = this.E;
        if (view == null || view.getVisibility() != 0) {
            return;
        }
        ViewAnimator.j(this.E).c(0.4f, 0.8f, 0.4f).h(1000L).s(2).r(2).m(new AccelerateDecelerateInterpolator()).t().o(new o());
    }

    public void Q() {
        DYTabLayout dYTabLayout = this.f62985m;
        if (dYTabLayout == null) {
            return;
        }
        p0(au.d(this.f62982j0, dYTabLayout.e()));
        q0();
    }

    public void V(Context context, boolean z16) {
        this.f62982j0 = at.a();
        View inflate = LayoutInflater.from(context).inflate(R.layout.dok, this);
        View findViewById = inflate.findViewById(R.id.rxt);
        this.f62975f = findViewById;
        findViewById.setBackgroundResource(this.f62982j0.getPanelBgRes());
        S(inflate);
        T(inflate);
        U(inflate);
    }

    public boolean X() {
        return this.f62977g0 == AECaptureMode.GIF;
    }

    public boolean Y() {
        boolean z16;
        DYAEFilterProviderView dYAEFilterProviderView = this.K;
        if (dYAEFilterProviderView == null && this.L == null && this.P == null) {
            return false;
        }
        if (dYAEFilterProviderView != null) {
            z16 = (dYAEFilterProviderView.getVisibility() == 0) | false;
        } else {
            z16 = false;
        }
        DYAEBeautyProviderView dYAEBeautyProviderView = this.L;
        if (dYAEBeautyProviderView != null) {
            z16 |= dYAEBeautyProviderView.getVisibility() == 0;
        }
        AECosmeticsProviderView aECosmeticsProviderView = this.P;
        if (aECosmeticsProviderView != null) {
            z16 |= aECosmeticsProviderView.getVisibility() == 0;
        }
        DYAEBodyProviderView dYAEBodyProviderView = this.M;
        if (dYAEBodyProviderView != null) {
            return z16 | (dYAEBodyProviderView.getVisibility() == 0);
        }
        return z16;
    }

    public void b0() {
        DYAEFilterProviderView dYAEFilterProviderView = this.K;
        if (dYAEFilterProviderView != null) {
            dYAEFilterProviderView.u();
        }
        com.tencent.aelight.camera.aioeditor.activity.richmedia.m.n().V(null, (Activity) getContext(), 0);
        com.tencent.aelight.camera.aioeditor.activity.richmedia.m.n().L(null, 0);
        ((com.tencent.aelight.camera.aioeditor.capture.data.d) fr.f.c(5)).o((Activity) getContext());
    }

    public void c0() {
        DYAEFilterProviderView dYAEFilterProviderView = this.K;
        if (dYAEFilterProviderView != null) {
            dYAEFilterProviderView.w();
            this.K = null;
        }
        DYAEBeautyProviderView dYAEBeautyProviderView = this.L;
        if (dYAEBeautyProviderView != null) {
            dYAEBeautyProviderView.x();
            this.L = null;
        }
        AECosmeticsProviderView aECosmeticsProviderView = this.P;
        if (aECosmeticsProviderView != null) {
            aECosmeticsProviderView.u();
            this.P = null;
        }
    }

    @Override // com.tencent.aelight.camera.ae.camera.ui.panel.StartPointSeekBar.a
    public void d(StartPointSeekBar startPointSeekBar) {
        SeekBarOpDataWrapper value;
        Object opData;
        AEProviderViewModel aEProviderViewModel = this.S;
        if (aEProviderViewModel == null || (value = aEProviderViewModel.A2().getValue()) == null || (opData = value.getOpData()) == null) {
            return;
        }
        int g16 = (int) startPointSeekBar.g();
        AEProviderViewModel.H2(opData, g16);
        DYAEBodyProviderView dYAEBodyProviderView = this.M;
        if (dYAEBodyProviderView == null || dYAEBodyProviderView.getVisibility() != 0) {
            AEProviderViewModel.G2(opData, g16);
        }
        AEProviderViewModel aEProviderViewModel2 = this.S;
        if (aEProviderViewModel2 != null) {
            aEProviderViewModel2.E2(opData, g16);
        }
        AEPituCameraUnit aEPituCameraUnit = (AEPituCameraUnit) this.f62976f0.b(65537, new Object[0]);
        if (aEPituCameraUnit != null) {
            aEPituCameraUnit.r3(value.getType(), opData, g16, true);
        }
    }

    public void d0() {
        DYAEFilterProviderView dYAEFilterProviderView = this.K;
        if (dYAEFilterProviderView != null) {
            dYAEFilterProviderView.z();
        }
        DYAEBeautyProviderView dYAEBeautyProviderView = this.L;
        if (dYAEBeautyProviderView != null) {
            dYAEBeautyProviderView.A();
        }
        AECosmeticsProviderView aECosmeticsProviderView = this.P;
        if (aECosmeticsProviderView != null) {
            aECosmeticsProviderView.z();
        }
        DYAEBodyProviderView dYAEBodyProviderView = this.M;
        if (dYAEBodyProviderView != null) {
            dYAEBodyProviderView.p();
        }
    }

    public void e0() {
        DYAEFilterProviderView dYAEFilterProviderView = this.K;
        if (dYAEFilterProviderView != null) {
            dYAEFilterProviderView.A();
        }
    }

    @Override // com.tencent.aelight.camera.ae.camera.ui.panel.AEAbsBottomPanal
    public void f(boolean z16) {
        if (this.f62971c0) {
            t0();
        }
        DYAEFilterProviderView dYAEFilterProviderView = this.K;
        if (dYAEFilterProviderView != null) {
            dYAEFilterProviderView.x();
            this.K.setVisibility(8);
        }
        DYAEBeautyProviderView dYAEBeautyProviderView = this.L;
        if (dYAEBeautyProviderView != null) {
            dYAEBeautyProviderView.y();
            this.L.setVisibility(8);
            f0();
        }
        AECosmeticsProviderView aECosmeticsProviderView = this.P;
        if (aECosmeticsProviderView != null) {
            aECosmeticsProviderView.x();
            this.P.setVisibility(8);
        }
        DYAEBodyProviderView dYAEBodyProviderView = this.M;
        if (dYAEBodyProviderView != null) {
            dYAEBodyProviderView.n();
            this.M.setVisibility(8);
        }
        com.tencent.aelight.camera.ae.part.c cVar = this.f62976f0;
        if (cVar != null) {
            AEPituCameraUnit aEPituCameraUnit = (AEPituCameraUnit) cVar.b(65537, new Object[0]);
            if (aEPituCameraUnit != null) {
                aEPituCameraUnit.onHideNormalTip();
            }
            this.f62976f0.q(196613, new Object[0]);
        }
        if (QLog.isColorLevel()) {
            QLog.d("AEProviderContainerView", 2, "panel closed");
        }
    }

    @Override // com.tencent.aelight.camera.ae.camera.ui.panel.AEAbsBottomPanal
    public boolean g() {
        return !Y();
    }

    @Override // com.tencent.aelight.camera.ae.camera.ui.panel.StartPointSeekBar.a
    public void i(StartPointSeekBar startPointSeekBar) {
        SeekBarOpDataWrapper value;
        Object opData;
        String name;
        AEProviderViewModel aEProviderViewModel = this.S;
        if (aEProviderViewModel == null || (value = aEProviderViewModel.A2().getValue()) == null || (opData = value.getOpData()) == null) {
            return;
        }
        this.S.F2();
        if (opData instanceof com.tencent.aelight.camera.ae.camera.ui.panel.b) {
            com.tencent.aelight.camera.ae.camera.ui.panel.b bVar = (com.tencent.aelight.camera.ae.camera.ui.panel.b) opData;
            com.tencent.aelight.camera.ae.camera.ui.panel.f D2 = AEProviderViewModel.D2(bVar);
            if (D2 == null) {
                name = bVar.getKey();
            } else {
                name = D2.getName();
            }
            com.tencent.aelight.camera.ae.report.b.b().R(name);
            return;
        }
        if (opData instanceof bj) {
            com.tencent.aelight.camera.ae.report.b.b().a0(((bj) opData).getName(), AEProviderViewModel.t2(opData));
        } else if (opData instanceof QIMFilterCategoryItem) {
            com.tencent.aelight.camera.ae.report.b.b().X(((QIMFilterCategoryItem) opData).f66697d, AEProviderViewModel.t2(opData));
        }
    }

    @Override // com.tencent.aelight.camera.ae.camera.ui.panel.StartPointSeekBar.a
    public void m(StartPointSeekBar startPointSeekBar, int i3) {
        Object opData;
        AEProviderViewModel aEProviderViewModel = this.S;
        if (aEProviderViewModel != null) {
            SeekBarOpDataWrapper value = aEProviderViewModel.A2().getValue();
            if (value == null || (opData = value.getOpData()) == null) {
                return;
            }
            AEProviderViewModel.H2(opData, i3);
            AEPituCameraUnit aEPituCameraUnit = (AEPituCameraUnit) this.f62976f0.b(65537, new Object[0]);
            if (aEPituCameraUnit != null) {
                aEPituCameraUnit.r3(value.getType(), opData, i3, true);
            }
        }
        StartPointSeekBar.t(startPointSeekBar, Math.round(i3), this.R);
    }

    public void setCaptureMode(AECaptureMode aECaptureMode) {
        this.f62977g0 = aECaptureMode;
    }

    public void setControllerAndManager(AECaptureController aECaptureController, com.tencent.aelight.camera.ae.part.c cVar) {
        this.f62974e0 = aECaptureController;
        this.f62976f0 = cVar;
        W();
    }

    public void u0(int i3) {
        this.f62985m.h(i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class e implements Observer<AECaptureModeChangingEvent> {
        e() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(AECaptureModeChangingEvent aECaptureModeChangingEvent) {
            if (aECaptureModeChangingEvent == null || DYAEProviderContainerView.this.R == null) {
                return;
            }
            if (aECaptureModeChangingEvent.f65599b == AECaptureMode.GIF) {
                DYAEProviderContainerView.this.R.setTextColor(-16777216);
            } else {
                DYAEProviderContainerView.this.R.setTextColor(-1);
            }
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
                DYAEProviderContainerView.this.f62972d0 = num.intValue();
            }
        }
    }

    public DYAEProviderContainerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P() {
        ms.a.f("AEProviderContainerView", String.format("checkShowHideAIBeauty---visibleOnTab=%b, visibleOnFace=%b", Boolean.valueOf(this.f62984l0), Boolean.valueOf(this.f62983k0)));
        this.D.setVisibility((this.f62984l0 && this.f62983k0) ? 0 : 8);
        this.E.setVisibility((this.f62984l0 && this.f62983k0) ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int R(int i3) {
        return (int) TypedValue.applyDimension(1, i3, getResources().getDisplayMetrics());
    }

    private void q0() {
        this.f62971c0 = true;
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ObjectAnimator.ofFloat(this, "translationY", this.f62973e, 0.0f));
        animatorSet.addListener(new j());
        animatorSet.setDuration(300L).start();
        Animation b16 = com.tencent.aelight.camera.aioeditor.capture.util.g.b(this, 0.0f, 1.0f);
        b16.setStartOffset(200L);
        b16.setDuration(100L);
        b16.setAnimationListener(new l());
        startAnimation(b16);
    }

    private void t0() {
        this.f62971c0 = false;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "translationY", 0.0f, this.f62973e);
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
            DYAEProviderContainerView dYAEProviderContainerView = DYAEProviderContainerView.this;
            boolean z16 = true;
            if (num.intValue() != 1 && num.intValue() != 2) {
                z16 = false;
            }
            dYAEProviderContainerView.f62984l0 = z16;
            DYAEProviderContainerView.this.P();
            DYAEProviderContainerView.this.p0(num.intValue());
        }
    }

    public DYAEProviderContainerView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f62973e = com.tencent.aelight.camera.ae.flashshow.util.v.a(getContext(), 241.0f);
        this.f62971c0 = false;
        this.f62972d0 = GenderType.DEFAULT.value;
        this.f62977g0 = AECaptureMode.NORMAL;
        this.f62979h0 = 0;
        this.f62981i0 = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a0(com.tencent.aelight.camera.ae.r rVar) {
        final String localPath;
        if (rVar == null || rVar.getType() != 1) {
            final AEMaterialMetaData aEMaterialMetaData = rVar == null ? null : rVar.getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.KEY_MATERIAL java.lang.String();
            if (aEMaterialMetaData != null && !TextUtils.isEmpty(aEMaterialMetaData.getLocalPath())) {
                if (aEMaterialMetaData.isNoneMaterial()) {
                    localPath = LightNode.getEmptyMaterialPath();
                } else {
                    localPath = aEMaterialMetaData.getLocalPath();
                }
                ThreadManager.getFileThreadHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.ui.panel.bt
                    @Override // java.lang.Runnable
                    public final void run() {
                        DYAEProviderContainerView.this.Z(localPath, aEMaterialMetaData);
                    }
                });
                return;
            }
            this.S.K2(0, aEMaterialMetaData);
        }
    }

    private void S(View view) {
        this.f62978h = (ViewGroup) view.findViewById(R.id.rym);
        this.f62980i = (ViewGroup) view.findViewById(R.id.ryn);
        DYTabLayout dYTabLayout = (DYTabLayout) view.findViewById(R.id.ryq);
        this.f62985m = dYTabLayout;
        dYTabLayout.setupTabs(au.c(this.f62982j0), new k());
        View findViewById = view.findViewById(R.id.ryp);
        this.C = findViewById;
        findViewById.setVisibility(this.f62982j0.getShowTabBarDivider() ? 0 : 4);
        TextView textView = (TextView) view.findViewById(R.id.rpf);
        this.D = textView;
        textView.setCompoundDrawablePadding(R(8));
        this.D.setOnClickListener(new p());
        View findViewById2 = view.findViewById(R.id.rtj);
        this.E = findViewById2;
        findViewById2.setAlpha(0.4f);
        this.E.setOnClickListener(new q());
    }

    private void T(View view) {
        this.F = (ViewGroup) view.findViewById(R.id.s0g);
        this.G = (ViewGroup) view.findViewById(R.id.s0h);
        this.J = (TextView) view.findViewById(R.id.s0k);
        View findViewById = view.findViewById(R.id.s0j);
        this.H = findViewById;
        findViewById.setVisibility(this.f62982j0.getShowTabBarDivider() ? 0 : 4);
        View findViewById2 = view.findViewById(R.id.rph);
        this.I = findViewById2;
        AccessibilityUtil.p(findViewById2, HardCodeUtil.qqStr(R.string.y8p));
        this.I.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.aelight.camera.ae.camera.ui.panel.DYAEProviderContainerView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                EventCollector.getInstance().onViewClickedBefore(view2);
                DYAEProviderContainerView.this.r0(new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.ui.panel.DYAEProviderContainerView.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (DYAEProviderContainerView.this.L != null) {
                            DYAEProviderContainerView.this.L.q();
                        }
                    }
                });
                EventCollector.getInstance().onViewClicked(view2);
            }
        });
        this.N = new DYAEEffectListHolder(getContext(), this.G, new r(), 0);
    }

    private void U(View view) {
        this.R = (TextView) view.findViewById(R.id.f163802s31);
        StartPointSeekBar startPointSeekBar = (StartPointSeekBar) view.findViewById(R.id.f163789s10);
        this.Q = startPointSeekBar;
        startPointSeekBar.setOnSeekBarChangeListener(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class j extends com.tencent.mobileqq.widget.f {
        j() {
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
            DYAEProviderContainerView.this.setVisibility(0);
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
            DYAEProviderContainerView.this.setAlpha(1.0f);
            DYAEProviderContainerView.this.setVisibility(8);
            if (DYAEProviderContainerView.this.f62974e0 != null && !gq.a.v(((Activity) DYAEProviderContainerView.this.getContext()).getIntent())) {
                DYAEProviderContainerView.this.f62974e0.a(false, 150);
            }
            if (DYAEProviderContainerView.this.f62976f0 != null) {
                DYAEProviderContainerView.this.f62976f0.q(131075, new Object[0]);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    public void v0() {
    }
}
