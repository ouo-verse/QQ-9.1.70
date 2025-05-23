package com.tencent.qqmini.nativePlugins;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.tencent.ark.ark;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.activateFriend.ae;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.mini.forward.ForwardMiniChooseFriendOption;
import com.tencent.mobileqq.mini.reuse.MiniAppTransferModule;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.vaswebviewplugin.QWalletMixJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.VasCommonJsPlugin;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.core.manager.ActivityResultManager;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.shell.IActivityResultListener;
import cooperation.qzone.QzoneIPCModule;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@JsPlugin(secondary = true)
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u0000 \u001c2\u00020\u0001:\u0003\u001d\u001e\u001fB\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J,\u0010\r\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u00072\u0006\u0010\f\u001a\u00020\u000bH\u0002J,\u0010\u000e\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u00072\u0006\u0010\f\u001a\u00020\u000bH\u0002J,\u0010\u000f\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u00072\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0018\u0010\u0010\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0007J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0007R\u0018\u0010\u0016\u001a\u00060\u0013R\u00020\u00008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0019\u001a\u00060\u0017R\u00020\u00008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0018\u00a8\u0006 "}, d2 = {"Lcom/tencent/qqmini/nativePlugins/j;", "Lcom/tencent/qqmini/sdk/launcher/core/plugins/BaseJsPlugin;", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "g", tl.h.F, "", "msgId", "businessId", "domain", "Lcom/tencent/qqmini/sdk/launcher/core/model/RequestEvent;", "requestEvent", "j", "i", "l", "e", "showFriendSelector", "qqNotify", "Lcom/tencent/qqmini/nativePlugins/j$b;", "d", "Lcom/tencent/qqmini/nativePlugins/j$b;", "mGetFriendSelectorListener", "Lcom/tencent/qqmini/nativePlugins/j$c;", "Lcom/tencent/qqmini/nativePlugins/j$c;", "mNotifyResultListener", "<init>", "()V", "f", "a", "b", "c", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class j extends BaseJsPlugin {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final b mGetFriendSelectorListener = new b();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final c mNotifyResultListener = new c();

    private final void e(String msgId, final RequestEvent requestEvent) {
        Bundle bundle = new Bundle();
        bundle.putString("msgid", msgId);
        QIPCClientHelper.getInstance().getClient().callServer("MiniAppTransferModule", MiniAppTransferModule.ACTION_DELETE_QQ_NOTIFY, bundle, new EIPCResultCallback() { // from class: com.tencent.qqmini.nativePlugins.h
            @Override // eipc.EIPCResultCallback
            public final void onCallback(EIPCResult eIPCResult) {
                j.f(RequestEvent.this, eIPCResult);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(RequestEvent requestEvent, EIPCResult eIPCResult) {
        Intrinsics.checkNotNullParameter(requestEvent, "$requestEvent");
        if (eIPCResult.isSuccess()) {
            requestEvent.ok();
        } else {
            requestEvent.fail();
        }
    }

    private final void g(Activity activity) {
        Intent intent = new Intent();
        intent.putExtra("forward_type", 1057);
        intent.putExtra(ForwardRecentActivity.SELECTION_MODE, 2);
        RouteUtils.startActivityForResult(activity, intent, RouterConstants.UI_ROUTE_JUMP_FORWARD_RECENT, 12334);
    }

    private final void h(Activity activity) {
        Intent intent = new Intent();
        intent.putExtra("forward_type", 1057);
        intent.putExtra(ForwardRecentActivity.SELECTION_MODE, 1);
        RouteUtils.startActivityForResult(activity, intent, RouterConstants.UI_ROUTE_JUMP_FORWARD_RECENT, 12334);
    }

    private final void i(String msgId, String businessId, String domain, RequestEvent requestEvent) {
        IMiniAppContext iMiniAppContext = this.mMiniAppContext;
        Activity attachActivity = iMiniAppContext != null ? iMiniAppContext.getAttachActivity() : null;
        if (attachActivity == null) {
            requestEvent.fail("attached activity is null");
            QLog.e("FriendJsPlugin", 1, "attached activity is null");
        }
        this.mNotifyResultListener.c(requestEvent);
        com.tencent.mobileqq.activity.activateFriend.ae.p(attachActivity, msgId, domain, businessId, 12335);
    }

    private final void j(String msgId, String businessId, String domain, final RequestEvent requestEvent) {
        com.tencent.mobileqq.activity.activateFriend.ae.s(msgId, domain, businessId, new ae.c() { // from class: com.tencent.qqmini.nativePlugins.i
            @Override // com.tencent.mobileqq.activity.activateFriend.ae.c
            public final void onResult(Bundle bundle, Bundle bundle2) {
                j.k(RequestEvent.this, bundle, bundle2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(RequestEvent requestEvent, Bundle bundle, Bundle bundle2) {
        Intrinsics.checkNotNullParameter(requestEvent, "$requestEvent");
        requestEvent.ok();
        QLog.d("FriendJsPlugin", 1, "notifyOnce success");
    }

    private final void l(String msgId, String businessId, String domain, final RequestEvent requestEvent) {
        com.tencent.mobileqq.activity.activateFriend.ae.k(msgId, domain, businessId, new ae.b() { // from class: com.tencent.qqmini.nativePlugins.g
            @Override // com.tencent.mobileqq.activity.activateFriend.ae.b
            public final void queryHasSetNotify(Bundle bundle, Bundle bundle2) {
                j.m(RequestEvent.this, bundle, bundle2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(RequestEvent requestEvent, Bundle bundle, Bundle bundle2) {
        Intrinsics.checkNotNullParameter(requestEvent, "$requestEvent");
        int i3 = bundle != null ? bundle.getInt(QWalletMixJsPlugin.PARAMS_HAS_SUBSCRIBE, -1) : -1;
        QLog.d("FriendJsPlugin", 1, "queryNotify result:" + i3);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("subScribed", i3 > 0);
        requestEvent.ok(jSONObject);
    }

    @JsEvent({"qqNotify"})
    public final void qqNotify(RequestEvent requestEvent) {
        Intrinsics.checkNotNullParameter(requestEvent, "requestEvent");
        QLog.d("FriendJsPlugin", 2, "qqNotify, json:" + requestEvent.jsonParams);
        try {
            JSONObject optJSONObject = new JSONObject(requestEvent.jsonParams).optJSONObject("data");
            Integer valueOf = optJSONObject != null ? Integer.valueOf(optJSONObject.optInt("action", 0)) : null;
            JSONObject optJSONObject2 = optJSONObject != null ? optJSONObject.optJSONObject("params") : null;
            String optString = optJSONObject2 != null ? optJSONObject2.optString("msgid") : null;
            Intrinsics.checkNotNull(optString);
            String optString2 = optJSONObject2 != null ? optJSONObject2.optString("busiid") : null;
            String optString3 = optJSONObject2 != null ? optJSONObject2.optString("domain") : null;
            if (TextUtils.isEmpty(optString)) {
                String str = "params is illegal " + requestEvent.jsonParams;
                requestEvent.fail(str);
                QLog.e("FriendJsPlugin", 1, str);
                return;
            }
            if (valueOf != null && valueOf.intValue() == 1) {
                j(optString, optString2, optString3, requestEvent);
                return;
            }
            if (valueOf.intValue() == 2) {
                i(optString, optString2, optString3, requestEvent);
                return;
            }
            if (valueOf != null && valueOf.intValue() == 3) {
                l(optString, optString2, optString3, requestEvent);
                return;
            }
            if (valueOf.intValue() == 4) {
                e(optString, requestEvent);
                return;
            }
            requestEvent.fail("action should be 1 ~ 4");
        } catch (Exception e16) {
            requestEvent.fail("native exception:" + e16);
        }
    }

    @JsEvent({VasCommonJsPlugin.H5_CALLBACK_GETFRIENDINFO})
    public final void showFriendSelector(RequestEvent requestEvent) {
        Intrinsics.checkNotNullParameter(requestEvent, "requestEvent");
        QLog.d("FriendJsPlugin", 1, "showFriendSelector, json:" + requestEvent.jsonParams);
        IMiniAppContext iMiniAppContext = this.mMiniAppContext;
        Activity attachActivity = iMiniAppContext != null ? iMiniAppContext.getAttachActivity() : null;
        if (attachActivity == null) {
            requestEvent.fail("attached activity is null");
            return;
        }
        boolean z16 = false;
        try {
            JSONObject optJSONObject = new JSONObject(requestEvent.jsonParams).optJSONObject("data");
            if (optJSONObject != null) {
                z16 = optJSONObject.getBoolean("isMulti");
            }
        } catch (Exception unused) {
        }
        this.mGetFriendSelectorListener.b(requestEvent);
        if (z16) {
            g(attachActivity);
        } else {
            h(attachActivity);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\"\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016R$\u0010\u0015\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/qqmini/nativePlugins/j$b;", "Lcom/tencent/qqmini/sdk/launcher/shell/IActivityResultListener;", "Lorg/json/JSONObject;", ark.ARKMETADATA_JSON, "", "a", "Lcom/tencent/qqmini/sdk/launcher/core/model/RequestEvent;", "requestEvent", "b", "", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "", "doOnActivityResult", "Lcom/tencent/qqmini/sdk/launcher/core/model/RequestEvent;", "getMRequestEvent", "()Lcom/tencent/qqmini/sdk/launcher/core/model/RequestEvent;", "setMRequestEvent", "(Lcom/tencent/qqmini/sdk/launcher/core/model/RequestEvent;)V", "mRequestEvent", "<init>", "(Lcom/tencent/qqmini/nativePlugins/j;)V", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    private final class b implements IActivityResultListener {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private RequestEvent mRequestEvent;

        public b() {
        }

        private final void a(JSONObject json) {
            RequestEvent requestEvent = this.mRequestEvent;
            if (requestEvent != null) {
                requestEvent.ok(json);
            }
            this.mRequestEvent = null;
        }

        public final void b(RequestEvent requestEvent) {
            Intrinsics.checkNotNullParameter(requestEvent, "requestEvent");
            RequestEvent requestEvent2 = this.mRequestEvent;
            if (requestEvent2 != null) {
                requestEvent2.fail("new request is coming, abort older one");
            }
            this.mRequestEvent = requestEvent;
            ActivityResultManager.g().addActivityResultListener(this);
        }

        @Override // com.tencent.qqmini.sdk.launcher.shell.IActivityResultListener
        public boolean doOnActivityResult(int requestCode, int resultCode, Intent data) {
            if (requestCode != 12334) {
                return false;
            }
            ActivityResultManager.g().removeActivityResultListener(this);
            if (resultCode == 0) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("isCancled", true);
                a(jSONObject);
                return true;
            }
            QLog.d("FriendJsPlugin", 1, "select friend onReceiveResult code  " + resultCode);
            Serializable serializableExtra = data != null ? data.getSerializableExtra(ForwardMiniChooseFriendOption.RESULT_LIST) : null;
            Intrinsics.checkNotNull(serializableExtra, "null cannot be cast to non-null type java.util.ArrayList<com.tencent.mobileqq.mini.forward.MiniPluginForwardResult>{ kotlin.collections.TypeAliasesKt.ArrayList<com.tencent.mobileqq.mini.forward.MiniPluginForwardResult> }");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("members", new JSONArray(new Gson().toJson((ArrayList) serializableExtra)));
            jSONObject2.put("isCancled", false);
            a(jSONObject2);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007J\"\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016R$\u0010\u0016\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/qqmini/nativePlugins/j$c;", "Lcom/tencent/qqmini/sdk/launcher/shell/IActivityResultListener;", "Lorg/json/JSONObject;", ark.ARKMETADATA_JSON, "", "b", "a", "Lcom/tencent/qqmini/sdk/launcher/core/model/RequestEvent;", "requestEvent", "c", "", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "", "doOnActivityResult", "Lcom/tencent/qqmini/sdk/launcher/core/model/RequestEvent;", "getMRequestEvent", "()Lcom/tencent/qqmini/sdk/launcher/core/model/RequestEvent;", "setMRequestEvent", "(Lcom/tencent/qqmini/sdk/launcher/core/model/RequestEvent;)V", "mRequestEvent", "<init>", "(Lcom/tencent/qqmini/nativePlugins/j;)V", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public final class c implements IActivityResultListener {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private RequestEvent mRequestEvent;

        public c() {
        }

        private final void a(JSONObject json) {
            RequestEvent requestEvent = this.mRequestEvent;
            if (requestEvent != null) {
                requestEvent.fail(json.toString());
            }
            this.mRequestEvent = null;
        }

        private final void b(JSONObject json) {
            RequestEvent requestEvent = this.mRequestEvent;
            if (requestEvent != null) {
                requestEvent.ok(json);
            }
            this.mRequestEvent = null;
        }

        public final void c(RequestEvent requestEvent) {
            Intrinsics.checkNotNullParameter(requestEvent, "requestEvent");
            ActivityResultManager.g().removeActivityResultListener(this);
            RequestEvent requestEvent2 = this.mRequestEvent;
            if (requestEvent2 != null) {
                requestEvent2.fail("new request is coming, abort older one");
            }
            this.mRequestEvent = requestEvent;
            ActivityResultManager.g().addActivityResultListener(this);
        }

        @Override // com.tencent.qqmini.sdk.launcher.shell.IActivityResultListener
        public boolean doOnActivityResult(int requestCode, int resultCode, Intent data) {
            if (requestCode != 12335) {
                return false;
            }
            ActivityResultManager.g().removeActivityResultListener(this);
            JSONObject jSONObject = new JSONObject();
            if (resultCode != -1) {
                jSONObject.put("subScribed", false);
                a(jSONObject);
                return true;
            }
            jSONObject.put("subScribed", (data != null ? data.getIntExtra("errorCode", 0) : 0) == 0);
            b(jSONObject);
            return true;
        }
    }
}
