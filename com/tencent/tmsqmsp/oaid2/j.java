package com.tencent.tmsqmsp.oaid2;

import android.os.IBinder;
import android.os.Parcel;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;
import com.tencent.tmsqmsp.oaid2.i;

/* compiled from: P */
/* loaded from: classes26.dex */
public class j implements k {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public IBinder f380820a;

    public j(IBinder iBinder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) iBinder);
        } else {
            this.f380820a = iBinder;
        }
    }

    @Override // com.tencent.tmsqmsp.oaid2.k
    public void a(i iVar) {
        i.a aVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) iVar);
            return;
        }
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            OaidMonitor.writeParcelToken(obtain, "com.hihonor.cloudservice.oaid.IOAIDService");
            if (iVar != null) {
                aVar = (i.a) iVar;
            } else {
                aVar = null;
            }
            obtain.writeStrongBinder(aVar);
            OaidMonitor.binderTransact(this.f380820a, 3, obtain, obtain2, 0);
            obtain2.readException();
        } catch (Exception unused) {
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
        return this.f380820a;
    }

    @Override // com.tencent.tmsqmsp.oaid2.k
    public void b(i iVar) {
        i.a aVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) iVar);
            return;
        }
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            OaidMonitor.writeParcelToken(obtain, "com.hihonor.cloudservice.oaid.IOAIDService");
            if (iVar != null) {
                aVar = (i.a) iVar;
            } else {
                aVar = null;
            }
            obtain.writeStrongBinder(aVar);
            OaidMonitor.binderTransact(this.f380820a, 2, obtain, obtain2, 0);
            obtain2.readException();
        } catch (Exception unused) {
        } finally {
            OaidMonitor.parcelRecycle(obtain2);
            OaidMonitor.parcelRecycle(obtain);
        }
    }
}
