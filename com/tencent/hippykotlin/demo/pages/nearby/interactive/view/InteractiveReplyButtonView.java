package com.tencent.hippykotlin.demo.pages.nearby.interactive.view;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.module.AdelieKuiklyBaseModule$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.UserDataManager;
import com.tencent.hippykotlin.demo.pages.nearby.base.repo.BDHService;
import com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPJumpUtil;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.event.VisibilityEventKt;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.compose.ButtonView;
import com.tencent.kuikly.core.views.compose.a;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import n25.g;
import n25.j;
import n25.l;
import n35.v;
import n35.w;
import n35.z;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class InteractiveReplyButtonView extends ComposeView<InteractiveReplyButtonViewAttr, InteractiveReplyButtonViewEvent> {
    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ InteractiveReplyButtonViewAttr access$getAttr(InteractiveReplyButtonView interactiveReplyButtonView) {
        return (InteractiveReplyButtonViewAttr) interactiveReplyButtonView.getAttr();
    }

    public static final void access$report(InteractiveReplyButtonView interactiveReplyButtonView, String str) {
        interactiveReplyButtonView.getClass();
        String q16 = c.f117352a.g().getPageData().n().q("source", "1");
        e m3 = AdelieKuiklyBaseModule$$ExternalSyntheticOutline0.m("dt_pgid", "pg_nearby_interact_msg_list", "nearby_user_from", q16);
        m3.v("dt_eid", "em_nearby_reply_btn");
        m3.t("nearby_circle_type", 1);
        e eVar = new e();
        eVar.v("dt_pgid", "pg_nearby_interact_msg_list");
        eVar.v("nearby_user_from", q16);
        Unit unit = Unit.INSTANCE;
        m3.v("cur_pg", eVar);
        m3.v(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
        Utils.INSTANCE.currentBridgeModule().reportCustomDtEvent(str, m3);
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.InteractiveReplyButtonView$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.InteractiveReplyButtonView$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        mVar.marginTop(12.0f);
                        return Unit.INSTANCE;
                    }
                });
                final InteractiveReplyButtonView interactiveReplyButtonView = InteractiveReplyButtonView.this;
                com.tencent.kuikly.core.views.compose.c.a(viewContainer2, new Function1<ButtonView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.InteractiveReplyButtonView$body$1.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ButtonView buttonView) {
                        ButtonView buttonView2 = buttonView;
                        buttonView2.attr(new Function1<a, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.InteractiveReplyButtonView.body.1.2.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(a aVar) {
                                a aVar2 = aVar;
                                aVar2.mo153width(64.0f);
                                aVar2.mo141height(29.0f);
                                aVar2.borderRadius(4.0f);
                                aVar2.mo113backgroundColor(QUIToken.color$default("fill_standard_primary"));
                                aVar2.alignItemsCenter();
                                aVar2.m(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.InteractiveReplyButtonView.body.1.2.1.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(af afVar) {
                                        af afVar2 = afVar;
                                        b.a.b(afVar2, "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_BDMZ2QiddxE.png", false, 2, null);
                                        afVar2.size(16.0f, 16.0f);
                                        afVar2.t(QUIToken.color$default("icon_primary"));
                                        afVar2.alignSelfCenter();
                                        return Unit.INSTANCE;
                                    }
                                });
                                aVar2.q(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.InteractiveReplyButtonView.body.1.2.1.2
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ce ceVar) {
                                        ce ceVar2 = ceVar;
                                        ceVar2.text("\u56de\u590d");
                                        ceVar2.fontWeight400();
                                        ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                        ceVar2.lineHeight(20.0f);
                                        ceVar2.color(QUIToken.color$default("text_primary"));
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final InteractiveReplyButtonView interactiveReplyButtonView2 = InteractiveReplyButtonView.this;
                        buttonView2.event(new Function1<com.tencent.kuikly.core.views.compose.b, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.InteractiveReplyButtonView.body.1.2.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(com.tencent.kuikly.core.views.compose.b bVar) {
                                com.tencent.kuikly.core.views.compose.b bVar2 = bVar;
                                final InteractiveReplyButtonView interactiveReplyButtonView3 = InteractiveReplyButtonView.this;
                                bVar2.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.InteractiveReplyButtonView.body.1.2.2.1
                                    {
                                        super(1);
                                    }

                                    /* JADX WARN: Removed duplicated region for block: B:17:0x006a  */
                                    @Override // kotlin.jvm.functions.Function1
                                    /*
                                        Code decompiled incorrectly, please refer to instructions dump.
                                    */
                                    public final Unit invoke(ClickParams clickParams) {
                                        Object firstOrNull;
                                        v vVar;
                                        String urlFromCache;
                                        w wVar;
                                        List<z> list;
                                        Object firstOrNull2;
                                        g gVar = InteractiveReplyButtonView.access$getAttr(InteractiveReplyButtonView.this).feed;
                                        if (gVar != null) {
                                            l lVar = gVar.F;
                                            if (lVar == null) {
                                                lVar = new l(gVar.f418067d, new r25.e(UserDataManager.INSTANCE.getUserSelfInfo().tid, null, null, 0, null, 1073741822), null, null, null, null, null, 0L, null, false, 0, null, 0, null, null, 2097148);
                                            }
                                            BDHService bDHService = BDHService.INSTANCE;
                                            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) lVar.f418097m);
                                            j jVar = (j) firstOrNull;
                                            if (jVar != null && (wVar = jVar.f418083d) != null && (list = wVar.f418273d) != null) {
                                                firstOrNull2 = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) list);
                                                z zVar = (z) firstOrNull2;
                                                if (zVar != null) {
                                                    vVar = zVar.f418280d;
                                                    urlFromCache = bDHService.getUrlFromCache(vVar);
                                                    if (urlFromCache == null) {
                                                        urlFromCache = "";
                                                    }
                                                    e eVar = new e();
                                                    eVar.v("comment_id", gVar.f418072m);
                                                    eVar.v("reply_id", gVar.C);
                                                    eVar.v("feedImageUrl", urlFromCache);
                                                    eVar.v("show_reply_input", "1");
                                                    KLog kLog = KLog.INSTANCE;
                                                    StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("click: commentId=");
                                                    m3.append(gVar.f418072m);
                                                    m3.append(", replyId=");
                                                    m3.append(gVar.C);
                                                    m3.append(", imgUrl=");
                                                    m3.append(urlFromCache);
                                                    kLog.i("InteractiveReplyButtonView", m3.toString());
                                                    NBPJumpUtil.INSTANCE.jumpArticleFeedDetailPage(lVar, 7, eVar);
                                                }
                                            }
                                            vVar = null;
                                            urlFromCache = bDHService.getUrlFromCache(vVar);
                                            if (urlFromCache == null) {
                                            }
                                            e eVar2 = new e();
                                            eVar2.v("comment_id", gVar.f418072m);
                                            eVar2.v("reply_id", gVar.C);
                                            eVar2.v("feedImageUrl", urlFromCache);
                                            eVar2.v("show_reply_input", "1");
                                            KLog kLog2 = KLog.INSTANCE;
                                            StringBuilder m36 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("click: commentId=");
                                            m36.append(gVar.f418072m);
                                            m36.append(", replyId=");
                                            m36.append(gVar.C);
                                            m36.append(", imgUrl=");
                                            m36.append(urlFromCache);
                                            kLog2.i("InteractiveReplyButtonView", m36.toString());
                                            NBPJumpUtil.INSTANCE.jumpArticleFeedDetailPage(lVar, 7, eVar2);
                                        }
                                        InteractiveReplyButtonView.access$report(InteractiveReplyButtonView.this, "dt_clck");
                                        return Unit.INSTANCE;
                                    }
                                });
                                final InteractiveReplyButtonView interactiveReplyButtonView4 = InteractiveReplyButtonView.this;
                                VisibilityEventKt.b(bVar2, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.InteractiveReplyButtonView.body.1.2.2.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(Object obj) {
                                        InteractiveReplyButtonView.access$report(InteractiveReplyButtonView.this, "dt_imp");
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
        return new InteractiveReplyButtonViewAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new InteractiveReplyButtonViewEvent();
    }
}
