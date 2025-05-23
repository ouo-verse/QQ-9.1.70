package com.tencent.luggage.wxa.pp;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;

/* compiled from: P */
/* loaded from: classes8.dex */
public interface a extends IInterface {
    int a(int i3);

    c a(int i3, String str, String str2);

    d a(long j3);

    boolean a(int i3, String str);

    int b(int i3, String str);

    boolean b(int i3);

    int c(int i3, String str);

    b c(int i3);

    int d(int i3);

    b d(int i3, String str);

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.pp.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static abstract class AbstractBinderC6612a extends Binder implements a {
        public static a a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.tencent.soter.soterserver.ISoterService");
            if (queryLocalInterface != null && (queryLocalInterface instanceof a)) {
                return (a) queryLocalInterface;
            }
            return new C6613a(iBinder);
        }

        public static a f() {
            return C6613a.f137726b;
        }

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.pp.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public static class C6613a implements a {

            /* renamed from: b, reason: collision with root package name */
            public static a f137726b;

            /* renamed from: a, reason: collision with root package name */
            public IBinder f137727a;

            public C6613a(IBinder iBinder) {
                this.f137727a = iBinder;
            }

            @Override // com.tencent.luggage.wxa.pp.a
            public int a(int i3) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.soter.soterserver.ISoterService");
                    obtain.writeInt(i3);
                    if (!OaidMonitor.binderTransact(this.f137727a, 7, obtain, obtain2, 0) && AbstractBinderC6612a.f() != null) {
                        return AbstractBinderC6612a.f().a(i3);
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f137727a;
            }

            @Override // com.tencent.luggage.wxa.pp.a
            public boolean b(int i3) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.soter.soterserver.ISoterService");
                    obtain.writeInt(i3);
                    if (!OaidMonitor.binderTransact(this.f137727a, 3, obtain, obtain2, 0) && AbstractBinderC6612a.f() != null) {
                        return AbstractBinderC6612a.f().b(i3);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.luggage.wxa.pp.a
            public b c(int i3) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.soter.soterserver.ISoterService");
                    obtain.writeInt(i3);
                    if (!OaidMonitor.binderTransact(this.f137727a, 2, obtain, obtain2, 0) && AbstractBinderC6612a.f() != null) {
                        return AbstractBinderC6612a.f().c(i3);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? b.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.luggage.wxa.pp.a
            public int d(int i3) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.soter.soterserver.ISoterService");
                    obtain.writeInt(i3);
                    if (!OaidMonitor.binderTransact(this.f137727a, 1, obtain, obtain2, 0) && AbstractBinderC6612a.f() != null) {
                        return AbstractBinderC6612a.f().d(i3);
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.luggage.wxa.pp.a
            public boolean a(int i3, String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.soter.soterserver.ISoterService");
                    obtain.writeInt(i3);
                    obtain.writeString(str);
                    if (!OaidMonitor.binderTransact(this.f137727a, 8, obtain, obtain2, 0) && AbstractBinderC6612a.f() != null) {
                        return AbstractBinderC6612a.f().a(i3, str);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.luggage.wxa.pp.a
            public int b(int i3, String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.soter.soterserver.ISoterService");
                    obtain.writeInt(i3);
                    obtain.writeString(str);
                    if (!OaidMonitor.binderTransact(this.f137727a, 5, obtain, obtain2, 0) && AbstractBinderC6612a.f() != null) {
                        return AbstractBinderC6612a.f().b(i3, str);
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.luggage.wxa.pp.a
            public b d(int i3, String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.soter.soterserver.ISoterService");
                    obtain.writeInt(i3);
                    obtain.writeString(str);
                    if (!OaidMonitor.binderTransact(this.f137727a, 6, obtain, obtain2, 0) && AbstractBinderC6612a.f() != null) {
                        return AbstractBinderC6612a.f().d(i3, str);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? b.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.luggage.wxa.pp.a
            public int c(int i3, String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.soter.soterserver.ISoterService");
                    obtain.writeInt(i3);
                    obtain.writeString(str);
                    if (!OaidMonitor.binderTransact(this.f137727a, 4, obtain, obtain2, 0) && AbstractBinderC6612a.f() != null) {
                        return AbstractBinderC6612a.f().c(i3, str);
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.luggage.wxa.pp.a
            public c a(int i3, String str, String str2) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.soter.soterserver.ISoterService");
                    obtain.writeInt(i3);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (!OaidMonitor.binderTransact(this.f137727a, 9, obtain, obtain2, 0) && AbstractBinderC6612a.f() != null) {
                        return AbstractBinderC6612a.f().a(i3, str, str2);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? c.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.luggage.wxa.pp.a
            public d a(long j3) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.soter.soterserver.ISoterService");
                    obtain.writeLong(j3);
                    if (!OaidMonitor.binderTransact(this.f137727a, 10, obtain, obtain2, 0) && AbstractBinderC6612a.f() != null) {
                        return AbstractBinderC6612a.f().a(j3);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? d.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }
        }
    }
}
