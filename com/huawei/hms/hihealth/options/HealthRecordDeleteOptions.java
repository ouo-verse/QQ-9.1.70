package com.huawei.hms.hihealth.options;

import android.os.Parcelable;
import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.health.aabq;
import com.huawei.hms.health.aabv;
import com.huawei.hms.health.aabw;
import com.huawei.hms.health.aaby;
import com.huawei.hms.health.aabz;
import com.huawei.hms.health.aac;
import com.huawei.hms.hihealth.HiHealthStatusCodes;
import com.huawei.hms.hihealth.data.DataType;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* compiled from: P */
/* loaded from: classes2.dex */
public class HealthRecordDeleteOptions extends aabq {
    public static final Parcelable.Creator<HealthRecordDeleteOptions> CREATOR = new aabq.aab(HealthRecordDeleteOptions.class);
    private static final TimeUnit TIME_UNIT = TimeUnit.NANOSECONDS;

    @aaby(id = 1)
    private final DataType mDataType;

    @aaby(id = 5)
    private final boolean mDeleteSubData;

    @aaby(id = 3)
    private final long mEndTime;

    @aaby(id = 4)
    private final List<String> mHealthRecordIds;

    @aaby(id = 2)
    private final long mStartTime;

    @aaby(id = 6)
    private final List<DataType> mSubDataTypeList;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class Builder {
        private DataType aab;
        private long aaba;
        private long aabb;
        private List<String> aabc;
        private boolean aabd;
        private List<DataType> aabe;

        public HealthRecordDeleteOptions build() {
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
            if (aabz.aab(this.aabc).booleanValue() && (this.aab == null || this.aaba == 0 || this.aabb == 0)) {
                throw new IllegalStateException("deleteHealthRecord: should input starttime endtime dataType or healthRecordId");
            }
            DataType dataType = this.aab;
            if (dataType != null && !aac.aab(dataType.getName())) {
                aabz.aab("build HealthRecordDeleteOptions", "The input datatype is not supported by the health record type.");
                throw new SecurityException(String.valueOf(HiHealthStatusCodes.HEALTH_RECORDS_NOT_SUPPORT));
            }
            return new HealthRecordDeleteOptions(this);
        }

        public Builder isDeleteSubData(boolean z16) {
            this.aabd = z16;
            return this;
        }

        public Builder setDataType(DataType dataType) {
            this.aab = dataType;
            return this;
        }

        public Builder setHealthRecordIds(List<String> list) {
            this.aabc = list;
            return this;
        }

        public Builder setSubDataTypeList(List<DataType> list) {
            this.aabe = list;
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
            this.aaba = HealthRecordDeleteOptions.TIME_UNIT.convert(j3, timeUnit);
            this.aabb = HealthRecordDeleteOptions.TIME_UNIT.convert(j16, timeUnit);
            return this;
        }
    }

    @aabw
    HealthRecordDeleteOptions(@aabv(id = 1) DataType dataType, @aabv(id = 2) long j3, @aabv(id = 3) long j16, @aabv(id = 4) List<String> list, @aabv(id = 5) boolean z16, @aabv(id = 6) List<DataType> list2) {
        this.mDataType = dataType;
        this.mStartTime = j3;
        this.mEndTime = j16;
        this.mHealthRecordIds = list;
        this.mDeleteSubData = z16;
        this.mSubDataTypeList = list2;
    }

    public DataType getDataType() {
        return this.mDataType;
    }

    public long getEndTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.mEndTime, TIME_UNIT);
    }

    public List<String> getHealthRecordIds() {
        return this.mHealthRecordIds;
    }

    public long getStartTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.mStartTime, TIME_UNIT);
    }

    public List<DataType> getSubDataTypeList() {
        return this.mSubDataTypeList;
    }

    public boolean isDeleteSubData() {
        return this.mDeleteSubData;
    }

    HealthRecordDeleteOptions(Builder builder) {
        this(builder.aab, builder.aaba, builder.aabb, builder.aabc, builder.aabd, builder.aabe);
    }
}
