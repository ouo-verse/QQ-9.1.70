package com.huawei.hms.hihealth.result;

import android.os.Parcelable;
import com.huawei.hms.common.internal.Objects;
import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.health.aabr;
import com.huawei.hms.health.aabv;
import com.huawei.hms.health.aabw;
import com.huawei.hms.health.aaby;
import com.huawei.hms.hihealth.data.ActivityRecord;
import com.huawei.hms.hihealth.data.ActivityRecordSampleSet;
import com.huawei.hms.hihealth.data.DataType;
import com.huawei.hms.hihealth.data.SampleSet;
import com.huawei.hms.support.api.client.Status;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: P */
/* loaded from: classes2.dex */
public class ActivityRecordResult extends aabr {
    public static final Parcelable.Creator<ActivityRecordResult> CREATOR = new aabr.aab(ActivityRecordResult.class);

    @aaby(id = 3)
    private final List<ActivityRecordSampleSet> mActivityRecordSampleSets;

    @aaby(id = 2)
    private final List<ActivityRecord> mActivityRecords;

    @aaby(id = 1)
    private final Status mStatus;

    @aabw
    public ActivityRecordResult(@aabv(id = 1) Status status, @aabv(id = 2) List<ActivityRecord> list, @aabv(id = 3) List<ActivityRecordSampleSet> list2) {
        this.mStatus = status;
        this.mActivityRecords = list;
        this.mActivityRecordSampleSets = Collections.unmodifiableList(list2);
    }

    public static ActivityRecordResult getActivityRecordResult(Status status) {
        return new ActivityRecordResult(status, new ArrayList(), new ArrayList());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ActivityRecordResult)) {
            return false;
        }
        ActivityRecordResult activityRecordResult = (ActivityRecordResult) obj;
        if (this.mStatus.equals(activityRecordResult.mStatus) && Objects.equal(this.mActivityRecords, activityRecordResult.mActivityRecords) && Objects.equal(this.mActivityRecordSampleSets, activityRecordResult.mActivityRecordSampleSets)) {
            return true;
        }
        return false;
    }

    public List<ActivityRecordSampleSet> getActivityRecordSampleSets() {
        return this.mActivityRecordSampleSets;
    }

    public List<ActivityRecord> getActivityRecords() {
        return this.mActivityRecords;
    }

    public List<SampleSet> getSampleSet(ActivityRecord activityRecord) {
        Preconditions.checkArgument(this.mActivityRecords.contains(activityRecord), "the parameter entered is illegal");
        ArrayList arrayList = new ArrayList();
        for (ActivityRecordSampleSet activityRecordSampleSet : this.mActivityRecordSampleSets) {
            if (Objects.equal(activityRecord, activityRecordSampleSet.getActivityRecord())) {
                arrayList.add(activityRecordSampleSet.getSampleSet());
            }
        }
        return arrayList;
    }

    @Override // com.huawei.hms.support.api.client.Result
    public Status getStatus() {
        return this.mStatus;
    }

    public int hashCode() {
        return Objects.hashCode(this.mStatus, this.mActivityRecords, this.mActivityRecordSampleSets);
    }

    public String toString() {
        return Objects.toStringHelper(this).add("status", this.mStatus).add("activityRecords", this.mActivityRecords).add("activityRecordSampleSets", this.mActivityRecordSampleSets).toString();
    }

    public List<SampleSet> getSampleSet(ActivityRecord activityRecord, DataType dataType) {
        Preconditions.checkArgument(this.mActivityRecords.contains(activityRecord), "the parameter entered is illegal");
        ArrayList arrayList = new ArrayList();
        for (ActivityRecordSampleSet activityRecordSampleSet : this.mActivityRecordSampleSets) {
            if (Objects.equal(activityRecord, activityRecordSampleSet.getActivityRecord()) && dataType.equals(activityRecordSampleSet.getSampleSet().getDataType())) {
                arrayList.add(activityRecordSampleSet.getSampleSet());
            }
        }
        return arrayList;
    }
}
