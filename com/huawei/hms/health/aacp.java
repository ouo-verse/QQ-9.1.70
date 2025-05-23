package com.huawei.hms.health;

import com.huawei.hmf.tasks.Task;
import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.hihealth.options.ActivityBeginOptions;
import com.huawei.hms.hihealth.options.OnBeginActivityListener;
import java.util.concurrent.Callable;

/* compiled from: P */
/* loaded from: classes2.dex */
public class aacp implements com.huawei.hms.hihealth.aabp {
    private static volatile aacp aab;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    class aab implements Callable<Void> {
        aab(aacp aacpVar) {
        }

        @Override // java.util.concurrent.Callable
        public Void call() throws Exception {
            aack.aabf().aabd().aabl();
            return null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    class aaba implements Callable<Void> {
        aaba(aacp aacpVar) {
        }

        @Override // java.util.concurrent.Callable
        public Void call() throws Exception {
            aack.aabf().aabd().aabc();
            return null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    class aabb implements Callable<Void> {
        aabb(aacp aacpVar) {
        }

        @Override // java.util.concurrent.Callable
        public Void call() throws Exception {
            aack.aabf().aabd().aabg();
            return null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    class aabc implements Callable<Void> {
        aabc(aacp aacpVar) {
        }

        @Override // java.util.concurrent.Callable
        public Void call() throws Exception {
            aack.aabf().aabd().aabd();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class aabd implements Callable<Integer> {
        private final ActivityBeginOptions aab;
        private final OnBeginActivityListener aaba;

        public aabd(aacp aacpVar, ActivityBeginOptions activityBeginOptions, OnBeginActivityListener onBeginActivityListener) {
            this.aab = activityBeginOptions;
            this.aaba = onBeginActivityListener;
        }

        @Override // java.util.concurrent.Callable
        public Integer call() throws Exception {
            return Integer.valueOf(aack.aabf().aabd().aab(new ActivityBeginOptions.Builder(this.aab.getActivityType()).setAppType("Android").build(), new aacq(this)));
        }
    }

    public static aacp aabd() {
        if (aab == null) {
            synchronized (aace.class) {
                if (aab == null) {
                    aab = new aacp();
                }
            }
        }
        return aab;
    }

    public Task<Void> aab() {
        return aacs.aab(10, new aabc(this));
    }

    public Task<Void> aaba() {
        return aacs.aabb(10, new aabb(this));
    }

    public Task<Void> aabb() {
        return aacs.aabb(10, new aab(this));
    }

    public Task<Void> aabc() {
        return aacs.aabb(10, new aaba(this));
    }

    public Task<Integer> aab(ActivityBeginOptions activityBeginOptions, OnBeginActivityListener onBeginActivityListener) {
        Preconditions.checkNotNull(activityBeginOptions, "activityBeginOptions cannot be null.");
        return aacs.aabb(10, new aabd(this, activityBeginOptions, onBeginActivityListener));
    }
}
