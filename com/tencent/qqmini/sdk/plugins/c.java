package com.tencent.qqmini.sdk.plugins;

import android.text.TextUtils;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.EntryModel;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@JsPlugin
/* loaded from: classes23.dex */
public class c extends BaseJsPlugin {

    /* compiled from: P */
    /* loaded from: classes23.dex */
    class a implements AsyncResult {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ RequestEvent f348262a;

        a(RequestEvent requestEvent) {
            this.f348262a = requestEvent;
        }

        @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult
        public void onReceiveResult(boolean z16, JSONObject jSONObject) {
            try {
                QMLog.d("GroupJsPlugin", "isSuccess:" + z16 + " result:" + jSONObject);
                if (z16 && jSONObject != null) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("IsGroupMember", jSONObject.get("IsGroupMember"));
                    this.f348262a.ok(jSONObject2);
                } else {
                    this.f348262a.fail(jSONObject, jSONObject.getString("errorMsg"));
                }
            } catch (JSONException e16) {
                this.f348262a.fail(e16.getMessage());
                QMLog.e("GroupJsPlugin", this.f348262a.event + "onReceiveResult error!", e16);
            }
        }
    }

    private boolean isEntryModelGroupType(String str) {
        EntryModel entryModel;
        MiniAppInfo miniAppInfo = this.mMiniAppInfo;
        if (miniAppInfo != null && (entryModel = miniAppInfo.launchParam.entryModel) != null && str != null && str.equals(entryModel.getEntryHash()) && this.mMiniAppInfo.launchParam.entryModel.type == 1) {
            return true;
        }
        return false;
    }

    @JsEvent({"isGroupMember"})
    public void isGroupMember(RequestEvent requestEvent) {
        try {
            String optString = new JSONObject(requestEvent.jsonParams).optString("openGid", "");
            if (TextUtils.isEmpty(optString)) {
                requestEvent.fail("openGid can not empty!");
                QMLog.e("GroupJsPlugin", "isGroupMember error:openGid can not empty!");
            } else {
                ((MiniAppProxy) ProxyManager.get(MiniAppProxy.class)).isGroupMember(this.mApkgInfo.appId, optString, new a(requestEvent));
            }
        } catch (Exception e16) {
            requestEvent.fail(e16.getMessage());
            QMLog.e("GroupJsPlugin", requestEvent.event + " error!", e16);
        }
    }

    @JsEvent({"sendShareInfoToGroup"})
    public void sendShareInfoToGroup(RequestEvent requestEvent) {
        try {
            if (!isEntryModelGroupType(new JSONObject(requestEvent.jsonParams).optString("entryDataHash", ""))) {
                requestEvent.fail("not entry from group\uff0ccan not send message!");
                QMLog.e("GroupJsPlugin", "sendShareInfoToGroup error:not entry from group\uff0ccan not send message!");
                return;
            }
            long j3 = this.mMiniAppInfo.launchParam.entryModel.uin;
            if (((float) j3) == 0.0f) {
                requestEvent.fail("group id is invalid!");
                QMLog.e("GroupJsPlugin", "sendShareInfoToGroup error:group id is invalid!");
            } else {
                ((MiniAppProxy) ProxyManager.get(MiniAppProxy.class)).sendShareInfoToGroup(this.mMiniAppContext, j3);
            }
        } catch (Exception e16) {
            requestEvent.fail(e16.getMessage());
            QMLog.e("GroupJsPlugin", requestEvent.event + " error", e16);
        }
    }
}
