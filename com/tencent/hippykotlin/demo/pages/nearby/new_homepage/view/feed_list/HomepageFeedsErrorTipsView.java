package com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.feed_list;

import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedItemView$body$1$3$3$3$3$1$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view_model.NBPHomePageBaseViewModel;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ah;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class HomepageFeedsErrorTipsView extends ComposeView<HomepageFeedsErrorTipsAttr, HomepageFeedsErrorTipsEvent> {
    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ HomepageFeedsErrorTipsAttr access$getAttr(HomepageFeedsErrorTipsView homepageFeedsErrorTipsView) {
        return (HomepageFeedsErrorTipsAttr) homepageFeedsErrorTipsView.getAttr();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.feed_list.HomepageFeedsErrorTipsView$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.feed_list.HomepageFeedsErrorTipsView$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        mVar2.m140flex(1.0f);
                        mVar2.allCenter();
                        mVar2.flexDirectionColumn();
                        return Unit.INSTANCE;
                    }
                });
                ah.a(viewContainer2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.feed_list.HomepageFeedsErrorTipsView$body$1.2
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ImageView imageView) {
                        imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.feed_list.HomepageFeedsErrorTipsView.body.1.2.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(af afVar) {
                                af afVar2 = afVar;
                                afVar2.size(86.0f, 86.0f);
                                b.a.b(afVar2, "data:image/png;base64,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", false, 2, null);
                                afVar2.t(QUIToken.color$default("icon_primary"));
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                cg.a(viewContainer2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.feed_list.HomepageFeedsErrorTipsView$body$1.3
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(TextView textView) {
                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.feed_list.HomepageFeedsErrorTipsView.body.1.3.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ce ceVar) {
                                ce ceVar2 = ceVar;
                                ceVar2.marginTop(24.0f);
                                ceVar2.text("\u7f51\u7edc\u5f02\u5e38\uff0c\u70b9\u51fb\u91cd\u8bd5");
                                NBPArticleFeedItemView$body$1$3$3$3$3$1$1$$ExternalSyntheticOutline0.m(ceVar2, 13.0f, null, 2, null, "text_primary");
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final HomepageFeedsErrorTipsView homepageFeedsErrorTipsView = HomepageFeedsErrorTipsView.this;
                viewContainer2.event(new Function1<Event, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.feed_list.HomepageFeedsErrorTipsView$body$1.4
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Event event) {
                        final HomepageFeedsErrorTipsView homepageFeedsErrorTipsView2 = HomepageFeedsErrorTipsView.this;
                        event.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.feed_list.HomepageFeedsErrorTipsView.body.1.4.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ClickParams clickParams) {
                                NBPHomePageBaseViewModel nBPHomePageBaseViewModel = HomepageFeedsErrorTipsView.access$getAttr(HomepageFeedsErrorTipsView.this).viewModel;
                                if (nBPHomePageBaseViewModel != null) {
                                    nBPHomePageBaseViewModel.fetchFeedList(false);
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

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return new HomepageFeedsErrorTipsAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new HomepageFeedsErrorTipsEvent();
    }
}
