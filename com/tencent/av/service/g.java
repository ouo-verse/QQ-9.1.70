package com.tencent.av.service;

import android.graphics.Bitmap;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.ResultReceiver;
import com.tencent.av.service.f;
import com.tencent.av.service.h;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;

/* compiled from: P */
/* loaded from: classes3.dex */
public interface g extends IInterface {
    void A1(boolean z16) throws RemoteException;

    long[] B0(String str) throws RemoteException;

    String[] C0(String str) throws RemoteException;

    void C2(String str) throws RemoteException;

    boolean D2(int i3) throws RemoteException;

    boolean F1(String str, boolean z16) throws RemoteException;

    void G2(h hVar) throws RemoteException;

    void G4(int i3, long j3, int i16, int i17) throws RemoteException;

    boolean H1(String str, String str2) throws RemoteException;

    void J1(String str) throws RemoteException;

    boolean K0(long j3) throws RemoteException;

    boolean K2() throws RemoteException;

    long[] K4(String str) throws RemoteException;

    boolean L0(String str, int i3, int i16, byte[] bArr) throws RemoteException;

    void L1(f fVar, String str) throws RemoteException;

    void L2(long j3) throws RemoteException;

    String M(int i3, String str, String str2, int i16) throws RemoteException;

    Bundle M0(int i3, int i16, int i17, byte[] bArr, Bundle bundle, ResultReceiver resultReceiver) throws RemoteException;

    int N3() throws RemoteException;

    void O1(String str) throws RemoteException;

    boolean O3() throws RemoteException;

    boolean P0(int i3, long j3) throws RemoteException;

    void P1(String str, String str2, String str3, int i3) throws RemoteException;

    void P3(String str, String str2, String str3) throws RemoteException;

    int Q1() throws RemoteException;

    void Q3(boolean z16) throws RemoteException;

    boolean R4(String str, int i3) throws RemoteException;

    boolean S4() throws RemoteException;

    int T2() throws RemoteException;

    void U3(int i3, String str) throws RemoteException;

    boolean W3(String str, int i3) throws RemoteException;

    int W4() throws RemoteException;

    int[] X() throws RemoteException;

    String X1(String str) throws RemoteException;

    void Y0(String str) throws RemoteException;

    boolean b0(String str) throws RemoteException;

    boolean c0(String str, int i3) throws RemoteException;

    void c5(long[] jArr, String str) throws RemoteException;

    boolean d4() throws RemoteException;

    void d5(String str, int i3, int i16, byte[] bArr) throws RemoteException;

    int e0(String str) throws RemoteException;

    void e4(int i3) throws RemoteException;

    void f1() throws RemoteException;

    long f3(String str) throws RemoteException;

    void g0(f fVar) throws RemoteException;

    void g5(String str) throws RemoteException;

    String getPhoneNumByUin(String str) throws RemoteException;

    String getSKey() throws RemoteException;

    String getUinByPhoneNum(String str) throws RemoteException;

    void i2(String str) throws RemoteException;

    boolean isFriend(String str) throws RemoteException;

    String j1(String str) throws RemoteException;

    boolean k0() throws RemoteException;

    void k1(long j3, String str, long j16) throws RemoteException;

    void k4(h hVar) throws RemoteException;

    void m0(int i3, String str) throws RemoteException;

    int m3(int i3, String str) throws RemoteException;

    boolean n() throws RemoteException;

    void n1(String str, long j3) throws RemoteException;

    int n3(String str) throws RemoteException;

    void n4() throws RemoteException;

    void p2(long j3, String str, int i3) throws RemoteException;

    void p3(boolean z16) throws RemoteException;

    int q2(String str) throws RemoteException;

    long r3(String str) throws RemoteException;

    boolean s() throws RemoteException;

    boolean t2() throws RemoteException;

    void u1(int i3, String str, String str2) throws RemoteException;

    void v4() throws RemoteException;

    Bitmap x1(int i3, String str, String str2, boolean z16, boolean z17) throws RemoteException;

    String x3(int i3, String str, String str2) throws RemoteException;

    boolean x4(String str) throws RemoteException;

    void z0(boolean z16) throws RemoteException;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static abstract class a extends Binder implements g {

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: P */
        /* renamed from: com.tencent.av.service.g$a$a, reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static class C0746a implements g {

            /* renamed from: e, reason: collision with root package name */
            public static g f74376e;

            /* renamed from: d, reason: collision with root package name */
            private IBinder f74377d;

            C0746a(IBinder iBinder) {
                this.f74377d = iBinder;
            }

            @Override // com.tencent.av.service.g
            public void A1(boolean z16) throws RemoteException {
                int i3;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.av.service.IQQServiceForAV");
                    if (z16) {
                        i3 = 1;
                    } else {
                        i3 = 0;
                    }
                    obtain.writeInt(i3);
                    if (!OaidMonitor.binderTransact(this.f74377d, 69, obtain, obtain2, 0) && a.v() != null) {
                        a.v().A1(z16);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.av.service.g
            public boolean D2(int i3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.av.service.IQQServiceForAV");
                    obtain.writeInt(i3);
                    boolean z16 = false;
                    if (!OaidMonitor.binderTransact(this.f74377d, 54, obtain, obtain2, 0) && a.v() != null) {
                        return a.v().D2(i3);
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

            @Override // com.tencent.av.service.g
            public boolean H1(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.av.service.IQQServiceForAV");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    boolean z16 = false;
                    if (!OaidMonitor.binderTransact(this.f74377d, 41, obtain, obtain2, 0) && a.v() != null) {
                        return a.v().H1(str, str2);
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

            @Override // com.tencent.av.service.g
            public void J1(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.av.service.IQQServiceForAV");
                    obtain.writeString(str);
                    if (!OaidMonitor.binderTransact(this.f74377d, 61, obtain, obtain2, 0) && a.v() != null) {
                        a.v().J1(str);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.av.service.g
            public boolean K0(long j3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.av.service.IQQServiceForAV");
                    obtain.writeLong(j3);
                    boolean z16 = false;
                    if (!OaidMonitor.binderTransact(this.f74377d, 24, obtain, obtain2, 0) && a.v() != null) {
                        return a.v().K0(j3);
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

            @Override // com.tencent.av.service.g
            public boolean K2() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.av.service.IQQServiceForAV");
                    boolean z16 = false;
                    if (!OaidMonitor.binderTransact(this.f74377d, 52, obtain, obtain2, 0) && a.v() != null) {
                        return a.v().K2();
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

            @Override // com.tencent.av.service.g
            public long[] K4(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.av.service.IQQServiceForAV");
                    obtain.writeString(str);
                    if (!OaidMonitor.binderTransact(this.f74377d, 17, obtain, obtain2, 0) && a.v() != null) {
                        return a.v().K4(str);
                    }
                    obtain2.readException();
                    return obtain2.createLongArray();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.av.service.g
            public void L1(f fVar, String str) throws RemoteException {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.av.service.IQQServiceForAV");
                    if (fVar != null) {
                        iBinder = fVar.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeString(str);
                    if (!OaidMonitor.binderTransact(this.f74377d, 8, obtain, null, 1) && a.v() != null) {
                        a.v().L1(fVar, str);
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.av.service.g
            public void L2(long j3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.av.service.IQQServiceForAV");
                    obtain.writeLong(j3);
                    if (!OaidMonitor.binderTransact(this.f74377d, 18, obtain, null, 1) && a.v() != null) {
                        a.v().L2(j3);
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.av.service.g
            public String M(int i3, String str, String str2, int i16) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.av.service.IQQServiceForAV");
                    obtain.writeInt(i3);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeInt(i16);
                    if (!OaidMonitor.binderTransact(this.f74377d, 5, obtain, obtain2, 0) && a.v() != null) {
                        return a.v().M(i3, str, str2, i16);
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.av.service.g
            public Bundle M0(int i3, int i16, int i17, byte[] bArr, Bundle bundle, ResultReceiver resultReceiver) throws RemoteException {
                Bundle bundle2;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.av.service.IQQServiceForAV");
                    obtain.writeInt(i3);
                    obtain.writeInt(i16);
                    obtain.writeInt(i17);
                    obtain.writeByteArray(bArr);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (resultReceiver != null) {
                        obtain.writeInt(1);
                        resultReceiver.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                } catch (Throwable th5) {
                    th = th5;
                }
                try {
                    if (!OaidMonitor.binderTransact(this.f74377d, 67, obtain, obtain2, 0) && a.v() != null) {
                        Bundle M0 = a.v().M0(i3, i16, i17, bArr, bundle, resultReceiver);
                        OaidMonitor.parcelRecycle(obtain2);
                        OaidMonitor.parcelRecycle(obtain);
                        return M0;
                    }
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        bundle2 = (Bundle) Bundle.CREATOR.createFromParcel(obtain2);
                    } else {
                        bundle2 = null;
                    }
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                    return bundle2;
                } catch (Throwable th6) {
                    th = th6;
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                    throw th;
                }
            }

            @Override // com.tencent.av.service.g
            public boolean O3() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.av.service.IQQServiceForAV");
                    boolean z16 = false;
                    if (!OaidMonitor.binderTransact(this.f74377d, 16, obtain, obtain2, 0) && a.v() != null) {
                        return a.v().O3();
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

            @Override // com.tencent.av.service.g
            public boolean P0(int i3, long j3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.av.service.IQQServiceForAV");
                    obtain.writeInt(i3);
                    obtain.writeLong(j3);
                    boolean z16 = false;
                    if (!OaidMonitor.binderTransact(this.f74377d, 12, obtain, obtain2, 0) && a.v() != null) {
                        return a.v().P0(i3, j3);
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

            @Override // com.tencent.av.service.g
            public boolean S4() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.av.service.IQQServiceForAV");
                    boolean z16 = false;
                    if (!OaidMonitor.binderTransact(this.f74377d, 46, obtain, obtain2, 0) && a.v() != null) {
                        return a.v().S4();
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

            @Override // com.tencent.av.service.g
            public void U3(int i3, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.av.service.IQQServiceForAV");
                    obtain.writeInt(i3);
                    obtain.writeString(str);
                    if (!OaidMonitor.binderTransact(this.f74377d, 6, obtain, null, 1) && a.v() != null) {
                        a.v().U3(i3, str);
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.av.service.g
            public String X1(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.av.service.IQQServiceForAV");
                    obtain.writeString(str);
                    if (!OaidMonitor.binderTransact(this.f74377d, 4, obtain, obtain2, 0) && a.v() != null) {
                        return a.v().X1(str);
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f74377d;
            }

            @Override // com.tencent.av.service.g
            public boolean d4() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.av.service.IQQServiceForAV");
                    boolean z16 = false;
                    if (!OaidMonitor.binderTransact(this.f74377d, 53, obtain, obtain2, 0) && a.v() != null) {
                        return a.v().d4();
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

            @Override // com.tencent.av.service.g
            public void g0(f fVar) throws RemoteException {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.av.service.IQQServiceForAV");
                    if (fVar != null) {
                        iBinder = fVar.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    if (!OaidMonitor.binderTransact(this.f74377d, 9, obtain, null, 1) && a.v() != null) {
                        a.v().g0(fVar);
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.av.service.g
            public void g5(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.av.service.IQQServiceForAV");
                    obtain.writeString(str);
                    if (!OaidMonitor.binderTransact(this.f74377d, 60, obtain, obtain2, 0) && a.v() != null) {
                        a.v().g5(str);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.av.service.g
            public String getPhoneNumByUin(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.av.service.IQQServiceForAV");
                    obtain.writeString(str);
                    if (!OaidMonitor.binderTransact(this.f74377d, 48, obtain, obtain2, 0) && a.v() != null) {
                        return a.v().getPhoneNumByUin(str);
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.av.service.g
            public boolean isFriend(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.av.service.IQQServiceForAV");
                    obtain.writeString(str);
                    boolean z16 = false;
                    if (!OaidMonitor.binderTransact(this.f74377d, 1, obtain, obtain2, 0) && a.v() != null) {
                        return a.v().isFriend(str);
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

            @Override // com.tencent.av.service.g
            public boolean k0() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.av.service.IQQServiceForAV");
                    boolean z16 = false;
                    if (!OaidMonitor.binderTransact(this.f74377d, 73, obtain, obtain2, 0) && a.v() != null) {
                        return a.v().k0();
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

            @Override // com.tencent.av.service.g
            public void k1(long j3, String str, long j16) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.av.service.IQQServiceForAV");
                    obtain.writeLong(j3);
                    obtain.writeString(str);
                    obtain.writeLong(j16);
                    if (!OaidMonitor.binderTransact(this.f74377d, 65, obtain, obtain2, 0) && a.v() != null) {
                        a.v().k1(j3, str, j16);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.av.service.g
            public void m0(int i3, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.av.service.IQQServiceForAV");
                    obtain.writeInt(i3);
                    obtain.writeString(str);
                    if (!OaidMonitor.binderTransact(this.f74377d, 11, obtain, null, 1) && a.v() != null) {
                        a.v().m0(i3, str);
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.av.service.g
            public int m3(int i3, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.av.service.IQQServiceForAV");
                    obtain.writeInt(i3);
                    obtain.writeString(str);
                    if (!OaidMonitor.binderTransact(this.f74377d, 13, obtain, obtain2, 0) && a.v() != null) {
                        return a.v().m3(i3, str);
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.av.service.g
            public boolean n() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.av.service.IQQServiceForAV");
                    boolean z16 = false;
                    if (!OaidMonitor.binderTransact(this.f74377d, 70, obtain, obtain2, 0) && a.v() != null) {
                        return a.v().n();
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

            @Override // com.tencent.av.service.g
            public int n3(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.av.service.IQQServiceForAV");
                    obtain.writeString(str);
                    if (!OaidMonitor.binderTransact(this.f74377d, 66, obtain, obtain2, 0) && a.v() != null) {
                        return a.v().n3(str);
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.av.service.g
            public void n4() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.av.service.IQQServiceForAV");
                    if (!OaidMonitor.binderTransact(this.f74377d, 7, obtain, null, 1) && a.v() != null) {
                        a.v().n4();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.av.service.g
            public long r3(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.av.service.IQQServiceForAV");
                    obtain.writeString(str);
                    if (!OaidMonitor.binderTransact(this.f74377d, 14, obtain, obtain2, 0) && a.v() != null) {
                        return a.v().r3(str);
                    }
                    obtain2.readException();
                    return obtain2.readLong();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.av.service.g
            public boolean s() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.av.service.IQQServiceForAV");
                    boolean z16 = false;
                    if (!OaidMonitor.binderTransact(this.f74377d, 71, obtain, obtain2, 0) && a.v() != null) {
                        return a.v().s();
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

            @Override // com.tencent.av.service.g
            public void u1(int i3, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.av.service.IQQServiceForAV");
                    obtain.writeInt(i3);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (!OaidMonitor.binderTransact(this.f74377d, 10, obtain, null, 1) && a.v() != null) {
                        a.v().u1(i3, str, str2);
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.av.service.g
            public void v4() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.av.service.IQQServiceForAV");
                    if (!OaidMonitor.binderTransact(this.f74377d, 35, obtain, null, 1) && a.v() != null) {
                        a.v().v4();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.av.service.g
            public Bitmap x1(int i3, String str, String str2, boolean z16, boolean z17) throws RemoteException {
                int i16;
                Bitmap bitmap;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.av.service.IQQServiceForAV");
                    obtain.writeInt(i3);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    int i17 = 1;
                    if (z16) {
                        i16 = 1;
                    } else {
                        i16 = 0;
                    }
                    obtain.writeInt(i16);
                    if (!z17) {
                        i17 = 0;
                    }
                    obtain.writeInt(i17);
                    if (!OaidMonitor.binderTransact(this.f74377d, 2, obtain, obtain2, 0) && a.v() != null) {
                        return a.v().x1(i3, str, str2, z16, z17);
                    }
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        bitmap = (Bitmap) Bitmap.CREATOR.createFromParcel(obtain2);
                    } else {
                        bitmap = null;
                    }
                    return bitmap;
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.av.service.g
            public String x3(int i3, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.av.service.IQQServiceForAV");
                    obtain.writeInt(i3);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (!OaidMonitor.binderTransact(this.f74377d, 3, obtain, obtain2, 0) && a.v() != null) {
                        return a.v().x3(i3, str, str2);
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }
        }

        public a() {
            attachInterface(this, "com.tencent.av.service.IQQServiceForAV");
        }

        public static g j(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.tencent.av.service.IQQServiceForAV");
            if (queryLocalInterface != null && (queryLocalInterface instanceof g)) {
                return (g) queryLocalInterface;
            }
            return new C0746a(iBinder);
        }

        public static g v() {
            return C0746a.f74376e;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i3, Parcel parcel, Parcel parcel2, int i16) throws RemoteException {
            boolean z16;
            boolean z17;
            Bundle bundle;
            ResultReceiver resultReceiver;
            if (i3 != 1598968902) {
                boolean z18 = false;
                switch (i3) {
                    case 1:
                        parcel.enforceInterface("com.tencent.av.service.IQQServiceForAV");
                        boolean isFriend = isFriend(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeInt(isFriend ? 1 : 0);
                        return true;
                    case 2:
                        parcel.enforceInterface("com.tencent.av.service.IQQServiceForAV");
                        int readInt = parcel.readInt();
                        String readString = parcel.readString();
                        String readString2 = parcel.readString();
                        if (parcel.readInt() != 0) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        if (parcel.readInt() != 0) {
                            z17 = true;
                        } else {
                            z17 = false;
                        }
                        Bitmap x16 = x1(readInt, readString, readString2, z16, z17);
                        parcel2.writeNoException();
                        if (x16 != null) {
                            parcel2.writeInt(1);
                            x16.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 3:
                        parcel.enforceInterface("com.tencent.av.service.IQQServiceForAV");
                        String x36 = x3(parcel.readInt(), parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeString(x36);
                        return true;
                    case 4:
                        parcel.enforceInterface("com.tencent.av.service.IQQServiceForAV");
                        String X1 = X1(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeString(X1);
                        return true;
                    case 5:
                        parcel.enforceInterface("com.tencent.av.service.IQQServiceForAV");
                        String M = M(parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeString(M);
                        return true;
                    case 6:
                        parcel.enforceInterface("com.tencent.av.service.IQQServiceForAV");
                        U3(parcel.readInt(), parcel.readString());
                        return true;
                    case 7:
                        parcel.enforceInterface("com.tencent.av.service.IQQServiceForAV");
                        n4();
                        return true;
                    case 8:
                        parcel.enforceInterface("com.tencent.av.service.IQQServiceForAV");
                        L1(f.a.j(parcel.readStrongBinder()), parcel.readString());
                        return true;
                    case 9:
                        parcel.enforceInterface("com.tencent.av.service.IQQServiceForAV");
                        g0(f.a.j(parcel.readStrongBinder()));
                        return true;
                    case 10:
                        parcel.enforceInterface("com.tencent.av.service.IQQServiceForAV");
                        u1(parcel.readInt(), parcel.readString(), parcel.readString());
                        return true;
                    case 11:
                        parcel.enforceInterface("com.tencent.av.service.IQQServiceForAV");
                        m0(parcel.readInt(), parcel.readString());
                        return true;
                    case 12:
                        parcel.enforceInterface("com.tencent.av.service.IQQServiceForAV");
                        boolean P0 = P0(parcel.readInt(), parcel.readLong());
                        parcel2.writeNoException();
                        parcel2.writeInt(P0 ? 1 : 0);
                        return true;
                    case 13:
                        parcel.enforceInterface("com.tencent.av.service.IQQServiceForAV");
                        int m3 = m3(parcel.readInt(), parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeInt(m3);
                        return true;
                    case 14:
                        parcel.enforceInterface("com.tencent.av.service.IQQServiceForAV");
                        long r36 = r3(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeLong(r36);
                        return true;
                    case 15:
                        parcel.enforceInterface("com.tencent.av.service.IQQServiceForAV");
                        boolean R4 = R4(parcel.readString(), parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeInt(R4 ? 1 : 0);
                        return true;
                    case 16:
                        parcel.enforceInterface("com.tencent.av.service.IQQServiceForAV");
                        boolean O3 = O3();
                        parcel2.writeNoException();
                        parcel2.writeInt(O3 ? 1 : 0);
                        return true;
                    case 17:
                        parcel.enforceInterface("com.tencent.av.service.IQQServiceForAV");
                        long[] K4 = K4(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeLongArray(K4);
                        return true;
                    case 18:
                        parcel.enforceInterface("com.tencent.av.service.IQQServiceForAV");
                        L2(parcel.readLong());
                        return true;
                    case 19:
                        parcel.enforceInterface("com.tencent.av.service.IQQServiceForAV");
                        boolean x46 = x4(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeInt(x46 ? 1 : 0);
                        return true;
                    case 20:
                        parcel.enforceInterface("com.tencent.av.service.IQQServiceForAV");
                        int q26 = q2(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeInt(q26);
                        return true;
                    case 21:
                        parcel.enforceInterface("com.tencent.av.service.IQQServiceForAV");
                        int Q1 = Q1();
                        parcel2.writeNoException();
                        parcel2.writeInt(Q1);
                        return true;
                    case 22:
                        parcel.enforceInterface("com.tencent.av.service.IQQServiceForAV");
                        long f36 = f3(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeLong(f36);
                        return true;
                    case 23:
                        parcel.enforceInterface("com.tencent.av.service.IQQServiceForAV");
                        boolean L0 = L0(parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.createByteArray());
                        parcel2.writeNoException();
                        parcel2.writeInt(L0 ? 1 : 0);
                        return true;
                    case 24:
                        parcel.enforceInterface("com.tencent.av.service.IQQServiceForAV");
                        boolean K0 = K0(parcel.readLong());
                        parcel2.writeNoException();
                        parcel2.writeInt(K0 ? 1 : 0);
                        return true;
                    case 25:
                        parcel.enforceInterface("com.tencent.av.service.IQQServiceForAV");
                        boolean c06 = c0(parcel.readString(), parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeInt(c06 ? 1 : 0);
                        return true;
                    case 26:
                        parcel.enforceInterface("com.tencent.av.service.IQQServiceForAV");
                        String readString3 = parcel.readString();
                        if (parcel.readInt() != 0) {
                            z18 = true;
                        }
                        boolean F1 = F1(readString3, z18);
                        parcel2.writeNoException();
                        parcel2.writeInt(F1 ? 1 : 0);
                        return true;
                    case 27:
                        parcel.enforceInterface("com.tencent.av.service.IQQServiceForAV");
                        G2(h.a.j(parcel.readStrongBinder()));
                        return true;
                    case 28:
                        parcel.enforceInterface("com.tencent.av.service.IQQServiceForAV");
                        k4(h.a.j(parcel.readStrongBinder()));
                        return true;
                    case 29:
                        parcel.enforceInterface("com.tencent.av.service.IQQServiceForAV");
                        String sKey = getSKey();
                        parcel2.writeNoException();
                        parcel2.writeString(sKey);
                        return true;
                    case 30:
                        parcel.enforceInterface("com.tencent.av.service.IQQServiceForAV");
                        e4(parcel.readInt());
                        return true;
                    case 31:
                        parcel.enforceInterface("com.tencent.av.service.IQQServiceForAV");
                        i2(parcel.readString());
                        return true;
                    case 32:
                        parcel.enforceInterface("com.tencent.av.service.IQQServiceForAV");
                        boolean W3 = W3(parcel.readString(), parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeInt(W3 ? 1 : 0);
                        return true;
                    case 33:
                        parcel.enforceInterface("com.tencent.av.service.IQQServiceForAV");
                        O1(parcel.readString());
                        return true;
                    case 34:
                        parcel.enforceInterface("com.tencent.av.service.IQQServiceForAV");
                        C2(parcel.readString());
                        return true;
                    case 35:
                        parcel.enforceInterface("com.tencent.av.service.IQQServiceForAV");
                        v4();
                        return true;
                    case 36:
                        parcel.enforceInterface("com.tencent.av.service.IQQServiceForAV");
                        f1();
                        return true;
                    case 37:
                        parcel.enforceInterface("com.tencent.av.service.IQQServiceForAV");
                        int e06 = e0(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeInt(e06);
                        return true;
                    case 38:
                        parcel.enforceInterface("com.tencent.av.service.IQQServiceForAV");
                        P3(parcel.readString(), parcel.readString(), parcel.readString());
                        return true;
                    case 39:
                        parcel.enforceInterface("com.tencent.av.service.IQQServiceForAV");
                        c5(parcel.createLongArray(), parcel.readString());
                        return true;
                    case 40:
                        parcel.enforceInterface("com.tencent.av.service.IQQServiceForAV");
                        p2(parcel.readLong(), parcel.readString(), parcel.readInt());
                        return true;
                    case 41:
                        parcel.enforceInterface("com.tencent.av.service.IQQServiceForAV");
                        boolean H1 = H1(parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeInt(H1 ? 1 : 0);
                        return true;
                    case 42:
                        parcel.enforceInterface("com.tencent.av.service.IQQServiceForAV");
                        long[] B0 = B0(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeLongArray(B0);
                        return true;
                    case 43:
                        parcel.enforceInterface("com.tencent.av.service.IQQServiceForAV");
                        String[] C0 = C0(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeStringArray(C0);
                        return true;
                    case 44:
                        parcel.enforceInterface("com.tencent.av.service.IQQServiceForAV");
                        String j16 = j1(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeString(j16);
                        return true;
                    case 45:
                        parcel.enforceInterface("com.tencent.av.service.IQQServiceForAV");
                        if (parcel.readInt() != 0) {
                            z18 = true;
                        }
                        Q3(z18);
                        return true;
                    case 46:
                        parcel.enforceInterface("com.tencent.av.service.IQQServiceForAV");
                        boolean S4 = S4();
                        parcel2.writeNoException();
                        parcel2.writeInt(S4 ? 1 : 0);
                        return true;
                    case 47:
                        parcel.enforceInterface("com.tencent.av.service.IQQServiceForAV");
                        String uinByPhoneNum = getUinByPhoneNum(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeString(uinByPhoneNum);
                        return true;
                    case 48:
                        parcel.enforceInterface("com.tencent.av.service.IQQServiceForAV");
                        String phoneNumByUin = getPhoneNumByUin(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeString(phoneNumByUin);
                        return true;
                    case 49:
                        parcel.enforceInterface("com.tencent.av.service.IQQServiceForAV");
                        int W4 = W4();
                        parcel2.writeNoException();
                        parcel2.writeInt(W4);
                        return true;
                    case 50:
                        parcel.enforceInterface("com.tencent.av.service.IQQServiceForAV");
                        int N3 = N3();
                        parcel2.writeNoException();
                        parcel2.writeInt(N3);
                        return true;
                    case 51:
                        parcel.enforceInterface("com.tencent.av.service.IQQServiceForAV");
                        int[] X = X();
                        parcel2.writeNoException();
                        parcel2.writeIntArray(X);
                        return true;
                    case 52:
                        parcel.enforceInterface("com.tencent.av.service.IQQServiceForAV");
                        boolean K2 = K2();
                        parcel2.writeNoException();
                        parcel2.writeInt(K2 ? 1 : 0);
                        return true;
                    case 53:
                        parcel.enforceInterface("com.tencent.av.service.IQQServiceForAV");
                        boolean d46 = d4();
                        parcel2.writeNoException();
                        parcel2.writeInt(d46 ? 1 : 0);
                        return true;
                    case 54:
                        parcel.enforceInterface("com.tencent.av.service.IQQServiceForAV");
                        boolean D2 = D2(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeInt(D2 ? 1 : 0);
                        return true;
                    case 55:
                        parcel.enforceInterface("com.tencent.av.service.IQQServiceForAV");
                        int T2 = T2();
                        parcel2.writeNoException();
                        parcel2.writeInt(T2);
                        return true;
                    case 56:
                        parcel.enforceInterface("com.tencent.av.service.IQQServiceForAV");
                        if (parcel.readInt() != 0) {
                            z18 = true;
                        }
                        z0(z18);
                        return true;
                    case 57:
                        parcel.enforceInterface("com.tencent.av.service.IQQServiceForAV");
                        n1(parcel.readString(), parcel.readLong());
                        return true;
                    case 58:
                        parcel.enforceInterface("com.tencent.av.service.IQQServiceForAV");
                        if (parcel.readInt() != 0) {
                            z18 = true;
                        }
                        p3(z18);
                        return true;
                    case 59:
                        parcel.enforceInterface("com.tencent.av.service.IQQServiceForAV");
                        boolean b06 = b0(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeInt(b06 ? 1 : 0);
                        return true;
                    case 60:
                        parcel.enforceInterface("com.tencent.av.service.IQQServiceForAV");
                        g5(parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 61:
                        parcel.enforceInterface("com.tencent.av.service.IQQServiceForAV");
                        J1(parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 62:
                        parcel.enforceInterface("com.tencent.av.service.IQQServiceForAV");
                        G4(parcel.readInt(), parcel.readLong(), parcel.readInt(), parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 63:
                        parcel.enforceInterface("com.tencent.av.service.IQQServiceForAV");
                        d5(parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.createByteArray());
                        parcel2.writeNoException();
                        return true;
                    case 64:
                        parcel.enforceInterface("com.tencent.av.service.IQQServiceForAV");
                        P1(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 65:
                        parcel.enforceInterface("com.tencent.av.service.IQQServiceForAV");
                        k1(parcel.readLong(), parcel.readString(), parcel.readLong());
                        parcel2.writeNoException();
                        return true;
                    case 66:
                        parcel.enforceInterface("com.tencent.av.service.IQQServiceForAV");
                        int n3 = n3(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeInt(n3);
                        return true;
                    case 67:
                        parcel.enforceInterface("com.tencent.av.service.IQQServiceForAV");
                        int readInt2 = parcel.readInt();
                        int readInt3 = parcel.readInt();
                        int readInt4 = parcel.readInt();
                        byte[] createByteArray = parcel.createByteArray();
                        if (parcel.readInt() != 0) {
                            bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                        } else {
                            bundle = null;
                        }
                        if (parcel.readInt() != 0) {
                            resultReceiver = (ResultReceiver) ResultReceiver.CREATOR.createFromParcel(parcel);
                        } else {
                            resultReceiver = null;
                        }
                        Bundle M0 = M0(readInt2, readInt3, readInt4, createByteArray, bundle, resultReceiver);
                        parcel2.writeNoException();
                        if (M0 != null) {
                            parcel2.writeInt(1);
                            M0.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 68:
                        parcel.enforceInterface("com.tencent.av.service.IQQServiceForAV");
                        Y0(parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 69:
                        parcel.enforceInterface("com.tencent.av.service.IQQServiceForAV");
                        if (parcel.readInt() != 0) {
                            z18 = true;
                        }
                        A1(z18);
                        parcel2.writeNoException();
                        return true;
                    case 70:
                        parcel.enforceInterface("com.tencent.av.service.IQQServiceForAV");
                        boolean n16 = n();
                        parcel2.writeNoException();
                        parcel2.writeInt(n16 ? 1 : 0);
                        return true;
                    case 71:
                        parcel.enforceInterface("com.tencent.av.service.IQQServiceForAV");
                        boolean s16 = s();
                        parcel2.writeNoException();
                        parcel2.writeInt(s16 ? 1 : 0);
                        return true;
                    case 72:
                        parcel.enforceInterface("com.tencent.av.service.IQQServiceForAV");
                        boolean t26 = t2();
                        parcel2.writeNoException();
                        parcel2.writeInt(t26 ? 1 : 0);
                        return true;
                    case 73:
                        parcel.enforceInterface("com.tencent.av.service.IQQServiceForAV");
                        boolean k06 = k0();
                        parcel2.writeNoException();
                        parcel2.writeInt(k06 ? 1 : 0);
                        return true;
                    default:
                        return super.onTransact(i3, parcel, parcel2, i16);
                }
            }
            parcel2.writeString("com.tencent.av.service.IQQServiceForAV");
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }
}
