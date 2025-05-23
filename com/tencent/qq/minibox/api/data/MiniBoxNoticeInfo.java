package com.tencent.qq.minibox.api.data;

import android.text.TextUtils;
import com.tencent.gamecenter.wadl.biz.entity.WadlParams;
import com.tencent.gamecenter.wadl.biz.entity.WadlResult;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.IMiniBoxLauncher;
import java.io.File;

/* compiled from: P */
/* loaded from: classes22.dex */
public class MiniBoxNoticeInfo extends Entity implements Cloneable {
    public static final int APPNAME_MAX_LENGTH = 6;
    public static final String APPNAME_SUFFIX = "...";
    public static final long HOUR_8 = 28800000;
    public static final long HOUR_9 = 3240000;
    public static final String KEY_APPID = "appid";
    public static final String KEY_ICON_URL = "iconURL";
    public static final String KEY_TIPS = "tips";
    public static final long MIN_10 = 600000;
    public static final long MIN_5 = 300000;
    public static final int NOTIFY_TYPE_BANNER = 2;
    public static final int NOTIFY_TYPE_HOUR_NONE = -1;
    public static final int NOTIFY_TYPE_NOTIFICATION_HOUR8 = 3;
    public static final int NOTIFY_TYPE_NOTIFICATION_MIN5 = 1;
    public static final String TAG = "MiniBoxNoticeInfo";
    public static final int TYPE_MINIBOX_INSTALL = 0;
    public static final int TYPE_NONE = -1;
    public String apkChannel;
    public String appName;
    public int bannerType;
    public long createTime;
    public int downloadType;
    public long endTime;
    public String filePath;
    public String iconUrl;
    public String jumpUrl;
    public String packageName;
    public long startTime;
    public String title;
    public int versionCode;

    @unique
    public String appId = "";

    @notColumn
    public int notifyStatus = -1;

    public MiniBoxNoticeInfo() {
    }

    public static int convertToBannerType(WadlResult wadlResult) {
        if (wadlResult.taskStatus == 6 && !((IMiniBoxLauncher) QRoute.api(IMiniBoxLauncher.class)).isMiniBoxAppInstall(wadlResult.wadlParams.packageName)) {
            return 0;
        }
        return -1;
    }

    private int getNotifyStatus(long j3) {
        long currentTimeMillis = System.currentTimeMillis() - j3;
        if (currentTimeMillis >= MIN_5 && currentTimeMillis < 600000) {
            return 1;
        }
        if (currentTimeMillis >= 600000 && currentTimeMillis < HOUR_8) {
            return 2;
        }
        if (currentTimeMillis >= HOUR_9) {
            return 3;
        }
        return -1;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0053  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object clone() {
        MiniBoxNoticeInfo miniBoxNoticeInfo;
        CloneNotSupportedException e16;
        try {
            miniBoxNoticeInfo = (MiniBoxNoticeInfo) super.clone();
        } catch (CloneNotSupportedException e17) {
            miniBoxNoticeInfo = null;
            e16 = e17;
        }
        try {
            miniBoxNoticeInfo.appId = this.appId;
            miniBoxNoticeInfo.packageName = this.packageName;
            miniBoxNoticeInfo.versionCode = this.versionCode;
            miniBoxNoticeInfo.apkChannel = this.apkChannel;
            miniBoxNoticeInfo.appName = this.appName;
            miniBoxNoticeInfo.filePath = this.filePath;
            miniBoxNoticeInfo.bannerType = this.bannerType;
            miniBoxNoticeInfo.title = this.title;
            miniBoxNoticeInfo.jumpUrl = this.jumpUrl;
            miniBoxNoticeInfo.startTime = this.startTime;
            miniBoxNoticeInfo.endTime = this.endTime;
            miniBoxNoticeInfo.createTime = this.createTime;
            miniBoxNoticeInfo.iconUrl = this.iconUrl;
            miniBoxNoticeInfo.downloadType = this.downloadType;
        } catch (CloneNotSupportedException e18) {
            e16 = e18;
            QLog.e(TAG, 1, "clone exception", e16);
            if (miniBoxNoticeInfo != null) {
            }
        }
        if (miniBoxNoticeInfo != null) {
            return new MiniBoxNoticeInfo();
        }
        return miniBoxNoticeInfo;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return this.appId.equals(((MiniBoxNoticeInfo) obj).appId);
        }
        return false;
    }

    public String getTitle(String str, int i3) {
        String qqStr;
        if (str.length() > 6) {
            str = str.substring(0, 6) + APPNAME_SUFFIX;
        }
        if (i3 != 1 && i3 != 2) {
            if (i3 != 3) {
                qqStr = "";
            } else {
                qqStr = HardCodeUtil.qqStr(R.string.f16530286);
            }
        } else {
            qqStr = HardCodeUtil.qqStr(R.string.f16531287);
        }
        return str + qqStr;
    }

    public boolean isValid() {
        if (TextUtils.isEmpty(this.appId) || this.bannerType == -1 || this.startTime < 1 || this.endTime < 1) {
            return false;
        }
        if (TextUtils.isEmpty(this.filePath)) {
            QLog.w(TAG, 1, "isValid filePath is empty");
            return false;
        }
        if (new File(this.filePath).exists()) {
            return true;
        }
        QLog.w(TAG, 1, "isValid file not exists filePath=" + this.filePath);
        return false;
    }

    public String toString() {
        return "MiniBoxNoticeInfo{appId='" + this.appId + "', packageName='" + this.packageName + "', versionCode=" + this.versionCode + ", appName='" + this.appName + "', filePath='" + this.filePath + "', bannerType=" + this.bannerType + ", apkChannel='" + this.apkChannel + "', title='" + this.title + "', jumpUrl='" + this.jumpUrl + "', startTime=" + this.startTime + ", endTime=" + this.endTime + ", createTime=" + this.createTime + ", downloadType=" + this.downloadType + ", iconUrl='" + this.iconUrl + "', notifyStatus=" + this.notifyStatus + '}';
    }

    public void updateMiniBoxNoticeInfo(WadlResult wadlResult) {
        WadlParams wadlParams = wadlResult.wadlParams;
        this.appId = wadlParams.appId;
        this.appName = wadlParams.appName;
        this.packageName = wadlParams.packageName;
        this.versionCode = wadlParams.versionCode;
        this.apkChannel = wadlParams.apkChannel;
        this.filePath = wadlResult.downloadFilePath;
        this.createTime = wadlResult.createTime;
        this.downloadType = wadlParams.from;
        this.bannerType = convertToBannerType(wadlResult);
        this.iconUrl = wadlResult.wadlParams.iconUrl;
        updateTipsInfo();
    }

    public void updateTipsInfo() {
        QLog.d(TAG, 1, "setTipsInfo bannerType");
        if (!TextUtils.isEmpty(this.filePath)) {
            File file = new File(this.filePath);
            if (!file.exists()) {
                return;
            }
            long lastModified = file.lastModified();
            this.startTime = lastModified;
            int notifyStatus = getNotifyStatus(lastModified);
            this.notifyStatus = notifyStatus;
            this.title = getTitle(this.appName, notifyStatus);
        }
    }

    public MiniBoxNoticeInfo(WadlResult wadlResult) {
        updateMiniBoxNoticeInfo(wadlResult);
    }
}
