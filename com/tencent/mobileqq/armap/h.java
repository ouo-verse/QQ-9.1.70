package com.tencent.mobileqq.armap;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.armap.i;
import com.tencent.mobileqq.portal.o;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

/* compiled from: P */
/* loaded from: classes11.dex */
public class h {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    public static final String f199744b;

    /* renamed from: a, reason: collision with root package name */
    public b[] f199745a;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static class a implements b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public final String f199746a;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.f199746a = h.f199744b + "." + getClass().getSimpleName();
        }

        public static final String f(String str, String str2) {
            return com.tencent.mobileqq.armap.utils.a.a() + File.separator + "_res/" + str;
        }

        @Override // com.tencent.mobileqq.armap.h.b
        public boolean a(i.a aVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) aVar)).booleanValue();
            }
            String e16 = o.e(e(aVar));
            if (aVar.f199754c.equalsIgnoreCase(e16)) {
                return true;
            }
            if (QLog.isColorLevel()) {
                QLog.i(this.f199746a, 1, "checkDownloadFile.verify failed|" + e16 + "|" + aVar);
                return false;
            }
            return false;
        }

        @Override // com.tencent.mobileqq.armap.h.b
        public String b(i.a aVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (String) iPatchRedirector.redirect((short) 6, (Object) this, (Object) aVar);
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append(com.tencent.mobileqq.armap.utils.a.a());
            String str = File.separator;
            sb5.append(str);
            sb5.append("_res/");
            sb5.append(aVar.f199754c);
            sb5.append(str);
            return sb5.toString();
        }

        @Override // com.tencent.mobileqq.armap.h.b
        public boolean c(i.a aVar, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
                return true;
            }
            return ((Boolean) iPatchRedirector.redirect((short) 7, this, aVar, Boolean.valueOf(z16))).booleanValue();
        }

        @Override // com.tencent.mobileqq.armap.h.b
        public boolean d(i.a aVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVar)).booleanValue();
            }
            String e16 = e(aVar);
            try {
                boolean exists = new File(e16).exists();
                if (QLog.isColorLevel()) {
                    QLog.d(this.f199746a, 2, "needDownload.file exist|" + exists + "|" + aVar + "|" + e16);
                }
                if (!exists) {
                    return true;
                }
                return false;
            } catch (Throwable th5) {
                if (QLog.isColorLevel()) {
                    QLog.i(this.f199746a, 2, "isNeedDownload.exception happen.e=" + th5.getMessage());
                }
                th5.printStackTrace();
                return false;
            }
        }

        @Override // com.tencent.mobileqq.armap.h.b
        public String e(i.a aVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (String) iPatchRedirector.redirect((short) 4, (Object) this, (Object) aVar);
            }
            return f(aVar.f199754c, aVar.f199755d);
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public interface b {
        boolean a(i.a aVar);

        String b(i.a aVar);

        boolean c(i.a aVar, boolean z16);

        boolean d(i.a aVar);

        String e(i.a aVar);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(70865);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        f199744b = i.class.getSimpleName() + "." + h.class.getSimpleName();
    }

    public h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f199745a = new b[7];
        }
    }

    public b a(AppInterface appInterface, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (b) iPatchRedirector.redirect((short) 2, (Object) this, (Object) appInterface, i3);
        }
        if (i3 < 0 || i3 > 7) {
            i3 = 0;
        }
        b bVar = this.f199745a[i3];
        if (bVar == null) {
            if (i3 != 5) {
                if (i3 == 6) {
                    bVar = new com.tencent.mobileqq.troop.troopgame.d();
                }
            } else {
                bVar = new com.tencent.mobileqq.ar.ARPromotionMgr.a();
            }
        }
        if (bVar == null) {
            bVar = new a();
        }
        this.f199745a[i3] = bVar;
        return bVar;
    }
}
