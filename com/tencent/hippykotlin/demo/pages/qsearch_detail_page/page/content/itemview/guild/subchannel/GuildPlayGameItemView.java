package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel;

import com.tencent.hippykotlin.demo.pages.foundation.extension.FontModuleExtKt;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.guild.GuildCommonItemModel;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.view.GuildItemFooterAttr;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.view.GuildItemHeaderAttr;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.view.GuildItemMiddleAvatarAttr;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* loaded from: classes32.dex */
public final class GuildPlayGameItemView extends GuildBaseImageItemView {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.GuildBaseImageItemView
    public final void configFooter(GuildItemFooterAttr guildItemFooterAttr) {
        int i3 = ((GuildBaseImageAttr) getAttr()).index;
        guildItemFooterAttr.getClass();
        guildItemFooterAttr.buttonText = "\u52a0\u5165";
        guildItemFooterAttr.buttonColor = new h(4278229503L);
        guildItemFooterAttr.buttonWidth = 54.0f;
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.GuildPlayGameItemView$configHeader$1$1, kotlin.jvm.internal.Lambda] */
    @Override // com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.GuildBaseImageItemView
    public final void configHeader(GuildItemHeaderAttr guildItemHeaderAttr, final GuildCommonItemModel guildCommonItemModel) {
        guildItemHeaderAttr.text = "\u5f00\u9ed1\u4e2d";
        guildItemHeaderAttr.iconColor = new h(4281466879L);
        guildItemHeaderAttr.iconBgColor = new h(2986358614L);
        guildItemHeaderAttr.setIconSrcIOS("ec_search_guild_interactive.pag");
        guildItemHeaderAttr.setIconSrcAnd("ecommerce_search_guild_interactive");
        guildItemHeaderAttr.rightPartViewBuilder = new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.GuildPlayGameItemView$configHeader$1$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                final GuildCommonItemModel guildCommonItemModel2 = GuildCommonItemModel.this;
                w.a(viewContainer, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.GuildPlayGameItemView$configHeader$1$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.GuildPlayGameItemView.configHeader.1.1.1.1
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
                        cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.GuildPlayGameItemView.configHeader.1.1.1.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(TextView textView) {
                                final GuildCommonItemModel guildCommonItemModel4 = GuildCommonItemModel.this;
                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.GuildPlayGameItemView.configHeader.1.1.1.2.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ce ceVar) {
                                        ce ceVar2 = ceVar;
                                        ceVar2.m144maxWidth(240.0f);
                                        ceVar2.text(GuildCommonItemModel.this.getTitle());
                                        ce.fontSize$default(ceVar2, 12.0f, null, 2, null);
                                        ceVar2.fontWeight400();
                                        ceVar2.color(new h(3238002687L));
                                        ceVar2.textOverFlowTail();
                                        ceVar2.lines(1);
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
        guildItemMiddleAvatarAttr.setPlay(((GuildBaseImageAttr) getAttr()).getPlayIndex() == ((GuildBaseImageAttr) getAttr()).index);
    }
}
