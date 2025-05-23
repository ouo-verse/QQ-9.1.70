package com.huawei.hms.hihealth.data;

import android.os.Parcelable;
import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.health.aabq;
import com.huawei.hms.health.aabv;
import com.huawei.hms.health.aabw;
import com.huawei.hms.health.aaby;
import com.huawei.hms.health.aabz;
import com.huawei.hms.health.aacu;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/* compiled from: P */
/* loaded from: classes2.dex */
public class SampleSection extends aabq {
    public static final Parcelable.Creator<SampleSection> CREATOR = new aabq.aab(SampleSection.class);

    @aaby(id = 4)
    private long endTime;

    @aaby(id = 5)
    private List<SamplePoint> sectionDataList;

    @aaby(id = 1)
    private int sectionNum;

    @aaby(id = 2)
    private long sectionTime;

    @aaby(id = 3)
    private long startTime;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class Builder {
        private long endTime;
        private List<SamplePoint> sectionDataList = new ArrayList();
        private int sectionNum;
        private long sectionTime;
        private long startTime;

        public Builder addSectionData(SamplePoint samplePoint) {
            boolean z16;
            if (samplePoint != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            Preconditions.checkArgument(z16, "sectionDataSamplePoint must not be null");
            this.sectionDataList.add(samplePoint);
            return this;
        }

        public SampleSection build() {
            boolean z16;
            int i3 = this.sectionNum;
            boolean z17 = true;
            if (i3 > 0 && i3 < 1000) {
                z16 = true;
            } else {
                z16 = false;
            }
            Preconditions.checkArgument(z16, "SampleSection:sectionNum must between 0 and 1000.");
            Preconditions.checkArgument(aacu.aaba(this.startTime), "SampleSection:startTime illegal.");
            if (!aacu.aaba(this.endTime) || this.endTime < this.startTime) {
                z17 = false;
            }
            Preconditions.checkArgument(z17, "SampleSection:endtime should be later than start time.");
            Preconditions.checkArgument(aabz.aaba(this.sectionDataList).booleanValue(), "SampleSection:sectionDataList must not be empty.");
            return new SampleSection(this.sectionNum, this.sectionTime, this.startTime, this.endTime, this.sectionDataList);
        }

        public Builder setEndTime(long j3, TimeUnit timeUnit) {
            this.endTime = TimeUnit.MILLISECONDS.convert(j3, timeUnit);
            return this;
        }

        public Builder setSectionDataList(List<SamplePoint> list) {
            this.sectionDataList.addAll(list);
            return this;
        }

        public Builder setSectionNum(int i3) {
            this.sectionNum = i3;
            return this;
        }

        public Builder setSectionTime(long j3, TimeUnit timeUnit) {
            this.sectionTime = TimeUnit.SECONDS.convert(j3, timeUnit);
            return this;
        }

        public Builder setStartTime(long j3, TimeUnit timeUnit) {
            this.startTime = TimeUnit.MILLISECONDS.convert(j3, timeUnit);
            return this;
        }
    }

    public SampleSection() {
        this.sectionDataList = new ArrayList();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SampleSection)) {
            return false;
        }
        SampleSection sampleSection = (SampleSection) obj;
        if (this.sectionNum == sampleSection.getSectionNum() && this.sectionTime == sampleSection.getSectionTime(TimeUnit.SECONDS)) {
            long j3 = this.startTime;
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            if (j3 == sampleSection.getStartTime(timeUnit) && this.endTime == sampleSection.getEndTime(timeUnit) && Objects.equals(this.sectionDataList, sampleSection.getSectionDataList())) {
                return true;
            }
        }
        return false;
    }

    public long getEndTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.endTime, TimeUnit.MILLISECONDS);
    }

    public List<SamplePoint> getSectionDataList() {
        return this.sectionDataList;
    }

    public int getSectionNum() {
        return this.sectionNum;
    }

    public long getSectionTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.sectionTime, TimeUnit.SECONDS);
    }

    public long getStartTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.startTime, TimeUnit.MILLISECONDS);
    }

    public int hashCode() {
        return com.huawei.hms.common.internal.Objects.hashCode(Integer.valueOf(this.sectionNum), Long.valueOf(this.sectionTime), Long.valueOf(this.startTime), Long.valueOf(this.endTime), this.sectionDataList);
    }

    public String toString() {
        StringBuilder aab2 = com.huawei.hms.health.aab.aab("SampleSection{sectionNum = ");
        aab2.append(this.sectionNum);
        aab2.append(", sectionTime = ");
        aab2.append(this.sectionTime);
        aab2.append(", startTime = ");
        aab2.append(this.startTime);
        aab2.append(", endTime = ");
        aab2.append(this.endTime);
        aab2.append(", sectionDataList = ");
        aab2.append(this.sectionDataList);
        aab2.append("}");
        return aab2.toString();
    }

    @aabw
    SampleSection(@aabv(id = 1) int i3, @aabv(id = 2) long j3, @aabv(id = 3) long j16, @aabv(id = 4) long j17, @aabv(id = 5) List<SamplePoint> list) {
        this.sectionNum = i3;
        this.sectionTime = j3;
        this.startTime = j16;
        this.endTime = j17;
        this.sectionDataList = list;
    }
}
