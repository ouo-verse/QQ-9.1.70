package com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement;

import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.base.extension.PageDataExtKt;
import com.tencent.hippykotlin.demo.pages.nearby.new_homepage.data.Tacit;
import com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view_model.NBPHomePageBaseViewModel;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.event.VisibilityEventKt;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.layout.FlexWrap;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.internal.GroupAttr;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class TacitAgreementSelectContentView extends ComposeView<TacitAgreementSelectContentViewAttr, TacitAgreementSelectContentViewEvent> {
    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ TacitAgreementSelectContentViewAttr access$getAttr(TacitAgreementSelectContentView tacitAgreementSelectContentView) {
        return (TacitAgreementSelectContentViewAttr) tacitAgreementSelectContentView.getAttr();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void access$report(TacitAgreementSelectContentView tacitAgreementSelectContentView) {
        Object obj;
        e eVar;
        NBPHomePageBaseViewModel nBPHomePageBaseViewModel = ((TacitAgreementSelectContentViewAttr) tacitAgreementSelectContentView.getAttr()).viewModel;
        if (nBPHomePageBaseViewModel != null) {
            e jsonWithHomePagePgParams = nBPHomePageBaseViewModel.jsonWithHomePagePgParams();
            jsonWithHomePagePgParams.v("dt_eid", "em_bas_multiple_choice_question");
            Tacit data = ((TacitAgreementSelectContentViewAttr) tacitAgreementSelectContentView.getAttr()).getData();
            if (data != null) {
                obj = Integer.valueOf(data.f114238id);
            } else {
                obj = "";
            }
            jsonWithHomePagePgParams.v("question_id", obj);
            NBPHomePageBaseViewModel nBPHomePageBaseViewModel2 = ((TacitAgreementSelectContentViewAttr) tacitAgreementSelectContentView.getAttr()).viewModel;
            if (nBPHomePageBaseViewModel2 != null) {
                eVar = nBPHomePageBaseViewModel2.jsonWithHomePagePgParams();
            } else {
                eVar = new e();
            }
            jsonWithHomePagePgParams.v("cur_pg", eVar);
            jsonWithHomePagePgParams.v(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
            Utils.INSTANCE.currentBridgeModule().reportCustomDtEvent("dt_imp", jsonWithHomePagePgParams);
        }
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementSelectContentView$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementSelectContentView$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        mVar2.m140flex(1.0f);
                        mVar2.mo153width(264.0f);
                        return Unit.INSTANCE;
                    }
                });
                final TacitAgreementSelectContentView tacitAgreementSelectContentView = TacitAgreementSelectContentView.this;
                viewContainer2.event(new Function1<Event, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementSelectContentView$body$1.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Event event) {
                        final TacitAgreementSelectContentView tacitAgreementSelectContentView2 = TacitAgreementSelectContentView.this;
                        VisibilityEventKt.b(event, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementSelectContentView.body.1.2.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(Object obj) {
                                TacitAgreementSelectContentView.access$report(TacitAgreementSelectContentView.this);
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final TacitAgreementSelectContentView tacitAgreementSelectContentView2 = TacitAgreementSelectContentView.this;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementSelectContentView$body$1.3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementSelectContentView.body.1.3.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.m140flex(1.0f);
                                tVar2.borderRadius(12.0f);
                                tVar2.flexDirectionColumn();
                                tVar2.allCenter();
                                if (PageDataExtKt.isNightMode(tVar2.getPagerData())) {
                                    GroupAttr.backgroundImage$default(tVar2, "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_hcCnrC45w4O.png", null, 2, null);
                                } else {
                                    GroupAttr.backgroundImage$default(tVar2, "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_Yo9Tz3tYbpu.png", null, 2, null);
                                }
                                return Unit.INSTANCE;
                            }
                        });
                        final TacitAgreementSelectContentView tacitAgreementSelectContentView3 = TacitAgreementSelectContentView.this;
                        cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementSelectContentView.body.1.3.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(TextView textView) {
                                final TacitAgreementSelectContentView tacitAgreementSelectContentView4 = TacitAgreementSelectContentView.this;
                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementSelectContentView.body.1.3.2.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ce ceVar) {
                                        String str;
                                        ce ceVar2 = ceVar;
                                        ceVar2.positionAbsolute();
                                        ceVar2.mo153width(232.0f);
                                        ceVar2.m142left(16.0f);
                                        ceVar2.m150top(16.0f);
                                        if (PageDataExtKt.isNightMode(ceVar2.getPagerData())) {
                                            ceVar2.color(h.INSTANCE.m());
                                        } else {
                                            ceVar2.color(new h(5849456L, 1.0f));
                                        }
                                        Tacit data = TacitAgreementSelectContentView.access$getAttr(TacitAgreementSelectContentView.this).getData();
                                        if (data == null || (str = data.question) == null) {
                                            str = "";
                                        }
                                        ceVar2.text(str);
                                        ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                        ceVar2.fontWeight500();
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final TacitAgreementSelectContentView tacitAgreementSelectContentView4 = TacitAgreementSelectContentView.this;
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementSelectContentView.body.1.3.3
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                List<String> list;
                                v vVar4 = vVar3;
                                vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementSelectContentView.body.1.3.3.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.flexDirectionRow();
                                        tVar2.positionAbsolute();
                                        tVar2.mo153width(232.0f);
                                        tVar2.mo141height(100.0f);
                                        tVar2.m142left(16.0f);
                                        tVar2.m150top(60.0f);
                                        tVar2.flexWrap(FlexWrap.WRAP);
                                        tVar2.justifyContentSpaceBetween();
                                        return Unit.INSTANCE;
                                    }
                                });
                                Tacit data = TacitAgreementSelectContentView.access$getAttr(TacitAgreementSelectContentView.this).getData();
                                if (data != null && (list = data.options) != null) {
                                    final TacitAgreementSelectContentView tacitAgreementSelectContentView5 = TacitAgreementSelectContentView.this;
                                    final int i3 = 0;
                                    for (Object obj : list) {
                                        int i16 = i3 + 1;
                                        if (i3 < 0) {
                                            CollectionsKt__CollectionsKt.throwIndexOverflow();
                                        }
                                        final String str = (String) obj;
                                        vVar4.addChild(new TacitAgreementSingleBtnView(), new Function1<TacitAgreementSingleBtnView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementSelectContentView$body$1$3$3$2$1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(TacitAgreementSingleBtnView tacitAgreementSingleBtnView) {
                                                final int i17 = i3;
                                                final String str2 = str;
                                                final TacitAgreementSelectContentView tacitAgreementSelectContentView6 = tacitAgreementSelectContentView5;
                                                tacitAgreementSingleBtnView.attr(new Function1<TacitAgreementSingleBtnViewAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementSelectContentView$body$1$3$3$2$1.1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(TacitAgreementSingleBtnViewAttr tacitAgreementSingleBtnViewAttr) {
                                                        TacitAgreementSingleBtnViewAttr tacitAgreementSingleBtnViewAttr2 = tacitAgreementSingleBtnViewAttr;
                                                        tacitAgreementSingleBtnViewAttr2.index = i17;
                                                        tacitAgreementSingleBtnViewAttr2.btnText = str2;
                                                        tacitAgreementSingleBtnViewAttr2.data$delegate.setValue(tacitAgreementSingleBtnViewAttr2, TacitAgreementSingleBtnViewAttr.$$delegatedProperties[0], TacitAgreementSelectContentView.access$getAttr(tacitAgreementSelectContentView6).getData());
                                                        tacitAgreementSingleBtnViewAttr2.viewModel = TacitAgreementSelectContentView.access$getAttr(tacitAgreementSelectContentView6).viewModel;
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        i3 = i16;
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
        return new TacitAgreementSelectContentViewAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new TacitAgreementSelectContentViewEvent();
    }
}
