package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.bottomArea.distribution;

import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt;
import com.tencent.kuikly.core.base.Direction;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.j;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.u;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import java.util.Arrays;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class DetailDistributionBottomView$bodyWithRedBtn$1 extends Lambda implements Function1<ViewContainer<?, ?>, Unit> {
    public final /* synthetic */ ButtonInfo $buttonInfo;
    public final /* synthetic */ float $width;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DetailDistributionBottomView$bodyWithRedBtn$1(float f16, ButtonInfo buttonInfo) {
        super(1);
        this.$width = f16;
        this.$buttonInfo = buttonInfo;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(ViewContainer<?, ?> viewContainer) {
        final float f16 = this.$width;
        final ButtonInfo buttonInfo = this.$buttonInfo;
        w.a(viewContainer, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.bottomArea.distribution.DetailDistributionBottomView$bodyWithRedBtn$1.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(v vVar) {
                v vVar2 = vVar;
                final float f17 = f16;
                final ButtonInfo buttonInfo2 = buttonInfo;
                vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.bottomArea.distribution.DetailDistributionBottomView.bodyWithRedBtn.1.1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(t tVar) {
                        t tVar2 = tVar;
                        tVar2.allCenter();
                        tVar2.borderRadius(4.0f).mo153width(f17);
                        Direction direction = Direction.TO_RIGHT;
                        j[] jVarArr = buttonInfo2.backGroundGradientColor;
                        tVar2.mo135backgroundLinearGradient(direction, (j[]) Arrays.copyOf(jVarArr, jVarArr.length));
                        return Unit.INSTANCE;
                    }
                });
                final ButtonInfo buttonInfo3 = buttonInfo;
                vVar2.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.bottomArea.distribution.DetailDistributionBottomView.bodyWithRedBtn.1.1.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(u uVar) {
                        final ButtonInfo buttonInfo4 = ButtonInfo.this;
                        uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.bottomArea.distribution.DetailDistributionBottomView.bodyWithRedBtn.1.1.2.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ClickParams clickParams) {
                                ButtonInfo.this.clickEvent.invoke();
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final ButtonInfo buttonInfo4 = buttonInfo;
                cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.bottomArea.distribution.DetailDistributionBottomView.bodyWithRedBtn.1.1.3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(TextView textView) {
                        final ButtonInfo buttonInfo5 = ButtonInfo.this;
                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.bottomArea.distribution.DetailDistributionBottomView.bodyWithRedBtn.1.1.3.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ce ceVar) {
                                h hVar;
                                ce ceVar2 = ceVar;
                                ceVar2.text(ButtonInfo.this.text);
                                ce.fontSize$default(ceVar2.fontWeightBold(), 16.0f, null, 2, null);
                                hVar = IPagerIdKtxKt.getSkinColor(ceVar2).tokenColor("qecommerce_color_bg_default", false);
                                ceVar2.color(hVar);
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
