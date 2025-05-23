package com.tencent.zplan;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;

/* compiled from: P */
/* loaded from: classes27.dex */
public interface c extends IInterface {
    String t0(String str, String str2, int i3) throws RemoteException;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static abstract class a extends Binder implements c {

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: P */
        /* renamed from: com.tencent.zplan.c$a$a, reason: collision with other inner class name */
        /* loaded from: classes27.dex */
        public static class C10050a implements c {

            /* renamed from: e, reason: collision with root package name */
            public static c f385233e;

            /* renamed from: d, reason: collision with root package name */
            private IBinder f385234d;

            C10050a(IBinder iBinder) {
                this.f385234d = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f385234d;
            }

            @Override // com.tencent.zplan.c
            public String t0(String str, String str2, int i3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.zplan.IOnRemoteLuaEvent");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeInt(i3);
                    if (!OaidMonitor.binderTransact(this.f385234d, 1, obtain, obtain2, 0) && a.v() != null) {
                        return a.v().t0(str, str2, i3);
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }
        }

        public a() {
            attachInterface(this, "com.tencent.zplan.IOnRemoteLuaEvent");
        }

        public static c j(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.tencent.zplan.IOnRemoteLuaEvent");
            if (queryLocalInterface != null && (queryLocalInterface instanceof c)) {
                return (c) queryLocalInterface;
            }
            return new C10050a(iBinder);
        }

        public static c v() {
            return C10050a.f385233e;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i3, Parcel parcel, Parcel parcel2, int i16) throws RemoteException {
            if (i3 != 1) {
                if (i3 != 1598968902) {
                    return super.onTransact(i3, parcel, parcel2, i16);
                }
                parcel2.writeString("com.tencent.zplan.IOnRemoteLuaEvent");
                return true;
            }
            parcel.enforceInterface("com.tencent.zplan.IOnRemoteLuaEvent");
            String t06 = t0(parcel.readString(), parcel.readString(), parcel.readInt());
            parcel2.writeNoException();
            parcel2.writeString(t06);
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }
}
