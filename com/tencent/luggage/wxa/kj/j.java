package com.tencent.luggage.wxa.kj;

import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class j extends com.tencent.luggage.wxa.xd.p {
    private static final int CTRL_INDEX = -2;
    private static final String NAME = "onAppRunningStatusChange";

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f132216a;

        static {
            int[] iArr = new int[com.tencent.luggage.wxa.qc.b.values().length];
            f132216a = iArr;
            try {
                iArr[com.tencent.luggage.wxa.qc.b.BACKGROUND.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f132216a[com.tencent.luggage.wxa.qc.b.FOREGROUND.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f132216a[com.tencent.luggage.wxa.qc.b.SUSPEND.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f132216a[com.tencent.luggage.wxa.qc.b.DESTROYED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public static void a(com.tencent.luggage.wxa.ic.g gVar, com.tencent.luggage.wxa.qc.b bVar) {
        String str;
        HashMap hashMap = new HashMap();
        int i3 = a.f132216a[bVar.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    return;
                } else {
                    str = QCircleDaTongConstant.ElementParamValue.SUSPEND;
                }
            } else {
                str = "active";
            }
        } else {
            str = "background";
        }
        hashMap.put("status", str);
        new j().setData(hashMap).setContext(gVar.h0()).dispatch();
    }
}
