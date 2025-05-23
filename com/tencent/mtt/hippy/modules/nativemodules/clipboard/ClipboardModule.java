package com.tencent.mtt.hippy.modules.nativemodules.clipboard;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.os.Build;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase;
import com.tencent.mtt.hippy.utils.ContextHolder;
import com.tencent.qmethod.pandoraex.monitor.ClipboardMonitor;

/* compiled from: P */
@HippyNativeModule(name = "ClipboardModule")
/* loaded from: classes20.dex */
public class ClipboardModule extends HippyNativeModuleBase {

    /* renamed from: a, reason: collision with root package name */
    private final ClipboardManager f337508a;

    public ClipboardModule(HippyEngineContext hippyEngineContext) {
        super(hippyEngineContext);
        this.f337508a = (ClipboardManager) this.mContext.getGlobalConfigs().getContext().getSystemService("clipboard");
    }

    private ClipboardManager a() {
        return this.f337508a;
    }

    @HippyMethod(name = "getString")
    public void getString(Promise promise) {
        if (Build.VERSION.SDK_INT < 29 && ContextHolder.isAppOnBackground()) {
            promise.resolve("");
            return;
        }
        try {
            ClipData primaryClip = ClipboardMonitor.getPrimaryClip(a());
            if (primaryClip != null && primaryClip.getItemCount() >= 1) {
                promise.resolve("" + ((Object) primaryClip.getItemAt(0).getText()));
                return;
            }
            promise.resolve("");
        } catch (Exception e16) {
            promise.reject(e16);
        }
    }

    @HippyMethod(name = "setString")
    public void setString(String str) {
        if (Build.VERSION.SDK_INT < 29 && ContextHolder.isAppOnBackground()) {
            return;
        }
        ClipboardMonitor.setPrimaryClip(a(), ClipData.newPlainText(null, str));
    }
}
