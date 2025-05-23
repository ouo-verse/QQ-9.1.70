package com.tencent.hippykotlin.demo.pages.nearby.new_guide.view;

import c01.c;
import c45.i;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieCategoryHomePage$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.CategoryListFooterKt$CategoryListFooter$1$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.ECLoadingAttr;
import com.tencent.hippykotlin.demo.pages.base.ECLoadingView;
import com.tencent.hippykotlin.demo.pages.base.ECLoadingViewKt;
import com.tencent.hippykotlin.demo.pages.base.QToastMode;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedItemView$body$1$3$8$1$2$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyConst;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.NBPLatLng;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.NBPUserSelfInfo;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.UserDataManager;
import com.tencent.hippykotlin.demo.pages.nearby.base.module.QQNearbyModule;
import com.tencent.hippykotlin.demo.pages.nearby.base.repo.NBPPublishConfig;
import com.tencent.hippykotlin.demo.pages.nearby.base.repo.NBPPublishService;
import com.tencent.hippykotlin.demo.pages.nearby.base.repo.QQStrangerSsoRequest;
import com.tencent.hippykotlin.demo.pages.nearby.base.repo.QQStrangerSsoService$sendProxyRequest$1;
import com.tencent.hippykotlin.demo.pages.nearby.base.tech_reporter.APICallTechReporter;
import com.tencent.hippykotlin.demo.pages.nearby.new_guide.NBPGuideNoviceViewModel;
import com.tencent.hippykotlin.demo.pages.nearby.new_homepage.repository.NBPNewHomeRepository$updateTagsInfo$1;
import com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.repository.NBPNewEditRepository$setUserInfo$1;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.aa;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.module.MemoryCacheModule;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.ModalView;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ah;
import com.tencent.kuikly.core.views.bb;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.u;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import f35.g;
import f35.j;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import n25.k;
import oicq.wlogin_sdk.tools.util;
import s25.f;
import s35.ad;
import s35.ae;
import s35.d;
import t35.a;

/* loaded from: classes31.dex */
public final class NBPGuideNoviceSecondPageView extends ComposeView<NBPGuideNoviceSecondPageViewAttr, NBPGuideNoviceSecondPageViewEvent> {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPGuideNoviceSecondPageView.class, "isRadioCheck", "isRadioCheck()Z", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPGuideNoviceSecondPageView.class, "selectedTagList", "getSelectedTagList()Lcom/tencent/kuikly/core/reactive/collection/ObservableList;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPGuideNoviceSecondPageView.class, "mainTagId", "getMainTagId()I", 0)};
    public aa<NBPGuideTagCardView> tagCardViewRef;
    public final ReadWriteProperty isRadioCheck$delegate = c.a(Boolean.TRUE);
    public final ReadWriteProperty selectedTagList$delegate = c.b();
    public final ReadWriteProperty mainTagId$delegate = c.a(-1);

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ NBPGuideNoviceSecondPageViewAttr access$getAttr(NBPGuideNoviceSecondPageView nBPGuideNoviceSecondPageView) {
        return (NBPGuideNoviceSecondPageViewAttr) nBPGuideNoviceSecondPageView.getAttr();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void access$handleClickTag(NBPGuideNoviceSecondPageView nBPGuideNoviceSecondPageView, a aVar) {
        int collectionSizeOrDefault;
        Object firstOrNull;
        int i3 = !nBPGuideNoviceSecondPageView.getSelectedTagList().contains(aVar) ? 1 : 0;
        e jsonWithPageParams = nBPGuideNoviceSecondPageView.jsonWithPageParams();
        jsonWithPageParams.v("dt_eid", "em_nearby_interest_tag");
        jsonWithPageParams.t("nearby_tag_id", aVar.f435362d);
        jsonWithPageParams.t("nearby_action_type", i3);
        jsonWithPageParams.v(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
        Utils.INSTANCE.currentBridgeModule().reportCustomDtEvent("dt_clck", jsonWithPageParams);
        nBPGuideNoviceSecondPageView.getSelectedTagList().clear();
        com.tencent.kuikly.core.reactive.collection.c<a> selectedTagList = ((NBPGuideNoviceSecondPageViewAttr) nBPGuideNoviceSecondPageView.getAttr()).getViewModel().getSelectedTagList();
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(selectedTagList, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<a> it = selectedTagList.iterator();
        while (it.hasNext()) {
            arrayList.add(Boolean.valueOf(nBPGuideNoviceSecondPageView.getSelectedTagList().add(it.next())));
        }
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) nBPGuideNoviceSecondPageView.getSelectedTagList());
        a aVar2 = (a) firstOrNull;
        nBPGuideNoviceSecondPageView.mainTagId$delegate.setValue(nBPGuideNoviceSecondPageView, $$delegatedProperties[2], Integer.valueOf(aVar2 != null ? aVar2.f435362d : -1));
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideNoviceSecondPageView$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideNoviceSecondPageView$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        mVar2.flexDirectionColumn();
                        mVar2.alignItemsCenter();
                        mVar2.mo113backgroundColor(QUIToken.color$default("bg_nav_secondary"));
                        mVar2.size(mVar2.getPagerData().m(), mVar2.getPagerData().l());
                        return Unit.INSTANCE;
                    }
                });
                final NBPGuideNoviceSecondPageView nBPGuideNoviceSecondPageView = NBPGuideNoviceSecondPageView.this;
                viewContainer2.addChild(new NBPGuideNoviceNavBarView(), new Function1<NBPGuideNoviceNavBarView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideNoviceSecondPageView$body$1.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(NBPGuideNoviceNavBarView nBPGuideNoviceNavBarView) {
                        NBPGuideNoviceNavBarView nBPGuideNoviceNavBarView2 = nBPGuideNoviceNavBarView;
                        nBPGuideNoviceNavBarView2.attr(new Function1<NBPGuideNoviceNavBarAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideNoviceSecondPageView.body.1.2.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(NBPGuideNoviceNavBarAttr nBPGuideNoviceNavBarAttr) {
                                NBPGuideNoviceNavBarAttr nBPGuideNoviceNavBarAttr2 = nBPGuideNoviceNavBarAttr;
                                nBPGuideNoviceNavBarAttr2.title = "\u6211\u7684\u5174\u8da3\u6210\u5206";
                                nBPGuideNoviceNavBarAttr2.alignSelfStretch();
                                return Unit.INSTANCE;
                            }
                        });
                        final NBPGuideNoviceSecondPageView nBPGuideNoviceSecondPageView2 = NBPGuideNoviceSecondPageView.this;
                        nBPGuideNoviceNavBarView2.event(new Function1<NBPGuideNoviceNavBarEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideNoviceSecondPageView.body.1.2.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(NBPGuideNoviceNavBarEvent nBPGuideNoviceNavBarEvent) {
                                final NBPGuideNoviceSecondPageView nBPGuideNoviceSecondPageView3 = NBPGuideNoviceSecondPageView.this;
                                nBPGuideNoviceNavBarEvent.clickBackBtnHandlerFn = new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideNoviceSecondPageView.body.1.2.2.1
                                    {
                                        super(1);
                                    }

                                    /* JADX WARN: Multi-variable type inference failed */
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(Object obj) {
                                        Function0<Unit> function0 = ((NBPGuideNoviceSecondPageViewEvent) NBPGuideNoviceSecondPageView.this.getViewEvent()).onBackEventHandler;
                                        if (function0 != null) {
                                            function0.invoke();
                                        }
                                        return Unit.INSTANCE;
                                    }
                                };
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final NBPGuideNoviceSecondPageView nBPGuideNoviceSecondPageView2 = NBPGuideNoviceSecondPageView.this;
                viewContainer2.addChild(new NBPGuideTagCardView(), new Function1<NBPGuideTagCardView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideNoviceSecondPageView$body$1.3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(NBPGuideTagCardView nBPGuideTagCardView) {
                        NBPGuideTagCardView nBPGuideTagCardView2 = nBPGuideTagCardView;
                        final NBPGuideNoviceSecondPageView nBPGuideNoviceSecondPageView3 = NBPGuideNoviceSecondPageView.this;
                        nBPGuideTagCardView2.ref(nBPGuideTagCardView2, new Function1<aa<NBPGuideTagCardView>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideNoviceSecondPageView.body.1.3.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(aa<NBPGuideTagCardView> aaVar) {
                                NBPGuideNoviceSecondPageView.this.tagCardViewRef = aaVar;
                                return Unit.INSTANCE;
                            }
                        });
                        final NBPGuideNoviceSecondPageView nBPGuideNoviceSecondPageView4 = NBPGuideNoviceSecondPageView.this;
                        nBPGuideTagCardView2.attr(new Function1<NBPGuideTagCardAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideNoviceSecondPageView.body.1.3.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(NBPGuideTagCardAttr nBPGuideTagCardAttr) {
                                j jVar;
                                NBPGuideTagCardAttr nBPGuideTagCardAttr2 = nBPGuideTagCardAttr;
                                nBPGuideTagCardAttr2.marginTop(16.0f);
                                NBPGuideNoviceSecondPageView nBPGuideNoviceSecondPageView5 = NBPGuideNoviceSecondPageView.this;
                                KProperty<Object>[] kPropertyArr = NBPGuideNoviceSecondPageView.$$delegatedProperties;
                                nBPGuideTagCardAttr2.setTagList(nBPGuideNoviceSecondPageView5.getSelectedTagList());
                                NBPGuideNoviceSecondPageView nBPGuideNoviceSecondPageView6 = NBPGuideNoviceSecondPageView.this;
                                nBPGuideTagCardAttr2.mainTagId$delegate.setValue(nBPGuideTagCardAttr2, NBPGuideTagCardAttr.$$delegatedProperties[0], Integer.valueOf(((Number) nBPGuideNoviceSecondPageView6.mainTagId$delegate.getValue(nBPGuideNoviceSecondPageView6, NBPGuideNoviceSecondPageView.$$delegatedProperties[2])).intValue()));
                                g loginRsp = NBPGuideNoviceSecondPageView.access$getAttr(NBPGuideNoviceSecondPageView.this).getViewModel().getLoginRsp();
                                if (loginRsp != null && (jVar = loginRsp.E) != null) {
                                    nBPGuideTagCardAttr2.tagSpecificIconList = jVar.f397814i;
                                    nBPGuideTagCardAttr2.tagCommonIconList = jVar.f397815m;
                                }
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideNoviceSecondPageView$body$1.4
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideNoviceSecondPageView.body.1.4.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.marginTop(24.0f);
                                tVar2.flexDirectionRow();
                                return Unit.INSTANCE;
                            }
                        });
                        cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideNoviceSecondPageView.body.1.4.2
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(TextView textView) {
                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideNoviceSecondPageView.body.1.4.2.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ce ceVar) {
                                        ce ceVar2 = ceVar;
                                        ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                        ceVar2.fontWeight400();
                                        ceVar2.color(QUIToken.color$default("text_secondary"));
                                        ceVar2.text("\u9009\u62e9");
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideNoviceSecondPageView.body.1.4.3
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(TextView textView) {
                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideNoviceSecondPageView.body.1.4.3.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ce ceVar) {
                                        ce ceVar2 = ceVar;
                                        ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                        ceVar2.fontWeight400();
                                        ceVar2.color(QUIToken.color$default("brand_standard"));
                                        ceVar2.text("3");
                                        ceVar2.marginLeft(2.0f);
                                        ceVar2.marginRight(2.0f);
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideNoviceSecondPageView.body.1.4.4
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(TextView textView) {
                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideNoviceSecondPageView.body.1.4.4.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ce ceVar) {
                                        ce ceVar2 = ceVar;
                                        ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                        ceVar2.fontWeight400();
                                        ceVar2.color(QUIToken.color$default("text_secondary"));
                                        ceVar2.text("\u4e2a\u4ee5\u4e0a\u6807\u7b7e\uff0c\u53d1\u73b0\u66f4\u591a\u540c\u597d\u5185\u5bb9");
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final NBPGuideNoviceSecondPageView nBPGuideNoviceSecondPageView3 = NBPGuideNoviceSecondPageView.this;
                viewContainer2.addChild(new NBPGuideTagPickerView(), new Function1<NBPGuideTagPickerView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideNoviceSecondPageView$body$1.5
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(NBPGuideTagPickerView nBPGuideTagPickerView) {
                        NBPGuideTagPickerView nBPGuideTagPickerView2 = nBPGuideTagPickerView;
                        final NBPGuideNoviceSecondPageView nBPGuideNoviceSecondPageView4 = NBPGuideNoviceSecondPageView.this;
                        nBPGuideTagPickerView2.attr(new Function1<NBPGuideTagPickerAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideNoviceSecondPageView.body.1.5.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(NBPGuideTagPickerAttr nBPGuideTagPickerAttr) {
                                NBPGuideTagPickerAttr nBPGuideTagPickerAttr2 = nBPGuideTagPickerAttr;
                                nBPGuideTagPickerAttr2.marginTop(24.0f);
                                NBPGuideNoviceViewModel viewModel = NBPGuideNoviceSecondPageView.access$getAttr(NBPGuideNoviceSecondPageView.this).getViewModel();
                                com.tencent.kuikly.core.reactive.collection.c<a> tagList = viewModel.getTagList();
                                ReadWriteProperty readWriteProperty = nBPGuideTagPickerAttr2.tagList$delegate;
                                KProperty<?>[] kPropertyArr = NBPGuideTagPickerAttr.$$delegatedProperties;
                                readWriteProperty.setValue(nBPGuideTagPickerAttr2, kPropertyArr[0], tagList);
                                nBPGuideTagPickerAttr2.selectedTagList$delegate.setValue(nBPGuideTagPickerAttr2, kPropertyArr[1], viewModel.getSelectedTagList());
                                return Unit.INSTANCE;
                            }
                        });
                        final NBPGuideNoviceSecondPageView nBPGuideNoviceSecondPageView5 = NBPGuideNoviceSecondPageView.this;
                        nBPGuideTagPickerView2.event(new Function1<NBPGuideTagPickerEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideNoviceSecondPageView.body.1.5.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(NBPGuideTagPickerEvent nBPGuideTagPickerEvent) {
                                final NBPGuideNoviceSecondPageView nBPGuideNoviceSecondPageView6 = NBPGuideNoviceSecondPageView.this;
                                nBPGuideTagPickerEvent.eventHandler = new Function1<a, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideNoviceSecondPageView.body.1.5.2.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(a aVar) {
                                        NBPGuideNoviceSecondPageView.access$handleClickTag(NBPGuideNoviceSecondPageView.this, aVar);
                                        return Unit.INSTANCE;
                                    }
                                };
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final NBPGuideNoviceSecondPageView nBPGuideNoviceSecondPageView4 = NBPGuideNoviceSecondPageView.this;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideNoviceSecondPageView$body$1.6
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideNoviceSecondPageView.body.1.6.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.m140flex(1.0f);
                                tVar2.allCenter();
                                return Unit.INSTANCE;
                            }
                        });
                        final NBPGuideNoviceSecondPageView nBPGuideNoviceSecondPageView5 = NBPGuideNoviceSecondPageView.this;
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideNoviceSecondPageView.body.1.6.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                v vVar4 = vVar3;
                                final NBPGuideNoviceSecondPageView nBPGuideNoviceSecondPageView6 = NBPGuideNoviceSecondPageView.this;
                                vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideNoviceSecondPageView.body.1.6.2.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.mo153width(168.0f);
                                        tVar2.mo141height(45.0f);
                                        tVar2.borderRadius(4.0f);
                                        tVar2.allCenter();
                                        if (NBPGuideNoviceSecondPageView.access$getAttr(NBPGuideNoviceSecondPageView.this).getViewModel().getSelectedTagList().size() >= 3) {
                                            tVar2.mo113backgroundColor(QUIToken.color$default("button_bg_primary_default"));
                                        } else {
                                            tVar2.mo113backgroundColor(QUIToken.color$default("button_bg_primary_disable"));
                                        }
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPGuideNoviceSecondPageView nBPGuideNoviceSecondPageView7 = NBPGuideNoviceSecondPageView.this;
                                cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideNoviceSecondPageView.body.1.6.2.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(TextView textView) {
                                        final NBPGuideNoviceSecondPageView nBPGuideNoviceSecondPageView8 = NBPGuideNoviceSecondPageView.this;
                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideNoviceSecondPageView.body.1.6.2.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ce ceVar) {
                                                ce ceVar2 = ceVar;
                                                ceVar2.text("\u8fdb\u5165\u9644\u8fd1");
                                                ce.fontSize$default(ceVar2, 17.0f, null, 2, null);
                                                ceVar2.fontWeight500();
                                                if (NBPGuideNoviceSecondPageView.access$getAttr(NBPGuideNoviceSecondPageView.this).getViewModel().getSelectedTagList().size() >= 3) {
                                                    ceVar2.color(QUIToken.color$default("button_text_primary_default"));
                                                } else {
                                                    ceVar2.color(QUIToken.color$default("button_text_primary_disable"));
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPGuideNoviceSecondPageView nBPGuideNoviceSecondPageView8 = NBPGuideNoviceSecondPageView.this;
                                vVar4.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideNoviceSecondPageView.body.1.6.2.3
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(u uVar) {
                                        final NBPGuideNoviceSecondPageView nBPGuideNoviceSecondPageView9 = NBPGuideNoviceSecondPageView.this;
                                        uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideNoviceSecondPageView.body.1.6.2.3.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ClickParams clickParams) {
                                                NBPGuideNoviceSecondPageView.access$handleEnter(NBPGuideNoviceSecondPageView.this);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final NBPGuideNoviceSecondPageView nBPGuideNoviceSecondPageView6 = NBPGuideNoviceSecondPageView.this;
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideNoviceSecondPageView.body.1.6.3
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                v vVar4 = vVar3;
                                vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideNoviceSecondPageView.body.1.6.3.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.marginTop(20.0f);
                                        tVar2.flexDirectionRow();
                                        tVar2.alignItemsCenter();
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPGuideNoviceSecondPageView nBPGuideNoviceSecondPageView7 = NBPGuideNoviceSecondPageView.this;
                                ah.a(vVar4, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideNoviceSecondPageView.body.1.6.3.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ImageView imageView) {
                                        final NBPGuideNoviceSecondPageView nBPGuideNoviceSecondPageView8 = NBPGuideNoviceSecondPageView.this;
                                        imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideNoviceSecondPageView.body.1.6.3.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(af afVar) {
                                                String str;
                                                af afVar2 = afVar;
                                                afVar2.mo153width(16.0f);
                                                afVar2.mo141height(16.0f);
                                                NBPGuideNoviceSecondPageView nBPGuideNoviceSecondPageView9 = NBPGuideNoviceSecondPageView.this;
                                                KProperty<Object>[] kPropertyArr = NBPGuideNoviceSecondPageView.$$delegatedProperties;
                                                if (nBPGuideNoviceSecondPageView9.isRadioCheck()) {
                                                    str = "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_ZCATJ1g2z78.png";
                                                } else {
                                                    str = "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_djC3mQb3WBF.png";
                                                }
                                                b.a.b(afVar2, str, false, 2, null);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideNoviceSecondPageView.body.1.6.3.3
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(TextView textView) {
                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideNoviceSecondPageView.body.1.6.3.3.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ce ceVar) {
                                                ce ceVar2 = ceVar;
                                                ceVar2.text("\u53d1\u5e03\u5174\u8da3\u6210\u5206\u5361\u5230\u9644\u8fd1");
                                                ceVar2.fontWeight400();
                                                ce.fontSize$default(ceVar2, 12.0f, null, 2, null);
                                                ceVar2.color(QUIToken.color$default("text_secondary"));
                                                ceVar2.marginLeft(7.0f);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPGuideNoviceSecondPageView nBPGuideNoviceSecondPageView8 = NBPGuideNoviceSecondPageView.this;
                                vVar4.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideNoviceSecondPageView.body.1.6.3.4
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(u uVar) {
                                        final NBPGuideNoviceSecondPageView nBPGuideNoviceSecondPageView9 = NBPGuideNoviceSecondPageView.this;
                                        uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideNoviceSecondPageView.body.1.6.3.4.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ClickParams clickParams) {
                                                NBPGuideNoviceSecondPageView nBPGuideNoviceSecondPageView10 = NBPGuideNoviceSecondPageView.this;
                                                KProperty<Object>[] kPropertyArr = NBPGuideNoviceSecondPageView.$$delegatedProperties;
                                                nBPGuideNoviceSecondPageView10.isRadioCheck$delegate.setValue(nBPGuideNoviceSecondPageView10, NBPGuideNoviceSecondPageView.$$delegatedProperties[0], Boolean.valueOf(!nBPGuideNoviceSecondPageView10.isRadioCheck()));
                                                e jsonWithPageParams = nBPGuideNoviceSecondPageView10.jsonWithPageParams();
                                                jsonWithPageParams.v("dt_eid", "em_nearby_publish_idcard");
                                                jsonWithPageParams.v(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
                                                Utils.INSTANCE.currentBridgeModule().reportCustomDtEvent("dt_clck", jsonWithPageParams);
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
                final NBPGuideNoviceSecondPageView nBPGuideNoviceSecondPageView5 = NBPGuideNoviceSecondPageView.this;
                ConditionViewKt.c(viewContainer2, new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideNoviceSecondPageView$body$1.7
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        NBPGuideNoviceViewModel viewModel = NBPGuideNoviceSecondPageView.access$getAttr(NBPGuideNoviceSecondPageView.this).getViewModel();
                        return Boolean.valueOf(((Boolean) viewModel.isEntering$delegate.getValue(viewModel, NBPGuideNoviceViewModel.$$delegatedProperties[9])).booleanValue());
                    }
                }, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideNoviceSecondPageView$body$1.8
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ConditionView conditionView) {
                        bb.b(conditionView, false, new Function1<ModalView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideNoviceSecondPageView.body.1.8.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ModalView modalView) {
                                ModalView modalView2 = modalView;
                                w.a(modalView2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideNoviceSecondPageView.body.1.8.1.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar) {
                                        v vVar2 = vVar;
                                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideNoviceSecondPageView.body.1.8.1.1.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                t tVar2 = tVar;
                                                tVar2.size(tVar2.getPagerData().m(), tVar2.getPagerData().l());
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        vVar2.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideNoviceSecondPageView.body.1.8.1.1.2
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(u uVar) {
                                                uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideNoviceSecondPageView.body.1.8.1.1.2.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final /* bridge */ /* synthetic */ Unit invoke(ClickParams clickParams) {
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                ECLoadingViewKt.ECLoading(modalView2, new Function1<ECLoadingView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideNoviceSecondPageView.body.1.8.1.2
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ECLoadingView eCLoadingView) {
                                        eCLoadingView.attr(new Function1<ECLoadingAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideNoviceSecondPageView.body.1.8.1.2.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ECLoadingAttr eCLoadingAttr) {
                                                ECLoadingAttr eCLoadingAttr2 = eCLoadingAttr;
                                                eCLoadingAttr2.delayShow = false;
                                                eCLoadingAttr2.setLoadingText("\u6b63\u5728\u8fdb\u5165...");
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        }, 1, null);
                        return Unit.INSTANCE;
                    }
                });
                return Unit.INSTANCE;
            }
        };
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return new NBPGuideNoviceSecondPageViewAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new NBPGuideNoviceSecondPageViewEvent();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.kuikly.core.base.ComposeView
    public final void created() {
        int collectionSizeOrDefault;
        super.created();
        com.tencent.kuikly.core.reactive.collection.c<a> selectedTagList = ((NBPGuideNoviceSecondPageViewAttr) getAttr()).getViewModel().getSelectedTagList();
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(selectedTagList, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<a> it = selectedTagList.iterator();
        while (it.hasNext()) {
            arrayList.add(Boolean.valueOf(getSelectedTagList().add(it.next())));
        }
    }

    public final com.tencent.kuikly.core.reactive.collection.c<a> getSelectedTagList() {
        return (com.tencent.kuikly.core.reactive.collection.c) this.selectedTagList$delegate.getValue(this, $$delegatedProperties[1]);
    }

    public final boolean isRadioCheck() {
        return ((Boolean) this.isRadioCheck$delegate.getValue(this, $$delegatedProperties[0])).booleanValue();
    }

    public final e jsonWithPageParams() {
        return AdelieCategoryHomePage$$ExternalSyntheticOutline0.m("dt_pgid", "pg_nearby_choose_interest");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void access$handleEnter(final NBPGuideNoviceSecondPageView nBPGuideNoviceSecondPageView) {
        List listOf;
        List mutableList;
        int collectionSizeOrDefault;
        List mutableList2;
        NBPGuideTagCardView b16;
        NBPGuideTagShareCardView b17;
        r25.e eVar;
        if (((NBPGuideNoviceSecondPageViewAttr) nBPGuideNoviceSecondPageView.getAttr()).getViewModel().getSelectedTagList().size() < 3) {
            Utils.INSTANCE.currentBridgeModule().qToast("\u81f3\u5c11\u8981\u9009\u62e93\u4e2a\u5174\u8da3\u54e6", QToastMode.Warning);
            return;
        }
        KLog kLog = KLog.INSTANCE;
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("[handleEnter]isRadioCheck: ");
        m3.append(nBPGuideNoviceSecondPageView.isRadioCheck());
        kLog.i("NBPGuideNoviceSecondPage", m3.toString());
        e jsonWithPageParams = nBPGuideNoviceSecondPageView.jsonWithPageParams();
        jsonWithPageParams.v("dt_eid", "em_nearby_enter_nearby_btn");
        jsonWithPageParams.t("nearby_check_publish_idcard", nBPGuideNoviceSecondPageView.isRadioCheck() ? 1 : 0);
        jsonWithPageParams.v(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
        Utils.INSTANCE.currentBridgeModule().reportCustomDtEvent("dt_clck", jsonWithPageParams);
        NBPGuideNoviceViewModel viewModel = ((NBPGuideNoviceSecondPageViewAttr) nBPGuideNoviceSecondPageView.getAttr()).getViewModel();
        ReadWriteProperty readWriteProperty = viewModel.isEntering$delegate;
        KProperty<?>[] kPropertyArr = NBPGuideNoviceViewModel.$$delegatedProperties;
        readWriteProperty.setValue(viewModel, kPropertyArr[9], Boolean.TRUE);
        final Function0<Unit> function0 = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideNoviceSecondPageView$handleEnter$onFinish$1
            {
                super(0);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function0
            public final Unit invoke() {
                Function0<Unit> function02 = ((NBPGuideNoviceSecondPageViewEvent) NBPGuideNoviceSecondPageView.this.getViewEvent()).onNextEventHandler;
                if (function02 == null) {
                    return null;
                }
                function02.invoke();
                return Unit.INSTANCE;
            }
        };
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Integer[]{1, 2, 3, 7});
        NBPGuideNoviceViewModel viewModel2 = ((NBPGuideNoviceSecondPageViewAttr) nBPGuideNoviceSecondPageView.getAttr()).getViewModel();
        String str = (String) viewModel2.avatar$delegate.getValue(viewModel2, kPropertyArr[1]);
        String nick = ((NBPGuideNoviceSecondPageViewAttr) nBPGuideNoviceSecondPageView.getAttr()).getViewModel().getNick();
        NBPGuideNoviceViewModel viewModel3 = ((NBPGuideNoviceSecondPageViewAttr) nBPGuideNoviceSecondPageView.getAttr()).getViewModel();
        s35.af afVar = new s35.af(null, 0L, nick, 0, null, ((NBPGuideNoviceSecondPageViewAttr) nBPGuideNoviceSecondPageView.getAttr()).getViewModel().getGender(), new d(((Number) viewModel3.birthdayYear$delegate.getValue(viewModel3, kPropertyArr[4])).intValue(), ((NBPGuideNoviceSecondPageViewAttr) nBPGuideNoviceSecondPageView.getAttr()).getViewModel().getBirthdayMonth(), ((NBPGuideNoviceSecondPageViewAttr) nBPGuideNoviceSecondPageView.getAttr()).getViewModel().getBirthdayDay()), null, str, null, null, null, null, null, 0, false, null, null, null, 0, 0, null, null, 0, 0, 0, null, null, null, null, 0, null, null, null, null, null, null, false, false, -357, 255);
        NBPGuideNoviceSecondPageView$handleEnter$2 nBPGuideNoviceSecondPageView$handleEnter$2 = new Function1<s35.v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideNoviceSecondPageView$handleEnter$2
            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(s35.v vVar) {
                KLog.INSTANCE.i("NBPGuideNoviceSecondPage", "[handleEnter]setUserInfo success");
                return Unit.INSTANCE;
            }
        };
        NBPGuideNoviceSecondPageView$handleEnter$3 nBPGuideNoviceSecondPageView$handleEnter$3 = new Function2<Integer, String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideNoviceSecondPageView$handleEnter$3
            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Integer num, String str2) {
                int intValue = num.intValue();
                KLog.INSTANCE.e("NBPGuideNoviceSecondPage", "[handleEnter]setUserInfo error: [" + intValue + ']' + str2);
                return Unit.INSTANCE;
            }
        };
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) listOf);
        s35.u uVar = new s35.u(mutableList, afVar, 0);
        NBPNewEditRepository$setUserInfo$1 nBPNewEditRepository$setUserInfo$1 = new NBPNewEditRepository$setUserInfo$1(2, nBPGuideNoviceSecondPageView$handleEnter$2, nBPGuideNoviceSecondPageView$handleEnter$3);
        QQStrangerSsoRequest qQStrangerSsoRequest = new QQStrangerSsoRequest(new u35.a("QQStranger.UserInfo", "SsoSetUserInfo", 2, new c45.a(i.d(uVar))));
        QQStrangerSsoService$sendProxyRequest$1 qQStrangerSsoService$sendProxyRequest$1 = new QQStrangerSsoService$sendProxyRequest$1(nBPNewEditRepository$setUserInfo$1);
        APICallTechReporter aPICallTechReporter = new APICallTechReporter(1, "trpc.qqstranger.common_proxy.CommonProxy.SsoHandle");
        QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
        NBPArticleFeedItemView$body$1$3$8$1$2$1$$ExternalSyntheticOutline0.m(aPICallTechReporter, qQStrangerSsoService$sendProxyRequest$1, qQStrangerSsoRequest, null, 6);
        com.tencent.kuikly.core.reactive.collection.c<a> selectedTagList = ((NBPGuideNoviceSecondPageViewAttr) nBPGuideNoviceSecondPageView.getAttr()).getViewModel().getSelectedTagList();
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(selectedTagList, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<a> it = selectedTagList.iterator();
        while (it.hasNext()) {
            arrayList.add(Integer.valueOf(it.next().f435362d));
        }
        NBPGuideNoviceSecondPageView$handleEnter$5 nBPGuideNoviceSecondPageView$handleEnter$5 = new Function1<ae, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideNoviceSecondPageView$handleEnter$5
            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ae aeVar) {
                KLog.INSTANCE.i("NBPGuideNoviceSecondPage", "[handleEnter]updateTagsInfo success");
                return Unit.INSTANCE;
            }
        };
        NBPGuideNoviceSecondPageView$handleEnter$6 nBPGuideNoviceSecondPageView$handleEnter$6 = NBPGuideNoviceSecondPageView$handleEnter$6.INSTANCE;
        if (QQKuiklyPlatformApi.Companion.getNetworkType() != QQKuiklyPlatformApi.QQNetworkType.NOT_REACHABLE) {
            mutableList2 = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList);
            NBPArticleFeedItemView$body$1$3$8$1$2$1$$ExternalSyntheticOutline0.m(new APICallTechReporter(1, "trpc.qqstranger.common_proxy.CommonProxy.SsoHandle"), new QQStrangerSsoService$sendProxyRequest$1(new NBPNewHomeRepository$updateTagsInfo$1(2, nBPGuideNoviceSecondPageView$handleEnter$5, nBPGuideNoviceSecondPageView$handleEnter$6)), new QQStrangerSsoRequest(new u35.a("QQStranger.UserInfo", "SsoUpdateUserTags", 2, new c45.a(i.d(new ad(mutableList2, 0, 0))))), null, 6);
        } else {
            nBPGuideNoviceSecondPageView$handleEnter$6.invoke(-1, "network unreachable");
        }
        g loginRsp = ((NBPGuideNoviceSecondPageViewAttr) nBPGuideNoviceSecondPageView.getAttr()).getViewModel().getLoginRsp();
        if (loginRsp != null && (eVar = loginRsp.f397801e) != null) {
            String str2 = "SelfUserInfoByteArray_2" + util.base64_pad_url + String.valueOf(eVar.f430610d);
            MemoryCacheModule memoryCacheModule = (MemoryCacheModule) com.tencent.kuikly.core.manager.c.f117352a.g().acquireModule("KRMemoryCacheModule");
            NearbyConst nearbyConst = NearbyConst.INSTANCE;
            memoryCacheModule.c("nearbypro", str2);
        }
        if (nBPGuideNoviceSecondPageView.isRadioCheck()) {
            aa<NBPGuideTagCardView> aaVar = nBPGuideNoviceSecondPageView.tagCardViewRef;
            if (aaVar == null || (b16 = aaVar.b()) == null) {
                return;
            }
            Function1<String, Unit> function1 = new Function1<String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideNoviceSecondPageView$handleEnter$8
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(String str3) {
                    k kVar;
                    String str4 = str3;
                    if (str4 == null) {
                        KLog.INSTANCE.e("NBPGuideNoviceSecondPage", "[handleEnter]getSharePhotoPath error: photoPath is null");
                        Utils.INSTANCE.currentBridgeModule().qToast("\u670d\u52a1\u5668\u7e41\u5fd9\uff0c\u53d1\u5e03\u5931\u8d25!", QToastMode.Warning);
                        function0.invoke();
                    } else {
                        NBPUserSelfInfo userSelfInfo = UserDataManager.INSTANCE.getUserSelfInfo();
                        boolean z16 = false;
                        if (QQNearbyModule.Companion.getInstance().hadLocationPermission()) {
                            if (userSelfInfo.locationAddress.length() > 0) {
                                z16 = true;
                            }
                        }
                        CategoryListFooterKt$CategoryListFooter$1$1$$ExternalSyntheticOutline0.m("[handleEnter]publish start: ", z16, KLog.INSTANCE, "NBPGuideNoviceSecondPage");
                        if (z16) {
                            NBPLatLng nBPLatLng = userSelfInfo.latLng;
                            double d16 = 1000000;
                            n25.i iVar = new n25.i((long) (nBPLatLng.latitude * d16), (long) (nBPLatLng.longitude * d16), 12);
                            String str5 = userSelfInfo.locationAddress;
                            String str6 = userSelfInfo.locationCountry;
                            String str7 = userSelfInfo.locationProvince;
                            String str8 = userSelfInfo.locationCity;
                            String str9 = userSelfInfo.locationDistrict;
                            String str10 = userSelfInfo.locationName;
                            kVar = new k((String) null, str10, 0, (String) null, str5, 0, iVar, 0, 0, (String) null, str6, str7, str8, 0, 0, (String) null, str9, (String) null, (String) null, str10, 1500077);
                        } else {
                            kVar = null;
                        }
                        k kVar2 = kVar;
                        NBPPublishService nBPPublishService = NBPPublishService.INSTANCE;
                        NBPPublishConfig nBPPublishConfig = new NBPPublishConfig("8", str4, null, null, kVar2, null, null, kVar2 != null ? 2 : 3, 236);
                        final NBPGuideNoviceSecondPageView nBPGuideNoviceSecondPageView2 = nBPGuideNoviceSecondPageView;
                        final Function0<Unit> function02 = function0;
                        nBPPublishService.publish(nBPPublishConfig, new Function3<Boolean, f, String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideNoviceSecondPageView$handleEnter$8.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public final Unit invoke(Boolean bool, f fVar, String str11) {
                                boolean booleanValue = bool.booleanValue();
                                NBPGuideNoviceViewModel viewModel4 = NBPGuideNoviceSecondPageView.access$getAttr(NBPGuideNoviceSecondPageView.this).getViewModel();
                                viewModel4.isEntering$delegate.setValue(viewModel4, NBPGuideNoviceViewModel.$$delegatedProperties[9], Boolean.FALSE);
                                KLog.INSTANCE.i("NBPGuideNoviceSecondPage", "[handleEnter]publish default: " + booleanValue + ", " + str11);
                                function02.invoke();
                                return Unit.INSTANCE;
                            }
                        });
                    }
                    return Unit.INSTANCE;
                }
            };
            aa<NBPGuideTagShareCardView> aaVar2 = b16.guideTagShareCardViewRef;
            if (aaVar2 == null || (b17 = aaVar2.b()) == null) {
                return;
            }
            KProperty<Object>[] kPropertyArr2 = NBPGuideTagShareCardView.$$delegatedProperties;
            b17.getSharePhotoPath(function1, 0);
            return;
        }
        function0.invoke();
    }
}
