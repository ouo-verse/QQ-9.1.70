package com.tencent.superplayer.seamless.ipc;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.view.Surface;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes26.dex */
public interface a extends IInterface {

    /* compiled from: P */
    /* renamed from: com.tencent.superplayer.seamless.ipc.a$a, reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    public static abstract class AbstractBinderC9875a extends Binder implements a {

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: P */
        /* renamed from: com.tencent.superplayer.seamless.ipc.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes26.dex */
        public static class C9876a implements a {

            /* renamed from: e, reason: collision with root package name */
            public static a f373965e;

            /* renamed from: d, reason: collision with root package name */
            private IBinder f373966d;

            C9876a(IBinder iBinder) {
                this.f373966d = iBinder;
            }

            @Override // com.tencent.superplayer.seamless.ipc.a
            public void E2(f fVar) throws RemoteException {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.superplayer.seamless.ipc.IRemotePlayer");
                    if (fVar != null) {
                        iBinder = fVar.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    if (!OaidMonitor.binderTransact(this.f373966d, 32, obtain, obtain2, 0) && AbstractBinderC9875a.v() != null) {
                        AbstractBinderC9875a.v().E2(fVar);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.superplayer.seamless.ipc.a
            public void Q(d dVar) throws RemoteException {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.superplayer.seamless.ipc.IRemotePlayer");
                    if (dVar != null) {
                        iBinder = dVar.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    if (!OaidMonitor.binderTransact(this.f373966d, 37, obtain, obtain2, 0) && AbstractBinderC9875a.v() != null) {
                        AbstractBinderC9875a.v().Q(dVar);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.superplayer.seamless.ipc.a
            public void T1(int i3, int i16) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.superplayer.seamless.ipc.IRemotePlayer");
                    obtain.writeInt(i3);
                    obtain.writeInt(i16);
                    if (!OaidMonitor.binderTransact(this.f373966d, 15, obtain, obtain2, 0) && AbstractBinderC9875a.v() != null) {
                        AbstractBinderC9875a.v().T1(i3, i16);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.superplayer.seamless.ipc.a
            public void U4(boolean z16, long j3, long j16) throws RemoteException {
                int i3;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.superplayer.seamless.ipc.IRemotePlayer");
                    if (z16) {
                        i3 = 1;
                    } else {
                        i3 = 0;
                    }
                    obtain.writeInt(i3);
                    obtain.writeLong(j3);
                    obtain.writeLong(j16);
                    if (!OaidMonitor.binderTransact(this.f373966d, 19, obtain, obtain2, 0) && AbstractBinderC9875a.v() != null) {
                        AbstractBinderC9875a.v().U4(z16, j3, j16);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.superplayer.seamless.ipc.a
            public void addExtReportData(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.superplayer.seamless.ipc.IRemotePlayer");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (!OaidMonitor.binderTransact(this.f373966d, 2, obtain, obtain2, 0) && AbstractBinderC9875a.v() != null) {
                        AbstractBinderC9875a.v().addExtReportData(str, str2);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f373966d;
            }

            @Override // com.tencent.superplayer.seamless.ipc.a
            public void deselectTrack(int i3, long j3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.superplayer.seamless.ipc.IRemotePlayer");
                    obtain.writeInt(i3);
                    obtain.writeLong(j3);
                    if (!OaidMonitor.binderTransact(this.f373966d, 39, obtain, obtain2, 0) && AbstractBinderC9875a.v() != null) {
                        AbstractBinderC9875a.v().deselectTrack(i3, j3);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.superplayer.seamless.ipc.a
            public int getCurrentPlayerState() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.superplayer.seamless.ipc.IRemotePlayer");
                    if (!OaidMonitor.binderTransact(this.f373966d, 47, obtain, obtain2, 0) && AbstractBinderC9875a.v() != null) {
                        return AbstractBinderC9875a.v().getCurrentPlayerState();
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.superplayer.seamless.ipc.a
            public long getCurrentPositionMs() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.superplayer.seamless.ipc.IRemotePlayer");
                    if (!OaidMonitor.binderTransact(this.f373966d, 23, obtain, obtain2, 0) && AbstractBinderC9875a.v() != null) {
                        return AbstractBinderC9875a.v().getCurrentPositionMs();
                    }
                    obtain2.readException();
                    return obtain2.readLong();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.superplayer.seamless.ipc.a
            public long getDurationMs() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.superplayer.seamless.ipc.IRemotePlayer");
                    if (!OaidMonitor.binderTransact(this.f373966d, 22, obtain, obtain2, 0) && AbstractBinderC9875a.v() != null) {
                        return AbstractBinderC9875a.v().getDurationMs();
                    }
                    obtain2.readException();
                    return obtain2.readLong();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.superplayer.seamless.ipc.a
            public long getFileSizeBytes() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.superplayer.seamless.ipc.IRemotePlayer");
                    if (!OaidMonitor.binderTransact(this.f373966d, 48, obtain, obtain2, 0) && AbstractBinderC9875a.v() != null) {
                        return AbstractBinderC9875a.v().getFileSizeBytes();
                    }
                    obtain2.readException();
                    return obtain2.readLong();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.superplayer.seamless.ipc.a
            public String getStreamDumpInfo() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.superplayer.seamless.ipc.IRemotePlayer");
                    if (!OaidMonitor.binderTransact(this.f373966d, 29, obtain, obtain2, 0) && AbstractBinderC9875a.v() != null) {
                        return AbstractBinderC9875a.v().getStreamDumpInfo();
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.superplayer.seamless.ipc.a
            public String getToken() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.superplayer.seamless.ipc.IRemotePlayer");
                    if (!OaidMonitor.binderTransact(this.f373966d, 43, obtain, obtain2, 0) && AbstractBinderC9875a.v() != null) {
                        return AbstractBinderC9875a.v().getToken();
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.superplayer.seamless.ipc.a
            public int getVideoHeight() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.superplayer.seamless.ipc.IRemotePlayer");
                    if (!OaidMonitor.binderTransact(this.f373966d, 25, obtain, obtain2, 0) && AbstractBinderC9875a.v() != null) {
                        return AbstractBinderC9875a.v().getVideoHeight();
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.superplayer.seamless.ipc.a
            public int getVideoRotation() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.superplayer.seamless.ipc.IRemotePlayer");
                    if (!OaidMonitor.binderTransact(this.f373966d, 30, obtain, obtain2, 0) && AbstractBinderC9875a.v() != null) {
                        return AbstractBinderC9875a.v().getVideoRotation();
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.superplayer.seamless.ipc.a
            public int getVideoWidth() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.superplayer.seamless.ipc.IRemotePlayer");
                    if (!OaidMonitor.binderTransact(this.f373966d, 24, obtain, obtain2, 0) && AbstractBinderC9875a.v() != null) {
                        return AbstractBinderC9875a.v().getVideoWidth();
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.superplayer.seamless.ipc.a
            public void h3(Map map) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.superplayer.seamless.ipc.IRemotePlayer");
                    obtain.writeMap(map);
                    if (!OaidMonitor.binderTransact(this.f373966d, 3, obtain, obtain2, 0) && AbstractBinderC9875a.v() != null) {
                        AbstractBinderC9875a.v().h3(map);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.superplayer.seamless.ipc.a
            public boolean isBuffering() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.superplayer.seamless.ipc.IRemotePlayer");
                    boolean z16 = false;
                    if (!OaidMonitor.binderTransact(this.f373966d, 28, obtain, obtain2, 0) && AbstractBinderC9875a.v() != null) {
                        return AbstractBinderC9875a.v().isBuffering();
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

            @Override // com.tencent.superplayer.seamless.ipc.a
            public boolean isLoopBack() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.superplayer.seamless.ipc.IRemotePlayer");
                    boolean z16 = false;
                    if (!OaidMonitor.binderTransact(this.f373966d, 21, obtain, obtain2, 0) && AbstractBinderC9875a.v() != null) {
                        return AbstractBinderC9875a.v().isLoopBack();
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

            @Override // com.tencent.superplayer.seamless.ipc.a
            public boolean isOutputMute() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.superplayer.seamless.ipc.IRemotePlayer");
                    boolean z16 = false;
                    if (!OaidMonitor.binderTransact(this.f373966d, 17, obtain, obtain2, 0) && AbstractBinderC9875a.v() != null) {
                        return AbstractBinderC9875a.v().isOutputMute();
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

            @Override // com.tencent.superplayer.seamless.ipc.a
            public boolean isPausing() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.superplayer.seamless.ipc.IRemotePlayer");
                    boolean z16 = false;
                    if (!OaidMonitor.binderTransact(this.f373966d, 27, obtain, obtain2, 0) && AbstractBinderC9875a.v() != null) {
                        return AbstractBinderC9875a.v().isPausing();
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

            @Override // com.tencent.superplayer.seamless.ipc.a
            public boolean isPlaying() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.superplayer.seamless.ipc.IRemotePlayer");
                    boolean z16 = false;
                    if (!OaidMonitor.binderTransact(this.f373966d, 26, obtain, obtain2, 0) && AbstractBinderC9875a.v() != null) {
                        return AbstractBinderC9875a.v().isPlaying();
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

            @Override // com.tencent.superplayer.seamless.ipc.a
            public void l1(i iVar) throws RemoteException {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.superplayer.seamless.ipc.IRemotePlayer");
                    if (iVar != null) {
                        iBinder = iVar.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    if (!OaidMonitor.binderTransact(this.f373966d, 36, obtain, obtain2, 0) && AbstractBinderC9875a.v() != null) {
                        AbstractBinderC9875a.v().l1(iVar);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.superplayer.seamless.ipc.a
            public void onPrePlayViewShow() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.superplayer.seamless.ipc.IRemotePlayer");
                    if (!OaidMonitor.binderTransact(this.f373966d, 1, obtain, obtain2, 0) && AbstractBinderC9875a.v() != null) {
                        AbstractBinderC9875a.v().onPrePlayViewShow();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.superplayer.seamless.ipc.a
            public void pause() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.superplayer.seamless.ipc.IRemotePlayer");
                    if (!OaidMonitor.binderTransact(this.f373966d, 10, obtain, obtain2, 0) && AbstractBinderC9875a.v() != null) {
                        AbstractBinderC9875a.v().pause();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.superplayer.seamless.ipc.a
            public void pauseDownload() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.superplayer.seamless.ipc.IRemotePlayer");
                    if (!OaidMonitor.binderTransact(this.f373966d, 44, obtain, obtain2, 0) && AbstractBinderC9875a.v() != null) {
                        AbstractBinderC9875a.v().pauseDownload();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.superplayer.seamless.ipc.a
            public void release() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.superplayer.seamless.ipc.IRemotePlayer");
                    if (!OaidMonitor.binderTransact(this.f373966d, 12, obtain, obtain2, 0) && AbstractBinderC9875a.v() != null) {
                        AbstractBinderC9875a.v().release();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.superplayer.seamless.ipc.a
            public void reset() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.superplayer.seamless.ipc.IRemotePlayer");
                    if (!OaidMonitor.binderTransact(this.f373966d, 13, obtain, obtain2, 0) && AbstractBinderC9875a.v() != null) {
                        AbstractBinderC9875a.v().reset();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.superplayer.seamless.ipc.a
            public void resumeDownload() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.superplayer.seamless.ipc.IRemotePlayer");
                    if (!OaidMonitor.binderTransact(this.f373966d, 45, obtain, obtain2, 0) && AbstractBinderC9875a.v() != null) {
                        AbstractBinderC9875a.v().resumeDownload();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.superplayer.seamless.ipc.a
            public void seekTo(int i3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.superplayer.seamless.ipc.IRemotePlayer");
                    obtain.writeInt(i3);
                    if (!OaidMonitor.binderTransact(this.f373966d, 14, obtain, obtain2, 0) && AbstractBinderC9875a.v() != null) {
                        AbstractBinderC9875a.v().seekTo(i3);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.superplayer.seamless.ipc.a
            public void selectProgram(int i3, long j3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.superplayer.seamless.ipc.IRemotePlayer");
                    obtain.writeInt(i3);
                    obtain.writeLong(j3);
                    if (!OaidMonitor.binderTransact(this.f373966d, 40, obtain, obtain2, 0) && AbstractBinderC9875a.v() != null) {
                        AbstractBinderC9875a.v().selectProgram(i3, j3);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.superplayer.seamless.ipc.a
            public void selectTrack(int i3, long j3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.superplayer.seamless.ipc.IRemotePlayer");
                    obtain.writeInt(i3);
                    obtain.writeLong(j3);
                    if (!OaidMonitor.binderTransact(this.f373966d, 38, obtain, obtain2, 0) && AbstractBinderC9875a.v() != null) {
                        AbstractBinderC9875a.v().selectTrack(i3, j3);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.superplayer.seamless.ipc.a
            public void setBusinessDownloadStrategy(int i3, int i16, int i17, int i18) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.superplayer.seamless.ipc.IRemotePlayer");
                    obtain.writeInt(i3);
                    obtain.writeInt(i16);
                    obtain.writeInt(i17);
                    obtain.writeInt(i18);
                    if (!OaidMonitor.binderTransact(this.f373966d, 8, obtain, obtain2, 0) && AbstractBinderC9875a.v() != null) {
                        AbstractBinderC9875a.v().setBusinessDownloadStrategy(i3, i16, i17, i18);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.superplayer.seamless.ipc.a
            public void setLoopback(boolean z16) throws RemoteException {
                int i3;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.superplayer.seamless.ipc.IRemotePlayer");
                    if (z16) {
                        i3 = 1;
                    } else {
                        i3 = 0;
                    }
                    obtain.writeInt(i3);
                    if (!OaidMonitor.binderTransact(this.f373966d, 18, obtain, obtain2, 0) && AbstractBinderC9875a.v() != null) {
                        AbstractBinderC9875a.v().setLoopback(z16);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.superplayer.seamless.ipc.a
            public void setOutputMute(boolean z16) throws RemoteException {
                int i3;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.superplayer.seamless.ipc.IRemotePlayer");
                    if (z16) {
                        i3 = 1;
                    } else {
                        i3 = 0;
                    }
                    obtain.writeInt(i3);
                    if (!OaidMonitor.binderTransact(this.f373966d, 16, obtain, obtain2, 0) && AbstractBinderC9875a.v() != null) {
                        AbstractBinderC9875a.v().setOutputMute(z16);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.superplayer.seamless.ipc.a
            public void setPlaySpeedRatio(float f16) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.superplayer.seamless.ipc.IRemotePlayer");
                    obtain.writeFloat(f16);
                    if (!OaidMonitor.binderTransact(this.f373966d, 7, obtain, obtain2, 0) && AbstractBinderC9875a.v() != null) {
                        AbstractBinderC9875a.v().setPlaySpeedRatio(f16);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.superplayer.seamless.ipc.a
            public void setPlayerActive() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.superplayer.seamless.ipc.IRemotePlayer");
                    if (!OaidMonitor.binderTransact(this.f373966d, 50, obtain, obtain2, 0) && AbstractBinderC9875a.v() != null) {
                        AbstractBinderC9875a.v().setPlayerActive();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.superplayer.seamless.ipc.a
            public void setReportContentId(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.superplayer.seamless.ipc.IRemotePlayer");
                    obtain.writeString(str);
                    if (!OaidMonitor.binderTransact(this.f373966d, 49, obtain, obtain2, 0) && AbstractBinderC9875a.v() != null) {
                        AbstractBinderC9875a.v().setReportContentId(str);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.superplayer.seamless.ipc.a
            public void setSurface(Surface surface) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.superplayer.seamless.ipc.IRemotePlayer");
                    if (surface != null) {
                        obtain.writeInt(1);
                        surface.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!OaidMonitor.binderTransact(this.f373966d, 4, obtain, obtain2, 0) && AbstractBinderC9875a.v() != null) {
                        AbstractBinderC9875a.v().setSurface(surface);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.superplayer.seamless.ipc.a
            public void start() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.superplayer.seamless.ipc.IRemotePlayer");
                    if (!OaidMonitor.binderTransact(this.f373966d, 9, obtain, obtain2, 0) && AbstractBinderC9875a.v() != null) {
                        AbstractBinderC9875a.v().start();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.superplayer.seamless.ipc.a
            public void stop() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.superplayer.seamless.ipc.IRemotePlayer");
                    if (!OaidMonitor.binderTransact(this.f373966d, 11, obtain, obtain2, 0) && AbstractBinderC9875a.v() != null) {
                        AbstractBinderC9875a.v().stop();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.superplayer.seamless.ipc.a
            public void switchDefinition(String str, int i3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.superplayer.seamless.ipc.IRemotePlayer");
                    obtain.writeString(str);
                    obtain.writeInt(i3);
                    if (!OaidMonitor.binderTransact(this.f373966d, 41, obtain, obtain2, 0) && AbstractBinderC9875a.v() != null) {
                        AbstractBinderC9875a.v().switchDefinition(str, i3);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.superplayer.seamless.ipc.a
            public void switchDefinitionForUrl(String str, int i3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.superplayer.seamless.ipc.IRemotePlayer");
                    obtain.writeString(str);
                    obtain.writeInt(i3);
                    if (!OaidMonitor.binderTransact(this.f373966d, 42, obtain, obtain2, 0) && AbstractBinderC9875a.v() != null) {
                        AbstractBinderC9875a.v().switchDefinitionForUrl(str, i3);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.superplayer.seamless.ipc.a
            public void t3(g gVar) throws RemoteException {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.superplayer.seamless.ipc.IRemotePlayer");
                    if (gVar != null) {
                        iBinder = gVar.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    if (!OaidMonitor.binderTransact(this.f373966d, 34, obtain, obtain2, 0) && AbstractBinderC9875a.v() != null) {
                        AbstractBinderC9875a.v().t3(gVar);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.superplayer.seamless.ipc.a
            public void t4(h hVar) throws RemoteException {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.superplayer.seamless.ipc.IRemotePlayer");
                    if (hVar != null) {
                        iBinder = hVar.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    if (!OaidMonitor.binderTransact(this.f373966d, 35, obtain, obtain2, 0) && AbstractBinderC9875a.v() != null) {
                        AbstractBinderC9875a.v().t4(hVar);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.superplayer.seamless.ipc.a
            public void v3(e eVar) throws RemoteException {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.superplayer.seamless.ipc.IRemotePlayer");
                    if (eVar != null) {
                        iBinder = eVar.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    if (!OaidMonitor.binderTransact(this.f373966d, 31, obtain, obtain2, 0) && AbstractBinderC9875a.v() != null) {
                        AbstractBinderC9875a.v().v3(eVar);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.superplayer.seamless.ipc.a
            public void w4(c cVar) throws RemoteException {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.superplayer.seamless.ipc.IRemotePlayer");
                    if (cVar != null) {
                        iBinder = cVar.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    if (!OaidMonitor.binderTransact(this.f373966d, 33, obtain, obtain2, 0) && AbstractBinderC9875a.v() != null) {
                        AbstractBinderC9875a.v().w4(cVar);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }
        }

        public static a j(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.tencent.superplayer.seamless.ipc.IRemotePlayer");
            if (queryLocalInterface != null && (queryLocalInterface instanceof a)) {
                return (a) queryLocalInterface;
            }
            return new C9876a(iBinder);
        }

        public static a v() {
            return C9876a.f373965e;
        }
    }

    void E2(f fVar) throws RemoteException;

    void Q(d dVar) throws RemoteException;

    void T1(int i3, int i16) throws RemoteException;

    void U4(boolean z16, long j3, long j16) throws RemoteException;

    void addExtReportData(String str, String str2) throws RemoteException;

    void deselectTrack(int i3, long j3) throws RemoteException;

    int getCurrentPlayerState() throws RemoteException;

    long getCurrentPositionMs() throws RemoteException;

    long getDurationMs() throws RemoteException;

    long getFileSizeBytes() throws RemoteException;

    String getStreamDumpInfo() throws RemoteException;

    String getToken() throws RemoteException;

    int getVideoHeight() throws RemoteException;

    int getVideoRotation() throws RemoteException;

    int getVideoWidth() throws RemoteException;

    void h3(Map map) throws RemoteException;

    boolean isBuffering() throws RemoteException;

    boolean isLoopBack() throws RemoteException;

    boolean isOutputMute() throws RemoteException;

    boolean isPausing() throws RemoteException;

    boolean isPlaying() throws RemoteException;

    void l1(i iVar) throws RemoteException;

    void onPrePlayViewShow() throws RemoteException;

    void pause() throws RemoteException;

    void pauseDownload() throws RemoteException;

    void release() throws RemoteException;

    void reset() throws RemoteException;

    void resumeDownload() throws RemoteException;

    void seekTo(int i3) throws RemoteException;

    void selectProgram(int i3, long j3) throws RemoteException;

    void selectTrack(int i3, long j3) throws RemoteException;

    void setBusinessDownloadStrategy(int i3, int i16, int i17, int i18) throws RemoteException;

    void setLoopback(boolean z16) throws RemoteException;

    void setOutputMute(boolean z16) throws RemoteException;

    void setPlaySpeedRatio(float f16) throws RemoteException;

    void setPlayerActive() throws RemoteException;

    void setReportContentId(String str) throws RemoteException;

    void setSurface(Surface surface) throws RemoteException;

    void start() throws RemoteException;

    void stop() throws RemoteException;

    void switchDefinition(String str, int i3) throws RemoteException;

    void switchDefinitionForUrl(String str, int i3) throws RemoteException;

    void t3(g gVar) throws RemoteException;

    void t4(h hVar) throws RemoteException;

    void v3(e eVar) throws RemoteException;

    void w4(c cVar) throws RemoteException;
}
