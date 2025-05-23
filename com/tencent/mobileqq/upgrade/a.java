package com.tencent.mobileqq.upgrade;

import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes20.dex */
public class a implements com.tencent.open.downloadnew.b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private InterfaceC8882a f306223a;

    /* renamed from: b, reason: collision with root package name */
    private String f306224b;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.upgrade.a$a, reason: collision with other inner class name */
    /* loaded from: classes20.dex */
    public interface InterfaceC8882a {
        boolean a(int i3);

        void b(int i3);
    }

    public a(String str, InterfaceC8882a interfaceC8882a) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, (Object) interfaceC8882a);
        } else {
            this.f306224b = str;
            this.f306223a = interfaceC8882a;
        }
    }

    @Override // com.tencent.open.downloadnew.b
    public void a(String str, int i3, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, str, Integer.valueOf(i3), bundle);
            return;
        }
        if (BaseApplicationImpl.sApplication.getPackageName().equals(str)) {
            if (QLog.isDevelopLevel()) {
                QLog.d("UpgradeController", 4, "syncVersionCodeToTool:" + str + ", versionCode:" + i3);
            }
            InterfaceC8882a interfaceC8882a = this.f306223a;
            if (interfaceC8882a != null && !interfaceC8882a.a(i3)) {
                this.f306224b = null;
            }
        }
    }

    @Override // com.tencent.open.downloadnew.b
    public int b(String str, int i3, String str2, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        int i16 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, this, str, Integer.valueOf(i3), str2, bundle)).intValue();
        }
        if (!str.equals(BaseApplicationImpl.sApplication.getPackageName())) {
            return -1;
        }
        String str3 = this.f306224b;
        Exception exc = null;
        if (str3 == null) {
            i16 = -1;
        } else if (str3.length() != 0) {
            int i17 = -20;
            try {
                File file = new File(str2);
                File file2 = new File(str2 + "~tmp");
                if (file2.exists()) {
                    file2.delete();
                }
                file.renameTo(file2);
                com.tencent.securitysdk.utils.a.j(file2, this.f306224b);
                file2.renameTo(file);
            } catch (FileNotFoundException e16) {
                exc = e16;
                i16 = -30;
            } catch (IOException e17) {
                exc = e17;
                if (exc.getMessage() != null && exc.getMessage().contains("space")) {
                    i17 = -10;
                }
                i16 = i17;
            } catch (Exception e18) {
                exc = e18;
                i16 = i17;
            }
        }
        InterfaceC8882a interfaceC8882a = this.f306223a;
        if (interfaceC8882a != null) {
            interfaceC8882a.b(i16);
        }
        QLog.d("UpgradeController", 1, "writeCodeToApk:" + this.f306224b + ", forFile:" + str2 + " result: " + i16, exc);
        return i16;
    }
}
