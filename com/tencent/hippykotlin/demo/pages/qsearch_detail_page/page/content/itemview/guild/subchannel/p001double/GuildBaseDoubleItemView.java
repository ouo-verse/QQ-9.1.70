package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.p001double;

import com.tencent.hippykotlin.demo.pages.base.EcommerceExtKt;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.guild.SearchGuildBaseItemModel;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.guild.SearchGuildDoubleItemModel;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.p001double.GuildBaseDoubleAttr;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.p001double.GuildBaseDoubleEvent;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.view.GuildGroupTitleAttr;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.view.GuildGroupTitleView;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.util.ISearchReport;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.util.QSearchUtilKt;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.QSearchReportView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.pager.b;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.u;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes32.dex */
public abstract class GuildBaseDoubleItemView<Attr extends GuildBaseDoubleAttr, Event extends GuildBaseDoubleEvent, Model extends SearchGuildBaseItemModel> extends QSearchReportView<Attr, Event> {
    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ GuildBaseDoubleAttr access$getAttr(GuildBaseDoubleItemView guildBaseDoubleItemView) {
        return (GuildBaseDoubleAttr) guildBaseDoubleItemView.getAttr();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final e access$getReportParams(GuildBaseDoubleItemView guildBaseDoubleItemView, SearchGuildBaseItemModel searchGuildBaseItemModel) {
        e baseReportParams = guildBaseDoubleItemView.getBaseReportParams();
        GuildBaseDoubleAttr guildBaseDoubleAttr = (GuildBaseDoubleAttr) guildBaseDoubleItemView.getAttr();
        baseReportParams.v("search_query_text", (String) guildBaseDoubleAttr.keyword$delegate.getValue(guildBaseDoubleAttr, GuildBaseDoubleAttr.$$delegatedProperties[1]));
        baseReportParams.v("search_trace_id", ((GuildBaseDoubleAttr) guildBaseDoubleItemView.getAttr()).traceId);
        baseReportParams.v("online_member_count", searchGuildBaseItemModel.getAudienceCount());
        baseReportParams.v(QCircleDaTongConstant.ElementParamKey.SGRP_CHANNEL_NAME, searchGuildBaseItemModel.getChannelName());
        baseReportParams.v("search_card_type", "2");
        baseReportParams.t("sgrp_content_card_type", searchGuildBaseItemModel.getType());
        baseReportParams.t("search_index", searchGuildBaseItemModel.reportIndex + 1);
        baseReportParams.t("search_result_num", searchGuildBaseItemModel.resultNumber);
        b pager = guildBaseDoubleItemView.getPager();
        ISearchReport iSearchReport = pager instanceof ISearchReport ? (ISearchReport) pager : null;
        if (iSearchReport != null) {
            baseReportParams.v("query_source", String.valueOf(iSearchReport.getQuerySource()));
            baseReportParams.v("user_source", String.valueOf(iSearchReport.getUserSource()));
            baseReportParams.v("net_search_session_id", iSearchReport.getSessionId());
        }
        return baseReportParams;
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        final float m3 = (getPagerData().m() - 24.0f) / 2;
        return new Function1<ViewContainer<?, ?>, Unit>(this) { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.double.GuildBaseDoubleItemView$body$1
            public final /* synthetic */ GuildBaseDoubleItemView<Attr, Event, Model> $ctx;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$ctx = this;
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.double.GuildBaseDoubleItemView$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        mVar2.m140flex(1.0f);
                        mVar2.padding(8.0f, 8.0f, 0.0f, 0.0f);
                        return Unit.INSTANCE;
                    }
                });
                final GuildBaseDoubleItemView<Attr, Event, Model> guildBaseDoubleItemView = this.$ctx;
                viewContainer2.addChild(new GuildGroupTitleView(), new Function1<GuildGroupTitleView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.double.GuildBaseDoubleItemView$body$1.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(GuildGroupTitleView guildGroupTitleView) {
                        final GuildBaseDoubleItemView<GuildBaseDoubleAttr, GuildBaseDoubleEvent, SearchGuildBaseItemModel> guildBaseDoubleItemView2 = guildBaseDoubleItemView;
                        guildGroupTitleView.attr(new Function1<GuildGroupTitleAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.double.GuildBaseDoubleItemView.body.1.2.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(GuildGroupTitleAttr guildGroupTitleAttr) {
                                guildGroupTitleAttr.title = GuildBaseDoubleItemView.access$getAttr(guildBaseDoubleItemView2).title;
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final GuildBaseDoubleItemView<Attr, Event, Model> guildBaseDoubleItemView2 = this.$ctx;
                final float f16 = m3;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.double.GuildBaseDoubleItemView$body$1.3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    /* JADX WARN: Code restructure failed: missing block: B:5:0x0015, code lost:
                    
                        r0 = kotlin.collections.CollectionsKt___CollectionsKt.take(r0, 2);
                     */
                    @Override // kotlin.jvm.functions.Function1
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public final Unit invoke(v vVar) {
                        List take;
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.double.GuildBaseDoubleItemView.body.1.3.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.m140flex(1.0f);
                                tVar2.flexDirectionRow();
                                return Unit.INSTANCE;
                            }
                        });
                        SearchGuildDoubleItemModel searchGuildDoubleItemModel = GuildBaseDoubleItemView.access$getAttr(guildBaseDoubleItemView2).data;
                        if (searchGuildDoubleItemModel != null && (r0 = searchGuildDoubleItemModel.modelList) != null && take != null) {
                            final GuildBaseDoubleItemView<GuildBaseDoubleAttr, GuildBaseDoubleEvent, SearchGuildBaseItemModel> guildBaseDoubleItemView3 = guildBaseDoubleItemView2;
                            final float f17 = f16;
                            final int i3 = 0;
                            for (Object obj : take) {
                                int i16 = i3 + 1;
                                if (i3 < 0) {
                                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                                }
                                final SearchGuildBaseItemModel searchGuildBaseItemModel = (SearchGuildBaseItemModel) obj;
                                Intrinsics.checkNotNull(searchGuildBaseItemModel, "null cannot be cast to non-null type Model of com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.double.GuildBaseDoubleItemView.body.<no name provided>.invoke.<no name provided>.invoke$lambda$0");
                                guildBaseDoubleItemView3.getClass();
                                w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.double.GuildBaseDoubleItemView$createItemView$1$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar3) {
                                        v vVar4 = vVar3;
                                        final float f18 = f17;
                                        final int i17 = i3;
                                        final GuildBaseDoubleItemView<GuildBaseDoubleAttr, GuildBaseDoubleEvent, SearchGuildBaseItemModel> guildBaseDoubleItemView4 = guildBaseDoubleItemView3;
                                        final SearchGuildBaseItemModel searchGuildBaseItemModel2 = searchGuildBaseItemModel;
                                        vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.double.GuildBaseDoubleItemView$createItemView$1$1.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                t tVar2 = tVar;
                                                tVar2.mo153width(f18);
                                                tVar2.mo141height(170.0f);
                                                tVar2.marginLeft(i17 == 0 ? 0.0f : 8.0f);
                                                tVar2.borderRadius(8.0f);
                                                EcommerceExtKt.vr$default(tVar2, null, "em_search_channel_result_card", GuildBaseDoubleItemView.access$getReportParams(guildBaseDoubleItemView4, searchGuildBaseItemModel2), null, String.valueOf(searchGuildBaseItemModel2.hashCode()), true, 9);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final GuildBaseDoubleItemView<GuildBaseDoubleAttr, GuildBaseDoubleEvent, SearchGuildBaseItemModel> guildBaseDoubleItemView5 = guildBaseDoubleItemView3;
                                        final SearchGuildBaseItemModel searchGuildBaseItemModel3 = searchGuildBaseItemModel;
                                        final int i18 = i3;
                                        vVar4.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.double.GuildBaseDoubleItemView$createItemView$1$1.2
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(u uVar) {
                                                final GuildBaseDoubleItemView<GuildBaseDoubleAttr, GuildBaseDoubleEvent, SearchGuildBaseItemModel> guildBaseDoubleItemView6 = guildBaseDoubleItemView5;
                                                final SearchGuildBaseItemModel searchGuildBaseItemModel4 = searchGuildBaseItemModel3;
                                                final int i19 = i18;
                                                uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.double.GuildBaseDoubleItemView.createItemView.1.1.2.1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ClickParams clickParams) {
                                                        guildBaseDoubleItemView6.onClick(searchGuildBaseItemModel4);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        guildBaseDoubleItemView3.createItem(searchGuildBaseItemModel, f17, i3, vVar4);
                                        return Unit.INSTANCE;
                                    }
                                });
                                i3 = i16;
                            }
                        }
                        return Unit.INSTANCE;
                    }
                });
                return Unit.INSTANCE;
            }
        };
    }

    public abstract void createItem(SearchGuildBaseItemModel searchGuildBaseItemModel, float f16, int i3, ViewContainer viewContainer);

    /* JADX WARN: Multi-variable type inference failed */
    public final void onClick(SearchGuildBaseItemModel searchGuildBaseItemModel) {
        QSearchUtilKt.openGuildSubChannel(searchGuildBaseItemModel, ((GuildBaseDoubleAttr) getAttr()).traceId);
    }
}
