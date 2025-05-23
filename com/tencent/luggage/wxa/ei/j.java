package com.tencent.luggage.wxa.ei;

import android.webkit.ValueCallback;
import java.net.URL;

/* compiled from: P */
/* loaded from: classes8.dex */
public interface j extends p {
    k a(Class cls);

    void a(URL url, String str, ValueCallback valueCallback);

    void a(URL url, String str, String str2, int i3, String str3, ValueCallback valueCallback);

    void addJavascriptInterface(Object obj, String str);

    void destroy();

    void setJsExceptionHandler(i iVar);
}
