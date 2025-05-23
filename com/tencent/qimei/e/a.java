package com.tencent.qimei.e;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;

/* compiled from: P */
/* loaded from: classes22.dex */
public interface a extends IInterface {

    /* compiled from: P */
    /* renamed from: com.tencent.qimei.e.a$a, reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    public static abstract class AbstractBinderC9316a extends Binder implements a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int f343241a = 0;

        /* compiled from: P */
        /* renamed from: com.tencent.qimei.e.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes22.dex */
        public static class C9317a implements a {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            public IBinder f343242a;

            public C9317a(IBinder iBinder) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) iBinder);
                } else {
                    this.f343242a = iBinder;
                }
            }

            @Override // com.tencent.qimei.e.a
            public String a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    return (String) iPatchRedirector.redirect((short) 4, (Object) this);
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.asus.msa.SupplementaryDID.IDidAidlInterface");
                    OaidMonitor.binderTransact(this.f343242a, 3, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                    return readString;
                } catch (Throwable unused) {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                    return "";
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    return (IBinder) iPatchRedirector.redirect((short) 3, (Object) this);
                }
                return this.f343242a;
            }

            @Override // com.tencent.qimei.e.a
            public boolean b() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                boolean z16 = true;
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.asus.msa.SupplementaryDID.IDidAidlInterface");
                    OaidMonitor.binderTransact(this.f343242a, 1, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() == 0) {
                        z16 = false;
                    }
                } catch (Exception unused) {
                } catch (Throwable th5) {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                    throw th5;
                }
                OaidMonitor.parcelRecycle(obtain2);
                OaidMonitor.parcelRecycle(obtain);
                return z16;
            }

            @Override // com.tencent.qimei.e.a
            public String f() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                    return (String) iPatchRedirector.redirect((short) 5, (Object) this);
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    OaidMonitor.writeParcelToken(obtain, "com.asus.msa.SupplementaryDID.IDidAidlInterface");
                    OaidMonitor.binderTransact(this.f343242a, 5, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                    return readString;
                } catch (Throwable unused) {
                    OaidMonitor.parcelRecycle(obtain2);
                    OaidMonitor.parcelRecycle(obtain);
                    return "";
                }
            }
        }
    }

    String a();

    boolean b();

    String f();
}
