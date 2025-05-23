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
public interface c extends IInterface {

    /* compiled from: P */
    /* loaded from: classes17.dex */
    public static abstract class a extends Binder implements c {
        static IPatchRedirector $redirector_;

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: P */
        /* renamed from: com.tencent.mobileqq.qqlive.widget.player.c$a$a, reason: collision with other inner class name */
        /* loaded from: classes17.dex */
        public static class C8411a implements c {
            static IPatchRedirector $redirector_;

            /* renamed from: e, reason: collision with root package name */
            public static c f274034e;

            /* renamed from: d, reason: collision with root package name */
            private IBinder f274035d;

            C8411a(IBinder iBinder) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) iBinder);
                } else {
                    this.f274035d = iBinder;
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (IBinder) iPatchRedirector.redirect((short) 2, (Object) this);
                }
                return this.f274035d;
            }

            @Override // com.tencent.mobileqq.qqlive.widget.player.c
            public void onError(int i3, int i16, int i17, String str) throws RemoteException {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), str);
                    return;
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.mobileqq.qqlive.widget.player.IRemoteErrorListener");
                    obtain.writeInt(i3);
                    obtain.writeInt(i16);
                    obtain.writeInt(i17);
                    obtain.writeString(str);
                    if (!OaidMonitor.binderTransact(this.f274035d, 1, obtain, obtain2, 0) && a.v() != null) {
                        a.v().onError(i3, i16, i17, str);
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
                attachInterface(this, "com.tencent.mobileqq.qqlive.widget.player.IRemoteErrorListener");
            }
        }

        public static c j(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.tencent.mobileqq.qqlive.widget.player.IRemoteErrorListener");
            if (queryLocalInterface != null && (queryLocalInterface instanceof c)) {
                return (c) queryLocalInterface;
            }
            return new C8411a(iBinder);
        }

        public static c v() {
            return C8411a.f274034e;
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
                parcel.enforceInterface("com.tencent.mobileqq.qqlive.widget.player.IRemoteErrorListener");
                onError(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readString());
                parcel2.writeNoException();
                return true;
            }
            parcel2.writeString("com.tencent.mobileqq.qqlive.widget.player.IRemoteErrorListener");
            return true;
        }
    }

    void onError(int i3, int i16, int i17, String str) throws RemoteException;
}
