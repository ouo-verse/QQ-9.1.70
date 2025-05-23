package com.tencent.hippykotlin.demo.pages.nearby.new_guide;

import c01.c;
import c45.i;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieCategoryHomePage$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.ECTransitionAttr;
import com.tencent.hippykotlin.demo.pages.base.ECTransitionView;
import com.tencent.hippykotlin.demo.pages.base.ECTransitionViewKt;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedItemView$body$1$3$8$1$2$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyBasePager;
import com.tencent.hippykotlin.demo.pages.nearby.base.module.QQNearbyModule;
import com.tencent.hippykotlin.demo.pages.nearby.base.repo.QQStrangerSsoRequest;
import com.tencent.hippykotlin.demo.pages.nearby.base.repo.QQStrangerSsoService$sendProxyRequest$1;
import com.tencent.hippykotlin.demo.pages.nearby.base.tech_reporter.APICallTechReporter;
import com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideTagPickerAttr;
import com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideTagPickerView;
import com.tencent.hippykotlin.demo.pages.nearby.new_homepage.repository.NBPNewHomeRepository$updateTagsInfo$1;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.aa;
import com.tencent.kuikly.core.base.attr.AccessibilityRole;
import com.tencent.kuikly.core.base.b;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.FrameEventKt;
import com.tencent.kuikly.core.base.event.VisibilityEventKt;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.layout.d;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.timer.TimerKt;
import com.tencent.kuikly.core.views.ScrollParams;
import com.tencent.kuikly.core.views.ScrollerView;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.ao;
import com.tencent.kuikly.core.views.ap;
import com.tencent.kuikly.core.views.aq;
import com.tencent.kuikly.core.views.ar;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.co;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.u;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import f35.k;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt__StringsJVMKt;
import s35.ad;
import s35.ae;
import t35.a;

/* loaded from: classes31.dex */
public final class NBPGuideTagPickPage extends NearbyBasePager {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPGuideTagPickPage.class, "currentOffsetY", "getCurrentOffsetY()F", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPGuideTagPickPage.class, "guideViewHeight", "getGuideViewHeight()F", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPGuideTagPickPage.class, "startViewAnimate", "getStartViewAnimate()Z", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPGuideTagPickPage.class, "tagList", "getTagList()Lcom/tencent/kuikly/core/reactive/collection/ObservableList;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPGuideTagPickPage.class, "selectedTagList", "getSelectedTagList()Lcom/tencent/kuikly/core/reactive/collection/ObservableList;", 0)};
    public final ReadWriteProperty currentOffsetY$delegate;
    public boolean exit;
    public final ReadWriteProperty guideViewHeight$delegate;
    public aa<aq<?, ?>> listViewRef;
    public k oldUserConfig;
    public e pageParams;
    public final ReadWriteProperty selectedTagList$delegate;
    public final ReadWriteProperty startViewAnimate$delegate;
    public final ReadWriteProperty tagList$delegate;

    public NBPGuideTagPickPage() {
        Float valueOf = Float.valueOf(0.0f);
        this.currentOffsetY$delegate = c.a(valueOf);
        this.guideViewHeight$delegate = c.a(valueOf);
        this.startViewAnimate$delegate = c.a(Boolean.FALSE);
        this.tagList$delegate = c.b();
        this.selectedTagList$delegate = c.b();
        this.pageParams = new e();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.NBPGuideTagPickPage$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                final NBPGuideTagPickPage nBPGuideTagPickPage = NBPGuideTagPickPage.this;
                w.a(viewContainer, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.NBPGuideTagPickPage$body$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        final NBPGuideTagPickPage nBPGuideTagPickPage2 = NBPGuideTagPickPage.this;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.NBPGuideTagPickPage.body.1.1.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                boolean booleanValue;
                                boolean booleanValue2;
                                t tVar2 = tVar;
                                tVar2.absolutePositionAllZero();
                                booleanValue = ((Boolean) r0.startViewAnimate$delegate.getValue(NBPGuideTagPickPage.this, NBPGuideTagPickPage.$$delegatedProperties[2])).booleanValue();
                                if (booleanValue) {
                                    tVar2.mo113backgroundColor(new h(0L, 0.5f));
                                } else {
                                    tVar2.mo113backgroundColor(new h(0L, 0.0f));
                                }
                                b l3 = b.Companion.l(b.INSTANCE, 0.3f, null, 2, null);
                                booleanValue2 = ((Boolean) r1.startViewAnimate$delegate.getValue(NBPGuideTagPickPage.this, NBPGuideTagPickPage.$$delegatedProperties[2])).booleanValue();
                                tVar2.animate(l3, Boolean.valueOf(booleanValue2));
                                final NBPGuideTagPickPage nBPGuideTagPickPage3 = NBPGuideTagPickPage.this;
                                TimerKt.h(0, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.NBPGuideTagPickPage.body.1.1.1.1
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public final Unit invoke() {
                                        NBPGuideTagPickPage nBPGuideTagPickPage4 = NBPGuideTagPickPage.this;
                                        nBPGuideTagPickPage4.startViewAnimate$delegate.setValue(nBPGuideTagPickPage4, NBPGuideTagPickPage.$$delegatedProperties[2], Boolean.TRUE);
                                        return Unit.INSTANCE;
                                    }
                                }, 1, null);
                                return Unit.INSTANCE;
                            }
                        });
                        vVar2.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.NBPGuideTagPickPage.body.1.1.2
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(u uVar) {
                                uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.NBPGuideTagPickPage.body.1.1.2.1
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
                        final NBPGuideTagPickPage nBPGuideTagPickPage3 = NBPGuideTagPickPage.this;
                        ECTransitionViewKt.TransitionFromBottomView(vVar2, new Function1<ECTransitionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.NBPGuideTagPickPage.body.1.1.3
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ECTransitionView eCTransitionView) {
                                ECTransitionView eCTransitionView2 = eCTransitionView;
                                final NBPGuideTagPickPage nBPGuideTagPickPage4 = NBPGuideTagPickPage.this;
                                eCTransitionView2.attr(new Function1<ECTransitionAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.NBPGuideTagPickPage.body.1.1.3.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ECTransitionAttr eCTransitionAttr) {
                                        boolean booleanValue;
                                        ECTransitionAttr eCTransitionAttr2 = eCTransitionAttr;
                                        Attr.absolutePosition$default(eCTransitionAttr2, 0.0f, 0.0f, 0.0f, 0.0f, 11, null);
                                        eCTransitionAttr2.size(eCTransitionAttr2.getPagerData().m(), eCTransitionAttr2.getPagerData().l());
                                        booleanValue = ((Boolean) r0.startViewAnimate$delegate.getValue(NBPGuideTagPickPage.this, NBPGuideTagPickPage.$$delegatedProperties[2])).booleanValue();
                                        eCTransitionAttr2.setTransitionAppear(booleanValue);
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPGuideTagPickPage nBPGuideTagPickPage5 = NBPGuideTagPickPage.this;
                                ar.a(eCTransitionView2, new Function1<aq<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.NBPGuideTagPickPage.body.1.1.3.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(aq<?, ?> aqVar) {
                                        aq<?, ?> aqVar2 = aqVar;
                                        final NBPGuideTagPickPage nBPGuideTagPickPage6 = NBPGuideTagPickPage.this;
                                        aqVar2.ref(aqVar2, new Function1<aa<aq<?, ?>>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.NBPGuideTagPickPage.body.1.1.3.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(aa<aq<?, ?>> aaVar) {
                                                NBPGuideTagPickPage.this.listViewRef = aaVar;
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final NBPGuideTagPickPage nBPGuideTagPickPage7 = NBPGuideTagPickPage.this;
                                        aqVar2.attr(new Function1<ao, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.NBPGuideTagPickPage.body.1.1.3.2.2
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ao aoVar) {
                                                float floatValue;
                                                float floatValue2;
                                                ao aoVar2 = aoVar;
                                                Attr.absolutePosition$default(aoVar2, 0.0f, 0.0f, 0.0f, 0.0f, 11, null);
                                                aoVar2.mo153width(aoVar2.getPagerData().m());
                                                floatValue = ((Number) r0.guideViewHeight$delegate.getValue(NBPGuideTagPickPage.this, NBPGuideTagPickPage.$$delegatedProperties[1])).floatValue();
                                                if (!(floatValue == 0.0f)) {
                                                    floatValue2 = ((Number) r0.guideViewHeight$delegate.getValue(NBPGuideTagPickPage.this, NBPGuideTagPickPage.$$delegatedProperties[1])).floatValue();
                                                } else {
                                                    floatValue2 = aoVar2.getPagerData().l();
                                                }
                                                aoVar2.mo141height(floatValue2);
                                                aoVar2.flexDirectionColumn();
                                                aoVar2.alignItemsCenter();
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final NBPGuideTagPickPage nBPGuideTagPickPage8 = NBPGuideTagPickPage.this;
                                        aqVar2.event(new Function1<ap, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.NBPGuideTagPickPage.body.1.1.3.2.3
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ap apVar) {
                                                final ap apVar2 = apVar;
                                                final NBPGuideTagPickPage nBPGuideTagPickPage9 = NBPGuideTagPickPage.this;
                                                apVar2.scroll(true, new Function1<ScrollParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.NBPGuideTagPickPage.body.1.1.3.2.3.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ScrollParams scrollParams) {
                                                        NBPGuideTagPickPage nBPGuideTagPickPage10 = NBPGuideTagPickPage.this;
                                                        nBPGuideTagPickPage10.currentOffsetY$delegate.setValue(nBPGuideTagPickPage10, NBPGuideTagPickPage.$$delegatedProperties[0], Float.valueOf(scrollParams.getOffsetY()));
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final NBPGuideTagPickPage nBPGuideTagPickPage10 = NBPGuideTagPickPage.this;
                                                apVar2.willDragEndBySync(new Function1<co, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.NBPGuideTagPickPage.body.1.1.3.2.3.2
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(co coVar) {
                                                        float floatValue;
                                                        co coVar2 = coVar;
                                                        NBPGuideTagPickPage nBPGuideTagPickPage11 = NBPGuideTagPickPage.this;
                                                        aa<aq<?, ?>> aaVar = null;
                                                        if (((Number) nBPGuideTagPickPage11.currentOffsetY$delegate.getValue(nBPGuideTagPickPage11, NBPGuideTagPickPage.$$delegatedProperties[0])).floatValue() < -20.0f && coVar2.getVelocityY() < -0.2d) {
                                                            aa<aq<?, ?>> aaVar2 = NBPGuideTagPickPage.this.listViewRef;
                                                            if (aaVar2 != null) {
                                                                aaVar = aaVar2;
                                                            } else {
                                                                Intrinsics.throwUninitializedPropertyAccessException("listViewRef");
                                                            }
                                                            aq<?, ?> b16 = aaVar.b();
                                                            if (b16 != null) {
                                                                floatValue = ((Number) r12.guideViewHeight$delegate.getValue(NBPGuideTagPickPage.this, NBPGuideTagPickPage.$$delegatedProperties[1])).floatValue();
                                                                ScrollerView.setContentInsetWhenEndDrag$default(b16, floatValue, 0.0f, 0.0f, 0.0f, 14, null);
                                                            }
                                                            NBPGuideTagPickPage.this.exit = true;
                                                        } else {
                                                            aa<aq<?, ?>> aaVar3 = NBPGuideTagPickPage.this.listViewRef;
                                                            if (aaVar3 != null) {
                                                                aaVar = aaVar3;
                                                            } else {
                                                                Intrinsics.throwUninitializedPropertyAccessException("listViewRef");
                                                            }
                                                            aq<?, ?> b17 = aaVar.b();
                                                            if (b17 != null) {
                                                                ScrollerView.setContentInsetWhenEndDrag$default(b17, 0.0f, 0.0f, 0.0f, 0.0f, 14, null);
                                                            }
                                                            NBPGuideTagPickPage.this.exit = false;
                                                        }
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final NBPGuideTagPickPage nBPGuideTagPickPage11 = NBPGuideTagPickPage.this;
                                                apVar2.dragEnd(new Function1<ScrollParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.NBPGuideTagPickPage.body.1.1.3.2.3.3
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ScrollParams scrollParams) {
                                                        if (NBPGuideTagPickPage.this.exit) {
                                                            ap apVar3 = apVar2;
                                                            C32111 c32111 = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.NBPGuideTagPickPage.body.1.1.3.2.3.3.1
                                                                @Override // kotlin.jvm.functions.Function0
                                                                public final Unit invoke() {
                                                                    QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
                                                                    QQKuiklyPlatformApi.Companion.closePage$default();
                                                                    return Unit.INSTANCE;
                                                                }
                                                            };
                                                            KProperty<Object>[] kPropertyArr = IPagerIdKtxKt.$$delegatedProperties;
                                                            TimerKt.e(apVar3.getPagerId(), 200, c32111);
                                                        }
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                apVar2.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.NBPGuideTagPickPage.body.1.1.3.2.3.4
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final /* bridge */ /* synthetic */ Unit invoke(ClickParams clickParams) {
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final NBPGuideTagPickPage nBPGuideTagPickPage9 = NBPGuideTagPickPage.this;
                                        w.a(aqVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.NBPGuideTagPickPage.body.1.1.3.2.4
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(v vVar3) {
                                                v vVar4 = vVar3;
                                                vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.NBPGuideTagPickPage.body.1.1.3.2.4.1
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
                                                final NBPGuideTagPickPage nBPGuideTagPickPage10 = NBPGuideTagPickPage.this;
                                                vVar4.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.NBPGuideTagPickPage.body.1.1.3.2.4.2
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(u uVar) {
                                                        final NBPGuideTagPickPage nBPGuideTagPickPage11 = NBPGuideTagPickPage.this;
                                                        FrameEventKt.d(uVar, new Function1<d, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.NBPGuideTagPickPage.body.1.1.3.2.4.2.1
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(d dVar) {
                                                                NBPGuideTagPickPage nBPGuideTagPickPage12 = NBPGuideTagPickPage.this;
                                                                nBPGuideTagPickPage12.guideViewHeight$delegate.setValue(nBPGuideTagPickPage12, NBPGuideTagPickPage.$$delegatedProperties[1], Float.valueOf(dVar.getHeight()));
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                w.a(vVar4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.NBPGuideTagPickPage.body.1.1.3.2.4.3
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(v vVar5) {
                                                        v vVar6 = vVar5;
                                                        vVar6.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.NBPGuideTagPickPage.body.1.1.3.2.4.3.1
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(t tVar) {
                                                                t tVar2 = tVar;
                                                                tVar2.allCenter();
                                                                tVar2.paddingTop(4.5f);
                                                                tVar2.paddingBottom(4.5f);
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        w.a(vVar6, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.NBPGuideTagPickPage.body.1.1.3.2.4.3.2
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(v vVar7) {
                                                                vVar7.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.NBPGuideTagPickPage.body.1.1.3.2.4.3.2.1
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
                                                cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.NBPGuideTagPickPage.body.1.1.3.2.4.4
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(TextView textView) {
                                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.NBPGuideTagPickPage.body.1.1.3.2.4.4.1
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ce ceVar) {
                                                                ce ceVar2 = ceVar;
                                                                ceVar2.marginTop(24.0f);
                                                                ce.fontSize$default(ceVar2, 18.0f, null, 2, null);
                                                                ceVar2.fontWeight500();
                                                                ceVar2.color(QUIToken.color$default("text_primary"));
                                                                ceVar2.text("\u9009\u62e9\u5174\u8da3\u6807\u7b7e\uff0c\u53d1\u73b0\u540c\u597d\u5185\u5bb9");
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                w.a(vVar4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.NBPGuideTagPickPage.body.1.1.3.2.4.5
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(v vVar5) {
                                                        v vVar6 = vVar5;
                                                        vVar6.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.NBPGuideTagPickPage.body.1.1.3.2.4.5.1
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(t tVar) {
                                                                t tVar2 = tVar;
                                                                tVar2.marginTop(4.0f);
                                                                tVar2.flexDirectionRow();
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        cg.a(vVar6, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.NBPGuideTagPickPage.body.1.1.3.2.4.5.2
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(TextView textView) {
                                                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.NBPGuideTagPickPage.body.1.1.3.2.4.5.2.1
                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(ce ceVar) {
                                                                        ce ceVar2 = ceVar;
                                                                        ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                                                        ceVar2.fontWeight400();
                                                                        ceVar2.color(QUIToken.color$default("text_secondary"));
                                                                        ceVar2.text("\u9009\u62e9");
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        cg.a(vVar6, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.NBPGuideTagPickPage.body.1.1.3.2.4.5.3
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(TextView textView) {
                                                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.NBPGuideTagPickPage.body.1.1.3.2.4.5.3.1
                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(ce ceVar) {
                                                                        ce ceVar2 = ceVar;
                                                                        ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                                                        ceVar2.fontWeight400();
                                                                        ceVar2.color(QUIToken.color$default("brand_standard"));
                                                                        ceVar2.text("3");
                                                                        ceVar2.marginLeft(2.0f);
                                                                        ceVar2.marginRight(2.0f);
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        cg.a(vVar6, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.NBPGuideTagPickPage.body.1.1.3.2.4.5.4
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(TextView textView) {
                                                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.NBPGuideTagPickPage.body.1.1.3.2.4.5.4.1
                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(ce ceVar) {
                                                                        ce ceVar2 = ceVar;
                                                                        ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                                                        ceVar2.fontWeight400();
                                                                        ceVar2.color(QUIToken.color$default("text_secondary"));
                                                                        ceVar2.text("\u4e2a\u4ee5\u4e0a\u6807\u7b7e\uff0c\u53d1\u73b0\u66f4\u591a\u540c\u597d\u5185\u5bb9");
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final NBPGuideTagPickPage nBPGuideTagPickPage11 = NBPGuideTagPickPage.this;
                                                vVar4.addChild(new NBPGuideTagPickerView(), new Function1<NBPGuideTagPickerView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.NBPGuideTagPickPage.body.1.1.3.2.4.6
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(NBPGuideTagPickerView nBPGuideTagPickerView) {
                                                        final NBPGuideTagPickPage nBPGuideTagPickPage12 = NBPGuideTagPickPage.this;
                                                        nBPGuideTagPickerView.attr(new Function1<NBPGuideTagPickerAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.NBPGuideTagPickPage.body.1.1.3.2.4.6.1
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(NBPGuideTagPickerAttr nBPGuideTagPickerAttr) {
                                                                NBPGuideTagPickerAttr nBPGuideTagPickerAttr2 = nBPGuideTagPickerAttr;
                                                                nBPGuideTagPickerAttr2.marginTop(24.0f);
                                                                NBPGuideTagPickPage nBPGuideTagPickPage13 = NBPGuideTagPickPage.this;
                                                                com.tencent.kuikly.core.reactive.collection.c cVar = (com.tencent.kuikly.core.reactive.collection.c) nBPGuideTagPickPage13.tagList$delegate.getValue(nBPGuideTagPickPage13, NBPGuideTagPickPage.$$delegatedProperties[3]);
                                                                ReadWriteProperty readWriteProperty = nBPGuideTagPickerAttr2.tagList$delegate;
                                                                KProperty<?>[] kPropertyArr = NBPGuideTagPickerAttr.$$delegatedProperties;
                                                                readWriteProperty.setValue(nBPGuideTagPickerAttr2, kPropertyArr[0], cVar);
                                                                nBPGuideTagPickerAttr2.selectedTagList$delegate.setValue(nBPGuideTagPickerAttr2, kPropertyArr[1], NBPGuideTagPickPage.this.getSelectedTagList());
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final NBPGuideTagPickPage nBPGuideTagPickPage12 = NBPGuideTagPickPage.this;
                                                w.a(vVar4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.NBPGuideTagPickPage.body.1.1.3.2.4.7
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(v vVar5) {
                                                        v vVar6 = vVar5;
                                                        vVar6.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.NBPGuideTagPickPage.body.1.1.3.2.4.7.1
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(t tVar) {
                                                                t tVar2 = tVar;
                                                                tVar2.marginTop(32.0f);
                                                                tVar2.marginBottom(30.0f);
                                                                tVar2.mo113backgroundColor(QUIToken.color$default("button_bg_primary_default"));
                                                                tVar2.borderRadius(4.0f);
                                                                tVar2.size(168.0f, 45.0f);
                                                                tVar2.allCenter();
                                                                tVar2.mo113backgroundColor(QUIToken.color$default("button_bg_primary_default"));
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        cg.a(vVar6, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.NBPGuideTagPickPage.body.1.1.3.2.4.7.2
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(TextView textView) {
                                                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.NBPGuideTagPickPage.body.1.1.3.2.4.7.2.1
                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(ce ceVar) {
                                                                        ce ceVar2 = ceVar;
                                                                        ce.fontSize$default(ceVar2, 17.0f, null, 2, null);
                                                                        ceVar2.fontWeight500();
                                                                        ceVar2.color(QUIToken.color$default("button_text_primary_default"));
                                                                        ceVar2.text("\u5b8c\u6210");
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        final NBPGuideTagPickPage nBPGuideTagPickPage13 = NBPGuideTagPickPage.this;
                                                        vVar6.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.NBPGuideTagPickPage.body.1.1.3.2.4.7.3
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(u uVar) {
                                                                u uVar2 = uVar;
                                                                final NBPGuideTagPickPage nBPGuideTagPickPage14 = NBPGuideTagPickPage.this;
                                                                uVar2.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.NBPGuideTagPickPage.body.1.1.3.2.4.7.3.1
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    /* JADX WARN: Code restructure failed: missing block: B:26:0x0119, code lost:
                                                                    
                                                                        r11 = kotlin.text.StringsKt__StringsJVMKt.encodeToByteArray(r11);
                                                                     */
                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    /*
                                                                        Code decompiled incorrectly, please refer to instructions dump.
                                                                    */
                                                                    public final Unit invoke(ClickParams clickParams) {
                                                                        int collectionSizeOrDefault;
                                                                        byte[] encodeToByteArray;
                                                                        byte[][] bArr;
                                                                        byte[] encodeToByteArray2;
                                                                        int collectionSizeOrDefault2;
                                                                        List mutableList;
                                                                        NBPGuideTagPickPage nBPGuideTagPickPage15 = NBPGuideTagPickPage.this;
                                                                        e eVar = nBPGuideTagPickPage15.pageParams;
                                                                        eVar.v("dt_eid", "em_nearby_interest_choose_pop");
                                                                        eVar.v(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
                                                                        Utils.INSTANCE.currentBridgeModule().reportCustomDtEvent("dt_clck", eVar);
                                                                        if (nBPGuideTagPickPage15.getSelectedTagList().size() > 0) {
                                                                            com.tencent.kuikly.core.reactive.collection.c<a> selectedTagList = nBPGuideTagPickPage15.getSelectedTagList();
                                                                            collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(selectedTagList, 10);
                                                                            ArrayList arrayList = new ArrayList(collectionSizeOrDefault2);
                                                                            Iterator<a> it = selectedTagList.iterator();
                                                                            while (it.hasNext()) {
                                                                                arrayList.add(Integer.valueOf(it.next().f435362d));
                                                                            }
                                                                            NBPGuideTagPickPage$onHandleComplete$3 nBPGuideTagPickPage$onHandleComplete$3 = new Function1<ae, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.NBPGuideTagPickPage$onHandleComplete$3
                                                                                @Override // kotlin.jvm.functions.Function1
                                                                                public final Unit invoke(ae aeVar) {
                                                                                    KLog.INSTANCE.i("NBPGuideTagPickPage", "updateTagsInfo success");
                                                                                    return Unit.INSTANCE;
                                                                                }
                                                                            };
                                                                            NBPGuideTagPickPage$onHandleComplete$4 nBPGuideTagPickPage$onHandleComplete$4 = NBPGuideTagPickPage$onHandleComplete$4.INSTANCE;
                                                                            if (QQKuiklyPlatformApi.Companion.getNetworkType() != QQKuiklyPlatformApi.QQNetworkType.NOT_REACHABLE) {
                                                                                mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList);
                                                                                NBPArticleFeedItemView$body$1$3$8$1$2$1$$ExternalSyntheticOutline0.m(new APICallTechReporter(1, "trpc.qqstranger.common_proxy.CommonProxy.SsoHandle"), new QQStrangerSsoService$sendProxyRequest$1(new NBPNewHomeRepository$updateTagsInfo$1(2, nBPGuideTagPickPage$onHandleComplete$3, nBPGuideTagPickPage$onHandleComplete$4)), new QQStrangerSsoRequest(new u35.a("QQStranger.UserInfo", "SsoUpdateUserTags", 2, new c45.a(i.d(new ad(mutableList, 0, 0))))), null, 6);
                                                                            } else {
                                                                                nBPGuideTagPickPage$onHandleComplete$4.invoke(-1, "network unreachable");
                                                                            }
                                                                        }
                                                                        if (nBPGuideTagPickPage15.getSelectedTagList().size() >= 3) {
                                                                            e eVar2 = new e();
                                                                            com.tencent.kuikly.core.nvi.serialization.json.b bVar = new com.tencent.kuikly.core.nvi.serialization.json.b();
                                                                            com.tencent.kuikly.core.reactive.collection.c<a> selectedTagList2 = nBPGuideTagPickPage15.getSelectedTagList();
                                                                            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(selectedTagList2, 10);
                                                                            ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
                                                                            Iterator<a> it5 = selectedTagList2.iterator();
                                                                            while (it5.hasNext()) {
                                                                                arrayList2.add(bVar.t(i.c(it5.next())));
                                                                            }
                                                                            Unit unit = Unit.INSTANCE;
                                                                            eVar2.v("tagList", bVar);
                                                                            k kVar = nBPGuideTagPickPage15.oldUserConfig;
                                                                            eVar2.v("oldUserConfig", kVar != null ? i.c(kVar) : null);
                                                                            encodeToByteArray = StringsKt__StringsJVMKt.encodeToByteArray(eVar2.toString());
                                                                            e eVar3 = nBPGuideTagPickPage15.pageParams;
                                                                            QQNearbyModule companion = QQNearbyModule.Companion.getInstance();
                                                                            if (eVar3 != null && (r11 = eVar3.toString()) != null && encodeToByteArray2 != null) {
                                                                                bArr = new byte[][]{encodeToByteArray, encodeToByteArray2};
                                                                            } else {
                                                                                bArr = new byte[][]{encodeToByteArray};
                                                                            }
                                                                            companion.setSharePenetratePageData(bArr);
                                                                            QQKuiklyPlatformApi.Companion companion2 = QQKuiklyPlatformApi.Companion;
                                                                            QQKuiklyPlatformApi.Companion.openPage$default("mqqapi://kuikly/open?version=1&src_type=app&page_name=nearbypro_guide_tag_publish&modal_mode=1", true, 4);
                                                                        } else {
                                                                            QQKuiklyPlatformApi.Companion companion3 = QQKuiklyPlatformApi.Companion;
                                                                            QQKuiklyPlatformApi.Companion.closePage$default();
                                                                        }
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                final NBPGuideTagPickPage nBPGuideTagPickPage15 = NBPGuideTagPickPage.this;
                                                                VisibilityEventKt.b(uVar2, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.NBPGuideTagPickPage.body.1.1.3.2.4.7.3.2
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(Object obj) {
                                                                        e eVar = NBPGuideTagPickPage.this.pageParams;
                                                                        eVar.v("dt_eid", "em_nearby_interest_choose_pop");
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
                        return Unit.INSTANCE;
                    }
                });
                return Unit.INSTANCE;
            }
        };
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.BasePager, com.tencent.kuikly.core.base.ComposeView
    public final void created() {
        List<t35.b> list;
        Object firstOrNull;
        List<a> list2;
        int collectionSizeOrDefault;
        Object firstOrNull2;
        Object orNull;
        e eVar;
        String decodeToString;
        super.created();
        Object[] sharePenetratePageData = QQNearbyModule.Companion.getInstance().getSharePenetratePageData();
        if (sharePenetratePageData != null) {
            firstOrNull2 = ArraysKt___ArraysKt.firstOrNull(sharePenetratePageData);
            byte[] bArr = firstOrNull2 instanceof byte[] ? (byte[]) firstOrNull2 : null;
            this.oldUserConfig = bArr != null ? (k) i.b(new k(false, null, null, null, 15, null), bArr) : null;
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
        k kVar = this.oldUserConfig;
        if (kVar == null || (list = kVar.f397817e) == null) {
            return;
        }
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) list);
        t35.b bVar = (t35.b) firstOrNull;
        if (bVar == null || (list2 = bVar.f435370f) == null) {
            return;
        }
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(Boolean.valueOf(((com.tencent.kuikly.core.reactive.collection.c) this.tagList$delegate.getValue(this, $$delegatedProperties[3])).add((a) it.next())));
        }
    }

    public final com.tencent.kuikly.core.reactive.collection.c<a> getSelectedTagList() {
        return (com.tencent.kuikly.core.reactive.collection.c) this.selectedTagList$delegate.getValue(this, $$delegatedProperties[4]);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.BasePager, com.tencent.kuikly.core.pager.Pager
    public final void pageWillDestroy() {
        super.pageWillDestroy();
        com.tencent.kuikly.core.module.k kVar = (com.tencent.kuikly.core.module.k) com.tencent.kuikly.core.manager.c.f117352a.g().acquireModule("KRNotifyModule");
        e m3 = AdelieCategoryHomePage$$ExternalSyntheticOutline0.m("pageName", "nearbypro_guide_tag_pick");
        Unit unit = Unit.INSTANCE;
        com.tencent.kuikly.core.module.k.d(kVar, "NBP_KUIKLY_PAGE_WILL_DESTORY_EVENT", m3, false, 4, null);
    }
}
