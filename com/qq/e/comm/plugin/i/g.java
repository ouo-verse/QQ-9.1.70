package com.qq.e.comm.plugin.i;

import android.os.Looper;
import android.text.TextUtils;
import com.qq.e.comm.managers.thread.GdtSDKThreadManager;
import com.qq.e.comm.util.FileUtil;
import com.qq.e.comm.util.GDTLogger;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: P */
/* loaded from: classes3.dex */
final class g {

    /* renamed from: a, reason: collision with root package name */
    private final List<a> f39542a = new CopyOnWriteArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public h f39553a;

        /* renamed from: b, reason: collision with root package name */
        public String f39554b;

        /* renamed from: c, reason: collision with root package name */
        public com.qq.e.comm.plugin.i.a f39555c;

        /* renamed from: d, reason: collision with root package name */
        public com.tencent.ams.fusion.service.resdownload.a f39556d;

        /* renamed from: e, reason: collision with root package name */
        public volatile boolean f39557e = false;

        /* renamed from: f, reason: collision with root package name */
        public volatile boolean f39558f = false;

        /* renamed from: g, reason: collision with root package name */
        public volatile boolean f39559g = false;

        public a(h hVar, String str, com.qq.e.comm.plugin.i.a aVar) {
            this.f39553a = hVar;
            this.f39554b = str;
            if (aVar instanceof k) {
                this.f39555c = aVar;
            }
            if (aVar instanceof com.tencent.ams.fusion.service.resdownload.a) {
                this.f39556d = aVar;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        for (a aVar : new ArrayList(this.f39542a)) {
            if (aVar != null && TextUtils.equals(str, aVar.f39554b) && aVar.f39557e) {
                this.f39542a.remove(aVar);
                GDTLogger.d("DownloadPendingTaskCenter_remove\u540e\u7f13\u5b58\u961f\u5217\u5927\u5c0f :" + this.f39542a.size());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(h hVar) {
        for (a aVar : this.f39542a) {
            if (a(hVar, aVar)) {
                com.qq.e.comm.plugin.i.a aVar2 = aVar.f39555c;
                if (aVar2 != null) {
                    aVar2.c();
                } else {
                    com.tencent.ams.fusion.service.resdownload.a aVar3 = aVar.f39556d;
                    if (aVar3 != null) {
                        aVar3.c();
                    }
                }
                aVar.f39557e = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(h hVar) {
        for (a aVar : this.f39542a) {
            if (a(hVar, aVar)) {
                com.qq.e.comm.plugin.i.a aVar2 = aVar.f39555c;
                if (aVar2 != null) {
                    aVar2.b(true);
                } else {
                    com.tencent.ams.fusion.service.resdownload.a aVar3 = aVar.f39556d;
                    if (aVar3 != null) {
                        aVar3.d();
                    }
                }
                aVar.f39557e = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        h hVar;
        for (a aVar : this.f39542a) {
            if (aVar != null && TextUtils.equals(aVar.f39554b, str) && (hVar = aVar.f39553a) != null && hVar.a() != null && !TextUtils.isEmpty(aVar.f39553a.c())) {
                if (new File(aVar.f39553a.a().getAbsolutePath() + File.separator + aVar.f39553a.b()).exists() && !aVar.f39558f) {
                    GDTLogger.d("DownloadPendingTaskCenter_\u4e0b\u8f7d\u5b8c\u6210\u4f46\u8fd8\u6ca1\u6709remove,\u56de\u6536\u524d,\u56de\u8c03onCompleted :" + aVar.hashCode());
                    com.qq.e.comm.plugin.i.a aVar2 = aVar.f39555c;
                    if (aVar2 != null) {
                        aVar2.a(true);
                    }
                    com.tencent.ams.fusion.service.resdownload.a aVar3 = aVar.f39556d;
                    if (aVar3 != null) {
                        aVar3.e();
                    }
                    aVar.f39557e = true;
                    aVar.f39558f = true;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(h hVar) {
        for (a aVar : this.f39542a) {
            if (a(hVar, aVar)) {
                b(hVar, aVar);
            }
        }
    }

    public void a(h hVar, String str, com.qq.e.comm.plugin.i.a aVar) {
        a aVar2 = new a(hVar, str, aVar);
        GDTLogger.d("DownloadPendingTaskCenter_\u8be5url\u6b63\u5728\u4e0b\u8f7d\u4e2d :" + hVar.c());
        GDTLogger.d("DownloadPendingTaskCenter_\u7f13\u5b58\u76ee\u5f55\u4e3a :" + hVar.a());
        this.f39542a.add(aVar2);
        GDTLogger.d("DownloadPendingTaskCenter_add\u540e\u7f13\u5b58\u961f\u5217\u5927\u5c0f :" + this.f39542a.size());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(h hVar, a aVar) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(hVar.a().getAbsolutePath());
        String str = File.separator;
        sb5.append(str);
        sb5.append(hVar.b());
        File file = new File(sb5.toString());
        if (file.exists()) {
            File file2 = new File(aVar.f39553a.a().getAbsolutePath() + str + hVar.b());
            try {
                try {
                    boolean copyTo = FileUtil.copyTo(new FileInputStream(file), file2);
                    GDTLogger.d("DownloadPendingTaskCenter_\u7f13\u5b58\u76ee\u5f55\u4e0d\u540c\uff0c\u62f7\u8d1d\u6587\u4ef6\u5230pendingTask\u6307\u5b9a\u76ee\u5f55 succ: " + copyTo);
                    GDTLogger.d("DownloadPendingTaskCenter_\u7f13\u5b58\u76ee\u5f55\u4e0d\u540c\uff0c\u62f7\u8d1d\u6587\u4ef6\u5230pendingTask\u6307\u5b9a\u76ee\u5f55 src: " + file.getAbsolutePath());
                    GDTLogger.d("DownloadPendingTaskCenter_\u7f13\u5b58\u76ee\u5f55\u4e0d\u540c\uff0c\u62f7\u8d1d\u6587\u4ef6\u5230pendingTask\u6307\u5b9a\u76ee\u5f55 target: " + file2.getAbsolutePath());
                    if (copyTo) {
                        com.qq.e.comm.plugin.i.a aVar2 = aVar.f39555c;
                        if (aVar2 != null) {
                            aVar2.a(true);
                        } else {
                            com.tencent.ams.fusion.service.resdownload.a aVar3 = aVar.f39556d;
                            if (aVar3 != null) {
                                aVar3.e();
                            }
                        }
                    } else {
                        d dVar = new d(108, 1009);
                        dVar.a("file_copy_error");
                        com.qq.e.comm.plugin.i.a aVar4 = aVar.f39555c;
                        if (aVar4 != null) {
                            aVar4.a(dVar, true);
                        } else {
                            com.tencent.ams.fusion.service.resdownload.a aVar5 = aVar.f39556d;
                            if (aVar5 != null) {
                                aVar5.a(dVar);
                            }
                        }
                    }
                } catch (FileNotFoundException e16) {
                    GDTLogger.e("copyFileAndCallOnCompleted error:", e16);
                    com.qq.e.comm.plugin.i.a aVar6 = aVar.f39555c;
                    if (aVar6 != null) {
                        aVar6.a(new d(108, 1010, e16), true);
                    } else {
                        com.tencent.ams.fusion.service.resdownload.a aVar7 = aVar.f39556d;
                        if (aVar7 != null) {
                            aVar7.a(new d(108, 1010, e16));
                        }
                    }
                }
            } finally {
                aVar.f39558f = true;
                aVar.f39559g = false;
                aVar.f39557e = true;
            }
        }
    }

    public void a(final String str) {
        GdtSDKThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.qq.e.comm.plugin.i.g.1
            @Override // java.lang.Runnable
            public void run() {
                g.this.b(str);
                g.this.c(str);
            }
        });
    }

    public void a(final int i3, final h hVar, final e eVar, final d dVar) {
        GdtSDKThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.qq.e.comm.plugin.i.g.2
            @Override // java.lang.Runnable
            public void run() {
                String str;
                if (!com.qq.e.comm.plugin.k.g.b(g.this.f39542a)) {
                    switch (i3) {
                        case 101:
                            g.this.a(hVar);
                            break;
                        case 102:
                            g.this.b(hVar);
                            break;
                        case 103:
                            g.this.a(hVar, eVar.d(), eVar.f());
                            break;
                        case 104:
                            g.this.a(hVar, eVar.e(), eVar.d(), eVar.c());
                            break;
                        case 105:
                            g.this.c(hVar);
                            break;
                        case 106:
                            g.this.d(hVar);
                            break;
                        case 107:
                            g.this.e(hVar);
                            break;
                        case 108:
                            g.this.a(hVar, dVar);
                            break;
                    }
                    g gVar = g.this;
                    h hVar2 = hVar;
                    if (hVar2 != null) {
                        str = hVar2.c();
                    } else {
                        str = "";
                    }
                    gVar.c(f.a(str));
                }
            }
        });
    }

    private boolean a(h hVar, a aVar) {
        return (aVar == null || hVar == null || hVar.c() == null || !TextUtils.equals(aVar.f39554b, String.valueOf(hVar.c().hashCode()))) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(h hVar) {
        for (a aVar : this.f39542a) {
            if (a(hVar, aVar)) {
                com.qq.e.comm.plugin.i.a aVar2 = aVar.f39555c;
                if (aVar2 != null) {
                    aVar2.b();
                } else {
                    com.tencent.ams.fusion.service.resdownload.a aVar3 = aVar.f39556d;
                    if (aVar3 != null) {
                        aVar3.b();
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(h hVar) {
        for (a aVar : this.f39542a) {
            if (a(hVar, aVar)) {
                com.qq.e.comm.plugin.i.a aVar2 = aVar.f39555c;
                if (aVar2 != null) {
                    aVar2.a();
                } else {
                    com.tencent.ams.fusion.service.resdownload.a aVar3 = aVar.f39556d;
                    if (aVar3 != null) {
                        aVar3.a();
                    }
                }
            }
        }
    }

    private void b(final h hVar, final a aVar) {
        if (aVar.f39558f) {
            GDTLogger.e("DownloadPendingTaskCenter_onCompletedInternal notified");
            return;
        }
        if (TextUtils.equals(aVar.f39553a.a().getAbsolutePath(), hVar.a().getAbsolutePath())) {
            GDTLogger.d("DownloadPendingTaskCenter_\u7f13\u5b58\u76ee\u5f55\u76f8\u540c\u76f4\u63a5\u56de\u8c03 onCompleted " + hVar.b() + " , task :" + aVar.hashCode());
            com.qq.e.comm.plugin.i.a aVar2 = aVar.f39555c;
            if (aVar2 != null) {
                aVar2.a(true);
            } else {
                com.tencent.ams.fusion.service.resdownload.a aVar3 = aVar.f39556d;
                if (aVar3 != null) {
                    aVar3.e();
                }
            }
            aVar.f39558f = true;
            aVar.f39557e = true;
            return;
        }
        if (aVar.f39559g) {
            GDTLogger.e("DownloadPendingTaskCenter_onCompletedInternal fileCopying: " + aVar.f39559g);
            return;
        }
        aVar.f39559g = true;
        if (Looper.myLooper() == Looper.getMainLooper()) {
            GdtSDKThreadManager.getInstance().runOnThread(3, new Runnable() { // from class: com.qq.e.comm.plugin.i.g.3
                @Override // java.lang.Runnable
                public void run() {
                    g.this.c(hVar, aVar);
                    g.this.c(aVar.f39554b);
                }
            });
        } else {
            c(hVar, aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(h hVar, long j3, boolean z16) {
        for (a aVar : this.f39542a) {
            if (a(hVar, aVar)) {
                com.qq.e.comm.plugin.i.a aVar2 = aVar.f39555c;
                if (aVar2 != null) {
                    aVar2.a(j3, z16);
                } else {
                    com.tencent.ams.fusion.service.resdownload.a aVar3 = aVar.f39556d;
                    if (aVar3 != null) {
                        aVar3.a(j3, z16);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(h hVar, long j3, long j16, int i3) {
        for (a aVar : this.f39542a) {
            if (a(hVar, aVar)) {
                com.qq.e.comm.plugin.i.a aVar2 = aVar.f39555c;
                if (aVar2 != null) {
                    aVar2.a(j3, j16, i3);
                } else {
                    com.tencent.ams.fusion.service.resdownload.a aVar3 = aVar.f39556d;
                    if (aVar3 != null) {
                        aVar3.a(j3, j16, i3);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(h hVar, d dVar) {
        for (a aVar : this.f39542a) {
            if (a(hVar, aVar)) {
                com.qq.e.comm.plugin.i.a aVar2 = aVar.f39555c;
                if (aVar2 != null) {
                    aVar2.a(dVar, true);
                } else {
                    com.tencent.ams.fusion.service.resdownload.a aVar3 = aVar.f39556d;
                    if (aVar3 != null) {
                        aVar3.a(dVar);
                    }
                }
                aVar.f39557e = true;
            }
        }
    }
}
