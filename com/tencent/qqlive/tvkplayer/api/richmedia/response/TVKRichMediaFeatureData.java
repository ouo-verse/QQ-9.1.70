package com.tencent.qqlive.tvkplayer.api.richmedia.response;

import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKRichMediaFeatureData {
    private final String mEnv;
    private final String mFeatureType;
    private final ArrayList<TVKRichMediaContent> mRichMediaContentList;
    private final String mVersion;

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class TVKRichMediaContent {
        private final String mContent;
        private final long mEndTimeMs;
        private final long mStartTimeMs;

        public TVKRichMediaContent(long j3, long j16, String str) {
            this.mStartTimeMs = j3;
            this.mEndTimeMs = j16;
            this.mContent = str;
        }

        public String getContent() {
            return this.mContent;
        }

        public long getEndTimeMs() {
            return this.mEndTimeMs;
        }

        public long getStartTimeMs() {
            return this.mStartTimeMs;
        }
    }

    public TVKRichMediaFeatureData(String str, String str2, String str3, ArrayList<TVKRichMediaContent> arrayList) {
        this.mFeatureType = str;
        this.mEnv = str2;
        this.mVersion = str3;
        this.mRichMediaContentList = arrayList;
    }

    public String getEnv() {
        return this.mEnv;
    }

    public String getFeatureType() {
        return this.mFeatureType;
    }

    public List<TVKRichMediaContent> getRichMediaContentList() {
        return this.mRichMediaContentList;
    }

    public String getVersion() {
        return this.mVersion;
    }
}
