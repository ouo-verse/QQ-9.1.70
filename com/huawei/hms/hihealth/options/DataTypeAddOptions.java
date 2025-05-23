package com.huawei.hms.hihealth.options;

import android.os.Parcelable;
import com.huawei.hms.common.internal.Objects;
import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.health.aabq;
import com.huawei.hms.health.aabv;
import com.huawei.hms.health.aabw;
import com.huawei.hms.health.aaby;
import com.huawei.hms.hihealth.data.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: P */
/* loaded from: classes2.dex */
public class DataTypeAddOptions extends aabq {
    public static final Parcelable.Creator<DataTypeAddOptions> CREATOR = new aabq.aab(DataTypeAddOptions.class);

    @aaby(id = 1)
    private final String aab;

    @aaby(id = 2)
    private final List<Field> aaba;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class Builder {
        private String aab;
        private List<Field> aaba = new ArrayList();

        public Builder addField(Field field) {
            if (!this.aaba.contains(field)) {
                this.aaba.add(field);
            }
            return this;
        }

        public DataTypeAddOptions build() {
            boolean z16;
            if (this.aab != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            Preconditions.checkState(z16, "The name of the new data type should not be null");
            Preconditions.checkState(!this.aaba.isEmpty(), "The data fields of the new data type should not be empty");
            return new DataTypeAddOptions(this);
        }

        public Builder setName(String str) {
            this.aab = str;
            return this;
        }

        public Builder addField(String str, int i3) {
            Field newIntField;
            Preconditions.checkArgument((str == null || str.isEmpty()) ? false : true, "Invalid field name");
            Preconditions.checkArgument(i3 == 1 || i3 == 2 || i3 == 3 || i3 == 4, "Invalid field format");
            if (i3 == 1) {
                newIntField = Field.newIntField(str);
            } else if (i3 == 2) {
                newIntField = Field.newDoubleField(str);
            } else if (i3 != 3) {
                newIntField = i3 != 4 ? null : Field.newMapField(str);
            } else {
                newIntField = Field.newStringField(str);
            }
            return addField(newIntField);
        }
    }

    @aabw
    DataTypeAddOptions(@aabv(id = 1) String str, @aabv(id = 2) List<Field> list) {
        this.aab = str;
        this.aaba = Collections.unmodifiableList(list);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DataTypeAddOptions)) {
            return false;
        }
        DataTypeAddOptions dataTypeAddOptions = (DataTypeAddOptions) obj;
        if (Objects.equal(this.aab, dataTypeAddOptions.aab) && Objects.equal(this.aaba, dataTypeAddOptions.aaba)) {
            return true;
        }
        return false;
    }

    public List<Field> getFields() {
        return this.aaba;
    }

    public String getName() {
        return this.aab;
    }

    public int hashCode() {
        return Objects.hashCode(this.aab, this.aaba);
    }

    public String toString() {
        return Objects.toStringHelper(this).add("name", this.aab).add("fields", this.aaba).toString();
    }
}
