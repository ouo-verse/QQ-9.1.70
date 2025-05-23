package com.tencent.hippykotlin.demo.pages.nearby.publish.view;

import com.tencent.hippykotlin.demo.pages.nearby.publish.NBPPublishViewModel;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.g;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.directives.LoopDirectivesView;
import com.tencent.kuikly.core.directives.LoopDirectivesViewKt;
import com.tencent.kuikly.core.reactive.collection.c;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.ao;
import com.tencent.kuikly.core.views.aq;
import com.tencent.kuikly.core.views.ar;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import o25.f;

/* loaded from: classes31.dex */
public final class NBPPublishThemeSelectionView extends ComposeView<NBPPublishThemeSelectionAttr, NBPPublishThemeSelectionEvent> {
    public float listViewHeight = 400.0f;

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ NBPPublishThemeSelectionAttr access$getAttr(NBPPublishThemeSelectionView nBPPublishThemeSelectionView) {
        return (NBPPublishThemeSelectionAttr) nBPPublishThemeSelectionView.getAttr();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishThemeSelectionView$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                final NBPPublishThemeSelectionView nBPPublishThemeSelectionView = NBPPublishThemeSelectionView.this;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishThemeSelectionView$body$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        mVar2.mo113backgroundColor(h.INSTANCE.m());
                        mVar2.alignItemsCenter();
                        mVar2.flexDirectionColumn();
                        mVar2.mo153width(mVar2.getPagerData().m());
                        mVar2.mo141height(NBPPublishThemeSelectionView.this.listViewHeight);
                        mVar2.borderRadius(8.0f);
                        mVar2.mo139boxShadow(new g(0.0f, 4.0f, 8.0f, new h(0L, 0.08f)));
                        return Unit.INSTANCE;
                    }
                });
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishThemeSelectionView$body$1.2
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishThemeSelectionView.body.1.2.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.size(tVar2.getPagerData().m(), 14.0f);
                                tVar2.allCenter();
                                return Unit.INSTANCE;
                            }
                        });
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishThemeSelectionView.body.1.2.2
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                vVar3.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishThemeSelectionView.body.1.2.2.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.size(36.0f, 5.0f);
                                        tVar2.borderRadius(3.0f);
                                        tVar2.mo113backgroundColor(new h(4291611852L));
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                cg.a(viewContainer2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishThemeSelectionView$body$1.3
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(TextView textView) {
                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishThemeSelectionView.body.1.3.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ce ceVar) {
                                ce ceVar2 = ceVar;
                                ceVar2.marginTop(16.0f);
                                ceVar2.text("\u9009\u62e9\u4e3b\u9898\u5730\u56fe");
                                ceVar2.color(new h(4279901214L));
                                ce.fontSize$default(ceVar2, 17.0f, null, 2, null);
                                ceVar2.fontWeight500();
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final NBPPublishThemeSelectionView nBPPublishThemeSelectionView2 = NBPPublishThemeSelectionView.this;
                ar.a(viewContainer2, new Function1<aq<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishThemeSelectionView$body$1.4
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(aq<?, ?> aqVar) {
                        aq<?, ?> aqVar2 = aqVar;
                        final NBPPublishThemeSelectionView nBPPublishThemeSelectionView3 = NBPPublishThemeSelectionView.this;
                        aqVar2.attr(new Function1<ao, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishThemeSelectionView.body.1.4.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ao aoVar) {
                                ao aoVar2 = aoVar;
                                aoVar2.marginTop(8.0f);
                                aoVar2.m140flex(1.0f);
                                aoVar2.flexDirectionColumn();
                                aoVar2.showScrollerIndicator(false);
                                aoVar2.size(aoVar2.getPagerData().m(), NBPPublishThemeSelectionView.this.listViewHeight);
                                return Unit.INSTANCE;
                            }
                        });
                        final c cVar = new c(null, null, null, 7, null);
                        NBPPublishViewModel nBPPublishViewModel = null;
                        cVar.add(null);
                        NBPPublishViewModel nBPPublishViewModel2 = NBPPublishThemeSelectionView.access$getAttr(NBPPublishThemeSelectionView.this).viewModel;
                        if (nBPPublishViewModel2 != null) {
                            nBPPublishViewModel = nBPPublishViewModel2;
                        } else {
                            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                        }
                        cVar.addAll(nBPPublishViewModel.getThemeList());
                        Function0<c<f>> function0 = new Function0<c<f>>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishThemeSelectionView.body.1.4.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final c<f> invoke() {
                                return cVar;
                            }
                        };
                        final NBPPublishThemeSelectionView nBPPublishThemeSelectionView4 = NBPPublishThemeSelectionView.this;
                        LoopDirectivesViewKt.a(aqVar2, function0, new Function2<LoopDirectivesView<f>, f, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishThemeSelectionView.body.1.4.3
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public final Unit invoke(LoopDirectivesView<f> loopDirectivesView, f fVar) {
                                final f fVar2 = fVar;
                                final NBPPublishThemeSelectionView nBPPublishThemeSelectionView5 = NBPPublishThemeSelectionView.this;
                                loopDirectivesView.addChild(new NBPPublishThemeSelectionItemView(), new Function1<NBPPublishThemeSelectionItemView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishThemeSelectionView.body.1.4.3.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(NBPPublishThemeSelectionItemView nBPPublishThemeSelectionItemView) {
                                        NBPPublishThemeSelectionItemView nBPPublishThemeSelectionItemView2 = nBPPublishThemeSelectionItemView;
                                        final f fVar3 = f.this;
                                        final NBPPublishThemeSelectionView nBPPublishThemeSelectionView6 = nBPPublishThemeSelectionView5;
                                        nBPPublishThemeSelectionItemView2.attr(new Function1<NBPPublishThemeSelectionItemAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishThemeSelectionView.body.1.4.3.1.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(NBPPublishThemeSelectionItemAttr nBPPublishThemeSelectionItemAttr) {
                                                NBPPublishThemeSelectionItemAttr nBPPublishThemeSelectionItemAttr2 = nBPPublishThemeSelectionItemAttr;
                                                nBPPublishThemeSelectionItemAttr2.mapTheme = f.this;
                                                NBPPublishViewModel nBPPublishViewModel3 = NBPPublishThemeSelectionView.access$getAttr(nBPPublishThemeSelectionView6).viewModel;
                                                if (nBPPublishViewModel3 == null) {
                                                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                                                    nBPPublishViewModel3 = null;
                                                }
                                                nBPPublishThemeSelectionItemAttr2.viewModel = nBPPublishViewModel3;
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final NBPPublishThemeSelectionView nBPPublishThemeSelectionView7 = nBPPublishThemeSelectionView5;
                                        nBPPublishThemeSelectionItemView2.event(new Function1<NBPPublishThemeSelectionItemEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishThemeSelectionView.body.1.4.3.1.2
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(NBPPublishThemeSelectionItemEvent nBPPublishThemeSelectionItemEvent) {
                                                final NBPPublishThemeSelectionView nBPPublishThemeSelectionView8 = NBPPublishThemeSelectionView.this;
                                                nBPPublishThemeSelectionItemEvent.eventHandler = new Function1<f, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishThemeSelectionView.body.1.4.3.1.2.1
                                                    {
                                                        super(1);
                                                    }

                                                    /* JADX WARN: Multi-variable type inference failed */
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(f fVar4) {
                                                        f fVar5 = fVar4;
                                                        Function1<? super f, Unit> function1 = ((NBPPublishThemeSelectionEvent) NBPPublishThemeSelectionView.this.getViewEvent()).eventHandler;
                                                        if (function1 != null) {
                                                            function1.invoke(fVar5);
                                                        }
                                                        return Unit.INSTANCE;
                                                    }
                                                };
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
                });
                return Unit.INSTANCE;
            }
        };
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return new NBPPublishThemeSelectionAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new NBPPublishThemeSelectionEvent();
    }
}
