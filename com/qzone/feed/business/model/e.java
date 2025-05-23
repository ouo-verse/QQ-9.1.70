package com.qzone.feed.business.model;

import com.qzone.feed.business.service.QZoneRapidCommentService;
import com.qzone.widget.u;
import com.qzone.widget.v;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: P */
/* loaded from: classes39.dex */
public class e {

    /* renamed from: d, reason: collision with root package name */
    private static String f47154d = "RapidCommentDownloadQueue";

    /* renamed from: e, reason: collision with root package name */
    private static volatile e f47155e;

    /* renamed from: a, reason: collision with root package name */
    public boolean f47156a;

    /* renamed from: b, reason: collision with root package name */
    private a f47157b;

    /* renamed from: c, reason: collision with root package name */
    private CopyOnWriteArrayList<a> f47158c = new CopyOnWriteArrayList<>();

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class a {

        /* renamed from: a, reason: collision with root package name */
        v f47159a;

        /* renamed from: b, reason: collision with root package name */
        ArrayList<u> f47160b;

        /* renamed from: c, reason: collision with root package name */
        boolean f47161c;

        /* renamed from: d, reason: collision with root package name */
        int f47162d;

        public a(v vVar, boolean z16, boolean z17, int i3) {
            ArrayList<u> arrayList;
            if (vVar != null && (arrayList = vVar.rapidCommentTabInfoList) != null && arrayList.size() != 0) {
                if (i3 < 0 || i3 >= vVar.rapidCommentTabInfoList.size()) {
                    QZLog.i(e.f47154d, "the which/size is " + i3 + "/" + vVar.rapidCommentTabInfoList.size());
                    return;
                }
                this.f47159a = vVar;
                this.f47161c = z16;
                this.f47160b = new ArrayList<>();
                if (z17) {
                    u uVar = vVar.rapidCommentTabInfoList.get(i3);
                    if (QZoneRapidCommentService.v().B(uVar, z16)) {
                        this.f47160b.add(uVar);
                        this.f47162d = (int) (this.f47162d + uVar.rcTabId);
                        return;
                    }
                    return;
                }
                for (int i16 = 0; i16 < i3; i16++) {
                    u uVar2 = vVar.rapidCommentTabInfoList.get(i16);
                    if (QZoneRapidCommentService.v().B(uVar2, z16)) {
                        this.f47160b.add(uVar2);
                        this.f47162d = (int) (this.f47162d + uVar2.rcTabId);
                    }
                }
                return;
            }
            QZLog.i(e.f47154d, "tabList or tabList.rapidCommentTabInfoList is null");
        }
    }

    e() {
    }

    public static e c() {
        if (f47155e == null) {
            synchronized (e.class) {
                if (f47155e == null) {
                    f47155e = new e();
                }
            }
        }
        return f47155e;
    }

    public void d() {
        int i3;
        ArrayList<u> arrayList;
        if (e()) {
            a aVar = this.f47157b;
            int size = (aVar == null || (arrayList = aVar.f47160b) == null) ? 0 : arrayList.size();
            f();
            int G = u5.b.G("hasLoadRapidCommentNum", 0);
            if (this.f47156a) {
                this.f47156a = false;
                int i16 = G + size;
                v x16 = QZoneRapidCommentService.v().x();
                if (x16 != null && i16 > (i3 = x16.rcTabNum)) {
                    i16 = i3;
                }
                u5.b.q0("hasLoadRapidCommentNum", i16);
            } else {
                g();
            }
            QZLog.i(f47154d, "handleDownloadCallback, timeToStopDownload is " + this.f47156a);
        }
    }

    public boolean e() {
        return this.f47158c.size() > 0;
    }

    public void f() {
        try {
            if (e()) {
                this.f47158c.remove(this.f47157b);
                if (this.f47157b != null) {
                    QZLog.i(f47154d, "removeTask for " + this.f47157b.f47162d);
                }
            }
        } catch (Exception e16) {
            QZLog.e(f47154d, "removeTask() catch an exception.", e16);
        }
    }

    public void g() {
        ArrayList<u> arrayList;
        try {
            if (e()) {
                a aVar = this.f47158c.get(0);
                if (aVar != null && aVar.f47159a != null && (arrayList = aVar.f47160b) != null && arrayList.size() != 0) {
                    this.f47157b = aVar;
                    QZoneRapidCommentService.v().K(aVar.f47159a, aVar.f47160b, aVar.f47161c);
                    QZLog.i(f47154d, "runTask for " + aVar.f47162d);
                }
                QZLog.i(f47154d, "the RapidCommentDownloadTask is null");
                f();
                g();
            }
        } catch (Exception e16) {
            QZLog.e(f47154d, "runTask() catch an exception.", e16);
        }
    }

    public void b(a aVar) {
        ArrayList<u> arrayList;
        if (aVar != null) {
            try {
                if (aVar.f47159a != null && (arrayList = aVar.f47160b) != null && arrayList.size() != 0) {
                    Iterator<a> it = this.f47158c.iterator();
                    while (it.hasNext()) {
                        a next = it.next();
                        if (next != null && next.f47162d == aVar.f47162d) {
                            return;
                        }
                    }
                    this.f47158c.add(aVar);
                    QZLog.i(f47154d, "addTask for " + aVar.f47162d);
                    return;
                }
            } catch (Exception e16) {
                QZLog.e(f47154d, "addTask() catch an exception.", e16);
                return;
            }
        }
        QZLog.i(f47154d, "the RapidCommentDownloadTask is null");
    }
}
