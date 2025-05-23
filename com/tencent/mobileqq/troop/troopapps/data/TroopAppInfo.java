package com.tencent.mobileqq.troop.troopapps.data;

import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.uniqueConstraints;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
@uniqueConstraints(clause = ConflictClause.REPLACE, columnNames = "appId")
/* loaded from: classes19.dex */
public class TroopAppInfo extends Entity {
    static IPatchRedirector $redirector_;
    public String AppTipIcon;
    public int AppTipIconTimeStamp;
    public int AppTipInfoSeq;
    public int AppTipReportIdClick;
    public int AppTipReportIdShow;
    public String AppTipToolTip;
    public String androidDownloadUrl;
    public String androidOpen;
    public int appFrom;
    public String appIcon;
    public int appIconUpdateTime;
    public long appId;
    public int appInnerType;
    public String appIntro;
    public int appIsNew;
    public String appName;
    public int appNewTime;
    public int appSortKey;
    public int appStatus;
    public int appType;
    public int appUpdateTime;
    public String appUrl;
    public int appWindowHeight;
    public int appWindowWidth;
    public int initFlag;
    public String openParam;
    public int settingFlag;
    public String tags;
    public String versionAndroid;

    public TroopAppInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
