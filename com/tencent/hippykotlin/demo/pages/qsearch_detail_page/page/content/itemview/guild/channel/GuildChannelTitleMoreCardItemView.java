package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.channel;

import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.guild.SearchGuildChannelItemModel;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.template.TemplateItemsKt;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.QSearchBaseTitleMoreCardItemView;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.util.ISearchReport;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.pager.b;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class GuildChannelTitleMoreCardItemView extends QSearchBaseTitleMoreCardItemView<GuildChannelTitleMoreCardItemAttr> {
    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ GuildChannelTitleMoreCardItemAttr access$getAttr(GuildChannelTitleMoreCardItemView guildChannelTitleMoreCardItemView) {
        return (GuildChannelTitleMoreCardItemAttr) guildChannelTitleMoreCardItemView.getAttr();
    }

    @Override // com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.QSearchBaseTitleMoreCardItemView
    public final Function1<ViewContainer<?, ?>, Unit> buildItems() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.channel.GuildChannelTitleMoreCardItemView$buildItems$1
            {
                super(1);
            }

            /* JADX WARN: Type inference failed for: r0v3, types: [java.util.List<com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.guild.SearchGuildChannelItemModel>, java.util.ArrayList] */
            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                int size = GuildChannelTitleMoreCardItemView.access$getAttr(GuildChannelTitleMoreCardItemView.this).getData().channelList.size();
                for (final int i3 = 0; i3 < size; i3++) {
                    final GuildChannelTitleMoreCardItemView guildChannelTitleMoreCardItemView = GuildChannelTitleMoreCardItemView.this;
                    viewContainer2.addChild(new GuildChannelSingleItemView(), new Function1<GuildChannelSingleItemView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.channel.GuildChannelTitleMoreCardItemView$buildItems$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(GuildChannelSingleItemView guildChannelSingleItemView) {
                            final GuildChannelTitleMoreCardItemView guildChannelTitleMoreCardItemView2 = GuildChannelTitleMoreCardItemView.this;
                            final int i16 = i3;
                            guildChannelSingleItemView.attr(new Function1<GuildChannelSingleItemAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.channel.GuildChannelTitleMoreCardItemView.buildItems.1.1.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                /* JADX WARN: Type inference failed for: r1v6, types: [java.util.List<com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.guild.SearchGuildChannelItemModel>, java.util.ArrayList] */
                                /* JADX WARN: Type inference failed for: r2v4, types: [java.util.List<com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.guild.SearchGuildChannelItemModel>, java.util.ArrayList] */
                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(GuildChannelSingleItemAttr guildChannelSingleItemAttr) {
                                    GuildChannelSingleItemAttr guildChannelSingleItemAttr2 = guildChannelSingleItemAttr;
                                    guildChannelSingleItemAttr2.isInGroup = true;
                                    guildChannelSingleItemAttr2.keyword = GuildChannelTitleMoreCardItemView.access$getAttr(GuildChannelTitleMoreCardItemView.this).keyword;
                                    guildChannelSingleItemAttr2.data = (SearchGuildChannelItemModel) GuildChannelTitleMoreCardItemView.access$getAttr(GuildChannelTitleMoreCardItemView.this).getData().channelList.get(i16);
                                    guildChannelSingleItemAttr2.index = i16;
                                    guildChannelSingleItemAttr2.traceId = GuildChannelTitleMoreCardItemView.access$getAttr(GuildChannelTitleMoreCardItemView.this).traceId;
                                    guildChannelSingleItemAttr2.showDivider = i16 != GuildChannelTitleMoreCardItemView.access$getAttr(GuildChannelTitleMoreCardItemView.this).getData().channelList.size() - 1;
                                    guildChannelSingleItemAttr2.tabData = GuildChannelTitleMoreCardItemView.access$getAttr(GuildChannelTitleMoreCardItemView.this).tabData;
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
        return new GuildChannelTitleMoreCardItemAttr();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.QSearchBaseTitleMoreCardItemView
    public final e getReportParams() {
        String str;
        b pager = getPager();
        ISearchReport iSearchReport = pager instanceof ISearchReport ? (ISearchReport) pager : null;
        e reportParams = super.getReportParams();
        if (iSearchReport == null || (str = iSearchReport.getTabName(3)) == null) {
            str = "";
        }
        reportParams.v("target_tab_name", str);
        reportParams.t("target_tab_mask", 3);
        reportParams.v("transfer_info", TemplateItemsKt.mergeTransferInfo(((GuildChannelTitleMoreCardItemAttr) getAttr()).getData().getReportInfo(), reportParams));
        return reportParams;
    }

    @Override // com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.QSearchBaseTitleMoreCardItemView
    public final Integer getJumpTabWhenClickMore() {
        return 3;
    }
}
