package com.tencent.mobileqq.qqlive.widget.player;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.callback.room.VideoSeiInfo;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;

/* compiled from: P */
/* loaded from: classes17.dex */
public interface e extends IInterface {

    /* compiled from: P */
    /* loaded from: classes17.dex */
    public static abstract class a extends Binder implements e {
        static IPatchRedirector $redirector_;

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: P */
        /* renamed from: com.tencent.mobileqq.qqlive.widget.player.e$a$a, reason: collision with other inner class name */
        /* loaded from: classes17.dex */
        public static class C8413a implements e {
            static IPatchRedirector $redirector_;

            /* renamed from: e, reason: collision with root package name */
            public static e f274038e;

            /* renamed from: d, reason: collision with root package name */
            private IBinder f274039d;

            C8413a(IBinder iBinder) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) iBinder);
                } else {
                    this.f274039d = iBinder;
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (IBinder) iPatchRedirector.redirect((short) 2, (Object) this);
                }
                return this.f274039d;
            }

            @Override // com.tencent.mobileqq.qqlive.widget.player.e
            public void q(VideoSeiInfo videoSeiInfo) throws RemoteException {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    iPatchRedirector.redirect((short) 4, (Object) this, (Object) videoSeiInfo);
                    return;
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.mobileqq.qqlive.widget.player.IRemoteSeiInfoListener");
                    if (videoSeiInfo != null) {
                        obtain.writeInt(1);
                        videoSeiInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!OaidMonitor.binderTransact(this.f274039d, 1, obtain, obtain2, 0) && a.v() != null) {
                        a.v().q(videoSeiInfo);
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
                attachInterface(this, "com.tencent.mobileqq.qqlive.widget.player.IRemoteSeiInfoListener");
            }
        }

        public static e j(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.tencent.mobileqq.qqlive.widget.player.IRemoteSeiInfoListener");
            if (queryLocalInterface != null && (queryLocalInterface instanceof e)) {
                return (e) queryLocalInterface;
            }
            return new C8413a(iBinder);
        }

        public static e v() {
            return C8413a.f274038e;
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
            VideoSeiInfo videoSeiInfo;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), parcel, parcel2, Integer.valueOf(i16))).booleanValue();
            }
            if (i3 != 1598968902) {
                if (i3 != 1) {
                    return super.onTransact(i3, parcel, parcel2, i16);
                }
                parcel.enforceInterface("com.tencent.mobileqq.qqlive.widget.player.IRemoteSeiInfoListener");
                if (parcel.readInt() != 0) {
                    videoSeiInfo = VideoSeiInfo.CREATOR.createFromParcel(parcel);
                } else {
                    videoSeiInfo = null;
                }
                q(videoSeiInfo);
                parcel2.writeNoException();
                return true;
            }
            parcel2.writeString("com.tencent.mobileqq.qqlive.widget.player.IRemoteSeiInfoListener");
            return true;
        }
    }

    void q(VideoSeiInfo videoSeiInfo) throws RemoteException;
}
