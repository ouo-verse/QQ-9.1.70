package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel;

import com.tencent.hippykotlin.demo.pages.foundation.extension.FontModuleExtKt;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.PageStatus;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.StFeedEx;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.guild.Audience;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.guild.GuildVideoItemModel;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.guild.SearchGuildBaseItemModel;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.view.GuildItemFooterAttr;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.view.GuildItemFooterView;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.view.GuildItemHeaderAttr;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.view.GuildItemHeaderView;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.view.GuildUserIconsAttr;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.view.GuildUserIconsView;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.view.GuildUserIconsViewKt;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.view.SingleGuildVideoItemAttr;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.view.SingleGuildVideoItemView;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.BorderStyle;
import com.tencent.kuikly.core.base.Direction;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.e;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.j;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ah;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* compiled from: P */
/* loaded from: classes32.dex */
public class GuildLiveVideoItemView extends GuildBaseItemView<GuildLiveVideoAttr, GuildLiveVideoEvent, GuildVideoItemModel> {
    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ GuildLiveVideoAttr access$getAttr(GuildLiveVideoItemView guildLiveVideoItemView) {
        return (GuildLiveVideoAttr) guildLiveVideoItemView.getAttr();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void configFooter(GuildItemFooterAttr guildItemFooterAttr) {
        guildItemFooterAttr.mo113backgroundColor(new h(3845206328L));
        int i3 = ((GuildLiveVideoAttr) getAttr()).index;
        guildItemFooterAttr.buttonText = "\u89c2\u770b\u76f4\u64ad";
        guildItemFooterAttr.buttonColor = new h(4278229503L);
        guildItemFooterAttr.buttonWidth = 68.0f;
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.GuildLiveVideoItemView$configHeader$1$1, kotlin.jvm.internal.Lambda] */
    public void configHeader(GuildItemHeaderAttr guildItemHeaderAttr, final GuildVideoItemModel guildVideoItemModel) {
        guildItemHeaderAttr.text = "\u76f4\u64ad\u4e2d";
        guildItemHeaderAttr.iconColor = new h(4294930256L);
        guildItemHeaderAttr.iconBgColor = new h(2990674958L);
        guildItemHeaderAttr.rightPartViewBuilder = new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.GuildLiveVideoItemView$configHeader$1$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                final GuildVideoItemModel guildVideoItemModel2 = GuildVideoItemModel.this;
                w.a(viewContainer, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.GuildLiveVideoItemView$configHeader$1$1.1
                    {
                        super(1);
                    }

                    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.List<com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.guild.Audience>, java.util.ArrayList] */
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.GuildLiveVideoItemView.configHeader.1.1.1.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.m140flex(1.0f);
                                tVar2.flexDirectionRow();
                                tVar2.justifyContentFlexEnd();
                                return Unit.INSTANCE;
                            }
                        });
                        final Ref.IntRef intRef = new Ref.IntRef();
                        if (GuildVideoItemModel.this.audienceList.size() > 1) {
                            intRef.element = 1;
                            final GuildVideoItemModel guildVideoItemModel3 = GuildVideoItemModel.this;
                            ah.a(vVar2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.GuildLiveVideoItemView.configHeader.1.1.1.2
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(ImageView imageView) {
                                    final GuildVideoItemModel guildVideoItemModel4 = GuildVideoItemModel.this;
                                    imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.GuildLiveVideoItemView.configHeader.1.1.1.2.1
                                        {
                                            super(1);
                                        }

                                        /* JADX WARN: Type inference failed for: r0v4, types: [java.util.List<com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.guild.Audience>, java.util.ArrayList] */
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(af afVar) {
                                            af afVar2 = afVar;
                                            afVar2.mo153width(18.0f);
                                            afVar2.mo141height(18.0f);
                                            afVar2.borderRadius(9.0f);
                                            afVar2.m136border(new e(1.0f, BorderStyle.SOLID, h.INSTANCE.m()));
                                            b.a.b(afVar2, ((Audience) GuildVideoItemModel.this.audienceList.get(0)).avatar, false, 2, null);
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    return Unit.INSTANCE;
                                }
                            });
                            w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.GuildLiveVideoItemView.configHeader.1.1.1.3
                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(v vVar3) {
                                    vVar3.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.GuildLiveVideoItemView.configHeader.1.1.1.3.1
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(t tVar) {
                                            t tVar2 = tVar;
                                            tVar2.mo153width(1.0f);
                                            tVar2.mo141height(18.0f);
                                            tVar2.marginLeft(6.0f).marginRight(6.0f);
                                            tVar2.mo113backgroundColor(new h(2164260863L));
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    return Unit.INSTANCE;
                                }
                            });
                        }
                        final GuildVideoItemModel guildVideoItemModel4 = GuildVideoItemModel.this;
                        GuildUserIconsViewKt.QSearchLiveUserView(vVar2, new Function1<GuildUserIconsView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.GuildLiveVideoItemView.configHeader.1.1.1.4
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(GuildUserIconsView guildUserIconsView) {
                                final GuildVideoItemModel guildVideoItemModel5 = GuildVideoItemModel.this;
                                final Ref.IntRef intRef2 = intRef;
                                guildUserIconsView.attr(new Function1<GuildUserIconsAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.GuildLiveVideoItemView.configHeader.1.1.1.4.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    /* JADX WARN: Type inference failed for: r0v4, types: [java.util.List<com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.guild.Audience>, java.util.ArrayList] */
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(GuildUserIconsAttr guildUserIconsAttr) {
                                        GuildUserIconsAttr guildUserIconsAttr2 = guildUserIconsAttr;
                                        guildUserIconsAttr2.mo141height(FontModuleExtKt.qqFontScaleAddSize(12.0f) + 18.0f);
                                        ?? r06 = GuildVideoItemModel.this.audienceList;
                                        guildUserIconsAttr2.audienceList(r06.subList(intRef2.element, r06.size()));
                                        guildUserIconsAttr2.audienceCount = GuildVideoItemModel.this.getAudienceCount();
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
        return new GuildLiveVideoAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new GuildLiveVideoEvent();
    }

    @Override // com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.GuildBaseItemView
    public final void createItem(SearchGuildBaseItemModel searchGuildBaseItemModel, final float f16, ViewContainer viewContainer) {
        final GuildVideoItemModel guildVideoItemModel = (GuildVideoItemModel) searchGuildBaseItemModel;
        viewContainer.addChild(new SingleGuildVideoItemView(), new Function1<SingleGuildVideoItemView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.GuildLiveVideoItemView$createItem$1$1
            public final /* synthetic */ float $itemHeight = 170.0f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(SingleGuildVideoItemView singleGuildVideoItemView) {
                final float f17 = f16;
                final float f18 = this.$itemHeight;
                final GuildLiveVideoItemView guildLiveVideoItemView = this;
                final GuildVideoItemModel guildVideoItemModel2 = guildVideoItemModel;
                singleGuildVideoItemView.attr(new Function1<SingleGuildVideoItemAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.GuildLiveVideoItemView$createItem$1$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(SingleGuildVideoItemAttr singleGuildVideoItemAttr) {
                        SingleGuildVideoItemAttr singleGuildVideoItemAttr2 = singleGuildVideoItemAttr;
                        Attr.absolutePosition$default(singleGuildVideoItemAttr2, 0.0f, 0.0f, 0.0f, 0.0f, 12, null);
                        singleGuildVideoItemAttr2.size(f17, f18);
                        GuildLiveVideoAttr access$getAttr = GuildLiveVideoItemView.access$getAttr(guildLiveVideoItemView);
                        boolean booleanValue = ((Boolean) access$getAttr.muted$delegate.getValue(access$getAttr, GuildLiveVideoAttr.$$delegatedProperties[0])).booleanValue();
                        ReadWriteProperty readWriteProperty = singleGuildVideoItemAttr2.muted$delegate;
                        KProperty<?>[] kPropertyArr = SingleGuildVideoItemAttr.$$delegatedProperties;
                        readWriteProperty.setValue(singleGuildVideoItemAttr2, kPropertyArr[0], Boolean.valueOf(booleanValue));
                        singleGuildVideoItemAttr2.index = GuildLiveVideoItemView.access$getAttr(guildLiveVideoItemView).index;
                        singleGuildVideoItemAttr2.playIndex$delegate.setValue(singleGuildVideoItemAttr2, kPropertyArr[1], Integer.valueOf(GuildLiveVideoItemView.access$getAttr(guildLiveVideoItemView).getPlayIndex()));
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
        viewContainer.addChild(new GuildItemHeaderView(), new Function1<GuildItemHeaderView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.GuildLiveVideoItemView$createItem$1$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(GuildItemHeaderView guildItemHeaderView) {
                final GuildLiveVideoItemView guildLiveVideoItemView = GuildLiveVideoItemView.this;
                final GuildVideoItemModel guildVideoItemModel2 = guildVideoItemModel;
                guildItemHeaderView.attr(new Function1<GuildItemHeaderAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.GuildLiveVideoItemView$createItem$1$2.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(GuildItemHeaderAttr guildItemHeaderAttr) {
                        GuildItemHeaderAttr guildItemHeaderAttr2 = guildItemHeaderAttr;
                        GuildLiveVideoAttr access$getAttr = GuildLiveVideoItemView.access$getAttr(GuildLiveVideoItemView.this);
                        guildItemHeaderAttr2.pageStatus$delegate.setValue(guildItemHeaderAttr2, GuildItemHeaderAttr.$$delegatedProperties[3], (PageStatus) access$getAttr.pageStatus$delegate.getValue(access$getAttr, GuildBaseAttr.$$delegatedProperties[2]));
                        guildItemHeaderAttr2.tabData = GuildLiveVideoItemView.access$getAttr(GuildLiveVideoItemView.this).tabData;
                        GuildLiveVideoItemView.this.configHeader(guildItemHeaderAttr2, guildVideoItemModel2);
                        return Unit.INSTANCE;
                    }
                });
                return Unit.INSTANCE;
            }
        });
        w.a(viewContainer, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.GuildLiveVideoItemView$createItem$1$3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(v vVar) {
                v vVar2 = vVar;
                vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.GuildLiveVideoItemView$createItem$1$3.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(t tVar) {
                        t tVar2 = tVar;
                        tVar2.m140flex(1.0f);
                        tVar2.marginTop(16.0f);
                        tVar2.justifyContentFlexEnd();
                        tVar2.paddingLeft(12.0f);
                        tVar2.paddingRight(12.0f);
                        tVar2.mo135backgroundLinearGradient(Direction.TO_BOTTOM, new j(new h(3223864L), 0.0f), new j(new h(3845206328L), 1.0f));
                        return Unit.INSTANCE;
                    }
                });
                final GuildVideoItemModel guildVideoItemModel2 = GuildVideoItemModel.this;
                cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.GuildLiveVideoItemView$createItem$1$3.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(TextView textView) {
                        final GuildVideoItemModel guildVideoItemModel3 = GuildVideoItemModel.this;
                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.GuildLiveVideoItemView.createItem.1.3.2.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ce ceVar) {
                                ce ceVar2 = ceVar;
                                ceVar2.marginRight(90.0f);
                                ceVar2.color(h.INSTANCE.m());
                                ce.fontSize$default(ceVar2, 17.0f, null, 2, null);
                                ceVar2.fontFamily("PingFang SC");
                                ceVar2.fontWeight500();
                                ceVar2.text(GuildVideoItemModel.this.getSubChannelName());
                                ceVar2.lines(1);
                                ceVar2.textOverFlowTail();
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                return Unit.INSTANCE;
            }
        });
        viewContainer.addChild(new GuildItemFooterView(), new Function1<GuildItemFooterView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.GuildLiveVideoItemView$createItem$1$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(GuildItemFooterView guildItemFooterView) {
                final GuildVideoItemModel guildVideoItemModel2 = GuildVideoItemModel.this;
                final GuildLiveVideoItemView guildLiveVideoItemView = this;
                guildItemFooterView.attr(new Function1<GuildItemFooterAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.GuildLiveVideoItemView$createItem$1$4.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(GuildItemFooterAttr guildItemFooterAttr) {
                        GuildItemFooterAttr guildItemFooterAttr2 = guildItemFooterAttr;
                        guildItemFooterAttr2.data = GuildVideoItemModel.this;
                        guildLiveVideoItemView.configFooter(guildItemFooterAttr2);
                        guildItemFooterAttr2.traceId = GuildLiveVideoItemView.access$getAttr(guildLiveVideoItemView).traceId;
                        guildItemFooterAttr2.reportParams = guildLiveVideoItemView.getReportParams(GuildVideoItemModel.this);
                        return Unit.INSTANCE;
                    }
                });
                return Unit.INSTANCE;
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.GuildBaseItemView
    public final GuildVideoItemModel getData() {
        SearchGuildBaseItemModel searchGuildBaseItemModel = ((GuildLiveVideoAttr) getAttr()).data;
        if (searchGuildBaseItemModel instanceof GuildVideoItemModel) {
            return (GuildVideoItemModel) searchGuildBaseItemModel;
        }
        return null;
    }
}
