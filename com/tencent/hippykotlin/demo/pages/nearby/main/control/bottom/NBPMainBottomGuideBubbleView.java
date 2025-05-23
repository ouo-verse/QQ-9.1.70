package com.tencent.hippykotlin.demo.pages.nearby.main.control.bottom;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.view.DataCardKt$DataCard$3$1$1$1$1$1$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyConstKt;
import com.tencent.hippykotlin.demo.pages.nearby.base.module.QQNearbyModule;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.CameraPosition;
import com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPJumpUtil;
import com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPMainKtxKt;
import com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPViewModelStoreKt;
import com.tencent.hippykotlin.demo.pages.nearby.main.theme.NBPMainMapTheme;
import com.tencent.hippykotlin.demo.pages.nearby.main.theme.NBPMainMapThemeViewModel;
import com.tencent.hippykotlin.demo.pages.nearby.main.theme.NBPMainThemeGuideType;
import com.tencent.hippykotlin.demo.pages.nearby.main.theme.NBPThemeAttachConfig;
import com.tencent.hippykotlin.demo.pages.nearby.main.theme.NBPThemeGuideConfig;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.Direction;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.event.FrameEventKt;
import com.tencent.kuikly.core.base.event.VisibilityEventKt;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.j;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.layout.d;
import com.tencent.kuikly.core.log.KLog;
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
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt__StringsJVMKt;
import o25.f;

/* loaded from: classes31.dex */
public final class NBPMainBottomGuideBubbleView extends ComposeView<NBPMainBottomGuideBubbleViewAttr, NBPMainBottomGuideBubbleViewEvent> {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPMainBottomGuideBubbleView.class, "positionX", "getPositionX()F", 0)};
    public final ReadWriteProperty positionX$delegate = c.a(Float.valueOf(0.0f));

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ NBPMainBottomGuideBubbleViewAttr access$getAttr(NBPMainBottomGuideBubbleView nBPMainBottomGuideBubbleView) {
        return (NBPMainBottomGuideBubbleViewAttr) nBPMainBottomGuideBubbleView.getAttr();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.bottom.NBPMainBottomGuideBubbleView$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.bottom.NBPMainBottomGuideBubbleView$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        mVar.allCenter();
                        return Unit.INSTANCE;
                    }
                });
                final NBPMainBottomGuideBubbleView nBPMainBottomGuideBubbleView = NBPMainBottomGuideBubbleView.this;
                viewContainer2.event(new Function1<Event, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.bottom.NBPMainBottomGuideBubbleView$body$1.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Event event) {
                        Event event2 = event;
                        final NBPMainBottomGuideBubbleView nBPMainBottomGuideBubbleView2 = NBPMainBottomGuideBubbleView.this;
                        event2.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.bottom.NBPMainBottomGuideBubbleView.body.1.2.1
                            {
                                super(1);
                            }

                            /* JADX WARN: Removed duplicated region for block: B:41:0x009b  */
                            /* JADX WARN: Removed duplicated region for block: B:48:0x00ea  */
                            @Override // kotlin.jvm.functions.Function1
                            /*
                                Code decompiled incorrectly, please refer to instructions dump.
                            */
                            public final Unit invoke(ClickParams clickParams) {
                                boolean z16;
                                String str;
                                byte[] encodeToByteArray;
                                boolean isBlank;
                                NBPThemeAttachConfig nBPThemeAttachConfig;
                                NBPThemeGuideConfig nBPThemeGuideConfig;
                                NBPThemeAttachConfig nBPThemeAttachConfig2;
                                NBPThemeGuideConfig nBPThemeGuideConfig2;
                                NBPMainMapThemeViewModel mapThemeVM = NBPViewModelStoreKt.getMapThemeVM(NBPMainKtxKt.getNbpVMStore(NBPMainBottomGuideBubbleView.this.getPager()));
                                NBPMainThemeGuideType themeGuideType = mapThemeVM.getThemeGuideType();
                                if (themeGuideType != null) {
                                    int ordinal = themeGuideType.ordinal();
                                    if (ordinal == 0) {
                                        NBPMainMapTheme orCreateNBPMainMapTheme = mapThemeVM.getOrCreateNBPMainMapTheme(mapThemeVM.currentThemeId);
                                        String str2 = (orCreateNBPMainMapTheme == null || (nBPThemeAttachConfig = orCreateNBPMainMapTheme.attachConfig) == null || (nBPThemeGuideConfig = nBPThemeAttachConfig.recommendGuide) == null) ? null : nBPThemeGuideConfig.themeId;
                                        if (str2 != null) {
                                            isBlank = StringsKt__StringsJVMKt.isBlank(str2);
                                            if (!isBlank) {
                                                z16 = false;
                                                if (!z16) {
                                                    f currentMapTheme = mapThemeVM.getCurrentMapTheme();
                                                    if (currentMapTheme == null || (str = currentMapTheme.f421849d) == null) {
                                                        str = mapThemeVM.currentThemeId;
                                                    }
                                                    e jsonWithMainPgParams = NearbyConstKt.jsonWithMainPgParams();
                                                    DataCardKt$DataCard$3$1$1$1$1$1$1$$ExternalSyntheticOutline0.m("jumpChooseThemePage schema:", str, KLog.INSTANCE, "NBPChooseThemePage");
                                                    QQNearbyModule companion = QQNearbyModule.Companion.getInstance();
                                                    encodeToByteArray = StringsKt__StringsJVMKt.encodeToByteArray(jsonWithMainPgParams.toString());
                                                    companion.setSharePenetratePageData(new byte[][]{encodeToByteArray});
                                                    QQKuiklyPlatformApi.Companion companion2 = QQKuiklyPlatformApi.Companion;
                                                    QQKuiklyPlatformApi.Companion.openPage$default("mqqapi://kuikly/open?target=52&channel=2&version=1&src_type=app&modal_mode=1&page_name=nearbypro_choose_theme&theme_id=" + str + "&custom_back_pressed=1", false, 6);
                                                } else {
                                                    mapThemeVM.changeMapTheme(str2, true);
                                                }
                                                mapThemeVM.reportThemeGuideClick(String.valueOf(mapThemeVM.getThemeGuideText()), 0);
                                            }
                                        }
                                        z16 = true;
                                        if (!z16) {
                                        }
                                        mapThemeVM.reportThemeGuideClick(String.valueOf(mapThemeVM.getThemeGuideText()), 0);
                                    } else if (ordinal == 1) {
                                        NBPMainMapTheme orCreateNBPMainMapTheme2 = mapThemeVM.getOrCreateNBPMainMapTheme(mapThemeVM.currentThemeId);
                                        String str3 = (orCreateNBPMainMapTheme2 == null || (nBPThemeAttachConfig2 = orCreateNBPMainMapTheme2.attachConfig) == null || (nBPThemeGuideConfig2 = nBPThemeAttachConfig2.publishGuide) == null) ? null : nBPThemeGuideConfig2.themeId;
                                        if (str3 == null || str3.length() == 0) {
                                            str3 = mapThemeVM.currentThemeId;
                                        }
                                        NBPJumpUtil nBPJumpUtil = NBPJumpUtil.INSTANCE;
                                        CameraPosition cameraPosition = mapThemeVM.curCameraPos;
                                        nBPJumpUtil.jumpPublishPage("0", cameraPosition != null ? cameraPosition.target : null, str3);
                                        mapThemeVM.reportThemeGuideClick(String.valueOf(mapThemeVM.getThemeGuideText()), 1);
                                    } else if (ordinal == 2) {
                                        mapThemeVM.changeMapTheme("", false);
                                        mapThemeVM.reportThemeGuideClick(String.valueOf(mapThemeVM.getThemeGuideText()), 2);
                                    }
                                    mapThemeVM.setThemeGuideType(null);
                                }
                                return Unit.INSTANCE;
                            }
                        });
                        final NBPMainBottomGuideBubbleView nBPMainBottomGuideBubbleView3 = NBPMainBottomGuideBubbleView.this;
                        VisibilityEventKt.b(event2, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.bottom.NBPMainBottomGuideBubbleView.body.1.2.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(Object obj) {
                                NBPMainMapThemeViewModel mapThemeVM = NBPViewModelStoreKt.getMapThemeVM(NBPMainKtxKt.getNbpVMStore(NBPMainBottomGuideBubbleView.this.getPager()));
                                NBPMainThemeGuideType themeGuideType = mapThemeVM.getThemeGuideType();
                                if (themeGuideType != null) {
                                    String themeGuideText = mapThemeVM.getThemeGuideText();
                                    int ordinal = themeGuideType.ordinal();
                                    e jsonWithMainPgParamsImp = NearbyConstKt.jsonWithMainPgParamsImp();
                                    jsonWithMainPgParamsImp.v("dt_eid", "em_nearby_guide_bubble");
                                    jsonWithMainPgParamsImp.v("nearby_bubble_id", themeGuideText);
                                    jsonWithMainPgParamsImp.t("nearby_bubble_type", ordinal);
                                    jsonWithMainPgParamsImp.v(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
                                    Utils.INSTANCE.currentBridgeModule().reportCustomDtEvent("dt_imp", jsonWithMainPgParamsImp);
                                }
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final NBPMainBottomGuideBubbleView nBPMainBottomGuideBubbleView2 = NBPMainBottomGuideBubbleView.this;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.bottom.NBPMainBottomGuideBubbleView$body$1.3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        final NBPMainBottomGuideBubbleView nBPMainBottomGuideBubbleView3 = NBPMainBottomGuideBubbleView.this;
                        vVar2.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.bottom.NBPMainBottomGuideBubbleView.body.1.3.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(u uVar) {
                                final NBPMainBottomGuideBubbleView nBPMainBottomGuideBubbleView4 = NBPMainBottomGuideBubbleView.this;
                                FrameEventKt.d(uVar, new Function1<d, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.bottom.NBPMainBottomGuideBubbleView.body.1.3.1.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(d dVar) {
                                        NBPMainBottomGuideBubbleView.this.calTrianglePosition(dVar);
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.bottom.NBPMainBottomGuideBubbleView.body.1.3.2
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                vVar3.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.bottom.NBPMainBottomGuideBubbleView.body.1.3.2.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.absolutePositionAllZero();
                                        tVar2.borderRadius(16.0f);
                                        tVar2.mo135backgroundLinearGradient(Direction.TO_TOP, new j(new h(16729458L, 1.0f), 0.0f), new j(new h(16745279L, 1.0f), 0.5f), new j(new h(16765263L, 1.0f), 1.0f));
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final NBPMainBottomGuideBubbleView nBPMainBottomGuideBubbleView4 = NBPMainBottomGuideBubbleView.this;
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.bottom.NBPMainBottomGuideBubbleView.body.1.3.3
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                v vVar4 = vVar3;
                                final NBPMainBottomGuideBubbleView nBPMainBottomGuideBubbleView5 = NBPMainBottomGuideBubbleView.this;
                                vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.bottom.NBPMainBottomGuideBubbleView.body.1.3.3.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        NBPMainBottomGuideBubbleView nBPMainBottomGuideBubbleView6 = NBPMainBottomGuideBubbleView.this;
                                        Attr.absolutePosition$default(tVar2, 0.0f, ((Number) nBPMainBottomGuideBubbleView6.positionX$delegate.getValue(nBPMainBottomGuideBubbleView6, NBPMainBottomGuideBubbleView.$$delegatedProperties[0])).floatValue() - 6.0f, -5.0f, 0.0f, 9, null);
                                        tVar2.size(12.0f, 12.0f);
                                        tVar2.mo113backgroundColor(new h(16729458L, 1.0f));
                                        tVar2.transform(new com.tencent.kuikly.core.base.t(45.0f, 0.0f, 0.0f, 6, null));
                                        tVar2.allCenter();
                                        return Unit.INSTANCE;
                                    }
                                });
                                w.a(vVar4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.bottom.NBPMainBottomGuideBubbleView.body.1.3.3.2
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar5) {
                                        vVar5.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.bottom.NBPMainBottomGuideBubbleView.body.1.3.3.2.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                t tVar2 = tVar;
                                                tVar2.mo113backgroundColor(h.INSTANCE.m());
                                                tVar2.size(9.8f, 9.8f);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final NBPMainBottomGuideBubbleView nBPMainBottomGuideBubbleView5 = NBPMainBottomGuideBubbleView.this;
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.bottom.NBPMainBottomGuideBubbleView.body.1.3.4
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                v vVar4 = vVar3;
                                vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.bottom.NBPMainBottomGuideBubbleView.body.1.3.4.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.borderRadius(16.0f);
                                        tVar2.mo113backgroundColor(h.INSTANCE.m());
                                        tVar2.flexDirectionRow();
                                        tVar2.margin(1.0f);
                                        tVar2.alignItemsCenter();
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPMainBottomGuideBubbleView nBPMainBottomGuideBubbleView6 = NBPMainBottomGuideBubbleView.this;
                                ah.a(vVar4, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.bottom.NBPMainBottomGuideBubbleView.body.1.3.4.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ImageView imageView) {
                                        final NBPMainBottomGuideBubbleView nBPMainBottomGuideBubbleView7 = NBPMainBottomGuideBubbleView.this;
                                        imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.bottom.NBPMainBottomGuideBubbleView.body.1.3.4.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(af afVar) {
                                                af afVar2 = afVar;
                                                afVar2.size(56.0f, 56.0f);
                                                afVar2.margin(8.0f);
                                                afVar2.o();
                                                b.a.b(afVar2, NBPMainBottomGuideBubbleView.access$getAttr(NBPMainBottomGuideBubbleView.this).guideLeftIcon, false, 2, null);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPMainBottomGuideBubbleView nBPMainBottomGuideBubbleView7 = NBPMainBottomGuideBubbleView.this;
                                cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.bottom.NBPMainBottomGuideBubbleView.body.1.3.4.3
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(TextView textView) {
                                        final NBPMainBottomGuideBubbleView nBPMainBottomGuideBubbleView8 = NBPMainBottomGuideBubbleView.this;
                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.bottom.NBPMainBottomGuideBubbleView.body.1.3.4.3.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ce ceVar) {
                                                ce ceVar2 = ceVar;
                                                ceVar2.fontWeight500();
                                                ce.fontSize$default(ceVar2, 16.0f, null, 2, null);
                                                ceVar2.mo153width(160.0f);
                                                ceVar2.lines(2);
                                                ceVar2.textOverFlowTail();
                                                ceVar2.color(new h(4279901214L));
                                                ceVar2.text(NBPMainBottomGuideBubbleView.access$getAttr(NBPMainBottomGuideBubbleView.this).guideText);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPMainBottomGuideBubbleView nBPMainBottomGuideBubbleView8 = NBPMainBottomGuideBubbleView.this;
                                w.a(vVar4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.bottom.NBPMainBottomGuideBubbleView.body.1.3.4.4
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar5) {
                                        v vVar6 = vVar5;
                                        vVar6.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.bottom.NBPMainBottomGuideBubbleView.body.1.3.4.4.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                t tVar2 = tVar;
                                                tVar2.size(24.0f, 24.0f);
                                                tVar2.borderRadius(12.0f);
                                                tVar2.allCenter();
                                                tVar2.marginLeft(16.0f);
                                                tVar2.marginRight(16.0f);
                                                tVar2.mo135backgroundLinearGradient(Direction.TO_TOP_RIGHT, new j(new h(16729458L, 1.0f), 0.0f), new j(new h(16745279L, 1.0f), 0.5f), new j(new h(16765263L, 1.0f), 1.0f));
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final NBPMainBottomGuideBubbleView nBPMainBottomGuideBubbleView9 = NBPMainBottomGuideBubbleView.this;
                                        ah.a(vVar6, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.bottom.NBPMainBottomGuideBubbleView.body.1.3.4.4.2
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ImageView imageView) {
                                                final NBPMainBottomGuideBubbleView nBPMainBottomGuideBubbleView10 = NBPMainBottomGuideBubbleView.this;
                                                imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.bottom.NBPMainBottomGuideBubbleView.body.1.3.4.4.2.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(af afVar) {
                                                        af afVar2 = afVar;
                                                        afVar2.size(15.0f, 15.0f);
                                                        b.a.b(afVar2, NBPMainBottomGuideBubbleView.access$getAttr(NBPMainBottomGuideBubbleView.this).guideRightIcon, false, 2, null);
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

    /* JADX WARN: Multi-variable type inference failed */
    public final void calTrianglePosition(d dVar) {
        float m3;
        float x16 = dVar.getX();
        Float f16 = ((NBPMainBottomGuideBubbleViewAttr) getAttr()).trianglePosition;
        if (f16 != null) {
            m3 = f16.floatValue();
        } else {
            m3 = getPagerData().m() / 2.0f;
        }
        this.positionX$delegate.setValue(this, $$delegatedProperties[0], Float.valueOf(m3 - x16));
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return new NBPMainBottomGuideBubbleViewAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new NBPMainBottomGuideBubbleViewEvent();
    }
}
