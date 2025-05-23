package com.huawei.hms.hihealth.options;

import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.huawei.hms.common.internal.Objects;
import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.health.aabq;
import com.huawei.hms.health.aabv;
import com.huawei.hms.health.aabw;
import com.huawei.hms.health.aaby;
import com.huawei.hms.health.aabz;
import com.huawei.hms.health.aac;
import com.huawei.hms.hihealth.HiHealthStatusCodes;
import com.huawei.hms.hihealth.data.HealthRecord;

/* compiled from: P */
/* loaded from: classes2.dex */
public class HealthRecordInsertOptions extends aabq {
    public static final Parcelable.Creator<HealthRecordInsertOptions> CREATOR = new aabq.aab(HealthRecordInsertOptions.class);

    @aaby(id = 1)
    private final HealthRecord mHealthRecord;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class Builder {
        private HealthRecord aab;

        public HealthRecordInsertOptions build() {
            boolean z16;
            if (this.aab != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            Preconditions.checkState(z16, "health record should not be null.");
            if (aac.aab(this.aab.getDataCollector().getDataType().getName())) {
                return new HealthRecordInsertOptions(this.aab);
            }
            aabz.aab("build HealthRecordInsertOptions", "The input datatype is not supported by the health record type.");
            throw new SecurityException(String.valueOf(HiHealthStatusCodes.HEALTH_RECORDS_NOT_SUPPORT));
        }

        public Builder setHealthRecord(HealthRecord healthRecord) {
            this.aab = healthRecord;
            return this;
        }
    }

    @aabw
    HealthRecordInsertOptions(@aabv(id = 1) HealthRecord healthRecord) {
        this.mHealthRecord = healthRecord;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (!(obj instanceof HealthRecordInsertOptions)) {
                return false;
            }
            return Objects.equal(this.mHealthRecord, ((HealthRecordInsertOptions) obj).mHealthRecord);
        }
        return true;
    }

    public HealthRecord getInsertHealthRecord() {
        return this.mHealthRecord;
    }

    public int hashCode() {
        return Objects.hashCode(this.mHealthRecord);
    }

    @NonNull
    public String toString() {
        return Objects.toStringHelper(this).add("healthRecord", this.mHealthRecord).toString();
    }
}
