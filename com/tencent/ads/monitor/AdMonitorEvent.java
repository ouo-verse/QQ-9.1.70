package com.tencent.ads.monitor;

/* compiled from: P */
/* loaded from: classes37.dex */
public interface AdMonitorEvent {

    /* compiled from: P */
    /* loaded from: classes37.dex */
    public enum SkipCause {
        USER_SKIP,
        USER_RETURN,
        PLAY_FAILED,
        PLAY_STUCK,
        FORCE_SKIP,
        NO_AD,
        OTHER_REASON;

        /* renamed from: values, reason: to resolve conflict with enum method */
        public static SkipCause[] valuesCustom() {
            SkipCause[] valuesCustom = values();
            int length = valuesCustom.length;
            SkipCause[] skipCauseArr = new SkipCause[length];
            System.arraycopy(valuesCustom, 0, skipCauseArr, 0, length);
            return skipCauseArr;
        }
    }

    void onAdClick(String str);

    void onAdItemPlayFinish(String str);

    void onAdItemWillPlay(String str);

    void onAdPlayFinish();

    void onAdPlaySkip(SkipCause skipCause);

    void onAdPlaying(long j3);

    void onAdRequestFinish(String str);

    void onAdRequestStart();

    void onException(Throwable th5, String str);
}
