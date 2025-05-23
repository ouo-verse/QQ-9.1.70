package com.tencent.mobileqq.msf.core.net.patch;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.sdk.report.StatReportManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QzoneIPCModule;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

/* loaded from: classes15.dex */
public class PatchReporter {
    static IPatchRedirector $redirector_ = null;
    public static final String ACTION_PATCH_CHECK = "actPatchCheck";
    public static final String ACTION_PATCH_CONFIG = "actPatchConfig";
    public static final String ACTION_PATCH_DOWNLOAD = "actPatchDownload";
    public static final String ACTION_PATCH_DOWN_MSF = "actPatchDownMsf";
    public static final String ACTION_PATCH_INSTALL = "actPatchInstall";
    public static final String ACTION_PATCH_LOAD = "actPatchLoad";
    public static final String ACTION_PATCH_RESOLVE = "actPatchResolve";
    public static final String ACTION_PATCH_UNZIP = "actPatchUnzip";
    public static final int CODE_CHECK_EXCEPTION = 302;
    public static final int CODE_CHECK_FAIL = 301;
    public static final int CODE_CHECK_SUCCESS = 300;
    public static final int CODE_CONFIG_EXCEPTION = 102;
    public static final int CODE_CONFIG_FAIL = 101;
    public static final int CODE_CONFIG_SUCCESS = 100;
    public static final int CODE_DOWNLOAD_EXCEPTION = 202;
    public static final int CODE_DOWNLOAD_FAIL = 201;
    public static final int CODE_DOWNLOAD_SUCCESS = 200;
    public static final int CODE_INSTALL_EXCEPTION = 502;
    public static final int CODE_INSTALL_FAIL = 501;
    public static final int CODE_INSTALL_START_FAIL = 503;
    public static final int CODE_INSTALL_SUCCESS = 500;
    public static final int CODE_LOAD_FAIL = 401;
    public static final int CODE_LOAD_SUCCESS = 400;
    public static final int CODE_RELAX_FAIL = 801;
    public static final int CODE_RELAX_INIT_FAIL = 803;
    public static final int CODE_RELAX_INJECT_FAILED = 807;
    public static final int CODE_RELAX_IO_EXCEPTION = 802;
    public static final int CODE_RELAX_LOAD_SO_FAIL = 806;
    public static final int CODE_RELAX_LOSE_FILE = 804;
    public static final int CODE_RELAX_OK = 800;
    public static final int CODE_RELAX_REMOVE_PATCH_CLASSES_FAIL = 805;
    public static final int CODE_RESOLVE_LIB_UNLOAD = 609;
    public static final int CODE_RESOLVE_SUCCESS = 600;
    public static final int CODE_UNZIP_7Z_EXCEPTION = 702;
    public static final int CODE_UNZIP_7Z_FAIL = 701;
    public static final int CODE_UNZIP_7Z_SIZE_ERROR = 703;
    public static final int CODE_UNZIP_7Z_SUCCESS = 700;
    private static final int INTERVAL_REPORT_PATCH_INSTALL = 8;
    public static final int PATCH_DOWN_BAD_URL = 5001;
    public static final int PATCH_DOWN_OK = 5000;
    public static final int PATCH_DOWN_RENAME_FAILED = 5002;
    private static SimpleDateFormat patchReportDateFormat;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(18997);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            patchReportDateFormat = new SimpleDateFormat("yyyyMMddHH");
        }
    }

    public PatchReporter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void reportPatchDownload(String str, String str2, String str3, int i3, int i16, long j3) {
        boolean z16;
        int i17;
        MsfCore msfCore;
        try {
            String valueOf = String.valueOf(i3);
            HashMap hashMap = new HashMap();
            hashMap.put(QzoneIPCModule.RESULT_CODE, valueOf);
            hashMap.put("patchPath", str2);
            hashMap.put("patchTmpPath", str3);
            hashMap.put("patchUrl", str);
            String str4 = "";
            if (TextUtils.isEmpty("") && (msfCore = MsfCore.sCore) != null) {
                str4 = msfCore.getMainAccount();
            }
            QLog.d("PatchLogTag", 1, "reportPatchDownload reportPatchEvent curUin=" + str4 + ", path=" + str2 + ", result=" + valueOf + ", tmpPath=" + str3);
            if (i3 == 0) {
                i17 = i16;
                z16 = true;
            } else {
                z16 = false;
                i17 = i16;
            }
            StatReportManager.collectPerformance(str4, ACTION_PATCH_DOWN_MSF, z16, j3, i17, hashMap, null, false);
            QLog.d("PatchLogTag", 1, "PatchReporter reportPatchEvent actPatchDownMsf");
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
    }

    public static void reportPatchEvent(Context context, String str, String str2, int i3, String str3) {
        reportPatchEvent(context, str, str2, i3, str3, 0);
    }

    public static void reportPatchEvent(Context context, String str, String str2, int i3, String str3, int i16) {
        MsfCore msfCore;
        try {
            String valueOf = String.valueOf(i3);
            HashMap hashMap = new HashMap();
            hashMap.put(QzoneIPCModule.RESULT_CODE, valueOf);
            hashMap.put("relaxCode", String.valueOf(i16));
            hashMap.put("patchName", str3);
            String mainAccount = (!TextUtils.isEmpty(str) || (msfCore = MsfCore.sCore) == null) ? str : msfCore.getMainAccount();
            QLog.d("PatchLogTag", 1, "PatchReporter reportPatchEvent curUin=" + mainAccount + ", event=" + str2 + ", result=" + i3 + ", patchName=" + str3);
            boolean z16 = i3 % 100 == 0;
            if (!ACTION_PATCH_CONFIG.equals(str2) && !ACTION_PATCH_DOWNLOAD.equals(str2) && !ACTION_PATCH_RESOLVE.equals(str2) && !ACTION_PATCH_UNZIP.equals(str2)) {
                String str4 = str2 + mainAccount + str3;
                String patchReportInfo = PatchSharedPreUtil.getPatchReportInfo(context, str4);
                if (ACTION_PATCH_CHECK.equals(str2)) {
                    if (TextUtils.isEmpty(patchReportInfo) || !patchReportInfo.equals(valueOf)) {
                        StatReportManager.collectPerformance(mainAccount, str2, z16, 0L, 0L, hashMap, null, false);
                        PatchSharedPreUtil.updatePatchReportInfo(context, str4, valueOf);
                        QLog.d("PatchLogTag", 1, "PatchReporter reportPatchEvent actPatchCheck");
                        return;
                    }
                    return;
                }
                if (ACTION_PATCH_INSTALL.equals(str2)) {
                    boolean z17 = z16;
                    String format = patchReportDateFormat.format(new Date(System.currentTimeMillis()));
                    String str5 = valueOf + format.substring(0, 8) + (Integer.parseInt(format.substring(8)) / 8);
                    if (TextUtils.isEmpty(patchReportInfo) || !patchReportInfo.equals(str5)) {
                        hashMap.put("uin", mainAccount);
                        hashMap.put("sdk", String.valueOf(Build.VERSION.SDK_INT));
                        StatReportManager.collectPerformance(mainAccount, str2, z17, 0L, 0L, hashMap, null, false);
                        PatchSharedPreUtil.updatePatchReportInfo(context, str4, str5);
                        QLog.d("PatchLogTag", 1, "PatchReporter reportPatchEvent actPatchInstall");
                        return;
                    }
                    return;
                }
                return;
            }
            StatReportManager.collectPerformance(mainAccount, str2, z16, 0L, 0L, hashMap, null, false);
            QLog.d("PatchLogTag", 1, "PatchReporter reportPatchEvent " + str2);
        } catch (Throwable th5) {
            QLog.d("PatchLogTag", 1, "PatchReporter reportPatchEvent throwable=" + th5);
        }
    }
}
