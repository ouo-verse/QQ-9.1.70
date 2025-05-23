package com.tencent.mobileqq.microapp.sdk;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.io.Serializable;

/* loaded from: classes15.dex */
public class LaunchParam implements Serializable {
    static IPatchRedirector $redirector_ = null;
    public static final String MINI_APPID_COLLECTION_PAGE = "101495732";
    public static final int SCENE_ABOUT = 1216;
    public static final int SCENE_H5_LIST = 1201;
    public static final int SCENE_HOME_PLUS = 1202;
    public static final int SCENE_HOME_SEARCH = 1206;
    public static final int SCENE_NAVIGATE_BACK = 1215;
    public static final int SCENE_NAVIGATE_TO = 1214;
    public static final int SCENE_NOT_DEFINE = 1200;
    public static final int SCENE_PUBLIC_ACCOUNT_CUSTOM_MENU = 1209;
    public static final int SCENE_PUBLIC_ACCOUNT_TEMPLATE_MSG = 1210;
    public static final int SCENE_PUBLIC_GROUP_MSG = 1211;
    public static final int SCENE_SCAN_QQ = 1207;
    public static final int SCENE_SCAN_WX = 1208;
    public static final int SCENE_SHARE_C2C = 1212;
    public static final int SCENE_SHARE_GROUP = 1213;
    public static final int SCENE_WALLET_APPS = 1203;
    public static final int SCENE_WALLET_BANNER = 1204;
    public static final int SCENE_WALLET_CHOICENESS = 1205;
    public static final int STATE_LOADING = 1;
    public static final int STATE_NONE = 0;
    public String appInfo;
    public String entryPath;
    public String extraKey;
    public String fromMiniAppId;
    public String miniAppId;
    public String navigateExtData;
    public int scene;
    public int tempState;

    public LaunchParam() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.scene = 1200;
            this.tempState = 0;
        }
    }

    public static boolean isCollectionPage(String str) {
        return "101495732".equals(str);
    }

    private static String standardEntryPath(String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        int indexOf = str.indexOf(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER);
        String str3 = "";
        if (indexOf == -1) {
            str2 = "";
        } else {
            String substring = str.substring(0, indexOf);
            str2 = str.substring(indexOf + 1, str.length());
            str = substring;
        }
        if (!str.toLowerCase().endsWith(".html")) {
            str = str + ".html";
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append(str);
        if (!TextUtils.isEmpty(str2)) {
            str3 = QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER + str2;
        }
        sb5.append(str3);
        return sb5.toString();
    }

    public int getReqAction() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        int i3 = this.scene;
        if (i3 == 1207) {
            return 1;
        }
        if (i3 == 1208) {
            return 2;
        }
        return 0;
    }

    public String getScheme() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        String str = "mqqapi://microapp/open?mini_appid=" + this.miniAppId;
        if (!TextUtils.isEmpty(this.entryPath)) {
            str = str + "&entryPath=" + this.entryPath;
        }
        if (!TextUtils.isEmpty(this.navigateExtData)) {
            return str + "&extraData=" + this.navigateExtData;
        }
        return str;
    }

    public boolean isValid() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        int i3 = this.scene;
        if (i3 != 1207 && i3 != 1208) {
            if (i3 != 1214) {
                if (TextUtils.isEmpty(this.miniAppId)) {
                    return false;
                }
                return true;
            }
            if (TextUtils.isEmpty(this.miniAppId) || TextUtils.isEmpty(this.fromMiniAppId)) {
                return false;
            }
            return true;
        }
        if (TextUtils.isEmpty(this.extraKey)) {
            return false;
        }
        return true;
    }

    public void standardize() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            this.entryPath = standardEntryPath(this.entryPath);
        }
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return "LaunchParam{scene=" + this.scene + ", miniAppId='" + this.miniAppId + "', extraKey='" + this.extraKey + "', entryPath='" + this.entryPath + "', navigateExtData='" + this.navigateExtData + "', fromMiniAppId='" + this.fromMiniAppId + "'}";
    }
}
