package com.tencent.aelight.camera.ae.camera.ui;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.ScaleAnimation;
import android.widget.RelativeLayout;
import androidx.lifecycle.Observer;
import com.tencent.aelight.camera.ae.AEBaseCameraUnit;
import com.tencent.aelight.camera.ae.AEPituCameraUnit;
import com.tencent.aelight.camera.ae.camera.core.AECameraGLSurfaceView;
import com.tencent.aelight.camera.ae.camera.ui.animator.ViewAnimator;
import com.tencent.aelight.camera.ae.camera.ui.panel.AEARCakeMaterialManager;
import com.tencent.aelight.camera.ae.camera.ui.panel.AEARCakePanel;
import com.tencent.aelight.camera.ae.camera.ui.panel.AEMaterialPanel;
import com.tencent.aelight.camera.ae.camera.ui.panel.ao;
import com.tencent.aelight.camera.ae.data.AEGifMaterialManager;
import com.tencent.aelight.camera.ae.data.AEMaterialManager;
import com.tencent.aelight.camera.ae.flashshow.ui.ay;
import com.tencent.aelight.camera.ae.flashshow.util.v;
import com.tencent.aelight.camera.ae.n;
import com.tencent.aelight.camera.ae.report.AEBaseReportParam;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.VideoFilterViewPager;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.m;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.view.GLVideoClipUtil;
import com.tencent.aelight.camera.api.IAEFilterManagerHolder;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.aelight.camera.constants.AEEditorConstants;
import com.tencent.aelight.camera.struct.camera.material.AEMaterialMetaData;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.ApngImage;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import cooperation.peak.PeakConstants;

/* compiled from: P */
/* loaded from: classes32.dex */
public class AECaptureController implements c {

    /* renamed from: a, reason: collision with root package name */
    private final AECameraGLSurfaceView f62313a;

    /* renamed from: b, reason: collision with root package name */
    public View f62314b;

    /* renamed from: c, reason: collision with root package name */
    public AEMaterialPanel f62315c;

    /* renamed from: d, reason: collision with root package name */
    private AEARCakePanel f62316d;

    /* renamed from: e, reason: collision with root package name */
    private ao f62317e;

    /* renamed from: f, reason: collision with root package name */
    private View f62318f;

    /* renamed from: g, reason: collision with root package name */
    private ViewGroup f62319g;

    /* renamed from: h, reason: collision with root package name */
    private View f62320h;

    /* renamed from: i, reason: collision with root package name */
    private View f62321i;

    /* renamed from: j, reason: collision with root package name */
    private View f62322j;

    /* renamed from: k, reason: collision with root package name */
    private View f62323k;

    /* renamed from: l, reason: collision with root package name */
    private VideoFilterViewPager f62324l;

    /* renamed from: o, reason: collision with root package name */
    private AEBaseCameraUnit f62327o;

    /* renamed from: m, reason: collision with root package name */
    public volatile boolean f62325m = true;

    /* renamed from: n, reason: collision with root package name */
    private boolean f62326n = true;

    /* renamed from: p, reason: collision with root package name */
    private com.tencent.aelight.camera.aioeditor.capture.data.e f62328p = new b();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class a implements Observer<ao> {
        a() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(ao aoVar) {
            AECaptureController.this.f62317e = aoVar;
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class b extends com.tencent.aelight.camera.aioeditor.capture.data.e {
        b() {
        }

        @Override // com.tencent.aelight.camera.aioeditor.capture.data.e
        public void b() {
            super.b();
            AECaptureController.this.m();
        }
    }

    public AECaptureController(View view, AEBaseCameraUnit aEBaseCameraUnit) {
        if (view != null) {
            this.f62314b = view;
            this.f62327o = aEBaseCameraUnit;
            this.f62313a = (AECameraGLSurfaceView) view.findViewById(R.id.rq9);
            this.f62315c = (AEMaterialPanel) this.f62314b.findViewById(R.id.ryz);
            this.f62316d = (AEARCakePanel) this.f62314b.findViewById(R.id.ryy);
            this.f62322j = this.f62314b.findViewById(R.id.rnb);
            this.f62323k = this.f62314b.findViewById(R.id.rnc);
            this.f62324l = (VideoFilterViewPager) this.f62314b.findViewById(R.id.f163755ru2);
            j();
            return;
        }
        throw new IllegalStateException("rootView is null");
    }

    private void j() {
        ((AEPituCameraUnit.an) n.a(this.f62327o).get(AEPituCameraUnit.an.class)).f61910i.observe(this.f62327o, new a());
    }

    private void s(final boolean z16) {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.ui.AECaptureController.1
            @Override // java.lang.Runnable
            public void run() {
                if (AECaptureController.this.f62320h == null && AECaptureController.this.f62319g != null) {
                    AECaptureController aECaptureController = AECaptureController.this;
                    aECaptureController.f62320h = aECaptureController.f62319g.findViewById(R.id.f163804s33);
                }
                if (AECaptureController.this.f62320h != null) {
                    AECaptureController.this.f62320h.setVisibility(z16 ? 0 : 8);
                }
            }
        });
    }

    public void f() {
        this.f62319g = (ViewGroup) this.f62314b.findViewById(R.id.ru9);
        this.f62318f = this.f62314b.findViewById(R.id.rrh);
        this.f62321i = this.f62314b.findViewById(R.id.rzx);
    }

    public void g() {
        AECameraGLSurfaceView aECameraGLSurfaceView;
        ms.a.f("CaptureController", "applyVideoMaterialAgain");
        if (((AEPituCameraUnit) this.f62327o).l2()) {
            com.tencent.aelight.camera.ae.data.a n3 = AEARCakeMaterialManager.i().n();
            ms.a.f("CaptureController", "applyVideoMaterialAgain from arcake : ");
            if (n3 == null) {
                v(null);
                ms.a.f("CaptureController", "applyVideoMaterialAgain giftMaterial is null ");
                return;
            } else {
                v(n3.b());
                return;
            }
        }
        if (AEMaterialManager.J() != null) {
            v(AEMaterialManager.J());
            return;
        }
        AEBaseCameraUnit aEBaseCameraUnit = this.f62327o;
        if ((aEBaseCameraUnit instanceof AEPituCameraUnit) && ((AEPituCameraUnit) aEBaseCameraUnit).n2() && (aECameraGLSurfaceView = this.f62313a) != null) {
            aECameraGLSurfaceView.setMaterial(AEGifMaterialManager.o().n());
        } else {
            v(AEMaterialManager.H());
        }
    }

    public void h() {
        AEARCakePanel aEARCakePanel = this.f62316d;
        if (aEARCakePanel != null) {
            aEARCakePanel.f(true);
        }
        AEMaterialPanel aEMaterialPanel = this.f62315c;
        if (aEMaterialPanel != null) {
            aEMaterialPanel.f(true);
        }
        ao aoVar = this.f62317e;
        if (aoVar != null) {
            aoVar.f();
        }
        ViewGroup viewGroup = this.f62319g;
        if (viewGroup != null) {
            viewGroup.setVisibility(0);
        }
    }

    public void i() {
        View findViewById = this.f62314b.findViewById(R.id.rwv);
        if (findViewById == null || !(findViewById instanceof RelativeLayout)) {
            return;
        }
        RelativeLayout relativeLayout = (RelativeLayout) findViewById;
        if (relativeLayout.isShown()) {
            relativeLayout.setVisibility(8);
            VideoFilterViewPager videoFilterViewPager = this.f62324l;
            if (videoFilterViewPager != null) {
                videoFilterViewPager.I();
            }
        }
    }

    public boolean k() {
        AEMaterialPanel aEMaterialPanel = this.f62315c;
        boolean v3 = aEMaterialPanel != null ? false | aEMaterialPanel.v() : false;
        ao aoVar = this.f62317e;
        if (aoVar != null) {
            v3 |= aoVar.c();
        }
        AEARCakePanel aEARCakePanel = this.f62316d;
        return aEARCakePanel != null ? v3 | aEARCakePanel.t() : v3;
    }

    public boolean l() {
        AECameraGLSurfaceView aECameraGLSurfaceView = this.f62313a;
        return aECameraGLSurfaceView != null && aECameraGLSurfaceView.isRecording();
    }

    public void m() {
        h();
        com.tencent.aelight.camera.aioeditor.capture.data.d dVar = (com.tencent.aelight.camera.aioeditor.capture.data.d) fr.f.c(5);
        if (this.f62314b != null && dVar != null) {
            m.n().V(null, (Activity) this.f62314b.getContext(), 0);
            dVar.o((Activity) this.f62314b.getContext());
            m.n().L(null, 0);
        }
        ao aoVar = this.f62317e;
        if (aoVar != null) {
            aoVar.onClear();
        }
    }

    public void n() {
        AEMaterialPanel aEMaterialPanel = this.f62315c;
        if (aEMaterialPanel != null) {
            aEMaterialPanel.y();
        }
        AEARCakePanel aEARCakePanel = this.f62316d;
        if (aEARCakePanel != null) {
            aEARCakePanel.v();
        }
        ao aoVar = this.f62317e;
        if (aoVar != null) {
            aoVar.onDestroy();
        }
    }

    public void o() {
        ao aoVar = this.f62317e;
        if (aoVar != null) {
            aoVar.onResume();
        }
        m.n().O(0);
        AbstractGifImage.resumeAll();
        if (URLDrawable.depImp.mLog != null) {
            ApngImage.playByTag(13);
        }
    }

    public void p() {
        AEMaterialPanel aEMaterialPanel = this.f62315c;
        if (aEMaterialPanel != null) {
            aEMaterialPanel.z();
        }
        ao aoVar = this.f62317e;
        if (aoVar != null) {
            aoVar.onStop();
        }
        this.f62326n = this.f62325m;
    }

    public boolean q() {
        if (l()) {
            return true;
        }
        if (!k()) {
            return false;
        }
        h();
        return true;
    }

    public void t(int i3) {
        if (this.f62313a.getSmoothLevel() == i3) {
            return;
        }
        if (GLVideoClipUtil.a()) {
            if (QLog.isColorLevel()) {
                QLog.d("CaptureController", 2, "onDrawBeautyFeature is in (back_camera && no template is selected) || NightMode is on");
            }
            i3 = 0;
        }
        this.f62313a.setBeautyLevel(i3);
    }

    public void u(String str, String str2) {
        this.f62313a.setCustomMaterial(str, str2);
    }

    public void v(AEMaterialMetaData aEMaterialMetaData) {
        String str;
        Intent intent;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("material id : ");
        if (aEMaterialMetaData == null) {
            str = "null";
        } else {
            str = aEMaterialMetaData.f69050id;
        }
        sb5.append(str);
        ms.a.f("CaptureController", sb5.toString());
        if (this.f62313a != null) {
            Activity z16 = this.f62327o.z();
            if (!l() && aEMaterialMetaData != null) {
                Intent intent2 = z16.getIntent();
                intent2.putExtra(PeakConstants.KEY_QQ_CAMERA_VIDEOPARAM, "camera^" + aEMaterialMetaData.f69050id);
                intent2.putExtra("material_id", aEMaterialMetaData.f69050id);
                intent2.putExtra(AEEditorConstants.MATERIAL_TOPIC, aEMaterialMetaData.topic);
                intent2.putExtra(PeakConstants.KEY_QQ_CAMERA_MATERIAL_NAME, aEMaterialMetaData.takeSameName);
                intent2.putExtra(AEEditorConstants.AE_EDITOR_IS_SHOW_TAKE_SAME, aEMaterialMetaData.showCircleTakeSame);
                intent2.putExtra(AECameraConstants.KEY_SEND_ARK_MSG_JSON_INFO, aEMaterialMetaData.arkInfoJson);
            } else if (!l() && (intent = z16.getIntent()) != null) {
                intent.removeExtra(PeakConstants.KEY_QQ_CAMERA_VIDEOPARAM);
                intent.removeExtra("material_id");
                intent.removeExtra(AEEditorConstants.MATERIAL_TOPIC);
                intent.removeExtra(PeakConstants.KEY_QQ_CAMERA_MATERIAL_NAME);
                intent.removeExtra(AEEditorConstants.AE_EDITOR_IS_SHOW_TAKE_SAME);
                intent.removeExtra(AECameraConstants.KEY_SEND_ARK_MSG_JSON_INFO);
            }
            this.f62313a.setMaterialMetaData(aEMaterialMetaData);
        }
        r(aEMaterialMetaData);
    }

    public void w(int i3) {
        this.f62313a.setSharpFaceLevel(i3);
    }

    public void x() {
        m.n().O(0);
        com.tencent.aelight.camera.aioeditor.capture.data.d dVar = (com.tencent.aelight.camera.aioeditor.capture.data.d) fr.f.c(5);
        if (this.f62326n) {
            dVar.L[0].e((Activity) this.f62314b.getContext());
        }
        ay.SelectFilter d16 = ((ay) com.tencent.aelight.camera.ae.control.a.b(4)).d();
        if (d16 == null || "".equals(d16.getId()) || ((IAEFilterManagerHolder) QRoute.api(IAEFilterManagerHolder.class)).isAEFilterManagerEmpty()) {
            return;
        }
        ((IAEFilterManagerHolder) QRoute.api(IAEFilterManagerHolder.class)).setIsAfterUpdateMaterial(false);
        ((IAEFilterManagerHolder) QRoute.api(IAEFilterManagerHolder.class)).updateLutGL(d16.getLutPath());
    }

    private void r(AEMaterialMetaData aEMaterialMetaData) {
        boolean z16;
        if (aEMaterialMetaData != null) {
            String o06 = AEBaseReportParam.U().o0();
            z16 = o06 == null || !o06.equalsIgnoreCase(aEMaterialMetaData.f69050id);
            AEBaseReportParam.U().u1(aEMaterialMetaData.f69050id);
            AEBaseReportParam.U().q1(aEMaterialMetaData.showCircleTakeSame);
            if (aEMaterialMetaData.showCircleTakeSame != 0) {
                s(true);
            } else {
                s(false);
            }
        } else {
            boolean z17 = !"none".equalsIgnoreCase(AEBaseReportParam.U().o0());
            AEBaseReportParam.U().u1("none");
            AEBaseReportParam.U().q1(0);
            s(false);
            z16 = z17;
        }
        if (z16) {
            com.tencent.aelight.camera.ae.report.b.b().D();
        }
    }

    @Override // com.tencent.aelight.camera.ae.camera.ui.c
    public void a(boolean z16, int i3) {
        ScaleAnimation scaleAnimation;
        View view;
        View view2;
        if (this.f62319g == null || this.f62318f == null) {
            return;
        }
        if (this.f62321i != null || ((AEPituCameraUnit) this.f62327o).l2()) {
            int height = this.f62319g.getHeight();
            View view3 = this.f62321i;
            float height2 = height + (view3 != null ? view3.getHeight() : 0);
            if (this.f62319g.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                height2 += ((ViewGroup.MarginLayoutParams) r3).bottomMargin;
            }
            if (z16) {
                long j3 = i3;
                ViewAnimator.j(this.f62319g, this.f62321i).w(0.0f, height2).h(j3).t();
                View view4 = this.f62322j;
                if (view4 != null && view4.getVisibility() == 0 && (view2 = this.f62323k) != null && view2.getVisibility() == 0) {
                    this.f62322j.getLocationOnScreen(new int[2]);
                    ViewAnimator.j(this.f62322j, this.f62323k).w(0.0f, (this.f62314b.getHeight() - r2[1]) + v.a(this.f62314b.getContext(), 100.0f)).h(j3).t();
                }
                scaleAnimation = new ScaleAnimation(1.0f, 0.7f, 1.0f, 0.7f, 1, 0.5f, 1, 0.5f);
            } else {
                long j16 = i3;
                ViewAnimator.j(this.f62319g, this.f62321i).w(height2, 0.0f).h(j16).t();
                View view5 = this.f62322j;
                if (view5 != null && view5.getVisibility() == 0 && (view = this.f62323k) != null && view.getVisibility() == 0) {
                    this.f62322j.getLocationOnScreen(new int[2]);
                    ViewAnimator.j(this.f62322j, this.f62323k).w((this.f62314b.getHeight() - r2[1]) + v.a(this.f62314b.getContext(), 100.0f), 0.0f).h(j16).t();
                }
                scaleAnimation = new ScaleAnimation(0.7f, 1.0f, 0.7f, 1.0f, 1, 0.5f, 1, 0.5f);
            }
            scaleAnimation.setDuration(i3);
            scaleAnimation.setFillAfter(true);
            this.f62318f.startAnimation(scaleAnimation);
        }
    }
}
