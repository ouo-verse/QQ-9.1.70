package com.tencent.mobileqq.app.automator;

import android.annotation.TargetApi;
import android.content.SharedPreferences;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.app.AutomatorObserver;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.startup.control.MicroStep;
import com.tencent.mobileqq.startup.task.ce;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.Constants;

/* compiled from: P */
/* loaded from: classes11.dex */
public class Automator extends BusinessHandler implements b {
    static IPatchRedirector $redirector_;
    public ConcurrentHashMap<String, Long> C;
    public volatile boolean D;
    public QQAppInterface E;
    private AutomatorImpl F;
    private HashMap<Integer, com.tencent.mobileqq.service.profile.a> G;

    /* renamed from: d, reason: collision with root package name */
    public long f195305d;

    /* renamed from: e, reason: collision with root package name */
    public int f195306e;

    /* renamed from: f, reason: collision with root package name */
    public SharedPreferences f195307f;

    /* renamed from: h, reason: collision with root package name */
    public boolean f195308h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f195309i;

    /* renamed from: m, reason: collision with root package name */
    public boolean f195310m;

    public Automator(QQAppInterface qQAppInterface) {
        super(qQAppInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
            return;
        }
        this.f195306e = 1;
        this.f195308h = false;
        this.f195309i = false;
        this.f195310m = false;
        this.C = new ConcurrentHashMap<>(16);
        this.D = false;
        this.G = new LinkedHashMap();
        this.E = qQAppInterface;
        this.F = new AutomatorImpl(this, this);
    }

    public com.tencent.mobileqq.service.profile.a D2(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (com.tencent.mobileqq.service.profile.a) iPatchRedirector.redirect((short) 11, (Object) this, i3);
        }
        return this.G.get(Integer.valueOf(i3));
    }

    @Override // com.tencent.mobileqq.app.automator.b
    public void E() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this);
        } else {
            this.F.E();
        }
    }

    public HashMap<Integer, com.tencent.mobileqq.service.profile.a> E2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (HashMap) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.G;
    }

    public int F2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Integer) iPatchRedirector.redirect((short) 24, (Object) this)).intValue();
        }
        return this.F.g();
    }

    public boolean G2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this)).booleanValue();
        }
        if (!ce.INSTANCE.d()) {
            return false;
        }
        LinearGroup f16 = this.F.f();
        if (f16 != null) {
            return h.c(f16);
        }
        return true;
    }

    public boolean H2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Boolean) iPatchRedirector.redirect((short) 18, (Object) this)).booleanValue();
        }
        return true;
    }

    public void I2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
        } else {
            this.F.k();
        }
    }

    public void J2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
        } else {
            notifyUI(0, true, null);
        }
    }

    public void K2(boolean z16, long j3, boolean z17) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z18 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, Boolean.valueOf(z16), Long.valueOf(j3), Boolean.valueOf(z17));
            return;
        }
        if (this.f195307f != null && z16) {
            com.tencent.mobileqq.friend.utils.b.d().i(false);
        }
        if (j3 != 0) {
            this.appRuntime.getPreferences().edit().putLong(Constants.Key.SvcRegister_timeStamp.toString(), j3).commit();
        }
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("refreshAllList isListChanged=");
            sb5.append(z16);
            sb5.append(",timeStamp=");
            sb5.append(j3);
            sb5.append(",accInfoPref!=null ");
            if (this.f195307f == null) {
                z18 = false;
            }
            sb5.append(z18);
            QLog.d("QQInitHandler", 2, sb5.toString());
        }
        if (z16 || z17) {
            StringBuilder sb6 = new StringBuilder();
            sb6.append("{");
            if (z16) {
                i3 = 6;
            } else {
                i3 = 7;
            }
            sb6.append(i3);
            sb6.append("}");
            M2(h.a(this, sb6.toString()));
        }
    }

    public void L2(int i3, com.tencent.mobileqq.service.profile.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, i3, (Object) aVar);
        } else {
            this.G.put(Integer.valueOf(i3), aVar);
        }
    }

    @TargetApi(9)
    public void M2(AsyncStep asyncStep) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) asyncStep);
        } else {
            this.F.i(asyncStep);
        }
    }

    @Override // com.tencent.mobileqq.app.automator.f
    public boolean Q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return ((Boolean) iPatchRedirector.redirect((short) 28, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.app.automator.f
    public boolean S() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return ((Boolean) iPatchRedirector.redirect((short) 27, (Object) this)).booleanValue();
        }
        return QLog.isColorLevel();
    }

    @Override // com.tencent.mobileqq.app.automator.d
    public AsyncStep S1(b bVar, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return (AsyncStep) iPatchRedirector.redirect((short) 26, (Object) this, (Object) bVar, (Object) str);
        }
        return h.a(this, str);
    }

    @Override // com.tencent.mobileqq.app.automator.b
    @TargetApi(9)
    public void a2(AsyncStep asyncStep) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) asyncStep);
        } else {
            this.F.a2(asyncStep);
        }
    }

    public int getInActionLoginB() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Integer) iPatchRedirector.redirect((short) 16, (Object) this)).intValue();
        }
        return 1;
    }

    @Override // com.tencent.mobileqq.app.automator.b
    public String getTag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return (String) iPatchRedirector.redirect((short) 25, (Object) this);
        }
        return this.F.getTag();
    }

    @Override // com.tencent.mobileqq.app.automator.b
    public void i2(AsyncStep[] asyncStepArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) asyncStepArr);
        } else {
            this.F.i2(asyncStepArr);
        }
    }

    public boolean isInRealActionLoginB() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Boolean) iPatchRedirector.redirect((short) 17, (Object) this)).booleanValue();
        }
        return !com.tencent.mobileqq.startup.a.f289669j;
    }

    public boolean isSyncNormalMsgFinish() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Boolean) iPatchRedirector.redirect((short) 19, (Object) this)).booleanValue();
        }
        return true;
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Class) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return AutomatorObserver.class;
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("QQInitHandler", 2, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        }
        this.D = true;
        this.F.h();
        this.f195305d = 0L;
        MicroStep.INSTANCE.a();
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, toServiceMsg, fromServiceMsg, obj);
        } else {
            new RuntimeException("WTF");
        }
    }

    public void updateLastRegisterProxyRespTime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this);
        } else {
            notifyUI(4, true, null);
        }
    }
}
