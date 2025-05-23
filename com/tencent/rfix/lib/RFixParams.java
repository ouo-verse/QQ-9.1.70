package com.tencent.rfix.lib;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.Keep;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.rfix.loader.log.RFixLog;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Keep
/* loaded from: classes25.dex */
public class RFixParams {
    static IPatchRedirector $redirector_ = null;
    private static final int MAX_CUSTOM_PROPERTIES = 5;
    private static final String TAG = "RFix.RFixParams";
    private final String appId;
    private final String appKey;
    private String appVersion;
    private boolean autoRequestEnable;
    private final Map<String, String> customProperties;
    private String deviceId;
    private String deviceManufacturer;
    private String deviceModel;
    private String dummyAppVersion;
    private String dummyUserId;
    private final boolean enable;
    private boolean initMMKVInternal;
    private boolean mainVerifyEnable;
    private String userId;

    public RFixParams(String str, String str2) {
        this(true, str, str2);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, (Object) str2);
    }

    public String getAppId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.appId;
    }

    public String getAppKey() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.appKey;
    }

    public String getAppVersion(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (String) iPatchRedirector.redirect((short) 13, (Object) this, (Object) context);
        }
        if (!TextUtils.isEmpty(this.dummyAppVersion)) {
            return this.dummyAppVersion;
        }
        return getRealAppVersion(context);
    }

    public boolean getAutoRequestEnable() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        return this.autoRequestEnable;
    }

    public Set<String> getCustomProperties() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return (Set) iPatchRedirector.redirect((short) 24, (Object) this);
        }
        return this.customProperties.keySet();
    }

    public String getCustomProperty(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return (String) iPatchRedirector.redirect((short) 25, (Object) this, (Object) str);
        }
        return this.customProperties.get(str);
    }

    public String getDeviceId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (String) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        return this.deviceId;
    }

    public String getDeviceManufacturer() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (String) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        return this.deviceManufacturer;
    }

    public String getDeviceModel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (String) iPatchRedirector.redirect((short) 20, (Object) this);
        }
        return this.deviceModel;
    }

    public boolean getInitMMKVInternal() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        return this.initMMKVInternal;
    }

    public boolean getMainVerifyEnable() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
        }
        return this.mainVerifyEnable;
    }

    public String getRealAppVersion(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (String) iPatchRedirector.redirect((short) 14, (Object) this, (Object) context);
        }
        if (!TextUtils.isEmpty(this.appVersion)) {
            return this.appVersion;
        }
        try {
            this.appVersion = InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), context.getPackageName(), 0).versionName;
        } catch (Exception unused) {
        }
        return this.appVersion;
    }

    public String getUserId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (String) iPatchRedirector.redirect((short) 22, (Object) this);
        }
        if (!TextUtils.isEmpty(this.dummyUserId)) {
            return this.dummyUserId;
        }
        return this.userId;
    }

    public boolean isEnable() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return this.enable;
    }

    public RFixParams setAppVersion(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (RFixParams) iPatchRedirector.redirect((short) 12, (Object) this, (Object) str);
        }
        this.appVersion = str;
        return this;
    }

    public RFixParams setAutoRequestEnable(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (RFixParams) iPatchRedirector.redirect((short) 6, (Object) this, z16);
        }
        this.autoRequestEnable = z16;
        return this;
    }

    public RFixParams setCustomProperty(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (RFixParams) iPatchRedirector.redirect((short) 23, (Object) this, (Object) str, (Object) str2);
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (this.customProperties.keySet().size() >= 5 && !this.customProperties.containsKey(str)) {
                RFixLog.e(TAG, "setCustomProperty custom property reach max support count! new property: '" + str + "' not accept.");
                return this;
            }
            this.customProperties.put(str, str2);
            return this;
        }
        RFixLog.e(TAG, "setCustomProperty custom property not support empty string!");
        return this;
    }

    public RFixParams setDeviceId(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (RFixParams) iPatchRedirector.redirect((short) 15, (Object) this, (Object) str);
        }
        this.deviceId = str;
        return this;
    }

    public RFixParams setDeviceManufacturer(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (RFixParams) iPatchRedirector.redirect((short) 17, (Object) this, (Object) str);
        }
        this.deviceManufacturer = str;
        return this;
    }

    public RFixParams setDeviceModel(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (RFixParams) iPatchRedirector.redirect((short) 19, (Object) this, (Object) str);
        }
        this.deviceModel = str;
        return this;
    }

    public RFixParams setDummyAppVersion(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return (RFixParams) iPatchRedirector.redirect((short) 26, (Object) this, (Object) str);
        }
        this.dummyAppVersion = str;
        return this;
    }

    public RFixParams setDummyUserId(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return (RFixParams) iPatchRedirector.redirect((short) 27, (Object) this, (Object) str);
        }
        this.dummyUserId = str;
        return this;
    }

    public RFixParams setInitMMKVInternal(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (RFixParams) iPatchRedirector.redirect((short) 8, (Object) this, z16);
        }
        this.initMMKVInternal = z16;
        return this;
    }

    public RFixParams setMainVerifyEnable(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (RFixParams) iPatchRedirector.redirect((short) 10, (Object) this, z16);
        }
        this.mainVerifyEnable = z16;
        return this;
    }

    public RFixParams setUserId(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (RFixParams) iPatchRedirector.redirect((short) 21, (Object) this, (Object) str);
        }
        this.userId = str;
        return this;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return (String) iPatchRedirector.redirect((short) 28, (Object) this);
        }
        return "RFixParams{enable=" + this.enable + ", appId='" + this.appId + "', appKey='" + this.appKey + "', appVersion='" + this.appVersion + "', autoRequestEnable=" + this.autoRequestEnable + ", initMMKVInternal=" + this.initMMKVInternal + ", deviceId='" + this.deviceId + "', deviceManufacturer='" + this.deviceManufacturer + "', deviceModel='" + this.deviceModel + "', userId='" + this.userId + "', customProperties=" + this.customProperties + ", dummyAppVersion='" + this.dummyAppVersion + "', dummyUserId='" + this.dummyUserId + "'}";
    }

    public RFixParams(boolean z16, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), str, str2);
            return;
        }
        this.enable = z16;
        this.appId = str;
        this.appKey = str2;
        this.autoRequestEnable = true;
        this.initMMKVInternal = true;
        this.mainVerifyEnable = true;
        this.customProperties = new HashMap();
    }
}
