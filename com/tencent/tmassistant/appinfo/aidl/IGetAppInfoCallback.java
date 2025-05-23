package com.tencent.tmassistant.appinfo.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;
import com.tencent.tmassistant.appinfo.data.AppDetail;
import java.util.List;

/* compiled from: P */
/* loaded from: classes26.dex */
public interface IGetAppInfoCallback extends IInterface {
    void onGetAppInfoResponse(int i3, int i16, List<AppDetail> list);

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public static abstract class Stub extends Binder implements IGetAppInfoCallback {
        private static final String DESCRIPTOR = "com.tencent.tmassistant.appinfo.aidl.IGetAppInfoCallback";

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: P */
        /* loaded from: classes26.dex */
        public static class a implements IGetAppInfoCallback {

            /* renamed from: b, reason: collision with root package name */
            public static IGetAppInfoCallback f380369b;

            /* renamed from: a, reason: collision with root package name */
            private IBinder f380370a;

            a(IBinder iBinder) {
                this.f380370a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f380370a;
            }

            @Override // com.tencent.tmassistant.appinfo.aidl.IGetAppInfoCallback
            public void onGetAppInfoResponse(int i3, int i16, List<AppDetail> list) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, Stub.DESCRIPTOR);
                    obtain.writeInt(i3);
                    obtain.writeInt(i16);
                    obtain.writeTypedList(list);
                    if (!OaidMonitor.binderTransact(this.f380370a, 1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onGetAppInfoResponse(i3, i16, list);
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

        public static IGetAppInfoCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof IGetAppInfoCallback)) {
                return (IGetAppInfoCallback) queryLocalInterface;
            }
            return new a(iBinder);
        }

        public static IGetAppInfoCallback getDefaultImpl() {
            return a.f380369b;
        }

        public static boolean setDefaultImpl(IGetAppInfoCallback iGetAppInfoCallback) {
            if (a.f380369b == null && iGetAppInfoCallback != null) {
                a.f380369b = iGetAppInfoCallback;
                return true;
            }
            return false;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i3, Parcel parcel, Parcel parcel2, int i16) {
            if (i3 != 1) {
                if (i3 != 1598968902) {
                    return super.onTransact(i3, parcel, parcel2, i16);
                }
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            parcel.enforceInterface(DESCRIPTOR);
            onGetAppInfoResponse(parcel.readInt(), parcel.readInt(), parcel.createTypedArrayList(AppDetail.CREATOR));
            parcel2.writeNoException();
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public static class Default implements IGetAppInfoCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.tencent.tmassistant.appinfo.aidl.IGetAppInfoCallback
        public void onGetAppInfoResponse(int i3, int i16, List<AppDetail> list) {
        }
    }
}
