package com.tencent.mobileqq.webview.swift.injector;

import android.content.Context;
import android.os.Bundle;
import java.io.IOException;
import mqq.app.Servlet;
import org.apache.http.HttpResponse;

/* compiled from: P */
/* loaded from: classes20.dex */
public interface n {
    String a(HttpResponse httpResponse) throws IllegalStateException, IOException;

    HttpResponse b(Context context, String str, String str2, String str3, Bundle bundle, Bundle bundle2) throws IOException;

    Class<? extends Servlet> c();

    String d();

    int getNetWorkType();
}
