package com.huawei.hms.hihealth;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.huawei.hms.hihealth.data.DataType;
import com.huawei.hms.hihealth.options.DataTypeAddOptions;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;

/* compiled from: P */
/* loaded from: classes2.dex */
public interface aabr extends IInterface {

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static abstract class aab extends Binder implements aabr {
        public static aabr aab(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.huawei.hms.hihealth.ISettingControllerManager");
            if (queryLocalInterface != null && (queryLocalInterface instanceof aabr)) {
                return (aabr) queryLocalInterface;
            }
            return new C0272aab(iBinder);
        }

        public static aabr aabb() {
            return C0272aab.aaba;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: P */
        /* renamed from: com.huawei.hms.hihealth.aabr$aab$aab, reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static class C0272aab implements aabr {
            public static aabr aaba;
            private IBinder aab;

            C0272aab(IBinder iBinder) {
                this.aab = iBinder;
            }

            @Override // com.huawei.hms.hihealth.aabr
            public DataType aab(DataTypeAddOptions dataTypeAddOptions) throws RemoteException {
                DataType createFromParcel;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.huawei.hms.hihealth.ISettingControllerManager");
                    if (dataTypeAddOptions != null) {
                        obtain.writeInt(1);
                        dataTypeAddOptions.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (OaidMonitor.binderTransact(this.aab, 2, obtain, obtain2, 0) || aab.aabb() == null) {
                        obtain2.readException();
                        createFromParcel = obtain2.readInt() != 0 ? DataType.CREATOR.createFromParcel(obtain2) : null;
                    } else {
                        createFromParcel = ((C0272aab) aaba).aab(dataTypeAddOptions);
                    }
                    return createFromParcel;
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.huawei.hms.hihealth.aabr
            public void aaba() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.huawei.hms.hihealth.ISettingControllerManager");
                    if (OaidMonitor.binderTransact(this.aab, 1, obtain, obtain2, 0) || aab.aabb() == null) {
                        obtain2.readException();
                    } else {
                        ((C0272aab) aaba).aaba();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.huawei.hms.hihealth.aabr
            public boolean aabc(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.huawei.hms.hihealth.ISettingControllerManager");
                    obtain.writeString(str);
                    boolean z16 = false;
                    if (!OaidMonitor.binderTransact(this.aab, 9, obtain, obtain2, 0) && aab.aabb() != null) {
                        return ((C0272aab) aaba).aabc(str);
                    }
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z16 = true;
                    }
                    return z16;
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.huawei.hms.hihealth.aabr
            public String aabe() throws RemoteException {
                String readString;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.huawei.hms.hihealth.ISettingControllerManager");
                    if (!OaidMonitor.binderTransact(this.aab, 6, obtain, obtain2, 0) && aab.aabb() != null) {
                        readString = ((C0272aab) aaba).aabe();
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

            @Override // com.huawei.hms.hihealth.aabr
            public void aabf() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.huawei.hms.hihealth.ISettingControllerManager");
                    if (!OaidMonitor.binderTransact(this.aab, 4, obtain, obtain2, 0) && aab.aabb() != null) {
                        ((C0272aab) aaba).aabf();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.huawei.hms.hihealth.aabr
            public boolean aabi() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.huawei.hms.hihealth.ISettingControllerManager");
                    boolean z16 = false;
                    if (!OaidMonitor.binderTransact(this.aab, 5, obtain, obtain2, 0) && aab.aabb() != null) {
                        return ((C0272aab) aaba).aabi();
                    }
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z16 = true;
                    }
                    return z16;
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.huawei.hms.hihealth.aabr
            public boolean aabj() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.huawei.hms.hihealth.ISettingControllerManager");
                    boolean z16 = false;
                    if (!OaidMonitor.binderTransact(this.aab, 7, obtain, obtain2, 0) && aab.aabb() != null) {
                        return ((C0272aab) aaba).aabj();
                    }
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z16 = true;
                    }
                    return z16;
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.huawei.hms.hihealth.aabr
            public com.huawei.hms.hihealth.data.aabc aabk() throws RemoteException {
                com.huawei.hms.hihealth.data.aabc aabcVar;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.huawei.hms.hihealth.ISettingControllerManager");
                    if (!OaidMonitor.binderTransact(this.aab, 11, obtain, obtain2, 0) && aab.aabb() != null) {
                        aabcVar = ((C0272aab) aaba).aabk();
                    } else {
                        obtain2.readException();
                        if (obtain2.readInt() != 0) {
                            aabcVar = com.huawei.hms.hihealth.data.aabc.CREATOR.createFromParcel(obtain2);
                        } else {
                            aabcVar = null;
                        }
                    }
                    return aabcVar;
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.aab;
            }

            @Override // com.huawei.hms.hihealth.aabr
            public boolean aab() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.huawei.hms.hihealth.ISettingControllerManager");
                    if (!OaidMonitor.binderTransact(this.aab, 10, obtain, obtain2, 0) && aab.aabb() != null) {
                        return ((C0272aab) aaba).aab();
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.huawei.hms.hihealth.aabr
            public DataType aaba(String str) throws RemoteException {
                DataType createFromParcel;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.huawei.hms.hihealth.ISettingControllerManager");
                    obtain.writeString(str);
                    if (OaidMonitor.binderTransact(this.aab, 3, obtain, obtain2, 0) || aab.aabb() == null) {
                        obtain2.readException();
                        createFromParcel = obtain2.readInt() != 0 ? DataType.CREATOR.createFromParcel(obtain2) : null;
                    } else {
                        createFromParcel = ((C0272aab) aaba).aaba(str);
                    }
                    return createFromParcel;
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.huawei.hms.hihealth.aabr
            public boolean aaba(boolean z16) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.huawei.hms.hihealth.ISettingControllerManager");
                    obtain.writeInt(z16 ? 1 : 0);
                    if (!OaidMonitor.binderTransact(this.aab, 8, obtain, obtain2, 0) && aab.aabb() != null) {
                        return ((C0272aab) aaba).aaba(z16);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }
        }
    }

    DataType aab(DataTypeAddOptions dataTypeAddOptions) throws RemoteException;

    boolean aab() throws RemoteException;

    DataType aaba(String str) throws RemoteException;

    void aaba() throws RemoteException;

    boolean aaba(boolean z16) throws RemoteException;

    boolean aabc(String str) throws RemoteException;

    String aabe() throws RemoteException;

    void aabf() throws RemoteException;

    boolean aabi() throws RemoteException;

    boolean aabj() throws RemoteException;

    com.huawei.hms.hihealth.data.aabc aabk() throws RemoteException;
}
