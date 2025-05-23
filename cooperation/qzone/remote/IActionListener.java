package cooperation.qzone.remote;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;

/* compiled from: P */
/* loaded from: classes28.dex */
public interface IActionListener extends IInterface {
    public static final String DESCRIPTOR = "cooperation.qzone.remote.IActionListener";

    void onRecvFromMsg(RecvMsg recvMsg) throws RemoteException;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static abstract class Stub extends Binder implements IActionListener {
        static final int TRANSACTION_onRecvFromMsg = 1;

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: P */
        /* loaded from: classes28.dex */
        public static class Proxy implements IActionListener {
            public static IActionListener sDefaultImpl;
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IActionListener.DESCRIPTOR;
            }

            @Override // cooperation.qzone.remote.IActionListener
            public void onRecvFromMsg(RecvMsg recvMsg) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, IActionListener.DESCRIPTOR);
                    if (recvMsg != null) {
                        obtain.writeInt(1);
                        recvMsg.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!OaidMonitor.binderTransact(this.mRemote, 1, obtain, null, 1) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onRecvFromMsg(recvMsg);
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain);
                }
            }
        }

        public Stub() {
            attachInterface(this, IActionListener.DESCRIPTOR);
        }

        public static IActionListener asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(IActionListener.DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof IActionListener)) {
                return (IActionListener) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        public static IActionListener getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IActionListener iActionListener) {
            if (Proxy.sDefaultImpl == null) {
                if (iActionListener != null) {
                    Proxy.sDefaultImpl = iActionListener;
                    return true;
                }
                return false;
            }
            throw new IllegalStateException("setDefaultImpl() called twice");
        }

        @Override // android.os.Binder
        public boolean onTransact(int i3, Parcel parcel, Parcel parcel2, int i16) throws RemoteException {
            RecvMsg recvMsg;
            if (i3 != 1598968902) {
                if (i3 != 1) {
                    return super.onTransact(i3, parcel, parcel2, i16);
                }
                parcel.enforceInterface(IActionListener.DESCRIPTOR);
                if (parcel.readInt() != 0) {
                    recvMsg = RecvMsg.CREATOR.createFromParcel(parcel);
                } else {
                    recvMsg = null;
                }
                onRecvFromMsg(recvMsg);
                return true;
            }
            parcel2.writeString(IActionListener.DESCRIPTOR);
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static class Default implements IActionListener {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // cooperation.qzone.remote.IActionListener
        public void onRecvFromMsg(RecvMsg recvMsg) throws RemoteException {
        }
    }
}
