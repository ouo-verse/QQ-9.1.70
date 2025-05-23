package com.huawei.hms.hihealth;

import android.os.Bundle;
import android.util.SparseArray;
import androidx.annotation.NonNull;
import com.huawei.hms.common.internal.Objects;
import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.hihealth.data.DataType;
import com.huawei.hms.support.api.entity.auth.Scope;
import com.huawei.hms.support.hwid.request.HuaweiIdAuthExtendedParams;
import com.huawei.hms.support.hwid.result.AuthHuaweiId;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/* compiled from: P */
@Deprecated
/* loaded from: classes2.dex */
public class HiHealthOptions implements HuaweiIdAuthExtendedParams {
    public static final int ACCESS_READ = 0;
    public static final int ACCESS_WRITE = 1;
    private final Set<Scope> aab;
    private final SparseArray<List<DataType>> aaba;
    private final AuthHuaweiId aabb;

    /* compiled from: P */
    @Deprecated
    /* loaded from: classes2.dex */
    public static class Builder {
        private final SparseArray<List<DataType>> aab = new SparseArray<>();
        private AuthHuaweiId aaba;

        Builder() {
        }

        static /* synthetic */ Builder aab(Builder builder, AuthHuaweiId authHuaweiId) {
            builder.aaba = authHuaweiId;
            return builder;
        }

        public final Builder addDataType(@NonNull DataType dataType) {
            return addDataType(dataType, 0);
        }

        public final HiHealthOptions build() {
            return new HiHealthOptions(this.aab, this.aaba, null);
        }

        /* synthetic */ Builder(aab aabVar) {
        }

        public final Builder addDataType(@NonNull DataType dataType, int i3) {
            boolean z16 = true;
            if (i3 != 0 && i3 != 1) {
                z16 = false;
            }
            Preconditions.checkArgument(z16, "NOT valid access type");
            List<DataType> list = this.aab.get(i3);
            if (list == null) {
                list = new ArrayList<>();
                this.aab.put(i3, list);
            }
            list.add(dataType);
            return this;
        }
    }

    /* synthetic */ HiHealthOptions(SparseArray sparseArray, AuthHuaweiId authHuaweiId, aab aabVar) {
        Scope scope;
        this.aaba = sparseArray;
        this.aabb = authHuaweiId;
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < sparseArray.size(); i3++) {
            int keyAt = sparseArray.keyAt(i3);
            for (DataType dataType : (List) sparseArray.valueAt(i3)) {
                if (keyAt == 0 && dataType.getScopeNameRead() != null) {
                    scope = new Scope(dataType.getScopeNameRead());
                } else {
                    scope = (keyAt == 1 && dataType.getScopeNameBoth() != null) ? new Scope(dataType.getScopeNameBoth()) : scope;
                }
                arrayList.add(scope);
            }
        }
        this.aab = aabs.aab(arrayList);
    }

    public static Builder builder() {
        return new Builder(null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || HiHealthOptions.class != obj.getClass() || !(obj instanceof HiHealthOptions)) {
            return false;
        }
        HiHealthOptions hiHealthOptions = (HiHealthOptions) obj;
        if (Objects.equal(this.aaba, hiHealthOptions.aaba) && Objects.equal(this.aabb, hiHealthOptions.aabb)) {
            return true;
        }
        return false;
    }

    @Override // com.huawei.hms.support.feature.request.AuthExtendedParams
    public Bundle getExtendedBundle() {
        return new Bundle();
    }

    @Override // com.huawei.hms.support.feature.request.AuthExtendedParams
    public int getExtendedParamType() {
        return 1;
    }

    @Override // com.huawei.hms.support.feature.request.AuthExtendedParams
    public List<Scope> getExtendedScopes() {
        return new ArrayList(this.aab);
    }

    public int hashCode() {
        return Objects.hashCode(this.aaba, this.aabb);
    }

    public static Builder builder(AuthHuaweiId authHuaweiId) {
        aab aabVar = null;
        return authHuaweiId != null ? Builder.aab(new Builder(aabVar), authHuaweiId) : new Builder(aabVar);
    }
}
