package com.sina.weibo.sdk.auth;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.sina.weibo.sdk.c.a;
import com.sina.weibo.sdk.c.c;
import com.sina.weibo.sdk.c.e;
import com.sina.weibo.sdk.common.UiError;
import com.sina.weibo.sdk.net.h;
import com.sina.weibo.sdk.web.WebActivity;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: g, reason: collision with root package name */
    public WeakReference<Activity> f61225g;

    /* renamed from: h, reason: collision with root package name */
    public WbAuthListener f61226h;

    public a(Activity activity) {
        this.f61225g = new WeakReference<>(activity);
    }

    public final void d() {
        c.a("WBSsoTag", "startClientAuth()");
        try {
            Activity activity = this.f61225g.get();
            a.C0511a c16 = com.sina.weibo.sdk.c.a.c(activity);
            Intent intent = new Intent();
            intent.setClassName(c16.packageName, c16.f61247am);
            AuthInfo a16 = com.sina.weibo.sdk.a.a();
            intent.putExtra(com.heytap.mcssdk.a.a.f36102l, a16.getAppKey());
            intent.putExtra("redirectUri", a16.getRedirectUrl());
            intent.putExtra("scope", a16.getScope());
            intent.putExtra("packagename", a16.getPackageName());
            intent.putExtra("key_hash", a16.getHash());
            intent.putExtra("_weibo_command_type", 3);
            StringBuilder sb5 = new StringBuilder();
            sb5.append(System.currentTimeMillis());
            intent.putExtra("_weibo_transaction", sb5.toString());
            Activity activity2 = this.f61225g.get();
            if (activity2 == null) {
                this.f61226h.onError(new UiError(-1, "activity is null", ""));
            } else {
                if (com.sina.weibo.sdk.c.a.a(activity, intent)) {
                    intent.putExtra("aid", e.f(activity2, a16.getAppKey()));
                    activity2.startActivityForResult(intent, 32973);
                    c.a("WBSsoTag", "start SsoActivity ");
                    return;
                }
                this.f61226h.onError(new UiError(-2, "your app is illegal", ""));
            }
        } catch (Exception e16) {
            e16.printStackTrace();
            c.b("WBSsoTag", e16.getMessage());
            this.f61226h.onError(new UiError(-3, "occur exception", e16.getMessage()));
        }
    }

    public final void e() {
        Activity activity = this.f61225g.get();
        h hVar = new h();
        AuthInfo a16 = com.sina.weibo.sdk.a.a();
        if (a16 == null) {
            return;
        }
        hVar.put(CommonConstant.ReqAccessTokenParam.CLIENT_ID, a16.getAppKey());
        hVar.put(CommonConstant.ReqAccessTokenParam.REDIRECT_URI, a16.getRedirectUrl());
        hVar.put("scope", a16.getScope());
        hVar.put("packagename", a16.getPackageName());
        hVar.put("key_hash", a16.getHash());
        hVar.put(CommonConstant.ReqAccessTokenParam.RESPONSE_TYPE, "code");
        hVar.put("version", "0041005000");
        hVar.put("luicode", "10000360");
        hVar.put("lfid", "OP_" + a16.getAppKey());
        Oauth2AccessToken readAccessToken = AccessTokenHelper.readAccessToken(activity);
        if (readAccessToken != null) {
            String accessToken = readAccessToken.getAccessToken();
            if (!TextUtils.isEmpty(readAccessToken.getAccessToken())) {
                hVar.put("trans_token", accessToken);
                hVar.put("trans_access_token", accessToken);
            }
        }
        String f16 = e.f(activity, a16.getAppKey());
        if (!TextUtils.isEmpty(f16)) {
            hVar.put("aid", f16);
        }
        String str = "https://open.weibo.cn/oauth2/authorize?" + hVar.k();
        if (this.f61226h != null) {
            b f17 = b.f();
            StringBuilder sb5 = new StringBuilder();
            sb5.append(System.currentTimeMillis());
            String sb6 = sb5.toString();
            f17.a(sb6, this.f61226h);
            Intent intent = new Intent(activity, (Class<?>) WebActivity.class);
            com.sina.weibo.sdk.web.b.a aVar = new com.sina.weibo.sdk.web.b.a(a16, str, sb6);
            Bundle bundle = new Bundle();
            aVar.writeToBundle(bundle);
            intent.putExtras(bundle);
            activity.startActivity(intent);
        }
    }
}
