package com.huawei.hms.hihealth.result;

import com.huawei.hms.hihealth.data.HealthRecord;
import java.util.List;

/* compiled from: P */
/* loaded from: classes2.dex */
public class HealthRecordReply extends aab<HealthRecordResult> {
    public List<HealthRecord> getHealthRecords() {
        return getResult().getHealthRecords();
    }
}
