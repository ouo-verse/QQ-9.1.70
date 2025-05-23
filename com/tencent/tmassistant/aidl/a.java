package com.tencent.tmassistant.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;
import java.util.List;

/* compiled from: P */
/* loaded from: classes26.dex */
public interface a extends IInterface {
    void a(String str, String str2, int i3, int i16, String str3);

    void a(String str, String str2, long j3, long j16);

    void a(List<String> list);

    /* compiled from: P */
    /* renamed from: com.tencent.tmassistant.aidl.a$a, reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    public static abstract class AbstractBinderC9989a extends Binder implements a {
        public AbstractBinderC9989a() {
            attachInterface(this, "com.tencent.tmassistant.aidl.ITMAssistantDownloadSDKServiceCallback");
        }

        public static a a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.tencent.tmassistant.aidl.ITMAssistantDownloadSDKServiceCallback");
            if (queryLocalInterface != null && (queryLocalInterface instanceof a)) {
                return (a) queryLocalInterface;
            }
            return new C9990a(iBinder);
        }

        public static a i() {
            return C9990a.f380362b;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i3, Parcel parcel, Parcel parcel2, int i16) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 1598968902) {
                            return super.onTransact(i3, parcel, parcel2, i16);
                        }
                        parcel2.writeString("com.tencent.tmassistant.aidl.ITMAssistantDownloadSDKServiceCallback");
                        return true;
                    }
                    parcel.enforceInterface("com.tencent.tmassistant.aidl.ITMAssistantDownloadSDKServiceCallback");
                    a(parcel.createStringArrayList());
                    parcel2.writeNoException();
                    return true;
                }
                parcel.enforceInterface("com.tencent.tmassistant.aidl.ITMAssistantDownloadSDKServiceCallback");
                a(parcel.readString(), parcel.readString(), parcel.readLong(), parcel.readLong());
                parcel2.writeNoException();
                return true;
            }
            parcel.enforceInterface("com.tencent.tmassistant.aidl.ITMAssistantDownloadSDKServiceCallback");
            a(parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readString());
            parcel2.writeNoException();
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: P */
        /* renamed from: com.tencent.tmassistant.aidl.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes26.dex */
        public static class C9990a implements a {

            /* renamed from: b, reason: collision with root package name */
            public static a f380362b;

            /* renamed from: a, reason: collision with root package name */
            private IBinder f380363a;

            C9990a(IBinder iBinder) {
                this.f380363a = iBinder;
            }

            @Override // com.tencent.tmassistant.aidl.a
            public void a(String str, String str2, int i3, int i16, String str3) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.tmassistant.aidl.ITMAssistantDownloadSDKServiceCallback");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeInt(i3);
                    obtain.writeInt(i16);
                    obtain.writeString(str3);
                    if (!OaidMonitor.binderTransact(this.f380363a, 1, obtain, obtain2, 0) && AbstractBinderC9989a.i() != null) {
                        AbstractBinderC9989a.i().a(str, str2, i3, i16, str3);
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
                return this.f380363a;
            }

            @Override // com.tencent.tmassistant.aidl.a
            public void a(String str, String str2, long j3, long j16) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.tmassistant.aidl.ITMAssistantDownloadSDKServiceCallback");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeLong(j3);
                    obtain.writeLong(j16);
                } catch (Throwable th5) {
                    th = th5;
                }
                try {
                    if (!OaidMonitor.binderTransact(this.f380363a, 2, obtain, obtain2, 0) && AbstractBinderC9989a.i() != null) {
                        AbstractBinderC9989a.i().a(str, str2, j3, j16);
                        OaidMonitor.parcelRecycle(obtain2);
                        OaidMonitor.parcelRecycle(obtain);
                    } else {
                        obtain2.readException();
                        OaidMonitor.parcelRecycle(obtain2);
                        OaidMonitor.parcelRecycle(obtain);
                    }
                } catch (Throwable th6) {
                    th = th6;
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                    throw th;
                }
            }
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }
}
