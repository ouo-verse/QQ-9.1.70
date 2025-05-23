package com.tencent.mobileqq.mini.api.data;

import NS_MINI_INTERFACE.INTERFACE$StApiAppInfo;
import NS_MINI_INTERFACE.INTERFACE$StRegistrationInfo;
import android.text.TextUtils;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;

/* compiled from: P */
/* loaded from: classes15.dex */
public class SimpleMiniAppConfig {
    public static final int TYPE_MINI_APP = 0;
    public static final int TYPE_MINI_GAME = 1;
    public SimpleMiniAppInfo config;
    public SimpleLaunchParam launchParam = new SimpleLaunchParam();

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class SimpleLaunchParam {
        public String entryPath;
        public String miniAppId;
        public String reportData;
        public int scene = 9999;

        public static String standardEntryPath(String str) {
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
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class SimpleMiniAppInfo {
        public String appId;
        public String developerDesc;
        public int engineType;
        public String gameRegistrationNumber;
        public String hostScene;
        public String iconUrl;
        public String name;
        public int reportType;
        public INTERFACE$StApiAppInfo stApiAppInfo;
        public int verType;
        public String via;

        public static SimpleMiniAppInfo from(INTERFACE$StApiAppInfo iNTERFACE$StApiAppInfo) {
            if (iNTERFACE$StApiAppInfo == null) {
                return null;
            }
            SimpleMiniAppInfo simpleMiniAppInfo = new SimpleMiniAppInfo();
            simpleMiniAppInfo.stApiAppInfo = iNTERFACE$StApiAppInfo;
            simpleMiniAppInfo.appId = iNTERFACE$StApiAppInfo.appId.get();
            simpleMiniAppInfo.name = iNTERFACE$StApiAppInfo.appName.get();
            simpleMiniAppInfo.iconUrl = iNTERFACE$StApiAppInfo.icon.get();
            simpleMiniAppInfo.developerDesc = iNTERFACE$StApiAppInfo.desc.get();
            INTERFACE$StRegistrationInfo iNTERFACE$StRegistrationInfo = iNTERFACE$StApiAppInfo.registrationInfo;
            if (iNTERFACE$StRegistrationInfo != null) {
                simpleMiniAppInfo.gameRegistrationNumber = iNTERFACE$StRegistrationInfo.registrationNumber.get();
            }
            return simpleMiniAppInfo;
        }

        public boolean isEngineTypeMiniApp() {
            if (this.engineType == 0) {
                return true;
            }
            return false;
        }

        public boolean isEngineTypeMiniGame() {
            if (this.engineType == 1) {
                return true;
            }
            return false;
        }

        public void setEngineType(int i3) {
            this.engineType = i3;
        }

        public void setReportType(int i3) {
            this.reportType = i3;
        }
    }

    public SimpleMiniAppConfig(SimpleMiniAppInfo simpleMiniAppInfo) {
        this.config = simpleMiniAppInfo;
    }
}
