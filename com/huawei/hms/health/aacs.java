package com.huawei.hms.health;

import android.os.IInterface;
import com.huawei.hmf.tasks.Task;
import com.huawei.hmf.tasks.Tasks;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.hihealth.HiHealthKitClient;
import com.huawei.hms.support.api.client.Status;
import java.util.concurrent.Callable;

/* compiled from: P */
/* loaded from: classes2.dex */
public class aacs {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class aab<T> implements Callable<T> {
        private Callable<T> aab;

        aab(Callable<T> callable) {
            this.aab = callable;
        }

        @Override // java.util.concurrent.Callable
        public T call() throws Exception {
            try {
                return this.aab.call();
            } finally {
                aacs.aab();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class aaba<T> implements Callable<T> {
        private int aab;
        private Callable<T> aaba;

        aaba(int i3, Callable<T> callable) {
            this.aab = i3;
            this.aaba = callable;
        }

        @Override // java.util.concurrent.Callable
        public T call() throws Exception {
            try {
                aacs.aab(this.aab);
                return this.aaba.call();
            } finally {
                aacs.aab();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    static class aabb<T> implements Callable<T> {
        private int aab;
        private Callable<T> aaba;

        aabb(int i3, Callable<T> callable) {
            this.aab = i3;
            this.aaba = callable;
        }

        @Override // java.util.concurrent.Callable
        public T call() throws Exception {
            try {
                if (HiHealthKitClient.getInstance().bindServiceWithOutCheckEmui(this.aab) != null) {
                    return this.aaba.call();
                }
                throw new ApiException(new Status(50011, "the client is not connected"));
            } finally {
                aacs.aab();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class aabc<T> implements Callable<T> {
        private int aab;
        private Callable<T> aaba;

        aabc(int i3, Callable<T> callable) {
            this.aab = i3;
            this.aaba = callable;
        }

        @Override // java.util.concurrent.Callable
        public T call() throws Exception {
            aacs.aab(this.aab);
            return this.aaba.call();
        }
    }

    public static <T> Task<T> aab(int i3, Callable<T> callable) {
        return Tasks.callInBackground(new aaba(i3, callable));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> Task<T> aaba(int i3, Callable<T> callable) {
        return Tasks.callInBackground(new aabb(i3, callable));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> Task<T> aabb(int i3, Callable<T> callable) {
        return Tasks.callInBackground(new aabc(i3, callable));
    }

    public static <T> Task<T> aab(Callable<T> callable) {
        return Tasks.callInBackground(new aab(callable));
    }

    static /* synthetic */ IInterface aab(int i3) throws ApiException {
        IInterface bindService = HiHealthKitClient.getInstance().bindService(i3);
        if (bindService != null) {
            return bindService;
        }
        throw new ApiException(new Status(50011, "the client is not connected"));
    }

    static /* synthetic */ void aab() {
        HiHealthKitClient.getInstance().delayedDisconnect();
    }
}
