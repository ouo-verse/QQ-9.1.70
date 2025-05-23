package com.tencent.mobileqq.winkpublish.api;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.tencent.mobileqq.winkpublish.QueueTaskBean;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;

/* loaded from: classes21.dex */
public interface IPublishQueueListener extends IInterface {
    public static final String DESCRIPTOR = "com.tencent.mobileqq.winkpublish.api.IPublishQueueListener";

    void onProgressChanged(QueueTaskBean queueTaskBean) throws RemoteException;

    void onQueueChanged() throws RemoteException;

    /* loaded from: classes21.dex */
    public static class Default implements IPublishQueueListener {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.tencent.mobileqq.winkpublish.api.IPublishQueueListener
        public void onQueueChanged() throws RemoteException {
        }

        @Override // com.tencent.mobileqq.winkpublish.api.IPublishQueueListener
        public void onProgressChanged(QueueTaskBean queueTaskBean) throws RemoteException {
        }
    }

    /* loaded from: classes21.dex */
    public static abstract class Stub extends Binder implements IPublishQueueListener {
        static final int TRANSACTION_onProgressChanged = 2;
        static final int TRANSACTION_onQueueChanged = 1;

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes21.dex */
        public static class Proxy implements IPublishQueueListener {
            public static IPublishQueueListener sDefaultImpl;
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IPublishQueueListener.DESCRIPTOR;
            }

            @Override // com.tencent.mobileqq.winkpublish.api.IPublishQueueListener
            public void onProgressChanged(QueueTaskBean queueTaskBean) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, IPublishQueueListener.DESCRIPTOR);
                    if (queueTaskBean != null) {
                        obtain.writeInt(1);
                        queueTaskBean.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!OaidMonitor.binderTransact(this.mRemote, 2, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onProgressChanged(queueTaskBean);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.mobileqq.winkpublish.api.IPublishQueueListener
            public void onQueueChanged() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, IPublishQueueListener.DESCRIPTOR);
                    if (!OaidMonitor.binderTransact(this.mRemote, 1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onQueueChanged();
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
            attachInterface(this, IPublishQueueListener.DESCRIPTOR);
        }

        public static IPublishQueueListener asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(IPublishQueueListener.DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof IPublishQueueListener)) {
                return (IPublishQueueListener) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        public static IPublishQueueListener getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IPublishQueueListener iPublishQueueListener) {
            if (Proxy.sDefaultImpl == null) {
                if (iPublishQueueListener != null) {
                    Proxy.sDefaultImpl = iPublishQueueListener;
                    return true;
                }
                return false;
            }
            throw new IllegalStateException("setDefaultImpl() called twice");
        }

        @Override // android.os.Binder
        public boolean onTransact(int i3, Parcel parcel, Parcel parcel2, int i16) throws RemoteException {
            QueueTaskBean queueTaskBean;
            if (i3 != 1598968902) {
                if (i3 != 1) {
                    if (i3 != 2) {
                        return super.onTransact(i3, parcel, parcel2, i16);
                    }
                    parcel.enforceInterface(IPublishQueueListener.DESCRIPTOR);
                    if (parcel.readInt() != 0) {
                        queueTaskBean = QueueTaskBean.CREATOR.createFromParcel(parcel);
                    } else {
                        queueTaskBean = null;
                    }
                    onProgressChanged(queueTaskBean);
                    parcel2.writeNoException();
                    return true;
                }
                parcel.enforceInterface(IPublishQueueListener.DESCRIPTOR);
                onQueueChanged();
                parcel2.writeNoException();
                return true;
            }
            parcel2.writeString(IPublishQueueListener.DESCRIPTOR);
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }
}
