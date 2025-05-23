package com.tencent.qqlive.tvkplayer.api;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKTrackInfo {
    public static final int MEDIA_TRACK_TYPE_AUDIO = 2;
    public static final int MEDIA_TRACK_TYPE_SUBTITLE = 3;
    public static final int MEDIA_TRACK_TYPE_UNKNOWN = 0;
    public static final int MEDIA_TRACK_TYPE_VIDEO = 1;
    private static final AtomicLong sUniqueId = new AtomicLong(1);
    private boolean mIsSelected;
    private String mTrackName;
    private int mTrackType = 0;
    private final String mTrackUniqueId = String.valueOf(sUniqueId.incrementAndGet());

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes23.dex */
    public @interface TVKTrackType {
        public static final int MEDIA_TRACK_TYPE_AUDIO = 2;
        public static final int MEDIA_TRACK_TYPE_SUBTITLE = 3;
        public static final int MEDIA_TRACK_TYPE_UNKNOWN = 0;
        public static final int MEDIA_TRACK_TYPE_VIDEO = 1;
    }

    public String getTrackName() {
        return this.mTrackName;
    }

    public int getTrackType() {
        return this.mTrackType;
    }

    public String getTrackUniqueId() {
        return "" + this.mTrackName + "_" + this.mTrackUniqueId;
    }

    public boolean isSelected() {
        return this.mIsSelected;
    }

    public void setSelected(boolean z16) {
        this.mIsSelected = z16;
    }

    public void setTrackName(String str) {
        this.mTrackName = str;
    }

    public void setTrackType(int i3) {
        this.mTrackType = i3;
    }

    public String toString() {
        return "TVKTrackInfo{trackType=" + this.mTrackType + ", name=" + this.mTrackName + ", uniqueId=" + getTrackUniqueId() + ", isSelected=" + this.mIsSelected + '}';
    }
}
