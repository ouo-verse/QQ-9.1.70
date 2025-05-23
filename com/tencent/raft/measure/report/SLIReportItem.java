package com.tencent.raft.measure.report;

import androidx.annotation.NonNull;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.raft.measure.BuildConfig;
import com.tencent.raft.measure.config.RAFTComConfig;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes25.dex */
public final class SLIReportItem {
    static IPatchRedirector $redirector_;
    private String appId;
    private String appName;
    private String appVersion;
    private final String comName;
    private final String comVersion;
    private final String sliName;
    private final String sliType;
    private final String sliValue;

    public SLIReportItem(@NonNull RAFTComConfig rAFTComConfig, @NotNull String str, @NotNull String str2, @NotNull String str3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, rAFTComConfig, str, str2, str3);
            return;
        }
        this.sliName = str;
        this.sliValue = str2;
        this.sliType = str3;
        this.comName = rAFTComConfig.getComName();
        this.comVersion = rAFTComConfig.getComVersion();
    }

    public String getAppId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.appId;
    }

    public String getAppName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.appName;
    }

    public String getAppVersion() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.appVersion;
    }

    public String getComName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.comName;
    }

    public String getComVersion() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.comVersion;
    }

    public String getSliName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.sliName;
    }

    public String getSliType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.sliType;
    }

    public String getSliValue() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.sliValue;
    }

    public void setAppInfo(@NonNull AppInfo appInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) appInfo);
            return;
        }
        this.appId = appInfo.getAppId();
        this.appName = appInfo.getAppName();
        this.appVersion = appInfo.getAppVersion();
    }

    public String toUrlParams() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        StringBuilder sb5 = new StringBuilder();
        try {
            sb5.append("com_name=");
            sb5.append(URLEncoder.encode(this.comName, "UTF-8"));
            sb5.append(ContainerUtils.FIELD_DELIMITER);
            sb5.append("com_ver=");
            sb5.append(URLEncoder.encode(this.comVersion, "UTF-8"));
            sb5.append(ContainerUtils.FIELD_DELIMITER);
            sb5.append("sli_name=");
            sb5.append(URLEncoder.encode(this.sliName, "UTF-8"));
            sb5.append(ContainerUtils.FIELD_DELIMITER);
            sb5.append("sli_value=");
            sb5.append(URLEncoder.encode(this.sliValue, "UTF-8"));
            sb5.append(ContainerUtils.FIELD_DELIMITER);
            sb5.append("sli_type=");
            sb5.append(URLEncoder.encode(this.sliType, "UTF-8"));
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
