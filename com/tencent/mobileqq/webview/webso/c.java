package com.tencent.mobileqq.webview.webso;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.ditto.shell.LayoutAttrDefine;
import com.tencent.mobileqq.haoliyou.JefsClass;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.mobileqq.webview.webso.HybridWebReporter;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;
import org.json.JSONException;
import org.json.JSONObject;
import wns_proxy.EnumHttpMethod;
import wns_proxy.HttpReq;
import wns_proxy.HttpRsp;

/* compiled from: P */
/* loaded from: classes20.dex */
public class c implements BusinessObserver {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name */
    private static volatile c f314999f;

    /* renamed from: h, reason: collision with root package name */
    private static final Object f315000h;

    /* renamed from: d, reason: collision with root package name */
    private boolean f315001d;

    /* renamed from: e, reason: collision with root package name */
    private ConcurrentHashMap<String, b> f315002e;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public String f315003a;

        /* renamed from: b, reason: collision with root package name */
        public String f315004b;

        /* renamed from: c, reason: collision with root package name */
        public String f315005c;

        /* renamed from: d, reason: collision with root package name */
        public String f315006d;

        /* renamed from: e, reason: collision with root package name */
        public String f315007e;

        /* renamed from: f, reason: collision with root package name */
        public String f315008f;

        /* renamed from: g, reason: collision with root package name */
        public boolean f315009g;

        /* renamed from: h, reason: collision with root package name */
        public int f315010h;

        /* renamed from: i, reason: collision with root package name */
        public Object f315011i;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return "url=" + this.f315003a + " ,method=" + this.f315004b + " ,jsonHeader=" + this.f315005c + " ,body=" + this.f315006d + " ," + this.f315007e + " ,rspBase64=" + this.f315009g + " ,timeout=" + this.f315010h + " ,userInfo=" + this.f315011i;
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public String f315012a;

        /* renamed from: b, reason: collision with root package name */
        public String f315013b;

        /* renamed from: c, reason: collision with root package name */
        public String f315014c;

        /* renamed from: d, reason: collision with root package name */
        public volatile String f315015d;

        /* renamed from: e, reason: collision with root package name */
        public int f315016e;

        /* renamed from: f, reason: collision with root package name */
        public int f315017f;

        /* renamed from: g, reason: collision with root package name */
        public boolean f315018g;

        /* renamed from: h, reason: collision with root package name */
        public String f315019h;

        /* renamed from: i, reason: collision with root package name */
        public int f315020i;

        /* renamed from: j, reason: collision with root package name */
        public String f315021j;

        /* renamed from: k, reason: collision with root package name */
        public Object f315022k;

        /* renamed from: l, reason: collision with root package name */
        public Handler f315023l;

        /* renamed from: m, reason: collision with root package name */
        public HybridWebReporter.a f315024m;

        /* renamed from: n, reason: collision with root package name */
        public long f315025n;

        public b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.f315012a = null;
            this.f315013b = null;
            this.f315014c = null;
            this.f315015d = null;
            this.f315016e = 0;
            this.f315017f = -1;
            this.f315018g = false;
            this.f315020i = 0;
            this.f315021j = "";
            this.f315025n = 0L;
            this.f315025n = System.currentTimeMillis();
        }

        public String toString() {
            int length;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append("unikey=");
            sb5.append(this.f315012a);
            sb5.append(JefsClass.INDEX_URL);
            sb5.append(this.f315013b);
            sb5.append(" ,header=");
            sb5.append(this.f315014c);
            sb5.append(",htmlbody len=");
            if (TextUtils.isEmpty(this.f315015d)) {
                length = 0;
            } else {
                length = this.f315015d.length();
            }
            sb5.append(length);
            sb5.append(",reqState=");
            sb5.append(this.f315016e);
            sb5.append(",httpStatusCode=");
            sb5.append(this.f315017f);
            sb5.append(",needBase64Rsp=");
            sb5.append(this.f315018g);
            sb5.append(",jsCallback=");
            sb5.append(this.f315019h);
            sb5.append(",resultCode=");
            sb5.append(this.f315020i);
            sb5.append(",errorMsg=");
            sb5.append(this.f315021j);
            return sb5.toString();
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(48258);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            f315000h = new Object();
        }
    }

    c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f315001d = false;
            this.f315002e = new ConcurrentHashMap<>();
        }
    }

    private boolean a(b bVar, com.tencent.mobileqq.webview.webso.a aVar, String str) {
        int indexOf = str.indexOf(HttpRsp.HTTP_HEADER_END);
        String str2 = aVar.f314997e;
        if (indexOf < 1) {
            return false;
        }
        String[] split = str.substring(0, indexOf - 1).split("\r\n");
        int length = split.length;
        if (length >= 1) {
            String[] split2 = split[0].split(" ");
            if (split2.length >= 2) {
                try {
                    bVar.f315017f = Integer.valueOf(split2[1].trim()).intValue();
                    bVar.f315024m.f314906e = split2[1].trim();
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
            }
            JSONObject jSONObject = new JSONObject();
            for (int i3 = 1; i3 < length; i3++) {
                String[] split3 = split[i3].split(":");
                if (split3.length > 1) {
                    try {
                        jSONObject.put(split3[0].trim(), split3[1].trim());
                    } catch (JSONException e17) {
                        e17.printStackTrace();
                    }
                }
            }
            bVar.f315014c = jSONObject.toString();
        }
        bVar.f315020i = 0;
        bVar.f315015d = str2;
        return true;
    }

    private b b(String str) {
        b bVar = new b();
        bVar.f315012a = str;
        bVar.f315016e = 4;
        bVar.f315020i = 10006;
        return bVar;
    }

    public static c c() {
        if (f314999f == null) {
            synchronized (f315000h) {
                if (f314999f == null) {
                    f314999f = new c();
                }
            }
        }
        return f314999f;
    }

    private void d(b bVar) {
        Handler handler;
        if (bVar == null || (handler = bVar.f315023l) == null || handler == null) {
            return;
        }
        g(handler, bVar);
        HybridWebReporter.b().e(bVar.f315024m);
    }

    private void e(boolean z16, Bundle bundle) {
        String string = bundle.getString("key_uni_key");
        String string2 = bundle.getString("url");
        if (!TextUtils.isEmpty(string2) && !TextUtils.isEmpty(string)) {
            b bVar = this.f315002e.get(string);
            if (bVar == null) {
                QLog.e("WebSoCgiService", 1, "get webso state fail, unikey=" + string + ",map size=" + this.f315002e.size());
                f(z16, bundle, b(string));
                return;
            }
            bVar.f315016e = 2;
            bVar.f315020i = 0;
            f(z16, bundle, bVar);
            this.f315002e.remove(string);
            QLog.i("WebSoCgiService", 1, "onGetHttpData success(" + z16 + "), url:" + string2 + " ,map size=" + this.f315002e.size());
        }
    }

    private void f(boolean z16, Bundle bundle, b bVar) {
        if (bVar.f315024m == null) {
            HybridWebReporter.a aVar = new HybridWebReporter.a();
            bVar.f315024m = aVar;
            aVar.f314902a = e.k();
            HybridWebReporter.a aVar2 = bVar.f315024m;
            aVar2.f314903b = bVar.f315013b;
            aVar2.f314913l = true;
        }
        bVar.f315024m.f314907f = bundle.getString("key_user_ip");
        bVar.f315024m.f314910i = bundle.getString("key_dns_result");
        bVar.f315024m.f314908g = bundle.getString("key_server_ip");
        bVar.f315024m.f314909h = bundle.getString("key_server_port");
        bVar.f315024m.f314911j = bundle.getInt("key_time_cost");
        bVar.f315024m.f314914m = bundle.getInt("rsp_code");
        HybridWebReporter.a aVar3 = bVar.f315024m;
        aVar3.f314917p = 0;
        aVar3.f314912k = bundle.getString("key_detail_info");
        if (!z16) {
            bVar.f315024m.f314926y = 1;
            bVar.f315020i = bundle.getInt("rsp_code", 10002);
            bVar.f315021j = bundle.getString("rsp_message");
            d(bVar);
            QLog.w("WebSoCgiService", 1, "state=" + bVar);
            return;
        }
        HttpRsp httpRsp = (HttpRsp) bundle.getSerializable("rsp_data");
        if (httpRsp == null) {
            bVar.f315020i = 10002;
            bVar.f315021j = "rsp is null";
            d(bVar);
            QLog.w("WebSoCgiService", 1, "state=" + bVar);
            return;
        }
        if (!a(bVar, new com.tencent.mobileqq.webview.webso.a(httpRsp), httpRsp.rspinfo)) {
            return;
        }
        QLog.i("WebSoCgiService", 1, "wnscgi@ before send rsp msg,total cost " + (System.currentTimeMillis() - bVar.f315025n) + " ms");
        d(bVar);
    }

    private void g(Handler handler, b bVar) {
        Message obtainMessage = handler.obtainMessage(204);
        obtainMessage.obj = bVar;
        handler.sendMessage(obtainMessage);
    }

    public boolean h(a aVar, Handler handler) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) aVar, (Object) handler)).booleanValue();
        }
        return i(aVar, handler, VasUtil.getTempApi().websoGetCookie4WebSoOrSonic(aVar.f315003a));
    }

    public boolean i(a aVar, Handler handler, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, this, aVar, handler, str)).booleanValue();
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (aVar != null && !TextUtils.isEmpty(aVar.f315003a)) {
            if (!NetworkUtil.isNetworkAvailable(peekAppRuntime.getApplicationContext())) {
                QLog.w("WebSoCgiService", 2, "startCgiRequest isNetworkAvailable false ,cgiInfo=" + aVar);
                return false;
            }
            String str2 = String.valueOf(Math.random()) + String.valueOf(System.currentTimeMillis());
            QLog.i("WebSoCgiService", 2, "wnscgi@ startCgiRequest running cgiInfo=" + aVar + ",uniKey=" + str2);
            b bVar = new b();
            bVar.f315012a = str2;
            bVar.f315013b = aVar.f315003a;
            bVar.f315018g = aVar.f315009g;
            bVar.f315016e = 1;
            bVar.f315019h = aVar.f315008f;
            bVar.f315022k = aVar.f315011i;
            HybridWebReporter.a aVar2 = new HybridWebReporter.a();
            bVar.f315024m = aVar2;
            aVar2.f314902a = e.k();
            HybridWebReporter.a aVar3 = bVar.f315024m;
            aVar3.f314903b = aVar.f315003a;
            aVar3.f314913l = true;
            this.f315002e.put(str2, bVar);
            long k3 = e.k();
            String websoGetQUA = VasUtil.getTempApi().websoGetQUA();
            String w3 = e.w();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("method", aVar.f315004b.toUpperCase());
                jSONObject.put("entity_body", aVar.f315006d);
                jSONObject.put("if_None_Match", "");
                jSONObject.put("content_type", aVar.f315007e);
                jSONObject.put(LayoutAttrDefine.CLICK_URI, aVar.f315003a);
                if (aVar.f315004b.equalsIgnoreCase("GET")) {
                    if (!TextUtils.isEmpty(aVar.f315006d)) {
                        if (aVar.f315003a.contains(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER)) {
                            jSONObject.put(LayoutAttrDefine.CLICK_URI, aVar.f315003a + ContainerUtils.FIELD_DELIMITER + aVar.f315006d);
                        } else {
                            jSONObject.put(LayoutAttrDefine.CLICK_URI, aVar.f315003a + QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER + aVar.f315006d);
                        }
                    }
                } else if (!TextUtils.isEmpty(aVar.f315006d)) {
                    jSONObject.put("content_length", aVar.f315006d.length());
                }
                jSONObject.put("cookie", str + "; qua=" + websoGetQUA + "; ");
                jSONObject.put("no_Chunked", "true");
                jSONObject.put("accept_Encoding", "identity");
            } catch (Exception e16) {
                e16.printStackTrace();
            }
            HttpRequestPackage httpRequestPackage = new HttpRequestPackage(w3, jSONObject);
            httpRequestPackage.addHeader(aVar.f315005c);
            HttpReq httpReq = new HttpReq(EnumHttpMethod.convert("e" + httpRequestPackage.method).value(), httpRequestPackage.getHeaderString(), httpRequestPackage.getBodyString(), httpRequestPackage.host);
            bVar.f315023l = handler;
            NewIntent newIntent = new NewIntent(peekAppRuntime.getApplicationContext(), WebSoServlet.class);
            WebSoServlet.a(newIntent, k3, aVar.f315003a, httpReq, "", aVar.f315010h, 1101, str2, c.class);
            if (!this.f315001d) {
                peekAppRuntime.registObserver(this);
                this.f315001d = true;
            }
            peekAppRuntime.startServlet(newIntent);
            QLog.i("WebSoCgiService", 1, "wnscgi@ after start servlet,total cost " + (System.currentTimeMillis() - bVar.f315025n) + " ms");
            return true;
        }
        QLog.w("WebSoCgiService", 2, "startCgiRequest param invalid, cgiInfo=" + aVar);
        return false;
    }

    @Override // mqq.observer.BusinessObserver
    public void onReceive(int i3, boolean z16, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16), bundle);
        } else if (i3 == 1101) {
            e(z16, bundle);
        }
    }
}
