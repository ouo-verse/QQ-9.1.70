package com.tencent.mobileqq.webview.injector;

import android.content.Context;
import android.os.Bundle;
import com.tencent.biz.common.util.HttpUtil;
import java.io.IOException;
import mqq.app.Servlet;
import org.apache.http.HttpResponse;

/* compiled from: P */
/* loaded from: classes35.dex */
public class k implements com.tencent.mobileqq.webview.swift.injector.n {
    @Override // com.tencent.mobileqq.webview.swift.injector.n
    public String a(HttpResponse httpResponse) throws IllegalStateException, IOException {
        return HttpUtil.readHttpResponse(httpResponse);
    }

    @Override // com.tencent.mobileqq.webview.swift.injector.n
    public HttpResponse b(Context context, String str, String str2, String str3, Bundle bundle, Bundle bundle2) throws IOException {
        String str4;
        if ("GET".equals(str3) || !"POST".equals(str3)) {
            str4 = "GET";
        } else {
            str4 = "POST";
        }
        return HttpUtil.openRequest(context, str, str2, str4, bundle, bundle2);
    }

    @Override // com.tencent.mobileqq.webview.swift.injector.n
    public Class<? extends Servlet> c() {
        return com.tencent.biz.m.class;
    }

    @Override // com.tencent.mobileqq.webview.swift.injector.n
    public String d() {
        return HttpUtil.getNetWorkTypeByStr();
    }

    @Override // com.tencent.mobileqq.webview.swift.injector.n
    public int getNetWorkType() {
        return HttpUtil.getNetWorkType();
    }
}
