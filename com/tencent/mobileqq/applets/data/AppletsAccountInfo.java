package com.tencent.mobileqq.applets.data;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.StringUtil;
import tencent.im.oidb.qqconnect$Appinfo;

/* compiled from: P */
/* loaded from: classes11.dex */
public class AppletsAccountInfo extends Entity {
    static IPatchRedirector $redirector_ = null;
    private static final String TABLENAME = "applets_account_info";

    @notColumn
    public AppletInfo appInfo;
    public byte[] appInfoDetail;
    public String faceUrl;
    public String faceUrlSimple;
    public String nick;

    @unique
    public String uin;

    public AppletsAccountInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public AppletInfo convertToAppletInfo(qqconnect$Appinfo qqconnect_appinfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (AppletInfo) iPatchRedirector.redirect((short) 3, (Object) this, (Object) qqconnect_appinfo);
        }
        AppletInfo appletInfo = new AppletInfo();
        if (qqconnect_appinfo != null) {
            if (qqconnect_appinfo.appid.has()) {
                appletInfo.appid = qqconnect_appinfo.appid.get();
            }
            if (qqconnect_appinfo.app_type.has()) {
                appletInfo.appType = qqconnect_appinfo.app_type.get();
            }
            if (qqconnect_appinfo.platform.has()) {
                appletInfo.platform = qqconnect_appinfo.platform.get();
            }
            if (qqconnect_appinfo.app_name.has()) {
                appletInfo.appName = qqconnect_appinfo.app_name.get();
            }
            if (qqconnect_appinfo.app_state.has()) {
                appletInfo.appState = qqconnect_appinfo.app_state.get();
            }
            if (qqconnect_appinfo.iphone_url_scheme.has()) {
                appletInfo.iphoneUrlScheme = qqconnect_appinfo.iphone_url_scheme.get();
            }
            if (qqconnect_appinfo.android_pack_name.has()) {
                appletInfo.packName = qqconnect_appinfo.android_pack_name.get();
            }
            if (qqconnect_appinfo.icon_url.has()) {
                appletInfo.icon_url = qqconnect_appinfo.icon_url.get();
            }
            if (qqconnect_appinfo.source_url.has()) {
                appletInfo.sourceUrl = qqconnect_appinfo.source_url.get();
            }
            if (qqconnect_appinfo.icon_small_url.has()) {
                appletInfo.smallUrl = qqconnect_appinfo.icon_small_url.get();
            }
            if (qqconnect_appinfo.icon_middle_url.has()) {
                appletInfo.middleUrl = qqconnect_appinfo.icon_middle_url.get();
            }
        }
        return appletInfo;
    }

    @Override // com.tencent.mobileqq.persistence.Entity
    public String getTableName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return TABLENAME;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "--AppletsAccountInfo--,shortUin:" + StringUtil.getSimpleUinForPrint(String.valueOf(this.uin)) + ",nick:" + this.nick + ",face_url:" + this.faceUrl + ",face_url_simple:" + this.faceUrlSimple + ",appInfo:" + this.appInfo;
    }
}
