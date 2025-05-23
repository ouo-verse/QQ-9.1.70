package com.tencent.mobileqq.guild.util;

import com.tencent.qphone.base.util.QLog;
import java.math.BigDecimal;

/* compiled from: P */
/* loaded from: classes14.dex */
public class al {
    public static String a(long j3) {
        if (j3 < 1000) {
            return j3 + "";
        }
        if (QLog.isColorLevel()) {
            QLog.d("GuildNumberUtil", 2, "getFormatNumber ori: " + j3);
        }
        double d16 = j3;
        if (d16 < 1000000.0d) {
            return b(j3 + "", ",", 3).toString();
        }
        if (d16 < 1.0E10d) {
            StringBuilder b16 = b(new BigDecimal(d16 / 10000.0d).setScale(1, 3).toString(), ",", 3);
            if (QLog.isColorLevel()) {
                QLog.d("GuildNumberUtil", 2, "getFormatNumber split: " + b16.toString());
            }
            b16.append("\u4e07");
            return b16.toString();
        }
        StringBuilder b17 = b(new BigDecimal(d16).divide(new BigDecimal(1.0E8d)).setScale(1, 4).toString(), ",", 3);
        if (QLog.isColorLevel()) {
            QLog.d("GuildNumberUtil", 2, "getFormatNumber split: " + b17.toString());
        }
        b17.append("\u4ebf");
        return b17.toString();
    }

    private static StringBuilder b(String str, CharSequence charSequence, int i3) {
        int i16;
        int length = str.length() - 1;
        StringBuilder sb5 = new StringBuilder();
        int indexOf = str.indexOf(46);
        if (indexOf != -1) {
            i16 = indexOf - 1;
        } else {
            i16 = length;
        }
        while (length >= 0) {
            if (i16 <= length) {
                sb5.insert(0, str.charAt(length));
            } else {
                if ((i16 - length) % i3 == 0) {
                    sb5.insert(0, charSequence);
                }
                sb5.insert(0, str.charAt(length));
            }
            length--;
        }
        return sb5;
    }
}
