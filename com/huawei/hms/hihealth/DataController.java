package com.huawei.hms.hihealth;

import android.app.PendingIntent;
import androidx.annotation.NonNull;
import com.huawei.hmf.tasks.Task;
import com.huawei.hms.health.aabz;
import com.huawei.hms.health.aacl;
import com.huawei.hms.health.aacw;
import com.huawei.hms.hihealth.data.DataCollector;
import com.huawei.hms.hihealth.data.DataType;
import com.huawei.hms.hihealth.data.SamplePoint;
import com.huawei.hms.hihealth.data.SampleSet;
import com.huawei.hms.hihealth.options.DataCollectorsOptions;
import com.huawei.hms.hihealth.options.DeleteOptions;
import com.huawei.hms.hihealth.options.ModifyDataMonitorOptions;
import com.huawei.hms.hihealth.options.ReadOptions;
import com.huawei.hms.hihealth.options.UpdateOptions;
import com.huawei.hms.hihealth.result.ReadReply;
import com.huawei.hms.support.hwid.result.AuthHuaweiId;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes2.dex */
public class DataController {
    private aabm aab;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DataController() {
        this.aab = null;
        this.aab = aacl.aabb();
    }

    public Task<Void> clearAll() {
        return ((aacl) this.aab).aab();
    }

    public Task<Void> delete(DeleteOptions deleteOptions) {
        return ((aacl) this.aab).aab(deleteOptions);
    }

    @Deprecated
    public Task<List<DataCollector>> getDataCollectors(@NonNull DataCollectorsOptions dataCollectorsOptions) {
        ((aacl) this.aab).aab(dataCollectorsOptions);
        throw null;
    }

    public Task<Void> insert(SampleSet sampleSet) {
        return ((aacl) this.aab).aab(sampleSet);
    }

    public Task<ReadReply> read(ReadOptions readOptions) {
        return aabz.aab(((aacl) this.aab).aab(readOptions), new aacw());
    }

    public Task<SampleSet> readDailySummation(DataType dataType, int i3, int i16) {
        return ((aacl) this.aab).aab(dataType, i3, i16);
    }

    public Task<Map<DataType, SamplePoint>> readLatestData(List<DataType> list) {
        return ((aacl) this.aab).aab(list);
    }

    public Task<SampleSet> readTodaySummation(DataType dataType) {
        return ((aacl) this.aab).aab(dataType);
    }

    @Deprecated
    public Task<SampleSet> readTodaySummationFromDevice(DataType dataType) {
        ((aacl) this.aab).aaba(dataType);
        throw null;
    }

    @Deprecated
    public Task<Void> registerModifyDataMonitor(ModifyDataMonitorOptions modifyDataMonitorOptions) {
        ((aacl) this.aab).aab(modifyDataMonitorOptions);
        throw null;
    }

    @Deprecated
    public Task<Void> syncAll() {
        return ((aacl) this.aab).aaba();
    }

    @Deprecated
    public Task<Void> unregisterModifyDataMonitor(PendingIntent pendingIntent) {
        ((aacl) this.aab).aab(pendingIntent);
        throw null;
    }

    public Task<Void> update(UpdateOptions updateOptions) {
        return ((aacl) this.aab).aab(updateOptions);
    }

    @Deprecated
    public DataController(@NonNull AuthHuaweiId authHuaweiId) {
        this.aab = null;
        this.aab = aacl.aabb();
    }

    public Task<List<SampleSet>> readDailySummation(List<DataType> list, int i3, int i16) {
        return ((aacl) this.aab).aab(list, i3, i16);
    }

    public Task<List<SampleSet>> readTodaySummation(List<DataType> list) {
        return ((aacl) this.aab).aaba(list);
    }
}
