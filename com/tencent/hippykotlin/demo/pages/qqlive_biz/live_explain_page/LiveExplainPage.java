package com.tencent.hippykotlin.demo.pages.qqlive_biz.live_explain_page;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.RoleCardKt$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.BasePager;
import com.tencent.hippykotlin.demo.pages.base.EcommerceExtKt;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.qqlive_biz.live_explain_page.model.ExplainBubbleDetail;
import com.tencent.hippykotlin.demo.pages.qqlive_biz.live_explain_page.model.ExplainBubbleInfo;
import com.tencent.hippykotlin.demo.pages.qqlive_biz.live_explain_page.model.LiveExplainDataRspModel;
import com.tencent.hippykotlin.demo.pages.qqlive_biz.live_explain_page.model.LiveExplainReportModel;
import com.tencent.hippykotlin.demo.pages.qqlive_biz.live_explain_page.model.LiveExplainReportModel$reportExplainBubbleClicked$1;
import com.tencent.hippykotlin.demo.pages.qqlive_biz.live_explain_page.model.LiveExplainRequestModel;
import com.tencent.hippykotlin.demo.pages.qqlive_biz.live_explain_page.view.ExplainBubbleViewAttr;
import com.tencent.hippykotlin.demo.pages.qqlive_biz.live_explain_page.view.ExplainBubbleViewEvent;
import com.tencent.hippykotlin.demo.pages.qqlive_biz.live_explain_page.view.HotSaleViewEvent;
import com.tencent.hippykotlin.demo.pages.qqlive_biz.live_explain_page.view.LiveExplainBubbleView;
import com.tencent.hippykotlin.demo.pages.qqlive_biz.live_explain_page.view.LiveHotSaleView;
import com.tencent.hippykotlin.demo.pages.qqlive_biz.live_explain_page.view.LiveHotSaleViewAttr;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.aa;
import com.tencent.kuikly.core.base.attr.d;
import com.tencent.kuikly.core.base.b;
import com.tencent.kuikly.core.base.event.AnimationCompletionParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.l;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.base.u;
import com.tencent.kuikly.core.base.y;
import com.tencent.kuikly.core.directives.BindDirectivesView;
import com.tencent.kuikly.core.directives.BindDirectivesViewKt;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
import com.tencent.kuikly.core.module.k;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.pager.c;
import com.tencent.kuikly.core.timer.TimerKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import org.apache.httpcore.message.TokenParser;

/* loaded from: classes32.dex */
public final class LiveExplainPage extends BasePager implements c {
    public static final /* synthetic */ int $r8$clinit = 0;
    public aa<LiveExplainBubbleView> explainViewRef;
    public boolean hasExplainViewShowing;
    public aa<LiveHotSaleView> hotSaleViewRef;
    public final LiveExplainPageAttr pageAttr = new LiveExplainPageAttr();

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqlive_biz.live_explain_page.LiveExplainPage$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                final LiveExplainPage liveExplainPage = LiveExplainPage.this;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqlive_biz.live_explain_page.LiveExplainPage$body$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        float f16;
                        int i3;
                        b.Companion companion;
                        final m mVar2 = mVar;
                        mVar2.justifyContentFlexEnd();
                        final LiveExplainPage liveExplainPage2 = LiveExplainPage.this;
                        Float valueOf = Float.valueOf(0.04f);
                        Float valueOf2 = Float.valueOf(0.16f);
                        Float valueOf3 = Float.valueOf(0.0f);
                        Float[] fArr = {Float.valueOf(0.25f), valueOf, valueOf2, valueOf3, valueOf3};
                        int showAnimationFlag = liveExplainPage2.pageAttr.getShowAnimationFlag();
                        if (showAnimationFlag == 0) {
                            f16 = 0.0f;
                            i3 = 2;
                            d.a.a(mVar2, null, new u(0.0f, 0.0f), new y(0.0f, 0.5f, 0.0f, 0.0f, 12, null), null, null, 25, null);
                            mVar2.m147opacity(0.0f);
                        } else if (showAnimationFlag != 1) {
                            if (showAnimationFlag == 2) {
                                TimerKt.f(mVar2.getPagerId(), new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqlive_biz.live_explain_page.LiveExplainPageKt$bindShowAnimation$1
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public final Unit invoke() {
                                        aa<LiveExplainBubbleView> aaVar = LiveExplainPage.this.explainViewRef;
                                        LiveExplainBubbleView b16 = aaVar != null ? aaVar.b() : null;
                                        if (b16 != null) {
                                            b16.playBuyBtnAnimation();
                                        }
                                        return Unit.INSTANCE;
                                    }
                                }, 160);
                                TimerKt.f(mVar2.getPagerId(), new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqlive_biz.live_explain_page.LiveExplainPageKt$bindShowAnimation$2
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public final Unit invoke() {
                                        Utils utils = Utils.INSTANCE;
                                        String pagerId = Attr.this.getPagerId();
                                        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("explain_view ctx.pageAttr.hotSaleAppearAnimated ");
                                        m3.append(liveExplainPage2.pageAttr.getHotSaleAppearAnimated());
                                        utils.bridgeModule(pagerId).log(m3.toString());
                                        if (liveExplainPage2.pageAttr.getHotSaleNum() >= 9) {
                                            liveExplainPage2.pageAttr.setHotSaleAppearAnimated(true);
                                        }
                                        return Unit.INSTANCE;
                                    }
                                }, 960);
                            }
                            f16 = 0.0f;
                            i3 = 2;
                        } else {
                            mVar2.m147opacity(1.0f);
                            f16 = 0.0f;
                            i3 = 2;
                            d.a.a(mVar2, null, new u(1.0f, 1.0f), new y(0.0f, 0.0f, 0.0f, 0.0f, 12, null), null, null, 25, null);
                        }
                        b.Companion companion2 = b.INSTANCE;
                        mVar2.m134animation(b.Companion.l(companion2, fArr[liveExplainPage2.pageAttr.getShowAnimationFlag() % 4].floatValue(), null, i3, null), (Object) Integer.valueOf(liveExplainPage2.pageAttr.getShowAnimationFlag()));
                        LiveExplainPage liveExplainPage3 = LiveExplainPage.this;
                        Float[] fArr2 = new Float[5];
                        fArr2[0] = valueOf2;
                        fArr2[1] = valueOf;
                        fArr2[i3] = valueOf2;
                        fArr2[3] = valueOf3;
                        fArr2[4] = valueOf3;
                        int closeAnimationFlag = liveExplainPage3.pageAttr.getCloseAnimationFlag();
                        if (closeAnimationFlag == 1) {
                            companion = companion2;
                            mVar2.transform(new u(1.08f, 1.08f));
                        } else if (closeAnimationFlag == i3) {
                            companion = companion2;
                            mVar2.transform(new u(1.03f, 1.03f));
                        } else if (closeAnimationFlag != 3) {
                            companion = companion2;
                        } else {
                            companion = companion2;
                            d.a.a(mVar2, null, new u(0.6f, 0.6f), new y(0.0f, 0.3f, 0.0f, 0.0f, 12, null), null, null, 25, null);
                            mVar2.m147opacity(f16);
                        }
                        float floatValue = fArr2[liveExplainPage3.pageAttr.getCloseAnimationFlag() % 4].floatValue();
                        b.Companion companion3 = companion;
                        mVar2.m134animation(b.Companion.l(companion3, floatValue, null, i3, null), (Object) Integer.valueOf(liveExplainPage3.pageAttr.getCloseAnimationFlag()));
                        LiveExplainPage liveExplainPage4 = LiveExplainPage.this;
                        if (liveExplainPage4.pageAttr.getCutoverAnimationFlag() == 1) {
                            d.a.a(mVar2, null, new u(f16, f16), new y(0.0f, 0.5f, 0.0f, 0.0f, 12, null), null, null, 25, null);
                            mVar2.m147opacity(f16);
                        }
                        mVar2.m134animation(b.Companion.l(companion3, 0.2f, null, i3, null), (Object) Integer.valueOf(liveExplainPage4.pageAttr.getCutoverAnimationFlag()));
                        return Unit.INSTANCE;
                    }
                });
                final LiveExplainPage liveExplainPage2 = LiveExplainPage.this;
                viewContainer2.event(new Function1<Event, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqlive_biz.live_explain_page.LiveExplainPage$body$1.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Event event) {
                        final LiveExplainPage liveExplainPage3 = LiveExplainPage.this;
                        event.animationCompletion(new Function1<AnimationCompletionParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqlive_biz.live_explain_page.LiveExplainPage.body.1.2.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(AnimationCompletionParams animationCompletionParams) {
                                ExplainBubbleDetail explainBubbleDetail;
                                LiveExplainPage liveExplainPage4 = LiveExplainPage.this;
                                if (liveExplainPage4.pageAttr.getCloseAnimationFlag() != 0 && liveExplainPage4.pageAttr.getCloseAnimationFlag() < 4) {
                                    LiveExplainPageAttr liveExplainPageAttr = liveExplainPage4.pageAttr;
                                    liveExplainPageAttr.setCloseAnimationFlag(liveExplainPageAttr.getCloseAnimationFlag() + 1);
                                    if (liveExplainPage4.pageAttr.getCloseAnimationFlag() == 4) {
                                        e m3 = RoleCardKt$$ExternalSyntheticOutline0.m("type", 0);
                                        m3.t("roomID", liveExplainPage4.getPageData().n().j("roomID"));
                                        k kVar = (k) liveExplainPage4.getModule("KRNotifyModule");
                                        if (kVar != null) {
                                            k.d(kVar, "LiveExplainViewEventNotification", m3, false, 4, null);
                                        }
                                        return Unit.INSTANCE;
                                    }
                                }
                                if (liveExplainPage4.pageAttr.getShowAnimationFlag() != 0) {
                                    LiveExplainPageAttr liveExplainPageAttr2 = liveExplainPage4.pageAttr;
                                    liveExplainPageAttr2.setShowAnimationFlag(liveExplainPageAttr2.getShowAnimationFlag() + 1);
                                }
                                if (liveExplainPage4.pageAttr.getCutoverAnimationFlag() == 1) {
                                    LiveExplainPageAttr liveExplainPageAttr3 = liveExplainPage4.pageAttr;
                                    ReadWriteProperty readWriteProperty = liveExplainPageAttr3.nextBubbleInfo$delegate;
                                    KProperty<?>[] kPropertyArr = LiveExplainPageAttr.$$delegatedProperties;
                                    liveExplainPageAttr3.bubbleInfo$delegate.setValue(liveExplainPageAttr3, kPropertyArr[4], (ExplainBubbleInfo) readWriteProperty.getValue(liveExplainPageAttr3, kPropertyArr[5]));
                                    LiveExplainPageAttr liveExplainPageAttr4 = liveExplainPage4.pageAttr;
                                    LiveExplainReportModel liveExplainReportModel = liveExplainPageAttr4.reportModel;
                                    if (liveExplainReportModel != null) {
                                        ExplainBubbleInfo bubbleInfo = liveExplainPageAttr4.getBubbleInfo();
                                        Intrinsics.checkNotNull(bubbleInfo);
                                        liveExplainReportModel.bubbleInfo = bubbleInfo;
                                    }
                                    LiveExplainPageAttr liveExplainPageAttr5 = liveExplainPage4.pageAttr;
                                    ExplainBubbleInfo bubbleInfo2 = liveExplainPageAttr5.getBubbleInfo();
                                    liveExplainPageAttr5.setHotSaleNum((bubbleInfo2 == null || (explainBubbleDetail = bubbleInfo2.detail) == null) ? 0 : explainBubbleDetail.salesCnt);
                                    LiveExplainPageAttr liveExplainPageAttr6 = liveExplainPage4.pageAttr;
                                    liveExplainPageAttr6.cutoverAnimationFlag$delegate.setValue(liveExplainPageAttr6, kPropertyArr[2], 0);
                                    liveExplainPage4.pageAttr.setShowAnimationFlag(0);
                                    liveExplainPage4.pageAttr.setShowAnimationFlag(1);
                                    k kVar2 = (k) liveExplainPage4.getModule("KRNotifyModule");
                                    if (kVar2 != null) {
                                        k.d(kVar2, "LiveExplainViewEventNotification", new e().t("type", 2), false, 4, null);
                                    }
                                    Utils.INSTANCE.bridgeModule(liveExplainPage4.getPagerId()).localServeTime(new LiveExplainPage$exposeReport$1(liveExplainPage4));
                                }
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final LiveExplainPage liveExplainPage3 = LiveExplainPage.this;
                Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.qqlive_biz.live_explain_page.LiveExplainPage$body$1.3
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Boolean.valueOf(LiveExplainPage.this.pageAttr.getHotSaleNum() > 8);
                    }
                };
                final LiveExplainPage liveExplainPage4 = LiveExplainPage.this;
                ConditionViewKt.c(viewContainer2, function0, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqlive_biz.live_explain_page.LiveExplainPage$body$1.4
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ConditionView conditionView) {
                        final LiveExplainPage liveExplainPage5 = LiveExplainPage.this;
                        conditionView.addChild(new LiveHotSaleView(), new Function1<LiveHotSaleView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqlive_biz.live_explain_page.LiveExplainPage.body.1.4.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(LiveHotSaleView liveHotSaleView) {
                                LiveHotSaleView liveHotSaleView2 = liveHotSaleView;
                                final LiveExplainPage liveExplainPage6 = LiveExplainPage.this;
                                liveHotSaleView2.ref(liveHotSaleView2, new Function1<aa<LiveHotSaleView>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqlive_biz.live_explain_page.LiveExplainPage.body.1.4.1.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(aa<LiveHotSaleView> aaVar) {
                                        LiveExplainPage.this.hotSaleViewRef = aaVar;
                                        return Unit.INSTANCE;
                                    }
                                });
                                final LiveExplainPage liveExplainPage7 = LiveExplainPage.this;
                                liveHotSaleView2.attr(new Function1<LiveHotSaleViewAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqlive_biz.live_explain_page.LiveExplainPage.body.1.4.1.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(LiveHotSaleViewAttr liveHotSaleViewAttr) {
                                        LiveHotSaleViewAttr liveHotSaleViewAttr2 = liveHotSaleViewAttr;
                                        liveHotSaleViewAttr2.marginBottom(4.0f);
                                        int hotSaleNum = LiveExplainPage.this.pageAttr.getHotSaleNum();
                                        ReadWriteProperty readWriteProperty = liveHotSaleViewAttr2.hotSaleNum$delegate;
                                        KProperty<?>[] kPropertyArr = LiveHotSaleViewAttr.$$delegatedProperties;
                                        readWriteProperty.setValue(liveHotSaleViewAttr2, kPropertyArr[2], Integer.valueOf(hotSaleNum));
                                        liveHotSaleViewAttr2.appearAnimated$delegate.setValue(liveHotSaleViewAttr2, kPropertyArr[1], Boolean.valueOf(LiveExplainPage.this.pageAttr.getHotSaleAppearAnimated()));
                                        return Unit.INSTANCE;
                                    }
                                });
                                final LiveExplainPage liveExplainPage8 = LiveExplainPage.this;
                                liveHotSaleView2.event(new Function1<HotSaleViewEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqlive_biz.live_explain_page.LiveExplainPage.body.1.4.1.3
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(HotSaleViewEvent hotSaleViewEvent) {
                                        final LiveExplainPage liveExplainPage9 = LiveExplainPage.this;
                                        hotSaleViewEvent.animationCompletion(new Function1<AnimationCompletionParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqlive_biz.live_explain_page.LiveExplainPage.body.1.4.1.3.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(AnimationCompletionParams animationCompletionParams) {
                                                LiveExplainPage liveExplainPage10 = LiveExplainPage.this;
                                                if (liveExplainPage10.pageAttr.getHotSaleAppearAnimated()) {
                                                    Utils.INSTANCE.logToNative("live_explain  hotSaleAppearAnimated");
                                                    aa<LiveHotSaleView> aaVar = liveExplainPage10.hotSaleViewRef;
                                                    LiveHotSaleView b16 = aaVar != null ? aaVar.b() : null;
                                                    if (b16 != null) {
                                                        b16.playIncreaseAnimation();
                                                    }
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
                final LiveExplainPage liveExplainPage5 = LiveExplainPage.this;
                Function0<Object> function02 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.qqlive_biz.live_explain_page.LiveExplainPage$body$1.5
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return LiveExplainPage.this.pageAttr.getBubbleInfo();
                    }
                };
                final LiveExplainPage liveExplainPage6 = LiveExplainPage.this;
                BindDirectivesViewKt.a(viewContainer2, function02, new Function1<BindDirectivesView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqlive_biz.live_explain_page.LiveExplainPage$body$1.6
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(BindDirectivesView bindDirectivesView) {
                        final LiveExplainPage liveExplainPage7 = LiveExplainPage.this;
                        bindDirectivesView.addChild(new LiveExplainBubbleView(), new Function1<LiveExplainBubbleView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqlive_biz.live_explain_page.LiveExplainPage.body.1.6.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(LiveExplainBubbleView liveExplainBubbleView) {
                                LiveExplainBubbleView liveExplainBubbleView2 = liveExplainBubbleView;
                                final LiveExplainPage liveExplainPage8 = LiveExplainPage.this;
                                liveExplainBubbleView2.ref(liveExplainBubbleView2, new Function1<aa<LiveExplainBubbleView>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqlive_biz.live_explain_page.LiveExplainPage.body.1.6.1.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(aa<LiveExplainBubbleView> aaVar) {
                                        LiveExplainPage.this.explainViewRef = aaVar;
                                        return Unit.INSTANCE;
                                    }
                                });
                                final LiveExplainPage liveExplainPage9 = LiveExplainPage.this;
                                liveExplainBubbleView2.attr(new Function1<ExplainBubbleViewAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqlive_biz.live_explain_page.LiveExplainPage.body.1.6.1.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ExplainBubbleViewAttr explainBubbleViewAttr) {
                                        ExplainBubbleViewAttr explainBubbleViewAttr2 = explainBubbleViewAttr;
                                        ExplainBubbleInfo bubbleInfo = LiveExplainPage.this.pageAttr.getBubbleInfo();
                                        ReadWriteProperty readWriteProperty = explainBubbleViewAttr2.bubbleInfo$delegate;
                                        KProperty<?>[] kPropertyArr = ExplainBubbleViewAttr.$$delegatedProperties;
                                        readWriteProperty.setValue(explainBubbleViewAttr2, kPropertyArr[1], bubbleInfo);
                                        LiveExplainPageAttr liveExplainPageAttr = LiveExplainPage.this.pageAttr;
                                        LiveExplainReportModel liveExplainReportModel = liveExplainPageAttr.reportModel;
                                        if (liveExplainReportModel != null) {
                                            EcommerceExtKt.vr(explainBubbleViewAttr2, "em_qqlive_small_window", liveExplainReportModel.vrBindParams(liveExplainPageAttr.getBubbleInfo()));
                                        }
                                        explainBubbleViewAttr2.isHRC$delegate.setValue(explainBubbleViewAttr2, kPropertyArr[4], 0);
                                        return Unit.INSTANCE;
                                    }
                                });
                                final LiveExplainPage liveExplainPage10 = LiveExplainPage.this;
                                liveExplainBubbleView2.event(new Function1<ExplainBubbleViewEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqlive_biz.live_explain_page.LiveExplainPage.body.1.6.1.3
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ExplainBubbleViewEvent explainBubbleViewEvent) {
                                        ExplainBubbleViewEvent explainBubbleViewEvent2 = explainBubbleViewEvent;
                                        final LiveExplainPage liveExplainPage11 = LiveExplainPage.this;
                                        explainBubbleViewEvent2.registerEvent("onClickCloseBtn", new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqlive_biz.live_explain_page.LiveExplainPage.body.1.6.1.3.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(Object obj) {
                                                LiveExplainPage liveExplainPage12 = LiveExplainPage.this;
                                                int i3 = LiveExplainPage.$r8$clinit;
                                                liveExplainPage12.closeExplainView();
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final LiveExplainPage liveExplainPage12 = LiveExplainPage.this;
                                        explainBubbleViewEvent2.registerEvent("onClickBubbleView", new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqlive_biz.live_explain_page.LiveExplainPage.body.1.6.1.3.2
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(Object obj) {
                                                LiveExplainPageAttr liveExplainPageAttr = LiveExplainPage.this.pageAttr;
                                                LiveExplainReportModel liveExplainReportModel = liveExplainPageAttr.reportModel;
                                                if (liveExplainReportModel != null) {
                                                    Utils.INSTANCE.bridgeModule(liveExplainReportModel.pagerId).localServeTime(new LiveExplainReportModel$reportExplainBubbleClicked$1(liveExplainPageAttr.enterRoomTime, liveExplainReportModel));
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

    public final void closeExplainView() {
        if (this.hasExplainViewShowing) {
            this.pageAttr.setCloseAnimationFlag(0);
            this.pageAttr.setCloseAnimationFlag(1);
            this.hasExplainViewShowing = false;
        }
        LiveExplainPageAttr liveExplainPageAttr = this.pageAttr;
        LiveExplainReportModel liveExplainReportModel = liveExplainPageAttr.reportModel;
        if (liveExplainReportModel != null) {
            liveExplainReportModel.reportExplainBubbleExpDuration(liveExplainPageAttr.explainViewExposeTime);
        }
    }

    @Override // com.tencent.kuikly.core.pager.Pager, com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return this.pageAttr;
    }

    @Override // com.tencent.kuikly.core.pager.Pager, com.tencent.kuikly.core.base.AbstractBaseView
    public final l createEvent() {
        return new l();
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.BasePager, com.tencent.kuikly.core.base.ComposeView
    public final void created() {
        super.created();
        Utils.INSTANCE.bridgeModule(getPagerId()).log("live_explain created");
    }

    @Override // com.tencent.kuikly.core.pager.c
    public final void onPagerEvent(String str, e eVar) {
        Utils utils = Utils.INSTANCE;
        utils.bridgeModule(getPagerId()).log("live_explain onPagerEvent " + str + TokenParser.SP + eVar);
        int hashCode = str.hashCode();
        boolean z16 = false;
        if (hashCode == -880547656) {
            if (str.equals("didExitRoom")) {
                utils.bridgeModule(getPagerId()).log("live_explain onDidExitRoom");
                closeExplainView();
                this.pageAttr.setHotSaleAppearAnimated(false);
                return;
            }
            return;
        }
        if (hashCode != 828294062) {
            if (hashCode == 872060813 && str.equals("pushMessage")) {
                int j3 = eVar.j("pushType");
                if (j3 == 1) {
                    requestExplainData(new Function1<ExplainBubbleInfo, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqlive_biz.live_explain_page.LiveExplainPage$handlePushMessage$1
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(ExplainBubbleInfo explainBubbleInfo) {
                            LiveExplainPage.this.pageAttr.setNextBubbleInfo(explainBubbleInfo);
                            return Unit.INSTANCE;
                        }
                    });
                    return;
                }
                if (j3 == 2) {
                    closeExplainView();
                    return;
                }
                if (j3 != 3) {
                    if (j3 == 4) {
                        requestExplainData(new Function1<ExplainBubbleInfo, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqlive_biz.live_explain_page.LiveExplainPage$handlePushMessage$2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ExplainBubbleInfo explainBubbleInfo) {
                                LiveExplainPage.this.pageAttr.setNextBubbleInfo(explainBubbleInfo);
                                return Unit.INSTANCE;
                            }
                        });
                        return;
                    }
                    if (j3 == 5) {
                        requestExplainData(new Function1<ExplainBubbleInfo, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqlive_biz.live_explain_page.LiveExplainPage$handlePushMessage$3
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ExplainBubbleInfo explainBubbleInfo) {
                                LiveExplainPage.this.pageAttr.setNextBubbleInfo(explainBubbleInfo);
                                return Unit.INSTANCE;
                            }
                        });
                        return;
                    }
                    if (j3 == 6) {
                        int j16 = new e(eVar.p("msgDataStr")).j("sales_cnt");
                        if (this.pageAttr.getHotSaleNum() < 9 && j16 >= 9) {
                            z16 = true;
                        }
                        this.pageAttr.setHotSaleNum(j16);
                        if (z16) {
                            TimerKt.d(100, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqlive_biz.live_explain_page.LiveExplainPage$goodsInfoChanged$1
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public final Unit invoke() {
                                    LiveExplainPage.this.pageAttr.setHotSaleAppearAnimated(true);
                                    return Unit.INSTANCE;
                                }
                            });
                            return;
                        }
                        aa<LiveHotSaleView> aaVar = this.hotSaleViewRef;
                        LiveHotSaleView b16 = aaVar != null ? aaVar.b() : null;
                        if (b16 != null) {
                            b16.playIncreaseAnimation();
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        if (str.equals("didEnterRoomAndShown")) {
            if (!this.hasExplainViewShowing) {
                requestExplainData(null);
            }
            utils.bridgeModule(getPagerId()).localServeTime(new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqlive_biz.live_explain_page.LiveExplainPage$onDidEnterRoom$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(e eVar2) {
                    e eVar3 = eVar2;
                    Intrinsics.checkNotNull(eVar3);
                    LiveExplainPage.this.pageAttr.enterRoomTime = (int) eVar3.h("time");
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.kuikly.core.pager.c
    public final void onRootViewSizeChanged(double d16, double d17) {
        c.a.a(this, d16, d17);
    }

    public final void requestExplainData(final Function1<? super ExplainBubbleInfo, Unit> function1) {
        final LiveExplainRequestModel liveExplainRequestModel = new LiveExplainRequestModel(getPagerId());
        int j3 = getPageData().n().j("roomID");
        String q16 = getPageData().n().q("qz_gdt", "");
        liveExplainRequestModel.roomId = j3;
        liveExplainRequestModel.gdtClickId = q16;
        liveExplainRequestModel.requestData(new Function3<e, Integer, String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqlive_biz.live_explain_page.LiveExplainPage$requestExplainData$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public final Unit invoke(e eVar, Integer num, String str) {
                ExplainBubbleDetail explainBubbleDetail;
                LiveExplainDataRspModel liveExplainDataRspModel;
                ExplainBubbleInfo explainBubbleInfo;
                ExplainBubbleDetail explainBubbleDetail2;
                ExplainBubbleInfo explainBubbleInfo2;
                ExplainBubbleDetail explainBubbleDetail3;
                num.intValue();
                LiveExplainDataRspModel liveExplainDataRspModel2 = LiveExplainRequestModel.this.rspModel;
                if ((liveExplainDataRspModel2 != null ? liveExplainDataRspModel2.bubbleInfo : null) != null) {
                    if (((liveExplainDataRspModel2 == null || (explainBubbleInfo2 = liveExplainDataRspModel2.bubbleInfo) == null || (explainBubbleDetail3 = explainBubbleInfo2.detail) == null) ? null : explainBubbleDetail3.title) != null) {
                        Utils utils = Utils.INSTANCE;
                        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("live_explain requestExplainData ");
                        LiveExplainDataRspModel liveExplainDataRspModel3 = LiveExplainRequestModel.this.rspModel;
                        Intrinsics.checkNotNull(liveExplainDataRspModel3);
                        ExplainBubbleInfo explainBubbleInfo3 = liveExplainDataRspModel3.bubbleInfo;
                        m3.append((explainBubbleInfo3 == null || (explainBubbleDetail2 = explainBubbleInfo3.detail) == null) ? null : explainBubbleDetail2.title);
                        utils.logToNative(m3.toString());
                        Function1<ExplainBubbleInfo, Unit> function12 = function1;
                        if (function12 != null && (liveExplainDataRspModel = LiveExplainRequestModel.this.rspModel) != null && (explainBubbleInfo = liveExplainDataRspModel.bubbleInfo) != null) {
                            function12.invoke(explainBubbleInfo);
                        }
                        LiveExplainPage liveExplainPage = this;
                        LiveExplainDataRspModel liveExplainDataRspModel4 = LiveExplainRequestModel.this.rspModel;
                        ExplainBubbleInfo explainBubbleInfo4 = liveExplainDataRspModel4 != null ? liveExplainDataRspModel4.bubbleInfo : null;
                        LiveExplainPageAttr liveExplainPageAttr = liveExplainPage.pageAttr;
                        if (liveExplainPageAttr.reportModel == null) {
                            liveExplainPageAttr.reportModel = new LiveExplainReportModel(liveExplainPage.getPagerId(), liveExplainPage.getPageData().n(), 0);
                        }
                        if (!liveExplainPage.hasExplainViewShowing) {
                            utils.bridgeModule(liveExplainPage.getPagerId()).log("live_explain first show explain view");
                            LiveExplainPageAttr liveExplainPageAttr2 = liveExplainPage.pageAttr;
                            liveExplainPageAttr2.bubbleInfo$delegate.setValue(liveExplainPageAttr2, LiveExplainPageAttr.$$delegatedProperties[4], explainBubbleInfo4);
                            LiveExplainPageAttr liveExplainPageAttr3 = liveExplainPage.pageAttr;
                            LiveExplainReportModel liveExplainReportModel = liveExplainPageAttr3.reportModel;
                            if (liveExplainReportModel != null) {
                                ExplainBubbleInfo bubbleInfo = liveExplainPageAttr3.getBubbleInfo();
                                Intrinsics.checkNotNull(bubbleInfo);
                                liveExplainReportModel.bubbleInfo = bubbleInfo;
                            }
                            LiveExplainPageAttr liveExplainPageAttr4 = liveExplainPage.pageAttr;
                            ExplainBubbleInfo bubbleInfo2 = liveExplainPageAttr4.getBubbleInfo();
                            liveExplainPageAttr4.setHotSaleNum((bubbleInfo2 == null || (explainBubbleDetail = bubbleInfo2.detail) == null) ? 0 : explainBubbleDetail.salesCnt);
                            liveExplainPage.pageAttr.setShowAnimationFlag(0);
                            liveExplainPage.pageAttr.setShowAnimationFlag(1);
                            liveExplainPage.hasExplainViewShowing = true;
                            e m16 = RoleCardKt$$ExternalSyntheticOutline0.m("type", 1);
                            m16.t("roomID", liveExplainPage.getPageData().n().j("roomID"));
                            k kVar = (k) liveExplainPage.getModule("KRNotifyModule");
                            if (kVar != null) {
                                k.d(kVar, "LiveExplainViewEventNotification", m16, false, 4, null);
                            }
                            utils.bridgeModule(liveExplainPage.getPagerId()).localServeTime(new LiveExplainPage$exposeReport$1(liveExplainPage));
                        } else {
                            utils.bridgeModule(liveExplainPage.getPagerId()).log("live_explain explain view cutover");
                            LiveExplainPageAttr liveExplainPageAttr5 = liveExplainPage.pageAttr;
                            LiveExplainReportModel liveExplainReportModel2 = liveExplainPageAttr5.reportModel;
                            if (liveExplainReportModel2 != null) {
                                liveExplainReportModel2.reportExplainBubbleExpDuration(liveExplainPageAttr5.explainViewExposeTime);
                            }
                            LiveExplainPageAttr liveExplainPageAttr6 = liveExplainPage.pageAttr;
                            liveExplainPageAttr6.cutoverAnimationFlag$delegate.setValue(liveExplainPageAttr6, LiveExplainPageAttr.$$delegatedProperties[2], 1);
                            liveExplainPage.pageAttr.setHotSaleAppearAnimated(false);
                        }
                    }
                }
                return Unit.INSTANCE;
            }
        });
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final void viewDidLoad() {
        super.viewDidLoad();
        addPagerEventObserver(this);
    }

    @Override // com.tencent.kuikly.core.pager.Pager, com.tencent.kuikly.core.base.AbstractBaseView
    public final com.tencent.kuikly.core.base.k createAttr() {
        return this.pageAttr;
    }

    @Override // com.tencent.kuikly.core.pager.Pager, com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new l();
    }
}
