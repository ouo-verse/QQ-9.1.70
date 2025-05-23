package com.tencent.luggage.wxa.ef;

import com.tencent.luggage.wxa.xd.k0;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class c extends k0 {
    private static final int CTRL_INDEX = 995;
    private static final String NAME = "onLocationChangeError";

    /* renamed from: a, reason: collision with root package name */
    public final com.tencent.luggage.wxa.xd.d f124676a;

    public c(com.tencent.luggage.wxa.xd.d dVar) {
        this.f124676a = dVar;
    }

    public void a(int i3, String str) {
        HashMap hashMap = new HashMap(2);
        hashMap.put("errCode", Integer.valueOf(i3));
        hashMap.put("errStr", str);
        synchronized (this) {
            setContext(this.f124676a).setData(hashMap).dispatch();
        }
    }
}
