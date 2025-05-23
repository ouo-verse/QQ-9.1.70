package com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver;

import com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.create.AdelieAudioRecordManager$endRecord$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.BasePager;
import com.tencent.hippykotlin.demo.pages.base.BridgeModule;
import com.tencent.hippykotlin.demo.pages.base.NetworkUtils;
import com.tencent.hippykotlin.demo.pages.base.NetworkUtils$requestWithCmd$7;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.base.extension.AttrExtKt;
import com.tencent.hippykotlin.demo.pages.base.extension.PageDataExtKt;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.portrait_list_views.QPPromoteReceiverPortraitNav;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.portrait_list_views.QPPromoteReceiverPortraitNavAttr;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.portrait_list_views.QPPromoteReceiverPortraitSearchResultList;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.portrait_list_views.QPPromoteReceiverPortraitSectionList;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.portrait_list_views.QPPromoteReceiverPortraitSectionListModel;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.search_views.QPPromoteReceiverSearchBar;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.search_views.QPPromoteReceiverSearchBarAttr;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.page_model.QPPromoteReceiverCreatorPortraitPageModel;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.page_model.QPPromoteReceiverCreatorPortraitPageModel$refresh$2;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.page_model.QPPromoteReceiverPortraitListItem;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.QPlusTrafficRepository;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.protoc.QPlusGetCateNameListRsp;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.protoc.QPlusGetTalentsByCategoryRsp;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.protoc.QPlusUserInfo;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
import com.tencent.kuikly.core.directives.LoopDirectivesView;
import com.tencent.kuikly.core.directives.LoopDirectivesViewKt;
import com.tencent.kuikly.core.nvi.serialization.json.b;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.reactive.collection.c;
import com.tencent.kuikly.core.views.ao;
import com.tencent.kuikly.core.views.aq;
import com.tencent.kuikly.core.views.ar;
import com.tencent.mobileqq.qwallet.transaction.impl.NotifyMsgApiImpl;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.BooleanCompanionObject;
import kotlin.jvm.internal.DoubleCompanionObject;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.LongCompanionObject;
import kotlin.jvm.internal.StringCompanionObject;

/* loaded from: classes31.dex */
public final class QPPromoteReceiverCreatorPortraitPage extends BasePager {
    public static final /* synthetic */ int $r8$clinit = 0;
    public final Lazy pageModel$delegate;

    public QPPromoteReceiverCreatorPortraitPage() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<QPPromoteReceiverCreatorPortraitPageModel>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.QPPromoteReceiverCreatorPortraitPage$pageModel$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final QPPromoteReceiverCreatorPortraitPageModel invoke() {
                Object d16;
                QPPromoteReceiverCreatorPortraitPageModel qPPromoteReceiverCreatorPortraitPageModel = new QPPromoteReceiverCreatorPortraitPageModel();
                b l3 = PageDataExtKt.getUserData(QPPromoteReceiverCreatorPortraitPage.this.getPageData()).l("selectedCreatorList");
                if (l3 != null) {
                    int c16 = l3.c();
                    for (int i3 = 0; i3 < c16; i3++) {
                        if (BooleanCompanionObject.INSTANCE instanceof e) {
                            d16 = Boolean.valueOf(l3.e(i3));
                        } else if (IntCompanionObject.INSTANCE instanceof e) {
                            d16 = Integer.valueOf(l3.i(i3));
                        } else if (LongCompanionObject.INSTANCE instanceof e) {
                            d16 = Long.valueOf(l3.m(i3));
                        } else if (StringCompanionObject.INSTANCE instanceof e) {
                            d16 = l3.o(i3);
                        } else if (DoubleCompanionObject.INSTANCE instanceof e) {
                            d16 = Double.valueOf(l3.g(i3));
                        } else {
                            d16 = l3.d(i3);
                        }
                        if (d16 != null) {
                            e eVar = (e) d16;
                            qPPromoteReceiverCreatorPortraitPageModel.getSelectedList().add(new QPPromoteReceiverPortraitListItem(eVar.p("uin"), Utils.INSTANCE.currentBridgeModule().urlDecode(eVar.p("name")), eVar.p("icon"), eVar.j(NotifyMsgApiImpl.KEY_GROUP_TYPE), eVar.f("isBlueV"), eVar.f("isBigV")));
                            qPPromoteReceiverCreatorPortraitPageModel.setSelectedCount(qPPromoteReceiverCreatorPortraitPageModel.getSelectedCount() + 1);
                        } else {
                            throw new NullPointerException("null cannot be cast to non-null type com.tencent.kuikly.core.nvi.serialization.json.JSONObject");
                        }
                    }
                }
                qPPromoteReceiverCreatorPortraitPageModel.dataParam = "selectedCreatorList";
                return qPPromoteReceiverCreatorPortraitPageModel;
            }
        });
        this.pageModel$delegate = lazy;
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.QPPromoteReceiverCreatorPortraitPage$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.QPPromoteReceiverCreatorPortraitPage$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        mVar2.size(mVar2.getPagerData().m(), mVar2.getPagerData().l());
                        AttrExtKt.backgroundColorToken(mVar2, "qecommerce_skin_color_bg_backplate");
                        return Unit.INSTANCE;
                    }
                });
                final QPPromoteReceiverCreatorPortraitPage qPPromoteReceiverCreatorPortraitPage = QPPromoteReceiverCreatorPortraitPage.this;
                viewContainer2.addChild(new QPPromoteReceiverPortraitNav(), new Function1<QPPromoteReceiverPortraitNav, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.QPPromoteReceiverCreatorPortraitPage$body$1.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(QPPromoteReceiverPortraitNav qPPromoteReceiverPortraitNav) {
                        final QPPromoteReceiverCreatorPortraitPage qPPromoteReceiverCreatorPortraitPage2 = QPPromoteReceiverCreatorPortraitPage.this;
                        qPPromoteReceiverPortraitNav.attr(new Function1<QPPromoteReceiverPortraitNavAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.QPPromoteReceiverCreatorPortraitPage.body.1.2.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(QPPromoteReceiverPortraitNavAttr qPPromoteReceiverPortraitNavAttr) {
                                QPPromoteReceiverPortraitNavAttr qPPromoteReceiverPortraitNavAttr2 = qPPromoteReceiverPortraitNavAttr;
                                qPPromoteReceiverPortraitNavAttr2.titleText$delegate.setValue(qPPromoteReceiverPortraitNavAttr2, QPPromoteReceiverPortraitNavAttr.$$delegatedProperties[0], "\u9009\u62e9\u8fbe\u4eba");
                                qPPromoteReceiverPortraitNavAttr2.viewModel = QPPromoteReceiverCreatorPortraitPage.this.getPageModel();
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final QPPromoteReceiverCreatorPortraitPage qPPromoteReceiverCreatorPortraitPage2 = QPPromoteReceiverCreatorPortraitPage.this;
                viewContainer2.addChild(new QPPromoteReceiverSearchBar(), new Function1<QPPromoteReceiverSearchBar, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.QPPromoteReceiverCreatorPortraitPage$body$1.3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(QPPromoteReceiverSearchBar qPPromoteReceiverSearchBar) {
                        final QPPromoteReceiverCreatorPortraitPage qPPromoteReceiverCreatorPortraitPage3 = QPPromoteReceiverCreatorPortraitPage.this;
                        qPPromoteReceiverSearchBar.attr(new Function1<QPPromoteReceiverSearchBarAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.QPPromoteReceiverCreatorPortraitPage.body.1.3.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(QPPromoteReceiverSearchBarAttr qPPromoteReceiverSearchBarAttr) {
                                qPPromoteReceiverSearchBarAttr.viewModel = QPPromoteReceiverCreatorPortraitPage.this.getPageModel();
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final QPPromoteReceiverCreatorPortraitPage qPPromoteReceiverCreatorPortraitPage3 = QPPromoteReceiverCreatorPortraitPage.this;
                Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.QPPromoteReceiverCreatorPortraitPage$body$1.4
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Boolean.valueOf(QPPromoteReceiverCreatorPortraitPage.this.getPageModel().getSearchStatus() == 0);
                    }
                };
                final QPPromoteReceiverCreatorPortraitPage qPPromoteReceiverCreatorPortraitPage4 = QPPromoteReceiverCreatorPortraitPage.this;
                ConditionViewKt.c(viewContainer2, function0, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.QPPromoteReceiverCreatorPortraitPage$body$1.5
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ConditionView conditionView) {
                        final QPPromoteReceiverCreatorPortraitPage qPPromoteReceiverCreatorPortraitPage5 = QPPromoteReceiverCreatorPortraitPage.this;
                        ar.a(conditionView, new Function1<aq<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.QPPromoteReceiverCreatorPortraitPage.body.1.5.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(aq<?, ?> aqVar) {
                                aq<?, ?> aqVar2 = aqVar;
                                aqVar2.attr(new Function1<ao, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.QPPromoteReceiverCreatorPortraitPage.body.1.5.1.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ao aoVar) {
                                        ao aoVar2 = aoVar;
                                        aoVar2.mo153width(aoVar2.getPagerData().m());
                                        aoVar2.m143maxHeight(((aoVar2.getPagerData().l() - aoVar2.getPager().getPageData().getNavigationBarHeight()) - 56.0f) - 12.0f);
                                        aoVar2.m140flex(1.0f);
                                        aoVar2.marginTop(12.0f);
                                        aoVar2.showScrollerIndicator(false);
                                        AttrExtKt.backgroundColorToken(aoVar2, "qecommerce_skin_color_bg_default");
                                        return Unit.INSTANCE;
                                    }
                                });
                                final QPPromoteReceiverCreatorPortraitPage qPPromoteReceiverCreatorPortraitPage6 = QPPromoteReceiverCreatorPortraitPage.this;
                                LoopDirectivesViewKt.a(aqVar2, new Function0<c<QPPromoteReceiverPortraitSectionListModel>>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.QPPromoteReceiverCreatorPortraitPage.body.1.5.1.2
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public final c<QPPromoteReceiverPortraitSectionListModel> invoke() {
                                        return QPPromoteReceiverCreatorPortraitPage.this.getPageModel().getPortraitSectionListModels();
                                    }
                                }, new Function2<LoopDirectivesView<QPPromoteReceiverPortraitSectionListModel>, QPPromoteReceiverPortraitSectionListModel, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.QPPromoteReceiverCreatorPortraitPage.body.1.5.1.3
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Unit invoke(LoopDirectivesView<QPPromoteReceiverPortraitSectionListModel> loopDirectivesView, QPPromoteReceiverPortraitSectionListModel qPPromoteReceiverPortraitSectionListModel) {
                                        loopDirectivesView.addChild(new QPPromoteReceiverPortraitSectionList(qPPromoteReceiverPortraitSectionListModel), new Function1<QPPromoteReceiverPortraitSectionList, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.QPPromoteReceiverCreatorPortraitPage.body.1.5.1.3.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final /* bridge */ /* synthetic */ Unit invoke(QPPromoteReceiverPortraitSectionList qPPromoteReceiverPortraitSectionList) {
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
                final QPPromoteReceiverCreatorPortraitPage qPPromoteReceiverCreatorPortraitPage5 = QPPromoteReceiverCreatorPortraitPage.this;
                Function0<Object> function02 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.QPPromoteReceiverCreatorPortraitPage$body$1.6
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Boolean.valueOf(QPPromoteReceiverCreatorPortraitPage.this.getPageModel().getShowItemList().isEmpty());
                    }
                };
                final QPPromoteReceiverCreatorPortraitPage qPPromoteReceiverCreatorPortraitPage6 = QPPromoteReceiverCreatorPortraitPage.this;
                ConditionViewKt.b(viewContainer2, function02, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.QPPromoteReceiverCreatorPortraitPage$body$1.7
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ConditionView conditionView) {
                        QPPromoteReceiverCreatorPortraitPage qPPromoteReceiverCreatorPortraitPage7 = QPPromoteReceiverCreatorPortraitPage.this;
                        int i3 = QPPromoteReceiverCreatorPortraitPage.$r8$clinit;
                        qPPromoteReceiverCreatorPortraitPage7.getClass();
                        QPPromoteReceiverCreatorPortraitPage$bodyWithEmptyView$1.INSTANCE.invoke(conditionView);
                        return Unit.INSTANCE;
                    }
                });
                final QPPromoteReceiverCreatorPortraitPage qPPromoteReceiverCreatorPortraitPage7 = QPPromoteReceiverCreatorPortraitPage.this;
                ConditionViewKt.a(viewContainer2, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.QPPromoteReceiverCreatorPortraitPage$body$1.8
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ConditionView conditionView) {
                        QPPromoteReceiverCreatorPortraitPageModel pageModel = QPPromoteReceiverCreatorPortraitPage.this.getPageModel();
                        conditionView.addChild(new QPPromoteReceiverPortraitSearchResultList(pageModel), new Function1<QPPromoteReceiverPortraitSearchResultList, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.QPPromoteReceiverCreatorPortraitPage.body.1.8.1
                            @Override // kotlin.jvm.functions.Function1
                            public final /* bridge */ /* synthetic */ Unit invoke(QPPromoteReceiverPortraitSearchResultList qPPromoteReceiverPortraitSearchResultList) {
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

    @Override // com.tencent.hippykotlin.demo.pages.base.BasePager, com.tencent.kuikly.core.base.ComposeView
    public final void created() {
        super.created();
        final QPPromoteReceiverCreatorPortraitPageModel pageModel = getPageModel();
        pageModel.getClass();
        QPlusTrafficRepository qPlusTrafficRepository = QPlusTrafficRepository.INSTANCE;
        final Function1<QPlusGetCateNameListRsp, Unit> function1 = new Function1<QPlusGetCateNameListRsp, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.page_model.QPPromoteReceiverCreatorPortraitPageModel$refresh$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(QPlusGetCateNameListRsp qPlusGetCateNameListRsp) {
                ArrayList<String> arrayList = qPlusGetCateNameListRsp.categories;
                if (arrayList != null) {
                    QPPromoteReceiverCreatorPortraitPageModel qPPromoteReceiverCreatorPortraitPageModel = QPPromoteReceiverCreatorPortraitPageModel.this;
                    qPPromoteReceiverCreatorPortraitPageModel.categoryLists.clear();
                    qPPromoteReceiverCreatorPortraitPageModel.categoryLists.addAll(arrayList);
                }
                final QPPromoteReceiverCreatorPortraitPageModel qPPromoteReceiverCreatorPortraitPageModel2 = QPPromoteReceiverCreatorPortraitPageModel.this;
                qPPromoteReceiverCreatorPortraitPageModel2.getPortraitSectionListModels().clear();
                qPPromoteReceiverCreatorPortraitPageModel2.getAllItemList().clear();
                QPPromoteReceiverPortraitSectionListModel qPPromoteReceiverPortraitSectionListModel = new QPPromoteReceiverPortraitSectionListModel(qPPromoteReceiverCreatorPortraitPageModel2);
                qPPromoteReceiverCreatorPortraitPageModel2.topSectionListModel = qPPromoteReceiverPortraitSectionListModel;
                qPPromoteReceiverPortraitSectionListModel.title$delegate.setValue(qPPromoteReceiverPortraitSectionListModel, QPPromoteReceiverPortraitSectionListModel.$$delegatedProperties[0], "\u81ea\u9009");
                qPPromoteReceiverCreatorPortraitPageModel2.topSectionListModel.getSectionList().addAll(qPPromoteReceiverCreatorPortraitPageModel2.getSelectedList());
                qPPromoteReceiverCreatorPortraitPageModel2.getAllItemList().addAll(qPPromoteReceiverCreatorPortraitPageModel2.getSelectedList());
                qPPromoteReceiverCreatorPortraitPageModel2.getPortraitSectionListModels().add(qPPromoteReceiverCreatorPortraitPageModel2.topSectionListModel);
                qPPromoteReceiverCreatorPortraitPageModel2.setListReqCount(qPPromoteReceiverCreatorPortraitPageModel2.categoryLists.size());
                Iterator<String> it = qPPromoteReceiverCreatorPortraitPageModel2.categoryLists.iterator();
                while (it.hasNext()) {
                    final String next = it.next();
                    if (next.length() == 0) {
                        qPPromoteReceiverCreatorPortraitPageModel2.setListReqCount(qPPromoteReceiverCreatorPortraitPageModel2.getListReqCount() - 1);
                    } else {
                        QPlusTrafficRepository qPlusTrafficRepository2 = QPlusTrafficRepository.INSTANCE;
                        final Function1<QPlusGetTalentsByCategoryRsp, Unit> function12 = new Function1<QPlusGetTalentsByCategoryRsp, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.page_model.QPPromoteReceiverCreatorPortraitPageModel$refreshCategoryData$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(QPlusGetTalentsByCategoryRsp qPlusGetTalentsByCategoryRsp) {
                                QPPromoteReceiverCreatorPortraitPageModel.this.setListReqCount(r0.getListReqCount() - 1);
                                QPPromoteReceiverPortraitSectionListModel qPPromoteReceiverPortraitSectionListModel2 = new QPPromoteReceiverPortraitSectionListModel(QPPromoteReceiverCreatorPortraitPageModel.this);
                                qPPromoteReceiverPortraitSectionListModel2.title$delegate.setValue(qPPromoteReceiverPortraitSectionListModel2, QPPromoteReceiverPortraitSectionListModel.$$delegatedProperties[0], next);
                                ArrayList<QPlusUserInfo> arrayList2 = qPlusGetTalentsByCategoryRsp.talents;
                                if (arrayList2 != null) {
                                    QPPromoteReceiverCreatorPortraitPageModel qPPromoteReceiverCreatorPortraitPageModel3 = QPPromoteReceiverCreatorPortraitPageModel.this;
                                    for (QPlusUserInfo qPlusUserInfo : arrayList2) {
                                        QPPromoteReceiverPortraitListItem qPPromoteReceiverPortraitListItem = new QPPromoteReceiverPortraitListItem(String.valueOf(qPlusUserInfo.uin), Utils.INSTANCE.currentBridgeModule().urlDecode(qPlusUserInfo.nickname), qPlusUserInfo.icon, 0, qPlusUserInfo.isBlueV, qPlusUserInfo.isBigV);
                                        if (!qPPromoteReceiverCreatorPortraitPageModel3.hasAddedToAllItems(qPPromoteReceiverPortraitListItem)) {
                                            qPPromoteReceiverPortraitSectionListModel2.getSectionList().add(qPPromoteReceiverPortraitListItem);
                                            qPPromoteReceiverCreatorPortraitPageModel3.getAllItemList().add(qPPromoteReceiverPortraitListItem);
                                        }
                                    }
                                }
                                if (qPPromoteReceiverPortraitSectionListModel2.getSectionList().size() > 0) {
                                    QPPromoteReceiverCreatorPortraitPageModel.this.getPortraitSectionListModels().add(qPPromoteReceiverPortraitSectionListModel2);
                                }
                                return Unit.INSTANCE;
                            }
                        };
                        Function2<Integer, String, Unit> function2 = new Function2<Integer, String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.page_model.QPPromoteReceiverCreatorPortraitPageModel$refreshCategoryData$1$2
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public final Unit invoke(Integer num, String str) {
                                num.intValue();
                                QPPromoteReceiverCreatorPortraitPageModel.this.setListReqCount(r1.getListReqCount() - 1);
                                return Unit.INSTANCE;
                            }
                        };
                        NetworkUtils networkUtils = NetworkUtils.INSTANCE;
                        QPlusGetTalentsByCategoryRsp qPlusGetTalentsByCategoryRsp = new QPlusGetTalentsByCategoryRsp(null, 0, 0, 0L, 0L, 31, null);
                        Function1<QPlusGetTalentsByCategoryRsp, Unit> function13 = new Function1<QPlusGetTalentsByCategoryRsp, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.QPlusTrafficRepository$reqGetTalentsByCategory$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(QPlusGetTalentsByCategoryRsp qPlusGetTalentsByCategoryRsp2) {
                                function12.invoke(qPlusGetTalentsByCategoryRsp2);
                                return Unit.INSTANCE;
                            }
                        };
                        BridgeModule currentBridgeModule = Utils.INSTANCE.currentBridgeModule();
                        e m3 = AdelieAudioRecordManager$endRecord$1$$ExternalSyntheticOutline0.m("category_name", next, "page", 0);
                        m3.t("size", 10);
                        NetworkUtils$requestWithCmd$7 networkUtils$requestWithCmd$7 = new NetworkUtils$requestWithCmd$7(function2, qPlusGetTalentsByCategoryRsp, function13);
                        int i3 = BridgeModule.$r8$clinit;
                        currentBridgeModule.ssoRequest("trpc.ecom.talent_search_svr.TalentSearchSvr/GetTalentsByCategory", m3, false, networkUtils$requestWithCmd$7);
                    }
                }
                return Unit.INSTANCE;
            }
        };
        QPPromoteReceiverCreatorPortraitPageModel$refresh$2 qPPromoteReceiverCreatorPortraitPageModel$refresh$2 = new Function2<Integer, String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.page_model.QPPromoteReceiverCreatorPortraitPageModel$refresh$2
            @Override // kotlin.jvm.functions.Function2
            public final /* bridge */ /* synthetic */ Unit invoke(Integer num, String str) {
                num.intValue();
                return Unit.INSTANCE;
            }
        };
        NetworkUtils networkUtils = NetworkUtils.INSTANCE;
        QPlusGetCateNameListRsp qPlusGetCateNameListRsp = new QPlusGetCateNameListRsp(null);
        Function1<QPlusGetCateNameListRsp, Unit> function12 = new Function1<QPlusGetCateNameListRsp, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.QPlusTrafficRepository$reqGetCreatorCateNameList$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(QPlusGetCateNameListRsp qPlusGetCateNameListRsp2) {
                function1.invoke(qPlusGetCateNameListRsp2);
                return Unit.INSTANCE;
            }
        };
        BridgeModule currentBridgeModule = Utils.INSTANCE.currentBridgeModule();
        e eVar = new e();
        NetworkUtils$requestWithCmd$7 networkUtils$requestWithCmd$7 = new NetworkUtils$requestWithCmd$7(qPPromoteReceiverCreatorPortraitPageModel$refresh$2, qPlusGetCateNameListRsp, function12);
        int i3 = BridgeModule.$r8$clinit;
        currentBridgeModule.ssoRequest("trpc.ecom.talent_search_svr.TalentSearchSvr/GetCateNameList", eVar, false, networkUtils$requestWithCmd$7);
    }

    public final QPPromoteReceiverCreatorPortraitPageModel getPageModel() {
        return (QPPromoteReceiverCreatorPortraitPageModel) this.pageModel$delegate.getValue();
    }
}
