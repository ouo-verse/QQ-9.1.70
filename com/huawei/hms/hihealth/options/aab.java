package com.huawei.hms.hihealth.options;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.huawei.hms.hihealth.data.SamplePoint;
import java.util.List;

/* compiled from: P */
/* loaded from: classes2.dex */
public interface aab extends IInterface {
    void onReceive(List<SamplePoint> list) throws RemoteException;

    void onStatusChange(int i3) throws RemoteException;

    /* compiled from: P */
    /* renamed from: com.huawei.hms.hihealth.options.aab$aab, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static abstract class AbstractBinderC0273aab extends Binder implements aab {
        public AbstractBinderC0273aab() {
            attachInterface(this, "com.huawei.hms.hihealth.options.OnActivityRecordRemoteListener");
        }

        @Override // android.os.Binder
        public boolean onTransact(int i3, Parcel parcel, Parcel parcel2, int i16) throws RemoteException {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 1598968902) {
                        return super.onTransact(i3, parcel, parcel2, i16);
                    }
                    parcel2.writeString("com.huawei.hms.hihealth.options.OnActivityRecordRemoteListener");
                    return true;
                }
                parcel.enforceInterface("com.huawei.hms.hihealth.options.OnActivityRecordRemoteListener");
                onStatusChange(parcel.readInt());
            } else {
                parcel.enforceInterface("com.huawei.hms.hihealth.options.OnActivityRecordRemoteListener");
                onReceive(parcel.createTypedArrayList(SamplePoint.CREATOR));
            }
            parcel2.writeNoException();
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }
}
