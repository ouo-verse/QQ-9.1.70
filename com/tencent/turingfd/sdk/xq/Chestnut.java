package com.tencent.turingfd.sdk.xq;

import java.lang.reflect.Field;

/* compiled from: P */
/* loaded from: classes27.dex */
public class Chestnut {
    /* JADX WARN: Removed duplicated region for block: B:10:0x0011 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0010 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Object a(Class<?> cls, String str, Object obj) {
        Field field;
        try {
            field = cls.getDeclaredField(str);
        } catch (Throwable unused) {
        }
        if (field != null) {
            field.setAccessible(true);
            if (field != null) {
            }
        } else {
            field = null;
            if (field != null) {
                return null;
            }
            try {
                return field.get(obj);
            } catch (Throwable unused2) {
                return null;
            }
        }
    }
}
