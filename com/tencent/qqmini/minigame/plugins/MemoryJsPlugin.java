package com.tencent.qqmini.minigame.plugins;

import android.app.ActivityManager;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Debug;
import android.os.Process;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.utils.MiniSDKConst;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@JsPlugin
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0012\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fH\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/qqmini/minigame/plugins/MemoryJsPlugin;", "Lcom/tencent/qqmini/sdk/launcher/core/plugins/BaseJsPlugin;", "()V", "componentCallbacks", "Landroid/content/ComponentCallbacks2;", "hasRegisterComponent", "", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", MiniSDKConst.ON_APP_LOW_MEMORY, "", "req", "Lcom/tencent/qqmini/sdk/launcher/core/model/RequestEvent;", "registerComponentCallback", "Companion", "lib_minigame_internalRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes23.dex */
public final class MemoryJsPlugin extends BaseJsPlugin {
    private static final String TAG = "MemoryJsPlugin";
    private ComponentCallbacks2 componentCallbacks;
    private boolean hasRegisterComponent;

    private final void registerComponentCallback(final RequestEvent req) {
        try {
            this.componentCallbacks = new ComponentCallbacks2() { // from class: com.tencent.qqmini.minigame.plugins.MemoryJsPlugin$registerComponentCallback$1
                @Override // android.content.ComponentCallbacks
                public void onConfigurationChanged(@NotNull Configuration newConfig) {
                    Intrinsics.checkParameterIsNotNull(newConfig, "newConfig");
                }

                @Override // android.content.ComponentCallbacks
                public void onLowMemory() {
                    Context context;
                    context = ((BaseJsPlugin) MemoryJsPlugin.this).mContext;
                    Object systemService = context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
                    if (systemService != null) {
                        Debug.MemoryInfo memoryInfo = SystemMethodProxy.getProcessMemoryInfo((ActivityManager) systemService, new int[]{Process.myPid()})[0];
                        if (memoryInfo != null) {
                            QMLog.e("MemoryJsPlugin", "onLowMemory!!!!!! Meminfo:dalvikPss[" + memoryInfo.dalvikPss + "],nativePss[" + memoryInfo.nativePss + "],otherPss[" + memoryInfo.otherPss + "],total[" + memoryInfo.getTotalPss() + ']');
                            return;
                        }
                        return;
                    }
                    throw new TypeCastException("null cannot be cast to non-null type android.app.ActivityManager");
                }

                @Override // android.content.ComponentCallbacks2
                public void onTrimMemory(int level) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("level", level);
                    req.jsService.evaluateSubscribeJS(MiniSDKConst.ON_APP_LOW_MEMORY, jSONObject.toString(), -1);
                }
            };
            Context mContext = this.mContext;
            Intrinsics.checkExpressionValueIsNotNull(mContext, "mContext");
            mContext.getApplicationContext().registerComponentCallbacks(this.componentCallbacks);
        } catch (Exception e16) {
            QMLog.e(TAG, "registerComponentCallback failed.", e16);
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin, com.tencent.qqmini.sdk.launcher.core.plugins.ILifeCycle
    public void onDestroy() {
        super.onDestroy();
        if (this.hasRegisterComponent && this.componentCallbacks != null) {
            Context mContext = this.mContext;
            Intrinsics.checkExpressionValueIsNotNull(mContext, "mContext");
            mContext.getApplicationContext().unregisterComponentCallbacks(this.componentCallbacks);
        }
    }

    @JsEvent({MiniSDKConst.ON_APP_LOW_MEMORY})
    @Nullable
    public final String onMemoryWarning(@NotNull RequestEvent req) {
        Intrinsics.checkParameterIsNotNull(req, "req");
        if (!this.hasRegisterComponent) {
            registerComponentCallback(req);
            this.hasRegisterComponent = true;
            return null;
        }
        return null;
    }
}
