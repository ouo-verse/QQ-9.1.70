package com.huawei.hms.hihealth.options;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.huawei.hms.hihealth.data.SamplePoint;

/* compiled from: P */
/* loaded from: classes2.dex */
public interface aabd extends IInterface {
    void onSamplePoint(SamplePoint samplePoint) throws RemoteException;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static abstract class aab extends Binder implements aabd {
        public aab() {
            attachInterface(this, "com.huawei.hms.hihealth.options.OnSamplePointRemoteListener");
        }

        @Override // android.os.Binder
        public boolean onTransact(int i3, Parcel parcel, Parcel parcel2, int i16) throws RemoteException {
            SamplePoint samplePoint;
            if (i3 != 1) {
                if (i3 != 1598968902) {
                    return super.onTransact(i3, parcel, parcel2, i16);
                }
                parcel2.writeString("com.huawei.hms.hihealth.options.OnSamplePointRemoteListener");
                return true;
            }
            parcel.enforceInterface("com.huawei.hms.hihealth.options.OnSamplePointRemoteListener");
            if (parcel.readInt() != 0) {
                samplePoint = SamplePoint.CREATOR.createFromParcel(parcel);
            } else {
                samplePoint = null;
            }
            onSamplePoint(samplePoint);
            parcel2.writeNoException();
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }
}
