package com.tencent.biz.webviewplugin;

import android.content.SharedPreferences;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes5.dex */
public class y extends WebViewPlugin {

    /* renamed from: d, reason: collision with root package name */
    PubAccountWebViewHttpBridge f97651d = new PubAccountWebViewHttpBridge();

    /* renamed from: e, reason: collision with root package name */
    List<String> f97652e = new ArrayList();

    /* renamed from: f, reason: collision with root package name */
    String f97653f;

    /* renamed from: h, reason: collision with root package name */
    String f97654h;

    public y() {
        AppInterface appInterface;
        this.f97653f = "";
        this.f97654h = "";
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        if (runtime != null && (appInterface = (AppInterface) runtime.getAppRuntime("modular_web")) != null) {
            this.f97654h = appInterface.getCurrentAccountUin();
            SharedPreferences sharedPreferences = BaseApplication.getContext().getSharedPreferences("sp_public_account_with_cuin_" + this.f97654h, 4);
            if (sharedPreferences != null) {
                boolean z16 = sharedPreferences.getBoolean("kandian_feeds_preload", false);
                boolean z17 = sharedPreferences.getBoolean("kandian_feeds_preload_wifi", false);
                boolean z18 = sharedPreferences.getBoolean("kandian_feeds_preload_4G", false);
                boolean z19 = sharedPreferences.getBoolean("kandian_feeds_preload_3G", false);
                boolean z26 = sharedPreferences.getBoolean("kandian_feeds_preload_2G", false);
                boolean z27 = sharedPreferences.getBoolean("kandian_feeds_image_preload", false);
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("readInJoyPreload", z16);
                    jSONObject.put("readInJoyPreloadWifi", z17);
                    jSONObject.put("readInJoyPreload4G", z18);
                    jSONObject.put("readInJoyPreload3G", z19);
                    jSONObject.put("readInJoyPreload2G", z26);
                    jSONObject.put("readInJoyImgPreload", z27);
                    jSONObject.put("platform", "android");
                    this.f97653f = jSONObject.toString();
                } catch (JSONException e16) {
                    e16.printStackTrace();
                }
                if (QLog.isColorLevel()) {
                    QLog.i("PubAccountPreloadPlugin", 2, "reportJson" + this.f97653f);
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        return "pubAccountPreload";
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public long getWebViewEventByNameSpace(String str) {
        return 8L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleEvent(String str, long j3, Map<String, Object> map) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onDestroy() {
        this.f97651d.c();
        super.onDestroy();
    }

    public void p(String str, boolean z16) {
        this.f97651d.j(str, z16);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public Object handleEvent(String str, long j3) {
        if (!QLog.isColorLevel()) {
            return null;
        }
        QLog.d("PubAccountPreloadPlugin", 2, "url is " + str);
        return null;
    }
}
