package com.tencent.biz.richframework.part.utils;

import com.tencent.biz.richframework.delegate.impl.RFWLog;
import java.util.List;

/* compiled from: P */
/* loaded from: classes5.dex */
public class RFSafeListUtils {
    public static <T> T get(List<T> list, int i3) {
        if (isEmpty(list)) {
            RFWLog.d("RFListUtils", RFWLog.USR, "[get] list should is empty.");
            return null;
        }
        if (i3 < 0) {
            RFWLog.d("RFListUtils", RFWLog.USR, "[get] list position < 0, handle fail.");
            return null;
        }
        if (i3 >= list.size()) {
            RFWLog.d("RFListUtils", RFWLog.USR, "[get] position >= list.size(), handle fail.");
            return null;
        }
        return list.get(i3);
    }

    public static <T> int getSize(List<T> list) {
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public static <T> boolean isEmpty(List<T> list) {
        if (list != null && !list.isEmpty()) {
            return false;
        }
        return true;
    }

    public static <T> void remove(List<T> list, int i3) {
        if (isEmpty(list)) {
            RFWLog.d("RFListUtils", RFWLog.USR, "[remove] list should is empty.");
            return;
        }
        if (i3 < 0) {
            RFWLog.d("RFListUtils", RFWLog.USR, "[remove] list position < 0, handle fail.");
        } else if (i3 >= list.size()) {
            RFWLog.d("RFListUtils", RFWLog.USR, "[remove] position >= list.size(), handle fail.");
        } else {
            list.remove(i3);
        }
    }
}
