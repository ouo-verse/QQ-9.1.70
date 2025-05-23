package com.tencent.mobileqq.webview.config;

import com.tencent.freesia.IConfigData;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u0000 \u000f2\u00020\u0001:\u0001\u0005B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0007\u001a\u00020\u0006J\b\u0010\t\u001a\u00020\bH\u0016R\u0016\u0010\f\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/webview/config/b;", "Lcom/tencent/freesia/IConfigData;", "Lorg/json/JSONObject;", "jsonObj", "", "a", "", "b", "", "toString", "d", "Z", "fallback2SoftSandboxForPerf", "<init>", "()V", "e", "webview_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class b implements IConfigData {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean fallbackEnabled = true;

    public final void a(JSONObject jsonObj) {
        Intrinsics.checkNotNullParameter(jsonObj, "jsonObj");
        if (QLog.isColorLevel()) {
            QLog.d("HardSandBoxConfig_SandBoxControl", 2, "from json:" + jsonObj);
        }
        this.fallbackEnabled = jsonObj.optInt("enableFallback", 1) == 1;
    }

    /* renamed from: b, reason: from getter */
    public final boolean getFallbackEnabled() {
        return this.fallbackEnabled;
    }

    public String toString() {
        return "fallbackEnabled= " + this.fallbackEnabled;
    }
}
