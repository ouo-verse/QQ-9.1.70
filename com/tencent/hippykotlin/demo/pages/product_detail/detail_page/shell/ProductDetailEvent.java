package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell;

import com.tencent.kuikly.core.base.l;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public class ProductDetailEvent extends l {
    public final void productDetailEvent(final Function2<? super String, Object, Unit> function2) {
        register("productDetailEvent", new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.ProductDetailEvent$productDetailEvent$1
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

    public final boolean onFireProductDetailEvent(String str, Object obj) {
        return super.onFireEvent("productDetailEvent", MapsKt.mapOf(TuplesKt.to("bizEventName", str), TuplesKt.to("bizEventData", obj)));
    }
}
