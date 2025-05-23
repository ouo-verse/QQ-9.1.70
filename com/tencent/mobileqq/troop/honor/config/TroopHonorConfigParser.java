package com.tencent.mobileqq.troop.honor.config;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.freesia.BaseConfigParser;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.honor.api.ITroopHonorService;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import java.nio.charset.StandardCharsets;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* loaded from: classes19.dex */
public class TroopHonorConfigParser extends BaseConfigParser<b> {
    static IPatchRedirector $redirector_;

    public TroopHonorConfigParser() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static b d() {
        b bVar = (b) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("100795");
        if (bVar == null) {
            b bVar2 = new b();
            bVar2.f297519f = true;
            return bVar2;
        }
        return bVar;
    }

    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    @NonNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public b defaultConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (b) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        QLog.d("TroopHonorConfigParser", 1, "ret default config");
        b bVar = new b();
        bVar.f297519f = true;
        return bVar;
    }

    @Override // com.tencent.freesia.BaseConfigParser
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void doOnConfigUpdate(@Nullable b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) bVar);
            return;
        }
        QLog.d("TroopHonorConfigParser", 1, "onUpdate, newConf = " + bVar);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null && bVar != null) {
            ((ITroopHonorService) peekAppRuntime.getRuntimeService(ITroopHonorService.class, "")).updateConfig(bVar, false);
        }
    }

    @Override // com.tencent.freesia.BaseConfigParser
    @NonNull
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public b parse(@NonNull byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (b) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bArr);
        }
        b f16 = b.f(new String(bArr, StandardCharsets.UTF_8));
        if (f16 == null) {
            QLog.d("TroopHonorConfigParser", 1, "parse config null");
            return defaultConfig();
        }
        return f16;
    }
}
