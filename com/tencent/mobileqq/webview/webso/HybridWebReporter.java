package com.tencent.mobileqq.webview.webso;

import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.ams.mosaic.jsengine.component.text.TextComponent;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import common.config.service.QzoneConfig;
import cooperation.qzone.LocalMultiProcConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.zip.GZIPInputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes20.dex */
public class HybridWebReporter {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    public static String f314890b;

    /* renamed from: c, reason: collision with root package name */
    private static ArrayList<a> f314891c;

    /* renamed from: d, reason: collision with root package name */
    private static long f314892d;

    /* renamed from: e, reason: collision with root package name */
    private static HybridWebReporter f314893e;

    /* renamed from: f, reason: collision with root package name */
    private static final Object f314894f;

    /* renamed from: a, reason: collision with root package name */
    private Random f314895a;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class ReportRunnable implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        boolean f314896d;

        /* renamed from: e, reason: collision with root package name */
        boolean f314897e;

        /* renamed from: f, reason: collision with root package name */
        int f314898f;

        /* renamed from: h, reason: collision with root package name */
        int f314899h;

        /* renamed from: i, reason: collision with root package name */
        ArrayList<a> f314900i;

        /* renamed from: m, reason: collision with root package name */
        String f314901m;

        public ReportRunnable(ArrayList<a> arrayList) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) arrayList);
                return;
            }
            this.f314896d = false;
            this.f314897e = false;
            this.f314898f = 0;
            this.f314899h = 0;
            this.f314900i = arrayList;
        }

        private void a(String str) {
            String entityUtils;
            try {
                HttpResponse websoExecuteHttpPost = VasUtil.getTempApi().websoExecuteHttpPost(BaseApplication.getContext(), str, new StringEntity(this.f314901m, "UTF-8"));
                if (websoExecuteHttpPost.getStatusLine().getStatusCode() == 200) {
                    this.f314900i.clear();
                    this.f314897e = true;
                    QLog.d("HybridWebReporter", 4, "report success.");
                    try {
                        boolean z16 = false;
                        for (Header header : websoExecuteHttpPost.getHeaders("Content-Encoding")) {
                            if (header.getValue().equals("gzip")) {
                                z16 = true;
                            }
                        }
                        HttpEntity entity = websoExecuteHttpPost.getEntity();
                        if (z16) {
                            entityUtils = e.g(new GZIPInputStream(entity.getContent()));
                        } else {
                            entityUtils = EntityUtils.toString(entity);
                        }
                        if (QLog.isColorLevel()) {
                            QLog.d("HybridWebReporter", 2, "HybridWeb report response result = " + entityUtils);
                        }
                        if (TextUtils.isEmpty(entityUtils)) {
                            return;
                        }
                        JSONObject jSONObject = new JSONObject(entityUtils);
                        if (jSONObject.opt("urlPrefixConfig") instanceof JSONArray) {
                            String jSONObject2 = jSONObject.toString();
                            HybridWebReporter.f314890b = jSONObject2;
                            LocalMultiProcConfig.putString("urlPrefixConfig", jSONObject2);
                            return;
                        }
                        return;
                    } catch (Throwable th5) {
                        QLog.w("HybridWebReporter", 1, "save url prefix report err.", th5);
                        return;
                    }
                }
                QLog.e("HybridWebReporter", 1, "HttpStatus error when report : " + websoExecuteHttpPost.getStatusLine().getStatusCode());
                this.f314898f = this.f314898f + 1;
            } catch (Throwable th6) {
                this.f314898f++;
                QLog.w("HybridWebReporter", 1, "exception when report", th6);
            }
        }

        private void e() {
            if (this.f314896d) {
                return;
            }
            if (this.f314900i.isEmpty()) {
                QLog.e("HybridWebReporter", 1, "listToSend is empty.");
                return;
            }
            ArrayList<a> arrayList = this.f314900i;
            JSONObject jSONObject = new JSONObject();
            try {
                JSONArray jSONArray = new JSONArray();
                Iterator<a> it = arrayList.iterator();
                while (it.hasNext()) {
                    jSONArray.mo162put(it.next().b());
                }
                jSONObject.put("data", jSONArray);
            } catch (Exception e16) {
                QLog.w("HybridWebReporter", 1, e16.toString());
                jSONObject = null;
            }
            if (jSONObject != null) {
                this.f314901m = jSONObject.toString();
            }
            if (QLog.isColorLevel()) {
                QLog.i("HybridWebReporter", 2, "json : " + this.f314901m);
            }
            this.f314896d = true;
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            String str = QzoneConfig.getInstance().getConfig("QzUrlCache", QzoneConfig.SECONDARY_WEBSO_REPORT_URL, QzoneConfig.SECONDARY_WEBSO_REPORT_URL_DEFAULT) + "?uin=" + e.k();
            e();
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.f314901m)) {
                if (QLog.isColorLevel()) {
                    QLog.i("HybridWebReporter", 2, "start report thread.");
                }
                while (!this.f314897e && this.f314899h <= 1) {
                    if (this.f314898f > 1) {
                        new Handler(ThreadManagerV2.getSubThreadLooper()).postDelayed(this, MiniBoxNoticeInfo.MIN_5);
                        this.f314899h++;
                        this.f314898f = 0;
                        return;
                    }
                    a(str);
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class a {
        static IPatchRedirector $redirector_;
        private AtomicInteger A;

        /* renamed from: a, reason: collision with root package name */
        public long f314902a;

        /* renamed from: b, reason: collision with root package name */
        public String f314903b;

        /* renamed from: c, reason: collision with root package name */
        public String f314904c;

        /* renamed from: d, reason: collision with root package name */
        public String f314905d;

        /* renamed from: e, reason: collision with root package name */
        public String f314906e;

        /* renamed from: f, reason: collision with root package name */
        public String f314907f;

        /* renamed from: g, reason: collision with root package name */
        public String f314908g;

        /* renamed from: h, reason: collision with root package name */
        public String f314909h;

        /* renamed from: i, reason: collision with root package name */
        public String f314910i;

        /* renamed from: j, reason: collision with root package name */
        public int f314911j;

        /* renamed from: k, reason: collision with root package name */
        public String f314912k;

        /* renamed from: l, reason: collision with root package name */
        public boolean f314913l;

        /* renamed from: m, reason: collision with root package name */
        public int f314914m;

        /* renamed from: n, reason: collision with root package name */
        public boolean f314915n;

        /* renamed from: o, reason: collision with root package name */
        public boolean f314916o;

        /* renamed from: p, reason: collision with root package name */
        public int f314917p;

        /* renamed from: q, reason: collision with root package name */
        public int f314918q;

        /* renamed from: r, reason: collision with root package name */
        public int f314919r;

        /* renamed from: s, reason: collision with root package name */
        public String f314920s;

        /* renamed from: t, reason: collision with root package name */
        public long f314921t;

        /* renamed from: u, reason: collision with root package name */
        public String f314922u;

        /* renamed from: v, reason: collision with root package name */
        public String f314923v;

        /* renamed from: w, reason: collision with root package name */
        public String f314924w;

        /* renamed from: x, reason: collision with root package name */
        public String f314925x;

        /* renamed from: y, reason: collision with root package name */
        public int f314926y;

        /* renamed from: z, reason: collision with root package name */
        public boolean f314927z;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.f314904c = "";
            this.f314905d = "";
            this.f314906e = "";
            this.f314907f = "";
            this.f314908g = "";
            this.f314909h = "";
            this.f314910i = "";
            this.f314912k = "";
            this.f314915n = false;
            this.f314919r = 0;
            this.f314920s = TextComponent.SpanType.HTML;
            this.f314921t = 0L;
            this.f314922u = VasUtil.getTempApi().websoGetAPN();
            this.f314923v = "QQ";
            this.f314924w = VasUtil.getTempApi().websoGetQUA();
            this.f314925x = "Android";
            this.f314926y = -1;
            this.f314927z = false;
            this.A = new AtomicInteger(0);
        }

        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            this.f314919r = 0;
            this.f314920s = TextComponent.SpanType.HTML;
            this.f314921t = 0L;
        }

        public JSONObject b() {
            int i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (JSONObject) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("uin", this.f314902a);
                String str = this.f314903b;
                if (!TextUtils.isEmpty(str)) {
                    int indexOf = this.f314903b.indexOf(63);
                    if (indexOf < 0) {
                        indexOf = this.f314903b.length();
                    }
                    str = this.f314903b.substring(0, indexOf);
                }
                jSONObject.put("url", this.f314903b);
                jSONObject.put("path", str);
                jSONObject.put("errordomain", this.f314904c);
                jSONObject.put("errorcode", this.f314905d);
                jSONObject.put("httpstatus", this.f314906e);
                jSONObject.put("userip", this.f314907f);
                jSONObject.put("serverip", this.f314908g);
                jSONObject.put("port", this.f314909h);
                jSONObject.put("dnsresult", this.f314910i);
                jSONObject.put("apn", this.f314922u);
                jSONObject.put("timecost", this.f314911j / 1000.0f);
                jSONObject.put("app", this.f314923v);
                jSONObject.put("appversion", this.f314924w);
                jSONObject.put("platform", this.f314925x);
                jSONObject.put("sampling", this.f314926y);
                jSONObject.put("usewns", this.f314913l);
                int i16 = this.f314914m;
                if (i16 != 1000 && i16 != 0) {
                    i3 = i16 + 300000;
                    jSONObject.put("wnscode", i3);
                    jSONObject.put("detail", this.f314912k);
                    jSONObject.put("usecache", this.f314915n);
                    jSONObject.put("cachehasdata", this.f314916o);
                    jSONObject.put("cacheupdatepolicy", this.f314917p);
                    jSONObject.put("cacheupdatetimecost", this.f314918q / 1000.0f);
                    jSONObject.put("serviceversion", this.f314919r);
                    jSONObject.put("webso3_type", this.f314920s);
                    jSONObject.put("datasize", this.f314921t);
                    return jSONObject;
                }
                i3 = 0;
                jSONObject.put("wnscode", i3);
                jSONObject.put("detail", this.f314912k);
                jSONObject.put("usecache", this.f314915n);
                jSONObject.put("cachehasdata", this.f314916o);
                jSONObject.put("cacheupdatepolicy", this.f314917p);
                jSONObject.put("cacheupdatetimecost", this.f314918q / 1000.0f);
                jSONObject.put("serviceversion", this.f314919r);
                jSONObject.put("webso3_type", this.f314920s);
                jSONObject.put("datasize", this.f314921t);
                return jSONObject;
            } catch (Exception e16) {
                QLog.e("HybridWebReporter", 1, e16, new Object[0]);
                return null;
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(48252);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        f314891c = new ArrayList<>();
        f314892d = SystemClock.uptimeMillis();
        f314893e = null;
        f314894f = new Object();
    }

    HybridWebReporter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f314895a = null;
        }
    }

    private boolean a(a aVar) {
        int i3;
        int i16;
        try {
            i3 = Integer.valueOf(aVar.f314906e).intValue();
        } catch (Exception unused) {
            i3 = 200;
        }
        if (!QLog.isColorLevel() && (((i16 = aVar.f314914m) == 1000 || i16 == 0) && i3 >= 100 && i3 <= 400)) {
            return false;
        }
        return true;
    }

    public static HybridWebReporter b() {
        if (f314893e == null) {
            synchronized (f314894f) {
                if (f314893e == null) {
                    f314893e = new HybridWebReporter();
                }
            }
        }
        return f314893e;
    }

    private boolean c(int i3) {
        if (i3 <= 0) {
            return false;
        }
        if (this.f314895a == null) {
            this.f314895a = new Random(System.currentTimeMillis());
        }
        if (this.f314895a.nextInt() % i3 != 0) {
            return false;
        }
        return true;
    }

    private boolean d(a aVar) {
        if (aVar != null && aVar.f314926y != 0 && !aVar.f314927z) {
            return false;
        }
        return true;
    }

    public static void f() {
        ArrayList arrayList;
        if (f314891c.isEmpty()) {
            return;
        }
        synchronized (f314891c) {
            arrayList = new ArrayList(f314891c);
            f314891c.clear();
            f314892d = SystemClock.uptimeMillis();
        }
        ThreadManagerV2.executeOnNetWorkThread(new ReportRunnable(arrayList));
    }

    public void e(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
            return;
        }
        if (d(aVar)) {
            return;
        }
        long uptimeMillis = SystemClock.uptimeMillis() - f314892d;
        int config = QzoneConfig.getInstance().getConfig("QzUrlCache", QzoneConfig.SECONDARY_WEBSO_REPORT_BATCH_INTERVAL, 600) * 1000;
        int config2 = QzoneConfig.getInstance().getConfig("QzUrlCache", QzoneConfig.SECONDARY_WEBSO_REPORT_BATCH_COUNT, 10);
        aVar.f314927z = true;
        if (aVar.f314926y < 0) {
            aVar.f314926y = QzoneConfig.getInstance().getConfig("QzUrlCache", QzoneConfig.SECONDARY_WEBSO_REPORT_DEFAULT_SAMPLING, 20);
        }
        if (a(aVar)) {
            aVar.f314926y = 1;
        }
        if (c(aVar.f314926y)) {
            synchronized (f314891c) {
                f314891c.add(aVar);
            }
            if (f314891c.size() >= config2 || (uptimeMillis >= config && f314891c.size() > 0)) {
                f();
            }
        }
    }
}
