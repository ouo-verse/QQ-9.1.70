package com.tencent.hippykotlin.demo.pages.adelie.module;

import com.tencent.kuikly.core.module.Module;
import com.tencent.kuikly.core.nvi.serialization.json.b;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class AdelieRedDotModule extends Module {
    public static List getRedDotInfoListFromCache$default(AdelieRedDotModule adelieRedDotModule) {
        List emptyList;
        adelieRedDotModule.getClass();
        Object returnValue = adelieRedDotModule.toNative(false, "getRedDotInfoListFromCache", new e().toString(), null, true).getReturnValue();
        e eVar = null;
        String str = returnValue instanceof String ? (String) returnValue : null;
        if (str == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        try {
            eVar = new e(str);
        } catch (Exception unused) {
        }
        return adelieRedDotModule.parseRedDotInfoList(eVar);
    }

    public static void getRedDotInfoListFromNet$default(final AdelieRedDotModule adelieRedDotModule, final Function1 function1) {
        adelieRedDotModule.getClass();
        adelieRedDotModule.toNative(false, "getRedDotInfoListFromNet", new e().toString(), new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.module.AdelieRedDotModule$getRedDotInfoListFromNet$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(e eVar) {
                e m3;
                e eVar2 = eVar;
                if (eVar2 != null && (m3 = eVar2.m("data")) != null) {
                    function1.invoke(adelieRedDotModule.parseRedDotInfoList(m3));
                }
                return Unit.INSTANCE;
            }
        }, false);
    }

    @Override // com.tencent.kuikly.core.module.Module
    public final String moduleName() {
        return "AdelieRedDotModule";
    }

    public final List<AdelieRedDotModule$Companion$RedDotInfo> parseRedDotInfoList(e eVar) {
        List<AdelieRedDotModule$Companion$RedDotInfo> emptyList;
        b l3;
        if (eVar == null || (l3 = eVar.l("redDotInfoList")) == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        ArrayList arrayList = new ArrayList();
        int c16 = l3.c();
        for (int i3 = 0; i3 < c16; i3++) {
            e l16 = l3.l(i3);
            if (l16 != null) {
                arrayList.add(new AdelieRedDotModule$Companion$RedDotInfo(l16.p("revokeId"), l16.n("robotUin"), l16.p("redDotText"), l16.j("bizType")));
            }
        }
        return arrayList;
    }
}
