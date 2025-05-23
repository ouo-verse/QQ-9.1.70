package com.tencent.mobileqq.webview.config;

import com.tencent.freesia.IConfigData;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import tl.h;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\b\u0018\u0000 \u001b2\u00020\u0001:\u0001\u0005B\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\b\u001a\u00020\u0006J\u0006\u0010\t\u001a\u00020\u0006J\u0006\u0010\n\u001a\u00020\u0006J\u0006\u0010\u000b\u001a\u00020\u0006J\b\u0010\r\u001a\u00020\fH\u0016R\u001b\u0010\u0011\u001a\u00020\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0013\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0012R\u0016\u0010\u0016\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0015R\u0016\u0010\u0018\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0012\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/webview/config/WebViewMainProcConfig;", "Lcom/tencent/freesia/IConfigData;", "Lorg/json/JSONObject;", "jsonObj", "", "a", "", "d", "g", "e", "c", "f", "", "toString", "Lkotlin/Lazy;", "b", "()Z", "switchOn", "Z", "useX5Core", "", "I", "sandboxLevel", h.F, "sandboxFallbackOn", "<init>", "()V", "i", "webview_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class WebViewMainProcConfig implements IConfigData {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Lazy switchOn;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean useX5Core;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private int sandboxLevel;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean fallbackOn;

    public WebViewMainProcConfig() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.mobileqq.webview.config.WebViewMainProcConfig$switchOn$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                return Boolean.valueOf(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("webview_mainproc_config", false));
            }
        });
        this.switchOn = lazy;
        this.useX5Core = true;
        this.fallbackOn = true;
    }

    private final boolean b() {
        return ((Boolean) this.switchOn.getValue()).booleanValue();
    }

    public final void a(JSONObject jsonObj) {
        Intrinsics.checkNotNullParameter(jsonObj, "jsonObj");
        if (QLog.isColorLevel()) {
            QLog.d("WebViewMainProc_config", 2, "from json:" + jsonObj);
        }
        this.useX5Core = jsonObj.optInt("coreType", 1) == 1;
        this.sandboxLevel = jsonObj.optInt("sandboxLevel", 3);
        this.fallbackOn = jsonObj.optInt("sandboxFallbackOn", 1) == 1;
    }

    public final boolean c() {
        return this.sandboxLevel == 3;
    }

    public final boolean d() {
        return b();
    }

    public final boolean e() {
        return this.sandboxLevel >= 1;
    }

    /* renamed from: f, reason: from getter */
    public final boolean getFallbackOn() {
        return this.fallbackOn;
    }

    /* renamed from: g, reason: from getter */
    public final boolean getUseX5Core() {
        return this.useX5Core;
    }

    public String toString() {
        return "switchOn=" + b() + " useX5Core= " + this.useX5Core + ", sandboxLevel= " + this.sandboxLevel + ", fallbackOn= " + this.fallbackOn;
    }
}
