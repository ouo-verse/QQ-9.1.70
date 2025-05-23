package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel;

import com.tencent.hippykotlin.demo.pages.foundation.extension.FontModuleExtKt;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.guild.GuildCommonItemModel;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.view.GuildItemFooterAttr;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.view.GuildItemHeaderAttr;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.view.GuildItemMiddleAvatarAttr;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.view.GuildMusicMarqueeAttr;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.view.GuildMusicMarqueeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.g;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ah;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class GuildMusicItemView extends GuildBaseImageItemView {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.GuildBaseImageItemView
    public final void configFooter(GuildItemFooterAttr guildItemFooterAttr) {
        int i3 = ((GuildBaseImageAttr) getAttr()).index;
        guildItemFooterAttr.getClass();
        guildItemFooterAttr.buttonText = "\u4e00\u8d77\u542c";
        guildItemFooterAttr.buttonColor = new h(1291845631L);
        guildItemFooterAttr.buttonWidth = 55.0f;
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.GuildMusicItemView$configHeader$1$1, kotlin.jvm.internal.Lambda] */
    @Override // com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.GuildBaseImageItemView
    public final void configHeader(GuildItemHeaderAttr guildItemHeaderAttr, final GuildCommonItemModel guildCommonItemModel) {
        guildItemHeaderAttr.text = "\u542c\u6b4c\u4e2d";
        guildItemHeaderAttr.iconColor = new h(4278976438L);
        guildItemHeaderAttr.iconBgColor = new h(2986688051L);
        guildItemHeaderAttr.setIconSrcIOS("ec_search_guild_music.pag");
        guildItemHeaderAttr.setIconSrcAnd("ecommerce_search_guild_music");
        guildItemHeaderAttr.rightPartViewBuilder = new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.GuildMusicItemView$configHeader$1$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                final GuildCommonItemModel guildCommonItemModel2 = GuildCommonItemModel.this;
                w.a(viewContainer, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.GuildMusicItemView$configHeader$1$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.GuildMusicItemView.configHeader.1.1.1.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.m140flex(1.0f);
                                tVar2.mo141height(FontModuleExtKt.qqFontScaleAddSize(12.0f) + 18.0f);
                                tVar2.flexDirectionRow();
                                tVar2.alignItemsCenter();
                                tVar2.justifyContentFlexEnd();
                                return Unit.INSTANCE;
                            }
                        });
                        final GuildCommonItemModel guildCommonItemModel3 = GuildCommonItemModel.this;
                        vVar2.addChild(new GuildMusicMarqueeView(), new Function1<GuildMusicMarqueeView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.GuildMusicItemView.configHeader.1.1.1.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(GuildMusicMarqueeView guildMusicMarqueeView) {
                                final GuildCommonItemModel guildCommonItemModel4 = GuildCommonItemModel.this;
                                guildMusicMarqueeView.attr(new Function1<GuildMusicMarqueeAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.GuildMusicItemView.configHeader.1.1.1.2.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(GuildMusicMarqueeAttr guildMusicMarqueeAttr) {
                                        final List listOf;
                                        GuildMusicMarqueeAttr guildMusicMarqueeAttr2 = guildMusicMarqueeAttr;
                                        guildMusicMarqueeAttr2.m140flex(1.0f);
                                        guildMusicMarqueeAttr2.mo141height(18.0f);
                                        guildMusicMarqueeAttr2.marginLeft(8.0f);
                                        guildMusicMarqueeAttr2.marqueePerSecondTranslation = 40.0f;
                                        listOf = CollectionsKt__CollectionsJVMKt.listOf(GuildCommonItemModel.this.getTitle());
                                        final C48581 c48581 = new Function2<ViewContainer<?, ?>, String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.GuildMusicItemView.configHeader.1.1.1.2.1.1
                                            @Override // kotlin.jvm.functions.Function2
                                            public final Unit invoke(ViewContainer<?, ?> viewContainer2, String str) {
                                                final String str2 = str;
                                                cg.a(viewContainer2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.GuildMusicItemView.configHeader.1.1.1.2.1.1.1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(TextView textView) {
                                                        final String str3 = str2;
                                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.GuildMusicItemView.configHeader.1.1.1.2.1.1.1.1
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ce ceVar) {
                                                                ce ceVar2 = ceVar;
                                                                ceVar2.text(str3);
                                                                ceVar2.color(h.INSTANCE.m());
                                                                ce.fontSize$default(ceVar2, 12.0f, null, 2, null);
                                                                ceVar2.lineHeight(18.0f);
                                                                ceVar2.lines(1);
                                                                ceVar2.m147opacity(0.75f);
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        };
                                        guildMusicMarqueeAttr2.marqueeItemListCount = new Function0<Integer>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.view.GuildMusicMarqueeAttr$initMarqueeItems$1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(0);
                                            }

                                            @Override // kotlin.jvm.functions.Function0
                                            public final Integer invoke() {
                                                return Integer.valueOf(listOf.size());
                                            }
                                        };
                                        guildMusicMarqueeAttr2.marqueeItemViewCreator = new Function2<ViewContainer<?, ?>, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.view.GuildMusicMarqueeAttr$initMarqueeItems$2
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            /* JADX WARN: Multi-variable type inference failed */
                                            {
                                                super(2);
                                            }

                                            @Override // kotlin.jvm.functions.Function2
                                            public final Unit invoke(ViewContainer<?, ?> viewContainer2, Integer num) {
                                                int intValue = num.intValue();
                                                c48581.invoke(viewContainer2, listOf.get(intValue));
                                                return Unit.INSTANCE;
                                            }
                                        };
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final h hVar = new h(3238002687L);
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.GuildMusicItemView.configHeader.1.1.1.3
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                final h hVar2 = h.this;
                                vVar3.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.GuildMusicItemView.configHeader.1.1.1.3.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.mo153width(1.0f);
                                        tVar2.mo141height(12.0f);
                                        tVar2.marginLeft(4.0f).marginRight(6.0f);
                                        tVar2.mo113backgroundColor(h.this);
                                        tVar2.mo139boxShadow(new g(3.0f, 3.0f, 3.0f, new h(1275068416L)));
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        ah.a(vVar2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.GuildMusicItemView.configHeader.1.1.1.4
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ImageView imageView) {
                                imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.GuildMusicItemView.configHeader.1.1.1.4.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(af afVar) {
                                        af afVar2 = afVar;
                                        afVar2.mo153width(12.0f).mo141height(12.0f);
                                        b.a.b(afVar2, "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAACQAAAAkCAYAAADhAJiYAAAACXBIWXMAACE4AAAhOAFFljFgAAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAAGUSURBVHgB7Zg9bsJAEIXfWunCAThADkAfeuid3jSpoEnFGahScYD0OUDS5wDkFjlAemcmWpBtFvvNrm0JiU9arZDHq4/ZvwHgxpXhkEhZlhPpJv+DOfeDRKKEvEQubSlt2nh8kPYpch+IwCwkMgvpNvBZaUGz9WLNmklIZArpVoZXzFIZGygyc6OMotP56qe4XyFhjThU6okNpoTkG4YWr4WczRKboUekoTJzJpAVekA61BisUMp0Hel1ypJPYOGXCRpTiBqDFfpGOl9MECv0DjLlFziwpzUlJIOpzBvi2bGB9EktUpqlmBt8b7nLYm57velzMnxnLUPu2MBKDbQATyHvwSJFZUgGnUm3RfwBSZchnUIRNVAbnVPoOmS05KBLB5K93yBBshaZYgAZZe2XQBB3QUYX7wbDoefac2hNZQEZXbgrDIvu2G3oQWjKCpClQiKz0NTVhHzAEuNxlqVmhtgTuC+mzSydhPzaoerenqntZMvPoKG4r344CfktmFJixKDbv1aanJ1D1X8zxhDytdYNmj91+3iieo+iMAAAAABJRU5ErkJggg==", false, 2, null);
                                        afVar2.marginRight(2.0f);
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final GuildCommonItemModel guildCommonItemModel4 = GuildCommonItemModel.this;
                        cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.GuildMusicItemView.configHeader.1.1.1.5
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(TextView textView) {
                                final GuildCommonItemModel guildCommonItemModel5 = GuildCommonItemModel.this;
                                final h hVar2 = hVar;
                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.GuildMusicItemView.configHeader.1.1.1.5.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ce ceVar) {
                                        ce ceVar2 = ceVar;
                                        ceVar2.mo141height(FontModuleExtKt.qqFontScaleAddSize(12.0f) + 16.0f);
                                        ceVar2.text(GuildCommonItemModel.this.getAudienceCount());
                                        ce.fontSize$default(ceVar2, 12.0f, null, 2, null);
                                        ceVar2.fontWeight400();
                                        ceVar2.color(hVar2);
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

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.GuildBaseImageItemView
    public final void configMiddle(GuildItemMiddleAvatarAttr guildItemMiddleAvatarAttr) {
        guildItemMiddleAvatarAttr.appIcon = "";
        guildItemMiddleAvatarAttr.setPlay(((GuildBaseImageAttr) getAttr()).getPlayIndex() == ((GuildBaseImageAttr) getAttr()).index);
    }
}
