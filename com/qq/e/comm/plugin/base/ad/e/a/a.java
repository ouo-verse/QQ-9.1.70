package com.qq.e.comm.plugin.base.ad.e.a;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.qq.e.comm.StubVisitor;
import com.qq.e.comm.plugin.k.c;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;
import java.net.URLEncoder;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class a {
    public static boolean a(Context context, String str, String str2, String str3) {
        if (StringUtil.isEmpty(str3)) {
            return false;
        }
        Uri parse = Uri.parse(a(str3, (String) null, (String) null));
        if ("http".equalsIgnoreCase(parse.getScheme()) || "https".equalsIgnoreCase(parse.getScheme())) {
            return false;
        }
        return context.getPackageManager().resolveActivity(a(context, str, str2, parse), 65536) != null;
    }

    public static Intent a(Context context, String str, String str2, Uri uri) {
        Intent intent;
        if (uri == null) {
            if (StringUtil.isEmpty(str)) {
                intent = null;
            } else {
                intent = c.c(context, str);
                if (intent != null) {
                    intent.addFlags(268435456);
                }
            }
        } else {
            intent = new Intent();
            intent.setData(uri);
            intent.setAction(CommonConstant.ACTION.HWID_SCHEME_URL);
            intent.addFlags(268435456);
            if (!StringUtil.isEmpty(str)) {
                intent.setPackage(str);
                if (!StringUtil.isEmpty(str2)) {
                    intent.setClassName(str, str2);
                }
            }
        }
        Bundle customBundle = StubVisitor.getInstance().getCustomBundle();
        if (intent != null && customBundle != null) {
            intent.putExtras(customBundle);
        }
        return intent;
    }

    public static Intent a(String str, String str2, boolean z16) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            Intent intent = new Intent();
            try {
                intent.setData(Uri.parse(str2));
                intent.setAction(CommonConstant.ACTION.HWID_SCHEME_URL);
                intent.setPackage(str);
                Bundle customBundle = StubVisitor.getInstance().getCustomBundle();
                if (customBundle != null) {
                    intent.putExtras(customBundle);
                }
                if (z16) {
                    intent.addFlags(268435456);
                }
                return intent;
            } catch (Exception e16) {
                GDTLogger.e(e16.getMessage());
            }
        }
        return null;
    }

    public static String a(String str, String str2, String str3) {
        if (StringUtil.isEmpty(str)) {
            return str;
        }
        if (StringUtil.isEmpty(str2)) {
            str2 = "unknown";
        }
        if (StringUtil.isEmpty(str3)) {
            str3 = "unknown";
        }
        return str.replaceAll("\\$\\{platform\\}", URLEncoder.encode("e.qq.com")).replaceAll("\\$\\{adid\\}", URLEncoder.encode(str2)).replaceAll("\\$\\{clickid\\}", URLEncoder.encode(str3)).replaceAll("\\$\\{traceurl\\}", "none");
    }

    public static JSONObject a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        String optString = jSONObject.optString("customized_invoke_url");
        if (!StringUtil.isEmpty(optString)) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("customized_invoke_url", optString);
                return jSONObject2;
            } catch (JSONException unused) {
            }
        }
        return null;
    }
}
