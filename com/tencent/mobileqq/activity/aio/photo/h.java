package com.tencent.mobileqq.activity.aio.photo;

import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.tencent.mobileqq.activity.aio.photo.i;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes10.dex */
public interface h extends IInterface {
    void A(long j3, int i3, int i16);

    void B(long j3);

    void C(long j3, int i3, Bundle bundle);

    void D(int i3);

    void D1(i iVar);

    Intent E(long j3, int i3) throws RemoteException;

    void G(long j3);

    void I1(long[] jArr);

    void J4(MessageForShortVideo messageForShortVideo);

    void T3();

    MessageForShortVideo Y1(long j3);

    void b(String str, int i3);

    @Deprecated
    String c2(String str, String str2);

    void d(long j3);

    void destory();

    void f(long j3);

    void f5(String str, int i3);

    void g(int i3, boolean z16, String str, String str2, String str3, String str4);

    void h(long j3, int i3);

    void h4(long j3);

    int k(long j3, int i3);

    void m(long j3);

    Intent u(long j3, int i3, int i16);

    void y(long j3, int i3, int i16);

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static abstract class a extends Binder implements h, IBinder.DeathRecipient {

        /* renamed from: d, reason: collision with root package name */
        protected i f179747d;

        /* compiled from: P */
        /* renamed from: com.tencent.mobileqq.activity.aio.photo.h$a$a, reason: collision with other inner class name */
        /* loaded from: classes10.dex */
        private static class C7133a implements h {

            /* renamed from: d, reason: collision with root package name */
            private IBinder f179748d;

            C7133a(IBinder iBinder) {
                this.f179748d = iBinder;
            }

            @Override // com.tencent.mobileqq.activity.aio.photo.h
            public void A(long j3, int i3, int i16) {
                Parcel obtain = Parcel.obtain();
                try {
                    try {
                        OaidMonitor.writeParcelToken(obtain, "com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider");
                        obtain.writeLong(j3);
                        obtain.writeInt(i3);
                        obtain.writeInt(i16);
                        OaidMonitor.binderTransact(this.f179748d, 2, obtain, null, 1);
                    } catch (RemoteException e16) {
                        if (QLog.isColorLevel()) {
                            QLog.e("IAIOImageProvider", 2, e16.getMessage(), e16);
                        }
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.mobileqq.activity.aio.photo.h
            public void B(long j3) {
                Parcel obtain = Parcel.obtain();
                try {
                    try {
                        OaidMonitor.writeParcelToken(obtain, "com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider");
                        obtain.writeLong(j3);
                        OaidMonitor.binderTransact(this.f179748d, 17, obtain, null, 1);
                    } catch (RemoteException e16) {
                        if (QLog.isColorLevel()) {
                            QLog.e("IAIOImageProvider", 2, e16.getMessage(), e16);
                        }
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.mobileqq.activity.aio.photo.h
            public void C(long j3, int i3, Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider");
                    obtain.writeLong(j3);
                    obtain.writeInt(i3);
                    obtain.writeBundle(bundle);
                    OaidMonitor.binderTransact(this.f179748d, 16, obtain, null, 1);
                } catch (RemoteException unused) {
                } catch (Throwable th5) {
                    OaidMonitor.parcelRecycle(obtain);
                    throw th5;
                }
                OaidMonitor.parcelRecycle(obtain);
            }

            @Override // com.tencent.mobileqq.activity.aio.photo.h
            public void D(int i3) {
                Parcel obtain = Parcel.obtain();
                try {
                    try {
                        OaidMonitor.writeParcelToken(obtain, "com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider");
                        obtain.writeInt(i3);
                        OaidMonitor.binderTransact(this.f179748d, 3, obtain, null, 1);
                    } catch (RemoteException e16) {
                        if (QLog.isColorLevel()) {
                            QLog.e("IAIOImageProvider", 2, e16.getMessage(), e16);
                        }
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.mobileqq.activity.aio.photo.h
            public void D1(i iVar) {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                try {
                    try {
                        OaidMonitor.writeParcelToken(obtain, "com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider");
                        if (iVar != null) {
                            iBinder = iVar.asBinder();
                        } else {
                            iBinder = null;
                        }
                        obtain.writeStrongBinder(iBinder);
                        OaidMonitor.binderTransact(this.f179748d, 4, obtain, null, 1);
                    } catch (RemoteException e16) {
                        if (QLog.isColorLevel()) {
                            QLog.e("IAIOImageProvider", 2, e16.getMessage(), e16);
                        }
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.mobileqq.activity.aio.photo.h
            public Intent E(long j3, int i3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                Intent intent = null;
                try {
                    try {
                        OaidMonitor.writeParcelToken(obtain, "com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider");
                        obtain.writeLong(j3);
                        obtain.writeInt(i3);
                        OaidMonitor.binderTransact(this.f179748d, 5, obtain, obtain2, 0);
                        obtain2.readException();
                        if (obtain2.readInt() != 0) {
                            intent = (Intent) Intent.CREATOR.createFromParcel(obtain2);
                        }
                    } catch (Exception e16) {
                        if (QLog.isColorLevel()) {
                            QLog.e("IAIOImageProvider", 2, e16.getMessage(), e16);
                        }
                    }
                    return intent;
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.mobileqq.activity.aio.photo.h
            public void G(long j3) {
                Parcel obtain = Parcel.obtain();
                try {
                    try {
                        OaidMonitor.writeParcelToken(obtain, "com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider");
                        obtain.writeLong(j3);
                        OaidMonitor.binderTransact(this.f179748d, 26, obtain, null, 1);
                    } catch (RemoteException e16) {
                        if (QLog.isColorLevel()) {
                            QLog.e("IAIOImageProvider", 2, e16.getMessage(), e16);
                        }
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.mobileqq.activity.aio.photo.h
            public void J4(MessageForShortVideo messageForShortVideo) {
                Parcel obtain = Parcel.obtain();
                try {
                    try {
                        OaidMonitor.writeParcelToken(obtain, "com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider");
                        obtain.writeParcelable(messageForShortVideo, 0);
                        OaidMonitor.binderTransact(this.f179748d, 18, obtain, null, 1);
                    } catch (RemoteException e16) {
                        if (QLog.isColorLevel()) {
                            QLog.e("IAIOImageProvider", 2, e16.getMessage(), e16);
                        }
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.mobileqq.activity.aio.photo.h
            public void T3() {
                Parcel obtain = Parcel.obtain();
                try {
                    try {
                        OaidMonitor.writeParcelToken(obtain, "com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider");
                        OaidMonitor.binderTransact(this.f179748d, 15, obtain, null, 1);
                    } catch (RemoteException e16) {
                        if (QLog.isColorLevel()) {
                            QLog.e("IAIOImageProvider", 2, e16.getMessage(), e16);
                        }
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f179748d;
            }

            @Override // com.tencent.mobileqq.activity.aio.photo.h
            public void b(String str, int i3) {
                Parcel obtain = Parcel.obtain();
                try {
                    try {
                        OaidMonitor.writeParcelToken(obtain, "com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider");
                        obtain.writeString(str);
                        obtain.writeInt(i3);
                        OaidMonitor.binderTransact(this.f179748d, 8, obtain, null, 1);
                    } catch (RemoteException e16) {
                        if (QLog.isColorLevel()) {
                            QLog.e("IAIOImageProvider", 2, e16.getMessage(), e16);
                        }
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.mobileqq.activity.aio.photo.h
            public void d(long j3) {
                Parcel obtain = Parcel.obtain();
                try {
                    try {
                        OaidMonitor.writeParcelToken(obtain, "com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider");
                        obtain.writeLong(j3);
                        OaidMonitor.binderTransact(this.f179748d, 13, obtain, null, 1);
                    } catch (RemoteException e16) {
                        if (QLog.isColorLevel()) {
                            QLog.e("IAIOImageProvider", 2, e16.getMessage(), e16);
                        }
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.mobileqq.activity.aio.photo.h
            public void destory() {
                Parcel obtain = Parcel.obtain();
                try {
                    try {
                        OaidMonitor.writeParcelToken(obtain, "com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider");
                        OaidMonitor.binderTransact(this.f179748d, 6, obtain, null, 1);
                    } catch (RemoteException e16) {
                        if (QLog.isColorLevel()) {
                            QLog.e("IAIOImageProvider", 2, e16.getMessage(), e16);
                        }
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.mobileqq.activity.aio.photo.h
            public void f(long j3) {
                Parcel obtain = Parcel.obtain();
                try {
                    try {
                        OaidMonitor.writeParcelToken(obtain, "com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider");
                        obtain.writeLong(j3);
                        OaidMonitor.binderTransact(this.f179748d, 11, obtain, null, 1);
                    } catch (RemoteException e16) {
                        if (QLog.isColorLevel()) {
                            QLog.e("IAIOImageProvider", 2, e16.getMessage(), e16);
                        }
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.mobileqq.activity.aio.photo.h
            public void g(int i3, boolean z16, String str, String str2, String str3, String str4) {
                int i16;
                Parcel obtain = Parcel.obtain();
                try {
                    try {
                        OaidMonitor.writeParcelToken(obtain, "com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider");
                        obtain.writeInt(i3);
                        if (z16) {
                            i16 = 1;
                        } else {
                            i16 = 0;
                        }
                        obtain.writeInt(i16);
                        obtain.writeString(str);
                        obtain.writeString(str2);
                        obtain.writeString(str3);
                        obtain.writeString(str4);
                        OaidMonitor.binderTransact(this.f179748d, 23, obtain, null, 1);
                    } catch (RemoteException e16) {
                        if (QLog.isColorLevel()) {
                            QLog.e("IAIOImageProvider", 2, "safetyReportForChat exception", e16);
                        }
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.mobileqq.activity.aio.photo.h
            public void h(long j3, int i3) {
                Parcel obtain = Parcel.obtain();
                try {
                    try {
                        OaidMonitor.writeParcelToken(obtain, "com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider");
                        obtain.writeLong(j3);
                        obtain.writeInt(i3);
                        OaidMonitor.binderTransact(this.f179748d, 7, obtain, null, 1);
                    } catch (RemoteException e16) {
                        if (QLog.isColorLevel()) {
                            QLog.e("IAIOImageProvider", 2, e16.getMessage(), e16);
                        }
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.mobileqq.activity.aio.photo.h
            public int k(long j3, int i3) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    try {
                        OaidMonitor.writeParcelToken(obtain, "com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider");
                        obtain.writeLong(j3);
                        obtain.writeInt(i3);
                        OaidMonitor.binderTransact(this.f179748d, 19, obtain, obtain2, 0);
                        obtain2.readException();
                        return obtain2.readInt();
                    } catch (RemoteException e16) {
                        if (QLog.isColorLevel()) {
                            QLog.e("IAIOImageProvider", 2, "getSaveFileProgress exception", e16);
                        }
                        OaidMonitor.parcelRecycle(obtain2);
                        OaidMonitor.parcelRecycle(obtain);
                        return -1;
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.mobileqq.activity.aio.photo.h
            public void m(long j3) {
                Parcel obtain = Parcel.obtain();
                try {
                    try {
                        OaidMonitor.writeParcelToken(obtain, "com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider");
                        obtain.writeLong(j3);
                        OaidMonitor.binderTransact(this.f179748d, 24, obtain, null, 1);
                    } catch (RemoteException e16) {
                        if (QLog.isColorLevel()) {
                            QLog.e("IAIOImageProvider", 2, e16.getMessage(), e16);
                        }
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.mobileqq.activity.aio.photo.h
            public Intent u(long j3, int i3, int i16) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                Intent intent = null;
                try {
                    try {
                        OaidMonitor.writeParcelToken(obtain, "com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider");
                        obtain.writeLong(j3);
                        obtain.writeInt(i3);
                        obtain.writeInt(i16);
                        OaidMonitor.binderTransact(this.f179748d, 9, obtain, obtain2, 0);
                        obtain2.readException();
                        if (obtain2.readInt() != 0) {
                            intent = (Intent) Intent.CREATOR.createFromParcel(obtain2);
                        }
                    } catch (RemoteException e16) {
                        if (QLog.isColorLevel()) {
                            QLog.e("IAIOImageProvider", 2, e16.getMessage(), e16);
                        }
                    }
                    return intent;
                } finally {
                    OaidMonitor.parcelRecycle(obtain);
                    OaidMonitor.parcelRecycle(obtain2);
                }
            }

            @Override // com.tencent.mobileqq.activity.aio.photo.h
            public void y(long j3, int i3, int i16) {
                Parcel obtain = Parcel.obtain();
                try {
                    try {
                        OaidMonitor.writeParcelToken(obtain, "com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider");
                        obtain.writeLong(j3);
                        obtain.writeInt(i3);
                        obtain.writeInt(i16);
                        OaidMonitor.binderTransact(this.f179748d, 1, obtain, null, 1);
                    } catch (RemoteException e16) {
                        if (QLog.isColorLevel()) {
                            QLog.e("IAIOImageProvider", 2, e16.getMessage(), e16);
                        }
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public a() {
            attachInterface(this, "com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider");
        }

        public static h j(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider");
            if (queryLocalInterface != null && (queryLocalInterface instanceof h)) {
                return (h) queryLocalInterface;
            }
            return new C7133a(iBinder);
        }

        private boolean v(int i3, Parcel parcel, Parcel parcel2) {
            boolean z16;
            switch (i3) {
                case 14:
                    parcel.enforceInterface("com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider");
                    MessageForShortVideo Y1 = Y1(parcel.readLong());
                    parcel2.writeNoException();
                    if (Y1 != null) {
                        parcel2.writeInt(1);
                        Y1.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 15:
                    parcel.enforceInterface("com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider");
                    T3();
                    parcel2.writeNoException();
                    return true;
                case 16:
                    parcel.enforceInterface("com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider");
                    C(parcel.readLong(), parcel.readInt(), parcel.readBundle());
                    parcel2.writeNoException();
                    return true;
                case 17:
                case 18:
                case 20:
                default:
                    return false;
                case 19:
                    parcel.enforceInterface("com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider");
                    int k3 = k(parcel.readLong(), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(k3);
                    return true;
                case 21:
                    parcel.enforceInterface("com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider");
                    f5(parcel.readString(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 22:
                    parcel.enforceInterface("com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider");
                    String c26 = c2(parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(c26);
                    return true;
                case 23:
                    parcel.enforceInterface("com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider");
                    int readInt = parcel.readInt();
                    int readInt2 = parcel.readInt();
                    String readString = parcel.readString();
                    String readString2 = parcel.readString();
                    String readString3 = parcel.readString();
                    String readString4 = parcel.readString();
                    if (readInt2 == 1) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    g(readInt, z16, readString, readString2, readString3, readString4);
                    parcel2.writeNoException();
                    return true;
            }
        }

        public void D1(i iVar) {
            try {
                iVar.asBinder().linkToDeath(this, 0);
                this.f179747d = iVar;
            } catch (RemoteException unused) {
                binderDied();
            }
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            destory();
        }

        public void destory() {
            if (QLog.isColorLevel()) {
                QLog.d("PEAK", 2, "binder destoryed");
            }
            this.f179747d = null;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i3, Parcel parcel, Parcel parcel2, int i16) throws RemoteException {
            try {
                if (i3 != 13) {
                    if (i3 != 20) {
                        if (i3 != 24) {
                            if (i3 != 26) {
                                if (i3 != 1598968902) {
                                    if (i3 != 17) {
                                        if (i3 != 18) {
                                            switch (i3) {
                                                case 1:
                                                    parcel.enforceInterface("com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider");
                                                    y(parcel.readLong(), parcel.readInt(), parcel.readInt());
                                                    parcel2.writeNoException();
                                                    return true;
                                                case 2:
                                                    parcel.enforceInterface("com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider");
                                                    A(parcel.readLong(), parcel.readInt(), parcel.readInt());
                                                    parcel2.writeNoException();
                                                    return true;
                                                case 3:
                                                    parcel.enforceInterface("com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider");
                                                    D(parcel.readInt());
                                                    parcel2.writeNoException();
                                                    return true;
                                                case 4:
                                                    parcel.enforceInterface("com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider");
                                                    D1(i.a.j(parcel.readStrongBinder()));
                                                    parcel2.writeNoException();
                                                    return true;
                                                case 5:
                                                    parcel.enforceInterface("com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider");
                                                    Intent E = E(parcel.readLong(), parcel.readInt());
                                                    parcel2.writeNoException();
                                                    if (E != null) {
                                                        parcel2.writeInt(1);
                                                        E.writeToParcel(parcel2, 1);
                                                    } else {
                                                        parcel2.writeInt(0);
                                                    }
                                                    return true;
                                                case 6:
                                                    parcel.enforceInterface("com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider");
                                                    destory();
                                                    parcel2.writeNoException();
                                                    return true;
                                                case 7:
                                                    parcel.enforceInterface("com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider");
                                                    h(parcel.readLong(), parcel.readInt());
                                                    parcel2.writeNoException();
                                                    return true;
                                                case 8:
                                                    parcel.enforceInterface("com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider");
                                                    b(parcel.readString(), parcel.readInt());
                                                    parcel2.writeNoException();
                                                    return true;
                                                case 9:
                                                    parcel.enforceInterface("com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider");
                                                    Intent u16 = u(parcel.readLong(), parcel.readInt(), parcel.readInt());
                                                    parcel2.writeNoException();
                                                    if (u16 != null) {
                                                        parcel2.writeInt(1);
                                                        u16.writeToParcel(parcel2, 1);
                                                    } else {
                                                        parcel2.writeInt(0);
                                                    }
                                                    return true;
                                                case 10:
                                                    parcel.enforceInterface("com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider");
                                                    h4(parcel.readLong());
                                                    parcel2.writeNoException();
                                                    return true;
                                                case 11:
                                                    parcel.enforceInterface("com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider");
                                                    f(parcel.readLong());
                                                    parcel2.writeNoException();
                                                    return true;
                                                default:
                                                    if (v(i3, parcel, parcel2)) {
                                                        return true;
                                                    }
                                                    return super.onTransact(i3, parcel, parcel2, i16);
                                            }
                                        }
                                        parcel.enforceInterface("com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider");
                                        J4((MessageForShortVideo) parcel.readParcelable(MessageForShortVideo.class.getClassLoader()));
                                        parcel2.writeNoException();
                                        return true;
                                    }
                                    parcel.enforceInterface("com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider");
                                    B(parcel.readLong());
                                    parcel2.writeNoException();
                                    return true;
                                }
                                parcel2.writeString("com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider");
                                return true;
                            }
                            parcel.enforceInterface("com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider");
                            G(parcel.readLong());
                            parcel2.writeNoException();
                            return true;
                        }
                        parcel.enforceInterface("com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider");
                        m(parcel.readLong());
                        parcel2.writeNoException();
                        return true;
                    }
                    parcel.enforceInterface("com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider");
                    long[] jArr = new long[parcel.readInt()];
                    parcel.readLongArray(jArr);
                    I1(jArr);
                    parcel2.writeNoException();
                    return true;
                }
                parcel.enforceInterface("com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider");
                d(parcel.readLong());
                parcel2.writeNoException();
                return true;
            } catch (RuntimeException e16) {
                e16.printStackTrace();
                throw e16;
            }
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }
}
