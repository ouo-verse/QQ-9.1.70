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
public class HealthRecordUpdateOptions extends aabq {
    public static final Parcelable.Creator<HealthRecordUpdateOptions> CREATOR = new aabq.aab(HealthRecordUpdateOptions.class);

    @aaby(id = 1)
    private final HealthRecord mHealthRecord;

    @aaby(id = 2)
    private final String mHealthRecordId;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class Builder {
        private HealthRecord aab;
        private String aaba;

        public HealthRecordUpdateOptions build() {
            boolean z16;
            String str = this.aaba;
            boolean z17 = true;
            if (str != null && str.length() != 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            Preconditions.checkArgument(z16, "health record id should not be null.");
            if (this.aab == null) {
                z17 = false;
            }
            Preconditions.checkState(z17, "health record should not be null.");
            if (aac.aab(this.aab.getDataCollector().getDataType().getName())) {
                return new HealthRecordUpdateOptions(this.aab, this.aaba);
            }
            aabz.aab("build HealthRecordUpdateOptions", "The input datatype is not supported by the health record type.");
            throw new SecurityException(String.valueOf(HiHealthStatusCodes.HEALTH_RECORDS_NOT_SUPPORT));
        }

        public Builder setHealthRecord(HealthRecord healthRecord) {
            this.aab = healthRecord;
            return this;
        }

        public Builder setHealthRecordId(String str) {
            this.aaba = str;
            return this;
        }
    }

    @aabw
    HealthRecordUpdateOptions(@aabv(id = 1) HealthRecord healthRecord, @aabv(id = 2) String str) {
        this.mHealthRecord = healthRecord;
        this.mHealthRecordId = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HealthRecordUpdateOptions)) {
            return false;
        }
        HealthRecordUpdateOptions healthRecordUpdateOptions = (HealthRecordUpdateOptions) obj;
        if (Objects.equal(this.mHealthRecord, healthRecordUpdateOptions.mHealthRecord) && Objects.equal(this.mHealthRecordId, healthRecordUpdateOptions.mHealthRecordId)) {
            return true;
        }
        return false;
    }

    public HealthRecord getUpdateHealthRecord() {
        return this.mHealthRecord;
    }

    public String getUpdateHealthRecordId() {
        return this.mHealthRecordId;
    }

    public int hashCode() {
        return Objects.hashCode(this.mHealthRecord, this.mHealthRecordId);
    }

    @NonNull
    public String toString() {
        return Objects.toStringHelper(this).add("healthRecord", this.mHealthRecord).add("healthRecordId", this.mHealthRecordId).toString();
    }
}
