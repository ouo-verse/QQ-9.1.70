package com.tencent.avcore.camera.observe;

import android.os.Handler;
import android.os.Looper;
import com.tencent.avcore.util.AVCoreLog;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Observable;
import java.util.Observer;

/* compiled from: P */
/* loaded from: classes3.dex */
public class CameraObserver implements Observer {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    Handler f77463d;

    public CameraObserver() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f77463d = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(Object obj) {
        byte[] bArr;
        if (obj == null) {
            return;
        }
        Object[] objArr = (Object[]) obj;
        int intValue = ((Integer) objArr[0]).intValue();
        if (AVCoreLog.isDevelopLevel()) {
            AVCoreLog.printAllUserLog("CameraObserver", "onUpdate, msgType[" + intValue + "]");
        }
        long j3 = 0;
        switch (intValue) {
            case 1:
                if (objArr.length > 1) {
                    boolean booleanValue = ((Boolean) objArr[1]).booleanValue();
                    if (objArr.length > 2) {
                        j3 = ((Long) objArr[2]).longValue();
                    }
                    h(j3, booleanValue);
                    return;
                }
                g();
                return;
            case 2:
                boolean booleanValue2 = ((Boolean) objArr[1]).booleanValue();
                int intValue2 = ((Integer) objArr[2]).intValue();
                if (objArr.length > 3) {
                    j3 = ((Long) objArr[3]).longValue();
                }
                c(j3, booleanValue2, intValue2);
                return;
            case 3:
                if (objArr.length > 1) {
                    j3 = ((Long) objArr[1]).longValue();
                }
                f(j3);
                return;
            case 4:
                boolean booleanValue3 = ((Boolean) objArr[1]).booleanValue();
                if (objArr.length > 2) {
                    j3 = ((Long) objArr[2]).longValue();
                }
                b(j3, booleanValue3);
                return;
            case 5:
                i();
                return;
            case 6:
                e(((Boolean) objArr[1]).booleanValue());
                return;
            case 7:
                try {
                    bArr = (byte[]) objArr[1];
                } catch (Exception e16) {
                    e16.printStackTrace();
                    bArr = null;
                }
                j(bArr);
                return;
            case 8:
                d(((Boolean) objArr[1]).booleanValue());
                return;
            default:
                return;
        }
    }

    protected void b(long j3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Long.valueOf(j3), Boolean.valueOf(z16));
        }
    }

    protected void c(long j3, boolean z16, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Long.valueOf(j3), Boolean.valueOf(z16), Integer.valueOf(i3));
        }
    }

    protected void d(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, z16);
        }
    }

    protected void e(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, z16);
        }
    }

    protected void f(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, j3);
        }
    }

    @Deprecated
    protected void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        }
    }

    protected void h(long j3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Long.valueOf(j3), Boolean.valueOf(z16));
        }
    }

    protected void i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        }
    }

    protected void j(byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) bArr);
        }
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) observable, obj);
            return;
        }
        Looper mainLooper = Looper.getMainLooper();
        if (Thread.currentThread() != mainLooper.getThread()) {
            if (this.f77463d == null) {
                this.f77463d = new Handler(mainLooper);
            }
            this.f77463d.post(new Runnable(obj) { // from class: com.tencent.avcore.camera.observe.CameraObserver.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ Object f77464d;

                {
                    this.f77464d = obj;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) CameraObserver.this, obj);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        CameraObserver.this.k(this.f77464d);
                    } else {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                }
            });
            return;
        }
        k(obj);
    }
}
