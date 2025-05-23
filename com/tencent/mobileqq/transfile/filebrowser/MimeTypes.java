package com.tencent.mobileqq.transfile.filebrowser;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes19.dex */
public class MimeTypes {
    static IPatchRedirector $redirector_;
    private Map<String, String> mMimeTypes;

    public MimeTypes() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mMimeTypes = new HashMap();
        }
    }

    public static String getExtension(String str) {
        if (str == null) {
            return null;
        }
        int lastIndexOf = str.lastIndexOf(".");
        if (lastIndexOf >= 0) {
            return str.substring(lastIndexOf);
        }
        return "";
    }

    public String getMimeType(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        }
        return this.mMimeTypes.get(getExtension(str));
    }

    public void put(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) str2);
        } else {
            this.mMimeTypes.put(str, str2);
        }
    }
}
