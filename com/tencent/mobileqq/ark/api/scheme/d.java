package com.tencent.mobileqq.ark.api.scheme;

import android.app.Activity;
import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.ark.module.h;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QzonePluginProxyActivity;
import cooperation.qzone.TranslucentActivity;
import cooperation.qzone.report.datong.QZoneDTLoginReporter;
import cooperation.qzone.webviewplugin.QZoneJsConstants;
import mqq.app.MobileQQ;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes11.dex */
public class d implements h {
    public static Activity b() {
        Activity f16 = com.tencent.mobileqq.ark.module.b.f();
        if (f16 != null) {
            return f16;
        }
        if (MobileQQ.sProcessId == 2) {
            return BaseApplicationImpl.getApplication().getResumeActivity();
        }
        return null;
    }

    @Override // com.tencent.mobileqq.ark.module.h
    public boolean a(String str, String str2, JSONObject jSONObject, long j3, String str3, String str4) {
        Activity b16;
        if (j3 != 0 || (b16 = b()) == null) {
            return false;
        }
        Intent intent = new Intent(b16, (Class<?>) TranslucentActivity.class);
        intent.addFlags(268435456);
        QzonePluginProxyActivity.setActivityNameToIntent(intent, QZoneHelper.QZONE_TRANSLUCENT_ACTIVITY);
        intent.setAction(QZoneJsConstants.QZonePersonalizeJsConstants.ACTION_WEB_JS_TO_QZONE);
        intent.putExtra("cmd", "Schema");
        if (str.startsWith("arouse/detailbyurl?base64url") && !str.contains("from")) {
            str = str + "&from=aio";
        }
        intent.putExtra(QZoneDTLoginReporter.SCHEMA, "mqzone://" + str);
        intent.putExtra("from", 2);
        b16.startActivity(intent);
        return true;
    }
}
