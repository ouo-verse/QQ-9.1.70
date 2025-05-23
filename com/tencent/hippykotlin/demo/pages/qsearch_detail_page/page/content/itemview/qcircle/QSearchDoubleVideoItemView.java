package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.qcircle;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.BridgeModule;
import com.tencent.hippykotlin.demo.pages.base.EcommerceExtKt;
import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt;
import com.tencent.hippykotlin.demo.pages.foundation.view.QQVideoView;
import com.tencent.hippykotlin.demo.pages.foundation.view.QQVideoView$getCurrentPositionMs$1;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.DoubleVideoItemModel;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.ISearchItemModel;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.StFeedEx;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.StUser;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.template.TemplateItemsKt;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.viewmodel.QSearchTabContentViewModel;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.util.ISearchReport;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.QSearchReportView;
import com.tencent.kuikly.core.base.AbstractBaseView;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.pager.b;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class QSearchDoubleVideoItemView extends QSearchReportView<QSearchDoubleVideoAttr, QSearchDoubleVideoEvent> {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(QSearchDoubleVideoItemView.class, "subPlayIndex", "getSubPlayIndex()I", 0)};
    public boolean hasFocus;
    public int lastSubPlayIndex;
    public final ReadWriteProperty subPlayIndex$delegate = c.a(-1);
    public DoubleVideoItemModel videoData;

    /* JADX WARN: Multi-variable type inference failed */
    public static final void access$dispatchFocusState(QSearchDoubleVideoItemView qSearchDoubleVideoItemView) {
        if (((QSearchDoubleVideoAttr) qSearchDoubleVideoItemView.getAttr()).getPlayIndex() == ((QSearchDoubleVideoAttr) qSearchDoubleVideoItemView.getAttr()).index) {
            if (qSearchDoubleVideoItemView.hasFocus) {
                return;
            }
            qSearchDoubleVideoItemView.hasFocus = true;
            qSearchDoubleVideoItemView.setSubPlayIndex(qSearchDoubleVideoItemView.lastSubPlayIndex);
            return;
        }
        if (qSearchDoubleVideoItemView.hasFocus) {
            qSearchDoubleVideoItemView.hasFocus = false;
            if (((QSearchDoubleVideoAttr) qSearchDoubleVideoItemView.getAttr()).getPlayIndex() == -2) {
                qSearchDoubleVideoItemView.lastSubPlayIndex = qSearchDoubleVideoItemView.getSubPlayIndex();
                qSearchDoubleVideoItemView.setSubPlayIndex(-2);
            } else {
                qSearchDoubleVideoItemView.lastSubPlayIndex = 0;
                qSearchDoubleVideoItemView.setSubPlayIndex(-1);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ QSearchDoubleVideoAttr access$getAttr(QSearchDoubleVideoItemView qSearchDoubleVideoItemView) {
        return (QSearchDoubleVideoAttr) qSearchDoubleVideoItemView.getAttr();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final e access$getReportParams(QSearchDoubleVideoItemView qSearchDoubleVideoItemView, StFeedEx stFeedEx) {
        String str;
        String str2;
        String eid;
        e baseReportParams = qSearchDoubleVideoItemView.getBaseReportParams();
        DoubleVideoItemModel doubleVideoItemModel = qSearchDoubleVideoItemView.videoData;
        String str3 = "em_search_xsj_feed_card";
        if (doubleVideoItemModel == null || (str = doubleVideoItemModel.getEid()) == null) {
            str = "em_search_xsj_feed_card";
        }
        baseReportParams.v("eid", str);
        baseReportParams.v("search_query_text", ((QSearchDoubleVideoAttr) qSearchDoubleVideoItemView.getAttr()).keyword);
        baseReportParams.v("search_trace_id", ((QSearchDoubleVideoAttr) qSearchDoubleVideoItemView.getAttr()).traceId);
        baseReportParams.v("xsj_feed_id", stFeedEx.stFeed.f114289id);
        StUser stUser = stFeedEx.stFeed.poster;
        if (stUser == null || (str2 = stUser.f114290id) == null) {
            str2 = "";
        }
        baseReportParams.v(QCircleDaTongConstant.ElementParamKey.XSJ_AUTHOR_UIN, str2);
        baseReportParams.v("xsj_custom_pgid", "pg_qq_network_search_result_level2_page");
        DoubleVideoItemModel doubleVideoItemModel2 = qSearchDoubleVideoItemView.videoData;
        if (doubleVideoItemModel2 != null && (eid = doubleVideoItemModel2.getEid()) != null) {
            str3 = eid;
        }
        baseReportParams.v("xsj_eid", str3);
        b pager = qSearchDoubleVideoItemView.getPager();
        ISearchReport iSearchReport = pager instanceof ISearchReport ? (ISearchReport) pager : null;
        if (iSearchReport != null) {
            baseReportParams.v("query_source", String.valueOf(iSearchReport.getQuerySource()));
            baseReportParams.v("user_source", String.valueOf(iSearchReport.getUserSource()));
            baseReportParams.v("net_search_session_id", iSearchReport.getSessionId());
        }
        return baseReportParams;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v7, types: [java.util.List<com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.StFeedEx>, java.util.ArrayList] */
    public static final void access$launchFeedDetail(QSearchDoubleVideoItemView qSearchDoubleVideoItemView, StFeedEx stFeedEx, long j3) {
        Map mutableMapOf;
        String p16 = qSearchDoubleVideoItemView.getPager().getPageData().n().p("page_name");
        ArrayList arrayList = new ArrayList();
        QSearchTabContentViewModel qSearchTabContentViewModel = ((QSearchDoubleVideoAttr) qSearchDoubleVideoItemView.getAttr()).viewModel;
        if (qSearchTabContentViewModel != null) {
            int size = qSearchTabContentViewModel.getDataList().size();
            for (int i3 = ((QSearchDoubleVideoAttr) qSearchDoubleVideoItemView.getAttr()).index; i3 < size && arrayList.size() < 5; i3++) {
                ISearchItemModel iSearchItemModel = qSearchTabContentViewModel.getDataList().get(i3);
                DoubleVideoItemModel doubleVideoItemModel = iSearchItemModel instanceof DoubleVideoItemModel ? (DoubleVideoItemModel) iSearchItemModel : null;
                if (doubleVideoItemModel != null) {
                    Iterator it = doubleVideoItemModel.dataList.iterator();
                    while (it.hasNext()) {
                        StFeedEx stFeedEx2 = (StFeedEx) it.next();
                        if (arrayList.size() >= 5) {
                            break;
                        } else if (!arrayList.isEmpty() || Intrinsics.areEqual(stFeedEx2, stFeedEx)) {
                            arrayList.add(stFeedEx2.feedPbToken);
                        }
                    }
                }
            }
        }
        BridgeModule bridgeModule = IPagerIdKtxKt.getBridgeModule(qSearchDoubleVideoItemView);
        String str = ((QSearchDoubleVideoAttr) qSearchDoubleVideoItemView.getAttr()).keyword;
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("tab_mask", Long.valueOf(((QSearchDoubleVideoAttr) qSearchDoubleVideoItemView.getAttr()).tabData.tabMask)));
        bridgeModule.openQQCirLayerPage(arrayList, j3, str, p16, mutableMapOf);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v7, types: [java.util.List<com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.StFeedEx>, java.util.ArrayList] */
    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        ?? r16;
        DoubleVideoItemModel doubleVideoItemModel = ((QSearchDoubleVideoAttr) getAttr()).data;
        if (!(doubleVideoItemModel instanceof DoubleVideoItemModel)) {
            doubleVideoItemModel = null;
        }
        this.videoData = doubleVideoItemModel;
        final float m3 = (getPagerData().m() - 24.0f) / 2;
        DoubleVideoItemModel doubleVideoItemModel2 = this.videoData;
        final int size = (doubleVideoItemModel2 == null || (r16 = doubleVideoItemModel2.dataList) == 0) ? 0 : r16.size();
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.qcircle.QSearchDoubleVideoItemView$body$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                final int i3 = size;
                final QSearchDoubleVideoItemView qSearchDoubleVideoItemView = this;
                final float f16 = m3;
                w.a(viewContainer, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.qcircle.QSearchDoubleVideoItemView$body$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.qcircle.QSearchDoubleVideoItemView.body.1.1.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.padding(8.0f, 8.0f, 0.0f, 0.0f);
                                tVar2.flexDirectionRow();
                                return Unit.INSTANCE;
                            }
                        });
                        final int i16 = i3;
                        Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.qcircle.QSearchDoubleVideoItemView.body.1.1.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Boolean.valueOf(i16 > 0);
                            }
                        };
                        final QSearchDoubleVideoItemView qSearchDoubleVideoItemView2 = qSearchDoubleVideoItemView;
                        final float f17 = f16;
                        ConditionViewKt.c(vVar2, function0, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.qcircle.QSearchDoubleVideoItemView.body.1.1.3
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            /* JADX WARN: Type inference failed for: r0v2, types: [java.util.List<com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.StFeedEx>, java.util.ArrayList] */
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ConditionView conditionView) {
                                ConditionView conditionView2 = conditionView;
                                DoubleVideoItemModel doubleVideoItemModel3 = QSearchDoubleVideoItemView.this.videoData;
                                Intrinsics.checkNotNull(doubleVideoItemModel3);
                                ?? r06 = doubleVideoItemModel3.dataList;
                                final QSearchDoubleVideoItemView qSearchDoubleVideoItemView3 = QSearchDoubleVideoItemView.this;
                                final float f18 = f17;
                                Iterator it = r06.iterator();
                                final int i17 = 0;
                                while (it.hasNext()) {
                                    Object next = it.next();
                                    int i18 = i17 + 1;
                                    if (i17 < 0) {
                                        CollectionsKt__CollectionsKt.throwIndexOverflow();
                                    }
                                    final StFeedEx stFeedEx = (StFeedEx) next;
                                    qSearchDoubleVideoItemView3.getClass();
                                    conditionView2.addChild(new SingleVideoItemView(), new Function1<SingleVideoItemView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.qcircle.QSearchDoubleVideoItemView$createSingleItemView$1$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(SingleVideoItemView singleVideoItemView) {
                                            SingleVideoItemView singleVideoItemView2 = singleVideoItemView;
                                            final QSearchDoubleVideoItemView qSearchDoubleVideoItemView4 = QSearchDoubleVideoItemView.this;
                                            final int i19 = i17;
                                            final StFeedEx stFeedEx2 = stFeedEx;
                                            final float f19 = f18;
                                            singleVideoItemView2.attr(new Function1<SingleVideoItemAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.qcircle.QSearchDoubleVideoItemView$createSingleItemView$1$1.1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(SingleVideoItemAttr singleVideoItemAttr) {
                                                    String str;
                                                    String str2;
                                                    SingleVideoItemAttr singleVideoItemAttr2 = singleVideoItemAttr;
                                                    QSearchDoubleVideoAttr access$getAttr = QSearchDoubleVideoItemView.access$getAttr(QSearchDoubleVideoItemView.this);
                                                    boolean booleanValue = ((Boolean) access$getAttr.muted$delegate.getValue(access$getAttr, QSearchDoubleVideoAttr.$$delegatedProperties[1])).booleanValue();
                                                    ReadWriteProperty readWriteProperty = singleVideoItemAttr2.muted$delegate;
                                                    KProperty<?>[] kPropertyArr = SingleVideoItemAttr.$$delegatedProperties;
                                                    readWriteProperty.setValue(singleVideoItemAttr2, kPropertyArr[0], Boolean.valueOf(booleanValue));
                                                    singleVideoItemAttr2.index = i19;
                                                    singleVideoItemAttr2.playIndex$delegate.setValue(singleVideoItemAttr2, kPropertyArr[1], Integer.valueOf(QSearchDoubleVideoItemView.this.getSubPlayIndex()));
                                                    singleVideoItemAttr2.stFeedEx = stFeedEx2;
                                                    singleVideoItemAttr2.highlightWord = QSearchDoubleVideoItemView.access$getAttr(QSearchDoubleVideoItemView.this).keyword;
                                                    singleVideoItemAttr2.marginLeft(i19 == 0 ? 0.0f : 8.0f);
                                                    singleVideoItemAttr2.mo153width(f19);
                                                    e access$getReportParams = QSearchDoubleVideoItemView.access$getReportParams(QSearchDoubleVideoItemView.this, stFeedEx2);
                                                    QSearchDoubleVideoItemView qSearchDoubleVideoItemView5 = QSearchDoubleVideoItemView.this;
                                                    int i26 = i19;
                                                    DoubleVideoItemModel doubleVideoItemModel4 = qSearchDoubleVideoItemView5.videoData;
                                                    if (doubleVideoItemModel4 != null) {
                                                        str = doubleVideoItemModel4.getReportInfo();
                                                    } else {
                                                        str = "";
                                                    }
                                                    e mergeTransferInfo = TemplateItemsKt.mergeTransferInfo(str, access$getReportParams);
                                                    if (mergeTransferInfo != null) {
                                                        mergeTransferInfo.t("doc_position", i26);
                                                    }
                                                    if (mergeTransferInfo != null) {
                                                        DoubleVideoItemModel doubleVideoItemModel5 = QSearchDoubleVideoItemView.access$getAttr(qSearchDoubleVideoItemView5).data;
                                                        mergeTransferInfo.t("serial_number", doubleVideoItemModel5 != null ? doubleVideoItemModel5.serialNumber : -1);
                                                    }
                                                    access$getReportParams.v("transfer_info", mergeTransferInfo);
                                                    singleVideoItemAttr2.reportParams = access$getReportParams;
                                                    DoubleVideoItemModel doubleVideoItemModel6 = QSearchDoubleVideoItemView.this.videoData;
                                                    if (doubleVideoItemModel6 == null || (str2 = doubleVideoItemModel6.getEid()) == null) {
                                                        str2 = "em_search_xsj_feed_card";
                                                    }
                                                    EcommerceExtKt.vr$default(singleVideoItemAttr2, null, str2, singleVideoItemAttr2.reportParams, null, String.valueOf(stFeedEx2.hashCode()), true, 9);
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            final QSearchDoubleVideoItemView qSearchDoubleVideoItemView5 = QSearchDoubleVideoItemView.this;
                                            final int i26 = i17;
                                            final StFeedEx stFeedEx3 = stFeedEx;
                                            singleVideoItemView2.event(new Function1<SingleVideoItemEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.qcircle.QSearchDoubleVideoItemView$createSingleItemView$1$1.2

                                                /* compiled from: P */
                                                /* renamed from: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.qcircle.QSearchDoubleVideoItemView$createSingleItemView$1$1$2$1, reason: invalid class name */
                                                /* loaded from: classes32.dex */
                                                public final class AnonymousClass1 extends Lambda implements Function0<Unit> {
                                                    public final /* synthetic */ QSearchDoubleVideoItemView $ctx;

                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    public AnonymousClass1(QSearchDoubleVideoItemView qSearchDoubleVideoItemView) {
                                                        super(0);
                                                        this.$ctx = qSearchDoubleVideoItemView;
                                                    }

                                                    @Override // kotlin.jvm.functions.Function0
                                                    public final Unit invoke() {
                                                        QSearchDoubleVideoItemView qSearchDoubleVideoItemView = this.$ctx;
                                                        KProperty<Object>[] kPropertyArr = QSearchDoubleVideoItemView.$$delegatedProperties;
                                                        qSearchDoubleVideoItemView.setSubPlayIndex(qSearchDoubleVideoItemView.getSubPlayIndex() + 1);
                                                        qSearchDoubleVideoItemView.setSubPlayIndex(qSearchDoubleVideoItemView.getSubPlayIndex() % 2);
                                                        return Unit.INSTANCE;
                                                    }
                                                }

                                                /* compiled from: P */
                                                /* renamed from: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.qcircle.QSearchDoubleVideoItemView$createSingleItemView$1$1$2$2, reason: invalid class name and collision with other inner class name */
                                                /* loaded from: classes32.dex */
                                                public final class C49062 extends Lambda implements Function1<QQVideoView, Unit> {
                                                    public final /* synthetic */ QSearchDoubleVideoItemView $ctx;
                                                    public final /* synthetic */ int $subIndex;
                                                    public final /* synthetic */ StFeedEx $videoData;

                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    public C49062(int i3, QSearchDoubleVideoItemView qSearchDoubleVideoItemView, StFeedEx stFeedEx) {
                                                        super(1);
                                                        this.$subIndex = i3;
                                                        this.$ctx = qSearchDoubleVideoItemView;
                                                        this.$videoData = stFeedEx;
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(QQVideoView qQVideoView) {
                                                        QQVideoView qQVideoView2 = qQVideoView;
                                                        if (qQVideoView2 != null) {
                                                            int i3 = this.$subIndex;
                                                            QSearchDoubleVideoItemView qSearchDoubleVideoItemView = this.$ctx;
                                                            KProperty<Object>[] kPropertyArr = QSearchDoubleVideoItemView.$$delegatedProperties;
                                                            if (i3 == qSearchDoubleVideoItemView.getSubPlayIndex()) {
                                                                final QSearchDoubleVideoItemView qSearchDoubleVideoItemView2 = this.$ctx;
                                                                final StFeedEx stFeedEx = this.$videoData;
                                                                AbstractBaseView.callRenderViewMethod$default(qQVideoView2, "getCurrentPositionMs", null, new QQVideoView$getCurrentPositionMs$1(new Function1<Long, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.qcircle.QSearchDoubleVideoItemView.createSingleItemView.1.1.2.2.1
                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(Long l3) {
                                                                        QSearchDoubleVideoItemView.access$launchFeedDetail(QSearchDoubleVideoItemView.this, stFeedEx, l3.longValue());
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                }), 2, null);
                                                            } else {
                                                                QSearchDoubleVideoItemView.access$launchFeedDetail(this.$ctx, this.$videoData, 0L);
                                                            }
                                                        } else {
                                                            QSearchDoubleVideoItemView.access$launchFeedDetail(this.$ctx, this.$videoData, 0L);
                                                        }
                                                        return Unit.INSTANCE;
                                                    }
                                                }

                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(SingleVideoItemEvent singleVideoItemEvent) {
                                                    SingleVideoItemEvent singleVideoItemEvent2 = singleVideoItemEvent;
                                                    singleVideoItemEvent2.onVideoEnd = new AnonymousClass1(QSearchDoubleVideoItemView.this);
                                                    singleVideoItemEvent2.onVideoClick = new C49062(i26, QSearchDoubleVideoItemView.this, stFeedEx3);
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    i17 = i18;
                                }
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
        return new QSearchDoubleVideoAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new QSearchDoubleVideoEvent();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView, com.tencent.kuikly.core.base.AbstractBaseView
    public final void didInit() {
        super.didInit();
        bindValueChange(new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.qcircle.QSearchDoubleVideoItemView$didInit$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Integer.valueOf(QSearchDoubleVideoItemView.access$getAttr(QSearchDoubleVideoItemView.this).getPlayIndex());
            }
        }, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.qcircle.QSearchDoubleVideoItemView$didInit$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Object obj) {
                QSearchDoubleVideoItemView.access$dispatchFocusState(QSearchDoubleVideoItemView.this);
                return Unit.INSTANCE;
            }
        });
    }

    public final int getSubPlayIndex() {
        return ((Number) this.subPlayIndex$delegate.getValue(this, $$delegatedProperties[0])).intValue();
    }

    public final void setSubPlayIndex(int i3) {
        this.subPlayIndex$delegate.setValue(this, $$delegatedProperties[0], Integer.valueOf(i3));
    }
}
