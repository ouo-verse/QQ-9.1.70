package com.tencent.mobileqq.filemanager.activity.favfile;

import android.content.Context;
import android.content.res.Configuration;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.filemanager.activity.favfile.QfileBaseFavFileTabView;
import com.tencent.mobileqq.filemanager.activity.favfile.b;
import com.tencent.mobileqq.filemanager.api.IQQFileTempUtils;
import com.tencent.mobileqq.filemanager.data.FavFileInfo;
import com.tencent.mobileqq.filemanager.data.f;
import com.tencent.mobileqq.filemanager.widget.QfilePinnedHeaderExpandableListView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* loaded from: classes12.dex */
public class QfileFavPicFileTabView extends QfileBaseFavFileTabView {

    /* renamed from: a0, reason: collision with root package name */
    static String f206552a0 = "QfileFavPicFileTabView<FileAssistant>";
    b.c T;
    private View.OnClickListener U;
    private View.OnClickListener V;
    private QfilePinnedHeaderExpandableListView.a W;

    /* loaded from: classes12.dex */
    class a implements b.c {
        a() {
        }

        @Override // com.tencent.mobileqq.filemanager.activity.favfile.b.c
        public View.OnClickListener a(TextView textView) {
            QfileFavPicFileTabView.this.M();
            return null;
        }

        @Override // com.tencent.mobileqq.filemanager.activity.favfile.b.c
        public boolean b() {
            return QfileFavPicFileTabView.this.S();
        }

        @Override // com.tencent.mobileqq.filemanager.activity.favfile.b.c
        public boolean c(FavFileInfo favFileInfo) {
            return false;
        }

        @Override // com.tencent.mobileqq.filemanager.activity.favfile.b.c
        public boolean d() {
            return QfileFavPicFileTabView.this.T();
        }
    }

    /* loaded from: classes12.dex */
    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            QfileFavPicFileTabView.this.j0(view, true);
            view.sendAccessibilityEvent(8);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* loaded from: classes12.dex */
    class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            QfileFavPicFileTabView.this.j0(view, false);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public QfileFavPicFileTabView(Context context, QfileFavFileRecordProvider qfileFavFileRecordProvider, QfileBaseFavFileTabView.d dVar) {
        super(context, qfileFavFileRecordProvider, dVar);
        this.T = new a();
        this.U = new b();
        this.V = new c();
        this.W = new d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean h0(FavFileInfo favFileInfo, boolean z16) {
        if (favFileInfo == null) {
            return false;
        }
        i0(z16);
        if (v() && ((f.B(favFileInfo) && z16) || (!f.B(favFileInfo) && !z16))) {
            return false;
        }
        if (v()) {
            if (z16) {
                f.b(favFileInfo);
                return true;
            }
            f.F(favFileInfo);
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j0(View view, boolean z16) {
        FavFileInfo favFileInfo = (FavFileInfo) ((ob1.c) view.getTag()).f422335j;
        if (z16) {
            if (f.B(favFileInfo)) {
                f.F(favFileInfo);
            } else {
                f.b(favFileInfo);
                this.f206603d.G3(true);
            }
            k();
            Y();
        } else {
            if (!w()) {
                if (QLog.isColorLevel()) {
                    QLog.i(f206552a0, 2, "click too fast , wait a minute.");
                    return;
                }
                return;
            }
            G();
            ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).openFavorite(this.f206603d, this.f206604e.getCurrentAccountUin(), favFileInfo.f207672d);
        }
        i0(v());
    }

    @Override // com.tencent.mobileqq.filemanager.activity.favfile.QfileBaseFavFileTabView, com.tencent.mobileqq.filemanager.activity.fileassistant.QfileBaseTabView
    public void A() {
        if (this.N) {
            return;
        }
        super.A();
        setEditbarButton(true, true, false, true, true);
        this.F.setOnIndexChangedListener(this.W);
        if (this.f206603d.p3()) {
            this.f206603d.U2().O();
        } else {
            ReportController.o(this.f206604e, "dc00898", "", "", "0X800AFAC", "0X800AFAC", 0, 0, "", "", "", "");
        }
    }

    @Override // com.tencent.mobileqq.filemanager.activity.favfile.QfileBaseFavFileTabView
    protected int K() {
        return 1;
    }

    @Override // com.tencent.mobileqq.filemanager.activity.favfile.QfileBaseFavFileTabView
    protected String L(FavFileInfo favFileInfo) {
        return ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).getHistoryGroupByTime(favFileInfo.C);
    }

    @Override // com.tencent.mobileqq.filemanager.activity.favfile.QfileBaseFavFileTabView
    protected int N() {
        return 60;
    }

    @Override // com.tencent.mobileqq.filemanager.activity.favfile.QfileBaseFavFileTabView
    protected ob1.d O() {
        return new com.tencent.mobileqq.filemanager.activity.favfile.b(this.T, o(), this.E, this.U, this.V, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.filemanager.activity.favfile.QfileBaseFavFileTabView
    public void W(int i3) {
        super.W(i3);
        com.tencent.mobileqq.filemanager.activity.favfile.b bVar = (com.tencent.mobileqq.filemanager.activity.favfile.b) this.G;
        if (T() && bVar.m()) {
            C();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.filemanager.activity.favfile.QfileBaseFavFileTabView
    public void X() {
        super.X();
        this.F.setWhetherImageTab(true);
        this.F.setGridSize(((com.tencent.mobileqq.filemanager.activity.favfile.b) this.G).l());
    }

    protected void i0(boolean z16) {
        ReportController.o(this.f206604e, "dc00898", "", "", "0X800AFAD", "0X800AFAD", 0, 0, "", "", "", "");
    }

    public void k0() {
        this.f206603d.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.filemanager.activity.favfile.QfileFavPicFileTabView.5
            @Override // java.lang.Runnable
            public void run() {
                QfileFavPicFileTabView.this.k();
                QfileFavPicFileTabView.this.Y();
            }
        });
    }

    @Override // com.tencent.mobileqq.filemanager.activity.fileassistant.QfileBaseTabView, android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        QfilePinnedHeaderExpandableListView qfilePinnedHeaderExpandableListView;
        super.onConfigurationChanged(configuration);
        ob1.d dVar = this.G;
        if (dVar != null && (qfilePinnedHeaderExpandableListView = this.F) != null && (dVar instanceof com.tencent.mobileqq.filemanager.activity.favfile.b)) {
            com.tencent.mobileqq.filemanager.activity.favfile.b bVar = (com.tencent.mobileqq.filemanager.activity.favfile.b) dVar;
            qfilePinnedHeaderExpandableListView.setGridSize(bVar.l());
            bVar.q();
        }
    }

    /* loaded from: classes12.dex */
    class d implements QfilePinnedHeaderExpandableListView.a {

        /* renamed from: a, reason: collision with root package name */
        private boolean f206556a;

        /* renamed from: b, reason: collision with root package name */
        private int f206557b;

        /* renamed from: c, reason: collision with root package name */
        private int f206558c;

        d() {
        }

        @Override // com.tencent.mobileqq.filemanager.widget.QfilePinnedHeaderExpandableListView.a
        public void b(int i3, int i16) {
            this.f206556a = false;
            this.f206557b = Integer.MIN_VALUE;
            this.f206558c = Integer.MAX_VALUE;
            FavFileInfo favFileInfo = (FavFileInfo) QfileFavPicFileTabView.this.G.getChild(i3, i16);
            if (favFileInfo == null) {
                return;
            }
            boolean z16 = !f.B(favFileInfo);
            this.f206556a = z16;
            if (QfileFavPicFileTabView.this.h0(favFileInfo, z16)) {
                QfileFavPicFileTabView.this.k0();
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
                this.f206558c = Math.min(i18, this.f206558c);
            } else {
                this.f206557b = Math.max(i18, this.f206557b);
            }
            for (int i19 = min; i19 <= max; i19++) {
                QfileFavPicFileTabView qfileFavPicFileTabView = QfileFavPicFileTabView.this;
                qfileFavPicFileTabView.h0((FavFileInfo) qfileFavPicFileTabView.G.getChild(i3, i19), this.f206556a);
            }
            for (int i26 = this.f206558c; i26 < min; i26++) {
                QfileFavPicFileTabView qfileFavPicFileTabView2 = QfileFavPicFileTabView.this;
                qfileFavPicFileTabView2.h0((FavFileInfo) qfileFavPicFileTabView2.G.getChild(i3, i26), !this.f206556a);
            }
            while (true) {
                max++;
                if (max <= this.f206557b) {
                    QfileFavPicFileTabView qfileFavPicFileTabView3 = QfileFavPicFileTabView.this;
                    qfileFavPicFileTabView3.h0((FavFileInfo) qfileFavPicFileTabView3.G.getChild(i3, max), !this.f206556a);
                } else {
                    QfileFavPicFileTabView.this.k0();
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
