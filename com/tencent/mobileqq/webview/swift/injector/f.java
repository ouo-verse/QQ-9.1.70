package com.tencent.mobileqq.webview.swift.injector;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.smtt.sdk.DownloadListener;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes20.dex */
public interface f {

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface a {
        String a(String str);
    }

    void a(Activity activity, Bundle bundle);

    void b(String str, String str2, String str3, String str4, long j3, Activity activity, String str5);

    void c(Bundle bundle, Activity activity, String str, String str2);

    void d(Activity activity, String str, String str2, String str3, a aVar);

    boolean e(Activity activity, String str);

    int f(String str);

    boolean g(String str);

    void h(Context context, String str, String str2, String str3);

    Bundle i(String str, String str2, String str3, String str4);

    DownloadListener j(Activity activity, AppRuntime appRuntime, Object obj, Intent intent);

    void k(String str);
}
