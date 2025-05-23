package com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.modifer_ext;

import com.tencent.hippykotlin.demo.pages.base.EcommerceExtKt;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.pager.h;
import com.tencent.ntcompose.core.ModifiersKt;
import com.tencent.ntcompose.core.i;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ModifierExtKt {
    public static final i elementVR(i iVar, final String str, e eVar) {
        final e processVRPageData = processVRPageData(eVar);
        return ModifiersKt.d(iVar, "elementVR", new Function2<Attr, Event, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.modifer_ext.ModifierExtKt$elementVR$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Attr attr, Event event) {
                EcommerceExtKt.elementVR(attr, str, processVRPageData);
                return Unit.INSTANCE;
            }
        });
    }

    public static i elementVR$default(i iVar, final String str, e eVar, final String str2) {
        final e processVRPageData = processVRPageData(eVar);
        final boolean z16 = true;
        return ModifiersKt.d(iVar, "elementVR", new Function2<Attr, Event, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.modifer_ext.ModifierExtKt$elementVR$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Attr attr, Event event) {
                EcommerceExtKt.vr$default(attr, null, str, processVRPageData, null, str2, z16, 8);
                return Unit.INSTANCE;
            }
        });
    }

    public static final i pageVR(i iVar, final String str, final e eVar) {
        return ModifiersKt.d(iVar, "pageVR", new Function2<Attr, Event, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.modifer_ext.ModifierExtKt$pageVR$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Attr attr, Event event) {
                EcommerceExtKt.pageVR(attr, str, eVar);
                return Unit.INSTANCE;
            }
        });
    }

    public static final e processVRPageData(e eVar) {
        Object obj = h.a().getExtProps().get("vr_page_data");
        e eVar2 = obj instanceof e ? (e) obj : null;
        if (eVar2 == null) {
            return eVar == null ? new e() : eVar;
        }
        if (eVar == null) {
            return eVar2;
        }
        Iterator<String> c16 = eVar2.c();
        while (c16.hasNext()) {
            String next = c16.next();
            if (!eVar.a(next)) {
                eVar.v(next, eVar2.p(next));
            }
        }
        return eVar;
    }
}
