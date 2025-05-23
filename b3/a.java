package b3;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;

/* compiled from: P */
/* loaded from: classes2.dex */
public interface a extends IInterface {

    /* compiled from: P */
    /* renamed from: b3.a$a, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static abstract class AbstractBinderC0088a extends Binder implements a {

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: P */
        /* renamed from: b3.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static class C0089a implements a {

            /* renamed from: e, reason: collision with root package name */
            public static a f27791e;

            /* renamed from: d, reason: collision with root package name */
            private IBinder f27792d;

            C0089a(IBinder iBinder) {
                this.f27792d = iBinder;
            }

            @Override // b3.a
            public void F0(b bVar) throws RemoteException {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.ihoc.tgpa.bgdownload.IBgPreDownloadServer");
                    if (bVar != null) {
                        iBinder = bVar.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    if (!OaidMonitor.binderTransact(this.f27792d, 6, obtain, obtain2, 0) && AbstractBinderC0088a.v() != null) {
                        AbstractBinderC0088a.v().F0(bVar);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // b3.a
            public void F2() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.ihoc.tgpa.bgdownload.IBgPreDownloadServer");
                    if (!OaidMonitor.binderTransact(this.f27792d, 5, obtain, null, 1) && AbstractBinderC0088a.v() != null) {
                        AbstractBinderC0088a.v().F2();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // b3.a
            public void U0() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.ihoc.tgpa.bgdownload.IBgPreDownloadServer");
                    if (!OaidMonitor.binderTransact(this.f27792d, 3, obtain, null, 1) && AbstractBinderC0088a.v() != null) {
                        AbstractBinderC0088a.v().U0();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // b3.a
            public void Z3() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.ihoc.tgpa.bgdownload.IBgPreDownloadServer");
                    if (!OaidMonitor.binderTransact(this.f27792d, 7, obtain, obtain2, 0) && AbstractBinderC0088a.v() != null) {
                        AbstractBinderC0088a.v().Z3();
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
                return this.f27792d;
            }

            @Override // b3.a
            public void c4(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.ihoc.tgpa.bgdownload.IBgPreDownloadServer");
                    obtain.writeString(str);
                    if (!OaidMonitor.binderTransact(this.f27792d, 2, obtain, null, 1) && AbstractBinderC0088a.v() != null) {
                        AbstractBinderC0088a.v().c4(str);
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain);
                }
            }
        }

        public static a j(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.ihoc.tgpa.bgdownload.IBgPreDownloadServer");
            if (queryLocalInterface != null && (queryLocalInterface instanceof a)) {
                return (a) queryLocalInterface;
            }
            return new C0089a(iBinder);
        }

        public static a v() {
            return C0089a.f27791e;
        }
    }

    void F0(b bVar) throws RemoteException;

    void F2() throws RemoteException;

    void U0() throws RemoteException;

    void Z3() throws RemoteException;

    void c4(String str) throws RemoteException;
}
