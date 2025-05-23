package com.qq.e.tg.cfg;

import com.qq.e.comm.util.GDTLogger;

/* loaded from: classes3.dex */
public class MultiProcessFlag {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f40467a;

    /* renamed from: b, reason: collision with root package name */
    private static boolean f40468b;

    public static boolean isMultiProcess() {
        return f40467a;
    }

    public static void setMultiProcess(boolean z16) {
        if (!f40468b) {
            f40468b = true;
            f40467a = z16;
            GDTLogger.d("setMultiProcess multiProcess is true");
        } else {
            GDTLogger.w("setMultiProcess MultiProcessFlag has already be setted,reset will not take any effect");
        }
        GDTLogger.d("setMultiProcess multiProcess " + f40467a);
    }
}
