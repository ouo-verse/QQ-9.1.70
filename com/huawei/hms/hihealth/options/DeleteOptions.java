package com.huawei.hms.hihealth.options;

import android.os.Parcelable;
import com.huawei.hms.common.internal.Objects;
import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.health.aabq;
import com.huawei.hms.health.aabv;
import com.huawei.hms.health.aabw;
import com.huawei.hms.health.aaby;
import com.huawei.hms.health.aacu;
import com.huawei.hms.hihealth.data.ActivityRecord;
import com.huawei.hms.hihealth.data.DataCollector;
import com.huawei.hms.hihealth.data.DataType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* compiled from: P */
/* loaded from: classes2.dex */
public class DeleteOptions extends aabq {
    public static final Parcelable.Creator<DeleteOptions> CREATOR = new aabq.aab(DeleteOptions.class);

    @aaby(id = 6)
    private final List<ActivityRecord> mActivityRecords;

    @aaby(id = 2)
    private final List<DataCollector> mDataCollectors;

    @aaby(id = 1)
    private final List<DataType> mDataTypes;

    @aaby(id = 4)
    private final long mEndTime;

    @aaby(id = 7)
    private final boolean mIsDeleteAllActivityRecords;

    @aaby(id = 5)
    private final boolean mIsDeleteAllData;

    @aaby(id = 3)
    private final long mStartTime;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class Builder {
        private long aabb;
        private long aabc;
        private List<DataType> aab = new ArrayList();
        private List<DataCollector> aaba = new ArrayList();
        private boolean aabd = false;
        private List<ActivityRecord> aabe = new ArrayList();
        private boolean aabf = false;

        public Builder addActivityRecord(ActivityRecord activityRecord) {
            boolean z16;
            boolean z17 = true;
            Preconditions.checkArgument(!this.aabf, "addActivityRecord() can not be used together with deleteAllActivityRecords()");
            if (activityRecord != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            Preconditions.checkArgument(z16, "ActivityRecord should not be null");
            if (activityRecord.getEndTime(TimeUnit.MILLISECONDS) <= 0) {
                z17 = false;
            }
            Preconditions.checkArgument(z17, "Cannot delete a activityRecord that has not ended");
            Preconditions.checkArgument(aacu.aabc(activityRecord.getPackageName()), "must specify the valid package name.");
            this.aabe.add(activityRecord);
            return this;
        }

        public Builder addDataCollector(DataCollector dataCollector) {
            boolean z16 = true;
            Preconditions.checkArgument(!this.aabd, "addDataCollector() can not be used together with deleteAllData(), because deleteAllData() will be delete all data.");
            if (dataCollector == null) {
                z16 = false;
            }
            Preconditions.checkArgument(z16, "DataCollector should not be null");
            if (!this.aaba.contains(dataCollector)) {
                this.aaba.add(dataCollector);
            }
            return this;
        }

        public Builder addDataType(DataType dataType) {
            boolean z16 = true;
            Preconditions.checkArgument(!this.aabd, "addDataType() can not be used together with deleteAllData(), because deleteAllData() will be delete all data.");
            if (dataType == null) {
                z16 = false;
            }
            Preconditions.checkArgument(z16, "data type should not be null");
            if (!this.aab.contains(dataType)) {
                this.aab.add(dataType);
            }
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:25:0x005b  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public DeleteOptions build() {
            boolean z16;
            boolean z17;
            boolean z18;
            boolean z19;
            boolean z26;
            long j3 = this.aabb;
            if (j3 >= 0) {
                long j16 = this.aabc;
                if (j16 > 0 && j16 >= j3) {
                    z16 = true;
                    Preconditions.checkState(z16, "Time range is invalid");
                    if (this.aabd && this.aaba.isEmpty() && this.aab.isEmpty()) {
                        z17 = false;
                    } else {
                        z17 = true;
                    }
                    if (this.aabf && this.aabe.isEmpty()) {
                        z18 = false;
                    } else {
                        z18 = true;
                    }
                    if (z17 && !z18) {
                        z19 = false;
                    } else {
                        z19 = true;
                    }
                    Preconditions.checkState(z19, "No data or activityRecord marked for deletion");
                    if (!this.aabe.isEmpty()) {
                        for (ActivityRecord activityRecord : this.aabe) {
                            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                            if (activityRecord.getStartTime(timeUnit) >= this.aabb && activityRecord.getEndTime(timeUnit) <= this.aabc) {
                                z26 = true;
                            } else {
                                z26 = false;
                            }
                            Preconditions.checkState(z26, "Start time or end time of activity record is outside the set time interval");
                            Preconditions.checkArgument(aacu.aabc(activityRecord.getPackageName()), "must specify the valid package name.");
                        }
                    }
                    return new DeleteOptions(this);
                }
            }
            z16 = false;
            Preconditions.checkState(z16, "Time range is invalid");
            if (this.aabd) {
            }
            z17 = true;
            if (this.aabf) {
            }
            z18 = true;
            if (z17) {
            }
            z19 = true;
            Preconditions.checkState(z19, "No data or activityRecord marked for deletion");
            if (!this.aabe.isEmpty()) {
            }
            return new DeleteOptions(this);
        }

        public Builder deleteAllActivityRecords() {
            Preconditions.checkArgument(this.aabe.isEmpty(), "deleteAllActivityRecords() can not be used together with addActivityRecord(), because deleteAllActivityRecords() will delete all activityRecords");
            this.aabf = true;
            return this;
        }

        public Builder deleteAllData() {
            Preconditions.checkArgument(this.aab.isEmpty(), "deleteAllData() can not be used together with addDataType(), because deleteAllData() will delete all data");
            Preconditions.checkArgument(this.aaba.isEmpty(), "deleteAllData() can not be use together with addDataCollector(), because deleteAllData() will delete all data");
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
            this.aabb = timeUnit.toMillis(j3);
            this.aabc = timeUnit.toMillis(j16);
            return this;
        }
    }

    DeleteOptions(Builder builder) {
        this(builder.aab, builder.aaba, builder.aabb, builder.aabc, builder.aabd, builder.aabe, builder.aabf);
    }

    public boolean deleteAllActivityRecords() {
        return this.mIsDeleteAllActivityRecords;
    }

    public boolean deleteAllData() {
        return this.mIsDeleteAllData;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DeleteOptions)) {
            return false;
        }
        DeleteOptions deleteOptions = (DeleteOptions) obj;
        if (Objects.equal(this.mDataTypes, deleteOptions.mDataTypes) && Objects.equal(this.mDataCollectors, deleteOptions.mDataCollectors) && this.mStartTime == deleteOptions.mStartTime && this.mEndTime == deleteOptions.mEndTime && this.mIsDeleteAllData == deleteOptions.mIsDeleteAllData && Objects.equal(this.mActivityRecords, deleteOptions.mActivityRecords) && this.mIsDeleteAllActivityRecords == deleteOptions.mIsDeleteAllActivityRecords) {
            return true;
        }
        return false;
    }

    public List<ActivityRecord> getActivityRecords() {
        return this.mActivityRecords;
    }

    public List<DataCollector> getDataCollectors() {
        return this.mDataCollectors;
    }

    public List<DataType> getDataTypes() {
        return this.mDataTypes;
    }

    public long getEndTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.mEndTime, TimeUnit.MILLISECONDS);
    }

    public long getStartTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.mStartTime, TimeUnit.MILLISECONDS);
    }

    public int hashCode() {
        return Objects.hashCode(Long.valueOf(this.mStartTime), Long.valueOf(this.mEndTime));
    }

    public String toString() {
        return Objects.toStringHelper(this).add("dateTypes", this.mDataTypes).add("dataCollectors", this.mDataCollectors).add("startTime", Long.valueOf(this.mStartTime)).add("endTime", Long.valueOf(this.mEndTime)).add("deleteAllData", Boolean.valueOf(this.mIsDeleteAllData)).add("activityRecords", this.mActivityRecords).add("isDeleteAllActivityRecords", Boolean.valueOf(this.mIsDeleteAllActivityRecords)).toString();
    }

    @aabw
    public DeleteOptions(@aabv(id = 1) List<DataType> list, @aabv(id = 2) List<DataCollector> list2, @aabv(id = 3) long j3, @aabv(id = 4) long j16, @aabv(id = 5) boolean z16, @aabv(id = 6) List<ActivityRecord> list3, @aabv(id = 7) boolean z17) {
        this.mDataTypes = Collections.unmodifiableList(list);
        this.mDataCollectors = list2;
        this.mStartTime = j3;
        this.mEndTime = j16;
        this.mIsDeleteAllData = z16;
        this.mActivityRecords = list3;
        this.mIsDeleteAllActivityRecords = z17;
    }
}
