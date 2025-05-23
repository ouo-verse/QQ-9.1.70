package com.tencent.qqnt.emotion.utils;

import com.tencent.mobileqq.app.utils.DiySecureFileHelper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes24.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static final Map<String, Integer> f356685a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(47216);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f356685a = new HashMap();
        }
    }

    public static void a(String str, String str2, int i3) {
        int i16;
        String str3 = str + "_" + str2;
        Map<String, Integer> map = f356685a;
        synchronized (map) {
            if (map.containsKey(str3)) {
                i16 = map.get(str3).intValue();
            } else {
                i16 = -1;
            }
            if (i16 != i3) {
                BaseApplication.getContext().getSharedPreferences("StepUpdate", 4).edit().putInt(str3, i3).commit();
                map.put(str3, Integer.valueOf(i3));
            }
        }
    }

    public static int b(String str, String str2) {
        int i3;
        String str3 = str + "_" + str2;
        Map<String, Integer> map = f356685a;
        synchronized (map) {
            if (map.containsKey(str3)) {
                i3 = map.get(str3).intValue();
            } else {
                int i16 = BaseApplication.getContext().getSharedPreferences("StepUpdate", 4).getInt(str3, 0);
                map.put(str3, Integer.valueOf(i16));
                i3 = i16;
            }
        }
        return i3;
    }

    public static String c(String str) {
        if (str.length() > 4) {
            String substring = str.substring(4);
            if (QLog.isDevelopLevel()) {
                QLog.d(DiySecureFileHelper.TAG, 4, str + " -> " + substring);
            }
            return substring;
        }
        return str;
    }
}
