package com.tencent.luggage.wxa.ii;

import android.text.TextUtils;
import com.tencent.luggage.wxa.hn.i6;

/* compiled from: P */
/* loaded from: classes8.dex */
public class q extends com.tencent.luggage.wxa.xn.c {

    /* renamed from: g, reason: collision with root package name */
    public static final String[] f130585g = {com.tencent.luggage.wxa.xn.c.a(o.f130583p, "LaunchWxaAppPBTableNew")};

    public q(com.tencent.luggage.wxa.xn.b bVar) {
        super(bVar, o.f130583p, "LaunchWxaAppPBTableNew", com.tencent.luggage.wxa.q9.g.f138363j);
    }

    public boolean a(String str, i6 i6Var) {
        if (!TextUtils.isEmpty(str) && i6Var != null) {
            o oVar = new o();
            oVar.f138369b = str;
            oVar.f138371d = i6Var;
            return super.b(oVar);
        }
        return false;
    }
}
