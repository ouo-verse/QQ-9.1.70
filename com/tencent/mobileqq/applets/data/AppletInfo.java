package com.tencent.mobileqq.applets.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes11.dex */
public class AppletInfo implements Serializable, Cloneable {
    static IPatchRedirector $redirector_ = null;
    private static final long serialVersionUID = 1;
    public String appKey;
    public String appName;
    public int appState;
    public int appType;
    public int appid;
    public String icon_url;
    public String iphoneUrlScheme;
    public String middleUrl;
    public String packName;
    public int platform;
    public String smallUrl;
    public String sourceUrl;

    public AppletInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "--AppletsAccountInfo--,appid:" + this.appid + ",appType:" + this.appType + ",platform:" + this.platform + ",appName:" + this.appName + ",appKey:" + this.appKey + ",appState:" + this.appState + ",iphoneUrlScheme:" + this.iphoneUrlScheme + ",packName:" + this.packName + ",icon_url:" + this.icon_url + ",sourceUrl:" + this.sourceUrl + ",smallUrl:" + this.smallUrl + ",middleUrl:" + this.middleUrl;
    }
}
