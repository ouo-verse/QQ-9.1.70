package com.tencent.mobileqq.filemanager.activity.recentfile;

import android.content.Context;
import com.tencent.mobileqq.filemanager.api.IQQFileTempUtils;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.t;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtilsTemp;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import ob1.d;

/* compiled from: P */
/* loaded from: classes12.dex */
public class QfileRecentTencentDocFileTabView extends QfileBaseRecentFileTabView {

    /* renamed from: g0, reason: collision with root package name */
    private t f206770g0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class a extends t {
        a() {
        }

        @Override // com.tencent.mobileqq.filemanager.util.t
        public void a() {
            QfileRecentTencentDocFileTabView.this.f206603d.U2().C();
        }

        @Override // com.tencent.mobileqq.filemanager.util.t
        public void b() {
            QfileRecentTencentDocFileTabView.this.f206603d.U2().K();
        }

        @Override // com.tencent.mobileqq.filemanager.util.t
        public void c() {
            QfileRecentTencentDocFileTabView.this.f206603d.U2().e0();
        }

        @Override // com.tencent.mobileqq.filemanager.util.t
        public void d() {
            QfileRecentTencentDocFileTabView.this.f206603d.U2().h0();
        }

        @Override // com.tencent.mobileqq.filemanager.util.t
        public void e() {
            QfileRecentTencentDocFileTabView.this.f206603d.U2().u();
        }

        @Override // com.tencent.mobileqq.filemanager.util.t
        public void f() {
            QfileRecentTencentDocFileTabView.this.f206603d.U2().g();
        }
    }

    public QfileRecentTencentDocFileTabView(Context context) {
        super(context);
        this.f206770g0 = null;
        G0();
        setEditbarButton(false, true, true, true, true);
    }

    private void O0() {
        if (this.f206603d.p3()) {
            this.f206603d.U2().z();
        } else {
            this.f206603d.U2().q();
        }
        t tVar = this.f206770g0;
        if (tVar != null) {
            this.f206603d.P3(tVar);
            return;
        }
        a aVar = new a();
        this.f206770g0 = aVar;
        this.f206603d.P3(aVar);
    }

    @Override // com.tencent.mobileqq.filemanager.activity.recentfile.QfileBaseRecentFileTabView, com.tencent.mobileqq.filemanager.activity.fileassistant.QfileBaseTabView
    public void A() {
        super.A();
        setEditbarButton(false, true, true, true, true);
        O0();
    }

    @Override // com.tencent.mobileqq.filemanager.activity.fileassistant.QfileBaseTabView
    public void B() {
        super.B();
        this.f206603d.G3(false);
    }

    @Override // com.tencent.mobileqq.filemanager.activity.recentfile.QfileBaseRecentFileTabView
    public void K0(final FileManagerEntity fileManagerEntity) {
        if (!this.P.contains(fileManagerEntity)) {
            String str = this.E;
            if (str != null && str.trim().length() != 0 && !this.E.equals(fileManagerEntity.peerUin)) {
                return;
            }
            this.P.add(fileManagerEntity);
            Collections.sort(this.P, this.V);
        }
        E(new Runnable() { // from class: com.tencent.mobileqq.filemanager.activity.recentfile.QfileRecentTencentDocFileTabView.2
            @Override // java.lang.Runnable
            public void run() {
                String historyGroupByTime = ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).getHistoryGroupByTime(fileManagerEntity.srvTime);
                if (!QfileRecentTencentDocFileTabView.this.G.containsKey(historyGroupByTime)) {
                    QfileRecentTencentDocFileTabView.this.G.put(historyGroupByTime, new ArrayList());
                }
                List<FileManagerEntity> list = QfileRecentTencentDocFileTabView.this.G.get(historyGroupByTime);
                if (list.contains(fileManagerEntity)) {
                    return;
                }
                list.add(0, fileManagerEntity);
                QfileRecentTencentDocFileTabView.this.C();
            }
        });
    }

    @Override // com.tencent.mobileqq.filemanager.activity.fileassistant.QfileBaseTabView
    public void l(ArrayList<FileManagerEntity> arrayList) {
        if (arrayList != null && arrayList.size() != 0) {
            Iterator<FileManagerEntity> it = arrayList.iterator();
            while (it.hasNext()) {
                s0(it.next());
            }
        }
    }

    @Override // com.tencent.mobileqq.filemanager.activity.recentfile.QfileBaseRecentFileTabView
    protected boolean s0(FileManagerEntity fileManagerEntity) {
        String historyGroupByTime = ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).getHistoryGroupByTime(fileManagerEntity.srvTime);
        if (!this.G.containsKey(historyGroupByTime)) {
            QLog.e(QfileBaseRecentFileTabView.f206699f0, 1, "delRecentFileRecords, fileEntities find, but recentRecords not find!");
            return false;
        }
        synchronized (this.G) {
            Iterator<FileManagerEntity> it = this.G.get(historyGroupByTime).iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if (fileManagerEntity == it.next()) {
                    it.remove();
                    break;
                }
            }
        }
        C();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.filemanager.activity.recentfile.QfileBaseRecentFileTabView
    public void w0(FileManagerEntity fileManagerEntity) {
        ((ITeamWorkUtilsTemp) QRoute.api(ITeamWorkUtilsTemp.class)).forwardTencentDoc(this.f206603d, fileManagerEntity);
    }

    @Override // com.tencent.mobileqq.filemanager.activity.recentfile.QfileBaseRecentFileTabView
    protected d y0() {
        return new com.tencent.mobileqq.filemanager.activity.recentfile.a(o(), this.G, o(), this.f206700a0, this.f206702c0, this.f206701b0, this.f206703d0);
    }

    @Override // com.tencent.mobileqq.filemanager.activity.recentfile.QfileBaseRecentFileTabView
    protected void z0() {
        this.G.clear();
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

    public QfileRecentTencentDocFileTabView(Context context, String str) {
        super(context, str);
        this.f206770g0 = null;
        G0();
        setEditbarButton(false, true, true, true, true);
    }
}
