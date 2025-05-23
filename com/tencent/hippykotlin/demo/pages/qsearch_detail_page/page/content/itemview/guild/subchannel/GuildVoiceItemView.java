package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel;

import com.tencent.hippykotlin.demo.pages.foundation.extension.FontModuleExtKt;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.guild.Audience;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.guild.GuildCommonItemModel;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.view.GuildItemFooterAttr;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.view.GuildItemHeaderAttr;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.view.GuildItemMiddleAvatarAttr;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.view.GuildUserIconsAttr;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.view.GuildUserIconsView;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.view.GuildUserIconsViewKt;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.view.GuildVoiceBackgroundAttr;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.view.GuildVoiceBackgroundView;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class GuildVoiceItemView extends GuildBaseImageItemView {
    @Override // com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.GuildBaseImageItemView
    public final Function1 configBackground(final GuildCommonItemModel guildCommonItemModel, final float f16) {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.GuildVoiceItemView$configBackground$1
            public final /* synthetic */ float $itemHeight = 170.0f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                final float f17 = f16;
                final float f18 = this.$itemHeight;
                final GuildCommonItemModel guildCommonItemModel2 = guildCommonItemModel;
                viewContainer.addChild(new GuildVoiceBackgroundView(), new Function1<GuildVoiceBackgroundView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.GuildVoiceItemView$configBackground$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(GuildVoiceBackgroundView guildVoiceBackgroundView) {
                        final float f19 = f17;
                        final float f26 = f18;
                        final GuildCommonItemModel guildCommonItemModel3 = guildCommonItemModel2;
                        guildVoiceBackgroundView.attr(new Function1<GuildVoiceBackgroundAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.GuildVoiceItemView.configBackground.1.1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(GuildVoiceBackgroundAttr guildVoiceBackgroundAttr) {
                                GuildVoiceBackgroundAttr guildVoiceBackgroundAttr2 = guildVoiceBackgroundAttr;
                                Attr.absolutePosition$default(guildVoiceBackgroundAttr2, 0.0f, 0.0f, 0.0f, 0.0f, 12, null);
                                guildVoiceBackgroundAttr2.size(f19, f26);
                                guildVoiceBackgroundAttr2.src = guildCommonItemModel3.getCover();
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
    public final void configFooter(GuildItemFooterAttr guildItemFooterAttr) {
        int i3 = ((GuildBaseImageAttr) getAttr()).index;
        guildItemFooterAttr.getClass();
        guildItemFooterAttr.buttonText = "\u52a0\u5165";
        guildItemFooterAttr.buttonColor = new h(1291845631L);
        guildItemFooterAttr.buttonWidth = 54.0f;
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [kotlin.jvm.internal.Lambda, com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.GuildVoiceItemView$configHeader$1$1] */
    @Override // com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.GuildBaseImageItemView
    public final void configHeader(GuildItemHeaderAttr guildItemHeaderAttr, final GuildCommonItemModel guildCommonItemModel) {
        guildItemHeaderAttr.text = "\u8bed\u97f3\u4e2d";
        guildItemHeaderAttr.iconColor = new h(4294925304L);
        guildItemHeaderAttr.iconBgColor = new h(2988574513L);
        guildItemHeaderAttr.setIconSrcIOS("ec_search_guild_voice.pag");
        guildItemHeaderAttr.setIconSrcAnd("ecommerce_search_guild_voice");
        guildItemHeaderAttr.rightPartViewBuilder = new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.GuildVoiceItemView$configHeader$1$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                final GuildCommonItemModel guildCommonItemModel2 = GuildCommonItemModel.this;
                w.a(viewContainer, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.GuildVoiceItemView$configHeader$1$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.GuildVoiceItemView.configHeader.1.1.1.1
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
                        GuildUserIconsViewKt.QSearchLiveUserView(vVar2, new Function1<GuildUserIconsView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.GuildVoiceItemView.configHeader.1.1.1.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(GuildUserIconsView guildUserIconsView) {
                                final GuildCommonItemModel guildCommonItemModel4 = GuildCommonItemModel.this;
                                guildUserIconsView.attr(new Function1<GuildUserIconsAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.GuildVoiceItemView.configHeader.1.1.1.2.1
                                    {
                                        super(1);
                                    }

                                    /* JADX WARN: Type inference failed for: r0v9, types: [java.util.List<com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.guild.Audience>, java.util.ArrayList] */
                                    /* JADX WARN: Type inference failed for: r1v2, types: [java.util.List<com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.guild.Audience>, java.util.ArrayList] */
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(GuildUserIconsAttr guildUserIconsAttr) {
                                        List<Audience> emptyList;
                                        GuildUserIconsAttr guildUserIconsAttr2 = guildUserIconsAttr;
                                        guildUserIconsAttr2.mo141height(FontModuleExtKt.qqFontScaleAddSize(12.0f) + 18.0f);
                                        emptyList = CollectionsKt__CollectionsKt.emptyList();
                                        if (GuildCommonItemModel.this.audienceList.size() > 6) {
                                            ?? r06 = GuildCommonItemModel.this.audienceList;
                                            emptyList = r06.subList(6, r06.size());
                                        }
                                        guildUserIconsAttr2.audienceList(emptyList);
                                        guildUserIconsAttr2.audienceCount = GuildCommonItemModel.this.getAudienceCount();
                                        guildUserIconsAttr2.setRightIcon("data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAACQAAAAkCAYAAADhAJiYAAAACXBIWXMAACE4AAAhOAFFljFgAAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAAGUSURBVHgB7Zg9bsJAEIXfWunCAThADkAfeuid3jSpoEnFGahScYD0OUDS5wDkFjlAemcmWpBtFvvNrm0JiU9arZDHq4/ZvwHgxpXhkEhZlhPpJv+DOfeDRKKEvEQubSlt2nh8kPYpch+IwCwkMgvpNvBZaUGz9WLNmklIZArpVoZXzFIZGygyc6OMotP56qe4XyFhjThU6okNpoTkG4YWr4WczRKboUekoTJzJpAVekA61BisUMp0Hel1ypJPYOGXCRpTiBqDFfpGOl9MECv0DjLlFziwpzUlJIOpzBvi2bGB9EktUpqlmBt8b7nLYm57velzMnxnLUPu2MBKDbQATyHvwSJFZUgGnUm3RfwBSZchnUIRNVAbnVPoOmS05KBLB5K93yBBshaZYgAZZe2XQBB3QUYX7wbDoefac2hNZQEZXbgrDIvu2G3oQWjKCpClQiKz0NTVhHzAEuNxlqVmhtgTuC+mzSydhPzaoerenqntZMvPoKG4r344CfktmFJixKDbv1aanJ1D1X8zxhDytdYNmj91+3iieo+iMAAAAABJRU5ErkJggg==");
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
