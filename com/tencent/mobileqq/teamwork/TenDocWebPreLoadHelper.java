package com.tencent.mobileqq.teamwork;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.teamwork.api.ITeamWorkDocEditBrowserProxy;
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes18.dex */
public class TenDocWebPreLoadHelper {

    /* renamed from: a, reason: collision with root package name */
    public static volatile String f291578a = "";

    public static TouchWebView a(Context context) {
        bo b16 = bo.b();
        if (context == null) {
            context = BaseApplication.getContext();
        }
        return b16.c(context);
    }

    public static boolean b(Context context, String str) {
        if (!new ta1.n().a() || !(context instanceof Activity) || TextUtils.isEmpty(str)) {
            return false;
        }
        if ((!((ITeamWorkDocEditBrowserProxy) QRoute.api(ITeamWorkDocEditBrowserProxy.class)).isInstanceClass((Activity) context) && !((ITeamWorkUtils) QRoute.api(ITeamWorkUtils.class)).isDocsUrlForPreLoad(str)) || !bo.b().e()) {
            return false;
        }
        if (!str.contains(f291578a) && f291578a != null) {
            return false;
        }
        return true;
    }

    public static void c(String str) {
        QLog.d("TenDocWebPreLoadHelper", 1, "tendocpreload preCreateWebViewNoWebProcess ");
        bo.b().d(str);
    }

    public static void d(final String str) {
        QLog.d("TenDocWebPreLoadHelper", 1, "tendocpreload preloadTenDocUrl ");
        if (!TextUtils.isEmpty(str)) {
            f291578a = str;
            if (Looper.getMainLooper() == Looper.myLooper()) {
                if (((ITeamWorkUtils) QRoute.api(ITeamWorkUtils.class)).isDocsUrlForPreLoad(str) && !bo.b().g(str)) {
                    bo.b().d(str);
                    bo.b().g(str);
                    return;
                }
                return;
            }
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.tencent.mobileqq.teamwork.TenDocWebPreLoadHelper.1
                @Override // java.lang.Runnable
                public void run() {
                    TenDocWebPreLoadHelper.d(str);
                }
            });
        }
    }
}
