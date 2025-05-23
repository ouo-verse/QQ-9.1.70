package com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.GuideBannerCardAnimationViewKt$$ExternalSyntheticOutline0;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.w;
import com.tencent.kuikly.core.views.ScrollParams;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.event.ViewEventPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.BoxKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.RowKt;
import com.tencent.ntcompose.foundation.layout.b;
import com.tencent.ntcompose.foundation.layout.base.Alignment;
import com.tencent.ntcompose.foundation.layout.n;
import com.tencent.ntcompose.foundation.lazy.d;
import com.tencent.ntcompose.foundation.lazy.e;
import com.tencent.ntcompose.foundation.lazy.layout.a;
import com.tencent.ntcompose.material.LazyRowKt;
import com.tencent.ntcompose.material.TextKt;
import com.tencent.ntcompose.material.base.ModifiersKt;
import com.tencent.qqnt.kernel.nativeinterface.MsgConstant;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class QQMoreOptionContentViewKt {
    /* JADX WARN: Removed duplicated region for block: B:105:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0285  */
    /* JADX WARN: Removed duplicated region for block: B:43:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01f1 A[LOOP:0: B:62:0x01ee->B:64:0x01f1, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0202  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0270  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x00a5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void QQMoreOptionContentView(i iVar, final boolean z16, i iVar2, final Function2<? super Composer, ? super Integer, Unit> function2, float f16, Function0<Unit> function0, i iVar3, List<QQMoreOptionButton> list, Function0<Unit> function02, Composer composer, final int i3, final int i16) {
        int i17;
        float f17;
        int i18;
        Function0<Unit> function03;
        int i19;
        int i26;
        int i27;
        i iVar4;
        i iVar5;
        final float f18;
        final Function0<Unit> function04;
        i iVar6;
        List<QQMoreOptionButton> list2;
        final Function0<Unit> function05;
        d dVar;
        Object rememberedValue;
        boolean z17;
        int i28;
        Object rememberedValue2;
        final i iVar7;
        i iVar8;
        final Function0<Unit> function06;
        final Function0<Unit> function07;
        final i iVar9;
        final List<QQMoreOptionButton> list3;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(299762268);
        int i29 = i16 & 1;
        int i36 = i29 != 0 ? i3 | 2 : i3;
        if ((i16 & 2) != 0) {
            i36 |= 48;
        } else if ((i3 & 112) == 0) {
            i36 |= startRestartGroup.changed(z16) ? 32 : 16;
        }
        int i37 = i16 & 4;
        if (i37 != 0) {
            i36 |= 128;
        }
        if ((i16 & 8) != 0) {
            i36 |= 3072;
        } else if ((i3 & 7168) == 0) {
            i36 |= startRestartGroup.changed(function2) ? 2048 : 1024;
            i17 = i16 & 16;
            if (i17 == 0) {
                i36 |= 24576;
            } else if ((57344 & i3) == 0) {
                f17 = f16;
                i36 |= startRestartGroup.changed(f17) ? 16384 : 8192;
                i18 = i16 & 32;
                if (i18 != 0) {
                    i36 |= 196608;
                } else if ((458752 & i3) == 0) {
                    function03 = function0;
                    i36 |= startRestartGroup.changed(function03) ? 131072 : 65536;
                    i19 = i16 & 64;
                    if (i19 != 0) {
                        i36 |= 524288;
                    }
                    i26 = i16 & 128;
                    if (i26 != 0) {
                        i36 |= 4194304;
                    }
                    i27 = i16 & 256;
                    if (i27 == 0) {
                        i36 |= 100663296;
                    } else if ((i3 & 234881024) == 0) {
                        i36 |= startRestartGroup.changed(function02) ? 67108864 : 33554432;
                    }
                    if ((i16 & 197) != 197 && (191739611 & i36) == 38347922 && startRestartGroup.getSkipping()) {
                        startRestartGroup.skipToGroupEnd();
                        iVar8 = iVar;
                        iVar7 = iVar2;
                        iVar9 = iVar3;
                        function06 = function02;
                        f18 = f17;
                        function07 = function03;
                        list3 = list;
                    } else {
                        startRestartGroup.startDefaults();
                        if ((i3 & 1) == 0 && !startRestartGroup.getDefaultsInvalid()) {
                            startRestartGroup.skipToGroupEnd();
                            if (i26 != 0) {
                                iVar5 = iVar2;
                                list2 = list;
                                function05 = function02;
                                i36 &= -29360129;
                                f18 = f17;
                                function04 = function03;
                                iVar4 = iVar;
                            } else {
                                iVar4 = iVar;
                                iVar5 = iVar2;
                                list2 = list;
                                function05 = function02;
                                f18 = f17;
                                function04 = function03;
                            }
                            iVar6 = iVar3;
                        } else {
                            iVar4 = i29 == 0 ? i.INSTANCE : iVar;
                            iVar5 = i37 == 0 ? i.INSTANCE : iVar2;
                            f18 = i17 == 0 ? 20.0f : f17;
                            function04 = i18 == 0 ? new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QQMoreOptionContentViewKt$QQMoreOptionContentView$1
                                @Override // kotlin.jvm.functions.Function0
                                public final /* bridge */ /* synthetic */ Unit invoke() {
                                    return Unit.INSTANCE;
                                }
                            } : function03;
                            iVar6 = i19 == 0 ? i.INSTANCE : iVar3;
                            if (i26 == 0) {
                                list2 = CollectionsKt__CollectionsKt.emptyList();
                                i36 &= -29360129;
                            } else {
                                list2 = list;
                            }
                            function05 = i27 == 0 ? new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QQMoreOptionContentViewKt$QQMoreOptionContentView$2
                                @Override // kotlin.jvm.functions.Function0
                                public final /* bridge */ /* synthetic */ Unit invoke() {
                                    return Unit.INSTANCE;
                                }
                            } : function02;
                        }
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(299762268, i36, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QQMoreOptionContentView (QQMoreOptionContentView.kt:83)");
                        }
                        d a16 = e.a(0, 0.0f, startRestartGroup, 0, 3);
                        if (!z16) {
                            dVar = a16;
                            d.x(a16, 0, 0.0f, true, null, 8, null);
                        } else {
                            dVar = a16;
                            d.x(a16, 1, 0.0f, true, null, 8, null);
                        }
                        startRestartGroup.startReplaceableGroup(-492369756);
                        rememberedValue = startRestartGroup.rememberedValue();
                        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                            rememberedValue = GuideBannerCardAnimationViewKt$$ExternalSyntheticOutline0.m(0.0f, null, 2, null, startRestartGroup);
                        }
                        startRestartGroup.endReplaceableGroup();
                        final MutableState mutableState = (MutableState) rememberedValue;
                        i k3 = ComposeLayoutPropUpdaterKt.k(iVar4, ((Number) mutableState.getValue()).floatValue());
                        Boolean bool = Boolean.FALSE;
                        z17 = false;
                        i iVar10 = iVar4;
                        final d dVar2 = dVar;
                        Object[] objArr = {Float.valueOf(f18), function04, dVar2, function05};
                        startRestartGroup.startReplaceableGroup(-568225417);
                        for (i28 = 0; i28 < 4; i28++) {
                            z17 |= startRestartGroup.changed(objArr[i28]);
                        }
                        rememberedValue2 = startRestartGroup.rememberedValue();
                        if (!z17 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            rememberedValue2 = new Function1<ScrollParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QQMoreOptionContentViewKt$QQMoreOptionContentView$3$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(ScrollParams scrollParams) {
                                    if (scrollParams.getOffsetX() < f18) {
                                        function04.invoke();
                                        d.x(dVar2, 0, 0.0f, true, null, 8, null);
                                    } else {
                                        function05.invoke();
                                        d.x(dVar2, 1, 0.0f, true, null, 8, null);
                                    }
                                    return Unit.INSTANCE;
                                }
                            };
                            startRestartGroup.updateRememberedValue(rememberedValue2);
                        }
                        startRestartGroup.endReplaceableGroup();
                        final i iVar11 = iVar5;
                        i iVar12 = iVar5;
                        final i iVar13 = iVar6;
                        final int i38 = i36;
                        final List<QQMoreOptionButton> list4 = list2;
                        LazyRowKt.a(k3, null, dVar2, null, null, null, bool, bool, null, null, null, 0, null, null, null, null, null, null, null, (Function1) rememberedValue2, null, null, ComposableLambdaKt.composableLambda(startRestartGroup, 268776613, true, new Function3<a, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QQMoreOptionContentViewKt$QQMoreOptionContentView$4
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public final Unit invoke(a aVar, Composer composer2, Integer num) {
                                Composer composer3 = composer2;
                                int intValue = num.intValue();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(268776613, intValue, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QQMoreOptionContentView.<anonymous> (QQMoreOptionContentView.kt:116)");
                                }
                                i iVar14 = i.this;
                                final MutableState<Float> mutableState2 = mutableState;
                                composer3.startReplaceableGroup(1157296644);
                                boolean changed = composer3.changed(mutableState2);
                                Object rememberedValue3 = composer3.rememberedValue();
                                if (changed || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue3 = new Function1<w, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QQMoreOptionContentViewKt$QQMoreOptionContentView$4$1$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(w wVar) {
                                            mutableState2.setValue(Float.valueOf(wVar.getHeight()));
                                            return Unit.INSTANCE;
                                        }
                                    };
                                    composer3.updateRememberedValue(rememberedValue3);
                                }
                                composer3.endReplaceableGroup();
                                i m3 = ViewEventPropUpdaterKt.m(iVar14, (Function1) rememberedValue3);
                                final Function2<Composer, Integer, Unit> function22 = function2;
                                final int i39 = i38;
                                BoxKt.a(m3, null, null, ComposableLambdaKt.composableLambda(composer3, -1158008993, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QQMoreOptionContentViewKt$QQMoreOptionContentView$4.2
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public final Unit invoke(b bVar, Composer composer4, Integer num2) {
                                        Composer composer5 = composer4;
                                        int intValue2 = num2.intValue();
                                        if ((intValue2 & 81) == 16 && composer5.getSkipping()) {
                                            composer5.skipToGroupEnd();
                                        } else {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-1158008993, intValue2, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QQMoreOptionContentView.<anonymous>.<anonymous> (QQMoreOptionContentView.kt:123)");
                                            }
                                            function22.invoke(composer5, Integer.valueOf((i39 >> 9) & 14));
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                        return Unit.INSTANCE;
                                    }
                                }), composer3, 3080, 6);
                                i iVar15 = iVar13;
                                final List<QQMoreOptionButton> list5 = list4;
                                RowKt.a(iVar15, null, null, null, null, ComposableLambdaKt.composableLambda(composer3, -1984152381, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QQMoreOptionContentViewKt$QQMoreOptionContentView$4.3
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public final Unit invoke(n nVar, Composer composer4, Integer num2) {
                                        Composer composer5 = composer4;
                                        int intValue2 = num2.intValue();
                                        if ((intValue2 & 81) == 16 && composer5.getSkipping()) {
                                            composer5.skipToGroupEnd();
                                        } else {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-1984152381, intValue2, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QQMoreOptionContentView.<anonymous>.<anonymous> (QQMoreOptionContentView.kt:130)");
                                            }
                                            for (final QQMoreOptionButton qQMoreOptionButton : list5) {
                                                if (qQMoreOptionButton.buttonBuilder != null) {
                                                    composer5.startReplaceableGroup(-492986463);
                                                    qQMoreOptionButton.buttonBuilder.invoke(composer5, 0);
                                                    composer5.endReplaceableGroup();
                                                } else {
                                                    composer5.startReplaceableGroup(-492986372);
                                                    BoxKt.a(ViewEventPropUpdaterKt.d(ModifiersKt.d(ComposeLayoutPropUpdaterKt.w(ComposeLayoutPropUpdaterKt.f(i.INSTANCE, 0.0f, 1, null), qQMoreOptionButton.buttonWidth), qQMoreOptionButton.buttonColor), false, null, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QQMoreOptionContentViewKt$QQMoreOptionContentView$4$3$1$1
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(ClickParams clickParams) {
                                                            QQMoreOptionButton.this.buttonClickFn.invoke();
                                                            return Unit.INSTANCE;
                                                        }
                                                    }, 3, null), Alignment.Center, null, ComposableLambdaKt.composableLambda(composer5, 1184641522, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QQMoreOptionContentViewKt$QQMoreOptionContentView$4$3$1$2
                                                        {
                                                            super(3);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function3
                                                        public final Unit invoke(b bVar, Composer composer6, Integer num3) {
                                                            Composer composer7 = composer6;
                                                            int intValue3 = num3.intValue();
                                                            if ((intValue3 & 81) == 16 && composer7.getSkipping()) {
                                                                composer7.skipToGroupEnd();
                                                            } else {
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                    ComposerKt.traceEventStart(1184641522, intValue3, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QQMoreOptionContentView.<anonymous>.<anonymous>.<anonymous>.<anonymous> (QQMoreOptionContentView.kt:145)");
                                                                }
                                                                if (QQMoreOptionButton.this.textBuilder != null) {
                                                                    composer7.startReplaceableGroup(1230118171);
                                                                    QQMoreOptionButton.this.textBuilder.invoke(composer7, 0);
                                                                    composer7.endReplaceableGroup();
                                                                } else {
                                                                    composer7.startReplaceableGroup(1230118260);
                                                                    QQMoreOptionButton qQMoreOptionButton2 = QQMoreOptionButton.this;
                                                                    String str = qQMoreOptionButton2.text;
                                                                    float f19 = qQMoreOptionButton2.textFontSize;
                                                                    TextKt.a(str, null, null, qQMoreOptionButton2.textColor, Float.valueOf(f19), null, qQMoreOptionButton2.textFontWeight, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer7, 4096, 0, 0, 134217638);
                                                                    composer7.endReplaceableGroup();
                                                                }
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                    ComposerKt.traceEventEnd();
                                                                }
                                                            }
                                                            return Unit.INSTANCE;
                                                        }
                                                    }), composer5, 3128, 4);
                                                    composer5.endReplaceableGroup();
                                                }
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                        return Unit.INSTANCE;
                                    }
                                }), composer3, 196616, 30);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                return Unit.INSTANCE;
                            }
                        }), startRestartGroup, 14155784, 0, MsgConstant.KRMFILETHUMBSIZE384, 3669818);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        iVar7 = iVar12;
                        iVar8 = iVar10;
                        List<QQMoreOptionButton> list5 = list2;
                        function06 = function05;
                        function07 = function04;
                        iVar9 = iVar6;
                        list3 = list5;
                    }
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup != null) {
                        return;
                    }
                    final i iVar14 = iVar8;
                    endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QQMoreOptionContentViewKt$QQMoreOptionContentView$5
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Unit invoke(Composer composer2, Integer num) {
                            num.intValue();
                            QQMoreOptionContentViewKt.QQMoreOptionContentView(i.this, z16, iVar7, function2, f18, function07, iVar9, list3, function06, composer2, i3 | 1, i16);
                            return Unit.INSTANCE;
                        }
                    });
                    return;
                }
                function03 = function0;
                i19 = i16 & 64;
                if (i19 != 0) {
                }
                i26 = i16 & 128;
                if (i26 != 0) {
                }
                i27 = i16 & 256;
                if (i27 == 0) {
                }
                if ((i16 & 197) != 197) {
                }
                startRestartGroup.startDefaults();
                if ((i3 & 1) == 0) {
                }
                if (i29 == 0) {
                }
                if (i37 == 0) {
                }
                if (i17 == 0) {
                }
                if (i18 == 0) {
                }
                if (i19 == 0) {
                }
                if (i26 == 0) {
                }
                if (i27 == 0) {
                }
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                d a162 = e.a(0, 0.0f, startRestartGroup, 0, 3);
                if (!z16) {
                }
                startRestartGroup.startReplaceableGroup(-492369756);
                rememberedValue = startRestartGroup.rememberedValue();
                if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                }
                startRestartGroup.endReplaceableGroup();
                final MutableState<Float> mutableState2 = (MutableState) rememberedValue;
                i k36 = ComposeLayoutPropUpdaterKt.k(iVar4, ((Number) mutableState2.getValue()).floatValue());
                Boolean bool2 = Boolean.FALSE;
                z17 = false;
                i iVar102 = iVar4;
                final d dVar22 = dVar;
                Object[] objArr2 = {Float.valueOf(f18), function04, dVar22, function05};
                startRestartGroup.startReplaceableGroup(-568225417);
                while (i28 < 4) {
                }
                rememberedValue2 = startRestartGroup.rememberedValue();
                if (!z17) {
                }
                rememberedValue2 = new Function1<ScrollParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QQMoreOptionContentViewKt$QQMoreOptionContentView$3$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ScrollParams scrollParams) {
                        if (scrollParams.getOffsetX() < f18) {
                            function04.invoke();
                            d.x(dVar22, 0, 0.0f, true, null, 8, null);
                        } else {
                            function05.invoke();
                            d.x(dVar22, 1, 0.0f, true, null, 8, null);
                        }
                        return Unit.INSTANCE;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
                startRestartGroup.endReplaceableGroup();
                final i iVar112 = iVar5;
                i iVar122 = iVar5;
                final i iVar132 = iVar6;
                final int i382 = i36;
                final List<QQMoreOptionButton> list42 = list2;
                LazyRowKt.a(k36, null, dVar22, null, null, null, bool2, bool2, null, null, null, 0, null, null, null, null, null, null, null, (Function1) rememberedValue2, null, null, ComposableLambdaKt.composableLambda(startRestartGroup, 268776613, true, new Function3<a, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QQMoreOptionContentViewKt$QQMoreOptionContentView$4
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public final Unit invoke(a aVar, Composer composer2, Integer num) {
                        Composer composer3 = composer2;
                        int intValue = num.intValue();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(268776613, intValue, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QQMoreOptionContentView.<anonymous> (QQMoreOptionContentView.kt:116)");
                        }
                        i iVar142 = i.this;
                        final MutableState<Float> mutableState22 = mutableState2;
                        composer3.startReplaceableGroup(1157296644);
                        boolean changed = composer3.changed(mutableState22);
                        Object rememberedValue3 = composer3.rememberedValue();
                        if (changed || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                            rememberedValue3 = new Function1<w, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QQMoreOptionContentViewKt$QQMoreOptionContentView$4$1$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(w wVar) {
                                    mutableState22.setValue(Float.valueOf(wVar.getHeight()));
                                    return Unit.INSTANCE;
                                }
                            };
                            composer3.updateRememberedValue(rememberedValue3);
                        }
                        composer3.endReplaceableGroup();
                        i m3 = ViewEventPropUpdaterKt.m(iVar142, (Function1) rememberedValue3);
                        final Function2<? super Composer, ? super Integer, Unit> function22 = function2;
                        final int i39 = i382;
                        BoxKt.a(m3, null, null, ComposableLambdaKt.composableLambda(composer3, -1158008993, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QQMoreOptionContentViewKt$QQMoreOptionContentView$4.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public final Unit invoke(b bVar, Composer composer4, Integer num2) {
                                Composer composer5 = composer4;
                                int intValue2 = num2.intValue();
                                if ((intValue2 & 81) == 16 && composer5.getSkipping()) {
                                    composer5.skipToGroupEnd();
                                } else {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1158008993, intValue2, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QQMoreOptionContentView.<anonymous>.<anonymous> (QQMoreOptionContentView.kt:123)");
                                    }
                                    function22.invoke(composer5, Integer.valueOf((i39 >> 9) & 14));
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                                return Unit.INSTANCE;
                            }
                        }), composer3, 3080, 6);
                        i iVar15 = iVar132;
                        final List<QQMoreOptionButton> list52 = list42;
                        RowKt.a(iVar15, null, null, null, null, ComposableLambdaKt.composableLambda(composer3, -1984152381, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QQMoreOptionContentViewKt$QQMoreOptionContentView$4.3
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public final Unit invoke(n nVar, Composer composer4, Integer num2) {
                                Composer composer5 = composer4;
                                int intValue2 = num2.intValue();
                                if ((intValue2 & 81) == 16 && composer5.getSkipping()) {
                                    composer5.skipToGroupEnd();
                                } else {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1984152381, intValue2, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QQMoreOptionContentView.<anonymous>.<anonymous> (QQMoreOptionContentView.kt:130)");
                                    }
                                    for (final QQMoreOptionButton qQMoreOptionButton : list52) {
                                        if (qQMoreOptionButton.buttonBuilder != null) {
                                            composer5.startReplaceableGroup(-492986463);
                                            qQMoreOptionButton.buttonBuilder.invoke(composer5, 0);
                                            composer5.endReplaceableGroup();
                                        } else {
                                            composer5.startReplaceableGroup(-492986372);
                                            BoxKt.a(ViewEventPropUpdaterKt.d(ModifiersKt.d(ComposeLayoutPropUpdaterKt.w(ComposeLayoutPropUpdaterKt.f(i.INSTANCE, 0.0f, 1, null), qQMoreOptionButton.buttonWidth), qQMoreOptionButton.buttonColor), false, null, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QQMoreOptionContentViewKt$QQMoreOptionContentView$4$3$1$1
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(ClickParams clickParams) {
                                                    QQMoreOptionButton.this.buttonClickFn.invoke();
                                                    return Unit.INSTANCE;
                                                }
                                            }, 3, null), Alignment.Center, null, ComposableLambdaKt.composableLambda(composer5, 1184641522, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QQMoreOptionContentViewKt$QQMoreOptionContentView$4$3$1$2
                                                {
                                                    super(3);
                                                }

                                                @Override // kotlin.jvm.functions.Function3
                                                public final Unit invoke(b bVar, Composer composer6, Integer num3) {
                                                    Composer composer7 = composer6;
                                                    int intValue3 = num3.intValue();
                                                    if ((intValue3 & 81) == 16 && composer7.getSkipping()) {
                                                        composer7.skipToGroupEnd();
                                                    } else {
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(1184641522, intValue3, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QQMoreOptionContentView.<anonymous>.<anonymous>.<anonymous>.<anonymous> (QQMoreOptionContentView.kt:145)");
                                                        }
                                                        if (QQMoreOptionButton.this.textBuilder != null) {
                                                            composer7.startReplaceableGroup(1230118171);
                                                            QQMoreOptionButton.this.textBuilder.invoke(composer7, 0);
                                                            composer7.endReplaceableGroup();
                                                        } else {
                                                            composer7.startReplaceableGroup(1230118260);
                                                            QQMoreOptionButton qQMoreOptionButton2 = QQMoreOptionButton.this;
                                                            String str = qQMoreOptionButton2.text;
                                                            float f19 = qQMoreOptionButton2.textFontSize;
                                                            TextKt.a(str, null, null, qQMoreOptionButton2.textColor, Float.valueOf(f19), null, qQMoreOptionButton2.textFontWeight, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer7, 4096, 0, 0, 134217638);
                                                            composer7.endReplaceableGroup();
                                                        }
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventEnd();
                                                        }
                                                    }
                                                    return Unit.INSTANCE;
                                                }
                                            }), composer5, 3128, 4);
                                            composer5.endReplaceableGroup();
                                        }
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                                return Unit.INSTANCE;
                            }
                        }), composer3, 196616, 30);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        return Unit.INSTANCE;
                    }
                }), startRestartGroup, 14155784, 0, MsgConstant.KRMFILETHUMBSIZE384, 3669818);
                if (ComposerKt.isTraceInProgress()) {
                }
                iVar7 = iVar122;
                iVar8 = iVar102;
                List<QQMoreOptionButton> list52 = list2;
                function06 = function05;
                function07 = function04;
                iVar9 = iVar6;
                list3 = list52;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            f17 = f16;
            i18 = i16 & 32;
            if (i18 != 0) {
            }
            function03 = function0;
            i19 = i16 & 64;
            if (i19 != 0) {
            }
            i26 = i16 & 128;
            if (i26 != 0) {
            }
            i27 = i16 & 256;
            if (i27 == 0) {
            }
            if ((i16 & 197) != 197) {
            }
            startRestartGroup.startDefaults();
            if ((i3 & 1) == 0) {
            }
            if (i29 == 0) {
            }
            if (i37 == 0) {
            }
            if (i17 == 0) {
            }
            if (i18 == 0) {
            }
            if (i19 == 0) {
            }
            if (i26 == 0) {
            }
            if (i27 == 0) {
            }
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            d a1622 = e.a(0, 0.0f, startRestartGroup, 0, 3);
            if (!z16) {
            }
            startRestartGroup.startReplaceableGroup(-492369756);
            rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
            }
            startRestartGroup.endReplaceableGroup();
            final MutableState<Float> mutableState22 = (MutableState) rememberedValue;
            i k362 = ComposeLayoutPropUpdaterKt.k(iVar4, ((Number) mutableState22.getValue()).floatValue());
            Boolean bool22 = Boolean.FALSE;
            z17 = false;
            i iVar1022 = iVar4;
            final d dVar222 = dVar;
            Object[] objArr22 = {Float.valueOf(f18), function04, dVar222, function05};
            startRestartGroup.startReplaceableGroup(-568225417);
            while (i28 < 4) {
            }
            rememberedValue2 = startRestartGroup.rememberedValue();
            if (!z17) {
            }
            rememberedValue2 = new Function1<ScrollParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QQMoreOptionContentViewKt$QQMoreOptionContentView$3$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(ScrollParams scrollParams) {
                    if (scrollParams.getOffsetX() < f18) {
                        function04.invoke();
                        d.x(dVar222, 0, 0.0f, true, null, 8, null);
                    } else {
                        function05.invoke();
                        d.x(dVar222, 1, 0.0f, true, null, 8, null);
                    }
                    return Unit.INSTANCE;
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue2);
            startRestartGroup.endReplaceableGroup();
            final i iVar1122 = iVar5;
            i iVar1222 = iVar5;
            final i iVar1322 = iVar6;
            final int i3822 = i36;
            final List<QQMoreOptionButton> list422 = list2;
            LazyRowKt.a(k362, null, dVar222, null, null, null, bool22, bool22, null, null, null, 0, null, null, null, null, null, null, null, (Function1) rememberedValue2, null, null, ComposableLambdaKt.composableLambda(startRestartGroup, 268776613, true, new Function3<a, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QQMoreOptionContentViewKt$QQMoreOptionContentView$4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public final Unit invoke(a aVar, Composer composer2, Integer num) {
                    Composer composer3 = composer2;
                    int intValue = num.intValue();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(268776613, intValue, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QQMoreOptionContentView.<anonymous> (QQMoreOptionContentView.kt:116)");
                    }
                    i iVar142 = i.this;
                    final MutableState<Float> mutableState222 = mutableState22;
                    composer3.startReplaceableGroup(1157296644);
                    boolean changed = composer3.changed(mutableState222);
                    Object rememberedValue3 = composer3.rememberedValue();
                    if (changed || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue3 = new Function1<w, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QQMoreOptionContentViewKt$QQMoreOptionContentView$4$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(w wVar) {
                                mutableState222.setValue(Float.valueOf(wVar.getHeight()));
                                return Unit.INSTANCE;
                            }
                        };
                        composer3.updateRememberedValue(rememberedValue3);
                    }
                    composer3.endReplaceableGroup();
                    i m3 = ViewEventPropUpdaterKt.m(iVar142, (Function1) rememberedValue3);
                    final Function2<? super Composer, ? super Integer, Unit> function22 = function2;
                    final int i39 = i3822;
                    BoxKt.a(m3, null, null, ComposableLambdaKt.composableLambda(composer3, -1158008993, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QQMoreOptionContentViewKt$QQMoreOptionContentView$4.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public final Unit invoke(b bVar, Composer composer4, Integer num2) {
                            Composer composer5 = composer4;
                            int intValue2 = num2.intValue();
                            if ((intValue2 & 81) == 16 && composer5.getSkipping()) {
                                composer5.skipToGroupEnd();
                            } else {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1158008993, intValue2, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QQMoreOptionContentView.<anonymous>.<anonymous> (QQMoreOptionContentView.kt:123)");
                                }
                                function22.invoke(composer5, Integer.valueOf((i39 >> 9) & 14));
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }), composer3, 3080, 6);
                    i iVar15 = iVar1322;
                    final List<QQMoreOptionButton> list522 = list422;
                    RowKt.a(iVar15, null, null, null, null, ComposableLambdaKt.composableLambda(composer3, -1984152381, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QQMoreOptionContentViewKt$QQMoreOptionContentView$4.3
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public final Unit invoke(n nVar, Composer composer4, Integer num2) {
                            Composer composer5 = composer4;
                            int intValue2 = num2.intValue();
                            if ((intValue2 & 81) == 16 && composer5.getSkipping()) {
                                composer5.skipToGroupEnd();
                            } else {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1984152381, intValue2, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QQMoreOptionContentView.<anonymous>.<anonymous> (QQMoreOptionContentView.kt:130)");
                                }
                                for (final QQMoreOptionButton qQMoreOptionButton : list522) {
                                    if (qQMoreOptionButton.buttonBuilder != null) {
                                        composer5.startReplaceableGroup(-492986463);
                                        qQMoreOptionButton.buttonBuilder.invoke(composer5, 0);
                                        composer5.endReplaceableGroup();
                                    } else {
                                        composer5.startReplaceableGroup(-492986372);
                                        BoxKt.a(ViewEventPropUpdaterKt.d(ModifiersKt.d(ComposeLayoutPropUpdaterKt.w(ComposeLayoutPropUpdaterKt.f(i.INSTANCE, 0.0f, 1, null), qQMoreOptionButton.buttonWidth), qQMoreOptionButton.buttonColor), false, null, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QQMoreOptionContentViewKt$QQMoreOptionContentView$4$3$1$1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ClickParams clickParams) {
                                                QQMoreOptionButton.this.buttonClickFn.invoke();
                                                return Unit.INSTANCE;
                                            }
                                        }, 3, null), Alignment.Center, null, ComposableLambdaKt.composableLambda(composer5, 1184641522, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QQMoreOptionContentViewKt$QQMoreOptionContentView$4$3$1$2
                                            {
                                                super(3);
                                            }

                                            @Override // kotlin.jvm.functions.Function3
                                            public final Unit invoke(b bVar, Composer composer6, Integer num3) {
                                                Composer composer7 = composer6;
                                                int intValue3 = num3.intValue();
                                                if ((intValue3 & 81) == 16 && composer7.getSkipping()) {
                                                    composer7.skipToGroupEnd();
                                                } else {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(1184641522, intValue3, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QQMoreOptionContentView.<anonymous>.<anonymous>.<anonymous>.<anonymous> (QQMoreOptionContentView.kt:145)");
                                                    }
                                                    if (QQMoreOptionButton.this.textBuilder != null) {
                                                        composer7.startReplaceableGroup(1230118171);
                                                        QQMoreOptionButton.this.textBuilder.invoke(composer7, 0);
                                                        composer7.endReplaceableGroup();
                                                    } else {
                                                        composer7.startReplaceableGroup(1230118260);
                                                        QQMoreOptionButton qQMoreOptionButton2 = QQMoreOptionButton.this;
                                                        String str = qQMoreOptionButton2.text;
                                                        float f19 = qQMoreOptionButton2.textFontSize;
                                                        TextKt.a(str, null, null, qQMoreOptionButton2.textColor, Float.valueOf(f19), null, qQMoreOptionButton2.textFontWeight, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer7, 4096, 0, 0, 134217638);
                                                        composer7.endReplaceableGroup();
                                                    }
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                    }
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        }), composer5, 3128, 4);
                                        composer5.endReplaceableGroup();
                                    }
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }), composer3, 196616, 30);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    return Unit.INSTANCE;
                }
            }), startRestartGroup, 14155784, 0, MsgConstant.KRMFILETHUMBSIZE384, 3669818);
            if (ComposerKt.isTraceInProgress()) {
            }
            iVar7 = iVar1222;
            iVar8 = iVar1022;
            List<QQMoreOptionButton> list522 = list2;
            function06 = function05;
            function07 = function04;
            iVar9 = iVar6;
            list3 = list522;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        i17 = i16 & 16;
        if (i17 == 0) {
        }
        f17 = f16;
        i18 = i16 & 32;
        if (i18 != 0) {
        }
        function03 = function0;
        i19 = i16 & 64;
        if (i19 != 0) {
        }
        i26 = i16 & 128;
        if (i26 != 0) {
        }
        i27 = i16 & 256;
        if (i27 == 0) {
        }
        if ((i16 & 197) != 197) {
        }
        startRestartGroup.startDefaults();
        if ((i3 & 1) == 0) {
        }
        if (i29 == 0) {
        }
        if (i37 == 0) {
        }
        if (i17 == 0) {
        }
        if (i18 == 0) {
        }
        if (i19 == 0) {
        }
        if (i26 == 0) {
        }
        if (i27 == 0) {
        }
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        d a16222 = e.a(0, 0.0f, startRestartGroup, 0, 3);
        if (!z16) {
        }
        startRestartGroup.startReplaceableGroup(-492369756);
        rememberedValue = startRestartGroup.rememberedValue();
        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
        }
        startRestartGroup.endReplaceableGroup();
        final MutableState<Float> mutableState222 = (MutableState) rememberedValue;
        i k3622 = ComposeLayoutPropUpdaterKt.k(iVar4, ((Number) mutableState222.getValue()).floatValue());
        Boolean bool222 = Boolean.FALSE;
        z17 = false;
        i iVar10222 = iVar4;
        final d dVar2222 = dVar;
        Object[] objArr222 = {Float.valueOf(f18), function04, dVar2222, function05};
        startRestartGroup.startReplaceableGroup(-568225417);
        while (i28 < 4) {
        }
        rememberedValue2 = startRestartGroup.rememberedValue();
        if (!z17) {
        }
        rememberedValue2 = new Function1<ScrollParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QQMoreOptionContentViewKt$QQMoreOptionContentView$3$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ScrollParams scrollParams) {
                if (scrollParams.getOffsetX() < f18) {
                    function04.invoke();
                    d.x(dVar2222, 0, 0.0f, true, null, 8, null);
                } else {
                    function05.invoke();
                    d.x(dVar2222, 1, 0.0f, true, null, 8, null);
                }
                return Unit.INSTANCE;
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue2);
        startRestartGroup.endReplaceableGroup();
        final i iVar11222 = iVar5;
        i iVar12222 = iVar5;
        final i iVar13222 = iVar6;
        final int i38222 = i36;
        final List<QQMoreOptionButton> list4222 = list2;
        LazyRowKt.a(k3622, null, dVar2222, null, null, null, bool222, bool222, null, null, null, 0, null, null, null, null, null, null, null, (Function1) rememberedValue2, null, null, ComposableLambdaKt.composableLambda(startRestartGroup, 268776613, true, new Function3<a, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QQMoreOptionContentViewKt$QQMoreOptionContentView$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public final Unit invoke(a aVar, Composer composer2, Integer num) {
                Composer composer3 = composer2;
                int intValue = num.intValue();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(268776613, intValue, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QQMoreOptionContentView.<anonymous> (QQMoreOptionContentView.kt:116)");
                }
                i iVar142 = i.this;
                final MutableState<Float> mutableState2222 = mutableState222;
                composer3.startReplaceableGroup(1157296644);
                boolean changed = composer3.changed(mutableState2222);
                Object rememberedValue3 = composer3.rememberedValue();
                if (changed || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue3 = new Function1<w, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QQMoreOptionContentViewKt$QQMoreOptionContentView$4$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(w wVar) {
                            mutableState2222.setValue(Float.valueOf(wVar.getHeight()));
                            return Unit.INSTANCE;
                        }
                    };
                    composer3.updateRememberedValue(rememberedValue3);
                }
                composer3.endReplaceableGroup();
                i m3 = ViewEventPropUpdaterKt.m(iVar142, (Function1) rememberedValue3);
                final Function2<? super Composer, ? super Integer, Unit> function22 = function2;
                final int i39 = i38222;
                BoxKt.a(m3, null, null, ComposableLambdaKt.composableLambda(composer3, -1158008993, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QQMoreOptionContentViewKt$QQMoreOptionContentView$4.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public final Unit invoke(b bVar, Composer composer4, Integer num2) {
                        Composer composer5 = composer4;
                        int intValue2 = num2.intValue();
                        if ((intValue2 & 81) == 16 && composer5.getSkipping()) {
                            composer5.skipToGroupEnd();
                        } else {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1158008993, intValue2, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QQMoreOptionContentView.<anonymous>.<anonymous> (QQMoreOptionContentView.kt:123)");
                            }
                            function22.invoke(composer5, Integer.valueOf((i39 >> 9) & 14));
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                        return Unit.INSTANCE;
                    }
                }), composer3, 3080, 6);
                i iVar15 = iVar13222;
                final List<QQMoreOptionButton> list5222 = list4222;
                RowKt.a(iVar15, null, null, null, null, ComposableLambdaKt.composableLambda(composer3, -1984152381, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QQMoreOptionContentViewKt$QQMoreOptionContentView$4.3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public final Unit invoke(n nVar, Composer composer4, Integer num2) {
                        Composer composer5 = composer4;
                        int intValue2 = num2.intValue();
                        if ((intValue2 & 81) == 16 && composer5.getSkipping()) {
                            composer5.skipToGroupEnd();
                        } else {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1984152381, intValue2, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QQMoreOptionContentView.<anonymous>.<anonymous> (QQMoreOptionContentView.kt:130)");
                            }
                            for (final QQMoreOptionButton qQMoreOptionButton : list5222) {
                                if (qQMoreOptionButton.buttonBuilder != null) {
                                    composer5.startReplaceableGroup(-492986463);
                                    qQMoreOptionButton.buttonBuilder.invoke(composer5, 0);
                                    composer5.endReplaceableGroup();
                                } else {
                                    composer5.startReplaceableGroup(-492986372);
                                    BoxKt.a(ViewEventPropUpdaterKt.d(ModifiersKt.d(ComposeLayoutPropUpdaterKt.w(ComposeLayoutPropUpdaterKt.f(i.INSTANCE, 0.0f, 1, null), qQMoreOptionButton.buttonWidth), qQMoreOptionButton.buttonColor), false, null, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QQMoreOptionContentViewKt$QQMoreOptionContentView$4$3$1$1
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(ClickParams clickParams) {
                                            QQMoreOptionButton.this.buttonClickFn.invoke();
                                            return Unit.INSTANCE;
                                        }
                                    }, 3, null), Alignment.Center, null, ComposableLambdaKt.composableLambda(composer5, 1184641522, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QQMoreOptionContentViewKt$QQMoreOptionContentView$4$3$1$2
                                        {
                                            super(3);
                                        }

                                        @Override // kotlin.jvm.functions.Function3
                                        public final Unit invoke(b bVar, Composer composer6, Integer num3) {
                                            Composer composer7 = composer6;
                                            int intValue3 = num3.intValue();
                                            if ((intValue3 & 81) == 16 && composer7.getSkipping()) {
                                                composer7.skipToGroupEnd();
                                            } else {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(1184641522, intValue3, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QQMoreOptionContentView.<anonymous>.<anonymous>.<anonymous>.<anonymous> (QQMoreOptionContentView.kt:145)");
                                                }
                                                if (QQMoreOptionButton.this.textBuilder != null) {
                                                    composer7.startReplaceableGroup(1230118171);
                                                    QQMoreOptionButton.this.textBuilder.invoke(composer7, 0);
                                                    composer7.endReplaceableGroup();
                                                } else {
                                                    composer7.startReplaceableGroup(1230118260);
                                                    QQMoreOptionButton qQMoreOptionButton2 = QQMoreOptionButton.this;
                                                    String str = qQMoreOptionButton2.text;
                                                    float f19 = qQMoreOptionButton2.textFontSize;
                                                    TextKt.a(str, null, null, qQMoreOptionButton2.textColor, Float.valueOf(f19), null, qQMoreOptionButton2.textFontWeight, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer7, 4096, 0, 0, 134217638);
                                                    composer7.endReplaceableGroup();
                                                }
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                            return Unit.INSTANCE;
                                        }
                                    }), composer5, 3128, 4);
                                    composer5.endReplaceableGroup();
                                }
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                        return Unit.INSTANCE;
                    }
                }), composer3, 196616, 30);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                return Unit.INSTANCE;
            }
        }), startRestartGroup, 14155784, 0, MsgConstant.KRMFILETHUMBSIZE384, 3669818);
        if (ComposerKt.isTraceInProgress()) {
        }
        iVar7 = iVar12222;
        iVar8 = iVar10222;
        List<QQMoreOptionButton> list5222 = list2;
        function06 = function05;
        function07 = function04;
        iVar9 = iVar6;
        list3 = list5222;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }
}
