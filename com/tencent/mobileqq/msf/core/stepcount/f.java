package com.tencent.mobileqq.msf.core.stepcount;

import android.hardware.SensorManager;
import android.support.annotation.NonNull;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qmethod.pandoraex.monitor.SensorMonitor;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* compiled from: P */
/* loaded from: classes15.dex */
public class f implements com.tencent.mobileqq.msf.core.stepcount.b {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: b, reason: collision with root package name */
    private static final String f250020b = "StepCounterManager";

    /* renamed from: c, reason: collision with root package name */
    private static volatile com.tencent.mobileqq.msf.core.stepcount.b f250021c;

    /* renamed from: a, reason: collision with root package name */
    private MsfCore f250022a;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private static final f f250023a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(IjkMediaPlayer.FFP_PROP_INT64_TRAFFIC_STATISTIC_BYTE_COUNT);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f250023a = new f(null);
            }
        }

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* synthetic */ f(a aVar) {
        this();
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
    }

    public static f c() {
        return b.f250023a;
    }

    private void d() {
        BaseApplication context = BaseApplication.getContext();
        if (context != null) {
            SensorManager sensorManager = (SensorManager) context.getSystemService(WebRTCSDK.PRIVILEGE_SENSOR);
            if (sensorManager != null && SensorMonitor.getDefaultSensor(sensorManager, 19) != null) {
                QLog.d(f250020b, 1, "enable refactored step counter");
                f250021c = new com.tencent.mobileqq.msf.core.stepcount.a(context);
                return;
            }
            return;
        }
        QLog.d(f250020b, 1, "init step counter failed");
    }

    @Override // com.tencent.mobileqq.msf.core.stepcount.b
    public void a(String str, ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str, (Object) toServiceMsg);
        } else if (f250021c != null) {
            f250021c.a(str, toServiceMsg);
        }
    }

    @Override // com.tencent.mobileqq.msf.core.stepcount.b
    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else if (f250021c != null) {
            f250021c.b();
        }
    }

    f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            d();
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void b(String str, @NonNull ToServiceMsg toServiceMsg) {
        if (StepCounterConstants.CMD_UPDATE_CONFIG.equals(toServiceMsg.getServiceCmd())) {
            e.a().a(toServiceMsg);
        } else {
            c().a(str, toServiceMsg);
        }
    }

    @Override // com.tencent.mobileqq.msf.core.stepcount.b
    public void a(MsfCore msfCore, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, msfCore, Boolean.valueOf(z16));
            return;
        }
        this.f250022a = msfCore;
        if (f250021c != null) {
            f250021c.a(this.f250022a, z16);
        }
    }

    @Override // com.tencent.mobileqq.msf.core.stepcount.b
    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else if (f250021c != null) {
            f250021c.a();
        }
    }
}
