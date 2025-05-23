package com.tencent.mobileqq.observer;

import android.os.Bundle;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import mqq.observer.BusinessObserver;

/* compiled from: P */
/* loaded from: classes9.dex */
public class QZoneObserver implements BusinessObserver {
    static IPatchRedirector $redirector_;

    public QZoneObserver() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, z16);
        }
    }

    protected void b(boolean z16, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Boolean.valueOf(z16), bundle);
        }
    }

    protected void c(boolean z16, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Boolean.valueOf(z16), bundle);
        }
    }

    protected void d(boolean z16, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, Boolean.valueOf(z16), bundle);
        }
    }

    protected void e(boolean z16, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), bundle);
        }
    }

    protected void f(boolean z16, boolean z17, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Boolean.valueOf(z17), Long.valueOf(j3));
        }
    }

    protected void g(boolean z16, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), bundle);
        }
    }

    protected void h(boolean z16, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Boolean.valueOf(z16), bundle);
        }
    }

    protected void i(boolean z16, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Boolean.valueOf(z16), bundle);
        }
    }

    protected void j(boolean z16, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Boolean.valueOf(z16), bundle);
        }
    }

    protected void k(boolean z16, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Boolean.valueOf(z16), bundle);
        }
    }

    protected void l(boolean z16, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Boolean.valueOf(z16), bundle);
        }
    }

    @Override // mqq.observer.BusinessObserver
    public void onReceive(int i3, boolean z16, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, Integer.valueOf(i3), Boolean.valueOf(z16), bundle);
            return;
        }
        if (i3 == 1000) {
            boolean z17 = bundle.getBoolean(QCircleDaTongConstant.ElementParamValue.NEW);
            long j3 = bundle.getLong("notify_type", 0L);
            if (QLog.isColorLevel()) {
                if (((j3 >>> 17) & 1) != 0) {
                    QLog.d("ZebraAlbum.UndealCount.QZoneObserver", 2, "onReceive QZONE_GET_UNREAD hasNew: " + z17 + "type:" + j3 + "and then call onGetQZoneFeedCountFin");
                }
                QLog.d("UndealCount.UndealCount.QZoneObserver", 2, "qzone redtypeinfo:onReceive QZONE_GET_UNREAD hasNew: " + z17 + ",type:" + j3 + " and then call onGetQZoneFeedCountFin");
            }
            f(z16, z17, j3);
            return;
        }
        if (i3 == 1001) {
            ThreadManagerV2.executeOnSubThread(new Runnable(z16, bundle) { // from class: com.tencent.mobileqq.observer.QZoneObserver.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ boolean f254470d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ Bundle f254471e;

                {
                    this.f254470d = z16;
                    this.f254471e = bundle;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, QZoneObserver.this, Boolean.valueOf(z16), bundle);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        QZoneObserver.this.g(this.f254470d, this.f254471e);
                    }
                }
            });
            return;
        }
        if (i3 == 1002) {
            e(z16, bundle);
            return;
        }
        if (i3 == 1003) {
            i(z16, bundle);
            return;
        }
        if (i3 == 1004) {
            j(z16, bundle);
            return;
        }
        if (i3 == 1005) {
            k(z16, bundle);
            return;
        }
        if (i3 == 1006) {
            c(z16, bundle);
            return;
        }
        if (i3 == 1007) {
            ThreadManagerV2.executeOnSubThread(new Runnable(z16, bundle) { // from class: com.tencent.mobileqq.observer.QZoneObserver.2
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ boolean f254472d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ Bundle f254473e;

                {
                    this.f254472d = z16;
                    this.f254473e = bundle;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, QZoneObserver.this, Boolean.valueOf(z16), bundle);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        QZoneObserver.this.h(this.f254472d, this.f254473e);
                    }
                }
            });
            return;
        }
        if (i3 == 1008) {
            l(z16, bundle);
            return;
        }
        if (i3 == 1009) {
            b(z16, bundle);
        } else if (i3 == 1010) {
            d(z16, bundle);
        } else if (i3 == 1999) {
            a(bundle.getBoolean("is_selected_key", false));
        }
    }
}
