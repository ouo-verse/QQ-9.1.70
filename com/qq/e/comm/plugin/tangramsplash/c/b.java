package com.qq.e.comm.plugin.tangramsplash.c;

import android.text.TextUtils;
import com.qq.e.comm.StubVisitor;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.status.SDKStatus;
import com.qq.e.comm.plugin.i.h;
import com.qq.e.comm.plugin.k.at;
import com.qq.e.comm.plugin.tangramsplash.d.f;
import com.qq.e.comm.plugin.tangramsplash.report.SplashLinkReporter;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.Md5Util;
import com.qq.e.tg.splash.adapter.AdFlowReportAdapter;
import com.qq.e.tg.splash.adapter.AdFlowReporter;
import com.tencent.biz.common.util.WebViewConstants;
import com.tencent.ditto.shell.LayoutAttrDefine;
import cooperation.qzone.webviewplugin.QzoneZipCacheHelper;
import java.io.File;

/* compiled from: P */
/* loaded from: classes3.dex */
public class b extends com.qq.e.comm.plugin.i.a {

    /* renamed from: a, reason: collision with root package name */
    public final h f39812a;

    /* renamed from: b, reason: collision with root package name */
    public int f39813b;

    /* renamed from: d, reason: collision with root package name */
    public String f39814d;

    /* renamed from: e, reason: collision with root package name */
    public String f39815e;

    /* renamed from: f, reason: collision with root package name */
    public final String f39816f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f39817g;

    /* renamed from: h, reason: collision with root package name */
    public String f39818h;

    /* renamed from: i, reason: collision with root package name */
    private final boolean f39819i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f39820j;

    /* renamed from: k, reason: collision with root package name */
    private int f39821k;

    /* renamed from: l, reason: collision with root package name */
    private com.qq.e.comm.plugin.stat.b f39822l;

    /* renamed from: m, reason: collision with root package name */
    private com.qq.e.comm.plugin.stat.c f39823m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f39824n;

    /* renamed from: o, reason: collision with root package name */
    private int f39825o;

    public b(h hVar, int i3, String str, String str2, String str3, boolean z16, String str4) {
        this(hVar, i3, str, str2, str3, z16, str4, 0, false, true);
    }

    @Override // com.qq.e.comm.plugin.i.a, com.tencent.ams.fusion.service.resdownload.a
    public void a() {
    }

    @Override // com.qq.e.comm.plugin.i.a, com.tencent.ams.fusion.service.resdownload.a
    public void b() {
    }

    @Override // com.qq.e.comm.plugin.i.a
    public int f() {
        if (this.f39820j) {
            return 1310122;
        }
        return 1310107;
    }

    @Override // com.qq.e.comm.plugin.i.a
    public int g() {
        if (this.f39820j) {
            return 1310123;
        }
        return 1310108;
    }

    @Override // com.qq.e.comm.plugin.i.a
    public int h() {
        return 100142;
    }

    public b(h hVar, int i3, String str, String str2, String str3, boolean z16, String str4, int i16, boolean z17, boolean z18) {
        this.f39821k = 0;
        this.f39822l = new com.qq.e.comm.plugin.stat.b();
        this.f39823m = new com.qq.e.comm.plugin.stat.c();
        this.f39824n = false;
        this.f39825o = 0;
        this.f39812a = hVar;
        this.f39813b = i3;
        this.f39814d = str;
        this.f39815e = str2;
        this.f39816f = str3;
        this.f39818h = str4;
        this.f39817g = z16;
        this.f39821k = i16;
        this.f39820j = z17;
        this.f39819i = z18;
        this.f39822l.a(str);
        if (hVar != null) {
            try {
                this.f39823m.a(LayoutAttrDefine.CLICK_URI, hVar.c());
                this.f39823m.a(QzoneZipCacheHelper.DIR, hVar.a() == null ? null : hVar.a().getAbsolutePath());
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
    }

    @Override // com.qq.e.comm.plugin.i.a, com.tencent.ams.fusion.service.resdownload.a
    public void a(long j3, long j16, int i3) {
    }

    @Override // com.qq.e.comm.plugin.i.a
    public void b(boolean z16) {
        if (this.f39812a == null) {
            return;
        }
        super.b(z16);
        long b16 = e.a().f39853l.b(this.f39812a.b());
        a(b16, 0L, h(), this.f39812a.c(), null, z16);
        SplashLinkReporter.a(7000032, this.f39814d, this.f39816f, this.f39813b, b16, 2, this.f39818h);
    }

    @Override // com.qq.e.comm.plugin.i.a, com.tencent.ams.fusion.service.resdownload.a
    public void a(long j3, boolean z16) {
    }

    @Override // com.qq.e.comm.plugin.i.a
    public void a(boolean z16) {
        long length;
        if (this.f39812a == null) {
            return;
        }
        super.a(z16);
        long b16 = e.a().f39853l.b(this.f39812a.b());
        this.f39824n = true;
        b(b16, z16);
        if (TextUtils.isEmpty(this.f39815e)) {
            length = at.a(2, this.f39814d, this.f39812a.c()).length();
        } else {
            length = at.a(2, this.f39814d, this.f39815e).length();
        }
        long j3 = length;
        a(b16, j3, f(), this.f39812a.c(), null, z16);
        SplashLinkReporter.a(7000031, this.f39814d, this.f39816f, this.f39813b, b16, this.f39818h);
        if (SDKStatus.getSDKVersionCode() >= 370) {
            AdFlowReportAdapter.Params params = new AdFlowReportAdapter.Params();
            params.url = this.f39812a.c();
            params.flowAmount = (j3 / 1024) + "";
            params.entrancePath = this.f39812a.a() + this.f39812a.b();
            params.costTime = b16;
            params.netType = GDTADManager.getInstance().getDeviceStatus().getNetworkType().getConnValue();
            AdFlowReporter.getInstance().report(params);
        }
    }

    private void b(long j3, boolean z16) {
        if (b(this.f39815e, this.f39814d)) {
            a(j3, 0L, 7, null, null, z16);
        }
    }

    public static boolean b(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        File a16 = at.a(2, str2, str);
        if (!a16.exists()) {
            return false;
        }
        if (GDTADManager.getInstance().getSM().getInteger("splashVideoMd5Check", 0) == 1 && !str.equals(Md5Util.encode(a16))) {
            GDTLogger.i("\u89c6\u9891\u8d44\u6e90md5\u6821\u9a8c\u5931\u8d25" + a16.getAbsolutePath());
            try {
                a16.delete();
            } catch (Exception e16) {
                GDTLogger.e("\u5220\u9664\u6587\u4ef6\u9519\u8bef\uff0c" + e16.getMessage());
            }
            return true;
        }
        GDTLogger.i("\u89c6\u9891\u8d44\u6e90\u4e0b\u8f7d\u6210\u529f" + a16.getAbsolutePath());
        return false;
    }

    @Override // com.qq.e.comm.plugin.i.a, com.tencent.ams.fusion.service.resdownload.a
    public void c() {
    }

    public static void a(String str, String str2) {
        File a16 = at.a(str2, str);
        File a17 = at.a(3, str2, str);
        if (a16 != null) {
            a16.mkdir();
            try {
                StubVisitor.getInstance().unZipFolder(a17.getAbsolutePath(), a16.getAbsolutePath());
            } catch (Throwable th5) {
                if (a16.exists()) {
                    a16.delete();
                }
                th5.printStackTrace();
            }
        }
        a17.delete();
    }

    @Override // com.qq.e.comm.plugin.i.a
    public void a(com.qq.e.comm.plugin.i.d dVar, boolean z16) {
        if (this.f39812a == null) {
            return;
        }
        super.a(dVar, z16);
        GDTLogger.e("Preload res download", dVar);
        int i3 = this.f39813b;
        if (i3 == 1) {
            com.qq.e.comm.plugin.tangramsplash.report.c.a(11039, this.f39814d);
        } else if (i3 == 2) {
            com.qq.e.comm.plugin.tangramsplash.report.c.a(11049, this.f39814d);
        } else if (i3 == 3) {
            com.qq.e.comm.plugin.tangramsplash.report.c.a(11059, this.f39814d);
        }
        long b16 = e.a().f39853l.b(this.f39812a.b());
        a(b16, 0L, g(), this.f39812a.c(), dVar, z16);
        SplashLinkReporter.a(7000032, this.f39814d, this.f39816f, this.f39813b, b16, 2, this.f39818h);
        if (this.f39819i) {
            int integer = GDTADManager.getInstance().getSM().getInteger("splash_preload_material_download_retry", 1);
            GDTLogger.d("\u7d20\u6750\u4e0b\u8f7d\u5931\u8d25\u91cd\u8bd5\u6b21\u6570 " + integer);
            if (!f.a(GDTADManager.getInstance().getAppContext()) || integer <= 0 || this.f39824n || this.f39825o >= integer) {
                return;
            }
            e.a().f39853l.a(this.f39812a.b());
            com.qq.e.comm.plugin.i.f a16 = com.qq.e.comm.plugin.i.f.a(GDTADManager.getInstance().getAppContext());
            h hVar = this.f39812a;
            a16.a(hVar, hVar.c(), this);
            this.f39825o++;
            com.qq.e.comm.plugin.tangramsplash.report.c.a(1310106, this.f39814d, com.qq.e.comm.plugin.tangramsplash.report.c.a(com.qq.e.comm.plugin.tangramsplash.report.c.a(WebViewConstants.WV.ENABLE_WEBAIO_SWITCH, 10, Integer.MIN_VALUE, 1, this.f39813b == 1 ? 0 : 1, this.f39812a.c(), this.f39817g, 0, Integer.MIN_VALUE), this.f39816f));
        }
    }

    public void a(long j3, long j16, int i3, String str, com.qq.e.comm.plugin.i.d dVar, boolean z16) {
        if (com.qq.e.comm.plugin.j.c.a("splashAdLogoMargin", 1, 1)) {
            e.a().a(this.f39821k, this.f39814d, this.f39812a.h(), i3, j3, 1, this.f39813b, str, this.f39816f, this.f39817g, j16, dVar != null ? dVar.c() : Integer.MIN_VALUE, dVar != null ? dVar.b() : null, this.f39825o, z16);
        }
    }
}
