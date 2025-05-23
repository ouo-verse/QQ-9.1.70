package com.tencent.luggage.wxa.ka;

import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes8.dex */
public class q {

    /* renamed from: b, reason: collision with root package name */
    public static volatile q f131874b;

    /* renamed from: a, reason: collision with root package name */
    public Map f131875a = new HashMap();

    public static q a() {
        if (f131874b == null) {
            synchronized (q.class) {
                if (f131874b == null) {
                    f131874b = new q();
                }
            }
        }
        return f131874b;
    }

    public boolean a(String str, a aVar) {
        if (str == null || str.length() == 0 || aVar == null) {
            return false;
        }
        this.f131875a.put(str, aVar);
        return true;
    }
}
