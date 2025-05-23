package com.tencent.hippykotlin.demo.pages.nearby.base.view;

import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.views.ImageEvent;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ah;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public final class NBPSharePanelView extends ComposeView<NBPSharePanelViewAttr, NBPSharePanelViewEvent> {
    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ NBPSharePanelViewAttr access$getAttr(NBPSharePanelView nBPSharePanelView) {
        return (NBPSharePanelViewAttr) nBPSharePanelView.getAttr();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ NBPSharePanelViewEvent access$getEvent(NBPSharePanelView nBPSharePanelView) {
        return (NBPSharePanelViewEvent) nBPSharePanelView.getEvent();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        final float f16 = getPager().getPageData().getIsIphoneX() ? 34.0f : 0.0f;
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPSharePanelView$body$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                final float f17 = f16;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPSharePanelView$body$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        mVar2.size(mVar2.getPager().getPageData().m(), f17 + 242.0f);
                        mVar2.mo113backgroundColor(QUIToken.color$default("bg_middle_light"));
                        mVar2.borderRadius(8.0f, 8.0f, 0.0f, 0.0f);
                        return Unit.INSTANCE;
                    }
                });
                final NBPSharePanelView nBPSharePanelView = this;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPSharePanelView$body$1.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPSharePanelView.body.1.2.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.size(tVar2.getPager().getPageData().m(), 36.0f);
                                tVar2.flexDirectionRow();
                                tVar2.justifyContentSpaceBetween();
                                tVar2.alignItemsFlexEnd();
                                return Unit.INSTANCE;
                            }
                        });
                        cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPSharePanelView.body.1.2.2
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(TextView textView) {
                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPSharePanelView.body.1.2.2.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ce ceVar) {
                                        ce ceVar2 = ceVar;
                                        ceVar2.text("\u5206\u4eab\u5230");
                                        ceVar2.color(QUIToken.color$default("text_primary"));
                                        ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                        ceVar2.marginLeft(16.0f);
                                        ceVar2.fontWeight500();
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final NBPSharePanelView nBPSharePanelView2 = NBPSharePanelView.this;
                        ah.a(vVar2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPSharePanelView.body.1.2.3
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ImageView imageView) {
                                ImageView imageView2 = imageView;
                                imageView2.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPSharePanelView.body.1.2.3.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(af afVar) {
                                        af afVar2 = afVar;
                                        afVar2.q();
                                        b.a.b(afVar2, QUIToken.INSTANCE.image("close", QUIToken.color$default("icon_primary")), false, 2, null);
                                        afVar2.size(20.0f, 20.0f);
                                        afVar2.marginRight(16.0f);
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPSharePanelView nBPSharePanelView3 = NBPSharePanelView.this;
                                imageView2.event(new Function1<ImageEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPSharePanelView.body.1.2.3.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ImageEvent imageEvent) {
                                        final NBPSharePanelView nBPSharePanelView4 = NBPSharePanelView.this;
                                        imageEvent.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPSharePanelView.body.1.2.3.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ClickParams clickParams) {
                                                Function0<Unit> function0 = NBPSharePanelView.access$getEvent(NBPSharePanelView.this).onCloseClickHandler;
                                                if (function0 != null) {
                                                    function0.invoke();
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
                final NBPSharePanelView nBPSharePanelView2 = this;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPSharePanelView$body$1.3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPSharePanelView.body.1.3.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.size(tVar2.getPager().getPageData().m(), 74.0f);
                                tVar2.flexDirectionRow();
                                tVar2.marginTop(20.0f);
                                tVar2.marginBottom(20.0f);
                                return Unit.INSTANCE;
                            }
                        });
                        for (final ShareItemData shareItemData : NBPSharePanelView.access$getAttr(NBPSharePanelView.this).topItems) {
                            final NBPSharePanelView nBPSharePanelView3 = NBPSharePanelView.this;
                            vVar2.addChild(new NBPSharePanelItemView(), new Function1<NBPSharePanelItemView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPSharePanelView.body.1.3.2
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(NBPSharePanelItemView nBPSharePanelItemView) {
                                    NBPSharePanelItemView nBPSharePanelItemView2 = nBPSharePanelItemView;
                                    final ShareItemData shareItemData2 = ShareItemData.this;
                                    nBPSharePanelItemView2.attr(new Function1<NBPSharePanelItemViewAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPSharePanelView.body.1.3.2.1
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(NBPSharePanelItemViewAttr nBPSharePanelItemViewAttr) {
                                            NBPSharePanelItemViewAttr nBPSharePanelItemViewAttr2 = nBPSharePanelItemViewAttr;
                                            nBPSharePanelItemViewAttr2.data = ShareItemData.this;
                                            nBPSharePanelItemViewAttr2.marginLeft(16.0f);
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    final NBPSharePanelView nBPSharePanelView4 = nBPSharePanelView3;
                                    final ShareItemData shareItemData3 = ShareItemData.this;
                                    nBPSharePanelItemView2.event(new Function1<NBPSharePanelItemViewEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPSharePanelView.body.1.3.2.2
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(NBPSharePanelItemViewEvent nBPSharePanelItemViewEvent) {
                                            final NBPSharePanelView nBPSharePanelView5 = NBPSharePanelView.this;
                                            final ShareItemData shareItemData4 = shareItemData3;
                                            nBPSharePanelItemViewEvent.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPSharePanelView.body.1.3.2.2.1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(ClickParams clickParams) {
                                                    Function1<? super ShareItemData, Unit> function1 = NBPSharePanelView.access$getEvent(NBPSharePanelView.this).onItemClickHandler;
                                                    if (function1 != null) {
                                                        function1.invoke(shareItemData4);
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
                        }
                        return Unit.INSTANCE;
                    }
                });
                final NBPSharePanelView nBPSharePanelView3 = this;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPSharePanelView$body$1.4
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPSharePanelView.body.1.4.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.size(tVar2.getPager().getPageData().m(), 74.0f);
                                tVar2.flexDirectionRow();
                                tVar2.marginBottom(20.0f);
                                return Unit.INSTANCE;
                            }
                        });
                        for (final ShareItemData shareItemData : NBPSharePanelView.access$getAttr(NBPSharePanelView.this).bottomItems) {
                            if (!Intrinsics.areEqual(shareItemData.text, "\u590d\u5236\u94fe\u63a5") || NBPSharePanelView.access$getAttr(NBPSharePanelView.this).showCopyLink) {
                                if (!Intrinsics.areEqual(shareItemData.text, "\u9644\u8fd1\u52a8\u6001") || NBPSharePanelView.access$getAttr(NBPSharePanelView.this).showShareNBPFeed) {
                                    final NBPSharePanelView nBPSharePanelView4 = NBPSharePanelView.this;
                                    vVar2.addChild(new NBPSharePanelItemView(), new Function1<NBPSharePanelItemView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPSharePanelView.body.1.4.2
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(NBPSharePanelItemView nBPSharePanelItemView) {
                                            NBPSharePanelItemView nBPSharePanelItemView2 = nBPSharePanelItemView;
                                            final ShareItemData shareItemData2 = ShareItemData.this;
                                            nBPSharePanelItemView2.attr(new Function1<NBPSharePanelItemViewAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPSharePanelView.body.1.4.2.1
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(NBPSharePanelItemViewAttr nBPSharePanelItemViewAttr) {
                                                    NBPSharePanelItemViewAttr nBPSharePanelItemViewAttr2 = nBPSharePanelItemViewAttr;
                                                    nBPSharePanelItemViewAttr2.data = ShareItemData.this;
                                                    nBPSharePanelItemViewAttr2.marginLeft(16.0f);
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            final NBPSharePanelView nBPSharePanelView5 = nBPSharePanelView4;
                                            final ShareItemData shareItemData3 = ShareItemData.this;
                                            nBPSharePanelItemView2.event(new Function1<NBPSharePanelItemViewEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPSharePanelView.body.1.4.2.2
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(NBPSharePanelItemViewEvent nBPSharePanelItemViewEvent) {
                                                    final NBPSharePanelView nBPSharePanelView6 = NBPSharePanelView.this;
                                                    final ShareItemData shareItemData4 = shareItemData3;
                                                    nBPSharePanelItemViewEvent.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPSharePanelView.body.1.4.2.2.1
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(ClickParams clickParams) {
                                                            Function1<? super ShareItemData, Unit> function1 = NBPSharePanelView.access$getEvent(NBPSharePanelView.this).onItemClickHandler;
                                                            if (function1 != null) {
                                                                function1.invoke(shareItemData4);
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
                                }
                            }
                        }
                        return Unit.INSTANCE;
                    }
                });
                return Unit.INSTANCE;
            }
        };
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return new NBPSharePanelViewAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new NBPSharePanelViewEvent();
    }
}
