package com.tencent.luggage.wxa.rc;

import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import android.util.Pair;
import com.tencent.luggage.wxa.tn.w0;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class k {

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {
        public void a(String str, String str2) {
            Os.rename(str, str2);
        }
    }

    public static Pair a(String str, String str2) {
        try {
            long c16 = w0.c();
            b(com.tencent.luggage.wxa.cp.x.b(str, true), com.tencent.luggage.wxa.cp.x.b(str2, true));
            com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrand.FileMove", "move, os rename works, cost = %d", Long.valueOf(w0.c() - c16));
            return Pair.create(Boolean.TRUE, null);
        } catch (Exception e16) {
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrand.FileMove", "move, os rename exp = %s", w0.a((Throwable) e16));
            ErrnoException errnoException = e16 instanceof ErrnoException ? (ErrnoException) e16 : null;
            boolean b16 = com.tencent.luggage.wxa.cp.x.b(str, str2);
            if (!b16) {
                b16 = n.a(com.tencent.luggage.wxa.cp.x.b(str, true), com.tencent.luggage.wxa.cp.x.b(str2, true), true);
            }
            return Pair.create(Boolean.valueOf(b16), errnoException);
        }
    }

    public static void b(String str, String str2) {
        new a().a(str, str2);
    }

    public static l a(ErrnoException errnoException) {
        if (errnoException != null) {
            com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrand.FileMove", errnoException, "handleFileMoveErrnoException", new Object[0]);
            if (errnoException.errno == OsConstants.ENAMETOOLONG) {
                return l.ERR_NAME_TOO_LONG;
            }
            return l.ERR_OP_FAIL;
        }
        return l.ERR_OP_FAIL;
    }
}
