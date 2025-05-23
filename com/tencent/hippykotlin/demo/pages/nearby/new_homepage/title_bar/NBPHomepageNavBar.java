package com.tencent.hippykotlin.demo.pages.nearby.new_homepage.title_bar;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieAgreementConsentPage$onCreate$1$1$3$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyConst;
import com.tencent.hippykotlin.demo.pages.nearby.base.module.QQNearbyModule;
import com.tencent.hippykotlin.demo.pages.nearby.base.utils.NearbyProUtilsKt;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPSharePanelViewKt;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.ShareItemData;
import com.tencent.hippykotlin.demo.pages.nearby.common_share.NearbyCommonShareHelper$getArkMsgAndShare$1$2$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.nearby.new_homepage.repository.NearbyUserShareHelper;
import com.tencent.hippykotlin.demo.pages.nearby.new_homepage.repository.NearbyUserShareHelper$Companion$shareUserByQQ$helper$1;
import com.tencent.hippykotlin.demo.pages.nearby.new_homepage.repository.NearbyUserShareHelper$Companion$shareUserByQQ$helper$2;
import com.tencent.hippykotlin.demo.pages.nearby.new_homepage.repository.NearbyUserShareHelper$shareByQQ$1;
import com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view_model.NBPHomePageBaseViewModel;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.event.VisibilityEventKt;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.l;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
import com.tencent.kuikly.core.layout.FlexWrap;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.module.k;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.reactive.collection.c;
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
import j35.a;
import j35.g;
import j35.i;
import j35.j;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import oicq.wlogin_sdk.tools.util;

/* loaded from: classes31.dex */
public final class NBPHomepageNavBar extends ComposeView<NBPHomepageNavBarAttr, l> {
    /* JADX WARN: Code restructure failed: missing block: B:4:0x0010, code lost:
    
        if (r0.getAppId() == 1) goto L8;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void access$closePage(NBPHomepageNavBar nBPHomepageNavBar) {
        boolean z16;
        NBPHomePageBaseViewModel nBPHomePageBaseViewModel = ((NBPHomepageNavBarAttr) nBPHomepageNavBar.getAttr()).viewModel;
        if (nBPHomePageBaseViewModel != null) {
            z16 = true;
        }
        z16 = false;
        if (z16) {
            AdelieAgreementConsentPage$onCreate$1$1$3$$ExternalSyntheticOutline0.m((k) ((NBPHomepageNavBarAttr) nBPHomepageNavBar.getAttr()).getPager().acquireModule("KRNotifyModule"), "JIEBAN_EXIT_MY_PROFILE_EVENT", false, 4, null);
        } else {
            QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
            QQKuiklyPlatformApi.Companion.closePage$default();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void access$editReport(NBPHomepageNavBar nBPHomepageNavBar, String str) {
        e eVar;
        NBPHomePageBaseViewModel nBPHomePageBaseViewModel = ((NBPHomepageNavBarAttr) nBPHomepageNavBar.getAttr()).viewModel;
        if (nBPHomePageBaseViewModel != null) {
            e jsonWithHomePagePgParams = nBPHomePageBaseViewModel.jsonWithHomePagePgParams();
            jsonWithHomePagePgParams.v("dt_eid", "em_edit_profile_btn");
            NBPHomePageBaseViewModel nBPHomePageBaseViewModel2 = ((NBPHomepageNavBarAttr) nBPHomepageNavBar.getAttr()).viewModel;
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
    public static final /* synthetic */ NBPHomepageNavBarAttr access$getAttr(NBPHomepageNavBar nBPHomepageNavBar) {
        return (NBPHomepageNavBarAttr) nBPHomepageNavBar.getAttr();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.title_bar.NBPHomepageNavBar$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.title_bar.NBPHomepageNavBar$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        mVar2.size(mVar2.getPagerData().m(), mVar2.getPagerData().getNavigationBarHeight());
                        mVar2.m154zIndex(2);
                        mVar2.allCenter();
                        return Unit.INSTANCE;
                    }
                });
                viewContainer2.event(new Function1<Event, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.title_bar.NBPHomepageNavBar$body$1.2
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Event event) {
                        event.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.title_bar.NBPHomepageNavBar.body.1.2.1
                            @Override // kotlin.jvm.functions.Function1
                            public final /* bridge */ /* synthetic */ Unit invoke(ClickParams clickParams) {
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                viewContainer2.getPager().getPageData().getIsIOS();
                final NBPHomepageNavBar nBPHomepageNavBar = NBPHomepageNavBar.this;
                Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.title_bar.NBPHomepageNavBar$body$1.3
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        NBPHomepageNavBarAttr access$getAttr = NBPHomepageNavBar.access$getAttr(NBPHomepageNavBar.this);
                        return Boolean.valueOf(((Boolean) access$getAttr.isFullScreen$delegate.getValue(access$getAttr, NBPHomepageNavBarAttr.$$delegatedProperties[0])).booleanValue());
                    }
                };
                final NBPHomepageNavBar nBPHomepageNavBar2 = NBPHomepageNavBar.this;
                ConditionViewKt.c(viewContainer2, function0, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.title_bar.NBPHomepageNavBar$body$1.4
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ConditionView conditionView) {
                        ConditionView conditionView2 = conditionView;
                        w.a(conditionView2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.title_bar.NBPHomepageNavBar.body.1.4.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar) {
                                vVar.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.title_bar.NBPHomepageNavBar.body.1.4.1.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.absolutePositionAllZero();
                                        tVar2.mo141height(tVar2.getPagerData().getNavigationBarHeight());
                                        tVar2.mo113backgroundColor(QUIToken.color$default("bg_bottom_light"));
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final NBPHomepageNavBar nBPHomepageNavBar3 = NBPHomepageNavBar.this;
                        final float f16 = 44.0f;
                        w.a(conditionView2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.title_bar.NBPHomepageNavBar.body.1.4.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar) {
                                v vVar2 = vVar;
                                final float f17 = f16;
                                vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.title_bar.NBPHomepageNavBar.body.1.4.2.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.flexDirectionRow();
                                        tVar2.marginTop(tVar2.getPagerData().getStatusBarHeight());
                                        tVar2.mo153width(tVar2.getPagerData().m());
                                        tVar2.mo141height(f17);
                                        tVar2.alignItemsCenter();
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPHomepageNavBar nBPHomepageNavBar4 = nBPHomepageNavBar3;
                                w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.title_bar.NBPHomepageNavBar.body.1.4.2.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar3) {
                                        v vVar4 = vVar3;
                                        vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.title_bar.NBPHomepageNavBar.body.1.4.2.2.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                t tVar2 = tVar;
                                                tVar2.allCenter();
                                                tVar2.size(50.0f, 30.0f);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        ah.a(vVar4, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.title_bar.NBPHomepageNavBar.body.1.4.2.2.2
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ImageView imageView) {
                                                imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.title_bar.NBPHomepageNavBar.body.1.4.2.2.2.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(af afVar) {
                                                        af afVar2 = afVar;
                                                        afVar2.marginLeft(10.0f);
                                                        afVar2.size(12.0f, 24.0f);
                                                        afVar2.t(QUIToken.color$default("icon_primary"));
                                                        b.a.b(afVar2, "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_MrDtUj-df36.png", false, 2, null);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final NBPHomepageNavBar nBPHomepageNavBar5 = NBPHomepageNavBar.this;
                                        vVar4.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.title_bar.NBPHomepageNavBar.body.1.4.2.2.3
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(u uVar) {
                                                final NBPHomepageNavBar nBPHomepageNavBar6 = NBPHomepageNavBar.this;
                                                uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.title_bar.NBPHomepageNavBar.body.1.4.2.2.3.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ClickParams clickParams) {
                                                        NBPHomepageNavBar.access$closePage(NBPHomepageNavBar.this);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPHomepageNavBar nBPHomepageNavBar5 = nBPHomepageNavBar3;
                                w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.title_bar.NBPHomepageNavBar.body.1.4.2.3
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar3) {
                                        v vVar4 = vVar3;
                                        final NBPHomepageNavBar nBPHomepageNavBar6 = NBPHomepageNavBar.this;
                                        vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.title_bar.NBPHomepageNavBar.body.1.4.2.3.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                t tVar2 = tVar;
                                                tVar2.flexDirectionRow();
                                                tVar2.mo141height(30.0f);
                                                tVar2.mo153width(240.0f);
                                                tVar2.alignItemsCenter();
                                                NBPHomepageNavBarAttr access$getAttr = NBPHomepageNavBar.access$getAttr(NBPHomepageNavBar.this);
                                                tVar2.m147opacity(((Number) access$getAttr.avatarOpacity$delegate.getValue(access$getAttr, NBPHomepageNavBarAttr.$$delegatedProperties[1])).floatValue());
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final NBPHomepageNavBar nBPHomepageNavBar7 = NBPHomepageNavBar.this;
                                        ah.a(vVar4, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.title_bar.NBPHomepageNavBar.body.1.4.2.3.2
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ImageView imageView) {
                                                final NBPHomepageNavBar nBPHomepageNavBar8 = NBPHomepageNavBar.this;
                                                imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.title_bar.NBPHomepageNavBar.body.1.4.2.3.2.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(af afVar) {
                                                        s35.af userInfo;
                                                        String str;
                                                        af afVar2 = afVar;
                                                        afVar2.size(30.0f, 30.0f);
                                                        afVar2.borderRadius(15.0f);
                                                        NBPHomePageBaseViewModel nBPHomePageBaseViewModel = NBPHomepageNavBar.access$getAttr(NBPHomepageNavBar.this).viewModel;
                                                        if (nBPHomePageBaseViewModel != null && (userInfo = nBPHomePageBaseViewModel.getUserInfo()) != null && (str = userInfo.E) != null) {
                                                            b.a.b(afVar2, str, false, 2, null);
                                                        }
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final NBPHomepageNavBar nBPHomepageNavBar8 = NBPHomepageNavBar.this;
                                        cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.title_bar.NBPHomepageNavBar.body.1.4.2.3.3
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(TextView textView) {
                                                final NBPHomepageNavBar nBPHomepageNavBar9 = NBPHomepageNavBar.this;
                                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.title_bar.NBPHomepageNavBar.body.1.4.2.3.3.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ce ceVar) {
                                                        s35.af userInfo;
                                                        String str;
                                                        ce ceVar2 = ceVar;
                                                        ceVar2.marginLeft(10.0f);
                                                        ce.fontSize$default(ceVar2, 16.0f, null, 2, null);
                                                        NBPHomePageBaseViewModel nBPHomePageBaseViewModel = NBPHomepageNavBar.access$getAttr(NBPHomepageNavBar.this).viewModel;
                                                        if (nBPHomePageBaseViewModel != null && (userInfo = nBPHomePageBaseViewModel.getUserInfo()) != null && (str = userInfo.f433209f) != null) {
                                                            ceVar2.text(str);
                                                        }
                                                        ceVar2.m144maxWidth(200.0f);
                                                        ceVar2.m146minWidth(40.0f);
                                                        ceVar2.color(QUIToken.color$default("text_primary"));
                                                        ceVar2.lines(1);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.title_bar.NBPHomepageNavBar.body.1.4.2.4
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar3) {
                                        vVar3.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.title_bar.NBPHomepageNavBar.body.1.4.2.4.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                t tVar2 = tVar;
                                                tVar2.mo141height(30.0f);
                                                tVar2.m140flex(1.0f);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPHomepageNavBar nBPHomepageNavBar6 = nBPHomepageNavBar3;
                                w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.title_bar.NBPHomepageNavBar.body.1.4.2.5
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar3) {
                                        v vVar4 = vVar3;
                                        vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.title_bar.NBPHomepageNavBar.body.1.4.2.5.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                t tVar2 = tVar;
                                                tVar2.allCenter();
                                                tVar2.size(35.0f, 30.0f);
                                                tVar2.marginRight(16.0f);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        ah.a(vVar4, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.title_bar.NBPHomepageNavBar.body.1.4.2.5.2
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ImageView imageView) {
                                                imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.title_bar.NBPHomepageNavBar.body.1.4.2.5.2.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(af afVar) {
                                                        af afVar2 = afVar;
                                                        afVar2.size(20.0f, 20.0f);
                                                        afVar2.t(QUIToken.color$default("icon_primary"));
                                                        b.a.b(afVar2, "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_9neOGptQ8ao.png", false, 2, null);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final NBPHomepageNavBar nBPHomepageNavBar7 = NBPHomepageNavBar.this;
                                        vVar4.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.title_bar.NBPHomepageNavBar.body.1.4.2.5.3
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(u uVar) {
                                                final NBPHomepageNavBar nBPHomepageNavBar8 = NBPHomepageNavBar.this;
                                                uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.title_bar.NBPHomepageNavBar.body.1.4.2.5.3.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ClickParams clickParams) {
                                                        NBPHomePageBaseViewModel nBPHomePageBaseViewModel = NBPHomepageNavBar.access$getAttr(NBPHomepageNavBar.this).viewModel;
                                                        if (nBPHomePageBaseViewModel != null) {
                                                            nBPHomePageBaseViewModel.openEditPage();
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
                        return Unit.INSTANCE;
                    }
                });
                final NBPHomepageNavBar nBPHomepageNavBar3 = NBPHomepageNavBar.this;
                ConditionViewKt.a(viewContainer2, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.title_bar.NBPHomepageNavBar$body$1.5
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ConditionView conditionView) {
                        final NBPHomepageNavBar nBPHomepageNavBar4 = NBPHomepageNavBar.this;
                        final float f16 = 44.0f;
                        w.a(conditionView, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.title_bar.NBPHomepageNavBar.body.1.5.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar) {
                                v vVar2 = vVar;
                                final float f17 = f16;
                                vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.title_bar.NBPHomepageNavBar.body.1.5.1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.flexDirectionRow();
                                        tVar2.marginTop(tVar2.getPagerData().getStatusBarHeight());
                                        tVar2.mo153width(tVar2.getPagerData().m());
                                        tVar2.mo141height(f17);
                                        tVar2.alignItemsCenter();
                                        return Unit.INSTANCE;
                                    }
                                });
                                final float f18 = f16;
                                final NBPHomepageNavBar nBPHomepageNavBar5 = NBPHomepageNavBar.this;
                                w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.title_bar.NBPHomepageNavBar.body.1.5.1.2
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar3) {
                                        v vVar4 = vVar3;
                                        final float f19 = f18;
                                        vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.title_bar.NBPHomepageNavBar.body.1.5.1.2.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                t tVar2 = tVar;
                                                tVar2.paddingLeft(16.0f);
                                                tVar2.paddingRight(12.0f);
                                                tVar2.allCenter();
                                                tVar2.mo141height(f19);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        w.a(vVar4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.title_bar.NBPHomepageNavBar.body.1.5.1.2.2
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(v vVar5) {
                                                v vVar6 = vVar5;
                                                vVar6.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.title_bar.NBPHomepageNavBar.body.1.5.1.2.2.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(t tVar) {
                                                        t tVar2 = tVar;
                                                        tVar2.size(28.0f, 28.0f);
                                                        tVar2.borderRadius(14.0f);
                                                        tVar2.mo113backgroundColor(new h(1499883110L));
                                                        tVar2.allCenter();
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                ah.a(vVar6, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.title_bar.NBPHomepageNavBar.body.1.5.1.2.2.2
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ImageView imageView) {
                                                        imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.title_bar.NBPHomepageNavBar.body.1.5.1.2.2.2.1
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(af afVar) {
                                                                af afVar2 = afVar;
                                                                afVar2.size(20.0f, 20.0f);
                                                                b.a.b(afVar2, "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_tYDNTg8cDk5.png", false, 2, null);
                                                                afVar2.o();
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final NBPHomepageNavBar nBPHomepageNavBar6 = nBPHomepageNavBar5;
                                        vVar4.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.title_bar.NBPHomepageNavBar.body.1.5.1.2.3
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(u uVar) {
                                                final NBPHomepageNavBar nBPHomepageNavBar7 = NBPHomepageNavBar.this;
                                                uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.title_bar.NBPHomepageNavBar.body.1.5.1.2.3.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ClickParams clickParams) {
                                                        NBPHomepageNavBar.access$closePage(NBPHomepageNavBar.this);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.title_bar.NBPHomepageNavBar.body.1.5.1.3
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar3) {
                                        vVar3.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.title_bar.NBPHomepageNavBar.body.1.5.1.3.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                tVar.m140flex(1.0f);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                if (NBPHomepageNavBar.access$getAttr(NBPHomepageNavBar.this).isSelf) {
                                    final NBPHomepageNavBar nBPHomepageNavBar6 = NBPHomepageNavBar.this;
                                    w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.title_bar.NBPHomepageNavBar.body.1.5.1.4
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(v vVar3) {
                                            v vVar4 = vVar3;
                                            vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.title_bar.NBPHomepageNavBar.body.1.5.1.4.1
                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(t tVar) {
                                                    t tVar2 = tVar;
                                                    tVar2.flexDirectionRow();
                                                    tVar2.marginRight(16.0f);
                                                    tVar2.alignItemsCenter();
                                                    tVar2.flexWrap(FlexWrap.WRAP);
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            final NBPHomepageNavBar nBPHomepageNavBar7 = NBPHomepageNavBar.this;
                                            Function0<Object> function02 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.title_bar.NBPHomepageNavBar.body.1.5.1.4.2
                                                {
                                                    super(0);
                                                }

                                                @Override // kotlin.jvm.functions.Function0
                                                public final Object invoke() {
                                                    NBPHomepageNavBarAttr access$getAttr = NBPHomepageNavBar.access$getAttr(NBPHomepageNavBar.this);
                                                    return Boolean.valueOf(((Boolean) access$getAttr.isMinScreen$delegate.getValue(access$getAttr, NBPHomepageNavBarAttr.$$delegatedProperties[2])).booleanValue());
                                                }
                                            };
                                            final NBPHomepageNavBar nBPHomepageNavBar8 = NBPHomepageNavBar.this;
                                            ConditionViewKt.c(vVar4, function02, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.title_bar.NBPHomepageNavBar.body.1.5.1.4.3
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(ConditionView conditionView2) {
                                                    final NBPHomepageNavBar nBPHomepageNavBar9 = NBPHomepageNavBar.this;
                                                    w.a(conditionView2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.title_bar.NBPHomepageNavBar.body.1.5.1.4.3.1
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(v vVar5) {
                                                            v vVar6 = vVar5;
                                                            vVar6.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.title_bar.NBPHomepageNavBar.body.1.5.1.4.3.1.1
                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(t tVar) {
                                                                    t tVar2 = tVar;
                                                                    tVar2.size(28.0f, 28.0f);
                                                                    tVar2.borderRadius(14.0f);
                                                                    tVar2.mo113backgroundColor(new h(1499883110L));
                                                                    tVar2.allCenter();
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                            ah.a(vVar6, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.title_bar.NBPHomepageNavBar.body.1.5.1.4.3.1.2
                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(ImageView imageView) {
                                                                    imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.title_bar.NBPHomepageNavBar.body.1.5.1.4.3.1.2.1
                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        public final Unit invoke(af afVar) {
                                                                            af afVar2 = afVar;
                                                                            afVar2.size(20.0f, 20.0f);
                                                                            b.a.b(afVar2, "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_ewFVGSnVr-V.png", false, 2, null);
                                                                            return Unit.INSTANCE;
                                                                        }
                                                                    });
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                            final NBPHomepageNavBar nBPHomepageNavBar10 = NBPHomepageNavBar.this;
                                                            vVar6.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.title_bar.NBPHomepageNavBar.body.1.5.1.4.3.1.3
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(u uVar) {
                                                                    final NBPHomepageNavBar nBPHomepageNavBar11 = NBPHomepageNavBar.this;
                                                                    uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.title_bar.NBPHomepageNavBar.body.1.5.1.4.3.1.3.1
                                                                        {
                                                                            super(1);
                                                                        }

                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        public final Unit invoke(ClickParams clickParams) {
                                                                            e eVar;
                                                                            QQNearbyModule companion = QQNearbyModule.Companion.getInstance();
                                                                            companion.getClass();
                                                                            KLog kLog = KLog.INSTANCE;
                                                                            NearbyConst nearbyConst = NearbyConst.INSTANCE;
                                                                            kLog.i("personal_detail_page", "openMyDressPage");
                                                                            companion.asyncToNativeMethod("openMyDressPage", (e) null, (Function1<? super e, Unit>) null);
                                                                            NBPHomePageBaseViewModel nBPHomePageBaseViewModel = NBPHomepageNavBar.access$getAttr(NBPHomepageNavBar.this).viewModel;
                                                                            if (nBPHomePageBaseViewModel != null) {
                                                                                e jsonWithHomePagePgParams = nBPHomePageBaseViewModel.jsonWithHomePagePgParams();
                                                                                NBPHomepageNavBar nBPHomepageNavBar12 = NBPHomepageNavBar.this;
                                                                                jsonWithHomePagePgParams.v("dt_eid", "em_kl_rehandling");
                                                                                NBPHomePageBaseViewModel nBPHomePageBaseViewModel2 = NBPHomepageNavBar.access$getAttr(nBPHomepageNavBar12).viewModel;
                                                                                if (nBPHomePageBaseViewModel2 != null) {
                                                                                    eVar = nBPHomePageBaseViewModel2.jsonWithHomePagePgParams();
                                                                                } else {
                                                                                    eVar = new e();
                                                                                }
                                                                                jsonWithHomePagePgParams.v("cur_pg", eVar);
                                                                                jsonWithHomePagePgParams.v(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
                                                                                Utils.INSTANCE.currentBridgeModule().reportCustomDtEvent("dt_clck", jsonWithHomePagePgParams);
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
                                            final NBPHomepageNavBar nBPHomepageNavBar9 = NBPHomepageNavBar.this;
                                            w.a(vVar4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.title_bar.NBPHomepageNavBar.body.1.5.1.4.4
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(v vVar5) {
                                                    v vVar6 = vVar5;
                                                    vVar6.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.title_bar.NBPHomepageNavBar.body.1.5.1.4.4.1
                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(t tVar) {
                                                            t tVar2 = tVar;
                                                            tVar2.mo141height(28.0f);
                                                            tVar2.marginLeft(8.0f);
                                                            tVar2.borderRadius(14.0f);
                                                            tVar2.mo113backgroundColor(new h(1499883110L));
                                                            tVar2.flexDirectionRow();
                                                            tVar2.alignItemsCenter();
                                                            tVar2.justifyContentCenter();
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    ah.a(vVar6, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.title_bar.NBPHomepageNavBar.body.1.5.1.4.4.2
                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(ImageView imageView) {
                                                            imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.title_bar.NBPHomepageNavBar.body.1.5.1.4.4.2.1
                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(af afVar) {
                                                                    af afVar2 = afVar;
                                                                    afVar2.size(18.0f, 18.0f);
                                                                    afVar2.marginLeft(5.0f);
                                                                    afVar2.t(h.INSTANCE.m());
                                                                    b.a.b(afVar2, "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_9neOGptQ8ao.png", false, 2, null);
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    final NBPHomepageNavBar nBPHomepageNavBar10 = NBPHomepageNavBar.this;
                                                    cg.a(vVar6, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.title_bar.NBPHomepageNavBar.body.1.5.1.4.4.3
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(TextView textView) {
                                                            final NBPHomepageNavBar nBPHomepageNavBar11 = NBPHomepageNavBar.this;
                                                            textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.title_bar.NBPHomepageNavBar.body.1.5.1.4.4.3.1
                                                                {
                                                                    super(1);
                                                                }

                                                                /* JADX WARN: Code restructure failed: missing block: B:14:0x007e, code lost:
                                                                
                                                                    if ((r11 != null ? r11.I : null) == null) goto L18;
                                                                 */
                                                                @Override // kotlin.jvm.functions.Function1
                                                                /*
                                                                    Code decompiled incorrectly, please refer to instructions dump.
                                                                */
                                                                public final Unit invoke(ce ceVar) {
                                                                    int i3;
                                                                    Boolean bool;
                                                                    Boolean bool2;
                                                                    Boolean bool3;
                                                                    String str;
                                                                    String str2;
                                                                    String str3;
                                                                    String str4;
                                                                    ce ceVar2 = ceVar;
                                                                    ceVar2.fontWeight400();
                                                                    Boolean bool4 = null;
                                                                    ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                                                    ceVar2.marginLeft(4.0f);
                                                                    ceVar2.marginRight(5.0f);
                                                                    ceVar2.color(h.INSTANCE.m());
                                                                    StringBuilder sb5 = new StringBuilder();
                                                                    sb5.append("\u8d44\u6599\u5b8c\u6210\u5ea6");
                                                                    NBPHomePageBaseViewModel nBPHomePageBaseViewModel = NBPHomepageNavBar.access$getAttr(NBPHomepageNavBar.this).viewModel;
                                                                    if (nBPHomePageBaseViewModel != null) {
                                                                        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("progress_");
                                                                        m3.append(nBPHomePageBaseViewModel.getAppId());
                                                                        m3.append(util.base64_pad_url);
                                                                        m3.append(nBPHomePageBaseViewModel.accountId);
                                                                        String sb6 = m3.toString();
                                                                        Utils utils = Utils.INSTANCE;
                                                                        Integer num = utils.cacheModule("").getInt(sb6);
                                                                        int intValue = num != null ? num.intValue() : 0;
                                                                        if (intValue == 0) {
                                                                            nBPHomePageBaseViewModel.isFirstEntry = true;
                                                                        }
                                                                        if (nBPHomePageBaseViewModel.getUserInfo() != null) {
                                                                            s35.af userInfo = nBPHomePageBaseViewModel.getUserInfo();
                                                                        }
                                                                        if (!nBPHomePageBaseViewModel.isFirstEntry) {
                                                                            NearbyCommonShareHelper$getArkMsgAndShare$1$2$$ExternalSyntheticOutline0.m("skipping progress calculation, return: ", intValue, KLog.INSTANCE, "NBPHomePageBaseViewModel");
                                                                            i3 = intValue;
                                                                        }
                                                                        s35.af userInfo2 = nBPHomePageBaseViewModel.getUserInfo();
                                                                        if (userInfo2 == null || (str4 = userInfo2.E) == null) {
                                                                            bool = null;
                                                                        } else {
                                                                            bool = Boolean.valueOf(str4.length() > 0);
                                                                        }
                                                                        s35.af userInfo3 = nBPHomePageBaseViewModel.getUserInfo();
                                                                        if (userInfo3 == null || (str3 = userInfo3.f433209f) == null) {
                                                                            bool2 = null;
                                                                        } else {
                                                                            bool2 = Boolean.valueOf(str3.length() > 0);
                                                                        }
                                                                        s35.af userInfo4 = nBPHomePageBaseViewModel.getUserInfo();
                                                                        Integer valueOf = userInfo4 != null ? Integer.valueOf(userInfo4.f433218m) : null;
                                                                        s35.af userInfo5 = nBPHomePageBaseViewModel.getUserInfo();
                                                                        if (userInfo5 == null || (str2 = userInfo5.f433214i) == null) {
                                                                            bool3 = null;
                                                                        } else {
                                                                            bool3 = Boolean.valueOf(str2.length() > 0);
                                                                        }
                                                                        s35.af userInfo6 = nBPHomePageBaseViewModel.getUserInfo();
                                                                        if (userInfo6 != null && (str = userInfo6.F) != null) {
                                                                            bool4 = Boolean.valueOf(str.length() > 0);
                                                                        }
                                                                        int size = nBPHomePageBaseViewModel.getTagList().size();
                                                                        int size2 = ((c) nBPHomePageBaseViewModel.tacitAllMyList$delegate.getValue(nBPHomePageBaseViewModel, NBPHomePageBaseViewModel.$$delegatedProperties[6])).size();
                                                                        Boolean bool5 = Boolean.TRUE;
                                                                        int doCalculateProgress = (int) (NearbyProUtilsKt.doCalculateProgress(Intrinsics.areEqual(bool, bool5), Intrinsics.areEqual(bool2, bool5), valueOf != null ? valueOf.intValue() : 0, Intrinsics.areEqual(bool3, bool5), Intrinsics.areEqual(bool4, bool5), size, size2) * 100);
                                                                        int i16 = nBPHomePageBaseViewModel.calculateProgressCount + 1;
                                                                        nBPHomePageBaseViewModel.calculateProgressCount = i16;
                                                                        if ((i16 > 7 && !nBPHomePageBaseViewModel.isFirstEntry) || nBPHomePageBaseViewModel.isFirstEntry) {
                                                                            utils.cacheModule("").setInt(sb6, Integer.valueOf(doCalculateProgress));
                                                                            i3 = doCalculateProgress;
                                                                        }
                                                                        i3 = intValue;
                                                                    } else {
                                                                        i3 = 0;
                                                                    }
                                                                    sb5.append(i3);
                                                                    sb5.append('%');
                                                                    ceVar2.text(sb5.toString());
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    final NBPHomepageNavBar nBPHomepageNavBar11 = NBPHomepageNavBar.this;
                                                    vVar6.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.title_bar.NBPHomepageNavBar.body.1.5.1.4.4.4
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(u uVar) {
                                                            u uVar2 = uVar;
                                                            final NBPHomepageNavBar nBPHomepageNavBar12 = NBPHomepageNavBar.this;
                                                            uVar2.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.title_bar.NBPHomepageNavBar.body.1.5.1.4.4.4.1
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(ClickParams clickParams) {
                                                                    NBPHomePageBaseViewModel nBPHomePageBaseViewModel = NBPHomepageNavBar.access$getAttr(NBPHomepageNavBar.this).viewModel;
                                                                    if (nBPHomePageBaseViewModel != null) {
                                                                        nBPHomePageBaseViewModel.openEditPage();
                                                                    }
                                                                    NBPHomepageNavBar.access$editReport(NBPHomepageNavBar.this, "dt_clck");
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                            final NBPHomepageNavBar nBPHomepageNavBar13 = NBPHomepageNavBar.this;
                                                            VisibilityEventKt.b(uVar2, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.title_bar.NBPHomepageNavBar.body.1.5.1.4.4.4.2
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(Object obj) {
                                                                    NBPHomepageNavBar.access$editReport(NBPHomepageNavBar.this, "dt_imp");
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            final NBPHomePageBaseViewModel nBPHomePageBaseViewModel = NBPHomepageNavBar.access$getAttr(NBPHomepageNavBar.this).viewModel;
                                            final NBPHomepageNavBar nBPHomepageNavBar10 = NBPHomepageNavBar.this;
                                            w.a(vVar4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.title_bar.NBPHomepageNavBar.body.1.5.1.4.5
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(v vVar5) {
                                                    v vVar6 = vVar5;
                                                    vVar6.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.title_bar.NBPHomepageNavBar.body.1.5.1.4.5.1
                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(t tVar) {
                                                            t tVar2 = tVar;
                                                            tVar2.mo141height(28.0f);
                                                            tVar2.mo153width(28.0f);
                                                            tVar2.marginLeft(8.0f);
                                                            tVar2.borderRadius(14.0f);
                                                            tVar2.mo113backgroundColor(new h(1499883110L));
                                                            tVar2.alignItemsCenter();
                                                            tVar2.justifyContentCenter();
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    ah.a(vVar6, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.title_bar.NBPHomepageNavBar.body.1.5.1.4.5.2
                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(ImageView imageView) {
                                                            imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.title_bar.NBPHomepageNavBar.body.1.5.1.4.5.2.1
                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(af afVar) {
                                                                    af afVar2 = afVar;
                                                                    afVar2.size(20.0f, 20.0f);
                                                                    afVar2.t(h.INSTANCE.m());
                                                                    b.a.b(afVar2, "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_FRhUZDbTjpY.png", false, 2, null);
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    final NBPHomepageNavBar nBPHomepageNavBar11 = NBPHomepageNavBar.this;
                                                    final NBPHomePageBaseViewModel nBPHomePageBaseViewModel2 = nBPHomePageBaseViewModel;
                                                    vVar6.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.title_bar.NBPHomepageNavBar.body.1.5.1.4.5.3
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(u uVar) {
                                                            final u uVar2 = uVar;
                                                            final NBPHomepageNavBar nBPHomepageNavBar12 = NBPHomepageNavBar.this;
                                                            VisibilityEventKt.b(uVar2, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.title_bar.NBPHomepageNavBar.body.1.5.1.4.5.3.1
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(Object obj) {
                                                                    NBPHomePageBaseViewModel nBPHomePageBaseViewModel3 = NBPHomepageNavBar.access$getAttr(NBPHomepageNavBar.this).viewModel;
                                                                    if (nBPHomePageBaseViewModel3 != null) {
                                                                        nBPHomePageBaseViewModel3.homePageBaseReport("dt_imp", "em_nearby_share_btn");
                                                                    }
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                            final NBPHomePageBaseViewModel nBPHomePageBaseViewModel3 = nBPHomePageBaseViewModel2;
                                                            final NBPHomepageNavBar nBPHomepageNavBar13 = NBPHomepageNavBar.this;
                                                            uVar2.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.title_bar.NBPHomepageNavBar.body.1.5.1.4.5.3.2
                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(ClickParams clickParams) {
                                                                    c45.e gVar;
                                                                    if (NBPHomePageBaseViewModel.this != null) {
                                                                        NBPHomePageBaseViewModel nBPHomePageBaseViewModel4 = NBPHomepageNavBar.access$getAttr(nBPHomepageNavBar13).viewModel;
                                                                        if (nBPHomePageBaseViewModel4 != null) {
                                                                            nBPHomePageBaseViewModel4.homePageBaseReport("dt_clck", "em_nearby_share_btn");
                                                                        }
                                                                        String pagerId = uVar2.getPagerId();
                                                                        int appId = NBPHomePageBaseViewModel.this.getAppId();
                                                                        NBPHomePageBaseViewModel nBPHomePageBaseViewModel5 = NBPHomePageBaseViewModel.this;
                                                                        String str = nBPHomePageBaseViewModel5.accountId;
                                                                        nBPHomePageBaseViewModel5.getUserInfo();
                                                                        NearbyUserShareHelper nearbyUserShareHelper = new NearbyUserShareHelper(pagerId, appId, str, NearbyUserShareHelper$Companion$shareUserByQQ$helper$1.INSTANCE, NearbyUserShareHelper$Companion$shareUserByQQ$helper$2.INSTANCE);
                                                                        ShareItemData shareItemData = NBPSharePanelViewKt.ShareItemQQ;
                                                                        if (Intrinsics.areEqual(shareItemData, shareItemData)) {
                                                                            if (appId == 2) {
                                                                                gVar = new j35.c(2, (j35.b) null, new j35.k(Long.parseLong(str), null, 2), (i) null, (a) null, (j) null, 117);
                                                                            } else {
                                                                                gVar = new g(7, null, new j35.k(0L, str, 1), 2);
                                                                            }
                                                                            nearbyUserShareHelper.repo.getArkMsg(gVar, new NearbyUserShareHelper$shareByQQ$1(nearbyUserShareHelper));
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
        return new NBPHomepageNavBarAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new l();
    }
}
