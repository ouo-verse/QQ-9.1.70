package com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.AgreementConsentViewKt$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.foundation.module.CacheModule;
import com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedItemView$body$1$3$3$3$3$1$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.nearby.new_homepage.data.Tacit;
import com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view_model.FetchStatus;
import com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view_model.NBPHomePageBaseViewModel;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.event.VisibilityEventKt;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
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
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class TacitAgreementFirstBubbleTipView extends ComposeView<TacitAgreementFirstBubbleTipAttr, TacitAgreementFirstBubbleTipEvent> {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(TacitAgreementFirstBubbleTipView.class, "disMiss", "getDisMiss()Z", 0)};
    public final ReadWriteProperty disMiss$delegate = c.a(Boolean.FALSE);

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ TacitAgreementFirstBubbleTipAttr access$getAttr(TacitAgreementFirstBubbleTipView tacitAgreementFirstBubbleTipView) {
        return (TacitAgreementFirstBubbleTipAttr) tacitAgreementFirstBubbleTipView.getAttr();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void access$report(TacitAgreementFirstBubbleTipView tacitAgreementFirstBubbleTipView) {
        e eVar;
        NBPHomePageBaseViewModel nBPHomePageBaseViewModel = ((TacitAgreementFirstBubbleTipAttr) tacitAgreementFirstBubbleTipView.getAttr()).viewModel;
        if (nBPHomePageBaseViewModel != null) {
            e jsonWithHomePagePgParams = nBPHomePageBaseViewModel.jsonWithHomePagePgParams();
            jsonWithHomePagePgParams.v("dt_eid", "em_bas_lead_toast");
            NBPHomePageBaseViewModel nBPHomePageBaseViewModel2 = ((TacitAgreementFirstBubbleTipAttr) tacitAgreementFirstBubbleTipView.getAttr()).viewModel;
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

    /* JADX WARN: Multi-variable type inference failed */
    public static final boolean access$showBubbleView(TacitAgreementFirstBubbleTipView tacitAgreementFirstBubbleTipView) {
        NBPHomePageBaseViewModel nBPHomePageBaseViewModel;
        String str;
        com.tencent.kuikly.core.reactive.collection.c<Tacit> tacitMyList;
        if (((Boolean) tacitAgreementFirstBubbleTipView.disMiss$delegate.getValue(tacitAgreementFirstBubbleTipView, $$delegatedProperties[0])).booleanValue()) {
            return false;
        }
        NBPHomePageBaseViewModel nBPHomePageBaseViewModel2 = ((TacitAgreementFirstBubbleTipAttr) tacitAgreementFirstBubbleTipView.getAttr()).viewModel;
        if ((nBPHomePageBaseViewModel2 != null ? (FetchStatus) nBPHomePageBaseViewModel2.tacitState$delegate.getValue(nBPHomePageBaseViewModel2, NBPHomePageBaseViewModel.$$delegatedProperties[4]) : null) != FetchStatus.FETCH_STATE_SUCCESS) {
            return false;
        }
        NBPHomePageBaseViewModel nBPHomePageBaseViewModel3 = ((TacitAgreementFirstBubbleTipAttr) tacitAgreementFirstBubbleTipView.getAttr()).viewModel;
        if ((nBPHomePageBaseViewModel3 == null || (tacitMyList = nBPHomePageBaseViewModel3.getTacitMyList()) == null || !tacitMyList.isEmpty()) ? false : true) {
            return false;
        }
        NBPHomePageBaseViewModel nBPHomePageBaseViewModel4 = ((TacitAgreementFirstBubbleTipAttr) tacitAgreementFirstBubbleTipView.getAttr()).viewModel;
        if ((nBPHomePageBaseViewModel4 != null && nBPHomePageBaseViewModel4.tacitListTodaySize == 0) || (nBPHomePageBaseViewModel = ((TacitAgreementFirstBubbleTipAttr) tacitAgreementFirstBubbleTipView.getAttr()).viewModel) == null || (str = nBPHomePageBaseViewModel.accountId) == null) {
            return false;
        }
        Integer num = ((CacheModule) com.tencent.kuikly.core.manager.c.f117352a.g().acquireModule("HRCacheModule")).getInt("homepage_tacit_first_visit_" + str);
        return num == null || num.intValue() != 1;
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementFirstBubbleTipView$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementFirstBubbleTipView$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        mVar.flexDirectionColumn();
                        return Unit.INSTANCE;
                    }
                });
                final TacitAgreementFirstBubbleTipView tacitAgreementFirstBubbleTipView = TacitAgreementFirstBubbleTipView.this;
                Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementFirstBubbleTipView$body$1.2
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Boolean.valueOf(TacitAgreementFirstBubbleTipView.access$showBubbleView(TacitAgreementFirstBubbleTipView.this));
                    }
                };
                final TacitAgreementFirstBubbleTipView tacitAgreementFirstBubbleTipView2 = TacitAgreementFirstBubbleTipView.this;
                ConditionViewKt.c(viewContainer2, function0, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementFirstBubbleTipView$body$1.3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ConditionView conditionView) {
                        final TacitAgreementFirstBubbleTipView tacitAgreementFirstBubbleTipView3 = TacitAgreementFirstBubbleTipView.this;
                        w.a(conditionView, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementFirstBubbleTipView.body.1.3.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar) {
                                v vVar2 = vVar;
                                vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementFirstBubbleTipView.body.1.3.1.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.flexDirectionRow();
                                        tVar2.alignItemsCenter();
                                        tVar2.mo141height(34.0f);
                                        tVar2.marginLeft(8.0f);
                                        return Unit.INSTANCE;
                                    }
                                });
                                ah.a(vVar2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementFirstBubbleTipView.body.1.3.1.2
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ImageView imageView) {
                                        imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementFirstBubbleTipView.body.1.3.1.2.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(af afVar) {
                                                af afVar2 = afVar;
                                                afVar2.size(5.0f, 11.0f);
                                                b.a.b(afVar2, "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_EXe6pcsJC87.png", false, 2, null);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final TacitAgreementFirstBubbleTipView tacitAgreementFirstBubbleTipView4 = TacitAgreementFirstBubbleTipView.this;
                                w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementFirstBubbleTipView.body.1.3.1.3
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar3) {
                                        v vVar4 = vVar3;
                                        vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementFirstBubbleTipView.body.1.3.1.3.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                t tVar2 = tVar;
                                                tVar2.mo141height(34.0f);
                                                tVar2.mo113backgroundColor(new h(0L, 0.7f));
                                                tVar2.borderRadius(4.0f);
                                                tVar2.paddingLeft(10.0f);
                                                tVar2.paddingRight(10.0f);
                                                tVar2.allCenter();
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final TacitAgreementFirstBubbleTipView tacitAgreementFirstBubbleTipView5 = TacitAgreementFirstBubbleTipView.this;
                                        cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementFirstBubbleTipView.body.1.3.1.3.2
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(TextView textView) {
                                                final TacitAgreementFirstBubbleTipView tacitAgreementFirstBubbleTipView6 = TacitAgreementFirstBubbleTipView.this;
                                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementFirstBubbleTipView.body.1.3.1.3.2.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ce ceVar) {
                                                        com.tencent.kuikly.core.reactive.collection.c<Tacit> tacitMyList;
                                                        ce ceVar2 = ceVar;
                                                        NBPArticleFeedItemView$body$1$3$3$3$3$1$1$$ExternalSyntheticOutline0.m(ceVar2, 12.0f, null, 2, null, "text_allwhite_primary");
                                                        NBPHomePageBaseViewModel nBPHomePageBaseViewModel = TacitAgreementFirstBubbleTipView.access$getAttr(TacitAgreementFirstBubbleTipView.this).viewModel;
                                                        ceVar2.text("\u56de\u7b54" + ((nBPHomePageBaseViewModel == null || (tacitMyList = nBPHomePageBaseViewModel.getTacitMyList()) == null) ? 6 : tacitMyList.size()) + "\u9898\uff0c\u67e5\u770b\u4f60\u548c\u4ed6\u4eba\u7684\u9ed8\u5951\u5ea6");
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final TacitAgreementFirstBubbleTipView tacitAgreementFirstBubbleTipView6 = TacitAgreementFirstBubbleTipView.this;
                                        vVar4.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementFirstBubbleTipView.body.1.3.1.3.3
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(u uVar) {
                                                final TacitAgreementFirstBubbleTipView tacitAgreementFirstBubbleTipView7 = TacitAgreementFirstBubbleTipView.this;
                                                VisibilityEventKt.b(uVar, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementFirstBubbleTipView.body.1.3.1.3.3.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(Object obj) {
                                                        String str;
                                                        NBPHomePageBaseViewModel nBPHomePageBaseViewModel = TacitAgreementFirstBubbleTipView.access$getAttr(TacitAgreementFirstBubbleTipView.this).viewModel;
                                                        if (nBPHomePageBaseViewModel != null && (str = nBPHomePageBaseViewModel.accountId) != null) {
                                                            ((CacheModule) com.tencent.kuikly.core.manager.c.f117352a.g().acquireModule("HRCacheModule")).setInt(AgreementConsentViewKt$$ExternalSyntheticOutline0.m("homepage_tacit_first_visit_", str), 1);
                                                        }
                                                        final TacitAgreementFirstBubbleTipView tacitAgreementFirstBubbleTipView8 = TacitAgreementFirstBubbleTipView.this;
                                                        TimerKt.c(3000, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementFirstBubbleTipView.body.1.3.1.3.3.1.2
                                                            {
                                                                super(0);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function0
                                                            public final Unit invoke() {
                                                                TacitAgreementFirstBubbleTipView tacitAgreementFirstBubbleTipView9 = TacitAgreementFirstBubbleTipView.this;
                                                                tacitAgreementFirstBubbleTipView9.disMiss$delegate.setValue(tacitAgreementFirstBubbleTipView9, TacitAgreementFirstBubbleTipView.$$delegatedProperties[0], Boolean.TRUE);
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        TacitAgreementFirstBubbleTipView.access$report(TacitAgreementFirstBubbleTipView.this);
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
        return new TacitAgreementFirstBubbleTipAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new TacitAgreementFirstBubbleTipEvent();
    }
}
