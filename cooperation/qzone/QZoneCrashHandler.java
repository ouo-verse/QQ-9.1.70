package cooperation.qzone;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import android.text.format.Time;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.networkedmodule.QzoneModuleConst;
import java.io.File;
import java.io.FileWriter;
import java.lang.Thread;
import java.util.List;
import mqq.app.CrashHandler;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes28.dex */
public class QZoneCrashHandler extends CrashHandler {
    private static final String PREf_LAST_ERROR = "QZ_setting";
    private static Thread.UncaughtExceptionHandler defaultHandler;
    public static String lastCrashedMeasuredText;

    public QZoneCrashHandler() {
        if (defaultHandler == null) {
            defaultHandler = Thread.getDefaultUncaughtExceptionHandler();
        }
    }

    public static void appendLog(String str, String str2, boolean z16) {
        boolean z17;
        FileWriter fileWriter = null;
        try {
            try {
                String str3 = AppConstants.LOG_PATH_SDCARD;
                File file = new File(VFSAssistantUtils.getSDKPrivatePath(str3));
                if (!file.exists()) {
                    file.mkdirs();
                }
                File file2 = new File(VFSAssistantUtils.getSDKPrivatePath(str3 + "log1.txt"));
                if (!file2.exists()) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                FileWriter fileWriter2 = new FileWriter(file2, true);
                if (z17) {
                    try {
                        fileWriter2.write("App Version:" + AppSetting.f99554n + ",Model:" + DeviceInfoMonitor.getModel() + ",AndroidVer" + Build.VERSION.RELEASE);
                        fileWriter2.write("\r\n");
                        Time time = new Time();
                        time.setToNow();
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append(time.format("[%Y-%m-%d %H:%M:%S]"));
                        sb5.append(" ");
                        fileWriter2.write(sb5.toString());
                        fileWriter2.write("Start Log...");
                        fileWriter2.write("\r\n");
                    } catch (Exception e16) {
                        e = e16;
                        fileWriter = fileWriter2;
                        e.printStackTrace();
                        if (fileWriter != null) {
                            try {
                                fileWriter.close();
                                return;
                            } catch (Exception e17) {
                                if (QLog.isColorLevel()) {
                                    QLog.e("ReportLog", 1, "Error Append fail" + e17.getMessage());
                                    return;
                                }
                                return;
                            }
                        }
                        return;
                    } catch (Throwable th5) {
                        th = th5;
                        fileWriter = fileWriter2;
                        if (fileWriter != null) {
                            try {
                                fileWriter.close();
                            } catch (Exception e18) {
                                if (QLog.isColorLevel()) {
                                    QLog.e("ReportLog", 1, "Error Append fail" + e18.getMessage());
                                }
                            }
                        }
                        throw th;
                    }
                }
                Time time2 = new Time();
                time2.setToNow();
                fileWriter2.write(time2.format("[%Y-%m-%d %H:%M:%S]") + " ");
                if (str != null) {
                    fileWriter2.write("<" + str + "> ");
                }
                fileWriter2.write(str2);
                fileWriter2.write("\r\n");
                fileWriter2.close();
            } catch (Exception e19) {
                e = e19;
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }

    @SuppressLint({"NewApi"})
    public static String getLastCrashInf() {
        SharedPreferences sharedPreferences = BaseApplication.getContext().getSharedPreferences("QZ_setting", 0);
        String string = sharedPreferences.getString(LocalMultiProcConfig.Constants.KEY_LAST_CRASH_INFO, null);
        if (string != null) {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.remove(LocalMultiProcConfig.Constants.KEY_LAST_CRASH_INFO);
            edit.apply();
        }
        return string;
    }

    @SuppressLint({"NewApi"})
    public static void saveLastCrashInf(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        LocalMultiProcConfig.putString("QZ_setting", LocalMultiProcConfig.Constants.KEY_LAST_CRASH_INFO, str);
        QzoneModuleConst.updateCrashInfo(str, true);
    }

    @Override // mqq.app.CrashHandler, java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th5) {
        SimpleAccount simpleAccount;
        String str;
        super.uncaughtException(thread, th5);
        List<SimpleAccount> allAccounts = MobileQQ.sMobileQQ.getAllAccounts();
        if (allAccounts != null) {
            simpleAccount = allAccounts.get(0);
        } else {
            simpleAccount = null;
        }
        if (simpleAccount != null) {
            str = simpleAccount.getUin();
        } else {
            str = "0";
        }
        CrashGuard.getInstance().onException(th5, Long.valueOf(str).longValue());
        MobileQQ mobileQQ = MobileQQ.sMobileQQ;
        String stackTraceString = QLog.getStackTraceString(th5);
        QLog.e("crash", 1, stackTraceString);
        saveLastCrashInf(stackTraceString);
        appendLog("crash", stackTraceString, true);
        QzoneModuleConst.updateCrashInfo(stackTraceString, false);
        defaultHandler.uncaughtException(thread, th5);
        mobileQQ.crashed();
        mobileQQ.otherProcessExit(false);
    }

    void alertExit() {
    }
}
