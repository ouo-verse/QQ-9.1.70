package com.huawei.hms.hatool;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.Pair;
import com.tencent.bugly.common.utils.DeviceInfoUtil;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import java.lang.reflect.InvocationTargetException;

/* compiled from: P */
/* loaded from: classes2.dex */
public class x0 extends o {
    public static String c() {
        String str;
        String str2 = "";
        try {
            String str3 = (String) Class.forName("com.huawei.android.os.BuildEx").getMethod("getUDID", new Class[0]).invoke(null, new Object[0]);
            try {
                v.c("hmsSdk", "getUDID success");
                return str3;
            } catch (AndroidRuntimeException unused) {
                str2 = str3;
                str = "getUDID getudid failed, RuntimeException is AndroidRuntimeException";
                v.f("hmsSdk", str);
                return str2;
            } catch (ClassNotFoundException unused2) {
                str2 = str3;
                str = "getUDID method invoke failed";
                v.f("hmsSdk", str);
                return str2;
            } catch (IllegalAccessException unused3) {
                str2 = str3;
                str = "getUDID method invoke failed : Illegal AccessException";
                v.f("hmsSdk", str);
                return str2;
            } catch (IllegalArgumentException unused4) {
                str2 = str3;
                str = "getUDID method invoke failed : Illegal ArgumentException";
                v.f("hmsSdk", str);
                return str2;
            } catch (NoSuchMethodException unused5) {
                str2 = str3;
                str = "getUDID method invoke failed : NoSuchMethodException";
                v.f("hmsSdk", str);
                return str2;
            } catch (InvocationTargetException unused6) {
                str2 = str3;
                str = "getUDID method invoke failed : InvocationTargetException";
                v.f("hmsSdk", str);
                return str2;
            }
        } catch (AndroidRuntimeException unused7) {
        } catch (ClassNotFoundException unused8) {
        } catch (IllegalAccessException unused9) {
        } catch (IllegalArgumentException unused10) {
        } catch (NoSuchMethodException unused11) {
        } catch (InvocationTargetException unused12) {
        }
    }

    public static Pair<String, String> e(Context context) {
        if (c0.a(context, DeviceInfoUtil.PERMISSION_READ_PHONE)) {
            v.f("hmsSdk", "getMccAndMnc() Pair value is empty");
            return new Pair<>("", "");
        }
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager == null) {
            return new Pair<>("", "");
        }
        if (telephonyManager.getSimState() != 5) {
            return new Pair<>("", "");
        }
        String networkOperator = DeviceInfoMonitor.getNetworkOperator(telephonyManager);
        if (!TextUtils.isEmpty(networkOperator) && !TextUtils.equals(networkOperator, "null")) {
            if (networkOperator.length() > 3) {
                return new Pair<>(networkOperator.substring(0, 3), networkOperator.substring(3));
            }
            return new Pair<>("", "");
        }
        return new Pair<>("", "");
    }
}
