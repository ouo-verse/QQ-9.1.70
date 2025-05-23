package com.tencent.luggage.wxa.rc;

import com.tencent.luggage.wxa.tn.w0;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.commons.io.IOUtils;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class n {
    public static boolean a(String str, String str2, boolean z16) {
        if (w0.c(str)) {
            return false;
        }
        com.tencent.luggage.wxa.cp.v vVar = new com.tencent.luggage.wxa.cp.v(str);
        if (!vVar.e()) {
            return false;
        }
        com.tencent.luggage.wxa.cp.v vVar2 = new com.tencent.luggage.wxa.cp.v(str2);
        if (vVar.q()) {
            if ((!vVar2.q() && vVar2.e()) || !a(str, str2)) {
                return false;
            }
            if (!z16) {
                return true;
            }
            vVar.d();
            return true;
        }
        if (!vVar.p()) {
            return true;
        }
        if (!vVar2.e()) {
            vVar2.v();
        }
        if (!vVar2.p()) {
            return false;
        }
        String[] t16 = vVar.t();
        for (int i3 = 0; i3 < t16.length; i3++) {
            a(str + "/" + t16[i3], str2 + "/" + t16[i3], z16);
        }
        return true;
    }

    public static boolean a(String str, String str2) {
        InputStream inputStream;
        if (!w0.c(str) && !w0.c(str2)) {
            if (str.equals(str2)) {
                return true;
            }
            OutputStream outputStream = null;
            try {
                inputStream = com.tencent.luggage.wxa.cp.x.n(str);
            } catch (Exception e16) {
                e = e16;
                inputStream = null;
            } catch (Throwable th5) {
                th = th5;
                inputStream = null;
                IOUtils.closeQuietly(inputStream);
                IOUtils.closeQuietly(outputStream);
                throw th;
            }
            try {
                try {
                    outputStream = com.tencent.luggage.wxa.cp.x.o(str2);
                    IOUtils.copy(inputStream, outputStream);
                    IOUtils.closeQuietly(inputStream);
                    IOUtils.closeQuietly(outputStream);
                    return true;
                } catch (Throwable th6) {
                    th = th6;
                    IOUtils.closeQuietly(inputStream);
                    IOUtils.closeQuietly(outputStream);
                    throw th;
                }
            } catch (Exception e17) {
                e = e17;
                com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrand.FileCopy", e, "", new Object[0]);
                IOUtils.closeQuietly(inputStream);
                IOUtils.closeQuietly(outputStream);
                return false;
            }
        }
        com.tencent.luggage.wxa.tn.w.f("MicroMsg.AppBrand.FileCopy", "copy file but src path or dest path is null, return false.");
        return false;
    }
}
