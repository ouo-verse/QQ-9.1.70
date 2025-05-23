package com.tencent.mobileqq.qqgamepub.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes16.dex */
public class QQGameMsgInfo implements Serializable {
    static IPatchRedirector $redirector_ = null;
    public static final int MSG_TYPE_ARK = 1;
    public static final int MSG_TYPE_IMGHEADER = 2;
    public static final int MSG_TYPE_TEXTHEADER = 3;
    public static final int REPORT_TYPE_CLICK = 2;
    public static final int REPORT_TYPE_RECEIVE = 1;
    public String actionUrl;
    public String adJson;
    public String advId;
    public String arkAppConfig;
    public String arkAppMinVersion;
    public String arkAppName;
    public String arkAppView;
    public int arkHeight;
    public String arkMetaList;
    public int arkWidth;
    public String contentText;
    public String coverUrl;
    public String dateTitle;
    public String desc;
    public String directJumpConfigs;
    public String extJson;
    public String fid;
    public String frienduin;
    public String gameAppId;
    public String icon;
    public boolean isAdMsg;
    public int istroop;
    public String limitText;
    public String loadArkResPath;
    public long msgId;
    public long msgTime;
    public int msgType;
    public String paMsgid;
    public int retId;
    public String sortedConfigs;
    public String taskId;
    public int tianshuFootageid;
    public String title;
    public String triggerInfo;
    public long uniseq;
    public String url;

    public QQGameMsgInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.paMsgid = "";
        this.gameAppId = "";
        this.taskId = "";
        this.extJson = "";
        this.sortedConfigs = "";
        this.arkAppName = "";
        this.arkAppView = "";
        this.arkAppMinVersion = "";
        this.arkMetaList = "";
        this.arkAppConfig = "";
        this.url = "";
        this.coverUrl = "";
        this.title = "";
        this.dateTitle = "";
        this.contentText = "";
        this.limitText = "";
        this.actionUrl = "";
        this.frienduin = "";
        this.advId = "";
        this.triggerInfo = "";
        this.fid = "";
        this.desc = "";
        this.icon = "";
        this.isAdMsg = false;
        this.adJson = null;
        this.directJumpConfigs = "";
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "QQGameMsgInfo{msgType=" + this.msgType + ", msgTime=" + this.msgTime + ", istroop=" + this.istroop + ", paMsgid='" + this.paMsgid + "', gameAppId='" + this.gameAppId + "', taskId='" + this.taskId + "', extJson='" + this.extJson + "', sortedConfigs='" + this.sortedConfigs + "', arkAppName='" + this.arkAppName + "', arkAppView='" + this.arkAppView + "', arkAppMinVersion='" + this.arkAppMinVersion + "', arkMetaList='" + this.arkMetaList + "', arkAppConfig='" + this.arkAppConfig + "', arkWidth=" + this.arkWidth + ", arkHeight=" + this.arkHeight + ", url='" + this.url + "', coverUrl='" + this.coverUrl + "', title='" + this.title + "', dateTitle='" + this.dateTitle + "', contentText='" + this.contentText + "', limitText='" + this.limitText + "', actionUrl='" + this.actionUrl + "', frienduin='" + this.frienduin + "', uniseq=" + this.uniseq + ", advId='" + this.advId + "', triggerInfo='" + this.triggerInfo + "', desc='" + this.desc + "', icon='" + this.icon + "', isAdMsg=" + this.isAdMsg + ", adJson='" + this.adJson + "', loadArkResPath='" + this.loadArkResPath + "', directJumpConfigs='" + this.directJumpConfigs + "', msgId=" + this.msgId + ", retId=" + this.retId + '}';
    }
}
