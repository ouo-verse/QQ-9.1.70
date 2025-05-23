package com.tencent.qqmini.sdk.action;

import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.action.Action;
import com.tencent.qqmini.sdk.launcher.core.utils.ApiUtil;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes23.dex */
public class ServiceEvaluateCallbackAction implements Action<String> {
    private int mCallbackId = -1;
    private IMiniAppContext mMiniAppContext;
    private JSONObject mRet;

    public static ServiceEvaluateCallbackAction obtain(IMiniAppContext iMiniAppContext) {
        ServiceEvaluateCallbackAction serviceEvaluateCallbackAction = new ServiceEvaluateCallbackAction();
        serviceEvaluateCallbackAction.mMiniAppContext = iMiniAppContext;
        return serviceEvaluateCallbackAction;
    }

    public void callbackJsEventFail(String str, JSONObject jSONObject, int i3) {
        this.mRet = ApiUtil.wrapCallbackFail(str, jSONObject);
        this.mCallbackId = i3;
        this.mMiniAppContext.performAction(this);
    }

    public void callbackJsEventOK(String str, JSONObject jSONObject, int i3) {
        this.mRet = ApiUtil.wrapCallbackOk(str, jSONObject);
        this.mCallbackId = i3;
        this.mMiniAppContext.performAction(this);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.action.Action
    public String perform(BaseRuntime baseRuntime) {
        IJsService jsService = baseRuntime.getJsService();
        if (jsService == null) {
            return null;
        }
        jsService.evaluateCallbackJs(this.mCallbackId, this.mRet.toString());
        return null;
    }
}
