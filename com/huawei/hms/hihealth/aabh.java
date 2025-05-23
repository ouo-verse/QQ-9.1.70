package com.huawei.hms.hihealth;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;

/* compiled from: P */
/* loaded from: classes2.dex */
public interface aabh extends IInterface {

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static abstract class aab extends Binder implements aabh {
        public static aabh aab() {
            return C0266aab.aaba;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: P */
        /* renamed from: com.huawei.hms.hihealth.aabh$aab$aab, reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static class C0266aab implements aabh {
            public static aabh aaba;
            private IBinder aab;

            C0266aab(IBinder iBinder) {
                this.aab = iBinder;
            }

            public IBinder aab(int i3, String str) throws RemoteException {
                IBinder readStrongBinder;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.huawei.hms.hihealth.IClientPoolAidlInterface");
                    obtain.writeInt(i3);
                    obtain.writeString(str);
                    if (OaidMonitor.binderTransact(this.aab, 1, obtain, obtain2, 0) || aab.aab() == null) {
                        obtain2.readException();
                        readStrongBinder = obtain2.readStrongBinder();
                    } else {
                        readStrongBinder = ((C0266aab) aaba).aab(i3, str);
                    }
                    return readStrongBinder;
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.aab;
            }

            public void aab(com.huawei.hms.hihealth.aab aabVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.huawei.hms.hihealth.IClientPoolAidlInterface");
                    obtain.writeStrongBinder(aabVar != null ? aabVar.asBinder() : null);
                    if (OaidMonitor.binderTransact(this.aab, 2, obtain, obtain2, 0) || aab.aab() == null) {
                        obtain2.readException();
                    } else {
                        ((C0266aab) aaba).aab(aabVar);
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }
        }

        public static aabh aab(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.huawei.hms.hihealth.IClientPoolAidlInterface");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof aabh)) ? new C0266aab(iBinder) : (aabh) queryLocalInterface;
        }
    }
}
