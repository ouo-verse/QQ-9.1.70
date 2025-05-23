package jl0;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;

/* compiled from: P */
/* loaded from: classes6.dex */
public interface c extends IInterface {
    void a(String str, Bundle bundle) throws RemoteException;

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static abstract class a extends Binder implements c {

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: P */
        /* renamed from: jl0.c$a$a, reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public static class C10596a implements c {

            /* renamed from: e, reason: collision with root package name */
            public static c f410359e;

            /* renamed from: d, reason: collision with root package name */
            private IBinder f410360d;

            C10596a(IBinder iBinder) {
                this.f410360d = iBinder;
            }

            @Override // jl0.c
            public void a(String str, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.gamecenter.wadl.api.IWadlServiceCallBack");
                    obtain.writeString(str);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!OaidMonitor.binderTransact(this.f410360d, 1, obtain, null, 1) && a.v() != null) {
                        a.v().a(str, bundle);
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f410360d;
            }
        }

        public a() {
            attachInterface(this, "com.tencent.gamecenter.wadl.api.IWadlServiceCallBack");
        }

        public static c j(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.tencent.gamecenter.wadl.api.IWadlServiceCallBack");
            if (queryLocalInterface != null && (queryLocalInterface instanceof c)) {
                return (c) queryLocalInterface;
            }
            return new C10596a(iBinder);
        }

        public static c v() {
            return C10596a.f410359e;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i3, Parcel parcel, Parcel parcel2, int i16) throws RemoteException {
            Bundle bundle;
            if (i3 != 1598968902) {
                if (i3 != 1) {
                    return super.onTransact(i3, parcel, parcel2, i16);
                }
                parcel.enforceInterface("com.tencent.gamecenter.wadl.api.IWadlServiceCallBack");
                String readString = parcel.readString();
                if (parcel.readInt() != 0) {
                    bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                } else {
                    bundle = null;
                }
                a(readString, bundle);
                return true;
            }
            parcel2.writeString("com.tencent.gamecenter.wadl.api.IWadlServiceCallBack");
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }
}
