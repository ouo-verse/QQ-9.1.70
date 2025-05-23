package com.tencent.luggage.wxa.ma;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;

/* compiled from: P */
/* loaded from: classes8.dex */
public interface b extends IInterface {

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.ma.b$b, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C6466b {
        public static Object b(Parcel parcel, Parcelable.Creator creator) {
            if (parcel.readInt() != 0) {
                return creator.createFromParcel(parcel);
            }
            return null;
        }

        public static void b(Parcel parcel, Parcelable parcelable, int i3) {
            if (parcelable != null) {
                parcel.writeInt(1);
                parcelable.writeToParcel(parcel, i3);
            } else {
                parcel.writeInt(0);
            }
        }
    }

    void onCallback(Bundle bundle);

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static abstract class a extends Binder implements b {

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.ma.b$a$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public static class C6465a implements b {

            /* renamed from: a, reason: collision with root package name */
            public IBinder f134220a;

            public C6465a(IBinder iBinder) {
                this.f134220a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f134220a;
            }

            @Override // com.tencent.luggage.wxa.ma.b
            public void onCallback(Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.mm.ipcinvoker.aidl.AIDL_IPCInvokeCallback");
                    C6466b.b(obtain, bundle, 0);
                    OaidMonitor.binderTransact(this.f134220a, 1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }
        }

        public a() {
            attachInterface(this, "com.tencent.mm.ipcinvoker.aidl.AIDL_IPCInvokeCallback");
        }

        public static b a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.tencent.mm.ipcinvoker.aidl.AIDL_IPCInvokeCallback");
            if (queryLocalInterface != null && (queryLocalInterface instanceof b)) {
                return (b) queryLocalInterface;
            }
            return new C6465a(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i3, Parcel parcel, Parcel parcel2, int i16) {
            if (i3 >= 1 && i3 <= 16777215) {
                parcel.enforceInterface("com.tencent.mm.ipcinvoker.aidl.AIDL_IPCInvokeCallback");
            }
            if (i3 != 1598968902) {
                if (i3 != 1) {
                    return super.onTransact(i3, parcel, parcel2, i16);
                }
                onCallback((Bundle) C6466b.b(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                return true;
            }
            parcel2.writeString("com.tencent.mm.ipcinvoker.aidl.AIDL_IPCInvokeCallback");
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }
}
