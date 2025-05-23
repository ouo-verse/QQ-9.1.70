package com.tencent.mapsdk.internal;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class qu {

    /* renamed from: a, reason: collision with root package name */
    public final mv f149935a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f149936b;

    /* renamed from: c, reason: collision with root package name */
    public final bf f149937c;

    @RequiresApi(api = 21)
    public qu(Context context, bf bfVar, String str) {
        this.f149937c = bfVar;
        if (str == null) {
            this.f149935a = my.a(context);
        } else {
            this.f149935a = mx.a(context, str);
        }
        if (a()) {
            this.f149936b = this.f149935a.c(et.E);
            bfVar.g().c(this.f149936b);
        } else {
            bfVar.g().c(false);
        }
    }

    @RequiresApi(api = 21)
    public static boolean a() {
        String[] strArr = Build.SUPPORTED_64_BIT_ABIS;
        return (strArr == null || strArr.length == 0) ? false : true;
    }

    @RequiresApi(api = 21)
    private void b() {
        if (a()) {
            this.f149936b = this.f149935a.c(et.E);
            this.f149937c.g().c(this.f149936b);
        } else {
            this.f149937c.g().c(false);
        }
    }

    @RequiresApi(api = 21)
    private void a(boolean z16) {
        if (a()) {
            this.f149936b = z16;
            this.f149935a.a(et.E, z16);
            this.f149937c.g().c(this.f149936b);
            return;
        }
        this.f149937c.g().c(false);
    }
}
