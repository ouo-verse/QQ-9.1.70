package com.tencent.thumbplayer.core.codec.tmediacodec.statistics;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes26.dex */
public class MediaCodecStatistics {
    private boolean mIsReuse;
    private boolean mIsReuseHasSet;
    private boolean mIsVideo;
    private long mLastTimeInMs;
    private boolean mReuseEnable;
    private final Map<String, Long> mStatisticsMap = new HashMap();
    private String mCacheResultData = "";

    public MediaCodecStatistics(boolean z16) {
        this.mIsVideo = z16;
    }

    private final void setIsReuse(boolean z16) {
        this.mIsReuse = z16;
        this.mIsReuseHasSet = true;
    }

    private final void setReuseEnable(boolean z16) {
        this.mReuseEnable = z16;
    }

    public final void configCodecEnd(boolean z16) {
        setIsReuse(z16);
        this.mStatisticsMap.put("configCodec", Long.valueOf(System.currentTimeMillis() - this.mLastTimeInMs));
    }

    public final void configCodecStart(boolean z16) {
        setReuseEnable(z16);
        this.mLastTimeInMs = System.currentTimeMillis();
    }

    public final void createByCodecEnd() {
        this.mStatisticsMap.put("createCodec", Long.valueOf(System.currentTimeMillis() - this.mLastTimeInMs));
    }

    public final void createByCodecStart() {
        this.mCacheResultData = "";
        this.mStatisticsMap.clear();
        this.mLastTimeInMs = System.currentTimeMillis();
    }

    @NonNull
    public final String getData() {
        if (TextUtils.isEmpty(this.mCacheResultData)) {
            StringBuilder sb5 = new StringBuilder("{");
            sb5.append("\"isVideo\":");
            sb5.append(this.mIsVideo + " ,");
            if (this.mIsReuseHasSet) {
                sb5.append("\"isReuse\":");
                sb5.append(this.mIsReuse + " ,");
            }
            sb5.append("\"reuseEnable\":");
            sb5.append(this.mReuseEnable + " ,");
            long j3 = 0;
            for (Map.Entry<String, Long> entry : this.mStatisticsMap.entrySet()) {
                if (entry != null) {
                    j3 += entry.getValue().longValue();
                }
                sb5.append("\"" + ((Object) entry.getKey()) + "\":");
                StringBuilder sb6 = new StringBuilder();
                sb6.append(entry.getValue().longValue());
                sb6.append(" ,");
                sb5.append(sb6.toString());
            }
            sb5.append("\"totalCodec\":");
            sb5.append(j3);
            sb5.append("}");
            this.mCacheResultData = sb5.toString();
        }
        return this.mCacheResultData;
    }

    public final void startCodecEnd() {
        this.mStatisticsMap.put("startCodec", Long.valueOf(System.currentTimeMillis() - this.mLastTimeInMs));
    }

    public final void startCodecStart() {
        this.mLastTimeInMs = System.currentTimeMillis();
    }
}
