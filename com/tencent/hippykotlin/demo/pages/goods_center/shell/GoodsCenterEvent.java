package com.tencent.hippykotlin.demo.pages.goods_center.shell;

import com.tencent.kuikly.core.base.l;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class GoodsCenterEvent extends l {
    public final void goodsCenterEvent(final Function2<? super String, Object, Unit> function2) {
        register("goodsCenterEvent", new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.shell.GoodsCenterEvent$goodsCenterEvent$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Object obj) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Any>");
                Map map = (Map) obj;
                Function2<String, Object, Unit> function22 = function2;
                Object obj2 = map.get("bizEventName");
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.String");
                function22.invoke((String) obj2, map.get("bizEventData"));
                return Unit.INSTANCE;
            }
        });
    }

    @Override // com.tencent.kuikly.core.base.l, com.tencent.kuikly.core.base.event.Event, com.tencent.kuikly.core.base.event.b, com.tencent.kuikly.core.base.event.d
    public final boolean onFireEvent(String str, Object obj) {
        Map mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("bizEventName", str), TuplesKt.to("bizEventData", obj));
        return super.onFireEvent("goodsCenterEvent", mapOf);
    }
}
