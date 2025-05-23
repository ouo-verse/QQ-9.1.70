package com.tencent.hippykotlin.demo.pages.retain.view;

import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes33.dex */
public final class RetainPopWindowCouponView$timeCubeView$1 extends Lambda implements Function1<ViewContainer<?, ?>, Unit> {
    public final /* synthetic */ String $timeStr;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RetainPopWindowCouponView$timeCubeView$1(String str) {
        super(1);
        this.$timeStr = str;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(ViewContainer<?, ?> viewContainer) {
        final String str = this.$timeStr;
        w.a(viewContainer, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.retain.view.RetainPopWindowCouponView$timeCubeView$1.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(v vVar) {
                v vVar2 = vVar;
                vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.retain.view.RetainPopWindowCouponView.timeCubeView.1.1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(t tVar) {
                        h hVar;
                        t tVar2 = tVar;
                        tVar2.mo141height(20.0f);
                        tVar2.m146minWidth(20.0f);
                        hVar = IPagerIdKtxKt.getSkinColor(tVar2).tokenColor("qecommerce_skin_color_tag_normal", false);
                        tVar2.mo113backgroundColor(hVar);
                        tVar2.marginLeft(4.0f);
                        tVar2.marginRight(4.0f);
                        tVar2.allCenter();
                        tVar2.borderRadius(2.0f);
                        return Unit.INSTANCE;
                    }
                });
                final String str2 = str;
                cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.retain.view.RetainPopWindowCouponView.timeCubeView.1.1.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(TextView textView) {
                        final String str3 = str2;
                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.retain.view.RetainPopWindowCouponView.timeCubeView.1.1.2.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ce ceVar) {
                                h hVar;
                                ce ceVar2 = ceVar;
                                ceVar2.text(str3);
                                ceVar2.marginLeft(2.5f);
                                ceVar2.marginRight(2.5f);
                                hVar = IPagerIdKtxKt.getSkinColor(ceVar2).tokenColor("qecommerce_skin_color_text_red_brand", false);
                                ceVar2.color(hVar);
                                ce.fontSize$default(ceVar2, 12.0f, null, 2, null);
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                return Unit.INSTANCE;
            }
        });
        return Unit.INSTANCE;
    }
}
