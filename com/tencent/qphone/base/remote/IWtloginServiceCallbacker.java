package com.tencent.qphone.base.remote;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;
import java.util.ArrayList;
import java.util.List;
import oicq.wlogin_sdk.devicelock.DevlockInfo;
import oicq.wlogin_sdk.request.WFastLoginInfo;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.tools.ErrMsg;

/* compiled from: P */
/* loaded from: classes22.dex */
public interface IWtloginServiceCallbacker extends IInterface {
    public static final String DESCRIPTOR = "com.tencent.qphone.base.remote.IWtloginServiceCallbacker";

    void OnCheckPictureAndGetSt(String str, byte[] bArr, byte[] bArr2, WUserSigInfo wUserSigInfo, DevlockInfo devlockInfo, int i3, ErrMsg errMsg) throws RemoteException;

    void OnCheckSMSAndGetSt(String str, byte[] bArr, WUserSigInfo wUserSigInfo, int i3, ErrMsg errMsg) throws RemoteException;

    void OnCloseCode(String str, byte[] bArr, long j3, WUserSigInfo wUserSigInfo, byte[] bArr2, int i3, ErrMsg errMsg) throws RemoteException;

    void OnException(String str, int i3) throws RemoteException;

    void OnGetStWithPasswd(String str, long j3, int i3, long j16, String str2, byte[] bArr, WUserSigInfo wUserSigInfo, DevlockInfo devlockInfo, int i16, ErrMsg errMsg) throws RemoteException;

    void OnGetStWithoutPasswd(String str, long j3, long j16, int i3, long j17, WUserSigInfo wUserSigInfo, int i16, ErrMsg errMsg) throws RemoteException;

    void OnRefreshPictureData(String str, byte[] bArr, int i3, ErrMsg errMsg) throws RemoteException;

    void OnRefreshSMSData(String str, long j3, WUserSigInfo wUserSigInfo, int i3, int i16, int i17, ErrMsg errMsg) throws RemoteException;

    void OnVerifyCode(String str, byte[] bArr, long j3, List list, byte[] bArr2, int i3, ErrMsg errMsg) throws RemoteException;

    void onGetA1WithA1(String str, long j3, int i3, long j16, byte[] bArr, long j17, long j18, long j19, byte[] bArr2, byte[] bArr3, WUserSigInfo wUserSigInfo, WFastLoginInfo wFastLoginInfo, int i16, ErrMsg errMsg) throws RemoteException;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static abstract class Stub extends Binder implements IWtloginServiceCallbacker {
        static final int TRANSACTION_OnCheckPictureAndGetSt = 3;
        static final int TRANSACTION_OnCheckSMSAndGetSt = 10;
        static final int TRANSACTION_OnCloseCode = 7;
        static final int TRANSACTION_OnException = 5;
        static final int TRANSACTION_OnGetStWithPasswd = 1;
        static final int TRANSACTION_OnGetStWithoutPasswd = 2;
        static final int TRANSACTION_OnRefreshPictureData = 4;
        static final int TRANSACTION_OnRefreshSMSData = 9;
        static final int TRANSACTION_OnVerifyCode = 6;
        static final int TRANSACTION_onGetA1WithA1 = 8;

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: P */
        /* loaded from: classes22.dex */
        public static class Proxy implements IWtloginServiceCallbacker {
            public static IWtloginServiceCallbacker sDefaultImpl;
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // com.tencent.qphone.base.remote.IWtloginServiceCallbacker
            public void OnCheckPictureAndGetSt(String str, byte[] bArr, byte[] bArr2, WUserSigInfo wUserSigInfo, DevlockInfo devlockInfo, int i3, ErrMsg errMsg) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, IWtloginServiceCallbacker.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeByteArray(bArr);
                    obtain.writeByteArray(bArr2);
                    if (wUserSigInfo != null) {
                        obtain.writeInt(1);
                        wUserSigInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (devlockInfo != null) {
                        obtain.writeInt(1);
                        devlockInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(i3);
                    if (errMsg != null) {
                        obtain.writeInt(1);
                        errMsg.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                } catch (Throwable th5) {
                    th = th5;
                }
                try {
                    if (!OaidMonitor.binderTransact(this.mRemote, 3, obtain, null, 1) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().OnCheckPictureAndGetSt(str, bArr, bArr2, wUserSigInfo, devlockInfo, i3, errMsg);
                        OaidMonitor.parcelRecycle(obtain);
                    } else {
                        OaidMonitor.parcelRecycle(obtain);
                    }
                } catch (Throwable th6) {
                    th = th6;
                    OaidMonitor.parcelRecycle(obtain);
                    throw th;
                }
            }

            @Override // com.tencent.qphone.base.remote.IWtloginServiceCallbacker
            public void OnCheckSMSAndGetSt(String str, byte[] bArr, WUserSigInfo wUserSigInfo, int i3, ErrMsg errMsg) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, IWtloginServiceCallbacker.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeByteArray(bArr);
                    if (wUserSigInfo != null) {
                        obtain.writeInt(1);
                        wUserSigInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(i3);
                    if (errMsg != null) {
                        obtain.writeInt(1);
                        errMsg.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!OaidMonitor.binderTransact(this.mRemote, 10, obtain, null, 1) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().OnCheckSMSAndGetSt(str, bArr, wUserSigInfo, i3, errMsg);
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.qphone.base.remote.IWtloginServiceCallbacker
            public void OnCloseCode(String str, byte[] bArr, long j3, WUserSigInfo wUserSigInfo, byte[] bArr2, int i3, ErrMsg errMsg) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, IWtloginServiceCallbacker.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeByteArray(bArr);
                    obtain.writeLong(j3);
                    if (wUserSigInfo != null) {
                        obtain.writeInt(1);
                        wUserSigInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeByteArray(bArr2);
                    obtain.writeInt(i3);
                    if (errMsg != null) {
                        obtain.writeInt(1);
                        errMsg.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                } catch (Throwable th5) {
                    th = th5;
                }
                try {
                    if (!OaidMonitor.binderTransact(this.mRemote, 7, obtain, null, 1) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().OnCloseCode(str, bArr, j3, wUserSigInfo, bArr2, i3, errMsg);
                        OaidMonitor.parcelRecycle(obtain);
                    } else {
                        OaidMonitor.parcelRecycle(obtain);
                    }
                } catch (Throwable th6) {
                    th = th6;
                    OaidMonitor.parcelRecycle(obtain);
                    throw th;
                }
            }

            @Override // com.tencent.qphone.base.remote.IWtloginServiceCallbacker
            public void OnException(String str, int i3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, IWtloginServiceCallbacker.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeInt(i3);
                    if (!OaidMonitor.binderTransact(this.mRemote, 5, obtain, null, 1) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().OnException(str, i3);
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.qphone.base.remote.IWtloginServiceCallbacker
            public void OnGetStWithPasswd(String str, long j3, int i3, long j16, String str2, byte[] bArr, WUserSigInfo wUserSigInfo, DevlockInfo devlockInfo, int i16, ErrMsg errMsg) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, IWtloginServiceCallbacker.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeLong(j3);
                    obtain.writeInt(i3);
                    obtain.writeLong(j16);
                    obtain.writeString(str2);
                    obtain.writeByteArray(bArr);
                    if (wUserSigInfo != null) {
                        obtain.writeInt(1);
                        wUserSigInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (devlockInfo != null) {
                        obtain.writeInt(1);
                        devlockInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(i16);
                    if (errMsg != null) {
                        obtain.writeInt(1);
                        errMsg.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                } catch (Throwable th5) {
                    th = th5;
                }
                try {
                    if (!OaidMonitor.binderTransact(this.mRemote, 1, obtain, null, 1) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().OnGetStWithPasswd(str, j3, i3, j16, str2, bArr, wUserSigInfo, devlockInfo, i16, errMsg);
                        OaidMonitor.parcelRecycle(obtain);
                    } else {
                        OaidMonitor.parcelRecycle(obtain);
                    }
                } catch (Throwable th6) {
                    th = th6;
                    OaidMonitor.parcelRecycle(obtain);
                    throw th;
                }
            }

            @Override // com.tencent.qphone.base.remote.IWtloginServiceCallbacker
            public void OnGetStWithoutPasswd(String str, long j3, long j16, int i3, long j17, WUserSigInfo wUserSigInfo, int i16, ErrMsg errMsg) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, IWtloginServiceCallbacker.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeLong(j3);
                    obtain.writeLong(j16);
                    obtain.writeInt(i3);
                    obtain.writeLong(j17);
                    if (wUserSigInfo != null) {
                        obtain.writeInt(1);
                        wUserSigInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(i16);
                    if (errMsg != null) {
                        obtain.writeInt(1);
                        errMsg.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                } catch (Throwable th5) {
                    th = th5;
                }
                try {
                    if (!OaidMonitor.binderTransact(this.mRemote, 2, obtain, null, 1) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().OnGetStWithoutPasswd(str, j3, j16, i3, j17, wUserSigInfo, i16, errMsg);
                        OaidMonitor.parcelRecycle(obtain);
                    } else {
                        OaidMonitor.parcelRecycle(obtain);
                    }
                } catch (Throwable th6) {
                    th = th6;
                    OaidMonitor.parcelRecycle(obtain);
                    throw th;
                }
            }

            @Override // com.tencent.qphone.base.remote.IWtloginServiceCallbacker
            public void OnRefreshPictureData(String str, byte[] bArr, int i3, ErrMsg errMsg) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, IWtloginServiceCallbacker.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeByteArray(bArr);
                    obtain.writeInt(i3);
                    if (errMsg != null) {
                        obtain.writeInt(1);
                        errMsg.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!OaidMonitor.binderTransact(this.mRemote, 4, obtain, null, 1) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().OnRefreshPictureData(str, bArr, i3, errMsg);
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.qphone.base.remote.IWtloginServiceCallbacker
            public void OnRefreshSMSData(String str, long j3, WUserSigInfo wUserSigInfo, int i3, int i16, int i17, ErrMsg errMsg) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, IWtloginServiceCallbacker.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeLong(j3);
                    if (wUserSigInfo != null) {
                        obtain.writeInt(1);
                        wUserSigInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(i3);
                    obtain.writeInt(i16);
                    obtain.writeInt(i17);
                    if (errMsg != null) {
                        obtain.writeInt(1);
                        errMsg.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    try {
                        if (!OaidMonitor.binderTransact(this.mRemote, 9, obtain, null, 1) && Stub.getDefaultImpl() != null) {
                            Stub.getDefaultImpl().OnRefreshSMSData(str, j3, wUserSigInfo, i3, i16, i17, errMsg);
                            OaidMonitor.parcelRecycle(obtain);
                        } else {
                            OaidMonitor.parcelRecycle(obtain);
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        OaidMonitor.parcelRecycle(obtain);
                        throw th;
                    }
                } catch (Throwable th6) {
                    th = th6;
                }
            }

            @Override // com.tencent.qphone.base.remote.IWtloginServiceCallbacker
            public void OnVerifyCode(String str, byte[] bArr, long j3, List list, byte[] bArr2, int i3, ErrMsg errMsg) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, IWtloginServiceCallbacker.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeByteArray(bArr);
                    obtain.writeLong(j3);
                    obtain.writeList(list);
                    obtain.writeByteArray(bArr2);
                    obtain.writeInt(i3);
                    if (errMsg != null) {
                        obtain.writeInt(1);
                        errMsg.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                } catch (Throwable th5) {
                    th = th5;
                }
                try {
                    if (!OaidMonitor.binderTransact(this.mRemote, 6, obtain, null, 1) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().OnVerifyCode(str, bArr, j3, list, bArr2, i3, errMsg);
                        OaidMonitor.parcelRecycle(obtain);
                    } else {
                        OaidMonitor.parcelRecycle(obtain);
                    }
                } catch (Throwable th6) {
                    th = th6;
                    OaidMonitor.parcelRecycle(obtain);
                    throw th;
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IWtloginServiceCallbacker.DESCRIPTOR;
            }

            @Override // com.tencent.qphone.base.remote.IWtloginServiceCallbacker
            public void onGetA1WithA1(String str, long j3, int i3, long j16, byte[] bArr, long j17, long j18, long j19, byte[] bArr2, byte[] bArr3, WUserSigInfo wUserSigInfo, WFastLoginInfo wFastLoginInfo, int i16, ErrMsg errMsg) throws RemoteException {
                Parcel parcel;
                Parcel obtain = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, IWtloginServiceCallbacker.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeLong(j3);
                    obtain.writeInt(i3);
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
                    obtain.writeInt(i16);
                    if (errMsg != null) {
                        obtain.writeInt(1);
                        errMsg.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (OaidMonitor.binderTransact(this.mRemote, 8, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        OaidMonitor.parcelRecycle(obtain);
                        return;
                    }
                    parcel = obtain;
                    try {
                        Stub.getDefaultImpl().onGetA1WithA1(str, j3, i3, j16, bArr, j17, j18, j19, bArr2, bArr3, wUserSigInfo, wFastLoginInfo, i16, errMsg);
                        OaidMonitor.parcelRecycle(parcel);
                    } catch (Throwable th5) {
                        th = th5;
                        OaidMonitor.parcelRecycle(parcel);
                        throw th;
                    }
                } catch (Throwable th6) {
                    th = th6;
                    parcel = obtain;
                }
            }
        }

        public Stub() {
            attachInterface(this, IWtloginServiceCallbacker.DESCRIPTOR);
        }

        public static IWtloginServiceCallbacker asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(IWtloginServiceCallbacker.DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof IWtloginServiceCallbacker)) {
                return (IWtloginServiceCallbacker) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        public static IWtloginServiceCallbacker getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IWtloginServiceCallbacker iWtloginServiceCallbacker) {
            if (Proxy.sDefaultImpl == null) {
                if (iWtloginServiceCallbacker != null) {
                    Proxy.sDefaultImpl = iWtloginServiceCallbacker;
                    return true;
                }
                return false;
            }
            throw new IllegalStateException("setDefaultImpl() called twice");
        }

        @Override // android.os.Binder
        public boolean onTransact(int i3, Parcel parcel, Parcel parcel2, int i16) throws RemoteException {
            WUserSigInfo wUserSigInfo;
            DevlockInfo devlockInfo;
            ErrMsg errMsg;
            WUserSigInfo wUserSigInfo2;
            ErrMsg errMsg2;
            WUserSigInfo wUserSigInfo3;
            DevlockInfo devlockInfo2;
            ErrMsg errMsg3;
            ErrMsg errMsg4;
            WUserSigInfo wUserSigInfo4;
            ErrMsg errMsg5;
            WUserSigInfo wUserSigInfo5;
            WFastLoginInfo wFastLoginInfo;
            ErrMsg errMsg6;
            WUserSigInfo wUserSigInfo6;
            ErrMsg errMsg7;
            WUserSigInfo wUserSigInfo7;
            ErrMsg errMsg8;
            if (i3 != 1598968902) {
                ErrMsg errMsg9 = null;
                switch (i3) {
                    case 1:
                        parcel.enforceInterface(IWtloginServiceCallbacker.DESCRIPTOR);
                        String readString = parcel.readString();
                        long readLong = parcel.readLong();
                        int readInt = parcel.readInt();
                        long readLong2 = parcel.readLong();
                        String readString2 = parcel.readString();
                        byte[] createByteArray = parcel.createByteArray();
                        if (parcel.readInt() != 0) {
                            wUserSigInfo = WUserSigInfo.CREATOR.createFromParcel(parcel);
                        } else {
                            wUserSigInfo = null;
                        }
                        if (parcel.readInt() != 0) {
                            devlockInfo = DevlockInfo.CREATOR.createFromParcel(parcel);
                        } else {
                            devlockInfo = null;
                        }
                        int readInt2 = parcel.readInt();
                        if (parcel.readInt() != 0) {
                            errMsg = ErrMsg.CREATOR.createFromParcel(parcel);
                        } else {
                            errMsg = null;
                        }
                        OnGetStWithPasswd(readString, readLong, readInt, readLong2, readString2, createByteArray, wUserSigInfo, devlockInfo, readInt2, errMsg);
                        return true;
                    case 2:
                        parcel.enforceInterface(IWtloginServiceCallbacker.DESCRIPTOR);
                        String readString3 = parcel.readString();
                        long readLong3 = parcel.readLong();
                        long readLong4 = parcel.readLong();
                        int readInt3 = parcel.readInt();
                        long readLong5 = parcel.readLong();
                        if (parcel.readInt() != 0) {
                            wUserSigInfo2 = WUserSigInfo.CREATOR.createFromParcel(parcel);
                        } else {
                            wUserSigInfo2 = null;
                        }
                        int readInt4 = parcel.readInt();
                        if (parcel.readInt() != 0) {
                            errMsg2 = ErrMsg.CREATOR.createFromParcel(parcel);
                        } else {
                            errMsg2 = null;
                        }
                        OnGetStWithoutPasswd(readString3, readLong3, readLong4, readInt3, readLong5, wUserSigInfo2, readInt4, errMsg2);
                        return true;
                    case 3:
                        parcel.enforceInterface(IWtloginServiceCallbacker.DESCRIPTOR);
                        String readString4 = parcel.readString();
                        byte[] createByteArray2 = parcel.createByteArray();
                        byte[] createByteArray3 = parcel.createByteArray();
                        if (parcel.readInt() != 0) {
                            wUserSigInfo3 = WUserSigInfo.CREATOR.createFromParcel(parcel);
                        } else {
                            wUserSigInfo3 = null;
                        }
                        if (parcel.readInt() != 0) {
                            devlockInfo2 = DevlockInfo.CREATOR.createFromParcel(parcel);
                        } else {
                            devlockInfo2 = null;
                        }
                        int readInt5 = parcel.readInt();
                        if (parcel.readInt() != 0) {
                            errMsg3 = ErrMsg.CREATOR.createFromParcel(parcel);
                        } else {
                            errMsg3 = null;
                        }
                        OnCheckPictureAndGetSt(readString4, createByteArray2, createByteArray3, wUserSigInfo3, devlockInfo2, readInt5, errMsg3);
                        return true;
                    case 4:
                        parcel.enforceInterface(IWtloginServiceCallbacker.DESCRIPTOR);
                        String readString5 = parcel.readString();
                        byte[] createByteArray4 = parcel.createByteArray();
                        int readInt6 = parcel.readInt();
                        if (parcel.readInt() != 0) {
                            errMsg9 = ErrMsg.CREATOR.createFromParcel(parcel);
                        }
                        OnRefreshPictureData(readString5, createByteArray4, readInt6, errMsg9);
                        return true;
                    case 5:
                        parcel.enforceInterface(IWtloginServiceCallbacker.DESCRIPTOR);
                        OnException(parcel.readString(), parcel.readInt());
                        return true;
                    case 6:
                        parcel.enforceInterface(IWtloginServiceCallbacker.DESCRIPTOR);
                        String readString6 = parcel.readString();
                        byte[] createByteArray5 = parcel.createByteArray();
                        long readLong6 = parcel.readLong();
                        ArrayList readArrayList = parcel.readArrayList(getClass().getClassLoader());
                        byte[] createByteArray6 = parcel.createByteArray();
                        int readInt7 = parcel.readInt();
                        if (parcel.readInt() != 0) {
                            errMsg4 = ErrMsg.CREATOR.createFromParcel(parcel);
                        } else {
                            errMsg4 = null;
                        }
                        OnVerifyCode(readString6, createByteArray5, readLong6, readArrayList, createByteArray6, readInt7, errMsg4);
                        return true;
                    case 7:
                        parcel.enforceInterface(IWtloginServiceCallbacker.DESCRIPTOR);
                        String readString7 = parcel.readString();
                        byte[] createByteArray7 = parcel.createByteArray();
                        long readLong7 = parcel.readLong();
                        if (parcel.readInt() != 0) {
                            wUserSigInfo4 = WUserSigInfo.CREATOR.createFromParcel(parcel);
                        } else {
                            wUserSigInfo4 = null;
                        }
                        byte[] createByteArray8 = parcel.createByteArray();
                        int readInt8 = parcel.readInt();
                        if (parcel.readInt() != 0) {
                            errMsg5 = ErrMsg.CREATOR.createFromParcel(parcel);
                        } else {
                            errMsg5 = null;
                        }
                        OnCloseCode(readString7, createByteArray7, readLong7, wUserSigInfo4, createByteArray8, readInt8, errMsg5);
                        return true;
                    case 8:
                        parcel.enforceInterface(IWtloginServiceCallbacker.DESCRIPTOR);
                        String readString8 = parcel.readString();
                        long readLong8 = parcel.readLong();
                        int readInt9 = parcel.readInt();
                        long readLong9 = parcel.readLong();
                        byte[] createByteArray9 = parcel.createByteArray();
                        long readLong10 = parcel.readLong();
                        long readLong11 = parcel.readLong();
                        long readLong12 = parcel.readLong();
                        byte[] createByteArray10 = parcel.createByteArray();
                        byte[] createByteArray11 = parcel.createByteArray();
                        if (parcel.readInt() != 0) {
                            wUserSigInfo5 = WUserSigInfo.CREATOR.createFromParcel(parcel);
                        } else {
                            wUserSigInfo5 = null;
                        }
                        if (parcel.readInt() != 0) {
                            wFastLoginInfo = WFastLoginInfo.CREATOR.createFromParcel(parcel);
                        } else {
                            wFastLoginInfo = null;
                        }
                        int readInt10 = parcel.readInt();
                        if (parcel.readInt() != 0) {
                            errMsg6 = ErrMsg.CREATOR.createFromParcel(parcel);
                        } else {
                            errMsg6 = null;
                        }
                        onGetA1WithA1(readString8, readLong8, readInt9, readLong9, createByteArray9, readLong10, readLong11, readLong12, createByteArray10, createByteArray11, wUserSigInfo5, wFastLoginInfo, readInt10, errMsg6);
                        return true;
                    case 9:
                        parcel.enforceInterface(IWtloginServiceCallbacker.DESCRIPTOR);
                        String readString9 = parcel.readString();
                        long readLong13 = parcel.readLong();
                        if (parcel.readInt() != 0) {
                            wUserSigInfo6 = WUserSigInfo.CREATOR.createFromParcel(parcel);
                        } else {
                            wUserSigInfo6 = null;
                        }
                        int readInt11 = parcel.readInt();
                        int readInt12 = parcel.readInt();
                        int readInt13 = parcel.readInt();
                        if (parcel.readInt() != 0) {
                            errMsg7 = ErrMsg.CREATOR.createFromParcel(parcel);
                        } else {
                            errMsg7 = null;
                        }
                        OnRefreshSMSData(readString9, readLong13, wUserSigInfo6, readInt11, readInt12, readInt13, errMsg7);
                        return true;
                    case 10:
                        parcel.enforceInterface(IWtloginServiceCallbacker.DESCRIPTOR);
                        String readString10 = parcel.readString();
                        byte[] createByteArray12 = parcel.createByteArray();
                        if (parcel.readInt() != 0) {
                            wUserSigInfo7 = WUserSigInfo.CREATOR.createFromParcel(parcel);
                        } else {
                            wUserSigInfo7 = null;
                        }
                        int readInt14 = parcel.readInt();
                        if (parcel.readInt() != 0) {
                            errMsg8 = ErrMsg.CREATOR.createFromParcel(parcel);
                        } else {
                            errMsg8 = null;
                        }
                        OnCheckSMSAndGetSt(readString10, createByteArray12, wUserSigInfo7, readInt14, errMsg8);
                        return true;
                    default:
                        return super.onTransact(i3, parcel, parcel2, i16);
                }
            }
            parcel2.writeString(IWtloginServiceCallbacker.DESCRIPTOR);
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class Default implements IWtloginServiceCallbacker {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.tencent.qphone.base.remote.IWtloginServiceCallbacker
        public void OnException(String str, int i3) throws RemoteException {
        }

        @Override // com.tencent.qphone.base.remote.IWtloginServiceCallbacker
        public void onGetA1WithA1(String str, long j3, int i3, long j16, byte[] bArr, long j17, long j18, long j19, byte[] bArr2, byte[] bArr3, WUserSigInfo wUserSigInfo, WFastLoginInfo wFastLoginInfo, int i16, ErrMsg errMsg) throws RemoteException {
        }

        @Override // com.tencent.qphone.base.remote.IWtloginServiceCallbacker
        public void OnRefreshPictureData(String str, byte[] bArr, int i3, ErrMsg errMsg) throws RemoteException {
        }

        @Override // com.tencent.qphone.base.remote.IWtloginServiceCallbacker
        public void OnGetStWithoutPasswd(String str, long j3, long j16, int i3, long j17, WUserSigInfo wUserSigInfo, int i16, ErrMsg errMsg) throws RemoteException {
        }

        @Override // com.tencent.qphone.base.remote.IWtloginServiceCallbacker
        public void OnCheckSMSAndGetSt(String str, byte[] bArr, WUserSigInfo wUserSigInfo, int i3, ErrMsg errMsg) throws RemoteException {
        }

        @Override // com.tencent.qphone.base.remote.IWtloginServiceCallbacker
        public void OnGetStWithPasswd(String str, long j3, int i3, long j16, String str2, byte[] bArr, WUserSigInfo wUserSigInfo, DevlockInfo devlockInfo, int i16, ErrMsg errMsg) throws RemoteException {
        }

        @Override // com.tencent.qphone.base.remote.IWtloginServiceCallbacker
        public void OnCheckPictureAndGetSt(String str, byte[] bArr, byte[] bArr2, WUserSigInfo wUserSigInfo, DevlockInfo devlockInfo, int i3, ErrMsg errMsg) throws RemoteException {
        }

        @Override // com.tencent.qphone.base.remote.IWtloginServiceCallbacker
        public void OnCloseCode(String str, byte[] bArr, long j3, WUserSigInfo wUserSigInfo, byte[] bArr2, int i3, ErrMsg errMsg) throws RemoteException {
        }

        @Override // com.tencent.qphone.base.remote.IWtloginServiceCallbacker
        public void OnRefreshSMSData(String str, long j3, WUserSigInfo wUserSigInfo, int i3, int i16, int i17, ErrMsg errMsg) throws RemoteException {
        }

        @Override // com.tencent.qphone.base.remote.IWtloginServiceCallbacker
        public void OnVerifyCode(String str, byte[] bArr, long j3, List list, byte[] bArr2, int i3, ErrMsg errMsg) throws RemoteException {
        }
    }
}
