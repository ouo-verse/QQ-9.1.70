package com.qzone.adapter.feedcomponent;

import android.graphics.BitmapFactory;
import com.qzone.proxy.feedcomponent.model.VideoInfo;

/* compiled from: P */
/* loaded from: classes39.dex */
public abstract class q {

    /* renamed from: a, reason: collision with root package name */
    static q f41922a;

    public static q b() {
        q qVar = f41922a;
        if (qVar != null) {
            return qVar;
        }
        throw new RuntimeException("LocalImageHelper does not init");
    }

    public static void n(q qVar) {
        f41922a = qVar;
    }

    public abstract VideoInfo a(Object obj);

    public abstract int c(Object obj);

    public abstract String d(Object obj);

    public abstract String e(Object obj);

    public abstract String f(Object obj);

    public abstract String g(Object obj);

    public abstract BitmapFactory.Options h(String str);

    public abstract Object i(Object obj);

    public abstract Object j(Object obj);

    public abstract String k(Object obj);

    public abstract String l(Object obj);

    public abstract String m(Object obj);

    public abstract boolean o(Object obj);

    public abstract boolean p(Object obj);

    public abstract boolean q(Object obj);

    public abstract String r(Object obj);
}
