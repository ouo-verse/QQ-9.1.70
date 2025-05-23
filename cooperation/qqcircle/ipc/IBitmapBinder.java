package cooperation.qqcircle.ipc;

import android.graphics.Bitmap;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;

/* compiled from: P */
/* loaded from: classes28.dex */
public interface IBitmapBinder extends IInterface {
    public static final String DESCRIPTOR = "cooperation.qqcircle.ipc.IBitmapBinder";

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static class Default implements IBitmapBinder {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // cooperation.qqcircle.ipc.IBitmapBinder
        public Bitmap getBitmap() throws RemoteException {
            return null;
        }
    }

    Bitmap getBitmap() throws RemoteException;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static abstract class Stub extends Binder implements IBitmapBinder {
        static final int TRANSACTION_getBitmap = 1;

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: P */
        /* loaded from: classes28.dex */
        public static class Proxy implements IBitmapBinder {
            public static IBitmapBinder sDefaultImpl;
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // cooperation.qqcircle.ipc.IBitmapBinder
            public Bitmap getBitmap() throws RemoteException {
                Bitmap bitmap;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, IBitmapBinder.DESCRIPTOR);
                    if (!OaidMonitor.binderTransact(this.mRemote, 1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getBitmap();
                    }
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        bitmap = (Bitmap) Bitmap.CREATOR.createFromParcel(obtain2);
                    } else {
                        bitmap = null;
                    }
                    return bitmap;
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            public String getInterfaceDescriptor() {
                return IBitmapBinder.DESCRIPTOR;
            }
        }

        public Stub() {
            attachInterface(this, IBitmapBinder.DESCRIPTOR);
        }

        public static IBitmapBinder asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(IBitmapBinder.DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof IBitmapBinder)) {
                return (IBitmapBinder) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        public static IBitmapBinder getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IBitmapBinder iBitmapBinder) {
            if (Proxy.sDefaultImpl == null) {
                if (iBitmapBinder != null) {
                    Proxy.sDefaultImpl = iBitmapBinder;
                    return true;
                }
                return false;
            }
            throw new IllegalStateException("setDefaultImpl() called twice");
        }

        @Override // android.os.Binder
        public boolean onTransact(int i3, Parcel parcel, Parcel parcel2, int i16) throws RemoteException {
            if (i3 != 1598968902) {
                if (i3 != 1) {
                    return super.onTransact(i3, parcel, parcel2, i16);
                }
                parcel.enforceInterface(IBitmapBinder.DESCRIPTOR);
                Bitmap bitmap = getBitmap();
                parcel2.writeNoException();
                if (bitmap != null) {
                    parcel2.writeInt(1);
                    bitmap.writeToParcel(parcel2, 1);
                } else {
                    parcel2.writeInt(0);
                }
                return true;
            }
            parcel2.writeString(IBitmapBinder.DESCRIPTOR);
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }
}
