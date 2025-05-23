package com.huawei.hms.hihealth;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;

/* compiled from: P */
/* loaded from: classes2.dex */
public interface aabn extends IInterface {

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static abstract class aab extends Binder implements aabn {

        /* compiled from: P */
        /* renamed from: com.huawei.hms.hihealth.aabn$aab$aab, reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        private static class C0270aab implements aabn {
            private IBinder aab;

            C0270aab(IBinder iBinder) {
                this.aab = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.aab;
            }
        }

        public static aabn aab(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.huawei.hms.hihealth.IHealthRecordsControllerManager");
            if (queryLocalInterface != null && (queryLocalInterface instanceof aabn)) {
                return (aabn) queryLocalInterface;
            }
            return new C0270aab(iBinder);
        }
    }
}
