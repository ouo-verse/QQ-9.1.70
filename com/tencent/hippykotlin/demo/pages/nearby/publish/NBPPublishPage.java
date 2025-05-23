package com.tencent.hippykotlin.demo.pages.nearby.publish;

import c01.c;
import c45.i;
import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieAgreementConsentPage$onCreate$1$1$3$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.ECLoadingAttr;
import com.tencent.hippykotlin.demo.pages.base.ECLoadingView;
import com.tencent.hippykotlin.demo.pages.base.ECLoadingViewKt;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt;
import com.tencent.hippykotlin.demo.pages.foundation.lib.vas_report_utils.VasBusinessReportData$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyBasePager;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyConst;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyConstKt;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.NBPLatLng;
import com.tencent.hippykotlin.demo.pages.nearby.base.module.QQNearbyModule;
import com.tencent.hippykotlin.demo.pages.nearby.city_walk.view.NBPCityWalkPreviewView;
import com.tencent.hippykotlin.demo.pages.nearby.city_walk.view.NBPCityWalkPreviewViewAttr;
import com.tencent.hippykotlin.demo.pages.nearby.city_walk.view.NBPCityWalkSelectListAttr;
import com.tencent.hippykotlin.demo.pages.nearby.city_walk.view.NBPCityWalkSelectListView;
import com.tencent.hippykotlin.demo.pages.nearby.city_walk.view_model.NBPCityWalkViewModel;
import com.tencent.hippykotlin.demo.pages.nearby.module.NBPPublishBridgeModule;
import com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishAvatarAttr;
import com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishAvatarEvent;
import com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishAvatarView;
import com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishContentAttr;
import com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishContentView;
import com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishNavBarAttr;
import com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishNavBarView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.aa;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.b;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.event.FrameEventKt;
import com.tencent.kuikly.core.base.event.VisibilityEventKt;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.y;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
import com.tencent.kuikly.core.layout.d;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.module.Module;
import com.tencent.kuikly.core.module.k;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.ModalView;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.TransitionType;
import com.tencent.kuikly.core.views.TransitionView;
import com.tencent.kuikly.core.views.TransitionViewKt;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ah;
import com.tencent.kuikly.core.views.bb;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.ci;
import com.tencent.kuikly.core.views.cj;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.u;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt__StringsKt;
import x25.m;

/* loaded from: classes31.dex */
public final class NBPPublishPage extends NearbyBasePager {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPPublishPage.class, "avatarFrame", "getAvatarFrame()Lcom/tencent/kuikly/core/layout/Frame;", 0)};
    public aa<NBPPublishContentView> contentView;
    public NBPPublishViewModel viewModel;
    public NBPCityWalkViewModel viewModelCityWalk;
    public String source = "0";
    public final ReadWriteProperty avatarFrame$delegate = c.a(d.INSTANCE.a());
    public m poiData = new m(null, null, 0, null, 0, null, false, null, null, 0, null, 0, null, null, 16383, null);

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.NBPPublishPage$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<com.tencent.kuikly.core.base.m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.NBPPublishPage$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(com.tencent.kuikly.core.base.m mVar) {
                        com.tencent.kuikly.core.base.m mVar2 = mVar;
                        mVar2.alignItemsCenter();
                        mVar2.flexDirectionColumn();
                        return Unit.INSTANCE;
                    }
                });
                if (!Intrinsics.areEqual(NBPPublishPage.this.source, "0")) {
                    w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.NBPPublishPage$body$1.2
                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(v vVar) {
                            v vVar2 = vVar;
                            vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.NBPPublishPage.body.1.2.1
                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(t tVar) {
                                    t tVar2 = tVar;
                                    tVar2.flexDirectionColumn();
                                    tVar2.alignItemsCenter();
                                    tVar2.justifyContentFlexStart();
                                    tVar2.absolutePositionAllZero();
                                    return Unit.INSTANCE;
                                }
                            });
                            ah.a(vVar2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.NBPPublishPage.body.1.2.2
                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(ImageView imageView) {
                                    imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.NBPPublishPage.body.1.2.2.1
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(af afVar) {
                                            af afVar2 = afVar;
                                            afVar2.mo113backgroundColor(new h(4293654778L));
                                            b.a.b(afVar2, "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_FVPWrylFIYY.png", false, 2, null);
                                            afVar2.absolutePositionAllZero();
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    return Unit.INSTANCE;
                                }
                            });
                            ah.a(vVar2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.NBPPublishPage.body.1.2.3
                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(ImageView imageView) {
                                    imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.NBPPublishPage.body.1.2.3.1
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(af afVar) {
                                            af afVar2 = afVar;
                                            b.a.b(afVar2, "https://vfiles.gtimg.cn/wupload/xy/componenthub/zH712Wyu.png", false, 2, null);
                                            afVar2.size(200.0f, 129.0f);
                                            afVar2.marginTop((afVar2.getPagerData().l() - 362.0f) - 129.0f);
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
                final NBPPublishPage nBPPublishPage = NBPPublishPage.this;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.NBPPublishPage$body$1.3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        final NBPPublishPage nBPPublishPage2 = NBPPublishPage.this;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.NBPPublishPage.body.1.3.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.alignItemsCenter();
                                tVar2.flexDirectionColumn();
                                tVar2.m140flex(1.0f);
                                NBPCityWalkViewModel nBPCityWalkViewModel = NBPPublishPage.this.viewModelCityWalk;
                                if (nBPCityWalkViewModel == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("viewModelCityWalk");
                                    nBPCityWalkViewModel = null;
                                }
                                tVar2.m152visibility(!nBPCityWalkViewModel.isDisplay());
                                return Unit.INSTANCE;
                            }
                        });
                        final NBPPublishPage nBPPublishPage3 = NBPPublishPage.this;
                        vVar2.addChild(new NBPPublishNavBarView(), new Function1<NBPPublishNavBarView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.NBPPublishPage.body.1.3.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(NBPPublishNavBarView nBPPublishNavBarView) {
                                final NBPPublishPage nBPPublishPage4 = NBPPublishPage.this;
                                nBPPublishNavBarView.attr(new Function1<NBPPublishNavBarAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.NBPPublishPage.body.1.3.2.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(NBPPublishNavBarAttr nBPPublishNavBarAttr) {
                                        NBPPublishNavBarAttr nBPPublishNavBarAttr2 = nBPPublishNavBarAttr;
                                        nBPPublishNavBarAttr2.viewModel = NBPPublishPage.this.getViewModel();
                                        nBPPublishNavBarAttr2.m154zIndex(1);
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final NBPPublishPage nBPPublishPage4 = NBPPublishPage.this;
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.NBPPublishPage.body.1.3.3
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                v vVar4 = vVar3;
                                vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.NBPPublishPage.body.1.3.3.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.overflow(true);
                                        tVar2.m140flex(1.0f);
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPPublishPage nBPPublishPage5 = NBPPublishPage.this;
                                w.a(vVar4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.NBPPublishPage.body.1.3.3.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar5) {
                                        v vVar6 = vVar5;
                                        final NBPPublishPage nBPPublishPage6 = NBPPublishPage.this;
                                        vVar6.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.NBPPublishPage.body.1.3.3.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                t tVar2 = tVar;
                                                tVar2.m140flex(1.0f);
                                                tVar2.flexDirectionColumn();
                                                tVar2.alignItemsCenter();
                                                if (NBPPublishPage.this.getViewModel().getShowAvatarStatusPanel()) {
                                                    float l3 = NBPPublishPage.this.getPager().getPageData().l();
                                                    NBPPublishPage nBPPublishPage7 = NBPPublishPage.this;
                                                    ReadWriteProperty readWriteProperty = nBPPublishPage7.avatarFrame$delegate;
                                                    KProperty<?>[] kPropertyArr = NBPPublishPage.$$delegatedProperties;
                                                    float y16 = l3 - ((d) readWriteProperty.getValue(nBPPublishPage7, kPropertyArr[0])).getY();
                                                    NBPPublishPage nBPPublishPage8 = NBPPublishPage.this;
                                                    tVar2.transform(new y(0.0f, 0.0f, 0.0f, (((y16 - ((d) nBPPublishPage8.avatarFrame$delegate.getValue(nBPPublishPage8, kPropertyArr[0])).getHeight()) - NBPPublishPage.this.getPager().getPageData().getStatusBarHeight()) - 44.0f) - 284.0f));
                                                } else {
                                                    tVar2.transform(new y(0.0f, 0.0f, 0.0f, 0.0f));
                                                }
                                                tVar2.animate(b.Companion.h(com.tencent.kuikly.core.base.b.INSTANCE, 0.2f, null, 2, null), Boolean.valueOf(NBPPublishPage.this.getViewModel().getShowAvatarStatusPanel()));
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final NBPPublishPage nBPPublishPage7 = NBPPublishPage.this;
                                        vVar6.addChild(new NBPPublishContentView(), new Function1<NBPPublishContentView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.NBPPublishPage.body.1.3.3.2.2
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(NBPPublishContentView nBPPublishContentView) {
                                                NBPPublishContentView nBPPublishContentView2 = nBPPublishContentView;
                                                final NBPPublishPage nBPPublishPage8 = NBPPublishPage.this;
                                                nBPPublishContentView2.ref(nBPPublishContentView2, new Function1<aa<NBPPublishContentView>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.NBPPublishPage.body.1.3.3.2.2.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(aa<NBPPublishContentView> aaVar) {
                                                        NBPPublishPage.this.contentView = aaVar;
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final NBPPublishPage nBPPublishPage9 = NBPPublishPage.this;
                                                nBPPublishContentView2.attr(new Function1<NBPPublishContentAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.NBPPublishPage.body.1.3.3.2.2.2
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(NBPPublishContentAttr nBPPublishContentAttr) {
                                                        nBPPublishContentAttr.viewModel = NBPPublishPage.this.getViewModel();
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final NBPPublishPage nBPPublishPage8 = NBPPublishPage.this;
                                        vVar6.addChild(new NBPPublishAvatarView(), new Function1<NBPPublishAvatarView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.NBPPublishPage.body.1.3.3.2.3
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(NBPPublishAvatarView nBPPublishAvatarView) {
                                                NBPPublishAvatarView nBPPublishAvatarView2 = nBPPublishAvatarView;
                                                final NBPPublishPage nBPPublishPage9 = NBPPublishPage.this;
                                                nBPPublishAvatarView2.attr(new Function1<NBPPublishAvatarAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.NBPPublishPage.body.1.3.3.2.3.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(NBPPublishAvatarAttr nBPPublishAvatarAttr) {
                                                        NBPPublishAvatarAttr nBPPublishAvatarAttr2 = nBPPublishAvatarAttr;
                                                        nBPPublishAvatarAttr2.viewModel = NBPPublishPage.this.getViewModel();
                                                        NBPCityWalkViewModel nBPCityWalkViewModel = NBPPublishPage.this.viewModelCityWalk;
                                                        if (nBPCityWalkViewModel == null) {
                                                            Intrinsics.throwUninitializedPropertyAccessException("viewModelCityWalk");
                                                            nBPCityWalkViewModel = null;
                                                        }
                                                        nBPPublishAvatarAttr2.viewModelCityWalk = nBPCityWalkViewModel;
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final NBPPublishPage nBPPublishPage10 = NBPPublishPage.this;
                                                nBPPublishAvatarView2.event(new Function1<NBPPublishAvatarEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.NBPPublishPage.body.1.3.3.2.3.2
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(NBPPublishAvatarEvent nBPPublishAvatarEvent) {
                                                        final NBPPublishPage nBPPublishPage11 = NBPPublishPage.this;
                                                        FrameEventKt.d(nBPPublishAvatarEvent, new Function1<d, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.NBPPublishPage.body.1.3.3.2.3.2.1
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(d dVar) {
                                                                NBPPublishPage nBPPublishPage12 = NBPPublishPage.this;
                                                                nBPPublishPage12.avatarFrame$delegate.setValue(nBPPublishPage12, NBPPublishPage.$$delegatedProperties[0], dVar);
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final NBPPublishPage nBPPublishPage9 = NBPPublishPage.this;
                                        w.a(vVar6, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.NBPPublishPage.body.1.3.3.2.4
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(v vVar7) {
                                                v vVar8 = vVar7;
                                                vVar8.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.NBPPublishPage.body.1.3.3.2.4.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(t tVar) {
                                                        t tVar2 = tVar;
                                                        tVar2.m140flex(1.0f);
                                                        tVar2.justifyContentFlexEnd();
                                                        tVar2.paddingBottom(30.0f);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final NBPPublishPage nBPPublishPage10 = NBPPublishPage.this;
                                                w.a(vVar8, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.NBPPublishPage.body.1.3.3.2.4.2
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(v vVar9) {
                                                        v vVar10 = vVar9;
                                                        vVar10.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.NBPPublishPage.body.1.3.3.2.4.2.1
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(t tVar) {
                                                                t tVar2 = tVar;
                                                                tVar2.alignItemsCenter();
                                                                tVar2.flexDirectionRow();
                                                                tVar2.padding(2.0f);
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        cg.a(vVar10, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.NBPPublishPage.body.1.3.3.2.4.2.2
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(TextView textView) {
                                                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.NBPPublishPage.body.1.3.3.2.4.2.2.1
                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(ce ceVar) {
                                                                        ce ceVar2 = ceVar;
                                                                        ceVar2.text("\u8def\u7ebf");
                                                                        ceVar2.color(new h(4287664276L));
                                                                        ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        ah.a(vVar10, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.NBPPublishPage.body.1.3.3.2.4.2.3
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ImageView imageView) {
                                                                imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.NBPPublishPage.body.1.3.3.2.4.2.3.1
                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(af afVar) {
                                                                        af afVar2 = afVar;
                                                                        b.a.b(afVar2, "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_p7mZ5IdEDXQ.png", false, 2, null);
                                                                        afVar2.size(12.0f, 12.0f);
                                                                        afVar2.t(new h(4287664276L));
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        final NBPPublishPage nBPPublishPage11 = NBPPublishPage.this;
                                                        vVar10.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.NBPPublishPage.body.1.3.3.2.4.2.4
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(u uVar) {
                                                                u uVar2 = uVar;
                                                                final NBPPublishPage nBPPublishPage12 = NBPPublishPage.this;
                                                                uVar2.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.NBPPublishPage.body.1.3.3.2.4.2.4.1
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(ClickParams clickParams) {
                                                                        NBPCityWalkViewModel nBPCityWalkViewModel = NBPPublishPage.this.viewModelCityWalk;
                                                                        if (nBPCityWalkViewModel == null) {
                                                                            Intrinsics.throwUninitializedPropertyAccessException("viewModelCityWalk");
                                                                            nBPCityWalkViewModel = null;
                                                                        }
                                                                        nBPCityWalkViewModel.setDisplay(true);
                                                                        e jsonWithPublishPgParams = NearbyConstKt.jsonWithPublishPgParams();
                                                                        jsonWithPublishPgParams.v("dt_eid", "em_nearby_path_btn");
                                                                        jsonWithPublishPgParams.v(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
                                                                        Utils.INSTANCE.currentBridgeModule().reportCustomDtEvent("dt_clck", jsonWithPublishPgParams);
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                VisibilityEventKt.b(uVar2, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.NBPPublishPage.body.1.3.3.2.4.2.4.2
                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(Object obj) {
                                                                        e jsonWithPublishPgParams = NearbyConstKt.jsonWithPublishPgParams();
                                                                        jsonWithPublishPgParams.v("dt_eid", "em_nearby_path_btn");
                                                                        jsonWithPublishPgParams.v(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
                                                                        Utils.INSTANCE.currentBridgeModule().reportCustomDtEvent("dt_imp", jsonWithPublishPgParams);
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
                        return Unit.INSTANCE;
                    }
                });
                final NBPPublishPage nBPPublishPage2 = NBPPublishPage.this;
                viewContainer2.addChild(new NBPCityWalkSelectListView(), new Function1<NBPCityWalkSelectListView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.NBPPublishPage$body$1.4
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(NBPCityWalkSelectListView nBPCityWalkSelectListView) {
                        final NBPPublishPage nBPPublishPage3 = NBPPublishPage.this;
                        nBPCityWalkSelectListView.attr(new Function1<NBPCityWalkSelectListAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.NBPPublishPage.body.1.4.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(NBPCityWalkSelectListAttr nBPCityWalkSelectListAttr) {
                                NBPCityWalkSelectListAttr nBPCityWalkSelectListAttr2 = nBPCityWalkSelectListAttr;
                                NBPCityWalkViewModel nBPCityWalkViewModel = NBPPublishPage.this.viewModelCityWalk;
                                NBPCityWalkViewModel nBPCityWalkViewModel2 = null;
                                if (nBPCityWalkViewModel == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("viewModelCityWalk");
                                    nBPCityWalkViewModel = null;
                                }
                                nBPCityWalkSelectListAttr2.viewModel = nBPCityWalkViewModel;
                                NBPCityWalkViewModel nBPCityWalkViewModel3 = NBPPublishPage.this.viewModelCityWalk;
                                if (nBPCityWalkViewModel3 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("viewModelCityWalk");
                                } else {
                                    nBPCityWalkViewModel2 = nBPCityWalkViewModel3;
                                }
                                nBPCityWalkSelectListAttr2.m152visibility(nBPCityWalkViewModel2.isDisplay());
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final NBPPublishPage nBPPublishPage3 = NBPPublishPage.this;
                ConditionViewKt.c(viewContainer2, new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.NBPPublishPage$body$1.5
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        NBPPublishViewModel viewModel = NBPPublishPage.this.getViewModel();
                        return Boolean.valueOf(((Boolean) viewModel.isPublishing$delegate.getValue(viewModel, NBPPublishViewModel.$$delegatedProperties[10])).booleanValue());
                    }
                }, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.NBPPublishPage$body$1.6
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ConditionView conditionView) {
                        bb.b(conditionView, false, new Function1<ModalView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.NBPPublishPage.body.1.6.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ModalView modalView) {
                                ModalView modalView2 = modalView;
                                w.a(modalView2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.NBPPublishPage.body.1.6.1.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar) {
                                        v vVar2 = vVar;
                                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.NBPPublishPage.body.1.6.1.1.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                t tVar2 = tVar;
                                                tVar2.size(tVar2.getPagerData().m(), tVar2.getPagerData().l());
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        vVar2.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.NBPPublishPage.body.1.6.1.1.2
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(u uVar) {
                                                uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.NBPPublishPage.body.1.6.1.1.2.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final /* bridge */ /* synthetic */ Unit invoke(ClickParams clickParams) {
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                ECLoadingViewKt.ECLoading(modalView2, new Function1<ECLoadingView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.NBPPublishPage.body.1.6.1.2
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ECLoadingView eCLoadingView) {
                                        eCLoadingView.attr(new Function1<ECLoadingAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.NBPPublishPage.body.1.6.1.2.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ECLoadingAttr eCLoadingAttr) {
                                                ECLoadingAttr eCLoadingAttr2 = eCLoadingAttr;
                                                eCLoadingAttr2.delayShow = false;
                                                eCLoadingAttr2.setLoadingText("\u53d1\u5e03\u4e2d...");
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
                TransitionType transitionType = TransitionType.DIRECTION_FROM_RIGHT;
                final NBPPublishPage nBPPublishPage4 = NBPPublishPage.this;
                TransitionViewKt.a(viewContainer2, transitionType, new Function1<TransitionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.NBPPublishPage$body$1.7
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(TransitionView transitionView) {
                        TransitionView transitionView2 = transitionView;
                        final NBPPublishPage nBPPublishPage5 = NBPPublishPage.this;
                        transitionView2.attr(new Function1<ci, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.NBPPublishPage.body.1.7.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ci ciVar) {
                                ci ciVar2 = ciVar;
                                NBPCityWalkViewModel nBPCityWalkViewModel = NBPPublishPage.this.viewModelCityWalk;
                                if (nBPCityWalkViewModel == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("viewModelCityWalk");
                                    nBPCityWalkViewModel = null;
                                }
                                ciVar2.r(nBPCityWalkViewModel.isPreview());
                                ciVar2.absolutePositionAllZero();
                                return Unit.INSTANCE;
                            }
                        });
                        transitionView2.event(new Function1<cj, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.NBPPublishPage.body.1.7.2
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(cj cjVar) {
                                cjVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.NBPPublishPage.body.1.7.2.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final /* bridge */ /* synthetic */ Unit invoke(ClickParams clickParams) {
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final NBPPublishPage nBPPublishPage6 = NBPPublishPage.this;
                        transitionView2.addChild(new NBPCityWalkPreviewView(), new Function1<NBPCityWalkPreviewView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.NBPPublishPage.body.1.7.3
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(NBPCityWalkPreviewView nBPCityWalkPreviewView) {
                                final NBPPublishPage nBPPublishPage7 = NBPPublishPage.this;
                                nBPCityWalkPreviewView.attr(new Function1<NBPCityWalkPreviewViewAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.NBPPublishPage.body.1.7.3.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(NBPCityWalkPreviewViewAttr nBPCityWalkPreviewViewAttr) {
                                        NBPCityWalkPreviewViewAttr nBPCityWalkPreviewViewAttr2 = nBPCityWalkPreviewViewAttr;
                                        NBPCityWalkViewModel nBPCityWalkViewModel = NBPPublishPage.this.viewModelCityWalk;
                                        if (nBPCityWalkViewModel == null) {
                                            Intrinsics.throwUninitializedPropertyAccessException("viewModelCityWalk");
                                            nBPCityWalkViewModel = null;
                                        }
                                        nBPCityWalkPreviewViewAttr2.viewModel = nBPCityWalkViewModel;
                                        nBPCityWalkPreviewViewAttr2.absolutePositionAllZero();
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final NBPPublishPage nBPPublishPage5 = NBPPublishPage.this;
                viewContainer2.event(new Function1<Event, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.NBPPublishPage$body$1.8
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Event event) {
                        final NBPPublishPage nBPPublishPage6 = NBPPublishPage.this;
                        event.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.NBPPublishPage.body.1.8.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ClickParams clickParams) {
                                NBPPublishContentView b16;
                                aa<NBPPublishContentView> aaVar = NBPPublishPage.this.contentView;
                                if (aaVar != null && (b16 = aaVar.b()) != null) {
                                    b16.hideKeyboard();
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

    @Override // com.tencent.hippykotlin.demo.pages.nearby.base.NearbyBasePager, com.tencent.hippykotlin.demo.pages.base.BasePager, com.tencent.kuikly.core.pager.Pager
    public final Map<String, Module> createExternalModules() {
        Map<String, Module> mutableMap;
        mutableMap = MapsKt__MapsKt.toMutableMap(super.createExternalModules());
        if (mutableMap != null) {
            mutableMap.put("NBPPublishKuiklyModule", new NBPPublishBridgeModule());
        }
        return mutableMap;
    }

    public final String getParamKey(String str) {
        if (getPageData().getIsAndroid()) {
            return str;
        }
        String lowerCase = str.toLowerCase();
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase()");
        return lowerCase;
    }

    public final NBPPublishViewModel getViewModel() {
        NBPPublishViewModel nBPPublishViewModel = this.viewModel;
        if (nBPPublishViewModel != null) {
            return nBPPublishViewModel;
        }
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        return null;
    }

    @Override // com.tencent.kuikly.core.pager.Pager, com.tencent.kuikly.core.pager.b
    public final void onReceivePagerEvent(String str, e eVar) {
        super.onReceivePagerEvent(str, eVar);
        if (Intrinsics.areEqual(str, "onModalModeBackPressed")) {
            NBPCityWalkViewModel nBPCityWalkViewModel = this.viewModelCityWalk;
            NBPCityWalkViewModel nBPCityWalkViewModel2 = null;
            if (nBPCityWalkViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModelCityWalk");
                nBPCityWalkViewModel = null;
            }
            if (nBPCityWalkViewModel.isPreview()) {
                NBPCityWalkViewModel nBPCityWalkViewModel3 = this.viewModelCityWalk;
                if (nBPCityWalkViewModel3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModelCityWalk");
                } else {
                    nBPCityWalkViewModel2 = nBPCityWalkViewModel3;
                }
                nBPCityWalkViewModel2.setPreview(false);
                return;
            }
            NBPCityWalkViewModel nBPCityWalkViewModel4 = this.viewModelCityWalk;
            if (nBPCityWalkViewModel4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModelCityWalk");
                nBPCityWalkViewModel4 = null;
            }
            if (nBPCityWalkViewModel4.isDisplay()) {
                NBPCityWalkViewModel nBPCityWalkViewModel5 = this.viewModelCityWalk;
                if (nBPCityWalkViewModel5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModelCityWalk");
                } else {
                    nBPCityWalkViewModel2 = nBPCityWalkViewModel5;
                }
                nBPCityWalkViewModel2.setDisplay(false);
                return;
            }
            getViewModel().tryRetentionOrClose();
        }
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.BasePager, com.tencent.kuikly.core.pager.Pager
    public final void pageDidAppear() {
        super.pageDidAppear();
        if (Intrinsics.areEqual(this.source, "0")) {
            k kVar = (k) com.tencent.kuikly.core.manager.c.f117352a.g().acquireModule("KRNotifyModule");
            NearbyConst nearbyConst = NearbyConst.INSTANCE;
            e eVar = new e();
            eVar.w("nearbyData", true);
            Unit unit = Unit.INSTANCE;
            k.d(kVar, "update_map_concise_action", eVar, false, 4, null);
        }
        IPagerIdKtxKt.getBridgeModule(this).setBlackStatusBarStyle();
        if (QQNearbyModule.Companion.getInstance().hadLocationPermission()) {
            return;
        }
        KLog.INSTANCE.e("NBPPublishPage", "no location permission, close page");
        QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
        QQKuiklyPlatformApi.Companion.closePage$default();
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.BasePager, com.tencent.kuikly.core.pager.Pager
    public final void pageWillDestroy() {
        super.pageWillDestroy();
        AdelieAgreementConsentPage$onCreate$1$1$3$$ExternalSyntheticOutline0.m(IPagerIdKtxKt.getNotifyModule(this), "NBPNotifyPublishCloseEvent", false, 4, null);
        if (Intrinsics.areEqual(this.source, "0") && !getViewModel().isEnterDetailPage) {
            k kVar = (k) com.tencent.kuikly.core.manager.c.f117352a.g().acquireModule("KRNotifyModule");
            NearbyConst nearbyConst = NearbyConst.INSTANCE;
            e eVar = new e();
            eVar.w("nearbyData", false);
            Unit unit = Unit.INSTANCE;
            k.d(kVar, "update_map_concise_action", eVar, false, 4, null);
        }
        customDtReportPageExposure(false);
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final void viewDidLoad() {
        super.viewDidLoad();
        k.d(IPagerIdKtxKt.getNotifyModule(this), "NBPNotifyPublishAppearEvent", new e(), false, 4, null);
        customDtReportPageExposure(true);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.BasePager, com.tencent.kuikly.core.base.ComposeView
    public final void created() {
        List emptyList;
        NBPLatLng nBPLatLng;
        m mVar;
        p35.af afVar;
        p35.af afVar2;
        super.created();
        this.source = getPageData().n().q("source", "0");
        String q16 = getPageData().n().q(getParamKey("topicIds"), "");
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        if (q16.length() > 0) {
            emptyList = StringsKt__StringsKt.split$default((CharSequence) Utils.INSTANCE.currentBridgeModule().urlDecode(q16), new String[]{"|"}, false, 0, 6, (Object) null);
        }
        List list = emptyList;
        String q17 = getPageData().n().q(getParamKey("cameraPosTarget"), "");
        if (q17.length() > 0) {
            e eVar = new e(q17);
            nBPLatLng = new NBPLatLng(eVar.i(QCircleSchemeAttr.Polymerize.LAT, 0.0d), eVar.i("lon", 0.0d));
        } else {
            nBPLatLng = null;
        }
        try {
            if (Intrinsics.areEqual(this.source, "5")) {
                try {
                    QQNearbyModule.Companion companion = QQNearbyModule.Companion;
                    Object[] sharePenetratePageData = companion.getInstance().getSharePenetratePageData();
                    Object firstOrNull = sharePenetratePageData != null ? ArraysKt___ArraysKt.firstOrNull(sharePenetratePageData) : null;
                    byte[] bArr = firstOrNull instanceof byte[] ? (byte[]) firstOrNull : null;
                    mVar = bArr != null ? (m) i.b(new m(null, null, 0L, null, 0L, null, false, null, null, 0L, null, 0, null, null, 16383, null), bArr) : null;
                    companion.getInstance().setSharePenetratePageData(new byte[0]);
                } catch (Exception e16) {
                    KLog.INSTANCE.e("NBPPublishPage", "\u89e3\u6790\u9875\u9762poiData\u6570\u636e\u5931\u8d25 " + e16);
                    QQNearbyModule.Companion.getInstance().setSharePenetratePageData(new byte[0]);
                    mVar = null;
                }
                if (mVar != null) {
                    this.poiData = mVar;
                    p35.ah ahVar = mVar.f447113d;
                    double d16 = -1.0d;
                    double d17 = 1000000;
                    double d18 = ((ahVar == null || (afVar2 = ahVar.C) == null) ? -1.0d : afVar2.f425135d) / d17;
                    if (ahVar != null && (afVar = ahVar.C) != null) {
                        d16 = afVar.f425136e;
                    }
                    nBPLatLng = new NBPLatLng(d18, d16 / d17);
                }
            }
            String q18 = getPageData().n().q(getParamKey("theme_id"), "");
            this.viewModel = new NBPPublishViewModel(getPagerId(), this.source, list, nBPLatLng, this.poiData, q18);
            getPagerId();
            this.viewModelCityWalk = new NBPCityWalkViewModel(this.source, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.NBPPublishPage$created$1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final Unit invoke() {
                    NBPPublishPage.this.getViewModel().isEnterDetailPage = true;
                    return Unit.INSTANCE;
                }
            });
            NBPPublishViewModel viewModel = getViewModel();
            boolean isDetectPhotoTagEnabled = viewModel.isDetectPhotoTagEnabled();
            e eVar2 = viewModel.qqmcConfig;
            long n3 = eVar2 != null ? eVar2.n("minSoVersion") : 0L;
            e eVar3 = viewModel.qqmcConfig;
            long n16 = eVar3 != null ? eVar3.n("minModelVersion") : 0L;
            KLog kLog = KLog.INSTANCE;
            kLog.i("NBPPublishViewModel", "onPublishPageCreated: " + isDetectPhotoTagEnabled + ", " + n3 + ", " + n16);
            NBPPublishBridgeModule bridgeModule = viewModel.bridgeModule();
            bridgeModule.getClass();
            e eVar4 = new e();
            eVar4.w("detectPhotoTag", isDetectPhotoTagEnabled);
            eVar4.u("minSoVersion", n3);
            eVar4.u("minModelVersion", n16);
            Unit unit = Unit.INSTANCE;
            bridgeModule.asyncToNativeMethod("onPublishPageCreated", eVar4, (Function1<? super e, Unit>) null);
            StringBuilder m3 = VasBusinessReportData$$ExternalSyntheticOutline0.m(BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("created finished: source="), this.source, ", themeId=", q18, ", poiName=");
            p35.ah ahVar2 = this.poiData.f447113d;
            m3.append(ahVar2 != null ? ahVar2.Q : null);
            m3.append(", cameraPosTarget=");
            m3.append(nBPLatLng != null ? Double.valueOf(nBPLatLng.latitude) : null);
            m3.append(',');
            m3.append(nBPLatLng != null ? Double.valueOf(nBPLatLng.longitude) : null);
            kLog.i("NBPPublishPage", m3.toString());
        } catch (Throwable th5) {
            QQNearbyModule.Companion.getInstance().setSharePenetratePageData(new byte[0]);
            throw th5;
        }
    }

    public final void customDtReportPageExposure(boolean z16) {
        String str;
        if (z16) {
            str = "dt_pgin";
        } else {
            str = "dt_pgout";
        }
        e jsonWithPublishPgParams = NearbyConstKt.jsonWithPublishPgParams();
        jsonWithPublishPgParams.v("nearby_dynamic_publish_entrance", this.source);
        jsonWithPublishPgParams.v(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
        Utils.INSTANCE.currentBridgeModule().reportCustomDtEvent(str, jsonWithPublishPgParams);
    }
}
