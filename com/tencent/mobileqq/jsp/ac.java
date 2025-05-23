package com.tencent.mobileqq.jsp;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.support.v4.util.ArraySet;
import android.text.TextUtils;
import com.tencent.mobileqq.bigbrother.TeleScreenConfig;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.PackageUtil;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import java.io.ByteArrayInputStream;
import java.util.Iterator;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes33.dex */
public class ac extends WebViewPlugin {

    /* renamed from: d, reason: collision with root package name */
    private Activity f238806d;

    /* renamed from: e, reason: collision with root package name */
    private ArraySet<Integer> f238807e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class a implements com.tencent.mobileqq.bigbrother.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f238808a;

        a(String str) {
            this.f238808a = str;
        }

        @Override // com.tencent.mobileqq.bigbrother.b
        public void onJump(int i3, int i16) {
            if (ac.this.f238807e != null) {
                ac.this.f238807e.remove(Integer.valueOf(i3));
            }
            com.tencent.mobileqq.bigbrother.d.b().d(i3);
            ac.this.callJs(this.f238808a, "{\"openresult\":" + i16 + "}");
        }
    }

    private int q(String str) {
        int a16 = com.tencent.mobileqq.bigbrother.d.b().a(new a(str));
        if (this.f238807e == null) {
            this.f238807e = new ArraySet<>();
        }
        this.f238807e.add(Integer.valueOf(a16));
        return a16;
    }

    private Activity r() {
        Activity a16 = this.mRuntime.a();
        while (a16 != null && (a16 instanceof BasePluginActivity)) {
            a16 = ((BasePluginActivity) a16).getOutActivity();
        }
        return a16;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x005c -> B:10:0x0070). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x005e -> B:10:0x0070). Please report as a decompilation issue!!! */
    private void s(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("businessId");
            String optString2 = jSONObject.optString("openlink");
            String optString3 = jSONObject.optString("packageName");
            String optString4 = jSONObject.optString("callback");
            int q16 = !TextUtils.isEmpty(optString4) ? q(optString4) : 0;
            try {
                if (!TextUtils.isEmpty(optString2)) {
                    com.tencent.mobileqq.bigbrother.g.a(this.f238806d, optString2, optString, q16);
                } else if (!TextUtils.isEmpty(optString3)) {
                    PackageUtil.startAppWithPkgName(this.f238806d, optString3, null, optString, q16);
                } else if (!TextUtils.isEmpty(optString4)) {
                    callJs(optString4, "{\"openresult\":-3}");
                }
            } catch (ActivityNotFoundException unused) {
                if (!TextUtils.isEmpty(optString4)) {
                    callJs(optString4, "{\"openresult\":-3}");
                }
            }
        } catch (Exception e16) {
            QLog.e("WebViewPlugin", 1, e16, new Object[0]);
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        return "Gdt";
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public long getWebViewEventByNameSpace(String str) {
        return 8L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public Object handleEvent(String str, long j3) {
        if (j3 == 8 && str != null) {
            try {
                TeleScreenConfig.a aVar = (TeleScreenConfig.a) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("100839");
                if (aVar != null && aVar.f(str)) {
                    QLog.d("WebViewPlugin", 1, "doInterceptRequest");
                    return new WebResourceResponse("text/html", "utf-8", new ByteArrayInputStream(new byte[0]));
                }
            } catch (Throwable th5) {
                QLog.e("WebViewPlugin", 1, th5, new Object[0]);
                return super.handleEvent(str, j3);
            }
        }
        return super.handleEvent(str, j3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        if (!"Gdt".equals(str2)) {
            return false;
        }
        addOpenApiListenerIfNeeded(str3, jsBridgeListener);
        if (!"Openlink".equals(str3) || strArr.length <= 0) {
            return true;
        }
        s(strArr[0]);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onCreate() {
        super.onCreate();
        this.f238806d = r();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onDestroy() {
        ArraySet<Integer> arraySet = this.f238807e;
        if (arraySet != null) {
            Iterator<Integer> it = arraySet.iterator();
            while (it.hasNext()) {
                com.tencent.mobileqq.bigbrother.d.b().d(it.next().intValue());
            }
            this.f238807e.clear();
        }
        super.onDestroy();
    }
}
