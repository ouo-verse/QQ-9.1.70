package com.tencent.qimei.d;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes22.dex */
public interface a extends IInterface {

    /* compiled from: P */
    /* renamed from: com.tencent.qimei.d.a$a, reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    public static abstract class AbstractBinderC9315a extends Binder implements a {
        static IPatchRedirector $redirector_;

        public AbstractBinderC9315a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                attachInterface(this, "com.hihonor.cloudservice.oaid.IOAIDCallBack");
            }
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (IBinder) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i3, @NonNull Parcel parcel, @Nullable Parcel parcel2, int i16) {
            Bundle bundle;
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), parcel, parcel2, Integer.valueOf(i16))).booleanValue();
            }
            if (i3 == 1) {
                parcel.enforceInterface("com.hihonor.cloudservice.oaid.IOAIDCallBack");
                int readInt = parcel.readInt();
                long readLong = parcel.readLong();
                if (parcel.readInt() != 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                a(readInt, readLong, z16, parcel.readFloat(), parcel.readDouble(), parcel.readString());
                if (parcel2 != null) {
                    parcel2.writeNoException();
                }
                return true;
            }
            if (i3 == 2) {
                parcel.enforceInterface("com.hihonor.cloudservice.oaid.IOAIDCallBack");
                int readInt2 = parcel.readInt();
                if (parcel.readInt() != 0) {
                    bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                } else {
                    bundle = null;
                }
                a(readInt2, bundle);
                if (parcel2 != null) {
                    parcel2.writeNoException();
                }
                return true;
            }
            if (i3 != 1598968902) {
                try {
                    return super.onTransact(i3, parcel, parcel2, i16);
                } catch (RemoteException e16) {
                    com.tencent.qimei.ad.b.a("honor onTransact exception." + e16.toString());
                    return false;
                }
            }
            parcel.enforceInterface("com.hihonor.cloudservice.oaid.IOAIDCallBack");
            return true;
        }
    }

    void a(int i3, long j3, boolean z16, float f16, double d16, String str);

    void a(int i3, Bundle bundle);
}
