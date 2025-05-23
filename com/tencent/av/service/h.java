package com.tencent.av.service;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;

/* compiled from: P */
/* loaded from: classes3.dex */
public interface h extends IInterface {

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static abstract class a extends Binder implements h {

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: P */
        /* renamed from: com.tencent.av.service.h$a$a, reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static class C0747a implements h {

            /* renamed from: e, reason: collision with root package name */
            public static h f74378e;

            /* renamed from: d, reason: collision with root package name */
            private IBinder f74379d;

            C0747a(IBinder iBinder) {
                this.f74379d = iBinder;
            }

            @Override // com.tencent.av.service.h
            public void R2(int i3, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.av.service.IQQServiceLocationCallback");
                    obtain.writeInt(i3);
                    obtain.writeString(str);
                    if (!OaidMonitor.binderTransact(this.f74379d, 1, obtain, null, 1) && a.v() != null) {
                        a.v().R2(i3, str);
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.av.service.h
            public void W(boolean z16, LBSInfo lBSInfo) throws RemoteException {
                int i3;
                Parcel obtain = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.av.service.IQQServiceLocationCallback");
                    if (z16) {
                        i3 = 1;
                    } else {
                        i3 = 0;
                    }
                    obtain.writeInt(i3);
                    if (lBSInfo != null) {
                        obtain.writeInt(1);
                        lBSInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!OaidMonitor.binderTransact(this.f74379d, 2, obtain, null, 1) && a.v() != null) {
                        a.v().W(z16, lBSInfo);
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f74379d;
            }
        }

        public static h j(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.tencent.av.service.IQQServiceLocationCallback");
            if (queryLocalInterface != null && (queryLocalInterface instanceof h)) {
                return (h) queryLocalInterface;
            }
            return new C0747a(iBinder);
        }

        public static h v() {
            return C0747a.f74378e;
        }
    }

    void R2(int i3, String str) throws RemoteException;

    void W(boolean z16, LBSInfo lBSInfo) throws RemoteException;
}
