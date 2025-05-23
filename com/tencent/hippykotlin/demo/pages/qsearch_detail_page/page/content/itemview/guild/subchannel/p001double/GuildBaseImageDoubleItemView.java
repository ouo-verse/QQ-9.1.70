package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.p001double;

import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.PageStatus;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.guild.GuildCommonItemModel;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.guild.SearchGuildBaseItemModel;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.p001double.view.GuildDoubleItemHeaderAttr;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.p001double.view.GuildDoubleItemHeaderView;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.p001double.view.GuildDoubleItemMiddleAvatarAttr;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.p001double.view.GuildDoubleItemMiddleAvatarView;
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
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* compiled from: P */
/* loaded from: classes32.dex */
public abstract class GuildBaseImageDoubleItemView extends GuildBaseDoubleItemView<GuildBaseImageDoubleAttr, GuildBaseImageDoubleEvent, GuildCommonItemModel> {
    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ GuildBaseImageDoubleAttr access$getAttr(GuildBaseImageDoubleItemView guildBaseImageDoubleItemView) {
        return (GuildBaseImageDoubleAttr) guildBaseImageDoubleItemView.getAttr();
    }

    public Function1 configBackground$1(final GuildCommonItemModel guildCommonItemModel, final float f16) {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.double.GuildBaseImageDoubleItemView$configBackground$1
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
                viewContainer.addChild(new GuildMixBackgroundView(), new Function1<GuildMixBackgroundView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.double.GuildBaseImageDoubleItemView$configBackground$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(GuildMixBackgroundView guildMixBackgroundView) {
                        final float f19 = f17;
                        final float f26 = f18;
                        final GuildCommonItemModel guildCommonItemModel3 = guildCommonItemModel2;
                        guildMixBackgroundView.attr(new Function1<GuildMixBackgroundAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.double.GuildBaseImageDoubleItemView.configBackground.1.1.1
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

    public void configBottom(final GuildCommonItemModel guildCommonItemModel, ViewContainer viewContainer) {
        cg.a(viewContainer, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.double.GuildBaseImageDoubleItemView$configBottom$1$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(TextView textView) {
                final GuildCommonItemModel guildCommonItemModel2 = GuildCommonItemModel.this;
                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.double.GuildBaseImageDoubleItemView$configBottom$1$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ce ceVar) {
                        ce ceVar2 = ceVar;
                        ceVar2.marginLeft(12.0f);
                        ceVar2.marginBottom(12.0f);
                        ceVar2.marginTop(7.0f);
                        ceVar2.text(GuildCommonItemModel.this.getTitle());
                        ceVar2.lines(1);
                        ceVar2.color(new h(3221225471L));
                        ce.fontSize$default(ceVar2, 13.0f, null, 2, null);
                        ceVar2.fontWeight400();
                        return Unit.INSTANCE;
                    }
                });
                return Unit.INSTANCE;
            }
        });
    }

    public abstract void configHeader(GuildDoubleItemHeaderAttr guildDoubleItemHeaderAttr);

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return new GuildBaseImageDoubleAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new GuildBaseImageDoubleEvent();
    }

    @Override // com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.p001double.GuildBaseDoubleItemView
    public final void createItem(SearchGuildBaseItemModel searchGuildBaseItemModel, float f16, int i3, ViewContainer viewContainer) {
        final GuildCommonItemModel guildCommonItemModel = (GuildCommonItemModel) searchGuildBaseItemModel;
        configBackground$1(guildCommonItemModel, f16).invoke(viewContainer);
        viewContainer.addChild(new GuildDoubleItemHeaderView(), new Function1<GuildDoubleItemHeaderView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.double.GuildBaseImageDoubleItemView$createItem$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(GuildDoubleItemHeaderView guildDoubleItemHeaderView) {
                final GuildCommonItemModel guildCommonItemModel2 = GuildCommonItemModel.this;
                final GuildBaseImageDoubleItemView guildBaseImageDoubleItemView = this;
                guildDoubleItemHeaderView.attr(new Function1<GuildDoubleItemHeaderAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.double.GuildBaseImageDoubleItemView$createItem$1$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(GuildDoubleItemHeaderAttr guildDoubleItemHeaderAttr) {
                        GuildDoubleItemHeaderAttr guildDoubleItemHeaderAttr2 = guildDoubleItemHeaderAttr;
                        guildDoubleItemHeaderAttr2.avatar = GuildCommonItemModel.this.getChannelIcon();
                        GuildBaseImageDoubleAttr access$getAttr = GuildBaseImageDoubleItemView.access$getAttr(guildBaseImageDoubleItemView);
                        guildDoubleItemHeaderAttr2.pageStatus$delegate.setValue(guildDoubleItemHeaderAttr2, GuildDoubleItemHeaderAttr.$$delegatedProperties[3], (PageStatus) access$getAttr.pageStatus$delegate.getValue(access$getAttr, GuildBaseDoubleAttr.$$delegatedProperties[2]));
                        guildDoubleItemHeaderAttr2.tabData = GuildBaseImageDoubleItemView.access$getAttr(guildBaseImageDoubleItemView).tabData;
                        guildBaseImageDoubleItemView.configHeader(guildDoubleItemHeaderAttr2);
                        return Unit.INSTANCE;
                    }
                });
                return Unit.INSTANCE;
            }
        });
        new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.double.GuildBaseImageDoubleItemView$configMiddle$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer2) {
                final GuildBaseImageDoubleItemView guildBaseImageDoubleItemView = GuildBaseImageDoubleItemView.this;
                final GuildCommonItemModel guildCommonItemModel2 = guildCommonItemModel;
                viewContainer2.addChild(new GuildDoubleItemMiddleAvatarView(), new Function1<GuildDoubleItemMiddleAvatarView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.double.GuildBaseImageDoubleItemView$configMiddle$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(GuildDoubleItemMiddleAvatarView guildDoubleItemMiddleAvatarView) {
                        final GuildBaseImageDoubleItemView guildBaseImageDoubleItemView2 = GuildBaseImageDoubleItemView.this;
                        final GuildCommonItemModel guildCommonItemModel3 = guildCommonItemModel2;
                        guildDoubleItemMiddleAvatarView.attr(new Function1<GuildDoubleItemMiddleAvatarAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.double.GuildBaseImageDoubleItemView.configMiddle.1.1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(GuildDoubleItemMiddleAvatarAttr guildDoubleItemMiddleAvatarAttr) {
                                GuildDoubleItemMiddleAvatarAttr guildDoubleItemMiddleAvatarAttr2 = guildDoubleItemMiddleAvatarAttr;
                                guildDoubleItemMiddleAvatarAttr2.marginLeft(7.0f);
                                boolean z16 = GuildBaseImageDoubleItemView.access$getAttr(GuildBaseImageDoubleItemView.this).getPlayIndex() == GuildBaseImageDoubleItemView.access$getAttr(GuildBaseImageDoubleItemView.this).index;
                                ReadWriteProperty readWriteProperty = guildDoubleItemMiddleAvatarAttr2.play$delegate;
                                KProperty<?>[] kPropertyArr = GuildDoubleItemMiddleAvatarAttr.$$delegatedProperties;
                                readWriteProperty.setValue(guildDoubleItemMiddleAvatarAttr2, kPropertyArr[0], Boolean.valueOf(z16));
                                guildDoubleItemMiddleAvatarAttr2.audienceList = guildCommonItemModel3.audienceList;
                                GuildBaseImageDoubleAttr access$getAttr = GuildBaseImageDoubleItemView.access$getAttr(GuildBaseImageDoubleItemView.this);
                                guildDoubleItemMiddleAvatarAttr2.userScrolling$delegate.setValue(guildDoubleItemMiddleAvatarAttr2, kPropertyArr[1], Boolean.valueOf(((Boolean) access$getAttr.userScrolling$delegate.getValue(access$getAttr, GuildBaseDoubleAttr.$$delegatedProperties[3])).booleanValue()));
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                return Unit.INSTANCE;
            }
        }.invoke(viewContainer);
        cg.a(viewContainer, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.double.GuildBaseImageDoubleItemView$createItem$1$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(TextView textView) {
                final GuildCommonItemModel guildCommonItemModel2 = GuildCommonItemModel.this;
                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.double.GuildBaseImageDoubleItemView$createItem$1$2.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ce ceVar) {
                        ce ceVar2 = ceVar;
                        ceVar2.marginLeft(12.0f);
                        ceVar2.marginTop(15.0f);
                        ceVar2.color(h.INSTANCE.m());
                        ce.fontSize$default(ceVar2, 16.0f, null, 2, null);
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
        configBottom(guildCommonItemModel, viewContainer);
    }
}
