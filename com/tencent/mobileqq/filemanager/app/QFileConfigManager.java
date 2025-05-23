package com.tencent.mobileqq.filemanager.app;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.business.qfile.QFileFileReaderConfigBean;
import com.tencent.mobileqq.config.business.qfile.QfileFileAssistantTipsConfigBean;
import com.tencent.mobileqq.config.business.qfile.m;
import com.tencent.mobileqq.config.business.qfile.n;
import com.tencent.mobileqq.config.business.qfile.o;
import com.tencent.mobileqq.config.business.qfile.p;
import com.tencent.mobileqq.config.business.qfile.q;
import com.tencent.mobileqq.config.business.qfile.r;
import com.tencent.mobileqq.filebrowser.IFileBrowserService;
import com.tencent.mobileqq.filemanager.api.IQFileConfigManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes12.dex */
public class QFileConfigManager implements com.tencent.mobileqq.config.business.qfile.a {

    /* renamed from: a, reason: collision with root package name */
    private AppRuntime f207045a;

    /* renamed from: b, reason: collision with root package name */
    private HashMap<String, com.tencent.mobileqq.filemanager.data.c> f207046b;

    /* renamed from: p, reason: collision with root package name */
    private com.tencent.mobileqq.config.business.qfile.f f207060p;

    /* renamed from: q, reason: collision with root package name */
    private com.tencent.mobileqq.config.business.qfile.e f207061q;

    /* renamed from: r, reason: collision with root package name */
    private com.tencent.mobileqq.config.business.qfile.h f207062r;

    /* renamed from: s, reason: collision with root package name */
    private com.tencent.mobileqq.config.business.qfile.g f207063s;

    /* renamed from: t, reason: collision with root package name */
    private qb1.c f207064t;

    /* renamed from: u, reason: collision with root package name */
    private com.tencent.mobileqq.config.business.qfile.j f207065u;

    /* renamed from: v, reason: collision with root package name */
    private com.tencent.mobileqq.config.business.qfile.k f207066v;

    /* renamed from: w, reason: collision with root package name */
    private QFileFileReaderConfigBean f207067w;

    /* renamed from: x, reason: collision with root package name */
    private m f207068x;

    /* renamed from: c, reason: collision with root package name */
    private boolean f207047c = false;

    /* renamed from: d, reason: collision with root package name */
    private boolean f207048d = false;

    /* renamed from: e, reason: collision with root package name */
    private boolean f207049e = false;

    /* renamed from: f, reason: collision with root package name */
    private boolean f207050f = false;

    /* renamed from: g, reason: collision with root package name */
    private boolean f207051g = false;

    /* renamed from: h, reason: collision with root package name */
    private boolean f207052h = false;

    /* renamed from: i, reason: collision with root package name */
    private boolean f207053i = false;

    /* renamed from: j, reason: collision with root package name */
    private boolean f207054j = false;

    /* renamed from: k, reason: collision with root package name */
    private boolean f207055k = false;

    /* renamed from: l, reason: collision with root package name */
    private boolean f207056l = false;

    /* renamed from: m, reason: collision with root package name */
    private boolean f207057m = false;

    /* renamed from: n, reason: collision with root package name */
    private int f207058n = 0;

    /* renamed from: o, reason: collision with root package name */
    private boolean f207059o = false;

    /* renamed from: y, reason: collision with root package name */
    private String f207069y = "";

    /* renamed from: z, reason: collision with root package name */
    private boolean f207070z = false;
    private int A = 65799;
    private boolean B = false;
    private String C = "101.91.91.150";
    private boolean D = false;

    public QFileConfigManager(AppRuntime appRuntime) {
        this.f207045a = appRuntime;
        P();
    }

    public static synchronized QFileConfigManager J(AppRuntime appRuntime) {
        QFileConfigManager qFileConfigManager;
        synchronized (QFileConfigManager.class) {
            if (appRuntime != null) {
                qFileConfigManager = (QFileConfigManager) ((IQFileConfigManager) appRuntime.getRuntimeService(IQFileConfigManager.class, "all")).getQFileConfigManager();
            } else {
                throw new NullPointerException("app is null!");
            }
        }
        return qFileConfigManager;
    }

    private void P() {
        S();
        X();
        W();
        T();
        i0();
        h0();
        k0();
        j0();
        Y();
        Z();
        V();
        Q();
        R();
    }

    private void Q() {
        g0(com.tencent.mobileqq.filemanager.util.h.c(this.f207045a, "file_dataline_key", "{}"));
        com.tencent.mobileqq.filemanager.fileassistant.util.g.a(this.f207068x.f202754d);
    }

    private void S() {
        if (this.f207046b == null) {
            this.f207046b = new HashMap<>();
        }
        String c16 = com.tencent.mobileqq.filemanager.util.h.c(this.f207045a, "qfile_file_auto_download", "{}");
        QLog.i("QFileConfigManager", 1, "initFileDownloadConfig: load download config [" + c16 + "]");
        m0(c16);
    }

    private void T() {
        this.f207053i = com.tencent.mobileqq.filemanager.util.h.a(this.f207045a, "ipv6_all_switch", false);
        this.f207054j = com.tencent.mobileqq.filemanager.util.h.a(this.f207045a, "ipv6_c2c_switch", false);
        this.f207055k = com.tencent.mobileqq.filemanager.util.h.a(this.f207045a, "ipv6_group_switch", false);
        this.f207056l = com.tencent.mobileqq.filemanager.util.h.a(this.f207045a, "ipv6_disc_switch", false);
        this.f207057m = com.tencent.mobileqq.filemanager.util.h.a(this.f207045a, "ipv6_dataline_switch", false);
        this.f207058n = com.tencent.mobileqq.filemanager.util.h.b(this.f207045a, "ipv6_strategy", 0);
        QLog.i("QFileConfigManager", 1, "initFileIPv6Config: load config. enableFileIPv6[" + this.f207053i + "] enableC2CIPv6[" + this.f207054j + "] enableGroupIPv6[" + this.f207055k + "] enableDiscIPv6[" + this.f207056l + "] enableDatalineIPv6[" + this.f207057m + "] strategy[" + this.f207058n + "]");
    }

    private void U() {
        if (this.f207067w != null) {
            return;
        }
        n0(com.tencent.mobileqq.filemanager.util.h.c(this.f207045a, "file_reader_key", "{}"));
    }

    private void V() {
        this.f207059o = com.tencent.mobileqq.filemanager.util.h.a(this.f207045a, "apkcheck_enable_switch", false);
        QLog.i("QFileConfigManager", 1, "initMMApkFileCheckConfig: load apkcheckconfig. enable[" + this.f207059o + "]");
    }

    private void W() {
        this.f207050f = com.tencent.mobileqq.filemanager.util.h.a(this.f207045a, "enable_file_media_platform", false);
        QLog.i("QFileConfigManager", 1, "initMediaPlatformConfig: load common config. enableFileMediaPlatform[" + this.f207050f + "]");
    }

    private void X() {
        this.f207047c = com.tencent.mobileqq.filemanager.util.h.a(this.f207045a, "troop_video_preivew", false);
        this.f207048d = com.tencent.mobileqq.filemanager.util.h.a(this.f207045a, "troop_video_preivew_for_svip", false);
        this.f207049e = com.tencent.mobileqq.filemanager.util.h.a(this.f207045a, "troop_video_preivew_for_yearsvip", false);
        QLog.i("QFileConfigManager", 1, "initTroopFileVideoPreviewConfig: load common config. enableTroopVidePreview[" + this.f207047c + "] enableTroopVidePreviewForSVIP[" + this.f207048d + "] enableTroopVidePreviewForYearSVIP[" + this.f207049e + "]");
    }

    private void Y() {
        o0(com.tencent.mobileqq.filemanager.util.h.c(this.f207045a, "yyb_promote_action_key", "{}"));
    }

    private void Z() {
        p0(com.tencent.mobileqq.filemanager.util.h.c(this.f207045a, "yyb_promote_dialog_key", "{}"));
    }

    private void g0(String str) {
        if (TextUtils.isEmpty(str)) {
            QLog.i("QFileConfigManager", 1, "loadDatalineConfig: load dataline config. " + str);
        }
        this.f207068x = (m) rb1.b.a(str, m.class);
    }

    private void h0() {
        String string = this.f207045a.getApplicationContext().getSharedPreferences("c2cfile_excitingdownload_" + this.f207045a.getCurrentUin(), 0).getString("qfile_c2cfile_excitingdownload", "{}");
        QLog.i("QFileConfigManager", 1, "load Exciting-C2C-Download Config [" + string + "]");
        o oVar = new o();
        oVar.onParse(string);
        this.f207061q = oVar;
    }

    private void i0() {
        String string = this.f207045a.getApplicationContext().getSharedPreferences("c2cfile_excitingupload_" + this.f207045a.getCurrentUin(), 0).getString("qfile_c2cfile_excitingupload", "{}");
        QLog.i("QFileConfigManager", 1, "load Exciting-C2C-Upload Config [" + string + "]");
        p pVar = new p();
        pVar.onParse(string);
        this.f207060p = pVar;
    }

    private void j0() {
        q0("groupfile_excitingdownload_", "qfile_groupfile_excitingdownload");
        String c16 = com.tencent.mobileqq.filemanager.util.h.c(this.f207045a, "qfile_groupfile_excitingdownload", "{}");
        QLog.i("QFileConfigManager", 1, "load Exciting-Group-Download Config [" + c16 + "]");
        q qVar = new q();
        qVar.onParse(c16);
        this.f207063s = qVar;
    }

    private void k0() {
        q0("groupfile_excitingupload_", "qfile_groupfile_excitingupload");
        String c16 = com.tencent.mobileqq.filemanager.util.h.c(this.f207045a, "qfile_groupfile_excitingupload", "{}");
        QLog.i("QFileConfigManager", 1, "load Exciting-Group-Upload Config [" + c16 + "]");
        r rVar = new r();
        rVar.onParse(c16);
        this.f207062r = rVar;
    }

    private void l0() {
        if (this.f207064t != null) {
            return;
        }
        String string = this.f207045a.getApplicationContext().getSharedPreferences("qfile_file_assistant_tips" + this.f207045a.getCurrentUin(), 0).getString("qfile_file_assistant_tips", "{}");
        QLog.i("QFileConfigManager", 1, "load QFILE_CONFIG_FILE_ASSISTANT_TIPS Config [" + string + "]");
        QfileFileAssistantTipsConfigBean qfileFileAssistantTipsConfigBean = new QfileFileAssistantTipsConfigBean();
        qfileFileAssistantTipsConfigBean.onParse(string);
        this.f207064t = qfileFileAssistantTipsConfigBean;
    }

    private void m0(String str) {
        n nVar = (n) rb1.b.a(str, n.class);
        if (nVar != null) {
            q();
            this.f207046b.clear();
            this.f207046b.putAll(nVar.f202760d);
        }
        if (TextUtils.isEmpty(str)) {
            QLog.i("QFileConfigManager", 1, "loadFileDownloadConfig: load download config. " + str);
        }
    }

    private void n0(String str) {
        if (TextUtils.isEmpty(str)) {
            QLog.i("QFileConfigManager", 1, "loadFileReaderConfig: load download config. " + str);
        }
        this.f207067w = (QFileFileReaderConfigBean) rb1.b.a(str, QFileFileReaderConfigBean.class);
        ((IFileBrowserService) QRoute.api(IFileBrowserService.class)).setCheckShowTbsReaderBar(this.f207067w.isShowReaderBar);
    }

    private void o0(String str) {
        if (TextUtils.isEmpty(str)) {
            QLog.i("QFileConfigManager", 1, "loadYYBPromoteActionConfig: load download config. " + str);
        }
        this.f207065u = (com.tencent.mobileqq.config.business.qfile.j) rb1.b.a(str, com.tencent.mobileqq.config.business.qfile.j.class);
    }

    private void p0(String str) {
        if (TextUtils.isEmpty(str)) {
            QLog.i("QFileConfigManager", 1, "loadYYBPromoteDialogConfig: load download config. " + str);
        }
        this.f207066v = (com.tencent.mobileqq.config.business.qfile.k) rb1.b.a(str, com.tencent.mobileqq.config.business.qfile.k.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        if (this.f207046b == null) {
            this.f207046b = new HashMap<>();
        }
    }

    private void q0(String str, String str2) {
        if (!com.tencent.mobileqq.filemanager.util.h.a(this.f207045a, str, false)) {
            String string = this.f207045a.getApplicationContext().getSharedPreferences(str + this.f207045a.getCurrentUin(), 0).getString(str2, "");
            if (!TextUtils.isEmpty(string)) {
                com.tencent.mobileqq.filemanager.util.h.h(this.f207045a, str2, string);
            }
            com.tencent.mobileqq.filemanager.util.h.f(this.f207045a, str, true);
            QLog.i("QFileConfigManager", 1, "migrateLocalConfigDone, spKey:" + str + ", configKey:" + str2);
        }
    }

    public com.tencent.mobileqq.config.business.qfile.g A() {
        return this.f207063s;
    }

    public void A0(qb1.c cVar) {
        this.f207064t = cVar;
    }

    public com.tencent.mobileqq.config.business.qfile.h B() {
        return this.f207062r;
    }

    public void B0(final Bundle bundle) {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.filemanager.app.QFileConfigManager.2
            @Override // java.lang.Runnable
            public void run() {
                if (bundle.containsKey("troop_video_preivew") && bundle.containsKey("troop_video_preivew_for_svip") && bundle.containsKey("troop_video_preivew_for_yearsvip") && bundle.containsKey("enable_file_media_platform")) {
                    QFileConfigManager.this.f207047c = bundle.getBoolean("troop_video_preivew", false);
                    QFileConfigManager.this.f207048d = bundle.getBoolean("troop_video_preivew_for_svip", false);
                    QFileConfigManager.this.f207049e = bundle.getBoolean("troop_video_preivew_for_yearsvip", false);
                    QFileConfigManager.this.f207050f = bundle.getBoolean("enable_file_media_platform", false);
                    QLog.i("QFileConfigManager", 1, "setFileCommonConfig: set common config. enableTroopVidePreview[" + QFileConfigManager.this.f207047c + "] enableTroopVidePreviewForSVIP[" + QFileConfigManager.this.f207048d + "] enableTroopVidePreviewForYearSVIP[" + QFileConfigManager.this.f207049e + "] UseMediaPlatform enabled[" + QFileConfigManager.this.f207050f + "]");
                }
            }
        });
    }

    public qb1.c C() {
        l0();
        return this.f207064t;
    }

    public void C0(final HashMap<String, com.tencent.mobileqq.filemanager.data.c> hashMap) {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.filemanager.app.QFileConfigManager.1
            @Override // java.lang.Runnable
            public void run() {
                if (hashMap != null) {
                    QFileConfigManager.this.q();
                    QFileConfigManager.this.f207046b.clear();
                    QFileConfigManager.this.f207046b.putAll(hashMap);
                    QLog.i("QFileConfigManager", 1, "setFileDownloadConfig: set download config. ");
                }
            }
        });
    }

    public com.tencent.mobileqq.filemanager.data.c D(String str) {
        if (!TextUtils.isEmpty(str)) {
            str = str.toLowerCase();
        }
        q();
        com.tencent.mobileqq.filemanager.data.c cVar = this.f207046b.get(str);
        if (cVar == null) {
            cVar = this.f207046b.get("*");
        }
        if (cVar == null) {
            m0("{}");
            return this.f207046b.get("*");
        }
        return cVar;
    }

    public void D0(final Bundle bundle) {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.filemanager.app.QFileConfigManager.3
            @Override // java.lang.Runnable
            public void run() {
                if (bundle == null) {
                    return;
                }
                QLog.i("QFileConfigManager", 1, "setFileIPv6Config[" + bundle.toString() + "]");
                if (bundle.containsKey("ipv6_all_switch")) {
                    QFileConfigManager.this.f207053i = bundle.getBoolean("ipv6_all_switch", false);
                }
                if (bundle.containsKey("ipv6_c2c_switch")) {
                    QFileConfigManager.this.f207054j = bundle.getBoolean("ipv6_c2c_switch", false);
                }
                if (bundle.containsKey("ipv6_group_switch")) {
                    QFileConfigManager.this.f207055k = bundle.getBoolean("ipv6_group_switch", false);
                }
                if (bundle.containsKey("ipv6_disc_switch")) {
                    QFileConfigManager.this.f207056l = bundle.getBoolean("ipv6_disc_switch", false);
                }
                if (bundle.containsKey("ipv6_dataline_switch")) {
                    QFileConfigManager.this.f207057m = bundle.getBoolean("ipv6_dataline_switch", false);
                }
                if (bundle.containsKey("ipv6_strategy")) {
                    QFileConfigManager.this.f207058n = bundle.getInt("ipv6_strategy", 0);
                }
            }
        });
    }

    public int E() {
        return this.f207058n;
    }

    public void E0() {
        U();
        ((IFileBrowserService) QRoute.api(IFileBrowserService.class)).setCheckShowTbsReaderBar(this.f207067w.isShowReaderBar);
    }

    public boolean F() {
        return this.f207053i;
    }

    public void F0(QFileFileReaderConfigBean qFileFileReaderConfigBean) {
        if (qFileFileReaderConfigBean != null) {
            this.f207067w = qFileFileReaderConfigBean;
            ((IFileBrowserService) QRoute.api(IFileBrowserService.class)).setCheckShowTbsReaderBar(this.f207067w.isShowReaderBar);
        }
    }

    public QFileFileReaderConfigBean G() {
        U();
        return this.f207067w;
    }

    public void G0(String str) {
        this.C = str;
    }

    public boolean H() {
        return this.f207055k;
    }

    public void H0(boolean z16) {
        this.B = z16;
    }

    public String I() {
        return this.C;
    }

    public void I0(boolean z16) {
        this.f207059o = z16;
        QLog.i("QFileConfigManager", 1, "set apkcheckConfig enable:" + z16);
    }

    public void J0(boolean z16) {
        this.f207052h = z16;
    }

    public boolean K() {
        return this.f207048d;
    }

    public void K0(boolean z16) {
        this.f207051g = z16;
    }

    public boolean L() {
        return this.f207047c;
    }

    public void L0(boolean z16) {
        this.f207070z = z16;
    }

    public boolean M() {
        return this.f207049e;
    }

    public void M0(com.tencent.mobileqq.config.business.qfile.j jVar) {
        if (jVar != null) {
            this.f207065u = jVar;
        }
    }

    public com.tencent.mobileqq.config.business.qfile.j N() {
        return this.f207065u;
    }

    public void N0(com.tencent.mobileqq.config.business.qfile.k kVar) {
        if (kVar != null) {
            this.f207066v = kVar;
        }
    }

    public com.tencent.mobileqq.config.business.qfile.k O() {
        return this.f207066v;
    }

    public void R() {
        if (TextUtils.isEmpty(this.f207069y)) {
            this.f207069y = AppConstants.DATALINE_NEW_VERSION_UIN;
        }
    }

    public boolean a0() {
        return this.B;
    }

    public boolean b0() {
        return this.f207059o;
    }

    public boolean c0() {
        if (this.f207051g) {
            return this.f207052h;
        }
        return this.f207050f;
    }

    public boolean d0() {
        return this.f207052h;
    }

    public boolean e0() {
        return this.f207051g;
    }

    public boolean f0() {
        return this.f207070z;
    }

    public boolean r() {
        return this.f207054j;
    }

    public m s() {
        return this.f207068x;
    }

    public void s0(m mVar) {
        if (mVar != null) {
            this.f207068x = mVar;
        }
    }

    public boolean t() {
        return this.f207057m;
    }

    public void t0(int i3) {
        this.A = i3;
    }

    public int u() {
        return this.A;
    }

    public void u0(String str) {
        this.f207069y = str;
    }

    public String v() {
        return this.f207069y;
    }

    public void v0(boolean z16) {
        this.D = z16;
    }

    public boolean w() {
        return this.D;
    }

    public void w0(com.tencent.mobileqq.config.business.qfile.e eVar) {
        this.f207061q = eVar;
    }

    public boolean x() {
        return this.f207056l;
    }

    public void x0(com.tencent.mobileqq.config.business.qfile.f fVar) {
        this.f207060p = fVar;
    }

    public com.tencent.mobileqq.config.business.qfile.e y() {
        return this.f207061q;
    }

    public void y0(com.tencent.mobileqq.config.business.qfile.g gVar) {
        this.f207063s = gVar;
    }

    public com.tencent.mobileqq.config.business.qfile.f z() {
        return this.f207060p;
    }

    public void z0(com.tencent.mobileqq.config.business.qfile.h hVar) {
        this.f207062r = hVar;
    }

    public void r0() {
    }
}
