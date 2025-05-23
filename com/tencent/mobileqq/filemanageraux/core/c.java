package com.tencent.mobileqq.filemanageraux.core;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.filemanager.api.IFMConfig;
import com.tencent.mobileqq.filemanager.api.IQQFileEngine;
import com.tencent.mobileqq.filemanager.api.IQQFileTempUtils;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.core.f;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes12.dex */
public class c extends f {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    AppInterface f209592b;

    /* renamed from: c, reason: collision with root package name */
    String f209593c;

    /* renamed from: d, reason: collision with root package name */
    String f209594d;

    /* renamed from: e, reason: collision with root package name */
    FMObserver f209595e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class a extends FMObserver {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) c.this);
            }
        }

        @Override // com.tencent.mobileqq.filemanager.app.FMObserver
        protected void V(boolean z16, int i3, String str, String str2, String str3, String str4, String str5, int i16, String str6) {
            String str7;
            String valueOf;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Integer.valueOf(i3), str, str2, str3, str4, str5, Integer.valueOf(i16), str6);
                return;
            }
            if (QLog.isDevelopLevel()) {
                QLog.i("PreviewStep_1", 4, "SUCCESS OnFileWeiYunPreview harcode[" + ((IFMConfig) QRoute.api(IFMConfig.class)).getUserHarCodeIp() + "]");
            }
            if (((IFMConfig) QRoute.api(IFMConfig.class)).getUserHarCodeIp()) {
                str7 = "183.61.37.13";
                valueOf = "443";
            } else {
                if (str4 != null && str4.length() > 0) {
                    str7 = str4;
                } else {
                    str7 = str5;
                }
                valueOf = String.valueOf(i16);
            }
            String str8 = str7;
            String str9 = valueOf;
            c cVar = c.this;
            com.tencent.mobileqq.filemanager.core.b bVar = cVar.f207649a;
            if (bVar == null) {
                return;
            }
            bVar.a(z16, str8, str9, i3, str, str2, str3, cVar.f209593c, null);
        }
    }

    public c(AppInterface appInterface, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, appInterface, str, str2);
            return;
        }
        this.f209595e = null;
        this.f209592b = appInterface;
        this.f209593c = str;
        this.f209594d = str2;
        e();
    }

    @Override // com.tencent.mobileqq.filemanager.core.f
    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else if (this.f209595e != null) {
            ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).deleteObserver(this.f209595e);
        }
    }

    @Override // com.tencent.mobileqq.filemanager.core.f
    public int b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return 4;
    }

    @Override // com.tencent.mobileqq.filemanager.core.f
    public boolean c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        ((IQQFileEngine) this.f209592b.getRuntimeService(IQQFileEngine.class, "")).getWeiYunPreview(this.f209593c, this.f209594d);
        return true;
    }

    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            this.f209595e = new a();
            ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).addObserver(this.f209595e);
        }
    }
}
