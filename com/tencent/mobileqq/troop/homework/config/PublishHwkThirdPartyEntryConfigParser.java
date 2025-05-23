package com.tencent.mobileqq.troop.homework.config;

import androidx.annotation.NonNull;
import com.tencent.freesia.BaseConfigParser;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import java.nio.charset.StandardCharsets;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes19.dex */
public class PublishHwkThirdPartyEntryConfigParser extends BaseConfigParser<a> {
    static IPatchRedirector $redirector_;

    public PublishHwkThirdPartyEntryConfigParser() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static a c() {
        a aVar = (a) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("100599");
        if (aVar != null) {
            return aVar;
        }
        return new a();
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
    @NonNull
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public a parse(@NonNull byte[] bArr) {
        JSONObject jSONObject;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (a) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bArr);
        }
        JSONObject jSONObject2 = null;
        try {
            jSONObject = new JSONObject(new String(bArr, StandardCharsets.UTF_8));
        } catch (JSONException e16) {
            e = e16;
        }
        try {
            if (QLog.isColorLevel()) {
                QLog.d("PublishHwkThirdPartyEntryConfigParser", 2, "parse:" + new String(bArr));
            }
        } catch (JSONException e17) {
            e = e17;
            jSONObject2 = jSONObject;
            QLog.e("PublishHwkThirdPartyEntryConfigParser", 1, e, new Object[0]);
            jSONObject = jSONObject2;
            return a.e(jSONObject);
        }
        return a.e(jSONObject);
    }

    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    public void onSend(@NonNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
            return;
        }
        super.onSend(str);
        if (QLog.isColorLevel()) {
            QLog.d("PublishHwkThirdPartyEntryConfigParser", 2, "onSend:" + str);
        }
    }
}
