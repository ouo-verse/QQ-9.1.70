package com.tencent.luggage.wxa.wn;

import android.os.Message;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class b implements a {
    public void a() {
    }

    @Override // com.tencent.luggage.wxa.wn.a
    public String getName() {
        String name = getClass().getName();
        return name.substring(name.lastIndexOf(36) + 1);
    }

    public boolean a(Message message) {
        return false;
    }

    public void b() {
    }
}
