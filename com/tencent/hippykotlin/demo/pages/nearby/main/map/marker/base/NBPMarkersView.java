package com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.base;

import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.DeclarativeBaseView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.VirtualViewKt;
import com.tencent.kuikly.core.base.aa;
import com.tencent.kuikly.core.base.attr.d;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.base.u;
import com.tencent.kuikly.core.base.y;
import com.tencent.kuikly.core.directives.LoopDirectivesView;
import com.tencent.kuikly.core.directives.LoopDirectivesViewKt;
import com.tencent.kuikly.core.layout.FlexNode;
import com.tencent.kuikly.core.pager.e;
import com.tencent.kuikly.core.reactive.collection.c;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import defpackage.k;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public final class NBPMarkersView extends ComposeView<NBPMarkersAttr, NBPMarkersEvent> implements e {
    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ NBPMarkersAttr access$getAttr(NBPMarkersView nBPMarkersView) {
        return (NBPMarkersAttr) nBPMarkersView.getAttr();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.base.NBPMarkersView$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                final NBPMarkersView nBPMarkersView = NBPMarkersView.this;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.base.NBPMarkersView$body$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        mVar2.m152visibility(NBPMarkersView.access$getAttr(NBPMarkersView.this).getViewModel().getShowMarkersLayer());
                        mVar2.m151touchEnable(false);
                        return Unit.INSTANCE;
                    }
                });
                final NBPMarkersView nBPMarkersView2 = NBPMarkersView.this;
                Function0<c<NBPMapMarker>> function0 = new Function0<c<NBPMapMarker>>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.base.NBPMarkersView$body$1.2
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final c<NBPMapMarker> invoke() {
                        return NBPMarkersView.access$getAttr(NBPMarkersView.this).getViewModel().getVisibleMarkers();
                    }
                };
                final NBPMarkersView nBPMarkersView3 = NBPMarkersView.this;
                LoopDirectivesViewKt.a(viewContainer2, function0, new Function2<LoopDirectivesView<NBPMapMarker>, NBPMapMarker, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.base.NBPMarkersView$body$1.3
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Unit invoke(LoopDirectivesView<NBPMapMarker> loopDirectivesView, NBPMapMarker nBPMapMarker) {
                        final NBPMapMarker nBPMapMarker2 = nBPMapMarker;
                        final NBPMarkersView nBPMarkersView4 = NBPMarkersView.this;
                        w.a(loopDirectivesView, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.base.NBPMarkersView.body.1.3.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar) {
                                v vVar2 = vVar;
                                final NBPMapMarker nBPMapMarker3 = NBPMapMarker.this;
                                vVar2.ref(vVar2, new Function1<aa<v>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.base.NBPMarkersView.body.1.3.1.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(aa<v> aaVar) {
                                        NBPMapMarker.this.viewRef = aaVar;
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPMapMarker nBPMapMarker4 = NBPMapMarker.this;
                                final NBPMarkersView nBPMarkersView5 = nBPMarkersView4;
                                vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.base.NBPMarkersView.body.1.3.1.2
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        y a16;
                                        u a17;
                                        t tVar2 = tVar;
                                        tVar2.positionAbsolute();
                                        tVar2.m150top(0.0f);
                                        tVar2.m142left(0.0f);
                                        tVar2.size(NBPMapMarker.this.markerViewSize.getWidth(), NBPMapMarker.this.markerViewSize.getHeight());
                                        NBPMarkerTransform nBPMarkerTransform = NBPMapMarker.this.viewPositionTransform;
                                        if (nBPMarkerTransform == null || (a16 = nBPMarkerTransform.translate) == null) {
                                            a16 = y.INSTANCE.a();
                                        }
                                        y yVar = a16;
                                        NBPMarkerTransform nBPMarkerTransform2 = NBPMapMarker.this.viewPositionTransform;
                                        if (nBPMarkerTransform2 == null || (a17 = nBPMarkerTransform2.scale) == null) {
                                            a17 = u.INSTANCE.a();
                                        }
                                        d.a.a(tVar2, null, a17, yVar, null, null, 25, null);
                                        tVar2.m152visibility(NBPMapMarker.this.isVisibleOnMap);
                                        NBPMarkersViewModel viewModel = NBPMarkersView.access$getAttr(nBPMarkersView5).getViewModel();
                                        if (Intrinsics.areEqual((String) viewModel.currentFocusedKey$delegate.getValue(viewModel, NBPMarkersViewModel.$$delegatedProperties[2]), NBPMapMarker.this.key)) {
                                            tVar2.m154zIndex(2);
                                        } else {
                                            tVar2.m154zIndex(0);
                                        }
                                        return Unit.INSTANCE;
                                    }
                                });
                                if (k.a(com.tencent.kuikly.core.manager.c.f117352a)) {
                                    final NBPMapMarker nBPMapMarker5 = NBPMapMarker.this;
                                    w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.base.NBPMarkersView.body.1.3.1.3
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(v vVar3) {
                                            v vVar4 = vVar3;
                                            final NBPMapMarker nBPMapMarker6 = NBPMapMarker.this;
                                            vVar4.ref(vVar4, new Function1<aa<v>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.base.NBPMarkersView.body.1.3.1.3.1
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(aa<v> aaVar) {
                                                    NBPMapMarker.this.opacityWrapperViewRef = aaVar;
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.base.NBPMarkersView.body.1.3.1.3.2
                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(t tVar) {
                                                    t tVar2 = tVar;
                                                    tVar2.size(400.0f);
                                                    Attr.absolutePosition$default(tVar2, -200.0f, -200.0f, 0.0f, 0.0f, 12, null);
                                                    tVar2.m147opacity(1.0f);
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            final NBPMapMarker nBPMapMarker7 = NBPMapMarker.this;
                                            w.a(vVar4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.base.NBPMarkersView.body.1.3.1.3.3
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(v vVar5) {
                                                    v vVar6 = vVar5;
                                                    vVar6.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.base.NBPMarkersView.body.1.3.1.3.3.1
                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(t tVar) {
                                                            Attr.absolutePosition$default(tVar, 200.0f, 200.0f, 0.0f, 0.0f, 12, null);
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    NBPMapMarker.this.markerViewBuilder.invoke(vVar6);
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            return Unit.INSTANCE;
                                        }
                                    });
                                } else {
                                    NBPMapMarker.this.markerViewBuilder.invoke(vVar2);
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

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return new NBPMarkersAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new NBPMarkersEvent();
    }

    @Override // com.tencent.kuikly.core.base.DeclarativeBaseView
    public final void didMoveToParentView() {
        super.didMoveToParentView();
        getPager().addPagerLayoutEventObserver(this);
    }

    @Override // com.tencent.kuikly.core.base.ComposeView, com.tencent.kuikly.core.base.ViewContainer, com.tencent.kuikly.core.base.DeclarativeBaseView
    public final void didRemoveFromParentView() {
        super.didRemoveFromParentView();
        getPager().removePagerLayoutEventObserver(this);
    }

    @Override // com.tencent.kuikly.core.base.ComposeView, com.tencent.kuikly.core.views.internal.GroupView, com.tencent.kuikly.core.base.DeclarativeBaseView
    public final boolean isRenderView() {
        return true;
    }

    @Override // com.tencent.kuikly.core.pager.e
    public final void onPagerDidScroll(Object obj) {
        e.a.a(this, obj);
    }

    @Override // com.tencent.kuikly.core.pager.e
    public final void onPagerWillCalculateLayoutFinish() {
        ArrayList arrayList = new ArrayList();
        getFlexNode().g0();
        int i3 = 0;
        int i16 = 0;
        for (Object obj : VirtualViewKt.a(this)) {
            int i17 = i16 + 1;
            if (i16 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            DeclarativeBaseView declarativeBaseView = (DeclarativeBaseView) obj;
            if (declarativeBaseView.getFlexNode().getIsDirty()) {
                arrayList.add(declarativeBaseView.getFlexNode());
            }
            i16 = i17;
        }
        for (Object obj2 : arrayList) {
            int i18 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            getFlexNode().f0((FlexNode) obj2);
            i3 = i18;
        }
    }

    @Override // com.tencent.kuikly.core.pager.e
    public final void onPagerCalculateLayoutFinish() {
    }

    @Override // com.tencent.kuikly.core.pager.e
    public final void onPagerDidLayout() {
    }
}
