package com.tencent.mobileqq.haoliyou;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.lang.reflect.Method;

/* compiled from: P */
/* loaded from: classes7.dex */
public abstract class IATHandler {
    static IPatchRedirector $redirector_ = null;
    private static final String CLS_NAME = "com.tencent.mobileqq.haoliyou.JefsClass";
    public static IATHandler sHandler;

    public IATHandler() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void initHandler() {
        try {
            String str = JefsClass.TAG;
            Method method = JefsClass.class.getMethod("getInstance", new Class[0]);
            method.setAccessible(true);
            sHandler = (IATHandler) method.invoke(null, new Object[0]);
        } catch (Throwable unused) {
        }
    }

    public static void shellCheckAndDoSync(Context context, Intent intent, Runnable runnable) {
        IATHandler iATHandler = sHandler;
        if (iATHandler != null) {
            iATHandler.checkAndDoSync(context, intent, runnable);
        }
    }

    public static void shellStartActivityForResult(Activity activity, Intent intent, int i3, Bundle bundle) {
        IATHandler iATHandler = sHandler;
        if (iATHandler != null) {
            iATHandler.proxyStartActivityForResult(activity, intent, i3, bundle);
        }
    }

    public abstract void checkAndDoSync(Context context, Intent intent, Runnable runnable);

    public abstract void proxyStartActivityForResult(Activity activity, Intent intent, int i3, Bundle bundle);
}
