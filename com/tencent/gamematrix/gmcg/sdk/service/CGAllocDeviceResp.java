package com.tencent.gamematrix.gmcg.sdk.service;

import com.tencent.gamematrix.gmcg.api.GmCgDeviceAllocSource;
import com.tencent.gamematrix.gmcg.api.model.GmCgColdStartDeviceInfo;
import com.tencent.gamematrix.gmcg.api.model.GmCgDeviceInfo;
import com.tencent.gamematrix.gmcg.api.model.GmCgPlayQueueInfo;
import com.tencent.gamematrix.gmcg.base.log.CGLog;
import com.tencent.gamematrix.gmcg.base.utils.CGStringUtil;

/* compiled from: P */
/* loaded from: classes6.dex */
public class CGAllocDeviceResp {
    public String bizInfo;
    public String coldStartDevice;
    public long coldStartTime;
    public CGAllocDeviceInfo device;
    public boolean isMainland = false;

    /* renamed from: msg, reason: collision with root package name */
    public String f107887msg;
    public float percent;
    public int querygap;
    public CGAllocQueueInfo queueInfo;
    public int realWaitPos;
    public int ret;
    public String status;
    public String tag;
    public boolean tiyanVip;
    public boolean vip;
    public String waitid;
    public int waitnum;
    public int waitpos;
    public int waitsec;

    public boolean hasDevice() {
        if (this.device != null) {
            return true;
        }
        return false;
    }

    public boolean hasValidDevice() {
        CGAllocDeviceInfo cGAllocDeviceInfo = this.device;
        if (cGAllocDeviceInfo != null && cGAllocDeviceInfo.isValid()) {
            return true;
        }
        return false;
    }

    public boolean isNeedColdStart() {
        if (this.device == null && CGStringUtil.notEmpty(this.coldStartDevice)) {
            return true;
        }
        return false;
    }

    public GmCgColdStartDeviceInfo toGmCgColdStartDeviceInfo(String str) {
        if (isNeedColdStart()) {
            GmCgColdStartDeviceInfo gmCgColdStartDeviceInfo = new GmCgColdStartDeviceInfo();
            gmCgColdStartDeviceInfo.coldStartDevice = this.coldStartDevice;
            gmCgColdStartDeviceInfo.coldStartTime = this.coldStartTime;
            gmCgColdStartDeviceInfo.startPercent = this.percent;
            gmCgColdStartDeviceInfo.deviceState = this.status;
            if (CGStringUtil.notEmpty(this.bizInfo)) {
                str = this.bizInfo;
            }
            gmCgColdStartDeviceInfo.pBizInfo = str;
            return gmCgColdStartDeviceInfo;
        }
        return null;
    }

    public GmCgDeviceInfo toGmCgDeviceInfo(@GmCgDeviceAllocSource int i3) {
        String str;
        int i16;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("CGAllocDeviceResp: ");
        CGAllocDeviceInfo cGAllocDeviceInfo = this.device;
        if (cGAllocDeviceInfo != null) {
            str = cGAllocDeviceInfo.deviceID;
        } else {
            str = "null";
        }
        sb5.append(str);
        sb5.append(" vip:");
        sb5.append(this.vip);
        sb5.append(" tiyanVip:");
        sb5.append(this.tiyanVip);
        CGLog.i(sb5.toString());
        if (hasDevice()) {
            GmCgDeviceInfo.Builder identityProfileType = new GmCgDeviceInfo.Builder().setDeviceID(this.device.deviceID).setDeviceName(this.device.name).setDeviceTag(this.device.tag).setArea(this.device.area).setIdentity(this.device.identity).setControlkey(this.device.controlkey).setWidth(this.device.width).setHeight(this.device.height).setWebrtcUrl(this.device.webrtcUrl).setWebrtcIP(this.device.webrtcIP).setSessionStartTime(this.device.sessionStartTime).setCurrentTime(this.device.currentTime).setBizInfo(this.device.bizInfo).setCloudGameType(this.device.type).setFrameworkType(this.device.frameworkType).setReallocated(this.device.reallocated).setBot(this.device.bot).setKeepIdleTime(this.device.keepIdleTime).setAllocateSource(i3).setHasSaveArchive(this.device.saveArchive).setHasAutoLogin(this.device.autoLogin).setHasSetResolution(this.device.setResolution).setSupportFreeFlow(this.device.freeFlow).setCreatedByOther(this.device.isCreatedByOther).setClusterLabel(this.device.clusterLabel).setFps(this.device.fps).setKeepAliveState(this.device.keepaliveState).setKeepAliveLeftTime(this.device.keepaliveLeftTime).setIdentityProfileType(CGServiceUtil.getIdentityProfileType(this.vip, this.tiyanVip));
            CGAllocQueueInfo cGAllocQueueInfo = this.queueInfo;
            int i17 = 0;
            if (cGAllocQueueInfo != null) {
                i16 = cGAllocQueueInfo.getCurAllocQueueSize(true);
            } else {
                i16 = 0;
            }
            CGAllocQueueInfo cGAllocQueueInfo2 = this.queueInfo;
            if (cGAllocQueueInfo2 != null) {
                i17 = cGAllocQueueInfo2.getCurAllocQueueWaitSec(true);
            }
            return identityProfileType.setCurAllocQueueInfo(i16, i17).setUserAbilities(this.device.userAbilities).setCluster(this.device.cluster).setHardwareType(this.device.hardwareType).setMainLand(this.isMainland).setSignalServer(this.device.signalServer).setHardwareType(this.device.hardwareType).build();
        }
        return null;
    }

    public GmCgPlayQueueInfo toGmCgQueueInfo(String str) {
        int i3;
        if (hasDevice()) {
            return null;
        }
        GmCgPlayQueueInfo gmCgPlayQueueInfo = new GmCgPlayQueueInfo();
        gmCgPlayQueueInfo.pWaitNum = this.waitnum;
        gmCgPlayQueueInfo.pWaitPos = this.waitpos;
        gmCgPlayQueueInfo.pWaitSec = this.waitsec;
        int i16 = 0;
        gmCgPlayQueueInfo.pWaitCanceled = false;
        gmCgPlayQueueInfo.pIdentityProfType = CGServiceUtil.getIdentityProfileType(this.vip, this.tiyanVip);
        gmCgPlayQueueInfo.pRealWaitPos = this.realWaitPos;
        gmCgPlayQueueInfo.pWaitId = this.waitid;
        gmCgPlayQueueInfo.pGameTag = this.tag;
        if (CGStringUtil.notEmpty(this.bizInfo)) {
            str = this.bizInfo;
        }
        gmCgPlayQueueInfo.pBizInfo = str;
        CGAllocQueueInfo cGAllocQueueInfo = this.queueInfo;
        if (cGAllocQueueInfo != null) {
            i3 = cGAllocQueueInfo.getCurAllocQueueSize(false);
        } else {
            i3 = 0;
        }
        gmCgPlayQueueInfo.pCurAllocQueueSize = i3;
        CGAllocQueueInfo cGAllocQueueInfo2 = this.queueInfo;
        if (cGAllocQueueInfo2 != null) {
            i16 = cGAllocQueueInfo2.getCurAllocQueueWaitSec(false);
        }
        gmCgPlayQueueInfo.pCurAllocQueueWaitSec = i16;
        return gmCgPlayQueueInfo;
    }

    public String toString() {
        return "CGAllocDeviceResp{ret=" + this.ret + ", msg='" + this.f107887msg + "', device=" + this.device + ", coldStartDevice='" + this.coldStartDevice + "', waitid='" + this.waitid + "', waitnum=" + this.waitnum + ", waitpos=" + this.waitpos + ", waitsec=" + this.waitsec + ", querygap=" + this.querygap + ", vip=" + this.vip + ", tiyanVip=" + this.tiyanVip + ", realWaitPos=" + this.realWaitPos + ", tag='" + this.tag + "', bizInfo='" + this.bizInfo + "', queueInfo=" + this.queueInfo + ", status='" + this.status + "', coldStartTime=" + this.coldStartTime + "', percent=" + this.percent + '}';
    }
}
