package com.tencent.hippykotlin.demo.pages.nearby.publish.view;

import com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishContentView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.event.VisibilityEventKt;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.u;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes31.dex */
public final class NBPPublishContentView$actionSheet$1 extends Lambda implements Function1<ViewContainer<?, ?>, Unit> {
    public final /* synthetic */ List<NBPPublishContentView.ActionSheetItem> $items;
    public final /* synthetic */ Function0<Unit> $onDidAppear;
    public final /* synthetic */ Function1<Boolean, Unit> $onDismiss;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public NBPPublishContentView$actionSheet$1(List<NBPPublishContentView.ActionSheetItem> list, Function1<? super Boolean, Unit> function1, Function0<Unit> function0) {
        super(1);
        this.$items = list;
        this.$onDismiss = function1;
        this.$onDidAppear = function0;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(ViewContainer<?, ?> viewContainer) {
        ViewContainer<?, ?> viewContainer2 = viewContainer;
        viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishContentView$actionSheet$1.1
            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(m mVar) {
                m mVar2 = mVar;
                mVar2.flexDirectionColumn();
                mVar2.borderRadius(8.0f, 8.0f, 0.0f, 0.0f);
                mVar2.mo113backgroundColor(h.INSTANCE.m());
                mVar2.mo153width(mVar2.getPagerData().m());
                return Unit.INSTANCE;
            }
        });
        final Function1<Boolean, Unit> function1 = this.$onDismiss;
        final Function0<Unit> function0 = this.$onDidAppear;
        viewContainer2.event(new Function1<Event, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishContentView$actionSheet$1.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Event event) {
                Event event2 = event;
                final Function1<Boolean, Unit> function12 = function1;
                event2.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishContentView.actionSheet.1.2.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ClickParams clickParams) {
                        Function1<Boolean, Unit> function13 = function12;
                        if (function13 != null) {
                            function13.invoke(Boolean.FALSE);
                        }
                        return Unit.INSTANCE;
                    }
                });
                final Function0<Unit> function02 = function0;
                VisibilityEventKt.b(event2, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishContentView.actionSheet.1.2.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Object obj) {
                        Function0<Unit> function03 = function02;
                        if (function03 != null) {
                            function03.invoke();
                        }
                        return Unit.INSTANCE;
                    }
                });
                return Unit.INSTANCE;
            }
        });
        List<NBPPublishContentView.ActionSheetItem> list = this.$items;
        final Function1<Boolean, Unit> function12 = this.$onDismiss;
        int i3 = 0;
        for (Object obj : list) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            final NBPPublishContentView.ActionSheetItem actionSheetItem = (NBPPublishContentView.ActionSheetItem) obj;
            w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishContentView$actionSheet$1$3$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(v vVar) {
                    v vVar2 = vVar;
                    vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishContentView$actionSheet$1$3$1.1
                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(t tVar) {
                            t tVar2 = tVar;
                            tVar2.mo141height(56.0f);
                            tVar2.allCenter();
                            return Unit.INSTANCE;
                        }
                    });
                    final Function1<Boolean, Unit> function13 = function12;
                    final NBPPublishContentView.ActionSheetItem actionSheetItem2 = actionSheetItem;
                    vVar2.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishContentView$actionSheet$1$3$1.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(u uVar) {
                            final Function1<Boolean, Unit> function14 = function13;
                            final NBPPublishContentView.ActionSheetItem actionSheetItem3 = actionSheetItem2;
                            uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishContentView.actionSheet.1.3.1.2.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(ClickParams clickParams) {
                                    Function1<Boolean, Unit> function15 = function14;
                                    if (function15 != null) {
                                        function15.invoke(Boolean.FALSE);
                                    }
                                    actionSheetItem3.callback.invoke();
                                    return Unit.INSTANCE;
                                }
                            });
                            return Unit.INSTANCE;
                        }
                    });
                    final NBPPublishContentView.ActionSheetItem actionSheetItem3 = actionSheetItem;
                    cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishContentView$actionSheet$1$3$1.3
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(TextView textView) {
                            final NBPPublishContentView.ActionSheetItem actionSheetItem4 = NBPPublishContentView.ActionSheetItem.this;
                            textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishContentView.actionSheet.1.3.1.3.1
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(ce ceVar) {
                                    ce ceVar2 = ceVar;
                                    ceVar2.color(h.INSTANCE.b());
                                    ceVar2.text(NBPPublishContentView.ActionSheetItem.this.title);
                                    ce.fontSize$default(ceVar2, 17.0f, null, 2, null);
                                    return Unit.INSTANCE;
                                }
                            });
                            return Unit.INSTANCE;
                        }
                    });
                    return Unit.INSTANCE;
                }
            });
            if (i3 != list.size() - 1) {
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishContentView$actionSheet$1$3$2
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        vVar.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishContentView$actionSheet$1$3$2.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.mo141height(0.5f);
                                tVar2.mo113backgroundColor(new h(0L, 0.1f));
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
            }
            i3 = i16;
        }
        w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishContentView$actionSheet$1.4
            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(v vVar) {
                vVar.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishContentView.actionSheet.1.4.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(t tVar) {
                        t tVar2 = tVar;
                        tVar2.mo141height(12.0f);
                        tVar2.mo113backgroundColor(new h(16119546L, 1.0f));
                        return Unit.INSTANCE;
                    }
                });
                return Unit.INSTANCE;
            }
        });
        final Function1<Boolean, Unit> function13 = this.$onDismiss;
        w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishContentView$actionSheet$1.5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(v vVar) {
                v vVar2 = vVar;
                vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishContentView.actionSheet.1.5.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(t tVar) {
                        t tVar2 = tVar;
                        tVar2.allCenter();
                        tVar2.mo141height(56.0f);
                        tVar2.marginBottom(21.0f);
                        return Unit.INSTANCE;
                    }
                });
                final Function1<Boolean, Unit> function14 = function13;
                vVar2.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishContentView.actionSheet.1.5.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(u uVar) {
                        final Function1<Boolean, Unit> function15 = function14;
                        uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishContentView.actionSheet.1.5.2.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ClickParams clickParams) {
                                Function1<Boolean, Unit> function16 = function15;
                                if (function16 != null) {
                                    function16.invoke(Boolean.TRUE);
                                }
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishContentView.actionSheet.1.5.3
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(TextView textView) {
                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishContentView.actionSheet.1.5.3.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ce ceVar) {
                                ce ceVar2 = ceVar;
                                ce.fontSize$default(ceVar2, 17.0f, null, 2, null);
                                ceVar2.text("\u53d6\u6d88");
                                ceVar2.fontWeight600();
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
