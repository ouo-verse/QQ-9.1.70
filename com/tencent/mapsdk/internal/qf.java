package com.tencent.mapsdk.internal;

import android.content.Context;
import com.tencent.mapsdk.core.components.protocol.jce.conf.CSFileUpdateReq;
import com.tencent.mapsdk.core.components.protocol.jce.conf.FileUpdateReq;
import com.tencent.mapsdk.core.components.protocol.jce.conf.FileUpdateRsp;
import com.tencent.mapsdk.core.utils.log.LogUtil;
import com.tencent.mapsdk.internal.lb;
import com.tencent.mapsdk.vector.VectorMap;
import com.tencent.tencentmap.mapsdk.maps.TencentMapOptions;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class qf {

    /* renamed from: e, reason: collision with root package name */
    public static volatile Map<String, List<WeakReference<bi>>> f149785e = new HashMap();

    /* renamed from: a, reason: collision with root package name */
    public volatile boolean f149786a = false;

    /* renamed from: b, reason: collision with root package name */
    String f149787b;

    /* renamed from: c, reason: collision with root package name */
    mv f149788c;

    /* renamed from: d, reason: collision with root package name */
    mz f149789d;

    /* renamed from: f, reason: collision with root package name */
    public WeakReference<bi> f149790f;

    /* renamed from: g, reason: collision with root package name */
    String f149791g;

    /* renamed from: h, reason: collision with root package name */
    String f149792h;

    /* renamed from: i, reason: collision with root package name */
    String f149793i;

    /* renamed from: j, reason: collision with root package name */
    String f149794j;

    /* renamed from: k, reason: collision with root package name */
    String f149795k;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<qf> f149796a;

        /* renamed from: b, reason: collision with root package name */
        private final String f149797b;

        /* renamed from: c, reason: collision with root package name */
        private final fz f149798c;

        public a(qf qfVar, String str, fz fzVar) {
            this.f149796a = new WeakReference<>(qfVar);
            this.f149797b = str;
            this.f149798c = fzVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            WeakReference<qf> weakReference = this.f149796a;
            if (weakReference != null && weakReference.get() != null) {
                qf qfVar = this.f149796a.get();
                String str = this.f149797b;
                fz fzVar = this.f149798c;
                ArrayList arrayList = new ArrayList();
                arrayList.add(new FileUpdateReq(er.f148280i, qfVar.f149788c.b(et.f148298a), qfVar.f149788c.a(et.f148317t)));
                arrayList.add(new FileUpdateReq("poi_icon", qfVar.f149788c.b(et.f148300c), qfVar.f149788c.a(et.f148318u)));
                arrayList.add(new FileUpdateReq(er.f148281j, qfVar.f149788c.b(et.f148301d), qfVar.f149788c.a(et.f148319v)));
                arrayList.add(new FileUpdateReq(er.f148287p, qfVar.f149788c.b("escalator_night_version"), qfVar.f149788c.a("escalator_night_md5")));
                if (fzVar != null && fzVar.a()) {
                    arrayList.add(new FileUpdateReq(er.f148283l, qfVar.f149788c.b("indoormap_style_version"), qfVar.f149788c.a("indoormap_style_md5")));
                    arrayList.add(new FileUpdateReq(er.f148284m, qfVar.f149788c.b("indoormap_style_night_version"), qfVar.f149788c.a("indoormap_style_night_md5")));
                    arrayList.add(new FileUpdateReq(er.f148285n, qfVar.f149788c.b(et.f148316s), qfVar.f149788c.a(et.f148322y)));
                    arrayList.add(new FileUpdateReq(er.f148286o, qfVar.f149788c.b("indoorpoi_icon_3d_night_version"), qfVar.f149788c.a("indoorpoi_icon_3d_night_md5")));
                }
                String a16 = qfVar.a();
                CSFileUpdateReq cSFileUpdateReq = new CSFileUpdateReq(arrayList, a16, ho.n(), null, qfVar.f149787b, str);
                qfVar.f149792h = qfVar.f149789d.a(qfVar.f149791g);
                qfVar.f149793i = qfVar.f149789d.b(qfVar.f149791g);
                qfVar.f149794j = qfVar.f149789d.c(qfVar.f149791g) + "config/";
                qfVar.f149795k = qfVar.f149789d.c(qfVar.f149791g) + "assets/";
                ku.a(qfVar.f149794j);
                ku.a(qfVar.f149795k);
                List<FileUpdateRsp> a17 = new qd().a(qfVar.f149789d.c(qfVar.f149791g) + "config/", qfVar.f149789d.c(qfVar.f149791g) + "assets/", a16, cSFileUpdateReq, qfVar);
                if (a17 != null) {
                    if (qfVar.f149786a) {
                        if (qfVar.a(qfVar.f149794j, qfVar.f149792h) && qfVar.a(qfVar.f149795k, qfVar.f149793i)) {
                            for (int i3 = 0; i3 < a17.size(); i3++) {
                                qf.a(qfVar, a17.get(i3));
                            }
                        } else {
                            qfVar.f149786a = false;
                            qf.a(qfVar, false);
                            return;
                        }
                    }
                    qf.a(qfVar, true);
                    return;
                }
                qfVar.f149786a = false;
                qf.a(qfVar, false);
            }
        }
    }

    public qf(Context context, bi biVar, String str) {
        this.f149789d = mz.a(context, (TencentMapOptions) null);
        this.f149787b = "";
        if (biVar != null && biVar.f147819b != null && biVar.f147819b.e_ != 0) {
            this.f149787b = ((VectorMap) biVar.f147819b.e_).z();
        }
        this.f149790f = new WeakReference<>(biVar);
        this.f149791g = str;
        mv a16 = mx.a(context, str);
        this.f149788c = a16;
        if (a16 != null) {
            a16.a(new String[]{"mapPoiIconIndoorVersion", "poiIconIndoorMd5"});
        }
    }

    private List<FileUpdateRsp> b(String str, fz fzVar) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new FileUpdateReq(er.f148280i, this.f149788c.b(et.f148298a), this.f149788c.a(et.f148317t)));
        arrayList.add(new FileUpdateReq("poi_icon", this.f149788c.b(et.f148300c), this.f149788c.a(et.f148318u)));
        arrayList.add(new FileUpdateReq(er.f148281j, this.f149788c.b(et.f148301d), this.f149788c.a(et.f148319v)));
        arrayList.add(new FileUpdateReq(er.f148287p, this.f149788c.b("escalator_night_version"), this.f149788c.a("escalator_night_md5")));
        if (fzVar != null && fzVar.a()) {
            arrayList.add(new FileUpdateReq(er.f148283l, this.f149788c.b("indoormap_style_version"), this.f149788c.a("indoormap_style_md5")));
            arrayList.add(new FileUpdateReq(er.f148284m, this.f149788c.b("indoormap_style_night_version"), this.f149788c.a("indoormap_style_night_md5")));
            arrayList.add(new FileUpdateReq(er.f148285n, this.f149788c.b(et.f148316s), this.f149788c.a(et.f148322y)));
            arrayList.add(new FileUpdateReq(er.f148286o, this.f149788c.b("indoorpoi_icon_3d_night_version"), this.f149788c.a("indoorpoi_icon_3d_night_md5")));
        }
        String a16 = a();
        CSFileUpdateReq cSFileUpdateReq = new CSFileUpdateReq(arrayList, a16, ho.n(), null, this.f149787b, str);
        this.f149792h = this.f149789d.a(this.f149791g);
        this.f149793i = this.f149789d.b(this.f149791g);
        this.f149794j = this.f149789d.c(this.f149791g) + "config/";
        this.f149795k = this.f149789d.c(this.f149791g) + "assets/";
        ku.a(this.f149794j);
        ku.a(this.f149795k);
        return new qd().a(this.f149789d.c(this.f149791g) + "config/", this.f149789d.c(this.f149791g) + "assets/", a16, cSFileUpdateReq, this);
    }

    private void c() {
        mv mvVar = this.f149788c;
        if (mvVar == null) {
            return;
        }
        mvVar.a(new String[]{"mapPoiIconIndoorVersion", "poiIconIndoorMd5"});
    }

    private void a(String str, fz fzVar) {
        String a16 = a();
        if (f149785e.containsKey(a16)) {
            a(a16, this.f149790f);
            return;
        }
        a(a16, this.f149790f);
        WeakReference<bi> weakReference = this.f149790f;
        if (weakReference != null && weakReference.get() != null && this.f149790f.get().f147819b != null) {
            int i3 = this.f149790f.get().f147819b.f147934f;
            LogUtil.a(i3).b(lb.a.f149158e, "map config check update, styleIds: " + str + ", indoorAuth: " + fzVar);
            lc.a(lb.Z, i3);
        }
        kp.b(new a(this, str, fzVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(String str, String str2) {
        bi biVar;
        FileInputStream fileInputStream;
        oq oqVar;
        boolean a16;
        oq oqVar2;
        WeakReference<bi> weakReference = this.f149790f;
        if (weakReference != null && (biVar = weakReference.get()) != null && biVar.f147819b != null && biVar.f147819b.e_ != 0) {
            int i3 = biVar.f147819b.f147934f;
            VectorMap vectorMap = (VectorMap) biVar.f147819b.e_;
            File file = new File(str);
            if (file.exists() && file.isDirectory()) {
                File[] listFiles = file.listFiles();
                if (listFiles == null) {
                    LogUtil.a(i3).e(lb.a.f149158e, "moveConfigFile, tmpDirPath: " + str + ", targetDirPath: " + str2 + " tmp list files null");
                    return false;
                }
                boolean z16 = true;
                FileInputStream fileInputStream2 = null;
                for (File file2 : listFiles) {
                    try {
                        fileInputStream = new FileInputStream(file2);
                    } catch (FileNotFoundException | IOException unused) {
                    } catch (Throwable th5) {
                        th = th5;
                    }
                    try {
                        int length = (int) file2.length();
                        byte[] bArr = new byte[length];
                        fileInputStream.read(bArr, 0, length);
                        if (str2.equals(this.f149792h)) {
                            String name = file2.getName();
                            w wVar = vectorMap.f151351o.f149408u;
                            if (wVar != null && (oqVar2 = wVar.f151302b) != null) {
                                a16 = w.a(new File(oqVar2.c()), name, bArr, wVar.f151304d);
                                z16 &= a16;
                            }
                            a16 = false;
                            z16 &= a16;
                        } else if (str2.equals(this.f149793i)) {
                            String name2 = file2.getName();
                            w wVar2 = vectorMap.f151351o.f149408u;
                            if (wVar2 != null && (oqVar = wVar2.f151302b) != null) {
                                a16 = w.a(new File(oqVar.e()), name2, bArr, wVar2.f151305e);
                                z16 &= a16;
                            }
                            a16 = false;
                            z16 &= a16;
                        }
                        ku.a((Closeable) fileInputStream);
                        fileInputStream2 = fileInputStream;
                    } catch (FileNotFoundException | IOException unused2) {
                        fileInputStream2 = fileInputStream;
                        ku.a((Closeable) fileInputStream2);
                    } catch (Throwable th6) {
                        th = th6;
                        fileInputStream2 = fileInputStream;
                        ku.a((Closeable) fileInputStream2);
                        throw th;
                    }
                }
                return z16;
            }
            LogUtil.d("Config temp dir not exists:".concat(String.valueOf(str)));
            LogUtil.a(i3).e(lb.a.f149158e, "moveConfigFile, tmpDirPath: " + str + ", targetDirPath: " + str2 + " temp dir not exists");
        }
        return false;
    }

    public final WeakReference<bi>[] b() {
        List<WeakReference<bi>> list = f149785e.get(a());
        if (list == null) {
            return null;
        }
        return (WeakReference[]) list.toArray(new WeakReference[list.size()]);
    }

    private void a(boolean z16) {
        bi biVar;
        tr trVar;
        M m3;
        ne neVar;
        rq a16;
        this.f149788c.a(et.f148299b, System.currentTimeMillis());
        ku.c(this.f149794j);
        ku.c(this.f149795k);
        long currentTimeMillis = System.currentTimeMillis();
        if (!z16) {
            currentTimeMillis = 0;
        }
        List<WeakReference<bi>> list = f149785e.get(a());
        if (list == null) {
            return;
        }
        int size = list.size();
        WeakReference[] weakReferenceArr = (WeakReference[]) list.toArray(new WeakReference[size]);
        for (int i3 = 0; i3 < size; i3++) {
            WeakReference weakReference = weakReferenceArr[i3];
            if (weakReference != null && (biVar = (bi) weakReference.get()) != null && (trVar = biVar.f147819b) != null && (m3 = trVar.e_) != 0) {
                VectorMap vectorMap = (VectorMap) m3;
                hi hiVar = trVar.aC.f147918e;
                if (this.f149786a) {
                    vectorMap.u();
                    rr rrVar = biVar.f147822e;
                    if (rrVar != null && (neVar = (ne) trVar.d_) != null && (a16 = rrVar.a(rrVar.f150126f)) != null) {
                        neVar.f149398k.b(a16.f150117a);
                    }
                    vectorMap.f151351o.f149412y = true;
                    ne neVar2 = trVar.aC;
                    if (neVar2 != null) {
                        neVar2.O();
                    }
                    trVar.aG = true;
                    if (hiVar != null) {
                        hiVar.a().a(false, currentTimeMillis);
                        hiVar.a().b(z16, currentTimeMillis);
                    }
                } else if (!z16 && hiVar != null) {
                    hiVar.a().b(z16, currentTimeMillis);
                }
                vectorMap.f151350n = true;
            }
        }
        WeakReference<bi> weakReference2 = this.f149790f;
        int i16 = (weakReference2 == null || weakReference2.get() == null || this.f149790f.get().f147819b == null) ? -1 : this.f149790f.get().f147819b.f147934f;
        f149785e.clear();
        mx.b();
        lc.c(lb.Z, i16);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0064, code lost:
    
        if (r0.equals(com.tencent.mapsdk.internal.er.f148284m) == false) goto L7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(FileUpdateRsp fileUpdateRsp) {
        char c16 = 1;
        if (fileUpdateRsp.iFileUpdated != 1) {
            return;
        }
        String str = fileUpdateRsp.sName;
        str.hashCode();
        switch (str.hashCode()) {
            case -1319508241:
                if (str.equals(er.f148285n)) {
                    c16 = 0;
                    break;
                }
                c16 = '\uffff';
                break;
            case -1091367180:
                break;
            case -503063473:
                if (str.equals(er.f148287p)) {
                    c16 = 2;
                    break;
                }
                c16 = '\uffff';
                break;
            case 178735484:
                if (str.equals(er.f148281j)) {
                    c16 = 3;
                    break;
                }
                c16 = '\uffff';
                break;
            case 204802075:
                if (str.equals(er.f148283l)) {
                    c16 = 4;
                    break;
                }
                c16 = '\uffff';
                break;
            case 451944782:
                if (str.equals("poi_icon")) {
                    c16 = 5;
                    break;
                }
                c16 = '\uffff';
                break;
            case 1366209438:
                if (str.equals(er.f148280i)) {
                    c16 = 6;
                    break;
                }
                c16 = '\uffff';
                break;
            case 1864531656:
                if (str.equals(er.f148286o)) {
                    c16 = 7;
                    break;
                }
                c16 = '\uffff';
                break;
            default:
                c16 = '\uffff';
                break;
        }
        switch (c16) {
            case 0:
                this.f149788c.a(et.f148316s, fileUpdateRsp.iVersion);
                this.f149788c.a(et.f148322y, fileUpdateRsp.sMd5);
                return;
            case 1:
                this.f149788c.a("indoormap_style_night_version", fileUpdateRsp.iVersion);
                this.f149788c.a("indoormap_style_night_md5", fileUpdateRsp.sMd5);
                return;
            case 2:
                this.f149788c.a("escalator_night_version", fileUpdateRsp.iVersion);
                this.f149788c.a("escalator_night_md5", fileUpdateRsp.sMd5);
                return;
            case 3:
                this.f149788c.a(et.f148301d, fileUpdateRsp.iVersion);
                this.f149788c.a(et.f148319v, fileUpdateRsp.sMd5);
                return;
            case 4:
                this.f149788c.a("indoormap_style_version", fileUpdateRsp.iVersion);
                this.f149788c.a("indoormap_style_md5", fileUpdateRsp.sMd5);
                return;
            case 5:
                this.f149788c.a(et.f148300c, fileUpdateRsp.iVersion);
                this.f149788c.a(et.f148318u, fileUpdateRsp.sMd5);
                return;
            case 6:
                this.f149788c.a(et.f148298a, fileUpdateRsp.iVersion);
                this.f149788c.a(et.f148317t, fileUpdateRsp.sMd5);
                return;
            case 7:
                this.f149788c.a("indoorpoi_icon_3d_night_version", fileUpdateRsp.iVersion);
                this.f149788c.a("indoorpoi_icon_3d_night_md5", fileUpdateRsp.sMd5);
                return;
            default:
                return;
        }
    }

    public final String a() {
        String str = this.f149791g;
        return hs.a(str) ? ho.a() : str;
    }

    public final synchronized void a(String str, WeakReference<bi> weakReference) {
        if (f149785e.containsKey(str)) {
            List<WeakReference<bi>> list = f149785e.get(str);
            if (list != null) {
                list.add(weakReference);
            }
        } else {
            ArrayList arrayList = new ArrayList();
            arrayList.add(weakReference);
            f149785e.put(str, arrayList);
        }
    }

    static /* synthetic */ void a(qf qfVar, boolean z16) {
        bi biVar;
        tr trVar;
        M m3;
        ne neVar;
        rq a16;
        qfVar.f149788c.a(et.f148299b, System.currentTimeMillis());
        ku.c(qfVar.f149794j);
        ku.c(qfVar.f149795k);
        long currentTimeMillis = System.currentTimeMillis();
        if (!z16) {
            currentTimeMillis = 0;
        }
        List<WeakReference<bi>> list = f149785e.get(qfVar.a());
        if (list != null) {
            int size = list.size();
            WeakReference[] weakReferenceArr = (WeakReference[]) list.toArray(new WeakReference[size]);
            for (int i3 = 0; i3 < size; i3++) {
                WeakReference weakReference = weakReferenceArr[i3];
                if (weakReference != null && (biVar = (bi) weakReference.get()) != null && (trVar = biVar.f147819b) != null && (m3 = trVar.e_) != 0) {
                    VectorMap vectorMap = (VectorMap) m3;
                    hi hiVar = trVar.aC.f147918e;
                    if (qfVar.f149786a) {
                        vectorMap.u();
                        rr rrVar = biVar.f147822e;
                        if (rrVar != null && (neVar = (ne) trVar.d_) != null && (a16 = rrVar.a(rrVar.f150126f)) != null) {
                            neVar.f149398k.b(a16.f150117a);
                        }
                        vectorMap.f151351o.f149412y = true;
                        ne neVar2 = trVar.aC;
                        if (neVar2 != null) {
                            neVar2.O();
                        }
                        trVar.aG = true;
                        if (hiVar != null) {
                            hiVar.a().a(false, currentTimeMillis);
                            hiVar.a().b(z16, currentTimeMillis);
                        }
                    } else if (!z16 && hiVar != null) {
                        hiVar.a().b(z16, currentTimeMillis);
                    }
                    vectorMap.f151350n = true;
                }
            }
            WeakReference<bi> weakReference2 = qfVar.f149790f;
            int i16 = (weakReference2 == null || weakReference2.get() == null || qfVar.f149790f.get().f147819b == null) ? -1 : qfVar.f149790f.get().f147819b.f147934f;
            f149785e.clear();
            mx.b();
            lc.c(lb.Z, i16);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0063, code lost:
    
        if (r0.equals(com.tencent.mapsdk.internal.er.f148284m) == false) goto L6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static /* synthetic */ void a(qf qfVar, FileUpdateRsp fileUpdateRsp) {
        char c16 = 1;
        if (fileUpdateRsp.iFileUpdated == 1) {
            String str = fileUpdateRsp.sName;
            str.hashCode();
            switch (str.hashCode()) {
                case -1319508241:
                    if (str.equals(er.f148285n)) {
                        c16 = 0;
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case -1091367180:
                    break;
                case -503063473:
                    if (str.equals(er.f148287p)) {
                        c16 = 2;
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case 178735484:
                    if (str.equals(er.f148281j)) {
                        c16 = 3;
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case 204802075:
                    if (str.equals(er.f148283l)) {
                        c16 = 4;
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case 451944782:
                    if (str.equals("poi_icon")) {
                        c16 = 5;
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case 1366209438:
                    if (str.equals(er.f148280i)) {
                        c16 = 6;
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case 1864531656:
                    if (str.equals(er.f148286o)) {
                        c16 = 7;
                        break;
                    }
                    c16 = '\uffff';
                    break;
                default:
                    c16 = '\uffff';
                    break;
            }
            switch (c16) {
                case 0:
                    qfVar.f149788c.a(et.f148316s, fileUpdateRsp.iVersion);
                    qfVar.f149788c.a(et.f148322y, fileUpdateRsp.sMd5);
                    return;
                case 1:
                    qfVar.f149788c.a("indoormap_style_night_version", fileUpdateRsp.iVersion);
                    qfVar.f149788c.a("indoormap_style_night_md5", fileUpdateRsp.sMd5);
                    return;
                case 2:
                    qfVar.f149788c.a("escalator_night_version", fileUpdateRsp.iVersion);
                    qfVar.f149788c.a("escalator_night_md5", fileUpdateRsp.sMd5);
                    return;
                case 3:
                    qfVar.f149788c.a(et.f148301d, fileUpdateRsp.iVersion);
                    qfVar.f149788c.a(et.f148319v, fileUpdateRsp.sMd5);
                    return;
                case 4:
                    qfVar.f149788c.a("indoormap_style_version", fileUpdateRsp.iVersion);
                    qfVar.f149788c.a("indoormap_style_md5", fileUpdateRsp.sMd5);
                    return;
                case 5:
                    qfVar.f149788c.a(et.f148300c, fileUpdateRsp.iVersion);
                    qfVar.f149788c.a(et.f148318u, fileUpdateRsp.sMd5);
                    return;
                case 6:
                    qfVar.f149788c.a(et.f148298a, fileUpdateRsp.iVersion);
                    qfVar.f149788c.a(et.f148317t, fileUpdateRsp.sMd5);
                    return;
                case 7:
                    qfVar.f149788c.a("indoorpoi_icon_3d_night_version", fileUpdateRsp.iVersion);
                    qfVar.f149788c.a("indoorpoi_icon_3d_night_md5", fileUpdateRsp.sMd5);
                    return;
                default:
                    return;
            }
        }
    }
}
