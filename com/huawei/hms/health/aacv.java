package com.huawei.hms.health;

import com.huawei.hms.hihealth.result.ActivityRecordReply;
import com.huawei.hms.hihealth.result.ActivityRecordResult;
import com.huawei.hms.support.api.client.Status;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class aacv<T> implements aacz<T> {
    private ActivityRecordReply aab = new ActivityRecordReply();

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.huawei.hms.health.aacz
    public com.huawei.hms.hihealth.result.aab aab(T t16) {
        Status status;
        ActivityRecordResult activityRecordResult;
        ActivityRecordReply activityRecordReply;
        if (t16 instanceof ActivityRecordResult) {
            activityRecordReply = this.aab;
            activityRecordResult = (ActivityRecordResult) t16;
        } else {
            if (t16 instanceof Exception) {
                status = aabz.aab(((Exception) t16).getMessage());
            } else {
                status = Status.FAILURE;
            }
            activityRecordResult = ActivityRecordResult.getActivityRecordResult(status);
            activityRecordReply = this.aab;
        }
        activityRecordReply.setResult(activityRecordResult);
        return this.aab;
    }
}
