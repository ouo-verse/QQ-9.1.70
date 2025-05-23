package com.tencent.thumbplayer.common;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.telephony.ServiceState;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.bugly.common.utils.DeviceInfoUtil;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.info.QADNetStatus;
import com.tencent.qmethod.pandoraex.monitor.LocationMonitor;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;
import com.tencent.thumbplayer.common.log.TPLogUtil;
import com.tencent.thumbplayer.common.thread.TPThreadPool;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes26.dex */
public class TPNetworkUtil {
    public static final int NETWORK_STATUS_AVAILABLE = 1;
    public static final int NETWORK_STATUS_UNAVAILABLE = 0;
    public static final int NETWORK_STATUS_UNKNOWN = -1;
    public static final int NETWORK_TYPE_2G = 1;
    public static final int NETWORK_TYPE_3G = 2;
    public static final int NETWORK_TYPE_4G = 3;
    public static final int NETWORK_TYPE_5G = 4;
    public static final int NETWORK_TYPE_UNKNOWN = -1;
    public static final int NETWORK_TYPE_WIFI = 0;
    private static final int SYSTEM_ENUM_NETWORK_TYPE_NR = 20;
    private static final String TAG = "TPNetworkUtil";
    private static boolean sIsRegistered = false;
    private static boolean sNeedUpdateNetworkInfo = false;
    private static int sNetworkStatus = -1;
    private static BroadcastReceiver sNetworkStatusMonitor = new BroadcastReceiver() { // from class: com.tencent.thumbplayer.common.TPNetworkUtil.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            TPNetworkUtil.updateNetworkInfo(context);
        }
    };
    private static int sNetworkType = -1;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes26.dex */
    public @interface TPNetworkStatus {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes26.dex */
    public @interface TPNetworkType {
    }

    private static boolean checkPermission(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            if ("android.permission.WRITE_SETTINGS".equals(str)) {
                return Settings.System.canWrite(context);
            }
            try {
                if (context.checkSelfPermission(str) == 0) {
                    return true;
                }
            } catch (Exception e16) {
                TPLogUtil.e(TAG, e16.getMessage());
            }
        }
        return false;
    }

    private static int convertTelNetworkTypeToTPNetworkType(int i3) {
        if (i3 != 20) {
            switch (i3) {
                case 1:
                case 2:
                case 4:
                case 7:
                case 11:
                    return 1;
                case 3:
                case 5:
                case 6:
                case 8:
                case 9:
                case 10:
                case 12:
                case 14:
                case 15:
                    return 2;
                case 13:
                    return 3;
                default:
                    return -1;
            }
        }
        return 4;
    }

    private static void dumpNetworkInfo() {
        String str;
        int i3 = sNetworkStatus;
        String str2 = "unknown";
        if (i3 != 0) {
            if (i3 != 1) {
                str = "unknown";
            } else {
                str = "available";
            }
        } else {
            str = QADNetStatus.UNAVAILABLE;
        }
        int i16 = sNetworkType;
        if (i16 != 0) {
            if (i16 != 1) {
                if (i16 != 2) {
                    if (i16 != 3) {
                        if (i16 == 4) {
                            str2 = "mobile 5G";
                        }
                    } else {
                        str2 = "mobile 4G";
                    }
                } else {
                    str2 = "mobile 3G";
                }
            } else {
                str2 = "mobile 2G";
            }
        } else {
            str2 = "wifi";
        }
        TPLogUtil.i(TAG, "dumpNetworkInfo, currentNetworkStatus is " + str + ", currentNetworkType is " + str2);
    }

    private static int getMobileNetworkType(Context context, int i3) {
        if (is5GNetworkType(context)) {
            return 4;
        }
        return convertTelNetworkTypeToTPNetworkType(i3);
    }

    public static int getNetworkStatus(Context context) {
        int i3 = sNetworkStatus;
        if (i3 != -1 && !sNeedUpdateNetworkInfo) {
            return i3;
        }
        int networkStatusByContext = getNetworkStatusByContext(context);
        sNetworkStatus = networkStatusByContext;
        return networkStatusByContext;
    }

    private static int getNetworkStatusByContext(Context context) {
        NetworkInfo activeNetworkInfo;
        if (context == null) {
            return -1;
        }
        if (!sIsRegistered) {
            registerReceiver(context);
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
            if (connectivityManager != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null && activeNetworkInfo.isAvailable()) {
                if (activeNetworkInfo.getState() == NetworkInfo.State.CONNECTED) {
                    return 1;
                }
            }
            return 0;
        } catch (Exception e16) {
            TPLogUtil.e(TAG, e16.getMessage());
            return -1;
        }
    }

    public static int getNetworkType(Context context) {
        int i3 = sNetworkType;
        if (i3 != -1 && !sNeedUpdateNetworkInfo) {
            return i3;
        }
        int networkTypeByContext = getNetworkTypeByContext(context);
        sNetworkType = networkTypeByContext;
        return networkTypeByContext;
    }

    private static int getNetworkTypeByContext(Context context) {
        NetworkInfo activeNetworkInfo;
        if (context == null) {
            return -1;
        }
        if (!sIsRegistered) {
            registerReceiver(context);
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null && activeNetworkInfo.isConnected()) {
                int type = NetworkMonitor.getType(activeNetworkInfo);
                if (type != 0) {
                    if (type != 1) {
                        return -1;
                    }
                    return 0;
                }
                return getMobileNetworkType(context, NetworkMonitor.getSubtype(activeNetworkInfo));
            }
        } catch (Exception e16) {
            TPLogUtil.e(TAG, e16.getMessage());
        }
        return -1;
    }

    private static boolean is5GNetworkType(Context context) {
        int networkType;
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager == null) {
            TPLogUtil.e(TAG, "is5GNetworkType, TelephonyManager is null");
            return false;
        }
        if (Build.VERSION.SDK_INT < 29) {
            TPLogUtil.e(TAG, "is5GNetworkType, less api 29");
            return false;
        }
        if (!checkPermission(context, DeviceInfoUtil.PERMISSION_READ_PHONE)) {
            TPLogUtil.e(TAG, "is5GNetworkType, no READ_PHONE_STATE permission");
            return false;
        }
        try {
            networkType = NetworkMonitor.getNetworkType(telephonyManager);
        } catch (Exception e16) {
            TPLogUtil.e(TAG, e16);
        }
        if (networkType != 13 && networkType != 20) {
            TPLogUtil.i(TAG, "is5GNetworkType, not NETWORK_TYPE_LTE");
            return false;
        }
        ServiceState serviceState = LocationMonitor.getServiceState(telephonyManager);
        if (serviceState == null) {
            TPLogUtil.e(TAG, "is5GNetworkType, serviceState is null");
            return false;
        }
        int intValue = ((Integer) TPPrimaryReflectUtil.invokeMethod(serviceState, "android.telephony.ServiceState", "getNrState", new Class[0], new Object[0])).intValue();
        if (intValue == 2 || intValue == 3) {
            TPLogUtil.i(TAG, "is5GNetworkType, networkType is NETWORK_TYPE_NR (5G)");
            return true;
        }
        return false;
    }

    public static boolean isNetworkAvailable(Context context) {
        int i3 = sNetworkStatus;
        if (i3 != -1 && !sNeedUpdateNetworkInfo) {
            if (i3 != 1) {
                return false;
            }
            return true;
        }
        int networkStatusByContext = getNetworkStatusByContext(context);
        sNetworkStatus = networkStatusByContext;
        if (networkStatusByContext != 1) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$registerReceiver$0(Context context) {
        context.registerReceiver(sNetworkStatusMonitor, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"), null, new Handler(TPThreadPool.getInstance().obtainSharedHandlerThread().getLooper()));
    }

    private static synchronized void registerReceiver(@NonNull final Context context) {
        synchronized (TPNetworkUtil.class) {
            if (sIsRegistered) {
                return;
            }
            if (Looper.getMainLooper() == Looper.myLooper()) {
                context.registerReceiver(sNetworkStatusMonitor, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"), null, new Handler(TPThreadPool.getInstance().obtainSharedHandlerThread().getLooper()));
            } else {
                TPThreadPool.getInstance().postRunnableOnMainThread(new Runnable() { // from class: com.tencent.thumbplayer.common.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        TPNetworkUtil.lambda$registerReceiver$0(context);
                    }
                });
            }
            sIsRegistered = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void updateNetworkInfo(Context context) {
        sNeedUpdateNetworkInfo = true;
        sNetworkStatus = getNetworkStatusByContext(context);
        sNetworkType = getNetworkTypeByContext(context);
        dumpNetworkInfo();
        sNeedUpdateNetworkInfo = false;
    }
}
