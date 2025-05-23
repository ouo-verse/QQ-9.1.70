package com.tencent.thumbplayer.core.datatransport.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;
import com.tencent.thumbplayer.core.datatransport.aidl.ITPRemoteDataTransportResourceLoaderListener;
import com.tencent.thumbplayer.core.datatransport.aidl.ITPRemotePreloadTaskListener;
import com.tencent.thumbplayer.core.datatransport.aidl.ITPRemoteTaskListener;
import java.util.List;

/* loaded from: classes26.dex */
public interface ITPDataTransportRemote extends IInterface {
    int createMultiTask(List<TPDataTransportTaskParam> list, ITPRemoteTaskListener iTPRemoteTaskListener) throws RemoteException;

    int createPreloadTask(TPDataTransportTaskParam tPDataTransportTaskParam, ITPRemotePreloadTaskListener iTPRemotePreloadTaskListener) throws RemoteException;

    int createTask(TPDataTransportTaskParam tPDataTransportTaskParam, ITPRemoteTaskListener iTPRemoteTaskListener) throws RemoteException;

    List<String> getMultiProxyUrlList(int i3, int i16) throws RemoteException;

    String getProxyUrl(int i3, int i16) throws RemoteException;

    String getTaskAccessibleNativeInfo(int i3, int i16) throws RemoteException;

    String getTaskErrorCode(int i3) throws RemoteException;

    void pauseTask(int i3) throws RemoteException;

    void resumeTask(int i3) throws RemoteException;

    void setTaskResourceLoaderListener(int i3, ITPRemoteDataTransportResourceLoaderListener iTPRemoteDataTransportResourceLoaderListener) throws RemoteException;

    void startTask(int i3) throws RemoteException;

    void stopTask(int i3) throws RemoteException;

    void updateRunningTaskInfo(int i3, String str, String str2) throws RemoteException;

    void updateRunningTaskParam(int i3, List<TPDataTransportTaskParam> list) throws RemoteException;

    /* loaded from: classes26.dex */
    public static abstract class Stub extends Binder implements ITPDataTransportRemote {
        private static final String DESCRIPTOR = "com.tencent.thumbplayer.core.datatransport.aidl.ITPDataTransportRemote";
        static final int TRANSACTION_createMultiTask = 2;
        static final int TRANSACTION_createPreloadTask = 3;
        static final int TRANSACTION_createTask = 1;
        static final int TRANSACTION_getMultiProxyUrlList = 10;
        static final int TRANSACTION_getProxyUrl = 9;
        static final int TRANSACTION_getTaskAccessibleNativeInfo = 13;
        static final int TRANSACTION_getTaskErrorCode = 8;
        static final int TRANSACTION_pauseTask = 6;
        static final int TRANSACTION_resumeTask = 7;
        static final int TRANSACTION_setTaskResourceLoaderListener = 14;
        static final int TRANSACTION_startTask = 4;
        static final int TRANSACTION_stopTask = 5;
        static final int TRANSACTION_updateRunningTaskInfo = 12;
        static final int TRANSACTION_updateRunningTaskParam = 11;

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes26.dex */
        public static class Proxy implements ITPDataTransportRemote {
            public static ITPDataTransportRemote sDefaultImpl;
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.tencent.thumbplayer.core.datatransport.aidl.ITPDataTransportRemote
            public int createMultiTask(List<TPDataTransportTaskParam> list, ITPRemoteTaskListener iTPRemoteTaskListener) throws RemoteException {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeTypedList(list);
                    if (iTPRemoteTaskListener != null) {
                        iBinder = iTPRemoteTaskListener.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    if (!OaidMonitor.binderTransact(this.mRemote, 2, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().createMultiTask(list, iTPRemoteTaskListener);
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.thumbplayer.core.datatransport.aidl.ITPDataTransportRemote
            public int createPreloadTask(TPDataTransportTaskParam tPDataTransportTaskParam, ITPRemotePreloadTaskListener iTPRemotePreloadTaskListener) throws RemoteException {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    if (tPDataTransportTaskParam != null) {
                        obtain.writeInt(1);
                        tPDataTransportTaskParam.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (iTPRemotePreloadTaskListener != null) {
                        iBinder = iTPRemotePreloadTaskListener.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    if (!OaidMonitor.binderTransact(this.mRemote, 3, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().createPreloadTask(tPDataTransportTaskParam, iTPRemotePreloadTaskListener);
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.thumbplayer.core.datatransport.aidl.ITPDataTransportRemote
            public int createTask(TPDataTransportTaskParam tPDataTransportTaskParam, ITPRemoteTaskListener iTPRemoteTaskListener) throws RemoteException {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    if (tPDataTransportTaskParam != null) {
                        obtain.writeInt(1);
                        tPDataTransportTaskParam.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (iTPRemoteTaskListener != null) {
                        iBinder = iTPRemoteTaskListener.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    if (!OaidMonitor.binderTransact(this.mRemote, 1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().createTask(tPDataTransportTaskParam, iTPRemoteTaskListener);
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.tencent.thumbplayer.core.datatransport.aidl.ITPDataTransportRemote
            public List<String> getMultiProxyUrlList(int i3, int i16) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeInt(i3);
                    obtain.writeInt(i16);
                    if (!OaidMonitor.binderTransact(this.mRemote, 10, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getMultiProxyUrlList(i3, i16);
                    }
                    obtain2.readException();
                    return obtain2.createStringArrayList();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.thumbplayer.core.datatransport.aidl.ITPDataTransportRemote
            public String getProxyUrl(int i3, int i16) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeInt(i3);
                    obtain.writeInt(i16);
                    if (!OaidMonitor.binderTransact(this.mRemote, 9, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getProxyUrl(i3, i16);
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.thumbplayer.core.datatransport.aidl.ITPDataTransportRemote
            public String getTaskAccessibleNativeInfo(int i3, int i16) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeInt(i3);
                    obtain.writeInt(i16);
                    if (!OaidMonitor.binderTransact(this.mRemote, 13, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getTaskAccessibleNativeInfo(i3, i16);
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.thumbplayer.core.datatransport.aidl.ITPDataTransportRemote
            public String getTaskErrorCode(int i3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeInt(i3);
                    if (!OaidMonitor.binderTransact(this.mRemote, 8, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getTaskErrorCode(i3);
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.thumbplayer.core.datatransport.aidl.ITPDataTransportRemote
            public void pauseTask(int i3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeInt(i3);
                    if (!OaidMonitor.binderTransact(this.mRemote, 6, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().pauseTask(i3);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.thumbplayer.core.datatransport.aidl.ITPDataTransportRemote
            public void resumeTask(int i3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeInt(i3);
                    if (!OaidMonitor.binderTransact(this.mRemote, 7, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().resumeTask(i3);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.thumbplayer.core.datatransport.aidl.ITPDataTransportRemote
            public void setTaskResourceLoaderListener(int i3, ITPRemoteDataTransportResourceLoaderListener iTPRemoteDataTransportResourceLoaderListener) throws RemoteException {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeInt(i3);
                    if (iTPRemoteDataTransportResourceLoaderListener != null) {
                        iBinder = iTPRemoteDataTransportResourceLoaderListener.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    if (!OaidMonitor.binderTransact(this.mRemote, 14, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().setTaskResourceLoaderListener(i3, iTPRemoteDataTransportResourceLoaderListener);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.thumbplayer.core.datatransport.aidl.ITPDataTransportRemote
            public void startTask(int i3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeInt(i3);
                    if (!OaidMonitor.binderTransact(this.mRemote, 4, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().startTask(i3);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.thumbplayer.core.datatransport.aidl.ITPDataTransportRemote
            public void stopTask(int i3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeInt(i3);
                    if (!OaidMonitor.binderTransact(this.mRemote, 5, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().stopTask(i3);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.thumbplayer.core.datatransport.aidl.ITPDataTransportRemote
            public void updateRunningTaskInfo(int i3, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeInt(i3);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (!OaidMonitor.binderTransact(this.mRemote, 12, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().updateRunningTaskInfo(i3, str, str2);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.thumbplayer.core.datatransport.aidl.ITPDataTransportRemote
            public void updateRunningTaskParam(int i3, List<TPDataTransportTaskParam> list) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeInt(i3);
                    obtain.writeTypedList(list);
                    if (!OaidMonitor.binderTransact(this.mRemote, 11, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().updateRunningTaskParam(i3, list);
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
            attachInterface(this, DESCRIPTOR);
        }

        public static ITPDataTransportRemote asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof ITPDataTransportRemote)) {
                return (ITPDataTransportRemote) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        public static ITPDataTransportRemote getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(ITPDataTransportRemote iTPDataTransportRemote) {
            if (Proxy.sDefaultImpl == null) {
                if (iTPDataTransportRemote != null) {
                    Proxy.sDefaultImpl = iTPDataTransportRemote;
                    return true;
                }
                return false;
            }
            throw new IllegalStateException("setDefaultImpl() called twice");
        }

        @Override // android.os.Binder
        public boolean onTransact(int i3, Parcel parcel, Parcel parcel2, int i16) throws RemoteException {
            if (i3 != 1598968902) {
                TPDataTransportTaskParam tPDataTransportTaskParam = null;
                switch (i3) {
                    case 1:
                        parcel.enforceInterface(DESCRIPTOR);
                        if (parcel.readInt() != 0) {
                            tPDataTransportTaskParam = TPDataTransportTaskParam.CREATOR.createFromParcel(parcel);
                        }
                        int createTask = createTask(tPDataTransportTaskParam, ITPRemoteTaskListener.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        parcel2.writeInt(createTask);
                        return true;
                    case 2:
                        parcel.enforceInterface(DESCRIPTOR);
                        int createMultiTask = createMultiTask(parcel.createTypedArrayList(TPDataTransportTaskParam.CREATOR), ITPRemoteTaskListener.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        parcel2.writeInt(createMultiTask);
                        return true;
                    case 3:
                        parcel.enforceInterface(DESCRIPTOR);
                        if (parcel.readInt() != 0) {
                            tPDataTransportTaskParam = TPDataTransportTaskParam.CREATOR.createFromParcel(parcel);
                        }
                        int createPreloadTask = createPreloadTask(tPDataTransportTaskParam, ITPRemotePreloadTaskListener.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        parcel2.writeInt(createPreloadTask);
                        return true;
                    case 4:
                        parcel.enforceInterface(DESCRIPTOR);
                        startTask(parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 5:
                        parcel.enforceInterface(DESCRIPTOR);
                        stopTask(parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 6:
                        parcel.enforceInterface(DESCRIPTOR);
                        pauseTask(parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 7:
                        parcel.enforceInterface(DESCRIPTOR);
                        resumeTask(parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 8:
                        parcel.enforceInterface(DESCRIPTOR);
                        String taskErrorCode = getTaskErrorCode(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeString(taskErrorCode);
                        return true;
                    case 9:
                        parcel.enforceInterface(DESCRIPTOR);
                        String proxyUrl = getProxyUrl(parcel.readInt(), parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeString(proxyUrl);
                        return true;
                    case 10:
                        parcel.enforceInterface(DESCRIPTOR);
                        List<String> multiProxyUrlList = getMultiProxyUrlList(parcel.readInt(), parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeStringList(multiProxyUrlList);
                        return true;
                    case 11:
                        parcel.enforceInterface(DESCRIPTOR);
                        updateRunningTaskParam(parcel.readInt(), parcel.createTypedArrayList(TPDataTransportTaskParam.CREATOR));
                        parcel2.writeNoException();
                        return true;
                    case 12:
                        parcel.enforceInterface(DESCRIPTOR);
                        updateRunningTaskInfo(parcel.readInt(), parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 13:
                        parcel.enforceInterface(DESCRIPTOR);
                        String taskAccessibleNativeInfo = getTaskAccessibleNativeInfo(parcel.readInt(), parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeString(taskAccessibleNativeInfo);
                        return true;
                    case 14:
                        parcel.enforceInterface(DESCRIPTOR);
                        setTaskResourceLoaderListener(parcel.readInt(), ITPRemoteDataTransportResourceLoaderListener.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    default:
                        return super.onTransact(i3, parcel, parcel2, i16);
                }
            }
            parcel2.writeString(DESCRIPTOR);
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }

    /* loaded from: classes26.dex */
    public static class Default implements ITPDataTransportRemote {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.tencent.thumbplayer.core.datatransport.aidl.ITPDataTransportRemote
        public int createMultiTask(List<TPDataTransportTaskParam> list, ITPRemoteTaskListener iTPRemoteTaskListener) throws RemoteException {
            return 0;
        }

        @Override // com.tencent.thumbplayer.core.datatransport.aidl.ITPDataTransportRemote
        public int createPreloadTask(TPDataTransportTaskParam tPDataTransportTaskParam, ITPRemotePreloadTaskListener iTPRemotePreloadTaskListener) throws RemoteException {
            return 0;
        }

        @Override // com.tencent.thumbplayer.core.datatransport.aidl.ITPDataTransportRemote
        public int createTask(TPDataTransportTaskParam tPDataTransportTaskParam, ITPRemoteTaskListener iTPRemoteTaskListener) throws RemoteException {
            return 0;
        }

        @Override // com.tencent.thumbplayer.core.datatransport.aidl.ITPDataTransportRemote
        public List<String> getMultiProxyUrlList(int i3, int i16) throws RemoteException {
            return null;
        }

        @Override // com.tencent.thumbplayer.core.datatransport.aidl.ITPDataTransportRemote
        public String getProxyUrl(int i3, int i16) throws RemoteException {
            return null;
        }

        @Override // com.tencent.thumbplayer.core.datatransport.aidl.ITPDataTransportRemote
        public String getTaskAccessibleNativeInfo(int i3, int i16) throws RemoteException {
            return null;
        }

        @Override // com.tencent.thumbplayer.core.datatransport.aidl.ITPDataTransportRemote
        public String getTaskErrorCode(int i3) throws RemoteException {
            return null;
        }

        @Override // com.tencent.thumbplayer.core.datatransport.aidl.ITPDataTransportRemote
        public void pauseTask(int i3) throws RemoteException {
        }

        @Override // com.tencent.thumbplayer.core.datatransport.aidl.ITPDataTransportRemote
        public void resumeTask(int i3) throws RemoteException {
        }

        @Override // com.tencent.thumbplayer.core.datatransport.aidl.ITPDataTransportRemote
        public void startTask(int i3) throws RemoteException {
        }

        @Override // com.tencent.thumbplayer.core.datatransport.aidl.ITPDataTransportRemote
        public void stopTask(int i3) throws RemoteException {
        }

        @Override // com.tencent.thumbplayer.core.datatransport.aidl.ITPDataTransportRemote
        public void setTaskResourceLoaderListener(int i3, ITPRemoteDataTransportResourceLoaderListener iTPRemoteDataTransportResourceLoaderListener) throws RemoteException {
        }

        @Override // com.tencent.thumbplayer.core.datatransport.aidl.ITPDataTransportRemote
        public void updateRunningTaskParam(int i3, List<TPDataTransportTaskParam> list) throws RemoteException {
        }

        @Override // com.tencent.thumbplayer.core.datatransport.aidl.ITPDataTransportRemote
        public void updateRunningTaskInfo(int i3, String str, String str2) throws RemoteException {
        }
    }
}
