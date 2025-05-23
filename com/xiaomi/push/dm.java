package com.xiaomi.push;

import android.content.Context;

/* compiled from: P */
/* loaded from: classes28.dex */
public class dm extends dl {
    public dm(Context context, int i3) {
        super(context, i3);
    }

    @Override // com.xiaomi.push.ae.a
    public String e() {
        return "23";
    }

    @Override // com.xiaomi.push.dl
    public gh f() {
        return gh.Storage;
    }

    @Override // com.xiaomi.push.dl
    public String j() {
        return "ram:" + ge.e() + ",rom:" + ge.o() + "|ramOriginal:" + ge.s() + ",romOriginal:" + ge.v();
    }
}
