package com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.center;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import bp3.c;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.hippykotlin.demo.pages.goods_center.card.product.GoodsCenterProductView$body$1$1$3$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTCenterUIConfig;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.w;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.event.ViewEventPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.ColumnKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.RowKt;
import com.tencent.ntcompose.foundation.layout.d;
import com.tencent.ntcompose.foundation.layout.n;
import com.tencent.ntcompose.material.ImageKt;
import com.tencent.ntcompose.material.TextKt;
import com.tencent.ntcompose.material.ai;
import defpackage.k;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* compiled from: P */
/* loaded from: classes37.dex */
public final class ComposableSingletons$QQFTCenterEmptyCardViewKt {
    public static final ComposableSingletons$QQFTCenterEmptyCardViewKt INSTANCE = new ComposableSingletons$QQFTCenterEmptyCardViewKt();

    /* renamed from: lambda-1, reason: not valid java name */
    public static Function3<d, Composer, Integer, Unit> f150lambda1 = ComposableLambdaKt.composableLambdaInstance(1436801893, false, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.center.ComposableSingletons$QQFTCenterEmptyCardViewKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function3
        public final Unit invoke(d dVar, Composer composer, Integer num) {
            Composer composer2 = composer;
            int intValue = num.intValue();
            if ((intValue & 81) == 16 && composer2.getSkipping()) {
                composer2.skipToGroupEnd();
            } else {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1436801893, intValue, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.center.ComposableSingletons$QQFTCenterEmptyCardViewKt.lambda-1.<anonymous> (QQFTCenterEmptyCardView.kt:55)");
                }
                i.Companion companion = i.INSTANCE;
                ImageKt.a(null, null, null, null, null, ComposeLayoutPropUpdaterKt.u(companion, 80.0f), null, 0, null, null, "data:image/png;base64,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", null, null, null, null, null, null, null, null, QUIToken.color$default("text_secondary"), null, composer2, 262144, 1073741830, 0, 1571807);
                float f16 = 24;
                TextKt.a("\u6682\u65e0\u8bb0\u5f55", ComposeLayoutPropUpdaterKt.n(companion, 0.0f, f16, 0.0f, 0.0f, 13, null), null, QUIToken.color$default("text_secondary"), Float.valueOf(17), null, c.INSTANCE.e(), null, null, null, ai.f(ai.INSTANCE.a()), Float.valueOf(f16), null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer2, 1601606, 48, 0, 134214564);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            return Unit.INSTANCE;
        }
    });

    /* renamed from: lambda-2, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f151lambda2 = ComposableLambdaKt.composableLambdaInstance(-1525488548, false, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.center.ComposableSingletons$QQFTCenterEmptyCardViewKt$lambda-2$1
        @Override // kotlin.jvm.functions.Function2
        public final Unit invoke(Composer composer, Integer num) {
            Composer composer2 = composer;
            int intValue = num.intValue();
            if ((intValue & 11) == 2 && composer2.getSkipping()) {
                composer2.skipToGroupEnd();
            } else {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1525488548, intValue, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.center.ComposableSingletons$QQFTCenterEmptyCardViewKt.lambda-2.<anonymous> (QQFTCenterEmptyCardView.kt:88)");
                }
                final boolean a16 = k.a(com.tencent.kuikly.core.manager.c.f117352a);
                final float f16 = a16 ? 12 : 14;
                final float f17 = a16 ? 12 : 16;
                final float f18 = a16 ? 8 : 12;
                final float f19 = 56;
                composer2.startReplaceableGroup(-492369756);
                Object rememberedValue = composer2.rememberedValue();
                if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                    rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.TRUE, null, 2, null);
                    composer2.updateRememberedValue(rememberedValue);
                }
                composer2.endReplaceableGroup();
                final MutableState mutableState = (MutableState) rememberedValue;
                float f26 = 8;
                RowKt.a(ComposeLayoutPropUpdaterKt.m(ComposeLayoutPropUpdaterKt.h(i.INSTANCE, 0.0f, 1, null), f17, f26, f17, f26), null, null, null, null, ComposableLambdaKt.composableLambda(composer2, -1807021826, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.center.ComposableSingletons$QQFTCenterEmptyCardViewKt$lambda-2$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public final Unit invoke(n nVar, Composer composer3, Integer num2) {
                        Composer composer4;
                        Composer composer5 = composer3;
                        int intValue2 = num2.intValue();
                        if ((intValue2 & 81) == 16 && composer5.getSkipping()) {
                            composer5.skipToGroupEnd();
                        } else {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1807021826, intValue2, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.center.ComposableSingletons$QQFTCenterEmptyCardViewKt.lambda-2.<anonymous>.<anonymous> (QQFTCenterEmptyCardView.kt:98)");
                            }
                            composer5.startReplaceableGroup(1880978474);
                            if (mutableState.getValue().booleanValue()) {
                                composer4 = composer5;
                                ImageKt.a(null, null, null, null, null, ComposeLayoutPropUpdaterKt.u(i.INSTANCE, f19), null, 0, null, null, "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAHAAAABwBAMAAAA0zul4AAAACXBIWXMAABYlAAAWJQFJUiTwAAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAAAbUExURUdwTDAwMjAwNjAwNC8wMy8wMzAwMy8wMy8wM91XOysAAAAIdFJOUwBfHD7kvn2c/YrSWQAAAcFJREFUWMPtlrFuwjAQhgOIpGNaVJUxAgZGCkvGCiSasa2KlDFtGfIAlcjakoR77NoO0LNjk8bqeP+AdNifz+dzfOc4JBKJRCKR/lfXGg2C+rz701hl9mLQ6aCS3e157JGPdfUcIxVwgsZWii3rRXYYoaF8xu31TBP3OFNc9qGYO+fgHhwPikB7YmxFH9sh2oEHX84UloaznrBlkTII0KKFZMtyYY/NuMCr5LKt7FUKMiqRMQTZliWvqYIsTJMyApvBkSXYiXw7sF9NsfAI4rZbxJiKOS3Bzm63+xQuW4LT6otftgbDCvxuDbqbzeYVILE6nCGUtulIrEBPOLQAXeHQJsZx20t++c2JDpZgnBufRygvgan80CN5/L6YwYmxBKTwdAl0IfcNFUAuDirIikfxtqjrLpJDrEB+df0j6BkLa1IH+ceyP4LO1sCtnAawe6vD8mel/MU84R221aQqcyJjI64hzNnvFN6FVauaWY7+igqpVvORK1NeQ5QdT7qoDWAf8ptTYxGjKt9bpDBgaQjhYzEzNBPoBALUG/yqNDQT2hPH6+nbAtSSrQN8M5s8oiYQH3mVkpE+FSQSiUQikf6kHx8/NGhrwQj0AAAAAElFTkSuQmCC", null, null, null, null, null, null, null, null, QUIToken.color$default("icon_primary"), null, composer4, 262144, 1073741830, 0, 1571807);
                            } else {
                                composer4 = composer5;
                            }
                            composer4.endReplaceableGroup();
                            i n3 = ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.A(i.INSTANCE), mutableState.getValue().booleanValue() ? f18 : 0.0f, 0.0f, 0.0f, 0.0f, 14, null);
                            final boolean z16 = a16;
                            final MutableState<Boolean> mutableState2 = mutableState;
                            final float f27 = f19;
                            final float f28 = f17;
                            final float f29 = f18;
                            final float f36 = f16;
                            Function3<d, Composer, Integer, Unit> function3 = new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.center.ComposableSingletons.QQFTCenterEmptyCardViewKt.lambda-2.1.1.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public final Unit invoke(d dVar, Composer composer6, Integer num3) {
                                    String str;
                                    Composer composer7 = composer6;
                                    int intValue3 = num3.intValue();
                                    if ((intValue3 & 81) == 16 && composer7.getSkipping()) {
                                        composer7.skipToGroupEnd();
                                    } else {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-130328139, intValue3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.center.ComposableSingletons$QQFTCenterEmptyCardViewKt.lambda-2.<anonymous>.<anonymous>.<anonymous> (QQFTCenterEmptyCardView.kt:102)");
                                        }
                                        i.Companion companion = i.INSTANCE;
                                        i n16 = ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.A(companion), 0.0f, 6, 0.0f, 0.0f, 13, null);
                                        if (z16) {
                                            str = "\u8bf7\u4f7f\u7528\u7535\u8111\u7248\u5206\u4eab\u6587\u4ef6\uff0c\u624b\u673a\u7248\u5373\u5c06\u4e0a\u7ebf";
                                        } else {
                                            str = "\u8bf7\u4f7f\u7528\u7535\u8111\u7248QQ\u95ea\u4f20\u5206\u4eab\u6587\u4ef6";
                                        }
                                        TextKt.a(str, n16, null, QUIToken.color$default("text_primary"), Float.valueOf(z16 ? 13 : 16), null, c.INSTANCE.f(), null, null, null, ai.f(ai.INSTANCE.a()), Float.valueOf(20), null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer7, 1577024, 48, 0, 134214564);
                                        i A = ComposeLayoutPropUpdaterKt.A(companion);
                                        Object[] objArr = {mutableState2, Float.valueOf(f27), Float.valueOf(f28), Float.valueOf(f29)};
                                        final MutableState<Boolean> mutableState3 = mutableState2;
                                        final float f37 = f27;
                                        final float f38 = f28;
                                        final float f39 = f29;
                                        composer7.startReplaceableGroup(-568225417);
                                        boolean z17 = false;
                                        for (int i3 = 0; i3 < 4; i3++) {
                                            z17 |= composer7.changed(objArr[i3]);
                                        }
                                        Object rememberedValue2 = composer7.rememberedValue();
                                        if (z17 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                            rememberedValue2 = new Function1<w, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.center.ComposableSingletons$QQFTCenterEmptyCardViewKt$lambda-2$1$1$1$1$1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(w wVar) {
                                                    MutableState<Boolean> mutableState4 = mutableState3;
                                                    float width = wVar.getWidth();
                                                    QQFTCenterUIConfig qQFTCenterUIConfig = QQFTCenterUIConfig.INSTANCE;
                                                    float f46 = 2;
                                                    mutableState4.setValue(Boolean.valueOf(width < (((GoodsCenterProductView$body$1$1$3$$ExternalSyntheticOutline0.m(com.tencent.kuikly.core.manager.c.f117352a) - (QQFTCenterUIConfig.insetLeft * f46)) - f37) - (f38 * f46)) - f39));
                                                    return Unit.INSTANCE;
                                                }
                                            };
                                            composer7.updateRememberedValue(rememberedValue2);
                                        }
                                        composer7.endReplaceableGroup();
                                        i m3 = ViewEventPropUpdaterKt.m(A, (Function1) rememberedValue2);
                                        final float f46 = f36;
                                        RowKt.a(m3, null, null, null, null, ComposableLambdaKt.composableLambda(composer7, -81672745, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.center.ComposableSingletons.QQFTCenterEmptyCardViewKt.lambda-2.1.1.1.2
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(3);
                                            }

                                            @Override // kotlin.jvm.functions.Function3
                                            public final Unit invoke(n nVar2, Composer composer8, Integer num4) {
                                                Composer composer9 = composer8;
                                                int intValue4 = num4.intValue();
                                                if ((intValue4 & 81) == 16 && composer9.getSkipping()) {
                                                    composer9.skipToGroupEnd();
                                                } else {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(-81672745, intValue4, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.center.ComposableSingletons$QQFTCenterEmptyCardViewKt.lambda-2.<anonymous>.<anonymous>.<anonymous>.<anonymous> (QQFTCenterEmptyCardView.kt:115)");
                                                    }
                                                    i.Companion companion2 = i.INSTANCE;
                                                    float f47 = 2;
                                                    i n17 = ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.A(companion2), 0.0f, f47, 0.0f, 0.0f, 13, null);
                                                    h color$default = QUIToken.color$default("text_primary");
                                                    ai.Companion companion3 = ai.INSTANCE;
                                                    int a17 = companion3.a();
                                                    float f48 = 20;
                                                    c.Companion companion4 = c.INSTANCE;
                                                    TextKt.a("\u6253\u5f00 ", n17, null, color$default, Float.valueOf(f46), null, companion4.e(), null, null, null, ai.f(a17), Float.valueOf(f48), null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer9, 1577030, 48, 0, 134214564);
                                                    TextKt.a("QQ\u7535\u8111\u7248\uff0c", ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.A(companion2), 0.0f, f47, 0.0f, 0.0f, 13, null), null, QUIToken.color$default("text_primary"), Float.valueOf(f46), null, companion4.f(), null, null, null, ai.f(companion3.a()), Float.valueOf(f48), null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer9, 1577030, 48, 0, 134214564);
                                                    TextKt.a("\u70b9\u51fb", ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.A(companion2), 0.0f, f47, 0.0f, 0.0f, 13, null), null, QUIToken.color$default("text_primary"), Float.valueOf(f46), null, companion4.e(), null, null, null, ai.f(companion3.a()), Float.valueOf(f48), null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer9, 1577030, 48, 0, 134214564);
                                                    TextKt.a("\u201c+\u201d", ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.A(companion2), 0.0f, f47, 0.0f, 0.0f, 13, null), null, QUIToken.color$default("text_primary"), Float.valueOf(f46), null, companion4.f(), null, null, null, ai.f(companion3.a()), Float.valueOf(f48), null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer9, 1577030, 48, 0, 134214564);
                                                    TextKt.a("\u4f7f\u7528 ", ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.A(companion2), 0.0f, f47, 0.0f, 0.0f, 13, null), null, QUIToken.color$default("text_primary"), Float.valueOf(f46), null, companion4.e(), null, null, null, ai.f(companion3.a()), Float.valueOf(f48), null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer9, 1577030, 48, 0, 134214564);
                                                    TextKt.a("\u95ea\u4f20\u6587\u4ef6", ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.A(companion2), 0.0f, f47, 0.0f, 0.0f, 13, null), null, QUIToken.color$default("text_primary"), Float.valueOf(f46), null, companion4.f(), null, null, null, ai.f(companion3.a()), Float.valueOf(f48), null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer9, 1577030, 48, 0, 134214564);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                    }
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        }), composer7, 196616, 30);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                    return Unit.INSTANCE;
                                }
                            };
                            Composer composer6 = composer4;
                            ColumnKt.a(n3, null, null, null, ComposableLambdaKt.composableLambda(composer6, -130328139, true, function3), composer6, 24584, 14);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                        return Unit.INSTANCE;
                    }
                }), composer2, 196616, 30);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            return Unit.INSTANCE;
        }
    });
}
