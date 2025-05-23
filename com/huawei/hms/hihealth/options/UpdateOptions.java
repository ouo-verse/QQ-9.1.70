package com.huawei.hms.hihealth.options;

import android.os.Parcelable;
import com.huawei.hms.common.internal.Objects;
import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.health.aabq;
import com.huawei.hms.health.aabv;
import com.huawei.hms.health.aabw;
import com.huawei.hms.health.aaby;
import com.huawei.hms.hihealth.data.SamplePoint;
import com.huawei.hms.hihealth.data.SampleSet;
import java.util.concurrent.TimeUnit;

/* compiled from: P */
/* loaded from: classes2.dex */
public class UpdateOptions extends aabq {
    public static final Parcelable.Creator<UpdateOptions> CREATOR = new aabq.aab(UpdateOptions.class);

    @aaby(id = 3)
    private final long mEndTime;

    @aaby(id = 1)
    private final SampleSet mSampleSet;

    @aaby(id = 2)
    private final long mStartTime;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class Builder {
        private SampleSet aab = null;
        private long aaba = 0;
        private long aabb = 0;

        public UpdateOptions build() {
            boolean z16;
            boolean z17;
            boolean z18;
            boolean z19;
            boolean z26;
            Preconditions.checkNotNull(this.aab, "SampleSet should not be null");
            if (this.aaba != 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            Preconditions.checkState(z16, "StartTime should not be zero");
            if (this.aabb != 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            Preconditions.checkState(z17, "EndTime should not be zero");
            for (SamplePoint samplePoint : this.aab.getSamplePoints()) {
                TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                long startTime = samplePoint.getStartTime(timeUnit);
                long endTime = samplePoint.getEndTime(timeUnit);
                if (startTime <= endTime) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                Preconditions.checkState(z18, "SamplePoint's start time and end time should not be outside the UpdateOptions time range");
                if ((startTime != 0 && startTime < this.aaba) || (startTime != 0 && startTime > this.aabb)) {
                    z19 = false;
                } else {
                    z19 = true;
                }
                Preconditions.checkState(z19, "SamplePoint's start time and end time should not be outside the UpdateOptions time range");
                if (endTime <= this.aabb && endTime >= this.aaba) {
                    z26 = true;
                } else {
                    z26 = false;
                }
                Preconditions.checkState(z26, "SamplePoint's start time and end time should not be outside the UpdateOptions time range");
            }
            return new UpdateOptions(this);
        }

        public Builder setSampleSet(SampleSet sampleSet) {
            Preconditions.checkNotNull(sampleSet, "Cannot set a null sample set");
            this.aab = sampleSet;
            return this;
        }

        public Builder setTimeInterval(long j3, long j16, TimeUnit timeUnit) {
            boolean z16;
            boolean z17;
            boolean z18;
            boolean z19 = true;
            if (j3 > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            Preconditions.checkArgument(z16, "Start time is illegal");
            if (j16 >= j3) {
                z17 = true;
            } else {
                z17 = false;
            }
            Preconditions.checkArgument(z17, "End time is illegal");
            this.aaba = timeUnit.toMillis(j3);
            this.aabb = timeUnit.toMillis(j16);
            if (this.aaba > 1388505600000L) {
                z18 = true;
            } else {
                z18 = false;
            }
            Preconditions.checkState(z18, "Start time must be later than default start time: 20140101 00:00:000");
            if (this.aabb < this.aaba) {
                z19 = false;
            }
            Preconditions.checkState(z19, "the start time must be less than the end time");
            return this;
        }
    }

    @aabw
    UpdateOptions(@aabv(id = 1) SampleSet sampleSet, @aabv(id = 2) long j3, @aabv(id = 3) long j16) {
        this.mSampleSet = sampleSet;
        this.mStartTime = j3;
        this.mEndTime = j16;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof UpdateOptions)) {
            return false;
        }
        UpdateOptions updateOptions = (UpdateOptions) obj;
        if (Objects.equal(this.mSampleSet, updateOptions.mSampleSet) && this.mStartTime == updateOptions.mStartTime && this.mEndTime == updateOptions.mEndTime) {
            return true;
        }
        return false;
    }

    public final long getEndTime() {
        return this.mEndTime;
    }

    public SampleSet getSampleSet() {
        return this.mSampleSet;
    }

    public final long getStartTime() {
        return this.mStartTime;
    }

    public int hashCode() {
        return Objects.hashCode(this.mSampleSet, Long.valueOf(this.mStartTime), Long.valueOf(this.mEndTime));
    }

    public String toString() {
        return Objects.toStringHelper(this).add("sampleSet", this.mSampleSet).add("startTime", Long.valueOf(this.mStartTime)).add("endTime", Long.valueOf(this.mEndTime)).toString();
    }

    UpdateOptions(Builder builder) {
        this(builder.aab, builder.aaba, builder.aabb);
    }

    public long getEndTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.mEndTime, TimeUnit.MILLISECONDS);
    }

    public long getStartTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.mStartTime, TimeUnit.MILLISECONDS);
    }
}
