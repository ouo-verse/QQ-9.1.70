package com.tencent.zplan;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;
import com.tencent.zplan.model.ZPlanRecordFrameData;

/* loaded from: classes27.dex */
public interface IZPlanRecordCallback extends IInterface {
    void onEncodeEnd(String str, int i3, Bundle bundle) throws RemoteException;

    void onEncodeStart(String str, int i3) throws RemoteException;

    void onRecordCoverDone(String str, int i3, Bundle bundle) throws RemoteException;

    void onRecordDone(String str, int i3, Bundle bundle) throws RemoteException;

    void onRecordFrameEnd(String str, int i3, Bundle bundle) throws RemoteException;

    void onRecordFrameStart(String str, int i3, Bundle bundle) throws RemoteException;

    void onRecordSingleFrame(String str, int i3, ZPlanRecordFrameData zPlanRecordFrameData) throws RemoteException;

    /* loaded from: classes27.dex */
    public static abstract class Stub extends Binder implements IZPlanRecordCallback {
        private static final String DESCRIPTOR = "com.tencent.zplan.IZPlanRecordCallback";
        static final int TRANSACTION_onEncodeEnd = 5;
        static final int TRANSACTION_onEncodeStart = 4;
        static final int TRANSACTION_onRecordCoverDone = 7;
        static final int TRANSACTION_onRecordDone = 6;
        static final int TRANSACTION_onRecordFrameEnd = 3;
        static final int TRANSACTION_onRecordFrameStart = 1;
        static final int TRANSACTION_onRecordSingleFrame = 2;

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes27.dex */
        public static class Proxy implements IZPlanRecordCallback {
            public static IZPlanRecordCallback sDefaultImpl;
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.tencent.zplan.IZPlanRecordCallback
            public void onEncodeEnd(String str, int i3, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeInt(i3);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!OaidMonitor.binderTransact(this.mRemote, 5, obtain, null, 1) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onEncodeEnd(str, i3, bundle);
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.zplan.IZPlanRecordCallback
            public void onEncodeStart(String str, int i3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeInt(i3);
                    if (!OaidMonitor.binderTransact(this.mRemote, 4, obtain, null, 1) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onEncodeStart(str, i3);
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.zplan.IZPlanRecordCallback
            public void onRecordCoverDone(String str, int i3, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeInt(i3);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!OaidMonitor.binderTransact(this.mRemote, 7, obtain, null, 1) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onRecordCoverDone(str, i3, bundle);
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.zplan.IZPlanRecordCallback
            public void onRecordDone(String str, int i3, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeInt(i3);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!OaidMonitor.binderTransact(this.mRemote, 6, obtain, null, 1) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onRecordDone(str, i3, bundle);
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.zplan.IZPlanRecordCallback
            public void onRecordFrameEnd(String str, int i3, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeInt(i3);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!OaidMonitor.binderTransact(this.mRemote, 3, obtain, null, 1) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onRecordFrameEnd(str, i3, bundle);
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.zplan.IZPlanRecordCallback
            public void onRecordFrameStart(String str, int i3, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeInt(i3);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!OaidMonitor.binderTransact(this.mRemote, 1, obtain, null, 1) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onRecordFrameStart(str, i3, bundle);
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.zplan.IZPlanRecordCallback
            public void onRecordSingleFrame(String str, int i3, ZPlanRecordFrameData zPlanRecordFrameData) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeInt(i3);
                    if (zPlanRecordFrameData != null) {
                        obtain.writeInt(1);
                        zPlanRecordFrameData.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!OaidMonitor.binderTransact(this.mRemote, 2, obtain, null, 1) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onRecordSingleFrame(str, i3, zPlanRecordFrameData);
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain);
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IZPlanRecordCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof IZPlanRecordCallback)) {
                return (IZPlanRecordCallback) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        public static IZPlanRecordCallback getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IZPlanRecordCallback iZPlanRecordCallback) {
            if (Proxy.sDefaultImpl == null && iZPlanRecordCallback != null) {
                Proxy.sDefaultImpl = iZPlanRecordCallback;
                return true;
            }
            return false;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i3, Parcel parcel, Parcel parcel2, int i16) throws RemoteException {
            if (i3 != 1598968902) {
                Bundle bundle = null;
                Bundle bundle2 = null;
                Bundle bundle3 = null;
                Bundle bundle4 = null;
                Bundle bundle5 = null;
                ZPlanRecordFrameData zPlanRecordFrameData = null;
                switch (i3) {
                    case 1:
                        parcel.enforceInterface(DESCRIPTOR);
                        String readString = parcel.readString();
                        int readInt = parcel.readInt();
                        if (parcel.readInt() != 0) {
                            bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                        }
                        onRecordFrameStart(readString, readInt, bundle);
                        return true;
                    case 2:
                        parcel.enforceInterface(DESCRIPTOR);
                        String readString2 = parcel.readString();
                        int readInt2 = parcel.readInt();
                        if (parcel.readInt() != 0) {
                            zPlanRecordFrameData = ZPlanRecordFrameData.INSTANCE.createFromParcel(parcel);
                        }
                        onRecordSingleFrame(readString2, readInt2, zPlanRecordFrameData);
                        return true;
                    case 3:
                        parcel.enforceInterface(DESCRIPTOR);
                        String readString3 = parcel.readString();
                        int readInt3 = parcel.readInt();
                        if (parcel.readInt() != 0) {
                            bundle5 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                        }
                        onRecordFrameEnd(readString3, readInt3, bundle5);
                        return true;
                    case 4:
                        parcel.enforceInterface(DESCRIPTOR);
                        onEncodeStart(parcel.readString(), parcel.readInt());
                        return true;
                    case 5:
                        parcel.enforceInterface(DESCRIPTOR);
                        String readString4 = parcel.readString();
                        int readInt4 = parcel.readInt();
                        if (parcel.readInt() != 0) {
                            bundle4 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                        }
                        onEncodeEnd(readString4, readInt4, bundle4);
                        return true;
                    case 6:
                        parcel.enforceInterface(DESCRIPTOR);
                        String readString5 = parcel.readString();
                        int readInt5 = parcel.readInt();
                        if (parcel.readInt() != 0) {
                            bundle3 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                        }
                        onRecordDone(readString5, readInt5, bundle3);
                        return true;
                    case 7:
                        parcel.enforceInterface(DESCRIPTOR);
                        String readString6 = parcel.readString();
                        int readInt6 = parcel.readInt();
                        if (parcel.readInt() != 0) {
                            bundle2 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                        }
                        onRecordCoverDone(readString6, readInt6, bundle2);
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

    /* loaded from: classes27.dex */
    public static class Default implements IZPlanRecordCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.tencent.zplan.IZPlanRecordCallback
        public void onEncodeStart(String str, int i3) throws RemoteException {
        }

        @Override // com.tencent.zplan.IZPlanRecordCallback
        public void onEncodeEnd(String str, int i3, Bundle bundle) throws RemoteException {
        }

        @Override // com.tencent.zplan.IZPlanRecordCallback
        public void onRecordCoverDone(String str, int i3, Bundle bundle) throws RemoteException {
        }

        @Override // com.tencent.zplan.IZPlanRecordCallback
        public void onRecordDone(String str, int i3, Bundle bundle) throws RemoteException {
        }

        @Override // com.tencent.zplan.IZPlanRecordCallback
        public void onRecordFrameEnd(String str, int i3, Bundle bundle) throws RemoteException {
        }

        @Override // com.tencent.zplan.IZPlanRecordCallback
        public void onRecordFrameStart(String str, int i3, Bundle bundle) throws RemoteException {
        }

        @Override // com.tencent.zplan.IZPlanRecordCallback
        public void onRecordSingleFrame(String str, int i3, ZPlanRecordFrameData zPlanRecordFrameData) throws RemoteException {
        }
    }
}
