package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.adapt_width;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.event.FrameEventKt;
import com.tencent.kuikly.core.base.k;
import com.tencent.kuikly.core.base.l;
import com.tencent.kuikly.core.layout.d;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.u;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* compiled from: P */
/* loaded from: classes32.dex */
public abstract class QSearchBaseAdaptWidthView<A extends k, E extends l> extends ComposeView<A, E> {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(QSearchBaseAdaptWidthView.class, "width", "getWidth()F", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(QSearchBaseAdaptWidthView.class, NodeProps.MAX_WIDTH, "getMaxWidth()F", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(QSearchBaseAdaptWidthView.class, "layoutFinished", "getLayoutFinished()Z", 0)};
    public final ReadWriteProperty width$delegate = c.a(Float.valueOf(0.0f));
    public final ReadWriteProperty maxWidth$delegate = c.a(Float.valueOf(Float.MAX_VALUE));
    public final ReadWriteProperty layoutFinished$delegate = c.a(Boolean.FALSE);

    public static final void access$adjustContentWidth(final QSearchBaseAdaptWidthView qSearchBaseAdaptWidthView) {
        if (qSearchBaseAdaptWidthView.getWidth() > qSearchBaseAdaptWidthView.getMaxWidth()) {
            qSearchBaseAdaptWidthView.getPager().addNextTickTask(new Function0<Unit>(qSearchBaseAdaptWidthView) { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.adapt_width.QSearchBaseAdaptWidthView$adjustContentWidth$1
                public final /* synthetic */ QSearchBaseAdaptWidthView<k, l> this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.this$0 = qSearchBaseAdaptWidthView;
                }

                @Override // kotlin.jvm.functions.Function0
                public final Unit invoke() {
                    this.this$0.shrinkWidth();
                    this.this$0.setLayoutFinished(true);
                    return Unit.INSTANCE;
                }
            });
        } else {
            if (qSearchBaseAdaptWidthView.getWidth() <= 0.0f || qSearchBaseAdaptWidthView.getMaxWidth() >= Float.MAX_VALUE) {
                return;
            }
            qSearchBaseAdaptWidthView.setLayoutFinished(true);
        }
    }

    public abstract Function1<ViewContainer<?, ?>, Unit> buildContent();

    @Override // com.tencent.kuikly.core.base.ComposeView
    public void created() {
        super.created();
        bindValueChange(new Function0<Object>(this) { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.adapt_width.QSearchBaseAdaptWidthView$created$1
            public final /* synthetic */ QSearchBaseAdaptWidthView<A, E> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Float.valueOf(this.this$0.getWidth());
            }
        }, new Function1<Object, Unit>(this) { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.adapt_width.QSearchBaseAdaptWidthView$created$2
            public final /* synthetic */ QSearchBaseAdaptWidthView<A, E> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Object obj) {
                QSearchBaseAdaptWidthView.access$adjustContentWidth(this.this$0);
                return Unit.INSTANCE;
            }
        });
        bindValueChange(new Function0<Object>(this) { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.adapt_width.QSearchBaseAdaptWidthView$created$3
            public final /* synthetic */ QSearchBaseAdaptWidthView<A, E> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Float.valueOf(this.this$0.getMaxWidth());
            }
        }, new Function1<Object, Unit>(this) { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.adapt_width.QSearchBaseAdaptWidthView$created$4
            public final /* synthetic */ QSearchBaseAdaptWidthView<A, E> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Object obj) {
                QSearchBaseAdaptWidthView.access$adjustContentWidth(this.this$0);
                return Unit.INSTANCE;
            }
        });
    }

    public final float getMaxWidth() {
        return ((Number) this.maxWidth$delegate.getValue(this, $$delegatedProperties[1])).floatValue();
    }

    public final float getWidth() {
        return ((Number) this.width$delegate.getValue(this, $$delegatedProperties[0])).floatValue();
    }

    public final void setLayoutFinished(boolean z16) {
        this.layoutFinished$delegate.setValue(this, $$delegatedProperties[2], Boolean.valueOf(z16));
    }

    public abstract boolean shrinkWidth();

    @Override // com.tencent.kuikly.core.base.ComposeView
    public Function1<ViewContainer<?, ?>, Unit> body() {
        setLayoutFinished(false);
        return new Function1<ViewContainer<?, ?>, Unit>(this) { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.adapt_width.QSearchBaseAdaptWidthView$body$1
            public final /* synthetic */ QSearchBaseAdaptWidthView<A, E> $ctx;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$ctx = this;
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                final QSearchBaseAdaptWidthView<A, E> qSearchBaseAdaptWidthView = this.$ctx;
                w.a(viewContainer, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.adapt_width.QSearchBaseAdaptWidthView$body$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.adapt_width.QSearchBaseAdaptWidthView.body.1.1.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                tVar.flexDirectionRow();
                                return Unit.INSTANCE;
                            }
                        });
                        final QSearchBaseAdaptWidthView<k, l> qSearchBaseAdaptWidthView2 = qSearchBaseAdaptWidthView;
                        vVar2.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.adapt_width.QSearchBaseAdaptWidthView.body.1.1.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(u uVar) {
                                final QSearchBaseAdaptWidthView<k, l> qSearchBaseAdaptWidthView3 = qSearchBaseAdaptWidthView2;
                                FrameEventKt.d(uVar, new Function1<d, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.adapt_width.QSearchBaseAdaptWidthView.body.1.1.2.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(d dVar) {
                                        d dVar2 = dVar;
                                        if (dVar2.getWidth() > 0.0f) {
                                            QSearchBaseAdaptWidthView<k, l> qSearchBaseAdaptWidthView4 = qSearchBaseAdaptWidthView3;
                                            qSearchBaseAdaptWidthView4.maxWidth$delegate.setValue(qSearchBaseAdaptWidthView4, QSearchBaseAdaptWidthView.$$delegatedProperties[1], Float.valueOf(dVar2.getWidth()));
                                        }
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final QSearchBaseAdaptWidthView<k, l> qSearchBaseAdaptWidthView3 = qSearchBaseAdaptWidthView;
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.adapt_width.QSearchBaseAdaptWidthView.body.1.1.3
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                v vVar4 = vVar3;
                                final QSearchBaseAdaptWidthView<k, l> qSearchBaseAdaptWidthView4 = qSearchBaseAdaptWidthView3;
                                vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.adapt_width.QSearchBaseAdaptWidthView.body.1.1.3.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.flexDirectionRow();
                                        tVar2.alignItemsCenter();
                                        QSearchBaseAdaptWidthView<k, l> qSearchBaseAdaptWidthView5 = qSearchBaseAdaptWidthView4;
                                        tVar2.m147opacity(((Boolean) qSearchBaseAdaptWidthView5.layoutFinished$delegate.getValue(qSearchBaseAdaptWidthView5, QSearchBaseAdaptWidthView.$$delegatedProperties[2])).booleanValue() ? 1.0f : 0.0f);
                                        return Unit.INSTANCE;
                                    }
                                });
                                final QSearchBaseAdaptWidthView<k, l> qSearchBaseAdaptWidthView5 = qSearchBaseAdaptWidthView3;
                                vVar4.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.adapt_width.QSearchBaseAdaptWidthView.body.1.1.3.2
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(u uVar) {
                                        final QSearchBaseAdaptWidthView<k, l> qSearchBaseAdaptWidthView6 = qSearchBaseAdaptWidthView5;
                                        FrameEventKt.d(uVar, new Function1<d, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.adapt_width.QSearchBaseAdaptWidthView.body.1.1.3.2.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(d dVar) {
                                                QSearchBaseAdaptWidthView<k, l> qSearchBaseAdaptWidthView7 = qSearchBaseAdaptWidthView6;
                                                qSearchBaseAdaptWidthView7.width$delegate.setValue(qSearchBaseAdaptWidthView7, QSearchBaseAdaptWidthView.$$delegatedProperties[0], Float.valueOf(dVar.getWidth()));
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                qSearchBaseAdaptWidthView3.buildContent().invoke(vVar4);
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
}
