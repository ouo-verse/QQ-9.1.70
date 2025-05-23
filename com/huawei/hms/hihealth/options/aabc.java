package com.huawei.hms.hihealth.options;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: P */
/* loaded from: classes2.dex */
public interface aabc extends IInterface {
    void onException(int i3, String str) throws RemoteException;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static abstract class aab extends Binder implements aabc {
        public aab() {
            attachInterface(this, "com.huawei.hms.hihealth.options.OnRealTimeExceptionRemoteListener");
        }

        @Override // android.os.Binder
        public boolean onTransact(int i3, Parcel parcel, Parcel parcel2, int i16) throws RemoteException {
            if (i3 != 1) {
                if (i3 != 1598968902) {
                    return super.onTransact(i3, parcel, parcel2, i16);
                }
                parcel2.writeString("com.huawei.hms.hihealth.options.OnRealTimeExceptionRemoteListener");
                return true;
            }
            parcel.enforceInterface("com.huawei.hms.hihealth.options.OnRealTimeExceptionRemoteListener");
            onException(parcel.readInt(), parcel.readString());
            parcel2.writeNoException();
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }
}
