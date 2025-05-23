package com.vivo.push.util;

import android.content.Context;
import cooperation.qzone.music.QzoneWebMusicJsPlugin;
import java.lang.reflect.Method;

/* compiled from: P */
/* loaded from: classes22.dex */
public class ContextDelegate {
    private static final String TAG = "ContextDelegate";
    private static Context mContext = null;
    private static Method mCreateCredentialProtectedStorageContext = null;
    private static Method mCreateDeviceProtectedStorageContext = null;
    private static boolean mDelegateEnable = false;
    private static Boolean mIsFbeProject;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    private static class a {

        /* renamed from: a, reason: collision with root package name */
        private static ContextDelegate f387862a = new ContextDelegate();
    }

    private static Context createCredentialProtectedStorageContext(Context context) {
        try {
            if (mCreateCredentialProtectedStorageContext == null) {
                mCreateCredentialProtectedStorageContext = Context.class.getMethod("createCredentialProtectedStorageContext", new Class[0]);
            }
            return (Context) mCreateCredentialProtectedStorageContext.invoke(context, new Object[0]);
        } catch (Exception e16) {
            e16.printStackTrace();
            return context;
        }
    }

    private static Context createDeviceProtectedStorageContext(Context context) {
        try {
            if (mCreateDeviceProtectedStorageContext == null) {
                mCreateDeviceProtectedStorageContext = Context.class.getMethod("createDeviceProtectedStorageContext", new Class[0]);
            }
            return (Context) mCreateDeviceProtectedStorageContext.invoke(context, new Object[0]);
        } catch (Exception e16) {
            e16.printStackTrace();
            return context;
        }
    }

    public static Context getContext(Context context) {
        if (isFBEProject() && context != null) {
            Context context2 = mContext;
            if (context2 != null) {
                return context2;
            }
            setContext(context);
            return mContext;
        }
        return context;
    }

    public static ContextDelegate getInstance() {
        return a.f387862a;
    }

    public static boolean isFBEProject() {
        boolean z16;
        if (mIsFbeProject == null) {
            try {
                if ("file".equals(n.a("ro.crypto.type", QzoneWebMusicJsPlugin.EVENT_UNKOWN))) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                mIsFbeProject = Boolean.valueOf(z16);
                u.b(TAG, "mIsFbeProject = " + mIsFbeProject.toString());
            } catch (Exception e16) {
                u.a(TAG, "mIsFbeProject = " + e16.getMessage());
            }
        }
        Boolean bool = mIsFbeProject;
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    private static void setAppContext() {
        Context context = mContext;
        if (context == null) {
            return;
        }
        setContext(context);
    }

    private static void setContext(Context context) {
        if (!mDelegateEnable) {
            mContext = createCredentialProtectedStorageContext(context);
        } else {
            mContext = createDeviceProtectedStorageContext(context);
        }
    }

    public static void setEnable(boolean z16) {
        mDelegateEnable = z16;
        setAppContext();
    }
}
