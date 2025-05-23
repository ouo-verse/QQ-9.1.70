package com.tencent.hippykotlin.demo.pages.qwallet.biz.hb.detail.view;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import bp3.c;
import com.tencent.hippykotlin.demo.pages.compose_ui.view.qui.LoadingIconType;
import com.tencent.hippykotlin.demo.pages.compose_ui.view.qui.LoadingKt;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.kuikly.core.views.FooterRefreshState;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.RowKt;
import com.tencent.ntcompose.foundation.layout.base.Alignment;
import com.tencent.ntcompose.foundation.layout.n;
import com.tencent.ntcompose.material.FooterRefreshKt;
import com.tencent.ntcompose.material.SpacerKt;
import com.tencent.ntcompose.material.TextKt;
import com.tencent.ntcompose.material.p;
import com.tencent.ntcompose.ui.platform.CompositionLocalsKt;
import com.tencent.ntcompose.ui.platform.a;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class HbDetailFooterRefreshKt {

    /* compiled from: P */
    /* loaded from: classes33.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[FooterRefreshState.values().length];
            try {
                iArr[FooterRefreshState.REFRESHING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[FooterRefreshState.IDLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[FooterRefreshState.NONE_MORE_DATA.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[FooterRefreshState.FAILURE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final void HbDetailFooterRefresh(final i iVar, float f16, final Function1<? super Function2<? super Boolean, ? super Boolean, Unit>, Unit> function1, Composer composer, final int i3, final int i16) {
        Composer startRestartGroup = composer.startRestartGroup(1174063459);
        final float f17 = (i16 & 2) != 0 ? 100.0f : f16;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1174063459, i3, -1, "com.tencent.hippykotlin.demo.pages.qwallet.biz.hb.detail.view.HbDetailFooterRefresh (HbDetailFooterRefresh.kt:29)");
        }
        final p b16 = FooterRefreshKt.b(startRestartGroup, 0);
        startRestartGroup.startReplaceableGroup(-492369756);
        Object rememberedValue = startRestartGroup.rememberedValue();
        Composer.Companion companion = Composer.INSTANCE;
        if (rememberedValue == companion.getEmpty()) {
            rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(FooterRefreshState.IDLE, null, 2, null);
            startRestartGroup.updateRememberedValue(rememberedValue);
        }
        startRestartGroup.endReplaceableGroup();
        final MutableState mutableState = (MutableState) rememberedValue;
        i j3 = ComposeLayoutPropUpdaterKt.j(iVar, 0.0f, 1, null);
        startRestartGroup.startReplaceableGroup(1618982084);
        boolean changed = startRestartGroup.changed(mutableState) | startRestartGroup.changed(function1) | startRestartGroup.changed(b16);
        Object rememberedValue2 = startRestartGroup.rememberedValue();
        if (changed || rememberedValue2 == companion.getEmpty()) {
            rememberedValue2 = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qwallet.biz.hb.detail.view.HbDetailFooterRefreshKt$HbDetailFooterRefresh$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final Unit invoke() {
                    if (mutableState.getValue() != FooterRefreshState.NONE_MORE_DATA) {
                        mutableState.setValue(FooterRefreshState.REFRESHING);
                        Function1<Function2<? super Boolean, ? super Boolean, Unit>, Unit> function12 = function1;
                        final p pVar = b16;
                        final MutableState<FooterRefreshState> mutableState2 = mutableState;
                        function12.invoke(new Function2<Boolean, Boolean, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qwallet.biz.hb.detail.view.HbDetailFooterRefreshKt$HbDetailFooterRefresh$1$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public final Unit invoke(Boolean bool, Boolean bool2) {
                                boolean booleanValue = bool.booleanValue();
                                boolean booleanValue2 = bool2.booleanValue();
                                p.this.b(false);
                                if (booleanValue2) {
                                    mutableState2.setValue(FooterRefreshState.FAILURE);
                                } else if (booleanValue) {
                                    mutableState2.setValue(FooterRefreshState.NONE_MORE_DATA);
                                } else {
                                    mutableState2.setValue(FooterRefreshState.IDLE);
                                }
                                return Unit.INSTANCE;
                            }
                        });
                    }
                    return Unit.INSTANCE;
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue2);
        }
        startRestartGroup.endReplaceableGroup();
        FooterRefreshKt.a(b16, null, j3, f17, 5.0f, (Function0) rememberedValue2, ComposableLambdaKt.composableLambda(startRestartGroup, -441662158, true, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qwallet.biz.hb.detail.view.HbDetailFooterRefreshKt$HbDetailFooterRefresh$2
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
                        ComposerKt.traceEventStart(-441662158, intValue, -1, "com.tencent.hippykotlin.demo.pages.qwallet.biz.hb.detail.view.HbDetailFooterRefresh.<anonymous> (HbDetailFooterRefresh.kt:56)");
                    }
                    HbDetailFooterRefreshKt.HbDetailFooterRefreshView(mutableState.getValue(), composer3, 0);
                    SpacerKt.a(ComposeLayoutPropUpdaterKt.k(i.INSTANCE, ((a) composer3.consume(CompositionLocalsKt.d())).f().getBottom()), composer3, 8, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                return Unit.INSTANCE;
            }
        }), startRestartGroup, ((i3 << 6) & 7168) | 1597952, 2);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qwallet.biz.hb.detail.view.HbDetailFooterRefreshKt$HbDetailFooterRefresh$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                HbDetailFooterRefreshKt.HbDetailFooterRefresh(i.this, f17, function1, composer2, i3 | 1, i16);
                return Unit.INSTANCE;
            }
        });
    }

    public static final void HbDetailFooterRefreshView(final FooterRefreshState footerRefreshState, Composer composer, final int i3) {
        int i16;
        Composer startRestartGroup = composer.startRestartGroup(1317050955);
        if ((i3 & 14) == 0) {
            i16 = (startRestartGroup.changed(footerRefreshState) ? 4 : 2) | i3;
        } else {
            i16 = i3;
        }
        if ((i16 & 11) == 2 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1317050955, i3, -1, "com.tencent.hippykotlin.demo.pages.qwallet.biz.hb.detail.view.HbDetailFooterRefreshView (HbDetailFooterRefresh.kt:67)");
            }
            startRestartGroup.startReplaceableGroup(-492369756);
            Object rememberedValue = startRestartGroup.rememberedValue();
            String str = "";
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("", null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceableGroup();
            final MutableState mutableState = (MutableState) rememberedValue;
            int i17 = WhenMappings.$EnumSwitchMapping$0[footerRefreshState.ordinal()];
            if (i17 == 1 || i17 == 2) {
                str = "\u6570\u636e\u52a0\u8f7d\u4e2d...";
            } else if (i17 != 3 && i17 == 4) {
                str = "\u52a0\u8f7d\u6570\u636e\u5931\u8d25";
            }
            mutableState.setValue(str);
            RowKt.a(ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), 0.0f, 10.0f, 0.0f, 10.0f, 5, null), com.tencent.ntcompose.foundation.layout.base.a.f339245a.b(), Alignment.Vertical.CenterVertically, null, null, ComposableLambdaKt.composableLambda(startRestartGroup, 251130989, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qwallet.biz.hb.detail.view.HbDetailFooterRefreshKt$HbDetailFooterRefreshView$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public final Unit invoke(n nVar, Composer composer2, Integer num) {
                    LoadingIconType loadingIconType;
                    Composer composer3 = composer2;
                    int intValue = num.intValue();
                    if ((intValue & 81) == 16 && composer3.getSkipping()) {
                        composer3.skipToGroupEnd();
                    } else {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(251130989, intValue, -1, "com.tencent.hippykotlin.demo.pages.qwallet.biz.hb.detail.view.HbDetailFooterRefreshView.<anonymous> (HbDetailFooterRefresh.kt:90)");
                        }
                        composer3.startReplaceableGroup(-2046271494);
                        if (FooterRefreshState.this == FooterRefreshState.REFRESHING) {
                            if (QUIToken.INSTANCE.isNightMode()) {
                                loadingIconType = LoadingIconType.WHITE;
                            } else {
                                loadingIconType = LoadingIconType.GRAY;
                            }
                            LoadingKt.Loading(ComposeLayoutPropUpdaterKt.u(i.INSTANCE, 18.0f), loadingIconType, composer3, 8, 0);
                        }
                        composer3.endReplaceableGroup();
                        TextKt.a(mutableState.getValue(), ComposeLayoutPropUpdaterKt.n(i.INSTANCE, 6.0f, 0.0f, 0.0f, 0.0f, 14, null), null, QUIToken.color$default("text_secondary"), Float.valueOf(14.0f), null, c.INSTANCE.e(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer3, 1601600, 0, 0, 134217636);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                    return Unit.INSTANCE;
                }
            }), startRestartGroup, 197064, 24);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qwallet.biz.hb.detail.view.HbDetailFooterRefreshKt$HbDetailFooterRefreshView$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                HbDetailFooterRefreshKt.HbDetailFooterRefreshView(FooterRefreshState.this, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }
}
