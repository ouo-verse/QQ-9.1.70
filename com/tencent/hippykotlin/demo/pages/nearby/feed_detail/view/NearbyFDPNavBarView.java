package com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.hippykotlin.demo.pages.nearby.base.utils.NearbyProUtilsKt;
import com.tencent.hippykotlin.demo.pages.nearby.feed_detail.INearbyFeedDetailDTReporter;
import com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPJumpUtil;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.Direction;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.attr.c;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.event.FrameEventKt;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.j;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
import com.tencent.kuikly.core.directives.LoopDirectivesView;
import com.tencent.kuikly.core.directives.LoopDirectivesViewKt;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.ScrollParams;
import com.tencent.kuikly.core.views.TabsView;
import com.tencent.kuikly.core.views.TabsViewKt;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ah;
import com.tencent.kuikly.core.views.bw;
import com.tencent.kuikly.core.views.bx;
import com.tencent.kuikly.core.views.bz;
import com.tencent.kuikly.core.views.ca;
import com.tencent.kuikly.core.views.cb;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.u;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import o25.f;
import v25.i;

/* loaded from: classes31.dex */
public final class NearbyFDPNavBarView extends ComposeView<NearbyFDPNavBarAttr, NearbyFDPNavBarEvent> {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NearbyFDPNavBarView.class, "curIndex", "getCurIndex()I", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NearbyFDPNavBarView.class, "tabDataList", "getTabDataList()Lcom/tencent/kuikly/core/reactive/collection/ObservableList;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NearbyFDPNavBarView.class, "tabsViewWidth", "getTabsViewWidth()F", 0)};
    public final ReadWriteProperty curIndex$delegate = c.a(0);
    public final ReadWriteProperty tabDataList$delegate = c.b();
    public final ReadWriteProperty tabsViewWidth$delegate = c.a(Float.valueOf(200.0f));
    public final i rspCache = NearbyProUtilsKt.getCachedMapThemeList();
    public f currentTheme = new f(null, null, null, null, null, null, null, null, null, null, false, false, 0, 0, false, null, null, 0, 262143, null);

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ NearbyFDPNavBarAttr access$getAttr(NearbyFDPNavBarView nearbyFDPNavBarView) {
        return (NearbyFDPNavBarAttr) nearbyFDPNavBarView.getAttr();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ NearbyFDPNavBarEvent access$getEvent(NearbyFDPNavBarView nearbyFDPNavBarView) {
        return (NearbyFDPNavBarEvent) nearbyFDPNavBarView.getEvent();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return new NearbyFDPNavBarAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new NearbyFDPNavBarEvent();
    }

    public final com.tencent.kuikly.core.reactive.collection.c<String> getTabDataList() {
        return (com.tencent.kuikly.core.reactive.collection.c) this.tabDataList$delegate.getValue(this, $$delegatedProperties[1]);
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0045, code lost:
    
        if (r2 == null) goto L15;
     */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.kuikly.core.base.ComposeView
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        f fVar;
        List<f> list;
        Object obj;
        getTabDataList().add("\u63a8\u8350");
        getTabDataList().add("\u5173\u6ce8");
        i iVar = this.rspCache;
        if (iVar != null && (list = iVar.f440858e) != null) {
            Iterator<T> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (Intrinsics.areEqual(((f) obj).f421849d, ((NearbyFDPNavBarAttr) getAttr()).getThemeId())) {
                    break;
                }
            }
            fVar = (f) obj;
        }
        fVar = new f(null, null, null, null, null, null, null, null, null, null, false, false, 0, 0, false, null, null, 0, 262143, null);
        this.currentTheme = fVar;
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.NearbyFDPNavBarView$body$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.NearbyFDPNavBarView$body$2.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        mVar2.paddingTop(mVar2.getPagerData().getStatusBarHeight());
                        mVar2.overflow(false);
                        return Unit.INSTANCE;
                    }
                });
                final NearbyFDPNavBarView nearbyFDPNavBarView = NearbyFDPNavBarView.this;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.NearbyFDPNavBarView$body$2.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.NearbyFDPNavBarView.body.2.2.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.positionAbsolute();
                                tVar2.size(tVar2.getPagerData().m(), tVar2.getPagerData().l());
                                return Unit.INSTANCE;
                            }
                        });
                        final NearbyFDPNavBarView nearbyFDPNavBarView2 = NearbyFDPNavBarView.this;
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.NearbyFDPNavBarView.body.2.2.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                final NearbyFDPNavBarView nearbyFDPNavBarView3 = NearbyFDPNavBarView.this;
                                vVar3.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.NearbyFDPNavBarView.body.2.2.2.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.size(tVar2.getPagerData().m(), tVar2.getPagerData().getNavigationBarHeight() + 32.0f);
                                        if (!com.tencent.kuikly.core.manager.c.f117352a.g().isNightMode()) {
                                            Direction direction = Direction.TO_BOTTOM;
                                            NearbyFDPNavBarAttr access$getAttr = NearbyFDPNavBarView.access$getAttr(NearbyFDPNavBarView.this);
                                            tVar2.mo135backgroundLinearGradient(direction, new j(new h(255, 255, 255, ((Number) access$getAttr.bgGradientPercentage$delegate.getValue(access$getAttr, NearbyFDPNavBarAttr.$$delegatedProperties[0])).floatValue()), 0.0f), new j(new h(255, 255, 255, 1.0f), 1.0f));
                                        } else {
                                            tVar2.mo135backgroundLinearGradient(Direction.TO_BOTTOM, new j(QUIToken.color$default("bg_bottom_light"), 0.0f), new j(QUIToken.color$default("bg_bottom_light"), 1.0f));
                                        }
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.NearbyFDPNavBarView.body.2.2.3
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                vVar3.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.NearbyFDPNavBarView.body.2.2.3.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.m140flex(1.0f);
                                        tVar2.mo113backgroundColor(QUIToken.color$default("bg_bottom_light"));
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final NearbyFDPNavBarView nearbyFDPNavBarView2 = NearbyFDPNavBarView.this;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.NearbyFDPNavBarView$body$2.3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.NearbyFDPNavBarView.body.2.3.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.mo141height(44.0f);
                                tVar2.flexDirectionRow();
                                tVar2.alignItemsStretch();
                                return Unit.INSTANCE;
                            }
                        });
                        final NearbyFDPNavBarView nearbyFDPNavBarView3 = NearbyFDPNavBarView.this;
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.NearbyFDPNavBarView.body.2.3.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                v vVar4 = vVar3;
                                final float f16 = 50.0f;
                                vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.NearbyFDPNavBarView.body.2.3.2.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.flexDirectionRow();
                                        tVar2.alignItemsCenter();
                                        tVar2.mo153width(f16);
                                        return Unit.INSTANCE;
                                    }
                                });
                                ah.a(vVar4, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.NearbyFDPNavBarView.body.2.3.2.2
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ImageView imageView) {
                                        imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.NearbyFDPNavBarView.body.2.3.2.2.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(af afVar) {
                                                af afVar2 = afVar;
                                                b.a.b(afVar2, QUIToken.INSTANCE.image("chevron_left", QUIToken.color$default("text_nav_secondary")), false, 2, null);
                                                afVar2.size(24.0f, 24.0f);
                                                afVar2.marginLeft(10.0f);
                                                afVar2.marginRight(10.0f);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NearbyFDPNavBarView nearbyFDPNavBarView4 = NearbyFDPNavBarView.this;
                                vVar4.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.NearbyFDPNavBarView.body.2.3.2.3
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(u uVar) {
                                        final NearbyFDPNavBarView nearbyFDPNavBarView5 = NearbyFDPNavBarView.this;
                                        uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.NearbyFDPNavBarView.body.2.3.2.3.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ClickParams clickParams) {
                                                Function1<Object, Unit> function1 = NearbyFDPNavBarView.access$getEvent(NearbyFDPNavBarView.this).clickBackBtnHandlerFn;
                                                if (function1 != null) {
                                                    function1.invoke(null);
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
                        final NearbyFDPNavBarView nearbyFDPNavBarView4 = NearbyFDPNavBarView.this;
                        Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.NearbyFDPNavBarView.body.2.3.3
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Boolean.valueOf(Intrinsics.areEqual(NearbyFDPNavBarView.access$getAttr(NearbyFDPNavBarView.this).getThemeId(), "") || NearbyFDPNavBarView.this.currentTheme.H);
                            }
                        };
                        final NearbyFDPNavBarView nearbyFDPNavBarView5 = NearbyFDPNavBarView.this;
                        ConditionViewKt.c(vVar2, function0, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.NearbyFDPNavBarView.body.2.3.4
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ConditionView conditionView) {
                                final NearbyFDPNavBarView nearbyFDPNavBarView6 = NearbyFDPNavBarView.this;
                                KProperty<Object>[] kPropertyArr = NearbyFDPNavBarView.$$delegatedProperties;
                                nearbyFDPNavBarView6.getClass();
                                new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.NearbyFDPNavBarView$tabsHeader$1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ViewContainer<?, ?> viewContainer3) {
                                        final NearbyFDPNavBarView nearbyFDPNavBarView7 = NearbyFDPNavBarView.this;
                                        TabsViewKt.b(viewContainer3, new Function1<TabsView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.NearbyFDPNavBarView$tabsHeader$1.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(TabsView tabsView) {
                                                TabsView tabsView2 = tabsView;
                                                final NearbyFDPNavBarView nearbyFDPNavBarView8 = NearbyFDPNavBarView.this;
                                                tabsView2.attr(new Function1<ca, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.NearbyFDPNavBarView.tabsHeader.1.1.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ca caVar) {
                                                        ca caVar2 = caVar;
                                                        caVar2.flexDirectionRow();
                                                        caVar2.m140flex(1.0f);
                                                        c.a.a(caVar2, 0.0f, 50.0f, 0.0f, 50.0f, 5, null);
                                                        caVar2.mo141height(44.0f);
                                                        NearbyFDPNavBarView nearbyFDPNavBarView9 = NearbyFDPNavBarView.this;
                                                        caVar2.h(((Number) nearbyFDPNavBarView9.curIndex$delegate.getValue(nearbyFDPNavBarView9, NearbyFDPNavBarView.$$delegatedProperties[0])).intValue());
                                                        caVar2.justifyContentSpaceAround();
                                                        caVar2.allCenter();
                                                        caVar2.m(new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.NearbyFDPNavBarView.tabsHeader.1.1.1.1
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ViewContainer<?, ?> viewContainer4) {
                                                                w.a(viewContainer4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.NearbyFDPNavBarView.tabsHeader.1.1.1.1.1
                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(v vVar3) {
                                                                        vVar3.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.NearbyFDPNavBarView.tabsHeader.1.1.1.1.1.1
                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(t tVar) {
                                                                                t tVar2 = tVar;
                                                                                tVar2.alignSelfCenter();
                                                                                tVar2.marginTop(35.0f);
                                                                                tVar2.mo153width(32.0f);
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
                                                        NearbyFDPNavBarAttr access$getAttr = NearbyFDPNavBarView.access$getAttr(NearbyFDPNavBarView.this);
                                                        ScrollParams scrollParams = (ScrollParams) access$getAttr.scrollParams$delegate.getValue(access$getAttr, NearbyFDPNavBarAttr.$$delegatedProperties[3]);
                                                        if (scrollParams != null) {
                                                            caVar2.n(scrollParams);
                                                        }
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final NearbyFDPNavBarView nearbyFDPNavBarView9 = NearbyFDPNavBarView.this;
                                                tabsView2.event(new Function1<cb, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.NearbyFDPNavBarView.tabsHeader.1.1.2
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(cb cbVar) {
                                                        final NearbyFDPNavBarView nearbyFDPNavBarView10 = NearbyFDPNavBarView.this;
                                                        FrameEventKt.e(cbVar, new Function1<com.tencent.kuikly.core.base.w, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.NearbyFDPNavBarView.tabsHeader.1.1.2.1
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(com.tencent.kuikly.core.base.w wVar) {
                                                                NearbyFDPNavBarView nearbyFDPNavBarView11 = NearbyFDPNavBarView.this;
                                                                nearbyFDPNavBarView11.tabsViewWidth$delegate.setValue(nearbyFDPNavBarView11, NearbyFDPNavBarView.$$delegatedProperties[2], Float.valueOf(wVar.getWidth()));
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final NearbyFDPNavBarView nearbyFDPNavBarView10 = NearbyFDPNavBarView.this;
                                                Function0<com.tencent.kuikly.core.reactive.collection.c<String>> function02 = new Function0<com.tencent.kuikly.core.reactive.collection.c<String>>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.NearbyFDPNavBarView.tabsHeader.1.1.3
                                                    {
                                                        super(0);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function0
                                                    public final com.tencent.kuikly.core.reactive.collection.c<String> invoke() {
                                                        NearbyFDPNavBarView nearbyFDPNavBarView11 = NearbyFDPNavBarView.this;
                                                        KProperty<Object>[] kPropertyArr2 = NearbyFDPNavBarView.$$delegatedProperties;
                                                        return nearbyFDPNavBarView11.getTabDataList();
                                                    }
                                                };
                                                final NearbyFDPNavBarView nearbyFDPNavBarView11 = NearbyFDPNavBarView.this;
                                                LoopDirectivesViewKt.a(tabsView2, function02, new Function2<LoopDirectivesView<String>, String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.NearbyFDPNavBarView.tabsHeader.1.1.4
                                                    {
                                                        super(2);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function2
                                                    public final Unit invoke(LoopDirectivesView<String> loopDirectivesView, String str) {
                                                        final String str2 = str;
                                                        final NearbyFDPNavBarView nearbyFDPNavBarView12 = NearbyFDPNavBarView.this;
                                                        TabsViewKt.a(loopDirectivesView, new Function2<bz, bz.a, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.NearbyFDPNavBarView.tabsHeader.1.1.4.1
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(2);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function2
                                                            public final Unit invoke(bz bzVar, bz.a aVar) {
                                                                bz bzVar2 = bzVar;
                                                                final bz.a aVar2 = aVar;
                                                                final NearbyFDPNavBarView nearbyFDPNavBarView13 = NearbyFDPNavBarView.this;
                                                                bzVar2.attr(new Function1<bw, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.NearbyFDPNavBarView.tabsHeader.1.1.4.1.1
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(bw bwVar) {
                                                                        bw bwVar2 = bwVar;
                                                                        bwVar2.flexDirectionRow();
                                                                        NearbyFDPNavBarView nearbyFDPNavBarView14 = NearbyFDPNavBarView.this;
                                                                        bwVar2.mo153width(((Number) nearbyFDPNavBarView14.tabsViewWidth$delegate.getValue(nearbyFDPNavBarView14, NearbyFDPNavBarView.$$delegatedProperties[2])).floatValue() / NearbyFDPNavBarView.this.getTabDataList().size());
                                                                        bwVar2.mo141height(44.0f);
                                                                        bwVar2.alignSelfCenter();
                                                                        bwVar2.allCenter();
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                final NearbyFDPNavBarView nearbyFDPNavBarView14 = NearbyFDPNavBarView.this;
                                                                final String str3 = str2;
                                                                bzVar2.event(new Function1<bx, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.NearbyFDPNavBarView.tabsHeader.1.1.4.1.2
                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(bx bxVar) {
                                                                        final NearbyFDPNavBarView nearbyFDPNavBarView15 = NearbyFDPNavBarView.this;
                                                                        final String str4 = str3;
                                                                        bxVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.NearbyFDPNavBarView.tabsHeader.1.1.4.1.2.1
                                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                            {
                                                                                super(1);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(ClickParams clickParams) {
                                                                                String str5;
                                                                                NearbyFDPNavBarView nearbyFDPNavBarView16 = NearbyFDPNavBarView.this;
                                                                                KProperty<Object>[] kPropertyArr2 = NearbyFDPNavBarView.$$delegatedProperties;
                                                                                int indexOf = nearbyFDPNavBarView16.getTabDataList().indexOf(str4);
                                                                                INearbyFeedDetailDTReporter iNearbyFeedDetailDTReporter = NearbyFDPNavBarView.access$getAttr(NearbyFDPNavBarView.this).dtReporter;
                                                                                if (iNearbyFeedDetailDTReporter != null) {
                                                                                    if (indexOf == 0) {
                                                                                        str5 = "em_nearby_tab_recommend";
                                                                                    } else {
                                                                                        str5 = "em_nearby_tab_focus";
                                                                                    }
                                                                                    NearbyFDPNavBarAttr access$getAttr = NearbyFDPNavBarView.access$getAttr(NearbyFDPNavBarView.this);
                                                                                    iNearbyFeedDetailDTReporter.dtReportNavElementClick(str5, ((Boolean) access$getAttr.isFollowingPage$delegate.getValue(access$getAttr, NearbyFDPNavBarAttr.$$delegatedProperties[4])).booleanValue());
                                                                                }
                                                                                Function1<Object, Unit> function1 = NearbyFDPNavBarView.access$getEvent(NearbyFDPNavBarView.this).clickTabHandlerFn;
                                                                                if (function1 != null) {
                                                                                    function1.invoke(Integer.valueOf(indexOf));
                                                                                }
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        });
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                final String str4 = str2;
                                                                cg.a(bzVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.NearbyFDPNavBarView.tabsHeader.1.1.4.1.3
                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(TextView textView) {
                                                                        final String str5 = str4;
                                                                        final bz.a aVar3 = aVar2;
                                                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.NearbyFDPNavBarView.tabsHeader.1.1.4.1.3.1
                                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                            {
                                                                                super(1);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(ce ceVar) {
                                                                                ce ceVar2 = ceVar;
                                                                                ceVar2.text(str5);
                                                                                ce.fontSize$default(ceVar2, 16.0f, null, 2, null);
                                                                                ceVar2.fontWeight500();
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
                                }.invoke(conditionView);
                                return Unit.INSTANCE;
                            }
                        });
                        final NearbyFDPNavBarView nearbyFDPNavBarView6 = NearbyFDPNavBarView.this;
                        ConditionViewKt.a(vVar2, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.NearbyFDPNavBarView.body.2.3.5
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ConditionView conditionView) {
                                final NearbyFDPNavBarView nearbyFDPNavBarView7 = NearbyFDPNavBarView.this;
                                w.a(conditionView, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.NearbyFDPNavBarView.body.2.3.5.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar3) {
                                        v vVar4 = vVar3;
                                        vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.NearbyFDPNavBarView.body.2.3.5.1.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                t tVar2 = tVar;
                                                tVar2.m140flex(1.0f);
                                                tVar2.allCenter();
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final NearbyFDPNavBarView nearbyFDPNavBarView8 = NearbyFDPNavBarView.this;
                                        cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.NearbyFDPNavBarView.body.2.3.5.1.2
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(TextView textView) {
                                                final NearbyFDPNavBarView nearbyFDPNavBarView9 = NearbyFDPNavBarView.this;
                                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.NearbyFDPNavBarView.body.2.3.5.1.2.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ce ceVar) {
                                                        ce ceVar2 = ceVar;
                                                        NearbyFDPNavBarAttr access$getAttr = NearbyFDPNavBarView.access$getAttr(NearbyFDPNavBarView.this);
                                                        ceVar2.text((String) access$getAttr.navTitle$delegate.getValue(access$getAttr, NearbyFDPNavBarAttr.$$delegatedProperties[1]));
                                                        ce.fontSize$default(ceVar2, 17.0f, null, 2, null);
                                                        ceVar2.color(QUIToken.color$default("text_nav_secondary"));
                                                        ceVar2.fontWeightMedium();
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
                        final NearbyFDPNavBarView nearbyFDPNavBarView7 = NearbyFDPNavBarView.this;
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.NearbyFDPNavBarView.body.2.3.6
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                v vVar4 = vVar3;
                                final float f16 = 50.0f;
                                vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.NearbyFDPNavBarView.body.2.3.6.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.flexDirectionRow();
                                        tVar2.alignItemsCenter();
                                        tVar2.justifyContentFlexEnd();
                                        tVar2.mo153width(f16);
                                        return Unit.INSTANCE;
                                    }
                                });
                                ah.a(vVar4, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.NearbyFDPNavBarView.body.2.3.6.2
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ImageView imageView) {
                                        imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.NearbyFDPNavBarView.body.2.3.6.2.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(af afVar) {
                                                af afVar2 = afVar;
                                                b.a.b(afVar2, "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_hSHiPhTcANu.png", false, 2, null);
                                                afVar2.size(24.0f, 24.0f);
                                                afVar2.marginRight(16.0f);
                                                afVar2.t(QUIToken.color$default("text_nav_secondary"));
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NearbyFDPNavBarView nearbyFDPNavBarView8 = NearbyFDPNavBarView.this;
                                vVar4.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.NearbyFDPNavBarView.body.2.3.6.3
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(u uVar) {
                                        final NearbyFDPNavBarView nearbyFDPNavBarView9 = NearbyFDPNavBarView.this;
                                        uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.NearbyFDPNavBarView.body.2.3.6.3.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ClickParams clickParams) {
                                                Function1<Object, Unit> function1 = NearbyFDPNavBarView.access$getEvent(NearbyFDPNavBarView.this).clickPublishBtnHandlerFn;
                                                if (function1 != null) {
                                                    function1.invoke(null);
                                                }
                                                NBPJumpUtil.INSTANCE.jumpPublishPage("3", null, Intrinsics.areEqual(NearbyFDPNavBarView.access$getAttr(NearbyFDPNavBarView.this).getThemeId(), "") ? null : NearbyFDPNavBarView.access$getAttr(NearbyFDPNavBarView.this).getThemeId());
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
}
