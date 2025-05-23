package com.tencent.hippykotlin.demo.pages.nearby.main.theme.view;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieCategoryHomePage$$ExternalSyntheticOutline1;
import com.tencent.hippykotlin.demo.pages.foundation.view.PAGAttr;
import com.tencent.hippykotlin.demo.pages.foundation.view.PAGEvent;
import com.tencent.hippykotlin.demo.pages.foundation.view.PAGView;
import com.tencent.hippykotlin.demo.pages.foundation.view.PAGViewKt;
import com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPMainKtxKt;
import com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPViewModelStoreKt;
import com.tencent.hippykotlin.demo.pages.nearby.main.theme.NBPMainMapThemeViewModel;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.timer.TimerKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* loaded from: classes31.dex */
public final class NBPThemeLoadingAnimationView extends ComposeView<NBPThemeLoadingAnimationAttr, NBPThemeLoadingAnimationEvent> {
    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.theme.view.NBPThemeLoadingAnimationView$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.theme.view.NBPThemeLoadingAnimationView$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        mVar2.m151touchEnable(false);
                        mVar2.allCenter();
                        return Unit.INSTANCE;
                    }
                });
                final NBPThemeLoadingAnimationView nBPThemeLoadingAnimationView = NBPThemeLoadingAnimationView.this;
                PAGViewKt.PAG(viewContainer2, new Function1<PAGView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.theme.view.NBPThemeLoadingAnimationView$body$1.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(PAGView pAGView) {
                        PAGView pAGView2 = pAGView;
                        pAGView2.attr(new Function1<PAGAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.theme.view.NBPThemeLoadingAnimationView.body.1.2.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(PAGAttr pAGAttr) {
                                PAGAttr pAGAttr2 = pAGAttr;
                                float m3 = pAGAttr2.getPagerData().m();
                                float f16 = 2.1666667f * m3;
                                if (f16 < pAGAttr2.getPagerData().l()) {
                                    m3 = (pAGAttr2.getPagerData().l() / f16) * pAGAttr2.getPagerData().m();
                                    f16 = pAGAttr2.getPagerData().l();
                                }
                                pAGAttr2.mo141height(f16);
                                pAGAttr2.mo153width(m3);
                                pAGAttr2.src("https://vfiles.gtimg.cn/wuji_dashboard/xy/componenthub/hVZF1KGU.pag");
                                return Unit.INSTANCE;
                            }
                        });
                        final NBPThemeLoadingAnimationView nBPThemeLoadingAnimationView2 = NBPThemeLoadingAnimationView.this;
                        pAGView2.event(new Function1<PAGEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.theme.view.NBPThemeLoadingAnimationView.body.1.2.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(PAGEvent pAGEvent) {
                                PAGEvent pAGEvent2 = pAGEvent;
                                final NBPThemeLoadingAnimationView nBPThemeLoadingAnimationView3 = NBPThemeLoadingAnimationView.this;
                                pAGEvent2.register("loadFailure", new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.theme.view.NBPThemeLoadingAnimationView.body.1.2.2.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(Object obj) {
                                        AdelieCategoryHomePage$$ExternalSyntheticOutline1.m(BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("loading pag loadFailure curTheme:"), NBPViewModelStoreKt.getMapThemeVM(NBPMainKtxKt.getNbpVMStore(NBPThemeLoadingAnimationView.this.getPager())).currentThemeId, KLog.INSTANCE, "ThemeLoadingAnimation");
                                        NBPViewModelStoreKt.getMapThemeVM(NBPMainKtxKt.getNbpVMStore(NBPThemeLoadingAnimationView.this.getPager())).themeSwitchLoadingAnimationEndPlay();
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPThemeLoadingAnimationView nBPThemeLoadingAnimationView4 = NBPThemeLoadingAnimationView.this;
                                pAGEvent2.register("animationStart", new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.theme.view.NBPThemeLoadingAnimationView.body.1.2.2.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(Object obj) {
                                        final NBPMainMapThemeViewModel mapThemeVM = NBPViewModelStoreKt.getMapThemeVM(NBPMainKtxKt.getNbpVMStore(NBPThemeLoadingAnimationView.this.getPager()));
                                        mapThemeVM.getClass();
                                        AdelieCategoryHomePage$$ExternalSyntheticOutline1.m(BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("themeSwitchLoadingAnimationBeginPlay curTheme:"), mapThemeVM.currentThemeId, KLog.INSTANCE, "ThemeLoadingAnimation");
                                        mapThemeVM.setThemeSwitchLoadingAnimationPlaying(true);
                                        TimerKt.d(3000, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.theme.NBPMainMapThemeViewModel$themeSwitchLoadingAnimationBeginPlay$1
                                            {
                                                super(0);
                                            }

                                            @Override // kotlin.jvm.functions.Function0
                                            public final Unit invoke() {
                                                if (NBPMainMapThemeViewModel.this.getThemeSwitchLoadingAnimationPlaying()) {
                                                    NBPMainMapThemeViewModel.this.setThemeSwitchLoadingAnimationPlaying(false);
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPThemeLoadingAnimationView nBPThemeLoadingAnimationView5 = NBPThemeLoadingAnimationView.this;
                                pAGEvent2.register("animationEnd", new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.theme.view.NBPThemeLoadingAnimationView.body.1.2.2.3
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(Object obj) {
                                        NBPViewModelStoreKt.getMapThemeVM(NBPMainKtxKt.getNbpVMStore(NBPThemeLoadingAnimationView.this.getPager())).themeSwitchLoadingAnimationEndPlay();
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
        return new NBPThemeLoadingAnimationAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new NBPThemeLoadingAnimationEvent();
    }
}
