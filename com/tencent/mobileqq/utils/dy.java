package com.tencent.mobileqq.utils;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes20.dex */
public class dy {
    public static String a(String str, String str2, String[] strArr) {
        StringBuilder sb5 = new StringBuilder(120);
        sb5.append("DELETE FROM ");
        sb5.append(str);
        if (!TextUtils.isEmpty(str2)) {
            sb5.append(" WHERE ");
            sb5.append(str2);
            sb5.append(" whereArgs ");
            sb5.append(Arrays.toString(strArr));
        }
        return sb5.toString();
    }

    public static String b(String str, ContentValues contentValues) {
        if (contentValues != null && contentValues.size() > 0) {
            StringBuilder sb5 = new StringBuilder(120);
            StringBuilder sb6 = new StringBuilder(120);
            sb6.append("INSERT INTO ");
            sb6.append(SQLiteDatabase.findEditTable(str));
            sb6.append(" (");
            int i3 = 0;
            for (Map.Entry<String, Object> entry : contentValues.valueSet()) {
                if (i3 > 0) {
                    sb6.append(',');
                    sb5.append(',');
                }
                sb6.append(entry.getKey());
                sb5.append(entry.getValue());
                i3++;
            }
            sb6.append(") VALUES (");
            sb6.append((CharSequence) sb5);
            sb6.append(")");
            return sb6.toString();
        }
        QLog.d("SQLUtils", 1, "buildInsert Empty values");
        return "";
    }

    public static String c(String str, ContentValues contentValues, String str2) {
        int i3;
        String str3;
        Object value;
        StringBuilder sb5 = new StringBuilder();
        StringBuilder sb6 = new StringBuilder();
        sb6.append("INSERT");
        sb6.append(" INTO ");
        sb6.append(str);
        sb6.append('(');
        int i16 = 0;
        if (contentValues != null && contentValues.size() > 0) {
            i3 = contentValues.size();
        } else {
            i3 = 0;
        }
        if (i3 > 0) {
            for (Map.Entry<String, Object> entry : contentValues.valueSet()) {
                if (i16 > 0) {
                    str3 = ",";
                } else {
                    str3 = "";
                }
                sb6.append(str3);
                sb6.append(entry.getKey());
                if (i16 > 0) {
                    value = "," + entry.getValue();
                } else {
                    value = entry.getValue();
                }
                sb5.append(value);
                i16++;
            }
            sb6.append(')');
            sb6.append(" VALUES (");
            sb6.append((CharSequence) sb5);
        } else {
            sb6.append(str2);
            sb6.append(") VALUES (NULL");
        }
        sb6.append(')');
        return sb6.toString();
    }

    public static String d(String str, ContentValues contentValues, String[] strArr, String str2) {
        String str3;
        StringBuilder sb5 = new StringBuilder(120);
        sb5.append("UPDATE ");
        sb5.append(str);
        sb5.append(" SET ");
        int i3 = 0;
        for (String str4 : contentValues.keySet()) {
            if (i3 > 0) {
                str3 = ",";
            } else {
                str3 = "";
            }
            sb5.append(str3);
            sb5.append(str4);
            sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
            sb5.append(contentValues.get(str4));
            i3++;
        }
        if (!TextUtils.isEmpty(str2)) {
            sb5.append(" WHERE ");
            sb5.append(str2);
        }
        if (strArr != null) {
            sb5.append(" whereArgs ");
            sb5.append(Arrays.toString(strArr));
        }
        return sb5.toString();
    }

    public static String e(String str) {
        Matcher matcher = Pattern.compile("(?:FROM|JOIN|UPDATE|INTO|TABLE|DROP\\s+TABLE\\s+IF\\s+EXISTS|CREATE\\s+TABLE\\s+IF\\s+NOT\\s+EXISTS)\\s+([a-zA-Z0-9_]+)", 2).matcher(str);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return "";
    }
}
