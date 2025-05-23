package com.tencent.shadow.dynamic.host;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;
import com.tencent.shadow.core.common.InstalledApk;

/* compiled from: P */
/* loaded from: classes25.dex */
class BinderUuidManager implements UuidManager {
    private IBinder mRemote;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BinderUuidManager(IBinder iBinder) {
        this.mRemote = iBinder;
    }

    private void checkException(Parcel parcel) throws FailedException, NotFoundException {
        int readInt = parcel.readInt();
        if (readInt != 1) {
            if (readInt != 2) {
                if (readInt == 0) {
                    return;
                }
                throw new RuntimeException("\u4e0d\u8ba4\u8bc6\u7684Code==" + readInt);
            }
            throw new NotFoundException(parcel);
        }
        throw new FailedException(parcel);
    }

    @Override // com.tencent.shadow.dynamic.host.UuidManager
    public InstalledApk getPlugin(String str, String str2) throws RemoteException, FailedException, NotFoundException {
        InstalledApk installedApk;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            OaidMonitor.writeParcelToken(obtain, UuidManager.DESCRIPTOR);
            obtain.writeString(str);
            obtain.writeString(str2);
            OaidMonitor.binderTransact(this.mRemote, 1, obtain, obtain2, 0);
            checkException(obtain2);
            if (obtain2.readInt() != 0) {
                installedApk = InstalledApk.CREATOR.createFromParcel(obtain2);
            } else {
                installedApk = null;
            }
            return installedApk;
        } finally {
            OaidMonitor.parcelRecycle(obtain2);
            OaidMonitor.parcelRecycle(obtain);
        }
    }

    @Override // com.tencent.shadow.dynamic.host.UuidManager
    public InstalledApk getPluginLoader(String str) throws RemoteException, NotFoundException, FailedException {
        InstalledApk installedApk;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            OaidMonitor.writeParcelToken(obtain, UuidManager.DESCRIPTOR);
            obtain.writeString(str);
            OaidMonitor.binderTransact(this.mRemote, 2, obtain, obtain2, 0);
            checkException(obtain2);
            if (obtain2.readInt() != 0) {
                installedApk = InstalledApk.CREATOR.createFromParcel(obtain2);
            } else {
                installedApk = null;
            }
            return installedApk;
        } finally {
            OaidMonitor.parcelRecycle(obtain2);
            OaidMonitor.parcelRecycle(obtain);
        }
    }

    @Override // com.tencent.shadow.dynamic.host.UuidManager
    public InstalledApk getRuntime(String str) throws RemoteException, NotFoundException, FailedException {
        InstalledApk installedApk;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            OaidMonitor.writeParcelToken(obtain, UuidManager.DESCRIPTOR);
            obtain.writeString(str);
            OaidMonitor.binderTransact(this.mRemote, 3, obtain, obtain2, 0);
            checkException(obtain2);
            if (obtain2.readInt() != 0) {
                installedApk = InstalledApk.CREATOR.createFromParcel(obtain2);
            } else {
                installedApk = null;
            }
            return installedApk;
        } finally {
            OaidMonitor.parcelRecycle(obtain2);
            OaidMonitor.parcelRecycle(obtain);
        }
    }
}
