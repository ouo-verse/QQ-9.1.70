package com.tencent.zplan;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;

/* compiled from: P */
/* loaded from: classes27.dex */
public interface e extends IInterface {
    void T0(boolean z16, String str) throws RemoteException;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static abstract class a extends Binder implements e {

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: P */
        /* renamed from: com.tencent.zplan.e$a$a, reason: collision with other inner class name */
        /* loaded from: classes27.dex */
        public static class C10054a implements e {

            /* renamed from: e, reason: collision with root package name */
            public static e f385300e;

            /* renamed from: d, reason: collision with root package name */
            private IBinder f385301d;

            C10054a(IBinder iBinder) {
                this.f385301d = iBinder;
            }

            @Override // com.tencent.zplan.e
            public void T0(boolean z16, String str) throws RemoteException {
                int i3;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.zplan.IZPlanActionCallback");
                    if (z16) {
                        i3 = 1;
                    } else {
                        i3 = 0;
                    }
                    obtain.writeInt(i3);
                    obtain.writeString(str);
                    if (!OaidMonitor.binderTransact(this.f385301d, 1, obtain, obtain2, 0) && a.v() != null) {
                        a.v().T0(z16, str);
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
                return this.f385301d;
            }
        }

        public a() {
            attachInterface(this, "com.tencent.zplan.IZPlanActionCallback");
        }

        public static e j(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.tencent.zplan.IZPlanActionCallback");
            if (queryLocalInterface != null && (queryLocalInterface instanceof e)) {
                return (e) queryLocalInterface;
            }
            return new C10054a(iBinder);
        }

        public static e v() {
            return C10054a.f385300e;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i3, Parcel parcel, Parcel parcel2, int i16) throws RemoteException {
            boolean z16;
            if (i3 != 1) {
                if (i3 != 1598968902) {
                    return super.onTransact(i3, parcel, parcel2, i16);
                }
                parcel2.writeString("com.tencent.zplan.IZPlanActionCallback");
                return true;
            }
            parcel.enforceInterface("com.tencent.zplan.IZPlanActionCallback");
            if (parcel.readInt() != 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            T0(z16, parcel.readString());
            parcel2.writeNoException();
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }
}
