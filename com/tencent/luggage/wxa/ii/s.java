package com.tencent.luggage.wxa.ii;

import com.tencent.luggage.wxa.hn.z0;
import com.tencent.luggage.wxa.tn.w0;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes8.dex */
public class s extends com.tencent.luggage.wxa.xn.c {

    /* renamed from: g, reason: collision with root package name */
    public static final String[] f130587g = {com.tencent.luggage.wxa.xn.c.a(r.f130586p, "WxaJsApiPluginInfo")};

    public s(com.tencent.luggage.wxa.xn.b bVar) {
        super(bVar, r.f130586p, "WxaJsApiPluginInfo", com.tencent.luggage.wxa.q9.n.f138506j);
    }

    public boolean a(String str, z0 z0Var) {
        if (!w0.c(str) && z0Var != null) {
            try {
                z0Var.b();
                if (!b(str, z0Var)) {
                    return false;
                }
                com.tencent.luggage.wxa.tn.w.d("MicroMsg.LaunchWxaJsApiPluginInfoStorage", "setWxaJsApiPluginInfoData appId:%s ok", str);
                return true;
            } catch (IOException unused) {
                com.tencent.luggage.wxa.tn.w.b("MicroMsg.LaunchWxaJsApiPluginInfoStorage", "setWxaJsApiPluginInfoData,invalid CheckJsApiInfo %s", str);
                return false;
            }
        }
        com.tencent.luggage.wxa.tn.w.b("MicroMsg.LaunchWxaJsApiPluginInfoStorage", "setWxaJsApiPluginInfoData,invalid input %s", str);
        return false;
    }

    public final boolean b(String str, z0 z0Var) {
        r rVar = new r();
        rVar.f138512b = str;
        boolean b16 = b(rVar, new String[0]);
        rVar.f138514d = z0Var;
        if (b16) {
            return c(rVar, new String[0]);
        }
        return a(rVar);
    }
}
