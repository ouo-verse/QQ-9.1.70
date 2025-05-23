package com.tencent.mobileqq.ar.arengine;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;
import com.tencent.mobileqq.ar.arengine.ag;
import com.tencent.mobileqq.ar.arengine.ah;
import com.tencent.mobileqq.ar.model.ARRelationShip;
import com.tencent.mobileqq.ar.model.ArFeatureInfo;
import com.tencent.mobileqq.ar.model.ArModelResource;
import com.tencent.mobileqq.ar.model.ArVideoResourceInfo;
import com.tencent.mobileqq.ar.model.ArWebInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes11.dex */
public class ad {

    /* renamed from: u, reason: collision with root package name */
    private static String f198063u = "";

    /* renamed from: a, reason: collision with root package name */
    private ArrayList<ArCloudConfigInfo> f198064a;

    /* renamed from: b, reason: collision with root package name */
    private ah f198065b;

    /* renamed from: d, reason: collision with root package name */
    AppInterface f198067d;

    /* renamed from: e, reason: collision with root package name */
    long f198068e;

    /* renamed from: f, reason: collision with root package name */
    long f198069f;

    /* renamed from: h, reason: collision with root package name */
    long f198071h;

    /* renamed from: i, reason: collision with root package name */
    long f198072i;

    /* renamed from: j, reason: collision with root package name */
    long f198073j;

    /* renamed from: k, reason: collision with root package name */
    int f198074k;

    /* renamed from: l, reason: collision with root package name */
    long f198075l;

    /* renamed from: m, reason: collision with root package name */
    long f198076m;

    /* renamed from: n, reason: collision with root package name */
    long f198077n;

    /* renamed from: o, reason: collision with root package name */
    int f198078o;

    /* renamed from: p, reason: collision with root package name */
    long f198079p;

    /* renamed from: q, reason: collision with root package name */
    int f198080q;

    /* renamed from: r, reason: collision with root package name */
    long f198081r;

    /* renamed from: s, reason: collision with root package name */
    int f198082s;

    /* renamed from: t, reason: collision with root package name */
    private Context f198083t;

    /* renamed from: c, reason: collision with root package name */
    Object f198066c = new Object();

    /* renamed from: g, reason: collision with root package name */
    String f198070g = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class a implements ah.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ d f198084a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ArCloudConfigInfo f198085b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.ar.arengine.d f198086c;

        a(d dVar, ArCloudConfigInfo arCloudConfigInfo, com.tencent.mobileqq.ar.arengine.d dVar2) {
            this.f198084a = dVar;
            this.f198085b = arCloudConfigInfo;
            this.f198086c = dVar2;
        }

        @Override // com.tencent.mobileqq.ar.arengine.ah.c
        public void a(int i3) {
            d dVar = this.f198084a;
            if (dVar != null) {
                dVar.k(i3);
            }
        }

        @Override // com.tencent.mobileqq.ar.arengine.ah.c
        public void b(int i3, boolean z16) {
            d dVar = this.f198084a;
            if (dVar != null) {
                dVar.g(z16, i3, this.f198085b);
            }
            if (i3 == 2) {
                ad adVar = ad.this;
                long currentTimeMillis = System.currentTimeMillis();
                ad adVar2 = ad.this;
                adVar.f198072i = currentTimeMillis - adVar2.f198068e;
                adVar2.f198074k = !z16 ? 1 : 0;
                return;
            }
            if (i3 == 3) {
                ad adVar3 = ad.this;
                long currentTimeMillis2 = System.currentTimeMillis();
                ad adVar4 = ad.this;
                adVar3.f198076m = currentTimeMillis2 - adVar4.f198068e;
                adVar4.f198078o = !z16 ? 1 : 0;
            }
        }

        @Override // com.tencent.mobileqq.ar.arengine.ah.c
        public void c() {
            d dVar = this.f198084a;
            if (dVar != null) {
                dVar.l();
            }
        }

        @Override // com.tencent.mobileqq.ar.arengine.ah.c
        public void d(boolean z16) {
            d dVar = this.f198084a;
            if (dVar != null) {
                dVar.h(z16, this.f198085b);
            }
            ad.this.f198069f = System.currentTimeMillis();
            ad adVar = ad.this;
            adVar.f198082s = !z16 ? 1 : 0;
            adVar.d();
            if (z16) {
                ArCloudConfigInfo arCloudConfigInfo = this.f198085b;
                if (arCloudConfigInfo.f197700f != 1) {
                    ad.this.r(arCloudConfigInfo.E.f198409d, this.f198086c);
                }
                ad.this.c(this.f198085b);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public interface d {
        void A(boolean z16, ArCloudConfigInfo arCloudConfigInfo);

        void g(boolean z16, int i3, ArCloudConfigInfo arCloudConfigInfo);

        void h(boolean z16, ArCloudConfigInfo arCloudConfigInfo);

        void j(int i3);

        void k(int i3);

        void l();

        void m();

        void q(boolean z16, ArCloudConfigInfo arCloudConfigInfo);

        void u(int i3);

        void v();
    }

    public ad(AppInterface appInterface, Context context) {
        this.f198064a = null;
        this.f198083t = null;
        f198063u = af.j();
        this.f198064a = new ArrayList<>();
        this.f198065b = new ah(appInterface);
        this.f198067d = appInterface;
        this.f198083t = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ArCloudConfigInfo arCloudConfigInfo) {
        if (arCloudConfigInfo != null) {
            for (int i3 = 0; i3 < this.f198064a.size(); i3++) {
                if (arCloudConfigInfo.F != null && arCloudConfigInfo.E.f198409d.equals(this.f198064a.get(i3).E.f198409d)) {
                    return;
                }
            }
            this.f198064a.add(arCloudConfigInfo);
        }
    }

    private void f(boolean z16) {
        QLog.i("AREngine_ARMarkerResourceManager", 1, "checkAndDeleteExpiredResource  ");
        long currentTimeMillis = System.currentTimeMillis();
        File[] listFiles = new File(o()).listFiles();
        if (listFiles == null) {
            return;
        }
        for (File file : listFiles) {
            if ((((int) ((currentTimeMillis - file.lastModified()) / 86400000)) > 7 || z16) && file.getName().endsWith("_config.dat")) {
                ArCloudConfigInfo a16 = ai.a(o(), file.getName());
                if (a16 == null) {
                    return;
                }
                s(a16);
                file.delete();
                if (a16.E != null) {
                    File file2 = new File(a16.E.f198412h);
                    if (file2.exists()) {
                        file2.delete();
                    }
                    if (a16.F != null) {
                        File file3 = new File(a16.F.D);
                        if (file3.exists()) {
                            file3.delete();
                        }
                        File file4 = new File(a16.E.f198413i + a16.F.f198421e + File.separator);
                        if (file4.exists() && file4.isDirectory()) {
                            File[] listFiles2 = file4.listFiles();
                            if (listFiles2 != null) {
                                for (File file5 : listFiles2) {
                                    file5.delete();
                                }
                            }
                            file4.delete();
                        }
                    }
                    ArrayList<ArVideoResourceInfo> arrayList = a16.D;
                    if (arrayList != null && arrayList.size() > 0) {
                        Iterator<ArVideoResourceInfo> it = a16.D.iterator();
                        while (it.hasNext()) {
                            File file6 = new File(a16.E.f198413i + it.next().f198430i + "_model.zip");
                            if (file6.exists()) {
                                file6.delete();
                            }
                        }
                    }
                }
            }
        }
    }

    private void i(com.tencent.mobileqq.ar.arengine.d dVar, d dVar2, ArCloudConfigInfo arCloudConfigInfo) {
        File file;
        String str;
        String str2;
        ARRelationShip aRRelationShip;
        if (arCloudConfigInfo == null) {
            return;
        }
        ArrayList<ag.c> arrayList = new ArrayList<>();
        QLog.i("AREngine_ARMarkerResourceManager", 1, "downLoadMarkerModelResources");
        File file2 = new File(arCloudConfigInfo.E.f198412h);
        g();
        this.f198068e = System.currentTimeMillis();
        this.f198070g = arCloudConfigInfo.E.f198409d;
        if (!file2.exists() && !arCloudConfigInfo.e()) {
            ag.c cVar = new ag.c();
            cVar.f198121a = 2;
            ArFeatureInfo arFeatureInfo = arCloudConfigInfo.E;
            cVar.f198122b = arFeatureInfo.f198411f;
            cVar.f198123c = arFeatureInfo.f198409d;
            long j3 = arFeatureInfo.f198410e;
            long j16 = j3 / 8192;
            this.f198071h = j16;
            cVar.f198127g = j3;
            cVar.f198124d = arFeatureInfo.f198412h;
            cVar.f198125e = false;
            this.f198080q = arCloudConfigInfo.f197702i;
            this.f198081r += j16;
            arrayList.add(cVar);
        }
        ArWebInfo arWebInfo = arCloudConfigInfo.H;
        if (arWebInfo != null && arWebInfo.a()) {
            File file3 = new File(f198063u + "pddata/app/offline/html5/" + arCloudConfigInfo.H.f198435h + File.separator);
            StringBuilder sb5 = new StringBuilder();
            sb5.append("offlie  ");
            sb5.append(com.tencent.biz.common.offline.c.c(arCloudConfigInfo.H.f198435h));
            QLog.i("AREngine_ARMarkerResourceManager", 1, sb5.toString());
            if (!file3.exists() && !TextUtils.isEmpty(arCloudConfigInfo.H.f198435h)) {
                ag.c cVar2 = new ag.c();
                cVar2.f198121a = 4;
                cVar2.f198122b = String.valueOf(arCloudConfigInfo.H.f198435h);
                arrayList.add(cVar2);
            }
        }
        com.tencent.mobileqq.ar.ARPromotion.c cVar3 = arCloudConfigInfo.M;
        if (cVar3 != null && !TextUtils.isEmpty(cVar3.f196875i)) {
            if (!new File(arCloudConfigInfo.M.f196875i).exists()) {
                ag.c cVar4 = new ag.c();
                cVar4.f198121a = 7;
                com.tencent.mobileqq.ar.ARPromotion.c cVar5 = arCloudConfigInfo.M;
                cVar4.f198122b = cVar5.f196872f;
                cVar4.f198123c = cVar5.f196874h;
                cVar4.f198127g = cVar5.f196873g;
                cVar4.f198124d = cVar5.f196875i;
                cVar4.f198125e = true;
                arrayList.add(cVar4);
            } else {
                try {
                    com.tencent.mobileqq.ar.ARPromotion.c cVar6 = arCloudConfigInfo.M;
                    ai.c(cVar6.f196875i, af.g(cVar6.f196874h));
                } catch (Exception unused) {
                }
            }
        }
        if (arCloudConfigInfo.I == 1 && (aRRelationShip = arCloudConfigInfo.J) != null && !TextUtils.isEmpty(aRRelationShip.f198396h) && !new File(arCloudConfigInfo.J.f198396h).exists()) {
            ag.c cVar7 = new ag.c();
            cVar7.f198121a = 6;
            ARRelationShip aRRelationShip2 = arCloudConfigInfo.J;
            cVar7.f198122b = aRRelationShip2.f198394e;
            cVar7.f198123c = aRRelationShip2.f198395f;
            cVar7.f198127g = aRRelationShip2.D;
            cVar7.f198124d = aRRelationShip2.f198396h;
            cVar7.f198125e = true;
            arrayList.add(cVar7);
        }
        int i3 = arCloudConfigInfo.f197702i;
        if (i3 != 0 && i3 != 100 && i3 != 7 && i3 != 8) {
            ArrayList<ArVideoResourceInfo> arrayList2 = arCloudConfigInfo.D;
            if (arrayList2 != null && arrayList2.size() > 0) {
                ArrayList arrayList3 = new ArrayList();
                Iterator<ArVideoResourceInfo> it = arCloudConfigInfo.D.iterator();
                while (it.hasNext()) {
                    ArVideoResourceInfo next = it.next();
                    if (next.D != 4) {
                        File file4 = new File(next.F);
                        if (file4.exists()) {
                            str2 = com.tencent.mobileqq.portal.o.e(file4.getAbsolutePath());
                        } else {
                            str2 = null;
                        }
                        if ((!file4.exists() || TextUtils.isEmpty(str2) || !str2.equals(next.f198430i)) && !arrayList3.contains(next.E)) {
                            ag.c cVar8 = new ag.c();
                            cVar8.f198121a = 3;
                            cVar8.f198122b = next.E;
                            cVar8.f198123c = next.f198430i;
                            long j17 = next.f198427e;
                            long j18 = j17 / 8192;
                            this.f198075l = j18;
                            cVar8.f198127g = j17;
                            this.f198081r += j18;
                            this.f198077n = System.currentTimeMillis();
                            cVar8.f198124d = next.F;
                            cVar8.f198125e = false;
                            arrayList.add(cVar8);
                            arrayList3.add(next.E);
                        }
                    }
                }
            }
        } else {
            if (arCloudConfigInfo.F != null) {
                file = new File(arCloudConfigInfo.F.D);
            } else {
                file = null;
            }
            if (file != null && file.exists()) {
                str = com.tencent.mobileqq.portal.o.e(file.getAbsolutePath());
            } else {
                str = null;
            }
            if (file != null && file.exists() && !TextUtils.isEmpty(str) && str.equals(arCloudConfigInfo.F.f198421e)) {
                try {
                    File file5 = new File(arCloudConfigInfo.F.D);
                    String str3 = arCloudConfigInfo.F.D;
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append(file5.getParentFile().getAbsolutePath());
                    String str4 = File.separator;
                    sb6.append(str4);
                    sb6.append(arCloudConfigInfo.F.f198421e);
                    sb6.append(str4);
                    ai.c(str3, sb6.toString());
                    dVar2.g(true, 3, arCloudConfigInfo);
                    QLog.i("AREngine_ARMarkerResourceManager", 1, "onARMarkerModelDownloadComplete  ");
                } catch (Exception unused2) {
                    new File(arCloudConfigInfo.F.D).delete();
                    QLog.i("AREngine_ARMarkerResourceManager", 1, "Download end. uncompressZip error. url = ");
                    dVar2.g(false, 3, arCloudConfigInfo);
                    QLog.i("AREngine_ARMarkerResourceManager", 1, "onARMarkerModelDownloadComplete  ");
                    dVar2.h(false, arCloudConfigInfo);
                    return;
                }
            } else if (arCloudConfigInfo.F != null) {
                ag.c cVar9 = new ag.c();
                cVar9.f198121a = 3;
                ArModelResource arModelResource = arCloudConfigInfo.F;
                cVar9.f198122b = arModelResource.f198422f;
                cVar9.f198123c = arModelResource.f198421e;
                long j19 = arModelResource.f198420d;
                long j26 = j19 / 8192;
                this.f198075l = j26;
                cVar9.f198127g = j19;
                this.f198081r += j26;
                this.f198077n = System.currentTimeMillis();
                cVar9.f198124d = arCloudConfigInfo.F.D;
                cVar9.f198125e = true;
                arrayList.add(cVar9);
            }
        }
        if (dVar2 != null && (arCloudConfigInfo.e() || arCloudConfigInfo.a())) {
            dVar2.l();
        }
        if (arrayList.size() > 0) {
            this.f198065b.e(arrayList, new a(dVar2, arCloudConfigInfo, dVar));
            return;
        }
        if (dVar2 != null) {
            dVar2.h(true, arCloudConfigInfo);
        }
        if (arCloudConfigInfo.f197700f != 1) {
            r(arCloudConfigInfo.E.f198409d, dVar);
        }
        c(arCloudConfigInfo);
    }

    private void k(d dVar, ArCloudConfigInfo arCloudConfigInfo) {
        File file;
        String str;
        String str2;
        String str3;
        ARRelationShip aRRelationShip;
        QLog.i("AREngine_ARMarkerResourceManager", 1, "downLoadObjectModelResources");
        if (arCloudConfigInfo == null) {
            return;
        }
        ArrayList<ag.c> arrayList = new ArrayList<>();
        ArWebInfo arWebInfo = arCloudConfigInfo.H;
        int i3 = 4;
        if (arWebInfo != null && arWebInfo.a()) {
            if (!new File(f198063u + "pddata/app/offline/html5/" + arCloudConfigInfo.H.f198435h + File.separator).exists() && !TextUtils.isEmpty(arCloudConfigInfo.H.f198435h)) {
                ag.c cVar = new ag.c();
                cVar.f198121a = 4;
                cVar.f198122b = String.valueOf(arCloudConfigInfo.H.f198435h);
                arrayList.add(cVar);
            }
        }
        com.tencent.mobileqq.ar.ARPromotion.c cVar2 = arCloudConfigInfo.M;
        if (cVar2 != null && !TextUtils.isEmpty(cVar2.f196875i)) {
            if (!new File(arCloudConfigInfo.M.f196875i).exists()) {
                ag.c cVar3 = new ag.c();
                cVar3.f198121a = 7;
                com.tencent.mobileqq.ar.ARPromotion.c cVar4 = arCloudConfigInfo.M;
                cVar3.f198122b = cVar4.f196872f;
                cVar3.f198123c = cVar4.f196874h;
                cVar3.f198127g = cVar4.f196873g;
                cVar3.f198124d = cVar4.f196875i;
                cVar3.f198125e = true;
                arrayList.add(cVar3);
            } else {
                try {
                    com.tencent.mobileqq.ar.ARPromotion.c cVar5 = arCloudConfigInfo.M;
                    ai.c(cVar5.f196875i, af.g(cVar5.f196874h));
                } catch (Exception unused) {
                }
            }
        }
        if (arCloudConfigInfo.I == 1 && (aRRelationShip = arCloudConfigInfo.J) != null && !TextUtils.isEmpty(aRRelationShip.f198396h)) {
            if (!new File(arCloudConfigInfo.J.f198396h).exists()) {
                String str4 = f198063u + "ar_model/0/" + arCloudConfigInfo.J.f198395f + "_model.zip";
                if (new File(str4).exists()) {
                    try {
                        ai.c(str4, af.f());
                    } catch (Exception unused2) {
                        ag.c cVar6 = new ag.c();
                        cVar6.f198121a = 6;
                        ARRelationShip aRRelationShip2 = arCloudConfigInfo.J;
                        cVar6.f198122b = aRRelationShip2.f198394e;
                        cVar6.f198123c = aRRelationShip2.f198395f;
                        cVar6.f198127g = aRRelationShip2.D;
                        cVar6.f198124d = aRRelationShip2.f198396h;
                        cVar6.f198125e = true;
                        arrayList.add(cVar6);
                    }
                } else {
                    ag.c cVar7 = new ag.c();
                    cVar7.f198121a = 6;
                    ARRelationShip aRRelationShip3 = arCloudConfigInfo.J;
                    cVar7.f198122b = aRRelationShip3.f198394e;
                    cVar7.f198123c = aRRelationShip3.f198395f;
                    cVar7.f198127g = aRRelationShip3.D;
                    cVar7.f198124d = aRRelationShip3.f198396h;
                    cVar7.f198125e = true;
                    arrayList.add(cVar7);
                }
            } else {
                try {
                    ai.c(arCloudConfigInfo.J.f198396h, af.f());
                } catch (Exception unused3) {
                }
            }
        }
        int i16 = arCloudConfigInfo.f197702i;
        if (i16 == 0 || i16 == 7 || i16 == 8) {
            if (arCloudConfigInfo.F != null) {
                file = new File(arCloudConfigInfo.F.D);
            } else {
                file = null;
            }
            if (file != null && file.exists()) {
                str = com.tencent.mobileqq.portal.o.e(file.getAbsolutePath());
            } else {
                str = null;
            }
            if (file != null && file.exists() && !TextUtils.isEmpty(str) && str.equals(arCloudConfigInfo.F.f198421e)) {
                try {
                    File file2 = new File(arCloudConfigInfo.F.D);
                    String str5 = arCloudConfigInfo.F.D;
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(file2.getParentFile().getAbsolutePath());
                    String str6 = File.separator;
                    sb5.append(str6);
                    sb5.append(arCloudConfigInfo.F.f198421e);
                    sb5.append(str6);
                    ai.c(str5, sb5.toString());
                    dVar.A(true, arCloudConfigInfo);
                    QLog.i("AREngine_ARMarkerResourceManager", 1, "onARObjectClassifyDownloadComplete.");
                } catch (Exception unused4) {
                    new File(arCloudConfigInfo.F.D).delete();
                    QLog.i("AREngine_ARMarkerResourceManager", 1, "onARObjectClassifyDownloadComplete. uncompressZip error.");
                    dVar.A(false, arCloudConfigInfo);
                    return;
                }
            } else {
                ArModelResource arModelResource = arCloudConfigInfo.F;
                if (arModelResource != null && arCloudConfigInfo.f197702i == 7) {
                    if (arModelResource.f198421e != null) {
                        str2 = f198063u + "ar_model/0/" + arCloudConfigInfo.F.f198421e + "_model.zip";
                    } else {
                        str2 = "";
                    }
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append(f198063u);
                    sb6.append("ar_cloud_classfiy_model/");
                    sb6.append(arCloudConfigInfo.f197702i);
                    String str7 = File.separator;
                    sb6.append(str7);
                    sb6.append(arCloudConfigInfo.F.f198421e);
                    sb6.append(str7);
                    String sb7 = sb6.toString();
                    if (new File(str2).exists()) {
                        try {
                            ai.c(str2, sb7);
                        } catch (Exception unused5) {
                            if (arCloudConfigInfo.F != null) {
                                ag.c cVar8 = new ag.c();
                                cVar8.f198121a = 3;
                                ArModelResource arModelResource2 = arCloudConfigInfo.F;
                                cVar8.f198122b = arModelResource2.f198422f;
                                cVar8.f198123c = arModelResource2.f198421e;
                                long j3 = arModelResource2.f198420d;
                                long j16 = j3 / 8192;
                                this.f198075l = j16;
                                cVar8.f198127g = j3;
                                this.f198081r += j16;
                                this.f198077n = System.currentTimeMillis();
                                cVar8.f198124d = arCloudConfigInfo.F.D;
                                cVar8.f198125e = true;
                                arrayList.add(cVar8);
                            }
                        }
                    } else if (arCloudConfigInfo.F != null) {
                        ag.c cVar9 = new ag.c();
                        cVar9.f198121a = 3;
                        ArModelResource arModelResource3 = arCloudConfigInfo.F;
                        cVar9.f198122b = arModelResource3.f198422f;
                        cVar9.f198123c = arModelResource3.f198421e;
                        long j17 = arModelResource3.f198420d;
                        long j18 = j17 / 8192;
                        this.f198075l = j18;
                        cVar9.f198127g = j17;
                        this.f198081r += j18;
                        this.f198077n = System.currentTimeMillis();
                        cVar9.f198124d = arCloudConfigInfo.F.D;
                        cVar9.f198125e = true;
                        arrayList.add(cVar9);
                    }
                } else if (arModelResource != null) {
                    ag.c cVar10 = new ag.c();
                    cVar10.f198121a = 3;
                    ArModelResource arModelResource4 = arCloudConfigInfo.F;
                    cVar10.f198122b = arModelResource4.f198422f;
                    cVar10.f198123c = arModelResource4.f198421e;
                    long j19 = arModelResource4.f198420d;
                    long j26 = j19 / 8192;
                    this.f198075l = j26;
                    cVar10.f198127g = j19;
                    this.f198081r += j26;
                    this.f198077n = System.currentTimeMillis();
                    cVar10.f198124d = arCloudConfigInfo.F.D;
                    cVar10.f198125e = true;
                    arrayList.add(cVar10);
                }
            }
        }
        ArrayList<ArVideoResourceInfo> arrayList2 = arCloudConfigInfo.D;
        if (arrayList2 != null && arrayList2.size() > 0) {
            ArrayList arrayList3 = new ArrayList();
            Iterator<ArVideoResourceInfo> it = arCloudConfigInfo.D.iterator();
            while (it.hasNext()) {
                ArVideoResourceInfo next = it.next();
                if (next.D != i3) {
                    File file3 = new File(next.F);
                    if (file3.exists()) {
                        str3 = com.tencent.mobileqq.portal.o.e(file3.getAbsolutePath());
                    } else {
                        str3 = null;
                    }
                    if ((!file3.exists() || TextUtils.isEmpty(str3) || !str3.equals(next.f198430i)) && !arrayList3.contains(next.E)) {
                        ag.c cVar11 = new ag.c();
                        cVar11.f198121a = 3;
                        cVar11.f198122b = next.E;
                        cVar11.f198123c = next.f198430i;
                        long j27 = next.f198427e;
                        long j28 = j27 / 8192;
                        this.f198075l = j28;
                        cVar11.f198127g = j27;
                        this.f198081r += j28;
                        this.f198077n = System.currentTimeMillis();
                        cVar11.f198124d = next.F;
                        cVar11.f198125e = false;
                        arrayList.add(cVar11);
                        arrayList3.add(next.E);
                    }
                    i3 = 4;
                }
            }
        }
        if (dVar != null && arCloudConfigInfo.a()) {
            dVar.v();
        }
        if (arrayList.size() > 0) {
            this.f198065b.e(arrayList, new b(dVar, arCloudConfigInfo));
        } else if (dVar != null) {
            dVar.A(true, arCloudConfigInfo);
        }
    }

    private void m(d dVar, ArCloudConfigInfo arCloudConfigInfo) {
        File file;
        String str;
        String str2;
        String str3;
        ARRelationShip aRRelationShip;
        QLog.i("AREngine_ARMarkerResourceManager", 1, "downLoadSceneModelResources");
        if (arCloudConfigInfo == null) {
            return;
        }
        ArrayList<ag.c> arrayList = new ArrayList<>();
        ArWebInfo arWebInfo = arCloudConfigInfo.H;
        int i3 = 4;
        if (arWebInfo != null && arWebInfo.a()) {
            if (!new File(f198063u + "pddata/app/offline/html5/" + arCloudConfigInfo.H.f198435h + File.separator).exists() && !TextUtils.isEmpty(arCloudConfigInfo.H.f198435h)) {
                ag.c cVar = new ag.c();
                cVar.f198121a = 4;
                cVar.f198122b = String.valueOf(arCloudConfigInfo.H.f198435h);
                arrayList.add(cVar);
            }
        }
        com.tencent.mobileqq.ar.ARPromotion.c cVar2 = arCloudConfigInfo.M;
        if (cVar2 != null && !TextUtils.isEmpty(cVar2.f196875i)) {
            if (!new File(arCloudConfigInfo.M.f196875i).exists()) {
                ag.c cVar3 = new ag.c();
                cVar3.f198121a = 7;
                com.tencent.mobileqq.ar.ARPromotion.c cVar4 = arCloudConfigInfo.M;
                cVar3.f198122b = cVar4.f196872f;
                cVar3.f198123c = cVar4.f196874h;
                cVar3.f198127g = cVar4.f196873g;
                cVar3.f198124d = cVar4.f196875i;
                cVar3.f198125e = true;
                arrayList.add(cVar3);
            } else {
                try {
                    com.tencent.mobileqq.ar.ARPromotion.c cVar5 = arCloudConfigInfo.M;
                    ai.c(cVar5.f196875i, af.g(cVar5.f196874h));
                } catch (Exception unused) {
                }
            }
        }
        if (arCloudConfigInfo.I == 1 && (aRRelationShip = arCloudConfigInfo.J) != null && !TextUtils.isEmpty(aRRelationShip.f198396h)) {
            if (!new File(arCloudConfigInfo.J.f198396h).exists()) {
                String str4 = f198063u + "ar_model/0/" + arCloudConfigInfo.J.f198395f + "_model.zip";
                if (new File(str4).exists()) {
                    try {
                        ai.c(str4, af.f());
                    } catch (Exception unused2) {
                        ag.c cVar6 = new ag.c();
                        cVar6.f198121a = 6;
                        ARRelationShip aRRelationShip2 = arCloudConfigInfo.J;
                        cVar6.f198122b = aRRelationShip2.f198394e;
                        cVar6.f198123c = aRRelationShip2.f198395f;
                        cVar6.f198127g = aRRelationShip2.D;
                        cVar6.f198124d = aRRelationShip2.f198396h;
                        cVar6.f198125e = true;
                        arrayList.add(cVar6);
                    }
                } else {
                    ag.c cVar7 = new ag.c();
                    cVar7.f198121a = 6;
                    ARRelationShip aRRelationShip3 = arCloudConfigInfo.J;
                    cVar7.f198122b = aRRelationShip3.f198394e;
                    cVar7.f198123c = aRRelationShip3.f198395f;
                    cVar7.f198127g = aRRelationShip3.D;
                    cVar7.f198124d = aRRelationShip3.f198396h;
                    cVar7.f198125e = true;
                    arrayList.add(cVar7);
                }
            } else {
                try {
                    ai.c(arCloudConfigInfo.J.f198396h, af.f());
                } catch (Exception unused3) {
                }
            }
        }
        int i16 = arCloudConfigInfo.f197702i;
        if (i16 == 0 || i16 == 7 || i16 == 8) {
            if (arCloudConfigInfo.F != null) {
                file = new File(arCloudConfigInfo.F.D);
            } else {
                file = null;
            }
            if (file != null && file.exists()) {
                str = com.tencent.mobileqq.portal.o.e(file.getAbsolutePath());
            } else {
                str = null;
            }
            if (file != null && file.exists() && !TextUtils.isEmpty(str) && str.equals(arCloudConfigInfo.F.f198421e)) {
                try {
                    File file2 = new File(arCloudConfigInfo.F.D);
                    String str5 = arCloudConfigInfo.F.D;
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(file2.getParentFile().getAbsolutePath());
                    String str6 = File.separator;
                    sb5.append(str6);
                    sb5.append(arCloudConfigInfo.F.f198421e);
                    sb5.append(str6);
                    ai.c(str5, sb5.toString());
                    if (dVar != null) {
                        dVar.q(true, arCloudConfigInfo);
                    }
                    QLog.i("AREngine_ARMarkerResourceManager", 1, "onARSceneRecogDownloadComplete.");
                } catch (Exception unused4) {
                    new File(arCloudConfigInfo.F.D).delete();
                    QLog.i("AREngine_ARMarkerResourceManager", 1, "onARSceneRecogDownloadComplete. uncompressZip error.");
                    if (dVar != null) {
                        dVar.q(true, arCloudConfigInfo);
                        return;
                    }
                    return;
                }
            } else {
                ArModelResource arModelResource = arCloudConfigInfo.F;
                if (arModelResource != null && arCloudConfigInfo.f197702i == 7) {
                    if (arModelResource != null && arModelResource.f198421e != null) {
                        str2 = f198063u + "ar_model/0/" + arCloudConfigInfo.F.f198421e + "_model.zip";
                    } else {
                        str2 = "";
                    }
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append(f198063u);
                    sb6.append("ar_cloud_classfiy_model/");
                    sb6.append(arCloudConfigInfo.f197702i);
                    String str7 = File.separator;
                    sb6.append(str7);
                    sb6.append(arCloudConfigInfo.F.f198421e);
                    sb6.append(str7);
                    String sb7 = sb6.toString();
                    if (new File(str2).exists()) {
                        try {
                            ai.c(str2, sb7);
                        } catch (Exception unused5) {
                            if (arCloudConfigInfo.F != null) {
                                ag.c cVar8 = new ag.c();
                                cVar8.f198121a = 3;
                                ArModelResource arModelResource2 = arCloudConfigInfo.F;
                                cVar8.f198122b = arModelResource2.f198422f;
                                cVar8.f198123c = arModelResource2.f198421e;
                                long j3 = arModelResource2.f198420d;
                                long j16 = j3 / 8192;
                                this.f198075l = j16;
                                cVar8.f198127g = j3;
                                this.f198081r += j16;
                                this.f198077n = System.currentTimeMillis();
                                cVar8.f198124d = arCloudConfigInfo.F.D;
                                cVar8.f198125e = true;
                                arrayList.add(cVar8);
                            }
                        }
                    } else if (arCloudConfigInfo.F != null) {
                        ag.c cVar9 = new ag.c();
                        cVar9.f198121a = 3;
                        ArModelResource arModelResource3 = arCloudConfigInfo.F;
                        cVar9.f198122b = arModelResource3.f198422f;
                        cVar9.f198123c = arModelResource3.f198421e;
                        long j17 = arModelResource3.f198420d;
                        long j18 = j17 / 8192;
                        this.f198075l = j18;
                        cVar9.f198127g = j17;
                        this.f198081r += j18;
                        this.f198077n = System.currentTimeMillis();
                        cVar9.f198124d = arCloudConfigInfo.F.D;
                        cVar9.f198125e = true;
                        arrayList.add(cVar9);
                    }
                } else if (arModelResource != null) {
                    ag.c cVar10 = new ag.c();
                    cVar10.f198121a = 3;
                    ArModelResource arModelResource4 = arCloudConfigInfo.F;
                    cVar10.f198122b = arModelResource4.f198422f;
                    cVar10.f198123c = arModelResource4.f198421e;
                    long j19 = arModelResource4.f198420d;
                    long j26 = j19 / 8192;
                    this.f198075l = j26;
                    cVar10.f198127g = j19;
                    this.f198081r += j26;
                    this.f198077n = System.currentTimeMillis();
                    cVar10.f198124d = arCloudConfigInfo.F.D;
                    cVar10.f198125e = true;
                    arrayList.add(cVar10);
                }
            }
        }
        ArrayList<ArVideoResourceInfo> arrayList2 = arCloudConfigInfo.D;
        if (arrayList2 != null && arrayList2.size() > 0) {
            ArrayList arrayList3 = new ArrayList();
            Iterator<ArVideoResourceInfo> it = arCloudConfigInfo.D.iterator();
            while (it.hasNext()) {
                ArVideoResourceInfo next = it.next();
                if (next.D != i3) {
                    File file3 = new File(next.F);
                    if (file3.exists()) {
                        str3 = com.tencent.mobileqq.portal.o.e(file3.getAbsolutePath());
                    } else {
                        str3 = null;
                    }
                    if ((!file3.exists() || TextUtils.isEmpty(str3) || !str3.equals(next.f198430i)) && !arrayList3.contains(next.E)) {
                        ag.c cVar11 = new ag.c();
                        cVar11.f198121a = 3;
                        cVar11.f198122b = next.E;
                        cVar11.f198123c = next.f198430i;
                        long j27 = next.f198427e;
                        long j28 = j27 / 8192;
                        this.f198075l = j28;
                        cVar11.f198127g = j27;
                        this.f198081r += j28;
                        this.f198077n = System.currentTimeMillis();
                        cVar11.f198124d = next.F;
                        cVar11.f198125e = false;
                        arrayList.add(cVar11);
                        arrayList3.add(next.E);
                    }
                    i3 = 4;
                }
            }
        }
        if (dVar != null && arCloudConfigInfo.a()) {
            dVar.m();
        }
        if (arrayList.size() > 0) {
            this.f198065b.e(arrayList, new c(dVar, arCloudConfigInfo));
        } else if (dVar != null) {
            dVar.q(true, arCloudConfigInfo);
        }
    }

    private static String o() {
        u();
        return f198063u + "ar_cloud_marker_config/";
    }

    private void q(long j3) {
        ArrayList<ArVideoResourceInfo> arrayList;
        this.f198064a.clear();
        File[] listFiles = new File(o()).listFiles();
        if (listFiles == null) {
            return;
        }
        for (File file : listFiles) {
            if (file.getName().endsWith("_config.dat")) {
                String o16 = o();
                String name = file.getName();
                if (file.lastModified() + j3 >= System.currentTimeMillis()) {
                    ArCloudConfigInfo a16 = ai.a(o16, name);
                    s(a16);
                    if ((a16 == null || a16.E == null || new File(a16.E.f198412h).exists()) && (a16 == null || a16.F == null || new File(a16.F.D).exists())) {
                        if (a16 != null && (arrayList = a16.D) != null && arrayList.size() > 0 && a16.E != null) {
                            Iterator<ArVideoResourceInfo> it = a16.D.iterator();
                            while (it.hasNext()) {
                                ArVideoResourceInfo next = it.next();
                                if (!new File(a16.E.f198413i + next.f198430i + "_model.zip").exists()) {
                                    int i3 = next.D;
                                }
                            }
                        }
                        this.f198064a.add(a16);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean r(String str, com.tencent.mobileqq.ar.arengine.d dVar) {
        if (dVar == null) {
            return false;
        }
        try {
            return ai.b(new String(dVar.f198161i[0].f198171g, "utf-8"), o(), str + "_config.dat");
        } catch (UnsupportedEncodingException e16) {
            QLog.i("AREngine_ARMarkerResourceManager", 1, "saveJsonConfigInfo failed. error msg = " + e16.getMessage());
            return false;
        }
    }

    public static boolean s(ArCloudConfigInfo arCloudConfigInfo) {
        com.tencent.mobileqq.ar.ARPromotion.c cVar;
        ARRelationShip aRRelationShip;
        if (arCloudConfigInfo == null) {
            return false;
        }
        u();
        ArFeatureInfo arFeatureInfo = arCloudConfigInfo.E;
        if (arFeatureInfo != null) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(f198063u);
            sb5.append("ar_cloud_marker_feature/");
            sb5.append(arCloudConfigInfo.f197702i);
            String str = File.separator;
            sb5.append(str);
            sb5.append(arCloudConfigInfo.E.f198409d);
            sb5.append("_signature.db");
            arFeatureInfo.f198412h = sb5.toString();
            arCloudConfigInfo.E.f198413i = f198063u + "ar_cloud_marker_model/" + arCloudConfigInfo.f197702i + str;
        }
        ArModelResource arModelResource = arCloudConfigInfo.F;
        if (arModelResource != null) {
            arModelResource.D = f198063u + "ar_cloud_marker_model/" + arCloudConfigInfo.f197702i + File.separator + arCloudConfigInfo.F.f198421e + "_model.zip";
        }
        if (arCloudConfigInfo.I == 1 && (aRRelationShip = arCloudConfigInfo.J) != null && !TextUtils.isEmpty(aRRelationShip.f198395f)) {
            arCloudConfigInfo.J.f198396h = f198063u + "ar_cloud_relationship/" + arCloudConfigInfo.J.f198395f + "_relationship.zip";
        }
        if (arCloudConfigInfo.b() && (cVar = arCloudConfigInfo.M) != null) {
            cVar.f196875i = f198063u + "ar_cloud_transfer/" + arCloudConfigInfo.M.f196874h + ".zip";
        }
        ArrayList<ArVideoResourceInfo> arrayList = arCloudConfigInfo.D;
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<ArVideoResourceInfo> it = arCloudConfigInfo.D.iterator();
            while (it.hasNext()) {
                ArVideoResourceInfo next = it.next();
                if (next.D == 4) {
                    next.F = y81.a.a(next.E);
                } else if (arCloudConfigInfo.E != null) {
                    next.F = arCloudConfigInfo.E.f198413i + next.f198430i + "_model.zip";
                }
            }
        }
        return true;
    }

    private static boolean t(ArCloudConfigInfo arCloudConfigInfo) {
        com.tencent.mobileqq.ar.ARPromotion.c cVar;
        ARRelationShip aRRelationShip;
        if (arCloudConfigInfo == null) {
            return false;
        }
        u();
        ArFeatureInfo arFeatureInfo = arCloudConfigInfo.E;
        if (arFeatureInfo != null) {
            arFeatureInfo.f198413i = f198063u + "ar_cloud_classfiy_model/" + arCloudConfigInfo.f197702i + File.separator;
        }
        if (arCloudConfigInfo.I == 1 && (aRRelationShip = arCloudConfigInfo.J) != null && !TextUtils.isEmpty(aRRelationShip.f198395f)) {
            arCloudConfigInfo.J.f198396h = f198063u + "ar_cloud_relationship/" + arCloudConfigInfo.J.f198395f + "_relationship.zip";
        }
        if (arCloudConfigInfo.b() && (cVar = arCloudConfigInfo.M) != null) {
            cVar.f196875i = f198063u + "ar_cloud_transfer/" + arCloudConfigInfo.M.f196874h + ".zip";
        }
        ArrayList<ArVideoResourceInfo> arrayList = arCloudConfigInfo.D;
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<ArVideoResourceInfo> it = arCloudConfigInfo.D.iterator();
            while (it.hasNext()) {
                ArVideoResourceInfo next = it.next();
                if (next.D == 4) {
                    next.F = y81.a.a(next.E);
                } else {
                    next.F = f198063u + "ar_cloud_classfiy_model/" + arCloudConfigInfo.f197702i + File.separator + next.f198430i + "_model.zip";
                }
            }
        }
        ArModelResource arModelResource = arCloudConfigInfo.F;
        if (arModelResource != null) {
            arModelResource.D = f198063u + "ar_cloud_classfiy_model/" + arCloudConfigInfo.f197702i + File.separator + arCloudConfigInfo.F.f198421e + "_model.zip";
        }
        return true;
    }

    static void u() {
        if (TextUtils.isEmpty(f198063u)) {
            f198063u = af.j();
        }
        af.b(AppConstants.SDCARD_AR_MODEL + ".nomedia");
        af.b(AppConstants.SDCARD_AR_TRANSFER + ".nomedia");
    }

    private static boolean v(ArCloudConfigInfo arCloudConfigInfo) {
        com.tencent.mobileqq.ar.ARPromotion.c cVar;
        ARRelationShip aRRelationShip;
        if (arCloudConfigInfo == null) {
            return false;
        }
        u();
        ArFeatureInfo arFeatureInfo = arCloudConfigInfo.E;
        if (arFeatureInfo != null) {
            arFeatureInfo.f198413i = f198063u + "ar_cloud_scene_model/" + arCloudConfigInfo.f197702i + File.separator;
        }
        if (arCloudConfigInfo.I == 1 && (aRRelationShip = arCloudConfigInfo.J) != null && !TextUtils.isEmpty(aRRelationShip.f198395f)) {
            arCloudConfigInfo.J.f198396h = f198063u + "ar_cloud_relationship/" + arCloudConfigInfo.J.f198395f + "_relationship.zip";
        }
        if (arCloudConfigInfo.b() && (cVar = arCloudConfigInfo.M) != null) {
            cVar.f196875i = f198063u + "ar_cloud_transfer/" + arCloudConfigInfo.M.f196874h + ".zip";
        }
        ArrayList<ArVideoResourceInfo> arrayList = arCloudConfigInfo.D;
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<ArVideoResourceInfo> it = arCloudConfigInfo.D.iterator();
            while (it.hasNext()) {
                ArVideoResourceInfo next = it.next();
                if (next.D == 4) {
                    next.F = y81.a.a(next.E);
                } else {
                    next.F = f198063u + "ar_cloud_scene_model/" + arCloudConfigInfo.f197702i + File.separator + next.f198430i + "_model.zip";
                }
            }
        }
        ArModelResource arModelResource = arCloudConfigInfo.F;
        if (arModelResource != null) {
            arModelResource.D = f198063u + "ar_cloud_scene_model/" + arCloudConfigInfo.f197702i + File.separator + arCloudConfigInfo.F.f198421e + "_model.zip";
        }
        return true;
    }

    public void d() {
        QLog.i("AREngine_ARMarkerResourceManager", 1, "arCloudDownloadReport start.");
        ARReport.c().o(this.f198070g, this.f198071h, this.f198072i, this.f198074k, this.f198075l, this.f198076m, this.f198078o, this.f198079p, this.f198080q, this.f198069f - this.f198068e, this.f198081r, this.f198082s);
    }

    public void e() {
        synchronized (this.f198066c) {
            ah ahVar = this.f198065b;
            if (ahVar != null) {
                ahVar.b();
            }
        }
    }

    public void g() {
        this.f198068e = 0L;
        this.f198069f = 0L;
        this.f198070g = null;
        this.f198071h = 0L;
        this.f198072i = 0L;
        this.f198073j = 0L;
        this.f198074k = -1;
        this.f198075l = 0L;
        this.f198076m = 0L;
        this.f198077n = 0L;
        this.f198078o = -1;
        this.f198079p = 0L;
        this.f198080q = -1;
        this.f198081r = 0L;
        this.f198082s = -1;
    }

    public boolean h(com.tencent.mobileqq.ar.arengine.d dVar, d dVar2, boolean z16, String str) {
        ARRelationShip aRRelationShip;
        try {
            String str2 = new String(dVar.f198161i[0].f198171g, "utf-8");
            QLog.i("AREngine_ARMarkerResourceManager", 1, "downLoadMarkerConfig. jsonContent = " + str2);
            ArCloudConfigInfo a16 = com.tencent.mobileqq.ar.arengine.c.a(str2);
            QLog.i("AREngine_ARMarkerResourceManager", 1, "downLoadMarkerConfig. config = " + a16);
            if (a16 != null && a16.E != null) {
                if (a16.M != null) {
                    QLog.i("AREngine_ARMarkerResourceManager", 1, "downLoadMarkerConfig pause because of ar360 is not support");
                    return false;
                }
                int i3 = a16.I;
                if (i3 == 1) {
                    com.tencent.mobileqq.ar.g.b();
                    return false;
                }
                if (z16 && (i3 != 1 || (aRRelationShip = a16.J) == null || TextUtils.isEmpty(aRRelationShip.f198393d) || !a16.J.f198393d.equals(str))) {
                    return false;
                }
                QLog.i("AREngine_ARMarkerResourceManager", 1, "downLoadMarkerConfig");
                s(a16);
                synchronized (this.f198066c) {
                    i(dVar, dVar2, a16);
                }
                return true;
            }
            QLog.i("AREngine_ARMarkerResourceManager", 1, "ARCloud Marker Recog failed.");
            return false;
        } catch (Exception e16) {
            QLog.i("AREngine_ARMarkerResourceManager", 1, "downLoadMarkerConfig. parse json failed. error msg = " + e16.getMessage());
            return false;
        }
    }

    public boolean j(f fVar, d dVar, boolean z16, String str) {
        byte[] a16;
        if (fVar == null || (a16 = fVar.a()) == null) {
            return false;
        }
        try {
            String str2 = new String(a16, "utf-8");
            if (QLog.isColorLevel()) {
                QLog.i("AREngine_ARMarkerResourceManager", 2, "downLoadMarkerConfig. jsonContent = " + str2);
            }
            ArCloudConfigInfo a17 = com.tencent.mobileqq.ar.arengine.c.a(str2);
            QLog.i("AREngine_ARMarkerResourceManager", 1, "downLoadMarkerConfig. config = " + a17);
            if (a17 == null) {
                return false;
            }
            if (a17.M != null) {
                if (!com.tencent.mobileqq.ar.g.b() && com.tencent.mobileqq.ar.ARPromotionMgr.c.a()) {
                    String str3 = a17.f197703m;
                    if (str3 != null) {
                        ReportController.o(null, "CliOper", "", "", "0X80098CC", "0X80098CC", 0, 0, str3, "0", "0", "");
                    }
                } else {
                    QLog.i("AREngine_ARMarkerResourceManager", 1, "downLoadObjectConfig pause because of device not support");
                    return false;
                }
            }
            if (a17.I != 1 && a17.f197702i != 7) {
                t(a17);
                if (QLog.isDebugVersion() && a17.f197701h == 0) {
                    QLog.e("AREngine_ARMarkerResourceManager", 1, HardCodeUtil.qqStr(R.string.jqv));
                }
                a17.f197701h = Math.max(1, a17.f197701h);
                synchronized (this.f198066c) {
                    k(dVar, a17);
                }
                return true;
            }
            QLog.i("AREngine_ARMarkerResourceManager", 1, "ar card not support");
            return false;
        } catch (UnsupportedEncodingException e16) {
            QLog.i("AREngine_ARMarkerResourceManager", 1, "processObjectClassifyRecogResult. parse json failed. error msg = " + e16.getMessage());
            return false;
        }
    }

    public boolean l(t tVar, d dVar, boolean z16, String str) {
        byte[] a16;
        if (tVar == null || (a16 = tVar.a()) == null) {
            return false;
        }
        try {
            String str2 = new String(a16, "utf-8");
            if (QLog.isColorLevel()) {
                QLog.i("AREngine_ARMarkerResourceManager", 2, "downLoadSceneConfig. jsonContent = " + str2);
            }
            ArCloudConfigInfo a17 = com.tencent.mobileqq.ar.arengine.c.a(str2);
            QLog.i("AREngine_ARMarkerResourceManager", 1, "downLoadSceneConfig. config = " + a17);
            if (a17 == null) {
                return false;
            }
            if (a17.M != null) {
                if (!com.tencent.mobileqq.ar.g.b() && com.tencent.mobileqq.ar.ARPromotionMgr.c.a()) {
                    String str3 = a17.f197703m;
                    if (str3 != null) {
                        ReportController.o(null, "CliOper", "", "", "0X80098CC", "0X80098CC", 0, 0, str3, "0", "0", "");
                    }
                } else {
                    QLog.i("AREngine_ARMarkerResourceManager", 1, "downLoadSceneConfig pause because of device not support");
                    return false;
                }
            }
            if (a17.I == 1) {
                try {
                    com.tencent.mobileqq.ar.g.b();
                    return false;
                } catch (Exception e16) {
                    QLog.i("AREngine_ARMarkerResourceManager", 1, " HotVideoUtils.saveBlurBitmap e = " + e16.getMessage());
                }
            }
            if (z16 && (a17.I != 1 || a17.J == null || !a17.a())) {
                return false;
            }
            v(a17);
            if (QLog.isDebugVersion() && a17.f197701h == 0) {
                QLog.e("AREngine_ARMarkerResourceManager", 1, HardCodeUtil.qqStr(R.string.jqu));
            }
            a17.f197701h = Math.max(1, a17.f197701h);
            synchronized (this.f198066c) {
                m(dVar, a17);
            }
            return true;
        } catch (UnsupportedEncodingException e17) {
            QLog.i("AREngine_ARMarkerResourceManager", 1, "processSceneRecogResult. parse json failed. error msg = " + e17.getMessage());
            return false;
        }
    }

    public ArrayList<ArCloudConfigInfo> n() {
        return this.f198064a;
    }

    public void p(long j3, boolean z16) {
        long currentTimeMillis = System.currentTimeMillis();
        q(j3);
        f(z16);
        ARReport.c().m(System.currentTimeMillis() - currentTimeMillis);
    }

    public void w() {
        ah ahVar = this.f198065b;
        if (ahVar != null) {
            ahVar.f();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class b implements ah.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ d f198088a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ArCloudConfigInfo f198089b;

        b(d dVar, ArCloudConfigInfo arCloudConfigInfo) {
            this.f198088a = dVar;
            this.f198089b = arCloudConfigInfo;
        }

        @Override // com.tencent.mobileqq.ar.arengine.ah.c
        public void a(int i3) {
            d dVar = this.f198088a;
            if (dVar != null) {
                dVar.u(i3);
            }
        }

        @Override // com.tencent.mobileqq.ar.arengine.ah.c
        public void c() {
            d dVar = this.f198088a;
            if (dVar != null) {
                dVar.v();
            }
        }

        @Override // com.tencent.mobileqq.ar.arengine.ah.c
        public void d(boolean z16) {
            d dVar = this.f198088a;
            if (dVar != null) {
                dVar.A(z16, this.f198089b);
            }
        }

        @Override // com.tencent.mobileqq.ar.arengine.ah.c
        public void b(int i3, boolean z16) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class c implements ah.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ d f198091a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ArCloudConfigInfo f198092b;

        c(d dVar, ArCloudConfigInfo arCloudConfigInfo) {
            this.f198091a = dVar;
            this.f198092b = arCloudConfigInfo;
        }

        @Override // com.tencent.mobileqq.ar.arengine.ah.c
        public void a(int i3) {
            d dVar = this.f198091a;
            if (dVar != null) {
                dVar.j(i3);
            }
        }

        @Override // com.tencent.mobileqq.ar.arengine.ah.c
        public void c() {
            d dVar = this.f198091a;
            if (dVar != null) {
                dVar.m();
            }
        }

        @Override // com.tencent.mobileqq.ar.arengine.ah.c
        public void d(boolean z16) {
            d dVar = this.f198091a;
            if (dVar != null) {
                dVar.q(z16, this.f198092b);
            }
        }

        @Override // com.tencent.mobileqq.ar.arengine.ah.c
        public void b(int i3, boolean z16) {
        }
    }
}
