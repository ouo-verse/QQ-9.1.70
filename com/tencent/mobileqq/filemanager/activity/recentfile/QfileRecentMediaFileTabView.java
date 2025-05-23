package com.tencent.mobileqq.filemanager.activity.recentfile;

import android.content.Context;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.ah;
import com.tencent.mobileqq.filemanager.util.t;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import ob1.d;

/* compiled from: P */
/* loaded from: classes12.dex */
public class QfileRecentMediaFileTabView extends QfileBaseRecentFileTabView {

    /* renamed from: g0, reason: collision with root package name */
    private t f206749g0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class a extends t {
        a() {
        }

        @Override // com.tencent.mobileqq.filemanager.util.t
        public void a() {
            QfileRecentMediaFileTabView.this.f206603d.U2().C();
        }

        @Override // com.tencent.mobileqq.filemanager.util.t
        public void b() {
            QfileRecentMediaFileTabView.this.f206603d.U2().K();
        }

        @Override // com.tencent.mobileqq.filemanager.util.t
        public void c() {
            QfileRecentMediaFileTabView.this.f206603d.U2().e0();
        }

        @Override // com.tencent.mobileqq.filemanager.util.t
        public void d() {
            QfileRecentMediaFileTabView.this.f206603d.U2().h0();
        }

        @Override // com.tencent.mobileqq.filemanager.util.t
        public void e() {
            QfileRecentMediaFileTabView.this.f206603d.U2().u();
        }

        @Override // com.tencent.mobileqq.filemanager.util.t
        public void f() {
            QfileRecentMediaFileTabView.this.f206603d.U2().g();
        }
    }

    public QfileRecentMediaFileTabView(Context context) {
        super(context);
        this.f206749g0 = null;
        G0();
        setEditbarButton(false, true, true, true, true);
    }

    private String O0(String str) {
        int o06 = ah.o0(str);
        if (o06 != 1) {
            if (o06 != 2) {
                return null;
            }
            return HardCodeUtil.qqStr(R.string.bah);
        }
        return HardCodeUtil.qqStr(R.string.bad);
    }

    private void P0() {
        if (this.f206603d.p3()) {
            this.f206603d.U2().s();
        } else {
            this.f206603d.U2().l();
        }
        t tVar = this.f206749g0;
        if (tVar != null) {
            this.f206603d.P3(tVar);
            return;
        }
        a aVar = new a();
        this.f206749g0 = aVar;
        this.f206603d.P3(aVar);
    }

    @Override // com.tencent.mobileqq.filemanager.activity.recentfile.QfileBaseRecentFileTabView, com.tencent.mobileqq.filemanager.activity.fileassistant.QfileBaseTabView
    public void A() {
        super.A();
        setEditbarButton(false, true, true, true, true);
        P0();
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
        final String O0 = O0(fileManagerEntity.fileName);
        if (O0 == null) {
            return;
        }
        E(new Runnable() { // from class: com.tencent.mobileqq.filemanager.activity.recentfile.QfileRecentMediaFileTabView.2
            @Override // java.lang.Runnable
            public void run() {
                if (!QfileRecentMediaFileTabView.this.G.containsKey(O0)) {
                    QfileRecentMediaFileTabView.this.G.put(O0, new ArrayList());
                }
                List<FileManagerEntity> list = QfileRecentMediaFileTabView.this.G.get(O0);
                if (list.contains(fileManagerEntity)) {
                    return;
                }
                list.add(0, fileManagerEntity);
                QfileRecentMediaFileTabView.this.C();
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
        String O0 = O0(fileManagerEntity.fileName);
        if (!this.G.containsKey(O0)) {
            QLog.e(QfileBaseRecentFileTabView.f206699f0, 1, "delRecentFileRecords, fileEntities find, but recentRecords not find!");
            return false;
        }
        synchronized (this.G) {
            Iterator<FileManagerEntity> it = this.G.get(O0).iterator();
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
            if (!fileManagerEntity.bDelInFM && ((!this.f206603d.A0 && fileManagerEntity.peerType != 10014) || ah.I(fileManagerEntity.getFilePath()))) {
                String O0 = O0(fileManagerEntity.fileName);
                if (O0 != null) {
                    if (!this.G.containsKey(O0)) {
                        this.G.put(O0, new ArrayList());
                    }
                    this.G.get(O0).add(fileManagerEntity);
                }
            }
        }
        C();
        setSelect(0);
        J0(true);
        this.U = false;
    }

    public QfileRecentMediaFileTabView(Context context, String str) {
        super(context, str);
        this.f206749g0 = null;
        G0();
        setEditbarButton(false, true, true, true, true);
    }
}
