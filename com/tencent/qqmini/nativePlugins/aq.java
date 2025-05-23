package com.tencent.qqmini.nativePlugins;

import android.text.TextUtils;
import com.tencent.mobileqq.mini.out.nativePlugins.WeiyunDownloadFilePlugin;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@JsPlugin(secondary = true)
/* loaded from: classes34.dex */
public class aq extends BaseJsPlugin {

    /* renamed from: d, reason: collision with root package name */
    private ar f347011d;

    private JSONObject b(RequestEvent requestEvent) {
        try {
            return new JSONObject(requestEvent.jsonParams);
        } catch (JSONException unused) {
            QLog.e(WeiyunDownloadFilePlugin.TAG, 1, "Failed to parse jsonParams=" + requestEvent.jsonParams);
            return null;
        }
    }

    @JsEvent({"weiyunDownload"})
    public void weiyunDownload(RequestEvent requestEvent) {
        try {
            JSONObject b16 = b(requestEvent);
            if (b16 != null) {
                JSONObject jSONObject = new JSONObject(b16.optString("data"));
                String string = jSONObject.getString("action");
                if (TextUtils.isEmpty(string)) {
                    return;
                }
                if (string.equals(com.tencent.luggage.wxa.of.b.NAME) || string.equals("pauseDownloadTask") || string.equals("cancelDownloadTask")) {
                    QLog.d(WeiyunDownloadFilePlugin.TAG, 2, "create weiyun Download");
                    if (this.f347011d == null) {
                        this.f347011d = new ar(this.mMiniAppContext);
                    }
                    JSONObject jSONObject2 = new JSONObject(jSONObject.getString("data"));
                    if (string.equals(com.tencent.luggage.wxa.of.b.NAME)) {
                        if (this.f347011d.c(jSONObject2)) {
                            this.f347011d.b(jSONObject2, jSONObject2.getString("file_id"), requestEvent);
                            requestEvent.ok();
                            return;
                        } else {
                            requestEvent.fail("download params illegal.");
                            return;
                        }
                    }
                    if (string.equals("pauseDownloadTask")) {
                        QLog.d(WeiyunDownloadFilePlugin.TAG, 2, "pause weiyun Download");
                        this.f347011d.d(jSONObject2.getString("file_id"), requestEvent);
                    } else if (string.equals("cancelDownloadTask")) {
                        QLog.d(WeiyunDownloadFilePlugin.TAG, 2, "cacel weiyun Download");
                        this.f347011d.a(jSONObject2.getString("file_id"), requestEvent);
                    }
                }
            }
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
    }
}
