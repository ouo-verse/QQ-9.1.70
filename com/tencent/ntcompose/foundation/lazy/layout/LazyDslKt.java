package com.tencent.ntcompose.foundation.lazy.layout;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.kuikly.core.timer.TimerKt;
import com.tencent.ntcompose.material.HoverKt;
import com.tencent.qqnt.kernel.nativeinterface.MsgConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import so3.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001at\u0010\r\u001a\u00020\n\"\u0004\b\u0000\u0010\u0000*\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022#\b\u0002\u0010\t\u001a\u001d\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u00042&\u0010\f\u001a\"\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\n0\u0004\u00a2\u0006\u0002\b\u000bH\u0007\u00a2\u0006\u0004\b\r\u0010\u000e\u001a\u009e\u0001\u0010\u0012\u001a\u00020\n\"\u0004\b\u0000\u0010\u0000*\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u000228\b\u0002\u0010\t\u001a2\u0012\u0013\u0012\u00110\u0010\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u000f2;\u0010\f\u001a7\u0012\u0013\u0012\u00110\u0010\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\n0\u000f\u00a2\u0006\u0002\b\u000bH\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013\u001ah\u0010\u0015\u001a\u00020\n*\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u00102#\b\u0002\u0010\t\u001a\u001d\u0012\u0013\u0012\u00110\u0010\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\b0\u00042&\u0010\f\u001a\"\u0012\u0013\u0012\u00110\u0010\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\n0\u0004\u00a2\u0006\u0002\b\u000bH\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016\u001aT\u0010\u001d\u001a\u00020\n*\u00020\u00012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u001a\u001a\u00020\u00192\u0011\u0010\u001c\u001a\r\u0012\u0004\u0012\u00020\n0\u001b\u00a2\u0006\u0002\b\u000bH\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001e\u00a8\u0006\u001f"}, d2 = {"T", "Lcom/tencent/ntcompose/foundation/lazy/layout/a;", "", "items", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "key", "", "Landroidx/compose/runtime/Composable;", "itemContent", "b", "(Lcom/tencent/ntcompose/foundation/lazy/layout/a;Ljava/util/List;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "Lkotlin/Function2;", "", "index", "c", "(Lcom/tencent/ntcompose/foundation/lazy/layout/a;Ljava/util/List;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;II)V", "count", "a", "(Lcom/tencent/ntcompose/foundation/lazy/layout/a;ILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "contentType", "bringIndex", "", "stickyMarginTop", "Lkotlin/Function0;", "content", "d", "(Lcom/tencent/ntcompose/foundation/lazy/layout/a;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Integer;FLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "ntcompose_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class LazyDslKt {
    public static final <T> void b(final a aVar, final List<? extends T> items, final Function1<? super T, ? extends Object> function1, final Function3<? super T, ? super Composer, ? super Integer, Unit> itemContent, Composer composer, final int i3, final int i16) {
        Intrinsics.checkNotNullParameter(aVar, "<this>");
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(itemContent, "itemContent");
        Composer startRestartGroup = composer.startRestartGroup(-484579922);
        if ((i16 & 2) != 0) {
            function1 = new Function1<T, Object>() { // from class: com.tencent.ntcompose.foundation.lazy.layout.LazyDslKt$items$1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(T t16) {
                    Intrinsics.checkNotNull(t16, "null cannot be cast to non-null type kotlin.Any");
                    return t16;
                }
            };
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-484579922, i3, -1, "com.tencent.ntcompose.foundation.lazy.layout.items (LazyDsl.kt:64)");
        }
        a(aVar, items.size(), new Function1<Integer, Object>() { // from class: com.tencent.ntcompose.foundation.lazy.layout.LazyDslKt$items$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final Object invoke(int i17) {
                return function1.invoke(items.get(i17));
            }
        }, ComposableLambdaKt.composableLambda(startRestartGroup, 1260298178, true, new Function3<Integer, Composer, Integer, Unit>() { // from class: com.tencent.ntcompose.foundation.lazy.layout.LazyDslKt$items$3
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(Integer num, Composer composer2, Integer num2) {
                invoke(num.intValue(), composer2, num2.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i17, Composer composer2, int i18) {
                int i19;
                if ((i18 & 14) == 0) {
                    i19 = (composer2.changed(i17) ? 4 : 2) | i18;
                } else {
                    i19 = i18;
                }
                if ((i19 & 91) == 18 && composer2.getSkipping()) {
                    composer2.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1260298178, i18, -1, "com.tencent.ntcompose.foundation.lazy.layout.items.<anonymous> (LazyDsl.kt:71)");
                }
                itemContent.invoke(items.get(i17), composer2, Integer.valueOf((i3 >> 6) & 112));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), startRestartGroup, (i3 & 14) | 3072, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        final Function1<? super T, ? extends Object> function12 = function1;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.ntcompose.foundation.lazy.layout.LazyDslKt$items$4
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                invoke(composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer2, int i17) {
                LazyDslKt.b(a.this, items, function12, itemContent, composer2, i3 | 1, i16);
            }
        });
    }

    public static final <T> void c(final a aVar, final List<? extends T> items, final Function2<? super Integer, ? super T, ? extends Object> function2, final Function4<? super Integer, ? super T, ? super Composer, ? super Integer, Unit> itemContent, Composer composer, final int i3, final int i16) {
        Intrinsics.checkNotNullParameter(aVar, "<this>");
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(itemContent, "itemContent");
        Composer startRestartGroup = composer.startRestartGroup(1139873163);
        if ((i16 & 2) != 0) {
            function2 = new Function2<Integer, T, Object>() { // from class: com.tencent.ntcompose.foundation.lazy.layout.LazyDslKt$itemsIndexed$1
                public final Object invoke(int i17, T t16) {
                    Intrinsics.checkNotNull(t16, "null cannot be cast to non-null type kotlin.Any");
                    return t16;
                }

                /* JADX WARN: Multi-variable type inference failed */
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Integer num, Object obj) {
                    return invoke(num.intValue(), (int) obj);
                }
            };
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1139873163, i3, -1, "com.tencent.ntcompose.foundation.lazy.layout.itemsIndexed (LazyDsl.kt:143)");
        }
        a(aVar, items.size(), new Function1<Integer, Object>() { // from class: com.tencent.ntcompose.foundation.lazy.layout.LazyDslKt$itemsIndexed$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final Object invoke(int i17) {
                return function2.invoke(Integer.valueOf(i17), items.get(i17));
            }
        }, ComposableLambdaKt.composableLambda(startRestartGroup, -1809670921, true, new Function3<Integer, Composer, Integer, Unit>() { // from class: com.tencent.ntcompose.foundation.lazy.layout.LazyDslKt$itemsIndexed$3
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(Integer num, Composer composer2, Integer num2) {
                invoke(num.intValue(), composer2, num2.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i17, Composer composer2, int i18) {
                if ((i18 & 14) == 0) {
                    i18 |= composer2.changed(i17) ? 4 : 2;
                }
                if ((i18 & 91) == 18 && composer2.getSkipping()) {
                    composer2.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1809670921, i18, -1, "com.tencent.ntcompose.foundation.lazy.layout.itemsIndexed.<anonymous> (LazyDsl.kt:150)");
                }
                itemContent.invoke(Integer.valueOf(i17), items.get(i17), composer2, Integer.valueOf((i18 & 14) | ((i3 >> 3) & 896)));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), startRestartGroup, (i3 & 14) | 3072, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        final Function2<? super Integer, ? super T, ? extends Object> function22 = function2;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.ntcompose.foundation.lazy.layout.LazyDslKt$itemsIndexed$4
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                invoke(composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer2, int i17) {
                LazyDslKt.c(a.this, items, function22, itemContent, composer2, i3 | 1, i16);
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0060  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void d(final a aVar, Object obj, Object obj2, Integer num, float f16, final Function2<? super Composer, ? super Integer, Unit> content, Composer composer, final int i3, final int i16) {
        int i17;
        final Integer num2;
        int i18;
        float f17;
        int i19;
        Object obj3;
        final Object obj4;
        final Object obj5;
        final float f18;
        ScopeUpdateScope endRestartGroup;
        Intrinsics.checkNotNullParameter(aVar, "<this>");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer startRestartGroup = composer.startRestartGroup(1866107719);
        if ((i16 & Integer.MIN_VALUE) != 0) {
            i17 = i3 | 6;
        } else if ((i3 & 14) == 0) {
            i17 = (startRestartGroup.changed(aVar) ? 4 : 2) | i3;
        } else {
            i17 = i3;
        }
        int i26 = i16 & 1;
        if (i26 != 0) {
            i17 |= 16;
        }
        int i27 = i16 & 4;
        if (i27 != 0) {
            i17 |= 3072;
        } else if ((i3 & 7168) == 0) {
            num2 = num;
            i17 |= startRestartGroup.changed(num2) ? 2048 : 1024;
            i18 = i16 & 8;
            if (i18 == 0) {
                i17 |= 24576;
            } else if ((i3 & 57344) == 0) {
                f17 = f16;
                i17 |= startRestartGroup.changed(f17) ? 16384 : 8192;
                if ((i16 & 16) == 0) {
                    if ((458752 & i3) == 0) {
                        i19 = startRestartGroup.changed(content) ? 131072 : 65536;
                    }
                    if ((i16 & 3) != 3 && (373851 & i17) == 74770 && startRestartGroup.getSkipping()) {
                        startRestartGroup.skipToGroupEnd();
                        obj4 = obj;
                        obj5 = obj2;
                        f18 = f17;
                    } else {
                        obj3 = i26 == 0 ? null : obj;
                        Object obj6 = (i16 & 2) == 0 ? null : obj2;
                        Integer num3 = i27 == 0 ? null : num2;
                        float f19 = i18 == 0 ? 0.0f : f17;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1866107719, i17, -1, "com.tencent.ntcompose.foundation.lazy.layout.stickyHeader (LazyDsl.kt:305)");
                        }
                        if (obj3 == null) {
                            startRestartGroup.startReplaceableGroup(-1616190275);
                            startRestartGroup.startMovableGroup(-1616190265, obj3);
                            HoverKt.a(aVar, null, null, num3, f19, null, content, startRestartGroup, (i17 & 14) | (i17 & 7168) | (57344 & i17) | (3670016 & (i17 << 3)), 19);
                            startRestartGroup.endMovableGroup();
                            startRestartGroup.endReplaceableGroup();
                        } else {
                            startRestartGroup.startReplaceableGroup(-1616190075);
                            HoverKt.a(aVar, null, null, num3, f19, null, content, startRestartGroup, (i17 & 14) | (i17 & 7168) | (57344 & i17) | (3670016 & (i17 << 3)), 19);
                            startRestartGroup.endReplaceableGroup();
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        obj4 = obj3;
                        obj5 = obj6;
                        num2 = num3;
                        f18 = f19;
                    }
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup != null) {
                        return;
                    }
                    endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.ntcompose.foundation.lazy.layout.LazyDslKt$stickyHeader$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num4) {
                            invoke(composer2, num4.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i28) {
                            LazyDslKt.d(a.this, obj4, obj5, num2, f18, content, composer2, i3 | 1, i16);
                        }
                    });
                    return;
                }
                i19 = 196608;
                i17 |= i19;
                if ((i16 & 3) != 3) {
                }
                if (i26 == 0) {
                }
                if ((i16 & 2) == 0) {
                }
                if (i27 == 0) {
                }
                if (i18 == 0) {
                }
                if (ComposerKt.isTraceInProgress()) {
                }
                if (obj3 == null) {
                }
                if (ComposerKt.isTraceInProgress()) {
                }
                obj4 = obj3;
                obj5 = obj6;
                num2 = num3;
                f18 = f19;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            f17 = f16;
            if ((i16 & 16) == 0) {
            }
            i17 |= i19;
            if ((i16 & 3) != 3) {
            }
            if (i26 == 0) {
            }
            if ((i16 & 2) == 0) {
            }
            if (i27 == 0) {
            }
            if (i18 == 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            if (obj3 == null) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            obj4 = obj3;
            obj5 = obj6;
            num2 = num3;
            f18 = f19;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        num2 = num;
        i18 = i16 & 8;
        if (i18 == 0) {
        }
        f17 = f16;
        if ((i16 & 16) == 0) {
        }
        i17 |= i19;
        if ((i16 & 3) != 3) {
        }
        if (i26 == 0) {
        }
        if ((i16 & 2) == 0) {
        }
        if (i27 == 0) {
        }
        if (i18 == 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        if (obj3 == null) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        obj4 = obj3;
        obj5 = obj6;
        num2 = num3;
        f18 = f19;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x025b  */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0228 A[LOOP:0: B:68:0x0226->B:69:0x0228, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0251  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0071  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void a(final a aVar, final int i3, Function1<? super Integer, ? extends Object> function1, final Function3<? super Integer, ? super Composer, ? super Integer, Unit> itemContent, Composer composer, final int i16, final int i17) {
        int i18;
        Function1<? super Integer, ? extends Object> function12;
        int coerceIn;
        Object rememberedValue;
        Composer.Companion companion;
        Object rememberedValue2;
        Object rememberedValue3;
        Object rememberedValue4;
        Object rememberedValue5;
        final MutableState mutableState;
        int i19;
        int coerceAtMost;
        ScopeUpdateScope endRestartGroup;
        Intrinsics.checkNotNullParameter(aVar, "<this>");
        Intrinsics.checkNotNullParameter(itemContent, "itemContent");
        Composer startRestartGroup = composer.startRestartGroup(-635659333);
        if ((i17 & Integer.MIN_VALUE) != 0) {
            i18 = i16 | 6;
        } else if ((i16 & 14) == 0) {
            i18 = (startRestartGroup.changed(aVar) ? 4 : 2) | i16;
        } else {
            i18 = i16;
        }
        if ((i17 & 1) != 0) {
            i18 |= 48;
        } else if ((i16 & 112) == 0) {
            i18 |= startRestartGroup.changed(i3) ? 32 : 16;
        }
        int i26 = i17 & 2;
        if (i26 != 0) {
            i18 |= MsgConstant.KRMFILETHUMBSIZE384;
        } else if ((i16 & 896) == 0) {
            function12 = function1;
            i18 |= startRestartGroup.changed(function12) ? 256 : 128;
            if ((i17 & 4) == 0) {
                i18 |= 3072;
            } else if ((i16 & 7168) == 0) {
                i18 |= startRestartGroup.changed(itemContent) ? 2048 : 1024;
            }
            if ((i18 & 5851) != 1170 && startRestartGroup.getSkipping()) {
                startRestartGroup.skipToGroupEnd();
            } else {
                if (i26 != 0) {
                    function12 = new Function1<Integer, Object>() { // from class: com.tencent.ntcompose.foundation.lazy.layout.LazyDslKt$items$9
                        public final Object invoke(int i27) {
                            Intrinsics.checkNotNull(Integer.valueOf(i27), "null cannot be cast to non-null type kotlin.Any");
                            return Integer.valueOf(i27);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                            return invoke(num.intValue());
                        }
                    };
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-635659333, i18, -1, "com.tencent.ntcompose.foundation.lazy.layout.items (LazyDsl.kt:238)");
                }
                coerceIn = RangesKt___RangesKt.coerceIn(aVar.getFirstLoadMaxIndex(), 0, i3);
                startRestartGroup.startReplaceableGroup(-492369756);
                rememberedValue = startRestartGroup.rememberedValue();
                companion = Composer.INSTANCE;
                if (rememberedValue == companion.getEmpty()) {
                    rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(0, null, 2, null);
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                startRestartGroup.endReplaceableGroup();
                final MutableState mutableState2 = (MutableState) rememberedValue;
                startRestartGroup.startReplaceableGroup(-492369756);
                rememberedValue2 = startRestartGroup.rememberedValue();
                if (rememberedValue2 == companion.getEmpty()) {
                    rememberedValue2 = new b(0);
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                }
                startRestartGroup.endReplaceableGroup();
                final b bVar = (b) rememberedValue2;
                startRestartGroup.startReplaceableGroup(-492369756);
                rememberedValue3 = startRestartGroup.rememberedValue();
                if (rememberedValue3 == companion.getEmpty()) {
                    rememberedValue3 = new b("");
                    startRestartGroup.updateRememberedValue(rememberedValue3);
                }
                startRestartGroup.endReplaceableGroup();
                final b bVar2 = (b) rememberedValue3;
                startRestartGroup.startReplaceableGroup(-492369756);
                rememberedValue4 = startRestartGroup.rememberedValue();
                if (rememberedValue4 == companion.getEmpty()) {
                    rememberedValue4 = new b(0);
                    startRestartGroup.updateRememberedValue(rememberedValue4);
                }
                startRestartGroup.endReplaceableGroup();
                final b bVar3 = (b) rememberedValue4;
                bVar.b(Integer.valueOf(i3));
                startRestartGroup.startReplaceableGroup(-492369756);
                rememberedValue5 = startRestartGroup.rememberedValue();
                if (rememberedValue5 == companion.getEmpty()) {
                    rememberedValue5 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(i3 == 0 || i3 > coerceIn), null, 2, null);
                    startRestartGroup.updateRememberedValue(rememberedValue5);
                }
                startRestartGroup.endReplaceableGroup();
                mutableState = (MutableState) rememberedValue5;
                startRestartGroup.startReplaceableGroup(489126007);
                if (((Boolean) mutableState.getValue()).booleanValue() || coerceIn <= 0) {
                    i19 = 0;
                } else {
                    startRestartGroup.startReplaceableGroup(1157296644);
                    boolean changed = startRestartGroup.changed(mutableState);
                    Object rememberedValue6 = startRestartGroup.rememberedValue();
                    if (changed || rememberedValue6 == companion.getEmpty()) {
                        rememberedValue6 = new Function0<Unit>() { // from class: com.tencent.ntcompose.foundation.lazy.layout.LazyDslKt$items$10$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                                if (mutableState.getValue().booleanValue()) {
                                    mutableState.setValue(Boolean.FALSE);
                                }
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue6);
                    }
                    startRestartGroup.endReplaceableGroup();
                    i19 = 0;
                    TimerKt.c(0, (Function0) rememberedValue6);
                }
                startRestartGroup.endReplaceableGroup();
                EffectsKt.DisposableEffect(Unit.INSTANCE, new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: com.tencent.ntcompose.foundation.lazy.layout.LazyDslKt$items$11

                    /* compiled from: P */
                    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004\u00b8\u0006\u0000"}, d2 = {"androidx/compose/runtime/DisposableEffectScope$onDispose$1", "Landroidx/compose/runtime/DisposableEffectResult;", "", "dispose", "runtime_release"}, k = 1, mv = {1, 7, 1})
                    /* loaded from: classes34.dex */
                    public static final class a implements DisposableEffectResult {

                        /* renamed from: a, reason: collision with root package name */
                        final /* synthetic */ b f339319a;

                        public a(b bVar) {
                            this.f339319a = bVar;
                        }

                        @Override // androidx.compose.runtime.DisposableEffectResult
                        public void dispose() {
                            TimerKt.b((String) this.f339319a.a());
                        }
                    }

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final DisposableEffectResult invoke(DisposableEffectScope DisposableEffect) {
                        Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
                        return new a(bVar2);
                    }
                }, startRestartGroup, i19);
                if (!((Boolean) mutableState.getValue()).booleanValue()) {
                    int max = Math.max(aVar.getFirstLoadMaxIndex() + 2, 8);
                    coerceAtMost = RangesKt___RangesKt.coerceAtMost(((Number) bVar3.a()).intValue(), ((Number) bVar.a()).intValue());
                    if (coerceAtMost < ((Number) bVar.a()).intValue()) {
                        coerceIn = RangesKt___RangesKt.coerceAtMost(coerceAtMost + max, ((Number) bVar.a()).intValue());
                        if (coerceIn < ((Number) bVar.a()).intValue()) {
                            TimerKt.b((String) bVar2.a());
                            if (((Number) mutableState2.getValue()).intValue() >= 0) {
                                bVar2.b(TimerKt.c(16, new Function0<Unit>() { // from class: com.tencent.ntcompose.foundation.lazy.layout.LazyDslKt$items$renderItems$1
                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public /* bridge */ /* synthetic */ Unit invoke() {
                                        invoke2();
                                        return Unit.INSTANCE;
                                    }

                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2() {
                                        int coerceAtMost2;
                                        coerceAtMost2 = RangesKt___RangesKt.coerceAtMost(bVar3.a().intValue(), bVar.a().intValue());
                                        if (coerceAtMost2 < bVar.a().intValue()) {
                                            MutableState<Integer> mutableState3 = mutableState2;
                                            mutableState3.setValue(Integer.valueOf(mutableState3.getValue().intValue() + 1));
                                        }
                                    }
                                }));
                            }
                        }
                    } else {
                        coerceIn = coerceAtMost;
                    }
                }
                bVar3.b(Integer.valueOf(coerceIn));
                while (i19 < coerceIn) {
                    startRestartGroup.startMovableGroup(489127363, function12.invoke(Integer.valueOf(i19)));
                    itemContent.invoke(Integer.valueOf(i19), startRestartGroup, Integer.valueOf((i18 >> 6) & 112));
                    startRestartGroup.endMovableGroup();
                    i19++;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
                return;
            }
            final Function1<? super Integer, ? extends Object> function13 = function12;
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.ntcompose.foundation.lazy.layout.LazyDslKt$items$12
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i27) {
                    LazyDslKt.a(a.this, i3, function13, itemContent, composer2, i16 | 1, i17);
                }
            });
            return;
        }
        function12 = function1;
        if ((i17 & 4) == 0) {
        }
        if ((i18 & 5851) != 1170) {
        }
        if (i26 != 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        coerceIn = RangesKt___RangesKt.coerceIn(aVar.getFirstLoadMaxIndex(), 0, i3);
        startRestartGroup.startReplaceableGroup(-492369756);
        rememberedValue = startRestartGroup.rememberedValue();
        companion = Composer.INSTANCE;
        if (rememberedValue == companion.getEmpty()) {
        }
        startRestartGroup.endReplaceableGroup();
        final MutableState<Integer> mutableState22 = (MutableState) rememberedValue;
        startRestartGroup.startReplaceableGroup(-492369756);
        rememberedValue2 = startRestartGroup.rememberedValue();
        if (rememberedValue2 == companion.getEmpty()) {
        }
        startRestartGroup.endReplaceableGroup();
        final b<Integer> bVar4 = (b) rememberedValue2;
        startRestartGroup.startReplaceableGroup(-492369756);
        rememberedValue3 = startRestartGroup.rememberedValue();
        if (rememberedValue3 == companion.getEmpty()) {
        }
        startRestartGroup.endReplaceableGroup();
        final b<String> bVar22 = (b) rememberedValue3;
        startRestartGroup.startReplaceableGroup(-492369756);
        rememberedValue4 = startRestartGroup.rememberedValue();
        if (rememberedValue4 == companion.getEmpty()) {
        }
        startRestartGroup.endReplaceableGroup();
        final b<Integer> bVar32 = (b) rememberedValue4;
        bVar4.b(Integer.valueOf(i3));
        startRestartGroup.startReplaceableGroup(-492369756);
        rememberedValue5 = startRestartGroup.rememberedValue();
        if (rememberedValue5 == companion.getEmpty()) {
        }
        startRestartGroup.endReplaceableGroup();
        mutableState = (MutableState) rememberedValue5;
        startRestartGroup.startReplaceableGroup(489126007);
        if (((Boolean) mutableState.getValue()).booleanValue()) {
        }
        i19 = 0;
        startRestartGroup.endReplaceableGroup();
        EffectsKt.DisposableEffect(Unit.INSTANCE, new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: com.tencent.ntcompose.foundation.lazy.layout.LazyDslKt$items$11

            /* compiled from: P */
            @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004\u00b8\u0006\u0000"}, d2 = {"androidx/compose/runtime/DisposableEffectScope$onDispose$1", "Landroidx/compose/runtime/DisposableEffectResult;", "", "dispose", "runtime_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes34.dex */
            public static final class a implements DisposableEffectResult {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ b f339319a;

                public a(b bVar) {
                    this.f339319a = bVar;
                }

                @Override // androidx.compose.runtime.DisposableEffectResult
                public void dispose() {
                    TimerKt.b((String) this.f339319a.a());
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final DisposableEffectResult invoke(DisposableEffectScope DisposableEffect) {
                Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
                return new a(bVar22);
            }
        }, startRestartGroup, i19);
        if (!((Boolean) mutableState.getValue()).booleanValue()) {
        }
        bVar32.b(Integer.valueOf(coerceIn));
        while (i19 < coerceIn) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }
}
