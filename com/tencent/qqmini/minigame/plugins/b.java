package com.tencent.qqmini.minigame.plugins;

import android.text.TextUtils;
import android.util.Pair;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.qqmini.minigame.GameRuntime;
import com.tencent.qqmini.minigame.a;
import com.tencent.qqmini.minigame.floatview.FloatBoxManager;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.HippyPageProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.utils.DebugUtil;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.net.URI;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import org.json.JSONObject;

/* compiled from: P */
@JsPlugin
/* loaded from: classes23.dex */
public class b extends BaseJsPlugin implements a.InterfaceC9388a {

    /* renamed from: d, reason: collision with root package name */
    private HashMap<String, Pair<RequestEvent, Integer>> f346645d = new HashMap<>();

    /* compiled from: P */
    /* loaded from: classes23.dex */
    class a implements AsyncResult {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ RequestEvent f346646a;

        a(RequestEvent requestEvent) {
            this.f346646a = requestEvent;
        }

        @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult
        public void onReceiveResult(boolean z16, JSONObject jSONObject) {
            if (z16) {
                if (jSONObject == null) {
                    QMLog.e("floatBox.GameBoxTaskPlugin", "[createGameBoxTask] result is null.");
                    this.f346646a.fail("result is null.");
                    return;
                }
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put(MiniAppGetGameTaskTicketServlet.KEY_TASKID, jSONObject.optString("ticket"));
                    jSONObject2.put("taskType", jSONObject.optInt(MiniAppGetGameTaskTicketServlet.KEY_TASKID));
                    QMLog.d("floatBox.GameBoxTaskPlugin", "[createGameBoxTask] ret : " + jSONObject2.toString());
                    this.f346646a.ok(jSONObject2);
                    return;
                } catch (Exception e16) {
                    QMLog.e("floatBox.GameBoxTaskPlugin", "[createGameBoxTask] error: " + e16.toString());
                    this.f346646a.fail(e16.toString());
                    return;
                }
            }
            QMLog.e("floatBox.GameBoxTaskPlugin", "[createGameBoxTask] get task id from server failed.");
            this.f346646a.fail("get task id from server failed.");
        }
    }

    public b() {
        com.tencent.qqmini.minigame.a.a().c(this);
    }

    public static String b(String str, String str2) {
        String str3 = str2;
        QMLog.d("floatBox.GameBoxTaskPlugin", "[addParamToUrl] oldUrl:" + str + ", query:" + str3);
        try {
            String[] split = new URI(str).getQuery().split(ContainerUtils.FIELD_DELIMITER);
            if (split != null && split.length != 0) {
                int i3 = 0;
                while (true) {
                    if (i3 >= split.length) {
                        break;
                    }
                    String str4 = split[i3];
                    if (!TextUtils.isEmpty(str4) && str4.startsWith("url=")) {
                        URI uri = new URI(URLDecoder.decode(str4.substring(str4.indexOf("url=") + 4), "UTF-8"));
                        String query = uri.getQuery();
                        if (!TextUtils.isEmpty(query)) {
                            str3 = query + str3;
                        }
                        split[i3] = "url=" + URLEncoder.encode(new URI(uri.getScheme(), uri.getAuthority(), uri.getPath(), str3, uri.getFragment()).toString(), "UTF-8");
                    } else {
                        i3++;
                    }
                }
                String str5 = "";
                for (int i16 = 0; i16 < split.length; i16++) {
                    if (i16 == 0) {
                        str5 = str5 + split[i16];
                    } else {
                        str5 = str5 + ContainerUtils.FIELD_DELIMITER + split[i16];
                    }
                }
                return str.substring(0, str.indexOf(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER) + 1) + str5;
            }
            return "";
        } catch (Exception e16) {
            QMLog.e("floatBox.GameBoxTaskPlugin", "[addParamToUrl] error: " + e16.toString());
            return "";
        }
    }

    private String c(int i3, String str) {
        if (this.mMiniAppInfo == null) {
            return "";
        }
        String str2 = "appId=" + this.mMiniAppInfo.appId + "&taskType=" + i3;
        if (!TextUtils.isEmpty(str)) {
            str2 = str2 + "&taskId=" + str;
        }
        LaunchParam launchParam = this.mMiniAppInfo.launchParam;
        if (launchParam == null) {
            return str2;
        }
        if (!TextUtils.isEmpty(launchParam.taskAppId)) {
            return str2 + "&taskAppId=" + this.mMiniAppInfo.launchParam.taskAppId;
        }
        return str2;
    }

    private ku3.a d() {
        com.tencent.qqmini.minigame.floatview.b floatViewCtrl;
        IMiniAppContext iMiniAppContext = this.mMiniAppContext;
        if (!(iMiniAppContext instanceof GameRuntime) || (floatViewCtrl = ((GameRuntime) iMiniAppContext).getFloatViewCtrl()) == null) {
            return null;
        }
        com.tencent.qqmini.minigame.floatview.a d16 = floatViewCtrl.d(18);
        if (!(d16 instanceof FloatBoxManager)) {
            return null;
        }
        return ((FloatBoxManager) d16).t();
    }

    private String e() {
        ku3.a d16 = d();
        if (d16 == null) {
            return "";
        }
        return d16.f413050f;
    }

    private String f() {
        ku3.a d16 = d();
        if (d16 == null) {
            return "";
        }
        return d16.f413048d;
    }

    @Override // com.tencent.qqmini.minigame.a.InterfaceC9388a
    public void a(String str, String str2) {
        QMLog.d("floatBox.GameBoxTaskPlugin", "[onTaskComplete],id:" + str + " , appId:" + str2);
        Pair<RequestEvent, Integer> pair = this.f346645d.get(str);
        if (pair.first != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(MiniAppGetGameTaskTicketServlet.KEY_TASKID, str);
                jSONObject.put("appId", str2);
                jSONObject.put("taskType", pair.second);
                ((RequestEvent) pair.first).ok(jSONObject);
                this.f346645d.remove(str);
            } catch (Exception e16) {
                QMLog.i("floatBox.GameBoxTaskPlugin", e16.toString());
                ((RequestEvent) pair.first).fail(e16.toString());
            }
        }
    }

    @JsEvent({"createGameBoxTask"})
    public void createGameBoxTask(RequestEvent requestEvent) {
        QMLog.d("floatBox.GameBoxTaskPlugin", "[createGameBoxTask] para:" + requestEvent.jsonParams.toString());
        ChannelProxy channelProxy = (ChannelProxy) ProxyManager.get(ChannelProxy.class);
        if (channelProxy != null) {
            channelProxy.getGameTaskTicket(this.mMiniAppInfo.appId, new a(requestEvent));
        } else {
            requestEvent.fail("channelProxy is null.");
        }
    }

    @JsEvent({"doGameBoxTask"})
    public String doGameBoxTask(RequestEvent requestEvent) {
        QMLog.d("floatBox.GameBoxTaskPlugin", "[doGameBoxTask] para:" + requestEvent.jsonParams.toString());
        IMiniAppContext iMiniAppContext = this.mMiniAppContext;
        if (iMiniAppContext != null && iMiniAppContext.getContext() != null && this.mMiniAppInfo != null) {
            try {
                JSONObject jSONObject = new JSONObject(requestEvent.jsonParams);
                int optInt = jSONObject.optInt("taskType");
                String optString = jSONObject.optString(MiniAppGetGameTaskTicketServlet.KEY_TASKID);
                if (optInt == 1 || optInt == 2) {
                    if (TextUtils.isEmpty(this.mMiniAppInfo.extInfo)) {
                        QMLog.e("floatBox.GameBoxTaskPlugin", "[doGameBoxTask] error,extInfo is null");
                        return requestEvent.fail("extInfo is null");
                    }
                    String f16 = f();
                    if (TextUtils.isEmpty(f16)) {
                        QMLog.e("floatBox.GameBoxTaskPlugin", "[doGameBoxTask] error,page url is empty");
                        if (DebugUtil.isDebugVersion()) {
                            f16 = "mqqapi://hippy/open?bundleName=miniGameCenter&domain=qzone.qq.com&from=gameBox&url=%2Fgame-box";
                        } else {
                            return requestEvent.fail("page url is empty.");
                        }
                    }
                    String b16 = b(f16, c(optInt, optString));
                    HippyPageProxy hippyPageProxy = (HippyPageProxy) ProxyManager.get(HippyPageProxy.class);
                    if (hippyPageProxy != null) {
                        hippyPageProxy.openHippyPage(this.mMiniAppContext, b16, e(), 1, null);
                        QMLog.i("floatBox.GameBoxTaskPlugin", "[doGameBoxTask] open:" + b16 + ", ok!");
                        this.f346645d.put(optString, new Pair<>(requestEvent, Integer.valueOf(optInt)));
                        return "";
                    }
                }
                return requestEvent.fail();
            } catch (Exception e16) {
                QMLog.e("floatBox.GameBoxTaskPlugin", e16.toString());
                return requestEvent.fail(e16.toString());
            }
        }
        QMLog.e("floatBox.GameBoxTaskPlugin", "[doGameBoxTask] error,context is NULL");
        return requestEvent.fail();
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin, com.tencent.qqmini.sdk.launcher.core.plugins.ILifeCycle
    public void onDestroy() {
        super.onDestroy();
        com.tencent.qqmini.minigame.a.a().c(null);
    }
}
