package com.tencent.tmassistant.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;
import com.tencent.tmassistant.aidl.a;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes26.dex */
public interface b extends IInterface {
    int a(String str, String str2, int i3, String str3, String str4, Map map);

    void a();

    void a(int i3);

    void a(String str, com.tencent.tmassistant.aidl.a aVar);

    void a(String str, String str2);

    void a(boolean z16);

    void b(String str, com.tencent.tmassistant.aidl.a aVar);

    void b(boolean z16);

    int c();

    void c(String str, String str2);

    TMAssistantDownloadTaskInfo d(String str, String str2);

    void e(String str, String str2);

    List<TMAssistantDownloadTaskInfo> f(String str);

    void g();

    boolean h();

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public static abstract class a extends Binder implements b {
        public a() {
            attachInterface(this, "com.tencent.tmassistant.aidl.ITMAssistantDownloadSDKServiceInterface");
        }

        public static b a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.tencent.tmassistant.aidl.ITMAssistantDownloadSDKServiceInterface");
            if (queryLocalInterface != null && (queryLocalInterface instanceof b)) {
                return (b) queryLocalInterface;
            }
            return new C9991a(iBinder);
        }

        public static b i() {
            return C9991a.f380364b;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i3, Parcel parcel, Parcel parcel2, int i16) {
            if (i3 != 1598968902) {
                boolean z16 = false;
                switch (i3) {
                    case 1:
                        parcel.enforceInterface("com.tencent.tmassistant.aidl.ITMAssistantDownloadSDKServiceInterface");
                        int c16 = c();
                        parcel2.writeNoException();
                        parcel2.writeInt(c16);
                        return true;
                    case 2:
                        parcel.enforceInterface("com.tencent.tmassistant.aidl.ITMAssistantDownloadSDKServiceInterface");
                        if (parcel.readInt() != 0) {
                            z16 = true;
                        }
                        b(z16);
                        parcel2.writeNoException();
                        return true;
                    case 3:
                        parcel.enforceInterface("com.tencent.tmassistant.aidl.ITMAssistantDownloadSDKServiceInterface");
                        if (parcel.readInt() != 0) {
                            z16 = true;
                        }
                        a(z16);
                        parcel2.writeNoException();
                        return true;
                    case 4:
                        parcel.enforceInterface("com.tencent.tmassistant.aidl.ITMAssistantDownloadSDKServiceInterface");
                        a(parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 5:
                        parcel.enforceInterface("com.tencent.tmassistant.aidl.ITMAssistantDownloadSDKServiceInterface");
                        boolean h16 = h();
                        parcel2.writeNoException();
                        parcel2.writeInt(h16 ? 1 : 0);
                        return true;
                    case 6:
                        parcel.enforceInterface("com.tencent.tmassistant.aidl.ITMAssistantDownloadSDKServiceInterface");
                        TMAssistantDownloadTaskInfo d16 = d(parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        if (d16 != null) {
                            parcel2.writeInt(1);
                            d16.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 7:
                        parcel.enforceInterface("com.tencent.tmassistant.aidl.ITMAssistantDownloadSDKServiceInterface");
                        List<TMAssistantDownloadTaskInfo> f16 = f(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeTypedList(f16);
                        return true;
                    case 8:
                        parcel.enforceInterface("com.tencent.tmassistant.aidl.ITMAssistantDownloadSDKServiceInterface");
                        int a16 = a(parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readHashMap(getClass().getClassLoader()));
                        parcel2.writeNoException();
                        parcel2.writeInt(a16);
                        return true;
                    case 9:
                        parcel.enforceInterface("com.tencent.tmassistant.aidl.ITMAssistantDownloadSDKServiceInterface");
                        c(parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 10:
                        parcel.enforceInterface("com.tencent.tmassistant.aidl.ITMAssistantDownloadSDKServiceInterface");
                        e(parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 11:
                        parcel.enforceInterface("com.tencent.tmassistant.aidl.ITMAssistantDownloadSDKServiceInterface");
                        a(parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 12:
                        parcel.enforceInterface("com.tencent.tmassistant.aidl.ITMAssistantDownloadSDKServiceInterface");
                        a();
                        parcel2.writeNoException();
                        return true;
                    case 13:
                        parcel.enforceInterface("com.tencent.tmassistant.aidl.ITMAssistantDownloadSDKServiceInterface");
                        g();
                        parcel2.writeNoException();
                        return true;
                    case 14:
                        parcel.enforceInterface("com.tencent.tmassistant.aidl.ITMAssistantDownloadSDKServiceInterface");
                        a(parcel.readString(), a.AbstractBinderC9989a.a(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 15:
                        parcel.enforceInterface("com.tencent.tmassistant.aidl.ITMAssistantDownloadSDKServiceInterface");
                        b(parcel.readString(), a.AbstractBinderC9989a.a(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    default:
                        return super.onTransact(i3, parcel, parcel2, i16);
                }
            }
            parcel2.writeString("com.tencent.tmassistant.aidl.ITMAssistantDownloadSDKServiceInterface");
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: P */
        /* renamed from: com.tencent.tmassistant.aidl.b$a$a, reason: collision with other inner class name */
        /* loaded from: classes26.dex */
        public static class C9991a implements b {

            /* renamed from: b, reason: collision with root package name */
            public static b f380364b;

            /* renamed from: a, reason: collision with root package name */
            private IBinder f380365a;

            C9991a(IBinder iBinder) {
                this.f380365a = iBinder;
            }

            @Override // com.tencent.tmassistant.aidl.b
            public void a(boolean z16) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.tmassistant.aidl.ITMAssistantDownloadSDKServiceInterface");
                    obtain.writeInt(z16 ? 1 : 0);
                    if (!OaidMonitor.binderTransact(this.f380365a, 3, obtain, obtain2, 0) && a.i() != null) {
                        a.i().a(z16);
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
                return this.f380365a;
            }

            @Override // com.tencent.tmassistant.aidl.b
            public void b(String str, com.tencent.tmassistant.aidl.a aVar) {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.tmassistant.aidl.ITMAssistantDownloadSDKServiceInterface");
                    obtain.writeString(str);
                    if (aVar != null) {
                        iBinder = aVar.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    if (!OaidMonitor.binderTransact(this.f380365a, 15, obtain, obtain2, 0) && a.i() != null) {
                        a.i().b(str, aVar);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.tmassistant.aidl.b
            public int c() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.tmassistant.aidl.ITMAssistantDownloadSDKServiceInterface");
                    if (!OaidMonitor.binderTransact(this.f380365a, 1, obtain, obtain2, 0) && a.i() != null) {
                        return a.i().c();
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.tmassistant.aidl.b
            public TMAssistantDownloadTaskInfo d(String str, String str2) {
                TMAssistantDownloadTaskInfo tMAssistantDownloadTaskInfo;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.tmassistant.aidl.ITMAssistantDownloadSDKServiceInterface");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (!OaidMonitor.binderTransact(this.f380365a, 6, obtain, obtain2, 0) && a.i() != null) {
                        return a.i().d(str, str2);
                    }
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        tMAssistantDownloadTaskInfo = TMAssistantDownloadTaskInfo.CREATOR.createFromParcel(obtain2);
                    } else {
                        tMAssistantDownloadTaskInfo = null;
                    }
                    return tMAssistantDownloadTaskInfo;
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.tmassistant.aidl.b
            public void e(String str, String str2) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.tmassistant.aidl.ITMAssistantDownloadSDKServiceInterface");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (!OaidMonitor.binderTransact(this.f380365a, 10, obtain, obtain2, 0) && a.i() != null) {
                        a.i().e(str, str2);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.tmassistant.aidl.b
            public List<TMAssistantDownloadTaskInfo> f(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.tmassistant.aidl.ITMAssistantDownloadSDKServiceInterface");
                    obtain.writeString(str);
                    if (!OaidMonitor.binderTransact(this.f380365a, 7, obtain, obtain2, 0) && a.i() != null) {
                        return a.i().f(str);
                    }
                    obtain2.readException();
                    return obtain2.createTypedArrayList(TMAssistantDownloadTaskInfo.CREATOR);
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.tmassistant.aidl.b
            public void g() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.tmassistant.aidl.ITMAssistantDownloadSDKServiceInterface");
                    if (!OaidMonitor.binderTransact(this.f380365a, 13, obtain, obtain2, 0) && a.i() != null) {
                        a.i().g();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.tmassistant.aidl.b
            public boolean h() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.tmassistant.aidl.ITMAssistantDownloadSDKServiceInterface");
                    boolean z16 = false;
                    if (!OaidMonitor.binderTransact(this.f380365a, 5, obtain, obtain2, 0) && a.i() != null) {
                        return a.i().h();
                    }
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z16 = true;
                    }
                    return z16;
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.tmassistant.aidl.b
            public void a(int i3) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.tmassistant.aidl.ITMAssistantDownloadSDKServiceInterface");
                    obtain.writeInt(i3);
                    if (!OaidMonitor.binderTransact(this.f380365a, 4, obtain, obtain2, 0) && a.i() != null) {
                        a.i().a(i3);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.tmassistant.aidl.b
            public void c(String str, String str2) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.tmassistant.aidl.ITMAssistantDownloadSDKServiceInterface");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (!OaidMonitor.binderTransact(this.f380365a, 9, obtain, obtain2, 0) && a.i() != null) {
                        a.i().c(str, str2);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.tmassistant.aidl.b
            public int a(String str, String str2, int i3, String str3, String str4, Map map) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.tmassistant.aidl.ITMAssistantDownloadSDKServiceInterface");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeInt(i3);
                    obtain.writeString(str3);
                    obtain.writeString(str4);
                    obtain.writeMap(map);
                } catch (Throwable th5) {
                    th = th5;
                }
                try {
                    if (!OaidMonitor.binderTransact(this.f380365a, 8, obtain, obtain2, 0) && a.i() != null) {
                        int a16 = a.i().a(str, str2, i3, str3, str4, map);
                        OaidMonitor.parcelRecycle(obtain2);
                        OaidMonitor.parcelRecycle(obtain);
                        return a16;
                    }
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                    return readInt;
                } catch (Throwable th6) {
                    th = th6;
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                    throw th;
                }
            }

            @Override // com.tencent.tmassistant.aidl.b
            public void a(String str, String str2) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.tmassistant.aidl.ITMAssistantDownloadSDKServiceInterface");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (!OaidMonitor.binderTransact(this.f380365a, 11, obtain, obtain2, 0) && a.i() != null) {
                        a.i().a(str, str2);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.tmassistant.aidl.b
            public void a() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.tmassistant.aidl.ITMAssistantDownloadSDKServiceInterface");
                    if (!OaidMonitor.binderTransact(this.f380365a, 12, obtain, obtain2, 0) && a.i() != null) {
                        a.i().a();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.tmassistant.aidl.b
            public void a(String str, com.tencent.tmassistant.aidl.a aVar) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.tmassistant.aidl.ITMAssistantDownloadSDKServiceInterface");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(aVar != null ? aVar.asBinder() : null);
                    if (!OaidMonitor.binderTransact(this.f380365a, 14, obtain, obtain2, 0) && a.i() != null) {
                        a.i().a(str, aVar);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }
}
