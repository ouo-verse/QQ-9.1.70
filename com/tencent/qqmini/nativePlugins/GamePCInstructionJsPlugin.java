package com.tencent.qqmini.nativePlugins;

import android.app.Activity;
import android.content.DialogInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.minigame.manager.GamePCInstructionManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.nativePlugins.GamePCInstructionJsPlugin;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import org.json.JSONException;
import org.json.JSONObject;

@JsPlugin
/* loaded from: classes34.dex */
public class GamePCInstructionJsPlugin extends BaseJsPlugin {

    /* renamed from: d, reason: collision with root package name */
    private static boolean f346949d;

    @Override // com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin, com.tencent.qqmini.sdk.launcher.core.plugins.ILifeCycle
    public void onCreate(IMiniAppContext iMiniAppContext) {
        super.onCreate(iMiniAppContext);
        f346949d = false;
    }

    @JsEvent({"sendPCGuide"})
    public void sendPCGuide(RequestEvent requestEvent) {
        IMiniAppContext iMiniAppContext = this.mMiniAppContext;
        if (iMiniAppContext != null && iMiniAppContext.getContext() != null && this.mMiniAppInfo != null) {
            Activity attachActivity = this.mMiniAppContext.getAttachActivity();
            MiniAppInfo miniAppInfo = this.mMiniAppContext.getMiniAppInfo();
            if (attachActivity == null || miniAppInfo == null) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(requestEvent.jsonParams);
                String optString = jSONObject.optString("title");
                String optString2 = jSONObject.optString("imageUrl");
                QMLog.e("GamePCInstructionJsPlugin", "[sendPCInstruction] title: " + optString + " image: " + optString2);
                ThreadManagerV2.getUIHandlerV2().post(new AnonymousClass1(attachActivity, miniAppInfo, requestEvent, optString, optString2));
                return;
            } catch (Throwable unused) {
                requestEvent.fail("sendPCInstruction json exception");
                return;
            }
        }
        QLog.e("GamePCInstructionJsPlugin", 1, "[sendPCInstruction] error,context is NULL");
        requestEvent.fail();
    }

    /* renamed from: com.tencent.qqmini.nativePlugins.GamePCInstructionJsPlugin$1, reason: invalid class name */
    /* loaded from: classes34.dex */
    class AnonymousClass1 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Activity f346950d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ MiniAppInfo f346951e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ RequestEvent f346952f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f346953h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ String f346954i;

        AnonymousClass1(Activity activity, MiniAppInfo miniAppInfo, RequestEvent requestEvent, String str, String str2) {
            this.f346950d = activity;
            this.f346951e = miniAppInfo;
            this.f346952f = requestEvent;
            this.f346953h = str;
            this.f346954i = str2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void d(final RequestEvent requestEvent, Activity activity, MiniAppInfo miniAppInfo, String str, String str2, DialogInterface dialogInterface, int i3) {
            if (GamePCInstructionJsPlugin.f346949d) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("errCode", 10000);
                } catch (JSONException e16) {
                    QLog.d("GamePCInstructionJsPlugin", 2, "has sent msg json error:" + e16);
                }
                requestEvent.fail(jSONObject, "already send pc msg");
                return;
            }
            if (i3 == 1) {
                GamePCInstructionManager.handlePCInstructionConfirm(activity, miniAppInfo, str, str2, Boolean.TRUE, new AsyncResult() { // from class: com.tencent.qqmini.nativePlugins.l
                    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult
                    public final void onReceiveResult(boolean z16, JSONObject jSONObject2) {
                        GamePCInstructionJsPlugin.AnonymousClass1.c(RequestEvent.this, z16, jSONObject2);
                    }
                });
                return;
            }
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("errCode", 10001);
            } catch (JSONException e17) {
                QLog.d("GamePCInstructionJsPlugin", 2, "user canceled json error:" + e17);
            }
            requestEvent.fail(jSONObject2, "user canceled");
        }

        @Override // java.lang.Runnable
        public void run() {
            Activity activity = this.f346950d;
            MiniAppInfo miniAppInfo = this.f346951e;
            Boolean valueOf = Boolean.valueOf(GamePCInstructionJsPlugin.f346949d);
            Boolean bool = Boolean.TRUE;
            final RequestEvent requestEvent = this.f346952f;
            final Activity activity2 = this.f346950d;
            final MiniAppInfo miniAppInfo2 = this.f346951e;
            final String str = this.f346953h;
            final String str2 = this.f346954i;
            GamePCInstructionManager.showPCInstructionDialog(activity, miniAppInfo, valueOf, bool, new DialogInterface.OnClickListener() { // from class: com.tencent.qqmini.nativePlugins.k
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    GamePCInstructionJsPlugin.AnonymousClass1.d(RequestEvent.this, activity2, miniAppInfo2, str, str2, dialogInterface, i3);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void c(RequestEvent requestEvent, boolean z16, JSONObject jSONObject) {
            if (z16) {
                GamePCInstructionJsPlugin.f346949d = true;
                requestEvent.ok();
            } else {
                requestEvent.fail(jSONObject, "send msg failed");
            }
        }
    }
}
