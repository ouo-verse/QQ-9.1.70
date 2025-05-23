package com.tencent.mobileqq.qqlive.widget.player;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.view.Surface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.widget.player.b;
import com.tencent.mobileqq.qqlive.widget.player.c;
import com.tencent.mobileqq.qqlive.widget.player.d;
import com.tencent.mobileqq.qqlive.widget.player.e;
import com.tencent.mobileqq.qqlive.widget.player.f;
import com.tencent.mobileqq.qqlive.widget.util.SizeParcelable;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;

/* compiled from: P */
/* loaded from: classes17.dex */
public interface a extends IInterface {

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.qqlive.widget.player.a$a, reason: collision with other inner class name */
    /* loaded from: classes17.dex */
    public static abstract class AbstractBinderC8408a extends Binder implements a {
        static IPatchRedirector $redirector_;

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: P */
        /* renamed from: com.tencent.mobileqq.qqlive.widget.player.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes17.dex */
        public static class C8409a implements a {
            static IPatchRedirector $redirector_;

            /* renamed from: e, reason: collision with root package name */
            public static a f274030e;

            /* renamed from: d, reason: collision with root package name */
            private IBinder f274031d;

            C8409a(IBinder iBinder) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) iBinder);
                } else {
                    this.f274031d = iBinder;
                }
            }

            @Override // com.tencent.mobileqq.qqlive.widget.player.a
            public void J0(f fVar) throws RemoteException {
                IBinder iBinder;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
                    iPatchRedirector.redirect((short) 18, (Object) this, (Object) fVar);
                    return;
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.mobileqq.qqlive.widget.player.IQQLiveRemotePlayer");
                    if (fVar != null) {
                        iBinder = fVar.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    if (!OaidMonitor.binderTransact(this.f274031d, 15, obtain, obtain2, 0) && AbstractBinderC8408a.v() != null) {
                        AbstractBinderC8408a.v().J0(fVar);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.mobileqq.qqlive.widget.player.a
            public void K3(d dVar) throws RemoteException {
                IBinder iBinder;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
                    iPatchRedirector.redirect((short) 19, (Object) this, (Object) dVar);
                    return;
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.mobileqq.qqlive.widget.player.IQQLiveRemotePlayer");
                    if (dVar != null) {
                        iBinder = dVar.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    if (!OaidMonitor.binderTransact(this.f274031d, 16, obtain, obtain2, 0) && AbstractBinderC8408a.v() != null) {
                        AbstractBinderC8408a.v().K3(dVar);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.mobileqq.qqlive.widget.player.a
            public void V3(b bVar) throws RemoteException {
                IBinder iBinder;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
                    iPatchRedirector.redirect((short) 21, (Object) this, (Object) bVar);
                    return;
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.mobileqq.qqlive.widget.player.IQQLiveRemotePlayer");
                    if (bVar != null) {
                        iBinder = bVar.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    if (!OaidMonitor.binderTransact(this.f274031d, 18, obtain, obtain2, 0) && AbstractBinderC8408a.v() != null) {
                        AbstractBinderC8408a.v().V3(bVar);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.mobileqq.qqlive.widget.player.a
            public void Y2(e eVar) throws RemoteException {
                IBinder iBinder;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
                    iPatchRedirector.redirect((short) 20, (Object) this, (Object) eVar);
                    return;
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.mobileqq.qqlive.widget.player.IQQLiveRemotePlayer");
                    if (eVar != null) {
                        iBinder = eVar.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    if (!OaidMonitor.binderTransact(this.f274031d, 17, obtain, obtain2, 0) && AbstractBinderC8408a.v() != null) {
                        AbstractBinderC8408a.v().Y2(eVar);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.mobileqq.qqlive.widget.player.a
            public void a2(c cVar) throws RemoteException {
                IBinder iBinder;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
                    iPatchRedirector.redirect((short) 17, (Object) this, (Object) cVar);
                    return;
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.mobileqq.qqlive.widget.player.IQQLiveRemotePlayer");
                    if (cVar != null) {
                        iBinder = cVar.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    if (!OaidMonitor.binderTransact(this.f274031d, 14, obtain, obtain2, 0) && AbstractBinderC8408a.v() != null) {
                        AbstractBinderC8408a.v().a2(cVar);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (IBinder) iPatchRedirector.redirect((short) 2, (Object) this);
                }
                return this.f274031d;
            }

            @Override // com.tencent.mobileqq.qqlive.widget.player.a
            public SizeParcelable getVideoSize() throws RemoteException {
                SizeParcelable sizeParcelable;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
                    return (SizeParcelable) iPatchRedirector.redirect((short) 14, (Object) this);
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.mobileqq.qqlive.widget.player.IQQLiveRemotePlayer");
                    if (!OaidMonitor.binderTransact(this.f274031d, 11, obtain, obtain2, 0) && AbstractBinderC8408a.v() != null) {
                        return AbstractBinderC8408a.v().getVideoSize();
                    }
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        sizeParcelable = SizeParcelable.INSTANCE.createFromParcel(obtain2);
                    } else {
                        sizeParcelable = null;
                    }
                    return sizeParcelable;
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.mobileqq.qqlive.widget.player.a
            public boolean isOutputMute() throws RemoteException {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.mobileqq.qqlive.widget.player.IQQLiveRemotePlayer");
                    boolean z16 = false;
                    if (!OaidMonitor.binderTransact(this.f274031d, 8, obtain, obtain2, 0) && AbstractBinderC8408a.v() != null) {
                        return AbstractBinderC8408a.v().isOutputMute();
                    }
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z16 = true;
                    }
                    return z16;
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.mobileqq.qqlive.widget.player.a
            public boolean isPlaying() throws RemoteException {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this)).booleanValue();
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.mobileqq.qqlive.widget.player.IQQLiveRemotePlayer");
                    boolean z16 = false;
                    if (!OaidMonitor.binderTransact(this.f274031d, 10, obtain, obtain2, 0) && AbstractBinderC8408a.v() != null) {
                        return AbstractBinderC8408a.v().isPlaying();
                    }
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z16 = true;
                    }
                    return z16;
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.mobileqq.qqlive.widget.player.a
            public void o2(Surface surface) throws RemoteException {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
                    iPatchRedirector.redirect((short) 16, (Object) this, (Object) surface);
                    return;
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.mobileqq.qqlive.widget.player.IQQLiveRemotePlayer");
                    if (surface != null) {
                        obtain.writeInt(1);
                        surface.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!OaidMonitor.binderTransact(this.f274031d, 13, obtain, obtain2, 0) && AbstractBinderC8408a.v() != null) {
                        AbstractBinderC8408a.v().o2(surface);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.mobileqq.qqlive.widget.player.a
            public void pause() throws RemoteException {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                    iPatchRedirector.redirect((short) 6, (Object) this);
                    return;
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.mobileqq.qqlive.widget.player.IQQLiveRemotePlayer");
                    if (!OaidMonitor.binderTransact(this.f274031d, 3, obtain, obtain2, 0) && AbstractBinderC8408a.v() != null) {
                        AbstractBinderC8408a.v().pause();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.mobileqq.qqlive.widget.player.a
            public void prepare(String str) throws RemoteException {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
                    return;
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.mobileqq.qqlive.widget.player.IQQLiveRemotePlayer");
                    obtain.writeString(str);
                    if (!OaidMonitor.binderTransact(this.f274031d, 1, obtain, obtain2, 0) && AbstractBinderC8408a.v() != null) {
                        AbstractBinderC8408a.v().prepare(str);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.mobileqq.qqlive.widget.player.a
            public void release() throws RemoteException {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                    iPatchRedirector.redirect((short) 9, (Object) this);
                    return;
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.mobileqq.qqlive.widget.player.IQQLiveRemotePlayer");
                    if (!OaidMonitor.binderTransact(this.f274031d, 6, obtain, obtain2, 0) && AbstractBinderC8408a.v() != null) {
                        AbstractBinderC8408a.v().release();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.mobileqq.qqlive.widget.player.a
            public void replay() throws RemoteException {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                    iPatchRedirector.redirect((short) 7, (Object) this);
                    return;
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.mobileqq.qqlive.widget.player.IQQLiveRemotePlayer");
                    if (!OaidMonitor.binderTransact(this.f274031d, 4, obtain, obtain2, 0) && AbstractBinderC8408a.v() != null) {
                        AbstractBinderC8408a.v().replay();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.mobileqq.qqlive.widget.player.a
            public void setOutputMute(boolean z16) throws RemoteException {
                int i3;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                    iPatchRedirector.redirect((short) 12, (Object) this, z16);
                    return;
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.mobileqq.qqlive.widget.player.IQQLiveRemotePlayer");
                    if (z16) {
                        i3 = 1;
                    } else {
                        i3 = 0;
                    }
                    obtain.writeInt(i3);
                    if (!OaidMonitor.binderTransact(this.f274031d, 9, obtain, obtain2, 0) && AbstractBinderC8408a.v() != null) {
                        AbstractBinderC8408a.v().setOutputMute(z16);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.mobileqq.qqlive.widget.player.a
            public void setXYAxis(int i3) throws RemoteException {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
                    iPatchRedirector.redirect((short) 15, (Object) this, i3);
                    return;
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.mobileqq.qqlive.widget.player.IQQLiveRemotePlayer");
                    obtain.writeInt(i3);
                    if (!OaidMonitor.binderTransact(this.f274031d, 12, obtain, obtain2, 0) && AbstractBinderC8408a.v() != null) {
                        AbstractBinderC8408a.v().setXYAxis(i3);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.mobileqq.qqlive.widget.player.a
            public void start(String str) throws RemoteException {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                    iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
                    return;
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.mobileqq.qqlive.widget.player.IQQLiveRemotePlayer");
                    obtain.writeString(str);
                    if (!OaidMonitor.binderTransact(this.f274031d, 2, obtain, obtain2, 0) && AbstractBinderC8408a.v() != null) {
                        AbstractBinderC8408a.v().start(str);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.mobileqq.qqlive.widget.player.a
            public void stop() throws RemoteException {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                    iPatchRedirector.redirect((short) 8, (Object) this);
                    return;
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.mobileqq.qqlive.widget.player.IQQLiveRemotePlayer");
                    if (!OaidMonitor.binderTransact(this.f274031d, 5, obtain, obtain2, 0) && AbstractBinderC8408a.v() != null) {
                        AbstractBinderC8408a.v().stop();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.mobileqq.qqlive.widget.player.a
            public void switchStream(String str) throws RemoteException {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                    iPatchRedirector.redirect((short) 10, (Object) this, (Object) str);
                    return;
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.mobileqq.qqlive.widget.player.IQQLiveRemotePlayer");
                    obtain.writeString(str);
                    if (!OaidMonitor.binderTransact(this.f274031d, 7, obtain, obtain2, 0) && AbstractBinderC8408a.v() != null) {
                        AbstractBinderC8408a.v().switchStream(str);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }
        }

        public AbstractBinderC8408a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                attachInterface(this, "com.tencent.mobileqq.qqlive.widget.player.IQQLiveRemotePlayer");
            }
        }

        public static a j(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.tencent.mobileqq.qqlive.widget.player.IQQLiveRemotePlayer");
            if (queryLocalInterface != null && (queryLocalInterface instanceof a)) {
                return (a) queryLocalInterface;
            }
            return new C8409a(iBinder);
        }

        public static a v() {
            return C8409a.f274030e;
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
            Surface surface;
            IPatchRedirector iPatchRedirector = $redirector_;
            boolean z16 = false;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), parcel, parcel2, Integer.valueOf(i16))).booleanValue();
            }
            if (i3 != 1598968902) {
                switch (i3) {
                    case 1:
                        parcel.enforceInterface("com.tencent.mobileqq.qqlive.widget.player.IQQLiveRemotePlayer");
                        prepare(parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 2:
                        parcel.enforceInterface("com.tencent.mobileqq.qqlive.widget.player.IQQLiveRemotePlayer");
                        start(parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 3:
                        parcel.enforceInterface("com.tencent.mobileqq.qqlive.widget.player.IQQLiveRemotePlayer");
                        pause();
                        parcel2.writeNoException();
                        return true;
                    case 4:
                        parcel.enforceInterface("com.tencent.mobileqq.qqlive.widget.player.IQQLiveRemotePlayer");
                        replay();
                        parcel2.writeNoException();
                        return true;
                    case 5:
                        parcel.enforceInterface("com.tencent.mobileqq.qqlive.widget.player.IQQLiveRemotePlayer");
                        stop();
                        parcel2.writeNoException();
                        return true;
                    case 6:
                        parcel.enforceInterface("com.tencent.mobileqq.qqlive.widget.player.IQQLiveRemotePlayer");
                        release();
                        parcel2.writeNoException();
                        return true;
                    case 7:
                        parcel.enforceInterface("com.tencent.mobileqq.qqlive.widget.player.IQQLiveRemotePlayer");
                        switchStream(parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 8:
                        parcel.enforceInterface("com.tencent.mobileqq.qqlive.widget.player.IQQLiveRemotePlayer");
                        boolean isOutputMute = isOutputMute();
                        parcel2.writeNoException();
                        parcel2.writeInt(isOutputMute ? 1 : 0);
                        return true;
                    case 9:
                        parcel.enforceInterface("com.tencent.mobileqq.qqlive.widget.player.IQQLiveRemotePlayer");
                        if (parcel.readInt() != 0) {
                            z16 = true;
                        }
                        setOutputMute(z16);
                        parcel2.writeNoException();
                        return true;
                    case 10:
                        parcel.enforceInterface("com.tencent.mobileqq.qqlive.widget.player.IQQLiveRemotePlayer");
                        boolean isPlaying = isPlaying();
                        parcel2.writeNoException();
                        parcel2.writeInt(isPlaying ? 1 : 0);
                        return true;
                    case 11:
                        parcel.enforceInterface("com.tencent.mobileqq.qqlive.widget.player.IQQLiveRemotePlayer");
                        SizeParcelable videoSize = getVideoSize();
                        parcel2.writeNoException();
                        if (videoSize != null) {
                            parcel2.writeInt(1);
                            videoSize.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 12:
                        parcel.enforceInterface("com.tencent.mobileqq.qqlive.widget.player.IQQLiveRemotePlayer");
                        setXYAxis(parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 13:
                        parcel.enforceInterface("com.tencent.mobileqq.qqlive.widget.player.IQQLiveRemotePlayer");
                        if (parcel.readInt() != 0) {
                            surface = (Surface) Surface.CREATOR.createFromParcel(parcel);
                        } else {
                            surface = null;
                        }
                        o2(surface);
                        parcel2.writeNoException();
                        return true;
                    case 14:
                        parcel.enforceInterface("com.tencent.mobileqq.qqlive.widget.player.IQQLiveRemotePlayer");
                        a2(c.a.j(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 15:
                        parcel.enforceInterface("com.tencent.mobileqq.qqlive.widget.player.IQQLiveRemotePlayer");
                        J0(f.a.j(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 16:
                        parcel.enforceInterface("com.tencent.mobileqq.qqlive.widget.player.IQQLiveRemotePlayer");
                        K3(d.a.j(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 17:
                        parcel.enforceInterface("com.tencent.mobileqq.qqlive.widget.player.IQQLiveRemotePlayer");
                        Y2(e.a.j(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 18:
                        parcel.enforceInterface("com.tencent.mobileqq.qqlive.widget.player.IQQLiveRemotePlayer");
                        V3(b.a.j(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    default:
                        return super.onTransact(i3, parcel, parcel2, i16);
                }
            }
            parcel2.writeString("com.tencent.mobileqq.qqlive.widget.player.IQQLiveRemotePlayer");
            return true;
        }
    }

    void J0(f fVar) throws RemoteException;

    void K3(d dVar) throws RemoteException;

    void V3(b bVar) throws RemoteException;

    void Y2(e eVar) throws RemoteException;

    void a2(c cVar) throws RemoteException;

    SizeParcelable getVideoSize() throws RemoteException;

    boolean isOutputMute() throws RemoteException;

    boolean isPlaying() throws RemoteException;

    void o2(Surface surface) throws RemoteException;

    void pause() throws RemoteException;

    void prepare(String str) throws RemoteException;

    void release() throws RemoteException;

    void replay() throws RemoteException;

    void setOutputMute(boolean z16) throws RemoteException;

    void setXYAxis(int i3) throws RemoteException;

    void start(String str) throws RemoteException;

    void stop() throws RemoteException;

    void switchStream(String str) throws RemoteException;
}
