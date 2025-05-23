package com.tencent.mobileqq.auto.engine.main;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.ViewParent;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import uq3.o;

/* compiled from: P */
/* loaded from: classes11.dex */
public class c {
    static IPatchRedirector $redirector_;

    public static void a(Activity activity) {
        try {
            if (!o.n() || Build.VERSION.SDK_INT < 35) {
                return;
            }
            if (activity == null) {
                QLog.d("QFSAndroid15BackEventNullFixHelper", 1, "Activity is empty");
                return;
            }
            QLog.d("QFSAndroid15BackEventNullFixHelper", 1, "start fixBackEventNull :" + activity.getClass().getName());
            ViewParent parent = activity.getWindow().getDecorView().getParent();
            if (parent == null) {
                QLog.d("QFSAndroid15BackEventNullFixHelper", 1, "root view is empty :" + activity.getClass().getName());
                return;
            }
            Object b16 = b(b(parent, "mOnBackInvokedDispatcher"), "mChecker");
            Object b17 = b(b16, "mContext");
            if (!(b17 instanceof WeakReference)) {
                QLog.d("QFSAndroid15BackEventNullFixHelper", 1, "find check context not weakReference ");
                return;
            }
            Context context = (Context) ((WeakReference) b17).get();
            if (context == null) {
                c(b16, new WeakReference(activity), "mContext");
                QLog.d("QFSAndroid15BackEventNullFixHelper", 1, "find check context is empty,set a new ");
                return;
            }
            int hashCode = context.hashCode();
            int hashCode2 = activity.hashCode();
            int hashCode3 = b(parent, "mContext").hashCode();
            if (hashCode != hashCode2 && hashCode != hashCode3) {
                c(b16, new WeakReference(activity), "mContext");
                QLog.d("QFSAndroid15BackEventNullFixHelper", 1, "find check context hasCode not equal ,set a new ");
            }
        } catch (Exception e16) {
            QLog.e("QFSAndroid15BackEventNullFixHelper", 1, e16, new Object[0]);
        }
    }

    private static Object b(Object obj, String str) throws NoSuchFieldException, IllegalAccessException {
        Class<?> cls = obj.getClass();
        QLog.d("QFSAndroid15BackEventNullFixHelper", 1, "getTargetObject from targetClass:" + cls.getName() + "|filedName:" + str + "| parentObject:" + obj.getClass().getName());
        Field declaredField = cls.getDeclaredField(str);
        declaredField.setAccessible(true);
        return declaredField.get(obj);
    }

    private static void c(Object obj, Object obj2, String str) throws NoSuchFieldException, IllegalAccessException {
        Class<?> cls = obj.getClass();
        QLog.d("QFSAndroid15BackEventNullFixHelper", 1, "setValueToObject to targetClass:" + cls.getName() + "|filedName:" + str + "| parentObject:" + obj.getClass().getName());
        Field declaredField = cls.getDeclaredField(str);
        declaredField.setAccessible(true);
        declaredField.set(obj, obj2);
    }
}
