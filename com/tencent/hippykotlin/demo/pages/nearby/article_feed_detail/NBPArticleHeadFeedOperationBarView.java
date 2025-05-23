package com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail;

import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.hippykotlin.demo.pages.nearby.base.repo.QuickCommentItem;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.CommentPanelState;
import com.tencent.hippykotlin.demo.pages.nearby.feed_comment.NBPFeedQuickCommentSelectAttr;
import com.tencent.hippykotlin.demo.pages.nearby.feed_comment.NBPFeedQuickCommentSelectEvent;
import com.tencent.hippykotlin.demo.pages.nearby.feed_comment.NBPFeedQuickCommentSelectView;
import com.tencent.hippykotlin.demo.pages.nearby.feed_comment.NBPFeedQuickCommentSelectViewKt;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.u;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;

/* loaded from: classes31.dex */
public final class NBPArticleHeadFeedOperationBarView extends ComposeView<NBPArticleHeadFeedOperationBarViewAttr, NBPArticleHeadFeedOperationBarViewEvent> {
    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ NBPArticleHeadFeedOperationBarViewAttr access$getAttr(NBPArticleHeadFeedOperationBarView nBPArticleHeadFeedOperationBarView) {
        return (NBPArticleHeadFeedOperationBarViewAttr) nBPArticleHeadFeedOperationBarView.getAttr();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ NBPArticleHeadFeedOperationBarViewEvent access$getEvent(NBPArticleHeadFeedOperationBarView nBPArticleHeadFeedOperationBarView) {
        return (NBPArticleHeadFeedOperationBarViewEvent) nBPArticleHeadFeedOperationBarView.getEvent();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        final NBPArticleFeedDetailVM vm5 = ((NBPArticleHeadFeedOperationBarViewAttr) getAttr()).getVm();
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleHeadFeedOperationBarView$body$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleHeadFeedOperationBarView$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        mVar.mo113backgroundColor(QUIToken.color$default("bg_top_light"));
                        return Unit.INSTANCE;
                    }
                });
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleHeadFeedOperationBarView$body$1.2
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleHeadFeedOperationBarView.body.1.2.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.mo141height(0.5f);
                                tVar2.mo113backgroundColor(QUIToken.color$default("border_standard"));
                                return Unit.INSTANCE;
                            }
                        });
                        vVar2.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleHeadFeedOperationBarView.body.1.2.2
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(u uVar) {
                                uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleHeadFeedOperationBarView.body.1.2.2.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final /* bridge */ /* synthetic */ Unit invoke(ClickParams clickParams) {
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final NBPArticleFeedDetailVM nBPArticleFeedDetailVM = NBPArticleFeedDetailVM.this;
                Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleHeadFeedOperationBarView$body$1.3
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        boolean z16 = true;
                        if (!(!NBPArticleFeedDetailVM.this.getAiQuickComments().isEmpty()) && !(!NBPArticleFeedDetailVM.this.getQuickComments().isEmpty())) {
                            z16 = false;
                        }
                        return Boolean.valueOf(z16);
                    }
                };
                final NBPArticleFeedDetailVM nBPArticleFeedDetailVM2 = NBPArticleFeedDetailVM.this;
                final NBPArticleHeadFeedOperationBarView nBPArticleHeadFeedOperationBarView = this;
                ConditionViewKt.c(viewContainer2, function0, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleHeadFeedOperationBarView$body$1.4
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ConditionView conditionView) {
                        final NBPArticleFeedDetailVM nBPArticleFeedDetailVM3 = NBPArticleFeedDetailVM.this;
                        final NBPArticleHeadFeedOperationBarView nBPArticleHeadFeedOperationBarView2 = nBPArticleHeadFeedOperationBarView;
                        NBPFeedQuickCommentSelectViewKt.NBPFeedQuickCommentSelect(conditionView, new Function1<NBPFeedQuickCommentSelectView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleHeadFeedOperationBarView.body.1.4.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(NBPFeedQuickCommentSelectView nBPFeedQuickCommentSelectView) {
                                NBPFeedQuickCommentSelectView nBPFeedQuickCommentSelectView2 = nBPFeedQuickCommentSelectView;
                                final NBPArticleFeedDetailVM nBPArticleFeedDetailVM4 = NBPArticleFeedDetailVM.this;
                                nBPFeedQuickCommentSelectView2.attr(new Function1<NBPFeedQuickCommentSelectAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleHeadFeedOperationBarView.body.1.4.1.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(NBPFeedQuickCommentSelectAttr nBPFeedQuickCommentSelectAttr) {
                                        NBPFeedQuickCommentSelectAttr nBPFeedQuickCommentSelectAttr2 = nBPFeedQuickCommentSelectAttr;
                                        nBPFeedQuickCommentSelectAttr2.mo153width(nBPFeedQuickCommentSelectAttr2.getPagerData().m());
                                        nBPFeedQuickCommentSelectAttr2.setAiQuickComments(NBPArticleFeedDetailVM.this.getAiQuickComments());
                                        nBPFeedQuickCommentSelectAttr2.setQuickComments(NBPArticleFeedDetailVM.this.getQuickComments());
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPArticleHeadFeedOperationBarView nBPArticleHeadFeedOperationBarView3 = nBPArticleHeadFeedOperationBarView2;
                                nBPFeedQuickCommentSelectView2.event(new Function1<NBPFeedQuickCommentSelectEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleHeadFeedOperationBarView.body.1.4.1.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(NBPFeedQuickCommentSelectEvent nBPFeedQuickCommentSelectEvent) {
                                        NBPFeedQuickCommentSelectEvent nBPFeedQuickCommentSelectEvent2 = nBPFeedQuickCommentSelectEvent;
                                        final NBPArticleHeadFeedOperationBarView nBPArticleHeadFeedOperationBarView4 = NBPArticleHeadFeedOperationBarView.this;
                                        nBPFeedQuickCommentSelectEvent2.onSelectHandler = new Function1<QuickCommentItem, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleHeadFeedOperationBarView.body.1.4.1.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(QuickCommentItem quickCommentItem) {
                                                Function1<? super QuickCommentItem, Unit> function1;
                                                QuickCommentItem quickCommentItem2 = quickCommentItem;
                                                if (quickCommentItem2 != null && (function1 = NBPArticleHeadFeedOperationBarView.access$getEvent(NBPArticleHeadFeedOperationBarView.this).onQuickReplySelectHandler) != null) {
                                                    function1.invoke(quickCommentItem2);
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        };
                                        final NBPArticleHeadFeedOperationBarView nBPArticleHeadFeedOperationBarView5 = NBPArticleHeadFeedOperationBarView.this;
                                        nBPFeedQuickCommentSelectEvent2.onExposeHandler = new Function1<QuickCommentItem, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleHeadFeedOperationBarView.body.1.4.1.2.2
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(QuickCommentItem quickCommentItem) {
                                                Function1<? super QuickCommentItem, Unit> function1;
                                                QuickCommentItem quickCommentItem2 = quickCommentItem;
                                                if (quickCommentItem2 != null && (function1 = NBPArticleHeadFeedOperationBarView.access$getEvent(NBPArticleHeadFeedOperationBarView.this).onQuickReplyExposeHandler) != null) {
                                                    function1.invoke(quickCommentItem2);
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        };
                                        final NBPArticleHeadFeedOperationBarView nBPArticleHeadFeedOperationBarView6 = NBPArticleHeadFeedOperationBarView.this;
                                        nBPFeedQuickCommentSelectEvent2.onClickAIHandler = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleHeadFeedOperationBarView.body.1.4.1.2.3
                                            {
                                                super(0);
                                            }

                                            @Override // kotlin.jvm.functions.Function0
                                            public final Unit invoke() {
                                                NBPArticleHeadFeedOperationBarView.access$getAttr(NBPArticleHeadFeedOperationBarView.this).getVm().onHeadFeedBottomBarClick(NBPArticleHeadFeedOperationBarView.access$getAttr(NBPArticleHeadFeedOperationBarView.this).getFeedModel(), CommentPanelState.AI_Quick_Comments);
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
                final NBPArticleHeadFeedOperationBarView nBPArticleHeadFeedOperationBarView2 = this;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleHeadFeedOperationBarView$body$1.5
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleHeadFeedOperationBarView.body.1.5.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.flexDirectionRow();
                                tVar2.paddingTop(8.0f);
                                tVar2.paddingLeft(16.0f);
                                tVar2.paddingRight(16.0f);
                                tVar2.paddingBottom(tVar2.getPagerData().getSafeAreaInsets().getBottom() + 10.0f);
                                tVar2.alignItemsCenter();
                                tVar2.m140flex(1.0f);
                                return Unit.INSTANCE;
                            }
                        });
                        vVar2.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleHeadFeedOperationBarView.body.1.5.2
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(u uVar) {
                                uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleHeadFeedOperationBarView.body.1.5.2.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final /* bridge */ /* synthetic */ Unit invoke(ClickParams clickParams) {
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final NBPArticleHeadFeedOperationBarView nBPArticleHeadFeedOperationBarView3 = NBPArticleHeadFeedOperationBarView.this;
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleHeadFeedOperationBarView.body.1.5.3
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                v vVar4 = vVar3;
                                vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleHeadFeedOperationBarView.body.1.5.3.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.m140flex(1.0f);
                                        tVar2.mo141height(36.0f);
                                        tVar2.mo113backgroundColor(QUIToken.color$default("fill_standard_primary"));
                                        tVar2.borderRadius(8.0f);
                                        tVar2.paddingLeft(16.0f);
                                        tVar2.justifyContentCenter();
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPArticleHeadFeedOperationBarView nBPArticleHeadFeedOperationBarView4 = NBPArticleHeadFeedOperationBarView.this;
                                vVar4.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleHeadFeedOperationBarView.body.1.5.3.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(u uVar) {
                                        final NBPArticleHeadFeedOperationBarView nBPArticleHeadFeedOperationBarView5 = NBPArticleHeadFeedOperationBarView.this;
                                        uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleHeadFeedOperationBarView.body.1.5.3.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ClickParams clickParams) {
                                                NBPArticleFeedDetailVM vm6 = NBPArticleHeadFeedOperationBarView.access$getAttr(NBPArticleHeadFeedOperationBarView.this).getVm();
                                                NBPArticleFeedModel feedModel = NBPArticleHeadFeedOperationBarView.access$getAttr(NBPArticleHeadFeedOperationBarView.this).getFeedModel();
                                                KProperty<Object>[] kPropertyArr = NBPArticleFeedDetailVM.$$delegatedProperties;
                                                vm6.onHeadFeedBottomBarClick(feedModel, CommentPanelState.None);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleHeadFeedOperationBarView.body.1.5.3.3
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(TextView textView) {
                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleHeadFeedOperationBarView.body.1.5.3.3.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ce ceVar) {
                                                ce ceVar2 = ceVar;
                                                ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                                ceVar2.lineHeight(24.0f);
                                                ceVar2.fontWeight400();
                                                ceVar2.color(QUIToken.color$default("text_secondary"));
                                                ceVar2.text("\u671f\u5f85\u4f60\u7684\u7cbe\u5f69\u70b9\u8bc4");
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final NBPArticleHeadFeedOperationBarView nBPArticleHeadFeedOperationBarView4 = NBPArticleHeadFeedOperationBarView.this;
                        vVar2.addChild(new NBPArticleFeedOperationBarView(), new Function1<NBPArticleFeedOperationBarView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleHeadFeedOperationBarView.body.1.5.4
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(NBPArticleFeedOperationBarView nBPArticleFeedOperationBarView) {
                                final NBPArticleHeadFeedOperationBarView nBPArticleHeadFeedOperationBarView5 = NBPArticleHeadFeedOperationBarView.this;
                                nBPArticleFeedOperationBarView.attr(new Function1<NBPArticleFeedOperationBarViewAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleHeadFeedOperationBarView.body.1.5.4.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(NBPArticleFeedOperationBarViewAttr nBPArticleFeedOperationBarViewAttr) {
                                        NBPArticleFeedOperationBarViewAttr nBPArticleFeedOperationBarViewAttr2 = nBPArticleFeedOperationBarViewAttr;
                                        nBPArticleFeedOperationBarViewAttr2.f114204vm = NBPArticleHeadFeedOperationBarView.access$getAttr(NBPArticleHeadFeedOperationBarView.this).getVm();
                                        nBPArticleFeedOperationBarViewAttr2.feedModel = NBPArticleHeadFeedOperationBarView.access$getAttr(NBPArticleHeadFeedOperationBarView.this).getFeedModel();
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
        return new NBPArticleHeadFeedOperationBarViewAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new NBPArticleHeadFeedOperationBarViewEvent();
    }
}
