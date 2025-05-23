package com.tencent.mobileqq.ecshop.conf;

import androidx.annotation.Keep;
import com.tencent.freesia.IConfigData;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* compiled from: P */
@Keep
/* loaded from: classes5.dex */
public class EcshopConfBean implements IConfigData {
    static IPatchRedirector $redirector_;
    public int adClickAreaSwitch;
    public boolean forbidPreloadMsg;
    public boolean forbidTransFirstPageData;
    public int jumpType;
    public MsgTabPageConfig msgTabPageConfig;
    public List<ForbidJumpThirdAppRule> rules;
    public ShakeAdEffectBean shakeAdEffectBean;

    /* compiled from: P */
    @Keep
    /* loaded from: classes5.dex */
    public static class ForbidJumpThirdAppRule {
        static IPatchRedirector $redirector_;
        public String keyPath;
        public String value;

        public ForbidJumpThirdAppRule(String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, (Object) str2);
            } else {
                this.keyPath = str;
                this.value = str2;
            }
        }
    }

    /* compiled from: P */
    @Keep
    /* loaded from: classes5.dex */
    public static class MsgTabPageConfig {
        static IPatchRedirector $redirector_;
        public String benefitsCenterTabExperimentName;
        public String coinsMsgTabTitle;
        public String dailyMsgTabTitle;
        public int maxDailyMsgCount;
        public int maxPAMsgCount;
        public String paMsgTabTitle;
        public boolean shouldDisableLastUnreadDailyMsg;
        public boolean shouldEnableBenefitsCenterTab;
        public boolean shouldPreloadDailyMsgPage;

        public MsgTabPageConfig() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    @Keep
    /* loaded from: classes5.dex */
    public static class ShakeAdEffectBean {
        static IPatchRedirector $redirector_;
        public Date beginTime;
        public String bigShakeUrl;
        public Date endTime;
        public float shakeAcceleration;
        public float shakeAxisX;
        public float shakeAxisY;
        public float shakeAxisZ;
        public int shakeMinCount;
        public double shakeStayTime;
        public String smallShakeUrl;

        public ShakeAdEffectBean() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public boolean isValid() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
            }
            if (this.beginTime == null || this.endTime == null) {
                return false;
            }
            Date date = new Date();
            if (date.compareTo(this.beginTime) < 0 || date.compareTo(this.endTime) > 0) {
                return false;
            }
            return true;
        }
    }

    public EcshopConfBean() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.jumpType = 1;
        this.forbidPreloadMsg = false;
        this.forbidTransFirstPageData = false;
        this.adClickAreaSwitch = 0;
        this.shakeAdEffectBean = new ShakeAdEffectBean();
        this.msgTabPageConfig = new MsgTabPageConfig();
        this.rules = new ArrayList();
    }
}
