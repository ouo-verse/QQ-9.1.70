package com.google.android.exoplayer2.source.hls.playlist;

import android.support.annotation.NonNull;
import com.google.android.exoplayer2.drm.DrmInitData;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public final class HlsMediaPlaylist extends HlsPlaylist {
    public static final int PLAYLIST_TYPE_EVENT = 2;
    public static final int PLAYLIST_TYPE_UNKNOWN = 0;
    public static final int PLAYLIST_TYPE_VOD = 1;
    public final int discontinuitySequence;
    public final DrmInitData drmInitData;
    public final long durationUs;
    public final boolean hasDiscontinuitySequence;
    public final boolean hasEndTag;
    public final boolean hasIndependentSegmentsTag;
    public final boolean hasProgramDateTime;
    public final Segment initializationSegment;
    public final long mediaSequence;
    public final int playlistType;
    public final List<Segment> segments;
    public final long startOffsetUs;
    public final long startTimeUs;
    public final long targetDurationUs;
    public final int version;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes2.dex */
    public @interface PlaylistType {
    }

    /* loaded from: classes2.dex */
    public static final class Segment implements Comparable<Long> {
        public final long byterangeLength;
        public final long byterangeOffset;
        public final long durationUs;
        public final String encryptionIV;
        public final String fullSegmentEncryptionKeyUri;
        public final boolean hasGapTag;
        public final int relativeDiscontinuitySequence;
        public final long relativeStartTimeUs;
        public final String url;

        public Segment(String str, long j3, long j16) {
            this(str, 0L, -1, -9223372036854775807L, null, null, j3, j16, false);
        }

        public Segment(String str, long j3, int i3, long j16, String str2, String str3, long j17, long j18, boolean z16) {
            this.url = str;
            this.durationUs = j3;
            this.relativeDiscontinuitySequence = i3;
            this.relativeStartTimeUs = j16;
            this.fullSegmentEncryptionKeyUri = str2;
            this.encryptionIV = str3;
            this.byterangeOffset = j17;
            this.byterangeLength = j18;
            this.hasGapTag = z16;
        }

        @Override // java.lang.Comparable
        public int compareTo(@NonNull Long l3) {
            if (this.relativeStartTimeUs > l3.longValue()) {
                return 1;
            }
            return this.relativeStartTimeUs < l3.longValue() ? -1 : 0;
        }
    }

    public HlsMediaPlaylist(int i3, String str, List<String> list, long j3, long j16, boolean z16, int i16, long j17, int i17, long j18, boolean z17, boolean z18, boolean z19, DrmInitData drmInitData, Segment segment, List<Segment> list2) {
        super(str, list);
        long j19;
        this.playlistType = i3;
        this.startTimeUs = j16;
        this.hasDiscontinuitySequence = z16;
        this.discontinuitySequence = i16;
        this.mediaSequence = j17;
        this.version = i17;
        this.targetDurationUs = j18;
        this.hasIndependentSegmentsTag = z17;
        this.hasEndTag = z18;
        this.hasProgramDateTime = z19;
        this.drmInitData = drmInitData;
        this.initializationSegment = segment;
        this.segments = Collections.unmodifiableList(list2);
        if (!list2.isEmpty()) {
            Segment segment2 = list2.get(list2.size() - 1);
            this.durationUs = segment2.relativeStartTimeUs + segment2.durationUs;
        } else {
            this.durationUs = 0L;
        }
        if (j3 == -9223372036854775807L) {
            j19 = -9223372036854775807L;
        } else {
            j19 = j3 >= 0 ? j3 : this.durationUs + j3;
        }
        this.startOffsetUs = j19;
    }

    public HlsMediaPlaylist copyWith(long j3, int i3) {
        return new HlsMediaPlaylist(this.playlistType, this.baseUri, this.tags, this.startOffsetUs, j3, true, i3, this.mediaSequence, this.version, this.targetDurationUs, this.hasIndependentSegmentsTag, this.hasEndTag, this.hasProgramDateTime, this.drmInitData, this.initializationSegment, this.segments);
    }

    public HlsMediaPlaylist copyWithEndTag() {
        if (this.hasEndTag) {
            return this;
        }
        return new HlsMediaPlaylist(this.playlistType, this.baseUri, this.tags, this.startOffsetUs, this.startTimeUs, this.hasDiscontinuitySequence, this.discontinuitySequence, this.mediaSequence, this.version, this.targetDurationUs, this.hasIndependentSegmentsTag, true, this.hasProgramDateTime, this.drmInitData, this.initializationSegment, this.segments);
    }

    public long getEndTimeUs() {
        return this.startTimeUs + this.durationUs;
    }

    public boolean isNewerThan(HlsMediaPlaylist hlsMediaPlaylist) {
        if (hlsMediaPlaylist == null) {
            return true;
        }
        long j3 = this.mediaSequence;
        long j16 = hlsMediaPlaylist.mediaSequence;
        if (j3 > j16) {
            return true;
        }
        if (j3 < j16) {
            return false;
        }
        int size = this.segments.size();
        int size2 = hlsMediaPlaylist.segments.size();
        if (size > size2) {
            return true;
        }
        if (size == size2 && this.hasEndTag && !hlsMediaPlaylist.hasEndTag) {
            return true;
        }
        return false;
    }
}
