package com.sina.weibo.sdk.a;

import android.content.Context;
import com.sina.weibo.sdk.c.c;
import com.weibo.ssosdk.VisitorLoginListener;
import com.weibo.ssosdk.WeiboSsoSdk;
import com.weibo.ssosdk.WeiboSsoSdkConfig;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: c, reason: collision with root package name */
    public String f61221c = "";

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* renamed from: com.sina.weibo.sdk.a.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0509a {

        /* renamed from: e, reason: collision with root package name */
        private static final a f61223e = new a();
    }

    private static void a(Context context, String str) {
        WeiboSsoSdkConfig weiboSsoSdkConfig = new WeiboSsoSdkConfig();
        weiboSsoSdkConfig.setContext(context.getApplicationContext());
        weiboSsoSdkConfig.setAppKey(str);
        weiboSsoSdkConfig.setFrom("1478195010");
        weiboSsoSdkConfig.setWm("1000_0001");
        WeiboSsoSdk.initConfig(weiboSsoSdkConfig);
    }

    public static synchronized a b() {
        a aVar;
        synchronized (a.class) {
            aVar = C0509a.f61223e;
        }
        return aVar;
    }

    public final String c(Context context, String str) {
        a(context, str);
        try {
            this.f61221c = WeiboSsoSdk.getInstance().visitorLogin().getAid();
        } catch (Exception e16) {
            c.b("AidManager", e16.getMessage());
        }
        return this.f61221c;
    }

    public final synchronized void b(Context context, String str) {
        a(context, str);
        try {
            WeiboSsoSdk.getInstance().visitorLogin(new VisitorLoginListener() { // from class: com.sina.weibo.sdk.a.a.1
                @Override // com.weibo.ssosdk.VisitorLoginListener
                public final void handler(WeiboSsoSdk.VisitorLoginInfo visitorLoginInfo) {
                    try {
                        a.this.f61221c = visitorLoginInfo.getAid();
                    } catch (Exception e16) {
                        c.b("AidManager", e16.getMessage());
                    }
                }
            });
        } catch (Exception e16) {
            c.b("AidManager", e16.getMessage());
        }
    }
}
