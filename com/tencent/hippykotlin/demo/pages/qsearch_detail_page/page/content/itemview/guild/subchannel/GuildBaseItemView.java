package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel;

import com.tencent.hippykotlin.demo.pages.base.EcommerceExtKt;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.GuildItemInfo;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.guild.SearchGuildBaseItemModel;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.template.TemplateItemsKt;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.GuildBaseAttr;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.GuildBaseEvent;
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
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
/* loaded from: classes32.dex */
public abstract class GuildBaseItemView<Attr extends GuildBaseAttr, Event extends GuildBaseEvent, Model extends SearchGuildBaseItemModel> extends QSearchReportView<Attr, Event> {
    public static final /* synthetic */ int $r8$clinit = 0;

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ GuildBaseAttr access$getAttr(GuildBaseItemView guildBaseItemView) {
        return (GuildBaseAttr) guildBaseItemView.getAttr();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        final float m3 = getPagerData().m() - 16.0f;
        final Model data = getData();
        if (data == null) {
            return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.GuildBaseItemView$body$data$1
                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(ViewContainer<?, ?> viewContainer) {
                    return Unit.INSTANCE;
                }
            };
        }
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.GuildBaseItemView$body$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Incorrect types in method signature: (Lcom/tencent/hippykotlin/demo/pages/qsearch_detail_page/page/content/itemview/guild/subchannel/GuildBaseItemView<TAttr;TEvent;TModel;>;TModel;F)V */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.GuildBaseItemView$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        mVar2.m140flex(1.0f);
                        mVar2.padding(8.0f, 8.0f, 0.0f, 0.0f);
                        return Unit.INSTANCE;
                    }
                });
                final GuildBaseItemView<Attr, Event, Model> guildBaseItemView = GuildBaseItemView.this;
                viewContainer2.addChild(new GuildGroupTitleView(), new Function1<GuildGroupTitleView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.GuildBaseItemView$body$1.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(GuildGroupTitleView guildGroupTitleView) {
                        final GuildBaseItemView<GuildBaseAttr, GuildBaseEvent, SearchGuildBaseItemModel> guildBaseItemView2 = guildBaseItemView;
                        guildGroupTitleView.attr(new Function1<GuildGroupTitleAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.GuildBaseItemView.body.1.2.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(GuildGroupTitleAttr guildGroupTitleAttr) {
                                guildGroupTitleAttr.title = GuildBaseItemView.access$getAttr(guildBaseItemView2).title;
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final GuildBaseItemView<Attr, Event, Model> guildBaseItemView2 = GuildBaseItemView.this;
                final SearchGuildBaseItemModel searchGuildBaseItemModel = data;
                final float f16 = m3;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.GuildBaseItemView$body$1.3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.GuildBaseItemView.body.1.3.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.m140flex(1.0f);
                                tVar2.flexDirectionRow();
                                return Unit.INSTANCE;
                            }
                        });
                        final SearchGuildBaseItemModel searchGuildBaseItemModel2 = searchGuildBaseItemModel;
                        final GuildBaseItemView<GuildBaseAttr, GuildBaseEvent, SearchGuildBaseItemModel> guildBaseItemView3 = guildBaseItemView2;
                        vVar2.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.GuildBaseItemView.body.1.3.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(u uVar) {
                                final SearchGuildBaseItemModel searchGuildBaseItemModel3 = SearchGuildBaseItemModel.this;
                                final GuildBaseItemView<GuildBaseAttr, GuildBaseEvent, SearchGuildBaseItemModel> guildBaseItemView4 = guildBaseItemView3;
                                uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.GuildBaseItemView.body.1.3.2.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ClickParams clickParams) {
                                        QSearchUtilKt.openGuildSubChannel(SearchGuildBaseItemModel.this, GuildBaseItemView.access$getAttr(guildBaseItemView4).traceId);
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final GuildBaseItemView<GuildBaseAttr, GuildBaseEvent, SearchGuildBaseItemModel> guildBaseItemView4 = guildBaseItemView2;
                        final SearchGuildBaseItemModel searchGuildBaseItemModel3 = searchGuildBaseItemModel;
                        final float f17 = f16;
                        int i3 = GuildBaseItemView.$r8$clinit;
                        guildBaseItemView4.getClass();
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.GuildBaseItemView$createItemView$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                v vVar4 = vVar3;
                                final float f18 = f17;
                                final GuildBaseItemView<GuildBaseAttr, GuildBaseEvent, SearchGuildBaseItemModel> guildBaseItemView5 = guildBaseItemView4;
                                final SearchGuildBaseItemModel searchGuildBaseItemModel4 = searchGuildBaseItemModel3;
                                vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.GuildBaseItemView$createItemView$1$1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.mo153width(f18);
                                        tVar2.mo141height(170.0f);
                                        tVar2.borderRadius(8.0f);
                                        e reportParams = guildBaseItemView5.getReportParams(searchGuildBaseItemModel4);
                                        String eid = searchGuildBaseItemModel4.getEid();
                                        if (eid == null) {
                                            eid = "em_search_channel_result_card";
                                        }
                                        EcommerceExtKt.vr$default(tVar2, null, eid, reportParams, null, String.valueOf(searchGuildBaseItemModel4.hashCode()), true, 9);
                                        return Unit.INSTANCE;
                                    }
                                });
                                guildBaseItemView4.createItem(searchGuildBaseItemModel3, f17, vVar4);
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

    public abstract void createItem(SearchGuildBaseItemModel searchGuildBaseItemModel, float f16, ViewContainer viewContainer);

    public abstract Model getData();

    /* JADX WARN: Multi-variable type inference failed */
    public final e getReportParams(Model model) {
        e baseReportParams = getBaseReportParams();
        GuildBaseAttr guildBaseAttr = (GuildBaseAttr) getAttr();
        baseReportParams.v("search_query_text", (String) guildBaseAttr.keyword$delegate.getValue(guildBaseAttr, GuildBaseAttr.$$delegatedProperties[1]));
        baseReportParams.v("search_trace_id", ((GuildBaseAttr) getAttr()).traceId);
        baseReportParams.v("online_member_count", model.getAudienceCount());
        baseReportParams.v(QCircleDaTongConstant.ElementParamKey.SGRP_CHANNEL_NAME, model.getChannelName());
        baseReportParams.v("search_card_type", "1");
        baseReportParams.t("sgrp_content_card_type", model.getType());
        baseReportParams.t("search_index", model.reportIndex + 1);
        baseReportParams.t("search_result_num", model.resultNumber);
        GuildItemInfo guildItemInfo = model.originData;
        baseReportParams.u("sgrp_channel_id", guildItemInfo != null ? guildItemInfo.guildId : 0L);
        GuildItemInfo guildItemInfo2 = model.originData;
        baseReportParams.u("sgrp_sub_channel_id", guildItemInfo2 != null ? guildItemInfo2.channelId : 0L);
        GuildItemInfo guildItemInfo3 = model.originData;
        baseReportParams.u("founder_uin", guildItemInfo3 != null ? guildItemInfo3.guildOwner : 0L);
        GuildItemInfo guildItemInfo4 = model.originData;
        baseReportParams.u("sgrp_stream_id", guildItemInfo4 != null ? guildItemInfo4.roomId : 0L);
        b pager = getPager();
        ISearchReport iSearchReport = pager instanceof ISearchReport ? (ISearchReport) pager : null;
        if (iSearchReport != null) {
            baseReportParams.v("query_source", String.valueOf(iSearchReport.getQuerySource()));
            baseReportParams.v("user_source", String.valueOf(iSearchReport.getUserSource()));
            baseReportParams.v("net_search_session_id", iSearchReport.getSessionId());
        }
        e mergeTransferInfo = TemplateItemsKt.mergeTransferInfo(model.getReportInfo(), baseReportParams);
        if (mergeTransferInfo != null) {
            mergeTransferInfo.t("serial_number", model.serialNumber);
        }
        baseReportParams.v("transfer_info", mergeTransferInfo);
        return baseReportParams;
    }
}
