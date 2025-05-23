package com.tencent.hippykotlin.demo.pages.router_page;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.AgreementConsentViewKt$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.BasePager;
import com.tencent.hippykotlin.demo.pages.base.BridgeModule;
import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.QQComposeViewExtCreator$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.foundation.lib.mqq.Mqq;
import com.tencent.hippykotlin.demo.pages.foundation.module.CacheModule;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.router_page.views.HistorySelectorView;
import com.tencent.hippykotlin.demo.pages.router_page.views.HistorySelectorViewAttr;
import com.tencent.hippykotlin.demo.pages.router_page.views.HistorySelectorViewEvent;
import com.tencent.hippykotlin.demo.pages.router_page.views.RouterNavigationBar;
import com.tencent.hippykotlin.demo.pages.router_page.views.RouterNavigationBarAttr;
import com.tencent.kuikly.core.base.BorderStyle;
import com.tencent.kuikly.core.base.Direction;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.aa;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.d;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.j;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.module.p;
import com.tencent.kuikly.core.module.r;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.InputEvent;
import com.tencent.kuikly.core.views.InputParams;
import com.tencent.kuikly.core.views.InputView;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ah;
import com.tencent.kuikly.core.views.ai;
import com.tencent.kuikly.core.views.am;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.compose.ButtonView;
import com.tencent.kuikly.core.views.compose.a;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.u;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import com.tencent.oskplayer.proxy.VideoProxy;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* loaded from: classes33.dex */
public final class RouterPage extends BasePager {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(RouterPage.class, "selectDexMode", "getSelectDexMode()Z", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(RouterPage.class, "selectJSMode", "getSelectJSMode()Z", 0)};
    public aa<HistorySelectorView> historyRef;
    public aa<InputView> inputRef;
    public String inputText = "";
    public final ReadWriteProperty selectDexMode$delegate = c.a(Boolean.FALSE);
    public final ReadWriteProperty selectJSMode$delegate = c.a(Boolean.TRUE);

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.router_page.RouterPage$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.router_page.RouterPage$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        mVar.mo113backgroundColor(h.INSTANCE.m());
                        return Unit.INSTANCE;
                    }
                });
                viewContainer2.addChild(new RouterNavigationBar(), new Function1<RouterNavigationBar, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.router_page.RouterPage$body$1.2
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(RouterNavigationBar routerNavigationBar) {
                        routerNavigationBar.attr(new Function1<RouterNavigationBarAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.router_page.RouterPage.body.1.2.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(RouterNavigationBarAttr routerNavigationBarAttr) {
                                RouterNavigationBarAttr routerNavigationBarAttr2 = routerNavigationBarAttr;
                                routerNavigationBarAttr2.title$delegate.setValue(routerNavigationBarAttr2, RouterNavigationBarAttr.$$delegatedProperties[0], "NTCompose\u9875\u9762\u8def\u7531");
                                routerNavigationBarAttr2.backDisable = true;
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.router_page.RouterPage$body$1.3
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.router_page.RouterPage.body.1.3.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.allCenter();
                                tVar2.margin(20.0f);
                                return Unit.INSTANCE;
                            }
                        });
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.router_page.RouterPage.body.1.3.2
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                v vVar4 = vVar3;
                                vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.router_page.RouterPage.body.1.3.2.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.mo113backgroundColor(h.INSTANCE.m());
                                        tVar2.borderRadius(10.0f);
                                        tVar2.padding(10.0f);
                                        return Unit.INSTANCE;
                                    }
                                });
                                ah.a(vVar4, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.router_page.RouterPage.body.1.3.2.2
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ImageView imageView) {
                                        imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.router_page.RouterPage.body.1.3.2.2.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(af afVar) {
                                                af afVar2 = afVar;
                                                b.a.b(afVar2, "data:image/png;base64,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72F61/szves9TO96f6Z3vYfpXe/P9K73ML3r/Zne9R6md70/07vew/Su97FTBwIAAAAMg/yt7/EVRM/0rvcwvev9md71HqZ3vT/Tu97D9K73Z3rXe5je9f5M73oP07ven+ld72F61/szves9TO96f6Z3vYfpXe/P9K73ML3r/Zne9R6md70/07vew/Su92d613uY3vX+TO96D9O73p/pXe9hetf7M73rPUzven+md72H6V3vz/Su9zC96/2Z3vUepne9P9O73sP0rvdnetd7mN71/kzveg/Tu96f6V3vYXrX+zO96z1M73p/pne9h+ld78/0rvcwvev9md71HqZ3vT/Tu97D9K73Z3rXe5je9f5M73oP07ven+ld72F61/szves9TO96f6Z3vYfpXe/P9K73ML3r/Zne9R6md70/07vew/Su92d613uY3vX+TO96D9O73p/pXe9hetf7M73rPUzven+md72H6V3vz/Su97CxUwcCAAAADIP8re+xF0R613uZ3vV+TO96L9O73o/pXe9letf7Mb3rvUzvej+md72X6V3vx/Su9zK96/2Y3vVepne9H9O73sv0rvdjetd7md71fkzvei/Tu96P6V3vZXrX+zG9671M73o/pne9l+ld78f0rvcyvev9mN71XqZ3vR/Tu97L9K73Y3rXe5ne9X5M73ov07vej+ld72V61/sxveu9TO96P6Z3vZfpXe/H9K73Mr3r/Zje9V6md70f07vey/Su92N613uZ3vV+TO96L9O73o/pXe9letf7Mb3rvUzvej+md72X6V3vx/Su9zK96/2Y3vVepne9H9O73sv0rvdjetd7md71fkzvei/Tu96P6V3vZXrX+zG9671M73o/pne9l+ld78f0rvcyvev9mN71XqZ3vR/Tu97L9K73Y3rXe5nex04dCAAAADAM8re+x1cQ6T1M73p/pne9h+ld78/0rvcwvev9md71HqZ3vT/Tu97D9K73Z3rXe5je9f5M73oP07ven+ld72F61/szves9TO96f6Z3vYfpXe/P9K73ML3r/Zne9R6md70/07vew/Su92d613uY3vX+TO96D9O73p/pXe9hetf7M73rPUzven+md72H6V3vz/Su9zC96/2Z3vUepne9P9O73sP0rvdnetd7mN71/kzveg/Tu96f6V3vYXrX+zO96z1M73p/pne9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", false, 2, null);
                                                afVar2.size(afVar2.getPagerData().m() * 0.4f, afVar2.getPagerData().m() * 0.5f * 0.734676f);
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
                final RouterPage routerPage = RouterPage.this;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.router_page.RouterPage$body$1.4
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.router_page.RouterPage.body.1.4.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                tVar.flexDirectionRow();
                                return Unit.INSTANCE;
                            }
                        });
                        final RouterPage routerPage2 = RouterPage.this;
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.router_page.RouterPage.body.1.4.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                v vVar4 = vVar3;
                                vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.router_page.RouterPage.body.1.4.2.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.margin(10.0f);
                                        tVar2.marginTop(0.0f);
                                        tVar2.mo141height(40.0f);
                                        tVar2.m140flex(1.0f);
                                        tVar2.borderRadius(5.0f);
                                        tVar2.mo135backgroundLinearGradient(Direction.TO_BOTTOM, new j(new h(4283533037L), 0.0f), new j(new h(4283533037L), 1.0f));
                                        return Unit.INSTANCE;
                                    }
                                });
                                w.a(vVar4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.router_page.RouterPage.body.1.4.2.2
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar5) {
                                        v vVar6 = vVar5;
                                        vVar6.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.router_page.RouterPage.body.1.4.2.2.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                tVar.absolutePositionAllZero();
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        w.a(vVar6, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.router_page.RouterPage.body.1.4.2.2.2
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(v vVar7) {
                                                vVar7.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.router_page.RouterPage.body.1.4.2.2.2.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(t tVar) {
                                                        t tVar2 = tVar;
                                                        tVar2.absolutePosition(1.0f, 1.0f, 1.0f, 1.0f);
                                                        tVar2.mo113backgroundColor(h.INSTANCE.m());
                                                        tVar2.borderRadius(5.0f);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final RouterPage routerPage3 = RouterPage.this;
                                am.a(vVar4, new Function1<InputView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.router_page.RouterPage.body.1.4.2.3
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(InputView inputView) {
                                        InputView inputView2 = inputView;
                                        final RouterPage routerPage4 = RouterPage.this;
                                        inputView2.ref(inputView2, new Function1<aa<InputView>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.router_page.RouterPage.body.1.4.2.3.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(aa<InputView> aaVar) {
                                                RouterPage.this.inputRef = aaVar;
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        inputView2.attr(new Function1<ai, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.router_page.RouterPage.body.1.4.2.3.2
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ai aiVar) {
                                                ai aiVar2 = aiVar;
                                                aiVar2.m140flex(1.0f);
                                                ai.m(aiVar2, 15.0f, null, 2, null);
                                                aiVar2.i(new h(4283533037L));
                                                aiVar2.marginLeft(10.0f);
                                                aiVar2.marginRight(10.0f);
                                                aiVar2.u("\u8f93\u5165pageName\uff08\u4e0d\u533a\u5206\u5927\u5c0f\u5199\uff09");
                                                aiVar2.h(true);
                                                aiVar2.v(new h(2854474749L));
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final RouterPage routerPage5 = RouterPage.this;
                                        inputView2.event(new Function1<InputEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.router_page.RouterPage.body.1.4.2.3.3
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(InputEvent inputEvent) {
                                                final RouterPage routerPage6 = RouterPage.this;
                                                InputEvent.q(inputEvent, false, new Function1<InputParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.router_page.RouterPage.body.1.4.2.3.3.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(InputParams inputParams) {
                                                        RouterPage.this.inputText = inputParams.getText();
                                                        return Unit.INSTANCE;
                                                    }
                                                }, 1, null);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final RouterPage routerPage3 = RouterPage.this;
                        com.tencent.kuikly.core.views.compose.c.a(vVar2, new Function1<ButtonView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.router_page.RouterPage.body.1.4.3
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ButtonView buttonView) {
                                ButtonView buttonView2 = buttonView;
                                buttonView2.attr(new Function1<a, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.router_page.RouterPage.body.1.4.3.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(a aVar) {
                                        a aVar2 = aVar;
                                        aVar2.size(80.0f, 40.0f);
                                        aVar2.borderRadius(20.0f);
                                        aVar2.marginLeft(2.0f);
                                        aVar2.marginRight(10.0f);
                                        aVar2.mo135backgroundLinearGradient(Direction.TO_BOTTOM, new j(new h(4283533037L), 0.0f), new j(new h(4283533037L), 1.0f));
                                        aVar2.q(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.router_page.RouterPage.body.1.4.3.1.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ce ceVar) {
                                                ce ceVar2 = ceVar;
                                                ceVar2.text("\u8df3\u8f6c");
                                                ce.fontSize$default(ceVar2, 17.0f, null, 2, null);
                                                ceVar2.color(h.INSTANCE.m());
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final RouterPage routerPage4 = RouterPage.this;
                                buttonView2.event(new Function1<com.tencent.kuikly.core.views.compose.b, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.router_page.RouterPage.body.1.4.3.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(com.tencent.kuikly.core.views.compose.b bVar) {
                                        final com.tencent.kuikly.core.views.compose.b bVar2 = bVar;
                                        final RouterPage routerPage5 = RouterPage.this;
                                        bVar2.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.router_page.RouterPage.body.1.4.3.2.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ClickParams clickParams) {
                                                String str;
                                                String m3;
                                                String str2;
                                                String str3;
                                                List takeLast;
                                                String joinToString$default;
                                                if (RouterPage.this.inputText.length() == 0) {
                                                    IPagerIdKtxKt.getBridgeModule(RouterPage.this).toast("\u8bf7\u8f93\u5165PageName");
                                                } else {
                                                    InputView b16 = RouterPage.this.getInputRef().b();
                                                    if (b16 != null) {
                                                        b16.h();
                                                    }
                                                    aa<HistorySelectorView> aaVar = RouterPage.this.historyRef;
                                                    if (aaVar == null) {
                                                        Intrinsics.throwUninitializedPropertyAccessException("historyRef");
                                                        aaVar = null;
                                                    }
                                                    HistorySelectorView b17 = aaVar.b();
                                                    if (b17 != null) {
                                                        String str4 = RouterPage.this.inputText;
                                                        b17.getHistorys().remove(str4);
                                                        b17.getHistorys().add(str4);
                                                        com.tencent.kuikly.core.reactive.collection.c<String> historys = b17.getHistorys();
                                                        HistorySelectorView.Companion.getClass();
                                                        r value = HistorySelectorView.cacheModule$delegate.getValue();
                                                        takeLast = CollectionsKt___CollectionsKt.takeLast(historys, 6);
                                                        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(takeLast, ";", null, null, 0, null, null, 62, null);
                                                        value.a("router_history", joinToString$default);
                                                        b17.sync();
                                                    }
                                                    ((CacheModule) bVar2.getPager().acquireModule("HRCacheModule")).setItem("router_last_input_key2", RouterPage.this.inputText);
                                                    ((r) RouterPage.this.acquireModule("KRSharedPreferencesModule")).setItem("dex_mode_key2", String.valueOf(d.b(RouterPage.this.getSelectDexMode())));
                                                    RouterPage routerPage6 = RouterPage.this;
                                                    String str5 = routerPage6.inputText;
                                                    if (routerPage6.getPageData().n().j("appId") == 1) {
                                                        if (!Intrinsics.areEqual(routerPage6.getPageData().n().p("execute_mode"), "1")) {
                                                            str2 = "1";
                                                        } else {
                                                            str2 = "2";
                                                        }
                                                        if (routerPage6.isInQQContainer()) {
                                                            str3 = "mqqapi://kuikly/open?";
                                                        } else {
                                                            str3 = "mqqapi://ecommerce/open?";
                                                        }
                                                        String m16 = QQComposeViewExtCreator$$ExternalSyntheticOutline0.m(str3, "target=52&channel=2&version=1&src_type=app&page_name=", str5);
                                                        if (routerPage6.getSelectDexMode()) {
                                                            m16 = AgreementConsentViewKt$$ExternalSyntheticOutline0.m(m16, "&useDexMode=1");
                                                            str2 = "1";
                                                        }
                                                        if (routerPage6.getPageData().getIsIOS() && routerPage6.isInQQContainer() && !routerPage6.getSelectJSMode()) {
                                                            str2 = "0";
                                                        }
                                                        m3 = QQComposeViewExtCreator$$ExternalSyntheticOutline0.m(m16, "&is_debug_mode=", str2);
                                                    } else {
                                                        String m17 = AgreementConsentViewKt$$ExternalSyntheticOutline0.m(":8899/nativevue2.js?_rij_violaUrl=1&hideNav=1&v_nav_immer=1&nv2=2&v_bg_color=f5f5f5&statusColor=1&v_debug=1&v_bundleName=", str5);
                                                        Map<String, String> a16 = com.tencent.kuikly.core.utils.c.a(m17);
                                                        if (a16.containsKey("ip")) {
                                                            StringBuilder m18 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("http://");
                                                            m18.append(a16.get("ip"));
                                                            str = m18.toString();
                                                        } else {
                                                            str = VideoProxy.PROXY_SERVER;
                                                        }
                                                        m3 = AgreementConsentViewKt$$ExternalSyntheticOutline0.m(str, m17);
                                                    }
                                                    String str6 = m3;
                                                    if (Intrinsics.areEqual(routerPage6.getPageData().n().p("is_miniprogram"), "1")) {
                                                        Map<String, String> a17 = com.tencent.kuikly.core.utils.c.a("pageName=" + str5);
                                                        e eVar = new e();
                                                        for (Map.Entry<String, String> entry : a17.entrySet()) {
                                                            eVar.v(entry.getKey(), entry.getValue());
                                                        }
                                                        p.c((p) routerPage6.acquireModule("KRRouterModule"), eVar.p("pageName"), eVar, null, 4, null);
                                                    } else if (routerPage6.isInQQContainer()) {
                                                        QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
                                                        QQKuiklyPlatformApi.Companion.openPage$default(str6, false, 6);
                                                    } else {
                                                        BridgeModule.openPage$default(IPagerIdKtxKt.getBridgeModule(routerPage6), str6, false, null, null, 30);
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
                        });
                        return Unit.INSTANCE;
                    }
                });
                final RouterPage routerPage2 = RouterPage.this;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.router_page.RouterPage$body$1.5
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.router_page.RouterPage.body.1.5.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.flexDirectionRow();
                                tVar2.flexWrapWrap();
                                return Unit.INSTANCE;
                            }
                        });
                        if (vVar2.getPager().getPageData().getIsAndroid()) {
                            final RouterPage routerPage3 = RouterPage.this;
                            w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.router_page.RouterPage.body.1.5.2
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(v vVar3) {
                                    v vVar4 = vVar3;
                                    vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.router_page.RouterPage.body.1.5.2.1
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(t tVar) {
                                            t tVar2 = tVar;
                                            tVar2.flexDirectionRow();
                                            tVar2.alignItemsCenter();
                                            tVar2.marginBottom(10.0f);
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    final RouterPage routerPage4 = RouterPage.this;
                                    vVar4.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.router_page.RouterPage.body.1.5.2.2
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(u uVar) {
                                            final RouterPage routerPage5 = RouterPage.this;
                                            uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.router_page.RouterPage.body.1.5.2.2.1
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(ClickParams clickParams) {
                                                    RouterPage routerPage6 = RouterPage.this;
                                                    routerPage6.selectDexMode$delegate.setValue(routerPage6, RouterPage.$$delegatedProperties[0], Boolean.valueOf(!routerPage6.getSelectDexMode()));
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.router_page.RouterPage.body.1.5.2.3
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(TextView textView) {
                                            textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.router_page.RouterPage.body.1.5.2.3.1
                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(ce ceVar) {
                                                    ce ceVar2 = ceVar;
                                                    ceVar2.text("\u662f\u5426dex\u6a21\u5f0f\u52a0\u8f7d");
                                                    ce.fontSize$default(ceVar2, 13.0f, null, 2, null);
                                                    ceVar2.marginLeft(10.0f);
                                                    ceVar2.mo135backgroundLinearGradient(Direction.TO_RIGHT, new j(new h(4283533037L), 0.0f), new j(new h(4283533037L), 1.0f));
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    final RouterPage routerPage5 = RouterPage.this;
                                    w.a(vVar4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.router_page.RouterPage.body.1.5.2.4
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(v vVar5) {
                                            v vVar6 = vVar5;
                                            vVar6.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.router_page.RouterPage.body.1.5.2.4.1
                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(t tVar) {
                                                    t tVar2 = tVar;
                                                    tVar2.size(15.0f, 15.0f);
                                                    tVar2.borderRadius(7.5f);
                                                    tVar2.marginLeft(5.0f);
                                                    tVar2.m136border(new com.tencent.kuikly.core.base.e(0.5f, BorderStyle.SOLID, new h(4283533037L)));
                                                    tVar2.allCenter();
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            final RouterPage routerPage6 = RouterPage.this;
                                            w.a(vVar6, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.router_page.RouterPage.body.1.5.2.4.2
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(v vVar7) {
                                                    final RouterPage routerPage7 = RouterPage.this;
                                                    vVar7.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.router_page.RouterPage.body.1.5.2.4.2.1
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(t tVar) {
                                                            t tVar2 = tVar;
                                                            tVar2.size(10.0f, 10.0f);
                                                            tVar2.borderRadius(5.0f);
                                                            tVar2.mo113backgroundColor(new h(4283533037L));
                                                            tVar2.m152visibility(RouterPage.this.getSelectDexMode());
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
                        } else {
                            final RouterPage routerPage4 = RouterPage.this;
                            w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.router_page.RouterPage.body.1.5.3
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(v vVar3) {
                                    v vVar4 = vVar3;
                                    vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.router_page.RouterPage.body.1.5.3.1
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(t tVar) {
                                            t tVar2 = tVar;
                                            tVar2.flexDirectionRow();
                                            tVar2.alignItemsCenter();
                                            tVar2.marginBottom(10.0f);
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    final RouterPage routerPage5 = RouterPage.this;
                                    vVar4.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.router_page.RouterPage.body.1.5.3.2
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(u uVar) {
                                            final RouterPage routerPage6 = RouterPage.this;
                                            uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.router_page.RouterPage.body.1.5.3.2.1
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(ClickParams clickParams) {
                                                    RouterPage routerPage7 = RouterPage.this;
                                                    routerPage7.selectJSMode$delegate.setValue(routerPage7, RouterPage.$$delegatedProperties[1], Boolean.valueOf(!routerPage7.getSelectJSMode()));
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.router_page.RouterPage.body.1.5.3.3
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(TextView textView) {
                                            textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.router_page.RouterPage.body.1.5.3.3.1
                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(ce ceVar) {
                                                    ce ceVar2 = ceVar;
                                                    ceVar2.text("\u662f\u5426\u672c\u5730\u4ee3\u7406\u6a21\u5f0f\u52a0\u8f7d");
                                                    ce.fontSize$default(ceVar2, 13.0f, null, 2, null);
                                                    ceVar2.marginLeft(10.0f);
                                                    ceVar2.mo135backgroundLinearGradient(Direction.TO_RIGHT, new j(new h(4283533037L), 0.0f), new j(new h(4283533037L), 1.0f));
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    final RouterPage routerPage6 = RouterPage.this;
                                    w.a(vVar4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.router_page.RouterPage.body.1.5.3.4
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(v vVar5) {
                                            v vVar6 = vVar5;
                                            vVar6.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.router_page.RouterPage.body.1.5.3.4.1
                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(t tVar) {
                                                    t tVar2 = tVar;
                                                    tVar2.size(15.0f, 15.0f);
                                                    tVar2.borderRadius(7.5f);
                                                    tVar2.marginLeft(5.0f);
                                                    tVar2.m136border(new com.tencent.kuikly.core.base.e(0.5f, BorderStyle.SOLID, new h(4283533037L)));
                                                    tVar2.allCenter();
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            final RouterPage routerPage7 = RouterPage.this;
                                            w.a(vVar6, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.router_page.RouterPage.body.1.5.3.4.2
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(v vVar7) {
                                                    final RouterPage routerPage8 = RouterPage.this;
                                                    vVar7.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.router_page.RouterPage.body.1.5.3.4.2.1
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(t tVar) {
                                                            t tVar2 = tVar;
                                                            tVar2.size(10.0f, 10.0f);
                                                            tVar2.borderRadius(5.0f);
                                                            tVar2.mo113backgroundColor(new h(4283533037L));
                                                            tVar2.m152visibility(RouterPage.this.getSelectJSMode());
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
                        }
                        final RouterPage routerPage5 = RouterPage.this;
                        vVar2.addChild(new HistorySelectorView(), new Function1<HistorySelectorView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.router_page.RouterPage.body.1.5.4
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(HistorySelectorView historySelectorView) {
                                HistorySelectorView historySelectorView2 = historySelectorView;
                                historySelectorView2.attr(new Function1<HistorySelectorViewAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.router_page.RouterPage.body.1.5.4.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(HistorySelectorViewAttr historySelectorViewAttr) {
                                        historySelectorViewAttr.marginLeft(20.0f);
                                        return Unit.INSTANCE;
                                    }
                                });
                                final RouterPage routerPage6 = RouterPage.this;
                                historySelectorView2.event(new Function1<HistorySelectorViewEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.router_page.RouterPage.body.1.5.4.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(HistorySelectorViewEvent historySelectorViewEvent) {
                                        HistorySelectorViewEvent historySelectorViewEvent2 = historySelectorViewEvent;
                                        final RouterPage routerPage7 = RouterPage.this;
                                        historySelectorViewEvent2.selectedHandler = new Function1<String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.router_page.RouterPage.body.1.5.4.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(String str) {
                                                String str2 = str;
                                                InputView b16 = RouterPage.this.getInputRef().b();
                                                if (b16 != null) {
                                                    b16.setText(str2);
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        };
                                        final RouterPage routerPage8 = RouterPage.this;
                                        historySelectorViewEvent2.openHistoryHandler = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.router_page.RouterPage.body.1.5.4.2.2
                                            {
                                                super(0);
                                            }

                                            @Override // kotlin.jvm.functions.Function0
                                            public final Unit invoke() {
                                                InputView b16 = RouterPage.this.getInputRef().b();
                                                if (b16 != null) {
                                                    b16.h();
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        };
                                        return Unit.INSTANCE;
                                    }
                                });
                                final RouterPage routerPage7 = RouterPage.this;
                                historySelectorView2.ref(historySelectorView2, new Function1<aa<HistorySelectorView>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.router_page.RouterPage.body.1.5.4.3
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(aa<HistorySelectorView> aaVar) {
                                        RouterPage.this.historyRef = aaVar;
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                cg.a(viewContainer2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.router_page.RouterPage$body$1.6
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(TextView textView) {
                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.router_page.RouterPage.body.1.6.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ce ceVar) {
                                String str;
                                ce ceVar2 = ceVar;
                                ce.fontSize$default(ceVar2, 12.0f, null, 2, null);
                                ceVar2.marginLeft(10.0f);
                                ceVar2.marginTop(5.0f);
                                if (Intrinsics.areEqual(ceVar2.getPagerData().n().p("execute_mode"), "1")) {
                                    str = "\u5982\uff1arouter \u6216\u8005 router&key=value \uff08&\u540e\u9762\u4e3a\u9875\u9762\u53c2\u6570\uff09";
                                } else {
                                    str = " \u5982\uff1arouter \u6216\u8005 router&key=value \uff08&\u540e\u9762\u4e3a\u9875\u9762\u53c2\u6570\uff09\n \u6ce8\uff1a\u771f\u673a\u8bbf\u95ee\u9700\u8981\u8ffd\u52a0\u7535\u8111ip\u5730\u5740\uff0c\u5982ip=10.45.3.76 \n \u793a\u4f8b\uff1amy_page_name&order_id=12434&ip=10.45.3.76";
                                }
                                ceVar2.text(str);
                                ceVar2.mo135backgroundLinearGradient(Direction.TO_RIGHT, new j(new h(4283533037L), 0.0f), new j(new h(4283533037L), 1.0f));
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                com.tencent.kuikly.core.views.compose.c.a(viewContainer2, new Function1<ButtonView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.router_page.RouterPage$body$1.7
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ButtonView buttonView) {
                        ButtonView buttonView2 = buttonView;
                        buttonView2.attr(new Function1<a, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.router_page.RouterPage.body.1.7.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(a aVar) {
                                a aVar2 = aVar;
                                aVar2.marginLeft(10.0f);
                                aVar2.marginTop(32.0f);
                                aVar2.mo153width(aVar2.getPagerData().m() / 2);
                                aVar2.mo141height(28.0f);
                                aVar2.borderRadius(6.0f);
                                aVar2.mo135backgroundLinearGradient(Direction.TO_RIGHT, new j(new h(4283533037L), 0.0f), new j(new h(4283533037L), 1.0f));
                                aVar2.q(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.router_page.RouterPage.body.1.7.1.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ce ceVar) {
                                        ce ceVar2 = ceVar;
                                        ceVar2.color(h.INSTANCE.m());
                                        ceVar2.value("Debug\u9875\u9762\u5feb\u901f\u6253\u5f00");
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        buttonView2.event(new Function1<com.tencent.kuikly.core.views.compose.b, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.router_page.RouterPage.body.1.7.2
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(com.tencent.kuikly.core.views.compose.b bVar) {
                                bVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.router_page.RouterPage.body.1.7.2.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ClickParams clickParams) {
                                        Mqq.INSTANCE.getUi().openKuikly("debug_page", new e());
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

    public final aa<InputView> getInputRef() {
        aa<InputView> aaVar = this.inputRef;
        if (aaVar != null) {
            return aaVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("inputRef");
        return null;
    }

    public final boolean getSelectDexMode() {
        return ((Boolean) this.selectDexMode$delegate.getValue(this, $$delegatedProperties[0])).booleanValue();
    }

    public final boolean getSelectJSMode() {
        return ((Boolean) this.selectJSMode$delegate.getValue(this, $$delegatedProperties[1])).booleanValue();
    }

    public final boolean isInQQContainer() {
        return getPageData().n().f("isQQContainer");
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final void viewDidLoad() {
        InputView b16;
        super.viewDidLoad();
        String item = ((CacheModule) getPager().acquireModule("HRCacheModule")).getItem("router_last_input_key2");
        if ((item.length() > 0) && (b16 = getInputRef().b()) != null) {
            b16.setText(item);
        }
        String item2 = ((r) acquireModule("KRSharedPreferencesModule")).getItem("dex_mode_key2");
        this.selectDexMode$delegate.setValue(this, $$delegatedProperties[0], Boolean.valueOf(item2.length() > 0 ? d.a(Integer.parseInt(item2)) : false));
    }
}
