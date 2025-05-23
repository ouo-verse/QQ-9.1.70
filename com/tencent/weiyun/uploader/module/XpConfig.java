package com.tencent.weiyun.uploader.module;

import android.os.Environment;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.weiyun.uploader.IConfig;

/* compiled from: P */
/* loaded from: classes27.dex */
public class XpConfig {
    static IPatchRedirector $redirector_ = null;
    public static final String DEFAULT_QUA = "";
    public static final String DEFAULT_REFER = "tencent";
    public static final int DEFAULT_REPORT_PERCENT = 5;
    public static final String DEFAULT_TERMINAL = "android";
    public static final String DEFAULT_USER_AGENT = "android-tencent";
    public static final String DEFAULT_VERSION = "1.0";
    private static IConfig sRealConfig;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(13478);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            sRealConfig = null;
        }
    }

    public XpConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static String getCachePath() {
        IConfig iConfig = sRealConfig;
        if (iConfig != null) {
            return iConfig.getCachePath();
        }
        return Environment.getDataDirectory().getAbsolutePath();
    }

    public static String getCurrentUin() {
        IConfig iConfig = sRealConfig;
        if (iConfig != null) {
            return String.valueOf(iConfig.getCurrentUin());
        }
        return "0";
    }

    public static int getIsp() {
        IConfig iConfig = sRealConfig;
        if (iConfig != null) {
            return iConfig.getIsp();
        }
        return 0;
    }

    public static String getQUA() {
        IConfig iConfig = sRealConfig;
        if (iConfig != null) {
            return iConfig.getQUA();
        }
        return "";
    }

    public static String getRefer() {
        IConfig iConfig = sRealConfig;
        if (iConfig != null) {
            return iConfig.getRefer();
        }
        return "tencent";
    }

    public static int getReportPercent() {
        IConfig iConfig = sRealConfig;
        if (iConfig != null) {
            return iConfig.getReportPercent();
        }
        return 5;
    }

    public static String getTerminal() {
        IConfig iConfig = sRealConfig;
        if (iConfig != null) {
            return iConfig.getTerminal();
        }
        return "android";
    }

    public static String getUserAgent() {
        IConfig iConfig = sRealConfig;
        if (iConfig != null) {
            return iConfig.getUserAgent();
        }
        return "android-tencent";
    }

    public static String getVersion() {
        IConfig iConfig = sRealConfig;
        if (iConfig != null) {
            return iConfig.getVersion();
        }
        return "1.0";
    }

    public static boolean isRdm() {
        IConfig iConfig = sRealConfig;
        if (iConfig != null && iConfig.isRdm()) {
            return true;
        }
        return false;
    }

    public static void setConfig(IConfig iConfig) {
        sRealConfig = iConfig;
    }
}
