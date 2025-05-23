package com.tencent.mobileqq.activity.qqsettingme;

import android.view.View;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.qqsettingme.api.IQQSettingMeApi;
import com.tencent.mobileqq.activity.recent.DrawerFrame;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.proavatar.QQProAvatarView;
import com.tencent.mobileqq.profilecard.api.IProfileCardApi;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.utils.ProfileCardConst;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes10.dex */
public class n extends com.tencent.mobileqq.processor.c {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name */
    private QQProAvatarView f185012h;

    public n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.processor.c, com.tencent.mobileqq.processor.b
    public void c(AppRuntime appRuntime) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) appRuntime);
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("fillData mAvatarView is null? :");
        if (this.f185012h == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        sb5.append(z16);
        QLog.d("QQSettingMeAvatarProcessor", 1, sb5.toString());
        if (this.f185012h != null) {
            ((IQQSettingMeApi) QRoute.api(IQQSettingMeApi.class)).setAvatarDrawable(this.f185012h);
        }
    }

    @Override // com.tencent.mobileqq.processor.c, com.tencent.mobileqq.processor.b
    public void d(com.tencent.mobileqq.qqsettingme.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVar);
            return;
        }
        this.f185012h = (QQProAvatarView) aVar.f274439h.findViewById(R.id.unk);
        QLog.d("QQSettingMeAvatarProcessor", 1, "initViewBinder mAvatarView" + this.f185012h);
    }

    @Override // com.tencent.mobileqq.processor.c, com.tencent.mobileqq.processor.b
    public void onClick(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) view);
            return;
        }
        QBaseActivity qBaseActivity = this.f259741b.get();
        if (qBaseActivity == null) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("QQSettingMeAvatarProcessor", 2, "jumpToProfile");
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        AllInOne allInOne = new AllInOne(peekAppRuntime.getCurrentAccountUin(), 0);
        allInOne.lastActivity = 1;
        allInOne.profileEntryType = 8;
        allInOne.extras.putInt(ProfileCardConst.ENTER_PAGE_SOURCE_ID, 12);
        allInOne.extras.putInt(ProfileCardConst.ENTER_PAGE_SUB_SOURCE_ID, 121);
        ProfileUtils.openProfileCardForResult(qBaseActivity, allInOne, 1009);
        ((IProfileCardApi) QRoute.api(IProfileCardApi.class)).checkToCleanSettingMeRedPointGuide((QQAppInterface) peekAppRuntime);
        ReportController.o(peekAppRuntime, "CliOper", "", "", "0X8004033", "0X8004033", 0, 0, "", "", "", "");
        ReportController.o(peekAppRuntime, "CliOper", "", "", "0X80072D7", "0X80072D7", 0, 0, "", "", "", "");
        DrawerFrame.f185113z0 = com.tencent.mobileqq.qqsettingme.a.f274434i;
        if (view != null) {
            Object tag = view.getTag();
            if ((tag instanceof Boolean) && ((Boolean) tag).booleanValue()) {
                ReportController.o(peekAppRuntime, "CliOper", "", "", "0X8006726", "0X8006726", 0, 0, "", "", "", "");
            }
        }
        VideoReport.reportEvent("clck", view, null);
    }

    @Override // com.tencent.mobileqq.processor.c, com.tencent.mobileqq.processor.b
    public void onDestroy() {
        com.tencent.mobileqq.vas.b bVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        QLog.d("QQSettingMeAvatarProcessor", 1, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        this.f185012h = null;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null && (bVar = (com.tencent.mobileqq.vas.b) peekAppRuntime.getManager(QQManagerFactory.CHAT_AVATAR_PENDANT_MANAGER)) != null) {
            bVar.clear();
        }
        m23.b.b().g("setting");
    }

    @Override // com.tencent.mobileqq.processor.c, com.tencent.mobileqq.processor.b
    public String w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "d_avatar";
    }
}
