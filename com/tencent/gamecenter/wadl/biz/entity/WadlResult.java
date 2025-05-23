package com.tencent.gamecenter.wadl.biz.entity;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.gamecenter.wadl.util.GameCenterUtil;

/* compiled from: P */
/* loaded from: classes6.dex */
public class WadlResult implements Parcelable {
    public static final Parcelable.Creator<WadlResult> CREATOR = new a();
    public static final String WEB_DOWNLOAD_TYPE = "downloadType";
    public static final String WEB_KEY_APPID = "appid";
    public static final String WEB_KEY_APP_NAME = "appName";
    public static final String WEB_KEY_ERR_CODE = "errorCode";
    public static final String WEB_KEY_ERR_MSG = "errorMsg";
    public static final String WEB_KEY_EXTRA_INFO = "extraInfo";
    public static final String WEB_KEY_F_PROGRESS = "f_pro";
    public static final String WEB_KEY_ICON_URL = "iconUrl";
    public static final String WEB_KEY_IS_AUTO_INSTALL_BY_SDK = "isAutoInstallBySDK";
    public static final String WEB_KEY_IS_RES = "isRes";
    public static final String WEB_KEY_MIE_ACT_ID = "mieActId";
    public static final String WEB_KEY_PACKAGE_NAME = "packagename";
    public static final String WEB_KEY_PROGRESS = "pro";
    public static final String WEB_KEY_RES_MD5 = "resMD5";
    public static final String WEB_KEY_RES_NAME = "resName";
    public static final String WEB_KEY_RES_VERSION_NAME = "resVersionName";
    public static final String WEB_KEY_SAVE_PATH = "savePath";
    public static final String WEB_KEY_SPEED = "speed";
    public static final String WEB_KEY_STATE = "state";
    public static final String WEB_KEY_VERSION_CODE = "versionCode";
    public static final String WEB_KEY_VIA = "via";
    public static final String WEB_KEY_WRITE_CODE_STATE = "writecodestate";
    public int businessId;
    public long createTime;
    public String downloadFilePath;
    public long downloadFileSize;
    public int errCode;
    public int event;
    public long fileSize;
    public float floatProgress;
    public long lastUpdateTime;
    public int progress;
    public long speed;

    @Deprecated
    public String taskId = "";
    public int taskStatus;
    public WadlParams wadlParams;

    /* compiled from: P */
    /* loaded from: classes6.dex */
    class a implements Parcelable.Creator<WadlResult> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public WadlResult createFromParcel(Parcel parcel) {
            return new WadlResult(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public WadlResult[] newArray(int i3) {
            return new WadlResult[i3];
        }
    }

    public WadlResult(WadlParams wadlParams) {
        if (wadlParams != null) {
            this.wadlParams = wadlParams;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean isDownloadComplete() {
        WadlParams wadlParams = this.wadlParams;
        if (wadlParams != null && !TextUtils.isEmpty(wadlParams.appId) && this.taskStatus == 6) {
            return true;
        }
        return false;
    }

    public boolean isRunning() {
        int i3 = this.taskStatus;
        if (i3 != 13 && i3 != 2 && i3 != 4) {
            return false;
        }
        return true;
    }

    public boolean isTaskPaused() {
        int i3 = this.taskStatus;
        if (i3 != 5 && i3 != 7) {
            return false;
        }
        return true;
    }

    public String toSimpleString() {
        String str;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("{taskStatus=");
        sb5.append(this.taskStatus);
        sb5.append(", downloadFileSize=");
        sb5.append(this.downloadFileSize);
        sb5.append(", fileSize=");
        sb5.append(this.fileSize);
        sb5.append(", createTime=");
        sb5.append(this.createTime);
        sb5.append(", floatProgress=");
        sb5.append(this.floatProgress);
        sb5.append(", appId=");
        WadlParams wadlParams = this.wadlParams;
        if (wadlParams != null) {
            str = wadlParams.appId;
        } else {
            str = "";
        }
        sb5.append(str);
        sb5.append('}');
        return sb5.toString();
    }

    public String toString() {
        return "WadlResult{ event=" + this.event + ", businessId=" + this.businessId + ", taskStatus=" + this.taskStatus + ", fileSize=" + this.fileSize + ", downloadFileSize=" + this.downloadFileSize + ", speed=" + this.speed + ", downloadFilePath='" + this.downloadFilePath + "', createTime=" + this.createTime + ", lastUpdateTime=" + this.lastUpdateTime + ", errCode=" + this.errCode + ", progress=" + this.progress + ", floatProgress=" + this.floatProgress + ", " + this.wadlParams + '}';
    }

    public boolean update(WadlResult wadlResult) {
        boolean z16;
        int i3 = this.taskStatus;
        int i16 = wadlResult.taskStatus;
        if (i3 != i16) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.wadlParams = wadlResult.wadlParams;
        this.taskStatus = i16;
        this.fileSize = wadlResult.fileSize;
        this.downloadFileSize = wadlResult.downloadFileSize;
        this.speed = wadlResult.speed;
        this.downloadFilePath = wadlResult.downloadFilePath;
        this.lastUpdateTime = wadlResult.lastUpdateTime;
        this.errCode = wadlResult.errCode;
        this.progress = wadlResult.progress;
        this.floatProgress = wadlResult.floatProgress;
        return z16;
    }

    public boolean updateTaskStatus() {
        boolean z16;
        WadlParams wadlParams = this.wadlParams;
        if (wadlParams != null) {
            z16 = wadlParams.isRes;
        } else {
            z16 = false;
        }
        if (!z16 && this.taskStatus == 9) {
            this.taskStatus = 6;
        }
        if (this.taskStatus == 6 && !GameCenterUtil.fileExists(this.downloadFilePath)) {
            this.taskStatus = 0;
        }
        if (this.taskStatus == 0) {
            return false;
        }
        return true;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeParcelable(this.wadlParams, i3);
        parcel.writeInt(this.businessId);
        parcel.writeInt(this.taskStatus);
        parcel.writeLong(this.fileSize);
        parcel.writeLong(this.downloadFileSize);
        parcel.writeLong(this.speed);
        parcel.writeString(this.downloadFilePath);
        parcel.writeLong(this.createTime);
        parcel.writeLong(this.lastUpdateTime);
        parcel.writeInt(this.errCode);
        parcel.writeInt(this.progress);
        parcel.writeFloat(this.floatProgress);
    }

    protected WadlResult(Parcel parcel) {
        this.wadlParams = (WadlParams) parcel.readParcelable(WadlParams.class.getClassLoader());
        this.businessId = parcel.readInt();
        this.taskStatus = parcel.readInt();
        this.fileSize = parcel.readLong();
        this.downloadFileSize = parcel.readLong();
        this.speed = parcel.readLong();
        this.downloadFilePath = parcel.readString();
        this.createTime = parcel.readLong();
        this.lastUpdateTime = parcel.readLong();
        this.errCode = parcel.readInt();
        this.progress = parcel.readInt();
        this.floatProgress = parcel.readFloat();
    }
}
