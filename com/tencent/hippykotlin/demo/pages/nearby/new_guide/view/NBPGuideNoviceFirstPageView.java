package com.tencent.hippykotlin.demo.pages.nearby.new_guide.view;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieCategoryHomePage$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.QToastMode;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQCommonNApiModule;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedItemView$body$1$3$3$3$3$1$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.nearby.base.module.QQNearbyModule;
import com.tencent.hippykotlin.demo.pages.nearby.base.utils.FastClickUtils;
import com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPJumpUtil;
import com.tencent.hippykotlin.demo.pages.nearby.new_guide.NBPGuideNoviceViewModel;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.BorderStyle;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.aa;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.attr.d;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.base.u;
import com.tencent.kuikly.core.base.y;
import com.tencent.kuikly.core.directives.LoopDirectivesView;
import com.tencent.kuikly.core.directives.LoopDirectivesViewKt;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.PageListEvent;
import com.tencent.kuikly.core.views.PageListView;
import com.tencent.kuikly.core.views.ScrollParams;
import com.tencent.kuikly.core.views.ScrollerView;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ah;
import com.tencent.kuikly.core.views.be;
import com.tencent.kuikly.core.views.bf;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* loaded from: classes31.dex */
public final class NBPGuideNoviceFirstPageView extends ComposeView<NBPGuideNoviceFirstPageViewAttr, NBPGuideNoviceFirstPageViewEvent> {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPGuideNoviceFirstPageView.class, "cardDataList", "getCardDataList()Lcom/tencent/kuikly/core/reactive/collection/ObservableList;", 0)};
    public final ReadWriteProperty cardDataList$delegate = c.b();
    public final FastClickUtils fastClickUtils = new FastClickUtils(500);
    public aa<PageListView<?, ?>> pageListViewRef;

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ NBPGuideNoviceFirstPageViewAttr access$getAttr(NBPGuideNoviceFirstPageView nBPGuideNoviceFirstPageView) {
        return (NBPGuideNoviceFirstPageViewAttr) nBPGuideNoviceFirstPageView.getAttr();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void access$handleNext(NBPGuideNoviceFirstPageView nBPGuideNoviceFirstPageView) {
        if (((NBPGuideNoviceFirstPageViewAttr) nBPGuideNoviceFirstPageView.getAttr()).getViewModel().getNick().length() == 0) {
            Utils.INSTANCE.currentBridgeModule().qToast("\u6635\u79f0\u4e0d\u80fd\u4e3a\u7a7a\u54e6", QToastMode.Warning);
            return;
        }
        e jsonWithPageParams = nBPGuideNoviceFirstPageView.jsonWithPageParams();
        jsonWithPageParams.v("dt_eid", "em_nearby_next_btn");
        jsonWithPageParams.t("nearby_gender", ((NBPGuideNoviceFirstPageViewAttr) nBPGuideNoviceFirstPageView.getAttr()).getViewModel().getGender());
        NBPGuideNoviceViewModel.Companion.getClass();
        jsonWithPageParams.t("nearby_constellation", NBPGuideNoviceViewModel.CONSTELLATION_LIST.indexOf(((NBPGuideNoviceFirstPageViewAttr) nBPGuideNoviceFirstPageView.getAttr()).getViewModel().getConstellation()) + 1);
        jsonWithPageParams.v(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
        Utils.INSTANCE.currentBridgeModule().reportCustomDtEvent("dt_clck", jsonWithPageParams);
        Function0<Unit> function0 = ((NBPGuideNoviceFirstPageViewEvent) nBPGuideNoviceFirstPageView.getViewEvent()).onNextEventHandler;
        if (function0 != null) {
            function0.invoke();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void access$showDatePicker(NBPGuideNoviceFirstPageView nBPGuideNoviceFirstPageView) {
        if (nBPGuideNoviceFirstPageView.fastClickUtils.isFastDoubleClick()) {
            return;
        }
        e jsonWithPageParams = nBPGuideNoviceFirstPageView.jsonWithPageParams();
        jsonWithPageParams.v("dt_eid", "em_nearby_constellation_btn");
        jsonWithPageParams.v(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
        Utils.INSTANCE.currentBridgeModule().reportCustomDtEvent("dt_clck", jsonWithPageParams);
        final NBPGuideNoviceViewModel viewModel = ((NBPGuideNoviceFirstPageViewAttr) nBPGuideNoviceFirstPageView.getAttr()).getViewModel();
        QQNearbyModule.Companion.getInstance().showKLDatePicker(((Number) viewModel.birthdayYear$delegate.getValue(viewModel, NBPGuideNoviceViewModel.$$delegatedProperties[4])).intValue(), viewModel.getBirthdayMonth(), viewModel.getBirthdayDay(), new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideNoviceFirstPageView$showDatePicker$2$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(e eVar) {
                e eVar2 = eVar;
                if (eVar2 != null) {
                    NBPGuideNoviceViewModel nBPGuideNoviceViewModel = NBPGuideNoviceViewModel.this;
                    int j3 = eVar2.j("year");
                    ReadWriteProperty readWriteProperty = nBPGuideNoviceViewModel.birthdayYear$delegate;
                    KProperty<?>[] kPropertyArr = NBPGuideNoviceViewModel.$$delegatedProperties;
                    readWriteProperty.setValue(nBPGuideNoviceViewModel, kPropertyArr[4], Integer.valueOf(j3));
                    nBPGuideNoviceViewModel.birthdayMonth$delegate.setValue(nBPGuideNoviceViewModel, kPropertyArr[5], Integer.valueOf(eVar2.j("month")));
                    nBPGuideNoviceViewModel.birthdayDay$delegate.setValue(nBPGuideNoviceViewModel, kPropertyArr[6], Integer.valueOf(eVar2.j("day")));
                }
                return Unit.INSTANCE;
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void access$showGenderPicker(final NBPGuideNoviceFirstPageView nBPGuideNoviceFirstPageView) {
        if (nBPGuideNoviceFirstPageView.fastClickUtils.isFastDoubleClick()) {
            return;
        }
        e jsonWithPageParams = nBPGuideNoviceFirstPageView.jsonWithPageParams();
        jsonWithPageParams.v("dt_eid", "em_nearby_gender_btn");
        jsonWithPageParams.v(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
        Utils.INSTANCE.currentBridgeModule().reportCustomDtEvent("dt_clck", jsonWithPageParams);
        int gender = ((NBPGuideNoviceFirstPageViewAttr) nBPGuideNoviceFirstPageView.getAttr()).getViewModel().getGender();
        int i3 = 1;
        if (gender == 1) {
            i3 = 0;
        } else if (gender != 2) {
            i3 = -1;
        }
        QQNearbyModule.Companion.getInstance().showKLGenderPicker(i3, new Function1<Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideNoviceFirstPageView$showGenderPicker$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Integer num) {
                Integer num2 = num;
                if (num2 != null) {
                    NBPGuideNoviceFirstPageView nBPGuideNoviceFirstPageView2 = NBPGuideNoviceFirstPageView.this;
                    int intValue = num2.intValue();
                    NBPGuideNoviceViewModel viewModel = NBPGuideNoviceFirstPageView.access$getAttr(nBPGuideNoviceFirstPageView2).getViewModel();
                    viewModel.gender$delegate.setValue(viewModel, NBPGuideNoviceViewModel.$$delegatedProperties[2], Integer.valueOf(intValue));
                    nBPGuideNoviceFirstPageView2.updateCardDataList();
                    nBPGuideNoviceFirstPageView2.handleScrollOffset(0.0f);
                }
                return Unit.INSTANCE;
            }
        });
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideNoviceFirstPageView$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideNoviceFirstPageView$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        mVar2.flexDirectionColumn();
                        mVar2.alignItemsCenter();
                        mVar2.size(mVar2.getPagerData().m(), mVar2.getPagerData().l());
                        mVar2.mo113backgroundColor(QUIToken.color$default("bg_bottom_light"));
                        return Unit.INSTANCE;
                    }
                });
                ah.a(viewContainer2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideNoviceFirstPageView$body$1.2
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ImageView imageView) {
                        imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideNoviceFirstPageView.body.1.2.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(af afVar) {
                                String str;
                                af afVar2 = afVar;
                                QQCommonNApiModule.Companion companion = QQCommonNApiModule.Companion;
                                if (((QQCommonNApiModule) com.tencent.kuikly.core.manager.c.f117352a.g().acquireModule("QQCommonNApiModule")).isDarkTheme()) {
                                    str = "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_usWZbbItXCP.png";
                                } else {
                                    str = "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_XzZizBeq83m.png";
                                }
                                b.a.b(afVar2, str, false, 2, null);
                                afVar2.positionAbsolute();
                                afVar2.m150top(0.0f);
                                afVar2.m142left(0.0f);
                                afVar2.size(afVar2.getPagerData().m(), afVar2.getPagerData().m());
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final NBPGuideNoviceFirstPageView nBPGuideNoviceFirstPageView = NBPGuideNoviceFirstPageView.this;
                viewContainer2.addChild(new NBPGuideNoviceNavBarView(), new Function1<NBPGuideNoviceNavBarView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideNoviceFirstPageView$body$1.3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(NBPGuideNoviceNavBarView nBPGuideNoviceNavBarView) {
                        NBPGuideNoviceNavBarView nBPGuideNoviceNavBarView2 = nBPGuideNoviceNavBarView;
                        nBPGuideNoviceNavBarView2.attr(new Function1<NBPGuideNoviceNavBarAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideNoviceFirstPageView.body.1.3.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(NBPGuideNoviceNavBarAttr nBPGuideNoviceNavBarAttr) {
                                nBPGuideNoviceNavBarAttr.alignSelfStretch();
                                return Unit.INSTANCE;
                            }
                        });
                        final NBPGuideNoviceFirstPageView nBPGuideNoviceFirstPageView2 = NBPGuideNoviceFirstPageView.this;
                        nBPGuideNoviceNavBarView2.event(new Function1<NBPGuideNoviceNavBarEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideNoviceFirstPageView.body.1.3.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(NBPGuideNoviceNavBarEvent nBPGuideNoviceNavBarEvent) {
                                final NBPGuideNoviceFirstPageView nBPGuideNoviceFirstPageView3 = NBPGuideNoviceFirstPageView.this;
                                nBPGuideNoviceNavBarEvent.clickBackBtnHandlerFn = new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideNoviceFirstPageView.body.1.3.2.1
                                    {
                                        super(1);
                                    }

                                    /* JADX WARN: Multi-variable type inference failed */
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(Object obj) {
                                        Function0<Unit> function0 = ((NBPGuideNoviceFirstPageViewEvent) NBPGuideNoviceFirstPageView.this.getViewEvent()).onBackEventHandler;
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
                ah.a(viewContainer2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideNoviceFirstPageView$body$1.4
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ImageView imageView) {
                        imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideNoviceFirstPageView.body.1.4.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(af afVar) {
                                af afVar2 = afVar;
                                b.a.b(afVar2, "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_ipwt6LU6h10.png", false, 2, null);
                                afVar2.o();
                                afVar2.marginTop(-14.0f);
                                afVar2.mo153width(47.46f);
                                afVar2.mo141height(58.42f);
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                cg.a(viewContainer2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideNoviceFirstPageView$body$1.5
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(TextView textView) {
                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideNoviceFirstPageView.body.1.5.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ce ceVar) {
                                ce ceVar2 = ceVar;
                                ceVar2.marginTop(10.0f);
                                ceVar2.text("\u7528\u8eab\u8fb9\u7684\u4e8b");
                                ce.fontSize$default(ceVar2, 22.0f, null, 2, null);
                                ceVar2.color(QUIToken.color$default("text_primary"));
                                ceVar2.fontWeight600();
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                cg.a(viewContainer2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideNoviceFirstPageView$body$1.6
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(TextView textView) {
                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideNoviceFirstPageView.body.1.6.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ce ceVar) {
                                ce ceVar2 = ceVar;
                                ceVar2.marginTop(5.0f);
                                ceVar2.text("{ \u8fde\u63a5\u8eab\u8fb9\u7684\u4eba }");
                                ce.fontSize$default(ceVar2, 22.0f, null, 2, null);
                                ceVar2.color(QUIToken.color$default("text_primary"));
                                ceVar2.fontWeight600();
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final NBPGuideNoviceFirstPageView nBPGuideNoviceFirstPageView2 = NBPGuideNoviceFirstPageView.this;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideNoviceFirstPageView$body$1.7
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideNoviceFirstPageView.body.1.7.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.m140flex(1.0f);
                                tVar2.allCenter();
                                return Unit.INSTANCE;
                            }
                        });
                        final NBPGuideNoviceFirstPageView nBPGuideNoviceFirstPageView3 = NBPGuideNoviceFirstPageView.this;
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideNoviceFirstPageView.body.1.7.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                v vVar4 = vVar3;
                                vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideNoviceFirstPageView.body.1.7.2.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.flexDirectionColumn();
                                        tVar2.alignItemsCenter();
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPGuideNoviceFirstPageView nBPGuideNoviceFirstPageView4 = NBPGuideNoviceFirstPageView.this;
                                w.a(vVar4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideNoviceFirstPageView.body.1.7.2.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar5) {
                                        v vVar6 = vVar5;
                                        vVar6.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideNoviceFirstPageView.body.1.7.2.2.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                tVar.alignItemsCenter();
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final NBPGuideNoviceFirstPageView nBPGuideNoviceFirstPageView5 = NBPGuideNoviceFirstPageView.this;
                                        bf.a(vVar6, new Function1<PageListView<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideNoviceFirstPageView.body.1.7.2.2.2
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(PageListView<?, ?> pageListView) {
                                                PageListView<?, ?> pageListView2 = pageListView;
                                                final NBPGuideNoviceFirstPageView nBPGuideNoviceFirstPageView6 = NBPGuideNoviceFirstPageView.this;
                                                pageListView2.ref(pageListView2, new Function1<aa<PageListView<?, ?>>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideNoviceFirstPageView.body.1.7.2.2.2.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(aa<PageListView<?, ?>> aaVar) {
                                                        NBPGuideNoviceFirstPageView.this.pageListViewRef = aaVar;
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final NBPGuideNoviceFirstPageView nBPGuideNoviceFirstPageView7 = NBPGuideNoviceFirstPageView.this;
                                                pageListView2.attr(new Function1<be, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideNoviceFirstPageView.body.1.7.2.2.2.2
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(be beVar) {
                                                        be beVar2 = beVar;
                                                        beVar2.pageItemWidth(NBPGuideViewConstKt.pageViewFitWidth(NBPGuideNoviceFirstPageView.this));
                                                        beVar2.pageItemHeight(NBPGuideViewConstKt.pageViewFitWidth(NBPGuideNoviceFirstPageView.this) * 0.43f);
                                                        beVar2.flexDirectionRow();
                                                        beVar2.overflow(false);
                                                        beVar2.showScrollerIndicator(false);
                                                        beVar2.defaultPageIndex(0);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final NBPGuideNoviceFirstPageView nBPGuideNoviceFirstPageView8 = NBPGuideNoviceFirstPageView.this;
                                                pageListView2.event(new Function1<PageListEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideNoviceFirstPageView.body.1.7.2.2.2.3
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(PageListEvent pageListEvent) {
                                                        PageListEvent pageListEvent2 = pageListEvent;
                                                        final NBPGuideNoviceFirstPageView nBPGuideNoviceFirstPageView9 = NBPGuideNoviceFirstPageView.this;
                                                        pageListEvent2.scroll(true, new Function1<ScrollParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideNoviceFirstPageView.body.1.7.2.2.2.3.1
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ScrollParams scrollParams) {
                                                                NBPGuideNoviceFirstPageView nBPGuideNoviceFirstPageView10 = NBPGuideNoviceFirstPageView.this;
                                                                float offsetX = scrollParams.getOffsetX();
                                                                KProperty<Object>[] kPropertyArr = NBPGuideNoviceFirstPageView.$$delegatedProperties;
                                                                nBPGuideNoviceFirstPageView10.handleScrollOffset(offsetX);
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        final NBPGuideNoviceFirstPageView nBPGuideNoviceFirstPageView10 = NBPGuideNoviceFirstPageView.this;
                                                        pageListEvent2.pageIndexDidChanged(new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideNoviceFirstPageView.body.1.7.2.2.2.3.2
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(Object obj) {
                                                                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.tencent.kuikly.core.nvi.serialization.json.JSONObject");
                                                                int j3 = ((e) obj).j("index");
                                                                if (j3 >= 0) {
                                                                    NBPGuideNoviceFirstPageView nBPGuideNoviceFirstPageView11 = NBPGuideNoviceFirstPageView.this;
                                                                    KProperty<Object>[] kPropertyArr = NBPGuideNoviceFirstPageView.$$delegatedProperties;
                                                                    if (j3 < nBPGuideNoviceFirstPageView11.getCardDataList().size()) {
                                                                        NBPGuideNoviceViewModel viewModel = NBPGuideNoviceFirstPageView.access$getAttr(NBPGuideNoviceFirstPageView.this).getViewModel();
                                                                        GalleryCardData galleryCardData = NBPGuideNoviceFirstPageView.this.getCardDataList().get(j3);
                                                                        viewModel.avatar$delegate.setValue(viewModel, NBPGuideNoviceViewModel.$$delegatedProperties[1], (String) galleryCardData.avatarUrl$delegate.getValue(galleryCardData, GalleryCardData.$$delegatedProperties[0]));
                                                                    }
                                                                }
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final NBPGuideNoviceFirstPageView nBPGuideNoviceFirstPageView9 = NBPGuideNoviceFirstPageView.this;
                                                Function0<com.tencent.kuikly.core.reactive.collection.c<GalleryCardData>> function0 = new Function0<com.tencent.kuikly.core.reactive.collection.c<GalleryCardData>>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideNoviceFirstPageView.body.1.7.2.2.2.4
                                                    {
                                                        super(0);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function0
                                                    public final com.tencent.kuikly.core.reactive.collection.c<GalleryCardData> invoke() {
                                                        NBPGuideNoviceFirstPageView nBPGuideNoviceFirstPageView10 = NBPGuideNoviceFirstPageView.this;
                                                        KProperty<Object>[] kPropertyArr = NBPGuideNoviceFirstPageView.$$delegatedProperties;
                                                        return nBPGuideNoviceFirstPageView10.getCardDataList();
                                                    }
                                                };
                                                final NBPGuideNoviceFirstPageView nBPGuideNoviceFirstPageView10 = NBPGuideNoviceFirstPageView.this;
                                                LoopDirectivesViewKt.a(pageListView2, function0, new Function2<LoopDirectivesView<GalleryCardData>, GalleryCardData, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideNoviceFirstPageView.body.1.7.2.2.2.5
                                                    {
                                                        super(2);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function2
                                                    public final Unit invoke(LoopDirectivesView<GalleryCardData> loopDirectivesView, GalleryCardData galleryCardData) {
                                                        final GalleryCardData galleryCardData2 = galleryCardData;
                                                        final NBPGuideNoviceFirstPageView nBPGuideNoviceFirstPageView11 = NBPGuideNoviceFirstPageView.this;
                                                        w.a(loopDirectivesView, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideNoviceFirstPageView.body.1.7.2.2.2.5.1
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(v vVar7) {
                                                                v vVar8 = vVar7;
                                                                final GalleryCardData galleryCardData3 = GalleryCardData.this;
                                                                vVar8.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideNoviceFirstPageView.body.1.7.2.2.2.5.1.1
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(t tVar) {
                                                                        t tVar2 = tVar;
                                                                        tVar2.allCenter();
                                                                        GalleryCardData galleryCardData4 = GalleryCardData.this;
                                                                        ReadWriteProperty readWriteProperty = galleryCardData4.opacity$delegate;
                                                                        KProperty<?>[] kPropertyArr = GalleryCardData.$$delegatedProperties;
                                                                        tVar2.m147opacity(((Number) readWriteProperty.getValue(galleryCardData4, kPropertyArr[3])).floatValue());
                                                                        GalleryCardData galleryCardData5 = GalleryCardData.this;
                                                                        float floatValue = ((Number) galleryCardData5.transformScale$delegate.getValue(galleryCardData5, kPropertyArr[1])).floatValue();
                                                                        GalleryCardData galleryCardData6 = GalleryCardData.this;
                                                                        d.a.a(tVar2, null, new u(floatValue, ((Number) galleryCardData6.transformScale$delegate.getValue(galleryCardData6, kPropertyArr[1])).floatValue()), new y(GalleryCardData.this.getTransformTranslateX(), 0.0f, 0.0f, 0.0f, 14, null), null, null, 25, null);
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                final GalleryCardData galleryCardData4 = GalleryCardData.this;
                                                                final NBPGuideNoviceFirstPageView nBPGuideNoviceFirstPageView12 = nBPGuideNoviceFirstPageView11;
                                                                ah.a(vVar8, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideNoviceFirstPageView.body.1.7.2.2.2.5.1.2
                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(ImageView imageView) {
                                                                        final GalleryCardData galleryCardData5 = GalleryCardData.this;
                                                                        final NBPGuideNoviceFirstPageView nBPGuideNoviceFirstPageView13 = nBPGuideNoviceFirstPageView12;
                                                                        imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideNoviceFirstPageView.body.1.7.2.2.2.5.1.2.1
                                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                            {
                                                                                super(1);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(af afVar) {
                                                                                af afVar2 = afVar;
                                                                                GalleryCardData galleryCardData6 = GalleryCardData.this;
                                                                                b.a.b(afVar2, (String) galleryCardData6.avatarUrl$delegate.getValue(galleryCardData6, GalleryCardData.$$delegatedProperties[0]), false, 2, null);
                                                                                afVar2.size(NBPGuideViewConstKt.pageViewFitWidth(nBPGuideNoviceFirstPageView13) * 0.43f, NBPGuideViewConstKt.pageViewFitWidth(nBPGuideNoviceFirstPageView13) * 0.43f);
                                                                                afVar2.p();
                                                                                afVar2.borderRadius((NBPGuideViewConstKt.pageViewFitWidth(nBPGuideNoviceFirstPageView13) * 0.43f) / 2);
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
                                });
                                w.a(vVar4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideNoviceFirstPageView.body.1.7.2.3
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar5) {
                                        v vVar6 = vVar5;
                                        vVar6.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideNoviceFirstPageView.body.1.7.2.3.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                tVar.marginTop(12.0f);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        cg.a(vVar6, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideNoviceFirstPageView.body.1.7.2.3.2
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(TextView textView) {
                                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideNoviceFirstPageView.body.1.7.2.3.2.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ce ceVar) {
                                                        ce ceVar2 = ceVar;
                                                        ceVar2.fontWeight400();
                                                        ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                                        ceVar2.color(QUIToken.color$default("text_secondary"));
                                                        ceVar2.text("\u6ed1\u52a8\u9009\u62e9\u4f60\u7684\u5934\u50cf");
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPGuideNoviceFirstPageView nBPGuideNoviceFirstPageView5 = NBPGuideNoviceFirstPageView.this;
                                w.a(vVar4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideNoviceFirstPageView.body.1.7.2.4
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar5) {
                                        v vVar6 = vVar5;
                                        vVar6.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideNoviceFirstPageView.body.1.7.2.4.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                t tVar2 = tVar;
                                                tVar2.marginTop(24.0f);
                                                tVar2.size(162.0f, 42.0f);
                                                tVar2.allCenter();
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final NBPGuideNoviceFirstPageView nBPGuideNoviceFirstPageView6 = NBPGuideNoviceFirstPageView.this;
                                        cg.a(vVar6, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideNoviceFirstPageView.body.1.7.2.4.2
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(TextView textView) {
                                                final NBPGuideNoviceFirstPageView nBPGuideNoviceFirstPageView7 = NBPGuideNoviceFirstPageView.this;
                                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideNoviceFirstPageView.body.1.7.2.4.2.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ce ceVar) {
                                                        ce ceVar2 = ceVar;
                                                        ceVar2.fontWeightMedium();
                                                        NBPArticleFeedItemView$body$1$3$3$3$3$1$1$$ExternalSyntheticOutline0.m(ceVar2, 16.0f, null, 2, null, "text_primary");
                                                        ceVar2.text(NBPGuideNoviceFirstPageView.access$getAttr(NBPGuideNoviceFirstPageView.this).getViewModel().getNick());
                                                        ceVar2.lines(1);
                                                        ceVar2.textOverFlowTail();
                                                        ceVar2.m144maxWidth(162.0f);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final NBPGuideNoviceFirstPageView nBPGuideNoviceFirstPageView7 = NBPGuideNoviceFirstPageView.this;
                                        vVar6.event(new Function1<com.tencent.kuikly.core.views.u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideNoviceFirstPageView.body.1.7.2.4.3
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(com.tencent.kuikly.core.views.u uVar) {
                                                final NBPGuideNoviceFirstPageView nBPGuideNoviceFirstPageView8 = NBPGuideNoviceFirstPageView.this;
                                                uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideNoviceFirstPageView.body.1.7.2.4.3.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ClickParams clickParams) {
                                                        if (!NBPGuideNoviceFirstPageView.this.fastClickUtils.isFastDoubleClick()) {
                                                            NBPJumpUtil.jumpNickEditPage$default(0, NBPGuideNoviceFirstPageView.access$getAttr(NBPGuideNoviceFirstPageView.this).getViewModel().getNick(), 1);
                                                        }
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                w.a(vVar4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideNoviceFirstPageView.body.1.7.2.5
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar5) {
                                        vVar5.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideNoviceFirstPageView.body.1.7.2.5.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                t tVar2 = tVar;
                                                tVar2.mo153width(162.0f);
                                                tVar2.mo141height(0.5f);
                                                tVar2.mo113backgroundColor(QUIToken.color$default("border_standard"));
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPGuideNoviceFirstPageView nBPGuideNoviceFirstPageView6 = NBPGuideNoviceFirstPageView.this;
                                w.a(vVar4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideNoviceFirstPageView.body.1.7.2.6
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar5) {
                                        v vVar6 = vVar5;
                                        vVar6.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideNoviceFirstPageView.body.1.7.2.6.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                t tVar2 = tVar;
                                                tVar2.flexDirectionRow();
                                                tVar2.marginTop(20.0f);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final NBPGuideNoviceFirstPageView nBPGuideNoviceFirstPageView7 = NBPGuideNoviceFirstPageView.this;
                                        w.a(vVar6, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideNoviceFirstPageView.body.1.7.2.6.2
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(v vVar7) {
                                                v vVar8 = vVar7;
                                                vVar8.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideNoviceFirstPageView.body.1.7.2.6.2.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(t tVar) {
                                                        t tVar2 = tVar;
                                                        tVar2.padding(8.0f, 8.0f, 8.0f, 16.0f);
                                                        tVar2.flexDirectionRow();
                                                        tVar2.alignItemsCenter();
                                                        tVar2.m136border(new com.tencent.kuikly.core.base.e(0.5f, BorderStyle.SOLID, QUIToken.color$default("fill_standard_quaternary")));
                                                        tVar2.borderRadius(6.0f);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final NBPGuideNoviceFirstPageView nBPGuideNoviceFirstPageView8 = NBPGuideNoviceFirstPageView.this;
                                                ah.a(vVar8, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideNoviceFirstPageView.body.1.7.2.6.2.2
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ImageView imageView) {
                                                        final NBPGuideNoviceFirstPageView nBPGuideNoviceFirstPageView9 = NBPGuideNoviceFirstPageView.this;
                                                        imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideNoviceFirstPageView.body.1.7.2.6.2.2.1
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(af afVar) {
                                                                String str;
                                                                af afVar2 = afVar;
                                                                afVar2.size(16.0f, 16.0f);
                                                                afVar2.o();
                                                                if (NBPGuideNoviceFirstPageView.access$getAttr(NBPGuideNoviceFirstPageView.this).getViewModel().getGender() == 1) {
                                                                    str = "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_8mMIez3Oefl.png";
                                                                } else {
                                                                    str = "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_TB7_3nsRQ-f.png";
                                                                }
                                                                b.a.b(afVar2, str, false, 2, null);
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final NBPGuideNoviceFirstPageView nBPGuideNoviceFirstPageView9 = NBPGuideNoviceFirstPageView.this;
                                                cg.a(vVar8, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideNoviceFirstPageView.body.1.7.2.6.2.3
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(TextView textView) {
                                                        final NBPGuideNoviceFirstPageView nBPGuideNoviceFirstPageView10 = NBPGuideNoviceFirstPageView.this;
                                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideNoviceFirstPageView.body.1.7.2.6.2.3.1
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ce ceVar) {
                                                                String str;
                                                                ce ceVar2 = ceVar;
                                                                int gender = NBPGuideNoviceFirstPageView.access$getAttr(NBPGuideNoviceFirstPageView.this).getViewModel().getGender();
                                                                if (gender == 1) {
                                                                    str = "\u7537";
                                                                } else if (gender != 2) {
                                                                    str = "";
                                                                } else {
                                                                    str = "\u5973";
                                                                }
                                                                ceVar2.text(str);
                                                                ceVar2.color(QUIToken.color$default("text_primary"));
                                                                ceVar2.fontWeight400();
                                                                ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                                                ceVar2.marginLeft(4.0f);
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final NBPGuideNoviceFirstPageView nBPGuideNoviceFirstPageView10 = NBPGuideNoviceFirstPageView.this;
                                                vVar8.event(new Function1<com.tencent.kuikly.core.views.u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideNoviceFirstPageView.body.1.7.2.6.2.4
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(com.tencent.kuikly.core.views.u uVar) {
                                                        final NBPGuideNoviceFirstPageView nBPGuideNoviceFirstPageView11 = NBPGuideNoviceFirstPageView.this;
                                                        uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideNoviceFirstPageView.body.1.7.2.6.2.4.1
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ClickParams clickParams) {
                                                                NBPGuideNoviceFirstPageView.access$showGenderPicker(NBPGuideNoviceFirstPageView.this);
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final NBPGuideNoviceFirstPageView nBPGuideNoviceFirstPageView8 = NBPGuideNoviceFirstPageView.this;
                                        w.a(vVar6, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideNoviceFirstPageView.body.1.7.2.6.3
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(v vVar7) {
                                                v vVar8 = vVar7;
                                                vVar8.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideNoviceFirstPageView.body.1.7.2.6.3.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(t tVar) {
                                                        t tVar2 = tVar;
                                                        tVar2.padding(8.0f, 16.0f, 8.0f, 16.0f);
                                                        tVar2.m136border(new com.tencent.kuikly.core.base.e(0.5f, BorderStyle.SOLID, QUIToken.color$default("fill_standard_quaternary")));
                                                        tVar2.borderRadius(6.0f);
                                                        tVar2.allCenter();
                                                        tVar2.marginLeft(12.0f);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final NBPGuideNoviceFirstPageView nBPGuideNoviceFirstPageView9 = NBPGuideNoviceFirstPageView.this;
                                                cg.a(vVar8, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideNoviceFirstPageView.body.1.7.2.6.3.2
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(TextView textView) {
                                                        final NBPGuideNoviceFirstPageView nBPGuideNoviceFirstPageView10 = NBPGuideNoviceFirstPageView.this;
                                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideNoviceFirstPageView.body.1.7.2.6.3.2.1
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ce ceVar) {
                                                                ce ceVar2 = ceVar;
                                                                ceVar2.fontWeight400();
                                                                ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                                                ceVar2.text(NBPGuideNoviceFirstPageView.access$getAttr(NBPGuideNoviceFirstPageView.this).getViewModel().getConstellation());
                                                                ceVar2.color(QUIToken.color$default("text_primary"));
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final NBPGuideNoviceFirstPageView nBPGuideNoviceFirstPageView10 = NBPGuideNoviceFirstPageView.this;
                                                vVar8.event(new Function1<com.tencent.kuikly.core.views.u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideNoviceFirstPageView.body.1.7.2.6.3.3
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(com.tencent.kuikly.core.views.u uVar) {
                                                        final NBPGuideNoviceFirstPageView nBPGuideNoviceFirstPageView11 = NBPGuideNoviceFirstPageView.this;
                                                        uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideNoviceFirstPageView.body.1.7.2.6.3.3.1
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ClickParams clickParams) {
                                                                NBPGuideNoviceFirstPageView.access$showDatePicker(NBPGuideNoviceFirstPageView.this);
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
                                final NBPGuideNoviceFirstPageView nBPGuideNoviceFirstPageView7 = NBPGuideNoviceFirstPageView.this;
                                w.a(vVar4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideNoviceFirstPageView.body.1.7.2.7
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar5) {
                                        v vVar6 = vVar5;
                                        final NBPGuideNoviceFirstPageView nBPGuideNoviceFirstPageView8 = NBPGuideNoviceFirstPageView.this;
                                        vVar6.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideNoviceFirstPageView.body.1.7.2.7.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                t tVar2 = tVar;
                                                tVar2.mo153width(168.0f);
                                                tVar2.mo141height(45.0f);
                                                tVar2.mo113backgroundColor(QUIToken.color$default("button_bg_primary_default"));
                                                tVar2.borderRadius(4.0f);
                                                tVar2.allCenter();
                                                tVar2.marginTop(32.0f);
                                                if (NBPGuideNoviceFirstPageView.access$getAttr(NBPGuideNoviceFirstPageView.this).getViewModel().getNick().length() > 0) {
                                                    tVar2.mo113backgroundColor(QUIToken.color$default("button_bg_primary_default"));
                                                } else {
                                                    tVar2.mo113backgroundColor(QUIToken.color$default("button_bg_primary_disable"));
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final NBPGuideNoviceFirstPageView nBPGuideNoviceFirstPageView9 = NBPGuideNoviceFirstPageView.this;
                                        cg.a(vVar6, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideNoviceFirstPageView.body.1.7.2.7.2
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(TextView textView) {
                                                final NBPGuideNoviceFirstPageView nBPGuideNoviceFirstPageView10 = NBPGuideNoviceFirstPageView.this;
                                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideNoviceFirstPageView.body.1.7.2.7.2.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ce ceVar) {
                                                        ce ceVar2 = ceVar;
                                                        ceVar2.text("\u4e0b\u4e00\u6b65");
                                                        ce.fontSize$default(ceVar2, 17.0f, null, 2, null);
                                                        ceVar2.fontWeight500();
                                                        if (NBPGuideNoviceFirstPageView.access$getAttr(NBPGuideNoviceFirstPageView.this).getViewModel().getNick().length() > 0) {
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
                                        final NBPGuideNoviceFirstPageView nBPGuideNoviceFirstPageView10 = NBPGuideNoviceFirstPageView.this;
                                        vVar6.event(new Function1<com.tencent.kuikly.core.views.u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideNoviceFirstPageView.body.1.7.2.7.3
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(com.tencent.kuikly.core.views.u uVar) {
                                                final NBPGuideNoviceFirstPageView nBPGuideNoviceFirstPageView11 = NBPGuideNoviceFirstPageView.this;
                                                uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideNoviceFirstPageView.body.1.7.2.7.3.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ClickParams clickParams) {
                                                        NBPGuideNoviceFirstPageView.access$handleNext(NBPGuideNoviceFirstPageView.this);
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
        return new NBPGuideNoviceFirstPageViewAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new NBPGuideNoviceFirstPageViewEvent();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final void created() {
        super.created();
        updateCardDataList();
        handleScrollOffset(0.0f);
    }

    public final com.tencent.kuikly.core.reactive.collection.c<GalleryCardData> getCardDataList() {
        return (com.tencent.kuikly.core.reactive.collection.c) this.cardDataList$delegate.getValue(this, $$delegatedProperties[0]);
    }

    public final void handleScrollOffset(float f16) {
        float min = Math.min(getPagerData().m(), 420.0f);
        int i3 = 0;
        for (GalleryCardData galleryCardData : getCardDataList()) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            GalleryCardData galleryCardData2 = galleryCardData;
            float f17 = i3 * min;
            float min2 = Math.min(((Math.min((int) (f17 + min), (int) (f16 + min)) - Math.max((int) f17, (int) f16) >= 0 ? r7 + 1 : 0) * 1.0f) / ((int) min), 1.0f);
            ReadWriteProperty readWriteProperty = galleryCardData2.transformScale$delegate;
            KProperty<?>[] kPropertyArr = GalleryCardData.$$delegatedProperties;
            readWriteProperty.setValue(galleryCardData2, kPropertyArr[1], Float.valueOf((0.25f * min2) + 0.75f));
            galleryCardData2.transformTranslateX$delegate.setValue(galleryCardData2, kPropertyArr[2], Float.valueOf((1 - min2) * 0.5f));
            if (f17 > f16) {
                galleryCardData2.transformTranslateX$delegate.setValue(galleryCardData2, kPropertyArr[2], Float.valueOf(-galleryCardData2.getTransformTranslateX()));
            }
            galleryCardData2.opacity$delegate.setValue(galleryCardData2, kPropertyArr[3], Float.valueOf(1.0f - (Math.min(Math.abs(galleryCardData2.getTransformTranslateX() * min), min / 2) / min)));
            i3 = i16;
        }
    }

    public final e jsonWithPageParams() {
        return AdelieCategoryHomePage$$ExternalSyntheticOutline0.m("dt_pgid", "pg_nearby_new_user_register");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void updateCardDataList() {
        PageListView<?, ?> b16;
        int collectionSizeOrDefault;
        getCardDataList().clear();
        List<String> avatarUrls = ((NBPGuideNoviceFirstPageViewAttr) getAttr()).getViewModel().getAvatarUrls();
        if (avatarUrls != null) {
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(avatarUrls, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            for (String str : avatarUrls) {
                com.tencent.kuikly.core.reactive.collection.c<GalleryCardData> cardDataList = getCardDataList();
                GalleryCardData galleryCardData = new GalleryCardData();
                galleryCardData.avatarUrl$delegate.setValue(galleryCardData, GalleryCardData.$$delegatedProperties[0], str);
                arrayList.add(Boolean.valueOf(cardDataList.add(galleryCardData)));
            }
        }
        aa<PageListView<?, ?>> aaVar = this.pageListViewRef;
        if (aaVar == null || (b16 = aaVar.b()) == null) {
            return;
        }
        ScrollerView.setContentOffset$default(b16, 0.0f, 0.0f, false, null, 12, null);
    }
}
