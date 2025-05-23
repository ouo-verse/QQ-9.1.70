package com.tencent.smtt.utils;

import android.content.Context;
import android.os.Bundle;

/* compiled from: P */
/* loaded from: classes25.dex */
public class h implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private Context f369746a;

    /* renamed from: b, reason: collision with root package name */
    private int f369747b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f369748c;

    /* renamed from: d, reason: collision with root package name */
    private Bundle f369749d;

    /* renamed from: e, reason: collision with root package name */
    private long f369750e;

    public h(Context context, int i3, boolean z16, long j3, Bundle bundle) {
        this.f369746a = context;
        this.f369747b = i3;
        this.f369748c = z16;
        this.f369749d = bundle;
        this.f369750e = j3;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        String str2;
        String str3;
        Bundle bundle;
        if (this.f369748c && (bundle = this.f369749d) != null) {
            String string = bundle.getString("guid");
            str2 = this.f369749d.getString("qua2");
            str3 = this.f369749d.getString("lc");
            str = string;
        } else {
            str = "";
            str2 = str;
            str3 = str2;
        }
        com.tencent.smtt.sdk.stat.b.a(this.f369746a, str, str2, str3, this.f369747b, this.f369748c, this.f369750e, false);
        this.f369746a = null;
        this.f369749d = null;
    }
}
