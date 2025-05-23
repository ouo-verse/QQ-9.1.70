package com.tencent.aelight.camera.ae.flashshow.ui;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.lifecycle.Observer;
import com.tencent.aelight.camera.ae.AEPituCameraUnit;
import com.tencent.aelight.camera.ae.camera.ui.panel.AEARCakePanel;
import com.tencent.aelight.camera.ae.camera.ui.panel.AEMaterialPanel;
import com.tencent.aelight.camera.ae.data.AEMaterialManager;
import com.tencent.aelight.camera.ae.flashshow.AEFlashShowCameraUnit;
import com.tencent.aelight.camera.ae.flashshow.LSBaseCameraUnit;
import com.tencent.aelight.camera.ae.flashshow.LSCameraGLSurfaceView;
import com.tencent.aelight.camera.ae.flashshow.ui.ay;
import com.tencent.aelight.camera.ae.report.AEBaseReportParam;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.VideoFilterViewPager;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.view.GLVideoClipUtil;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.aelight.camera.constants.AEEditorConstants;
import com.tencent.aelight.camera.struct.camera.material.AEMaterialMetaData;
import com.tencent.image.AbstractGifImage;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import cooperation.peak.PeakConstants;

/* compiled from: P */
/* loaded from: classes32.dex */
public class LSCaptureController implements com.tencent.aelight.camera.ae.camera.ui.c {

    /* renamed from: a, reason: collision with root package name */
    private final LSCameraGLSurfaceView f64633a;

    /* renamed from: b, reason: collision with root package name */
    public View f64634b;

    /* renamed from: c, reason: collision with root package name */
    public AEMaterialPanel f64635c;

    /* renamed from: d, reason: collision with root package name */
    private AEARCakePanel f64636d;

    /* renamed from: e, reason: collision with root package name */
    private com.tencent.aelight.camera.ae.camera.ui.panel.ao f64637e;

    /* renamed from: f, reason: collision with root package name */
    private View f64638f;

    /* renamed from: g, reason: collision with root package name */
    private ViewGroup f64639g;

    /* renamed from: h, reason: collision with root package name */
    private View f64640h;

    /* renamed from: i, reason: collision with root package name */
    private View f64641i;

    /* renamed from: j, reason: collision with root package name */
    private View f64642j;

    /* renamed from: k, reason: collision with root package name */
    private View f64643k;

    /* renamed from: l, reason: collision with root package name */
    private VideoFilterViewPager f64644l;

    /* renamed from: o, reason: collision with root package name */
    private LSBaseCameraUnit f64647o;

    /* renamed from: m, reason: collision with root package name */
    public volatile boolean f64645m = true;

    /* renamed from: n, reason: collision with root package name */
    private boolean f64646n = true;

    /* renamed from: p, reason: collision with root package name */
    private com.tencent.aelight.camera.aioeditor.capture.data.e f64648p = new b();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class a implements Observer<com.tencent.aelight.camera.ae.camera.ui.panel.ao> {
        a() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(com.tencent.aelight.camera.ae.camera.ui.panel.ao aoVar) {
            LSCaptureController.this.f64637e = aoVar;
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
            LSCaptureController.this.n();
        }
    }

    public LSCaptureController(View view, LSCameraGLSurfaceView lSCameraGLSurfaceView, LSBaseCameraUnit lSBaseCameraUnit) {
        if (view != null) {
            this.f64634b = view;
            this.f64647o = lSBaseCameraUnit;
            this.f64633a = lSCameraGLSurfaceView;
            this.f64635c = (AEMaterialPanel) view.findViewById(R.id.ryz);
            this.f64636d = (AEARCakePanel) this.f64634b.findViewById(R.id.ryy);
            this.f64642j = this.f64634b.findViewById(R.id.rnb);
            this.f64643k = this.f64634b.findViewById(R.id.rnc);
            this.f64644l = (VideoFilterViewPager) this.f64634b.findViewById(R.id.f163755ru2);
            j();
            return;
        }
        throw new IllegalStateException("rootView is null");
    }

    private void j() {
        ((AEPituCameraUnit.an) com.tencent.aelight.camera.ae.n.a(this.f64647o).get(AEPituCameraUnit.an.class)).f61910i.observe(this.f64647o, new a());
    }

    private void m(AEMaterialMetaData aEMaterialMetaData) {
        Intent intent;
        Activity A = this.f64647o.A();
        if (A != null && A.getIntent() != null) {
            if (!l() && aEMaterialMetaData != null) {
                Intent intent2 = A.getIntent();
                intent2.putExtra(PeakConstants.KEY_QQ_CAMERA_VIDEOPARAM, "camera^" + aEMaterialMetaData.f69050id);
                intent2.putExtra("material_id", aEMaterialMetaData.f69050id);
                intent2.putExtra(AEEditorConstants.MATERIAL_TOPIC, aEMaterialMetaData.topic);
                intent2.putExtra(PeakConstants.KEY_QQ_CAMERA_MATERIAL_NAME, aEMaterialMetaData.takeSameName);
                intent2.putExtra(AEEditorConstants.AE_EDITOR_IS_SHOW_TAKE_SAME, aEMaterialMetaData.showCircleTakeSame);
                return;
            }
            if (l() || (intent = A.getIntent()) == null) {
                return;
            }
            intent.removeExtra(PeakConstants.KEY_QQ_CAMERA_VIDEOPARAM);
            intent.removeExtra("material_id");
            intent.removeExtra(AEEditorConstants.MATERIAL_TOPIC);
            intent.removeExtra(PeakConstants.KEY_QQ_CAMERA_MATERIAL_NAME);
            intent.removeExtra(AEEditorConstants.AE_EDITOR_IS_SHOW_TAKE_SAME);
            intent.removeExtra(AECameraConstants.KEY_SEND_ARK_MSG_JSON_INFO);
            return;
        }
        ms.a.i("CaptureController", "modifyIntent but activity status error");
    }

    private void t(final boolean z16) {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.LSCaptureController.1
            @Override // java.lang.Runnable
            public void run() {
                if (LSCaptureController.this.f64640h == null && LSCaptureController.this.f64639g != null) {
                    LSCaptureController lSCaptureController = LSCaptureController.this;
                    lSCaptureController.f64640h = lSCaptureController.f64639g.findViewById(R.id.f163804s33);
                }
                if (LSCaptureController.this.f64640h != null) {
                    LSCaptureController.this.f64640h.setVisibility(z16 ? 0 : 8);
                }
            }
        });
    }

    public void A() {
        com.tencent.aelight.camera.aioeditor.activity.richmedia.m.n().O(0);
        com.tencent.aelight.camera.aioeditor.capture.data.d dVar = (com.tencent.aelight.camera.aioeditor.capture.data.d) fr.f.c(5);
        if (this.f64646n) {
            dVar.L[0].e(this.f64647o.A());
        }
        ay.SelectFilter d16 = ((ay) com.tencent.aelight.camera.ae.control.a.b(4)).d();
        if (d16 == null || "".equals(d16.getId()) || com.tencent.aelight.camera.ae.flashshow.filter.b.a() == null) {
            return;
        }
        com.tencent.aelight.camera.ae.flashshow.filter.b.a().A0(false);
        com.tencent.aelight.camera.ae.flashshow.filter.b.a().Z0(d16.getLutPath());
    }

    public void f() {
        this.f64639g = (ViewGroup) this.f64634b.findViewById(R.id.ru9);
        this.f64638f = this.f64634b.findViewById(R.id.rrh);
        this.f64641i = this.f64634b.findViewById(R.id.rzx);
    }

    public void g() {
        ms.a.f("CaptureController", "applyVideoMaterialAgain");
        if (AEMaterialManager.J() != null) {
            w(AEMaterialManager.J());
            return;
        }
        if (this.f64647o instanceof AEFlashShowCameraUnit) {
            AEMaterialMetaData B = AEFlashShowMaterialManager.B();
            if (B != null) {
                B.isFromRecoveryMaterial = true;
            }
            w(B);
            return;
        }
        w(AEMaterialManager.H());
    }

    public void h() {
        AEARCakePanel aEARCakePanel = this.f64636d;
        if (aEARCakePanel != null) {
            aEARCakePanel.f(true);
        }
        AEMaterialPanel aEMaterialPanel = this.f64635c;
        if (aEMaterialPanel != null) {
            aEMaterialPanel.f(true);
        }
        com.tencent.aelight.camera.ae.camera.ui.panel.ao aoVar = this.f64637e;
        if (aoVar != null) {
            aoVar.f();
        }
        ViewGroup viewGroup = this.f64639g;
        if (viewGroup != null) {
            viewGroup.setVisibility(0);
        }
    }

    public void i() {
        View findViewById = this.f64634b.findViewById(R.id.rwv);
        if (findViewById == null || !(findViewById instanceof RelativeLayout)) {
            return;
        }
        RelativeLayout relativeLayout = (RelativeLayout) findViewById;
        if (relativeLayout.isShown()) {
            relativeLayout.setVisibility(8);
            VideoFilterViewPager videoFilterViewPager = this.f64644l;
            if (videoFilterViewPager != null) {
                videoFilterViewPager.I();
            }
        }
    }

    public boolean k() {
        AEMaterialPanel aEMaterialPanel = this.f64635c;
        boolean v3 = aEMaterialPanel != null ? false | aEMaterialPanel.v() : false;
        com.tencent.aelight.camera.ae.camera.ui.panel.ao aoVar = this.f64637e;
        if (aoVar != null) {
            v3 |= aoVar.c();
        }
        AEARCakePanel aEARCakePanel = this.f64636d;
        return aEARCakePanel != null ? v3 | aEARCakePanel.t() : v3;
    }

    public boolean l() {
        LSCameraGLSurfaceView lSCameraGLSurfaceView = this.f64633a;
        return lSCameraGLSurfaceView != null && lSCameraGLSurfaceView.i1();
    }

    public void n() {
        h();
        com.tencent.aelight.camera.aioeditor.capture.data.d dVar = (com.tencent.aelight.camera.aioeditor.capture.data.d) fr.f.c(5);
        if (this.f64634b != null && dVar != null) {
            com.tencent.aelight.camera.aioeditor.activity.richmedia.m.n().V(null, this.f64647o.A(), 0);
            dVar.o(this.f64647o.A());
            com.tencent.aelight.camera.aioeditor.activity.richmedia.m.n().L(null, 0);
        }
        com.tencent.aelight.camera.ae.camera.ui.panel.ao aoVar = this.f64637e;
        if (aoVar != null) {
            aoVar.onClear();
        }
    }

    public void o() {
        AEMaterialPanel aEMaterialPanel = this.f64635c;
        if (aEMaterialPanel != null) {
            aEMaterialPanel.y();
        }
        AEARCakePanel aEARCakePanel = this.f64636d;
        if (aEARCakePanel != null) {
            aEARCakePanel.v();
        }
        com.tencent.aelight.camera.ae.camera.ui.panel.ao aoVar = this.f64637e;
        if (aoVar != null) {
            aoVar.onDestroy();
        }
    }

    public void p() {
        com.tencent.aelight.camera.ae.camera.ui.panel.ao aoVar = this.f64637e;
        if (aoVar != null) {
            aoVar.onResume();
        }
        com.tencent.aelight.camera.aioeditor.activity.richmedia.m.n().O(0);
        AbstractGifImage.resumeAll();
    }

    public void q() {
        AEMaterialPanel aEMaterialPanel = this.f64635c;
        if (aEMaterialPanel != null) {
            aEMaterialPanel.z();
        }
        com.tencent.aelight.camera.ae.camera.ui.panel.ao aoVar = this.f64637e;
        if (aoVar != null) {
            aoVar.onStop();
        }
        this.f64646n = this.f64645m;
    }

    public boolean r() {
        if (l()) {
            return true;
        }
        if (!k()) {
            return false;
        }
        h();
        return true;
    }

    public void u(int i3) {
        LSCameraGLSurfaceView lSCameraGLSurfaceView = this.f64633a;
        if (lSCameraGLSurfaceView == null || lSCameraGLSurfaceView.M0() == i3) {
            return;
        }
        if (GLVideoClipUtil.a()) {
            if (QLog.isColorLevel()) {
                QLog.d("CaptureController", 2, "onDrawBeautyFeature is in (back_camera && no template is selected) || NightMode is on");
            }
            i3 = 0;
        }
        this.f64633a.setBeautyLevel(i3);
    }

    public void v(String str, String str2) {
        LSCameraGLSurfaceView lSCameraGLSurfaceView = this.f64633a;
        if (lSCameraGLSurfaceView == null) {
            return;
        }
        lSCameraGLSurfaceView.setCustomMaterial(str, str2);
    }

    public void x(AEMaterialMetaData aEMaterialMetaData, boolean z16) {
        String str;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("material id : ");
        if (aEMaterialMetaData == null) {
            str = "null";
        } else {
            str = aEMaterialMetaData.f69050id;
        }
        sb5.append(str);
        sb5.append(" forceUpdate = ");
        sb5.append(z16);
        ms.a.f("CaptureController", sb5.toString());
        if (this.f64633a != null) {
            m(aEMaterialMetaData);
            this.f64633a.setMaterialMetaData(aEMaterialMetaData, z16);
        }
        s(aEMaterialMetaData);
    }

    public void y(String str, String str2, boolean z16) {
        LSCameraGLSurfaceView lSCameraGLSurfaceView;
        ms.a.f("CaptureController", "setMaterialByPath");
        if (str == null || str2 == null || (lSCameraGLSurfaceView = this.f64633a) == null) {
            return;
        }
        lSCameraGLSurfaceView.setMaterialByPath(str, str2, z16);
    }

    public void z(int i3) {
        LSCameraGLSurfaceView lSCameraGLSurfaceView = this.f64633a;
        if (lSCameraGLSurfaceView == null) {
            return;
        }
        lSCameraGLSurfaceView.setSharpFaceLevel(i3);
    }

    public void w(AEMaterialMetaData aEMaterialMetaData) {
        x(aEMaterialMetaData, false);
    }

    private void s(AEMaterialMetaData aEMaterialMetaData) {
        boolean z16;
        if (aEMaterialMetaData != null) {
            String o06 = AEBaseReportParam.U().o0();
            z16 = o06 == null || !o06.equalsIgnoreCase(aEMaterialMetaData.f69050id);
            AEBaseReportParam.U().u1(aEMaterialMetaData.f69050id);
            AEBaseReportParam.U().q1(aEMaterialMetaData.showCircleTakeSame);
            if (aEMaterialMetaData.showCircleTakeSame != 0) {
                t(true);
            } else {
                t(false);
            }
        } else {
            boolean z17 = !"none".equalsIgnoreCase(AEBaseReportParam.U().o0());
            AEBaseReportParam.U().u1("none");
            AEBaseReportParam.U().q1(0);
            t(false);
            z16 = z17;
        }
        if (z16) {
            com.tencent.aelight.camera.ae.report.b.b().D();
        }
    }

    @Override // com.tencent.aelight.camera.ae.camera.ui.c
    public void a(boolean z16, int i3) {
    }
}
