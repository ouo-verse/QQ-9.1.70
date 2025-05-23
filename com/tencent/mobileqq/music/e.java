package com.tencent.mobileqq.music;

import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.tencent.mobileqq.music.c;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;

/* compiled from: P */
/* loaded from: classes15.dex */
public interface e extends IInterface {

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static abstract class a extends Binder implements e {
        static IPatchRedirector $redirector_;

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: P */
        /* renamed from: com.tencent.mobileqq.music.e$a$a, reason: collision with other inner class name */
        /* loaded from: classes15.dex */
        public static class C8123a implements e {
            static IPatchRedirector $redirector_;

            /* renamed from: e, reason: collision with root package name */
            public static e f251880e;

            /* renamed from: d, reason: collision with root package name */
            private IBinder f251881d;

            C8123a(IBinder iBinder) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) iBinder);
                } else {
                    this.f251881d = iBinder;
                }
            }

            @Override // com.tencent.mobileqq.music.e
            public SongInfo[] B2() throws RemoteException {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
                    return (SongInfo[]) iPatchRedirector.redirect((short) 20, (Object) this);
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.mobileqq.music.IQQPlayerService");
                    if (!OaidMonitor.binderTransact(this.f251881d, 17, obtain, obtain2, 0) && a.v() != null) {
                        return a.v().B2();
                    }
                    obtain2.readException();
                    return (SongInfo[]) obtain2.createTypedArray(SongInfo.CREATOR);
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.mobileqq.music.e
            public void C4(c cVar) throws RemoteException {
                IBinder iBinder;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
                    iPatchRedirector.redirect((short) 28, (Object) this, (Object) cVar);
                    return;
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.mobileqq.music.IQQPlayerService");
                    if (cVar != null) {
                        iBinder = cVar.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    if (!OaidMonitor.binderTransact(this.f251881d, 25, obtain, obtain2, 0) && a.v() != null) {
                        a.v().C4(cVar);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.mobileqq.music.e
            public Intent N0() throws RemoteException {
                Intent intent;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
                    return (Intent) iPatchRedirector.redirect((short) 22, (Object) this);
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.mobileqq.music.IQQPlayerService");
                    if (!OaidMonitor.binderTransact(this.f251881d, 19, obtain, obtain2, 0) && a.v() != null) {
                        return a.v().N0();
                    }
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        intent = (Intent) Intent.CREATOR.createFromParcel(obtain2);
                    } else {
                        intent = null;
                    }
                    return intent;
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.mobileqq.music.e
            public int O() throws RemoteException {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
                    return ((Integer) iPatchRedirector.redirect((short) 19, (Object) this)).intValue();
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.mobileqq.music.IQQPlayerService");
                    if (!OaidMonitor.binderTransact(this.f251881d, 16, obtain, obtain2, 0) && a.v() != null) {
                        return a.v().O();
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.mobileqq.music.e
            public String T4(int i3, String str) throws RemoteException {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
                    return (String) iPatchRedirector.redirect((short) 26, (Object) this, i3, (Object) str);
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.mobileqq.music.IQQPlayerService");
                    obtain.writeInt(i3);
                    obtain.writeString(str);
                    if (!OaidMonitor.binderTransact(this.f251881d, 23, obtain, obtain2, 0) && a.v() != null) {
                        return a.v().T4(i3, str);
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.mobileqq.music.e
            public int X2() throws RemoteException {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                    return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this)).intValue();
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.mobileqq.music.IQQPlayerService");
                    if (!OaidMonitor.binderTransact(this.f251881d, 10, obtain, obtain2, 0) && a.v() != null) {
                        return a.v().X2();
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.mobileqq.music.e
            public void X3(c cVar) throws RemoteException {
                IBinder iBinder;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
                    iPatchRedirector.redirect((short) 29, (Object) this, (Object) cVar);
                    return;
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.mobileqq.music.IQQPlayerService");
                    if (cVar != null) {
                        iBinder = cVar.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    if (!OaidMonitor.binderTransact(this.f251881d, 26, obtain, obtain2, 0) && a.v() != null) {
                        a.v().X3(cVar);
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
                return this.f251881d;
            }

            @Override // com.tencent.mobileqq.music.e
            public void b2(String str, SongInfo[] songInfoArr, int i3) throws RemoteException {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    iPatchRedirector.redirect((short) 4, this, str, songInfoArr, Integer.valueOf(i3));
                    return;
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.mobileqq.music.IQQPlayerService");
                    obtain.writeString(str);
                    obtain.writeTypedArray(songInfoArr, 0);
                    obtain.writeInt(i3);
                    if (!OaidMonitor.binderTransact(this.f251881d, 1, obtain, obtain2, 0) && a.v() != null) {
                        a.v().b2(str, songInfoArr, i3);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.mobileqq.music.e
            public boolean b3(String str) throws RemoteException {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 25, (Object) this, (Object) str)).booleanValue();
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.mobileqq.music.IQQPlayerService");
                    obtain.writeString(str);
                    boolean z16 = false;
                    if (!OaidMonitor.binderTransact(this.f251881d, 22, obtain, obtain2, 0) && a.v() != null) {
                        return a.v().b3(str);
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

            @Override // com.tencent.mobileqq.music.e
            public SongInfo getCurrentSong() throws RemoteException {
                SongInfo songInfo;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
                    return (SongInfo) iPatchRedirector.redirect((short) 16, (Object) this);
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.mobileqq.music.IQQPlayerService");
                    if (!OaidMonitor.binderTransact(this.f251881d, 13, obtain, obtain2, 0) && a.v() != null) {
                        return a.v().getCurrentSong();
                    }
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        songInfo = SongInfo.CREATOR.createFromParcel(obtain2);
                    } else {
                        songInfo = null;
                    }
                    return songInfo;
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.mobileqq.music.e
            public int getCurrentSongPosition() throws RemoteException {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
                    return ((Integer) iPatchRedirector.redirect((short) 15, (Object) this)).intValue();
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.mobileqq.music.IQQPlayerService");
                    if (!OaidMonitor.binderTransact(this.f251881d, 12, obtain, obtain2, 0) && a.v() != null) {
                        return a.v().getCurrentSongPosition();
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.mobileqq.music.e
            public int getDuration() throws RemoteException {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
                    return ((Integer) iPatchRedirector.redirect((short) 14, (Object) this)).intValue();
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.mobileqq.music.IQQPlayerService");
                    if (!OaidMonitor.binderTransact(this.f251881d, 11, obtain, obtain2, 0) && a.v() != null) {
                        return a.v().getDuration();
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.mobileqq.music.e
            public Bundle getExtras() throws RemoteException {
                Bundle bundle;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
                    return (Bundle) iPatchRedirector.redirect((short) 24, (Object) this);
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.mobileqq.music.IQQPlayerService");
                    if (!OaidMonitor.binderTransact(this.f251881d, 21, obtain, obtain2, 0) && a.v() != null) {
                        return a.v().getExtras();
                    }
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        bundle = (Bundle) Bundle.CREATOR.createFromParcel(obtain2);
                    } else {
                        bundle = null;
                    }
                    return bundle;
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.mobileqq.music.e
            public int getPlayState() throws RemoteException {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                    return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.mobileqq.music.IQQPlayerService");
                    if (!OaidMonitor.binderTransact(this.f251881d, 9, obtain, obtain2, 0) && a.v() != null) {
                        return a.v().getPlayState();
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.mobileqq.music.e
            public String getToken() throws RemoteException {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
                    return (String) iPatchRedirector.redirect((short) 27, (Object) this);
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.mobileqq.music.IQQPlayerService");
                    if (!OaidMonitor.binderTransact(this.f251881d, 24, obtain, obtain2, 0) && a.v() != null) {
                        return a.v().getToken();
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.mobileqq.music.e
            public boolean isPlaying() throws RemoteException {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.mobileqq.music.IQQPlayerService");
                    boolean z16 = false;
                    if (!OaidMonitor.binderTransact(this.f251881d, 8, obtain, obtain2, 0) && a.v() != null) {
                        return a.v().isPlaying();
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

            @Override // com.tencent.mobileqq.music.e
            public void m2(Intent intent) throws RemoteException {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
                    iPatchRedirector.redirect((short) 21, (Object) this, (Object) intent);
                    return;
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.mobileqq.music.IQQPlayerService");
                    if (intent != null) {
                        obtain.writeInt(1);
                        intent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!OaidMonitor.binderTransact(this.f251881d, 18, obtain, obtain2, 0) && a.v() != null) {
                        a.v().m2(intent);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.mobileqq.music.e
            public void p0() throws RemoteException {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                    iPatchRedirector.redirect((short) 10, (Object) this);
                    return;
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.mobileqq.music.IQQPlayerService");
                    if (!OaidMonitor.binderTransact(this.f251881d, 7, obtain, obtain2, 0) && a.v() != null) {
                        a.v().p0();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.mobileqq.music.e
            public void pause() throws RemoteException {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                    iPatchRedirector.redirect((short) 5, (Object) this);
                    return;
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.mobileqq.music.IQQPlayerService");
                    if (!OaidMonitor.binderTransact(this.f251881d, 2, obtain, obtain2, 0) && a.v() != null) {
                        a.v().pause();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.mobileqq.music.e
            public int q4() throws RemoteException {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
                    return ((Integer) iPatchRedirector.redirect((short) 18, (Object) this)).intValue();
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.mobileqq.music.IQQPlayerService");
                    if (!OaidMonitor.binderTransact(this.f251881d, 15, obtain, obtain2, 0) && a.v() != null) {
                        return a.v().q4();
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.mobileqq.music.e
            public void r() throws RemoteException {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                    iPatchRedirector.redirect((short) 9, (Object) this);
                    return;
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.mobileqq.music.IQQPlayerService");
                    if (!OaidMonitor.binderTransact(this.f251881d, 6, obtain, obtain2, 0) && a.v() != null) {
                        a.v().r();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.mobileqq.music.e
            public void resume() throws RemoteException {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                    iPatchRedirector.redirect((short) 6, (Object) this);
                    return;
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.mobileqq.music.IQQPlayerService");
                    if (!OaidMonitor.binderTransact(this.f251881d, 3, obtain, obtain2, 0) && a.v() != null) {
                        a.v().resume();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.mobileqq.music.e
            public void seekTo(int i3) throws RemoteException {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
                    iPatchRedirector.redirect((short) 31, (Object) this, i3);
                    return;
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.mobileqq.music.IQQPlayerService");
                    obtain.writeInt(i3);
                    if (!OaidMonitor.binderTransact(this.f251881d, 28, obtain, obtain2, 0) && a.v() != null) {
                        a.v().seekTo(i3);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.mobileqq.music.e
            public void setExtras(Bundle bundle) throws RemoteException {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
                    iPatchRedirector.redirect((short) 23, (Object) this, (Object) bundle);
                    return;
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.mobileqq.music.IQQPlayerService");
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!OaidMonitor.binderTransact(this.f251881d, 20, obtain, obtain2, 0) && a.v() != null) {
                        a.v().setExtras(bundle);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.mobileqq.music.e
            public void setPlayMode(int i3) throws RemoteException {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                    iPatchRedirector.redirect((short) 8, (Object) this, i3);
                    return;
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.mobileqq.music.IQQPlayerService");
                    obtain.writeInt(i3);
                    if (!OaidMonitor.binderTransact(this.f251881d, 5, obtain, obtain2, 0) && a.v() != null) {
                        a.v().setPlayMode(i3);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.mobileqq.music.e
            public void stop() throws RemoteException {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                    iPatchRedirector.redirect((short) 7, (Object) this);
                    return;
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.mobileqq.music.IQQPlayerService");
                    if (!OaidMonitor.binderTransact(this.f251881d, 4, obtain, obtain2, 0) && a.v() != null) {
                        a.v().stop();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.mobileqq.music.e
            public int w3() throws RemoteException {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
                    return ((Integer) iPatchRedirector.redirect((short) 30, (Object) this)).intValue();
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.mobileqq.music.IQQPlayerService");
                    if (!OaidMonitor.binderTransact(this.f251881d, 27, obtain, obtain2, 0) && a.v() != null) {
                        return a.v().w3();
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.mobileqq.music.e
            public SongInfo y0() throws RemoteException {
                SongInfo songInfo;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
                    return (SongInfo) iPatchRedirector.redirect((short) 17, (Object) this);
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.mobileqq.music.IQQPlayerService");
                    if (!OaidMonitor.binderTransact(this.f251881d, 14, obtain, obtain2, 0) && a.v() != null) {
                        return a.v().y0();
                    }
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        songInfo = SongInfo.CREATOR.createFromParcel(obtain2);
                    } else {
                        songInfo = null;
                    }
                    return songInfo;
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
                attachInterface(this, "com.tencent.mobileqq.music.IQQPlayerService");
            }
        }

        public static e j(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.tencent.mobileqq.music.IQQPlayerService");
            if (queryLocalInterface != null && (queryLocalInterface instanceof e)) {
                return (e) queryLocalInterface;
            }
            return new C8123a(iBinder);
        }

        public static e v() {
            return C8123a.f251880e;
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
                Intent intent = null;
                Bundle bundle = null;
                switch (i3) {
                    case 1:
                        parcel.enforceInterface("com.tencent.mobileqq.music.IQQPlayerService");
                        b2(parcel.readString(), (SongInfo[]) parcel.createTypedArray(SongInfo.CREATOR), parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 2:
                        parcel.enforceInterface("com.tencent.mobileqq.music.IQQPlayerService");
                        pause();
                        parcel2.writeNoException();
                        return true;
                    case 3:
                        parcel.enforceInterface("com.tencent.mobileqq.music.IQQPlayerService");
                        resume();
                        parcel2.writeNoException();
                        return true;
                    case 4:
                        parcel.enforceInterface("com.tencent.mobileqq.music.IQQPlayerService");
                        stop();
                        parcel2.writeNoException();
                        return true;
                    case 5:
                        parcel.enforceInterface("com.tencent.mobileqq.music.IQQPlayerService");
                        setPlayMode(parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 6:
                        parcel.enforceInterface("com.tencent.mobileqq.music.IQQPlayerService");
                        r();
                        parcel2.writeNoException();
                        return true;
                    case 7:
                        parcel.enforceInterface("com.tencent.mobileqq.music.IQQPlayerService");
                        p0();
                        parcel2.writeNoException();
                        return true;
                    case 8:
                        parcel.enforceInterface("com.tencent.mobileqq.music.IQQPlayerService");
                        boolean isPlaying = isPlaying();
                        parcel2.writeNoException();
                        parcel2.writeInt(isPlaying ? 1 : 0);
                        return true;
                    case 9:
                        parcel.enforceInterface("com.tencent.mobileqq.music.IQQPlayerService");
                        int playState = getPlayState();
                        parcel2.writeNoException();
                        parcel2.writeInt(playState);
                        return true;
                    case 10:
                        parcel.enforceInterface("com.tencent.mobileqq.music.IQQPlayerService");
                        int X2 = X2();
                        parcel2.writeNoException();
                        parcel2.writeInt(X2);
                        return true;
                    case 11:
                        parcel.enforceInterface("com.tencent.mobileqq.music.IQQPlayerService");
                        int duration = getDuration();
                        parcel2.writeNoException();
                        parcel2.writeInt(duration);
                        return true;
                    case 12:
                        parcel.enforceInterface("com.tencent.mobileqq.music.IQQPlayerService");
                        int currentSongPosition = getCurrentSongPosition();
                        parcel2.writeNoException();
                        parcel2.writeInt(currentSongPosition);
                        return true;
                    case 13:
                        parcel.enforceInterface("com.tencent.mobileqq.music.IQQPlayerService");
                        SongInfo currentSong = getCurrentSong();
                        parcel2.writeNoException();
                        if (currentSong != null) {
                            parcel2.writeInt(1);
                            currentSong.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 14:
                        parcel.enforceInterface("com.tencent.mobileqq.music.IQQPlayerService");
                        SongInfo y06 = y0();
                        parcel2.writeNoException();
                        if (y06 != null) {
                            parcel2.writeInt(1);
                            y06.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 15:
                        parcel.enforceInterface("com.tencent.mobileqq.music.IQQPlayerService");
                        int q46 = q4();
                        parcel2.writeNoException();
                        parcel2.writeInt(q46);
                        return true;
                    case 16:
                        parcel.enforceInterface("com.tencent.mobileqq.music.IQQPlayerService");
                        int O = O();
                        parcel2.writeNoException();
                        parcel2.writeInt(O);
                        return true;
                    case 17:
                        parcel.enforceInterface("com.tencent.mobileqq.music.IQQPlayerService");
                        SongInfo[] B2 = B2();
                        parcel2.writeNoException();
                        parcel2.writeTypedArray(B2, 1);
                        return true;
                    case 18:
                        parcel.enforceInterface("com.tencent.mobileqq.music.IQQPlayerService");
                        if (parcel.readInt() != 0) {
                            intent = (Intent) Intent.CREATOR.createFromParcel(parcel);
                        }
                        m2(intent);
                        parcel2.writeNoException();
                        return true;
                    case 19:
                        parcel.enforceInterface("com.tencent.mobileqq.music.IQQPlayerService");
                        Intent N0 = N0();
                        parcel2.writeNoException();
                        if (N0 != null) {
                            parcel2.writeInt(1);
                            N0.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 20:
                        parcel.enforceInterface("com.tencent.mobileqq.music.IQQPlayerService");
                        if (parcel.readInt() != 0) {
                            bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                        }
                        setExtras(bundle);
                        parcel2.writeNoException();
                        return true;
                    case 21:
                        parcel.enforceInterface("com.tencent.mobileqq.music.IQQPlayerService");
                        Bundle extras = getExtras();
                        parcel2.writeNoException();
                        if (extras != null) {
                            parcel2.writeInt(1);
                            extras.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 22:
                        parcel.enforceInterface("com.tencent.mobileqq.music.IQQPlayerService");
                        boolean b36 = b3(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeInt(b36 ? 1 : 0);
                        return true;
                    case 23:
                        parcel.enforceInterface("com.tencent.mobileqq.music.IQQPlayerService");
                        String T4 = T4(parcel.readInt(), parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeString(T4);
                        return true;
                    case 24:
                        parcel.enforceInterface("com.tencent.mobileqq.music.IQQPlayerService");
                        String token = getToken();
                        parcel2.writeNoException();
                        parcel2.writeString(token);
                        return true;
                    case 25:
                        parcel.enforceInterface("com.tencent.mobileqq.music.IQQPlayerService");
                        C4(c.a.j(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 26:
                        parcel.enforceInterface("com.tencent.mobileqq.music.IQQPlayerService");
                        X3(c.a.j(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 27:
                        parcel.enforceInterface("com.tencent.mobileqq.music.IQQPlayerService");
                        int w3 = w3();
                        parcel2.writeNoException();
                        parcel2.writeInt(w3);
                        return true;
                    case 28:
                        parcel.enforceInterface("com.tencent.mobileqq.music.IQQPlayerService");
                        seekTo(parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    default:
                        return super.onTransact(i3, parcel, parcel2, i16);
                }
            }
            parcel2.writeString("com.tencent.mobileqq.music.IQQPlayerService");
            return true;
        }
    }

    SongInfo[] B2() throws RemoteException;

    void C4(c cVar) throws RemoteException;

    Intent N0() throws RemoteException;

    int O() throws RemoteException;

    String T4(int i3, String str) throws RemoteException;

    int X2() throws RemoteException;

    void X3(c cVar) throws RemoteException;

    void b2(String str, SongInfo[] songInfoArr, int i3) throws RemoteException;

    boolean b3(String str) throws RemoteException;

    SongInfo getCurrentSong() throws RemoteException;

    int getCurrentSongPosition() throws RemoteException;

    int getDuration() throws RemoteException;

    Bundle getExtras() throws RemoteException;

    int getPlayState() throws RemoteException;

    String getToken() throws RemoteException;

    boolean isPlaying() throws RemoteException;

    void m2(Intent intent) throws RemoteException;

    void p0() throws RemoteException;

    void pause() throws RemoteException;

    int q4() throws RemoteException;

    void r() throws RemoteException;

    void resume() throws RemoteException;

    void seekTo(int i3) throws RemoteException;

    void setExtras(Bundle bundle) throws RemoteException;

    void setPlayMode(int i3) throws RemoteException;

    void stop() throws RemoteException;

    int w3() throws RemoteException;

    SongInfo y0() throws RemoteException;
}
