package com.tencent.hippykotlin.demo.pages.nearby.middle_page.view;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.event.ViewEventPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.ColumnKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.base.Alignment;
import com.tencent.ntcompose.ui.platform.CompositionLocalsKt;
import com.tencent.ntcompose.ui.platform.a;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class FeedsEmptyViewKt {
    /* JADX WARN: Multi-variable type inference failed */
    public static final void FeedsEmptyView(Composer composer, final int i3) {
        Composer startRestartGroup = composer.startRestartGroup(-663881415);
        if (i3 == 0 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-663881415, i3, -1, "com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.FeedsEmptyView (FeedsEmptyView.kt:29)");
            }
            final float d16 = ((a) startRestartGroup.consume(CompositionLocalsKt.d())).d();
            final float bottom = ((a) startRestartGroup.consume(CompositionLocalsKt.d())).f().getBottom() + 56.0f + 12.0f;
            startRestartGroup.startReplaceableGroup(-492369756);
            Object rememberedValue = startRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (rememberedValue == companion.getEmpty()) {
                rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceableGroup();
            final MutableState mutableState = (MutableState) rememberedValue;
            i j3 = ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null);
            Float f16 = (Float) mutableState.getValue();
            i k3 = ComposeLayoutPropUpdaterKt.k(j3, f16 != null ? f16.floatValue() : 1.0f);
            Float valueOf = Float.valueOf(d16);
            Float valueOf2 = Float.valueOf(bottom);
            startRestartGroup.startReplaceableGroup(1618982084);
            boolean changed = startRestartGroup.changed(valueOf) | startRestartGroup.changed(mutableState) | startRestartGroup.changed(valueOf2);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (changed || rememberedValue2 == companion.getEmpty()) {
                rememberedValue2 = new Function1<ap3.a, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.FeedsEmptyViewKt$FeedsEmptyView$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ap3.a aVar) {
                        ap3.a aVar2 = aVar;
                        if (mutableState.getValue() == null) {
                            float y16 = aVar2.getY();
                            for (ap3.a f17 = aVar2.f(); f17 != null; f17 = f17.f()) {
                                y16 += f17.getY();
                            }
                            mutableState.setValue(Float.valueOf((d16 - y16) - bottom));
                        }
                        return Unit.INSTANCE;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceableGroup();
            ColumnKt.a(ViewEventPropUpdaterKt.l(k3, (Function1) rememberedValue2), com.tencent.ntcompose.foundation.layout.base.a.f339245a.b(), Alignment.INSTANCE.b(), null, ComposableSingletons$FeedsEmptyViewKt.f47lambda1, startRestartGroup, 24648, 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.FeedsEmptyViewKt$FeedsEmptyView$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                FeedsEmptyViewKt.FeedsEmptyView(composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }
}
