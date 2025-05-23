package com.qzone.video.TVK_SDK.mediaplayer.vodcgi;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import ap.h;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.huawei.hms.framework.common.ContainerUtils;
import com.qzone.adapter.feedcomponent.i;
import com.qzone.proxy.feedcomponent.model.TencentVideoModule;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheLunarData;
import com.qzone.util.l;
import com.qzone.video.TVK_SDK.mediaplayer.config.TencentVideo;
import com.qzone.video.TVK_SDK.mediaplayer.utils.HttpUtils;
import com.qzone.video.TVK_SDK.mediaplayer.vodcgi.a;
import com.tencent.ads.data.AdParam;
import com.tencent.ams.dynamicwidget.report.LinkReportConstant$EventKey;
import com.tencent.ams.dynamicwidget.report.LinkReportConstant$GlobalKey;
import com.tencent.ark.ark;
import com.tencent.component.network.NetworkManager;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.vip.TMSManager;
import com.tencent.oskplayer.util.PlayerUtils;
import com.tencent.qqlive.tvkplayer.tools.config.TVKMediaPlayerConfig;
import com.tencent.qqlive.tvkplayer.vinfo.live.TVKLiveRequestBuilder;
import com.tencent.qqmini.sdk.plugins.SensorJsPlugin;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import com.tencent.tmassistantbase.util.GlobalUtil;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import cooperation.qzone.util.NetworkState;
import cooperation.qzone.webviewplugin.QzoneWebViewOfflinePlugin;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.http.Header;
import org.apache.http.message.BasicHeader;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes37.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private int f59966a;

    /* renamed from: b, reason: collision with root package name */
    private zo.d f59967b;

    /* renamed from: c, reason: collision with root package name */
    private com.qzone.video.TVK_SDK.mediaplayer.vodcgi.b f59968c;

    /* renamed from: e, reason: collision with root package name */
    private a f59970e;

    /* renamed from: d, reason: collision with root package name */
    private boolean f59969d = false;

    /* renamed from: f, reason: collision with root package name */
    private List<String> f59971f = null;

    /* compiled from: P */
    /* loaded from: classes37.dex */
    private class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            com.qzone.video.TVK_SDK.mediaplayer.utils.b.c("VodInfoProcess.java", 0, 40, "MediaPlayerMgr", "msg.what: " + message.what + "msg.arg1:" + message.arg1 + "msg.arg2:" + message.arg2, new Object[0]);
            int i3 = message.what;
            if (i3 == 0) {
                e.this.f59968c.b(message.arg1, message.arg2, (com.qzone.video.TVK_SDK.mediaplayer.vodcgi.a) message.obj);
            } else if (i3 == 1) {
                e.this.f59968c.c(message.arg1, (com.qzone.video.TVK_SDK.mediaplayer.vodcgi.a) message.obj);
            } else if (i3 != 2) {
                e.this.f59968c.b(message.arg1, message.arg2, null);
            } else {
                e eVar = e.this;
                new c(message.arg1, this, eVar.f59967b, (com.qzone.video.TVK_SDK.mediaplayer.vodcgi.a) message.obj, e.this.f59968c).h();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private int f59973a;

        /* renamed from: b, reason: collision with root package name */
        private String f59974b;

        /* renamed from: c, reason: collision with root package name */
        private int f59975c;

        /* renamed from: d, reason: collision with root package name */
        private int f59976d;

        /* renamed from: e, reason: collision with root package name */
        private String f59977e;

        /* renamed from: f, reason: collision with root package name */
        private int f59978f;

        /* renamed from: g, reason: collision with root package name */
        private ArrayList<String> f59979g;

        /* renamed from: h, reason: collision with root package name */
        private int f59980h;

        /* renamed from: i, reason: collision with root package name */
        private String f59981i;

        b() {
        }

        public int a() {
            return this.f59980h;
        }

        public String b() {
            return this.f59981i;
        }

        public ArrayList<String> c() {
            return this.f59979g;
        }

        public void d(int i3) {
            this.f59978f = i3;
        }

        public void e(int i3) {
            this.f59973a = i3;
        }

        public void f(int i3) {
            this.f59980h = i3;
        }

        public void g(String str) {
            this.f59981i = str;
        }

        public void h(String str) {
            this.f59974b = str;
        }

        public void i(int i3) {
            this.f59975c = i3;
        }

        public void j(int i3) {
            this.f59976d = i3;
        }

        public void k(String str) {
            this.f59977e = str;
        }

        public void l(ArrayList<String> arrayList) {
            this.f59979g = arrayList;
        }
    }

    /* compiled from: P */
    /* loaded from: classes37.dex */
    private class c {

        /* renamed from: a, reason: collision with root package name */
        private com.qzone.video.TVK_SDK.mediaplayer.vodcgi.a f59982a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f59983b;

        /* renamed from: c, reason: collision with root package name */
        private int f59984c;

        /* renamed from: d, reason: collision with root package name */
        private Handler f59985d;

        /* renamed from: e, reason: collision with root package name */
        private int f59986e;

        /* renamed from: f, reason: collision with root package name */
        private com.qzone.video.TVK_SDK.mediaplayer.vodcgi.b f59987f;

        /* renamed from: g, reason: collision with root package name */
        private ap.b f59988g = new a("UTF-8");

        /* compiled from: P */
        /* loaded from: classes37.dex */
        class a extends h {
            a(String str) {
                super(str);
            }

            @Override // ap.h
            public void B(int i3, Header[] headerArr, String str, Throwable th5) {
                String str2;
                com.qzone.video.TVK_SDK.mediaplayer.utils.b.c("VodInfoProcess.java", 0, 40, "MediaPlayerMgr", "MediaKey callback canceled: " + c.this.f59987f.a(), new Object[0]);
                if (c.this.f59987f.a()) {
                    return;
                }
                String str3 = "";
                if (th5 == null) {
                    str2 = "";
                } else {
                    str2 = th5.toString();
                }
                com.qzone.video.TVK_SDK.mediaplayer.utils.b.c("VodInfoProcess.java", 679, 20, "MediaPlayerMgr", "[getvkey]return = statusCode" + i3 + "; responseString " + str + "; throwable" + str2, new Object[0]);
                if (c.this.f59986e <= 2) {
                    c.this.f59983b = !r9.f59983b;
                    com.qzone.video.TVK_SDK.mediaplayer.utils.b.c("VodInfoProcess.java", 0, 20, "MediaPlayerMgr", " change host, retry", new Object[0]);
                    c.this.f59986e++;
                    c.this.h();
                    return;
                }
                int a16 = com.qzone.video.TVK_SDK.mediaplayer.utils.a.a(th5);
                if (th5 != null) {
                    str3 = th5.toString();
                }
                com.qzone.video.TVK_SDK.mediaplayer.vodcgi.a aVar = new com.qzone.video.TVK_SDK.mediaplayer.vodcgi.a();
                aVar.H(a16);
                aVar.M(str3);
                Message message = new Message();
                message.obj = aVar;
                message.what = 0;
                message.arg1 = c.this.f59984c;
                message.arg2 = 108;
                c.this.f59985d.sendMessage(message);
            }

            @Override // ap.h
            public void C(int i3, String str, Header[] headerArr, String str2) {
                com.qzone.video.TVK_SDK.mediaplayer.utils.b.c("VodInfoProcess.java", 0, 40, "MediaPlayerMgr", "MediaKey callback canceled: " + c.this.f59987f.a(), new Object[0]);
                if (c.this.f59987f.a()) {
                    return;
                }
                try {
                    com.qzone.video.TVK_SDK.mediaplayer.utils.b.c("VodInfoProcess.java", 679, 40, "MediaPlayerMgr", "[getvkey]return = " + str2, new Object[0]);
                    c.this.f59986e = 0;
                    com.qzone.video.TVK_SDK.mediaplayer.vodcgi.a l3 = c.this.l(str2);
                    if (l3 != null) {
                        Message message = new Message();
                        message.arg1 = c.this.f59984c;
                        message.obj = l3;
                        if (l3.h() == 0) {
                            message.what = 1;
                        } else {
                            message.what = 0;
                            message.arg2 = 101;
                        }
                        c.this.f59985d.sendMessage(message);
                    }
                } catch (JSONException e16) {
                    Message message2 = new Message();
                    com.qzone.video.TVK_SDK.mediaplayer.vodcgi.a aVar = new com.qzone.video.TVK_SDK.mediaplayer.vodcgi.a();
                    aVar.H(com.qzone.video.TVK_SDK.mediaplayer.utils.a.a(e16));
                    message2.what = 0;
                    message2.arg1 = c.this.f59984c;
                    message2.arg2 = 106;
                    message2.obj = aVar;
                    c.this.f59985d.sendMessage(message2);
                } catch (Exception e17) {
                    Message message3 = new Message();
                    com.qzone.video.TVK_SDK.mediaplayer.vodcgi.a aVar2 = new com.qzone.video.TVK_SDK.mediaplayer.vodcgi.a();
                    aVar2.H(com.qzone.video.TVK_SDK.mediaplayer.utils.a.a(e17));
                    message3.what = 0;
                    message3.arg1 = c.this.f59984c;
                    message3.arg2 = 107;
                    message3.obj = aVar2;
                    c.this.f59985d.sendMessage(message3);
                }
            }
        }

        protected c(int i3, Handler handler, zo.d dVar, com.qzone.video.TVK_SDK.mediaplayer.vodcgi.a aVar, com.qzone.video.TVK_SDK.mediaplayer.vodcgi.b bVar) {
            this.f59983b = false;
            this.f59984c = 0;
            this.f59986e = 0;
            this.f59984c = i3;
            e.this.f59967b = dVar;
            this.f59983b = false;
            this.f59982a = aVar;
            this.f59985d = handler;
            this.f59986e = 0;
            this.f59987f = bVar;
        }

        private Header[] i() {
            if (e.this.f59967b != null && !TextUtils.isEmpty(e.this.f59967b.l())) {
                com.qzone.video.TVK_SDK.mediaplayer.utils.b.c("VodInfoProcess.java", 0, 40, "MediaPlayerMgr", "cookie = " + e.this.f59967b.l(), new Object[0]);
                return new Header[]{new BasicHeader("Cookie", e.this.f59967b.l()), new BasicHeader("User-Agent", "qqlive")};
            }
            com.qzone.video.TVK_SDK.mediaplayer.utils.b.c("VodInfoProcess.java", 0, 40, "MediaPlayerMgr", "cookie is empty", new Object[0]);
            return new Header[]{new BasicHeader("User-Agent", "qqlive")};
        }

        protected void h() {
            String k3 = k();
            ap.d j3 = j();
            com.qzone.video.TVK_SDK.mediaplayer.utils.b.c("VodInfoProcess.java", 522, 40, "MediaPlayerMgr", "[getvkey] getRequestUrl = " + k3, new Object[0]);
            com.qzone.video.TVK_SDK.mediaplayer.utils.b.c("VodInfoProcess.java", 522, 40, "MediaPlayerMgr", "[getvkey] getQueryParams = " + j3.toString(), new Object[0]);
            HttpUtils.g(TencentVideo.a(), k3, i(), j3, null, this.f59988g);
        }

        protected ap.d j() {
            ap.d dVar = new ap.d(e.this.f59967b.i());
            dVar.g("vid", this.f59982a.C());
            dVar.g("filename", this.f59982a.l());
            com.qzone.video.TVK_SDK.mediaplayer.vodcgi.a aVar = this.f59982a;
            dVar.g("format", String.valueOf(aVar.d(aVar.y())));
            dVar.g(TPReportKeys.PlayerStep.PLAYER_CDN_TYPE, String.valueOf(this.f59982a.o()));
            dVar.g(AdParam.OTYPE, ark.ARKMETADATA_JSON);
            dVar.g("platform", e.this.f59967b.m());
            dVar.g("uin", e.this.f59967b.o());
            dVar.g(TVKLiveRequestBuilder.RequestParamKey.RANDOM_NUMBER, String.valueOf(Math.random()));
            dVar.g("guid", TencentVideo.b());
            if (!TextUtils.isEmpty(e.this.f59967b.p())) {
                String str = "";
                String str2 = "";
                int i3 = 0;
                String str3 = str2;
                while (i3 < this.f59982a.B().size()) {
                    a.c cVar = this.f59982a.B().get(i3);
                    String str4 = str + "|" + cVar.b();
                    str2 = str2 + "|" + String.valueOf(cVar.c());
                    str3 = str3 + "|" + cVar.d();
                    i3++;
                    str = str4;
                }
                dVar.g("path", str);
                dVar.g("spip", str3);
                dVar.g("spport", str2);
                dVar.g("unicom", e.this.f59967b.p());
            }
            dVar.g(AdParam.APPVER, e.this.f59967b.a());
            dVar.g(AdParam.ENCRYPTVER, "6.5");
            if (!TextUtils.isEmpty(e.this.f59967b.b())) {
                dVar.g("cKey", e.this.f59967b.b());
            }
            return dVar;
        }

        protected String k() {
            if (this.f59983b) {
                return com.qzone.video.TVK_SDK.mediaplayer.config.a.f59858d;
            }
            return com.qzone.video.TVK_SDK.mediaplayer.config.a.f59857c;
        }

        protected com.qzone.video.TVK_SDK.mediaplayer.vodcgi.a l(String str) throws JSONException {
            b k3 = e.k(HttpUtils.b(str));
            if (k3.a() != 0) {
                this.f59982a.H(k3.a());
                this.f59982a.M(k3.b());
                return this.f59982a;
            }
            this.f59982a.X(k3.c().get(0).toString());
            return this.f59982a;
        }
    }

    public e(int i3, zo.d dVar, com.qzone.video.TVK_SDK.mediaplayer.vodcgi.b bVar) {
        this.f59967b = null;
        this.f59970e = null;
        Looper mainLooper = Looper.getMainLooper();
        if (mainLooper != null) {
            this.f59970e = new a(mainLooper);
        } else {
            Looper myLooper = Looper.myLooper();
            if (myLooper != null) {
                Looper.prepare();
                this.f59970e = new a(myLooper);
                Looper.loop();
            } else {
                com.qzone.video.TVK_SDK.mediaplayer.utils.b.c("VodInfoProcess.java", 0, 10, "MediaPlayerMgr", "VodInfoProcess, mEventHandler is NULL", new Object[0]);
                this.f59970e = null;
            }
        }
        this.f59966a = i3;
        this.f59967b = dVar;
        this.f59968c = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static b k(String str) throws JSONException {
        b bVar = new b();
        JSONObject jSONObject = new JSONObject(str);
        if ("o".equals(jSONObject.getString(ReportConstant.COSTREPORT_PREFIX))) {
            bVar.e(jSONObject.getInt(LinkReportConstant$GlobalKey.CONNECT_TYPE));
            bVar.h(jSONObject.getString("key"));
            bVar.i(jSONObject.getInt("level"));
            bVar.j(jSONObject.getInt("levelvalid"));
            if (jSONObject.has(WidgetCacheLunarData.SHA)) {
                bVar.k(jSONObject.getString(WidgetCacheLunarData.SHA));
            }
            if (jSONObject.has("ch")) {
                bVar.d(jSONObject.getInt("ch"));
            }
            JSONArray jSONArray = jSONObject.getJSONObject("ul").getJSONArray(SensorJsPlugin.SENSOR_INTERVAL_UI);
            int length = jSONArray.length();
            ArrayList<String> arrayList = new ArrayList<>();
            for (int i3 = 0; i3 < length; i3++) {
                if (jSONArray.getJSONObject(i3).has("url")) {
                    arrayList.add(jSONArray.getJSONObject(i3).getString("url"));
                }
            }
            bVar.l(arrayList);
        } else {
            bVar.f(jSONObject.getInt("em"));
            bVar.g(jSONObject.optString("msg"));
        }
        return bVar;
    }

    public void i() {
        if (!j(this.f59967b, this.f59968c)) {
            com.qzone.video.TVK_SDK.mediaplayer.vodcgi.a aVar = new com.qzone.video.TVK_SDK.mediaplayer.vodcgi.a();
            aVar.H(-10007);
            aVar.M("vid is empty or callback is null");
            Message message = new Message();
            message.what = 0;
            message.arg1 = this.f59966a;
            message.arg2 = 105;
            message.obj = aVar;
            this.f59970e.sendMessage(message);
            return;
        }
        d dVar = new d(this.f59966a, this.f59970e, this.f59967b, this.f59968c);
        if (TencentVideoModule.v() == 1) {
            dVar.o();
        } else {
            dVar.p(0);
        }
    }

    /* compiled from: P */
    /* loaded from: classes37.dex */
    private class d {

        /* renamed from: a, reason: collision with root package name */
        private boolean f59991a;

        /* renamed from: c, reason: collision with root package name */
        private int f59993c;

        /* renamed from: e, reason: collision with root package name */
        private zo.d f59995e;

        /* renamed from: f, reason: collision with root package name */
        private Handler f59996f;

        /* renamed from: g, reason: collision with root package name */
        private int f59997g;

        /* renamed from: h, reason: collision with root package name */
        private com.qzone.video.TVK_SDK.mediaplayer.vodcgi.b f59998h;

        /* renamed from: i, reason: collision with root package name */
        private HashMap<String, String> f59999i;

        /* renamed from: b, reason: collision with root package name */
        private int f59992b = 2;

        /* renamed from: d, reason: collision with root package name */
        private String f59994d = "6.5";

        /* renamed from: j, reason: collision with root package name */
        private ap.b f60000j = new a("UTF-8");

        /* compiled from: P */
        /* loaded from: classes37.dex */
        class a extends h {
            a(String str) {
                super(str);
            }

            @Override // ap.h
            public void B(int i3, Header[] headerArr, String str, Throwable th5) {
                String str2;
                PlayerUtils.log(4, "VodInfoProcess.java@MediaPlayerMgr", "videoinfo callback canceled: " + d.this.f59998h.a());
                if (d.this.f59998h.a()) {
                    return;
                }
                String str3 = "";
                if (th5 == null) {
                    str2 = "";
                } else {
                    str2 = th5.toString();
                }
                PlayerUtils.log(4, "VodInfoProcess.java@MediaPlayerMgr", "[getvInfo]return = statusCode" + i3 + "; responseString " + str + "; throwable" + str2);
                if (d.this.f59993c <= d.this.f59992b) {
                    PlayerUtils.log(4, "VodInfoProcess.java@MediaPlayerMgr", " change host, retry " + d.this.f59993c);
                    d dVar = d.this;
                    dVar.f59993c = dVar.f59993c + 1;
                    if (TencentVideoModule.v() == 1) {
                        d.this.o();
                        return;
                    } else {
                        d dVar2 = d.this;
                        dVar2.p(dVar2.f59993c);
                        return;
                    }
                }
                PlayerUtils.log(4, "VodInfoProcess.java@MediaPlayerMgr", "http retry failed");
                int a16 = com.qzone.video.TVK_SDK.mediaplayer.utils.a.a(th5);
                if (th5 != null) {
                    str3 = th5.toString();
                }
                com.qzone.video.TVK_SDK.mediaplayer.vodcgi.a aVar = new com.qzone.video.TVK_SDK.mediaplayer.vodcgi.a();
                aVar.H(a16);
                aVar.M(str3);
                Message message = new Message();
                message.obj = aVar;
                message.what = 0;
                message.arg1 = d.this.f59997g;
                message.arg2 = 108;
                d.this.f59996f.sendMessage(message);
            }

            @Override // ap.h
            public void C(int i3, String str, Header[] headerArr, String str2) {
                PlayerUtils.log(4, "VodInfoProcess.java@MediaPlayerMgr", "videoinfo callback canceled: " + d.this.f59998h.a());
                PlayerUtils.log(4, "VodInfoProcess.java@MediaPlayerMgr", "[getvInfo] tvk_log return = " + str2);
                if (d.this.f59998h.a()) {
                    return;
                }
                d.this.f59993c = 0;
                try {
                    com.qzone.video.TVK_SDK.mediaplayer.vodcgi.a x16 = d.this.x(str2);
                    if (x16 != null) {
                        if (TextUtils.isEmpty(x16.C()) && !TextUtils.isEmpty(str)) {
                            x16.e0(str);
                        }
                        Message message = new Message();
                        message.arg1 = d.this.f59997g;
                        message.obj = x16;
                        if (x16.h() == 0) {
                            d.this.z(x16);
                            if (!TextUtils.isEmpty(d.this.f59995e.p())) {
                                message.what = 2;
                            } else {
                                message.what = 1;
                            }
                        } else {
                            message.what = 0;
                            message.arg2 = 101;
                        }
                        PlayerUtils.log(4, "VodInfoProcess.java@MediaPlayerMgr", "request safe vid = " + x16.C() + ", get safe url success");
                        d.this.f59996f.sendMessage(message);
                    }
                } catch (JSONException e16) {
                    Message message2 = new Message();
                    com.qzone.video.TVK_SDK.mediaplayer.vodcgi.a aVar = new com.qzone.video.TVK_SDK.mediaplayer.vodcgi.a();
                    aVar.H(com.qzone.video.TVK_SDK.mediaplayer.utils.a.a(e16));
                    message2.what = 0;
                    message2.arg1 = d.this.f59997g;
                    message2.arg2 = 106;
                    message2.obj = aVar;
                    d.this.f59996f.sendMessage(message2);
                } catch (Exception e17) {
                    Message message3 = new Message();
                    com.qzone.video.TVK_SDK.mediaplayer.vodcgi.a aVar2 = new com.qzone.video.TVK_SDK.mediaplayer.vodcgi.a();
                    aVar2.H(com.qzone.video.TVK_SDK.mediaplayer.utils.a.a(e17));
                    message3.what = 0;
                    message3.arg1 = d.this.f59997g;
                    message3.arg2 = 107;
                    message3.obj = aVar2;
                    d.this.f59996f.sendMessage(message3);
                }
            }
        }

        public d(int i3, Handler handler, zo.d dVar, com.qzone.video.TVK_SDK.mediaplayer.vodcgi.b bVar) {
            this.f59991a = false;
            this.f59993c = 0;
            this.f59995e = null;
            this.f59996f = null;
            this.f59997g = 0;
            this.f59997g = i3;
            this.f59995e = dVar;
            this.f59991a = false;
            this.f59993c = 0;
            this.f59996f = handler;
            this.f59998h = bVar;
            v();
        }

        private String[] j(com.qzone.video.TVK_SDK.mediaplayer.vodcgi.a aVar) {
            Uri.Builder buildUpon;
            int size = aVar.B().size();
            String[] strArr = new String[size - 1];
            for (int i3 = 1; i3 < size; i3++) {
                if (aVar.E()) {
                    String e16 = aVar.B().get(i3).e();
                    if (aVar.B().get(i3).a() != null) {
                        e16 = e16 + aVar.B().get(i3).a().b();
                    }
                    buildUpon = Uri.parse(e16).buildUpon();
                    String a16 = aVar.B().get(i3).a().a();
                    if (!TextUtils.isEmpty(a16) && !GlobalUtil.DEF_STRING.equals(a16)) {
                        buildUpon.appendQueryParameter("hlskey", aVar.B().get(i3).a().a());
                    } else {
                        buildUpon.appendQueryParameter("hlskey", "");
                    }
                } else {
                    buildUpon = Uri.parse(aVar.B().get(i3).e() + aVar.l()).buildUpon();
                    buildUpon.appendQueryParameter("platform", this.f59995e.m());
                    buildUpon.appendQueryParameter(TtmlNode.TAG_BR, aVar.f());
                    buildUpon.appendQueryParameter(TPReportKeys.Common.COMMON_MEDIA_FORMAT, aVar.y());
                    buildUpon.appendQueryParameter("vkey", aVar.D());
                    buildUpon.appendQueryParameter("level", aVar.s());
                    if (!TextUtils.isEmpty(aVar.z())) {
                        buildUpon.appendQueryParameter(WidgetCacheLunarData.SHA, aVar.z());
                    }
                }
                buildUpon.appendQueryParameter("sdtfrom", this.f59995e.n());
                strArr[i3 - 1] = buildUpon.toString();
            }
            return strArr;
        }

        private String k(com.qzone.video.TVK_SDK.mediaplayer.vodcgi.a aVar) {
            Uri.Builder buildUpon;
            if (aVar.E()) {
                buildUpon = Uri.parse(aVar.n()).buildUpon();
                String a16 = aVar.B().get(0).a().a();
                if (!TextUtils.isEmpty(a16) && !GlobalUtil.DEF_STRING.equals(a16)) {
                    buildUpon.appendQueryParameter("hlskey", aVar.B().get(0).a().a());
                } else {
                    buildUpon.appendQueryParameter("hlskey", "");
                }
            } else {
                buildUpon = Uri.parse(aVar.p() + aVar.l()).buildUpon();
                buildUpon.appendQueryParameter("platform", this.f59995e.m());
                buildUpon.appendQueryParameter(TtmlNode.TAG_BR, aVar.f());
                buildUpon.appendQueryParameter(TPReportKeys.Common.COMMON_MEDIA_FORMAT, aVar.y());
                buildUpon.appendQueryParameter("vkey", aVar.D());
                buildUpon.appendQueryParameter("level", aVar.s());
                if (!TextUtils.isEmpty(aVar.z())) {
                    buildUpon.appendQueryParameter(WidgetCacheLunarData.SHA, aVar.z());
                }
            }
            buildUpon.appendQueryParameter("sdtfrom", this.f59995e.n());
            return buildUpon.toString();
        }

        private String[] l(com.qzone.video.TVK_SDK.mediaplayer.vodcgi.a aVar) {
            int size = aVar.B().size();
            String[] strArr = new String[size - 1];
            for (int i3 = 1; i3 < size; i3++) {
                Uri.Builder buildUpon = Uri.parse(aVar.B().get(i3).e() + aVar.x().get(0).a()).buildUpon();
                buildUpon.appendQueryParameter("platform", this.f59995e.m());
                buildUpon.appendQueryParameter(TtmlNode.TAG_BR, aVar.f());
                buildUpon.appendQueryParameter(TPReportKeys.Common.COMMON_MEDIA_FORMAT, aVar.y());
                buildUpon.appendQueryParameter("vkey", aVar.D());
                buildUpon.appendQueryParameter("level", aVar.s());
                if (!TextUtils.isEmpty(aVar.z())) {
                    buildUpon.appendQueryParameter(WidgetCacheLunarData.SHA, aVar.z());
                }
                buildUpon.appendQueryParameter("sdtfrom", this.f59995e.n());
                strArr[i3 - 1] = buildUpon.toString();
            }
            return strArr;
        }

        private String m(com.qzone.video.TVK_SDK.mediaplayer.vodcgi.a aVar) {
            Uri.Builder buildUpon = Uri.parse(aVar.p() + aVar.x().get(0).a()).buildUpon();
            buildUpon.appendQueryParameter("platform", this.f59995e.m());
            buildUpon.appendQueryParameter(TtmlNode.TAG_BR, aVar.f());
            buildUpon.appendQueryParameter(TPReportKeys.Common.COMMON_MEDIA_FORMAT, aVar.y());
            buildUpon.appendQueryParameter("vkey", aVar.D());
            buildUpon.appendQueryParameter("level", aVar.s());
            if (!TextUtils.isEmpty(aVar.z())) {
                buildUpon.appendQueryParameter(WidgetCacheLunarData.SHA, aVar.z());
            }
            buildUpon.appendQueryParameter("sdtfrom", this.f59995e.n());
            return buildUpon.toString();
        }

        private Header[] r() {
            zo.d dVar = this.f59995e;
            if (dVar != null && !TextUtils.isEmpty(dVar.l())) {
                com.qzone.video.TVK_SDK.mediaplayer.utils.b.c("VodInfoProcess.java", 0, 40, "MediaPlayerMgr", "cookie = " + this.f59995e.l(), new Object[0]);
                return new Header[]{new BasicHeader("Cookie", this.f59995e.l()), new BasicHeader("User-Agent", "qqlive")};
            }
            com.qzone.video.TVK_SDK.mediaplayer.utils.b.c("VodInfoProcess.java", 0, 40, "MediaPlayerMgr", "cookie is empty", new Object[0]);
            return new Header[]{new BasicHeader("User-Agent", "qqlive")};
        }

        private void v() {
            HashMap<String, String> hashMap = new HashMap<>();
            this.f59999i = hashMap;
            hashMap.put("fhd", l.a(R.string.vim));
            this.f59999i.put("hd", l.a(R.string.vih));
            this.f59999i.put("msd", l.a(R.string.vii));
            this.f59999i.put("sd", l.a(R.string.vij));
            this.f59999i.put("mp4", l.a(R.string.vik));
            this.f59999i.put("shd", l.a(R.string.vil));
        }

        private com.qzone.video.TVK_SDK.mediaplayer.vodcgi.a w(String str) throws JSONException {
            com.qzone.video.TVK_SDK.mediaplayer.vodcgi.a aVar = new com.qzone.video.TVK_SDK.mediaplayer.vodcgi.a();
            aVar.h0(str);
            JSONObject jSONObject = new JSONObject(str);
            if ("o".equals(jSONObject.getString(ReportConstant.COSTREPORT_PREFIX))) {
                aVar.H(0);
                JSONArray jSONArray = jSONObject.getJSONObject("fl").getJSONArray("fi");
                for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                    a.b bVar = new a.b();
                    bVar.h(jSONArray.getJSONObject(i3).getInt("id"));
                    bVar.j(jSONArray.getJSONObject(i3).optInt("sl"));
                    String optString = jSONArray.getJSONObject(i3).optString("name");
                    bVar.i(optString);
                    String optString2 = jSONArray.getJSONObject(i3).optString("cname");
                    if (!TextUtils.isEmpty(optString2)) {
                        bVar.g(com.qzone.video.TVK_SDK.mediaplayer.utils.d.a(optString2));
                    } else {
                        bVar.g(this.f59999i.get(optString));
                    }
                    aVar.a(bVar);
                }
                aVar.K(jSONObject.getInt(TPReportKeys.Common.COMMON_DL_TYPE));
                if (jSONObject.has("preview")) {
                    aVar.Y(jSONObject.optInt("preview"));
                }
                if ("1".equals(jSONObject.getString("exem"))) {
                    aVar.U(true);
                }
                JSONArray jSONArray2 = jSONObject.getJSONObject(LinkReportConstant$EventKey.VALUE).getJSONArray("vi");
                int length = jSONArray2.length();
                aVar.I(length);
                if (length > 0) {
                    JSONObject jSONObject2 = jSONArray2.getJSONObject(0);
                    aVar.e0(jSONObject2.getString("vid"));
                    aVar.G(jSONObject2.getString(TtmlNode.TAG_BR));
                    aVar.c0(jSONObject2.getString("ti"));
                    aVar.L(jSONObject2.getDouble("td"));
                    aVar.g0(jSONObject2.getInt("vw"));
                    aVar.R(jSONObject2.getInt("vh"));
                    aVar.Q(jSONObject2.getLong("fs"));
                    aVar.W(jSONObject2.getInt("ch"));
                    int i16 = jSONObject2.getInt("st");
                    aVar.b0(i16);
                    if (8 == i16) {
                        aVar.U(true);
                    }
                    aVar.d0(jSONObject2.getInt("type"));
                    if (jSONObject2.has("token")) {
                        aVar.J(jSONObject2.getString("token"));
                    }
                    if (jSONObject2.has("fvkey")) {
                        aVar.k0(jSONObject2.getString("fvkey"));
                    }
                    if (jSONObject2.has("fsha")) {
                        aVar.Z(jSONObject2.getString("fsha"));
                    }
                    if (jSONObject2.has("level")) {
                        aVar.T(jSONObject2.getString("level"));
                    }
                    if (jSONObject2.has("sp")) {
                        aVar.a0(jSONObject2.getString("sp"));
                    }
                    if (jSONObject2.has("videotype")) {
                        aVar.f0(jSONObject2.getInt("videotype"));
                    }
                    if (jSONObject2.has("dm")) {
                        aVar.i0(Integer.parseInt(jSONObject2.getString("dm")));
                    }
                    if (jSONObject2.has("targetid")) {
                        aVar.j0(jSONObject2.getString("targetid"));
                    }
                    if (jSONObject2.has("hevc")) {
                        aVar.S(jSONObject2.getInt("hevc"));
                    }
                    String string = jSONObject2.getString("fn");
                    aVar.P(string);
                    if (jSONObject2.has("cl") && jSONObject2.getJSONObject("cl").getInt("fc") > 0) {
                        JSONArray jSONArray3 = jSONObject2.getJSONObject("cl").getJSONArray("ci");
                        int length2 = jSONArray3.length();
                        for (int i17 = 0; i17 < length2; i17++) {
                            a.d dVar = new a.d();
                            dVar.b(jSONArray3.getJSONObject(i17).getDouble("cd"));
                            dVar.c(string.replace(".mp4", "") + "." + jSONArray3.getJSONObject(i17).getString("idx") + ".mp4");
                            aVar.c(dVar);
                        }
                    }
                    if (jSONObject2.has("ll")) {
                        JSONArray jSONArray4 = jSONObject2.getJSONObject("ll").getJSONArray("li");
                        a.e eVar = new a.e();
                        eVar.a(jSONArray4.getJSONObject(0).getInt(tl.h.F));
                        eVar.e(jSONArray4.getJSONObject(0).getInt("w"));
                        eVar.b(jSONArray4.getJSONObject(0).getInt(HippyTKDListViewAdapter.X));
                        eVar.c(jSONArray4.getJSONObject(0).getInt("y"));
                        if (jSONArray4.getJSONObject(0).getInt("show") == 0) {
                            eVar.d(false);
                        } else {
                            eVar.d(true);
                        }
                        aVar.V(eVar);
                    }
                    JSONArray jSONArray5 = jSONObject2.getJSONObject("ul").getJSONArray(SensorJsPlugin.SENSOR_INTERVAL_UI);
                    int length3 = jSONArray5.length();
                    for (int i18 = 0; i18 < length3; i18++) {
                        a.c cVar = new a.c();
                        if (jSONArray5.getJSONObject(i18).has("url")) {
                            cVar.m(jSONArray5.getJSONObject(i18).getString("url"));
                        }
                        if (jSONArray5.getJSONObject(i18).has("dt")) {
                            cVar.g(jSONArray5.getJSONObject(i18).getInt("dt"));
                        }
                        if (jSONArray5.getJSONObject(i18).has(TPReportKeys.PlayerStep.PLAYER_CDN_TYPE)) {
                            cVar.n(jSONArray5.getJSONObject(i18).getInt(TPReportKeys.PlayerStep.PLAYER_CDN_TYPE));
                        }
                        if (jSONArray5.getJSONObject(i18).has(TVKMediaPlayerConfig.PlayerConfig.FORMAT_ID_HLS)) {
                            cVar.i(y(jSONArray5.getJSONObject(i18).getJSONObject(TVKMediaPlayerConfig.PlayerConfig.FORMAT_ID_HLS)));
                        }
                        if (jSONArray5.getJSONObject(i18).has("path")) {
                            cVar.j(jSONArray5.getJSONObject(i18).getString("path"));
                        }
                        if (jSONArray5.getJSONObject(i18).has("spip")) {
                            cVar.l(jSONArray5.getJSONObject(i18).getString("spip"));
                        }
                        if (jSONArray5.getJSONObject(i18).has("spport")) {
                            cVar.k(jSONArray5.getJSONObject(i18).getInt("spport"));
                        }
                        if (jSONArray5.getJSONObject(i18).has("dtc")) {
                            cVar.h(jSONArray5.getJSONObject(i18).getInt("dtc"));
                        }
                        aVar.b(cVar);
                    }
                }
            } else {
                aVar.H(jSONObject.getInt("em"));
                if (jSONObject.has("msg")) {
                    aVar.M(jSONObject.getString("msg"));
                }
                if (jSONObject.has("exinfo")) {
                    aVar.N(jSONObject.getString("exinfo"));
                }
                if (jSONObject.has("exmsg")) {
                    aVar.O(jSONObject.getString("exmsg"));
                }
            }
            return aVar;
        }

        private a.C0501a y(JSONObject jSONObject) throws JSONException {
            a.C0501a c0501a = new a.C0501a();
            if (jSONObject.has("pt")) {
                c0501a.d(jSONObject.getString("pt"));
            }
            if (jSONObject.has("st")) {
                c0501a.e(jSONObject.getInt("st"));
            }
            if (jSONObject.has("hk")) {
                c0501a.c(jSONObject.getString("hk"));
            }
            if (jSONObject.has("stype")) {
                c0501a.f(jSONObject.getString("stype"));
            }
            return c0501a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean z(com.qzone.video.TVK_SDK.mediaplayer.vodcgi.a aVar) {
            if (aVar.h() != 0 || (!aVar.E() && aVar.x() != null && (aVar.x() == null || aVar.x().size() != 0))) {
                e.this.f59969d = true;
            } else {
                e.this.f59969d = false;
            }
            if (!e.this.f59969d) {
                String k3 = k(aVar);
                String[] j3 = j(aVar);
                if (!aVar.E()) {
                    if (com.qzone.video.TVK_SDK.mediaplayer.config.b.f59864b != null && TextUtils.isEmpty(this.f59995e.p())) {
                        k3 = i(k3);
                    }
                    for (int i3 = 0; i3 < j3.length; i3++) {
                        if (com.qzone.video.TVK_SDK.mediaplayer.config.b.f59864b != null && TextUtils.isEmpty(this.f59995e.p())) {
                            j3[i3] = j3[i3] + com.qzone.video.TVK_SDK.mediaplayer.config.b.f59864b;
                        }
                    }
                }
                aVar.X(k3);
                aVar.F(j3);
                return true;
            }
            if (aVar.h() == 0 && aVar.x() != null && aVar.x().size() > 0) {
                String m3 = m(aVar);
                String[] l3 = l(aVar);
                if (com.qzone.video.TVK_SDK.mediaplayer.config.b.f59864b != null && TextUtils.isEmpty(this.f59995e.p())) {
                    m3 = i(m3);
                }
                aVar.X(m3);
                aVar.F(l3);
            }
            return true;
        }

        public int n(int i3) {
            if (i3 == TMSManager.f312758d) {
                return 1;
            }
            if (i3 == TMSManager.f312756b) {
                return 2;
            }
            return i3 == TMSManager.f312758d ? 3 : 0;
        }

        protected void o() {
            String t16 = t();
            String q16 = q();
            ap.d s16 = s();
            PlayerUtils.log(4, "VodInfoProcess.java@MediaPlayerMgr", "[getvinfo] tvk_log getRequestUrl = " + t16);
            PlayerUtils.log(3, "VodInfoProcess.java@MediaPlayerMgr", "[getvinfo] tvk_log getQueryParams = " + s16.toString());
            HttpUtils.f(TencentVideo.a(), t16, q16, r(), s16, null, this.f60000j);
        }

        protected void p(int i3) {
            String u16 = u(i3);
            String q16 = q();
            ap.d s16 = s();
            PlayerUtils.log(4, "VodInfoProcess.java@MediaPlayerMgr", "[getvinfo] getRequestUrl = " + u16 + ", getRequestHost = " + q16 + ", apn = " + NetworkManager.getIspType());
            StringBuilder sb5 = new StringBuilder();
            sb5.append("[getvinfo] getQueryParams = ");
            sb5.append(s16.toString());
            PlayerUtils.log(3, "VodInfoProcess.java@MediaPlayerMgr", sb5.toString());
            HttpUtils.f(TencentVideo.a(), u16, q16, r(), s16, null, this.f60000j);
        }

        public String q() {
            if (this.f59991a) {
                return com.qzone.video.TVK_SDK.mediaplayer.config.a.f59862h;
            }
            return com.qzone.video.TVK_SDK.mediaplayer.config.a.f59861g;
        }

        protected ap.d s() {
            ap.d dVar = new ap.d(this.f59995e.i());
            dVar.g("vid", this.f59995e.r());
            dVar.f("dfnnettype", this.f59995e.f());
            dVar.f("device", this.f59995e.c());
            dVar.f("dfnvip", this.f59995e.d());
            dVar.f("dfncase", this.f59995e.e());
            dVar.g("dfnres", this.f59995e.g());
            dVar.f(TVKLiveRequestBuilder.RequestParamKey.HTTPS, this.f59995e.q());
            dVar.g(AdParam.OTYPE, ark.ARKMETADATA_JSON);
            if (this.f59995e.s()) {
                dVar.g("charge", "1");
            }
            dVar.g("platform", this.f59995e.m());
            dVar.g("newplatform", this.f59995e.m());
            dVar.g("sdtfrom", this.f59995e.n());
            dVar.g("defn", this.f59995e.j());
            int h16 = this.f59995e.h();
            if ("auto".equalsIgnoreCase(com.qzone.video.TVK_SDK.mediaplayer.config.b.f59863a)) {
                if (h16 == 1) {
                    dVar.g("clip", "4");
                    dVar.g(AdParam.DTYPE, "1");
                } else {
                    dVar.g("clip", "0");
                    dVar.g(AdParam.DTYPE, String.valueOf(h16));
                }
            } else if ("mp4".equalsIgnoreCase(com.qzone.video.TVK_SDK.mediaplayer.config.b.f59863a)) {
                dVar.g("clip", "4");
                dVar.g(AdParam.DTYPE, "1");
            } else if (TVKMediaPlayerConfig.PlayerConfig.FORMAT_ID_HLS.equalsIgnoreCase(com.qzone.video.TVK_SDK.mediaplayer.config.b.f59863a)) {
                dVar.g("clip", "0");
                dVar.g(AdParam.DTYPE, String.valueOf(3));
            }
            dVar.g("uin", this.f59995e.o());
            dVar.g("logo", "1");
            dVar.g("guid", TencentVideo.b());
            dVar.g(TVKLiveRequestBuilder.RequestParamKey.RANDOM_NUMBER, String.valueOf(Math.random()));
            dVar.g("thirdAppVer", com.qzone.video.TVK_SDK.mediaplayer.utils.e.a(TencentVideo.a()));
            dVar.g(AdParam.APPVER, this.f59995e.a());
            dVar.g(AdParam.ENCRYPTVER, this.f59994d);
            if (!TextUtils.isEmpty(this.f59995e.b())) {
                dVar.g("cKey", this.f59995e.b());
            }
            if (!TextUtils.isEmpty(this.f59995e.p())) {
                dVar.g("unicom", this.f59995e.p());
            } else {
                dVar.g("unicom", "");
            }
            Map<String, String> i3 = this.f59995e.i();
            if (i3 != null) {
                for (Map.Entry<String, String> entry : i3.entrySet()) {
                    dVar.g(entry.getKey(), entry.getValue());
                }
            }
            if (this.f59995e.k() > 0) {
                dVar.f("hevclv", this.f59995e.k());
            }
            dVar.f("unicomtype", TMSManager.e().h() ? 2 : -1);
            dVar.f("newnettype", NetworkState.getNetworkType());
            dVar.f("netoperator", n(com.tencent.mobileqq.vip.l.b().first.intValue()));
            return dVar;
        }

        protected String t() {
            if (this.f59991a) {
                return com.qzone.video.TVK_SDK.mediaplayer.config.a.f59856b;
            }
            return com.qzone.video.TVK_SDK.mediaplayer.config.a.f59855a;
        }

        protected String u(int i3) {
            String str;
            if (this.f59991a) {
                str = com.qzone.video.TVK_SDK.mediaplayer.config.a.f59856b;
            } else {
                str = com.qzone.video.TVK_SDK.mediaplayer.config.a.f59855a;
            }
            if (e.this.f59971f == null || e.this.f59971f.size() == 0) {
                e.this.f59971f = i.H().G0(str);
                if (e.this.f59971f != null && e.this.f59971f.size() > 0) {
                    this.f59992b = e.this.f59971f.size();
                }
            }
            Uri parse = Uri.parse(str);
            String str2 = parse.getScheme() + QzoneWebViewOfflinePlugin.STR_DEVIDER;
            if (e.this.f59971f != null && e.this.f59971f.size() > i3) {
                str = str2 + ((String) e.this.f59971f.get(i3)) + parse.getPath();
            }
            PlayerUtils.log(5, "VodInfoProcess.java@MediaPlayerMgr", "requestUrl = " + str);
            return str;
        }

        protected com.qzone.video.TVK_SDK.mediaplayer.vodcgi.a x(String str) throws JSONException {
            if (HttpUtils.b(str).equals(str)) {
                JSONObject jSONObject = new JSONObject(str);
                com.qzone.video.TVK_SDK.mediaplayer.vodcgi.a aVar = new com.qzone.video.TVK_SDK.mediaplayer.vodcgi.a();
                aVar.H(109);
                aVar.M(jSONObject.optString("ret"));
                aVar.N(jSONObject.optString("msg"));
                return aVar;
            }
            return w(HttpUtils.b(str));
        }

        private String i(String str) {
            if (str == null || TextUtils.isEmpty(com.qzone.video.TVK_SDK.mediaplayer.config.b.f59864b) || 3 == this.f59995e.h()) {
                return str;
            }
            return (str.substring(0, str.indexOf(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER) + 1) + com.qzone.video.TVK_SDK.mediaplayer.config.b.f59864b + ContainerUtils.FIELD_DELIMITER) + str.substring(str.indexOf(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER) + 1);
        }
    }

    private boolean j(zo.d dVar, com.qzone.video.TVK_SDK.mediaplayer.vodcgi.b bVar) {
        return (dVar == null || bVar == null || TextUtils.isEmpty(dVar.r())) ? false : true;
    }
}
