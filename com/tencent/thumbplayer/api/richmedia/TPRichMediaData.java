package com.tencent.thumbplayer.api.richmedia;

import com.tencent.thumbplayer.api.common.TPTimeRange;
import java.util.ArrayList;

/* loaded from: classes26.dex */
public class TPRichMediaData {
    private ArrayList<TPRichMediaContent> mContents = new ArrayList<>();
    private String mEnv;
    private String mFeatureType;
    private String mVersion;

    /* loaded from: classes26.dex */
    public static class TPRichMediaContent {
        private String mContent;
        private TPTimeRange mTimeRange;

        public String getContent() {
            return this.mContent;
        }

        public TPTimeRange getTimeRange() {
            return this.mTimeRange;
        }
    }

    public ArrayList<TPRichMediaContent> getContentList() {
        return this.mContents;
    }

    public String getEnv() {
        return this.mEnv;
    }

    public String getFeatureType() {
        return this.mFeatureType;
    }

    public String getVersion() {
        return this.mVersion;
    }
}
