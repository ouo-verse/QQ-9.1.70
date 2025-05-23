package com.tencent.mobileqq.music;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;

/* compiled from: P */
/* loaded from: classes15.dex */
public interface c extends IInterface {

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static abstract class a extends Binder implements c {
        static IPatchRedirector $redirector_;

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: P */
        /* renamed from: com.tencent.mobileqq.music.c$a$a, reason: collision with other inner class name */
        /* loaded from: classes15.dex */
        public static class C8122a implements c {
            static IPatchRedirector $redirector_;

            /* renamed from: e, reason: collision with root package name */
            public static c f251878e;

            /* renamed from: d, reason: collision with root package name */
            private IBinder f251879d;

            C8122a(IBinder iBinder) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) iBinder);
                } else {
                    this.f251879d = iBinder;
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (IBinder) iPatchRedirector.redirect((short) 2, (Object) this);
                }
                return this.f251879d;
            }

            @Override // com.tencent.mobileqq.music.c
            public void onPlaySongChanged(SongInfo songInfo) throws RemoteException {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                    iPatchRedirector.redirect((short) 5, (Object) this, (Object) songInfo);
                    return;
                }
                Parcel obtain = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.mobileqq.music.IQQPlayerCallback");
                    if (songInfo != null) {
                        obtain.writeInt(1);
                        songInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!OaidMonitor.binderTransact(this.f251879d, 2, obtain, null, 1) && a.v() != null) {
                        a.v().onPlaySongChanged(songInfo);
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.mobileqq.music.c
            public void onPlayStateChanged(int i3) throws RemoteException {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    iPatchRedirector.redirect((short) 4, (Object) this, i3);
                    return;
                }
                Parcel obtain = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.mobileqq.music.IQQPlayerCallback");
                    obtain.writeInt(i3);
                    if (!OaidMonitor.binderTransact(this.f251879d, 1, obtain, null, 1) && a.v() != null) {
                        a.v().onPlayStateChanged(i3);
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain);
                }
            }
        }

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                attachInterface(this, "com.tencent.mobileqq.music.IQQPlayerCallback");
            }
        }

        public static c j(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.tencent.mobileqq.music.IQQPlayerCallback");
            if (queryLocalInterface != null && (queryLocalInterface instanceof c)) {
                return (c) queryLocalInterface;
            }
            return new C8122a(iBinder);
        }

        public static c v() {
            return C8122a.f251878e;
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
            SongInfo songInfo;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), parcel, parcel2, Integer.valueOf(i16))).booleanValue();
            }
            if (i3 != 1598968902) {
                if (i3 != 1) {
                    if (i3 != 2) {
                        return super.onTransact(i3, parcel, parcel2, i16);
                    }
                    parcel.enforceInterface("com.tencent.mobileqq.music.IQQPlayerCallback");
                    if (parcel.readInt() != 0) {
                        songInfo = SongInfo.CREATOR.createFromParcel(parcel);
                    } else {
                        songInfo = null;
                    }
                    onPlaySongChanged(songInfo);
                    return true;
                }
                parcel.enforceInterface("com.tencent.mobileqq.music.IQQPlayerCallback");
                onPlayStateChanged(parcel.readInt());
                return true;
            }
            parcel2.writeString("com.tencent.mobileqq.music.IQQPlayerCallback");
            return true;
        }
    }

    void onPlaySongChanged(SongInfo songInfo) throws RemoteException;

    void onPlayStateChanged(int i3) throws RemoteException;
}
