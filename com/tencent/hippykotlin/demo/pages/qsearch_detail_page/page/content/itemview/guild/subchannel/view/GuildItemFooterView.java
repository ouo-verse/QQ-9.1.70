package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.view;

import com.tencent.hippykotlin.demo.pages.base.EcommerceExtKt;
import com.tencent.hippykotlin.demo.pages.foundation.extension.FontModuleExtKt;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.util.QSearchUtilKt;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.BorderStyle;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.e;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ah;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.compose.ButtonView;
import com.tencent.kuikly.core.views.compose.a;
import com.tencent.kuikly.core.views.compose.c;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class GuildItemFooterView extends ComposeView<GuildItemFooterAttr, GuildItemFooterEvent> {
    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ GuildItemFooterAttr access$getAttr(GuildItemFooterView guildItemFooterView) {
        return (GuildItemFooterAttr) guildItemFooterView.getAttr();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.view.GuildItemFooterView$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.view.GuildItemFooterView$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        mVar2.mo141height(FontModuleExtKt.qqFontScaleAddSize(12.0f) + 40.0f);
                        mVar2.paddingBottom(3.0f);
                        mVar2.flexDirectionRow();
                        mVar2.paddingLeft(12.0f);
                        mVar2.paddingRight(12.0f);
                        return Unit.INSTANCE;
                    }
                });
                final GuildItemFooterView guildItemFooterView = GuildItemFooterView.this;
                ah.a(viewContainer2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.view.GuildItemFooterView$body$1.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ImageView imageView) {
                        final GuildItemFooterView guildItemFooterView2 = GuildItemFooterView.this;
                        imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.view.GuildItemFooterView.body.1.2.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(af afVar) {
                                af afVar2 = afVar;
                                afVar2.mo153width(18.0f);
                                afVar2.mo141height(18.0f);
                                afVar2.alignSelfCenter();
                                afVar2.borderRadius(4.0f);
                                afVar2.m136border(new e(0.5f, BorderStyle.SOLID, h.INSTANCE.m()));
                                b.a.b(afVar2, GuildItemFooterView.access$getAttr(GuildItemFooterView.this).getData().getChannelIcon(), false, 2, null);
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final GuildItemFooterView guildItemFooterView2 = GuildItemFooterView.this;
                cg.a(viewContainer2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.view.GuildItemFooterView$body$1.3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(TextView textView) {
                        final GuildItemFooterView guildItemFooterView3 = GuildItemFooterView.this;
                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.view.GuildItemFooterView.body.1.3.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ce ceVar) {
                                ce ceVar2 = ceVar;
                                ceVar2.m140flex(1.0f);
                                ceVar2.alignSelfCenter();
                                ceVar2.text(GuildItemFooterView.access$getAttr(GuildItemFooterView.this).getData().getChannelName());
                                ceVar2.lines(1);
                                ceVar2.textOverFlowTail();
                                ceVar2.color(h.INSTANCE.m());
                                ce.fontSize$default(ceVar2, 12.0f, null, 2, null);
                                ceVar2.fontWeight400();
                                ceVar2.marginLeft(5.0f);
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final GuildItemFooterView guildItemFooterView3 = GuildItemFooterView.this;
                c.a(viewContainer2, new Function1<ButtonView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.view.GuildItemFooterView$body$1.4
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ButtonView buttonView) {
                        ButtonView buttonView2 = buttonView;
                        final GuildItemFooterView guildItemFooterView4 = GuildItemFooterView.this;
                        buttonView2.attr(new Function1<a, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.view.GuildItemFooterView.body.1.4.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(a aVar) {
                                a aVar2 = aVar;
                                final GuildItemFooterView guildItemFooterView5 = GuildItemFooterView.this;
                                aVar2.q(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.view.GuildItemFooterView.body.1.4.1.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ce ceVar) {
                                        ce ceVar2 = ceVar;
                                        ceVar2.text(GuildItemFooterView.access$getAttr(GuildItemFooterView.this).buttonText);
                                        ceVar2.fontWeightSemisolid();
                                        ceVar2.color(h.INSTANCE.m());
                                        ce.fontSize$default(ceVar2, 13.0f, null, 2, null);
                                        ceVar2.lines(1);
                                        return Unit.INSTANCE;
                                    }
                                });
                                aVar2.size(GuildItemFooterView.access$getAttr(GuildItemFooterView.this).buttonWidth, 28.0f);
                                aVar2.mo113backgroundColor(GuildItemFooterView.access$getAttr(GuildItemFooterView.this).buttonColor);
                                aVar2.borderRadius(4.0f);
                                aVar2.marginLeft(12.0f);
                                EcommerceExtKt.elementVR(aVar2, "em_search_join_entrance", GuildItemFooterView.access$getAttr(GuildItemFooterView.this).reportParams);
                                return Unit.INSTANCE;
                            }
                        });
                        final GuildItemFooterView guildItemFooterView5 = GuildItemFooterView.this;
                        buttonView2.event(new Function1<com.tencent.kuikly.core.views.compose.b, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.view.GuildItemFooterView.body.1.4.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(com.tencent.kuikly.core.views.compose.b bVar) {
                                final GuildItemFooterView guildItemFooterView6 = GuildItemFooterView.this;
                                bVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.view.GuildItemFooterView.body.1.4.2.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ClickParams clickParams) {
                                        QSearchUtilKt.openGuildSubChannel(GuildItemFooterView.access$getAttr(GuildItemFooterView.this).getData(), GuildItemFooterView.access$getAttr(GuildItemFooterView.this).traceId);
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
        return new GuildItemFooterAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new GuildItemFooterEvent();
    }
}
