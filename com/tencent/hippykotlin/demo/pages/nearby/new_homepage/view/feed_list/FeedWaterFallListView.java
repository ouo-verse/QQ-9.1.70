package com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.feed_list;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.base.extension.PageDataExtKt;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyProKtxKt;
import com.tencent.hippykotlin.demo.pages.nearby.base.utils.FastClickUtils;
import com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPJumpUtil;
import com.tencent.hippykotlin.demo.pages.nearby.main.base.UserSelfBaseInfo;
import com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view_model.FetchStatus;
import com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view_model.NBPHomePageBaseViewModel;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.Direction;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.event.VisibilityEventKt;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.j;
import com.tencent.kuikly.core.directives.BindDirectivesView;
import com.tencent.kuikly.core.directives.BindDirectivesViewKt;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
import com.tencent.kuikly.core.directives.LoopDirectivesView;
import com.tencent.kuikly.core.directives.LoopDirectivesViewKt;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.ScrollerAttr;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.ah;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.ck;
import com.tencent.kuikly.core.views.cl;
import com.tencent.kuikly.core.views.cm;
import com.tencent.kuikly.core.views.cn;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.u;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt__StringsJVMKt;
import n35.z;
import p35.ac;
import p35.ag;
import p35.n;
import s35.af;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class FeedWaterFallListView extends ComposeView<FeedWaterFallListAttr, FeedWaterFallListEvent> {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(FeedWaterFallListView.class, "listViewHeight", "getListViewHeight()F", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(FeedWaterFallListView.class, "itemWidth", "getItemWidth()F", 0)};
    public final ReadWriteProperty listViewHeight$delegate = c.a(Float.valueOf(550.0f));
    public final ReadWriteProperty itemWidth$delegate = c.a(Float.valueOf(124.0f));
    public final FastClickUtils fastClickUtils = new FastClickUtils(500);

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ FeedWaterFallListAttr access$getAttr(FeedWaterFallListView feedWaterFallListView) {
        return (FeedWaterFallListAttr) feedWaterFallListView.getAttr();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void access$report(FeedWaterFallListView feedWaterFallListView, String str, String str2) {
        e eVar;
        NBPHomePageBaseViewModel nBPHomePageBaseViewModel = ((FeedWaterFallListAttr) feedWaterFallListView.getAttr()).viewModel;
        if (nBPHomePageBaseViewModel != null) {
            e jsonWithHomePagePgParams = nBPHomePageBaseViewModel.jsonWithHomePagePgParams();
            jsonWithHomePagePgParams.v("dt_eid", "em_kl_dynamic");
            jsonWithHomePagePgParams.v("kl_dynamic_id", str2);
            NBPHomePageBaseViewModel nBPHomePageBaseViewModel2 = ((FeedWaterFallListAttr) feedWaterFallListView.getAttr()).viewModel;
            if (nBPHomePageBaseViewModel2 != null) {
                eVar = nBPHomePageBaseViewModel2.jsonWithHomePagePgParams();
            } else {
                eVar = new e();
            }
            jsonWithHomePagePgParams.v("cur_pg", eVar);
            jsonWithHomePagePgParams.v(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
            Utils.INSTANCE.currentBridgeModule().reportCustomDtEvent(str, jsonWithHomePagePgParams);
        }
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        final float l3 = getPagerData().l() - 250.0f;
        this.listViewHeight$delegate.setValue(this, $$delegatedProperties[0], Float.valueOf(getPagerData().l() * 0.73f));
        ConditionViewKt.c(this, new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.feed_list.FeedWaterFallListView$body$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(((double) (FeedWaterFallListView.this.getPagerData().l() / FeedWaterFallListView.this.getPagerData().m())) < 1.3d);
            }
        }, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.feed_list.FeedWaterFallListView$body$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ConditionView conditionView) {
                FeedWaterFallListView feedWaterFallListView = FeedWaterFallListView.this;
                feedWaterFallListView.itemWidth$delegate.setValue(feedWaterFallListView, FeedWaterFallListView.$$delegatedProperties[1], Float.valueOf((feedWaterFallListView.getPagerData().m() - 4) / 3));
                return Unit.INSTANCE;
            }
        });
        ConditionViewKt.a(this, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.feed_list.FeedWaterFallListView$body$3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ConditionView conditionView) {
                FeedWaterFallListView feedWaterFallListView = FeedWaterFallListView.this;
                feedWaterFallListView.itemWidth$delegate.setValue(feedWaterFallListView, FeedWaterFallListView.$$delegatedProperties[1], Float.valueOf((feedWaterFallListView.getPagerData().m() - 4) / 3));
                return Unit.INSTANCE;
            }
        });
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.feed_list.FeedWaterFallListView$body$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                final FeedWaterFallListView feedWaterFallListView = FeedWaterFallListView.this;
                final float f16 = l3;
                cn.a(viewContainer, new Function1<cm, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.feed_list.FeedWaterFallListView$body$4.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(cm cmVar) {
                        cm cmVar2 = cmVar;
                        final FeedWaterFallListView feedWaterFallListView2 = FeedWaterFallListView.this;
                        cmVar2.attr(new Function1<ck, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.feed_list.FeedWaterFallListView.body.4.1.1
                            {
                                super(1);
                            }

                            /* JADX WARN: Code restructure failed: missing block: B:4:0x0010, code lost:
                            
                                if (r0.isSelf == true) goto L8;
                             */
                            @Override // kotlin.jvm.functions.Function1
                            /*
                                Code decompiled incorrectly, please refer to instructions dump.
                            */
                            public final Unit invoke(ck ckVar) {
                                boolean z16;
                                ck ckVar2 = ckVar;
                                NBPHomePageBaseViewModel nBPHomePageBaseViewModel = FeedWaterFallListView.access$getAttr(FeedWaterFallListView.this).viewModel;
                                if (nBPHomePageBaseViewModel != null) {
                                    z16 = true;
                                }
                                z16 = false;
                                if (z16) {
                                    FeedWaterFallListView feedWaterFallListView3 = FeedWaterFallListView.this;
                                    ckVar2.mo141height(((Number) feedWaterFallListView3.listViewHeight$delegate.getValue(feedWaterFallListView3, FeedWaterFallListView.$$delegatedProperties[0])).floatValue() + 10.0f);
                                } else {
                                    FeedWaterFallListView feedWaterFallListView4 = FeedWaterFallListView.this;
                                    ckVar2.mo141height(((Number) feedWaterFallListView4.listViewHeight$delegate.getValue(feedWaterFallListView4, FeedWaterFallListView.$$delegatedProperties[0])).floatValue() + 90.0f);
                                }
                                ckVar2.w(ckVar2.getPagerData().m());
                                ckVar2.u(1.0f);
                                ckVar2.t(1.0f);
                                ckVar2.h(3);
                                ckVar2.justifyContentCenter();
                                ckVar2.alignItemsCenter();
                                ckVar2.alignSelfCenter();
                                ScrollerAttr.bouncesEnable$default(ckVar2, false, false, 2, null);
                                ckVar2.showScrollerIndicator(false);
                                ckVar2.scrollEnable(false);
                                return Unit.INSTANCE;
                            }
                        });
                        final float f17 = f16;
                        final FeedWaterFallListView feedWaterFallListView3 = FeedWaterFallListView.this;
                        cmVar2.event(new Function1<cl, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.feed_list.FeedWaterFallListView.body.4.1.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(cl clVar) {
                                final float f18 = f17;
                                final FeedWaterFallListView feedWaterFallListView4 = feedWaterFallListView3;
                                clVar.contentSizeChanged(new Function2<Float, Float, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.feed_list.FeedWaterFallListView.body.4.1.2.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public final Unit invoke(Float f19, Float f26) {
                                        f19.floatValue();
                                        float floatValue = f26.floatValue();
                                        if (floatValue > f18) {
                                            FeedWaterFallListView feedWaterFallListView5 = feedWaterFallListView4;
                                            feedWaterFallListView5.listViewHeight$delegate.setValue(feedWaterFallListView5, FeedWaterFallListView.$$delegatedProperties[0], Float.valueOf(floatValue));
                                            FeedWaterFallListView feedWaterFallListView6 = feedWaterFallListView4;
                                            e eVar = new e();
                                            eVar.v("height", Float.valueOf(floatValue));
                                            Unit unit = Unit.INSTANCE;
                                            feedWaterFallListView6.onFireEvent("changePageHeight", eVar);
                                        }
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final FeedWaterFallListView feedWaterFallListView4 = FeedWaterFallListView.this;
                        Function0<com.tencent.kuikly.core.reactive.collection.c<n>> function0 = new Function0<com.tencent.kuikly.core.reactive.collection.c<n>>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.feed_list.FeedWaterFallListView.body.4.1.3
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final com.tencent.kuikly.core.reactive.collection.c<n> invoke() {
                                FeedWaterFallListAttr access$getAttr = FeedWaterFallListView.access$getAttr(FeedWaterFallListView.this);
                                return (com.tencent.kuikly.core.reactive.collection.c) access$getAttr.feedList$delegate.getValue(access$getAttr, FeedWaterFallListAttr.$$delegatedProperties[0]);
                            }
                        };
                        final FeedWaterFallListView feedWaterFallListView5 = FeedWaterFallListView.this;
                        LoopDirectivesViewKt.a(cmVar2, function0, new Function2<LoopDirectivesView<n>, n, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.feed_list.FeedWaterFallListView.body.4.1.4
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public final Unit invoke(LoopDirectivesView<n> loopDirectivesView, n nVar) {
                                final n nVar2 = nVar;
                                final FeedWaterFallListView feedWaterFallListView6 = FeedWaterFallListView.this;
                                w.a(loopDirectivesView, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.feed_list.FeedWaterFallListView.body.4.1.4.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar) {
                                        v vVar2 = vVar;
                                        final FeedWaterFallListView feedWaterFallListView7 = FeedWaterFallListView.this;
                                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.feed_list.FeedWaterFallListView.body.4.1.4.1.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                t tVar2 = tVar;
                                                tVar2.size(FeedWaterFallListView.this.getItemWidth(), FeedWaterFallListView.this.getItemWidth());
                                                tVar2.allCenter();
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final FeedWaterFallListView feedWaterFallListView8 = FeedWaterFallListView.this;
                                        final n nVar3 = nVar2;
                                        vVar2.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.feed_list.FeedWaterFallListView.body.4.1.4.1.2
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(u uVar) {
                                                u uVar2 = uVar;
                                                final FeedWaterFallListView feedWaterFallListView9 = FeedWaterFallListView.this;
                                                final n nVar4 = nVar3;
                                                uVar2.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.feed_list.FeedWaterFallListView.body.4.1.4.1.2.1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ClickParams clickParams) {
                                                        FeedWaterFallListView.access$report(FeedWaterFallListView.this, "dt_clck", nVar4.f425193d);
                                                        NBPHomePageBaseViewModel nBPHomePageBaseViewModel = FeedWaterFallListView.access$getAttr(FeedWaterFallListView.this).viewModel;
                                                        if (nBPHomePageBaseViewModel != null) {
                                                            n nVar5 = nVar4;
                                                            String str = nVar5.f425193d;
                                                            UserSelfBaseInfo selfBaseInfo = nBPHomePageBaseViewModel.getSelfBaseInfo();
                                                            Object obj = null;
                                                            if (nBPHomePageBaseViewModel.getAppId() == 1) {
                                                                af afVar = nVar5.f425194e;
                                                                if (afVar != null) {
                                                                    obj = afVar.f433205d;
                                                                }
                                                            } else {
                                                                af afVar2 = nVar5.f425194e;
                                                                if (afVar2 != null) {
                                                                    obj = Long.valueOf(afVar2.f433207e);
                                                                }
                                                            }
                                                            NBPJumpUtil.jumpArticleFeedDetailPage$default(String.valueOf(obj), str, selfBaseInfo, 0, nVar5, null, null, 96);
                                                        }
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final FeedWaterFallListView feedWaterFallListView10 = FeedWaterFallListView.this;
                                                final n nVar5 = nVar3;
                                                VisibilityEventKt.b(uVar2, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.feed_list.FeedWaterFallListView.body.4.1.4.1.2.2
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(Object obj) {
                                                        FeedWaterFallListView.access$report(FeedWaterFallListView.this, "dt_imp", nVar5.f425193d);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final n nVar4 = nVar2;
                                        final FeedWaterFallListView feedWaterFallListView9 = FeedWaterFallListView.this;
                                        ah.a(vVar2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.feed_list.FeedWaterFallListView.body.4.1.4.1.3
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ImageView imageView) {
                                                final n nVar5 = n.this;
                                                final FeedWaterFallListView feedWaterFallListView10 = feedWaterFallListView9;
                                                imageView.attr(new Function1<com.tencent.kuikly.core.views.af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.feed_list.FeedWaterFallListView.body.4.1.4.1.3.1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(com.tencent.kuikly.core.views.af afVar) {
                                                        Object firstOrNull;
                                                        n35.w wVar;
                                                        List<z> list;
                                                        Object firstOrNull2;
                                                        Object firstOrNull3;
                                                        String str;
                                                        com.tencent.kuikly.core.views.af afVar2 = afVar;
                                                        afVar2.absolutePositionAllZero();
                                                        n35.v vVar3 = null;
                                                        if (n.this.L == 1) {
                                                            b.a.b(afVar2, "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_dyLPvKbIRS6.png", false, 2, null);
                                                        } else {
                                                            NBPHomePageBaseViewModel nBPHomePageBaseViewModel = FeedWaterFallListView.access$getAttr(feedWaterFallListView10).viewModel;
                                                            Integer valueOf = nBPHomePageBaseViewModel != null ? Integer.valueOf(nBPHomePageBaseViewModel.getAppId()) : null;
                                                            if (valueOf != null && valueOf.intValue() == 1) {
                                                                firstOrNull3 = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) n.this.f425198m);
                                                                ag agVar = (ag) firstOrNull3;
                                                                if (agVar == null || (str = agVar.f425140e) == null) {
                                                                    str = "";
                                                                }
                                                                b.a.b(afVar2, str, false, 2, null);
                                                            } else if (valueOf != null && valueOf.intValue() == 2) {
                                                                firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) n.this.f425198m);
                                                                ag agVar2 = (ag) firstOrNull;
                                                                if (agVar2 != null && (wVar = agVar2.f425139d) != null && (list = wVar.f418273d) != null) {
                                                                    firstOrNull2 = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) list);
                                                                    z zVar = (z) firstOrNull2;
                                                                    if (zVar != null) {
                                                                        vVar3 = zVar.f418280d;
                                                                    }
                                                                }
                                                                NearbyProKtxKt.srcWithIndexNode(afVar2, vVar3);
                                                            }
                                                        }
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final FeedWaterFallListView feedWaterFallListView10 = FeedWaterFallListView.this;
                                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.feed_list.FeedWaterFallListView.body.4.1.4.1.4
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(v vVar3) {
                                                final FeedWaterFallListView feedWaterFallListView11 = FeedWaterFallListView.this;
                                                vVar3.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.feed_list.FeedWaterFallListView.body.4.1.4.1.4.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(t tVar) {
                                                        t tVar2 = tVar;
                                                        tVar2.positionAbsolute();
                                                        tVar2.m142left(0.0f);
                                                        tVar2.m138bottom(0.0f);
                                                        tVar2.mo153width(FeedWaterFallListView.this.getItemWidth());
                                                        tVar2.mo141height(30.0f);
                                                        tVar2.mo135backgroundLinearGradient(Direction.TO_TOP, new j(new h(0L, 0.4f), 0.0f), new j(new h(0L, 0.0f), 1.0f));
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final n nVar5 = nVar2;
                                        Function0<Object> function02 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.feed_list.FeedWaterFallListView.body.4.1.4.1.5
                                            {
                                                super(0);
                                            }

                                            @Override // kotlin.jvm.functions.Function0
                                            public final Object invoke() {
                                                return Boolean.valueOf(n.this.L == 1);
                                            }
                                        };
                                        final n nVar6 = nVar2;
                                        ConditionViewKt.c(vVar2, function02, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.feed_list.FeedWaterFallListView.body.4.1.4.1.6
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ConditionView conditionView) {
                                                final n nVar7 = n.this;
                                                cg.a(conditionView, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.feed_list.FeedWaterFallListView.body.4.1.4.1.6.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(TextView textView) {
                                                        final n nVar8 = n.this;
                                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.feed_list.FeedWaterFallListView.body.4.1.4.1.6.1.1
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ce ceVar) {
                                                                String decodeToString;
                                                                ce ceVar2 = ceVar;
                                                                ceVar2.textPostProcessor("emoji");
                                                                ce.fontSize$default(ceVar2, 18.0f, null, 2, null);
                                                                ceVar2.lineHeight(22.0f);
                                                                ceVar2.marginLeft(17.0f);
                                                                ceVar2.marginRight(17.0f);
                                                                ceVar2.color(new h(7504300L, 1.0f));
                                                                decodeToString = StringsKt__StringsJVMKt.decodeToString(n.this.f425197i.f30291a);
                                                                ceVar2.text(decodeToString);
                                                                ceVar2.lines(3);
                                                                ceVar2.textAlignCenter();
                                                                ceVar2.textOverFlowTail();
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final n nVar7 = nVar2;
                                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.feed_list.FeedWaterFallListView.body.4.1.4.1.7
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(v vVar3) {
                                                v vVar4 = vVar3;
                                                vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.feed_list.FeedWaterFallListView.body.4.1.4.1.7.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(t tVar) {
                                                        t tVar2 = tVar;
                                                        tVar2.positionAbsolute();
                                                        tVar2.m142left(9.0f);
                                                        tVar2.m138bottom(0.0f);
                                                        tVar2.m140flex(1.0f);
                                                        tVar2.mo141height(20.0f);
                                                        tVar2.flexDirectionRow();
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                ah.a(vVar4, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.feed_list.FeedWaterFallListView.body.4.1.4.1.7.2
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ImageView imageView) {
                                                        imageView.attr(new Function1<com.tencent.kuikly.core.views.af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.feed_list.FeedWaterFallListView.body.4.1.4.1.7.2.1
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(com.tencent.kuikly.core.views.af afVar) {
                                                                com.tencent.kuikly.core.views.af afVar2 = afVar;
                                                                afVar2.size(12.0f, 12.0f);
                                                                afVar2.marginRight(2.0f);
                                                                b.a.b(afVar2, "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_tPIqJvJ-LcH.png", false, 2, null);
                                                                afVar2.alignSelfCenter();
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final n nVar8 = n.this;
                                                cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.feed_list.FeedWaterFallListView.body.4.1.4.1.7.3
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(TextView textView) {
                                                        final n nVar9 = n.this;
                                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.feed_list.FeedWaterFallListView.body.4.1.4.1.7.3.1
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ce ceVar) {
                                                                String str;
                                                                ce ceVar2 = ceVar;
                                                                ce.fontSize$default(ceVar2, 12.0f, null, 2, null);
                                                                ceVar2.color(h.INSTANCE.m());
                                                                ac acVar = n.this.E;
                                                                if (acVar == null || (str = Integer.valueOf(acVar.f425120e).toString()) == null) {
                                                                    str = "0";
                                                                }
                                                                ceVar2.text(str);
                                                                ceVar2.alignSelfCenter();
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
                        final FeedWaterFallListView feedWaterFallListView6 = FeedWaterFallListView.this;
                        Function0<Object> function02 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.feed_list.FeedWaterFallListView.body.4.1.5
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                FeedWaterFallListAttr access$getAttr = FeedWaterFallListView.access$getAttr(FeedWaterFallListView.this);
                                return (FetchStatus) access$getAttr.fetchStatus$delegate.getValue(access$getAttr, FeedWaterFallListAttr.$$delegatedProperties[1]);
                            }
                        };
                        final FeedWaterFallListView feedWaterFallListView7 = FeedWaterFallListView.this;
                        BindDirectivesViewKt.a(cmVar2, function02, new Function1<BindDirectivesView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.feed_list.FeedWaterFallListView.body.4.1.6
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(BindDirectivesView bindDirectivesView) {
                                BindDirectivesView bindDirectivesView2 = bindDirectivesView;
                                FeedWaterFallListAttr access$getAttr = FeedWaterFallListView.access$getAttr(FeedWaterFallListView.this);
                                int ordinal = ((FetchStatus) access$getAttr.fetchStatus$delegate.getValue(access$getAttr, FeedWaterFallListAttr.$$delegatedProperties[1])).ordinal();
                                if (ordinal == 1) {
                                    final FeedWaterFallListView feedWaterFallListView8 = FeedWaterFallListView.this;
                                    bindDirectivesView2.addChild(new HomepageFeedsErrorTipsView(), new Function1<HomepageFeedsErrorTipsView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.feed_list.FeedWaterFallListView.body.4.1.6.4
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(HomepageFeedsErrorTipsView homepageFeedsErrorTipsView) {
                                            final FeedWaterFallListView feedWaterFallListView9 = FeedWaterFallListView.this;
                                            homepageFeedsErrorTipsView.attr(new Function1<HomepageFeedsErrorTipsAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.feed_list.FeedWaterFallListView.body.4.1.6.4.1
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(HomepageFeedsErrorTipsAttr homepageFeedsErrorTipsAttr) {
                                                    HomepageFeedsErrorTipsAttr homepageFeedsErrorTipsAttr2 = homepageFeedsErrorTipsAttr;
                                                    homepageFeedsErrorTipsAttr2.viewModel = FeedWaterFallListView.access$getAttr(FeedWaterFallListView.this).viewModel;
                                                    homepageFeedsErrorTipsAttr2.mo153width(homepageFeedsErrorTipsAttr2.getPagerData().m());
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            return Unit.INSTANCE;
                                        }
                                    });
                                } else if (ordinal == 3) {
                                    final FeedWaterFallListView feedWaterFallListView9 = FeedWaterFallListView.this;
                                    bindDirectivesView2.addChild(new HomepageFeedsLoadingView(), new Function1<HomepageFeedsLoadingView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.feed_list.FeedWaterFallListView.body.4.1.6.1
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(HomepageFeedsLoadingView homepageFeedsLoadingView) {
                                            final FeedWaterFallListView feedWaterFallListView10 = FeedWaterFallListView.this;
                                            homepageFeedsLoadingView.attr(new Function1<HomepageFeedsLoadingAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.feed_list.FeedWaterFallListView.body.4.1.6.1.1
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(HomepageFeedsLoadingAttr homepageFeedsLoadingAttr) {
                                                    HomepageFeedsLoadingAttr homepageFeedsLoadingAttr2 = homepageFeedsLoadingAttr;
                                                    NBPHomePageBaseViewModel nBPHomePageBaseViewModel = FeedWaterFallListView.access$getAttr(FeedWaterFallListView.this).viewModel;
                                                    homepageFeedsLoadingAttr2.getClass();
                                                    homepageFeedsLoadingAttr2.mo153width(homepageFeedsLoadingAttr2.getPagerData().m());
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            return Unit.INSTANCE;
                                        }
                                    });
                                } else if (ordinal == 4) {
                                    final FeedWaterFallListView feedWaterFallListView10 = FeedWaterFallListView.this;
                                    Function0<Object> function03 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.feed_list.FeedWaterFallListView.body.4.1.6.2
                                        {
                                            super(0);
                                        }

                                        @Override // kotlin.jvm.functions.Function0
                                        public final Object invoke() {
                                            FeedWaterFallListAttr access$getAttr2 = FeedWaterFallListView.access$getAttr(FeedWaterFallListView.this);
                                            return Boolean.valueOf(((com.tencent.kuikly.core.reactive.collection.c) access$getAttr2.feedList$delegate.getValue(access$getAttr2, FeedWaterFallListAttr.$$delegatedProperties[0])).isEmpty());
                                        }
                                    };
                                    final FeedWaterFallListView feedWaterFallListView11 = FeedWaterFallListView.this;
                                    ConditionViewKt.c(bindDirectivesView2, function03, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.feed_list.FeedWaterFallListView.body.4.1.6.3
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(ConditionView conditionView) {
                                            final FeedWaterFallListView feedWaterFallListView12 = FeedWaterFallListView.this;
                                            w.a(conditionView, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.feed_list.FeedWaterFallListView.body.4.1.6.3.1
                                                {
                                                    super(1);
                                                }

                                                /* JADX WARN: Code restructure failed: missing block: B:4:0x0028, code lost:
                                                
                                                    if (r0.isSelf == true) goto L8;
                                                 */
                                                @Override // kotlin.jvm.functions.Function1
                                                /*
                                                    Code decompiled incorrectly, please refer to instructions dump.
                                                */
                                                public final Unit invoke(v vVar) {
                                                    v vVar2 = vVar;
                                                    final FeedWaterFallListView feedWaterFallListView13 = FeedWaterFallListView.this;
                                                    vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.feed_list.FeedWaterFallListView.body.4.1.6.3.1.1
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(t tVar) {
                                                            t tVar2 = tVar;
                                                            tVar2.mo141height(tVar2.getPagerData().l() - 250.0f);
                                                            tVar2.mo153width((FeedWaterFallListView.this.getItemWidth() + 1) * 3);
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    ah.a(vVar2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.feed_list.FeedWaterFallListView.body.4.1.6.3.1.2
                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(ImageView imageView) {
                                                            imageView.attr(new Function1<com.tencent.kuikly.core.views.af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.feed_list.FeedWaterFallListView.body.4.1.6.3.1.2.1
                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(com.tencent.kuikly.core.views.af afVar) {
                                                                    com.tencent.kuikly.core.views.af afVar2 = afVar;
                                                                    afVar2.size(69.0f, 69.0f);
                                                                    b.a.b(afVar2, "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_TzMDBaNd74o.png", false, 2, null);
                                                                    if (PageDataExtKt.isNightMode(afVar2.getPagerData())) {
                                                                        afVar2.t(h.INSTANCE.m());
                                                                    }
                                                                    afVar2.alignSelfCenter();
                                                                    afVar2.marginTop(24.0f);
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    final FeedWaterFallListView feedWaterFallListView14 = FeedWaterFallListView.this;
                                                    cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.feed_list.FeedWaterFallListView.body.4.1.6.3.1.3
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(TextView textView) {
                                                            final FeedWaterFallListView feedWaterFallListView15 = FeedWaterFallListView.this;
                                                            textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.feed_list.FeedWaterFallListView.body.4.1.6.3.1.3.1
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(ce ceVar) {
                                                                    String str;
                                                                    ce ceVar2 = ceVar;
                                                                    ce.fontSize$default(ceVar2, 16.0f, null, 2, null);
                                                                    ceVar2.marginTop(24.0f);
                                                                    ceVar2.lineHeight(22.0f);
                                                                    ceVar2.color(QUIToken.color$default("text_primary"));
                                                                    NBPHomePageBaseViewModel nBPHomePageBaseViewModel = FeedWaterFallListView.access$getAttr(FeedWaterFallListView.this).viewModel;
                                                                    boolean z16 = false;
                                                                    if ((nBPHomePageBaseViewModel != null && nBPHomePageBaseViewModel.isSelf) && !FeedWaterFallListView.access$getAttr(FeedWaterFallListView.this).isUserLikedPage) {
                                                                        str = "\u5206\u4eab\u6b64\u523b\uff0c\u603b\u6709\u4eba\u61c2\u4f60";
                                                                    } else {
                                                                        NBPHomePageBaseViewModel nBPHomePageBaseViewModel2 = FeedWaterFallListView.access$getAttr(FeedWaterFallListView.this).viewModel;
                                                                        if (((nBPHomePageBaseViewModel2 == null || nBPHomePageBaseViewModel2.isSelf) ? false : true) && !FeedWaterFallListView.access$getAttr(FeedWaterFallListView.this).isUserLikedPage) {
                                                                            str = "TA\u8fd8\u6ca1\u6709\u52a8\u6001\u54e6";
                                                                        } else {
                                                                            NBPHomePageBaseViewModel nBPHomePageBaseViewModel3 = FeedWaterFallListView.access$getAttr(FeedWaterFallListView.this).viewModel;
                                                                            if (nBPHomePageBaseViewModel3 != null && nBPHomePageBaseViewModel3.isSelf) {
                                                                                z16 = true;
                                                                            }
                                                                            if (z16 && FeedWaterFallListView.access$getAttr(FeedWaterFallListView.this).isUserLikedPage) {
                                                                                str = "\u4f60\u8fd8\u6ca1\u6709\u70b9\u8d5e\u8fc7\u52a8\u6001\u54e6";
                                                                            } else {
                                                                                str = "TA\u8fd8\u6ca1\u6709\u70b9\u8d5e\u8fc7\u52a8\u6001\u54e6";
                                                                            }
                                                                        }
                                                                    }
                                                                    ceVar2.text(str);
                                                                    ceVar2.alignSelfCenter();
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    NBPHomePageBaseViewModel nBPHomePageBaseViewModel = FeedWaterFallListView.access$getAttr(FeedWaterFallListView.this).viewModel;
                                                    boolean z16 = nBPHomePageBaseViewModel != null;
                                                    if (z16 && !FeedWaterFallListView.access$getAttr(FeedWaterFallListView.this).isUserLikedPage) {
                                                        final FeedWaterFallListView feedWaterFallListView15 = FeedWaterFallListView.this;
                                                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.feed_list.FeedWaterFallListView.body.4.1.6.3.1.4
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(v vVar3) {
                                                                v vVar4 = vVar3;
                                                                vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.feed_list.FeedWaterFallListView.body.4.1.6.3.1.4.1
                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(t tVar) {
                                                                        t tVar2 = tVar;
                                                                        tVar2.size(74.0f, 29.0f);
                                                                        tVar2.marginTop(15.0f);
                                                                        tVar2.allCenter();
                                                                        tVar2.alignSelfCenter();
                                                                        tVar2.borderRadius(4.0f);
                                                                        tVar2.mo113backgroundColor(QUIToken.color$default("button_bg_primary_default"));
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                final FeedWaterFallListView feedWaterFallListView16 = FeedWaterFallListView.this;
                                                                vVar4.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.feed_list.FeedWaterFallListView.body.4.1.6.3.1.4.2
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(u uVar) {
                                                                        final FeedWaterFallListView feedWaterFallListView17 = FeedWaterFallListView.this;
                                                                        uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.feed_list.FeedWaterFallListView.body.4.1.6.3.1.4.2.1
                                                                            {
                                                                                super(1);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(ClickParams clickParams) {
                                                                                if (!FeedWaterFallListView.this.fastClickUtils.isFastDoubleClick()) {
                                                                                    NBPHomePageBaseViewModel nBPHomePageBaseViewModel2 = FeedWaterFallListView.access$getAttr(FeedWaterFallListView.this).viewModel;
                                                                                    if (nBPHomePageBaseViewModel2 != null && nBPHomePageBaseViewModel2.getAppId() == 2) {
                                                                                        NBPJumpUtil.INSTANCE.jumpPublishPage("1", null, null);
                                                                                    } else {
                                                                                        QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
                                                                                        QQKuiklyPlatformApi.Companion.openPage$default("mqqapi://stranger/publish_feed", false, 6);
                                                                                    }
                                                                                }
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        });
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.feed_list.FeedWaterFallListView.body.4.1.6.3.1.4.3
                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(TextView textView) {
                                                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.feed_list.FeedWaterFallListView.body.4.1.6.3.1.4.3.1
                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(ce ceVar) {
                                                                                ce ceVar2 = ceVar;
                                                                                ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                                                                ceVar2.fontWeight400();
                                                                                ceVar2.color(QUIToken.color$default("button_text_primary_default"));
                                                                                ceVar2.text("\u53bb\u53d1\u5e03");
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
                                                    w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.feed_list.FeedWaterFallListView.body.4.1.6.3.1.5
                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(v vVar3) {
                                                            v vVar4 = vVar3;
                                                            vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.feed_list.FeedWaterFallListView.body.4.1.6.3.1.5.1
                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(t tVar) {
                                                                    t tVar2 = tVar;
                                                                    tVar2.mo141height(10.0f);
                                                                    tVar2.mo113backgroundColor(QUIToken.color$default("bg_bottom_light"));
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                            w.a(vVar4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.feed_list.FeedWaterFallListView.body.4.1.6.3.1.5.2
                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(v vVar5) {
                                                                    vVar5.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.feed_list.FeedWaterFallListView.body.4.1.6.3.1.5.2.1
                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        public final Unit invoke(t tVar) {
                                                                            t tVar2 = tVar;
                                                                            tVar2.mo141height(400.0f);
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
                        return Unit.INSTANCE;
                    }
                });
                return Unit.INSTANCE;
            }
        };
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return new FeedWaterFallListAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new FeedWaterFallListEvent();
    }

    public final float getItemWidth() {
        return ((Number) this.itemWidth$delegate.getValue(this, $$delegatedProperties[1])).floatValue();
    }
}
