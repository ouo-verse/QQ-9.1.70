package com.tencent.hippykotlin.demo.pages.qqlive_biz.live_explain_page.view;

import c01.c;
import com.tencent.ditto.shell.LayoutAttrDefine;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.BridgeModule;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.qqlive_biz.live_explain_page.model.ExplainActivePicInfo;
import com.tencent.hippykotlin.demo.pages.qqlive_biz.live_explain_page.model.ExplainActiveStock;
import com.tencent.hippykotlin.demo.pages.qqlive_biz.live_explain_page.model.ExplainActivity;
import com.tencent.hippykotlin.demo.pages.qqlive_biz.live_explain_page.model.ExplainActivityPrice;
import com.tencent.hippykotlin.demo.pages.qqlive_biz.live_explain_page.model.ExplainBubbleDetail;
import com.tencent.hippykotlin.demo.pages.qqlive_biz.live_explain_page.model.ExplainBubbleInfo;
import com.tencent.hippykotlin.demo.pages.qqlive_biz.live_explain_page.model.ExplainCommonShowStyle;
import com.tencent.hippykotlin.demo.pages.qqlive_biz.live_explain_page.model.ExplainHotLabel;
import com.tencent.hippykotlin.demo.pages.qqlive_biz.live_explain_page.model.ExplainLiveCouponInfo;
import com.tencent.hippykotlin.demo.pages.qqlive_biz.live_explain_page.model.ExplainLiveShowItem;
import com.tencent.hippykotlin.demo.pages.qqlive_biz.live_explain_page.model.ExplainPrice;
import com.tencent.hippykotlin.demo.pages.qqlive_biz.live_explain_page.model.ExplainTimeRange;
import com.tencent.hippykotlin.demo.pages.qqlive_biz.live_explain_page.model.ExplainUIStyle;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.aa;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
import com.tencent.kuikly.core.global.GlobalFunctions;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.timer.TimerKt;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ah;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.u;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class LiveExplainBubbleView extends ComposeView<ExplainBubbleViewAttr, ExplainBubbleViewEvent> {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(LiveExplainBubbleView.class, "leftTimeInfo", "getLeftTimeInfo()Ljava/lang/String;", 0)};
    public aa<LiveExplainBuyBtn> buyBtnRef;
    public Integer diffTime;
    public final ExplainBubbleViewAttr bubbleAttr = new ExplainBubbleViewAttr();
    public final ReadWriteProperty leftTimeInfo$delegate = c.a("");
    public String timeCallbackRef = "";

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ ExplainBubbleViewAttr access$getAttr(LiveExplainBubbleView liveExplainBubbleView) {
        return (ExplainBubbleViewAttr) liveExplainBubbleView.getAttr();
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x006c, code lost:
    
        if (r6 != null) goto L41;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final boolean access$hasDiscountActivity(LiveExplainBubbleView liveExplainBubbleView) {
        ExplainLiveShowItem explainLiveShowItem;
        String str;
        String str2;
        Object first;
        ExplainCommonShowStyle explainCommonShowStyle;
        ExplainLiveShowItem explainLiveShowItem2;
        ExplainCommonShowStyle explainCommonShowStyle2;
        ExplainLiveShowItem explainLiveShowItem3;
        ExplainCommonShowStyle explainCommonShowStyle3;
        ExplainBubbleInfo bubbleInfo = ((ExplainBubbleViewAttr) liveExplainBubbleView.getAttr()).getBubbleInfo();
        if (bubbleInfo == null || (explainCommonShowStyle3 = bubbleInfo.liveCommonStyleInfos) == null || (explainLiveShowItem = explainCommonShowStyle3.normalStyleInfo) == null) {
            explainLiveShowItem = null;
        }
        ExplainBubbleInfo bubbleInfo2 = ((ExplainBubbleViewAttr) liveExplainBubbleView.getAttr()).getBubbleInfo();
        if (bubbleInfo2 != null && (explainCommonShowStyle2 = bubbleInfo2.liveCommonStyleInfos) != null && (explainLiveShowItem3 = explainCommonShowStyle2.couponStyleInfo) != null) {
            explainLiveShowItem = explainLiveShowItem3;
        }
        ExplainBubbleInfo bubbleInfo3 = ((ExplainBubbleViewAttr) liveExplainBubbleView.getAttr()).getBubbleInfo();
        if (bubbleInfo3 != null && (explainCommonShowStyle = bubbleInfo3.liveCommonStyleInfos) != null && (explainLiveShowItem2 = explainCommonShowStyle.liveActiveStyleInfo) != null) {
            explainLiveShowItem = explainLiveShowItem2;
        }
        if (explainLiveShowItem != null) {
            ArrayList<ExplainHotLabel> arrayList = explainLiveShowItem.hotLabels;
            String str3 = "";
            if (arrayList != null && (arrayList.isEmpty() ^ true)) {
                ExplainBubbleViewAttr explainBubbleViewAttr = (ExplainBubbleViewAttr) liveExplainBubbleView.getAttr();
                ArrayList<ExplainHotLabel> arrayList2 = explainLiveShowItem.hotLabels;
                if (arrayList2 != null) {
                    first = CollectionsKt___CollectionsKt.first((List<? extends Object>) arrayList2);
                    ExplainHotLabel explainHotLabel = (ExplainHotLabel) first;
                    if (explainHotLabel != null) {
                        str2 = explainHotLabel.text;
                    }
                }
                str2 = "";
                explainBubbleViewAttr.buyBtnActivityTxt$delegate.setValue(explainBubbleViewAttr, ExplainBubbleViewAttr.$$delegatedProperties[3], str2);
            }
            ExplainBubbleViewAttr explainBubbleViewAttr2 = (ExplainBubbleViewAttr) liveExplainBubbleView.getAttr();
            ExplainActivePicInfo explainActivePicInfo = explainLiveShowItem.mainCover;
            if (explainActivePicInfo != null && (str = explainActivePicInfo.url) != null) {
                str3 = str;
            }
            explainBubbleViewAttr2.activityMaskURL$delegate.setValue(explainBubbleViewAttr2, ExplainBubbleViewAttr.$$delegatedProperties[2], str3);
        }
        ExplainBubbleViewAttr explainBubbleViewAttr3 = (ExplainBubbleViewAttr) liveExplainBubbleView.getAttr();
        return ((String) explainBubbleViewAttr3.buyBtnActivityTxt$delegate.getValue(explainBubbleViewAttr3, ExplainBubbleViewAttr.$$delegatedProperties[3])).length() > 0;
    }

    public static final boolean access$isActivityGoods(LiveExplainBubbleView liveExplainBubbleView) {
        ExplainActivity explainActivity;
        ExplainActivity explainActivity2;
        ExplainBubbleInfo bubbleInfo = liveExplainBubbleView.bubbleAttr.getBubbleInfo();
        if ((bubbleInfo != null ? bubbleInfo.activity : null) == null) {
            return false;
        }
        ExplainBubbleInfo bubbleInfo2 = liveExplainBubbleView.bubbleAttr.getBubbleInfo();
        if ((bubbleInfo2 == null || (explainActivity2 = bubbleInfo2.activity) == null || explainActivity2.status != 3) ? false : true) {
            return false;
        }
        ExplainBubbleInfo bubbleInfo3 = liveExplainBubbleView.bubbleAttr.getBubbleInfo();
        return !(bubbleInfo3 != null && (explainActivity = bubbleInfo3.activity) != null && explainActivity.status == 4);
    }

    public static final boolean access$isSoldOut(LiveExplainBubbleView liveExplainBubbleView) {
        ExplainBubbleDetail explainBubbleDetail;
        ExplainActivity explainActivity;
        ExplainActiveStock explainActiveStock;
        ExplainActivity explainActivity2;
        ExplainActiveStock explainActiveStock2;
        ExplainBubbleInfo bubbleInfo = liveExplainBubbleView.bubbleAttr.getBubbleInfo();
        if ((bubbleInfo != null ? bubbleInfo.activity : null) != null) {
            ExplainBubbleInfo bubbleInfo2 = liveExplainBubbleView.bubbleAttr.getBubbleInfo();
            if ((bubbleInfo2 == null || (explainActivity2 = bubbleInfo2.activity) == null || (explainActiveStock2 = explainActivity2.stock) == null || explainActiveStock2.total != 0) ? false : true) {
                return true;
            }
            ExplainBubbleInfo bubbleInfo3 = liveExplainBubbleView.bubbleAttr.getBubbleInfo();
            if ((bubbleInfo3 == null || (explainActivity = bubbleInfo3.activity) == null || (explainActiveStock = explainActivity.stock) == null || explainActiveStock.remain != 0) ? false : true) {
                return true;
            }
        } else {
            ExplainBubbleInfo bubbleInfo4 = liveExplainBubbleView.bubbleAttr.getBubbleInfo();
            if ((bubbleInfo4 == null || (explainBubbleDetail = bubbleInfo4.detail) == null || explainBubbleDetail.inventory != 0) ? false : true) {
                return true;
            }
        }
        return false;
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqlive_biz.live_explain_page.view.LiveExplainBubbleView$body$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                final LiveExplainBubbleView liveExplainBubbleView = LiveExplainBubbleView.this;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqlive_biz.live_explain_page.view.LiveExplainBubbleView$body$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        mVar2.size(120.0f, LiveExplainBubbleView.access$hasDiscountActivity(LiveExplainBubbleView.this) ? 202.0f : 192.0f);
                        mVar2.mo113backgroundColor(h.INSTANCE.m());
                        mVar2.borderRadius(4.0f);
                        return Unit.INSTANCE;
                    }
                });
                final LiveExplainBubbleView liveExplainBubbleView2 = LiveExplainBubbleView.this;
                viewContainer2.event(new Function1<Event, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqlive_biz.live_explain_page.view.LiveExplainBubbleView$body$1.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Event event) {
                        final LiveExplainBubbleView liveExplainBubbleView3 = LiveExplainBubbleView.this;
                        event.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqlive_biz.live_explain_page.view.LiveExplainBubbleView.body.1.2.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ClickParams clickParams) {
                                String str;
                                LiveExplainBubbleView liveExplainBubbleView4 = LiveExplainBubbleView.this;
                                KProperty<Object>[] kPropertyArr = LiveExplainBubbleView.$$delegatedProperties;
                                liveExplainBubbleView4.getClass();
                                e eVar = new e();
                                if (!liveExplainBubbleView4.getPagerData().getIsIOS()) {
                                    eVar.v("half", "1");
                                    eVar.v("is_from_live", "1");
                                    eVar.t(LayoutAttrDefine.MARGIN_TOP, 224);
                                } else {
                                    eVar.t("half", 1);
                                    eVar.v("bg_mask_alpha", Float.valueOf(0.0f));
                                    eVar.t(LayoutAttrDefine.MARGIN_TOP, 168);
                                }
                                Utils utils = Utils.INSTANCE;
                                BridgeModule bridgeModule = utils.bridgeModule(liveExplainBubbleView4.getPagerId());
                                ExplainBubbleInfo bubbleInfo = liveExplainBubbleView4.bubbleAttr.getBubbleInfo();
                                if (bubbleInfo == null || (str = bubbleInfo.detailUrl) == null) {
                                    str = "";
                                }
                                BridgeModule.openPage$default(bridgeModule, str, false, eVar, null, 24);
                                liveExplainBubbleView4.emit("onClickBubbleView", null);
                                e eVar2 = new e();
                                eVar2.v("live_room_id", String.valueOf(liveExplainBubbleView4.getPagerData().n().j("roomID")));
                                utils.currentBridgeModule().ssoRequest("trpc.ecom.qqlive_product_dynamic_svr.QqliveProductDynamicSvr/RecordBuyingPeople", eVar2, false, new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqlive_biz.live_explain_page.view.LiveExplainBubbleView$requestRecordBuying$1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(e eVar3) {
                                        Utils.INSTANCE.logToNative("live_explain requestRecordBuying " + eVar3);
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final LiveExplainBubbleView liveExplainBubbleView3 = LiveExplainBubbleView.this;
                final LiveExplainBubbleView liveExplainBubbleView4 = this;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqlive_biz.live_explain_page.view.LiveExplainBubbleView$body$1.3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqlive_biz.live_explain_page.view.LiveExplainBubbleView.body.1.3.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.marginTop(2.0f).marginLeft(2.0f).marginRight(2.0f);
                                tVar2.mo141height(116.0f).borderRadius(4.0f);
                                return Unit.INSTANCE;
                            }
                        });
                        final LiveExplainBubbleView liveExplainBubbleView5 = LiveExplainBubbleView.this;
                        ah.a(vVar2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqlive_biz.live_explain_page.view.LiveExplainBubbleView.body.1.3.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ImageView imageView) {
                                final LiveExplainBubbleView liveExplainBubbleView6 = LiveExplainBubbleView.this;
                                imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqlive_biz.live_explain_page.view.LiveExplainBubbleView.body.1.3.2.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(af afVar) {
                                        String str;
                                        ExplainBubbleDetail explainBubbleDetail;
                                        af afVar2 = afVar;
                                        afVar2.size(116.0f, 116.0f);
                                        ExplainBubbleInfo bubbleInfo = LiveExplainBubbleView.this.bubbleAttr.getBubbleInfo();
                                        if (bubbleInfo == null || (explainBubbleDetail = bubbleInfo.detail) == null || (str = explainBubbleDetail.cover) == null) {
                                            str = "";
                                        }
                                        b.a.b(afVar2, str, false, 2, null);
                                        afVar2.mo113backgroundColor(new h(4294111986L));
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final LiveExplainBubbleView liveExplainBubbleView6 = LiveExplainBubbleView.this;
                        Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.qqlive_biz.live_explain_page.view.LiveExplainBubbleView.body.1.3.3
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                ExplainBubbleViewAttr access$getAttr = LiveExplainBubbleView.access$getAttr(LiveExplainBubbleView.this);
                                return Boolean.valueOf(((String) access$getAttr.activityMaskURL$delegate.getValue(access$getAttr, ExplainBubbleViewAttr.$$delegatedProperties[2])).length() > 0);
                            }
                        };
                        final LiveExplainBubbleView liveExplainBubbleView7 = LiveExplainBubbleView.this;
                        ConditionViewKt.c(vVar2, function0, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqlive_biz.live_explain_page.view.LiveExplainBubbleView.body.1.3.4
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ConditionView conditionView) {
                                final LiveExplainBubbleView liveExplainBubbleView8 = LiveExplainBubbleView.this;
                                ah.a(conditionView, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqlive_biz.live_explain_page.view.LiveExplainBubbleView.body.1.3.4.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ImageView imageView) {
                                        final LiveExplainBubbleView liveExplainBubbleView9 = LiveExplainBubbleView.this;
                                        imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqlive_biz.live_explain_page.view.LiveExplainBubbleView.body.1.3.4.1.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(af afVar) {
                                                af afVar2 = afVar;
                                                afVar2.size(116.0f, 116.0f);
                                                afVar2.absolutePosition(0.0f, 0.0f, 0.0f, 0.0f);
                                                ExplainBubbleViewAttr access$getAttr = LiveExplainBubbleView.access$getAttr(LiveExplainBubbleView.this);
                                                b.a.b(afVar2, (String) access$getAttr.activityMaskURL$delegate.getValue(access$getAttr, ExplainBubbleViewAttr.$$delegatedProperties[2]), false, 2, null);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final LiveExplainBubbleView liveExplainBubbleView8 = LiveExplainBubbleView.this;
                        ConditionViewKt.c(vVar2, new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.qqlive_biz.live_explain_page.view.LiveExplainBubbleView.body.1.3.5
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Boolean.valueOf(LiveExplainBubbleView.access$isSoldOut(LiveExplainBubbleView.this));
                            }
                        }, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqlive_biz.live_explain_page.view.LiveExplainBubbleView.body.1.3.6
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ConditionView conditionView) {
                                w.a(conditionView, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqlive_biz.live_explain_page.view.LiveExplainBubbleView.body.1.3.6.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar3) {
                                        v vVar4 = vVar3;
                                        vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqlive_biz.live_explain_page.view.LiveExplainBubbleView.body.1.3.6.1.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                t tVar2 = tVar;
                                                tVar2.absolutePosition(0.0f, 0.0f, 0.0f, 0.0f);
                                                tVar2.mo113backgroundColor(new h(2150575919L));
                                                tVar2.borderRadius(4.0f);
                                                tVar2.allCenter();
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqlive_biz.live_explain_page.view.LiveExplainBubbleView.body.1.3.6.1.2
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(TextView textView) {
                                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqlive_biz.live_explain_page.view.LiveExplainBubbleView.body.1.3.6.1.2.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ce ceVar) {
                                                        ce ceVar2 = ceVar;
                                                        ce.fontSize$default(ceVar2, 14.0f, null, 2, null).fontWeightMedium().color(h.INSTANCE.m());
                                                        ceVar2.value("\u5df2\u552e\u7f44");
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
                        final LiveExplainBubbleView liveExplainBubbleView9 = LiveExplainBubbleView.this;
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqlive_biz.live_explain_page.view.LiveExplainBubbleView.body.1.3.7
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                v vVar4 = vVar3;
                                vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqlive_biz.live_explain_page.view.LiveExplainBubbleView.body.1.3.7.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        tVar.positionAbsolute().m150top(0.0f).m149right(0.0f).size(20.0f, 20.0f);
                                        return Unit.INSTANCE;
                                    }
                                });
                                final LiveExplainBubbleView liveExplainBubbleView10 = LiveExplainBubbleView.this;
                                vVar4.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqlive_biz.live_explain_page.view.LiveExplainBubbleView.body.1.3.7.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(u uVar) {
                                        final LiveExplainBubbleView liveExplainBubbleView11 = LiveExplainBubbleView.this;
                                        uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqlive_biz.live_explain_page.view.LiveExplainBubbleView.body.1.3.7.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ClickParams clickParams) {
                                                LiveExplainBubbleView liveExplainBubbleView12 = LiveExplainBubbleView.this;
                                                KProperty<Object>[] kPropertyArr = LiveExplainBubbleView.$$delegatedProperties;
                                                liveExplainBubbleView12.emit("onClickCloseBtn", null);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                ah.a(vVar4, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqlive_biz.live_explain_page.view.LiveExplainBubbleView.body.1.3.7.3
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ImageView imageView) {
                                        imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqlive_biz.live_explain_page.view.LiveExplainBubbleView.body.1.3.7.3.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(af afVar) {
                                                af afVar2 = afVar;
                                                afVar2.marginTop(3.0f).marginLeft(3.0f).size(14.0f, 14.0f);
                                                b.a.b(afVar2, "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABwAAAAdCAYAAAC5UQwxAAAACXBIWXMAABYlAAAWJQFJUiTwAAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAAOwSURBVHgB7VZNSxthEN6PZLOb1Ghi0hgVE21KatISW1tKC9XYU3vyor9B8Cae/ULUowhexZv4BwRPevCgBxHEixepGu3BkzeTNB+dZzOvXdOYzaFQKB0Y3v2YmeedeeeZXUn6L/+yyNByuSzz9aNCNqbKJKVSqa69Ug0yOzuLZ8rt7W03FEEeC8BApomiKPLi4qKcy+VMP8TAO9jUzWp0dFS9ubmJ0U7PoWdnZ8/T6bSDNycyfuCDd5qmOU9PT+Ps9y2TycQQS7KpDgyc+/v7vcVi8YKClxHg8PDwRX9/v5Od7wMgtZGRERVgJycnvbCFD/maPogl/V7FBzsFoE7avLm5+aZQKFxaQem5Jkol7J1Op3ZwcJAQGySfi42Njdf0zhuLxVwNA5K2raysfMzn8xkBiswZVBVge3t7SQFGtpfLy8sfPB5PGwBJBWDtsnLDwMhLTiFaI9QIn6gRrrhUFwyqRyIRwwpGNpn5+fkBXde76P1T0iZREamOyFx3N6nfMIwOWrsXFhYGraBbW1uvtre3U1awubm5Qdi63e52Wn2khuXcawufjcqGT0hbCbST1h4EFKA4W3G+AMOGKDMB5if1YOMzMzOKZNOlIkuVywHQAGmny+V6Nj09PZTNZq/LLHR9NTU1NYQNkaIarQIMMWpxsFZ9YVUiDhVpzZPmsFImRZCb5D6K5brAdlnSH9QL8C1WZkbjIjNxDQLyoWNFSe/u7q5Jv4uSrq6uvie7FlJXI2R/mF6lDDKPNIeqqgYaRJwZyjg2NjY8Pj4+LEDBPTQSeAfAGtOoLqBJajovJZVKadWtPzEx8YX410f76ZucnPxq6V4rT5WGAcnRnI0U1HV0dJSwgqFBqHniULKJE2icuPdZgGKGAjSRSJig5oHXy5bLaGZWDcY8Qzd2MVU6QHJy6SHQtDVTjMFkMqnZ0gIG4CAcapFaqrQ+aOJjDZJ2Emj1cDg/Pj5GFRx252mOtt3d3ZdoBMxGHldRkNrr9fpDoRB4hnmrB4PBe54CdGlpaQCzF4A7OztJye48uaX1FpL19fV3GMR0HyGwMMCkCqlFEHwjNQtoO5U6Avqsra29pftm/lqo9TK0fi1QLkx9DHFfOBx288gz2x6/Euhk6ddE8vPAb+MNNDUCKAJgeOPz0hwIBDD1DTznr4lVrGMQPk1+v98L5XvN7gytAVycrcblq3kW6Gw+CgfoEI1GdajE81SymzrYEQcQKv5lJJuNmj9fFl/F7g/uT4lctf5d+Qls3FrO7pE37AAAAABJRU5ErkJggg==", false, 2, null);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final LiveExplainBubbleView liveExplainBubbleView10 = LiveExplainBubbleView.this;
                        Function0<Object> function02 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.qqlive_biz.live_explain_page.view.LiveExplainBubbleView.body.1.3.8
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                ExplainBubbleInfo bubbleInfo = LiveExplainBubbleView.this.bubbleAttr.getBubbleInfo();
                                return Boolean.valueOf(bubbleInfo != null && bubbleInfo.type == 2);
                            }
                        };
                        final LiveExplainBubbleView liveExplainBubbleView11 = LiveExplainBubbleView.this;
                        ConditionViewKt.c(vVar2, function02, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqlive_biz.live_explain_page.view.LiveExplainBubbleView.body.1.3.9
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ConditionView conditionView) {
                                final LiveExplainBubbleView liveExplainBubbleView12 = LiveExplainBubbleView.this;
                                w.a(conditionView, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqlive_biz.live_explain_page.view.LiveExplainBubbleView.body.1.3.9.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar3) {
                                        v vVar4 = vVar3;
                                        vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqlive_biz.live_explain_page.view.LiveExplainBubbleView.body.1.3.9.1.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                t tVar2 = tVar;
                                                tVar2.size(58.0f, 16.0f).borderRadius(2.0f).mo113backgroundColor(new h(4294934824L));
                                                Attr.absolutePosition$default(tVar2, 2.0f, 2.0f, 0.0f, 0.0f, 12, null);
                                                tVar2.allCenter();
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final LiveExplainBubbleView liveExplainBubbleView13 = LiveExplainBubbleView.this;
                                        cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqlive_biz.live_explain_page.view.LiveExplainBubbleView.body.1.3.9.1.2
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(TextView textView) {
                                                final LiveExplainBubbleView liveExplainBubbleView14 = LiveExplainBubbleView.this;
                                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqlive_biz.live_explain_page.view.LiveExplainBubbleView.body.1.3.9.1.2.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ce ceVar) {
                                                        String str;
                                                        ExplainBubbleDetail explainBubbleDetail;
                                                        ExplainUIStyle explainUIStyle;
                                                        ce ceVar2 = ceVar;
                                                        ce.fontSize$default(ceVar2, 10.0f, null, 2, null).color(h.INSTANCE.m()).lines(1).textOverFlowTail();
                                                        ExplainBubbleInfo bubbleInfo = LiveExplainBubbleView.this.bubbleAttr.getBubbleInfo();
                                                        if (bubbleInfo == null || (explainBubbleDetail = bubbleInfo.detail) == null || (explainUIStyle = explainBubbleDetail.uiStyle) == null || (str = explainUIStyle.uiTitle) == null) {
                                                            str = "\u5b98\u65b9\u70ed\u63a8\u4e2d";
                                                        }
                                                        ceVar2.value(str);
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
                        final LiveExplainBubbleView liveExplainBubbleView12 = LiveExplainBubbleView.this;
                        final LiveExplainBubbleView liveExplainBubbleView13 = liveExplainBubbleView4;
                        ConditionViewKt.a(vVar2, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqlive_biz.live_explain_page.view.LiveExplainBubbleView.body.1.3.10
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ConditionView conditionView) {
                                final LiveExplainBubbleView liveExplainBubbleView14 = LiveExplainBubbleView.this;
                                final LiveExplainBubbleView liveExplainBubbleView15 = liveExplainBubbleView13;
                                conditionView.addChild(new LiveExplainBanner(), new Function1<LiveExplainBanner, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqlive_biz.live_explain_page.view.LiveExplainBubbleView.body.1.3.10.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(LiveExplainBanner liveExplainBanner) {
                                        final LiveExplainBubbleView liveExplainBubbleView16 = LiveExplainBubbleView.this;
                                        final LiveExplainBubbleView liveExplainBubbleView17 = liveExplainBubbleView15;
                                        liveExplainBanner.attr(new Function1<LiveExplainBannerAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqlive_biz.live_explain_page.view.LiveExplainBubbleView.body.1.3.10.1.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(LiveExplainBannerAttr liveExplainBannerAttr) {
                                                ExplainState explainState;
                                                LiveExplainBannerAttr liveExplainBannerAttr2 = liveExplainBannerAttr;
                                                Attr.absolutePosition$default(liveExplainBannerAttr2, 0.0f, 0.0f, 0.0f, 0.0f, 12, null);
                                                if (!LiveExplainBubbleView.access$isActivityGoods(LiveExplainBubbleView.this)) {
                                                    explainState = ExplainState.EXPLAINING;
                                                } else {
                                                    ExplainBubbleViewAttr explainBubbleViewAttr = LiveExplainBubbleView.this.bubbleAttr;
                                                    explainState = (ExplainState) explainBubbleViewAttr.state$delegate.getValue(explainBubbleViewAttr, ExplainBubbleViewAttr.$$delegatedProperties[0]);
                                                }
                                                ReadWriteProperty readWriteProperty = liveExplainBannerAttr2.state$delegate;
                                                KProperty<?>[] kPropertyArr = LiveExplainBannerAttr.$$delegatedProperties;
                                                readWriteProperty.setValue(liveExplainBannerAttr2, kPropertyArr[0], explainState);
                                                LiveExplainBubbleView liveExplainBubbleView18 = liveExplainBubbleView17;
                                                liveExplainBannerAttr2.leftTimeInfo$delegate.setValue(liveExplainBannerAttr2, kPropertyArr[1], (String) liveExplainBubbleView18.leftTimeInfo$delegate.getValue(liveExplainBubbleView18, LiveExplainBubbleView.$$delegatedProperties[0]));
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
                final LiveExplainBubbleView liveExplainBubbleView5 = LiveExplainBubbleView.this;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqlive_biz.live_explain_page.view.LiveExplainBubbleView$body$1.4
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqlive_biz.live_explain_page.view.LiveExplainBubbleView.body.1.4.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                tVar.marginLeft(4.0f).marginRight(4.0f).marginTop(6.0f).mo141height(34.0f);
                                return Unit.INSTANCE;
                            }
                        });
                        final LiveExplainBubbleView liveExplainBubbleView6 = LiveExplainBubbleView.this;
                        cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqlive_biz.live_explain_page.view.LiveExplainBubbleView.body.1.4.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(TextView textView) {
                                final LiveExplainBubbleView liveExplainBubbleView7 = LiveExplainBubbleView.this;
                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqlive_biz.live_explain_page.view.LiveExplainBubbleView.body.1.4.2.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ce ceVar) {
                                        String str;
                                        ExplainBubbleDetail explainBubbleDetail;
                                        ExplainBubbleDetail explainBubbleDetail2;
                                        String str2;
                                        ce ceVar2 = ceVar;
                                        ceVar2.marginLeft(0.0f).marginRight(0.0f);
                                        Integer num = null;
                                        ce fontSize$default = ce.fontSize$default(ceVar2, 12.0f, null, 2, null);
                                        ExplainBubbleInfo bubbleInfo = LiveExplainBubbleView.this.bubbleAttr.getBubbleInfo();
                                        if (bubbleInfo != null && (explainBubbleDetail2 = bubbleInfo.detail) != null && (str2 = explainBubbleDetail2.adTxt) != null) {
                                            num = Integer.valueOf(str2.length());
                                        }
                                        Intrinsics.checkNotNull(num);
                                        fontSize$default.lines(num.intValue() > 0 ? 1 : 2).textOverFlowTail();
                                        ExplainBubbleInfo bubbleInfo2 = LiveExplainBubbleView.this.bubbleAttr.getBubbleInfo();
                                        if (bubbleInfo2 == null || (explainBubbleDetail = bubbleInfo2.detail) == null || (str = explainBubbleDetail.title) == null) {
                                            str = "";
                                        }
                                        ceVar2.value(str);
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final LiveExplainBubbleView liveExplainBubbleView7 = LiveExplainBubbleView.this;
                        Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.qqlive_biz.live_explain_page.view.LiveExplainBubbleView.body.1.4.3
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                ExplainBubbleDetail explainBubbleDetail;
                                String str;
                                ExplainBubbleInfo bubbleInfo = LiveExplainBubbleView.this.bubbleAttr.getBubbleInfo();
                                Integer valueOf = (bubbleInfo == null || (explainBubbleDetail = bubbleInfo.detail) == null || (str = explainBubbleDetail.adTxt) == null) ? null : Integer.valueOf(str.length());
                                Intrinsics.checkNotNull(valueOf);
                                return Boolean.valueOf(valueOf.intValue() > 0);
                            }
                        };
                        final LiveExplainBubbleView liveExplainBubbleView8 = LiveExplainBubbleView.this;
                        ConditionViewKt.c(vVar2, function0, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqlive_biz.live_explain_page.view.LiveExplainBubbleView.body.1.4.4
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ConditionView conditionView) {
                                final LiveExplainBubbleView liveExplainBubbleView9 = LiveExplainBubbleView.this;
                                cg.a(conditionView, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqlive_biz.live_explain_page.view.LiveExplainBubbleView.body.1.4.4.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(TextView textView) {
                                        final LiveExplainBubbleView liveExplainBubbleView10 = LiveExplainBubbleView.this;
                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqlive_biz.live_explain_page.view.LiveExplainBubbleView.body.1.4.4.1.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ce ceVar) {
                                                String str;
                                                ExplainBubbleDetail explainBubbleDetail;
                                                ce ceVar2 = ceVar;
                                                ceVar2.marginLeft(0.0f).marginRight(0.0f).marginTop(2.0f);
                                                ce.fontSize$default(ceVar2, 12.0f, null, 2, null).color(4294922790L).lines(1).textOverFlowTail();
                                                ExplainBubbleInfo bubbleInfo = LiveExplainBubbleView.this.bubbleAttr.getBubbleInfo();
                                                if (bubbleInfo == null || (explainBubbleDetail = bubbleInfo.detail) == null || (str = explainBubbleDetail.adTxt) == null) {
                                                    str = "";
                                                }
                                                ceVar2.value(str);
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
                final LiveExplainBubbleView liveExplainBubbleView6 = LiveExplainBubbleView.this;
                viewContainer2.addChild(new LiveExplainBuyBtn(), new Function1<LiveExplainBuyBtn, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqlive_biz.live_explain_page.view.LiveExplainBubbleView$body$1.5
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(LiveExplainBuyBtn liveExplainBuyBtn) {
                        LiveExplainBuyBtn liveExplainBuyBtn2 = liveExplainBuyBtn;
                        final LiveExplainBubbleView liveExplainBubbleView7 = LiveExplainBubbleView.this;
                        liveExplainBuyBtn2.ref(liveExplainBuyBtn2, new Function1<aa<LiveExplainBuyBtn>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqlive_biz.live_explain_page.view.LiveExplainBubbleView.body.1.5.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(aa<LiveExplainBuyBtn> aaVar) {
                                LiveExplainBubbleView.this.buyBtnRef = aaVar;
                                return Unit.INSTANCE;
                            }
                        });
                        final LiveExplainBubbleView liveExplainBubbleView8 = LiveExplainBubbleView.this;
                        liveExplainBuyBtn2.attr(new Function1<LiveExplainBuyBtnAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqlive_biz.live_explain_page.view.LiveExplainBubbleView.body.1.5.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(LiveExplainBuyBtnAttr liveExplainBuyBtnAttr) {
                                String str;
                                ExplainPrice explainPrice;
                                String str2;
                                ExplainPrice explainPrice2;
                                ExplainActivityPrice explainActivityPrice;
                                ExplainPrice explainPrice3;
                                String str3;
                                ExplainPrice explainPrice4;
                                LiveExplainBuyBtnAttr liveExplainBuyBtnAttr2 = liveExplainBuyBtnAttr;
                                liveExplainBuyBtnAttr2.mo141height(LiveExplainBubbleView.access$hasDiscountActivity(LiveExplainBubbleView.this) ? 34.0f : 24.0f);
                                ExplainBubbleViewAttr explainBubbleViewAttr = LiveExplainBubbleView.this.bubbleAttr;
                                ReadWriteProperty readWriteProperty = explainBubbleViewAttr.state$delegate;
                                KProperty<?>[] kPropertyArr = ExplainBubbleViewAttr.$$delegatedProperties;
                                ExplainState explainState = (ExplainState) readWriteProperty.getValue(explainBubbleViewAttr, kPropertyArr[0]);
                                ReadWriteProperty readWriteProperty2 = liveExplainBuyBtnAttr2.explainState$delegate;
                                KProperty<?>[] kPropertyArr2 = LiveExplainBuyBtnAttr.$$delegatedProperties;
                                readWriteProperty2.setValue(liveExplainBuyBtnAttr2, kPropertyArr2[0], explainState);
                                ExplainBubbleViewAttr explainBubbleViewAttr2 = LiveExplainBubbleView.this.bubbleAttr;
                                liveExplainBuyBtnAttr2.buyBtnActivityTxt$delegate.setValue(liveExplainBuyBtnAttr2, kPropertyArr2[3], (String) explainBubbleViewAttr2.buyBtnActivityTxt$delegate.getValue(explainBubbleViewAttr2, kPropertyArr[3]));
                                ExplainBubbleInfo bubbleInfo = LiveExplainBubbleView.this.bubbleAttr.getBubbleInfo();
                                if (bubbleInfo != null) {
                                    ExplainBubbleDetail explainBubbleDetail = bubbleInfo.detail;
                                    if (explainBubbleDetail == null || (explainPrice4 = explainBubbleDetail.price) == null || (str = explainPrice4.pricesTxt) == null) {
                                        str = "";
                                    }
                                    liveExplainBuyBtnAttr2.setGoodsPriceStr(str);
                                    ExplainLiveCouponInfo explainLiveCouponInfo = bubbleInfo.coupon;
                                    if (explainLiveCouponInfo != null && (explainPrice3 = explainLiveCouponInfo.afterCoupon) != null && (str3 = explainPrice3.pricesTxt) != null) {
                                        liveExplainBuyBtnAttr2.setGoodsPriceStr(str3);
                                    }
                                    ExplainActivity explainActivity = bubbleInfo.activity;
                                    if (explainActivity != null && (explainActivityPrice = explainActivity.price) != null) {
                                        liveExplainBuyBtnAttr2.setGoodsPriceStr(String.valueOf(explainActivityPrice.liveSpecial / 100.0d));
                                    }
                                    ExplainBubbleDetail explainBubbleDetail2 = bubbleInfo.detail;
                                    liveExplainBuyBtnAttr2.pricesSuffix$delegate.setValue(liveExplainBuyBtnAttr2, kPropertyArr2[2], String.valueOf((explainBubbleDetail2 == null || (explainPrice2 = explainBubbleDetail2.price) == null) ? null : explainPrice2.pricesSuffix));
                                    ExplainLiveCouponInfo explainLiveCouponInfo2 = bubbleInfo.coupon;
                                    if (explainLiveCouponInfo2 != null && (explainPrice = explainLiveCouponInfo2.afterCoupon) != null && (str2 = explainPrice.pricesSuffix) != null) {
                                        liveExplainBuyBtnAttr2.pricesSuffix$delegate.setValue(liveExplainBuyBtnAttr2, kPropertyArr2[2], str2);
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
        };
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return this.bubbleAttr;
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new ExplainBubbleViewEvent();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.kuikly.core.base.ComposeView
    public final void created() {
        ExplainActivity explainActivity;
        super.created();
        ExplainBubbleInfo bubbleInfo = ((ExplainBubbleViewAttr) getAttr()).getBubbleInfo();
        if (((bubbleInfo == null || (explainActivity = bubbleInfo.activity) == null) ? null : Integer.valueOf(explainActivity.f114288ts)) != null) {
            startTimer();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int leftTime(int i3) {
        ExplainActivity explainActivity;
        ExplainTimeRange explainTimeRange;
        Integer num = this.diffTime;
        Intrinsics.checkNotNull(num);
        int intValue = num.intValue() + i3;
        ExplainBubbleInfo bubbleInfo = ((ExplainBubbleViewAttr) getAttr()).getBubbleInfo();
        int i16 = ((bubbleInfo == null || (explainActivity = bubbleInfo.activity) == null || (explainTimeRange = explainActivity.timeRange) == null) ? 0 : explainTimeRange.begin) - intValue;
        if (i16 < 0) {
            return 0;
        }
        return i16;
    }

    public final void playBuyBtnAnimation() {
        aa<LiveExplainBuyBtn> aaVar = this.buyBtnRef;
        LiveExplainBuyBtn b16 = aaVar != null ? aaVar.b() : null;
        if (b16 != null) {
            LiveExplainBuyBtnAttr liveExplainBuyBtnAttr = b16.viewAttr;
            ReadWriteProperty readWriteProperty = liveExplainBuyBtnAttr.appearAnimated$delegate;
            KProperty<?>[] kPropertyArr = LiveExplainBuyBtnAttr.$$delegatedProperties;
            KProperty<?> kProperty = kPropertyArr[4];
            Boolean bool = Boolean.TRUE;
            readWriteProperty.setValue(liveExplainBuyBtnAttr, kProperty, bool);
            LiveExplainBuyBtnAttr liveExplainBuyBtnAttr2 = b16.viewAttr;
            liveExplainBuyBtnAttr2.lightSweep$delegate.setValue(liveExplainBuyBtnAttr2, kPropertyArr[5], bool);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void startTimer() {
        ExplainActivity explainActivity;
        ExplainBubbleInfo bubbleInfo = ((ExplainBubbleViewAttr) getAttr()).getBubbleInfo();
        if (((bubbleInfo == null || (explainActivity = bubbleInfo.activity) == null) ? null : Integer.valueOf(explainActivity.f114288ts)) == null) {
            return;
        }
        Utils.INSTANCE.bridgeModule(getPagerId()).localServeTime(new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqlive_biz.live_explain_page.view.LiveExplainBubbleView$startTimer$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(e eVar) {
                String str;
                ExplainActivity explainActivity2;
                e eVar2 = eVar;
                Intrinsics.checkNotNull(eVar2);
                int h16 = (int) eVar2.h("time");
                LiveExplainBubbleView liveExplainBubbleView = LiveExplainBubbleView.this;
                if (liveExplainBubbleView.diffTime == null) {
                    ExplainBubbleInfo bubbleInfo2 = LiveExplainBubbleView.access$getAttr(liveExplainBubbleView).getBubbleInfo();
                    Integer valueOf = (bubbleInfo2 == null || (explainActivity2 = bubbleInfo2.activity) == null) ? null : Integer.valueOf(explainActivity2.f114288ts);
                    Intrinsics.checkNotNull(valueOf);
                    liveExplainBubbleView.diffTime = Integer.valueOf(valueOf.intValue() - h16);
                }
                LiveExplainBubbleView liveExplainBubbleView2 = LiveExplainBubbleView.this;
                int leftTime = liveExplainBubbleView2.leftTime(h16);
                int i3 = leftTime % 60;
                String valueOf2 = String.valueOf(i3);
                if (i3 < 10) {
                    valueOf2 = '0' + valueOf2;
                }
                int i16 = leftTime / 60;
                String valueOf3 = String.valueOf(i16);
                if (i16 < 10) {
                    valueOf3 = '0' + valueOf3;
                }
                if (1 <= leftTime && leftTime < 60) {
                    str = valueOf3 + ':' + valueOf2;
                } else {
                    str = "";
                }
                liveExplainBubbleView2.leftTimeInfo$delegate.setValue(liveExplainBubbleView2, LiveExplainBubbleView.$$delegatedProperties[0], str);
                if (LiveExplainBubbleView.this.leftTime(h16) < 1) {
                    ExplainBubbleViewAttr explainBubbleViewAttr = LiveExplainBubbleView.this.bubbleAttr;
                    explainBubbleViewAttr.state$delegate.setValue(explainBubbleViewAttr, ExplainBubbleViewAttr.$$delegatedProperties[0], ExplainState.EXPLAINING);
                } else {
                    ExplainBubbleViewAttr explainBubbleViewAttr2 = LiveExplainBubbleView.this.bubbleAttr;
                    explainBubbleViewAttr2.state$delegate.setValue(explainBubbleViewAttr2, ExplainBubbleViewAttr.$$delegatedProperties[0], ExplainState.PREHEAT);
                }
                LiveExplainBubbleView liveExplainBubbleView3 = LiveExplainBubbleView.this;
                String pagerId = liveExplainBubbleView3.getPagerId();
                final LiveExplainBubbleView liveExplainBubbleView4 = LiveExplainBubbleView.this;
                liveExplainBubbleView3.timeCallbackRef = TimerKt.e(pagerId, 1000, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqlive_biz.live_explain_page.view.LiveExplainBubbleView$startTimer$1.1
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Unit invoke() {
                        LiveExplainBubbleView liveExplainBubbleView5 = LiveExplainBubbleView.this;
                        KProperty<Object>[] kPropertyArr = LiveExplainBubbleView.$$delegatedProperties;
                        liveExplainBubbleView5.startTimer();
                        return Unit.INSTANCE;
                    }
                });
                return Unit.INSTANCE;
            }
        });
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final void viewDestroyed() {
        super.viewDestroyed();
        if (this.timeCallbackRef.length() > 0) {
            GlobalFunctions.f117252a.c(getPagerId(), this.timeCallbackRef);
        }
    }
}
