package com.tencent.mobileqq.qqexpand.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/qqexpand/utils/m;", "", "Landroid/content/Context;", "context", "", "url", "", "b", "c", "a", "<init>", "()V", "qqexpand_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    public static final m f264104a = new m();

    m() {
    }

    public final void a(Context context, String url) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (TextUtils.isEmpty(url)) {
            l.f264102a.a().e("NativeNavigateUtils", 1, "schema url is null", null);
            return;
        }
        l lVar = l.f264102a;
        if (QLog.isColorLevel()) {
            lVar.a().d("NativeNavigateUtils", 2, "navigateBySchema: " + url + " ");
        }
        Bundle bundle = new Bundle();
        bundle.putString("data", url);
        QIPCClientHelper.getInstance().callServer("ExpandFlutterIPCServer", "notifyOpenSchema", bundle, null);
    }

    public final void b(Context context, String url) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (!((IMiniAppService) QRoute.api(IMiniAppService.class)).isMiniAppUrl(url)) {
            l.f264102a.a().e("NativeNavigateUtils", 1, "jumpUrl: " + url + " is not miniapp ", null);
            return;
        }
        l lVar = l.f264102a;
        if (QLog.isColorLevel()) {
            lVar.a().d("NativeNavigateUtils", 2, "navigateMiniApp: " + url + " ");
        }
        ((IMiniAppService) QRoute.api(IMiniAppService.class)).startMiniApp(context, url, 2065, null);
    }

    public final void c(Context context, String url) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (TextUtils.isEmpty(url)) {
            l.f264102a.a().e("NativeNavigateUtils", 1, "web url is null", null);
            return;
        }
        l lVar = l.f264102a;
        if (QLog.isColorLevel()) {
            lVar.a().d("NativeNavigateUtils", 2, "navigateWebView: " + url + " ");
        }
        Intent intent = new Intent(context, (Class<?>) QQBrowserActivity.class);
        intent.putExtra("url", url);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
    }
}
