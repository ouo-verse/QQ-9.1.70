package com.tencent.mobileqq.data;

import android.text.TextUtils;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.qphone.base.util.MD5;
import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes10.dex */
public class RockDownloadInfo extends Entity implements Serializable {
    public static final int CHECK_LEVEL_DELETE = 3;
    public static final int CHECK_LEVEL_DOWNLOAD = 1;
    public static final int CHECK_LEVEL_INSTALL = 4;
    public static final int CHECK_LEVEL_QUERY = 2;
    private static final String TAG = "RockDownloadInfo";
    public String applicationName;
    public String businessName;
    public String businessScene;
    public String downloadURL;
    public long endTime;
    public String localPath;
    public String md5;
    public String packageName;
    public int realVersionCode;
    public long startTime;
    public String ticket;
    public int versionCode;

    public RockDownloadInfo(String str, String str2, String str3, String str4, int i3) {
        this.businessName = str;
        this.businessScene = str2;
        this.packageName = str3;
        this.downloadURL = str4;
        this.versionCode = i3;
    }

    public String getApplicationName() {
        return this.applicationName;
    }

    public String getBusinessName() {
        return this.businessName;
    }

    public String getBusinessScene() {
        return this.businessScene;
    }

    public String getDownloadFileNameMD5() {
        if (this.realVersionCode == 0) {
            return MD5.toMD5(this.businessName + this.businessScene + this.packageName + this.versionCode);
        }
        return MD5.toMD5(this.businessName + this.businessScene + this.packageName + this.realVersionCode);
    }

    public String getDownloadURL() {
        return this.downloadURL;
    }

    public String getLocalPath() {
        return this.localPath;
    }

    public String getMd5() {
        return this.md5;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public int getRealVersionCode() {
        return this.realVersionCode;
    }

    public int getVersionCode() {
        return this.versionCode;
    }

    public void setApplicationName(String str) {
        this.applicationName = str;
    }

    public void setBusinessName(String str) {
        this.businessName = str;
    }

    public void setBusinessScene(String str) {
        this.businessScene = str;
    }

    public void setDownloadURL(String str) {
        this.downloadURL = str;
    }

    public void setLocalPath(String str) {
        this.localPath = str;
    }

    public void setMd5(String str) {
        this.md5 = str;
    }

    public void setPackageName(String str) {
        this.packageName = str;
    }

    public void setRealVersionCode(int i3) {
        this.realVersionCode = i3;
    }

    public void setVersionCode(int i3) {
        this.versionCode = i3;
    }

    public String toString() {
        return "RockDownloadInfo{businessName='" + this.businessName + "', businessScene='" + this.businessScene + "', packageName='" + this.packageName + "', downloadURL='" + this.downloadURL + "', versionCode=" + this.versionCode + ", startTime=" + this.startTime + ", endTime=" + this.endTime + ", applicationName='" + this.applicationName + "', md5='" + this.md5 + "', realVersionCode=" + this.realVersionCode + ", localPath='" + this.localPath + "', ticket='" + this.ticket + "'}";
    }

    public boolean verifyDate(int i3) {
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 == 4 && !TextUtils.isEmpty(this.businessName) && !TextUtils.isEmpty(this.localPath)) {
                        return true;
                    }
                    return false;
                }
            } else if (!TextUtils.isEmpty(this.businessName) && !TextUtils.isEmpty(this.packageName)) {
                return true;
            }
            if (!TextUtils.isEmpty(this.businessName) && !TextUtils.isEmpty(this.localPath)) {
                return true;
            }
            return false;
        }
        if (!TextUtils.isEmpty(this.businessName) && !TextUtils.isEmpty(this.businessScene) && !TextUtils.isEmpty(this.packageName) && !TextUtils.isEmpty(this.downloadURL) && this.versionCode > 0) {
            return true;
        }
        return false;
    }

    public RockDownloadInfo(String str, String str2, String str3) {
        this.businessName = str;
        this.businessScene = str2;
        this.packageName = str3;
    }

    public RockDownloadInfo(String str, String str2) {
        this.businessName = str;
        this.packageName = str2;
    }

    public RockDownloadInfo() {
    }
}
