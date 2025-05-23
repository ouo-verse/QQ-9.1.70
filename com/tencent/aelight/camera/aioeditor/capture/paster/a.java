package com.tencent.aelight.camera.aioeditor.capture.paster;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import com.tencent.aelight.camera.aioeditor.capture.data.k;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleLayout;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.qphone.base.util.QLog;
import hr.e;

/* compiled from: P */
/* loaded from: classes32.dex */
public class a extends com.tencent.aelight.camera.aioeditor.capture.data.a implements URLDrawable.URLDrawableListener {
    private final float C;
    private final float D;
    private final float E;
    hr.e F;
    int G;
    String H;
    int I;
    URLDrawable J;

    /* renamed from: m, reason: collision with root package name */
    private final String f66852m;

    private URLDrawable s() {
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        Drawable drawable = com.tencent.mobileqq.urldrawable.b.f306350a;
        obtain.mFailedDrawable = drawable;
        obtain.mLoadingDrawable = drawable;
        obtain.mUseAutoScaleParams = false;
        e.a h16 = this.F.h(this.H);
        if (h16 != null) {
            return URLDrawable.getDrawable(h16.f406049d, obtain);
        }
        if (!QLog.isColorLevel()) {
            return null;
        }
        QLog.d("QCombo.LPaster", 2, "createUrlDrawable no item =" + this.H);
        return null;
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.data.a
    public int g(Activity activity, int i3) {
        DoodleLayout b16 = com.tencent.aelight.camera.aioeditor.capture.util.b.c().b(i3);
        if (b16 == null) {
            return 0;
        }
        r(this.F, this.H, ScreenUtil.SCREEN_WIDTH, ScreenUtil.SCREEN_HIGHT, this.C, this.D, this.E, b16.m0());
        if (!QLog.isColorLevel()) {
            return 0;
        }
        QLog.d("QCombo.LPaster", 2, "apply id=" + this.f66852m + " name=" + this.H + " state=" + this.I);
        return 0;
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.data.a
    public synchronized int h() {
        if (this.J == null) {
            this.J = s();
        }
        URLDrawable uRLDrawable = this.J;
        if (uRLDrawable != null) {
            if (uRLDrawable.getStatus() == 1) {
                this.I = 3;
                this.G = 100;
            } else {
                this.J.startDownload();
                this.J.setURLDrawableListener(this);
                this.I = 1;
                this.G = 0;
                l();
            }
            if (QLog.isColorLevel()) {
                QLog.d("QCombo.LPaster", 2, "download id=" + this.f66852m + " name=" + this.H + " dstate=" + this.J.getStatus());
            }
        }
        return this.I;
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.data.a
    public synchronized float i() {
        return 1.0f;
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.data.a
    public synchronized int j() {
        if (this.J == null) {
            this.J = s();
        }
        if (this.J != null) {
            if (this.I != 3) {
                e.a h16 = this.F.h(this.H);
                if (h16 != null) {
                    if (AbsDownloader.getFile(h16.f406049d) == null) {
                        this.I = 2;
                    } else {
                        this.I = 3;
                        this.J.startDownload();
                    }
                } else if (QLog.isColorLevel()) {
                    QLog.d("QCombo.LPaster", 2, "getState no item =" + this.H);
                }
            }
        } else {
            this.I = 2;
        }
        return this.I;
    }

    @Override // com.tencent.image.URLDrawable.URLDrawableListener
    public void onLoadProgressed(URLDrawable uRLDrawable, int i3) {
        this.G = i3;
        this.I = 1;
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.data.a
    public void q(Activity activity, int i3) {
        e.a h16 = this.F.h(this.H);
        if (h16 != null) {
            DoodleLayout b16 = com.tencent.aelight.camera.aioeditor.capture.util.b.c().b(i3);
            if (b16 != null) {
                b16.m0().g(this.F.f405989b, h16.f406048c);
            }
        } else if (QLog.isColorLevel()) {
            QLog.d("QCombo.LPaster", 2, "unApply no item =" + this.H);
        }
        if (QLog.isColorLevel()) {
            QLog.d("QCombo.LPaster", 2, "apply id=" + this.f66852m + " name=" + this.H + " state=" + this.I);
        }
    }

    public String toString() {
        return "LP@" + this.f66852m + "@" + this.H + "@" + hashCode();
    }

    public a(hr.e eVar, String str, String str2, float f16, float f17, float f18) {
        super(null);
        this.G = 0;
        this.I = 2;
        this.f66852m = str;
        this.H = str2;
        this.F = eVar;
        this.C = f16;
        this.D = f17;
        this.E = f18;
        if (QLog.isColorLevel()) {
            QLog.d("QCombo.LPaster", 2, "create id=" + str + " name=" + str2);
        }
    }

    @Override // com.tencent.image.URLDrawable.URLDrawableListener
    public void onLoadCanceled(URLDrawable uRLDrawable) {
        this.G = 0;
        this.I = 2;
    }

    @Override // com.tencent.image.URLDrawable.URLDrawableListener
    public void onLoadFialed(URLDrawable uRLDrawable, Throwable th5) {
        this.G = 0;
        this.I = 2;
        m(4);
    }

    public void r(hr.e eVar, String str, int i3, int i16, float f16, float f17, float f18, k kVar) {
        if (kVar == null) {
            if (QLog.isColorLevel()) {
                QLog.d("QCombo.LPaster", 2, "try apply but no listener");
                return;
            }
            return;
        }
        URLDrawable uRLDrawable = this.J;
        if (uRLDrawable != null) {
            uRLDrawable.setBounds(0, 0, uRLDrawable.getIntrinsicWidth(), uRLDrawable.getIntrinsicHeight());
            e.a h16 = this.F.h(this.H);
            if (h16 != null) {
                h16.f406050e = uRLDrawable;
                kVar.f(h16, i3 * f16, i16 * f17, f18, this.f66708h);
                return;
            } else {
                if (QLog.isColorLevel()) {
                    QLog.d("QCombo.LPaster", 2, "applyLocationPaster no item =" + this.H);
                    return;
                }
                return;
            }
        }
        hd0.c.g("QCombo.LPaster", "can create drawable from urldrawable:" + this.J);
    }

    @Override // com.tencent.image.URLDrawable.URLDrawableListener
    public void onLoadSuccessed(URLDrawable uRLDrawable) {
        this.G = 100;
        this.I = 3;
        n();
    }
}
