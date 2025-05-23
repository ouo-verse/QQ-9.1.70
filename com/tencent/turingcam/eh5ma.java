package com.tencent.turingcam;

import android.content.Context;

/* compiled from: P */
/* loaded from: classes27.dex */
public class eh5ma {

    /* renamed from: a, reason: collision with root package name */
    public static Context f382207a;

    public static synchronized boolean a(Context context) {
        synchronized (eh5ma.class) {
            if (f382207a != null) {
                return true;
            }
            if (context == null) {
                return false;
            }
            Context applicationContext = context.getApplicationContext();
            if (applicationContext == null) {
                return false;
            }
            f382207a = applicationContext;
            return true;
        }
    }

    public static synchronized Context a() {
        Context context;
        synchronized (eh5ma.class) {
            context = f382207a;
        }
        return context;
    }
}
