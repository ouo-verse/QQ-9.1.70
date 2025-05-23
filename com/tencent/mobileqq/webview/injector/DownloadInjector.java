package com.tencent.mobileqq.webview.injector;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.webview.swift.injector.f;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.smtt.sdk.DownloadListener;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes35.dex */
public class DownloadInjector implements com.tencent.mobileqq.webview.swift.injector.f {
    @Override // com.tencent.mobileqq.webview.swift.injector.f
    public void a(Activity activity, Bundle bundle) {
        ip3.b.h().d(activity, bundle);
    }

    @Override // com.tencent.mobileqq.webview.swift.injector.f
    public void b(String str, String str2, String str3, String str4, long j3, Activity activity, String str5) {
        ip3.b.h().f(str, str2, str3, str4, j3, activity, str5);
    }

    @Override // com.tencent.mobileqq.webview.swift.injector.f
    public void c(Bundle bundle, Activity activity, String str, String str2) {
        ip3.b.h().e(bundle, activity, str, str2);
    }

    @Override // com.tencent.mobileqq.webview.swift.injector.f
    public void d(final Activity activity, final String str, final String str2, final String str3, final f.a aVar) {
        DownloadInfo downloadInfo = (DownloadInfo) ip3.b.h().g(str3);
        if (downloadInfo != null) {
            a(activity, i(str, str3, downloadInfo.f341186f, null));
        } else {
            ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.webview.injector.DownloadInjector.1
                @Override // java.lang.Runnable
                public void run() {
                    DownloadInjector.this.a(activity, DownloadInjector.this.i(str, str3, aVar.a(str2), null));
                }
            }, 8, null, true);
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.injector.f
    public boolean e(Activity activity, String str) {
        DownloadInfo downloadInfo = (DownloadInfo) ip3.b.h().g(str);
        if (downloadInfo == null || downloadInfo.f() != 4) {
            return false;
        }
        Bundle bundle = new Bundle();
        bundle.putString(com.tencent.open.downloadnew.e.f341493b, str);
        bundle.putInt(com.tencent.open.downloadnew.e.f341502k, 5);
        bundle.putBoolean(com.tencent.open.downloadnew.e.f341510s, false);
        bundle.putBoolean(com.tencent.open.downloadnew.e.f341515x, false);
        a(activity, bundle);
        return true;
    }

    @Override // com.tencent.mobileqq.webview.swift.injector.f
    public int f(String str) {
        DownloadInfo downloadInfo = (DownloadInfo) ip3.b.h().g(str);
        if (downloadInfo == null) {
            return 0;
        }
        int f16 = downloadInfo.f();
        if (f16 == 2) {
            return 1;
        }
        if (f16 == 3) {
            return 2;
        }
        if (f16 != 4) {
            return f16 != 10 ? 0 : 5;
        }
        return 3;
    }

    @Override // com.tencent.mobileqq.webview.swift.injector.f
    public boolean g(String str) {
        return ip3.b.h().i(str);
    }

    @Override // com.tencent.mobileqq.webview.swift.injector.f
    public void h(Context context, String str, String str2, String str3) {
        DownloadInfo downloadInfo = new DownloadInfo();
        downloadInfo.f341186f = str;
        downloadInfo.L = str2;
        downloadInfo.f341189h = str3;
        ip3.b.h().j(context, downloadInfo);
    }

    @Override // com.tencent.mobileqq.webview.swift.injector.f
    public Bundle i(String str, String str2, String str3, String str4) {
        Bundle bundle = new Bundle();
        bundle.putString(com.tencent.open.downloadnew.e.f341493b, str2);
        bundle.putString(com.tencent.open.downloadnew.e.f341501j, str3);
        bundle.putInt(com.tencent.open.downloadnew.e.f341502k, 2);
        bundle.putString(com.tencent.open.downloadnew.e.f341503l, str);
        bundle.putBoolean(com.tencent.open.downloadnew.e.f341510s, false);
        bundle.putBoolean(com.tencent.open.downloadnew.e.f341515x, false);
        bundle.putString(com.tencent.open.downloadnew.e.f341504m, "_" + str2);
        if (!TextUtils.isEmpty(str4)) {
            bundle.putString(com.tencent.open.downloadnew.e.f341497f, str4);
        }
        return bundle;
    }

    @Override // com.tencent.mobileqq.webview.swift.injector.f
    public DownloadListener j(Activity activity, AppRuntime appRuntime, Object obj, Intent intent) {
        return (DownloadListener) ip3.b.h().c(activity, appRuntime, obj, intent);
    }

    @Override // com.tencent.mobileqq.webview.swift.injector.f
    public void k(String str) {
        ip3.b.h().a(str, "_" + str, true);
    }
}
