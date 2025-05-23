package com.tencent.mobileqq.qqgift.api.impl;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqgift.api.IQQGiftUtil;
import com.tencent.mobileqq.qqgift.data.service.d;
import com.tencent.mobileqq.vasgift.countdown.CountDownController;
import com.tencent.mobileqq.vasgift.countdown.CountDownInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.ipc.IPCConst;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes16.dex */
public class QQGiftUtilImpl implements IQQGiftUtil {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "IQQGiftUtilImpl";

    public QQGiftUtilImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.qqgift.api.IQQGiftUtil
    public boolean checkIsQQGiftUrl(String str, String str2, Intent intent) {
        JSONObject optJSONObject;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, this, str, str2, intent)).booleanValue();
        }
        try {
            optJSONObject = new JSONObject(str2).optJSONObject("options");
        } catch (JSONException e16) {
            QLog.e(TAG, 1, "checkIsQQGiftUrl throw e:" + e16.getMessage());
        }
        if (optJSONObject == null) {
            return false;
        }
        if (optJSONObject.optInt("isQQGiftRecharge", 0) != 1) {
            if (!optJSONObject.optString("openQQGiftH5", "0").equals("1")) {
                return false;
            }
        }
        return true;
    }

    @Override // com.tencent.mobileqq.qqgift.api.IQQGiftUtil
    public Intent getOpenQQGiftUrlIntent(Activity activity, String str, String str2, Intent intent, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Intent) iPatchRedirector.redirect((short) 3, this, activity, str, str2, intent, bundle);
        }
        bundle.remove("isTransparentTitle");
        bundle.remove(IPCConst.KEY_HIDE_LEFT_BUTTON);
        return new Intent(activity, (Class<?>) QQBrowserActivity.class);
    }

    @Override // com.tencent.mobileqq.qqgift.api.IQQGiftUtil
    public boolean isQQGiftCountDowning(d dVar, String str) {
        CountDownInfo countDownInfo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) dVar, (Object) str)).booleanValue();
        }
        CountDownController c16 = e43.a.d().c(str + "");
        if (c16 != null && dVar != null) {
            countDownInfo = c16.m().get(dVar.f264874d + "");
        } else {
            countDownInfo = null;
        }
        if (countDownInfo != null) {
            return true;
        }
        return false;
    }
}
