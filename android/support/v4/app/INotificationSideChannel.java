package android.support.v4.app;

import android.app.Notification;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;

/* compiled from: P */
/* loaded from: classes.dex */
public interface INotificationSideChannel extends IInterface {
    void cancel(String str, int i3, String str2) throws RemoteException;

    void cancelAll(String str) throws RemoteException;

    void notify(String str, int i3, String str2, Notification notification) throws RemoteException;

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static abstract class Stub extends Binder implements INotificationSideChannel {
        private static final String DESCRIPTOR = "android.support.v4.app.INotificationSideChannel";
        static final int TRANSACTION_cancel = 2;
        static final int TRANSACTION_cancelAll = 3;
        static final int TRANSACTION_notify = 1;

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: P */
        /* loaded from: classes.dex */
        public static class Proxy implements INotificationSideChannel {
            public static INotificationSideChannel sDefaultImpl;
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // android.support.v4.app.INotificationSideChannel
            public void cancel(String str, int i3, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeInt(i3);
                    obtain.writeString(str2);
                    if (!OaidMonitor.binderTransact(this.mRemote, 2, obtain, null, 1) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().cancel(str, i3, str2);
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // android.support.v4.app.INotificationSideChannel
            public void cancelAll(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (!OaidMonitor.binderTransact(this.mRemote, 3, obtain, null, 1) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().cancelAll(str);
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // android.support.v4.app.INotificationSideChannel
            public void notify(String str, int i3, String str2, Notification notification) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeInt(i3);
                    obtain.writeString(str2);
                    if (notification != null) {
                        obtain.writeInt(1);
                        notification.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!OaidMonitor.binderTransact(this.mRemote, 1, obtain, null, 1) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().notify(str, i3, str2, notification);
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain);
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static INotificationSideChannel asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof INotificationSideChannel)) {
                return (INotificationSideChannel) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        public static INotificationSideChannel getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(INotificationSideChannel iNotificationSideChannel) {
            if (Proxy.sDefaultImpl == null) {
                if (iNotificationSideChannel != null) {
                    Proxy.sDefaultImpl = iNotificationSideChannel;
                    return true;
                }
                return false;
            }
            throw new IllegalStateException("setDefaultImpl() called twice");
        }

        @Override // android.os.Binder
        public boolean onTransact(int i3, Parcel parcel, Parcel parcel2, int i16) throws RemoteException {
            Notification notification;
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 1598968902) {
                            return super.onTransact(i3, parcel, parcel2, i16);
                        }
                        parcel2.writeString(DESCRIPTOR);
                        return true;
                    }
                    parcel.enforceInterface(DESCRIPTOR);
                    cancelAll(parcel.readString());
                    return true;
                }
                parcel.enforceInterface(DESCRIPTOR);
                cancel(parcel.readString(), parcel.readInt(), parcel.readString());
                return true;
            }
            parcel.enforceInterface(DESCRIPTOR);
            String readString = parcel.readString();
            int readInt = parcel.readInt();
            String readString2 = parcel.readString();
            if (parcel.readInt() != 0) {
                notification = (Notification) Notification.CREATOR.createFromParcel(parcel);
            } else {
                notification = null;
            }
            notify(readString, readInt, readString2, notification);
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class Default implements INotificationSideChannel {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // android.support.v4.app.INotificationSideChannel
        public void cancelAll(String str) throws RemoteException {
        }

        @Override // android.support.v4.app.INotificationSideChannel
        public void cancel(String str, int i3, String str2) throws RemoteException {
        }

        @Override // android.support.v4.app.INotificationSideChannel
        public void notify(String str, int i3, String str2, Notification notification) throws RemoteException {
        }
    }
}
