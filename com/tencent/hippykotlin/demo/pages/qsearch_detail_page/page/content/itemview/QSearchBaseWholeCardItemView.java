package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview;

import com.tencent.hippykotlin.demo.pages.base.QUISkinColor;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.QSearchBaseWholeCardItemAttr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.l;
import com.tencent.kuikly.core.directives.BindDirectivesView;
import com.tencent.kuikly.core.directives.BindDirectivesViewKt;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
/* loaded from: classes32.dex */
public abstract class QSearchBaseWholeCardItemView<A extends QSearchBaseWholeCardItemAttr, E extends l> extends ComposeView<A, E> {
    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ QSearchBaseWholeCardItemAttr access$getAttr(QSearchBaseWholeCardItemView qSearchBaseWholeCardItemView) {
        return (QSearchBaseWholeCardItemAttr) qSearchBaseWholeCardItemView.getAttr();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>(this) { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.QSearchBaseWholeCardItemView$body$1
            public final /* synthetic */ QSearchBaseWholeCardItemView<A, E> $ctx;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$ctx = this;
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                final QSearchBaseWholeCardItemView<A, E> qSearchBaseWholeCardItemView = this.$ctx;
                w.a(viewContainer, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.QSearchBaseWholeCardItemView$body$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.QSearchBaseWholeCardItemView.body.1.1.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.paddingLeft(8.0f);
                                tVar2.paddingRight(8.0f);
                                return Unit.INSTANCE;
                            }
                        });
                        final QSearchBaseWholeCardItemView<QSearchBaseWholeCardItemAttr, l> qSearchBaseWholeCardItemView2 = qSearchBaseWholeCardItemView;
                        Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.QSearchBaseWholeCardItemView.body.1.1.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Boolean.valueOf(QSearchBaseWholeCardItemView.access$getAttr(qSearchBaseWholeCardItemView2).isLastItem());
                            }
                        };
                        final QSearchBaseWholeCardItemView<QSearchBaseWholeCardItemAttr, l> qSearchBaseWholeCardItemView3 = qSearchBaseWholeCardItemView;
                        BindDirectivesViewKt.a(vVar2, function0, new Function1<BindDirectivesView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.QSearchBaseWholeCardItemView.body.1.1.3
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(BindDirectivesView bindDirectivesView) {
                                BindDirectivesView bindDirectivesView2 = bindDirectivesView;
                                if (QSearchBaseWholeCardItemView.access$getAttr(qSearchBaseWholeCardItemView3).isFirstItem && QSearchBaseWholeCardItemView.access$getAttr(qSearchBaseWholeCardItemView3).isLastItem()) {
                                    final QSearchBaseWholeCardItemView<QSearchBaseWholeCardItemAttr, l> qSearchBaseWholeCardItemView4 = qSearchBaseWholeCardItemView3;
                                    qSearchBaseWholeCardItemView4.getClass();
                                    new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.QSearchBaseWholeCardItemView$buildFirstLastItem$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(ViewContainer<?, ?> viewContainer2) {
                                            final QSearchBaseWholeCardItemView<QSearchBaseWholeCardItemAttr, l> qSearchBaseWholeCardItemView5 = qSearchBaseWholeCardItemView4;
                                            w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.QSearchBaseWholeCardItemView$buildFirstLastItem$1.1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(v vVar3) {
                                                    v vVar4 = vVar3;
                                                    vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.QSearchBaseWholeCardItemView.buildFirstLastItem.1.1.1
                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(t tVar) {
                                                            tVar.paddingTop(8.0f);
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    final QSearchBaseWholeCardItemView<QSearchBaseWholeCardItemAttr, l> qSearchBaseWholeCardItemView6 = qSearchBaseWholeCardItemView5;
                                                    w.a(vVar4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.QSearchBaseWholeCardItemView.buildFirstLastItem.1.1.2
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(v vVar5) {
                                                            v vVar6 = vVar5;
                                                            vVar6.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.QSearchBaseWholeCardItemView.buildFirstLastItem.1.1.2.1
                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(t tVar) {
                                                                    t tVar2 = tVar;
                                                                    tVar2.padding(0.0f, 16.0f, 0.0f, 16.0f);
                                                                    tVar2.mo113backgroundColor(QUISkinColor.INSTANCE.wrapColor("fill_light_secondary"));
                                                                    tVar2.borderRadius(8.0f);
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                            qSearchBaseWholeCardItemView6.buildItem(false).invoke(vVar6);
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            return Unit.INSTANCE;
                                        }
                                    }.invoke(bindDirectivesView2);
                                } else if (QSearchBaseWholeCardItemView.access$getAttr(qSearchBaseWholeCardItemView3).isFirstItem) {
                                    final QSearchBaseWholeCardItemView<QSearchBaseWholeCardItemAttr, l> qSearchBaseWholeCardItemView5 = qSearchBaseWholeCardItemView3;
                                    qSearchBaseWholeCardItemView5.getClass();
                                    new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.QSearchBaseWholeCardItemView$buildFirstItem$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(ViewContainer<?, ?> viewContainer2) {
                                            final QSearchBaseWholeCardItemView<QSearchBaseWholeCardItemAttr, l> qSearchBaseWholeCardItemView6 = qSearchBaseWholeCardItemView5;
                                            w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.QSearchBaseWholeCardItemView$buildFirstItem$1.1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(v vVar3) {
                                                    v vVar4 = vVar3;
                                                    vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.QSearchBaseWholeCardItemView.buildFirstItem.1.1.1
                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(t tVar) {
                                                            tVar.paddingTop(8.0f);
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    final QSearchBaseWholeCardItemView<QSearchBaseWholeCardItemAttr, l> qSearchBaseWholeCardItemView7 = qSearchBaseWholeCardItemView6;
                                                    w.a(vVar4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.QSearchBaseWholeCardItemView.buildFirstItem.1.1.2
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(v vVar5) {
                                                            v vVar6 = vVar5;
                                                            vVar6.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.QSearchBaseWholeCardItemView.buildFirstItem.1.1.2.1
                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(t tVar) {
                                                                    t tVar2 = tVar;
                                                                    tVar2.padding(0.0f, 16.0f, 0.0f, 16.0f);
                                                                    tVar2.mo113backgroundColor(QUISkinColor.INSTANCE.wrapColor("fill_light_secondary"));
                                                                    tVar2.borderRadius(8.0f, 8.0f, 0.0f, 0.0f);
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                            qSearchBaseWholeCardItemView7.buildItem(true).invoke(vVar6);
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            return Unit.INSTANCE;
                                        }
                                    }.invoke(bindDirectivesView2);
                                } else if (QSearchBaseWholeCardItemView.access$getAttr(qSearchBaseWholeCardItemView3).isLastItem()) {
                                    final QSearchBaseWholeCardItemView<QSearchBaseWholeCardItemAttr, l> qSearchBaseWholeCardItemView6 = qSearchBaseWholeCardItemView3;
                                    qSearchBaseWholeCardItemView6.getClass();
                                    new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.QSearchBaseWholeCardItemView$buildLastItem$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(ViewContainer<?, ?> viewContainer2) {
                                            final QSearchBaseWholeCardItemView<QSearchBaseWholeCardItemAttr, l> qSearchBaseWholeCardItemView7 = qSearchBaseWholeCardItemView6;
                                            w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.QSearchBaseWholeCardItemView$buildLastItem$1.1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(v vVar3) {
                                                    final QSearchBaseWholeCardItemView<QSearchBaseWholeCardItemAttr, l> qSearchBaseWholeCardItemView8 = qSearchBaseWholeCardItemView7;
                                                    w.a(vVar3, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.QSearchBaseWholeCardItemView.buildLastItem.1.1.1
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(v vVar4) {
                                                            v vVar5 = vVar4;
                                                            vVar5.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.QSearchBaseWholeCardItemView.buildLastItem.1.1.1.1
                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(t tVar) {
                                                                    t tVar2 = tVar;
                                                                    tVar2.padding(0.0f, 16.0f, 0.0f, 16.0f);
                                                                    tVar2.mo113backgroundColor(QUISkinColor.INSTANCE.wrapColor("fill_light_secondary"));
                                                                    tVar2.borderRadius(0.0f, 0.0f, 8.0f, 8.0f);
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                            qSearchBaseWholeCardItemView8.buildItem(false).invoke(vVar5);
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            return Unit.INSTANCE;
                                        }
                                    }.invoke(bindDirectivesView2);
                                } else {
                                    final QSearchBaseWholeCardItemView<QSearchBaseWholeCardItemAttr, l> qSearchBaseWholeCardItemView7 = qSearchBaseWholeCardItemView3;
                                    qSearchBaseWholeCardItemView7.getClass();
                                    new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.QSearchBaseWholeCardItemView$buildMiddleItem$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(ViewContainer<?, ?> viewContainer2) {
                                            final QSearchBaseWholeCardItemView<QSearchBaseWholeCardItemAttr, l> qSearchBaseWholeCardItemView8 = qSearchBaseWholeCardItemView7;
                                            w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.QSearchBaseWholeCardItemView$buildMiddleItem$1.1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(v vVar3) {
                                                    v vVar4 = vVar3;
                                                    vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.QSearchBaseWholeCardItemView.buildMiddleItem.1.1.1
                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(t tVar) {
                                                            t tVar2 = tVar;
                                                            tVar2.padding(0.0f, 16.0f, 0.0f, 16.0f);
                                                            tVar2.mo113backgroundColor(QUISkinColor.INSTANCE.wrapColor("fill_light_secondary"));
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    qSearchBaseWholeCardItemView8.buildItem(true).invoke(vVar4);
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            return Unit.INSTANCE;
                                        }
                                    }.invoke(bindDirectivesView2);
                                }
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

    public abstract Function1<ViewContainer<?, ?>, Unit> buildItem(boolean z16);
}
