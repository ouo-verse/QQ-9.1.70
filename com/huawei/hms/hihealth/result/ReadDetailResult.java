package com.huawei.hms.hihealth.result;

import android.os.Parcelable;
import com.huawei.hms.common.internal.Objects;
import com.huawei.hms.health.aabr;
import com.huawei.hms.health.aabv;
import com.huawei.hms.health.aabw;
import com.huawei.hms.health.aaby;
import com.huawei.hms.health.aabz;
import com.huawei.hms.hihealth.data.DataCollector;
import com.huawei.hms.hihealth.data.DataType;
import com.huawei.hms.hihealth.data.Group;
import com.huawei.hms.hihealth.data.SampleSet;
import com.huawei.hms.support.api.client.Status;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes2.dex */
public class ReadDetailResult extends aabr {
    public static final Parcelable.Creator<ReadDetailResult> CREATOR = new aabr.aab(ReadDetailResult.class);
    private static final String DEFAULT_NAME = "default";
    private static final String DEFAULT_PACKAGE_NAME = "com.huawei.hms.health";
    private static final String TAG = "ReadDetailResult";

    @aaby(id = 4)
    private int mBatchNumber;

    @aaby(id = 3)
    private final List<Group> mGroups;

    @aaby(id = 1)
    private List<SampleSet> mOriginalSampleSets;

    @aaby(id = 2)
    private Status mStatus;
    private final List<DataCollector> mUniqueDataCollectors;

    ReadDetailResult(List<SampleSet> list, Status status, List<Group> list2) {
        this(list, status, list2, 1);
    }

    public static ReadDetailResult create(Status status, List<Group> list) {
        return new ReadDetailResult(Collections.EMPTY_LIST, status, list);
    }

    public static ReadDetailResult createBySampleSet(Status status, List<SampleSet> list) {
        return new ReadDetailResult(list, status, Collections.EMPTY_LIST);
    }

    private static void insertGroup(Group group, List<Group> list) {
        for (Group group2 : list) {
            if (group2.hasSameSample(group)) {
                Iterator<SampleSet> it = group.getSampleSets().iterator();
                while (it.hasNext()) {
                    insertSampleSet(it.next(), group2.getSampleSets());
                }
                return;
            }
        }
        list.add(group);
    }

    private static void insertSampleSet(SampleSet sampleSet, List<SampleSet> list) {
        for (SampleSet sampleSet2 : list) {
            if (sampleSet2.getDataCollector().equals(sampleSet.getDataCollector())) {
                if (sampleSet2.getSamplePoints() != null) {
                    sampleSet2.getSamplePoints().addAll(sampleSet.getSamplePoints());
                    return;
                }
                return;
            }
        }
        list.add(sampleSet);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ReadDetailResult)) {
            return false;
        }
        ReadDetailResult readDetailResult = (ReadDetailResult) obj;
        if (this.mStatus.equals(readDetailResult.mStatus) && Objects.equal(this.mOriginalSampleSets, readDetailResult.mOriginalSampleSets) && Objects.equal(this.mGroups, readDetailResult.mGroups)) {
            return true;
        }
        return false;
    }

    public final int getBatchNumber() {
        return this.mBatchNumber;
    }

    public List<Group> getGroups() {
        return this.mGroups;
    }

    public SampleSet getSampleSet(DataCollector dataCollector) {
        for (SampleSet sampleSet : this.mOriginalSampleSets) {
            if (dataCollector.equals(sampleSet.getDataCollector())) {
                return sampleSet;
            }
        }
        SampleSet create = SampleSet.create(dataCollector);
        this.mOriginalSampleSets.add(create);
        return create;
    }

    public List<SampleSet> getSampleSets() {
        return this.mOriginalSampleSets;
    }

    @Override // com.huawei.hms.support.api.client.Result
    public Status getStatus() {
        return this.mStatus;
    }

    public int hashCode() {
        return Objects.hashCode(this.mStatus, this.mOriginalSampleSets, this.mGroups);
    }

    public final void polymeric(ReadDetailResult readDetailResult) {
        Iterator<SampleSet> it = readDetailResult.getSampleSets().iterator();
        while (it.hasNext()) {
            insertSampleSet(it.next(), this.mOriginalSampleSets);
        }
        Iterator<Group> it5 = readDetailResult.getGroups().iterator();
        while (it5.hasNext()) {
            insertGroup(it5.next(), this.mGroups);
        }
    }

    public void setSampleSets(List<SampleSet> list) {
        this.mOriginalSampleSets = list;
    }

    @Override // com.huawei.hms.support.api.client.Result
    public void setStatus(Status status) {
        if (status != null) {
            this.mStatus = status;
        }
    }

    public String toString() {
        StringBuilder aab = com.huawei.hms.health.aab.aab("ReadDetailResult{");
        aab.append("status: ");
        aab.append(this.mStatus.toString());
        if (!this.mOriginalSampleSets.isEmpty()) {
            aab.append(" sampleSets: ");
            Iterator<SampleSet> it = this.mOriginalSampleSets.iterator();
            while (it.hasNext()) {
                aab.append(it.next().toString());
                aab.append(" ");
            }
        }
        if (!this.mGroups.isEmpty()) {
            aab.append(" groups: ");
            Iterator<Group> it5 = this.mGroups.iterator();
            while (it5.hasNext()) {
                aab.append(" ");
                aab.append(it5.next().toString());
            }
        }
        aab.append("}");
        return aab.toString();
    }

    @aabw
    ReadDetailResult(@aabv(id = 1) List<SampleSet> list, @aabv(id = 2) Status status, @aabv(id = 3) List<Group> list2, @aabv(id = 4) int i3) {
        this.mOriginalSampleSets = list;
        this.mStatus = status;
        this.mGroups = list2;
        this.mBatchNumber = i3;
        this.mUniqueDataCollectors = new ArrayList();
    }

    public static ReadDetailResult create(Status status, List<DataType> list, List<DataCollector> list2) {
        ArrayList arrayList = new ArrayList();
        Iterator<DataCollector> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(SampleSet.create(it.next()));
        }
        Iterator<DataType> it5 = list.iterator();
        while (it5.hasNext()) {
            arrayList.add(SampleSet.create(new DataCollector.Builder().setPackageName(DEFAULT_PACKAGE_NAME).setDataStreamName("default").setDataGenerateType(1).setDataType(it5.next()).build()));
        }
        return new ReadDetailResult(arrayList, status, Collections.EMPTY_LIST);
    }

    public SampleSet getSampleSet(DataType dataType) {
        if (dataType == null) {
            return null;
        }
        DataCollector aab = aabz.aab(dataType);
        for (SampleSet sampleSet : this.mOriginalSampleSets) {
            if (dataType.equals(sampleSet.getDataType()) && aab.equals(sampleSet.getDataCollector())) {
                return sampleSet;
            }
        }
        SampleSet create = SampleSet.create(aab);
        this.mOriginalSampleSets.add(create);
        return create;
    }

    public void polymeric(List<Group> list) {
        if (aabz.aab(this.mGroups).booleanValue()) {
            this.mGroups.addAll(list);
            return;
        }
        Iterator<Group> it = list.iterator();
        while (it.hasNext()) {
            insertGroup(it.next(), this.mGroups);
        }
    }
}
