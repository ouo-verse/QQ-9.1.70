package com.tencent.qqmini.sdk.launcher.model;

import android.text.TextUtils;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.io.File;

/* compiled from: P */
/* loaded from: classes23.dex */
public abstract class ApkgBaseInfo {
    public String apkgFolderPath;
    public String apkgName;
    public String appId;
    public String iconUrl;
    public String mConfigStr;

    public ApkgBaseInfo() {
    }

    public static boolean equalObj(Object obj, Object obj2) {
        if (obj == null) {
            if (obj2 == null) {
                return true;
            }
            return false;
        }
        return obj.equals(obj2);
    }

    public static String normalize(String str) {
        if (str != null) {
            int indexOf = str.indexOf(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER);
            if (indexOf == -1) {
                indexOf = str.length();
            }
            return str.substring(0, indexOf);
        }
        return str;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof ApkgBaseInfo)) {
            return false;
        }
        if (this != obj && !equalObj(this.appId, ((ApkgBaseInfo) obj).appId)) {
            return false;
        }
        return true;
    }

    public String getApkgFolderPath() {
        return this.apkgFolderPath;
    }

    public String getChildFileAbsolutePath(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return new File(getRootPath(), str).getAbsolutePath();
    }

    public String getRootPath() {
        return this.apkgFolderPath;
    }

    public abstract String getRootPath(String str);

    public abstract String getWorkerPath(String str, String str2);

    public abstract void init(String str) throws Exception;

    public abstract boolean isUrlResReady(String str, MiniAppInfo miniAppInfo);

    public String toString() {
        return "appId:" + this.appId + ", name:" + this.apkgName;
    }

    public ApkgBaseInfo(String str, MiniAppBaseInfo miniAppBaseInfo) {
        this.apkgFolderPath = str;
        if (miniAppBaseInfo != null) {
            this.appId = miniAppBaseInfo.appId;
            this.apkgName = miniAppBaseInfo.name;
            this.iconUrl = miniAppBaseInfo.iconUrl;
        }
    }
}
