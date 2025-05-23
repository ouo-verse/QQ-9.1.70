package com.huawei.hms.hihealth.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hms.common.internal.Objects;
import com.huawei.hms.common.internal.safeparcel.SafeParcelReader;
import com.huawei.hms.common.internal.safeparcel.SafeParcelWriter;
import com.huawei.hms.health.aabz;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class ActivityRecordSampleSet implements Parcelable {
    public static final Parcelable.Creator<ActivityRecordSampleSet> CREATOR = new aab();
    private static final int DATASETID = 2;
    private static final int SESSIONID = 1;
    private static final String TAG = "ActivityRecordSampleSet";
    private final ActivityRecord mActivityRecord;
    private final SampleSet mSampleSet;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    static class aab implements Parcelable.Creator<ActivityRecordSampleSet> {
        aab() {
        }

        @Override // android.os.Parcelable.Creator
        public ActivityRecordSampleSet createFromParcel(Parcel parcel) {
            return new ActivityRecordSampleSet(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public ActivityRecordSampleSet[] newArray(int i3) {
            return new ActivityRecordSampleSet[i3];
        }
    }

    protected ActivityRecordSampleSet(Parcel parcel) {
        int i3;
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        ActivityRecord activityRecord = null;
        int i16 = 0;
        SampleSet sampleSet = null;
        while (true) {
            i3 = i16 + 1;
            if (i16 > validateObjectHeader || parcel.dataPosition() >= validateObjectHeader) {
                break;
            }
            int readHeader = SafeParcelReader.readHeader(parcel);
            int fieldId = SafeParcelReader.getFieldId(readHeader);
            if (fieldId == 1) {
                activityRecord = (ActivityRecord) SafeParcelReader.createParcelable(parcel, readHeader, ActivityRecord.CREATOR);
            } else if (fieldId != 2) {
                SafeParcelReader.skipUnknownField(parcel, readHeader);
            } else {
                sampleSet = (SampleSet) SafeParcelReader.createParcelable(parcel, readHeader, SampleSet.CREATOR);
            }
            i16 = i3;
        }
        if (i3 > validateObjectHeader) {
            aabz.aab(TAG, "Max loop reached, ActivityRecordSampleSet parcel failed");
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        this.mActivityRecord = activityRecord;
        this.mSampleSet = sampleSet;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ActivityRecordSampleSet)) {
            return false;
        }
        ActivityRecordSampleSet activityRecordSampleSet = (ActivityRecordSampleSet) obj;
        if (Objects.equal(this.mActivityRecord, activityRecordSampleSet.mActivityRecord) && Objects.equal(this.mSampleSet, activityRecordSampleSet.mSampleSet)) {
            return true;
        }
        return false;
    }

    public ActivityRecord getActivityRecord() {
        return this.mActivityRecord;
    }

    public SampleSet getSampleSet() {
        return this.mSampleSet;
    }

    public int hashCode() {
        return Objects.hashCode(this.mActivityRecord, this.mSampleSet);
    }

    public boolean isSampleSetEmpty() {
        return this.mSampleSet.isEmpty();
    }

    public String toString() {
        return Objects.toStringHelper(this).add("mActivityRecord", this.mActivityRecord).add("mSampleSet", this.mSampleSet).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, this.mActivityRecord, i3, false);
        SafeParcelWriter.writeParcelable(parcel, 2, this.mSampleSet, i3, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public ActivityRecordSampleSet(ActivityRecord activityRecord, SampleSet sampleSet) {
        this.mActivityRecord = activityRecord;
        this.mSampleSet = sampleSet;
    }
}
