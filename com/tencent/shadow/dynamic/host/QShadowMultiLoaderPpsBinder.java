package com.tencent.shadow.dynamic.host;

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;

/* loaded from: classes25.dex */
public class QShadowMultiLoaderPpsBinder extends Binder {
    private final QShadowMultiLoaderPluginProcessService mPps;

    /* JADX INFO: Access modifiers changed from: package-private */
    public QShadowMultiLoaderPpsBinder(QShadowMultiLoaderPluginProcessService qShadowMultiLoaderPluginProcessService) {
        this.mPps = qShadowMultiLoaderPluginProcessService;
    }

    @Override // android.os.Binder
    public boolean onTransact(int i3, Parcel parcel, Parcel parcel2, int i16) {
        BinderUuidManager binderUuidManager;
        if (i3 != 1598968902) {
            switch (i3) {
                case 1:
                    parcel.enforceInterface(MultiLoaderPpsBinder.DESCRIPTOR);
                    try {
                        this.mPps.loadRuntimeForPlugin(parcel.readString(), parcel.readString());
                        parcel2.writeInt(0);
                    } catch (FailedException e16) {
                        parcel2.writeInt(1);
                        e16.writeToParcel(parcel2, 0);
                    }
                    return true;
                case 2:
                    parcel.enforceInterface(MultiLoaderPpsBinder.DESCRIPTOR);
                    try {
                        this.mPps.loadPluginLoaderForPlugin(parcel.readString(), parcel.readString());
                        parcel2.writeInt(0);
                    } catch (FailedException e17) {
                        parcel2.writeInt(1);
                        e17.writeToParcel(parcel2, 0);
                    }
                    return true;
                case 3:
                    parcel.enforceInterface(MultiLoaderPpsBinder.DESCRIPTOR);
                    String readString = parcel.readString();
                    IBinder readStrongBinder = parcel.readStrongBinder();
                    if (readStrongBinder != null) {
                        binderUuidManager = new BinderUuidManager(readStrongBinder);
                    } else {
                        binderUuidManager = null;
                    }
                    this.mPps.setUuidManagerForPlugin(readString, binderUuidManager);
                    parcel2.writeNoException();
                    return true;
                case 4:
                    parcel.enforceInterface(MultiLoaderPpsBinder.DESCRIPTOR);
                    PpsStatus ppsStatusForPlugin = this.mPps.getPpsStatusForPlugin(parcel.readString());
                    parcel2.writeNoException();
                    ppsStatusForPlugin.writeToParcel(parcel2, 1);
                    return true;
                case 5:
                    parcel.enforceInterface(MultiLoaderPpsBinder.DESCRIPTOR);
                    IBinder pluginLoaderForPlugin = this.mPps.getPluginLoaderForPlugin(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(pluginLoaderForPlugin);
                    return true;
                case 6:
                    parcel.enforceInterface(MultiLoaderPpsBinder.DESCRIPTOR);
                    this.mPps.exit();
                    parcel2.writeNoException();
                    return true;
                default:
                    return false;
            }
        }
        parcel2.writeString(MultiLoaderPpsBinder.DESCRIPTOR);
        return true;
    }
}
