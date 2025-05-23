package com.huawei.hms.hihealth.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hms.common.internal.Objects;
import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.health.aabz;
import com.huawei.hms.health.aacu;
import com.huawei.hms.hihealth.data.SamplePoint;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes2.dex */
public class SampleSet implements Parcelable {
    public static final Parcelable.Creator<SampleSet> CREATOR = new aab();
    private DataCollector dataCollector;
    private List<DataCollector> involvedDataCollectors;
    private List<SamplePoint> samplePointsList;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class Builder {
        DataCollector dataCollector;
        List<SamplePoint> samplePointsList = new ArrayList();

        public Builder(DataCollector dataCollector) {
            this.dataCollector = (DataCollector) Preconditions.checkNotNull(dataCollector, "dataCollector is not allow null!");
        }

        public Builder addSample(SamplePoint samplePoint) {
            Preconditions.checkArgument(samplePoint.getDataCollector().getDataStreamId().equals(this.dataCollector.getDataStreamId()), "DataCollector mismatch");
            SampleSet.checkLegality(samplePoint, this.dataCollector);
            this.samplePointsList.add(samplePoint);
            return this;
        }

        public Builder addSampleList(Iterable<SamplePoint> iterable) {
            Iterator<SamplePoint> it = iterable.iterator();
            while (it.hasNext()) {
                addSample(it.next());
            }
            return this;
        }

        public SampleSet build() {
            SampleSet sampleSet = new SampleSet((aab) null);
            sampleSet.samplePointsList = this.samplePointsList;
            sampleSet.dataCollector = this.dataCollector;
            return sampleSet;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class aab implements Parcelable.Creator<SampleSet> {
        aab() {
        }

        @Override // android.os.Parcelable.Creator
        public SampleSet createFromParcel(Parcel parcel) {
            return new SampleSet(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public SampleSet[] newArray(int i3) {
            return new SampleSet[i3];
        }
    }

    SampleSet() {
    }

    protected SampleSet(Parcel parcel) {
        this.dataCollector = (DataCollector) parcel.readParcelable(DataCollector.class.getClassLoader());
        ArrayList arrayList = new ArrayList();
        this.samplePointsList = arrayList;
        aacu.aab(parcel, arrayList, SamplePoint.CREATOR);
    }

    public static Builder builder(DataCollector dataCollector) {
        Preconditions.checkNotNull(dataCollector, "DataCollector cannot be null");
        return new Builder(dataCollector);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void checkLegality(SamplePoint samplePoint, DataCollector dataCollector) throws IllegalArgumentException {
        boolean z16;
        if (!dataCollector.getDataType().isFromSelfDefined()) {
            if (!aabz.aab(dataCollector.getDataType()).equals(dataCollector)) {
                if (samplePoint != null && samplePoint.getDataCollector().equals(dataCollector)) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                Preconditions.checkArgument(z16, "samplePoint is null or dataCollector mismatch!");
                return;
            }
            Preconditions.checkState(dataCollector.getDataType().equals(samplePoint.getDataType()), "dataCollector DataType mismatch!");
        }
    }

    public static SampleSet create(DataCollector dataCollector) {
        Preconditions.checkNotNull(dataCollector, "DataCollector cannot be null");
        return new Builder(dataCollector).build();
    }

    public void addSample(SamplePoint samplePoint) {
        checkLegality(samplePoint, this.dataCollector);
        this.samplePointsList.add(samplePoint);
    }

    public final void addSampleList(Iterable<SamplePoint> iterable) {
        if (iterable == null) {
            return;
        }
        Iterator<SamplePoint> it = iterable.iterator();
        while (it.hasNext()) {
            addSample(it.next());
        }
    }

    public final void addSampleListNoCheckLegality(List<SamplePoint> list) {
        if (list == null) {
            return;
        }
        Iterator<SamplePoint> it = list.iterator();
        while (it.hasNext()) {
            addSampleNoCheckLegality(it.next());
        }
    }

    public void addSampleNoCheckLegality(SamplePoint samplePoint) {
        this.samplePointsList.add(samplePoint);
    }

    public SamplePoint createSamplePoint() {
        return new SamplePoint.Builder(this.dataCollector).build();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SampleSet)) {
            return false;
        }
        SampleSet sampleSet = (SampleSet) obj;
        if (this.dataCollector.equals(sampleSet.dataCollector) && Objects.equal(this.samplePointsList, sampleSet.samplePointsList)) {
            return true;
        }
        return false;
    }

    public DataCollector getDataCollector() {
        return this.dataCollector;
    }

    public DataType getDataType() {
        return this.dataCollector.getDataType();
    }

    public List<SamplePoint> getSamplePoints() {
        return this.samplePointsList;
    }

    public final int hashCode() {
        return Objects.hashCode(this.dataCollector);
    }

    public boolean isEmpty() {
        return this.samplePointsList.isEmpty();
    }

    public String toString() {
        StringBuilder aab2 = com.huawei.hms.health.aab.aab("SampleSet{");
        StringBuilder aab3 = com.huawei.hms.health.aab.aab("dataCollector=");
        aab3.append(this.dataCollector);
        aab2.append(aab3.toString());
        StringBuilder aab4 = com.huawei.hms.health.aab.aab(", samplePointsList=");
        aab4.append(this.samplePointsList);
        aab2.append(aab4.toString());
        StringBuilder aab5 = com.huawei.hms.health.aab.aab(", involvedDataCollectors=");
        aab5.append(this.involvedDataCollectors);
        aab5.append('}');
        aab2.append(aab5.toString());
        return aab2.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeParcelable(this.dataCollector, i3);
        parcel.writeTypedList(this.samplePointsList);
    }

    /* synthetic */ SampleSet(aab aabVar) {
        this();
    }
}
