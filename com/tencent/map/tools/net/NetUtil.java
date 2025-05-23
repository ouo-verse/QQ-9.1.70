package com.tencent.map.tools.net;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.info.QADNetStatus;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* compiled from: P */
@SuppressLint({"MissingPermission"})
/* loaded from: classes9.dex */
public class NetUtil {
    private static final int BUF_SIZE = 4096;
    private static final String CMWAP = "cmwap";
    private static final String CTWAP = "ctwap";
    public static final int DEFAULT_TIME_OUT = 10000;
    public static final String MAP_USER_AGENT = "QQ Map Mobile";
    private static final String NET_3G = "3gnet";
    public static final String STR_UserAgent = "androidsdk";
    public static final int TYPE_3GWAP = 3;
    public static final int TYPE_CMWAP = 1;
    public static final int TYPE_CTWAP = 4;
    public static final int TYPE_NET_WORK_DISABLED = 0;
    public static final int TYPE_OTHER_NET = 6;
    public static final int TYPE_UNIWAP = 2;
    public static final int TYPE_WIFI = 5;
    private static final String UNIWAP = "uniwap";
    private static final String WAP_3G = "3gwap";
    public static final String WIFI = "wifi";

    public static int getNetType(Context context) {
        return getNetType(getNetworkInfo(context));
    }

    public static String getNetTypeStr(Context context) {
        int netType = getNetType(context);
        if (netType != 1) {
            if (netType != 2) {
                if (netType != 3) {
                    if (netType != 4) {
                        if (netType != 5) {
                            return "";
                        }
                        return "wifi";
                    }
                    return "ctwap";
                }
                return "3gwap";
            }
            return "uniwap";
        }
        return "cmwap";
    }

    public static NetworkInfo getNetworkInfo(Context context) {
        try {
            return ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Exception unused) {
            return null;
        }
    }

    public static String getNetworkType(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                int type = NetworkMonitor.getType(activeNetworkInfo);
                if (type == 1) {
                    return "wifi";
                }
                if (type != 0) {
                    return "other";
                }
                switch (NetworkMonitor.getSubtype(activeNetworkInfo)) {
                    case 1:
                    case 2:
                        return QADNetStatus.G_2;
                    case 3:
                        return QADNetStatus.G_3;
                    case 4:
                        return QADNetStatus.G_2;
                    case 5:
                    case 6:
                    case 8:
                        return QADNetStatus.G_3;
                    case 7:
                    default:
                        return "other";
                }
            }
        } catch (Exception unused) {
        }
        return "unknown";
    }

    public static boolean isMobile(Context context) {
        int netType = getNetType(context);
        if (netType != 0 && netType != 5) {
            return true;
        }
        return false;
    }

    public static boolean isNetAvailable(Context context) {
        ConnectivityManager connectivityManager;
        NetworkInfo networkInfo;
        try {
            connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            networkInfo = getNetworkInfo(context);
        } catch (Exception unused) {
        }
        if (networkInfo != null) {
            return networkInfo.isAvailable();
        }
        for (NetworkInfo networkInfo2 : connectivityManager.getAllNetworkInfo()) {
            if (networkInfo2.isAvailable() && networkInfo2.isConnectedOrConnecting()) {
                return true;
            }
        }
        return false;
    }

    public static boolean isWifi(Context context) {
        if (getNetType(context) == 5) {
            return true;
        }
        return false;
    }

    public static final void safeClose(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    public static byte[] toBytes(InputStream inputStream) {
        try {
            return toBytesThrow(inputStream);
        } catch (Throwable th5) {
            th5.printStackTrace();
            return null;
        }
    }

    public static byte[] toBytesThrow(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        if (inputStream == null) {
            return null;
        }
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
        } catch (Throwable th5) {
            th = th5;
        }
        try {
            byte[] bArr = new byte[4096];
            while (true) {
                int read = inputStream.read(bArr, 0, 4096);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    byteArrayOutputStream.flush();
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    safeClose(byteArrayOutputStream);
                    return byteArray;
                }
            }
        } catch (Throwable th6) {
            th = th6;
            byteArrayOutputStream2 = byteArrayOutputStream;
            safeClose(byteArrayOutputStream2);
            throw th;
        }
    }

    public static void writeBytesWithoutClose(byte[] bArr, OutputStream outputStream) {
        if (bArr != null && bArr.length != 0 && outputStream != null) {
            try {
                outputStream.write(bArr);
            } catch (IOException e16) {
                e16.printStackTrace();
            }
        }
    }

    private static int getNetType(NetworkInfo networkInfo) {
        if (networkInfo == null || !networkInfo.isAvailable()) {
            return 0;
        }
        int type = NetworkMonitor.getType(networkInfo);
        if (type == 1) {
            return 5;
        }
        if (type != 0) {
            return 6;
        }
        String netGetExInfo = NetworkMonitor.netGetExInfo(networkInfo);
        if (TextUtils.isEmpty(netGetExInfo)) {
            return 6;
        }
        if (netGetExInfo.equalsIgnoreCase("cmwap")) {
            return 1;
        }
        if (netGetExInfo.equalsIgnoreCase("3gwap")) {
            return 3;
        }
        if (netGetExInfo.equalsIgnoreCase("uniwap")) {
            return 2;
        }
        return netGetExInfo.equalsIgnoreCase("ctwap") ? 4 : 3;
    }
}
