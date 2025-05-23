package com.tencent.aelight.camera.aioeditor.capture.paster;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import com.tencent.aelight.camera.aioeditor.capture.data.h;
import com.tencent.aelight.camera.aioeditor.capture.data.k;
import com.tencent.aelight.camera.aioeditor.capture.paster.QIMInformationPasterManager;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleLayout;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.ApngDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.vas.VasApngUtil;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.IEventReceiver;
import fr.f;
import hr.d;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.Calendar;
import java.util.HashMap;

/* loaded from: classes32.dex */
public class CaptureComboInformationPaster extends com.tencent.aelight.camera.aioeditor.capture.data.a implements IEventReceiver, d.b {
    public static HashMap<String, Drawable> N = new HashMap<>();
    hr.d C;
    int D;
    private float E;
    private String F;
    private QIMInformationPasterManager G;
    private d.c H;
    private b I;
    private float J;
    private float K;
    private String L;
    private String M;

    /* renamed from: m, reason: collision with root package name */
    private final String f66804m;

    /* JADX INFO: Access modifiers changed from: private */
    public void u(Drawable drawable, String str, int i3, k kVar) {
        if (QLog.isColorLevel()) {
            QLog.d("CaptureComboInformationPaster", 2, "applyApngInfoPaster w=" + drawable.getIntrinsicWidth() + " px=" + this.J + " py=" + this.K + " scale=" + this.E);
        }
        kVar.d(new vr.a(this.C.f405989b, this.M, drawable, i3), ScreenUtil.SCREEN_WIDTH * this.J, ScreenUtil.SCREEN_HIGHT * this.K, this.E, str, this.f66708h);
    }

    private void v(DoodleLayout doodleLayout, final k kVar) {
        d.c cVar = this.H;
        if (cVar.f406025d == 8) {
            if (doodleLayout != null) {
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.capture.paster.CaptureComboInformationPaster.1
                    @Override // java.lang.Runnable
                    public void run() {
                        CaptureComboInformationPaster captureComboInformationPaster = CaptureComboInformationPaster.this;
                        captureComboInformationPaster.w(captureComboInformationPaster.H, kVar);
                    }
                }, 16, null, true);
            }
        } else {
            kVar.a(cVar, this.M, this.J * ScreenUtil.SCREEN_WIDTH, ScreenUtil.SCREEN_HIGHT * this.K, this.E);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00e2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void w(d.c cVar, k kVar) {
        String str;
        String c16 = com.tencent.aelight.camera.aioeditor.capture.util.c.c(cVar);
        if (cVar.f406025d == 8) {
            int i3 = Calendar.getInstance().get(7) - 1;
            str = c16 + File.separator + (i3 != 0 ? i3 : 7) + ".apng";
        } else {
            str = c16 + File.separator + "city.apng";
        }
        int[] iArr = {13};
        try {
            if (!ApngDrawable.isApngFile(new File(str))) {
                if (QLog.isColorLevel()) {
                    QLog.d("CaptureComboInformationPaster", 2, "applyNormalPaster isApngFile not valid path=" + str);
                    return;
                }
                return;
            }
        } catch (IOException e16) {
            e16.printStackTrace();
        }
        URLDrawable apngDrawable = VasApngUtil.getApngDrawable(BaseApplicationImpl.sApplication.getRuntime(), str, "-Dynamic-", null, iArr, "-Dynamic-", null);
        if (apngDrawable != null) {
            int status = apngDrawable.getStatus();
            if (status != 1) {
                if (QLog.isColorLevel()) {
                    QLog.e("CaptureComboInformationPaster", 2, "urlDrawable is not  SUCCESSED :" + status);
                }
                apngDrawable.setURLDrawableListener(new a(str, apngDrawable, kVar));
                N.put(str, apngDrawable);
                if (status == 2) {
                    apngDrawable.restartDownload();
                } else {
                    apngDrawable.startDownload();
                }
            }
            if (apngDrawable == null) {
                apngDrawable.setBounds(0, 0, apngDrawable.getIntrinsicWidth(), apngDrawable.getIntrinsicHeight());
                u(apngDrawable, str, 1, kVar);
                return;
            } else {
                hd0.c.g("CaptureComboInformationPaster", "can not create drawable from name:" + this.C.f405989b);
                return;
            }
        }
        apngDrawable = null;
        if (apngDrawable == null) {
        }
    }

    @Override // hr.d.b
    public void e() {
        com.tencent.aelight.camera.aioeditor.capture.data.d dVar;
        h v3;
        d.c cVar = this.H;
        if (cVar == null || cVar.f406025d != 7 || (v3 = (dVar = (com.tencent.aelight.camera.aioeditor.capture.data.d) f.c(5)).v(this.L)) == null) {
            return;
        }
        v3.j();
        dVar.B(v3);
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.data.a
    public int g(Activity activity, int i3) {
        k m06;
        DoodleLayout b16 = com.tencent.aelight.camera.aioeditor.capture.util.b.c().b(i3);
        if (b16 == null || this.H == null || (m06 = b16.m0()) == null) {
            return 0;
        }
        v(b16, m06);
        if (!QLog.isColorLevel()) {
            return 0;
        }
        QLog.d("CaptureComboInformationPaster", 2, "apply id=" + this.f66804m + " name=" + this.F + " state=" + this.D);
        return 0;
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.data.a
    public synchronized int h() {
        if (this.H != null) {
            if (this.I == null) {
                this.I = new b(this);
            }
            this.G.n(this.H, this.I);
            l();
            this.D = 1;
            if (QLog.isColorLevel()) {
                QLog.d("CaptureComboInformationPaster", 2, "create mState=" + this.D + " id=" + this.f66804m);
            }
        } else {
            m(4);
        }
        return this.D;
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.data.a
    public synchronized float i() {
        b bVar = this.I;
        if (bVar == null) {
            return 1.0f;
        }
        return bVar.c();
    }

    @Override // com.tribe.async.dispatch.IEventReceiver
    public boolean isValidate() {
        return this.D == 1;
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.data.a
    public synchronized int j() {
        d.c cVar = this.H;
        if (cVar != null) {
            if (this.G.k(cVar)) {
                this.D = 3;
            } else if (this.G.j(this.H)) {
                this.D = 1;
            } else {
                this.D = 2;
            }
        }
        return this.D;
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.data.a
    public void q(Activity activity, int i3) {
        if (this.H != null) {
            DoodleLayout b16 = com.tencent.aelight.camera.aioeditor.capture.util.b.c().b(i3);
            if (b16 != null) {
                b16.m0().g(this.C.f405989b, this.M);
            }
        } else if (QLog.isColorLevel()) {
            QLog.d("CaptureComboInformationPaster", 2, "unApply no item =" + this.F);
        }
        if (QLog.isColorLevel()) {
            QLog.d("CaptureComboInformationPaster", 2, "unApply id=" + this.f66804m + " name=" + this.F + " state=" + this.D);
        }
    }

    public String toString() {
        return "NP@" + this.f66804m + "@" + hashCode();
    }

    public CaptureComboInformationPaster(hr.d dVar, String str, String str2, String str3, float f16, float f17, float f18) {
        super(null);
        this.D = 2;
        this.f66804m = str2;
        this.C = dVar;
        this.E = f18;
        this.F = str3;
        this.J = f16;
        this.K = f17;
        this.G = (QIMInformationPasterManager) f.d().g(12);
        d.c g16 = this.C.g(str3);
        this.H = g16;
        this.L = str;
        if (g16 != null) {
            g16.b(this);
            this.M = "CaptureComboInformationPaster_" + this.H.f406024c + "_" + this.H.f406023b;
        }
        if (QLog.isColorLevel()) {
            QLog.d("CaptureComboInformationPaster", 2, "package id=" + str2 + " posterId=" + str3);
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.data.a
    public void m(int i3) {
        this.D = 2;
        super.m(i3);
    }

    /* loaded from: classes32.dex */
    private static class b implements QIMInformationPasterManager.b {

        /* renamed from: a, reason: collision with root package name */
        private float f66810a;

        /* renamed from: b, reason: collision with root package name */
        private WeakReference<CaptureComboInformationPaster> f66811b;

        public b(CaptureComboInformationPaster captureComboInformationPaster) {
            this.f66811b = new WeakReference<>(captureComboInformationPaster);
        }

        @Override // com.tencent.aelight.camera.aioeditor.capture.paster.QIMInformationPasterManager.b
        public void a(float f16, String str, int i3) {
            this.f66810a = f16;
        }

        public float c() {
            return this.f66810a;
        }

        @Override // com.tencent.aelight.camera.aioeditor.capture.paster.QIMInformationPasterManager.b
        public void b(boolean z16, String str, d.c cVar) {
            if (z16) {
                this.f66810a = 1.0f;
                if (this.f66811b.get() != null) {
                    this.f66811b.get().n();
                    return;
                }
                return;
            }
            this.f66810a = 0.0f;
            if (this.f66811b.get() != null) {
                this.f66811b.get().m(0);
            }
        }
    }

    @Override // hr.d.b
    public void b(boolean z16) {
        if (z16) {
            return;
        }
        m(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class a implements URLDrawable.URLDrawableListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f66806d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ URLDrawable f66807e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ k f66808f;

        a(String str, URLDrawable uRLDrawable, k kVar) {
            this.f66806d = str;
            this.f66807e = uRLDrawable;
            this.f66808f = kVar;
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadFialed(URLDrawable uRLDrawable, Throwable th5) {
            CaptureComboInformationPaster.N.remove(this.f66806d);
            if (QLog.isColorLevel()) {
                QLog.d("CaptureComboInformationPaster", 2, "applyApngInfoPaster onLoadFialed");
            }
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadSuccessed(URLDrawable uRLDrawable) {
            CaptureComboInformationPaster.N.remove(this.f66806d);
            uRLDrawable.setBounds(0, 0, uRLDrawable.getIntrinsicWidth(), uRLDrawable.getIntrinsicHeight());
            CaptureComboInformationPaster.this.u(this.f66807e, this.f66806d, 1, this.f66808f);
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadCanceled(URLDrawable uRLDrawable) {
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadProgressed(URLDrawable uRLDrawable, int i3) {
        }
    }
}
