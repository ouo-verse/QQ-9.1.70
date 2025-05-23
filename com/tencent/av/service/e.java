package com.tencent.av.service;

import android.app.Notification;
import android.graphics.Bitmap;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.tencent.av.service.d;
import com.tencent.av.service.i;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;

/* compiled from: P */
/* loaded from: classes3.dex */
public interface e extends IInterface {
    void A0(long j3, String str) throws RemoteException;

    void H0(byte[] bArr) throws RemoteException;

    void I3(byte[] bArr) throws RemoteException;

    void V4(int i3, long j3, byte[] bArr) throws RemoteException;

    void d2(String str, Bundle bundle, i iVar) throws RemoteException;

    void f2(long j3) throws RemoteException;

    void g2(d dVar) throws RemoteException;

    int getPstnUserNumberInMAV(long j3, int i3) throws RemoteException;

    void i4() throws RemoteException;

    void k3(String str, Bitmap bitmap) throws RemoteException;

    void processS2C(byte[] bArr) throws RemoteException;

    void q0(String str) throws RemoteException;

    void u3() throws RemoteException;

    void u4() throws RemoteException;

    void v0(boolean z16, Notification notification) throws RemoteException;

    void z2(boolean z16) throws RemoteException;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static abstract class a extends Binder implements e {

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: P */
        /* renamed from: com.tencent.av.service.e$a$a, reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static class C0744a implements e {

            /* renamed from: e, reason: collision with root package name */
            public static e f74372e;

            /* renamed from: d, reason: collision with root package name */
            private IBinder f74373d;

            C0744a(IBinder iBinder) {
                this.f74373d = iBinder;
            }

            @Override // com.tencent.av.service.e
            public void V4(int i3, long j3, byte[] bArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.av.service.IAVServiceForQQ");
                    obtain.writeInt(i3);
                    obtain.writeLong(j3);
                    obtain.writeByteArray(bArr);
                    if (!OaidMonitor.binderTransact(this.f74373d, 3, obtain, null, 1) && a.v() != null) {
                        a.v().V4(i3, j3, bArr);
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f74373d;
            }

            @Override // com.tencent.av.service.e
            public void d2(String str, Bundle bundle, i iVar) throws RemoteException {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.av.service.IAVServiceForQQ");
                    obtain.writeString(str);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (iVar != null) {
                        iBinder = iVar.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    if (!OaidMonitor.binderTransact(this.f74373d, 16, obtain, obtain2, 0) && a.v() != null) {
                        a.v().d2(str, bundle, iVar);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.av.service.e
            public void k3(String str, Bitmap bitmap) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.av.service.IAVServiceForQQ");
                    obtain.writeString(str);
                    if (bitmap != null) {
                        obtain.writeInt(1);
                        bitmap.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!OaidMonitor.binderTransact(this.f74373d, 7, obtain, null, 1) && a.v() != null) {
                        a.v().k3(str, bitmap);
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.av.service.e
            public void processS2C(byte[] bArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.av.service.IAVServiceForQQ");
                    obtain.writeByteArray(bArr);
                    if (!OaidMonitor.binderTransact(this.f74373d, 2, obtain, null, 1) && a.v() != null) {
                        a.v().processS2C(bArr);
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.av.service.e
            public void q0(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.av.service.IAVServiceForQQ");
                    obtain.writeString(str);
                    if (!OaidMonitor.binderTransact(this.f74373d, 9, obtain, null, 1) && a.v() != null) {
                        a.v().q0(str);
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.av.service.e
            public void v0(boolean z16, Notification notification) throws RemoteException {
                int i3;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.av.service.IAVServiceForQQ");
                    if (z16) {
                        i3 = 1;
                    } else {
                        i3 = 0;
                    }
                    obtain.writeInt(i3);
                    if (notification != null) {
                        obtain.writeInt(1);
                        notification.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!OaidMonitor.binderTransact(this.f74373d, 6, obtain, obtain2, 0) && a.v() != null) {
                        a.v().v0(z16, notification);
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
            attachInterface(this, "com.tencent.av.service.IAVServiceForQQ");
        }

        public static e j(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.tencent.av.service.IAVServiceForQQ");
            if (queryLocalInterface != null && (queryLocalInterface instanceof e)) {
                return (e) queryLocalInterface;
            }
            return new C0744a(iBinder);
        }

        public static e v() {
            return C0744a.f74372e;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i3, Parcel parcel, Parcel parcel2, int i16) throws RemoteException {
            if (i3 != 1598968902) {
                boolean z16 = false;
                Notification notification = null;
                Bundle bundle = null;
                Bitmap bitmap = null;
                switch (i3) {
                    case 1:
                        parcel.enforceInterface("com.tencent.av.service.IAVServiceForQQ");
                        g2(d.a.j(parcel.readStrongBinder()));
                        return true;
                    case 2:
                        parcel.enforceInterface("com.tencent.av.service.IAVServiceForQQ");
                        processS2C(parcel.createByteArray());
                        return true;
                    case 3:
                        parcel.enforceInterface("com.tencent.av.service.IAVServiceForQQ");
                        V4(parcel.readInt(), parcel.readLong(), parcel.createByteArray());
                        return true;
                    case 4:
                        parcel.enforceInterface("com.tencent.av.service.IAVServiceForQQ");
                        I3(parcel.createByteArray());
                        parcel2.writeNoException();
                        return true;
                    case 5:
                        parcel.enforceInterface("com.tencent.av.service.IAVServiceForQQ");
                        H0(parcel.createByteArray());
                        parcel2.writeNoException();
                        return true;
                    case 6:
                        parcel.enforceInterface("com.tencent.av.service.IAVServiceForQQ");
                        if (parcel.readInt() != 0) {
                            z16 = true;
                        }
                        if (parcel.readInt() != 0) {
                            notification = (Notification) Notification.CREATOR.createFromParcel(parcel);
                        }
                        v0(z16, notification);
                        parcel2.writeNoException();
                        return true;
                    case 7:
                        parcel.enforceInterface("com.tencent.av.service.IAVServiceForQQ");
                        String readString = parcel.readString();
                        if (parcel.readInt() != 0) {
                            bitmap = (Bitmap) Bitmap.CREATOR.createFromParcel(parcel);
                        }
                        k3(readString, bitmap);
                        return true;
                    case 8:
                        parcel.enforceInterface("com.tencent.av.service.IAVServiceForQQ");
                        int pstnUserNumberInMAV = getPstnUserNumberInMAV(parcel.readLong(), parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeInt(pstnUserNumberInMAV);
                        return true;
                    case 9:
                        parcel.enforceInterface("com.tencent.av.service.IAVServiceForQQ");
                        q0(parcel.readString());
                        return true;
                    case 10:
                        parcel.enforceInterface("com.tencent.av.service.IAVServiceForQQ");
                        A0(parcel.readLong(), parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 11:
                        parcel.enforceInterface("com.tencent.av.service.IAVServiceForQQ");
                        f2(parcel.readLong());
                        parcel2.writeNoException();
                        return true;
                    case 12:
                        parcel.enforceInterface("com.tencent.av.service.IAVServiceForQQ");
                        i4();
                        parcel2.writeNoException();
                        return true;
                    case 13:
                        parcel.enforceInterface("com.tencent.av.service.IAVServiceForQQ");
                        u4();
                        parcel2.writeNoException();
                        return true;
                    case 14:
                        parcel.enforceInterface("com.tencent.av.service.IAVServiceForQQ");
                        if (parcel.readInt() != 0) {
                            z16 = true;
                        }
                        z2(z16);
                        parcel2.writeNoException();
                        return true;
                    case 15:
                        parcel.enforceInterface("com.tencent.av.service.IAVServiceForQQ");
                        u3();
                        parcel2.writeNoException();
                        return true;
                    case 16:
                        parcel.enforceInterface("com.tencent.av.service.IAVServiceForQQ");
                        String readString2 = parcel.readString();
                        if (parcel.readInt() != 0) {
                            bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                        }
                        d2(readString2, bundle, i.a.j(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    default:
                        return super.onTransact(i3, parcel, parcel2, i16);
                }
            }
            parcel2.writeString("com.tencent.av.service.IAVServiceForQQ");
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }
}
