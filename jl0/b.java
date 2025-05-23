package jl0;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.tencent.gamecenter.wadl.api.WadlRequest;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;
import jl0.c;

/* compiled from: P */
/* loaded from: classes6.dex */
public interface b extends IInterface {
    void L(c cVar) throws RemoteException;

    void e2(WadlRequest wadlRequest) throws RemoteException;

    void s3(c cVar) throws RemoteException;

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static abstract class a extends Binder implements b {

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: P */
        /* renamed from: jl0.b$a$a, reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public static class C10595a implements b {

            /* renamed from: e, reason: collision with root package name */
            public static b f410357e;

            /* renamed from: d, reason: collision with root package name */
            private IBinder f410358d;

            C10595a(IBinder iBinder) {
                this.f410358d = iBinder;
            }

            @Override // jl0.b
            public void L(c cVar) throws RemoteException {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.gamecenter.wadl.api.IWadlService");
                    if (cVar != null) {
                        iBinder = cVar.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    if (!OaidMonitor.binderTransact(this.f410358d, 3, obtain, null, 1) && a.v() != null) {
                        a.v().L(cVar);
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f410358d;
            }

            @Override // jl0.b
            public void e2(WadlRequest wadlRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.gamecenter.wadl.api.IWadlService");
                    if (wadlRequest != null) {
                        obtain.writeInt(1);
                        wadlRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!OaidMonitor.binderTransact(this.f410358d, 1, obtain, null, 1) && a.v() != null) {
                        a.v().e2(wadlRequest);
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // jl0.b
            public void s3(c cVar) throws RemoteException {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.gamecenter.wadl.api.IWadlService");
                    if (cVar != null) {
                        iBinder = cVar.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    if (!OaidMonitor.binderTransact(this.f410358d, 2, obtain, null, 1) && a.v() != null) {
                        a.v().s3(cVar);
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain);
                }
            }
        }

        public a() {
            attachInterface(this, "com.tencent.gamecenter.wadl.api.IWadlService");
        }

        public static b j(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.tencent.gamecenter.wadl.api.IWadlService");
            if (queryLocalInterface != null && (queryLocalInterface instanceof b)) {
                return (b) queryLocalInterface;
            }
            return new C10595a(iBinder);
        }

        public static b v() {
            return C10595a.f410357e;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i3, Parcel parcel, Parcel parcel2, int i16) throws RemoteException {
            WadlRequest wadlRequest;
            if (i3 != 1598968902) {
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 != 3) {
                            return super.onTransact(i3, parcel, parcel2, i16);
                        }
                        parcel.enforceInterface("com.tencent.gamecenter.wadl.api.IWadlService");
                        L(c.a.j(parcel.readStrongBinder()));
                        return true;
                    }
                    parcel.enforceInterface("com.tencent.gamecenter.wadl.api.IWadlService");
                    s3(c.a.j(parcel.readStrongBinder()));
                    return true;
                }
                parcel.enforceInterface("com.tencent.gamecenter.wadl.api.IWadlService");
                if (parcel.readInt() != 0) {
                    wadlRequest = WadlRequest.CREATOR.createFromParcel(parcel);
                } else {
                    wadlRequest = null;
                }
                e2(wadlRequest);
                return true;
            }
            parcel2.writeString("com.tencent.gamecenter.wadl.api.IWadlService");
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }
}
