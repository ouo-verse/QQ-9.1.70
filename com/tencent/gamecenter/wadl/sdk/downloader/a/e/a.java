package com.tencent.gamecenter.wadl.sdk.downloader.a.e;

import android.net.http.Headers;
import android.text.TextUtils;
import com.tencent.gamecenter.wadl.biz.entity.WadlReportBuilder;
import com.tencent.gamecenter.wadl.sdk.downloader.DownloaderConstant;
import com.tencent.gamecenter.wadl.sdk.downloader.manager.DNSPreParseManager;
import com.tencent.gamecenter.wadl.sdk.downloader.task.k.a;
import com.tencent.mtt.hippy.adapter.http.HttpHeader;
import com.tencent.raft.standard.report.BaseEvent;
import com.tencent.raft.standard.report.IRReport;
import cooperation.qzone.music.QzoneWebMusicJsPlugin;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes6.dex */
public abstract class a implements com.tencent.gamecenter.wadl.sdk.downloader.a.d {

    /* renamed from: t, reason: collision with root package name */
    public static String f107280t = "BaseReq";

    /* renamed from: b, reason: collision with root package name */
    protected int f107282b;

    /* renamed from: c, reason: collision with root package name */
    protected com.tencent.gamecenter.wadl.sdk.downloader.task.k.a f107283c;

    /* renamed from: d, reason: collision with root package name */
    protected Map<String, String> f107284d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f107285e;

    /* renamed from: f, reason: collision with root package name */
    protected boolean f107286f;

    /* renamed from: g, reason: collision with root package name */
    protected String f107287g;

    /* renamed from: h, reason: collision with root package name */
    protected Map<String, String> f107288h;

    /* renamed from: k, reason: collision with root package name */
    protected String f107291k;

    /* renamed from: s, reason: collision with root package name */
    protected String f107299s;

    /* renamed from: a, reason: collision with root package name */
    protected URL f107281a = null;

    /* renamed from: i, reason: collision with root package name */
    protected c f107289i = new c();

    /* renamed from: j, reason: collision with root package name */
    private String f107290j = null;

    /* renamed from: l, reason: collision with root package name */
    protected List<String> f107292l = null;

    /* renamed from: m, reason: collision with root package name */
    protected e f107293m = new e();

    /* renamed from: n, reason: collision with root package name */
    protected int f107294n = 0;

    /* renamed from: o, reason: collision with root package name */
    protected String f107295o = "";

    /* renamed from: p, reason: collision with root package name */
    protected volatile boolean f107296p = false;

    /* renamed from: q, reason: collision with root package name */
    protected HttpURLConnection f107297q = null;

    /* renamed from: r, reason: collision with root package name */
    private InputStream f107298r = null;

    public a(com.tencent.gamecenter.wadl.sdk.downloader.task.k.a aVar, Map<String, String> map, b bVar, boolean z16, boolean z17, com.tencent.gamecenter.wadl.sdk.downloader.task.k.b bVar2, int i3, String str) {
        this.f107284d = null;
        this.f107299s = "";
        this.f107283c = aVar;
        this.f107284d = map;
        this.f107285e = z16;
        this.f107286f = z17;
        if (bVar != null) {
            this.f107289i.a(bVar);
            this.f107293m.f107309f = true;
        }
        this.f107287g = bVar2.b();
        this.f107288h = bVar2.b(aVar.f107609b);
        this.f107282b = i3;
        this.f107299s = str;
    }

    private HttpURLConnection i() {
        HttpURLConnection a16 = a(this.f107281a);
        a16.setConnectTimeout(com.tencent.gamecenter.wadl.sdk.downloader.a.a.a());
        a16.setReadTimeout(com.tencent.gamecenter.wadl.sdk.downloader.a.a.h());
        a16.setUseCaches(false);
        a16.setDoInput(true);
        a16.setInstanceFollowRedirects(false);
        return a16;
    }

    private void j() {
        this.f107294n = 0;
        this.f107295o = "";
        com.tencent.gamecenter.wadl.sdk.common.e.b.a(f107280t, "executeOnce lastUrl\uff1a " + this.f107291k);
        try {
            this.f107281a = new URL(this.f107291k);
            try {
                this.f107297q = i();
                o();
                l();
            } catch (IOException e16) {
                a(e16);
            }
        } catch (MalformedURLException e17) {
            this.f107294n = -51;
            this.f107295o = com.tencent.gamecenter.wadl.sdk.downloader.a.c.a((Throwable) e17);
            com.tencent.gamecenter.wadl.sdk.common.e.b.b(f107280t, "executeOnce exception", e17);
        }
    }

    private void k() {
        int i3;
        String str;
        a(this.f107297q);
        if (com.tencent.gamecenter.wadl.sdk.downloader.a.c.d(this.f107293m.f107305b)) {
            this.f107294n = -11;
            this.f107295o = this.f107291k;
            return;
        }
        String headerField = this.f107297q.getHeaderField("Content-Range");
        String headerField2 = this.f107297q.getHeaderField("Content-Length");
        if (this.f107293m.f107309f) {
            if (!TextUtils.isEmpty(headerField)) {
                this.f107293m.f107304a = com.tencent.gamecenter.wadl.sdk.downloader.a.c.g(headerField);
                if (this.f107293m.f107304a == -1) {
                    this.f107294n = -54;
                    str = "content-range header:" + headerField;
                    this.f107295o = str;
                    return;
                }
                return;
            }
            i3 = -53;
            this.f107294n = i3;
        }
        if (!TextUtils.isEmpty(headerField2)) {
            this.f107293m.f107304a = com.tencent.gamecenter.wadl.sdk.downloader.a.c.f(headerField2);
            if (this.f107293m.f107304a == -1) {
                this.f107294n = -56;
                str = "content-range header:" + headerField2;
                this.f107295o = str;
                return;
            }
            return;
        }
        i3 = -55;
        this.f107294n = i3;
    }

    private void l() {
        try {
            int responseCode = this.f107297q.getResponseCode();
            if (responseCode != 200 && responseCode != 206) {
                if (responseCode != 307) {
                    if (responseCode != 413 && responseCode != 500) {
                        switch (responseCode) {
                            case 301:
                            case 302:
                            case 303:
                                break;
                            default:
                                this.f107294n = responseCode;
                                break;
                        }
                    } else {
                        a(responseCode);
                    }
                }
                b(responseCode);
            } else {
                k();
            }
        } catch (Throwable th5) {
            a(th5);
        }
    }

    private void m() {
        com.tencent.gamecenter.wadl.sdk.downloader.task.k.a aVar;
        String a16;
        if (TextUtils.isEmpty(this.f107291k) && (aVar = this.f107283c) != null) {
            if (this.f107282b == 2 || aVar.f107611d) {
                a16 = aVar.a();
            } else {
                a16 = aVar.f107608a;
            }
            this.f107291k = a16;
        }
    }

    private void n() {
        if (this.f107294n == 0 && TextUtils.isEmpty(this.f107283c.f107612e)) {
            try {
                String b16 = b();
                if (!TextUtils.isEmpty(b16)) {
                    this.f107283c.f107612e = b16;
                } else {
                    com.tencent.gamecenter.wadl.sdk.downloader.task.k.a aVar = this.f107283c;
                    aVar.f107612e = aVar.f107608a;
                }
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
    }

    private void o() {
        boolean z16;
        if (this.f107289i.f107302a.size() > 0) {
            this.f107297q.addRequestProperty("Range", this.f107289i.toString());
        }
        this.f107297q.addRequestProperty("Connection", "close");
        Map<String, String> map = this.f107284d;
        boolean z17 = false;
        if (map != null) {
            z16 = false;
            for (String str : map.keySet()) {
                this.f107297q.addRequestProperty(str, this.f107284d.get(str));
                if ("User-Agent".equalsIgnoreCase(str)) {
                    z16 = true;
                }
                if ("host".equalsIgnoreCase(str)) {
                    z17 = true;
                }
            }
        } else {
            z16 = false;
        }
        Map<String, String> map2 = this.f107288h;
        if (map2 != null && map2.size() > 0) {
            for (String str2 : this.f107288h.keySet()) {
                if (str2.equalsIgnoreCase("host")) {
                    z17 = true;
                }
                if (!str2.equalsIgnoreCase(DownloaderConstant.KEY_RANGE) && !this.f107297q.getURL().getPath().contains(this.f107287g)) {
                    this.f107297q.addRequestProperty(str2, this.f107288h.get(str2));
                }
            }
        }
        a(this.f107297q, z17, z16);
    }

    @Override // com.tencent.gamecenter.wadl.sdk.downloader.a.d
    public long a(com.tencent.gamecenter.wadl.sdk.downloader.a.b bVar) {
        long j3 = 0;
        try {
            this.f107298r = com.tencent.gamecenter.wadl.sdk.downloader.manager.c.a().a(this.f107297q.getInputStream());
            long a16 = com.tencent.gamecenter.wadl.sdk.downloader.a.c.a(this.f107289i.a(), this.f107293m.f107304a);
            byte[] bArr = new byte[4096];
            boolean z16 = true;
            boolean z17 = true;
            while (j3 < a16) {
                if (this.f107296p) {
                    com.tencent.gamecenter.wadl.sdk.downloader.manager.c.a().b(this.f107298r);
                    if (this.f107296p) {
                        this.f107294n = -66;
                    }
                    e();
                    return j3;
                }
                if (!z16) {
                    com.tencent.gamecenter.wadl.sdk.downloader.manager.c.a().b(this.f107298r);
                    if (this.f107296p) {
                        this.f107294n = -66;
                    }
                    e();
                    return j3;
                }
                int read = this.f107298r.read(bArr, 0, (int) Math.min(4096L, a16 - j3));
                if (read == -1) {
                    this.f107294n = -62;
                    this.f107295o = "readLen:" + j3 + ",dataLen:" + a16;
                    com.tencent.gamecenter.wadl.sdk.downloader.manager.c.a().b(this.f107298r);
                    if (this.f107296p) {
                        this.f107294n = -66;
                    }
                    e();
                    return j3;
                }
                if (bVar != null) {
                    if (!this.f107296p) {
                        z16 = bVar.a(bArr, read, z17);
                    }
                    if (z17) {
                        z17 = false;
                    }
                } else {
                    com.tencent.gamecenter.wadl.sdk.common.e.b.b(f107280t, "dataReceiver is null");
                }
                j3 += read;
            }
            com.tencent.gamecenter.wadl.sdk.downloader.manager.c.a().b(this.f107298r);
            if (this.f107296p) {
                this.f107294n = -66;
            }
            e();
            return j3;
        } catch (Throwable th5) {
            try {
                a(th5);
                com.tencent.gamecenter.wadl.sdk.downloader.manager.c.a().b(this.f107298r);
                if (this.f107296p) {
                    this.f107294n = -66;
                }
                e();
                return j3;
            } catch (Throwable unused) {
                com.tencent.gamecenter.wadl.sdk.downloader.manager.c.a().b(this.f107298r);
                if (this.f107296p) {
                    this.f107294n = -66;
                }
                e();
                return j3;
            }
        }
    }

    abstract HttpURLConnection a(URL url);

    @Override // com.tencent.gamecenter.wadl.sdk.downloader.a.d
    public String b() {
        return this.f107290j;
    }

    @Override // com.tencent.gamecenter.wadl.sdk.downloader.a.d
    public byte[] c() {
        ByteArrayOutputStream byteArrayOutputStream;
        byte[] bArr = null;
        try {
            try {
                this.f107298r = this.f107297q.getInputStream();
                byte[] bArr2 = new byte[256];
                byteArrayOutputStream = new ByteArrayOutputStream();
                while (true) {
                    try {
                        int read = this.f107298r.read(bArr2);
                        if (read == -1) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr2, 0, read);
                    } catch (Throwable th5) {
                        th = th5;
                        try {
                            a(th);
                            e();
                            if (byteArrayOutputStream != null) {
                                byteArrayOutputStream.close();
                            }
                            return bArr;
                        } catch (Throwable th6) {
                            e();
                            if (byteArrayOutputStream != null) {
                                try {
                                    byteArrayOutputStream.close();
                                } catch (IOException e16) {
                                    com.tencent.gamecenter.wadl.sdk.common.e.b.b(f107280t, "readAllData out close fail!", e16);
                                }
                            }
                            throw th6;
                        }
                    }
                }
                bArr = byteArrayOutputStream.toByteArray();
                e();
                byteArrayOutputStream.close();
            } catch (Throwable th7) {
                th = th7;
                byteArrayOutputStream = null;
            }
        } catch (IOException e17) {
            com.tencent.gamecenter.wadl.sdk.common.e.b.b(f107280t, "readAllData out close fail!", e17);
        }
        return bArr;
    }

    @Override // com.tencent.gamecenter.wadl.sdk.downloader.a.d
    public void d() {
        this.f107296p = true;
        com.tencent.gamecenter.wadl.sdk.common.e.b.a(f107280t, "abort");
    }

    @Override // com.tencent.gamecenter.wadl.sdk.downloader.a.d
    public void e() {
        String str;
        InputStream inputStream = this.f107298r;
        if (inputStream != null) {
            try {
                inputStream.close();
                com.tencent.gamecenter.wadl.sdk.common.e.b.a(f107280t, "cleanRequest close inputStream");
            } catch (Throwable th5) {
                com.tencent.gamecenter.wadl.sdk.common.e.b.b(f107280t, "cleanRequest close inputStream exception", th5);
            }
        }
        HttpURLConnection httpURLConnection = this.f107297q;
        if (httpURLConnection != null) {
            URL url = httpURLConnection.getURL();
            String str2 = f107280t;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("cleanRequest disconnect conn ");
            if (url != null) {
                str = url.getHost();
            } else {
                str = QzoneWebMusicJsPlugin.EVENT_UNKOWN;
            }
            sb5.append(str);
            com.tencent.gamecenter.wadl.sdk.common.e.b.a(str2, sb5.toString());
            try {
                this.f107297q.disconnect();
            } catch (Throwable th6) {
                com.tencent.gamecenter.wadl.sdk.common.e.b.b(f107280t, "cleanRequest disconnect conn exception", th6);
            }
        }
    }

    @Override // com.tencent.gamecenter.wadl.sdk.downloader.a.d
    public List<String> f() {
        return this.f107292l;
    }

    @Override // com.tencent.gamecenter.wadl.sdk.downloader.a.d
    public int g() {
        return this.f107294n;
    }

    @Override // com.tencent.gamecenter.wadl.sdk.downloader.a.d
    public String getFailInfo() {
        return this.f107295o;
    }

    @Override // com.tencent.gamecenter.wadl.sdk.downloader.a.d
    public e h() {
        return this.f107293m;
    }

    private void b(int i3) {
        String headerField = this.f107297q.getHeaderField("location");
        if (TextUtils.isEmpty(headerField)) {
            this.f107294n = -58;
            this.f107295o = "location:" + headerField;
        } else {
            String a16 = com.tencent.gamecenter.wadl.sdk.downloader.a.c.a(headerField, this.f107283c.f107608a);
            this.f107291k = a16;
            this.f107290j = a16;
            b(a16);
            this.f107294n = -57;
        }
        try {
            a(i3, this.f107290j);
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x003b, code lost:
    
        if (r0 < 8) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x003f, code lost:
    
        if (r5.f107294n != (-57)) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0041, code lost:
    
        r5.f107294n = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0044, code lost:
    
        n();
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0047, code lost:
    
        return;
     */
    @Override // com.tencent.gamecenter.wadl.sdk.downloader.a.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a() {
        m();
        e();
        int i3 = 0;
        while (true) {
            if (i3 >= 8) {
                break;
            }
            if (this.f107296p) {
                return;
            }
            j();
            if (this.f107294n != -57) {
                break;
            }
            if (this.f107286f) {
                this.f107294n = -74;
                this.f107295o = "location:" + this.f107291k;
                break;
            }
            i3++;
        }
    }

    private void b(String str) {
        int indexOf;
        HttpURLConnection httpURLConnection = this.f107297q;
        String headerField = httpURLConnection != null ? httpURLConnection.getHeaderField("X-Extra-Servers") : "";
        if (TextUtils.isEmpty(headerField)) {
            return;
        }
        try {
            if ("http".equals(new URL(str).getProtocol()) && str.startsWith("http://") && (indexOf = str.indexOf("/", 7)) != -1) {
                String substring = str.substring(indexOf);
                String[] split = headerField.split(";");
                if (split == null || split.length <= 0) {
                    return;
                }
                this.f107292l = new ArrayList();
                for (String str2 : split) {
                    this.f107292l.add("http://" + str2 + substring);
                }
            }
        } catch (Exception unused) {
        }
    }

    protected void a(int i3) {
        if (com.tencent.gamecenter.wadl.sdk.common.b.c.k() && !this.f107285e && this.f107293m.f107309f) {
            i3 = -59;
        }
        this.f107294n = i3;
    }

    private void a(int i3, String str) {
        com.tencent.gamecenter.wadl.sdk.common.e.b.c(f107280t, "reportSpeedLimited statusCode:" + i3 + ",lastJumpUrl:" + str);
        String str2 = com.tencent.gamecenter.wadl.sdk.common.e.g.c(str).get("xbl_sche");
        HashMap hashMap = new HashMap();
        hashMap.put("ext11", "1");
        hashMap.put("ext12", "160");
        hashMap.put("oper_module", "769");
        hashMap.put("ext1", "76901");
        hashMap.put(WadlReportBuilder.TableElem.OPER_ID, "989670");
        if (!"1".equals(str2) && !"2".equals(str2) && !"3".equals(str2)) {
            str2 = "0";
        }
        hashMap.put("ext25", str2);
        com.tencent.gamecenter.wadl.sdk.downloader.task.k.a aVar = this.f107283c;
        String str3 = (aVar == null || TextUtils.isEmpty(aVar.f107608a)) ? "" : this.f107283c.f107608a;
        if (str == null) {
            str = "";
        }
        hashMap.put("ext26", str);
        hashMap.put("ext27", str3);
        hashMap.put("ext28", i3 + "");
        String str4 = this.f107299s;
        if (str4 == null) {
            str4 = "";
        }
        hashMap.put("ext29", str4);
        BaseEvent baseEvent = new BaseEvent("", "", true, hashMap);
        IRReport iRReport = com.tencent.gamecenter.wadl.sdk.common.a.f106990m;
        if (iRReport != null) {
            iRReport.report(baseEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(Throwable th5) {
        com.tencent.gamecenter.wadl.sdk.common.e.b.b(f107280t, "handleException exception", th5);
        this.f107295o = com.tencent.gamecenter.wadl.sdk.downloader.a.c.a(th5);
        this.f107294n = this.f107296p ? -66 : com.tencent.gamecenter.wadl.sdk.common.b.c.h() ? -77 : !com.tencent.gamecenter.wadl.sdk.common.b.c.j() ? -15 : !com.tencent.gamecenter.wadl.sdk.common.b.f.a() ? -16 : com.tencent.gamecenter.wadl.sdk.downloader.a.c.b(th5);
    }

    protected void a(HttpURLConnection httpURLConnection) {
        if (httpURLConnection == null) {
            return;
        }
        this.f107293m.f107305b = httpURLConnection.getHeaderField("Content-Type");
        this.f107293m.f107307d = httpURLConnection.getHeaderField(Headers.ETAG);
        this.f107293m.f107308e = httpURLConnection.getHeaderField("Last-Modified");
        this.f107293m.f107306c = httpURLConnection.getHeaderField(HttpHeader.RSP.CONTENT_DISPOSITION);
    }

    protected void a(HttpURLConnection httpURLConnection, boolean z16, boolean z17) {
        if (httpURLConnection == null || this.f107283c == null) {
            return;
        }
        if (!z17) {
            httpURLConnection.addRequestProperty("User-Agent", "HalleyService/3.0");
        }
        if (z16 || TextUtils.isEmpty(this.f107287g) || this.f107283c.f107609b != a.EnumC1136a.Type_CDN_Ip_Socket_Schedule || httpURLConnection.getURL().getPath().contains(this.f107287g)) {
            return;
        }
        httpURLConnection.addRequestProperty("Host", this.f107287g);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean a(String str) {
        return DNSPreParseManager.getInstance().isDnsPreParseSwitchOn() && DNSPreParseManager.getInstance().getAllDomains().contains(str);
    }
}
