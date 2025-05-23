package com.huawei.hms.hihealth;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.huawei.hms.hihealth.data.AppLangItem;
import com.huawei.hms.hihealth.data.ScopeLangItem;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes2.dex */
public interface aabj extends IInterface {

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static abstract class aab extends Binder implements aabj {
        public static aabj aab() {
            return C0268aab.aaba;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: P */
        /* renamed from: com.huawei.hms.hihealth.aabj$aab$aab, reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static class C0268aab implements aabj {
            public static aabj aaba;
            private IBinder aab;

            C0268aab(IBinder iBinder) {
                this.aab = iBinder;
            }

            @Override // com.huawei.hms.hihealth.aabj
            public void aab(boolean z16) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.huawei.hms.hihealth.IConsentsControllerManager");
                    obtain.writeInt(z16 ? 1 : 0);
                    if (OaidMonitor.binderTransact(this.aab, 6, obtain, obtain2, 0) || aab.aab() == null) {
                        obtain2.readException();
                    } else {
                        ((C0268aab) aaba).aab(z16);
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.huawei.hms.hihealth.aabj
            public Map aaba(List<String> list) throws RemoteException {
                Map readHashMap;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.huawei.hms.hihealth.IConsentsControllerManager");
                    obtain.writeStringList(list);
                    if (!OaidMonitor.binderTransact(this.aab, 5, obtain, obtain2, 0) && aab.aab() != null) {
                        readHashMap = ((C0268aab) aaba).aaba(list);
                    } else {
                        obtain2.readException();
                        readHashMap = obtain2.readHashMap(getClass().getClassLoader());
                    }
                    return readHashMap;
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.aab;
            }

            @Override // com.huawei.hms.hihealth.aabj
            public ScopeLangItem aab(String str, String str2) throws RemoteException {
                ScopeLangItem createFromParcel;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.huawei.hms.hihealth.IConsentsControllerManager");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (OaidMonitor.binderTransact(this.aab, 2, obtain, obtain2, 0) || aab.aab() == null) {
                        obtain2.readException();
                        createFromParcel = obtain2.readInt() != 0 ? ScopeLangItem.CREATOR.createFromParcel(obtain2) : null;
                    } else {
                        createFromParcel = ((C0268aab) aaba).aab(str, str2);
                    }
                    return createFromParcel;
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.huawei.hms.hihealth.aabj
            public List<AppLangItem> aab(String str, int i3) throws RemoteException {
                List<AppLangItem> createTypedArrayList;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.huawei.hms.hihealth.IConsentsControllerManager");
                    obtain.writeString(str);
                    obtain.writeInt(i3);
                    if (OaidMonitor.binderTransact(this.aab, 1, obtain, obtain2, 0) || aab.aab() == null) {
                        obtain2.readException();
                        createTypedArrayList = obtain2.createTypedArrayList(AppLangItem.CREATOR);
                    } else {
                        createTypedArrayList = ((C0268aab) aaba).aab(str, i3);
                    }
                    return createTypedArrayList;
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.huawei.hms.hihealth.aabj
            public Map aab(List<String> list) throws RemoteException {
                Map readHashMap;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.huawei.hms.hihealth.IConsentsControllerManager");
                    obtain.writeStringList(list);
                    if (OaidMonitor.binderTransact(this.aab, 4, obtain, obtain2, 0) || aab.aab() == null) {
                        obtain2.readException();
                        readHashMap = obtain2.readHashMap(getClass().getClassLoader());
                    } else {
                        readHashMap = ((C0268aab) aaba).aab(list);
                    }
                    return readHashMap;
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.huawei.hms.hihealth.aabj
            public void aab(String str, List<String> list) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.huawei.hms.hihealth.IConsentsControllerManager");
                    obtain.writeString(str);
                    obtain.writeStringList(list);
                    if (OaidMonitor.binderTransact(this.aab, 3, obtain, obtain2, 0) || aab.aab() == null) {
                        obtain2.readException();
                    } else {
                        ((C0268aab) aaba).aab(str, list);
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }
        }

        public static aabj aab(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.huawei.hms.hihealth.IConsentsControllerManager");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof aabj)) ? new C0268aab(iBinder) : (aabj) queryLocalInterface;
        }
    }

    ScopeLangItem aab(String str, String str2) throws RemoteException;

    List<AppLangItem> aab(String str, int i3) throws RemoteException;

    Map aab(List<String> list) throws RemoteException;

    void aab(String str, List<String> list) throws RemoteException;

    void aab(boolean z16) throws RemoteException;

    Map aaba(List<String> list) throws RemoteException;
}
