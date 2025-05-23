package com.tencent.thumbplayer.report.reportv2;

import androidx.annotation.Nullable;
import com.tencent.thumbplayer.api.common.TPTrackInfo;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes26.dex */
public class TPVodReportParamRecord extends TPBaseReportParamRecord {
    public long mBufferingStartOccurElapsedTimeMs;
    public int mBufferingTotalCount;
    public int mBufferingTotalDurationMs;
    public long mPauseStartOccurElapsedTimeMs;
    public long mPauseTotalDurationMs;
    public long mPlayerFirstStartOccurElapsedTimeMs;
    public long mPlayerStartOccurElapsedTimeMs;
    public long mPrepareEndOccurElapsedTimeMs;
    public long mRetentionDurationMs;
    public int mSeekBufferingTotalCount;
    public int mSeekBufferingTotalDurationMs;
    public long mSeekStartOccurElapsedTimeMs;
    public int mSeekTotalCount;
    public float mPlaySpeed = 1.0f;
    public Map<Long, TPSelectTrackInfo> mSelectTrackInfoList = new HashMap();

    /* loaded from: classes26.dex */
    public static class TPSelectTrackInfo {
        public int mSelectTrackId;
        public long mSelectTrackStartOccurElapsedTimeMs;

        @Nullable
        public TPTrackInfo mTrackInfo;
    }
}
