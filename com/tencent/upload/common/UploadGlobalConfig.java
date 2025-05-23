package com.tencent.upload.common;

import SLICE_UPLOAD.stEnvironment;
import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.upload.network.base.UploadSoDefaultLoader;
import com.tencent.upload.report.Report;
import com.tencent.upload.report.UploadQualityReportBuilder;
import com.tencent.upload.uinterface.IUploadConfig;
import com.tencent.upload.uinterface.IUploadEnv;
import com.tencent.upload.uinterface.IUploadLog;
import com.tencent.upload.uinterface.IUploadReport;
import com.tencent.upload.uinterface.IUploadSoLoader;
import com.tencent.upload.uinterface.TaskTypeConfig;
import java.io.File;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class UploadGlobalConfig {
    static IPatchRedirector $redirector_ = null;
    private static final String KEEPIMG_TEST_FILE = "/sdcard/keep_image_tmp_file_206cce3cffb78a4a87f85bb0ad467288.txt";
    private static final String TAG = "UploadGlobalConfig";
    private static IUploadConfig sConfig;
    private static Context sContext;
    private static boolean sKeepImageTmpFile;
    private static IUploadEnv sUploadEnv;
    private static IUploadLog sUploadLog;
    private static IUploadReport sUploadReport;
    private static IUploadSoLoader sUploadSoLoader;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(10086);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            sKeepImageTmpFile = false;
        }
    }

    UploadGlobalConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static final IUploadConfig getConfig() {
        return sConfig;
    }

    public static final Context getContext() {
        return sContext;
    }

    public static stEnvironment getEnv() {
        stEnvironment stenvironment = new stEnvironment();
        stenvironment.qua = sConfig.getQUA3();
        stenvironment.net = sUploadEnv.getCurrentNetworkCategory();
        stenvironment.operators = sUploadEnv.getProviderName();
        stenvironment.deviceInfo = sConfig.getDeviceInfo();
        stenvironment.source = 1;
        return stenvironment;
    }

    public static final IUploadEnv getUploadEnv() {
        return sUploadEnv;
    }

    public static final IUploadLog getUploadLog() {
        return sUploadLog;
    }

    public static IUploadReport getUploadReport() {
        if (sUploadReport == null) {
            sUploadReport = new IUploadReport() { // from class: com.tencent.upload.common.UploadGlobalConfig.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this);
                    }
                }

                @Override // com.tencent.upload.uinterface.IUploadReport
                public void batchComplete() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                        iPatchRedirector.redirect((short) 3, (Object) this);
                    }
                }

                @Override // com.tencent.upload.uinterface.IUploadReport
                public void onSessionReport(UploadQualityReportBuilder uploadQualityReportBuilder, TaskTypeConfig taskTypeConfig) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                        iPatchRedirector.redirect((short) 5, (Object) this, (Object) uploadQualityReportBuilder, (Object) taskTypeConfig);
                    }
                }

                @Override // com.tencent.upload.uinterface.IUploadReport
                public void onUploadReport(Report report) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) report);
                    }
                }

                @Override // com.tencent.upload.uinterface.IUploadReport
                public void openSessionReport(int i3, String str, String str2, int i16) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                        iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), str, str2, Integer.valueOf(i16));
                    }
                }
            };
        }
        return sUploadReport;
    }

    public static final IUploadSoLoader getUploadSoLoader() {
        if (sUploadSoLoader == null) {
            sUploadSoLoader = new UploadSoDefaultLoader();
        }
        return sUploadSoLoader;
    }

    public static void init(Context context, IUploadConfig iUploadConfig, IUploadLog iUploadLog, IUploadReport iUploadReport, IUploadEnv iUploadEnv, IUploadSoLoader iUploadSoLoader) {
        if (context != null && iUploadConfig != null && iUploadEnv != null && iUploadSoLoader != null) {
            sContext = context;
            sConfig = iUploadConfig;
            sUploadReport = iUploadReport;
            sUploadLog = iUploadLog;
            sUploadEnv = iUploadEnv;
            sUploadSoLoader = iUploadSoLoader;
            return;
        }
        throw new RuntimeException("upload\u7ec4\u4ef6init\u521d\u59cb\u5316\u53c2\u6570\u9519\u8bef\uff01");
    }

    public static void keepImageTmpFile(boolean z16) {
        sKeepImageTmpFile = z16;
    }

    public static boolean needKeepImageTmpFile() {
        if (getConfig() != null && !getConfig().isReleaseMode() && new File(KEEPIMG_TEST_FILE).exists()) {
            return true;
        }
        return sKeepImageTmpFile;
    }
}
