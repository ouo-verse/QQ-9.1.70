package com.tencent.qqmini.miniapp.plugin;

import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.annotation.Restriction;
import com.tencent.qqmini.sdk.launcher.core.model.ApkgInfo;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.core.utils.ApiUtil;
import com.tencent.qqmini.sdk.manager.ApkgManager;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

@JsPlugin(restriction = Restriction.RESTRICT_TO_MINI_APP)
/* loaded from: classes23.dex */
public class SubpackageJsPlugin extends BaseJsPlugin {
    public static final String API_CREATE_LOAD_SUBPACKAGE_TASK = "createLoadSubPackageTask";
    public static final String EVENT_ON_LOAD_SUBPACKAGE_TASK_STATE_CHANGE = "onLoadSubPackageTaskStateChange";
    private static final String TAG = "SubpackageJsPlugin";
    private AtomicInteger subpackageTaskId = new AtomicInteger(0);

    @JsEvent({"createLoadSubPackageTask"})
    public String createLoadSubPackageTask(final RequestEvent requestEvent) {
        try {
            final String optString = new JSONObject(requestEvent.jsonParams).optString("moduleName");
            final int andIncrement = this.subpackageTaskId.getAndIncrement();
            JSONObject jSONObject = new JSONObject();
            ApkgManager.getInstance().downloadSubPack(this.mApkgInfo, this.mMiniAppInfo, optString, new ApkgManager.OnInitApkgListener() { // from class: com.tencent.qqmini.miniapp.plugin.SubpackageJsPlugin.1
                @Override // com.tencent.qqmini.sdk.manager.ApkgManager.OnInitApkgListener
                public void onInitApkgInfo(int i3, ApkgInfo apkgInfo, String str) {
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        jSONObject2.put(MiniAppGetGameTaskTicketServlet.KEY_TASKID, andIncrement);
                        jSONObject2.put("moduleName", optString);
                        if (i3 == 0) {
                            jSONObject2.put("state", "success");
                        } else {
                            jSONObject2.put("state", "fail");
                        }
                        requestEvent.jsService.evaluateSubscribeJS("onLoadSubPackageTaskStateChange", jSONObject2.toString(), 0);
                    } catch (Throwable th5) {
                        try {
                            jSONObject2.put(MiniAppGetGameTaskTicketServlet.KEY_TASKID, andIncrement);
                            jSONObject2.put("moduleName", optString);
                            jSONObject2.put("state", "fail");
                        } catch (Throwable th6) {
                            th6.printStackTrace();
                        }
                        requestEvent.jsService.evaluateSubscribeJS("onLoadSubPackageTaskStateChange", jSONObject2.toString(), 0);
                        th5.printStackTrace();
                    }
                }
            });
            jSONObject.put("loadTaskId", andIncrement);
            return ApiUtil.wrapCallbackOk(requestEvent.event, jSONObject).toString();
        } catch (Throwable th5) {
            th5.printStackTrace();
            return ApiUtil.wrapCallbackFail(requestEvent.event, new JSONObject()).toString();
        }
    }
}
