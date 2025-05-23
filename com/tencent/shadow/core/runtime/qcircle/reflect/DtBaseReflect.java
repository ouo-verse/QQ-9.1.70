package com.tencent.shadow.core.runtime.qcircle.reflect;

import android.app.Activity;
import java.lang.reflect.Method;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes25.dex */
public abstract class DtBaseReflect {
    protected HashMap<String, Method> mMethodMap = new HashMap<>();
    private Object mObject;

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean getInstance(Activity activity, String str, String str2) {
        Class<?> loadClass = loadClass(activity, str);
        if (loadClass == null) {
            return false;
        }
        try {
            this.mObject = loadClass.getMethod(str2, new Class[0]).invoke(null, new Object[0]);
            return true;
        } catch (Exception e16) {
            e16.printStackTrace();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Object getObject(Activity activity) {
        if (this.mObject == null) {
            initObject(activity);
        }
        return this.mObject;
    }

    protected abstract void initObject(Activity activity);

    /* JADX INFO: Access modifiers changed from: protected */
    public Class<?> loadClass(Activity activity, String str) {
        ClassLoader classLoader;
        ClassLoader parent;
        if (activity == null || (classLoader = activity.getClassLoader()) == null || (parent = classLoader.getParent()) == null) {
            return null;
        }
        try {
            return parent.loadClass(str);
        } catch (ClassNotFoundException e16) {
            e16.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean newInstance(Activity activity, String str) {
        Class<?> loadClass = loadClass(activity, str);
        if (loadClass == null) {
            return false;
        }
        try {
            this.mObject = loadClass.newInstance();
            return true;
        } catch (Exception e16) {
            e16.printStackTrace();
            return false;
        }
    }
}
