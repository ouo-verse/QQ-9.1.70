package cooperation.qlink;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;

/* compiled from: P */
/* loaded from: classes28.dex */
public interface a extends IInterface {
    void U(SendMsg sendMsg) throws RemoteException;

    /* compiled from: P */
    /* renamed from: cooperation.qlink.a$a, reason: collision with other inner class name */
    /* loaded from: classes28.dex */
    public static abstract class AbstractBinderC10106a extends Binder implements a {

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: P */
        /* renamed from: cooperation.qlink.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes28.dex */
        public static class C10107a implements a {

            /* renamed from: e, reason: collision with root package name */
            public static a f390491e;

            /* renamed from: d, reason: collision with root package name */
            private IBinder f390492d;

            C10107a(IBinder iBinder) {
                this.f390492d = iBinder;
            }

            @Override // cooperation.qlink.a
            public void U(SendMsg sendMsg) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "cooperation.qlink.IQlinkService");
                    if (sendMsg != null) {
                        obtain.writeInt(1);
                        sendMsg.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!OaidMonitor.binderTransact(this.f390492d, 1, obtain, obtain2, 0) && AbstractBinderC10106a.v() != null) {
                        AbstractBinderC10106a.v().U(sendMsg);
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
                return this.f390492d;
            }
        }

        public AbstractBinderC10106a() {
            attachInterface(this, "cooperation.qlink.IQlinkService");
        }

        public static a j(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("cooperation.qlink.IQlinkService");
            if (queryLocalInterface != null && (queryLocalInterface instanceof a)) {
                return (a) queryLocalInterface;
            }
            return new C10107a(iBinder);
        }

        public static a v() {
            return C10107a.f390491e;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i3, Parcel parcel, Parcel parcel2, int i16) throws RemoteException {
            SendMsg sendMsg;
            if (i3 != 1598968902) {
                if (i3 != 1) {
                    return super.onTransact(i3, parcel, parcel2, i16);
                }
                parcel.enforceInterface("cooperation.qlink.IQlinkService");
                if (parcel.readInt() != 0) {
                    sendMsg = SendMsg.CREATOR.createFromParcel(parcel);
                } else {
                    sendMsg = null;
                }
                U(sendMsg);
                parcel2.writeNoException();
                return true;
            }
            parcel2.writeString("cooperation.qlink.IQlinkService");
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }
}
