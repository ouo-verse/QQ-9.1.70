package com.tencent.hippykotlin.demo.pages.nearby.feed_comment;

import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.hippykotlin.demo.pages.nearby.base.repo.QuickCommentItem;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.Direction;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.j;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.ao;
import com.tencent.kuikly.core.views.aq;
import com.tencent.kuikly.core.views.ar;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.u;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* loaded from: classes31.dex */
public final class NBPFeedAIQuickCommentSelectView extends ComposeView<NBPFeedAIQuickCommentSelectAttr, NBPFeedAIQuickCommentSelectEvent> {
    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ NBPFeedAIQuickCommentSelectAttr access$getAttr(NBPFeedAIQuickCommentSelectView nBPFeedAIQuickCommentSelectView) {
        return (NBPFeedAIQuickCommentSelectAttr) nBPFeedAIQuickCommentSelectView.getAttr();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_comment.NBPFeedAIQuickCommentSelectView$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                final NBPFeedAIQuickCommentSelectView nBPFeedAIQuickCommentSelectView = NBPFeedAIQuickCommentSelectView.this;
                ar.a(viewContainer, new Function1<aq<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_comment.NBPFeedAIQuickCommentSelectView$body$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(aq<?, ?> aqVar) {
                        aq<?, ?> aqVar2 = aqVar;
                        final NBPFeedAIQuickCommentSelectView nBPFeedAIQuickCommentSelectView2 = NBPFeedAIQuickCommentSelectView.this;
                        aqVar2.attr(new Function1<ao, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_comment.NBPFeedAIQuickCommentSelectView.body.1.1.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ao aoVar) {
                                ao aoVar2 = aoVar;
                                aoVar2.flexDirectionColumn();
                                aoVar2.showScrollerIndicator(false);
                                aoVar2.paddingTop(10.0f);
                                aoVar2.paddingBottom(26.0f);
                                float m3 = aoVar2.getPagerData().m();
                                NBPFeedAIQuickCommentSelectAttr access$getAttr = NBPFeedAIQuickCommentSelectView.access$getAttr(NBPFeedAIQuickCommentSelectView.this);
                                aoVar2.size(m3, ((Number) access$getAttr.viewHeight$delegate.getValue(access$getAttr, NBPFeedAIQuickCommentSelectAttr.$$delegatedProperties[0])).floatValue());
                                if (QUIToken.INSTANCE.isNightMode()) {
                                    aoVar2.mo135backgroundLinearGradient(Direction.TO_BOTTOM_RIGHT, new j(new h(3028281L, 1.0f), 0.0f), new j(new h(2762801L, 1.0f), 0.5f), new j(new h(3552043L, 1.0f), 1.0f));
                                } else {
                                    aoVar2.mo135backgroundLinearGradient(Direction.TO_BOTTOM_RIGHT, new j(new h(15727103L, 1.0f), 0.0f), new j(new h(14802175L, 1.0f), 0.5f), new j(new h(16776177L, 1.0f), 1.0f));
                                }
                                return Unit.INSTANCE;
                            }
                        });
                        List<QuickCommentItem> list = NBPFeedAIQuickCommentSelectView.access$getAttr(NBPFeedAIQuickCommentSelectView.this).aiQuickComments;
                        final NBPFeedAIQuickCommentSelectView nBPFeedAIQuickCommentSelectView3 = NBPFeedAIQuickCommentSelectView.this;
                        for (final QuickCommentItem quickCommentItem : list) {
                            w.a(aqVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_comment.NBPFeedAIQuickCommentSelectView$body$1$1$2$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(v vVar) {
                                    v vVar2 = vVar;
                                    vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_comment.NBPFeedAIQuickCommentSelectView$body$1$1$2$1.1
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(t tVar) {
                                            t tVar2 = tVar;
                                            tVar2.margin(0.0f, 16.0f, 10.0f, 16.0f);
                                            tVar2.mo113backgroundColor(QUIToken.color$default("fill_light_secondary"));
                                            tVar2.mo141height(40.0f);
                                            tVar2.borderRadius(8.0f);
                                            tVar2.flexDirectionRow();
                                            tVar2.alignItemsCenter();
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    if (c.f117352a.g().getPageData().u()) {
                                        if (QuickCommentItem.this.trace.length() > 0) {
                                            final QuickCommentItem quickCommentItem2 = QuickCommentItem.this;
                                            cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_comment.NBPFeedAIQuickCommentSelectView$body$1$1$2$1.2
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(TextView textView) {
                                                    final QuickCommentItem quickCommentItem3 = QuickCommentItem.this;
                                                    textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_comment.NBPFeedAIQuickCommentSelectView.body.1.1.2.1.2.1
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(ce ceVar) {
                                                            ce ceVar2 = ceVar;
                                                            ceVar2.marginLeft(16.0f);
                                                            ceVar2.text(QuickCommentItem.this.trace + ':');
                                                            ceVar2.color(QUIToken.color$default("text_primary"));
                                                            ce.fontSize$default(ceVar2, 16.0f, null, 2, null);
                                                            ceVar2.fontWeight600();
                                                            ceVar2.fontFamily("PingFang SC");
                                                            ceVar2.mo153width(70.0f);
                                                            ceVar2.lines(1);
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                        }
                                    }
                                    final QuickCommentItem quickCommentItem3 = QuickCommentItem.this;
                                    cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_comment.NBPFeedAIQuickCommentSelectView$body$1$1$2$1.3
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(TextView textView) {
                                            final QuickCommentItem quickCommentItem4 = QuickCommentItem.this;
                                            textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_comment.NBPFeedAIQuickCommentSelectView.body.1.1.2.1.3.1
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(ce ceVar) {
                                                    ce ceVar2 = ceVar;
                                                    ceVar2.textPostProcessor("emoji");
                                                    ceVar2.marginLeft(16.0f);
                                                    ceVar2.marginRight(16.0f);
                                                    ceVar2.text(QuickCommentItem.this.text);
                                                    ceVar2.color(QUIToken.color$default("text_primary"));
                                                    ce.fontSize$default(ceVar2, 16.0f, null, 2, null);
                                                    ceVar2.fontWeight400();
                                                    ceVar2.fontFamily("PingFang SC");
                                                    ceVar2.lines(1);
                                                    ceVar2.m140flex(1.0f);
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    final NBPFeedAIQuickCommentSelectView nBPFeedAIQuickCommentSelectView4 = nBPFeedAIQuickCommentSelectView3;
                                    final QuickCommentItem quickCommentItem4 = QuickCommentItem.this;
                                    vVar2.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_comment.NBPFeedAIQuickCommentSelectView$body$1$1$2$1.4
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(u uVar) {
                                            final NBPFeedAIQuickCommentSelectView nBPFeedAIQuickCommentSelectView5 = NBPFeedAIQuickCommentSelectView.this;
                                            final QuickCommentItem quickCommentItem5 = quickCommentItem4;
                                            uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_comment.NBPFeedAIQuickCommentSelectView.body.1.1.2.1.4.1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                /* JADX WARN: Multi-variable type inference failed */
                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(ClickParams clickParams) {
                                                    Function1<? super QuickCommentItem, Unit> function1 = ((NBPFeedAIQuickCommentSelectEvent) NBPFeedAIQuickCommentSelectView.this.getViewEvent()).eventHandler;
                                                    if (function1 != null) {
                                                        function1.invoke(quickCommentItem5);
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
                return Unit.INSTANCE;
            }
        };
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return new NBPFeedAIQuickCommentSelectAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new NBPFeedAIQuickCommentSelectEvent();
    }
}
