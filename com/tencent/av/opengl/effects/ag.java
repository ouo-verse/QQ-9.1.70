package com.tencent.av.opengl.effects;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.av.business.manager.pendant.b;
import com.tencent.avcore.util.AVCoreLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes3.dex */
public class ag {

    /* renamed from: g, reason: collision with root package name */
    private static ag f73937g;

    /* renamed from: a, reason: collision with root package name */
    private final Map<String, Drawable> f73938a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    private String f73939b = null;

    /* renamed from: c, reason: collision with root package name */
    private boolean f73940c = false;

    /* renamed from: d, reason: collision with root package name */
    private boolean f73941d = false;

    /* renamed from: e, reason: collision with root package name */
    private com.tencent.av.business.manager.pendant.b f73942e = null;

    /* renamed from: f, reason: collision with root package name */
    private int f73943f = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class a implements b.a {
        a() {
        }

        @Override // com.tencent.av.business.manager.pendant.b.a
        public void a() {
            ag.this.f73941d = false;
        }
    }

    ag() {
    }

    public static ag e() {
        if (f73937g == null) {
            synchronized (ag.class) {
                if (f73937g == null) {
                    f73937g = new ag();
                }
            }
        }
        return f73937g;
    }

    public boolean b() {
        if (this.f73943f <= 0) {
            return true;
        }
        return false;
    }

    public void c() {
        this.f73938a.clear();
        g();
        h();
        f(0);
    }

    public void d(long j3) {
        h();
        g();
        f(0);
        l("clearState_" + j3, null);
    }

    public void f(int i3) {
        if (!this.f73941d) {
            return;
        }
        com.tencent.av.business.manager.pendant.b bVar = this.f73942e;
        if (bVar != null) {
            bVar.e(i3, new a());
        }
        if (AVCoreLog.isColorLevel()) {
            AVCoreLog.i("TipsInfo", "hideErrorTips");
        }
    }

    public void g() {
        if (!this.f73940c) {
            return;
        }
        com.tencent.av.business.manager.pendant.b bVar = this.f73942e;
        if (bVar != null) {
            bVar.c(0);
        }
        this.f73940c = false;
        if (AVCoreLog.isColorLevel()) {
            AVCoreLog.i("TipsInfo", "hideFaceTips");
        }
    }

    public void h() {
        if (QLog.isColorLevel()) {
            QLog.w("TipsInfo", 1, "hideGestureTips, mCurGestureTip[" + this.f73939b + "]");
        }
        if (TextUtils.isEmpty(this.f73939b)) {
            return;
        }
        l("hideGestureTips", null);
        com.tencent.av.business.manager.pendant.b bVar = this.f73942e;
        if (bVar != null) {
            bVar.c(0);
        }
    }

    public void i(String str) {
        Drawable drawable;
        if (!TextUtils.isEmpty(str) && !this.f73938a.containsKey(str)) {
            Resources resources = BaseApplicationImpl.getApplication().getResources();
            if ("fivea".equals(str)) {
                drawable = resources.getDrawable(R.drawable.dbt);
            } else if ("palmup".equals(str)) {
                drawable = resources.getDrawable(R.drawable.dbu);
            } else if ("qheart".equals(str)) {
                drawable = resources.getDrawable(R.drawable.dbv);
            } else {
                drawable = null;
            }
            this.f73938a.put(str, drawable);
            if (AVCoreLog.isColorLevel()) {
                AVCoreLog.i("TipsInfo", "loadGestureTipIcon, drawable[" + drawable + "], gestureType[" + str + "]");
            }
        }
    }

    public void j() {
        this.f73940c = false;
    }

    public void k(com.tencent.av.business.manager.pendant.b bVar) {
        this.f73942e = bVar;
        if (QLog.isColorLevel()) {
            QLog.i("TipsInfo", 2, "setEffectPendantTips, tip[" + bVar + "]");
        }
    }

    public void l(String str, String str2) {
        if (QLog.isColorLevel()) {
            QLog.d("TipsInfo", 1, "setGestureType[" + str + "], GestureTips[" + this.f73939b + "->" + str2 + "]");
        }
        this.f73939b = str2;
    }

    public void m(String str) {
        if (!b()) {
            return;
        }
        g();
        h();
        com.tencent.av.business.manager.pendant.b bVar = this.f73942e;
        if (bVar != null) {
            bVar.d(str);
        }
        this.f73941d = true;
        if (AVCoreLog.isColorLevel()) {
            AVCoreLog.i("TipsInfo", "showErrorTips");
        }
    }

    public void n() {
        if (!b() || this.f73941d || this.f73940c) {
            return;
        }
        h();
        com.tencent.av.business.manager.pendant.b bVar = this.f73942e;
        if (bVar != null) {
            bVar.a(100);
        }
        this.f73940c = true;
        if (AVCoreLog.isColorLevel()) {
            AVCoreLog.i("TipsInfo", "showFaceTips");
        }
    }

    public void o(String str, String str2) {
        if (!b() || this.f73941d || TextUtils.equals(this.f73939b, str)) {
            return;
        }
        g();
        Drawable drawable = this.f73938a.get(str2);
        if (drawable != null) {
            com.tencent.av.business.manager.pendant.b bVar = this.f73942e;
            if (bVar != null) {
                bVar.b(drawable, str);
            }
        } else {
            com.tencent.av.business.manager.pendant.b bVar2 = this.f73942e;
            if (bVar2 != null) {
                bVar2.f(str);
            }
        }
        l("showGestureTips", str);
        if (AVCoreLog.isColorLevel()) {
            AVCoreLog.i("TipsInfo", "showGestureTips, wording[" + str + "], drawable[" + drawable + "]");
        }
    }

    public void p() {
        this.f73938a.clear();
    }
}
