package com.tencent.mars.ilink.comm;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.telephony.TelephonyManager;
import android.util.Log;
import com.tencent.mars.ilink.xlog.Xlog;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;
import java.io.PrintWriter;
import java.io.StringWriter;

/* loaded from: classes9.dex */
public class PlatformComm {
    static final int EMobile = 2;
    static final int ENoNet = -1;
    static final int EOtherNet = 3;
    static final int EWifi = 1;
    private static final boolean IS_PROXY_ON = false;
    static final int NETTYPE_2G = 3;
    static final int NETTYPE_3G = 4;
    static final int NETTYPE_4G = 5;
    static final int NETTYPE_NON = -1;
    static final int NETTYPE_NOT_WIFI = 0;
    static final int NETTYPE_UNKNOWN = 6;
    static final int NETTYPE_WAP = 2;
    static final int NETTYPE_WIFI = 1;
    private static final String TAG = "PlatformComm";
    private static final Xlog m_xlog = new Xlog();
    public static Context context = null;
    public static Handler handler = null;

    /* loaded from: classes9.dex */
    public static class APNInfo {
        public String extraInfo;
        public int netType;
        public int subNetType;
    }

    /* loaded from: classes9.dex */
    public static class Assert {
        public static void assertTrue(String str, boolean z16) {
        }

        public static void assertTrue(boolean z16) {
        }
    }

    /* loaded from: classes9.dex */
    public static class C2Java {
        private static String exception2String(Exception exc) {
            StringWriter stringWriter = new StringWriter();
            exc.printStackTrace(new PrintWriter(stringWriter));
            return stringWriter.toString();
        }

        public static APNInfo getAPNInfo() {
            String netGetExInfo;
            try {
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) PlatformComm.context.getSystemService("connectivity")).getActiveNetworkInfo();
                APNInfo aPNInfo = new APNInfo();
                if (activeNetworkInfo != null) {
                    aPNInfo.netType = NetworkMonitor.getType(activeNetworkInfo);
                    aPNInfo.subNetType = NetworkMonitor.getSubtype(activeNetworkInfo);
                    if (1 != NetworkMonitor.getType(activeNetworkInfo)) {
                        if (NetworkMonitor.netGetExInfo(activeNetworkInfo) == null) {
                            netGetExInfo = "";
                        } else {
                            netGetExInfo = NetworkMonitor.netGetExInfo(activeNetworkInfo);
                        }
                        aPNInfo.extraInfo = netGetExInfo;
                    } else {
                        aPNInfo.extraInfo = getCurWifiInfo().ssid;
                    }
                    return aPNInfo;
                }
                return null;
            } catch (Exception e16) {
                e16.printStackTrace();
                return null;
            }
        }

        public static int getCurRadioAccessNetworkInfo() {
            Context context = PlatformComm.context;
            if (context == null) {
                Assert.assertTrue(false);
                return 0;
            }
            try {
                return NetworkMonitor.getNetworkType((TelephonyManager) context.getSystemService("phone"));
            } catch (SecurityException e16) {
                e16.printStackTrace();
                Assert.assertTrue(e16.getClass().getSimpleName() + ":" + e16.getStackTrace()[0] + ", " + e16.getStackTrace()[1], false);
                return 0;
            } catch (Exception e17) {
                e17.printStackTrace();
                Assert.assertTrue(e17.getClass().getSimpleName() + ":" + e17.getStackTrace()[0] + ", " + e17.getStackTrace()[1], false);
                return 0;
            }
        }

        public static SIMInfo getCurSIMInfo() {
            int iSPCode;
            try {
                Context context = PlatformComm.context;
                if (context == null || (iSPCode = NetStatusUtil.getISPCode(context)) == 0) {
                    return null;
                }
                SIMInfo sIMInfo = new SIMInfo();
                sIMInfo.ispCode = "" + iSPCode;
                sIMInfo.ispName = NetStatusUtil.getISPName(PlatformComm.context);
                return sIMInfo;
            } catch (Exception e16) {
                e16.printStackTrace();
                return null;
            }
        }

        public static WifiInfo getCurWifiInfo() {
            WifiInfo wifiInfo = new WifiInfo();
            wifiInfo.ssid = NetworkSignalUtil.getSSID();
            wifiInfo.bssid = NetworkSignalUtil.getBSSID();
            return wifiInfo;
        }

        public static int getNetInfo() {
            NetworkInfo activeNetworkInfo;
            ConnectivityManager connectivityManager = (ConnectivityManager) PlatformComm.context.getSystemService("connectivity");
            if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
                return -1;
            }
            try {
                int type = NetworkMonitor.getType(activeNetworkInfo);
                if (type != 0) {
                    if (type == 1) {
                        return 1;
                    }
                    if (type != 2 && type != 3 && type != 4 && type != 5) {
                        return 3;
                    }
                }
                return 2;
            } catch (Exception e16) {
                e16.printStackTrace();
                return 3;
            }
        }

        public static int getProxyInfo(StringBuffer stringBuffer) {
            return -1;
        }

        public static long getSignal(boolean z16) {
            try {
                if (PlatformComm.context == null) {
                    Assert.assertTrue(false);
                    return 0L;
                }
                if (z16) {
                    return NetworkSignalUtil.getWifiSignalStrength();
                }
                return NetworkSignalUtil.getGSMSignalStrength();
            } catch (Exception unused) {
                return 0L;
            }
        }

        public static int getStatisticsNetType() {
            Context context = PlatformComm.context;
            if (context == null) {
                Assert.assertTrue(false);
                return 0;
            }
            try {
                int netType = NetStatusUtil.getNetType(context);
                if (netType == -1) {
                    return -1;
                }
                if (NetStatusUtil.is2G(PlatformComm.context)) {
                    return 3;
                }
                if (NetStatusUtil.is3G(PlatformComm.context)) {
                    return 4;
                }
                if (NetStatusUtil.is4G(PlatformComm.context)) {
                    return 5;
                }
                if (NetStatusUtil.isWifi(netType)) {
                    return 1;
                }
                if (NetStatusUtil.isWap(netType)) {
                    return 2;
                }
                return 6;
            } catch (Exception e16) {
                Log.e(PlatformComm.TAG, exception2String(e16));
                Assert.assertTrue(e16.getClass().getSimpleName() + ":" + e16.getStackTrace()[0] + ", " + e16.getStackTrace()[1], false);
                return -1;
            }
        }

        public static boolean isNetworkConnected() {
            Context context = PlatformComm.context;
            if (context == null) {
                Assert.assertTrue(false);
                return false;
            }
            try {
                return NetStatusUtil.isNetworkConnected(context);
            } catch (Exception e16) {
                Log.e(PlatformComm.TAG, exception2String(e16));
                Assert.assertTrue(e16.getClass().getSimpleName() + ":" + e16.getStackTrace()[0] + ", " + e16.getStackTrace()[1], false);
                return false;
            }
        }

        public static boolean startAlarm(int i3, int i16, int i17) {
            Context context = PlatformComm.context;
            if (context == null) {
                Assert.assertTrue(false);
                return false;
            }
            try {
                return Alarm.start(i3, i16, i17, context);
            } catch (Exception e16) {
                Log.e(PlatformComm.TAG, exception2String(e16));
                e16.printStackTrace();
                Assert.assertTrue(e16.getClass().getSimpleName() + ":" + e16.getStackTrace()[0] + ", " + e16.getStackTrace()[1], false);
                return false;
            }
        }

        public static boolean stopAlarm(int i3) {
            Context context = PlatformComm.context;
            if (context == null) {
                Assert.assertTrue(false);
                return false;
            }
            try {
                return Alarm.stop(i3, context);
            } catch (Exception e16) {
                Log.e(PlatformComm.TAG, exception2String(e16));
                e16.printStackTrace();
                Assert.assertTrue(e16.getClass().getSimpleName() + ":" + e16.getStackTrace()[0] + ", " + e16.getStackTrace()[1], false);
                return false;
            }
        }

        public static WakerLock wakeupLock_new() {
            Context context = PlatformComm.context;
            if (context == null) {
                Assert.assertTrue(false);
                return null;
            }
            try {
                return new WakerLock(context);
            } catch (Exception e16) {
                Log.e(PlatformComm.TAG, exception2String(e16));
                Assert.assertTrue(e16.getClass().getSimpleName() + ":" + e16.getStackTrace()[0] + ", " + e16.getStackTrace()[1], false);
                return null;
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class SIMInfo {
        public String ispCode;
        public String ispName;
    }

    /* loaded from: classes9.dex */
    public static class WifiInfo {
        public String bssid;
        public String ssid;
    }

    public static void init(Context context2, Handler handler2) {
        context = context2;
        handler = handler2;
        NetworkSignalUtil.InitNetworkSignalUtil(context2);
        com.tencent.mars.ilink.xlog.Log.setLogImp(m_xlog);
    }
}
