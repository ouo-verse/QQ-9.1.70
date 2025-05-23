package com.tencent.biz.pubaccount.weishi;

import NS_KING_PUBLIC.stAuth;
import android.app.Activity;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi.util.bb;
import com.tencent.mobileqq.Doraemon.DoraemonAPIManager;
import com.tencent.mobileqq.Doraemon.IDoraemonService;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.login.QAdLoginDefine$LoginCookieKey;
import com.tencent.util.ThreeDes;
import cooperation.qzone.LocalMultiProcConfig;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes32.dex */
public class s {

    /* renamed from: g, reason: collision with root package name */
    private static volatile s f81569g;

    /* renamed from: a, reason: collision with root package name */
    private DoraemonAPIManager f81570a;

    /* renamed from: d, reason: collision with root package name */
    private volatile boolean f81573d;

    /* renamed from: e, reason: collision with root package name */
    private long f81574e;

    /* renamed from: f, reason: collision with root package name */
    private int f81575f = 0;

    /* renamed from: b, reason: collision with root package name */
    private final Map<Long, c> f81571b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    private final List<b> f81572c = Collections.synchronizedList(new ArrayList());

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public interface b {
        void onFailure(int i3);

        void onSuccess(String str, String str2);
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public String f81578a;

        /* renamed from: b, reason: collision with root package name */
        public String f81579b;

        public c(String str, String str2) {
            this.f81578a = str;
            this.f81579b = str2;
        }
    }

    s() {
        q();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(int i3, int i16) {
        this.f81575f++;
        com.tencent.biz.pubaccount.weishi.util.x.m("WSQQConnectAuthManager", "authRetry: " + this.f81575f);
        if (this.f81575f >= 3) {
            l(i3, i16);
            this.f81575f = 0;
        } else {
            e(i3);
        }
    }

    private void e(int i3) {
        DoraemonAPIManager doraemonAPIManager = this.f81570a;
        if (doraemonAPIManager == null) {
            return;
        }
        doraemonAPIManager.d("loginSilent", null, new a(i3));
    }

    private c f() {
        Map<Long, c> map = this.f81571b;
        if (map != null) {
            return map.get(Long.valueOf(bb.o()));
        }
        return null;
    }

    private Activity g() {
        SplashActivity splashActivity = SplashActivity.sWeakInstance != null ? SplashActivity.sWeakInstance.get() : null;
        return splashActivity == null ? BaseActivity.sTopActivity : splashActivity;
    }

    public static s h() {
        if (f81569g == null) {
            synchronized (s.class) {
                if (f81569g == null) {
                    f81569g = new s();
                }
            }
        }
        return f81569g;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(int i3, JSONObject jSONObject) {
        String optString = jSONObject.optString("openid");
        String optString2 = jSONObject.optString(QAdLoginDefine$LoginCookieKey.WX_ACCESS_TOKEN);
        if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
            this.f81571b.put(Long.valueOf(bb.o()), new c(optString, optString2));
        }
        String encode = ThreeDes.encode(optString, bb.y());
        String encode2 = ThreeDes.encode(optString2, bb.y());
        LocalMultiProcConfig.putString4Uin("key_qq_connect_open_id", encode, bb.o());
        LocalMultiProcConfig.putString4Uin("key_qq_connect_access_token", encode2, bb.o());
        LocalMultiProcConfig.putLong4Uin("key_qq_connect_auth_time", System.currentTimeMillis(), bb.o());
        m(i3, optString, optString2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(int i3, int i16) {
        long currentTimeMillis = System.currentTimeMillis() - this.f81574e;
        int i17 = this.f81575f;
        this.f81573d = false;
        for (b bVar : this.f81572c) {
            if (bVar != null) {
                bVar.onFailure(i16);
            }
        }
        this.f81572c.clear();
        com.tencent.biz.pubaccount.weishi.report.g.d().n((int) currentTimeMillis, i3, i17, i16, "");
    }

    private void m(int i3, String str, String str2) {
        long currentTimeMillis = System.currentTimeMillis() - this.f81574e;
        int i16 = this.f81575f;
        this.f81575f = 0;
        this.f81573d = false;
        for (b bVar : this.f81572c) {
            if (bVar != null) {
                bVar.onSuccess(str, str2);
            }
        }
        this.f81572c.clear();
        com.tencent.biz.pubaccount.weishi.report.g.d().m((int) currentTimeMillis, i3, i16);
    }

    private void n(int i3) {
        if (this.f81573d) {
            return;
        }
        this.f81574e = System.currentTimeMillis();
        this.f81573d = true;
        ((IDoraemonService) QRoute.api(IDoraemonService.class)).prepare();
        this.f81570a = ((IDoraemonService) QRoute.api(IDoraemonService.class)).createAPIManager(g(), 6, String.valueOf(1101083114));
        e(i3);
    }

    private synchronized boolean r() {
        long o16 = bb.o();
        if (this.f81571b.get(Long.valueOf(o16)) != null) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long long4Uin = LocalMultiProcConfig.getLong4Uin("key_qq_connect_auth_time", 0L, o16);
        StringBuilder sb5 = new StringBuilder();
        sb5.append("now qq connect auth time diff (sec) = ");
        long j3 = currentTimeMillis - long4Uin;
        sb5.append(j3 / 1000);
        com.tencent.biz.pubaccount.weishi.util.x.j("WSQQConnectAuthManager", sb5.toString());
        if (j3 > 1728000000) {
            return false;
        }
        String string4Uin = LocalMultiProcConfig.getString4Uin("key_qq_connect_open_id", "", o16);
        String string4Uin2 = LocalMultiProcConfig.getString4Uin("key_qq_connect_access_token", "", o16);
        String decode = ThreeDes.decode(string4Uin, bb.y());
        String decode2 = ThreeDes.decode(string4Uin2, bb.y());
        com.tencent.biz.pubaccount.weishi.util.x.c("weishi-828", "use sp openId and accessToken encrypted:" + string4Uin + " , " + string4Uin2 + ", decrypt:" + decode + " , " + decode2);
        if (!TextUtils.isEmpty(decode) && !TextUtils.isEmpty(decode2)) {
            this.f81571b.put(Long.valueOf(bb.o()), new c(decode, decode2));
            return true;
        }
        return false;
    }

    public stAuth i(String str, String str2, boolean z16) {
        c f16;
        c f17 = f();
        if (f17 != null) {
            com.tencent.biz.pubaccount.weishi.util.x.c("weishi-828", "use memory openId and accessToken" + f17.f81578a + " , " + f17.f81579b);
            return new stAuth(1, f17.f81578a, f17.f81579b);
        }
        if (r() && (f16 = f()) != null) {
            com.tencent.biz.pubaccount.weishi.util.x.c("weishi-828", "use memory openId and accessToken" + f16.f81578a + " , " + f16.f81579b);
            return new stAuth(1, f16.f81578a, f16.f81579b);
        }
        com.tencent.biz.pubaccount.weishi.util.x.m("weishi-828", "\u672a\u83b7\u53d6\u5230openId\u548caccessToken\uff0c\u4f7f\u7528\u4e86\u515c\u5e95\u65b9\u6848");
        if (z16) {
            o(1);
        }
        return new stAuth(2, str, str2);
    }

    public c j() {
        long o16 = bb.o();
        c f16 = f();
        if (f16 != null) {
            return f16;
        }
        return new c(ThreeDes.decode(LocalMultiProcConfig.getString4Uin("key_qq_connect_open_id", "", o16), bb.y()), ThreeDes.decode(LocalMultiProcConfig.getString4Uin("key_qq_connect_access_token", "", o16), bb.y()));
    }

    public void p(int i3, b bVar) {
        if (!this.f81573d) {
            this.f81572c.clear();
        }
        if (bVar != null) {
            this.f81572c.add(bVar);
        }
        n(i3);
    }

    public void q() {
        if (r()) {
            return;
        }
        o(1);
    }

    public void o(int i3) {
        p(i3, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class a implements com.tencent.mobileqq.Doraemon.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f81576a;

        a(int i3) {
            this.f81576a = i3;
        }

        @Override // com.tencent.mobileqq.Doraemon.a
        public void onFailure(int i3, String str) {
            com.tencent.biz.pubaccount.weishi.util.x.m("WSQQConnectAuthManager", "getOpenIdAndAccessToken onFailure: " + i3 + " , " + str);
            if (i3 == 1) {
                s.this.d(this.f81576a, i3);
            } else {
                s.this.l(this.f81576a, i3);
            }
        }

        @Override // com.tencent.mobileqq.Doraemon.a
        public void onPermission(int i3) {
            com.tencent.biz.pubaccount.weishi.util.x.m("WSQQConnectAuthManager", "getOpenIdAndAccessToken onPermission: " + i3);
            if (i3 != 0) {
                switch (i3) {
                    case 12:
                    case 13:
                    case 14:
                        s.this.d(this.f81576a, i3);
                        return;
                    default:
                        s.this.l(this.f81576a, i3);
                        return;
                }
            }
        }

        @Override // com.tencent.mobileqq.Doraemon.a
        public void onSuccess(JSONObject jSONObject) {
            com.tencent.biz.pubaccount.weishi.util.x.c("WSQQConnectAuthManager", "getOpenIdAndAccessToken onSuccess: " + jSONObject.toString());
            s.this.k(this.f81576a, jSONObject);
        }

        @Override // com.tencent.mobileqq.Doraemon.a
        public void onComplete() {
        }

        @Override // com.tencent.mobileqq.Doraemon.a
        public void onTrigger(JSONObject jSONObject) {
        }
    }
}
