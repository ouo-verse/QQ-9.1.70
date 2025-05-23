package com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail;

import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.l;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* loaded from: classes31.dex */
public final class NBPArticleFeedDetailFooterView extends ComposeView<NBPArticleFeedDetailFooterViewAttr, l> {
    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ NBPArticleFeedDetailFooterViewAttr access$getAttr(NBPArticleFeedDetailFooterView nBPArticleFeedDetailFooterView) {
        return (NBPArticleFeedDetailFooterViewAttr) nBPArticleFeedDetailFooterView.getAttr();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedDetailFooterView$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedDetailFooterView$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        mVar2.allCenter();
                        mVar2.flexDirectionRow();
                        mVar2.paddingTop(12.0f);
                        mVar2.paddingBottom(12.0f);
                        mVar2.mo113backgroundColor(QUIToken.color$default("bg_bottom_standard"));
                        return Unit.INSTANCE;
                    }
                });
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedDetailFooterView$body$1.2
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        vVar.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedDetailFooterView.body.1.2.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.mo153width(40.0f);
                                tVar2.mo141height(0.5f);
                                tVar2.mo113backgroundColor(QUIToken.color$default("border_standard"));
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final NBPArticleFeedDetailFooterView nBPArticleFeedDetailFooterView = NBPArticleFeedDetailFooterView.this;
                cg.a(viewContainer2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedDetailFooterView$body$1.3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(TextView textView) {
                        final NBPArticleFeedDetailFooterView nBPArticleFeedDetailFooterView2 = NBPArticleFeedDetailFooterView.this;
                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedDetailFooterView.body.1.3.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ce ceVar) {
                                ce ceVar2 = ceVar;
                                ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                ceVar2.fontWeight400();
                                NBPArticleFeedDetailFooterViewAttr access$getAttr = NBPArticleFeedDetailFooterView.access$getAttr(NBPArticleFeedDetailFooterView.this);
                                ceVar2.text((String) access$getAttr.text$delegate.getValue(access$getAttr, NBPArticleFeedDetailFooterViewAttr.$$delegatedProperties[0]));
                                ceVar2.color(QUIToken.color$default("text_secondary"));
                                ceVar2.marginLeft(10.0f);
                                ceVar2.marginRight(10.0f);
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedDetailFooterView$body$1.4
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        vVar.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedDetailFooterView.body.1.4.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.mo153width(40.0f);
                                tVar2.mo141height(0.5f);
                                tVar2.mo113backgroundColor(QUIToken.color$default("border_standard"));
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
        return new NBPArticleFeedDetailFooterViewAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new l();
    }
}
