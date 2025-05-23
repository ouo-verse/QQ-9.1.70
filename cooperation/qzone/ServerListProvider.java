package cooperation.qzone;

import android.app.ActivityManager;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.cache.QZoneFilePath;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes28.dex */
public class ServerListProvider {
    private static String SERVER_DIR = QZoneFilePath.SERVER_DIR;
    private static final String TAG = "ServerListProvider";
    public static final int VALUE_DB2 = 13;
    public static final int VALUE_DB3 = 86;
    public static final int VALUE_DEV_001 = 15;
    public static final int VALUE_DEV_002 = 16;
    public static final int VALUE_DEV_003 = 17;
    public static final int VALUE_DEV_004 = 18;
    public static final int VALUE_DEV_005 = 19;
    public static final int VALUE_DEV_006 = 20;
    public static final int VALUE_DEV_007 = 21;
    public static final int VALUE_DEV_008 = 22;
    public static final int VALUE_DEV_009 = 23;
    public static final int VALUE_DEV_010 = 24;
    public static final int VALUE_DEV_011 = 25;
    public static final int VALUE_DEV_012 = 26;
    public static final int VALUE_DEV_013 = 27;
    public static final int VALUE_DEV_014 = 28;
    public static final int VALUE_DEV_015 = 29;
    public static final int VALUE_DEV_016 = 30;
    public static final int VALUE_DEV_017 = 31;
    public static final int VALUE_DEV_018 = 32;
    public static final int VALUE_DEV_019 = 33;
    public static final int VALUE_DEV_020 = 34;
    public static final int VALUE_DEV_021 = 35;
    public static final int VALUE_DEV_022 = 36;
    public static final int VALUE_DEV_023 = 37;
    public static final int VALUE_DEV_024 = 38;
    public static final int VALUE_DEV_025 = 39;
    public static final int VALUE_DEV_026 = 40;
    public static final int VALUE_DEV_027 = 41;
    public static final int VALUE_DEV_028 = 42;
    public static final int VALUE_DEV_029 = 43;
    public static final int VALUE_DEV_030 = 44;
    public static final int VALUE_DEV_031 = 45;
    public static final int VALUE_DEV_032 = 46;
    public static final int VALUE_DEV_033 = 47;
    public static final int VALUE_DEV_034 = 48;
    public static final int VALUE_DEV_035 = 49;
    public static final int VALUE_DEV_036 = 50;
    public static final int VALUE_DEV_037 = 51;
    public static final int VALUE_DEV_050 = 60;
    public static final int VALUE_DEV_051 = 61;
    public static final int VALUE_DEV_052 = 62;
    public static final int VALUE_DEV_053 = 63;
    public static final int VALUE_DEV_054 = 64;
    public static final int VALUE_DEV_055 = 65;
    public static final int VALUE_DEV_056 = 66;
    public static final int VALUE_DEV_057 = 67;
    public static final int VALUE_DEV_058 = 68;
    public static final int VALUE_DEV_059 = 69;
    public static final int VALUE_DEV_060 = 70;
    public static final int VALUE_DEV_061 = 71;
    public static final int VALUE_DEV_062 = 72;
    public static final int VALUE_DEV_063 = 73;
    public static final int VALUE_DEV_064 = 74;
    public static final int VALUE_DEV_065 = 75;
    public static final int VALUE_DEV_066 = 76;
    public static final int VALUE_DEV_067 = 77;
    public static final int VALUE_DEV_068 = 78;
    public static final int VALUE_DEV_069 = 79;
    public static final int VALUE_DEV_070 = 82;
    public static final int VALUE_DEV_071 = 83;
    public static final int VALUE_PUBLISH = 14;
    public static final int VALUE_TEST_001 = 11;
    public static final int VALUE_TEST_006 = 80;
    public static final int VALUE_TEST_007 = 81;
    public static final int VALUE_TEST_008 = 84;
    public static final int VALUE_TEST_009 = 85;
    public static final int VALUE_TEST_195 = 87;
    public static final int VALUE_TOUCH_001 = 12;
    public static final int VALUE_ZHENGSHI = 0;
    private static AtomicBoolean isDebugEnabled;

    private static void delServerFile() {
        try {
            File file = new File(QZoneFilePath.TESTSERVER_PATH);
            if (file.exists()) {
                file.delete();
            }
        } catch (Exception unused) {
        }
    }

    public static void enableDebug(boolean z16) {
        if (isDebugEnabled == null) {
            isDebugEnabled = new AtomicBoolean(false);
        }
        isDebugEnabled.set(z16);
        LocalMultiProcConfig.putBool(LocalMultiProcConfig.Constants.KEY_ENABLE_DEBUG, z16);
    }

    private static void generateServerFile() {
        FileWriter fileWriter;
        Throwable th5;
        BufferedWriter bufferedWriter;
        if (isServerFileExits()) {
            return;
        }
        File file = new File(SERVER_DIR);
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(QZoneFilePath.TESTSERVER_PATH);
        if (!file2.exists()) {
            BufferedWriter bufferedWriter2 = null;
            try {
                try {
                    if (file2.createNewFile()) {
                        fileWriter = new FileWriter(file2);
                        try {
                            bufferedWriter = new BufferedWriter(fileWriter);
                        } catch (Exception unused) {
                        } catch (Throwable th6) {
                            th5 = th6;
                            bufferedWriter = null;
                        }
                        try {
                            bufferedWriter.write("server=socket://59.37.96.165:14000");
                            bufferedWriter.close();
                            bufferedWriter2 = bufferedWriter;
                        } catch (Exception unused2) {
                            bufferedWriter2 = bufferedWriter;
                            if (bufferedWriter2 != null) {
                                try {
                                    bufferedWriter2.close();
                                } catch (Exception e16) {
                                    e16.printStackTrace();
                                }
                            }
                            if (fileWriter != null) {
                                fileWriter.close();
                            }
                            return;
                        } catch (Throwable th7) {
                            th5 = th7;
                            if (bufferedWriter != null) {
                                try {
                                    bufferedWriter.close();
                                } catch (Exception e17) {
                                    e17.printStackTrace();
                                }
                            }
                            if (fileWriter != null) {
                                try {
                                    fileWriter.close();
                                    throw th5;
                                } catch (Exception e18) {
                                    e18.printStackTrace();
                                    throw th5;
                                }
                            }
                            throw th5;
                        }
                    } else {
                        fileWriter = null;
                    }
                    if (bufferedWriter2 != null) {
                        try {
                            bufferedWriter2.close();
                        } catch (Exception e19) {
                            e19.printStackTrace();
                        }
                    }
                } catch (Exception unused3) {
                    fileWriter = null;
                } catch (Throwable th8) {
                    fileWriter = null;
                    th5 = th8;
                    bufferedWriter = null;
                }
                if (fileWriter != null) {
                    fileWriter.close();
                }
            } catch (Exception e26) {
                e26.printStackTrace();
            }
        }
    }

    public static String getCmdPrefix() {
        return QZoneHelper.CMD_PREFIX_PUBLIC;
    }

    public static int getType() {
        return LocalMultiProcConfig.getInt(LocalMultiProcConfig.Constants.KEY_SERVER_ENVIRONMENT, 0);
    }

    public static boolean isDebugEnable() {
        if (isDebugEnabled == null) {
            AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            isDebugEnabled = atomicBoolean;
            atomicBoolean.set(LocalMultiProcConfig.getBool(LocalMultiProcConfig.Constants.KEY_ENABLE_DEBUG, false));
        }
        return isDebugEnabled.get();
    }

    public static boolean isServerFileExits() {
        try {
            File file = new File(QZoneFilePath.TESTSERVER_PATH);
            if (!file.exists()) {
                return false;
            }
            if (file.length() <= 0) {
                return false;
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private static boolean killMSF() {
        try {
            BaseApplication context = BaseApplication.getContext();
            if (context != null) {
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : SystemMethodProxy.getRunningAppProcesses((ActivityManager) BaseApplication.getContext().getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY))) {
                    if (runningAppProcessInfo.processName.equals(context.getPackageName() + ":MSF")) {
                        SystemMethodProxy.killProcess(runningAppProcessInfo.pid);
                        return true;
                    }
                }
                return false;
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean switchToTestServer() {
        if (isServerFileExits()) {
            return true;
        }
        generateServerFile();
        if (killMSF()) {
            return true;
        }
        delServerFile();
        return false;
    }

    public static boolean switchToZhengshi() {
        if (!isServerFileExits()) {
            return true;
        }
        delServerFile();
        if (killMSF()) {
            return true;
        }
        generateServerFile();
        return false;
    }
}
