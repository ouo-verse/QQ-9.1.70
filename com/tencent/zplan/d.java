package com.tencent.zplan;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;

/* compiled from: P */
/* loaded from: classes27.dex */
public interface d extends IInterface {

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static abstract class a extends Binder implements d {

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: P */
        /* renamed from: com.tencent.zplan.d$a$a, reason: collision with other inner class name */
        /* loaded from: classes27.dex */
        public static class C10053a implements d {

            /* renamed from: e, reason: collision with root package name */
            public static d f385296e;

            /* renamed from: d, reason: collision with root package name */
            private IBinder f385297d;

            C10053a(IBinder iBinder) {
                this.f385297d = iBinder;
            }

            @Override // com.tencent.zplan.d
            public void S0(boolean z16) throws RemoteException {
                int i3;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.zplan.IRunStatus");
                    if (z16) {
                        i3 = 1;
                    } else {
                        i3 = 0;
                    }
                    obtain.writeInt(i3);
                    if (!OaidMonitor.binderTransact(this.f385297d, 1, obtain, obtain2, 0) && a.v() != null) {
                        a.v().S0(z16);
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
                return this.f385297d;
            }
        }

        public static d j(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.tencent.zplan.IRunStatus");
            if (queryLocalInterface != null && (queryLocalInterface instanceof d)) {
                return (d) queryLocalInterface;
            }
            return new C10053a(iBinder);
        }

        public static d v() {
            return C10053a.f385296e;
        }
    }

    void S0(boolean z16) throws RemoteException;
}
