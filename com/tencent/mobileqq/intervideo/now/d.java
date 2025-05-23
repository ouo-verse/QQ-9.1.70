package com.tencent.mobileqq.intervideo.now;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.mini.out.nativePlugins.NowLiveNativePlugin;
import com.tencent.mobileqq.troop.api.ITroopMemberApiClientApi;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.VRReportDefine$ReportKey;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes33.dex */
public class d extends WebViewPlugin {

    /* renamed from: d, reason: collision with root package name */
    private com.tencent.biz.troop.b f238335d;

    /* renamed from: e, reason: collision with root package name */
    private int f238336e;

    /* renamed from: f, reason: collision with root package name */
    private int f238337f;

    /* renamed from: h, reason: collision with root package name */
    final ITroopMemberApiClientApi.a f238338h = new a();

    /* compiled from: P */
    /* loaded from: classes33.dex */
    class a implements ITroopMemberApiClientApi.a {
        a() {
        }

        @Override // com.tencent.mobileqq.troop.api.ITroopMemberApiClientApi.a
        public void callback(Bundle bundle) {
            int i3 = bundle.getInt("msg");
            if (i3 == 88) {
                d.this.f238336e = bundle.getInt("state");
                d dVar = d.this;
                dVar.x(dVar.f238336e, d.this.f238337f);
                return;
            }
            if (i3 == 89) {
                d.this.w(bundle.getInt("errCode"), bundle.getString("desc"));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(int i3, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("errcode", i3);
            jSONObject.put("desc", str);
            callJs("window.__WEBVIEW_INSTALL && window.__WEBVIEW_INSTALL(" + jSONObject.toString() + ");");
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(int i3, int i16) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("state", i3);
            jSONObject.put("progress", i16);
            callJs("window.__WEBVIEW_GETPLUGININFO && window.__WEBVIEW_GETPLUGININFO(" + jSONObject.toString() + ");");
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        return NowLiveNativePlugin.PLUGIN_NAME;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00e0  */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        int i3;
        if (QLog.isColorLevel()) {
            QLog.d("NowWebViewPlugin", 2, "handleJsRequest, url=" + str + ", pkgName=" + str2 + ", methodName=" + str3);
        }
        if (this.f238335d != null && str != null && NowLiveNativePlugin.PLUGIN_NAME.equals(str2) && str3 != null) {
            if ("getPluginInfo".equals(str3)) {
                this.f238335d.r0();
                x(this.f238336e, this.f238337f);
            } else if ("openRoom".equals(str3)) {
                if (strArr == null || strArr.length == 0) {
                    return false;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("NowWebViewPlugin", 2, "handleJsRequest arg = " + strArr[0]);
                }
                String str4 = strArr[0];
                if (TextUtils.isEmpty(str4)) {
                    return false;
                }
                this.f238335d.S(Long.valueOf(str4).longValue());
            } else if (VRReportDefine$ReportKey.INSTALL.equals(str3)) {
                if (QLog.isColorLevel()) {
                    QLog.d("NowWebViewPlugin", 2, "handleJsRequest install arg = " + strArr[0]);
                }
                if (strArr != null && strArr.length > 0) {
                    try {
                        i3 = Integer.valueOf(strArr[0]).intValue();
                    } catch (NumberFormatException e16) {
                        e16.printStackTrace();
                    }
                    this.f238335d.P(i3 == 1);
                }
                i3 = 0;
                this.f238335d.P(i3 == 1);
            } else if ("preload".equals(str3)) {
                this.f238335d.h0(v(strArr));
            } else if ("audioRoomSetting".equals(str3)) {
                h52.a.b(this, strArr);
            } else if (QLog.isColorLevel()) {
                QLog.w("NowWebViewPlugin", 2, "NOT support method " + str3 + " yet!!");
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onCreate() {
        super.onCreate();
        com.tencent.biz.troop.b A = com.tencent.biz.troop.b.A();
        this.f238335d = A;
        A.p();
        this.f238335d.F0(this.f238338h);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onDestroy() {
        super.onDestroy();
        com.tencent.biz.troop.b bVar = this.f238335d;
        if (bVar != null) {
            bVar.q();
            this.f238335d.m0();
        }
    }

    public com.tencent.biz.troop.b u() {
        return this.f238335d;
    }

    private Bundle v(String... strArr) {
        if (strArr == null || strArr.length == 0) {
            return null;
        }
        Bundle bundle = new Bundle();
        try {
            JSONObject jSONObject = new JSONObject(strArr[0]);
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str = (String) keys.next();
                bundle.putString(str, jSONObject.optString(str));
            }
        } catch (JSONException e16) {
            if (QLog.isColorLevel()) {
                QLog.w("NowWebViewPlugin", 2, "getFirstParam error: ", e16);
            }
        }
        return bundle;
    }
}
