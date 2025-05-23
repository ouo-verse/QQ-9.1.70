package com.tencent.mobileqq.wink.api;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.tencent.mobileqq.wink.model.MediaScanForwardResult;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;
import java.util.List;

/* compiled from: P */
/* loaded from: classes21.dex */
public interface a extends IInterface {

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.wink.api.a$a, reason: collision with other inner class name */
    /* loaded from: classes21.dex */
    public static abstract class AbstractBinderC9012a extends Binder implements a {

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: P */
        /* renamed from: com.tencent.mobileqq.wink.api.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes21.dex */
        public static class C9013a implements a {

            /* renamed from: e, reason: collision with root package name */
            public static a f317958e;

            /* renamed from: d, reason: collision with root package name */
            private IBinder f317959d;

            C9013a(IBinder iBinder) {
                this.f317959d = iBinder;
            }

            @Override // com.tencent.mobileqq.wink.api.a
            public void R(List<MediaScanForwardResult> list) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.mobileqq.wink.api.IClipResultCallback");
                    obtain.writeTypedList(list);
                    if (!OaidMonitor.binderTransact(this.f317959d, 1, obtain, obtain2, 0) && AbstractBinderC9012a.v() != null) {
                        AbstractBinderC9012a.v().R(list);
                    } else {
                        obtain2.readException();
                        obtain2.readTypedList(list, MediaScanForwardResult.INSTANCE);
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f317959d;
            }
        }

        public static a j(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.tencent.mobileqq.wink.api.IClipResultCallback");
            if (queryLocalInterface != null && (queryLocalInterface instanceof a)) {
                return (a) queryLocalInterface;
            }
            return new C9013a(iBinder);
        }

        public static a v() {
            return C9013a.f317958e;
        }
    }

    void R(List<MediaScanForwardResult> list) throws RemoteException;
}
