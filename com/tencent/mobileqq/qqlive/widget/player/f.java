package com.tencent.mobileqq.qqlive.widget.player;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;

/* compiled from: P */
/* loaded from: classes17.dex */
public interface f extends IInterface {

    /* compiled from: P */
    /* loaded from: classes17.dex */
    public static abstract class a extends Binder implements f {
        static IPatchRedirector $redirector_;

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: P */
        /* renamed from: com.tencent.mobileqq.qqlive.widget.player.f$a$a, reason: collision with other inner class name */
        /* loaded from: classes17.dex */
        public static class C8414a implements f {
            static IPatchRedirector $redirector_;

            /* renamed from: e, reason: collision with root package name */
            public static f f274040e;

            /* renamed from: d, reason: collision with root package name */
            private IBinder f274041d;

            C8414a(IBinder iBinder) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) iBinder);
                } else {
                    this.f274041d = iBinder;
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (IBinder) iPatchRedirector.redirect((short) 2, (Object) this);
                }
                return this.f274041d;
            }

            @Override // com.tencent.mobileqq.qqlive.widget.player.f
            public void o() throws RemoteException {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    iPatchRedirector.redirect((short) 4, (Object) this);
                    return;
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.mobileqq.qqlive.widget.player.IRemoteSwitchDefinitionListener");
                    if (!OaidMonitor.binderTransact(this.f274041d, 1, obtain, obtain2, 0) && a.v() != null) {
                        a.v().o();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }
        }

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                attachInterface(this, "com.tencent.mobileqq.qqlive.widget.player.IRemoteSwitchDefinitionListener");
            }
        }

        public static f j(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.tencent.mobileqq.qqlive.widget.player.IRemoteSwitchDefinitionListener");
            if (queryLocalInterface != null && (queryLocalInterface instanceof f)) {
                return (f) queryLocalInterface;
            }
            return new C8414a(iBinder);
        }

        public static f v() {
            return C8414a.f274040e;
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
                parcel.enforceInterface("com.tencent.mobileqq.qqlive.widget.player.IRemoteSwitchDefinitionListener");
                o();
                parcel2.writeNoException();
                return true;
            }
            parcel2.writeString("com.tencent.mobileqq.qqlive.widget.player.IRemoteSwitchDefinitionListener");
            return true;
        }
    }

    void o() throws RemoteException;
}
