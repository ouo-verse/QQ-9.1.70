package com.tencent.soter.soterserver;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;

/* compiled from: P */
/* loaded from: classes25.dex */
public interface ISoterService extends IInterface {

    /* compiled from: P */
    /* loaded from: classes25.dex */
    public static class Default implements ISoterService {
        static IPatchRedirector $redirector_;

        public Default() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
                return (IBinder) iPatchRedirector.redirect((short) 15, (Object) this);
            }
            return null;
        }

        @Override // com.tencent.soter.soterserver.ISoterService
        public SoterSignResult finishSign(long j3) throws RemoteException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return (SoterSignResult) iPatchRedirector.redirect((short) 11, (Object) this, j3);
            }
            return null;
        }

        @Override // com.tencent.soter.soterserver.ISoterService
        public int generateAppSecureKey(int i3) throws RemoteException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, i3)).intValue();
            }
            return 0;
        }

        @Override // com.tencent.soter.soterserver.ISoterService
        public int generateAuthKey(int i3, String str) throws RemoteException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this, i3, (Object) str)).intValue();
            }
            return 0;
        }

        @Override // com.tencent.soter.soterserver.ISoterService
        public SoterExportResult getAppSecureKey(int i3) throws RemoteException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (SoterExportResult) iPatchRedirector.redirect((short) 3, (Object) this, i3);
            }
            return null;
        }

        @Override // com.tencent.soter.soterserver.ISoterService
        public SoterExportResult getAuthKey(int i3, String str) throws RemoteException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (SoterExportResult) iPatchRedirector.redirect((short) 7, (Object) this, i3, (Object) str);
            }
            return null;
        }

        @Override // com.tencent.soter.soterserver.ISoterService
        public SoterDeviceResult getDeviceId() throws RemoteException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                return (SoterDeviceResult) iPatchRedirector.redirect((short) 12, (Object) this);
            }
            return null;
        }

        @Override // com.tencent.soter.soterserver.ISoterService
        public SoterExtraParam getExtraParam(String str) throws RemoteException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
                return (SoterExtraParam) iPatchRedirector.redirect((short) 14, (Object) this, (Object) str);
            }
            return null;
        }

        @Override // com.tencent.soter.soterserver.ISoterService
        public int getVersion() throws RemoteException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this)).intValue();
            }
            return 0;
        }

        @Override // com.tencent.soter.soterserver.ISoterService
        public boolean hasAskAlready(int i3) throws RemoteException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, i3)).booleanValue();
            }
            return false;
        }

        @Override // com.tencent.soter.soterserver.ISoterService
        public boolean hasAuthKey(int i3, String str) throws RemoteException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, i3, (Object) str)).booleanValue();
            }
            return false;
        }

        @Override // com.tencent.soter.soterserver.ISoterService
        public SoterSessionResult initSigh(int i3, String str, String str2) throws RemoteException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return (SoterSessionResult) iPatchRedirector.redirect((short) 10, this, Integer.valueOf(i3), str, str2);
            }
            return null;
        }

        @Override // com.tencent.soter.soterserver.ISoterService
        public int removeAllAuthKey(int i3) throws RemoteException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this, i3)).intValue();
            }
            return 0;
        }

        @Override // com.tencent.soter.soterserver.ISoterService
        public int removeAuthKey(int i3, String str) throws RemoteException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this, i3, (Object) str)).intValue();
            }
            return 0;
        }
    }

    /* compiled from: P */
    /* loaded from: classes25.dex */
    public static abstract class Stub extends Binder implements ISoterService {
        static IPatchRedirector $redirector_ = null;
        private static final String DESCRIPTOR = "com.tencent.soter.soterserver.ISoterService";
        static final int TRANSACTION_finishSign = 10;
        static final int TRANSACTION_generateAppSecureKey = 1;
        static final int TRANSACTION_generateAuthKey = 4;
        static final int TRANSACTION_getAppSecureKey = 2;
        static final int TRANSACTION_getAuthKey = 6;
        static final int TRANSACTION_getDeviceId = 11;
        static final int TRANSACTION_getExtraParam = 13;
        static final int TRANSACTION_getVersion = 12;
        static final int TRANSACTION_hasAskAlready = 3;
        static final int TRANSACTION_hasAuthKey = 8;
        static final int TRANSACTION_initSigh = 9;
        static final int TRANSACTION_removeAllAuthKey = 7;
        static final int TRANSACTION_removeAuthKey = 5;

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: P */
        /* loaded from: classes25.dex */
        public static class Proxy implements ISoterService {
            static IPatchRedirector $redirector_;
            public static ISoterService sDefaultImpl;
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) iBinder);
                } else {
                    this.mRemote = iBinder;
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (IBinder) iPatchRedirector.redirect((short) 2, (Object) this);
                }
                return this.mRemote;
            }

            @Override // com.tencent.soter.soterserver.ISoterService
            public SoterSignResult finishSign(long j3) throws RemoteException {
                SoterSignResult soterSignResult;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                    return (SoterSignResult) iPatchRedirector.redirect((short) 13, (Object) this, j3);
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeLong(j3);
                    if (!OaidMonitor.binderTransact(this.mRemote, 10, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().finishSign(j3);
                    }
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        soterSignResult = SoterSignResult.CREATOR.createFromParcel(obtain2);
                    } else {
                        soterSignResult = null;
                    }
                    return soterSignResult;
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.soter.soterserver.ISoterService
            public int generateAppSecureKey(int i3) throws RemoteException {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this, i3)).intValue();
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeInt(i3);
                    if (!OaidMonitor.binderTransact(this.mRemote, 1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().generateAppSecureKey(i3);
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.soter.soterserver.ISoterService
            public int generateAuthKey(int i3, String str) throws RemoteException {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                    return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this, i3, (Object) str)).intValue();
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeInt(i3);
                    obtain.writeString(str);
                    if (!OaidMonitor.binderTransact(this.mRemote, 4, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().generateAuthKey(i3, str);
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.soter.soterserver.ISoterService
            public SoterExportResult getAppSecureKey(int i3) throws RemoteException {
                SoterExportResult soterExportResult;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                    return (SoterExportResult) iPatchRedirector.redirect((short) 5, (Object) this, i3);
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeInt(i3);
                    if (!OaidMonitor.binderTransact(this.mRemote, 2, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getAppSecureKey(i3);
                    }
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        soterExportResult = SoterExportResult.CREATOR.createFromParcel(obtain2);
                    } else {
                        soterExportResult = null;
                    }
                    return soterExportResult;
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.soter.soterserver.ISoterService
            public SoterExportResult getAuthKey(int i3, String str) throws RemoteException {
                SoterExportResult soterExportResult;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                    return (SoterExportResult) iPatchRedirector.redirect((short) 9, (Object) this, i3, (Object) str);
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeInt(i3);
                    obtain.writeString(str);
                    if (!OaidMonitor.binderTransact(this.mRemote, 6, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getAuthKey(i3, str);
                    }
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        soterExportResult = SoterExportResult.CREATOR.createFromParcel(obtain2);
                    } else {
                        soterExportResult = null;
                    }
                    return soterExportResult;
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.soter.soterserver.ISoterService
            public SoterDeviceResult getDeviceId() throws RemoteException {
                SoterDeviceResult soterDeviceResult;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
                    return (SoterDeviceResult) iPatchRedirector.redirect((short) 14, (Object) this);
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    if (!OaidMonitor.binderTransact(this.mRemote, 11, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getDeviceId();
                    }
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        soterDeviceResult = SoterDeviceResult.CREATOR.createFromParcel(obtain2);
                    } else {
                        soterDeviceResult = null;
                    }
                    return soterDeviceResult;
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.soter.soterserver.ISoterService
            public SoterExtraParam getExtraParam(String str) throws RemoteException {
                SoterExtraParam soterExtraParam;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
                    return (SoterExtraParam) iPatchRedirector.redirect((short) 16, (Object) this, (Object) str);
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (!OaidMonitor.binderTransact(this.mRemote, 13, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getExtraParam(str);
                    }
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        soterExtraParam = SoterExtraParam.CREATOR.createFromParcel(obtain2);
                    } else {
                        soterExtraParam = null;
                    }
                    return soterExtraParam;
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            public String getInterfaceDescriptor() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    return (String) iPatchRedirector.redirect((short) 3, (Object) this);
                }
                return Stub.DESCRIPTOR;
            }

            @Override // com.tencent.soter.soterserver.ISoterService
            public int getVersion() throws RemoteException {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
                    return ((Integer) iPatchRedirector.redirect((short) 15, (Object) this)).intValue();
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    if (!OaidMonitor.binderTransact(this.mRemote, 12, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getVersion();
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.soter.soterserver.ISoterService
            public boolean hasAskAlready(int i3) throws RemoteException {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, i3)).booleanValue();
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeInt(i3);
                    boolean z16 = false;
                    if (!OaidMonitor.binderTransact(this.mRemote, 3, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().hasAskAlready(i3);
                    }
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z16 = true;
                    }
                    return z16;
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.soter.soterserver.ISoterService
            public boolean hasAuthKey(int i3, String str) throws RemoteException {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, i3, (Object) str)).booleanValue();
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeInt(i3);
                    obtain.writeString(str);
                    boolean z16 = false;
                    if (!OaidMonitor.binderTransact(this.mRemote, 8, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().hasAuthKey(i3, str);
                    }
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z16 = true;
                    }
                    return z16;
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.soter.soterserver.ISoterService
            public SoterSessionResult initSigh(int i3, String str, String str2) throws RemoteException {
                SoterSessionResult soterSessionResult;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                    return (SoterSessionResult) iPatchRedirector.redirect((short) 12, this, Integer.valueOf(i3), str, str2);
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeInt(i3);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (!OaidMonitor.binderTransact(this.mRemote, 9, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().initSigh(i3, str, str2);
                    }
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        soterSessionResult = SoterSessionResult.CREATOR.createFromParcel(obtain2);
                    } else {
                        soterSessionResult = null;
                    }
                    return soterSessionResult;
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.soter.soterserver.ISoterService
            public int removeAllAuthKey(int i3) throws RemoteException {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                    return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this, i3)).intValue();
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeInt(i3);
                    if (!OaidMonitor.binderTransact(this.mRemote, 7, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().removeAllAuthKey(i3);
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.soter.soterserver.ISoterService
            public int removeAuthKey(int i3, String str) throws RemoteException {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                    return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this, i3, (Object) str)).intValue();
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeInt(i3);
                    obtain.writeString(str);
                    if (!OaidMonitor.binderTransact(this.mRemote, 5, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().removeAuthKey(i3, str);
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }
        }

        public Stub() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                attachInterface(this, DESCRIPTOR);
            }
        }

        public static ISoterService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof ISoterService)) {
                return (ISoterService) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        public static ISoterService getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(ISoterService iSoterService) {
            if (Proxy.sDefaultImpl == null) {
                if (iSoterService != null) {
                    Proxy.sDefaultImpl = iSoterService;
                    return true;
                }
                return false;
            }
            throw new IllegalStateException("setDefaultImpl() called twice");
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (IBinder) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i3, Parcel parcel, Parcel parcel2, int i16) throws RemoteException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), parcel, parcel2, Integer.valueOf(i16))).booleanValue();
            }
            if (i3 != 1598968902) {
                switch (i3) {
                    case 1:
                        parcel.enforceInterface(DESCRIPTOR);
                        int generateAppSecureKey = generateAppSecureKey(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeInt(generateAppSecureKey);
                        return true;
                    case 2:
                        parcel.enforceInterface(DESCRIPTOR);
                        SoterExportResult appSecureKey = getAppSecureKey(parcel.readInt());
                        parcel2.writeNoException();
                        if (appSecureKey != null) {
                            parcel2.writeInt(1);
                            appSecureKey.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 3:
                        parcel.enforceInterface(DESCRIPTOR);
                        boolean hasAskAlready = hasAskAlready(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeInt(hasAskAlready ? 1 : 0);
                        return true;
                    case 4:
                        parcel.enforceInterface(DESCRIPTOR);
                        int generateAuthKey = generateAuthKey(parcel.readInt(), parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeInt(generateAuthKey);
                        return true;
                    case 5:
                        parcel.enforceInterface(DESCRIPTOR);
                        int removeAuthKey = removeAuthKey(parcel.readInt(), parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeInt(removeAuthKey);
                        return true;
                    case 6:
                        parcel.enforceInterface(DESCRIPTOR);
                        SoterExportResult authKey = getAuthKey(parcel.readInt(), parcel.readString());
                        parcel2.writeNoException();
                        if (authKey != null) {
                            parcel2.writeInt(1);
                            authKey.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 7:
                        parcel.enforceInterface(DESCRIPTOR);
                        int removeAllAuthKey = removeAllAuthKey(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeInt(removeAllAuthKey);
                        return true;
                    case 8:
                        parcel.enforceInterface(DESCRIPTOR);
                        boolean hasAuthKey = hasAuthKey(parcel.readInt(), parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeInt(hasAuthKey ? 1 : 0);
                        return true;
                    case 9:
                        parcel.enforceInterface(DESCRIPTOR);
                        SoterSessionResult initSigh = initSigh(parcel.readInt(), parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        if (initSigh != null) {
                            parcel2.writeInt(1);
                            initSigh.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 10:
                        parcel.enforceInterface(DESCRIPTOR);
                        SoterSignResult finishSign = finishSign(parcel.readLong());
                        parcel2.writeNoException();
                        if (finishSign != null) {
                            parcel2.writeInt(1);
                            finishSign.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 11:
                        parcel.enforceInterface(DESCRIPTOR);
                        SoterDeviceResult deviceId = getDeviceId();
                        parcel2.writeNoException();
                        if (deviceId != null) {
                            parcel2.writeInt(1);
                            deviceId.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 12:
                        parcel.enforceInterface(DESCRIPTOR);
                        int version = getVersion();
                        parcel2.writeNoException();
                        parcel2.writeInt(version);
                        return true;
                    case 13:
                        parcel.enforceInterface(DESCRIPTOR);
                        SoterExtraParam extraParam = getExtraParam(parcel.readString());
                        parcel2.writeNoException();
                        if (extraParam != null) {
                            parcel2.writeInt(1);
                            extraParam.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    default:
                        return super.onTransact(i3, parcel, parcel2, i16);
                }
            }
            parcel2.writeString(DESCRIPTOR);
            return true;
        }
    }

    SoterSignResult finishSign(long j3) throws RemoteException;

    int generateAppSecureKey(int i3) throws RemoteException;

    int generateAuthKey(int i3, String str) throws RemoteException;

    SoterExportResult getAppSecureKey(int i3) throws RemoteException;

    SoterExportResult getAuthKey(int i3, String str) throws RemoteException;

    SoterDeviceResult getDeviceId() throws RemoteException;

    SoterExtraParam getExtraParam(String str) throws RemoteException;

    int getVersion() throws RemoteException;

    boolean hasAskAlready(int i3) throws RemoteException;

    boolean hasAuthKey(int i3, String str) throws RemoteException;

    SoterSessionResult initSigh(int i3, String str, String str2) throws RemoteException;

    int removeAllAuthKey(int i3) throws RemoteException;

    int removeAuthKey(int i3, String str) throws RemoteException;
}
