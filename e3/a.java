package e3;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;

/* compiled from: P */
/* loaded from: classes2.dex */
public interface a extends IInterface {

    /* compiled from: P */
    /* renamed from: e3.a$a, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static abstract class AbstractBinderC10214a extends Binder implements a {

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: P */
        /* renamed from: e3.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static class C10215a implements a {

            /* renamed from: e, reason: collision with root package name */
            public static a f395522e;

            /* renamed from: d, reason: collision with root package name */
            private IBinder f395523d;

            C10215a(IBinder iBinder) {
                this.f395523d = iBinder;
            }

            @Override // e3.a
            public void M1(Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.mcs.aidl.IMcsSdkService");
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!OaidMonitor.binderTransact(this.f395523d, 1, obtain, obtain2, 0) && AbstractBinderC10214a.v() != null) {
                        AbstractBinderC10214a.v().M1(bundle);
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
                return this.f395523d;
            }
        }

        public static a j(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.mcs.aidl.IMcsSdkService");
            if (queryLocalInterface != null && (queryLocalInterface instanceof a)) {
                return (a) queryLocalInterface;
            }
            return new C10215a(iBinder);
        }

        public static a v() {
            return C10215a.f395522e;
        }
    }

    void M1(Bundle bundle);
}
