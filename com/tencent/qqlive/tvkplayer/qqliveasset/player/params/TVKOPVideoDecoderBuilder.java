package com.tencent.qqlive.tvkplayer.qqliveasset.player.params;

import androidx.annotation.NonNull;
import com.tencent.qqlive.tvkplayer.qqliveasset.context.TVKQQLiveAssetPlayerContext;
import com.tencent.qqlive.tvkplayer.qqliveasset.strategy.ITVKPlayerAndDecoderChooser;
import com.tencent.qqlive.tvkplayer.qqliveasset.strategy.TVKStrategyEnum;
import com.tencent.thumbplayer.api.optionalparam.TPOptionalID;
import com.tencent.thumbplayer.api.optionalparam.TPOptionalParam;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes23.dex */
class TVKOPVideoDecoderBuilder implements ITVKOptionalParamBuilder {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.tencent.qqlive.tvkplayer.qqliveasset.player.params.TVKOPVideoDecoderBuilder$1, reason: invalid class name */
    /* loaded from: classes23.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$tencent$qqlive$tvkplayer$qqliveasset$strategy$TVKStrategyEnum$VideoDecoderStrategy;

        static {
            int[] iArr = new int[TVKStrategyEnum.VideoDecoderStrategy.values().length];
            $SwitchMap$com$tencent$qqlive$tvkplayer$qqliveasset$strategy$TVKStrategyEnum$VideoDecoderStrategy = iArr;
            try {
                iArr[TVKStrategyEnum.VideoDecoderStrategy.VIDEO_DECODER_STRATEGY_MEDIACODEC_FIRST.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$tencent$qqlive$tvkplayer$qqliveasset$strategy$TVKStrategyEnum$VideoDecoderStrategy[TVKStrategyEnum.VideoDecoderStrategy.VIDEO_DECODER_STRATEGY_MEDIACODEC_ONLY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$tencent$qqlive$tvkplayer$qqliveasset$strategy$TVKStrategyEnum$VideoDecoderStrategy[TVKStrategyEnum.VideoDecoderStrategy.VIDEO_DECODER_STRATEGY_SOFT_FIRST.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$tencent$qqlive$tvkplayer$qqliveasset$strategy$TVKStrategyEnum$VideoDecoderStrategy[TVKStrategyEnum.VideoDecoderStrategy.VIDEO_DECODER_STRATEGY_SOFT_ONLY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$tencent$qqlive$tvkplayer$qqliveasset$strategy$TVKStrategyEnum$VideoDecoderStrategy[TVKStrategyEnum.VideoDecoderStrategy.VIDEO_DECODER_STRATEGY_AUTO.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    private int[] getVideoDecoderTypes(TVKStrategyEnum.VideoDecoderStrategy videoDecoderStrategy) {
        int i3 = AnonymousClass1.$SwitchMap$com$tencent$qqlive$tvkplayer$qqliveasset$strategy$TVKStrategyEnum$VideoDecoderStrategy[videoDecoderStrategy.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        return null;
                    }
                    return new int[]{101};
                }
                return new int[]{101, 102};
            }
            return new int[]{102};
        }
        return new int[]{102, 101};
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.player.params.ITVKOptionalParamBuilder
    @NonNull
    public List<TPOptionalParam<?>> buildOptionalParamList(@NonNull TVKQQLiveAssetPlayerContext tVKQQLiveAssetPlayerContext, boolean z16) {
        ITVKPlayerAndDecoderChooser playerAndDecoderChooser = tVKQQLiveAssetPlayerContext.getPlayerAndDecoderChooser();
        int[] videoDecoderTypes = getVideoDecoderTypes(playerAndDecoderChooser.chooseVideoDecoderStrategy(playerAndDecoderChooser.choosePlayerStrategy()));
        ArrayList arrayList = new ArrayList();
        if (videoDecoderTypes != null) {
            arrayList.add(TPOptionalParam.buildQueueInt(TPOptionalID.OPTIONAL_ID_BEFORE_QUEUE_INT_VIDEO_DECODER_TYPE, videoDecoderTypes));
        }
        return arrayList;
    }
}
