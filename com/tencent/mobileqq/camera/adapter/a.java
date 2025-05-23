package com.tencent.mobileqq.camera.adapter;

import android.content.SharedPreferences;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes11.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: t, reason: collision with root package name */
    private static a f200998t;

    /* renamed from: a, reason: collision with root package name */
    public final boolean f200999a;

    /* renamed from: b, reason: collision with root package name */
    public int f201000b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f201001c;

    /* renamed from: d, reason: collision with root package name */
    public String f201002d;

    /* renamed from: e, reason: collision with root package name */
    public String f201003e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f201004f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f201005g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f201006h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f201007i;

    /* renamed from: j, reason: collision with root package name */
    public int f201008j;

    /* renamed from: k, reason: collision with root package name */
    public int f201009k;

    /* renamed from: l, reason: collision with root package name */
    public int f201010l;

    /* renamed from: m, reason: collision with root package name */
    public int f201011m;

    /* renamed from: n, reason: collision with root package name */
    public int f201012n;

    /* renamed from: o, reason: collision with root package name */
    public int f201013o;

    /* renamed from: p, reason: collision with root package name */
    public int f201014p;

    /* renamed from: q, reason: collision with root package name */
    public int f201015q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f201016r;

    /* renamed from: s, reason: collision with root package name */
    private final ArrayList<String> f201017s;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(71185);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            f200998t = null;
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f200999a = false;
        this.f201000b = -1;
        this.f201001c = false;
        this.f201004f = false;
        this.f201005g = false;
        this.f201006h = false;
        this.f201007i = false;
        this.f201008j = -1;
        this.f201009k = -1;
        this.f201010l = -1;
        this.f201011m = -1;
        this.f201012n = -1;
        this.f201013o = -1;
        this.f201014p = -1;
        this.f201015q = -1;
        this.f201016r = false;
        this.f201017s = new ArrayList<>();
    }

    public static a a() {
        if (f200998t == null) {
            synchronized (a.class) {
                if (f200998t == null) {
                    f200998t = new a();
                }
            }
        }
        return f200998t;
    }

    private void h(SharedPreferences sharedPreferences) {
        QLog.i("Q.camera.adapter.CameraAttrs", 1, "[loadValueFromPref] + BEGIN");
        this.f201001c = sharedPreferences.getBoolean("sysCameraOn", false);
        this.f201002d = sharedPreferences.getString("str_sysMinVersion", "1.0.0");
        this.f201003e = sharedPreferences.getString("str_sysMaxVersion", "1000.0.0");
        this.f201004f = sharedPreferences.getBoolean("disableCameraSDK", false);
        this.f201005g = sharedPreferences.getBoolean("readCamNumException", false);
        this.f201006h = sharedPreferences.getBoolean("disableFrontCamera", false);
        this.f201007i = sharedPreferences.getBoolean("beBlurredPreviewAfterTakePic", false);
        this.f201008j = sharedPreferences.getInt("int_frontCamRotate0", -1);
        this.f201009k = sharedPreferences.getInt("int_frontCamRotate90", -1);
        this.f201010l = sharedPreferences.getInt("int_frontCamRotate180", -1);
        this.f201011m = sharedPreferences.getInt("int_frontCamRotate270", -1);
        this.f201012n = sharedPreferences.getInt("int_backCamRotate0", -1);
        this.f201013o = sharedPreferences.getInt("int_backCamRotate90", -1);
        this.f201014p = sharedPreferences.getInt("int_backCamRotate180", -1);
        this.f201015q = sharedPreferences.getInt("int_backCamRotate270", -1);
        this.f201016r = sharedPreferences.getBoolean("frontCamFlipH", false);
        if (QLog.isColorLevel()) {
            QLog.i("Q.camera.adapter.CameraAttrs", 2, "[loadValueFromPref] + END");
        }
    }

    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        if (this.f201017s.contains("int_frontCamRotate0")) {
            return;
        }
        SharedPreferences h16 = com.tencent.mobileqq.camera.utils.a.h(BaseApplication.getContext());
        this.f201008j = h16.getInt("int_frontCamRotate0", -1);
        this.f201009k = h16.getInt("int_frontCamRotate90", -1);
        this.f201010l = h16.getInt("int_frontCamRotate180", -1);
        this.f201011m = h16.getInt("int_frontCamRotate270", -1);
        this.f201012n = h16.getInt("int_backCamRotate0", -1);
        this.f201013o = h16.getInt("int_backCamRotate90", -1);
        this.f201014p = h16.getInt("int_backCamRotate180", -1);
        this.f201015q = h16.getInt("int_backCamRotate270", -1);
        this.f201017s.add("int_frontCamRotate0");
    }

    public void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            if (this.f201017s.contains("disableCameraSDK")) {
                return;
            }
            this.f201004f = com.tencent.mobileqq.camera.utils.a.h(BaseApplication.getContext()).getBoolean("disableCameraSDK", false);
            this.f201017s.add("disableCameraSDK");
        }
    }

    public void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            if (this.f201017s.contains("frontCamFlipH")) {
                return;
            }
            this.f201016r = com.tencent.mobileqq.camera.utils.a.h(BaseApplication.getContext()).getBoolean("frontCamFlipH", false);
            this.f201017s.add("frontCamFlipH");
        }
    }

    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            if (this.f201017s.contains("readCamNumException")) {
                return;
            }
            SharedPreferences h16 = com.tencent.mobileqq.camera.utils.a.h(BaseApplication.getContext());
            this.f201005g = h16.getBoolean("readCamNumException", false);
            this.f201006h = h16.getBoolean("disableFrontCamera", false);
            this.f201017s.add("readCamNumException");
        }
    }

    public void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        if (this.f201017s.contains("sysCameraOn")) {
            return;
        }
        SharedPreferences h16 = com.tencent.mobileqq.camera.utils.a.h(BaseApplication.getContext());
        this.f201001c = h16.getBoolean("sysCameraOn", false);
        this.f201002d = h16.getString("str_sysMinVersion", "1.0.0");
        this.f201003e = h16.getString("str_sysMaxVersion", "1000.0.0");
        this.f201017s.add("sysCameraOn");
    }

    public void g(SharedPreferences sharedPreferences, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, sharedPreferences, Boolean.valueOf(z16));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("Q.camera.adapter.CameraAttrs", 4, "[loadConfigAndSave] + BEGIN");
        }
        int i3 = sharedPreferences.getInt("qcamera_conf_version", 0);
        if (i3 != this.f201000b && z16) {
            this.f201000b = i3;
            h(sharedPreferences);
        }
        if (QLog.isColorLevel()) {
            QLog.i("Q.camera.adapter.CameraAttrs", 4, "[loadConfigAndSave] + END");
        }
    }
}
