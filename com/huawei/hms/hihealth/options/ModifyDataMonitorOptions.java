package com.huawei.hms.hihealth.options;

import android.app.PendingIntent;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.huawei.hms.common.internal.Objects;
import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.health.aabq;
import com.huawei.hms.health.aabv;
import com.huawei.hms.health.aabw;
import com.huawei.hms.health.aaby;
import com.huawei.hms.hihealth.data.DataCollector;
import com.huawei.hms.hihealth.data.DataType;

/* compiled from: P */
/* loaded from: classes2.dex */
public class ModifyDataMonitorOptions extends aabq {
    public static final Parcelable.Creator<ModifyDataMonitorOptions> CREATOR = new aabq.aab(ModifyDataMonitorOptions.class);

    @aaby(id = 1)
    private final PendingIntent aab;

    @aaby(id = 2)
    private DataType aaba;

    @aaby(id = 3)
    private DataCollector aabb;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class Builder {
        private PendingIntent aab;
        private DataType aaba;
        private DataCollector aabb;

        public ModifyDataMonitorOptions build() {
            boolean z16;
            if (this.aabb == null && this.aaba == null) {
                z16 = false;
            } else {
                z16 = true;
            }
            Preconditions.checkState(z16, "Set at least one of DataCollector or DataType");
            Preconditions.checkNotNull(this.aab, "Must set the PendingIntent");
            return new ModifyDataMonitorOptions(this);
        }

        public Builder setModifyDataCollector(DataCollector dataCollector) throws NullPointerException {
            Preconditions.checkNotNull(dataCollector);
            this.aabb = dataCollector;
            return this;
        }

        public Builder setModifyDataIntent(PendingIntent pendingIntent) {
            Preconditions.checkNotNull(pendingIntent);
            this.aab = pendingIntent;
            return this;
        }

        public Builder setModifyDataType(DataType dataType) {
            Preconditions.checkNotNull(dataType);
            this.aaba = dataType;
            return this;
        }
    }

    @aabw
    ModifyDataMonitorOptions(@aabv(id = 1) PendingIntent pendingIntent, @aabv(id = 2) DataType dataType, @aabv(id = 3) DataCollector dataCollector) {
        this.aabb = dataCollector;
        this.aaba = dataType;
        this.aab = pendingIntent;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ModifyDataMonitorOptions)) {
            return false;
        }
        ModifyDataMonitorOptions modifyDataMonitorOptions = (ModifyDataMonitorOptions) obj;
        if (Objects.equal(this.aab, modifyDataMonitorOptions.aab) && Objects.equal(this.aabb, modifyDataMonitorOptions.aabb) && Objects.equal(this.aaba, modifyDataMonitorOptions.aaba)) {
            return true;
        }
        return false;
    }

    public DataCollector getModifyDataCollector() {
        return this.aabb;
    }

    @Nullable
    public PendingIntent getModifyDataIntent() {
        return this.aab;
    }

    public DataType getModifyDataType() {
        return this.aaba;
    }

    public int hashCode() {
        return Objects.hashCode(this.aab, this.aaba, this.aabb);
    }

    public String toString() {
        return Objects.toStringHelper(this).add("pendingIntent", this.aab).add("dataType", this.aaba).add("dataCollector", this.aabb).toString();
    }
}
