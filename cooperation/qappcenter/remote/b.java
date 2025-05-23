package cooperation.qappcenter.remote;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;

/* compiled from: P */
/* loaded from: classes28.dex */
public interface b extends IInterface {
    void F4(SendMsg sendMsg) throws RemoteException;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static abstract class a extends Binder implements b {

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: P */
        /* renamed from: cooperation.qappcenter.remote.b$a$a, reason: collision with other inner class name */
        /* loaded from: classes28.dex */
        public static class C10105a implements b {

            /* renamed from: e, reason: collision with root package name */
            public static b f390398e;

            /* renamed from: d, reason: collision with root package name */
            private IBinder f390399d;

            C10105a(IBinder iBinder) {
                this.f390399d = iBinder;
            }

            @Override // cooperation.qappcenter.remote.b
            public void F4(SendMsg sendMsg) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "cooperation.qappcenter.remote.IServiceHandler");
                    if (sendMsg != null) {
                        obtain.writeInt(1);
                        sendMsg.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!OaidMonitor.binderTransact(this.f390399d, 1, obtain, obtain2, 0) && a.v() != null) {
                        a.v().F4(sendMsg);
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
                return this.f390399d;
            }
        }

        public a() {
            attachInterface(this, "cooperation.qappcenter.remote.IServiceHandler");
        }

        public static b j(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("cooperation.qappcenter.remote.IServiceHandler");
            if (queryLocalInterface != null && (queryLocalInterface instanceof b)) {
                return (b) queryLocalInterface;
            }
            return new C10105a(iBinder);
        }

        public static b v() {
            return C10105a.f390398e;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i3, Parcel parcel, Parcel parcel2, int i16) throws RemoteException {
            SendMsg sendMsg;
            if (i3 != 1598968902) {
                if (i3 != 1) {
                    return super.onTransact(i3, parcel, parcel2, i16);
                }
                parcel.enforceInterface("cooperation.qappcenter.remote.IServiceHandler");
                if (parcel.readInt() != 0) {
                    sendMsg = SendMsg.CREATOR.createFromParcel(parcel);
                } else {
                    sendMsg = null;
                }
                F4(sendMsg);
                parcel2.writeNoException();
                return true;
            }
            parcel2.writeString("cooperation.qappcenter.remote.IServiceHandler");
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }
}
