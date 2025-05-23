package com.tencent.ad.tangram.protocol;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class indicator {
    public static final int DO_NOTHING = 0;
    public static final int HIDE_AD = 3;
    public static final int OPEN_JUMP_URL = 6;
    public static final int kAdInfo = 10;
    public static final int kDisplay = 13;
    public static final int kFeedsExposureCtrl = 14;
    public static final int kFeedsNoveltyCtrl = 15;
    public static final int kFeedsTimeIntervalCtrl = 20;
    public static final int kFillAd = 4;
    public static final int kFillDisplayResponse = 11;
    public static final int kForceNoAdForAntispamControl = 21;
    public static final int kForceNoAdForOverDailyQuota = 18;
    public static final int kForceNoAdForOverHourlyQuota = 19;
    public static final int kFrequenceLimitCtrl = 17;
    public static final int kGooglepayAdvertiserCtrl = 22;
    public static final int kIndex = 2;
    public static final int kMixerFilter = 9;
    public static final int kMixerNetworkFailed = 12;
    public static final int kNegativeFeedbackCtrl = 23;
    public static final int kOperationFlexbility = 1;
    public static final int kRerankingDocWash = 6;
    public static final int kRerankingInput = 7;
    public static final int kRerankingOutput = 8;
    public static final int kScoring = 3;
    public static final int kSkipRetrieval = 16;
    public static final int kSunfishNetworkFailed = 5;
    public static final int kUnknown = 0;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static final class AdCount {
        public int index = 0;
        public int scoring = 0;
        public int fillad = 0;
        public int reranking_docwash = 0;
        public int reranking_input = 0;
        public int reranking_output = 0;
        public int mixer_filter = 0;
        public int adinfo = 0;
        public int mixer = 0;
        public int display = 0;
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static final class NoAdIndicator {
        public int partition_timestamp = 0;
        public long placement_id = 0;
        public int no_ad_reason = 0;
        public AdCount ad_count = new AdCount();
    }

    indicator() {
    }
}
