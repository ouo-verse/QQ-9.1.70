package com.huawei.hms.hihealth.options;

import android.os.Parcelable;
import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.health.aabq;
import com.huawei.hms.health.aabv;
import com.huawei.hms.health.aabw;
import com.huawei.hms.health.aaby;
import com.huawei.hms.health.aabz;
import com.huawei.hms.hihealth.data.DataType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* compiled from: P */
/* loaded from: classes2.dex */
public class ActivityRecordDeleteOptions extends aabq {
    public static final Parcelable.Creator<ActivityRecordDeleteOptions> CREATOR = new aabq.aab(ActivityRecordDeleteOptions.class);
    private static final TimeUnit TIME_UNIT = TimeUnit.MILLISECONDS;

    @aaby(id = 4)
    private final List<String> mActivityRecordIds;

    @aaby(id = 5)
    private final boolean mDeleteSubData;

    @aaby(id = 3)
    private final long mEndTime;

    @aaby(id = 2)
    private final long mStartTime;

    @aaby(id = 1)
    private final List<DataType> mSubDataTypeList;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class Builder {
        private List<DataType> aab = new ArrayList();
        private long aaba;
        private long aabb;
        private List<String> aabc;
        private boolean aabd;

        public ActivityRecordDeleteOptions build() {
            boolean z16;
            boolean z17 = true;
            if (this.aaba >= 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            Preconditions.checkArgument(z16, "Start time is illegal");
            if (this.aabb < this.aaba) {
                z17 = false;
            }
            Preconditions.checkArgument(z17, "End time is illegal");
            if (aabz.aab(this.aabc).booleanValue() && (this.aaba == 0 || this.aabb == 0)) {
                throw new IllegalStateException("deleteActivityRecord: should input starTime endTime or activityRecordId");
            }
            return new ActivityRecordDeleteOptions(this);
        }

        @Deprecated
        public Builder isDeleteSubData(boolean z16) {
            this.aabd = z16;
            return this;
        }

        public Builder setActivityRecordIds(List<String> list) {
            this.aabc = list;
            return this;
        }

        public Builder setSubDataTypeList(List<DataType> list) {
            this.aab = list;
            this.aabd = true;
            return this;
        }

        public Builder setTimeInterval(long j3, long j16, TimeUnit timeUnit) {
            boolean z16;
            boolean z17 = true;
            if (j3 >= 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            Preconditions.checkArgument(z16, "Start time is illegal");
            if (j16 < j3) {
                z17 = false;
            }
            Preconditions.checkArgument(z17, "End time is illegal");
            this.aaba = ActivityRecordDeleteOptions.TIME_UNIT.convert(j3, timeUnit);
            this.aabb = ActivityRecordDeleteOptions.TIME_UNIT.convert(j16, timeUnit);
            return this;
        }
    }

    ActivityRecordDeleteOptions(Builder builder) {
        this(builder.aab, builder.aaba, builder.aabb, builder.aabc, builder.aabd);
    }

    public List<String> getActivityRecordIds() {
        return this.mActivityRecordIds;
    }

    public long getEndTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.mEndTime, TIME_UNIT);
    }

    public long getStartTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.mStartTime, TIME_UNIT);
    }

    public List<DataType> getSubDataTypeList() {
        return this.mSubDataTypeList;
    }

    @Deprecated
    public boolean isDeleteSubData() {
        if (!this.mDeleteSubData && !aabz.aaba(this.mSubDataTypeList).booleanValue()) {
            return false;
        }
        return true;
    }

    @aabw
    ActivityRecordDeleteOptions(@aabv(id = 1) List<DataType> list, @aabv(id = 2) long j3, @aabv(id = 3) long j16, @aabv(id = 4) List<String> list2, @aabv(id = 5) boolean z16) {
        this.mSubDataTypeList = Collections.unmodifiableList(list);
        this.mStartTime = j3;
        this.mEndTime = j16;
        this.mActivityRecordIds = list2;
        this.mDeleteSubData = z16;
    }
}
