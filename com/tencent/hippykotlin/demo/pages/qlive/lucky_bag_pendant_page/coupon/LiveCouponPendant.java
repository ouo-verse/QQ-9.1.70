package com.tencent.hippykotlin.demo.pages.qlive.lucky_bag_pendant_page.coupon;

import com.tencent.hippykotlin.demo.pages.base.BridgeModule;
import com.tencent.hippykotlin.demo.pages.base.EcommerceExtKt;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt;
import com.tencent.hippykotlin.demo.pages.foundation.view.PAGAttr;
import com.tencent.hippykotlin.demo.pages.foundation.view.PAGEvent;
import com.tencent.hippykotlin.demo.pages.foundation.view.PAGView;
import com.tencent.hippykotlin.demo.pages.foundation.view.PAGViewKt;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.a;
import com.tencent.kuikly.core.base.b;
import com.tencent.kuikly.core.base.event.AnimationCompletionParams;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.l;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.base.u;
import com.tencent.kuikly.core.base.y;
import com.tencent.kuikly.core.directives.BindDirectivesView;
import com.tencent.kuikly.core.directives.BindDirectivesViewKt;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
import com.tencent.kuikly.core.module.k;
import com.tencent.kuikly.core.nvi.serialization.json.b;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.timer.TimerKt;
import com.tencent.kuikly.core.views.ModalView;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.bb;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* loaded from: classes31.dex */
public final class LiveCouponPendant extends ComposeView<LiveCouponPendantAttr, LiveCouponPendantEvent> {
    public static final /* synthetic */ int $r8$clinit = 0;

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ LiveCouponPendantAttr access$getAttr(LiveCouponPendant liveCouponPendant) {
        return (LiveCouponPendantAttr) liveCouponPendant.getAttr();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void access$onClickReceiveCoupon(LiveCouponPendant liveCouponPendant, LiveCouponPendant liveCouponPendant2) {
        ArrayList<LivingCoupon> arrayList;
        liveCouponPendant.getClass();
        e eVar = new e();
        LiveCouponPendantAttr liveCouponPendantAttr = (LiveCouponPendantAttr) liveCouponPendant2.getAttr();
        ReadWriteProperty readWriteProperty = liveCouponPendantAttr.roomID$delegate;
        KProperty<?>[] kPropertyArr = LiveCouponPendantAttr.$$delegatedProperties;
        eVar.u("roomID", ((Number) readWriteProperty.getValue(liveCouponPendantAttr, kPropertyArr[4])).longValue());
        LiveCouponPendantAttr liveCouponPendantAttr2 = (LiveCouponPendantAttr) liveCouponPendant2.getAttr();
        eVar.w("isAnchor", ((Boolean) liveCouponPendantAttr2.isAnchor$delegate.getValue(liveCouponPendantAttr2, kPropertyArr[3])).booleanValue());
        eVar.u("liveUserId", liveCouponPendant.getPagerData().n().n("live_user_id"));
        eVar.u("enterRoomTime", liveCouponPendant.getPagerData().n().n("enter_room_time"));
        eVar.v("liveProgramId", liveCouponPendant.getPagerData().n().p("live_program_id"));
        eVar.t("liveType", liveCouponPendant.getPagerData().n().j("live_type"));
        b bVar = new b();
        LiveCouponPendantAttr liveCouponPendantAttr3 = (LiveCouponPendantAttr) liveCouponPendant2.getAttr();
        LiveCouponRspModel liveCouponRspModel = (LiveCouponRspModel) liveCouponPendantAttr3.couponInfo$delegate.getValue(liveCouponPendantAttr3, kPropertyArr[5]);
        if (liveCouponRspModel != null && (arrayList = liveCouponRspModel.coupons) != null) {
            Iterator<T> it = arrayList.iterator();
            while (it.hasNext()) {
                bVar.t(((LivingCoupon) it.next()).couponBatchId);
            }
        }
        eVar.v("couponBatchIds", bVar);
        Utils.INSTANCE.logToNative("KTVLivePendant onClickReceiveCoupon userData " + eVar);
        BridgeModule.openPage$default(IPagerIdKtxKt.getBridgeModule(liveCouponPendant2), "mqqapi://ecommerce/open?target=52&channel=2&page_name=LiveCouponReceivePage&modal_mode=1", false, eVar, null, 24);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void access$onCouponReceiveSuccess(LiveCouponPendant liveCouponPendant, e eVar) {
        liveCouponPendant.getClass();
        Utils.INSTANCE.logToNative("KTVLivePendant onCouponReceiveSuccess " + eVar);
        if (eVar != null) {
            long n3 = eVar.n("roomID");
            LiveCouponPendantAttr liveCouponPendantAttr = (LiveCouponPendantAttr) liveCouponPendant.getAttr();
            ReadWriteProperty readWriteProperty = liveCouponPendantAttr.roomID$delegate;
            KProperty<?>[] kPropertyArr = LiveCouponPendantAttr.$$delegatedProperties;
            if (n3 == ((Number) readWriteProperty.getValue(liveCouponPendantAttr, kPropertyArr[4])).longValue()) {
                LiveCouponPendantAttr liveCouponPendantAttr2 = (LiveCouponPendantAttr) liveCouponPendant.getAttr();
                liveCouponPendantAttr2.couponNum$delegate.setValue(liveCouponPendantAttr2, kPropertyArr[6], Integer.valueOf(eVar.j("coupon_num")));
            }
        }
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.lucky_bag_pendant_page.coupon.LiveCouponPendant$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                final LiveCouponPendant liveCouponPendant = LiveCouponPendant.this;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.lucky_bag_pendant_page.coupon.LiveCouponPendant$body$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        e eVar = new e();
                        LiveCouponPendantAttr access$getAttr = LiveCouponPendant.access$getAttr(LiveCouponPendant.this);
                        EcommerceExtKt.vr(mVar, "em_qqlive_coupon_entrance", eVar.t("params_report_is_hrc", ((Number) access$getAttr.isHRC$delegate.getValue(access$getAttr, LiveCouponPendantAttr.$$delegatedProperties[8])).intValue()));
                        return Unit.INSTANCE;
                    }
                });
                final LiveCouponPendant liveCouponPendant2 = LiveCouponPendant.this;
                viewContainer2.event(new Function1<Event, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.lucky_bag_pendant_page.coupon.LiveCouponPendant$body$1.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Event event) {
                        final LiveCouponPendant liveCouponPendant3 = LiveCouponPendant.this;
                        event.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.lucky_bag_pendant_page.coupon.LiveCouponPendant.body.1.2.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ClickParams clickParams) {
                                LiveCouponPendant liveCouponPendant4 = LiveCouponPendant.this;
                                LiveCouponPendant.access$onClickReceiveCoupon(liveCouponPendant4, liveCouponPendant4);
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final LiveCouponPendant liveCouponPendant3 = LiveCouponPendant.this;
                Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.lucky_bag_pendant_page.coupon.LiveCouponPendant$body$1.3
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        LiveCouponPendantAttr access$getAttr = LiveCouponPendant.access$getAttr(LiveCouponPendant.this);
                        return (String) access$getAttr.pendantAnimationUrl$delegate.getValue(access$getAttr, LiveCouponPendantAttr.$$delegatedProperties[2]);
                    }
                };
                final LiveCouponPendant liveCouponPendant4 = LiveCouponPendant.this;
                BindDirectivesViewKt.a(viewContainer2, function0, new Function1<BindDirectivesView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.lucky_bag_pendant_page.coupon.LiveCouponPendant$body$1.4
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(BindDirectivesView bindDirectivesView) {
                        BindDirectivesView bindDirectivesView2 = bindDirectivesView;
                        final LiveCouponPendant liveCouponPendant5 = LiveCouponPendant.this;
                        Function0<Object> function02 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.lucky_bag_pendant_page.coupon.LiveCouponPendant.body.1.4.1
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Boolean.valueOf(LiveCouponPendant.access$getAttr(LiveCouponPendant.this).getCouponNum() > 0);
                            }
                        };
                        final LiveCouponPendant liveCouponPendant6 = LiveCouponPendant.this;
                        ConditionViewKt.c(bindDirectivesView2, function02, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.lucky_bag_pendant_page.coupon.LiveCouponPendant.body.1.4.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ConditionView conditionView) {
                                final LiveCouponPendant liveCouponPendant7 = LiveCouponPendant.this;
                                PAGViewKt.PAG(conditionView, new Function1<PAGView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.lucky_bag_pendant_page.coupon.LiveCouponPendant.body.1.4.2.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(PAGView pAGView) {
                                        PAGView pAGView2 = pAGView;
                                        final LiveCouponPendant liveCouponPendant8 = LiveCouponPendant.this;
                                        pAGView2.attr(new Function1<PAGAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.lucky_bag_pendant_page.coupon.LiveCouponPendant.body.1.4.2.1.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(PAGAttr pAGAttr) {
                                                PAGAttr pAGAttr2 = pAGAttr;
                                                pAGAttr2.marginLeft(LiveCouponPendant.this.getPagerData().getIsIOS() ? 9.0f : 7.0f);
                                                pAGAttr2.size(40.0f, 40.0f);
                                                LiveCouponPendantAttr access$getAttr = LiveCouponPendant.access$getAttr(LiveCouponPendant.this);
                                                String str = (String) access$getAttr.pendantAnimationUrl$delegate.getValue(access$getAttr, LiveCouponPendantAttr.$$delegatedProperties[2]);
                                                if (str == null) {
                                                    str = "";
                                                }
                                                pAGAttr2.src(str);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final LiveCouponPendant liveCouponPendant9 = LiveCouponPendant.this;
                                        pAGView2.event(new Function1<PAGEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.lucky_bag_pendant_page.coupon.LiveCouponPendant.body.1.4.2.1.2
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(PAGEvent pAGEvent) {
                                                final LiveCouponPendant liveCouponPendant10 = LiveCouponPendant.this;
                                                pAGEvent.register("animationEnd", new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.lucky_bag_pendant_page.coupon.LiveCouponPendant.body.1.4.2.1.2.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(Object obj) {
                                                        LiveCouponPendant liveCouponPendant11 = LiveCouponPendant.this;
                                                        int i3 = LiveCouponPendant.$r8$clinit;
                                                        liveCouponPendant11.emit("pendantDidShow", null);
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
                        final LiveCouponPendant liveCouponPendant7 = LiveCouponPendant.this;
                        Function0<Object> function03 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.lucky_bag_pendant_page.coupon.LiveCouponPendant.body.1.4.3
                            {
                                super(0);
                            }

                            /* JADX WARN: Code restructure failed: missing block: B:4:0x0024, code lost:
                            
                                if (((java.lang.Boolean) r0.isAnchor$delegate.getValue(r0, com.tencent.hippykotlin.demo.pages.qlive.lucky_bag_pendant_page.coupon.LiveCouponPendantAttr.$$delegatedProperties[3])).booleanValue() == false) goto L8;
                             */
                            @Override // kotlin.jvm.functions.Function0
                            /*
                                Code decompiled incorrectly, please refer to instructions dump.
                            */
                            public final Object invoke() {
                                boolean z16 = true;
                                if (LiveCouponPendant.access$getAttr(LiveCouponPendant.this).getCouponNum() > 1) {
                                    LiveCouponPendantAttr access$getAttr = LiveCouponPendant.access$getAttr(LiveCouponPendant.this);
                                }
                                z16 = false;
                                return Boolean.valueOf(z16);
                            }
                        };
                        final LiveCouponPendant liveCouponPendant8 = LiveCouponPendant.this;
                        ConditionViewKt.c(bindDirectivesView2, function03, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.lucky_bag_pendant_page.coupon.LiveCouponPendant.body.1.4.4
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ConditionView conditionView) {
                                final LiveCouponPendant liveCouponPendant9 = LiveCouponPendant.this;
                                w.a(conditionView, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.lucky_bag_pendant_page.coupon.LiveCouponPendant.body.1.4.4.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar) {
                                        v vVar2 = vVar;
                                        final LiveCouponPendant liveCouponPendant10 = LiveCouponPendant.this;
                                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.lucky_bag_pendant_page.coupon.LiveCouponPendant.body.1.4.4.1.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                t tVar2 = tVar;
                                                tVar2.mo113backgroundColor(new h(4294396976L));
                                                tVar2.mo141height(16.0f).borderRadius(8.0f);
                                                Attr.absolutePosition$default(tVar2, -4.0f, 0.0f, 0.0f, -4.0f, 6, null);
                                                tVar2.alignItemsCenter();
                                                if (tVar2.getPagerData().getIsIOS()) {
                                                    tVar2.justifyContentFlexEnd();
                                                } else {
                                                    tVar2.justifyContentCenter();
                                                }
                                                if (LiveCouponPendant.access$getAttr(LiveCouponPendant.this).getCouponNum() < 100) {
                                                    tVar2.mo153width(16.0f);
                                                } else {
                                                    a.C5863a.a(tVar2, 0.0f, 4.0f, 0.0f, 4.0f, 5, null);
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final LiveCouponPendant liveCouponPendant11 = LiveCouponPendant.this;
                                        cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.lucky_bag_pendant_page.coupon.LiveCouponPendant.body.1.4.4.1.2
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(TextView textView) {
                                                final LiveCouponPendant liveCouponPendant12 = LiveCouponPendant.this;
                                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.lucky_bag_pendant_page.coupon.LiveCouponPendant.body.1.4.4.1.2.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ce ceVar) {
                                                        String valueOf;
                                                        ce ceVar2 = ceVar;
                                                        ce.fontSize$default(ceVar2.fontWeight700(), 10.0f, null, 2, null).fontFamily("DIN Next LT Pro").lines(1);
                                                        ceVar2.color(h.INSTANCE.m());
                                                        if (LiveCouponPendant.access$getAttr(LiveCouponPendant.this).getCouponNum() > 99) {
                                                            valueOf = "99+";
                                                        } else {
                                                            valueOf = String.valueOf(LiveCouponPendant.access$getAttr(LiveCouponPendant.this).getCouponNum());
                                                        }
                                                        ceVar2.text(valueOf);
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
                final LiveCouponPendant liveCouponPendant5 = LiveCouponPendant.this;
                bb.b(viewContainer2, false, new Function1<ModalView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.lucky_bag_pendant_page.coupon.LiveCouponPendant$body$1.5
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ModalView modalView) {
                        final LiveCouponPendant liveCouponPendant6 = LiveCouponPendant.this;
                        modalView.addChild(new CPBigCouponView(), new Function1<CPBigCouponView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.lucky_bag_pendant_page.coupon.LiveCouponPendant.body.1.5.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(CPBigCouponView cPBigCouponView) {
                                CPBigCouponView cPBigCouponView2 = cPBigCouponView;
                                final LiveCouponPendant liveCouponPendant7 = LiveCouponPendant.this;
                                cPBigCouponView2.attr(new Function1<CPBigCouponViewAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.lucky_bag_pendant_page.coupon.LiveCouponPendant.body.1.5.1.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(CPBigCouponViewAttr cPBigCouponViewAttr) {
                                        CPBigCouponViewAttr cPBigCouponViewAttr2 = cPBigCouponViewAttr;
                                        cPBigCouponViewAttr2.transform(new y(-1.25f, 0.0f, 0.0f, 0.0f, 12, null));
                                        if (LiveCouponPendant.access$getAttr(LiveCouponPendant.this).getBigCouponViewAnimated()) {
                                            cPBigCouponViewAttr2.transform(new y(0.0f, 0.0f, 0.0f, 0.0f, 12, null));
                                        }
                                        b.Companion companion = com.tencent.kuikly.core.base.b.INSTANCE;
                                        cPBigCouponViewAttr2.m134animation(b.Companion.n(companion, 0.5f, 0.8f, 0.7f, null, 8, null), (Object) Boolean.valueOf(LiveCouponPendant.access$getAttr(LiveCouponPendant.this).getBigCouponViewAnimated()));
                                        LiveCouponPendantAttr access$getAttr = LiveCouponPendant.access$getAttr(LiveCouponPendant.this);
                                        ReadWriteProperty readWriteProperty = access$getAttr.bigCouponViewDisappearAnimated$delegate;
                                        KProperty<?>[] kPropertyArr = LiveCouponPendantAttr.$$delegatedProperties;
                                        if (((Boolean) readWriteProperty.getValue(access$getAttr, kPropertyArr[1])).booleanValue()) {
                                            cPBigCouponViewAttr2.transform(new u(0.0f, 0.0f));
                                        }
                                        com.tencent.kuikly.core.base.b r16 = b.Companion.r(companion, 0.5f, 0.9f, 0.7f, null, 8, null);
                                        LiveCouponPendantAttr access$getAttr2 = LiveCouponPendant.access$getAttr(LiveCouponPendant.this);
                                        cPBigCouponViewAttr2.m134animation(r16, (Object) Boolean.valueOf(((Boolean) access$getAttr2.bigCouponViewDisappearAnimated$delegate.getValue(access$getAttr2, kPropertyArr[1])).booleanValue()));
                                        LiveCouponPendantAttr access$getAttr3 = LiveCouponPendant.access$getAttr(LiveCouponPendant.this);
                                        cPBigCouponViewAttr2.couponInfo$delegate.setValue(cPBigCouponViewAttr2, CPBigCouponViewAttr.$$delegatedProperties[0], (LiveCouponRspModel) access$getAttr3.couponInfo$delegate.getValue(access$getAttr3, kPropertyArr[5]));
                                        return Unit.INSTANCE;
                                    }
                                });
                                final LiveCouponPendant liveCouponPendant8 = LiveCouponPendant.this;
                                cPBigCouponView2.event(new Function1<l, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.lucky_bag_pendant_page.coupon.LiveCouponPendant.body.1.5.1.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(l lVar) {
                                        final l lVar2 = lVar;
                                        final LiveCouponPendant liveCouponPendant9 = LiveCouponPendant.this;
                                        lVar2.animationCompletion(new Function1<AnimationCompletionParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.lucky_bag_pendant_page.coupon.LiveCouponPendant.body.1.5.1.2.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(AnimationCompletionParams animationCompletionParams) {
                                                if (LiveCouponPendant.access$getAttr(LiveCouponPendant.this).getBigCouponViewAnimated()) {
                                                    l lVar3 = lVar2;
                                                    final LiveCouponPendant liveCouponPendant10 = LiveCouponPendant.this;
                                                    Function0<Unit> function02 = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.lucky_bag_pendant_page.coupon.LiveCouponPendant.body.1.5.1.2.1.1
                                                        {
                                                            super(0);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function0
                                                        public final Unit invoke() {
                                                            LiveCouponPendantAttr access$getAttr = LiveCouponPendant.access$getAttr(LiveCouponPendant.this);
                                                            ReadWriteProperty readWriteProperty = access$getAttr.pendantAnimationUrl$delegate;
                                                            KProperty<?>[] kPropertyArr = LiveCouponPendantAttr.$$delegatedProperties;
                                                            readWriteProperty.setValue(access$getAttr, kPropertyArr[2], "https://qq-ecommerce.cdn-go.cn/iOS/latest/defaultmode/8925/youhuiquan/qecommerce_zhibo_coupon.pag");
                                                            LiveCouponPendantAttr access$getAttr2 = LiveCouponPendant.access$getAttr(LiveCouponPendant.this);
                                                            access$getAttr2.bigCouponViewDisappearAnimated$delegate.setValue(access$getAttr2, kPropertyArr[1], Boolean.TRUE);
                                                            return Unit.INSTANCE;
                                                        }
                                                    };
                                                    KProperty<Object>[] kPropertyArr = IPagerIdKtxKt.$$delegatedProperties;
                                                    TimerKt.e(lVar3.getPagerId(), 3000, function02);
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
                }, 1, null);
                return Unit.INSTANCE;
            }
        };
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return new LiveCouponPendantAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new LiveCouponPendantEvent();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final void viewDidLoad() {
        super.viewDidLoad();
        Function0<Unit> function0 = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.lucky_bag_pendant_page.coupon.LiveCouponPendant$viewDidLoad$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Unit invoke() {
                LiveCouponPendantAttr access$getAttr = LiveCouponPendant.access$getAttr(LiveCouponPendant.this);
                access$getAttr.bigCouponViewAnimated$delegate.setValue(access$getAttr, LiveCouponPendantAttr.$$delegatedProperties[0], Boolean.TRUE);
                return Unit.INSTANCE;
            }
        };
        KProperty<Object>[] kPropertyArr = IPagerIdKtxKt.$$delegatedProperties;
        TimerKt.e(getPagerId(), 1000, function0);
        k kVar = (k) getModule("KRNotifyModule");
        if (kVar != null) {
            kVar.a("CouponReceiveSuccess", true, new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.lucky_bag_pendant_page.coupon.LiveCouponPendant$viewDidLoad$2
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(e eVar) {
                    LiveCouponPendant.access$onCouponReceiveSuccess(LiveCouponPendant.this, eVar);
                    return Unit.INSTANCE;
                }
            });
        }
    }
}
