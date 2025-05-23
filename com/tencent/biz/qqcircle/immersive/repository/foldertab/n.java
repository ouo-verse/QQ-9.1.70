package com.tencent.biz.qqcircle.immersive.repository.foldertab;

import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.beans.QCircleTabInfo;
import com.tencent.biz.qqcircle.immersive.repository.foldertab.m;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class n {

    /* renamed from: a, reason: collision with root package name */
    private final p60.b f89823a;

    /* renamed from: b, reason: collision with root package name */
    private final a f89824b;

    /* renamed from: c, reason: collision with root package name */
    private final QFSPreloadDataSource f89825c;

    /* renamed from: d, reason: collision with root package name */
    private final c f89826d;

    public n(@NonNull l lVar) {
        this.f89823a = lVar;
        this.f89824b = new a(lVar);
        this.f89825c = new QFSPreloadDataSource(lVar);
        this.f89826d = new c(lVar);
    }

    private boolean b(@NonNull m.a aVar) {
        QCircleTabInfo G = this.f89823a.G();
        if (G == null) {
            QLog.e(n(), 1, "doFeedPrePull tab info is null");
            return false;
        }
        if (G.getSource() != 75 || !uq3.c.V4()) {
            return false;
        }
        QLog.d(n(), 1, "doFeedPrePull real");
        return this.f89825c.n(aVar);
    }

    private void c(m.a aVar) {
        if (aVar.f89816g) {
            e(aVar);
        } else {
            d(aVar);
        }
    }

    private void d(m.a aVar) {
        if (o(aVar)) {
            return;
        }
        if (m(aVar)) {
            QLog.d(n(), 1, "doInit fetch from push preload data source");
            return;
        }
        if (j(aVar)) {
            QLog.d(n(), 1, "doInit fetch from cache data source");
            return;
        }
        if (this.f89824b.i(aVar)) {
            QLog.d(n(), 1, "doInit fetch from preload data source");
            return;
        }
        if (l(aVar)) {
            QLog.d(n(), 1, "doInit fetch from preload data source");
            return;
        }
        if (i(aVar)) {
            QLog.d(n(), 1, "doInit fetch from dis cache data source");
            return;
        }
        if (h(aVar)) {
            QLog.d(n(), 1, "doInit fetch from backup data source");
        } else if (k(aVar)) {
            QLog.d(n(), 1, "doInit fetch from network data source");
        } else {
            QLog.e(n(), 1, "doInit no data source can fetch");
        }
    }

    private void e(m.a aVar) {
        if (m(aVar)) {
            QLog.d(n(), 1, "doInit fetch from push preload data source");
            return;
        }
        if (l(aVar)) {
            QLog.d(n(), 1, "doInit fetch from preload data source");
            return;
        }
        if (j(aVar)) {
            QLog.d(n(), 1, "doInit fetch from cache data source");
            k(aVar.c("refresh"));
        } else if (k(aVar)) {
            QLog.d(n(), 1, "doInit fetch from network data source");
        } else {
            QLog.e(n(), 1, "doInit no data source can fetch");
        }
    }

    private void f(m.a aVar) {
        if (k(aVar)) {
            QLog.d(n(), 1, "doLoadMore fetch from network data source");
        } else {
            QLog.e(n(), 1, "doLoadMore no data source can fetch");
        }
    }

    private void g(m.a aVar) {
        if (k(aVar)) {
            QLog.d(n(), 1, "doRefresh fetch from network data source");
        } else {
            QLog.e(n(), 1, "doRefresh no data source can fetch");
        }
    }

    private boolean h(m.a aVar) {
        if (this.f89825c.f89798f != 10 || !com.tencent.biz.qqcircle.richframework.preload.coldbootV2.h.b() || !aVar.f89813d) {
            return false;
        }
        QLog.d(n(), 1, "doInit fetch from redPoint backup data source");
        aVar.f89822m.put("is_backup_rsp", Boolean.TRUE);
        return this.f89825c.s(aVar, 10000);
    }

    private boolean i(m.a aVar) {
        return this.f89824b.h(aVar, "CACHE_TYPE_DISK");
    }

    private boolean j(m.a aVar) {
        if (!aVar.f89816g && aVar.f89811b) {
            return this.f89824b.h(aVar, "CACHE_TYPE_MEMORY");
        }
        return false;
    }

    private boolean k(m.a aVar) {
        return this.f89826d.g(aVar, "");
    }

    private boolean l(m.a aVar) {
        if (aVar.f89813d) {
            return this.f89825c.p(aVar, "");
        }
        return false;
    }

    private boolean m(m.a aVar) {
        if (aVar.f89815f) {
            return this.f89825c.r(aVar);
        }
        return false;
    }

    private boolean o(m.a aVar) {
        QFSPreloadDataSource qFSPreloadDataSource = this.f89825c;
        if (qFSPreloadDataSource.f89798f != 10 || !aVar.f89814e) {
            return false;
        }
        return qFSPreloadDataSource.j(aVar);
    }

    public void a() {
        this.f89824b.g();
    }

    public String n() {
        return "FeedLine_QFSFolderTabPipeline_" + this.f89823a.G().getName();
    }

    public void p(@NonNull m.a aVar) {
        String str = aVar.f89810a;
        str.hashCode();
        char c16 = '\uffff';
        switch (str.hashCode()) {
            case -1294802335:
                if (str.equals("pre_pull")) {
                    c16 = 0;
                    break;
                }
                break;
            case 3237136:
                if (str.equals("init")) {
                    c16 = 1;
                    break;
                }
                break;
            case 1085444827:
                if (str.equals("refresh")) {
                    c16 = 2;
                    break;
                }
                break;
            case 1389383438:
                if (str.equals("load_more")) {
                    c16 = 3;
                    break;
                }
                break;
        }
        switch (c16) {
            case 0:
                b(aVar);
                return;
            case 1:
                c(aVar);
                return;
            case 2:
                g(aVar);
                return;
            case 3:
                f(aVar);
                return;
            default:
                return;
        }
    }

    public void q(List<e30.b> list) {
        this.f89824b.j(list);
    }

    public void r(String str, int i3, int i16) {
        this.f89824b.k(str, i3, i16);
    }
}
