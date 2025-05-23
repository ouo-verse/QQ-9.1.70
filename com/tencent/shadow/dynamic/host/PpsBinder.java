package com.tencent.shadow.dynamic.host;

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes25.dex */
public class PpsBinder extends Binder {
    static final String DESCRIPTOR = "com.tencent.shadow.dynamic.host.PpsBinder";
    static final int TRANSACTION_CODE_FAILED_EXCEPTION = 1;
    static final int TRANSACTION_CODE_NO_EXCEPTION = 0;
    static final int TRANSACTION_exit = 4;
    static final int TRANSACTION_getPluginLoader = 6;
    static final int TRANSACTION_getPpsStatus = 5;
    static final int TRANSACTION_loadPluginLoader = 2;
    static final int TRANSACTION_loadRuntime = 1;
    static final int TRANSACTION_setUuidManager = 3;
    private final PluginProcessService mPps;

    /* JADX INFO: Access modifiers changed from: package-private */
    public PpsBinder(PluginProcessService pluginProcessService) {
        this.mPps = pluginProcessService;
    }

    @Override // android.os.Binder
    public boolean onTransact(int i3, Parcel parcel, Parcel parcel2, int i16) {
        BinderUuidManager binderUuidManager;
        if (i3 != 1598968902) {
            switch (i3) {
                case 1:
                    parcel.enforceInterface(DESCRIPTOR);
                    try {
                        this.mPps.loadRuntime(parcel.readString());
                        parcel2.writeInt(0);
                    } catch (FailedException e16) {
                        parcel2.writeInt(1);
                        e16.writeToParcel(parcel2, 0);
                    }
                    return true;
                case 2:
                    parcel.enforceInterface(DESCRIPTOR);
                    try {
                        this.mPps.loadPluginLoader(parcel.readString());
                        parcel2.writeInt(0);
                    } catch (FailedException e17) {
                        parcel2.writeInt(1);
                        e17.writeToParcel(parcel2, 0);
                    }
                    return true;
                case 3:
                    parcel.enforceInterface(DESCRIPTOR);
                    IBinder readStrongBinder = parcel.readStrongBinder();
                    if (readStrongBinder != null) {
                        binderUuidManager = new BinderUuidManager(readStrongBinder);
                    } else {
                        binderUuidManager = null;
                    }
                    this.mPps.setUuidManager(binderUuidManager);
                    parcel2.writeNoException();
                    return true;
                case 4:
                    parcel.enforceInterface(DESCRIPTOR);
                    this.mPps.exit();
                    parcel2.writeNoException();
                    return true;
                case 5:
                    parcel.enforceInterface(DESCRIPTOR);
                    PpsStatus ppsStatus = this.mPps.getPpsStatus();
                    parcel2.writeNoException();
                    ppsStatus.writeToParcel(parcel2, 1);
                    return true;
                case 6:
                    parcel.enforceInterface(DESCRIPTOR);
                    IBinder pluginLoader = this.mPps.getPluginLoader();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(pluginLoader);
                    return true;
                default:
                    return false;
            }
        }
        parcel2.writeString(DESCRIPTOR);
        return true;
    }
}
