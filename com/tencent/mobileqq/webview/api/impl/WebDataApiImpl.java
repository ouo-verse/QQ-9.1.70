package com.tencent.mobileqq.webview.api.impl;

import android.content.Intent;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper;
import com.tencent.mobileqq.webprocess.WebProcessReceiver;
import com.tencent.mobileqq.webview.api.IWebDataApi;
import com.tencent.mobileqq.webview.injector.q;
import com.tencent.mobileqq.webview.util.t;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.TbsDownloader;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\b\u0018\u0000 \f2\u00020\u0001:\u0001\rB\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\u0002H\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/webview/api/impl/WebDataApiImpl;", "Lcom/tencent/mobileqq/webview/api/IWebDataApi;", "", "clearWebCache", "clearOfflineCache", "clearWebCacheOnAbi64", "", "delayMs", "preDownloadTbsDelayedIfNeed", "updateSandBoxSwitch", "<init>", "()V", "Companion", "a", "webview_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class WebDataApiImpl implements IWebDataApi {
    public static final String TAG = "WebDataImpl";

    /* JADX INFO: Access modifiers changed from: private */
    public static final void preDownloadTbsDelayedIfNeed$lambda$0() {
        boolean startsWith$default;
        String dpc = WebAccelerateHelper.getInstance().getTBSDpcParam();
        Intrinsics.checkNotNullExpressionValue(dpc, "dpc");
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(dpc, "1|1|1", false, 2, null);
        if (!startsWith$default) {
            QLog.i("WebDataImpl", 1, "preloadTbsSwitchOn=false return");
            return;
        }
        if (!TbsDownloader.needDownload(BaseApplication.getContext(), false)) {
            QLog.i("WebDataImpl", 1, "needDownload=false return");
            return;
        }
        QLog.i("WebDataImpl", 1, "send ACTION_DOWNLOAD_TBS");
        Intent intent = new Intent(BaseApplication.context, (Class<?>) WebProcessReceiver.class);
        intent.setAction(com.tencent.qqmini.miniapp.receiver.WebProcessReceiver.ACTION_DOWNLOAD_TBS);
        BaseApplication.context.sendBroadcast(intent, "com.tencent.msg.permission.pushnotify");
    }

    @Override // com.tencent.mobileqq.webview.api.IWebDataApi
    public void clearOfflineCache() {
        q.INSTANCE.a();
    }

    @Override // com.tencent.mobileqq.webview.api.IWebDataApi
    public void clearWebCache() {
        q.INSTANCE.b();
    }

    @Override // com.tencent.mobileqq.webview.api.IWebDataApi
    public void clearWebCacheOnAbi64() {
        com.tencent.mobileqq.webview.a.INSTANCE.b();
    }

    @Override // com.tencent.mobileqq.webview.api.IWebDataApi
    public void preDownloadTbsDelayedIfNeed(long delayMs) {
        ThreadManagerV2.executeDelay(new Runnable() { // from class: com.tencent.mobileqq.webview.api.impl.a
            @Override // java.lang.Runnable
            public final void run() {
                WebDataApiImpl.preDownloadTbsDelayedIfNeed$lambda$0();
            }
        }, 16, null, true, delayMs);
    }

    @Override // com.tencent.mobileqq.webview.api.IWebDataApi
    public void updateSandBoxSwitch() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            IRuntimeService runtimeService = peekAppRuntime.getRuntimeService(IFeatureRuntimeService.class, "all");
            Intrinsics.checkNotNullExpressionValue(runtimeService, "appRuntime.getRuntimeSer\u2026onstant.ALL\n            )");
            boolean isFeatureSwitchEnable = ((IFeatureRuntimeService) runtimeService).isFeatureSwitchEnable("webview_sandbox_toolproc_switch", false);
            t.Companion companion = t.INSTANCE;
            boolean booleanValue = ((Boolean) companion.a().b("webview_sandbox_toolproc_switch", Boolean.FALSE)).booleanValue();
            QLog.d("ConfigInjector", 1, "update sandboxSwitchOn newValue=" + isFeatureSwitchEnable + " oldValue=" + booleanValue);
            if (isFeatureSwitchEnable != booleanValue) {
                companion.a().d("webview_sandbox_toolproc_switch", Boolean.valueOf(isFeatureSwitchEnable));
            }
        }
    }
}
