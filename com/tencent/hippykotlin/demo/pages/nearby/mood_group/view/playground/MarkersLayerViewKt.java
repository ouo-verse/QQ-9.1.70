package com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.playground;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.tencent.ntcompose.animation.AnimateAsStateKt;
import com.tencent.ntcompose.animation.b;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.layout.BoxKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.material.base.ModifiersKt;
import h35.a;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class MarkersLayerViewKt {
    public static final void MarkersLayerView(final List<UserMarkerInfo> list, final Function2<? super UserMarkerInfo, ? super a, Unit> function2, final Function2<? super UserMarkerInfo, ? super a, Unit> function22, Composer composer, final int i3) {
        Composer startRestartGroup = composer.startRestartGroup(-146549620);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-146549620, i3, -1, "com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.playground.MarkersLayerView (MarkersLayerView.kt:14)");
        }
        BoxKt.a(ModifiersKt.b(ComposeLayoutPropUpdaterKt.h(i.INSTANCE, 0.0f, 1, null), AnimateAsStateKt.c(list.isEmpty() ^ true ? 1.0f : 0.0f, b.d(150, 0, null, null, 14, null), null, startRestartGroup, 48, 4).getValue().floatValue()), null, null, ComposableLambdaKt.composableLambda(startRestartGroup, -1870005306, true, new Function3<com.tencent.ntcompose.foundation.layout.b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.playground.MarkersLayerViewKt$MarkersLayerView$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public final Unit invoke(com.tencent.ntcompose.foundation.layout.b bVar, Composer composer2, Integer num) {
                Composer composer3 = composer2;
                int intValue = num.intValue();
                if ((intValue & 81) == 16 && composer3.getSkipping()) {
                    composer3.skipToGroupEnd();
                } else {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1870005306, intValue, -1, "com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.playground.MarkersLayerView.<anonymous> (MarkersLayerView.kt:27)");
                    }
                    List<UserMarkerInfo> list2 = list;
                    Function2<UserMarkerInfo, a, Unit> function23 = function2;
                    Function2<UserMarkerInfo, a, Unit> function24 = function22;
                    int i16 = i3;
                    for (UserMarkerInfo userMarkerInfo : list2) {
                        composer3.startMovableGroup(1690980021, Long.valueOf(userMarkerInfo.user.f444488d));
                        UserMarkerViewKt.UserMarkerView(userMarkerInfo, function23, function24, composer3, (i16 & 112) | (i16 & 896));
                        composer3.endMovableGroup();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                return Unit.INSTANCE;
            }
        }), startRestartGroup, 3080, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.playground.MarkersLayerViewKt$MarkersLayerView$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                MarkersLayerViewKt.MarkersLayerView(list, function2, function22, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }
}
