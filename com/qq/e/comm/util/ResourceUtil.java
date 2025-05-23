package com.qq.e.comm.util;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import java.lang.reflect.Field;

/* compiled from: P */
/* loaded from: classes3.dex */
public class ResourceUtil {
    public static int getColorId(Context context, String str) {
        Resources resources;
        if (context != null && !TextUtils.isEmpty(str) && (resources = context.getResources()) != null) {
            return resources.getIdentifier(str, "color", context.getPackageName());
        }
        return -1;
    }

    public static int getDrawableId(Context context, String str) {
        Resources resources;
        if (context != null && !TextUtils.isEmpty(str) && (resources = context.getResources()) != null) {
            return resources.getIdentifier(str, "drawable", context.getPackageName());
        }
        return -1;
    }

    public static int getId(Context context, String str) {
        Resources resources;
        if (context != null && !TextUtils.isEmpty(str) && (resources = context.getResources()) != null) {
            return resources.getIdentifier(str, "id", context.getPackageName());
        }
        return -1;
    }

    public static int getLayoutId(Context context, String str) {
        Resources resources;
        if (context != null && !TextUtils.isEmpty(str) && (resources = context.getResources()) != null) {
            return resources.getIdentifier(str, TtmlNode.TAG_LAYOUT, context.getPackageName());
        }
        return -1;
    }

    public static int getStringId(Context context, String str) {
        Resources resources;
        if (context != null && !TextUtils.isEmpty(str) && (resources = context.getResources()) != null) {
            return resources.getIdentifier(str, HippyControllerProps.STRING, context.getPackageName());
        }
        return -1;
    }

    public static int getStyleId(Context context, String str) {
        Resources resources;
        if (context != null && !TextUtils.isEmpty(str) && (resources = context.getResources()) != null) {
            return resources.getIdentifier(str, "style", context.getPackageName());
        }
        return -1;
    }

    public static int getStyleableFieldId(Context context, String str, String str2) {
        String str3 = str + "_" + str2;
        try {
            for (Class<?> cls : Class.forName(context.getPackageName() + ".R").getClasses()) {
                if (cls.getSimpleName().equals("styleable")) {
                    for (Field field : cls.getFields()) {
                        if (field.getName().equals(str3)) {
                            return ((Integer) field.get(null)).intValue();
                        }
                    }
                }
            }
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
        return 0;
    }

    public static int[] getStyleableIntArray(Context context, String str) {
        try {
            for (Field field : Class.forName(context.getPackageName() + ".R$styleable").getFields()) {
                if (field.getName().equals(str)) {
                    return (int[]) field.get(null);
                }
            }
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
        return null;
    }
}
