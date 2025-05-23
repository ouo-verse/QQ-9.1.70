package mqq.manager.impl;

import android.app.ActivityManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Base64;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.msf.sdk.MsfMsgUtil;
import com.tencent.mobileqq.msf.sdk.MsfServiceSdk;
import com.tencent.mobileqq.msf.sdk.RdmReq;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.login.QAdLoginDefine$LoginStatus;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileFilter;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.app.ISecurityFileHelper;
import mqq.app.MainService;
import mqq.app.MobileQQ;
import mqq.manager.ISecurityFileFrameworkService;

/* compiled from: P */
/* loaded from: classes28.dex */
public class SecurityFileFrameworkServiceImpl implements ISecurityFileFrameworkService {
    private static final long ERROR_CODE_ENCRYPT_FILE_EXIST_WHEN_FIRST_INTO = 6;
    private static final long ERROR_CODE_FETCH_THIRD_PROCESS_ERROR = 7;
    private static final long ERROR_CODE_FRAMEWORK_ENABLE_FAIL = 0;
    private static final long ERROR_CODE_GET_ROOT_FILTER_NULL = 9;
    private static final long ERROR_CODE_GET_UIN_FILTER_NULL = 10;
    private static final long ERROR_CODE_RENAME_BUT_UIN_FILE_REMOVED = 4;
    private static final long ERROR_CODE_RENAME_FAIL = 2;
    private static final long ERROR_CODE_RENAME_FAIL_TOOL_PROCESS_EXIST = 3;
    private static final long ERROR_CODE_RENAME_SUCCESS = 1;
    private static final long ERROR_CODE_RENAME_SUCCESS_BUT_FILE_SUM_NO_MATCH = 11;
    private static final long ERROR_CODE_RETURN_NULL = 8;
    private static final long ERROR_CODE_TOKEN_DO_NOT_MATCH = 5;
    public static final String FILE_KEY_PREFIX = "NoRename#";
    private static final long REQUEST_CODE_SECURITY_FILE_FRAMEWORK = 0;
    private static final String SP_KEY_FILE_KEY = "FILE_KEY";
    private static final String SP_KEY_UIN_IS_FIRST = "UIN_IS_FIRST_";
    public static final String TAG = "SecurityFileFrameworkManagerImpl";
    private static File sRootFile;
    private ConcurrentHashMap<String, File> businessRootFiles = new ConcurrentHashMap<>();
    private AppRuntime mApp;
    private File mUINRootFile;
    private static String SDCARD_ROOT = getInitSDCardRoot();
    private static String SDCARD_PATH = SDCARD_ROOT + "/Tencent/MobileQQ/";
    private static boolean enable = false;

    private static String generalFileKey() {
        byte[] bArr = new byte[6];
        new SecureRandom().nextBytes(bArr);
        String encodeToString = Base64.encodeToString(bArr, 11);
        return generateVerifyChar(encodeToString) + encodeToString;
    }

    private String generateEncryptUIN(String str, String str2, String str3) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "generateEncryptUIN( deviceToken=", str2, "fileKey= ", str3, " )");
        }
        return MD5.toMD5(str2 + str + str3);
    }

    private File generateOrGetUINFile() {
        String str;
        boolean z16;
        String str2;
        String deviceToken = MsfServiceSdk.get().getDeviceToken(this.mApp.getAccount());
        SharedPreferences sharedPreferences = this.mApp.getApplication().getSharedPreferences(TAG, 4);
        String string = sharedPreferences.getString(this.mApp.getAccount(), null);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "Current UIN=", this.mApp.getAccount(), "msfDeviceToken=", deviceToken, " spDeviceToken=", string);
        }
        boolean z17 = sharedPreferences.getBoolean(SP_KEY_UIN_IS_FIRST + this.mApp.getAccount(), true);
        if (TextUtils.isEmpty(deviceToken)) {
            if (TextUtils.isEmpty(string)) {
                String account = this.mApp.getAccount();
                str = SP_KEY_UIN_IS_FIRST;
                string = account;
                z16 = z17;
            } else {
                str = SP_KEY_UIN_IS_FIRST;
                z16 = false;
            }
        } else if (TextUtils.isEmpty(string)) {
            sharedPreferences.edit().putString(this.mApp.getAccount(), deviceToken).commit();
            str = SP_KEY_UIN_IS_FIRST;
            string = deviceToken;
            z16 = true;
        } else {
            if (!deviceToken.equals(string)) {
                QLog.d(TAG, 1, "Token Don't Match: msfDeviceToken=", deviceToken, " spDeviceToken=", string);
                sharedPreferences.edit().putString(this.mApp.getAccount(), deviceToken).commit();
                str = SP_KEY_UIN_IS_FIRST;
                reportToRDM(0L, 5L, null);
            } else {
                str = SP_KEY_UIN_IS_FIRST;
            }
            string = deviceToken;
            z16 = false;
        }
        final String account2 = this.mApp.getAccount();
        File[] listFiles = sRootFile.listFiles(new FileFilter() { // from class: mqq.manager.impl.SecurityFileFrameworkServiceImpl.2
            @Override // java.io.FileFilter
            public boolean accept(File file) {
                if (file.isDirectory() && (file.getName().length() == 32 || file.getName().equals(account2))) {
                    return true;
                }
                return false;
            }
        });
        String generateEncryptUIN = generateEncryptUIN(this.mApp.getAccount(), string, sRootFile.getName().replace(FILE_KEY_PREFIX, ""));
        if (listFiles == null) {
            QLog.d(TAG, 1, "sRootFile.listFiles = null");
            str2 = generateEncryptUIN;
            reportToRDM(0L, 10L, null);
            listFiles = new File[0];
        } else {
            str2 = generateEncryptUIN;
        }
        boolean z18 = false;
        boolean z19 = false;
        for (File file : listFiles) {
            if (file.getName().equals(this.mApp.getAccount())) {
                z19 = true;
            }
            if (file.getName().equals(str2)) {
                z18 = true;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "hasEncryptUinDir=", Boolean.valueOf(z18), " encryptUIN=", str2);
        }
        if (z18) {
            if (z16) {
                sharedPreferences.edit().putBoolean(str + this.mApp.getAccount(), false).commit();
                reportToRDM(0L, 6L, null);
            }
            return new File(sRootFile + File.separator + str2);
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "isFirst=", Boolean.valueOf(z16), " hasUINDir=", Boolean.valueOf(z19));
        }
        if (z16) {
            File file2 = new File(sRootFile.getAbsolutePath() + File.separator + this.mApp.getAccount());
            if (!file2.exists()) {
                file2.mkdirs();
            }
            sharedPreferences.edit().putBoolean(str + this.mApp.getAccount(), false).commit();
            return file2;
        }
        if (z19) {
            File renameAndGetDir = renameAndGetDir(str2, isContainThirdProcess());
            if (renameAndGetDir != null) {
                return renameAndGetDir;
            }
            reportToRDM(0L, 8L, null);
            return null;
        }
        File file3 = new File(sRootFile.getAbsolutePath() + File.separator + str2);
        file3.mkdirs();
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("toFile", file3.getAbsolutePath());
        reportToRDM(0L, 4L, hashMap);
        return file3;
    }

    public static char generateVerifyChar(String str) {
        int i3 = 0;
        for (char c16 : str.toCharArray()) {
            i3 += c16 * c16;
        }
        return "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789".charAt(i3 % 60);
    }

    private File getBusinessRootFile(ISecurityFileHelper iSecurityFileHelper) {
        if (this.businessRootFiles.containsKey(this.mApp.getAccount() + iSecurityFileHelper.declareBusinessFileName())) {
            return this.businessRootFiles.get(this.mApp.getAccount() + iSecurityFileHelper.declareBusinessFileName());
        }
        if (iSecurityFileHelper.oldBusinessDirExist(this.mApp.getAccount())) {
            this.businessRootFiles.put(this.mApp.getAccount() + iSecurityFileHelper.declareBusinessFileName(), iSecurityFileHelper.oldBusinessDir(this.mApp.getAccount()));
            return iSecurityFileHelper.oldBusinessDir(this.mApp.getAccount());
        }
        File file = new File(this.mUINRootFile.getAbsolutePath() + File.separator + iSecurityFileHelper.declareBusinessFileName());
        if (!file.exists()) {
            file.mkdirs();
        }
        this.businessRootFiles.put(this.mApp.getAccount() + iSecurityFileHelper.declareBusinessFileName(), file);
        return file;
    }

    private static String getInitSDCardRoot() {
        try {
            return Environment.getExternalStorageDirectory().getAbsolutePath();
        } catch (Throwable unused) {
            return null;
        }
    }

    public static File getRootFile() {
        File file;
        synchronized (SecurityFileFrameworkServiceImpl.class) {
            if (sRootFile == null) {
                boolean initSecureFileFramework = initSecureFileFramework(BaseApplication.context);
                enable = initSecureFileFramework;
                if (!initSecureFileFramework || sRootFile == null) {
                    sRootFile = new File(SDCARD_PATH);
                }
            }
            file = sRootFile;
        }
        return file;
    }

    private static boolean initSecureFileFramework(Context context) {
        boolean z16;
        if (context == null) {
            QLog.d(TAG, 1, "context is null");
            return false;
        }
        File externalCacheDir = context.getExternalCacheDir();
        if (externalCacheDir != null && externalCacheDir.getParentFile() != null) {
            SDCARD_ROOT = externalCacheDir.getParentFile().getAbsolutePath();
            SDCARD_PATH = SDCARD_ROOT + "/Tencent/MobileQQ/";
            File file = new File(SDCARD_PATH);
            if (!file.exists() && !file.mkdirs()) {
                QLog.d(TAG, 1, "rootFile create fail, target root path=", file.getAbsoluteFile());
                return false;
            }
            SharedPreferences sharedPreferences = context.getSharedPreferences(TAG, 4);
            String string = sharedPreferences.getString(SP_KEY_FILE_KEY, "");
            if (TextUtils.isEmpty(string)) {
                File[] listFiles = file.listFiles(new FileFilter() { // from class: mqq.manager.impl.SecurityFileFrameworkServiceImpl.1
                    @Override // java.io.FileFilter
                    public boolean accept(File file2) {
                        if (!file2.isDirectory() || !file2.getName().startsWith(SecurityFileFrameworkServiceImpl.FILE_KEY_PREFIX)) {
                            return false;
                        }
                        String replaceAll = file2.getName().replaceAll(SecurityFileFrameworkServiceImpl.FILE_KEY_PREFIX, "");
                        if (replaceAll.length() != 9 || replaceAll.charAt(0) != SecurityFileFrameworkServiceImpl.generateVerifyChar(replaceAll.substring(1))) {
                            return false;
                        }
                        return true;
                    }
                });
                if (listFiles == null) {
                    listFiles = new File[0];
                    QLog.d(TAG, 1, "rootFile.listFiles = null");
                }
                if (listFiles.length > 1) {
                    long j3 = Long.MAX_VALUE;
                    File file2 = null;
                    for (File file3 : listFiles) {
                        if (file3.lastModified() < j3) {
                            j3 = file3.lastModified();
                            file2 = file3;
                        }
                    }
                    Object[] objArr = new Object[4];
                    objArr[0] = "initSecureFileFramework: fileKeyFiles.length=";
                    objArr[1] = Integer.valueOf(listFiles.length);
                    objArr[2] = "firstCreateFile=";
                    if (file2 == null) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    objArr[3] = Boolean.valueOf(z16);
                    QLog.d(TAG, 1, objArr);
                    if (file2 == null) {
                        return false;
                    }
                    sharedPreferences.edit().putString(SP_KEY_FILE_KEY, file2.getName().replaceAll(FILE_KEY_PREFIX, "")).commit();
                    sRootFile = file2;
                    return true;
                }
                if (listFiles.length == 0) {
                    String generalFileKey = generalFileKey();
                    File file4 = new File(file.getAbsolutePath() + File.separator + FILE_KEY_PREFIX + generalFileKey);
                    if (file4.mkdirs()) {
                        sharedPreferences.edit().putString(SP_KEY_FILE_KEY, generalFileKey).commit();
                        sRootFile = file4;
                        return true;
                    }
                    QLog.d(TAG, 1, "dir create fail, path=", file4.getAbsoluteFile());
                    return false;
                }
                sharedPreferences.edit().putString(SP_KEY_FILE_KEY, listFiles[0].getName().replaceAll(FILE_KEY_PREFIX, "")).commit();
                sRootFile = listFiles[0];
                return true;
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append(file.getAbsolutePath());
            String str = File.separator;
            sb5.append(str);
            sb5.append(FILE_KEY_PREFIX);
            sb5.append(string);
            File file5 = new File(sb5.toString());
            if (file5.exists()) {
                if (!file5.isDirectory()) {
                    if (file5.renameTo(new File(file.getAbsolutePath() + str + FILE_KEY_PREFIX + string + "_bak"))) {
                        QLog.d(TAG, 1, "dir been occupied\uff0crename file\uff1a", file5.getAbsoluteFile());
                        if (file5.mkdirs()) {
                            sRootFile = file5;
                            return true;
                        }
                        QLog.d(TAG, 1, "dir been occupied\uff0ccreate dir fail, path=", file5.getAbsoluteFile());
                        return false;
                    }
                    QLog.d(TAG, 1, "dir been occupied\uff0crename file fail, can't create new file, path=", file5.getAbsoluteFile());
                    return false;
                }
                sRootFile = file5;
                return true;
            }
            if (file5.mkdirs()) {
                sRootFile = file5;
                return true;
            }
            QLog.d(TAG, 1, "FileKey exist, File no exist, dir create fail, path=", file5.getAbsoluteFile());
            return false;
        }
        QLog.d(TAG, 1, "externalCacheDir is null");
        return false;
    }

    private boolean isContainThirdProcess() {
        boolean z16 = true;
        try {
            ActivityManager activityManager = (ActivityManager) this.mApp.getApplication().getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
            if (activityManager != null) {
                List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = SystemMethodProxy.getRunningAppProcesses(activityManager);
                for (int i3 = 0; i3 < runningAppProcesses.size(); i3++) {
                    if ("com.tencent.mobileqq:tool".equals(runningAppProcesses.get(i3).processName)) {
                        break;
                    }
                }
            }
            z16 = false;
            return z16;
        } catch (Exception e16) {
            QLog.d(TAG, 1, e16.toString());
            reportToRDM(0L, 7L, null);
            return false;
        }
    }

    private File renameAndGetDir(String str, boolean z16) {
        long j3;
        StringBuilder sb5 = new StringBuilder();
        sb5.append(sRootFile.getAbsolutePath());
        String str2 = File.separator;
        sb5.append(str2);
        sb5.append(this.mApp.getAccount());
        File file = new File(sb5.toString());
        File file2 = new File(sRootFile.getAbsolutePath() + str2 + str);
        if (file.exists()) {
            if (!z16) {
                String[] list = file.list();
                long j16 = -1;
                if (list != null) {
                    j3 = list.length;
                } else {
                    j3 = -1;
                }
                if (file.renameTo(file2)) {
                    String[] list2 = file2.list();
                    if (list2 != null) {
                        j16 = list2.length;
                    }
                    HashMap<String, String> hashMap = new HashMap<>();
                    hashMap.put("fileSumBeforeRename", "" + j3);
                    hashMap.put("fileSumAfterRename", "" + j16);
                    if (j3 == j16) {
                        reportToRDM(0L, 1L, hashMap);
                    } else {
                        reportToRDM(0L, 11L, hashMap);
                    }
                    return file2;
                }
                HashMap<String, String> hashMap2 = new HashMap<>();
                hashMap2.put("tempFilePath", file.getAbsolutePath());
                reportToRDM(0L, 2L, hashMap2);
                QLog.d(TAG, 1, "hasUINDir & rename fail return=", file.getAbsolutePath());
                return file;
            }
            HashMap<String, String> hashMap3 = new HashMap<>();
            hashMap3.put("tempFilePath", file.getAbsolutePath());
            reportToRDM(0L, 3L, hashMap3);
            QLog.d(TAG, 1, "containThirdProcess return=", file.getAbsolutePath());
            return file;
        }
        return null;
    }

    private void reportToRDM(long j3, long j16, HashMap<String, String> hashMap) {
        String account;
        HashMap hashMap2;
        try {
            if (this.mApp.getAccount() == null) {
                account = "NoLogin";
            } else {
                account = this.mApp.getAccount();
            }
            StringBuilder sb5 = new StringBuilder();
            if (hashMap == null) {
                hashMap2 = new HashMap();
            } else {
                HashMap hashMap3 = new HashMap(hashMap);
                for (String str : hashMap.keySet()) {
                    sb5.append(str);
                    sb5.append("#");
                    sb5.append(hashMap.get(str));
                    sb5.append("|");
                }
                hashMap2 = hashMap3;
            }
            hashMap2.put("uin", account);
            hashMap2.put(QAdLoginDefine$LoginStatus.IS_LOGIN, String.valueOf(this.mApp.isLogin()));
            hashMap2.put("isRunning", String.valueOf(this.mApp.isRunning()));
            hashMap2.put("fromCode", j3 + "");
            hashMap2.put("errorCode", j16 + "");
            QLog.d(TAG, 1, "reportToRDM{ fromCode=", Long.valueOf(j3), " errorCode=", Long.valueOf(j16), " additionParams=", sb5.toString(), "}");
            RdmReq rdmReq = new RdmReq();
            rdmReq.eventName = "SecureFile";
            rdmReq.elapse = 0L;
            rdmReq.size = 0L;
            rdmReq.isSucceed = true;
            rdmReq.isRealTime = false;
            rdmReq.params = hashMap2;
            ToServiceMsg rdmReportMsg = MsfMsgUtil.getRdmReportMsg(MsfServiceSdk.get().getMsfServiceName(), rdmReq);
            rdmReportMsg.setNeedCallback(false);
            MsfServiceSdk.get().sendMsg(rdmReportMsg);
        } catch (Throwable unused) {
        }
    }

    @Override // mqq.manager.ISecurityFileFrameworkService
    public String getEncryptUIN() {
        return this.mUINRootFile.getName();
    }

    @Override // mqq.manager.ISecurityFileFrameworkService
    @Nullable
    public File getUINRootFile(@Nullable ISecurityFileHelper iSecurityFileHelper) {
        synchronized (SecurityFileFrameworkServiceImpl.class) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "call getUINRootFile");
            }
            if (this.mApp.getAccount() == null) {
                QLog.d(TAG, 1, "getAccount==null");
                if (!MainService.isDebugVersion) {
                    return null;
                }
                throw new RuntimeException("mApp.getAccount() == null, you need call it later");
            }
            if (!this.mApp.getApplication().getQQProcessName().equals(MobileQQ.PACKAGE_NAME)) {
                QLog.d(TAG, 1, "only call in main process");
                if (!MainService.isDebugVersion) {
                    return null;
                }
                throw new RuntimeException("method 'getUINRootFile' can only call in main process");
            }
            File file = this.mUINRootFile;
            if (file != null) {
                if (iSecurityFileHelper == null) {
                    return file;
                }
                return getBusinessRootFile(iSecurityFileHelper);
            }
            if (!enable) {
                QLog.d(TAG, 1, "getUINRootFile Enable = false");
                reportToRDM(0L, 0L, null);
                File file2 = new File(sRootFile.getAbsolutePath() + File.separator + this.mApp.getAccount());
                this.mUINRootFile = file2;
                if (!file2.mkdirs()) {
                    QLog.d(TAG, 1, "getUINRootFile Enable = false, mkdirs = false, mUINRootFile=", this.mUINRootFile.getAbsolutePath());
                    this.mUINRootFile = sRootFile;
                }
            } else {
                this.mUINRootFile = generateOrGetUINFile();
            }
            if (iSecurityFileHelper == null) {
                return this.mUINRootFile;
            }
            return getBusinessRootFile(iSecurityFileHelper);
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        this.mApp = appRuntime;
        getRootFile();
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        if (this.mApp != null) {
            this.mApp = null;
        }
    }
}
