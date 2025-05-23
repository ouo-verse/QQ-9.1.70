package com.tencent.imcore.message;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes7.dex */
public class ap {
    static IPatchRedirector $redirector_;

    @NonNull
    private static List<Integer> a(Field[] fieldArr) {
        ArrayList arrayList = new ArrayList();
        for (Field field : fieldArr) {
            if (field.getName().startsWith("UIN_TYPE_")) {
                try {
                    arrayList.add((Integer) field.get(null));
                } catch (IllegalAccessException e16) {
                    e16.printStackTrace();
                }
            }
        }
        return arrayList;
    }

    public static int[] b() {
        List<Integer> a16 = a(AppConstants.VALUE.class.getFields());
        int size = a16.size();
        int[] iArr = new int[size];
        for (int i3 = 0; i3 < size; i3++) {
            iArr[i3] = a16.get(i3).intValue();
        }
        return iArr;
    }
}
