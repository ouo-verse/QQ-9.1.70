package com.tencent.mobileqq.richstatus;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes18.dex */
public class TipsInfo implements Serializable {
    static IPatchRedirector $redirector_ = null;
    public static final int TYPE_JUMP_URL = 2;
    public static final int TYPE_JUMP_URL_WITHOUT_TIPS = 3;
    public static final int TYPE_PAYMENT = 1;
    public int authAppid;
    public String errorDesc;
    public String leftBtnWording;
    public int ret;
    public String rightBtnWording;
    public String titleWording;
    public int type;
    public String url;
    public boolean valid;
    public int vipMonth;
    public String vipType;
    public String wording;

    public TipsInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.valid = false;
            this.type = -1;
        }
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "TipsInfo{valid=" + this.valid + ", ret=" + this.ret + ", type=" + this.type + ", titleWording='" + this.titleWording + "', wording='" + this.wording + "', rightBtnWording='" + this.rightBtnWording + "', leftBtnWording='" + this.leftBtnWording + "', vipType='" + this.vipType + "', vipMonth=" + this.vipMonth + ", url='" + this.url + "'}";
    }
}
