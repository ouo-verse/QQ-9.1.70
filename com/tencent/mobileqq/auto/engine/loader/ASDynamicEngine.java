package com.tencent.mobileqq.auto.engine.loader;

import android.app.Application;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.auto.engine.lib.ASEngineConstants;
import com.tencent.mobileqq.auto.engine.lib.ASEnterBean;
import com.tencent.mobileqq.auto.engine.lib.ASInject;
import com.tencent.mobileqq.auto.engine.lib.delegateimpl.ASEngineImpl;
import com.tencent.mobileqq.auto.engine.lib.delegateimpl.ASToastImpl;
import com.tencent.mobileqq.auto.engine.loader.b;
import com.tencent.mobileqq.auto.engine.loader.selector.d;
import com.tencent.mobileqq.auto.engine.loader.selector.e;
import com.tencent.mobileqq.auto.engine.loader.selector.f;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QUA;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;
import uq3.c;

/* compiled from: P */
/* loaded from: classes11.dex */
public class ASDynamicEngine {
    static IPatchRedirector $redirector_;

    /* renamed from: k, reason: collision with root package name */
    private static final ConcurrentHashMap<String, ASDynamicEngine> f199846k;

    /* renamed from: a, reason: collision with root package name */
    private final com.tencent.mobileqq.auto.engine.loader.b f199847a;

    /* renamed from: b, reason: collision with root package name */
    private com.tencent.mobileqq.auto.engine.loader.parse.b f199848b;

    /* renamed from: c, reason: collision with root package name */
    private e f199849c;

    /* renamed from: d, reason: collision with root package name */
    private volatile boolean f199850d;

    /* renamed from: e, reason: collision with root package name */
    private volatile ASPluginBean f199851e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f199852f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f199853g;

    /* renamed from: h, reason: collision with root package name */
    private com.tencent.mobileqq.auto.engine.loader.net.a f199854h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f199855i;

    /* renamed from: j, reason: collision with root package name */
    private WeakReference<b> f199856j;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static abstract class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private com.tencent.mobileqq.auto.engine.loader.b f199857a;

        /* compiled from: P */
        /* renamed from: com.tencent.mobileqq.auto.engine.loader.ASDynamicEngine$a$a, reason: collision with other inner class name */
        /* loaded from: classes11.dex */
        class C7427a implements b.a {
            static IPatchRedirector $redirector_;

            C7427a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
                }
            }

            @Override // com.tencent.mobileqq.auto.engine.loader.b.a
            public boolean a(ASEnterBean aSEnterBean) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) aSEnterBean)).booleanValue();
                }
                return a.this.g(aSEnterBean);
            }
        }

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.f199857a = new com.tencent.mobileqq.auto.engine.loader.b();
            }
        }

        public ASDynamicEngine a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (ASDynamicEngine) iPatchRedirector.redirect((short) 6, (Object) this);
            }
            this.f199857a.g(f());
            this.f199857a.f(b());
            this.f199857a.h(new C7427a());
            return ASDynamicEngine.g(this.f199857a);
        }

        abstract List<String> b();

        public a c(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (a) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            }
            this.f199857a.d(str);
            return this;
        }

        public a d(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (a) iPatchRedirector.redirect((short) 3, (Object) this, z16);
            }
            this.f199857a.e(z16);
            return this;
        }

        public a e(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (a) iPatchRedirector.redirect((short) 4, (Object) this, z16);
            }
            this.f199857a.i(z16);
            return this;
        }

        abstract boolean f();

        public boolean g(ASEnterBean aSEnterBean) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) aSEnterBean)).booleanValue();
            }
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public interface b {
        boolean a();
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(40512);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 16)) {
            redirector.redirect((short) 16);
        } else {
            f199846k = new ConcurrentHashMap<>();
        }
    }

    ASDynamicEngine(com.tencent.mobileqq.auto.engine.loader.b bVar) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) bVar);
            return;
        }
        this.f199847a = bVar;
        QLog.d(q(bVar.a()), 1, "ASDynamicEngine init start" + hashCode());
        C();
        String q16 = q(bVar.a());
        StringBuilder sb5 = new StringBuilder();
        sb5.append("ASDynamicEngine init end");
        if (this.f199851e == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        sb5.append(z16);
        sb5.append(hashCode());
        QLog.d(q16, 1, sb5.toString());
    }

    private synchronized void C() {
        this.f199848b = new com.tencent.mobileqq.auto.engine.loader.parse.b(this.f199847a.a());
        e eVar = new e();
        this.f199849c = eVar;
        this.f199851e = eVar.d(this.f199847a.a());
        t();
        u();
        r();
        try {
            this.f199854h = new com.tencent.mobileqq.auto.engine.loader.net.a();
            e();
        } catch (Exception e16) {
            QLog.e(q(this.f199847a.a()), 1, "init net info manger  error:", e16);
        }
    }

    private void D() {
        this.f199851e = new ASPluginBean().setBusinessKey(this.f199847a.a()).setType(ASPluginBean.TYPE_NATIVE).setVersionCode(ASEngineUtils.getHostVersion());
    }

    public static void d(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            String i3 = i(str);
            ASDynamicEngine e16 = com.tencent.mobileqq.auto.engine.loader.a.e(i3);
            if (e16.v()) {
                return;
            }
            int versionCode = e16.k().getVersionCode();
            SharedPreferences sharedPreferences = MobileQQ.sMobileQQ.getSharedPreferences("AS_SHARE_PREFERENCE", 0);
            String str2 = "AS_CRASH_COUNT_" + i3 + e16.k().getVersionCode();
            int i16 = sharedPreferences.getInt(str2, 0) + 1;
            sharedPreferences.edit().putInt(str2, i16).apply();
            if (i16 >= c.f3()) {
                e16.m().e(versionCode, i3);
            }
            QLog.i(q(i3), 1, "crashCount: " + i16 + " crashVersion:" + versionCode + " key:" + str2 + "---------" + str);
        } catch (Exception e17) {
            QLog.i("ASDynamicEngine", 1, "check stack exception:" + e17);
        }
    }

    private void e() {
        if (MobileQQ.sProcessId != 1) {
            return;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.auto.engine.loader.ASDynamicEngine.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) ASDynamicEngine.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    ASDynamicEngine.this.s();
                    ASDynamicEngine.this.f199849c.f();
                } else {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                }
            }
        }, 64, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ASDynamicEngine g(com.tencent.mobileqq.auto.engine.loader.b bVar) {
        ConcurrentHashMap<String, ASDynamicEngine> concurrentHashMap = f199846k;
        if (!concurrentHashMap.containsKey(bVar.a())) {
            synchronized (ASDynamicEngine.class) {
                if (!concurrentHashMap.containsKey(bVar.a())) {
                    concurrentHashMap.put(bVar.a(), new ASDynamicEngine(bVar));
                }
            }
        }
        return concurrentHashMap.get(bVar.a());
    }

    private static String i(@NonNull String str) {
        String lowerCase = str.toLowerCase();
        Iterator<Map.Entry<String, ASDynamicEngine>> it = f199846k.entrySet().iterator();
        while (it.hasNext()) {
            com.tencent.mobileqq.auto.engine.loader.b j3 = it.next().getValue().j();
            List<String> b16 = j3.b();
            if (b16 != null) {
                Iterator<String> it5 = b16.iterator();
                while (it5.hasNext()) {
                    if (lowerCase.contains(it5.next().toLowerCase())) {
                        return j3.a();
                    }
                }
            }
        }
        return "";
    }

    public static ASDynamicEngine l(String str) {
        if (!TextUtils.isEmpty(str)) {
            ConcurrentHashMap<String, ASDynamicEngine> concurrentHashMap = f199846k;
            if (concurrentHashMap.containsKey(str)) {
                return concurrentHashMap.get(str);
            }
            return null;
        }
        return null;
    }

    private String p() {
        if (ASPluginBean.TYPE_NATIVE.equals(this.f199851e.getType())) {
            return ExifInterface.GPS_MEASUREMENT_IN_PROGRESS;
        }
        if (ASPluginBean.TYPE_NET.equals(this.f199851e.getType())) {
            return "N";
        }
        if (ASPluginBean.TYPE_DEBUG.equals(this.f199851e.getType())) {
            return "T";
        }
        return "U";
    }

    public static String q(String str) {
        if (TextUtils.isEmpty(str)) {
            return "ASDynamicEngine";
        }
        return "ASDynamicEngine_" + str;
    }

    private synchronized void r() {
        QLog.d(q(this.f199847a.a()), 1, "start initNativeApplication" + hashCode());
        if (!v()) {
            return;
        }
        String str = ASEngineConstants.AppName.sAPP.get(this.f199847a.a());
        if (TextUtils.isEmpty(str)) {
            QLog.d(q(this.f199847a.a()), 1, "appName is empty");
            return;
        }
        try {
            Class.forName(str).getMethod("init", Application.class).invoke(null, MobileQQ.sMobileQQ);
            QLog.d(q(this.f199847a.a()), 1, "init success:" + str);
        } catch (Exception e16) {
            e16.printStackTrace();
            QLog.d(q(this.f199847a.a()), 1, "init failed:" + str, e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        if (this.f199850d) {
            return;
        }
        ConcurrentHashMap<String, ASPluginBean> h16 = h();
        if (this.f199847a.c() != null) {
            this.f199849c.a(this.f199847a.c());
        }
        this.f199849c.b(new com.tencent.mobileqq.auto.engine.loader.selector.c()).b(new d(h16.get(ASPluginBean.TYPE_NATIVE))).b(new com.tencent.mobileqq.auto.engine.loader.selector.b(h16.get(ASPluginBean.TYPE_NET), h16.get(ASPluginBean.TYPE_NATIVE))).b(new f(h16.get(ASPluginBean.TYPE_NATIVE)));
        this.f199850d = true;
    }

    private void t() {
        ASInject.g().setToastDelegate(new ASToastImpl()).setAsEngineDelegate(new ASEngineImpl());
        QLog.d(q(this.f199847a.a()), 1, "inject delegate success" + hashCode());
    }

    private void u() {
        if (!v()) {
            ASEngineConstants.BusinessKeyToUUID.sUUID.put(this.f199847a.a(), this.f199851e.getUUid());
        }
    }

    public void A(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, z16);
            return;
        }
        this.f199852f = z16;
        QLog.d(q(this.f199847a.a()), 1, "setOnThirdTab:" + z16 + hashCode());
    }

    public void B(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, z16);
        } else {
            this.f199853g = z16;
        }
    }

    public boolean f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        QLog.d(q(this.f199847a.a()), 1, "forceNative:" + this.f199855i);
        return this.f199855i;
    }

    public ConcurrentHashMap<String, ASPluginBean> h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (ConcurrentHashMap) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.f199848b.a();
    }

    public com.tencent.mobileqq.auto.engine.loader.b j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (com.tencent.mobileqq.auto.engine.loader.b) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.f199847a;
    }

    public ASPluginBean k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (ASPluginBean) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.f199851e;
    }

    public com.tencent.mobileqq.auto.engine.loader.net.a m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.mobileqq.auto.engine.loader.net.a) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.f199854h;
    }

    public String n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (String) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return p() + "_" + (this.f199851e.getVersionCode() + "");
    }

    public String o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return QUA.getQUA3() + "_" + n();
    }

    public boolean v() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
        }
        if (this.f199851e == null) {
            QLog.d(q(this.f199847a.a()), 1, "mCurrentPluginBean is empty force native:");
            y(true);
            return true;
        }
        if (this.f199851e != null && ASPluginBean.TYPE_NATIVE.equals(this.f199851e.getType())) {
            z16 = true;
        } else {
            z16 = false;
        }
        QLog.d(q(this.f199847a.a()), 1, "isNative:" + z16);
        if (z16 || this.f199855i) {
            return true;
        }
        return false;
    }

    public boolean w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        WeakReference<b> weakReference = this.f199856j;
        if (weakReference == null) {
            return this.f199852f;
        }
        b bVar = weakReference.get();
        if (bVar != null) {
            return bVar.a();
        }
        return this.f199852f;
    }

    public boolean x() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this)).booleanValue();
        }
        return this.f199853g;
    }

    public boolean y(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, z16)).booleanValue();
        }
        QLog.d(q(this.f199847a.a()), 1, "setForceNative:" + z16);
        D();
        r();
        this.f199855i = z16;
        return z16;
    }

    public void z(b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) bVar);
        } else {
            this.f199856j = new WeakReference<>(bVar);
        }
    }
}
