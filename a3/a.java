package a3;

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
    /* renamed from: a3.a$a, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static abstract class AbstractBinderC0006a extends Binder implements a {

        /* compiled from: P */
        /* renamed from: a3.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        private static class C0007a implements a {

            /* renamed from: d, reason: collision with root package name */
            private IBinder f25426d;

            C0007a(IBinder iBinder) {
                this.f25426d = iBinder;
            }

            @Override // a3.a
            public void S(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.ihoc.mgpa.dataforwardsdk.ICallBack");
                    obtain.writeString(str);
                    OaidMonitor.binderTransact(this.f25426d, 1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f25426d;
            }
        }

        public static a j(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.ihoc.mgpa.dataforwardsdk.ICallBack");
            if (queryLocalInterface != null && (queryLocalInterface instanceof a)) {
                return (a) queryLocalInterface;
            }
            return new C0007a(iBinder);
        }
    }

    void S(String str) throws RemoteException;
}
