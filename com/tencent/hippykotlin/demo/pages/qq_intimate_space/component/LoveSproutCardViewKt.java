package com.tencent.hippykotlin.demo.pages.qq_intimate_space.component;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import bp3.a;
import bp3.j;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSBottomDynamicGuideEvent;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.h;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.event.ViewEventPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.BoxKt;
import com.tencent.ntcompose.foundation.layout.ColumnKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.b;
import com.tencent.ntcompose.foundation.layout.base.Alignment;
import com.tencent.ntcompose.foundation.layout.d;
import com.tencent.ntcompose.material.APNGKt;
import com.tencent.ntcompose.material.ImageKt;
import com.tencent.ntcompose.material.RichTextKt;
import com.tencent.ntcompose.material.ai;
import com.tencent.ntcompose.material.base.ModifiersKt;
import com.tencent.ntcompose.material.n;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: P */
/* loaded from: classes37.dex */
public final class LoveSproutCardViewKt {
    public static final List<String> extractBracketedContent(String str) {
        ArrayList arrayList = new ArrayList();
        StringBuilder sb5 = new StringBuilder();
        int length = str.length();
        boolean z16 = false;
        for (int i3 = 0; i3 < length; i3++) {
            char charAt = str.charAt(i3);
            if (charAt == '[') {
                if (z16) {
                    sb5 = new StringBuilder();
                }
                z16 = true;
            } else if (charAt == ']') {
                if (z16) {
                    arrayList.add(sb5.toString());
                    sb5 = new StringBuilder();
                    z16 = false;
                }
            } else if (z16) {
                sb5.append(charAt);
            }
        }
        return arrayList;
    }

    public static final a highlightedText(String str, j jVar, List<String> list, j jVar2) {
        boolean z16;
        int collectionSizeOrDefault;
        Comparable minOrNull;
        int length;
        int e16;
        int indexOf$default;
        int indexOf$default2;
        a.C0144a c0144a = new a.C0144a(0, 1, null);
        int i3 = 0;
        while (i3 < str.length()) {
            String str2 = null;
            int i16 = -1;
            for (String str3 : list) {
                indexOf$default2 = StringsKt__StringsKt.indexOf$default((CharSequence) str, str3, i3, false, 4, (Object) null);
                if (indexOf$default2 == i3 && (str2 == null || str3.length() > str2.length())) {
                    i16 = indexOf$default2;
                    str2 = str3;
                }
            }
            if (str2 == null || i16 != i3) {
                z16 = false;
            } else {
                e16 = c0144a.e(jVar2);
                try {
                    c0144a.a(str2);
                    Unit unit = Unit.INSTANCE;
                    c0144a.c(e16);
                    i3 += str2.length();
                    z16 = true;
                } finally {
                }
            }
            int i17 = i3;
            if (z16) {
                i3 = i17;
            } else {
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
                ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) str, (String) it.next(), i17, false, 4, (Object) null);
                    arrayList.add(Integer.valueOf(indexOf$default));
                }
                ArrayList arrayList2 = new ArrayList();
                Iterator it5 = arrayList.iterator();
                while (it5.hasNext()) {
                    Object next = it5.next();
                    if (((Number) next).intValue() >= 0) {
                        arrayList2.add(next);
                    }
                }
                minOrNull = CollectionsKt___CollectionsKt.minOrNull((Iterable<? extends Comparable>) arrayList2);
                Integer num = (Integer) minOrNull;
                if (num != null) {
                    length = num.intValue();
                } else {
                    length = str.length();
                }
                i3 = length;
                e16 = c0144a.e(jVar);
                try {
                    String substring = str.substring(i17, i3);
                    Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                    c0144a.a(substring);
                    Unit unit2 = Unit.INSTANCE;
                } finally {
                }
            }
        }
        return c0144a.f();
    }

    public static final void LoveSproutCardView(final i iVar, final LoveSproutCardConfig loveSproutCardConfig, final Function0<Unit> function0, Composer composer, final int i3, final int i16) {
        Composer startRestartGroup = composer.startRestartGroup(-602494364);
        if ((i16 & 4) != 0) {
            function0 = null;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-602494364, i3, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.component.LoveSproutCardView (LoveSproutCardView.kt:33)");
        }
        startRestartGroup.startReplaceableGroup(-492369756);
        Object rememberedValue = startRestartGroup.rememberedValue();
        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new LoveSproutCardViewModel(loveSproutCardConfig), null, 2, null);
            startRestartGroup.updateRememberedValue(rememberedValue);
        }
        startRestartGroup.endReplaceableGroup();
        final MutableState mutableState = (MutableState) rememberedValue;
        LoveWallFlowerGeneralCardKt.LoveWallFlowerGeneralCard(iVar, new LoveWallFlowerGeneralCardConfig(loveSproutCardConfig.flower.f395479e, loveSproutCardConfig.titleFontSize, loveSproutCardConfig.playFlowerAnimation), ComposableLambdaKt.composableLambda(startRestartGroup, -1015498056, true, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.component.LoveSproutCardViewKt$LoveSproutCardView$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                Composer composer3 = composer2;
                int intValue = num.intValue();
                if ((intValue & 11) == 2 && composer3.getSkipping()) {
                    composer3.skipToGroupEnd();
                } else {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1015498056, intValue, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.component.LoveSproutCardView.<anonymous> (LoveSproutCardView.kt:46)");
                    }
                    i j3 = ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null);
                    Alignment.Horizontal b16 = Alignment.INSTANCE.b();
                    final MutableState<LoveSproutCardViewModel> mutableState2 = mutableState;
                    final LoveSproutCardConfig loveSproutCardConfig2 = loveSproutCardConfig;
                    final Function0<Unit> function02 = function0;
                    final int i17 = i3;
                    ColumnKt.a(j3, null, b16, null, ComposableLambdaKt.composableLambda(composer3, -1280482655, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.component.LoveSproutCardViewKt$LoveSproutCardView$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public final Unit invoke(d dVar, Composer composer4, Integer num2) {
                            Composer composer5 = composer4;
                            int intValue2 = num2.intValue();
                            if ((intValue2 & 81) == 16 && composer5.getSkipping()) {
                                composer5.skipToGroupEnd();
                            } else {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1280482655, intValue2, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.component.LoveSproutCardView.<anonymous>.<anonymous> (LoveSproutCardView.kt:49)");
                                }
                                RichTextKt.b(LoveSproutCardViewKt.highlightedText(mutableState2.getValue().intro, new j(h.INSTANCE.b(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, 32766, null), mutableState2.getValue().introHighlightWords, new j(new h(255, 128, 0, 1.0f), null, null, null, new n("DINPro-Medium"), null, null, null, null, null, null, null, null, null, null, 32750, null)), null, null, null, Float.valueOf(loveSproutCardConfig2.introFontSize), null, null, null, null, null, ai.f(ai.INSTANCE.a()), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, composer5, 0, 0, 0, 268434414);
                                i.Companion companion = i.INSTANCE;
                                float f16 = 168;
                                ImageKt.a(null, null, null, null, null, ComposeLayoutPropUpdaterKt.n(ModifiersKt.j(ComposeLayoutPropUpdaterKt.v(companion, f16, f16), 8.0f), 0.0f, 10, 0.0f, 0.0f, 13, null), null, 0, null, null, loveSproutCardConfig2.flower.f395481h, null, null, null, null, null, null, null, null, null, null, composer5, 262144, 0, 0, 2096095);
                                if (function02 != null) {
                                    if (loveSproutCardConfig2.buttonApngUrl != null) {
                                        composer5.startReplaceableGroup(1788286846);
                                        BoxKt.a(ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(companion, 0.0f, 1, null), 60.0f), 0.0f, 8, 0.0f, 0.0f, 13, null), null, null, ComposableLambdaKt.composableLambda(composer5, -469262043, true, new Function3<b, Composer, Integer, Unit>(function02, i17, loveSproutCardConfig2) { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.component.LoveSproutCardViewKt.LoveSproutCardView.1.1.1
                                            public final /* synthetic */ LoveSproutCardConfig $config;
                                            public final /* synthetic */ Function0<Unit> $onBtnClick;

                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(3);
                                                this.$config = r3;
                                            }

                                            @Override // kotlin.jvm.functions.Function3
                                            public final Unit invoke(b bVar, Composer composer6, Integer num3) {
                                                int i18;
                                                b bVar2 = bVar;
                                                Composer composer7 = composer6;
                                                int intValue3 = num3.intValue();
                                                if ((intValue3 & 14) == 0) {
                                                    i18 = (composer7.changed(bVar2) ? 4 : 2) | intValue3;
                                                } else {
                                                    i18 = intValue3;
                                                }
                                                if ((i18 & 91) == 18 && composer7.getSkipping()) {
                                                    composer7.skipToGroupEnd();
                                                } else {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(-469262043, intValue3, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.component.LoveSproutCardView.<anonymous>.<anonymous>.<anonymous> (LoveSproutCardView.kt:69)");
                                                    }
                                                    i.Companion companion2 = i.INSTANCE;
                                                    i v3 = ComposeLayoutPropUpdaterKt.v(companion2, 179.5f, 60.0f);
                                                    Alignment alignment = Alignment.Center;
                                                    i a16 = bVar2.a(v3, alignment);
                                                    final Function0<Unit> function03 = this.$onBtnClick;
                                                    composer7.startReplaceableGroup(1157296644);
                                                    boolean changed = composer7.changed(function03);
                                                    Object rememberedValue2 = composer7.rememberedValue();
                                                    if (changed || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                                        rememberedValue2 = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.component.LoveSproutCardViewKt$LoveSproutCardView$1$1$1$1$1
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ClickParams clickParams) {
                                                                function03.invoke();
                                                                return Unit.INSTANCE;
                                                            }
                                                        };
                                                        composer7.updateRememberedValue(rememberedValue2);
                                                    }
                                                    composer7.endReplaceableGroup();
                                                    APNGKt.a(ViewEventPropUpdaterKt.d(a16, false, null, (Function1) rememberedValue2, 3, null), null, this.$config.buttonApngUrl, 0, null, null, null, null, composer7, 3080, 242);
                                                    i o16 = ComposeLayoutPropUpdaterKt.o(bVar2.a(ComposeLayoutPropUpdaterKt.v(companion2, (float) 118.81d, 120), alignment), 84, 24);
                                                    final Function0<Unit> function04 = this.$onBtnClick;
                                                    composer7.startReplaceableGroup(1157296644);
                                                    boolean changed2 = composer7.changed(function04);
                                                    Object rememberedValue3 = composer7.rememberedValue();
                                                    if (changed2 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                                        rememberedValue3 = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.component.LoveSproutCardViewKt$LoveSproutCardView$1$1$1$2$1
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ClickParams clickParams) {
                                                                function04.invoke();
                                                                return Unit.INSTANCE;
                                                            }
                                                        };
                                                        composer7.updateRememberedValue(rememberedValue3);
                                                    }
                                                    composer7.endReplaceableGroup();
                                                    APNGKt.a(ViewEventPropUpdaterKt.d(o16, false, null, (Function1) rememberedValue3, 3, null), null, "https://image.superqqshow.qq.com/wuji/qq_zplan_config_test/couple_space_pic_resouce/4221bcd7_mSbOXa9EB79.png", 0, null, null, null, null, composer7, 3464, 242);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                    }
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        }), composer5, 3080, 6);
                                        composer5.endReplaceableGroup();
                                    } else {
                                        composer5.startReplaceableGroup(1788287868);
                                        i n3 = ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.v(companion, 168.0f, 45.0f), 0.0f, 16, 0.0f, 0.0f, 13, null);
                                        LoveWallButtonConfig loveWallButtonConfig = new LoveWallButtonConfig(loveSproutCardConfig2.buttonText, 16.0f, LoveWallButtonTextColor.YELLOW_BUTTON_COLORS, "https://image.superqqshow.qq.com/wuji/qq_zplan_config_test/couple_space_pic_resouce/4221bcd7_TnkBjfRXl8n.png");
                                        final Function0<Unit> function03 = function02;
                                        composer5.startReplaceableGroup(1157296644);
                                        boolean changed = composer5.changed(function03);
                                        Object rememberedValue2 = composer5.rememberedValue();
                                        if (changed || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                            rememberedValue2 = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.component.LoveSproutCardViewKt$LoveSproutCardView$1$1$2$1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(ClickParams clickParams) {
                                                    function03.invoke();
                                                    return Unit.INSTANCE;
                                                }
                                            };
                                            composer5.updateRememberedValue(rememberedValue2);
                                        }
                                        composer5.endReplaceableGroup();
                                        LoveWallButtonKt.LoveWallButton(n3, loveWallButtonConfig, (Function1) rememberedValue2, composer5, 8);
                                        composer5.endReplaceableGroup();
                                    }
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }), composer3, 24584, 10);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                return Unit.INSTANCE;
            }
        }), startRestartGroup, QFSBottomDynamicGuideEvent.DYNAMIC_GUIDE_BUTTON_TYPE, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        final Function0<Unit> function02 = function0;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.component.LoveSproutCardViewKt$LoveSproutCardView$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                LoveSproutCardViewKt.LoveSproutCardView(i.this, loveSproutCardConfig, function02, composer2, i3 | 1, i16);
                return Unit.INSTANCE;
            }
        });
    }
}
