package com.tencent.mobileqq.qrscan.earlydown;

import android.os.Looper;
import com.tencent.chirp.ChirpWrapper;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.earlydownload.xmldata.XmlData;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qrscan.api.IQRScanAbilityApi;
import com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadConstants;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.LinkedList;
import mk2.a;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes17.dex */
public class ChirpSoHandler extends com.tencent.mobileqq.earlydownload.handler.b implements mk2.a {
    static IPatchRedirector $redirector_;
    private AppRuntime E;
    private boolean F;
    private LinkedList<a.InterfaceC10793a> G;

    public ChirpSoHandler(AppRuntime appRuntime) {
        super("qq.android.system.chirp", appRuntime);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appRuntime);
            return;
        }
        this.F = false;
        this.G = new LinkedList<>();
        this.E = appRuntime;
    }

    @Override // com.tencent.mobileqq.earlydownload.handler.b
    public void I(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, z16);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("ChirpSoHandler", 2, "restartDownload " + z16);
        }
        if (!this.F) {
            this.F = z16;
        }
        if (o() != null && o().loadState == 2) {
            if (QLog.isColorLevel()) {
                QLog.d("ChirpSoHandler", 2, "is in downloading");
                return;
            }
            return;
        }
        super.I(z16);
    }

    @Override // mk2.a
    public void a(a.InterfaceC10793a interfaceC10793a) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) interfaceC10793a);
            return;
        }
        synchronized (this.G) {
            if (!this.G.contains(interfaceC10793a)) {
                this.G.add(interfaceC10793a);
            }
        }
    }

    @Override // mk2.a
    public void b(a.InterfaceC10793a interfaceC10793a) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) interfaceC10793a);
            return;
        }
        synchronized (this.G) {
            this.G.remove(interfaceC10793a);
        }
    }

    @Override // com.tencent.mobileqq.earlydownload.handler.b
    public boolean e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return true;
    }

    @Override // com.tencent.mobileqq.earlydownload.handler.b
    public void i(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("ChirpSoHandler", 2, "onDownload success " + str);
        }
        Runnable runnable = new Runnable(str) { // from class: com.tencent.mobileqq.qrscan.earlydown.ChirpSoHandler.1
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f276617d;

            {
                this.f276617d = str;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ChirpSoHandler.this, (Object) str);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    ChirpWrapper.f(this.f276617d);
                }
            }
        };
        if (Looper.getMainLooper() == Looper.myLooper()) {
            ThreadManager.getSubThreadHandler().post(runnable);
        } else {
            runnable.run();
        }
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.qrscan.earlydown.ChirpSoHandler.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ChirpSoHandler.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    synchronized (ChirpSoHandler.this.G) {
                        Iterator it = ChirpSoHandler.this.G.iterator();
                        while (it.hasNext()) {
                            ((a.InterfaceC10793a) it.next()).B1();
                        }
                    }
                    return;
                }
                iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        });
    }

    @Override // com.tencent.mobileqq.earlydownload.handler.b
    public int n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return ((IQRScanAbilityApi) QRoute.api(IQRScanAbilityApi.class)).getEarlyDownBusId(101);
    }

    @Override // com.tencent.mobileqq.earlydownload.handler.b
    public Class<? extends XmlData> p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Class) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return ChirpSoData.class;
    }

    @Override // com.tencent.mobileqq.earlydownload.handler.b
    public String q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return PreDownloadConstants.DEPARTMENT_PRD;
    }

    @Override // com.tencent.mobileqq.earlydownload.handler.b
    public String t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "actEarlyChirpSo";
    }

    @Override // com.tencent.mobileqq.earlydownload.handler.b
    public boolean z() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        if (this.F) {
            ((IQRScanAbilityApi) QRoute.api(IQRScanAbilityApi.class)).setTalkbackSwitch();
            if (QLog.isColorLevel()) {
                QLog.d("ChirpSoHandler", 2, "isNetValid2Download by user " + AppSetting.f99565y);
            }
            return AppSetting.f99565y;
        }
        ((IQRScanAbilityApi) QRoute.api(IQRScanAbilityApi.class)).setTalkbackSwitch();
        if (QLog.isColorLevel()) {
            QLog.d("ChirpSoHandler", 2, "isNetValid2Download by startup " + AppSetting.f99565y);
        }
        if (AppSetting.f99565y && super.z()) {
            return true;
        }
        return false;
    }
}
