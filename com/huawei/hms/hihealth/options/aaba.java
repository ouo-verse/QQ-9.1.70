package com.huawei.hms.hihealth.options;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.huawei.hms.hihealth.data.RealTimeSampleSet;

/* compiled from: P */
/* loaded from: classes2.dex */
public interface aaba extends IInterface {
    void onReceive(int i3, RealTimeSampleSet realTimeSampleSet) throws RemoteException;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static abstract class aab extends Binder implements aaba {
        public aab() {
            attachInterface(this, "com.huawei.hms.hihealth.options.OnBeginActivityRemoteListener");
        }

        @Override // android.os.Binder
        public boolean onTransact(int i3, Parcel parcel, Parcel parcel2, int i16) throws RemoteException {
            RealTimeSampleSet realTimeSampleSet;
            if (i3 != 1) {
                if (i3 != 1598968902) {
                    return super.onTransact(i3, parcel, parcel2, i16);
                }
                parcel2.writeString("com.huawei.hms.hihealth.options.OnBeginActivityRemoteListener");
                return true;
            }
            parcel.enforceInterface("com.huawei.hms.hihealth.options.OnBeginActivityRemoteListener");
            int readInt = parcel.readInt();
            if (parcel.readInt() != 0) {
                realTimeSampleSet = RealTimeSampleSet.CREATOR.createFromParcel(parcel);
            } else {
                realTimeSampleSet = null;
            }
            onReceive(readInt, realTimeSampleSet);
            parcel2.writeNoException();
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }
}
