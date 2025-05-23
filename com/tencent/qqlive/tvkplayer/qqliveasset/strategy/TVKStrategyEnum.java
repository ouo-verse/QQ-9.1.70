package com.tencent.qqlive.tvkplayer.qqliveasset.strategy;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKStrategyEnum {

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public enum PlayerStrategy {
        PLAYER_STRATEGY_AUTO,
        PLAYER_STRATEGY_SELF_ONLY,
        PLAYER_STRATEGY_SYSTEM_ONLY
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public enum ProxyStrategy {
        PROXY_STRATEGY_AUTO,
        PROXY_STRATEGY_MUST,
        PROXY_STRATEGY_MUST_NONE
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public class SecurityStrategy {
        public static final int SECURITY_STRATEGY_BY_VINFO_ENCRYPTION = 1;
        public static final int SECURITY_STRATEGY_OFF = 0;
        public static final int SECURITY_STRATEGY_ON = 2;

        public SecurityStrategy() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public enum VideoDecoderStrategy {
        VIDEO_DECODER_STRATEGY_AUTO,
        VIDEO_DECODER_STRATEGY_MEDIACODEC_ONLY,
        VIDEO_DECODER_STRATEGY_MEDIACODEC_FIRST,
        VIDEO_DECODER_STRATEGY_SOFT_ONLY,
        VIDEO_DECODER_STRATEGY_SOFT_FIRST
    }
}
