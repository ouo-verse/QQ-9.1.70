package com.tencent.hippykotlin.demo.pages.nearby.publish.view;

import com.tencent.hippykotlin.demo.pages.nearby.publish.NBPPublishViewModel;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.b;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.g;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
import com.tencent.kuikly.core.directives.LoopDirectivesView;
import com.tencent.kuikly.core.directives.LoopDirectivesViewKt;
import com.tencent.kuikly.core.reactive.collection.c;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.TransitionType;
import com.tencent.kuikly.core.views.TransitionView;
import com.tencent.kuikly.core.views.TransitionViewKt;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ah;
import com.tencent.kuikly.core.views.ao;
import com.tencent.kuikly.core.views.aq;
import com.tencent.kuikly.core.views.ar;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.ci;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.u;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.reflect.KProperty;

/* loaded from: classes31.dex */
public final class NBPPublishImg2txtSelectionView extends ComposeView<NBPPublishImg2txtSelectionAttr, NBPPublishImg2txtSelectionEvent> {
    public float listViewHeight = 400.0f;

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ NBPPublishImg2txtSelectionAttr access$getAttr(NBPPublishImg2txtSelectionView nBPPublishImg2txtSelectionView) {
        return (NBPPublishImg2txtSelectionAttr) nBPPublishImg2txtSelectionView.getAttr();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishImg2txtSelectionView$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                final NBPPublishImg2txtSelectionView nBPPublishImg2txtSelectionView = NBPPublishImg2txtSelectionView.this;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishImg2txtSelectionView$body$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        mVar2.mo113backgroundColor(new h(4294309626L));
                        mVar2.alignItemsCenter();
                        mVar2.flexDirectionColumn();
                        mVar2.mo153width(mVar2.getPagerData().m());
                        mVar2.mo141height(NBPPublishImg2txtSelectionView.this.listViewHeight);
                        mVar2.borderRadius(8.0f);
                        mVar2.mo139boxShadow(new g(0.0f, 4.0f, 8.0f, new h(0L, 0.08f)));
                        return Unit.INSTANCE;
                    }
                });
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishImg2txtSelectionView$body$1.2
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishImg2txtSelectionView.body.1.2.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.size(tVar2.getPagerData().m(), 14.0f);
                                tVar2.allCenter();
                                return Unit.INSTANCE;
                            }
                        });
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishImg2txtSelectionView.body.1.2.2
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                vVar3.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishImg2txtSelectionView.body.1.2.2.1
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
                final NBPPublishImg2txtSelectionView nBPPublishImg2txtSelectionView2 = NBPPublishImg2txtSelectionView.this;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishImg2txtSelectionView$body$1.3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishImg2txtSelectionView.body.1.3.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.alignItemsCenter();
                                tVar2.flexDirectionRow();
                                tVar2.marginTop(16.0f);
                                tVar2.alignSelfStretch();
                                return Unit.INSTANCE;
                            }
                        });
                        ah.a(vVar2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishImg2txtSelectionView.body.1.3.2
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ImageView imageView) {
                                imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishImg2txtSelectionView.body.1.3.2.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(af afVar) {
                                        af afVar2 = afVar;
                                        afVar2.marginLeft(16.0f);
                                        b.a.b(afVar2, "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_ZSnKv45Z3m2.png", false, 2, null);
                                        afVar2.t(new h(4281282611L));
                                        afVar2.size(24.0f, 24.0f);
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishImg2txtSelectionView.body.1.3.3
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(TextView textView) {
                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishImg2txtSelectionView.body.1.3.3.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ce ceVar) {
                                        ce ceVar2 = ceVar;
                                        ceVar2.marginLeft(4.0f);
                                        ceVar2.text("\u8bd5\u8bd5\u8fd9\u4e9b\u8bdd");
                                        ceVar2.color(new h(4279901214L));
                                        ce.fontSize$default(ceVar2, 17.0f, null, 2, null);
                                        ceVar2.fontWeight500();
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishImg2txtSelectionView.body.1.3.4
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                vVar3.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishImg2txtSelectionView.body.1.3.4.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        tVar.m140flex(1.0f);
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final NBPPublishImg2txtSelectionView nBPPublishImg2txtSelectionView3 = NBPPublishImg2txtSelectionView.this;
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishImg2txtSelectionView.body.1.3.5
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                v vVar4 = vVar3;
                                final NBPPublishImg2txtSelectionView nBPPublishImg2txtSelectionView4 = NBPPublishImg2txtSelectionView.this;
                                vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishImg2txtSelectionView.body.1.3.5.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.size(24.0f, 24.0f);
                                        tVar2.allCenter();
                                        tVar2.marginRight(14.0f);
                                        tVar2.m151touchEnable(!NBPPublishImg2txtSelectionView.access$getAttr(NBPPublishImg2txtSelectionView.this).getViewModel().isRequestImg2txt());
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPPublishImg2txtSelectionView nBPPublishImg2txtSelectionView5 = NBPPublishImg2txtSelectionView.this;
                                ConditionViewKt.c(vVar4, new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishImg2txtSelectionView.body.1.3.5.2
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return Boolean.valueOf(NBPPublishImg2txtSelectionView.access$getAttr(NBPPublishImg2txtSelectionView.this).getViewModel().isRequestImg2txt());
                                    }
                                }, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishImg2txtSelectionView.body.1.3.5.3
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ConditionView conditionView) {
                                        TransitionViewKt.a(conditionView, TransitionType.CUSTOM, new Function1<TransitionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishImg2txtSelectionView.body.1.3.5.3.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(TransitionView transitionView) {
                                                TransitionView transitionView2 = transitionView;
                                                transitionView2.attr(new Function1<ci, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishImg2txtSelectionView.body.1.3.5.3.1.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ci ciVar) {
                                                        ci ciVar2 = ciVar;
                                                        ciVar2.i(new Function1<Attr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishImg2txtSelectionView.body.1.3.5.3.1.1.1
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(Attr attr) {
                                                                attr.transform(new com.tencent.kuikly.core.base.t(0.0f, 0.0f, 0.0f, 6, null));
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        ciVar2.j(new Function1<Attr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishImg2txtSelectionView.body.1.3.5.3.1.1.2
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(Attr attr) {
                                                                attr.transform(new com.tencent.kuikly.core.base.t(360.0f, 0.0f, 0.0f, 6, null));
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        ciVar2.h(b.Companion.l(com.tencent.kuikly.core.base.b.INSTANCE, 0.5f, null, 2, null).i(true));
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                ah.a(transitionView2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishImg2txtSelectionView.body.1.3.5.3.1.2
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ImageView imageView) {
                                                        imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishImg2txtSelectionView.body.1.3.5.3.1.2.1
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(af afVar) {
                                                                af afVar2 = afVar;
                                                                b.a.b(afVar2, "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_t67dmQ1UM82.png", false, 2, null);
                                                                afVar2.t(new h(4287664276L));
                                                                afVar2.size(20.0f, 20.0f);
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
                                ConditionViewKt.a(vVar4, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishImg2txtSelectionView.body.1.3.5.4
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ConditionView conditionView) {
                                        ah.a(conditionView, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishImg2txtSelectionView.body.1.3.5.4.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ImageView imageView) {
                                                imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishImg2txtSelectionView.body.1.3.5.4.1.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(af afVar) {
                                                        af afVar2 = afVar;
                                                        b.a.b(afVar2, "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_0HZjFeyvu4S.png", false, 2, null);
                                                        afVar2.t(new h(4281282611L));
                                                        afVar2.size(20.0f, 20.0f);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPPublishImg2txtSelectionView nBPPublishImg2txtSelectionView6 = NBPPublishImg2txtSelectionView.this;
                                vVar4.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishImg2txtSelectionView.body.1.3.5.5
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(u uVar) {
                                        final NBPPublishImg2txtSelectionView nBPPublishImg2txtSelectionView7 = NBPPublishImg2txtSelectionView.this;
                                        uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishImg2txtSelectionView.body.1.3.5.5.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ClickParams clickParams) {
                                                NBPPublishViewModel viewModel = NBPPublishImg2txtSelectionView.access$getAttr(NBPPublishImg2txtSelectionView.this).getViewModel();
                                                KProperty<Object>[] kPropertyArr = NBPPublishViewModel.$$delegatedProperties;
                                                viewModel.convertImageToText(false);
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
                final NBPPublishImg2txtSelectionView nBPPublishImg2txtSelectionView3 = NBPPublishImg2txtSelectionView.this;
                Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishImg2txtSelectionView$body$1.4
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Boolean.valueOf(NBPPublishImg2txtSelectionView.access$getAttr(NBPPublishImg2txtSelectionView.this).getViewModel().getImg2txtContentList().size() > 0);
                    }
                };
                final NBPPublishImg2txtSelectionView nBPPublishImg2txtSelectionView4 = NBPPublishImg2txtSelectionView.this;
                ConditionViewKt.c(viewContainer2, function0, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishImg2txtSelectionView$body$1.5
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ConditionView conditionView) {
                        final NBPPublishImg2txtSelectionView nBPPublishImg2txtSelectionView5 = NBPPublishImg2txtSelectionView.this;
                        ar.a(conditionView, new Function1<aq<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishImg2txtSelectionView.body.1.5.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(aq<?, ?> aqVar) {
                                aq<?, ?> aqVar2 = aqVar;
                                final NBPPublishImg2txtSelectionView nBPPublishImg2txtSelectionView6 = NBPPublishImg2txtSelectionView.this;
                                aqVar2.attr(new Function1<ao, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishImg2txtSelectionView.body.1.5.1.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ao aoVar) {
                                        ao aoVar2 = aoVar;
                                        aoVar2.m140flex(1.0f);
                                        aoVar2.flexDirectionColumn();
                                        aoVar2.showScrollerIndicator(false);
                                        aoVar2.size(aoVar2.getPagerData().m(), NBPPublishImg2txtSelectionView.this.listViewHeight);
                                        aoVar2.paddingTop(8.0f);
                                        aoVar2.paddingBottom(26.0f);
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPPublishImg2txtSelectionView nBPPublishImg2txtSelectionView7 = NBPPublishImg2txtSelectionView.this;
                                Function0<c<String>> function02 = new Function0<c<String>>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishImg2txtSelectionView.body.1.5.1.2
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public final c<String> invoke() {
                                        return NBPPublishImg2txtSelectionView.access$getAttr(NBPPublishImg2txtSelectionView.this).getViewModel().getImg2txtContentList();
                                    }
                                };
                                final NBPPublishImg2txtSelectionView nBPPublishImg2txtSelectionView8 = NBPPublishImg2txtSelectionView.this;
                                LoopDirectivesViewKt.a(aqVar2, function02, new Function2<LoopDirectivesView<String>, String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishImg2txtSelectionView.body.1.5.1.3
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public final Unit invoke(LoopDirectivesView<String> loopDirectivesView, String str) {
                                        final String str2 = str;
                                        final NBPPublishImg2txtSelectionView nBPPublishImg2txtSelectionView9 = NBPPublishImg2txtSelectionView.this;
                                        w.a(loopDirectivesView, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishImg2txtSelectionView.body.1.5.1.3.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(v vVar) {
                                                v vVar2 = vVar;
                                                vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishImg2txtSelectionView.body.1.5.1.3.1.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(t tVar) {
                                                        t tVar2 = tVar;
                                                        tVar2.margin(0.0f, 16.0f, 8.0f, 16.0f);
                                                        tVar2.mo113backgroundColor(new h(4294967295L));
                                                        tVar2.mo141height(56.0f);
                                                        tVar2.borderRadius(8.0f);
                                                        tVar2.flexDirectionRow();
                                                        tVar2.alignItemsCenter();
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final String str3 = str2;
                                                cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishImg2txtSelectionView.body.1.5.1.3.1.2
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(TextView textView) {
                                                        final String str4 = str3;
                                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishImg2txtSelectionView.body.1.5.1.3.1.2.1
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ce ceVar) {
                                                                ce ceVar2 = ceVar;
                                                                ceVar2.marginLeft(16.0f);
                                                                ceVar2.marginRight(16.0f);
                                                                ceVar2.text(str4);
                                                                ceVar2.color(new h(4279901214L));
                                                                ce.fontSize$default(ceVar2, 16.0f, null, 2, null);
                                                                ceVar2.fontWeight400();
                                                                ceVar2.lines(1);
                                                                ceVar2.m140flex(1.0f);
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final NBPPublishImg2txtSelectionView nBPPublishImg2txtSelectionView10 = nBPPublishImg2txtSelectionView9;
                                                final String str4 = str2;
                                                vVar2.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishImg2txtSelectionView.body.1.5.1.3.1.3
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(u uVar) {
                                                        final NBPPublishImg2txtSelectionView nBPPublishImg2txtSelectionView11 = NBPPublishImg2txtSelectionView.this;
                                                        final String str5 = str4;
                                                        uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishImg2txtSelectionView.body.1.5.1.3.1.3.1
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(1);
                                                            }

                                                            /* JADX WARN: Multi-variable type inference failed */
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ClickParams clickParams) {
                                                                Function1<? super String, Unit> function1 = ((NBPPublishImg2txtSelectionEvent) NBPPublishImg2txtSelectionView.this.getViewEvent()).eventHandler;
                                                                if (function1 != null) {
                                                                    function1.invoke(str5);
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
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final NBPPublishImg2txtSelectionView nBPPublishImg2txtSelectionView5 = NBPPublishImg2txtSelectionView.this;
                ConditionViewKt.a(viewContainer2, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishImg2txtSelectionView$body$1.6
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ConditionView conditionView) {
                        final NBPPublishImg2txtSelectionView nBPPublishImg2txtSelectionView6 = NBPPublishImg2txtSelectionView.this;
                        w.a(conditionView, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishImg2txtSelectionView.body.1.6.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar) {
                                v vVar2 = vVar;
                                vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishImg2txtSelectionView.body.1.6.1.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.allCenter();
                                        tVar2.m140flex(1.0f);
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPPublishImg2txtSelectionView nBPPublishImg2txtSelectionView7 = NBPPublishImg2txtSelectionView.this;
                                cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishImg2txtSelectionView.body.1.6.1.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(TextView textView) {
                                        final NBPPublishImg2txtSelectionView nBPPublishImg2txtSelectionView8 = NBPPublishImg2txtSelectionView.this;
                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishImg2txtSelectionView.body.1.6.1.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ce ceVar) {
                                                ce ceVar2 = ceVar;
                                                if (NBPPublishImg2txtSelectionView.access$getAttr(NBPPublishImg2txtSelectionView.this).getViewModel().isRequestImg2txt()) {
                                                    ceVar2.text("\u52a0\u8f7d\u4e2d\uff0c\u8bf7\u7a0d\u5019...");
                                                } else {
                                                    ceVar2.text("\u6682\u65e0\u63a8\u8350\u6587\u672c");
                                                }
                                                ceVar2.color(new h(4287664276L));
                                                ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                                ceVar2.fontWeight400();
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
        return new NBPPublishImg2txtSelectionAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new NBPPublishImg2txtSelectionEvent();
    }
}
