package com.tencent.xweb;

import com.tencent.luggage.wxa.ar.x0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes27.dex */
public class XWebPreferences {
    public static final String TAG = "XWebPreferences";

    /* renamed from: a, reason: collision with root package name */
    public static IXWebPreferences f385063a;

    /* renamed from: b, reason: collision with root package name */
    public static final List f385064b = new ArrayList();

    /* loaded from: classes27.dex */
    public interface XWebPreferencesListener {
        void onWebPreferencesReady();
    }

    public static boolean getBooleanValue(String str) {
        IXWebPreferences iXWebPreferences = f385063a;
        if (iXWebPreferences != null) {
            return iXWebPreferences.getBooleanValue(str);
        }
        x0.f(TAG, "getBooleanValue, web preferences not set, key:" + str);
        return false;
    }

    public static int getIntegerValue(String str) {
        IXWebPreferences iXWebPreferences = f385063a;
        if (iXWebPreferences != null) {
            return iXWebPreferences.getIntegerValue(str);
        }
        x0.f(TAG, "getIntegerValue, web preferences not set, key:" + str);
        return 0;
    }

    public static String getStringValue(String str) {
        IXWebPreferences iXWebPreferences = f385063a;
        if (iXWebPreferences != null) {
            return iXWebPreferences.getStringValue(str);
        }
        x0.f(TAG, "getStringValue, web preferences not set, key:" + str);
        return null;
    }

    public static boolean getValue(String str) {
        IXWebPreferences iXWebPreferences = f385063a;
        if (iXWebPreferences != null) {
            return iXWebPreferences.getValue(str);
        }
        x0.f(TAG, "getValue, web preferences not set, key:" + str);
        return false;
    }

    public static boolean isReady() {
        if (f385063a != null) {
            return true;
        }
        return false;
    }

    public static void registerWebPreferencesListener(XWebPreferencesListener xWebPreferencesListener) {
        if (xWebPreferencesListener != null) {
            f385064b.add(xWebPreferencesListener);
        }
    }

    public static void setValue(String str, boolean z16) {
        IXWebPreferences iXWebPreferences = f385063a;
        if (iXWebPreferences != null) {
            iXWebPreferences.setValue(str, z16);
            return;
        }
        x0.f(TAG, "setValue, web preferences not set, key:" + str);
    }

    public static void setWebPreferences(IXWebPreferences iXWebPreferences) {
        x0.d(TAG, "setWebPreferences:" + iXWebPreferences);
        f385063a = iXWebPreferences;
        List list = f385064b;
        if (!list.isEmpty()) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ((XWebPreferencesListener) it.next()).onWebPreferencesReady();
            }
        }
    }

    public static void unregisterWebPreferencesListener(XWebPreferencesListener xWebPreferencesListener) {
        if (xWebPreferencesListener != null) {
            f385064b.remove(xWebPreferencesListener);
        }
    }

    public static void setValue(String str, int i3) {
        IXWebPreferences iXWebPreferences = f385063a;
        if (iXWebPreferences != null) {
            iXWebPreferences.setValue(str, i3);
            return;
        }
        x0.f(TAG, "setValue, web preferences not set, key:" + str);
    }

    public static void setValue(String str, String str2) {
        IXWebPreferences iXWebPreferences = f385063a;
        if (iXWebPreferences != null) {
            iXWebPreferences.setValue(str, str2);
            return;
        }
        x0.f(TAG, "setValue, web preferences not set, key:" + str);
    }
}
