package com.tencent.mobileqq.tvideo.base;

import android.content.Context;
import android.text.TextUtils;
import androidx.lifecycle.Lifecycle;
import com.tencent.mobileqq.mqq.api.IAccountRuntime;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tvideo.account.qqconnect.TVideoQQConnectToken;
import com.tencent.mobileqq.tvideo.history.TVideoWatchHistoryUpdateHelper;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserCookieMonster;
import com.tencent.mobileqq.webview.swift.cookie.SwiftTicketCookie;
import com.tencent.qphone.base.util.QLog;
import zt2.k;

/* compiled from: P */
/* loaded from: classes19.dex */
public class b {
    private void a() {
        TVideoQQConnectToken j3 = zt2.e.f453199a.j();
        if (j3 != null) {
            String qqUin = j3.getQqUin();
            String account = ((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount();
            if (!TextUtils.equals(qqUin, account)) {
                QLog.d("QFSLayerTVideoInitTask", 1, "accountChanged saveUin = " + qqUin + " currentUin = " + account);
                c();
                return;
            }
            return;
        }
        c();
    }

    private void b(String str) {
        if (SwiftBrowserCookieMonster.s(str) != null) {
            SwiftTicketCookie.f314535h = jy2.g.l(true);
            SwiftBrowserCookieMonster.s(str).n(str);
        }
    }

    private void c() {
        zt2.e.f453199a.n();
        b("https://film.video.qq.com");
        b("https://film.qq.com");
    }

    public void d(Context context, Lifecycle lifecycle) {
        QLog.d("QFSLayerTVideoInitTask", 1, "initTask");
        a();
        if (!zt2.e.f453199a.k()) {
            k.e();
        }
        iy2.a.d();
        gu2.h.a();
        jx2.c.k().l(context);
        qx2.a.c().g();
        TVideoWatchHistoryUpdateHelper tVideoWatchHistoryUpdateHelper = new TVideoWatchHistoryUpdateHelper();
        if (lifecycle != null) {
            lifecycle.addObserver(tVideoWatchHistoryUpdateHelper);
        }
        com.tencent.mobileqq.tvideo.temporaryauth.d.j();
    }
}
