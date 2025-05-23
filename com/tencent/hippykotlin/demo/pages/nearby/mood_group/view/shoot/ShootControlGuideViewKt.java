package com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.shoot;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import com.tencent.hippykotlin.demo.pages.nearby.mood_group.vm.shoot.NBPShootViewModel;
import com.tencent.kuikly.core.base.Direction;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.j;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.layout.BoxKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.material.base.ModifiersKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ShootControlGuideViewKt {
    public static final void ShootControlGuideView(final NBPShootViewModel nBPShootViewModel, Composer composer, final int i3) {
        Composer startRestartGroup = composer.startRestartGroup(727856461);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(727856461, i3, -1, "com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.shoot.ShootControlGuideView (ShootControlGuideView.kt:21)");
        }
        if (nBPShootViewModel.showControlGuideView.getValue().booleanValue()) {
            i k3 = ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), 311.0f);
            Direction direction = Direction.TO_BOTTOM;
            h.Companion companion = h.INSTANCE;
            BoxKt.a(ModifiersKt.e(k3, direction, new j(companion.a(0.0f), 0.0f), new j(companion.a(0.6f), 1.0f)), null, null, ComposableSingletons$ShootControlGuideViewKt.f80lambda1, startRestartGroup, 3080, 6);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.shoot.ShootControlGuideViewKt$ShootControlGuideView$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                ShootControlGuideViewKt.ShootControlGuideView(NBPShootViewModel.this, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }
}
