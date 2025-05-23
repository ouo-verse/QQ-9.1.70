package com.tencent.luggage.wxa.ra;

import android.os.IBinder;

/* compiled from: P */
/* loaded from: classes8.dex */
public class a implements IBinder.DeathRecipient {

    /* renamed from: a, reason: collision with root package name */
    public final String f139429a;

    public a(String str) {
        this.f139429a = str;
    }

    @Override // android.os.IBinder.DeathRecipient
    public void binderDied() {
        com.tencent.luggage.wxa.ta.c.c("IPC.DeathRecipientImpl", "binderDied(%s)", this.f139429a);
        String str = this.f139429a;
        if (str != null && str.length() != 0) {
            b.a(this.f139429a);
        }
    }
}
