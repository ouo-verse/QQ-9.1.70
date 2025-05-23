package com.tencent.mobileqq.filemanager.activity.recentfile;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.activity.fileassistant.QfileBaseTabView;
import com.tencent.mobileqq.filemanager.api.IQQFileTempUtils;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.e;
import com.tencent.mobileqq.filemanager.data.f;
import com.tencent.mobileqq.filemanager.util.ah;
import com.tencent.mobileqq.filemanager.util.t;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtilsTemp;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import ob1.d;

/* compiled from: P */
/* loaded from: classes12.dex */
public class QfileRecentAllFileTabView extends QfileBaseRecentFileTabView {

    /* renamed from: g0, reason: collision with root package name */
    private t f206738g0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class a extends t {
        a() {
        }

        @Override // com.tencent.mobileqq.filemanager.util.t
        public void a() {
            QfileRecentAllFileTabView.this.f206603d.U2().C();
        }

        @Override // com.tencent.mobileqq.filemanager.util.t
        public void b() {
            QfileRecentAllFileTabView.this.f206603d.U2().K();
        }

        @Override // com.tencent.mobileqq.filemanager.util.t
        public void c() {
            QfileRecentAllFileTabView.this.f206603d.U2().e0();
            ArrayList<FileManagerEntity> q16 = f.q();
            if (q16 != null && q16.size() > 0) {
                Iterator<FileManagerEntity> it = q16.iterator();
                while (it.hasNext()) {
                    if (e.g(it.next().Uuid)) {
                        ReportController.o(((QfileBaseTabView) QfileRecentAllFileTabView.this).f206604e, "dc00898", "", "", "0X800A087", "0X800A087", 0, 0, "", "", "", "");
                    }
                }
            }
        }

        @Override // com.tencent.mobileqq.filemanager.util.t
        public void d() {
            QfileRecentAllFileTabView.this.f206603d.U2().h0();
        }

        @Override // com.tencent.mobileqq.filemanager.util.t
        public void e() {
            QfileRecentAllFileTabView.this.f206603d.U2().u();
        }

        @Override // com.tencent.mobileqq.filemanager.util.t
        public void f() {
            QfileRecentAllFileTabView.this.f206603d.U2().g();
        }
    }

    public QfileRecentAllFileTabView(Context context) {
        super(context);
        this.f206738g0 = null;
        G0();
        setEditbarButton(false, true, true, true, true);
    }

    private Pair<Integer, Integer> P0(long j3) {
        Iterator<List<FileManagerEntity>> it = this.G.values().iterator();
        int i3 = -1;
        int i16 = -1;
        int i17 = -1;
        loop0: while (true) {
            if (!it.hasNext()) {
                break;
            }
            i16++;
            Iterator<FileManagerEntity> it5 = it.next().iterator();
            while (it5.hasNext()) {
                i17++;
                if (it5.next().nSessionId == j3) {
                    i3 = i17;
                    break loop0;
                }
            }
        }
        return new Pair<>(Integer.valueOf(i16), Integer.valueOf(i3));
    }

    private void Q0() {
        long j3;
        Intent intent = this.f206603d.getIntent();
        String stringExtra = intent.getStringExtra("from");
        long[] longArrayExtra = intent.getLongArrayExtra("locate_session_id");
        if (longArrayExtra != null && longArrayExtra.length > 0) {
            j3 = longArrayExtra[0];
        } else {
            j3 = 0;
        }
        intent.removeExtra("locate_session_id");
        QLog.e(QfileBaseRecentFileTabView.f206699f0, 1, "handleSelect from:" + stringExtra + ", locateSessionId:" + j3);
        if (TextUtils.equals(stringExtra, QQPermissionConstants.Business.SCENE.TBS_TOOL) && j3 > 0) {
            Pair<Integer, Integer> P0 = P0(j3);
            QLog.e(QfileBaseRecentFileTabView.f206699f0, 1, "handleSelect locateSessionId:" + j3 + ", position: " + P0.first + ":" + P0.second);
            if (P0.first.intValue() >= 0 && P0.second.intValue() >= 0) {
                setSelect(P0.first.intValue(), P0.second.intValue(), longArrayExtra);
                return;
            } else {
                setSelect(0);
                return;
            }
        }
        setSelect(0);
    }

    private void R0() {
        if (this.f206603d.p3()) {
            this.f206603d.U2().Q();
        } else {
            this.f206603d.U2().r();
        }
        t tVar = this.f206738g0;
        if (tVar != null) {
            this.f206603d.P3(tVar);
            return;
        }
        a aVar = new a();
        this.f206738g0 = aVar;
        this.f206603d.P3(aVar);
    }

    @Override // com.tencent.mobileqq.filemanager.activity.recentfile.QfileBaseRecentFileTabView, com.tencent.mobileqq.filemanager.activity.fileassistant.QfileBaseTabView
    public void A() {
        super.A();
        this.f206603d.G3(true);
        setEditbarButton(false, true, true, true, true);
        R0();
    }

    @Override // com.tencent.mobileqq.filemanager.activity.fileassistant.QfileBaseTabView
    public void B() {
        super.B();
        this.f206603d.G3(false);
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
        E(new Runnable() { // from class: com.tencent.mobileqq.filemanager.activity.recentfile.QfileRecentAllFileTabView.2
            @Override // java.lang.Runnable
            public void run() {
                String historyGroupByTime = ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).getHistoryGroupByTime(fileManagerEntity.srvTime);
                if (!QfileRecentAllFileTabView.this.G.containsKey(historyGroupByTime)) {
                    QfileRecentAllFileTabView.this.G.put(historyGroupByTime, new ArrayList());
                }
                List<FileManagerEntity> list = QfileRecentAllFileTabView.this.G.get(historyGroupByTime);
                if (list.contains(fileManagerEntity)) {
                    return;
                }
                list.add(0, fileManagerEntity);
                QfileRecentAllFileTabView.this.C();
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
        if (fileManagerEntity.nFileType == 13) {
            ((ITeamWorkUtilsTemp) QRoute.api(ITeamWorkUtilsTemp.class)).forwardTencentDoc(this.f206603d, fileManagerEntity);
        } else {
            super.w0(fileManagerEntity);
        }
    }

    @Override // com.tencent.mobileqq.filemanager.activity.recentfile.QfileBaseRecentFileTabView
    protected d y0() {
        return new com.tencent.mobileqq.filemanager.activity.recentfile.a(o(), this.G, o(), this.f206700a0, this.f206702c0, this.f206701b0, this.f206703d0);
    }

    @Override // com.tencent.mobileqq.filemanager.activity.recentfile.QfileBaseRecentFileTabView
    protected void z0() {
        this.G.clear();
        for (FileManagerEntity fileManagerEntity : this.P) {
            if (!fileManagerEntity.bDelInFM) {
                BaseFileAssistantActivity baseFileAssistantActivity = this.f206603d;
                if ((!baseFileAssistantActivity.A0 && baseFileAssistantActivity.S2() != 1025 && this.f206603d.S2() != 1024 && fileManagerEntity.peerType != 10014) || ah.I(fileManagerEntity.getFilePath())) {
                    String historyGroupByTime = ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).getHistoryGroupByTime(fileManagerEntity.srvTime);
                    if (!this.G.containsKey(historyGroupByTime)) {
                        this.G.put(historyGroupByTime, new ArrayList());
                    }
                    this.G.get(historyGroupByTime).add(fileManagerEntity);
                }
            }
        }
        C();
        Q0();
        J0(true);
        this.U = false;
    }

    public QfileRecentAllFileTabView(Context context, String str) {
        super(context, str);
        this.f206738g0 = null;
        G0();
        setEditbarButton(false, true, true, true, true);
    }
}
