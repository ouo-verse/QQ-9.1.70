package com.tencent.open.base;

import android.content.Context;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import com.tencent.ams.adcore.mma.api.Global;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.qmethod.pandoraex.monitor.ContactsMonitor;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes22.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    protected static final String f340969a = "com.tencent.open.base.a";

    /* renamed from: b, reason: collision with root package name */
    protected static Uri f340970b = Uri.parse("content://telephony/carriers/preferapn");

    public static boolean a(Context context) {
        ConnectivityManager connectivityManager;
        try {
            connectivityManager = (ConnectivityManager) BaseApplication.context.getSystemService("connectivity");
        } catch (Exception e16) {
            QLog.e(f340969a, 1, "checkNetWork Exception", e16);
        }
        if (connectivityManager == null) {
            return true;
        }
        NetworkInfo[] allNetworkInfo = connectivityManager.getAllNetworkInfo();
        if (allNetworkInfo != null) {
            for (NetworkInfo networkInfo : allNetworkInfo) {
                if (networkInfo.isConnectedOrConnecting()) {
                    return true;
                }
            }
        }
        return false;
    }

    public static String b(Context context) {
        return AppNetConnInfo.getCurrentAPN();
    }

    public static String c(Context context) {
        int g16 = g(context);
        if (g16 == 2) {
            return "wifi";
        }
        if (g16 == 1) {
            return "cmwap";
        }
        if (g16 == 4) {
            return "cmnet";
        }
        if (g16 == 16) {
            return "uniwap";
        }
        if (g16 == 8) {
            return "uninet";
        }
        if (g16 == 64) {
            return "wap";
        }
        if (g16 == 32) {
            return "net";
        }
        if (g16 == 512) {
            return "ctwap";
        }
        if (g16 == 256) {
            return "ctnet";
        }
        if (g16 == 2048) {
            return "3gnet";
        }
        if (g16 == 1024) {
            return "3gwap";
        }
        String b16 = b(context);
        if (b16 != null && b16.length() != 0) {
            return b16;
        }
        return "none";
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0054  */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v2, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String d(Context context) {
        Exception e16;
        Cursor cursor;
        String str = "80";
        ?? r16 = 0;
        String str2 = null;
        try {
            try {
                cursor = ContactsMonitor.query(context.getContentResolver(), f340970b, null, null, null, null);
                if (cursor == null) {
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                }
                try {
                    cursor.moveToFirst();
                    if (cursor.isAfterLast()) {
                        cursor.close();
                        cursor.close();
                        return "80";
                    }
                    int columnIndex = cursor.getColumnIndex("port");
                    if (columnIndex >= 0) {
                        str2 = cursor.getString(columnIndex);
                    }
                    if (str2 != null) {
                        str = str2;
                    }
                    cursor.close();
                    return str;
                } catch (Exception e17) {
                    e16 = e17;
                    e16.printStackTrace();
                    if (cursor != null) {
                        cursor.close();
                    }
                    return "80";
                }
            } catch (Exception e18) {
                e16 = e18;
                cursor = null;
            } catch (Throwable th5) {
                th = th5;
                if (r16 != 0) {
                }
                throw th;
            }
        } catch (Throwable th6) {
            th = th6;
            r16 = context;
            if (r16 != 0) {
                r16.close();
            }
            throw th;
        }
    }

    public static int e(Context context) {
        Cursor cursor = null;
        try {
            try {
                Cursor query = ContactsMonitor.query(context.getContentResolver(), f340970b, null, null, null, null);
                if (query == null) {
                    if (query != null) {
                        query.close();
                    }
                    return -1;
                }
                query.moveToFirst();
                int i3 = query.getInt(query.getColumnIndex("port"));
                query.close();
                return i3;
            } catch (Exception e16) {
                e16.printStackTrace();
                if (0 != 0) {
                    cursor.close();
                }
                return -1;
            }
        } catch (Throwable th5) {
            if (0 != 0) {
                cursor.close();
            }
            throw th5;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0045  */
    /* JADX WARN: Type inference failed for: r8v0, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v5, types: [android.database.Cursor] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String f(Context context) {
        Throwable th5;
        Exception e16;
        Cursor cursor;
        try {
            try {
                cursor = ContactsMonitor.query(context.getContentResolver(), f340970b, null, null, null, null);
            } catch (Exception e17) {
                e16 = e17;
                cursor = null;
            } catch (Throwable th6) {
                th5 = th6;
                context = 0;
                if (context != 0) {
                }
                throw th5;
            }
            if (cursor == null) {
                if (cursor != null) {
                    cursor.close();
                }
                return null;
            }
            try {
                cursor.moveToFirst();
                int columnIndex = cursor.getColumnIndex("proxy");
                if (columnIndex >= 0) {
                    String string = cursor.getString(columnIndex);
                    cursor.close();
                    return string;
                }
            } catch (Exception e18) {
                e16 = e18;
                e16.printStackTrace();
                if (cursor == null) {
                    return "";
                }
                cursor.close();
                return "";
            }
            cursor.close();
            return "";
        } catch (Throwable th7) {
            th5 = th7;
            if (context != 0) {
                context.close();
            }
            throw th5;
        }
    }

    public static int g(Context context) {
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        try {
            connectivityManager = (ConnectivityManager) BaseApplication.context.getSystemService("connectivity");
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
        if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
            return 128;
        }
        if (NetworkMonitor.getTypeName(activeNetworkInfo).toUpperCase().equals(Global.TRACKING_WIFI)) {
            return 2;
        }
        String lowerCase = NetworkMonitor.netGetExInfo(activeNetworkInfo).toLowerCase();
        if (lowerCase.startsWith("cmwap")) {
            return 1;
        }
        if (!lowerCase.startsWith("cmnet") && !lowerCase.startsWith("epc.tmobile.com")) {
            if (lowerCase.startsWith("uniwap")) {
                return 16;
            }
            if (lowerCase.startsWith("uninet")) {
                return 8;
            }
            if (lowerCase.startsWith("wap")) {
                return 64;
            }
            if (lowerCase.startsWith("net")) {
                return 32;
            }
            if (lowerCase.startsWith("ctwap")) {
                return 512;
            }
            if (lowerCase.startsWith("ctnet")) {
                return 256;
            }
            if (lowerCase.startsWith("3gwap")) {
                return 1024;
            }
            if (lowerCase.startsWith("3gnet")) {
                return 2048;
            }
            if (lowerCase.startsWith("#777")) {
                String f16 = f(context);
                if (f16 != null) {
                    if (f16.length() > 0) {
                        return 512;
                    }
                }
                return 256;
            }
            return 128;
        }
        return 4;
    }

    public static String h(Context context) {
        NetworkInfo activeNetworkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) BaseApplication.context.getSystemService("connectivity");
        if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
            return "MOBILE";
        }
        return NetworkMonitor.getTypeName(activeNetworkInfo);
    }

    public static boolean i(Context context) {
        int g16 = g(context);
        if (g16 == 1 || g16 == 16 || g16 == 64 || g16 == 512 || g16 == 1024) {
            return true;
        }
        return false;
    }

    public static boolean j(Context context) {
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        if (context == null || (connectivityManager = (ConnectivityManager) BaseApplication.context.getSystemService("connectivity")) == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || !activeNetworkInfo.isAvailable()) {
            return false;
        }
        return true;
    }

    public static boolean k(Context context) {
        return AppNetConnInfo.isWifiConn();
    }
}
