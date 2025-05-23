package com.tencent.mobileqq.soload.biz.entity;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes18.dex */
public class SoLoadInfo implements Serializable {
    static IPatchRedirector $redirector_;
    public static SoLoadInfo sDefault;
    public int curCode;
    public String failDetail;
    public boolean isFinishDownload;
    public boolean isFirstlyLoad;
    public boolean isNeedDownload;
    public String rFileFolder;
    public SoDetailInfo soDetailInfo;
    public String soPathToLoad;
    public int subErrCode;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(33764);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            sDefault = new SoLoadInfo();
        }
    }

    public SoLoadInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.curCode = 6;
        this.isFirstlyLoad = true;
        this.isNeedDownload = true;
    }

    public String getVer() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        SoDetailInfo soDetailInfo = this.soDetailInfo;
        if (soDetailInfo == null) {
            return null;
        }
        return soDetailInfo.ver;
    }
}
