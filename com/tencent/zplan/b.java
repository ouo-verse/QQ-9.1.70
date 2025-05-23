package com.tencent.zplan;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;

/* compiled from: P */
/* loaded from: classes27.dex */
public interface b extends IInterface {
    void onExecuteLua() throws RemoteException;

    void onLuaResult(boolean z16, String str) throws RemoteException;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static abstract class a extends Binder implements b {

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: P */
        /* renamed from: com.tencent.zplan.b$a$a, reason: collision with other inner class name */
        /* loaded from: classes27.dex */
        public static class C10049a implements b {

            /* renamed from: e, reason: collision with root package name */
            public static b f385229e;

            /* renamed from: d, reason: collision with root package name */
            private IBinder f385230d;

            C10049a(IBinder iBinder) {
                this.f385230d = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f385230d;
            }

            @Override // com.tencent.zplan.b
            public void onExecuteLua() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.zplan.IOnLuaResult");
                    if (!OaidMonitor.binderTransact(this.f385230d, 1, obtain, obtain2, 0) && a.v() != null) {
                        a.v().onExecuteLua();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.zplan.b
            public void onLuaResult(boolean z16, String str) throws RemoteException {
                int i3;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.zplan.IOnLuaResult");
                    if (z16) {
                        i3 = 1;
                    } else {
                        i3 = 0;
                    }
                    obtain.writeInt(i3);
                    obtain.writeString(str);
                    if (!OaidMonitor.binderTransact(this.f385230d, 2, obtain, obtain2, 0) && a.v() != null) {
                        a.v().onLuaResult(z16, str);
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
            attachInterface(this, "com.tencent.zplan.IOnLuaResult");
        }

        public static b j(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.tencent.zplan.IOnLuaResult");
            if (queryLocalInterface != null && (queryLocalInterface instanceof b)) {
                return (b) queryLocalInterface;
            }
            return new C10049a(iBinder);
        }

        public static b v() {
            return C10049a.f385229e;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i3, Parcel parcel, Parcel parcel2, int i16) throws RemoteException {
            boolean z16;
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 1598968902) {
                        return super.onTransact(i3, parcel, parcel2, i16);
                    }
                    parcel2.writeString("com.tencent.zplan.IOnLuaResult");
                    return true;
                }
                parcel.enforceInterface("com.tencent.zplan.IOnLuaResult");
                if (parcel.readInt() != 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                onLuaResult(z16, parcel.readString());
                parcel2.writeNoException();
                return true;
            }
            parcel.enforceInterface("com.tencent.zplan.IOnLuaResult");
            onExecuteLua();
            parcel2.writeNoException();
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }
}
