package com.heytap.databaseengine.utils;

import java.util.List;

/* compiled from: P */
/* loaded from: classes2.dex */
public class AlertNullOrEmptyUtil {
    public static boolean isNullOrEmpty(String str) {
        return str == null || str.isEmpty();
    }

    public static <T> boolean isNullOrEmpty(List<T> list) {
        return list == null || list.isEmpty();
    }
}
