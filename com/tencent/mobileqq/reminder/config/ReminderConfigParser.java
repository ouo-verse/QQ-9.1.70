package com.tencent.mobileqq.reminder.config;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.freesia.BaseConfigParser;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.reminder.api.IQQReminderOfTianshuService;
import com.tencent.mobileqq.vas.comm.api.IGameCenterUnitedConfigApi;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* loaded from: classes18.dex */
public class ReminderConfigParser extends BaseConfigParser<com.tencent.mobileqq.reminder.data.a> {
    static IPatchRedirector $redirector_;

    public ReminderConfigParser() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    @NonNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public com.tencent.mobileqq.reminder.data.a defaultConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (com.tencent.mobileqq.reminder.data.a) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return new com.tencent.mobileqq.reminder.data.a();
    }

    @Override // com.tencent.freesia.BaseConfigParser
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void doOnConfigUpdate(com.tencent.mobileqq.reminder.data.a aVar) {
        AppRuntime peekAppRuntime;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVar);
            return;
        }
        QLog.i("ReminderConfigProcessor", 1, "[onUpdate]");
        if (aVar != null && (peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime()) != null) {
            ((IQQReminderOfTianshuService) peekAppRuntime.getRuntimeService(IQQReminderOfTianshuService.class, "all")).updateRequestInterval(aVar.mRequestIntervalInSec, 1);
        }
    }

    @Override // com.tencent.freesia.BaseConfigParser
    @Nullable
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public com.tencent.mobileqq.reminder.data.a parse(@NonNull byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.mobileqq.reminder.data.a) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bArr);
        }
        return (com.tencent.mobileqq.reminder.data.a) ((IGameCenterUnitedConfigApi) QRoute.api(IGameCenterUnitedConfigApi.class)).getConfig(IGameCenterUnitedConfigApi.GAMEPLAT_BUBBLE_REQUEST_INTERVAL, defaultConfig());
    }
}
