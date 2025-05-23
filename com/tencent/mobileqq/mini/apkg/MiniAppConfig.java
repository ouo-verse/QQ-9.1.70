package com.tencent.mobileqq.mini.apkg;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.component.network.module.base.QDLog;
import com.tencent.mobileqq.mini.sdk.BaseLibInfo;
import com.tencent.mobileqq.mini.sdk.LaunchParam;

/* compiled from: P */
/* loaded from: classes33.dex */
public class MiniAppConfig implements Parcelable {
    public static final Parcelable.Creator<MiniAppConfig> CREATOR = new Parcelable.Creator<MiniAppConfig>() { // from class: com.tencent.mobileqq.mini.apkg.MiniAppConfig.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MiniAppConfig createFromParcel(Parcel parcel) {
            LaunchParam launchParam;
            int readInt;
            MiniAppConfig miniAppConfig;
            MiniAppConfig miniAppConfig2 = null;
            try {
                MiniAppInfo miniAppInfo = (MiniAppInfo) parcel.readParcelable(MiniAppInfo.class.getClassLoader());
                launchParam = (LaunchParam) parcel.readParcelable(LaunchParam.class.getClassLoader());
                BaseLibInfo baseLibInfo = (BaseLibInfo) parcel.readParcelable(BaseLibInfo.class.getClassLoader());
                readInt = parcel.readInt();
                miniAppConfig = new MiniAppConfig(miniAppInfo, baseLibInfo);
            } catch (Throwable th5) {
                th = th5;
            }
            try {
                miniAppConfig.launchParam = launchParam;
                miniAppConfig.forceReroad = readInt;
                miniAppConfig.isFromShowInfo = parcel.readInt() == 1;
                miniAppConfig.link = parcel.readString();
                miniAppConfig.linkType = parcel.readInt();
                miniAppConfig.entryPath = parcel.readString();
                miniAppConfig.isSdkMode = parcel.readInt() == 1;
                return miniAppConfig;
            } catch (Throwable th6) {
                th = th6;
                miniAppConfig2 = miniAppConfig;
                QDLog.e("miniapp", "MiniAppConfig createFromParcel exception!", th);
                return miniAppConfig2;
            }
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MiniAppConfig[] newArray(int i3) {
            return new MiniAppConfig[i3];
        }
    };
    public static final int TYPE_CLOUD_GAME = 7;
    public static final int TYPE_H5_GAME = 8;
    public static final int TYPE_MINI_APP = 0;
    public static final int TYPE_MINI_GAME = 1;
    public static final int TYPE_VIRTUAL_APP = 5;
    public static final int TYPE_YUNGAME_SDK_APP = 6;
    public BaseLibInfo baseLibInfo;
    public MiniAppInfo config;
    public String entryPath;

    @Deprecated
    private int forceReroad;
    public int gameAdsTotalTime;
    public boolean isFromShowInfo;
    public boolean isSdkMode;
    public LaunchParam launchParam;
    public String link;
    public int linkType;

    public MiniAppConfig(MiniAppInfo miniAppInfo) {
        this(miniAppInfo, getBaseLibInfoByType(miniAppInfo));
    }

    private static BaseLibInfo getBaseLibInfoByType(MiniAppInfo miniAppInfo) {
        return BaseLibManager.g().getBaseLibInfo();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getConfigInfo() {
        return "config =" + this.config;
    }

    public boolean isBackToMiniApp() {
        LaunchParam launchParam = this.launchParam;
        return launchParam != null && launchParam.fromBackToMiniApp == 1;
    }

    public boolean isEngineTypeMiniGame() {
        MiniAppInfo miniAppInfo = this.config;
        return miniAppInfo != null && miniAppInfo.isEngineTypeMiniGame();
    }

    public boolean isFromShowInfo() {
        return this.isFromShowInfo;
    }

    public boolean isInternalApp() {
        MiniAppInfo miniAppInfo = this.config;
        return miniAppInfo != null && miniAppInfo.isInternalApp();
    }

    public boolean isLimitedAccessApp() {
        MiniAppInfo miniAppInfo = this.config;
        return miniAppInfo != null && miniAppInfo.isLimitedAccessApp();
    }

    public boolean isReportTypeMiniGame() {
        MiniAppInfo miniAppInfo = this.config;
        return miniAppInfo != null && miniAppInfo.isReportTypeMiniGame();
    }

    public boolean isShortcutFakeApp() {
        MiniAppInfo miniAppInfo;
        LaunchParam launchParam = this.launchParam;
        return launchParam != null && launchParam.scene == 1023 && (miniAppInfo = this.config) != null && TextUtils.isEmpty(miniAppInfo.downloadUrl);
    }

    public String toString() {
        return "MiniAppConfig{config=" + this.config + ", launchParam=" + this.launchParam + ", baseLibInfo=" + this.baseLibInfo + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeParcelable(this.config, 0);
        parcel.writeParcelable(this.launchParam, 0);
        parcel.writeParcelable(this.baseLibInfo, 0);
        parcel.writeInt(this.forceReroad);
        parcel.writeInt(this.isFromShowInfo ? 1 : 0);
        parcel.writeString(this.link);
        parcel.writeInt(this.linkType);
        parcel.writeString(this.entryPath);
        parcel.writeInt(this.isSdkMode ? 1 : 0);
    }

    MiniAppConfig(MiniAppInfo miniAppInfo, BaseLibInfo baseLibInfo) {
        this.forceReroad = 0;
        this.isSdkMode = false;
        this.gameAdsTotalTime = 0;
        this.config = miniAppInfo;
        this.baseLibInfo = baseLibInfo;
        this.launchParam = new LaunchParam();
    }

    public static boolean isValid(MiniAppConfig miniAppConfig) {
        MiniAppInfo miniAppInfo;
        return (miniAppConfig == null || (miniAppInfo = miniAppConfig.config) == null || TextUtils.isEmpty(miniAppInfo.appId)) ? false : true;
    }

    public boolean equals(MiniAppConfig miniAppConfig) {
        if (miniAppConfig == null) {
            return false;
        }
        return miniAppConfig.config == null ? this.config == null : isEngineTypeMiniGame() ? equalObj(this.config.appId, miniAppConfig.config.appId) && equalObj(Integer.valueOf(this.config.verType), Integer.valueOf(miniAppConfig.config.verType)) && equalObj(this.config.version, miniAppConfig.config.version) : equalObj(this.config.appId, miniAppConfig.config.appId) && equalObj(Integer.valueOf(this.config.verType), Integer.valueOf(miniAppConfig.config.verType)) && equalObj(this.config.version, miniAppConfig.config.version) && equalObj(this.config.firstPage, miniAppConfig.config.firstPage);
    }

    public static boolean equalObj(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }
}
