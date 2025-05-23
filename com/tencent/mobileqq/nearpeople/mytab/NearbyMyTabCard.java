package com.tencent.mobileqq.nearpeople.mytab;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes15.dex */
public class NearbyMyTabCard implements Serializable {
    static IPatchRedirector $redirector_;
    public int age;
    public int carrier;
    public int charmLevel;
    public int charmValue;
    public List<NearbyMyTabConfig> configList;
    public int currentCharm;
    public int gender;
    public int giftNum;
    public int godFlag;
    public int likeTotalNum;
    public int newLikeNum;
    public int nextCharm;
    public String nickName;
    public Long uin;
    public List<Object> visitors;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class NearbyMyTabConfig implements Serializable {
        static IPatchRedirector $redirector_;
        public int configId;
        public NearbyMyTabConfigExtraVal extraVal;
        public String iconUrl;
        public transient RedTouch redTouch;
        public String strName;
        public String strUrl;
        public String tips;

        public NearbyMyTabConfig() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class NearbyMyTabConfigExtraVal implements Serializable {
        static IPatchRedirector $redirector_;
        public String actionName;
        public String path;
        public int pathId;

        public NearbyMyTabConfigExtraVal() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    public NearbyMyTabCard() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.nickName = "";
        this.configList = new ArrayList();
        this.visitors = new ArrayList();
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        StringBuilder sb5 = new StringBuilder(120);
        sb5.append("[");
        sb5.append("uin = ");
        sb5.append(this.uin);
        sb5.append(", nickName = ");
        sb5.append(this.nickName);
        sb5.append(", newLikeNum = ");
        sb5.append(this.newLikeNum);
        sb5.append(", charmValue = ");
        sb5.append(this.charmValue);
        sb5.append(", charmLevel = ");
        sb5.append(this.charmLevel);
        sb5.append(", currentCharm = ");
        sb5.append(this.currentCharm);
        sb5.append(", nextCharm = ");
        sb5.append(this.nextCharm);
        sb5.append(", giftNum = ");
        sb5.append(this.giftNum);
        sb5.append("]");
        return sb5.toString();
    }
}
