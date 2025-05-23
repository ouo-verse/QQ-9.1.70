package com.tencent.biz.richframework.order;

import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.part.utils.RFSafeListUtils;
import java.util.List;

/* compiled from: P */
/* loaded from: classes5.dex */
public class RFWElementOperateUtils {
    public static String getContextHashCodeCombineGroup(IOrderElement iOrderElement) {
        return iOrderElement.getContextHashCode() + "_" + iOrderElement.getGroup();
    }

    public static int partition(List<IOrderElement> list, int i3, int i16) {
        int i17 = i3 + 1;
        int i18 = i17;
        while (i17 <= i16) {
            if (list.get(i17).getPriority() > list.get(i3).getPriority()) {
                swap(list, i17, i18);
                i18++;
            }
            i17++;
        }
        int i19 = i18 - 1;
        swap(list, i3, i19);
        return i19;
    }

    public static void printList(List<IOrderElement> list) {
        if (RFSafeListUtils.isEmpty(list)) {
            return;
        }
        RFWLog.d("RFWElementOperateUtils", RFWLog.CLR, "[printList] list start");
        for (IOrderElement iOrderElement : list) {
            if (iOrderElement != null) {
                RFWLog.d("RFWElementOperateUtils", RFWLog.CLR, getContextHashCodeCombineGroup(iOrderElement) + " element =" + iOrderElement);
            }
        }
        RFWLog.d("RFWElementOperateUtils", RFWLog.CLR, "list end");
    }

    public static void quickSort(List<IOrderElement> list, int i3, int i16) {
        if (i3 < i16) {
            int partition = partition(list, i3, i16);
            quickSort(list, i3, partition - 1);
            quickSort(list, partition + 1, i16);
        }
    }

    public static void swap(List<IOrderElement> list, int i3, int i16) {
        IOrderElement iOrderElement = list.get(i3);
        list.set(i3, list.get(i16));
        list.set(i16, iOrderElement);
    }
}
