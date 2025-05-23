package com.tencent.mobileqq.qqlive.data.datareport;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.data.login.LoginInfo;
import com.tencent.mobileqq.qqlive.data.room.BaseRoomInfo;

/* compiled from: P */
/* loaded from: classes17.dex */
public class CommonReportData {
    static IPatchRedirector $redirector_;
    private final String appId;
    private long enterRoomTime;
    private LoginInfo loginInfo;
    private BaseRoomInfo roomInfo;
    private String url;
    private long videoCodec;
    private String videoResolution;
    private long videoTrans;

    public CommonReportData(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
            return;
        }
        this.url = "";
        this.videoCodec = 0L;
        this.videoTrans = 0L;
        this.videoResolution = "";
        this.appId = str;
    }

    public String getAppId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        if (!TextUtils.isEmpty(this.appId)) {
            return this.appId;
        }
        return "";
    }

    public String getCommid() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return getAppId() + "_" + getRoomId() + "_" + this.enterRoomTime;
    }

    public String getExpgrpid() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return "";
    }

    public String getProgramId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        BaseRoomInfo baseRoomInfo = this.roomInfo;
        if (baseRoomInfo != null) {
            return baseRoomInfo.getProgramId();
        }
        return "";
    }

    public String getReportDevType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return "Android";
    }

    public int getRoomId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        BaseRoomInfo baseRoomInfo = this.roomInfo;
        if (baseRoomInfo != null) {
            return (int) baseRoomInfo.getRoomId();
        }
        return -1;
    }

    public String getTestId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return "";
    }

    public long getUid() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Long) iPatchRedirector.redirect((short) 9, (Object) this)).longValue();
        }
        LoginInfo loginInfo = this.loginInfo;
        if (loginInfo == null) {
            return -1L;
        }
        return loginInfo.uid;
    }

    public String getUrl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (String) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return this.url;
    }

    public long getVideoCodec() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Long) iPatchRedirector.redirect((short) 15, (Object) this)).longValue();
        }
        return this.videoCodec;
    }

    public String getVideoResolution() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (String) iPatchRedirector.redirect((short) 19, (Object) this);
        }
        return this.videoResolution;
    }

    public long getVideoTrans() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Long) iPatchRedirector.redirect((short) 17, (Object) this)).longValue();
        }
        return this.videoTrans;
    }

    public void reset() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this);
            return;
        }
        this.loginInfo = null;
        this.roomInfo = null;
        this.enterRoomTime = 0L;
        this.url = "";
        this.videoCodec = 0L;
        this.videoTrans = 0L;
        this.videoResolution = "";
    }

    public void setEnterRoomTime(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, j3);
        } else {
            this.enterRoomTime = j3;
        }
    }

    public void setLoginInfo(LoginInfo loginInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) loginInfo);
        } else {
            this.loginInfo = loginInfo;
        }
    }

    public void setRoomInfo(BaseRoomInfo baseRoomInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) baseRoomInfo);
        } else {
            this.roomInfo = baseRoomInfo;
        }
    }

    public void setUrl(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) str);
        } else {
            this.url = str;
        }
    }

    public void setVideoCodec(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, j3);
        } else {
            this.videoCodec = j3;
        }
    }

    public void setVideoResolution(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) str);
        } else {
            this.videoResolution = str;
        }
    }

    public void setVideoTrans(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, j3);
        } else {
            this.videoTrans = j3;
        }
    }
}
