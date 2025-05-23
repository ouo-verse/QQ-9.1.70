package com.huawei.hms.hihealth.options;

import android.os.Parcelable;
import com.huawei.hms.common.internal.Objects;
import com.huawei.hms.health.aabq;
import com.huawei.hms.health.aabv;
import com.huawei.hms.health.aabw;
import com.huawei.hms.health.aaby;
import com.huawei.hms.hihealth.data.DataType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: P */
/* loaded from: classes2.dex */
public class DataCollectorsOptions extends aabq {
    public static final Parcelable.Creator<DataCollectorsOptions> CREATOR = new aabq.aab(DataCollectorsOptions.class);

    @aaby(id = 1)
    private final List<DataType> aab;

    @aaby(id = 2)
    private final List<Integer> aaba;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class Builder {
        private DataType[] aab = new DataType[0];
        private int[] aaba = {0, 1};

        public DataCollectorsOptions build() {
            return new DataCollectorsOptions(this, (aab) null);
        }

        public Builder setDataCollectorTypes(int... iArr) {
            this.aaba = iArr;
            return this;
        }

        public Builder setDataTypes(DataType... dataTypeArr) {
            this.aab = dataTypeArr;
            return this;
        }
    }

    @aabw
    DataCollectorsOptions(@aabv(id = 1) List<DataType> list, @aabv(id = 2) List<Integer> list2) {
        this.aab = list;
        this.aaba = list2;
    }

    public List<Integer> getDataCollectorTypes() {
        return this.aaba;
    }

    public List<DataType> getDataTypes() {
        return this.aab;
    }

    public String toString() {
        return Objects.toStringHelper(this).add("dataTypes", this.aab).add("dataCollectorTypes", this.aaba).toString();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    /* synthetic */ DataCollectorsOptions(Builder builder, aab aabVar) {
        this(r6, r0);
        ArrayList arrayList = new ArrayList(Arrays.asList(builder.aab));
        int[] iArr = builder.aaba;
        ArrayList arrayList2 = new ArrayList(iArr.length);
        for (int i3 : iArr) {
            arrayList2.add(Integer.valueOf(i3));
        }
    }
}
