package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template;

import com.tencent.hippykotlin.demo.pages.base.EcommerceExtKt;
import com.tencent.hippykotlin.demo.pages.base.QUISkinColor;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.QSearchJump;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.template.QSearchBaseTemplateModel;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.template.QSearchButtonInfo;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.template.QSearchMultiImageVideoTemplateModel;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.template.QSearchTemplateLayoutInfo;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.template.QSearchTemplateReportInfo;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchBaseTemplateAttr;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchBaseTemplateEvent;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.util.ISearchReport;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.util.QSearchUtilKt;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.QSearchReportView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.a;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.pager.b;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.u;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.text.Regex;

/* compiled from: P */
/* loaded from: classes32.dex */
public abstract class QSearchBaseTemplateView<M extends QSearchBaseTemplateModel, A extends QSearchBaseTemplateAttr<M>, E extends QSearchBaseTemplateEvent> extends QSearchReportView<A, E> {
    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ QSearchBaseTemplateAttr access$getAttr(QSearchBaseTemplateView qSearchBaseTemplateView) {
        return (QSearchBaseTemplateAttr) qSearchBaseTemplateView.getAttr();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        final QSearchTemplateLayoutInfo qSearchTemplateLayoutInfo = ((QSearchBaseTemplateAttr) getAttr()).getData().layoutInfo;
        final float f16 = qSearchTemplateLayoutInfo.marginTop;
        final float f17 = qSearchTemplateLayoutInfo.topCorner;
        final float f18 = qSearchTemplateLayoutInfo.bottomCorner;
        return new Function1<ViewContainer<?, ?>, Unit>(this) { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchBaseTemplateView$body$1
            public final /* synthetic */ QSearchBaseTemplateView<M, A, E> $ctx;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$ctx = this;
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                this.$ctx.buildOverlay().invoke(viewContainer2);
                final QSearchBaseTemplateView<M, A, E> qSearchBaseTemplateView = this.$ctx;
                final float f19 = f16;
                final QSearchTemplateLayoutInfo qSearchTemplateLayoutInfo2 = qSearchTemplateLayoutInfo;
                final float f26 = f17;
                final float f27 = f18;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchBaseTemplateView$body$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        final float f28 = f19;
                        final QSearchBaseTemplateView<QSearchBaseTemplateModel, QSearchBaseTemplateAttr<Object>, QSearchBaseTemplateEvent> qSearchBaseTemplateView2 = qSearchBaseTemplateView;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchBaseTemplateView.body.1.1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                QSearchTemplateReportInfo qSearchTemplateReportInfo;
                                t tVar2 = tVar;
                                a.C5863a.a(tVar2, f28, 8.0f, 0.0f, 8.0f, 4, null);
                                QSearchBaseTemplateView<QSearchBaseTemplateModel, QSearchBaseTemplateAttr<Object>, QSearchBaseTemplateEvent> qSearchBaseTemplateView3 = qSearchBaseTemplateView2;
                                qSearchBaseTemplateView3.getClass();
                                if (!(qSearchBaseTemplateView3 instanceof QSearchBannerTemplateView) && (qSearchTemplateReportInfo = QSearchBaseTemplateView.access$getAttr(qSearchBaseTemplateView2).getData().reportInfo) != null) {
                                    EcommerceExtKt.vr$default(tVar2, null, qSearchTemplateReportInfo.eid, qSearchTemplateReportInfo.getReportParams(qSearchBaseTemplateView2.getReportParams()), null, String.valueOf(qSearchTemplateReportInfo.hashCode()), true, 9);
                                }
                                return Unit.INSTANCE;
                            }
                        });
                        final QSearchJump qSearchJump = QSearchBaseTemplateView.access$getAttr(qSearchBaseTemplateView).getData().jumpLink;
                        if (qSearchJump != null) {
                            final QSearchBaseTemplateView<QSearchBaseTemplateModel, QSearchBaseTemplateAttr<Object>, QSearchBaseTemplateEvent> qSearchBaseTemplateView3 = qSearchBaseTemplateView;
                            vVar2.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchBaseTemplateView$body$1$1$2$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(u uVar) {
                                    final QSearchBaseTemplateView<QSearchBaseTemplateModel, QSearchBaseTemplateAttr<Object>, QSearchBaseTemplateEvent> qSearchBaseTemplateView4 = qSearchBaseTemplateView3;
                                    final QSearchJump qSearchJump2 = qSearchJump;
                                    uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchBaseTemplateView$body$1$1$2$1.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(ClickParams clickParams) {
                                            QSearchBaseTemplateView<QSearchBaseTemplateModel, QSearchBaseTemplateAttr<Object>, QSearchBaseTemplateEvent> qSearchBaseTemplateView5 = qSearchBaseTemplateView4;
                                            qSearchBaseTemplateView5.doJump(qSearchJump2, QSearchBaseTemplateView.access$getAttr(qSearchBaseTemplateView5).getData().extensionMap);
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    return Unit.INSTANCE;
                                }
                            });
                        }
                        final QSearchBaseTemplateView<QSearchBaseTemplateModel, QSearchBaseTemplateAttr<Object>, QSearchBaseTemplateEvent> qSearchBaseTemplateView4 = qSearchBaseTemplateView;
                        final QSearchTemplateLayoutInfo qSearchTemplateLayoutInfo3 = qSearchTemplateLayoutInfo2;
                        final float f29 = f26;
                        final float f36 = f27;
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchBaseTemplateView.body.1.1.3
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                v vVar4 = vVar3;
                                final QSearchBaseTemplateView<QSearchBaseTemplateModel, QSearchBaseTemplateAttr<Object>, QSearchBaseTemplateEvent> qSearchBaseTemplateView5 = qSearchBaseTemplateView4;
                                final QSearchTemplateLayoutInfo qSearchTemplateLayoutInfo4 = qSearchTemplateLayoutInfo3;
                                final float f37 = f29;
                                final float f38 = f36;
                                vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchBaseTemplateView.body.1.1.3.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        a.C5863a.a(tVar2, 0.0f, qSearchBaseTemplateView5.getPaddingHorizontal(), 0.0f, qSearchBaseTemplateView5.getPaddingHorizontal(), 5, null);
                                        tVar2.mo113backgroundColor(QUISkinColor.INSTANCE.wrapColor("fill_light_secondary"));
                                        if (qSearchTemplateLayoutInfo4.useWholeCard) {
                                            float f39 = QSearchBaseTemplateView.access$getAttr(qSearchBaseTemplateView5).isFirstItem ? 8.0f : 0.0f;
                                            QSearchBaseTemplateAttr access$getAttr = QSearchBaseTemplateView.access$getAttr(qSearchBaseTemplateView5);
                                            float f46 = ((Boolean) access$getAttr.isLastItem$delegate.getValue(access$getAttr, QSearchBaseTemplateAttr.$$delegatedProperties[2])).booleanValue() ? 8.0f : 0.0f;
                                            tVar2.borderRadius(f39, f39, f46, f46);
                                        } else {
                                            float f47 = f37;
                                            float f48 = f38;
                                            tVar2.borderRadius(f47, f47, f48, f48);
                                        }
                                        return Unit.INSTANCE;
                                    }
                                });
                                qSearchBaseTemplateView4.buildContent().invoke(vVar4);
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

    public abstract Function1<ViewContainer<?, ?>, Unit> buildContent();

    public Function1<ViewContainer<?, ?>, Unit> buildOverlay() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchBaseTemplateView$buildOverlay$1
            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(ViewContainer<?, ?> viewContainer) {
                return Unit.INSTANCE;
            }
        };
    }

    public final void clickButton(QSearchButtonInfo qSearchButtonInfo) {
        doJump(qSearchButtonInfo.jumpInfo, qSearchButtonInfo.extensionMap);
    }

    public float getPaddingHorizontal() {
        return 16.0f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public e getReportParams() {
        e baseReportParams = getBaseReportParams();
        baseReportParams.v("search_query_text", ((QSearchBaseTemplateAttr) getAttr()).keyword);
        baseReportParams.v("search_trace_id", ((QSearchBaseTemplateAttr) getAttr()).traceId);
        baseReportParams.t("serial_number", ((QSearchBaseTemplateAttr) getAttr()).index + 1);
        b pager = getPager();
        ISearchReport iSearchReport = pager instanceof ISearchReport ? (ISearchReport) pager : null;
        if (iSearchReport != null) {
            baseReportParams.v("query_source", String.valueOf(iSearchReport.getQuerySource()));
            baseReportParams.v("user_source", String.valueOf(iSearchReport.getUserSource()));
        }
        return baseReportParams;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final e getTemplateCardReportInfo() {
        e reportParams;
        QSearchTemplateReportInfo qSearchTemplateReportInfo = ((QSearchBaseTemplateAttr) getAttr()).getData().reportInfo;
        return (qSearchTemplateReportInfo == null || (reportParams = qSearchTemplateReportInfo.getReportParams(getReportParams())) == null) ? getReportParams() : reportParams;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:21:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00a6  */
    /* JADX WARN: Type inference failed for: r10v10, types: [java.util.Map] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void doJump(QSearchJump qSearchJump, Map<String, String> map) {
        LinkedHashMap linkedHashMap;
        String str;
        LinkedHashMap linkedHashMap2;
        boolean z16;
        ?? mutableMap;
        LinkedHashMap linkedHashMap3 = null;
        if (map != null) {
            mutableMap = MapsKt__MapsKt.toMutableMap(map);
            linkedHashMap = mutableMap;
        } else {
            linkedHashMap = null;
        }
        Integer valueOf = qSearchJump != null ? Integer.valueOf(qSearchJump.type) : null;
        if (valueOf != null && valueOf.intValue() == 11) {
            linkedHashMap3 = new LinkedHashMap();
            e eVar = new e();
            eVar.v("search_query_text", ((QSearchBaseTemplateAttr) getAttr()).keyword);
            eVar.v("trace_id", ((QSearchBaseTemplateAttr) getAttr()).traceId);
            eVar.t("jump_type", 1);
            linkedHashMap3.put("open_group_detail_transInfo", eVar.toString());
            getPager().getPageData().getIsAndroid();
            String str2 = ((QSearchBaseTemplateAttr) getAttr()).keyword;
            if (new Regex("\\d+").matches(str2)) {
                int length = str2.length();
                if (6 <= length && length < 10) {
                    z16 = true;
                    r2 = ((QSearchBaseTemplateAttr) getAttr()).tabData.tabMask == 6;
                    linkedHashMap3.put("subSourceId", String.valueOf(!z16 ? r2 ? 1020 : 1019 : r2 ? 1022 : 1021));
                }
            }
            z16 = false;
            if (((QSearchBaseTemplateAttr) getAttr()).tabData.tabMask == 6) {
            }
            linkedHashMap3.put("subSourceId", String.valueOf(!z16 ? r2 ? 1020 : 1019 : r2 ? 1022 : 1021));
        } else if (valueOf != null && valueOf.intValue() == 2) {
            linkedHashMap3 = new LinkedHashMap();
            boolean z17 = ((QSearchBaseTemplateAttr) getAttr()).tabData.tabMask == 3;
            String str3 = ((QSearchBaseTemplateAttr) getAttr()).keyword;
            if (new Regex("^(?=.*[A-Za-z])\\S{5,14}$").matches(str3)) {
                int length2 = str3.length();
                if (5 <= length2 && length2 < 14) {
                    r2 = true;
                }
            }
            boolean z18 = ((QSearchBaseTemplateAttr) getAttr()).getData() instanceof QSearchMultiImageVideoTemplateModel;
            if (z17) {
                if (r2) {
                    if (z18) {
                        str = "qq_network_search_post_sub_tab_searchid";
                    } else {
                        str = "qq_network_search_channel_sub_tab_searchid";
                    }
                } else if (z18) {
                    str = "qq_network_search_post_sub_tab_keyword";
                } else {
                    str = "qq_network_search_channel_sub_tab_keyword";
                }
            } else if (r2) {
                if (z18) {
                    str = "qq_network_search_post_all_tab_searchid";
                } else {
                    str = "qq_network_search_channel_all_tab_searchid";
                }
            } else if (z18) {
                str = "qq_network_search_post_all_tab_keyword";
            } else {
                str = "qq_network_search_channel_all_tab_keyword";
            }
            linkedHashMap3.put("guild_sub_source", str);
        }
        if (linkedHashMap3 != null) {
            if (linkedHashMap != null) {
                linkedHashMap.putAll(linkedHashMap3);
            } else {
                linkedHashMap2 = linkedHashMap3;
                QSearchUtilKt.allInOneJump(qSearchJump, getPager(), ((QSearchBaseTemplateAttr) getAttr()).keyword, ((QSearchBaseTemplateAttr) getAttr()).traceId, ((QSearchBaseTemplateAttr) getAttr()).tabData.tabMask, linkedHashMap2);
            }
        }
        linkedHashMap2 = linkedHashMap;
        QSearchUtilKt.allInOneJump(qSearchJump, getPager(), ((QSearchBaseTemplateAttr) getAttr()).keyword, ((QSearchBaseTemplateAttr) getAttr()).traceId, ((QSearchBaseTemplateAttr) getAttr()).tabData.tabMask, linkedHashMap2);
    }
}
