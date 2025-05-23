package com.qq.e.comm.plugin.base.ad.clickcomponent;

import android.text.TextUtils;
import android.util.Pair;
import com.qq.e.comm.plugin.base.ad.clickcomponent.a.a;
import com.qq.e.comm.plugin.base.ad.model.f;
import com.qq.e.comm.plugin.k.af;
import com.qq.e.comm.plugin.k.ay;
import com.qq.e.comm.plugin.k.i;
import com.qq.e.comm.plugin.k.y;
import com.qq.e.comm.plugin.stat.StatTracer;
import com.qq.e.comm.util.StringUtil;
import com.qq.e.tg.cfg.VideoResultReceiver;
import com.tencent.ad.tangram.protocol.sdk_event_log;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import java.io.UnsupportedEncodingException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class ClickInfo {
    public static final int CLICK_ACTION_TYPE_DOWNLOAD_WITHOUT_REPORT = 8;
    public static final int CLICK_ACTION_TYPE_DOWNLOAD_WITH_REPORT = 5;
    public static final int CLICK_ACTION_TYPE_NORMAL = 1;
    public static final int CLICK_ACTION_TYPE_NORMAL_WITHOUT_APP_DOWNLOAD = 7;
    public static final int CLICK_ACTION_TYPE_ONLY_ACTION = 3;
    public static final int CLICK_ACTION_TYPE_ONLY_ACTION_WITHOUT_PAGE = 4;
    public static final int CLICK_ACTION_TYPE_ONLY_REPORT = 2;
    public static final int CLICK_ACTION_TYPE_ONLY_REPORT_EXTERNAL = 9;
    public static final int CLICK_ACTION_TYPE_ONLY_WEB_PAGE_CLICK = 6;
    public static final int CLICK_ACTION_TYPE_ONLY_WECHAT = 10;
    public static final int CLICK_ACTION_TYPE_UNKNOWN = 0;
    public static final int TRIPLE_LINK_TYPE_DEFAULT = 12;

    /* renamed from: a, reason: collision with root package name */
    long f38484a;

    /* renamed from: b, reason: collision with root package name */
    private com.qq.e.comm.plugin.base.ad.clickcomponent.e f38485b;

    /* renamed from: c, reason: collision with root package name */
    private f f38486c;

    /* renamed from: d, reason: collision with root package name */
    private c f38487d;

    /* renamed from: e, reason: collision with root package name */
    private e f38488e;

    /* renamed from: f, reason: collision with root package name */
    private com.qq.e.comm.plugin.base.ad.clickcomponent.a.b f38489f;

    /* renamed from: g, reason: collision with root package name */
    private com.qq.e.comm.plugin.base.ad.clickcomponent.a.c f38490g;

    /* renamed from: h, reason: collision with root package name */
    private d f38491h;

    /* renamed from: i, reason: collision with root package name */
    private int f38492i;

    /* renamed from: j, reason: collision with root package name */
    private int f38493j;

    /* renamed from: k, reason: collision with root package name */
    private a f38494k;

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface ClickActionType {
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private int f38497a;

        /* renamed from: b, reason: collision with root package name */
        private int f38498b = Integer.MIN_VALUE;

        /* renamed from: c, reason: collision with root package name */
        private boolean f38499c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f38500d;

        public int a() {
            return this.f38497a;
        }

        public int b() {
            return this.f38498b;
        }

        public boolean c() {
            return this.f38499c;
        }

        public void d() {
            this.f38500d = true;
        }

        public boolean e() {
            return this.f38500d;
        }

        public void a(int i3) {
            this.f38498b = i3 - 1;
        }

        public void a(boolean z16) {
            this.f38499c = z16;
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private f f38501a;

        /* renamed from: b, reason: collision with root package name */
        private c f38502b;

        /* renamed from: c, reason: collision with root package name */
        private com.qq.e.comm.plugin.base.ad.clickcomponent.e f38503c;

        /* renamed from: d, reason: collision with root package name */
        private e f38504d;

        /* renamed from: e, reason: collision with root package name */
        private d f38505e;

        /* renamed from: f, reason: collision with root package name */
        private int f38506f;

        /* renamed from: g, reason: collision with root package name */
        private int f38507g = -1;

        /* renamed from: h, reason: collision with root package name */
        private a f38508h;

        public b a(f fVar) {
            this.f38501a = fVar;
            return this;
        }

        public b a(d dVar) {
            this.f38505e = dVar;
            return this;
        }

        public b a(c cVar) {
            this.f38502b = cVar;
            return this;
        }

        public b a(com.qq.e.comm.plugin.base.ad.clickcomponent.e eVar) {
            this.f38503c = eVar;
            return this;
        }

        public b a(e eVar) {
            this.f38504d = eVar;
            return this;
        }

        public b a(int i3) {
            this.f38506f = i3;
            return this;
        }

        public b a(a aVar) {
            this.f38508h = aVar;
            return this;
        }

        public ClickInfo a() {
            return new ClickInfo(this);
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public String f38509a;

        /* renamed from: b, reason: collision with root package name */
        public com.qq.e.comm.plugin.base.ad.b f38510b;

        /* renamed from: c, reason: collision with root package name */
        public String f38511c;

        public c(String str, com.qq.e.comm.plugin.base.ad.b bVar, String str2) {
            this.f38509a = str;
            this.f38510b = bVar;
            this.f38511c = str2;
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class e {

        /* renamed from: a, reason: collision with root package name */
        public boolean f38514a;

        /* renamed from: b, reason: collision with root package name */
        public int f38515b;

        /* renamed from: c, reason: collision with root package name */
        public int f38516c;

        /* renamed from: d, reason: collision with root package name */
        public String f38517d;

        /* renamed from: e, reason: collision with root package name */
        public long f38518e;

        /* renamed from: f, reason: collision with root package name */
        public String f38519f;

        /* renamed from: g, reason: collision with root package name */
        public boolean f38520g = true;

        /* renamed from: h, reason: collision with root package name */
        public WeakReference<VideoResultReceiver> f38521h;

        public e(boolean z16, int i3, int i16, String str, long j3, String str2, WeakReference<VideoResultReceiver> weakReference) {
            this.f38517d = null;
            this.f38514a = z16;
            this.f38515b = i3;
            this.f38516c = i16;
            this.f38518e = j3;
            this.f38519f = str2;
            this.f38521h = weakReference;
            this.f38517d = com.qq.e.comm.plugin.base.ad.clickcomponent.d.d.a(i3, i16, str);
        }
    }

    public void a() {
        if (d() != null) {
            a(this);
            d().ab();
        }
    }

    public com.qq.e.comm.plugin.base.ad.clickcomponent.e b() {
        return this.f38485b;
    }

    public c c() {
        return this.f38487d;
    }

    public f d() {
        return this.f38486c;
    }

    public String e() {
        return this.f38486c.y();
    }

    public a f() {
        return this.f38494k;
    }

    public int g() {
        d dVar = this.f38491h;
        if (dVar == null) {
            return 1;
        }
        return dVar.f38513b;
    }

    public String h() {
        f fVar = this.f38486c;
        if (fVar == null) {
            return null;
        }
        String c16 = i.c(fVar.v(), this.f38494k);
        if (TextUtils.isEmpty(c16)) {
            return null;
        }
        boolean z16 = true;
        try {
            String host = new URL(c16).getHost();
            if (!host.endsWith("gdt.qq.com")) {
                if (!host.endsWith("c.l.qq.com")) {
                    z16 = false;
                }
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        if (!z16) {
            return c16;
        }
        if (b() == null) {
            return c16;
        }
        String d16 = b().d();
        if (!StringUtil.isEmpty(d16)) {
            c16 = ay.a(c16, ReportConstant.COSTREPORT_PREFIX, d16);
        }
        if (this.f38486c.t() != com.qq.e.comm.plugin.base.ad.b.SPLASH) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("click_pos", this.f38493j);
                c16 = ay.d(c16, "feeds_attachment", URLEncoder.encode(jSONObject.toString(), "UTF-8"));
            } catch (UnsupportedEncodingException | JSONException e17) {
                e17.printStackTrace();
            }
            c16 = ay.d(c16, "click_area", String.valueOf(b().e()));
        }
        return com.qq.e.comm.plugin.k.b.c(com.qq.e.comm.plugin.k.b.b(c16));
    }

    public com.qq.e.comm.plugin.base.ad.clickcomponent.a.b i() {
        return this.f38489f;
    }

    public JSONObject j() {
        f fVar = this.f38486c;
        if (fVar != null) {
            return fVar.v();
        }
        return null;
    }

    public e k() {
        return this.f38488e;
    }

    public d l() {
        return this.f38491h;
    }

    public long m() {
        return this.f38484a;
    }

    public String n() {
        c cVar = this.f38487d;
        if (cVar != null) {
            return cVar.f38511c;
        }
        return null;
    }

    public com.qq.e.comm.plugin.base.ad.clickcomponent.a.c o() {
        return this.f38490g;
    }

    public String p() {
        if (!com.qq.e.comm.plugin.j.c.a("supportDualOpenRewardH5", 1, 1) || d() == null || d().X() == null) {
            return "";
        }
        return d().X().a();
    }

    public boolean q() {
        JSONObject j3 = j();
        if (!y.a(j3)) {
            return false;
        }
        JSONObject optJSONObject = j3.optJSONObject("splash_switch");
        if (!y.a(optJSONObject)) {
            return false;
        }
        return optJSONObject.optBoolean("contract_rl_report", false);
    }

    public boolean r() {
        int[] ap5;
        f fVar = this.f38486c;
        if (fVar != null && (ap5 = fVar.ap()) != null && ap5.length > 0) {
            for (int i3 : ap5) {
                if (i3 == 12) {
                    return true;
                }
            }
        }
        return false;
    }

    ClickInfo(b bVar) {
        this.f38486c = bVar.f38501a;
        this.f38485b = bVar.f38503c;
        this.f38487d = bVar.f38502b;
        this.f38488e = bVar.f38504d;
        this.f38494k = bVar.f38508h;
        this.f38489f = new com.qq.e.comm.plugin.base.ad.clickcomponent.a.b(h());
        this.f38491h = bVar.f38505e;
        this.f38492i = bVar.f38506f;
        this.f38493j = bVar.f38507g;
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        public Pair<String, String> f38512a;

        /* renamed from: b, reason: collision with root package name */
        public int f38513b;

        public d(int i3) {
            this.f38513b = 1;
            if (i3 != 0) {
                this.f38513b = i3;
            }
        }

        public d(Pair<String, String> pair, int i3) {
            this.f38513b = 1;
            this.f38512a = pair;
            if (i3 != 0) {
                this.f38513b = i3;
            }
        }
    }

    private void a(final ClickInfo clickInfo) {
        boolean z16;
        List<String> E = d().E();
        if (com.qq.e.comm.plugin.k.b.a(d())) {
            com.qq.e.comm.plugin.base.ad.clickcomponent.c.c.a(sdk_event_log.SdkEventDimension.EVENT_STATISTICS_CLICK_START, clickInfo, 5, 0);
        }
        if (E == null || E.size() <= 0) {
            return;
        }
        for (String str : E) {
            String b16 = com.qq.e.comm.plugin.j.e.a().b(c().f38511c, "contractC2SClickHost");
            List arrayList = new ArrayList();
            if (TextUtils.isEmpty(b16)) {
                arrayList.add("c.l.qq.com/click");
                arrayList.add("ttc.gdt.qq.com/click");
            } else {
                arrayList = Arrays.asList(TextUtils.split(b16, ","));
            }
            Iterator it = arrayList.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (str.contains((String) it.next())) {
                        z16 = true;
                        break;
                    }
                } else {
                    z16 = false;
                    break;
                }
            }
            if (z16) {
                com.qq.e.comm.plugin.base.ad.clickcomponent.a.a aVar = new com.qq.e.comm.plugin.base.ad.clickcomponent.a.a(com.qq.e.comm.plugin.k.b.c(str));
                aVar.a(new a.InterfaceC0279a() { // from class: com.qq.e.comm.plugin.base.ad.clickcomponent.ClickInfo.1
                    @Override // com.qq.e.comm.plugin.base.ad.clickcomponent.a.a.InterfaceC0279a
                    public void a(int i3, JSONObject jSONObject) {
                        if (i3 != 200 && i3 != 302) {
                            com.qq.e.comm.plugin.base.ad.clickcomponent.c.c.a(sdk_event_log.SdkEventDimension.EVENT_STATISTICS_CLICK_FAILED, clickInfo, 5, i3);
                        } else {
                            com.qq.e.comm.plugin.base.ad.clickcomponent.c.c.a(sdk_event_log.SdkEventDimension.EVENT_STATISTICS_CLICK_SUCCESS, clickInfo, 5, i3);
                        }
                        StatTracer.instantReport(ClickInfo.this.n());
                    }

                    @Override // com.qq.e.comm.plugin.base.ad.clickcomponent.a.a.InterfaceC0279a
                    public void a(Exception exc) {
                        com.qq.e.comm.plugin.base.ad.clickcomponent.c.c.a(sdk_event_log.SdkEventDimension.EVENT_STATISTICS_CLICK_FAILED, clickInfo, 5, 0);
                        StatTracer.instantReport(ClickInfo.this.n());
                    }
                });
                aVar.a();
            } else {
                af.b(str);
            }
        }
    }

    public void a(long j3) {
        this.f38484a = j3;
    }

    public void a(com.qq.e.comm.plugin.base.ad.clickcomponent.a.c cVar) {
        this.f38490g = cVar;
    }
}
