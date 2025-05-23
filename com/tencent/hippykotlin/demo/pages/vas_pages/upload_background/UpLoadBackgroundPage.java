package com.tencent.hippykotlin.demo.pages.vas_pages.upload_background;

import c01.c;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.view.BotListCellKt$BotListCell$3$1$2$2$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.QToastMode;
import com.tencent.hippykotlin.demo.pages.foundation.lib.vas_report_utils.VasBusinessReportData$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.foundation.qui_component.ActionButtonParams;
import com.tencent.hippykotlin.demo.pages.foundation.qui_component.QActionSheetAttr;
import com.tencent.hippykotlin.demo.pages.foundation.qui_component.QActionSheetEvent;
import com.tencent.hippykotlin.demo.pages.foundation.qui_component.QActionSheetKt;
import com.tencent.hippykotlin.demo.pages.foundation.qui_component.QActionSheetView;
import com.tencent.hippykotlin.demo.pages.foundation.view.DynamicAttr;
import com.tencent.hippykotlin.demo.pages.foundation.view.VasDynamicView;
import com.tencent.hippykotlin.demo.pages.foundation.view.VasDynamicViewKt;
import com.tencent.hippykotlin.demo.pages.vas_base.VasBasePage;
import com.tencent.hippykotlin.demo.pages.vas_base.VasModule;
import com.tencent.hippykotlin.demo.pages.vas_base.native_api.Friends;
import com.tencent.hippykotlin.demo.pages.vas_base.native_api.INativeApi;
import com.tencent.hippykotlin.demo.pages.vas_base.pay.VasPayData;
import com.tencent.hippykotlin.demo.pages.vas_base.pay.VasPayHelper;
import com.tencent.hippykotlin.demo.pages.vas_base.report.Vas04586ReportProxy;
import com.tencent.hippykotlin.demo.pages.vas_base.views.VasNavBarAttr;
import com.tencent.hippykotlin.demo.pages.vas_base.views.VasNavigationBar;
import com.tencent.intervideo.nowproxy.customized_interface.CustomKey;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.k;
import com.tencent.kuikly.core.base.l;
import com.tencent.kuikly.core.coroutines.BuildersKt;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.module.d;
import com.tencent.kuikly.core.nvi.serialization.json.b;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.reactive.ReactiveObserver;
import com.tencent.kuikly.core.views.CanvasView;
import com.tencent.kuikly.core.views.CanvasViewKt;
import com.tencent.kuikly.core.views.ScrollerAttr;
import com.tencent.kuikly.core.views.ScrollerView;
import com.tencent.kuikly.core.views.SwitchView;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.bo;
import com.tencent.kuikly.core.views.bt;
import com.tencent.kuikly.core.views.bu;
import com.tencent.kuikly.core.views.bv;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.compose.ButtonView;
import com.tencent.kuikly.core.views.compose.a;
import com.tencent.kuikly.core.views.p;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import com.tencent.mobileqq.mini.out.webPlugins.MiniAppPlugin;
import com.tencent.qqmini.sdk.utils.MiniSDKConst;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* loaded from: classes33.dex */
public final class UpLoadBackgroundPage extends VasBasePage {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(UpLoadBackgroundPage.class, "selectedEffectItemID", "getSelectedEffectItemID()I", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(UpLoadBackgroundPage.class, "bottomButtonWords", "getBottomButtonWords()Ljava/lang/String;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(UpLoadBackgroundPage.class, "isNormalSize", "isNormalSize()Z", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(UpLoadBackgroundPage.class, "isFreeEffect", "isFreeEffect()Z", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(UpLoadBackgroundPage.class, "isSVIP", "isSVIP()Z", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(UpLoadBackgroundPage.class, "enableSelectFriends", "getEnableSelectFriends()Z", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(UpLoadBackgroundPage.class, "nickName", "getNickName()Ljava/lang/String;", 0)};
    public final ReadWriteProperty enableSelectFriends$delegate;
    public String friendListParams;
    public String friendUin;
    public float imageHeightOrigin;
    public String imageUrlEncode;
    public float imageWeightOrigin;
    public final ReadWriteProperty isFreeEffect$delegate;
    public final ReadWriteProperty isNormalSize$delegate;
    public final ReadWriteProperty isSVIP$delegate;
    public final ReadWriteProperty nickName$delegate;
    public float subImageBottom;
    public float subImageLeft;
    public float subImageRight;
    public float subImageTop;
    public int uinType;
    public boolean updateVipStatusFlag;
    public String imagePath = "";
    public final float bottomHeight = 250.0f;
    public final List<BackgroundStyleItemData> effectData = (ArrayList) new UploadBackgroundRequest().fetchEffectData();
    public final ReadWriteProperty selectedEffectItemID$delegate = c.a(0);
    public final ReadWriteProperty bottomButtonWords$delegate = c.a("\u7acb\u5373\u88c5\u626e");

    public UpLoadBackgroundPage() {
        Boolean bool = Boolean.TRUE;
        this.isNormalSize$delegate = c.a(bool);
        this.isFreeEffect$delegate = c.a(bool);
        this.isSVIP$delegate = c.a(bool);
        this.enableSelectFriends$delegate = c.a(Boolean.FALSE);
        this.nickName$delegate = c.a("");
        this.friendListParams = "";
    }

    public static final void access$batchSetBackgroundPhoto(UpLoadBackgroundPage upLoadBackgroundPage, b bVar) {
        upLoadBackgroundPage.getClass();
        com.tencent.kuikly.core.pager.b g16 = com.tencent.kuikly.core.manager.c.f117352a.g();
        Intrinsics.checkNotNull(g16, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.vas_base.VasBasePage");
        BuildersKt.b(((VasBasePage) g16).getPageScope(), null, null, new UpLoadBackgroundPage$batchSetBackgroundPhoto$1(upLoadBackgroundPage, bVar, upLoadBackgroundPage, null), 3, null);
    }

    public static final e access$getSelectImageArea(UpLoadBackgroundPage upLoadBackgroundPage) {
        upLoadBackgroundPage.getClass();
        e eVar = new e();
        UpLoadBackgroundPage$getSelectImageArea$resize$1 upLoadBackgroundPage$getSelectImageArea$resize$1 = UpLoadBackgroundPage$getSelectImageArea$resize$1.INSTANCE;
        float floatValue = ((Number) upLoadBackgroundPage$getSelectImageArea$resize$1.invoke(Float.valueOf(upLoadBackgroundPage.subImageLeft / upLoadBackgroundPage.imageWeightOrigin))).floatValue();
        float floatValue2 = ((Number) upLoadBackgroundPage$getSelectImageArea$resize$1.invoke(Float.valueOf(upLoadBackgroundPage.subImageTop / upLoadBackgroundPage.imageHeightOrigin))).floatValue();
        float floatValue3 = ((Number) upLoadBackgroundPage$getSelectImageArea$resize$1.invoke(Float.valueOf(upLoadBackgroundPage.subImageRight / upLoadBackgroundPage.imageWeightOrigin))).floatValue();
        float floatValue4 = ((Number) upLoadBackgroundPage$getSelectImageArea$resize$1.invoke(Float.valueOf(upLoadBackgroundPage.subImageBottom / upLoadBackgroundPage.imageHeightOrigin))).floatValue();
        if (floatValue + floatValue3 < 0.99f && floatValue2 + floatValue4 < 0.99f) {
            eVar.v("left", String.valueOf(floatValue));
            eVar.v("top", String.valueOf(floatValue2));
            eVar.v("right", String.valueOf(floatValue3));
            eVar.v("bottom", String.valueOf(floatValue4));
            eVar.w("isNormalSize", upLoadBackgroundPage.isNormalSize());
        } else {
            upLoadBackgroundPage.platformApi.getCoreModule().qToast("\u8bf7\u91cd\u65b0\u9009\u62e9\u88c1\u526a\u533a\u57df", QToastMode.Warning);
        }
        return eVar;
    }

    public static final boolean access$isOpenPay(UpLoadBackgroundPage upLoadBackgroundPage) {
        ReadWriteProperty readWriteProperty = upLoadBackgroundPage.isSVIP$delegate;
        KProperty<?>[] kPropertyArr = $$delegatedProperties;
        return (((Boolean) readWriteProperty.getValue(upLoadBackgroundPage, kPropertyArr[4])).booleanValue() || (upLoadBackgroundPage.isNormalSize() && ((Boolean) upLoadBackgroundPage.isFreeEffect$delegate.getValue(upLoadBackgroundPage, kPropertyArr[3])).booleanValue())) ? false : true;
    }

    public static final void access$singleSetBackgroundPhoto(UpLoadBackgroundPage upLoadBackgroundPage) {
        upLoadBackgroundPage.getClass();
        com.tencent.kuikly.core.pager.b g16 = com.tencent.kuikly.core.manager.c.f117352a.g();
        Intrinsics.checkNotNull(g16, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.vas_base.VasBasePage");
        BuildersKt.b(((VasBasePage) g16).getPageScope(), null, null, new UpLoadBackgroundPage$singleSetBackgroundPhoto$1(upLoadBackgroundPage, upLoadBackgroundPage, null), 3, null);
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.upload_background.UpLoadBackgroundPage$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                final UpLoadBackgroundPage upLoadBackgroundPage = UpLoadBackgroundPage.this;
                String str = upLoadBackgroundPage.imagePath;
                viewContainer2.addChild(new UploadBackgroundView(upLoadBackgroundPage, str), new Function1<UploadBackgroundView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.upload_background.UpLoadBackgroundPage$body$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(UploadBackgroundView uploadBackgroundView) {
                        final UpLoadBackgroundPage upLoadBackgroundPage2 = UpLoadBackgroundPage.this;
                        uploadBackgroundView.attr(new Function1<UploadBackgroundAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.upload_background.UpLoadBackgroundPage.body.1.1.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(UploadBackgroundAttr uploadBackgroundAttr) {
                                int intValue;
                                final UploadBackgroundAttr uploadBackgroundAttr2 = uploadBackgroundAttr;
                                uploadBackgroundAttr2.absolutePositionAllZero();
                                uploadBackgroundAttr2.viewWidth = uploadBackgroundAttr2.getPagerData().m();
                                float l3 = uploadBackgroundAttr2.getPagerData().l() - UpLoadBackgroundPage.this.bottomHeight;
                                uploadBackgroundAttr2.viewHeight = l3;
                                uploadBackgroundAttr2.size(uploadBackgroundAttr2.viewWidth, l3);
                                ReactiveObserver.Companion companion = ReactiveObserver.INSTANCE;
                                intValue = ((Number) r1.selectedEffectItemID$delegate.getValue(UpLoadBackgroundPage.this, UpLoadBackgroundPage.$$delegatedProperties[0])).intValue();
                                Integer valueOf = Integer.valueOf(intValue);
                                final UpLoadBackgroundPage upLoadBackgroundPage3 = UpLoadBackgroundPage.this;
                                companion.b(valueOf, new Function1<Boolean, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.upload_background.UpLoadBackgroundPage.body.1.1.1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(Boolean bool) {
                                        int intValue2;
                                        bool.booleanValue();
                                        UploadBackgroundAttr uploadBackgroundAttr3 = UploadBackgroundAttr.this;
                                        intValue2 = ((Number) r0.selectedEffectItemID$delegate.getValue(upLoadBackgroundPage3, UpLoadBackgroundPage.$$delegatedProperties[0])).intValue();
                                        uploadBackgroundAttr3.itemId$delegate.setValue(uploadBackgroundAttr3, UploadBackgroundAttr.$$delegatedProperties[0], Integer.valueOf(intValue2));
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                viewContainer2.addChild(new VasNavigationBar(), new Function1<VasNavigationBar, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.upload_background.UpLoadBackgroundPage$body$1.2
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(VasNavigationBar vasNavigationBar) {
                        vasNavigationBar.attr(new Function1<VasNavBarAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.upload_background.UpLoadBackgroundPage.body.1.2.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(VasNavBarAttr vasNavBarAttr) {
                                VasNavBarAttr vasNavBarAttr2 = vasNavBarAttr;
                                h.Companion companion = h.INSTANCE;
                                h j3 = companion.j();
                                ReadWriteProperty readWriteProperty = vasNavBarAttr2.bgColor$delegate;
                                KProperty<?>[] kPropertyArr = VasNavBarAttr.$$delegatedProperties;
                                readWriteProperty.setValue(vasNavBarAttr2, kPropertyArr[1], j3);
                                vasNavBarAttr2.textColor$delegate.setValue(vasNavBarAttr2, kPropertyArr[2], companion.m());
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final UpLoadBackgroundPage upLoadBackgroundPage2 = UpLoadBackgroundPage.this;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.upload_background.UpLoadBackgroundPage$body$1.3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        final UpLoadBackgroundPage upLoadBackgroundPage3 = UpLoadBackgroundPage.this;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.upload_background.UpLoadBackgroundPage.body.1.3.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.mo113backgroundColor(h.INSTANCE.m());
                                tVar2.absolutePosition(tVar2.getPagerData().l() - UpLoadBackgroundPage.this.bottomHeight, 0.0f, 0.0f, 0.0f);
                                return Unit.INSTANCE;
                            }
                        });
                        final UpLoadBackgroundPage upLoadBackgroundPage4 = UpLoadBackgroundPage.this;
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.upload_background.UpLoadBackgroundPage.body.1.3.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                v vVar4 = vVar3;
                                vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.upload_background.UpLoadBackgroundPage.body.1.3.2.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.flexDirectionRow();
                                        tVar2.m150top(13.0f);
                                        tVar2.m138bottom(5.0f);
                                        return Unit.INSTANCE;
                                    }
                                });
                                cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.upload_background.UpLoadBackgroundPage.body.1.3.2.2
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(TextView textView) {
                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.upload_background.UpLoadBackgroundPage.body.1.3.2.2.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ce ceVar) {
                                                ce ceVar2 = ceVar;
                                                ceVar2.marginLeft(5.0f);
                                                ceVar2.mo141height(30.0f);
                                                ceVar2.m142left(8.0f);
                                                ceVar2.fontWeight600();
                                                ceVar2.color(h.INSTANCE.b());
                                                ceVar2.text("\u5f00\u542f\u9ad8\u6e05\u80cc\u666f");
                                                ce.fontSize$default(ceVar2, 17.0f, null, 2, null);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                VasDynamicViewKt.VasDynamicImg(vVar4, new Function1<VasDynamicView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.upload_background.UpLoadBackgroundPage.body.1.3.2.3
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(VasDynamicView vasDynamicView) {
                                        vasDynamicView.attr(new Function1<DynamicAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.upload_background.UpLoadBackgroundPage.body.1.3.2.3.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(DynamicAttr dynamicAttr) {
                                                DynamicAttr dynamicAttr2 = dynamicAttr;
                                                dynamicAttr2.marginLeft(12.0f);
                                                dynamicAttr2.with("src", "https://qqvip-web.cdn-go.cn/cdn/latest/qqgxh/item-tag/5.png");
                                                dynamicAttr2.mo141height(15.0f);
                                                dynamicAttr2.mo153width(30.0f);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final UpLoadBackgroundPage upLoadBackgroundPage5 = UpLoadBackgroundPage.this;
                                bv.a(vVar4, new Function1<SwitchView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.upload_background.UpLoadBackgroundPage.body.1.3.2.4
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(SwitchView switchView) {
                                        SwitchView switchView2 = switchView;
                                        switchView2.attr(new Function1<bt, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.upload_background.UpLoadBackgroundPage.body.1.3.2.4.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(bt btVar) {
                                                bt btVar2 = btVar;
                                                btVar2.m150top(-3.0f);
                                                btVar2.marginLeft(btVar2.getPagerData().h() - 230.0f);
                                                btVar2.size(50.0f, 25.0f);
                                                btVar2.n(new h(4279876351L));
                                                btVar2.q(3.0f);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final UpLoadBackgroundPage upLoadBackgroundPage6 = UpLoadBackgroundPage.this;
                                        switchView2.event(new Function1<bu, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.upload_background.UpLoadBackgroundPage.body.1.3.2.4.2
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(bu buVar) {
                                                final UpLoadBackgroundPage upLoadBackgroundPage7 = UpLoadBackgroundPage.this;
                                                buVar.i(new Function1<Boolean, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.upload_background.UpLoadBackgroundPage.body.1.3.2.4.2.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(Boolean bool) {
                                                        boolean booleanValue = bool.booleanValue();
                                                        UpLoadBackgroundPage upLoadBackgroundPage8 = UpLoadBackgroundPage.this;
                                                        upLoadBackgroundPage8.isNormalSize$delegate.setValue(upLoadBackgroundPage8, UpLoadBackgroundPage.$$delegatedProperties[2], Boolean.valueOf(!booleanValue));
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
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.upload_background.UpLoadBackgroundPage.body.1.3.3
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                v vVar4 = vVar3;
                                vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.upload_background.UpLoadBackgroundPage.body.1.3.3.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        tVar.m150top(15.0f);
                                        return Unit.INSTANCE;
                                    }
                                });
                                CanvasViewKt.a(vVar4, new Function1<CanvasView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.upload_background.UpLoadBackgroundPage.body.1.3.3.2
                                    @Override // kotlin.jvm.functions.Function1
                                    public final /* bridge */ /* synthetic */ Unit invoke(CanvasView canvasView) {
                                        return Unit.INSTANCE;
                                    }
                                }, new Function3<p, Float, Float, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.upload_background.UpLoadBackgroundPage.body.1.3.3.3
                                    @Override // kotlin.jvm.functions.Function3
                                    public final Unit invoke(p pVar, Float f16, Float f17) {
                                        p pVar2 = pVar;
                                        float floatValue = f16.floatValue();
                                        float floatValue2 = f17.floatValue();
                                        pVar2.b();
                                        pVar2.n(h.INSTANCE.e());
                                        pVar2.j(1.0f);
                                        pVar2.k(12.0f, floatValue2);
                                        pVar2.i(floatValue - 12.0f, floatValue2);
                                        pVar2.m();
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final UpLoadBackgroundPage upLoadBackgroundPage5 = UpLoadBackgroundPage.this;
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.upload_background.UpLoadBackgroundPage.body.1.3.4
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                v vVar4 = vVar3;
                                vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.upload_background.UpLoadBackgroundPage.body.1.3.4.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        tVar.m150top(25.0f);
                                        return Unit.INSTANCE;
                                    }
                                });
                                final UpLoadBackgroundPage upLoadBackgroundPage6 = UpLoadBackgroundPage.this;
                                bo.a(vVar4, new Function1<ScrollerView<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.upload_background.UpLoadBackgroundPage.body.1.3.4.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ScrollerView<?, ?> scrollerView) {
                                        ScrollerView<?, ?> scrollerView2 = scrollerView;
                                        scrollerView2.attr(new Function1<ScrollerAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.upload_background.UpLoadBackgroundPage.body.1.3.4.2.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ScrollerAttr scrollerAttr) {
                                                ScrollerAttr scrollerAttr2 = scrollerAttr;
                                                ScrollerAttr.bouncesEnable$default(scrollerAttr2, true, false, 2, null);
                                                scrollerAttr2.flexDirectionRow();
                                                scrollerAttr2.mo141height(120.0f);
                                                scrollerAttr2.m138bottom(5.0f);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        for (final BackgroundStyleItemData backgroundStyleItemData : UpLoadBackgroundPage.this.effectData) {
                                            final UpLoadBackgroundPage upLoadBackgroundPage7 = UpLoadBackgroundPage.this;
                                            scrollerView2.addChild(new ScrollerBackGroundItem(backgroundStyleItemData), new Function1<ScrollerBackGroundItem, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.upload_background.UpLoadBackgroundPage.body.1.3.4.2.2
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(ScrollerBackGroundItem scrollerBackGroundItem) {
                                                    ScrollerBackGroundItem scrollerBackGroundItem2 = scrollerBackGroundItem;
                                                    scrollerBackGroundItem2.attr(new Function1<k, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.upload_background.UpLoadBackgroundPage.body.1.3.4.2.2.1
                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(k kVar) {
                                                            k kVar2 = kVar;
                                                            kVar2.marginLeft(3.0f);
                                                            kVar2.marginRight(3.0f);
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    final UpLoadBackgroundPage upLoadBackgroundPage8 = UpLoadBackgroundPage.this;
                                                    final BackgroundStyleItemData backgroundStyleItemData2 = backgroundStyleItemData;
                                                    scrollerBackGroundItem2.event(new Function1<l, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.upload_background.UpLoadBackgroundPage.body.1.3.4.2.2.2
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(l lVar) {
                                                            final UpLoadBackgroundPage upLoadBackgroundPage9 = UpLoadBackgroundPage.this;
                                                            final BackgroundStyleItemData backgroundStyleItemData3 = backgroundStyleItemData2;
                                                            lVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.upload_background.UpLoadBackgroundPage.body.1.3.4.2.2.2.1
                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(ClickParams clickParams) {
                                                                    UpLoadBackgroundPage upLoadBackgroundPage10 = UpLoadBackgroundPage.this;
                                                                    upLoadBackgroundPage10.selectedEffectItemID$delegate.setValue(upLoadBackgroundPage10, UpLoadBackgroundPage.$$delegatedProperties[0], Integer.valueOf(backgroundStyleItemData3.itemId));
                                                                    List<BackgroundStyleItemData> list = UpLoadBackgroundPage.this.effectData;
                                                                    BackgroundStyleItemData backgroundStyleItemData4 = backgroundStyleItemData3;
                                                                    for (BackgroundStyleItemData backgroundStyleItemData5 : list) {
                                                                        if (backgroundStyleItemData5.itemId == backgroundStyleItemData4.itemId) {
                                                                            if (!backgroundStyleItemData5.isSelected()) {
                                                                                backgroundStyleItemData5.setSelected(true);
                                                                            }
                                                                        } else if (backgroundStyleItemData5.isSelected()) {
                                                                            backgroundStyleItemData5.setSelected(false);
                                                                        }
                                                                    }
                                                                    UpLoadBackgroundPage upLoadBackgroundPage11 = UpLoadBackgroundPage.this;
                                                                    upLoadBackgroundPage11.isFreeEffect$delegate.setValue(upLoadBackgroundPage11, UpLoadBackgroundPage.$$delegatedProperties[3], Boolean.valueOf(backgroundStyleItemData3.isFree));
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
                        final UpLoadBackgroundPage upLoadBackgroundPage6 = UpLoadBackgroundPage.this;
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.upload_background.UpLoadBackgroundPage.body.1.3.5
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                v vVar4 = vVar3;
                                vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.upload_background.UpLoadBackgroundPage.body.1.3.5.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.m150top(35.0f);
                                        tVar2.mo141height(43.0f);
                                        tVar2.marginRight(15.0f);
                                        tVar2.marginLeft(15.0f);
                                        return Unit.INSTANCE;
                                    }
                                });
                                final UpLoadBackgroundPage upLoadBackgroundPage7 = UpLoadBackgroundPage.this;
                                com.tencent.kuikly.core.views.compose.c.a(vVar4, new Function1<ButtonView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.upload_background.UpLoadBackgroundPage.body.1.3.5.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ButtonView buttonView) {
                                        ButtonView buttonView2 = buttonView;
                                        final UpLoadBackgroundPage upLoadBackgroundPage8 = UpLoadBackgroundPage.this;
                                        buttonView2.attr(new Function1<a, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.upload_background.UpLoadBackgroundPage.body.1.3.5.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(a aVar) {
                                                a aVar2 = aVar;
                                                aVar2.mo141height(43.0f);
                                                aVar2.mo113backgroundColor(new h(4279876351L));
                                                final UpLoadBackgroundPage upLoadBackgroundPage9 = UpLoadBackgroundPage.this;
                                                aVar2.q(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.upload_background.UpLoadBackgroundPage.body.1.3.5.2.1.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ce ceVar) {
                                                        ce ceVar2 = ceVar;
                                                        ceVar2.color(h.INSTANCE.m());
                                                        UpLoadBackgroundPage upLoadBackgroundPage10 = UpLoadBackgroundPage.this;
                                                        ceVar2.text((String) upLoadBackgroundPage10.bottomButtonWords$delegate.getValue(upLoadBackgroundPage10, UpLoadBackgroundPage.$$delegatedProperties[1]));
                                                        ce.fontSize$default(ceVar2, 15.0f, null, 2, null);
                                                        ceVar2.fontWeight500();
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                aVar2.borderRadius(5.0f);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final UpLoadBackgroundPage upLoadBackgroundPage9 = UpLoadBackgroundPage.this;
                                        buttonView2.event(new Function1<com.tencent.kuikly.core.views.compose.b, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.upload_background.UpLoadBackgroundPage.body.1.3.5.2.2
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(com.tencent.kuikly.core.views.compose.b bVar) {
                                                final Ref.LongRef longRef = new Ref.LongRef();
                                                final UpLoadBackgroundPage upLoadBackgroundPage10 = UpLoadBackgroundPage.this;
                                                bVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.upload_background.UpLoadBackgroundPage.body.1.3.5.2.2.1

                                                    @DebugMetadata(c = "com.tencent.hippykotlin.demo.pages.vas_pages.upload_background.UpLoadBackgroundPage$body$1$3$5$2$2$1$1", f = "UploadBackgroundPage.kt", i = {}, l = {245}, m = "invokeSuspend", n = {}, s = {})
                                                    /* renamed from: com.tencent.hippykotlin.demo.pages.vas_pages.upload_background.UpLoadBackgroundPage$body$1$3$5$2$2$1$1, reason: invalid class name and collision with other inner class name */
                                                    /* loaded from: classes33.dex */
                                                    public final class C57991 extends SuspendLambda implements Function2<com.tencent.kuikly.core.coroutines.b, Continuation<? super Unit>, Object> {
                                                        public final /* synthetic */ Ref.LongRef $clickInterceptTime;
                                                        public final /* synthetic */ UpLoadBackgroundPage $ctx;
                                                        public UpLoadBackgroundPage L$0;
                                                        public int label;

                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        public C57991(UpLoadBackgroundPage upLoadBackgroundPage, Ref.LongRef longRef, Continuation<? super C57991> continuation) {
                                                            super(2, continuation);
                                                            this.$ctx = upLoadBackgroundPage;
                                                            this.$clickInterceptTime = longRef;
                                                        }

                                                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                                            return new C57991(this.$ctx, this.$clickInterceptTime, continuation);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function2
                                                        public final Object invoke(com.tencent.kuikly.core.coroutines.b bVar, Continuation<? super Unit> continuation) {
                                                            return ((C57991) create(bVar, continuation)).invokeSuspend(Unit.INSTANCE);
                                                        }

                                                        /* JADX WARN: Removed duplicated region for block: B:23:0x00b2  */
                                                        /* JADX WARN: Removed duplicated region for block: B:8:0x004a  */
                                                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                        /*
                                                            Code decompiled incorrectly, please refer to instructions dump.
                                                        */
                                                        public final Object invokeSuspend(Object obj) {
                                                            Object coroutine_suspended;
                                                            UpLoadBackgroundPage upLoadBackgroundPage;
                                                            List listOf;
                                                            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                                            int i3 = this.label;
                                                            if (i3 == 0) {
                                                                ResultKt.throwOnFailure(obj);
                                                                if (UpLoadBackgroundPage.access$isOpenPay(this.$ctx)) {
                                                                    UpLoadBackgroundPage upLoadBackgroundPage2 = this.$ctx;
                                                                    UploadBackgroundRequest uploadBackgroundRequest = new UploadBackgroundRequest();
                                                                    this.L$0 = upLoadBackgroundPage2;
                                                                    this.label = 1;
                                                                    Object isSuperVip2 = uploadBackgroundRequest.isSuperVip2(upLoadBackgroundPage2, this);
                                                                    if (isSuperVip2 == coroutine_suspended) {
                                                                        return coroutine_suspended;
                                                                    }
                                                                    upLoadBackgroundPage = upLoadBackgroundPage2;
                                                                    obj = isSuperVip2;
                                                                }
                                                                if (!UpLoadBackgroundPage.access$isOpenPay(this.$ctx)) {
                                                                    listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"svip", "vip"});
                                                                    VasPayHelper.openKuiklyPay$default(new VasPayData("mvip.n.a.gxh_gqbj", listOf, "1", new e(new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.upload_background.UpLoadBackgroundPage.body.1.3.5.2.2.1.1.1
                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        public final Unit invoke(e eVar) {
                                                                            eVar.C("traceDetail", new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.upload_background.UpLoadBackgroundPage.body.1.3.5.2.2.1.1.1.1
                                                                                @Override // kotlin.jvm.functions.Function1
                                                                                public final Unit invoke(e eVar2) {
                                                                                    e eVar3 = eVar2;
                                                                                    eVar3.z("appid", "DressVip");
                                                                                    eVar3.z("page_id", "3001004_diy_kuikly");
                                                                                    return Unit.INSTANCE;
                                                                                }
                                                                            });
                                                                            return Unit.INSTANCE;
                                                                        }
                                                                    }), 3528));
                                                                    this.$ctx.updateVipStatusFlag = true;
                                                                } else if (Intrinsics.areEqual(this.$ctx.getFrom(), "myBackgroudPage")) {
                                                                    if (this.$ctx.friendListParams.length() == 0) {
                                                                        this.$ctx.platformApi.getCoreModule().qToast(MiniSDKConst.AdConst.ERROR_MSG_PARAM_ERROR, QToastMode.Warning);
                                                                    } else {
                                                                        b bVar = new b(this.$ctx.friendListParams);
                                                                        if (bVar.c() == 0) {
                                                                            UpLoadBackgroundPage upLoadBackgroundPage3 = this.$ctx;
                                                                            upLoadBackgroundPage3.friendUin = "";
                                                                            UpLoadBackgroundPage.access$singleSetBackgroundPhoto(upLoadBackgroundPage3);
                                                                        } else {
                                                                            UpLoadBackgroundPage.access$batchSetBackgroundPhoto(this.$ctx, bVar);
                                                                        }
                                                                    }
                                                                } else {
                                                                    UpLoadBackgroundPage upLoadBackgroundPage4 = this.$ctx;
                                                                    ReadWriteProperty readWriteProperty = upLoadBackgroundPage4.enableSelectFriends$delegate;
                                                                    KProperty<?>[] kPropertyArr = UpLoadBackgroundPage.$$delegatedProperties;
                                                                    readWriteProperty.setValue(upLoadBackgroundPage4, kPropertyArr[5], Boolean.FALSE);
                                                                    UpLoadBackgroundPage upLoadBackgroundPage5 = this.$ctx;
                                                                    upLoadBackgroundPage5.enableSelectFriends$delegate.setValue(upLoadBackgroundPage5, kPropertyArr[5], Boolean.TRUE);
                                                                }
                                                                this.$clickInterceptTime.element = this.$ctx.platformApi.getCoreModule().currentTimeStamp() + 500;
                                                                return Unit.INSTANCE;
                                                            }
                                                            if (i3 == 1) {
                                                                upLoadBackgroundPage = this.L$0;
                                                                ResultKt.throwOnFailure(obj);
                                                            } else {
                                                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                                            }
                                                            upLoadBackgroundPage.isSVIP$delegate.setValue(upLoadBackgroundPage, UpLoadBackgroundPage.$$delegatedProperties[4], Boolean.valueOf(((Boolean) obj).booleanValue()));
                                                            if (!UpLoadBackgroundPage.access$isOpenPay(this.$ctx)) {
                                                            }
                                                            this.$clickInterceptTime.element = this.$ctx.platformApi.getCoreModule().currentTimeStamp() + 500;
                                                            return Unit.INSTANCE;
                                                        }
                                                    }

                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ClickParams clickParams) {
                                                        long currentTimeStamp = UpLoadBackgroundPage.this.platformApi.getCoreModule().currentTimeStamp();
                                                        Ref.LongRef longRef2 = longRef;
                                                        if (currentTimeStamp < longRef2.element) {
                                                            KLog.INSTANCE.i(UpLoadBackgroundPage.this.getPageName(), "click too quick");
                                                        } else {
                                                            longRef2.element = UpLoadBackgroundPage.this.platformApi.getCoreModule().currentTimeStamp() + 3000;
                                                            BuildersKt.e(UpLoadBackgroundPage.this.getPageScope(), null, null, new C57991(UpLoadBackgroundPage.this, longRef, null), 3, null);
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
                        final UpLoadBackgroundPage upLoadBackgroundPage7 = UpLoadBackgroundPage.this;
                        Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.upload_background.UpLoadBackgroundPage.body.1.3.6
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                UpLoadBackgroundPage upLoadBackgroundPage8 = UpLoadBackgroundPage.this;
                                return Boolean.valueOf(((Boolean) upLoadBackgroundPage8.enableSelectFriends$delegate.getValue(upLoadBackgroundPage8, UpLoadBackgroundPage.$$delegatedProperties[5])).booleanValue());
                            }
                        };
                        final UpLoadBackgroundPage upLoadBackgroundPage8 = UpLoadBackgroundPage.this;
                        ConditionViewKt.c(vVar2, function0, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.upload_background.UpLoadBackgroundPage.body.1.3.7
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ConditionView conditionView) {
                                final UpLoadBackgroundPage upLoadBackgroundPage9 = UpLoadBackgroundPage.this;
                                QActionSheetKt.QActionSheet(conditionView, new Function1<QActionSheetView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.upload_background.UpLoadBackgroundPage.body.1.3.7.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(QActionSheetView qActionSheetView) {
                                        final QActionSheetView qActionSheetView2 = qActionSheetView;
                                        qActionSheetView2.attr(new Function1<QActionSheetAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.upload_background.UpLoadBackgroundPage.body.1.3.7.1.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(QActionSheetAttr qActionSheetAttr) {
                                                qActionSheetAttr.with("title", "\u8bbe\u7f6e\u5230");
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final UpLoadBackgroundPage upLoadBackgroundPage10 = UpLoadBackgroundPage.this;
                                        qActionSheetView2.event(new Function1<QActionSheetEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.upload_background.UpLoadBackgroundPage.body.1.3.7.1.2
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(QActionSheetEvent qActionSheetEvent) {
                                                QActionSheetEvent qActionSheetEvent2 = qActionSheetEvent;
                                                final UpLoadBackgroundPage upLoadBackgroundPage11 = UpLoadBackgroundPage.this;
                                                final QActionSheetView qActionSheetView3 = qActionSheetView2;
                                                qActionSheetEvent2.onClickWithText(new Function1<ActionButtonParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.upload_background.UpLoadBackgroundPage.body.1.3.7.1.2.1

                                                    @DebugMetadata(c = "com.tencent.hippykotlin.demo.pages.vas_pages.upload_background.UpLoadBackgroundPage$body$1$3$7$1$2$1$1", f = "UploadBackgroundPage.kt", i = {}, l = {307}, m = "invokeSuspend", n = {}, s = {})
                                                    /* renamed from: com.tencent.hippykotlin.demo.pages.vas_pages.upload_background.UpLoadBackgroundPage$body$1$3$7$1$2$1$1, reason: invalid class name and collision with other inner class name */
                                                    /* loaded from: classes33.dex */
                                                    public final class C58041 extends SuspendLambda implements Function2<com.tencent.kuikly.core.coroutines.b, Continuation<? super Unit>, Object> {
                                                        public final /* synthetic */ UpLoadBackgroundPage $ctx;
                                                        public int label;

                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        public C58041(UpLoadBackgroundPage upLoadBackgroundPage, Continuation<? super C58041> continuation) {
                                                            super(2, continuation);
                                                            this.$ctx = upLoadBackgroundPage;
                                                        }

                                                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                                            return new C58041(this.$ctx, continuation);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function2
                                                        public final Object invoke(com.tencent.kuikly.core.coroutines.b bVar, Continuation<? super Unit> continuation) {
                                                            return ((C58041) create(bVar, continuation)).invokeSuspend(Unit.INSTANCE);
                                                        }

                                                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                        public final Object invokeSuspend(Object obj) {
                                                            Object coroutine_suspended;
                                                            Continuation intercepted;
                                                            Object coroutine_suspended2;
                                                            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                                            int i3 = this.label;
                                                            if (i3 == 0) {
                                                                ResultKt.throwOnFailure(obj);
                                                                Friends friends = this.$ctx.platformApi.getVasModule().getFriends();
                                                                final Friends.PanelParams panelParams = new Friends.PanelParams();
                                                                panelParams.maxNum = 100;
                                                                panelParams.overLimitTips = "\u6bcf\u6b21\u6700\u591a\u9009\u62e9100\u4e2a\u804a\u5929";
                                                                this.label = 1;
                                                                friends.getClass();
                                                                INativeApi.Companion.checkQQVersion$default();
                                                                intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(this);
                                                                final SafeContinuation safeContinuation = new SafeContinuation(intercepted);
                                                                VasModule.Companion.getInstance().toNative(false, "friendsOpenSelectFriendsPanel", new e(
                                                                /*  JADX ERROR: Method code generation error
                                                                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0064: INVOKE 
                                                                      (wrap:com.tencent.hippykotlin.demo.pages.vas_base.VasModule:0x005e: INVOKE 
                                                                      (wrap:com.tencent.hippykotlin.demo.pages.vas_base.VasModule$Companion:0x005c: SGET  A[WRAPPED] (LINE:93) com.tencent.hippykotlin.demo.pages.vas_base.VasModule.Companion com.tencent.hippykotlin.demo.pages.vas_base.VasModule$Companion)
                                                                     VIRTUAL call: com.tencent.hippykotlin.demo.pages.vas_base.VasModule.Companion.getInstance():com.tencent.hippykotlin.demo.pages.vas_base.VasModule A[MD:():com.tencent.hippykotlin.demo.pages.vas_base.VasModule (m), WRAPPED] (LINE:95))
                                                                      false
                                                                      ("friendsOpenSelectFriendsPanel")
                                                                      (wrap:java.lang.String:0x0050: INVOKE 
                                                                      (wrap:com.tencent.kuikly.core.nvi.serialization.json.e:0x004d: CONSTRUCTOR 
                                                                      (wrap:kotlin.jvm.functions.Function1<com.tencent.kuikly.core.nvi.serialization.json.e, kotlin.Unit>:0x004a: CONSTRUCTOR (r1v1 'panelParams' com.tencent.hippykotlin.demo.pages.vas_base.native_api.Friends$PanelParams A[DONT_INLINE]) A[MD:(com.tencent.hippykotlin.demo.pages.vas_base.native_api.Friends$PanelParams):void (m), WRAPPED] (LINE:75) call: com.tencent.hippykotlin.demo.pages.vas_base.native_api.Friends$PanelParams$toJson$1.<init>(com.tencent.hippykotlin.demo.pages.vas_base.native_api.Friends$PanelParams):void type: CONSTRUCTOR)
                                                                     A[MD:(kotlin.jvm.functions.Function1<? super com.tencent.kuikly.core.nvi.serialization.json.e, kotlin.Unit>):void throws com.tencent.kuikly.core.nvi.serialization.json.JSONException (m), WRAPPED] (LINE:78) call: com.tencent.kuikly.core.nvi.serialization.json.e.<init>(kotlin.jvm.functions.Function1):void type: CONSTRUCTOR)
                                                                     VIRTUAL call: com.tencent.kuikly.core.nvi.serialization.json.e.toString():java.lang.String A[MD:():java.lang.String (m), WRAPPED] (LINE:81))
                                                                      (wrap:kotlin.jvm.functions.Function1<com.tencent.kuikly.core.nvi.serialization.json.e, kotlin.Unit>:0x0056: CONSTRUCTOR (r11v5 'safeContinuation' kotlin.coroutines.SafeContinuation A[DONT_INLINE]) A[MD:(kotlin.coroutines.Continuation<? super java.util.List<com.tencent.hippykotlin.demo.pages.vas_base.native_api.Friends$FriendInfo>>):void (m), WRAPPED] (LINE:87) call: com.tencent.hippykotlin.demo.pages.vas_base.native_api.Friends$openPanel$2$1.<init>(kotlin.coroutines.Continuation):void type: CONSTRUCTOR)
                                                                      false
                                                                     VIRTUAL call: com.tencent.kuikly.core.module.Module.toNative(boolean, java.lang.String, java.lang.Object, kotlin.jvm.functions.Function1, boolean):com.tencent.kuikly.core.module.Module$b A[MD:(boolean, java.lang.String, java.lang.Object, kotlin.jvm.functions.Function1<? super com.tencent.kuikly.core.nvi.serialization.json.e, kotlin.Unit>, boolean):com.tencent.kuikly.core.module.Module$b (m)] (LINE:101) in method: com.tencent.hippykotlin.demo.pages.vas_pages.upload_background.UpLoadBackgroundPage.body.1.3.7.1.2.1.1.invokeSuspend(java.lang.Object):java.lang.Object, file: classes33.dex
                                                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
                                                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
                                                                    	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:94)
                                                                    	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                                                                    	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                                    	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:297)
                                                                    	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:276)
                                                                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:406)
                                                                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
                                                                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
                                                                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                                                                    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
                                                                    	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                                                    	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                                                                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.hippykotlin.demo.pages.vas_base.native_api.Friends$PanelParams$toJson$1, state: NOT_LOADED
                                                                    	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:304)
                                                                    	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:781)
                                                                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:730)
                                                                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:418)
                                                                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:145)
                                                                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:121)
                                                                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:108)
                                                                    	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:1117)
                                                                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:777)
                                                                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:418)
                                                                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:145)
                                                                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:121)
                                                                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:108)
                                                                    	at jadx.core.codegen.InsnGen.addArgDot(InsnGen.java:97)
                                                                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:852)
                                                                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:422)
                                                                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:145)
                                                                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:121)
                                                                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:108)
                                                                    	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:1117)
                                                                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:884)
                                                                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:422)
                                                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:303)
                                                                    	... 21 more
                                                                    */
                                                                /*
                                                                    this = this;
                                                                    java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                                                                    int r1 = r10.label
                                                                    r2 = 1
                                                                    if (r1 == 0) goto L18
                                                                    if (r1 != r2) goto Lf
                                                                    kotlin.ResultKt.throwOnFailure(r11)
                                                                    goto L77
                                                                Lf:
                                                                    java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
                                                                    java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                                                                    r11.<init>(r0)
                                                                    throw r11
                                                                L18:
                                                                    kotlin.ResultKt.throwOnFailure(r11)
                                                                    com.tencent.hippykotlin.demo.pages.vas_pages.upload_background.UpLoadBackgroundPage r11 = r10.$ctx
                                                                    com.tencent.hippykotlin.demo.pages.vas_base.VasBasePage$PlatformApi r11 = r11.platformApi
                                                                    com.tencent.hippykotlin.demo.pages.vas_base.VasModule r11 = r11.getVasModule()
                                                                    com.tencent.hippykotlin.demo.pages.vas_base.native_api.Friends r11 = r11.getFriends()
                                                                    com.tencent.hippykotlin.demo.pages.vas_base.native_api.Friends$PanelParams r1 = new com.tencent.hippykotlin.demo.pages.vas_base.native_api.Friends$PanelParams
                                                                    r1.<init>()
                                                                    r3 = 100
                                                                    r1.maxNum = r3
                                                                    java.lang.String r3 = "\u6bcf\u6b21\u6700\u591a\u9009\u62e9100\u4e2a\u804a\u5929"
                                                                    r1.overLimitTips = r3
                                                                    r10.label = r2
                                                                    r11.getClass()
                                                                    com.tencent.hippykotlin.demo.pages.vas_base.native_api.INativeApi.Companion.checkQQVersion$default()
                                                                    kotlin.coroutines.SafeContinuation r11 = new kotlin.coroutines.SafeContinuation
                                                                    kotlin.coroutines.Continuation r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.intercepted(r10)
                                                                    r11.<init>(r2)
                                                                    com.tencent.kuikly.core.nvi.serialization.json.e r2 = new com.tencent.kuikly.core.nvi.serialization.json.e
                                                                    com.tencent.hippykotlin.demo.pages.vas_base.native_api.Friends$PanelParams$toJson$1 r3 = new com.tencent.hippykotlin.demo.pages.vas_base.native_api.Friends$PanelParams$toJson$1
                                                                    r3.<init>(r1)
                                                                    r2.<init>(r3)
                                                                    java.lang.String r7 = r2.toString()
                                                                    com.tencent.hippykotlin.demo.pages.vas_base.native_api.Friends$openPanel$2$1 r8 = new com.tencent.hippykotlin.demo.pages.vas_base.native_api.Friends$openPanel$2$1
                                                                    r8.<init>(r11)
                                                                    java.lang.String r6 = "friendsOpenSelectFriendsPanel"
                                                                    com.tencent.hippykotlin.demo.pages.vas_base.VasModule$Companion r1 = com.tencent.hippykotlin.demo.pages.vas_base.VasModule.Companion
                                                                    com.tencent.hippykotlin.demo.pages.vas_base.VasModule r4 = r1.getInstance()
                                                                    r5 = 0
                                                                    r9 = 0
                                                                    r4.toNative(r5, r6, r7, r8, r9)
                                                                    java.lang.Object r11 = r11.getOrThrow()
                                                                    java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                                                                    if (r11 != r1) goto L74
                                                                    kotlin.coroutines.jvm.internal.DebugProbes.probeCoroutineSuspended(r10)
                                                                L74:
                                                                    if (r11 != r0) goto L77
                                                                    return r0
                                                                L77:
                                                                    java.util.List r11 = (java.util.List) r11
                                                                    boolean r0 = r11.isEmpty()
                                                                    if (r0 == 0) goto L82
                                                                    kotlin.Unit r11 = kotlin.Unit.INSTANCE
                                                                    return r11
                                                                L82:
                                                                    com.tencent.hippykotlin.demo.pages.vas_pages.upload_background.UpLoadBackgroundPage r0 = r10.$ctx
                                                                    java.lang.StringBuilder r1 = new java.lang.StringBuilder
                                                                    r1.<init>()
                                                                    java.lang.String r2 = "batchSetBackgroundPhoto choose "
                                                                    r1.append(r2)
                                                                    r1.append(r11)
                                                                    java.lang.String r1 = r1.toString()
                                                                    com.tencent.kuikly.core.log.KLog r2 = com.tencent.kuikly.core.log.KLog.INSTANCE
                                                                    java.lang.String r0 = r0.getPageName()
                                                                    r2.i(r0, r1)
                                                                    com.tencent.kuikly.core.nvi.serialization.json.b r0 = new com.tencent.kuikly.core.nvi.serialization.json.b
                                                                    r0.<init>()
                                                                    java.util.Iterator r11 = r11.iterator()
                                                                La8:
                                                                    boolean r1 = r11.hasNext()
                                                                    if (r1 == 0) goto Lc2
                                                                    java.lang.Object r1 = r11.next()
                                                                    com.tencent.hippykotlin.demo.pages.vas_base.native_api.Friends$FriendInfo r1 = (com.tencent.hippykotlin.demo.pages.vas_base.native_api.Friends.FriendInfo) r1
                                                                    com.tencent.kuikly.core.nvi.serialization.json.e r2 = new com.tencent.kuikly.core.nvi.serialization.json.e
                                                                    com.tencent.hippykotlin.demo.pages.vas_pages.upload_background.UpLoadBackgroundPage$body$1$3$7$1$2$1$1$1$friendInfo$1 r3 = new com.tencent.hippykotlin.demo.pages.vas_pages.upload_background.UpLoadBackgroundPage$body$1$3$7$1$2$1$1$1$friendInfo$1
                                                                    r3.<init>(r1)
                                                                    r2.<init>(r3)
                                                                    r0.t(r2)
                                                                    goto La8
                                                                Lc2:
                                                                    com.tencent.hippykotlin.demo.pages.vas_pages.upload_background.UpLoadBackgroundPage r11 = r10.$ctx
                                                                    com.tencent.hippykotlin.demo.pages.vas_pages.upload_background.UpLoadBackgroundPage.access$batchSetBackgroundPhoto(r11, r0)
                                                                    kotlin.Unit r11 = kotlin.Unit.INSTANCE
                                                                    return r11
                                                                */
                                                                throw new UnsupportedOperationException("Method not decompiled: com.tencent.hippykotlin.demo.pages.vas_pages.upload_background.UpLoadBackgroundPage$body$1.AnonymousClass3.AnonymousClass7.AnonymousClass1.AnonymousClass2.C58031.C58041.invokeSuspend(java.lang.Object):java.lang.Object");
                                                            }
                                                        }

                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(ActionButtonParams actionButtonParams) {
                                                            int i3 = actionButtonParams.index;
                                                            if (i3 == 0) {
                                                                UpLoadBackgroundPage upLoadBackgroundPage12 = UpLoadBackgroundPage.this;
                                                                upLoadBackgroundPage12.friendUin = "";
                                                                UpLoadBackgroundPage.access$singleSetBackgroundPhoto(upLoadBackgroundPage12);
                                                            } else {
                                                                if (i3 == 1) {
                                                                    String str2 = UpLoadBackgroundPage.this.friendUin;
                                                                    if (str2 == null) {
                                                                        Intrinsics.throwUninitializedPropertyAccessException("friendUin");
                                                                        str2 = null;
                                                                    }
                                                                    if (str2.length() == 0) {
                                                                        BuildersKt.e(UpLoadBackgroundPage.this.getPageScope(), null, null, new C58041(UpLoadBackgroundPage.this, null), 3, null);
                                                                    } else {
                                                                        UpLoadBackgroundPage.access$singleSetBackgroundPhoto(UpLoadBackgroundPage.this);
                                                                    }
                                                                }
                                                            }
                                                            qActionSheetView3.dismiss();
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    qActionSheetEvent2.register("onDismiss", new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.upload_background.UpLoadBackgroundPage.body.1.3.7.1.2.2
                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            qActionSheetView2.addButton("\u5168\u90e8\u804a\u5929");
                                            String str2 = UpLoadBackgroundPage.this.friendUin;
                                            if (str2 == null) {
                                                Intrinsics.throwUninitializedPropertyAccessException("friendUin");
                                                str2 = null;
                                            }
                                            if (str2.length() == 0) {
                                                qActionSheetView2.addButton("\u6307\u5b9a\u804a\u5929");
                                            } else {
                                                StringBuilder m3 = BotListCellKt$BotListCell$3$1$2$2$$ExternalSyntheticOutline0.m('\u4e0e');
                                                UpLoadBackgroundPage upLoadBackgroundPage11 = UpLoadBackgroundPage.this;
                                                m3.append((String) upLoadBackgroundPage11.nickName$delegate.getValue(upLoadBackgroundPage11, UpLoadBackgroundPage.$$delegatedProperties[6]));
                                                m3.append("\u7684\u804a\u5929");
                                                qActionSheetView2.addButton(m3.toString());
                                            }
                                            qActionSheetView2.addCancelButton();
                                            qActionSheetView2.show();
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

        public final boolean isNormalSize() {
            return ((Boolean) this.isNormalSize$delegate.getValue(this, $$delegatedProperties[2])).booleanValue();
        }

        @Override // com.tencent.hippykotlin.demo.pages.vas_base.VasBasePage, com.tencent.hippykotlin.demo.pages.base.BasePager, com.tencent.kuikly.core.pager.Pager
        public final void pageDidAppear() {
            super.pageDidAppear();
            if (this.updateVipStatusFlag) {
                this.updateVipStatusFlag = false;
                BuildersKt.e(getPageScope(), null, null, new UpLoadBackgroundPage$pageDidAppear$1(this, null), 3, null);
            }
        }

        @Override // com.tencent.hippykotlin.demo.pages.vas_base.VasBasePage, com.tencent.hippykotlin.demo.pages.base.BasePager, com.tencent.kuikly.core.base.ComposeView
        public final void created() {
            super.created();
            this.platformApi.getCoreModule().setWhiteStatusBarStyle();
            this.friendUin = getPagerData().n().q("frienduin", "");
            this.uinType = getPagerData().n().k("uintype", 0);
            this.imageUrlEncode = getPagerData().n().q(CustomKey.SHARE_IMAGE_URL, "");
            this.friendListParams = getPagerData().n().p("friendlist");
            String q16 = getPagerData().n().q("imageurlbase64", "");
            com.tencent.kuikly.core.manager.c cVar = com.tencent.kuikly.core.manager.c.f117352a;
            com.tencent.kuikly.core.pager.b g16 = cVar.g();
            Intrinsics.checkNotNull(g16, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.vas_base.VasBasePage");
            VasBasePage vasBasePage = (VasBasePage) g16;
            StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("UpLoadBackgroundPage uin:");
            String str = this.friendUin;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException("friendUin");
                str = null;
            }
            m3.append(str);
            m3.append(", uinType:");
            m3.append(this.uinType);
            m3.append(", imageUrl:");
            String str2 = this.imageUrlEncode;
            if (str2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("imageUrlEncode");
                str2 = null;
            }
            StringBuilder m16 = VasBusinessReportData$$ExternalSyntheticOutline0.m(m3, str2, ", base64:", q16, ", friendListParams:");
            m16.append(this.friendListParams);
            m16.append(", from:");
            com.tencent.kuikly.core.pager.b g17 = cVar.g();
            Intrinsics.checkNotNull(g17, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.vas_base.VasBasePage");
            m16.append(((VasBasePage) g17).getFrom());
            String sb5 = m16.toString();
            KLog kLog = KLog.INSTANCE;
            kLog.i(vasBasePage.getPageName(), sb5);
            if (q16.length() > 0) {
                this.imageUrlEncode = this.platformApi.getCodecModule().a(q16);
            }
            d codecModule = this.platformApi.getCodecModule();
            String str3 = this.imageUrlEncode;
            if (str3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("imageUrlEncode");
                str3 = null;
            }
            this.imagePath = codecModule.urlDecode(str3);
            BuildersKt.e(getPageScope(), null, null, new UpLoadBackgroundPage$created$1(this, null), 3, null);
            String str4 = this.friendUin;
            if (str4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("friendUin");
                str4 = null;
            }
            boolean z16 = this.uinType != 0;
            com.tencent.kuikly.core.pager.b g18 = cVar.g();
            Intrinsics.checkNotNull(g18, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.vas_base.VasBasePage");
            BuildersKt.b(((VasBasePage) g18).getPageScope(), null, null, new UpLoadBackgroundPage$getNickName$1(this, str4, z16, null), 3, null);
            Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.upload_background.UpLoadBackgroundPage$created$update$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(Boolean bool) {
                    String str5;
                    bool.booleanValue();
                    UpLoadBackgroundPage upLoadBackgroundPage = UpLoadBackgroundPage.this;
                    if (UpLoadBackgroundPage.access$isOpenPay(upLoadBackgroundPage)) {
                        str5 = "\u5f00\u901a\u8d85\u7ea7\u4f1a\u5458\u7acb\u5373\u88c5\u626e";
                    } else {
                        str5 = "\u7acb\u5373\u88c5\u626e";
                    }
                    upLoadBackgroundPage.bottomButtonWords$delegate.setValue(upLoadBackgroundPage, UpLoadBackgroundPage.$$delegatedProperties[1], str5);
                    return Unit.INSTANCE;
                }
            };
            ReactiveObserver.Companion companion = ReactiveObserver.INSTANCE;
            companion.b(Boolean.valueOf(isNormalSize()), function1);
            ReadWriteProperty readWriteProperty = this.isFreeEffect$delegate;
            KProperty<?>[] kPropertyArr = $$delegatedProperties;
            companion.b(Boolean.valueOf(((Boolean) readWriteProperty.getValue(this, kPropertyArr[3])).booleanValue()), function1);
            companion.b(Boolean.valueOf(((Boolean) this.isSVIP$delegate.getValue(this, kPropertyArr[4])).booleanValue()), function1);
            Function1<Map<String, String>, Unit> function12 = this.vasCommonReportImpl;
            Vas04586ReportProxy vas04586ReportProxy = new Vas04586ReportProxy(function12);
            vas04586ReportProxy.appId = "DressVip";
            vas04586ReportProxy.pageId = "3001004_diy";
            Long l3 = 100L;
            if (l3 != null) {
                vas04586ReportProxy.actionId = l3.longValue();
            }
            kLog.i("VasBaseReportProxy", vas04586ReportProxy.toString());
            HashMap hashMap = new HashMap();
            vas04586ReportProxy.recordString(hashMap, "appid", vas04586ReportProxy.appId);
            vas04586ReportProxy.recordString(hashMap, "page_id", vas04586ReportProxy.pageId);
            vas04586ReportProxy.recordString(hashMap, "module_id", "");
            vas04586ReportProxy.recordString(hashMap, "sub_module_id", "");
            vas04586ReportProxy.recordString(hashMap, "item_id", "");
            vas04586ReportProxy.recordString(hashMap, "item_type", "");
            vas04586ReportProxy.recordNum(hashMap, "action_id", vas04586ReportProxy.actionId);
            vas04586ReportProxy.recordString(hashMap, "uid", "");
            vas04586ReportProxy.recordString(hashMap, "to_uid", "");
            vas04586ReportProxy.recordString(hashMap, QCircleLpReportDc05507.KEY_POSITION_ID, "");
            vas04586ReportProxy.recordString(hashMap, "action_attr", "");
            vas04586ReportProxy.recordString(hashMap, "action_value", "");
            vas04586ReportProxy.recordString(hashMap, "str_ruleid", "");
            if (!vas04586ReportProxy.busiInfo.containsKey(MiniAppPlugin.ATTR_PAGE_TYPE)) {
                vas04586ReportProxy.busiInfo.put(MiniAppPlugin.ATTR_PAGE_TYPE, "kuikly");
            }
            vas04586ReportProxy.recordMap(hashMap, "busi_info", vas04586ReportProxy.busiInfo);
            vas04586ReportProxy.recordMap(hashMap, "trace_info", vas04586ReportProxy.traceInfo);
            hashMap.put(AdMetricTag.Report.TYPE, "DC04586");
            function12.invoke(hashMap);
        }
    }
