package com.tencent.mobileqq.sharepanel.launcher.ipc;

import android.graphics.Bitmap;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes18.dex */
public interface a extends IInterface {

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.sharepanel.launcher.ipc.a$a, reason: collision with other inner class name */
    /* loaded from: classes18.dex */
    public static abstract class AbstractBinderC8586a extends Binder implements a {
        static IPatchRedirector $redirector_;

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: P */
        /* renamed from: com.tencent.mobileqq.sharepanel.launcher.ipc.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes18.dex */
        public static class C8587a implements a {
            static IPatchRedirector $redirector_;

            /* renamed from: e, reason: collision with root package name */
            public static a f287373e;

            /* renamed from: d, reason: collision with root package name */
            private IBinder f287374d;

            C8587a(IBinder iBinder) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) iBinder);
                } else {
                    this.f287374d = iBinder;
                }
            }

            @Override // com.tencent.mobileqq.sharepanel.launcher.ipc.a
            public boolean D4(ResultRecord resultRecord) throws RemoteException {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) resultRecord)).booleanValue();
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.mobileqq.sharepanel.launcher.ipc.ISharePanelIPCParam");
                    boolean z16 = true;
                    if (resultRecord != null) {
                        obtain.writeInt(1);
                        resultRecord.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!OaidMonitor.binderTransact(this.f287374d, 3, obtain, obtain2, 0) && AbstractBinderC8586a.v() != null) {
                        return AbstractBinderC8586a.v().D4(resultRecord);
                    }
                    obtain2.readException();
                    if (obtain2.readInt() == 0) {
                        z16 = false;
                    }
                    if (obtain2.readInt() != 0) {
                        ResultRecord.readFromParcel(obtain2);
                    }
                    return z16;
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.mobileqq.sharepanel.launcher.ipc.a
            public boolean G0() throws RemoteException {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.mobileqq.sharepanel.launcher.ipc.ISharePanelIPCParam");
                    boolean z16 = false;
                    if (!OaidMonitor.binderTransact(this.f287374d, 2, obtain, obtain2, 0) && AbstractBinderC8586a.v() != null) {
                        return AbstractBinderC8586a.v().G0();
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

            @Override // com.tencent.mobileqq.sharepanel.launcher.ipc.a
            public boolean J(List<ResultRecord> list, String str) throws RemoteException {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) list, (Object) str)).booleanValue();
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.mobileqq.sharepanel.launcher.ipc.ISharePanelIPCParam");
                    obtain.writeTypedList(list);
                    obtain.writeString(str);
                    boolean z16 = false;
                    if (!OaidMonitor.binderTransact(this.f287374d, 5, obtain, obtain2, 0) && AbstractBinderC8586a.v() != null) {
                        return AbstractBinderC8586a.v().J(list, str);
                    }
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z16 = true;
                    }
                    obtain2.readTypedList(list, ResultRecord.CREATOR);
                    return z16;
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (IBinder) iPatchRedirector.redirect((short) 2, (Object) this);
                }
                return this.f287374d;
            }

            @Override // com.tencent.mobileqq.sharepanel.launcher.ipc.a
            public boolean i0() throws RemoteException {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.mobileqq.sharepanel.launcher.ipc.ISharePanelIPCParam");
                    boolean z16 = false;
                    if (!OaidMonitor.binderTransact(this.f287374d, 4, obtain, obtain2, 0) && AbstractBinderC8586a.v() != null) {
                        return AbstractBinderC8586a.v().i0();
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

            @Override // com.tencent.mobileqq.sharepanel.launcher.ipc.a
            public boolean l(List<ResultRecord> list) throws RemoteException {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, (Object) list)).booleanValue();
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.mobileqq.sharepanel.launcher.ipc.ISharePanelIPCParam");
                    obtain.writeTypedList(list);
                    boolean z16 = false;
                    if (!OaidMonitor.binderTransact(this.f287374d, 6, obtain, obtain2, 0) && AbstractBinderC8586a.v() != null) {
                        return AbstractBinderC8586a.v().l(list);
                    }
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z16 = true;
                    }
                    obtain2.readTypedList(list, ResultRecord.CREATOR);
                    return z16;
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.mobileqq.sharepanel.launcher.ipc.a
            public Bitmap y2() throws RemoteException {
                Bitmap bitmap;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    return (Bitmap) iPatchRedirector.redirect((short) 4, (Object) this);
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.tencent.mobileqq.sharepanel.launcher.ipc.ISharePanelIPCParam");
                    if (!OaidMonitor.binderTransact(this.f287374d, 1, obtain, obtain2, 0) && AbstractBinderC8586a.v() != null) {
                        return AbstractBinderC8586a.v().y2();
                    }
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        bitmap = (Bitmap) Bitmap.CREATOR.createFromParcel(obtain2);
                    } else {
                        bitmap = null;
                    }
                    return bitmap;
                } finally {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                }
            }
        }

        public AbstractBinderC8586a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                attachInterface(this, "com.tencent.mobileqq.sharepanel.launcher.ipc.ISharePanelIPCParam");
            }
        }

        public static a j(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.tencent.mobileqq.sharepanel.launcher.ipc.ISharePanelIPCParam");
            if (queryLocalInterface != null && (queryLocalInterface instanceof a)) {
                return (a) queryLocalInterface;
            }
            return new C8587a(iBinder);
        }

        public static a v() {
            return C8587a.f287373e;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (IBinder) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i3, Parcel parcel, Parcel parcel2, int i16) throws RemoteException {
            ResultRecord resultRecord;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), parcel, parcel2, Integer.valueOf(i16))).booleanValue();
            }
            if (i3 != 1598968902) {
                switch (i3) {
                    case 1:
                        parcel.enforceInterface("com.tencent.mobileqq.sharepanel.launcher.ipc.ISharePanelIPCParam");
                        Bitmap y26 = y2();
                        parcel2.writeNoException();
                        if (y26 != null) {
                            parcel2.writeInt(1);
                            y26.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 2:
                        parcel.enforceInterface("com.tencent.mobileqq.sharepanel.launcher.ipc.ISharePanelIPCParam");
                        boolean G0 = G0();
                        parcel2.writeNoException();
                        parcel2.writeInt(G0 ? 1 : 0);
                        return true;
                    case 3:
                        parcel.enforceInterface("com.tencent.mobileqq.sharepanel.launcher.ipc.ISharePanelIPCParam");
                        if (parcel.readInt() != 0) {
                            resultRecord = ResultRecord.CREATOR.createFromParcel(parcel);
                        } else {
                            resultRecord = null;
                        }
                        boolean D4 = D4(resultRecord);
                        parcel2.writeNoException();
                        parcel2.writeInt(D4 ? 1 : 0);
                        if (resultRecord != null) {
                            parcel2.writeInt(1);
                            resultRecord.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 4:
                        parcel.enforceInterface("com.tencent.mobileqq.sharepanel.launcher.ipc.ISharePanelIPCParam");
                        boolean i06 = i0();
                        parcel2.writeNoException();
                        parcel2.writeInt(i06 ? 1 : 0);
                        return true;
                    case 5:
                        parcel.enforceInterface("com.tencent.mobileqq.sharepanel.launcher.ipc.ISharePanelIPCParam");
                        ArrayList createTypedArrayList = parcel.createTypedArrayList(ResultRecord.CREATOR);
                        boolean J = J(createTypedArrayList, parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeInt(J ? 1 : 0);
                        parcel2.writeTypedList(createTypedArrayList);
                        return true;
                    case 6:
                        parcel.enforceInterface("com.tencent.mobileqq.sharepanel.launcher.ipc.ISharePanelIPCParam");
                        ArrayList createTypedArrayList2 = parcel.createTypedArrayList(ResultRecord.CREATOR);
                        boolean l3 = l(createTypedArrayList2);
                        parcel2.writeNoException();
                        parcel2.writeInt(l3 ? 1 : 0);
                        parcel2.writeTypedList(createTypedArrayList2);
                        return true;
                    default:
                        return super.onTransact(i3, parcel, parcel2, i16);
                }
            }
            parcel2.writeString("com.tencent.mobileqq.sharepanel.launcher.ipc.ISharePanelIPCParam");
            return true;
        }
    }

    boolean D4(ResultRecord resultRecord) throws RemoteException;

    boolean G0() throws RemoteException;

    boolean J(List<ResultRecord> list, String str) throws RemoteException;

    boolean i0() throws RemoteException;

    boolean l(List<ResultRecord> list) throws RemoteException;

    Bitmap y2() throws RemoteException;
}
