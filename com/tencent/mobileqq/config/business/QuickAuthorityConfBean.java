package com.tencent.mobileqq.config.business;

import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import oicq.wlogin_sdk.tools.util;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes10.dex */
public class QuickAuthorityConfBean {

    /* renamed from: a, reason: collision with root package name */
    public int f202467a = 0;

    /* renamed from: b, reason: collision with root package name */
    public int f202468b = 0;

    /* renamed from: c, reason: collision with root package name */
    public int f202469c = 1;

    /* renamed from: d, reason: collision with root package name */
    public int f202470d = 0;

    /* renamed from: e, reason: collision with root package name */
    public int f202471e = 1;

    /* renamed from: f, reason: collision with root package name */
    public ConcurrentHashMap<String, String> f202472f = new ConcurrentHashMap<>(10);

    public static QuickAuthorityConfBean a(String str) {
        final boolean z16;
        QuickAuthorityConfBean quickAuthorityConfBean = new QuickAuthorityConfBean();
        if (str == null) {
            return quickAuthorityConfBean;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            quickAuthorityConfBean.f202467a = jSONObject.optInt("kCheckSignatureSwitch", 0);
            quickAuthorityConfBean.f202468b = jSONObject.optInt("kDisableChooseSwitch", 0);
            quickAuthorityConfBean.f202469c = jSONObject.optInt("kShowKickDialog", 1);
            quickAuthorityConfBean.f202470d = jSONObject.optInt("kFDHookSwitch", 0);
            quickAuthorityConfBean.f202471e = jSONObject.optInt("kWtloginPowTest", 1);
            JSONObject optJSONObject = jSONObject.optJSONObject("kSignatureList");
            if (optJSONObject != null) {
                Iterator keys = optJSONObject.keys();
                while (keys.hasNext()) {
                    String str2 = (String) keys.next();
                    String optString = optJSONObject.optString(str2);
                    if (!TextUtils.isEmpty(optString)) {
                        quickAuthorityConfBean.f202472f.put(str2, optString);
                        if (QLog.isColorLevel()) {
                            QLog.d("QuickAuthorityConfProcessor", 2, "package: ", str2, " signature:", optString);
                        }
                    }
                }
            }
            QLog.d("QuickAuthorityConfProcessor", 2, "confBean = " + quickAuthorityConfBean.toString());
            if (quickAuthorityConfBean.f202471e == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.config.business.QuickAuthorityConfBean.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        util.save_pow_test(BaseApplication.getContext(), z16);
                        if (QLog.isColorLevel()) {
                            QLog.d("QuickAuthorityConfProcessor", 2, "pow_test ", Boolean.valueOf(z16));
                        }
                    } catch (Throwable th5) {
                        QLog.e("QuickAuthorityConfProcessor", 2, th5, new Object[0]);
                    }
                }
            });
            return quickAuthorityConfBean;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("QuickAuthorityConfProcessor", 1, "parse e:", e16.toString());
                return null;
            }
            return null;
        }
    }

    public String toString() {
        StringBuilder sb5 = new StringBuilder(20);
        sb5.append("kCheckSignatureSwitch:");
        sb5.append(this.f202467a);
        sb5.append(" kDisableChooseSwitch:");
        sb5.append(this.f202468b);
        sb5.append(" signatureMaps:");
        sb5.append(this.f202472f.size());
        sb5.append(" fdSwitch:");
        sb5.append(this.f202470d);
        sb5.append(" wtloginPowTest:");
        sb5.append(this.f202471e);
        return sb5.toString();
    }
}
