package com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.playground;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.HomepageSource;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.UserDataManager;
import com.tencent.hippykotlin.demo.pages.nearby.base.module.QQNearbyModule;
import com.tencent.hippykotlin.demo.pages.nearby.base.utils.NearbyProUtilsKt;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentsViewModel$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPJumpUtil;
import com.tencent.hippykotlin.demo.pages.nearby.mood_group.NBPMoodGroupViewModel;
import com.tencent.hippykotlin.demo.pages.nearby.mood_group.data.NBPMoodGroupConfig;
import com.tencent.hippykotlin.demo.pages.nearby.mood_group.repo.INBPMoodGroupRepo;
import com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.playground.UserMarkerInfo;
import com.tencent.hippykotlin.demo.pages.nearby.mood_group.vm.NBPMoodGroupUserActionViewModel;
import com.tencent.hippykotlin.demo.pages.nearby.mood_group.vm.result.NBPShootResultViewModel;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.timer.TimerKt;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.layout.BoxKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.b;
import com.tencent.ntcompose.foundation.layout.base.Alignment;
import com.tencent.qqlive.tvkplayer.qqliveasset.player.message.TVKQQLiveAssetPlayerMsg;
import h35.a;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import org.apache.httpcore.message.TokenParser;

/* loaded from: classes31.dex */
public final class PlaygroundViewKt {
    public static final void PlaygroundView(final NBPMoodGroupViewModel nBPMoodGroupViewModel, Composer composer, final int i3) {
        Composer startRestartGroup = composer.startRestartGroup(-861114270);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-861114270, i3, -1, "com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.playground.PlaygroundView (PlaygroundView.kt:16)");
        }
        final NBPMoodGroupConfig nBPMoodGroupConfig = nBPMoodGroupViewModel.config;
        if (nBPMoodGroupConfig == null) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
                return;
            }
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.playground.PlaygroundViewKt$PlaygroundView$config$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Unit invoke(Composer composer2, Integer num) {
                    num.intValue();
                    PlaygroundViewKt.PlaygroundView(NBPMoodGroupViewModel.this, composer2, i3 | 1);
                    return Unit.INSTANCE;
                }
            });
            return;
        }
        final BackgroundInfo bgInfo = nBPMoodGroupViewModel.getBgInfo();
        if (bgInfo == null) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            ScopeUpdateScope endRestartGroup2 = startRestartGroup.endRestartGroup();
            if (endRestartGroup2 == null) {
                return;
            }
            endRestartGroup2.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.playground.PlaygroundViewKt$PlaygroundView$bgInfo$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Unit invoke(Composer composer2, Integer num) {
                    num.intValue();
                    PlaygroundViewKt.PlaygroundView(NBPMoodGroupViewModel.this, composer2, i3 | 1);
                    return Unit.INSTANCE;
                }
            });
            return;
        }
        BoxKt.a(ComposeLayoutPropUpdaterKt.h(i.INSTANCE, 0.0f, 1, null), null, null, ComposableLambdaKt.composableLambda(startRestartGroup, -1005152664, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.playground.PlaygroundViewKt$PlaygroundView$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function3
            public final Unit invoke(b bVar, Composer composer2, Integer num) {
                int i16;
                b bVar2 = bVar;
                Composer composer3 = composer2;
                int intValue = num.intValue();
                if ((intValue & 14) == 0) {
                    i16 = (composer3.changed(bVar2) ? 4 : 2) | intValue;
                } else {
                    i16 = intValue;
                }
                if ((i16 & 91) == 18 && composer3.getSkipping()) {
                    composer3.skipToGroupEnd();
                } else {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1005152664, intValue, -1, "com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.playground.PlaygroundView.<anonymous> (PlaygroundView.kt:24)");
                    }
                    i a16 = bVar2.a(i.INSTANCE, Alignment.CenterEnd);
                    BackgroundInfo backgroundInfo = BackgroundInfo.this;
                    NBPShootResultViewModel resultVM = nBPMoodGroupViewModel.getResultVM();
                    NBPMoodGroupUserActionViewModel userActionVM = nBPMoodGroupViewModel.getUserActionVM();
                    composer3.startReplaceableGroup(1157296644);
                    boolean changed = composer3.changed(userActionVM);
                    Object rememberedValue = composer3.rememberedValue();
                    if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                        rememberedValue = new PlaygroundViewKt$PlaygroundView$1$1$1(userActionVM);
                        composer3.updateRememberedValue(rememberedValue);
                    }
                    composer3.endReplaceableGroup();
                    BackgroundLayerViewKt.BackgroundLayerView(a16, backgroundInfo, resultVM, (Function0) rememberedValue, composer3, TVKQQLiveAssetPlayerMsg.PLAYER_INFO_CGI_REQUEST);
                    final NBPMoodGroupViewModel nBPMoodGroupViewModel2 = nBPMoodGroupViewModel;
                    composer3.startReplaceableGroup(-492369756);
                    Object rememberedValue2 = composer3.rememberedValue();
                    Composer.Companion companion = Composer.INSTANCE;
                    if (rememberedValue2 == companion.getEmpty()) {
                        rememberedValue2 = new Function2<UserMarkerInfo, a, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.playground.PlaygroundViewKt$PlaygroundView$1$onClickHandler$1$1
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public final Unit invoke(UserMarkerInfo userMarkerInfo, a aVar) {
                                UserMarkerInfo userMarkerInfo2 = userMarkerInfo;
                                final NBPMoodGroupUserActionViewModel userActionVM2 = NBPMoodGroupViewModel.this.getUserActionVM();
                                final UserActionMenuInfo userActionMenuInfo = new UserActionMenuInfo(userMarkerInfo2.user.f444488d, aVar, userMarkerInfo2.markerTopCenterPos);
                                userActionVM2.menuInfo$delegate.setValue(userActionMenuInfo);
                                String str = userActionVM2.autoCloseUserActionMenuRef;
                                if (str != null) {
                                    TimerKt.b(str);
                                }
                                userActionVM2.autoCloseUserActionMenuRef = TimerKt.d(3000, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.vm.NBPMoodGroupUserActionViewModel$showMenu$2
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public final Unit invoke() {
                                        if (Intrinsics.areEqual(NBPMoodGroupUserActionViewModel.this.getMenuInfo(), userActionMenuInfo)) {
                                            NBPMoodGroupUserActionViewModel.this.menuInfo$delegate.setValue(null);
                                        }
                                        return Unit.INSTANCE;
                                    }
                                });
                                NBPMoodGroupViewModel.this.getReportVM().dtReportElementImp("em_nearby_hug", null);
                                NBPMoodGroupViewModel.this.getReportVM().dtReportElementImp("em_nearby_data_card", null);
                                return Unit.INSTANCE;
                            }
                        };
                        composer3.updateRememberedValue(rememberedValue2);
                    }
                    composer3.endReplaceableGroup();
                    Function2 function2 = (Function2) rememberedValue2;
                    final NBPMoodGroupViewModel nBPMoodGroupViewModel3 = nBPMoodGroupViewModel;
                    composer3.startReplaceableGroup(-492369756);
                    Object rememberedValue3 = composer3.rememberedValue();
                    if (rememberedValue3 == companion.getEmpty()) {
                        rememberedValue3 = new Function2<UserMarkerInfo, a, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.playground.PlaygroundViewKt$PlaygroundView$1$onReplyHandler$1$1
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public final Unit invoke(UserMarkerInfo userMarkerInfo, a aVar) {
                                NBPMoodGroupConfig.BarrageConfig barrageConfig;
                                List<NBPMoodGroupConfig.BarrageItemConfig> list;
                                final UserMarkerInfo userMarkerInfo2 = userMarkerInfo;
                                final a aVar2 = aVar;
                                NBPMoodGroupViewModel nBPMoodGroupViewModel4 = NBPMoodGroupViewModel.this;
                                nBPMoodGroupViewModel4.getClass();
                                KLog kLog = KLog.INSTANCE;
                                StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("onReply ");
                                m3.append(userMarkerInfo2.user.f444490f);
                                m3.append(TokenParser.SP);
                                NBPFeedCommentsViewModel$$ExternalSyntheticOutline0.m(m3, aVar2.f404270f, kLog, "NBPMoodGroupViewModel");
                                NBPMoodGroupConfig nBPMoodGroupConfig2 = nBPMoodGroupViewModel4.config;
                                if (nBPMoodGroupConfig2 != null && (barrageConfig = nBPMoodGroupConfig2.barrageConfig) != null && (list = barrageConfig.items) != null) {
                                    for (NBPMoodGroupConfig.BarrageItemConfig barrageItemConfig : list) {
                                        if (Intrinsics.areEqual(barrageItemConfig.f114228id, String.valueOf(aVar2.f404271h))) {
                                            NBPMoodGroupConfig.BarrageReplyInteractionConfig barrageReplyInteractionConfig = barrageItemConfig.replyInteraction;
                                            if (barrageReplyInteractionConfig != null) {
                                                ((INBPMoodGroupRepo) nBPMoodGroupViewModel4.repo$delegate.getValue()).interact(userMarkerInfo2.user.f444488d, nBPMoodGroupViewModel4.pageParams.mid, Long.parseLong(barrageReplyInteractionConfig.interactionId), new Function3<k35.i, Integer, String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.NBPMoodGroupViewModel$onReply$1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(3);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function3
                                                    public final Unit invoke(k35.i iVar, Integer num2, String str) {
                                                        k35.i iVar2 = iVar;
                                                        int intValue2 = num2.intValue();
                                                        String str2 = str;
                                                        if (intValue2 == 0 && iVar2 != null) {
                                                            KLog kLog2 = KLog.INSTANCE;
                                                            StringBuilder m16 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("onReply success ");
                                                            m16.append(UserMarkerInfo.this.user.f444490f);
                                                            m16.append(TokenParser.SP);
                                                            NBPFeedCommentsViewModel$$ExternalSyntheticOutline0.m(m16, aVar2.f404270f, kLog2, "NBPMoodGroupViewModel");
                                                        } else {
                                                            NearbyProUtilsKt.toastAPIErrorMsg$default(intValue2, str2);
                                                        }
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                nBPMoodGroupViewModel4.barrageLoopManger.onNewBarrage(BarrageDisplayInfoKt.createLocalBarrage$default(Long.parseLong(barrageItemConfig.f114228id), userMarkerInfo2.user.f444488d, barrageReplyInteractionConfig.clickMsg), barrageReplyInteractionConfig.replyBubble);
                                            }
                                        }
                                    }
                                    throw new NoSuchElementException("Collection contains no element matching the predicate.");
                                }
                                NBPMoodGroupViewModel.this.getReportVM().dtReportElementClick("em_nearby_emotion_bubble", null);
                                return Unit.INSTANCE;
                            }
                        };
                        composer3.updateRememberedValue(rememberedValue3);
                    }
                    composer3.endReplaceableGroup();
                    Function2 function22 = (Function2) rememberedValue3;
                    final NBPMoodGroupViewModel nBPMoodGroupViewModel4 = nBPMoodGroupViewModel;
                    composer3.startReplaceableGroup(-492369756);
                    Object rememberedValue4 = composer3.rememberedValue();
                    if (rememberedValue4 == companion.getEmpty()) {
                        rememberedValue4 = new Function2<UserActionMenuInfo, NBPMoodGroupConfig.UserActionMenuInteraction, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.playground.PlaygroundViewKt$PlaygroundView$1$onInteractionHandler$1$1
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public final Unit invoke(UserActionMenuInfo userActionMenuInfo, NBPMoodGroupConfig.UserActionMenuInteraction userActionMenuInteraction) {
                                Unit unit;
                                Object obj;
                                final String str;
                                UserActionMenuInfo userActionMenuInfo2 = userActionMenuInfo;
                                NBPMoodGroupConfig.UserActionMenuInteraction userActionMenuInteraction2 = userActionMenuInteraction;
                                final NBPMoodGroupUserActionViewModel userActionVM2 = NBPMoodGroupViewModel.this.getUserActionVM();
                                userActionVM2.getClass();
                                final long j3 = userActionMenuInfo2.tid;
                                a aVar = userActionMenuInfo2.barrage;
                                KLog.INSTANCE.d("NBPMoodGroupViewModel", "onInteraction tid=" + j3 + " barrage=" + aVar);
                                NBPMoodGroupConfig.BarrageConfig barrageConfig = userActionVM2.barrageConfig;
                                if (barrageConfig != null) {
                                    Iterator<T> it = barrageConfig.items.iterator();
                                    while (true) {
                                        if (!it.hasNext()) {
                                            obj = null;
                                            break;
                                        }
                                        obj = it.next();
                                        if (Intrinsics.areEqual(((NBPMoodGroupConfig.BarrageItemConfig) obj).f114228id, String.valueOf(aVar != null ? Long.valueOf(aVar.f404271h) : null))) {
                                            break;
                                        }
                                    }
                                    NBPMoodGroupConfig.BarrageItemConfig barrageItemConfig = (NBPMoodGroupConfig.BarrageItemConfig) obj;
                                    if (barrageItemConfig == null || (str = barrageItemConfig.aioMsg) == null) {
                                        str = barrageConfig.defaultAioMsg;
                                    }
                                    if (str.length() > 0) {
                                        QQNearbyModule.Companion.getInstance().sendAIOMessage(String.valueOf(userActionMenuInfo2.tid), str, new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.vm.NBPMoodGroupUserActionViewModel$onInteraction$1$1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(e eVar) {
                                                KLog kLog = KLog.INSTANCE;
                                                StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("sendAIOMessage tid=");
                                                m3.append(j3);
                                                m3.append(" barrage=");
                                                NBPFeedCommentsViewModel$$ExternalSyntheticOutline0.m(m3, str, kLog, "NBPMoodGroupViewModel");
                                                return Unit.INSTANCE;
                                            }
                                        });
                                    } else {
                                        KLog.INSTANCE.d("NBPMoodGroupViewModel", "sendAIOMessage fail msgText is null");
                                    }
                                    unit = Unit.INSTANCE;
                                } else {
                                    unit = null;
                                }
                                if (unit == null) {
                                    KLog.INSTANCE.d("NBPMoodGroupViewModel", "sendAIOMessage fail barrageConfig is null");
                                }
                                UserActionMenuInfo menuInfo = userActionVM2.getMenuInfo();
                                if (menuInfo != null) {
                                    userActionVM2.tipsInfo$delegate.setValue(new UserActionTipsInfo(menuInfo.tid, userActionMenuInteraction2.icon.src, userActionMenuInteraction2.clickMsg, menuInfo.userTopCenter));
                                    String str2 = userActionVM2.autoCloseUserActionTipsRef;
                                    if (str2 != null) {
                                        TimerKt.b(str2);
                                    }
                                    userActionVM2.autoCloseUserActionTipsRef = TimerKt.d(1000, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.vm.NBPMoodGroupUserActionViewModel$showTips$2
                                        {
                                            super(0);
                                        }

                                        @Override // kotlin.jvm.functions.Function0
                                        public final Unit invoke() {
                                            NBPMoodGroupUserActionViewModel.this.tipsInfo$delegate.setValue(null);
                                            return Unit.INSTANCE;
                                        }
                                    });
                                }
                                userActionVM2.menuInfo$delegate.setValue(null);
                                NBPMoodGroupViewModel.this.getReportVM().dtReportElementClick("em_nearby_hug", null);
                                return Unit.INSTANCE;
                            }
                        };
                        composer3.updateRememberedValue(rememberedValue4);
                    }
                    composer3.endReplaceableGroup();
                    Function2 function23 = (Function2) rememberedValue4;
                    final NBPMoodGroupViewModel nBPMoodGroupViewModel5 = nBPMoodGroupViewModel;
                    composer3.startReplaceableGroup(-492369756);
                    Object rememberedValue5 = composer3.rememberedValue();
                    if (rememberedValue5 == companion.getEmpty()) {
                        rememberedValue5 = new Function1<String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.playground.PlaygroundViewKt$PlaygroundView$1$onOpenProfileHandler$1$1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(String str) {
                                Long longOrNull;
                                String str2 = str;
                                NBPMoodGroupViewModel.this.getUserActionVM().menuInfo$delegate.setValue(null);
                                UserDataManager userDataManager = UserDataManager.INSTANCE;
                                longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(str2);
                                NBPJumpUtil.jumpPersonaPage$default(2, str2, userDataManager.isHostTid(longOrNull), false, HomepageSource.MOOD_GROUP_PLAYGROUND, null, 32);
                                NBPMoodGroupViewModel.this.getReportVM().dtReportElementClick("em_nearby_data_card", null);
                                return Unit.INSTANCE;
                            }
                        };
                        composer3.updateRememberedValue(rememberedValue5);
                    }
                    composer3.endReplaceableGroup();
                    MarkersLayerViewKt.MarkersLayerView(nBPMoodGroupViewModel.userMarkers, function2, function22, composer3, 432);
                    UserActionMenuViewKt.UserActionMenuView(nBPMoodGroupViewModel.getUserActionVM().getMenuInfo(), nBPMoodGroupConfig.userActionMenuConfig, function23, (Function1) rememberedValue5, composer3, 3456);
                    UserActionTipsViewKt.UserActionTipsView((UserActionTipsInfo) nBPMoodGroupViewModel.getUserActionVM().tipsInfo$delegate.getValue(), nBPMoodGroupConfig.userActionMenuConfig, composer3, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                return Unit.INSTANCE;
            }
        }), startRestartGroup, 3080, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup3 = startRestartGroup.endRestartGroup();
        if (endRestartGroup3 == null) {
            return;
        }
        endRestartGroup3.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.playground.PlaygroundViewKt$PlaygroundView$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                PlaygroundViewKt.PlaygroundView(NBPMoodGroupViewModel.this, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }
}
