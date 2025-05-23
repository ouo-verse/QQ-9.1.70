package com.tencent.smtt.sdk.core.dynamicinstall.a;

import android.content.Context;
import com.tencent.mobileqq.icgame.api.room.PreloadTRTCPlayerParams;
import com.tencent.qqlive.tvkplayer.vinfo.live.TVKLiveRequestBuilder;
import com.tencent.smtt.sdk.core.dynamicinstall.d;
import com.tencent.smtt.utils.AppUtil;
import com.tencent.smtt.utils.Md5Utils;
import com.tencent.smtt.utils.TbsLog;
import java.util.Locale;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes23.dex */
public class a {
    public static String a(Context context, d dVar) {
        JSONObject jSONObject = new JSONObject();
        String packageName = context.getPackageName();
        String appVersionName = AppUtil.getAppVersionName(context);
        long currentTimeMillis = System.currentTimeMillis();
        try {
            jSONObject.put("appn", packageName);
            jSONObject.put("appvn", appVersionName);
            jSONObject.put("appvc", AppUtil.getAppVersionCode(context));
            jSONObject.put(PreloadTRTCPlayerParams.KEY_SIG, dVar.b());
            jSONObject.put("cid", dVar.c());
            jSONObject.put(TVKLiveRequestBuilder.RequestParamKey.CKEY, dVar.d());
            jSONObject.put("sign", a(packageName, appVersionName, currentTimeMillis, dVar));
            jSONObject.put("source", "X5SDK");
            jSONObject.put("timestamp", currentTimeMillis);
            return jSONObject.toString();
        } catch (Exception unused) {
            TbsLog.i("DynamicConfig", "request generate failed " + jSONObject);
            return null;
        }
    }

    private static String a(String str, String str2, long j3, d dVar) {
        return Md5Utils.getMD5(String.format(Locale.ENGLISH, "%s%s%s%s%d", str, str2, dVar.b(), dVar.c(), Long.valueOf(j3)));
    }
}
