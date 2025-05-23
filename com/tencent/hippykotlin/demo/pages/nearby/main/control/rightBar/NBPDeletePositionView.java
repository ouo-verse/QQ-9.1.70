package com.tencent.hippykotlin.demo.pages.nearby.main.control.rightBar;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.QToastMode;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt;
import com.tencent.hippykotlin.demo.pages.foundation.module.PbResponse;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQUIModule;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedDetailPageV2$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyApi$sendPbRequest$1;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyConstKt;
import com.tencent.hippykotlin.demo.pages.nearby.base.tech_reporter.APICallTechReporter;
import com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPMainKtxKt;
import com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPViewModelStoreKt;
import com.tencent.hippykotlin.demo.pages.nearby.main.control.NBPMainControlViewModel;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.b;
import com.tencent.kuikly.core.base.event.AnimationCompletionParams;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.base.y;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.timer.TimerKt;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.u;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* loaded from: classes31.dex */
public final class NBPDeletePositionView extends ComposeView<NBPDeletePositionViewAttr, NBPDeletePositionViewEvent> {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPDeletePositionView.class, "animated", "getAnimated()Z", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPDeletePositionView.class, "showDeletePositionAlert", "getShowDeletePositionAlert()Z", 0)};
    public final ReadWriteProperty animated$delegate;
    public NBPMainControlViewModel controlViewModel;
    public final ReadWriteProperty showDeletePositionAlert$delegate;

    public NBPDeletePositionView() {
        Boolean bool = Boolean.FALSE;
        this.animated$delegate = c.a(bool);
        this.showDeletePositionAlert$delegate = c.a(bool);
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        this.controlViewModel = NBPViewModelStoreKt.getControlViewModel(NBPMainKtxKt.getNbpVMStore(getPager()));
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.rightBar.NBPDeletePositionView$body$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                final NBPDeletePositionView nBPDeletePositionView = NBPDeletePositionView.this;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.rightBar.NBPDeletePositionView$body$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        mVar2.absolutePosition(0.0f, 0.0f, 0.0f, 0.0f);
                        mVar2.justifyContentFlexEnd();
                        if (NBPDeletePositionView.this.getAnimated()) {
                            mVar2.mo113backgroundColor(new h(0, 0, 0, 0.5f));
                        } else {
                            mVar2.mo113backgroundColor(new h(0, 0, 0, 0.0f));
                        }
                        mVar2.m134animation(b.Companion.n(b.INSTANCE, 0.5f, 0.92f, 1.0f, null, 8, null), (Object) Boolean.valueOf(NBPDeletePositionView.this.getAnimated()));
                        return Unit.INSTANCE;
                    }
                });
                final NBPDeletePositionView nBPDeletePositionView2 = NBPDeletePositionView.this;
                final NBPDeletePositionView nBPDeletePositionView3 = this;
                viewContainer2.event(new Function1<Event, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.rightBar.NBPDeletePositionView$body$1.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Event event) {
                        Event event2 = event;
                        final NBPDeletePositionView nBPDeletePositionView4 = NBPDeletePositionView.this;
                        event2.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.rightBar.NBPDeletePositionView.body.1.2.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ClickParams clickParams) {
                                NBPDeletePositionView.this.setAnimated(false);
                                return Unit.INSTANCE;
                            }
                        });
                        final NBPDeletePositionView nBPDeletePositionView5 = NBPDeletePositionView.this;
                        final NBPDeletePositionView nBPDeletePositionView6 = nBPDeletePositionView3;
                        event2.animationCompletion(new Function1<AnimationCompletionParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.rightBar.NBPDeletePositionView.body.1.2.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(AnimationCompletionParams animationCompletionParams) {
                                AnimationCompletionParams animationCompletionParams2 = animationCompletionParams;
                                if (!NBPDeletePositionView.this.getAnimated()) {
                                    nBPDeletePositionView6.emit("close", animationCompletionParams2);
                                }
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final NBPDeletePositionView nBPDeletePositionView4 = NBPDeletePositionView.this;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.rightBar.NBPDeletePositionView$body$1.3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        final NBPDeletePositionView nBPDeletePositionView5 = NBPDeletePositionView.this;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.rightBar.NBPDeletePositionView.body.1.3.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.mo113backgroundColor(QUIToken.color$default("bg_middle_light"));
                                if (NBPDeletePositionView.this.getAnimated()) {
                                    tVar2.transform(new y(0.0f, 0.0f, 0.0f, 0.0f, 12, null));
                                } else {
                                    tVar2.transform(new y(0.0f, 1.0f, 0.0f, 0.0f, 12, null));
                                }
                                tVar2.m134animation(b.Companion.n(b.INSTANCE, 0.5f, 0.92f, 1.0f, null, 8, null), (Object) Boolean.valueOf(NBPDeletePositionView.this.getAnimated()));
                                return Unit.INSTANCE;
                            }
                        });
                        final NBPDeletePositionView nBPDeletePositionView6 = NBPDeletePositionView.this;
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.rightBar.NBPDeletePositionView.body.1.3.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                v vVar4 = vVar3;
                                vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.rightBar.NBPDeletePositionView.body.1.3.2.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.mo141height(56.0f);
                                        tVar2.allCenter();
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPDeletePositionView nBPDeletePositionView7 = NBPDeletePositionView.this;
                                vVar4.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.rightBar.NBPDeletePositionView.body.1.3.2.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(u uVar) {
                                        final NBPDeletePositionView nBPDeletePositionView8 = NBPDeletePositionView.this;
                                        uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.rightBar.NBPDeletePositionView.body.1.3.2.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ClickParams clickParams) {
                                                NBPDeletePositionView.this.setAnimated(false);
                                                NBPDeletePositionView nBPDeletePositionView9 = NBPDeletePositionView.this;
                                                nBPDeletePositionView9.showDeletePositionAlert$delegate.setValue(nBPDeletePositionView9, NBPDeletePositionView.$$delegatedProperties[1], Boolean.TRUE);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.rightBar.NBPDeletePositionView.body.1.3.2.3
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(TextView textView) {
                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.rightBar.NBPDeletePositionView.body.1.3.2.3.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ce ceVar) {
                                                ce ceVar2 = ceVar;
                                                ceVar2.color(h.INSTANCE.i());
                                                ceVar2.fontWeight500();
                                                ceVar2.text("\u6e05\u9664\u4f4d\u7f6e\u4fe1\u606f\u5e76\u9000\u51fa\u9644\u8fd1");
                                                ce.fontSize$default(ceVar2, 17.0f, null, 2, null);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.rightBar.NBPDeletePositionView.body.1.3.3
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                vVar3.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.rightBar.NBPDeletePositionView.body.1.3.3.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.mo141height(12.0f);
                                        tVar2.mo113backgroundColor(QUIToken.color$default("bg_middle_standard"));
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.rightBar.NBPDeletePositionView.body.1.3.4
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                v vVar4 = vVar3;
                                vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.rightBar.NBPDeletePositionView.body.1.3.4.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.allCenter();
                                        tVar2.mo141height(56.0f);
                                        if (tVar2.getPagerData().getAndroidBottomBavBarHeight() < 30.0f) {
                                            tVar2.marginBottom(20.0f);
                                        }
                                        return Unit.INSTANCE;
                                    }
                                });
                                cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.rightBar.NBPDeletePositionView.body.1.3.4.2
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(TextView textView) {
                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.rightBar.NBPDeletePositionView.body.1.3.4.2.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ce ceVar) {
                                                ce ceVar2 = ceVar;
                                                ce.fontSize$default(ceVar2, 17.0f, null, 2, null);
                                                ceVar2.text("\u53d6\u6d88");
                                                ceVar2.color(QUIToken.color$default("text_primary"));
                                                ceVar2.fontWeight600();
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
                final NBPDeletePositionView nBPDeletePositionView5 = NBPDeletePositionView.this;
                Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.rightBar.NBPDeletePositionView$body$1.4
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        NBPDeletePositionView nBPDeletePositionView6 = NBPDeletePositionView.this;
                        return Boolean.valueOf(((Boolean) nBPDeletePositionView6.showDeletePositionAlert$delegate.getValue(nBPDeletePositionView6, NBPDeletePositionView.$$delegatedProperties[1])).booleanValue());
                    }
                };
                final NBPDeletePositionView nBPDeletePositionView6 = NBPDeletePositionView.this;
                ConditionViewKt.c(viewContainer2, function0, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.rightBar.NBPDeletePositionView$body$1.5
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ConditionView conditionView) {
                        e jsonWithMainPgParamsImp = NearbyConstKt.jsonWithMainPgParamsImp();
                        jsonWithMainPgParamsImp.v("dt_eid", "em_nearby_location_clear_pop");
                        jsonWithMainPgParamsImp.v(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
                        Utils.INSTANCE.currentBridgeModule().reportCustomDtEvent("dt_imp", jsonWithMainPgParamsImp);
                        QQUIModule qQUIModule = (QQUIModule) com.tencent.kuikly.core.manager.c.f117352a.g().acquireModule("QQUIModule");
                        final NBPDeletePositionView nBPDeletePositionView7 = NBPDeletePositionView.this;
                        qQUIModule.openAlertDialog("", "\u6e05\u9664\u540e\uff0c\u9644\u8fd1\u5185\u4e0d\u518d\u5c55\u793a\u4f60\u7684\u52a8\u6001\u548c\u5728\u7ebf\u60c5\u51b5\uff0c\u662f\u5426\u786e\u8ba4\u6e05\u9664\uff1f", "\u53d6\u6d88", "\u786e\u8ba4", "", false, new Function2<Boolean, Boolean, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.rightBar.NBPDeletePositionView.body.1.5.2
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public final Unit invoke(Boolean bool, Boolean bool2) {
                                boolean booleanValue = bool.booleanValue();
                                bool2.booleanValue();
                                NBPMainControlViewModel nBPMainControlViewModel = null;
                                if (booleanValue) {
                                    final NBPDeletePositionView nBPDeletePositionView8 = NBPDeletePositionView.this;
                                    nBPDeletePositionView8.showDeletePositionAlert$delegate.setValue(nBPDeletePositionView8, NBPDeletePositionView.$$delegatedProperties[1], Boolean.FALSE);
                                    CancelAccountRequest cancelAccountRequest = new CancelAccountRequest();
                                    Function1<PbResponse<f35.b>, Unit> function1 = new Function1<PbResponse<f35.b>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.rightBar.NBPDeletePositionView$onConfirmDeleteClick$1
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(PbResponse<f35.b> pbResponse) {
                                            PbResponse<f35.b> pbResponse2 = pbResponse;
                                            if (pbResponse2.success) {
                                                KLog kLog = KLog.INSTANCE;
                                                StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("report delete position success. protoSize=");
                                                f35.b bVar = pbResponse2.rsp;
                                                NBPArticleFeedDetailPageV2$$ExternalSyntheticOutline0.m(m3, bVar != null ? Integer.valueOf(bVar.getProtoSize()) : null, kLog, "NBPMainRightBar");
                                                Utils.INSTANCE.currentBridgeModule().qToast("\u5220\u9664\u4f4d\u7f6e\u6210\u529f", QToastMode.Success);
                                                NBPDeletePositionView nBPDeletePositionView9 = NBPDeletePositionView.this;
                                                AnonymousClass1 anonymousClass1 = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.rightBar.NBPDeletePositionView$onConfirmDeleteClick$1.1
                                                    @Override // kotlin.jvm.functions.Function0
                                                    public final Unit invoke() {
                                                        QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
                                                        QQKuiklyPlatformApi.Companion.closePage$default();
                                                        return Unit.INSTANCE;
                                                    }
                                                };
                                                KProperty<Object>[] kPropertyArr = IPagerIdKtxKt.$$delegatedProperties;
                                                TimerKt.e(nBPDeletePositionView9.getPagerId(), 600, anonymousClass1);
                                            } else {
                                                KLog.INSTANCE.i("NBPMainRightBar", "report delete position fail");
                                                Utils.INSTANCE.currentBridgeModule().qToast("\u5220\u9664\u4f4d\u7f6e\u5931\u8d25", QToastMode.Warning);
                                            }
                                            return Unit.INSTANCE;
                                        }
                                    };
                                    APICallTechReporter aPICallTechReporter = new APICallTechReporter(1, "trpc.lplan.user_manager_svr.User.SsoCancelAccount");
                                    QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
                                    QQKuiklyPlatformApi.Companion.sendPbRequest$default(cancelAccountRequest, null, new NearbyApi$sendPbRequest$1(aPICallTechReporter, function1), 6);
                                    e jsonWithMainPgParams = NearbyConstKt.jsonWithMainPgParams();
                                    jsonWithMainPgParams.v("dt_eid", "em_nearby_location_clear_pop");
                                    jsonWithMainPgParams.t("nearby_btn_type", 1);
                                    jsonWithMainPgParams.v(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
                                    Utils.INSTANCE.currentBridgeModule().reportCustomDtEvent("dt_clck", jsonWithMainPgParams);
                                } else {
                                    NBPDeletePositionView nBPDeletePositionView9 = NBPDeletePositionView.this;
                                    nBPDeletePositionView9.showDeletePositionAlert$delegate.setValue(nBPDeletePositionView9, NBPDeletePositionView.$$delegatedProperties[1], Boolean.FALSE);
                                    NBPMainControlViewModel nBPMainControlViewModel2 = NBPDeletePositionView.this.controlViewModel;
                                    if (nBPMainControlViewModel2 == null) {
                                        Intrinsics.throwUninitializedPropertyAccessException("controlViewModel");
                                    } else {
                                        nBPMainControlViewModel = nBPMainControlViewModel2;
                                    }
                                    nBPMainControlViewModel.setShowDeletePositionActionSheet(false);
                                    e jsonWithMainPgParams2 = NearbyConstKt.jsonWithMainPgParams();
                                    jsonWithMainPgParams2.v("dt_eid", "em_nearby_location_clear_pop");
                                    jsonWithMainPgParams2.t("nearby_btn_type", 0);
                                    jsonWithMainPgParams2.v(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
                                    Utils.INSTANCE.currentBridgeModule().reportCustomDtEvent("dt_clck", jsonWithMainPgParams2);
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
        return new NBPDeletePositionViewAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new NBPDeletePositionViewEvent();
    }

    public final boolean getAnimated() {
        return ((Boolean) this.animated$delegate.getValue(this, $$delegatedProperties[0])).booleanValue();
    }

    public final void setAnimated(boolean z16) {
        this.animated$delegate.setValue(this, $$delegatedProperties[0], Boolean.valueOf(z16));
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final void viewDidLayout() {
        super.viewDidLayout();
        setAnimated(true);
    }
}
