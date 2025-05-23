package com.tencent.biz.qqcircle.utils;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes5.dex */
public class cw {
    public static int a(String str, String str2) {
        int parseInt;
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return -2;
        }
        if (TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            return -1;
        }
        if (!TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return 1;
        }
        String trim = str.trim();
        String trim2 = str2.trim();
        String[] split = trim.split("\\.");
        String[] split2 = trim2.split("\\.");
        if (split.length != 0 && split2.length != 0) {
            ArrayList arrayList = new ArrayList(Arrays.asList(split));
            ArrayList arrayList2 = new ArrayList(Arrays.asList(split2));
            try {
                for (int size = arrayList.size() - 1; size >= 0 && Integer.parseInt((String) arrayList.get(size)) == 0; size--) {
                    arrayList.remove(size);
                }
                for (int size2 = arrayList2.size() - 1; size2 >= 0 && Integer.parseInt((String) arrayList2.get(size2)) == 0; size2--) {
                    arrayList2.remove(size2);
                }
                int i3 = 0;
                while (i3 < arrayList.size()) {
                    int parseInt2 = Integer.parseInt((String) arrayList.get(i3));
                    int i16 = i3 + 1;
                    if (arrayList2.size() < i16 || parseInt2 > (parseInt = Integer.parseInt((String) arrayList2.get(i3)))) {
                        return 1;
                    }
                    if (parseInt2 != parseInt && parseInt2 < parseInt) {
                        return -1;
                    }
                    i3 = i16;
                }
                if (arrayList2.size() > arrayList.size()) {
                    return -1;
                }
                return 0;
            } catch (Exception e16) {
                QLog.e("VersionUtil", 1, "compareVersion fail e:" + e16.toString());
            }
        }
        return -2;
    }
}
