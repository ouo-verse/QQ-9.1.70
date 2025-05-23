package cooperation.qappcenter.remote;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;

/* compiled from: P */
/* loaded from: classes28.dex */
public interface a extends IInterface {

    /* compiled from: P */
    /* renamed from: cooperation.qappcenter.remote.a$a, reason: collision with other inner class name */
    /* loaded from: classes28.dex */
    public static abstract class AbstractBinderC10103a extends Binder implements a {

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: P */
        /* renamed from: cooperation.qappcenter.remote.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes28.dex */
        public static class C10104a implements a {

            /* renamed from: e, reason: collision with root package name */
            public static a f390396e;

            /* renamed from: d, reason: collision with root package name */
            private IBinder f390397d;

            C10104a(IBinder iBinder) {
                this.f390397d = iBinder;
            }

            @Override // cooperation.qappcenter.remote.a
            public void X4(RecvMsg recvMsg) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "cooperation.qappcenter.remote.IActionListener");
                    if (recvMsg != null) {
                        obtain.writeInt(1);
                        recvMsg.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!OaidMonitor.binderTransact(this.f390397d, 1, obtain, null, 1) && AbstractBinderC10103a.v() != null) {
                        AbstractBinderC10103a.v().X4(recvMsg);
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f390397d;
            }
        }

        public static a j(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("cooperation.qappcenter.remote.IActionListener");
            if (queryLocalInterface != null && (queryLocalInterface instanceof a)) {
                return (a) queryLocalInterface;
            }
            return new C10104a(iBinder);
        }

        public static a v() {
            return C10104a.f390396e;
        }
    }

    void X4(RecvMsg recvMsg) throws RemoteException;
}
