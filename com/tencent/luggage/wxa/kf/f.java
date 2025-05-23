package com.tencent.luggage.wxa.kf;

import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.xd.i;
import com.tencent.luggage.wxa.xd.m;
import java.util.HashSet;

/* compiled from: P */
/* loaded from: classes8.dex */
public class f implements m {

    /* renamed from: a, reason: collision with root package name */
    public HashSet f131970a = new HashSet();

    /* renamed from: b, reason: collision with root package name */
    public boolean f131971b;

    public f(i iVar) {
        this.f131971b = false;
        boolean a16 = a(iVar);
        this.f131971b = a16;
        if (a16) {
            w.d("MicroMsg.LoadSubPackageTaskCallbackFilter", "JsApiOnLoadSubPackageTaskStateChange support listen task state change");
        }
    }

    public static boolean a(i iVar) {
        if (iVar.i() == null) {
            return false;
        }
        return w0.a(iVar.i().h("supportListenTaskStateChange"), false);
    }

    public boolean h(String str) {
        if (!str.equals("success") && !str.equals("fail") && !this.f131970a.contains(str) && this.f131971b) {
            return false;
        }
        return true;
    }
}
