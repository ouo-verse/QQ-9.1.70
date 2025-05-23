package com.tencent.mobileqq.filemanager.fileviewer.presenter;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.tencent.aelight.camera.qqstory.api.IAELaunchEditPic;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AdapterView;
import cooperation.peak.PeakConstants;
import java.util.List;

/* compiled from: P */
/* loaded from: classes12.dex */
public class f extends FileBrowserPresenterBase implements FileBrowserModelBase.e, FileBrowserModelBase.f {
    private int F;
    private List<FileBrowserModelBase.b> G;
    private boolean H;
    protected com.tencent.mobileqq.filemanager.fileviewer.viewer.b I;
    boolean J;
    private int K;
    private View.OnClickListener L;
    private AdapterView.OnItemClickListener M;
    private AdapterView.OnItemSelectedListener N;

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class a implements AdapterView.OnItemLongClickListener {
        a() {
        }

        @Override // com.tencent.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i3, long j3) {
            f.this.f208462h.R1();
            return true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            f.this.i0();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class c implements AdapterView.OnItemClickListener {
        c() {
        }

        @Override // com.tencent.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j3) {
            f.this.H = !r1.H;
            f fVar = f.this;
            com.tencent.mobileqq.filemanager.fileviewer.h hVar = fVar.f208463i;
            if (hVar != null) {
                hVar.g(fVar.H);
            }
            if (f.this.H) {
                f.this.I.n(false);
                f.this.I.o(false);
            } else {
                f.this.I.n(true);
                f.this.I();
            }
            f fVar2 = f.this;
            fVar2.I.u(fVar2.H);
        }
    }

    public f(FileBrowserModelBase fileBrowserModelBase, Activity activity) {
        super(fileBrowserModelBase, activity);
        this.F = 0;
        this.H = false;
        this.J = false;
        this.K = 0;
        this.L = new b();
        this.M = new c();
        this.N = new d();
        this.G = this.f208460e.W();
        this.F = this.f208460e.C();
        this.K = this.f208460e.C();
        com.tencent.mobileqq.filemanager.fileviewer.viewer.b bVar = new com.tencent.mobileqq.filemanager.fileviewer.viewer.b(activity);
        this.I = bVar;
        S(bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean e0(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String f0() {
        FileBrowserModelBase.b bVar = this.G.get(this.f208460e.C());
        if (bVar == null) {
            return null;
        }
        String d16 = bVar.d();
        if (TextUtils.isEmpty(d16)) {
            return bVar.e();
        }
        return d16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i0() {
        int i3;
        String f06 = f0();
        int i16 = 1;
        if (TextUtils.isEmpty(f06)) {
            QLog.i("PictureFilePresenter<QFile>", 1, "startEditPicture. but file path is null.");
            return;
        }
        Intent startEditPic = ((IAELaunchEditPic) QRoute.api(IAELaunchEditPic.class)).startEditPic(this.f208461f, f06, true, true, true, true, true, 2, 130, 7);
        startEditPic.putExtra("open_chatfragment", true);
        startEditPic.putExtra(PeakConstants.SEND_BUSINESS_TYPE, 1041);
        startEditPic.putExtra(PeakConstants.EANBLE_EDIT_PIC_TITLE_BAR, true);
        startEditPic.putExtra(AppConstants.Key.KEY_HELP_FORWARD_PIC, true);
        startEditPic.putExtra("key_allow_multiple_forward_from_limit", false);
        this.f208461f.startActivity(startEditPic);
        int F = this.f208460e.F();
        if (F != 3 && F != 4) {
            if (F != 7 && F != 8 && F != 9) {
                if (F != 11) {
                    i3 = 0;
                } else {
                    i16 = 2;
                }
            }
            i3 = i16;
        } else {
            i3 = 3;
        }
        ReportController.o(null, "dc00898", "", "", "0X800A1E2", "0X800A1E2", i3, 0, "", "", "", "");
        this.f208461f.overridePendingTransition(R.anim.f154548b2, R.anim.f154550b4);
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.presenter.FileBrowserPresenterBase
    public String E() {
        return this.f208460e.L();
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.presenter.FileBrowserPresenterBase
    public boolean G() {
        return false;
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.presenter.FileBrowserPresenterBase
    public boolean H() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.filemanager.fileviewer.presenter.FileBrowserPresenterBase
    public void I() {
        int T = this.f208460e.T();
        if (T != 2 && T != 5) {
            if (T == 6) {
                this.I.n(true);
                this.I.o(false);
            }
            super.I();
            if (this.f208460e.O() == 9501) {
                this.I.c();
                return;
            }
            return;
        }
        this.I.n(false);
        this.I.o(false);
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.presenter.FileBrowserPresenterBase
    public void K() {
        super.K();
        if (QLog.isColorLevel()) {
            QLog.w("PictureFilePresenter<QFile>", 1, "FileBrowserPresenter init: type = picture");
        }
        List<FileBrowserModelBase.b> list = this.G;
        if (list != null && list.get(this.F) != null && this.f208460e.p()) {
            this.I.B(e0(f0()));
            com.tencent.mobileqq.filemanager.util.d.h(BaseApplication.getContext().getString(R.string.b7d));
        }
        this.I.C(this.G);
        this.I.y(this.M);
        this.I.z(new a());
        this.I.A(this.N);
        this.I.x(this.L);
        this.I.w(this.f208460e.C());
        I();
        this.f208460e.N0(this);
        this.f208460e.O0(this);
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase.f
    public void a(float f16) {
        J(f16);
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase.f
    public void e() {
        this.I.n(true);
        this.I.o(false);
        I();
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase.f
    public void f() {
        I();
        this.G.get(this.f208460e.C()).a(this.f208460e.N());
        this.I.E();
        this.I.v();
        com.tencent.mobileqq.filemanager.fileviewer.g gVar = this.f208462h;
        if (gVar != null) {
            gVar.K1();
        }
    }

    public void g0(int i3) {
        this.f208460e.K0(i3);
        if (this.f208460e.d() && this.f208460e.D() != null) {
            this.I.o(true);
            this.I.n(false);
            J(0.0f);
            this.f208460e.D().a();
        }
        I();
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase.f
    public void j() {
        this.I.n(false);
        this.I.o(true);
        J(this.f208460e.S());
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase.e
    public void k(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            if (QLog.isColorLevel()) {
                QLog.e("PictureFilePresenter<QFile>", 1, "PictureFilePresenter onThumbDownload error : picture fileid is null!");
                return;
            }
            return;
        }
        FileBrowserModelBase.b bVar = this.G.get(this.f208460e.C());
        if (!bVar.c(str)) {
            return;
        }
        if (TextUtils.isEmpty(str2)) {
            if (QLog.isColorLevel()) {
                QLog.e("PictureFilePresenter<QFile>", 1, "PictureFilePresenter onThumbDownload error : picture thumbPath is null!");
            }
            bVar.setState(3);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.e("PictureFilePresenter<QFile>", 1, "PictureFilePresenter onThumbDownload suc : fileId[" + str + "] thumbPath[" + str2 + "]");
        }
        bVar.f(str2);
        bVar.setState(2);
        this.I.E();
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase.f
    public void l() {
        I();
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class d implements AdapterView.OnItemSelectedListener {
        d() {
        }

        @Override // com.tencent.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> adapterView, View view, int i3, long j3) {
            boolean z16;
            f.this.F = i3;
            f fVar = f.this;
            com.tencent.mobileqq.filemanager.fileviewer.viewer.b bVar = fVar.I;
            if (fVar.K == f.this.F) {
                z16 = true;
            } else {
                z16 = false;
            }
            bVar.D(z16);
            f.this.g0(i3);
            com.tencent.mobileqq.filemanager.fileviewer.h hVar = f.this.f208463i;
            if (hVar != null) {
                hVar.a(i3);
            }
            FileBrowserModelBase.b bVar2 = (FileBrowserModelBase.b) f.this.G.get(i3);
            if (bVar2 == null) {
                com.tencent.mobileqq.filemanager.util.d.h(BaseApplication.getContext().getString(R.string.b7d));
                return;
            }
            f.this.f208460e.d0().a(bVar2);
            f.this.f208460e.w0(i3, bVar2);
            f fVar2 = f.this;
            fVar2.I.B(fVar2.e0(fVar2.f0()));
            f.this.I.E();
            com.tencent.mobileqq.filemanager.fileviewer.g gVar = f.this.f208462h;
            if (gVar != null) {
                gVar.K1();
            }
            f.this.J = true;
        }

        @Override // com.tencent.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }
}
