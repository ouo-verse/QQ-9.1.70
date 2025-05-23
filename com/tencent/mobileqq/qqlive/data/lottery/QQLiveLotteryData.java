package com.tencent.mobileqq.qqlive.data.lottery;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes17.dex */
public class QQLiveLotteryData {
    static IPatchRedirector $redirector_ = null;
    public static final int NONE = 0;
    public static final int SLAP_FACE = 1;
    public long countDown;
    public String effectUrl;
    public String iconUrl;
    public Boolean isParticipate;
    public String jumpUrl;
    public String lotteryId;
    public int lotteryType;
    public String popText;
    public String title;

    public QQLiveLotteryData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.lotteryId = "";
        this.title = "";
        this.popText = "";
        this.jumpUrl = "";
        this.iconUrl = "";
        this.effectUrl = "";
    }
}
