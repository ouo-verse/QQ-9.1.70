package com.tencent.mobileqq.avatar.utils;

import android.text.TextUtils;
import com.tencent.ams.adcore.mma.api.Global;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes11.dex */
public class b {
    static IPatchRedirector $redirector_;

    public static int a(int i3) {
        return (i3 >>> 4) & 15;
    }

    public static String b(int i3) {
        if (i3 == 1) {
            return "actGetUserHead";
        }
        if (i3 != 4 && i3 != 8) {
            if (i3 == 11) {
                return "actGetUserHead";
            }
            if (i3 != 16 && i3 != 32) {
                return "actGetUserHead";
            }
            return "actGetNearbyHead";
        }
        return "actGetGroupHead";
    }

    public static String c(int i3) {
        String str;
        if (i3 != 4 && i3 != 8) {
            String b16 = b(i3);
            int systemNetwork = NetworkUtil.getSystemNetwork(BaseApplication.getContext());
            if (systemNetwork == 1) {
                str = Global.TRACKING_WIFI;
            } else if (systemNetwork == 2) {
                str = "2G";
            } else if (systemNetwork == 3) {
                str = "3G";
            } else if (systemNetwork == 4) {
                str = "4G";
            } else {
                str = "Unknown";
            }
            return b16 + str;
        }
        return "";
    }

    public static byte d(int i3) {
        if (i3 == 32) {
            return (byte) 1;
        }
        return (byte) 2;
    }

    public static long e(String str) {
        try {
            return new BigInteger(str).longValue();
        } catch (Exception unused) {
            if (QLog.isColorLevel()) {
                QLog.e("AvatarUtil", 2, "failed getLong, uin = " + str);
                return 0L;
            }
            return 0L;
        }
    }

    public static int f(int i3) {
        return i3 & 15;
    }

    public static int g(int i3, int i16) {
        if (i16 == 2 && i3 == 1) {
            return 8;
        }
        if (i3 == 1) {
            return 7;
        }
        return 6;
    }

    public static String h(long j3) {
        BigInteger valueOf = BigInteger.valueOf(j3);
        if (valueOf.signum() < 0) {
            valueOf = valueOf.add(BigInteger.ONE.shiftLeft(64));
        }
        return valueOf.toString();
    }

    public static String i(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        int lastIndexOf = str.lastIndexOf(95);
        if (lastIndexOf > 0) {
            return str.substring(lastIndexOf + 1);
        }
        return str;
    }

    public static <T> List<List<T>> j(List<T> list, int i3) {
        int i16;
        int i17;
        if (list != null && i3 >= 1) {
            int size = list.size();
            if (size % i3 == 0) {
                i16 = size / i3;
            } else {
                i16 = 1 + (size / i3);
            }
            ArrayList arrayList = new ArrayList();
            for (int i18 = 0; i18 < i16; i18++) {
                int i19 = i18 * i3;
                if (i18 == i16 - 1) {
                    i17 = size;
                } else {
                    i17 = (i18 + 1) * i3;
                }
                arrayList.add(list.subList(i19, i17));
            }
            return arrayList;
        }
        return null;
    }
}
