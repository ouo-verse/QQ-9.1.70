package com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.operation;

import com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.base.MarkerViewExtKt;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.l;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ah;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.u;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public final class NBPOperationMarkerView extends ComposeView<NBPOperationMarkerAttr, l> {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        final NBPOperationMarkerViewModel nBPOperationMarkerViewModel = ((NBPOperationMarkerAttr) getAttr()).f114227vm;
        if (nBPOperationMarkerViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
            nBPOperationMarkerViewModel = null;
        }
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.operation.NBPOperationMarkerView$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                final NBPOperationMarkerViewModel nBPOperationMarkerViewModel2 = NBPOperationMarkerViewModel.this;
                w.a(viewContainer, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.operation.NBPOperationMarkerView$body$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        final NBPOperationMarkerViewModel nBPOperationMarkerViewModel3 = NBPOperationMarkerViewModel.this;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.operation.NBPOperationMarkerView.body.1.1.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                MarkerViewExtKt.bindMarkerStatusChange(tVar, NBPOperationMarkerViewModel.this, 0.0f);
                                return Unit.INSTANCE;
                            }
                        });
                        final NBPOperationMarkerViewModel nBPOperationMarkerViewModel4 = NBPOperationMarkerViewModel.this;
                        vVar2.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.operation.NBPOperationMarkerView.body.1.1.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(u uVar) {
                                final NBPOperationMarkerViewModel nBPOperationMarkerViewModel5 = NBPOperationMarkerViewModel.this;
                                MarkerViewExtKt.bindMarkerPopShow(uVar, nBPOperationMarkerViewModel5.anchor, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.operation.NBPOperationMarkerView.body.1.1.2.1
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public final Unit invoke() {
                                        NBPOperationMarkerViewModel.this.readyToFocus = true;
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final NBPOperationMarkerViewModel nBPOperationMarkerViewModel5 = NBPOperationMarkerViewModel.this;
                        ah.a(vVar2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.operation.NBPOperationMarkerView.body.1.1.3
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ImageView imageView) {
                                final NBPOperationMarkerViewModel nBPOperationMarkerViewModel6 = NBPOperationMarkerViewModel.this;
                                imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.operation.NBPOperationMarkerView.body.1.1.3.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(af afVar) {
                                        af afVar2 = afVar;
                                        afVar2.size(NBPOperationMarkerViewModel.this.getMarkerViewSize().getWidth(), NBPOperationMarkerViewModel.this.getMarkerViewSize().getHeight());
                                        b.a.b(afVar2, NBPOperationMarkerViewModel.this.operator.f421858h, false, 2, null);
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
        return new NBPOperationMarkerAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new l();
    }
}
