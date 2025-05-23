package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.channel;

import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.guild.SearchGuildChannelItemModel;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.QSearchBaseWholeCardItemView;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.event.Event;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class GuildChannelWholeCardItemView extends QSearchBaseWholeCardItemView<GuildChannelWholeCardItemAttr, GuildChannelWholeCardItemEvent> {
    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ GuildChannelWholeCardItemAttr access$getAttr(GuildChannelWholeCardItemView guildChannelWholeCardItemView) {
        return (GuildChannelWholeCardItemAttr) guildChannelWholeCardItemView.getAttr();
    }

    @Override // com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.QSearchBaseWholeCardItemView
    public final Function1<ViewContainer<?, ?>, Unit> buildItem(boolean z16) {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.channel.GuildChannelWholeCardItemView$buildItem$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                final GuildChannelWholeCardItemView guildChannelWholeCardItemView = GuildChannelWholeCardItemView.this;
                viewContainer.addChild(new GuildChannelSingleItemView(), new Function1<GuildChannelSingleItemView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.channel.GuildChannelWholeCardItemView$buildItem$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(GuildChannelSingleItemView guildChannelSingleItemView) {
                        final GuildChannelWholeCardItemView guildChannelWholeCardItemView2 = GuildChannelWholeCardItemView.this;
                        guildChannelSingleItemView.attr(new Function1<GuildChannelSingleItemAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.channel.GuildChannelWholeCardItemView.buildItem.1.1.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(GuildChannelSingleItemAttr guildChannelSingleItemAttr) {
                                GuildChannelSingleItemAttr guildChannelSingleItemAttr2 = guildChannelSingleItemAttr;
                                guildChannelSingleItemAttr2.keyword = GuildChannelWholeCardItemView.access$getAttr(GuildChannelWholeCardItemView.this).keyword;
                                SearchGuildChannelItemModel searchGuildChannelItemModel = GuildChannelWholeCardItemView.access$getAttr(GuildChannelWholeCardItemView.this).data;
                                if (searchGuildChannelItemModel == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("data");
                                    searchGuildChannelItemModel = null;
                                }
                                guildChannelSingleItemAttr2.data = searchGuildChannelItemModel;
                                guildChannelSingleItemAttr2.index = GuildChannelWholeCardItemView.access$getAttr(GuildChannelWholeCardItemView.this).index;
                                guildChannelSingleItemAttr2.traceId = GuildChannelWholeCardItemView.access$getAttr(GuildChannelWholeCardItemView.this).traceId;
                                guildChannelSingleItemAttr2.showDivider = false;
                                guildChannelSingleItemAttr2.tabData = GuildChannelWholeCardItemView.access$getAttr(GuildChannelWholeCardItemView.this).getTabData();
                                guildChannelSingleItemAttr2.filterTag = GuildChannelWholeCardItemView.access$getAttr(GuildChannelWholeCardItemView.this).filterTag;
                                guildChannelSingleItemAttr2.marginTop(8.0f);
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
        return new GuildChannelWholeCardItemAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new GuildChannelWholeCardItemEvent();
    }
}
