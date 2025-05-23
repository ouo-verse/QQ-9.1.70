package com.tencent.mobileqq.util;

import android.os.Bundle;
import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.mobileqq.app.LocaleManager;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qmmkv.v2.MMKVOptionEntityV2;
import com.tencent.mobileqq.servlet.LoginVerifyServlet;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import mqq.app.MobileQQ;
import mqq.observer.BusinessObserver;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0016\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\t\u001a\u00020\u0006\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/util/s;", "", "", IProfileCardConst.KEY_FROM_TYPE, "Lcom/tencent/mobileqq/util/q;", "callback", "", "d", "c", "b", "<init>", "()V", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class s {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final s f306795a = new s();

    s() {
    }

    private final void d(int fromType, final q callback) {
        QLog.d("CountryCodeManager", 1, "requestCountryCode fromType: " + fromType);
        LoginVerifyServlet.l(fromType, new BusinessObserver() { // from class: com.tencent.mobileqq.util.r
            @Override // mqq.observer.BusinessObserver
            public final void onReceive(int i3, boolean z16, Bundle bundle) {
                s.e(q.this, i3, z16, bundle);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(q callback, int i3, boolean z16, Bundle bundle) {
        boolean z17;
        Intrinsics.checkNotNullParameter(callback, "$callback");
        if (!z16) {
            QLog.e("CountryCodeManager", 1, "requestCountryCode fail!!!");
            callback.onResult("86", LocaleManager.MOBILE_COUNTRY_CODE_CN_STR);
            return;
        }
        byte[] byteArray = bundle.getByteArray("data");
        if (byteArray == null) {
            QLog.e("CountryCodeManager", 1, "extraData is null!!!");
            callback.onResult("86", LocaleManager.MOBILE_COUNTRY_CODE_CN_STR);
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(new String(byteArray, Charsets.UTF_8));
            int optInt = jSONObject.optInt("retcode", -1);
            String optString = jSONObject.optString(HippyReporter.EXTRA_KEY_REPORT_ERRMSG, "");
            Intrinsics.checkNotNullExpressionValue(optString, "codeJson.optString(COUNTRY_CODE_KEY_ERROR_MSG, \"\")");
            if (optInt != 0) {
                QLog.e("CountryCodeManager", 1, "requestCountryCode failed code: " + optInt + " errorMsg: " + optString);
                callback.onResult("86", LocaleManager.MOBILE_COUNTRY_CODE_CN_STR);
                return;
            }
            String optString2 = jSONObject.optString("code", "86");
            Intrinsics.checkNotNullExpressionValue(optString2, "codeJson.optString(COUNT\u2026DE, COUNTRY_CODE_DEFAULT)");
            String optString3 = jSONObject.optString("abbr");
            Intrinsics.checkNotNullExpressionValue(optString3, "codeJson.optString(COUNTRY_CODE_KEY_COUNTRY_SHORT)");
            boolean z18 = false;
            if (optString2.length() == 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (!z17) {
                if (optString3.length() == 0) {
                    z18 = true;
                }
                if (!z18) {
                    callback.onResult(optString2, optString3);
                    MMKVOptionEntityV2 fromV2 = QMMKV.fromV2(MobileQQ.sMobileQQ, "common_mmkv_configurations");
                    Intrinsics.checkNotNullExpressionValue(fromV2, "fromV2(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
                    fromV2.putString("country_code_key", optString2);
                    fromV2.putString("country_short_key", optString3);
                    QLog.d("CountryCodeManager", 1, "requestCountryCode success code: " + optString2 + " countryShort: " + optString3);
                    return;
                }
            }
            QLog.e("CountryCodeManager", 1, "requestCountryCode response code or short is null!!!");
            callback.onResult("86", LocaleManager.MOBILE_COUNTRY_CODE_CN_STR);
        } catch (Exception e16) {
            callback.onResult("86", LocaleManager.MOBILE_COUNTRY_CODE_CN_STR);
            QLog.e("CountryCodeManager", 1, "requestCountryCode json error: " + e16);
        }
    }

    public final void b() {
        QLog.d("CountryCodeManager", 1, "clearCountryCodeCache");
        MMKVOptionEntityV2 fromV2 = QMMKV.fromV2(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(fromV2, "fromV2(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
        fromV2.putString("country_code_key", "");
        fromV2.putString("country_short_key", "");
    }

    public final void c(int fromType, @NotNull q callback) {
        boolean z16;
        Intrinsics.checkNotNullParameter(callback, "callback");
        MMKVOptionEntityV2 fromV2 = QMMKV.fromV2(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(fromV2, "fromV2(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
        String string = fromV2.getString("country_code_key", "");
        String string2 = fromV2.getString("country_short_key", "");
        boolean z17 = false;
        if (string != null && string.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            if (string2 == null || string2.length() == 0) {
                z17 = true;
            }
            if (!z17) {
                QLog.d("CountryCodeManager", 1, "getCountryCode in mmkv code : " + string + ", countryShort: " + string2);
                callback.onResult(string, string2);
                return;
            }
        }
        d(fromType, callback);
    }
}
