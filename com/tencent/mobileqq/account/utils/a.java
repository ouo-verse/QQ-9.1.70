package com.tencent.mobileqq.account.utils;

import android.text.TextUtils;
import com.tencent.mobileqq.account.bean.QQAccount;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.remote.SimpleAccount;
import java.util.List;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes9.dex */
public class a {
    static IPatchRedirector $redirector_;

    public static int a() {
        List<SimpleAccount> allAccounts = MobileQQ.sMobileQQ.getAllAccounts();
        if (allAccounts != null) {
            return allAccounts.size();
        }
        return 0;
    }

    public static String b(String str) {
        int i3;
        if (str != null && str.length() > 4) {
            int length = str.length();
            StringBuilder sb5 = new StringBuilder();
            int i16 = 5;
            int i17 = 1;
            if (length <= 5) {
                i16 = 4;
                i3 = 1;
            } else if (length <= 9) {
                i3 = (length - 5) / 2;
            } else {
                i3 = (length - 6) / 2;
                i16 = 6;
            }
            if (i3 > 0) {
                i17 = i3;
            }
            sb5.append(str.substring(0, i17));
            for (int i18 = 0; i18 < i16; i18++) {
                sb5.append("*");
            }
            int i19 = i17 + i16;
            if (i19 < length) {
                sb5.append(str.substring(i19));
            }
            return sb5.toString();
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    public static SimpleAccount c(String str) {
        List<SimpleAccount> allAccounts = MobileQQ.sMobileQQ.getAllAccounts();
        if (allAccounts == null) {
            return null;
        }
        for (SimpleAccount simpleAccount : allAccounts) {
            if (simpleAccount != null && TextUtils.equals(str, simpleAccount.getUin())) {
                return simpleAccount;
            }
        }
        return null;
    }

    public static boolean d(List<QQAccount> list, List<QQAccount> list2) {
        int i3;
        int i16;
        if (list == list2) {
            return false;
        }
        if (list != null) {
            i3 = list.size();
        } else {
            i3 = 0;
        }
        if (list2 != null) {
            i16 = list2.size();
        } else {
            i16 = 0;
        }
        if (i3 != i16) {
            return true;
        }
        for (int i17 = 0; i17 < i3; i17++) {
            if (!list.get(i17).equals(list2.get(i17))) {
                return true;
            }
        }
        return false;
    }
}
