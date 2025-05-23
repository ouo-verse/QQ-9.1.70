package com.tencent.gamematrix.gmcg.sdk.service;

import android.text.TextUtils;
import com.tencent.gamematrix.gmcg.api.GmCgDeviceAllocSource;
import com.tencent.gamematrix.gmcg.api.model.GmCgAllocSignalServer;
import com.tencent.gamematrix.gmcg.api.model.GmCgClusterLabel;
import com.tencent.gamematrix.gmcg.api.model.GmCgDeviceInfo;
import com.tencent.gamematrix.gmcg.base.utils.CGStringUtil;
import com.tencent.gamematrix.gmcg.sdk.config.CGUserDeviceInfo;
import java.util.List;

/* compiled from: P */
/* loaded from: classes6.dex */
public class CGAllocDeviceInfo {
    public String appid;
    public String area;
    public boolean autoLogin;
    public String bizInfo;
    public boolean bot;
    public String cluster;
    public List<GmCgClusterLabel> clusterLabel;
    public String controlkey;
    public long currentTime;
    public String deviceID;
    public int fps;
    public int frameworkType;
    public boolean freeFlow;
    public String hardwareType;
    public int height;
    public String identity;
    public boolean isCreatedByOther;
    public int keepIdleTime;
    public int keepaliveLeftTime;
    public int keepaliveState;
    public String name;
    public boolean reallocated;
    public String role;
    public boolean saveArchive;
    public long sessionStartTime;
    public boolean setResolution;
    public GmCgAllocSignalServer signalServer;
    public String tag;
    public int type;
    public List<String> userAbilities;
    public CGUserDeviceInfo userDeviceInfo;
    public List<String> webrtcIP;
    public String webrtcUrl;
    public int width;
    public int zone;

    public int getIdentityProfileType() {
        if (TextUtils.equals(this.role, "vip")) {
            return 1;
        }
        if (TextUtils.equals(this.role, "tiyan")) {
            return 2;
        }
        return 0;
    }

    public boolean isDeviceActive() {
        int i3 = this.keepaliveState;
        if (i3 == 1 || i3 == 2 || i3 == 3 || i3 == 4 || i3 == 5 || i3 == 6) {
            return true;
        }
        return false;
    }

    public boolean isDeviceNewAllocatedAndAlive() {
        int i3 = this.keepaliveState;
        if (i3 == 1 || i3 == 2) {
            return true;
        }
        return false;
    }

    public boolean isUserDeviceInfoValid() {
        if (this.userDeviceInfo != null) {
            return true;
        }
        return false;
    }

    public boolean isValid() {
        if (CGStringUtil.notEmpty(this.deviceID) && CGStringUtil.notEmpty(this.controlkey) && CGStringUtil.notEmpty(this.webrtcUrl)) {
            return true;
        }
        return false;
    }

    public GmCgDeviceInfo toGmCgDeviceInfo(@GmCgDeviceAllocSource int i3) {
        return new GmCgDeviceInfo.Builder().setDeviceID(this.deviceID).setDeviceName(this.name).setDeviceTag(this.tag).setArea(this.area).setIdentity(this.identity).setControlkey(this.controlkey).setWidth(this.width).setHeight(this.height).setWebrtcUrl(this.webrtcUrl).setWebrtcIP(this.webrtcIP).setSessionStartTime(this.sessionStartTime).setCurrentTime(this.currentTime).setBizInfo(this.bizInfo).setCloudGameType(this.type).setFrameworkType(this.frameworkType).setReallocated(this.reallocated).setBot(this.bot).setKeepIdleTime(this.keepIdleTime).setAllocateSource(i3).setHasSaveArchive(this.saveArchive).setHasAutoLogin(this.autoLogin).setHasSetResolution(this.setResolution).setSupportFreeFlow(this.freeFlow).setCreatedByOther(this.isCreatedByOther).setClusterLabel(this.clusterLabel).setFps(this.fps).setKeepAliveState(this.keepaliveState).setKeepAliveLeftTime(this.keepaliveLeftTime).setIdentityProfileType(getIdentityProfileType()).setCluster(this.cluster).setHardwareType(this.hardwareType).setSignalServer(this.signalServer).setHardwareType(this.hardwareType).build();
    }
}
