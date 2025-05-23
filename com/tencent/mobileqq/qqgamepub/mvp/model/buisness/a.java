package com.tencent.mobileqq.qqgamepub.mvp.model.buisness;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import com.tencent.common.config.AppSetting;
import com.tencent.gamecenter.wadl.biz.entity.WadlReportBuilder;
import com.tencent.gamecenter.wadl.biz.entity.WadlResult;
import com.tencent.gamecenter.wadl.biz.listener.WadlProxyServiceCallBackInterface;
import com.tencent.gamecenter.wadl.util.WadlProxyServiceUtil;
import com.tencent.hippy.qq.api.IHippySetting;
import com.tencent.hippy.qq.app.HippyQQPreloadEngine;
import com.tencent.hippy.qq.update.HippyQQConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqgamepub.api.IGamePubAccountMsgService;
import com.tencent.mobileqq.qqgamepub.api.IQQGameHippyApi;
import com.tencent.mobileqq.qqgamepub.data.GmpEnterInfoReq;
import com.tencent.mobileqq.qqgamepub.data.QQGameMsgInfo;
import com.tencent.mobileqq.qqgamepub.mvp.presenter.base.b;
import com.tencent.mobileqq.qqgamepub.mvp.presenter.buisness.QQGameHippyBasePresenter;
import com.tencent.mobileqq.qqgamepub.utils.GamePubAccountHelper;
import com.tencent.mobileqq.qqgamepub.utils.e;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.IQWalletApi;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes16.dex */
public class a implements kh2.a, WadlProxyServiceCallBackInterface {
    static IPatchRedirector $redirector_;
    public long C;
    public long D;
    public long E;
    public int F;
    public long G;
    public boolean H;
    private int I;
    private int J;
    private QQGameHippyBasePresenter K;

    /* renamed from: d, reason: collision with root package name */
    protected e f264625d;

    /* renamed from: e, reason: collision with root package name */
    private IGamePubAccountMsgService f264626e;

    /* renamed from: f, reason: collision with root package name */
    protected long f264627f;

    /* renamed from: h, reason: collision with root package name */
    public long f264628h;

    /* renamed from: i, reason: collision with root package name */
    public long f264629i;

    /* renamed from: m, reason: collision with root package name */
    public long f264630m;

    public a(b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) bVar);
            return;
        }
        this.H = false;
        this.I = 0;
        this.J = 0;
        o(bVar);
    }

    public void a(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
            return;
        }
        e eVar = this.f264625d;
        if (eVar != null) {
            eVar.a(str);
        }
    }

    public long b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Long) iPatchRedirector.redirect((short) 19, (Object) this)).longValue();
        }
        return this.G;
    }

    public IGamePubAccountMsgService c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (IGamePubAccountMsgService) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        if (this.f264626e == null) {
            synchronized (this) {
                if (this.f264626e == null) {
                    this.f264626e = (IGamePubAccountMsgService) MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IGamePubAccountMsgService.class, "");
                }
            }
        }
        return this.f264626e;
    }

    public int d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Integer) iPatchRedirector.redirect((short) 14, (Object) this)).intValue();
        }
        return this.F;
    }

    public int e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Integer) iPatchRedirector.redirect((short) 18, (Object) this)).intValue();
        }
        return this.J;
    }

    public int f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Integer) iPatchRedirector.redirect((short) 16, (Object) this)).intValue();
        }
        return this.I;
    }

    public void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this);
            return;
        }
        this.H = false;
        WadlProxyServiceUtil.getProxyService().registerWadlServiceCallBack(this);
        WadlProxyServiceUtil.getProxyService().doQueryAllTask();
    }

    public void h(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str, (Object) str2);
        } else {
            this.f264625d = new e(str, str2);
        }
    }

    public void i(Activity activity, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) activity, (Object) bundle);
            return;
        }
        Intent intent = activity.getIntent();
        if (intent != null) {
            if (intent.hasExtra("startTime")) {
                if (bundle == null) {
                    this.f264628h = intent.getLongExtra("startTime", 0L);
                } else {
                    this.f264628h = SystemClock.elapsedRealtime();
                }
                if (this.f264628h > 0) {
                    this.C = SystemClock.elapsedRealtime() - this.f264628h;
                }
            }
            if (intent.hasExtra("clickTime")) {
                this.f264629i = intent.getLongExtra("clickTime", 0L);
            }
            if (intent.hasExtra("unreadNum")) {
                this.F = intent.getIntExtra("unreadNum", 0);
            }
            if (intent.hasExtra("lastReadTime")) {
                this.G = intent.getLongExtra("lastReadTime", 0L);
            }
        }
    }

    public void j(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        } else {
            if (this.f264627f < 0) {
                return;
            }
            long elapsedRealtime = (SystemClock.elapsedRealtime() - this.f264627f) / 1000;
            if (elapsedRealtime > 0) {
                GamePubAccountHelper.r(str).setOperId("206471").setModuleType("76916").setExt(17, String.valueOf(elapsedRealtime)).report();
            }
        }
    }

    public void k(String str, String str2) {
        long j3;
        int i3;
        int i16;
        long j16;
        long j17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str, (Object) str2);
            return;
        }
        e eVar = this.f264625d;
        if (eVar != null) {
            eVar.c();
            long d16 = this.f264625d.d("onLoadHippyEnd") - this.f264625d.d("loadHippy");
            HippyQQPreloadEngine A = this.K.A();
            if (A != null) {
                HashMap<String, Long> loadStepsTime = A.getLoadStepsTime();
                if (loadStepsTime == null) {
                    return;
                }
                j3 = 0;
                if (loadStepsTime.containsKey(HippyQQConstants.STEP_NAME_LOAD_LIBRARY_START)) {
                    j16 = loadStepsTime.get(HippyQQConstants.STEP_NAME_LOAD_LIBRARY_START).longValue();
                } else {
                    j16 = 0;
                }
                if (loadStepsTime.containsKey(HippyQQConstants.STEP_NAME_LOAD_LIBRARY_END)) {
                    j17 = loadStepsTime.get(HippyQQConstants.STEP_NAME_LOAD_LIBRARY_END).longValue();
                } else {
                    j17 = 0;
                }
                if (j17 >= j16) {
                    j3 = j17 - j16;
                }
            } else {
                j3 = -1;
            }
            if (A != null) {
                boolean isPredraw = A.isPredraw();
                if (A.isPreloaded()) {
                    i16 = 2;
                } else {
                    i16 = 0;
                }
                i3 = i16 | (isPredraw ? 1 : 0);
            } else {
                i3 = -1;
            }
            long d17 = this.f264625d.d("initViewEnd") - this.f264627f;
            int moduleVersion = ((IHippySetting) QRoute.api(IHippySetting.class)).getModuleVersion(((IQQGameHippyApi) QRoute.api(IQQGameHippyApi.class)).getGamePaHippyModuleName());
            WadlReportBuilder r16 = GamePubAccountHelper.r(this.K.z());
            r16.setModuleType("76918").setOperId("206612").setExt(25, String.valueOf(i3)).setExt(26, moduleVersion + "").setExt(27, str).setExt(28, str2).setExt(29, this.E + "").setExt(30, this.D + "").setExt(31, this.f264630m + "").setExt(32, d17 + "").setExt(33, d16 + "").setExt(34, this.C + "").setExt(47, "perf").setExt(35, j3 + "");
            List<Long> b16 = this.f264625d.b();
            if (b16 != null && b16.size() > 0) {
                String e16 = this.f264625d.e();
                r16.setExt(36, e16);
                int i17 = 0;
                while (i17 < b16.size()) {
                    r16.setExt(37 + i17, b16.get(i17) + "");
                    i17++;
                    e16 = e16;
                }
                StringBuilder sb5 = new StringBuilder();
                sb5.append("gamePubAccount prefData={");
                sb5.append("isPreLoadHipyy=");
                sb5.append(i3);
                sb5.append("|");
                sb5.append("version=");
                sb5.append(AppSetting.f99554n);
                sb5.append("|");
                sb5.append("hippyVersion=");
                sb5.append(moduleVersion);
                sb5.append("|");
                sb5.append("showHippyCostTime=");
                sb5.append(this.E);
                sb5.append("|");
                sb5.append("showHippyFirstScreenTime=");
                sb5.append(this.D);
                sb5.append("|");
                sb5.append("AppLoadHippyCostTime=");
                sb5.append(this.f264630m);
                sb5.append("|");
                sb5.append("initViewCostTime=");
                sb5.append(d17);
                sb5.append("|");
                sb5.append("loadHippyCostTime=");
                sb5.append(d16);
                sb5.append("|");
                sb5.append("mEnterQQGamePubCostTime=");
                sb5.append(this.C);
                sb5.append("|");
                sb5.append("loadLibCostTime=");
                sb5.append(j3);
                sb5.append("|");
                sb5.append("pointTime=(");
                sb5.append(e16);
                sb5.append(")");
                sb5.append("}");
                QLog.d("QQGameHippyModel", 1, sb5);
            }
            r16.report();
        }
    }

    public void l(QQGameMsgInfo qQGameMsgInfo, int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, this, qQGameMsgInfo, Integer.valueOf(i3), str);
        } else {
            GamePubAccountHelper.K(qQGameMsgInfo, i3, str);
        }
    }

    public void m(int i3, QQGameMsgInfo qQGameMsgInfo, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, this, Integer.valueOf(i3), qQGameMsgInfo, str);
        } else {
            GamePubAccountHelper.K(qQGameMsgInfo, i3, str);
        }
    }

    public void n(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, j3);
        } else {
            this.E = j3;
        }
    }

    public void o(b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) bVar);
        } else {
            this.K = (QQGameHippyBasePresenter) bVar;
        }
    }

    @Override // com.tencent.gamecenter.wadl.biz.listener.WadlProxyServiceCallBackInterface
    public void onQueryCallback(ArrayList<WadlResult> arrayList) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) arrayList);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("QQGameHippyModel", 1, "---->onQueryCallback isGetGameEnter=" + this.H);
        }
        if (this.H) {
            return;
        }
        try {
            long w3 = GamePubAccountHelper.w(arrayList);
            if (QLog.isColorLevel()) {
                QLog.d("QQGameHippyModel", 1, "---> get lastGameAppID=" + w3);
            }
            this.H = true;
            if (GamePubAccountHelper.C()) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            ((IQWalletApi) QRoute.api(IQWalletApi.class)).servletSendRequest(new GmpEnterInfoReq(w3, 1, i3), this.K);
        } catch (Throwable th5) {
            QLog.d("QQGameHippyModel", 1, "---->onQueryCallback getLastGameAppID fail:" + th5.getMessage());
        }
    }

    @Override // com.tencent.gamecenter.wadl.biz.listener.WadlProxyServiceCallBackInterface
    public void onQueryCallbackVia(ArrayList<WadlResult> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) arrayList);
        }
    }

    @Override // com.tencent.gamecenter.wadl.biz.listener.WadlProxyServiceCallBackInterface
    public void onWadlTaskStatusChanged(WadlResult wadlResult) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) wadlResult);
        }
    }

    public void p(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, j3);
        } else {
            this.f264627f = j3;
        }
    }

    public void q(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, i3);
        } else {
            this.F = i3;
        }
    }

    public void r(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, i3);
        } else {
            this.J = i3;
        }
    }

    public void s(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, i3);
        } else {
            this.I = i3;
        }
    }

    public void t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this);
        } else {
            WadlProxyServiceUtil.getProxyService().unRegisterWadlServiceCallBack(this);
        }
    }

    public void u(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, z16);
            return;
        }
        this.f264630m = SystemClock.elapsedRealtime() - this.f264628h;
        QLog.d("QQGameHippyModel", 1, "click GamePubAccount to onLoad success:" + z16 + ",cost:" + this.f264630m);
    }

    public void v(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, j3);
        } else if (j3 > 0) {
            long j16 = this.f264628h;
            if (j3 > j16) {
                this.D = j3 - j16;
            }
        }
    }

    public void w(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, j3);
        } else {
            this.E = j3 - this.f264628h;
        }
    }
}
