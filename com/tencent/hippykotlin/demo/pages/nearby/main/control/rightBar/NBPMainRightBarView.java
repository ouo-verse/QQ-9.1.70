package com.tencent.hippykotlin.demo.pages.nearby.main.control.rightBar;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieCategoryHomePage$$ExternalSyntheticOutline1;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.view.DataCardKt$DataCard$3$1$1$1$1$1$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.hippykotlin.demo.pages.foundation.view.APNGAttr;
import com.tencent.hippykotlin.demo.pages.foundation.view.APNGVView;
import com.tencent.hippykotlin.demo.pages.foundation.view.APNGViewKt;
import com.tencent.hippykotlin.demo.pages.nearby.base.NBPSchemeGeneratorKt;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyConstKt;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.UserDataManager;
import com.tencent.hippykotlin.demo.pages.nearby.base.module.QQNearbyModule;
import com.tencent.hippykotlin.demo.pages.nearby.base.utils.FastClickUtils;
import com.tencent.hippykotlin.demo.pages.nearby.base.utils.NearbyProUtilsKt;
import com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPJumpUtil;
import com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPMainKtxKt;
import com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPViewModelStoreKt;
import com.tencent.hippykotlin.demo.pages.nearby.main.control.NBPMainControlViewModel;
import com.tencent.hippykotlin.demo.pages.nearby.main.control.pendant.NBPPendantViewModel;
import com.tencent.hippykotlin.demo.pages.nearby.main.control.title.NBPMainTitleViewModel;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.AccessibilityRole;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.event.VisibilityEventKt;
import com.tencent.kuikly.core.base.g;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.k;
import com.tencent.kuikly.core.base.l;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.module.d;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.views.ImageEvent;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.ModalView;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ah;
import com.tencent.kuikly.core.views.bb;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.u;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import o25.a;

/* loaded from: classes31.dex */
public final class NBPMainRightBarView extends ComposeView<k, l> {
    public NBPMainControlViewModel controlViewModel;
    public final FastClickUtils fastClickUtils = new FastClickUtils(500);

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        final NBPPendantViewModel nBPPendantViewModel = (NBPPendantViewModel) NBPMainKtxKt.getNbpVMStore(getPager()).getViewModel("NBPPendantViewModel");
        final NBPPendantViewModel nBPPendantViewModel2 = (NBPPendantViewModel) NBPMainKtxKt.getNbpVMStore(getPager()).getViewModel("NBPPendantViewModel");
        this.controlViewModel = NBPViewModelStoreKt.getControlViewModel(NBPMainKtxKt.getNbpVMStore(getPager()));
        final NBPMainTitleViewModel titleViewModel = NBPViewModelStoreKt.getTitleViewModel(NBPMainKtxKt.getNbpVMStore(getPager()));
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.rightBar.NBPMainRightBarView$body$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.rightBar.NBPMainRightBarView$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        mVar2.flexDirectionColumn();
                        mVar2.alignItemsCenter();
                        return Unit.INSTANCE;
                    }
                });
                final NBPMainRightBarView nBPMainRightBarView = NBPMainRightBarView.this;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.rightBar.NBPMainRightBarView$body$1.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.rightBar.NBPMainRightBarView.body.1.2.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.size(36.0f, 36.0f);
                                tVar2.borderRadius(18.0f);
                                h.Companion companion = h.INSTANCE;
                                tVar2.mo113backgroundColor(companion.m());
                                tVar2.boxShadow(new g(0.0f, 2.25f, 6.75f, companion.a(0.12f)), true);
                                tVar2.allCenter();
                                tVar2.accessibility("\u6211\u7684\u4e3b\u9875");
                                tVar2.accessibilityRole(AccessibilityRole.BUTTON);
                                return Unit.INSTANCE;
                            }
                        });
                        ah.a(vVar2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.rightBar.NBPMainRightBarView.body.1.2.2
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ImageView imageView) {
                                imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.rightBar.NBPMainRightBarView.body.1.2.2.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(af afVar) {
                                        af afVar2 = afVar;
                                        afVar2.size(18.0f, 18.0f);
                                        b.a.b(afVar2, QUIToken.INSTANCE.image(QCircleAlphaUserReporter.KEY_USER, new h(4281282611L)), false, 2, null);
                                        afVar2.o();
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final NBPMainRightBarView nBPMainRightBarView2 = NBPMainRightBarView.this;
                        vVar2.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.rightBar.NBPMainRightBarView.body.1.2.3
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(u uVar) {
                                u uVar2 = uVar;
                                final NBPMainRightBarView nBPMainRightBarView3 = NBPMainRightBarView.this;
                                uVar2.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.rightBar.NBPMainRightBarView.body.1.2.3.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ClickParams clickParams) {
                                        if (!NBPMainRightBarView.this.fastClickUtils.isFastDoubleClick()) {
                                            NBPMainRightBarView.this.getClass();
                                            NBPJumpUtil.jumpPersonaPage$default(2, String.valueOf(UserDataManager.INSTANCE.getUserSelfInfo().tid), true, false, null, null, 56);
                                            e jsonWithMainPgParams = NearbyConstKt.jsonWithMainPgParams();
                                            jsonWithMainPgParams.v("dt_eid", "em_nearby_personal_homepage_en");
                                            jsonWithMainPgParams.v(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
                                            Utils.INSTANCE.currentBridgeModule().reportCustomDtEvent("dt_clck", jsonWithMainPgParams);
                                        }
                                        return Unit.INSTANCE;
                                    }
                                });
                                VisibilityEventKt.b(uVar2, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.rightBar.NBPMainRightBarView.body.1.2.3.2
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(Object obj) {
                                        e jsonWithMainPgParamsImp = NearbyConstKt.jsonWithMainPgParamsImp();
                                        jsonWithMainPgParamsImp.v("dt_eid", "em_nearby_personal_homepage_en");
                                        jsonWithMainPgParamsImp.v(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
                                        Utils.INSTANCE.currentBridgeModule().reportCustomDtEvent("dt_imp", jsonWithMainPgParamsImp);
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final NBPMainRightBarView nBPMainRightBarView2 = NBPMainRightBarView.this;
                final NBPMainTitleViewModel nBPMainTitleViewModel = titleViewModel;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.rightBar.NBPMainRightBarView$body$1.3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.rightBar.NBPMainRightBarView.body.1.3.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.size(36.0f, 36.0f);
                                tVar2.marginTop(12.0f);
                                tVar2.borderRadius(18.0f);
                                h.Companion companion = h.INSTANCE;
                                tVar2.mo113backgroundColor(companion.m());
                                tVar2.boxShadow(new g(0.0f, 2.25f, 6.75f, companion.a(0.12f)), true);
                                tVar2.allCenter();
                                tVar2.accessibility("\u4e3b\u9898\u5730\u56fe\u9009\u62e9\u6309\u94ae");
                                tVar2.accessibilityRole(AccessibilityRole.BUTTON);
                                return Unit.INSTANCE;
                            }
                        });
                        ah.a(vVar2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.rightBar.NBPMainRightBarView.body.1.3.2
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ImageView imageView) {
                                imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.rightBar.NBPMainRightBarView.body.1.3.2.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(af afVar) {
                                        af afVar2 = afVar;
                                        afVar2.size(18.0f, 18.0f);
                                        b.a.b(afVar2, "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAADYAAAA2CAMAAAC7m5rvAAAAZlBMVEUAAAAvMDMwMDQwMDMwMDQAAAAlJSwvMDMAAAAwMDQvMDMwMDIAAAAAAAAwMDQvMDMvMDMwMDIAAAAvMDMWFhcAAAAAAAAuMDIAAAAAAAAuMDIwMDMAAAAAAAAAAAAAAAAvMDMAAABnfh9+AAAAIHRSTlMA34CfQCAQ75+/v2BgvyCQz3DvrzDfgH9QkI9QQG/PjxH9mo4AAAF/SURBVEjH7ZVtl4IgEIVDBPIlfK21sl35/39ypRFHwTb40DntOd1P2PAMd8Lj3X30ZoobMQxpFsTwqhxAxB+ML0ITYWCcDpZIvK677vkXHpRE1CzT2KlTjhCdGVHonXIB2u4bQ0ky24pMrzbBTpZ348BQyXoWA9ruU6hn0NMchLqafug+1SuoNvrXwoagozmxnJpG+gFqpT5/90DyGtGoascVYjgatbe3OVs+emInpY48FGPfalQXiN1qTdUsCGMHddc5n9QxD4zVylH/HDspV/vnWL+B5R6z5XtbSLnYX3o/jDNb3ANjR2Xr2L7s3vIN7OQx2+0wqwbqHPZP/sBkfdgFtDAXD7w3PkJ1F37d3eHMX/uW8IqWpEwjuY1R+LwihlGKmWGLX3Qlwc+rsMIKQTcAp4grIGucVFyFIK9MnZgu670ioQ2xkliiETJPXSzDqOL3zFiC4M7NpQLDaCvesGcGEO4Rg5gOegQKij0duSC685ekGM9+wlzM5O5f6hdGkmEDXKuGPgAAAABJRU5ErkJggg==", false, 2, null);
                                        afVar2.o();
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final NBPMainRightBarView nBPMainRightBarView3 = NBPMainRightBarView.this;
                        final NBPMainTitleViewModel nBPMainTitleViewModel2 = nBPMainTitleViewModel;
                        vVar2.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.rightBar.NBPMainRightBarView.body.1.3.3
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(u uVar) {
                                u uVar2 = uVar;
                                final NBPMainRightBarView nBPMainRightBarView4 = NBPMainRightBarView.this;
                                final NBPMainTitleViewModel nBPMainTitleViewModel3 = nBPMainTitleViewModel2;
                                uVar2.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.rightBar.NBPMainRightBarView.body.1.3.3.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ClickParams clickParams) {
                                        byte[] encodeToByteArray;
                                        if (!NBPMainRightBarView.this.fastClickUtils.isFastDoubleClick()) {
                                            KLog kLog = KLog.INSTANCE;
                                            AdelieCategoryHomePage$$ExternalSyntheticOutline1.m(BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("clicked change theme button, current theme id: "), nBPMainTitleViewModel3.getCurMapTheme().f421849d, kLog, "NBPMainRightBar");
                                            NBPMainRightBarView nBPMainRightBarView5 = NBPMainRightBarView.this;
                                            String str = nBPMainTitleViewModel3.getCurMapTheme().f421849d;
                                            nBPMainRightBarView5.getClass();
                                            e jsonWithMainPgParams = NearbyConstKt.jsonWithMainPgParams();
                                            DataCardKt$DataCard$3$1$1$1$1$1$1$$ExternalSyntheticOutline0.m("jumpChooseThemePage schema:", str, kLog, "NBPChooseThemePage");
                                            QQNearbyModule companion = QQNearbyModule.Companion.getInstance();
                                            encodeToByteArray = StringsKt__StringsJVMKt.encodeToByteArray(jsonWithMainPgParams.toString());
                                            companion.setSharePenetratePageData(new byte[][]{encodeToByteArray});
                                            QQKuiklyPlatformApi.Companion companion2 = QQKuiklyPlatformApi.Companion;
                                            QQKuiklyPlatformApi.Companion.openPage$default("mqqapi://kuikly/open?target=52&channel=2&version=1&src_type=app&modal_mode=1&page_name=nearbypro_choose_theme&theme_id=" + str + "&custom_back_pressed=1", false, 6);
                                            e jsonWithMainPgParams2 = NearbyConstKt.jsonWithMainPgParams();
                                            jsonWithMainPgParams2.v("dt_eid", "em_nearby_switch_map_en");
                                            jsonWithMainPgParams2.v(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
                                            Utils.INSTANCE.currentBridgeModule().reportCustomDtEvent("dt_clck", jsonWithMainPgParams2);
                                        }
                                        return Unit.INSTANCE;
                                    }
                                });
                                VisibilityEventKt.b(uVar2, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.rightBar.NBPMainRightBarView.body.1.3.3.2
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(Object obj) {
                                        e jsonWithMainPgParamsImp = NearbyConstKt.jsonWithMainPgParamsImp();
                                        jsonWithMainPgParamsImp.v("dt_eid", "em_nearby_switch_map_en");
                                        jsonWithMainPgParamsImp.v(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
                                        Utils.INSTANCE.currentBridgeModule().reportCustomDtEvent("dt_imp", jsonWithMainPgParamsImp);
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final NBPMainRightBarView nBPMainRightBarView3 = NBPMainRightBarView.this;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.rightBar.NBPMainRightBarView$body$1.4
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.rightBar.NBPMainRightBarView.body.1.4.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.size(36.0f, 36.0f);
                                tVar2.marginTop(12.0f);
                                tVar2.borderRadius(18.0f);
                                h.Companion companion = h.INSTANCE;
                                tVar2.mo113backgroundColor(companion.m());
                                tVar2.boxShadow(new g(0.0f, 2.25f, 6.75f, companion.a(0.12f)), true);
                                tVar2.allCenter();
                                tVar2.accessibility("\u6e05\u9664\u4f4d\u7f6e");
                                tVar2.accessibilityRole(AccessibilityRole.BUTTON);
                                return Unit.INSTANCE;
                            }
                        });
                        ah.a(vVar2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.rightBar.NBPMainRightBarView.body.1.4.2
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ImageView imageView) {
                                imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.rightBar.NBPMainRightBarView.body.1.4.2.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(af afVar) {
                                        af afVar2 = afVar;
                                        afVar2.size(18.0f, 18.0f);
                                        b.a.b(afVar2, "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAADYAAAA2CAMAAAC7m5rvAAAAQlBMVEUAAAAwMDUvMDMvMDMwMDQvMDMwMDQvMDIvMDMwMDQwMDIwMDQvMDMwMDMuMDMuMDIwMDMwMDQvMDMwMDMvMDMvMDMzfSXtAAAAFXRSTlMAIN/vEJ9AcM+AYDC/kI9/UL+vsF+8t1hVAAABc0lEQVRIx+WV2ZKDIBBF2Vc16oT//9UpW6jUDH0lVuUt95H20AsXFF8n4/xirY0p34DcpEuTsu49yDemKbwByqn0snJAPXXhpK65R/1Mb36V0q1xawt5TOloXkXbIbeeX8wVaqDq6uTivgtEWp8AdpaThACc55NRLLKxidozMFkAZtOUDiZDfUfUXToCP9DbGmy6H+urQJpBlbSdgZgjb/ZVHMubgDL8wPJla4MiPonJkKvTrelisEinq40d52dyOUN5mkVzunL/wgGc50zuWYQ578fKhSOycfEL73QHnExpmnZgE8dwWTdKmRsmF6lSWkKTJ+BjbPQIr/ByYv7iTln8epbMcp5iz27Go8d54hqXilYLfmqk7sfc3NHcgsuc+nFEKgWOpd8zHRXsLa3K/DQDcY+/vSlT3bKZyx9B4wwt7bImngWU1C/OhEW8q1y5s+IAyoLOXaRCR4w57AysVQNq2N+YwucAzmnEzeK+kk3iK/UL5ggrfJtElvEAAAAASUVORK5CYII=", false, 2, null);
                                        afVar2.o();
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final NBPMainRightBarView nBPMainRightBarView4 = NBPMainRightBarView.this;
                        vVar2.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.rightBar.NBPMainRightBarView.body.1.4.3
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(u uVar) {
                                u uVar2 = uVar;
                                final NBPMainRightBarView nBPMainRightBarView5 = NBPMainRightBarView.this;
                                uVar2.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.rightBar.NBPMainRightBarView.body.1.4.3.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ClickParams clickParams) {
                                        if (!NBPMainRightBarView.this.fastClickUtils.isFastDoubleClick()) {
                                            NBPMainRightBarView.this.getControlViewModel().setShowDeletePositionActionSheet(true);
                                            e jsonWithMainPgParams = NearbyConstKt.jsonWithMainPgParams();
                                            jsonWithMainPgParams.v("dt_eid", "em_nearby_location_clear_icon");
                                            jsonWithMainPgParams.v(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
                                            Utils.INSTANCE.currentBridgeModule().reportCustomDtEvent("dt_clck", jsonWithMainPgParams);
                                        }
                                        return Unit.INSTANCE;
                                    }
                                });
                                VisibilityEventKt.b(uVar2, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.rightBar.NBPMainRightBarView.body.1.4.3.2
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(Object obj) {
                                        e jsonWithMainPgParamsImp = NearbyConstKt.jsonWithMainPgParamsImp();
                                        jsonWithMainPgParamsImp.v("dt_eid", "em_nearby_location_clear_icon");
                                        jsonWithMainPgParamsImp.v(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
                                        Utils.INSTANCE.currentBridgeModule().reportCustomDtEvent("dt_imp", jsonWithMainPgParamsImp);
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final NBPPendantViewModel nBPPendantViewModel3 = nBPPendantViewModel;
                Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.rightBar.NBPMainRightBarView$body$1.5
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        NBPPendantViewModel nBPPendantViewModel4 = NBPPendantViewModel.this;
                        return Boolean.valueOf(((Boolean) nBPPendantViewModel4.showLandMark$delegate.getValue(nBPPendantViewModel4, NBPPendantViewModel.$$delegatedProperties[2])).booleanValue());
                    }
                };
                final NBPMainRightBarView nBPMainRightBarView4 = NBPMainRightBarView.this;
                final NBPPendantViewModel nBPPendantViewModel4 = nBPPendantViewModel2;
                ConditionViewKt.c(viewContainer2, function0, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.rightBar.NBPMainRightBarView$body$1.6
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ConditionView conditionView) {
                        final NBPMainRightBarView nBPMainRightBarView5 = NBPMainRightBarView.this;
                        final NBPPendantViewModel nBPPendantViewModel5 = nBPPendantViewModel4;
                        w.a(conditionView, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.rightBar.NBPMainRightBarView.body.1.6.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar) {
                                v vVar2 = vVar;
                                vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.rightBar.NBPMainRightBarView.body.1.6.1.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.size(36.0f, 36.0f);
                                        tVar2.marginTop(12.0f);
                                        tVar2.borderRadius(18.0f);
                                        h.Companion companion = h.INSTANCE;
                                        tVar2.mo113backgroundColor(companion.m());
                                        tVar2.boxShadow(new g(0.0f, 2.25f, 6.75f, companion.a(0.12f)), true);
                                        tVar2.allCenter();
                                        tVar2.accessibility("\u9644\u8fd1\u5730\u5757\u5165\u53e3");
                                        tVar2.accessibilityRole(AccessibilityRole.BUTTON);
                                        return Unit.INSTANCE;
                                    }
                                });
                                ah.a(vVar2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.rightBar.NBPMainRightBarView.body.1.6.1.2
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ImageView imageView) {
                                        imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.rightBar.NBPMainRightBarView.body.1.6.1.2.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(af afVar) {
                                                af afVar2 = afVar;
                                                afVar2.size(18.0f, 18.0f);
                                                b.a.b(afVar2, "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAADwAAAA9CAMAAADGfvrlAAAAM1BMVEUAAAAuMDIvMDIwMDAwMDAuMDIvMDMuMDMuMDIvMDMwMDQuMDIvMDIvMDMwMDMuMDMvMDPJmv//AAAAEHRSTlMAgN8gEJ/vkG+/QGDPUDCvyZZApQAAAXJJREFUSMftlduWgyAMRQ1XAVH+/2tnNCLDqVLp03Qt91MFcztJ7PDw8F2oONLo1Sems0uMlt22YypQp61Nf7FdtpRqxg5bySZGkxb8c85XfhWxaaw5WVWScHwR2ZcIjR6xTFX57OiGhn7zfrgy62MEJcZmm3RdxMhKFGRLa4LHrISjhRXpizxln7YqC4hbn46h3hT+bQ8LdwjaVNtWA6MujRFX2qG4UzpnYLO76XKj0obQpE3Rlt0s5LK7lmSwV9iqjq3qWNOLaaK7Ky51YtxcDsO+GHF4h1rXL+7trlfyn+LtZFLGOOtZBnImn0CnKlkQEYqCrS+ynNIZwuDBfBLWpJuY+XUd7yMU5LzHdaGUNIclxyK5n4iz5dgnyKMOfD6hMLIqmN9Rr9PGLwdIkTAwl4IovoLNcfDBhlzgztd/SQa3eGl9mxC8D1dzlwCIbDb96RybAOhV6kTIKnIPxqqGJu08ESne59kgUoughoeHj/gBdbQ3kV3BELcAAAAASUVORK5CYII=", false, 2, null);
                                                afVar2.o();
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPMainRightBarView nBPMainRightBarView6 = NBPMainRightBarView.this;
                                final NBPPendantViewModel nBPPendantViewModel6 = nBPPendantViewModel5;
                                vVar2.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.rightBar.NBPMainRightBarView.body.1.6.1.3
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(u uVar) {
                                        final NBPMainRightBarView nBPMainRightBarView7 = NBPMainRightBarView.this;
                                        final NBPPendantViewModel nBPPendantViewModel7 = nBPPendantViewModel6;
                                        uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.rightBar.NBPMainRightBarView.body.1.6.1.3.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ClickParams clickParams) {
                                                Object firstOrNull;
                                                String str;
                                                if (!NBPMainRightBarView.this.fastClickUtils.isFastDoubleClick()) {
                                                    NBPPendantViewModel nBPPendantViewModel8 = nBPPendantViewModel7;
                                                    nBPPendantViewModel8.getClass();
                                                    KLog kLog = KLog.INSTANCE;
                                                    StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("onPendantIconClick+++areaInfo: +");
                                                    m3.append(nBPPendantViewModel8.areaInfo);
                                                    m3.append('+');
                                                    kLog.i("NBPPendantViewModel", m3.toString());
                                                    a aVar = nBPPendantViewModel8.areaInfo;
                                                    if (aVar != null) {
                                                        int i3 = aVar.f421830d;
                                                        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) aVar.f421833h);
                                                        o25.b bVar = (o25.b) firstOrNull;
                                                        if (bVar == null || (str = bVar.f421837f) == null) {
                                                            str = "";
                                                        }
                                                        if (str.length() > 0) {
                                                            str = ((d) c.f117352a.g().acquireModule("KRCodecModule")).urlEncode(str);
                                                        }
                                                        String landMarkScheme = NBPSchemeGeneratorKt.getLandMarkScheme(i3, "", str);
                                                        DataCardKt$DataCard$3$1$1$1$1$1$1$$ExternalSyntheticOutline0.m("onPendantIconClick: ", landMarkScheme, kLog, "NBPPendantViewModel");
                                                        QQNearbyModule.Companion.getInstance().launchZPlanScheme(landMarkScheme);
                                                        e jsonWithMainPgParams = NearbyConstKt.jsonWithMainPgParams();
                                                        jsonWithMainPgParams.v("dt_eid", "em_nearby_square_en");
                                                        jsonWithMainPgParams.v(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
                                                        Utils.INSTANCE.currentBridgeModule().reportCustomDtEvent("dt_clck", jsonWithMainPgParams);
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
                final NBPPendantViewModel nBPPendantViewModel5 = nBPPendantViewModel;
                Function0<Object> function02 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.rightBar.NBPMainRightBarView$body$1.7
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        NBPPendantViewModel nBPPendantViewModel6 = NBPPendantViewModel.this;
                        return Boolean.valueOf(((Boolean) nBPPendantViewModel6.showPrayCalendar$delegate.getValue(nBPPendantViewModel6, NBPPendantViewModel.$$delegatedProperties[8])).booleanValue());
                    }
                };
                final NBPPendantViewModel nBPPendantViewModel6 = nBPPendantViewModel;
                final NBPMainRightBarView nBPMainRightBarView5 = NBPMainRightBarView.this;
                ConditionViewKt.c(viewContainer2, function02, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.rightBar.NBPMainRightBarView$body$1.8
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ConditionView conditionView) {
                        ConditionView conditionView2 = conditionView;
                        final NBPPendantViewModel nBPPendantViewModel7 = NBPPendantViewModel.this;
                        final NBPMainRightBarView nBPMainRightBarView6 = nBPMainRightBarView5;
                        w.a(conditionView2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.rightBar.NBPMainRightBarView.body.1.8.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar) {
                                v vVar2 = vVar;
                                vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.rightBar.NBPMainRightBarView.body.1.8.1.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.size(36.0f, 36.0f);
                                        tVar2.marginTop(12.0f);
                                        tVar2.borderRadius(18.0f);
                                        h.Companion companion = h.INSTANCE;
                                        tVar2.mo113backgroundColor(companion.m());
                                        tVar2.boxShadow(new g(0.0f, 2.25f, 6.75f, companion.a(0.12f)), true);
                                        tVar2.allCenter();
                                        tVar2.accessibility("\u7948\u798f\u65e5\u5386");
                                        tVar2.accessibilityRole(AccessibilityRole.BUTTON);
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPPendantViewModel nBPPendantViewModel8 = NBPPendantViewModel.this;
                                Function0<Object> function03 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.rightBar.NBPMainRightBarView.body.1.8.1.2
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return Boolean.valueOf(!NBPPendantViewModel.this.canShowPrayCalendarAnimation());
                                    }
                                };
                                final NBPPendantViewModel nBPPendantViewModel9 = NBPPendantViewModel.this;
                                ConditionViewKt.c(vVar2, function03, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.rightBar.NBPMainRightBarView.body.1.8.1.3
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ConditionView conditionView3) {
                                        final NBPPendantViewModel nBPPendantViewModel10 = NBPPendantViewModel.this;
                                        ah.a(conditionView3, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.rightBar.NBPMainRightBarView.body.1.8.1.3.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ImageView imageView) {
                                                final NBPPendantViewModel nBPPendantViewModel11 = NBPPendantViewModel.this;
                                                imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.rightBar.NBPMainRightBarView.body.1.8.1.3.1.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(af afVar) {
                                                        af afVar2 = afVar;
                                                        afVar2.size(18.0f, 18.0f);
                                                        if (NBPPendantViewModel.this.isPrayCalendarSignIn()) {
                                                            b.a.b(afVar2, "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_hIDlejcnUI-.png", false, 2, null);
                                                        } else {
                                                            b.a.b(afVar2, "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_8_5C9sgfdkL.png", false, 2, null);
                                                        }
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
                                final NBPMainRightBarView nBPMainRightBarView7 = nBPMainRightBarView6;
                                final NBPPendantViewModel nBPPendantViewModel10 = NBPPendantViewModel.this;
                                vVar2.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.rightBar.NBPMainRightBarView.body.1.8.1.4
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(u uVar) {
                                        final NBPMainRightBarView nBPMainRightBarView8 = NBPMainRightBarView.this;
                                        final NBPPendantViewModel nBPPendantViewModel11 = nBPPendantViewModel10;
                                        uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.rightBar.NBPMainRightBarView.body.1.8.1.4.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ClickParams clickParams) {
                                                if (!NBPMainRightBarView.this.fastClickUtils.isFastDoubleClick()) {
                                                    NBPPendantViewModel nBPPendantViewModel12 = nBPPendantViewModel11;
                                                    if (((Boolean) nBPPendantViewModel12.showPrayCalendarTips$delegate.getValue(nBPPendantViewModel12, NBPPendantViewModel.$$delegatedProperties[9])).booleanValue()) {
                                                        nBPPendantViewModel11.setShowPrayCalendarTips(false);
                                                        NearbyProUtilsKt.setPrayCalendarTips(true);
                                                    }
                                                    NBPPendantViewModel nBPPendantViewModel13 = nBPPendantViewModel11;
                                                    nBPPendantViewModel13.getClass();
                                                    KLog.INSTANCE.i("NBPPendantViewModel", "onPrayCalendarIconClick");
                                                    NBPJumpUtil.jumpPrayCalendarPage$default();
                                                    e jsonWithMainPgParams = NearbyConstKt.jsonWithMainPgParams();
                                                    jsonWithMainPgParams.v("dt_eid", "em_nearby_luck_card_calendar_en");
                                                    jsonWithMainPgParams.t("clockin_state", nBPPendantViewModel13.isPrayCalendarSignIn() ? 1 : 2);
                                                    jsonWithMainPgParams.v(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
                                                    Utils.INSTANCE.currentBridgeModule().reportCustomDtEvent("dt_clck", jsonWithMainPgParams);
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
                        final NBPPendantViewModel nBPPendantViewModel8 = NBPPendantViewModel.this;
                        ConditionViewKt.c(conditionView2, new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.rightBar.NBPMainRightBarView.body.1.8.2
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Boolean.valueOf(NBPPendantViewModel.this.canShowPrayCalendarAnimation());
                            }
                        }, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.rightBar.NBPMainRightBarView.body.1.8.3
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ConditionView conditionView3) {
                                APNGViewKt.APNG(conditionView3, new Function1<APNGVView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.rightBar.NBPMainRightBarView.body.1.8.3.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(APNGVView aPNGVView) {
                                        aPNGVView.attr(new Function1<APNGAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.rightBar.NBPMainRightBarView.body.1.8.3.1.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(APNGAttr aPNGAttr) {
                                                APNGAttr aPNGAttr2 = aPNGAttr;
                                                aPNGAttr2.with("src", "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_JwVhZzUfitH.png");
                                                aPNGAttr2.repeatCount(0);
                                                aPNGAttr2.marginTop(-66.5f);
                                                aPNGAttr2.size(43.5f, 75.0f);
                                                aPNGAttr2.m151touchEnable(false);
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
                final NBPPendantViewModel nBPPendantViewModel7 = nBPPendantViewModel;
                Function0<Object> function03 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.rightBar.NBPMainRightBarView$body$1.9
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        NBPPendantViewModel nBPPendantViewModel8 = NBPPendantViewModel.this;
                        return Boolean.valueOf(((Boolean) nBPPendantViewModel8.showActivityIcon$delegate.getValue(nBPPendantViewModel8, NBPPendantViewModel.$$delegatedProperties[0])).booleanValue());
                    }
                };
                final NBPPendantViewModel nBPPendantViewModel8 = nBPPendantViewModel;
                final NBPMainRightBarView nBPMainRightBarView6 = NBPMainRightBarView.this;
                ConditionViewKt.c(viewContainer2, function03, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.rightBar.NBPMainRightBarView$body$1.10
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ConditionView conditionView) {
                        final NBPPendantViewModel nBPPendantViewModel9 = NBPPendantViewModel.this;
                        final NBPMainRightBarView nBPMainRightBarView7 = nBPMainRightBarView6;
                        ah.a(conditionView, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.rightBar.NBPMainRightBarView.body.1.10.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ImageView imageView) {
                                ImageView imageView2 = imageView;
                                final NBPPendantViewModel nBPPendantViewModel10 = NBPPendantViewModel.this;
                                imageView2.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.rightBar.NBPMainRightBarView.body.1.10.1.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(af afVar) {
                                        af afVar2 = afVar;
                                        afVar2.size(36.0f, 36.0f);
                                        afVar2.marginTop(12.0f);
                                        NBPPendantViewModel nBPPendantViewModel11 = NBPPendantViewModel.this;
                                        b.a.b(afVar2, (String) nBPPendantViewModel11.activityIconUrl$delegate.getValue(nBPPendantViewModel11, NBPPendantViewModel.$$delegatedProperties[1]), false, 2, null);
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPMainRightBarView nBPMainRightBarView8 = nBPMainRightBarView7;
                                final NBPPendantViewModel nBPPendantViewModel11 = NBPPendantViewModel.this;
                                imageView2.event(new Function1<ImageEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.rightBar.NBPMainRightBarView.body.1.10.1.2
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ImageEvent imageEvent) {
                                        final NBPMainRightBarView nBPMainRightBarView9 = NBPMainRightBarView.this;
                                        final NBPPendantViewModel nBPPendantViewModel12 = nBPPendantViewModel11;
                                        imageEvent.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.rightBar.NBPMainRightBarView.body.1.10.1.2.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ClickParams clickParams) {
                                                if (!NBPMainRightBarView.this.fastClickUtils.isFastDoubleClick()) {
                                                    NBPPendantViewModel nBPPendantViewModel13 = nBPPendantViewModel12;
                                                    nBPPendantViewModel13.getClass();
                                                    AdelieCategoryHomePage$$ExternalSyntheticOutline1.m(BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("onActivityIconClick: "), nBPPendantViewModel13.activityJumpUrl, KLog.INSTANCE, "NBPPendantViewModel");
                                                    if (nBPPendantViewModel13.activityJumpUrl.length() > 0) {
                                                        QQNearbyModule.Companion.getInstance().launchZPlanScheme(nBPPendantViewModel13.activityJumpUrl);
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
                final NBPMainRightBarView nBPMainRightBarView7 = NBPMainRightBarView.this;
                Function0<Object> function04 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.rightBar.NBPMainRightBarView$body$1.11
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        NBPMainControlViewModel controlViewModel = NBPMainRightBarView.this.getControlViewModel();
                        return Boolean.valueOf(((Boolean) controlViewModel.showDeletePositionActionSheet$delegate.getValue(controlViewModel, NBPMainControlViewModel.$$delegatedProperties[1])).booleanValue());
                    }
                };
                final NBPMainRightBarView nBPMainRightBarView8 = NBPMainRightBarView.this;
                ConditionViewKt.c(viewContainer2, function04, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.rightBar.NBPMainRightBarView$body$1.12
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ConditionView conditionView) {
                        final NBPMainRightBarView nBPMainRightBarView9 = NBPMainRightBarView.this;
                        bb.b(conditionView, false, new Function1<ModalView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.rightBar.NBPMainRightBarView.body.1.12.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ModalView modalView) {
                                final NBPMainRightBarView nBPMainRightBarView10 = NBPMainRightBarView.this;
                                modalView.addChild(new NBPDeletePositionView(), new Function1<NBPDeletePositionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.rightBar.NBPMainRightBarView.body.1.12.1.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(NBPDeletePositionView nBPDeletePositionView) {
                                        final NBPMainRightBarView nBPMainRightBarView11 = NBPMainRightBarView.this;
                                        nBPDeletePositionView.event(new Function1<NBPDeletePositionViewEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.rightBar.NBPMainRightBarView.body.1.12.1.1.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(NBPDeletePositionViewEvent nBPDeletePositionViewEvent) {
                                                final NBPMainRightBarView nBPMainRightBarView12 = NBPMainRightBarView.this;
                                                nBPDeletePositionViewEvent.registerEvent("close", new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.rightBar.NBPMainRightBarView.body.1.12.1.1.1.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(Object obj) {
                                                        NBPMainRightBarView.this.getControlViewModel().setShowDeletePositionActionSheet(false);
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
                        }, 1, null);
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

    public final NBPMainControlViewModel getControlViewModel() {
        NBPMainControlViewModel nBPMainControlViewModel = this.controlViewModel;
        if (nBPMainControlViewModel != null) {
            return nBPMainControlViewModel;
        }
        Intrinsics.throwUninitializedPropertyAccessException("controlViewModel");
        return null;
    }
}
