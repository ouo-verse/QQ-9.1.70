package com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement;

import c01.c;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.AgreementConsentViewKt$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.foundation.module.CacheModule;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedItemView$body$1$3$3$3$3$1$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view_model.NBPHomePageBaseViewModel;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.BorderStyle;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.Direction;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.event.VisibilityEventKt;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.j;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ah;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.compose.ButtonView;
import com.tencent.kuikly.core.views.compose.a;
import com.tencent.kuikly.core.views.t;
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
public final class TacitFaqView extends ComposeView<TacitFaqAttr, TacitFaqEvent> {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(TacitFaqView.class, "inviteClick", "getInviteClick()Z", 0)};
    public final ReadWriteProperty inviteClick$delegate = c.a(Boolean.FALSE);

    /* JADX WARN: Multi-variable type inference failed */
    public static final boolean access$alreadyInvite(TacitFaqView tacitFaqView) {
        String str;
        NBPHomePageBaseViewModel nBPHomePageBaseViewModel = ((TacitFaqAttr) tacitFaqView.getAttr()).viewModel;
        if (nBPHomePageBaseViewModel != null && (str = nBPHomePageBaseViewModel.accountId) != null) {
            Integer num = ((CacheModule) com.tencent.kuikly.core.manager.c.f117352a.g().acquireModule("HRCacheModule")).getInt("homepage_invite_friend_to_answer_tacit_" + str);
            if (num != null && num.intValue() == 1) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void access$btnReport(TacitFaqView tacitFaqView, String str, int i3) {
        e eVar;
        NBPHomePageBaseViewModel nBPHomePageBaseViewModel = ((TacitFaqAttr) tacitFaqView.getAttr()).viewModel;
        if (nBPHomePageBaseViewModel != null) {
            e jsonWithHomePagePgParams = nBPHomePageBaseViewModel.jsonWithHomePagePgParams();
            jsonWithHomePagePgParams.v("dt_eid", "em_bas_invite_tost");
            jsonWithHomePagePgParams.t(PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, i3);
            NBPHomePageBaseViewModel nBPHomePageBaseViewModel2 = ((TacitFaqAttr) tacitFaqView.getAttr()).viewModel;
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

    /* JADX WARN: Multi-variable type inference failed */
    public static final void access$doInvite(TacitFaqView tacitFaqView) {
        String str;
        NBPHomePageBaseViewModel nBPHomePageBaseViewModel = ((TacitFaqAttr) tacitFaqView.getAttr()).viewModel;
        if (nBPHomePageBaseViewModel != null) {
            nBPHomePageBaseViewModel.openAio(tacitFaqView.getPagerData().n(), 1);
        }
        NBPHomePageBaseViewModel nBPHomePageBaseViewModel2 = ((TacitFaqAttr) tacitFaqView.getAttr()).viewModel;
        if (nBPHomePageBaseViewModel2 != null && (str = nBPHomePageBaseViewModel2.accountId) != null) {
            ((CacheModule) com.tencent.kuikly.core.manager.c.f117352a.g().acquireModule("HRCacheModule")).setInt(AgreementConsentViewKt$$ExternalSyntheticOutline0.m("homepage_invite_friend_to_answer_tacit_", str), 1);
        }
        tacitFaqView.inviteClick$delegate.setValue(tacitFaqView, $$delegatedProperties[0], Boolean.TRUE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ TacitFaqAttr access$getAttr(TacitFaqView tacitFaqView) {
        return (TacitFaqAttr) tacitFaqView.getAttr();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitFaqView$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitFaqView$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        mVar2.flexDirectionColumn();
                        mVar2.mo153width(mVar2.getPagerData().m());
                        mVar2.mo113backgroundColor(QUIToken.color$default("bg_bottom_light"));
                        return Unit.INSTANCE;
                    }
                });
                final TacitFaqView tacitFaqView = TacitFaqView.this;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitFaqView$body$1.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitFaqView.body.1.2.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.m140flex(1.0f);
                                tVar2.marginLeft(16.0f);
                                tVar2.marginRight(16.0f);
                                tVar2.marginBottom(10.0f);
                                tVar2.mo141height(62.0f);
                                tVar2.borderRadius(8.0f);
                                tVar2.flexDirectionRow();
                                tVar2.allCenter();
                                tVar2.justifyContentSpaceBetween();
                                if (com.tencent.kuikly.core.manager.c.f117352a.g().isNightMode()) {
                                    tVar2.mo135backgroundLinearGradient(Direction.TO_RIGHT, new j(new h(2236468L, 1.0f), 1.0f), new j(new h(1644831L, 1.0f), 1.0f));
                                } else {
                                    tVar2.mo135backgroundLinearGradient(Direction.TO_RIGHT, new j(new h(16315391L, 1.0f), 1.0f), new j(new h(16644863L, 1.0f), 1.0f));
                                }
                                return Unit.INSTANCE;
                            }
                        });
                        final TacitFaqView tacitFaqView2 = TacitFaqView.this;
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitFaqView.body.1.2.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                v vVar4 = vVar3;
                                vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitFaqView.body.1.2.2.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.flexDirectionRow();
                                        tVar2.alignItemsCenter();
                                        tVar2.marginLeft(16.0f);
                                        return Unit.INSTANCE;
                                    }
                                });
                                ah.a(vVar4, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitFaqView.body.1.2.2.2
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ImageView imageView) {
                                        imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitFaqView.body.1.2.2.2.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(af afVar) {
                                                af afVar2 = afVar;
                                                afVar2.size(42.0f, 34.0f);
                                                b.a.b(afVar2, "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_UYFWZk4IHXz.png", false, 2, null);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final TacitFaqView tacitFaqView3 = TacitFaqView.this;
                                cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitFaqView.body.1.2.2.3
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(TextView textView) {
                                        final TacitFaqView tacitFaqView4 = TacitFaqView.this;
                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitFaqView.body.1.2.2.3.1
                                            {
                                                super(1);
                                            }

                                            /* JADX WARN: Code restructure failed: missing block: B:4:0x0020, code lost:
                                            
                                                if (r0.tacitFaqOwnerNotAnswer() == true) goto L8;
                                             */
                                            @Override // kotlin.jvm.functions.Function1
                                            /*
                                                Code decompiled incorrectly, please refer to instructions dump.
                                            */
                                            public final Unit invoke(ce ceVar) {
                                                String str;
                                                ce ceVar2 = ceVar;
                                                ceVar2.marginLeft(10.0f);
                                                ceVar2.color(QUIToken.color$default("text_primary"));
                                                NBPHomePageBaseViewModel nBPHomePageBaseViewModel = TacitFaqView.access$getAttr(TacitFaqView.this).viewModel;
                                                boolean z16 = nBPHomePageBaseViewModel != null;
                                                if (z16) {
                                                    str = "\u586b\u5199\u9ed8\u5951\u95ee\u7b54\u5373\u53ef\u89e3\u9501";
                                                } else {
                                                    str = "\u9080\u8bf7TA\u586b\u5199\u9ed8\u5951\u95ee\u7b54\n\u5373\u53ef\u89e3\u9501";
                                                }
                                                ceVar2.text(str);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final TacitFaqView tacitFaqView3 = TacitFaqView.this;
                        Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitFaqView.body.1.2.3
                            {
                                super(0);
                            }

                            /* JADX WARN: Code restructure failed: missing block: B:4:0x000f, code lost:
                            
                                if (r0.tacitFaqOwnerNotAnswer() == true) goto L8;
                             */
                            @Override // kotlin.jvm.functions.Function0
                            /*
                                Code decompiled incorrectly, please refer to instructions dump.
                            */
                            public final Object invoke() {
                                NBPHomePageBaseViewModel nBPHomePageBaseViewModel = TacitFaqView.access$getAttr(TacitFaqView.this).viewModel;
                                boolean z16 = nBPHomePageBaseViewModel != null;
                                return Boolean.valueOf(z16);
                            }
                        };
                        final TacitFaqView tacitFaqView4 = TacitFaqView.this;
                        ConditionViewKt.c(vVar2, function0, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitFaqView.body.1.2.4
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ConditionView conditionView) {
                                final TacitFaqView tacitFaqView5 = TacitFaqView.this;
                                com.tencent.kuikly.core.views.compose.c.a(conditionView, new Function1<ButtonView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitFaqView.body.1.2.4.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ButtonView buttonView) {
                                        ButtonView buttonView2 = buttonView;
                                        buttonView2.attr(new Function1<a, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitFaqView.body.1.2.4.1.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(a aVar) {
                                                a aVar2 = aVar;
                                                aVar2.marginRight(16.0f);
                                                aVar2.size(60.0f, 29.0f);
                                                aVar2.borderRadius(4.0f);
                                                aVar2.m136border(new com.tencent.kuikly.core.base.e(1.0f, BorderStyle.SOLID, QUIToken.color$default("border_standard")));
                                                aVar2.q(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitFaqView.body.1.2.4.1.1.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ce ceVar) {
                                                        ce ceVar2 = ceVar;
                                                        ceVar2.text("\u586b\u5199");
                                                        NBPArticleFeedItemView$body$1$3$3$3$3$1$1$$ExternalSyntheticOutline0.m(ceVar2, 14.0f, null, 2, null, "text_primary");
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final TacitFaqView tacitFaqView6 = TacitFaqView.this;
                                        buttonView2.event(new Function1<com.tencent.kuikly.core.views.compose.b, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitFaqView.body.1.2.4.1.2
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(com.tencent.kuikly.core.views.compose.b bVar) {
                                                com.tencent.kuikly.core.views.compose.b bVar2 = bVar;
                                                final TacitFaqView tacitFaqView7 = TacitFaqView.this;
                                                bVar2.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitFaqView.body.1.2.4.1.2.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ClickParams clickParams) {
                                                        NBPHomePageBaseViewModel nBPHomePageBaseViewModel = TacitFaqView.access$getAttr(TacitFaqView.this).viewModel;
                                                        if (nBPHomePageBaseViewModel != null) {
                                                            nBPHomePageBaseViewModel.openMyTacit();
                                                        }
                                                        TacitFaqView.access$btnReport(TacitFaqView.this, "dt_clck", 1);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final TacitFaqView tacitFaqView8 = TacitFaqView.this;
                                                VisibilityEventKt.b(bVar2, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitFaqView.body.1.2.4.1.2.2
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(Object obj) {
                                                        TacitFaqView.access$btnReport(TacitFaqView.this, "dt_imp", 1);
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
                        final TacitFaqView tacitFaqView5 = TacitFaqView.this;
                        ConditionViewKt.a(vVar2, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitFaqView.body.1.2.5
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ConditionView conditionView) {
                                ConditionView conditionView2 = conditionView;
                                final TacitFaqView tacitFaqView6 = TacitFaqView.this;
                                ConditionViewKt.c(conditionView2, new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitFaqView.body.1.2.5.1
                                    {
                                        super(0);
                                    }

                                    /* JADX WARN: Code restructure failed: missing block: B:4:0x001b, code lost:
                                    
                                        if (((java.lang.Boolean) r0.inviteClick$delegate.getValue(r0, com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitFaqView.$$delegatedProperties[0])).booleanValue() != false) goto L6;
                                     */
                                    @Override // kotlin.jvm.functions.Function0
                                    /*
                                        Code decompiled incorrectly, please refer to instructions dump.
                                    */
                                    public final Object invoke() {
                                        boolean z16;
                                        if (!TacitFaqView.access$alreadyInvite(TacitFaqView.this)) {
                                            TacitFaqView tacitFaqView7 = TacitFaqView.this;
                                            z16 = false;
                                        }
                                        z16 = true;
                                        return Boolean.valueOf(z16);
                                    }
                                }, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitFaqView.body.1.2.5.2
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ConditionView conditionView3) {
                                        com.tencent.kuikly.core.views.compose.c.a(conditionView3, new Function1<ButtonView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitFaqView.body.1.2.5.2.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ButtonView buttonView) {
                                                buttonView.attr(new Function1<a, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitFaqView.body.1.2.5.2.1.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(a aVar) {
                                                        a aVar2 = aVar;
                                                        aVar2.marginRight(16.0f);
                                                        aVar2.size(60.0f, 29.0f);
                                                        aVar2.q(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitFaqView.body.1.2.5.2.1.1.1
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ce ceVar) {
                                                                ce ceVar2 = ceVar;
                                                                ceVar2.text("\u5df2\u9080\u8bf7");
                                                                NBPArticleFeedItemView$body$1$3$3$3$3$1$1$$ExternalSyntheticOutline0.m(ceVar2, 14.0f, null, 2, null, "border_standard");
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
                                final TacitFaqView tacitFaqView7 = TacitFaqView.this;
                                ConditionViewKt.a(conditionView2, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitFaqView.body.1.2.5.3
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ConditionView conditionView3) {
                                        final TacitFaqView tacitFaqView8 = TacitFaqView.this;
                                        com.tencent.kuikly.core.views.compose.c.a(conditionView3, new Function1<ButtonView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitFaqView.body.1.2.5.3.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ButtonView buttonView) {
                                                ButtonView buttonView2 = buttonView;
                                                buttonView2.attr(new Function1<a, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitFaqView.body.1.2.5.3.1.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(a aVar) {
                                                        a aVar2 = aVar;
                                                        aVar2.marginRight(16.0f);
                                                        aVar2.size(60.0f, 29.0f);
                                                        aVar2.borderRadius(4.0f);
                                                        aVar2.m136border(new com.tencent.kuikly.core.base.e(1.0f, BorderStyle.SOLID, QUIToken.color$default("border_standard")));
                                                        aVar2.q(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitFaqView.body.1.2.5.3.1.1.1
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ce ceVar) {
                                                                ce ceVar2 = ceVar;
                                                                ceVar2.text("\u9080\u8bf7");
                                                                NBPArticleFeedItemView$body$1$3$3$3$3$1$1$$ExternalSyntheticOutline0.m(ceVar2, 14.0f, null, 2, null, "text_primary");
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final TacitFaqView tacitFaqView9 = TacitFaqView.this;
                                                buttonView2.event(new Function1<com.tencent.kuikly.core.views.compose.b, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitFaqView.body.1.2.5.3.1.2
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(com.tencent.kuikly.core.views.compose.b bVar) {
                                                        com.tencent.kuikly.core.views.compose.b bVar2 = bVar;
                                                        final TacitFaqView tacitFaqView10 = TacitFaqView.this;
                                                        bVar2.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitFaqView.body.1.2.5.3.1.2.1
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ClickParams clickParams) {
                                                                if (!TacitFaqView.access$alreadyInvite(TacitFaqView.this)) {
                                                                    TacitFaqView.access$doInvite(TacitFaqView.this);
                                                                    TacitFaqView.access$btnReport(TacitFaqView.this, "dt_clck", 2);
                                                                }
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        final TacitFaqView tacitFaqView11 = TacitFaqView.this;
                                                        VisibilityEventKt.b(bVar2, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitFaqView.body.1.2.5.3.1.2.2
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(Object obj) {
                                                                TacitFaqView.access$btnReport(TacitFaqView.this, "dt_imp", 2);
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
        };
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return new TacitFaqAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new TacitFaqEvent();
    }
}
