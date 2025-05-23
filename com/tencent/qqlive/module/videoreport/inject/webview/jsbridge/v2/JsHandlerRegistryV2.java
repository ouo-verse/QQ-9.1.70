package com.tencent.qqlive.module.videoreport.inject.webview.jsbridge.v2;

import com.tencent.qqlive.module.videoreport.inject.webview.jsbridge.jsinterface.IJsHandler;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes22.dex */
public class JsHandlerRegistryV2 {
    private static final String KEY_GET_SDK_INFO_V2 = "vr_getSdkVersion";
    private static final String KEY_REPORT_EVENT_V2 = "vr_reportEvent";
    private final Map<String, IJsHandler> mJsHandlers;

    public JsHandlerRegistryV2(Object obj) {
        HashMap hashMap = new HashMap();
        this.mJsHandlers = hashMap;
        WeakReference weakReference = new WeakReference(obj);
        hashMap.put(KEY_REPORT_EVENT_V2, new JsReportHandlerV2(weakReference));
        hashMap.put(KEY_GET_SDK_INFO_V2, new JsSdkInfoHandlerV2(weakReference));
    }

    public IJsHandler getJsHandler(String str) {
        return this.mJsHandlers.get(str);
    }
}
