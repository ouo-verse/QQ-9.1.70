package com.tencent.qqmini.nativePlugins;

import com.tencent.mobileqq.mini.api.IGuildPermission;
import com.tencent.mobileqq.mini.api.impl.GuildPermissionImpl;
import com.tencent.mobileqq.mini.servlet.GameHallAuthServerlet;
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
public class p extends BaseJsPlugin {

    /* compiled from: P */
    /* loaded from: classes34.dex */
    class a implements IGuildPermission.DialogCallBack {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ RequestEvent f347060a;

        a(RequestEvent requestEvent) {
            this.f347060a = requestEvent;
        }

        @Override // com.tencent.mobileqq.mini.api.IGuildPermission.DialogCallBack
        public void onCancel() {
            p.this.c(0, this.f347060a);
        }

        @Override // com.tencent.mobileqq.mini.api.IGuildPermission.DialogCallBack
        public void onConfirm() {
            p.this.c(2, this.f347060a);
        }

        @Override // com.tencent.mobileqq.mini.api.IGuildPermission.DialogCallBack
        public void onReject() {
            p.this.c(1, this.f347060a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i3, RequestEvent requestEvent) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("permissionResult", i3);
            requestEvent.ok(jSONObject);
        } catch (JSONException e16) {
            QLog.e("GuildPermissionJsPlugin", 1, e16, new Object[0]);
            requestEvent.fail(e16.getMessage());
        }
    }

    @JsEvent({"setGuildPermissionStatus"})
    public void setPermissionStatus(RequestEvent requestEvent) {
        try {
            GameHallAuthServerlet.setAuth(new JSONObject(requestEvent.jsonParams).getInt("permissionResult"));
            requestEvent.ok();
        } catch (Exception e16) {
            QLog.e("GuildPermissionJsPlugin", 1, e16, new Object[0]);
            requestEvent.fail(e16.getMessage());
        }
    }

    @JsEvent({"showGuildPermissionDialog"})
    public void showGuildPermissionDialog(RequestEvent requestEvent) {
        try {
            new GuildPermissionImpl().showPermissionDialog(this.mMiniAppContext.getAttachActivity(), new a(requestEvent), new JSONObject(requestEvent.jsonParams).optString("source", "24"));
        } catch (Exception e16) {
            QLog.e("GuildPermissionJsPlugin", 1, e16, new Object[0]);
            requestEvent.fail(e16.getMessage());
        }
    }
}
