package com.tencent.mobileqq.msf.core.e0;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/* compiled from: P */
/* loaded from: classes15.dex */
public class k {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: a, reason: collision with root package name */
    public static final String f248017a = "MSF.C.TestEnvManager";

    /* renamed from: b, reason: collision with root package name */
    private static String f248018b = "";

    /* renamed from: c, reason: collision with root package name */
    private static String f248019c = "";

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private static final k f248020a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(17719);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f248020a = new k();
            }
        }

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(28168);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        }
    }

    public k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static k c() {
        return a.f248020a;
    }

    private void e() {
        if (MsfSdkUtils.isBuildTestEnvValid()) {
            com.tencent.mobileqq.msf.core.d a16 = com.tencent.mobileqq.msf.core.d.a(BaseConstants.testServerAddress);
            if (a16.b() != null && a16.d() > 0) {
                a(BaseConstants.testServerAddress);
                QLog.d(f248017a, 1, "set buildTestServer Address socket://113.96.213.95:14000");
            } else {
                QLog.i(f248017a, 1, "testServerAddress ip or port error");
            }
        }
    }

    public void a(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        } else if (str != null) {
            f248018b = str;
            BaseConstants.isUseDebugSso = true;
        }
    }

    public String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) ? f248019c : (String) iPatchRedirector.redirect((short) 6, (Object) this);
    }

    public boolean d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        if (BaseApplication.getContext().getMSFInterfaceAdapter().isPublicVersion()) {
            return false;
        }
        return !TextUtils.isEmpty(f248018b);
    }

    private void b(Context context) {
        String property;
        String str = (BaseApplication.getContext().getFilesDir().getAbsolutePath() + "/testEnv") + "/testserver";
        File file = new File(str);
        if (!file.canRead()) {
            file = new File(str);
        }
        if (QLog.isColorLevel()) {
            QLog.i(f248017a, 2, "testserver path=" + file.getAbsolutePath() + " isFile=" + file.isFile() + " canRead=" + file.canRead() + " length=" + file.length());
        }
        Properties properties = new Properties();
        FileInputStream fileInputStream = null;
        try {
        } catch (IOException e16) {
            e16.printStackTrace();
        }
        try {
            try {
                if (file.exists()) {
                    FileInputStream fileInputStream2 = new FileInputStream(file);
                    try {
                        properties.load(fileInputStream2);
                        fileInputStream2.close();
                        fileInputStream = fileInputStream2;
                    } catch (Exception e17) {
                        e = e17;
                        fileInputStream = fileInputStream2;
                        e.printStackTrace();
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        property = properties.getProperty("server");
                        if (property == null) {
                        }
                        e();
                    } catch (Throwable th5) {
                        th = th5;
                        fileInputStream = fileInputStream2;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e18) {
                                e18.printStackTrace();
                            }
                        }
                        throw th;
                    }
                }
            } catch (Exception e19) {
                e = e19;
            }
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            property = properties.getProperty("server");
            if (property == null && property.trim().length() > 0) {
                com.tencent.mobileqq.msf.core.d a16 = com.tencent.mobileqq.msf.core.d.a(property);
                if (a16.b() == null || a16.d() <= 0) {
                    return;
                }
                a(property.trim().replace(" ", ""));
                QLog.d(f248017a, 1, "set TestServer Address " + f248018b);
                String property2 = properties.getProperty("id");
                if (property2 == null || property2.trim().length() <= 0) {
                    return;
                }
                f248019c = property2;
                return;
            }
            e();
        } catch (Throwable th6) {
            th = th6;
        }
    }

    public String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) ? f248018b : (String) iPatchRedirector.redirect((short) 5, (Object) this);
    }

    public void a(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) context);
            return;
        }
        if (!BaseApplication.getContext().getMSFInterfaceAdapter().isPublicVersion()) {
            try {
                b(context);
                return;
            } catch (Exception e16) {
                QLog.d(f248017a, 1, "loadTestServerConfig error " + e16);
                return;
            }
        }
        try {
            e();
        } catch (Exception e17) {
            QLog.d(f248017a, 1, "loadTestServerConfig error " + e17);
        }
    }
}
