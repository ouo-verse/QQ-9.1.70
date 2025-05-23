package com.tencent.mobileqq.login.restart;

import android.graphics.Bitmap;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;

/* compiled from: P */
/* loaded from: classes15.dex */
public interface a extends IInterface {

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.login.restart.a$a, reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    public static abstract class AbstractBinderC7989a extends Binder implements a {
        static IPatchRedirector $redirector_;

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: P */
        /* renamed from: com.tencent.mobileqq.login.restart.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes15.dex */
        public static class C7990a implements a {
            static IPatchRedirector $redirector_;

            /* renamed from: e, reason: collision with root package name */
            public static a f242613e;

            /* renamed from: d, reason: collision with root package name */
            private IBinder f242614d;

            C7990a(IBinder iBinder) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) iBinder);
                } else {
                    this.f242614d = iBinder;
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (IBinder) iPatchRedirector.redirect((short) 2, (Object) this);
                }
                return this.f242614d;
            }

            @Override // com.tencent.mobileqq.login.restart.a
            public Bitmap getBackground() throws RemoteException {
                Bitmap bitmap;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    return (Bitmap) iPatchRedirector.redirect((short) 4, (Object) this);
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.mobileqq.login.restart.ILoginRestartBackground");
                    if (!OaidMonitor.binderTransact(this.f242614d, 1, obtain, obtain2, 0) && AbstractBinderC7989a.v() != null) {
                        return AbstractBinderC7989a.v().getBackground();
                    }
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        bitmap = (Bitmap) Bitmap.CREATOR.createFromParcel(obtain2);
                    } else {
                        bitmap = null;
                    }
                    return bitmap;
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }
        }

        public AbstractBinderC7989a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                attachInterface(this, "com.tencent.mobileqq.login.restart.ILoginRestartBackground");
            }
        }

        public static a j(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.tencent.mobileqq.login.restart.ILoginRestartBackground");
            if (queryLocalInterface != null && (queryLocalInterface instanceof a)) {
                return (a) queryLocalInterface;
            }
            return new C7990a(iBinder);
        }

        public static a v() {
            return C7990a.f242613e;
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
        public boolean onTransact(int i3, Parcel parcel, Parcel parcel2, int i16) throws RemoteException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), parcel, parcel2, Integer.valueOf(i16))).booleanValue();
            }
            if (i3 != 1598968902) {
                if (i3 != 1) {
                    return super.onTransact(i3, parcel, parcel2, i16);
                }
                parcel.enforceInterface("com.tencent.mobileqq.login.restart.ILoginRestartBackground");
                Bitmap background = getBackground();
                parcel2.writeNoException();
                if (background != null) {
                    parcel2.writeInt(1);
                    background.writeToParcel(parcel2, 1);
                } else {
                    parcel2.writeInt(0);
                }
                return true;
            }
            parcel2.writeString("com.tencent.mobileqq.login.restart.ILoginRestartBackground");
            return true;
        }
    }

    Bitmap getBackground() throws RemoteException;
}
