package com.tencent.thumbplayer.core.downloadproxy.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;
import com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl;
import com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPreLoadListenerAidl;
import java.util.Map;

/* loaded from: classes26.dex */
public interface ITPDownloadProxyAidl extends IInterface {
    long GetTotalMemorySizeKB() throws RemoteException;

    int checkResourceStatus(String str, String str2, int i3) throws RemoteException;

    int clearCache(String str, String str2, int i3) throws RemoteException;

    int clearRangeCache(String str, int i3, int i16) throws RemoteException;

    String getClipPlayUrl(int i3, int i16, int i17) throws RemoteException;

    String getNativeInfo(int i3) throws RemoteException;

    String getPlayErrorCodeStr(int i3) throws RemoteException;

    String getPlayUrl(int i3, int i16) throws RemoteException;

    long getResourceSize(String str, String str2) throws RemoteException;

    int init(String str) throws RemoteException;

    int pauseDownload(int i3) throws RemoteException;

    void pushEvent(int i3) throws RemoteException;

    int resumeDownload(int i3) throws RemoteException;

    void setBusinessDownloadStrategy(int i3, int i16, int i17, int i18, int i19) throws RemoteException;

    boolean setClipInfo(int i3, int i16, String str, TPDownloadParamAidl tPDownloadParamAidl) throws RemoteException;

    void setMaxStorageSizeMB(long j3) throws RemoteException;

    void setPlayState(int i3, int i16) throws RemoteException;

    void setUpdatePlayerInfoInterval(int i3) throws RemoteException;

    void setUserData(Map map) throws RemoteException;

    int startClipPlay(String str, int i3, ITPPlayListenerAidl iTPPlayListenerAidl) throws RemoteException;

    int startClipPreload(String str, int i3, ITPPreLoadListenerAidl iTPPreLoadListenerAidl) throws RemoteException;

    int startPlay(String str, TPDownloadParamAidl tPDownloadParamAidl, ITPPlayListenerAidl iTPPlayListenerAidl) throws RemoteException;

    int startPreload(String str, TPDownloadParamAidl tPDownloadParamAidl, ITPPreLoadListenerAidl iTPPreLoadListenerAidl) throws RemoteException;

    void startTask(int i3) throws RemoteException;

    void stopPlay(int i3) throws RemoteException;

    void stopPreload(int i3) throws RemoteException;

    void updateTaskInfo(int i3, Map map) throws RemoteException;

    /* loaded from: classes26.dex */
    public static abstract class Stub extends Binder implements ITPDownloadProxyAidl {
        private static final String DESCRIPTOR = "com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl";
        static final int TRANSACTION_GetTotalMemorySizeKB = 27;
        static final int TRANSACTION_checkResourceStatus = 19;
        static final int TRANSACTION_clearCache = 18;
        static final int TRANSACTION_clearRangeCache = 17;
        static final int TRANSACTION_getClipPlayUrl = 6;
        static final int TRANSACTION_getNativeInfo = 16;
        static final int TRANSACTION_getPlayErrorCodeStr = 7;
        static final int TRANSACTION_getPlayUrl = 5;
        static final int TRANSACTION_getResourceSize = 20;
        static final int TRANSACTION_init = 1;
        static final int TRANSACTION_pauseDownload = 9;
        static final int TRANSACTION_pushEvent = 21;
        static final int TRANSACTION_resumeDownload = 10;
        static final int TRANSACTION_setBusinessDownloadStrategy = 25;
        static final int TRANSACTION_setClipInfo = 4;
        static final int TRANSACTION_setMaxStorageSizeMB = 23;
        static final int TRANSACTION_setPlayState = 22;
        static final int TRANSACTION_setUpdatePlayerInfoInterval = 26;
        static final int TRANSACTION_setUserData = 15;
        static final int TRANSACTION_startClipPlay = 3;
        static final int TRANSACTION_startClipPreload = 12;
        static final int TRANSACTION_startPlay = 2;
        static final int TRANSACTION_startPreload = 11;
        static final int TRANSACTION_startTask = 14;
        static final int TRANSACTION_stopPlay = 8;
        static final int TRANSACTION_stopPreload = 13;
        static final int TRANSACTION_updateTaskInfo = 24;

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes26.dex */
        public static class Proxy implements ITPDownloadProxyAidl {
            public static ITPDownloadProxyAidl sDefaultImpl;
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl
            public long GetTotalMemorySizeKB() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    if (!OaidMonitor.binderTransact(this.mRemote, 27, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().GetTotalMemorySizeKB();
                    }
                    obtain2.readException();
                    return obtain2.readLong();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl
            public int checkResourceStatus(String str, String str2, int i3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeInt(i3);
                    if (!OaidMonitor.binderTransact(this.mRemote, 19, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().checkResourceStatus(str, str2, i3);
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl
            public int clearCache(String str, String str2, int i3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeInt(i3);
                    if (!OaidMonitor.binderTransact(this.mRemote, 18, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().clearCache(str, str2, i3);
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl
            public int clearRangeCache(String str, int i3, int i16) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeInt(i3);
                    obtain.writeInt(i16);
                    if (!OaidMonitor.binderTransact(this.mRemote, 17, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().clearRangeCache(str, i3, i16);
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl
            public String getClipPlayUrl(int i3, int i16, int i17) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeInt(i3);
                    obtain.writeInt(i16);
                    obtain.writeInt(i17);
                    if (!OaidMonitor.binderTransact(this.mRemote, 6, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getClipPlayUrl(i3, i16, i17);
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl
            public String getNativeInfo(int i3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeInt(i3);
                    if (!OaidMonitor.binderTransact(this.mRemote, 16, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getNativeInfo(i3);
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl
            public String getPlayErrorCodeStr(int i3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeInt(i3);
                    if (!OaidMonitor.binderTransact(this.mRemote, 7, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getPlayErrorCodeStr(i3);
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl
            public String getPlayUrl(int i3, int i16) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeInt(i3);
                    obtain.writeInt(i16);
                    if (!OaidMonitor.binderTransact(this.mRemote, 5, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getPlayUrl(i3, i16);
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl
            public long getResourceSize(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (!OaidMonitor.binderTransact(this.mRemote, 20, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getResourceSize(str, str2);
                    }
                    obtain2.readException();
                    return obtain2.readLong();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl
            public int init(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (!OaidMonitor.binderTransact(this.mRemote, 1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().init(str);
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl
            public int pauseDownload(int i3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeInt(i3);
                    if (!OaidMonitor.binderTransact(this.mRemote, 9, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().pauseDownload(i3);
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl
            public void pushEvent(int i3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeInt(i3);
                    if (!OaidMonitor.binderTransact(this.mRemote, 21, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().pushEvent(i3);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl
            public int resumeDownload(int i3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeInt(i3);
                    if (!OaidMonitor.binderTransact(this.mRemote, 10, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().resumeDownload(i3);
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl
            public void setBusinessDownloadStrategy(int i3, int i16, int i17, int i18, int i19) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeInt(i3);
                    obtain.writeInt(i16);
                    obtain.writeInt(i17);
                    obtain.writeInt(i18);
                    obtain.writeInt(i19);
                    if (!OaidMonitor.binderTransact(this.mRemote, 25, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().setBusinessDownloadStrategy(i3, i16, i17, i18, i19);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl
            public boolean setClipInfo(int i3, int i16, String str, TPDownloadParamAidl tPDownloadParamAidl) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeInt(i3);
                    obtain.writeInt(i16);
                    obtain.writeString(str);
                    boolean z16 = true;
                    if (tPDownloadParamAidl != null) {
                        obtain.writeInt(1);
                        tPDownloadParamAidl.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!OaidMonitor.binderTransact(this.mRemote, 4, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().setClipInfo(i3, i16, str, tPDownloadParamAidl);
                    }
                    obtain2.readException();
                    if (obtain2.readInt() == 0) {
                        z16 = false;
                    }
                    return z16;
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl
            public void setMaxStorageSizeMB(long j3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeLong(j3);
                    if (!OaidMonitor.binderTransact(this.mRemote, 23, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().setMaxStorageSizeMB(j3);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl
            public void setPlayState(int i3, int i16) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeInt(i3);
                    obtain.writeInt(i16);
                    if (!OaidMonitor.binderTransact(this.mRemote, 22, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().setPlayState(i3, i16);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl
            public void setUpdatePlayerInfoInterval(int i3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeInt(i3);
                    if (!OaidMonitor.binderTransact(this.mRemote, 26, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().setUpdatePlayerInfoInterval(i3);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl
            public void setUserData(Map map) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeMap(map);
                    if (!OaidMonitor.binderTransact(this.mRemote, 15, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().setUserData(map);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl
            public int startClipPlay(String str, int i3, ITPPlayListenerAidl iTPPlayListenerAidl) throws RemoteException {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeInt(i3);
                    if (iTPPlayListenerAidl != null) {
                        iBinder = iTPPlayListenerAidl.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    if (!OaidMonitor.binderTransact(this.mRemote, 3, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().startClipPlay(str, i3, iTPPlayListenerAidl);
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl
            public int startClipPreload(String str, int i3, ITPPreLoadListenerAidl iTPPreLoadListenerAidl) throws RemoteException {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeInt(i3);
                    if (iTPPreLoadListenerAidl != null) {
                        iBinder = iTPPreLoadListenerAidl.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    if (!OaidMonitor.binderTransact(this.mRemote, 12, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().startClipPreload(str, i3, iTPPreLoadListenerAidl);
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl
            public int startPlay(String str, TPDownloadParamAidl tPDownloadParamAidl, ITPPlayListenerAidl iTPPlayListenerAidl) throws RemoteException {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (tPDownloadParamAidl != null) {
                        obtain.writeInt(1);
                        tPDownloadParamAidl.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (iTPPlayListenerAidl != null) {
                        iBinder = iTPPlayListenerAidl.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    if (!OaidMonitor.binderTransact(this.mRemote, 2, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().startPlay(str, tPDownloadParamAidl, iTPPlayListenerAidl);
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl
            public int startPreload(String str, TPDownloadParamAidl tPDownloadParamAidl, ITPPreLoadListenerAidl iTPPreLoadListenerAidl) throws RemoteException {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (tPDownloadParamAidl != null) {
                        obtain.writeInt(1);
                        tPDownloadParamAidl.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (iTPPreLoadListenerAidl != null) {
                        iBinder = iTPPreLoadListenerAidl.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    if (!OaidMonitor.binderTransact(this.mRemote, 11, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().startPreload(str, tPDownloadParamAidl, iTPPreLoadListenerAidl);
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl
            public void startTask(int i3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeInt(i3);
                    if (!OaidMonitor.binderTransact(this.mRemote, 14, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().startTask(i3);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl
            public void stopPlay(int i3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeInt(i3);
                    if (!OaidMonitor.binderTransact(this.mRemote, 8, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().stopPlay(i3);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl
            public void stopPreload(int i3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeInt(i3);
                    if (!OaidMonitor.binderTransact(this.mRemote, 13, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().stopPreload(i3);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl
            public void updateTaskInfo(int i3, Map map) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeInt(i3);
                    obtain.writeMap(map);
                    if (!OaidMonitor.binderTransact(this.mRemote, 24, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().updateTaskInfo(i3, map);
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

        public static ITPDownloadProxyAidl asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof ITPDownloadProxyAidl)) {
                return (ITPDownloadProxyAidl) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        public static ITPDownloadProxyAidl getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(ITPDownloadProxyAidl iTPDownloadProxyAidl) {
            if (Proxy.sDefaultImpl == null) {
                if (iTPDownloadProxyAidl != null) {
                    Proxy.sDefaultImpl = iTPDownloadProxyAidl;
                    return true;
                }
                return false;
            }
            throw new IllegalStateException("setDefaultImpl() called twice");
        }

        @Override // android.os.Binder
        public boolean onTransact(int i3, Parcel parcel, Parcel parcel2, int i16) throws RemoteException {
            if (i3 != 1598968902) {
                TPDownloadParamAidl tPDownloadParamAidl = null;
                switch (i3) {
                    case 1:
                        parcel.enforceInterface(DESCRIPTOR);
                        int init = init(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeInt(init);
                        return true;
                    case 2:
                        parcel.enforceInterface(DESCRIPTOR);
                        String readString = parcel.readString();
                        if (parcel.readInt() != 0) {
                            tPDownloadParamAidl = TPDownloadParamAidl.CREATOR.createFromParcel(parcel);
                        }
                        int startPlay = startPlay(readString, tPDownloadParamAidl, ITPPlayListenerAidl.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        parcel2.writeInt(startPlay);
                        return true;
                    case 3:
                        parcel.enforceInterface(DESCRIPTOR);
                        int startClipPlay = startClipPlay(parcel.readString(), parcel.readInt(), ITPPlayListenerAidl.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        parcel2.writeInt(startClipPlay);
                        return true;
                    case 4:
                        parcel.enforceInterface(DESCRIPTOR);
                        int readInt = parcel.readInt();
                        int readInt2 = parcel.readInt();
                        String readString2 = parcel.readString();
                        if (parcel.readInt() != 0) {
                            tPDownloadParamAidl = TPDownloadParamAidl.CREATOR.createFromParcel(parcel);
                        }
                        boolean clipInfo = setClipInfo(readInt, readInt2, readString2, tPDownloadParamAidl);
                        parcel2.writeNoException();
                        parcel2.writeInt(clipInfo ? 1 : 0);
                        return true;
                    case 5:
                        parcel.enforceInterface(DESCRIPTOR);
                        String playUrl = getPlayUrl(parcel.readInt(), parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeString(playUrl);
                        return true;
                    case 6:
                        parcel.enforceInterface(DESCRIPTOR);
                        String clipPlayUrl = getClipPlayUrl(parcel.readInt(), parcel.readInt(), parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeString(clipPlayUrl);
                        return true;
                    case 7:
                        parcel.enforceInterface(DESCRIPTOR);
                        String playErrorCodeStr = getPlayErrorCodeStr(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeString(playErrorCodeStr);
                        return true;
                    case 8:
                        parcel.enforceInterface(DESCRIPTOR);
                        stopPlay(parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 9:
                        parcel.enforceInterface(DESCRIPTOR);
                        int pauseDownload = pauseDownload(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeInt(pauseDownload);
                        return true;
                    case 10:
                        parcel.enforceInterface(DESCRIPTOR);
                        int resumeDownload = resumeDownload(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeInt(resumeDownload);
                        return true;
                    case 11:
                        parcel.enforceInterface(DESCRIPTOR);
                        String readString3 = parcel.readString();
                        if (parcel.readInt() != 0) {
                            tPDownloadParamAidl = TPDownloadParamAidl.CREATOR.createFromParcel(parcel);
                        }
                        int startPreload = startPreload(readString3, tPDownloadParamAidl, ITPPreLoadListenerAidl.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        parcel2.writeInt(startPreload);
                        return true;
                    case 12:
                        parcel.enforceInterface(DESCRIPTOR);
                        int startClipPreload = startClipPreload(parcel.readString(), parcel.readInt(), ITPPreLoadListenerAidl.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        parcel2.writeInt(startClipPreload);
                        return true;
                    case 13:
                        parcel.enforceInterface(DESCRIPTOR);
                        stopPreload(parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 14:
                        parcel.enforceInterface(DESCRIPTOR);
                        startTask(parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 15:
                        parcel.enforceInterface(DESCRIPTOR);
                        setUserData(parcel.readHashMap(getClass().getClassLoader()));
                        parcel2.writeNoException();
                        return true;
                    case 16:
                        parcel.enforceInterface(DESCRIPTOR);
                        String nativeInfo = getNativeInfo(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeString(nativeInfo);
                        return true;
                    case 17:
                        parcel.enforceInterface(DESCRIPTOR);
                        int clearRangeCache = clearRangeCache(parcel.readString(), parcel.readInt(), parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeInt(clearRangeCache);
                        return true;
                    case 18:
                        parcel.enforceInterface(DESCRIPTOR);
                        int clearCache = clearCache(parcel.readString(), parcel.readString(), parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeInt(clearCache);
                        return true;
                    case 19:
                        parcel.enforceInterface(DESCRIPTOR);
                        int checkResourceStatus = checkResourceStatus(parcel.readString(), parcel.readString(), parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeInt(checkResourceStatus);
                        return true;
                    case 20:
                        parcel.enforceInterface(DESCRIPTOR);
                        long resourceSize = getResourceSize(parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeLong(resourceSize);
                        return true;
                    case 21:
                        parcel.enforceInterface(DESCRIPTOR);
                        pushEvent(parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 22:
                        parcel.enforceInterface(DESCRIPTOR);
                        setPlayState(parcel.readInt(), parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 23:
                        parcel.enforceInterface(DESCRIPTOR);
                        setMaxStorageSizeMB(parcel.readLong());
                        parcel2.writeNoException();
                        return true;
                    case 24:
                        parcel.enforceInterface(DESCRIPTOR);
                        updateTaskInfo(parcel.readInt(), parcel.readHashMap(getClass().getClassLoader()));
                        parcel2.writeNoException();
                        return true;
                    case 25:
                        parcel.enforceInterface(DESCRIPTOR);
                        setBusinessDownloadStrategy(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 26:
                        parcel.enforceInterface(DESCRIPTOR);
                        setUpdatePlayerInfoInterval(parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 27:
                        parcel.enforceInterface(DESCRIPTOR);
                        long GetTotalMemorySizeKB = GetTotalMemorySizeKB();
                        parcel2.writeNoException();
                        parcel2.writeLong(GetTotalMemorySizeKB);
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

    /* loaded from: classes26.dex */
    public static class Default implements ITPDownloadProxyAidl {
        @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl
        public long GetTotalMemorySizeKB() throws RemoteException {
            return 0L;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl
        public int checkResourceStatus(String str, String str2, int i3) throws RemoteException {
            return 0;
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl
        public int clearCache(String str, String str2, int i3) throws RemoteException {
            return 0;
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl
        public int clearRangeCache(String str, int i3, int i16) throws RemoteException {
            return 0;
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl
        public String getClipPlayUrl(int i3, int i16, int i17) throws RemoteException {
            return null;
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl
        public String getNativeInfo(int i3) throws RemoteException {
            return null;
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl
        public String getPlayErrorCodeStr(int i3) throws RemoteException {
            return null;
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl
        public String getPlayUrl(int i3, int i16) throws RemoteException {
            return null;
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl
        public long getResourceSize(String str, String str2) throws RemoteException {
            return 0L;
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl
        public int init(String str) throws RemoteException {
            return 0;
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl
        public int pauseDownload(int i3) throws RemoteException {
            return 0;
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl
        public int resumeDownload(int i3) throws RemoteException {
            return 0;
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl
        public boolean setClipInfo(int i3, int i16, String str, TPDownloadParamAidl tPDownloadParamAidl) throws RemoteException {
            return false;
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl
        public int startClipPlay(String str, int i3, ITPPlayListenerAidl iTPPlayListenerAidl) throws RemoteException {
            return 0;
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl
        public int startClipPreload(String str, int i3, ITPPreLoadListenerAidl iTPPreLoadListenerAidl) throws RemoteException {
            return 0;
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl
        public int startPlay(String str, TPDownloadParamAidl tPDownloadParamAidl, ITPPlayListenerAidl iTPPlayListenerAidl) throws RemoteException {
            return 0;
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl
        public int startPreload(String str, TPDownloadParamAidl tPDownloadParamAidl, ITPPreLoadListenerAidl iTPPreLoadListenerAidl) throws RemoteException {
            return 0;
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl
        public void pushEvent(int i3) throws RemoteException {
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl
        public void setMaxStorageSizeMB(long j3) throws RemoteException {
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl
        public void setUpdatePlayerInfoInterval(int i3) throws RemoteException {
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl
        public void setUserData(Map map) throws RemoteException {
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl
        public void startTask(int i3) throws RemoteException {
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl
        public void stopPlay(int i3) throws RemoteException {
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl
        public void stopPreload(int i3) throws RemoteException {
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl
        public void setPlayState(int i3, int i16) throws RemoteException {
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl
        public void updateTaskInfo(int i3, Map map) throws RemoteException {
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPDownloadProxyAidl
        public void setBusinessDownloadStrategy(int i3, int i16, int i17, int i18, int i19) throws RemoteException {
        }
    }
}
