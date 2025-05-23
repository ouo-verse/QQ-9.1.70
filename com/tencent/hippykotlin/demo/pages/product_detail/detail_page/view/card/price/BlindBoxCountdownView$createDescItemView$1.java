package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price;

import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class BlindBoxCountdownView$createDescItemView$1 extends Lambda implements Function1<ViewContainer<?, ?>, Unit> {
    public final /* synthetic */ float $marginLeft;
    public final /* synthetic */ float $marginRight;
    public final /* synthetic */ String $text;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BlindBoxCountdownView$createDescItemView$1(float f16, float f17, String str) {
        super(1);
        this.$marginLeft = f16;
        this.$marginRight = f17;
        this.$text = str;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(ViewContainer<?, ?> viewContainer) {
        final float f16 = this.$marginLeft;
        final float f17 = this.$marginRight;
        final String str = this.$text;
        cg.a(viewContainer, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price.BlindBoxCountdownView$createDescItemView$1.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(TextView textView) {
                final float f18 = f16;
                final float f19 = f17;
                final String str2 = str;
                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price.BlindBoxCountdownView.createDescItemView.1.1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ce ceVar) {
                        ce ceVar2 = ceVar;
                        ceVar2.fontWeight500();
                        ceVar2.lines(1);
                        ce.fontSize$default(ceVar2, 12.0f, null, 2, null);
                        ceVar2.color(h.INSTANCE.m());
                        ceVar2.marginLeft(f18);
                        ceVar2.marginRight(f19);
                        ceVar2.text(str2);
                        return Unit.INSTANCE;
                    }
                });
                return Unit.INSTANCE;
            }
        });
        return Unit.INSTANCE;
    }
}
