package com.tencent.av.service;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;

/* compiled from: P */
/* loaded from: classes3.dex */
public interface i extends IInterface {
    void a5(boolean z16, String str) throws RemoteException;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static abstract class a extends Binder implements i {

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: P */
        /* renamed from: com.tencent.av.service.i$a$a, reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static class C0748a implements i {

            /* renamed from: e, reason: collision with root package name */
            public static i f74380e;

            /* renamed from: d, reason: collision with root package name */
            private IBinder f74381d;

            C0748a(IBinder iBinder) {
                this.f74381d = iBinder;
            }

            @Override // com.tencent.av.service.i
            public void a5(boolean z16, String str) throws RemoteException {
                int i3;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.av.service.IVideoActionCallback");
                    if (z16) {
                        i3 = 1;
                    } else {
                        i3 = 0;
                    }
                    obtain.writeInt(i3);
                    obtain.writeString(str);
                    if (!OaidMonitor.binderTransact(this.f74381d, 1, obtain, obtain2, 0) && a.v() != null) {
                        a.v().a5(z16, str);
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
                return this.f74381d;
            }
        }

        public a() {
            attachInterface(this, "com.tencent.av.service.IVideoActionCallback");
        }

        public static i j(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.tencent.av.service.IVideoActionCallback");
            if (queryLocalInterface != null && (queryLocalInterface instanceof i)) {
                return (i) queryLocalInterface;
            }
            return new C0748a(iBinder);
        }

        public static i v() {
            return C0748a.f74380e;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i3, Parcel parcel, Parcel parcel2, int i16) throws RemoteException {
            boolean z16;
            if (i3 != 1598968902) {
                if (i3 != 1) {
                    return super.onTransact(i3, parcel, parcel2, i16);
                }
                parcel.enforceInterface("com.tencent.av.service.IVideoActionCallback");
                if (parcel.readInt() != 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                a5(z16, parcel.readString());
                parcel2.writeNoException();
                return true;
            }
            parcel2.writeString("com.tencent.av.service.IVideoActionCallback");
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }
}
