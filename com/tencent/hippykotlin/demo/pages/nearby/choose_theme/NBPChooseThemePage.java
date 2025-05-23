package com.tencent.hippykotlin.demo.pages.nearby.choose_theme;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieCategoryHomePage$$ExternalSyntheticOutline1;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.hippykotlin.demo.pages.foundation.view.PAGAttr;
import com.tencent.hippykotlin.demo.pages.foundation.view.PAGEvent;
import com.tencent.hippykotlin.demo.pages.foundation.view.PAGView;
import com.tencent.hippykotlin.demo.pages.foundation.view.PAGViewKt;
import com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedItemView$body$1$3$3$3$3$1$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyBasePager;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.UserDataManager;
import com.tencent.hippykotlin.demo.pages.nearby.base.module.QQNearbyModule;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPHalfScreenModalAttr;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPHalfScreenModalEvent;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPHalfScreenModalView;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPHalfScreenModalViewKt;
import com.tencent.kuikly.core.base.Direction;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.aa;
import com.tencent.kuikly.core.base.attr.AccessibilityRole;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.j;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.directives.BindDirectivesView;
import com.tencent.kuikly.core.directives.BindDirectivesViewKt;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
import com.tencent.kuikly.core.directives.LoopDirectivesView;
import com.tencent.kuikly.core.directives.LoopDirectivesViewKt;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.module.k;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.timer.TimerKt;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ah;
import com.tencent.kuikly.core.views.ao;
import com.tencent.kuikly.core.views.aq;
import com.tencent.kuikly.core.views.ar;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.f;
import com.tencent.kuikly.core.views.h;
import com.tencent.kuikly.core.views.i;
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
import kotlin.text.StringsKt__StringsKt;

/* loaded from: classes31.dex */
public final class NBPChooseThemePage extends NearbyBasePager {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPChooseThemePage.class, "preloadThemeLoadingPAGView", "getPreloadThemeLoadingPAGView()Z", 0)};
    public aa<NBPHalfScreenModalView> modalViewRef;
    public NBPChooseThemeViewModel pageModel;
    public String curThemeId = "";
    public float listViewHeight = 645.0f;
    public final ReadWriteProperty preloadThemeLoadingPAGView$delegate = c.a(Boolean.TRUE);
    public e baseReportParams = new e();

    public static final e access$getReportParams(NBPChooseThemePage nBPChooseThemePage, String str) {
        nBPChooseThemePage.getClass();
        e eVar = new e(nBPChooseThemePage.baseReportParams.toString());
        eVar.v("dt_eid", "em_nearby_thematic_map_float");
        eVar.v("nearby_map_id", str);
        return eVar;
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.choose_theme.NBPChooseThemePage$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                final NBPChooseThemePage nBPChooseThemePage = NBPChooseThemePage.this;
                NBPHalfScreenModalViewKt.NBPHalfScreenModal(viewContainer2, new Function1<NBPHalfScreenModalView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.choose_theme.NBPChooseThemePage$body$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(NBPHalfScreenModalView nBPHalfScreenModalView) {
                        NBPHalfScreenModalView nBPHalfScreenModalView2 = nBPHalfScreenModalView;
                        final NBPChooseThemePage nBPChooseThemePage2 = NBPChooseThemePage.this;
                        nBPHalfScreenModalView2.ref(nBPHalfScreenModalView2, new Function1<aa<NBPHalfScreenModalView>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.choose_theme.NBPChooseThemePage.body.1.1.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(aa<NBPHalfScreenModalView> aaVar) {
                                NBPChooseThemePage.this.modalViewRef = aaVar;
                                return Unit.INSTANCE;
                            }
                        });
                        final NBPChooseThemePage nBPChooseThemePage3 = NBPChooseThemePage.this;
                        nBPHalfScreenModalView2.attr(new Function1<NBPHalfScreenModalAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.choose_theme.NBPChooseThemePage.body.1.1.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(NBPHalfScreenModalAttr nBPHalfScreenModalAttr) {
                                NBPHalfScreenModalAttr nBPHalfScreenModalAttr2 = nBPHalfScreenModalAttr;
                                nBPHalfScreenModalAttr2.mo153width(nBPHalfScreenModalAttr2.getPagerData().m());
                                nBPHalfScreenModalAttr2.mo141height(nBPHalfScreenModalAttr2.getPagerData().l());
                                nBPHalfScreenModalAttr2.contentHeight = NBPChooseThemePage.this.listViewHeight;
                                nBPHalfScreenModalAttr2.contentBorderRadius = 6.0f;
                                return Unit.INSTANCE;
                            }
                        });
                        nBPHalfScreenModalView2.event(new Function1<NBPHalfScreenModalEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.choose_theme.NBPChooseThemePage.body.1.1.3
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(NBPHalfScreenModalEvent nBPHalfScreenModalEvent) {
                                nBPHalfScreenModalEvent.onCloseHandler = new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.choose_theme.NBPChooseThemePage.body.1.1.3.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(Object obj) {
                                        QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
                                        QQKuiklyPlatformApi.Companion.closePage$default();
                                        return Unit.INSTANCE;
                                    }
                                };
                                return Unit.INSTANCE;
                            }
                        });
                        final NBPChooseThemePage nBPChooseThemePage4 = NBPChooseThemePage.this;
                        nBPHalfScreenModalView2.contentBuilder = new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.choose_theme.NBPChooseThemePage.body.1.1.4
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ViewContainer<?, ?> viewContainer3) {
                                ViewContainer<?, ?> viewContainer4 = viewContainer3;
                                viewContainer4.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.choose_theme.NBPChooseThemePage.body.1.1.4.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(m mVar) {
                                        mVar.mo113backgroundColor(QUIToken.color$default("bg_middle_light"));
                                        return Unit.INSTANCE;
                                    }
                                });
                                viewContainer4.addChild(new NBPChooseThemeDragBar(), new Function1<NBPChooseThemeDragBar, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.choose_theme.NBPChooseThemePage.body.1.1.4.2
                                    @Override // kotlin.jvm.functions.Function1
                                    public final /* bridge */ /* synthetic */ Unit invoke(NBPChooseThemeDragBar nBPChooseThemeDragBar) {
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPChooseThemePage nBPChooseThemePage5 = NBPChooseThemePage.this;
                                ar.a(viewContainer4, new Function1<aq<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.choose_theme.NBPChooseThemePage.body.1.1.4.3
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(aq<?, ?> aqVar) {
                                        aq<?, ?> aqVar2 = aqVar;
                                        aqVar2.attr(new Function1<ao, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.choose_theme.NBPChooseThemePage.body.1.1.4.3.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ao aoVar) {
                                                aoVar.m140flex(1.0f);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final NBPChooseThemePage nBPChooseThemePage6 = NBPChooseThemePage.this;
                                        Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.choose_theme.NBPChooseThemePage.body.1.1.4.3.2
                                            {
                                                super(0);
                                            }

                                            @Override // kotlin.jvm.functions.Function0
                                            public final Object invoke() {
                                                NBPChooseThemeViewModel pageModel = NBPChooseThemePage.this.getPageModel();
                                                return Integer.valueOf(((Number) pageModel.pageState$delegate.getValue(pageModel, NBPChooseThemeViewModel.$$delegatedProperties[1])).intValue());
                                            }
                                        };
                                        final NBPChooseThemePage nBPChooseThemePage7 = NBPChooseThemePage.this;
                                        BindDirectivesViewKt.a(aqVar2, function0, new Function1<BindDirectivesView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.choose_theme.NBPChooseThemePage.body.1.1.4.3.3
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(BindDirectivesView bindDirectivesView) {
                                                BindDirectivesView bindDirectivesView2 = bindDirectivesView;
                                                NBPChooseThemeViewModel pageModel = NBPChooseThemePage.this.getPageModel();
                                                int intValue = ((Number) pageModel.pageState$delegate.getValue(pageModel, NBPChooseThemeViewModel.$$delegatedProperties[1])).intValue();
                                                if (intValue == 0) {
                                                    final NBPChooseThemePage nBPChooseThemePage8 = NBPChooseThemePage.this;
                                                    w.a(bindDirectivesView2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.choose_theme.NBPChooseThemePage.body.1.1.4.3.3.1
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(v vVar) {
                                                            v vVar2 = vVar;
                                                            vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.choose_theme.NBPChooseThemePage.body.1.1.4.3.3.1.1
                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(t tVar) {
                                                                    t tVar2 = tVar;
                                                                    tVar2.flexDirectionColumn();
                                                                    tVar2.mo113backgroundColor(QUIToken.color$default("bg_middle_light"));
                                                                    tVar2.m140flex(1.0f);
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                            final NBPChooseThemePage nBPChooseThemePage9 = NBPChooseThemePage.this;
                                                            w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.choose_theme.NBPChooseThemePage.body.1.1.4.3.3.1.2
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(v vVar3) {
                                                                    v vVar4 = vVar3;
                                                                    vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.choose_theme.NBPChooseThemePage.body.1.1.4.3.3.1.2.1
                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        public final Unit invoke(t tVar) {
                                                                            t tVar2 = tVar;
                                                                            tVar2.m140flex(1.0f);
                                                                            tVar2.mo153width(tVar2.getPagerData().m());
                                                                            tVar2.paddingTop(200.0f);
                                                                            tVar2.justifyContentCenter();
                                                                            tVar2.flexDirectionRow();
                                                                            return Unit.INSTANCE;
                                                                        }
                                                                    });
                                                                    final NBPChooseThemePage nBPChooseThemePage10 = NBPChooseThemePage.this;
                                                                    i.a(vVar4, new Function1<h, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.choose_theme.NBPChooseThemePage.body.1.1.4.3.3.1.2.2
                                                                        {
                                                                            super(1);
                                                                        }

                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        public final Unit invoke(h hVar) {
                                                                            final NBPChooseThemePage nBPChooseThemePage11 = NBPChooseThemePage.this;
                                                                            hVar.attr(new Function1<f, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.choose_theme.NBPChooseThemePage.body.1.1.4.3.3.1.2.2.1
                                                                                {
                                                                                    super(1);
                                                                                }

                                                                                @Override // kotlin.jvm.functions.Function1
                                                                                public final Unit invoke(f fVar) {
                                                                                    f fVar2 = fVar;
                                                                                    fVar2.size(20.0f, 20.0f);
                                                                                    fVar2.h(!NBPChooseThemePage.this.getPager().isNightMode());
                                                                                    return Unit.INSTANCE;
                                                                                }
                                                                            });
                                                                            return Unit.INSTANCE;
                                                                        }
                                                                    });
                                                                    cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.choose_theme.NBPChooseThemePage.body.1.1.4.3.3.1.2.3
                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        public final Unit invoke(TextView textView) {
                                                                            textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.choose_theme.NBPChooseThemePage.body.1.1.4.3.3.1.2.3.1
                                                                                @Override // kotlin.jvm.functions.Function1
                                                                                public final Unit invoke(ce ceVar) {
                                                                                    ce ceVar2 = ceVar;
                                                                                    ceVar2.marginLeft(4.0f);
                                                                                    ceVar2.text("\u52a0\u8f7d\u4e2d,\u8bf7\u7a0d\u540e...");
                                                                                    NBPArticleFeedItemView$body$1$3$3$3$3$1$1$$ExternalSyntheticOutline0.m(ceVar2, 13.0f, null, 2, null, "text_primary");
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
                                                } else if (intValue == 1) {
                                                    final NBPChooseThemePage nBPChooseThemePage9 = NBPChooseThemePage.this;
                                                    w.a(bindDirectivesView2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.choose_theme.NBPChooseThemePage.body.1.1.4.3.3.6
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(v vVar) {
                                                            v vVar2 = vVar;
                                                            vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.choose_theme.NBPChooseThemePage.body.1.1.4.3.3.6.1
                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(t tVar) {
                                                                    t tVar2 = tVar;
                                                                    tVar2.m140flex(1.0f);
                                                                    tVar2.mo113backgroundColor(QUIToken.color$default("bg_middle_light"));
                                                                    tVar2.flexDirectionColumn();
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                            final NBPChooseThemePage nBPChooseThemePage10 = NBPChooseThemePage.this;
                                                            vVar2.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.choose_theme.NBPChooseThemePage.body.1.1.4.3.3.6.2
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(u uVar) {
                                                                    final NBPChooseThemePage nBPChooseThemePage11 = NBPChooseThemePage.this;
                                                                    uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.choose_theme.NBPChooseThemePage.body.1.1.4.3.3.6.2.1
                                                                        {
                                                                            super(1);
                                                                        }

                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        public final Unit invoke(ClickParams clickParams) {
                                                                            NBPChooseThemePage nBPChooseThemePage12 = NBPChooseThemePage.this;
                                                                            KProperty<Object>[] kPropertyArr = NBPChooseThemePage.$$delegatedProperties;
                                                                            nBPChooseThemePage12.getPageModel().setPageState(0);
                                                                            nBPChooseThemePage12.getPageModel().retryCount = 0;
                                                                            nBPChooseThemePage12.getPageModel().requestMapThemeList();
                                                                            return Unit.INSTANCE;
                                                                        }
                                                                    });
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                            w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.choose_theme.NBPChooseThemePage.body.1.1.4.3.3.6.3
                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(v vVar3) {
                                                                    v vVar4 = vVar3;
                                                                    vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.choose_theme.NBPChooseThemePage.body.1.1.4.3.3.6.3.1
                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        public final Unit invoke(t tVar) {
                                                                            t tVar2 = tVar;
                                                                            tVar2.m140flex(1.0f);
                                                                            tVar2.mo153width(tVar2.getPagerData().m());
                                                                            tVar2.alignItemsCenter();
                                                                            return Unit.INSTANCE;
                                                                        }
                                                                    });
                                                                    ah.a(vVar4, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.choose_theme.NBPChooseThemePage.body.1.1.4.3.3.6.3.2
                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        public final Unit invoke(ImageView imageView) {
                                                                            imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.choose_theme.NBPChooseThemePage.body.1.1.4.3.3.6.3.2.1
                                                                                @Override // kotlin.jvm.functions.Function1
                                                                                public final Unit invoke(af afVar) {
                                                                                    af afVar2 = afVar;
                                                                                    afVar2.size(86.0f, 86.0f);
                                                                                    afVar2.marginTop(200.0f);
                                                                                    b.a.b(afVar2, "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAMgAAADICAMAAACahl6sAAAATlBMVEUAAABMTExMTExQUFBMTExMTExISEhLS0tLS0tMTExQUFBAQEBLS0tKSkpLS0tNTU1MTExMTExMTExMTExKSkpJSUlMTExLS0tMTExMTEzb8illAAAAGXRSTlMA3+8gv4AgX5BAEBBwMKCfz2+vUI9QQc4/sIny8wAAB+NJREFUeNrtndty2yAQhlkOAnSWHLvV+79oJ8TxOnXqALuScEf/XWbSKp/2wAILEocOHTp06NChQ4cOHSJKddYMgwaAJUjCqGdnzr4Wr6K6m4ZRLv+U1G7yonDV3mm5xEi7cm2jJr0kSU9KFCdv4KsDjYObrFdKiaBGdf40ufkvg4EriqX+YgsYptOTP6/x03wPPdpSWPwsEcLZRkSoOvUjsvQlBL/VuT5fWX1nFrGragNI0YhkNcgCe6JM8vOFmmQKtAvsjXKGT2N4YpANe6L4q1NIVwmyqhvK1hmsdlcM9CkmlH5TFHsNDocYDCib+5fS19hAp2JC2dYo5w9zgBfsOsFGRsHokEasIrMEvTViZSlAr1pFFayevjDKZStWEhpFruZe+AzoxHpCoxixluo+JefS43Be6UFqRLdaW+2KgaIA3Wp9dYAka3CMldhIFZKswKEbsZnqGUm4OXqxqRyS8HIYsbHMB8nLc9xIXp6DmaQmctBJRp4cE7KHEzspVBMD2zuZxW7STP5gg5c2YjfVoTKy5ECX7xzU8Zw+xkvFEeid2FWdRKcgDa6t2FltmP2SA8SJ3RXe55k4EkIjdleNYZKfwytRgEKYaJJjGVGEQphYgmONohDpd+dqXtyx3lXJ3MylCnKsW6nkRbpCxhIFCfLi3X6k7oJ0yfuLIFTPRUnn+IjliXTvYAkae0WPd6yXCAahbNBxbRU4TMGbGqQekYJlxlpLTKRbGsQtf+mNIwXDlgbBgQh8c7ep5skmSSxURg6D9F9K5xo4TOLSxhJPNAi+jdPXYQDIiSvNrj3LGPL+TIGq8WfiWDInObfnBhEsID4lA9vgBGWCBIdtE37Xlgpi4sNd0UO9ewbSiUxhqHWEFBet+jzI5RnIAv25poW7iR7VLa1T8znIu+YzZfYO0Z7VZLY4BoofQYKgV/m+pSKJdZ4xsH35GUiAJfQz6ci8pfM8y+sbhfPPs5Z3EIFCfdN1Vs5SPVLEpF8/QDZKFXw/auj8lRsbemqixxH7iZLcFglRhYdLr7M83LXNRoOgN4JNL4FdVIiccuaz2qeP7BfI8S8bFSQYIknmkDavRLGQ3iBZxxSOPrFgnLBvNgcEuxhNYpB0EbltTmh8wfeZB4INc1olzZfaiEBqEzs1XUOsfk1im1kbkZB0wpyqkyE6PK2Mx6CXsQ8+RQwRMr7QshJb0YggohqDUWz8kCgjEkIkx4dbcU2sTErIyx/rRh9ZMeKDM0DoJCOmrSfeN8dzWM6pro0n6X90QxO5r94hBxuI8CHofkcWKYYn+xrk4ADBNGh48u8cXWkZ5KCDIImJTjQD1zDSrbEcVMXvwunYdFDoutZtIIEfyzH1P4CEgf1/AOF5mIVnIMC0HLs6iAVcv2q+XdcC+wIgXZiI4xrBY8n6UbKXDmJwpdE9br0NuNJoigZR+u6v9OHVnz8wLnBbDPg8AarKBfESz/Y92Z6uhgUZ6SD848iEE/gfGgYsUNwLp038IBgec/NjCwcaxZQ4sn87Mar6q1XA+dh5VOQs4ldE0ZjNIRPc/iSfkFCKRpx6ZXNAl9bzHkGSPpFFkDbrf8azAIkk58ztt7eIqW6eRSRyJJCY3JYUEzH1yiPpchqsp+xDRqeIdJClivcfEXISruEVL5w2Pf2VUm5XIgzs2GTFpdpoWBbJeCcYDiOp+ZdWDRM21QnZF5e+WNRK5OA50o9Ja4qoYkDwyCwo1lscIGJlteZbR2nx9rAu1O3otAztq0kdHPQTjHJCN2M4TYj1kE7Zjad3y8ru8ZgUXT3Getz+NN3+04Or0bwWhwhPaIci94dperxjQxlXO1RcrBE6wQgdHLyPk7iu/zDTpr+iidIORV+wiUibnA1l8O5b5YJgezVbi3DqekzHMkfQ0aceOqpvYc5IjFJ6ezUhTSbYFTBKaZ71K2EIGFlisn0YECsOl7UpB4A8g289ligDy6nKKqXe1yynhGX7tWisOOqsIe1okmK6tcx2QqhWhx8mllD/neYWrsSJVY+hHp0aZMM91Z146kWbmhuMYLqdlO/m0z65WjNoEiLKpOWygMa+8c0Mghn4TRQmNEhKyilvyRENkn4xQVFCgyRv3VxEQTplXo2iS7y8AkS6fInXiVTZFxMUE+9V/l10tSwp3oFw85ot4pawO8eyxClFAULHylIlS7ooDCpK6i6jUnHBsY7L9IJNCwiTjnrnJYaJEjtKActs3xIvy2G63NYyZXAtdtPMVir11Ouw6Qlr5rHtuOvFxYxDWbX3VdKVEC9OcuN4cRLkYCTZoVjpkYObZN7ykwT6W45iP9rwL6kROZhJtv5sB3Lwk2xWC7d4MptbeJ/A21aftuk5HkS6CoDuVqtneyvXf0YrIz7/VP73spReIsOc7r9rGsXIjeIQzxXBSbDrAkvCMZRiP/dH+DwhwSiIwuizyVFe3pcxayMJtwKTUIARRbkrhv4ttpcFpi8uX0JsEI5Y8qGAVfk+NRIaCvhRFm3rDIoWP9lsGrGr7LggS5JdFFIs2or95e/6NMb+HAVTWwfYpDL/FmWosuOCgnm61E8McW4HWFB6KmADBlWFN4ySenbT+dKpK5JS6mJbN4xyuReYIjbEHvpnliTpqZg947/VeBcHI7XzRXnUd/KT0/IJwzhMXfEQd7Y5GTfrEa5IAKCHwdiuWG86dOjQoUOHDh06dOhl9Aea9iC3qxu2fAAAAABJRU5ErkJggg==", false, 2, null);
                                                                                    afVar2.t(QUIToken.color$default("icon_primary"));
                                                                                    return Unit.INSTANCE;
                                                                                }
                                                                            });
                                                                            return Unit.INSTANCE;
                                                                        }
                                                                    });
                                                                    cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.choose_theme.NBPChooseThemePage.body.1.1.4.3.3.6.3.3
                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        public final Unit invoke(TextView textView) {
                                                                            textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.choose_theme.NBPChooseThemePage.body.1.1.4.3.3.6.3.3.1
                                                                                @Override // kotlin.jvm.functions.Function1
                                                                                public final Unit invoke(ce ceVar) {
                                                                                    ce ceVar2 = ceVar;
                                                                                    ceVar2.marginTop(24.0f);
                                                                                    ceVar2.text("\u7f51\u7edc\u5f02\u5e38\uff0c\u70b9\u51fb\u91cd\u8bd5");
                                                                                    NBPArticleFeedItemView$body$1$3$3$3$3$1$1$$ExternalSyntheticOutline0.m(ceVar2, 13.0f, null, 2, null, "text_primary");
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
                                                } else if (intValue == 2) {
                                                    final NBPChooseThemePage nBPChooseThemePage10 = NBPChooseThemePage.this;
                                                    Function0<com.tencent.kuikly.core.reactive.collection.c<o25.f>> function02 = new Function0<com.tencent.kuikly.core.reactive.collection.c<o25.f>>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.choose_theme.NBPChooseThemePage.body.1.1.4.3.3.2
                                                        {
                                                            super(0);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function0
                                                        public final com.tencent.kuikly.core.reactive.collection.c<o25.f> invoke() {
                                                            return NBPChooseThemePage.this.getPageModel().getMapThemeList();
                                                        }
                                                    };
                                                    final NBPChooseThemePage nBPChooseThemePage11 = NBPChooseThemePage.this;
                                                    LoopDirectivesViewKt.a(bindDirectivesView2, function02, new Function2<LoopDirectivesView<o25.f>, o25.f, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.choose_theme.NBPChooseThemePage.body.1.1.4.3.3.3
                                                        {
                                                            super(2);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function2
                                                        public final Unit invoke(LoopDirectivesView<o25.f> loopDirectivesView, o25.f fVar) {
                                                            final o25.f fVar2 = fVar;
                                                            final NBPChooseThemePage nBPChooseThemePage12 = NBPChooseThemePage.this;
                                                            w.a(loopDirectivesView, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.choose_theme.NBPChooseThemePage.body.1.1.4.3.3.3.1
                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(v vVar) {
                                                                    v vVar2 = vVar;
                                                                    final o25.f fVar3 = o25.f.this;
                                                                    vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.choose_theme.NBPChooseThemePage.body.1.1.4.3.3.3.1.1
                                                                        {
                                                                            super(1);
                                                                        }

                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        public final Unit invoke(t tVar) {
                                                                            t tVar2 = tVar;
                                                                            tVar2.flexDirectionRow();
                                                                            tVar2.size(tVar2.getPagerData().m(), 112.0f);
                                                                            tVar2.alignItemsCenter();
                                                                            tVar2.mo113backgroundColor(QUIToken.color$default("bg_middle_light"));
                                                                            tVar2.accessibility(o25.f.this.f421850e);
                                                                            tVar2.accessibilityRole(AccessibilityRole.BUTTON);
                                                                            return Unit.INSTANCE;
                                                                        }
                                                                    });
                                                                    if (Intrinsics.areEqual(o25.f.this.f421849d, nBPChooseThemePage12.curThemeId)) {
                                                                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.choose_theme.NBPChooseThemePage.body.1.1.4.3.3.3.1.2
                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(v vVar3) {
                                                                                v vVar4 = vVar3;
                                                                                vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.choose_theme.NBPChooseThemePage.body.1.1.4.3.3.3.1.2.1
                                                                                    @Override // kotlin.jvm.functions.Function1
                                                                                    public final Unit invoke(t tVar) {
                                                                                        t tVar2 = tVar;
                                                                                        tVar2.absolutePosition(4.5f, 17.5f, 4.5f, 17.5f);
                                                                                        tVar2.borderRadius(17.0f);
                                                                                        tVar2.mo135backgroundLinearGradient(Direction.TO_TOP_RIGHT, new j(new com.tencent.kuikly.core.base.h(255, 69, 114, 1.0f), 0.0f), new j(new com.tencent.kuikly.core.base.h(255, 209, 79, 1.0f), 1.0f));
                                                                                        return Unit.INSTANCE;
                                                                                    }
                                                                                });
                                                                                w.a(vVar4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.choose_theme.NBPChooseThemePage.body.1.1.4.3.3.3.1.2.2
                                                                                    @Override // kotlin.jvm.functions.Function1
                                                                                    public final Unit invoke(v vVar5) {
                                                                                        vVar5.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.choose_theme.NBPChooseThemePage.body.1.1.4.3.3.3.1.2.2.1
                                                                                            @Override // kotlin.jvm.functions.Function1
                                                                                            public final Unit invoke(t tVar) {
                                                                                                t tVar2 = tVar;
                                                                                                tVar2.absolutePosition(1.5f, 1.5f, 1.5f, 1.5f);
                                                                                                tVar2.borderRadius(16.0f);
                                                                                                tVar2.mo113backgroundColor(QUIToken.color$default("bg_middle_light"));
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
                                                                    final o25.f fVar4 = o25.f.this;
                                                                    ah.a(vVar2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.choose_theme.NBPChooseThemePage.body.1.1.4.3.3.3.1.3
                                                                        {
                                                                            super(1);
                                                                        }

                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        public final Unit invoke(ImageView imageView) {
                                                                            final o25.f fVar5 = o25.f.this;
                                                                            imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.choose_theme.NBPChooseThemePage.body.1.1.4.3.3.3.1.3.1
                                                                                {
                                                                                    super(1);
                                                                                }

                                                                                @Override // kotlin.jvm.functions.Function1
                                                                                public final Unit invoke(af afVar) {
                                                                                    af afVar2 = afVar;
                                                                                    afVar2.absolutePosition(5.8f, 19.0f, 6.0f, 19.0f);
                                                                                    afVar2.p();
                                                                                    afVar2.borderRadius(16.0f);
                                                                                    b.a.b(afVar2, o25.f.this.E, false, 2, null);
                                                                                    if (com.tencent.kuikly.core.manager.c.f117352a.g().isNightMode()) {
                                                                                        afVar2.m147opacity(0.3f);
                                                                                    }
                                                                                    return Unit.INSTANCE;
                                                                                }
                                                                            });
                                                                            return Unit.INSTANCE;
                                                                        }
                                                                    });
                                                                    final o25.f fVar5 = o25.f.this;
                                                                    w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.choose_theme.NBPChooseThemePage.body.1.1.4.3.3.3.1.4
                                                                        {
                                                                            super(1);
                                                                        }

                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        public final Unit invoke(v vVar3) {
                                                                            v vVar4 = vVar3;
                                                                            vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.choose_theme.NBPChooseThemePage.body.1.1.4.3.3.3.1.4.1
                                                                                @Override // kotlin.jvm.functions.Function1
                                                                                public final Unit invoke(t tVar) {
                                                                                    t tVar2 = tVar;
                                                                                    tVar2.flexDirectionColumn();
                                                                                    tVar2.marginLeft(40.0f);
                                                                                    return Unit.INSTANCE;
                                                                                }
                                                                            });
                                                                            final o25.f fVar6 = o25.f.this;
                                                                            cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.choose_theme.NBPChooseThemePage.body.1.1.4.3.3.3.1.4.2
                                                                                {
                                                                                    super(1);
                                                                                }

                                                                                @Override // kotlin.jvm.functions.Function1
                                                                                public final Unit invoke(TextView textView) {
                                                                                    final o25.f fVar7 = o25.f.this;
                                                                                    textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.choose_theme.NBPChooseThemePage.body.1.1.4.3.3.3.1.4.2.1
                                                                                        {
                                                                                            super(1);
                                                                                        }

                                                                                        @Override // kotlin.jvm.functions.Function1
                                                                                        public final Unit invoke(ce ceVar) {
                                                                                            String str;
                                                                                            ce ceVar2 = ceVar;
                                                                                            o25.f fVar8 = o25.f.this;
                                                                                            if (fVar8.H) {
                                                                                                str = StringsKt__StringsKt.removeSuffix(UserDataManager.INSTANCE.getUserSelfInfo().locationCity, (CharSequence) "\u5e02");
                                                                                            } else {
                                                                                                str = fVar8.f421850e;
                                                                                            }
                                                                                            ceVar2.text(str);
                                                                                            ceVar2.color(QUIToken.color$default("text_primary"));
                                                                                            ceVar2.fontWeight600();
                                                                                            ce.fontSize$default(ceVar2, 20.0f, null, 2, null);
                                                                                            return Unit.INSTANCE;
                                                                                        }
                                                                                    });
                                                                                    return Unit.INSTANCE;
                                                                                }
                                                                            });
                                                                            final o25.f fVar7 = o25.f.this;
                                                                            cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.choose_theme.NBPChooseThemePage.body.1.1.4.3.3.3.1.4.3
                                                                                {
                                                                                    super(1);
                                                                                }

                                                                                @Override // kotlin.jvm.functions.Function1
                                                                                public final Unit invoke(TextView textView) {
                                                                                    final o25.f fVar8 = o25.f.this;
                                                                                    textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.choose_theme.NBPChooseThemePage.body.1.1.4.3.3.3.1.4.3.1
                                                                                        {
                                                                                            super(1);
                                                                                        }

                                                                                        @Override // kotlin.jvm.functions.Function1
                                                                                        public final Unit invoke(ce ceVar) {
                                                                                            ce ceVar2 = ceVar;
                                                                                            ceVar2.text(o25.f.this.I + '\u4eba' + o25.f.this.f421852h);
                                                                                            ceVar2.marginTop(5.0f);
                                                                                            NBPArticleFeedItemView$body$1$3$3$3$3$1$1$$ExternalSyntheticOutline0.m(ceVar2, 12.0f, null, 2, null, "text_secondary");
                                                                                            return Unit.INSTANCE;
                                                                                        }
                                                                                    });
                                                                                    return Unit.INSTANCE;
                                                                                }
                                                                            });
                                                                            return Unit.INSTANCE;
                                                                        }
                                                                    });
                                                                    w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.choose_theme.NBPChooseThemePage.body.1.1.4.3.3.3.1.5
                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        public final Unit invoke(v vVar3) {
                                                                            vVar3.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.choose_theme.NBPChooseThemePage.body.1.1.4.3.3.3.1.5.1
                                                                                @Override // kotlin.jvm.functions.Function1
                                                                                public final Unit invoke(t tVar) {
                                                                                    tVar.m140flex(1.0f);
                                                                                    return Unit.INSTANCE;
                                                                                }
                                                                            });
                                                                            return Unit.INSTANCE;
                                                                        }
                                                                    });
                                                                    final o25.f fVar6 = o25.f.this;
                                                                    ah.a(vVar2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.choose_theme.NBPChooseThemePage.body.1.1.4.3.3.3.1.6
                                                                        {
                                                                            super(1);
                                                                        }

                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        public final Unit invoke(ImageView imageView) {
                                                                            final o25.f fVar7 = o25.f.this;
                                                                            imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.choose_theme.NBPChooseThemePage.body.1.1.4.3.3.3.1.6.1
                                                                                {
                                                                                    super(1);
                                                                                }

                                                                                @Override // kotlin.jvm.functions.Function1
                                                                                public final Unit invoke(af afVar) {
                                                                                    af afVar2 = afVar;
                                                                                    afVar2.size(85.0f, 85.0f);
                                                                                    afVar2.marginRight(40.0f);
                                                                                    afVar2.o();
                                                                                    b.a.b(afVar2, o25.f.this.f421851f, false, 2, null);
                                                                                    return Unit.INSTANCE;
                                                                                }
                                                                            });
                                                                            return Unit.INSTANCE;
                                                                        }
                                                                    });
                                                                    final o25.f fVar7 = o25.f.this;
                                                                    final NBPChooseThemePage nBPChooseThemePage13 = nBPChooseThemePage12;
                                                                    vVar2.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.choose_theme.NBPChooseThemePage.body.1.1.4.3.3.3.1.7
                                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                        {
                                                                            super(1);
                                                                        }

                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        public final Unit invoke(u uVar) {
                                                                            final o25.f fVar8 = o25.f.this;
                                                                            final NBPChooseThemePage nBPChooseThemePage14 = nBPChooseThemePage13;
                                                                            uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.choose_theme.NBPChooseThemePage.body.1.1.4.3.3.3.1.7.1
                                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                {
                                                                                    super(1);
                                                                                }

                                                                                @Override // kotlin.jvm.functions.Function1
                                                                                public final Unit invoke(ClickParams clickParams) {
                                                                                    KLog kLog = KLog.INSTANCE;
                                                                                    StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("change map theme to : ");
                                                                                    m3.append(o25.f.this.f421849d);
                                                                                    m3.append("+++");
                                                                                    AdelieCategoryHomePage$$ExternalSyntheticOutline1.m(m3, o25.f.this.f421850e, kLog, "nearbyProChooseTheme");
                                                                                    e access$getReportParams = NBPChooseThemePage.access$getReportParams(nBPChooseThemePage14, o25.f.this.f421849d);
                                                                                    access$getReportParams.v(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
                                                                                    Utils.INSTANCE.currentBridgeModule().reportCustomDtEvent("dt_clck", access$getReportParams);
                                                                                    k.d((k) com.tencent.kuikly.core.manager.c.f117352a.g().acquireModule("KRNotifyModule"), "NEARBY_CHANGE_MAP_THEME", new e().v("id", o25.f.this.f421849d), false, 4, null);
                                                                                    QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
                                                                                    QQKuiklyPlatformApi.Companion.closePage$default();
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
                                                    final NBPChooseThemePage nBPChooseThemePage12 = NBPChooseThemePage.this;
                                                    ConditionViewKt.c(bindDirectivesView2, new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.choose_theme.NBPChooseThemePage.body.1.1.4.3.3.4
                                                        {
                                                            super(0);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function0
                                                        public final Object invoke() {
                                                            return Boolean.valueOf(NBPChooseThemePage.this.getPageModel().getMapThemeList().size() < 5);
                                                        }
                                                    }, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.choose_theme.NBPChooseThemePage.body.1.1.4.3.3.5
                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(ConditionView conditionView) {
                                                            w.a(conditionView, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.choose_theme.NBPChooseThemePage.body.1.1.4.3.3.5.1
                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(v vVar) {
                                                                    v vVar2 = vVar;
                                                                    vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.choose_theme.NBPChooseThemePage.body.1.1.4.3.3.5.1.1
                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        public final Unit invoke(t tVar) {
                                                                            t tVar2 = tVar;
                                                                            tVar2.mo141height(110.0f);
                                                                            tVar2.mo113backgroundColor(QUIToken.color$default("bg_middle_light"));
                                                                            tVar2.allCenter();
                                                                            tVar2.flexDirectionColumn();
                                                                            return Unit.INSTANCE;
                                                                        }
                                                                    });
                                                                    ah.a(vVar2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.choose_theme.NBPChooseThemePage.body.1.1.4.3.3.5.1.2
                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        public final Unit invoke(ImageView imageView) {
                                                                            imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.choose_theme.NBPChooseThemePage.body.1.1.4.3.3.5.1.2.1
                                                                                @Override // kotlin.jvm.functions.Function1
                                                                                public final Unit invoke(af afVar) {
                                                                                    af afVar2 = afVar;
                                                                                    afVar2.size(40.0f, 40.0f);
                                                                                    b.a.b(afVar2, "https://vfiles.gtimg.cn/wuji_dashboard/xy/componenthub/xyePjW3i.png", false, 2, null);
                                                                                    return Unit.INSTANCE;
                                                                                }
                                                                            });
                                                                            return Unit.INSTANCE;
                                                                        }
                                                                    });
                                                                    cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.choose_theme.NBPChooseThemePage.body.1.1.4.3.3.5.1.3
                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        public final Unit invoke(TextView textView) {
                                                                            textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.choose_theme.NBPChooseThemePage.body.1.1.4.3.3.5.1.3.1
                                                                                @Override // kotlin.jvm.functions.Function1
                                                                                public final Unit invoke(ce ceVar) {
                                                                                    ce ceVar2 = ceVar;
                                                                                    ceVar2.marginTop(10.0f);
                                                                                    ceVar2.text("\u66f4\u591a\u4e3b\u9898\u5730\u56fe\u5efa\u8bbe\u4e2d");
                                                                                    ce.fontSize$default(ceVar2, 12.0f, null, 2, null);
                                                                                    ceVar2.fontWeight400();
                                                                                    ceVar2.color(QUIToken.color$default("text_secondary_light"));
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
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        w.a(aqVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.choose_theme.NBPChooseThemePage.body.1.1.4.3.4
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(v vVar) {
                                                v vVar2 = vVar;
                                                vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.choose_theme.NBPChooseThemePage.body.1.1.4.3.4.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(t tVar) {
                                                        t tVar2 = tVar;
                                                        tVar2.mo141height(10.0f);
                                                        tVar2.mo113backgroundColor(QUIToken.color$default("bg_middle_light"));
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.choose_theme.NBPChooseThemePage.body.1.1.4.3.4.2
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(v vVar3) {
                                                        vVar3.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.choose_theme.NBPChooseThemePage.body.1.1.4.3.4.2.1
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(t tVar) {
                                                                t tVar2 = tVar;
                                                                tVar2.mo141height(600.0f);
                                                                tVar2.mo113backgroundColor(QUIToken.color$default("bg_middle_light"));
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
                        return Unit.INSTANCE;
                    }
                });
                final NBPChooseThemePage nBPChooseThemePage2 = NBPChooseThemePage.this;
                Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.choose_theme.NBPChooseThemePage$body$1.2
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        NBPChooseThemePage nBPChooseThemePage3 = NBPChooseThemePage.this;
                        return Boolean.valueOf(((Boolean) nBPChooseThemePage3.preloadThemeLoadingPAGView$delegate.getValue(nBPChooseThemePage3, NBPChooseThemePage.$$delegatedProperties[0])).booleanValue());
                    }
                };
                final NBPChooseThemePage nBPChooseThemePage3 = NBPChooseThemePage.this;
                ConditionViewKt.c(viewContainer2, function0, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.choose_theme.NBPChooseThemePage$body$1.3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ConditionView conditionView) {
                        final NBPChooseThemePage nBPChooseThemePage4 = NBPChooseThemePage.this;
                        PAGViewKt.PAG(conditionView, new Function1<PAGView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.choose_theme.NBPChooseThemePage.body.1.3.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(PAGView pAGView) {
                                PAGView pAGView2 = pAGView;
                                pAGView2.attr(new Function1<PAGAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.choose_theme.NBPChooseThemePage.body.1.3.1.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(PAGAttr pAGAttr) {
                                        PAGAttr pAGAttr2 = pAGAttr;
                                        pAGAttr2.absolutePositionAllZero();
                                        pAGAttr2.m152visibility(false);
                                        pAGAttr2.m151touchEnable(false);
                                        pAGAttr2.src("https://vfiles.gtimg.cn/wuji_dashboard/xy/componenthub/hVZF1KGU.pag");
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPChooseThemePage nBPChooseThemePage5 = NBPChooseThemePage.this;
                                pAGView2.event(new Function1<PAGEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.choose_theme.NBPChooseThemePage.body.1.3.1.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(PAGEvent pAGEvent) {
                                        final NBPChooseThemePage nBPChooseThemePage6 = NBPChooseThemePage.this;
                                        pAGEvent.register("animationStart", new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.choose_theme.NBPChooseThemePage.body.1.3.1.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(Object obj) {
                                                NBPChooseThemePage nBPChooseThemePage7 = NBPChooseThemePage.this;
                                                nBPChooseThemePage7.preloadThemeLoadingPAGView$delegate.setValue(nBPChooseThemePage7, NBPChooseThemePage.$$delegatedProperties[0], Boolean.FALSE);
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

    /* JADX WARN: Code restructure failed: missing block: B:12:0x005c, code lost:
    
        r0 = kotlin.text.StringsKt__StringsJVMKt.decodeToString(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0067, code lost:
    
        if (r2 == null) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x004b, code lost:
    
        r0 = kotlin.collections.ArraysKt___ArraysKt.first(r0);
     */
    @Override // com.tencent.hippykotlin.demo.pages.base.BasePager, com.tencent.kuikly.core.base.ComposeView
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void created() {
        e eVar;
        Object first;
        String decodeToString;
        super.created();
        if (this.listViewHeight > getPageData().l() * 0.8f) {
            this.listViewHeight = getPageData().l() * 0.8f;
        }
        this.curThemeId = getPageData().n().p("theme_id");
        this.pageModel = new NBPChooseThemeViewModel();
        getPageModel().requestMapThemeList();
        Object[] sharePenetratePageData = QQNearbyModule.Companion.getInstance().getSharePenetratePageData();
        if (sharePenetratePageData != null && first != null) {
            eVar = null;
            byte[] bArr = first instanceof byte[] ? (byte[]) first : null;
            if (bArr != null && decodeToString != null) {
                eVar = new e(decodeToString);
            }
        }
        eVar = new e();
        this.baseReportParams = eVar;
        Function0<Unit> function0 = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.choose_theme.NBPChooseThemePage$created$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Unit invoke() {
                NBPChooseThemePage nBPChooseThemePage = NBPChooseThemePage.this;
                nBPChooseThemePage.preloadThemeLoadingPAGView$delegate.setValue(nBPChooseThemePage, NBPChooseThemePage.$$delegatedProperties[0], Boolean.TRUE);
                NBPChooseThemePage nBPChooseThemePage2 = NBPChooseThemePage.this;
                e access$getReportParams = NBPChooseThemePage.access$getReportParams(nBPChooseThemePage2, nBPChooseThemePage2.curThemeId);
                access$getReportParams.v(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
                Utils.INSTANCE.currentBridgeModule().reportCustomDtEvent("dt_imp", access$getReportParams);
                return Unit.INSTANCE;
            }
        };
        KProperty<Object>[] kPropertyArr = IPagerIdKtxKt.$$delegatedProperties;
        TimerKt.e(getPagerId(), 500, function0);
    }

    public final NBPChooseThemeViewModel getPageModel() {
        NBPChooseThemeViewModel nBPChooseThemeViewModel = this.pageModel;
        if (nBPChooseThemeViewModel != null) {
            return nBPChooseThemeViewModel;
        }
        Intrinsics.throwUninitializedPropertyAccessException("pageModel");
        return null;
    }

    @Override // com.tencent.kuikly.core.pager.Pager, com.tencent.kuikly.core.pager.b
    public final void onReceivePagerEvent(String str, e eVar) {
        NBPHalfScreenModalView b16;
        super.onReceivePagerEvent(str, eVar);
        if (Intrinsics.areEqual(str, "onModalModeBackPressed")) {
            aa<NBPHalfScreenModalView> aaVar = this.modalViewRef;
            if (aaVar == null || (b16 = aaVar.b()) == null) {
                return;
            }
            b16.setAnimationOpen(false);
            return;
        }
        super.onReceivePagerEvent(str, eVar);
    }
}
