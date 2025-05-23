package com.huawei.hms.hihealth;

import androidx.annotation.NonNull;
import com.huawei.hmf.tasks.Task;
import com.huawei.hms.health.aach;
import com.huawei.hms.hihealth.data.DataCollector;
import com.huawei.hms.hihealth.data.DataType;
import com.huawei.hms.hihealth.data.Record;
import com.huawei.hms.hihealth.options.OnSamplePointListener;
import com.huawei.hms.support.hwid.result.AuthHuaweiId;
import java.util.List;

/* compiled from: P */
/* loaded from: classes2.dex */
public class AutoRecorderController {
    private aabf aab;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoRecorderController() {
        this.aab = null;
        this.aab = aach.aaba();
    }

    @Deprecated
    public Task<List<Record>> getRecords() {
        return ((aach) this.aab).aab();
    }

    @Deprecated
    public Task<Void> startRecord(DataCollector dataCollector) {
        return ((aach) this.aab).aab(dataCollector);
    }

    @Deprecated
    public Task<Void> stopRecord(DataCollector dataCollector) {
        return ((aach) this.aab).aaba(dataCollector);
    }

    @Deprecated
    public AutoRecorderController(@NonNull AuthHuaweiId authHuaweiId) {
        this.aab = null;
        this.aab = aach.aaba();
    }

    @Deprecated
    public Task<List<Record>> getRecords(DataType dataType) {
        return ((aach) this.aab).aab(dataType);
    }

    @Deprecated
    public Task<Void> startRecord(DataType dataType) {
        return ((aach) this.aab).aaba(dataType);
    }

    @Deprecated
    public Task<Void> stopRecord(DataType dataType) {
        return ((aach) this.aab).aabb(dataType);
    }

    public Task<Void> startRecord(DataType dataType, OnSamplePointListener onSamplePointListener) {
        return ((aach) this.aab).aab(dataType, onSamplePointListener);
    }

    public Task<Void> stopRecord(DataType dataType, OnSamplePointListener onSamplePointListener) {
        return ((aach) this.aab).aaba(dataType, onSamplePointListener);
    }

    @Deprecated
    public Task<Void> stopRecord(Record record) {
        return ((aach) this.aab).aab(record);
    }
}
