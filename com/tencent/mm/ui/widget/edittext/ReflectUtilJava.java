package com.tencent.mm.ui.widget.edittext;

import android.widget.TextView;
import com.tencent.luggage.wxa.lo.n;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: P */
/* loaded from: classes9.dex */
public class ReflectUtilJava {
    public static boolean getEmailPopupWindow(TextView textView) {
        try {
            Field declaredField = TextView.class.getDeclaredField("mEditor");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(textView);
            Method method = (Method) Class.class.getDeclaredMethod("getDeclaredMethod", String.class, Class[].class).invoke(Class.forName("android.widget.Editor"), "getEmailPopupWindow", null);
            method.setAccessible(true);
            method.invoke(obj, new Object[0]);
            n.c(SelectableEditTextHelper.TAG, "getEmailPopupWindow succ", new Object[0]);
            return true;
        } catch (InvocationTargetException e16) {
            n.a(SelectableEditTextHelper.TAG, e16, "getEmailPopupWindow err", new Object[0]);
            return false;
        } catch (Throwable th5) {
            n.a(SelectableEditTextHelper.TAG, th5, "getEmailPopupWindow err", new Object[0]);
            return false;
        }
    }
}
