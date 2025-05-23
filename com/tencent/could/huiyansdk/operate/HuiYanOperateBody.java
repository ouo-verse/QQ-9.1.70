package com.tencent.could.huiyansdk.operate;

import com.google.gson.annotations.SerializedName;
import com.tencent.mobileqq.qcircle.api.utils.QCircleVideoDeviceInfoUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.zootopia.data.ZootopiaEnterParams;
import java.util.List;

/* compiled from: P */
/* loaded from: classes5.dex */
public class HuiYanOperateBody extends CloudOperateBody implements Cloneable {
    static IPatchRedirector $redirector_;

    @SerializedName(QCircleVideoDeviceInfoUtils.STRATEGY_DEVICE_MODEL)
    private String deviceModel;

    @SerializedName("DeviceToken")
    private String deviceToken;

    @SerializedName("ErrorCode")
    private String errorCode;

    @SerializedName("ErrorMessage")
    private String errorMessage;

    @SerializedName("NetWorkType")
    private String netWorkType;

    @SerializedName("OsVersion")
    private String osVersion;

    @SerializedName("PackageName")
    private String packageName;

    @SerializedName("PackageVersion")
    private String packageVersion;

    @SerializedName("Platform")
    private String platform;

    @SerializedName("SdkName")
    private String sdkName;

    @SerializedName("SdkVersion")
    private String sdkVersion;

    @SerializedName(ZootopiaEnterParams.KEY_TOKEN)
    private String token;

    @SerializedName("TuringVersion")
    private String turingVersion;

    @SerializedName("YouTuVersion")
    private String youTuVersion;

    public HuiYanOperateBody() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.errorCode = "";
        this.errorMessage = "";
        this.deviceModel = "";
        this.deviceToken = "";
        this.token = "";
        this.netWorkType = "";
        this.osVersion = "";
        this.sdkName = "";
        this.sdkVersion = "";
        this.packageName = "Android";
        this.packageVersion = "";
        this.platform = "Android";
        this.turingVersion = "";
        this.youTuVersion = "";
    }

    public Object clone() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            return iPatchRedirector.redirect((short) 32, (Object) this);
        }
        return super.clone();
    }

    public String getDeviceModel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.deviceModel;
    }

    public String getDeviceToken() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.deviceToken;
    }

    public String getErrorCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.errorCode;
    }

    public String getErrorMessage() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.errorMessage;
    }

    public String getNetWorkType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.netWorkType;
    }

    public String getOsVersion() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return this.osVersion;
    }

    public String getPackageName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (String) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        return this.packageName;
    }

    public String getPackageVersion() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (String) iPatchRedirector.redirect((short) 20, (Object) this);
        }
        return this.packageVersion;
    }

    public String getPlatform() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (String) iPatchRedirector.redirect((short) 22, (Object) this);
        }
        return this.platform;
    }

    public String getSdkName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (String) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return this.sdkName;
    }

    public String getSdkVersion() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (String) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        return this.sdkVersion;
    }

    public String getToken() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return (String) iPatchRedirector.redirect((short) 28, (Object) this);
        }
        return this.token;
    }

    public String getTuringVersion() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return (String) iPatchRedirector.redirect((short) 24, (Object) this);
        }
        return this.turingVersion;
    }

    public String getYouTuVersion() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return (String) iPatchRedirector.redirect((short) 26, (Object) this);
        }
        return this.youTuVersion;
    }

    @Override // com.tencent.could.huiyansdk.operate.CloudOperateBody
    public void initDate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this);
            return;
        }
        this.actions.add(new CloudOperateItem("StartHuiYanSdk"));
        this.actions.add(new CloudOperateItem("StartYTAuthUseTime"));
        this.actions.add(new CloudOperateItem("GetConfigUseTime"));
        this.actions.add(new CloudOperateItem("GetTuringTokenUseTime"));
        this.actions.add(new CloudOperateItem("GetLiveTypeDateUseTime"));
        this.actions.add(new CloudOperateItem("GetConfigDataUseTime"));
        this.actions.add(new CloudOperateItem("MakePackUseTime"));
        this.actions.add(new CloudOperateItem("GetCompareResultUseTime"));
        this.actions.add(new CloudOperateItem("LocalCheckUseTime"));
        this.actions.add(new CloudOperateItem("SendStreamCheckResultUseTime"));
        this.actions.add(new CloudOperateItem("GetLiveTypeData"));
        this.actions.add(new CloudOperateItem("GetConfigData"));
        this.actions.add(new CloudOperateItem("StartCamera"));
        this.actions.add(new CloudOperateItem("LocalCheck"));
        this.actions.add(new CloudOperateItem("LocalVideo"));
        this.actions.add(new CloudOperateItem("Compare"));
        this.actions.add(new CloudOperateItem("Crash"));
        this.actions.add(new CloudOperateItem("LocalVideoSize"));
        this.actions.add(new CloudOperateItem("LivenessPackSize"));
        this.actions.add(new CloudOperateItem("SendPackSize"));
        this.actions.add(new CloudOperateItem("StartTuringStreamCheck"));
        this.actions.add(new CloudOperateItem("SendStreamCheckResult"));
        this.actions.add(new CloudOperateItem("YTCatchError"));
        updateInfo("StartHuiYanSdk", 1, 1L, System.currentTimeMillis());
        updateInfo("Crash", 1, 0L, System.currentTimeMillis());
    }

    @Override // com.tencent.could.huiyansdk.operate.CloudOperateBody
    public void reset() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this);
            return;
        }
        this.errorCode = "";
        this.errorMessage = "";
        this.token = "";
        this.netWorkType = "";
        List<CloudOperateItem> list = this.actions;
        if (list != null) {
            list.clear();
            initDate();
        }
    }

    public void setDeviceModel(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
        } else {
            this.deviceModel = str;
        }
    }

    public void setDeviceToken(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) str);
        } else {
            this.deviceToken = str;
        }
    }

    public void setErrorCode(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        } else {
            this.errorCode = str;
        }
    }

    public void setErrorMessage(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        } else {
            this.errorMessage = str;
        }
    }

    public void setNetWorkType(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) str);
        } else {
            this.netWorkType = str;
        }
    }

    public void setOsVersion(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) str);
        } else {
            this.osVersion = str;
        }
    }

    public void setPackageName(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) str);
        } else {
            this.packageName = str;
        }
    }

    public void setPackageVersion(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) str);
        } else {
            this.packageVersion = str;
        }
    }

    public void setPlatform(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) str);
        } else {
            this.platform = str;
        }
    }

    public void setSdkName(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) str);
        } else {
            this.sdkName = str;
        }
    }

    public void setSdkVersion(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) str);
        } else {
            this.sdkVersion = str;
        }
    }

    public void setToken(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, (Object) str);
        } else {
            this.token = str;
        }
    }

    public void setTuringVersion(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, (Object) str);
        } else {
            this.turingVersion = str;
        }
    }

    public void setYouTuVersion(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, (Object) str);
        } else {
            this.youTuVersion = str;
        }
    }
}
