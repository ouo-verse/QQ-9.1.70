package com.huawei.hms.health;

import android.os.RemoteException;
import com.huawei.hmf.tasks.Task;
import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.hihealth.HiHealthStatusCodes;
import com.huawei.hms.hihealth.data.DataCollector;
import com.huawei.hms.hihealth.data.DataType;
import com.huawei.hms.hihealth.data.Record;
import com.huawei.hms.hihealth.data.SamplePoint;
import com.huawei.hms.hihealth.options.OnSamplePointListener;
import com.huawei.hms.hihealth.options.aabc;
import com.huawei.hms.hihealth.options.aabd;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/* compiled from: P */
/* loaded from: classes2.dex */
public class aach implements com.huawei.hms.hihealth.aabf {
    private static volatile aach aab;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    class aab extends aabd.aab {
        final /* synthetic */ OnSamplePointListener aab;

        aab(aach aachVar, OnSamplePointListener onSamplePointListener) {
            this.aab = onSamplePointListener;
        }

        @Override // com.huawei.hms.hihealth.options.aabd
        public void onSamplePoint(SamplePoint samplePoint) throws RemoteException {
            this.aab.onSamplePoint(samplePoint);
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    class aaba extends aabc.aab {
        final /* synthetic */ OnSamplePointListener aab;

        aaba(aach aachVar, OnSamplePointListener onSamplePointListener) {
            this.aab = onSamplePointListener;
        }

        @Override // com.huawei.hms.hihealth.options.aabc
        public void onException(int i3, String str) throws RemoteException {
            this.aab.onException(i3, str);
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    class aabc extends aabc.aab {
        final /* synthetic */ OnSamplePointListener aab;

        aabc(aach aachVar, OnSamplePointListener onSamplePointListener) {
            this.aab = onSamplePointListener;
        }

        @Override // com.huawei.hms.hihealth.options.aabc
        public void onException(int i3, String str) throws RemoteException {
            this.aab.onException(i3, str);
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    static class aabd implements Callable<List<Record>> {
        private final DataType aab;

        aabd(DataType dataType) {
            this.aab = dataType;
        }

        @Override // java.util.concurrent.Callable
        public List<Record> call() throws Exception {
            aabz.aabb("AutoRecorderImpl", "getRecords by dataType doing.");
            try {
                return aack.aabf().aaba().aab(this.aab);
            } catch (RemoteException unused) {
                aabz.aabc("AutoRecorderImpl", "getRecords remote exception.");
                return new ArrayList();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    static class aabe implements Callable<List<Record>> {
        aabe() {
        }

        @Override // java.util.concurrent.Callable
        public List<Record> call() throws Exception {
            aabz.aabb("AutoRecorderImpl", "getRecords doing.");
            try {
                return aack.aabf().aaba().aabb();
            } catch (RemoteException unused) {
                aabz.aabc("AutoRecorderImpl", "getRecords remote exception.");
                return new ArrayList();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    static class aabf implements Callable<Void> {
        private final DataCollector aab;

        aabf(DataCollector dataCollector) {
            this.aab = dataCollector;
        }

        @Override // java.util.concurrent.Callable
        public Void call() throws Exception {
            aabz.aabb("AutoRecorderImpl", "startRecord by dataCollector doing.");
            try {
                aack.aabf().aaba().aab(this.aab);
                return null;
            } catch (RemoteException unused) {
                aabz.aabc("AutoRecorderImpl", "startRecord remote exception.");
                return null;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    static class aabg implements Callable<Void> {
        private final DataType aab;

        aabg(DataType dataType) {
            this.aab = dataType;
        }

        @Override // java.util.concurrent.Callable
        public Void call() throws Exception {
            aabz.aabb("AutoRecorderImpl", "startRecord by dataType doing.");
            aack.aabf().aaba().aaba(this.aab);
            return null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    static class aabh implements Callable<Void> {
        private final DataType aab;
        private final aabd.aab aaba;
        private final aabc.aab aabb;

        aabh(DataType dataType, aabd.aab aabVar, aabc.aab aabVar2) {
            this.aab = dataType;
            this.aaba = aabVar;
            this.aabb = aabVar2;
        }

        @Override // java.util.concurrent.Callable
        public Void call() throws Exception {
            aabz.aabb("AutoRecorderImpl", "startRecord realTime data doing.");
            try {
                aack.aabf().aaba().aab(this.aab, this.aaba, this.aabb);
                return null;
            } catch (RemoteException unused) {
                aabz.aabc("AutoRecorderImpl", "startRecord realTime data remote exception.");
                throw new SecurityException(String.valueOf(50011));
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    static class aabi implements Callable<Void> {
        private final DataCollector aab;

        aabi(DataCollector dataCollector) {
            this.aab = dataCollector;
        }

        @Override // java.util.concurrent.Callable
        public Void call() throws Exception {
            aabz.aabb("AutoRecorderImpl", "stopRecord by dataCollector doing.");
            try {
                aack.aabf().aaba().aaba(this.aab);
                return null;
            } catch (RemoteException unused) {
                aabz.aabc("AutoRecorderImpl", "stopRecord by dataCollector remote exception.");
                return null;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    static class aabj implements Callable<Void> {
        private final Record aab;

        aabj(Record record) {
            this.aab = record;
        }

        @Override // java.util.concurrent.Callable
        public Void call() throws Exception {
            aabz.aabb("AutoRecorderImpl", "stopRecord doing.");
            try {
                aack.aabf().aaba().aab(this.aab);
                return null;
            } catch (RemoteException unused) {
                aabz.aabc("AutoRecorderImpl", "stopRecord remote exception.");
                return null;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    static class aabk implements Callable<Void> {
        private final DataType aab;

        aabk(DataType dataType) {
            this.aab = dataType;
        }

        @Override // java.util.concurrent.Callable
        public Void call() throws Exception {
            aabz.aabb("AutoRecorderImpl", "stopRecord by dataType doing.");
            try {
                aack.aabf().aaba().aabb(this.aab);
                return null;
            } catch (RemoteException unused) {
                aabz.aabc("AutoRecorderImpl", "stopRecord by dataType remote exception.");
                return null;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    static class aabl implements Callable<Void> {
        private final DataType aab;
        private final aabd.aab aaba;
        private final aabc.aab aabb;

        aabl(DataType dataType, aabd.aab aabVar, aabc.aab aabVar2) {
            this.aab = dataType;
            this.aaba = aabVar;
            this.aabb = aabVar2;
        }

        @Override // java.util.concurrent.Callable
        public Void call() throws Exception {
            aabz.aabb("AutoRecorderImpl", "stopRecord realTime data doing.");
            try {
                aack.aabf().aaba().aaba(this.aab, this.aaba, this.aabb);
                return null;
            } catch (RemoteException unused) {
                aabz.aabc("AutoRecorderImpl", "stopRecord realTime data remote exception.");
                throw new SecurityException(String.valueOf(50011));
            }
        }
    }

    public Task<List<Record>> aab() {
        aabz.aabb("AutoRecorderImpl", "getRecords.");
        return aacs.aab(4, new aabe());
    }

    public Task<Void> aaba(DataCollector dataCollector) {
        aabz.aabb("AutoRecorderImpl", "stopRecord by dataCollector.");
        Preconditions.checkArgument(dataCollector != null, "dataType or dataCollector must be set");
        return aacs.aab(4, new aabi(dataCollector));
    }

    public Task<Void> aabb(DataType dataType) {
        boolean z16;
        aabz.aabb("AutoRecorderImpl", "stopRecord by dataType.");
        if (dataType != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        Preconditions.checkArgument(z16, "dataType or dataCollector must be set");
        return aacs.aab(4, new aabk(dataType));
    }

    public Task<Void> aab(DataCollector dataCollector) {
        aabz.aabb("AutoRecorderImpl", "startRecord by dataCollector.");
        Preconditions.checkArgument(dataCollector != null, "dataType or dataCollector must be set");
        return aacs.aab(4, new aabf(dataCollector));
    }

    public Task<Void> aaba(DataType dataType) {
        aabz.aabb("AutoRecorderImpl", "startRecord by by dataType");
        Preconditions.checkArgument(dataType != null, "dataType or dataCollector must be set");
        return aacs.aab(4, new aabg(dataType));
    }

    public Task<List<Record>> aab(DataType dataType) {
        aabz.aabb("AutoRecorderImpl", "getRecords by dataType.");
        Preconditions.checkArgument(dataType != null, "dataType or dataCollector must be set");
        return aacs.aab(4, new aabd(dataType));
    }

    public Task<Void> aaba(DataType dataType, OnSamplePointListener onSamplePointListener) {
        if (dataType == null) {
            aabz.aab("AutoRecorderImpl", "dataType or healthKitRealTimeListener is null.");
            throw new SecurityException(String.valueOf(HiHealthStatusCodes.INPUT_PARAM_MISSING));
        }
        aabz.aabb("AutoRecorderImpl", "enter stop record realTime data by dataType.");
        if (onSamplePointListener != null) {
            return aacs.aab(4, new aabl(dataType, new aabb(this), new aabc(this, onSamplePointListener)));
        }
        aabz.aabc("AutoRecorderImpl", "healthKitRealTimeListener is null.");
        throw new SecurityException(String.valueOf(HiHealthStatusCodes.INPUT_PARAM_MISSING));
    }

    public static aach aaba() {
        if (aab == null) {
            synchronized (aach.class) {
                if (aab == null) {
                    aab = new aach();
                }
            }
        }
        return aab;
    }

    public Task<Void> aab(DataType dataType, OnSamplePointListener onSamplePointListener) {
        if (dataType == null) {
            aabz.aab("AutoRecorderImpl", "dataType or healthKitRealTimeListener is null.");
            throw new SecurityException(String.valueOf(HiHealthStatusCodes.INPUT_PARAM_MISSING));
        }
        aabz.aabb("AutoRecorderImpl", "start record realTime data by dataType.");
        if (onSamplePointListener != null) {
            return aacs.aabb(4, new aabh(dataType, new aab(this, onSamplePointListener), new aaba(this, onSamplePointListener)));
        }
        aabz.aab("AutoRecorderImpl", "dataType or healthKit RealTime Listener is null.");
        throw new SecurityException(String.valueOf(HiHealthStatusCodes.INPUT_PARAM_MISSING));
    }

    public Task<Void> aab(Record record) {
        aabz.aabb("AutoRecorderImpl", "stopRecord.");
        Preconditions.checkArgument(record != null, "dataType or dataCollector must be set");
        return aacs.aab(4, new aabj(record));
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    class aabb extends aabd.aab {
        aabb(aach aachVar) {
        }

        @Override // com.huawei.hms.hihealth.options.aabd
        public void onSamplePoint(SamplePoint samplePoint) throws RemoteException {
        }
    }
}
