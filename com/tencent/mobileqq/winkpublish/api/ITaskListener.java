package com.tencent.mobileqq.winkpublish.api;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.tencent.mobileqq.winkpublish.TaskInfo;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;

/* compiled from: P */
/* loaded from: classes21.dex */
public interface ITaskListener extends IInterface {
    public static final String DESCRIPTOR = "com.tencent.mobileqq.winkpublish.api.ITaskListener";

    void onTaskChange(TaskInfo taskInfo) throws RemoteException;

    /* compiled from: P */
    /* loaded from: classes21.dex */
    public static abstract class Stub extends Binder implements ITaskListener {
        static final int TRANSACTION_onTaskChange = 1;

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: P */
        /* loaded from: classes21.dex */
        public static class Proxy implements ITaskListener {
            public static ITaskListener sDefaultImpl;
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return ITaskListener.DESCRIPTOR;
            }

            @Override // com.tencent.mobileqq.winkpublish.api.ITaskListener
            public void onTaskChange(TaskInfo taskInfo) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, ITaskListener.DESCRIPTOR);
                    if (taskInfo != null) {
                        obtain.writeInt(1);
                        taskInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!OaidMonitor.binderTransact(this.mRemote, 1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onTaskChange(taskInfo);
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
            attachInterface(this, ITaskListener.DESCRIPTOR);
        }

        public static ITaskListener asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(ITaskListener.DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof ITaskListener)) {
                return (ITaskListener) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        public static ITaskListener getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(ITaskListener iTaskListener) {
            if (Proxy.sDefaultImpl == null) {
                if (iTaskListener != null) {
                    Proxy.sDefaultImpl = iTaskListener;
                    return true;
                }
                return false;
            }
            throw new IllegalStateException("setDefaultImpl() called twice");
        }

        @Override // android.os.Binder
        public boolean onTransact(int i3, Parcel parcel, Parcel parcel2, int i16) throws RemoteException {
            TaskInfo taskInfo;
            if (i3 != 1598968902) {
                if (i3 != 1) {
                    return super.onTransact(i3, parcel, parcel2, i16);
                }
                parcel.enforceInterface(ITaskListener.DESCRIPTOR);
                if (parcel.readInt() != 0) {
                    taskInfo = TaskInfo.CREATOR.createFromParcel(parcel);
                } else {
                    taskInfo = null;
                }
                onTaskChange(taskInfo);
                parcel2.writeNoException();
                return true;
            }
            parcel2.writeString(ITaskListener.DESCRIPTOR);
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes21.dex */
    public static class Default implements ITaskListener {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.tencent.mobileqq.winkpublish.api.ITaskListener
        public void onTaskChange(TaskInfo taskInfo) throws RemoteException {
        }
    }
}
