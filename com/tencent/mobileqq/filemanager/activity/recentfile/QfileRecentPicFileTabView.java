package com.tencent.mobileqq.filemanager.activity.recentfile;

import android.content.Context;
import android.content.res.Configuration;
import android.view.View;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.api.IQQFileEngine;
import com.tencent.mobileqq.filemanager.api.IQQFileTempUtils;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.f;
import com.tencent.mobileqq.filemanager.data.n;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.ah;
import com.tencent.mobileqq.filemanager.util.t;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.filemanager.widget.QfilePinnedHeaderExpandableListView;
import com.tencent.mobileqq.guild.api.IGuildFileApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes12.dex */
public class QfileRecentPicFileTabView extends QfileBaseRecentFileTabView {

    /* renamed from: g0, reason: collision with root package name */
    private t f206753g0;

    /* renamed from: h0, reason: collision with root package name */
    private FMObserver f206754h0;

    /* renamed from: i0, reason: collision with root package name */
    QfilePinnedHeaderExpandableListView.a f206755i0;

    /* renamed from: j0, reason: collision with root package name */
    private View.OnClickListener f206756j0;

    /* renamed from: k0, reason: collision with root package name */
    private View.OnClickListener f206757k0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes12.dex */
    public class a extends FMObserver {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.filemanager.app.FMObserver
        public void B0(n nVar) {
            super.B0(nVar);
            String str = nVar.f207833d;
            if (str != null && str.length() > 0) {
                QfileRecentPicFileTabView.this.C();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes12.dex */
    public class b extends t {
        b() {
        }

        @Override // com.tencent.mobileqq.filemanager.util.t
        public void a() {
            QfileRecentPicFileTabView.this.f206603d.U2().C();
        }

        @Override // com.tencent.mobileqq.filemanager.util.t
        public void b() {
            QfileRecentPicFileTabView.this.f206603d.U2().K();
        }

        @Override // com.tencent.mobileqq.filemanager.util.t
        public void c() {
            QfileRecentPicFileTabView.this.f206603d.U2().e0();
        }

        @Override // com.tencent.mobileqq.filemanager.util.t
        public void d() {
            QfileRecentPicFileTabView.this.f206603d.U2().h0();
        }

        @Override // com.tencent.mobileqq.filemanager.util.t
        public void e() {
            QfileRecentPicFileTabView.this.f206603d.U2().u();
        }

        @Override // com.tencent.mobileqq.filemanager.util.t
        public void f() {
            QfileRecentPicFileTabView.this.f206603d.U2().g();
        }
    }

    /* loaded from: classes12.dex */
    class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            QfileRecentPicFileTabView.this.S0(view, true);
            view.sendAccessibilityEvent(8);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* loaded from: classes12.dex */
    class e implements View.OnClickListener {
        e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            QfileRecentPicFileTabView.this.S0(view, false);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public QfileRecentPicFileTabView(Context context) {
        super(context);
        this.f206753g0 = null;
        this.f206754h0 = null;
        this.f206755i0 = new c();
        this.f206756j0 = new d();
        this.f206757k0 = new e();
        if (this.f206754h0 == null) {
            U0();
        }
        G0();
        setEditbarButton(true, true, true, true, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean R0(FileManagerEntity fileManagerEntity, boolean z16) {
        if (fileManagerEntity == null || fileManagerEntity.nFileType != 0) {
            return false;
        }
        if (v() && ((f.D(fileManagerEntity) && z16) || (!f.D(fileManagerEntity) && !z16))) {
            return false;
        }
        if (v()) {
            if (z16) {
                f.d(fileManagerEntity);
                return true;
            }
            f.H(fileManagerEntity);
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S0(View view, boolean z16) {
        ob1.c cVar = (ob1.c) view.getTag();
        FileManagerEntity fileManagerEntity = (FileManagerEntity) cVar.f422335j;
        AsyncImageView asyncImageView = cVar.f422326a;
        if (fileManagerEntity == null) {
            return;
        }
        if (z16) {
            if (f.D(fileManagerEntity)) {
                f.H(fileManagerEntity);
            } else {
                f.d(fileManagerEntity);
                if (V0(fileManagerEntity)) {
                    QQCustomDialog createNoTitleDialog = DialogUtil.createNoTitleDialog(this.f206603d, R.string.f0g);
                    createNoTitleDialog.setPositiveButton(R.string.i5e, new DialogUtil.DialogOnClickAdapter());
                    createNoTitleDialog.show();
                    f.L(f.f207765k);
                    FileManagerReporter.addData("0X800942D");
                }
            }
            if (this.f206603d.f206192z0 && fileManagerEntity.cloudType == 3 && !FileUtils.fileExistsAndNotEmpty(fileManagerEntity.getFilePath())) {
                com.tencent.mobileqq.filemanager.util.d.f(ah.y(fileManagerEntity.fileName) + HardCodeUtil.qqStr(R.string.f187013su));
                f.H(fileManagerEntity);
            } else if (this.f206603d.A0 && !((IGuildFileApi) QRoute.api(IGuildFileApi.class)).isLegalForSelectedFileName(fileManagerEntity.fileName)) {
                com.tencent.mobileqq.filemanager.util.d.f(HardCodeUtil.qqStr(R.string.f187133t6));
                f.H(fileManagerEntity);
            }
            k();
            I0();
            return;
        }
        if (v()) {
            ReportController.o(this.f206604e, "dc00898", "", "", "0X800A665", "0X800A665", 0, 0, "", "", "", "");
        }
        if (!w()) {
            if (QLog.isColorLevel()) {
                QLog.i(QfileBaseRecentFileTabView.f206699f0, 2, "click too fast , wait a minute.");
                return;
            }
            return;
        }
        G();
        FileManagerReporter.a aVar = new FileManagerReporter.a();
        aVar.f209157b = "file_viewer_in";
        aVar.f209158c = 73;
        aVar.f209159d = ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).getExtension(fileManagerEntity.fileName);
        aVar.f209160e = fileManagerEntity.fileSize;
        FileManagerReporter.addData(this.f206604e.getCurrentAccountUin(), aVar);
        FileManagerReporter.addData("0X8004AE4");
        IQQFileTempUtils iQQFileTempUtils = (IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class);
        BaseQQAppInterface baseQQAppInterface = this.f206604e;
        BaseFileAssistantActivity baseFileAssistantActivity = this.f206603d;
        iQQFileTempUtils.openRencentFileBrowserOnItemClick(baseQQAppInterface, baseFileAssistantActivity, fileManagerEntity, baseFileAssistantActivity.u3(), this.E, asyncImageView, false, false, 2);
    }

    private void T0() {
        if (this.f206603d.p3()) {
            this.f206603d.U2().F();
        } else {
            this.f206603d.U2().N();
        }
        t tVar = this.f206753g0;
        if (tVar != null) {
            this.f206603d.P3(tVar);
            return;
        }
        b bVar = new b();
        this.f206753g0 = bVar;
        this.f206603d.P3(bVar);
    }

    private void U0() {
        this.f206754h0 = new a();
    }

    private boolean V0(FileManagerEntity fileManagerEntity) {
        if (this.f206603d.j3() && !f.w(f.f207765k) && !f.A(fileManagerEntity)) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.filemanager.activity.recentfile.QfileBaseRecentFileTabView, com.tencent.mobileqq.filemanager.activity.fileassistant.QfileBaseTabView
    public void A() {
        super.A();
        setEditbarButton(true, true, true, true, true);
        T0();
        this.L.setOnIndexChangedListener(this.f206755i0);
    }

    @Override // com.tencent.mobileqq.filemanager.activity.fileassistant.QfileBaseTabView
    public void B() {
        super.B();
        ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).deleteObserver(this.f206754h0);
    }

    @Override // com.tencent.mobileqq.filemanager.activity.recentfile.QfileBaseRecentFileTabView
    protected void K0(final FileManagerEntity fileManagerEntity) {
        if (QLog.isDevelopLevel()) {
            QLog.e("crashBUG", 1, "Thread id: " + Thread.currentThread().getId() + " refreshRecentFileRecords");
        }
        if (!this.P.contains(fileManagerEntity)) {
            String str = this.E;
            if (str != null && str.trim().length() != 0 && !this.E.equals(fileManagerEntity.peerUin)) {
                return;
            }
            this.P.add(fileManagerEntity);
            Collections.sort(this.P, this.V);
        }
        if (fileManagerEntity.nFileType != 0) {
            return;
        }
        E(new Runnable() { // from class: com.tencent.mobileqq.filemanager.activity.recentfile.QfileRecentPicFileTabView.3
            @Override // java.lang.Runnable
            public void run() {
                String historyGroupByTime = ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).getHistoryGroupByTime(fileManagerEntity.srvTime);
                if (!QfileRecentPicFileTabView.this.G.containsKey(historyGroupByTime)) {
                    QfileRecentPicFileTabView.this.G.put(historyGroupByTime, new ArrayList());
                }
                List<FileManagerEntity> list = QfileRecentPicFileTabView.this.G.get(historyGroupByTime);
                if (list.contains(fileManagerEntity)) {
                    return;
                }
                list.add(0, fileManagerEntity);
                QfileRecentPicFileTabView.this.C();
            }
        });
    }

    public void W0() {
        this.f206603d.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.filemanager.activity.recentfile.QfileRecentPicFileTabView.5
            @Override // java.lang.Runnable
            public void run() {
                QfileRecentPicFileTabView.this.k();
                QfileRecentPicFileTabView.this.I0();
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.filemanager.activity.fileassistant.QfileBaseTabView, android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        QfilePinnedHeaderExpandableListView qfilePinnedHeaderExpandableListView;
        super.onConfigurationChanged(configuration);
        ob1.d dVar = this.Q;
        if (dVar != null && (qfilePinnedHeaderExpandableListView = this.L) != null && (dVar instanceof ob1.f)) {
            ob1.f fVar = (ob1.f) dVar;
            qfilePinnedHeaderExpandableListView.setGridSize(fVar.k());
            fVar.o();
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
    protected ob1.d y0() {
        return new ob1.f(o(), this.G, this.f206700a0, this.f206756j0, this.f206757k0, this.f206701b0, this.f206703d0);
    }

    @Override // com.tencent.mobileqq.filemanager.activity.recentfile.QfileBaseRecentFileTabView
    protected void z0() {
        if (this.P == null) {
            return;
        }
        this.G.clear();
        if (QLog.isDevelopLevel()) {
            QLog.e("crashBUG", 1, "Thread id: " + Thread.currentThread().getId());
        }
        for (FileManagerEntity fileManagerEntity : this.P) {
            if (!fileManagerEntity.bDelInFM && fileManagerEntity.nFileType == 0 && ((!this.f206603d.A0 && fileManagerEntity.peerType != 10014) || ah.I(fileManagerEntity.getFilePath()))) {
                if (!FileUtils.fileExistsAndNotEmpty(fileManagerEntity.getFilePath()) && !FileUtils.fileExistsAndNotEmpty(fileManagerEntity.strThumbPath)) {
                    if (fileManagerEntity.getCloudType() == 1) {
                        ((IQQFileEngine) this.f206604e.getRuntimeService(IQQFileEngine.class)).downLoadDiscThumb(fileManagerEntity, 7);
                    } else if (fileManagerEntity.getCloudType() == 2) {
                        ((IQQFileEngine) this.f206604e.getRuntimeService(IQQFileEngine.class)).getWeiYunPicThumb(fileManagerEntity.WeiYunFileId, fileManagerEntity.strLargeThumPath, 3, fileManagerEntity);
                    }
                }
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

    public QfileRecentPicFileTabView(Context context, String str) {
        super(context, str);
        this.f206753g0 = null;
        this.f206754h0 = null;
        this.f206755i0 = new c();
        this.f206756j0 = new d();
        this.f206757k0 = new e();
        G0();
        setEditbarButton(false, true, true, true, true);
    }

    /* loaded from: classes12.dex */
    class c implements QfilePinnedHeaderExpandableListView.a {

        /* renamed from: a, reason: collision with root package name */
        private boolean f206761a;

        /* renamed from: b, reason: collision with root package name */
        private int f206762b;

        /* renamed from: c, reason: collision with root package name */
        private int f206763c;

        c() {
        }

        @Override // com.tencent.mobileqq.filemanager.widget.QfilePinnedHeaderExpandableListView.a
        public void b(int i3, int i16) {
            this.f206761a = false;
            this.f206762b = Integer.MIN_VALUE;
            this.f206763c = Integer.MAX_VALUE;
            FileManagerEntity fileManagerEntity = (FileManagerEntity) QfileRecentPicFileTabView.this.Q.getChild(i3, i16);
            if (fileManagerEntity == null) {
                return;
            }
            boolean z16 = !f.D(fileManagerEntity);
            this.f206761a = z16;
            if (QfileRecentPicFileTabView.this.R0(fileManagerEntity, z16)) {
                QfileRecentPicFileTabView.this.W0();
            }
        }

        @Override // com.tencent.mobileqq.filemanager.widget.QfilePinnedHeaderExpandableListView.a
        public void d(int i3, int i16, int i17, int i18) {
            if (i3 != i17) {
                return;
            }
            int min = Math.min(i16, i18);
            int max = Math.max(i16, i18);
            if (i18 < i16) {
                this.f206763c = Math.min(i18, this.f206763c);
            } else {
                this.f206762b = Math.max(i18, this.f206762b);
            }
            for (int i19 = min; i19 <= max; i19++) {
                QfileRecentPicFileTabView qfileRecentPicFileTabView = QfileRecentPicFileTabView.this;
                qfileRecentPicFileTabView.R0((FileManagerEntity) qfileRecentPicFileTabView.Q.getChild(i3, i19), this.f206761a);
            }
            for (int i26 = this.f206763c; i26 < min; i26++) {
                QfileRecentPicFileTabView qfileRecentPicFileTabView2 = QfileRecentPicFileTabView.this;
                qfileRecentPicFileTabView2.R0((FileManagerEntity) qfileRecentPicFileTabView2.Q.getChild(i3, i26), !this.f206761a);
            }
            while (true) {
                max++;
                if (max <= this.f206762b) {
                    QfileRecentPicFileTabView qfileRecentPicFileTabView3 = QfileRecentPicFileTabView.this;
                    qfileRecentPicFileTabView3.R0((FileManagerEntity) qfileRecentPicFileTabView3.Q.getChild(i3, max), !this.f206761a);
                } else {
                    QfileRecentPicFileTabView.this.W0();
                    return;
                }
            }
        }

        @Override // com.tencent.mobileqq.filemanager.widget.QfilePinnedHeaderExpandableListView.a
        public void c(boolean z16) {
        }

        @Override // com.tencent.mobileqq.filemanager.widget.QfilePinnedHeaderExpandableListView.a
        public void a(int i3, int i16) {
        }
    }
}
