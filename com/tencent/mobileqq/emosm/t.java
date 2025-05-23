package com.tencent.mobileqq.emosm;

import android.os.Bundle;

/* compiled from: P */
/* loaded from: classes6.dex */
public abstract class t {
    private static int seed;
    public int key;

    public t() {
        int i3 = seed;
        seed = i3 + 1;
        this.key = i3;
    }

    public abstract void onBindedToClient();

    public abstract void onDisconnectWithService();

    public abstract void onPushMsg(Bundle bundle);

    public abstract void onResponse(Bundle bundle);
}
