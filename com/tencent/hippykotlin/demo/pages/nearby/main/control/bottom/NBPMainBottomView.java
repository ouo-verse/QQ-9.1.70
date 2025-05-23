package com.tencent.hippykotlin.demo.pages.nearby.main.control.bottom;

import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieAgreementConsentPage$onCreate$1$1$3$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.BridgeModule;
import com.tencent.hippykotlin.demo.pages.base.QToastMode;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyConstKt;
import com.tencent.hippykotlin.demo.pages.nearby.base.module.QQNearbyModule;
import com.tencent.hippykotlin.demo.pages.nearby.base.utils.FastClickUtils;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.CameraPosition;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.TextViewExtKt;
import com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPJumpUtil;
import com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPMainKtxKt;
import com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPViewModelStoreKt;
import com.tencent.hippykotlin.demo.pages.nearby.main.control.NBPMainControlViewModel;
import com.tencent.hippykotlin.demo.pages.nearby.main.control.title.NBPMainTitleViewModel;
import com.tencent.hippykotlin.demo.pages.nearby.main.theme.NBPMainMapThemeViewModel;
import com.tencent.hippykotlin.demo.pages.nearby.main.theme.NBPMainThemeGuideType;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.AccessibilityRole;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.b;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.event.VisibilityEventKt;
import com.tencent.kuikly.core.base.g;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.k;
import com.tencent.kuikly.core.base.l;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.base.s;
import com.tencent.kuikly.core.base.y;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
import com.tencent.kuikly.core.layout.d;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.nvi.serialization.json.e;
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
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* loaded from: classes31.dex */
public final class NBPMainBottomView extends ComposeView<k, l> {
    public static final Companion Companion = new Companion();
    public static final Lazy<Boolean> bottomBarIconUseShortMargin$delegate;
    public static final Set<String> bottomBarShortMarginBlackSet;
    public final FastClickUtils fastClickUtils = new FastClickUtils(500);
    public d themeListIconFrame = new d(0.0f, 0.0f, 0.0f, 0.0f, 15, null);

    /* loaded from: classes31.dex */
    public static final class Companion {
    }

    static {
        Lazy<Boolean> lazy;
        Set<String> of5;
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<Boolean>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.bottom.NBPMainBottomView$Companion$bottomBarIconUseShortMargin$2
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                c cVar = c.f117352a;
                return Boolean.valueOf(defpackage.k.a(cVar) ? NBPMainBottomView.bottomBarShortMarginBlackSet.contains(((QQKuiklyPlatformApi) cVar.g().acquireModule("QQKuiklyPlatformApi")).getDeviceInfo().model) : false);
            }
        });
        bottomBarIconUseShortMargin$delegate = lazy;
        of5 = SetsKt__SetsKt.setOf((Object[]) new String[]{"ANA-AN00", "PFEM10"});
        bottomBarShortMarginBlackSet = of5;
    }

    public static final void access$onClickFeedsEntrance(NBPMainBottomView nBPMainBottomView) {
        if (nBPMainBottomView.fastClickUtils.isFastDoubleClick()) {
            return;
        }
        e jsonWithMainPgParams = NearbyConstKt.jsonWithMainPgParams();
        jsonWithMainPgParams.v("dt_eid", "em_nearby_feeds_en");
        jsonWithMainPgParams.v(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
        Utils.INSTANCE.currentBridgeModule().reportCustomDtEvent("dt_clck", jsonWithMainPgParams);
        NBPJumpUtil.jumpSquareFeedList$default(null, null, null, "7", false, NBPViewModelStoreKt.getMapThemeVM(NBPMainKtxKt.getNbpVMStore(nBPMainBottomView.getPager())).currentThemeId, null, null, 208);
    }

    public static final boolean access$shouldShowGuideBubble(NBPMainBottomView nBPMainBottomView) {
        int ordinal;
        NBPMainThemeGuideType themeGuideType = NBPViewModelStoreKt.getMapThemeVM(NBPMainKtxKt.getNbpVMStore(nBPMainBottomView.getPager())).getThemeGuideType();
        if (themeGuideType != null && (ordinal = themeGuideType.ordinal()) != 0) {
            if (ordinal == 1) {
                return true;
            }
            if (ordinal != 2) {
                throw new NoWhenBranchMatchedException();
            }
        }
        return false;
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        final NBPMainTitleViewModel titleViewModel = NBPViewModelStoreKt.getTitleViewModel(NBPMainKtxKt.getNbpVMStore(getPager()));
        final NBPMainControlViewModel controlViewModel = NBPViewModelStoreKt.getControlViewModel(NBPMainKtxKt.getNbpVMStore(getPager()));
        final NBPMainMapThemeViewModel mapThemeVM = NBPViewModelStoreKt.getMapThemeVM(NBPMainKtxKt.getNbpVMStore(getPager()));
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.bottom.NBPMainBottomView$body$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.bottom.NBPMainBottomView$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        mVar2.flexDirectionRow();
                        mVar2.alignItemsCenter();
                        mVar2.justifyContentCenter();
                        return Unit.INSTANCE;
                    }
                });
                final NBPMainBottomView nBPMainBottomView = NBPMainBottomView.this;
                final NBPMainTitleViewModel nBPMainTitleViewModel = titleViewModel;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.bottom.NBPMainBottomView$body$1.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.bottom.NBPMainBottomView.body.1.2.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.size(60.0f, 60.0f);
                                tVar2.borderRadius(30.0f);
                                h.Companion companion = h.INSTANCE;
                                tVar2.mo139boxShadow(new g(0.0f, 4.0f, 12.0f, companion.a(0.12f)));
                                tVar2.allCenter();
                                tVar2.mo113backgroundColor(companion.m());
                                tVar2.accessibility("\u6d88\u606f\u5217\u8868\u5165\u53e3");
                                tVar2.accessibilityRole(AccessibilityRole.BUTTON);
                                return Unit.INSTANCE;
                            }
                        });
                        final NBPMainBottomView nBPMainBottomView2 = NBPMainBottomView.this;
                        final NBPMainTitleViewModel nBPMainTitleViewModel2 = nBPMainTitleViewModel;
                        vVar2.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.bottom.NBPMainBottomView.body.1.2.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(u uVar) {
                                u uVar2 = uVar;
                                final NBPMainBottomView nBPMainBottomView3 = NBPMainBottomView.this;
                                final NBPMainTitleViewModel nBPMainTitleViewModel3 = nBPMainTitleViewModel2;
                                uVar2.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.bottom.NBPMainBottomView.body.1.2.2.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ClickParams clickParams) {
                                        if (!NBPMainBottomView.this.fastClickUtils.isFastDoubleClick()) {
                                            NBPViewModelStoreKt.getGuideViewModel(NBPMainKtxKt.getVmStore()).setInMainPage(false);
                                            nBPMainTitleViewModel3.getClass();
                                            KLog.INSTANCE.i("NBPMainTitleViewModel", "open nbp chat list");
                                            final QQNearbyModule companion = QQNearbyModule.Companion.getInstance();
                                            companion.getClass();
                                            companion.checkAioAccess(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.module.QQNearbyModule$openNearbyProChatList$1
                                                {
                                                    super(0);
                                                }

                                                @Override // kotlin.jvm.functions.Function0
                                                public final Unit invoke() {
                                                    QQNearbyModule.this.asyncToNativeMethod("openChatList", (e) null, (Function1<? super e, Unit>) null);
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            e jsonWithMainPgParams = NearbyConstKt.jsonWithMainPgParams();
                                            jsonWithMainPgParams.v("dt_eid", "em_nearby_msg_list_en");
                                            jsonWithMainPgParams.v(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
                                            Utils.INSTANCE.currentBridgeModule().reportCustomDtEvent("dt_clck", jsonWithMainPgParams);
                                        }
                                        return Unit.INSTANCE;
                                    }
                                });
                                VisibilityEventKt.b(uVar2, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.bottom.NBPMainBottomView.body.1.2.2.2
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(Object obj) {
                                        e jsonWithMainPgParamsImp = NearbyConstKt.jsonWithMainPgParamsImp();
                                        jsonWithMainPgParamsImp.v("dt_eid", "em_nearby_msg_list_en");
                                        jsonWithMainPgParamsImp.v(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
                                        Utils.INSTANCE.currentBridgeModule().reportCustomDtEvent("dt_imp", jsonWithMainPgParamsImp);
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final NBPMainTitleViewModel nBPMainTitleViewModel3 = nBPMainTitleViewModel;
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.bottom.NBPMainBottomView.body.1.2.3
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                v vVar4 = vVar3;
                                vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.bottom.NBPMainBottomView.body.1.2.3.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.flexDirectionRow();
                                        tVar2.size(30.0f, 30.0f);
                                        return Unit.INSTANCE;
                                    }
                                });
                                ah.a(vVar4, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.bottom.NBPMainBottomView.body.1.2.3.2
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ImageView imageView) {
                                        imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.bottom.NBPMainBottomView.body.1.2.3.2.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(af afVar) {
                                                af afVar2 = afVar;
                                                afVar2.size(30.0f, 30.0f);
                                                b.a.b(afVar2, "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAFoAAABaCAMAAAAPdrEwAAAAPFBMVEUAAAAwMDIwMDUvMDMwMDQvMDMvMDMvMDMwMDAvMDMvMDMvMDQwMDQwMDUvMDMwMDMwMDQwMEEvMDIvMDOoY2XcAAAAE3RSTlMAYCDfQIDvnxCQv89wMK9QvxBvul67IAAAAeJJREFUWMPt2FuSozAMBVDZ8gsTQmjtf6/zMV2lKjSODb7zx1mAUF8LOTQ9Hg8wH3Z3EoKfrvrKLA3r22100xZZOni5032oMqQ6eGHF+5WIq1ySh2P5SXIRj6VyLHLDMhLGKresvluZ5Sb2Y5XxtQ+WCVyo7S1TKjVFmRSbQcu00CitQaPjjgIQ0XOnUiErC0TsNI1t2wnIy5ReBaTCZ1r5wTzY+ZBPacZtc9xJpL891mKey75z6u9T6fR1Ty6i3O/F3J6Roagz/VX0ySv9qt2wv/awaV4myZe07COnqPvF7rZNWtzAakr6aFvaD77rcbjrvd91HNlNvpG1ydAcvlo6z2f7HufBnzvx+xr7sXeUH92rr69/25bMa3R03/RucDXQEdNprRxHMJXtXNvjRl/rRYAK+iYwW0anDyafSgdB0VPUtQmS6GyB54FPJJBRBeJDCty2o3+o0KHGt+3JskOC/DItjP4oUD7JlOSpycF+/1oR/h2jIryyivDK6pVunaCjAZ7R/1VQZZGLFp1nbOOfQFc4hhdW4S19SQtf4nOnbnaaMbB4dZ7m+Mit23VecTxynajpcUkE4j69q0rNz+JOOD6bvY8sjhwRO4vAEbGzqCMC5xg7InYWC/0fYQn0eEz5A2eRH3aDjeU4AAAAAElFTkSuQmCC", false, 2, null);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPMainTitleViewModel nBPMainTitleViewModel4 = NBPMainTitleViewModel.this;
                                Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.bottom.NBPMainBottomView.body.1.2.3.3
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return Boolean.valueOf(NBPMainTitleViewModel.this.unreadMsgCount().length() > 0);
                                    }
                                };
                                final NBPMainTitleViewModel nBPMainTitleViewModel5 = NBPMainTitleViewModel.this;
                                ConditionViewKt.c(vVar4, function0, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.bottom.NBPMainBottomView.body.1.2.3.4
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ConditionView conditionView) {
                                        final NBPMainTitleViewModel nBPMainTitleViewModel6 = NBPMainTitleViewModel.this;
                                        w.a(conditionView, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.bottom.NBPMainBottomView.body.1.2.3.4.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(v vVar5) {
                                                v vVar6 = vVar5;
                                                vVar6.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.bottom.NBPMainBottomView.body.1.2.3.4.1.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(t tVar) {
                                                        t tVar2 = tVar;
                                                        Attr.absolutePosition$default(tVar2, -6.0f, 0.0f, 0.0f, -6.0f, 6, null);
                                                        tVar2.allCenter();
                                                        tVar2.padding(3.0f);
                                                        tVar2.mo113backgroundColor(h.INSTANCE.i());
                                                        tVar2.mo141height(15.0f);
                                                        tVar2.m146minWidth(15.0f);
                                                        tVar2.borderRadius(7.5f);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final NBPMainTitleViewModel nBPMainTitleViewModel7 = NBPMainTitleViewModel.this;
                                                cg.a(vVar6, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.bottom.NBPMainBottomView.body.1.2.3.4.1.2
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(TextView textView) {
                                                        final NBPMainTitleViewModel nBPMainTitleViewModel8 = NBPMainTitleViewModel.this;
                                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.bottom.NBPMainBottomView.body.1.2.3.4.1.2.1
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ce ceVar) {
                                                                ce ceVar2 = ceVar;
                                                                ceVar2.text(NBPMainTitleViewModel.this.unreadMsgCount());
                                                                ce.fontSize$default(ceVar2, 12.0f, null, 2, null);
                                                                ceVar2.fontWeight600();
                                                                ceVar2.color(h.INSTANCE.m());
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
                final NBPMainBottomView nBPMainBottomView2 = NBPMainBottomView.this;
                final NBPMainControlViewModel nBPMainControlViewModel = controlViewModel;
                final NBPMainTitleViewModel nBPMainTitleViewModel2 = titleViewModel;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.bottom.NBPMainBottomView$body$1.3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.bottom.NBPMainBottomView.body.1.3.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.size(60.0f, 60.0f);
                                Lazy<Boolean> lazy = NBPMainBottomView.bottomBarIconUseShortMargin$delegate;
                                tVar2.marginLeft(lazy.getValue().booleanValue() ? 17.0f : 28.0f);
                                tVar2.marginRight(lazy.getValue().booleanValue() ? 17.0f : 28.0f);
                                tVar2.borderRadius(30.0f);
                                h.Companion companion = h.INSTANCE;
                                tVar2.mo139boxShadow(new g(0.0f, 4.0f, 12.0f, companion.a(0.12f)));
                                tVar2.allCenter();
                                tVar2.mo113backgroundColor(companion.m());
                                tVar2.accessibility("\u52a8\u6001\u53d1\u8868\u5165\u53e3");
                                tVar2.accessibilityRole(AccessibilityRole.BUTTON);
                                return Unit.INSTANCE;
                            }
                        });
                        final NBPMainBottomView nBPMainBottomView3 = NBPMainBottomView.this;
                        final NBPMainControlViewModel nBPMainControlViewModel2 = nBPMainControlViewModel;
                        final NBPMainTitleViewModel nBPMainTitleViewModel3 = nBPMainTitleViewModel2;
                        vVar2.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.bottom.NBPMainBottomView.body.1.3.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(u uVar) {
                                u uVar2 = uVar;
                                final NBPMainBottomView nBPMainBottomView4 = NBPMainBottomView.this;
                                final NBPMainControlViewModel nBPMainControlViewModel3 = nBPMainControlViewModel2;
                                final NBPMainTitleViewModel nBPMainTitleViewModel4 = nBPMainTitleViewModel3;
                                uVar2.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.bottom.NBPMainBottomView.body.1.3.2.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ClickParams clickParams) {
                                        if (!NBPMainBottomView.this.fastClickUtils.isFastDoubleClick()) {
                                            NBPMainControlViewModel nBPMainControlViewModel4 = nBPMainControlViewModel3;
                                            String str = nBPMainTitleViewModel4.getCurMapTheme().f421849d;
                                            nBPMainControlViewModel4.getClass();
                                            if (NBPMainKtxKt.getVmStore().loginSuccess) {
                                                AdelieAgreementConsentPage$onCreate$1$1$3$$ExternalSyntheticOutline0.m((com.tencent.kuikly.core.module.k) c.f117352a.g().acquireModule("KRNotifyModule"), "ignore_next_pause_event", false, 4, null);
                                                NBPJumpUtil nBPJumpUtil = NBPJumpUtil.INSTANCE;
                                                CameraPosition cameraPosition = nBPMainControlViewModel4.curCameraPos;
                                                nBPJumpUtil.jumpPublishPage("0", cameraPosition != null ? cameraPosition.target : null, str);
                                                e jsonWithMainPgParams = NearbyConstKt.jsonWithMainPgParams();
                                                jsonWithMainPgParams.v("dt_eid", "em_nearby_publish_status_en");
                                                jsonWithMainPgParams.v(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
                                                Utils.INSTANCE.currentBridgeModule().reportCustomDtEvent("dt_clck", jsonWithMainPgParams);
                                            } else {
                                                KLog.INSTANCE.i("NBPMainControlViewModel", "\u6b63\u5728\u767b\u5f55\u4e2d, \u8fc7\u6ee4\u53d1\u5e03\u9875\u6309\u94ae\u70b9\u51fb");
                                                ((BridgeModule) c.f117352a.g().acquireModule("HRBridgeModule")).qToast("\u6570\u636e\u8bf7\u6c42\u4e2d, \u8bf7\u7a0d\u540e\u91cd\u8bd5!!", QToastMode.Info);
                                            }
                                            e jsonWithMainPgParams2 = NearbyConstKt.jsonWithMainPgParams();
                                            jsonWithMainPgParams2.v("dt_eid", "em_nearby_publish_en");
                                            jsonWithMainPgParams2.v(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
                                            Utils.INSTANCE.currentBridgeModule().reportCustomDtEvent("dt_clck", jsonWithMainPgParams2);
                                        }
                                        return Unit.INSTANCE;
                                    }
                                });
                                VisibilityEventKt.b(uVar2, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.bottom.NBPMainBottomView.body.1.3.2.2
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(Object obj) {
                                        e jsonWithMainPgParamsImp = NearbyConstKt.jsonWithMainPgParamsImp();
                                        jsonWithMainPgParamsImp.v("dt_eid", "em_nearby_publish_en");
                                        jsonWithMainPgParamsImp.v(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
                                        Utils.INSTANCE.currentBridgeModule().reportCustomDtEvent("dt_imp", jsonWithMainPgParamsImp);
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        ah.a(vVar2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.bottom.NBPMainBottomView.body.1.3.3
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ImageView imageView) {
                                imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.bottom.NBPMainBottomView.body.1.3.3.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(af afVar) {
                                        af afVar2 = afVar;
                                        afVar2.size(30.0f, 30.0f);
                                        b.a.b(afVar2, "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAFoAAABaCAMAAAAPdrEwAAAAQlBMVEUAAAAwMDcvMDMvMDMvMDMvMDMwMDQwMDIvMDMwMDAwMEEwMDMwMDQvMDMwMDMwMDQuMDIvMDIwMDMuMDIvMDIvMDO1Jw8KAAAAFXRSTlMAIL+f799AYM8QEJCArzBwj3BQf9/FR9kdAAACVUlEQVRYw+2YW5KtIAxFJTzUVtTjaeY/1XurH24RhY7k0/VruSoGSQLNw0MlbtQnjGu92IYLbKW8DRnaGrMKOYyqUOuQZahQm7zacBIQM4UCk4q50H68yIRKDLUn+tkEEezrGDIFMXwfmbsgSLd3L0EUHe05WdymjtIhkRv6Nce/ryLBsOc4T05APf+ofQBWNQ1JLWSsGpGgGihV09c+HeXV9jf7Sp9WCEv/MTfUFl0jlRu9FZ7eactTGxdXlb2b1v7QMjUvIaQgfuO7kac9yvKWUatUHAZEHPFiqLdtZAMwWIE0cJaaDtXKTFAx3FDHYdtzs1t899nRsn7s3Bw1RUHPp+uq1eY2DHXYj2LDVed8Yy0Z6p3E9pddqFN4uaxOaTNDlFVICV9tEXOmuY531G2+cy4YOblqW/p5HV7nqNEp3qUtN/PVP1N/pgwpZKSoTl/MNuERo3JZnQ7PQ7m+ea66w8PC6K65asJkdQn+7Dtqm1OrSrV81F2yRsWVlv9DiKsO3+VnLZ8bu5u7sTelUbfn78YBGcnWr5WpRrJV6fivOWp8b25u9ex6DQhHnUwHezPUwGWagZnw8IaaricZO6FxMtRgO28Px1cVLmPuqTGXKQqAHCYzvhprtVm+LzUMDS4527PVcMOfnhz46tQNEPMtdXl2dzZUqDHzpiEvzCNpWY5xu04NqFXwth7ivFr/9TpMj+Oo/Wco43FpIQsOKk5eve1iElOi/4iHnV4/D7LmoQG9/BUi3F7OTP3xnsDKiM3cJKhW4pL5hZAP+kqah4eHByn+Ae2gcZA9Kd2sAAAAAElFTkSuQmCC", false, 2, null);
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final NBPMainBottomView nBPMainBottomView3 = NBPMainBottomView.this;
                final NBPMainControlViewModel nBPMainControlViewModel2 = controlViewModel;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.bottom.NBPMainBottomView$body$1.4
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.bottom.NBPMainBottomView.body.1.4.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.size(60.0f, 60.0f);
                                tVar2.accessibilityRole(AccessibilityRole.BUTTON);
                                return Unit.INSTANCE;
                            }
                        });
                        final NBPMainBottomView nBPMainBottomView4 = NBPMainBottomView.this;
                        vVar2.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.bottom.NBPMainBottomView.body.1.4.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(u uVar) {
                                u uVar2 = uVar;
                                final NBPMainBottomView nBPMainBottomView5 = NBPMainBottomView.this;
                                uVar2.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.bottom.NBPMainBottomView.body.1.4.2.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ClickParams clickParams) {
                                        NBPMainBottomView.access$onClickFeedsEntrance(NBPMainBottomView.this);
                                        return Unit.INSTANCE;
                                    }
                                });
                                VisibilityEventKt.b(uVar2, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.bottom.NBPMainBottomView.body.1.4.2.2
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(Object obj) {
                                        e jsonWithMainPgParamsImp = NearbyConstKt.jsonWithMainPgParamsImp();
                                        jsonWithMainPgParamsImp.v("dt_eid", "em_nearby_feeds_en");
                                        jsonWithMainPgParamsImp.v(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
                                        Utils.INSTANCE.currentBridgeModule().reportCustomDtEvent("dt_imp", jsonWithMainPgParamsImp);
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final NBPMainControlViewModel nBPMainControlViewModel3 = nBPMainControlViewModel2;
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.bottom.NBPMainBottomView.body.1.4.3
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                v vVar4 = vVar3;
                                final NBPMainControlViewModel nBPMainControlViewModel4 = NBPMainControlViewModel.this;
                                vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.bottom.NBPMainBottomView.body.1.4.3.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.mo141height(60.0f);
                                        tVar2.borderRadius(30.0f);
                                        h.Companion companion = h.INSTANCE;
                                        tVar2.mo139boxShadow(new g(0.0f, 4.0f, 12.0f, companion.a(0.12f)));
                                        tVar2.mo113backgroundColor(companion.m());
                                        if (NBPMainControlViewModel.this.getShowFeedsEntranceTips()) {
                                            tVar2.mo153width(130.0f);
                                        } else {
                                            tVar2.mo153width(60.0f);
                                        }
                                        tVar2.animate(b.Companion.h(com.tencent.kuikly.core.base.b.INSTANCE, 0.33f, null, 2, null), Boolean.valueOf(NBPMainControlViewModel.this.getShowFeedsEntranceTips()));
                                        return Unit.INSTANCE;
                                    }
                                });
                                ah.a(vVar4, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.bottom.NBPMainBottomView.body.1.4.3.2
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ImageView imageView) {
                                        imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.bottom.NBPMainBottomView.body.1.4.3.2.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(af afVar) {
                                                af afVar2 = afVar;
                                                Attr.absolutePosition$default(afVar2, 15.0f, 15.0f, 0.0f, 0.0f, 12, null);
                                                afVar2.size(30.0f, 30.0f);
                                                afVar2.o();
                                                b.a.b(afVar2, "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAFoAAABaCAMAAAAPdrEwAAAAOVBMVEUAAAAwMDMvMDMwMDYvMDMvMDMwMDQwMDQvMDMwMDIvMDMwMDQwMDMvMDQwMDIuMDIwMDQvMDMvMDMtJLoIAAAAEnRSTlMAoN8g779AMJAQcIBQz2B/z89fU4cMAAABbklEQVRYw+3Y227CMAyAYceO05Qe2Pz+DzsB09IOHJws2pX/G4REPiJTbgye19l8CYwolhA572SFiaW1YMMvUdqLF4N8lb6u7+8svb27N8VuOlKdntaJZtNDRGld+GQzjIzC0Z5haHs0TDvlT4zmwSLn9BhhOROG/U8E6X4lfdjlu5uL0+1s/vkq5Znrf+DmWKOxgy0zWOQ7eC5Jd+l+XKdzP51v5ys099PbcZ7DRl1+Otbp2E/H2/mg0/KHnHbaaaeddtppp5122un/p0OCeUXZ0gwpDKWXx9v98bK00qjTAc7xODrBudRIs04/bWoa6WynoZHe7QOZGmnS6QXOBSvN+hJHXl57kiY6Uo2O01GOZnrTl1qv1oCEYqbLNHVakIpspqfKulZOdpGN9CJMoBR/24QtS4t1BjWUk90gC0K97fzptS7rO9rha63S8GVcPW7R9FEPX3yWxq5rDRG2y0xgK2VuWY1/5ASe543pC8h7NngvfEP1AAAAAElFTkSuQmCC", false, 2, null);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPMainControlViewModel nBPMainControlViewModel5 = NBPMainControlViewModel.this;
                                w.a(vVar4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.bottom.NBPMainBottomView.body.1.4.3.3
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar5) {
                                        v vVar6 = vVar5;
                                        final NBPMainControlViewModel nBPMainControlViewModel6 = NBPMainControlViewModel.this;
                                        vVar6.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.bottom.NBPMainBottomView.body.1.4.3.3.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                t tVar2 = tVar;
                                                Attr.absolutePosition$default(tVar2, 13.0f, 55.0f, 0.0f, 0.0f, 12, null);
                                                tVar2.flexDirectionColumn();
                                                if (NBPMainControlViewModel.this.getShowFeedsEntranceTips()) {
                                                    tVar2.m147opacity(1.0f);
                                                    tVar2.animate(b.Companion.l(com.tencent.kuikly.core.base.b.INSTANCE, 0.2f, null, 2, null), Boolean.valueOf(NBPMainControlViewModel.this.getShowFeedsEntranceTips()));
                                                } else {
                                                    tVar2.m147opacity(0.0f);
                                                    com.tencent.kuikly.core.base.b l3 = b.Companion.l(com.tencent.kuikly.core.base.b.INSTANCE, 0.16f, null, 2, null);
                                                    l3.h(0.17f);
                                                    tVar2.animate(l3, Boolean.valueOf(NBPMainControlViewModel.this.getShowFeedsEntranceTips()));
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        cg.a(vVar6, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.bottom.NBPMainBottomView.body.1.4.3.3.2
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(TextView textView) {
                                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.bottom.NBPMainBottomView.body.1.4.3.3.2.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ce ceVar) {
                                                        ce ceVar2 = ceVar;
                                                        ce.fontSize$default(ceVar2, 12.0f, null, 2, null);
                                                        ceVar2.lineHeight(16.8f);
                                                        ceVar2.color(h.INSTANCE.b());
                                                        ceVar2.fontWeight500();
                                                        TextViewExtKt.textWithLineHeightFix(ceVar2, "\u770b\u770b\u4eca\u65e5");
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        cg.a(vVar6, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.bottom.NBPMainBottomView.body.1.4.3.3.3
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(TextView textView) {
                                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.bottom.NBPMainBottomView.body.1.4.3.3.3.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ce ceVar) {
                                                        ce ceVar2 = ceVar;
                                                        ce.fontSize$default(ceVar2, 12.0f, null, 2, null);
                                                        ceVar2.lineHeight(16.8f);
                                                        ceVar2.color(h.INSTANCE.b());
                                                        ceVar2.fontWeight500();
                                                        TextViewExtKt.textWithLineHeightFix(ceVar2, "\u9644\u8fd1\u65b0\u9c9c\u4e8b");
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
                final NBPMainControlViewModel nBPMainControlViewModel3 = controlViewModel;
                Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.bottom.NBPMainBottomView$body$1.5
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Boolean.valueOf(NBPMainControlViewModel.this.getShowFeedsEntranceTips());
                    }
                };
                final NBPMainBottomView nBPMainBottomView4 = NBPMainBottomView.this;
                ConditionViewKt.c(viewContainer2, function0, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.bottom.NBPMainBottomView$body$1.6
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ConditionView conditionView) {
                        final NBPMainBottomView nBPMainBottomView5 = NBPMainBottomView.this;
                        w.a(conditionView, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.bottom.NBPMainBottomView.body.1.6.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar) {
                                v vVar2 = vVar;
                                vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.bottom.NBPMainBottomView.body.1.6.1.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.size(130.0f, 60.0f);
                                        tVar2.mo113backgroundColor(h.INSTANCE.j());
                                        tVar2.absolutePositionAllZero();
                                        tVar2.left(new s(50.0f));
                                        tVar2.transform(new y(0.0f, 0.0f, 58.0f, 0.0f, 8, null));
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPMainBottomView nBPMainBottomView6 = NBPMainBottomView.this;
                                vVar2.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.bottom.NBPMainBottomView.body.1.6.1.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(u uVar) {
                                        final NBPMainBottomView nBPMainBottomView7 = NBPMainBottomView.this;
                                        uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.bottom.NBPMainBottomView.body.1.6.1.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ClickParams clickParams) {
                                                NBPMainBottomView.access$onClickFeedsEntrance(NBPMainBottomView.this);
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
                final NBPMainBottomView nBPMainBottomView5 = NBPMainBottomView.this;
                Function0<Object> function02 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.bottom.NBPMainBottomView$body$1.7
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Boolean.valueOf(NBPMainBottomView.access$shouldShowGuideBubble(NBPMainBottomView.this));
                    }
                };
                final NBPMainBottomView nBPMainBottomView6 = NBPMainBottomView.this;
                final NBPMainMapThemeViewModel nBPMainMapThemeViewModel = mapThemeVM;
                ConditionViewKt.c(viewContainer2, function02, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.bottom.NBPMainBottomView$body$1.8
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ConditionView conditionView) {
                        final NBPMainBottomView nBPMainBottomView7 = NBPMainBottomView.this;
                        final NBPMainMapThemeViewModel nBPMainMapThemeViewModel2 = nBPMainMapThemeViewModel;
                        conditionView.addChild(new NBPMainBottomGuideBubbleView(), new Function1<NBPMainBottomGuideBubbleView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.bottom.NBPMainBottomView.body.1.8.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(NBPMainBottomGuideBubbleView nBPMainBottomGuideBubbleView) {
                                final NBPMainBottomView nBPMainBottomView8 = NBPMainBottomView.this;
                                final NBPMainMapThemeViewModel nBPMainMapThemeViewModel3 = nBPMainMapThemeViewModel2;
                                nBPMainBottomGuideBubbleView.attr(new Function1<NBPMainBottomGuideBubbleViewAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.bottom.NBPMainBottomView.body.1.8.1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(NBPMainBottomGuideBubbleViewAttr nBPMainBottomGuideBubbleViewAttr) {
                                        Float valueOf;
                                        NBPMainBottomGuideBubbleViewAttr nBPMainBottomGuideBubbleViewAttr2 = nBPMainBottomGuideBubbleViewAttr;
                                        Attr.absolutePosition$default(nBPMainBottomGuideBubbleViewAttr2, 0.0f, 0.0f, 76.0f, 0.0f, 1, null);
                                        NBPMainBottomView nBPMainBottomView9 = NBPMainBottomView.this;
                                        NBPMainThemeGuideType themeGuideType = nBPMainMapThemeViewModel3.getThemeGuideType();
                                        Intrinsics.checkNotNull(themeGuideType);
                                        d dVar = NBPMainBottomView.this.themeListIconFrame;
                                        nBPMainBottomView9.getClass();
                                        int ordinal = themeGuideType.ordinal();
                                        if (ordinal == 0) {
                                            valueOf = Float.valueOf((dVar.getWidth() / 2.0f) + dVar.getX());
                                        } else if (ordinal == 1) {
                                            valueOf = Float.valueOf(nBPMainBottomView9.getPagerData().m() / 2.0f);
                                        } else if (ordinal == 2) {
                                            valueOf = Float.valueOf((dVar.getWidth() / 2.0f) + dVar.getX());
                                        } else {
                                            throw new NoWhenBranchMatchedException();
                                        }
                                        nBPMainBottomGuideBubbleViewAttr2.trianglePosition = valueOf;
                                        NBPMainMapThemeViewModel nBPMainMapThemeViewModel4 = nBPMainMapThemeViewModel3;
                                        ReadWriteProperty readWriteProperty = nBPMainMapThemeViewModel4.themeGuideLeftIcon$delegate;
                                        KProperty<?>[] kPropertyArr = NBPMainMapThemeViewModel.$$delegatedProperties;
                                        nBPMainBottomGuideBubbleViewAttr2.guideLeftIcon = (String) readWriteProperty.getValue(nBPMainMapThemeViewModel4, kPropertyArr[7]);
                                        nBPMainBottomGuideBubbleViewAttr2.guideText = nBPMainMapThemeViewModel3.getThemeGuideText();
                                        NBPMainMapThemeViewModel nBPMainMapThemeViewModel5 = nBPMainMapThemeViewModel3;
                                        nBPMainBottomGuideBubbleViewAttr2.guideRightIcon = (String) nBPMainMapThemeViewModel5.themeGuideRightIcon$delegate.getValue(nBPMainMapThemeViewModel5, kPropertyArr[9]);
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
        return new k();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new l();
    }
}
