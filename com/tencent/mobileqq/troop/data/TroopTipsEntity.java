package com.tencent.mobileqq.troop.data;

import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.uniqueConstraints;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
@uniqueConstraints(clause = ConflictClause.REPLACE, columnNames = "msgSeq")
/* loaded from: classes19.dex */
public class TroopTipsEntity extends Entity {
    static IPatchRedirector $redirector_ = null;
    public static final int SHOW_IN_AIO_BOTTOM = 1;
    public String OptActionData_a;
    public String OptActionData_i;
    public int actiontType;
    public String currentUin;
    public long expireTime;
    public String extra;
    public int grayTipsRemindFlag;
    public String grayTipsSummary;
    public String highlightItems;
    public int highlightNum;
    public boolean isOfflineMsg;
    public boolean isSupportImage;
    public long msgSeq;
    public String optActionData;
    public String optButton;
    public String optContent;
    public int optIcon;
    public long optMsgTime;
    public int optShowLatest;
    public String optTitle;
    public String optUrl;
    public String optUrlP;
    public boolean read;
    public int repeatInterval;
    public String senderUin;
    public int serviceType;
    public long time;
    public int tipsPromptType;
    public String troopUin;
    public int uinType;

    public TroopTipsEntity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.isSupportImage = true;
        this.read = false;
        this.isOfflineMsg = false;
        this.grayTipsRemindFlag = 0;
        this.grayTipsSummary = "";
        this.uinType = 1;
        this.repeatInterval = 0;
    }

    public boolean need2InsertIntoMsgListRightNow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        if (!this.isOfflineMsg && this.optShowLatest != 1) {
            return true;
        }
        return false;
    }
}
