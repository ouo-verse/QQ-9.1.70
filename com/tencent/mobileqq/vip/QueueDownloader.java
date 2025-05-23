package com.tencent.mobileqq.vip;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.haoliyou.JefsClass;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.g;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes20.dex */
public final class QueueDownloader implements h, INetInfoHandler {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private DownloaderFactory.b f312752d;

    /* renamed from: e, reason: collision with root package name */
    private LinkedList<g> f312753e;

    /* renamed from: f, reason: collision with root package name */
    AtomicInteger f312754f;

    public QueueDownloader(AppRuntime appRuntime, DownloaderFactory.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appRuntime, (Object) bVar);
            return;
        }
        this.f312754f = new AtomicInteger(1);
        this.f312753e = new LinkedList<>();
        bVar = bVar == null ? new DownloaderFactory.b() : bVar;
        this.f312752d = bVar;
        if (bVar.f312718a) {
            AppNetConnInfo.registerConnectionChangeReceiver(appRuntime.getApplication(), this);
        }
    }

    private g c() {
        synchronized (this.f312753e) {
            if (!this.f312753e.isEmpty()) {
                Iterator<g> it = this.f312753e.iterator();
                while (it.hasNext()) {
                    g next = it.next();
                    if (!next.k()) {
                        next.l();
                        return next;
                    }
                }
            }
            return null;
        }
    }

    private void d(@NotNull g gVar) {
        ThreadManagerV2.postDownLoadTask(new Runnable(gVar) { // from class: com.tencent.mobileqq.vip.QueueDownloader.1
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ g f312755d;

            {
                this.f312755d = gVar;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) QueueDownloader.this, (Object) gVar);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, (Object) this);
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("QueueDownloader", 2, "doTask | run() downloadLimitCount=" + QueueDownloader.this.f312754f.get() + ",task=" + this.f312755d);
                }
                g gVar2 = this.f312755d;
                if (gVar2.f313023u && DownloaderFactory.E(gVar2.f313004c)) {
                    g gVar3 = this.f312755d;
                    gVar3.f313006d = -101;
                    gVar3.y(-1);
                    this.f312755d.n();
                    QueueDownloader.this.e(this.f312755d);
                    QueueDownloader.this.f312754f.addAndGet(-1);
                    QueueDownloader.this.b();
                    if (QLog.isColorLevel()) {
                        QLog.d("QueueDownloader", 2, "doTask | run() task is limit of failTime, task=" + this.f312755d);
                        return;
                    }
                    return;
                }
                int o16 = DownloaderFactory.o(this.f312755d, BaseApplicationImpl.getApplication().getRuntime());
                if (QLog.isColorLevel()) {
                    QLog.d("QueueDownloader", 2, "doTask | run() download task result=" + o16 + ",task=" + this.f312755d);
                }
                QueueDownloader.this.e(this.f312755d);
                QueueDownloader.this.f312754f.addAndGet(-1);
                QueueDownloader.this.b();
            }

            /* JADX WARN: Removed duplicated region for block: B:18:0x0051  */
            /* JADX WARN: Removed duplicated region for block: B:22:0x0053 A[Catch: Exception -> 0x0065, TryCatch #0 {Exception -> 0x0065, blocks: (B:10:0x0016, B:12:0x0021, B:15:0x0028, B:16:0x0037, B:19:0x005d, B:22:0x0053, B:23:0x0033), top: B:9:0x0016 }] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public String toString() {
                String str;
                int size;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (String) iPatchRedirector.redirect((short) 2, (Object) this);
                }
                try {
                    StringBuilder sb5 = new StringBuilder();
                    List<String> list = this.f312755d.f313009g;
                    if (list != null && list.size() != 0) {
                        str = this.f312755d.f313009g.get(0);
                        sb5.append("QueueDownloader");
                        sb5.append(" current task:");
                        sb5.append(str);
                        sb5.append(",downloadQueue size:");
                        if (QueueDownloader.this.f312753e != null) {
                            size = 0;
                        } else {
                            size = QueueDownloader.this.f312753e.size();
                        }
                        sb5.append(size);
                        return sb5.toString();
                    }
                    str = this.f312755d.f313004c;
                    sb5.append("QueueDownloader");
                    sb5.append(" current task:");
                    sb5.append(str);
                    sb5.append(",downloadQueue size:");
                    if (QueueDownloader.this.f312753e != null) {
                    }
                    sb5.append(size);
                    return sb5.toString();
                } catch (Exception e16) {
                    QLog.e("QueueDownloader", 1, e16, new Object[0]);
                    return super.toString();
                }
            }
        }, 2, null, false);
    }

    synchronized void b() {
        synchronized (this.f312753e) {
            Iterator<g> it = this.f312753e.iterator();
            while (true) {
                boolean z16 = true;
                if (!it.hasNext()) {
                    break;
                }
                g next = it.next();
                boolean z17 = false;
                if (next.A > 0) {
                    long currentTimeMillis = System.currentTimeMillis() / 1000;
                    if (next.k() || currentTimeMillis <= next.f313028z + next.A) {
                        z16 = false;
                    }
                    z17 = z16;
                }
                if (next.j() || z17) {
                    it.remove();
                    if (QLog.isColorLevel()) {
                        QLog.d("QueueDownloader", 2, "remove task[" + next.f313004c + "], isCancal=" + next.j() + ", timeOut=" + z17);
                    }
                }
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("QueueDownloader", 2, "doTask | downloadLimitCount=" + this.f312754f.get() + ",maxDownloadCount=3,downloadQueue size=" + this.f312753e.size());
        }
        while (this.f312754f.get() <= 3) {
            g c16 = c();
            if (c16 == null) {
                QLog.d("QueueDownloader", 2, "doTask | run() null");
                return;
            } else {
                d(c16);
                this.f312754f.addAndGet(1);
            }
        }
    }

    @Override // com.tencent.mobileqq.vip.h
    public int cancelTask(boolean z16, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, this, Boolean.valueOf(z16), str)).intValue();
        }
        QLog.d("QueueDownloader", 2, "cancelTask stopAll=" + z16 + ",key=" + str);
        synchronized (this.f312753e) {
            if (!this.f312753e.isEmpty()) {
                if (z16) {
                    Iterator<g> it = this.f312753e.iterator();
                    while (it.hasNext()) {
                        g next = it.next();
                        next.c(true);
                        next.d();
                    }
                    this.f312753e.clear();
                } else if (str != null && !TextUtils.isEmpty(str)) {
                    Iterator<g> it5 = this.f312753e.iterator();
                    ArrayList arrayList = new ArrayList();
                    while (it5.hasNext()) {
                        g next2 = it5.next();
                        if (str.equals(next2.f313004c)) {
                            if (!next2.k()) {
                                it5.remove();
                                arrayList.add(next2);
                            } else {
                                next2.c(true);
                                next2.d();
                            }
                        } else if (next2.j() && !next2.k()) {
                            it5.remove();
                            arrayList.add(next2);
                        }
                    }
                    if (arrayList.size() > 0) {
                        this.f312753e.removeAll(arrayList);
                    }
                } else {
                    return -1;
                }
            }
            return 0;
        }
    }

    public void e(g gVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) gVar);
            return;
        }
        synchronized (this.f312753e) {
            if (gVar != null) {
                if (!this.f312753e.isEmpty() && this.f312753e.contains(gVar)) {
                    if (QLog.isColorLevel()) {
                        QLog.d("QueueDownloader", 2, "removeTask | task=" + gVar);
                    }
                    gVar.d();
                    this.f312753e.remove(gVar);
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.vip.h
    public g getTask(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (g) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        }
        synchronized (this.f312753e) {
            if (str != null) {
                if (!this.f312753e.isEmpty()) {
                    Iterator<g> it = this.f312753e.iterator();
                    while (it.hasNext()) {
                        g next = it.next();
                        if (str.equals(next.f313004c)) {
                            if (QLog.isColorLevel()) {
                                QLog.d("QueueDownloader", 2, "getTask | " + str + " task find =" + next);
                            }
                            return next;
                        }
                    }
                }
            }
            if (QLog.isDebugVersion()) {
                QLog.d("QueueDownloader", 2, "getTask | " + str + " task not find");
                return null;
            }
            return null;
        }
    }

    @Override // com.tencent.mobileqq.vip.h
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
        } else {
            cancelTask(true, null);
        }
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
    public void onNetMobile2None() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        LinkedList<g> linkedList = this.f312753e;
        if (linkedList != null && linkedList.size() > 0) {
            if (QLog.isColorLevel()) {
                QLog.d("QueueDownloader", 2, "queueDownload network-onNetMobile2None");
            }
            synchronized (this.f312753e) {
                Iterator<g> it = this.f312753e.iterator();
                while (it.hasNext()) {
                    g next = it.next();
                    if (next.i() == 2) {
                        next.p();
                    }
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
    public void onNetMobile2Wifi(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) str);
        } else if (QLog.isColorLevel()) {
            QLog.d("QueueDownloader", 2, "queueDownload network-onNetMobile2Wifi");
        }
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
    public void onNetNone2Mobile(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) str);
        } else if (QLog.isColorLevel()) {
            QLog.d("QueueDownloader", 2, "queueDownload network-onNetNone2Mobile");
        }
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
    public void onNetNone2Wifi(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) str);
        } else if (QLog.isColorLevel()) {
            QLog.d("QueueDownloader", 2, "queueDownload network-onNetNone2Wifi");
        }
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
    public void onNetWifi2Mobile(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
            return;
        }
        LinkedList<g> linkedList = this.f312753e;
        if (linkedList != null && linkedList.size() > 0) {
            synchronized (this.f312753e) {
                Iterator<g> it = this.f312753e.iterator();
                while (it.hasNext()) {
                    g next = it.next();
                    if (next.i() == 2) {
                        next.q();
                    }
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
    public void onNetWifi2None() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        LinkedList<g> linkedList = this.f312753e;
        if (linkedList != null && linkedList.size() > 0) {
            if (QLog.isColorLevel()) {
                QLog.d("QueueDownloader", 2, "queueDownload network-onNetWifi2None");
            }
            synchronized (this.f312753e) {
                Iterator<g> it = this.f312753e.iterator();
                while (it.hasNext()) {
                    g next = it.next();
                    if (next.i() == 2) {
                        next.r();
                    }
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.vip.h
    public void startDownload(g gVar, f fVar, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, gVar, fVar, bundle);
            return;
        }
        if (DownloaderFactory.e(gVar) && getTask(gVar.f313004c) != gVar) {
            g task = getTask(gVar.f313004c);
            if (task != null) {
                if (task.f313001a0) {
                    gVar.u(fVar);
                    gVar.w(bundle);
                    AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
                    if (runtime != null) {
                        g.a aVar = gVar.Z;
                        if (aVar.f313030b < 0) {
                            aVar.f313030b = runtime.getLongAccountUin();
                        }
                    }
                    task.a(gVar);
                    return;
                }
                return;
            }
            gVar.u(fVar);
            gVar.w(bundle);
            AppRuntime runtime2 = BaseApplicationImpl.getApplication().getRuntime();
            if (runtime2 != null) {
                g.a aVar2 = gVar.Z;
                if (aVar2.f313030b < 0) {
                    aVar2.f313030b = runtime2.getLongAccountUin();
                }
            }
            synchronized (this.f312753e) {
                g task2 = getTask(gVar.f313004c);
                if (task2 == null) {
                    gVar.f313028z = (int) (System.currentTimeMillis() / 1000);
                    if (gVar.f313019q) {
                        this.f312753e.addFirst(gVar);
                    } else {
                        this.f312753e.addLast(gVar);
                    }
                } else if (gVar.f313019q && !task2.k() && this.f312753e.remove(task2)) {
                    this.f312753e.addFirst(task2);
                }
            }
            QLog.d("QueueDownloader", 2, "startDownload | task=" + gVar.f313004c);
            b();
        }
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        StringBuilder sb5 = new StringBuilder();
        LinkedList<g> linkedList = this.f312753e;
        if (linkedList != null && linkedList.size() > 0) {
            synchronized (this.f312753e) {
                Iterator<g> it = this.f312753e.iterator();
                while (it.hasNext()) {
                    g next = it.next();
                    sb5.append("key=");
                    sb5.append(next.f313004c);
                    List<String> list = next.f313009g;
                    if (list != null && list.size() > 0) {
                        sb5.append(",size=");
                        sb5.append(next.f313009g.size());
                        sb5.append(JefsClass.INDEX_URL);
                        sb5.append(next.f313009g.get(0));
                    }
                    sb5.append(";");
                }
            }
        }
        return "QueueDownloader task url:" + sb5.toString();
    }
}
