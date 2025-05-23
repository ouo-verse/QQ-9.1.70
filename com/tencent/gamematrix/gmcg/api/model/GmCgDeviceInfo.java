package com.tencent.gamematrix.gmcg.api.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.tencent.gamematrix.gmcg.api.GmCgDeviceAllocSource;
import com.tencent.gamematrix.gmcg.api.util.CGStringUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes6.dex */
public class GmCgDeviceInfo implements Parcelable {
    public static final Parcelable.Creator<GmCgDeviceInfo> CREATOR = new Parcelable.Creator<GmCgDeviceInfo>() { // from class: com.tencent.gamematrix.gmcg.api.model.GmCgDeviceInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GmCgDeviceInfo createFromParcel(Parcel parcel) {
            return new GmCgDeviceInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GmCgDeviceInfo[] newArray(int i3) {
            return new GmCgDeviceInfo[i3];
        }
    };

    @GmCgDeviceAllocSource
    private int allocateSource;
    private String bizInfo;
    private boolean bot;
    private int cloudGameScreenType;
    private int cloudGameType;
    public String cluster;
    public List<GmCgClusterLabel> clusterLabels;
    public String coldStartDevice;
    private String controlkey;
    private int curAllocQueueSize;
    private int curAllocQueueWaitSec;
    private long currentTime;
    private String deviceArea;
    private String deviceID;
    private String deviceName;
    public String deviceState;
    private String deviceTag;
    private String deviceZone;
    private int fps;
    private int frameworkType;
    private int gameClientType;
    private String gamePackageName;
    public String hardwareType;
    private boolean hasAutoLogin;
    private boolean hasSaveArchive;
    private boolean hasSetResolution;
    private int height;
    private String identity;
    public int identityProfType;
    private boolean isCreatedByOther;
    public boolean isMainLand;
    private int keepIdleTime;
    public int keepaliveLeftTime;
    public int keepaliveState;
    private boolean reallocated;
    private long sessionStartTime;
    public GmCgAllocSignalServer signalServer;
    public double startPercent;
    private boolean supportFreeFlow;
    public List<String> userAbilities;
    private List<String> webrtcIP;
    private String webrtcUrl;
    private int width;

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static class Builder {

        @GmCgDeviceAllocSource
        private int bAllocateSource;
        private String bArea;
        private String bBizInfo;
        private boolean bBot;
        private int bCloudGameScreenType;
        private int bCloudGameType;
        private String bCluster;
        private List<GmCgClusterLabel> bClusterLables;
        private String bColdStartDevice;
        private String bControlkey;
        private int bCurAllocQueueSize;
        private int bCurAllocQueueWaitSec;
        private long bCurrentTime;
        private String bDeviceID;
        private String bDeviceState;
        private int bFps;
        private int bFrameworkType;
        private int bGameClientType = 0;
        private String bGamePackageName;
        private String bHardwareType;
        private boolean bHasAutoLogin;
        private boolean bHasSaveArchive;
        private boolean bHasSetResolution;
        private int bHeight;
        private String bIdentity;
        private int bIdentityProfileType;
        private boolean bIsCreatedByOther;
        private int bKeepIdleTime;
        private String bName;
        private boolean bReallocated;
        private long bSessionStartTime;
        private GmCgAllocSignalServer bSignalServer;
        private double bStartPercent;
        private boolean bSupportFreeFlow;
        private String bTag;
        private List<String> bUserAbilities;
        private List<String> bWebrtcIP;
        private String bWebrtcUrl;
        private int bWidth;
        private String bZone;
        private boolean isMainLand;
        private int keepaliveLeftTime;
        private int keepaliveState;

        public GmCgDeviceInfo build() {
            return new GmCgDeviceInfo(this);
        }

        public Builder setAllocateSource(@GmCgDeviceAllocSource int i3) {
            this.bAllocateSource = i3;
            return this;
        }

        public Builder setArea(String str) {
            this.bArea = str;
            return this;
        }

        public Builder setBizInfo(String str) {
            this.bBizInfo = str;
            return this;
        }

        public Builder setBot(boolean z16) {
            this.bBot = z16;
            return this;
        }

        public Builder setCloudGameScreenType(int i3) {
            this.bCloudGameScreenType = i3;
            return this;
        }

        public Builder setCloudGameType(int i3) {
            this.bCloudGameType = i3;
            return this;
        }

        public Builder setCluster(String str) {
            this.bCluster = str;
            return this;
        }

        public Builder setClusterLabel(List<GmCgClusterLabel> list) {
            this.bClusterLables = list;
            return this;
        }

        public Builder setColdDeviceId(String str) {
            this.bColdStartDevice = str;
            return this;
        }

        public Builder setColdDevicePercent(double d16) {
            this.bStartPercent = d16;
            return this;
        }

        public Builder setColdDeviceState(String str) {
            this.bDeviceState = str;
            return this;
        }

        public Builder setControlkey(String str) {
            this.bControlkey = str;
            return this;
        }

        public Builder setCreatedByOther(boolean z16) {
            this.bIsCreatedByOther = z16;
            return this;
        }

        public Builder setCurAllocQueueInfo(int i3, int i16) {
            this.bCurAllocQueueSize = i3;
            this.bCurAllocQueueWaitSec = i16;
            return this;
        }

        public Builder setCurrentTime(long j3) {
            this.bCurrentTime = j3;
            return this;
        }

        public Builder setDeviceID(String str) {
            this.bGameClientType = 0;
            this.bDeviceID = str;
            return this;
        }

        public Builder setDeviceName(String str) {
            this.bName = str;
            return this;
        }

        public Builder setDeviceTag(String str) {
            this.bTag = str;
            return this;
        }

        public Builder setFps(int i3) {
            this.bFps = i3;
            return this;
        }

        public Builder setFrameworkType(int i3) {
            this.bFrameworkType = i3;
            return this;
        }

        public Builder setGamePackageName(String str) {
            this.bGamePackageName = str;
            return this;
        }

        public Builder setHardwareType(String str) {
            this.bHardwareType = str;
            return this;
        }

        public Builder setHasAutoLogin(boolean z16) {
            this.bHasAutoLogin = z16;
            return this;
        }

        public Builder setHasSaveArchive(boolean z16) {
            this.bHasSaveArchive = z16;
            return this;
        }

        public Builder setHasSetResolution(boolean z16) {
            this.bHasSetResolution = z16;
            return this;
        }

        public Builder setHeight(int i3) {
            this.bHeight = i3;
            return this;
        }

        public Builder setIdentity(String str) {
            this.bIdentity = str;
            return this;
        }

        public Builder setIdentityProfileType(int i3) {
            this.bIdentityProfileType = i3;
            return this;
        }

        public Builder setKeepAliveLeftTime(int i3) {
            this.keepaliveLeftTime = i3;
            return this;
        }

        public Builder setKeepAliveState(int i3) {
            this.keepaliveState = i3;
            return this;
        }

        public Builder setKeepIdleTime(int i3) {
            this.bKeepIdleTime = i3;
            return this;
        }

        public Builder setMainLand(boolean z16) {
            this.isMainLand = z16;
            return this;
        }

        public Builder setPcDeviceId(String str) {
            this.bGameClientType = 1;
            this.bDeviceID = str;
            return this;
        }

        public Builder setReallocated(boolean z16) {
            this.bReallocated = z16;
            return this;
        }

        public Builder setSessionStartTime(long j3) {
            this.bSessionStartTime = j3;
            return this;
        }

        public Builder setSignalServer(GmCgAllocSignalServer gmCgAllocSignalServer) {
            this.bSignalServer = gmCgAllocSignalServer;
            return this;
        }

        public Builder setSupportFreeFlow(boolean z16) {
            this.bSupportFreeFlow = z16;
            return this;
        }

        public Builder setUserAbilities(List<String> list) {
            this.bUserAbilities = list;
            return this;
        }

        public Builder setWebrtcIP(List<String> list) {
            this.bWebrtcIP = list;
            return this;
        }

        public Builder setWebrtcUrl(String str) {
            this.bWebrtcUrl = str;
            return this;
        }

        public Builder setWidth(int i3) {
            this.bWidth = i3;
            return this;
        }

        public Builder setZone(String str) {
            this.bZone = str;
            return this;
        }
    }

    public static GmCgDeviceInfo createDeviceByColdStartInfo(GmCgColdStartDeviceInfo gmCgColdStartDeviceInfo) {
        return new Builder().setBizInfo(gmCgColdStartDeviceInfo.pBizInfo).setColdDeviceId(gmCgColdStartDeviceInfo.coldStartDevice).setColdDeviceState(gmCgColdStartDeviceInfo.deviceState).setColdDevicePercent(gmCgColdStartDeviceInfo.startPercent).build();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @GmCgDeviceAllocSource
    public int getAllocateSource() {
        return this.allocateSource;
    }

    public String getBizInfo() {
        return this.bizInfo;
    }

    public int getCloudGameScreenType() {
        return this.cloudGameScreenType;
    }

    public int getCloudGameType() {
        return this.cloudGameType;
    }

    public String getCluster() {
        return this.cluster;
    }

    @NonNull
    public List<GmCgClusterLabel> getClusterLabels() {
        if (this.clusterLabels == null) {
            this.clusterLabels = new ArrayList();
        }
        return this.clusterLabels;
    }

    public String getControlkey() {
        return this.controlkey;
    }

    public int getCurAllocQueueSize() {
        return this.curAllocQueueSize;
    }

    public int getCurAllocQueueWaitSec() {
        return this.curAllocQueueWaitSec;
    }

    public long getCurrentTime() {
        return this.currentTime;
    }

    public String getDeviceArea() {
        return this.deviceArea;
    }

    public int getDeviceFps() {
        return this.fps;
    }

    public String getDeviceID() {
        return this.deviceID;
    }

    public String getDeviceName() {
        return this.deviceName;
    }

    public String getDeviceTag() {
        return this.deviceTag;
    }

    public String getDeviceZone() {
        return this.deviceZone;
    }

    public int getFrameworkType() {
        return this.frameworkType;
    }

    public String getFrameworkTypeSymbol() {
        int i3 = this.frameworkType;
        if (i3 != 0) {
            if (i3 != 1) {
                return QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER;
            }
            return "a";
        }
        return QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB;
    }

    public int getGameClientType() {
        return this.gameClientType;
    }

    public String getGamePackageName() {
        return this.gamePackageName;
    }

    public String getHardwareType() {
        return this.hardwareType;
    }

    public int getHeight() {
        return this.height;
    }

    public String getIdentity() {
        return this.identity;
    }

    public int getIdentityProfType() {
        return this.identityProfType;
    }

    public int getKeepIdleTime() {
        return this.keepIdleTime;
    }

    public long getSessionStartTime() {
        return this.sessionStartTime;
    }

    public GmCgAllocSignalServer getSignalServer() {
        return this.signalServer;
    }

    public List<String> getWebrtcIP() {
        return this.webrtcIP;
    }

    public String getWebrtcUrl() {
        return this.webrtcUrl;
    }

    public int getWidth() {
        return this.width;
    }

    public boolean hasAutoLogin() {
        return this.hasAutoLogin;
    }

    public boolean hasSaveArchive() {
        return this.hasSaveArchive;
    }

    public boolean hasSetResolution() {
        return this.hasSetResolution;
    }

    public boolean isBot() {
        return this.bot;
    }

    public boolean isColdStartDevice() {
        if (CGStringUtil.isEmpty(this.coldStartDevice) && !isValid()) {
            return true;
        }
        return false;
    }

    public boolean isCreatedByOther() {
        return this.isCreatedByOther;
    }

    public boolean isMobileTypeValid() {
        if (this.gameClientType == 0 && CGStringUtil.notEmpty(this.deviceID) && CGStringUtil.notEmpty(this.controlkey) && CGStringUtil.notEmpty(this.webrtcUrl)) {
            return true;
        }
        return false;
    }

    public boolean isPcTypeValid() {
        if (1 == this.gameClientType && CGStringUtil.notEmpty(this.deviceID)) {
            return true;
        }
        return false;
    }

    public boolean isReallocated() {
        return this.reallocated;
    }

    public boolean isValid() {
        if (!isMobileTypeValid() && !isPcTypeValid()) {
            return false;
        }
        return true;
    }

    public void setBizInfo(String str) {
        this.bizInfo = str;
    }

    public void setBot(boolean z16) {
        this.bot = z16;
    }

    public void setCreatedByOther(boolean z16) {
        this.isCreatedByOther = z16;
    }

    public void setGamePackageName(String str) {
        this.gamePackageName = str;
    }

    public boolean supportFreeFlow() {
        return this.supportFreeFlow;
    }

    public String toString() {
        return "GmCgDeviceInfo{gameClientType=" + this.gameClientType + ", deviceID='" + this.deviceID + "', deviceName='" + this.deviceName + "', width=" + this.width + ", height=" + this.height + ", deviceArea='" + this.deviceArea + "', deviceZone='" + this.deviceZone + "', identity='" + this.identity + "', deviceTag='" + this.deviceTag + "', controlkey='" + this.controlkey + "', webrtcUrl='" + this.webrtcUrl + "', cloudGameType=" + this.cloudGameType + ", cloudGameScreenType=" + this.cloudGameScreenType + ", sessionStartTime=" + this.sessionStartTime + ", currentTime=" + this.currentTime + ", bizInfo='" + this.bizInfo + "', frameworkType=" + this.frameworkType + ", reallocated=" + this.reallocated + ", bot=" + this.bot + ", keepIdleTime=" + this.keepIdleTime + ", hasSaveArchive=" + this.hasSaveArchive + ", hasAutoLogin=" + this.hasAutoLogin + ", hasSetResolution=" + this.hasSetResolution + ", supportFreeFlow=" + this.supportFreeFlow + ", gamePackageName='" + this.gamePackageName + "', allocateSource=" + this.allocateSource + ", isCreatedByOther=" + this.isCreatedByOther + ", identityProfType=" + this.identityProfType + ", curAllocQueueSize=" + this.curAllocQueueSize + ", curAllocQueueWaitSec=" + this.curAllocQueueWaitSec + ", coldStartDevice='" + this.coldStartDevice + "', deviceState='" + this.deviceState + "', startPercent=" + this.startPercent + ", cluster = " + this.cluster + ", hardwareType='" + this.hardwareType + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.gameClientType);
        parcel.writeString(this.deviceID);
        parcel.writeString(this.deviceName);
        parcel.writeInt(this.width);
        parcel.writeInt(this.height);
        parcel.writeString(this.deviceArea);
        parcel.writeString(this.deviceZone);
        parcel.writeString(this.identity);
        parcel.writeString(this.deviceTag);
        parcel.writeString(this.controlkey);
        parcel.writeString(this.webrtcUrl);
        parcel.writeStringList(this.webrtcIP);
        parcel.writeInt(this.cloudGameType);
        parcel.writeInt(this.cloudGameScreenType);
        parcel.writeLong(this.sessionStartTime);
        parcel.writeLong(this.currentTime);
        parcel.writeString(this.bizInfo);
        parcel.writeInt(this.frameworkType);
        parcel.writeByte(this.reallocated ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.bot ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.keepIdleTime);
        parcel.writeByte(this.hasSaveArchive ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.hasAutoLogin ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.hasSetResolution ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.supportFreeFlow ? (byte) 1 : (byte) 0);
        parcel.writeString(this.gamePackageName);
        parcel.writeInt(this.allocateSource);
        parcel.writeByte(this.isCreatedByOther ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.fps);
        parcel.writeInt(this.identityProfType);
        parcel.writeInt(this.curAllocQueueSize);
        parcel.writeInt(this.curAllocQueueWaitSec);
        parcel.writeString(this.coldStartDevice);
        parcel.writeString(this.deviceState);
        parcel.writeDouble(this.startPercent);
        parcel.writeStringList(this.userAbilities);
        parcel.writeString(this.hardwareType);
    }

    GmCgDeviceInfo(Builder builder) {
        this.gameClientType = builder.bGameClientType;
        this.deviceID = builder.bDeviceID;
        this.deviceName = builder.bName;
        this.width = builder.bWidth;
        this.height = builder.bHeight;
        this.deviceArea = builder.bArea;
        this.deviceZone = builder.bZone;
        this.identity = builder.bIdentity;
        this.deviceTag = builder.bTag;
        this.controlkey = builder.bControlkey;
        this.webrtcUrl = builder.bWebrtcUrl;
        this.webrtcIP = builder.bWebrtcIP;
        this.cloudGameType = builder.bCloudGameType;
        this.cloudGameScreenType = builder.bCloudGameScreenType;
        this.sessionStartTime = builder.bSessionStartTime;
        this.currentTime = builder.bCurrentTime;
        this.bizInfo = builder.bBizInfo;
        this.frameworkType = builder.bFrameworkType;
        this.reallocated = builder.bReallocated;
        this.bot = builder.bBot;
        this.keepIdleTime = builder.bKeepIdleTime;
        this.allocateSource = builder.bAllocateSource;
        this.hasSaveArchive = builder.bHasSaveArchive;
        this.hasAutoLogin = builder.bHasAutoLogin;
        this.hasSetResolution = builder.bHasSetResolution;
        this.supportFreeFlow = builder.bSupportFreeFlow;
        this.gamePackageName = builder.bGamePackageName;
        this.isCreatedByOther = builder.bIsCreatedByOther;
        this.identityProfType = builder.bIdentityProfileType;
        this.curAllocQueueSize = builder.bCurAllocQueueSize;
        this.curAllocQueueWaitSec = builder.bCurAllocQueueWaitSec;
        this.clusterLabels = builder.bClusterLables;
        this.fps = builder.bFps;
        this.keepaliveState = builder.keepaliveState;
        this.keepaliveLeftTime = builder.keepaliveLeftTime;
        this.userAbilities = builder.bUserAbilities;
        this.cluster = builder.bCluster;
        this.isMainLand = builder.isMainLand;
        this.signalServer = builder.bSignalServer;
        this.hardwareType = builder.bHardwareType;
    }

    protected GmCgDeviceInfo(Parcel parcel) {
        this.gameClientType = parcel.readInt();
        this.deviceID = parcel.readString();
        this.deviceName = parcel.readString();
        this.width = parcel.readInt();
        this.height = parcel.readInt();
        this.deviceArea = parcel.readString();
        this.deviceZone = parcel.readString();
        this.identity = parcel.readString();
        this.deviceTag = parcel.readString();
        this.controlkey = parcel.readString();
        this.webrtcUrl = parcel.readString();
        this.webrtcIP = parcel.createStringArrayList();
        this.cloudGameType = parcel.readInt();
        this.cloudGameScreenType = parcel.readInt();
        this.sessionStartTime = parcel.readLong();
        this.currentTime = parcel.readLong();
        this.bizInfo = parcel.readString();
        this.frameworkType = parcel.readInt();
        this.reallocated = parcel.readByte() != 0;
        this.bot = parcel.readByte() != 0;
        this.keepIdleTime = parcel.readInt();
        this.hasSaveArchive = parcel.readByte() != 0;
        this.hasAutoLogin = parcel.readByte() != 0;
        this.hasSetResolution = parcel.readByte() != 0;
        this.supportFreeFlow = parcel.readByte() != 0;
        this.gamePackageName = parcel.readString();
        this.allocateSource = parcel.readInt();
        this.isCreatedByOther = parcel.readByte() != 0;
        this.fps = parcel.readInt();
        this.identityProfType = parcel.readInt();
        this.curAllocQueueSize = parcel.readInt();
        this.curAllocQueueWaitSec = parcel.readInt();
        this.coldStartDevice = parcel.readString();
        this.deviceState = parcel.readString();
        this.startPercent = parcel.readDouble();
        this.userAbilities = parcel.createStringArrayList();
        this.cluster = parcel.readString();
        this.hardwareType = parcel.readString();
    }
}
