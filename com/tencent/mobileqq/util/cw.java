package com.tencent.mobileqq.util;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes20.dex */
public class cw {
    public static String a(String str, String str2, String str3) {
        if (!str2.equals(str3)) {
            return str.replace("\"" + str2 + "\"", str3);
        }
        return str;
    }

    public static String b(String str, QQAppInterface qQAppInterface) {
        String g16;
        List<String> f16 = f(str);
        if (f16.size() > 0) {
            String str2 = str;
            for (int i3 = 0; i3 < f16.size(); i3++) {
                String str3 = f16.get(i3);
                String str4 = "\"" + str3 + "\"";
                if (str.indexOf(str4) + str4.length() == str.length()) {
                    g16 = com.tencent.mobileqq.utils.ac.g0(qQAppInterface, str3, true);
                } else {
                    g16 = com.tencent.mobileqq.utils.ac.g(qQAppInterface, str3, true);
                }
                str2 = a(str2, str3, g16);
            }
            return str2;
        }
        return str;
    }

    public static String c(String str) {
        Matcher matcher = Pattern.compile("\"\\d+\"", 2).matcher(str);
        if (matcher.find()) {
            return matcher.group();
        }
        return null;
    }

    public static String d(Context context, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(String.valueOf(AppConstants.SYSTEM_MSG_UIN), 0);
        String str2 = "troop_answer_" + str;
        if (!sharedPreferences.contains(str2)) {
            return null;
        }
        return sharedPreferences.getString(str2, null);
    }

    public static String e(String str) {
        Matcher matcher = Pattern.compile("\\d+", 2).matcher(str);
        String str2 = null;
        while (matcher.find()) {
            str2 = matcher.group();
        }
        return str2;
    }

    private static List<String> f(String str) {
        Pattern compile = Pattern.compile("\"\\d+\"", 2);
        Pattern compile2 = Pattern.compile("\\d+", 2);
        ArrayList arrayList = new ArrayList();
        Matcher matcher = compile.matcher(str);
        while (matcher.find()) {
            Matcher matcher2 = compile2.matcher(matcher.group());
            while (matcher2.find()) {
                arrayList.add(matcher2.group());
            }
        }
        return arrayList;
    }
}
