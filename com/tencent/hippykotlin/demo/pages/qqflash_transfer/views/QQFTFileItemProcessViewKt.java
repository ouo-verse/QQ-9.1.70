package com.tencent.hippykotlin.demo.pages.qqflash_transfer.views;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.tencent.kuikly.core.base.BorderStyle;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.w;
import com.tencent.ntcompose.core.ComposeNodeKt;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.event.ViewEventPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.RowKt;
import com.tencent.ntcompose.foundation.layout.base.Alignment;
import com.tencent.ntcompose.foundation.layout.base.a;
import com.tencent.ntcompose.foundation.layout.n;
import com.tencent.ntcompose.material.CanvasViewPropUpdater;
import com.tencent.ntcompose.material.base.ModifiersKt;
import com.tencent.ntcompose.material.k;
import com.tencent.ntcompose.material.m;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import uo3.c;
import yo3.Offset;
import yo3.Size;

/* loaded from: classes37.dex */
public final class QQFTFileItemProcessViewKt {
    /* JADX WARN: Removed duplicated region for block: B:26:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00a5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void QQFTFileItemProcessView(final float f16, final float f17, h hVar, h hVar2, float f18, Composer composer, final int i3, final int i16) {
        int i17;
        float f19;
        h m3;
        final h g16;
        final float f26;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(904552920);
        if ((i16 & 1) != 0) {
            i17 = i3 | 6;
        } else if ((i3 & 14) == 0) {
            i17 = (startRestartGroup.changed(f16) ? 4 : 2) | i3;
        } else {
            i17 = i3;
        }
        if ((i16 & 2) != 0) {
            i17 |= 48;
        } else if ((i3 & 112) == 0) {
            i17 |= startRestartGroup.changed(f17) ? 32 : 16;
        }
        int i18 = i16 & 4;
        if (i18 != 0) {
            i17 |= 128;
        }
        int i19 = i16 & 8;
        if (i19 != 0) {
            i17 |= 1024;
        }
        int i26 = i16 & 16;
        if (i26 != 0) {
            i17 |= 24576;
        } else if ((57344 & i3) == 0) {
            f19 = f18;
            i17 |= startRestartGroup.changed(f19) ? 16384 : 8192;
            if ((i16 & 12) != 12 && (i17 & 46811) == 9362 && startRestartGroup.getSkipping()) {
                startRestartGroup.skipToGroupEnd();
                m3 = hVar;
                g16 = hVar2;
            } else {
                startRestartGroup.startDefaults();
                if ((i3 & 1) == 0 && !startRestartGroup.getDefaultsInvalid()) {
                    startRestartGroup.skipToGroupEnd();
                    m3 = hVar;
                    g16 = hVar2;
                } else {
                    m3 = i18 == 0 ? h.INSTANCE.m() : hVar;
                    g16 = i19 == 0 ? h.INSTANCE.g() : hVar2;
                    if (i26 != 0) {
                        f26 = 1.0f;
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(904552920, i3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTFileItemProcessView (QQFTFileItemProcessView.kt:32)");
                        }
                        final float rint = (f16 > 0.0f ? 1 : (f16 == 0.0f ? 0 : -1)) == 0 ? 0.0f : ((float) Math.rint((f16 - ((int) f16)) * 100)) * 3.6f;
                        i f27 = ModifiersKt.f(ModifiersKt.q(ComposeLayoutPropUpdaterKt.u(i.INSTANCE, f17), c.a(f17)), f26, m3, BorderStyle.SOLID);
                        Alignment.Vertical c16 = Alignment.INSTANCE.c();
                        a.e b16 = a.f339245a.b();
                        ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(startRestartGroup, 1195490678, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTFileItemProcessViewKt$QQFTFileItemProcessView$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public final Unit invoke(n nVar, Composer composer2, Integer num) {
                                Composer composer3 = composer2;
                                int intValue = num.intValue();
                                if ((intValue & 81) == 16 && composer3.getSkipping()) {
                                    composer3.skipToGroupEnd();
                                } else {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1195490678, intValue, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTFileItemProcessView.<anonymous> (QQFTFileItemProcessView.kt:49)");
                                    }
                                    i u16 = ComposeLayoutPropUpdaterKt.u(i.INSTANCE, f17);
                                    h hVar3 = g16;
                                    float f28 = rint;
                                    float f29 = f26;
                                    composer3.startReplaceableGroup(-537167339);
                                    composer3.startReplaceableGroup(-492369756);
                                    Object rememberedValue = composer3.rememberedValue();
                                    Composer.Companion companion = Composer.INSTANCE;
                                    if (rememberedValue == companion.getEmpty()) {
                                        rememberedValue = new k();
                                        composer3.updateRememberedValue(rememberedValue);
                                    }
                                    composer3.endReplaceableGroup();
                                    final k kVar = (k) rememberedValue;
                                    composer3.startReplaceableGroup(-492369756);
                                    Object rememberedValue2 = composer3.rememberedValue();
                                    if (rememberedValue2 == companion.getEmpty()) {
                                        rememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                                        composer3.updateRememberedValue(rememberedValue2);
                                    }
                                    composer3.endReplaceableGroup();
                                    final MutableState mutableState = (MutableState) rememberedValue2;
                                    if (((Boolean) mutableState.getValue()).booleanValue()) {
                                        kVar.e();
                                        float f36 = f29 / 2;
                                        float min = Math.min(kVar.getSize().getWidth(), kVar.getSize().getHeight()) - f29;
                                        kVar.h(hVar3, -90.0f, f28, true, new Offset(f36, f36), new Size(min, min), m.f339435a);
                                        if (!kVar.m()) {
                                            kVar.w();
                                            MutableState<Integer> q16 = kVar.q();
                                            q16.setValue(Integer.valueOf(q16.getValue().intValue() + 1));
                                        }
                                    }
                                    ArrayList arrayList = new ArrayList();
                                    arrayList.add(new com.tencent.ntcompose.core.k("drawCallback", kVar, kVar.q().getValue(), null, null, null, CanvasViewPropUpdater.f339340a, 56, null));
                                    ComposeNodeKt.a("Canvas", com.tencent.ntcompose.material.base.a.f339408a, null, ViewEventPropUpdaterKt.m(u16, new Function1<w, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTFileItemProcessViewKt$QQFTFileItemProcessView$1$invoke$$inlined$Canvas$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(w wVar) {
                                            w it = wVar;
                                            Intrinsics.checkNotNullParameter(it, "it");
                                            k.this.z(new Size(it.getWidth(), it.getHeight()));
                                            mutableState.setValue(Boolean.TRUE);
                                            MutableState<Integer> q17 = k.this.q();
                                            q17.setValue(Integer.valueOf(q17.getValue().intValue() + 1));
                                            return Unit.INSTANCE;
                                        }
                                    }), arrayList, null, composer3, 33206, 32);
                                    composer3.endReplaceableGroup();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                                return Unit.INSTANCE;
                            }
                        });
                        float f28 = f26;
                        RowKt.a(f27, b16, c16, null, null, composableLambda, startRestartGroup, 196680, 24);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        f19 = f28;
                    }
                }
                f26 = f19;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                if ((f16 > 0.0f ? 1 : (f16 == 0.0f ? 0 : -1)) == 0) {
                }
                i f272 = ModifiersKt.f(ModifiersKt.q(ComposeLayoutPropUpdaterKt.u(i.INSTANCE, f17), c.a(f17)), f26, m3, BorderStyle.SOLID);
                Alignment.Vertical c162 = Alignment.INSTANCE.c();
                a.e b162 = a.f339245a.b();
                ComposableLambda composableLambda2 = ComposableLambdaKt.composableLambda(startRestartGroup, 1195490678, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTFileItemProcessViewKt$QQFTFileItemProcessView$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public final Unit invoke(n nVar, Composer composer2, Integer num) {
                        Composer composer3 = composer2;
                        int intValue = num.intValue();
                        if ((intValue & 81) == 16 && composer3.getSkipping()) {
                            composer3.skipToGroupEnd();
                        } else {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1195490678, intValue, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTFileItemProcessView.<anonymous> (QQFTFileItemProcessView.kt:49)");
                            }
                            i u16 = ComposeLayoutPropUpdaterKt.u(i.INSTANCE, f17);
                            h hVar3 = g16;
                            float f282 = rint;
                            float f29 = f26;
                            composer3.startReplaceableGroup(-537167339);
                            composer3.startReplaceableGroup(-492369756);
                            Object rememberedValue = composer3.rememberedValue();
                            Composer.Companion companion = Composer.INSTANCE;
                            if (rememberedValue == companion.getEmpty()) {
                                rememberedValue = new k();
                                composer3.updateRememberedValue(rememberedValue);
                            }
                            composer3.endReplaceableGroup();
                            final k kVar = (k) rememberedValue;
                            composer3.startReplaceableGroup(-492369756);
                            Object rememberedValue2 = composer3.rememberedValue();
                            if (rememberedValue2 == companion.getEmpty()) {
                                rememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                                composer3.updateRememberedValue(rememberedValue2);
                            }
                            composer3.endReplaceableGroup();
                            final MutableState mutableState = (MutableState) rememberedValue2;
                            if (((Boolean) mutableState.getValue()).booleanValue()) {
                                kVar.e();
                                float f36 = f29 / 2;
                                float min = Math.min(kVar.getSize().getWidth(), kVar.getSize().getHeight()) - f29;
                                kVar.h(hVar3, -90.0f, f282, true, new Offset(f36, f36), new Size(min, min), m.f339435a);
                                if (!kVar.m()) {
                                    kVar.w();
                                    MutableState<Integer> q16 = kVar.q();
                                    q16.setValue(Integer.valueOf(q16.getValue().intValue() + 1));
                                }
                            }
                            ArrayList arrayList = new ArrayList();
                            arrayList.add(new com.tencent.ntcompose.core.k("drawCallback", kVar, kVar.q().getValue(), null, null, null, CanvasViewPropUpdater.f339340a, 56, null));
                            ComposeNodeKt.a("Canvas", com.tencent.ntcompose.material.base.a.f339408a, null, ViewEventPropUpdaterKt.m(u16, new Function1<w, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTFileItemProcessViewKt$QQFTFileItemProcessView$1$invoke$$inlined$Canvas$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(w wVar) {
                                    w it = wVar;
                                    Intrinsics.checkNotNullParameter(it, "it");
                                    k.this.z(new Size(it.getWidth(), it.getHeight()));
                                    mutableState.setValue(Boolean.TRUE);
                                    MutableState<Integer> q17 = k.this.q();
                                    q17.setValue(Integer.valueOf(q17.getValue().intValue() + 1));
                                    return Unit.INSTANCE;
                                }
                            }), arrayList, null, composer3, 33206, 32);
                            composer3.endReplaceableGroup();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                        return Unit.INSTANCE;
                    }
                });
                float f282 = f26;
                RowKt.a(f272, b162, c162, null, null, composableLambda2, startRestartGroup, 196680, 24);
                if (ComposerKt.isTraceInProgress()) {
                }
                f19 = f282;
            }
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
                return;
            }
            final h hVar3 = m3;
            final h hVar4 = g16;
            final float f29 = f19;
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTFileItemProcessViewKt$QQFTFileItemProcessView$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Unit invoke(Composer composer2, Integer num) {
                    num.intValue();
                    QQFTFileItemProcessViewKt.QQFTFileItemProcessView(f16, f17, hVar3, hVar4, f29, composer2, i3 | 1, i16);
                    return Unit.INSTANCE;
                }
            });
            return;
        }
        f19 = f18;
        if ((i16 & 12) != 12) {
        }
        startRestartGroup.startDefaults();
        if ((i3 & 1) == 0) {
        }
        if (i18 == 0) {
        }
        if (i19 == 0) {
        }
        if (i26 != 0) {
        }
        f26 = f19;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        if ((f16 > 0.0f ? 1 : (f16 == 0.0f ? 0 : -1)) == 0) {
        }
        i f2722 = ModifiersKt.f(ModifiersKt.q(ComposeLayoutPropUpdaterKt.u(i.INSTANCE, f17), c.a(f17)), f26, m3, BorderStyle.SOLID);
        Alignment.Vertical c1622 = Alignment.INSTANCE.c();
        a.e b1622 = a.f339245a.b();
        ComposableLambda composableLambda22 = ComposableLambdaKt.composableLambda(startRestartGroup, 1195490678, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTFileItemProcessViewKt$QQFTFileItemProcessView$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public final Unit invoke(n nVar, Composer composer2, Integer num) {
                Composer composer3 = composer2;
                int intValue = num.intValue();
                if ((intValue & 81) == 16 && composer3.getSkipping()) {
                    composer3.skipToGroupEnd();
                } else {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1195490678, intValue, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTFileItemProcessView.<anonymous> (QQFTFileItemProcessView.kt:49)");
                    }
                    i u16 = ComposeLayoutPropUpdaterKt.u(i.INSTANCE, f17);
                    h hVar32 = g16;
                    float f2822 = rint;
                    float f292 = f26;
                    composer3.startReplaceableGroup(-537167339);
                    composer3.startReplaceableGroup(-492369756);
                    Object rememberedValue = composer3.rememberedValue();
                    Composer.Companion companion = Composer.INSTANCE;
                    if (rememberedValue == companion.getEmpty()) {
                        rememberedValue = new k();
                        composer3.updateRememberedValue(rememberedValue);
                    }
                    composer3.endReplaceableGroup();
                    final k kVar = (k) rememberedValue;
                    composer3.startReplaceableGroup(-492369756);
                    Object rememberedValue2 = composer3.rememberedValue();
                    if (rememberedValue2 == companion.getEmpty()) {
                        rememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                        composer3.updateRememberedValue(rememberedValue2);
                    }
                    composer3.endReplaceableGroup();
                    final MutableState mutableState = (MutableState) rememberedValue2;
                    if (((Boolean) mutableState.getValue()).booleanValue()) {
                        kVar.e();
                        float f36 = f292 / 2;
                        float min = Math.min(kVar.getSize().getWidth(), kVar.getSize().getHeight()) - f292;
                        kVar.h(hVar32, -90.0f, f2822, true, new Offset(f36, f36), new Size(min, min), m.f339435a);
                        if (!kVar.m()) {
                            kVar.w();
                            MutableState<Integer> q16 = kVar.q();
                            q16.setValue(Integer.valueOf(q16.getValue().intValue() + 1));
                        }
                    }
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(new com.tencent.ntcompose.core.k("drawCallback", kVar, kVar.q().getValue(), null, null, null, CanvasViewPropUpdater.f339340a, 56, null));
                    ComposeNodeKt.a("Canvas", com.tencent.ntcompose.material.base.a.f339408a, null, ViewEventPropUpdaterKt.m(u16, new Function1<w, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTFileItemProcessViewKt$QQFTFileItemProcessView$1$invoke$$inlined$Canvas$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(w wVar) {
                            w it = wVar;
                            Intrinsics.checkNotNullParameter(it, "it");
                            k.this.z(new Size(it.getWidth(), it.getHeight()));
                            mutableState.setValue(Boolean.TRUE);
                            MutableState<Integer> q17 = k.this.q();
                            q17.setValue(Integer.valueOf(q17.getValue().intValue() + 1));
                            return Unit.INSTANCE;
                        }
                    }), arrayList, null, composer3, 33206, 32);
                    composer3.endReplaceableGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                return Unit.INSTANCE;
            }
        });
        float f2822 = f26;
        RowKt.a(f2722, b1622, c1622, null, null, composableLambda22, startRestartGroup, 196680, 24);
        if (ComposerKt.isTraceInProgress()) {
        }
        f19 = f2822;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }
}
