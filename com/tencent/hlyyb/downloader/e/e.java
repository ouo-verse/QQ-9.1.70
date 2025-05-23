package com.tencent.hlyyb.downloader.e;

import com.tencent.hlyyb.downloader.DownloaderTaskListener;
import com.tencent.hlyyb.downloader.e.c;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Iterator;
import java.util.Vector;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class e implements Runnable {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ c.a f114527a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ c f114528b;

    public e(c cVar, c.a aVar) {
        this.f114528b = cVar;
        this.f114527a = aVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) cVar, (Object) aVar);
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        h hVar;
        Vector vector;
        Vector vector2;
        h hVar2;
        h hVar3;
        Vector vector3;
        Vector vector4;
        h hVar4;
        h hVar5;
        Vector vector5;
        Vector vector6;
        h hVar6;
        h hVar7;
        Vector vector7;
        Vector vector8;
        h hVar8;
        h hVar9;
        Vector vector9;
        Vector vector10;
        h hVar10;
        h hVar11;
        Vector vector11;
        Vector vector12;
        h hVar12;
        h hVar13;
        Vector vector13;
        Vector vector14;
        h hVar14;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        switch (b.f114464b[this.f114527a.ordinal()]) {
            case 1:
                com.tencent.hlyyb.downloader.c.b f16 = com.tencent.hlyyb.downloader.c.b.f();
                hVar = this.f114528b.f114465a;
                f16.onTaskPendingMainloop(hVar);
                vector = this.f114528b.f114468d;
                synchronized (vector) {
                    vector2 = this.f114528b.f114468d;
                    Iterator it = vector2.iterator();
                    while (it.hasNext()) {
                        DownloaderTaskListener downloaderTaskListener = (DownloaderTaskListener) it.next();
                        if (downloaderTaskListener != null) {
                            hVar2 = this.f114528b.f114465a;
                            downloaderTaskListener.onTaskPendingMainloop(hVar2);
                        }
                    }
                }
                return;
            case 2:
                com.tencent.hlyyb.downloader.c.b f17 = com.tencent.hlyyb.downloader.c.b.f();
                hVar3 = this.f114528b.f114465a;
                f17.onTaskStartedMainloop(hVar3);
                vector3 = this.f114528b.f114468d;
                synchronized (vector3) {
                    vector4 = this.f114528b.f114468d;
                    Iterator it5 = vector4.iterator();
                    while (it5.hasNext()) {
                        DownloaderTaskListener downloaderTaskListener2 = (DownloaderTaskListener) it5.next();
                        if (downloaderTaskListener2 != null) {
                            hVar4 = this.f114528b.f114465a;
                            downloaderTaskListener2.onTaskStartedMainloop(hVar4);
                        }
                    }
                }
                return;
            case 3:
                com.tencent.hlyyb.downloader.c.b f18 = com.tencent.hlyyb.downloader.c.b.f();
                hVar5 = this.f114528b.f114465a;
                f18.onTaskDetectedMainloop(hVar5);
                vector5 = this.f114528b.f114468d;
                synchronized (vector5) {
                    vector6 = this.f114528b.f114468d;
                    Iterator it6 = vector6.iterator();
                    while (it6.hasNext()) {
                        DownloaderTaskListener downloaderTaskListener3 = (DownloaderTaskListener) it6.next();
                        if (downloaderTaskListener3 != null) {
                            hVar6 = this.f114528b.f114465a;
                            downloaderTaskListener3.onTaskDetectedMainloop(hVar6);
                        }
                    }
                }
                return;
            case 4:
                com.tencent.hlyyb.downloader.c.b f19 = com.tencent.hlyyb.downloader.c.b.f();
                hVar7 = this.f114528b.f114465a;
                f19.onTaskReceivedMainloop(hVar7);
                vector7 = this.f114528b.f114468d;
                synchronized (vector7) {
                    vector8 = this.f114528b.f114468d;
                    Iterator it7 = vector8.iterator();
                    while (it7.hasNext()) {
                        DownloaderTaskListener downloaderTaskListener4 = (DownloaderTaskListener) it7.next();
                        if (downloaderTaskListener4 != null) {
                            hVar8 = this.f114528b.f114465a;
                            downloaderTaskListener4.onTaskReceivedMainloop(hVar8);
                        }
                    }
                }
                return;
            case 5:
                com.tencent.hlyyb.downloader.c.b f26 = com.tencent.hlyyb.downloader.c.b.f();
                hVar9 = this.f114528b.f114465a;
                f26.onTaskPausedMainloop(hVar9);
                vector9 = this.f114528b.f114468d;
                synchronized (vector9) {
                    vector10 = this.f114528b.f114468d;
                    Iterator it8 = vector10.iterator();
                    while (it8.hasNext()) {
                        DownloaderTaskListener downloaderTaskListener5 = (DownloaderTaskListener) it8.next();
                        if (downloaderTaskListener5 != null) {
                            hVar10 = this.f114528b.f114465a;
                            downloaderTaskListener5.onTaskPausedMainloop(hVar10);
                        }
                    }
                }
                return;
            case 6:
                com.tencent.hlyyb.downloader.c.b f27 = com.tencent.hlyyb.downloader.c.b.f();
                hVar11 = this.f114528b.f114465a;
                f27.onTaskFailedMainloop(hVar11);
                vector11 = this.f114528b.f114468d;
                synchronized (vector11) {
                    vector12 = this.f114528b.f114468d;
                    Iterator it9 = vector12.iterator();
                    while (it9.hasNext()) {
                        DownloaderTaskListener downloaderTaskListener6 = (DownloaderTaskListener) it9.next();
                        if (downloaderTaskListener6 != null) {
                            hVar12 = this.f114528b.f114465a;
                            downloaderTaskListener6.onTaskFailedMainloop(hVar12);
                        }
                    }
                }
                return;
            case 7:
                com.tencent.hlyyb.downloader.c.b f28 = com.tencent.hlyyb.downloader.c.b.f();
                hVar13 = this.f114528b.f114465a;
                f28.onTaskCompletedMainloop(hVar13);
                vector13 = this.f114528b.f114468d;
                synchronized (vector13) {
                    vector14 = this.f114528b.f114468d;
                    Iterator it10 = vector14.iterator();
                    while (it10.hasNext()) {
                        DownloaderTaskListener downloaderTaskListener7 = (DownloaderTaskListener) it10.next();
                        if (downloaderTaskListener7 != null) {
                            hVar14 = this.f114528b.f114465a;
                            downloaderTaskListener7.onTaskCompletedMainloop(hVar14);
                        }
                    }
                }
                return;
            default:
                return;
        }
    }
}
