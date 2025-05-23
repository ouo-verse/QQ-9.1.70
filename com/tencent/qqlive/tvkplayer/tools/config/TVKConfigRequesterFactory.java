package com.tencent.qqlive.tvkplayer.tools.config;

/* compiled from: P */
/* loaded from: classes23.dex */
class TVKConfigRequesterFactory {
    TVKConfigRequesterFactory() {
    }

    public static ITVKConfigRequester createTabConfigRequester() {
        return new TVKTabConfigRequester();
    }

    public static ITVKConfigRequester createWujiConfigRequester() {
        return new TVKWujiConfigRequester();
    }
}
