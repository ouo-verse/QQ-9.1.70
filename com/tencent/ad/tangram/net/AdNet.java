package com.tencent.ad.tangram.net;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.LinkAddress;
import android.net.LinkProperties;
import android.net.NetworkInfo;
import android.os.Build;
import android.support.annotation.Nullable;
import android.telephony.TelephonyManager;
import com.tencent.ad.tangram.annotation.AdKeep;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.privacy.AdPrivacyPolicyManager;
import com.tencent.ad.tangram.system.AdTelephonyManager;
import com.tencent.ad.tangram.util.AdPermissionUtil;
import com.tencent.bugly.common.utils.DeviceInfoUtil;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;

/* compiled from: P */
@AdKeep
/* loaded from: classes3.dex */
public final class AdNet {
    public static final int IP_FAMILY_UNKNOWN = 0;
    public static final int IP_FAMILY_V4 = 1;
    public static final int IP_FAMILY_V6 = 2;
    private static final String TAG = "AdNet";

    private static int getDataTypeOnAndroidQ(int i3) {
        Object num = new Integer(1);
        Object num2 = new Integer(2);
        Object num3 = new Integer(3);
        Object num4 = new Integer(4);
        try {
            num = TelephonyManager.class.getDeclaredField("NETWORK_CLASS_2_G").get(TelephonyManager.class);
            num2 = TelephonyManager.class.getDeclaredField("NETWORK_CLASS_3_G").get(TelephonyManager.class);
            num3 = TelephonyManager.class.getDeclaredField("NETWORK_CLASS_4_G").get(TelephonyManager.class);
            num4 = TelephonyManager.class.getDeclaredField("NETWORK_CLASS_5_G").get(TelephonyManager.class);
        } catch (Throwable th5) {
            AdLog.d(TAG, "getDataTypeOnAndroidQ", th5);
        }
        try {
            Object invoke = TelephonyManager.class.getDeclaredMethod("getNetworkClass", Integer.TYPE).invoke(TelephonyManager.class, Integer.valueOf(i3));
            if (invoke.equals(num)) {
                return 2;
            }
            if (invoke.equals(num2)) {
                return 3;
            }
            if (invoke.equals(num3)) {
                return 4;
            }
            if (!invoke.equals(num4)) {
                return 0;
            }
            return 7;
        } catch (Throwable th6) {
            AdLog.d(TAG, "getDataTypeOnAndroidQ", th6);
            return 0;
        }
    }

    private static int getDataTypeOnAndroidR(int i3) {
        long bitMaskForNetworkType = AdTelephonyManager.getBitMaskForNetworkType(i3);
        if ((AdTelephonyManager.NETWORK_CLASS_BITMASK_2G & bitMaskForNetworkType) != 0) {
            return 2;
        }
        if ((AdTelephonyManager.NETWORK_CLASS_BITMASK_3G & bitMaskForNetworkType) != 0) {
            return 3;
        }
        if ((AdTelephonyManager.NETWORK_CLASS_BITMASK_4G & bitMaskForNetworkType) != 0) {
            return 4;
        }
        if ((bitMaskForNetworkType & 524288) != 0) {
            return 7;
        }
        return 0;
    }

    public static int getIpFamily(Context context) {
        if (!AdPrivacyPolicyManager.getInstance().isAllowed()) {
            AdLog.e(TAG, "getIpFamily not allowed");
            return 0;
        }
        return getIpFamilyImpl(context);
    }

    private static int getIpFamilyImpl(@Nullable Context context) {
        Context applicationContext;
        LinkProperties linkProperties;
        if (context == null || (applicationContext = context.getApplicationContext()) == null) {
            return 0;
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) applicationContext.getSystemService("connectivity");
            if (connectivityManager == null || (linkProperties = connectivityManager.getLinkProperties(connectivityManager.getActiveNetwork())) == null) {
                return 0;
            }
            int i3 = 0;
            for (LinkAddress linkAddress : linkProperties.getLinkAddresses()) {
                if (linkAddress != null) {
                    i3 |= getNetIpFamily(linkAddress.getAddress());
                }
            }
            return i3;
        } catch (Throwable th5) {
            AdLog.d(TAG, "getIpFamily", th5);
            return 0;
        }
    }

    private static int getNetIpFamily(@Nullable InetAddress inetAddress) {
        if (inetAddress != null && !inetAddress.isLoopbackAddress() && !inetAddress.isLinkLocalAddress() && !inetAddress.isAnyLocalAddress()) {
            if (inetAddress instanceof Inet6Address) {
                return 2;
            }
            if (inetAddress instanceof Inet4Address) {
                return 1;
            }
            return 0;
        }
        return 0;
    }

    public static int getType(Context context) {
        int typeInternal = getTypeInternal(context);
        if (typeInternal == 7) {
            return 0;
        }
        return typeInternal;
    }

    private static int getTypeInternal(@Nullable Context context) {
        Context applicationContext;
        NetworkInfo activeNetworkInfo;
        TelephonyManager telephonyManager;
        if (!AdPrivacyPolicyManager.getInstance().isAllowed()) {
            AdLog.e(TAG, "getTypeInternal not allowed");
            return 0;
        }
        if (context == null || (applicationContext = context.getApplicationContext()) == null) {
            return 0;
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) ConnectivityManager.class.cast(applicationContext.getSystemService("connectivity"));
            if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
                return 0;
            }
            switch (NetworkMonitor.getType(activeNetworkInfo)) {
                case 0:
                case 2:
                case 3:
                case 4:
                case 5:
                    if (Build.VERSION.SDK_INT <= 29) {
                        return getDataTypeOnAndroidQ(NetworkMonitor.getSubtype(activeNetworkInfo));
                    }
                    if (!AdPermissionUtil.checkPermission(context, DeviceInfoUtil.PERMISSION_READ_PHONE) || (telephonyManager = (TelephonyManager) TelephonyManager.class.cast(applicationContext.getSystemService("phone"))) == null) {
                        return 0;
                    }
                    return getDataTypeOnAndroidR(NetworkMonitor.getNetworkType(telephonyManager));
                case 1:
                case 6:
                    return 1;
                default:
                    return 0;
            }
        } catch (Throwable th5) {
            AdLog.e(TAG, "getTypeInternal", th5);
            return 0;
        }
    }

    public static int getTypeWith5G(Context context) {
        return getType(context);
    }

    public static boolean isNetValid(@Nullable Context context) {
        NetworkInfo activeNetworkInfo;
        if (!AdPrivacyPolicyManager.getInstance().isAllowed()) {
            AdLog.e(TAG, "isNetValid not allowed");
            return false;
        }
        if (context == null) {
            return false;
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
            if (connectivityManager != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null) {
                if (activeNetworkInfo.isAvailable()) {
                    return true;
                }
            }
            return false;
        } catch (Throwable th5) {
            AdLog.e(TAG, "isNetValid error :", th5);
            return false;
        }
    }

    public static boolean isWifiConnected(Context context) {
        if (getType(context) == 1) {
            return true;
        }
        return false;
    }
}
