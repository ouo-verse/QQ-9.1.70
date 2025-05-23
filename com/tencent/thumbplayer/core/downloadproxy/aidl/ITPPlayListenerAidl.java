package com.tencent.thumbplayer.core.downloadproxy.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;
import java.util.List;
import java.util.Map;

/* loaded from: classes26.dex */
public interface ITPPlayListenerAidl extends IInterface {
    long getAdvRemainTime() throws RemoteException;

    String getContentType(int i3, String str) throws RemoteException;

    int getCurrentPlayClipNo() throws RemoteException;

    long getCurrentPlayOffset() throws RemoteException;

    long getCurrentPosition() throws RemoteException;

    String getDataFilePath(int i3, String str) throws RemoteException;

    long getDataTotalSize(int i3, String str) throws RemoteException;

    String getPlayInfo(String str) throws RemoteException;

    long getPlayerBufferLength() throws RemoteException;

    void onDownloadCdnUrlExpired(Map map) throws RemoteException;

    void onDownloadCdnUrlInfoUpdate(String str, String str2, String str3, String str4) throws RemoteException;

    void onDownloadCdnUrlUpdate(String str) throws RemoteException;

    void onDownloadError(int i3, int i16, String str) throws RemoteException;

    void onDownloadFinish() throws RemoteException;

    void onDownloadProgressUpdate(int i3, int i16, long j3, long j16, String str) throws RemoteException;

    void onDownloadProtocolUpdate(String str, String str2) throws RemoteException;

    void onDownloadStatusUpdate(int i3) throws RemoteException;

    void onPcdnDownloadFailed(String str) throws RemoteException;

    int onPlayCallback(int i3, List list) throws RemoteException;

    void onQuicDownloadStatusUpdate(String str) throws RemoteException;

    int onReadData(int i3, String str, long j3, long j16) throws RemoteException;

    int onStartReadData(int i3, String str, long j3, long j16) throws RemoteException;

    int onStopReadData(int i3, String str, int i16) throws RemoteException;

    /* loaded from: classes26.dex */
    public static class Default implements ITPPlayListenerAidl {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl
        public long getAdvRemainTime() throws RemoteException {
            return 0L;
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl
        public String getContentType(int i3, String str) throws RemoteException {
            return null;
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl
        public int getCurrentPlayClipNo() throws RemoteException {
            return 0;
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl
        public long getCurrentPlayOffset() throws RemoteException {
            return 0L;
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl
        public long getCurrentPosition() throws RemoteException {
            return 0L;
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl
        public String getDataFilePath(int i3, String str) throws RemoteException {
            return null;
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl
        public long getDataTotalSize(int i3, String str) throws RemoteException {
            return 0L;
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl
        public String getPlayInfo(String str) throws RemoteException {
            return null;
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl
        public long getPlayerBufferLength() throws RemoteException {
            return 0L;
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl
        public int onPlayCallback(int i3, List list) throws RemoteException {
            return 0;
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl
        public int onReadData(int i3, String str, long j3, long j16) throws RemoteException {
            return 0;
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl
        public int onStartReadData(int i3, String str, long j3, long j16) throws RemoteException {
            return 0;
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl
        public int onStopReadData(int i3, String str, int i16) throws RemoteException {
            return 0;
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl
        public void onDownloadFinish() throws RemoteException {
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl
        public void onDownloadCdnUrlExpired(Map map) throws RemoteException {
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl
        public void onDownloadCdnUrlUpdate(String str) throws RemoteException {
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl
        public void onDownloadStatusUpdate(int i3) throws RemoteException {
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl
        public void onPcdnDownloadFailed(String str) throws RemoteException {
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl
        public void onQuicDownloadStatusUpdate(String str) throws RemoteException {
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl
        public void onDownloadProtocolUpdate(String str, String str2) throws RemoteException {
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl
        public void onDownloadError(int i3, int i16, String str) throws RemoteException {
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl
        public void onDownloadCdnUrlInfoUpdate(String str, String str2, String str3, String str4) throws RemoteException {
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl
        public void onDownloadProgressUpdate(int i3, int i16, long j3, long j16, String str) throws RemoteException {
        }
    }

    /* loaded from: classes26.dex */
    public static abstract class Stub extends Binder implements ITPPlayListenerAidl {
        private static final String DESCRIPTOR = "com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl";
        static final int TRANSACTION_getAdvRemainTime = 15;
        static final int TRANSACTION_getContentType = 22;
        static final int TRANSACTION_getCurrentPlayClipNo = 14;
        static final int TRANSACTION_getCurrentPlayOffset = 13;
        static final int TRANSACTION_getCurrentPosition = 12;
        static final int TRANSACTION_getDataFilePath = 21;
        static final int TRANSACTION_getDataTotalSize = 20;
        static final int TRANSACTION_getPlayInfo = 16;
        static final int TRANSACTION_getPlayerBufferLength = 11;
        static final int TRANSACTION_onDownloadCdnUrlExpired = 7;
        static final int TRANSACTION_onDownloadCdnUrlInfoUpdate = 6;
        static final int TRANSACTION_onDownloadCdnUrlUpdate = 5;
        static final int TRANSACTION_onDownloadError = 3;
        static final int TRANSACTION_onDownloadFinish = 2;
        static final int TRANSACTION_onDownloadProgressUpdate = 1;
        static final int TRANSACTION_onDownloadProtocolUpdate = 9;
        static final int TRANSACTION_onDownloadStatusUpdate = 8;
        static final int TRANSACTION_onPcdnDownloadFailed = 23;
        static final int TRANSACTION_onPlayCallback = 4;
        static final int TRANSACTION_onQuicDownloadStatusUpdate = 10;
        static final int TRANSACTION_onReadData = 18;
        static final int TRANSACTION_onStartReadData = 17;
        static final int TRANSACTION_onStopReadData = 19;

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes26.dex */
        public static class Proxy implements ITPPlayListenerAidl {
            public static ITPPlayListenerAidl sDefaultImpl;
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl
            public long getAdvRemainTime() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    if (!OaidMonitor.binderTransact(this.mRemote, 15, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getAdvRemainTime();
                    }
                    obtain2.readException();
                    return obtain2.readLong();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl
            public String getContentType(int i3, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeInt(i3);
                    obtain.writeString(str);
                    if (!OaidMonitor.binderTransact(this.mRemote, 22, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getContentType(i3, str);
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl
            public int getCurrentPlayClipNo() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    if (!OaidMonitor.binderTransact(this.mRemote, 14, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getCurrentPlayClipNo();
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl
            public long getCurrentPlayOffset() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    if (!OaidMonitor.binderTransact(this.mRemote, 13, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getCurrentPlayOffset();
                    }
                    obtain2.readException();
                    return obtain2.readLong();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl
            public long getCurrentPosition() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    if (!OaidMonitor.binderTransact(this.mRemote, 12, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getCurrentPosition();
                    }
                    obtain2.readException();
                    return obtain2.readLong();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl
            public String getDataFilePath(int i3, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeInt(i3);
                    obtain.writeString(str);
                    if (!OaidMonitor.binderTransact(this.mRemote, 21, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getDataFilePath(i3, str);
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl
            public long getDataTotalSize(int i3, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeInt(i3);
                    obtain.writeString(str);
                    if (!OaidMonitor.binderTransact(this.mRemote, 20, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getDataTotalSize(i3, str);
                    }
                    obtain2.readException();
                    return obtain2.readLong();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl
            public String getPlayInfo(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (!OaidMonitor.binderTransact(this.mRemote, 16, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getPlayInfo(str);
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl
            public long getPlayerBufferLength() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    if (!OaidMonitor.binderTransact(this.mRemote, 11, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getPlayerBufferLength();
                    }
                    obtain2.readException();
                    return obtain2.readLong();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl
            public void onDownloadCdnUrlExpired(Map map) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeMap(map);
                    if (!OaidMonitor.binderTransact(this.mRemote, 7, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onDownloadCdnUrlExpired(map);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl
            public void onDownloadCdnUrlInfoUpdate(String str, String str2, String str3, String str4) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    obtain.writeString(str4);
                    if (!OaidMonitor.binderTransact(this.mRemote, 6, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onDownloadCdnUrlInfoUpdate(str, str2, str3, str4);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl
            public void onDownloadCdnUrlUpdate(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (!OaidMonitor.binderTransact(this.mRemote, 5, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onDownloadCdnUrlUpdate(str);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl
            public void onDownloadError(int i3, int i16, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeInt(i3);
                    obtain.writeInt(i16);
                    obtain.writeString(str);
                    if (!OaidMonitor.binderTransact(this.mRemote, 3, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onDownloadError(i3, i16, str);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl
            public void onDownloadFinish() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    if (!OaidMonitor.binderTransact(this.mRemote, 2, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onDownloadFinish();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl
            public void onDownloadProgressUpdate(int i3, int i16, long j3, long j16, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeInt(i3);
                    obtain.writeInt(i16);
                    obtain.writeLong(j3);
                    obtain.writeLong(j16);
                    obtain.writeString(str);
                } catch (Throwable th5) {
                    th = th5;
                }
                try {
                    if (!OaidMonitor.binderTransact(this.mRemote, 1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onDownloadProgressUpdate(i3, i16, j3, j16, str);
                        OaidMonitor.parcelRecycle(obtain2);
                        OaidMonitor.parcelRecycle(obtain);
                    } else {
                        obtain2.readException();
                        OaidMonitor.parcelRecycle(obtain2);
                        OaidMonitor.parcelRecycle(obtain);
                    }
                } catch (Throwable th6) {
                    th = th6;
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                    throw th;
                }
            }

            @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl
            public void onDownloadProtocolUpdate(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (!OaidMonitor.binderTransact(this.mRemote, 9, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onDownloadProtocolUpdate(str, str2);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl
            public void onDownloadStatusUpdate(int i3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeInt(i3);
                    if (!OaidMonitor.binderTransact(this.mRemote, 8, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onDownloadStatusUpdate(i3);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl
            public void onPcdnDownloadFailed(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (!OaidMonitor.binderTransact(this.mRemote, 23, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onPcdnDownloadFailed(str);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl
            public int onPlayCallback(int i3, List list) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeInt(i3);
                    obtain.writeList(list);
                    if (!OaidMonitor.binderTransact(this.mRemote, 4, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().onPlayCallback(i3, list);
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl
            public void onQuicDownloadStatusUpdate(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (!OaidMonitor.binderTransact(this.mRemote, 10, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onQuicDownloadStatusUpdate(str);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl
            public int onReadData(int i3, String str, long j3, long j16) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeInt(i3);
                    obtain.writeString(str);
                    obtain.writeLong(j3);
                    obtain.writeLong(j16);
                } catch (Throwable th5) {
                    th = th5;
                }
                try {
                    if (!OaidMonitor.binderTransact(this.mRemote, 18, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        int onReadData = Stub.getDefaultImpl().onReadData(i3, str, j3, j16);
                        OaidMonitor.parcelRecycle(obtain2);
                        OaidMonitor.parcelRecycle(obtain);
                        return onReadData;
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

            @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl
            public int onStartReadData(int i3, String str, long j3, long j16) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeInt(i3);
                    obtain.writeString(str);
                    obtain.writeLong(j3);
                    obtain.writeLong(j16);
                } catch (Throwable th5) {
                    th = th5;
                }
                try {
                    if (!OaidMonitor.binderTransact(this.mRemote, 17, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        int onStartReadData = Stub.getDefaultImpl().onStartReadData(i3, str, j3, j16);
                        OaidMonitor.parcelRecycle(obtain2);
                        OaidMonitor.parcelRecycle(obtain);
                        return onStartReadData;
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

            @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl
            public int onStopReadData(int i3, String str, int i16) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeInt(i3);
                    obtain.writeString(str);
                    obtain.writeInt(i16);
                    if (!OaidMonitor.binderTransact(this.mRemote, 19, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().onStopReadData(i3, str, i16);
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
            attachInterface(this, DESCRIPTOR);
        }

        public static ITPPlayListenerAidl asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof ITPPlayListenerAidl)) {
                return (ITPPlayListenerAidl) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        public static ITPPlayListenerAidl getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(ITPPlayListenerAidl iTPPlayListenerAidl) {
            if (Proxy.sDefaultImpl == null) {
                if (iTPPlayListenerAidl != null) {
                    Proxy.sDefaultImpl = iTPPlayListenerAidl;
                    return true;
                }
                return false;
            }
            throw new IllegalStateException("setDefaultImpl() called twice");
        }

        @Override // android.os.Binder
        public boolean onTransact(int i3, Parcel parcel, Parcel parcel2, int i16) throws RemoteException {
            if (i3 != 1598968902) {
                switch (i3) {
                    case 1:
                        parcel.enforceInterface(DESCRIPTOR);
                        onDownloadProgressUpdate(parcel.readInt(), parcel.readInt(), parcel.readLong(), parcel.readLong(), parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 2:
                        parcel.enforceInterface(DESCRIPTOR);
                        onDownloadFinish();
                        parcel2.writeNoException();
                        return true;
                    case 3:
                        parcel.enforceInterface(DESCRIPTOR);
                        onDownloadError(parcel.readInt(), parcel.readInt(), parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 4:
                        parcel.enforceInterface(DESCRIPTOR);
                        int onPlayCallback = onPlayCallback(parcel.readInt(), parcel.readArrayList(getClass().getClassLoader()));
                        parcel2.writeNoException();
                        parcel2.writeInt(onPlayCallback);
                        return true;
                    case 5:
                        parcel.enforceInterface(DESCRIPTOR);
                        onDownloadCdnUrlUpdate(parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 6:
                        parcel.enforceInterface(DESCRIPTOR);
                        onDownloadCdnUrlInfoUpdate(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 7:
                        parcel.enforceInterface(DESCRIPTOR);
                        onDownloadCdnUrlExpired(parcel.readHashMap(getClass().getClassLoader()));
                        parcel2.writeNoException();
                        return true;
                    case 8:
                        parcel.enforceInterface(DESCRIPTOR);
                        onDownloadStatusUpdate(parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 9:
                        parcel.enforceInterface(DESCRIPTOR);
                        onDownloadProtocolUpdate(parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 10:
                        parcel.enforceInterface(DESCRIPTOR);
                        onQuicDownloadStatusUpdate(parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 11:
                        parcel.enforceInterface(DESCRIPTOR);
                        long playerBufferLength = getPlayerBufferLength();
                        parcel2.writeNoException();
                        parcel2.writeLong(playerBufferLength);
                        return true;
                    case 12:
                        parcel.enforceInterface(DESCRIPTOR);
                        long currentPosition = getCurrentPosition();
                        parcel2.writeNoException();
                        parcel2.writeLong(currentPosition);
                        return true;
                    case 13:
                        parcel.enforceInterface(DESCRIPTOR);
                        long currentPlayOffset = getCurrentPlayOffset();
                        parcel2.writeNoException();
                        parcel2.writeLong(currentPlayOffset);
                        return true;
                    case 14:
                        parcel.enforceInterface(DESCRIPTOR);
                        int currentPlayClipNo = getCurrentPlayClipNo();
                        parcel2.writeNoException();
                        parcel2.writeInt(currentPlayClipNo);
                        return true;
                    case 15:
                        parcel.enforceInterface(DESCRIPTOR);
                        long advRemainTime = getAdvRemainTime();
                        parcel2.writeNoException();
                        parcel2.writeLong(advRemainTime);
                        return true;
                    case 16:
                        parcel.enforceInterface(DESCRIPTOR);
                        String playInfo = getPlayInfo(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeString(playInfo);
                        return true;
                    case 17:
                        parcel.enforceInterface(DESCRIPTOR);
                        int onStartReadData = onStartReadData(parcel.readInt(), parcel.readString(), parcel.readLong(), parcel.readLong());
                        parcel2.writeNoException();
                        parcel2.writeInt(onStartReadData);
                        return true;
                    case 18:
                        parcel.enforceInterface(DESCRIPTOR);
                        int onReadData = onReadData(parcel.readInt(), parcel.readString(), parcel.readLong(), parcel.readLong());
                        parcel2.writeNoException();
                        parcel2.writeInt(onReadData);
                        return true;
                    case 19:
                        parcel.enforceInterface(DESCRIPTOR);
                        int onStopReadData = onStopReadData(parcel.readInt(), parcel.readString(), parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeInt(onStopReadData);
                        return true;
                    case 20:
                        parcel.enforceInterface(DESCRIPTOR);
                        long dataTotalSize = getDataTotalSize(parcel.readInt(), parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeLong(dataTotalSize);
                        return true;
                    case 21:
                        parcel.enforceInterface(DESCRIPTOR);
                        String dataFilePath = getDataFilePath(parcel.readInt(), parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeString(dataFilePath);
                        return true;
                    case 22:
                        parcel.enforceInterface(DESCRIPTOR);
                        String contentType = getContentType(parcel.readInt(), parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeString(contentType);
                        return true;
                    case 23:
                        parcel.enforceInterface(DESCRIPTOR);
                        onPcdnDownloadFailed(parcel.readString());
                        parcel2.writeNoException();
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
}
