package com.tencent.gamecenter.wadl.sdk.common.d.k.b.f;

import com.tencent.gamecenter.wadl.sdk.common.b.c;
import com.tencent.gamecenter.wadl.sdk.common.e.g;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes6.dex */
public class a extends com.tencent.gamecenter.wadl.sdk.common.d.k.a.a {
    public a(String str) {
        super(str);
    }

    @Override // com.tencent.gamecenter.wadl.sdk.common.d.k.a.a
    public int a() {
        return 1;
    }

    public JSONObject b() {
        c.m();
        byte[] a16 = a(c.b());
        if (!g.a(a16)) {
            return new JSONObject(new String(a16));
        }
        return null;
    }
}
