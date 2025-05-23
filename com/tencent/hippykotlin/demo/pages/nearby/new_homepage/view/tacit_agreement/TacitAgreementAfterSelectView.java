package com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement;

import c45.i;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedItemView$body$1$3$8$1$2$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.nearby.base.repo.QQStrangerSsoRequest;
import com.tencent.hippykotlin.demo.pages.nearby.base.repo.QQStrangerSsoService$sendProxyRequest$1;
import com.tencent.hippykotlin.demo.pages.nearby.base.tech_reporter.APICallTechReporter;
import com.tencent.hippykotlin.demo.pages.nearby.new_homepage.data.Tacit;
import com.tencent.hippykotlin.demo.pages.nearby.new_homepage.data.TagInfo;
import com.tencent.hippykotlin.demo.pages.nearby.new_homepage.repository.NBPNewHomeRepository$updateTagsInfo$1;
import com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view_model.NBPHomePageBaseViewModel;
import com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view_model.NBPHomePageBaseViewModel$tacitAddTag$2;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.BorderStyle;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.event.VisibilityEventKt;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.reactive.collection.c;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ah;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.compose.ButtonView;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.u;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import s35.ad;
import s35.ae;
import t35.a;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class TacitAgreementAfterSelectView extends ComposeView<TacitAgreementAfterSelectViewAttr, TacitAgreementAfterSelectViewEvent> {
    /* JADX WARN: Multi-variable type inference failed */
    public static final void access$addTagReport(TacitAgreementAfterSelectView tacitAgreementAfterSelectView, String str) {
        Object obj;
        e eVar;
        NBPHomePageBaseViewModel nBPHomePageBaseViewModel = ((TacitAgreementAfterSelectViewAttr) tacitAgreementAfterSelectView.getAttr()).viewModel;
        if (nBPHomePageBaseViewModel != null) {
            e jsonWithHomePagePgParams = nBPHomePageBaseViewModel.jsonWithHomePagePgParams();
            jsonWithHomePagePgParams.v("dt_eid", "em_bas_set_as_tag");
            jsonWithHomePagePgParams.t("choose_type", 1);
            Tacit data = ((TacitAgreementAfterSelectViewAttr) tacitAgreementAfterSelectView.getAttr()).getData();
            if (data != null) {
                obj = Integer.valueOf(data.f114238id);
            } else {
                obj = "";
            }
            jsonWithHomePagePgParams.v("question_id", obj);
            NBPHomePageBaseViewModel nBPHomePageBaseViewModel2 = ((TacitAgreementAfterSelectViewAttr) tacitAgreementAfterSelectView.getAttr()).viewModel;
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
    public static final void access$closeReport(TacitAgreementAfterSelectView tacitAgreementAfterSelectView, String str) {
        String str2;
        e eVar;
        Object obj;
        Tacit data = ((TacitAgreementAfterSelectViewAttr) tacitAgreementAfterSelectView.getAttr()).getData();
        boolean z16 = false;
        if (data != null && data.iSelect()) {
            str2 = "em_bas_multiple_choice_question_close";
        } else {
            str2 = "em_bas_true_falseclose";
        }
        NBPHomePageBaseViewModel nBPHomePageBaseViewModel = ((TacitAgreementAfterSelectViewAttr) tacitAgreementAfterSelectView.getAttr()).viewModel;
        if (nBPHomePageBaseViewModel != null) {
            e jsonWithHomePagePgParams = nBPHomePageBaseViewModel.jsonWithHomePagePgParams();
            jsonWithHomePagePgParams.v("dt_eid", str2);
            Tacit data2 = ((TacitAgreementAfterSelectViewAttr) tacitAgreementAfterSelectView.getAttr()).getData();
            if (data2 != null && data2.isJudge()) {
                jsonWithHomePagePgParams.t("choose_type", 1);
            }
            Tacit data3 = ((TacitAgreementAfterSelectViewAttr) tacitAgreementAfterSelectView.getAttr()).getData();
            if (data3 != null && data3.iSelect()) {
                z16 = true;
            }
            Object obj2 = "";
            if (z16) {
                Tacit data4 = ((TacitAgreementAfterSelectViewAttr) tacitAgreementAfterSelectView.getAttr()).getData();
                if (data4 == null) {
                    obj = "";
                } else {
                    obj = Integer.valueOf(data4.answer);
                }
                jsonWithHomePagePgParams.v("answer_id", obj);
            }
            Tacit data5 = ((TacitAgreementAfterSelectViewAttr) tacitAgreementAfterSelectView.getAttr()).getData();
            if (data5 != null) {
                obj2 = Integer.valueOf(data5.f114238id);
            }
            jsonWithHomePagePgParams.v("question_id", obj2);
            NBPHomePageBaseViewModel nBPHomePageBaseViewModel2 = ((TacitAgreementAfterSelectViewAttr) tacitAgreementAfterSelectView.getAttr()).viewModel;
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
    public static final /* synthetic */ TacitAgreementAfterSelectViewAttr access$getAttr(TacitAgreementAfterSelectView tacitAgreementAfterSelectView) {
        return (TacitAgreementAfterSelectViewAttr) tacitAgreementAfterSelectView.getAttr();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementAfterSelectView$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementAfterSelectView$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        mVar2.m140flex(1.0f);
                        mVar2.flexDirectionColumn();
                        mVar2.borderRadius(12.0f);
                        mVar2.mo113backgroundColor(QUIToken.color$default("bg_bottom_standard"));
                        mVar2.allCenter();
                        return Unit.INSTANCE;
                    }
                });
                final TacitAgreementAfterSelectView tacitAgreementAfterSelectView = TacitAgreementAfterSelectView.this;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementAfterSelectView$body$1.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementAfterSelectView.body.1.2.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.size(16.0f, 16.0f);
                                tVar2.positionAbsolute();
                                tVar2.m149right(10.0f);
                                tVar2.m150top(10.0f);
                                tVar2.allCenter();
                                return Unit.INSTANCE;
                            }
                        });
                        final TacitAgreementAfterSelectView tacitAgreementAfterSelectView2 = TacitAgreementAfterSelectView.this;
                        vVar2.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementAfterSelectView.body.1.2.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(u uVar) {
                                final TacitAgreementAfterSelectView tacitAgreementAfterSelectView3 = TacitAgreementAfterSelectView.this;
                                VisibilityEventKt.b(uVar, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementAfterSelectView.body.1.2.2.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(Object obj) {
                                        TacitAgreementAfterSelectView.access$closeReport(TacitAgreementAfterSelectView.this, "dt_imp");
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        ah.a(vVar2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementAfterSelectView.body.1.2.3
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ImageView imageView) {
                                imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementAfterSelectView.body.1.2.3.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(af afVar) {
                                        af afVar2 = afVar;
                                        afVar2.size(11.0f, 11.0f);
                                        b.a.b(afVar2, "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_27pWAUltOWN.png", false, 2, null);
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final TacitAgreementAfterSelectView tacitAgreementAfterSelectView3 = TacitAgreementAfterSelectView.this;
                        vVar2.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementAfterSelectView.body.1.2.4
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(u uVar) {
                                final TacitAgreementAfterSelectView tacitAgreementAfterSelectView4 = TacitAgreementAfterSelectView.this;
                                uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementAfterSelectView.body.1.2.4.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ClickParams clickParams) {
                                        NBPHomePageBaseViewModel nBPHomePageBaseViewModel;
                                        Tacit data = TacitAgreementAfterSelectView.access$getAttr(TacitAgreementAfterSelectView.this).getData();
                                        if (data != null && (nBPHomePageBaseViewModel = TacitAgreementAfterSelectView.access$getAttr(TacitAgreementAfterSelectView.this).viewModel) != null) {
                                            nBPHomePageBaseViewModel.removeTacit(data);
                                        }
                                        TacitAgreementAfterSelectView.access$closeReport(TacitAgreementAfterSelectView.this, "dt_clck");
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final TacitAgreementAfterSelectView tacitAgreementAfterSelectView2 = TacitAgreementAfterSelectView.this;
                cg.a(viewContainer2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementAfterSelectView$body$1.3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(TextView textView) {
                        final TacitAgreementAfterSelectView tacitAgreementAfterSelectView3 = TacitAgreementAfterSelectView.this;
                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementAfterSelectView.body.1.3.1
                            {
                                super(1);
                            }

                            /* JADX WARN: Code restructure failed: missing block: B:14:0x005b, code lost:
                            
                                if (r0 != null) goto L24;
                             */
                            /* JADX WARN: Code restructure failed: missing block: B:4:0x001f, code lost:
                            
                                if (r0.iSelect() == true) goto L8;
                             */
                            /* JADX WARN: Removed duplicated region for block: B:16:0x006b  */
                            @Override // kotlin.jvm.functions.Function1
                            /*
                                Code decompiled incorrectly, please refer to instructions dump.
                            */
                            public final Unit invoke(ce ceVar) {
                                String str;
                                ce ceVar2 = ceVar;
                                ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                ceVar2.lineHeight(20.0f);
                                Tacit data = TacitAgreementAfterSelectView.access$getAttr(TacitAgreementAfterSelectView.this).getData();
                                boolean z16 = data != null;
                                if (z16) {
                                    ceVar2.fontWeight400();
                                    ceVar2.color(QUIToken.color$default("text_secondary"));
                                } else {
                                    ceVar2.color(QUIToken.color$default("text_primary"));
                                    ceVar2.fontWeight500();
                                }
                                Tacit data2 = TacitAgreementAfterSelectView.access$getAttr(TacitAgreementAfterSelectView.this).getData();
                                String str2 = "";
                                if (data2 != null) {
                                    if (data2.isJudge()) {
                                        a aVar = data2.tag;
                                        if (aVar != null) {
                                            str = aVar.f435363e;
                                        }
                                        str = "";
                                        if (str != null) {
                                            str2 = str;
                                        }
                                    } else {
                                        if (data2.iSelect()) {
                                            str = data2.question;
                                            if (str != null) {
                                            }
                                        }
                                        str = "";
                                        if (str != null) {
                                        }
                                    }
                                }
                                ceVar2.text(str2);
                                ceVar2.marginBottom(8.0f);
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final TacitAgreementAfterSelectView tacitAgreementAfterSelectView3 = TacitAgreementAfterSelectView.this;
                Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementAfterSelectView$body$1.4
                    {
                        super(0);
                    }

                    /* JADX WARN: Code restructure failed: missing block: B:4:0x0011, code lost:
                    
                        if (r0.iSelect() == true) goto L8;
                     */
                    @Override // kotlin.jvm.functions.Function0
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public final Object invoke() {
                        Tacit data = TacitAgreementAfterSelectView.access$getAttr(TacitAgreementAfterSelectView.this).getData();
                        boolean z16 = data != null;
                        return Boolean.valueOf(z16);
                    }
                };
                final TacitAgreementAfterSelectView tacitAgreementAfterSelectView4 = TacitAgreementAfterSelectView.this;
                ConditionViewKt.c(viewContainer2, function0, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementAfterSelectView$body$1.5
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ConditionView conditionView) {
                        final TacitAgreementAfterSelectView tacitAgreementAfterSelectView5 = TacitAgreementAfterSelectView.this;
                        cg.a(conditionView, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementAfterSelectView.body.1.5.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(TextView textView) {
                                final TacitAgreementAfterSelectView tacitAgreementAfterSelectView6 = TacitAgreementAfterSelectView.this;
                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementAfterSelectView.body.1.5.1.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ce ceVar) {
                                        Object orNull;
                                        ce ceVar2 = ceVar;
                                        ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                        ceVar2.lineHeight(20.0f);
                                        ceVar2.color(QUIToken.color$default("text_primary"));
                                        Tacit data = TacitAgreementAfterSelectView.access$getAttr(TacitAgreementAfterSelectView.this).getData();
                                        String str = "";
                                        if (data != null) {
                                            orNull = CollectionsKt___CollectionsKt.getOrNull(data.options, data.answer - 1);
                                            String str2 = (String) orNull;
                                            if (str2 != null) {
                                                str = str2;
                                            }
                                        }
                                        ceVar2.text(str);
                                        ceVar2.fontWeight500();
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final TacitAgreementAfterSelectView tacitAgreementAfterSelectView5 = TacitAgreementAfterSelectView.this;
                Function0<Object> function02 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementAfterSelectView$body$1.6
                    {
                        super(0);
                    }

                    /* JADX WARN: Removed duplicated region for block: B:21:0x007b  */
                    @Override // kotlin.jvm.functions.Function0
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public final Object invoke() {
                        boolean z16;
                        boolean z17;
                        NBPHomePageBaseViewModel nBPHomePageBaseViewModel = TacitAgreementAfterSelectView.access$getAttr(TacitAgreementAfterSelectView.this).viewModel;
                        boolean z18 = false;
                        if (nBPHomePageBaseViewModel != null) {
                            Tacit data = TacitAgreementAfterSelectView.access$getAttr(TacitAgreementAfterSelectView.this).getData();
                            if (data != null) {
                                if (data.tag == null) {
                                    KLog.INSTANCE.d("NBPHomePageBaseViewModel", "tacitAddTagButtonVisible: tag is null");
                                } else if (!data.isJudge()) {
                                    KLog.INSTANCE.d("NBPHomePageBaseViewModel", "tacitAddTagButtonVisible: not isJudge");
                                } else if (nBPHomePageBaseViewModel.getTagList().size() < 20) {
                                    c<TagInfo> tagList = nBPHomePageBaseViewModel.getTagList();
                                    if (!(tagList instanceof Collection) || !tagList.isEmpty()) {
                                        Iterator<TagInfo> it = tagList.iterator();
                                        while (it.hasNext()) {
                                            if (it.next().tag.f435362d == data.tag.f435362d) {
                                                z17 = true;
                                                break;
                                            }
                                        }
                                    }
                                    z17 = false;
                                    if (!z17) {
                                        z16 = true;
                                        if (z16) {
                                            z18 = true;
                                        }
                                    }
                                }
                            }
                            z16 = false;
                            if (z16) {
                            }
                        }
                        return Boolean.valueOf(z18);
                    }
                };
                final TacitAgreementAfterSelectView tacitAgreementAfterSelectView6 = TacitAgreementAfterSelectView.this;
                ConditionViewKt.c(viewContainer2, function02, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementAfterSelectView$body$1.7
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ConditionView conditionView) {
                        final TacitAgreementAfterSelectView tacitAgreementAfterSelectView7 = TacitAgreementAfterSelectView.this;
                        com.tencent.kuikly.core.views.compose.c.a(conditionView, new Function1<ButtonView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementAfterSelectView.body.1.7.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ButtonView buttonView) {
                                ButtonView buttonView2 = buttonView;
                                buttonView2.attr(new Function1<com.tencent.kuikly.core.views.compose.a, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementAfterSelectView.body.1.7.1.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(com.tencent.kuikly.core.views.compose.a aVar) {
                                        com.tencent.kuikly.core.views.compose.a aVar2 = aVar;
                                        aVar2.marginTop(8.0f);
                                        aVar2.size(102.0f, 29.0f);
                                        aVar2.m136border(new com.tencent.kuikly.core.base.e(1.0f, BorderStyle.SOLID, new h(13421772L, 1.0f)));
                                        aVar2.borderRadius(4.0f);
                                        aVar2.q(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementAfterSelectView.body.1.7.1.1.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ce ceVar) {
                                                ce ceVar2 = ceVar;
                                                ceVar2.text("\u8bbe\u4e3a\u6807\u7b7e");
                                                ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                                ceVar2.textAlignCenter();
                                                ceVar2.color(QUIToken.color$default("text_primary"));
                                                ceVar2.fontWeight400();
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final TacitAgreementAfterSelectView tacitAgreementAfterSelectView8 = TacitAgreementAfterSelectView.this;
                                buttonView2.event(new Function1<com.tencent.kuikly.core.views.compose.b, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementAfterSelectView.body.1.7.1.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(com.tencent.kuikly.core.views.compose.b bVar) {
                                        com.tencent.kuikly.core.views.compose.b bVar2 = bVar;
                                        final TacitAgreementAfterSelectView tacitAgreementAfterSelectView9 = TacitAgreementAfterSelectView.this;
                                        bVar2.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementAfterSelectView.body.1.7.1.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ClickParams clickParams) {
                                                final a aVar;
                                                final NBPHomePageBaseViewModel nBPHomePageBaseViewModel;
                                                int collectionSizeOrDefault;
                                                List mutableList;
                                                List list;
                                                List mutableList2;
                                                Tacit data = TacitAgreementAfterSelectView.access$getAttr(TacitAgreementAfterSelectView.this).getData();
                                                if (data != null && (aVar = data.tag) != null && (nBPHomePageBaseViewModel = TacitAgreementAfterSelectView.access$getAttr(TacitAgreementAfterSelectView.this).viewModel) != null && nBPHomePageBaseViewModel.getTagList().size() < 20) {
                                                    c<TagInfo> tagList = nBPHomePageBaseViewModel.getTagList();
                                                    collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(tagList, 10);
                                                    ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                                                    Iterator<TagInfo> it = tagList.iterator();
                                                    while (it.hasNext()) {
                                                        arrayList.add(Integer.valueOf(it.next().tag.f435362d));
                                                    }
                                                    mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList);
                                                    if (!mutableList.contains(Integer.valueOf(aVar.f435362d))) {
                                                        mutableList.add(Integer.valueOf(aVar.f435362d));
                                                        list = CollectionsKt___CollectionsKt.toList(mutableList);
                                                        int appId = nBPHomePageBaseViewModel.getAppId();
                                                        Function1<ae, Unit> function1 = new Function1<ae, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view_model.NBPHomePageBaseViewModel$tacitAddTag$1
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ae aeVar) {
                                                                NBPHomePageBaseViewModel.this.getTagList().add(new TagInfo(aVar));
                                                                return Unit.INSTANCE;
                                                            }
                                                        };
                                                        NBPHomePageBaseViewModel$tacitAddTag$2 nBPHomePageBaseViewModel$tacitAddTag$2 = NBPHomePageBaseViewModel$tacitAddTag$2.INSTANCE;
                                                        if (QQKuiklyPlatformApi.Companion.getNetworkType() != QQKuiklyPlatformApi.QQNetworkType.NOT_REACHABLE) {
                                                            mutableList2 = CollectionsKt___CollectionsKt.toMutableList((Collection) list);
                                                            ad adVar = new ad(mutableList2, 0, 0);
                                                            NBPNewHomeRepository$updateTagsInfo$1 nBPNewHomeRepository$updateTagsInfo$1 = new NBPNewHomeRepository$updateTagsInfo$1(appId, function1, nBPHomePageBaseViewModel$tacitAddTag$2);
                                                            NBPArticleFeedItemView$body$1$3$8$1$2$1$$ExternalSyntheticOutline0.m(new APICallTechReporter(1, "trpc.qqstranger.common_proxy.CommonProxy.SsoHandle"), new QQStrangerSsoService$sendProxyRequest$1(nBPNewHomeRepository$updateTagsInfo$1), new QQStrangerSsoRequest(new u35.a("QQStranger.UserInfo", "SsoUpdateUserTags", appId, new c45.a(i.d(adVar)))), null, 6);
                                                        } else {
                                                            nBPHomePageBaseViewModel$tacitAddTag$2.invoke(-1, "network unreachable");
                                                        }
                                                    }
                                                }
                                                TacitAgreementAfterSelectView.access$addTagReport(TacitAgreementAfterSelectView.this, "dt_clck");
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final TacitAgreementAfterSelectView tacitAgreementAfterSelectView10 = TacitAgreementAfterSelectView.this;
                                        VisibilityEventKt.b(bVar2, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementAfterSelectView.body.1.7.1.2.2
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(Object obj) {
                                                TacitAgreementAfterSelectView.access$addTagReport(TacitAgreementAfterSelectView.this, "dt_imp");
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
        return new TacitAgreementAfterSelectViewAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new TacitAgreementAfterSelectViewEvent();
    }
}
