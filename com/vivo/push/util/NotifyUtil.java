package com.vivo.push.util;

import android.content.Context;

/* compiled from: P */
/* loaded from: classes22.dex */
public class NotifyUtil {
    private static BaseNotifyDataAdapter sNotifyData = null;
    private static String sNotifyDataAdapter = "com.vivo.push.util.NotifyDataAdapter";
    private static BaseNotifyLayoutAdapter sNotifyLayout = null;
    private static String sNotifyLayoutAdapter = "com.vivo.push.util.NotifyLayoutAdapter";

    public static BaseNotifyDataAdapter getNotifyDataAdapter(Context context) {
        initAdapter(context);
        return sNotifyData;
    }

    public static BaseNotifyLayoutAdapter getNotifyLayoutAdapter(Context context) {
        initAdapter(context);
        return sNotifyLayout;
    }

    private static Object getObjectByReflect(String str, Object obj) {
        Class<?> cls;
        Object obj2 = null;
        try {
            cls = Class.forName(str);
        } catch (Exception unused) {
            cls = null;
        }
        if (cls != null) {
            try {
                obj2 = cls.newInstance();
            } catch (Exception unused2) {
            }
        }
        if (obj2 != null) {
            return obj2;
        }
        return obj;
    }

    private static synchronized void initAdapter(Context context) {
        synchronized (NotifyUtil.class) {
            if (sNotifyData == null) {
                BaseNotifyDataAdapter baseNotifyDataAdapter = (BaseNotifyDataAdapter) getObjectByReflect(sNotifyDataAdapter, new l());
                sNotifyData = baseNotifyDataAdapter;
                baseNotifyDataAdapter.init(context);
            }
            if (sNotifyLayout == null) {
                BaseNotifyLayoutAdapter baseNotifyLayoutAdapter = (BaseNotifyLayoutAdapter) getObjectByReflect(sNotifyLayoutAdapter, new m());
                sNotifyLayout = baseNotifyLayoutAdapter;
                baseNotifyLayoutAdapter.init(context);
            }
        }
    }
}
