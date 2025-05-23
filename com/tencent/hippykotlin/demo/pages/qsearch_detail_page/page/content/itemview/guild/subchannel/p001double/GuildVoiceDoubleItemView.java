package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.p001double;

import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.guild.GuildCommonItemModel;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.p001double.view.GuildDoubleItemHeaderAttr;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.view.GuildVoiceBackgroundAttr;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.view.GuildVoiceBackgroundView;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.h;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class GuildVoiceDoubleItemView extends GuildMusicDoubleItemView {
    @Override // com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.p001double.GuildBaseImageDoubleItemView
    public final Function1 configBackground$1(final GuildCommonItemModel guildCommonItemModel, final float f16) {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.double.GuildVoiceDoubleItemView$configBackground$1
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
                viewContainer.addChild(new GuildVoiceBackgroundView(), new Function1<GuildVoiceBackgroundView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.double.GuildVoiceDoubleItemView$configBackground$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(GuildVoiceBackgroundView guildVoiceBackgroundView) {
                        final float f19 = f17;
                        final float f26 = f18;
                        final GuildCommonItemModel guildCommonItemModel3 = guildCommonItemModel2;
                        guildVoiceBackgroundView.attr(new Function1<GuildVoiceBackgroundAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.double.GuildVoiceDoubleItemView.configBackground.1.1.1
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

    @Override // com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.p001double.GuildMusicDoubleItemView, com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.p001double.GuildBaseImageDoubleItemView
    public final void configHeader(GuildDoubleItemHeaderAttr guildDoubleItemHeaderAttr) {
        guildDoubleItemHeaderAttr.text = "\u8bed\u97f3\u4e2d";
        guildDoubleItemHeaderAttr.iconColor = new h(4294925304L);
        guildDoubleItemHeaderAttr.iconBgColor = new h(2988574513L);
        guildDoubleItemHeaderAttr.setIconSrcIOS("ec_search_guild_voice.pag");
        guildDoubleItemHeaderAttr.setIconSrcAnd("ecommerce_search_guild_voice");
    }
}
