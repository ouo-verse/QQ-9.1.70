package com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.host;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyConstKt;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyProKtxKt;
import com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPMainKtxKt;
import com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPViewModelStore;
import com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.base.MarkerViewExtKt;
import com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.base.NBPAvatarAttr;
import com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.base.NBPAvatarView;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.a;
import com.tencent.kuikly.core.base.aa;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.attr.d;
import com.tencent.kuikly.core.base.b;
import com.tencent.kuikly.core.base.event.AnimationCompletionParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.u;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.views.APNGVView;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ah;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import v25.p;

/* loaded from: classes31.dex */
public final class NBPHostMarkerView extends ComposeView<NBPHostMarkerAttr, NBPHostMarkerEvent> {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPHostMarkerView.class, "animationRotate", "getAnimationRotate()F", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPHostMarkerView.class, "breathingAnim", "getBreathingAnim()Z", 0)};
    public final ReadWriteProperty animationRotate$delegate = c.a(Float.valueOf(0.0f));
    public final Lazy animationRotateGroup$delegate;
    public int animationRotateIndex;
    public final ReadWriteProperty breathingAnim$delegate;

    public NBPHostMarkerView() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Float[]>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.host.NBPHostMarkerView$animationRotateGroup$2
            @Override // kotlin.jvm.functions.Function0
            public final Float[] invoke() {
                Float valueOf = Float.valueOf(5.0f);
                return new Float[]{Float.valueOf(0.0f), valueOf, Float.valueOf(-5.0f), valueOf};
            }
        });
        this.animationRotateGroup$delegate = lazy;
        this.breathingAnim$delegate = c.a(Boolean.FALSE);
    }

    public static final Float[] access$getAnimationRotateGroup(NBPHostMarkerView nBPHostMarkerView) {
        return (Float[]) nBPHostMarkerView.animationRotateGroup$delegate.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        final NBPHostMarkerViewModel viewModel = ((NBPHostMarkerAttr) getAttr()).getViewModel();
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.host.NBPHostMarkerView$body$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                final NBPHostMarkerViewModel nBPHostMarkerViewModel = NBPHostMarkerViewModel.this;
                viewContainer2.ref(viewContainer2, new Function1<aa<ViewContainer<?, ?>>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.host.NBPHostMarkerView$body$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(aa<ViewContainer<?, ?>> aaVar) {
                        NBPHostMarkerViewModel.this.marekViewRef = aaVar;
                        return Unit.INSTANCE;
                    }
                });
                final NBPHostMarkerViewModel nBPHostMarkerViewModel2 = NBPHostMarkerViewModel.this;
                final NBPHostMarkerView nBPHostMarkerView = this;
                viewContainer2.event(new Function1<Event, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.host.NBPHostMarkerView$body$1.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Event event) {
                        final NBPHostMarkerViewModel nBPHostMarkerViewModel3 = NBPHostMarkerViewModel.this;
                        a aVar = nBPHostMarkerViewModel3.anchor;
                        final NBPHostMarkerView nBPHostMarkerView2 = nBPHostMarkerView;
                        MarkerViewExtKt.bindMarkerPopShow(event, aVar, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.host.NBPHostMarkerView.body.1.2.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Unit invoke() {
                                NBPHostMarkerViewModel.this.readyToFocus = true;
                                NBPHostMarkerView nBPHostMarkerView3 = nBPHostMarkerView2;
                                nBPHostMarkerView3.breathingAnim$delegate.setValue(nBPHostMarkerView3, NBPHostMarkerView.$$delegatedProperties[1], Boolean.TRUE);
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                com.tencent.kuikly.core.views.c.a(viewContainer2, new Function1<APNGVView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.host.NBPHostMarkerView$body$1.3
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(APNGVView aPNGVView) {
                        aPNGVView.attr(new Function1<com.tencent.kuikly.core.views.a, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.host.NBPHostMarkerView.body.1.3.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(com.tencent.kuikly.core.views.a aVar) {
                                com.tencent.kuikly.core.views.a aVar2 = aVar;
                                aVar2.mo153width(102.0f);
                                aVar2.mo141height(86.0f);
                                aVar2.src("https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_p_aWxlQDb63.png");
                                aVar2.absolutePositionAllZero();
                                aVar2.m142left(-24.0f);
                                aVar2.m150top(0.5f);
                                aVar2.autoPlay(true);
                                aVar2.repeatCount(0);
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final NBPHostMarkerView nBPHostMarkerView2 = this;
                final NBPHostMarkerViewModel nBPHostMarkerViewModel3 = NBPHostMarkerViewModel.this;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.host.NBPHostMarkerView$body$1.4
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        final NBPHostMarkerView nBPHostMarkerView3 = NBPHostMarkerView.this;
                        final NBPHostMarkerViewModel nBPHostMarkerViewModel4 = nBPHostMarkerViewModel3;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.host.NBPHostMarkerView.body.1.4.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                boolean booleanValue;
                                boolean booleanValue2;
                                boolean booleanValue3;
                                t tVar2 = tVar;
                                booleanValue = ((Boolean) r0.breathingAnim$delegate.getValue(NBPHostMarkerView.this, NBPHostMarkerView.$$delegatedProperties[1])).booleanValue();
                                float f16 = booleanValue ? 0.98f : 1.0f;
                                booleanValue2 = ((Boolean) r1.breathingAnim$delegate.getValue(NBPHostMarkerView.this, NBPHostMarkerView.$$delegatedProperties[1])).booleanValue();
                                d.a.a(tVar2, null, new u(f16, booleanValue2 ? 1.02f : 0.99f), null, nBPHostMarkerViewModel4.anchor, null, 21, null);
                                b i3 = b.INSTANCE.i(1.0f, "host_breathing");
                                booleanValue3 = ((Boolean) r1.breathingAnim$delegate.getValue(NBPHostMarkerView.this, NBPHostMarkerView.$$delegatedProperties[1])).booleanValue();
                                tVar2.m134animation(i3, (Object) Boolean.valueOf(booleanValue3));
                                return Unit.INSTANCE;
                            }
                        });
                        final NBPHostMarkerView nBPHostMarkerView4 = NBPHostMarkerView.this;
                        vVar2.event(new Function1<com.tencent.kuikly.core.views.u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.host.NBPHostMarkerView.body.1.4.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(com.tencent.kuikly.core.views.u uVar) {
                                final NBPHostMarkerView nBPHostMarkerView5 = NBPHostMarkerView.this;
                                uVar.animationCompletion(new Function1<AnimationCompletionParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.host.NBPHostMarkerView.body.1.4.2.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(AnimationCompletionParams animationCompletionParams) {
                                        boolean booleanValue;
                                        if (Intrinsics.areEqual(animationCompletionParams.getAnimationKey(), "host_breathing")) {
                                            NBPHostMarkerView nBPHostMarkerView6 = NBPHostMarkerView.this;
                                            booleanValue = ((Boolean) nBPHostMarkerView6.breathingAnim$delegate.getValue(nBPHostMarkerView6, NBPHostMarkerView.$$delegatedProperties[1])).booleanValue();
                                            nBPHostMarkerView6.breathingAnim$delegate.setValue(nBPHostMarkerView6, NBPHostMarkerView.$$delegatedProperties[1], Boolean.valueOf(!booleanValue));
                                        }
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final NBPHostMarkerView nBPHostMarkerView5 = NBPHostMarkerView.this;
                        final NBPHostMarkerViewModel nBPHostMarkerViewModel5 = nBPHostMarkerViewModel3;
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.host.NBPHostMarkerView.body.1.4.3
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                v vVar4 = vVar3;
                                final NBPHostMarkerView nBPHostMarkerView6 = NBPHostMarkerView.this;
                                vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.host.NBPHostMarkerView.body.1.4.3.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        NBPHostMarkerView nBPHostMarkerView7 = NBPHostMarkerView.this;
                                        ReadWriteProperty readWriteProperty = nBPHostMarkerView7.animationRotate$delegate;
                                        KProperty<?>[] kPropertyArr = NBPHostMarkerView.$$delegatedProperties;
                                        d.a.a(tVar2, new com.tencent.kuikly.core.base.t(((Number) readWriteProperty.getValue(nBPHostMarkerView7, kPropertyArr[0])).floatValue(), 0.0f, 0.0f, 6, null), null, null, new a(0.5f, 1.0f), null, 22, null);
                                        b l3 = b.Companion.l(b.INSTANCE, 0.05f, null, 2, null);
                                        NBPHostMarkerView nBPHostMarkerView8 = NBPHostMarkerView.this;
                                        tVar2.m134animation(l3, (Object) Float.valueOf(((Number) nBPHostMarkerView8.animationRotate$delegate.getValue(nBPHostMarkerView8, kPropertyArr[0])).floatValue()));
                                        tVar2.flexDirectionColumn();
                                        tVar2.mo153width(54.0f);
                                        tVar2.mo141height(60.0f);
                                        tVar2.alignItemsCenter();
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPHostMarkerView nBPHostMarkerView7 = NBPHostMarkerView.this;
                                vVar4.event(new Function1<com.tencent.kuikly.core.views.u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.host.NBPHostMarkerView.body.1.4.3.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(com.tencent.kuikly.core.views.u uVar) {
                                        final NBPHostMarkerView nBPHostMarkerView8 = NBPHostMarkerView.this;
                                        uVar.animationCompletion(new Function1<AnimationCompletionParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.host.NBPHostMarkerView.body.1.4.3.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(AnimationCompletionParams animationCompletionParams) {
                                                int lastIndex;
                                                NBPHostMarkerView nBPHostMarkerView9 = NBPHostMarkerView.this;
                                                int i3 = nBPHostMarkerView9.animationRotateIndex;
                                                if (i3 != 0) {
                                                    lastIndex = ArraysKt___ArraysKt.getLastIndex(NBPHostMarkerView.access$getAnimationRotateGroup(nBPHostMarkerView9));
                                                    if (i3 == lastIndex) {
                                                        NBPHostMarkerView nBPHostMarkerView10 = NBPHostMarkerView.this;
                                                        nBPHostMarkerView10.animationRotateIndex = 0;
                                                        nBPHostMarkerView10.animationRotate$delegate.setValue(nBPHostMarkerView10, NBPHostMarkerView.$$delegatedProperties[0], Float.valueOf(NBPHostMarkerView.access$getAnimationRotateGroup(nBPHostMarkerView10)[0].floatValue()));
                                                    } else {
                                                        NBPHostMarkerView nBPHostMarkerView11 = NBPHostMarkerView.this;
                                                        nBPHostMarkerView11.animationRotateIndex++;
                                                        nBPHostMarkerView11.animationRotate$delegate.setValue(nBPHostMarkerView11, NBPHostMarkerView.$$delegatedProperties[0], Float.valueOf(NBPHostMarkerView.access$getAnimationRotateGroup(nBPHostMarkerView11)[NBPHostMarkerView.this.animationRotateIndex].floatValue()));
                                                    }
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                ah.a(vVar4, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.host.NBPHostMarkerView.body.1.4.3.3
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ImageView imageView) {
                                        imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.host.NBPHostMarkerView.body.1.4.3.3.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(af afVar) {
                                                af afVar2 = afVar;
                                                b.a.b(afVar2, "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9__lYW3Gq9STU.png", false, 2, null);
                                                afVar2.mo153width(54.0f);
                                                afVar2.mo141height(60.0f);
                                                afVar2.absolutePositionAllZero();
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPHostMarkerViewModel nBPHostMarkerViewModel6 = nBPHostMarkerViewModel5;
                                vVar4.addChild(new NBPAvatarView(), new Function1<NBPAvatarView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.host.NBPHostMarkerView.body.1.4.3.4
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(NBPAvatarView nBPAvatarView) {
                                        final NBPHostMarkerViewModel nBPHostMarkerViewModel7 = NBPHostMarkerViewModel.this;
                                        nBPAvatarView.attr(new Function1<NBPAvatarAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.host.NBPHostMarkerView.body.1.4.3.4.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(NBPAvatarAttr nBPAvatarAttr) {
                                                NBPAvatarAttr nBPAvatarAttr2 = nBPAvatarAttr;
                                                p pVar = NBPHostMarkerViewModel.this.person;
                                                nBPAvatarAttr2.url = pVar.f440883h;
                                                nBPAvatarAttr2.dressBorderUrl = NearbyProKtxKt.avatarDressBorderUrl(pVar);
                                                nBPAvatarAttr2.size = 48.0f;
                                                nBPAvatarAttr2.borderWidth$delegate.setValue(nBPAvatarAttr2, NBPAvatarAttr.$$delegatedProperties[0], Float.valueOf(0.0f));
                                                nBPAvatarAttr2.marginTop(3.0f);
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
        return new NBPHostMarkerAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new NBPHostMarkerEvent();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.kuikly.core.base.ComposeView
    public final void created() {
        NBPViewModelStore nbpVMStore;
        super.created();
        NBPHostMarkerViewModel viewModel = ((NBPHostMarkerAttr) getAttr()).getViewModel();
        viewModel.readyToFocus = true;
        nbpVMStore = NBPMainKtxKt.getNbpVMStore(com.tencent.kuikly.core.manager.c.f117352a.g());
        nbpVMStore.dispatchEvent("EVENT_HOST_PERSON_APPEAR");
        e jsonWithMainPgParamsImp = NearbyConstKt.jsonWithMainPgParamsImp();
        jsonWithMainPgParamsImp.v("dt_eid", "em_nearby_avatar_icon");
        jsonWithMainPgParamsImp.v("nearby_frame_id", NearbyProKtxKt.avatarDressBorderUrl(viewModel.person));
        jsonWithMainPgParamsImp.v(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
        Utils.INSTANCE.currentBridgeModule().reportCustomDtEvent("dt_imp", jsonWithMainPgParamsImp);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.kuikly.core.base.ComposeView, com.tencent.kuikly.core.base.ViewContainer, com.tencent.kuikly.core.base.DeclarativeBaseView
    public final void didRemoveFromParentView() {
        NBPViewModelStore nbpVMStore;
        super.didRemoveFromParentView();
        ((NBPHostMarkerAttr) getAttr()).getViewModel().getClass();
        nbpVMStore = NBPMainKtxKt.getNbpVMStore(com.tencent.kuikly.core.manager.c.f117352a.g());
        nbpVMStore.dispatchEvent("EVENT_HOST_PERSON_DISAPPEAR");
    }
}
