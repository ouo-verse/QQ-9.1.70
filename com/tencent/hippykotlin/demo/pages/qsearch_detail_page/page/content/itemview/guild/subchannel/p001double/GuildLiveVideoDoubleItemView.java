package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.p001double;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.foundation.extension.FontModuleExtKt;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.PageStatus;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.StFeedEx;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.guild.GuildVideoItemModel;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.guild.SearchGuildBaseItemModel;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.p001double.view.GuildDoubleItemHeaderAttr;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.p001double.view.GuildDoubleItemHeaderView;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.view.GuildUserIconsAttr;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.view.GuildUserIconsView;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.view.GuildUserIconsViewKt;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.view.SingleGuildVideoItemAttr;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.view.SingleGuildVideoItemView;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.Direction;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.j;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* compiled from: P */
/* loaded from: classes32.dex */
public class GuildLiveVideoDoubleItemView extends GuildBaseDoubleItemView<GuildLiveVideoDoubleAttr, GuildLiveVideoDoubleEvent, GuildVideoItemModel> {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(GuildLiveVideoDoubleItemView.class, "subPlayIndex", "getSubPlayIndex()I", 0)};
    public boolean hasFocus;
    public int lastSubPlayIndex;
    public final ReadWriteProperty subPlayIndex$delegate = c.a(-1);

    /* JADX WARN: Multi-variable type inference failed */
    public static final void access$dispatchFocusState(GuildLiveVideoDoubleItemView guildLiveVideoDoubleItemView) {
        if (((GuildLiveVideoDoubleAttr) guildLiveVideoDoubleItemView.getAttr()).getPlayIndex() == ((GuildLiveVideoDoubleAttr) guildLiveVideoDoubleItemView.getAttr()).index) {
            if (guildLiveVideoDoubleItemView.hasFocus) {
                return;
            }
            guildLiveVideoDoubleItemView.hasFocus = true;
            guildLiveVideoDoubleItemView.setSubPlayIndex(guildLiveVideoDoubleItemView.lastSubPlayIndex);
            return;
        }
        if (guildLiveVideoDoubleItemView.hasFocus) {
            guildLiveVideoDoubleItemView.hasFocus = false;
            if (((GuildLiveVideoDoubleAttr) guildLiveVideoDoubleItemView.getAttr()).getPlayIndex() == -2) {
                guildLiveVideoDoubleItemView.lastSubPlayIndex = ((Number) guildLiveVideoDoubleItemView.subPlayIndex$delegate.getValue(guildLiveVideoDoubleItemView, $$delegatedProperties[0])).intValue();
                guildLiveVideoDoubleItemView.setSubPlayIndex(-2);
            } else {
                guildLiveVideoDoubleItemView.lastSubPlayIndex = 0;
                guildLiveVideoDoubleItemView.setSubPlayIndex(-1);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ GuildLiveVideoDoubleAttr access$getAttr(GuildLiveVideoDoubleItemView guildLiveVideoDoubleItemView) {
        return (GuildLiveVideoDoubleAttr) guildLiveVideoDoubleItemView.getAttr();
    }

    public void configHeader(GuildDoubleItemHeaderAttr guildDoubleItemHeaderAttr) {
        guildDoubleItemHeaderAttr.text = "\u76f4\u64ad\u4e2d";
        guildDoubleItemHeaderAttr.iconColor = new h(4294930256L);
        guildDoubleItemHeaderAttr.iconBgColor = new h(2990674958L);
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return new GuildLiveVideoDoubleAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new GuildLiveVideoDoubleEvent();
    }

    @Override // com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.p001double.GuildBaseDoubleItemView
    public final void createItem(SearchGuildBaseItemModel searchGuildBaseItemModel, final float f16, final int i3, ViewContainer viewContainer) {
        final GuildVideoItemModel guildVideoItemModel = (GuildVideoItemModel) searchGuildBaseItemModel;
        viewContainer.addChild(new SingleGuildVideoItemView(), new Function1<SingleGuildVideoItemView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.double.GuildLiveVideoDoubleItemView$createItem$1$1
            public final /* synthetic */ float $itemHeight = 170.0f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(SingleGuildVideoItemView singleGuildVideoItemView) {
                final float f17 = f16;
                final float f18 = this.$itemHeight;
                final GuildLiveVideoDoubleItemView guildLiveVideoDoubleItemView = this;
                final int i16 = i3;
                final GuildVideoItemModel guildVideoItemModel2 = guildVideoItemModel;
                singleGuildVideoItemView.attr(new Function1<SingleGuildVideoItemAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.double.GuildLiveVideoDoubleItemView$createItem$1$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(SingleGuildVideoItemAttr singleGuildVideoItemAttr) {
                        SingleGuildVideoItemAttr singleGuildVideoItemAttr2 = singleGuildVideoItemAttr;
                        Attr.absolutePosition$default(singleGuildVideoItemAttr2, 0.0f, 0.0f, 0.0f, 0.0f, 12, null);
                        singleGuildVideoItemAttr2.size(f17, f18);
                        GuildLiveVideoDoubleAttr access$getAttr = GuildLiveVideoDoubleItemView.access$getAttr(guildLiveVideoDoubleItemView);
                        boolean booleanValue = ((Boolean) access$getAttr.muted$delegate.getValue(access$getAttr, GuildLiveVideoDoubleAttr.$$delegatedProperties[0])).booleanValue();
                        ReadWriteProperty readWriteProperty = singleGuildVideoItemAttr2.muted$delegate;
                        KProperty<?>[] kPropertyArr = SingleGuildVideoItemAttr.$$delegatedProperties;
                        readWriteProperty.setValue(singleGuildVideoItemAttr2, kPropertyArr[0], Boolean.valueOf(booleanValue));
                        singleGuildVideoItemAttr2.index = i16;
                        GuildLiveVideoDoubleItemView guildLiveVideoDoubleItemView2 = guildLiveVideoDoubleItemView;
                        singleGuildVideoItemAttr2.playIndex$delegate.setValue(singleGuildVideoItemAttr2, kPropertyArr[1], Integer.valueOf(((Number) guildLiveVideoDoubleItemView2.subPlayIndex$delegate.getValue(guildLiveVideoDoubleItemView2, GuildLiveVideoDoubleItemView.$$delegatedProperties[0])).intValue()));
                        GuildVideoItemModel guildVideoItemModel3 = guildVideoItemModel2;
                        singleGuildVideoItemAttr2.data = guildVideoItemModel3;
                        StFeedEx stFeedEx = guildVideoItemModel3.stFeedEx;
                        Intrinsics.checkNotNull(stFeedEx);
                        singleGuildVideoItemAttr2.stFeedEx = stFeedEx;
                        singleGuildVideoItemAttr2.mo153width(f17);
                        return Unit.INSTANCE;
                    }
                });
                return Unit.INSTANCE;
            }
        });
        viewContainer.addChild(new GuildDoubleItemHeaderView(), new Function1<GuildDoubleItemHeaderView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.double.GuildLiveVideoDoubleItemView$createItem$1$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(GuildDoubleItemHeaderView guildDoubleItemHeaderView) {
                final GuildVideoItemModel guildVideoItemModel2 = GuildVideoItemModel.this;
                final GuildLiveVideoDoubleItemView guildLiveVideoDoubleItemView = this;
                guildDoubleItemHeaderView.attr(new Function1<GuildDoubleItemHeaderAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.double.GuildLiveVideoDoubleItemView$createItem$1$2.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(GuildDoubleItemHeaderAttr guildDoubleItemHeaderAttr) {
                        GuildDoubleItemHeaderAttr guildDoubleItemHeaderAttr2 = guildDoubleItemHeaderAttr;
                        guildDoubleItemHeaderAttr2.avatar = GuildVideoItemModel.this.getChannelIcon();
                        GuildLiveVideoDoubleAttr access$getAttr = GuildLiveVideoDoubleItemView.access$getAttr(guildLiveVideoDoubleItemView);
                        guildDoubleItemHeaderAttr2.pageStatus$delegate.setValue(guildDoubleItemHeaderAttr2, GuildDoubleItemHeaderAttr.$$delegatedProperties[3], (PageStatus) access$getAttr.pageStatus$delegate.getValue(access$getAttr, GuildBaseDoubleAttr.$$delegatedProperties[2]));
                        guildDoubleItemHeaderAttr2.tabData = GuildLiveVideoDoubleItemView.access$getAttr(guildLiveVideoDoubleItemView).tabData;
                        guildLiveVideoDoubleItemView.configHeader(guildDoubleItemHeaderAttr2);
                        return Unit.INSTANCE;
                    }
                });
                return Unit.INSTANCE;
            }
        });
        w.a(viewContainer, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.double.GuildLiveVideoDoubleItemView$createItem$1$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(v vVar) {
                v vVar2 = vVar;
                vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.double.GuildLiveVideoDoubleItemView$createItem$1$3.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(t tVar) {
                        t tVar2 = tVar;
                        tVar2.m140flex(1.0f);
                        tVar2.justifyContentFlexEnd();
                        return Unit.INSTANCE;
                    }
                });
                final GuildVideoItemModel guildVideoItemModel2 = GuildVideoItemModel.this;
                final GuildLiveVideoDoubleItemView guildLiveVideoDoubleItemView = this;
                w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.double.GuildLiveVideoDoubleItemView$createItem$1$3.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar3) {
                        v vVar4 = vVar3;
                        vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.double.GuildLiveVideoDoubleItemView.createItem.1.3.2.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.mo141height(FontModuleExtKt.qqFontScaleAddSize(16.0f) + 100.0f);
                                tVar2.justifyContentFlexEnd();
                                tVar2.padding(0.0f, 12.0f, 12.0f, 12.0f);
                                tVar2.mo135backgroundLinearGradient(Direction.TO_TOP, new j(new h(0, 0, 0, 0.7f), 0.0f), new j(h.INSTANCE.j(), 1.0f));
                                return Unit.INSTANCE;
                            }
                        });
                        final GuildVideoItemModel guildVideoItemModel3 = GuildVideoItemModel.this;
                        final GuildLiveVideoDoubleItemView guildLiveVideoDoubleItemView2 = guildLiveVideoDoubleItemView;
                        cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.double.GuildLiveVideoDoubleItemView.createItem.1.3.2.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(TextView textView) {
                                final GuildVideoItemModel guildVideoItemModel4 = GuildVideoItemModel.this;
                                final GuildLiveVideoDoubleItemView guildLiveVideoDoubleItemView3 = guildLiveVideoDoubleItemView2;
                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.double.GuildLiveVideoDoubleItemView.createItem.1.3.2.2.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ce ceVar) {
                                        ce ceVar2 = ceVar;
                                        ceVar2.color(h.INSTANCE.m());
                                        ce.fontSize$default(ceVar2, 16.0f, null, 2, null);
                                        ceVar2.fontWeight500();
                                        ceVar2.text(GuildVideoItemModel.this.getSubChannelName());
                                        ceVar2.lines(guildLiveVideoDoubleItemView3.getTitleLines());
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final GuildVideoItemModel guildVideoItemModel4 = GuildVideoItemModel.this;
                        final GuildLiveVideoDoubleItemView guildLiveVideoDoubleItemView3 = guildLiveVideoDoubleItemView;
                        GuildUserIconsViewKt.QSearchLiveUserView(vVar4, new Function1<GuildUserIconsView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.double.GuildLiveVideoDoubleItemView.createItem.1.3.2.3
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(GuildUserIconsView guildUserIconsView) {
                                final GuildVideoItemModel guildVideoItemModel5 = GuildVideoItemModel.this;
                                final GuildLiveVideoDoubleItemView guildLiveVideoDoubleItemView4 = guildLiveVideoDoubleItemView3;
                                guildUserIconsView.attr(new Function1<GuildUserIconsAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.double.GuildLiveVideoDoubleItemView.createItem.1.3.2.3.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(GuildUserIconsAttr guildUserIconsAttr) {
                                        GuildUserIconsAttr guildUserIconsAttr2 = guildUserIconsAttr;
                                        guildUserIconsAttr2.marginTop(6.0f);
                                        guildUserIconsAttr2.alignSelfFlexStart();
                                        guildUserIconsAttr2.audienceCount = GuildVideoItemModel.this.getAudienceCount();
                                        guildUserIconsAttr2.audienceList(GuildVideoItemModel.this.audienceList);
                                        guildUserIconsAttr2.setRightIcon(guildLiveVideoDoubleItemView4.getBottomIcon());
                                        guildUserIconsAttr2.rightIconSize = 15.0f;
                                        guildUserIconsAttr2.fontSize = 13.0f;
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
        });
    }

    @Override // com.tencent.kuikly.core.base.ComposeView, com.tencent.kuikly.core.base.AbstractBaseView
    public final void didInit() {
        super.didInit();
        bindValueChange(new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.double.GuildLiveVideoDoubleItemView$didInit$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Integer.valueOf(GuildLiveVideoDoubleItemView.access$getAttr(GuildLiveVideoDoubleItemView.this).getPlayIndex());
            }
        }, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.double.GuildLiveVideoDoubleItemView$didInit$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Object obj) {
                GuildLiveVideoDoubleItemView.access$dispatchFocusState(GuildLiveVideoDoubleItemView.this);
                return Unit.INSTANCE;
            }
        });
    }

    public String getBottomIcon() {
        return "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAACUAAAAsCAYAAADikXHLAAAACXBIWXMAACE4AAAhOAFFljFgAAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAAI7SURBVHgB7ZitcgIxEMf3DgqmD4DnHKL4InCtp2gwVSgUqgM8AaYvgKb14HkAKnDUtx5/3YWEOXLJkc8ZZsp/JpO7TWbzu80mlwnATf9RaZpGmTqimhd6BwfFYCEOlBn8UE+nUw4KQruRbL+IInKA2G630WKxgG63e2rE9/TIhvSRU9BuCi+cpRmWJniSVaJLVMNCYD3wIF9QXH0fYD4jxUVgL+AgZygESCTmgUuO+YhUorCPEOweLOQD6klhpym1mkYnKDZFRdPUsYmWNRQbbHShG/V5Zv1runnmEqkZnK86lTiI9l5me0qgCCWa3eus5v0vbhnGUOhwAGxKNMWj+ZCx9RRbiTkUOuqAxYqifMKqlTFRrg3AFYo57oOdZHnUVCW+SaTIsdVmCOrplia9FhSLkkke6UoaLd1ItSCcrKEeIZxyq1AXSmeTtFVdNFwDVM6375OnF+lC7SGccr6vAWonGnShviCcvkWDLtQSwmktGrSg8D5gA2Gm8If5PpPJ6psr7HuwB5b61IbCL/rAaiNp2oEauEgr9Ll0gmJ6g/xq+WXAn6Av8vGuajSCwsFpmoZYVpI2GkQnYhTtIfMlHwcshUcOOsrQeWiPA7xm7PTboDO8+PcniDmLaqGcr9kQooUDrSV2gktYIaBlUXRuCq7JZBJTwccSlhgvX0vtdruMz2WhriRJUsW62mg0+HMFyx1rj1mJMjfNJxnlFHcg3PiS48Nt8LEpopvi3KpGuNM99ng8TpmfVDbOH0irzaPhyDAkAAAAAElFTkSuQmCC";
    }

    public int getTitleLines() {
        return 2;
    }

    public final void setSubPlayIndex(int i3) {
        this.subPlayIndex$delegate.setValue(this, $$delegatedProperties[0], Integer.valueOf(i3));
    }
}
