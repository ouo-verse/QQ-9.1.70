package com.tencent.qqmini.nativePlugins;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import com.tencent.aelight.camera.api.IAECameraUnit;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.aelight.camera.entry.api.IAECameraEntryManager;
import com.tencent.aelight.camera.entry.api.IAECameraLaunchServer;
import com.tencent.ams.dsdk.core.DKConfiguration;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.mini.api.MiniConst;
import com.tencent.mobileqq.profilecard.bussiness.qzone.BaseProfileQZoneComponent;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.shell.IMiniAppFileManager;
import java.io.Serializable;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@JsPlugin(secondary = true)
/* loaded from: classes34.dex */
public class q extends BaseJsPlugin {

    /* renamed from: d, reason: collision with root package name */
    private a f347062d;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes34.dex */
    public class a extends BroadcastReceiver {

        /* renamed from: a, reason: collision with root package name */
        private final String f347063a;

        public a(String str) {
            this.f347063a = str;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (((BaseJsPlugin) q.this).mMiniAppContext.getContext() == null) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                String stringExtra = intent.getStringExtra("file_path");
                String stringExtra2 = intent.getStringExtra(MiniConst.LaunchCameraPluginConst.THUMB_PATH);
                long longExtra = intent.getLongExtra("video_duration", 0L);
                boolean booleanExtra = intent.getBooleanExtra("is_video", false);
                Serializable serializableExtra = intent.getSerializableExtra("extra_info");
                HashMap hashMap = serializableExtra instanceof HashMap ? (HashMap) serializableExtra : null;
                if (hashMap != null) {
                    if (hashMap.containsKey("material_result")) {
                        jSONObject.put("material_result", hashMap.get("material_result"));
                    }
                    if (hashMap.containsKey(MiniConst.LaunchCameraPluginConst.EXTRA_INFO_KEY_WIDGET_ID)) {
                        jSONObject.put(DKConfiguration.PreloadKeys.KEY_MATERIAL_ID, hashMap.get(MiniConst.LaunchCameraPluginConst.EXTRA_INFO_KEY_WIDGET_ID));
                    }
                }
                jSONObject.put("filePath", ((IMiniAppFileManager) ((BaseJsPlugin) q.this).mMiniAppContext.getManager(IMiniAppFileManager.class)).getWxFilePath(stringExtra));
                jSONObject.put(BaseProfileQZoneComponent.KEY_IS_VIDEO, booleanExtra ? 1 : 0);
                if (booleanExtra) {
                    jSONObject.put("videoDuration", (longExtra + 999) / 1000);
                    jSONObject.put("cover", ((IMiniAppFileManager) ((BaseJsPlugin) q.this).mMiniAppContext.getManager(IMiniAppFileManager.class)).getWxFilePath(stringExtra2));
                }
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
            String jSONObject2 = jSONObject.toString();
            QLog.i("LaunchAECameraPlugin", 1, "AECameraBackBroadcastReceiver---sendBackTo=" + this.f347063a + ", data: " + jSONObject2);
            q.this.sendSubscribeEvent(this.f347063a, jSONObject2);
        }
    }

    private void g(RequestEvent requestEvent) {
        if (this.mMiniAppContext.getContext() == null) {
            QLog.e("LaunchAECameraPlugin", 1, "activity is null");
            return;
        }
        try {
            JSONObject optJSONObject = new JSONObject(requestEvent.jsonParams).optJSONObject("data");
            QLog.i("LaunchAECameraPlugin", 1, "miniAppInvokeGYCamera--data=" + optJSONObject);
            if (optJSONObject == null) {
                QLog.e("LaunchAECameraPlugin", 1, "miniAppInvokeGYCamera--data is null.");
                requestEvent.fail();
                return;
            }
            Bundle bundle = new Bundle();
            try {
                int b16 = js.a.L.b();
                if (optJSONObject.has("from")) {
                    b16 = js.a.f(optJSONObject.getString("from")).b();
                }
                bundle.putInt(AECameraConstants.VIDEO_STORY_FROM_TYPE, b16);
                bundle.putInt(AECameraConstants.AECAMERA_MODE, optJSONObject.has("cmode") ? ((IAECameraEntryManager) QRoute.api(IAECameraEntryManager.class)).switchModeToInt(optJSONObject.getString("cmode")) : 200);
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
            j();
            i("custom_event_miniApp_onCameraInfoEvent");
            QIPCClientHelper.getInstance().callServer(IAECameraLaunchServer.NAME, IAECameraLaunchServer.ACTION_MINI_LAUNCH_CAMERA_FOR_MINIAPP, bundle, null);
            requestEvent.ok();
        } catch (JSONException e17) {
            QLog.e("LaunchAECameraPlugin", 1, "miniAppInvokeGYCamera--Failed to handle miniAppInvokeGYCamera", e17);
        }
    }

    private void h(RequestEvent requestEvent) {
        try {
            JSONObject jSONObject = new JSONObject(requestEvent.jsonParams);
            if (this.mMiniAppContext.getContext() != null) {
                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                QLog.i("LaunchAECameraPlugin", 1, "playInvokeGYCamera--data=" + optJSONObject);
                if (optJSONObject == null) {
                    QLog.e("LaunchAECameraPlugin", 1, "playInvokeGYCamera--data is null.");
                    requestEvent.fail();
                    return;
                }
                Bundle bundle = new Bundle();
                try {
                    String str = "";
                    if (optJSONObject.has(IAECameraUnit.WIDGET_NAME)) {
                        str = optJSONObject.getString(IAECameraUnit.WIDGET_NAME);
                    }
                    bundle.putString(IAECameraUnit.WIDGET_NAME, str);
                    bundle.putInt(AECameraConstants.VIDEO_STORY_FROM_TYPE, js.a.K.b());
                } catch (JSONException e16) {
                    e16.printStackTrace();
                }
                j();
                i("custom_event_play_onCameraInfoEvent");
                QIPCClientHelper.getInstance().callServer(IAECameraLaunchServer.NAME, IAECameraLaunchServer.ACTION_MINI_LAUNCH_CAMERA_FOR_PLAY, bundle, null);
                requestEvent.ok();
                return;
            }
            QLog.e("LaunchAECameraPlugin", 1, "playInvokeGYCamera--activity is null");
        } catch (JSONException e17) {
            QLog.e("LaunchAECameraPlugin", 1, "playInvokeGYCamera--Failed to handle playInvokeGYCamera", e17);
        }
    }

    private void i(String str) {
        if (this.mMiniAppContext.getContext() != null) {
            Context context = this.mMiniAppContext.getContext();
            a aVar = new a(str);
            this.f347062d = aVar;
            context.registerReceiver(aVar, new IntentFilter(MiniConst.LaunchCameraPluginConst.BROADCAST_ACTION_CAMERA_BACK_RESULT));
        }
    }

    private void j() {
        if (this.f347062d == null || this.mMiniAppContext.getContext() == null) {
            return;
        }
        try {
            this.mMiniAppContext.getContext().unregisterReceiver(this.f347062d);
        } catch (Throwable unused) {
        }
    }

    public void f(RequestEvent requestEvent) {
        String str;
        try {
            JSONObject jSONObject = new JSONObject(requestEvent.jsonParams);
            if (this.mMiniAppContext.getContext() != null) {
                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                Bundle bundle = new Bundle();
                try {
                } catch (JSONException e16) {
                    e16.printStackTrace();
                }
                if (optJSONObject == null) {
                    QLog.e("LaunchAECameraPlugin", 1, "data is null.");
                    requestEvent.fail();
                    return;
                }
                QLog.d("LaunchAECameraPlugin", 1, "data: " + optJSONObject.toString());
                int b16 = js.a.f410904d.b();
                String str2 = "";
                if (!optJSONObject.has("appId")) {
                    str = "";
                } else {
                    str = optJSONObject.getString("appId");
                }
                if (optJSONObject.has("from")) {
                    b16 = js.a.f(optJSONObject.getString("from")).b();
                }
                if (optJSONObject.has(IAECameraUnit.WIDGET_NAME)) {
                    str2 = optJSONObject.getString(IAECameraUnit.WIDGET_NAME);
                }
                bundle.putInt(AECameraConstants.VIDEO_STORY_FROM_TYPE, b16);
                bundle.putString(IAECameraUnit.WIDGET_NAME, str2);
                this.mMiniAppContext.getContext().getSharedPreferences(MiniConst.LaunchCameraPluginConst.MINI_LAUNCH_TAG, 0).edit().putString(MiniConst.LaunchCameraPluginConst.MINI_LAUNCH_AE_APP_ID, str).apply();
                j();
                i("custom_event_checkin_onCameraInfoEvent");
                QIPCClientHelper.getInstance().callServer(IAECameraLaunchServer.NAME, IAECameraLaunchServer.ACTION_MINI_LAUNCH_CAMERA_FOR_SIGN_IN, bundle, null);
                requestEvent.ok();
                return;
            }
            QLog.e("LaunchAECameraPlugin", 1, "activity is null");
        } catch (JSONException e17) {
            QLog.e("LaunchAECameraPlugin", 1, "Failed to handle checkinInvokeGYCamera", e17);
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin, com.tencent.qqmini.sdk.launcher.core.plugins.ILifeCycle
    public void onDestroy() {
        QLog.d("LaunchAECameraPlugin", 1, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        super.onDestroy();
        j();
    }

    @JsEvent({"play_invokeGYCamera", "checkin_invokeGYCamera", "miniApp_invokeGYCamera"})
    public void launchAECamera(RequestEvent requestEvent) {
        if (requestEvent == null) {
            return;
        }
        QLog.i("LaunchAECameraPlugin", 1, "launchAECamera--JsEvent=" + requestEvent.event);
        if ("checkin_invokeGYCamera".equals(requestEvent.event)) {
            f(requestEvent);
        } else if ("play_invokeGYCamera".equals(requestEvent.event)) {
            h(requestEvent);
        } else if ("miniApp_invokeGYCamera".equals(requestEvent.event)) {
            g(requestEvent);
        }
    }
}
