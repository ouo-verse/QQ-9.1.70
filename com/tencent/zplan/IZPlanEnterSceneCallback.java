package com.tencent.zplan;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;
import com.tencent.zplan.world.model.FirstFrameResult;

/* loaded from: classes27.dex */
public interface IZPlanEnterSceneCallback extends IInterface {
    void onEnterSceneResult(boolean z16) throws RemoteException;

    void onFirstFrame(FirstFrameResult firstFrameResult) throws RemoteException;

    /* loaded from: classes27.dex */
    public static abstract class Stub extends Binder implements IZPlanEnterSceneCallback {
        private static final String DESCRIPTOR = "com.tencent.zplan.IZPlanEnterSceneCallback";
        static final int TRANSACTION_onEnterSceneResult = 1;
        static final int TRANSACTION_onFirstFrame = 2;

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes27.dex */
        public static class Proxy implements IZPlanEnterSceneCallback {
            public static IZPlanEnterSceneCallback sDefaultImpl;
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

            @Override // com.tencent.zplan.IZPlanEnterSceneCallback
            public void onEnterSceneResult(boolean z16) throws RemoteException {
                int i3;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    if (z16) {
                        i3 = 1;
                    } else {
                        i3 = 0;
                    }
                    obtain.writeInt(i3);
                    if (!OaidMonitor.binderTransact(this.mRemote, 1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onEnterSceneResult(z16);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.zplan.IZPlanEnterSceneCallback
            public void onFirstFrame(FirstFrameResult firstFrameResult) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    if (firstFrameResult != null) {
                        obtain.writeInt(1);
                        firstFrameResult.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!OaidMonitor.binderTransact(this.mRemote, 2, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onFirstFrame(firstFrameResult);
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

        public static IZPlanEnterSceneCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof IZPlanEnterSceneCallback)) {
                return (IZPlanEnterSceneCallback) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        public static IZPlanEnterSceneCallback getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IZPlanEnterSceneCallback iZPlanEnterSceneCallback) {
            if (Proxy.sDefaultImpl == null && iZPlanEnterSceneCallback != null) {
                Proxy.sDefaultImpl = iZPlanEnterSceneCallback;
                return true;
            }
            return false;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i3, Parcel parcel, Parcel parcel2, int i16) throws RemoteException {
            boolean z16;
            FirstFrameResult firstFrameResult;
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 1598968902) {
                        return super.onTransact(i3, parcel, parcel2, i16);
                    }
                    parcel2.writeString(DESCRIPTOR);
                    return true;
                }
                parcel.enforceInterface(DESCRIPTOR);
                if (parcel.readInt() != 0) {
                    firstFrameResult = FirstFrameResult.CREATOR.createFromParcel(parcel);
                } else {
                    firstFrameResult = null;
                }
                onFirstFrame(firstFrameResult);
                parcel2.writeNoException();
                return true;
            }
            parcel.enforceInterface(DESCRIPTOR);
            if (parcel.readInt() != 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            onEnterSceneResult(z16);
            parcel2.writeNoException();
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }

    /* loaded from: classes27.dex */
    public static class Default implements IZPlanEnterSceneCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.tencent.zplan.IZPlanEnterSceneCallback
        public void onEnterSceneResult(boolean z16) throws RemoteException {
        }

        @Override // com.tencent.zplan.IZPlanEnterSceneCallback
        public void onFirstFrame(FirstFrameResult firstFrameResult) throws RemoteException {
        }
    }
}
