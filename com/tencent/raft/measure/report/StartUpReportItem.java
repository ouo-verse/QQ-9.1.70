package com.tencent.raft.measure.report;

import androidx.annotation.NonNull;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.raft.measure.BuildConfig;
import com.tencent.raft.measure.config.RAFTComConfig;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/* compiled from: P */
/* loaded from: classes25.dex */
public final class StartUpReportItem {
    static IPatchRedirector $redirector_;
    private final String appId;
    private final String appName;
    private final String appVersion;
    private final String comName;
    private final String comVersion;
    private final String samplingRate;

    public StartUpReportItem(@NonNull RAFTComConfig rAFTComConfig, @NonNull AppInfo appInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) rAFTComConfig, (Object) appInfo);
            return;
        }
        this.samplingRate = String.valueOf(5);
        this.comName = rAFTComConfig.getComName();
        this.comVersion = rAFTComConfig.getComVersion();
        this.appId = appInfo.getAppId();
        this.appName = appInfo.getAppName();
        this.appVersion = appInfo.getAppVersion();
    }

    public String getAppId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.appId;
    }

    public String getAppName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.appName;
    }

    public String getAppVersion() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.appVersion;
    }

    public String getComName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.comName;
    }

    public String getComVersion() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.comVersion;
    }

    public String getSamplingRate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.samplingRate;
    }

    public String toUrlParams() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        StringBuilder sb5 = new StringBuilder();
        try {
            sb5.append("com_name=");
            sb5.append(URLEncoder.encode(this.comName, "UTF-8"));
            sb5.append(ContainerUtils.FIELD_DELIMITER);
            sb5.append("com_ver=");
            sb5.append(URLEncoder.encode(this.comVersion, "UTF-8"));
            sb5.append(ContainerUtils.FIELD_DELIMITER);
            sb5.append("rate=");
            sb5.append(URLEncoder.encode(this.samplingRate, "UTF-8"));
            sb5.append(ContainerUtils.FIELD_DELIMITER);
            sb5.append("sli_type=");
            sb5.append(URLEncoder.encode("launch", "UTF-8"));
            sb5.append(ContainerUtils.FIELD_DELIMITER);
            sb5.append("app_id=");
            sb5.append(URLEncoder.encode(this.appId, "UTF-8"));
            sb5.append(ContainerUtils.FIELD_DELIMITER);
            sb5.append("app_name=");
            sb5.append(URLEncoder.encode(this.appName, "UTF-8"));
            sb5.append(ContainerUtils.FIELD_DELIMITER);
            sb5.append("app_ver=");
            sb5.append(URLEncoder.encode(this.appVersion, "UTF-8"));
            sb5.append(ContainerUtils.FIELD_DELIMITER);
            sb5.append("sdk_ver=");
            sb5.append(URLEncoder.encode(BuildConfig.RAFT_VERSION, "UTF-8"));
            sb5.append(ContainerUtils.FIELD_DELIMITER);
            sb5.append("platform=Android");
        } catch (UnsupportedEncodingException e16) {
            e16.printStackTrace();
        }
        return sb5.toString();
    }
}
