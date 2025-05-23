package com.tencent.qphone.base.util;

import android.os.Build;
import android.support.annotation.NonNull;
import com.tencent.mobileqq.monitor.NetworkMonitorCallback;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.sdk.utils.MonitorSocketImplFactory;
import com.tencent.mobileqq.msf.sdk.utils.MonitorSocketStat;
import com.tencent.mobileqq.qfix.ApplicationDelegate;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import java.io.File;
import java.io.FileInputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Random;

/* compiled from: P */
/* loaded from: classes22.dex */
public abstract class BaseApplication extends ApplicationDelegate {
    public static final String DATA_KEY_CHANNEL_ID = "channel_id";
    public static int appnewavmsgicon;
    public static int appnewmsgicon;
    public static BaseApplication context;
    public static int defaultNotifSoundResourceId;
    public static int devlockQuickloginIcon;
    public static MonitorSocketStat monitor;
    public static NetworkMonitorCallback networkMonitorCallback;
    public static String processName;
    public static int qqWifiConnecticon3;
    public static int qqWifiLayout;
    public static int qqWifiMissions;
    public static int qqWifiNoSignal;
    public static int qqWifiOperation;
    public static int qqWifiOperationTextViewId;
    public static int qqWifiRedTouchViewId;
    public static int qqWifiSettingViewId;
    public static int qqWifiSettings;
    public static int qqWifiStateIconViewId;
    public static int qqWifiStateTextSingleLine;
    public static int qqWifiStateTextViewId;
    public static int qqWifiTextDoubleLine;
    public static int qqWifiUserful;
    public static int qqlaunchicon;
    public static int qqwifinotifyconnectedicon;
    public static int qqwifinotifydivide;
    public static int qqwifinotifynoneicon;
    public static int qqwifinotifyusefulicon;
    private MSFInterfaceAdapter mMSFInterfaceAdapter = new MSFInterfaceAdapter();
    public static ArrayList<String> exclusiveStreamList = new ArrayList<>();
    public static int gMsfReceiverStarted = 0;
    public static String buildNum = "";
    public static String reportVersionName = "";
    public static boolean monitorBan = false;
    public static boolean httpMonitorBan = false;

    public static final void addServerSocket(String str) {
        MonitorSocketImplFactory.addServerSocket(str);
    }

    public static BaseApplication getContext() {
        return context;
    }

    public static final void removeServerSocket(String str) {
        MonitorSocketImplFactory.removeServerSocket(str);
    }

    public boolean doesHasPhonePermission() {
        return false;
    }

    public boolean doesHasSDCardPermission() {
        return false;
    }

    public abstract Object getAppData(String str);

    public abstract int getAppId();

    public abstract String getChannelId();

    public byte[] getCustomGuid() {
        return null;
    }

    @NonNull
    public MSFInterfaceAdapter getMSFInterfaceAdapter() {
        return this.mMSFInterfaceAdapter;
    }

    public abstract int getNTCoreVersion();

    public Integer getProductType() {
        return null;
    }

    public String getPublishVersion() {
        return "";
    }

    public abstract String getQua();

    public int getThirdPushType() {
        return 0;
    }

    public abstract boolean isUserAllow();

    /* JADX WARN: Removed duplicated region for block: B:24:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x01b5  */
    /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0122  */
    @Override // android.app.Application
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onCreate() {
        File file;
        String str;
        String str2;
        String str3;
        String str4;
        Exception exc;
        String property;
        super.onCreate();
        context = this;
        monitor = new MonitorSocketStat();
        long currentTimeMillis = System.currentTimeMillis();
        String str5 = null;
        try {
            file = new File(context.getFilesDir().getAbsolutePath() + "/monitor_config.properties");
        } catch (Exception e16) {
            QLog.d(MonitorSocketImplFactory.tag, 1, "" + e16);
            file = null;
        }
        if (file != null && file.exists()) {
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                Properties properties = new Properties();
                properties.load(fileInputStream);
                str2 = properties.getProperty("model");
                try {
                    property = properties.getProperty("display");
                    try {
                        str3 = properties.getProperty("appid");
                        try {
                            str4 = properties.getProperty("version");
                        } catch (Exception e17) {
                            e = e17;
                            str4 = null;
                            exc = e;
                            str = str4;
                            str5 = property;
                            QLog.d(MonitorSocketImplFactory.tag, 1, "" + exc);
                            QLog.d(MonitorSocketImplFactory.tag, 1, "phoneDisplays: " + str5 + ", phoneModels: " + str2 + ", appid: " + str3 + ", version: " + str4 + ", currVersion: " + MsfSdkUtils.getAppVersion() + ", process: " + str + ", " + processName);
                            if (str5 != null) {
                            }
                            if (!QLog.isColorLevel()) {
                            }
                        }
                    } catch (Exception e18) {
                        e = e18;
                        str3 = null;
                        str4 = null;
                    }
                } catch (Exception e19) {
                    e = e19;
                    str3 = null;
                    str4 = str3;
                    exc = e;
                    str = str4;
                    QLog.d(MonitorSocketImplFactory.tag, 1, "" + exc);
                    QLog.d(MonitorSocketImplFactory.tag, 1, "phoneDisplays: " + str5 + ", phoneModels: " + str2 + ", appid: " + str3 + ", version: " + str4 + ", currVersion: " + MsfSdkUtils.getAppVersion() + ", process: " + str + ", " + processName);
                    if (str5 != null) {
                    }
                    if (!QLog.isColorLevel()) {
                    }
                }
                try {
                    str5 = properties.getProperty("process");
                    fileInputStream.close();
                    str = str5;
                    str5 = property;
                } catch (Exception e26) {
                    exc = e26;
                    str = str5;
                    str5 = property;
                    QLog.d(MonitorSocketImplFactory.tag, 1, "" + exc);
                    QLog.d(MonitorSocketImplFactory.tag, 1, "phoneDisplays: " + str5 + ", phoneModels: " + str2 + ", appid: " + str3 + ", version: " + str4 + ", currVersion: " + MsfSdkUtils.getAppVersion() + ", process: " + str + ", " + processName);
                    if (str5 != null) {
                    }
                    if (!QLog.isColorLevel()) {
                    }
                }
            } catch (Exception e27) {
                e = e27;
                str2 = null;
                str3 = null;
            }
            QLog.d(MonitorSocketImplFactory.tag, 1, "phoneDisplays: " + str5 + ", phoneModels: " + str2 + ", appid: " + str3 + ", version: " + str4 + ", currVersion: " + MsfSdkUtils.getAppVersion() + ", process: " + str + ", " + processName);
        } else {
            QLog.d(MonitorSocketImplFactory.tag, 1, "monitor_config not found, disable monitor socket");
            str = null;
            str2 = null;
        }
        if (str5 != null) {
            if (QLog.isColorLevel()) {
                QLog.d(MonitorSocketImplFactory.tag, 2, "phoneDisplays is null, close Monitor Socket");
            }
        } else {
            String str6 = Build.DISPLAY;
            if (!str6.toUpperCase().contains("KOT49H") && !str6.toUpperCase().contains("KTU84P")) {
                if (!str5.contains(str6.toUpperCase()) && !str2.contains(DeviceInfoMonitor.getModel().toUpperCase())) {
                    if (new Random().nextInt(100) % 2 == 0) {
                        monitorBan = true;
                    }
                    if (!monitorBan) {
                        MonitorSocketImplFactory monitorSocketImplFactory = new MonitorSocketImplFactory();
                        if (monitorSocketImplFactory.getMsfSocketImpl(getContext())) {
                            try {
                                Socket.setSocketImplFactory(monitorSocketImplFactory);
                                QLog.d(MonitorSocketImplFactory.tag, 1, str + " Monitor Socket started.");
                            } catch (Exception unused) {
                                QLog.d(MonitorSocketImplFactory.tag, 1, "set socketimpl factory failed.");
                            }
                        } else {
                            QLog.d(MonitorSocketImplFactory.tag, 1, "get socketimpl failed.");
                        }
                    }
                } else {
                    QLog.d(MonitorSocketImplFactory.tag, 1, "Phone display|model in banlist, close Monitor Socket");
                }
            } else {
                QLog.d(MonitorSocketImplFactory.tag, 1, "Samsung above android 4.4 rom Donot Monitor Socket Netflow");
            }
        }
        if (!QLog.isColorLevel()) {
            QLog.d(MonitorSocketImplFactory.tag, 2, "BaseApplication(" + processName + ") initialization used " + (System.currentTimeMillis() - currentTimeMillis) + "ms");
        }
    }
}
