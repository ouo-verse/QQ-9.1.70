package com.huawei.hms.hihealth;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;

/* compiled from: P */
/* loaded from: classes2.dex */
public interface aabe extends IInterface {

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static abstract class aab extends Binder implements aabe {

        /* compiled from: P */
        /* renamed from: com.huawei.hms.hihealth.aabe$aab$aab, reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        private static class C0264aab implements aabe {
            private IBinder aab;

            C0264aab(IBinder iBinder) {
                this.aab = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.aab;
            }
        }

        public static aabe aab(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.huawei.hms.hihealth.IAuthControllerManager");
            if (queryLocalInterface != null && (queryLocalInterface instanceof aabe)) {
                return (aabe) queryLocalInterface;
            }
            return new C0264aab(iBinder);
        }
    }
}
