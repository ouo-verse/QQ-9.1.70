package com.tencent.tfd.sdk.wxa;

import android.content.Context;

/* compiled from: P */
/* renamed from: com.tencent.tfd.sdk.wxa.goto, reason: invalid class name */
/* loaded from: classes26.dex */
public final class Cgoto {

    /* renamed from: a, reason: collision with root package name */
    public static Context f375756a;

    public static synchronized boolean a(Context context) {
        synchronized (Cgoto.class) {
            if (f375756a != null) {
                return true;
            }
            if (context == null) {
                return false;
            }
            Context applicationContext = context.getApplicationContext();
            if (applicationContext == null) {
                return false;
            }
            f375756a = applicationContext;
            return true;
        }
    }

    public static synchronized Context a() {
        Context context;
        synchronized (Cgoto.class) {
            context = f375756a;
        }
        return context;
    }
}
