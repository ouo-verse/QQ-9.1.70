package com.tencent.tmassistantbase.util;

import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes26.dex */
public class b {
    public static <T> boolean a(List<T> list) {
        return list == null || list.size() <= 0;
    }

    public static <T> String b(List<T> list) {
        if (list == null) {
            return "NULL";
        }
        StringBuilder sb5 = new StringBuilder("size = ");
        sb5.append(list.size());
        sb5.append("data = [");
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            sb5.append(list.get(i3));
            if (i3 < size - 1) {
                sb5.append(",");
            }
        }
        sb5.append("]");
        return sb5.toString();
    }

    public static <T, S> String a(Map<T, S> map, String str) {
        if (a(map)) {
            return "";
        }
        Set<T> keySet = map.keySet();
        int size = keySet.size();
        StringBuilder sb5 = new StringBuilder();
        int i3 = 0;
        for (T t16 : keySet) {
            sb5.append(t16);
            sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
            sb5.append(map.get(t16));
            if (i3 < size - 1) {
                sb5.append(str);
            }
            i3++;
        }
        return sb5.toString();
    }

    public static Map<String, String> a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] split = str.split(str2);
        HashMap hashMap = new HashMap();
        for (String str3 : split) {
            try {
                hashMap.put(str3.substring(0, str3.indexOf(ContainerUtils.KEY_VALUE_DELIMITER)), str3.substring(str3.indexOf(ContainerUtils.KEY_VALUE_DELIMITER) + 1));
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
        return hashMap;
    }

    public static <T, S> boolean a(Map<T, S> map) {
        return map == null || map.size() <= 0;
    }
}
