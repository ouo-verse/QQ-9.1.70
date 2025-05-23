package com.tencent.mobileqq.springhb.config;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.freesia.BaseConfigParser;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import java.nio.charset.StandardCharsets;

/* loaded from: classes18.dex */
public class SpringHbCommonConfProcessor extends BaseConfigParser<a> {
    static IPatchRedirector $redirector_;

    public SpringHbCommonConfProcessor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static a d() {
        return (a) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("spring_common_config");
    }

    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    @NonNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public a defaultConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (a) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return new a();
    }

    @Override // com.tencent.freesia.BaseConfigParser
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void doOnConfigUpdate(@Nullable a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("SpringHb_SpringHbCommonConfProcessor", 2, String.format("onUpdate %s", aVar));
        }
        super.doOnConfigUpdate(aVar);
        com.tencent.mobileqq.springhb.entry.worker.b.f289157a.g(false);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0044 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0045  */
    @Override // com.tencent.freesia.BaseConfigParser
    @NonNull
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public a parse(@NonNull byte[] bArr) {
        a aVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (a) iPatchRedirector.redirect((short) 4, (Object) this, (Object) bArr);
        }
        if (bArr.length > 0) {
            try {
                String str = new String(bArr, StandardCharsets.UTF_8);
                if (QLog.isColorLevel()) {
                    QLog.i("SpringHb_SpringHbCommonConfProcessor", 2, String.format("onParsed %s", str));
                }
                aVar = a.e(str);
            } catch (Exception e16) {
                QLog.e("SpringHb_SpringHbCommonConfProcessor", 1, e16, new Object[0]);
            }
            if (aVar == null) {
                return aVar;
            }
            return new a();
        }
        aVar = null;
        if (aVar == null) {
        }
    }
}
