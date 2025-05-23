package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel;

import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.PageStatus;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.GuildItemInfo;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.guild.GuildCommonItemModel;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.guild.SearchGuildBaseItemModel;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.view.GuildItemFooterAttr;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.view.GuildItemFooterView;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.view.GuildItemHeaderAttr;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.view.GuildItemHeaderView;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.view.GuildItemMiddleAvatarAttr;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.view.GuildItemMiddleAvatarView;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.view.GuildMixBackgroundAttr;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.view.GuildMixBackgroundView;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
/* loaded from: classes32.dex */
public abstract class GuildBaseImageItemView extends GuildBaseItemView<GuildBaseImageAttr, GuildBaseImageEvent, GuildCommonItemModel> {
    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ GuildBaseImageAttr access$getAttr(GuildBaseImageItemView guildBaseImageItemView) {
        return (GuildBaseImageAttr) guildBaseImageItemView.getAttr();
    }

    public Function1 configBackground(final GuildCommonItemModel guildCommonItemModel, final float f16) {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.GuildBaseImageItemView$configBackground$1
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
                viewContainer.addChild(new GuildMixBackgroundView(), new Function1<GuildMixBackgroundView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.GuildBaseImageItemView$configBackground$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(GuildMixBackgroundView guildMixBackgroundView) {
                        final float f19 = f17;
                        final float f26 = f18;
                        final GuildCommonItemModel guildCommonItemModel3 = guildCommonItemModel2;
                        guildMixBackgroundView.attr(new Function1<GuildMixBackgroundAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.GuildBaseImageItemView.configBackground.1.1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(GuildMixBackgroundAttr guildMixBackgroundAttr) {
                                GuildMixBackgroundAttr guildMixBackgroundAttr2 = guildMixBackgroundAttr;
                                Attr.absolutePosition$default(guildMixBackgroundAttr2, 0.0f, 0.0f, 0.0f, 0.0f, 12, null);
                                guildMixBackgroundAttr2.size(f19, f26);
                                guildMixBackgroundAttr2.with("src", guildCommonItemModel3.getCover());
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

    public abstract void configFooter(GuildItemFooterAttr guildItemFooterAttr);

    public abstract void configHeader(GuildItemHeaderAttr guildItemHeaderAttr, GuildCommonItemModel guildCommonItemModel);

    public abstract void configMiddle(GuildItemMiddleAvatarAttr guildItemMiddleAvatarAttr);

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return new GuildBaseImageAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new GuildBaseImageEvent();
    }

    @Override // com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.GuildBaseItemView
    public final void createItem(SearchGuildBaseItemModel searchGuildBaseItemModel, final float f16, ViewContainer viewContainer) {
        final GuildCommonItemModel guildCommonItemModel = (GuildCommonItemModel) searchGuildBaseItemModel;
        configBackground(guildCommonItemModel, f16).invoke(viewContainer);
        viewContainer.addChild(new GuildItemHeaderView(), new Function1<GuildItemHeaderView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.GuildBaseImageItemView$createItem$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(GuildItemHeaderView guildItemHeaderView) {
                final GuildBaseImageItemView guildBaseImageItemView = GuildBaseImageItemView.this;
                final GuildCommonItemModel guildCommonItemModel2 = guildCommonItemModel;
                guildItemHeaderView.attr(new Function1<GuildItemHeaderAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.GuildBaseImageItemView$createItem$1$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(GuildItemHeaderAttr guildItemHeaderAttr) {
                        GuildItemHeaderAttr guildItemHeaderAttr2 = guildItemHeaderAttr;
                        guildItemHeaderAttr2.maskStartAlpha = 0.35f;
                        GuildBaseImageAttr access$getAttr = GuildBaseImageItemView.access$getAttr(GuildBaseImageItemView.this);
                        guildItemHeaderAttr2.pageStatus$delegate.setValue(guildItemHeaderAttr2, GuildItemHeaderAttr.$$delegatedProperties[3], (PageStatus) access$getAttr.pageStatus$delegate.getValue(access$getAttr, GuildBaseAttr.$$delegatedProperties[2]));
                        guildItemHeaderAttr2.tabData = GuildBaseImageItemView.access$getAttr(GuildBaseImageItemView.this).tabData;
                        GuildBaseImageItemView.this.configHeader(guildItemHeaderAttr2, guildCommonItemModel2);
                        return Unit.INSTANCE;
                    }
                });
                return Unit.INSTANCE;
            }
        });
        viewContainer.addChild(new GuildItemMiddleAvatarView(), new Function1<GuildItemMiddleAvatarView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.GuildBaseImageItemView$createItem$1$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(GuildItemMiddleAvatarView guildItemMiddleAvatarView) {
                final float f17 = f16;
                final GuildCommonItemModel guildCommonItemModel2 = guildCommonItemModel;
                final GuildBaseImageItemView guildBaseImageItemView = this;
                guildItemMiddleAvatarView.attr(new Function1<GuildItemMiddleAvatarAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.GuildBaseImageItemView$createItem$1$2.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(GuildItemMiddleAvatarAttr guildItemMiddleAvatarAttr) {
                        String str;
                        GuildItemMiddleAvatarAttr guildItemMiddleAvatarAttr2 = guildItemMiddleAvatarAttr;
                        guildItemMiddleAvatarAttr2.cardWidth = f17;
                        GuildCommonItemModel guildCommonItemModel3 = guildCommonItemModel2;
                        GuildItemInfo guildItemInfo = guildCommonItemModel3.originData;
                        if (guildItemInfo == null || (str = guildItemInfo.appIcon) == null) {
                            str = "";
                        }
                        guildItemMiddleAvatarAttr2.appIcon = str;
                        guildItemMiddleAvatarAttr2.audienceList = guildCommonItemModel3.audienceList;
                        guildBaseImageItemView.configMiddle(guildItemMiddleAvatarAttr2);
                        GuildBaseImageAttr access$getAttr = GuildBaseImageItemView.access$getAttr(guildBaseImageItemView);
                        guildItemMiddleAvatarAttr2.userScrolling$delegate.setValue(guildItemMiddleAvatarAttr2, GuildItemMiddleAvatarAttr.$$delegatedProperties[1], Boolean.valueOf(((Boolean) access$getAttr.userScrolling$delegate.getValue(access$getAttr, GuildBaseAttr.$$delegatedProperties[3])).booleanValue()));
                        return Unit.INSTANCE;
                    }
                });
                return Unit.INSTANCE;
            }
        });
        cg.a(viewContainer, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.GuildBaseImageItemView$createItem$1$3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(TextView textView) {
                final GuildCommonItemModel guildCommonItemModel2 = GuildCommonItemModel.this;
                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.GuildBaseImageItemView$createItem$1$3.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ce ceVar) {
                        ce ceVar2 = ceVar;
                        ceVar2.marginRight(90.0f);
                        ceVar2.marginLeft(12.0f);
                        ceVar2.color(h.INSTANCE.m());
                        ce.fontSize$default(ceVar2, 17.0f, null, 2, null);
                        ceVar2.fontFamily("PingFang SC");
                        ceVar2.fontWeight500();
                        ceVar2.text(GuildCommonItemModel.this.getSubChannelName());
                        ceVar2.lines(1);
                        ceVar2.textOverFlowTail();
                        return Unit.INSTANCE;
                    }
                });
                return Unit.INSTANCE;
            }
        });
        viewContainer.addChild(new GuildItemFooterView(), new Function1<GuildItemFooterView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.GuildBaseImageItemView$createItem$1$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(GuildItemFooterView guildItemFooterView) {
                final GuildCommonItemModel guildCommonItemModel2 = GuildCommonItemModel.this;
                final GuildBaseImageItemView guildBaseImageItemView = this;
                guildItemFooterView.attr(new Function1<GuildItemFooterAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.GuildBaseImageItemView$createItem$1$4.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(GuildItemFooterAttr guildItemFooterAttr) {
                        GuildItemFooterAttr guildItemFooterAttr2 = guildItemFooterAttr;
                        GuildCommonItemModel guildCommonItemModel3 = GuildCommonItemModel.this;
                        guildItemFooterAttr2.data = guildCommonItemModel3;
                        guildItemFooterAttr2.reportParams = guildBaseImageItemView.getReportParams(guildCommonItemModel3);
                        guildBaseImageItemView.configFooter(guildItemFooterAttr2);
                        guildItemFooterAttr2.traceId = GuildBaseImageItemView.access$getAttr(guildBaseImageItemView).traceId;
                        return Unit.INSTANCE;
                    }
                });
                return Unit.INSTANCE;
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.GuildBaseItemView
    public final GuildCommonItemModel getData() {
        SearchGuildBaseItemModel searchGuildBaseItemModel = ((GuildBaseImageAttr) getAttr()).data;
        if (searchGuildBaseItemModel instanceof GuildCommonItemModel) {
            return (GuildCommonItemModel) searchGuildBaseItemModel;
        }
        return null;
    }
}
