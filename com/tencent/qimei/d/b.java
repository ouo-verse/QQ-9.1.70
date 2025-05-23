package com.tencent.qimei.d;

import android.os.IBinder;
import android.os.Parcel;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qimei.d.a;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;

/* compiled from: P */
/* loaded from: classes22.dex */
public class b implements c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public IBinder f343223a;

    public b(IBinder iBinder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) iBinder);
        } else {
            this.f343223a = iBinder;
        }
    }

    @Override // com.tencent.qimei.d.c
    public void a(a aVar) {
        a.AbstractBinderC9315a abstractBinderC9315a;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) aVar);
            return;
        }
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            OaidMonitor.writeParcelToken(obtain, "com.hihonor.cloudservice.oaid.IOAIDService");
            if (aVar != null) {
                abstractBinderC9315a = (a.AbstractBinderC9315a) aVar;
            } else {
                abstractBinderC9315a = null;
            }
            obtain.writeStrongBinder(abstractBinderC9315a);
            OaidMonitor.binderTransact(this.f343223a, 2, obtain, obtain2, 0);
            obtain2.readException();
        } catch (Exception unused) {
        } catch (Throwable th5) {
            OaidMonitor.parcelRecycle(obtain2);
            OaidMonitor.parcelRecycle(obtain);
            throw th5;
        }
        OaidMonitor.parcelRecycle(obtain2);
        OaidMonitor.parcelRecycle(obtain);
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (IBinder) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.f343223a;
    }

    @Override // com.tencent.qimei.d.c
    public void b(a aVar) {
        a.AbstractBinderC9315a abstractBinderC9315a;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVar);
            return;
        }
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            OaidMonitor.writeParcelToken(obtain, "com.hihonor.cloudservice.oaid.IOAIDService");
            if (aVar != null) {
                abstractBinderC9315a = (a.AbstractBinderC9315a) aVar;
            } else {
                abstractBinderC9315a = null;
            }
            obtain.writeStrongBinder(abstractBinderC9315a);
            OaidMonitor.binderTransact(this.f343223a, 3, obtain, obtain2, 0);
            obtain2.readException();
        } catch (Exception unused) {
        } catch (Throwable th5) {
            OaidMonitor.parcelRecycle(obtain2);
            OaidMonitor.parcelRecycle(obtain);
            throw th5;
        }
        OaidMonitor.parcelRecycle(obtain2);
        OaidMonitor.parcelRecycle(obtain);
    }
}
