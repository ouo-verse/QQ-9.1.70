package com.tencent.hlyyb.downloader.c;

import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.component.network.module.base.QDLog;
import com.tencent.hlyyb.common.HalleyException;
import com.tencent.hlyyb.common.a.a;
import com.tencent.hlyyb.common.a.e;
import com.tencent.hlyyb.downloader.DownloaderTask;
import com.tencent.hlyyb.downloader.DownloaderTaskListener;
import com.tencent.hlyyb.downloader.DownloaderTaskStatus;
import com.tencent.hlyyb.downloader.e.a;
import com.tencent.hlyyb.downloader.e.f;
import com.tencent.hlyyb.downloader.e.h;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class b implements a.InterfaceC5814a, DownloaderTaskListener, f {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name */
    public static b f114441c;

    /* renamed from: a, reason: collision with root package name */
    public Vector<h> f114442a;

    /* renamed from: b, reason: collision with root package name */
    public a.c f114443b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(17702);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        }
    }

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f114442a = new Vector<>();
        this.f114443b = new a.c(this);
        com.tencent.hlyyb.common.a.a.a(QDLog.TAG_DOWNLOAD, this);
    }

    public static synchronized b f() {
        b bVar;
        synchronized (b.class) {
            if (f114441c == null) {
                f114441c = new b();
            }
            bVar = f114441c;
        }
        return bVar;
    }

    private boolean g() {
        synchronized (this.f114442a) {
            Iterator<h> it = this.f114442a.iterator();
            while (it.hasNext()) {
                h next = it.next();
                if (next.isRunning() || next.isWaiting()) {
                    return true;
                }
            }
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0077 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0074 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List<DownloaderTask> a(boolean z16, boolean z17, boolean z18, boolean z19, boolean z26, boolean z27, boolean z28) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (List) iPatchRedirector.redirect((short) 6, this, Boolean.valueOf(z16), Boolean.valueOf(z17), Boolean.valueOf(z18), Boolean.valueOf(z19), Boolean.valueOf(z26), Boolean.valueOf(z27), Boolean.valueOf(z28));
        }
        LinkedList linkedList = new LinkedList();
        synchronized (this.f114442a) {
            Iterator<h> it = this.f114442a.iterator();
            while (it.hasNext()) {
                h next = it.next();
                if (next.isEaseTask()) {
                    if (z17) {
                        if (next.isRunning()) {
                            if (next.isWaiting()) {
                                if (z19) {
                                    linkedList.add(next);
                                }
                            } else if (next.isPaused()) {
                                if (z26) {
                                    linkedList.add(next);
                                }
                            } else if (next.isFailed()) {
                                if (z27) {
                                    linkedList.add(next);
                                }
                            } else if (next.isCompleted() && z28) {
                                linkedList.add(next);
                            }
                        } else if (z18) {
                            linkedList.add(next);
                        }
                    }
                } else if (z16) {
                    if (next.isRunning()) {
                    }
                }
            }
        }
        return linkedList;
    }

    public final void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        a.c cVar = this.f114443b;
        if (cVar != null) {
            cVar.f();
        }
    }

    public final List<DownloaderTask> c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (List) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        LinkedList linkedList = new LinkedList();
        synchronized (this.f114442a) {
            linkedList.addAll(this.f114442a);
        }
        return linkedList;
    }

    public final List<DownloaderTask> d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (List) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        LinkedList linkedList = new LinkedList();
        synchronized (this.f114442a) {
            Iterator<h> it = this.f114442a.iterator();
            while (it.hasNext()) {
                h next = it.next();
                if (next.isRunning()) {
                    linkedList.add(next);
                }
            }
        }
        return linkedList;
    }

    public final long e() {
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Long) iPatchRedirector.redirect((short) 11, (Object) this)).longValue();
        }
        synchronized (this.f114442a) {
            Iterator<h> it = this.f114442a.iterator();
            j3 = 0;
            while (it.hasNext()) {
                h next = it.next();
                if (next.isRunning()) {
                    j3 += next.t();
                }
            }
        }
        return j3;
    }

    @Override // com.tencent.hlyyb.downloader.DownloaderTaskListener
    public final void onTaskCompletedMainloop(DownloaderTask downloaderTask) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) downloaderTask);
        } else if (g()) {
            this.f114443b.a();
        } else {
            this.f114443b.e();
        }
    }

    @Override // com.tencent.hlyyb.downloader.DownloaderTaskListener
    public final void onTaskCompletedSubloop(DownloaderTask downloaderTask) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, (Object) downloaderTask);
        } else {
            a((h) downloaderTask, 0);
        }
    }

    @Override // com.tencent.hlyyb.downloader.DownloaderTaskListener
    public final void onTaskDetectedMainloop(DownloaderTask downloaderTask) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) downloaderTask);
        }
    }

    @Override // com.tencent.hlyyb.downloader.DownloaderTaskListener
    public final void onTaskDetectedSubloop(DownloaderTask downloaderTask) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) downloaderTask);
        }
    }

    @Override // com.tencent.hlyyb.downloader.DownloaderTaskListener
    public final void onTaskFailedMainloop(DownloaderTask downloaderTask) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) downloaderTask);
        } else if (g()) {
            this.f114443b.a();
        } else {
            this.f114443b.e();
        }
    }

    @Override // com.tencent.hlyyb.downloader.DownloaderTaskListener
    public final void onTaskFailedSubloop(DownloaderTask downloaderTask) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) downloaderTask);
        } else {
            a((h) downloaderTask, 1);
        }
    }

    @Override // com.tencent.hlyyb.downloader.DownloaderTaskListener
    public final void onTaskPausedMainloop(DownloaderTask downloaderTask) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) downloaderTask);
        } else if (g()) {
            this.f114443b.a();
        } else {
            this.f114443b.e();
        }
    }

    @Override // com.tencent.hlyyb.downloader.DownloaderTaskListener
    public final void onTaskPausedSubloop(DownloaderTask downloaderTask) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) downloaderTask);
        } else {
            a((h) downloaderTask, 2);
        }
    }

    @Override // com.tencent.hlyyb.downloader.DownloaderTaskListener
    public final void onTaskPendingMainloop(DownloaderTask downloaderTask) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) downloaderTask);
        }
    }

    @Override // com.tencent.hlyyb.downloader.DownloaderTaskListener
    public final void onTaskReceivedMainloop(DownloaderTask downloaderTask) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) downloaderTask);
        }
    }

    @Override // com.tencent.hlyyb.downloader.DownloaderTaskListener
    public final void onTaskReceivedSubloop(DownloaderTask downloaderTask) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) downloaderTask);
        }
    }

    @Override // com.tencent.hlyyb.downloader.DownloaderTaskListener
    public final void onTaskStartedMainloop(DownloaderTask downloaderTask) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) downloaderTask);
        } else if (g()) {
            this.f114443b.a();
        } else {
            this.f114443b.e();
        }
    }

    @Override // com.tencent.hlyyb.downloader.DownloaderTaskListener
    public final void onTaskStartedSubloop(DownloaderTask downloaderTask) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) downloaderTask);
        }
    }

    @Override // com.tencent.hlyyb.common.a.a.InterfaceC5814a
    public final void a(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, i3, (Object) str);
            return;
        }
        List<DownloaderTask> d16 = d();
        if (d16.size() > 0) {
            Iterator<DownloaderTask> it = d16.iterator();
            while (it.hasNext()) {
                ((h) it.next()).a(i3, str);
            }
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(12:14|15|(1:17)|18|(1:20)|21|(4:23|(2:24|(3:26|(5:28|29|(1:31)(1:47)|32|(2:34|35)(1:45))(1:48)|46)(1:49))|36|(2:38|39))|50|af|57|58|39) */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00bc, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00bd, code lost:
    
        r0 = r0.getLocalizedMessage();
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00c3, code lost:
    
        monitor-enter(r5.f114442a);
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00c4, code lost:
    
        r5.f114442a.remove(r6);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(DownloaderTask downloaderTask) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) downloaderTask);
            return;
        }
        String str = "";
        if (downloaderTask == null || !(downloaderTask instanceof h)) {
            str = "param task not illegal.";
        } else {
            h hVar = (h) downloaderTask;
            synchronized (this) {
                if (com.tencent.hlyyb.common.b.b.a(hVar.f114607n)) {
                    hVar.f114607n = "";
                }
                if (hVar.f114607n.contains("../")) {
                    hVar.f114607n = hVar.f114607n.replace("../", "");
                }
                if (com.tencent.hlyyb.downloader.a.b.g(hVar.f114607n)) {
                    Iterator<DownloaderTask> it = c().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        DownloaderTask next = it.next();
                        if (hVar.f114605m.equalsIgnoreCase(next.getSaveDir())) {
                            if (hVar.f114607n.equalsIgnoreCase(com.tencent.hlyyb.downloader.a.b.g(((h) next).f114607n) ? next.getInitSaveName() : next.getRealSaveName())) {
                                str = "Can not add new task, another task exists with the same path:" + hVar.f114605m + "/" + hVar.f114607n;
                                break;
                            }
                        }
                    }
                    if (!"".equals(str)) {
                    }
                }
                synchronized (this.f114442a) {
                    this.f114442a.add(hVar);
                }
                hVar.o();
            }
        }
        if (!"".equals(str)) {
            throw new HalleyException(str);
        }
    }

    public final void a(DownloaderTask downloaderTask, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, downloaderTask, Boolean.valueOf(z16));
            return;
        }
        if (downloaderTask == null) {
            return;
        }
        h hVar = (h) downloaderTask;
        hVar.a(z16);
        synchronized (this.f114442a) {
            this.f114442a.remove(downloaderTask);
        }
        if (downloaderTask.getStatus() != DownloaderTaskStatus.COMPLETE) {
            a(hVar, 3);
        }
        if (g()) {
            this.f114443b.a();
        } else {
            this.f114443b.e();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:121:0x0381 A[Catch: all -> 0x04f6, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x04f6, blocks: (B:6:0x0006, B:9:0x0013, B:12:0x0020, B:15:0x002b, B:17:0x0041, B:19:0x0055, B:21:0x006b, B:23:0x0081, B:26:0x009f, B:28:0x00b3, B:31:0x00c5, B:32:0x00d6, B:35:0x00e1, B:36:0x00f2, B:39:0x00fd, B:40:0x010e, B:43:0x0119, B:45:0x012d, B:47:0x0137, B:49:0x014b, B:53:0x0164, B:54:0x0175, B:57:0x0180, B:59:0x0194, B:61:0x01a6, B:63:0x01b8, B:66:0x01ca, B:68:0x01de, B:70:0x01f4, B:72:0x020a, B:74:0x0224, B:78:0x0244, B:80:0x0259, B:81:0x025f, B:83:0x0265, B:88:0x0272, B:90:0x0284, B:92:0x029a, B:94:0x02ae, B:97:0x02ca, B:99:0x02d3, B:101:0x02e8, B:105:0x02f1, B:112:0x033a, B:114:0x0341, B:116:0x0355, B:118:0x0367, B:121:0x0381, B:123:0x039a, B:125:0x03ac, B:127:0x03c9, B:128:0x03df, B:130:0x03e7, B:134:0x03f2, B:135:0x0405, B:139:0x0412, B:140:0x0425, B:142:0x042b, B:144:0x0434, B:146:0x044a, B:149:0x0468, B:151:0x047c, B:153:0x0486, B:155:0x0497, B:156:0x049d, B:158:0x04a7, B:160:0x04b0, B:162:0x04c6, B:164:0x04cc, B:165:0x04d2, B:167:0x04dc, B:170:0x04f2, B:174:0x0311, B:176:0x0327), top: B:5:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:127:0x03c9 A[Catch: all -> 0x04f6, TryCatch #0 {all -> 0x04f6, blocks: (B:6:0x0006, B:9:0x0013, B:12:0x0020, B:15:0x002b, B:17:0x0041, B:19:0x0055, B:21:0x006b, B:23:0x0081, B:26:0x009f, B:28:0x00b3, B:31:0x00c5, B:32:0x00d6, B:35:0x00e1, B:36:0x00f2, B:39:0x00fd, B:40:0x010e, B:43:0x0119, B:45:0x012d, B:47:0x0137, B:49:0x014b, B:53:0x0164, B:54:0x0175, B:57:0x0180, B:59:0x0194, B:61:0x01a6, B:63:0x01b8, B:66:0x01ca, B:68:0x01de, B:70:0x01f4, B:72:0x020a, B:74:0x0224, B:78:0x0244, B:80:0x0259, B:81:0x025f, B:83:0x0265, B:88:0x0272, B:90:0x0284, B:92:0x029a, B:94:0x02ae, B:97:0x02ca, B:99:0x02d3, B:101:0x02e8, B:105:0x02f1, B:112:0x033a, B:114:0x0341, B:116:0x0355, B:118:0x0367, B:121:0x0381, B:123:0x039a, B:125:0x03ac, B:127:0x03c9, B:128:0x03df, B:130:0x03e7, B:134:0x03f2, B:135:0x0405, B:139:0x0412, B:140:0x0425, B:142:0x042b, B:144:0x0434, B:146:0x044a, B:149:0x0468, B:151:0x047c, B:153:0x0486, B:155:0x0497, B:156:0x049d, B:158:0x04a7, B:160:0x04b0, B:162:0x04c6, B:164:0x04cc, B:165:0x04d2, B:167:0x04dc, B:170:0x04f2, B:174:0x0311, B:176:0x0327), top: B:5:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:138:0x040f  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x042b A[Catch: all -> 0x04f6, TRY_LEAVE, TryCatch #0 {all -> 0x04f6, blocks: (B:6:0x0006, B:9:0x0013, B:12:0x0020, B:15:0x002b, B:17:0x0041, B:19:0x0055, B:21:0x006b, B:23:0x0081, B:26:0x009f, B:28:0x00b3, B:31:0x00c5, B:32:0x00d6, B:35:0x00e1, B:36:0x00f2, B:39:0x00fd, B:40:0x010e, B:43:0x0119, B:45:0x012d, B:47:0x0137, B:49:0x014b, B:53:0x0164, B:54:0x0175, B:57:0x0180, B:59:0x0194, B:61:0x01a6, B:63:0x01b8, B:66:0x01ca, B:68:0x01de, B:70:0x01f4, B:72:0x020a, B:74:0x0224, B:78:0x0244, B:80:0x0259, B:81:0x025f, B:83:0x0265, B:88:0x0272, B:90:0x0284, B:92:0x029a, B:94:0x02ae, B:97:0x02ca, B:99:0x02d3, B:101:0x02e8, B:105:0x02f1, B:112:0x033a, B:114:0x0341, B:116:0x0355, B:118:0x0367, B:121:0x0381, B:123:0x039a, B:125:0x03ac, B:127:0x03c9, B:128:0x03df, B:130:0x03e7, B:134:0x03f2, B:135:0x0405, B:139:0x0412, B:140:0x0425, B:142:0x042b, B:144:0x0434, B:146:0x044a, B:149:0x0468, B:151:0x047c, B:153:0x0486, B:155:0x0497, B:156:0x049d, B:158:0x04a7, B:160:0x04b0, B:162:0x04c6, B:164:0x04cc, B:165:0x04d2, B:167:0x04dc, B:170:0x04f2, B:174:0x0311, B:176:0x0327), top: B:5:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0465  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0497 A[Catch: all -> 0x04f6, TryCatch #0 {all -> 0x04f6, blocks: (B:6:0x0006, B:9:0x0013, B:12:0x0020, B:15:0x002b, B:17:0x0041, B:19:0x0055, B:21:0x006b, B:23:0x0081, B:26:0x009f, B:28:0x00b3, B:31:0x00c5, B:32:0x00d6, B:35:0x00e1, B:36:0x00f2, B:39:0x00fd, B:40:0x010e, B:43:0x0119, B:45:0x012d, B:47:0x0137, B:49:0x014b, B:53:0x0164, B:54:0x0175, B:57:0x0180, B:59:0x0194, B:61:0x01a6, B:63:0x01b8, B:66:0x01ca, B:68:0x01de, B:70:0x01f4, B:72:0x020a, B:74:0x0224, B:78:0x0244, B:80:0x0259, B:81:0x025f, B:83:0x0265, B:88:0x0272, B:90:0x0284, B:92:0x029a, B:94:0x02ae, B:97:0x02ca, B:99:0x02d3, B:101:0x02e8, B:105:0x02f1, B:112:0x033a, B:114:0x0341, B:116:0x0355, B:118:0x0367, B:121:0x0381, B:123:0x039a, B:125:0x03ac, B:127:0x03c9, B:128:0x03df, B:130:0x03e7, B:134:0x03f2, B:135:0x0405, B:139:0x0412, B:140:0x0425, B:142:0x042b, B:144:0x0434, B:146:0x044a, B:149:0x0468, B:151:0x047c, B:153:0x0486, B:155:0x0497, B:156:0x049d, B:158:0x04a7, B:160:0x04b0, B:162:0x04c6, B:164:0x04cc, B:165:0x04d2, B:167:0x04dc, B:170:0x04f2, B:174:0x0311, B:176:0x0327), top: B:5:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:158:0x04a7 A[Catch: all -> 0x04f6, TRY_LEAVE, TryCatch #0 {all -> 0x04f6, blocks: (B:6:0x0006, B:9:0x0013, B:12:0x0020, B:15:0x002b, B:17:0x0041, B:19:0x0055, B:21:0x006b, B:23:0x0081, B:26:0x009f, B:28:0x00b3, B:31:0x00c5, B:32:0x00d6, B:35:0x00e1, B:36:0x00f2, B:39:0x00fd, B:40:0x010e, B:43:0x0119, B:45:0x012d, B:47:0x0137, B:49:0x014b, B:53:0x0164, B:54:0x0175, B:57:0x0180, B:59:0x0194, B:61:0x01a6, B:63:0x01b8, B:66:0x01ca, B:68:0x01de, B:70:0x01f4, B:72:0x020a, B:74:0x0224, B:78:0x0244, B:80:0x0259, B:81:0x025f, B:83:0x0265, B:88:0x0272, B:90:0x0284, B:92:0x029a, B:94:0x02ae, B:97:0x02ca, B:99:0x02d3, B:101:0x02e8, B:105:0x02f1, B:112:0x033a, B:114:0x0341, B:116:0x0355, B:118:0x0367, B:121:0x0381, B:123:0x039a, B:125:0x03ac, B:127:0x03c9, B:128:0x03df, B:130:0x03e7, B:134:0x03f2, B:135:0x0405, B:139:0x0412, B:140:0x0425, B:142:0x042b, B:144:0x0434, B:146:0x044a, B:149:0x0468, B:151:0x047c, B:153:0x0486, B:155:0x0497, B:156:0x049d, B:158:0x04a7, B:160:0x04b0, B:162:0x04c6, B:164:0x04cc, B:165:0x04d2, B:167:0x04dc, B:170:0x04f2, B:174:0x0311, B:176:0x0327), top: B:5:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:169:0x04f1  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x02ca A[Catch: all -> 0x04f6, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x04f6, blocks: (B:6:0x0006, B:9:0x0013, B:12:0x0020, B:15:0x002b, B:17:0x0041, B:19:0x0055, B:21:0x006b, B:23:0x0081, B:26:0x009f, B:28:0x00b3, B:31:0x00c5, B:32:0x00d6, B:35:0x00e1, B:36:0x00f2, B:39:0x00fd, B:40:0x010e, B:43:0x0119, B:45:0x012d, B:47:0x0137, B:49:0x014b, B:53:0x0164, B:54:0x0175, B:57:0x0180, B:59:0x0194, B:61:0x01a6, B:63:0x01b8, B:66:0x01ca, B:68:0x01de, B:70:0x01f4, B:72:0x020a, B:74:0x0224, B:78:0x0244, B:80:0x0259, B:81:0x025f, B:83:0x0265, B:88:0x0272, B:90:0x0284, B:92:0x029a, B:94:0x02ae, B:97:0x02ca, B:99:0x02d3, B:101:0x02e8, B:105:0x02f1, B:112:0x033a, B:114:0x0341, B:116:0x0355, B:118:0x0367, B:121:0x0381, B:123:0x039a, B:125:0x03ac, B:127:0x03c9, B:128:0x03df, B:130:0x03e7, B:134:0x03f2, B:135:0x0405, B:139:0x0412, B:140:0x0425, B:142:0x042b, B:144:0x0434, B:146:0x044a, B:149:0x0468, B:151:0x047c, B:153:0x0486, B:155:0x0497, B:156:0x049d, B:158:0x04a7, B:160:0x04b0, B:162:0x04c6, B:164:0x04cc, B:165:0x04d2, B:167:0x04dc, B:170:0x04f2, B:174:0x0311, B:176:0x0327), top: B:5:0x0006 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(h hVar, int i3) {
        long j3;
        int length;
        int length2;
        String C;
        String D;
        if (hVar == null) {
            return;
        }
        try {
            HashMap hashMap = new HashMap();
            int failCode = hVar.getFailCode();
            if (i3 == 0) {
                failCode = 0;
            }
            String str = hVar.isEaseTask() ? "HLDownTiny" : "B_DLSDK_Result";
            if (e.a(e.a(str, failCode, false))) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append(com.tencent.hlyyb.common.a.b());
                hashMap.put(Constants.BASE_IN_PLUGIN_ID, sb5.toString());
                hashMap.put("B1", hVar.f114619t);
                hashMap.put("B2", com.tencent.hlyyb.common.b.b.d());
                hashMap.put("B3", com.tencent.hlyyb.common.b.b.e());
                StringBuilder sb6 = new StringBuilder();
                sb6.append(com.tencent.hlyyb.common.b.b.f());
                hashMap.put("B4", sb6.toString());
                if (!TextUtils.isEmpty(com.tencent.hlyyb.downloader.a.b.f114393a)) {
                    hashMap.put("B5", com.tencent.hlyyb.downloader.a.b.f114393a);
                }
                hashMap.put("B6", com.tencent.hlyyb.common.a.e());
                if (!TextUtils.isEmpty(hVar.f114585c)) {
                    hashMap.put("B7", hVar.f114585c);
                }
                if (!TextUtils.isEmpty(hVar.f114587d)) {
                    hashMap.put("B8", hVar.f114587d);
                }
                if (!TextUtils.isEmpty(com.tencent.hlyyb.downloader.a.b.f114394b)) {
                    hashMap.put("B9", com.tencent.hlyyb.downloader.a.b.f114394b);
                }
                if (!TextUtils.isEmpty(com.tencent.hlyyb.downloader.a.b.f114395c)) {
                    hashMap.put("B10", com.tencent.hlyyb.downloader.a.b.f114395c);
                }
                hashMap.put("C13", hVar.getSavePath());
                StringBuilder sb7 = new StringBuilder();
                sb7.append(hVar.f114601k);
                hashMap.put("B14", sb7.toString());
                StringBuilder sb8 = new StringBuilder();
                sb8.append(hVar.f114611p);
                hashMap.put("B15", sb8.toString());
                if (hVar.f114581a != -1) {
                    StringBuilder sb9 = new StringBuilder();
                    sb9.append(hVar.f114581a);
                    hashMap.put("B18", sb9.toString());
                }
                if (!TextUtils.isEmpty(hVar.f114583b)) {
                    hashMap.put("B19", hVar.f114583b);
                }
                StringBuilder sb10 = new StringBuilder();
                sb10.append(failCode);
                hashMap.put("B21", sb10.toString());
                StringBuilder sb11 = new StringBuilder();
                sb11.append(i3);
                hashMap.put("B22", sb11.toString());
                hashMap.put("B23", hVar.z());
                if (!TextUtils.isEmpty(hVar.Y)) {
                    hashMap.put("B24", hVar.Y);
                }
                StringBuilder sb12 = new StringBuilder();
                sb12.append(com.tencent.hlyyb.common.a.a.f());
                hashMap.put("B25", sb12.toString());
                StringBuilder sb13 = new StringBuilder();
                sb13.append(hVar.isSupportRange() ? 1 : 0);
                hashMap.put("B28", sb13.toString());
                StringBuilder sb14 = new StringBuilder();
                sb14.append(hVar.getCategory().ordinal());
                hashMap.put("B85", sb14.toString());
                StringBuilder sb15 = new StringBuilder();
                sb15.append(hVar.u());
                hashMap.put("B33", sb15.toString());
                if (hVar.getKnownSize() > 0) {
                    StringBuilder sb16 = new StringBuilder();
                    sb16.append(hVar.getKnownSize());
                    hashMap.put("B34", sb16.toString());
                }
                if (i3 != 0) {
                    hVar.D = SystemClock.elapsedRealtime();
                }
                long j16 = hVar.C;
                if (j16 > 0) {
                    long j17 = hVar.D;
                    if (j17 > j16) {
                        j3 = j17 - j16;
                        StringBuilder sb17 = new StringBuilder();
                        sb17.append(j3);
                        hashMap.put("B38", sb17.toString());
                        StringBuilder sb18 = new StringBuilder();
                        sb18.append(hVar.getReceivedLength());
                        hashMap.put("B41", sb18.toString());
                        StringBuilder sb19 = new StringBuilder();
                        sb19.append(hVar.f114621u);
                        hashMap.put("B44", sb19.toString());
                        StringBuilder sb20 = new StringBuilder();
                        sb20.append(hVar.f114623v.getAndSet(0L));
                        hashMap.put("B45", sb20.toString());
                        if (hVar.T) {
                            hashMap.put("B46", "1");
                        }
                        StringBuilder sb21 = new StringBuilder();
                        sb21.append(hVar.q());
                        hashMap.put("B66", sb21.toString());
                        if (i3 == 0 && hVar.f114586c0 > 0) {
                            StringBuilder sb22 = new StringBuilder();
                            sb22.append(hVar.f114586c0);
                            hashMap.put("B77", sb22.toString());
                        }
                        if (failCode != -40 || failCode == -12 || failCode == -45) {
                            StringBuilder sb23 = new StringBuilder();
                            sb23.append(e.b());
                            hashMap.put("C11", sb23.toString());
                            StringBuilder sb24 = new StringBuilder();
                            sb24.append(e.a());
                            hashMap.put("C12", sb24.toString());
                        }
                        long currentTimeMillis = System.currentTimeMillis();
                        StringBuilder sb25 = new StringBuilder();
                        sb25.append(hVar.B);
                        hashMap.put("C16", sb25.toString());
                        StringBuilder sb26 = new StringBuilder();
                        sb26.append(currentTimeMillis);
                        hashMap.put("C17", sb26.toString());
                        hashMap.put("C20", com.tencent.hlyyb.common.b.b.b(hVar.getFailInfo()));
                        String w3 = hVar.w();
                        length = w3.length();
                        if (length > 600) {
                            w3 = w3.substring(0, 600) + "|" + length;
                        }
                        hashMap.put("C26", w3);
                        StringBuilder sb27 = new StringBuilder();
                        sb27.append(hVar.f114582a0);
                        hashMap.put("C27", sb27.toString());
                        String x16 = hVar.x();
                        length2 = x16.length();
                        if (length2 > 2000) {
                            x16 = x16.substring(0, 2000) + "|" + length2;
                        }
                        hashMap.put("C37", x16);
                        if (i3 == 0 && hVar.p() > 1000) {
                            StringBuilder sb28 = new StringBuilder();
                            sb28.append(hVar.p());
                            hashMap.put("C48", sb28.toString());
                        }
                        if (hVar.s() > 1000) {
                            StringBuilder sb29 = new StringBuilder();
                            sb29.append(hVar.s());
                            hashMap.put("C72", sb29.toString());
                        }
                        if (hVar.r()) {
                            hashMap.put("C74", "1");
                        }
                        hashMap.put("C78", hVar.y());
                        hashMap.put("C79", hVar.v());
                        if (!TextUtils.isEmpty(hVar.U)) {
                            hashMap.put("C80", hVar.U);
                        }
                        hashMap.put("B90", hVar.A());
                        hashMap.put("B91", hVar.B());
                        C = hVar.C();
                        if (!TextUtils.isEmpty(C)) {
                            hashMap.put("C92", C);
                        }
                        D = hVar.D();
                        if (!TextUtils.isEmpty(D)) {
                            hashMap.put("C93", D);
                        }
                        StringBuilder sb30 = new StringBuilder();
                        sb30.append(hVar.F());
                        hashMap.put("C94", sb30.toString());
                        if (i3 == 2 && hVar.isPausedOnMobile()) {
                            hashMap.put("B87", "1");
                        }
                        hashMap.put(Constants.BASE_IN_PLUGIN_ID, com.tencent.hlyyb.common.a.c());
                        StringBuilder sb31 = new StringBuilder();
                        sb31.append(com.tencent.hlyyb.common.a.d());
                        hashMap.put(Constants.BASE_IN_PLUGIN_VERSION, sb31.toString());
                        e.a(str, failCode == 0, hashMap);
                    }
                }
                j3 = -1;
                StringBuilder sb172 = new StringBuilder();
                sb172.append(j3);
                hashMap.put("B38", sb172.toString());
                StringBuilder sb182 = new StringBuilder();
                sb182.append(hVar.getReceivedLength());
                hashMap.put("B41", sb182.toString());
                StringBuilder sb192 = new StringBuilder();
                sb192.append(hVar.f114621u);
                hashMap.put("B44", sb192.toString());
                StringBuilder sb202 = new StringBuilder();
                sb202.append(hVar.f114623v.getAndSet(0L));
                hashMap.put("B45", sb202.toString());
                if (hVar.T) {
                }
                StringBuilder sb212 = new StringBuilder();
                sb212.append(hVar.q());
                hashMap.put("B66", sb212.toString());
                if (i3 == 0) {
                    StringBuilder sb222 = new StringBuilder();
                    sb222.append(hVar.f114586c0);
                    hashMap.put("B77", sb222.toString());
                }
                if (failCode != -40) {
                }
                StringBuilder sb232 = new StringBuilder();
                sb232.append(e.b());
                hashMap.put("C11", sb232.toString());
                StringBuilder sb242 = new StringBuilder();
                sb242.append(e.a());
                hashMap.put("C12", sb242.toString());
                long currentTimeMillis2 = System.currentTimeMillis();
                StringBuilder sb252 = new StringBuilder();
                sb252.append(hVar.B);
                hashMap.put("C16", sb252.toString());
                StringBuilder sb262 = new StringBuilder();
                sb262.append(currentTimeMillis2);
                hashMap.put("C17", sb262.toString());
                hashMap.put("C20", com.tencent.hlyyb.common.b.b.b(hVar.getFailInfo()));
                String w36 = hVar.w();
                length = w36.length();
                if (length > 600) {
                }
                hashMap.put("C26", w36);
                StringBuilder sb272 = new StringBuilder();
                sb272.append(hVar.f114582a0);
                hashMap.put("C27", sb272.toString());
                String x162 = hVar.x();
                length2 = x162.length();
                if (length2 > 2000) {
                }
                hashMap.put("C37", x162);
                if (i3 == 0) {
                    StringBuilder sb282 = new StringBuilder();
                    sb282.append(hVar.p());
                    hashMap.put("C48", sb282.toString());
                }
                if (hVar.s() > 1000) {
                }
                if (hVar.r()) {
                }
                hashMap.put("C78", hVar.y());
                hashMap.put("C79", hVar.v());
                if (!TextUtils.isEmpty(hVar.U)) {
                }
                hashMap.put("B90", hVar.A());
                hashMap.put("B91", hVar.B());
                C = hVar.C();
                if (!TextUtils.isEmpty(C)) {
                }
                D = hVar.D();
                if (!TextUtils.isEmpty(D)) {
                }
                StringBuilder sb302 = new StringBuilder();
                sb302.append(hVar.F());
                hashMap.put("C94", sb302.toString());
                if (i3 == 2) {
                    hashMap.put("B87", "1");
                }
                hashMap.put(Constants.BASE_IN_PLUGIN_ID, com.tencent.hlyyb.common.a.c());
                StringBuilder sb312 = new StringBuilder();
                sb312.append(com.tencent.hlyyb.common.a.d());
                hashMap.put(Constants.BASE_IN_PLUGIN_VERSION, sb312.toString());
                e.a(str, failCode == 0, hashMap);
            }
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
    }

    public final void a(String str, boolean z16) {
        h hVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, str, Boolean.valueOf(z16));
            return;
        }
        synchronized (this.f114442a) {
            Iterator<h> it = this.f114442a.iterator();
            while (true) {
                if (!it.hasNext()) {
                    hVar = null;
                    break;
                } else {
                    hVar = it.next();
                    if (hVar.getUniqueKey().equals(str)) {
                        break;
                    }
                }
            }
        }
        if (hVar != null) {
            a(hVar, z16);
        }
    }

    @Override // com.tencent.hlyyb.downloader.e.f
    public final boolean a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        List<DownloaderTask> d16 = d();
        int size = d16.size();
        Iterator<DownloaderTask> it = d16.iterator();
        boolean z16 = false;
        while (it.hasNext()) {
            h hVar = (h) it.next();
            hVar.a(size);
            if (hVar.isRunning() ? hVar.n() : false) {
                z16 = true;
            }
        }
        return z16;
    }
}
