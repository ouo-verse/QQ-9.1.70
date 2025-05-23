package com.tencent.hippykotlin.demo.pages.nearby.feed_comment;

import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.hippykotlin.demo.pages.nearby.base.repo.QuickCommentItem;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.TextViewExtKt;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPCommentUtils;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.event.VisibilityEventKt;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.ScrollerAttr;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ah;
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
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* loaded from: classes31.dex */
public final class NBPFeedQuickCommentSelectView extends ComposeView<NBPFeedQuickCommentSelectAttr, NBPFeedQuickCommentSelectEvent> {
    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ NBPFeedQuickCommentSelectAttr access$getAttr(NBPFeedQuickCommentSelectView nBPFeedQuickCommentSelectView) {
        return (NBPFeedQuickCommentSelectAttr) nBPFeedQuickCommentSelectView.getAttr();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ NBPFeedQuickCommentSelectEvent access$getEvent(NBPFeedQuickCommentSelectView nBPFeedQuickCommentSelectView) {
        return (NBPFeedQuickCommentSelectEvent) nBPFeedQuickCommentSelectView.getEvent();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final boolean access$isAICommentButtonEnabled(NBPFeedQuickCommentSelectView nBPFeedQuickCommentSelectView) {
        nBPFeedQuickCommentSelectView.getClass();
        e eVar = (e) NBPCommentUtils.config$delegate.getValue();
        if (!(eVar != null && eVar.j("enabledAICommentButton") == 1)) {
            return false;
        }
        NBPFeedQuickCommentSelectAttr nBPFeedQuickCommentSelectAttr = (NBPFeedQuickCommentSelectAttr) nBPFeedQuickCommentSelectView.getAttr();
        return ((List) nBPFeedQuickCommentSelectAttr.aiQuickComments$delegate.getValue(nBPFeedQuickCommentSelectAttr, NBPFeedQuickCommentSelectAttr.$$delegatedProperties[1])).isEmpty() ^ true;
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_comment.NBPFeedQuickCommentSelectView$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                final NBPFeedQuickCommentSelectView nBPFeedQuickCommentSelectView = NBPFeedQuickCommentSelectView.this;
                Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_comment.NBPFeedQuickCommentSelectView$body$1.1
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        boolean z16 = true;
                        if (!NBPFeedQuickCommentSelectView.access$isAICommentButtonEnabled(NBPFeedQuickCommentSelectView.this) && !(!NBPFeedQuickCommentSelectView.access$getAttr(NBPFeedQuickCommentSelectView.this).getQuickComments().isEmpty())) {
                            z16 = false;
                        }
                        return Boolean.valueOf(z16);
                    }
                };
                final NBPFeedQuickCommentSelectView nBPFeedQuickCommentSelectView2 = NBPFeedQuickCommentSelectView.this;
                ConditionViewKt.c(viewContainer, function0, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_comment.NBPFeedQuickCommentSelectView$body$1.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ConditionView conditionView) {
                        final NBPFeedQuickCommentSelectView nBPFeedQuickCommentSelectView3 = NBPFeedQuickCommentSelectView.this;
                        w.a(conditionView, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_comment.NBPFeedQuickCommentSelectView.body.1.2.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar) {
                                v vVar2 = vVar;
                                vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_comment.NBPFeedQuickCommentSelectView.body.1.2.1.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.flexDirectionRow();
                                        tVar2.padding(8.0f, 16.0f, 0.0f, 16.0f);
                                        tVar2.mo153width(tVar2.getPagerData().m());
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPFeedQuickCommentSelectView nBPFeedQuickCommentSelectView4 = NBPFeedQuickCommentSelectView.this;
                                Function0<Object> function02 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_comment.NBPFeedQuickCommentSelectView.body.1.2.1.2
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return Boolean.valueOf(NBPFeedQuickCommentSelectView.access$isAICommentButtonEnabled(NBPFeedQuickCommentSelectView.this));
                                    }
                                };
                                final NBPFeedQuickCommentSelectView nBPFeedQuickCommentSelectView5 = NBPFeedQuickCommentSelectView.this;
                                ConditionViewKt.c(vVar2, function02, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_comment.NBPFeedQuickCommentSelectView.body.1.2.1.3
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ConditionView conditionView2) {
                                        final NBPFeedQuickCommentSelectView nBPFeedQuickCommentSelectView6 = NBPFeedQuickCommentSelectView.this;
                                        w.a(conditionView2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_comment.NBPFeedQuickCommentSelectView.body.1.2.1.3.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(v vVar3) {
                                                v vVar4 = vVar3;
                                                final NBPFeedQuickCommentSelectView nBPFeedQuickCommentSelectView7 = NBPFeedQuickCommentSelectView.this;
                                                vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_comment.NBPFeedQuickCommentSelectView.body.1.2.1.3.1.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(t tVar) {
                                                        t tVar2 = tVar;
                                                        tVar2.marginRight(8.0f);
                                                        NBPFeedQuickCommentSelectAttr access$getAttr = NBPFeedQuickCommentSelectView.access$getAttr(NBPFeedQuickCommentSelectView.this);
                                                        if (((Boolean) access$getAttr.isAIQuickCommentMode$delegate.getValue(access$getAttr, NBPFeedQuickCommentSelectAttr.$$delegatedProperties[2])).booleanValue()) {
                                                            tVar2.mo113backgroundColor(QUIToken.color$default("overlay_light"));
                                                        } else {
                                                            tVar2.mo113backgroundColor(QUIToken.color$default("fill_standard_primary"));
                                                        }
                                                        tVar2.borderRadius(6.0f);
                                                        tVar2.allCenter();
                                                        tVar2.mo141height(24.0f);
                                                        tVar2.paddingLeft(12.0f);
                                                        tVar2.paddingRight(12.0f);
                                                        tVar2.flexDirectionRow();
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final NBPFeedQuickCommentSelectView nBPFeedQuickCommentSelectView8 = NBPFeedQuickCommentSelectView.this;
                                                vVar4.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_comment.NBPFeedQuickCommentSelectView.body.1.2.1.3.1.2
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(u uVar) {
                                                        final NBPFeedQuickCommentSelectView nBPFeedQuickCommentSelectView9 = NBPFeedQuickCommentSelectView.this;
                                                        uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_comment.NBPFeedQuickCommentSelectView.body.1.2.1.3.1.2.1
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ClickParams clickParams) {
                                                                Function0<Unit> function03 = NBPFeedQuickCommentSelectView.access$getEvent(NBPFeedQuickCommentSelectView.this).onClickAIHandler;
                                                                if (function03 != null) {
                                                                    function03.invoke();
                                                                }
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                ah.a(vVar4, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_comment.NBPFeedQuickCommentSelectView.body.1.2.1.3.1.3
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ImageView imageView) {
                                                        imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_comment.NBPFeedQuickCommentSelectView.body.1.2.1.3.1.3.1
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(af afVar) {
                                                                af afVar2 = afVar;
                                                                b.a.b(afVar2, "data:image/png;base64,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", false, 2, null);
                                                                afVar2.size(16.0f, 16.0f);
                                                                afVar2.marginRight(4.0f);
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_comment.NBPFeedQuickCommentSelectView.body.1.2.1.3.1.4
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(TextView textView) {
                                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_comment.NBPFeedQuickCommentSelectView.body.1.2.1.3.1.4.1
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ce ceVar) {
                                                                ce ceVar2 = ceVar;
                                                                ceVar2.text("AI\u5e2e\u8bc4");
                                                                ceVar2.lineHeight(16.8f);
                                                                ceVar2.color(QUIToken.color$default("text_primary"));
                                                                ce.fontSize$default(ceVar2, 12.0f, null, 2, null);
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
                                final NBPFeedQuickCommentSelectView nBPFeedQuickCommentSelectView6 = NBPFeedQuickCommentSelectView.this;
                                Function0<Object> function03 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_comment.NBPFeedQuickCommentSelectView.body.1.2.1.4
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return Boolean.valueOf(!NBPFeedQuickCommentSelectView.access$getAttr(NBPFeedQuickCommentSelectView.this).getQuickComments().isEmpty());
                                    }
                                };
                                final NBPFeedQuickCommentSelectView nBPFeedQuickCommentSelectView7 = NBPFeedQuickCommentSelectView.this;
                                ConditionViewKt.c(vVar2, function03, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_comment.NBPFeedQuickCommentSelectView.body.1.2.1.5
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ConditionView conditionView2) {
                                        final NBPFeedQuickCommentSelectView nBPFeedQuickCommentSelectView8 = NBPFeedQuickCommentSelectView.this;
                                        ar.a(conditionView2, new Function1<aq<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_comment.NBPFeedQuickCommentSelectView.body.1.2.1.5.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(aq<?, ?> aqVar) {
                                                aq<?, ?> aqVar2 = aqVar;
                                                aqVar2.attr(new Function1<ao, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_comment.NBPFeedQuickCommentSelectView.body.1.2.1.5.1.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ao aoVar) {
                                                        ao aoVar2 = aoVar;
                                                        aoVar2.scrollEnable(true);
                                                        ScrollerAttr.bouncesEnable$default(aoVar2, true, false, 2, null);
                                                        aoVar2.showScrollerIndicator(false);
                                                        aoVar2.flexDirectionRow();
                                                        aoVar2.mo141height(24.0f);
                                                        aoVar2.m140flex(1.0f);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                List<QuickCommentItem> quickComments = NBPFeedQuickCommentSelectView.access$getAttr(NBPFeedQuickCommentSelectView.this).getQuickComments();
                                                final NBPFeedQuickCommentSelectView nBPFeedQuickCommentSelectView9 = NBPFeedQuickCommentSelectView.this;
                                                for (final QuickCommentItem quickCommentItem : quickComments) {
                                                    w.a(aqVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_comment.NBPFeedQuickCommentSelectView$body$1$2$1$5$1$2$1
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(v vVar3) {
                                                            v vVar4 = vVar3;
                                                            vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_comment.NBPFeedQuickCommentSelectView$body$1$2$1$5$1$2$1.1
                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(t tVar) {
                                                                    t tVar2 = tVar;
                                                                    tVar2.marginRight(8.0f);
                                                                    tVar2.mo113backgroundColor(QUIToken.color$default("fill_standard_primary"));
                                                                    tVar2.borderRadius(6.0f);
                                                                    tVar2.allCenter();
                                                                    tVar2.mo141height(24.0f);
                                                                    tVar2.paddingLeft(12.0f);
                                                                    tVar2.paddingRight(12.0f);
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                            final NBPFeedQuickCommentSelectView nBPFeedQuickCommentSelectView10 = NBPFeedQuickCommentSelectView.this;
                                                            final QuickCommentItem quickCommentItem2 = quickCommentItem;
                                                            vVar4.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_comment.NBPFeedQuickCommentSelectView$body$1$2$1$5$1$2$1.2
                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(u uVar) {
                                                                    u uVar2 = uVar;
                                                                    final NBPFeedQuickCommentSelectView nBPFeedQuickCommentSelectView11 = NBPFeedQuickCommentSelectView.this;
                                                                    final QuickCommentItem quickCommentItem3 = quickCommentItem2;
                                                                    uVar2.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_comment.NBPFeedQuickCommentSelectView.body.1.2.1.5.1.2.1.2.1
                                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                        {
                                                                            super(1);
                                                                        }

                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        public final Unit invoke(ClickParams clickParams) {
                                                                            Function1<? super QuickCommentItem, Unit> function1 = NBPFeedQuickCommentSelectView.access$getEvent(NBPFeedQuickCommentSelectView.this).onSelectHandler;
                                                                            if (function1 != null) {
                                                                                function1.invoke(quickCommentItem3);
                                                                            }
                                                                            return Unit.INSTANCE;
                                                                        }
                                                                    });
                                                                    final NBPFeedQuickCommentSelectView nBPFeedQuickCommentSelectView12 = NBPFeedQuickCommentSelectView.this;
                                                                    final QuickCommentItem quickCommentItem4 = quickCommentItem2;
                                                                    VisibilityEventKt.b(uVar2, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_comment.NBPFeedQuickCommentSelectView.body.1.2.1.5.1.2.1.2.2
                                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                        {
                                                                            super(1);
                                                                        }

                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        public final Unit invoke(Object obj) {
                                                                            Function1<? super QuickCommentItem, Unit> function1 = NBPFeedQuickCommentSelectView.access$getEvent(NBPFeedQuickCommentSelectView.this).onExposeHandler;
                                                                            if (function1 != null) {
                                                                                function1.invoke(quickCommentItem4);
                                                                            }
                                                                            return Unit.INSTANCE;
                                                                        }
                                                                    });
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                            final QuickCommentItem quickCommentItem3 = quickCommentItem;
                                                            cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_comment.NBPFeedQuickCommentSelectView$body$1$2$1$5$1$2$1.3
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(TextView textView) {
                                                                    final QuickCommentItem quickCommentItem4 = QuickCommentItem.this;
                                                                    textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_comment.NBPFeedQuickCommentSelectView.body.1.2.1.5.1.2.1.3.1
                                                                        {
                                                                            super(1);
                                                                        }

                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        public final Unit invoke(ce ceVar) {
                                                                            ce ceVar2 = ceVar;
                                                                            ceVar2.textPostProcessor("emoji");
                                                                            ceVar2.lineHeight(16.8f);
                                                                            ceVar2.color(QUIToken.color$default("text_primary"));
                                                                            ce.fontSize$default(ceVar2, 12.0f, null, 2, null);
                                                                            ceVar2.fontWeight400();
                                                                            TextViewExtKt.textWithLineHeightFix(ceVar2, QuickCommentItem.this.text);
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
        return new NBPFeedQuickCommentSelectAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new NBPFeedQuickCommentSelectEvent();
    }
}
