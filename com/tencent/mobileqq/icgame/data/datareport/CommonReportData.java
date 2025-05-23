package com.tencent.mobileqq.icgame.data.datareport;

import android.text.TextUtils;
import com.tencent.mobileqq.icgame.data.login.LoginInfo;
import com.tencent.mobileqq.qqlive.data.room.BaseRoomInfo;

/* compiled from: P */
/* loaded from: classes15.dex */
public class CommonReportData {
    private final String appId;
    private long enterRoomTime;
    private LoginInfo loginInfo;
    private BaseRoomInfo roomInfo;
    private String url = "";
    private long videoCodec = 0;
    private long videoTrans = 0;
    private String videoResolution = "";

    public CommonReportData(String str) {
        this.appId = str;
    }

    public String getAppId() {
        if (!TextUtils.isEmpty(this.appId)) {
            return this.appId;
        }
        return "";
    }

    public String getCommid() {
        return getAppId() + "_" + getRoomId() + "_" + this.enterRoomTime;
    }

    public String getExpgrpid() {
        return "";
    }

    public String getProgramId() {
        BaseRoomInfo baseRoomInfo = this.roomInfo;
        if (baseRoomInfo != null) {
            return baseRoomInfo.getProgramId();
        }
        return "";
    }

    public String getReportDevType() {
        return "Android";
    }

    public int getRoomId() {
        BaseRoomInfo baseRoomInfo = this.roomInfo;
        if (baseRoomInfo != null) {
            return (int) baseRoomInfo.getRoomId();
        }
        return -1;
    }

    public String getTestId() {
        return "";
    }

    public long getUid() {
        LoginInfo loginInfo = this.loginInfo;
        if (loginInfo == null) {
            return -1L;
        }
        return loginInfo.uid;
    }

    public String getUrl() {
        return this.url;
    }

    public long getVideoCodec() {
        return this.videoCodec;
    }

    public String getVideoResolution() {
        return this.videoResolution;
    }

    public long getVideoTrans() {
        return this.videoTrans;
    }

    public void reset() {
        this.loginInfo = null;
        this.roomInfo = null;
        this.enterRoomTime = 0L;
        this.url = "";
        this.videoCodec = 0L;
        this.videoTrans = 0L;
        this.videoResolution = "";
    }

    public void setEnterRoomTime(long j3) {
        this.enterRoomTime = j3;
    }

    public void setLoginInfo(LoginInfo loginInfo) {
        this.loginInfo = loginInfo;
    }

    public void setRoomInfo(BaseRoomInfo baseRoomInfo) {
        this.roomInfo = baseRoomInfo;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public void setVideoCodec(long j3) {
        this.videoCodec = j3;
    }

    public void setVideoResolution(String str) {
        this.videoResolution = str;
    }

    public void setVideoTrans(long j3) {
        this.videoTrans = j3;
    }
}
