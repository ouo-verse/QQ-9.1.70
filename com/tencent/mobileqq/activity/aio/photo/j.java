package com.tencent.mobileqq.activity.aio.photo;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes10.dex */
public interface j extends IInterface {

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static abstract class a extends Binder implements j {

        /* compiled from: P */
        /* renamed from: com.tencent.mobileqq.activity.aio.photo.j$a$a, reason: collision with other inner class name */
        /* loaded from: classes10.dex */
        private static class C7135a implements j {

            /* renamed from: d, reason: collision with root package name */
            private IBinder f179750d;

            C7135a(IBinder iBinder) {
                this.f179750d = iBinder;
            }

            @Override // com.tencent.mobileqq.activity.aio.photo.j
            public void P4(CompressInfo compressInfo) {
                Parcel obtain = Parcel.obtain();
                try {
                    try {
                        OaidMonitor.writeParcelToken(obtain, "com.tencent.mobileqq.activity.aio.photo.ICompressionCallBack");
                        obtain.writeParcelable(compressInfo, 1);
                        OaidMonitor.binderTransact(this.f179750d, 2, obtain, null, 1);
                    } catch (RemoteException e16) {
                        if (QLog.isColorLevel()) {
                            QLog.e("ICompressionCallBack", 2, e16.getMessage(), e16);
                        }
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f179750d;
            }

            @Override // com.tencent.mobileqq.activity.aio.photo.j
            public void k2(CompressInfo compressInfo) {
                Parcel obtain = Parcel.obtain();
                try {
                    try {
                        OaidMonitor.writeParcelToken(obtain, "com.tencent.mobileqq.activity.aio.photo.ICompressionCallBack");
                        obtain.writeParcelable(compressInfo, 1);
                        OaidMonitor.binderTransact(this.f179750d, 3, obtain, null, 1);
                    } catch (RemoteException e16) {
                        if (QLog.isColorLevel()) {
                            QLog.e("ICompressionCallBack", 2, e16.getMessage(), e16);
                        }
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.mobileqq.activity.aio.photo.j
            public void o1(CompressInfo compressInfo) {
                Parcel obtain = Parcel.obtain();
                try {
                    try {
                        OaidMonitor.writeParcelToken(obtain, "com.tencent.mobileqq.activity.aio.photo.ICompressionCallBack");
                        obtain.writeParcelable(compressInfo, 1);
                        OaidMonitor.binderTransact(this.f179750d, 1, obtain, null, 1);
                    } catch (RemoteException e16) {
                        if (QLog.isColorLevel()) {
                            QLog.e("ICompressionCallBack", 2, e16.getMessage(), e16);
                        }
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain);
                }
            }
        }

        public static j j(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.tencent.mobileqq.activity.aio.photo.ICompressionCallBack");
            if (queryLocalInterface != null && (queryLocalInterface instanceof j)) {
                return (j) queryLocalInterface;
            }
            return new C7135a(iBinder);
        }
    }

    void P4(CompressInfo compressInfo);

    void k2(CompressInfo compressInfo);

    void o1(CompressInfo compressInfo);
}
