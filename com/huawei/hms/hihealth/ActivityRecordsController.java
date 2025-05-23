package com.huawei.hms.hihealth;

import android.app.PendingIntent;
import android.content.ComponentName;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.huawei.hmf.tasks.Task;
import com.huawei.hms.health.aabz;
import com.huawei.hms.health.aace;
import com.huawei.hms.health.aacv;
import com.huawei.hms.hihealth.data.ActivityRecord;
import com.huawei.hms.hihealth.data.ComponentInfo;
import com.huawei.hms.hihealth.options.ActivityRecordDeleteOptions;
import com.huawei.hms.hihealth.options.ActivityRecordInsertOptions;
import com.huawei.hms.hihealth.options.ActivityRecordReadOptions;
import com.huawei.hms.hihealth.options.OnActivityRecordListener;
import com.huawei.hms.hihealth.result.ActivityRecordReply;
import com.huawei.hms.support.hwid.result.AuthHuaweiId;
import java.util.List;

/* compiled from: P */
/* loaded from: classes2.dex */
public class ActivityRecordsController {
    private aabd aab;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ActivityRecordsController() {
        this.aab = null;
        this.aab = aace.aaba();
    }

    public Task<Void> addActivityRecord(ActivityRecordInsertOptions activityRecordInsertOptions) {
        return ((aace) this.aab).aab(activityRecordInsertOptions);
    }

    @Deprecated
    public Task<Void> addActivityRecordsMonitor(PendingIntent pendingIntent) {
        ((aace) this.aab).aab(pendingIntent);
        throw null;
    }

    public Task<Void> beginActivityRecord(ActivityRecord activityRecord) {
        return ((aace) this.aab).aab(activityRecord);
    }

    public Task<Void> continueActivityRecord(String str) {
        return ((aace) this.aab).aab(str);
    }

    public Task<Void> deleteActivityRecord(ActivityRecordDeleteOptions activityRecordDeleteOptions) {
        return ((aace) this.aab).aab(activityRecordDeleteOptions);
    }

    public Task<List<ActivityRecord>> endActivityRecord(@Nullable String str) {
        return ((aace) this.aab).aaba(str);
    }

    public Task<ActivityRecordReply> getActivityRecord(ActivityRecordReadOptions activityRecordReadOptions) {
        return aabz.aab(((aace) this.aab).aab(activityRecordReadOptions), new aacv());
    }

    public Task<ComponentInfo> queryWorkoutComponentInfo() {
        return ((aace) this.aab).aab();
    }

    @Deprecated
    public Task<Void> removeActivityRecordsMonitor(PendingIntent pendingIntent) {
        ((aace) this.aab).aaba(pendingIntent);
        throw null;
    }

    @Deprecated
    public ActivityRecordsController(@NonNull AuthHuaweiId authHuaweiId) {
        this.aab = null;
        this.aab = aace.aaba();
    }

    public Task<Void> beginActivityRecord(ActivityRecord activityRecord, ComponentName componentName, OnActivityRecordListener onActivityRecordListener) {
        return ((aace) this.aab).aab(activityRecord, componentName, onActivityRecordListener);
    }
}
