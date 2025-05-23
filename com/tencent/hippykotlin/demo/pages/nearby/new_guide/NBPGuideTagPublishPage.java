package com.tencent.hippykotlin.demo.pages.nearby.new_guide;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.ECLoadingAttr;
import com.tencent.hippykotlin.demo.pages.base.ECLoadingView;
import com.tencent.hippykotlin.demo.pages.base.ECLoadingViewKt;
import com.tencent.hippykotlin.demo.pages.base.ECTransitionAttr;
import com.tencent.hippykotlin.demo.pages.base.ECTransitionView;
import com.tencent.hippykotlin.demo.pages.base.ECTransitionViewKt;
import com.tencent.hippykotlin.demo.pages.base.QToastMode;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.base.extension.ListExtKt;
import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyBasePager;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.NBPLatLng;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.NBPUserSelfInfo;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.UserDataManager;
import com.tencent.hippykotlin.demo.pages.nearby.base.module.QQNearbyModule;
import com.tencent.hippykotlin.demo.pages.nearby.base.repo.NBPPublishConfig;
import com.tencent.hippykotlin.demo.pages.nearby.base.repo.NBPPublishService;
import com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPJumpUtil;
import com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideTagCardAttr;
import com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideTagCardView;
import com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideTagShareCardView;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.aa;
import com.tencent.kuikly.core.base.attr.AccessibilityRole;
import com.tencent.kuikly.core.base.b;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.FrameEventKt;
import com.tencent.kuikly.core.base.event.VisibilityEventKt;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
import com.tencent.kuikly.core.layout.d;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.timer.TimerKt;
import com.tencent.kuikly.core.views.ModalView;
import com.tencent.kuikly.core.views.ScrollParams;
import com.tencent.kuikly.core.views.ScrollerView;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.ao;
import com.tencent.kuikly.core.views.ap;
import com.tencent.kuikly.core.views.aq;
import com.tencent.kuikly.core.views.ar;
import com.tencent.kuikly.core.views.bb;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.co;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.u;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt__StringsJVMKt;
import n25.i;
import n25.k;
import s25.f;
import t35.a;

/* loaded from: classes31.dex */
public final class NBPGuideTagPublishPage extends NearbyBasePager {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPGuideTagPublishPage.class, "currentOffsetY", "getCurrentOffsetY()F", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPGuideTagPublishPage.class, "guideViewHeight", "getGuideViewHeight()F", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPGuideTagPublishPage.class, "isEntering", "isEntering()Z", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPGuideTagPublishPage.class, "tagList", "getTagList()Lcom/tencent/kuikly/core/reactive/collection/ObservableList;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPGuideTagPublishPage.class, "startViewAnimate", "getStartViewAnimate()Z", 0)};
    public final ReadWriteProperty currentOffsetY$delegate;
    public boolean exit;
    public final ReadWriteProperty guideViewHeight$delegate;
    public final ReadWriteProperty isEntering$delegate;
    public aa<aq<?, ?>> listViewRef;
    public e pageParams;
    public final ReadWriteProperty startViewAnimate$delegate;
    public aa<NBPGuideTagCardView> tagCardViewRef;
    public List<String> tagCommonIconList;
    public final ReadWriteProperty tagList$delegate;
    public List<f35.e> tagSpecificIconList;

    public NBPGuideTagPublishPage() {
        Float valueOf = Float.valueOf(0.0f);
        this.currentOffsetY$delegate = c.a(valueOf);
        this.guideViewHeight$delegate = c.a(valueOf);
        Boolean bool = Boolean.FALSE;
        this.isEntering$delegate = c.a(bool);
        this.tagList$delegate = c.b();
        this.startViewAnimate$delegate = c.a(bool);
        this.pageParams = new e();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.NBPGuideTagPublishPage$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                final NBPGuideTagPublishPage nBPGuideTagPublishPage = NBPGuideTagPublishPage.this;
                w.a(viewContainer, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.NBPGuideTagPublishPage$body$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        final NBPGuideTagPublishPage nBPGuideTagPublishPage2 = NBPGuideTagPublishPage.this;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.NBPGuideTagPublishPage.body.1.1.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                boolean booleanValue;
                                boolean booleanValue2;
                                t tVar2 = tVar;
                                tVar2.absolutePositionAllZero();
                                booleanValue = ((Boolean) r0.startViewAnimate$delegate.getValue(NBPGuideTagPublishPage.this, NBPGuideTagPublishPage.$$delegatedProperties[4])).booleanValue();
                                if (booleanValue) {
                                    tVar2.mo113backgroundColor(new h(0L, 0.5f));
                                } else {
                                    tVar2.mo113backgroundColor(new h(0L, 0.0f));
                                }
                                b l3 = b.Companion.l(b.INSTANCE, 0.3f, null, 2, null);
                                booleanValue2 = ((Boolean) r1.startViewAnimate$delegate.getValue(NBPGuideTagPublishPage.this, NBPGuideTagPublishPage.$$delegatedProperties[4])).booleanValue();
                                tVar2.animate(l3, Boolean.valueOf(booleanValue2));
                                final NBPGuideTagPublishPage nBPGuideTagPublishPage3 = NBPGuideTagPublishPage.this;
                                TimerKt.h(0, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.NBPGuideTagPublishPage.body.1.1.1.1
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public final Unit invoke() {
                                        NBPGuideTagPublishPage nBPGuideTagPublishPage4 = NBPGuideTagPublishPage.this;
                                        nBPGuideTagPublishPage4.startViewAnimate$delegate.setValue(nBPGuideTagPublishPage4, NBPGuideTagPublishPage.$$delegatedProperties[4], Boolean.TRUE);
                                        return Unit.INSTANCE;
                                    }
                                }, 1, null);
                                return Unit.INSTANCE;
                            }
                        });
                        vVar2.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.NBPGuideTagPublishPage.body.1.1.2
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(u uVar) {
                                uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.NBPGuideTagPublishPage.body.1.1.2.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ClickParams clickParams) {
                                        QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
                                        QQKuiklyPlatformApi.Companion.closePage$default();
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final NBPGuideTagPublishPage nBPGuideTagPublishPage3 = NBPGuideTagPublishPage.this;
                        ECTransitionViewKt.TransitionFromBottomView(vVar2, new Function1<ECTransitionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.NBPGuideTagPublishPage.body.1.1.3
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ECTransitionView eCTransitionView) {
                                ECTransitionView eCTransitionView2 = eCTransitionView;
                                final NBPGuideTagPublishPage nBPGuideTagPublishPage4 = NBPGuideTagPublishPage.this;
                                eCTransitionView2.attr(new Function1<ECTransitionAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.NBPGuideTagPublishPage.body.1.1.3.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ECTransitionAttr eCTransitionAttr) {
                                        boolean booleanValue;
                                        ECTransitionAttr eCTransitionAttr2 = eCTransitionAttr;
                                        Attr.absolutePosition$default(eCTransitionAttr2, 0.0f, 0.0f, 0.0f, 0.0f, 11, null);
                                        eCTransitionAttr2.size(eCTransitionAttr2.getPagerData().m(), eCTransitionAttr2.getPagerData().l());
                                        booleanValue = ((Boolean) r0.startViewAnimate$delegate.getValue(NBPGuideTagPublishPage.this, NBPGuideTagPublishPage.$$delegatedProperties[4])).booleanValue();
                                        eCTransitionAttr2.setTransitionAppear(booleanValue);
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPGuideTagPublishPage nBPGuideTagPublishPage5 = NBPGuideTagPublishPage.this;
                                ar.a(eCTransitionView2, new Function1<aq<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.NBPGuideTagPublishPage.body.1.1.3.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(aq<?, ?> aqVar) {
                                        aq<?, ?> aqVar2 = aqVar;
                                        final NBPGuideTagPublishPage nBPGuideTagPublishPage6 = NBPGuideTagPublishPage.this;
                                        aqVar2.ref(aqVar2, new Function1<aa<aq<?, ?>>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.NBPGuideTagPublishPage.body.1.1.3.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(aa<aq<?, ?>> aaVar) {
                                                NBPGuideTagPublishPage.this.listViewRef = aaVar;
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final NBPGuideTagPublishPage nBPGuideTagPublishPage7 = NBPGuideTagPublishPage.this;
                                        aqVar2.attr(new Function1<ao, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.NBPGuideTagPublishPage.body.1.1.3.2.2
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ao aoVar) {
                                                float floatValue;
                                                float floatValue2;
                                                ao aoVar2 = aoVar;
                                                aoVar2.mo153width(aoVar2.getPagerData().m());
                                                floatValue = ((Number) r8.guideViewHeight$delegate.getValue(NBPGuideTagPublishPage.this, NBPGuideTagPublishPage.$$delegatedProperties[1])).floatValue();
                                                if (!(floatValue == 0.0f)) {
                                                    floatValue2 = ((Number) r8.guideViewHeight$delegate.getValue(NBPGuideTagPublishPage.this, NBPGuideTagPublishPage.$$delegatedProperties[1])).floatValue();
                                                } else {
                                                    floatValue2 = aoVar2.getPagerData().l();
                                                }
                                                aoVar2.mo141height(floatValue2);
                                                Attr.absolutePosition$default(aoVar2, 0.0f, 0.0f, 0.0f, 0.0f, 11, null);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final NBPGuideTagPublishPage nBPGuideTagPublishPage8 = NBPGuideTagPublishPage.this;
                                        aqVar2.event(new Function1<ap, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.NBPGuideTagPublishPage.body.1.1.3.2.3
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ap apVar) {
                                                final ap apVar2 = apVar;
                                                final NBPGuideTagPublishPage nBPGuideTagPublishPage9 = NBPGuideTagPublishPage.this;
                                                apVar2.scroll(true, new Function1<ScrollParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.NBPGuideTagPublishPage.body.1.1.3.2.3.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ScrollParams scrollParams) {
                                                        NBPGuideTagPublishPage nBPGuideTagPublishPage10 = NBPGuideTagPublishPage.this;
                                                        nBPGuideTagPublishPage10.currentOffsetY$delegate.setValue(nBPGuideTagPublishPage10, NBPGuideTagPublishPage.$$delegatedProperties[0], Float.valueOf(scrollParams.getOffsetY()));
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final NBPGuideTagPublishPage nBPGuideTagPublishPage10 = NBPGuideTagPublishPage.this;
                                                apVar2.willDragEndBySync(new Function1<co, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.NBPGuideTagPublishPage.body.1.1.3.2.3.2
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(co coVar) {
                                                        float floatValue;
                                                        co coVar2 = coVar;
                                                        NBPGuideTagPublishPage nBPGuideTagPublishPage11 = NBPGuideTagPublishPage.this;
                                                        aa<aq<?, ?>> aaVar = null;
                                                        if (((Number) nBPGuideTagPublishPage11.currentOffsetY$delegate.getValue(nBPGuideTagPublishPage11, NBPGuideTagPublishPage.$$delegatedProperties[0])).floatValue() < -20.0f && coVar2.getVelocityY() < -0.2d) {
                                                            aa<aq<?, ?>> aaVar2 = NBPGuideTagPublishPage.this.listViewRef;
                                                            if (aaVar2 != null) {
                                                                aaVar = aaVar2;
                                                            } else {
                                                                Intrinsics.throwUninitializedPropertyAccessException("listViewRef");
                                                            }
                                                            aq<?, ?> b16 = aaVar.b();
                                                            if (b16 != null) {
                                                                floatValue = ((Number) r12.guideViewHeight$delegate.getValue(NBPGuideTagPublishPage.this, NBPGuideTagPublishPage.$$delegatedProperties[1])).floatValue();
                                                                ScrollerView.setContentInsetWhenEndDrag$default(b16, floatValue, 0.0f, 0.0f, 0.0f, 14, null);
                                                            }
                                                            NBPGuideTagPublishPage.this.exit = true;
                                                        } else {
                                                            aa<aq<?, ?>> aaVar3 = NBPGuideTagPublishPage.this.listViewRef;
                                                            if (aaVar3 != null) {
                                                                aaVar = aaVar3;
                                                            } else {
                                                                Intrinsics.throwUninitializedPropertyAccessException("listViewRef");
                                                            }
                                                            aq<?, ?> b17 = aaVar.b();
                                                            if (b17 != null) {
                                                                ScrollerView.setContentInsetWhenEndDrag$default(b17, 0.0f, 0.0f, 0.0f, 0.0f, 14, null);
                                                            }
                                                            NBPGuideTagPublishPage.this.exit = false;
                                                        }
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final NBPGuideTagPublishPage nBPGuideTagPublishPage11 = NBPGuideTagPublishPage.this;
                                                apVar2.dragEnd(new Function1<ScrollParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.NBPGuideTagPublishPage.body.1.1.3.2.3.3
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ScrollParams scrollParams) {
                                                        if (NBPGuideTagPublishPage.this.exit) {
                                                            ap apVar3 = apVar2;
                                                            C32451 c32451 = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.NBPGuideTagPublishPage.body.1.1.3.2.3.3.1
                                                                @Override // kotlin.jvm.functions.Function0
                                                                public final Unit invoke() {
                                                                    QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
                                                                    QQKuiklyPlatformApi.Companion.closePage$default();
                                                                    return Unit.INSTANCE;
                                                                }
                                                            };
                                                            KProperty<Object>[] kPropertyArr = IPagerIdKtxKt.$$delegatedProperties;
                                                            TimerKt.e(apVar3.getPagerId(), 200, c32451);
                                                        }
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                apVar2.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.NBPGuideTagPublishPage.body.1.1.3.2.3.4
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final /* bridge */ /* synthetic */ Unit invoke(ClickParams clickParams) {
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final NBPGuideTagPublishPage nBPGuideTagPublishPage9 = NBPGuideTagPublishPage.this;
                                        w.a(aqVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.NBPGuideTagPublishPage.body.1.1.3.2.4
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(v vVar3) {
                                                v vVar4 = vVar3;
                                                vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.NBPGuideTagPublishPage.body.1.1.3.2.4.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(t tVar) {
                                                        t tVar2 = tVar;
                                                        tVar2.flexDirectionColumn();
                                                        tVar2.alignItemsCenter();
                                                        tVar2.mo113backgroundColor(QUIToken.color$default("bg_middle_light"));
                                                        tVar2.borderRadius(8.0f, 8.0f, 0.0f, 0.0f);
                                                        tVar2.paddingBottom(tVar2.getPagerData().getIsIphoneX() ? 30.0f : 0.0f);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final NBPGuideTagPublishPage nBPGuideTagPublishPage10 = NBPGuideTagPublishPage.this;
                                                vVar4.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.NBPGuideTagPublishPage.body.1.1.3.2.4.2
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(u uVar) {
                                                        final NBPGuideTagPublishPage nBPGuideTagPublishPage11 = NBPGuideTagPublishPage.this;
                                                        FrameEventKt.d(uVar, new Function1<d, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.NBPGuideTagPublishPage.body.1.1.3.2.4.2.1
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(d dVar) {
                                                                NBPGuideTagPublishPage nBPGuideTagPublishPage12 = NBPGuideTagPublishPage.this;
                                                                nBPGuideTagPublishPage12.guideViewHeight$delegate.setValue(nBPGuideTagPublishPage12, NBPGuideTagPublishPage.$$delegatedProperties[1], Float.valueOf(dVar.getHeight()));
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                w.a(vVar4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.NBPGuideTagPublishPage.body.1.1.3.2.4.3
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(v vVar5) {
                                                        v vVar6 = vVar5;
                                                        vVar6.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.NBPGuideTagPublishPage.body.1.1.3.2.4.3.1
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(t tVar) {
                                                                t tVar2 = tVar;
                                                                tVar2.allCenter();
                                                                tVar2.paddingTop(4.5f);
                                                                tVar2.paddingBottom(4.5f);
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        w.a(vVar6, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.NBPGuideTagPublishPage.body.1.1.3.2.4.3.2
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(v vVar7) {
                                                                vVar7.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.NBPGuideTagPublishPage.body.1.1.3.2.4.3.2.1
                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(t tVar) {
                                                                        t tVar2 = tVar;
                                                                        tVar2.size(36.0f, 5.0f);
                                                                        tVar2.borderRadius(3.0f);
                                                                        tVar2.mo113backgroundColor(QUIToken.color$default("icon_tertiary"));
                                                                        tVar2.accessibility("\u4e0b\u62c9\u5173\u95ed");
                                                                        tVar2.accessibilityRole(AccessibilityRole.BUTTON);
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.NBPGuideTagPublishPage.body.1.1.3.2.4.4
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(TextView textView) {
                                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.NBPGuideTagPublishPage.body.1.1.3.2.4.4.1
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ce ceVar) {
                                                                ce ceVar2 = ceVar;
                                                                ceVar2.marginTop(24.0f);
                                                                ce.fontSize$default(ceVar2, 18.0f, null, 2, null);
                                                                ceVar2.fontWeight500();
                                                                ceVar2.color(QUIToken.color$default("text_primary"));
                                                                ceVar2.text("\u53d1\u5e03\u4f60\u7684\u5174\u8da3\u6210\u5206\u5361\uff0c\u8ba9\u66f4\u591a\u540c\u597d\u53d1\u73b0\u4f60");
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final NBPGuideTagPublishPage nBPGuideTagPublishPage11 = NBPGuideTagPublishPage.this;
                                                vVar4.addChild(new NBPGuideTagCardView(), new Function1<NBPGuideTagCardView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.NBPGuideTagPublishPage.body.1.1.3.2.4.5
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(NBPGuideTagCardView nBPGuideTagCardView) {
                                                        NBPGuideTagCardView nBPGuideTagCardView2 = nBPGuideTagCardView;
                                                        final NBPGuideTagPublishPage nBPGuideTagPublishPage12 = NBPGuideTagPublishPage.this;
                                                        nBPGuideTagCardView2.ref(nBPGuideTagCardView2, new Function1<aa<NBPGuideTagCardView>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.NBPGuideTagPublishPage.body.1.1.3.2.4.5.1
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(aa<NBPGuideTagCardView> aaVar) {
                                                                NBPGuideTagPublishPage.this.tagCardViewRef = aaVar;
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        final NBPGuideTagPublishPage nBPGuideTagPublishPage13 = NBPGuideTagPublishPage.this;
                                                        nBPGuideTagCardView2.attr(new Function1<NBPGuideTagCardAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.NBPGuideTagPublishPage.body.1.1.3.2.4.5.2
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(NBPGuideTagCardAttr nBPGuideTagCardAttr) {
                                                                Object firstOrNull;
                                                                NBPGuideTagCardAttr nBPGuideTagCardAttr2 = nBPGuideTagCardAttr;
                                                                nBPGuideTagCardAttr2.marginTop(24.0f);
                                                                NBPGuideTagPublishPage nBPGuideTagPublishPage14 = NBPGuideTagPublishPage.this;
                                                                KProperty<Object>[] kPropertyArr = NBPGuideTagPublishPage.$$delegatedProperties;
                                                                nBPGuideTagCardAttr2.setTagList(nBPGuideTagPublishPage14.getTagList());
                                                                firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) NBPGuideTagPublishPage.this.getTagList());
                                                                a aVar = (a) firstOrNull;
                                                                nBPGuideTagCardAttr2.mainTagId$delegate.setValue(nBPGuideTagCardAttr2, NBPGuideTagCardAttr.$$delegatedProperties[0], Integer.valueOf(aVar != null ? aVar.f435362d : -1));
                                                                NBPGuideTagPublishPage nBPGuideTagPublishPage15 = NBPGuideTagPublishPage.this;
                                                                nBPGuideTagCardAttr2.tagSpecificIconList = nBPGuideTagPublishPage15.tagSpecificIconList;
                                                                nBPGuideTagCardAttr2.tagCommonIconList = nBPGuideTagPublishPage15.tagCommonIconList;
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final NBPGuideTagPublishPage nBPGuideTagPublishPage12 = NBPGuideTagPublishPage.this;
                                                w.a(vVar4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.NBPGuideTagPublishPage.body.1.1.3.2.4.6
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(v vVar5) {
                                                        v vVar6 = vVar5;
                                                        vVar6.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.NBPGuideTagPublishPage.body.1.1.3.2.4.6.1
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(t tVar) {
                                                                t tVar2 = tVar;
                                                                tVar2.marginTop(28.0f);
                                                                tVar2.marginBottom(30.0f);
                                                                tVar2.mo113backgroundColor(QUIToken.color$default("button_bg_primary_default"));
                                                                tVar2.borderRadius(4.0f);
                                                                tVar2.size(168.0f, 45.0f);
                                                                tVar2.allCenter();
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        cg.a(vVar6, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.NBPGuideTagPublishPage.body.1.1.3.2.4.6.2
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(TextView textView) {
                                                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.NBPGuideTagPublishPage.body.1.1.3.2.4.6.2.1
                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(ce ceVar) {
                                                                        ce ceVar2 = ceVar;
                                                                        ce.fontSize$default(ceVar2, 17.0f, null, 2, null);
                                                                        ceVar2.fontWeight500();
                                                                        ceVar2.color(QUIToken.color$default("button_text_primary_default"));
                                                                        ceVar2.text("\u53d1\u5e03");
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        final NBPGuideTagPublishPage nBPGuideTagPublishPage13 = NBPGuideTagPublishPage.this;
                                                        vVar6.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.NBPGuideTagPublishPage.body.1.1.3.2.4.6.3
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(u uVar) {
                                                                u uVar2 = uVar;
                                                                final NBPGuideTagPublishPage nBPGuideTagPublishPage14 = NBPGuideTagPublishPage.this;
                                                                uVar2.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.NBPGuideTagPublishPage.body.1.1.3.2.4.6.3.1
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(ClickParams clickParams) {
                                                                        int collectionSizeOrDefault;
                                                                        NBPGuideTagCardView b16;
                                                                        NBPGuideTagShareCardView b17;
                                                                        final NBPGuideTagPublishPage nBPGuideTagPublishPage15 = NBPGuideTagPublishPage.this;
                                                                        e eVar = nBPGuideTagPublishPage15.pageParams;
                                                                        eVar.v("dt_eid", "em_nearby_interest_publish_pop");
                                                                        com.tencent.kuikly.core.reactive.collection.c<a> tagList = nBPGuideTagPublishPage15.getTagList();
                                                                        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(tagList, 10);
                                                                        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                                                                        Iterator<a> it = tagList.iterator();
                                                                        while (it.hasNext()) {
                                                                            arrayList.add(Integer.valueOf(it.next().f435362d));
                                                                        }
                                                                        eVar.v("nearby_tag_id", ListExtKt.join(arrayList));
                                                                        eVar.v(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
                                                                        Utils.INSTANCE.currentBridgeModule().reportCustomDtEvent("dt_clck", eVar);
                                                                        nBPGuideTagPublishPage15.isEntering$delegate.setValue(nBPGuideTagPublishPage15, NBPGuideTagPublishPage.$$delegatedProperties[2], Boolean.TRUE);
                                                                        aa<NBPGuideTagCardView> aaVar = nBPGuideTagPublishPage15.tagCardViewRef;
                                                                        if (aaVar != null && (b16 = aaVar.b()) != null) {
                                                                            Function1<String, Unit> function1 = new Function1<String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.NBPGuideTagPublishPage$handlePublish$2
                                                                                {
                                                                                    super(1);
                                                                                }

                                                                                @Override // kotlin.jvm.functions.Function1
                                                                                public final Unit invoke(String str) {
                                                                                    k kVar;
                                                                                    String str2 = str;
                                                                                    if (str2 == null) {
                                                                                        KLog.INSTANCE.e("NBPGuideStockTagPublisher", "[handlePublish]getSharePhotoPath error: photoPath is null");
                                                                                        Utils.INSTANCE.currentBridgeModule().qToast("\u670d\u52a1\u5668\u7e41\u5fd9\uff0c\u53d1\u5e03\u5931\u8d25!", QToastMode.Warning);
                                                                                        NBPGuideTagPublishPage nBPGuideTagPublishPage16 = NBPGuideTagPublishPage.this;
                                                                                        AnonymousClass1 anonymousClass1 = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.NBPGuideTagPublishPage$handlePublish$2.1
                                                                                            @Override // kotlin.jvm.functions.Function0
                                                                                            public final Unit invoke() {
                                                                                                QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
                                                                                                QQKuiklyPlatformApi.Companion.closePage$default();
                                                                                                return Unit.INSTANCE;
                                                                                            }
                                                                                        };
                                                                                        KProperty<Object>[] kPropertyArr = IPagerIdKtxKt.$$delegatedProperties;
                                                                                        TimerKt.e(nBPGuideTagPublishPage16.getPagerId(), 100, anonymousClass1);
                                                                                    } else {
                                                                                        NBPUserSelfInfo userSelfInfo = UserDataManager.INSTANCE.getUserSelfInfo();
                                                                                        if (userSelfInfo.locationAddress.length() > 0) {
                                                                                            NBPLatLng nBPLatLng = userSelfInfo.latLng;
                                                                                            double d16 = 1000000;
                                                                                            i iVar = new i((long) (nBPLatLng.latitude * d16), (long) (nBPLatLng.longitude * d16), 12);
                                                                                            String str3 = userSelfInfo.locationAddress;
                                                                                            String str4 = userSelfInfo.locationCountry;
                                                                                            String str5 = userSelfInfo.locationProvince;
                                                                                            String str6 = userSelfInfo.locationCity;
                                                                                            String str7 = userSelfInfo.locationDistrict;
                                                                                            String str8 = userSelfInfo.locationName;
                                                                                            kVar = new k((String) null, str8, 0, (String) null, str3, 0, iVar, 0, 0, (String) null, str4, str5, str6, 0, 0, (String) null, str7, (String) null, (String) null, str8, 1500077);
                                                                                        } else {
                                                                                            kVar = null;
                                                                                        }
                                                                                        k kVar2 = kVar;
                                                                                        NBPPublishService nBPPublishService = NBPPublishService.INSTANCE;
                                                                                        NBPPublishConfig nBPPublishConfig = new NBPPublishConfig("7", str2, null, null, kVar2, null, null, kVar2 != null ? 2 : 3, 748);
                                                                                        final NBPGuideTagPublishPage nBPGuideTagPublishPage17 = NBPGuideTagPublishPage.this;
                                                                                        nBPPublishService.publish(nBPPublishConfig, new Function3<Boolean, f, String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.NBPGuideTagPublishPage$handlePublish$2.2
                                                                                            {
                                                                                                super(3);
                                                                                            }

                                                                                            @Override // kotlin.jvm.functions.Function3
                                                                                            public final Unit invoke(Boolean bool, f fVar, String str9) {
                                                                                                boolean booleanValue = bool.booleanValue();
                                                                                                f fVar2 = fVar;
                                                                                                String str10 = str9;
                                                                                                NBPGuideTagPublishPage nBPGuideTagPublishPage18 = NBPGuideTagPublishPage.this;
                                                                                                nBPGuideTagPublishPage18.isEntering$delegate.setValue(nBPGuideTagPublishPage18, NBPGuideTagPublishPage.$$delegatedProperties[2], Boolean.FALSE);
                                                                                                KLog.INSTANCE.i("NBPGuideStockTagPublisher", "publish default: " + booleanValue + ", " + str10);
                                                                                                if (booleanValue) {
                                                                                                    if ((fVar2 != null ? fVar2.f433139d : null) != null) {
                                                                                                        NBPJumpUtil.jumpSquareFeedList$default(null, fVar2.f433139d, null, "5", true, null, null, null, 224);
                                                                                                        return Unit.INSTANCE;
                                                                                                    }
                                                                                                }
                                                                                                if (str10 != null) {
                                                                                                    Utils.INSTANCE.currentBridgeModule().qToast(str10, QToastMode.Warning);
                                                                                                }
                                                                                                NBPGuideTagPublishPage nBPGuideTagPublishPage19 = NBPGuideTagPublishPage.this;
                                                                                                C32682 c32682 = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.NBPGuideTagPublishPage.handlePublish.2.2.2
                                                                                                    @Override // kotlin.jvm.functions.Function0
                                                                                                    public final Unit invoke() {
                                                                                                        QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
                                                                                                        QQKuiklyPlatformApi.Companion.closePage$default();
                                                                                                        return Unit.INSTANCE;
                                                                                                    }
                                                                                                };
                                                                                                KProperty<Object>[] kPropertyArr2 = IPagerIdKtxKt.$$delegatedProperties;
                                                                                                TimerKt.e(nBPGuideTagPublishPage19.getPagerId(), 100, c32682);
                                                                                                return Unit.INSTANCE;
                                                                                            }
                                                                                        });
                                                                                    }
                                                                                    return Unit.INSTANCE;
                                                                                }
                                                                            };
                                                                            aa<NBPGuideTagShareCardView> aaVar2 = b16.guideTagShareCardViewRef;
                                                                            if (aaVar2 != null && (b17 = aaVar2.b()) != null) {
                                                                                KProperty<Object>[] kPropertyArr = NBPGuideTagShareCardView.$$delegatedProperties;
                                                                                b17.getSharePhotoPath(function1, 0);
                                                                            }
                                                                        }
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                final NBPGuideTagPublishPage nBPGuideTagPublishPage15 = NBPGuideTagPublishPage.this;
                                                                VisibilityEventKt.b(uVar2, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.NBPGuideTagPublishPage.body.1.1.3.2.4.6.3.2
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(Object obj) {
                                                                        int collectionSizeOrDefault;
                                                                        NBPGuideTagPublishPage nBPGuideTagPublishPage16 = NBPGuideTagPublishPage.this;
                                                                        e eVar = nBPGuideTagPublishPage16.pageParams;
                                                                        eVar.v("dt_eid", "em_nearby_interest_publish_pop");
                                                                        com.tencent.kuikly.core.reactive.collection.c<a> tagList = nBPGuideTagPublishPage16.getTagList();
                                                                        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(tagList, 10);
                                                                        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                                                                        Iterator<a> it = tagList.iterator();
                                                                        while (it.hasNext()) {
                                                                            arrayList.add(Integer.valueOf(it.next().f435362d));
                                                                        }
                                                                        eVar.v("nearby_tag_id", ListExtKt.join(arrayList));
                                                                        eVar.v(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
                                                                        Utils.INSTANCE.currentBridgeModule().reportCustomDtEvent("dt_imp", eVar);
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
                        final NBPGuideTagPublishPage nBPGuideTagPublishPage4 = NBPGuideTagPublishPage.this;
                        ConditionViewKt.c(vVar2, new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.NBPGuideTagPublishPage.body.1.1.4
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                NBPGuideTagPublishPage nBPGuideTagPublishPage5 = NBPGuideTagPublishPage.this;
                                return Boolean.valueOf(((Boolean) nBPGuideTagPublishPage5.isEntering$delegate.getValue(nBPGuideTagPublishPage5, NBPGuideTagPublishPage.$$delegatedProperties[2])).booleanValue());
                            }
                        }, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.NBPGuideTagPublishPage.body.1.1.5
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ConditionView conditionView) {
                                bb.b(conditionView, false, new Function1<ModalView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.NBPGuideTagPublishPage.body.1.1.5.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ModalView modalView) {
                                        ModalView modalView2 = modalView;
                                        w.a(modalView2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.NBPGuideTagPublishPage.body.1.1.5.1.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(v vVar3) {
                                                v vVar4 = vVar3;
                                                vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.NBPGuideTagPublishPage.body.1.1.5.1.1.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(t tVar) {
                                                        t tVar2 = tVar;
                                                        tVar2.size(tVar2.getPagerData().m(), tVar2.getPagerData().l());
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                vVar4.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.NBPGuideTagPublishPage.body.1.1.5.1.1.2
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(u uVar) {
                                                        uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.NBPGuideTagPublishPage.body.1.1.5.1.1.2.1
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
                                        ECLoadingViewKt.ECLoading(modalView2, new Function1<ECLoadingView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.NBPGuideTagPublishPage.body.1.1.5.1.2
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ECLoadingView eCLoadingView) {
                                                eCLoadingView.attr(new Function1<ECLoadingAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.NBPGuideTagPublishPage.body.1.1.5.1.2.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ECLoadingAttr eCLoadingAttr) {
                                                        ECLoadingAttr eCLoadingAttr2 = eCLoadingAttr;
                                                        eCLoadingAttr2.delayShow = false;
                                                        eCLoadingAttr2.setLoadingText("\u6b63\u5728\u53d1\u5e03...");
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
                });
                return Unit.INSTANCE;
            }
        };
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.BasePager, com.tencent.kuikly.core.base.ComposeView
    public final void created() {
        Object firstOrNull;
        Object orNull;
        e eVar;
        String decodeToString;
        String decodeToString2;
        f35.k kVar;
        List<Object> w3;
        int collectionSizeOrDefault;
        a aVar;
        super.created();
        Object[] sharePenetratePageData = QQNearbyModule.Companion.getInstance().getSharePenetratePageData();
        if (sharePenetratePageData != null) {
            firstOrNull = ArraysKt___ArraysKt.firstOrNull(sharePenetratePageData);
            byte[] bArr = firstOrNull instanceof byte[] ? (byte[]) firstOrNull : null;
            if (bArr != null) {
                decodeToString2 = StringsKt__StringsJVMKt.decodeToString(bArr);
                e eVar2 = new e(decodeToString2);
                com.tencent.kuikly.core.nvi.serialization.json.b l3 = eVar2.l("tagList");
                if (l3 != null && (w3 = l3.w()) != null) {
                    collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(w3, 10);
                    ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                    for (Object obj : w3) {
                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                        byte[] a16 = d45.a.a((String) obj);
                        arrayList.add((a16 == null || (aVar = (a) c45.i.b(new a(0, null, 63), a16)) == null) ? null : Boolean.valueOf(getTagList().add(aVar)));
                    }
                }
                byte[] a17 = d45.a.a(eVar2.p("oldUserConfig"));
                if (a17 != null && (kVar = (f35.k) c45.i.b(new f35.k(false, null, null, null, 15, null), a17)) != null) {
                    this.tagSpecificIconList = kVar.f397818f;
                    this.tagCommonIconList = kVar.f397819h;
                }
            }
            orNull = ArraysKt___ArraysKt.getOrNull(sharePenetratePageData, 1);
            byte[] bArr2 = orNull instanceof byte[] ? (byte[]) orNull : null;
            if (bArr2 != null) {
                decodeToString = StringsKt__StringsJVMKt.decodeToString(bArr2);
                eVar = new e(decodeToString);
            } else {
                eVar = new e();
            }
            this.pageParams = eVar;
        }
    }

    public final com.tencent.kuikly.core.reactive.collection.c<a> getTagList() {
        return (com.tencent.kuikly.core.reactive.collection.c) this.tagList$delegate.getValue(this, $$delegatedProperties[3]);
    }
}
