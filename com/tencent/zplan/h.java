package com.tencent.zplan;

import android.content.res.Configuration;
import android.hardware.HardwareBuffer;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.os.RemoteException;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.Surface;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;
import com.tencent.zplan.IZPlanEngineStatusCallback;
import com.tencent.zplan.IZPlanEnterSceneCallback;
import com.tencent.zplan.IZPlanRecordCallback;
import com.tencent.zplan.IZPlanWorldCallback;
import com.tencent.zplan.b;
import com.tencent.zplan.c;
import com.tencent.zplan.d;
import com.tencent.zplan.e;
import com.tencent.zplan.engine.service.ReporterEventRecordTime;
import com.tencent.zplan.meme.model.MemeRecordParams;
import java.util.List;

/* compiled from: P */
/* loaded from: classes27.dex */
public interface h extends IInterface {
    void A3() throws RemoteException;

    void B4(String str) throws RemoteException;

    HardwareBuffer E0(int i3, int i16) throws RemoteException;

    long F3() throws RemoteException;

    void G1(Surface surface) throws RemoteException;

    void G3(int i3, String str, IZPlanEnterSceneCallback iZPlanEnterSceneCallback) throws RemoteException;

    void H() throws RemoteException;

    boolean H2() throws RemoteException;

    void H3() throws RemoteException;

    void I(String str, String str2, boolean z16) throws RemoteException;

    void I0(Surface surface) throws RemoteException;

    void I2() throws RemoteException;

    void J3() throws RemoteException;

    boolean L3() throws RemoteException;

    void O0(long j3) throws RemoteException;

    void O4(long j3, Surface surface, int i3, int i16) throws RemoteException;

    void P2() throws RemoteException;

    void R0(long j3, Surface surface, int i3, int i16) throws RemoteException;

    void R1(String str) throws RemoteException;

    void T(int i3, KeyEvent keyEvent) throws RemoteException;

    void V0(Surface surface, d dVar) throws RemoteException;

    void V1(boolean z16) throws RemoteException;

    int W0() throws RemoteException;

    void Y3(int i3, int i16, int i17, Surface surface) throws RemoteException;

    void Y4(int i3, int i16) throws RemoteException;

    void Z1(Surface surface) throws RemoteException;

    boolean Z4() throws RemoteException;

    void a0(String str) throws RemoteException;

    void a4(boolean z16, int i3, int i16) throws RemoteException;

    void c3(IZPlanEngineStatusCallback iZPlanEngineStatusCallback) throws RemoteException;

    void d1(String str, c cVar) throws RemoteException;

    boolean e1() throws RemoteException;

    void f0(String str, boolean z16) throws RemoteException;

    void g1(String str, int i3, String str2, boolean z16, boolean z17) throws RemoteException;

    void g3(String str, boolean z16) throws RemoteException;

    void h0(String str) throws RemoteException;

    void l3(int i3, int i16, int i17, int i18, IZPlanWorldCallback iZPlanWorldCallback) throws RemoteException;

    void l4(int i3, int i16, String str, IZPlanEnterSceneCallback iZPlanEnterSceneCallback) throws RemoteException;

    void m4(int i3) throws RemoteException;

    void n2(long j3, int i3) throws RemoteException;

    void notifyAppearanceKeyChange(String str) throws RemoteException;

    void o3(int i3) throws RemoteException;

    void o4(int i3, int i16, boolean z16) throws RemoteException;

    void onAppBackground() throws RemoteException;

    void onAppForeground() throws RemoteException;

    void onConfigurationChanged(Configuration configuration) throws RemoteException;

    void onTouchEvent(MotionEvent motionEvent) throws RemoteException;

    void pauseEngine() throws RemoteException;

    void q1() throws RemoteException;

    void r0(HardwareBuffer hardwareBuffer, int i3) throws RemoteException;

    void r2(int i3, int i16, int i17) throws RemoteException;

    List<ReporterEventRecordTime> s0(String str) throws RemoteException;

    void s2(int i3, String str, String str2) throws RemoteException;

    void s4(String str, String str2, b bVar, boolean z16) throws RemoteException;

    void setSurface(Surface surface) throws RemoteException;

    void u2(Surface surface) throws RemoteException;

    void v1(MemeRecordParams memeRecordParams, IZPlanRecordCallback iZPlanRecordCallback) throws RemoteException;

    ParcelFileDescriptor v2() throws RemoteException;

    boolean w0() throws RemoteException;

    void w1(int i3, String str) throws RemoteException;

    void x0(Surface surface) throws RemoteException;

    void y1(long j3) throws RemoteException;

    void y3(int i3) throws RemoteException;

    int y4() throws RemoteException;

    void z(String str, Bundle bundle, e eVar) throws RemoteException;

    void z3(int i3, Surface surface) throws RemoteException;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static abstract class a extends Binder implements h {

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: P */
        /* renamed from: com.tencent.zplan.h$a$a, reason: collision with other inner class name */
        /* loaded from: classes27.dex */
        public static class C10062a implements h {

            /* renamed from: e, reason: collision with root package name */
            public static h f385643e;

            /* renamed from: d, reason: collision with root package name */
            private IBinder f385644d;

            C10062a(IBinder iBinder) {
                this.f385644d = iBinder;
            }

            @Override // com.tencent.zplan.h
            public void B4(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.zplan.IZPlanServiceInterface");
                    obtain.writeString(str);
                    if (!OaidMonitor.binderTransact(this.f385644d, 53, obtain, obtain2, 0) && a.v() != null) {
                        a.v().B4(str);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.zplan.h
            public void G1(Surface surface) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.zplan.IZPlanServiceInterface");
                    if (surface != null) {
                        obtain.writeInt(1);
                        surface.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!OaidMonitor.binderTransact(this.f385644d, 7, obtain, null, 1) && a.v() != null) {
                        a.v().G1(surface);
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.zplan.h
            public void G3(int i3, String str, IZPlanEnterSceneCallback iZPlanEnterSceneCallback) throws RemoteException {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.zplan.IZPlanServiceInterface");
                    obtain.writeInt(i3);
                    obtain.writeString(str);
                    if (iZPlanEnterSceneCallback != null) {
                        iBinder = iZPlanEnterSceneCallback.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    if (!OaidMonitor.binderTransact(this.f385644d, 27, obtain, obtain2, 0) && a.v() != null) {
                        a.v().G3(i3, str, iZPlanEnterSceneCallback);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.zplan.h
            public void H() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.zplan.IZPlanServiceInterface");
                    if (!OaidMonitor.binderTransact(this.f385644d, 65, obtain, obtain2, 0) && a.v() != null) {
                        a.v().H();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.zplan.h
            public boolean H2() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.zplan.IZPlanServiceInterface");
                    boolean z16 = false;
                    if (!OaidMonitor.binderTransact(this.f385644d, 47, obtain, obtain2, 0) && a.v() != null) {
                        return a.v().H2();
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

            @Override // com.tencent.zplan.h
            public void I2() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.zplan.IZPlanServiceInterface");
                    if (!OaidMonitor.binderTransact(this.f385644d, 34, obtain, obtain2, 0) && a.v() != null) {
                        a.v().I2();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.zplan.h
            public void O4(long j3, Surface surface, int i3, int i16) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.zplan.IZPlanServiceInterface");
                    obtain.writeLong(j3);
                    if (surface != null) {
                        obtain.writeInt(1);
                        surface.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(i3);
                    obtain.writeInt(i16);
                    if (!OaidMonitor.binderTransact(this.f385644d, 23, obtain, obtain2, 0) && a.v() != null) {
                        a.v().O4(j3, surface, i3, i16);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.zplan.h
            public void R0(long j3, Surface surface, int i3, int i16) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.zplan.IZPlanServiceInterface");
                    obtain.writeLong(j3);
                    if (surface != null) {
                        obtain.writeInt(1);
                        surface.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(i3);
                    obtain.writeInt(i16);
                    if (!OaidMonitor.binderTransact(this.f385644d, 24, obtain, obtain2, 0) && a.v() != null) {
                        a.v().R0(j3, surface, i3, i16);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.zplan.h
            public void T(int i3, KeyEvent keyEvent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.zplan.IZPlanServiceInterface");
                    obtain.writeInt(i3);
                    if (keyEvent != null) {
                        obtain.writeInt(1);
                        keyEvent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!OaidMonitor.binderTransact(this.f385644d, 13, obtain, obtain2, 0) && a.v() != null) {
                        a.v().T(i3, keyEvent);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.zplan.h
            public void V0(Surface surface, d dVar) throws RemoteException {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.zplan.IZPlanServiceInterface");
                    if (surface != null) {
                        obtain.writeInt(1);
                        surface.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (dVar != null) {
                        iBinder = dVar.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    if (!OaidMonitor.binderTransact(this.f385644d, 3, obtain, null, 1) && a.v() != null) {
                        a.v().V0(surface, dVar);
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.zplan.h
            public void V1(boolean z16) throws RemoteException {
                int i3;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.zplan.IZPlanServiceInterface");
                    if (z16) {
                        i3 = 1;
                    } else {
                        i3 = 0;
                    }
                    obtain.writeInt(i3);
                    if (!OaidMonitor.binderTransact(this.f385644d, 43, obtain, obtain2, 0) && a.v() != null) {
                        a.v().V1(z16);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.zplan.h
            public int W0() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.zplan.IZPlanServiceInterface");
                    if (!OaidMonitor.binderTransact(this.f385644d, 49, obtain, obtain2, 0) && a.v() != null) {
                        return a.v().W0();
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.zplan.h
            public void Y3(int i3, int i16, int i17, Surface surface) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.zplan.IZPlanServiceInterface");
                    obtain.writeInt(i3);
                    obtain.writeInt(i16);
                    obtain.writeInt(i17);
                    if (surface != null) {
                        obtain.writeInt(1);
                        surface.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!OaidMonitor.binderTransact(this.f385644d, 33, obtain, null, 1) && a.v() != null) {
                        a.v().Y3(i3, i16, i17, surface);
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.zplan.h
            public void Y4(int i3, int i16) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.zplan.IZPlanServiceInterface");
                    obtain.writeInt(i3);
                    obtain.writeInt(i16);
                    if (!OaidMonitor.binderTransact(this.f385644d, 38, obtain, null, 1) && a.v() != null) {
                        a.v().Y4(i3, i16);
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.zplan.h
            public void Z1(Surface surface) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.zplan.IZPlanServiceInterface");
                    if (surface != null) {
                        obtain.writeInt(1);
                        surface.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!OaidMonitor.binderTransact(this.f385644d, 8, obtain, null, 1) && a.v() != null) {
                        a.v().Z1(surface);
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.zplan.h
            public boolean Z4() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.zplan.IZPlanServiceInterface");
                    boolean z16 = false;
                    if (!OaidMonitor.binderTransact(this.f385644d, 40, obtain, obtain2, 0) && a.v() != null) {
                        return a.v().Z4();
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

            @Override // com.tencent.zplan.h
            public void a4(boolean z16, int i3, int i16) throws RemoteException {
                int i17;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.zplan.IZPlanServiceInterface");
                    if (z16) {
                        i17 = 1;
                    } else {
                        i17 = 0;
                    }
                    obtain.writeInt(i17);
                    obtain.writeInt(i3);
                    obtain.writeInt(i16);
                    if (!OaidMonitor.binderTransact(this.f385644d, 44, obtain, obtain2, 0) && a.v() != null) {
                        a.v().a4(z16, i3, i16);
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
                return this.f385644d;
            }

            @Override // com.tencent.zplan.h
            public void c3(IZPlanEngineStatusCallback iZPlanEngineStatusCallback) throws RemoteException {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.zplan.IZPlanServiceInterface");
                    if (iZPlanEngineStatusCallback != null) {
                        iBinder = iZPlanEngineStatusCallback.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    if (!OaidMonitor.binderTransact(this.f385644d, 5, obtain, obtain2, 0) && a.v() != null) {
                        a.v().c3(iZPlanEngineStatusCallback);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.zplan.h
            public void d1(String str, c cVar) throws RemoteException {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.zplan.IZPlanServiceInterface");
                    obtain.writeString(str);
                    if (cVar != null) {
                        iBinder = cVar.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    if (!OaidMonitor.binderTransact(this.f385644d, 20, obtain, obtain2, 0) && a.v() != null) {
                        a.v().d1(str, cVar);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.zplan.h
            public boolean e1() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.zplan.IZPlanServiceInterface");
                    boolean z16 = false;
                    if (!OaidMonitor.binderTransact(this.f385644d, 41, obtain, obtain2, 0) && a.v() != null) {
                        return a.v().e1();
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

            @Override // com.tencent.zplan.h
            public void g1(String str, int i3, String str2, boolean z16, boolean z17) throws RemoteException {
                int i16;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.zplan.IZPlanServiceInterface");
                    obtain.writeString(str);
                    obtain.writeInt(i3);
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
                    if (!OaidMonitor.binderTransact(this.f385644d, 51, obtain, obtain2, 0) && a.v() != null) {
                        a.v().g1(str, i3, str2, z16, z17);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.zplan.h
            public void g3(String str, boolean z16) throws RemoteException {
                int i3;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.zplan.IZPlanServiceInterface");
                    obtain.writeString(str);
                    if (z16) {
                        i3 = 1;
                    } else {
                        i3 = 0;
                    }
                    obtain.writeInt(i3);
                    if (!OaidMonitor.binderTransact(this.f385644d, 48, obtain, obtain2, 0) && a.v() != null) {
                        a.v().g3(str, z16);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.zplan.h
            public void h0(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.zplan.IZPlanServiceInterface");
                    obtain.writeString(str);
                    if (!OaidMonitor.binderTransact(this.f385644d, 16, obtain, null, 1) && a.v() != null) {
                        a.v().h0(str);
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.zplan.h
            public void l3(int i3, int i16, int i17, int i18, IZPlanWorldCallback iZPlanWorldCallback) throws RemoteException {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.zplan.IZPlanServiceInterface");
                    obtain.writeInt(i3);
                    obtain.writeInt(i16);
                    obtain.writeInt(i17);
                    obtain.writeInt(i18);
                    if (iZPlanWorldCallback != null) {
                        iBinder = iZPlanWorldCallback.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    if (!OaidMonitor.binderTransact(this.f385644d, 28, obtain, null, 1) && a.v() != null) {
                        a.v().l3(i3, i16, i17, i18, iZPlanWorldCallback);
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.zplan.h
            public void l4(int i3, int i16, String str, IZPlanEnterSceneCallback iZPlanEnterSceneCallback) throws RemoteException {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.zplan.IZPlanServiceInterface");
                    obtain.writeInt(i3);
                    obtain.writeInt(i16);
                    obtain.writeString(str);
                    if (iZPlanEnterSceneCallback != null) {
                        iBinder = iZPlanEnterSceneCallback.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    if (!OaidMonitor.binderTransact(this.f385644d, 30, obtain, null, 1) && a.v() != null) {
                        a.v().l4(i3, i16, str, iZPlanEnterSceneCallback);
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.zplan.h
            public void m4(int i3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.zplan.IZPlanServiceInterface");
                    obtain.writeInt(i3);
                    if (!OaidMonitor.binderTransact(this.f385644d, 37, obtain, null, 1) && a.v() != null) {
                        a.v().m4(i3);
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.zplan.h
            public void notifyAppearanceKeyChange(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.zplan.IZPlanServiceInterface");
                    obtain.writeString(str);
                    if (!OaidMonitor.binderTransact(this.f385644d, 12, obtain, obtain2, 0) && a.v() != null) {
                        a.v().notifyAppearanceKeyChange(str);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.zplan.h
            public void o4(int i3, int i16, boolean z16) throws RemoteException {
                int i17;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.zplan.IZPlanServiceInterface");
                    obtain.writeInt(i3);
                    obtain.writeInt(i16);
                    if (z16) {
                        i17 = 1;
                    } else {
                        i17 = 0;
                    }
                    obtain.writeInt(i17);
                    if (!OaidMonitor.binderTransact(this.f385644d, 35, obtain, obtain2, 0) && a.v() != null) {
                        a.v().o4(i3, i16, z16);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.zplan.h
            public void onAppBackground() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.zplan.IZPlanServiceInterface");
                    if (!OaidMonitor.binderTransact(this.f385644d, 63, obtain, obtain2, 0) && a.v() != null) {
                        a.v().onAppBackground();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.zplan.h
            public void onAppForeground() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.zplan.IZPlanServiceInterface");
                    if (!OaidMonitor.binderTransact(this.f385644d, 64, obtain, obtain2, 0) && a.v() != null) {
                        a.v().onAppForeground();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.zplan.h
            public void onTouchEvent(MotionEvent motionEvent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.zplan.IZPlanServiceInterface");
                    if (motionEvent != null) {
                        obtain.writeInt(1);
                        motionEvent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!OaidMonitor.binderTransact(this.f385644d, 14, obtain, obtain2, 0) && a.v() != null) {
                        a.v().onTouchEvent(motionEvent);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.zplan.h
            public void pauseEngine() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.zplan.IZPlanServiceInterface");
                    if (!OaidMonitor.binderTransact(this.f385644d, 2, obtain, null, 1) && a.v() != null) {
                        a.v().pauseEngine();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.zplan.h
            public void r2(int i3, int i16, int i17) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.zplan.IZPlanServiceInterface");
                    obtain.writeInt(i3);
                    obtain.writeInt(i16);
                    obtain.writeInt(i17);
                    if (!OaidMonitor.binderTransact(this.f385644d, 29, obtain, null, 1) && a.v() != null) {
                        a.v().r2(i3, i16, i17);
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.zplan.h
            public List<ReporterEventRecordTime> s0(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.zplan.IZPlanServiceInterface");
                    obtain.writeString(str);
                    if (!OaidMonitor.binderTransact(this.f385644d, 9, obtain, obtain2, 0) && a.v() != null) {
                        return a.v().s0(str);
                    }
                    obtain2.readException();
                    return obtain2.createTypedArrayList(ReporterEventRecordTime.CREATOR);
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.zplan.h
            public void s4(String str, String str2, b bVar, boolean z16) throws RemoteException {
                IBinder iBinder;
                int i3;
                Parcel obtain = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.zplan.IZPlanServiceInterface");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (bVar != null) {
                        iBinder = bVar.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    if (z16) {
                        i3 = 1;
                    } else {
                        i3 = 0;
                    }
                    obtain.writeInt(i3);
                    if (!OaidMonitor.binderTransact(this.f385644d, 17, obtain, null, 1) && a.v() != null) {
                        a.v().s4(str, str2, bVar, z16);
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.zplan.h
            public void setSurface(Surface surface) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.zplan.IZPlanServiceInterface");
                    if (surface != null) {
                        obtain.writeInt(1);
                        surface.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!OaidMonitor.binderTransact(this.f385644d, 6, obtain, null, 1) && a.v() != null) {
                        a.v().setSurface(surface);
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.zplan.h
            public void v1(MemeRecordParams memeRecordParams, IZPlanRecordCallback iZPlanRecordCallback) throws RemoteException {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.zplan.IZPlanServiceInterface");
                    if (memeRecordParams != null) {
                        obtain.writeInt(1);
                        memeRecordParams.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (iZPlanRecordCallback != null) {
                        iBinder = iZPlanRecordCallback.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    if (!OaidMonitor.binderTransact(this.f385644d, 11, obtain, null, 1) && a.v() != null) {
                        a.v().v1(memeRecordParams, iZPlanRecordCallback);
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.zplan.h
            public boolean w0() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.zplan.IZPlanServiceInterface");
                    boolean z16 = false;
                    if (!OaidMonitor.binderTransact(this.f385644d, 42, obtain, obtain2, 0) && a.v() != null) {
                        return a.v().w0();
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

            @Override // com.tencent.zplan.h
            public void w1(int i3, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.zplan.IZPlanServiceInterface");
                    obtain.writeInt(i3);
                    obtain.writeString(str);
                    if (!OaidMonitor.binderTransact(this.f385644d, 19, obtain, obtain2, 0) && a.v() != null) {
                        a.v().w1(i3, str);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.zplan.h
            public void x0(Surface surface) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.zplan.IZPlanServiceInterface");
                    if (surface != null) {
                        obtain.writeInt(1);
                        surface.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!OaidMonitor.binderTransact(this.f385644d, 1, obtain, null, 1) && a.v() != null) {
                        a.v().x0(surface);
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.zplan.h
            public void y1(long j3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.zplan.IZPlanServiceInterface");
                    obtain.writeLong(j3);
                    if (!OaidMonitor.binderTransact(this.f385644d, 25, obtain, obtain2, 0) && a.v() != null) {
                        a.v().y1(j3);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.zplan.h
            public void y3(int i3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.zplan.IZPlanServiceInterface");
                    obtain.writeInt(i3);
                    if (!OaidMonitor.binderTransact(this.f385644d, 36, obtain, null, 1) && a.v() != null) {
                        a.v().y3(i3);
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.zplan.h
            public int y4() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.zplan.IZPlanServiceInterface");
                    if (!OaidMonitor.binderTransact(this.f385644d, 50, obtain, obtain2, 0) && a.v() != null) {
                        return a.v().y4();
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.zplan.h
            public void z(String str, Bundle bundle, e eVar) throws RemoteException {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.zplan.IZPlanServiceInterface");
                    obtain.writeString(str);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (eVar != null) {
                        iBinder = eVar.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    if (!OaidMonitor.binderTransact(this.f385644d, 62, obtain, obtain2, 0) && a.v() != null) {
                        a.v().z(str, bundle, eVar);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.zplan.h
            public void z3(int i3, Surface surface) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.zplan.IZPlanServiceInterface");
                    obtain.writeInt(i3);
                    if (surface != null) {
                        obtain.writeInt(1);
                        surface.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!OaidMonitor.binderTransact(this.f385644d, 31, obtain, null, 1) && a.v() != null) {
                        a.v().z3(i3, surface);
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain);
                }
            }
        }

        public a() {
            attachInterface(this, "com.tencent.zplan.IZPlanServiceInterface");
        }

        public static h j(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.tencent.zplan.IZPlanServiceInterface");
            if (queryLocalInterface != null && (queryLocalInterface instanceof h)) {
                return (h) queryLocalInterface;
            }
            return new C10062a(iBinder);
        }

        public static h v() {
            return C10062a.f385643e;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i3, Parcel parcel, Parcel parcel2, int i16) throws RemoteException {
            boolean z16;
            boolean z17;
            Parcelable.Creator creator;
            if (i3 != 1598968902) {
                boolean z18 = false;
                Surface surface = null;
                Bundle bundle = null;
                HardwareBuffer hardwareBuffer = null;
                Configuration configuration = null;
                Surface surface2 = null;
                Surface surface3 = null;
                Surface surface4 = null;
                Surface surface5 = null;
                Surface surface6 = null;
                MotionEvent motionEvent = null;
                KeyEvent keyEvent = null;
                MemeRecordParams memeRecordParams = null;
                Surface surface7 = null;
                Surface surface8 = null;
                Surface surface9 = null;
                Surface surface10 = null;
                Surface surface11 = null;
                switch (i3) {
                    case 1:
                        parcel.enforceInterface("com.tencent.zplan.IZPlanServiceInterface");
                        if (parcel.readInt() != 0) {
                            surface = (Surface) Surface.CREATOR.createFromParcel(parcel);
                        }
                        x0(surface);
                        return true;
                    case 2:
                        parcel.enforceInterface("com.tencent.zplan.IZPlanServiceInterface");
                        pauseEngine();
                        return true;
                    case 3:
                        parcel.enforceInterface("com.tencent.zplan.IZPlanServiceInterface");
                        if (parcel.readInt() != 0) {
                            surface11 = (Surface) Surface.CREATOR.createFromParcel(parcel);
                        }
                        V0(surface11, d.a.j(parcel.readStrongBinder()));
                        return true;
                    case 4:
                        parcel.enforceInterface("com.tencent.zplan.IZPlanServiceInterface");
                        if (parcel.readInt() != 0) {
                            surface10 = (Surface) Surface.CREATOR.createFromParcel(parcel);
                        }
                        I0(surface10);
                        return true;
                    case 5:
                        parcel.enforceInterface("com.tencent.zplan.IZPlanServiceInterface");
                        c3(IZPlanEngineStatusCallback.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 6:
                        parcel.enforceInterface("com.tencent.zplan.IZPlanServiceInterface");
                        if (parcel.readInt() != 0) {
                            surface9 = (Surface) Surface.CREATOR.createFromParcel(parcel);
                        }
                        setSurface(surface9);
                        return true;
                    case 7:
                        parcel.enforceInterface("com.tencent.zplan.IZPlanServiceInterface");
                        if (parcel.readInt() != 0) {
                            surface8 = (Surface) Surface.CREATOR.createFromParcel(parcel);
                        }
                        G1(surface8);
                        return true;
                    case 8:
                        parcel.enforceInterface("com.tencent.zplan.IZPlanServiceInterface");
                        if (parcel.readInt() != 0) {
                            surface7 = (Surface) Surface.CREATOR.createFromParcel(parcel);
                        }
                        Z1(surface7);
                        return true;
                    case 9:
                        parcel.enforceInterface("com.tencent.zplan.IZPlanServiceInterface");
                        List<ReporterEventRecordTime> s06 = s0(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeTypedList(s06);
                        return true;
                    case 10:
                        parcel.enforceInterface("com.tencent.zplan.IZPlanServiceInterface");
                        P2();
                        parcel2.writeNoException();
                        return true;
                    case 11:
                        parcel.enforceInterface("com.tencent.zplan.IZPlanServiceInterface");
                        if (parcel.readInt() != 0) {
                            memeRecordParams = MemeRecordParams.CREATOR.createFromParcel(parcel);
                        }
                        v1(memeRecordParams, IZPlanRecordCallback.Stub.asInterface(parcel.readStrongBinder()));
                        return true;
                    case 12:
                        parcel.enforceInterface("com.tencent.zplan.IZPlanServiceInterface");
                        notifyAppearanceKeyChange(parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 13:
                        parcel.enforceInterface("com.tencent.zplan.IZPlanServiceInterface");
                        int readInt = parcel.readInt();
                        if (parcel.readInt() != 0) {
                            keyEvent = (KeyEvent) KeyEvent.CREATOR.createFromParcel(parcel);
                        }
                        T(readInt, keyEvent);
                        parcel2.writeNoException();
                        return true;
                    case 14:
                        parcel.enforceInterface("com.tencent.zplan.IZPlanServiceInterface");
                        if (parcel.readInt() != 0) {
                            motionEvent = (MotionEvent) MotionEvent.CREATOR.createFromParcel(parcel);
                        }
                        onTouchEvent(motionEvent);
                        parcel2.writeNoException();
                        return true;
                    case 15:
                        parcel.enforceInterface("com.tencent.zplan.IZPlanServiceInterface");
                        if (parcel.readInt() != 0) {
                            surface6 = (Surface) Surface.CREATOR.createFromParcel(parcel);
                        }
                        u2(surface6);
                        return true;
                    case 16:
                        parcel.enforceInterface("com.tencent.zplan.IZPlanServiceInterface");
                        h0(parcel.readString());
                        return true;
                    case 17:
                        parcel.enforceInterface("com.tencent.zplan.IZPlanServiceInterface");
                        String readString = parcel.readString();
                        String readString2 = parcel.readString();
                        b j3 = b.a.j(parcel.readStrongBinder());
                        if (parcel.readInt() != 0) {
                            z18 = true;
                        }
                        s4(readString, readString2, j3, z18);
                        return true;
                    case 18:
                        parcel.enforceInterface("com.tencent.zplan.IZPlanServiceInterface");
                        String readString3 = parcel.readString();
                        String readString4 = parcel.readString();
                        if (parcel.readInt() != 0) {
                            z18 = true;
                        }
                        I(readString3, readString4, z18);
                        return true;
                    case 19:
                        parcel.enforceInterface("com.tencent.zplan.IZPlanServiceInterface");
                        w1(parcel.readInt(), parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 20:
                        parcel.enforceInterface("com.tencent.zplan.IZPlanServiceInterface");
                        d1(parcel.readString(), c.a.j(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 21:
                        parcel.enforceInterface("com.tencent.zplan.IZPlanServiceInterface");
                        long F3 = F3();
                        parcel2.writeNoException();
                        parcel2.writeLong(F3);
                        return true;
                    case 22:
                        parcel.enforceInterface("com.tencent.zplan.IZPlanServiceInterface");
                        O0(parcel.readLong());
                        parcel2.writeNoException();
                        return true;
                    case 23:
                        parcel.enforceInterface("com.tencent.zplan.IZPlanServiceInterface");
                        long readLong = parcel.readLong();
                        if (parcel.readInt() != 0) {
                            surface5 = (Surface) Surface.CREATOR.createFromParcel(parcel);
                        }
                        O4(readLong, surface5, parcel.readInt(), parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 24:
                        parcel.enforceInterface("com.tencent.zplan.IZPlanServiceInterface");
                        long readLong2 = parcel.readLong();
                        if (parcel.readInt() != 0) {
                            surface4 = (Surface) Surface.CREATOR.createFromParcel(parcel);
                        }
                        R0(readLong2, surface4, parcel.readInt(), parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 25:
                        parcel.enforceInterface("com.tencent.zplan.IZPlanServiceInterface");
                        y1(parcel.readLong());
                        parcel2.writeNoException();
                        return true;
                    case 26:
                        parcel.enforceInterface("com.tencent.zplan.IZPlanServiceInterface");
                        n2(parcel.readLong(), parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 27:
                        parcel.enforceInterface("com.tencent.zplan.IZPlanServiceInterface");
                        G3(parcel.readInt(), parcel.readString(), IZPlanEnterSceneCallback.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 28:
                        parcel.enforceInterface("com.tencent.zplan.IZPlanServiceInterface");
                        l3(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), IZPlanWorldCallback.Stub.asInterface(parcel.readStrongBinder()));
                        return true;
                    case 29:
                        parcel.enforceInterface("com.tencent.zplan.IZPlanServiceInterface");
                        r2(parcel.readInt(), parcel.readInt(), parcel.readInt());
                        return true;
                    case 30:
                        parcel.enforceInterface("com.tencent.zplan.IZPlanServiceInterface");
                        l4(parcel.readInt(), parcel.readInt(), parcel.readString(), IZPlanEnterSceneCallback.Stub.asInterface(parcel.readStrongBinder()));
                        return true;
                    case 31:
                        parcel.enforceInterface("com.tencent.zplan.IZPlanServiceInterface");
                        int readInt2 = parcel.readInt();
                        if (parcel.readInt() != 0) {
                            surface3 = (Surface) Surface.CREATOR.createFromParcel(parcel);
                        }
                        z3(readInt2, surface3);
                        return true;
                    case 32:
                        parcel.enforceInterface("com.tencent.zplan.IZPlanServiceInterface");
                        o3(parcel.readInt());
                        return true;
                    case 33:
                        parcel.enforceInterface("com.tencent.zplan.IZPlanServiceInterface");
                        int readInt3 = parcel.readInt();
                        int readInt4 = parcel.readInt();
                        int readInt5 = parcel.readInt();
                        if (parcel.readInt() != 0) {
                            surface2 = (Surface) Surface.CREATOR.createFromParcel(parcel);
                        }
                        Y3(readInt3, readInt4, readInt5, surface2);
                        return true;
                    case 34:
                        parcel.enforceInterface("com.tencent.zplan.IZPlanServiceInterface");
                        I2();
                        parcel2.writeNoException();
                        return true;
                    case 35:
                        parcel.enforceInterface("com.tencent.zplan.IZPlanServiceInterface");
                        int readInt6 = parcel.readInt();
                        int readInt7 = parcel.readInt();
                        if (parcel.readInt() != 0) {
                            z18 = true;
                        }
                        o4(readInt6, readInt7, z18);
                        parcel2.writeNoException();
                        return true;
                    case 36:
                        parcel.enforceInterface("com.tencent.zplan.IZPlanServiceInterface");
                        y3(parcel.readInt());
                        return true;
                    case 37:
                        parcel.enforceInterface("com.tencent.zplan.IZPlanServiceInterface");
                        m4(parcel.readInt());
                        return true;
                    case 38:
                        parcel.enforceInterface("com.tencent.zplan.IZPlanServiceInterface");
                        Y4(parcel.readInt(), parcel.readInt());
                        return true;
                    case 39:
                        parcel.enforceInterface("com.tencent.zplan.IZPlanServiceInterface");
                        if (parcel.readInt() != 0) {
                            configuration = (Configuration) Configuration.CREATOR.createFromParcel(parcel);
                        }
                        onConfigurationChanged(configuration);
                        parcel2.writeNoException();
                        return true;
                    case 40:
                        parcel.enforceInterface("com.tencent.zplan.IZPlanServiceInterface");
                        boolean Z4 = Z4();
                        parcel2.writeNoException();
                        parcel2.writeInt(Z4 ? 1 : 0);
                        return true;
                    case 41:
                        parcel.enforceInterface("com.tencent.zplan.IZPlanServiceInterface");
                        boolean e16 = e1();
                        parcel2.writeNoException();
                        parcel2.writeInt(e16 ? 1 : 0);
                        return true;
                    case 42:
                        parcel.enforceInterface("com.tencent.zplan.IZPlanServiceInterface");
                        boolean w06 = w0();
                        parcel2.writeNoException();
                        parcel2.writeInt(w06 ? 1 : 0);
                        return true;
                    case 43:
                        parcel.enforceInterface("com.tencent.zplan.IZPlanServiceInterface");
                        if (parcel.readInt() != 0) {
                            z18 = true;
                        }
                        V1(z18);
                        parcel2.writeNoException();
                        return true;
                    case 44:
                        parcel.enforceInterface("com.tencent.zplan.IZPlanServiceInterface");
                        if (parcel.readInt() != 0) {
                            z18 = true;
                        }
                        a4(z18, parcel.readInt(), parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 45:
                        parcel.enforceInterface("com.tencent.zplan.IZPlanServiceInterface");
                        A3();
                        parcel2.writeNoException();
                        return true;
                    case 46:
                        parcel.enforceInterface("com.tencent.zplan.IZPlanServiceInterface");
                        H3();
                        parcel2.writeNoException();
                        return true;
                    case 47:
                        parcel.enforceInterface("com.tencent.zplan.IZPlanServiceInterface");
                        boolean H2 = H2();
                        parcel2.writeNoException();
                        parcel2.writeInt(H2 ? 1 : 0);
                        return true;
                    case 48:
                        parcel.enforceInterface("com.tencent.zplan.IZPlanServiceInterface");
                        String readString5 = parcel.readString();
                        if (parcel.readInt() != 0) {
                            z18 = true;
                        }
                        g3(readString5, z18);
                        parcel2.writeNoException();
                        return true;
                    case 49:
                        parcel.enforceInterface("com.tencent.zplan.IZPlanServiceInterface");
                        int W0 = W0();
                        parcel2.writeNoException();
                        parcel2.writeInt(W0);
                        return true;
                    case 50:
                        parcel.enforceInterface("com.tencent.zplan.IZPlanServiceInterface");
                        int y46 = y4();
                        parcel2.writeNoException();
                        parcel2.writeInt(y46);
                        return true;
                    case 51:
                        parcel.enforceInterface("com.tencent.zplan.IZPlanServiceInterface");
                        String readString6 = parcel.readString();
                        int readInt8 = parcel.readInt();
                        String readString7 = parcel.readString();
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
                        g1(readString6, readInt8, readString7, z16, z17);
                        parcel2.writeNoException();
                        return true;
                    case 52:
                        parcel.enforceInterface("com.tencent.zplan.IZPlanServiceInterface");
                        R1(parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 53:
                        parcel.enforceInterface("com.tencent.zplan.IZPlanServiceInterface");
                        B4(parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 54:
                        parcel.enforceInterface("com.tencent.zplan.IZPlanServiceInterface");
                        if (parcel.readInt() != 0) {
                            creator = HardwareBuffer.CREATOR;
                            hardwareBuffer = (HardwareBuffer) creator.createFromParcel(parcel);
                        }
                        r0(hardwareBuffer, parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 55:
                        parcel.enforceInterface("com.tencent.zplan.IZPlanServiceInterface");
                        J3();
                        parcel2.writeNoException();
                        return true;
                    case 56:
                        parcel.enforceInterface("com.tencent.zplan.IZPlanServiceInterface");
                        HardwareBuffer E0 = E0(parcel.readInt(), parcel.readInt());
                        parcel2.writeNoException();
                        if (E0 != null) {
                            parcel2.writeInt(1);
                            E0.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 57:
                        parcel.enforceInterface("com.tencent.zplan.IZPlanServiceInterface");
                        q1();
                        parcel2.writeNoException();
                        return true;
                    case 58:
                        parcel.enforceInterface("com.tencent.zplan.IZPlanServiceInterface");
                        a0(parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 59:
                        parcel.enforceInterface("com.tencent.zplan.IZPlanServiceInterface");
                        s2(parcel.readInt(), parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 60:
                        parcel.enforceInterface("com.tencent.zplan.IZPlanServiceInterface");
                        boolean L3 = L3();
                        parcel2.writeNoException();
                        parcel2.writeInt(L3 ? 1 : 0);
                        return true;
                    case 61:
                        parcel.enforceInterface("com.tencent.zplan.IZPlanServiceInterface");
                        ParcelFileDescriptor v26 = v2();
                        parcel2.writeNoException();
                        if (v26 != null) {
                            parcel2.writeInt(1);
                            v26.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 62:
                        parcel.enforceInterface("com.tencent.zplan.IZPlanServiceInterface");
                        String readString8 = parcel.readString();
                        if (parcel.readInt() != 0) {
                            bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                        }
                        z(readString8, bundle, e.a.j(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 63:
                        parcel.enforceInterface("com.tencent.zplan.IZPlanServiceInterface");
                        onAppBackground();
                        parcel2.writeNoException();
                        return true;
                    case 64:
                        parcel.enforceInterface("com.tencent.zplan.IZPlanServiceInterface");
                        onAppForeground();
                        parcel2.writeNoException();
                        return true;
                    case 65:
                        parcel.enforceInterface("com.tencent.zplan.IZPlanServiceInterface");
                        H();
                        parcel2.writeNoException();
                        return true;
                    case 66:
                        parcel.enforceInterface("com.tencent.zplan.IZPlanServiceInterface");
                        String readString9 = parcel.readString();
                        if (parcel.readInt() != 0) {
                            z18 = true;
                        }
                        f0(readString9, z18);
                        parcel2.writeNoException();
                        return true;
                    default:
                        return super.onTransact(i3, parcel, parcel2, i16);
                }
            }
            parcel2.writeString("com.tencent.zplan.IZPlanServiceInterface");
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }
}
