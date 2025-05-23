package com.tencent.mobileqq.webview.util;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.webview.swift.injector.aa;
import java.io.IOException;
import org.apache.http.HttpResponse;

/* compiled from: P */
/* loaded from: classes20.dex */
public class g {
    static IPatchRedirector $redirector_;

    public static int a() {
        return ((com.tencent.mobileqq.webview.swift.injector.n) aa.k(com.tencent.mobileqq.webview.swift.injector.n.class)).getNetWorkType();
    }

    public static String b() {
        return ((com.tencent.mobileqq.webview.swift.injector.n) aa.k(com.tencent.mobileqq.webview.swift.injector.n.class)).d();
    }

    public static HttpResponse c(Context context, String str, String str2, String str3, Bundle bundle, Bundle bundle2) throws IOException {
        return ((com.tencent.mobileqq.webview.swift.injector.n) aa.k(com.tencent.mobileqq.webview.swift.injector.n.class)).b(context, str, str2, str3, bundle, bundle2);
    }

    public static String d(HttpResponse httpResponse) throws IllegalStateException, IOException {
        return ((com.tencent.mobileqq.webview.swift.injector.n) aa.k(com.tencent.mobileqq.webview.swift.injector.n.class)).a(httpResponse);
    }
}
