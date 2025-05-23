package com.tencent.halley.downloader.task.section;

import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.gamematrix.gmcg.api.constant.GmCgConstants;
import com.tencent.halley.common.utils.d;
import com.tencent.halley.common.utils.h;
import com.tencent.halley.downloader.DownloaderTaskStatus;
import com.tencent.halley.downloader.c.g;
import com.tencent.halley.downloader.c.j;
import com.tencent.halley.downloader.f.a;
import com.tencent.halley.downloader.task.TaskDivider;
import com.tencent.halley.downloader.task.b;
import com.tencent.halley.downloader.task.d.a;
import com.tencent.halley.downloader.task.d.b;
import com.tencent.halley.downloader.task.section.b;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class c implements a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public b f113989a;

    /* renamed from: b, reason: collision with root package name */
    public b f113990b;

    /* renamed from: c, reason: collision with root package name */
    public ArrayList<b> f113991c;

    /* renamed from: d, reason: collision with root package name */
    private volatile int f113992d;

    /* renamed from: e, reason: collision with root package name */
    private long f113993e;

    /* renamed from: f, reason: collision with root package name */
    private com.tencent.halley.downloader.task.c f113994f;

    public c(com.tencent.halley.downloader.task.c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) cVar);
            return;
        }
        this.f113991c = new ArrayList<>();
        this.f113992d = 0;
        this.f113993e = 0L;
        this.f113994f = cVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x0077, code lost:
    
        r1 = r2.D;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x007b, code lost:
    
        if (r1 <= 0) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x007d, code lost:
    
        r4 = r12.f113980c;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0081, code lost:
    
        if (r4 == r1) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0083, code lost:
    
        a(r4, r0);
     */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00b6 A[Catch: all -> 0x025d, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0005, B:7:0x000d, B:11:0x0015, B:13:0x001c, B:15:0x0025, B:16:0x002e, B:18:0x0034, B:20:0x003a, B:23:0x0044, B:25:0x0053, B:28:0x005d, B:30:0x0067, B:32:0x006f, B:37:0x0077, B:39:0x007d, B:41:0x0083, B:42:0x00b2, B:44:0x00b6, B:46:0x00bc, B:48:0x00c2, B:49:0x00cf, B:50:0x0134, B:54:0x013a, B:56:0x0142, B:58:0x014a, B:61:0x014f, B:63:0x0153, B:65:0x0163, B:68:0x016a, B:70:0x0170, B:71:0x0174, B:73:0x0184, B:76:0x018b, B:78:0x0191, B:79:0x0194, B:81:0x019c, B:83:0x01a6, B:85:0x01d9, B:86:0x01dc, B:88:0x01e4, B:89:0x01ed, B:91:0x01f1, B:93:0x01f7, B:95:0x01fd, B:97:0x0203, B:99:0x0207, B:101:0x020d, B:104:0x0087, B:105:0x008b, B:107:0x0091, B:109:0x009b, B:111:0x00a5, B:112:0x00ad, B:113:0x00d9, B:115:0x00e3, B:117:0x00ed, B:118:0x00f5, B:120:0x00fd, B:121:0x0103, B:122:0x0125, B:123:0x0128, B:125:0x012e, B:127:0x0232, B:130:0x0252), top: B:2:0x0001 }] */
    @Override // com.tencent.halley.downloader.task.section.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final synchronized h a(b bVar, b.C1251b c1251b) {
        String str;
        Map<String, List<String>> map;
        b.a a16;
        b.a a17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (h) iPatchRedirector.redirect((short) 10, (Object) this, (Object) bVar, (Object) c1251b);
        }
        boolean z16 = true;
        if (this.f113994f.U) {
            com.tencent.halley.common.a.c.e();
            if (com.tencent.halley.common.a.c.g()) {
                this.f113994f.pause();
                this.f113994f.V = true;
            }
        }
        if (d(bVar) && !bVar.a() && c1251b.f113980c > 0) {
            h hVar = new h(0, "");
            TaskDivider taskDivider = this.f113994f.f113832g;
            if (taskDivider != null && taskDivider.isSelfSection(bVar.f113945a)) {
                if (this.f113994f.A == -1) {
                    com.tencent.halley.downloader.task.c cVar = this.f113994f;
                    String str2 = cVar.f113843r;
                    if (cVar.Y && cVar.f113803ab) {
                        z16 = false;
                    }
                    if (cVar.J != -1 && c1251b.f113980c != this.f113994f.J) {
                        if (this.f113994f.f113831f.f113918i > 0) {
                            a(c1251b.f113978a, c1251b.f113980c, hVar);
                        } else {
                            a(c1251b.f113980c, hVar);
                        }
                        if (hVar.f113557a == 0) {
                            com.tencent.halley.downloader.task.c cVar2 = this.f113994f;
                            if (!cVar2.Z && !cVar2.c()) {
                                com.tencent.halley.downloader.task.c cVar3 = this.f113994f;
                                cVar3.a(false, cVar3.L, this.f113994f.f113845t, DownloaderTaskStatus.FAILED);
                            }
                            this.f113994f.f113834i.a(b.a.f113782c);
                        }
                    }
                    a(bVar, c1251b, str2, hVar);
                    if (hVar.f113557a == 0) {
                    }
                } else if (c1251b.f113980c != this.f113994f.A) {
                    if (this.f113994f.f113831f.f113918i > 0) {
                        a(c1251b.f113978a, c1251b.f113980c, hVar);
                    } else if (this.f113994f.D > 0) {
                        a(c1251b.f113980c, hVar);
                    } else {
                        hVar.f113557a = -43;
                        str = "detectLength:" + this.f113994f.A + ",rspLength:" + c1251b.f113980c;
                        hVar.f113558b = str;
                    }
                } else if (!this.f113994f.Q) {
                    hVar.f113557a = 1;
                    str = "not support range";
                    hVar.f113558b = str;
                }
                if (hVar.f113557a != 0) {
                    return hVar;
                }
                if (!TextUtils.isEmpty(c1251b.f113979b)) {
                    a.EnumC1249a enumC1249a = c1251b.f113978a.f113891d;
                    if (enumC1249a != a.EnumC1249a.f113897b && enumC1249a != a.EnumC1249a.f113896a) {
                        if (enumC1249a == a.EnumC1249a.f113902g) {
                            com.tencent.halley.downloader.task.d.b bVar2 = this.f113994f.f113831f;
                            String b16 = com.tencent.halley.common.a.c.b();
                            String str3 = c1251b.f113979b;
                            if (!TextUtils.isEmpty(b16) && !TextUtils.isEmpty(str3) && (a17 = bVar2.a(b16)) != null) {
                                a17.b(str3);
                            }
                        }
                    }
                    com.tencent.halley.downloader.task.d.b bVar3 = this.f113994f.f113831f;
                    String b17 = com.tencent.halley.common.a.c.b();
                    String str4 = c1251b.f113979b;
                    if (!TextUtils.isEmpty(b17) && !TextUtils.isEmpty(str4) && (a16 = bVar3.a(b17)) != null) {
                        a16.a(str4);
                    }
                }
                if (!TextUtils.isEmpty(c1251b.f113986i)) {
                    com.tencent.halley.downloader.task.c cVar4 = this.f113994f;
                    String str5 = c1251b.f113986i;
                    if (!TextUtils.isEmpty(str5)) {
                        d.e("halley-downloader-TaskImpl_qqq", "updateCrc64 " + cVar4.f113850y + " newValue= " + str5 + ", curCrc64= " + cVar4.f113813al);
                        if (TextUtils.isEmpty(cVar4.f113813al)) {
                            cVar4.f113813al = str5;
                        } else if (!cVar4.f113813al.equals(str5)) {
                            d.e("halley-downloader-TaskImpl_qqq", "updateCrc64 ERROR!!!");
                        }
                    }
                }
                Map<String, List<String>> map2 = c1251b.f113987j;
                if (map2 != null && !map2.isEmpty()) {
                    com.tencent.halley.downloader.task.c cVar5 = this.f113994f;
                    Map<String, List<String>> map3 = c1251b.f113987j;
                    if (map3 != null && !map3.isEmpty() && ((map = cVar5.f113812ak) == null || map.isEmpty())) {
                        d.e("halley-downloader-TaskImpl_qqq", "updateHttpRspHeaderMap " + cVar5.f113850y + " rspHeaderMap= " + map3);
                        cVar5.f113812ak = map3;
                    }
                }
                return hVar;
            }
            hVar.f113557a = 2;
            hVar.f113558b = "not the same divider";
            d.d("SectionTransportControlCenter", "onValidResponse... fail...not self section:" + bVar.f113945a);
            return hVar;
        }
        return new h(4, "");
    }

    public final synchronized h b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (h) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        this.f113993e = SystemClock.elapsedRealtime();
        h hVar = new h(0, "");
        com.tencent.halley.downloader.task.c cVar = this.f113994f;
        b bVar = new b(cVar.f113831f, true, cVar, this, cVar.f113830e, cVar.Y);
        this.f113989a = bVar;
        bVar.a(this.f113994f.M);
        b bVar2 = this.f113989a;
        com.tencent.halley.downloader.task.c cVar2 = this.f113994f;
        bVar2.f113949e = cVar2.f113851z;
        try {
            bVar2.a(cVar2.f113804ac, cVar2.f113805ad, cVar2.f113806ae, cVar2, cVar2.f113807af, cVar2.f113808ag, this.f113993e);
            com.tencent.halley.downloader.f.a a16 = com.tencent.halley.downloader.f.a.a();
            com.tencent.halley.common.a.a.d dVar = a16.f113743a;
            if (dVar != null) {
                d.a("halley-downloader-SectionTransportControlCenter", "before excuteDirectDownload, DirectExecutor maxPoolSize= " + dVar.getMaximumPoolSize() + ", submittedCount= " + dVar.f113207a.get(), true);
            }
            new a.C1244a(a16.f113743a.submit(this.f113989a));
        } catch (Exception e16) {
            String str = "";
            com.tencent.halley.common.a.a.d dVar2 = com.tencent.halley.downloader.f.a.a().f113743a;
            if (dVar2 != null) {
                str = " - DirectExecutor maxPoolSize= " + dVar2.getMaximumPoolSize() + ", submittedCount= " + dVar2.f113207a.get();
            }
            this.f113989a = null;
            hVar.f113557a = -67;
            hVar.f113558b = com.tencent.halley.downloader.a.b.a((Throwable) e16) + str;
            e16.printStackTrace();
        }
        if (hVar.f113557a != 0) {
            return hVar;
        }
        if (this.f113994f.isEaseTask()) {
            return hVar;
        }
        com.tencent.halley.downloader.task.c cVar3 = this.f113994f;
        if (cVar3.f113803ab) {
            b bVar3 = new b(cVar3.f113831f, false, cVar3, this, cVar3.f113830e, cVar3.Y);
            this.f113990b = bVar3;
            bVar3.a(this.f113994f.M);
            b bVar4 = this.f113990b;
            bVar4.f113949e = this.f113994f.f113851z;
            bVar4.h();
            try {
                b bVar5 = this.f113990b;
                com.tencent.halley.downloader.task.c cVar4 = this.f113994f;
                bVar5.a(cVar4.f113804ac, cVar4.f113805ad, cVar4.f113806ae, cVar4, cVar4.f113807af, cVar4.f113808ag, this.f113993e);
                com.tencent.halley.downloader.f.a.a().a(this.f113990b);
            } catch (Exception unused) {
                this.f113990b = null;
            }
        }
        return hVar;
    }

    public final void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        try {
            b bVar = this.f113989a;
            if (bVar != null) {
                bVar.b();
            }
            b bVar2 = this.f113990b;
            if (bVar2 != null) {
                bVar2.b();
            }
            if (this.f113991c.size() > 0) {
                Iterator<b> it = this.f113991c.iterator();
                while (it.hasNext()) {
                    it.next().b();
                }
            }
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
    }

    public final String d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        StringBuilder sb5 = new StringBuilder();
        b bVar = this.f113989a;
        if (bVar != null) {
            sb5.append(bVar.f());
        }
        b bVar2 = this.f113990b;
        if (bVar2 != null) {
            sb5.append(bVar2.f());
        }
        if (this.f113991c.size() > 0) {
            Iterator<b> it = this.f113991c.iterator();
            while (it.hasNext()) {
                sb5.append(it.next().f());
            }
        }
        return sb5.toString();
    }

    public final String e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        StringBuilder sb5 = new StringBuilder();
        b bVar = this.f113989a;
        if (bVar != null) {
            sb5.append(bVar.g());
        }
        b bVar2 = this.f113990b;
        if (bVar2 != null) {
            sb5.append(bVar2.g());
        }
        if (this.f113991c.size() > 0) {
            Iterator<b> it = this.f113991c.iterator();
            while (it.hasNext()) {
                sb5.append(it.next().g());
            }
        }
        return sb5.toString();
    }

    public final String f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        StringBuilder sb5 = new StringBuilder();
        b bVar = this.f113989a;
        if (bVar != null) {
            sb5.append(bVar.i());
        }
        b bVar2 = this.f113990b;
        if (bVar2 != null) {
            sb5.append(bVar2.i());
        }
        if (this.f113991c.size() > 0) {
            Iterator<b> it = this.f113991c.iterator();
            while (it.hasNext()) {
                sb5.append(it.next().i());
            }
        }
        return sb5.toString();
    }

    private boolean d(b bVar) {
        if (bVar != null) {
            return bVar == this.f113989a || bVar == this.f113990b || this.f113991c.contains(bVar);
        }
        return false;
    }

    @Override // com.tencent.halley.downloader.task.section.a
    public final DataSection a(b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (DataSection) iPatchRedirector.redirect((short) 8, (Object) this, (Object) bVar);
        }
        if (d(bVar) && this.f113994f.Q) {
            return this.f113994f.f113832g.getNextSection();
        }
        return null;
    }

    @Override // com.tencent.halley.downloader.task.section.a
    public final void b(b bVar) {
        DataSection dataSection;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) bVar);
        } else if (d(bVar) && (dataSection = bVar.f113945a) != null) {
            this.f113994f.f113832g.releaseSection(dataSection);
        }
    }

    @Override // com.tencent.halley.downloader.task.section.a
    public final void c(b bVar) {
        boolean z16;
        b bVar2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) bVar);
            return;
        }
        if (d(bVar)) {
            synchronized (this) {
                b bVar3 = this.f113989a;
                z16 = false;
                if ((bVar3 == null || bVar3.f113956l) && (!this.f113994f.Y || (bVar2 = this.f113990b) == null || bVar2.f113956l)) {
                    if (this.f113991c.size() > 0) {
                        Iterator<b> it = this.f113991c.iterator();
                        while (it.hasNext()) {
                            if (!it.next().f113956l) {
                                break;
                            }
                        }
                    }
                    z16 = true;
                }
            }
            if (!z16 || this.f113994f.R) {
                return;
            }
            d.d("SectionTransportControlCenter", "All Transports Finished, task:" + this.f113994f.getTaskUniqueKey());
            if (this.f113994f.f113832g.isReadFinish()) {
                return;
            }
            this.f113994f.L = bVar.c();
            this.f113994f.f113845t = bVar.d();
            if (this.f113994f.L == 0) {
                this.f113994f.L = -69;
                this.f113994f.f113845t = "readLen:" + this.f113994f.f113832g.getReadLen();
            }
            this.f113994f.f113834i.a(DownloaderTaskStatus.FAILED);
        }
    }

    private void a(long j3, h hVar) {
        hVar.f113557a = -10;
        hVar.f113558b = "knownSize:" + this.f113994f.D + ",rspLength:" + j3;
    }

    private void a(com.tencent.halley.downloader.task.d.a aVar, long j3, h hVar) {
        StringBuilder sb5;
        if (aVar.f113891d == a.EnumC1249a.f113905j) {
            hVar.f113557a = -76;
            sb5 = new StringBuilder("sche size:");
        } else {
            hVar.f113557a = -73;
            sb5 = new StringBuilder("sche size:");
        }
        sb5.append(this.f113994f.f113831f.f113918i);
        sb5.append(",rsp size:");
        sb5.append(j3);
        hVar.f113558b = sb5.toString();
    }

    private void a(b bVar, b.C1251b c1251b, String str, h hVar) {
        this.f113994f.A = c1251b.f113980c;
        this.f113994f.Q = c1251b.f113981d;
        com.tencent.halley.downloader.task.c cVar = this.f113994f;
        cVar.f113843r = str;
        cVar.f113844s = c1251b.f113985h;
        cVar.f113813al = c1251b.f113986i;
        cVar.f113812ak = c1251b.f113987j;
        d.e("SectionTransportControlCenter_qqq", "firstSuccDetect, " + this.f113994f.getFileUrl() + ", crc64= " + this.f113994f.f113813al + " httpHeader= " + this.f113994f.f113812ak);
        com.tencent.halley.downloader.task.d.a aVar = bVar.f113946b;
        if (aVar != null) {
            this.f113994f.O = aVar.f113892e;
        }
        if (this.f113994f.Q) {
            com.tencent.halley.downloader.task.c cVar2 = this.f113994f;
            long j3 = cVar2.f113832g.totalLen;
            if (j3 > 0) {
                if (j3 != cVar2.A) {
                    this.f113994f.f113832g = new TaskDivider("");
                    hVar.f113557a = 3;
                    hVar.f113558b = "can not resume from cfg, start over now";
                }
            }
        } else {
            this.f113994f.f113832g = new TaskDivider("");
            bVar.f113945a = this.f113994f.f113832g.getNextSection();
        }
        TaskDivider taskDivider = this.f113994f.f113832g;
        taskDivider.totalLen = c1251b.f113980c;
        taskDivider.setEtag(c1251b.f113982e);
        this.f113994f.f113832g.setHttpLastModified(c1251b.f113983f);
        DataSection dataSection = bVar.f113945a;
        if (dataSection.parentId == -1 && dataSection.sectionId == -1) {
            this.f113994f.f113832g.addRealSection(dataSection);
        }
    }

    @Override // com.tencent.halley.downloader.task.section.a
    public final boolean a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) ? this.f113994f.A != -1 : ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
    }

    private boolean a(b bVar, long j3, byte[] bArr, int i3) {
        try {
            long j16 = i3;
            this.f113994f.f113833h.a(bVar.f113945a.sectionId, j3, bArr, j16);
            bVar.f113945a.read += j16;
            if (this.f113994f.f113832g.isReadFinish()) {
                this.f113994f.f113835j.f113759b = System.currentTimeMillis();
                j.a().b();
            }
            if (j.a().f() > 4194304) {
                this.f113994f.S = true;
                j.a().b();
                d.d("SectionTransportControlCenter", "onRangeReceiveData... _dataBuffer too large, task:" + this.f113994f.f113850y + ", try wait...");
                try {
                    this.f113994f.T = true;
                    synchronized (this.f113994f.f113836k) {
                        this.f113994f.f113836k.wait(2000L);
                    }
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
            }
            return true;
        } catch (OutOfMemoryError e17) {
            e17.printStackTrace();
            this.f113994f.a(false, -19, "append size:" + i3 + ",buffer size:" + j.a().f(), DownloaderTaskStatus.FAILED);
            return false;
        }
    }

    @Override // com.tencent.halley.downloader.task.section.a
    public final boolean a(b bVar, long j3, byte[] bArr, int i3, boolean z16) {
        b bVar2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, this, bVar, Long.valueOf(j3), bArr, Integer.valueOf(i3), Boolean.valueOf(z16))).booleanValue();
        }
        if (!d(bVar)) {
            return false;
        }
        if (i3 > 0) {
            long j16 = i3;
            this.f113994f.f113828c.addAndGet(j16);
            this.f113994f.f113829d.addAndGet(j16);
        }
        TaskDivider taskDivider = this.f113994f.f113832g;
        if (taskDivider == null || !taskDivider.isSelfSection(bVar.f113945a)) {
            return false;
        }
        if (z16) {
            d.c("SectionTransportControlCenter", "is Direct:" + bVar.f113955k + " received first data from section:" + bVar.f113945a);
            DataSection dataSection = bVar.f113945a;
            if (dataSection.sectionId == -1) {
                boolean addRealSection = this.f113994f.f113832g.addRealSection(dataSection);
                d.d("SectionTransportControlCenter", "is Direct:" + bVar.f113955k + ",addRealSection:" + bVar.f113945a + ",added:" + addRealSection + ",all sections:" + this.f113994f.f113832g);
                if (g.a().f113697a && (!bVar.f113955k || bVar.f113960p)) {
                    long totalLen = this.f113994f.getTotalLen();
                    long j17 = g.a().f113698b;
                    if (j17 <= 0) {
                        j17 = GmCgConstants.MIN_NECESSARY_STORAGE_SIZE_DEFAULT;
                    }
                    if (totalLen > j17) {
                        com.tencent.halley.downloader.task.c cVar = this.f113994f;
                        cVar.f113802aa = true;
                        if (cVar.f113803ab && cVar.Y) {
                            int i16 = this.f113992d;
                            g a16 = g.a();
                            int i17 = a16.f113701e;
                            if (i17 <= 0 || i17 > a16.f113700d) {
                                i17 = a16.f113699c;
                            }
                            if (i16 < i17) {
                                com.tencent.halley.downloader.task.c cVar2 = this.f113994f;
                                b bVar3 = new b(cVar2.f113831f, false, cVar2, this, cVar2.f113830e, cVar2.Y);
                                bVar3.a(this.f113994f.M);
                                com.tencent.halley.downloader.task.c cVar3 = this.f113994f;
                                bVar3.f113949e = cVar3.f113851z;
                                bVar3.f113960p = true;
                                try {
                                    bVar3.a(cVar3.f113804ac, cVar3.f113805ad, cVar3.f113806ae, cVar3, cVar3.f113807af, cVar3.f113808ag, this.f113993e);
                                    com.tencent.halley.downloader.f.a.a().a(bVar3);
                                    this.f113991c.add(bVar3);
                                    bVar2 = bVar3;
                                } catch (Exception unused) {
                                    bVar2 = null;
                                }
                                this.f113992d++;
                                if (this.f113992d == 1) {
                                    bVar2.h();
                                }
                            }
                        }
                    }
                }
                if (!addRealSection) {
                    return false;
                }
            }
        }
        if (i3 <= 0 || this.f113994f.isPaused()) {
            return true;
        }
        return a(bVar, j3, bArr, i3);
    }
}
