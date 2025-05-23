package com.huawei.hms.hihealth;

import android.content.Intent;
import androidx.annotation.NonNull;
import com.huawei.hmf.tasks.Task;
import com.huawei.hms.health.aacr;
import com.huawei.hms.hihealth.data.DataType;
import com.huawei.hms.hihealth.options.DataTypeAddOptions;
import com.huawei.hms.hihealth.result.HealthKitAuthResult;
import com.huawei.hms.support.hwid.result.AuthHuaweiId;

/* compiled from: P */
/* loaded from: classes2.dex */
public class SettingController {
    private aabq aab;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SettingController() {
        this.aab = null;
        this.aab = aacr.aabg();
    }

    public Task<DataType> addDataType(DataTypeAddOptions dataTypeAddOptions) {
        return ((aacr) this.aab).aab(dataTypeAddOptions);
    }

    @Deprecated
    public Task<Void> checkHealthAppAuthorisation() {
        return checkHealthAppAuthorization();
    }

    public Task<Void> checkHealthAppAuthorization() {
        return ((aacr) this.aab).aab();
    }

    public Task<Void> disableHiHealth() {
        return ((aacr) this.aab).aaba();
    }

    public Task<String> getAuthUrl() {
        return ((aacr) this.aab).aabb();
    }

    @Deprecated
    public Task<Boolean> getHealthAppAuthorisation() {
        return getHealthAppAuthorization();
    }

    public Task<Boolean> getHealthAppAuthorization() {
        return ((aacr) this.aab).aabc();
    }

    public Task<Boolean> getLinkHealthKitStatus() {
        return ((aacr) this.aab).aabe();
    }

    @Deprecated
    public Boolean isAppInTrustList(String str) {
        return ((aacr) this.aab).aab(str);
    }

    public boolean openAuthFromCloud() {
        return ((aacr) this.aab).aabf();
    }

    public HealthKitAuthResult parseHealthKitAuthResultFromIntent(Intent intent) {
        return ((aacr) this.aab).aab(intent);
    }

    public Task<DataType> readDataType(String str) {
        return ((aacr) this.aab).aaba(str);
    }

    public Intent requestAuthorizationIntent(String[] strArr, boolean z16) {
        return ((aacr) this.aab).aab(strArr, z16);
    }

    public Task<Boolean> setLinkHealthKitStatus(boolean z16) {
        return ((aacr) this.aab).aab(z16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Deprecated
    public SettingController(@NonNull AuthHuaweiId authHuaweiId) {
        this.aab = null;
        this.aab = aacr.aabg();
    }
}
