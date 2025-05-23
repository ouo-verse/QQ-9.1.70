package com.tencent.nt.qav.reporter;

import com.tencent.avcore.util.AVCoreLog;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes22.dex */
public class QavReporter {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "QavReporter";
    private static volatile QavReporter sInstance;
    private a mQavReport;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public interface a {
        void a(String str, String str2, HashMap<String, String> hashMap);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(17201);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            sInstance = null;
        }
    }

    QavReporter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            init();
        }
    }

    public static QavReporter getInstance() {
        if (sInstance == null) {
            synchronized (QavReporter.class) {
                if (sInstance == null) {
                    sInstance = new QavReporter();
                }
            }
        }
        return sInstance;
    }

    private native void init();

    public void report(String str, String str2, HashMap<String, String> hashMap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, str, str2, hashMap);
            return;
        }
        a aVar = this.mQavReport;
        if (aVar != null) {
            aVar.a(str, str2, hashMap);
        } else {
            AVCoreLog.printErrorLog(TAG, "mQavReport is null");
        }
    }

    public void setReport(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
        } else {
            this.mQavReport = aVar;
        }
    }

    private void report(String str, String str2, String str3) {
        HashMap<String, String> hashMap = new HashMap<>();
        String[] split = str3.split("\\|");
        for (int i3 = 0; i3 < split.length - 1; i3 += 2) {
            hashMap.put(split[i3], split[i3 + 1]);
        }
        report(str, str2, hashMap);
    }
}
