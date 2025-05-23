package com.qq.e.comm.plugin.k;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.view.ContextThemeWrapper;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

/* compiled from: P */
/* loaded from: classes3.dex */
public class az {

    /* renamed from: a, reason: collision with root package name */
    static Class f39639a;

    /* renamed from: b, reason: collision with root package name */
    static Class f39640b;

    /* renamed from: c, reason: collision with root package name */
    static Class f39641c;

    /* renamed from: d, reason: collision with root package name */
    static Class f39642d;

    static {
        try {
            int i3 = AppCompatActivity.f26452a0;
            f39639a = AppCompatActivity.class;
            f39641c = ActionBar.class;
        } catch (ClassNotFoundException unused) {
            f39639a = null;
            f39641c = null;
        }
        try {
            f39640b = Class.forName("android.support.v7.app.AppCompatActivity");
            f39642d = Class.forName("android.support.v7.app.ActionBar");
        } catch (ClassNotFoundException unused2) {
            f39640b = null;
            f39642d = null;
        }
    }

    public static boolean a() {
        return true;
    }

    public static boolean b() {
        return false;
    }

    private static boolean c() {
        return (f39639a == null && f39640b == null) ? false : true;
    }

    public static Activity a(Context context) {
        if (context == null) {
            return null;
        }
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            return a(((ContextWrapper) context).getBaseContext());
        }
        return null;
    }

    public static boolean b(Context context) {
        if (context == null) {
            return false;
        }
        if (a(context) != null) {
            return true;
        }
        return c() && c(context) != null;
    }

    private static Context c(Context context) {
        Class cls;
        if (context == null) {
            return null;
        }
        Class cls2 = f39639a;
        if ((cls2 != null && cls2.isInstance(context)) || ((cls = f39640b) != null && cls.isInstance(context))) {
            return context;
        }
        if (context instanceof ContextThemeWrapper) {
            return c(((ContextThemeWrapper) context).getBaseContext());
        }
        return null;
    }
}
