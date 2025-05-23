package com.tencent.gamematrix.gmcg.base.utils;

import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: P */
/* loaded from: classes6.dex */
public class CGCollectionUtil {
    @NonNull
    public static <T> List<T> getSnapshot(@NonNull Collection<T> collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        for (T t16 : collection) {
            if (t16 != null) {
                arrayList.add(t16);
            }
        }
        return arrayList;
    }
}
