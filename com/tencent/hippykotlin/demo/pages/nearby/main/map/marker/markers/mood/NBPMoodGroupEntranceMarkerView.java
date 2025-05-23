package com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.mood;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.superResolution.LoadFailParams$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.hippykotlin.demo.pages.foundation.view.APNGAttr;
import com.tencent.hippykotlin.demo.pages.foundation.view.APNGVView;
import com.tencent.hippykotlin.demo.pages.foundation.view.APNGViewKt;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyConstKt;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.TextViewExtKt;
import com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPMainKtxKt;
import com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.base.MarkerViewExtKt;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.aa;
import com.tencent.kuikly.core.base.attr.AccessibilityRole;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.attr.d;
import com.tencent.kuikly.core.base.b;
import com.tencent.kuikly.core.base.event.AnimationCompletionParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.event.FrameEventKt;
import com.tencent.kuikly.core.base.g;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.l;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.base.t;
import com.tencent.kuikly.core.base.y;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.module.k;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ah;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.u;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import w25.a;

/* loaded from: classes31.dex */
public final class NBPMoodGroupEntranceMarkerView extends ComposeView<NBPMoodGroupEntranceAttr, l> {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPMoodGroupEntranceMarkerView.class, "text", "getText()Ljava/lang/String;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPMoodGroupEntranceMarkerView.class, "color", "getColor()J", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPMoodGroupEntranceMarkerView.class, "animationRotate", "getAnimationRotate()F", 0)};
    public final Lazy animationRotateGroup$delegate;
    public int animationRotateIndex;
    public final ReadWriteProperty text$delegate = c.a("");
    public final ReadWriteProperty color$delegate = c.a(0L);
    public final ReadWriteProperty animationRotate$delegate = c.a(Float.valueOf(0.0f));

    public NBPMoodGroupEntranceMarkerView() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Float[]>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.mood.NBPMoodGroupEntranceMarkerView$animationRotateGroup$2
            @Override // kotlin.jvm.functions.Function0
            public final Float[] invoke() {
                Float valueOf = Float.valueOf(5.0f);
                Float valueOf2 = Float.valueOf(-5.0f);
                return new Float[]{Float.valueOf(0.0f), valueOf, valueOf2, valueOf, valueOf2, valueOf};
            }
        });
        this.animationRotateGroup$delegate = lazy;
    }

    public static final Float[] access$getAnimationRotateGroup(NBPMoodGroupEntranceMarkerView nBPMoodGroupEntranceMarkerView) {
        return (Float[]) nBPMoodGroupEntranceMarkerView.animationRotateGroup$delegate.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ NBPMoodGroupEntranceAttr access$getAttr(NBPMoodGroupEntranceMarkerView nBPMoodGroupEntranceMarkerView) {
        return (NBPMoodGroupEntranceAttr) nBPMoodGroupEntranceMarkerView.getAttr();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        final NBPMoodGroupEntranceMarkerViewModel viewModel = ((NBPMoodGroupEntranceAttr) getAttr()).getViewModel();
        final a aVar = viewModel.entrance;
        NBPMoodGroupEntranceUIConfig nBPMoodGroupEntranceUIConfig = NBPMoodGroupEntranceUIConfig.INSTANCE;
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.mood.NBPMoodGroupEntranceMarkerView$body$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                final NBPMoodGroupEntranceMarkerView nBPMoodGroupEntranceMarkerView = NBPMoodGroupEntranceMarkerView.this;
                final NBPMoodGroupEntranceMarkerViewModel nBPMoodGroupEntranceMarkerViewModel = viewModel;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.mood.NBPMoodGroupEntranceMarkerView$body$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        mVar2.size(160.0f, 81.0f);
                        mVar2.flexDirectionColumn();
                        mVar2.alignItemsCenter();
                        mVar2.justifyContentFlexEnd();
                        mVar2.accessibility("\u60c5\u7eea\u5708\u5b50\u5165\u53e3");
                        mVar2.accessibilityRole(AccessibilityRole.BUTTON);
                        NBPMainKtxKt.boxShadowWithBlackSet$default(mVar2, new g(0.0f, 8.0f, 10.0f, h.INSTANCE.a(0.16f)));
                        NBPMoodGroupEntranceMarkerView nBPMoodGroupEntranceMarkerView2 = NBPMoodGroupEntranceMarkerView.this;
                        ReadWriteProperty readWriteProperty = nBPMoodGroupEntranceMarkerView2.animationRotate$delegate;
                        KProperty<?>[] kPropertyArr = NBPMoodGroupEntranceMarkerView.$$delegatedProperties;
                        d.a.a(mVar2, new t(((Number) readWriteProperty.getValue(nBPMoodGroupEntranceMarkerView2, kPropertyArr[2])).floatValue(), 0.0f, 0.0f, 6, null), null, null, nBPMoodGroupEntranceMarkerViewModel.anchor, null, 22, null);
                        b l3 = b.Companion.l(b.INSTANCE, 0.05f, null, 2, null);
                        NBPMoodGroupEntranceMarkerView nBPMoodGroupEntranceMarkerView3 = NBPMoodGroupEntranceMarkerView.this;
                        mVar2.m134animation(l3, (Object) Float.valueOf(((Number) nBPMoodGroupEntranceMarkerView3.animationRotate$delegate.getValue(nBPMoodGroupEntranceMarkerView3, kPropertyArr[2])).floatValue()));
                        return Unit.INSTANCE;
                    }
                });
                final NBPMoodGroupEntranceMarkerView nBPMoodGroupEntranceMarkerView2 = NBPMoodGroupEntranceMarkerView.this;
                viewContainer2.event(new Function1<Event, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.mood.NBPMoodGroupEntranceMarkerView$body$1.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Event event) {
                        final NBPMoodGroupEntranceMarkerView nBPMoodGroupEntranceMarkerView3 = NBPMoodGroupEntranceMarkerView.this;
                        event.animationCompletion(new Function1<AnimationCompletionParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.mood.NBPMoodGroupEntranceMarkerView.body.1.2.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(AnimationCompletionParams animationCompletionParams) {
                                int lastIndex;
                                KLog.INSTANCE.d("NBPMoodGroupEntranceMarkerView", "Entrance animationCompletion");
                                NBPMoodGroupEntranceMarkerView nBPMoodGroupEntranceMarkerView4 = NBPMoodGroupEntranceMarkerView.this;
                                int i3 = nBPMoodGroupEntranceMarkerView4.animationRotateIndex;
                                if (i3 != 0) {
                                    lastIndex = ArraysKt___ArraysKt.getLastIndex(NBPMoodGroupEntranceMarkerView.access$getAnimationRotateGroup(nBPMoodGroupEntranceMarkerView4));
                                    if (i3 == lastIndex) {
                                        NBPMoodGroupEntranceMarkerView nBPMoodGroupEntranceMarkerView5 = NBPMoodGroupEntranceMarkerView.this;
                                        nBPMoodGroupEntranceMarkerView5.animationRotateIndex = 0;
                                        nBPMoodGroupEntranceMarkerView5.animationRotate$delegate.setValue(nBPMoodGroupEntranceMarkerView5, NBPMoodGroupEntranceMarkerView.$$delegatedProperties[2], Float.valueOf(NBPMoodGroupEntranceMarkerView.access$getAnimationRotateGroup(nBPMoodGroupEntranceMarkerView5)[0].floatValue()));
                                    } else {
                                        NBPMoodGroupEntranceMarkerView nBPMoodGroupEntranceMarkerView6 = NBPMoodGroupEntranceMarkerView.this;
                                        nBPMoodGroupEntranceMarkerView6.animationRotateIndex++;
                                        nBPMoodGroupEntranceMarkerView6.animationRotate$delegate.setValue(nBPMoodGroupEntranceMarkerView6, NBPMoodGroupEntranceMarkerView.$$delegatedProperties[2], Float.valueOf(NBPMoodGroupEntranceMarkerView.access$getAnimationRotateGroup(nBPMoodGroupEntranceMarkerView6)[NBPMoodGroupEntranceMarkerView.this.animationRotateIndex].floatValue()));
                                    }
                                }
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final NBPMoodGroupEntranceMarkerViewModel nBPMoodGroupEntranceMarkerViewModel2 = viewModel;
                final NBPMoodGroupEntranceMarkerView nBPMoodGroupEntranceMarkerView3 = NBPMoodGroupEntranceMarkerView.this;
                final a aVar2 = aVar;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.mood.NBPMoodGroupEntranceMarkerView$body$1.3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        final NBPMoodGroupEntranceMarkerViewModel nBPMoodGroupEntranceMarkerViewModel3 = NBPMoodGroupEntranceMarkerViewModel.this;
                        vVar2.attr(new Function1<com.tencent.kuikly.core.views.t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.mood.NBPMoodGroupEntranceMarkerView.body.1.3.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(com.tencent.kuikly.core.views.t tVar) {
                                com.tencent.kuikly.core.views.t tVar2 = tVar;
                                tVar2.size(160.0f, 81.0f);
                                MarkerViewExtKt.bindMarkerStatusChange(tVar2, NBPMoodGroupEntranceMarkerViewModel.this, 0.0f);
                                tVar2.flexDirectionColumn();
                                tVar2.alignItemsCenter();
                                tVar2.justifyContentFlexEnd();
                                return Unit.INSTANCE;
                            }
                        });
                        final NBPMoodGroupEntranceMarkerViewModel nBPMoodGroupEntranceMarkerViewModel4 = NBPMoodGroupEntranceMarkerViewModel.this;
                        vVar2.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.mood.NBPMoodGroupEntranceMarkerView.body.1.3.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(u uVar) {
                                final NBPMoodGroupEntranceMarkerViewModel nBPMoodGroupEntranceMarkerViewModel5 = NBPMoodGroupEntranceMarkerViewModel.this;
                                MarkerViewExtKt.bindMarkerPopShow(uVar, nBPMoodGroupEntranceMarkerViewModel5.anchor, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.mood.NBPMoodGroupEntranceMarkerView.body.1.3.2.1
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public final Unit invoke() {
                                        NBPMoodGroupEntranceMarkerViewModel.this.readyToFocus = true;
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final NBPMoodGroupEntranceMarkerViewModel nBPMoodGroupEntranceMarkerViewModel5 = NBPMoodGroupEntranceMarkerViewModel.this;
                        Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.mood.NBPMoodGroupEntranceMarkerView.body.1.3.3
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Boolean.valueOf(NBPMoodGroupEntranceMarkerViewModel.this.config.moodBgUrl.length() > 0);
                            }
                        };
                        final NBPMoodGroupEntranceMarkerViewModel nBPMoodGroupEntranceMarkerViewModel6 = NBPMoodGroupEntranceMarkerViewModel.this;
                        ConditionViewKt.c(vVar2, function0, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.mood.NBPMoodGroupEntranceMarkerView.body.1.3.4
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ConditionView conditionView) {
                                final NBPMoodGroupEntranceMarkerViewModel nBPMoodGroupEntranceMarkerViewModel7 = NBPMoodGroupEntranceMarkerViewModel.this;
                                ah.a(conditionView, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.mood.NBPMoodGroupEntranceMarkerView.body.1.3.4.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ImageView imageView) {
                                        final NBPMoodGroupEntranceMarkerViewModel nBPMoodGroupEntranceMarkerViewModel8 = NBPMoodGroupEntranceMarkerViewModel.this;
                                        imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.mood.NBPMoodGroupEntranceMarkerView.body.1.3.4.1.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(af afVar) {
                                                af afVar2 = afVar;
                                                b.a.b(afVar2, NBPMoodGroupEntranceMarkerViewModel.this.config.moodBgUrl, false, 2, null);
                                                afVar2.mo153width(NBPMoodGroupEntranceMarkerViewModel.this.config.moodBgWidth);
                                                afVar2.mo141height(NBPMoodGroupEntranceMarkerViewModel.this.config.moodBgHeight);
                                                afVar2.absolutePositionAllZero();
                                                afVar2.m147opacity(0.0f);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final NBPMoodGroupEntranceMarkerViewModel nBPMoodGroupEntranceMarkerViewModel7 = NBPMoodGroupEntranceMarkerViewModel.this;
                        final NBPMoodGroupEntranceMarkerView nBPMoodGroupEntranceMarkerView4 = nBPMoodGroupEntranceMarkerView3;
                        final a aVar3 = aVar2;
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.mood.NBPMoodGroupEntranceMarkerView.body.1.3.5
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                v vVar4 = vVar3;
                                vVar4.attr(new Function1<com.tencent.kuikly.core.views.t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.mood.NBPMoodGroupEntranceMarkerView.body.1.3.5.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(com.tencent.kuikly.core.views.t tVar) {
                                        com.tencent.kuikly.core.views.t tVar2 = tVar;
                                        tVar2.mo153width(160.0f);
                                        tVar2.mo141height(76.0f);
                                        tVar2.borderRadius(8.0f);
                                        tVar2.mo113backgroundColor(h.INSTANCE.m());
                                        tVar2.flexDirectionRow();
                                        tVar2.overflow(true);
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPMoodGroupEntranceMarkerViewModel nBPMoodGroupEntranceMarkerViewModel8 = NBPMoodGroupEntranceMarkerViewModel.this;
                                w.a(vVar4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.mood.NBPMoodGroupEntranceMarkerView.body.1.3.5.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar5) {
                                        v vVar6 = vVar5;
                                        vVar6.attr(new Function1<com.tencent.kuikly.core.views.t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.mood.NBPMoodGroupEntranceMarkerView.body.1.3.5.2.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(com.tencent.kuikly.core.views.t tVar) {
                                                com.tencent.kuikly.core.views.t tVar2 = tVar;
                                                tVar2.mo153width(54.0f);
                                                tVar2.mo141height(76.0f);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final NBPMoodGroupEntranceMarkerViewModel nBPMoodGroupEntranceMarkerViewModel9 = NBPMoodGroupEntranceMarkerViewModel.this;
                                        ah.a(vVar6, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.mood.NBPMoodGroupEntranceMarkerView.body.1.3.5.2.2
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ImageView imageView) {
                                                final NBPMoodGroupEntranceMarkerViewModel nBPMoodGroupEntranceMarkerViewModel10 = NBPMoodGroupEntranceMarkerViewModel.this;
                                                imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.mood.NBPMoodGroupEntranceMarkerView.body.1.3.5.2.2.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(af afVar) {
                                                        af afVar2 = afVar;
                                                        afVar2.mo153width(54.0f);
                                                        afVar2.mo141height(76.0f);
                                                        b.a.b(afVar2, NBPMoodGroupEntranceMarkerViewModel.this.config.iconBgUrl, false, 2, null);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPMoodGroupEntranceMarkerView nBPMoodGroupEntranceMarkerView5 = nBPMoodGroupEntranceMarkerView4;
                                final NBPMoodGroupEntranceMarkerViewModel nBPMoodGroupEntranceMarkerViewModel9 = NBPMoodGroupEntranceMarkerViewModel.this;
                                final a aVar4 = aVar3;
                                w.a(vVar4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.mood.NBPMoodGroupEntranceMarkerView.body.1.3.5.3
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar5) {
                                        String sb5;
                                        v vVar6 = vVar5;
                                        vVar6.attr(new Function1<com.tencent.kuikly.core.views.t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.mood.NBPMoodGroupEntranceMarkerView.body.1.3.5.3.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(com.tencent.kuikly.core.views.t tVar) {
                                                com.tencent.kuikly.core.views.t tVar2 = tVar;
                                                tVar2.flexDirectionColumn();
                                                tVar2.paddingTop(7.0f);
                                                tVar2.paddingLeft(8.0f);
                                                tVar2.paddingRight(8.0f);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final a aVar5 = aVar4;
                                        cg.a(vVar6, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.mood.NBPMoodGroupEntranceMarkerView.body.1.3.5.3.2
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(TextView textView) {
                                                final a aVar6 = a.this;
                                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.mood.NBPMoodGroupEntranceMarkerView.body.1.3.5.3.2.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ce ceVar) {
                                                        ce ceVar2 = ceVar;
                                                        ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                                        ceVar2.lineHeight(20.0f);
                                                        ceVar2.color(h.INSTANCE.b());
                                                        ceVar2.fontWeight400();
                                                        TextViewExtKt.textWithLineHeightFix(ceVar2, a.this.f444470m);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final a aVar6 = aVar4;
                                        cg.a(vVar6, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.mood.NBPMoodGroupEntranceMarkerView.body.1.3.5.3.3
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(TextView textView) {
                                                final a aVar7 = a.this;
                                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.mood.NBPMoodGroupEntranceMarkerView.body.1.3.5.3.3.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ce ceVar) {
                                                        ce ceVar2 = ceVar;
                                                        ce.fontSize$default(ceVar2, 10.0f, null, 2, null);
                                                        ceVar2.lineHeight(14.0f);
                                                        ceVar2.fontWeight400();
                                                        ceVar2.lines(1);
                                                        ceVar2.color(QUIToken.color$default("text_secondary"));
                                                        TextViewExtKt.textWithLineHeightFix(ceVar2, a.this.C);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        NBPMoodGroupEntranceMarkerView nBPMoodGroupEntranceMarkerView6 = NBPMoodGroupEntranceMarkerView.this;
                                        w25.g gVar = nBPMoodGroupEntranceMarkerViewModel9.entranceRsp.f444476e;
                                        if ((gVar != null ? gVar.f444489e : null) != null) {
                                            sb5 = LoadFailParams$$ExternalSyntheticOutline0.m(new StringBuilder(), aVar4.H, '\u4e2d');
                                        } else {
                                            StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("\u52a0\u5165");
                                            m3.append(aVar4.H);
                                            sb5 = m3.toString();
                                        }
                                        ReadWriteProperty readWriteProperty = nBPMoodGroupEntranceMarkerView6.text$delegate;
                                        KProperty<?>[] kPropertyArr = NBPMoodGroupEntranceMarkerView.$$delegatedProperties;
                                        readWriteProperty.setValue(nBPMoodGroupEntranceMarkerView6, kPropertyArr[0], sb5);
                                        NBPMoodGroupEntranceMarkerView nBPMoodGroupEntranceMarkerView7 = NBPMoodGroupEntranceMarkerView.this;
                                        w25.g gVar2 = nBPMoodGroupEntranceMarkerViewModel9.entranceRsp.f444476e;
                                        nBPMoodGroupEntranceMarkerView7.color$delegate.setValue(nBPMoodGroupEntranceMarkerView7, kPropertyArr[1], Long.valueOf((gVar2 != null ? gVar2.f444489e : null) != null ? 4291611852L : 4278229503L));
                                        final NBPMoodGroupEntranceMarkerView nBPMoodGroupEntranceMarkerView8 = NBPMoodGroupEntranceMarkerView.this;
                                        Function0<Object> function02 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.mood.NBPMoodGroupEntranceMarkerView.body.1.3.5.3.4
                                            {
                                                super(0);
                                            }

                                            @Override // kotlin.jvm.functions.Function0
                                            public final Object invoke() {
                                                NBPMoodGroupEntranceAttr access$getAttr = NBPMoodGroupEntranceMarkerView.access$getAttr(NBPMoodGroupEntranceMarkerView.this);
                                                return Boolean.valueOf(((Boolean) access$getAttr.joinedMood$delegate.getValue(access$getAttr, NBPMoodGroupEntranceAttr.$$delegatedProperties[0])).booleanValue());
                                            }
                                        };
                                        final NBPMoodGroupEntranceMarkerView nBPMoodGroupEntranceMarkerView9 = NBPMoodGroupEntranceMarkerView.this;
                                        final a aVar7 = aVar4;
                                        ConditionViewKt.c(vVar6, function02, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.mood.NBPMoodGroupEntranceMarkerView.body.1.3.5.3.5
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ConditionView conditionView) {
                                                NBPMoodGroupEntranceMarkerView nBPMoodGroupEntranceMarkerView10 = NBPMoodGroupEntranceMarkerView.this;
                                                String m16 = LoadFailParams$$ExternalSyntheticOutline0.m(new StringBuilder(), aVar7.H, '\u4e2d');
                                                ReadWriteProperty readWriteProperty2 = nBPMoodGroupEntranceMarkerView10.text$delegate;
                                                KProperty<?>[] kPropertyArr2 = NBPMoodGroupEntranceMarkerView.$$delegatedProperties;
                                                readWriteProperty2.setValue(nBPMoodGroupEntranceMarkerView10, kPropertyArr2[0], m16);
                                                NBPMoodGroupEntranceMarkerView nBPMoodGroupEntranceMarkerView11 = NBPMoodGroupEntranceMarkerView.this;
                                                nBPMoodGroupEntranceMarkerView11.color$delegate.setValue(nBPMoodGroupEntranceMarkerView11, kPropertyArr2[1], 4291611852L);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final NBPMoodGroupEntranceMarkerViewModel nBPMoodGroupEntranceMarkerViewModel10 = nBPMoodGroupEntranceMarkerViewModel9;
                                        final NBPMoodGroupEntranceMarkerView nBPMoodGroupEntranceMarkerView10 = NBPMoodGroupEntranceMarkerView.this;
                                        w.a(vVar6, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.mood.NBPMoodGroupEntranceMarkerView.body.1.3.5.3.6
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(v vVar7) {
                                                v vVar8 = vVar7;
                                                final NBPMoodGroupEntranceMarkerViewModel nBPMoodGroupEntranceMarkerViewModel11 = NBPMoodGroupEntranceMarkerViewModel.this;
                                                vVar8.ref(vVar8, new Function1<aa<v>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.mood.NBPMoodGroupEntranceMarkerView.body.1.3.5.3.6.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(aa<v> aaVar) {
                                                        NBPMoodGroupEntranceMarkerViewModel.this.joinBtnRef = aaVar;
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                vVar8.attr(new Function1<com.tencent.kuikly.core.views.t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.mood.NBPMoodGroupEntranceMarkerView.body.1.3.5.3.6.2
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(com.tencent.kuikly.core.views.t tVar) {
                                                        tVar.flexDirectionRow();
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final NBPMoodGroupEntranceMarkerView nBPMoodGroupEntranceMarkerView11 = nBPMoodGroupEntranceMarkerView10;
                                                final NBPMoodGroupEntranceMarkerViewModel nBPMoodGroupEntranceMarkerViewModel12 = NBPMoodGroupEntranceMarkerViewModel.this;
                                                w.a(vVar8, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.mood.NBPMoodGroupEntranceMarkerView.body.1.3.5.3.6.3
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(v vVar9) {
                                                        v vVar10 = vVar9;
                                                        final NBPMoodGroupEntranceMarkerView nBPMoodGroupEntranceMarkerView12 = NBPMoodGroupEntranceMarkerView.this;
                                                        vVar10.attr(new Function1<com.tencent.kuikly.core.views.t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.mood.NBPMoodGroupEntranceMarkerView.body.1.3.5.3.6.3.1
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(com.tencent.kuikly.core.views.t tVar) {
                                                                com.tencent.kuikly.core.views.t tVar2 = tVar;
                                                                tVar2.mo141height(22.0f);
                                                                tVar2.borderRadius(11.0f);
                                                                NBPMoodGroupEntranceMarkerView nBPMoodGroupEntranceMarkerView13 = NBPMoodGroupEntranceMarkerView.this;
                                                                tVar2.mo113backgroundColor(new h(((Number) nBPMoodGroupEntranceMarkerView13.color$delegate.getValue(nBPMoodGroupEntranceMarkerView13, NBPMoodGroupEntranceMarkerView.$$delegatedProperties[1])).longValue()));
                                                                tVar2.marginTop(6.0f);
                                                                tVar2.paddingLeft(8.0f);
                                                                tVar2.paddingRight(8.0f);
                                                                tVar2.allCenter();
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        final NBPMoodGroupEntranceMarkerViewModel nBPMoodGroupEntranceMarkerViewModel13 = nBPMoodGroupEntranceMarkerViewModel12;
                                                        vVar10.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.mood.NBPMoodGroupEntranceMarkerView.body.1.3.5.3.6.3.2
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(u uVar) {
                                                                final NBPMoodGroupEntranceMarkerViewModel nBPMoodGroupEntranceMarkerViewModel14 = NBPMoodGroupEntranceMarkerViewModel.this;
                                                                FrameEventKt.d(uVar, new Function1<com.tencent.kuikly.core.layout.d, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.mood.NBPMoodGroupEntranceMarkerView.body.1.3.5.3.6.3.2.1
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(com.tencent.kuikly.core.layout.d dVar) {
                                                                        NBPMoodGroupEntranceMarkerViewModel.this.getClass();
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        final NBPMoodGroupEntranceMarkerView nBPMoodGroupEntranceMarkerView13 = NBPMoodGroupEntranceMarkerView.this;
                                                        cg.a(vVar10, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.mood.NBPMoodGroupEntranceMarkerView.body.1.3.5.3.6.3.3
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(TextView textView) {
                                                                final NBPMoodGroupEntranceMarkerView nBPMoodGroupEntranceMarkerView14 = NBPMoodGroupEntranceMarkerView.this;
                                                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.mood.NBPMoodGroupEntranceMarkerView.body.1.3.5.3.6.3.3.1
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(ce ceVar) {
                                                                        ce ceVar2 = ceVar;
                                                                        ce.fontSize$default(ceVar2, 10.0f, null, 2, null);
                                                                        ceVar2.lineHeight(14.0f);
                                                                        ceVar2.color(h.INSTANCE.m());
                                                                        ceVar2.fontWeight400();
                                                                        NBPMoodGroupEntranceMarkerView nBPMoodGroupEntranceMarkerView15 = NBPMoodGroupEntranceMarkerView.this;
                                                                        TextViewExtKt.textWithLineHeightFix(ceVar2, (String) nBPMoodGroupEntranceMarkerView15.text$delegate.getValue(nBPMoodGroupEntranceMarkerView15, NBPMoodGroupEntranceMarkerView.$$delegatedProperties[0]));
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
                        final NBPMoodGroupEntranceMarkerViewModel nBPMoodGroupEntranceMarkerViewModel8 = NBPMoodGroupEntranceMarkerViewModel.this;
                        APNGViewKt.APNG(vVar2, new Function1<APNGVView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.mood.NBPMoodGroupEntranceMarkerView.body.1.3.6
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(APNGVView aPNGVView) {
                                final NBPMoodGroupEntranceMarkerViewModel nBPMoodGroupEntranceMarkerViewModel9 = NBPMoodGroupEntranceMarkerViewModel.this;
                                aPNGVView.attr(new Function1<APNGAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.mood.NBPMoodGroupEntranceMarkerView.body.1.3.6.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(APNGAttr aPNGAttr) {
                                        APNGAttr aPNGAttr2 = aPNGAttr;
                                        aPNGAttr2.mo153width(54.0f);
                                        aPNGAttr2.mo141height(87.0f);
                                        aPNGAttr2.with("src", NBPMoodGroupEntranceMarkerViewModel.this.config.iconUrl);
                                        aPNGAttr2.absolutePositionAllZero();
                                        aPNGAttr2.m142left(0.0f);
                                        aPNGAttr2.m150top(-11.0f);
                                        aPNGAttr2.repeatCount(0);
                                        aPNGAttr2.with("autoPlay", Integer.valueOf(com.tencent.kuikly.core.base.d.b(true)));
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.mood.NBPMoodGroupEntranceMarkerView.body.1.3.7
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                v vVar4 = vVar3;
                                vVar4.attr(new Function1<com.tencent.kuikly.core.views.t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.mood.NBPMoodGroupEntranceMarkerView.body.1.3.7.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(com.tencent.kuikly.core.views.t tVar) {
                                        com.tencent.kuikly.core.views.t tVar2 = tVar;
                                        tVar2.mo153width(10.0f);
                                        tVar2.mo141height(5.0f);
                                        return Unit.INSTANCE;
                                    }
                                });
                                w.a(vVar4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.mood.NBPMoodGroupEntranceMarkerView.body.1.3.7.2
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar5) {
                                        vVar5.attr(new Function1<com.tencent.kuikly.core.views.t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.mood.NBPMoodGroupEntranceMarkerView.body.1.3.7.2.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(com.tencent.kuikly.core.views.t tVar) {
                                                com.tencent.kuikly.core.views.t tVar2 = tVar;
                                                tVar2.mo153width(10.0f);
                                                tVar2.mo141height(10.0f);
                                                tVar2.mo113backgroundColor(h.INSTANCE.m());
                                                d.a.a(tVar2, new t(45.0f, 0.0f, 0.0f, 6, null), null, new y(0.0f, -0.5f, 0.0f, 0.0f, 12, null), null, null, 26, null);
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

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return new NBPMoodGroupEntranceAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new l();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.kuikly.core.base.ComposeView
    public final void created() {
        super.created();
        NBPMoodGroupEntranceMarkerViewModel viewModel = ((NBPMoodGroupEntranceAttr) getAttr()).getViewModel();
        viewModel.getClass();
        e jsonWithMainPgParamsImp = NearbyConstKt.jsonWithMainPgParamsImp();
        jsonWithMainPgParamsImp.v("dt_eid", "em_nearby_emotion_circle_en");
        jsonWithMainPgParamsImp.t("nearby_circle_type", viewModel.entrance.f444465d != 1 ? 2 : 1);
        jsonWithMainPgParamsImp.t("nearby_click_area", 0);
        jsonWithMainPgParamsImp.v(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
        Utils.INSTANCE.currentBridgeModule().reportCustomDtEvent("dt_imp", jsonWithMainPgParamsImp);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.kuikly.core.base.ComposeView, com.tencent.kuikly.core.base.ViewContainer, com.tencent.kuikly.core.base.DeclarativeBaseView
    public final void didRemoveFromParentView() {
        super.didRemoveFromParentView();
        String str = ((NBPMoodGroupEntranceAttr) getAttr()).getViewModel().joinedMoodNotifyRef;
        if (str != null) {
            ((k) com.tencent.kuikly.core.manager.c.f117352a.g().acquireModule("KRNotifyModule")).e("NEARBY_JOIN_MOOD_GROUP_EVENT", str);
        }
    }
}
