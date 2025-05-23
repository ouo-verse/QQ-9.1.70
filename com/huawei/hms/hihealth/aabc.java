package com.huawei.hms.hihealth;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.huawei.hms.hihealth.data.ActivityRecord;
import com.huawei.hms.hihealth.data.ComponentInfo;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;

/* compiled from: P */
/* loaded from: classes2.dex */
public interface aabc extends IInterface {

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static abstract class aab extends Binder implements aabc {
        public static aabc aab() {
            return C0263aab.aaba;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: P */
        /* renamed from: com.huawei.hms.hihealth.aabc$aab$aab, reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static class C0263aab implements aabc {
            public static aabc aaba;
            private IBinder aab;

            C0263aab(IBinder iBinder) {
                this.aab = iBinder;
            }

            @Override // com.huawei.hms.hihealth.aabc
            public void aab(ActivityRecord activityRecord, ComponentInfo componentInfo, com.huawei.hms.hihealth.options.aab aabVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.huawei.hms.hihealth.IActivityRecordsControllerManager");
                    if (activityRecord != null) {
                        obtain.writeInt(1);
                        activityRecord.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (componentInfo != null) {
                        obtain.writeInt(1);
                        componentInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(aabVar != null ? aabVar.asBinder() : null);
                    if (OaidMonitor.binderTransact(this.aab, 9, obtain, obtain2, 0) || aab.aab() == null) {
                        obtain2.readException();
                    } else {
                        ((C0263aab) aaba).aab(activityRecord, componentInfo, aabVar);
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.huawei.hms.hihealth.aabc
            public ComponentInfo aabh() throws RemoteException {
                ComponentInfo componentInfo;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.huawei.hms.hihealth.IActivityRecordsControllerManager");
                    if (!OaidMonitor.binderTransact(this.aab, 11, obtain, obtain2, 0) && aab.aab() != null) {
                        componentInfo = ((C0263aab) aaba).aabh();
                    } else {
                        obtain2.readException();
                        if (obtain2.readInt() != 0) {
                            componentInfo = ComponentInfo.CREATOR.createFromParcel(obtain2);
                        } else {
                            componentInfo = null;
                        }
                    }
                    return componentInfo;
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.aab;
            }

            @Override // com.huawei.hms.hihealth.aabc
            public void aab(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.huawei.hms.hihealth.IActivityRecordsControllerManager");
                    obtain.writeString(str);
                    if (OaidMonitor.binderTransact(this.aab, 10, obtain, obtain2, 0) || aab.aab() == null) {
                        obtain2.readException();
                    } else {
                        ((C0263aab) aaba).aab(str);
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }
        }

        public static aabc aab(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.huawei.hms.hihealth.IActivityRecordsControllerManager");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof aabc)) ? new C0263aab(iBinder) : (aabc) queryLocalInterface;
        }
    }

    void aab(ActivityRecord activityRecord, ComponentInfo componentInfo, com.huawei.hms.hihealth.options.aab aabVar) throws RemoteException;

    void aab(String str) throws RemoteException;

    ComponentInfo aabh() throws RemoteException;
}
