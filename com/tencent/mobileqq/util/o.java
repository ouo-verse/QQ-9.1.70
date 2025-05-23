package com.tencent.mobileqq.util;

import android.content.Context;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.text.format.Time;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import java.util.ArrayList;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes20.dex */
public class o {
    public static final Uri a() {
        String string = PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext()).getString(AppConstants.Preferences.LAST_SCREEN_SHOT_URI, "");
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        return Uri.parse(string);
    }

    public static String b(ArrayList<String> arrayList, boolean z16) {
        String obj;
        Time time = new Time();
        time.setToNow();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("com.tencent.process.exit");
        sb5.append(time.year);
        sb5.append(time.month + 1);
        sb5.append(time.monthDay);
        sb5.append(time.hour);
        if (z16) {
            sb5.append(time.minute - 1);
        } else {
            sb5.append(time.minute);
        }
        if (arrayList == null) {
            obj = "null";
        } else {
            obj = arrayList.toString();
        }
        sb5.append(obj);
        return MD5.toMD5(MD5.toMD5(sb5.toString()) + sb5.toString());
    }

    public static boolean c(ArrayList<String> arrayList, Context context) {
        if (arrayList == null || arrayList.size() == 0) {
            return true;
        }
        String str = MobileQQ.processName;
        if (str != null) {
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                if (str.equals(arrayList.get(i3))) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean d(long j3, long j16) {
        if (j3 == 0 || j16 == 0) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis < j3 || currentTimeMillis > j16) {
            return false;
        }
        return true;
    }

    public static boolean e(String str, ArrayList<String> arrayList) {
        if (str == null || str.length() == 0) {
            return false;
        }
        if (!str.equals(b(arrayList, false)) && !str.equals(b(arrayList, true))) {
            return false;
        }
        return true;
    }
}
