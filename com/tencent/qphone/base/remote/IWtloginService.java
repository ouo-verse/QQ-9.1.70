package com.tencent.qphone.base.remote;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;
import com.tencent.qphone.base.remote.IWtloginServiceCallbacker;
import java.util.ArrayList;
import java.util.List;
import oicq.wlogin_sdk.request.WFastLoginInfo;
import oicq.wlogin_sdk.request.WUserSigInfo;

/* compiled from: P */
/* loaded from: classes22.dex */
public interface IWtloginService extends IInterface {
    public static final String DESCRIPTOR = "com.tencent.qphone.base.remote.IWtloginService";

    int CheckPictureAndGetSt(String str, String str2, byte[] bArr, WUserSigInfo wUserSigInfo, IWtloginServiceCallbacker iWtloginServiceCallbacker) throws RemoteException;

    int CheckSMSAndGetSt(String str, String str2, byte[] bArr, WUserSigInfo wUserSigInfo, IWtloginServiceCallbacker iWtloginServiceCallbacker) throws RemoteException;

    int CloseCode(String str, String str2, long j3, byte[] bArr, int i3, List list, WUserSigInfo wUserSigInfo, IWtloginServiceCallbacker iWtloginServiceCallbacker) throws RemoteException;

    int GetA1WithA1(String str, String str2, long j3, long j16, byte[] bArr, long j17, long j18, long j19, byte[] bArr2, byte[] bArr3, WUserSigInfo wUserSigInfo, WFastLoginInfo wFastLoginInfo, IWtloginServiceCallbacker iWtloginServiceCallbacker) throws RemoteException;

    int GetStWithPasswd(String str, String str2, long j3, String str3, WUserSigInfo wUserSigInfo, IWtloginServiceCallbacker iWtloginServiceCallbacker) throws RemoteException;

    int GetStWithoutPasswd(String str, String str2, long j3, long j16, WUserSigInfo wUserSigInfo, IWtloginServiceCallbacker iWtloginServiceCallbacker) throws RemoteException;

    int RefreshPictureData(String str, String str2, WUserSigInfo wUserSigInfo, IWtloginServiceCallbacker iWtloginServiceCallbacker) throws RemoteException;

    int RefreshSMSData(String str, String str2, WUserSigInfo wUserSigInfo, IWtloginServiceCallbacker iWtloginServiceCallbacker) throws RemoteException;

    int VerifyCode(String str, String str2, long j3, boolean z16, byte[] bArr, int[] iArr, int i3, WUserSigInfo wUserSigInfo, IWtloginServiceCallbacker iWtloginServiceCallbacker) throws RemoteException;

    void removeRemoteHelper(String str) throws RemoteException;

    void setTestHost(String str, int i3, String str2, IWtloginServiceCallbacker iWtloginServiceCallbacker) throws RemoteException;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static abstract class Stub extends Binder implements IWtloginService {
        static final int TRANSACTION_CheckPictureAndGetSt = 4;
        static final int TRANSACTION_CheckSMSAndGetSt = 10;
        static final int TRANSACTION_CloseCode = 7;
        static final int TRANSACTION_GetA1WithA1 = 8;
        static final int TRANSACTION_GetStWithPasswd = 1;
        static final int TRANSACTION_GetStWithoutPasswd = 3;
        static final int TRANSACTION_RefreshPictureData = 5;
        static final int TRANSACTION_RefreshSMSData = 9;
        static final int TRANSACTION_VerifyCode = 6;
        static final int TRANSACTION_removeRemoteHelper = 2;
        static final int TRANSACTION_setTestHost = 11;

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: P */
        /* loaded from: classes22.dex */
        public static class Proxy implements IWtloginService {
            public static IWtloginService sDefaultImpl;
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // com.tencent.qphone.base.remote.IWtloginService
            public int CheckPictureAndGetSt(String str, String str2, byte[] bArr, WUserSigInfo wUserSigInfo, IWtloginServiceCallbacker iWtloginServiceCallbacker) throws RemoteException {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, IWtloginService.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeByteArray(bArr);
                    if (wUserSigInfo != null) {
                        obtain.writeInt(1);
                        wUserSigInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (iWtloginServiceCallbacker != null) {
                        iBinder = iWtloginServiceCallbacker.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    if (!OaidMonitor.binderTransact(this.mRemote, 4, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().CheckPictureAndGetSt(str, str2, bArr, wUserSigInfo, iWtloginServiceCallbacker);
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.qphone.base.remote.IWtloginService
            public int CheckSMSAndGetSt(String str, String str2, byte[] bArr, WUserSigInfo wUserSigInfo, IWtloginServiceCallbacker iWtloginServiceCallbacker) throws RemoteException {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, IWtloginService.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeByteArray(bArr);
                    if (wUserSigInfo != null) {
                        obtain.writeInt(1);
                        wUserSigInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (iWtloginServiceCallbacker != null) {
                        iBinder = iWtloginServiceCallbacker.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    if (!OaidMonitor.binderTransact(this.mRemote, 10, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().CheckSMSAndGetSt(str, str2, bArr, wUserSigInfo, iWtloginServiceCallbacker);
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.qphone.base.remote.IWtloginService
            public int CloseCode(String str, String str2, long j3, byte[] bArr, int i3, List list, WUserSigInfo wUserSigInfo, IWtloginServiceCallbacker iWtloginServiceCallbacker) throws RemoteException {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, IWtloginService.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeLong(j3);
                    obtain.writeByteArray(bArr);
                    obtain.writeInt(i3);
                    obtain.writeList(list);
                    if (wUserSigInfo != null) {
                        obtain.writeInt(1);
                        wUserSigInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (iWtloginServiceCallbacker != null) {
                        iBinder = iWtloginServiceCallbacker.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                } catch (Throwable th5) {
                    th = th5;
                }
                try {
                    if (!OaidMonitor.binderTransact(this.mRemote, 7, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        int CloseCode = Stub.getDefaultImpl().CloseCode(str, str2, j3, bArr, i3, list, wUserSigInfo, iWtloginServiceCallbacker);
                        OaidMonitor.parcelRecycle(obtain2);
                        OaidMonitor.parcelRecycle(obtain);
                        return CloseCode;
                    }
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                    return readInt;
                } catch (Throwable th6) {
                    th = th6;
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                    throw th;
                }
            }

            @Override // com.tencent.qphone.base.remote.IWtloginService
            public int GetA1WithA1(String str, String str2, long j3, long j16, byte[] bArr, long j17, long j18, long j19, byte[] bArr2, byte[] bArr3, WUserSigInfo wUserSigInfo, WFastLoginInfo wFastLoginInfo, IWtloginServiceCallbacker iWtloginServiceCallbacker) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, IWtloginService.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeLong(j3);
                    obtain.writeLong(j16);
                    obtain.writeByteArray(bArr);
                    obtain.writeLong(j17);
                    obtain.writeLong(j18);
                    obtain.writeLong(j19);
                    obtain.writeByteArray(bArr2);
                    obtain.writeByteArray(bArr3);
                    if (wUserSigInfo != null) {
                        obtain.writeInt(1);
                        wUserSigInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (wFastLoginInfo != null) {
                        obtain.writeInt(1);
                        wFastLoginInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(iWtloginServiceCallbacker != null ? iWtloginServiceCallbacker.asBinder() : null);
                } catch (Throwable th5) {
                    th = th5;
                }
                try {
                    if (!OaidMonitor.binderTransact(this.mRemote, 8, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        int GetA1WithA1 = Stub.getDefaultImpl().GetA1WithA1(str, str2, j3, j16, bArr, j17, j18, j19, bArr2, bArr3, wUserSigInfo, wFastLoginInfo, iWtloginServiceCallbacker);
                        OaidMonitor.parcelRecycle(obtain2);
                        OaidMonitor.parcelRecycle(obtain);
                        return GetA1WithA1;
                    }
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                    return readInt;
                } catch (Throwable th6) {
                    th = th6;
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                    throw th;
                }
            }

            @Override // com.tencent.qphone.base.remote.IWtloginService
            public int GetStWithPasswd(String str, String str2, long j3, String str3, WUserSigInfo wUserSigInfo, IWtloginServiceCallbacker iWtloginServiceCallbacker) throws RemoteException {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, IWtloginService.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeLong(j3);
                    obtain.writeString(str3);
                    if (wUserSigInfo != null) {
                        obtain.writeInt(1);
                        wUserSigInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (iWtloginServiceCallbacker != null) {
                        iBinder = iWtloginServiceCallbacker.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    try {
                        if (!OaidMonitor.binderTransact(this.mRemote, 1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                            int GetStWithPasswd = Stub.getDefaultImpl().GetStWithPasswd(str, str2, j3, str3, wUserSigInfo, iWtloginServiceCallbacker);
                            OaidMonitor.parcelRecycle(obtain2);
                            OaidMonitor.parcelRecycle(obtain);
                            return GetStWithPasswd;
                        }
                        obtain2.readException();
                        int readInt = obtain2.readInt();
                        OaidMonitor.parcelRecycle(obtain2);
                        OaidMonitor.parcelRecycle(obtain);
                        return readInt;
                    } catch (Throwable th5) {
                        th = th5;
                        OaidMonitor.parcelRecycle(obtain2);
                        OaidMonitor.parcelRecycle(obtain);
                        throw th;
                    }
                } catch (Throwable th6) {
                    th = th6;
                }
            }

            @Override // com.tencent.qphone.base.remote.IWtloginService
            public int GetStWithoutPasswd(String str, String str2, long j3, long j16, WUserSigInfo wUserSigInfo, IWtloginServiceCallbacker iWtloginServiceCallbacker) throws RemoteException {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, IWtloginService.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeLong(j3);
                    obtain.writeLong(j16);
                    if (wUserSigInfo != null) {
                        obtain.writeInt(1);
                        wUserSigInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (iWtloginServiceCallbacker != null) {
                        iBinder = iWtloginServiceCallbacker.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                } catch (Throwable th5) {
                    th = th5;
                }
                try {
                    if (!OaidMonitor.binderTransact(this.mRemote, 3, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        int GetStWithoutPasswd = Stub.getDefaultImpl().GetStWithoutPasswd(str, str2, j3, j16, wUserSigInfo, iWtloginServiceCallbacker);
                        OaidMonitor.parcelRecycle(obtain2);
                        OaidMonitor.parcelRecycle(obtain);
                        return GetStWithoutPasswd;
                    }
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                    return readInt;
                } catch (Throwable th6) {
                    th = th6;
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                    throw th;
                }
            }

            @Override // com.tencent.qphone.base.remote.IWtloginService
            public int RefreshPictureData(String str, String str2, WUserSigInfo wUserSigInfo, IWtloginServiceCallbacker iWtloginServiceCallbacker) throws RemoteException {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, IWtloginService.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (wUserSigInfo != null) {
                        obtain.writeInt(1);
                        wUserSigInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (iWtloginServiceCallbacker != null) {
                        iBinder = iWtloginServiceCallbacker.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    if (!OaidMonitor.binderTransact(this.mRemote, 5, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().RefreshPictureData(str, str2, wUserSigInfo, iWtloginServiceCallbacker);
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.qphone.base.remote.IWtloginService
            public int RefreshSMSData(String str, String str2, WUserSigInfo wUserSigInfo, IWtloginServiceCallbacker iWtloginServiceCallbacker) throws RemoteException {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, IWtloginService.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (wUserSigInfo != null) {
                        obtain.writeInt(1);
                        wUserSigInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (iWtloginServiceCallbacker != null) {
                        iBinder = iWtloginServiceCallbacker.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    if (!OaidMonitor.binderTransact(this.mRemote, 9, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().RefreshSMSData(str, str2, wUserSigInfo, iWtloginServiceCallbacker);
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.qphone.base.remote.IWtloginService
            public int VerifyCode(String str, String str2, long j3, boolean z16, byte[] bArr, int[] iArr, int i3, WUserSigInfo wUserSigInfo, IWtloginServiceCallbacker iWtloginServiceCallbacker) throws RemoteException {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, IWtloginService.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeLong(j3);
                    obtain.writeInt(z16 ? 1 : 0);
                    obtain.writeByteArray(bArr);
                    obtain.writeIntArray(iArr);
                    obtain.writeInt(i3);
                    if (wUserSigInfo != null) {
                        obtain.writeInt(1);
                        wUserSigInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (iWtloginServiceCallbacker != null) {
                        iBinder = iWtloginServiceCallbacker.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                } catch (Throwable th5) {
                    th = th5;
                }
                try {
                    if (!OaidMonitor.binderTransact(this.mRemote, 6, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        int VerifyCode = Stub.getDefaultImpl().VerifyCode(str, str2, j3, z16, bArr, iArr, i3, wUserSigInfo, iWtloginServiceCallbacker);
                        OaidMonitor.parcelRecycle(obtain2);
                        OaidMonitor.parcelRecycle(obtain);
                        return VerifyCode;
                    }
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                    return readInt;
                } catch (Throwable th6) {
                    th = th6;
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                    throw th;
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IWtloginService.DESCRIPTOR;
            }

            @Override // com.tencent.qphone.base.remote.IWtloginService
            public void removeRemoteHelper(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, IWtloginService.DESCRIPTOR);
                    obtain.writeString(str);
                    if (!OaidMonitor.binderTransact(this.mRemote, 2, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().removeRemoteHelper(str);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.qphone.base.remote.IWtloginService
            public void setTestHost(String str, int i3, String str2, IWtloginServiceCallbacker iWtloginServiceCallbacker) throws RemoteException {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, IWtloginService.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeInt(i3);
                    obtain.writeString(str2);
                    if (iWtloginServiceCallbacker != null) {
                        iBinder = iWtloginServiceCallbacker.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    if (!OaidMonitor.binderTransact(this.mRemote, 11, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().setTestHost(str, i3, str2, iWtloginServiceCallbacker);
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
            attachInterface(this, IWtloginService.DESCRIPTOR);
        }

        public static IWtloginService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(IWtloginService.DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof IWtloginService)) {
                return (IWtloginService) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        public static IWtloginService getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IWtloginService iWtloginService) {
            if (Proxy.sDefaultImpl == null) {
                if (iWtloginService != null) {
                    Proxy.sDefaultImpl = iWtloginService;
                    return true;
                }
                return false;
            }
            throw new IllegalStateException("setDefaultImpl() called twice");
        }

        @Override // android.os.Binder
        public boolean onTransact(int i3, Parcel parcel, Parcel parcel2, int i16) throws RemoteException {
            WUserSigInfo wUserSigInfo;
            WUserSigInfo wUserSigInfo2;
            WUserSigInfo wUserSigInfo3;
            boolean z16;
            WUserSigInfo wUserSigInfo4;
            WUserSigInfo wUserSigInfo5;
            WUserSigInfo wUserSigInfo6;
            WFastLoginInfo wFastLoginInfo;
            WUserSigInfo wUserSigInfo7;
            if (i3 != 1598968902) {
                WUserSigInfo wUserSigInfo8 = null;
                switch (i3) {
                    case 1:
                        parcel.enforceInterface(IWtloginService.DESCRIPTOR);
                        String readString = parcel.readString();
                        String readString2 = parcel.readString();
                        long readLong = parcel.readLong();
                        String readString3 = parcel.readString();
                        if (parcel.readInt() != 0) {
                            wUserSigInfo = WUserSigInfo.CREATOR.createFromParcel(parcel);
                        } else {
                            wUserSigInfo = null;
                        }
                        int GetStWithPasswd = GetStWithPasswd(readString, readString2, readLong, readString3, wUserSigInfo, IWtloginServiceCallbacker.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        parcel2.writeInt(GetStWithPasswd);
                        return true;
                    case 2:
                        parcel.enforceInterface(IWtloginService.DESCRIPTOR);
                        removeRemoteHelper(parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 3:
                        parcel.enforceInterface(IWtloginService.DESCRIPTOR);
                        String readString4 = parcel.readString();
                        String readString5 = parcel.readString();
                        long readLong2 = parcel.readLong();
                        long readLong3 = parcel.readLong();
                        if (parcel.readInt() != 0) {
                            wUserSigInfo2 = WUserSigInfo.CREATOR.createFromParcel(parcel);
                        } else {
                            wUserSigInfo2 = null;
                        }
                        int GetStWithoutPasswd = GetStWithoutPasswd(readString4, readString5, readLong2, readLong3, wUserSigInfo2, IWtloginServiceCallbacker.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        parcel2.writeInt(GetStWithoutPasswd);
                        return true;
                    case 4:
                        parcel.enforceInterface(IWtloginService.DESCRIPTOR);
                        String readString6 = parcel.readString();
                        String readString7 = parcel.readString();
                        byte[] createByteArray = parcel.createByteArray();
                        if (parcel.readInt() != 0) {
                            wUserSigInfo3 = WUserSigInfo.CREATOR.createFromParcel(parcel);
                        } else {
                            wUserSigInfo3 = null;
                        }
                        int CheckPictureAndGetSt = CheckPictureAndGetSt(readString6, readString7, createByteArray, wUserSigInfo3, IWtloginServiceCallbacker.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        parcel2.writeInt(CheckPictureAndGetSt);
                        return true;
                    case 5:
                        parcel.enforceInterface(IWtloginService.DESCRIPTOR);
                        String readString8 = parcel.readString();
                        String readString9 = parcel.readString();
                        if (parcel.readInt() != 0) {
                            wUserSigInfo8 = WUserSigInfo.CREATOR.createFromParcel(parcel);
                        }
                        int RefreshPictureData = RefreshPictureData(readString8, readString9, wUserSigInfo8, IWtloginServiceCallbacker.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        parcel2.writeInt(RefreshPictureData);
                        return true;
                    case 6:
                        parcel.enforceInterface(IWtloginService.DESCRIPTOR);
                        String readString10 = parcel.readString();
                        String readString11 = parcel.readString();
                        long readLong4 = parcel.readLong();
                        if (parcel.readInt() != 0) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        byte[] createByteArray2 = parcel.createByteArray();
                        int[] createIntArray = parcel.createIntArray();
                        int readInt = parcel.readInt();
                        if (parcel.readInt() != 0) {
                            wUserSigInfo4 = WUserSigInfo.CREATOR.createFromParcel(parcel);
                        } else {
                            wUserSigInfo4 = null;
                        }
                        int VerifyCode = VerifyCode(readString10, readString11, readLong4, z16, createByteArray2, createIntArray, readInt, wUserSigInfo4, IWtloginServiceCallbacker.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        parcel2.writeInt(VerifyCode);
                        return true;
                    case 7:
                        parcel.enforceInterface(IWtloginService.DESCRIPTOR);
                        String readString12 = parcel.readString();
                        String readString13 = parcel.readString();
                        long readLong5 = parcel.readLong();
                        byte[] createByteArray3 = parcel.createByteArray();
                        int readInt2 = parcel.readInt();
                        ArrayList readArrayList = parcel.readArrayList(getClass().getClassLoader());
                        if (parcel.readInt() != 0) {
                            wUserSigInfo5 = WUserSigInfo.CREATOR.createFromParcel(parcel);
                        } else {
                            wUserSigInfo5 = null;
                        }
                        int CloseCode = CloseCode(readString12, readString13, readLong5, createByteArray3, readInt2, readArrayList, wUserSigInfo5, IWtloginServiceCallbacker.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        parcel2.writeInt(CloseCode);
                        return true;
                    case 8:
                        parcel.enforceInterface(IWtloginService.DESCRIPTOR);
                        String readString14 = parcel.readString();
                        String readString15 = parcel.readString();
                        long readLong6 = parcel.readLong();
                        long readLong7 = parcel.readLong();
                        byte[] createByteArray4 = parcel.createByteArray();
                        long readLong8 = parcel.readLong();
                        long readLong9 = parcel.readLong();
                        long readLong10 = parcel.readLong();
                        byte[] createByteArray5 = parcel.createByteArray();
                        byte[] createByteArray6 = parcel.createByteArray();
                        if (parcel.readInt() != 0) {
                            wUserSigInfo6 = WUserSigInfo.CREATOR.createFromParcel(parcel);
                        } else {
                            wUserSigInfo6 = null;
                        }
                        if (parcel.readInt() != 0) {
                            wFastLoginInfo = WFastLoginInfo.CREATOR.createFromParcel(parcel);
                        } else {
                            wFastLoginInfo = null;
                        }
                        int GetA1WithA1 = GetA1WithA1(readString14, readString15, readLong6, readLong7, createByteArray4, readLong8, readLong9, readLong10, createByteArray5, createByteArray6, wUserSigInfo6, wFastLoginInfo, IWtloginServiceCallbacker.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        parcel2.writeInt(GetA1WithA1);
                        return true;
                    case 9:
                        parcel.enforceInterface(IWtloginService.DESCRIPTOR);
                        String readString16 = parcel.readString();
                        String readString17 = parcel.readString();
                        if (parcel.readInt() != 0) {
                            wUserSigInfo8 = WUserSigInfo.CREATOR.createFromParcel(parcel);
                        }
                        int RefreshSMSData = RefreshSMSData(readString16, readString17, wUserSigInfo8, IWtloginServiceCallbacker.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        parcel2.writeInt(RefreshSMSData);
                        return true;
                    case 10:
                        parcel.enforceInterface(IWtloginService.DESCRIPTOR);
                        String readString18 = parcel.readString();
                        String readString19 = parcel.readString();
                        byte[] createByteArray7 = parcel.createByteArray();
                        if (parcel.readInt() != 0) {
                            wUserSigInfo7 = WUserSigInfo.CREATOR.createFromParcel(parcel);
                        } else {
                            wUserSigInfo7 = null;
                        }
                        int CheckSMSAndGetSt = CheckSMSAndGetSt(readString18, readString19, createByteArray7, wUserSigInfo7, IWtloginServiceCallbacker.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        parcel2.writeInt(CheckSMSAndGetSt);
                        return true;
                    case 11:
                        parcel.enforceInterface(IWtloginService.DESCRIPTOR);
                        setTestHost(parcel.readString(), parcel.readInt(), parcel.readString(), IWtloginServiceCallbacker.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    default:
                        return super.onTransact(i3, parcel, parcel2, i16);
                }
            }
            parcel2.writeString(IWtloginService.DESCRIPTOR);
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class Default implements IWtloginService {
        @Override // com.tencent.qphone.base.remote.IWtloginService
        public int CheckPictureAndGetSt(String str, String str2, byte[] bArr, WUserSigInfo wUserSigInfo, IWtloginServiceCallbacker iWtloginServiceCallbacker) throws RemoteException {
            return 0;
        }

        @Override // com.tencent.qphone.base.remote.IWtloginService
        public int CheckSMSAndGetSt(String str, String str2, byte[] bArr, WUserSigInfo wUserSigInfo, IWtloginServiceCallbacker iWtloginServiceCallbacker) throws RemoteException {
            return 0;
        }

        @Override // com.tencent.qphone.base.remote.IWtloginService
        public int CloseCode(String str, String str2, long j3, byte[] bArr, int i3, List list, WUserSigInfo wUserSigInfo, IWtloginServiceCallbacker iWtloginServiceCallbacker) throws RemoteException {
            return 0;
        }

        @Override // com.tencent.qphone.base.remote.IWtloginService
        public int GetA1WithA1(String str, String str2, long j3, long j16, byte[] bArr, long j17, long j18, long j19, byte[] bArr2, byte[] bArr3, WUserSigInfo wUserSigInfo, WFastLoginInfo wFastLoginInfo, IWtloginServiceCallbacker iWtloginServiceCallbacker) throws RemoteException {
            return 0;
        }

        @Override // com.tencent.qphone.base.remote.IWtloginService
        public int GetStWithPasswd(String str, String str2, long j3, String str3, WUserSigInfo wUserSigInfo, IWtloginServiceCallbacker iWtloginServiceCallbacker) throws RemoteException {
            return 0;
        }

        @Override // com.tencent.qphone.base.remote.IWtloginService
        public int GetStWithoutPasswd(String str, String str2, long j3, long j16, WUserSigInfo wUserSigInfo, IWtloginServiceCallbacker iWtloginServiceCallbacker) throws RemoteException {
            return 0;
        }

        @Override // com.tencent.qphone.base.remote.IWtloginService
        public int RefreshPictureData(String str, String str2, WUserSigInfo wUserSigInfo, IWtloginServiceCallbacker iWtloginServiceCallbacker) throws RemoteException {
            return 0;
        }

        @Override // com.tencent.qphone.base.remote.IWtloginService
        public int RefreshSMSData(String str, String str2, WUserSigInfo wUserSigInfo, IWtloginServiceCallbacker iWtloginServiceCallbacker) throws RemoteException {
            return 0;
        }

        @Override // com.tencent.qphone.base.remote.IWtloginService
        public int VerifyCode(String str, String str2, long j3, boolean z16, byte[] bArr, int[] iArr, int i3, WUserSigInfo wUserSigInfo, IWtloginServiceCallbacker iWtloginServiceCallbacker) throws RemoteException {
            return 0;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.tencent.qphone.base.remote.IWtloginService
        public void removeRemoteHelper(String str) throws RemoteException {
        }

        @Override // com.tencent.qphone.base.remote.IWtloginService
        public void setTestHost(String str, int i3, String str2, IWtloginServiceCallbacker iWtloginServiceCallbacker) throws RemoteException {
        }
    }
}
