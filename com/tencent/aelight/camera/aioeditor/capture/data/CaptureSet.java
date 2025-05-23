package com.tencent.aelight.camera.aioeditor.capture.data;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.m;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraControl;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes32.dex */
public class CaptureSet extends a implements b {
    public ArrayList<a> C;
    private final CopyOnWriteArraySet<a> D;
    public boolean E;
    float F;
    public long G;

    /* renamed from: m, reason: collision with root package name */
    public WeakReference<Activity> f66684m;

    public CaptureSet(Object obj) {
        super(obj);
        this.C = new ArrayList<>();
        this.D = new CopyOnWriteArraySet<>();
        this.E = false;
        this.F = 1.0f;
        this.G = 0L;
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.data.b
    public void a(a aVar) {
        if (QLog.isDevelopLevel()) {
            QLog.i("QCombo", 2, "onDownloadStart " + toString() + ", count=" + this.D.size());
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.data.b
    public void d(a aVar) {
        this.D.remove(aVar);
        if (QLog.isDevelopLevel()) {
            QLog.i("QCombo", 2, "onDownloadSuccess= " + toString() + ":" + aVar.toString() + ", count=" + this.D.size());
        }
        if (this.D.isEmpty()) {
            if (this.E) {
                u(2);
                m(4);
                return;
            }
            u(3);
            if (QLog.isDevelopLevel()) {
                QLog.i("QCombo", 2, "onDownloadFinish= " + toString() + ", count=" + this.D.size());
            }
            n();
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.data.a
    public int g(Activity activity, int i3) {
        boolean z16 = this instanceof h;
        if (z16) {
            h hVar = (h) this;
            if (c.w(hVar, i3)) {
                if (QLog.isDevelopLevel()) {
                    QLog.i("QCombo", 2, "apply already" + toString());
                }
                m.n().M(hVar, activity, i3);
                return 0;
            }
            QIMFilterCategoryItem qIMFilterCategoryItem = (QIMFilterCategoryItem) this.f66709i;
            if (qIMFilterCategoryItem != null && i3 == 0) {
                AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
                if ("back".equals(qIMFilterCategoryItem.E)) {
                    Bundle bundle = new Bundle();
                    bundle.putInt(CameraControl.f288075p, 2);
                    waitAppRuntime.notifyObservers(e.class, 970, true, bundle);
                } else if ("front".equals(qIMFilterCategoryItem.E) && com.tencent.mobileqq.shortvideo.mediadevice.a.k()) {
                    Bundle bundle2 = new Bundle();
                    bundle2.putInt(CameraControl.f288075p, 1);
                    waitAppRuntime.notifyObservers(e.class, 970, true, bundle2);
                }
            }
            h hVar2 = m.n().f66502i[i3];
            if (hVar2 != null) {
                hVar2.q(activity, i3);
            }
            m.n().M(hVar, activity, i3);
        }
        if (QLog.isDevelopLevel()) {
            QLog.i("QCombo", 2, "apply " + toString() + ", " + i3);
        }
        ArrayList arrayList = new ArrayList();
        Iterator<a> it = this.C.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next instanceof c) {
                arrayList.add(((c) next).f66710m);
            } else {
                next.g(activity, i3);
            }
        }
        if (z16) {
            d dVar = (d) fr.f.c(5);
            if (!dVar.L[i3].a()) {
                if (QLog.isDevelopLevel()) {
                    QLog.i("QCombo", 2, "apply " + toString() + ", " + i3 + " comboApplyFilterAborted");
                }
                return 0;
            }
            dVar.L[i3].h(null);
            m.a aVar = dVar.I;
            if (aVar != null) {
                QIMFilterCategoryItem y16 = dVar.y((h) this, aVar.c(i3).f66517c);
                m.n().V(y16, activity, i3);
                m.n().L(y16, i3);
                c.r(activity, arrayList, this, i3);
                Object obj = this.f66709i;
                if ((obj instanceof QIMFilterCategoryItem) && ((QIMFilterCategoryItem) obj).l() && i3 != 1 && i3 != 3) {
                    ((com.tencent.aelight.camera.aioeditor.capture.music.g) fr.f.d().g(8)).z(i3);
                }
            }
        }
        return 0;
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.data.a
    public int h() {
        if (QLog.isDevelopLevel()) {
            QLog.i("QCombo", 2, "download " + toString());
        }
        if (!NetworkUtil.isNetworkAvailable(BaseApplication.getContext())) {
            m(6);
            return 2;
        }
        ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.capture.data.CaptureSet.1
            @Override // java.lang.Runnable
            public void run() {
                CaptureSet.this.s();
            }
        });
        return 1;
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.data.a
    public int j() {
        StringBuilder sb5;
        boolean z16;
        boolean z17;
        String str;
        if (QLog.isColorLevel()) {
            sb5 = new StringBuilder("getState = ");
            sb5.append(toString());
            sb5.append("  ");
        } else {
            sb5 = null;
        }
        Iterator<a> it = this.C.iterator();
        while (true) {
            z16 = false;
            if (!it.hasNext()) {
                z17 = false;
                break;
            }
            a next = it.next();
            int j3 = next.j();
            if (sb5 != null) {
                sb5.append(j3);
                sb5.append("|");
                sb5.append(next.toString());
                sb5.append("   ");
            }
            if (j3 == 2) {
                z17 = false;
                z16 = true;
                break;
            }
            if (j3 == 1) {
                z17 = true;
                break;
            }
        }
        if (QLog.isDevelopLevel()) {
            if (sb5 != null) {
                str = sb5.toString();
            } else {
                str = "";
            }
            QLog.i("QCombo", 4, str);
        }
        if (z16) {
            u(2);
            return 2;
        }
        if (z17) {
            if (this.f66706e != 1) {
                h();
            }
            if (System.currentTimeMillis() - this.G <= 60000) {
                return 1;
            }
            u(2);
            m(5);
            return 2;
        }
        u(3);
        return 3;
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.data.a
    public void m(int i3) {
        super.m(i3);
        d dVar = (d) fr.f.i(5);
        if (dVar != null) {
            dVar.t(this, i3);
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.data.a
    public void n() {
        super.n();
        d dVar = (d) fr.f.i(5);
        if (dVar != null) {
            dVar.u(this);
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.data.a
    public void q(Activity activity, int i3) {
        if (QLog.isDevelopLevel()) {
            QLog.i("QCombo", 2, "unApply " + toString() + ", " + i3);
        }
        Iterator<a> it = this.C.iterator();
        while (it.hasNext()) {
            it.next().q(activity, i3);
        }
    }

    public void r(a aVar) {
        this.C.add(aVar);
        this.F = 1.0f / this.C.size();
    }

    public int s() {
        Iterator<a> it = this.C.iterator();
        boolean z16 = false;
        boolean z17 = false;
        while (it.hasNext()) {
            a next = it.next();
            if (next.j() == 2) {
                next.f(this);
                this.D.add(next);
                next.h();
                if (QLog.isDevelopLevel()) {
                    QLog.i("QCombo", 2, "download " + toString() + "  " + next.toString());
                }
                z16 = true;
            } else if (next.j() == 1) {
                this.D.add(next);
                next.f(this);
                if (QLog.isDevelopLevel()) {
                    QLog.i("QCombo", 2, "downloading " + toString() + ":" + next.toString());
                }
                z17 = true;
            }
        }
        this.G = System.currentTimeMillis();
        if (this.D.size() > 0) {
            u(1);
            l();
            d dVar = (d) fr.f.i(5);
            if (dVar != null) {
                dVar.C(this);
            }
        }
        if (!z16 && !z17) {
            u(3);
            n();
            return 3;
        }
        u(1);
        return 1;
    }

    public String t() {
        Object obj = this.f66709i;
        if (obj != null) {
            return ((QIMFilterCategoryItem) obj).f66697d;
        }
        return "unknown" + hashCode();
    }

    public void u(int i3) {
        this.f66706e = i3;
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.data.b
    public void c(a aVar, int i3) {
        this.E = true;
        this.D.remove(aVar);
        if (QLog.isDevelopLevel()) {
            QLog.i("QCombo", 2, "onDownloadError " + toString() + ":" + aVar.toString() + ", count=" + this.D.size());
        }
        if (this.D.isEmpty()) {
            u(2);
            m(i3);
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.data.a
    public float i() {
        try {
            Iterator<a> it = this.C.iterator();
            float f16 = 0.0f;
            while (it.hasNext()) {
                a next = it.next();
                float i3 = next.i();
                if (QLog.isDevelopLevel()) {
                    QLog.i("QCombo", 2, "getProgress " + next.toString() + " progress =" + i3);
                }
                f16 += this.F * i3;
            }
            return f16;
        } catch (Exception unused) {
            return 0.0f;
        }
    }
}
