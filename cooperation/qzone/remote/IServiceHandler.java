package cooperation.qzone.remote;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;

/* compiled from: P */
/* loaded from: classes28.dex */
public interface IServiceHandler extends IInterface {
    public static final String DESCRIPTOR = "cooperation.qzone.remote.IServiceHandler";

    void sendMsg(SendMsg sendMsg) throws RemoteException;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static abstract class Stub extends Binder implements IServiceHandler {
        static final int TRANSACTION_sendMsg = 1;

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: P */
        /* loaded from: classes28.dex */
        public static class Proxy implements IServiceHandler {
            public static IServiceHandler sDefaultImpl;
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IServiceHandler.DESCRIPTOR;
            }

            @Override // cooperation.qzone.remote.IServiceHandler
            public void sendMsg(SendMsg sendMsg) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, IServiceHandler.DESCRIPTOR);
                    if (sendMsg != null) {
                        obtain.writeInt(1);
                        sendMsg.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!OaidMonitor.binderTransact(this.mRemote, 1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().sendMsg(sendMsg);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }
        }

        public Stub() {
            attachInterface(this, IServiceHandler.DESCRIPTOR);
        }

        public static IServiceHandler asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(IServiceHandler.DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof IServiceHandler)) {
                return (IServiceHandler) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        public static IServiceHandler getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IServiceHandler iServiceHandler) {
            if (Proxy.sDefaultImpl == null) {
                if (iServiceHandler != null) {
                    Proxy.sDefaultImpl = iServiceHandler;
                    return true;
                }
                return false;
            }
            throw new IllegalStateException("setDefaultImpl() called twice");
        }

        @Override // android.os.Binder
        public boolean onTransact(int i3, Parcel parcel, Parcel parcel2, int i16) throws RemoteException {
            SendMsg sendMsg;
            if (i3 != 1598968902) {
                if (i3 != 1) {
                    return super.onTransact(i3, parcel, parcel2, i16);
                }
                parcel.enforceInterface(IServiceHandler.DESCRIPTOR);
                if (parcel.readInt() != 0) {
                    sendMsg = SendMsg.CREATOR.createFromParcel(parcel);
                } else {
                    sendMsg = null;
                }
                sendMsg(sendMsg);
                parcel2.writeNoException();
                return true;
            }
            parcel2.writeString(IServiceHandler.DESCRIPTOR);
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static class Default implements IServiceHandler {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // cooperation.qzone.remote.IServiceHandler
        public void sendMsg(SendMsg sendMsg) throws RemoteException {
        }
    }
}
