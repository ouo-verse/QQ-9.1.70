package com.tencent.hippykotlin.demo.pages.nearby.base.view;

import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ah;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.n;
import com.tencent.kuikly.core.views.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* loaded from: classes31.dex */
public final class NBPTagView extends ComposeView<NBPTagAttr, NBPTagEvent> {
    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ NBPTagAttr access$getAttr(NBPTagView nBPTagView) {
        return (NBPTagAttr) nBPTagView.getAttr();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPTagView$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                final NBPTagView nBPTagView = NBPTagView.this;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPTagView$body$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        h hVar;
                        m mVar2 = mVar;
                        mVar2.flexDirectionRow();
                        mVar2.alignItemsCenter();
                        mVar2.mo141height(22.0f);
                        mVar2.paddingLeft(6.0f);
                        mVar2.paddingRight(6.0f);
                        mVar2.borderRadius(8.0f);
                        if (NBPTagView.access$getAttr(NBPTagView.this).isDarkStyle) {
                            hVar = new h(0L, 0.1f);
                        } else {
                            hVar = new h(16777215L, 0.1f);
                        }
                        mVar2.mo113backgroundColor(hVar);
                        return Unit.INSTANCE;
                    }
                });
                final NBPTagView nBPTagView2 = NBPTagView.this;
                ah.a(viewContainer2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPTagView$body$1.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ImageView imageView) {
                        final NBPTagView nBPTagView3 = NBPTagView.this;
                        imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPTagView.body.1.2.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(af afVar) {
                                h m3;
                                af afVar2 = afVar;
                                afVar2.size(14.0f, 14.0f);
                                afVar2.o();
                                NBPTagAttr access$getAttr = NBPTagView.access$getAttr(NBPTagView.this);
                                b.a.b(afVar2, (String) access$getAttr.tagIconSrc$delegate.getValue(access$getAttr, NBPTagAttr.$$delegatedProperties[0]), false, 2, null);
                                if (NBPTagView.access$getAttr(NBPTagView.this).isDarkStyle) {
                                    m3 = h.INSTANCE.b();
                                } else {
                                    m3 = h.INSTANCE.m();
                                }
                                afVar2.t(m3);
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final NBPTagView nBPTagView3 = NBPTagView.this;
                cg.a(viewContainer2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPTagView$body$1.3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(TextView textView) {
                        final NBPTagView nBPTagView4 = NBPTagView.this;
                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPTagView.body.1.3.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ce ceVar) {
                                h m3;
                                ce ceVar2 = ceVar;
                                if (NBPTagView.access$getAttr(NBPTagView.this).isDarkStyle) {
                                    m3 = h.INSTANCE.b();
                                } else {
                                    m3 = h.INSTANCE.m();
                                }
                                ceVar2.color(m3);
                                NBPTagAttr access$getAttr = NBPTagView.access$getAttr(NBPTagView.this);
                                ceVar2.text((String) access$getAttr.tagNameStr$delegate.getValue(access$getAttr, NBPTagAttr.$$delegatedProperties[1]));
                                ceVar2.marginLeft(2.0f);
                                ce.fontSize$default(ceVar2, 12.0f, null, 2, null);
                                ceVar2.lines(1);
                                ceVar2.m140flex(1.0f);
                                ceVar2.fontWeight500();
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                o.a(viewContainer2, new Function1<n, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPTagView$body$1.4
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(n nVar) {
                        nVar.attr(new Function1<com.tencent.kuikly.core.views.m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPTagView.body.1.4.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(com.tencent.kuikly.core.views.m mVar) {
                                Attr.absolutePosition$default(mVar, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
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
        return new NBPTagAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new NBPTagEvent();
    }
}
