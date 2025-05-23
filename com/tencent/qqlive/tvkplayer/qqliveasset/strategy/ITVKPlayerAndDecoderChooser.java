package com.tencent.qqlive.tvkplayer.qqliveasset.strategy;

import com.tencent.qqlive.tvkplayer.qqliveasset.strategy.TVKStrategyEnum;

/* loaded from: classes23.dex */
public interface ITVKPlayerAndDecoderChooser {
    TVKStrategyEnum.PlayerStrategy choosePlayerStrategy();

    TVKStrategyEnum.VideoDecoderStrategy chooseVideoDecoderStrategy(TVKStrategyEnum.PlayerStrategy playerStrategy);
}
