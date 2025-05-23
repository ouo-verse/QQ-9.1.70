package com.tencent.qqlive.tvkplayer.vinfo.apiinner;

/* compiled from: P */
/* loaded from: classes23.dex */
public interface ITVKCGIRequestBase {

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public enum RequestState {
        STATE_IDLE,
        STATE_RUNNING,
        STATE_CANCELED
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class TVKCGIElapsedTime {
        public long mStartRequestMs = 0;
        public long mStartHttpRequestMs = 0;
        public long mHttpRequestCostTimeMs = 0;
        public long mStartParseTimeMs = 0;
        public long mParseCostTimeMs = 0;
        public long mTotalRequestCostTimeMs = 0;
    }

    void cancel();

    void execute();
}
