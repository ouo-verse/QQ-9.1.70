package com.tencent.qqmini.sdk.plugins;

import android.content.Context;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.TbsDownloader;
import com.tencent.smtt.sdk.TbsListener;
import org.json.JSONException;
import org.json.JSONObject;

@JsPlugin
/* loaded from: classes23.dex */
public class X5JsPlugin extends BaseJsPlugin {

    /* renamed from: d, reason: collision with root package name */
    private Context f348253d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes23.dex */
    public class a implements TbsListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ RequestEvent f348255a;

        a(RequestEvent requestEvent) {
            this.f348255a = requestEvent;
        }

        @Override // com.tencent.smtt.sdk.TbsListener
        public void onDownloadFinish(int i3) {
            QMLog.i("[mini] X5JsPlugin", "onDownloadFinish code: " + i3);
            if (i3 == 100) {
                RequestEvent requestEvent = this.f348255a;
                requestEvent.ok(X5JsPlugin.this.f(requestEvent, "x5 download finish!", i3));
            } else {
                RequestEvent requestEvent2 = this.f348255a;
                requestEvent2.fail(X5JsPlugin.this.f(requestEvent2, "x5 download failed!", i3), "");
            }
        }

        @Override // com.tencent.smtt.sdk.TbsListener
        public void onDownloadProgress(int i3) {
            QMLog.i("[mini] X5JsPlugin", "onDownloadProgress: " + i3);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("percent", i3);
            } catch (JSONException e16) {
                QMLog.e("[mini] X5JsPlugin", "onDownloadProgress: " + e16.getMessage());
            }
            this.f348255a.evaluateCallbackJs(jSONObject.toString());
        }

        @Override // com.tencent.smtt.sdk.TbsListener
        public void onInstallFinish(int i3) {
            QMLog.i("[mini] X5JsPlugin", "onInstallFinish code: " + i3);
            if (i3 == 200) {
                RequestEvent requestEvent = this.f348255a;
                requestEvent.ok(X5JsPlugin.this.f(requestEvent, "x5 install finish!", i3));
            } else {
                RequestEvent requestEvent2 = this.f348255a;
                requestEvent2.fail(X5JsPlugin.this.f(requestEvent2, "x5 install failed!", i3), "");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject f(RequestEvent requestEvent, String str, int i3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("errMsg", str);
            jSONObject.put("retCode", i3);
        } catch (JSONException e16) {
            requestEvent.fail(jSONObject, e16.getMessage());
            QMLog.e("[mini] X5JsPlugin", "getFeedbackJson errMsg:" + str + "code:" + i3);
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(RequestEvent requestEvent) {
        QbSdk.setTbsListener(new a(requestEvent));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(RequestEvent requestEvent, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("errMsg", str);
        } catch (JSONException e16) {
            requestEvent.ok();
            QMLog.e("[mini] X5JsPlugin", "x5CallbackEvent error:" + e16.getMessage());
        }
        QMLog.i("[mini] X5JsPlugin", str);
        requestEvent.ok(jSONObject);
    }

    @JsEvent({"downloadTbsX5"})
    public void downloadTbsX5(final RequestEvent requestEvent) {
        QMLog.i("[mini] X5JsPlugin", "downloadTbsX5 RequestEvent:" + requestEvent.jsonParams);
        this.f348253d = this.mMiniAppContext.getContext();
        ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.qqmini.sdk.plugins.X5JsPlugin.1
            @Override // java.lang.Runnable
            public void run() {
                if (com.tencent.qqmini.sdk.utils.e.a(X5JsPlugin.this.f348253d)) {
                    X5JsPlugin.this.h(requestEvent, "X5 already installed!");
                    return;
                }
                QMLog.i("[mini] X5JsPlugin", "startDownload tbs x5!");
                X5JsPlugin.this.g(requestEvent);
                TbsDownloader.startDownload(X5JsPlugin.this.f348253d, true);
            }
        });
    }
}
