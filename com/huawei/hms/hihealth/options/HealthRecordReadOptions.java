package com.huawei.hms.hihealth.options;

import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.health.aabq;
import com.huawei.hms.health.aabv;
import com.huawei.hms.health.aabw;
import com.huawei.hms.health.aaby;
import com.huawei.hms.health.aabz;
import com.huawei.hms.health.aac;
import com.huawei.hms.health.aacu;
import com.huawei.hms.hihealth.HiHealthStatusCodes;
import com.huawei.hms.hihealth.data.DataCollector;
import com.huawei.hms.hihealth.data.DataType;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/* compiled from: P */
/* loaded from: classes2.dex */
public class HealthRecordReadOptions extends aabq {
    public static final Parcelable.Creator<HealthRecordReadOptions> CREATOR = new aabq.aab(HealthRecordReadOptions.class);
    private static final TimeUnit TIME_UNIT = TimeUnit.NANOSECONDS;

    @aaby(id = 3)
    private final DataCollector mDataCollector;

    @aaby(id = 4)
    private final DataType mDataType;

    @aaby(id = 2)
    private final long mEndTime;

    @aaby(id = 5)
    private final boolean mIsFromAllApps;

    @aaby(id = 6)
    private final boolean mIsRemoteInquiry;

    @aaby(id = 7)
    private final List<String> mRemoveApplicationsList;

    @aaby(id = 1)
    private final long mStartTime;

    @aaby(id = 8)
    private final List<DataType> mSubDataTypeList;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class Builder {
        private DataCollector aabb;
        private DataType aabc;
        private long aab = 0;
        private long aaba = 0;
        private boolean aabd = false;
        private boolean aabe = false;
        private List<String> aabf = new ArrayList();
        private List<DataType> aabg = new ArrayList();

        public Builder allowRemoteInquiry() {
            this.aabe = true;
            return this;
        }

        public HealthRecordReadOptions build() {
            boolean z16;
            aacu.aab(this.aab, this.aaba, TimeUnit.NANOSECONDS);
            boolean z17 = false;
            if (this.aabc == null && this.aabb == null) {
                z16 = false;
            } else {
                z16 = true;
            }
            Preconditions.checkArgument(z16, "mDataType and mDataCollector,one of them must fill in");
            DataType dataType = this.aabc;
            if (dataType != null && this.aabb != null) {
                Preconditions.checkArgument(dataType.getName().equals(this.aabb.getDataType().getName()), "data type must be the same as that of the collector.");
            }
            long j3 = this.aaba;
            if (j3 > 0 && j3 > this.aab) {
                z17 = true;
            }
            Preconditions.checkArgument(z17, "End time is illegal");
            DataType dataType2 = this.aabc;
            if (dataType2 != null && !aac.aab(dataType2.getName())) {
                aabz.aab("build HealthRecordReadOptions", "The input datatype is not supported by the health record type.");
                throw new SecurityException(String.valueOf(HiHealthStatusCodes.HEALTH_RECORDS_NOT_SUPPORT));
            }
            DataCollector dataCollector = this.aabb;
            if (dataCollector != null && dataCollector.getDataType() != null && !aac.aab(this.aabb.getDataType().getName())) {
                aabz.aab("build HealthRecordReadOptions", "The input datatype is not supported by the health record type.");
                throw new SecurityException(String.valueOf(HiHealthStatusCodes.HEALTH_RECORDS_NOT_SUPPORT));
            }
            return new HealthRecordReadOptions(this.aab, this.aaba, this.aabb, this.aabc, this.aabd, this.aabe, this.aabf, this.aabg);
        }

        public Builder readByDataCollector(DataCollector dataCollector) {
            if (dataCollector != null) {
                this.aabb = dataCollector;
            }
            return this;
        }

        public Builder readByDataType(DataType dataType) {
            if (dataType != null) {
                this.aabc = dataType;
            }
            return this;
        }

        public Builder readHealthRecordsFromAllApps() {
            this.aabd = true;
            return this;
        }

        public Builder removeApplication(String str) {
            Preconditions.checkNotNull(str, "Application name should not be null");
            if (!this.aabf.contains(str)) {
                this.aabf.add(str);
            }
            return this;
        }

        public Builder setSubDataTypeList(List<DataType> list) {
            if (list != null && !list.isEmpty()) {
                this.aabg = list;
            }
            return this;
        }

        public Builder setTimeInterval(long j3, long j16, TimeUnit timeUnit) {
            boolean z16;
            TimeUnit timeUnit2 = TimeUnit.NANOSECONDS;
            this.aab = timeUnit2.convert(j3, timeUnit);
            this.aaba = timeUnit2.convert(j16, timeUnit);
            boolean z17 = true;
            if (this.aab > 1388505600000000000L) {
                z16 = true;
            } else {
                z16 = false;
            }
            Preconditions.checkState(z16, "Start time must be later than default start time: 20140101 00:00:000");
            if (this.aaba < this.aab) {
                z17 = false;
            }
            Preconditions.checkState(z17, "the start time must be less than the end time");
            return this;
        }
    }

    @aabw
    HealthRecordReadOptions(@aabv(id = 1) long j3, @aabv(id = 2) long j16, @aabv(id = 3) DataCollector dataCollector, @aabv(id = 4) DataType dataType, @aabv(id = 5) boolean z16, @aabv(id = 6) boolean z17, @aabv(id = 7) List<String> list, @aabv(id = 8) List<DataType> list2) {
        this.mStartTime = j3;
        this.mEndTime = j16;
        this.mDataCollector = dataCollector;
        this.mDataType = dataType;
        this.mIsFromAllApps = z16;
        this.mIsRemoteInquiry = z17;
        this.mRemoveApplicationsList = list;
        this.mSubDataTypeList = list2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof HealthRecordReadOptions)) {
            return false;
        }
        HealthRecordReadOptions healthRecordReadOptions = (HealthRecordReadOptions) obj;
        if (Objects.equals(Long.valueOf(this.mStartTime), Long.valueOf(healthRecordReadOptions.mStartTime)) && Objects.equals(Long.valueOf(this.mEndTime), Long.valueOf(healthRecordReadOptions.mEndTime)) && Objects.equals(this.mDataCollector, healthRecordReadOptions.mDataCollector) && Objects.equals(this.mDataType, healthRecordReadOptions.mDataType) && Objects.equals(Boolean.valueOf(this.mIsFromAllApps), Boolean.valueOf(healthRecordReadOptions.mIsFromAllApps)) && Objects.equals(Boolean.valueOf(this.mIsRemoteInquiry), Boolean.valueOf(healthRecordReadOptions.mIsRemoteInquiry)) && Objects.equals(this.mRemoveApplicationsList, healthRecordReadOptions.mRemoveApplicationsList) && Objects.equals(this.mSubDataTypeList, healthRecordReadOptions.mSubDataTypeList)) {
            return true;
        }
        return false;
    }

    public DataCollector getDataCollector() {
        return this.mDataCollector;
    }

    public DataType getDataType() {
        return this.mDataType;
    }

    public boolean getEnableServerQueries() {
        return this.mIsRemoteInquiry;
    }

    public long getEndTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.mEndTime, TIME_UNIT);
    }

    public List<String> getRemoveApplicationsList() {
        return this.mRemoveApplicationsList;
    }

    public long getStartTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.mStartTime, TIME_UNIT);
    }

    public List<DataType> getSubDataTypeList() {
        return this.mSubDataTypeList;
    }

    public int hashCode() {
        return com.huawei.hms.common.internal.Objects.hashCode(Long.valueOf(this.mStartTime), Long.valueOf(this.mEndTime), this.mDataCollector, this.mDataType, Boolean.valueOf(this.mIsFromAllApps), Boolean.valueOf(this.mIsRemoteInquiry), this.mRemoveApplicationsList, this.mSubDataTypeList);
    }

    public boolean isAllAppsSelected() {
        return this.mIsFromAllApps;
    }

    @NonNull
    public String toString() {
        return com.huawei.hms.common.internal.Objects.toStringHelper(this).add("startTime", Long.valueOf(this.mStartTime)).add("endTime", Long.valueOf(this.mEndTime)).add("dataCollector", this.mDataCollector).add("dataType", this.mDataType).add("fromAllApps", Boolean.valueOf(this.mIsFromAllApps)).add("useRemote", Boolean.valueOf(this.mIsRemoteInquiry)).add("removeApplications", this.mRemoveApplicationsList).add("subDataTypes", this.mSubDataTypeList).toString();
    }
}
