package com.tencent.mobileqq.upgrade;

import androidx.annotation.NonNull;
import com.tencent.freesia.BaseConfigParser;
import com.tencent.freesia.IConfigData;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes20.dex */
public class UpgradeConfigTypeParser extends BaseConfigParser<a> {
    static IPatchRedirector $redirector_;

    /* loaded from: classes20.dex */
    public static class a implements IConfigData {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private int f306169d;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.f306169d = 0;
            }
        }

        public static a a(JSONObject jSONObject) {
            a aVar = new a();
            if (jSONObject == null) {
                return aVar;
            }
            aVar.f306169d = jSONObject.optInt("platform", 0);
            return aVar;
        }

        public int b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return this.f306169d;
        }
    }

    public UpgradeConfigTypeParser() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static int c() {
        a aVar = (a) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("upgrade_config_use_platform_type");
        if (aVar == null) {
            return 0;
        }
        return aVar.b();
    }

    public static boolean d() {
        if (c() == 1) {
            return true;
        }
        return false;
    }

    public static boolean e() {
        if (c() == 2) {
            return true;
        }
        return false;
    }

    public static boolean f() {
        int c16 = c();
        if (c16 != 3 && c16 != 0) {
            return false;
        }
        return true;
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
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public a parse(@NonNull byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (a) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bArr);
        }
        a aVar = new a();
        try {
            String str = new String(bArr);
            QLog.d("UpgradeConfigTypeParser", 1, "parse: \n" + str);
            return a.a(new JSONObject(str));
        } catch (JSONException e16) {
            QLog.e("UpgradeConfigTypeParser", 1, "parse failed!", e16);
            return aVar;
        }
    }
}
