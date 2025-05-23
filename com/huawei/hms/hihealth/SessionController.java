package com.huawei.hms.hihealth;

import com.huawei.hmf.tasks.Task;
import com.huawei.hms.health.aacp;
import com.huawei.hms.hihealth.options.ActivityBeginOptions;
import com.huawei.hms.hihealth.options.OnBeginActivityListener;

/* compiled from: P */
/* loaded from: classes2.dex */
public class SessionController {
    private aabp aab;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SessionController() {
        this.aab = null;
        this.aab = aacp.aabd();
    }

    public Task<Integer> beginActivity(ActivityBeginOptions activityBeginOptions, OnBeginActivityListener onBeginActivityListener) {
        return ((aacp) this.aab).aab(activityBeginOptions, onBeginActivityListener);
    }

    public Task<Void> endActivity() {
        return ((aacp) this.aab).aab();
    }

    public Task<Void> keepActivity() {
        return ((aacp) this.aab).aaba();
    }

    public Task<Void> pauseActivity() {
        return ((aacp) this.aab).aabb();
    }

    public Task<Void> resumeActivity() {
        return ((aacp) this.aab).aabc();
    }
}
