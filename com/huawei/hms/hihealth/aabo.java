package com.huawei.hms.hihealth;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.huawei.hms.hihealth.options.ActivityBeginOptions;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;

/* compiled from: P */
/* loaded from: classes2.dex */
public interface aabo extends IInterface {

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static abstract class aab extends Binder implements aabo {

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: P */
        /* renamed from: com.huawei.hms.hihealth.aabo$aab$aab, reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static class C0271aab implements aabo {
            public static aabo aaba;
            private IBinder aab;

            C0271aab(IBinder iBinder) {
                this.aab = iBinder;
            }

            @Override // com.huawei.hms.hihealth.aabo
            public int aab(ActivityBeginOptions activityBeginOptions, com.huawei.hms.hihealth.options.aaba aabaVar) throws RemoteException {
                IBinder iBinder;
                int readInt;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.huawei.hms.hihealth.ISessionControllerManager");
                    if (activityBeginOptions != null) {
                        obtain.writeInt(1);
                        activityBeginOptions.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (aabaVar != null) {
                        iBinder = aabaVar.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    if (!OaidMonitor.binderTransact(this.aab, 1, obtain, obtain2, 0) && aab.aab() != null) {
                        readInt = ((C0271aab) aaba).aab(activityBeginOptions, aabaVar);
                    } else {
                        obtain2.readException();
                        readInt = obtain2.readInt();
                    }
                    return readInt;
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.huawei.hms.hihealth.aabo
            public void aabc() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.huawei.hms.hihealth.ISessionControllerManager");
                    if (!OaidMonitor.binderTransact(this.aab, 4, obtain, obtain2, 0) && aab.aab() != null) {
                        ((C0271aab) aaba).aabc();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.huawei.hms.hihealth.aabo
            public void aabd() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.huawei.hms.hihealth.ISessionControllerManager");
                    if (!OaidMonitor.binderTransact(this.aab, 5, obtain, obtain2, 0) && aab.aab() != null) {
                        ((C0271aab) aaba).aabd();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.huawei.hms.hihealth.aabo
            public void aabg() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.huawei.hms.hihealth.ISessionControllerManager");
                    if (!OaidMonitor.binderTransact(this.aab, 2, obtain, obtain2, 0) && aab.aab() != null) {
                        ((C0271aab) aaba).aabg();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.huawei.hms.hihealth.aabo
            public void aabl() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.huawei.hms.hihealth.ISessionControllerManager");
                    if (!OaidMonitor.binderTransact(this.aab, 3, obtain, obtain2, 0) && aab.aab() != null) {
                        ((C0271aab) aaba).aabl();
                    } else {
                        obtain2.readException();
                    }
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

        public static aabo aab() {
            return C0271aab.aaba;
        }

        public static aabo aab(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.huawei.hms.hihealth.ISessionControllerManager");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof aabo)) ? new C0271aab(iBinder) : (aabo) queryLocalInterface;
        }
    }

    int aab(ActivityBeginOptions activityBeginOptions, com.huawei.hms.hihealth.options.aaba aabaVar) throws RemoteException;

    void aabc() throws RemoteException;

    void aabd() throws RemoteException;

    void aabg() throws RemoteException;

    void aabl() throws RemoteException;
}
