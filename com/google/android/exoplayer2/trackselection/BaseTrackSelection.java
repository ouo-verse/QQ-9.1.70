package com.google.android.exoplayer2.trackselection;

import android.os.SystemClock;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.chunk.MediaChunk;
import com.google.android.exoplayer2.util.Assertions;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes2.dex */
public abstract class BaseTrackSelection implements TrackSelection {
    private final long[] blacklistUntilTimes;
    private final Format[] formats;
    protected final TrackGroup group;
    private int hashCode;
    protected final int length;
    protected final int[] tracks;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    private static final class DecreasingBandwidthComparator implements Comparator<Format> {
        DecreasingBandwidthComparator() {
        }

        @Override // java.util.Comparator
        public int compare(Format format, Format format2) {
            return format2.bitrate - format.bitrate;
        }
    }

    public BaseTrackSelection(TrackGroup trackGroup, int... iArr) {
        boolean z16;
        int i3 = 0;
        if (iArr.length > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        Assertions.checkState(z16);
        this.group = (TrackGroup) Assertions.checkNotNull(trackGroup);
        int length = iArr.length;
        this.length = length;
        this.formats = new Format[length];
        for (int i16 = 0; i16 < iArr.length; i16++) {
            this.formats[i16] = trackGroup.getFormat(iArr[i16]);
        }
        Arrays.sort(this.formats, new DecreasingBandwidthComparator());
        this.tracks = new int[this.length];
        while (true) {
            int i17 = this.length;
            if (i3 < i17) {
                this.tracks[i3] = trackGroup.indexOf(this.formats[i3]);
                i3++;
            } else {
                this.blacklistUntilTimes = new long[i17];
                return;
            }
        }
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelection
    public final boolean blacklist(int i3, long j3) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        boolean isBlacklisted = isBlacklisted(i3, elapsedRealtime);
        for (int i16 = 0; i16 < this.length && !isBlacklisted; i16++) {
            if (i16 != i3 && !isBlacklisted(i16, elapsedRealtime)) {
                isBlacklisted = true;
            } else {
                isBlacklisted = false;
            }
        }
        if (!isBlacklisted) {
            return false;
        }
        long[] jArr = this.blacklistUntilTimes;
        jArr[i3] = Math.max(jArr[i3], elapsedRealtime + j3);
        return true;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        BaseTrackSelection baseTrackSelection = (BaseTrackSelection) obj;
        if (this.group == baseTrackSelection.group && Arrays.equals(this.tracks, baseTrackSelection.tracks)) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelection
    public int evaluateQueueSize(long j3, List<? extends MediaChunk> list) {
        return list.size();
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelection
    public final Format getFormat(int i3) {
        return this.formats[i3];
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelection
    public final int getIndexInTrackGroup(int i3) {
        return this.tracks[i3];
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelection
    public final Format getSelectedFormat() {
        return this.formats[getSelectedIndex()];
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelection
    public final int getSelectedIndexInTrackGroup() {
        return this.tracks[getSelectedIndex()];
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelection
    public final TrackGroup getTrackGroup() {
        return this.group;
    }

    public int hashCode() {
        if (this.hashCode == 0) {
            this.hashCode = (System.identityHashCode(this.group) * 31) + Arrays.hashCode(this.tracks);
        }
        return this.hashCode;
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelection
    public final int indexOf(Format format) {
        for (int i3 = 0; i3 < this.length; i3++) {
            if (this.formats[i3] == format) {
                return i3;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean isBlacklisted(int i3, long j3) {
        if (this.blacklistUntilTimes[i3] > j3) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelection
    public final int length() {
        return this.tracks.length;
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelection
    public final int indexOf(int i3) {
        for (int i16 = 0; i16 < this.length; i16++) {
            if (this.tracks[i16] == i3) {
                return i16;
            }
        }
        return -1;
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelection
    public void disable() {
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelection
    public void enable() {
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelection
    public void onPlaybackSpeed(float f16) {
    }
}
