package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProUserAVRspInfo {
    public GProAVDevOptInfo devOpt;
    public ArrayList<GProAVRoomCtrlOptInfo> roomDevOpts;
    public GProSecurityResult secResult;
    public String tipMsg;
    public String trtcKey;
    public int userState;

    public GProUserAVRspInfo() {
        this.tipMsg = "";
        this.secResult = new GProSecurityResult();
        this.trtcKey = "";
        this.devOpt = new GProAVDevOptInfo();
        this.roomDevOpts = new ArrayList<>();
    }

    public GProAVDevOptInfo getDevOpt() {
        return this.devOpt;
    }

    public ArrayList<GProAVRoomCtrlOptInfo> getRoomDevOpts() {
        return this.roomDevOpts;
    }

    public GProSecurityResult getSecResult() {
        return this.secResult;
    }

    public String getTipMsg() {
        return this.tipMsg;
    }

    public String getTrtcKey() {
        return this.trtcKey;
    }

    public int getUserState() {
        return this.userState;
    }

    public String toString() {
        return "GProUserAVRspInfo{tipMsg=" + this.tipMsg + ",secResult=" + this.secResult + ",trtcKey=" + this.trtcKey + ",userState=" + this.userState + ",devOpt=" + this.devOpt + ",roomDevOpts=" + this.roomDevOpts + ",}";
    }

    public GProUserAVRspInfo(String str, GProSecurityResult gProSecurityResult, String str2, int i3, GProAVDevOptInfo gProAVDevOptInfo, ArrayList<GProAVRoomCtrlOptInfo> arrayList) {
        this.tipMsg = "";
        this.secResult = new GProSecurityResult();
        this.trtcKey = "";
        this.devOpt = new GProAVDevOptInfo();
        new ArrayList();
        this.tipMsg = str;
        this.secResult = gProSecurityResult;
        this.trtcKey = str2;
        this.userState = i3;
        this.devOpt = gProAVDevOptInfo;
        this.roomDevOpts = arrayList;
    }
}
