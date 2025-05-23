package com.qq.e.comm.plugin.k;

import android.text.TextUtils;
import android.util.SparseArray;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes3.dex */
public class g {
    public static boolean a(Object[] objArr) {
        return objArr != null && objArr.length > 0;
    }

    public static boolean b(Object[] objArr) {
        return objArr == null || objArr.length == 0;
    }

    public static boolean a(List list) {
        return list != null && list.size() > 0;
    }

    public static boolean b(List list) {
        return list == null || list.size() == 0;
    }

    public static boolean a(SparseArray sparseArray) {
        return sparseArray == null || sparseArray.size() == 0;
    }

    public static boolean a(Set set) {
        return set == null || set.size() == 0;
    }

    public static boolean a(String[] strArr) {
        return strArr == null || strArr.length == 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> List<T> a(List<T> list, T t16) {
        if (((t16 instanceof String) && !TextUtils.isEmpty((String) t16)) || t16 != 0) {
            if (list == null) {
                list = new ArrayList<>();
            }
            list.add(t16);
        }
        return list;
    }
}
