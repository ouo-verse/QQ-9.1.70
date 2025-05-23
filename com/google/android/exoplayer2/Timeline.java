package com.google.android.exoplayer2;

import android.util.Pair;
import com.google.android.exoplayer2.source.ads.AdPlaybackState;
import com.google.android.exoplayer2.util.Assertions;

/* compiled from: P */
/* loaded from: classes2.dex */
public abstract class Timeline {
    public static final Timeline EMPTY = new Timeline() { // from class: com.google.android.exoplayer2.Timeline.1
        @Override // com.google.android.exoplayer2.Timeline
        public int getIndexOfPeriod(Object obj) {
            return -1;
        }

        @Override // com.google.android.exoplayer2.Timeline
        public Period getPeriod(int i3, Period period, boolean z16) {
            throw new IndexOutOfBoundsException();
        }

        @Override // com.google.android.exoplayer2.Timeline
        public int getPeriodCount() {
            return 0;
        }

        @Override // com.google.android.exoplayer2.Timeline
        public Window getWindow(int i3, Window window, boolean z16, long j3) {
            throw new IndexOutOfBoundsException();
        }

        @Override // com.google.android.exoplayer2.Timeline
        public int getWindowCount() {
            return 0;
        }
    };

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class Period {
        private AdPlaybackState adPlaybackState;
        public long durationUs;

        /* renamed from: id, reason: collision with root package name */
        public Object f32938id;
        private long positionInWindowUs;
        public Object uid;
        public int windowIndex;

        public int getAdCountInAdGroup(int i3) {
            return this.adPlaybackState.adGroups[i3].count;
        }

        public long getAdDurationUs(int i3, int i16) {
            AdPlaybackState.AdGroup adGroup = this.adPlaybackState.adGroups[i3];
            if (adGroup.count != -1) {
                return adGroup.durationsUs[i16];
            }
            return -9223372036854775807L;
        }

        public int getAdGroupCount() {
            return this.adPlaybackState.adGroupCount;
        }

        public int getAdGroupIndexAfterPositionUs(long j3) {
            return this.adPlaybackState.getAdGroupIndexAfterPositionUs(j3);
        }

        public int getAdGroupIndexForPositionUs(long j3) {
            return this.adPlaybackState.getAdGroupIndexForPositionUs(j3);
        }

        public long getAdGroupTimeUs(int i3) {
            return this.adPlaybackState.adGroupTimesUs[i3];
        }

        public long getAdResumePositionUs() {
            return this.adPlaybackState.adResumePositionUs;
        }

        public long getDurationMs() {
            return C.usToMs(this.durationUs);
        }

        public long getDurationUs() {
            return this.durationUs;
        }

        public int getFirstAdIndexToPlay(int i3) {
            return this.adPlaybackState.adGroups[i3].getFirstAdIndexToPlay();
        }

        public int getNextAdIndexToPlay(int i3, int i16) {
            return this.adPlaybackState.adGroups[i3].getNextAdIndexToPlay(i16);
        }

        public long getPositionInWindowMs() {
            return C.usToMs(this.positionInWindowUs);
        }

        public long getPositionInWindowUs() {
            return this.positionInWindowUs;
        }

        public boolean hasPlayedAdGroup(int i3) {
            return !this.adPlaybackState.adGroups[i3].hasUnplayedAds();
        }

        public boolean isAdAvailable(int i3, int i16) {
            AdPlaybackState.AdGroup adGroup = this.adPlaybackState.adGroups[i3];
            if (adGroup.count != -1 && adGroup.states[i16] != 0) {
                return true;
            }
            return false;
        }

        public Period set(Object obj, Object obj2, int i3, long j3, long j16) {
            return set(obj, obj2, i3, j3, j16, AdPlaybackState.NONE);
        }

        public Period set(Object obj, Object obj2, int i3, long j3, long j16, AdPlaybackState adPlaybackState) {
            this.f32938id = obj;
            this.uid = obj2;
            this.windowIndex = i3;
            this.durationUs = j3;
            this.positionInWindowUs = j16;
            this.adPlaybackState = adPlaybackState;
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class Window {
        public long defaultPositionUs;
        public long durationUs;
        public int firstPeriodIndex;

        /* renamed from: id, reason: collision with root package name */
        public Object f32939id;
        public boolean isDynamic;
        public boolean isSeekable;
        public int lastPeriodIndex;
        public long positionInFirstPeriodUs;
        public long presentationStartTimeMs;
        public long windowStartTimeMs;

        public long getDefaultPositionMs() {
            return C.usToMs(this.defaultPositionUs);
        }

        public long getDefaultPositionUs() {
            return this.defaultPositionUs;
        }

        public long getDurationMs() {
            return C.usToMs(this.durationUs);
        }

        public long getDurationUs() {
            return this.durationUs;
        }

        public long getPositionInFirstPeriodMs() {
            return C.usToMs(this.positionInFirstPeriodUs);
        }

        public long getPositionInFirstPeriodUs() {
            return this.positionInFirstPeriodUs;
        }

        public Window set(Object obj, long j3, long j16, boolean z16, boolean z17, long j17, long j18, int i3, int i16, long j19) {
            this.f32939id = obj;
            this.presentationStartTimeMs = j3;
            this.windowStartTimeMs = j16;
            this.isSeekable = z16;
            this.isDynamic = z17;
            this.defaultPositionUs = j17;
            this.durationUs = j18;
            this.firstPeriodIndex = i3;
            this.lastPeriodIndex = i16;
            this.positionInFirstPeriodUs = j19;
            return this;
        }
    }

    public int getFirstWindowIndex(boolean z16) {
        if (isEmpty()) {
            return -1;
        }
        return 0;
    }

    public abstract int getIndexOfPeriod(Object obj);

    public int getLastWindowIndex(boolean z16) {
        if (isEmpty()) {
            return -1;
        }
        return getWindowCount() - 1;
    }

    public final int getNextPeriodIndex(int i3, Period period, Window window, int i16, boolean z16) {
        int i17 = getPeriod(i3, period).windowIndex;
        if (getWindow(i17, window).lastPeriodIndex == i3) {
            int nextWindowIndex = getNextWindowIndex(i17, i16, z16);
            if (nextWindowIndex == -1) {
                return -1;
            }
            return getWindow(nextWindowIndex, window).firstPeriodIndex;
        }
        return i3 + 1;
    }

    public int getNextWindowIndex(int i3, int i16, boolean z16) {
        if (i16 != 0) {
            if (i16 != 1) {
                if (i16 == 2) {
                    if (i3 == getLastWindowIndex(z16)) {
                        return getFirstWindowIndex(z16);
                    }
                    return i3 + 1;
                }
                throw new IllegalStateException();
            }
            return i3;
        }
        if (i3 == getLastWindowIndex(z16)) {
            return -1;
        }
        return i3 + 1;
    }

    public final Period getPeriod(int i3, Period period) {
        return getPeriod(i3, period, false);
    }

    public abstract Period getPeriod(int i3, Period period, boolean z16);

    public abstract int getPeriodCount();

    public final Pair<Integer, Long> getPeriodPosition(Window window, Period period, int i3, long j3) {
        return getPeriodPosition(window, period, i3, j3, 0L);
    }

    public int getPreviousWindowIndex(int i3, int i16, boolean z16) {
        if (i16 != 0) {
            if (i16 != 1) {
                if (i16 == 2) {
                    if (i3 == getFirstWindowIndex(z16)) {
                        return getLastWindowIndex(z16);
                    }
                    return i3 - 1;
                }
                throw new IllegalStateException();
            }
            return i3;
        }
        if (i3 == getFirstWindowIndex(z16)) {
            return -1;
        }
        return i3 - 1;
    }

    public final Window getWindow(int i3, Window window) {
        return getWindow(i3, window, false);
    }

    public abstract Window getWindow(int i3, Window window, boolean z16, long j3);

    public abstract int getWindowCount();

    public final boolean isEmpty() {
        if (getWindowCount() == 0) {
            return true;
        }
        return false;
    }

    public final boolean isLastPeriod(int i3, Period period, Window window, int i16, boolean z16) {
        if (getNextPeriodIndex(i3, period, window, i16, z16) == -1) {
            return true;
        }
        return false;
    }

    public final Pair<Integer, Long> getPeriodPosition(Window window, Period period, int i3, long j3, long j16) {
        Assertions.checkIndex(i3, 0, getWindowCount());
        getWindow(i3, window, false, j16);
        if (j3 == -9223372036854775807L) {
            j3 = window.getDefaultPositionUs();
            if (j3 == -9223372036854775807L) {
                return null;
            }
        }
        int i16 = window.firstPeriodIndex;
        long positionInFirstPeriodUs = window.getPositionInFirstPeriodUs() + j3;
        long durationUs = getPeriod(i16, period).getDurationUs();
        while (durationUs != -9223372036854775807L && positionInFirstPeriodUs >= durationUs && i16 < window.lastPeriodIndex) {
            positionInFirstPeriodUs -= durationUs;
            i16++;
            durationUs = getPeriod(i16, period).getDurationUs();
        }
        return Pair.create(Integer.valueOf(i16), Long.valueOf(positionInFirstPeriodUs));
    }

    public final Window getWindow(int i3, Window window, boolean z16) {
        return getWindow(i3, window, z16, 0L);
    }
}
