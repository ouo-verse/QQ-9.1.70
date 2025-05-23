package com.tencent.qqmini.miniapp.plugin;

import android.graphics.Paint;
import android.graphics.Typeface;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.core.utils.JSONUtil;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.action.NativeViewRequestEvent;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.core.utils.ApiUtil;
import org.json.JSONException;
import org.json.JSONObject;

@JsPlugin
/* loaded from: classes23.dex */
public class CanvasJsPlugin extends BaseJsPlugin {
    public static final String EVENT_DRAW_CANVAS = "drawCanvas";
    public static final String EVENT_GET_INAGE_DATA = "canvasGetImageData";
    public static final String EVENT_INSERT_CANVAS = "insertCanvas";
    public static final String EVENT_MEASURE_TEXT = "measureText";
    public static final String EVENT_PUT_IMAGE_DATA = "canvasPutImageData";
    public static final String EVENT_REMOVE_CANVAS = "removeCanvas";
    public static final String EVENT_TO_TEMP_FILE_PATH = "canvasToTempFilePath";
    public static final String EVENT_UPDATE_CANVAS = "updateCanvas";

    @JsEvent({"drawCanvas", "canvasToTempFilePath", "canvasPutImageData", "canvasGetImageData", "insertCanvas", "updateCanvas", "removeCanvas"})
    public void doInterceptJsEvent(RequestEvent requestEvent) {
        this.mMiniAppContext.performAction(NativeViewRequestEvent.obtain(requestEvent, 2));
    }

    @JsEvent({"measureText"})
    public String measureText(RequestEvent requestEvent) {
        try {
            JSONObject jSONObject = new JSONObject(requestEvent.jsonParams);
            Paint paint = new Paint(1);
            String optString = jSONObject.optString("fontFamily");
            if ("normal".equals(jSONObject.optString("fontStyle"))) {
                paint.setTypeface(Typeface.create(optString, 0));
            }
            String optString2 = jSONObject.optString("text");
            paint.setTextSize(jSONObject.optInt("fontSize"));
            float measureText = paint.measureText(optString2);
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("width", measureText);
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
            JSONObject wrapCallbackOk = ApiUtil.wrapCallbackOk(requestEvent.event, jSONObject2);
            IJsService iJsService = requestEvent.jsService;
            if (iJsService != null && wrapCallbackOk != null) {
                iJsService.evaluateCallbackJs(requestEvent.callbackId, JSONUtil.append(wrapCallbackOk, "errMsg", requestEvent.event + ":complete").toString());
            }
            return wrapCallbackOk.toString();
        } catch (JSONException e17) {
            e17.printStackTrace();
            return "";
        }
    }
}
