package com.tencent.raft.standard.report;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes25.dex */
public class BaseEvent {
    static IPatchRedirector $redirector_;
    private String code;
    private boolean isSuccess;
    private String key;
    private HashMap<String, String> reportParam;
    private int type;

    public BaseEvent(String str, String str2, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, str2, Boolean.valueOf(z16));
            return;
        }
        this.reportParam = new HashMap<>();
        this.key = str;
        this.code = str2;
        this.isSuccess = z16;
    }

    public String getCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.code;
    }

    public String getKey() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.key;
    }

    public Map<String, String> getReportParam() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (Map) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return this.reportParam;
    }

    public int getType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        return this.type;
    }

    public boolean isSuccess() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        return this.isSuccess;
    }

    public void setCode(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
        } else {
            this.code = str;
        }
    }

    public void setKey(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        } else {
            this.key = str;
        }
    }

    public void setReportParam(Map<String, String> map) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) map);
        } else {
            this.reportParam = (HashMap) map;
        }
    }

    public void setSuccess(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, z16);
        } else {
            this.isSuccess = z16;
        }
    }

    public void setType(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, i3);
        } else {
            this.type = i3;
        }
    }

    public BaseEvent(String str, String str2, boolean z16, Map<String, String> map) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, str, str2, Boolean.valueOf(z16), map);
            return;
        }
        this.reportParam = new HashMap<>();
        this.key = str;
        this.code = str2;
        this.isSuccess = z16;
        this.reportParam = (HashMap) map;
    }

    public BaseEvent(String str, String str2, boolean z16, int i3, HashMap<String, String> hashMap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, str, str2, Boolean.valueOf(z16), Integer.valueOf(i3), hashMap);
            return;
        }
        new HashMap();
        this.key = str;
        this.code = str2;
        this.isSuccess = z16;
        this.type = i3;
        this.reportParam = hashMap;
    }
}
