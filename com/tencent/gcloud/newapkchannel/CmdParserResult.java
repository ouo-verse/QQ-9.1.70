package com.tencent.gcloud.newapkchannel;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes6.dex */
public class CmdParserResult {
    static IPatchRedirector $redirector_;
    private String apkChannelId;
    private Integer code;
    private String minSignatureMd5;

    /* renamed from: msg, reason: collision with root package name */
    private String f108392msg;
    private String v1SignatureMd5;
    private String v1SignatureMolo;
    private String v2SignatureMd5;
    private String v3SignatureMd5;

    public CmdParserResult() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.code = 0;
            this.f108392msg = "";
        }
    }

    public String getApkChannelId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (String) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return this.apkChannelId;
    }

    public Integer getCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Integer) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.code;
    }

    public String getMinSignatureMd5() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (String) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        return this.minSignatureMd5;
    }

    public String getMsg() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.f108392msg;
    }

    public String getV1SignatureMd5() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.v1SignatureMd5;
    }

    public String getV1SignatureMolo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.v1SignatureMolo;
    }

    public String getV2SignatureMd5() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.v2SignatureMd5;
    }

    public String getV3SignatureMd5() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return this.v3SignatureMd5;
    }

    public void setApkChannelId(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) str);
        } else {
            this.apkChannelId = str;
        }
    }

    public void setCode(Integer num) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) num);
        } else {
            this.code = num;
        }
    }

    public void setMinSignatureMd5(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) str);
        } else {
            this.minSignatureMd5 = str;
        }
    }

    public void setMsg(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        } else {
            this.f108392msg = str;
        }
    }

    public void setV1SignatureMd5(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
        } else {
            this.v1SignatureMd5 = str;
        }
    }

    public void setV1SignatureMolo(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) str);
        } else {
            this.v1SignatureMolo = str;
        }
    }

    public void setV2SignatureMd5(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) str);
        } else {
            this.v2SignatureMd5 = str;
        }
    }

    public void setV3SignatureMd5(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) str);
        } else {
            this.v3SignatureMd5 = str;
        }
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (String) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        return "CmdParserResult{code=" + this.code + ", msg='" + this.f108392msg + "', v1SignatureMd5='" + this.v1SignatureMd5 + "', v1SignatureMolo='" + this.v1SignatureMolo + "', v2SignatureMd5='" + this.v2SignatureMd5 + "', v3SignatureMd5='" + this.v3SignatureMd5 + "', apkChannelId='" + this.apkChannelId + "', minSignatureMd5='" + this.minSignatureMd5 + "'}";
    }
}
