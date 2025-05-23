package com.qq.e.comm.plugin.base.ad.c;

import com.qq.e.comm.pi.ADPLI;
import org.json.JSONArray;

/* compiled from: P */
/* loaded from: classes3.dex */
public class c implements ADPLI {

    /* renamed from: a, reason: collision with root package name */
    private static volatile c f38477a;

    c() {
    }

    public static c a() {
        if (f38477a == null) {
            synchronized (c.class) {
                if (f38477a == null) {
                    f38477a = new c();
                }
            }
        }
        return f38477a;
    }

    @Override // com.qq.e.comm.pi.ADPLI
    public void preloadAfterAdLoaded(JSONArray jSONArray, String str) {
        b.a().a(jSONArray, str);
    }
}
