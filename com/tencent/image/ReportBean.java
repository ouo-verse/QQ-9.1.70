package com.tencent.image;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes7.dex */
public class ReportBean {
    static IPatchRedirector $redirector_;
    public HashMap<String, String> params;
    public long size;
    public boolean suc;
    public String tag;
    public long time;

    public ReportBean(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
            return;
        }
        this.suc = true;
        this.params = new HashMap<>();
        this.tag = str;
    }
}
