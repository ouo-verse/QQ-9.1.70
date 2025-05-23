package com.tencent.qqperf.opt.threadpriority;

import android.content.Context;
import com.tencent.qphone.base.util.BaseApplication;

/* compiled from: P */
/* loaded from: classes25.dex */
public class a {

    /* renamed from: f, reason: collision with root package name */
    private static a f363339f;

    /* renamed from: b, reason: collision with root package name */
    private int f363341b = -2;

    /* renamed from: c, reason: collision with root package name */
    private boolean f363342c = false;

    /* renamed from: d, reason: collision with root package name */
    private boolean f363343d = false;

    /* renamed from: e, reason: collision with root package name */
    private boolean f363344e = false;

    /* renamed from: a, reason: collision with root package name */
    private Context f363340a = BaseApplication.getContext();

    a() {
    }

    public static synchronized a c() {
        a aVar;
        synchronized (a.class) {
            if (f363339f == null) {
                f363339f = new a();
            }
            aVar = f363339f;
        }
        return aVar;
    }

    public boolean a() {
        return this.f363342c;
    }

    public int b() {
        return this.f363341b;
    }

    public boolean d() {
        return this.f363343d;
    }

    public boolean e() {
        return this.f363344e;
    }
}
