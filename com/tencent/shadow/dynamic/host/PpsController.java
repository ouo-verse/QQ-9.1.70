package com.tencent.shadow.dynamic.host;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;

/* loaded from: classes25.dex */
public class PpsController {
    private final IBinder mRemote;

    /* JADX INFO: Access modifiers changed from: package-private */
    public PpsController(IBinder iBinder) {
        this.mRemote = iBinder;
    }

    public void exit() throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            OaidMonitor.writeParcelToken(obtain, PpsBinder.DESCRIPTOR);
            OaidMonitor.binderTransact(this.mRemote, 4, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            OaidMonitor.parcelRecycle(obtain2);
            OaidMonitor.parcelRecycle(obtain);
        }
    }

    public IBinder getPluginLoader() throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            OaidMonitor.writeParcelToken(obtain, PpsBinder.DESCRIPTOR);
            OaidMonitor.binderTransact(this.mRemote, 6, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readStrongBinder();
        } finally {
            OaidMonitor.parcelRecycle(obtain2);
            OaidMonitor.parcelRecycle(obtain);
        }
    }

    public PpsStatus getPpsStatus() throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            OaidMonitor.writeParcelToken(obtain, PpsBinder.DESCRIPTOR);
            OaidMonitor.binderTransact(this.mRemote, 5, obtain, obtain2, 0);
            obtain2.readException();
            return new PpsStatus(obtain2);
        } finally {
            OaidMonitor.parcelRecycle(obtain2);
            OaidMonitor.parcelRecycle(obtain);
        }
    }

    public void loadPluginLoader(String str) throws RemoteException, FailedException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            OaidMonitor.writeParcelToken(obtain, PpsBinder.DESCRIPTOR);
            obtain.writeString(str);
            OaidMonitor.binderTransact(this.mRemote, 2, obtain, obtain2, 0);
            int readInt = obtain2.readInt();
            if (readInt != 1) {
                if (readInt == 0) {
                    return;
                }
                throw new RuntimeException("\u4e0d\u8ba4\u8bc6\u7684Code==" + readInt);
            }
            throw new FailedException(obtain2);
        } finally {
            OaidMonitor.parcelRecycle(obtain2);
            OaidMonitor.parcelRecycle(obtain);
        }
    }

    public void loadRuntime(String str) throws RemoteException, FailedException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            OaidMonitor.writeParcelToken(obtain, PpsBinder.DESCRIPTOR);
            obtain.writeString(str);
            OaidMonitor.binderTransact(this.mRemote, 1, obtain, obtain2, 0);
            int readInt = obtain2.readInt();
            if (readInt != 1) {
                if (readInt == 0) {
                    return;
                }
                throw new RuntimeException("\u4e0d\u8ba4\u8bc6\u7684Code==" + readInt);
            }
            throw new FailedException(obtain2);
        } finally {
            OaidMonitor.parcelRecycle(obtain2);
            OaidMonitor.parcelRecycle(obtain);
        }
    }

    public void setUuidManager(IBinder iBinder) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            OaidMonitor.writeParcelToken(obtain, PpsBinder.DESCRIPTOR);
            obtain.writeStrongBinder(iBinder);
            OaidMonitor.binderTransact(this.mRemote, 3, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            OaidMonitor.parcelRecycle(obtain2);
            OaidMonitor.parcelRecycle(obtain);
        }
    }
}
