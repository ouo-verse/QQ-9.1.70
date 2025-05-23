package com.tencent.hippykotlin.demo.pages.nearby.new_homepage.title_bar;

import c45.e;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPSharePanelViewKt;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.ShareItemData;
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
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
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
import j35.a;
import j35.c;
import j35.g;
import j35.i;
import j35.j;
import j35.k;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public final class NBPModalNavbar extends ComposeView<NBPModalNavbarAttr, NBPModalNavBarEvent> {
    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ NBPModalNavbarAttr access$getAttr(NBPModalNavbar nBPModalNavbar) {
        return (NBPModalNavbarAttr) nBPModalNavbar.getAttr();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.title_bar.NBPModalNavbar$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.title_bar.NBPModalNavbar$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        mVar2.size(mVar2.getPagerData().m(), mVar2.getPagerData().getNavigationBarHeight());
                        mVar2.m154zIndex(2);
                        mVar2.allCenter();
                        return Unit.INSTANCE;
                    }
                });
                viewContainer2.event(new Function1<Event, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.title_bar.NBPModalNavbar$body$1.2
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Event event) {
                        event.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.title_bar.NBPModalNavbar.body.1.2.1
                            @Override // kotlin.jvm.functions.Function1
                            public final /* bridge */ /* synthetic */ Unit invoke(ClickParams clickParams) {
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                viewContainer2.getPager().getPageData().getIsIOS();
                final NBPModalNavbar nBPModalNavbar = NBPModalNavbar.this;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.title_bar.NBPModalNavbar$body$1.3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        final NBPModalNavbar nBPModalNavbar2 = NBPModalNavbar.this;
                        vVar.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.title_bar.NBPModalNavbar.body.1.3.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.absolutePositionAllZero();
                                tVar2.mo141height(tVar2.getPagerData().getNavigationBarHeight());
                                tVar2.mo113backgroundColor(QUIToken.color$default("bg_bottom_light"));
                                tVar2.m147opacity(NBPModalNavbar.access$getAttr(NBPModalNavbar.this).getAvatarOpacity() / 5);
                                if (NBPModalNavbar.access$getAttr(NBPModalNavbar.this).isFullScreen() && NBPModalNavbar.access$getAttr(NBPModalNavbar.this).getAvatarOpacity() > 0.8d) {
                                    tVar2.m147opacity(1.0f);
                                }
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final NBPModalNavbar nBPModalNavbar2 = NBPModalNavbar.this;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.title_bar.NBPModalNavbar$body$1.4
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        final float f16 = 44.0f;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.title_bar.NBPModalNavbar.body.1.4.1
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
                                tVar2.mo141height(f16);
                                tVar2.alignItemsCenter();
                                return Unit.INSTANCE;
                            }
                        });
                        final NBPModalNavbar nBPModalNavbar3 = NBPModalNavbar.this;
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.title_bar.NBPModalNavbar.body.1.4.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                v vVar4 = vVar3;
                                vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.title_bar.NBPModalNavbar.body.1.4.2.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.allCenter();
                                        tVar2.size(50.0f, 30.0f);
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPModalNavbar nBPModalNavbar4 = NBPModalNavbar.this;
                                ah.a(vVar4, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.title_bar.NBPModalNavbar.body.1.4.2.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ImageView imageView) {
                                        final NBPModalNavbar nBPModalNavbar5 = NBPModalNavbar.this;
                                        imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.title_bar.NBPModalNavbar.body.1.4.2.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(af afVar) {
                                                af afVar2 = afVar;
                                                afVar2.marginLeft(10.0f);
                                                afVar2.size(12.0f, 24.0f);
                                                afVar2.t(QUIToken.color$default("icon_primary"));
                                                b.a.b(afVar2, "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_MrDtUj-df36.png", false, 2, null);
                                                if (NBPModalNavbar.access$getAttr(NBPModalNavbar.this).isFullScreen() && NBPModalNavbar.access$getAttr(NBPModalNavbar.this).getAvatarOpacity() > 0.8d) {
                                                    afVar2.m147opacity(1.0f);
                                                } else {
                                                    afVar2.m147opacity(0.0f);
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPModalNavbar nBPModalNavbar5 = NBPModalNavbar.this;
                                vVar4.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.title_bar.NBPModalNavbar.body.1.4.2.3
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(u uVar) {
                                        final NBPModalNavbar nBPModalNavbar6 = NBPModalNavbar.this;
                                        uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.title_bar.NBPModalNavbar.body.1.4.2.3.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ClickParams clickParams) {
                                                NBPModalNavbar.this.onFireEvent("closePage", null);
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
                        final NBPModalNavbar nBPModalNavbar4 = NBPModalNavbar.this;
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.title_bar.NBPModalNavbar.body.1.4.3
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                v vVar4 = vVar3;
                                final NBPModalNavbar nBPModalNavbar5 = NBPModalNavbar.this;
                                vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.title_bar.NBPModalNavbar.body.1.4.3.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.flexDirectionRow();
                                        tVar2.mo141height(32.0f);
                                        tVar2.m140flex(1.0f);
                                        tVar2.alignItemsCenter();
                                        tVar2.m147opacity(NBPModalNavbar.access$getAttr(NBPModalNavbar.this).getAvatarOpacity());
                                        if (NBPModalNavbar.access$getAttr(NBPModalNavbar.this).isFullScreen() && NBPModalNavbar.access$getAttr(NBPModalNavbar.this).getAvatarOpacity() > 0.8d) {
                                            tVar2.m147opacity(1.0f);
                                        }
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPModalNavbar nBPModalNavbar6 = NBPModalNavbar.this;
                                ah.a(vVar4, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.title_bar.NBPModalNavbar.body.1.4.3.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ImageView imageView) {
                                        final NBPModalNavbar nBPModalNavbar7 = NBPModalNavbar.this;
                                        imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.title_bar.NBPModalNavbar.body.1.4.3.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(af afVar) {
                                                s35.af userInfo;
                                                String str;
                                                af afVar2 = afVar;
                                                afVar2.size(32.0f, 32.0f);
                                                afVar2.borderRadius(16.0f);
                                                NBPHomePageBaseViewModel nBPHomePageBaseViewModel = NBPModalNavbar.access$getAttr(NBPModalNavbar.this).viewModel;
                                                if (nBPHomePageBaseViewModel != null && (userInfo = nBPHomePageBaseViewModel.getUserInfo()) != null && (str = userInfo.E) != null) {
                                                    b.a.b(afVar2, str, false, 2, null);
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPModalNavbar nBPModalNavbar7 = NBPModalNavbar.this;
                                cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.title_bar.NBPModalNavbar.body.1.4.3.3
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(TextView textView) {
                                        final NBPModalNavbar nBPModalNavbar8 = NBPModalNavbar.this;
                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.title_bar.NBPModalNavbar.body.1.4.3.3.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ce ceVar) {
                                                s35.af userInfo;
                                                String str;
                                                ce ceVar2 = ceVar;
                                                ceVar2.marginLeft(8.0f);
                                                ce.fontSize$default(ceVar2, 17.0f, null, 2, null);
                                                ceVar2.fontWeight500();
                                                NBPHomePageBaseViewModel nBPHomePageBaseViewModel = NBPModalNavbar.access$getAttr(NBPModalNavbar.this).viewModel;
                                                if (nBPHomePageBaseViewModel != null && (userInfo = nBPHomePageBaseViewModel.getUserInfo()) != null && (str = userInfo.f433209f) != null) {
                                                    ceVar2.text(str);
                                                }
                                                ceVar2.m144maxWidth(ceVar2.getPagerData().m() - 190.0f);
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
                        final NBPModalNavbar nBPModalNavbar5 = NBPModalNavbar.this;
                        Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.title_bar.NBPModalNavbar.body.1.4.4
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                NBPHomePageBaseViewModel nBPHomePageBaseViewModel = NBPModalNavbar.access$getAttr(NBPModalNavbar.this).viewModel;
                                return Boolean.valueOf((nBPHomePageBaseViewModel == null || nBPHomePageBaseViewModel.isSelf) ? false : true);
                            }
                        };
                        final NBPModalNavbar nBPModalNavbar6 = NBPModalNavbar.this;
                        ConditionViewKt.c(vVar2, function0, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.title_bar.NBPModalNavbar.body.1.4.5
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ConditionView conditionView) {
                                final NBPModalNavbar nBPModalNavbar7 = NBPModalNavbar.this;
                                w.a(conditionView, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.title_bar.NBPModalNavbar.body.1.4.5.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar3) {
                                        v vVar4 = vVar3;
                                        final NBPModalNavbar nBPModalNavbar8 = NBPModalNavbar.this;
                                        vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.title_bar.NBPModalNavbar.body.1.4.5.1.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                t tVar2 = tVar;
                                                tVar2.positionAbsolute();
                                                tVar2.m150top(10.0f);
                                                tVar2.m149right(16.0f);
                                                tVar2.flexDirectionRow();
                                                tVar2.m147opacity(NBPModalNavbar.access$getAttr(NBPModalNavbar.this).getAvatarOpacity());
                                                if (NBPModalNavbar.access$getAttr(NBPModalNavbar.this).isFullScreen() && NBPModalNavbar.access$getAttr(NBPModalNavbar.this).getAvatarOpacity() > 0.8d) {
                                                    tVar2.m147opacity(1.0f);
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final NBPHomePageBaseViewModel nBPHomePageBaseViewModel = NBPModalNavbar.access$getAttr(NBPModalNavbar.this).viewModel;
                                        final NBPModalNavbar nBPModalNavbar9 = NBPModalNavbar.this;
                                        w.a(vVar4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.title_bar.NBPModalNavbar.body.1.4.5.1.2
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(v vVar5) {
                                                v vVar6 = vVar5;
                                                vVar6.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.title_bar.NBPModalNavbar.body.1.4.5.1.2.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(t tVar) {
                                                        t tVar2 = tVar;
                                                        tVar2.size(24.0f, 24.0f);
                                                        tVar2.marginRight(12.0f);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                ah.a(vVar6, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.title_bar.NBPModalNavbar.body.1.4.5.1.2.2
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ImageView imageView) {
                                                        imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.title_bar.NBPModalNavbar.body.1.4.5.1.2.2.1
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(af afVar) {
                                                                af afVar2 = afVar;
                                                                afVar2.size(24.0f, 24.0f);
                                                                b.a.b(afVar2, "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_FRhUZDbTjpY.png", false, 2, null);
                                                                afVar2.t(QUIToken.color$default("icon_primary"));
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final NBPHomePageBaseViewModel nBPHomePageBaseViewModel2 = NBPHomePageBaseViewModel.this;
                                                final NBPModalNavbar nBPModalNavbar10 = nBPModalNavbar9;
                                                vVar6.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.title_bar.NBPModalNavbar.body.1.4.5.1.2.3
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(u uVar) {
                                                        final u uVar2 = uVar;
                                                        final NBPHomePageBaseViewModel nBPHomePageBaseViewModel3 = NBPHomePageBaseViewModel.this;
                                                        final NBPModalNavbar nBPModalNavbar11 = nBPModalNavbar10;
                                                        uVar2.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.title_bar.NBPModalNavbar.body.1.4.5.1.2.3.1
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ClickParams clickParams) {
                                                                e gVar;
                                                                if (NBPHomePageBaseViewModel.this != null) {
                                                                    NBPHomePageBaseViewModel nBPHomePageBaseViewModel4 = NBPModalNavbar.access$getAttr(nBPModalNavbar11).viewModel;
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
                                                                            gVar = new c(2, (j35.b) null, new k(Long.parseLong(str), null, 2), (i) null, (a) null, (j) null, 117);
                                                                        } else {
                                                                            gVar = new g(7, null, new k(0L, str, 1), 2);
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
                                        final NBPModalNavbar nBPModalNavbar10 = NBPModalNavbar.this;
                                        w.a(vVar4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.title_bar.NBPModalNavbar.body.1.4.5.1.3
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(v vVar5) {
                                                v vVar6 = vVar5;
                                                vVar6.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.title_bar.NBPModalNavbar.body.1.4.5.1.3.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(t tVar) {
                                                        tVar.size(24.0f, 24.0f);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                ah.a(vVar6, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.title_bar.NBPModalNavbar.body.1.4.5.1.3.2
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ImageView imageView) {
                                                        imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.title_bar.NBPModalNavbar.body.1.4.5.1.3.2.1
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(af afVar) {
                                                                af afVar2 = afVar;
                                                                afVar2.size(24.0f, 24.0f);
                                                                b.a.b(afVar2, "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_nipDU1eSCH0.png", false, 2, null);
                                                                afVar2.t(QUIToken.color$default("icon_primary"));
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final NBPModalNavbar nBPModalNavbar11 = NBPModalNavbar.this;
                                                vVar6.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.title_bar.NBPModalNavbar.body.1.4.5.1.3.3
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(u uVar) {
                                                        final NBPModalNavbar nBPModalNavbar12 = NBPModalNavbar.this;
                                                        uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.title_bar.NBPModalNavbar.body.1.4.5.1.3.3.1
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ClickParams clickParams) {
                                                                NBPHomePageBaseViewModel nBPHomePageBaseViewModel2 = NBPModalNavbar.access$getAttr(NBPModalNavbar.this).viewModel;
                                                                if (nBPHomePageBaseViewModel2 != null) {
                                                                    nBPHomePageBaseViewModel2.reportUser();
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
                        return Unit.INSTANCE;
                    }
                });
                final NBPModalNavbar nBPModalNavbar3 = NBPModalNavbar.this;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.title_bar.NBPModalNavbar$body$1.5
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        final NBPModalNavbar nBPModalNavbar4 = NBPModalNavbar.this;
                        vVar.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.title_bar.NBPModalNavbar.body.1.5.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.mo153width(tVar2.getPagerData().m());
                                tVar2.mo141height(1.0f);
                                tVar2.mo113backgroundColor(QUIToken.color$default("border_light"));
                                tVar2.m147opacity(NBPModalNavbar.access$getAttr(NBPModalNavbar.this).getAvatarOpacity());
                                if (NBPModalNavbar.access$getAttr(NBPModalNavbar.this).isFullScreen() && NBPModalNavbar.access$getAttr(NBPModalNavbar.this).getAvatarOpacity() > 0.8d) {
                                    tVar2.m147opacity(1.0f);
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
        return new NBPModalNavbarAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new NBPModalNavBarEvent();
    }
}
