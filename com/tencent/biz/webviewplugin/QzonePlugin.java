package com.tencent.biz.webviewplugin;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QzoneIPCModule;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes32.dex */
public class QzonePlugin extends WebViewPlugin {
    public static final String C = "QzonePlugin";

    /* renamed from: h, reason: collision with root package name */
    private WebView f97413h;

    /* renamed from: i, reason: collision with root package name */
    private String f97414i;

    /* renamed from: d, reason: collision with root package name */
    private boolean f97410d = false;

    /* renamed from: e, reason: collision with root package name */
    private String f97411e = null;

    /* renamed from: f, reason: collision with root package name */
    private String f97412f = "";

    /* renamed from: m, reason: collision with root package name */
    private boolean f97415m = false;

    private void t() {
        new Handler().post(new Runnable() { // from class: com.tencent.biz.webviewplugin.QzonePlugin.2
            @Override // java.lang.Runnable
            public void run() {
                if (QzonePlugin.this.f97413h != null) {
                    String str = QzonePlugin.this.f97414i;
                    if (QzonePlugin.this.mRuntime.a().getIntent().getExtras().getString("url") != null) {
                        str = QzonePlugin.this.mRuntime.a().getIntent().getExtras().getString("url");
                    }
                    QzonePlugin.this.f97413h.loadData(new String(str).replaceAll("#", "%23").replaceAll("%", "%25").replaceAll("'", "%27"), "text/html", "utf-8");
                }
            }
        });
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        return C;
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public long getWebViewSchemaByNameSpace(String str) {
        return 11L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleSchemaRequest(String str, String str2) {
        if (!TextUtils.isEmpty(str) && str.equalsIgnoreCase(QZoneHelper.QZONE_VIP_OPENSUCCESS_CALLBACK_URL)) {
            this.f97410d = true;
            return true;
        }
        if (this.mRuntime.a().getIntent().getBooleanExtra("fromQZone", false) && (str2.equals("http") || str2.equals("https"))) {
            return r(str);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onCreate() {
        super.onCreate();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onWebViewCreated(CustomWebView customWebView) {
        super.onWebViewCreated(customWebView);
        this.f97413h = this.mRuntime.e();
        if (this.mRuntime.a().getIntent() != null) {
            this.f97411e = this.mRuntime.a().getIntent().getStringExtra(QQBrowserActivity.BROADCAST_ACTION_KEY);
        }
    }

    public boolean r(String str) {
        Intent intent = this.mRuntime.a().getIntent();
        Bundle extras = intent.getExtras();
        byte[] byteArray = extras.getByteArray("post_data");
        boolean z16 = extras.getBoolean("UrlorData", true);
        this.f97414i = str;
        if (extras.getString("originalURL") != null) {
            this.f97414i = extras.getString("originalURL");
        }
        if (byteArray != null) {
            s(byteArray);
            intent.removeExtra("post_data");
        } else {
            if (z16) {
                return false;
            }
            t();
        }
        return true;
    }

    public void u(String str) {
        try {
            this.f97415m = new JSONObject(str).getInt(QzoneIPCModule.RESULT_CODE) == 0;
            if (QLog.isColorLevel()) {
                QLog.d("WebViewPlugin", 2, "onActivityResult: mPayActionSucc=" + this.f97415m);
            }
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onDestroy() {
        this.f97413h = null;
    }

    private void s(final byte[] bArr) {
        String str;
        String str2;
        if (bArr == null || (str = this.f97414i) == null) {
            return;
        }
        if (str == null || (str2 = this.f97412f) == null || !str2.equals(str)) {
            new Handler().post(new Runnable() { // from class: com.tencent.biz.webviewplugin.QzonePlugin.1
                @Override // java.lang.Runnable
                public void run() {
                    if (QzonePlugin.this.f97413h != null) {
                        QzonePlugin.this.f97413h.postUrl(QzonePlugin.this.f97414i, bArr);
                    }
                }
            });
            this.f97412f = this.f97414i;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleEvent(String str, long j3, Map<String, Object> map) {
        String str2;
        if (j3 != 8589934601L || (str2 = this.f97411e) == null || "".equals(str2)) {
            return false;
        }
        Intent intent = new Intent();
        intent.setAction(this.f97411e);
        intent.putExtra("key_qzone_vip_open_back_need_check_vipinfo", this.f97410d);
        if (QQBrowserActivity.ACTION_UPDATE_VIP_INFO.equals(this.f97411e)) {
            WebViewPlugin.b bVar = this.mRuntime;
            if (bVar.d(bVar.a()) != null) {
                intent.putExtra(QQBrowserActivity.KEY_PAY_ACTION_RESULT, this.f97415m);
            }
        }
        this.mRuntime.a().sendBroadcast(intent);
        return false;
    }
}
