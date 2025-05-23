package com.tencent.mobileqq.zootopia.openid;

import android.text.TextUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.z1.base.openId.ZootopiaOpenIdResult;
import com.tencent.mobileqq.zplan.api.IZPlanMMKVApi;
import com.tencent.qphone.base.util.QLog;
import java.net.URLDecoder;
import java.net.URLEncoder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\n\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0001\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J \u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0002H\u0002J\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\f\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\r\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0005J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0005\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/zootopia/openid/h;", "", "", "uin", "keyPrefix", "Lcom/tencent/mobileqq/z1/base/openId/ZootopiaOpenIdResult;", "c", "result", "prefix", "", "f", "d", "a", "g", "e", "b", tl.h.F, "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public static final h f328624a = new h();

    h() {
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0050 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0051 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final ZootopiaOpenIdResult c(String uin, String keyPrefix) {
        boolean z16;
        String str;
        JSONObject jSONObject;
        boolean isBlank;
        String string = ((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).getString(keyPrefix + uin, "");
        if (QLog.isColorLevel()) {
            QLog.d("ZootopiaOpenIdSPUtil", 1, "from sp: " + string);
        }
        if (string != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(string);
            if (!isBlank) {
                z16 = false;
                if (!z16) {
                    return null;
                }
                try {
                    str = URLDecoder.decode(string, "UTF-8");
                } catch (Throwable th5) {
                    QLog.e("ZootopiaOpenIdSPUtil", 1, "decodeError", th5);
                    str = null;
                }
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                if (str != null) {
                    try {
                        jSONObject = new JSONObject(str);
                    } catch (Throwable th6) {
                        QLog.e("ZootopiaOpenIdSPUtil", 1, "getDataFromSPCache, json err", th6);
                        return null;
                    }
                } else {
                    jSONObject = null;
                }
                if (jSONObject == null) {
                    return null;
                }
                String optString = jSONObject.optString("uin", "");
                Intrinsics.checkNotNullExpressionValue(optString, "it.optString(ZootopiaOpenIdUtils.VALUE_UIN, \"\")");
                String optString2 = jSONObject.optString("openId", "");
                Intrinsics.checkNotNullExpressionValue(optString2, "it.optString(ZootopiaOpenIdUtils.VALUE_OPENID, \"\")");
                String optString3 = jSONObject.optString("token", "");
                Intrinsics.checkNotNullExpressionValue(optString3, "it.optString(ZootopiaOpe\u2026s.VALUE_ACCESS_TOKEN, \"\")");
                String optString4 = jSONObject.optString("payToken", "");
                Intrinsics.checkNotNullExpressionValue(optString4, "it.optString(ZootopiaOpe\u2026tils.VALUE_PAY_TOKEN, \"\")");
                return new ZootopiaOpenIdResult(optString, optString2, optString3, optString4, jSONObject.optLong("expiredTime", 0L), jSONObject.optLong("recordTime", 0L));
            }
        }
        z16 = true;
        if (!z16) {
        }
    }

    private final void f(String uin, ZootopiaOpenIdResult result, String prefix) {
        String str;
        boolean isBlank;
        JSONObject jSONObject = new JSONObject();
        boolean z16 = true;
        try {
            jSONObject.put("uin", uin);
            jSONObject.put("openId", result.getOpenId());
            jSONObject.put("payToken", result.getPayToken());
            jSONObject.put("token", result.getAccessToken());
            jSONObject.put("expiredTime", result.getExpiredTime());
            jSONObject.put("recordTime", result.getRecordTime());
            try {
                str = URLEncoder.encode(jSONObject.toString(), "UTF-8");
            } catch (Throwable th5) {
                QLog.e("ZootopiaOpenIdSPUtil", 1, "encodeError, ", th5);
                str = null;
            }
            if (str != null) {
                isBlank = StringsKt__StringsJVMKt.isBlank(str);
                if (!isBlank) {
                    z16 = false;
                }
            }
            if (z16) {
                return;
            }
            ((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).setString(prefix + uin, str);
        } catch (Throwable th6) {
            QLog.e("ZootopiaOpenIdSPUtil", 1, "saveData, json err, ", th6);
        }
    }

    public final void a(String uin) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        ((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).remove("openid_" + uin);
    }

    public final void b(String uin) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        ((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).remove("openid_silent_" + uin);
    }

    public final ZootopiaOpenIdResult d(String uin) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        return c(uin, "openid_");
    }

    public final ZootopiaOpenIdResult e(String uin) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        return c(uin, "openid_silent_");
    }

    public final void g(String uin, ZootopiaOpenIdResult result) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(result, "result");
        f(uin, result, "openid_");
    }

    public final void h(String uin, ZootopiaOpenIdResult result) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(result, "result");
        f(uin, result, "openid_silent_");
    }
}
