package com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.view;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.common.compose.view.ErrorViewKt;
import com.tencent.hippykotlin.demo.pages.adelie.module.AdelieRedDotModule$Companion$RedDotInfo;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.AdelieCreativeCenterViewModel;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.ntcompose.foundation.lazy.d;
import com.tencent.ntcompose.foundation.lazy.layout.LazyDslKt;
import com.tencent.ntcompose.foundation.lazy.layout.a;
import com.tencent.ntcompose.material.SurfaceKt;
import h25.al;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import uo3.c;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class BotListKt {
    public static final void BotList(final a aVar, final AdelieCreativeCenterViewModel adelieCreativeCenterViewModel, final e eVar, final boolean z16, final d dVar, final boolean z17, final Function1<? super Boolean, Unit> function1, Composer composer, final int i3) {
        Composer startRestartGroup = composer.startRestartGroup(-514591378);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-514591378, i3, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.view.BotList (BotList.kt:19)");
        }
        startRestartGroup.startReplaceableGroup(-492369756);
        Object rememberedValue = startRestartGroup.rememberedValue();
        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new LinkedHashSet(), null, 2, null);
            startRestartGroup.updateRememberedValue(rememberedValue);
        }
        startRestartGroup.endReplaceableGroup();
        final MutableState mutableState = (MutableState) rememberedValue;
        SurfaceKt.a(null, c.a(8.0f), null, QUIToken.color$default("bg_bottom_light"), ComposableLambdaKt.composableLambda(startRestartGroup, 1344657772, true, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.view.BotListKt$BotList$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
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
                        ComposerKt.traceEventStart(1344657772, intValue, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.view.BotList.<anonymous> (BotList.kt:26)");
                    }
                    AdelieCreativeCenterViewModel adelieCreativeCenterViewModel2 = AdelieCreativeCenterViewModel.this;
                    d dVar2 = dVar;
                    boolean z18 = z17;
                    Function1<Boolean, Unit> function12 = function1;
                    int i16 = i3 >> 9;
                    BotListHeaderKt.BotListHeader(adelieCreativeCenterViewModel2, dVar2, z18, function12, composer3, (i16 & 112) | 8 | (i16 & 896) | (i16 & 7168));
                    composer3.startReplaceableGroup(938649314);
                    if (!z16) {
                        final AdelieCreativeCenterViewModel adelieCreativeCenterViewModel3 = AdelieCreativeCenterViewModel.this;
                        ErrorViewKt.ErrorView(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.view.BotListKt$BotList$1.1
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Unit invoke() {
                                AdelieCreativeCenterViewModel.this.fetchServerData(false, null);
                                return Unit.INSTANCE;
                            }
                        }, composer3, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        composer3.endReplaceableGroup();
                    } else {
                        composer3.endReplaceableGroup();
                        if (AdelieCreativeCenterViewModel.this.robotInfoList._stateList.isEmpty()) {
                            composer3.startReplaceableGroup(938649486);
                            BotEmptyViewKt.BotEmptyView(composer3, 0);
                            composer3.endReplaceableGroup();
                        } else {
                            composer3.startReplaceableGroup(938649530);
                            a aVar2 = aVar;
                            final AdelieCreativeCenterViewModel adelieCreativeCenterViewModel4 = AdelieCreativeCenterViewModel.this;
                            SnapshotStateList<al> snapshotStateList = adelieCreativeCenterViewModel4.robotInfoList._stateList;
                            final e eVar2 = eVar;
                            final Function1<Boolean, Unit> function13 = function1;
                            final int i17 = i3;
                            final MutableState<Set<String>> mutableState2 = mutableState;
                            LazyDslKt.c(aVar2, snapshotStateList, null, ComposableLambdaKt.composableLambda(composer3, -1754059562, true, new Function4<Integer, al, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.view.BotListKt$BotList$1.2
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(4);
                                }

                                @Override // kotlin.jvm.functions.Function4
                                public final Unit invoke(Integer num2, al alVar, Composer composer4, Integer num3) {
                                    AdelieRedDotModule$Companion$RedDotInfo adelieRedDotModule$Companion$RedDotInfo;
                                    int intValue2 = num2.intValue();
                                    al alVar2 = alVar;
                                    Composer composer5 = composer4;
                                    int intValue3 = num3.intValue();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1754059562, intValue3, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.view.BotList.<anonymous>.<anonymous> (BotList.kt:36)");
                                    }
                                    KLog kLog = KLog.INSTANCE;
                                    StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("viewModel.redDotList.valueList.size:");
                                    m3.append(AdelieCreativeCenterViewModel.this.redDotList._stateList.size());
                                    kLog.i("BotList", m3.toString());
                                    Iterator<AdelieRedDotModule$Companion$RedDotInfo> it = AdelieCreativeCenterViewModel.this.redDotList._stateList.iterator();
                                    while (true) {
                                        if (!it.hasNext()) {
                                            adelieRedDotModule$Companion$RedDotInfo = null;
                                            break;
                                        }
                                        adelieRedDotModule$Companion$RedDotInfo = it.next();
                                        if (adelieRedDotModule$Companion$RedDotInfo.robotUin == alVar2.f404159d) {
                                            break;
                                        }
                                    }
                                    BotListCellKt.BotListCell(intValue2, alVar2, eVar2, mutableState2.getValue(), function13, adelieRedDotModule$Companion$RedDotInfo, composer5, (intValue3 & 14) | 4672 | ((i17 >> 6) & 57344), 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    return Unit.INSTANCE;
                                }
                            }), composer3, 3144, 2);
                            if (AdelieCreativeCenterViewModel.this.robotInfoList._stateList.size() > 5) {
                                BotListFooterKt.BotListFooter(AdelieCreativeCenterViewModel.this, composer3, 8);
                            }
                            composer3.endReplaceableGroup();
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }
                return Unit.INSTANCE;
            }
        }), startRestartGroup, 28672, 5);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.view.BotListKt$BotList$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                BotListKt.BotList(a.this, adelieCreativeCenterViewModel, eVar, z16, dVar, z17, function1, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }
}
