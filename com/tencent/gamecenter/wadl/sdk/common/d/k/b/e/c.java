package com.tencent.gamecenter.wadl.sdk.common.d.k.b.e;

import android.os.Build;
import com.tencent.gamecenter.wadl.sdk.common.e.g;

/* compiled from: P */
/* loaded from: classes6.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public String f107214a;

    /* renamed from: b, reason: collision with root package name */
    public String f107215b;

    /* renamed from: c, reason: collision with root package name */
    public String f107216c;

    public c() {
        try {
            this.f107214a = Build.BRAND;
            this.f107215b = Build.VERSION.RELEASE;
            this.f107216c = g.c();
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
    }
}
