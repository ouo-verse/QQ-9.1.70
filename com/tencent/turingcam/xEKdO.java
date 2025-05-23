package com.tencent.turingcam;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes27.dex */
public abstract class xEKdO extends Binder implements IInterface {
    static IPatchRedirector $redirector_;

    public xEKdO() {
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
    public boolean onTransact(int i3, Parcel parcel, Parcel parcel2, int i16) {
        Bundle bundle;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), parcel, parcel2, Integer.valueOf(i16))).booleanValue();
        }
        try {
            if (i3 == 1) {
                parcel.enforceInterface("com.hihonor.cloudservice.oaid.IOAIDCallBack");
                parcel2.writeNoException();
                return true;
            }
            if (i3 == 2) {
                parcel.enforceInterface("com.hihonor.cloudservice.oaid.IOAIDCallBack");
                int readInt = parcel.readInt();
                if (parcel.readInt() != 0) {
                    bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                } else {
                    bundle = null;
                }
                s7Dnc s7dnc = (s7Dnc) this;
                if (!s7dnc.f382360b) {
                    String str = "";
                    if (readInt == 0 && bundle != null) {
                        str = bundle.getString("oa_id_flag");
                    }
                    synchronized (s7dnc.f382359a) {
                        s7dnc.f382359a.set(str);
                        s7dnc.f382359a.notifyAll();
                    }
                }
                parcel2.writeNoException();
                return true;
            }
            if (i3 != 1598968902) {
                return super.onTransact(i3, parcel, parcel2, i16);
            }
            parcel2.writeString("com.hihonor.cloudservice.oaid.IOAIDCallBack");
            return true;
        } catch (RemoteException unused) {
            return false;
        }
    }
}
