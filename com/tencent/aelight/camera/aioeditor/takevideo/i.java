package com.tencent.aelight.camera.aioeditor.takevideo;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.FaceLayer;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.crop.CropNewView;
import com.tencent.aelight.camera.report.api.IAEBaseReportParam;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.ocr.api.IOCR;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes32.dex */
public class i extends u implements View.OnClickListener, CropNewView.a {
    protected TextView C;
    public Bitmap D;
    public Bitmap E;
    protected TextView F;
    protected TextView G;
    protected boolean H;
    boolean I;
    boolean J;
    int K;
    boolean L;
    boolean M;
    boolean N;
    int[] P;

    /* renamed from: d, reason: collision with root package name */
    protected ViewGroup f68706d;

    /* renamed from: e, reason: collision with root package name */
    protected CropNewView f68707e;

    /* renamed from: f, reason: collision with root package name */
    protected View f68708f;

    /* renamed from: h, reason: collision with root package name */
    protected View f68709h;

    /* renamed from: i, reason: collision with root package name */
    protected TextView f68710i;

    /* renamed from: m, reason: collision with root package name */
    protected View f68711m;

    public i(EditVideoPartManager editVideoPartManager) {
        super(editVideoPartManager);
        this.H = false;
        this.I = false;
        this.J = false;
        this.K = 0;
        this.L = false;
        this.M = false;
        this.N = false;
        this.P = new int[5];
    }

    private boolean l0() {
        boolean z16;
        int e16 = this.mParent.C.e();
        if (e16 == 103) {
            this.mParent.n1();
            z16 = true;
        } else {
            z16 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.d("EditPicCropPart", 2, "onBussiBackPressed , bussiId = " + e16 + ",clickHit = " + z16);
        }
        return z16;
    }

    private boolean m0() {
        boolean z16;
        int e16 = this.mParent.C.e();
        if (e16 == 103) {
            this.mParent.Q0();
            z16 = true;
        } else {
            z16 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.d("EditPicCropPart", 2, "onBussiCropClick , bussiId = " + e16 + ",clickHit = " + z16);
        }
        return z16;
    }

    private boolean n0() {
        int e16 = this.mParent.C.e();
        this.L = true;
        if (QLog.isColorLevel()) {
            QLog.d("EditPicCropPart", 2, "onBussiCropClickIntercept , bussiId = " + e16 + ",intercepte = false");
        }
        return false;
    }

    private void o0(boolean z16) {
        EditVideoPartManager editVideoPartManager = this.mParent;
        if (editVideoPartManager == null) {
            return;
        }
        int e16 = editVideoPartManager.C.e();
        if (QLog.isColorLevel()) {
            QLog.d("EditPicCropPart", 2, "onBussiRestoreClick , bussiId = " + e16 + ",hasModified" + z16);
        }
    }

    private void p0() {
        if (this.mParent.C.e() == 103) {
            this.f68710i.setEnabled(false);
            this.f68710i.setText(R.string.fny);
            this.C.setVisibility(8);
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.crop.CropNewView.a
    public void T() {
        this.f68710i.setEnabled(true);
        this.f68708f.setEnabled(true);
        this.M = true;
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.u
    public void editVideoPrePublish(int i3, fs.b bVar) {
        bVar.f400395l.f400420f += this.K;
        if (this.J) {
            bVar.f400398o.reservesArray.add("2");
            id0.b.h("0X80075E9", id0.b.f407534c);
            ((IAEBaseReportParam) QRoute.api(IAEBaseReportParam.class)).setEditHasCut(true);
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.u
    public void editVideoStateChanged(int i3, Object obj) {
        k0();
        if (i3 == 7) {
            if (this.I) {
                return;
            }
            s0();
        } else if (this.I) {
            q0();
        }
    }

    public boolean j0() {
        return this.J;
    }

    protected void k0() {
        if (this.H) {
            return;
        }
        this.H = true;
        ViewGroup viewGroup = (ViewGroup) findViewSure(R.id.rr_);
        this.f68706d = viewGroup;
        viewGroup.setOnClickListener(this);
        EditVideoPartManager editVideoPartManager = this.mParent;
        if (editVideoPartManager.U != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f68706d.getLayoutParams();
            layoutParams.bottomMargin = ViewUtils.dip2px(56.5f);
            this.f68706d.setLayoutParams(layoutParams);
        } else if (editVideoPartManager.l0()) {
            ViewGroup.LayoutParams layoutParams2 = this.f68706d.getLayoutParams();
            if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin = UIUtils.b(getContext(), 38.0f);
                this.f68706d.setLayoutParams(layoutParams2);
            }
        }
        this.f68707e = (CropNewView) findViewSure(R.id.rro);
        View findViewSure = findViewSure(R.id.rrk);
        this.f68708f = findViewSure;
        findViewSure.setOnClickListener(this);
        View findViewSure2 = findViewSure(R.id.rrm);
        this.f68709h = findViewSure2;
        findViewSure2.setOnClickListener(this);
        TextView textView = (TextView) findViewSure(R.id.rr8);
        this.f68710i = textView;
        textView.setOnClickListener(this);
        View findViewSure3 = findViewSure(R.id.rqk);
        this.f68711m = findViewSure3;
        findViewSure3.setOnClickListener(this);
        this.C = (TextView) findViewSure(R.id.rrn);
        TextView textView2 = (TextView) findViewSure(R.id.rrl);
        this.F = textView2;
        textView2.setOnClickListener(this);
        this.G = (TextView) findViewSure(R.id.f163796s21);
        this.f68707e.setCropListener(this);
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.u
    public boolean onBackPressed() {
        if (!this.I) {
            return false;
        }
        if (!l0()) {
            this.mParent.t(0);
        }
        id0.b.f("0X80075D5");
        ((IOCR) QRoute.api(IOCR.class)).report("0X800AAE5", 0);
        return true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (id5 == R.id.rqk) {
            this.f68707e.w();
            onBackPressed();
        } else if (id5 != R.id.rr8) {
            switch (id5) {
                case R.id.rrk /* 2097545419 */:
                    this.f68707e.r();
                    this.f68708f.setEnabled(false);
                    if (!this.N) {
                        this.f68710i.setEnabled(false);
                    }
                    EditVideoPartManager editVideoPartManager = this.mParent;
                    if (editVideoPartManager != null && editVideoPartManager.C.e() == 103) {
                        this.f68710i.setEnabled(false);
                    }
                    this.M = false;
                    o0(false);
                    id0.b.f("0X80075D3");
                    ((IOCR) QRoute.api(IOCR.class)).report("0X800AAE3", 0);
                    break;
                case R.id.rrl /* 2097545420 */:
                    r0();
                    break;
                case R.id.rrm /* 2097545421 */:
                    T();
                    this.f68707e.f();
                    id0.b.f("0X80075D4");
                    ((IOCR) QRoute.api(IOCR.class)).report("0X800AAE4", 0);
                    break;
            }
        } else if (!n0()) {
            this.K++;
            this.J = true;
            boolean e16 = this.f68707e.e();
            if (QLog.isColorLevel()) {
                QLog.d("EditPicCrop", 2, "crop remove face items" + e16);
            }
            if (e16) {
                Bundle bundle = this.mParent.Y;
                if (bundle != null) {
                    bundle.remove(FaceLayer.f67956d0);
                    this.mParent.Y.remove("DynamicFaceLayer");
                    this.mParent.Y.remove(com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.g.f67980d0);
                }
                Bitmap s16 = this.f68707e.s();
                if (s16 != null) {
                    this.D = s16;
                    com.tencent.aelight.camera.aioeditor.activity.richmedia.m.n().S(this.D);
                    this.mParent.e1(this.D, false);
                    if (!m0()) {
                        this.mParent.A0();
                    }
                }
                id0.b.f("0X80075D2");
                ((IOCR) QRoute.api(IOCR.class)).report("0X800AAE6", 0);
                fs.g.b(this.P);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private void q0() {
        this.I = false;
        this.f68706d.setVisibility(8);
        this.D = null;
        this.E = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void s0() {
        this.I = true;
        this.f68706d.setVisibility(0);
        if (!this.N) {
            this.f68710i.setEnabled(false);
            this.C.setVisibility(8);
        } else {
            this.C.setVisibility(0);
        }
        p0();
        this.f68708f.setEnabled(false);
        this.f68707e.setImageBitmap(this.D);
        this.E = this.D;
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.crop.CropNewView.a
    public void c(int i3) {
        if (i3 == 1) {
            this.f68709h.setEnabled(false);
        } else if (i3 == 2) {
            this.f68709h.setEnabled(true);
        }
    }

    private void r0() {
    }
}
