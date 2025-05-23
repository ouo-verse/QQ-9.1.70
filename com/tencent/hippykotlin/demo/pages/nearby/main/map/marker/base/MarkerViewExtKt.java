package com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.base;

import com.tencent.kuikly.core.base.AbstractBaseView;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.a;
import com.tencent.kuikly.core.base.attr.d;
import com.tencent.kuikly.core.base.b;
import com.tencent.kuikly.core.base.event.AnimationCompletionParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.event.VisibilityEventKt;
import com.tencent.kuikly.core.base.q;
import com.tencent.kuikly.core.base.u;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class MarkerViewExtKt {
    public static final void bindMarkerPopShow(final Event event, final a aVar, final Function0<Unit> function0) {
        VisibilityEventKt.e(event, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.base.MarkerViewExtKt$bindMarkerPopShow$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Object obj) {
                AbstractBaseView<?, ?> view = Event.this.getView();
                if (view != null) {
                    final a aVar2 = aVar;
                    view.attr(new Function1<Attr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.base.MarkerViewExtKt$bindMarkerPopShow$1$1$1
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(Attr attr) {
                            d.a.a(attr, null, new u(0.2f, 0.2f), null, a.this, null, 21, null);
                            return Unit.INSTANCE;
                        }
                    });
                }
                return Unit.INSTANCE;
            }
        });
        VisibilityEventKt.b(event, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.base.MarkerViewExtKt$bindMarkerPopShow$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Object obj) {
                AbstractBaseView<?, ?> view = Event.this.getView();
                if (view != null) {
                    final a aVar2 = aVar;
                    q.a.a(view, b.INSTANCE.s(0.5f, 0.5f, 1.0f, "marker_view_animation_key_pop_show"), null, new Function1<Attr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.base.MarkerViewExtKt$bindMarkerPopShow$2$1$1
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(Attr attr) {
                            d.a.a(attr, null, new u(1.0f, 1.0f), null, a.this, null, 21, null);
                            return Unit.INSTANCE;
                        }
                    }, 2, null);
                }
                return Unit.INSTANCE;
            }
        });
        event.animationCompletion(new Function1<AnimationCompletionParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.base.MarkerViewExtKt$bindMarkerPopShow$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(AnimationCompletionParams animationCompletionParams) {
                if (Intrinsics.areEqual(animationCompletionParams.getAnimationKey(), "marker_view_animation_key_pop_show")) {
                    function0.invoke();
                }
                return Unit.INSTANCE;
            }
        });
    }

    public static final void bindMarkerStatusChange(Attr attr, FocusableMarker focusableMarker, float f16) {
        float f17;
        int ordinal = focusableMarker.getStatus().ordinal();
        if (ordinal == 0) {
            d.a.a(attr, null, new u(1.0f, 1.0f), null, focusableMarker.anchor, null, 21, null);
        } else if (ordinal == 1) {
            float f18 = focusableMarker.focusedScale;
            d.a.a(attr, null, new u(f18, f18), null, focusableMarker.anchor, null, 21, null);
            f17 = f16;
            b t16 = b.Companion.t(b.INSTANCE, 0.25f, 2.0f, 0.0f, null, 8, null);
            t16.h(f17);
            attr.animate(t16, focusableMarker.getStatus());
        }
        f17 = 0.0f;
        b t162 = b.Companion.t(b.INSTANCE, 0.25f, 2.0f, 0.0f, null, 8, null);
        t162.h(f17);
        attr.animate(t162, focusableMarker.getStatus());
    }
}
