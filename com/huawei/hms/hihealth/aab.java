package com.huawei.hms.hihealth;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: P */
/* loaded from: classes2.dex */
public interface aab extends IInterface {

    /* compiled from: P */
    /* renamed from: com.huawei.hms.hihealth.aab$aab, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static abstract class AbstractBinderC0262aab extends Binder implements aab {
        public AbstractBinderC0262aab() {
            attachInterface(this, "com.huawei.hms.hihealth.ClientToken");
        }

        @Override // android.os.Binder
        public boolean onTransact(int i3, Parcel parcel, Parcel parcel2, int i16) throws RemoteException {
            if (i3 != 1598968902) {
                return super.onTransact(i3, parcel, parcel2, i16);
            }
            parcel2.writeString("com.huawei.hms.hihealth.ClientToken");
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }
}
