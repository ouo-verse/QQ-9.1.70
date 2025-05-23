package b2;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.hihonor.cloudservice.framework.aidl.DataBuffer;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;

/* compiled from: P */
/* loaded from: classes2.dex */
public interface b extends IInterface {

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static abstract class a extends Binder implements b {

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: P */
        /* renamed from: b2.b$a$a, reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static class C0087a implements b {

            /* renamed from: e, reason: collision with root package name */
            public static b f27747e;

            /* renamed from: d, reason: collision with root package name */
            private IBinder f27748d;

            C0087a(IBinder iBinder) {
                this.f27748d = iBinder;
            }

            @Override // b2.b
            public void L4(DataBuffer dataBuffer, b2.a aVar) {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.hihonor.cloudservice.framework.aidl.IServiceInvoke");
                    if (dataBuffer != null) {
                        obtain.writeInt(1);
                        dataBuffer.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (aVar != null) {
                        iBinder = aVar.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    if (!OaidMonitor.binderTransact(this.f27748d, 1, obtain, obtain2, 0) && a.v() != null) {
                        a.v().L4(dataBuffer, aVar);
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
                return this.f27748d;
            }
        }

        public static b v() {
            return C0087a.f27747e;
        }

        public static b x(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.hihonor.cloudservice.framework.aidl.IServiceInvoke");
            if (queryLocalInterface != null && (queryLocalInterface instanceof b)) {
                return (b) queryLocalInterface;
            }
            return new C0087a(iBinder);
        }
    }

    void L4(DataBuffer dataBuffer, b2.a aVar);
}
