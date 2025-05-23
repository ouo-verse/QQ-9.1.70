package com.tencent.mobileqq.campuscircle;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.component.v;
import com.tencent.qphone.base.util.QLog;
import java.util.Locale;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes33.dex */
public class c extends WebViewPlugin {
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        return "campus_circle";
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public long getWebViewEventByNameSpace(String str) {
        return 8589934598L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleEvent(String str, long j3, Map<String, Object> map) {
        boolean handleEvent = super.handleEvent(str, j3, map);
        if (j3 != 8589934598L) {
            return handleEvent;
        }
        if (this.mRuntime.a().getIntent().getIntExtra("uintype", -1) == 1030) {
            boolean z16 = false;
            try {
                Uri parse = Uri.parse(this.mRuntime.a().getIntent().getStringExtra("url"));
                if (parse != null && parse.isHierarchical()) {
                    z16 = "1".equals(parse.getQueryParameter("__iscomic"));
                }
            } catch (Exception unused) {
            }
            if (z16) {
                return handleEvent;
            }
            Intent aliasIntent = SplashActivity.getAliasIntent(this.mRuntime.a());
            aliasIntent.putExtra(SplashActivity.FRAGMENT_ID, 1);
            aliasIntent.putExtra(AppConstants.MainTabIndex.MAIN_TAB_ID, 4);
            aliasIntent.setFlags(603979776);
            aliasIntent.putExtra("from", "campus_notice");
            this.mRuntime.a().startActivity(aliasIntent);
            if (QLog.isDevelopLevel()) {
                QLog.i("CampusNoticeManager", 4, "EVENT_BEFORE_ACTIVITY_FINISH");
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        if (QLog.isColorLevel()) {
            QLog.d("CampusCirclePlugin", 2, String.format(Locale.getDefault(), "handleJsRequest url: %s pkgName; %s method: %s, args: %s", str, str2, str3, strArr));
        }
        if ("campus_circle".equals(str2)) {
            if ("getRedPoint".equals(str3)) {
                return p(jsBridgeListener, str, str2, str3, strArr);
            }
            if ("reportRedPoint".equals(str3)) {
                return r(jsBridgeListener, str, str2, str3, strArr);
            }
            if ("setTitleIcon".equals(str3)) {
                return s(jsBridgeListener, str, str2, str3, strArr);
            }
            if ("onSearchSchoolResult".equals(str3)) {
                return q(jsBridgeListener, str, str2, str3, strArr);
            }
            return super.handleJsRequest(jsBridgeListener, str, str2, str3, strArr);
        }
        return super.handleJsRequest(jsBridgeListener, str, str2, str3, strArr);
    }

    public boolean q(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        if (strArr != null && strArr.length > 0) {
            try {
                JSONObject jSONObject = new JSONObject(strArr[0]);
                long j3 = jSONObject.getLong("schoolId");
                String string = jSONObject.getString("schoolName");
                Activity a16 = this.mRuntime.a();
                if (a16 != null) {
                    Intent intent = new Intent();
                    intent.putExtra("campus_school_id", j3);
                    intent.putExtra("campus_school", string);
                    a16.setResult(-1, intent);
                    a16.finish();
                }
                if (QLog.isColorLevel()) {
                    QLog.i("CampusCirclePlugin", 2, String.format(Locale.getDefault(), "onSearchSchoolResult schoolId: %d schoolName: %s activity: %s", Long.valueOf(j3), string, a16));
                }
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("CampusCirclePlugin", 2, "onSearchSchoolResult exception", e16);
                }
            }
        }
        return false;
    }

    public boolean r(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        long j3 = -1;
        if (strArr != null && strArr.length > 0) {
            try {
                j3 = new JSONObject(strArr[0]).optLong("seq", -1L);
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("CampusCirclePlugin", 2, "getRedPoint exception", e16);
                }
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("CampusCirclePlugin", 2, "getRedPoint seq=" + j3);
        }
        if (j3 < 0) {
            return true;
        }
        a.c().i(j3);
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x006b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean s(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        int i3;
        Drawable drawable;
        v vVar = (v) super.getBrowserComponent(2);
        if (vVar == null) {
            return false;
        }
        Resources resources = vVar.V.getContext().getResources();
        int i16 = (int) (resources.getDisplayMetrics().density * 30.0f);
        String str4 = "";
        int i17 = 10;
        if (strArr == null || strArr.length <= 0) {
            i3 = 0;
        } else {
            try {
                JSONObject jSONObject = new JSONObject(strArr[0]);
                i3 = jSONObject.optInt("iconIndex");
                try {
                    i17 = jSONObject.optInt("iconPad");
                    str4 = jSONObject.optString("iconRes");
                } catch (Exception e16) {
                    e = e16;
                    if (QLog.isColorLevel()) {
                        QLog.d("CampusCirclePlugin", 2, "getRedPoint exception", e);
                    }
                    if (!"arrow_up".equals(str4)) {
                    }
                    if (i3 <= 3) {
                    }
                    vVar.C.Y(i3, drawable, i17 >= 0 ? i17 > i16 ? i16 : i17 : 0);
                    return true;
                }
            } catch (Exception e17) {
                e = e17;
                i3 = 0;
            }
        }
        if (!"arrow_up".equals(str4)) {
            drawable = resources.getDrawable(R.drawable.eon);
        } else if ("arrow_down".equals(str4)) {
            drawable = resources.getDrawable(R.drawable.eom);
        } else {
            "none".equals(str4);
            drawable = null;
        }
        if (i3 <= 3) {
            i3 = 3;
        } else if (i3 < 0) {
            i3 = 0;
        }
        vVar.C.Y(i3, drawable, i17 >= 0 ? i17 > i16 ? i16 : i17 : 0);
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x004e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean p(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        String str4;
        String str5;
        int i3;
        int i16;
        boolean z16;
        int i17;
        if (strArr != null && strArr.length > 0) {
            try {
                str4 = new JSONObject(strArr[0]).optString("callback");
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("CampusCirclePlugin", 2, "getRedPoint exception", e16);
                }
            }
            str5 = str4;
            if (QLog.isColorLevel()) {
                QLog.d("CampusCirclePlugin", 2, "getRedPoint callback=" + str5);
            }
            if (!TextUtils.isEmpty(str5)) {
                return true;
            }
            JSONObject jSONObject = new JSONObject();
            Bundle d16 = a.c().d();
            long j3 = 0;
            if (d16 != null) {
                z16 = d16.getBoolean("hasRedTouch", false);
                i17 = d16.getInt("type", 1);
                int i18 = d16.getInt("count", 0);
                j3 = d16.getLong("seq", 0L);
                i3 = d16.getInt("code");
                i16 = i18;
            } else {
                i3 = -1;
                i16 = 0;
                z16 = false;
                i17 = 1;
            }
            try {
                jSONObject.put("code", i3);
                jSONObject.put("hasRedTouch", z16 ? 1 : 0);
                jSONObject.put("type", i17);
                jSONObject.put("count", i16);
                jSONObject.put("seq", j3);
            } catch (JSONException e17) {
                if (QLog.isColorLevel()) {
                    QLog.e("CampusCirclePlugin", 2, e17, "getRedPoint, exception");
                }
            }
            String jSONObject2 = jSONObject.toString();
            if (QLog.isColorLevel()) {
                QLog.d("CampusCirclePlugin", 2, "getRedPoint, json=" + jSONObject2);
            }
            callJs(str5, jSONObject2);
            return true;
        }
        str4 = "";
        str5 = str4;
        if (QLog.isColorLevel()) {
        }
        if (!TextUtils.isEmpty(str5)) {
        }
    }
}
