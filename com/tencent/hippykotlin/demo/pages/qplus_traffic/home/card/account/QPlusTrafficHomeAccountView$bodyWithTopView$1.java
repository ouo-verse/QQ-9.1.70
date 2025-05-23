package com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.account;

import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes31.dex */
public final class QPlusTrafficHomeAccountView$bodyWithTopView$1 extends Lambda implements Function1<ViewContainer<?, ?>, Unit> {
    public static final QPlusTrafficHomeAccountView$bodyWithTopView$1 INSTANCE = new QPlusTrafficHomeAccountView$bodyWithTopView$1();

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(ViewContainer<?, ?> viewContainer) {
        cg.a(viewContainer, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.account.QPlusTrafficHomeAccountView$bodyWithTopView$1.1
            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(TextView textView) {
                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.account.QPlusTrafficHomeAccountView.bodyWithTopView.1.1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ce ceVar) {
                        h hVar;
                        ce ceVar2 = ceVar;
                        ce.fontSize$default(ceVar2, 15.0f, null, 2, null).fontWeightBold();
                        ceVar2.marginLeft(16.0f).marginTop(16.0f);
                        hVar = IPagerIdKtxKt.getSkinColor(ceVar2).tokenColor("qecommerce_skin_color_text_primary", false);
                        ceVar2.color(hVar);
                        ceVar2.text("\u6211\u7684\u5e10\u6237");
                        return Unit.INSTANCE;
                    }
                });
                return Unit.INSTANCE;
            }
        });
        return Unit.INSTANCE;
    }

    public QPlusTrafficHomeAccountView$bodyWithTopView$1() {
        super(1);
    }
}
