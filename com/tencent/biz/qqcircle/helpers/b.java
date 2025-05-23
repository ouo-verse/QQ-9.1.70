package com.tencent.biz.qqcircle.helpers;

import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes4.dex */
public class b implements a {

    /* renamed from: e, reason: collision with root package name */
    private static volatile b f84608e;

    /* renamed from: d, reason: collision with root package name */
    private WeakReference<a> f84609d;

    public static b a() {
        if (f84608e == null) {
            synchronized (b.class) {
                if (f84608e == null) {
                    f84608e = new b();
                }
            }
        }
        return f84608e;
    }

    public void b(a aVar) {
        this.f84609d = new WeakReference<>(aVar);
        QLog.d("QCircleBottomTabHelper", 1, "setQQStatusProvider: " + aVar);
    }
}
