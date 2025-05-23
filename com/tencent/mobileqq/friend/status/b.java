package com.tencent.mobileqq.friend.status;

import android.text.TextUtils;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c;
import java.util.Arrays;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes12.dex */
public class b {
    static IPatchRedirector $redirector_;

    public static int a(int i3, int i16) {
        int i17;
        boolean z16;
        HashMap hashMap = new HashMap();
        hashMap.put(-55, 8);
        hashMap.put(201, 8);
        hashMap.put(10, 4);
        hashMap.put(-6, 0);
        hashMap.put(250, 0);
        hashMap.put(20, 0);
        hashMap.put(40, 0);
        hashMap.put(95, 0);
        hashMap.put(100, 0);
        hashMap.put(101, 0);
        hashMap.put(30, 1);
        hashMap.put(50, 2);
        hashMap.put(60, 3);
        hashMap.put(70, 7);
        hashMap.put(90, 4);
        hashMap.put(91, 4);
        if (hashMap.containsKey(Integer.valueOf(i3))) {
            i17 = ((Integer) hashMap.get(Integer.valueOf(i3))).intValue();
        } else {
            i17 = 0;
        }
        if (i16 != 69378 && i16 != 73474 && i16 != 73730) {
            z16 = false;
        } else {
            z16 = true;
        }
        Integer[] numArr = {0, 1, 2, 7, 6, 3, 4};
        if (z16) {
            return 0;
        }
        if (!Arrays.asList(numArr).contains(Integer.valueOf(i17)) && a.c().d(i16)) {
            return 4;
        }
        return i17;
    }

    @Deprecated
    public static int b(Friends friends) {
        int a16 = a(friends.detalStatusFlag, friends.iTermType);
        if (a16 == 1) {
            return 2;
        }
        if (a16 != 2) {
            if (a16 != 3 && a16 != 4) {
                if (a16 != 7) {
                    return ((int) friends.getLastLoginType()) + 20;
                }
            } else {
                return 0;
            }
        }
        return 1;
    }

    public static String c() {
        int netWorkTypeContain5G = HttpUtil.getNetWorkTypeContain5G();
        if (netWorkTypeContain5G != 1) {
            if (netWorkTypeContain5G != 2) {
                if (netWorkTypeContain5G != 3) {
                    if (netWorkTypeContain5G != 4) {
                        if (netWorkTypeContain5G != 6) {
                            return "";
                        }
                        return " - 5G";
                    }
                    return " - 4G";
                }
                return " - 3G";
            }
            return " - 2G";
        }
        return " - WiFi";
    }

    public static boolean d(int i3, int i16, byte b16, String str) {
        if ((i3 == 0 && i16 == 0) || (a(b16, i3) == 0 && !TextUtils.isEmpty(str) && str.contains("TIM"))) {
            return true;
        }
        return false;
    }

    public static boolean e(c cVar) {
        if ((cVar.z() == 0 && cVar.E() == 0) || (a(cVar.u(), cVar.z()) == 0 && !TextUtils.isEmpty(cVar.c0()) && cVar.c0().contains("TIM"))) {
            return true;
        }
        return false;
    }
}
