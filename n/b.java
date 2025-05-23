package n;

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
        /* renamed from: n.b$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static class C10815a implements b {

            /* renamed from: e, reason: collision with root package name */
            public static b f417911e;

            /* renamed from: d, reason: collision with root package name */
            private IBinder f417912d;

            C10815a(IBinder iBinder) {
                this.f417912d = iBinder;
            }

            @Override // n.b
            public int O2() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.android.internal.telephony.ISub");
                    if (!OaidMonitor.binderTransact(this.f417912d, 20, obtain, obtain2, 0) && a.v() != null) {
                        return a.v().O2();
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // n.b
            public int[] Z0() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.android.internal.telephony.ISub");
                    if (!OaidMonitor.binderTransact(this.f417912d, 27, obtain, obtain2, 0) && a.v() != null) {
                        return a.v().Z0();
                    }
                    obtain2.readException();
                    return obtain2.createIntArray();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f417912d;
            }
        }

        public static b j(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.android.internal.telephony.ISub");
            if (queryLocalInterface != null && (queryLocalInterface instanceof b)) {
                return (b) queryLocalInterface;
            }
            return new C10815a(iBinder);
        }

        public static b v() {
            return C10815a.f417911e;
        }
    }

    int O2() throws RemoteException;

    int[] Z0() throws RemoteException;
}
