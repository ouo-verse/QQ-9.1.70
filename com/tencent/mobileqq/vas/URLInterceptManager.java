package com.tencent.mobileqq.vas;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.utils.SchemaUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ax;
import com.tencent.mobileqq.utils.bi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.manager.Manager;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes20.dex */
public class URLInterceptManager implements Manager {
    public static int C = 1;
    public static int D = 2;
    public static int E = 3;

    /* renamed from: i, reason: collision with root package name */
    public static String f307843i = "URLInterceptManager";

    /* renamed from: m, reason: collision with root package name */
    public static int f307844m = -1;

    /* renamed from: h, reason: collision with root package name */
    AtomicBoolean f307848h = new AtomicBoolean(false);

    /* renamed from: d, reason: collision with root package name */
    Map<String, String> f307845d = new HashMap();

    /* renamed from: e, reason: collision with root package name */
    Map<String, String> f307846e = new HashMap();

    /* renamed from: f, reason: collision with root package name */
    Map<String, String> f307847f = new HashMap();

    public URLInterceptManager(QQAppInterface qQAppInterface) {
    }

    private boolean d(String str) {
        if (!this.f307848h.get()) {
            if (QLog.isColorLevel()) {
                QLog.e(f307843i, 2, "checkURL fail config not load");
            }
            return true;
        }
        if (TextUtils.isEmpty(str)) {
            if (QLog.isColorLevel()) {
                QLog.e(f307843i, 2, "checkURL url = null");
            }
            return true;
        }
        return false;
    }

    private void e(JSONObject jSONObject) {
        JSONArray jSONArray;
        if (jSONObject != null) {
            try {
                if (jSONObject.has("urltoapi")) {
                    jSONArray = jSONObject.getJSONArray("urltoapi");
                } else {
                    jSONArray = null;
                }
                if (jSONArray != null) {
                    for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                        k(jSONArray, i3);
                    }
                }
                this.f307848h.set(true);
            } catch (Exception e16) {
                QLog.e(f307843i, 1, "doParseJson fail: " + e16.getMessage());
            }
        }
    }

    @Nullable
    private String f(String str) {
        String str2;
        int indexOf = str.indexOf(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER);
        int indexOf2 = str.indexOf("#");
        int min = Math.min(indexOf, indexOf2);
        if (min > 0) {
            str2 = str.substring(0, min);
        } else {
            int max = Math.max(indexOf, indexOf2);
            if (max > 0) {
                str2 = str.substring(0, max);
            } else {
                str2 = str;
            }
        }
        if (this.f307846e.containsKey(str2)) {
            if (QLog.isColorLevel()) {
                QLog.d(f307843i, 2, "checkURL without param match url=" + str + " Replace with: " + this.f307846e.get(str2));
            }
            return this.f307846e.get(str2);
        }
        if (this.f307847f.keySet().size() > 0) {
            for (String str3 : this.f307847f.keySet()) {
                if (str.startsWith(str3)) {
                    if (QLog.isColorLevel()) {
                        QLog.d(f307843i, 2, "checkURL part match url=" + str + " Replace with: " + this.f307847f.get(str));
                    }
                    return this.f307847f.get(str3);
                }
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d(f307843i, 2, "checkURL not match! url = " + str);
            return null;
        }
        return null;
    }

    private boolean k(JSONArray jSONArray, int i3) throws JSONException {
        int optInt;
        JSONObject jSONObject = jSONArray.getJSONObject(i3);
        if (jSONObject != null) {
            String optString = jSONObject.optString("url", null);
            if (optString == null) {
                return true;
            }
            String optString2 = jSONObject.optString(DTConstants.TAG.API, null);
            if (TextUtils.isEmpty(optString2) || !optString2.startsWith(SchemaUtils.SCHEMA_MQQAPI) || (optInt = jSONObject.optInt("match_type", f307844m)) == f307844m) {
                return true;
            }
            String optString3 = jSONObject.optString("minVer", null);
            if (TextUtils.isEmpty(optString3)) {
                return true;
            }
            String optString4 = jSONObject.optString("maxVer", null);
            if (TextUtils.isEmpty(optString4)) {
                return true;
            }
            l(optString, optString2, optInt, optString3, optString4);
            return false;
        }
        return false;
    }

    private void l(String str, String str2, int i3, String str3, String str4) {
        String str5 = AppSetting.f99551k;
        if (IndividuationConfigInfo.isLaterVersion(str5, str4) && IndividuationConfigInfo.isLaterVersion(str3, str5)) {
            if (QLog.isColorLevel()) {
                QLog.d(f307843i, 2, "Parse from Json: URL = " + str + " API = " + str2 + " type = " + i3);
            }
            if (i3 == C) {
                this.f307845d.put(str, str2);
            } else if (i3 == D) {
                this.f307846e.put(str, str2);
            } else if (i3 == E) {
                this.f307847f.put(str, str2);
            }
        }
    }

    public String a(String str) {
        int indexOf;
        int i3;
        int indexOf2;
        if (d(str)) {
            return null;
        }
        if (QLog.isColorLevel()) {
            QLog.d(f307843i, 2, "checkURL original url = " + str);
        }
        if (str.contains("www.urlshare.cn/umirror_url_check") && (indexOf = str.indexOf("&url=")) > 0 && (indexOf2 = str.indexOf("&src_uin", (i3 = indexOf + 5))) > i3) {
            str = str.substring(i3, indexOf2);
        }
        if (this.f307845d.containsKey(str)) {
            if (QLog.isColorLevel()) {
                QLog.d(f307843i, 2, "checkURL full match url=" + str + " Replace with: " + this.f307845d.get(str));
            }
            return this.f307845d.get(str);
        }
        return f(str);
    }

    public boolean b(Intent intent, Activity activity) {
        if (intent.getComponent() != null && "com.tencent.mobileqq.activity.QQBrowserActivity".equals(intent.getComponent().getClassName())) {
            String a16 = a(intent.getStringExtra("url"));
            if (!TextUtils.isEmpty(a16)) {
                Intent intent2 = new Intent(activity, (Class<?>) JumpActivity.class);
                intent2.setData(Uri.parse(a16));
                intent2.putExtra("from", "webview");
                activity.startActivity(intent2);
                return true;
            }
            return false;
        }
        return false;
    }

    public boolean c(Intent intent, final QQAppInterface qQAppInterface, Context context) {
        ax c16;
        if (intent.getComponent() != null && "com.tencent.mobileqq.activity.QQBrowserActivity".equals(intent.getComponent().getClassName())) {
            if (!this.f307848h.get()) {
                ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.vas.URLInterceptManager.2
                    @Override // java.lang.Runnable
                    public void run() {
                        URLInterceptManager.this.j(qQAppInterface);
                    }
                }, 8, null, true);
                return false;
            }
            String a16 = a(intent.getStringExtra("url"));
            if (!TextUtils.isEmpty(a16) && (c16 = bi.c(qQAppInterface, context, a16)) != null) {
                c16.b();
                return true;
            }
        }
        return false;
    }

    public boolean g() {
        return this.f307848h.get();
    }

    public void h(final Context context) {
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.vas.URLInterceptManager.1
            @Override // java.lang.Runnable
            public void run() {
                URLInterceptManager.this.i(context);
            }
        }, 8, null, true);
    }

    public void i(Context context) {
        String str;
        String str2 = ClubContentJsonTask.UrlInterceptJSONTask.jsonName;
        File file = new File(context.getFilesDir(), str2);
        if (file.exists()) {
            try {
                str = FileUtils.readFileContent(file);
            } catch (OutOfMemoryError e16) {
                if (QLog.isColorLevel()) {
                    QLog.e(f307843i, 2, "getJsonOOM,json_name:" + str2 + e16.getMessage());
                }
                str = null;
            }
            if (str != null) {
                try {
                    e(new JSONObject(str));
                    return;
                } catch (Exception e17) {
                    QLog.e(f307843i, 1, "getJsonError,Exception:" + str2 + e17.getMessage());
                    return;
                }
            }
            return;
        }
        QLog.w(f307843i, 1, "json file not exist");
    }

    public void j(QQAppInterface qQAppInterface) {
        e(ClubContentJsonTask.getJsonFromLocalFile(qQAppInterface, ClubContentJsonTask.UrlInterceptJSONTask, true));
    }

    public URLInterceptManager() {
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
    }
}
