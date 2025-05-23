package com.tencent.qcircle.weseevideo.model.utils;

import android.support.annotation.Nullable;
import android.util.SparseArray;
import com.tencent.qcircle.tavcut.util.Logger;
import java.util.Collection;
import java.util.List;

/* compiled from: P */
/* loaded from: classes22.dex */
public class CollectionUtils {
    public static final int NOT_FIND_POSITION = -1;
    private static final String TAG = "CollectionUtils";

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public interface ElementCompare {
        boolean compared(Object obj);
    }

    public static <T> void add(Collection<T> collection, T t16) {
        if (collection != null && t16 != null) {
            collection.add(t16);
        }
    }

    @Nullable
    public static <T> List<T> checkListType(List list, Class<T> cls) {
        if (list == null || list.isEmpty() || !cls.isAssignableFrom(list.get(0).getClass())) {
            return null;
        }
        return list;
    }

    public static <T> T findElement(List<T> list, ElementCompare elementCompare) {
        int findPosition = findPosition(list, elementCompare);
        if (findPosition == -1) {
            return null;
        }
        return (T) obtain(list, findPosition);
    }

    public static <T> int findPosition(List<T> list, ElementCompare elementCompare) {
        if (list == null) {
            Logger.d(TAG, "findPosition() list == null.");
            return -1;
        }
        if (elementCompare == null) {
            Logger.d(TAG, "findPosition() compare == null");
            return -1;
        }
        for (int i3 = 0; i3 < list.size(); i3++) {
            if (elementCompare.compared(list.get(i3))) {
                return i3;
            }
        }
        return -1;
    }

    public static boolean isEmpty(Collection<?> collection) {
        if (collection != null && !collection.isEmpty()) {
            return false;
        }
        return true;
    }

    public static <T> T obtain(List<T> list, int i3) {
        if (list == null) {
            Logger.d(TAG, "obtain() list == null.");
            return null;
        }
        if (i3 < 0) {
            Logger.d(TAG, "obtain() position < 0.");
            return null;
        }
        if (i3 >= list.size()) {
            Logger.d(TAG, "obtain() position >= list.size().");
            return null;
        }
        return list.get(i3);
    }

    public static boolean outOfBounds(Collection collection, int i3) {
        return collection == null || i3 < 0 || i3 >= collection.size();
    }

    public static <T> void remove(Collection<T> collection, T t16) {
        if (collection != null && t16 != null) {
            collection.remove(t16);
        }
    }

    public static int size(Collection collection) {
        if (collection == null) {
            return 0;
        }
        return collection.size();
    }

    public static boolean outOfBounds(SparseArray sparseArray, int i3) {
        return sparseArray == null || i3 < 0 || i3 >= sparseArray.size();
    }
}
