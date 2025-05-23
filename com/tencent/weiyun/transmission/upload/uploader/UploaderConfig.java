package com.tencent.weiyun.transmission.upload.uploader;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.weiyun.transmission.WeiyunTransmissionGlobal;
import com.tencent.weiyun.uploader.IConfig;
import java.io.File;

/* compiled from: P */
/* loaded from: classes27.dex */
public class UploaderConfig implements IConfig {
    static IPatchRedirector $redirector_ = null;
    public static final String APP_NAME_WITH_PLATFORM = "Android-Weiyun-Lite";

    public UploaderConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.weiyun.uploader.IConfig
    public String getCachePath() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        File externalCacheDir = WeiyunTransmissionGlobal.getInstance().getContext().getExternalCacheDir();
        if (externalCacheDir == null) {
            externalCacheDir = WeiyunTransmissionGlobal.getInstance().getContext().getCacheDir();
        }
        return externalCacheDir.getAbsolutePath();
    }

    @Override // com.tencent.weiyun.uploader.IConfig
    public long getCurrentUin() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Long) iPatchRedirector.redirect((short) 8, (Object) this)).longValue();
        }
        return WeiyunTransmissionGlobal.getInstance().getHostInterface().getCurrentUin();
    }

    @Override // com.tencent.weiyun.uploader.IConfig
    public int getIsp() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        return WeiyunTransmissionGlobal.getInstance().getHostInterface().getCurrentIsp();
    }

    @Override // com.tencent.weiyun.uploader.IConfig
    public String getQUA() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return WeiyunTransmissionGlobal.getInstance().getAppInfo().qua;
    }

    @Override // com.tencent.weiyun.uploader.IConfig
    public String getRefer() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return null;
    }

    @Override // com.tencent.weiyun.uploader.IConfig
    public int getReportPercent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        return 0;
    }

    @Override // com.tencent.weiyun.uploader.IConfig
    public String getTerminal() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return APP_NAME_WITH_PLATFORM;
    }

    @Override // com.tencent.weiyun.uploader.IConfig
    public String getUserAgent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return null;
    }

    @Override // com.tencent.weiyun.uploader.IConfig
    public String getVersion() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        WeiyunTransmissionGlobal.AppInfo appInfo = WeiyunTransmissionGlobal.getInstance().getAppInfo();
        return appInfo.versionName + '.' + appInfo.versionCode;
    }

    @Override // com.tencent.weiyun.uploader.IConfig
    public boolean isRdm() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
        }
        return false;
    }
}
