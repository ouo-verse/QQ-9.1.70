package com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.playground;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import bp3.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.detail.model.BoxType$EnumUnboxingSharedUtility;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.view.BotListCellKt$BotListCell$3$1$2$2$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.nearby.compose_base.ModifierExtKt;
import com.tencent.hippykotlin.demo.pages.nearby.compose_base.geometry.Point;
import com.tencent.hippykotlin.demo.pages.nearby.mood_group.data.ImageConfig;
import com.tencent.hippykotlin.demo.pages.nearby.mood_group.data.NBPMoodGroupConfig;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.BorderStyle;
import com.tencent.kuikly.core.base.aa;
import com.tencent.kuikly.core.base.b;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.q;
import com.tencent.kuikly.core.base.y;
import com.tencent.kuikly.core.timer.TimerKt;
import com.tencent.kuikly.core.views.v;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.event.ViewEventPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.BoxKt;
import com.tencent.ntcompose.foundation.layout.ColumnKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.RowKt;
import com.tencent.ntcompose.foundation.layout.base.Alignment;
import com.tencent.ntcompose.foundation.layout.base.a;
import com.tencent.ntcompose.foundation.layout.d;
import com.tencent.ntcompose.foundation.layout.n;
import com.tencent.ntcompose.material.APNGKt;
import com.tencent.ntcompose.material.ImageKt;
import com.tencent.ntcompose.material.LottieKt;
import com.tencent.ntcompose.material.TextKt;
import com.tencent.ntcompose.material.base.ModifiersKt;
import com.tencent.qq.effect.engine.QEffectType;
import com.tencent.qqnt.kernel.nativeinterface.MsgConstant;
import com.tencent.tmassistantbase.common.TMAssistantDownloadErrorCode;
import h35.a;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref;
import kotlin.random.Random;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class UserMarkerViewKt {
    public static final boolean UserMarkerView$lambda$1(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void UserMarkerView(final UserMarkerInfo userMarkerInfo, final Function2<? super UserMarkerInfo, ? super a, Unit> function2, final Function2<? super UserMarkerInfo, ? super a, Unit> function22, Composer composer, final int i3) {
        int i16;
        float f16;
        T t16;
        com.tencent.kuikly.core.base.a aVar;
        T t17;
        Composer startRestartGroup = composer.startRestartGroup(-1032628041);
        if ((i3 & 14) == 0) {
            i16 = (startRestartGroup.changed(userMarkerInfo) ? 4 : 2) | i3;
        } else {
            i16 = i3;
        }
        if ((i3 & 112) == 0) {
            i16 |= startRestartGroup.changed(function2) ? 32 : 16;
        }
        if ((i3 & 896) == 0) {
            i16 |= startRestartGroup.changed(function22) ? 256 : 128;
        }
        final int i17 = i16;
        if ((i17 & TMAssistantDownloadErrorCode.DownloadSDKErrorCode_URL_EMPTY) == 146 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1032628041, i17, -1, "com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.playground.UserMarkerView (UserMarkerView.kt:49)");
            }
            final NBPMoodGroupConfig.UserMarkerConfig userMarkerConfig = userMarkerInfo.markerConfig;
            final boolean isHost = userMarkerInfo.isHost();
            final boolean z16 = userMarkerInfo.isNewAdd;
            startRestartGroup.startReplaceableGroup(-492369756);
            Object rememberedValue = startRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (rememberedValue == companion.getEmpty()) {
                rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceableGroup();
            final MutableState mutableState = (MutableState) rememberedValue;
            float f17 = userMarkerInfo.containerPos.f114221y;
            if (isHost && z16 && !UserMarkerView$lambda$1(mutableState)) {
                f16 = -userMarkerInfo.markerConfig.containerSize.getWidth();
            } else {
                f16 = userMarkerInfo.containerPos.f114220x;
            }
            startRestartGroup.startReplaceableGroup(-492369756);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == companion.getEmpty()) {
                rememberedValue2 = new Function1<a, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.playground.UserMarkerViewKt$UserMarkerView$onReplyFun$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(a aVar2) {
                        function22.invoke(userMarkerInfo, aVar2);
                        return Unit.INSTANCE;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceableGroup();
            final Function1 function1 = (Function1) rememberedValue2;
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            startRestartGroup.startReplaceableGroup(-492369756);
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            float f18 = f16;
            if (rememberedValue3 == companion.getEmpty()) {
                startRestartGroup.updateRememberedValue(null);
                t16 = 0;
            } else {
                t16 = rememberedValue3;
            }
            startRestartGroup.endReplaceableGroup();
            objectRef.element = t16;
            final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
            startRestartGroup.startReplaceableGroup(-492369756);
            Object rememberedValue4 = startRestartGroup.rememberedValue();
            if (rememberedValue4 == companion.getEmpty()) {
                aVar = null;
                startRestartGroup.updateRememberedValue(null);
                t17 = 0;
            } else {
                aVar = null;
                t17 = rememberedValue4;
            }
            startRestartGroup.endReplaceableGroup();
            objectRef2.element = t17;
            com.tencent.kuikly.core.base.a aVar2 = aVar;
            EffectsKt.DisposableEffect(Boolean.valueOf(isHost), Boolean.valueOf(z16), Boolean.valueOf(UserMarkerView$lambda$1(mutableState)), new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.playground.UserMarkerViewKt$UserMarkerView$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                    v b16;
                    if (isHost && z16 && !mutableState.getValue().booleanValue()) {
                        aa<v> aaVar = objectRef2.element;
                        if (aaVar != null && (b16 = aaVar.b()) != null) {
                            b j3 = b.Companion.j(b.INSTANCE, 0.5f, null, 2, null);
                            final UserMarkerInfo userMarkerInfo2 = userMarkerInfo;
                            q.a.a(b16, j3, null, new Function1<Attr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.playground.UserMarkerViewKt$UserMarkerView$1.1
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(Attr attr) {
                                    Point point = UserMarkerInfo.this.containerPos;
                                    attr.transform(new y(0.0f, 0.0f, point.f114220x, point.f114221y));
                                    return Unit.INSTANCE;
                                }
                            }, 2, null);
                        }
                        final MutableState<Boolean> mutableState2 = mutableState;
                        TimerKt.d(500, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.playground.UserMarkerViewKt$UserMarkerView$1.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Unit invoke() {
                                mutableState2.setValue(Boolean.TRUE);
                                return Unit.INSTANCE;
                            }
                        });
                    }
                    return new DisposableEffectResult() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.playground.UserMarkerViewKt$UserMarkerView$1$invoke$$inlined$onDispose$1
                        @Override // androidx.compose.runtime.DisposableEffectResult
                        public final void dispose() {
                        }
                    };
                }
            }, startRestartGroup, 0);
            BoxKt.a(ModifiersKt.Q(ModifierExtKt.size(ModifiersKt.c(i.INSTANCE, h.INSTANCE.l()), userMarkerConfig.containerSize), new y(0.0f, 0.0f, f18, f17), aVar2, 2, aVar2), Alignment.BottomCenter, new Function2<v, aa<v>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.playground.UserMarkerViewKt$UserMarkerView$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Type inference failed for: r2v1, types: [T, com.tencent.kuikly.core.base.aa] */
                @Override // kotlin.jvm.functions.Function2
                public final Unit invoke(v vVar, aa<v> aaVar) {
                    objectRef2.element = aaVar;
                    return Unit.INSTANCE;
                }
            }, ComposableLambdaKt.composableLambda(startRestartGroup, -563499919, true, new Function3<com.tencent.ntcompose.foundation.layout.b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.playground.UserMarkerViewKt$UserMarkerView$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(3);
                }

                /* JADX WARN: Multi-variable type inference failed */
                @Override // kotlin.jvm.functions.Function3
                public final Unit invoke(com.tencent.ntcompose.foundation.layout.b bVar, Composer composer2, Integer num) {
                    Composer composer3 = composer2;
                    int intValue = num.intValue();
                    if ((intValue & 81) == 16 && composer3.getSkipping()) {
                        composer3.skipToGroupEnd();
                    } else {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-563499919, intValue, -1, "com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.playground.UserMarkerView.<anonymous> (UserMarkerView.kt:96)");
                        }
                        Point point = (Point) UserMarkerInfo.this.boomEffectOffset$delegate.getValue();
                        final UserMarkerInfo userMarkerInfo2 = UserMarkerInfo.this;
                        final Ref.ObjectRef<aa<v>> objectRef3 = objectRef;
                        EffectsKt.DisposableEffect(point, new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.playground.UserMarkerViewKt$UserMarkerView$3.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            /* JADX WARN: Multi-variable type inference failed */
                            @Override // kotlin.jvm.functions.Function1
                            public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                                v b16;
                                v b17;
                                final Point point2 = (Point) UserMarkerInfo.this.boomEffectOffset$delegate.getValue();
                                if (point2 != null) {
                                    aa<v> aaVar = objectRef3.element;
                                    if (aaVar != null && (b17 = aaVar.b()) != null) {
                                        q.a.a(b17, b.Companion.t(b.INSTANCE, UserMarkerInfo.this.boomEffectAwayTime / 1000, 0.5f, 0.0f, null, 8, null), null, new Function1<Attr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.playground.UserMarkerViewKt.UserMarkerView.3.1.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(Attr attr) {
                                                Point point3 = Point.this;
                                                attr.transform(new y(0.0f, 0.0f, point3.f114220x, point3.f114221y));
                                                return Unit.INSTANCE;
                                            }
                                        }, 2, null);
                                    }
                                } else {
                                    aa<v> aaVar2 = objectRef3.element;
                                    if (aaVar2 != null && (b16 = aaVar2.b()) != null) {
                                        q.a.a(b16, b.Companion.j(b.INSTANCE, UserMarkerInfo.this.boomEffectResetTime / 1000, null, 2, null), null, new Function1<Attr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.playground.UserMarkerViewKt.UserMarkerView.3.1.2
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(Attr attr) {
                                                attr.transform(new y(0.0f, 0.0f, 0.0f, 0.0f));
                                                return Unit.INSTANCE;
                                            }
                                        }, 2, null);
                                    }
                                }
                                return new DisposableEffectResult() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.playground.UserMarkerViewKt$UserMarkerView$3$1$invoke$$inlined$onDispose$1
                                    @Override // androidx.compose.runtime.DisposableEffectResult
                                    public final void dispose() {
                                    }
                                };
                            }
                        }, composer3, 0);
                        i size = ModifierExtKt.size(ModifiersKt.c(i.INSTANCE, h.INSTANCE.l()), userMarkerConfig.containerSize);
                        a.k a16 = com.tencent.ntcompose.foundation.layout.base.a.f339245a.a();
                        Alignment.Horizontal b16 = Alignment.INSTANCE.b();
                        final Ref.ObjectRef<aa<v>> objectRef4 = objectRef;
                        Function2<v, aa<v>, Unit> function23 = new Function2<v, aa<v>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.playground.UserMarkerViewKt$UserMarkerView$3.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            /* JADX WARN: Multi-variable type inference failed */
                            /* JADX WARN: Type inference failed for: r2v1, types: [T, com.tencent.kuikly.core.base.aa] */
                            @Override // kotlin.jvm.functions.Function2
                            public final Unit invoke(v vVar, aa<v> aaVar) {
                                objectRef4.element = aaVar;
                                return Unit.INSTANCE;
                            }
                        };
                        final UserMarkerInfo userMarkerInfo3 = UserMarkerInfo.this;
                        final Function1<h35.a, Unit> function12 = function1;
                        final Function2<UserMarkerInfo, h35.a, Unit> function24 = function2;
                        final int i18 = i17;
                        final NBPMoodGroupConfig.UserMarkerConfig userMarkerConfig2 = userMarkerConfig;
                        final boolean z17 = isHost;
                        ColumnKt.a(size, a16, b16, function23, ComposableLambdaKt.composableLambda(composer3, 2063114970, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.playground.UserMarkerViewKt$UserMarkerView$3.3
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
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
                                        ComposerKt.traceEventStart(2063114970, intValue2, -1, "com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.playground.UserMarkerView.<anonymous>.<anonymous> (UserMarkerView.kt:130)");
                                    }
                                    final UserMarkerInfo userMarkerInfo4 = UserMarkerInfo.this;
                                    Function1<h35.a, Unit> function13 = function12;
                                    final Function2<UserMarkerInfo, h35.a, Unit> function25 = function24;
                                    composer5.startReplaceableGroup(511388516);
                                    boolean changed = composer5.changed(function25) | composer5.changed(userMarkerInfo4);
                                    Object rememberedValue5 = composer5.rememberedValue();
                                    if (changed || rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                                        rememberedValue5 = new Function1<h35.a, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.playground.UserMarkerViewKt$UserMarkerView$3$3$1$1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            /* JADX WARN: Multi-variable type inference failed */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(h35.a aVar3) {
                                                function25.invoke(userMarkerInfo4, aVar3);
                                                return Unit.INSTANCE;
                                            }
                                        };
                                        composer5.updateRememberedValue(rememberedValue5);
                                    }
                                    composer5.endReplaceableGroup();
                                    BubbleViewKt.BubbleView(userMarkerInfo4, function13, (Function1) rememberedValue5, composer5, (i18 & 14) | 48);
                                    BoxKt.a(ModifierExtKt.size(i.INSTANCE, userMarkerConfig2.markerSize), Alignment.Center, null, ComposableLambdaKt.composableLambda(composer5, 483309588, true, new Function3<com.tencent.ntcompose.foundation.layout.b, Composer, Integer, Unit>(function24, UserMarkerInfo.this, i18, z17) { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.playground.UserMarkerViewKt.UserMarkerView.3.3.2
                                        public final /* synthetic */ boolean $isHost;
                                        public final /* synthetic */ UserMarkerInfo $marker;
                                        public final /* synthetic */ Function2<UserMarkerInfo, h35.a, Unit> $onClick;

                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(3);
                                            this.$isHost = r5;
                                        }

                                        /* JADX WARN: Multi-variable type inference failed */
                                        @Override // kotlin.jvm.functions.Function3
                                        public final Unit invoke(com.tencent.ntcompose.foundation.layout.b bVar2, Composer composer6, Integer num3) {
                                            Composer composer7 = composer6;
                                            int intValue3 = num3.intValue();
                                            if ((intValue3 & 81) == 16 && composer7.getSkipping()) {
                                                composer7.skipToGroupEnd();
                                            } else {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(483309588, intValue3, -1, "com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.playground.UserMarkerView.<anonymous>.<anonymous>.<anonymous> (UserMarkerView.kt:140)");
                                                }
                                                i.Companion companion2 = i.INSTANCE;
                                                i size2 = ModifierExtKt.size(companion2, NBPMoodGroupConfig.UserMarkerConfig.this.markerSize);
                                                final Function2<UserMarkerInfo, h35.a, Unit> function26 = this.$onClick;
                                                final UserMarkerInfo userMarkerInfo5 = this.$marker;
                                                composer7.startReplaceableGroup(511388516);
                                                boolean changed2 = composer7.changed(function26) | composer7.changed(userMarkerInfo5);
                                                Object rememberedValue6 = composer7.rememberedValue();
                                                if (changed2 || rememberedValue6 == Composer.INSTANCE.getEmpty()) {
                                                    rememberedValue6 = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.playground.UserMarkerViewKt$UserMarkerView$3$3$2$1$1
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        /* JADX WARN: Multi-variable type inference failed */
                                                        {
                                                            super(1);
                                                        }

                                                        /* JADX WARN: Multi-variable type inference failed */
                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(ClickParams clickParams) {
                                                            Function2<UserMarkerInfo, h35.a, Unit> function27 = function26;
                                                            UserMarkerInfo userMarkerInfo6 = userMarkerInfo5;
                                                            BarrageDisplayInfo barrageDisplayInfo = (BarrageDisplayInfo) userMarkerInfo6.currentBarrage$delegate.getValue();
                                                            function27.invoke(userMarkerInfo6, barrageDisplayInfo != null ? barrageDisplayInfo.barrage : null);
                                                            return Unit.INSTANCE;
                                                        }
                                                    };
                                                    composer7.updateRememberedValue(rememberedValue6);
                                                }
                                                composer7.endReplaceableGroup();
                                                i d16 = ViewEventPropUpdaterKt.d(size2, false, null, (Function1) rememberedValue6, 3, null);
                                                a.k a17 = com.tencent.ntcompose.foundation.layout.base.a.f339245a.a();
                                                Alignment.Horizontal b17 = Alignment.INSTANCE.b();
                                                final UserMarkerInfo userMarkerInfo6 = this.$marker;
                                                final NBPMoodGroupConfig.UserMarkerConfig userMarkerConfig3 = NBPMoodGroupConfig.UserMarkerConfig.this;
                                                final boolean z18 = this.$isHost;
                                                ColumnKt.a(d16, a17, b17, null, ComposableLambdaKt.composableLambda(composer7, 835783741, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.playground.UserMarkerViewKt.UserMarkerView.3.3.2.2

                                                    /* compiled from: P */
                                                    /* renamed from: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.playground.UserMarkerViewKt$UserMarkerView$3$3$2$2$WhenMappings */
                                                    /* loaded from: classes31.dex */
                                                    public /* synthetic */ class WhenMappings {
                                                        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                                                        static {
                                                            int[] iArr = new int[BoxType$EnumUnboxingSharedUtility.values(4).length];
                                                            try {
                                                                iArr[1] = 1;
                                                            } catch (NoSuchFieldError unused) {
                                                            }
                                                            $EnumSwitchMapping$0 = iArr;
                                                        }
                                                    }

                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(3);
                                                    }

                                                    /* JADX WARN: Code restructure failed: missing block: B:23:0x008b, code lost:
                                                    
                                                        if (r1.equals("apng") == false) goto L36;
                                                     */
                                                    /* JADX WARN: Removed duplicated region for block: B:26:0x00b0  */
                                                    /* JADX WARN: Removed duplicated region for block: B:29:0x0135  */
                                                    /* JADX WARN: Removed duplicated region for block: B:32:0x018a  */
                                                    /* JADX WARN: Removed duplicated region for block: B:33:0x00db  */
                                                    @Override // kotlin.jvm.functions.Function3
                                                    /*
                                                        Code decompiled incorrectly, please refer to instructions dump.
                                                    */
                                                    public final Unit invoke(d dVar2, Composer composer8, Integer num4) {
                                                        boolean isBlank;
                                                        List<String> list;
                                                        Object random;
                                                        String str;
                                                        String substringAfterLast$default;
                                                        Composer composer9;
                                                        Composer composer10 = composer8;
                                                        int intValue4 = num4.intValue();
                                                        if ((intValue4 & 81) == 16 && composer10.getSkipping()) {
                                                            composer10.skipToGroupEnd();
                                                        } else {
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventStart(835783741, intValue4, -1, "com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.playground.UserMarkerView.<anonymous>.<anonymous>.<anonymous>.<anonymous> (UserMarkerView.kt:147)");
                                                            }
                                                            UserMarkerInfo userMarkerInfo7 = UserMarkerInfo.this;
                                                            isBlank = StringsKt__StringsJVMKt.isBlank(userMarkerInfo7.user.f444493m);
                                                            if (!isBlank) {
                                                                str = userMarkerInfo7.user.f444493m;
                                                            } else {
                                                                if (userMarkerInfo7.isHost()) {
                                                                    list = userMarkerInfo7.markerConfig.hostMarkerImages;
                                                                } else {
                                                                    list = userMarkerInfo7.markerConfig.guestMarkerImages;
                                                                }
                                                                random = CollectionsKt___CollectionsKt.random(list, Random.INSTANCE);
                                                                str = (String) random;
                                                            }
                                                            String str2 = str;
                                                            int i19 = 2;
                                                            substringAfterLast$default = StringsKt__StringsKt.substringAfterLast$default(UserMarkerInfo.this.user.f444493m, ".", (String) null, 2, (Object) null);
                                                            int hashCode = substringAfterLast$default.hashCode();
                                                            if (hashCode == -1096937569) {
                                                                if (substringAfterLast$default.equals(QEffectType.LOTTIE_TAG)) {
                                                                    i19 = 3;
                                                                    if (WhenMappings.$EnumSwitchMapping$0[BoxType$EnumUnboxingSharedUtility.ordinal(i19)] == 1) {
                                                                    }
                                                                    i iVar = i.INSTANCE;
                                                                    i B = ComposeLayoutPropUpdaterKt.B(ComposeLayoutPropUpdaterKt.k(iVar, userMarkerConfig3.infoBarSize.getHeight()));
                                                                    if (z18) {
                                                                    }
                                                                    i b18 = B.b(iVar);
                                                                    a.e b19 = com.tencent.ntcompose.foundation.layout.base.a.f339245a.b();
                                                                    Alignment.Vertical c16 = Alignment.INSTANCE.c();
                                                                    final NBPMoodGroupConfig.UserMarkerConfig userMarkerConfig4 = userMarkerConfig3;
                                                                    final UserMarkerInfo userMarkerInfo8 = UserMarkerInfo.this;
                                                                    Composer composer11 = composer9;
                                                                    RowKt.a(b18, b19, c16, null, null, ComposableLambdaKt.composableLambda(composer11, 1047537755, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.playground.UserMarkerViewKt.UserMarkerView.3.3.2.2.1
                                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                        {
                                                                            super(3);
                                                                        }

                                                                        @Override // kotlin.jvm.functions.Function3
                                                                        public final Unit invoke(n nVar, Composer composer12, Integer num5) {
                                                                            Composer composer13 = composer12;
                                                                            int intValue5 = num5.intValue();
                                                                            if ((intValue5 & 81) == 16 && composer13.getSkipping()) {
                                                                                composer13.skipToGroupEnd();
                                                                            } else {
                                                                                if (ComposerKt.isTraceInProgress()) {
                                                                                    ComposerKt.traceEventStart(1047537755, intValue5, -1, "com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.playground.UserMarkerView.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (UserMarkerView.kt:179)");
                                                                                }
                                                                                i.Companion companion3 = i.INSTANCE;
                                                                                i size3 = ModifierExtKt.size(companion3, NBPMoodGroupConfig.UserMarkerConfig.this.avatarContainerSize);
                                                                                Alignment alignment = Alignment.Center;
                                                                                final UserMarkerInfo userMarkerInfo9 = userMarkerInfo8;
                                                                                final NBPMoodGroupConfig.UserMarkerConfig userMarkerConfig5 = NBPMoodGroupConfig.UserMarkerConfig.this;
                                                                                BoxKt.a(size3, alignment, null, ComposableLambdaKt.composableLambda(composer13, 472574357, true, new Function3<com.tencent.ntcompose.foundation.layout.b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.playground.UserMarkerViewKt.UserMarkerView.3.3.2.2.1.1
                                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                    {
                                                                                        super(3);
                                                                                    }

                                                                                    @Override // kotlin.jvm.functions.Function3
                                                                                    public final Unit invoke(com.tencent.ntcompose.foundation.layout.b bVar3, Composer composer14, Integer num6) {
                                                                                        int i26;
                                                                                        com.tencent.ntcompose.foundation.layout.b bVar4 = bVar3;
                                                                                        Composer composer15 = composer14;
                                                                                        int intValue6 = num6.intValue();
                                                                                        if ((intValue6 & 14) == 0) {
                                                                                            i26 = (composer15.changed(bVar4) ? 4 : 2) | intValue6;
                                                                                        } else {
                                                                                            i26 = intValue6;
                                                                                        }
                                                                                        if ((i26 & 91) == 18 && composer15.getSkipping()) {
                                                                                            composer15.skipToGroupEnd();
                                                                                        } else {
                                                                                            if (ComposerKt.isTraceInProgress()) {
                                                                                                ComposerKt.traceEventStart(472574357, intValue6, -1, "com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.playground.UserMarkerView.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (UserMarkerView.kt:184)");
                                                                                            }
                                                                                            String str3 = UserMarkerInfo.this.user.f444491h;
                                                                                            i.Companion companion4 = i.INSTANCE;
                                                                                            i size4 = ModifierExtKt.size(companion4, userMarkerConfig5.avatarSize);
                                                                                            h.Companion companion5 = h.INSTANCE;
                                                                                            i c17 = ModifiersKt.c(size4, companion5.m());
                                                                                            NBPMoodGroupConfig.UserMarkerConfig userMarkerConfig6 = userMarkerConfig5;
                                                                                            ImageKt.a(str3, null, null, null, null, ModifiersKt.j(ModifiersKt.c(ModifiersKt.f(c17, userMarkerConfig6.avatarBorder, userMarkerConfig6.avatarBorderColor, BorderStyle.SOLID), companion5.e()), userMarkerConfig5.avatarRadius), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, composer15, 262144, 0, 0, 2097118);
                                                                                            if (UserMarkerInfo.this.user.C) {
                                                                                                ImageKt.a(userMarkerConfig5.avatarOnlineIcon.src, null, null, null, null, bVar4.a(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(companion4, userMarkerConfig5.avatarOnlineIcon.width), userMarkerConfig5.avatarOnlineIcon.height), Alignment.BottomEnd), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, composer15, 262144, 0, 0, 2097118);
                                                                                            }
                                                                                            if (ComposerKt.isTraceInProgress()) {
                                                                                                ComposerKt.traceEventEnd();
                                                                                            }
                                                                                        }
                                                                                        return Unit.INSTANCE;
                                                                                    }
                                                                                }), composer13, 3128, 4);
                                                                                i n3 = ComposeLayoutPropUpdaterKt.n(com.tencent.ntcompose.foundation.layout.h.b(companion3, NBPMoodGroupConfig.UserMarkerConfig.this.nicknameMaxWidth), NBPMoodGroupConfig.UserMarkerConfig.this.nicknameMarginLeft, 0.0f, 0.0f, 0.0f, 14, null);
                                                                                StringBuilder m3 = BotListCellKt$BotListCell$3$1$2$2$$ExternalSyntheticOutline0.m((char) 0);
                                                                                m3.append(userMarkerInfo8.user.f444490f);
                                                                                String sb5 = m3.toString();
                                                                                NBPMoodGroupConfig.UserMarkerConfig userMarkerConfig6 = NBPMoodGroupConfig.UserMarkerConfig.this;
                                                                                h hVar = userMarkerConfig6.nicknameFontColor;
                                                                                float f19 = userMarkerConfig6.nicknameFontSize;
                                                                                TextKt.a(sb5, n3, null, hVar, Float.valueOf(f19), null, c.INSTANCE.f(), new com.tencent.ntcompose.material.n("PingFang SC"), null, null, null, Float.valueOf(NBPMoodGroupConfig.UserMarkerConfig.this.nicknameLineHeight), null, null, null, null, null, null, 1, null, null, null, "emoji", null, null, null, false, composer13, (com.tencent.ntcompose.material.n.f339436b << 21) | 1577024, 100663296, MsgConstant.KRMFILETHUMBSIZE384, 129759012);
                                                                                if (ComposerKt.isTraceInProgress()) {
                                                                                    ComposerKt.traceEventEnd();
                                                                                }
                                                                            }
                                                                            return Unit.INSTANCE;
                                                                        }
                                                                    }), composer11, 196680, 24);
                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                    }
                                                                }
                                                                i19 = 1;
                                                                if (WhenMappings.$EnumSwitchMapping$0[BoxType$EnumUnboxingSharedUtility.ordinal(i19)] == 1) {
                                                                }
                                                                i iVar2 = i.INSTANCE;
                                                                i B2 = ComposeLayoutPropUpdaterKt.B(ComposeLayoutPropUpdaterKt.k(iVar2, userMarkerConfig3.infoBarSize.getHeight()));
                                                                if (z18) {
                                                                }
                                                                i b182 = B2.b(iVar2);
                                                                a.e b192 = com.tencent.ntcompose.foundation.layout.base.a.f339245a.b();
                                                                Alignment.Vertical c162 = Alignment.INSTANCE.c();
                                                                final NBPMoodGroupConfig.UserMarkerConfig userMarkerConfig42 = userMarkerConfig3;
                                                                final UserMarkerInfo userMarkerInfo82 = UserMarkerInfo.this;
                                                                Composer composer112 = composer9;
                                                                RowKt.a(b182, b192, c162, null, null, ComposableLambdaKt.composableLambda(composer112, 1047537755, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.playground.UserMarkerViewKt.UserMarkerView.3.3.2.2.1
                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                    {
                                                                        super(3);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function3
                                                                    public final Unit invoke(n nVar, Composer composer12, Integer num5) {
                                                                        Composer composer13 = composer12;
                                                                        int intValue5 = num5.intValue();
                                                                        if ((intValue5 & 81) == 16 && composer13.getSkipping()) {
                                                                            composer13.skipToGroupEnd();
                                                                        } else {
                                                                            if (ComposerKt.isTraceInProgress()) {
                                                                                ComposerKt.traceEventStart(1047537755, intValue5, -1, "com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.playground.UserMarkerView.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (UserMarkerView.kt:179)");
                                                                            }
                                                                            i.Companion companion3 = i.INSTANCE;
                                                                            i size3 = ModifierExtKt.size(companion3, NBPMoodGroupConfig.UserMarkerConfig.this.avatarContainerSize);
                                                                            Alignment alignment = Alignment.Center;
                                                                            final UserMarkerInfo userMarkerInfo9 = userMarkerInfo82;
                                                                            final NBPMoodGroupConfig.UserMarkerConfig userMarkerConfig5 = NBPMoodGroupConfig.UserMarkerConfig.this;
                                                                            BoxKt.a(size3, alignment, null, ComposableLambdaKt.composableLambda(composer13, 472574357, true, new Function3<com.tencent.ntcompose.foundation.layout.b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.playground.UserMarkerViewKt.UserMarkerView.3.3.2.2.1.1
                                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                {
                                                                                    super(3);
                                                                                }

                                                                                @Override // kotlin.jvm.functions.Function3
                                                                                public final Unit invoke(com.tencent.ntcompose.foundation.layout.b bVar3, Composer composer14, Integer num6) {
                                                                                    int i26;
                                                                                    com.tencent.ntcompose.foundation.layout.b bVar4 = bVar3;
                                                                                    Composer composer15 = composer14;
                                                                                    int intValue6 = num6.intValue();
                                                                                    if ((intValue6 & 14) == 0) {
                                                                                        i26 = (composer15.changed(bVar4) ? 4 : 2) | intValue6;
                                                                                    } else {
                                                                                        i26 = intValue6;
                                                                                    }
                                                                                    if ((i26 & 91) == 18 && composer15.getSkipping()) {
                                                                                        composer15.skipToGroupEnd();
                                                                                    } else {
                                                                                        if (ComposerKt.isTraceInProgress()) {
                                                                                            ComposerKt.traceEventStart(472574357, intValue6, -1, "com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.playground.UserMarkerView.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (UserMarkerView.kt:184)");
                                                                                        }
                                                                                        String str3 = UserMarkerInfo.this.user.f444491h;
                                                                                        i.Companion companion4 = i.INSTANCE;
                                                                                        i size4 = ModifierExtKt.size(companion4, userMarkerConfig5.avatarSize);
                                                                                        h.Companion companion5 = h.INSTANCE;
                                                                                        i c17 = ModifiersKt.c(size4, companion5.m());
                                                                                        NBPMoodGroupConfig.UserMarkerConfig userMarkerConfig6 = userMarkerConfig5;
                                                                                        ImageKt.a(str3, null, null, null, null, ModifiersKt.j(ModifiersKt.c(ModifiersKt.f(c17, userMarkerConfig6.avatarBorder, userMarkerConfig6.avatarBorderColor, BorderStyle.SOLID), companion5.e()), userMarkerConfig5.avatarRadius), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, composer15, 262144, 0, 0, 2097118);
                                                                                        if (UserMarkerInfo.this.user.C) {
                                                                                            ImageKt.a(userMarkerConfig5.avatarOnlineIcon.src, null, null, null, null, bVar4.a(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(companion4, userMarkerConfig5.avatarOnlineIcon.width), userMarkerConfig5.avatarOnlineIcon.height), Alignment.BottomEnd), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, composer15, 262144, 0, 0, 2097118);
                                                                                        }
                                                                                        if (ComposerKt.isTraceInProgress()) {
                                                                                            ComposerKt.traceEventEnd();
                                                                                        }
                                                                                    }
                                                                                    return Unit.INSTANCE;
                                                                                }
                                                                            }), composer13, 3128, 4);
                                                                            i n3 = ComposeLayoutPropUpdaterKt.n(com.tencent.ntcompose.foundation.layout.h.b(companion3, NBPMoodGroupConfig.UserMarkerConfig.this.nicknameMaxWidth), NBPMoodGroupConfig.UserMarkerConfig.this.nicknameMarginLeft, 0.0f, 0.0f, 0.0f, 14, null);
                                                                            StringBuilder m3 = BotListCellKt$BotListCell$3$1$2$2$$ExternalSyntheticOutline0.m((char) 0);
                                                                            m3.append(userMarkerInfo82.user.f444490f);
                                                                            String sb5 = m3.toString();
                                                                            NBPMoodGroupConfig.UserMarkerConfig userMarkerConfig6 = NBPMoodGroupConfig.UserMarkerConfig.this;
                                                                            h hVar = userMarkerConfig6.nicknameFontColor;
                                                                            float f19 = userMarkerConfig6.nicknameFontSize;
                                                                            TextKt.a(sb5, n3, null, hVar, Float.valueOf(f19), null, c.INSTANCE.f(), new com.tencent.ntcompose.material.n("PingFang SC"), null, null, null, Float.valueOf(NBPMoodGroupConfig.UserMarkerConfig.this.nicknameLineHeight), null, null, null, null, null, null, 1, null, null, null, "emoji", null, null, null, false, composer13, (com.tencent.ntcompose.material.n.f339436b << 21) | 1577024, 100663296, MsgConstant.KRMFILETHUMBSIZE384, 129759012);
                                                                            if (ComposerKt.isTraceInProgress()) {
                                                                                ComposerKt.traceEventEnd();
                                                                            }
                                                                        }
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                }), composer112, 196680, 24);
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                }
                                                            } else if (hashCode == 110742) {
                                                                if (substringAfterLast$default.equals("pag")) {
                                                                    i19 = 4;
                                                                    if (WhenMappings.$EnumSwitchMapping$0[BoxType$EnumUnboxingSharedUtility.ordinal(i19)] == 1) {
                                                                    }
                                                                    i iVar22 = i.INSTANCE;
                                                                    i B22 = ComposeLayoutPropUpdaterKt.B(ComposeLayoutPropUpdaterKt.k(iVar22, userMarkerConfig3.infoBarSize.getHeight()));
                                                                    if (z18) {
                                                                    }
                                                                    i b1822 = B22.b(iVar22);
                                                                    a.e b1922 = com.tencent.ntcompose.foundation.layout.base.a.f339245a.b();
                                                                    Alignment.Vertical c1622 = Alignment.INSTANCE.c();
                                                                    final NBPMoodGroupConfig.UserMarkerConfig userMarkerConfig422 = userMarkerConfig3;
                                                                    final UserMarkerInfo userMarkerInfo822 = UserMarkerInfo.this;
                                                                    Composer composer1122 = composer9;
                                                                    RowKt.a(b1822, b1922, c1622, null, null, ComposableLambdaKt.composableLambda(composer1122, 1047537755, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.playground.UserMarkerViewKt.UserMarkerView.3.3.2.2.1
                                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                        {
                                                                            super(3);
                                                                        }

                                                                        @Override // kotlin.jvm.functions.Function3
                                                                        public final Unit invoke(n nVar, Composer composer12, Integer num5) {
                                                                            Composer composer13 = composer12;
                                                                            int intValue5 = num5.intValue();
                                                                            if ((intValue5 & 81) == 16 && composer13.getSkipping()) {
                                                                                composer13.skipToGroupEnd();
                                                                            } else {
                                                                                if (ComposerKt.isTraceInProgress()) {
                                                                                    ComposerKt.traceEventStart(1047537755, intValue5, -1, "com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.playground.UserMarkerView.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (UserMarkerView.kt:179)");
                                                                                }
                                                                                i.Companion companion3 = i.INSTANCE;
                                                                                i size3 = ModifierExtKt.size(companion3, NBPMoodGroupConfig.UserMarkerConfig.this.avatarContainerSize);
                                                                                Alignment alignment = Alignment.Center;
                                                                                final UserMarkerInfo userMarkerInfo9 = userMarkerInfo822;
                                                                                final NBPMoodGroupConfig.UserMarkerConfig userMarkerConfig5 = NBPMoodGroupConfig.UserMarkerConfig.this;
                                                                                BoxKt.a(size3, alignment, null, ComposableLambdaKt.composableLambda(composer13, 472574357, true, new Function3<com.tencent.ntcompose.foundation.layout.b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.playground.UserMarkerViewKt.UserMarkerView.3.3.2.2.1.1
                                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                    {
                                                                                        super(3);
                                                                                    }

                                                                                    @Override // kotlin.jvm.functions.Function3
                                                                                    public final Unit invoke(com.tencent.ntcompose.foundation.layout.b bVar3, Composer composer14, Integer num6) {
                                                                                        int i26;
                                                                                        com.tencent.ntcompose.foundation.layout.b bVar4 = bVar3;
                                                                                        Composer composer15 = composer14;
                                                                                        int intValue6 = num6.intValue();
                                                                                        if ((intValue6 & 14) == 0) {
                                                                                            i26 = (composer15.changed(bVar4) ? 4 : 2) | intValue6;
                                                                                        } else {
                                                                                            i26 = intValue6;
                                                                                        }
                                                                                        if ((i26 & 91) == 18 && composer15.getSkipping()) {
                                                                                            composer15.skipToGroupEnd();
                                                                                        } else {
                                                                                            if (ComposerKt.isTraceInProgress()) {
                                                                                                ComposerKt.traceEventStart(472574357, intValue6, -1, "com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.playground.UserMarkerView.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (UserMarkerView.kt:184)");
                                                                                            }
                                                                                            String str3 = UserMarkerInfo.this.user.f444491h;
                                                                                            i.Companion companion4 = i.INSTANCE;
                                                                                            i size4 = ModifierExtKt.size(companion4, userMarkerConfig5.avatarSize);
                                                                                            h.Companion companion5 = h.INSTANCE;
                                                                                            i c17 = ModifiersKt.c(size4, companion5.m());
                                                                                            NBPMoodGroupConfig.UserMarkerConfig userMarkerConfig6 = userMarkerConfig5;
                                                                                            ImageKt.a(str3, null, null, null, null, ModifiersKt.j(ModifiersKt.c(ModifiersKt.f(c17, userMarkerConfig6.avatarBorder, userMarkerConfig6.avatarBorderColor, BorderStyle.SOLID), companion5.e()), userMarkerConfig5.avatarRadius), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, composer15, 262144, 0, 0, 2097118);
                                                                                            if (UserMarkerInfo.this.user.C) {
                                                                                                ImageKt.a(userMarkerConfig5.avatarOnlineIcon.src, null, null, null, null, bVar4.a(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(companion4, userMarkerConfig5.avatarOnlineIcon.width), userMarkerConfig5.avatarOnlineIcon.height), Alignment.BottomEnd), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, composer15, 262144, 0, 0, 2097118);
                                                                                            }
                                                                                            if (ComposerKt.isTraceInProgress()) {
                                                                                                ComposerKt.traceEventEnd();
                                                                                            }
                                                                                        }
                                                                                        return Unit.INSTANCE;
                                                                                    }
                                                                                }), composer13, 3128, 4);
                                                                                i n3 = ComposeLayoutPropUpdaterKt.n(com.tencent.ntcompose.foundation.layout.h.b(companion3, NBPMoodGroupConfig.UserMarkerConfig.this.nicknameMaxWidth), NBPMoodGroupConfig.UserMarkerConfig.this.nicknameMarginLeft, 0.0f, 0.0f, 0.0f, 14, null);
                                                                                StringBuilder m3 = BotListCellKt$BotListCell$3$1$2$2$$ExternalSyntheticOutline0.m((char) 0);
                                                                                m3.append(userMarkerInfo822.user.f444490f);
                                                                                String sb5 = m3.toString();
                                                                                NBPMoodGroupConfig.UserMarkerConfig userMarkerConfig6 = NBPMoodGroupConfig.UserMarkerConfig.this;
                                                                                h hVar = userMarkerConfig6.nicknameFontColor;
                                                                                float f19 = userMarkerConfig6.nicknameFontSize;
                                                                                TextKt.a(sb5, n3, null, hVar, Float.valueOf(f19), null, c.INSTANCE.f(), new com.tencent.ntcompose.material.n("PingFang SC"), null, null, null, Float.valueOf(NBPMoodGroupConfig.UserMarkerConfig.this.nicknameLineHeight), null, null, null, null, null, null, 1, null, null, null, "emoji", null, null, null, false, composer13, (com.tencent.ntcompose.material.n.f339436b << 21) | 1577024, 100663296, MsgConstant.KRMFILETHUMBSIZE384, 129759012);
                                                                                if (ComposerKt.isTraceInProgress()) {
                                                                                    ComposerKt.traceEventEnd();
                                                                                }
                                                                            }
                                                                            return Unit.INSTANCE;
                                                                        }
                                                                    }), composer1122, 196680, 24);
                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                    }
                                                                }
                                                                i19 = 1;
                                                                if (WhenMappings.$EnumSwitchMapping$0[BoxType$EnumUnboxingSharedUtility.ordinal(i19)] == 1) {
                                                                }
                                                                i iVar222 = i.INSTANCE;
                                                                i B222 = ComposeLayoutPropUpdaterKt.B(ComposeLayoutPropUpdaterKt.k(iVar222, userMarkerConfig3.infoBarSize.getHeight()));
                                                                if (z18) {
                                                                }
                                                                i b18222 = B222.b(iVar222);
                                                                a.e b19222 = com.tencent.ntcompose.foundation.layout.base.a.f339245a.b();
                                                                Alignment.Vertical c16222 = Alignment.INSTANCE.c();
                                                                final NBPMoodGroupConfig.UserMarkerConfig userMarkerConfig4222 = userMarkerConfig3;
                                                                final UserMarkerInfo userMarkerInfo8222 = UserMarkerInfo.this;
                                                                Composer composer11222 = composer9;
                                                                RowKt.a(b18222, b19222, c16222, null, null, ComposableLambdaKt.composableLambda(composer11222, 1047537755, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.playground.UserMarkerViewKt.UserMarkerView.3.3.2.2.1
                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                    {
                                                                        super(3);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function3
                                                                    public final Unit invoke(n nVar, Composer composer12, Integer num5) {
                                                                        Composer composer13 = composer12;
                                                                        int intValue5 = num5.intValue();
                                                                        if ((intValue5 & 81) == 16 && composer13.getSkipping()) {
                                                                            composer13.skipToGroupEnd();
                                                                        } else {
                                                                            if (ComposerKt.isTraceInProgress()) {
                                                                                ComposerKt.traceEventStart(1047537755, intValue5, -1, "com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.playground.UserMarkerView.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (UserMarkerView.kt:179)");
                                                                            }
                                                                            i.Companion companion3 = i.INSTANCE;
                                                                            i size3 = ModifierExtKt.size(companion3, NBPMoodGroupConfig.UserMarkerConfig.this.avatarContainerSize);
                                                                            Alignment alignment = Alignment.Center;
                                                                            final UserMarkerInfo userMarkerInfo9 = userMarkerInfo8222;
                                                                            final NBPMoodGroupConfig.UserMarkerConfig userMarkerConfig5 = NBPMoodGroupConfig.UserMarkerConfig.this;
                                                                            BoxKt.a(size3, alignment, null, ComposableLambdaKt.composableLambda(composer13, 472574357, true, new Function3<com.tencent.ntcompose.foundation.layout.b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.playground.UserMarkerViewKt.UserMarkerView.3.3.2.2.1.1
                                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                {
                                                                                    super(3);
                                                                                }

                                                                                @Override // kotlin.jvm.functions.Function3
                                                                                public final Unit invoke(com.tencent.ntcompose.foundation.layout.b bVar3, Composer composer14, Integer num6) {
                                                                                    int i26;
                                                                                    com.tencent.ntcompose.foundation.layout.b bVar4 = bVar3;
                                                                                    Composer composer15 = composer14;
                                                                                    int intValue6 = num6.intValue();
                                                                                    if ((intValue6 & 14) == 0) {
                                                                                        i26 = (composer15.changed(bVar4) ? 4 : 2) | intValue6;
                                                                                    } else {
                                                                                        i26 = intValue6;
                                                                                    }
                                                                                    if ((i26 & 91) == 18 && composer15.getSkipping()) {
                                                                                        composer15.skipToGroupEnd();
                                                                                    } else {
                                                                                        if (ComposerKt.isTraceInProgress()) {
                                                                                            ComposerKt.traceEventStart(472574357, intValue6, -1, "com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.playground.UserMarkerView.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (UserMarkerView.kt:184)");
                                                                                        }
                                                                                        String str3 = UserMarkerInfo.this.user.f444491h;
                                                                                        i.Companion companion4 = i.INSTANCE;
                                                                                        i size4 = ModifierExtKt.size(companion4, userMarkerConfig5.avatarSize);
                                                                                        h.Companion companion5 = h.INSTANCE;
                                                                                        i c17 = ModifiersKt.c(size4, companion5.m());
                                                                                        NBPMoodGroupConfig.UserMarkerConfig userMarkerConfig6 = userMarkerConfig5;
                                                                                        ImageKt.a(str3, null, null, null, null, ModifiersKt.j(ModifiersKt.c(ModifiersKt.f(c17, userMarkerConfig6.avatarBorder, userMarkerConfig6.avatarBorderColor, BorderStyle.SOLID), companion5.e()), userMarkerConfig5.avatarRadius), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, composer15, 262144, 0, 0, 2097118);
                                                                                        if (UserMarkerInfo.this.user.C) {
                                                                                            ImageKt.a(userMarkerConfig5.avatarOnlineIcon.src, null, null, null, null, bVar4.a(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(companion4, userMarkerConfig5.avatarOnlineIcon.width), userMarkerConfig5.avatarOnlineIcon.height), Alignment.BottomEnd), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, composer15, 262144, 0, 0, 2097118);
                                                                                        }
                                                                                        if (ComposerKt.isTraceInProgress()) {
                                                                                            ComposerKt.traceEventEnd();
                                                                                        }
                                                                                    }
                                                                                    return Unit.INSTANCE;
                                                                                }
                                                                            }), composer13, 3128, 4);
                                                                            i n3 = ComposeLayoutPropUpdaterKt.n(com.tencent.ntcompose.foundation.layout.h.b(companion3, NBPMoodGroupConfig.UserMarkerConfig.this.nicknameMaxWidth), NBPMoodGroupConfig.UserMarkerConfig.this.nicknameMarginLeft, 0.0f, 0.0f, 0.0f, 14, null);
                                                                            StringBuilder m3 = BotListCellKt$BotListCell$3$1$2$2$$ExternalSyntheticOutline0.m((char) 0);
                                                                            m3.append(userMarkerInfo8222.user.f444490f);
                                                                            String sb5 = m3.toString();
                                                                            NBPMoodGroupConfig.UserMarkerConfig userMarkerConfig6 = NBPMoodGroupConfig.UserMarkerConfig.this;
                                                                            h hVar = userMarkerConfig6.nicknameFontColor;
                                                                            float f19 = userMarkerConfig6.nicknameFontSize;
                                                                            TextKt.a(sb5, n3, null, hVar, Float.valueOf(f19), null, c.INSTANCE.f(), new com.tencent.ntcompose.material.n("PingFang SC"), null, null, null, Float.valueOf(NBPMoodGroupConfig.UserMarkerConfig.this.nicknameLineHeight), null, null, null, null, null, null, 1, null, null, null, "emoji", null, null, null, false, composer13, (com.tencent.ntcompose.material.n.f339436b << 21) | 1577024, 100663296, MsgConstant.KRMFILETHUMBSIZE384, 129759012);
                                                                            if (ComposerKt.isTraceInProgress()) {
                                                                                ComposerKt.traceEventEnd();
                                                                            }
                                                                        }
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                }), composer11222, 196680, 24);
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                }
                                                            } else {
                                                                if (hashCode == 3000872) {
                                                                }
                                                                i19 = 1;
                                                                if (WhenMappings.$EnumSwitchMapping$0[BoxType$EnumUnboxingSharedUtility.ordinal(i19)] == 1) {
                                                                    composer10.startReplaceableGroup(147062245);
                                                                    APNGKt.a(ModifierExtKt.size(i.INSTANCE, userMarkerConfig3.imageSize), null, str2, 0, Boolean.TRUE, null, null, null, composer10, 27656, 226);
                                                                    composer10.endReplaceableGroup();
                                                                    composer9 = composer10;
                                                                } else {
                                                                    composer10.startReplaceableGroup(147062591);
                                                                    composer9 = composer10;
                                                                    ImageKt.a(str2, null, null, null, null, ModifierExtKt.size(i.INSTANCE, userMarkerConfig3.imageSize), null, com.tencent.ntcompose.material.h.INSTANCE.c(), null, null, null, null, null, null, null, null, null, null, null, null, null, composer9, 12845056, 0, 0, 2096990);
                                                                    composer9.endReplaceableGroup();
                                                                }
                                                                i iVar2222 = i.INSTANCE;
                                                                i B2222 = ComposeLayoutPropUpdaterKt.B(ComposeLayoutPropUpdaterKt.k(iVar2222, userMarkerConfig3.infoBarSize.getHeight()));
                                                                if (z18) {
                                                                    iVar2222 = ComposeLayoutPropUpdaterKt.s(ModifiersKt.j(ModifiersKt.c(iVar2222, userMarkerConfig3.infoBarBgColor), userMarkerConfig3.infoBarRadius), 0.0f, 0.0f, userMarkerConfig3.infoBarRadius / 2.0f, 0.0f, 11, null);
                                                                }
                                                                i b182222 = B2222.b(iVar2222);
                                                                a.e b192222 = com.tencent.ntcompose.foundation.layout.base.a.f339245a.b();
                                                                Alignment.Vertical c162222 = Alignment.INSTANCE.c();
                                                                final NBPMoodGroupConfig.UserMarkerConfig userMarkerConfig42222 = userMarkerConfig3;
                                                                final UserMarkerInfo userMarkerInfo82222 = UserMarkerInfo.this;
                                                                Composer composer112222 = composer9;
                                                                RowKt.a(b182222, b192222, c162222, null, null, ComposableLambdaKt.composableLambda(composer112222, 1047537755, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.playground.UserMarkerViewKt.UserMarkerView.3.3.2.2.1
                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                    {
                                                                        super(3);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function3
                                                                    public final Unit invoke(n nVar, Composer composer12, Integer num5) {
                                                                        Composer composer13 = composer12;
                                                                        int intValue5 = num5.intValue();
                                                                        if ((intValue5 & 81) == 16 && composer13.getSkipping()) {
                                                                            composer13.skipToGroupEnd();
                                                                        } else {
                                                                            if (ComposerKt.isTraceInProgress()) {
                                                                                ComposerKt.traceEventStart(1047537755, intValue5, -1, "com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.playground.UserMarkerView.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (UserMarkerView.kt:179)");
                                                                            }
                                                                            i.Companion companion3 = i.INSTANCE;
                                                                            i size3 = ModifierExtKt.size(companion3, NBPMoodGroupConfig.UserMarkerConfig.this.avatarContainerSize);
                                                                            Alignment alignment = Alignment.Center;
                                                                            final UserMarkerInfo userMarkerInfo9 = userMarkerInfo82222;
                                                                            final NBPMoodGroupConfig.UserMarkerConfig userMarkerConfig5 = NBPMoodGroupConfig.UserMarkerConfig.this;
                                                                            BoxKt.a(size3, alignment, null, ComposableLambdaKt.composableLambda(composer13, 472574357, true, new Function3<com.tencent.ntcompose.foundation.layout.b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.playground.UserMarkerViewKt.UserMarkerView.3.3.2.2.1.1
                                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                {
                                                                                    super(3);
                                                                                }

                                                                                @Override // kotlin.jvm.functions.Function3
                                                                                public final Unit invoke(com.tencent.ntcompose.foundation.layout.b bVar3, Composer composer14, Integer num6) {
                                                                                    int i26;
                                                                                    com.tencent.ntcompose.foundation.layout.b bVar4 = bVar3;
                                                                                    Composer composer15 = composer14;
                                                                                    int intValue6 = num6.intValue();
                                                                                    if ((intValue6 & 14) == 0) {
                                                                                        i26 = (composer15.changed(bVar4) ? 4 : 2) | intValue6;
                                                                                    } else {
                                                                                        i26 = intValue6;
                                                                                    }
                                                                                    if ((i26 & 91) == 18 && composer15.getSkipping()) {
                                                                                        composer15.skipToGroupEnd();
                                                                                    } else {
                                                                                        if (ComposerKt.isTraceInProgress()) {
                                                                                            ComposerKt.traceEventStart(472574357, intValue6, -1, "com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.playground.UserMarkerView.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (UserMarkerView.kt:184)");
                                                                                        }
                                                                                        String str3 = UserMarkerInfo.this.user.f444491h;
                                                                                        i.Companion companion4 = i.INSTANCE;
                                                                                        i size4 = ModifierExtKt.size(companion4, userMarkerConfig5.avatarSize);
                                                                                        h.Companion companion5 = h.INSTANCE;
                                                                                        i c17 = ModifiersKt.c(size4, companion5.m());
                                                                                        NBPMoodGroupConfig.UserMarkerConfig userMarkerConfig6 = userMarkerConfig5;
                                                                                        ImageKt.a(str3, null, null, null, null, ModifiersKt.j(ModifiersKt.c(ModifiersKt.f(c17, userMarkerConfig6.avatarBorder, userMarkerConfig6.avatarBorderColor, BorderStyle.SOLID), companion5.e()), userMarkerConfig5.avatarRadius), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, composer15, 262144, 0, 0, 2097118);
                                                                                        if (UserMarkerInfo.this.user.C) {
                                                                                            ImageKt.a(userMarkerConfig5.avatarOnlineIcon.src, null, null, null, null, bVar4.a(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(companion4, userMarkerConfig5.avatarOnlineIcon.width), userMarkerConfig5.avatarOnlineIcon.height), Alignment.BottomEnd), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, composer15, 262144, 0, 0, 2097118);
                                                                                        }
                                                                                        if (ComposerKt.isTraceInProgress()) {
                                                                                            ComposerKt.traceEventEnd();
                                                                                        }
                                                                                    }
                                                                                    return Unit.INSTANCE;
                                                                                }
                                                                            }), composer13, 3128, 4);
                                                                            i n3 = ComposeLayoutPropUpdaterKt.n(com.tencent.ntcompose.foundation.layout.h.b(companion3, NBPMoodGroupConfig.UserMarkerConfig.this.nicknameMaxWidth), NBPMoodGroupConfig.UserMarkerConfig.this.nicknameMarginLeft, 0.0f, 0.0f, 0.0f, 14, null);
                                                                            StringBuilder m3 = BotListCellKt$BotListCell$3$1$2$2$$ExternalSyntheticOutline0.m((char) 0);
                                                                            m3.append(userMarkerInfo82222.user.f444490f);
                                                                            String sb5 = m3.toString();
                                                                            NBPMoodGroupConfig.UserMarkerConfig userMarkerConfig6 = NBPMoodGroupConfig.UserMarkerConfig.this;
                                                                            h hVar = userMarkerConfig6.nicknameFontColor;
                                                                            float f19 = userMarkerConfig6.nicknameFontSize;
                                                                            TextKt.a(sb5, n3, null, hVar, Float.valueOf(f19), null, c.INSTANCE.f(), new com.tencent.ntcompose.material.n("PingFang SC"), null, null, null, Float.valueOf(NBPMoodGroupConfig.UserMarkerConfig.this.nicknameLineHeight), null, null, null, null, null, null, 1, null, null, null, "emoji", null, null, null, false, composer13, (com.tencent.ntcompose.material.n.f339436b << 21) | 1577024, 100663296, MsgConstant.KRMFILETHUMBSIZE384, 129759012);
                                                                            if (ComposerKt.isTraceInProgress()) {
                                                                                ComposerKt.traceEventEnd();
                                                                            }
                                                                        }
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                }), composer112222, 196680, 24);
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                    ComposerKt.traceEventEnd();
                                                                }
                                                            }
                                                        }
                                                        return Unit.INSTANCE;
                                                    }
                                                }), composer7, 24648, 8);
                                                ImageConfig imageConfig = (ImageConfig) this.$marker.currentAnimation$delegate.getValue();
                                                if (imageConfig != null) {
                                                    final UserMarkerInfo userMarkerInfo7 = this.$marker;
                                                    i k3 = ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(companion2, imageConfig.width), imageConfig.height);
                                                    String str = imageConfig.src;
                                                    composer7.startReplaceableGroup(1157296644);
                                                    boolean changed3 = composer7.changed(userMarkerInfo7);
                                                    Object rememberedValue7 = composer7.rememberedValue();
                                                    if (changed3 || rememberedValue7 == Composer.INSTANCE.getEmpty()) {
                                                        rememberedValue7 = new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.playground.UserMarkerViewKt$UserMarkerView$3$3$2$3$1$1
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(Object obj) {
                                                                UserMarkerInfo.this.currentAnimation$delegate.setValue(null);
                                                                return Unit.INSTANCE;
                                                            }
                                                        };
                                                        composer7.updateRememberedValue(rememberedValue7);
                                                    }
                                                    composer7.endReplaceableGroup();
                                                    LottieKt.a(k3, null, str, false, true, null, null, (Function1) rememberedValue7, composer7, 27656, 98);
                                                }
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                            return Unit.INSTANCE;
                                        }
                                    }), composer5, 3128, 4);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                                return Unit.INSTANCE;
                            }
                        }), composer3, 24648, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                    return Unit.INSTANCE;
                }
            }), startRestartGroup, 3128, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.playground.UserMarkerViewKt$UserMarkerView$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                UserMarkerViewKt.UserMarkerView(UserMarkerInfo.this, function2, function22, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }
}
