package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.sugword;

import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.create.AdelieAudioRecordManager$endRecord$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.BridgeModule;
import com.tencent.hippykotlin.demo.pages.base.NetworkUtils;
import com.tencent.hippykotlin.demo.pages.base.NetworkUtils$requestWithCmd$7;
import com.tencent.hippykotlin.demo.pages.base.QUISkinColor;
import com.tencent.hippykotlin.demo.pages.base.RefreshListState;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.foundation.module.OIDBResponse;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.SubPageName;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.UnifySearchNetSugInfo;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.UnifySearchNetSugWordsRsp;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.UnifySearchTabInfo;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.QSearchDetailBaseSubPage;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.repo.SearchReqGetSugWords;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.sugword.item.QSearchSugWordsItemAttr;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.sugword.item.QSearchSugWordsItemEvent;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.sugword.item.QSearchSugWordsItemView;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.sugword.repo.NetSugWordsRspWrapper;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.sugword.repo.QSearchNetSugWordsRepo;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.util.QSearchReportKt;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.util.QSearchUtilKt;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.util.SearchNetApi;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.util.SearchNetApi$sendOidbPbRequest$1;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.reactive.collection.c;
import com.tencent.kuikly.core.views.ScrollParams;
import com.tencent.kuikly.core.views.ao;
import com.tencent.kuikly.core.views.ap;
import com.tencent.kuikly.core.views.aq;
import com.tencent.kuikly.core.views.ar;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import com.tencent.mobileqq.transfile.filebrowser.MimeTypeParser;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kuikly.com.tencent.trpcprotocol.search.unifysearch.l;
import kuikly.com.tencent.trpcprotocol.search.unifysearch.n;

/* loaded from: classes32.dex */
public final class QSearchSugWordsSubPageView extends QSearchDetailBaseSubPage<QSearchSugWordsContentAttr, QSearchSugWordsContentEvent> {
    public QSearchSugWordsViewModel sugWordsViewModel;

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ QSearchSugWordsContentAttr access$getAttr(QSearchSugWordsSubPageView qSearchSugWordsSubPageView) {
        return (QSearchSugWordsContentAttr) qSearchSugWordsSubPageView.getAttr();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.sugword.QSearchSugWordsSubPageView$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                final QSearchSugWordsSubPageView qSearchSugWordsSubPageView = QSearchSugWordsSubPageView.this;
                w.a(viewContainer, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.sugword.QSearchSugWordsSubPageView$body$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        final QSearchSugWordsSubPageView qSearchSugWordsSubPageView2 = QSearchSugWordsSubPageView.this;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.sugword.QSearchSugWordsSubPageView.body.1.1.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                if (!QSearchSugWordsSubPageView.access$getAttr(QSearchSugWordsSubPageView.this).getViewModel().isVasTheme()) {
                                    tVar2.mo113backgroundColor(QUISkinColor.INSTANCE.wrapColor("bg_bottom_light"));
                                }
                                tVar2.m140flex(1.0f);
                                return Unit.INSTANCE;
                            }
                        });
                        final QSearchSugWordsSubPageView qSearchSugWordsSubPageView3 = QSearchSugWordsSubPageView.this;
                        Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.sugword.QSearchSugWordsSubPageView.body.1.1.2
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                QSearchSugWordsViewModel qSearchSugWordsViewModel = QSearchSugWordsSubPageView.this.sugWordsViewModel;
                                if (qSearchSugWordsViewModel == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("sugWordsViewModel");
                                    qSearchSugWordsViewModel = null;
                                }
                                return Boolean.valueOf(qSearchSugWordsViewModel.getDataList().size() > 0);
                            }
                        };
                        final QSearchSugWordsSubPageView qSearchSugWordsSubPageView4 = QSearchSugWordsSubPageView.this;
                        ConditionViewKt.c(vVar2, function0, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.sugword.QSearchSugWordsSubPageView.body.1.1.3
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ConditionView conditionView) {
                                final QSearchSugWordsSubPageView qSearchSugWordsSubPageView5 = QSearchSugWordsSubPageView.this;
                                ar.a(conditionView, new Function1<aq<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.sugword.QSearchSugWordsSubPageView.body.1.1.3.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(aq<?, ?> aqVar) {
                                        aq<?, ?> aqVar2 = aqVar;
                                        aqVar2.attr(new Function1<ao, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.sugword.QSearchSugWordsSubPageView.body.1.1.3.1.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ao aoVar) {
                                                ao aoVar2 = aoVar;
                                                aoVar2.m140flex(1.0f);
                                                aoVar2.showScrollerIndicator(false);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        QSearchSugWordsViewModel qSearchSugWordsViewModel = QSearchSugWordsSubPageView.this.sugWordsViewModel;
                                        if (qSearchSugWordsViewModel == null) {
                                            Intrinsics.throwUninitializedPropertyAccessException("sugWordsViewModel");
                                            qSearchSugWordsViewModel = null;
                                        }
                                        c<l> dataList = qSearchSugWordsViewModel.getDataList();
                                        final QSearchSugWordsSubPageView qSearchSugWordsSubPageView6 = QSearchSugWordsSubPageView.this;
                                        Iterator<l> it = dataList.iterator();
                                        final int i3 = 0;
                                        while (it.hasNext()) {
                                            l next = it.next();
                                            int i16 = i3 + 1;
                                            if (i3 < 0) {
                                                CollectionsKt__CollectionsKt.throwIndexOverflow();
                                            }
                                            final l lVar = next;
                                            aqVar2.addChild(new QSearchSugWordsItemView(), new Function1<QSearchSugWordsItemView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.sugword.QSearchSugWordsSubPageView$body$1$1$3$1$2$1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(QSearchSugWordsItemView qSearchSugWordsItemView) {
                                                    QSearchSugWordsItemView qSearchSugWordsItemView2 = qSearchSugWordsItemView;
                                                    final l lVar2 = l.this;
                                                    final int i17 = i3;
                                                    final QSearchSugWordsSubPageView qSearchSugWordsSubPageView7 = qSearchSugWordsSubPageView6;
                                                    qSearchSugWordsItemView2.attr(new Function1<QSearchSugWordsItemAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.sugword.QSearchSugWordsSubPageView$body$1$1$3$1$2$1.1
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(QSearchSugWordsItemAttr qSearchSugWordsItemAttr) {
                                                            QSearchSugWordsItemAttr qSearchSugWordsItemAttr2 = qSearchSugWordsItemAttr;
                                                            qSearchSugWordsItemAttr2.sugWordInfo = l.this;
                                                            qSearchSugWordsItemAttr2.index = i17;
                                                            qSearchSugWordsItemAttr2.keyword = QSearchSugWordsSubPageView.access$getAttr(qSearchSugWordsSubPageView7).getViewModel().getInputText();
                                                            qSearchSugWordsItemAttr2.tabData = QSearchSugWordsSubPageView.access$getAttr(qSearchSugWordsSubPageView7).tabData;
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    final QSearchSugWordsSubPageView qSearchSugWordsSubPageView8 = qSearchSugWordsSubPageView6;
                                                    final l lVar3 = l.this;
                                                    qSearchSugWordsItemView2.event(new Function1<QSearchSugWordsItemEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.sugword.QSearchSugWordsSubPageView$body$1$1$3$1$2$1.2
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(QSearchSugWordsItemEvent qSearchSugWordsItemEvent) {
                                                            final QSearchSugWordsSubPageView qSearchSugWordsSubPageView9 = QSearchSugWordsSubPageView.this;
                                                            final l lVar4 = lVar3;
                                                            qSearchSugWordsItemEvent.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.sugword.QSearchSugWordsSubPageView.body.1.1.3.1.2.1.2.1
                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(ClickParams clickParams) {
                                                                    QSearchSugWordsSubPageView.this.emit("clickSugWord", lVar4.f413220d);
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            i3 = i16;
                                        }
                                        final QSearchSugWordsSubPageView qSearchSugWordsSubPageView7 = QSearchSugWordsSubPageView.this;
                                        aqVar2.event(new Function1<ap, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.sugword.QSearchSugWordsSubPageView.body.1.1.3.1.3
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ap apVar) {
                                                final QSearchSugWordsSubPageView qSearchSugWordsSubPageView8 = QSearchSugWordsSubPageView.this;
                                                apVar.dragBegin(new Function1<ScrollParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.sugword.QSearchSugWordsSubPageView.body.1.1.3.1.3.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ScrollParams scrollParams) {
                                                        QSearchSugWordsSubPageView.this.hideKeyboard();
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
                        return Unit.INSTANCE;
                    }
                });
                return Unit.INSTANCE;
            }
        };
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return new QSearchSugWordsContentAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new QSearchSugWordsContentEvent();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.QSearchDetailBaseSubPage, com.tencent.kuikly.core.base.ComposeView
    public final void created() {
        QSearchSugWordsViewModel qSearchSugWordsViewModel = ((QSearchSugWordsContentAttr) getAttr()).getViewModel().subWordPageViewModel;
        if (qSearchSugWordsViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("subWordPageViewModel");
            qSearchSugWordsViewModel = null;
        }
        this.sugWordsViewModel = qSearchSugWordsViewModel;
        super.created();
        bindValueChange(new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.sugword.QSearchSugWordsSubPageView$created$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return QSearchSugWordsSubPageView.access$getAttr(QSearchSugWordsSubPageView.this).getViewModel().getInputText();
            }
        }, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.sugword.QSearchSugWordsSubPageView$created$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Object obj) {
                boolean isBlank;
                UnifySearchTabInfo currentTabInfo = QSearchSugWordsSubPageView.access$getAttr(QSearchSugWordsSubPageView.this).getViewModel().getContentPageViewModel().getCurrentTabInfo();
                if (currentTabInfo != null) {
                    QSearchSugWordsSubPageView qSearchSugWordsSubPageView = QSearchSugWordsSubPageView.this;
                    final QSearchSugWordsViewModel qSearchSugWordsViewModel2 = qSearchSugWordsSubPageView.sugWordsViewModel;
                    if (qSearchSugWordsViewModel2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("sugWordsViewModel");
                        qSearchSugWordsViewModel2 = null;
                    }
                    String inputText = QSearchSugWordsSubPageView.access$getAttr(qSearchSugWordsSubPageView).getViewModel().getInputText();
                    int i3 = QSearchSugWordsSubPageView.access$getAttr(qSearchSugWordsSubPageView).getViewModel().querySource;
                    int i16 = QSearchSugWordsSubPageView.access$getAttr(qSearchSugWordsSubPageView).getViewModel().userSource;
                    boolean isSendReqByOIDB = SearchNetApi.INSTANCE.isSendReqByOIDB();
                    qSearchSugWordsViewModel2.getClass();
                    isBlank = StringsKt__StringsJVMKt.isBlank(inputText);
                    if (isBlank) {
                        qSearchSugWordsViewModel2.getDataList().clear();
                    } else if (!Intrinsics.areEqual(inputText, qSearchSugWordsViewModel2.keyword) || !Intrinsics.areEqual((RefreshListState) qSearchSugWordsViewModel2.listState$delegate.getValue(qSearchSugWordsViewModel2, QSearchSugWordsViewModel.$$delegatedProperties[1]), RefreshListState.Loading.INSTANCE)) {
                        qSearchSugWordsViewModel2.listState$delegate.setValue(qSearchSugWordsViewModel2, QSearchSugWordsViewModel.$$delegatedProperties[1], RefreshListState.Loading.INSTANCE);
                        qSearchSugWordsViewModel2.keyword = inputText;
                        final QSearchNetSugWordsRepo qSearchNetSugWordsRepo = (QSearchNetSugWordsRepo) qSearchSugWordsViewModel2.repo$delegate.getValue();
                        final Function2<Boolean, NetSugWordsRspWrapper, Unit> function2 = new Function2<Boolean, NetSugWordsRspWrapper, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.sugword.QSearchSugWordsViewModel$fetchSugWords$1
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public final Unit invoke(Boolean bool, NetSugWordsRspWrapper netSugWordsRspWrapper) {
                                List<UnifySearchNetSugInfo> list;
                                boolean isBlank2;
                                List<l> list2;
                                boolean isBlank3;
                                bool.booleanValue();
                                NetSugWordsRspWrapper netSugWordsRspWrapper2 = netSugWordsRspWrapper;
                                QSearchSugWordsViewModel.this.getDataList().clear();
                                n nVar = netSugWordsRspWrapper2.oidbRsp;
                                if (nVar != null && (list2 = nVar.f413229d) != null) {
                                    c<l> dataList = QSearchSugWordsViewModel.this.getDataList();
                                    ArrayList arrayList = new ArrayList();
                                    for (Object obj2 : list2) {
                                        isBlank3 = StringsKt__StringsJVMKt.isBlank(((l) obj2).f413220d);
                                        if (!isBlank3) {
                                            arrayList.add(obj2);
                                        }
                                    }
                                    dataList.addAll(arrayList);
                                }
                                UnifySearchNetSugWordsRsp unifySearchNetSugWordsRsp = netSugWordsRspWrapper2.msfRsp;
                                if (unifySearchNetSugWordsRsp != null && (list = unifySearchNetSugWordsRsp.netSugInfos) != null) {
                                    QSearchSugWordsViewModel qSearchSugWordsViewModel3 = QSearchSugWordsViewModel.this;
                                    ArrayList arrayList2 = new ArrayList();
                                    for (Object obj3 : list) {
                                        isBlank2 = StringsKt__StringsJVMKt.isBlank(((UnifySearchNetSugInfo) obj3).sugWord);
                                        if (!isBlank2) {
                                            arrayList2.add(obj3);
                                        }
                                    }
                                    Iterator it = arrayList2.iterator();
                                    while (it.hasNext()) {
                                        UnifySearchNetSugInfo unifySearchNetSugInfo = (UnifySearchNetSugInfo) it.next();
                                        qSearchSugWordsViewModel3.getDataList().add(new l(unifySearchNetSugInfo.sugWord, unifySearchNetSugInfo.hitKeyWord, unifySearchNetSugInfo.extension, 8));
                                    }
                                }
                                QSearchSugWordsViewModel qSearchSugWordsViewModel4 = QSearchSugWordsViewModel.this;
                                qSearchSugWordsViewModel4.listState$delegate.setValue(qSearchSugWordsViewModel4, QSearchSugWordsViewModel.$$delegatedProperties[1], new RefreshListState.RefreshResult(true, false));
                                return Unit.INSTANCE;
                            }
                        };
                        qSearchNetSugWordsRepo.getClass();
                        if (isSendReqByOIDB) {
                            QSearchUtilKt.fastLog("QSearchNetSugWordsRepo requestData begin", false);
                            SearchReqGetSugWords searchReqGetSugWords = new SearchReqGetSugWords(inputText, currentTabInfo, Utils.INSTANCE.currentBridgeModule().base64Code(qSearchNetSugWordsRepo.getExtensionData(i3, i16), true));
                            final long timeStamp = QSearchUtilKt.getTimeStamp();
                            QQKuiklyPlatformApi.Companion.sendOIDBRequest(searchReqGetSugWords, false, new SearchNetApi$sendOidbPbRequest$1(QSearchUtilKt.getTimeStamp(), searchReqGetSugWords, new Function1<OIDBResponse<n>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.sugword.repo.QSearchNetSugWordsRepo$requestDataByOIDB$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(OIDBResponse<n> oIDBResponse) {
                                    OIDBResponse<n> oIDBResponse2 = oIDBResponse;
                                    int timeStamp2 = (int) (QSearchUtilKt.getTimeStamp() - timeStamp);
                                    n nVar = oIDBResponse2.rsp;
                                    int i17 = oIDBResponse2.code;
                                    if (i17 != 0) {
                                        QSearchNetSugWordsRepo.access$nofityFail(qSearchNetSugWordsRepo, i17, oIDBResponse2.f114186msg, function2);
                                    } else if (nVar != null) {
                                        QSearchUtilKt.fastLog("QSearchNetSugWordsRepo requestData success, costTime=" + timeStamp2, false);
                                        function2.invoke(Boolean.TRUE, new NetSugWordsRspWrapper(nVar, null));
                                    } else {
                                        QSearchNetSugWordsRepo.access$nofityFail(qSearchNetSugWordsRepo, -1, "no rsp body", function2);
                                    }
                                    return Unit.INSTANCE;
                                }
                            }));
                        } else {
                            QSearchUtilKt.fastLog("QSearchNetSugWordsRepo requestDataByMSF begin", false);
                            Utils utils = Utils.INSTANCE;
                            String base64Code = utils.currentBridgeModule().base64Code(qSearchNetSugWordsRepo.getExtensionData(i3, i16), true);
                            final long timeStamp2 = QSearchUtilKt.getTimeStamp();
                            NetworkUtils networkUtils = NetworkUtils.INSTANCE;
                            UnifySearchNetSugWordsRsp unifySearchNetSugWordsRsp = new UnifySearchNetSugWordsRsp(null, "");
                            Function1<UnifySearchNetSugWordsRsp, Unit> function1 = new Function1<UnifySearchNetSugWordsRsp, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.sugword.repo.QSearchNetSugWordsRepo$requestDataByMSF$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(UnifySearchNetSugWordsRsp unifySearchNetSugWordsRsp2) {
                                    int timeStamp3 = (int) (QSearchUtilKt.getTimeStamp() - timeStamp2);
                                    QSearchReportKt.reportNetQuality("trpc.unifysearch.unite.netresult/HandleNetSugWords", timeStamp3, 0, "");
                                    QSearchUtilKt.fastLog("QSearchNetSugWordsRepo requestDataByMSF success, costTime=" + timeStamp3, false);
                                    function2.invoke(Boolean.TRUE, new NetSugWordsRspWrapper(null, unifySearchNetSugWordsRsp2));
                                    return Unit.INSTANCE;
                                }
                            };
                            Function2<Integer, String, Unit> function22 = new Function2<Integer, String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.sugword.repo.QSearchNetSugWordsRepo$requestDataByMSF$2
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public final Unit invoke(Integer num, String str) {
                                    int intValue = num.intValue();
                                    QSearchReportKt.reportNetQuality("trpc.unifysearch.unite.netresult/HandleNetSugWords", (int) (QSearchUtilKt.getTimeStamp() - timeStamp2), intValue, "");
                                    QSearchNetSugWordsRepo.access$nofityFail(qSearchNetSugWordsRepo, intValue, str, function2);
                                    return Unit.INSTANCE;
                                }
                            };
                            BridgeModule currentBridgeModule = utils.currentBridgeModule();
                            e m3 = AdelieAudioRecordManager$endRecord$1$$ExternalSyntheticOutline0.m(QCircleSchemeAttr.Detail.KEY_WORD, inputText, "sug_word_scene", 1);
                            m3.v("tab", currentTabInfo.encode());
                            m3.v(MimeTypeParser.ATTR_EXTENSION, base64Code);
                            currentBridgeModule.ssoRequest("trpc.unifysearch.unite.netresult/HandleNetSugWords", m3, false, new NetworkUtils$requestWithCmd$7(function22, unifySearchNetSugWordsRsp, function1));
                        }
                    }
                }
                return Unit.INSTANCE;
            }
        });
    }

    @Override // com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.QSearchDetailBaseSubPage
    public final SubPageName getSubPageName() {
        return SubPageName.SUG_WORD;
    }
}
