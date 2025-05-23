package com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement;

import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedItemView$body$1$3$3$3$3$1$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.nearby.base.utils.FastClickUtils;
import com.tencent.hippykotlin.demo.pages.nearby.new_homepage.data.Tacit;
import com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view_model.NBPHomePageBaseViewModel;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.reactive.collection.c;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.TextEvent;
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
import kotlin.jvm.functions.Function1;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class TacitAgreementTitleView extends ComposeView<TacitAgreementTitleAttr, TacitAgreementTitleEvent> {
    public final FastClickUtils fastClickUtils = new FastClickUtils(500);

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ TacitAgreementTitleAttr access$getAttr(TacitAgreementTitleView tacitAgreementTitleView) {
        return (TacitAgreementTitleAttr) tacitAgreementTitleView.getAttr();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void access$historyReport(TacitAgreementTitleView tacitAgreementTitleView) {
        e eVar;
        NBPHomePageBaseViewModel nBPHomePageBaseViewModel = ((TacitAgreementTitleAttr) tacitAgreementTitleView.getAttr()).viewModel;
        if (nBPHomePageBaseViewModel != null) {
            e jsonWithHomePagePgParams = nBPHomePageBaseViewModel.jsonWithHomePagePgParams();
            jsonWithHomePagePgParams.v("dt_eid", "em_kl_tacit_answer_more");
            NBPHomePageBaseViewModel nBPHomePageBaseViewModel2 = ((TacitAgreementTitleAttr) tacitAgreementTitleView.getAttr()).viewModel;
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

    /* JADX WARN: Multi-variable type inference failed */
    public static final void access$titleReport(TacitAgreementTitleView tacitAgreementTitleView) {
        NBPHomePageBaseViewModel nBPHomePageBaseViewModel;
        e eVar;
        NBPHomePageBaseViewModel nBPHomePageBaseViewModel2 = ((TacitAgreementTitleAttr) tacitAgreementTitleView.getAttr()).viewModel;
        c<Tacit> tacitMyList = nBPHomePageBaseViewModel2 != null ? nBPHomePageBaseViewModel2.getTacitMyList() : null;
        NBPHomePageBaseViewModel nBPHomePageBaseViewModel3 = ((TacitAgreementTitleAttr) tacitAgreementTitleView.getAttr()).viewModel;
        Integer valueOf = nBPHomePageBaseViewModel3 != null ? Integer.valueOf(nBPHomePageBaseViewModel3.tacitListTodaySize) : null;
        int i3 = 1;
        if (!(tacitMyList == null || tacitMyList.isEmpty())) {
            i3 = (valueOf != null && valueOf.intValue() == 0) ? 2 : -1;
        }
        if (i3 == -1 || (nBPHomePageBaseViewModel = ((TacitAgreementTitleAttr) tacitAgreementTitleView.getAttr()).viewModel) == null) {
            return;
        }
        e jsonWithHomePagePgParams = nBPHomePageBaseViewModel.jsonWithHomePagePgParams();
        jsonWithHomePagePgParams.v("dt_eid", "em_bas_tacit_answer_empty_state");
        jsonWithHomePagePgParams.t("status", i3);
        NBPHomePageBaseViewModel nBPHomePageBaseViewModel4 = ((TacitAgreementTitleAttr) tacitAgreementTitleView.getAttr()).viewModel;
        if (nBPHomePageBaseViewModel4 != null) {
            eVar = nBPHomePageBaseViewModel4.jsonWithHomePagePgParams();
        } else {
            eVar = new e();
        }
        jsonWithHomePagePgParams.v("cur_pg", eVar);
        jsonWithHomePagePgParams.v(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
        Utils.INSTANCE.currentBridgeModule().reportCustomDtEvent("dt_imp", jsonWithHomePagePgParams);
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementTitleView$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementTitleView$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        mVar2.flexDirectionColumn();
                        mVar2.mo153width(mVar2.getPagerData().m());
                        mVar2.mo113backgroundColor(QUIToken.color$default("bg_bottom_light"));
                        return Unit.INSTANCE;
                    }
                });
                final TacitAgreementTitleView tacitAgreementTitleView = TacitAgreementTitleView.this;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementTitleView$body$1.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementTitleView.body.1.2.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.flexDirectionRow();
                                tVar2.alignItemsCenter();
                                tVar2.mo141height(48.0f);
                                tVar2.positionRelative();
                                return Unit.INSTANCE;
                            }
                        });
                        final TacitAgreementTitleView tacitAgreementTitleView2 = TacitAgreementTitleView.this;
                        cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementTitleView.body.1.2.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(TextView textView) {
                                TextView textView2 = textView;
                                final TacitAgreementTitleView tacitAgreementTitleView3 = TacitAgreementTitleView.this;
                                textView2.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementTitleView.body.1.2.2.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ce ceVar) {
                                        String str;
                                        c<Tacit> tacitMyList;
                                        ce ceVar2 = ceVar;
                                        ceVar2.marginLeft(16.0f);
                                        ceVar2.fontWeight400();
                                        NBPArticleFeedItemView$body$1$3$3$3$3$1$1$$ExternalSyntheticOutline0.m(ceVar2, 14.0f, null, 2, null, "text_primary");
                                        NBPHomePageBaseViewModel nBPHomePageBaseViewModel = TacitAgreementTitleView.access$getAttr(TacitAgreementTitleView.this).viewModel;
                                        boolean z16 = false;
                                        if ((nBPHomePageBaseViewModel == null || (tacitMyList = nBPHomePageBaseViewModel.getTacitMyList()) == null || !tacitMyList.isEmpty()) ? false : true) {
                                            str = "\u4f60\u5df2\u5b8c\u6210\u4eca\u65e5\u9ed8\u5951\u95ee\u7b54";
                                        } else {
                                            str = "\u9ed8\u5951\u95ee\u7b54";
                                        }
                                        NBPHomePageBaseViewModel nBPHomePageBaseViewModel2 = TacitAgreementTitleView.access$getAttr(TacitAgreementTitleView.this).viewModel;
                                        if (nBPHomePageBaseViewModel2 != null && nBPHomePageBaseViewModel2.tacitListTodaySize == 0) {
                                            z16 = true;
                                        }
                                        if (z16) {
                                            str = "\u4f60\u5df2\u5b8c\u6210\u5168\u90e8\u9ed8\u5951\u95ee\u7b54";
                                        }
                                        ceVar2.text(str);
                                        TacitAgreementTitleView.access$titleReport(TacitAgreementTitleView.this);
                                        return Unit.INSTANCE;
                                    }
                                });
                                textView2.event(new Function1<TextEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementTitleView.body.1.2.2.2
                                    @Override // kotlin.jvm.functions.Function1
                                    public final /* bridge */ /* synthetic */ Unit invoke(TextEvent textEvent) {
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final TacitAgreementTitleView tacitAgreementTitleView3 = TacitAgreementTitleView.this;
                        vVar2.addChild(new TacitAgreementFirstBubbleTipView(), new Function1<TacitAgreementFirstBubbleTipView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementTitleView.body.1.2.3
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(TacitAgreementFirstBubbleTipView tacitAgreementFirstBubbleTipView) {
                                final TacitAgreementTitleView tacitAgreementTitleView4 = TacitAgreementTitleView.this;
                                tacitAgreementFirstBubbleTipView.attr(new Function1<TacitAgreementFirstBubbleTipAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementTitleView.body.1.2.3.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(TacitAgreementFirstBubbleTipAttr tacitAgreementFirstBubbleTipAttr) {
                                        TacitAgreementFirstBubbleTipAttr tacitAgreementFirstBubbleTipAttr2 = tacitAgreementFirstBubbleTipAttr;
                                        tacitAgreementFirstBubbleTipAttr2.m140flex(1.0f);
                                        tacitAgreementFirstBubbleTipAttr2.viewModel = TacitAgreementTitleView.access$getAttr(TacitAgreementTitleView.this).viewModel;
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        ah.a(vVar2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementTitleView.body.1.2.4
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ImageView imageView) {
                                imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementTitleView.body.1.2.4.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(af afVar) {
                                        af afVar2 = afVar;
                                        afVar2.size(16.0f, 16.0f);
                                        afVar2.alignSelfCenter();
                                        afVar2.marginRight(20.0f);
                                        b.a.b(afVar2, "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_61nMOVP2eUb.png", false, 2, null);
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final TacitAgreementTitleView tacitAgreementTitleView4 = TacitAgreementTitleView.this;
                        vVar2.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementTitleView.body.1.2.5
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(u uVar) {
                                final TacitAgreementTitleView tacitAgreementTitleView5 = TacitAgreementTitleView.this;
                                uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementTitleView.body.1.2.5.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ClickParams clickParams) {
                                        Object obj;
                                        if (!TacitAgreementTitleView.this.fastClickUtils.isFastDoubleClick()) {
                                            NBPHomePageBaseViewModel nBPHomePageBaseViewModel = TacitAgreementTitleView.access$getAttr(TacitAgreementTitleView.this).viewModel;
                                            if (nBPHomePageBaseViewModel == null || (obj = nBPHomePageBaseViewModel.accountId) == null) {
                                                obj = 0;
                                            }
                                            NBPHomePageBaseViewModel nBPHomePageBaseViewModel2 = TacitAgreementTitleView.access$getAttr(TacitAgreementTitleView.this).viewModel;
                                            int appId = nBPHomePageBaseViewModel2 != null ? nBPHomePageBaseViewModel2.getAppId() : 0;
                                            QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
                                            QQKuiklyPlatformApi.Companion.openPage$default("https://ti.qq.com/qq-stranger/question/index.html?_wv=3&account_id=" + obj + "&page_type=" + appId, false, 6);
                                            NBPHomePageBaseViewModel nBPHomePageBaseViewModel3 = TacitAgreementTitleView.access$getAttr(TacitAgreementTitleView.this).viewModel;
                                            if (nBPHomePageBaseViewModel3 != null) {
                                                nBPHomePageBaseViewModel3.hasJumpTacitH5 = true;
                                            }
                                            TacitAgreementTitleView.access$historyReport(TacitAgreementTitleView.this);
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
        };
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return new TacitAgreementTitleAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new TacitAgreementTitleEvent();
    }
}
