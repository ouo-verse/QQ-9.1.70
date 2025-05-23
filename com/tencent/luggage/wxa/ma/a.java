package com.tencent.luggage.wxa.ma;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.luggage.wxa.ma.b;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;

/* compiled from: P */
/* loaded from: classes8.dex */
public interface a extends IInterface {

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class b {
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

    Bundle a(Bundle bundle, String str);

    void a(Bundle bundle, String str, com.tencent.luggage.wxa.ma.b bVar);

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.ma.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static abstract class AbstractBinderC6463a extends Binder implements a {
        public AbstractBinderC6463a() {
            attachInterface(this, "com.tencent.mm.ipcinvoker.aidl.AIDL_IPCInvokeBridge");
        }

        public static a a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.tencent.mm.ipcinvoker.aidl.AIDL_IPCInvokeBridge");
            if (queryLocalInterface != null && (queryLocalInterface instanceof a)) {
                return (a) queryLocalInterface;
            }
            return new C6464a(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i3, Parcel parcel, Parcel parcel2, int i16) {
            if (i3 >= 1 && i3 <= 16777215) {
                parcel.enforceInterface("com.tencent.mm.ipcinvoker.aidl.AIDL_IPCInvokeBridge");
            }
            if (i3 != 1598968902) {
                if (i3 != 1) {
                    if (i3 != 2) {
                        return super.onTransact(i3, parcel, parcel2, i16);
                    }
                    Bundle a16 = a((Bundle) b.b(parcel, Bundle.CREATOR), parcel.readString());
                    parcel2.writeNoException();
                    b.b(parcel2, a16, 1);
                } else {
                    a((Bundle) b.b(parcel, Bundle.CREATOR), parcel.readString(), b.a.a(parcel.readStrongBinder()));
                }
                return true;
            }
            parcel2.writeString("com.tencent.mm.ipcinvoker.aidl.AIDL_IPCInvokeBridge");
            return true;
        }

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.ma.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public static class C6464a implements a {

            /* renamed from: a, reason: collision with root package name */
            public IBinder f134219a;

            public C6464a(IBinder iBinder) {
                this.f134219a = iBinder;
            }

            @Override // com.tencent.luggage.wxa.ma.a
            public void a(Bundle bundle, String str, com.tencent.luggage.wxa.ma.b bVar) {
                Parcel obtain = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.mm.ipcinvoker.aidl.AIDL_IPCInvokeBridge");
                    b.b(obtain, bundle, 0);
                    obtain.writeString(str);
                    obtain.writeStrongInterface(bVar);
                    OaidMonitor.binderTransact(this.f134219a, 1, obtain, null, 1);
                } finally {
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f134219a;
            }

            @Override // com.tencent.luggage.wxa.ma.a
            public Bundle a(Bundle bundle, String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.mm.ipcinvoker.aidl.AIDL_IPCInvokeBridge");
                    b.b(obtain, bundle, 0);
                    obtain.writeString(str);
                    OaidMonitor.binderTransact(this.f134219a, 2, obtain, obtain2, 0);
                    obtain2.readException();
                    return (Bundle) b.b(obtain2, Bundle.CREATOR);
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }
}
