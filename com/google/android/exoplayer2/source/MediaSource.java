package com.google.android.exoplayer2.source;

import android.support.annotation.Nullable;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.upstream.Allocator;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes2.dex */
public interface MediaSource {
    public static final String MEDIA_SOURCE_REUSED_ERROR_MESSAGE = "MediaSource instances are not allowed to be reused.";

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public interface Listener {
        void onSourceInfoRefreshed(MediaSource mediaSource, Timeline timeline, @Nullable Object obj);
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class MediaPeriodId {
        public final int adGroupIndex;
        public final int adIndexInAdGroup;
        public final int periodIndex;
        public final long windowSequenceNumber;

        public MediaPeriodId(int i3) {
            this(i3, -1L);
        }

        public MediaPeriodId copyWithPeriodIndex(int i3) {
            if (this.periodIndex == i3) {
                return this;
            }
            return new MediaPeriodId(i3, this.adGroupIndex, this.adIndexInAdGroup, this.windowSequenceNumber);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || MediaPeriodId.class != obj.getClass()) {
                return false;
            }
            MediaPeriodId mediaPeriodId = (MediaPeriodId) obj;
            if (this.periodIndex == mediaPeriodId.periodIndex && this.adGroupIndex == mediaPeriodId.adGroupIndex && this.adIndexInAdGroup == mediaPeriodId.adIndexInAdGroup && this.windowSequenceNumber == mediaPeriodId.windowSequenceNumber) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return ((((((527 + this.periodIndex) * 31) + this.adGroupIndex) * 31) + this.adIndexInAdGroup) * 31) + ((int) this.windowSequenceNumber);
        }

        public boolean isAd() {
            if (this.adGroupIndex != -1) {
                return true;
            }
            return false;
        }

        public MediaPeriodId(int i3, long j3) {
            this(i3, -1, -1, j3);
        }

        public MediaPeriodId(int i3, int i16, int i17, long j3) {
            this.periodIndex = i3;
            this.adGroupIndex = i16;
            this.adIndexInAdGroup = i17;
            this.windowSequenceNumber = j3;
        }
    }

    MediaPeriod createPeriod(MediaPeriodId mediaPeriodId, Allocator allocator);

    void maybeThrowSourceInfoRefreshError() throws IOException;

    void prepareSource(ExoPlayer exoPlayer, boolean z16, Listener listener);

    void releasePeriod(MediaPeriod mediaPeriod);

    void releaseSource();
}
