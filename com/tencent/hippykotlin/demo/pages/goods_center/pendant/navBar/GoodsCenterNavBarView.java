package com.tencent.hippykotlin.demo.pages.goods_center.pendant.navBar;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieCategoryHomePage$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.BridgeModule;
import com.tencent.hippykotlin.demo.pages.base.ECSearchBar;
import com.tencent.hippykotlin.demo.pages.base.ECSearchBarAttr;
import com.tencent.hippykotlin.demo.pages.base.ECSearchBarEvent;
import com.tencent.hippykotlin.demo.pages.base.ECSearchState;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.base.extension.AttrExtKt;
import com.tencent.hippykotlin.demo.pages.game_content_page.GameContentPage$body$1$3$1$3$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.goods_center.event.GoodsCenterEventDataBackEvent;
import com.tencent.hippykotlin.demo.pages.goods_center.event.GoodsCenterEventDataSearchText;
import com.tencent.hippykotlin.demo.pages.goods_center.shell.GoodsCenterEvent;
import com.tencent.hippykotlin.demo.pages.goods_center.shell.GoodsCenterPendantAttr;
import com.tencent.hippykotlin.demo.pages.goods_center.shell.GoodsCenterPendantView;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.aa;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.b;
import com.tencent.kuikly.core.base.event.AnimationCompletionParams;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.directives.BindDirectivesView;
import com.tencent.kuikly.core.directives.BindDirectivesViewKt;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.manager.BridgeManager;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.reactive.ReactiveObserver;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.InputParams;
import com.tencent.kuikly.core.views.InputView;
import com.tencent.kuikly.core.views.ScrollParams;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ah;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.u;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class GoodsCenterNavBarView extends GoodsCenterPendantView {
    public aa<ECSearchBar> searchBarRef;

    /* JADX WARN: Multi-variable type inference failed */
    public static final void access$beginEditing(GoodsCenterNavBarView goodsCenterNavBarView) {
        A attr = goodsCenterNavBarView.getAttr();
        Intrinsics.checkNotNull(attr, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.goods_center.pendant.navBar.GoodsCenterNavBarViewAttr");
        ((GoodsCenterNavBarViewAttr) attr).navViewModel().setAfterSearch(false);
        ((GoodsCenterEvent) goodsCenterNavBarView.getEvent()).onFireEvent("begin_editing", null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void access$bodyWithNavBar(final GoodsCenterNavBarView goodsCenterNavBarView) {
        A attr = goodsCenterNavBarView.getAttr();
        Intrinsics.checkNotNull(attr, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.goods_center.pendant.navBar.GoodsCenterNavBarViewAttr");
        final GoodsCenterNavBarViewAttr goodsCenterNavBarViewAttr = (GoodsCenterNavBarViewAttr) attr;
        final GoodsCenterNavBarViewModel navViewModel = goodsCenterNavBarViewAttr.navViewModel();
        w.a(goodsCenterNavBarView, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.pendant.navBar.GoodsCenterNavBarView$bodyWithNavBar$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(v vVar) {
                v vVar2 = vVar;
                final GoodsCenterNavBarView goodsCenterNavBarView2 = GoodsCenterNavBarView.this;
                vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.pendant.navBar.GoodsCenterNavBarView$bodyWithNavBar$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(t tVar) {
                        t tVar2 = tVar;
                        Attr.absolutePosition$default(tVar2, GoodsCenterNavBarView.this.getPagerData().getStatusBarHeight(), 0.0f, 0.0f, 0.0f, 4, null).mo141height(36.0f);
                        tVar2.flexDirectionRow().alignItemsFlexEnd();
                        return Unit.INSTANCE;
                    }
                });
                final GoodsCenterNavBarView goodsCenterNavBarView3 = GoodsCenterNavBarView.this;
                w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.pendant.navBar.GoodsCenterNavBarView$bodyWithNavBar$1.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar3) {
                        v vVar4 = vVar3;
                        vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.pendant.navBar.GoodsCenterNavBarView.bodyWithNavBar.1.2.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.mo153width(30.0f).mo141height(30.0f);
                                tVar2.justifyContentFlexEnd();
                                return Unit.INSTANCE;
                            }
                        });
                        final GoodsCenterNavBarView goodsCenterNavBarView4 = GoodsCenterNavBarView.this;
                        vVar4.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.pendant.navBar.GoodsCenterNavBarView.bodyWithNavBar.1.2.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(u uVar) {
                                final GoodsCenterNavBarView goodsCenterNavBarView5 = GoodsCenterNavBarView.this;
                                uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.pendant.navBar.GoodsCenterNavBarView.bodyWithNavBar.1.2.2.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ClickParams clickParams) {
                                        GoodsCenterNavBarView.access$tapBackButton(GoodsCenterNavBarView.this);
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        ah.a(vVar4, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.pendant.navBar.GoodsCenterNavBarView.bodyWithNavBar.1.2.3
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ImageView imageView) {
                                imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.pendant.navBar.GoodsCenterNavBarView.bodyWithNavBar.1.2.3.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(af afVar) {
                                        af afVar2 = afVar;
                                        afVar2.size(25.0f, 25.0f).marginLeft(8.0f);
                                        b.a.b(afVar2, "qecommerce_skin_icon_nav_arrow_left", false, 2, null);
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final GoodsCenterNavBarViewAttr goodsCenterNavBarViewAttr2 = goodsCenterNavBarViewAttr;
                cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.pendant.navBar.GoodsCenterNavBarView$bodyWithNavBar$1.3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(TextView textView) {
                        final GoodsCenterNavBarViewAttr goodsCenterNavBarViewAttr3 = GoodsCenterNavBarViewAttr.this;
                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.pendant.navBar.GoodsCenterNavBarView.bodyWithNavBar.1.3.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ce ceVar) {
                                ce ceVar2 = ceVar;
                                Attr.absolutePosition$default(ceVar2, 0.0f, 30.0f, 1.0f, 30.0f, 1, null);
                                GoodsCenterNavBarViewAttr goodsCenterNavBarViewAttr4 = GoodsCenterNavBarViewAttr.this;
                                ceVar2.m147opacity(((Number) goodsCenterNavBarViewAttr4.navTitleOpacity$delegate.getValue(goodsCenterNavBarViewAttr4, GoodsCenterNavBarViewAttr.$$delegatedProperties[3])).floatValue());
                                ce.fontSize$default(ceVar2, 17.0f, null, 2, null).fontWeightMedium().color(h.INSTANCE.b());
                                ceVar2.value("\u5e26\u8d27\u4e2d\u5fc3").textAlignCenter();
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                return Unit.INSTANCE;
            }
        });
        BindDirectivesViewKt.a(goodsCenterNavBarView, new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.pendant.navBar.GoodsCenterNavBarView$bodyWithNavBar$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Integer.valueOf(GoodsCenterNavBarViewModel.this.getSysBackCalledAutoIncreaseId());
            }
        }, new Function1<BindDirectivesView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.pendant.navBar.GoodsCenterNavBarView$bodyWithNavBar$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(BindDirectivesView bindDirectivesView) {
                if (GoodsCenterNavBarViewModel.this.getSysBackCalledAutoIncreaseId() > 0) {
                    GoodsCenterNavBarView.access$tapBackButton(goodsCenterNavBarView);
                }
                return Unit.INSTANCE;
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void access$bodyWithSearchView(final GoodsCenterNavBarView goodsCenterNavBarView) {
        A attr = goodsCenterNavBarView.getAttr();
        Intrinsics.checkNotNull(attr, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.goods_center.pendant.navBar.GoodsCenterNavBarViewAttr");
        final GoodsCenterNavBarViewAttr goodsCenterNavBarViewAttr = (GoodsCenterNavBarViewAttr) attr;
        final GoodsCenterNavBarViewModel navViewModel = goodsCenterNavBarViewAttr.navViewModel();
        goodsCenterNavBarView.getPagerData();
        w.a(goodsCenterNavBarView, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.pendant.navBar.GoodsCenterNavBarView$bodyWithSearchView$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(v vVar) {
                v vVar2 = vVar;
                final GoodsCenterNavBarViewAttr goodsCenterNavBarViewAttr2 = GoodsCenterNavBarViewAttr.this;
                final GoodsCenterNavBarViewModel goodsCenterNavBarViewModel = navViewModel;
                vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.pendant.navBar.GoodsCenterNavBarView$bodyWithSearchView$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(t tVar) {
                        t tVar2 = tVar;
                        GoodsCenterNavBarViewAttr goodsCenterNavBarViewAttr3 = GoodsCenterNavBarViewAttr.this;
                        Attr.absolutePosition$default(tVar2, GoodsCenterNavBarViewAttr.this.getSearchTop(), ((Number) goodsCenterNavBarViewAttr3.searchLeftSpace$delegate.getValue(goodsCenterNavBarViewAttr3, GoodsCenterNavBarViewAttr.$$delegatedProperties[2])).floatValue(), 0.0f, 16.0f, 4, null);
                        tVar2.mo141height(36.0f);
                        tVar2.justifyContentCenter();
                        GoodsCenterNavBarViewModel goodsCenterNavBarViewModel2 = goodsCenterNavBarViewModel;
                        AttrExtKt.backgroundColorToken(tVar2, (String) goodsCenterNavBarViewModel2.searchBarBackgroundColor$delegate.getValue(goodsCenterNavBarViewModel2, GoodsCenterNavBarViewModel.$$delegatedProperties[2]));
                        tVar2.borderRadius(4.0f);
                        tVar2.m134animation(b.Companion.l(com.tencent.kuikly.core.base.b.INSTANCE, 0.2f, null, 2, null), (Object) Boolean.valueOf(GoodsCenterNavBarViewAttr.this.isSearching()));
                        return Unit.INSTANCE;
                    }
                });
                final GoodsCenterNavBarViewAttr goodsCenterNavBarViewAttr3 = GoodsCenterNavBarViewAttr.this;
                final GoodsCenterNavBarView goodsCenterNavBarView2 = goodsCenterNavBarView;
                vVar2.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.pendant.navBar.GoodsCenterNavBarView$bodyWithSearchView$1.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(u uVar) {
                        u uVar2 = uVar;
                        final GoodsCenterNavBarViewAttr goodsCenterNavBarViewAttr4 = GoodsCenterNavBarViewAttr.this;
                        final GoodsCenterNavBarView goodsCenterNavBarView3 = goodsCenterNavBarView2;
                        uVar2.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.pendant.navBar.GoodsCenterNavBarView.bodyWithSearchView.1.2.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ClickParams clickParams) {
                                if (!GoodsCenterNavBarViewAttr.this.isSearching()) {
                                    GoodsCenterNavBarView.access$tapSearchBar(goodsCenterNavBarView3);
                                }
                                return Unit.INSTANCE;
                            }
                        });
                        final GoodsCenterNavBarView goodsCenterNavBarView4 = goodsCenterNavBarView2;
                        uVar2.animationCompletion(new Function1<AnimationCompletionParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.pendant.navBar.GoodsCenterNavBarView.bodyWithSearchView.1.2.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(AnimationCompletionParams animationCompletionParams) {
                                GoodsCenterNavBarView.this.mainViewScrollEnd();
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final GoodsCenterNavBarViewAttr goodsCenterNavBarViewAttr4 = GoodsCenterNavBarViewAttr.this;
                ConditionViewKt.c(vVar2, new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.pendant.navBar.GoodsCenterNavBarView$bodyWithSearchView$1.3
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Boolean.valueOf(!GoodsCenterNavBarViewAttr.this.isSearching());
                    }
                }, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.pendant.navBar.GoodsCenterNavBarView$bodyWithSearchView$1.4
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ConditionView conditionView) {
                        w.a(conditionView, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.pendant.navBar.GoodsCenterNavBarView.bodyWithSearchView.1.4.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                v vVar4 = vVar3;
                                vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.pendant.navBar.GoodsCenterNavBarView.bodyWithSearchView.1.4.1.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.alignSelfCenter();
                                        tVar2.flexDirectionRow();
                                        tVar2.allCenter();
                                        return Unit.INSTANCE;
                                    }
                                });
                                ah.a(vVar4, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.pendant.navBar.GoodsCenterNavBarView.bodyWithSearchView.1.4.1.2
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ImageView imageView) {
                                        imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.pendant.navBar.GoodsCenterNavBarView.bodyWithSearchView.1.4.1.2.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(af afVar) {
                                                af afVar2 = afVar;
                                                b.a.b(afVar2, "qecommerce_skin_icon_general_search_secondary", false, 2, null);
                                                afVar2.size(16.0f, 16.0f);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.pendant.navBar.GoodsCenterNavBarView.bodyWithSearchView.1.4.1.3
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(TextView textView) {
                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.pendant.navBar.GoodsCenterNavBarView.bodyWithSearchView.1.4.1.3.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ce ceVar) {
                                                ce ceVar2 = ceVar;
                                                ceVar2.marginLeft(4.0f);
                                                ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                                ceVar2.lineHeight(20.0f);
                                                AttrExtKt.colorToken(ceVar2, "qecommerce_skin_color_text_secondary");
                                                ceVar2.text("\u641c\u7d22");
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
                final GoodsCenterNavBarView goodsCenterNavBarView3 = goodsCenterNavBarView;
                final GoodsCenterNavBarViewModel goodsCenterNavBarViewModel2 = navViewModel;
                ConditionViewKt.a(vVar2, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.pendant.navBar.GoodsCenterNavBarView$bodyWithSearchView$1.5
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ConditionView conditionView) {
                        ConditionView conditionView2 = conditionView;
                        final GoodsCenterNavBarView goodsCenterNavBarView4 = GoodsCenterNavBarView.this;
                        Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.pendant.navBar.GoodsCenterNavBarView.bodyWithSearchView.1.5.1
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Boolean.valueOf(!GoodsCenterNavBarView.this.getPagerData().getIsIOS());
                            }
                        };
                        final GoodsCenterNavBarViewModel goodsCenterNavBarViewModel3 = goodsCenterNavBarViewModel2;
                        final GoodsCenterNavBarView goodsCenterNavBarView5 = GoodsCenterNavBarView.this;
                        ConditionViewKt.c(conditionView2, function0, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.pendant.navBar.GoodsCenterNavBarView.bodyWithSearchView.1.5.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ConditionView conditionView3) {
                                final GoodsCenterNavBarViewModel goodsCenterNavBarViewModel4 = GoodsCenterNavBarViewModel.this;
                                final GoodsCenterNavBarView goodsCenterNavBarView6 = goodsCenterNavBarView5;
                                conditionView3.addChild(new GoodsCenterSearchBarForAndroid(), new Function1<GoodsCenterSearchBarForAndroid, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.pendant.navBar.GoodsCenterNavBarView.bodyWithSearchView.1.5.2.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(GoodsCenterSearchBarForAndroid goodsCenterSearchBarForAndroid) {
                                        GoodsCenterSearchBarForAndroid goodsCenterSearchBarForAndroid2 = goodsCenterSearchBarForAndroid;
                                        final GoodsCenterNavBarViewModel goodsCenterNavBarViewModel5 = GoodsCenterNavBarViewModel.this;
                                        goodsCenterSearchBarForAndroid2.attr(new Function1<SearchBarForAndroidAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.pendant.navBar.GoodsCenterNavBarView.bodyWithSearchView.1.5.2.1.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(SearchBarForAndroidAttr searchBarForAndroidAttr) {
                                                SearchBarForAndroidAttr searchBarForAndroidAttr2 = searchBarForAndroidAttr;
                                                searchBarForAndroidAttr2.searchTxt$delegate.setValue(searchBarForAndroidAttr2, SearchBarForAndroidAttr.$$delegatedProperties[0], GoodsCenterNavBarViewModel.this.getSearchText());
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final GoodsCenterNavBarView goodsCenterNavBarView7 = goodsCenterNavBarView6;
                                        final GoodsCenterNavBarViewModel goodsCenterNavBarViewModel6 = GoodsCenterNavBarViewModel.this;
                                        goodsCenterSearchBarForAndroid2.event(new Function1<SearchBarForAndroidEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.pendant.navBar.GoodsCenterNavBarView.bodyWithSearchView.1.5.2.1.2
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(SearchBarForAndroidEvent searchBarForAndroidEvent) {
                                                SearchBarForAndroidEvent searchBarForAndroidEvent2 = searchBarForAndroidEvent;
                                                final GoodsCenterNavBarView goodsCenterNavBarView8 = GoodsCenterNavBarView.this;
                                                searchBarForAndroidEvent2.tapSearchBarCallback = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.pendant.navBar.GoodsCenterNavBarView.bodyWithSearchView.1.5.2.1.2.1
                                                    {
                                                        super(0);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function0
                                                    public final Unit invoke() {
                                                        GoodsCenterNavBarView.access$tapSearchBar(GoodsCenterNavBarView.this);
                                                        return Unit.INSTANCE;
                                                    }
                                                };
                                                final GoodsCenterNavBarViewModel goodsCenterNavBarViewModel7 = goodsCenterNavBarViewModel6;
                                                final GoodsCenterNavBarView goodsCenterNavBarView9 = GoodsCenterNavBarView.this;
                                                searchBarForAndroidEvent2.tapClearIconCallback = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.pendant.navBar.GoodsCenterNavBarView.bodyWithSearchView.1.5.2.1.2.2
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(0);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function0
                                                    public final Unit invoke() {
                                                        GoodsCenterNavBarViewModel.this.setSearchText("");
                                                        GoodsCenterNavBarView.access$tapSearchBar(goodsCenterNavBarView9);
                                                        return Unit.INSTANCE;
                                                    }
                                                };
                                                final GoodsCenterNavBarView goodsCenterNavBarView10 = GoodsCenterNavBarView.this;
                                                searchBarForAndroidEvent2.animationCompletion(new Function1<AnimationCompletionParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.pendant.navBar.GoodsCenterNavBarView.bodyWithSearchView.1.5.2.1.2.3
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(AnimationCompletionParams animationCompletionParams) {
                                                        GoodsCenterNavBarView.this.mainViewScrollEnd();
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
                        final GoodsCenterNavBarViewModel goodsCenterNavBarViewModel4 = goodsCenterNavBarViewModel2;
                        final GoodsCenterNavBarView goodsCenterNavBarView6 = GoodsCenterNavBarView.this;
                        ConditionViewKt.a(conditionView2, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.pendant.navBar.GoodsCenterNavBarView.bodyWithSearchView.1.5.3
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ConditionView conditionView3) {
                                final GoodsCenterNavBarView goodsCenterNavBarView7 = goodsCenterNavBarView6;
                                conditionView3.addChild(new ECSearchBar(), new Function1<ECSearchBar, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.pendant.navBar.GoodsCenterNavBarView.bodyWithSearchView.1.5.3.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ECSearchBar eCSearchBar) {
                                        ECSearchBar eCSearchBar2 = eCSearchBar;
                                        final GoodsCenterNavBarView goodsCenterNavBarView8 = GoodsCenterNavBarView.this;
                                        eCSearchBar2.ref(eCSearchBar2, new Function1<aa<ECSearchBar>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.pendant.navBar.GoodsCenterNavBarView.bodyWithSearchView.1.5.3.1.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(aa<ECSearchBar> aaVar) {
                                                GoodsCenterNavBarView.this.searchBarRef = aaVar;
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        eCSearchBar2.attr(new Function1<ECSearchBarAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.pendant.navBar.GoodsCenterNavBarView.bodyWithSearchView.1.5.3.1.2
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ECSearchBarAttr eCSearchBarAttr) {
                                                eCSearchBarAttr.mo141height(36.0f);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final GoodsCenterNavBarView goodsCenterNavBarView9 = GoodsCenterNavBarView.this;
                                        eCSearchBar2.event(new Function1<ECSearchBarEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.pendant.navBar.GoodsCenterNavBarView.bodyWithSearchView.1.5.3.1.3
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ECSearchBarEvent eCSearchBarEvent) {
                                                ECSearchBarEvent eCSearchBarEvent2 = eCSearchBarEvent;
                                                final GoodsCenterNavBarView goodsCenterNavBarView10 = GoodsCenterNavBarView.this;
                                                final Function1<InputParams, Unit> function1 = new Function1<InputParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.pendant.navBar.GoodsCenterNavBarView.bodyWithSearchView.1.5.3.1.3.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(InputParams inputParams) {
                                                        GoodsCenterNavBarView.access$beginEditing(GoodsCenterNavBarView.this);
                                                        return Unit.INSTANCE;
                                                    }
                                                };
                                                eCSearchBarEvent2.getClass();
                                                eCSearchBarEvent2.register("didBeginEditingWithText", new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.ECSearchBarEvent$didBeginEditingWithText$1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    /* JADX WARN: Multi-variable type inference failed */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(Object obj) {
                                                        Function1<InputParams, Unit> function12 = function1;
                                                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.tencent.kuikly.core.views.InputParams");
                                                        function12.invoke((InputParams) obj);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final GoodsCenterNavBarView goodsCenterNavBarView11 = GoodsCenterNavBarView.this;
                                                final Function1<InputParams, Unit> function12 = new Function1<InputParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.pendant.navBar.GoodsCenterNavBarView.bodyWithSearchView.1.5.3.1.3.2
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(InputParams inputParams) {
                                                        GoodsCenterNavBarView.access$didSearchText(GoodsCenterNavBarView.this, inputParams.getText());
                                                        return Unit.INSTANCE;
                                                    }
                                                };
                                                eCSearchBarEvent2.register("didSearchWithText", new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.ECSearchBarEvent$didSearchWithText$1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    /* JADX WARN: Multi-variable type inference failed */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(Object obj) {
                                                        Function1<InputParams, Unit> function13 = function12;
                                                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.tencent.kuikly.core.views.InputParams");
                                                        function13.invoke((InputParams) obj);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                ReactiveObserver.Companion companion = ReactiveObserver.INSTANCE;
                                String searchText = GoodsCenterNavBarViewModel.this.getSearchText();
                                final GoodsCenterNavBarView goodsCenterNavBarView8 = goodsCenterNavBarView6;
                                final GoodsCenterNavBarViewModel goodsCenterNavBarViewModel5 = GoodsCenterNavBarViewModel.this;
                                companion.b(searchText, new Function1<Boolean, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.pendant.navBar.GoodsCenterNavBarView.bodyWithSearchView.1.5.3.2
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(Boolean bool) {
                                        ECSearchBar b16;
                                        InputView b17;
                                        ECSearchBar b18;
                                        bool.booleanValue();
                                        aa<ECSearchBar> aaVar = GoodsCenterNavBarView.this.searchBarRef;
                                        if (aaVar != null && (b18 = aaVar.b()) != null) {
                                            String searchText2 = goodsCenterNavBarViewModel5.getSearchText();
                                            InputView b19 = b18.getInputRef().b();
                                            if (b19 != null) {
                                                b19.setText(searchText2);
                                            }
                                        }
                                        aa<ECSearchBar> aaVar2 = GoodsCenterNavBarView.this.searchBarRef;
                                        if (aaVar2 != null && (b16 = aaVar2.b()) != null && (b17 = b16.getInputRef().b()) != null) {
                                            b17.h();
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
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void access$didSearchText(GoodsCenterNavBarView goodsCenterNavBarView, String str) {
        CharSequence trim;
        goodsCenterNavBarView.getClass();
        if (!(str.length() == 0)) {
            trim = StringsKt__StringsKt.trim((CharSequence) str);
            String obj = trim.toString();
            if (obj.length() == 0) {
                Utils.INSTANCE.currentBridgeModule().toast("\u641c\u7d22\u5185\u5bb9\u4e0d\u80fd\u4e3a\u7a7a");
                return;
            } else {
                ((GoodsCenterEvent) goodsCenterNavBarView.getEvent()).onFireEvent("click_search", new GoodsCenterEventDataSearchText(new Regex("\\s{2,}").replace(obj, " "), 1));
                return;
            }
        }
        Utils.INSTANCE.currentBridgeModule().toast("\u641c\u7d22\u5185\u5bb9\u4e0d\u80fd\u4e3a\u7a7a");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void access$setStaticSearchBar(GoodsCenterNavBarView goodsCenterNavBarView) {
        A attr = goodsCenterNavBarView.getAttr();
        Intrinsics.checkNotNull(attr, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.goods_center.pendant.navBar.GoodsCenterNavBarViewAttr");
        GoodsCenterNavBarViewAttr goodsCenterNavBarViewAttr = (GoodsCenterNavBarViewAttr) attr;
        goodsCenterNavBarViewAttr.searchLeftSpace$delegate.setValue(goodsCenterNavBarViewAttr, GoodsCenterNavBarViewAttr.$$delegatedProperties[2], Float.valueOf(36.0f));
        goodsCenterNavBarViewAttr.setSearchTop(goodsCenterNavBarViewAttr.getSearchMaxTop() - 45.0f);
        goodsCenterNavBarViewAttr.setNavAreaHeight(goodsCenterNavBarViewAttr.getSearchTop() + 36.0f + 10.0f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void access$tapBackButton(GoodsCenterNavBarView goodsCenterNavBarView) {
        ECSearchBar b16;
        InputView b17;
        ECSearchBar b18;
        InputView b19;
        A attr = goodsCenterNavBarView.getAttr();
        Intrinsics.checkNotNull(attr, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.goods_center.pendant.navBar.GoodsCenterNavBarViewAttr");
        GoodsCenterNavBarViewAttr goodsCenterNavBarViewAttr = (GoodsCenterNavBarViewAttr) attr;
        GoodsCenterNavBarViewModel navViewModel = goodsCenterNavBarViewAttr.navViewModel();
        if (goodsCenterNavBarViewAttr.isSearching()) {
            boolean booleanValue = ((Boolean) navViewModel.isAfterSearch$delegate.getValue(navViewModel, GoodsCenterNavBarViewModel.$$delegatedProperties[1])).booleanValue();
            String searchText = navViewModel.getSearchText();
            if (booleanValue) {
                if (!goodsCenterNavBarView.getPagerData().getIsIOS()) {
                    goodsCenterNavBarView.openNativeSearchPageForAndroid();
                }
                navViewModel.setAfterSearch(false);
            } else {
                navViewModel.setSearchText("");
                aa<ECSearchBar> aaVar = goodsCenterNavBarView.searchBarRef;
                if (aaVar != null && (b18 = aaVar.b()) != null && (b19 = b18.getInputRef().b()) != null) {
                    b19.setText("");
                }
                aa<ECSearchBar> aaVar2 = goodsCenterNavBarView.searchBarRef;
                if (aaVar2 != null && (b16 = aaVar2.b()) != null && (b17 = b16.getInputRef().b()) != null) {
                    b17.h();
                }
                if (searchText.length() > 0) {
                    goodsCenterNavBarView.scrollChangeView(0.0f);
                } else {
                    goodsCenterNavBarView.scrollChangeView(goodsCenterNavBarViewAttr.getSearchMaxTop() - goodsCenterNavBarViewAttr.lastSearchTop);
                }
                goodsCenterNavBarViewAttr.isSearching$delegate.setValue(goodsCenterNavBarViewAttr, GoodsCenterNavBarViewAttr.$$delegatedProperties[4], Boolean.FALSE);
            }
            ((GoodsCenterEvent) goodsCenterNavBarView.getEvent()).onFireEvent("click_back", new GoodsCenterEventDataBackEvent(Boolean.valueOf(booleanValue), searchText));
            return;
        }
        BridgeModule.closePage$default(Utils.INSTANCE.bridgeModule(goodsCenterNavBarView.getPagerId()), null, null, 3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void access$tapSearchBar(GoodsCenterNavBarView goodsCenterNavBarView) {
        if (!goodsCenterNavBarView.getPagerData().getIsIOS()) {
            goodsCenterNavBarView.openNativeSearchPageForAndroid();
        }
        A attr = goodsCenterNavBarView.getAttr();
        Intrinsics.checkNotNull(attr, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.goods_center.pendant.navBar.GoodsCenterNavBarViewAttr");
        GoodsCenterNavBarViewAttr goodsCenterNavBarViewAttr = (GoodsCenterNavBarViewAttr) attr;
        goodsCenterNavBarViewAttr.navViewModel();
        goodsCenterNavBarViewAttr.lastSearchTop = goodsCenterNavBarViewAttr.getSearchTop();
        goodsCenterNavBarView.scrollChangeView(45.0f);
        goodsCenterNavBarViewAttr.isSearching$delegate.setValue(goodsCenterNavBarViewAttr, GoodsCenterNavBarViewAttr.$$delegatedProperties[4], Boolean.TRUE);
        e eVar = new e();
        e m3 = AdelieCategoryHomePage$$ExternalSyntheticOutline0.m("bus_id", GameContentPage$body$1$3$1$3$1$$ExternalSyntheticOutline0.m(BridgeManager.f117344a, c.f117352a, WadlProxyConsts.CHANNEL));
        Iterator<String> c16 = eVar.c();
        while (c16.hasNext()) {
            String next = c16.next();
            m3.v(next, eVar.p(next));
        }
        Utils.INSTANCE.currentBridgeModule().reportDT("xuanpin_search_bar_clk", m3);
        ((GoodsCenterEvent) goodsCenterNavBarView.getEvent()).onFireEvent("tap_search_bar", null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.hippykotlin.demo.pages.goods_center.shell.GoodsCenterPendantView, com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        A attr = getAttr();
        Intrinsics.checkNotNull(attr, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.goods_center.pendant.navBar.GoodsCenterNavBarViewAttr");
        final GoodsCenterNavBarViewAttr goodsCenterNavBarViewAttr = (GoodsCenterNavBarViewAttr) attr;
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.pendant.navBar.GoodsCenterNavBarView$body$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                final GoodsCenterNavBarViewAttr goodsCenterNavBarViewAttr2 = goodsCenterNavBarViewAttr;
                viewContainer.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.pendant.navBar.GoodsCenterNavBarView$body$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        mVar2.mo153width(mVar2.getPagerData().m());
                        GoodsCenterNavBarViewAttr goodsCenterNavBarViewAttr3 = GoodsCenterNavBarViewAttr.this;
                        mVar2.mo141height(((Number) goodsCenterNavBarViewAttr3.navAreaHeight$delegate.getValue(goodsCenterNavBarViewAttr3, GoodsCenterNavBarViewAttr.$$delegatedProperties[0])).floatValue());
                        mVar2.flexDirectionColumn().alignItemsFlexEnd();
                        mVar2.overflow(false);
                        return Unit.INSTANCE;
                    }
                });
                GoodsCenterNavBarView.access$bodyWithNavBar(GoodsCenterNavBarView.this);
                GoodsCenterNavBarView.access$bodyWithSearchView(GoodsCenterNavBarView.this);
                if (goodsCenterNavBarViewAttr.navViewModel().sourceFrom == 1) {
                    GoodsCenterNavBarView.access$setStaticSearchBar(GoodsCenterNavBarView.this);
                }
                return Unit.INSTANCE;
            }
        };
    }

    @Override // com.tencent.hippykotlin.demo.pages.goods_center.shell.GoodsCenterPendantView, com.tencent.kuikly.core.base.AbstractBaseView
    public final GoodsCenterPendantAttr createAttr() {
        return new GoodsCenterNavBarViewAttr();
    }

    @Override // com.tencent.hippykotlin.demo.pages.goods_center.shell.GoodsCenterPendantView, com.tencent.kuikly.core.base.AbstractBaseView
    public final GoodsCenterEvent createEvent() {
        return new GoodsCenterEvent();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.kuikly.core.base.ComposeView
    public final void created() {
        super.created();
        A attr = getAttr();
        Intrinsics.checkNotNull(attr, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.goods_center.pendant.navBar.GoodsCenterNavBarViewAttr");
        final GoodsCenterNavBarViewAttr goodsCenterNavBarViewAttr = (GoodsCenterNavBarViewAttr) attr;
        goodsCenterNavBarViewAttr.setNavAreaHeight(((Number) goodsCenterNavBarViewAttr.navAreaMaxHeight$delegate.getValue()).floatValue());
        goodsCenterNavBarViewAttr.setSearchTop(goodsCenterNavBarViewAttr.getSearchMaxTop());
        ReactiveObserver.INSTANCE.b(Boolean.valueOf(goodsCenterNavBarViewAttr.isSearching()), new Function1<Boolean, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.pendant.navBar.GoodsCenterNavBarViewAttr$created$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Boolean bool) {
                GoodsCenterNavBarViewModel navViewModel;
                bool.booleanValue();
                if (GoodsCenterNavBarViewAttr.this.getViewModel() != null && (navViewModel = GoodsCenterNavBarViewAttr.this.navViewModel()) != null) {
                    navViewModel.isSearching = GoodsCenterNavBarViewAttr.this.isSearching();
                }
                return Unit.INSTANCE;
            }
        });
    }

    @Override // com.tencent.hippykotlin.demo.pages.goods_center.shell.GoodsCenterPendantView
    public final boolean mainViewScrollEnable() {
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.hippykotlin.demo.pages.goods_center.shell.GoodsCenterPendantView, com.tencent.hippykotlin.demo.pages.goods_center.shell.IGoodsCenterPageSubView
    public final void mainViewScrollEnd() {
        A attr = getAttr();
        Intrinsics.checkNotNull(attr, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.goods_center.pendant.navBar.GoodsCenterNavBarViewAttr");
        GoodsCenterNavBarViewAttr goodsCenterNavBarViewAttr = (GoodsCenterNavBarViewAttr) attr;
        goodsCenterNavBarViewAttr.setNavAreaHeight(goodsCenterNavBarViewAttr.getSearchTop() + 36.0f + 10.0f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.hippykotlin.demo.pages.goods_center.shell.GoodsCenterPendantView, com.tencent.hippykotlin.demo.pages.goods_center.shell.IGoodsCenterPageSubView
    public final void mainViewScrollEvent(ScrollParams scrollParams) {
        A attr = getAttr();
        Intrinsics.checkNotNull(attr, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.goods_center.pendant.navBar.GoodsCenterNavBarViewAttr");
        GoodsCenterNavBarViewAttr goodsCenterNavBarViewAttr = (GoodsCenterNavBarViewAttr) attr;
        GoodsCenterNavBarViewModel navViewModel = goodsCenterNavBarViewAttr.navViewModel();
        if (((Boolean) navViewModel.isAfterSearch$delegate.getValue(navViewModel, GoodsCenterNavBarViewModel.$$delegatedProperties[1])).booleanValue() || navViewModel.isSearching || scrollParams.getOffsetY() < 0.0f) {
            return;
        }
        float offsetY = scrollParams.getOffsetY() / 1.0f;
        scrollChangeView(offsetY);
        if (offsetY < 45.0f || ((Number) goodsCenterNavBarViewAttr.navAreaHeight$delegate.getValue(goodsCenterNavBarViewAttr, GoodsCenterNavBarViewAttr.$$delegatedProperties[0])).floatValue() <= getPagerData().getNavigationBarHeight()) {
            return;
        }
        goodsCenterNavBarViewAttr.setNavAreaHeight(getPagerData().getNavigationBarHeight());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void openNativeSearchPageForAndroid() {
        A attr = getAttr();
        Intrinsics.checkNotNull(attr, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.goods_center.pendant.navBar.GoodsCenterNavBarViewAttr");
        GoodsCenterNavBarViewModel navViewModel = ((GoodsCenterNavBarViewAttr) attr).navViewModel();
        navViewModel.setAfterSearch(false);
        BridgeModule.openPage$default(Utils.INSTANCE.currentBridgeModule(), "mqqapi://ecommerce/open?target=57&channel=2&arg_query_string=" + navViewModel.getSearchText() + "&is_ktv_product_center=1", false, new e(), new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.pendant.navBar.GoodsCenterNavBarView$openNativeSearchPageForAndroid$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(e eVar) {
                ECSearchBar b16;
                e eVar2 = eVar;
                try {
                    e eVar3 = new e(String.valueOf(eVar2));
                    boolean g16 = eVar3.g("is_clk_back", false);
                    boolean g17 = eVar3.g("is_perform_search", false);
                    String q16 = eVar3.q("query_txt", "");
                    if (g16) {
                        GoodsCenterNavBarView.access$tapBackButton(GoodsCenterNavBarView.this);
                    } else if (g17) {
                        aa<ECSearchBar> aaVar = GoodsCenterNavBarView.this.searchBarRef;
                        if (aaVar != null && (b16 = aaVar.b()) != null) {
                            b16.setState(ECSearchState.ECSearchInputBarAfterSearch);
                            InputView b17 = b16.getInputRef().b();
                            if (b17 != null) {
                                b17.h();
                            }
                        }
                        GoodsCenterNavBarView.access$didSearchText(GoodsCenterNavBarView.this, q16);
                    }
                    KLog.INSTANCE.i("GoodsCenterNavBarView", "GoodsCenterNavBarView [openNativeSearchPageForAndroid] callback data= " + eVar2);
                } catch (Exception e16) {
                    KLog.INSTANCE.i("GoodsCenterNavBarView", "GoodsCenterNavBarView [openNativeSearchPageForAndroid] exception = " + e16);
                }
                return Unit.INSTANCE;
            }
        }, 8);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void scrollChangeView(float f16) {
        A attr = getAttr();
        Intrinsics.checkNotNull(attr, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.goods_center.pendant.navBar.GoodsCenterNavBarViewAttr");
        GoodsCenterNavBarViewAttr goodsCenterNavBarViewAttr = (GoodsCenterNavBarViewAttr) attr;
        if (goodsCenterNavBarViewAttr.navViewModel().sourceFrom != 1) {
            goodsCenterNavBarViewAttr.searchLeftSpace$delegate.setValue(goodsCenterNavBarViewAttr, GoodsCenterNavBarViewAttr.$$delegatedProperties[2], Float.valueOf(Math.min(f16, 20.0f) + 16.0f));
            goodsCenterNavBarViewAttr.setSearchTop(goodsCenterNavBarViewAttr.getSearchMaxTop() - Math.min(f16, 45.0f));
        }
        A attr2 = getAttr();
        Intrinsics.checkNotNull(attr2, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.goods_center.pendant.navBar.GoodsCenterNavBarViewAttr");
        GoodsCenterNavBarViewAttr goodsCenterNavBarViewAttr2 = (GoodsCenterNavBarViewAttr) attr2;
        goodsCenterNavBarViewAttr2.navTitleOpacity$delegate.setValue(goodsCenterNavBarViewAttr2, GoodsCenterNavBarViewAttr.$$delegatedProperties[3], Float.valueOf(1.0f - Math.min(f16 / 27.000002f, 1.0f)));
    }

    @Override // com.tencent.hippykotlin.demo.pages.goods_center.shell.GoodsCenterPendantView, com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return new GoodsCenterNavBarViewAttr();
    }

    @Override // com.tencent.hippykotlin.demo.pages.goods_center.shell.GoodsCenterPendantView, com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new GoodsCenterEvent();
    }
}
