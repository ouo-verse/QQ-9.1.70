package com.tencent.tav.coremedia;

import android.support.annotation.NonNull;

/* compiled from: P */
/* loaded from: classes26.dex */
public class CMTimeRange implements Cloneable {
    public static CMTimeRange CMTimeRangeInvalid;

    @NonNull
    private CMTime duration;
    private CMTime end;

    @NonNull
    private CMTime start;

    static {
        CMTime cMTime = CMTime.CMTimeZero;
        CMTimeRangeInvalid = new CMTimeRange(cMTime, cMTime);
    }

    public CMTimeRange(@NonNull CMTime cMTime, @NonNull CMTime cMTime2) {
        Utils.checkNotNull(cMTime);
        Utils.checkNotNull(cMTime2);
        this.start = cMTime;
        this.duration = cMTime2;
        this.end = cMTime.add(cMTime2);
    }

    public static CMTimeRange fromMs(long j3, long j16) {
        return new CMTimeRange(CMTime.fromMs(j3), CMTime.fromMs(j16));
    }

    public static CMTimeRange fromSeconds(float f16, float f17) {
        return new CMTimeRange(CMTime.fromSeconds(f16), CMTime.fromSeconds(f17));
    }

    public static CMTimeRange fromUs(long j3, long j16) {
        return new CMTimeRange(CMTime.fromUs(j3), CMTime.fromUs(j16));
    }

    public static CMTimeRange getIntersection(CMTimeRange cMTimeRange, CMTimeRange cMTimeRange2) {
        if (cMTimeRange != null && cMTimeRange2 != null) {
            CMTimeRange m260clone = cMTimeRange.m260clone();
            CMTimeRange m260clone2 = cMTimeRange2.m260clone();
            if (m260clone.getStartUs() > m260clone2.getStartUs()) {
                m260clone2 = m260clone;
                m260clone = m260clone2;
            }
            if (m260clone.getEndUs() > m260clone2.getStartUs() && m260clone.getEndUs() < m260clone2.getEndUs()) {
                return new CMTimeRange(m260clone2.getStart(), m260clone.getEnd().sub(m260clone2.getStart()));
            }
            if (m260clone.getEndUs() >= m260clone2.getEndUs()) {
                return m260clone2;
            }
            if (m260clone.getEndUs() < m260clone2.getStartUs()) {
                return CMTimeRangeInvalid;
            }
            return CMTimeRangeInvalid;
        }
        return CMTimeRangeInvalid;
    }

    public static CMTimeRange[] getUnions(CMTimeRange cMTimeRange, CMTimeRange cMTimeRange2) {
        CMTimeRange[] cMTimeRangeArr = new CMTimeRange[2];
        if (cMTimeRange == null) {
            cMTimeRangeArr[0] = cMTimeRange2;
        } else if (cMTimeRange2 == null) {
            cMTimeRangeArr[0] = cMTimeRange;
        } else {
            CMTimeRange m260clone = cMTimeRange.m260clone();
            CMTimeRange m260clone2 = cMTimeRange2.m260clone();
            if (m260clone.getStartUs() > m260clone2.getStartUs()) {
                m260clone2 = m260clone;
                m260clone = m260clone2;
            }
            cMTimeRangeArr[0] = m260clone;
            if (m260clone.getEndUs() >= m260clone2.getStartUs() && m260clone.getEndUs() < m260clone2.getEndUs()) {
                cMTimeRangeArr[1] = new CMTimeRange(m260clone.getEnd(), m260clone2.getEnd().sub(m260clone.getEnd()));
            } else if (m260clone.getEndUs() >= m260clone2.getEndUs()) {
                cMTimeRangeArr[1] = null;
            } else if (m260clone.getEndUs() < m260clone2.getStartUs()) {
                cMTimeRangeArr[1] = m260clone2;
            }
        }
        return cMTimeRangeArr;
    }

    public boolean containsTime(@NonNull CMTime cMTime) {
        Utils.checkNotNull(cMTime);
        if (getStartUs() <= cMTime.getTimeUs() && getEndUs() > cMTime.getTimeUs()) {
            return true;
        }
        return false;
    }

    public boolean containsTimeRange(@NonNull CMTimeRange cMTimeRange) {
        Utils.checkNotNull(cMTimeRange);
        if (getStartUs() <= cMTimeRange.getStartUs() && getEndUs() >= cMTimeRange.getEndUs()) {
            return true;
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof CMTimeRange)) {
            return false;
        }
        CMTimeRange cMTimeRange = (CMTimeRange) obj;
        if (!this.start.equals(cMTimeRange.start) || !this.duration.equals(cMTimeRange.duration)) {
            return false;
        }
        return true;
    }

    @NonNull
    public CMTime getDuration() {
        return this.duration;
    }

    public long getDurationUs() {
        return this.duration.getTimeUs();
    }

    public CMTime getEnd() {
        return this.end;
    }

    public long getEndUs() {
        return getStartUs() + getDurationUs();
    }

    @NonNull
    public CMTime getStart() {
        return this.start;
    }

    public long getStartUs() {
        return this.start.getTimeUs();
    }

    public boolean isLegal() {
        if (getStartUs() >= 0 && getDurationUs() > 0) {
            return true;
        }
        return false;
    }

    public void setDuration(@NonNull CMTime cMTime) {
        Utils.checkNotNull(cMTime);
        this.duration = cMTime;
        this.end = this.start.add(cMTime);
    }

    public void setStart(@NonNull CMTime cMTime) {
        Utils.checkNotNull(cMTime);
        this.start = cMTime;
        this.end = cMTime.add(this.duration);
    }

    public CMTimeRange[] split(float f16) {
        if (f16 >= 0.0f && f16 <= 1.0f) {
            CMTimeRange cMTimeRange = new CMTimeRange(this.start, getDuration().multi(f16));
            return new CMTimeRange[]{cMTimeRange, new CMTimeRange(cMTimeRange.getEnd(), getDuration().multi(1.0f - f16))};
        }
        return null;
    }

    public String toSimpleString() {
        return "CMTimeRange{startUs=" + this.start.getTimeUs() + ", durationUs=" + this.duration.getTimeUs() + '}';
    }

    public String toString() {
        return "CMTimeRange{start=" + this.start + ", duration=" + this.duration + ", end=" + this.end + '}';
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public CMTimeRange m260clone() {
        return new CMTimeRange(this.start, this.duration);
    }
}
