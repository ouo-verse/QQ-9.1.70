package com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.feed_list;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.foundation.lib.QQContext;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view_model.FetchStatus;
import com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view_model.NBPHomePageBaseViewModel;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.aa;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.attr.c;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.event.FrameEventKt;
import com.tencent.kuikly.core.base.event.VisibilityEventKt;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
import com.tencent.kuikly.core.directives.LoopDirectivesView;
import com.tencent.kuikly.core.directives.LoopDirectivesViewKt;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.PageListEvent;
import com.tencent.kuikly.core.views.PageListView;
import com.tencent.kuikly.core.views.ScrollParams;
import com.tencent.kuikly.core.views.TabsView;
import com.tencent.kuikly.core.views.TabsViewKt;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ah;
import com.tencent.kuikly.core.views.be;
import com.tencent.kuikly.core.views.bf;
import com.tencent.kuikly.core.views.bw;
import com.tencent.kuikly.core.views.bx;
import com.tencent.kuikly.core.views.bz;
import com.tencent.kuikly.core.views.ca;
import com.tencent.kuikly.core.views.cb;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import org.aspectj.lang.JoinPoint;
import p35.n;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class HomepageFeedsView extends ComposeView<FeedListViewAttr, FeedListViewEvent> {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(HomepageFeedsView.class, "listViewHeight", "getListViewHeight()F", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(HomepageFeedsView.class, "tabsViewWidth", "getTabsViewWidth()F", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(HomepageFeedsView.class, "itemWidth", "getItemWidth()F", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(HomepageFeedsView.class, "currentTabIndex", "getCurrentTabIndex()I", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(HomepageFeedsView.class, "pageIndex", "getPageIndex()I", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(HomepageFeedsView.class, "tabDataList", "getTabDataList()Lcom/tencent/kuikly/core/reactive/collection/ObservableList;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(HomepageFeedsView.class, "scrollParams", "getScrollParams()Lcom/tencent/kuikly/core/views/ScrollParams;", 0)};
    public final ReadWriteProperty currentTabIndex$delegate;
    public boolean isFirstDisplay;
    public float lastLikedFeedListHeight;
    public float lastSelfFeedHeight;
    public final ReadWriteProperty listViewHeight$delegate = c.a(Float.valueOf(550.0f));
    public final float minFeedViewHeight;
    public aa<PageListView<?, ?>> pageListRef;
    public final ReadWriteProperty scrollParams$delegate;
    public final ReadWriteProperty tabDataList$delegate;
    public final ReadWriteProperty tabsViewWidth$delegate;

    public HomepageFeedsView() {
        QQContext qQContext = QQContext.INSTANCE;
        this.tabsViewWidth$delegate = c.a(Float.valueOf(qQContext.getPageData().m() - 100.0f));
        c.a(Float.valueOf(124.0f));
        this.currentTabIndex$delegate = c.a(0);
        c.a(0);
        this.tabDataList$delegate = c.b();
        this.scrollParams$delegate = c.a(null);
        this.isFirstDisplay = true;
        float l3 = qQContext.getPageData().l() - 250;
        this.minFeedViewHeight = l3;
        this.lastSelfFeedHeight = l3;
        this.lastLikedFeedListHeight = l3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ FeedListViewAttr access$getAttr(HomepageFeedsView homepageFeedsView) {
        return (FeedListViewAttr) homepageFeedsView.getAttr();
    }

    public static final com.tencent.kuikly.core.reactive.collection.c access$getTabDataList(HomepageFeedsView homepageFeedsView) {
        return (com.tencent.kuikly.core.reactive.collection.c) homepageFeedsView.tabDataList$delegate.getValue(homepageFeedsView, $$delegatedProperties[5]);
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        bindValueChange(new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.feed_list.HomepageFeedsView$body$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Integer.valueOf(HomepageFeedsView.this.getCurrentTabIndex());
            }
        }, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.feed_list.HomepageFeedsView$body$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Object obj) {
                HomepageFeedsView homepageFeedsView = HomepageFeedsView.this;
                HomepageFeedsView.handleListHeight$default(homepageFeedsView, null, null, Integer.valueOf(homepageFeedsView.getCurrentTabIndex()), 3);
                return Unit.INSTANCE;
            }
        });
        setListViewHeight(getPagerData().l() * 0.73f);
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.feed_list.HomepageFeedsView$body$3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.feed_list.HomepageFeedsView$body$3.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        mVar2.mo113backgroundColor(QUIToken.color$default("bg_bottom_light"));
                        mVar2.mo153width(mVar2.getPagerData().m());
                        return Unit.INSTANCE;
                    }
                });
                final HomepageFeedsView homepageFeedsView = HomepageFeedsView.this;
                ConditionViewKt.c(viewContainer2, new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.feed_list.HomepageFeedsView$body$3.2
                    {
                        super(0);
                    }

                    /* JADX WARN: Code restructure failed: missing block: B:12:0x0028, code lost:
                    
                        if (((r0 == null || r0.isSelf) ? false : true) == false) goto L16;
                     */
                    /* JADX WARN: Code restructure failed: missing block: B:13:0x003f, code lost:
                    
                        r1 = true;
                     */
                    /* JADX WARN: Code restructure failed: missing block: B:15:0x0044, code lost:
                    
                        return java.lang.Boolean.valueOf(r1);
                     */
                    /* JADX WARN: Code restructure failed: missing block: B:23:0x003d, code lost:
                    
                        if ((r0 != null && r0.getAppId() == 1) != false) goto L23;
                     */
                    @Override // kotlin.jvm.functions.Function0
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public final Object invoke() {
                        NBPHomePageBaseViewModel nBPHomePageBaseViewModel = HomepageFeedsView.access$getAttr(HomepageFeedsView.this).viewModel;
                        boolean z16 = false;
                        if (nBPHomePageBaseViewModel != null && nBPHomePageBaseViewModel.getLikesOnlySelf()) {
                            NBPHomePageBaseViewModel nBPHomePageBaseViewModel2 = HomepageFeedsView.access$getAttr(HomepageFeedsView.this).viewModel;
                        }
                        NBPHomePageBaseViewModel nBPHomePageBaseViewModel3 = HomepageFeedsView.access$getAttr(HomepageFeedsView.this).viewModel;
                    }
                }, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.feed_list.HomepageFeedsView$body$3.3
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ConditionView conditionView) {
                        w.a(conditionView, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.feed_list.HomepageFeedsView.body.3.3.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar) {
                                v vVar2 = vVar;
                                vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.feed_list.HomepageFeedsView.body.3.3.1.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.flexDirectionRow();
                                        tVar2.alignItemsCenter();
                                        tVar2.mo141height(48.0f);
                                        return Unit.INSTANCE;
                                    }
                                });
                                cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.feed_list.HomepageFeedsView.body.3.3.1.2
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(TextView textView) {
                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.feed_list.HomepageFeedsView.body.3.3.1.2.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ce ceVar) {
                                                ce ceVar2 = ceVar;
                                                ceVar2.marginLeft(16.0f);
                                                ceVar2.fontWeight400();
                                                ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                                ceVar2.color(QUIToken.color$default("text_primary"));
                                                ceVar2.text("\u52a8\u6001");
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
                final HomepageFeedsView homepageFeedsView2 = HomepageFeedsView.this;
                ConditionViewKt.a(viewContainer2, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.feed_list.HomepageFeedsView$body$3.4
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ConditionView conditionView) {
                        HomepageFeedsView.access$getTabDataList(HomepageFeedsView.this).add("\u52a8\u6001");
                        HomepageFeedsView.access$getTabDataList(HomepageFeedsView.this).add("\u8d5e\u8fc7");
                        final HomepageFeedsView homepageFeedsView3 = HomepageFeedsView.this;
                        TabsViewKt.b(conditionView, new Function1<TabsView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.feed_list.HomepageFeedsView.body.3.4.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(TabsView tabsView) {
                                TabsView tabsView2 = tabsView;
                                final HomepageFeedsView homepageFeedsView4 = HomepageFeedsView.this;
                                tabsView2.attr(new Function1<ca, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.feed_list.HomepageFeedsView.body.3.4.1.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ca caVar) {
                                        ca caVar2 = caVar;
                                        caVar2.flexDirectionRow();
                                        caVar2.m140flex(1.0f);
                                        c.a.a(caVar2, 0.0f, 50.0f, 0.0f, 50.0f, 5, null);
                                        caVar2.mo141height(48.0f);
                                        HomepageFeedsView homepageFeedsView5 = HomepageFeedsView.this;
                                        KProperty<Object>[] kPropertyArr = HomepageFeedsView.$$delegatedProperties;
                                        homepageFeedsView5.getClass();
                                        caVar2.h(0);
                                        caVar2.justifyContentSpaceAround();
                                        caVar2.allCenter();
                                        caVar2.m(new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.feed_list.HomepageFeedsView.body.3.4.1.1.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ViewContainer<?, ?> viewContainer3) {
                                                w.a(viewContainer3, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.feed_list.HomepageFeedsView.body.3.4.1.1.1.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(v vVar) {
                                                        vVar.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.feed_list.HomepageFeedsView.body.3.4.1.1.1.1.1
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(t tVar) {
                                                                t tVar2 = tVar;
                                                                tVar2.alignSelfCenter();
                                                                tVar2.marginTop(35.0f);
                                                                tVar2.mo153width(40.0f);
                                                                tVar2.mo141height(2.0f);
                                                                tVar2.borderRadius(3.0f);
                                                                tVar2.mo113backgroundColor(QUIToken.color$default("brand_standard"));
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        HomepageFeedsView homepageFeedsView6 = HomepageFeedsView.this;
                                        ScrollParams scrollParams = (ScrollParams) homepageFeedsView6.scrollParams$delegate.getValue(homepageFeedsView6, HomepageFeedsView.$$delegatedProperties[6]);
                                        if (scrollParams != null) {
                                            caVar2.n(scrollParams);
                                        }
                                        return Unit.INSTANCE;
                                    }
                                });
                                final HomepageFeedsView homepageFeedsView5 = HomepageFeedsView.this;
                                tabsView2.event(new Function1<cb, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.feed_list.HomepageFeedsView.body.3.4.1.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(cb cbVar) {
                                        final HomepageFeedsView homepageFeedsView6 = HomepageFeedsView.this;
                                        FrameEventKt.e(cbVar, new Function1<com.tencent.kuikly.core.base.w, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.feed_list.HomepageFeedsView.body.3.4.1.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(com.tencent.kuikly.core.base.w wVar) {
                                                HomepageFeedsView homepageFeedsView7 = HomepageFeedsView.this;
                                                homepageFeedsView7.tabsViewWidth$delegate.setValue(homepageFeedsView7, HomepageFeedsView.$$delegatedProperties[1], Float.valueOf(wVar.getWidth()));
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final HomepageFeedsView homepageFeedsView6 = HomepageFeedsView.this;
                                Function0<com.tencent.kuikly.core.reactive.collection.c<String>> function0 = new Function0<com.tencent.kuikly.core.reactive.collection.c<String>>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.feed_list.HomepageFeedsView.body.3.4.1.3
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public final com.tencent.kuikly.core.reactive.collection.c<String> invoke() {
                                        return HomepageFeedsView.access$getTabDataList(HomepageFeedsView.this);
                                    }
                                };
                                final HomepageFeedsView homepageFeedsView7 = HomepageFeedsView.this;
                                LoopDirectivesViewKt.a(tabsView2, function0, new Function2<LoopDirectivesView<String>, String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.feed_list.HomepageFeedsView.body.3.4.1.4
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public final Unit invoke(LoopDirectivesView<String> loopDirectivesView, String str) {
                                        final String str2 = str;
                                        final HomepageFeedsView homepageFeedsView8 = HomepageFeedsView.this;
                                        TabsViewKt.a(loopDirectivesView, new Function2<bz, bz.a, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.feed_list.HomepageFeedsView.body.3.4.1.4.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(2);
                                            }

                                            @Override // kotlin.jvm.functions.Function2
                                            public final Unit invoke(bz bzVar, bz.a aVar) {
                                                bz bzVar2 = bzVar;
                                                final bz.a aVar2 = aVar;
                                                final HomepageFeedsView homepageFeedsView9 = HomepageFeedsView.this;
                                                bzVar2.attr(new Function1<bw, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.feed_list.HomepageFeedsView.body.3.4.1.4.1.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(bw bwVar) {
                                                        bw bwVar2 = bwVar;
                                                        bwVar2.flexDirectionRow();
                                                        HomepageFeedsView homepageFeedsView10 = HomepageFeedsView.this;
                                                        bwVar2.mo153width(((Number) homepageFeedsView10.tabsViewWidth$delegate.getValue(homepageFeedsView10, HomepageFeedsView.$$delegatedProperties[1])).floatValue() / HomepageFeedsView.access$getTabDataList(HomepageFeedsView.this).size());
                                                        bwVar2.mo141height(48.0f);
                                                        bwVar2.alignSelfCenter();
                                                        bwVar2.allCenter();
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final HomepageFeedsView homepageFeedsView10 = HomepageFeedsView.this;
                                                final String str3 = str2;
                                                bzVar2.event(new Function1<bx, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.feed_list.HomepageFeedsView.body.3.4.1.4.1.2
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(bx bxVar) {
                                                        final HomepageFeedsView homepageFeedsView11 = HomepageFeedsView.this;
                                                        final String str4 = str3;
                                                        bxVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.feed_list.HomepageFeedsView.body.3.4.1.4.1.2.1
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ClickParams clickParams) {
                                                                PageListView<?, ?> b16;
                                                                aa<PageListView<?, ?>> aaVar = HomepageFeedsView.this.pageListRef;
                                                                if (aaVar != null && (b16 = aaVar.b()) != null) {
                                                                    b16.scrollToPageIndex(HomepageFeedsView.access$getTabDataList(HomepageFeedsView.this).indexOf(str4), true);
                                                                }
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final String str4 = str2;
                                                cg.a(bzVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.feed_list.HomepageFeedsView.body.3.4.1.4.1.3
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(TextView textView) {
                                                        final String str5 = str4;
                                                        final bz.a aVar3 = aVar2;
                                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.feed_list.HomepageFeedsView.body.3.4.1.4.1.3.1
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ce ceVar) {
                                                                ce ceVar2 = ceVar;
                                                                ceVar2.text(str5);
                                                                ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                                                ceVar2.fontWeight400();
                                                                if (aVar3.a()) {
                                                                    ceVar2.color(QUIToken.color$default("brand_standard"));
                                                                } else {
                                                                    ceVar2.color(QUIToken.color$default("text_primary"));
                                                                }
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final HomepageFeedsView homepageFeedsView11 = HomepageFeedsView.this;
                                                final String str5 = str2;
                                                ConditionViewKt.c(bzVar2, new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.feed_list.HomepageFeedsView.body.3.4.1.4.1.4
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(0);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function0
                                                    public final Object invoke() {
                                                        NBPHomePageBaseViewModel nBPHomePageBaseViewModel = HomepageFeedsView.access$getAttr(HomepageFeedsView.this).viewModel;
                                                        boolean z16 = false;
                                                        if ((nBPHomePageBaseViewModel != null && nBPHomePageBaseViewModel.getLikesOnlySelf()) && HomepageFeedsView.access$getTabDataList(HomepageFeedsView.this).indexOf(str5) == 1) {
                                                            z16 = true;
                                                        }
                                                        return Boolean.valueOf(z16);
                                                    }
                                                }, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.feed_list.HomepageFeedsView.body.3.4.1.4.1.5
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ConditionView conditionView2) {
                                                        final bz.a aVar3 = bz.a.this;
                                                        ah.a(conditionView2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.feed_list.HomepageFeedsView.body.3.4.1.4.1.5.1
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ImageView imageView) {
                                                                final bz.a aVar4 = bz.a.this;
                                                                imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.feed_list.HomepageFeedsView.body.3.4.1.4.1.5.1.1
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(af afVar) {
                                                                        h color$default;
                                                                        af afVar2 = afVar;
                                                                        afVar2.mo153width(14.0f);
                                                                        afVar2.mo141height(14.0f);
                                                                        QUIToken qUIToken = QUIToken.INSTANCE;
                                                                        if (bz.a.this.a()) {
                                                                            color$default = QUIToken.color$default("brand_standard");
                                                                        } else {
                                                                            color$default = QUIToken.color$default("text_primary");
                                                                        }
                                                                        b.a.b(afVar2, qUIToken.image(JoinPoint.SYNCHRONIZATION_LOCK, color$default), false, 2, null);
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
                final HomepageFeedsView homepageFeedsView3 = HomepageFeedsView.this;
                bf.a(viewContainer2, new Function1<PageListView<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.feed_list.HomepageFeedsView$body$3.5
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(PageListView<?, ?> pageListView) {
                        PageListView<?, ?> pageListView2 = pageListView;
                        final HomepageFeedsView homepageFeedsView4 = HomepageFeedsView.this;
                        pageListView2.ref(pageListView2, new Function1<aa<PageListView<?, ?>>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.feed_list.HomepageFeedsView.body.3.5.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(aa<PageListView<?, ?>> aaVar) {
                                HomepageFeedsView.this.pageListRef = aaVar;
                                return Unit.INSTANCE;
                            }
                        });
                        final HomepageFeedsView homepageFeedsView5 = HomepageFeedsView.this;
                        pageListView2.attr(new Function1<be, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.feed_list.HomepageFeedsView.body.3.5.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(be beVar) {
                                be beVar2 = beVar;
                                beVar2.flexDirectionRow();
                                beVar2.pageItemWidth(beVar2.getPagerData().m());
                                HomepageFeedsView homepageFeedsView6 = HomepageFeedsView.this;
                                beVar2.pageItemHeight(((Number) homepageFeedsView6.listViewHeight$delegate.getValue(homepageFeedsView6, HomepageFeedsView.$$delegatedProperties[0])).floatValue());
                                HomepageFeedsView.this.getClass();
                                beVar2.defaultPageIndex(0);
                                return Unit.INSTANCE;
                            }
                        });
                        final HomepageFeedsView homepageFeedsView6 = HomepageFeedsView.this;
                        pageListView2.event(new Function1<PageListEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.feed_list.HomepageFeedsView.body.3.5.3
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(PageListEvent pageListEvent) {
                                final HomepageFeedsView homepageFeedsView7 = HomepageFeedsView.this;
                                pageListEvent.scroll(new Function1<ScrollParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.feed_list.HomepageFeedsView.body.3.5.3.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ScrollParams scrollParams) {
                                        HomepageFeedsView homepageFeedsView8 = HomepageFeedsView.this;
                                        homepageFeedsView8.scrollParams$delegate.setValue(homepageFeedsView8, HomepageFeedsView.$$delegatedProperties[6], scrollParams);
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final HomepageFeedsView homepageFeedsView7 = HomepageFeedsView.this;
                        pageListView2.addChild(new FeedWaterFallListView(), new Function1<FeedWaterFallListView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.feed_list.HomepageFeedsView.body.3.5.4
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(FeedWaterFallListView feedWaterFallListView) {
                                FeedWaterFallListView feedWaterFallListView2 = feedWaterFallListView;
                                final HomepageFeedsView homepageFeedsView8 = HomepageFeedsView.this;
                                feedWaterFallListView2.attr(new Function1<FeedWaterFallListAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.feed_list.HomepageFeedsView.body.3.5.4.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(FeedWaterFallListAttr feedWaterFallListAttr) {
                                        FeedWaterFallListAttr feedWaterFallListAttr2 = feedWaterFallListAttr;
                                        feedWaterFallListAttr2.isUserLikedPage = false;
                                        NBPHomePageBaseViewModel nBPHomePageBaseViewModel = HomepageFeedsView.access$getAttr(HomepageFeedsView.this).viewModel;
                                        com.tencent.kuikly.core.reactive.collection.c<n> feedList = nBPHomePageBaseViewModel != null ? nBPHomePageBaseViewModel.getFeedList() : null;
                                        Intrinsics.checkNotNull(feedList);
                                        ReadWriteProperty readWriteProperty = feedWaterFallListAttr2.feedList$delegate;
                                        KProperty<?>[] kPropertyArr = FeedWaterFallListAttr.$$delegatedProperties;
                                        readWriteProperty.setValue(feedWaterFallListAttr2, kPropertyArr[0], feedList);
                                        NBPHomePageBaseViewModel nBPHomePageBaseViewModel2 = HomepageFeedsView.access$getAttr(HomepageFeedsView.this).viewModel;
                                        FetchStatus feedState = nBPHomePageBaseViewModel2 != null ? nBPHomePageBaseViewModel2.getFeedState() : null;
                                        Intrinsics.checkNotNull(feedState);
                                        feedWaterFallListAttr2.fetchStatus$delegate.setValue(feedWaterFallListAttr2, kPropertyArr[1], feedState);
                                        feedWaterFallListAttr2.viewModel = HomepageFeedsView.access$getAttr(HomepageFeedsView.this).viewModel;
                                        return Unit.INSTANCE;
                                    }
                                });
                                final HomepageFeedsView homepageFeedsView9 = HomepageFeedsView.this;
                                feedWaterFallListView2.event(new Function1<FeedWaterFallListEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.feed_list.HomepageFeedsView.body.3.5.4.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(FeedWaterFallListEvent feedWaterFallListEvent) {
                                        FeedWaterFallListEvent feedWaterFallListEvent2 = feedWaterFallListEvent;
                                        final HomepageFeedsView homepageFeedsView10 = HomepageFeedsView.this;
                                        feedWaterFallListEvent2.register("changePageHeight", new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.feed_list.HomepageFeedsView.body.3.5.4.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(Object obj) {
                                                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.tencent.kuikly.core.nvi.serialization.json.JSONObject");
                                                HomepageFeedsView.handleListHeight$default(HomepageFeedsView.this, Float.valueOf((float) ((e) obj).h("height")), null, null, 4);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final HomepageFeedsView homepageFeedsView11 = HomepageFeedsView.this;
                                        VisibilityEventKt.b(feedWaterFallListEvent2, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.feed_list.HomepageFeedsView.body.3.5.4.2.2
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(Object obj) {
                                                NBPHomePageBaseViewModel nBPHomePageBaseViewModel = HomepageFeedsView.access$getAttr(HomepageFeedsView.this).viewModel;
                                                if (nBPHomePageBaseViewModel != null) {
                                                    nBPHomePageBaseViewModel.isCurrentLikedPage = false;
                                                }
                                                HomepageFeedsView homepageFeedsView12 = HomepageFeedsView.this;
                                                homepageFeedsView12.currentTabIndex$delegate.setValue(homepageFeedsView12, HomepageFeedsView.$$delegatedProperties[3], 0);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final HomepageFeedsView homepageFeedsView8 = HomepageFeedsView.this;
                        Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.feed_list.HomepageFeedsView.body.3.5.5
                            {
                                super(0);
                            }

                            /* JADX WARN: Code restructure failed: missing block: B:13:0x002b, code lost:
                            
                                if ((r0 != null && r0.getAppId() == 2) == false) goto L17;
                             */
                            /* JADX WARN: Code restructure failed: missing block: B:14:0x0055, code lost:
                            
                                r1 = true;
                             */
                            /* JADX WARN: Code restructure failed: missing block: B:30:0x0053, code lost:
                            
                                if ((r0 != null && r0.getAppId() == 2) != false) goto L31;
                             */
                            @Override // kotlin.jvm.functions.Function0
                            /*
                                Code decompiled incorrectly, please refer to instructions dump.
                            */
                            public final Object invoke() {
                                NBPHomePageBaseViewModel nBPHomePageBaseViewModel = HomepageFeedsView.access$getAttr(HomepageFeedsView.this).viewModel;
                                boolean z16 = false;
                                if ((nBPHomePageBaseViewModel == null || nBPHomePageBaseViewModel.getLikesOnlySelf()) ? false : true) {
                                    NBPHomePageBaseViewModel nBPHomePageBaseViewModel2 = HomepageFeedsView.access$getAttr(HomepageFeedsView.this).viewModel;
                                }
                                NBPHomePageBaseViewModel nBPHomePageBaseViewModel3 = HomepageFeedsView.access$getAttr(HomepageFeedsView.this).viewModel;
                                if (nBPHomePageBaseViewModel3 != null && nBPHomePageBaseViewModel3.isSelf) {
                                    NBPHomePageBaseViewModel nBPHomePageBaseViewModel4 = HomepageFeedsView.access$getAttr(HomepageFeedsView.this).viewModel;
                                }
                                return Boolean.valueOf(z16);
                            }
                        };
                        final HomepageFeedsView homepageFeedsView9 = HomepageFeedsView.this;
                        ConditionViewKt.c(pageListView2, function0, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.feed_list.HomepageFeedsView.body.3.5.6
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ConditionView conditionView) {
                                final HomepageFeedsView homepageFeedsView10 = HomepageFeedsView.this;
                                conditionView.addChild(new FeedWaterFallListView(), new Function1<FeedWaterFallListView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.feed_list.HomepageFeedsView.body.3.5.6.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(FeedWaterFallListView feedWaterFallListView) {
                                        FeedWaterFallListView feedWaterFallListView2 = feedWaterFallListView;
                                        final HomepageFeedsView homepageFeedsView11 = HomepageFeedsView.this;
                                        feedWaterFallListView2.attr(new Function1<FeedWaterFallListAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.feed_list.HomepageFeedsView.body.3.5.6.1.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(FeedWaterFallListAttr feedWaterFallListAttr) {
                                                FeedWaterFallListAttr feedWaterFallListAttr2 = feedWaterFallListAttr;
                                                feedWaterFallListAttr2.isUserLikedPage = true;
                                                NBPHomePageBaseViewModel nBPHomePageBaseViewModel = HomepageFeedsView.access$getAttr(HomepageFeedsView.this).viewModel;
                                                com.tencent.kuikly.core.reactive.collection.c<n> likedFeedList = nBPHomePageBaseViewModel != null ? nBPHomePageBaseViewModel.getLikedFeedList() : null;
                                                Intrinsics.checkNotNull(likedFeedList);
                                                ReadWriteProperty readWriteProperty = feedWaterFallListAttr2.feedList$delegate;
                                                KProperty<?>[] kPropertyArr = FeedWaterFallListAttr.$$delegatedProperties;
                                                readWriteProperty.setValue(feedWaterFallListAttr2, kPropertyArr[0], likedFeedList);
                                                NBPHomePageBaseViewModel nBPHomePageBaseViewModel2 = HomepageFeedsView.access$getAttr(HomepageFeedsView.this).viewModel;
                                                FetchStatus fetchStatus = nBPHomePageBaseViewModel2 != null ? (FetchStatus) nBPHomePageBaseViewModel2.likedFeedState$delegate.getValue(nBPHomePageBaseViewModel2, NBPHomePageBaseViewModel.$$delegatedProperties[13]) : null;
                                                Intrinsics.checkNotNull(fetchStatus);
                                                feedWaterFallListAttr2.fetchStatus$delegate.setValue(feedWaterFallListAttr2, kPropertyArr[1], fetchStatus);
                                                feedWaterFallListAttr2.viewModel = HomepageFeedsView.access$getAttr(HomepageFeedsView.this).viewModel;
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final HomepageFeedsView homepageFeedsView12 = HomepageFeedsView.this;
                                        feedWaterFallListView2.event(new Function1<FeedWaterFallListEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.feed_list.HomepageFeedsView.body.3.5.6.1.2
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(FeedWaterFallListEvent feedWaterFallListEvent) {
                                                FeedWaterFallListEvent feedWaterFallListEvent2 = feedWaterFallListEvent;
                                                final HomepageFeedsView homepageFeedsView13 = HomepageFeedsView.this;
                                                feedWaterFallListEvent2.register("changePageHeight", new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.feed_list.HomepageFeedsView.body.3.5.6.1.2.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(Object obj) {
                                                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.tencent.kuikly.core.nvi.serialization.json.JSONObject");
                                                        HomepageFeedsView.handleListHeight$default(HomepageFeedsView.this, null, Float.valueOf((float) ((e) obj).h("height")), null, 4);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final HomepageFeedsView homepageFeedsView14 = HomepageFeedsView.this;
                                                VisibilityEventKt.b(feedWaterFallListEvent2, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.feed_list.HomepageFeedsView.body.3.5.6.1.2.2
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(Object obj) {
                                                        HomepageFeedsView homepageFeedsView15 = HomepageFeedsView.this;
                                                        if (homepageFeedsView15.isFirstDisplay) {
                                                            homepageFeedsView15.isFirstDisplay = false;
                                                            NBPHomePageBaseViewModel nBPHomePageBaseViewModel = HomepageFeedsView.access$getAttr(homepageFeedsView15).viewModel;
                                                            if (nBPHomePageBaseViewModel != null) {
                                                                nBPHomePageBaseViewModel.fetchUserLikedList();
                                                            }
                                                        }
                                                        NBPHomePageBaseViewModel nBPHomePageBaseViewModel2 = HomepageFeedsView.access$getAttr(HomepageFeedsView.this).viewModel;
                                                        if (nBPHomePageBaseViewModel2 != null) {
                                                            nBPHomePageBaseViewModel2.isCurrentLikedPage = true;
                                                        }
                                                        HomepageFeedsView homepageFeedsView16 = HomepageFeedsView.this;
                                                        homepageFeedsView16.currentTabIndex$delegate.setValue(homepageFeedsView16, HomepageFeedsView.$$delegatedProperties[3], 1);
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
        return new FeedListViewAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new FeedListViewEvent();
    }

    public final int getCurrentTabIndex() {
        return ((Number) this.currentTabIndex$delegate.getValue(this, $$delegatedProperties[3])).intValue();
    }

    public final void setListViewHeight(float f16) {
        this.listViewHeight$delegate.setValue(this, $$delegatedProperties[0], Float.valueOf(f16));
    }

    public static void handleListHeight$default(HomepageFeedsView homepageFeedsView, Float f16, Float f17, Integer num, int i3) {
        if ((i3 & 1) != 0) {
            f16 = null;
        }
        if ((i3 & 2) != 0) {
            f17 = null;
        }
        if ((i3 & 4) != 0) {
            num = null;
        }
        homepageFeedsView.getClass();
        if (f16 != null && f17 == null && homepageFeedsView.getCurrentTabIndex() == 0) {
            homepageFeedsView.lastSelfFeedHeight = f16.floatValue();
            if (f16.floatValue() > homepageFeedsView.minFeedViewHeight) {
                homepageFeedsView.setListViewHeight(f16.floatValue());
                return;
            }
        }
        if (f16 == null && f17 != null && homepageFeedsView.getCurrentTabIndex() == 1) {
            homepageFeedsView.lastLikedFeedListHeight = f17.floatValue();
            if (f17.floatValue() > homepageFeedsView.minFeedViewHeight) {
                homepageFeedsView.setListViewHeight(f17.floatValue());
                return;
            }
        }
        if (num != null && num.intValue() == 0) {
            homepageFeedsView.setListViewHeight(homepageFeedsView.lastSelfFeedHeight);
        } else if (num != null && num.intValue() == 1) {
            homepageFeedsView.setListViewHeight(homepageFeedsView.lastLikedFeedListHeight);
        }
    }
}
