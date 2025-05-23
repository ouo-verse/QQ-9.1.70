package com.tencent.qqmini.container.core;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.qqmini.miniapp.core.EventListener;
import com.tencent.qqmini.miniapp.core.page.PageEventListener;
import com.tencent.qqmini.miniapp.core.service.ServiceEventListener;
import com.tencent.qqmini.sdk.core.utils.AppBrandUtil;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.engine.IJsPluginEngine;
import com.tencent.qqmini.sdk.launcher.core.utils.ApiUtil;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes23.dex */
public class c implements PageEventListener, ServiceEventListener {

    /* renamed from: b, reason: collision with root package name */
    private static final List<String> f346116b = Arrays.asList("reportDC", "reportIDKey", "reportKeyValue", "reportDataToDC", "reportRealtimeAction");

    /* renamed from: a, reason: collision with root package name */
    private final ax f346117a;

    public c(ax axVar) {
        this.f346117a = axVar;
    }

    private String c(String str, String str2, final RequestEvent requestEvent) throws JSONException {
        if (new JSONObject(str2).optInt(EventListener.KEY_DELTA, 0) > 0) {
            eu3.f.i(new Runnable() { // from class: com.tencent.qqmini.container.core.b
                @Override // java.lang.Runnable
                public final void run() {
                    c.this.e(requestEvent);
                }
            });
        }
        return ApiUtil.wrapCallbackOk(str, null).toString();
    }

    private String d(String str, String str2, RequestEvent requestEvent) throws JSONException {
        String optString = new JSONObject(str2).optString("url", "");
        ax axVar = this.f346117a;
        if (axVar != null) {
            axVar.C(optString);
        }
        requestEvent.ok();
        return ApiUtil.wrapCallbackOk(str, null).toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e(RequestEvent requestEvent) {
        ax axVar = this.f346117a;
        if (axVar != null && axVar.E()) {
            requestEvent.ok();
            return;
        }
        MiniView r16 = this.f346117a.r(requestEvent.webViewId);
        if (r16 == null) {
            requestEvent.fail("can not find view, id:" + requestEvent.webViewId);
            return;
        }
        Context context = r16.getContext();
        if (!(context instanceof Activity)) {
            requestEvent.fail("context belong to view is not activity");
            return;
        }
        Activity activity = (Activity) context;
        if (activity.isFinishing()) {
            requestEvent.fail("activity is finishing");
        } else {
            activity.finish();
            requestEvent.ok();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void f(Set set) {
        HashSet hashSet = new HashSet();
        hashSet.addAll(set);
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            ((MiniView) it.next()).w();
        }
    }

    private String g(String str) throws Exception {
        JSONObject jSONObject = new JSONObject(str);
        if (jSONObject.has("updateSubPkg")) {
            String string = jSONObject.getString("updateSubPkg");
            final Set<MiniView> t16 = this.f346117a.t(string);
            if (t16 != null && t16.size() >= 0) {
                this.f346117a.R(string);
                eu3.f.i(new Runnable() { // from class: com.tencent.qqmini.container.core.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        c.f(t16);
                    }
                });
                return "";
            }
            return "";
        }
        this.f346117a.F();
        return "";
    }

    private int h(String str) {
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException e16) {
            e16.printStackTrace();
            jSONObject = null;
        }
        if (jSONObject == null) {
            return 0;
        }
        return jSONObject.optInt("webviewId");
    }

    @Override // com.tencent.qqmini.miniapp.core.page.PageEventListener
    public void onAppRoute(String str, String str2, int i3) {
        this.f346117a.getJsService().evaluateSubscribeJS("onAppRoute", AppBrandUtil.getPageLoadInfo(str2, str, this.f346117a.getMiniAppInfo()).toString(), i3);
    }

    @Override // com.tencent.qqmini.miniapp.core.page.PageEventListener
    public void onAppRouteDone(String str, String str2, int i3) {
        this.f346117a.getJsService().evaluateSubscribeJS("onAppRouteDone", AppBrandUtil.getPageLoadInfo(str2, str, this.f346117a.getMiniAppInfo()).toString(), i3);
    }

    @Override // com.tencent.qqmini.miniapp.core.service.ServiceEventListener
    public void onServiceEvent(String str, String str2, int[] iArr) {
        if (!TextUtils.isEmpty(str) && f346116b.contains(str)) {
            if (QMLog.isColorLevel()) {
                QMLog.i("Mini-EventListener", "onServiceEvent, black event:" + str);
                return;
            }
            return;
        }
        if (QMLog.isColorLevel()) {
            QMLog.d("Mini-EventListener", "onServiceEvent, event: " + str + ", params: " + str2);
        }
        ax axVar = this.f346117a;
        if (axVar != null) {
            axVar.g(str, str2, iArr);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00d1 A[Catch: all -> 0x00d6, TRY_LEAVE, TryCatch #0 {all -> 0x00d6, blocks: (B:17:0x007e, B:32:0x00c7, B:34:0x00cc, B:36:0x00d1, B:38:0x0094, B:41:0x009f, B:44:0x00aa), top: B:16:0x007e }] */
    @Override // com.tencent.qqmini.miniapp.core.service.ServiceEventListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String onServiceNativeRequest(String str, String str2, int i3) {
        char c16;
        if ("initWeixinJSBridgeFinish".equals(str)) {
            QMLog.i("Mini-EventListener", "WeixinJSBridge finished.");
            return ApiUtil.wrapCallbackOk(str, null).toString();
        }
        if (!TextUtils.isEmpty(str) && f346116b.contains(str)) {
            if (QMLog.isColorLevel()) {
                QMLog.i("Mini-EventListener", "onServiceNativeRequest, black event:" + str);
            }
            return ApiUtil.wrapCallbackOk(str, null).toString();
        }
        IJsPluginEngine jsPluginEngine = this.f346117a.getJsPluginEngine();
        j jsService = this.f346117a.getJsService();
        int h16 = h(str2);
        RequestEvent build = new RequestEvent.Builder().setEvent(str).setJsonParams(str2).setCallbackId(i3).setJsService(jsService).setWebViewId(h16).build();
        try {
            int hashCode = str.hashCode();
            if (hashCode != -1949226856) {
                if (hashCode != -983638536) {
                    if (hashCode == 1862662092 && str.equals("navigateTo")) {
                        c16 = 0;
                        if (c16 == 0) {
                            if (c16 != 1) {
                                if (c16 != 2) {
                                    if (jsPluginEngine == null) {
                                        return "";
                                    }
                                    return jsPluginEngine.handleNativeRequest(str, str2, jsService, i3, h16);
                                }
                                return g(str2);
                            }
                            return c(str, str2, build);
                        }
                        return d(str, str2, build);
                    }
                    c16 = '\uffff';
                    if (c16 == 0) {
                    }
                } else {
                    if (str.equals("navigateBack")) {
                        c16 = 1;
                        if (c16 == 0) {
                        }
                    }
                    c16 = '\uffff';
                    if (c16 == 0) {
                    }
                }
            } else {
                if (str.equals("updateApp")) {
                    c16 = 2;
                    if (c16 == 0) {
                    }
                }
                c16 = '\uffff';
                if (c16 == 0) {
                }
            }
        } catch (Throwable th5) {
            QMLog.e("Mini-EventListener", "handleNativeRequestException", th5);
            return "";
        }
    }

    @Override // com.tencent.qqmini.miniapp.core.page.PageEventListener
    public void onWebViewEvent(String str, String str2, int i3) {
        if (QMLog.isColorLevel()) {
            QMLog.d("Mini-EventListener", "onWebViewEvent, eventName: " + str + ", jsonParams: " + str2 + ", webViewId: " + i3);
        }
        this.f346117a.getJsService().evaluateSubscribeJS(str, str2, i3);
    }

    @Override // com.tencent.qqmini.miniapp.core.page.PageEventListener
    public String onWebViewNativeRequest(String str, String str2, IJsService iJsService, int i3, int i16) {
        str.equals(com.tencent.luggage.wxa.id.b.NAME);
        if (this.f346117a.getJsPluginEngine() == null) {
            return "";
        }
        if (QMLog.isColorLevel()) {
            QMLog.d("Mini-EventListener", "onWebViewNativeRequest, eventName: " + str + ", jsonParams: " + str2);
        }
        return this.f346117a.getJsPluginEngine().handleNativeRequest(str, str2, iJsService, i3, i16);
    }

    @Override // com.tencent.qqmini.miniapp.core.page.PageEventListener
    public void onWebViewReady(String str, String str2, int i3) {
        onAppRoute(str, str2, i3);
        onAppRouteDone(str, str2, i3);
    }
}
