package com.tencent.luggage.wxa.vd;

import androidx.exifinterface.media.ExifInterface;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static final String[] f143353a;

    static {
        LinkedList linkedList = new LinkedList();
        for (Field field : ExifInterface.class.getDeclaredFields()) {
            try {
                if (Modifier.isFinal(field.getModifiers()) && Modifier.isStatic(field.getModifiers()) && field.getName().startsWith("TAG_")) {
                    linkedList.add((String) field.get(null));
                }
            } catch (Exception unused) {
            }
        }
        f143353a = (String[]) linkedList.toArray(new String[linkedList.size()]);
    }

    public static void a(ExifInterface exifInterface, ExifInterface exifInterface2) {
        if (exifInterface != null && exifInterface2 != null) {
            for (String str : f143353a) {
                String attribute = exifInterface.getAttribute(str);
                if (attribute != null) {
                    exifInterface2.setAttribute(str, attribute);
                }
            }
            exifInterface2.saveAttributes();
        }
    }
}
