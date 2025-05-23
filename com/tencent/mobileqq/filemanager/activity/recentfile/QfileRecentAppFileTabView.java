package com.tencent.mobileqq.filemanager.activity.recentfile;

import android.content.Context;
import com.tencent.mobileqq.filemanager.api.IQQFileTempUtils;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.ah;
import com.tencent.mobileqq.filemanager.util.t;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import ob1.d;

/* compiled from: P */
/* loaded from: classes12.dex */
public class QfileRecentAppFileTabView extends QfileBaseRecentFileTabView {

    /* renamed from: g0, reason: collision with root package name */
    private t f206741g0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class a extends t {
        a() {
        }

        @Override // com.tencent.mobileqq.filemanager.util.t
        public void a() {
            QfileRecentAppFileTabView.this.f206603d.U2().C();
        }

        @Override // com.tencent.mobileqq.filemanager.util.t
        public void b() {
            QfileRecentAppFileTabView.this.f206603d.U2().K();
        }

        @Override // com.tencent.mobileqq.filemanager.util.t
        public void c() {
            QfileRecentAppFileTabView.this.f206603d.U2().e0();
        }

        @Override // com.tencent.mobileqq.filemanager.util.t
        public void d() {
            QfileRecentAppFileTabView.this.f206603d.U2().h0();
        }

        @Override // com.tencent.mobileqq.filemanager.util.t
        public void e() {
            QfileRecentAppFileTabView.this.f206603d.U2().u();
        }

        @Override // com.tencent.mobileqq.filemanager.util.t
        public void f() {
            QfileRecentAppFileTabView.this.f206603d.U2().g();
        }
    }

    public QfileRecentAppFileTabView(Context context) {
        super(context);
        this.f206741g0 = null;
        G0();
        setEditbarButton(false, true, true, true, true);
    }

    private void O0() {
        if (this.f206603d.p3()) {
            this.f206603d.U2().B();
        } else {
            this.f206603d.U2().k0();
        }
        t tVar = this.f206741g0;
        if (tVar != null) {
            this.f206603d.P3(tVar);
            return;
        }
        a aVar = new a();
        this.f206741g0 = aVar;
        this.f206603d.P3(aVar);
    }

    @Override // com.tencent.mobileqq.filemanager.activity.recentfile.QfileBaseRecentFileTabView, com.tencent.mobileqq.filemanager.activity.fileassistant.QfileBaseTabView
    public void A() {
        super.A();
        setEditbarButton(false, true, true, true, true);
        O0();
    }

    @Override // com.tencent.mobileqq.filemanager.activity.recentfile.QfileBaseRecentFileTabView
    protected void K0(final FileManagerEntity fileManagerEntity) {
        if (!this.P.contains(fileManagerEntity)) {
            String str = this.E;
            if (str != null && str.trim().length() != 0 && !this.E.equals(fileManagerEntity.peerUin)) {
                return;
            }
            this.P.add(fileManagerEntity);
            Collections.sort(this.P, this.V);
        }
        if (fileManagerEntity.nFileType != 5) {
            return;
        }
        E(new Runnable() { // from class: com.tencent.mobileqq.filemanager.activity.recentfile.QfileRecentAppFileTabView.2
            @Override // java.lang.Runnable
            public void run() {
                String historyGroupByTime = ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).getHistoryGroupByTime(fileManagerEntity.srvTime);
                if (!QfileRecentAppFileTabView.this.G.containsKey(historyGroupByTime)) {
                    QfileRecentAppFileTabView.this.G.put(historyGroupByTime, new ArrayList());
                }
                List<FileManagerEntity> list = QfileRecentAppFileTabView.this.G.get(historyGroupByTime);
                if (list.contains(fileManagerEntity)) {
                    return;
                }
                list.add(0, fileManagerEntity);
                QfileRecentAppFileTabView.this.C();
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

    @Override // com.tencent.mobileqq.filemanager.activity.recentfile.QfileBaseRecentFileTabView
    protected d y0() {
        return new com.tencent.mobileqq.filemanager.activity.recentfile.a(o(), this.G, o(), this.f206700a0, this.f206702c0, this.f206701b0, this.f206703d0);
    }

    @Override // com.tencent.mobileqq.filemanager.activity.recentfile.QfileBaseRecentFileTabView
    protected void z0() {
        this.G.clear();
        for (FileManagerEntity fileManagerEntity : this.P) {
            if (!fileManagerEntity.bDelInFM && fileManagerEntity.nFileType == 5 && ((!this.f206603d.A0 && fileManagerEntity.peerType != 10014) || ah.I(fileManagerEntity.getFilePath()))) {
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

    public QfileRecentAppFileTabView(Context context, String str) {
        super(context, str);
        this.f206741g0 = null;
        G0();
        setEditbarButton(false, true, true, true, true);
    }
}
