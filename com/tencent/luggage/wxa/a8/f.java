package com.tencent.luggage.wxa.a8;

import com.tencent.luggage.wxa.tn.w0;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class f {

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f120930a;

        static {
            int[] iArr = new int[com.tencent.luggage.wxa.vj.e.values().length];
            f120930a = iArr;
            try {
                iArr[com.tencent.luggage.wxa.vj.e.FAIL_SINCE_IS_EXITING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f120930a[com.tencent.luggage.wxa.vj.e.FAIL_SINCE_NOT_IN_PIP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f120930a[com.tencent.luggage.wxa.vj.e.SUCCESS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public static boolean a(com.tencent.luggage.wxa.xd.o oVar, com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, int i3) {
        com.tencent.luggage.wxa.ic.g gVar;
        if (!oVar.getName().contains("operate")) {
            return false;
        }
        String optString = jSONObject.optString("type");
        if (w0.c(optString) || !optString.equalsIgnoreCase(com.tencent.luggage.wxa.c8.c.f123397t0)) {
            return false;
        }
        if (dVar instanceof com.tencent.luggage.wxa.xd.i) {
            gVar = ((com.tencent.luggage.wxa.xd.i) dVar).getRuntime();
        } else {
            gVar = null;
        }
        if (gVar == null) {
            dVar.a(i3, oVar.makeReturnJson(com.tencent.luggage.wxa.af.e.f121309e));
            return true;
        }
        com.tencent.luggage.wxa.vj.f Z = gVar.Z();
        if (Z == null) {
            dVar.a(i3, oVar.makeReturnJson(com.tencent.luggage.wxa.af.e.f121309e));
            return true;
        }
        int i16 = a.f120930a[Z.a(jSONObject.optInt("viewId")).ordinal()];
        if (i16 != 1) {
            if (i16 != 2) {
                dVar.a(i3, oVar.makeReturnJson(com.tencent.luggage.wxa.af.e.f121305a));
                return true;
            }
            dVar.a(i3, oVar.makeReturnJson(com.tencent.luggage.wxa.af.g.f121344m));
            return true;
        }
        dVar.a(i3, oVar.makeReturnJson(com.tencent.luggage.wxa.af.g.f121345n));
        return true;
    }
}
