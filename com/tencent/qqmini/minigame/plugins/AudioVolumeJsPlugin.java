package com.tencent.qqmini.minigame.plugins;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@JsPlugin
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 \u00062\u00020\u0001:\u0002\u0010\u0011B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\b\u0010\n\u001a\u00020\u0004H\u0016R\u0018\u0010\r\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\f\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/qqmini/minigame/plugins/AudioVolumeJsPlugin;", "Lcom/tencent/qqmini/sdk/launcher/core/plugins/BaseJsPlugin;", "Lcom/tencent/qqmini/sdk/launcher/core/model/RequestEvent;", "requestEvent", "", "d", "e", "f", "", "onAudioVolumeChange", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/qqmini/minigame/plugins/AudioVolumeJsPlugin$a;", "Lcom/tencent/qqmini/minigame/plugins/AudioVolumeJsPlugin$a;", "audioVolumeChangeReceiver", "<init>", "()V", "a", "b", "lib_minigame_internalRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes23.dex */
public final class AudioVolumeJsPlugin extends BaseJsPlugin {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private a audioVolumeChangeReceiver;

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0011\u001a\u00020\t\u0012\u0006\u0010\u0010\u001a\u00020\r\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016R\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/qqmini/minigame/plugins/AudioVolumeJsPlugin$a;", "Landroid/content/BroadcastReceiver;", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "", "onReceive", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/qqmini/minigame/plugins/AudioVolumeJsPlugin;", "a", "Ljava/lang/ref/WeakReference;", "pluginRef", "Lcom/tencent/qqmini/sdk/launcher/core/model/RequestEvent;", "b", "Lcom/tencent/qqmini/sdk/launcher/core/model/RequestEvent;", "requestEvent", "plugin", "<init>", "(Lcom/tencent/qqmini/minigame/plugins/AudioVolumeJsPlugin;Lcom/tencent/qqmini/sdk/launcher/core/model/RequestEvent;)V", "lib_minigame_internalRelease"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes23.dex */
    public static final class a extends BroadcastReceiver {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final WeakReference<AudioVolumeJsPlugin> pluginRef;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final RequestEvent requestEvent;

        public a(@NotNull AudioVolumeJsPlugin plugin, @NotNull RequestEvent requestEvent) {
            Intrinsics.checkParameterIsNotNull(plugin, "plugin");
            Intrinsics.checkParameterIsNotNull(requestEvent, "requestEvent");
            this.requestEvent = requestEvent;
            this.pluginRef = new WeakReference<>(plugin);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(@Nullable Context context, @Nullable Intent intent) {
            AudioVolumeJsPlugin audioVolumeJsPlugin = this.pluginRef.get();
            if (audioVolumeJsPlugin != null && intent != null) {
                String action = intent.getAction();
                int intExtra = intent.getIntExtra("android.media.EXTRA_VOLUME_STREAM_TYPE", -1);
                if (!(!Intrinsics.areEqual(action, "android.media.VOLUME_CHANGED_ACTION")) && intExtra == 3) {
                    audioVolumeJsPlugin.d(this.requestEvent);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d(RequestEvent requestEvent) {
        Object obj;
        int i3;
        Context context = this.mContext;
        if (context != null) {
            obj = context.getSystemService("audio");
        } else {
            obj = null;
        }
        if (obj instanceof AudioManager) {
            i3 = SystemMethodProxy.getStreamVolume((AudioManager) obj, 3);
        } else {
            i3 = -1;
        }
        if (i3 == -1) {
            QMLog.e("AudioVolumeJsPlugin", "notifyAudioVolumeChange: currentVolume get -1");
            return;
        }
        QMLog.i("AudioVolumeJsPlugin", "notifyAudioVolumeChange: currentVolume=" + i3);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("currentVolume", i3);
        IJsService iJsService = requestEvent.jsService;
        if (iJsService != null) {
            iJsService.evaluateSubscribeJS("onAudioVolumeChange", jSONObject.toString(), 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e(RequestEvent requestEvent) {
        if (this.audioVolumeChangeReceiver != null) {
            QMLog.w("AudioVolumeJsPlugin", "registerAudioVolumeChangeReceiver: has register.");
            return;
        }
        a aVar = new a(this, requestEvent);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.media.VOLUME_CHANGED_ACTION");
        Context context = this.mContext;
        if (context != null) {
            context.registerReceiver(aVar, intentFilter);
        }
        this.audioVolumeChangeReceiver = aVar;
        QMLog.i("AudioVolumeJsPlugin", "registerAudioVolumeChangeReceiver: success register.");
    }

    private final void f() {
        a aVar = this.audioVolumeChangeReceiver;
        if (aVar != null) {
            try {
                Context context = this.mContext;
                if (context != null) {
                    context.unregisterReceiver(aVar);
                }
                QMLog.d("AudioVolumeJsPlugin", "unRegisterAudioVolumeChangeReceiver: success");
            } catch (Throwable th5) {
                QMLog.e("AudioVolumeJsPlugin", "unRegisterAudioVolumeChangeReceiver: exception.", th5);
            }
        }
        this.audioVolumeChangeReceiver = null;
    }

    @JsEvent({"onAudioVolumeChange"})
    @NotNull
    public final String onAudioVolumeChange(@NotNull final RequestEvent requestEvent) {
        Intrinsics.checkParameterIsNotNull(requestEvent, "requestEvent");
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.qqmini.minigame.plugins.AudioVolumeJsPlugin$onAudioVolumeChange$1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    AudioVolumeJsPlugin.this.e(requestEvent);
                } catch (Exception e16) {
                    QMLog.e("AudioVolumeJsPlugin", "registerAudioVolumeChangeReceiver exception.", e16);
                }
            }
        });
        d(requestEvent);
        String ok5 = requestEvent.ok();
        Intrinsics.checkExpressionValueIsNotNull(ok5, "requestEvent.ok()");
        return ok5;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin, com.tencent.qqmini.sdk.launcher.core.plugins.ILifeCycle
    public void onDestroy() {
        super.onDestroy();
        f();
    }
}
