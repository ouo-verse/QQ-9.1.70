package com.huawei.hms.hihealth;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;

/* compiled from: P */
/* loaded from: classes2.dex */
public interface aabl extends IInterface {

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static abstract class aab extends Binder implements aabl {

        /* compiled from: P */
        /* renamed from: com.huawei.hms.hihealth.aabl$aab$aab, reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        private static class C0269aab implements aabl {
            private IBinder aab;

            C0269aab(IBinder iBinder) {
                this.aab = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.aab;
            }
        }

        public static aabl aab(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.huawei.hms.hihealth.IDataControllerManager");
            if (queryLocalInterface != null && (queryLocalInterface instanceof aabl)) {
                return (aabl) queryLocalInterface;
            }
            return new C0269aab(iBinder);
        }
    }
}
