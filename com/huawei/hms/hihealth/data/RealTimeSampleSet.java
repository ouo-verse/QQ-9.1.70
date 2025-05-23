package com.huawei.hms.hihealth.data;

import android.os.Parcelable;
import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.health.aabq;
import com.huawei.hms.health.aabv;
import com.huawei.hms.health.aabw;
import com.huawei.hms.health.aaby;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes2.dex */
public class RealTimeSampleSet extends aabq {
    public static final Parcelable.Creator<RealTimeSampleSet> CREATOR = new aabq.aab(RealTimeSampleSet.class);

    @aaby(id = 2)
    private int mDuration;

    @aaby(id = 3)
    private List<RealTimeSamplePoint> mRealTimeSamplePoints;

    @aaby(id = 1)
    private long mStartTime;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class Builder {
        private int mDuration;
        private List<RealTimeSamplePoint> mRealTimeSamplePoints = new ArrayList();
        private long mStartTime;

        public Builder addRealTimeSamplePoint(RealTimeSamplePoint realTimeSamplePoint) {
            this.mRealTimeSamplePoints.add(realTimeSamplePoint);
            return this;
        }

        public Builder addRealTimeSamplePointList(Iterable<RealTimeSamplePoint> iterable) {
            Iterator<RealTimeSamplePoint> it = iterable.iterator();
            while (it.hasNext()) {
                this.mRealTimeSamplePoints.add(it.next());
            }
            return this;
        }

        public RealTimeSampleSet build() {
            return new RealTimeSampleSet(this.mStartTime, this.mDuration, this.mRealTimeSamplePoints);
        }

        public Builder setDuration(int i3) {
            this.mDuration = i3;
            return this;
        }

        public Builder setStartTime(long j3) {
            this.mStartTime = j3;
            return this;
        }
    }

    public RealTimeSampleSet() {
    }

    @aabw
    RealTimeSampleSet(@aabv(id = 1) long j3, @aabv(id = 2) int i3, @aabv(id = 3) List<RealTimeSamplePoint> list) {
        this.mStartTime = j3;
        this.mDuration = i3;
        this.mRealTimeSamplePoints = list;
    }

    public double getDoubleValue(DataType dataType, Field field) {
        boolean z16;
        if (dataType != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        Preconditions.checkArgument(z16, "The dataType can not be null!");
        for (RealTimeSamplePoint realTimeSamplePoint : this.mRealTimeSamplePoints) {
            if (dataType.getName().equals(realTimeSamplePoint.getDataType().getName())) {
                return realTimeSamplePoint.getFieldValue(field).asDoubleValue();
            }
        }
        throw new IllegalArgumentException("The activityType does not support querying this dataType");
    }

    public int getDuration() {
        return this.mDuration;
    }

    public int getIntValue(DataType dataType, Field field) {
        boolean z16;
        if (dataType != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        Preconditions.checkArgument(z16, "The dataType can not be null!");
        for (RealTimeSamplePoint realTimeSamplePoint : this.mRealTimeSamplePoints) {
            if (dataType.getName().equals(realTimeSamplePoint.getDataType().getName())) {
                return realTimeSamplePoint.getFieldValue(field).asIntValue();
            }
        }
        throw new IllegalArgumentException("The activityType does not support querying this dataType");
    }

    public RealTimeSamplePoint getRealTimeSamplePoint(DataType dataType) {
        boolean z16;
        if (dataType != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        Preconditions.checkArgument(z16, "The dataType can not be null!");
        for (RealTimeSamplePoint realTimeSamplePoint : this.mRealTimeSamplePoints) {
            if (dataType.getName().equals(realTimeSamplePoint.getDataType().getName())) {
                return realTimeSamplePoint;
            }
        }
        throw new IllegalArgumentException("The activityType does not support querying this dataType");
    }

    public List<RealTimeSamplePoint> getRealTimeSamplePoints() {
        return this.mRealTimeSamplePoints;
    }

    public long getStartTime() {
        return this.mStartTime;
    }

    public String toString() {
        StringBuilder aab2 = com.huawei.hms.health.aab.aab("SampleSet{");
        StringBuilder aab3 = com.huawei.hms.health.aab.aab("StartTime=");
        aab3.append(this.mStartTime);
        aab2.append(aab3.toString());
        StringBuilder aab4 = com.huawei.hms.health.aab.aab(", Duration=");
        aab4.append(this.mDuration);
        aab2.append(aab4.toString());
        StringBuilder aab5 = com.huawei.hms.health.aab.aab(", RealTimeSamplePoints=");
        aab5.append(this.mRealTimeSamplePoints);
        aab5.append('}');
        aab2.append(aab5.toString());
        return aab2.toString();
    }
}
