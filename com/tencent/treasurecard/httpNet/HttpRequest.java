package com.tencent.treasurecard.httpNet;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.tencent.mobileqq.msf.sdk.utils.SignUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.vas.treasurecard.FtConstants;
import com.tencent.mobileqq.vaswebviewplugin.TreasureCardJsPlugin;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import com.tencent.treasurecard.bean.c;
import com.tencent.treasurecard.util.a;
import com.tencent.treasurecard.util.d;
import java.io.IOException;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONException;
import org.json.JSONObject;
import to4.b;

/* compiled from: P */
/* loaded from: classes26.dex */
public class HttpRequest implements b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private Context f381180a;

    /* renamed from: b, reason: collision with root package name */
    private int f381181b;

    public HttpRequest(Context context, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, i3);
        } else {
            this.f381180a = context;
            this.f381181b = i3;
        }
    }

    private String i(String str, String str2, long j3) throws Exception {
        byte[] bytes = ("POST\n" + str + "\n" + j3 + "\n" + str2 + "\n").getBytes("utf-8");
        Signature signature = Signature.getInstance(SignUtils.SIGNATURE_SHA256withRSA);
        signature.initSign(m("MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAM1S69E7szKnBvWZ\nFPiD/0I/rQF9ESRi7dPh9lM//oLw1D0QfVrBbdTbBrkTddPkOdzbVrSkRw1yx0/M\nGuLJi1edu1kA1Sk+VwCMn/x3H5OhSN39ntHnLjuQIhmqLR+8XhUl4kaQVqqG8Sjf\nG8y+M2iMnIPfqEu756MOpxLulObDAgMBAAECgYB6wIFlhOicdsktWcj0zo10APeg\ntTHjbBW9oBERMmgpxmtM2qfm80+DezKowV6nQIHrbWKH+tLT0nQgW+kS/uWDeRDI\nwhFV/z3tiUqVPvwl2QpYit32bT/DyVYjK09KurXebweCwRdD9DCWNXRifEiYiiMN\nVNja5qTkUa7WJ6lkuQJBAOaCZvw/DH5oldQ7O/ehYmt2dgO3/RKMXa16D8O+LlLv\nExHaOGjGwhCfIkMuIQXmSNR5zGGj9gfMG+sh2cxGSoUCQQDkB4gUhzcBVb5Wkay5\nHJyADQequNg/EqVkxvCtRC3eb8c1petaCROiadG5c180e1NOIl4O/Ll9nf6f74QI\ntEKnAkAtZom6LQDc9ORtxKzu/Q5RdCeSW+6wdI0O2fe46gBdvVDYN07c9CjM9Ure\nSHugmdbGYqbqpEyVBJKLIUOwhDexAkEA3WTqnHPD1gn36Xk6p+e9kx4TiZA6dNKX\nvsbgunltx3/jfJUBcsNJSvFO7K21i/EJKt13UTnSpsIVjBcyrHjIFQJACFdATri1\nD0aWFWP0Ey3L/TGbIFgYTDITZVZ81hauKgb9L3Yhkx2iWoonMiyWjH3RhgVGbs83\nMHaUYoX/5275xQ=="));
        signature.update(bytes);
        return new String(Base64.encode(signature.sign(), 2));
    }

    private boolean j(int i3, long j3, Context context) {
        if (-1 != i3 && d.c().f(Long.valueOf(j3)).booleanValue()) {
            return true;
        }
        return false;
    }

    private Request k(String str, String str2) {
        String str3;
        String str4 = "https://cmgate.vip.qq.com" + str;
        RequestBody create = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), str2);
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        try {
            str3 = i(str, str2, currentTimeMillis);
        } catch (Exception e16) {
            e16.printStackTrace();
            str3 = null;
        }
        return new Request.Builder().url(str4).addHeader("Authorization", str3).addHeader("Timestamp", currentTimeMillis + "").post(create).build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject l(ResponseBody responseBody) {
        try {
            return new JSONObject(responseBody.string());
        } catch (IOException e16) {
            e16.printStackTrace();
            return null;
        } catch (JSONException e17) {
            e17.printStackTrace();
            return null;
        }
    }

    private PrivateKey m(String str) throws Exception {
        return KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(Base64.decode(str.getBytes(), 2)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String n(String str) {
        try {
            Response execute = new OkHttpClient().newCall(new Request.Builder().url(str).build()).execute();
            if (execute.isSuccessful()) {
                return execute.body().string();
            }
            return "" + execute.code() + execute.message();
        } catch (Exception e16) {
            Log.d(TreasureCardJsPlugin.BUSINESS_NAME, "requestHttp " + e16.getMessage());
            e16.printStackTrace();
            return null;
        }
    }

    private com.tencent.treasurecard.bean.b o(Context context) {
        return new com.tencent.treasurecard.bean.b(FtConstants.CHANNEL_ID, "" + a.b());
    }

    @Override // to4.b
    public void a(String str, to4.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str, (Object) aVar);
            return;
        }
        Log.d(TreasureCardJsPlugin.BUSINESS_NAME, "userInfoRequest ");
        new BaseThread(new Runnable(new OkHttpClient().newBuilder().build(), k("/sdk/get-subscribe", "{\"appid\":" + this.f381181b + ",\"UserCode\":\"" + str + "\"}"), aVar) { // from class: com.tencent.treasurecard.httpNet.HttpRequest.3
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ OkHttpClient f381194d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ Request f381195e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ to4.a f381196f;

            {
                this.f381194d = r6;
                this.f381195e = r7;
                this.f381196f = aVar;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, HttpRequest.this, r6, r7, aVar);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                Response response;
                JSONObject l3;
                int i3;
                long j3;
                int i16;
                String str2;
                int i17;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                try {
                    response = this.f381194d.newCall(this.f381195e).execute();
                } catch (IOException e16) {
                    e16.printStackTrace();
                    response = null;
                }
                if (response == null || (l3 = HttpRequest.this.l(response.body())) == null) {
                    return;
                }
                int i18 = -1;
                long j16 = 0;
                int i19 = 0;
                try {
                    i17 = l3.getInt("IsFlowFree");
                } catch (JSONException e17) {
                    e = e17;
                    i3 = 0;
                    j3 = 0;
                    i16 = -1;
                }
                try {
                    i18 = l3.getInt("RetCode");
                    j16 = l3.getLong("NextReqTime");
                    i19 = l3.getInt("FlowThreshold");
                    str2 = l3.getString("FlowThresholdText");
                } catch (JSONException e18) {
                    e = e18;
                    long j17 = j16;
                    i16 = i18;
                    i18 = i17;
                    i3 = i19;
                    j3 = j17;
                    e.printStackTrace();
                    str2 = "";
                    int i26 = i3;
                    i17 = i18;
                    i18 = i16;
                    j16 = j3;
                    i19 = i26;
                    d.c().l(Long.valueOf(j16));
                    d.c().k(i19, str2);
                    new Handler(Looper.getMainLooper()).post(new Runnable(i18, i17) { // from class: com.tencent.treasurecard.httpNet.HttpRequest.3.1
                        static IPatchRedirector $redirector_;

                        /* renamed from: d, reason: collision with root package name */
                        final /* synthetic */ int f381197d;

                        /* renamed from: e, reason: collision with root package name */
                        final /* synthetic */ int f381198e;

                        {
                            this.f381197d = i18;
                            this.f381198e = i17;
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                iPatchRedirector3.redirect((short) 1, this, AnonymousClass3.this, Integer.valueOf(i18), Integer.valueOf(i17));
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                iPatchRedirector3.redirect((short) 2, (Object) this);
                                return;
                            }
                            if (AnonymousClass3.this.f381196f != null) {
                                Log.d(TreasureCardJsPlugin.BUSINESS_NAME, "userInfoRequest callBack.onResponse finalCode " + this.f381197d + " finalCardState " + this.f381198e);
                                AnonymousClass3.this.f381196f.a(this.f381197d, Integer.valueOf(this.f381198e));
                            }
                        }
                    });
                }
                d.c().l(Long.valueOf(j16));
                d.c().k(i19, str2);
                new Handler(Looper.getMainLooper()).post(new Runnable(i18, i17) { // from class: com.tencent.treasurecard.httpNet.HttpRequest.3.1
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ int f381197d;

                    /* renamed from: e, reason: collision with root package name */
                    final /* synthetic */ int f381198e;

                    {
                        this.f381197d = i18;
                        this.f381198e = i17;
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                            iPatchRedirector3.redirect((short) 1, this, AnonymousClass3.this, Integer.valueOf(i18), Integer.valueOf(i17));
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                            iPatchRedirector3.redirect((short) 2, (Object) this);
                            return;
                        }
                        if (AnonymousClass3.this.f381196f != null) {
                            Log.d(TreasureCardJsPlugin.BUSINESS_NAME, "userInfoRequest callBack.onResponse finalCode " + this.f381197d + " finalCardState " + this.f381198e);
                            AnonymousClass3.this.f381196f.a(this.f381197d, Integer.valueOf(this.f381198e));
                        }
                    }
                });
            }
        }).start();
    }

    @Override // to4.b
    public boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        if (a.b() == 1) {
            return true;
        }
        return false;
    }

    @Override // to4.b
    public boolean c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return !d.c().g(Long.valueOf(com.tencent.treasurecard.manager.a.f381202b)).booleanValue();
    }

    @Override // to4.b
    public void d(String str, to4.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str, (Object) aVar);
        } else {
            Log.d(TreasureCardJsPlugin.BUSINESS_NAME, "pcIdRequest ");
            new BaseThread(new Runnable(str, aVar) { // from class: com.tencent.treasurecard.httpNet.HttpRequest.2
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ String f381189d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ to4.a f381190e;

                {
                    this.f381189d = str;
                    this.f381190e = aVar;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, HttpRequest.this, str, aVar);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    int i3;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        c a16 = new c().a(HttpRequest.this.n(this.f381189d));
                        try {
                            i3 = Integer.valueOf(a16.f381163e).intValue();
                        } catch (Exception unused) {
                            i3 = 1003;
                        }
                        new Handler(Looper.getMainLooper()).post(new Runnable(i3, a16) { // from class: com.tencent.treasurecard.httpNet.HttpRequest.2.1
                            static IPatchRedirector $redirector_;

                            /* renamed from: d, reason: collision with root package name */
                            final /* synthetic */ int f381191d;

                            /* renamed from: e, reason: collision with root package name */
                            final /* synthetic */ c f381192e;

                            {
                                this.f381191d = i3;
                                this.f381192e = a16;
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                    iPatchRedirector3.redirect((short) 1, this, AnonymousClass2.this, Integer.valueOf(i3), a16);
                                }
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                    iPatchRedirector3.redirect((short) 2, (Object) this);
                                    return;
                                }
                                if (AnonymousClass2.this.f381190e != null) {
                                    Log.d(TreasureCardJsPlugin.BUSINESS_NAME, "pcIdRequest callBack.onResponse finalCode " + this.f381191d + " serInfo.pcId " + this.f381192e.f381166h);
                                    AnonymousClass2.this.f381190e.a(this.f381191d, this.f381192e.f381166h);
                                }
                            }
                        });
                        return;
                    }
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            }).start();
        }
    }

    @Override // to4.b
    public void e(to4.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) aVar);
            return;
        }
        Log.d(TreasureCardJsPlugin.BUSINESS_NAME, "signRequest ");
        com.tencent.treasurecard.bean.b o16 = o(this.f381180a);
        new BaseThread(new Runnable(new OkHttpClient().newBuilder().build(), k("/sdk/get-if-sign", "{\"appid\":" + this.f381181b + ",\"signContent\":\"" + o16.d() + "\"}"), o16, aVar) { // from class: com.tencent.treasurecard.httpNet.HttpRequest.1
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ OkHttpClient f381182d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ Request f381183e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ com.tencent.treasurecard.bean.b f381184f;

            /* renamed from: h, reason: collision with root package name */
            final /* synthetic */ to4.a f381185h;

            {
                this.f381182d = r6;
                this.f381183e = r7;
                this.f381184f = o16;
                this.f381185h = aVar;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, HttpRequest.this, r6, r7, o16, aVar);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                Response response;
                JSONObject l3;
                int i3;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                String str = null;
                try {
                    response = this.f381182d.newCall(this.f381183e).execute();
                } catch (IOException e16) {
                    e16.printStackTrace();
                    response = null;
                }
                if (response == null || (l3 = HttpRequest.this.l(response.body())) == null) {
                    return;
                }
                try {
                    str = l3.getString("sign");
                    i3 = l3.getInt("RetCode");
                } catch (JSONException e17) {
                    e17.printStackTrace();
                    i3 = -1;
                }
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                new Handler(Looper.getMainLooper()).post(new Runnable(i3, this.f381184f.a(str).g("http://wap.cmpassport.com/openapi/wabpGetUseInfo")) { // from class: com.tencent.treasurecard.httpNet.HttpRequest.1.1
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ int f381186d;

                    /* renamed from: e, reason: collision with root package name */
                    final /* synthetic */ String f381187e;

                    {
                        this.f381186d = i3;
                        this.f381187e = r7;
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                            iPatchRedirector3.redirect((short) 1, this, AnonymousClass1.this, Integer.valueOf(i3), r7);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                            iPatchRedirector3.redirect((short) 2, (Object) this);
                            return;
                        }
                        if (AnonymousClass1.this.f381185h != null) {
                            Log.d(TreasureCardJsPlugin.BUSINESS_NAME, "signRequest callBack.onResponse finalCode " + this.f381186d + " finalUrl " + this.f381187e);
                            AnonymousClass1.this.f381185h.a(this.f381186d, this.f381187e);
                        }
                    }
                });
            }
        }).start();
    }

    @Override // to4.b
    public void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        Log.d(TreasureCardJsPlugin.BUSINESS_NAME, "activeInfoRequest ");
        int b16 = d.c().b();
        if (j(b16, com.tencent.treasurecard.manager.a.f381202b, this.f381180a)) {
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("{\"appid\":");
        sb5.append(this.f381181b);
        sb5.append(",\"BizType\":");
        int i3 = 1;
        if (b16 != 1) {
            i3 = 0;
        }
        sb5.append(i3);
        sb5.append("}");
        new BaseThread(new Runnable(new OkHttpClient().newBuilder().build(), k("/sdk/get-flow-conf", sb5.toString())) { // from class: com.tencent.treasurecard.httpNet.HttpRequest.4
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ OkHttpClient f381200d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ Request f381201e;

            {
                this.f381200d = r8;
                this.f381201e = r9;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, HttpRequest.this, r8, r9);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                Response response;
                JSONObject l3;
                String str;
                String str2 = "";
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                try {
                    response = this.f381200d.newCall(this.f381201e).execute();
                } catch (IOException e16) {
                    e16.printStackTrace();
                    response = null;
                }
                if (response == null || (l3 = HttpRequest.this.l(response.body())) == null) {
                    return;
                }
                try {
                    str = l3.getString("Tips");
                } catch (JSONException e17) {
                    e = e17;
                    str = "";
                }
                try {
                    str2 = l3.getString("JumpUrl");
                } catch (JSONException e18) {
                    e = e18;
                    e.printStackTrace();
                    Log.d(TreasureCardJsPlugin.BUSINESS_NAME, "activeInfoRequest callBack.onResponse jumpUrl " + str2 + " tips " + str);
                    d.c().h(str2, str);
                }
                Log.d(TreasureCardJsPlugin.BUSINESS_NAME, "activeInfoRequest callBack.onResponse jumpUrl " + str2 + " tips " + str);
                d.c().h(str2, str);
            }
        }).start();
    }
}
