package com.tencent.mobileqq.app.face;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.image.AbstractVideoImage;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.LogTag;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.app.face.util.AvatarOptimiseConfigUtil;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarManager;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarView;
import com.tencent.mobileqq.data.DynamicAvatar;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ah;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes11.dex */
public class h {
    static IPatchRedirector $redirector_;

    /* renamed from: v, reason: collision with root package name */
    public static int[] f195570v;

    /* renamed from: w, reason: collision with root package name */
    public static long f195571w;

    /* renamed from: x, reason: collision with root package name */
    public static boolean f195572x;

    /* renamed from: y, reason: collision with root package name */
    public static Object f195573y;

    /* renamed from: a, reason: collision with root package name */
    public Drawable f195574a;

    /* renamed from: b, reason: collision with root package name */
    public URLDrawable f195575b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f195576c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f195577d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f195578e;

    /* renamed from: f, reason: collision with root package name */
    public int f195579f;

    /* renamed from: g, reason: collision with root package name */
    public String f195580g;

    /* renamed from: h, reason: collision with root package name */
    public int f195581h;

    /* renamed from: i, reason: collision with root package name */
    public int f195582i;

    /* renamed from: j, reason: collision with root package name */
    public int f195583j;

    /* renamed from: k, reason: collision with root package name */
    public String f195584k;

    /* renamed from: l, reason: collision with root package name */
    public String f195585l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f195586m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f195587n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f195588o;

    /* renamed from: p, reason: collision with root package name */
    public int f195589p;

    /* renamed from: q, reason: collision with root package name */
    public String f195590q;

    /* renamed from: r, reason: collision with root package name */
    public DynamicAvatarManager f195591r;

    /* renamed from: s, reason: collision with root package name */
    public WeakReference<DynamicAvatarView> f195592s;

    /* renamed from: t, reason: collision with root package name */
    private a f195593t;

    /* renamed from: u, reason: collision with root package name */
    public WeakReference<h> f195594u;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public interface a {
        void a(int i3, Drawable drawable, String str);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(70165);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 13)) {
            redirector.redirect((short) 13);
            return;
        }
        f195570v = new int[]{2, 3, 5, 0, 4, 6, 1};
        f195572x = false;
        f195573y = new Object();
    }

    public h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            this.f195576c = true;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void h(AppInterface appInterface) {
        synchronized (f195573y) {
            f195572x = true;
        }
        AbstractVideoImage.pauseAll();
        DynamicAvatarManager dynamicAvatarManager = (DynamicAvatarManager) appInterface.getManager(QQManagerFactory.DYNAMIC_AVATAR_MANAGER);
        if (dynamicAvatarManager != null) {
            dynamicAvatarManager.C();
            ThreadManager.getSubThreadHandler().removeCallbacks(dynamicAvatarManager.Q);
        }
    }

    public static void i(AppInterface appInterface) {
        if (f195571w <= 0) {
            int n3 = ah.n();
            if (n3 >= 8) {
                f195571w = 100L;
            } else if (n3 >= 4) {
                f195571w = 200L;
            } else if (n3 >= 3) {
                f195571w = 400L;
            } else if (n3 >= 2) {
                f195571w = 800L;
            } else {
                f195571w = 1000L;
            }
        }
        ThreadManager.getSubThreadHandler().postDelayed(((DynamicAvatarManager) appInterface.getManager(QQManagerFactory.DYNAMIC_AVATAR_MANAGER)).Q, f195571w);
    }

    public Drawable a() {
        URLDrawable uRLDrawable;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Drawable) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        if (!this.f195576c || (uRLDrawable = this.f195575b) == null) {
            return this.f195574a;
        }
        return uRLDrawable;
    }

    public void b(boolean z16, DynamicAvatar dynamicAvatar) {
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z18 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Boolean.valueOf(z16), dynamicAvatar);
            return;
        }
        this.f195591r.h(this);
        if (z16 && this.f195591r.w(this.f195589p) && this.f195591r.x()) {
            z17 = true;
        } else {
            z17 = false;
        }
        this.f195576c = z17;
        if (!z17) {
            return;
        }
        if (!this.f195588o && !NetworkUtil.isWifiConnected(BaseApplication.getContext()) && this.f195578e) {
            if (QLog.isDevelopLevel()) {
                QLog.d(LogTag.TAG_DYNAMIC_AVATAR, 2, "getDynamicAvatar mustWifi but isWifiConnected false");
                return;
            }
            return;
        }
        if (QLog.isDevelopLevel()) {
            QLog.i(LogTag.TAG_DYNAMIC_AVATAR, 2, "getDynamicAvatar uin: " + this.f195580g + " source: " + this.f195589p);
        }
        if (!this.f195588o && dynamicAvatar != null) {
            if (dynamicAvatar != null) {
                this.f195584k = DynamicAvatarManager.r(this.f195581h, this.f195583j, dynamicAvatar);
                this.f195585l = DynamicAvatarManager.r(this.f195581h, 640, dynamicAvatar);
                if (this.f195577d && TextUtils.isEmpty(this.f195584k)) {
                    this.f195584k = DynamicAvatarManager.r(17, this.f195583j, dynamicAvatar);
                    this.f195585l = DynamicAvatarManager.r(17, 640, dynamicAvatar);
                }
                if (!TextUtils.isEmpty(this.f195584k)) {
                    this.f195586m = true;
                }
                if (QLog.isDevelopLevel()) {
                    QLog.i(LogTag.TAG_DYNAMIC_AVATAR, 2, "initValue url: " + this.f195584k);
                }
            }
            if (!TextUtils.isEmpty(this.f195584k)) {
                this.f195591r.o(this);
                return;
            }
            return;
        }
        if (QLog.isDevelopLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("getDynamicAvatar mIsForceUpdate: ");
            sb5.append(this.f195588o);
            sb5.append(" dynamicAvatar is null:");
            if (dynamicAvatar == null) {
                z18 = true;
            }
            sb5.append(z18);
            QLog.i(LogTag.TAG_DYNAMIC_AVATAR, 2, sb5.toString());
        }
        this.f195591r.o(this);
    }

    public void c(AppInterface appInterface, Drawable drawable, int i3, int i16, String str, int i17, int i18, boolean z16, int i19, boolean z17, boolean z18, boolean z19, DynamicAvatar dynamicAvatar, boolean z26) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, appInterface, drawable, Integer.valueOf(i3), Integer.valueOf(i16), str, Integer.valueOf(i17), Integer.valueOf(i18), Boolean.valueOf(z16), Integer.valueOf(i19), Boolean.valueOf(z17), Boolean.valueOf(z18), Boolean.valueOf(z19), dynamicAvatar, Boolean.valueOf(z26));
            return;
        }
        this.f195580g = str;
        this.f195579f = i18;
        this.f195589p = i19;
        this.f195578e = z18;
        this.f195577d = z19;
        this.f195588o = z17;
        this.f195574a = drawable;
        if (i16 == 200) {
            this.f195582i = 17;
        } else {
            this.f195582i = 18;
        }
        if (i3 == 32) {
            this.f195581h = 18;
        } else {
            this.f195581h = 17;
        }
        this.f195583j = i17;
        this.f195587n = z16;
        this.f195584k = "";
        this.f195585l = "";
        this.f195586m = false;
        this.f195590q = DynamicAvatarManager.l(i3, i16, str, i17);
        if (!z26) {
            this.f195575b = null;
        }
        this.f195591r = (DynamicAvatarManager) appInterface.getManager(QQManagerFactory.DYNAMIC_AVATAR_MANAGER);
    }

    public void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else if (e() && this.f195592s.get() != null) {
            this.f195592s.get().d();
        }
    }

    public boolean e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        WeakReference<DynamicAvatarView> weakReference = this.f195592s;
        if (weakReference == null || weakReference.get() == null) {
            return false;
        }
        DynamicAvatarView dynamicAvatarView = this.f195592s.get();
        if (dynamicAvatarView.E == this) {
            return true;
        }
        QLog.e(LogTag.TAG_DYNAMIC_AVATAR, 1, "mDynamicFaceDrawable is changed : " + this + " " + dynamicAvatarView.E);
        return false;
    }

    public boolean f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        if (a() == this.f195575b) {
            return true;
        }
        return false;
    }

    public void g(int i3, Drawable drawable, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Integer.valueOf(i3), drawable, str);
            return;
        }
        a aVar = this.f195593t;
        if (aVar != null) {
            aVar.a(i3, drawable, str);
        }
    }

    public void j(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) aVar);
        } else {
            this.f195593t = aVar;
        }
    }

    public boolean k(URLDrawable uRLDrawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) uRLDrawable)).booleanValue();
        }
        if (!e()) {
            return false;
        }
        if (this.f195584k.equals(this.f195592s.get().F)) {
            if (QLog.isDevelopLevel()) {
                QLog.w(LogTag.TAG_DYNAMIC_AVATAR, 2, "setVideoDrawable url equals currentUrl");
            }
            return false;
        }
        if (QLog.isDevelopLevel()) {
            QLog.w(LogTag.TAG_DYNAMIC_AVATAR, 2, "truly setVideoDrawable");
        }
        this.f195592s.get().F = this.f195584k;
        this.f195575b = uRLDrawable;
        if (f195572x) {
            return false;
        }
        d();
        return true;
    }

    public h(AppInterface appInterface, int i3, int i16, String str, byte b16, int i17, boolean z16, Drawable drawable, Drawable drawable2, FaceDrawable.OnLoadingStateChangeListener onLoadingStateChangeListener, int i18, boolean z17, boolean z18, boolean z19, boolean z26, int i19, boolean z27, int i26) {
        h hVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, appInterface, Integer.valueOf(i3), Integer.valueOf(i16), str, Byte.valueOf(b16), Integer.valueOf(i17), Boolean.valueOf(z16), drawable, drawable2, onLoadingStateChangeListener, Integer.valueOf(i18), Boolean.valueOf(z17), Boolean.valueOf(z18), Boolean.valueOf(z19), Boolean.valueOf(z26), Integer.valueOf(i19), Boolean.valueOf(z27), Integer.valueOf(i26));
            return;
        }
        this.f195576c = true;
        c(appInterface, null, i3, i16, str, i18, i17, z18, i19, z17, z26, z16, null, false);
        if (appInterface instanceof QQAppInterface) {
            if (AvatarOptimiseConfigUtil.b()) {
                this.f195574a = new com.tencent.mobileqq.proavatar.g(appInterface, i3, i16, str, b16, i17, i18, z16, drawable, drawable2, onLoadingStateChangeListener, z19, z27, i26);
                hVar = this;
            } else {
                hVar = this;
                hVar.f195574a = new FaceDrawableImpl(appInterface, i3, i16, str, b16, i17, i18, z16, drawable, drawable2, onLoadingStateChangeListener, z19, z27, i26);
            }
        } else {
            hVar = this;
            hVar.f195574a = new NearByFaceDrawable(appInterface, i3, i16, str, (byte) 1, i17, z16, drawable, drawable2, onLoadingStateChangeListener, z19);
        }
        hVar.f195594u = new WeakReference<>(hVar);
        if (i16 != 205) {
            hVar.b(z19, null);
        }
    }

    public h(AppInterface appInterface, Drawable drawable, int i3, int i16, String str, int i17, boolean z16, DynamicAvatar dynamicAvatar, boolean z17, boolean z18, boolean z19, boolean z26, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, appInterface, drawable, Integer.valueOf(i3), Integer.valueOf(i16), str, Integer.valueOf(i17), Boolean.valueOf(z16), dynamicAvatar, Boolean.valueOf(z17), Boolean.valueOf(z18), Boolean.valueOf(z19), Boolean.valueOf(z26), Integer.valueOf(i18));
            return;
        }
        this.f195576c = true;
        c(appInterface, drawable, i3, i16, str, i17, 0, z16, i18, z26, z19, z17, dynamicAvatar, false);
        this.f195594u = new WeakReference<>(this);
        if (i16 != 205) {
            b(z18, dynamicAvatar);
        }
    }
}
