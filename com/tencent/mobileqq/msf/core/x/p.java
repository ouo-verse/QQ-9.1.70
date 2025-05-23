package com.tencent.mobileqq.msf.core.x;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.io.InputStream;
import java.util.Map;
import javax.xml.parsers.SAXParserFactory;

/* compiled from: P */
/* loaded from: classes15.dex */
public class p {
    static IPatchRedirector $redirector_;

    public p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void a(InputStream inputStream, Map<String, String> map, String str) {
        try {
            SAXParserFactory.newInstance().newSAXParser().parse(inputStream, new s(str, map));
            inputStream.close();
        } catch (Exception e16) {
            QLog.d("MSF.C.ConfigManager", 1, " " + e16, e16);
        }
    }
}
