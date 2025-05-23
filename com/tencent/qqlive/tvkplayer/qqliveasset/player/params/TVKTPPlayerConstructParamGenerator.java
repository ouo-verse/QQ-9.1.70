package com.tencent.qqlive.tvkplayer.qqliveasset.player.params;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.qqlive.tvkplayer.qqliveasset.context.TVKQQLiveAssetPlayerContext;
import com.tencent.qqlive.tvkplayer.qqliveasset.strategy.TVKStrategyEnum;
import com.tencent.thumbplayer.api.optionalparam.TPOptionalParam;
import com.tencent.thumbplayer.api.player.TPPlayerConstructParams;

/* loaded from: classes23.dex */
public class TVKTPPlayerConstructParamGenerator {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.tencent.qqlive.tvkplayer.qqliveasset.player.params.TVKTPPlayerConstructParamGenerator$1, reason: invalid class name */
    /* loaded from: classes23.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$tencent$qqlive$tvkplayer$qqliveasset$strategy$TVKStrategyEnum$PlayerStrategy;

        static {
            int[] iArr = new int[TVKStrategyEnum.PlayerStrategy.values().length];
            $SwitchMap$com$tencent$qqlive$tvkplayer$qqliveasset$strategy$TVKStrategyEnum$PlayerStrategy = iArr;
            try {
                iArr[TVKStrategyEnum.PlayerStrategy.PLAYER_STRATEGY_SYSTEM_ONLY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$tencent$qqlive$tvkplayer$qqliveasset$strategy$TVKStrategyEnum$PlayerStrategy[TVKStrategyEnum.PlayerStrategy.PLAYER_STRATEGY_SELF_ONLY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$tencent$qqlive$tvkplayer$qqliveasset$strategy$TVKStrategyEnum$PlayerStrategy[TVKStrategyEnum.PlayerStrategy.PLAYER_STRATEGY_AUTO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    @Nullable
    public static TPPlayerConstructParams generatePlayerConstructParam(@NonNull TVKQQLiveAssetPlayerContext tVKQQLiveAssetPlayerContext) {
        int[] playerCoreTypes = getPlayerCoreTypes(tVKQQLiveAssetPlayerContext.getPlayerAndDecoderChooser().choosePlayerStrategy());
        if (playerCoreTypes == null) {
            return null;
        }
        TPPlayerConstructParams tPPlayerConstructParams = new TPPlayerConstructParams();
        tPPlayerConstructParams.addOptionalParam(TPOptionalParam.buildQueueInt(TPPlayerConstructParams.CONSTRUCT_ID_QUEUE_INT_CORE_TYPE, playerCoreTypes));
        return tPPlayerConstructParams;
    }

    private static int[] getPlayerCoreTypes(TVKStrategyEnum.PlayerStrategy playerStrategy) {
        int i3 = AnonymousClass1.$SwitchMap$com$tencent$qqlive$tvkplayer$qqliveasset$strategy$TVKStrategyEnum$PlayerStrategy[playerStrategy.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                return null;
            }
            return new int[]{2};
        }
        return new int[]{1};
    }
}
