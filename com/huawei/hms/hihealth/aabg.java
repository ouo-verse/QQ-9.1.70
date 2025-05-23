package com.huawei.hms.hihealth;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.huawei.hms.hihealth.data.DataCollector;
import com.huawei.hms.hihealth.data.DataType;
import com.huawei.hms.hihealth.data.Record;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;
import java.util.List;

/* compiled from: P */
/* loaded from: classes2.dex */
public interface aabg extends IInterface {

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static abstract class aab extends Binder implements aabg {
        public static aabg aab() {
            return C0265aab.aaba;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: P */
        /* renamed from: com.huawei.hms.hihealth.aabg$aab$aab, reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static class C0265aab implements aabg {
            public static aabg aaba;
            private IBinder aab;

            C0265aab(IBinder iBinder) {
                this.aab = iBinder;
            }

            @Override // com.huawei.hms.hihealth.aabg
            public List<Record> aab(DataType dataType) throws RemoteException {
                List<Record> createTypedArrayList;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.huawei.hms.hihealth.IAutoRecorderControllerManager");
                    if (dataType != null) {
                        obtain.writeInt(1);
                        dataType.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (OaidMonitor.binderTransact(this.aab, 2, obtain, obtain2, 0) || aab.aab() == null) {
                        obtain2.readException();
                        createTypedArrayList = obtain2.createTypedArrayList(Record.CREATOR);
                    } else {
                        createTypedArrayList = ((C0265aab) aaba).aab(dataType);
                    }
                    return createTypedArrayList;
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.huawei.hms.hihealth.aabg
            public void aaba(DataType dataType) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.huawei.hms.hihealth.IAutoRecorderControllerManager");
                    if (dataType != null) {
                        obtain.writeInt(1);
                        dataType.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (OaidMonitor.binderTransact(this.aab, 4, obtain, obtain2, 0) || aab.aab() == null) {
                        obtain2.readException();
                    } else {
                        ((C0265aab) aaba).aaba(dataType);
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.huawei.hms.hihealth.aabg
            public List<Record> aabb() throws RemoteException {
                List<Record> createTypedArrayList;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.huawei.hms.hihealth.IAutoRecorderControllerManager");
                    if (OaidMonitor.binderTransact(this.aab, 1, obtain, obtain2, 0) || aab.aab() == null) {
                        obtain2.readException();
                        createTypedArrayList = obtain2.createTypedArrayList(Record.CREATOR);
                    } else {
                        createTypedArrayList = ((C0265aab) aaba).aabb();
                    }
                    return createTypedArrayList;
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.aab;
            }

            @Override // com.huawei.hms.hihealth.aabg
            public void aab(DataCollector dataCollector) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.huawei.hms.hihealth.IAutoRecorderControllerManager");
                    if (dataCollector != null) {
                        obtain.writeInt(1);
                        dataCollector.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (OaidMonitor.binderTransact(this.aab, 3, obtain, obtain2, 0) || aab.aab() == null) {
                        obtain2.readException();
                    } else {
                        ((C0265aab) aaba).aab(dataCollector);
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.huawei.hms.hihealth.aabg
            public void aaba(DataCollector dataCollector) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.huawei.hms.hihealth.IAutoRecorderControllerManager");
                    if (dataCollector != null) {
                        obtain.writeInt(1);
                        dataCollector.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (OaidMonitor.binderTransact(this.aab, 7, obtain, obtain2, 0) || aab.aab() == null) {
                        obtain2.readException();
                    } else {
                        ((C0265aab) aaba).aaba(dataCollector);
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.huawei.hms.hihealth.aabg
            public void aabb(DataType dataType) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.huawei.hms.hihealth.IAutoRecorderControllerManager");
                    if (dataType != null) {
                        obtain.writeInt(1);
                        dataType.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (OaidMonitor.binderTransact(this.aab, 6, obtain, obtain2, 0) || aab.aab() == null) {
                        obtain2.readException();
                    } else {
                        ((C0265aab) aaba).aabb(dataType);
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.huawei.hms.hihealth.aabg
            public void aab(DataType dataType, com.huawei.hms.hihealth.options.aabd aabdVar, com.huawei.hms.hihealth.options.aabc aabcVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.huawei.hms.hihealth.IAutoRecorderControllerManager");
                    if (dataType != null) {
                        obtain.writeInt(1);
                        dataType.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(aabdVar != null ? aabdVar.asBinder() : null);
                    obtain.writeStrongBinder(aabcVar != null ? aabcVar.asBinder() : null);
                    if (OaidMonitor.binderTransact(this.aab, 8, obtain, obtain2, 0) || aab.aab() == null) {
                        obtain2.readException();
                    } else {
                        ((C0265aab) aaba).aab(dataType, aabdVar, aabcVar);
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.huawei.hms.hihealth.aabg
            public void aaba(DataType dataType, com.huawei.hms.hihealth.options.aabd aabdVar, com.huawei.hms.hihealth.options.aabc aabcVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.huawei.hms.hihealth.IAutoRecorderControllerManager");
                    if (dataType != null) {
                        obtain.writeInt(1);
                        dataType.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(aabdVar != null ? aabdVar.asBinder() : null);
                    obtain.writeStrongBinder(aabcVar != null ? aabcVar.asBinder() : null);
                    if (OaidMonitor.binderTransact(this.aab, 9, obtain, obtain2, 0) || aab.aab() == null) {
                        obtain2.readException();
                    } else {
                        ((C0265aab) aaba).aaba(dataType, aabdVar, aabcVar);
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.huawei.hms.hihealth.aabg
            public void aab(Record record) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.huawei.hms.hihealth.IAutoRecorderControllerManager");
                    if (record != null) {
                        obtain.writeInt(1);
                        record.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (OaidMonitor.binderTransact(this.aab, 5, obtain, obtain2, 0) || aab.aab() == null) {
                        obtain2.readException();
                    } else {
                        ((C0265aab) aaba).aab(record);
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }
        }

        public static aabg aab(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.huawei.hms.hihealth.IAutoRecorderControllerManager");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof aabg)) ? new C0265aab(iBinder) : (aabg) queryLocalInterface;
        }
    }

    List<Record> aab(DataType dataType) throws RemoteException;

    void aab(DataCollector dataCollector) throws RemoteException;

    void aab(DataType dataType, com.huawei.hms.hihealth.options.aabd aabdVar, com.huawei.hms.hihealth.options.aabc aabcVar) throws RemoteException;

    void aab(Record record) throws RemoteException;

    void aaba(DataCollector dataCollector) throws RemoteException;

    void aaba(DataType dataType) throws RemoteException;

    void aaba(DataType dataType, com.huawei.hms.hihealth.options.aabd aabdVar, com.huawei.hms.hihealth.options.aabc aabcVar) throws RemoteException;

    List<Record> aabb() throws RemoteException;

    void aabb(DataType dataType) throws RemoteException;
}
