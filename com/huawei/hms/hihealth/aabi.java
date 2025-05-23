package com.huawei.hms.hihealth;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;

/* compiled from: P */
/* loaded from: classes2.dex */
public interface aabi extends IInterface {

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static abstract class aab extends Binder implements aabi {

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: P */
        /* renamed from: com.huawei.hms.hihealth.aabi$aab$aab, reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static class C0267aab implements aabi {
            public static aabi aaba;
            private IBinder aab;

            C0267aab(IBinder iBinder) {
                this.aab = iBinder;
            }

            @Override // com.huawei.hms.hihealth.aabi
            public String aab(String str, com.huawei.hms.hihealth.options.aabb aabbVar) throws RemoteException {
                IBinder iBinder;
                String readString;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.huawei.hms.hihealth.ICommonApiCall");
                    obtain.writeString(str);
                    if (aabbVar != null) {
                        iBinder = aabbVar.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    if (!OaidMonitor.binderTransact(this.aab, 2, obtain, obtain2, 0) && aab.aab() != null) {
                        readString = ((C0267aab) aaba).aab(str, aabbVar);
                    } else {
                        obtain2.readException();
                        readString = obtain2.readString();
                    }
                    return readString;
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.huawei.hms.hihealth.aabi
            public String aabb(String str) throws RemoteException {
                String readString;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.huawei.hms.hihealth.ICommonApiCall");
                    obtain.writeString(str);
                    if (!OaidMonitor.binderTransact(this.aab, 1, obtain, obtain2, 0) && aab.aab() != null) {
                        readString = ((C0267aab) aaba).aabb(str);
                    } else {
                        obtain2.readException();
                        readString = obtain2.readString();
                    }
                    return readString;
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.aab;
            }
        }

        public static aabi aab() {
            return C0267aab.aaba;
        }

        public static aabi aab(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.huawei.hms.hihealth.ICommonApiCall");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof aabi)) ? new C0267aab(iBinder) : (aabi) queryLocalInterface;
        }
    }

    String aab(String str, com.huawei.hms.hihealth.options.aabb aabbVar) throws RemoteException;

    String aabb(String str) throws RemoteException;
}
