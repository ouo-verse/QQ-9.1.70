package com.tencent.mobileqq.soload.config;

import android.text.TextUtils;
import com.tencent.mobileqq.config.am;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.soload.biz.entity.SoInfo;
import com.tencent.mobileqq.soload.biz.entity.SoLoadConfBean;
import com.tencent.mobileqq.soload.config.SoLoaderConfProcessor;
import com.tencent.mobileqq.soload.entity.SoConfig;
import com.tencent.mobileqq.soload.util.f;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes18.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    private static volatile a f288646b;

    /* renamed from: a, reason: collision with root package name */
    SoConfig f288647a;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.soload.config.a$a, reason: collision with other inner class name */
    /* loaded from: classes18.dex */
    class C8600a implements SoLoaderConfProcessor.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f288648a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f288649b;

        C8600a(c cVar, String str) {
            this.f288648a = cVar;
            this.f288649b = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, a.this, cVar, str);
            }
        }

        @Override // com.tencent.mobileqq.soload.config.SoLoaderConfProcessor.a
        public void a(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3);
                return;
            }
            c cVar = this.f288648a;
            if (cVar != null) {
                cVar.a(i3, a.this.d(this.f288649b));
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class b implements SoLoaderConfProcessor.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f288651a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f288652b;

        b(c cVar, String str) {
            this.f288651a = cVar;
            this.f288652b = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, a.this, cVar, str);
            }
        }

        @Override // com.tencent.mobileqq.soload.config.SoLoaderConfProcessor.a
        public void a(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3);
                return;
            }
            c cVar = this.f288651a;
            if (cVar != null) {
                cVar.a(i3, a.this.d(this.f288652b));
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public interface c {
        void a(int i3, SoInfo soInfo);
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("SoLoadWidget.SoConfigManager", 2, "SoConfigManager init");
        }
        this.f288647a = SoConfig.g();
    }

    public static a b() {
        if (f288646b == null) {
            synchronized (a.class) {
                if (f288646b == null) {
                    f288646b = new a();
                }
            }
        }
        return f288646b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SoInfo d(String str) {
        Map<String, SoInfo> map;
        SoConfig soConfig = this.f288647a;
        if (soConfig != null && (map = soConfig.f288676d) != null) {
            return map.get(str);
        }
        return null;
    }

    public static boolean g(com.tencent.mobileqq.soload.entity.a aVar) {
        if (aVar != null) {
            if (aVar.e()) {
                if (Math.abs(NetConnInfoCenter.getServerTimeMillis() - f.g()) < 600000) {
                    return true;
                }
                return false;
            }
            if (aVar.f()) {
                if (Math.abs(NetConnInfoCenter.getServerTimeMillis() - f.g()) < 1800000) {
                    return true;
                }
                return false;
            }
        }
        if (Math.abs(NetConnInfoCenter.getServerTimeMillis() - f.g()) < 600000) {
            return true;
        }
        return false;
    }

    public void c(String str, com.tencent.mobileqq.soload.entity.a aVar, c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, str, aVar, cVar);
            return;
        }
        if (g(aVar)) {
            if (cVar != null) {
                cVar.a(0, d(str));
            }
        } else {
            QLog.i("SoLoadWidget.SoConfigManager", 1, "[getNewestConfig], name=" + str);
            ((SoLoaderConfProcessor) am.s().e(526)).c(new b(cVar, str), false);
        }
    }

    public SoInfo e(String str, c cVar, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (SoInfo) iPatchRedirector.redirect((short) 2, this, str, cVar, Boolean.valueOf(z16));
        }
        if (QLog.isColorLevel()) {
            QLog.i("SoLoadWidget.SoConfigManager", 2, "getSoInfo, name=" + str + ",isSync=" + z16 + ", SoConfig=" + this.f288647a);
        }
        if (this.f288647a.b() && this.f288647a.c(str)) {
            if (z16) {
                return d(str);
            }
            if (cVar != null) {
                cVar.a(0, d(str));
            }
            return null;
        }
        QLog.i("SoLoadWidget.SoConfigManager", 1, "isConfigValid=" + this.f288647a.b() + ",isContainSo=" + this.f288647a.c(str) + ",name=" + str + ",isSync:" + z16);
        if (z16) {
            return null;
        }
        ((SoLoaderConfProcessor) am.s().e(526)).c(new C8600a(cVar, str), !this.f288647a.b());
        return null;
    }

    @Deprecated
    public Map<String, SoInfo> f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Map) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.f288647a.f288676d;
    }

    public void h(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str, (Object) str2);
            return;
        }
        SoInfo d16 = d(str);
        if (d16 != null && TextUtils.equals(d16.ver, str2)) {
            this.f288647a.f288676d.remove(str);
            this.f288647a.j(true);
        }
    }

    public void i(SoLoadConfBean soLoadConfBean) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) soLoadConfBean);
        } else {
            this.f288647a.l(soLoadConfBean);
        }
    }
}
