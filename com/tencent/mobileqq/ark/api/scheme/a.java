package com.tencent.mobileqq.ark.api.scheme;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.api.IArkService;
import com.tencent.mobileqq.ark.module.h;
import com.tencent.mobileqq.ark.p;
import com.tencent.mobileqq.ark.q;
import com.tencent.mobileqq.ark.util.i;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes11.dex */
public class a implements h {

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.ark.api.scheme.a$a, reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    class C7416a implements q {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f199141a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f199142b;

        C7416a(String str, String str2) {
            this.f199141a = str;
            this.f199142b = str2;
        }

        @Override // com.tencent.mobileqq.ark.q
        public void a(boolean z16, String str, String str2, Object obj) {
            if (z16) {
                ((a) obj).e(str2, this.f199141a, this.f199142b, str);
                BaseApplication.getContext().getSharedPreferences("arkappid2pkname_entry", 4).edit().putString(str2, str).commit();
            } else {
                QLog.i("ArkApp", 1, "ArkAppSchemeCenter.AppSchemeHandler.get packagename failed.");
            }
        }
    }

    private boolean d(Context context, String str) {
        if (InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), str.trim(), 0) == null) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean e(String str, String str2, String str3, String str4) {
        BaseActivity baseActivity = BaseActivity.sTopActivity;
        if (baseActivity == null) {
            return false;
        }
        String str5 = "platform=qq_m&current_uin=$OPID$&launchfrom=Ark&openid=$OPID$&atoken=$AT$&ptoken=$PT$&big_brother_source_key=" + str3;
        String str6 = null;
        try {
            Map<String, Object> b16 = i.b(new JSONObject(str2));
            Object obj = b16.get("url");
            if (obj != null && (obj instanceof String)) {
                str6 = (String) obj;
            }
            Object obj2 = b16.get("data");
            if (obj2 != null && (obj2 instanceof Map)) {
                StringBuilder sb5 = new StringBuilder();
                for (Map.Entry entry : ((Map) obj2).entrySet()) {
                    Object key = entry.getKey();
                    Object value = entry.getValue();
                    if (key != null && (key instanceof String) && value != null) {
                        sb5.append(ContainerUtils.FIELD_DELIMITER);
                        sb5.append(key);
                        sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
                        sb5.append(value.toString());
                    }
                }
                str5 = str5 + ((Object) sb5);
            }
        } catch (JSONException unused) {
            if (QLog.isColorLevel()) {
                QLog.i("ArkApp", 1, "ArkAppSchemeCenter.AppSchemeHandler.jsonParseError");
            }
        }
        String str7 = str5;
        if (!d(baseActivity, str4)) {
            if (!TextUtils.isEmpty(str6)) {
                Intent intent = new Intent(baseActivity, (Class<?>) QQBrowserActivity.class);
                intent.putExtra("url", str6);
                com.tencent.mobileqq.ark.d.b(intent, str3);
                intent.putExtra("fromArkAppDownload", true);
                baseActivity.startActivity(intent);
            } else if (QLog.isColorLevel()) {
                QLog.i("ArkApp", 1, "ArkAppSchemeCenter.AppSchemeHandler, download url is empty");
            }
        } else {
            f(baseActivity, str, str7, str4, "0");
        }
        return true;
    }

    private void f(Context context, String str, String str2, String str3, String str4) {
        eq2.a aVar = new eq2.a();
        int i3 = 268435456;
        try {
            int parseInt = Integer.parseInt(str4);
            if ((parseInt & 67108864) == 67108864) {
                i3 = 335544320;
            }
            if ((parseInt & 536870912) == 536870912) {
                i3 |= 536870912;
            }
            if ((parseInt & 4194304) == 4194304) {
                i3 |= 4194304;
            }
        } catch (Exception unused) {
        }
        aVar.d(c(), context, str, str2, str3, i3);
    }

    @Override // com.tencent.mobileqq.ark.module.h
    public boolean a(String str, String str2, JSONObject jSONObject, long j3, String str3, String str4) {
        BaseActivity baseActivity;
        if (j3 != 0 || (baseActivity = BaseActivity.sTopActivity) == null || TextUtils.isEmpty(str)) {
            return false;
        }
        String str5 = "biz_src_jc_ark";
        if (jSONObject != null) {
            str5 = jSONObject.optString("businessId", "biz_src_jc_ark");
        }
        String string = BaseApplication.getContext().getSharedPreferences("arkappid2pkname_entry", 4).getString(str, null);
        if (string != null && string.length() > 0 && d(baseActivity, string)) {
            e(str, str2, str5, string);
            return true;
        }
        QQAppInterface c16 = c();
        if (c16 == null) {
            QLog.i("ArkApp", 1, "ArkAppSchemeCenter.navigate app is null.");
            return false;
        }
        p sso = ((IArkService) c16.getRuntimeService(IArkService.class, "all")).getSSO();
        if (sso == null) {
            QLog.i("ArkApp", 1, "ArkAppSchemeCenter.navigate sso is null.");
            return false;
        }
        sso.b(str, this, new C7416a(str2, str5));
        return true;
    }

    protected QQAppInterface c() {
        AppRuntime runtime = BaseApplicationImpl.sApplication.getRuntime();
        if (runtime instanceof QQAppInterface) {
            return (QQAppInterface) runtime;
        }
        return null;
    }
}
