package com.tencent.mobileqq.webview.webso;

import android.content.SharedPreferences;
import android.net.Uri;
import android.net.http.Headers;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.util.LruCache;
import android.text.TextUtils;
import android.util.Pair;
import androidx.core.app.NotificationCompat;
import com.qzone.proxy.covercomponent.QzoneCoverConst;
import com.tencent.ark.ark;
import com.tencent.biz.common.util.k;
import com.tencent.ditto.shell.LayoutAttrDefine;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.mobileqq.webview.webso.HybridWebReporter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.tvkplayer.event.TVKEventId;
import com.tencent.sonic.sdk.SonicSessionConnection;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;
import wns_proxy.EnumHttpMethod;
import wns_proxy.HttpReq;
import wns_proxy.HttpRsp;

/* compiled from: P */
/* loaded from: classes20.dex */
public class WebSoService implements BusinessObserver {
    static IPatchRedirector $redirector_;

    /* renamed from: i, reason: collision with root package name */
    private static volatile WebSoService f314936i;

    /* renamed from: m, reason: collision with root package name */
    private static Object f314937m;

    /* renamed from: d, reason: collision with root package name */
    private String f314938d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f314939e;

    /* renamed from: f, reason: collision with root package name */
    private HashMap<String, String> f314940f;

    /* renamed from: h, reason: collision with root package name */
    LruCache<String, WebSoState> f314941h;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class a extends LruCache<String, WebSoState> {
        static IPatchRedirector $redirector_;

        a(int i3) {
            super(i3);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) WebSoService.this, i3);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.support.v4.util.LruCache
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public WebSoState create(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (WebSoState) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            }
            return new WebSoState();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class b implements c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f314984a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ WebSoState f314985b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Handler f314986c;

        b(long j3, WebSoState webSoState, Handler handler) {
            this.f314984a = j3;
            this.f314985b = webSoState;
            this.f314986c = handler;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, WebSoService.this, Long.valueOf(j3), webSoState, handler);
            }
        }

        @Override // com.tencent.mobileqq.webview.webso.WebSoService.c
        public void onResult(String str) {
            WebSoState webSoState;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("WebSoService", 2, "verifyHtmlData cost=" + (System.currentTimeMillis() - this.f314984a));
            }
            if (!TextUtils.isEmpty(str) && (webSoState = this.f314985b) != null && webSoState.f314963f.get() != 2) {
                WebSoState webSoState2 = this.f314985b;
                webSoState2.f314974q.f314915n = true;
                webSoState2.f314959b = str;
                WebSoState webSoState3 = this.f314985b;
                webSoState3.f314962e = true;
                webSoState3.f314969l = true;
                webSoState3.f314968k = false;
                e.h("load from cache");
                WebSoService.this.C(this.f314986c, this.f314985b);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface c {
        void onResult(String str);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(48279);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 16)) {
            redirector.redirect((short) 16);
        } else {
            f314937m = new Object();
        }
    }

    WebSoService() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        this.f314938d = "";
        this.f314939e = false;
        this.f314940f = new HashMap<>();
        this.f314941h = new a(10);
    }

    private Pair<String, String> A(String str, Handler handler, WebSoState webSoState, long j3) {
        String str2;
        Uri parse = Uri.parse(str);
        String str3 = "";
        if (parse != null) {
            String valueOf = String.valueOf(j3);
            SharedPreferences t16 = e.t();
            String x16 = e.x(parse);
            String string = t16.getString("eTag_" + valueOf + x16, "");
            str2 = t16.getString("pageVersion_" + valueOf + x16, "");
            String string2 = t16.getString("htmlSha1_" + valueOf + x16, "");
            File file = new File(e.l(parse));
            if (!TextUtils.isEmpty(string2) && file.exists()) {
                J(parse, string2, file, webSoState, new b(System.currentTimeMillis(), webSoState, handler));
                str3 = string;
                return new Pair<>(str3, str2);
            }
            if (QLog.isColorLevel()) {
                QLog.d("WebSoService", 2, "set eTag to get all data");
            }
        }
        str2 = "";
        return new Pair<>(str3, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C(Handler handler, WebSoState webSoState) {
        if (handler != null && webSoState != null) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("key_rsp_succeed", webSoState.f314965h);
            bundle.putString("url", webSoState.f314958a);
            bundle.putBoolean("need_force_refresh", webSoState.f314961d);
            bundle.putBoolean("need_local_refresh", webSoState.f314972o);
            bundle.putString("key_html_changed_data", webSoState.f314970m);
            bundle.putBoolean("key_wns_cache_hit", webSoState.f314964g);
            if (webSoState.f314964g && TextUtils.isEmpty(webSoState.f314959b)) {
                webSoState.f314959b = e.o(webSoState.f314958a);
                if (!TextUtils.isEmpty(webSoState.f314959b)) {
                    webSoState.f314969l = true;
                }
            }
            bundle.putBoolean("is_local_data", webSoState.f314969l);
            bundle.putString(QzoneCoverConst.WebViewConst.KEY_WNS_PROXY_HTTP_DATA, webSoState.f314959b);
            bundle.putInt("result_code", webSoState.f314966i);
            bundle.putString("error_message", webSoState.f314967j);
            bundle.putInt("req_state", webSoState.f314963f.get());
            bundle.putBoolean("is_silent_mode", webSoState.f314968k);
            bundle.putParcelable("key_webso_3", webSoState.f314976s);
            e.h("send webso3 " + webSoState.f314976s.toString());
            Message obtainMessage = handler.obtainMessage(203);
            obtainMessage.obj = bundle;
            handler.sendMessage(obtainMessage);
        }
    }

    private boolean D(boolean z16, Bundle bundle, WebSoState webSoState) {
        if (webSoState.f314974q == null) {
            HybridWebReporter.a aVar = new HybridWebReporter.a();
            webSoState.f314974q = aVar;
            aVar.f314902a = e.k();
            HybridWebReporter.a aVar2 = webSoState.f314974q;
            aVar2.f314903b = webSoState.f314958a;
            aVar2.f314913l = true;
        }
        if (!z16) {
            webSoState.f314974q.f314926y = 1;
        }
        webSoState.f314974q.f314907f = bundle.getString("key_user_ip");
        webSoState.f314974q.f314910i = bundle.getString("key_dns_result");
        webSoState.f314974q.f314908g = bundle.getString("key_server_ip");
        webSoState.f314974q.f314909h = bundle.getString("key_server_port");
        webSoState.f314974q.f314911j = bundle.getInt("key_time_cost");
        webSoState.f314974q.f314914m = bundle.getInt("rsp_code");
        HybridWebReporter.a aVar3 = webSoState.f314974q;
        aVar3.f314917p = 2;
        aVar3.f314912k = bundle.getString("key_detail_info");
        webSoState.f314968k = false;
        webSoState.f314976s.a();
        if (!z16) {
            webSoState.f314966i = 10001;
            if (!TextUtils.isEmpty(webSoState.f314959b)) {
                webSoState.f314964g = true;
            }
            w(webSoState);
            return true;
        }
        webSoState.f314974q.a();
        return false;
    }

    public static void H(String str, String str2, String str3, Uri uri) {
        ThreadManager.getFileThreadHandler().post(new Runnable(str, uri, str2, str3) { // from class: com.tencent.mobileqq.webview.webso.WebSoService.6
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f314954d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ Uri f314955e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ String f314956f;

            /* renamed from: h, reason: collision with root package name */
            final /* synthetic */ String f314957h;

            {
                this.f314954d = str;
                this.f314955e = uri;
                this.f314956f = str2;
                this.f314957h = str3;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, str, uri, str2, str3);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                String str4;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                System.currentTimeMillis();
                String str5 = this.f314954d;
                if (str5 != null) {
                    e.I(str5.getBytes(), e.l(this.f314955e));
                    str4 = com.tencent.mobileqq.webview.webso.b.b(this.f314954d);
                } else {
                    str4 = "";
                }
                if (!TextUtils.isEmpty(this.f314956f) && this.f314955e != null) {
                    SharedPreferences.Editor edit = e.t().edit();
                    String valueOf = String.valueOf(e.k());
                    String x16 = e.x(this.f314955e);
                    edit.putString("eTag_" + valueOf + x16, this.f314956f);
                    edit.putString("pageVersion_" + valueOf + x16, this.f314957h);
                    edit.putString("htmlSha1_" + valueOf + x16, str4);
                    edit.apply();
                }
            }
        });
    }

    private static void I(com.tencent.mobileqq.webview.webso.a aVar, String str, String str2, Uri uri, WebSoState webSoState) {
        ThreadManager.getFileThreadHandler().post(new Runnable(uri, str, str2, webSoState) { // from class: com.tencent.mobileqq.webview.webso.WebSoService.5
            static IPatchRedirector $redirector_;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ Uri f314950e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ String f314951f;

            /* renamed from: h, reason: collision with root package name */
            final /* synthetic */ String f314952h;

            /* renamed from: i, reason: collision with root package name */
            final /* synthetic */ WebSoState f314953i;

            {
                this.f314950e = uri;
                this.f314951f = str;
                this.f314952h = str2;
                this.f314953i = webSoState;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, com.tencent.mobileqq.webview.webso.a.this, uri, str, str2, webSoState);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                String str3;
                String str4;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                com.tencent.mobileqq.webview.webso.a aVar2 = com.tencent.mobileqq.webview.webso.a.this;
                if (aVar2 != null && (str4 = aVar2.f314997e) != null) {
                    try {
                        e.I(str4.getBytes(), e.l(this.f314950e));
                        str3 = com.tencent.mobileqq.webview.webso.b.b(com.tencent.mobileqq.webview.webso.a.this.f314997e);
                    } catch (OutOfMemoryError e16) {
                        QLog.e("WebSoService", 1, e16, new Object[0]);
                        return;
                    }
                } else {
                    str3 = "";
                }
                if (!TextUtils.isEmpty(this.f314951f) && this.f314950e != null) {
                    SharedPreferences.Editor edit = e.t().edit();
                    String valueOf = String.valueOf(e.k());
                    String x16 = e.x(this.f314950e);
                    edit.putString("eTag_" + valueOf + x16, this.f314951f);
                    edit.putString("pageVersion_" + valueOf + x16, this.f314952h);
                    edit.putString("htmlSha1_" + valueOf + x16, str3);
                    edit.apply();
                }
                this.f314953i.f314974q.f314918q = (int) (System.currentTimeMillis() - currentTimeMillis);
            }
        });
    }

    private void J(Uri uri, String str, File file, WebSoState webSoState, c cVar) {
        ThreadManager.getFileThreadHandler().post(new Runnable(file, str, cVar, uri) { // from class: com.tencent.mobileqq.webview.webso.WebSoService.3
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ File f314942d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ String f314943e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ c f314944f;

            /* renamed from: h, reason: collision with root package name */
            final /* synthetic */ Uri f314945h;

            {
                this.f314942d = file;
                this.f314943e = str;
                this.f314944f = cVar;
                this.f314945h = uri;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, WebSoService.this, file, str, cVar, uri);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                try {
                    long currentTimeMillis = System.currentTimeMillis();
                    String readFileToString = FileUtils.readFileToString(this.f314942d);
                    if (QLog.isColorLevel()) {
                        QLog.d("WebSoService", 2, "readFileToString cost=" + (System.currentTimeMillis() - currentTimeMillis));
                    }
                    if (!TextUtils.isEmpty(readFileToString)) {
                        long currentTimeMillis2 = System.currentTimeMillis();
                        if (com.tencent.mobileqq.webview.webso.b.b(readFileToString).equals(this.f314943e)) {
                            if (QLog.isColorLevel()) {
                                QLog.d("WebSoService", 2, "verify html success cost=" + (System.currentTimeMillis() - currentTimeMillis2));
                            }
                            this.f314944f.onResult(readFileToString);
                            return;
                        }
                        if (QLog.isColorLevel()) {
                            QLog.d("WebSoService", 2, "verify html fail cost=" + (System.currentTimeMillis() - currentTimeMillis2));
                        }
                        e.f(this.f314945h);
                        this.f314944f.onResult("");
                    }
                } catch (IOException e16) {
                    if (QLog.isColorLevel()) {
                        QLog.d("WebSoService", 2, "deal eTag exception=" + e16.getMessage());
                    }
                    e.f(this.f314945h);
                    this.f314944f.onResult("");
                    e16.printStackTrace();
                } catch (OutOfMemoryError e17) {
                    if (QLog.isColorLevel()) {
                        QLog.d("WebSoService", 2, "verify load data exception=" + e17.getMessage());
                    }
                    this.f314944f.onResult("");
                    e17.printStackTrace();
                }
            }
        });
    }

    private void c(WebSoState webSoState, String[] strArr, Uri uri, String str, String str2, boolean z16) {
        if (z16) {
            e.h("result = 304");
            WebSoState.WebSo3 webSo3 = webSoState.f314976s;
            webSo3.f314977d = true;
            webSo3.f314978e = str;
            webSo3.f314979f = str2;
            webSo3.f314980h = "\"" + strArr[0] + "\"";
            webSoState.f314976s.f314981i = uri.toString();
            webSoState.f314976s.f314982m = "webso-304";
            webSoState.f314964g = true;
            HybridWebReporter.a aVar = webSoState.f314974q;
            aVar.f314916o = true;
            aVar.f314920s = "304";
            w(webSoState);
            return;
        }
        QLog.i("WebSoService", 1, "now 304,so return! ");
        webSoState.f314964g = true;
        webSoState.f314974q.f314916o = true;
        w(webSoState);
    }

    private boolean d(WebSoState webSoState, String str, String[] strArr, Uri uri, String str2, String str3, String str4) {
        boolean equals = ark.ARKMETADATA_JSON.equals(str4);
        if (!equals) {
            f(uri.toString());
        }
        if (equals) {
            e.h("receive contentType = " + str4 + "  pageVersion = " + str3 + " etag = " + str2);
        }
        webSoState.f314974q.f314921t = str.length();
        return equals;
    }

    private static void f(String str) {
        FileUtils.delete(e.r(str), false);
    }

    private void g(Bundle bundle, WebSoState webSoState, com.tencent.mobileqq.webview.webso.a aVar, String str, String[] strArr, Uri uri) {
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        for (String str7 : strArr) {
            String lowerCase = str7.toLowerCase();
            if (lowerCase.contains(SonicSessionConnection.CUSTOM_HEAD_FILED_CACHE_OFFLINE)) {
                str2 = lowerCase.split(":")[1].trim();
            } else if (lowerCase.contains(Headers.ETAG)) {
                str3 = lowerCase.split(":")[1].trim();
            } else if (lowerCase.contains(SonicSessionConnection.CUSTOM_HEAD_FILED_TEMPLATE_TAG)) {
                str4 = lowerCase.split(":")[1].trim();
            } else if (lowerCase.contains("webso-page-version")) {
                str5 = u(webSoState, lowerCase);
            } else if (lowerCase.contains("webso-content-type")) {
                str6 = t(webSoState, lowerCase);
            }
        }
        x(bundle, webSoState, aVar, str, strArr, uri, str2, str3, str4, str5, str6);
    }

    @Nullable
    private com.tencent.mobileqq.webview.webso.a i(WebSoState webSoState, HttpRsp httpRsp, com.tencent.mobileqq.webview.webso.a aVar) {
        if (httpRsp != null) {
            aVar = new com.tencent.mobileqq.webview.webso.a(httpRsp);
        }
        if (httpRsp == null) {
            webSoState.f314966i = 10002;
            webSoState.f314967j = "rsp is null";
            w(webSoState);
            return null;
        }
        return aVar;
    }

    public static WebSoService j() {
        if (f314936i == null) {
            synchronized (f314937m) {
                if (f314936i == null) {
                    f314936i = new WebSoService();
                }
            }
        }
        return f314936i;
    }

    private void n(WebSoState webSoState, Uri uri) {
        webSoState.f314966i = TVKEventId.PLAYER_STATE_AD_LOADING_PLAY_END;
        webSoState.f314964g = false;
        webSoState.f314961d = true;
        e.B(uri);
        w(webSoState);
    }

    private void o(WebSoState webSoState, com.tencent.mobileqq.webview.webso.a aVar, Uri uri, String str, String str2) {
        e.h("result = json");
        WebSoState.WebSo3 webSo3 = webSoState.f314976s;
        webSo3.f314977d = true;
        webSo3.f314978e = str;
        webSo3.f314979f = str2;
        webSo3.f314980h = aVar.f314997e;
        webSo3.f314981i = uri.toString();
        webSoState.f314976s.f314982m = "webso-data-json";
        webSoState.f314964g = true;
        HybridWebReporter.a aVar2 = webSoState.f314974q;
        aVar2.f314916o = true;
        aVar2.f314920s = ark.ARKMETADATA_JSON;
        w(webSoState);
    }

    private void p(WebSoState webSoState, com.tencent.mobileqq.webview.webso.a aVar, String str, Uri uri, String str2, String str3, String str4) {
        String str5;
        webSoState.f314968k = true;
        webSoState.f314961d = false;
        webSoState.f314969l = false;
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject("data");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", 1);
            jSONObject.put("data", optJSONObject);
            jSONObject.put("type", str2);
            str5 = jSONObject.toString();
        } catch (JSONException e16) {
            e16.printStackTrace();
            str5 = "{\"code\":-1,\"data\":null}";
        }
        webSoState.f314959b = str5;
        w(webSoState);
        I(aVar, str3, str4, uri, webSoState);
        webSoState.f314968k = false;
    }

    private void q(WebSoState webSoState, com.tencent.mobileqq.webview.webso.a aVar, String str, Uri uri, String str2, String str3, String str4, String str5) {
        boolean[] zArr;
        if (v(webSoState.f314958a) && (zArr = webSoState.f314975r) != null && zArr.length > 0 && zArr[0]) {
            webSoState.f314968k = true;
            webSoState.f314961d = false;
            webSoState.f314969l = false;
            try {
                JSONObject optJSONObject = new JSONObject(str).optJSONObject("data");
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("code", 1);
                jSONObject.put("data", optJSONObject);
                jSONObject.put("type", str2);
                webSoState.f314959b = jSONObject.toString();
                w(webSoState);
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
        I(aVar, str3, str5, uri, webSoState);
        webSoState.f314968k = false;
        webSoState.f314959b = str;
        webSoState.f314961d = false;
        webSoState.f314969l = false;
        w(webSoState);
    }

    private void r(WebSoState webSoState, com.tencent.mobileqq.webview.webso.a aVar, String str, Uri uri, String str2, String str3) {
        I(aVar, str2, str3, uri, webSoState);
        webSoState.f314959b = str;
        webSoState.f314961d = true;
        webSoState.f314969l = false;
        w(webSoState);
    }

    private void s(WebSoState webSoState, String str, Uri uri, String str2, String str3) {
        webSoState.f314959b = str;
        webSoState.f314961d = true;
        webSoState.f314969l = false;
        HybridWebReporter.a aVar = webSoState.f314974q;
        aVar.f314918q = 0;
        aVar.f314917p = 0;
        w(webSoState);
        e.f(uri);
        H(str, str2, str3, uri);
    }

    @NotNull
    private String t(WebSoState webSoState, String str) {
        String trim = str.split(":")[1].trim();
        HybridWebReporter.a aVar = webSoState.f314974q;
        if (aVar.f314919r < 3) {
            aVar.f314919r = 3;
        }
        return trim;
    }

    @NotNull
    private String u(WebSoState webSoState, String str) {
        String trim = str.split(":")[1].trim();
        HybridWebReporter.a aVar = webSoState.f314974q;
        if (aVar.f314919r < 3) {
            aVar.f314919r = 3;
        }
        return trim;
    }

    private void x(Bundle bundle, WebSoState webSoState, com.tencent.mobileqq.webview.webso.a aVar, String str, String[] strArr, Uri uri, String str2, String str3, String str4, String str5, String str6) {
        boolean d16 = d(webSoState, str, strArr, uri, str3, str5, str6);
        if (strArr[0].contains("304")) {
            e.h("notifyState 304");
            c(webSoState, strArr, uri, str3, str5, d16);
            return;
        }
        if ("http".equals(str2)) {
            e.h("notifyState now 503, so start reLoadUrl");
            n(webSoState, uri);
            return;
        }
        if (TextUtils.isEmpty(str4)) {
            if ("true".equals(str2)) {
                e.h("notifyState true");
                r(webSoState, aVar, str, uri, str3, str5);
                return;
            }
            if (d16) {
                e.h("notifyState json");
                o(webSoState, aVar, uri, str3, str5);
                return;
            }
            if ("store".equals(str2)) {
                e.h("notifyState store");
                q(webSoState, aVar, str, uri, str2, str3, str4, str5);
                return;
            } else if (NotificationCompat.GROUP_KEY_SILENT.equals(str2)) {
                e.h("notifyState silent");
                p(webSoState, aVar, str, uri, str2, str3, str5);
                return;
            } else if (str2 == null || "false".equals(str2)) {
                e.h("notifyState update");
                s(webSoState, str, uri, str3, str5);
                return;
            }
        }
        e.h("notifyState other");
        e.f(uri);
        webSoState.f314959b = str;
        webSoState.f314961d = true;
        webSoState.f314969l = false;
        w(webSoState);
    }

    private void y(boolean z16, Bundle bundle) {
        String string = bundle.getString("url");
        if (TextUtils.isEmpty(string)) {
            return;
        }
        e.h("onGetHttpData succed(" + z16 + "), url:" + k.e(string, new String[0]));
        WebSoState webSoState = this.f314941h.get(e.y(string));
        webSoState.f314963f.set(2);
        webSoState.f314966i = 0;
        HttpRsp httpRsp = (HttpRsp) bundle.getSerializable("rsp_data");
        Bundle bundle2 = new Bundle();
        if (httpRsp != null && z16) {
            bundle2.putBoolean("key_rsp_succeed", true);
            bundle2.putString("url", bundle.getString("url"));
        } else {
            bundle2.putBoolean("key_rsp_succeed", false);
        }
        z(z16, bundle, webSoState);
    }

    public void B(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        } else if (this.f314940f.containsKey(str)) {
            this.f314940f.remove(str);
        }
    }

    public boolean E(String str, Handler handler) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, (Object) str, (Object) handler)).booleanValue();
        }
        return F(str, handler, false);
    }

    public boolean F(String str, Handler handler, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, this, str, handler, Boolean.valueOf(z16))).booleanValue();
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        e.h("startWebSoRequest url=" + str + " handler=" + handler);
        B(str);
        WebSoState webSoState = this.f314941h.get(e.y(str));
        webSoState.f314958a = str;
        webSoState.f314969l = false;
        webSoState.f314963f.set(1);
        webSoState.f314961d = false;
        webSoState.f314964g = false;
        HybridWebReporter.a aVar = new HybridWebReporter.a();
        webSoState.f314974q = aVar;
        aVar.f314902a = e.k();
        HybridWebReporter.a aVar2 = webSoState.f314974q;
        aVar2.f314903b = str;
        aVar2.f314913l = true;
        aVar2.f314927z = false;
        aVar2.a();
        webSoState.f314976s.a();
        if (e.C(str)) {
            webSoState.f314971n.set(1);
            webSoState.f314972o = false;
            webSoState.f314970m = "";
        } else {
            webSoState.f314971n.set(0);
        }
        if (e.G(str)) {
            return false;
        }
        long k3 = e.k();
        String websoGetQUA = VasUtil.getTempApi().websoGetQUA();
        String w3 = e.w();
        Pair<String, String> A = A(str, handler, webSoState, k3);
        String str2 = (String) A.first;
        String str3 = (String) A.second;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("if_None_Match", str2);
            if (!TextUtils.isEmpty(str3)) {
                jSONObject.put("web_page_version", str3);
            }
            jSONObject.put(LayoutAttrDefine.CLICK_URI, str);
            jSONObject.put("cookie", VasUtil.getTempApi().websoGetCookie4WebSoOrSonic(str) + "; qua=" + websoGetQUA + "; ");
            jSONObject.put("no_Chunked", "true");
            jSONObject.put("accept_Encoding", "identity");
            if (z16) {
                jSONObject.put("x_wns_ispreload_request", "1");
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        HttpRequestPackage httpRequestPackage = new HttpRequestPackage(w3, jSONObject);
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("webso", "3.0");
        } catch (Exception e17) {
            e17.printStackTrace();
        }
        httpRequestPackage.addHeader(jSONObject2.toString());
        e.h("send header = " + httpRequestPackage.getHeaderString());
        HttpReq httpReq = new HttpReq(EnumHttpMethod.convert("e" + httpRequestPackage.method).value(), httpRequestPackage.getHeaderString(), httpRequestPackage.getBodyString(), httpRequestPackage.host);
        if (handler != null) {
            webSoState.f314973p = new WeakReference<>(handler);
        }
        NewIntent newIntent = new NewIntent(peekAppRuntime.getApplicationContext(), WebSoServlet.class);
        WebSoServlet.b(newIntent, k3, str, httpReq, "");
        if (!this.f314939e) {
            peekAppRuntime.registObserver(this);
            this.f314939e = true;
        }
        peekAppRuntime.startServlet(newIntent);
        e.h("startServlet req");
        return true;
    }

    public void G(String str, Handler handler) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str, (Object) handler);
        } else if (!TextUtils.isEmpty(str) && e.D(Uri.parse(str))) {
            E(str, handler);
        }
    }

    public void b(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, (Object) str2);
        } else {
            this.f314940f.put(str, str2);
        }
    }

    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
        } else {
            this.f314941h.evictAll();
        }
    }

    public String h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.f314938d;
    }

    public String k(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
        }
        if (this.f314940f.containsKey(str)) {
            return this.f314940f.get(str);
        }
        return null;
    }

    public String l(String str, Handler handler) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this, (Object) str, (Object) handler);
        }
        return m(str, handler, null);
    }

    public String m(String str, Handler handler, boolean[] zArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, this, str, handler, zArr);
        }
        WebSoState webSoState = this.f314941h.get(e.y(str));
        if (!TextUtils.isEmpty(webSoState.f314958a)) {
            e.h("\u547d\u4e2d\u7f13\u5b58\uff0creqState:" + webSoState.f314963f);
            webSoState.f314975r = zArr;
            if (webSoState.f314963f.get() == 2) {
                C(handler, webSoState);
            } else if (webSoState.f314963f.get() == 1) {
                webSoState.f314973p = new WeakReference<>(handler);
                if (webSoState.f314962e) {
                    webSoState.f314969l = true;
                    C(handler, webSoState);
                } else {
                    ThreadManager.getFileThreadHandler().post(new Runnable(webSoState, str, handler) { // from class: com.tencent.mobileqq.webview.webso.WebSoService.4
                        static IPatchRedirector $redirector_;

                        /* renamed from: d, reason: collision with root package name */
                        final /* synthetic */ WebSoState f314946d;

                        /* renamed from: e, reason: collision with root package name */
                        final /* synthetic */ String f314947e;

                        /* renamed from: f, reason: collision with root package name */
                        final /* synthetic */ Handler f314948f;

                        {
                            this.f314946d = webSoState;
                            this.f314947e = str;
                            this.f314948f = handler;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, this, WebSoService.this, webSoState, str, handler);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                iPatchRedirector2.redirect((short) 2, (Object) this);
                                return;
                            }
                            try {
                                this.f314946d.f314959b = e.o(this.f314947e);
                                if (TextUtils.isEmpty(this.f314946d.f314959b)) {
                                    return;
                                }
                                WebSoState webSoState2 = this.f314946d;
                                webSoState2.f314969l = true;
                                webSoState2.f314962e = true;
                                WebSoService.this.C(this.f314948f, webSoState2);
                            } catch (OutOfMemoryError e16) {
                                QLog.e("WebSoService", 1, "exception", e16);
                            }
                        }
                    });
                    return null;
                }
            } else {
                E(str, handler);
            }
        } else {
            e.h("\u672a\u547d\u4e2d\u7f13\u5b58\uff0creqState:" + webSoState.f314963f);
            webSoState.f314975r = zArr;
            E(str, handler);
        }
        return webSoState.f314959b;
    }

    @Override // mqq.observer.BusinessObserver
    public void onReceive(int i3, boolean z16, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), Boolean.valueOf(z16), bundle);
        } else if (i3 == 100) {
            y(z16, bundle);
        }
    }

    public boolean v(String str) {
        Uri parse;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) str)).booleanValue();
        }
        if (TextUtils.isEmpty(str) || (parse = Uri.parse(str)) == null || !new File(e.l(parse)).exists()) {
            return false;
        }
        return true;
    }

    public void w(WebSoState webSoState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) webSoState);
            return;
        }
        if (webSoState == null) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.e("Webso", 2, "notifyMessage", new Throwable());
        }
        WeakReference<Handler> weakReference = webSoState.f314973p;
        if (weakReference != null && weakReference.get() != null) {
            e.h("notifyMessage");
            Handler handler = webSoState.f314973p.get();
            if (handler == null) {
                return;
            }
            C(handler, webSoState);
            webSoState.f314973p = null;
            HybridWebReporter.b().e(webSoState.f314974q);
        }
    }

    public void z(boolean z16, Bundle bundle, WebSoState webSoState) {
        HttpRsp httpRsp;
        com.tencent.mobileqq.webview.webso.a i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, Boolean.valueOf(z16), bundle, webSoState);
            return;
        }
        if (D(z16, bundle, webSoState) || (i3 = i(webSoState, (httpRsp = (HttpRsp) bundle.getSerializable("rsp_data")), null)) == null) {
            return;
        }
        String str = httpRsp.rspinfo;
        int indexOf = str.indexOf(HttpRsp.HTTP_HEADER_END);
        String str2 = i3.f314997e;
        this.f314938d = str2;
        if (indexOf < 1) {
            return;
        }
        String[] split = str.substring(0, indexOf - 1).split("\r\n");
        Uri parse = Uri.parse(bundle.getString("url"));
        String[] split2 = split[0].split(" ");
        if (split2.length >= 2) {
            try {
                webSoState.f314974q.f314906e = split2[1].trim();
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
        webSoState.f314964g = false;
        g(bundle, webSoState, i3, str2, split, parse);
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class WebSoState {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public String f314958a;

        /* renamed from: b, reason: collision with root package name */
        public volatile String f314959b;

        /* renamed from: c, reason: collision with root package name */
        public String f314960c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f314961d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f314962e;

        /* renamed from: f, reason: collision with root package name */
        public final AtomicInteger f314963f;

        /* renamed from: g, reason: collision with root package name */
        public boolean f314964g;

        /* renamed from: h, reason: collision with root package name */
        public boolean f314965h;

        /* renamed from: i, reason: collision with root package name */
        public int f314966i;

        /* renamed from: j, reason: collision with root package name */
        public String f314967j;

        /* renamed from: k, reason: collision with root package name */
        public boolean f314968k;

        /* renamed from: l, reason: collision with root package name */
        public boolean f314969l;

        /* renamed from: m, reason: collision with root package name */
        public String f314970m;

        /* renamed from: n, reason: collision with root package name */
        public final AtomicInteger f314971n;

        /* renamed from: o, reason: collision with root package name */
        public boolean f314972o;

        /* renamed from: p, reason: collision with root package name */
        public WeakReference<Handler> f314973p;

        /* renamed from: q, reason: collision with root package name */
        public HybridWebReporter.a f314974q;

        /* renamed from: r, reason: collision with root package name */
        public boolean[] f314975r;

        /* renamed from: s, reason: collision with root package name */
        public WebSo3 f314976s;

        public WebSoState() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.f314958a = null;
            this.f314959b = null;
            this.f314960c = null;
            this.f314962e = false;
            this.f314963f = new AtomicInteger(0);
            this.f314964g = false;
            this.f314966i = 0;
            this.f314967j = "";
            this.f314968k = true;
            this.f314969l = false;
            this.f314970m = null;
            this.f314971n = new AtomicInteger(0);
            this.f314976s = new WebSo3();
        }

        /* compiled from: P */
        /* loaded from: classes20.dex */
        public static class WebSo3 implements Parcelable {
            static IPatchRedirector $redirector_;
            public static final Parcelable.Creator<WebSo3> CREATOR;
            public String C;

            /* renamed from: d, reason: collision with root package name */
            public boolean f314977d;

            /* renamed from: e, reason: collision with root package name */
            public String f314978e;

            /* renamed from: f, reason: collision with root package name */
            public String f314979f;

            /* renamed from: h, reason: collision with root package name */
            public String f314980h;

            /* renamed from: i, reason: collision with root package name */
            public String f314981i;

            /* renamed from: m, reason: collision with root package name */
            public String f314982m;

            /* compiled from: P */
            /* loaded from: classes20.dex */
            class a implements Parcelable.Creator<WebSo3> {
                static IPatchRedirector $redirector_;

                a() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this);
                    }
                }

                @Override // android.os.Parcelable.Creator
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public WebSo3 createFromParcel(Parcel parcel) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        return (WebSo3) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
                    }
                    return new WebSo3(parcel);
                }

                @Override // android.os.Parcelable.Creator
                /* renamed from: b, reason: merged with bridge method [inline-methods] */
                public WebSo3[] newArray(int i3) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                        return (WebSo3[]) iPatchRedirector.redirect((short) 3, (Object) this, i3);
                    }
                    return new WebSo3[i3];
                }
            }

            static {
                IPatchRedirector redirector = PatchRedirectCenter.getRedirector(48276);
                $redirector_ = redirector;
                if (redirector != null && redirector.hasPatch((short) 8)) {
                    redirector.redirect((short) 8);
                } else {
                    CREATOR = new a();
                }
            }

            public WebSo3() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                    return;
                }
                this.f314977d = false;
                this.f314982m = "";
                this.C = "0";
            }

            public void a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                this.f314977d = false;
                this.f314978e = null;
                this.f314979f = null;
                this.f314980h = null;
                this.f314981i = null;
                this.C = "0";
                this.f314982m = "";
            }

            public String b() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    return (String) iPatchRedirector.redirect((short) 3, (Object) this);
                }
                return String.format("{\"code\":\"%s\",\"type\":\"%s\",\"data\":%s}", this.C, this.f314982m, this.f314980h);
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                    return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
                }
                return 0;
            }

            public String toString() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                    return (String) iPatchRedirector.redirect((short) 5, (Object) this);
                }
                return "WebSo3{valid=" + this.f314977d + ", eTag='" + this.f314978e + "', pageVersion='" + this.f314979f + "', jsonData='" + this.f314980h + "', uri='" + this.f314981i + "', callbackType='" + this.f314982m + "', code='" + this.C + "'}";
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel parcel, int i3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                    iPatchRedirector.redirect((short) 7, (Object) this, (Object) parcel, i3);
                    return;
                }
                parcel.writeByte(this.f314977d ? (byte) 1 : (byte) 0);
                parcel.writeString(this.f314978e);
                parcel.writeString(this.f314979f);
                parcel.writeString(this.f314980h);
                parcel.writeString(this.f314981i);
                parcel.writeString(this.f314982m);
                parcel.writeString(this.C);
            }

            protected WebSo3(Parcel parcel) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    iPatchRedirector.redirect((short) 4, (Object) this, (Object) parcel);
                    return;
                }
                this.f314977d = false;
                this.f314982m = "";
                this.C = "0";
                this.f314977d = parcel.readByte() != 0;
                this.f314978e = parcel.readString();
                this.f314979f = parcel.readString();
                this.f314980h = parcel.readString();
                this.f314981i = parcel.readString();
                this.f314982m = parcel.readString();
                this.C = parcel.readString();
            }
        }
    }
}
