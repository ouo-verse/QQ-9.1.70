package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProEnterAudioLiveChannelRsp implements Serializable {
    public String authMeta;
    public GProAVChannelConfig avChannelConfig;
    public boolean enableStream;
    public int globalMutedFlag;
    public GProEnterChannelPermission liveChannelPermission;
    public long noStreamDisconnectTrtcSecond;
    public GProEnterAVChannelPermissionInfo permissionInfo;
    public String privateMapKey;
    public String roomSessionId;
    public int sdkAppId;
    long serialVersionUID;
    public String showTips;
    public long sigExpiresSecond;
    public ArrayList<GProStreamInfo> streamInfoList;
    public String trtcUserSign;
    public ArrayList<GProUserBarNodePermission> userBarNodePermission;
    public int userTRTC;
    public long userTinyId;

    public GProEnterAudioLiveChannelRsp() {
        this.serialVersionUID = 1L;
        this.authMeta = "";
        this.trtcUserSign = "";
        this.privateMapKey = "";
        this.streamInfoList = new ArrayList<>();
        this.showTips = "";
        this.avChannelConfig = new GProAVChannelConfig();
        this.userBarNodePermission = new ArrayList<>();
        this.roomSessionId = "";
        this.permissionInfo = new GProEnterAVChannelPermissionInfo();
        this.liveChannelPermission = new GProEnterChannelPermission();
    }

    public String getAuthMeta() {
        return this.authMeta;
    }

    public GProAVChannelConfig getAvChannelConfig() {
        return this.avChannelConfig;
    }

    public boolean getEnableStream() {
        return this.enableStream;
    }

    public int getGlobalMutedFlag() {
        return this.globalMutedFlag;
    }

    public GProEnterChannelPermission getLiveChannelPermission() {
        return this.liveChannelPermission;
    }

    public long getNoStreamDisconnectTrtcSecond() {
        return this.noStreamDisconnectTrtcSecond;
    }

    public GProEnterAVChannelPermissionInfo getPermissionInfo() {
        return this.permissionInfo;
    }

    public String getPrivateMapKey() {
        return this.privateMapKey;
    }

    public String getRoomSessionId() {
        return this.roomSessionId;
    }

    public int getSdkAppId() {
        return this.sdkAppId;
    }

    public String getShowTips() {
        return this.showTips;
    }

    public long getSigExpiresSecond() {
        return this.sigExpiresSecond;
    }

    public ArrayList<GProStreamInfo> getStreamInfoList() {
        return this.streamInfoList;
    }

    public String getTrtcUserSign() {
        return this.trtcUserSign;
    }

    public ArrayList<GProUserBarNodePermission> getUserBarNodePermission() {
        return this.userBarNodePermission;
    }

    public int getUserTRTC() {
        return this.userTRTC;
    }

    public long getUserTinyId() {
        return this.userTinyId;
    }

    public String toString() {
        return "GProEnterAudioLiveChannelRsp{authMeta=" + this.authMeta + ",enableStream=" + this.enableStream + ",userTRTC=" + this.userTRTC + ",sdkAppId=" + this.sdkAppId + ",trtcUserSign=" + this.trtcUserSign + ",privateMapKey=" + this.privateMapKey + ",streamInfoList=" + this.streamInfoList + ",showTips=" + this.showTips + ",avChannelConfig=" + this.avChannelConfig + ",userBarNodePermission=" + this.userBarNodePermission + ",roomSessionId=" + this.roomSessionId + ",globalMutedFlag=" + this.globalMutedFlag + ",permissionInfo=" + this.permissionInfo + ",liveChannelPermission=" + this.liveChannelPermission + ",userTinyId=" + this.userTinyId + ",sigExpiresSecond=" + this.sigExpiresSecond + ",noStreamDisconnectTrtcSecond=" + this.noStreamDisconnectTrtcSecond + ",}";
    }

    public GProEnterAudioLiveChannelRsp(String str, boolean z16, int i3, int i16, String str2, String str3, ArrayList<GProStreamInfo> arrayList, String str4, GProAVChannelConfig gProAVChannelConfig, ArrayList<GProUserBarNodePermission> arrayList2, String str5, int i17, GProEnterAVChannelPermissionInfo gProEnterAVChannelPermissionInfo, GProEnterChannelPermission gProEnterChannelPermission, long j3, long j16, long j17) {
        this.serialVersionUID = 1L;
        this.authMeta = "";
        this.trtcUserSign = "";
        this.privateMapKey = "";
        this.streamInfoList = new ArrayList<>();
        this.showTips = "";
        this.avChannelConfig = new GProAVChannelConfig();
        this.userBarNodePermission = new ArrayList<>();
        this.roomSessionId = "";
        this.permissionInfo = new GProEnterAVChannelPermissionInfo();
        new GProEnterChannelPermission();
        this.authMeta = str;
        this.enableStream = z16;
        this.userTRTC = i3;
        this.sdkAppId = i16;
        this.trtcUserSign = str2;
        this.privateMapKey = str3;
        this.streamInfoList = arrayList;
        this.showTips = str4;
        this.avChannelConfig = gProAVChannelConfig;
        this.userBarNodePermission = arrayList2;
        this.roomSessionId = str5;
        this.globalMutedFlag = i17;
        this.permissionInfo = gProEnterAVChannelPermissionInfo;
        this.liveChannelPermission = gProEnterChannelPermission;
        this.userTinyId = j3;
        this.sigExpiresSecond = j16;
        this.noStreamDisconnectTrtcSecond = j17;
    }
}
