package com.tencent.hippykotlin.demo.pages.qlive.lucky_bag_pendant_page;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.AgreementConsentViewKt$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.BridgeModule;
import com.tencent.hippykotlin.demo.pages.base.EcommerceExtKt;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.foundation.view.APNGAttr;
import com.tencent.hippykotlin.demo.pages.foundation.view.APNGEvent;
import com.tencent.hippykotlin.demo.pages.foundation.view.APNGVView;
import com.tencent.hippykotlin.demo.pages.foundation.view.APNGViewKt;
import com.tencent.hippykotlin.demo.pages.foundation.view.PAGAttr;
import com.tencent.hippykotlin.demo.pages.foundation.view.PAGEvent;
import com.tencent.hippykotlin.demo.pages.foundation.view.PAGView;
import com.tencent.hippykotlin.demo.pages.foundation.view.PAGViewKt;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.b;
import com.tencent.kuikly.core.base.d;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.directives.BindDirectivesView;
import com.tencent.kuikly.core.directives.BindDirectivesViewKt;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
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
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* loaded from: classes31.dex */
public final class LBPLuckyBagPendant extends ComposeView<LBPLuckyBagPendantAttr, LBPLuckyBagPendantEvent> {
    static {
        Reflection.mutableProperty1(new MutablePropertyReference1Impl(LBPLuckyBagPendant.class, "showBigAnimation", "getShowBigAnimation()Z", 0));
    }

    public LBPLuckyBagPendant() {
        c.a(Boolean.FALSE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ LBPLuckyBagPendantAttr access$getAttr(LBPLuckyBagPendant lBPLuckyBagPendant) {
        return (LBPLuckyBagPendantAttr) lBPLuckyBagPendant.getAttr();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void access$onClickPendant(LBPLuckyBagPendant lBPLuckyBagPendant) {
        String str;
        LBPPlayConfig lBPPlayConfig;
        LBPPlayDetail lBPPlayDetail = ((LBPLuckyBagPendantAttr) lBPLuckyBagPendant.getAttr()).curDetail;
        if (lBPPlayDetail == null || (lBPPlayConfig = lBPPlayDetail.conf) == null || (str = lBPPlayConfig.triggeredUrl) == null) {
            str = "";
        }
        if (((LBPLuckyBagPendantAttr) lBPLuckyBagPendant.getAttr()).curDetail == null) {
            Utils.INSTANCE.bridgeModule(lBPLuckyBagPendant.getPagerId()).log("attr.curDetail == null when click pendant");
        }
        LBPPlayDetail lBPPlayDetail2 = ((LBPLuckyBagPendantAttr) lBPLuckyBagPendant.getAttr()).curDetail;
        if ((lBPPlayDetail2 != null ? lBPPlayDetail2.conf : null) == null) {
            Utils.INSTANCE.bridgeModule(lBPLuckyBagPendant.getPagerId()).log("attr.curDetail?.conf == null when click pendant");
        }
        Utils utils = Utils.INSTANCE;
        utils.bridgeModule(lBPLuckyBagPendant.getPagerId()).log(AgreementConsentViewKt$$ExternalSyntheticOutline0.m("did click pendant with url", str));
        BridgeModule.openPage$default(utils.bridgeModule(lBPLuckyBagPendant.getPagerId()), AgreementConsentViewKt$$ExternalSyntheticOutline0.m(str, "&type=1&bgColor=ff06011c"), false, null, null, 30);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final e access$vrParams(LBPLuckyBagPendant lBPLuckyBagPendant) {
        lBPLuckyBagPendant.getClass();
        e eVar = new e();
        LBPLuckyBagPendantAttr lBPLuckyBagPendantAttr = (LBPLuckyBagPendantAttr) lBPLuckyBagPendant.getAttr();
        eVar.t("params_report_is_hrc", ((Number) lBPLuckyBagPendantAttr.isHRC$delegate.getValue(lBPLuckyBagPendantAttr, LBPLuckyBagPendantAttr.$$delegatedProperties[6])).intValue());
        if (((LBPLuckyBagPendantAttr) lBPLuckyBagPendant.getAttr()).getReportPlayStatus() != 0) {
            int i3 = 1;
            if (((LBPLuckyBagPendantAttr) lBPLuckyBagPendant.getAttr()).getReportPlayStatus() == 1) {
                i3 = 0;
            } else if (((LBPLuckyBagPendantAttr) lBPLuckyBagPendant.getAttr()).getReportPlayStatus() != 2) {
                i3 = 2;
            }
            eVar.t("qqlive_luckybag_status", i3);
        }
        return eVar;
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.lucky_bag_pendant_page.LBPLuckyBagPendant$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                final LBPLuckyBagPendant lBPLuckyBagPendant = LBPLuckyBagPendant.this;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.lucky_bag_pendant_page.LBPLuckyBagPendant$body$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        final LBPLuckyBagPendant lBPLuckyBagPendant2 = LBPLuckyBagPendant.this;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.lucky_bag_pendant_page.LBPLuckyBagPendant.body.1.1.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.m140flex(1.0f);
                                EcommerceExtKt.vr(tVar2, "em_qqlive_luckybag", LBPLuckyBagPendant.access$vrParams(LBPLuckyBagPendant.this));
                                return Unit.INSTANCE;
                            }
                        });
                        final LBPLuckyBagPendant lBPLuckyBagPendant3 = LBPLuckyBagPendant.this;
                        vVar2.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.lucky_bag_pendant_page.LBPLuckyBagPendant.body.1.1.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(u uVar) {
                                final LBPLuckyBagPendant lBPLuckyBagPendant4 = LBPLuckyBagPendant.this;
                                uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.lucky_bag_pendant_page.LBPLuckyBagPendant.body.1.1.2.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ClickParams clickParams) {
                                        LBPLuckyBagPendant.access$onClickPendant(LBPLuckyBagPendant.this);
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final LBPLuckyBagPendant lBPLuckyBagPendant4 = LBPLuckyBagPendant.this;
                        Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.lucky_bag_pendant_page.LBPLuckyBagPendant.body.1.1.3
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return LBPLuckyBagPendant.access$getAttr(LBPLuckyBagPendant.this).getPendantAnimationUrl();
                            }
                        };
                        final LBPLuckyBagPendant lBPLuckyBagPendant5 = LBPLuckyBagPendant.this;
                        BindDirectivesViewKt.a(vVar2, function0, new Function1<BindDirectivesView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.lucky_bag_pendant_page.LBPLuckyBagPendant.body.1.1.4
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(BindDirectivesView bindDirectivesView) {
                                final LBPLuckyBagPendant lBPLuckyBagPendant6 = LBPLuckyBagPendant.this;
                                PAGViewKt.PAG(bindDirectivesView, new Function1<PAGView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.lucky_bag_pendant_page.LBPLuckyBagPendant.body.1.1.4.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(PAGView pAGView) {
                                        PAGView pAGView2 = pAGView;
                                        final LBPLuckyBagPendant lBPLuckyBagPendant7 = LBPLuckyBagPendant.this;
                                        pAGView2.attr(new Function1<PAGAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.lucky_bag_pendant_page.LBPLuckyBagPendant.body.1.1.4.1.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(PAGAttr pAGAttr) {
                                                PAGAttr pAGAttr2 = pAGAttr;
                                                pAGAttr2.absolutePosition(0.0f, 0.0f, 0.0f, 0.0f);
                                                String pendantAnimationUrl = LBPLuckyBagPendant.access$getAttr(LBPLuckyBagPendant.this).getPendantAnimationUrl();
                                                if (pendantAnimationUrl == null) {
                                                    pendantAnimationUrl = "";
                                                }
                                                pAGAttr2.src(pendantAnimationUrl);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final LBPLuckyBagPendant lBPLuckyBagPendant8 = LBPLuckyBagPendant.this;
                                        pAGView2.event(new Function1<PAGEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.lucky_bag_pendant_page.LBPLuckyBagPendant.body.1.1.4.1.2
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(PAGEvent pAGEvent) {
                                                PAGEvent pAGEvent2 = pAGEvent;
                                                final LBPLuckyBagPendant lBPLuckyBagPendant9 = LBPLuckyBagPendant.this;
                                                pAGEvent2.register("animationEnd", new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.lucky_bag_pendant_page.LBPLuckyBagPendant.body.1.1.4.1.2.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(Object obj) {
                                                        ((LBPLuckyBagPendantEvent) LBPLuckyBagPendant.this.getEvent()).onFireEvent("newPendantDidShow", null);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final LBPLuckyBagPendant lBPLuckyBagPendant10 = LBPLuckyBagPendant.this;
                                                pAGEvent2.register("loadFailure", new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.lucky_bag_pendant_page.LBPLuckyBagPendant.body.1.1.4.1.2.2
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(Object obj) {
                                                        LBPPlayConfig lBPPlayConfig;
                                                        String str;
                                                        LBPLuckyBagPendantAttr access$getAttr = LBPLuckyBagPendant.access$getAttr(LBPLuckyBagPendant.this);
                                                        LBPPlayDetail lBPPlayDetail = access$getAttr.curDetail;
                                                        if (lBPPlayDetail != null && (lBPPlayConfig = lBPPlayDetail.conf) != null && (str = lBPPlayConfig.pendantIcon) != null) {
                                                            access$getAttr.setPendantAnimationUrl(null);
                                                            access$getAttr.setPendantIconUrl(str);
                                                            access$getAttr.showStatusArea$qecommerce_biz_release(false);
                                                        }
                                                        ((LBPLuckyBagPendantEvent) LBPLuckyBagPendant.this.getEvent()).onFireEvent("newPendantDidShow", null);
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
                        final LBPLuckyBagPendant lBPLuckyBagPendant6 = LBPLuckyBagPendant.this;
                        Function0<Object> function02 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.lucky_bag_pendant_page.LBPLuckyBagPendant.body.1.1.5
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                LBPLuckyBagPendantAttr access$getAttr = LBPLuckyBagPendant.access$getAttr(LBPLuckyBagPendant.this);
                                return (String) access$getAttr.pendantIconUrl$delegate.getValue(access$getAttr, LBPLuckyBagPendantAttr.$$delegatedProperties[3]);
                            }
                        };
                        final LBPLuckyBagPendant lBPLuckyBagPendant7 = LBPLuckyBagPendant.this;
                        BindDirectivesViewKt.a(vVar2, function02, new Function1<BindDirectivesView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.lucky_bag_pendant_page.LBPLuckyBagPendant.body.1.1.6
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(BindDirectivesView bindDirectivesView) {
                                final LBPLuckyBagPendant lBPLuckyBagPendant8 = LBPLuckyBagPendant.this;
                                ah.a(bindDirectivesView, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.lucky_bag_pendant_page.LBPLuckyBagPendant.body.1.1.6.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ImageView imageView) {
                                        final LBPLuckyBagPendant lBPLuckyBagPendant9 = LBPLuckyBagPendant.this;
                                        imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.lucky_bag_pendant_page.LBPLuckyBagPendant.body.1.1.6.1.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(af afVar) {
                                                af afVar2 = afVar;
                                                afVar2.absolutePosition(0.0f, 0.0f, 0.0f, 0.0f);
                                                LBPLuckyBagPendantAttr access$getAttr = LBPLuckyBagPendant.access$getAttr(LBPLuckyBagPendant.this);
                                                String str = (String) access$getAttr.pendantIconUrl$delegate.getValue(access$getAttr, LBPLuckyBagPendantAttr.$$delegatedProperties[3]);
                                                if (str == null) {
                                                    str = "";
                                                }
                                                b.a.b(afVar2, str, false, 2, null);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        ((LBPLuckyBagPendantEvent) LBPLuckyBagPendant.this.getEvent()).onFireEvent("newPendantDidShow", null);
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final LBPLuckyBagPendant lBPLuckyBagPendant8 = LBPLuckyBagPendant.this;
                        Function0<Object> function03 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.lucky_bag_pendant_page.LBPLuckyBagPendant.body.1.1.7
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                boolean z16 = true;
                                if (LBPLuckyBagPendant.access$getAttr(LBPLuckyBagPendant.this).getPlayStatus() != 1 && LBPLuckyBagPendant.access$getAttr(LBPLuckyBagPendant.this).getPlayStatus() != 2) {
                                    z16 = false;
                                }
                                return Boolean.valueOf(z16);
                            }
                        };
                        final LBPLuckyBagPendant lBPLuckyBagPendant9 = LBPLuckyBagPendant.this;
                        ConditionViewKt.c(vVar2, function03, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.lucky_bag_pendant_page.LBPLuckyBagPendant.body.1.1.8
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ConditionView conditionView) {
                                final LBPLuckyBagPendant lBPLuckyBagPendant10 = LBPLuckyBagPendant.this;
                                w.a(conditionView, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.lucky_bag_pendant_page.LBPLuckyBagPendant.body.1.1.8.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar3) {
                                        v vVar4 = vVar3;
                                        final LBPLuckyBagPendant lBPLuckyBagPendant11 = LBPLuckyBagPendant.this;
                                        vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.lucky_bag_pendant_page.LBPLuckyBagPendant.body.1.1.8.1.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                t tVar2 = tVar;
                                                tVar2.absolutePosition(0.0f, 0.0f, 0.0f, 0.0f);
                                                LBPLuckyBagPendantAttr access$getAttr = LBPLuckyBagPendant.access$getAttr(LBPLuckyBagPendant.this);
                                                ReadWriteProperty readWriteProperty = access$getAttr.statusAreaOpacity$delegate;
                                                KProperty<?>[] kPropertyArr = LBPLuckyBagPendantAttr.$$delegatedProperties;
                                                tVar2.m147opacity(((Number) readWriteProperty.getValue(access$getAttr, kPropertyArr[4])).floatValue());
                                                com.tencent.kuikly.core.base.b l3 = b.Companion.l(com.tencent.kuikly.core.base.b.INSTANCE, 0.233f, null, 2, null);
                                                LBPLuckyBagPendantAttr access$getAttr2 = LBPLuckyBagPendant.access$getAttr(LBPLuckyBagPendant.this);
                                                tVar2.m134animation(l3, (Object) Float.valueOf(((Number) access$getAttr2.statusAreaOpacity$delegate.getValue(access$getAttr2, kPropertyArr[4])).floatValue()));
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final LBPLuckyBagPendant lBPLuckyBagPendant12 = LBPLuckyBagPendant.this;
                                        Function0<Object> function04 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.lucky_bag_pendant_page.LBPLuckyBagPendant.body.1.1.8.1.2
                                            {
                                                super(0);
                                            }

                                            @Override // kotlin.jvm.functions.Function0
                                            public final Object invoke() {
                                                return Boolean.valueOf(LBPLuckyBagPendant.access$getAttr(LBPLuckyBagPendant.this).getPlayStatus() == 1);
                                            }
                                        };
                                        final LBPLuckyBagPendant lBPLuckyBagPendant13 = LBPLuckyBagPendant.this;
                                        ConditionViewKt.c(vVar4, function04, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.lucky_bag_pendant_page.LBPLuckyBagPendant.body.1.1.8.1.3
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ConditionView conditionView2) {
                                                final LBPLuckyBagPendant lBPLuckyBagPendant14 = LBPLuckyBagPendant.this;
                                                w.a(conditionView2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.lucky_bag_pendant_page.LBPLuckyBagPendant.body.1.1.8.1.3.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(v vVar5) {
                                                        v vVar6 = vVar5;
                                                        vVar6.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.lucky_bag_pendant_page.LBPLuckyBagPendant.body.1.1.8.1.3.1.1
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(t tVar) {
                                                                t tVar2 = tVar;
                                                                Attr.absolutePosition$default(tVar2, 0.0f, 4.0f, 1.0f, 4.0f, 1, null);
                                                                tVar2.mo141height(9.0f);
                                                                tVar2.borderRadius(4.5f);
                                                                tVar2.mo113backgroundColor(new h(0, 0, 0, 0.5f));
                                                                tVar2.allCenter();
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        final LBPLuckyBagPendant lBPLuckyBagPendant15 = LBPLuckyBagPendant.this;
                                                        vVar6.addChild(new LBPCountdownText(), new Function1<LBPCountdownText, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.lucky_bag_pendant_page.LBPLuckyBagPendant.body.1.1.8.1.3.1.2
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(LBPCountdownText lBPCountdownText) {
                                                                final LBPLuckyBagPendant lBPLuckyBagPendant16 = LBPLuckyBagPendant.this;
                                                                lBPCountdownText.attr(new Function1<LBPCountdownTextAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.lucky_bag_pendant_page.LBPLuckyBagPendant.body.1.1.8.1.3.1.2.1
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(LBPCountdownTextAttr lBPCountdownTextAttr) {
                                                                        LBPPlayInfo lBPPlayInfo;
                                                                        LBPCountdownTextAttr lBPCountdownTextAttr2 = lBPCountdownTextAttr;
                                                                        lBPCountdownTextAttr2.localTimeDiffServe = LBPLuckyBagPendant.access$getAttr(LBPLuckyBagPendant.this).localTimeDiffServe;
                                                                        LBPPlayDetail lBPPlayDetail = LBPLuckyBagPendant.access$getAttr(LBPLuckyBagPendant.this).curDetail;
                                                                        if (lBPPlayDetail != null && (lBPPlayInfo = lBPPlayDetail.info) != null) {
                                                                            lBPCountdownTextAttr2.endTime = lBPPlayInfo.startTime + lBPPlayInfo.durationTime;
                                                                        }
                                                                        if (!LBPLuckyBagPendant.this.getPagerData().getIsIOS()) {
                                                                            lBPCountdownTextAttr2.marginBottom(1.0f);
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
                                        final LBPLuckyBagPendant lBPLuckyBagPendant14 = LBPLuckyBagPendant.this;
                                        Function0<Object> function05 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.lucky_bag_pendant_page.LBPLuckyBagPendant.body.1.1.8.1.4
                                            {
                                                super(0);
                                            }

                                            @Override // kotlin.jvm.functions.Function0
                                            public final Object invoke() {
                                                return Boolean.valueOf(LBPLuckyBagPendant.access$getAttr(LBPLuckyBagPendant.this).getPlayStatus() == 2);
                                            }
                                        };
                                        final LBPLuckyBagPendant lBPLuckyBagPendant15 = LBPLuckyBagPendant.this;
                                        ConditionViewKt.b(vVar4, function05, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.lucky_bag_pendant_page.LBPLuckyBagPendant.body.1.1.8.1.5
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ConditionView conditionView2) {
                                                final LBPLuckyBagPendant lBPLuckyBagPendant16 = LBPLuckyBagPendant.this;
                                                w.a(conditionView2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.lucky_bag_pendant_page.LBPLuckyBagPendant.body.1.1.8.1.5.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(v vVar5) {
                                                        v vVar6 = vVar5;
                                                        vVar6.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.lucky_bag_pendant_page.LBPLuckyBagPendant.body.1.1.8.1.5.1.1
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(t tVar) {
                                                                t tVar2 = tVar;
                                                                Attr.absolutePosition$default(tVar2, 0.0f, 1.0f, 1.0f, 1.0f, 1, null);
                                                                tVar2.mo141height(10.0f);
                                                                tVar2.borderRadius(3.0f);
                                                                tVar2.mo113backgroundColor(new h(0, 0, 0, 0.5f));
                                                                tVar2.allCenter();
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        final LBPLuckyBagPendant lBPLuckyBagPendant17 = LBPLuckyBagPendant.this;
                                                        cg.a(vVar6, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.lucky_bag_pendant_page.LBPLuckyBagPendant.body.1.1.8.1.5.1.2
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(TextView textView) {
                                                                final LBPLuckyBagPendant lBPLuckyBagPendant18 = LBPLuckyBagPendant.this;
                                                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.lucky_bag_pendant_page.LBPLuckyBagPendant.body.1.1.8.1.5.1.2.1
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(ce ceVar) {
                                                                        String str;
                                                                        LBPPlayConfig lBPPlayConfig;
                                                                        ce ceVar2 = ceVar;
                                                                        ce.fontSize$default(ceVar2, 8.0f, null, 2, null);
                                                                        ceVar2.color(h.INSTANCE.m());
                                                                        LBPPlayDetail lBPPlayDetail = LBPLuckyBagPendant.access$getAttr(LBPLuckyBagPendant.this).curDetail;
                                                                        if (lBPPlayDetail == null || (lBPPlayConfig = lBPPlayDetail.conf) == null || (str = lBPPlayConfig.text) == null) {
                                                                            str = "";
                                                                        }
                                                                        ceVar2.text(str);
                                                                        if (!LBPLuckyBagPendant.this.getPagerData().getIsIOS()) {
                                                                            ceVar2.marginBottom(1.0f);
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
                        });
                        return Unit.INSTANCE;
                    }
                });
                final LBPLuckyBagPendant lBPLuckyBagPendant2 = LBPLuckyBagPendant.this;
                Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.lucky_bag_pendant_page.LBPLuckyBagPendant$body$1.2
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return LBPLuckyBagPendant.access$getAttr(LBPLuckyBagPendant.this).getBigAnimationUrl();
                    }
                };
                final LBPLuckyBagPendant lBPLuckyBagPendant3 = LBPLuckyBagPendant.this;
                ConditionViewKt.c(viewContainer2, function0, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.lucky_bag_pendant_page.LBPLuckyBagPendant$body$1.3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ConditionView conditionView) {
                        ConditionView conditionView2 = conditionView;
                        Utils.INSTANCE.bridgeModule(conditionView2.getPagerId()).log("lucky bag pendant begin animation");
                        final LBPLuckyBagPendant lBPLuckyBagPendant4 = LBPLuckyBagPendant.this;
                        bb.b(conditionView2, false, new Function1<ModalView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.lucky_bag_pendant_page.LBPLuckyBagPendant.body.1.3.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ModalView modalView) {
                                final LBPLuckyBagPendant lBPLuckyBagPendant5 = LBPLuckyBagPendant.this;
                                APNGViewKt.APNG(modalView, new Function1<APNGVView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.lucky_bag_pendant_page.LBPLuckyBagPendant.body.1.3.1.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(APNGVView aPNGVView) {
                                        APNGVView aPNGVView2 = aPNGVView;
                                        final LBPLuckyBagPendant lBPLuckyBagPendant6 = LBPLuckyBagPendant.this;
                                        aPNGVView2.attr(new Function1<APNGAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.lucky_bag_pendant_page.LBPLuckyBagPendant.body.1.3.1.1.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(APNGAttr aPNGAttr) {
                                                APNGAttr aPNGAttr2 = aPNGAttr;
                                                aPNGAttr2.marginTop(48.0f);
                                                String bigAnimationUrl = LBPLuckyBagPendant.access$getAttr(LBPLuckyBagPendant.this).getBigAnimationUrl();
                                                if (bigAnimationUrl == null) {
                                                    bigAnimationUrl = "";
                                                }
                                                aPNGAttr2.with("src", bigAnimationUrl);
                                                aPNGAttr2.with("autoPlay", Integer.valueOf(d.b(true)));
                                                aPNGAttr2.repeatCount(1);
                                                aPNGAttr2.size(100.0f, 100.0f);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final LBPLuckyBagPendant lBPLuckyBagPendant7 = LBPLuckyBagPendant.this;
                                        aPNGVView2.event(new Function1<APNGEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.lucky_bag_pendant_page.LBPLuckyBagPendant.body.1.3.1.1.2
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(APNGEvent aPNGEvent) {
                                                final APNGEvent aPNGEvent2 = aPNGEvent;
                                                final LBPLuckyBagPendant lBPLuckyBagPendant8 = LBPLuckyBagPendant.this;
                                                aPNGEvent2.register("animationEnd", new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.lucky_bag_pendant_page.LBPLuckyBagPendant.body.1.3.1.1.2.1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(Object obj) {
                                                        LBPLuckyBagPendant.access$getAttr(LBPLuckyBagPendant.this).bigAnimationDidFinish$qecommerce_biz_release();
                                                        Utils.INSTANCE.bridgeModule(aPNGEvent2.getPagerId()).log("lucky bag pendant animation end");
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final LBPLuckyBagPendant lBPLuckyBagPendant9 = LBPLuckyBagPendant.this;
                                                aPNGEvent2.register("loadFailure", new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.lucky_bag_pendant_page.LBPLuckyBagPendant.body.1.3.1.1.2.2
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(Object obj) {
                                                        LBPLuckyBagPendant.access$getAttr(LBPLuckyBagPendant.this).bigAnimationDidFinish$qecommerce_biz_release();
                                                        Utils.INSTANCE.bridgeModule(aPNGEvent2.getPagerId()).log("lucky bag pendant loadFailure");
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
        return new LBPLuckyBagPendantAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new LBPLuckyBagPendantEvent();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.kuikly.core.base.ComposeView
    public final void created() {
        String str;
        LBPPlayConfig lBPPlayConfig;
        super.created();
        boolean z16 = getPagerData().n().j("auto_open_luckybag") == 1;
        Utils utils = Utils.INSTANCE;
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("auto_open_luckybag param: ");
        m3.append(getPagerData().n().j("auto_open_luckybag"));
        utils.logToNative(m3.toString());
        if (z16) {
            LBPPlayDetail lBPPlayDetail = ((LBPLuckyBagPendantAttr) getAttr()).curDetail;
            if (lBPPlayDetail == null || (lBPPlayConfig = lBPPlayDetail.conf) == null || (str = lBPPlayConfig.triggeredUrl) == null) {
                str = "";
            }
            BridgeModule.openPage$default(utils.bridgeModule(getPagerId()), AgreementConsentViewKt$$ExternalSyntheticOutline0.m(str, "&type=1&bgColor=ff06011c"), false, null, null, 30);
            utils.logToNative("auto open " + str + " when LBPLuckyBagPendant created");
        }
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final void viewDidLayout() {
        super.viewDidLayout();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final void viewDidLoad() {
        super.viewDidLoad();
    }
}
