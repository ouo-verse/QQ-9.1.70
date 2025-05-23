package com.tencent.mobileqq.springhb.entry.worker;

import androidx.annotation.NonNull;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.springhb.config.SpringHbCommonConfProcessor;
import com.tencent.mobileqq.springhb.entry.model.BaseActivityData;
import com.tencent.mobileqq.springhb.entry.model.MainActivityData;
import com.tencent.mobileqq.springhb.entry.model.MsgTabBannerData;
import com.tencent.mobileqq.springhb.entry.model.OnGrabActivityData;
import com.tencent.mobileqq.springhb.entry.model.PendantData;
import com.tencent.mobileqq.springhb.entry.model.UserData;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes18.dex */
public class c implements com.tencent.mobileqq.springhb.entry.b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final d f289163a;

    /* renamed from: b, reason: collision with root package name */
    private final e f289164b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f289165c;

    public c(d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) dVar);
        } else {
            this.f289163a = dVar;
            this.f289164b = dVar.l();
        }
    }

    private long n() {
        return this.f289163a.n().I();
    }

    @Override // com.tencent.mobileqq.springhb.entry.b
    public void a(BaseActivityData baseActivityData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) baseActivityData);
            return;
        }
        int i3 = 2;
        if (QLog.isColorLevel()) {
            QLog.d("UI_SpringFestivalTaskCallback", 2, "onPendantHide actData = " + baseActivityData);
        }
        if (baseActivityData.getType() != 2) {
            i3 = 1;
        }
        this.f289163a.p().g(i3);
    }

    @Override // com.tencent.mobileqq.springhb.entry.b
    public void b(@NonNull MainActivityData mainActivityData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) mainActivityData);
        } else {
            QLog.d("UI_SpringFestivalTaskCallback", 1, "\u2014\u2014\u2014\u2014> onMainActivityRealStart");
            this.f289163a.m().d(mainActivityData);
        }
    }

    @Override // com.tencent.mobileqq.springhb.entry.b
    public void c(BaseActivityData baseActivityData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) baseActivityData);
            return;
        }
        this.f289163a.u(baseActivityData);
        UserData.UserDataItem O = this.f289163a.n().O(baseActivityData.f289093id);
        if (QLog.isColorLevel()) {
            QLog.d("UI_SpringFestivalTaskCallback", 2, "onActivityAboutToOver isMiniAppDesktopOpened = " + this.f289164b.f() + ",userDataItem.hasClickCloseBtn = " + O.hasClickCloseBtn + ",springApi.getHongBaoCtrlV2().mState = " + this.f289163a.k().f289415m + ",actData = " + baseActivityData);
        }
        if (this.f289164b.f()) {
            this.f289163a.r().o(true);
            return;
        }
        if (baseActivityData.type == 2) {
            if (this.f289163a.k().f289415m != 2 && this.f289163a.k().f289415m != 3) {
                if (this.f289163a.k().f289415m == -1) {
                    o(baseActivityData);
                    return;
                } else {
                    if (this.f289163a.k().f289415m == 4) {
                        if (QLog.isColorLevel()) {
                            QLog.d("UI_SpringFestivalTaskCallback", 2, "onActivityAboutToOver call onActivityRealStart");
                        }
                        j(System.currentTimeMillis(), baseActivityData);
                        return;
                    }
                    return;
                }
            }
            this.f289163a.k().p0(true);
        }
    }

    @Override // com.tencent.mobileqq.springhb.entry.b
    public void d(MainActivityData mainActivityData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) mainActivityData);
        } else {
            this.f289163a.m().b(mainActivityData);
        }
    }

    @Override // com.tencent.mobileqq.springhb.entry.b
    public void e(MsgTabBannerData msgTabBannerData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) msgTabBannerData);
        } else {
            QLog.d("UI_SpringFestivalTaskCallback", 2, "onMsgTabBannerHide");
            this.f289163a.q().A();
        }
    }

    @Override // com.tencent.mobileqq.springhb.entry.b
    public void f(BaseActivityData baseActivityData) {
        PendantData pendantData;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) baseActivityData);
            return;
        }
        UserData.UserDataItem O = this.f289163a.n().O(baseActivityData.f289093id);
        boolean V = this.f289163a.n().V();
        int i3 = 2;
        if (QLog.isColorLevel()) {
            QLog.d("UI_SpringFestivalTaskCallback", 2, "onPendantShow  userDataItem.hasClickCloseBtn = " + O.hasClickCloseBtn + ",isPendantShowSwitchOn = " + V + ",actData = " + baseActivityData);
        }
        if (this.f289163a.t() || this.f289163a.s()) {
            return;
        }
        if (!this.f289164b.e()) {
            this.f289163a.r().o(true);
            return;
        }
        if (!O.hasClickCloseBtn && V && (pendantData = baseActivityData.pendantData) != null) {
            if (baseActivityData.getType() != 2) {
                i3 = 1;
            }
            this.f289163a.p().p(i3, pendantData);
        }
    }

    @Override // com.tencent.mobileqq.springhb.entry.b
    public void g(@NonNull MsgTabBannerData msgTabBannerData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) msgTabBannerData);
            return;
        }
        QLog.d("UI_SpringFestivalTaskCallback", 2, "onMsgTabBannerShow, msgTabBannerData = " + msgTabBannerData);
        this.f289163a.q().B(msgTabBannerData);
    }

    @Override // com.tencent.mobileqq.springhb.entry.b
    public void h(long j3, BaseActivityData baseActivityData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Long.valueOf(j3), baseActivityData);
            return;
        }
        this.f289163a.u(baseActivityData);
        UserData.UserDataItem O = this.f289163a.n().O(baseActivityData.f289093id);
        if (QLog.isColorLevel()) {
            QLog.d("UI_SpringFestivalTaskCallback", 2, "onActivityStart userDataItem.hasClickCloseBtn = " + O.hasClickCloseBtn + ",actData = " + baseActivityData);
        }
        if (this.f289163a.t() || this.f289163a.s()) {
            return;
        }
        if (!this.f289164b.e()) {
            this.f289163a.r().o(true);
            if (this.f289163a.n().X() && !SpringHbCommonConfProcessor.d().c("NotCloseMiniAppInSys", false) && baseActivityData.type == 2 && this.f289164b.f()) {
                ((IMiniAppService) QRoute.api(IMiniAppService.class)).updateMiniAppList(100);
                return;
            }
            return;
        }
        if (baseActivityData.type == 2) {
            this.f289165c = true;
            this.f289163a.i().h().l();
            if (QLog.isColorLevel()) {
                QLog.d("UI_SpringFestivalTaskCallback", 2, "onActivityStart statusTitle.h = " + this.f289163a.i().g());
            }
            long n3 = n();
            if (QLog.isColorLevel()) {
                QLog.d("UI_SpringFestivalTaskCallback", 2, "onActivityStart current = " + n3 + ",taskTime = " + j3 + ",delay = " + baseActivityData.getPeakDelayMs());
            }
            long peakDelayMs = (j3 + baseActivityData.getPeakDelayMs()) - n3;
            if (QLog.isColorLevel()) {
                QLog.d("UI_SpringFestivalTaskCallback", 2, "onActivityStart showPrepareCountDown current = " + n3 + ",prepareCountDownMs = " + peakDelayMs);
            }
            if (this.f289163a.n().Y()) {
                int M = this.f289163a.n().M();
                peakDelayMs /= M;
                if (QLog.isColorLevel()) {
                    QLog.d("UI_SpringFestivalTaskCallback", 2, "onActivityStart showPrepareCountDown SpeedUp prepareCountDownMs = " + peakDelayMs + ", ratio = " + M);
                }
            }
            this.f289163a.k().a1((OnGrabActivityData) baseActivityData, peakDelayMs);
        }
    }

    @Override // com.tencent.mobileqq.springhb.entry.b
    public void i(@NonNull MainActivityData mainActivityData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) mainActivityData);
        } else {
            this.f289163a.m().c(mainActivityData);
        }
    }

    @Override // com.tencent.mobileqq.springhb.entry.b
    public void j(long j3, BaseActivityData baseActivityData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Long.valueOf(j3), baseActivityData);
            return;
        }
        this.f289163a.u(baseActivityData);
        UserData.UserDataItem O = this.f289163a.n().O(baseActivityData.f289093id);
        if (QLog.isColorLevel()) {
            QLog.d("UI_SpringFestivalTaskCallback", 2, "onActivityRealStart userDataItem.hasClickCloseBtn = " + O.hasClickCloseBtn + ",actData = " + baseActivityData);
        }
        if (this.f289163a.t() || this.f289163a.s()) {
            return;
        }
        if (!this.f289164b.e()) {
            this.f289163a.r().o(true);
            return;
        }
        int i3 = baseActivityData.type;
        if (i3 == 2) {
            this.f289165c = true;
            this.f289163a.i().h().l();
            QLog.d("UI_SpringFestivalTaskCallback", 2, "onActivityRealStart statusTitle.h = " + this.f289163a.i().g());
            this.f289163a.k().d1((OnGrabActivityData) baseActivityData);
        } else if (i3 == 1) {
            o(baseActivityData);
            PendantData pendantData = baseActivityData.pendantData;
            if (pendantData != null) {
                this.f289163a.p().p(1, pendantData);
            }
        }
        this.f289163a.m().a();
    }

    @Override // com.tencent.mobileqq.springhb.entry.b
    public void k(BaseActivityData baseActivityData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) baseActivityData);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("UI_SpringFestivalTaskCallback", 2, "onActivityOver isMiniAppDesktopOpened = " + this.f289164b.f() + "actData = " + baseActivityData);
        }
        this.f289163a.k().s0();
        this.f289165c = false;
        this.f289163a.u(null);
        this.f289163a.o().e();
    }

    @Override // com.tencent.mobileqq.springhb.entry.b
    public void l(BaseActivityData baseActivityData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) baseActivityData);
            return;
        }
        QLog.d("UI_SpringFestivalTaskCallback", 2, "onBreathLightHide actData = " + baseActivityData);
        this.f289163a.h().m();
    }

    @Override // com.tencent.mobileqq.springhb.entry.b
    public void m(@NonNull BaseActivityData baseActivityData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) baseActivityData);
            return;
        }
        UserData.UserDataItem O = this.f289163a.n().O(baseActivityData.f289093id);
        QLog.d("UI_SpringFestivalTaskCallback", 2, "onBreathLightShow, actData = " + baseActivityData + ",userDataItem.hasDisplayBreathLight = " + O.hasDisplayBreathLight);
        this.f289163a.h().n(baseActivityData.breathLightData, O);
    }

    public void o(BaseActivityData baseActivityData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) baseActivityData);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("UI_SpringFestivalTaskCallback", 2, "notifyBrushEnd actData = " + baseActivityData);
        }
        if (baseActivityData == null) {
            QLog.d("UI_SpringFestivalTaskCallback", 1, "notifyBrushEnd return");
        } else {
            this.f289165c = false;
        }
    }

    public void p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("UI_SpringFestivalTaskCallback", 2, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        }
        this.f289165c = false;
    }
}
