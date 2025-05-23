package com.tencent.qqmini.minigame.plugins;

import android.text.TextUtils;
import android.view.View;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONException;
import org.json.JSONObject;

@JsPlugin
/* loaded from: classes23.dex */
public class CustomButtonPlugin extends BaseJsPlugin {
    private static final String API_OPERATE_CUSTOM_BUTTON = "operateCustomButton";
    private static final String COMPONENT_ID = "compId";
    private static final String LANG = "lang";
    private static final String ON_CUSTOM_BUTTON_CLICK = "onCustomButtonTap";
    private static final String OPERATE_CREATE = "create";
    private static final String OPERATE_DESTROY = "destroy";
    private static final String OPERATE_HIDE = "hide";
    private static final String OPERATE_SHOW = "show";
    private static final String OPERATE_TYPE = "operateType";
    private static final String OPERATE_UPDATE = "update";
    private static final String TAG = "CustomButtonPlugin";
    private static final String WITH_CREDENTIALS = "withCredentials";

    /* JADX INFO: Access modifiers changed from: private */
    public void handleButtonClick(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put(COMPONENT_ID, jSONObject.opt(COMPONENT_ID));
            jSONObject2.put(WITH_CREDENTIALS, jSONObject.opt(WITH_CREDENTIALS));
            jSONObject2.put("lang", jSONObject.opt("lang"));
            sendSubscribeEvent(ON_CUSTOM_BUTTON_CLICK, jSONObject2.toString());
        } catch (JSONException e16) {
            QMLog.e(TAG, "onClick callback exception", e16);
        }
    }

    @JsEvent({API_OPERATE_CUSTOM_BUTTON})
    public String operateCustomButton(RequestEvent requestEvent) {
        boolean z16;
        if (!TextUtils.isEmpty(requestEvent.jsonParams)) {
            try {
                final JSONObject jSONObject = new JSONObject(requestEvent.jsonParams);
                String optString = jSONObject.optString(OPERATE_TYPE);
                long optLong = jSONObject.optLong(COMPONENT_ID);
                if ("create".equals(optString)) {
                    z16 = OperateCustomButton.obtain(this.mMiniAppContext).operate("create", optLong, jSONObject, new View.OnClickListener() { // from class: com.tencent.qqmini.minigame.plugins.CustomButtonPlugin.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            EventCollector.getInstance().onViewClickedBefore(view);
                            CustomButtonPlugin.this.handleButtonClick(jSONObject);
                            EventCollector.getInstance().onViewClicked(view);
                        }
                    });
                } else if ("show".equals(optString)) {
                    z16 = OperateCustomButton.obtain(this.mMiniAppContext).operate("show", optLong, jSONObject, new View.OnClickListener() { // from class: com.tencent.qqmini.minigame.plugins.CustomButtonPlugin.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            EventCollector.getInstance().onViewClickedBefore(view);
                            CustomButtonPlugin.this.handleButtonClick(jSONObject);
                            EventCollector.getInstance().onViewClicked(view);
                        }
                    });
                } else if ("hide".equals(optString)) {
                    z16 = OperateCustomButton.obtain(this.mMiniAppContext).operate("hide", optLong, jSONObject, null);
                } else if ("destroy".equals(optString)) {
                    z16 = OperateCustomButton.obtain(this.mMiniAppContext).operate("destroy", optLong, jSONObject, null);
                } else if ("update".equals(optString)) {
                    z16 = OperateCustomButton.obtain(this.mMiniAppContext).operate("update", optLong, jSONObject, new View.OnClickListener() { // from class: com.tencent.qqmini.minigame.plugins.CustomButtonPlugin.3
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            EventCollector.getInstance().onViewClickedBefore(view);
                            CustomButtonPlugin.this.handleButtonClick(jSONObject);
                            EventCollector.getInstance().onViewClicked(view);
                        }
                    });
                } else {
                    z16 = false;
                }
                if (z16) {
                    return requestEvent.ok();
                }
                return requestEvent.fail("button not found");
            } catch (JSONException e16) {
                QMLog.e(TAG, requestEvent.event + " parse json exception " + requestEvent.jsonParams, e16);
                return requestEvent.fail("json parse error");
            }
        }
        return requestEvent.fail();
    }
}
