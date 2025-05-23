package com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.hippykotlin.demo.pages.nearby.new_homepage.data.Tacit;
import com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view_model.NBPHomePageBaseViewModel;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.Direction;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.event.TouchParams;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.j;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.compose.ButtonView;
import com.tencent.kuikly.core.views.compose.a;
import com.tencent.kuikly.core.views.compose.b;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class TacitAgreementSingleBtnView extends ComposeView<TacitAgreementSingleBtnViewAttr, TacitAgreementSingleBtnViewEvent> {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(TacitAgreementSingleBtnView.class, "buttonTouchedDown", "getButtonTouchedDown()Z", 0)};
    public final ReadWriteProperty buttonTouchedDown$delegate = c.a(Boolean.FALSE);

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ TacitAgreementSingleBtnViewAttr access$getAttr(TacitAgreementSingleBtnView tacitAgreementSingleBtnView) {
        return (TacitAgreementSingleBtnViewAttr) tacitAgreementSingleBtnView.getAttr();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void access$report(TacitAgreementSingleBtnView tacitAgreementSingleBtnView) {
        Object obj;
        e eVar;
        NBPHomePageBaseViewModel nBPHomePageBaseViewModel = ((TacitAgreementSingleBtnViewAttr) tacitAgreementSingleBtnView.getAttr()).viewModel;
        if (nBPHomePageBaseViewModel != null) {
            e jsonWithHomePagePgParams = nBPHomePageBaseViewModel.jsonWithHomePagePgParams();
            jsonWithHomePagePgParams.v("dt_eid", "em_bas_multiple_choice");
            Tacit data = ((TacitAgreementSingleBtnViewAttr) tacitAgreementSingleBtnView.getAttr()).getData();
            Object obj2 = "";
            if (data == null) {
                obj = "";
            } else {
                obj = Integer.valueOf(data.answer);
            }
            jsonWithHomePagePgParams.v("answer_id", obj);
            Tacit data2 = ((TacitAgreementSingleBtnViewAttr) tacitAgreementSingleBtnView.getAttr()).getData();
            if (data2 != null) {
                obj2 = Integer.valueOf(data2.f114238id);
            }
            jsonWithHomePagePgParams.v("question_id", obj2);
            NBPHomePageBaseViewModel nBPHomePageBaseViewModel2 = ((TacitAgreementSingleBtnViewAttr) tacitAgreementSingleBtnView.getAttr()).viewModel;
            if (nBPHomePageBaseViewModel2 != null) {
                eVar = nBPHomePageBaseViewModel2.jsonWithHomePagePgParams();
            } else {
                eVar = new e();
            }
            jsonWithHomePagePgParams.v("cur_pg", eVar);
            jsonWithHomePagePgParams.v(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
            Utils.INSTANCE.currentBridgeModule().reportCustomDtEvent("dt_clck", jsonWithHomePagePgParams);
        }
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementSingleBtnView$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementSingleBtnView$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        mVar2.size(114.0f, 26.0f);
                        mVar2.marginBottom(4.0f);
                        return Unit.INSTANCE;
                    }
                });
                final TacitAgreementSingleBtnView tacitAgreementSingleBtnView = TacitAgreementSingleBtnView.this;
                com.tencent.kuikly.core.views.compose.c.a(viewContainer2, new Function1<ButtonView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementSingleBtnView$body$1.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ButtonView buttonView) {
                        ButtonView buttonView2 = buttonView;
                        final TacitAgreementSingleBtnView tacitAgreementSingleBtnView2 = TacitAgreementSingleBtnView.this;
                        buttonView2.attr(new Function1<a, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementSingleBtnView.body.1.2.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(a aVar) {
                                a aVar2 = aVar;
                                aVar2.m140flex(1.0f);
                                aVar2.borderRadius(4.0f);
                                TacitAgreementSingleBtnView tacitAgreementSingleBtnView3 = TacitAgreementSingleBtnView.this;
                                if (((Boolean) tacitAgreementSingleBtnView3.buttonTouchedDown$delegate.getValue(tacitAgreementSingleBtnView3, TacitAgreementSingleBtnView.$$delegatedProperties[0])).booleanValue()) {
                                    aVar2.mo135backgroundLinearGradient(Direction.TO_RIGHT, new j(new h(11884543L, 1.0f), 0.0f), new j(new h(7297023L, 1.0f), 1.0f));
                                } else {
                                    aVar2.mo135backgroundLinearGradient(Direction.TO_RIGHT, new j(new h(16777215L, 0.6f), 0.0f), new j(new h(16777215L, 0.4f), 1.0f));
                                }
                                final TacitAgreementSingleBtnView tacitAgreementSingleBtnView4 = TacitAgreementSingleBtnView.this;
                                aVar2.q(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementSingleBtnView.body.1.2.1.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ce ceVar) {
                                        h color$default;
                                        ce ceVar2 = ceVar;
                                        ceVar2.text(TacitAgreementSingleBtnView.access$getAttr(TacitAgreementSingleBtnView.this).btnText);
                                        ceVar2.textAlignCenter();
                                        ce.fontSize$default(ceVar2, 12.0f, null, 2, null);
                                        ceVar2.fontWeight400();
                                        TacitAgreementSingleBtnView tacitAgreementSingleBtnView5 = TacitAgreementSingleBtnView.this;
                                        if (((Boolean) tacitAgreementSingleBtnView5.buttonTouchedDown$delegate.getValue(tacitAgreementSingleBtnView5, TacitAgreementSingleBtnView.$$delegatedProperties[0])).booleanValue()) {
                                            color$default = QUIToken.color$default("text_allwhite_primary");
                                        } else {
                                            color$default = QUIToken.color$default("text_primary");
                                        }
                                        ceVar2.color(color$default);
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final TacitAgreementSingleBtnView tacitAgreementSingleBtnView3 = TacitAgreementSingleBtnView.this;
                        buttonView2.event(new Function1<b, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementSingleBtnView.body.1.2.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(b bVar) {
                                b bVar2 = bVar;
                                final TacitAgreementSingleBtnView tacitAgreementSingleBtnView4 = TacitAgreementSingleBtnView.this;
                                bVar2.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementSingleBtnView.body.1.2.2.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ClickParams clickParams) {
                                        Tacit data = TacitAgreementSingleBtnView.access$getAttr(TacitAgreementSingleBtnView.this).getData();
                                        if (data != null) {
                                            TacitAgreementSingleBtnView tacitAgreementSingleBtnView5 = TacitAgreementSingleBtnView.this;
                                            data.answer = TacitAgreementSingleBtnView.access$getAttr(tacitAgreementSingleBtnView5).index + 1;
                                            data.setShowAfter(true);
                                            NBPHomePageBaseViewModel nBPHomePageBaseViewModel = TacitAgreementSingleBtnView.access$getAttr(tacitAgreementSingleBtnView5).viewModel;
                                            if (nBPHomePageBaseViewModel != null) {
                                                nBPHomePageBaseViewModel.editTacit(data, data.status);
                                            }
                                        }
                                        TacitAgreementSingleBtnView.access$report(TacitAgreementSingleBtnView.this);
                                        return Unit.INSTANCE;
                                    }
                                });
                                final TacitAgreementSingleBtnView tacitAgreementSingleBtnView5 = TacitAgreementSingleBtnView.this;
                                bVar2.touchDown(new Function1<TouchParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementSingleBtnView.body.1.2.2.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(TouchParams touchParams) {
                                        TacitAgreementSingleBtnView tacitAgreementSingleBtnView6 = TacitAgreementSingleBtnView.this;
                                        tacitAgreementSingleBtnView6.buttonTouchedDown$delegate.setValue(tacitAgreementSingleBtnView6, TacitAgreementSingleBtnView.$$delegatedProperties[0], Boolean.TRUE);
                                        return Unit.INSTANCE;
                                    }
                                });
                                final TacitAgreementSingleBtnView tacitAgreementSingleBtnView6 = TacitAgreementSingleBtnView.this;
                                bVar2.touchUp(new Function1<TouchParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementSingleBtnView.body.1.2.2.3
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(TouchParams touchParams) {
                                        TacitAgreementSingleBtnView tacitAgreementSingleBtnView7 = TacitAgreementSingleBtnView.this;
                                        tacitAgreementSingleBtnView7.buttonTouchedDown$delegate.setValue(tacitAgreementSingleBtnView7, TacitAgreementSingleBtnView.$$delegatedProperties[0], Boolean.FALSE);
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
        return new TacitAgreementSingleBtnViewAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new TacitAgreementSingleBtnViewEvent();
    }
}
