package com.tencent.thumbplayer.common.annotation;

import com.tencent.thumbplayer.api.common.TPOnInfoID;
import com.tencent.thumbplayer.common.log.TPLogUtil;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes26.dex */
public class TPOnInfoIDAttributeUtils {
    public static final Set<Integer> ONCE_INFO_ID_SET = new HashSet();
    private static final String TAG = "TPOnInfoIDAttributeUtils";

    static {
        resolveAllDeclaredAttribute();
    }

    public static boolean isOnceInfoID(int i3) {
        return ONCE_INFO_ID_SET.contains(Integer.valueOf(i3));
    }

    private static void resolveAllDeclaredAttribute() {
        boolean z16;
        try {
            for (Field field : TPOnInfoID.class.getDeclaredFields()) {
                if (field.isAnnotationPresent(TPOnInfoIDAttribute.class) && Modifier.isStatic(field.getModifiers()) && field.getGenericType() == Integer.TYPE) {
                    TPOnInfoIDAttribute tPOnInfoIDAttribute = (TPOnInfoIDAttribute) field.getAnnotation(TPOnInfoIDAttribute.class);
                    int intValue = ((Integer) field.get(TPOnInfoID.class)).intValue();
                    if (tPOnInfoIDAttribute != null && tPOnInfoIDAttribute.isOnceInfoID()) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        ONCE_INFO_ID_SET.add(Integer.valueOf(intValue));
                    }
                }
            }
        } catch (IllegalAccessException e16) {
            TPLogUtil.w(TAG, "load all declared onInfoID failed , exception:" + e16);
        }
    }
}
