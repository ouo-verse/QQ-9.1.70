package com.tencent.qqmini.nativePlugins;

import android.os.Build;
import android.text.TextUtils;
import com.tencent.gdtad.json.GdtJsonPbUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.haoliyou.sso.CheckForwardServlet;
import com.tencent.mobileqq.mini.server.RequestCallback;
import com.tencent.mobileqq.mini.servlet.EcommerceRequest;
import com.tencent.mobileqq.mini.util.NativeBuffersUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.trpc.qqecommerce.access.VacAdvGet$VacGetGoodsReq;
import com.tencent.mobileqq.trpc.qqecommerce.access.VacAdvGet$VacGetGoodsRsp;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.launcher.core.model.ApkgInfo;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import java.io.OutputStream;
import java.net.URL;
import java.util.Arrays;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import org.json.JSONException;
import org.json.JSONObject;

@JsPlugin
/* loaded from: classes34.dex */
public class EcommercePlugin extends BaseJsPlugin {

    /* renamed from: d, reason: collision with root package name */
    private String f346945d = "";

    private String c() {
        if (TextUtils.isEmpty(this.f346945d)) {
            this.f346945d = com.dataline.util.a.a(false);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("os_version", com.tencent.mobileqq.musicpendant.a.f(Build.VERSION.RELEASE));
            jSONObject.put("mobile_type", DeviceInfoMonitor.getModel());
            jSONObject.put("client_ip", this.f346945d);
        } catch (JSONException e16) {
            QLog.e("EcommercePlugin", 1, e16, new Object[0]);
        }
        return jSONObject.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(String str, String str2) {
        HttpsURLConnection httpsURLConnection = null;
        try {
            try {
                URL url = new URL(str);
                com.tencent.mobileqq.teamwork.c cVar = new com.tencent.mobileqq.teamwork.c();
                SSLContext sSLContext = SSLContext.getInstance("TLSv1.2");
                sSLContext.init(null, new TrustManager[]{cVar}, null);
                com.tencent.mobileqq.teamwork.l lVar = new com.tencent.mobileqq.teamwork.l(sSLContext.getSocketFactory());
                HttpsURLConnection.setDefaultSSLSocketFactory(lVar);
                HttpsURLConnection httpsURLConnection2 = (HttpsURLConnection) url.openConnection();
                try {
                    httpsURLConnection2.setSSLSocketFactory(lVar);
                    httpsURLConnection2.setRequestMethod("POST");
                    httpsURLConnection2.setRequestProperty("Content-Type", "application/json");
                    httpsURLConnection2.setRequestProperty("trpc-trans-info", c());
                    httpsURLConnection2.setConnectTimeout(10000);
                    httpsURLConnection2.setReadTimeout(10000);
                    httpsURLConnection2.setUseCaches(false);
                    httpsURLConnection2.connect();
                    OutputStream outputStream = httpsURLConnection2.getOutputStream();
                    outputStream.write(str2.getBytes());
                    outputStream.flush();
                    outputStream.close();
                    int responseCode = httpsURLConnection2.getResponseCode();
                    if (QLog.isColorLevel()) {
                        QLog.d("EcommercePlugin", 2, "url=" + str + " data=" + str2 + " rspCode= " + responseCode);
                    }
                    httpsURLConnection2.disconnect();
                } catch (Exception e16) {
                    e = e16;
                    httpsURLConnection = httpsURLConnection2;
                    QLog.e("EcommercePlugin", 2, e, new Object[0]);
                    if (httpsURLConnection != null) {
                        httpsURLConnection.disconnect();
                    }
                } catch (Throwable th5) {
                    th = th5;
                    httpsURLConnection = httpsURLConnection2;
                    if (httpsURLConnection != null) {
                        httpsURLConnection.disconnect();
                    }
                    throw th;
                }
            } catch (Throwable th6) {
                th = th6;
            }
        } catch (Exception e17) {
            e = e17;
        }
    }

    private void e(final String str, final String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqmini.nativePlugins.e
            @Override // java.lang.Runnable
            public final void run() {
                EcommercePlugin.this.d(str, str2);
            }
        }, 128, null, true);
    }

    @JsEvent({"getEcommerceGoods"})
    public void getEcommerceGoods(RequestEvent requestEvent) {
        VacAdvGet$VacGetGoodsReq vacAdvGet$VacGetGoodsReq;
        JSONException e16;
        String str;
        VacAdvGet$VacGetGoodsReq vacAdvGet$VacGetGoodsReq2 = new VacAdvGet$VacGetGoodsReq();
        try {
            JSONObject jSONObject = new JSONObject(requestEvent.jsonParams);
            vacAdvGet$VacGetGoodsReq = (VacAdvGet$VacGetGoodsReq) GdtJsonPbUtil.pbFromJson(new VacAdvGet$VacGetGoodsReq(), jSONObject);
            if (vacAdvGet$VacGetGoodsReq != null) {
                try {
                    PBStringField pBStringField = vacAdvGet$VacGetGoodsReq.app_id;
                    ApkgInfo apkgInfo = this.mApkgInfo;
                    if (apkgInfo != null) {
                        str = apkgInfo.appId;
                    } else {
                        str = "";
                    }
                    pBStringField.set(str);
                    byte[] bytesFromNativeBuffers = NativeBuffersUtil.getBytesFromNativeBuffers(jSONObject.optJSONArray("__nativeBuffers__"));
                    if (bytesFromNativeBuffers != null) {
                        vacAdvGet$VacGetGoodsReq.ext_info.set(ByteStringMicro.copyFrom(bytesFromNativeBuffers));
                        vacAdvGet$VacGetGoodsReq.page_number.set(0);
                        QLog.d("EcommercePlugin", 1, "req ext_info:" + Arrays.toString(bytesFromNativeBuffers));
                    }
                } catch (JSONException e17) {
                    e16 = e17;
                    QLog.e("EcommercePlugin", 1, e16, new Object[0]);
                    f(vacAdvGet$VacGetGoodsReq, requestEvent);
                }
            }
        } catch (JSONException e18) {
            vacAdvGet$VacGetGoodsReq = vacAdvGet$VacGetGoodsReq2;
            e16 = e18;
        }
        f(vacAdvGet$VacGetGoodsReq, requestEvent);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002d  */
    @JsEvent({"reportEcommerce"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void reportEcommerce(RequestEvent requestEvent) {
        String str;
        JSONObject jSONObject;
        String str2 = "";
        try {
            jSONObject = new JSONObject(requestEvent.jsonParams);
            str = jSONObject.optString("url");
        } catch (JSONException e16) {
            e = e16;
            str = "";
        }
        try {
            str2 = jSONObject.optString("content");
        } catch (JSONException e17) {
            e = e17;
            QLog.e("EcommercePlugin", 1, e, new Object[0]);
            if (TextUtils.isEmpty(str)) {
            }
        }
        if (TextUtils.isEmpty(str)) {
            e(str, str2);
        }
    }

    private void f(final VacAdvGet$VacGetGoodsReq vacAdvGet$VacGetGoodsReq, final RequestEvent requestEvent) {
        if (vacAdvGet$VacGetGoodsReq == null) {
            return;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqmini.nativePlugins.EcommercePlugin.1

            /* renamed from: com.tencent.qqmini.nativePlugins.EcommercePlugin$1$a */
            /* loaded from: classes34.dex */
            class a implements RequestCallback<VacAdvGet$VacGetGoodsRsp> {
                a() {
                }

                @Override // com.tencent.mobileqq.mini.server.RequestCallback
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public void onReqSucceed(VacAdvGet$VacGetGoodsRsp vacAdvGet$VacGetGoodsRsp) {
                    requestEvent.ok((JSONObject) GdtJsonPbUtil.pbToJson(vacAdvGet$VacGetGoodsRsp));
                }

                @Override // com.tencent.mobileqq.mini.server.RequestCallback
                public void onReqFailed(long j3, String str) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put(CheckForwardServlet.KEY_ERR_CODE, j3);
                        jSONObject.put("err_msg", str);
                    } catch (JSONException e16) {
                        QLog.e("EcommercePlugin", 1, e16.getMessage() + e16);
                    }
                    requestEvent.fail(String.valueOf(jSONObject));
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                EcommerceRequest.getInstance().requestEcommerceGoods(vacAdvGet$VacGetGoodsReq, new a());
            }
        }, 128, null, false);
    }
}
