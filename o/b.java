package o;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;

/* compiled from: P */
/* loaded from: classes.dex */
public interface b extends IInterface {

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static abstract class a extends Binder implements b {

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: P */
        /* renamed from: o.b$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static class C10876a implements b {

            /* renamed from: e, reason: collision with root package name */
            public static b f421653e;

            /* renamed from: d, reason: collision with root package name */
            private IBinder f421654d;

            C10876a(IBinder iBinder) {
                this.f421654d = iBinder;
            }

            @Override // o.b
            public void V(long j3, String str, o.a aVar) throws RemoteException {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.android.vending.licensing.ILicensingService");
                    obtain.writeLong(j3);
                    obtain.writeString(str);
                    if (aVar != null) {
                        iBinder = aVar.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    if (!OaidMonitor.binderTransact(this.f421654d, 1, obtain, null, 1) && a.v() != null) {
                        a.v().V(j3, str, aVar);
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f421654d;
            }
        }

        public static b j(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.android.vending.licensing.ILicensingService");
            if (queryLocalInterface != null && (queryLocalInterface instanceof b)) {
                return (b) queryLocalInterface;
            }
            return new C10876a(iBinder);
        }

        public static b v() {
            return C10876a.f421653e;
        }
    }

    void V(long j3, String str, o.a aVar) throws RemoteException;
}
