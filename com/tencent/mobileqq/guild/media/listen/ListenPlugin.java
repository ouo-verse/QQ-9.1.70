package com.tencent.mobileqq.guild.media.listen;

import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.media.core.MediaChannelUtils;
import com.tencent.mobileqq.guild.media.core.data.f;
import com.tencent.mobileqq.guild.media.core.j;
import com.tencent.mobileqq.guild.media.core.logic.ab;
import com.tencent.mobileqq.guild.media.core.notify.ba;
import com.tencent.mobileqq.guild.util.bw;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0012\u0018\u0000 \u00142\u00020\u0001:\u0001\u0015B\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/guild/media/listen/ListenPlugin;", "Lcom/tencent/qqmini/sdk/launcher/core/plugins/BaseJsPlugin;", "Lcom/tencent/qqmini/sdk/launcher/core/model/RequestEvent;", "req", "", "startMusic", "pauseMusic", "resumeMusic", "closeMiniAppPanel", "currentUserTinyid", "currentUserType", "setBgmVoice", "setBgmVoiceEnd", "getBgmVoice", "getRecentAppId", "invokeTogetherClick", "invokeGetStartTime", "reportAppWebLoad", "<init>", "()V", "d", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class ListenPlugin extends BaseJsPlugin {
    @JsEvent({"closeMiniAppPanel"})
    public final void closeMiniAppPanel(@NotNull RequestEvent req) {
        Intrinsics.checkNotNullParameter(req, "req");
        QLog.d("QGMC.MediaListen.ListenPlugin", 1, "closeMiniAppPanel " + req);
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.guild.media.listen.ListenPlugin$closeMiniAppPanel$$inlined$safeJsPluginInvoke$1
            @Override // java.lang.Runnable
            public final void run() {
                j.a().M0().e0(1);
            }
        });
    }

    @JsEvent({"currentUserTinyid"})
    public final void currentUserTinyid(@NotNull final RequestEvent req) {
        Intrinsics.checkNotNullParameter(req, "req");
        QLog.d("QGMC.MediaListen.ListenPlugin", 1, "currentUserTinyid " + req);
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.guild.media.listen.ListenPlugin$currentUserTinyid$$inlined$safeJsPluginInvoke$1
            @Override // java.lang.Runnable
            public final void run() {
                String str = j.c().getSelfUserInfo().f228093a;
                RequestEvent.this.ok(new JSONObject("{\"tinyId\":\"" + str + "\"}"));
            }
        });
    }

    @JsEvent({"currentUserType"})
    public final void currentUserType(@NotNull final RequestEvent req) {
        Intrinsics.checkNotNullParameter(req, "req");
        QLog.d("QGMC.MediaListen.ListenPlugin", 1, "currentUserType " + req);
        final Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = 3;
        if (j.c().getSelfUserInfo().f228118z) {
            intRef.element = 4;
        } else {
            f selfUserInfo = j.c().getSelfUserInfo();
            if (selfUserInfo.f228097e == 2) {
                intRef.element = 1;
            } else if (MediaChannelUtils.f228046a.v(selfUserInfo) || selfUserInfo.f228097e == 1) {
                intRef.element = 2;
            }
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.guild.media.listen.ListenPlugin$currentUserType$$inlined$safeJsPluginInvoke$1
            @Override // java.lang.Runnable
            public final void run() {
                RequestEvent.this.ok(new JSONObject("{\"userType\":\"" + intRef.element + "\"}"));
            }
        });
    }

    @JsEvent({"getBgmVoice"})
    public final void getBgmVoice(@NotNull final RequestEvent req) {
        Intrinsics.checkNotNullParameter(req, "req");
        QLog.d("QGMC.MediaListen.ListenPlugin", 1, "getBgmVoice");
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.guild.media.listen.ListenPlugin$getBgmVoice$$inlined$safeJsPluginInvoke$1
            @Override // java.lang.Runnable
            public final void run() {
                RequestEvent.this.ok(new JSONObject("{\"voice\": " + j.a().M0().getMusicVolume() + " }"));
            }
        });
    }

    @JsEvent({"getRecentApps"})
    public final void getRecentAppId(@NotNull RequestEvent req) {
        Intrinsics.checkNotNullParameter(req, "req");
        QLog.d("QGMC.MediaListen.ListenPlugin", 4, "getRecentAppId");
        req.ok(new JSONObject("{\"appid\": \"" + bw.Z() + "\"}"));
    }

    @JsEvent({"getStartTime"})
    public final void invokeGetStartTime(@NotNull final RequestEvent req) {
        Intrinsics.checkNotNullParameter(req, "req");
        QLog.i("QGMC.MediaListen.ListenPlugin", 1, "[invokeGetStartTime] params: " + req.jsonParams);
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.guild.media.listen.ListenPlugin$invokeGetStartTime$$inlined$safeJsPluginInvoke$1
            @Override // java.lang.Runnable
            public final void run() {
                long R = j.c().R();
                if (R <= 0) {
                    RequestEvent.this.fail("invalid timestamp");
                    return;
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("time", R);
                RequestEvent.this.ok(jSONObject);
            }
        });
    }

    @JsEvent({"togetherClick"})
    public final void invokeTogetherClick(@NotNull RequestEvent req) {
        Intrinsics.checkNotNullParameter(req, "req");
        QLog.i("QGMC.MediaListen.ListenPlugin", 1, "[invokeTogetherClick] param: " + req.jsonParams);
        String str = req.jsonParams;
        if (TextUtils.isEmpty(str)) {
            QLog.w("QGMC.MediaListen.ListenPlugin", 1, "[invokeTogetherClick] jsonStr is null or empty");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("data")) {
                final JSONObject jSONObject2 = new JSONObject(jSONObject.getString("data"));
                final String str2 = "playmode";
                if (!jSONObject2.has("playmode")) {
                    return;
                }
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.guild.media.listen.ListenPlugin$invokeTogetherClick$$inlined$safeJsPluginInvoke$1
                    @Override // java.lang.Runnable
                    public final void run() {
                        j.a().l0().z(JSONObject.this.getString(str2));
                    }
                });
            }
        } catch (JSONException e16) {
            QLog.e("QGMC.MediaListen.ListenPlugin", 1, "[invokeTogetherClick] exception, " + e16, e16);
        }
    }

    @JsEvent({"pauseMusic"})
    public final void pauseMusic(@NotNull RequestEvent req) {
        Intrinsics.checkNotNullParameter(req, "req");
        QLog.d("QGMC.MediaListen.ListenPlugin", 1, "pauseMusic " + req);
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.guild.media.listen.ListenPlugin$pauseMusic$$inlined$safeJsPluginInvoke$1
            @Override // java.lang.Runnable
            public final void run() {
                j.a().M0().S0();
            }
        });
    }

    @JsEvent({"lifeNodeNotice"})
    public final void reportAppWebLoad(@NotNull RequestEvent req) {
        Intrinsics.checkNotNullParameter(req, "req");
        QLog.i("QGMC.MediaListen.ListenPlugin", 1, "[reportAppWebLoad] params: " + req.jsonParams);
        String str = req.jsonParams;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            j.d().i(new ba(jSONObject.optLong("webview_finish", 0L), jSONObject.optLong("dom_ready", 0L), jSONObject.optLong("loaded", 0L), true));
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("result", 0);
            req.ok(jSONObject2);
        } catch (JSONException e16) {
            QLog.e("QGMC.MediaListen.ListenPlugin", 1, "[reportAppWebLoad] exception, " + e16, e16);
        }
    }

    @JsEvent({"resumeMusic"})
    public final void resumeMusic(@NotNull RequestEvent req) {
        Intrinsics.checkNotNullParameter(req, "req");
        QLog.d("QGMC.MediaListen.ListenPlugin", 1, "resumeMusic " + req);
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.guild.media.listen.ListenPlugin$resumeMusic$$inlined$safeJsPluginInvoke$1
            @Override // java.lang.Runnable
            public final void run() {
                ab.f1(j.a().M0(), false, 1, null);
            }
        });
    }

    @JsEvent({"setBgmVoice"})
    public final void setBgmVoice(@NotNull RequestEvent req) {
        Intrinsics.checkNotNullParameter(req, "req");
        QLog.d("QGMC.MediaListen.ListenPlugin", 1, "setBgmVoice ");
        try {
            final int optInt = new JSONObject(req.jsonParams).optInt("voice");
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.guild.media.listen.ListenPlugin$setBgmVoice$$inlined$safeJsPluginInvoke$1
                @Override // java.lang.Runnable
                public final void run() {
                    j.a().M0().b1(optInt);
                }
            });
        } catch (Exception e16) {
            QLog.e("QGMC.MediaListen.ListenPlugin", 1, e16, new Object[0]);
        }
    }

    @JsEvent({"setBgmVoiceEnd"})
    public final void setBgmVoiceEnd(@NotNull RequestEvent req) {
        Intrinsics.checkNotNullParameter(req, "req");
        QLog.d("QGMC.MediaListen.ListenPlugin", 1, "setBgmVoiceEnd ");
        try {
            new JSONObject(req.jsonParams).optInt("voice");
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.guild.media.listen.ListenPlugin$setBgmVoiceEnd$$inlined$safeJsPluginInvoke$1
                @Override // java.lang.Runnable
                public final void run() {
                    j.a().M0().c1();
                }
            });
        } catch (Exception e16) {
            QLog.e("QGMC.MediaListen.ListenPlugin", 1, e16, new Object[0]);
        }
    }

    @JsEvent({"startMusic"})
    public final void startMusic(@NotNull RequestEvent req) {
        Intrinsics.checkNotNullParameter(req, "req");
        QLog.d("QGMC.MediaListen.ListenPlugin", 1, "startMusic " + req);
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.guild.media.listen.ListenPlugin$startMusic$$inlined$safeJsPluginInvoke$1
            @Override // java.lang.Runnable
            public final void run() {
                ab.f1(j.a().M0(), false, 1, null);
            }
        });
    }
}
