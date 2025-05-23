package com.tencent.hippykotlin.demo.pages.base;

import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.Direction;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.j;
import com.tencent.kuikly.core.base.l;
import com.tencent.kuikly.core.layout.FlexNode;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECButton extends ComposeView<ECButtonAttr, l> {
    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ ECButtonAttr access$getAttr(ECButton eCButton) {
        return (ECButtonAttr) eCButton.getAttr();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.ECButton$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                final ECButton eCButton = ECButton.this;
                w.a(viewContainer, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.ECButton$body$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        final ECButton eCButton2 = ECButton.this;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.ECButton.body.1.1.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                h hVar;
                                h hVar2;
                                t tVar2 = tVar;
                                tVar2.allCenter();
                                Object prop = ECButton.access$getAttr(ECButton.this).getProp(NodeProps.BORDER_RADIUS);
                                Float f16 = prop instanceof Float ? (Float) prop : null;
                                tVar2.borderRadius(f16 != null ? f16.floatValue() : 4.0f);
                                FlexNode flexNode = ECButton.access$getAttr(ECButton.this).getFlexNode();
                                if (flexNode != null) {
                                    tVar2.mo141height(flexNode.K());
                                }
                                if (ECButton.access$getAttr(ECButton.this).isCirStyle) {
                                    tVar2.backgroundColor(4278229503L);
                                } else {
                                    Direction direction = Direction.TO_RIGHT;
                                    hVar = IPagerIdKtxKt.getSkinColor(tVar2).tokenColor(ECButton.access$getAttr(ECButton.this).startColorToken, false);
                                    hVar2 = IPagerIdKtxKt.getSkinColor(tVar2).tokenColor(ECButton.access$getAttr(ECButton.this).endColorToken, false);
                                    tVar2.mo135backgroundLinearGradient(direction, new j(hVar, 0.0f), new j(hVar2, 1.0f));
                                }
                                return Unit.INSTANCE;
                            }
                        });
                        final ECButton eCButton3 = ECButton.this;
                        cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.ECButton.body.1.1.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(TextView textView) {
                                final ECButton eCButton4 = ECButton.this;
                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.ECButton.body.1.1.2.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ce ceVar) {
                                        ce ceVar2 = ceVar;
                                        ce.fontSize$default(ceVar2, 16.0f, null, 2, null);
                                        ceVar2.color(h.INSTANCE.m());
                                        Function1<? super ce, Unit> function1 = ECButton.access$getAttr(ECButton.this).titleAttrInit;
                                        if (function1 != null) {
                                            function1.invoke(ceVar2);
                                        }
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
        };
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return new ECButtonAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new l();
    }
}
