package com.tencent.luggage.wxa.rf;

import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.xd.o;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class j {
    public static /* synthetic */ String a(o oVar, int i3, String str, Map map, int i16, Object obj) {
        if ((i16 & 4) != 0) {
            map = null;
        }
        return a(oVar, i3, str, map);
    }

    public static final String a(o oVar, int i3, String errMsg, Map map) {
        Intrinsics.checkNotNullParameter(oVar, "<this>");
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        com.tencent.luggage.wxa.af.c a16 = i.f139660a.a(i3);
        if (a16 == null) {
            w.b("MicroMsg.AppBrand.NFCErrnoMigrationLogic", "makeReturnJson, errCode: " + i3 + ", errInfo is null");
            String makeReturnJson = oVar.makeReturnJson(errMsg, (Map<String, ? extends Object>) map);
            Intrinsics.checkNotNullExpressionValue(makeReturnJson, "makeReturnJson(errMsg, errInfoMap)");
            return makeReturnJson;
        }
        String makeReturnJson2 = oVar.makeReturnJson(errMsg, a16, (Map<String, ? extends Object>) map);
        Intrinsics.checkNotNullExpressionValue(makeReturnJson2, "makeReturnJson(errMsg, errInfo, errInfoMap)");
        return makeReturnJson2;
    }
}
