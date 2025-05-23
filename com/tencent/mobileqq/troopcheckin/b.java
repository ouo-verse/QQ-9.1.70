package com.tencent.mobileqq.troopcheckin;

import android.os.Bundle;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;

/* compiled from: P */
/* loaded from: classes19.dex */
public class b extends QIPCModule {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name */
    public static b f302711e;

    /* renamed from: d, reason: collision with root package name */
    private d f302712d;

    b() {
        super("Module_CheckInServer");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void b() {
        d dVar = this.f302712d;
        if (dVar != null) {
            dVar.c();
            this.f302712d = null;
        }
    }

    public static b c() {
        if (f302711e == null) {
            synchronized (b.class) {
                if (f302711e == null) {
                    f302711e = new b();
                }
            }
        }
        return f302711e;
    }

    public void d(boolean z16, int i3, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), Integer.valueOf(i3), bundle);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Module_CheckInServer", 2, "notifyUploadResult callbackId" + i3 + ", data = " + bundle.toString());
        }
        EIPCResult createResult = EIPCResult.createResult(0, bundle);
        b();
        callbackResult(i3, createResult);
    }

    @Override // com.tencent.mobileqq.qipc.QIPCModule
    public void onAccountChange() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            super.onAccountChange();
            b();
        }
    }

    @Override // eipc.EIPCModule
    public EIPCResult onCall(String str, Bundle bundle, int i3) {
        d eVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (EIPCResult) iPatchRedirector.redirect((short) 2, this, str, bundle, Integer.valueOf(i3));
        }
        if (QLog.isColorLevel()) {
            QLog.d("Module_CheckInServer", 2, "action = " + str + ", params = " + bundle + ",callbackId=" + i3);
        }
        b();
        if (!"ACTION_UPLOAD_PIC".equals(str) && !"ACTION_UPLOAD_VIDEO".equals(str)) {
            if ("ACTION_CANCEL".equals(str)) {
                b();
                return null;
            }
            return null;
        }
        a aVar = new a();
        if ("ACTION_UPLOAD_PIC".equals(str)) {
            aVar.f302708a = bundle.getString("BUNDLE_NAME_FILEPATH");
            eVar = new c(aVar, i3);
        } else {
            aVar.f302708a = bundle.getString("BUNDLE_NAME_FILEPATH");
            aVar.f302709b = bundle.getString("BUNDLE_NAME_COVER");
            aVar.f302710c = bundle.getLong("BUNDLE_NAME_VIDEOTIME");
            eVar = new e(aVar, i3);
        }
        this.f302712d = eVar;
        eVar.a();
        return null;
    }
}
