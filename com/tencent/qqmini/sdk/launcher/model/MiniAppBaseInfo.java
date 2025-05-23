package com.tencent.qqmini.sdk.launcher.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.utils.ContainerInfo;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes23.dex */
public class MiniAppBaseInfo implements Parcelable {
    public static final int AUDIT = 2;
    public static final int AUDIT_PASS = 6;
    public static final int AUDIT_REJECT = 7;
    public static final Parcelable.Creator<MiniAppBaseInfo> CREATOR = new Parcelable.Creator<MiniAppBaseInfo>() { // from class: com.tencent.qqmini.sdk.launcher.model.MiniAppBaseInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MiniAppBaseInfo createFromParcel(Parcel parcel) {
            return new MiniAppBaseInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MiniAppBaseInfo[] newArray(int i3) {
            return new MiniAppBaseInfo[i3];
        }
    };
    public static final int DELETED = 5;
    public static final int DEVELOP = 0;
    public static final int DEVICE_UNKOWN = 0;
    public static final String ENV_VERSION_DEVELOP = "develop";
    public static final String ENV_VERSION_RELEASE = "release";
    public static final String ENV_VERSION_TRIAL = "trial";
    public static final int EXPERIENCE = 1;
    public static final int GRAY_RELEASE = 8;
    public static final int IS_CONTAINER = 1;
    public static final int LANDSCAPE = 2;
    public static final int LANDSCAPELEFT = 3;
    public static final int LANDSCAPERIGHT = 4;
    public static final int NOT_CONTAINER = 0;
    public static final int NO_SHOW = 2;
    public static final int OFFLINE = 9;
    public static final int ONLINE = 3;
    public static final int PORTRAIT = 1;
    public static final int PREVIEW = 4;
    public static final int SHOW_STATUS = 1;
    public static final int SHOW_UNKOWN = 0;
    public static final String TAG = "MiniAppInfo";
    public static final int TYPE_MINI_APP = 0;
    public static final int TYPE_MINI_GAME = 1;
    public static final int TYPE_MINI_HIPPY = 6;
    public String amsAdInfo;
    public ApkgBaseInfo apkgInfo;
    public String apngUrl;
    public String appId;
    public AppMode appMode;

    @Deprecated
    public int appType;
    public int auditState;
    public String baselibMiniVersion;
    public List<String> blackList;
    public List<String> businessDomainList;
    public DebugInfo debugInfo;
    public String desc;
    public String developerDesc;
    public int deviceOrientation;
    public List<String> downloadFileDomainList;
    public String downloadUrl;
    public boolean enableLoadingAd;
    public int engineType;
    public String extInfo;
    public int fileSize;
    public FirstPageInfo firstPage;
    public String firstPath;
    public String gameApprovalNumber;
    public String gameCopyrightInfo;
    public String gameOperatingCompany;
    public String gamePublicationCompany;
    public String gamePublicationNumber;
    public String iconUrl;
    public String ideExtraAppid;
    public String ideExtraData;
    public String ideScene;
    public String link;
    public int linkType;
    public String name;
    public int noNeedRealRecommend;
    public String prepayId;
    public ArrayList<String> qualifications;
    public int releaseState;
    public RenderInfo renderInfo;
    public String reportData;
    public List<String> requestDomainList;
    public List<SecondApiRightInfo> secondApiRightInfoList;
    public String shareId;
    public int showStatusBar;
    public int skipDomainCheck;
    public List<String> socketDomainList;
    public int startMode;
    public List<SubPkgInfo> subpkgs;
    public int tianshuAdId;
    public long timestamp;
    public List<String> udpIpList;
    public List<String> uploadFileDomainList;
    public long usrFileSizeLimit;
    public int verType;
    public String version;
    public String versionId;
    public int versionUpdateTime;
    public String via;
    public List<String> whiteList;

    public MiniAppBaseInfo() {
        this.udpIpList = new ArrayList();
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

    public static int getVerType(String str) {
        if ("develop".equalsIgnoreCase(str)) {
            return 0;
        }
        if ("trial".equalsIgnoreCase(str)) {
            return 1;
        }
        return 3;
    }

    public static boolean isSameVersion(MiniAppBaseInfo miniAppBaseInfo, MiniAppBaseInfo miniAppBaseInfo2) {
        if (miniAppBaseInfo == null || miniAppBaseInfo2 == null || !equalObj(miniAppBaseInfo.appId, miniAppBaseInfo2.appId) || !equalObj(Integer.valueOf(miniAppBaseInfo.verType), Integer.valueOf(miniAppBaseInfo2.verType)) || !equalObj(miniAppBaseInfo.version, miniAppBaseInfo2.version) || !equalObj(miniAppBaseInfo.versionId, miniAppBaseInfo2.versionId)) {
            return false;
        }
        return true;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(MiniAppBaseInfo miniAppBaseInfo) {
        if (miniAppBaseInfo == null || !equalObj(this.appId, miniAppBaseInfo.appId) || !equalObj(Integer.valueOf(this.verType), Integer.valueOf(miniAppBaseInfo.verType)) || !equalObj(this.version, miniAppBaseInfo.version) || !equalObj(Integer.valueOf(this.engineType), Integer.valueOf(miniAppBaseInfo.engineType)) || !equalObj(this.renderInfo, miniAppBaseInfo.renderInfo)) {
            return false;
        }
        return true;
    }

    public int getEngineType() {
        return this.engineType;
    }

    public String getVerTypeStr() {
        int i3 = this.verType;
        if (i3 != 0 && i3 != 4) {
            if (i3 == 1) {
                return "trial";
            }
            return "release";
        }
        return "develop";
    }

    public boolean isContainerInfo() {
        return TextUtils.equals(ContainerInfo.appId, this.appId);
    }

    public boolean isEngineTypeHippy() {
        if (this.engineType == 6) {
            return true;
        }
        return false;
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

    public boolean isForbidden() {
        if (this.auditState == 5 && this.releaseState == 1) {
            return true;
        }
        return false;
    }

    public boolean isInternalApp() {
        if (this.appId.equals("1109907872")) {
            return true;
        }
        if (this.appId.equals("1109840991")) {
            return AppLoaderFactory.g().getMiniAppEnv().getInnerMode();
        }
        AppMode appMode = this.appMode;
        if (appMode != null && appMode.interMode) {
            return true;
        }
        return false;
    }

    public boolean isLandScape() {
        int i3 = this.deviceOrientation;
        if (i3 != 2 && i3 != 3 && i3 != 4) {
            return false;
        }
        return true;
    }

    public boolean isShowStatusBar() {
        if (this.showStatusBar == 1) {
            return true;
        }
        return false;
    }

    public String simpleInfo() {
        return "[appId=" + this.appId + "][name=" + this.name + "]";
    }

    public boolean supportNativeRenderMode() {
        RenderInfo renderInfo = this.renderInfo;
        if (renderInfo != null && renderInfo.renderMode == 1 && !TextUtils.isEmpty(renderInfo.renderMaterialMap.get(1))) {
            return true;
        }
        return false;
    }

    public String toSimpleString() {
        int i3;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("{appId=");
        sb5.append(this.appId);
        sb5.append(", name=");
        sb5.append(this.name);
        sb5.append(", version=");
        sb5.append(this.version);
        sb5.append(", verType=");
        sb5.append(this.verType);
        sb5.append(", engineType=");
        sb5.append(this.engineType);
        sb5.append(", renderInfo=");
        RenderInfo renderInfo = this.renderInfo;
        if (renderInfo != null) {
            i3 = renderInfo.renderMode;
        } else {
            i3 = -1;
        }
        sb5.append(i3);
        sb5.append(", firstPage=");
        sb5.append(this.firstPage);
        return sb5.toString();
    }

    public String toString() {
        int i3;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("MiniAppInfo{appId=");
        sb5.append(this.appId);
        sb5.append(", name=");
        sb5.append(this.name);
        sb5.append(", version=");
        sb5.append(this.version);
        sb5.append(", verType=");
        sb5.append(this.verType);
        sb5.append(", engineType=");
        sb5.append(this.engineType);
        sb5.append(", renderInfo=");
        RenderInfo renderInfo = this.renderInfo;
        if (renderInfo != null) {
            i3 = renderInfo.renderMode;
        } else {
            i3 = -1;
        }
        sb5.append(i3);
        sb5.append(", firstPage=");
        sb5.append(this.firstPage);
        return sb5.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.appId);
        parcel.writeString(this.name);
        parcel.writeString(this.iconUrl);
        parcel.writeString(this.downloadUrl);
        parcel.writeInt(this.appType);
        parcel.writeString(this.version);
        parcel.writeString(this.versionId);
        parcel.writeString(this.desc);
        parcel.writeInt(this.verType);
        parcel.writeLong(this.timestamp);
        parcel.writeString(this.baselibMiniVersion);
        parcel.writeTypedList(this.subpkgs);
        parcel.writeParcelable(this.firstPage, i3);
        parcel.writeStringList(this.whiteList);
        parcel.writeStringList(this.blackList);
        parcel.writeTypedList(this.secondApiRightInfoList);
        parcel.writeParcelable(this.debugInfo, i3);
        parcel.writeStringList(this.requestDomainList);
        parcel.writeStringList(this.socketDomainList);
        parcel.writeStringList(this.uploadFileDomainList);
        parcel.writeStringList(this.downloadFileDomainList);
        parcel.writeStringList(this.businessDomainList);
        parcel.writeStringList(this.udpIpList);
        parcel.writeInt(this.fileSize);
        parcel.writeString(this.developerDesc);
        parcel.writeInt(this.skipDomainCheck);
        parcel.writeLong(this.usrFileSizeLimit);
        parcel.writeInt(this.noNeedRealRecommend);
        parcel.writeInt(this.versionUpdateTime);
        parcel.writeInt(this.engineType);
        parcel.writeParcelable(this.renderInfo, i3);
        parcel.writeParcelable(this.appMode, i3);
        parcel.writeStringList(this.qualifications);
        parcel.writeString(this.shareId);
        parcel.writeString(this.via);
        parcel.writeString(this.firstPath);
        parcel.writeString(this.link);
        parcel.writeInt(this.linkType);
        parcel.writeInt(this.deviceOrientation);
        parcel.writeInt(this.showStatusBar);
        parcel.writeInt(this.enableLoadingAd ? 1 : 0);
        parcel.writeString(this.prepayId);
        parcel.writeString(this.amsAdInfo);
        parcel.writeString(this.apngUrl);
        parcel.writeString(this.ideScene);
        parcel.writeString(this.ideExtraAppid);
        parcel.writeString(this.ideExtraData);
        parcel.writeInt(this.tianshuAdId);
        parcel.writeString(this.gameCopyrightInfo);
        parcel.writeString(this.gamePublicationNumber);
        parcel.writeString(this.gameOperatingCompany);
        parcel.writeString(this.gameApprovalNumber);
        parcel.writeString(this.gameOperatingCompany);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public MiniAppBaseInfo(Parcel parcel) {
        this.udpIpList = new ArrayList();
        this.appId = parcel.readString();
        this.name = parcel.readString();
        this.iconUrl = parcel.readString();
        this.downloadUrl = parcel.readString();
        this.appType = parcel.readInt();
        this.version = parcel.readString();
        this.versionId = parcel.readString();
        this.desc = parcel.readString();
        this.verType = parcel.readInt();
        this.timestamp = parcel.readLong();
        this.baselibMiniVersion = parcel.readString();
        this.subpkgs = parcel.createTypedArrayList(SubPkgInfo.CREATOR);
        this.firstPage = (FirstPageInfo) parcel.readParcelable(FirstPageInfo.class.getClassLoader());
        this.whiteList = parcel.createStringArrayList();
        this.blackList = parcel.createStringArrayList();
        this.secondApiRightInfoList = parcel.createTypedArrayList(SecondApiRightInfo.CREATOR);
        this.debugInfo = (DebugInfo) parcel.readParcelable(DebugInfo.class.getClassLoader());
        this.requestDomainList = parcel.createStringArrayList();
        this.socketDomainList = parcel.createStringArrayList();
        this.uploadFileDomainList = parcel.createStringArrayList();
        this.downloadFileDomainList = parcel.createStringArrayList();
        this.businessDomainList = parcel.createStringArrayList();
        this.udpIpList = parcel.createStringArrayList();
        this.fileSize = parcel.readInt();
        this.developerDesc = parcel.readString();
        this.skipDomainCheck = parcel.readInt();
        this.usrFileSizeLimit = parcel.readLong();
        this.noNeedRealRecommend = parcel.readInt();
        this.versionUpdateTime = parcel.readInt();
        this.engineType = parcel.readInt();
        this.renderInfo = (RenderInfo) parcel.readParcelable(RenderInfo.class.getClassLoader());
        this.appMode = (AppMode) parcel.readParcelable(AppMode.class.getClassLoader());
        this.qualifications = parcel.createStringArrayList();
        this.shareId = parcel.readString();
        this.via = parcel.readString();
        this.firstPath = parcel.readString();
        this.link = parcel.readString();
        this.linkType = parcel.readInt();
        this.deviceOrientation = parcel.readInt();
        this.showStatusBar = parcel.readInt();
        this.enableLoadingAd = parcel.readInt() == 1;
        this.prepayId = parcel.readString();
        this.amsAdInfo = parcel.readString();
        this.apngUrl = parcel.readString();
        this.ideScene = parcel.readString();
        this.ideExtraAppid = parcel.readString();
        this.ideExtraData = parcel.readString();
        this.tianshuAdId = parcel.readInt();
        this.gameCopyrightInfo = parcel.readString();
        this.gamePublicationNumber = parcel.readString();
        this.gamePublicationCompany = parcel.readString();
        this.gameApprovalNumber = parcel.readString();
        this.gameOperatingCompany = parcel.readString();
    }
}
