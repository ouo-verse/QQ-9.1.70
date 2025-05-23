package com.tencent.mobileqq.loginwelcome;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.luggage.wxa.yf.u;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.config.ai;
import com.tencent.mobileqq.config.l;
import com.tencent.mobileqq.loginwelcome.LoginWelcomeManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

/* loaded from: classes15.dex */
public class WelcomeConfigProcessor extends l<LoginWelcomeManager.n> {
    static IPatchRedirector $redirector_;

    public WelcomeConfigProcessor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.config.l
    @NonNull
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public LoginWelcomeManager.n migrateOldOrDefaultContent(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (LoginWelcomeManager.n) iPatchRedirector.redirect((short) 8, (Object) this, i3);
        }
        if (QLog.isColorLevel()) {
            QLog.d("WelcomeConfigProcessor", 2, "migrateOldOrDefaultContent");
        }
        return new LoginWelcomeManager.n();
    }

    @Override // com.tencent.mobileqq.config.l
    @Nullable
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public LoginWelcomeManager.n onParsed(ai[] aiVarArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (LoginWelcomeManager.n) iPatchRedirector.redirect((short) 4, (Object) this, (Object) aiVarArr);
        }
        if (QLog.isColorLevel()) {
            QLog.d("WelcomeConfigProcessor", 2, "onParsed :" + aiVarArr);
            if (aiVarArr != null) {
                for (ai aiVar : aiVarArr) {
                    if (aiVar != null) {
                        QLog.d("WelcomeConfigProcessor", 2, "onParsed item: " + aiVar.f202268b);
                    }
                }
            }
        }
        if (aiVarArr != null && aiVarArr.length > 0) {
            for (ai aiVar2 : aiVarArr) {
                if (aiVar2 != null && !TextUtils.isEmpty(aiVar2.f202268b)) {
                    try {
                        LoginWelcomeManager.n nVar = new LoginWelcomeManager.n();
                        JSONObject jSONObject = new JSONObject(aiVar2.f202268b);
                        if (jSONObject.has("popup_url")) {
                            nVar.f243102a = jSONObject.getString("popup_url");
                        }
                        if (jSONObject.has("fixed_entrance_url")) {
                            nVar.f243103b = jSONObject.getString("fixed_entrance_url");
                        }
                        if (jSONObject.has("request_interval")) {
                            nVar.f243104c = jSONObject.getInt("request_interval");
                        }
                        return nVar;
                    } catch (Throwable th5) {
                        QLog.e("WelcomeConfigProcessor", 1, th5, new Object[0]);
                    }
                }
            }
            return null;
        }
        return null;
    }

    @Override // com.tencent.mobileqq.config.l
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void onUpdate(LoginWelcomeManager.n nVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) nVar);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("WelcomeConfigProcessor", 2, "onUpdate");
        }
        if (nVar != null) {
            ((LoginWelcomeManager) BaseApplicationImpl.sApplication.getRuntime().getManager(QQManagerFactory.LOGIN_WELCOME_MANAGER)).G(nVar);
        }
    }

    @Override // com.tencent.mobileqq.config.l
    public Class<LoginWelcomeManager.n> clazz() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Class) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return LoginWelcomeManager.n.class;
    }

    @Override // com.tencent.mobileqq.config.l
    public boolean isNeedCompressed() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        return true;
    }

    @Override // com.tencent.mobileqq.config.l
    public boolean isNeedStoreLargeFile() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.config.l
    public int migrateOldVersion() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        if (QLog.isColorLevel()) {
            QLog.d("WelcomeConfigProcessor", 2, "migrateOldVersion");
            return 0;
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.config.l
    public void onReqFailed(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3);
        } else if (QLog.isColorLevel()) {
            QLog.d("WelcomeConfigProcessor", 2, "onReqFailed, code = " + i3);
        }
    }

    @Override // com.tencent.mobileqq.config.l
    public int type() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return u.CTRL_INDEX;
    }
}
