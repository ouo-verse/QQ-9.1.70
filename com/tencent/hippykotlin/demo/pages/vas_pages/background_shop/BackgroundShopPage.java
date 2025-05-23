package com.tencent.hippykotlin.demo.pages.vas_pages.background_shop;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.BridgeModule;
import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt;
import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.foundation.lib.QQUtils;
import com.tencent.hippykotlin.demo.pages.foundation.lib.mqq.Mqq;
import com.tencent.hippykotlin.demo.pages.foundation.lib.mqq.MqqUi;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.hippykotlin.demo.pages.foundation.view.DynamicAttr;
import com.tencent.hippykotlin.demo.pages.foundation.view.DynamicEvent;
import com.tencent.hippykotlin.demo.pages.foundation.view.VasDynamicView;
import com.tencent.hippykotlin.demo.pages.foundation.view.VasDynamicViewKt;
import com.tencent.hippykotlin.demo.pages.vas_base.VasBasePage;
import com.tencent.hippykotlin.demo.pages.vas_base.VasModule;
import com.tencent.hippykotlin.demo.pages.vas_base.VasSchema;
import com.tencent.hippykotlin.demo.pages.vas_base.krequest.URL;
import com.tencent.hippykotlin.demo.pages.vas_base.misc.SchemaBuilder;
import com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken;
import com.tencent.hippykotlin.demo.pages.vas_base.pay.VasPayData;
import com.tencent.hippykotlin.demo.pages.vas_base.pay.VasPayHelper;
import com.tencent.hippykotlin.demo.pages.vas_base.report.chain.bean.Node;
import com.tencent.hippykotlin.demo.pages.vas_base.report.chain.interfaces.IReportChain;
import com.tencent.hippykotlin.demo.pages.vas_base.report.vip_tracker.view.Tracker;
import com.tencent.hippykotlin.demo.pages.vas_base.report.vip_tracker.view.VipTrackerKt;
import com.tencent.hippykotlin.demo.pages.vas_base.report.vip_tracker.view.VipTrackerView;
import com.tencent.hippykotlin.demo.pages.vas_base.report.vip_tracker.view.VipTrackerViewAttr;
import com.tencent.hippykotlin.demo.pages.vas_base.report.vip_tracker.view.VipTrackerViewEvent;
import com.tencent.hippykotlin.demo.pages.vas_base.views.VasNavBarAttr;
import com.tencent.hippykotlin.demo.pages.vas_base.views.VasNavigationBar;
import com.tencent.hippykotlin.demo.pages.vas_pages.base_shop.data.FuncModItemData;
import com.tencent.hippykotlin.demo.pages.vas_pages.base_shop.data.ItemData;
import com.tencent.hippykotlin.demo.pages.vas_pages.base_shop.data.TagsItemData;
import com.tencent.hippykotlin.demo.pages.vas_pages.base_shop.data.TopBannerItemData;
import com.tencent.hippykotlin.demo.pages.vas_pages.base_shop.report.BaseReportInfo;
import com.tencent.hippykotlin.demo.pages.vas_pages.base_shop.view.FuncModItem;
import com.tencent.hippykotlin.demo.pages.vas_pages.base_shop.view.FuncModItemAttr;
import com.tencent.hippykotlin.demo.pages.vas_pages.base_shop.view.TagsItemAttr;
import com.tencent.hippykotlin.demo.pages.vas_pages.base_shop.view.TagsItemView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.aa;
import com.tencent.kuikly.core.base.attr.AccessibilityRole;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.coroutines.BuildersKt;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
import com.tencent.kuikly.core.directives.LoopDirectivesView;
import com.tencent.kuikly.core.directives.LoopDirectivesViewKt;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.reactive.ReactiveObserver;
import com.tencent.kuikly.core.views.FooterRefreshState;
import com.tencent.kuikly.core.views.FooterRefreshView;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.PageListView;
import com.tencent.kuikly.core.views.ScrollParams;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ah;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.ck;
import com.tencent.kuikly.core.views.cl;
import com.tencent.kuikly.core.views.cm;
import com.tencent.kuikly.core.views.cn;
import com.tencent.kuikly.core.views.compose.SliderPageAttr;
import com.tencent.kuikly.core.views.compose.SliderPageView;
import com.tencent.kuikly.core.views.compose.e;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import com.tencent.kuikly.core.views.x;
import com.tencent.kuikly.core.views.y;
import com.tencent.kuikly.core.views.z;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* loaded from: classes33.dex */
public final class BackgroundShopPage extends VasBasePage {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(BackgroundShopPage.class, "loadTopBannerDataFinished", "getLoadTopBannerDataFinished()Z", 0), IPagerIdKtxKt$$ExternalSyntheticOutline0.m(BackgroundShopPage.class, "firstData", "getFirstData()Lcom/tencent/kuikly/core/reactive/collection/ObservableList;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(BackgroundShopPage.class, "tagsItemData", "getTagsItemData()Lcom/tencent/hippykotlin/demo/pages/vas_pages/base_shop/data/TagsItemData;", 0), IPagerIdKtxKt$$ExternalSyntheticOutline0.m(BackgroundShopPage.class, "moreData", "getMoreData()Lcom/tencent/kuikly/core/reactive/collection/ObservableList;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(BackgroundShopPage.class, "footerRefreshText", "getFooterRefreshText()Ljava/lang/String;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(BackgroundShopPage.class, "isSvip", "isSvip()Z", 0)};
    public final ReadWriteProperty firstData$delegate;
    public aa<FooterRefreshView> footerRefreshRef;
    public final ReadWriteProperty footerRefreshText$delegate;
    public String friendUin;
    public final FuncModItemData funcModItemData;
    public boolean isPauseAnim;
    public final ReadWriteProperty isSvip$delegate;
    public final ReadWriteProperty loadTopBannerDataFinished$delegate;
    public final ReadWriteProperty moreData$delegate;
    public final ReadWriteProperty tagsItemData$delegate;
    public final ArrayList<TopBannerItemData> topBannerData;
    public int uinType;

    /* loaded from: classes33.dex */
    public static final class BgShopReportInfo extends BaseReportInfo {
        public BgShopReportInfo() {
            getExtProps().put("shopId", "3001004");
        }
    }

    public BackgroundShopPage() {
        Boolean bool = Boolean.FALSE;
        this.loadTopBannerDataFinished$delegate = c.a(bool);
        this.topBannerData = new ArrayList<>();
        this.funcModItemData = new FuncModItemData();
        ReactiveObserver.Companion companion = ReactiveObserver.INSTANCE;
        this.firstData$delegate = companion.d();
        this.tagsItemData$delegate = c.a(null);
        this.moreData$delegate = companion.d();
        this.footerRefreshText$delegate = c.a("\u4e0a\u62c9\u52a0\u8f7d\u66f4\u591a");
        this.isSvip$delegate = c.a(bool);
    }

    public static final com.tencent.kuikly.core.reactive.collection.c access$getFirstData(BackgroundShopPage backgroundShopPage) {
        return (com.tencent.kuikly.core.reactive.collection.c) backgroundShopPage.firstData$delegate.getValue(backgroundShopPage, $$delegatedProperties[1]);
    }

    public static final com.tencent.kuikly.core.reactive.collection.c access$getMoreData(BackgroundShopPage backgroundShopPage) {
        return (com.tencent.kuikly.core.reactive.collection.c) backgroundShopPage.moreData$delegate.getValue(backgroundShopPage, $$delegatedProperties[3]);
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        getExtProps().put("shopReportInfo", new BgShopReportInfo());
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.background_shop.BackgroundShopPage$body$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                final float m3 = BackgroundShopPage.this.getPagerData().m() - 40.0f;
                final int i3 = BackgroundShopPage.this.getPagerData().m() > 700.0f ? 6 : 3;
                final float f16 = (m3 - ((i3 - 1) * 10.0f)) / i3;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.background_shop.BackgroundShopPage$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        h hVar;
                        m mVar2 = mVar;
                        if (!VasUIToken.INSTANCE.isDarkMode()) {
                            hVar = new h(4294967295L);
                        } else {
                            hVar = new h(4280559144L);
                        }
                        mVar2.mo113backgroundColor(hVar);
                        return Unit.INSTANCE;
                    }
                });
                final BackgroundShopPage backgroundShopPage = BackgroundShopPage.this;
                final BackgroundShopPage backgroundShopPage2 = this;
                VipTrackerKt.VipTracker(viewContainer2, new Function1<VipTrackerView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.background_shop.BackgroundShopPage$body$1.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(VipTrackerView vipTrackerView) {
                        VipTrackerView vipTrackerView2 = vipTrackerView;
                        vipTrackerView2.attr(new Function1<VipTrackerViewAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.background_shop.BackgroundShopPage.body.1.2.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(VipTrackerViewAttr vipTrackerViewAttr) {
                                VipTrackerViewAttr vipTrackerViewAttr2 = vipTrackerViewAttr;
                                vipTrackerViewAttr2.size(vipTrackerViewAttr2.getPagerData().m(), vipTrackerViewAttr2.getPagerData().l());
                                vipTrackerViewAttr2.flexDirectionColumn();
                                vipTrackerViewAttr2.alignItemsCenter();
                                Tracker tracker = vipTrackerViewAttr2.tracker;
                                tracker.pageId = "3001004";
                                tracker.appId = "DressVip";
                                return Unit.INSTANCE;
                            }
                        });
                        final BackgroundShopPage backgroundShopPage3 = BackgroundShopPage.this;
                        w.a(vipTrackerView2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.background_shop.BackgroundShopPage.body.1.2.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar) {
                                v vVar2 = vVar;
                                vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.background_shop.BackgroundShopPage.body.1.2.2.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.size(tVar2.getPagerData().m(), tVar2.getPagerData().getNavigationBarHeight());
                                        return Unit.INSTANCE;
                                    }
                                });
                                vVar2.addChild(new VasNavigationBar(), new Function1<VasNavigationBar, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.background_shop.BackgroundShopPage.body.1.2.2.2
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(VasNavigationBar vasNavigationBar) {
                                        vasNavigationBar.attr(new Function1<VasNavBarAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.background_shop.BackgroundShopPage.body.1.2.2.2.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(VasNavBarAttr vasNavBarAttr) {
                                                h hVar;
                                                h hVar2;
                                                VasNavBarAttr vasNavBarAttr2 = vasNavBarAttr;
                                                ReadWriteProperty readWriteProperty = vasNavBarAttr2.navTitle$delegate;
                                                KProperty<?>[] kPropertyArr = VasNavBarAttr.$$delegatedProperties;
                                                readWriteProperty.setValue(vasNavBarAttr2, kPropertyArr[0], "\u80cc\u666f\u5546\u57ce");
                                                VasUIToken vasUIToken = VasUIToken.INSTANCE;
                                                if (!vasUIToken.isDarkMode()) {
                                                    hVar = new h(3438539767L);
                                                } else {
                                                    hVar = new h(3424263198L);
                                                }
                                                vasNavBarAttr2.bgColor$delegate.setValue(vasNavBarAttr2, kPropertyArr[1], hVar);
                                                if (!vasUIToken.isDarkMode()) {
                                                    hVar2 = new h(4279901214L);
                                                } else {
                                                    hVar2 = new h(4293980404L);
                                                }
                                                vasNavBarAttr2.textColor$delegate.setValue(vasNavBarAttr2, kPropertyArr[2], hVar2);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final BackgroundShopPage backgroundShopPage4 = BackgroundShopPage.this;
                                w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.background_shop.BackgroundShopPage.body.1.2.2.3
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar3) {
                                        v vVar4 = vVar3;
                                        vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.background_shop.BackgroundShopPage.body.1.2.2.3.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                t tVar2 = tVar;
                                                tVar2.positionAbsolute();
                                                tVar2.m142left(0.0f);
                                                tVar2.m150top(0.0f);
                                                tVar2.m149right(20.0f);
                                                tVar2.m138bottom(10.0f);
                                                tVar2.flexDirectionRow();
                                                tVar2.justifyContentFlexEnd();
                                                tVar2.alignItemsFlexEnd();
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final BackgroundShopPage backgroundShopPage5 = BackgroundShopPage.this;
                                        VipTrackerKt.VipTracker(vVar4, new Function1<VipTrackerView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.background_shop.BackgroundShopPage.body.1.2.2.3.2
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(VipTrackerView vipTrackerView3) {
                                                VipTrackerView vipTrackerView4 = vipTrackerView3;
                                                vipTrackerView4.attr(new Function1<VipTrackerViewAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.background_shop.BackgroundShopPage.body.1.2.2.3.2.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(VipTrackerViewAttr vipTrackerViewAttr) {
                                                        VipTrackerViewAttr vipTrackerViewAttr2 = vipTrackerViewAttr;
                                                        vipTrackerViewAttr2.tracker.moduleId = "9";
                                                        vipTrackerViewAttr2.tracker.expose = true;
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final BackgroundShopPage backgroundShopPage6 = BackgroundShopPage.this;
                                                VipTrackerKt.VipTracker(vipTrackerView4, new Function1<VipTrackerView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.background_shop.BackgroundShopPage.body.1.2.2.3.2.2
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(VipTrackerView vipTrackerView5) {
                                                        VipTrackerView vipTrackerView6 = vipTrackerView5;
                                                        vipTrackerView6.attr(new Function1<VipTrackerViewAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.background_shop.BackgroundShopPage.body.1.2.2.3.2.2.1
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(VipTrackerViewAttr vipTrackerViewAttr) {
                                                                Tracker tracker = vipTrackerViewAttr.tracker;
                                                                tracker.itemType = "4";
                                                                tracker.itemId = "Search";
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        ah.a(vipTrackerView6, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.background_shop.BackgroundShopPage.body.1.2.2.3.2.2.2
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ImageView imageView) {
                                                                imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.background_shop.BackgroundShopPage.body.1.2.2.3.2.2.2.1
                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(af afVar) {
                                                                        h hVar;
                                                                        af afVar2 = afVar;
                                                                        afVar2.accessibility("\u641c\u7d22");
                                                                        afVar2.accessibilityRole(AccessibilityRole.BUTTON);
                                                                        afVar2.size(24.0f, 24.0f);
                                                                        if (!VasUIToken.INSTANCE.isDarkMode()) {
                                                                            hVar = new h(4279901214L);
                                                                        } else {
                                                                            hVar = new h(4293980404L);
                                                                        }
                                                                        b.a.b(afVar2, QUIToken.INSTANCE.image("search", hVar), false, 2, null);
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        final BackgroundShopPage backgroundShopPage7 = BackgroundShopPage.this;
                                                        vipTrackerView6.event(new Function1<VipTrackerViewEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.background_shop.BackgroundShopPage.body.1.2.2.3.2.2.3
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(VipTrackerViewEvent vipTrackerViewEvent) {
                                                                final BackgroundShopPage backgroundShopPage8 = BackgroundShopPage.this;
                                                                vipTrackerViewEvent.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.background_shop.BackgroundShopPage.body.1.2.2.3.2.2.3.1
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(ClickParams clickParams) {
                                                                        Map mapOf;
                                                                        Map mapOf2;
                                                                        Map plus;
                                                                        Map<? extends String, ? extends String> plus2;
                                                                        KLog.INSTANCE.i(BackgroundShopPage.this.getPageName(), "user click open search");
                                                                        if (QQUtils.INSTANCE.compare("8.9.85") >= 0) {
                                                                            VasSchema vasSchema = VasSchema.INSTANCE;
                                                                            mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("appid", "8"), TuplesKt.to("enteranceId", "search_chatbg"));
                                                                            URL url = new URL("mqqapi://kuikly/open");
                                                                            mapOf2 = MapsKt__MapsKt.mapOf(TuplesKt.to("page_name", "vas_gxh_search"), TuplesKt.to("bundle_name", "vas_gxh_search"));
                                                                            Map<String, String> map = url.searchParams;
                                                                            plus = MapsKt__MapsKt.plus(VasSchema.necessaryParams, mapOf2);
                                                                            plus2 = MapsKt__MapsKt.plus(plus, mapOf);
                                                                            map.putAll(plus2);
                                                                            MqqUi.openUrl$default(Mqq.INSTANCE.getUi(), url.getHref());
                                                                        } else {
                                                                            QQKuiklyPlatformApi.openPage$default((QQKuiklyPlatformApi) com.tencent.kuikly.core.manager.c.f117352a.g().acquireModule("QQKuiklyPlatformApi"), "https://zb.vip.qq.com/v2/pages/searchPage?_wv=2&appid=8&enteranceId=search_chatbg", false, 6);
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
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final BackgroundShopPage backgroundShopPage6 = BackgroundShopPage.this;
                                        VipTrackerKt.VipTracker(vVar4, new Function1<VipTrackerView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.background_shop.BackgroundShopPage.body.1.2.2.3.3
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(VipTrackerView vipTrackerView3) {
                                                VipTrackerView vipTrackerView4 = vipTrackerView3;
                                                vipTrackerView4.attr(new Function1<VipTrackerViewAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.background_shop.BackgroundShopPage.body.1.2.2.3.3.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(VipTrackerViewAttr vipTrackerViewAttr) {
                                                        VipTrackerViewAttr vipTrackerViewAttr2 = vipTrackerViewAttr;
                                                        vipTrackerViewAttr2.tracker.moduleId = "10";
                                                        vipTrackerViewAttr2.tracker.expose = true;
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final BackgroundShopPage backgroundShopPage7 = BackgroundShopPage.this;
                                                VipTrackerKt.VipTracker(vipTrackerView4, new Function1<VipTrackerView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.background_shop.BackgroundShopPage.body.1.2.2.3.3.2
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(VipTrackerView vipTrackerView5) {
                                                        VipTrackerView vipTrackerView6 = vipTrackerView5;
                                                        vipTrackerView6.attr(new Function1<VipTrackerViewAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.background_shop.BackgroundShopPage.body.1.2.2.3.3.2.1
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(VipTrackerViewAttr vipTrackerViewAttr) {
                                                                Tracker tracker = vipTrackerViewAttr.tracker;
                                                                tracker.itemType = "4";
                                                                tracker.itemId = "MyPage";
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        ah.a(vipTrackerView6, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.background_shop.BackgroundShopPage.body.1.2.2.3.3.2.2
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ImageView imageView) {
                                                                imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.background_shop.BackgroundShopPage.body.1.2.2.3.3.2.2.1
                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(af afVar) {
                                                                        h hVar;
                                                                        af afVar2 = afVar;
                                                                        afVar2.accessibility("\u4e2a\u4eba\u4e2d\u5fc3");
                                                                        afVar2.accessibilityRole(AccessibilityRole.BUTTON);
                                                                        afVar2.marginLeft(10.0f);
                                                                        afVar2.size(24.0f, 24.0f);
                                                                        if (!VasUIToken.INSTANCE.isDarkMode()) {
                                                                            hVar = new h(4279901214L);
                                                                        } else {
                                                                            hVar = new h(4293980404L);
                                                                        }
                                                                        b.a.b(afVar2, QUIToken.INSTANCE.image(QCircleAlphaUserReporter.KEY_USER, hVar), false, 2, null);
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        final BackgroundShopPage backgroundShopPage8 = BackgroundShopPage.this;
                                                        vipTrackerView6.event(new Function1<VipTrackerViewEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.background_shop.BackgroundShopPage.body.1.2.2.3.3.2.3
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(VipTrackerViewEvent vipTrackerViewEvent) {
                                                                final BackgroundShopPage backgroundShopPage9 = BackgroundShopPage.this;
                                                                vipTrackerViewEvent.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.background_shop.BackgroundShopPage.body.1.2.2.3.3.2.3.1
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(ClickParams clickParams) {
                                                                        KLog.INSTANCE.i(BackgroundShopPage.this.getPageName(), "user click open member");
                                                                        SchemaBuilder schemaBuilder = SchemaBuilder.INSTANCE;
                                                                        Pair<String, ?>[] pairArr = new Pair[2];
                                                                        String str = BackgroundShopPage.this.friendUin;
                                                                        if (str == null) {
                                                                            Intrinsics.throwUninitializedPropertyAccessException("friendUin");
                                                                            str = null;
                                                                        }
                                                                        pairArr[0] = TuplesKt.to("friendUin", str);
                                                                        pairArr[1] = TuplesKt.to("uinType", Integer.valueOf(BackgroundShopPage.this.uinType));
                                                                        QQKuiklyPlatformApi.openPage$default((QQKuiklyPlatformApi) com.tencent.kuikly.core.manager.c.f117352a.g().acquireModule("QQKuiklyPlatformApi"), schemaBuilder.buildUrlWithParams("https://zb.vip.qq.com/v2/pages/newMinePage?appid=8&_nav_titleclr=000000&_nav_txtclr=000000&_wv=16777216", pairArr), false, 6);
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
                        final int i16 = i3;
                        final float f17 = m3;
                        final BackgroundShopPage backgroundShopPage4 = BackgroundShopPage.this;
                        final BackgroundShopPage backgroundShopPage5 = backgroundShopPage2;
                        final float f18 = f16;
                        final float f19 = 10.0f;
                        cn.a(vipTrackerView2, new Function1<cm, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.background_shop.BackgroundShopPage.body.1.2.3
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(cm cmVar) {
                                cm cmVar2 = cmVar;
                                final int i17 = i16;
                                final float f26 = f17;
                                final float f27 = f19;
                                cmVar2.attr(new Function1<ck, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.background_shop.BackgroundShopPage.body.1.2.3.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ck ckVar) {
                                        ck ckVar2 = ckVar;
                                        ckVar2.m140flex(1.0f);
                                        ckVar2.h(i17);
                                        ckVar2.w(f26);
                                        ckVar2.showScrollerIndicator(false);
                                        ckVar2.t(f27);
                                        ckVar2.u(16.0f);
                                        ckVar2.marginLeft(20.0f);
                                        ckVar2.marginRight(20.0f);
                                        return Unit.INSTANCE;
                                    }
                                });
                                final BackgroundShopPage backgroundShopPage6 = backgroundShopPage4;
                                cmVar2.event(new Function1<cl, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.background_shop.BackgroundShopPage.body.1.2.3.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(cl clVar) {
                                        cl clVar2 = clVar;
                                        final BackgroundShopPage backgroundShopPage7 = BackgroundShopPage.this;
                                        clVar2.scroll(new Function1<ScrollParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.background_shop.BackgroundShopPage.body.1.2.3.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ScrollParams scrollParams) {
                                                BackgroundShopPage backgroundShopPage8 = BackgroundShopPage.this;
                                                if (!backgroundShopPage8.isPauseAnim) {
                                                    VasModule vasModule = backgroundShopPage8.platformApi.getVasModule();
                                                    vasModule.getClass();
                                                    KLog.INSTANCE.e("VasModule", "pauseAnimTimeLine");
                                                    vasModule.toNative(false, "pauseAnimTimeLine", "shop", null, false);
                                                    BackgroundShopPage.this.isPauseAnim = true;
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final BackgroundShopPage backgroundShopPage8 = BackgroundShopPage.this;
                                        clVar2.scrollEnd(new Function1<ScrollParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.background_shop.BackgroundShopPage.body.1.2.3.2.2
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ScrollParams scrollParams) {
                                                VasModule vasModule = BackgroundShopPage.this.platformApi.getVasModule();
                                                vasModule.getClass();
                                                KLog.INSTANCE.e("VasModule", "resumeAnimTimeLine");
                                                vasModule.toNative(false, "resumeAnimTimeLine", "shop", null, false);
                                                BackgroundShopPage.this.isPauseAnim = false;
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final float f28 = f17;
                                w.a(cmVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.background_shop.BackgroundShopPage.body.1.2.3.3
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar) {
                                        final float f29 = f28;
                                        vVar.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.background_shop.BackgroundShopPage.body.1.2.3.3.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                t tVar2 = tVar;
                                                tVar2.mo153width(f29);
                                                tVar2.mo141height(1.0f);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final BackgroundShopPage backgroundShopPage7 = backgroundShopPage4;
                                Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.background_shop.BackgroundShopPage.body.1.2.3.4
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        BackgroundShopPage backgroundShopPage8 = BackgroundShopPage.this;
                                        return Boolean.valueOf(((Boolean) backgroundShopPage8.loadTopBannerDataFinished$delegate.getValue(backgroundShopPage8, BackgroundShopPage.$$delegatedProperties[0])).booleanValue());
                                    }
                                };
                                final float f29 = f17;
                                final BackgroundShopPage backgroundShopPage8 = backgroundShopPage4;
                                ConditionViewKt.c(cmVar2, function0, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.background_shop.BackgroundShopPage.body.1.2.3.5
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ConditionView conditionView) {
                                        final float f36 = f29;
                                        final float f37 = (800.0f * f36) / 1440.0f;
                                        final BackgroundShopPage backgroundShopPage9 = backgroundShopPage8;
                                        VipTrackerKt.VipTracker(conditionView, new Function1<VipTrackerView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.background_shop.BackgroundShopPage.body.1.2.3.5.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(VipTrackerView vipTrackerView3) {
                                                VipTrackerView vipTrackerView4 = vipTrackerView3;
                                                final float f38 = f37;
                                                vipTrackerView4.attr(new Function1<VipTrackerViewAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.background_shop.BackgroundShopPage.body.1.2.3.5.1.1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(VipTrackerViewAttr vipTrackerViewAttr) {
                                                        VipTrackerViewAttr vipTrackerViewAttr2 = vipTrackerViewAttr;
                                                        vipTrackerViewAttr2.tracker.moduleId = "1";
                                                        vipTrackerViewAttr2.tracker.expose = true;
                                                        vipTrackerViewAttr2.size(vipTrackerViewAttr2.getPagerData().m(), f38);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final float f39 = f37;
                                                final float f46 = f36;
                                                final BackgroundShopPage backgroundShopPage10 = backgroundShopPage9;
                                                VipTrackerKt.VipTracker(vipTrackerView4, new Function1<VipTrackerView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.background_shop.BackgroundShopPage.body.1.2.3.5.1.2
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(VipTrackerView vipTrackerView5) {
                                                        VipTrackerView vipTrackerView6 = vipTrackerView5;
                                                        final float f47 = f39;
                                                        vipTrackerView6.attr(new Function1<VipTrackerViewAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.background_shop.BackgroundShopPage.body.1.2.3.5.1.2.1
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(VipTrackerViewAttr vipTrackerViewAttr) {
                                                                VipTrackerViewAttr vipTrackerViewAttr2 = vipTrackerViewAttr;
                                                                vipTrackerViewAttr2.tracker.itemType = "1";
                                                                vipTrackerViewAttr2.size(vipTrackerViewAttr2.getPagerData().m(), f47);
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        final float f48 = f46;
                                                        final float f49 = f39;
                                                        final BackgroundShopPage backgroundShopPage11 = backgroundShopPage10;
                                                        e.a(vipTrackerView6, new Function1<SliderPageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.background_shop.BackgroundShopPage.body.1.2.3.5.1.2.2
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(SliderPageView sliderPageView) {
                                                                final float f56 = f48;
                                                                final float f57 = f49;
                                                                final BackgroundShopPage backgroundShopPage12 = backgroundShopPage11;
                                                                sliderPageView.attr(new Function1<SliderPageAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.background_shop.BackgroundShopPage.body.1.2.3.5.1.2.2.1
                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(SliderPageAttr sliderPageAttr) {
                                                                        SliderPageAttr sliderPageAttr2 = sliderPageAttr;
                                                                        sliderPageAttr2.r(true);
                                                                        sliderPageAttr2.mo153width(f56);
                                                                        sliderPageAttr2.mo141height(f57);
                                                                        sliderPageAttr2.u(f56);
                                                                        sliderPageAttr2.t(f57);
                                                                        sliderPageAttr2.s(3000);
                                                                        final Ref.IntRef intRef = new Ref.IntRef();
                                                                        final BackgroundShopPage backgroundShopPage13 = backgroundShopPage12;
                                                                        sliderPageAttr2.o(backgroundShopPage13.topBannerData, new Function2<PageListView<?, ?>, TopBannerItemData, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.background_shop.BackgroundShopPage.body.1.2.3.5.1.2.2.1.1
                                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                            {
                                                                                super(2);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function2
                                                                            public final Unit invoke(PageListView<?, ?> pageListView, TopBannerItemData topBannerItemData) {
                                                                                final TopBannerItemData topBannerItemData2 = topBannerItemData;
                                                                                final Ref.IntRef intRef2 = Ref.IntRef.this;
                                                                                final BackgroundShopPage backgroundShopPage14 = backgroundShopPage13;
                                                                                VipTrackerKt.VipTracker(pageListView, new Function1<VipTrackerView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.background_shop.BackgroundShopPage.body.1.2.3.5.1.2.2.1.1.1
                                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                    {
                                                                                        super(1);
                                                                                    }

                                                                                    @Override // kotlin.jvm.functions.Function1
                                                                                    public final Unit invoke(VipTrackerView vipTrackerView7) {
                                                                                        VipTrackerView vipTrackerView8 = vipTrackerView7;
                                                                                        final TopBannerItemData topBannerItemData3 = TopBannerItemData.this;
                                                                                        vipTrackerView8.attr(new Function1<VipTrackerViewAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.background_shop.BackgroundShopPage.body.1.2.3.5.1.2.2.1.1.1.1
                                                                                            {
                                                                                                super(1);
                                                                                            }

                                                                                            @Override // kotlin.jvm.functions.Function1
                                                                                            public final Unit invoke(VipTrackerViewAttr vipTrackerViewAttr) {
                                                                                                VipTrackerViewAttr vipTrackerViewAttr2 = vipTrackerViewAttr;
                                                                                                vipTrackerViewAttr2.tracker.itemType = "1";
                                                                                                TopBannerItemData topBannerItemData4 = TopBannerItemData.this;
                                                                                                vipTrackerViewAttr2.tracker.itemId = (String) topBannerItemData4.url$delegate.getValue(topBannerItemData4, TopBannerItemData.$$delegatedProperties[1]);
                                                                                                return Unit.INSTANCE;
                                                                                            }
                                                                                        });
                                                                                        final TopBannerItemData topBannerItemData4 = TopBannerItemData.this;
                                                                                        final Ref.IntRef intRef3 = intRef2;
                                                                                        final BackgroundShopPage backgroundShopPage15 = backgroundShopPage14;
                                                                                        VasDynamicViewKt.VasDynamicImg(vipTrackerView8, new Function1<VasDynamicView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.background_shop.BackgroundShopPage.body.1.2.3.5.1.2.2.1.1.1.2
                                                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                            {
                                                                                                super(1);
                                                                                            }

                                                                                            @Override // kotlin.jvm.functions.Function1
                                                                                            public final Unit invoke(VasDynamicView vasDynamicView) {
                                                                                                VasDynamicView vasDynamicView2 = vasDynamicView;
                                                                                                final TopBannerItemData topBannerItemData5 = TopBannerItemData.this;
                                                                                                final Ref.IntRef intRef4 = intRef3;
                                                                                                vasDynamicView2.attr(new Function1<DynamicAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.background_shop.BackgroundShopPage.body.1.2.3.5.1.2.2.1.1.1.2.1
                                                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                                    {
                                                                                                        super(1);
                                                                                                    }

                                                                                                    @Override // kotlin.jvm.functions.Function1
                                                                                                    public final Unit invoke(DynamicAttr dynamicAttr) {
                                                                                                        DynamicAttr dynamicAttr2 = dynamicAttr;
                                                                                                        TopBannerItemData topBannerItemData6 = TopBannerItemData.this;
                                                                                                        dynamicAttr2.with("src", (String) topBannerItemData6.image$delegate.getValue(topBannerItemData6, TopBannerItemData.$$delegatedProperties[0]));
                                                                                                        dynamicAttr2.with("sceneTag", "shop");
                                                                                                        intRef4.element++;
                                                                                                        return Unit.INSTANCE;
                                                                                                    }
                                                                                                });
                                                                                                final BackgroundShopPage backgroundShopPage16 = backgroundShopPage15;
                                                                                                final TopBannerItemData topBannerItemData6 = TopBannerItemData.this;
                                                                                                vasDynamicView2.event(new Function1<DynamicEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.background_shop.BackgroundShopPage.body.1.2.3.5.1.2.2.1.1.1.2.2
                                                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                                    {
                                                                                                        super(1);
                                                                                                    }

                                                                                                    @Override // kotlin.jvm.functions.Function1
                                                                                                    public final Unit invoke(DynamicEvent dynamicEvent) {
                                                                                                        final BackgroundShopPage backgroundShopPage17 = BackgroundShopPage.this;
                                                                                                        final TopBannerItemData topBannerItemData7 = topBannerItemData6;
                                                                                                        dynamicEvent.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.background_shop.BackgroundShopPage.body.1.2.3.5.1.2.2.1.1.1.2.2.1
                                                                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                                            {
                                                                                                                super(1);
                                                                                                            }

                                                                                                            @Override // kotlin.jvm.functions.Function1
                                                                                                            public final Unit invoke(ClickParams clickParams) {
                                                                                                                KLog.INSTANCE.i(BackgroundShopPage.this.getPageName(), "user click ad");
                                                                                                                VasModule vasModule = BackgroundShopPage.this.platformApi.getVasModule();
                                                                                                                TopBannerItemData topBannerItemData8 = topBannerItemData7;
                                                                                                                vasModule.openPage((String) topBannerItemData8.url$delegate.getValue(topBannerItemData8, TopBannerItemData.$$delegatedProperties[1]));
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
                                final BackgroundShopPage backgroundShopPage9 = backgroundShopPage4;
                                final float f36 = f17;
                                final BackgroundShopPage backgroundShopPage10 = backgroundShopPage5;
                                VipTrackerKt.VipTracker(cmVar2, new Function1<VipTrackerView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.background_shop.BackgroundShopPage.body.1.2.3.6
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(VipTrackerView vipTrackerView3) {
                                        VipTrackerView vipTrackerView4 = vipTrackerView3;
                                        final float f37 = f36;
                                        vipTrackerView4.attr(new Function1<VipTrackerViewAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.background_shop.BackgroundShopPage.body.1.2.3.6.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(VipTrackerViewAttr vipTrackerViewAttr) {
                                                VipTrackerViewAttr vipTrackerViewAttr2 = vipTrackerViewAttr;
                                                vipTrackerViewAttr2.tracker.moduleId = "2";
                                                vipTrackerViewAttr2.tracker.expose = true;
                                                vipTrackerViewAttr2.mo153width(f37);
                                                vipTrackerViewAttr2.flexDirectionRow();
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final BackgroundShopPage backgroundShopPage11 = BackgroundShopPage.this;
                                        final BackgroundShopPage backgroundShopPage12 = backgroundShopPage10;
                                        final float f38 = f36;
                                        vipTrackerView4.addChild(new FuncModItem(backgroundShopPage11), new Function1<FuncModItem, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.background_shop.BackgroundShopPage.body.1.2.3.6.2
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(FuncModItem funcModItem) {
                                                FuncModItem funcModItem2 = funcModItem;
                                                final FuncModItemData funcModItemData = new FuncModItemData();
                                                BackgroundShopPage backgroundShopPage13 = backgroundShopPage11;
                                                funcModItemData.setTitle("\u4e0a\u4f20\u80cc\u666f");
                                                funcModItemData.setDesc("\u4ece\u76f8\u518c\u9009\u62e9");
                                                funcModItemData.setIcon("https://qzonestyle.gtimg.cn/aoi/sola/20200302220701_ZHui6DnTCi.png");
                                                SchemaBuilder schemaBuilder = SchemaBuilder.INSTANCE;
                                                Pair[] pairArr = new Pair[2];
                                                String str = backgroundShopPage13.friendUin;
                                                if (str == null) {
                                                    Intrinsics.throwUninitializedPropertyAccessException("friendUin");
                                                    str = null;
                                                }
                                                pairArr[0] = TuplesKt.to("frienduin", str);
                                                pairArr[1] = TuplesKt.to("uintype", Integer.valueOf(backgroundShopPage13.uinType));
                                                funcModItemData.setUrl(schemaBuilder.buildVasKuiklySchema(pairArr));
                                                final float f39 = f38;
                                                final BackgroundShopPage backgroundShopPage14 = backgroundShopPage11;
                                                funcModItem2.attr(new Function1<FuncModItemAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.background_shop.BackgroundShopPage.body.1.2.3.6.2.1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(FuncModItemAttr funcModItemAttr) {
                                                        FuncModItemAttr funcModItemAttr2 = funcModItemAttr;
                                                        funcModItemAttr2.data = FuncModItemData.this;
                                                        funcModItemAttr2.itemWidth = f39 / 2;
                                                        final BackgroundShopPage backgroundShopPage15 = backgroundShopPage14;
                                                        funcModItemAttr2.click = new Function1<SchemaBuilder.TraceDetailInfo, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.background_shop.BackgroundShopPage.body.1.2.3.6.2.1.1

                                                            @DebugMetadata(c = "com.tencent.hippykotlin.demo.pages.vas_pages.background_shop.BackgroundShopPage$body$1$2$3$6$2$1$1$1", f = "BackgroundShopPage.kt", i = {}, l = {325}, m = "invokeSuspend", n = {}, s = {})
                                                            /* renamed from: com.tencent.hippykotlin.demo.pages.vas_pages.background_shop.BackgroundShopPage$body$1$2$3$6$2$1$1$1, reason: invalid class name and collision with other inner class name */
                                                            /* loaded from: classes33.dex */
                                                            public final class C56831 extends SuspendLambda implements Function2<com.tencent.kuikly.core.coroutines.b, Continuation<? super Unit>, Object> {
                                                                public final /* synthetic */ BackgroundShopPage $ctx;
                                                                public BackgroundShopPage L$0;
                                                                public int label;

                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                public C56831(BackgroundShopPage backgroundShopPage, Continuation<? super C56831> continuation) {
                                                                    super(2, continuation);
                                                                    this.$ctx = backgroundShopPage;
                                                                }

                                                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                                                    return new C56831(this.$ctx, continuation);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function2
                                                                public final Object invoke(com.tencent.kuikly.core.coroutines.b bVar, Continuation<? super Unit> continuation) {
                                                                    return ((C56831) create(bVar, continuation)).invokeSuspend(Unit.INSTANCE);
                                                                }

                                                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                                public final Object invokeSuspend(Object obj) {
                                                                    Object coroutine_suspended;
                                                                    Continuation intercepted;
                                                                    Object coroutine_suspended2;
                                                                    coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                                                    int i3 = this.label;
                                                                    if (i3 == 0) {
                                                                        ResultKt.throwOnFailure(obj);
                                                                        final BackgroundShopPage backgroundShopPage = this.$ctx;
                                                                        this.L$0 = backgroundShopPage;
                                                                        this.label = 1;
                                                                        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(this);
                                                                        final SafeContinuation safeContinuation = new SafeContinuation(intercepted);
                                                                        VasModule vasModule = backgroundShopPage.platformApi.getVasModule();
                                                                        Function1<com.tencent.kuikly.core.nvi.serialization.json.e, Unit> function1 = 
                                                                        /*  JADX ERROR: Method code generation error
                                                                            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0032: CONSTRUCTOR (r8v0 'function1' kotlin.jvm.functions.Function1<com.tencent.kuikly.core.nvi.serialization.json.e, kotlin.Unit>) = 
                                                                              (r11v1 'backgroundShopPage' com.tencent.hippykotlin.demo.pages.vas_pages.background_shop.BackgroundShopPage A[DONT_INLINE])
                                                                              (r1v1 'safeContinuation' kotlin.coroutines.SafeContinuation A[DONT_INLINE])
                                                                             A[DECLARE_VAR, MD:(com.tencent.hippykotlin.demo.pages.vas_pages.background_shop.BackgroundShopPage, kotlin.coroutines.Continuation<? super kotlin.Pair<java.lang.String, java.lang.String>>):void (m)] (LINE:51) call: com.tencent.hippykotlin.demo.pages.vas_pages.background_shop.BackgroundShopPage$body$1$2$3$6$2$1$1$1$pathData$1$1.<init>(com.tencent.hippykotlin.demo.pages.vas_pages.background_shop.BackgroundShopPage, kotlin.coroutines.Continuation):void type: CONSTRUCTOR in method: com.tencent.hippykotlin.demo.pages.vas_pages.background_shop.BackgroundShopPage.body.1.2.3.6.2.1.1.1.invokeSuspend(java.lang.Object):java.lang.Object, file: classes33.dex
                                                                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
                                                                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
                                                                            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:94)
                                                                            	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                                                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                                                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                                                                            	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                                            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:297)
                                                                            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:276)
                                                                            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:406)
                                                                            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
                                                                            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
                                                                            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                                                                            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
                                                                            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                                                            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                                                                            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.hippykotlin.demo.pages.vas_pages.background_shop.BackgroundShopPage$body$1$2$3$6$2$1$1$1$pathData$1$1, state: NOT_LOADED
                                                                            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:304)
                                                                            	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:781)
                                                                            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:730)
                                                                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:418)
                                                                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:303)
                                                                            	... 21 more
                                                                            */
                                                                        /*
                                                                            Method dump skipped, instructions count: 257
                                                                            To view this dump change 'Code comments level' option to 'DEBUG'
                                                                        */
                                                                        throw new UnsupportedOperationException("Method not decompiled: com.tencent.hippykotlin.demo.pages.vas_pages.background_shop.BackgroundShopPage$body$1.AnonymousClass2.AnonymousClass3.AnonymousClass6.C56812.AnonymousClass1.C56821.C56831.invokeSuspend(java.lang.Object):java.lang.Object");
                                                                    }
                                                                }

                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(SchemaBuilder.TraceDetailInfo traceDetailInfo) {
                                                                    KLog.INSTANCE.i(BackgroundShopPage.this.getPageName(), "user click select img");
                                                                    BuildersKt.e(BackgroundShopPage.this.getPageScope(), null, null, new C56831(BackgroundShopPage.this, null), 3, null);
                                                                    return Unit.INSTANCE;
                                                                }
                                                            };
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    final BackgroundShopPage backgroundShopPage15 = BackgroundShopPage.this;
                                                    final IReportChain reportChain = backgroundShopPage15.getReportChain();
                                                    if (reportChain != null) {
                                                        funcModItem2.performTaskWhenRenderViewDidLoad(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.VasBasePage$setFirstShowView$1
                                                            public final /* synthetic */ String $name = "FuncModItem";

                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(0);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function0
                                                            public final Unit invoke() {
                                                                IReportChain iReportChain = IReportChain.this;
                                                                long currentTimeStamp = IPagerIdKtxKt.getBridgeModule(backgroundShopPage15).currentTimeStamp();
                                                                com.tencent.kuikly.core.nvi.serialization.json.e eVar = new com.tencent.kuikly.core.nvi.serialization.json.e();
                                                                eVar.v("view_name", this.$name);
                                                                Unit unit = Unit.INSTANCE;
                                                                iReportChain.append(new Node(401, currentTimeStamp, eVar, 100, 8));
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                    }
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            if (!com.tencent.kuikly.core.manager.c.f117352a.g().getPageData().n().g("isIosInCheck", false)) {
                                                final BackgroundShopPage backgroundShopPage13 = BackgroundShopPage.this;
                                                final float f39 = f36;
                                                vipTrackerView4.addChild(new FuncModItem(backgroundShopPage13), new Function1<FuncModItem, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.background_shop.BackgroundShopPage.body.1.2.3.6.3
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(FuncModItem funcModItem) {
                                                        final BackgroundShopPage backgroundShopPage14 = BackgroundShopPage.this;
                                                        final FuncModItemData funcModItemData = backgroundShopPage14.funcModItemData;
                                                        final float f46 = f39;
                                                        funcModItem.attr(new Function1<FuncModItemAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.background_shop.BackgroundShopPage.body.1.2.3.6.3.1
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(FuncModItemAttr funcModItemAttr) {
                                                                FuncModItemAttr funcModItemAttr2 = funcModItemAttr;
                                                                funcModItemAttr2.data = FuncModItemData.this;
                                                                funcModItemAttr2.positionAbsolute();
                                                                float f47 = 2;
                                                                funcModItemAttr2.m142left(f46 / f47);
                                                                funcModItemAttr2.itemWidth = f46 / f47;
                                                                final BackgroundShopPage backgroundShopPage15 = backgroundShopPage14;
                                                                final FuncModItemData funcModItemData2 = FuncModItemData.this;
                                                                funcModItemAttr2.click = new Function1<SchemaBuilder.TraceDetailInfo, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.background_shop.BackgroundShopPage.body.1.2.3.6.3.1.1
                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(SchemaBuilder.TraceDetailInfo traceDetailInfo) {
                                                                        BackgroundShopPage backgroundShopPage16 = BackgroundShopPage.this;
                                                                        StringBuilder m16 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("user click ");
                                                                        m16.append(funcModItemData2.getTitle());
                                                                        KLog.INSTANCE.i(backgroundShopPage16.getPageName(), m16.toString());
                                                                        BackgroundShopPage.this.platformApi.getVasModule().openPage(funcModItemData2.getUrl());
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                };
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                            }
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    final float f37 = f17;
                                    w.a(cmVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.background_shop.BackgroundShopPage.body.1.2.3.7
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(v vVar) {
                                            final float f38 = f37;
                                            vVar.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.background_shop.BackgroundShopPage.body.1.2.3.7.1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(t tVar) {
                                                    h hVar;
                                                    t tVar2 = tVar;
                                                    tVar2.mo153width(f38);
                                                    tVar2.mo141height(1.0f);
                                                    if (!VasUIToken.INSTANCE.isDarkMode()) {
                                                        hVar = new h(436207616L);
                                                    } else {
                                                        hVar = new h(452984831L);
                                                    }
                                                    tVar2.mo113backgroundColor(hVar);
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    final BackgroundShopPage backgroundShopPage11 = backgroundShopPage4;
                                    Function0<com.tencent.kuikly.core.reactive.collection.c<ItemData>> function02 = new Function0<com.tencent.kuikly.core.reactive.collection.c<ItemData>>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.background_shop.BackgroundShopPage.body.1.2.3.8
                                        {
                                            super(0);
                                        }

                                        @Override // kotlin.jvm.functions.Function0
                                        public final com.tencent.kuikly.core.reactive.collection.c<ItemData> invoke() {
                                            return BackgroundShopPage.access$getFirstData(BackgroundShopPage.this);
                                        }
                                    };
                                    final float f38 = f17;
                                    final float f39 = f18;
                                    final BackgroundShopPage backgroundShopPage12 = backgroundShopPage4;
                                    LoopDirectivesViewKt.a(cmVar2, function02, new Function2<LoopDirectivesView<ItemData>, ItemData, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.background_shop.BackgroundShopPage.body.1.2.3.9
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(2);
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public final Unit invoke(LoopDirectivesView<ItemData> loopDirectivesView, ItemData itemData) {
                                            BackgroundShopPageKt.DataToView(loopDirectivesView, itemData, f38, f39, backgroundShopPage12.isSvip());
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    final BackgroundShopPage backgroundShopPage13 = backgroundShopPage4;
                                    Function0<Object> function03 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.background_shop.BackgroundShopPage.body.1.2.3.10
                                        {
                                            super(0);
                                        }

                                        @Override // kotlin.jvm.functions.Function0
                                        public final Object invoke() {
                                            BackgroundShopPage backgroundShopPage14 = BackgroundShopPage.this;
                                            boolean z16 = false;
                                            if (((TagsItemData) backgroundShopPage14.tagsItemData$delegate.getValue(backgroundShopPage14, BackgroundShopPage.$$delegatedProperties[2])) != null && !com.tencent.kuikly.core.manager.c.f117352a.g().getPageData().n().g("isIosInCheck", false)) {
                                                z16 = true;
                                            }
                                            return Boolean.valueOf(z16);
                                        }
                                    };
                                    final BackgroundShopPage backgroundShopPage14 = backgroundShopPage4;
                                    final float f46 = f17;
                                    ConditionViewKt.c(cmVar2, function03, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.background_shop.BackgroundShopPage.body.1.2.3.11
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(ConditionView conditionView) {
                                            final BackgroundShopPage backgroundShopPage15 = BackgroundShopPage.this;
                                            final float f47 = f46;
                                            w.a(conditionView, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.background_shop.BackgroundShopPage.body.1.2.3.11.1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(v vVar) {
                                                    v vVar2 = vVar;
                                                    final float f48 = f47;
                                                    vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.background_shop.BackgroundShopPage.body.1.2.3.11.1.1
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(t tVar) {
                                                            tVar.mo153width(f48);
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    final BackgroundShopPage backgroundShopPage16 = BackgroundShopPage.this;
                                                    final float f49 = f47;
                                                    vVar2.addChild(new TagsItemView(backgroundShopPage16), new Function1<TagsItemView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.background_shop.BackgroundShopPage.body.1.2.3.11.1.2
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(TagsItemView tagsItemView) {
                                                            final float f56 = f49;
                                                            final BackgroundShopPage backgroundShopPage17 = backgroundShopPage16;
                                                            tagsItemView.attr(new Function1<TagsItemAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.background_shop.BackgroundShopPage.body.1.2.3.11.1.2.1
                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(TagsItemAttr tagsItemAttr) {
                                                                    TagsItemAttr tagsItemAttr2 = tagsItemAttr;
                                                                    tagsItemAttr2.itemWidth = f56;
                                                                    BackgroundShopPage backgroundShopPage18 = backgroundShopPage17;
                                                                    TagsItemData tagsItemData = (TagsItemData) backgroundShopPage18.tagsItemData$delegate.getValue(backgroundShopPage18, BackgroundShopPage.$$delegatedProperties[2]);
                                                                    Intrinsics.checkNotNull(tagsItemData);
                                                                    tagsItemAttr2.data = tagsItemData;
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
                                    final BackgroundShopPage backgroundShopPage15 = backgroundShopPage4;
                                    Function0<com.tencent.kuikly.core.reactive.collection.c<ItemData>> function04 = new Function0<com.tencent.kuikly.core.reactive.collection.c<ItemData>>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.background_shop.BackgroundShopPage.body.1.2.3.12
                                        {
                                            super(0);
                                        }

                                        @Override // kotlin.jvm.functions.Function0
                                        public final com.tencent.kuikly.core.reactive.collection.c<ItemData> invoke() {
                                            return BackgroundShopPage.access$getMoreData(BackgroundShopPage.this);
                                        }
                                    };
                                    final float f47 = f17;
                                    final float f48 = f18;
                                    final BackgroundShopPage backgroundShopPage16 = backgroundShopPage4;
                                    LoopDirectivesViewKt.a(cmVar2, function04, new Function2<LoopDirectivesView<ItemData>, ItemData, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.background_shop.BackgroundShopPage.body.1.2.3.13
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(2);
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public final Unit invoke(LoopDirectivesView<ItemData> loopDirectivesView, ItemData itemData) {
                                            BackgroundShopPageKt.DataToView(loopDirectivesView, itemData, f47, f48, backgroundShopPage16.isSvip());
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    final BackgroundShopPage backgroundShopPage17 = backgroundShopPage4;
                                    Function0<Object> function05 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.background_shop.BackgroundShopPage.body.1.2.3.14
                                        {
                                            super(0);
                                        }

                                        @Override // kotlin.jvm.functions.Function0
                                        public final Object invoke() {
                                            return Boolean.valueOf(BackgroundShopPage.access$getFirstData(BackgroundShopPage.this).size() > 20);
                                        }
                                    };
                                    final BackgroundShopPage backgroundShopPage18 = backgroundShopPage4;
                                    final float f49 = f17;
                                    final BackgroundShopPage backgroundShopPage19 = backgroundShopPage5;
                                    ConditionViewKt.c(cmVar2, function05, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.background_shop.BackgroundShopPage.body.1.2.3.15
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(ConditionView conditionView) {
                                            final BackgroundShopPage backgroundShopPage20 = BackgroundShopPage.this;
                                            final float f56 = f49;
                                            final BackgroundShopPage backgroundShopPage21 = backgroundShopPage19;
                                            z.a(conditionView, new Function1<FooterRefreshView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.background_shop.BackgroundShopPage.body.1.2.3.15.1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(FooterRefreshView footerRefreshView) {
                                                    FooterRefreshView footerRefreshView2 = footerRefreshView;
                                                    final BackgroundShopPage backgroundShopPage22 = BackgroundShopPage.this;
                                                    footerRefreshView2.ref(footerRefreshView2, new Function1<aa<FooterRefreshView>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.background_shop.BackgroundShopPage.body.1.2.3.15.1.1
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(aa<FooterRefreshView> aaVar) {
                                                            BackgroundShopPage.this.footerRefreshRef = aaVar;
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    final float f57 = f56;
                                                    footerRefreshView2.attr(new Function1<x, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.background_shop.BackgroundShopPage.body.1.2.3.15.1.2
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(x xVar) {
                                                            x xVar2 = xVar;
                                                            xVar2.k(600.0f);
                                                            xVar2.allCenter();
                                                            xVar2.mo153width(f57);
                                                            xVar2.mo141height(30.0f);
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    final BackgroundShopPage backgroundShopPage23 = BackgroundShopPage.this;
                                                    final BackgroundShopPage backgroundShopPage24 = backgroundShopPage21;
                                                    footerRefreshView2.event(new Function1<y, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.background_shop.BackgroundShopPage.body.1.2.3.15.1.3
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(y yVar) {
                                                            y yVar2 = yVar;
                                                            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
                                                            objectRef.element = "";
                                                            final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
                                                            booleanRef.element = true;
                                                            final BackgroundShopPage backgroundShopPage25 = BackgroundShopPage.this;
                                                            final BackgroundShopPage backgroundShopPage26 = backgroundShopPage24;
                                                            yVar2.i(new Function1<FooterRefreshState, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.background_shop.BackgroundShopPage.body.1.2.3.15.1.3.1

                                                                @DebugMetadata(c = "com.tencent.hippykotlin.demo.pages.vas_pages.background_shop.BackgroundShopPage$body$1$2$3$15$1$3$1$1", f = "BackgroundShopPage.kt", i = {}, l = {432}, m = "invokeSuspend", n = {}, s = {})
                                                                /* renamed from: com.tencent.hippykotlin.demo.pages.vas_pages.background_shop.BackgroundShopPage$body$1$2$3$15$1$3$1$1, reason: invalid class name and collision with other inner class name */
                                                                /* loaded from: classes33.dex */
                                                                public final class C56631 extends SuspendLambda implements Function2<com.tencent.kuikly.core.coroutines.b, Continuation<? super Unit>, Object> {
                                                                    public final /* synthetic */ BackgroundShopPage $ctx;
                                                                    public final /* synthetic */ Ref.BooleanRef $isFirstLoadMore;
                                                                    public final /* synthetic */ Ref.ObjectRef<String> $loadMoreSession;
                                                                    public int label;
                                                                    public final /* synthetic */ BackgroundShopPage this$0;

                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                    public C56631(BackgroundShopPage backgroundShopPage, BackgroundShopPage backgroundShopPage2, Ref.ObjectRef<String> objectRef, Ref.BooleanRef booleanRef, Continuation<? super C56631> continuation) {
                                                                        super(2, continuation);
                                                                        this.$ctx = backgroundShopPage;
                                                                        this.this$0 = backgroundShopPage2;
                                                                        this.$loadMoreSession = objectRef;
                                                                        this.$isFirstLoadMore = booleanRef;
                                                                    }

                                                                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                                                        return new C56631(this.$ctx, this.this$0, this.$loadMoreSession, this.$isFirstLoadMore, continuation);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function2
                                                                    public final Object invoke(com.tencent.kuikly.core.coroutines.b bVar, Continuation<? super Unit> continuation) {
                                                                        return ((C56631) create(bVar, continuation)).invokeSuspend(Unit.INSTANCE);
                                                                    }

                                                                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                                    public final Object invokeSuspend(Object obj) {
                                                                        Object coroutine_suspended;
                                                                        Object coroutine_suspended2;
                                                                        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                                                        int i3 = this.label;
                                                                        if (i3 == 0) {
                                                                            ResultKt.throwOnFailure(obj);
                                                                            BackgroundShopPage backgroundShopPage = this.this$0;
                                                                            final Ref.ObjectRef<String> objectRef = this.$loadMoreSession;
                                                                            final Ref.BooleanRef booleanRef = this.$isFirstLoadMore;
                                                                            final BackgroundShopPage backgroundShopPage2 = this.$ctx;
                                                                            String str = objectRef.element;
                                                                            Function2<List<? extends ItemData>, String, Unit> function2 = 
                                                                            /*  JADX ERROR: Method code generation error
                                                                                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0029: CONSTRUCTOR (r6v0 'function2' kotlin.jvm.functions.Function2<java.util.List<? extends com.tencent.hippykotlin.demo.pages.vas_pages.base_shop.data.ItemData>, java.lang.String, kotlin.Unit>) = 
                                                                                  (r3v0 'booleanRef' kotlin.jvm.internal.Ref$BooleanRef A[DONT_INLINE])
                                                                                  (r4v0 'backgroundShopPage2' com.tencent.hippykotlin.demo.pages.vas_pages.background_shop.BackgroundShopPage A[DONT_INLINE])
                                                                                  (r1v1 'objectRef' kotlin.jvm.internal.Ref$ObjectRef<java.lang.String> A[DONT_INLINE])
                                                                                 A[DECLARE_VAR, MD:(kotlin.jvm.internal.Ref$BooleanRef, com.tencent.hippykotlin.demo.pages.vas_pages.background_shop.BackgroundShopPage, kotlin.jvm.internal.Ref$ObjectRef<java.lang.String>):void (m)] (LINE:42) call: com.tencent.hippykotlin.demo.pages.vas_pages.background_shop.BackgroundShopPage$body$1$2$3$15$1$3$1$1$1$1.<init>(kotlin.jvm.internal.Ref$BooleanRef, com.tencent.hippykotlin.demo.pages.vas_pages.background_shop.BackgroundShopPage, kotlin.jvm.internal.Ref$ObjectRef):void type: CONSTRUCTOR in method: com.tencent.hippykotlin.demo.pages.vas_pages.background_shop.BackgroundShopPage.body.1.2.3.15.1.3.1.1.invokeSuspend(java.lang.Object):java.lang.Object, file: classes33.dex
                                                                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
                                                                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
                                                                                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:94)
                                                                                	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                                                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                                                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                                                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                                                                                	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                                                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                                                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:297)
                                                                                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:276)
                                                                                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:406)
                                                                                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
                                                                                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
                                                                                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                                                                                	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
                                                                                	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                                                                	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                                                                                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.hippykotlin.demo.pages.vas_pages.background_shop.BackgroundShopPage$body$1$2$3$15$1$3$1$1$1$1, state: NOT_LOADED
                                                                                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:304)
                                                                                	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:781)
                                                                                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:730)
                                                                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:418)
                                                                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:303)
                                                                                	... 21 more
                                                                                */
                                                                            /*
                                                                                this = this;
                                                                                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                                                                                int r1 = r7.label
                                                                                r2 = 1
                                                                                if (r1 == 0) goto L18
                                                                                if (r1 != r2) goto Lf
                                                                                kotlin.ResultKt.throwOnFailure(r8)
                                                                                goto L4a
                                                                            Lf:
                                                                                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                                                                                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                                                                                r8.<init>(r0)
                                                                                throw r8
                                                                            L18:
                                                                                kotlin.ResultKt.throwOnFailure(r8)
                                                                                com.tencent.hippykotlin.demo.pages.vas_pages.background_shop.BackgroundShopPage r8 = r7.this$0
                                                                                kotlin.jvm.internal.Ref$ObjectRef<java.lang.String> r1 = r7.$loadMoreSession
                                                                                kotlin.jvm.internal.Ref$BooleanRef r3 = r7.$isFirstLoadMore
                                                                                com.tencent.hippykotlin.demo.pages.vas_pages.background_shop.BackgroundShopPage r4 = r7.$ctx
                                                                                T r5 = r1.element
                                                                                java.lang.String r5 = (java.lang.String) r5
                                                                                com.tencent.hippykotlin.demo.pages.vas_pages.background_shop.BackgroundShopPage$body$1$2$3$15$1$3$1$1$1$1 r6 = new com.tencent.hippykotlin.demo.pages.vas_pages.background_shop.BackgroundShopPage$body$1$2$3$15$1$3$1$1$1$1
                                                                                r6.<init>(r3, r4, r1)
                                                                                r7.label = r2
                                                                                com.tencent.hippykotlin.demo.pages.vas_pages.base_shop.request.LoadMoreRequest r1 = new com.tencent.hippykotlin.demo.pages.vas_pages.base_shop.request.LoadMoreRequest
                                                                                r1.<init>()
                                                                                java.lang.String r3 = "8"
                                                                                r2 = r8
                                                                                r4 = r5
                                                                                r5 = r6
                                                                                r6 = r7
                                                                                java.lang.Object r8 = r1.loadMoreRequest(r2, r3, r4, r5, r6)
                                                                                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                                                                                if (r8 != r1) goto L45
                                                                                goto L47
                                                                            L45:
                                                                                kotlin.Unit r8 = kotlin.Unit.INSTANCE
                                                                            L47:
                                                                                if (r8 != r0) goto L4a
                                                                                return r0
                                                                            L4a:
                                                                                com.tencent.hippykotlin.demo.pages.vas_pages.background_shop.BackgroundShopPage r8 = r7.$ctx
                                                                                com.tencent.kuikly.core.base.aa<com.tencent.kuikly.core.views.FooterRefreshView> r8 = r8.footerRefreshRef
                                                                                if (r8 == 0) goto L51
                                                                                goto L58
                                                                            L51:
                                                                                java.lang.String r8 = "footerRefreshRef"
                                                                                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r8)
                                                                                r8 = 0
                                                                            L58:
                                                                                com.tencent.kuikly.core.base.DeclarativeBaseView r8 = r8.b()
                                                                                com.tencent.kuikly.core.views.FooterRefreshView r8 = (com.tencent.kuikly.core.views.FooterRefreshView) r8
                                                                                if (r8 == 0) goto L65
                                                                                com.tencent.kuikly.core.views.FooterRefreshEndState r0 = com.tencent.kuikly.core.views.FooterRefreshEndState.SUCCESS
                                                                                r8.t(r0)
                                                                            L65:
                                                                                kotlin.Unit r8 = kotlin.Unit.INSTANCE
                                                                                return r8
                                                                            */
                                                                            throw new UnsupportedOperationException("Method not decompiled: com.tencent.hippykotlin.demo.pages.vas_pages.background_shop.BackgroundShopPage$body$1.AnonymousClass2.AnonymousClass3.AnonymousClass15.AnonymousClass1.C56613.C56621.C56631.invokeSuspend(java.lang.Object):java.lang.Object");
                                                                        }
                                                                    }

                                                                    /* renamed from: com.tencent.hippykotlin.demo.pages.vas_pages.background_shop.BackgroundShopPage$body$1$2$3$15$1$3$1$WhenMappings */
                                                                    /* loaded from: classes33.dex */
                                                                    public /* synthetic */ class WhenMappings {
                                                                        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                                                                        static {
                                                                            int[] iArr = new int[FooterRefreshState.values().length];
                                                                            try {
                                                                                iArr[FooterRefreshState.REFRESHING.ordinal()] = 1;
                                                                            } catch (NoSuchFieldError unused) {
                                                                            }
                                                                            try {
                                                                                iArr[FooterRefreshState.IDLE.ordinal()] = 2;
                                                                            } catch (NoSuchFieldError unused2) {
                                                                            }
                                                                            try {
                                                                                iArr[FooterRefreshState.NONE_MORE_DATA.ordinal()] = 3;
                                                                            } catch (NoSuchFieldError unused3) {
                                                                            }
                                                                            try {
                                                                                iArr[FooterRefreshState.FAILURE.ordinal()] = 4;
                                                                            } catch (NoSuchFieldError unused4) {
                                                                            }
                                                                            $EnumSwitchMapping$0 = iArr;
                                                                        }
                                                                    }

                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(FooterRefreshState footerRefreshState) {
                                                                        int i18 = WhenMappings.$EnumSwitchMapping$0[footerRefreshState.ordinal()];
                                                                        if (i18 == 1) {
                                                                            BackgroundShopPage.this.setFooterRefreshText("\u52a0\u8f7d\u66f4\u591a\u4e2d..");
                                                                            BuildersKt.e(BackgroundShopPage.this.getPageScope(), null, null, new C56631(BackgroundShopPage.this, backgroundShopPage26, objectRef, booleanRef, null), 3, null);
                                                                        } else if (i18 == 2) {
                                                                            BackgroundShopPage.this.setFooterRefreshText("\u4e0a\u62c9\u52a0\u8f7d\u66f4\u591a");
                                                                        } else if (i18 == 3) {
                                                                            BackgroundShopPage.this.setFooterRefreshText("\u65e0\u66f4\u591a\u6570\u636e");
                                                                        } else if (i18 == 4) {
                                                                            BackgroundShopPage.this.setFooterRefreshText("\u70b9\u51fb\u91cd\u8bd5\u52a0\u8f7d\u66f4\u591a");
                                                                        }
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                final BackgroundShopPage backgroundShopPage27 = BackgroundShopPage.this;
                                                                yVar2.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.background_shop.BackgroundShopPage.body.1.2.3.15.1.3.2
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(ClickParams clickParams) {
                                                                        aa<FooterRefreshView> aaVar = BackgroundShopPage.this.footerRefreshRef;
                                                                        if (aaVar == null) {
                                                                            Intrinsics.throwUninitializedPropertyAccessException("footerRefreshRef");
                                                                            aaVar = null;
                                                                        }
                                                                        FooterRefreshView b16 = aaVar.b();
                                                                        if (b16 != null) {
                                                                            b16.p();
                                                                        }
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        final BackgroundShopPage backgroundShopPage25 = BackgroundShopPage.this;
                                                        cg.a(footerRefreshView2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.background_shop.BackgroundShopPage.body.1.2.3.15.1.4
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(TextView textView) {
                                                                final BackgroundShopPage backgroundShopPage26 = BackgroundShopPage.this;
                                                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.background_shop.BackgroundShopPage.body.1.2.3.15.1.4.1
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(ce ceVar) {
                                                                        h hVar;
                                                                        ce ceVar2 = ceVar;
                                                                        if (!VasUIToken.INSTANCE.isDarkMode()) {
                                                                            hVar = new h(4279901214L);
                                                                        } else {
                                                                            hVar = new h(4293980404L);
                                                                        }
                                                                        ceVar2.color(hVar);
                                                                        ce.fontSize$default(ceVar2, 20.0f, null, 2, null);
                                                                        BackgroundShopPage backgroundShopPage27 = BackgroundShopPage.this;
                                                                        ceVar2.text((String) backgroundShopPage27.footerRefreshText$delegate.getValue(backgroundShopPage27, BackgroundShopPage.$$delegatedProperties[4]));
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
                                final BackgroundShopPage backgroundShopPage6 = BackgroundShopPage.this;
                                VipTrackerKt.VipTracker(vipTrackerView2, new Function1<VipTrackerView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.background_shop.BackgroundShopPage.body.1.2.4
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(VipTrackerView vipTrackerView3) {
                                        VipTrackerView vipTrackerView4 = vipTrackerView3;
                                        float m16 = vipTrackerView4.getPagerData().m() < 375.0f ? vipTrackerView4.getPagerData().m() : 375.0f;
                                        final float f26 = (60.0f * m16) / 375.0f;
                                        final float m17 = (vipTrackerView4.getPagerData().m() - m16) / 2;
                                        vipTrackerView4.attr(new Function1<VipTrackerViewAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.background_shop.BackgroundShopPage.body.1.2.4.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(VipTrackerViewAttr vipTrackerViewAttr) {
                                                VipTrackerViewAttr vipTrackerViewAttr2 = vipTrackerViewAttr;
                                                vipTrackerViewAttr2.tracker.moduleId = "7";
                                                vipTrackerViewAttr2.tracker.expose = true;
                                                vipTrackerViewAttr2.positionAbsolute();
                                                vipTrackerViewAttr2.m142left(m17);
                                                vipTrackerViewAttr2.m149right(m17);
                                                vipTrackerViewAttr2.m150top((vipTrackerViewAttr2.getPagerData().l() - 20.0f) - f26);
                                                vipTrackerViewAttr2.m138bottom(20.0f);
                                                vipTrackerViewAttr2.justifyContentCenter();
                                                vipTrackerViewAttr2.alignItemsCenter();
                                                vipTrackerViewAttr2.accessibility("\u5f00\u901a\u6216\u7eed\u8d39\u8d85\u7ea7\u4f1a\u5458");
                                                vipTrackerViewAttr2.accessibilityRole(AccessibilityRole.BUTTON);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final BackgroundShopPage backgroundShopPage7 = BackgroundShopPage.this;
                                        VipTrackerKt.VipTracker(vipTrackerView4, new Function1<VipTrackerView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.background_shop.BackgroundShopPage.body.1.2.4.2
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(VipTrackerView vipTrackerView5) {
                                                VipTrackerView vipTrackerView6 = vipTrackerView5;
                                                vipTrackerView6.attr(new Function1<VipTrackerViewAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.background_shop.BackgroundShopPage.body.1.2.4.2.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(VipTrackerViewAttr vipTrackerViewAttr) {
                                                        VipTrackerViewAttr vipTrackerViewAttr2 = vipTrackerViewAttr;
                                                        Tracker tracker = vipTrackerViewAttr2.tracker;
                                                        tracker.itemType = "4";
                                                        tracker.itemId = "Open";
                                                        vipTrackerViewAttr2.positionAbsolute();
                                                        vipTrackerViewAttr2.m142left(0.0f);
                                                        vipTrackerViewAttr2.m150top(0.0f);
                                                        vipTrackerViewAttr2.m149right(0.0f);
                                                        vipTrackerViewAttr2.m138bottom(0.0f);
                                                        vipTrackerViewAttr2.justifyContentCenter();
                                                        vipTrackerViewAttr2.alignItemsCenter();
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                VasDynamicViewKt.VasDynamicImg(vipTrackerView6, new Function1<VasDynamicView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.background_shop.BackgroundShopPage.body.1.2.4.2.2
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(VasDynamicView vasDynamicView) {
                                                        vasDynamicView.attr(new Function1<DynamicAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.background_shop.BackgroundShopPage.body.1.2.4.2.2.1
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(DynamicAttr dynamicAttr) {
                                                                DynamicAttr dynamicAttr2 = dynamicAttr;
                                                                dynamicAttr2.positionAbsolute();
                                                                dynamicAttr2.m142left(0.0f);
                                                                dynamicAttr2.m150top(0.0f);
                                                                dynamicAttr2.m149right(0.0f);
                                                                dynamicAttr2.m138bottom(0.0f);
                                                                dynamicAttr2.with("src", "https://tianquan.gtimg.cn/shoal/qqgxh/f25e14d9-22cc-4c2c-986c-3ae211390022.png?_bid=5399");
                                                                dynamicAttr2.with("sceneTag", "shop");
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final BackgroundShopPage backgroundShopPage8 = BackgroundShopPage.this;
                                                final float f27 = f26;
                                                cg.a(vipTrackerView6, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.background_shop.BackgroundShopPage.body.1.2.4.2.3
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(TextView textView) {
                                                        final BackgroundShopPage backgroundShopPage9 = BackgroundShopPage.this;
                                                        final float f28 = f27;
                                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.background_shop.BackgroundShopPage.body.1.2.4.2.3.1

                                                            @DebugMetadata(c = "com.tencent.hippykotlin.demo.pages.vas_pages.background_shop.BackgroundShopPage$body$1$2$4$2$3$1$1", f = "BackgroundShopPage.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
                                                            /* renamed from: com.tencent.hippykotlin.demo.pages.vas_pages.background_shop.BackgroundShopPage$body$1$2$4$2$3$1$1, reason: invalid class name and collision with other inner class name */
                                                            /* loaded from: classes33.dex */
                                                            public final class C56881 extends SuspendLambda implements Function2<com.tencent.kuikly.core.coroutines.b, Continuation<? super Unit>, Object> {
                                                                public final /* synthetic */ BackgroundShopPage $ctx;
                                                                public final /* synthetic */ ce $this_attr;

                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                public C56881(BackgroundShopPage backgroundShopPage, ce ceVar, Continuation<? super C56881> continuation) {
                                                                    super(2, continuation);
                                                                    this.$ctx = backgroundShopPage;
                                                                    this.$this_attr = ceVar;
                                                                }

                                                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                                                    return new C56881(this.$ctx, this.$this_attr, continuation);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function2
                                                                public final Object invoke(com.tencent.kuikly.core.coroutines.b bVar, Continuation<? super Unit> continuation) {
                                                                    return ((C56881) create(bVar, continuation)).invokeSuspend(Unit.INSTANCE);
                                                                }

                                                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                                public final Object invokeSuspend(Object obj) {
                                                                    IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                                                    ResultKt.throwOnFailure(obj);
                                                                    if (this.$ctx.isSvip()) {
                                                                        this.$this_attr.text("\u5feb\u6765\u70b9\u6211\u7eed\u8d39\u8d85\u7ea7\u4f1a\u5458");
                                                                        this.$ctx.platformApi.getSpModule().a(this.$ctx.getPageName() + "_open_vip", "\u5feb\u6765\u70b9\u6211\u7eed\u8d39\u8d85\u7ea7\u4f1a\u5458");
                                                                    } else {
                                                                        this.$this_attr.text("\u5feb\u6765\u70b9\u6211\u5f00\u901a\u8d85\u7ea7\u4f1a\u5458");
                                                                        this.$ctx.platformApi.getSpModule().a(this.$ctx.getPageName() + "_open_vip", "\u5feb\u6765\u70b9\u6211\u5f00\u901a\u8d85\u7ea7\u4f1a\u5458");
                                                                    }
                                                                    return Unit.INSTANCE;
                                                                }
                                                            }

                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ce ceVar) {
                                                                ce ceVar2 = ceVar;
                                                                String string = BackgroundShopPage.this.platformApi.getSpModule().getString(BackgroundShopPage.this.getPageName() + "_open_vip");
                                                                if (string.length() == 0) {
                                                                    ceVar2.text("\u5feb\u6765\u70b9\u6211\u7eed\u8d39\u8d85\u7ea7\u4f1a\u5458");
                                                                } else {
                                                                    ceVar2.text(string);
                                                                }
                                                                BuildersKt.e(BackgroundShopPage.this.getPageScope(), null, null, new C56881(BackgroundShopPage.this, ceVar2, null), 3, null);
                                                                ce.fontSize$default(ceVar2, 16.0f, null, 2, null);
                                                                ceVar2.marginTop(f28 / 5.0f);
                                                                ceVar2.marginLeft(ceVar2.getPagerData().m() / 8);
                                                                ceVar2.fontWeightBold();
                                                                ceVar2.color(h.INSTANCE.o("0xFF5b3505"));
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final BackgroundShopPage backgroundShopPage9 = BackgroundShopPage.this;
                                                vipTrackerView6.event(new Function1<VipTrackerViewEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.background_shop.BackgroundShopPage.body.1.2.4.2.4
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(VipTrackerViewEvent vipTrackerViewEvent) {
                                                        final BackgroundShopPage backgroundShopPage10 = BackgroundShopPage.this;
                                                        vipTrackerViewEvent.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.background_shop.BackgroundShopPage.body.1.2.4.2.4.1
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ClickParams clickParams) {
                                                                List listOf;
                                                                KLog.INSTANCE.i(BackgroundShopPage.this.getPageName(), "user click open svip");
                                                                listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"svip", "vip"});
                                                                VasPayHelper.openKuiklyPay$default(new VasPayData("mvip.g.a.act_bjktt", listOf, null, new com.tencent.kuikly.core.nvi.serialization.json.e(new Function1<com.tencent.kuikly.core.nvi.serialization.json.e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.background_shop.BackgroundShopPage.body.1.2.4.2.4.1.1
                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(com.tencent.kuikly.core.nvi.serialization.json.e eVar) {
                                                                        eVar.C("traceDetail", new Function1<com.tencent.kuikly.core.nvi.serialization.json.e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.background_shop.BackgroundShopPage.body.1.2.4.2.4.1.1.1
                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(com.tencent.kuikly.core.nvi.serialization.json.e eVar2) {
                                                                                com.tencent.kuikly.core.nvi.serialization.json.e eVar3 = eVar2;
                                                                                eVar3.z("appid", "kuikly_chatbgMall");
                                                                                eVar3.z("page_id", "1");
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        });
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                }), 3544));
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final BackgroundShopPage backgroundShopPage10 = BackgroundShopPage.this;
                                                vipTrackerView6.performTaskWhenRenderViewDidLoad(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.background_shop.BackgroundShopPage.body.1.2.4.2.5
                                                    {
                                                        super(0);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function0
                                                    public final Unit invoke() {
                                                        VasBasePage.PagePerfReport pagePerfReport = BackgroundShopPage.this._perfReport;
                                                        if (pagePerfReport.firstScreenShowedTime <= 0) {
                                                            pagePerfReport.firstScreenShowedTime = ((BridgeModule) com.tencent.kuikly.core.manager.c.f117352a.g().acquireModule("HRBridgeModule")).currentTimeStamp();
                                                            VasBasePage vasBasePage = pagePerfReport.page;
                                                            StringBuilder m18 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("viewDidLoadTime = ");
                                                            m18.append(pagePerfReport.viewDidLoadTime);
                                                            m18.append(" firstScreenShowedTime = ");
                                                            m18.append(pagePerfReport.firstScreenShowedTime);
                                                            String sb5 = m18.toString();
                                                            if (vasBasePage.isDebug()) {
                                                                KLog.INSTANCE.d(vasBasePage.getPageName(), sb5);
                                                            }
                                                            pagePerfReport.reportPerformance();
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
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                };
            }

            @Override // com.tencent.hippykotlin.demo.pages.vas_base.VasBasePage, com.tencent.hippykotlin.demo.pages.base.BasePager, com.tencent.kuikly.core.base.ComposeView
            public final void created() {
                super.created();
                this.friendUin = getPagerData().n().q("frienduin", "");
                this.uinType = getPagerData().n().k("uintype", 0);
                this.funcModItemData.setTitle(this.platformApi.getSpModule().getString(getPageName() + "_func_data_title"));
                this.funcModItemData.setDesc(this.platformApi.getSpModule().getString(getPageName() + "_func_data_desc"));
                this.funcModItemData.setIcon(this.platformApi.getSpModule().getString(getPageName() + "_func_data_icon"));
                this.funcModItemData.setUrl(this.platformApi.getSpModule().getString(getPageName() + "_func_data_url"));
                String str = null;
                BuildersKt.e(getPageScope(), null, null, new BackgroundShopPage$created$1(this, null), 3, null);
                VasModule vasModule = this.platformApi.getVasModule();
                vasModule.getClass();
                KLog.INSTANCE.e("VasModule", "preloadWebProcess");
                vasModule.toNative(false, "preloadWebProcess", null, null, false);
                BuildersKt.e(getPageScope(), null, null, new BackgroundShopPage$created$2(this, null), 3, null);
                if (getPagerData().getIsAndroid()) {
                    VasModule vasModule2 = this.platformApi.getVasModule();
                    String str2 = this.friendUin;
                    if (str2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("friendUin");
                    } else {
                        str = str2;
                    }
                    vasModule2.updateCurrentChatBgId(str, this.uinType);
                }
            }

            @Override // com.tencent.hippykotlin.demo.pages.vas_base.VasBasePage
            public final Triple<String, Integer, Boolean> getReportConfig() {
                return new Triple<>("vas_background_shop", 0, Boolean.FALSE);
            }

            public final boolean isSvip() {
                return ((Boolean) this.isSvip$delegate.getValue(this, $$delegatedProperties[5])).booleanValue();
            }

            @Override // com.tencent.hippykotlin.demo.pages.vas_base.VasBasePage, com.tencent.hippykotlin.demo.pages.base.BasePager, com.tencent.kuikly.core.pager.Pager
            public final void pageWillDestroy() {
                super.pageWillDestroy();
                if (getPagerData().getIsAndroid()) {
                    this.platformApi.getVasModule().updateCurrentChatBgId("", 0);
                }
                com.tencent.kuikly.core.nvi.serialization.json.e eVar = new com.tencent.kuikly.core.nvi.serialization.json.e();
                VasModule vasModule = this.platformApi.getVasModule();
                String eVar2 = eVar.toString();
                VasModule.Companion companion = VasModule.Companion;
                vasModule.writeH5Data("/vip/gxh/bgshop", "currentChatInfo", eVar2, null);
            }

            public final void setFooterRefreshText(String str) {
                this.footerRefreshText$delegate.setValue(this, $$delegatedProperties[4], str);
            }
        }
