package com.tencent.wstt.SSCM;

import android.content.Context;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Process;
import android.telephony.TelephonyManager;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* compiled from: P */
/* loaded from: classes27.dex */
public class c {
    static IPatchRedirector $redirector_;

    public static int a(Object obj) {
        if (obj == null) {
            return -1;
        }
        try {
            try {
                Method declaredMethod = obj.getClass().getDeclaredMethod("getDefaultDataSubId", new Class[0]);
                declaredMethod.setAccessible(true);
                return ((Integer) declaredMethod.invoke(obj, new Object[0])).intValue();
            } catch (NoSuchMethodException unused) {
                Method declaredMethod2 = obj.getClass().getDeclaredMethod("getDefaultDataSubscriptionId", new Class[0]);
                declaredMethod2.setAccessible(true);
                return ((Integer) declaredMethod2.invoke(obj, new Object[0])).intValue();
            } catch (Exception e16) {
                QLog.w("SSCM.Utils", 1, "getDefaultDataSubId excep!", e16);
                return -1;
            }
        } catch (Exception e17) {
            QLog.w("SSCM.Utils", 1, "getDefaultDataSubscriptionId excep!", e17);
            return -1;
        }
    }

    public static final int b(Context context) {
        TelephonyManager createForSubscriptionId;
        int networkType;
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        NetworkInfo recentNetworkInfo = AppNetConnInfo.getRecentNetworkInfo();
        long currentTimeMillis = System.currentTimeMillis();
        int a16 = a(d(telephonyManager));
        if (recentNetworkInfo != null) {
            networkType = NetworkMonitor.getSubtype(recentNetworkInfo);
        } else {
            if (a16 != -1) {
                try {
                    if (Build.VERSION.SDK_INT >= 24) {
                        createForSubscriptionId = telephonyManager.createForSubscriptionId(a16);
                        networkType = NetworkMonitor.getNetworkType(createForSubscriptionId);
                    }
                } catch (Exception e16) {
                    QLog.e("SSCM.Utils", 1, "getNetworkType excep!", e16);
                    networkType = 0;
                }
            }
            networkType = NetworkMonitor.getNetworkType(telephonyManager);
        }
        QLog.d("SSCM.Utils", 1, "getNetworkType:" + networkType + " ,simID:" + a16 + " ,cost:" + (System.currentTimeMillis() - currentTimeMillis));
        if (networkType != 1 && networkType != 2 && networkType != 4) {
            return 1;
        }
        return 2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:34:0x008d A[Catch: IOException -> 0x0089, TRY_LEAVE, TryCatch #0 {IOException -> 0x0089, blocks: (B:41:0x0085, B:34:0x008d), top: B:40:0x0085 }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0085 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v8, types: [java.io.BufferedReader] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String c() {
        ?? r06;
        FileReader fileReader;
        IOException e16;
        BufferedReader bufferedReader;
        String str = "/proc/" + String.valueOf(Process.myPid()) + "/net/netstat";
        String str2 = "0";
        FileReader fileReader2 = null;
        try {
        } catch (IOException e17) {
            e17.printStackTrace();
        }
        try {
            try {
                fileReader = new FileReader(str);
            } catch (IOException e18) {
                fileReader = null;
                e16 = e18;
                bufferedReader = null;
            } catch (Throwable th5) {
                th = th5;
                r06 = 0;
                if (fileReader2 != null) {
                }
                if (r06 != 0) {
                }
                throw th;
            }
            try {
                bufferedReader = new BufferedReader(fileReader, 8192);
            } catch (IOException e19) {
                e16 = e19;
                bufferedReader = null;
            } catch (Throwable th6) {
                th = th6;
                str = null;
                fileReader2 = fileReader;
                r06 = str;
                if (fileReader2 != null) {
                    try {
                        fileReader2.close();
                    } catch (IOException e26) {
                        e26.printStackTrace();
                        throw th;
                    }
                }
                if (r06 != 0) {
                    r06.close();
                }
                throw th;
            }
            try {
                bufferedReader.readLine();
                bufferedReader.readLine();
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    readLine = bufferedReader.readLine();
                }
                if (readLine != null) {
                    String[] split = readLine.split(" ");
                    if (split.length >= 9) {
                        str2 = split[8];
                    } else {
                        str2 = "-1";
                    }
                }
                fileReader.close();
                bufferedReader.close();
            } catch (IOException e27) {
                e16 = e27;
                e16.printStackTrace();
                if (fileReader != null) {
                    fileReader.close();
                }
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                return str2;
            }
            return str2;
        } catch (Throwable th7) {
            th = th7;
        }
    }

    public static Object d(TelephonyManager telephonyManager) {
        try {
            Field declaredField = TelephonyManager.class.getDeclaredField("mSubscriptionManager");
            declaredField.setAccessible(true);
            return declaredField.get(telephonyManager);
        } catch (Exception e16) {
            QLog.w("SSCM.Utils", 1, "getSubscriptionManager excep!", e16);
            return null;
        }
    }
}
