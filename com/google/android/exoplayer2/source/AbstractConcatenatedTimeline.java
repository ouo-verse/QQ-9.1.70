package com.google.android.exoplayer2.source;

import android.util.Pair;
import com.google.android.exoplayer2.Timeline;

/* compiled from: P */
/* loaded from: classes2.dex */
abstract class AbstractConcatenatedTimeline extends Timeline {
    private final int childCount;
    private final boolean isAtomic;
    private final ShuffleOrder shuffleOrder;

    public AbstractConcatenatedTimeline(boolean z16, ShuffleOrder shuffleOrder) {
        this.isAtomic = z16;
        this.shuffleOrder = shuffleOrder;
        this.childCount = shuffleOrder.getLength();
    }

    private int getNextChildIndex(int i3, boolean z16) {
        if (z16) {
            return this.shuffleOrder.getNextIndex(i3);
        }
        if (i3 < this.childCount - 1) {
            return i3 + 1;
        }
        return -1;
    }

    private int getPreviousChildIndex(int i3, boolean z16) {
        if (z16) {
            return this.shuffleOrder.getPreviousIndex(i3);
        }
        if (i3 > 0) {
            return i3 - 1;
        }
        return -1;
    }

    protected abstract int getChildIndexByChildUid(Object obj);

    protected abstract int getChildIndexByPeriodIndex(int i3);

    protected abstract int getChildIndexByWindowIndex(int i3);

    protected abstract Object getChildUidByChildIndex(int i3);

    protected abstract int getFirstPeriodIndexByChildIndex(int i3);

    @Override // com.google.android.exoplayer2.Timeline
    public int getFirstWindowIndex(boolean z16) {
        if (this.childCount == 0) {
            return -1;
        }
        int i3 = 0;
        if (this.isAtomic) {
            z16 = false;
        }
        if (z16) {
            i3 = this.shuffleOrder.getFirstIndex();
        }
        while (getTimelineByChildIndex(i3).isEmpty()) {
            i3 = getNextChildIndex(i3, z16);
            if (i3 == -1) {
                return -1;
            }
        }
        return getFirstWindowIndexByChildIndex(i3) + getTimelineByChildIndex(i3).getFirstWindowIndex(z16);
    }

    protected abstract int getFirstWindowIndexByChildIndex(int i3);

    @Override // com.google.android.exoplayer2.Timeline
    public final int getIndexOfPeriod(Object obj) {
        int indexOfPeriod;
        if (!(obj instanceof Pair)) {
            return -1;
        }
        Pair pair = (Pair) obj;
        Object obj2 = pair.first;
        Object obj3 = pair.second;
        int childIndexByChildUid = getChildIndexByChildUid(obj2);
        if (childIndexByChildUid == -1 || (indexOfPeriod = getTimelineByChildIndex(childIndexByChildUid).getIndexOfPeriod(obj3)) == -1) {
            return -1;
        }
        return getFirstPeriodIndexByChildIndex(childIndexByChildUid) + indexOfPeriod;
    }

    @Override // com.google.android.exoplayer2.Timeline
    public int getLastWindowIndex(boolean z16) {
        int i3;
        int i16 = this.childCount;
        if (i16 == 0) {
            return -1;
        }
        if (this.isAtomic) {
            z16 = false;
        }
        if (z16) {
            i3 = this.shuffleOrder.getLastIndex();
        } else {
            i3 = i16 - 1;
        }
        while (getTimelineByChildIndex(i3).isEmpty()) {
            i3 = getPreviousChildIndex(i3, z16);
            if (i3 == -1) {
                return -1;
            }
        }
        return getFirstWindowIndexByChildIndex(i3) + getTimelineByChildIndex(i3).getLastWindowIndex(z16);
    }

    @Override // com.google.android.exoplayer2.Timeline
    public int getNextWindowIndex(int i3, int i16, boolean z16) {
        int i17 = 0;
        if (this.isAtomic) {
            if (i16 == 1) {
                i16 = 2;
            }
            z16 = false;
        }
        int childIndexByWindowIndex = getChildIndexByWindowIndex(i3);
        int firstWindowIndexByChildIndex = getFirstWindowIndexByChildIndex(childIndexByWindowIndex);
        Timeline timelineByChildIndex = getTimelineByChildIndex(childIndexByWindowIndex);
        int i18 = i3 - firstWindowIndexByChildIndex;
        if (i16 != 2) {
            i17 = i16;
        }
        int nextWindowIndex = timelineByChildIndex.getNextWindowIndex(i18, i17, z16);
        if (nextWindowIndex != -1) {
            return firstWindowIndexByChildIndex + nextWindowIndex;
        }
        int nextChildIndex = getNextChildIndex(childIndexByWindowIndex, z16);
        while (nextChildIndex != -1 && getTimelineByChildIndex(nextChildIndex).isEmpty()) {
            nextChildIndex = getNextChildIndex(nextChildIndex, z16);
        }
        if (nextChildIndex != -1) {
            return getFirstWindowIndexByChildIndex(nextChildIndex) + getTimelineByChildIndex(nextChildIndex).getFirstWindowIndex(z16);
        }
        if (i16 != 2) {
            return -1;
        }
        return getFirstWindowIndex(z16);
    }

    @Override // com.google.android.exoplayer2.Timeline
    public final Timeline.Period getPeriod(int i3, Timeline.Period period, boolean z16) {
        int childIndexByPeriodIndex = getChildIndexByPeriodIndex(i3);
        int firstWindowIndexByChildIndex = getFirstWindowIndexByChildIndex(childIndexByPeriodIndex);
        getTimelineByChildIndex(childIndexByPeriodIndex).getPeriod(i3 - getFirstPeriodIndexByChildIndex(childIndexByPeriodIndex), period, z16);
        period.windowIndex += firstWindowIndexByChildIndex;
        if (z16) {
            period.uid = Pair.create(getChildUidByChildIndex(childIndexByPeriodIndex), period.uid);
        }
        return period;
    }

    @Override // com.google.android.exoplayer2.Timeline
    public int getPreviousWindowIndex(int i3, int i16, boolean z16) {
        int i17 = 0;
        if (this.isAtomic) {
            if (i16 == 1) {
                i16 = 2;
            }
            z16 = false;
        }
        int childIndexByWindowIndex = getChildIndexByWindowIndex(i3);
        int firstWindowIndexByChildIndex = getFirstWindowIndexByChildIndex(childIndexByWindowIndex);
        Timeline timelineByChildIndex = getTimelineByChildIndex(childIndexByWindowIndex);
        int i18 = i3 - firstWindowIndexByChildIndex;
        if (i16 != 2) {
            i17 = i16;
        }
        int previousWindowIndex = timelineByChildIndex.getPreviousWindowIndex(i18, i17, z16);
        if (previousWindowIndex != -1) {
            return firstWindowIndexByChildIndex + previousWindowIndex;
        }
        int previousChildIndex = getPreviousChildIndex(childIndexByWindowIndex, z16);
        while (previousChildIndex != -1 && getTimelineByChildIndex(previousChildIndex).isEmpty()) {
            previousChildIndex = getPreviousChildIndex(previousChildIndex, z16);
        }
        if (previousChildIndex != -1) {
            return getFirstWindowIndexByChildIndex(previousChildIndex) + getTimelineByChildIndex(previousChildIndex).getLastWindowIndex(z16);
        }
        if (i16 != 2) {
            return -1;
        }
        return getLastWindowIndex(z16);
    }

    protected abstract Timeline getTimelineByChildIndex(int i3);

    @Override // com.google.android.exoplayer2.Timeline
    public final Timeline.Window getWindow(int i3, Timeline.Window window, boolean z16, long j3) {
        int childIndexByWindowIndex = getChildIndexByWindowIndex(i3);
        int firstWindowIndexByChildIndex = getFirstWindowIndexByChildIndex(childIndexByWindowIndex);
        int firstPeriodIndexByChildIndex = getFirstPeriodIndexByChildIndex(childIndexByWindowIndex);
        getTimelineByChildIndex(childIndexByWindowIndex).getWindow(i3 - firstWindowIndexByChildIndex, window, z16, j3);
        window.firstPeriodIndex += firstPeriodIndexByChildIndex;
        window.lastPeriodIndex += firstPeriodIndexByChildIndex;
        return window;
    }
}
