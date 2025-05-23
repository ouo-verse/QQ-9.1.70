package com.tencent.biz.pubaccount.weishi.net;

import android.util.Log;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import mqq.app.AppRuntime;

/* compiled from: P */
@Deprecated
/* loaded from: classes32.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    private static Object f80977a = new Object();

    /* renamed from: b, reason: collision with root package name */
    private static i f80978b;

    i() {
    }

    public static i a() {
        if (f80978b == null) {
            synchronized (f80977a) {
                if (f80978b == null) {
                    f80978b = new i();
                }
            }
        }
        return f80978b;
    }

    public int b(j jVar, b bVar) {
        if (jVar == null) {
            return 1000004;
        }
        jVar.v(bVar);
        jVar.F = System.currentTimeMillis();
        try {
            WeishiIntent weishiIntent = new WeishiIntent(BaseApplication.getContext(), k.class);
            weishiIntent.setWithouLogin(true);
            weishiIntent.f80928d = (l) bVar;
            weishiIntent.putExtra("timeout", jVar.T);
            l lVar = weishiIntent.f80928d;
            if (lVar != null && lVar.f80994g != null) {
                AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
                if (runtime != null) {
                    runtime.startServlet(weishiIntent);
                    Log.i("weishi", "cmd=" + jVar.uniKey() + ", pkgId=" + jVar.getRequestPkgId() + " submit to MSF, isLogin: " + runtime.isLogin());
                } else {
                    Log.e("weishi", "app is null");
                }
                return 0;
            }
            return 1000004;
        } catch (Exception e16) {
            Log.e("weishi", "WeishiProtocolService occur exception. stack=" + e16.getLocalizedMessage());
            return 0;
        }
    }
}
