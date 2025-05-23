package com.tencent.luggage.wxa.kj;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class l1 {
    public static boolean a(k1 k1Var) {
        if (k1Var != k1.APP_LAUNCH && k1Var != k1.SWITCH_TAB && k1Var != k1.REDIRECT_TO && k1Var != k1.REWRITE_ROUTE && k1Var != k1.RE_LAUNCH && k1Var != k1.AUTO_RE_LAUNCH) {
            return true;
        }
        return false;
    }

    public static boolean b(k1 k1Var) {
        return com.tencent.luggage.wxa.u9.a.a(new k1[]{k1.SWITCH_TAB, k1.RE_LAUNCH, k1.AUTO_RE_LAUNCH}, k1Var);
    }

    public static boolean c(k1 k1Var) {
        if (k1Var != k1.REDIRECT_TO && k1Var != k1.REWRITE_ROUTE && k1Var != k1.SWITCH_TAB && k1Var != k1.RE_LAUNCH && k1Var != k1.AUTO_RE_LAUNCH) {
            return false;
        }
        return true;
    }
}
