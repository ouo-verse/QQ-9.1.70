package com.huawei.hms.health;

import com.huawei.hms.hihealth.result.HealthRecordReply;
import com.huawei.hms.hihealth.result.HealthRecordResult;
import com.huawei.hms.support.api.client.Status;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class aacy<T> implements aacz<T> {
    private HealthRecordReply aab = new HealthRecordReply();

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.huawei.hms.health.aacz
    public com.huawei.hms.hihealth.result.aab aab(T t16) {
        Status status;
        HealthRecordResult healthRecordResult;
        HealthRecordReply healthRecordReply;
        if (t16 instanceof HealthRecordResult) {
            healthRecordReply = this.aab;
            healthRecordResult = (HealthRecordResult) t16;
        } else {
            if (t16 instanceof Exception) {
                status = aabz.aab(((Exception) t16).getMessage());
            } else {
                status = Status.FAILURE;
            }
            healthRecordResult = HealthRecordResult.getHealthRecordResult(status);
            healthRecordReply = this.aab;
        }
        healthRecordReply.setResult(healthRecordResult);
        return this.aab;
    }
}
