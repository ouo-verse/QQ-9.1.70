package com.tencent.mobileqq.zplan.web;

import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes34.dex */
public class f {
    public static void a(WebResourceResponse webResourceResponse) {
        if (webResourceResponse != null) {
            Map<String, String> responseHeaders = webResourceResponse.getResponseHeaders();
            if (responseHeaders == null) {
                responseHeaders = new HashMap<>();
            }
            responseHeaders.put("Access-Control-Allow-Origin", "*");
            webResourceResponse.setResponseHeaders(responseHeaders);
        }
    }
}
