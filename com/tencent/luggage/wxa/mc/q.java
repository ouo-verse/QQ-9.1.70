package com.tencent.luggage.wxa.mc;

import com.tencent.luggage.wxa.tn.w0;
import java.io.Closeable;
import java.io.InputStream;
import java.io.OutputStream;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class q {
    public static String a(a0 a0Var, String str) {
        if (a0Var == null || w0.c(str)) {
            return null;
        }
        a0Var.m();
        InputStream b16 = a0Var.b(str);
        if (b16 == null) {
            return null;
        }
        try {
            b16.mark(b16.available());
            String a16 = com.tencent.luggage.wxa.y8.c.a(b16, 4096);
            b16.reset();
            com.tencent.luggage.wxa.cp.v vVar = new com.tencent.luggage.wxa.cp.v(a0Var.d() + "_xdir/" + str);
            com.tencent.luggage.wxa.cp.v k3 = vVar.k();
            if (k3.e() && k3.q()) {
                k3.d();
            }
            k3.w();
            if (!a16.equals(com.tencent.luggage.wxa.cp.x.i(vVar.m()))) {
                if (vVar.p()) {
                } else {
                    vVar.d();
                }
                OutputStream b17 = com.tencent.luggage.wxa.cp.x.b(vVar);
                com.tencent.luggage.wxa.y8.a.a(b16, b17);
                w0.a((Closeable) b17);
            }
            return vVar.g();
        } catch (Exception e16) {
            com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrand.PkgPartialCopy", e16, "copy failed", new Object[0]);
            return null;
        } finally {
            w0.a((Closeable) b16);
        }
    }
}
