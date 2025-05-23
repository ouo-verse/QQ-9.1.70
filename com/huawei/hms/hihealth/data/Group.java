package com.huawei.hms.hihealth.data;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import com.huawei.hms.common.internal.Objects;
import com.huawei.hms.health.aacc;
import com.huawei.hms.health.aacu;
import com.tencent.mobileqq.qwallet.transaction.impl.NotifyMsgApiImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* compiled from: P */
/* loaded from: classes2.dex */
public class Group implements Parcelable {
    public static final Parcelable.Creator<Group> CREATOR = new aab();
    public static final int TYPE_ACTIVITY_FRAGMENT = 4;
    public static final int TYPE_ACTIVITY_RECORD = 2;
    public static final int TYPE_ACTIVITY_TYPE = 3;
    public static final int TYPE_INTERVALS = 5;
    public static final int TYPE_TIME = 1;
    private final ActivityRecord activityRecord;
    private final int activityType;
    private final long endTime;
    private final int groupType;
    private boolean hasMoreSample;
    private final List<SampleSet> sampleSets;
    private final long startTime;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    static class aab implements Parcelable.Creator<Group> {
        aab() {
        }

        @Override // android.os.Parcelable.Creator
        public Group createFromParcel(Parcel parcel) {
            return new Group(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public Group[] newArray(int i3) {
            return new Group[i3];
        }
    }

    public Group(long j3, long j16, @Nullable ActivityRecord activityRecord, int i3, List<SampleSet> list, int i16, boolean z16) {
        this.startTime = j3;
        this.endTime = j16;
        this.activityRecord = activityRecord;
        this.activityType = i3;
        this.sampleSets = list;
        this.groupType = i16;
        this.hasMoreSample = z16;
    }

    public static String getGroupTypeString(int i3) {
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 4) {
                            if (i3 != 5) {
                                return NotificationCompat.CATEGORY_ERROR;
                            }
                            return "intervals";
                        }
                        return "activityFragment";
                    }
                    return "activityType";
                }
                return "activityRecord";
            }
            return "time";
        }
        return "none";
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Group)) {
            return false;
        }
        Group group = (Group) obj;
        if (this.groupType == group.groupType && this.startTime == group.startTime && this.endTime == group.endTime && this.hasMoreSample == group.hasMoreSample && this.activityType == group.activityType && Objects.equal(this.sampleSets, group.sampleSets)) {
            return true;
        }
        return false;
    }

    public String getActivity() {
        return aacc.aab(this.activityType);
    }

    @Nullable
    public ActivityRecord getActivityRecord() {
        return this.activityRecord;
    }

    public final int getActivityType() {
        return this.activityType;
    }

    public long getEndTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.endTime, TimeUnit.MILLISECONDS);
    }

    public int getGroupType() {
        return this.groupType;
    }

    @Nullable
    public SampleSet getSampleSet(DataType dataType) {
        for (SampleSet sampleSet : this.sampleSets) {
            if (sampleSet.getDataType().equals(dataType)) {
                return sampleSet;
            }
        }
        return null;
    }

    public List<SampleSet> getSampleSets() {
        return this.sampleSets;
    }

    public long getStartTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.startTime, TimeUnit.MILLISECONDS);
    }

    public final boolean hasMoreSample() {
        if (this.hasMoreSample || this.sampleSets.iterator().hasNext()) {
            return true;
        }
        return false;
    }

    public final boolean hasSameSample(Group group) {
        if (this.groupType == group.groupType && this.startTime == group.startTime && this.endTime == group.endTime && this.activityType == group.activityType) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.groupType), Long.valueOf(this.startTime), Long.valueOf(this.endTime), Integer.valueOf(this.activityType));
    }

    public String toString() {
        return Objects.toStringHelper(this).add(NotifyMsgApiImpl.KEY_GROUP_TYPE, getGroupTypeString(this.groupType)).add("startTime", Long.valueOf(this.startTime)).add("endTime", Long.valueOf(this.endTime)).add("hasMoreSample", Boolean.valueOf(this.hasMoreSample)).add("activityType", Integer.valueOf(this.activityType)).add("sampleSets", this.sampleSets).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.groupType);
        parcel.writeLong(this.startTime);
        parcel.writeLong(this.endTime);
        parcel.writeInt(hasMoreSample() ? 1 : 0);
        parcel.writeInt(this.activityType);
        parcel.writeParcelable(null, i3);
        parcel.writeTypedList(this.sampleSets);
    }

    protected Group(Parcel parcel) {
        this.groupType = parcel.readInt();
        this.startTime = parcel.readLong();
        this.endTime = parcel.readLong();
        this.hasMoreSample = parcel.readInt() != 0;
        this.activityType = parcel.readInt();
        this.activityRecord = (ActivityRecord) parcel.readParcelable(ActivityRecord.class.getClassLoader());
        ArrayList arrayList = new ArrayList();
        this.sampleSets = arrayList;
        aacu.aab(parcel, arrayList, SampleSet.CREATOR);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Group(Group group, List<DataCollector> list) {
        this(group.getStartTime(r12), group.getEndTime(r12), group.getActivityRecord(), group.getActivityType(), new ArrayList(group.getSampleSets().size()), group.getGroupType(), group.hasMoreSample());
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        this.sampleSets.addAll(group.getSampleSets());
    }
}
