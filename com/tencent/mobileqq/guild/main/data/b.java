package com.tencent.mobileqq.guild.main.data;

import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes14.dex */
public class b {
    public static List<Integer> a(@NonNull List<Object> list) {
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (obj instanceof List) {
                for (Object obj2 : (List) obj) {
                    if (obj2 instanceof Integer) {
                        arrayList.add((Integer) obj2);
                    }
                }
            }
        }
        return arrayList;
    }
}
