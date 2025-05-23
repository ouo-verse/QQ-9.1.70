package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.view;

import com.tencent.hippykotlin.demo.pages.base.QUISkinColor;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class GuildGroupTitleView extends ComposeView<GuildGroupTitleAttr, GuildGroupTitleEvent> {
    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ GuildGroupTitleAttr access$getAttr(GuildGroupTitleView guildGroupTitleView) {
        return (GuildGroupTitleAttr) guildGroupTitleView.getAttr();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.view.GuildGroupTitleView$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                if (GuildGroupTitleView.access$getAttr(GuildGroupTitleView.this).title.length() > 0) {
                    final GuildGroupTitleView guildGroupTitleView = GuildGroupTitleView.this;
                    cg.a(viewContainer2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.view.GuildGroupTitleView$body$1.1
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(TextView textView) {
                            final GuildGroupTitleView guildGroupTitleView2 = GuildGroupTitleView.this;
                            textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.view.GuildGroupTitleView.body.1.1.1
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(ce ceVar) {
                                    ce ceVar2 = ceVar;
                                    ceVar2.marginBottom(4.0f);
                                    ceVar2.text(GuildGroupTitleView.access$getAttr(GuildGroupTitleView.this).title);
                                    ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                    ceVar2.fontWeight500();
                                    ceVar2.color(QUISkinColor.INSTANCE.wrapColor("text_primary"));
                                    return Unit.INSTANCE;
                                }
                            });
                            return Unit.INSTANCE;
                        }
                    });
                }
                return Unit.INSTANCE;
            }
        };
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return new GuildGroupTitleAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new GuildGroupTitleEvent();
    }
}
