package com.tencent.mobileqq.filemanager.activity.recentfile;

import android.content.Context;
import com.tencent.mobileqq.filemanager.activity.fileassistant.QfileBaseTabView;
import com.tencent.mobileqq.filemanager.api.IQQFileTempUtils;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.e;
import com.tencent.mobileqq.filemanager.data.f;
import com.tencent.mobileqq.filemanager.util.t;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import ob1.d;

/* compiled from: P */
/* loaded from: classes12.dex */
public class QfileRecentTDocFileTabView extends QfileBaseRecentFileTabView {

    /* renamed from: g0, reason: collision with root package name */
    private t f206767g0;

    public QfileRecentTDocFileTabView(Context context) {
        super(context);
        this.f206767g0 = null;
        G0();
        setEditbarButton(false, true, true, true, true);
    }

    private void P0() {
        if (this.f206603d.p3()) {
            this.f206603d.U2().z();
        } else {
            this.f206603d.U2().q();
        }
        t tVar = this.f206767g0;
        if (tVar != null) {
            this.f206603d.P3(tVar);
            return;
        }
        a aVar = new a();
        this.f206767g0 = aVar;
        this.f206603d.P3(aVar);
    }

    @Override // com.tencent.mobileqq.filemanager.activity.recentfile.QfileBaseRecentFileTabView, com.tencent.mobileqq.filemanager.activity.fileassistant.QfileBaseTabView
    public void A() {
        super.A();
        this.f206603d.G3(true);
        setEditbarButton(false, true, true, true, true);
        P0();
    }

    @Override // com.tencent.mobileqq.filemanager.activity.fileassistant.QfileBaseTabView
    public void B() {
        super.B();
        this.f206603d.G3(false);
    }

    @Override // com.tencent.mobileqq.filemanager.activity.recentfile.QfileBaseRecentFileTabView
    void K0(final FileManagerEntity fileManagerEntity) {
        if (!this.P.contains(fileManagerEntity)) {
            String str = this.E;
            if (str != null && str.trim().length() != 0 && !this.E.equals(fileManagerEntity.peerUin)) {
                return;
            }
            this.P.add(fileManagerEntity);
            Collections.sort(this.P, this.V);
        }
        E(new Runnable() { // from class: com.tencent.mobileqq.filemanager.activity.recentfile.QfileRecentTDocFileTabView.1
            @Override // java.lang.Runnable
            public void run() {
                String historyGroupByTime = ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).getHistoryGroupByTime(fileManagerEntity.srvTime);
                if (!QfileRecentTDocFileTabView.this.G.containsKey(historyGroupByTime)) {
                    QfileRecentTDocFileTabView.this.G.put(historyGroupByTime, new ArrayList());
                }
                List<FileManagerEntity> list = QfileRecentTDocFileTabView.this.G.get(historyGroupByTime);
                if (list.contains(fileManagerEntity)) {
                    return;
                }
                list.add(0, fileManagerEntity);
                QfileRecentTDocFileTabView.this.C();
            }
        });
    }

    @Override // com.tencent.mobileqq.filemanager.activity.recentfile.QfileBaseRecentFileTabView
    protected d y0() {
        return new com.tencent.mobileqq.filemanager.activity.recentfile.a(o(), this.G, o(), this.f206700a0, this.f206702c0, this.f206701b0, this.f206703d0);
    }

    @Override // com.tencent.mobileqq.filemanager.activity.recentfile.QfileBaseRecentFileTabView
    void z0() {
        if (this.P == null) {
            return;
        }
        this.G.clear();
        if (QLog.isDevelopLevel()) {
            QLog.e("crashBUG", 1, "Thread id: " + Thread.currentThread().getId());
        }
        for (FileManagerEntity fileManagerEntity : this.P) {
            if (!fileManagerEntity.bDelInFM && fileManagerEntity.nFileType == 13) {
                String historyGroupByTime = ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).getHistoryGroupByTime(fileManagerEntity.srvTime);
                if (!this.G.containsKey(historyGroupByTime)) {
                    this.G.put(historyGroupByTime, new ArrayList());
                }
                this.G.get(historyGroupByTime).add(fileManagerEntity);
            }
        }
        C();
        setSelect(0);
        J0(true);
        this.U = false;
    }

    public QfileRecentTDocFileTabView(Context context, String str) {
        super(context, str);
        this.f206767g0 = null;
        G0();
        setEditbarButton(false, true, true, true, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class a extends t {
        a() {
        }

        @Override // com.tencent.mobileqq.filemanager.util.t
        public void c() {
            ArrayList<FileManagerEntity> q16 = f.q();
            if (q16 != null && q16.size() > 0) {
                Iterator<FileManagerEntity> it = q16.iterator();
                while (it.hasNext()) {
                    if (e.g(it.next().Uuid)) {
                        ReportController.o(((QfileBaseTabView) QfileRecentTDocFileTabView.this).f206604e, "dc00898", "", "", "0X800A08C", "0X800A08C", 0, 0, "", "", "", "");
                    }
                }
            }
        }

        @Override // com.tencent.mobileqq.filemanager.util.t
        public void e() {
            QfileRecentTDocFileTabView.this.f206603d.U2().u();
        }

        @Override // com.tencent.mobileqq.filemanager.util.t
        public void a() {
        }

        @Override // com.tencent.mobileqq.filemanager.util.t
        public void b() {
        }

        @Override // com.tencent.mobileqq.filemanager.util.t
        public void d() {
        }

        @Override // com.tencent.mobileqq.filemanager.util.t
        public void f() {
        }
    }
}
