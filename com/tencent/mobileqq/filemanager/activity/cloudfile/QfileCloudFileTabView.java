package com.tencent.mobileqq.filemanager.activity.cloudfile;

import android.content.Context;
import android.content.res.Configuration;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.filemanager.activity.fileassistant.QfileBaseTabView;
import com.tencent.mobileqq.filemanager.api.IQQFileEngine;
import com.tencent.mobileqq.filemanager.api.IQQFileTempUtils;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.ah;
import com.tencent.mobileqq.filemanager.util.t;
import com.tencent.mobileqq.filemanager.widget.QfilePinnedHeaderExpandableListView;
import com.tencent.mobileqq.filemanageraux.data.WeiYunFileInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes12.dex */
public class QfileCloudFileTabView extends QfileBaseCloudFileTabView {

    /* renamed from: f0, reason: collision with root package name */
    FMObserver f206442f0;

    /* renamed from: g0, reason: collision with root package name */
    final int f206443g0;

    /* renamed from: h0, reason: collision with root package name */
    int f206444h0;

    /* renamed from: i0, reason: collision with root package name */
    String f206445i0;

    /* renamed from: j0, reason: collision with root package name */
    private boolean f206446j0;

    /* renamed from: k0, reason: collision with root package name */
    private boolean f206447k0;

    /* renamed from: l0, reason: collision with root package name */
    private t f206448l0;

    /* renamed from: m0, reason: collision with root package name */
    private boolean f206449m0;

    /* renamed from: n0, reason: collision with root package name */
    private int f206450n0;

    /* renamed from: o0, reason: collision with root package name */
    g f206451o0;

    /* renamed from: p0, reason: collision with root package name */
    boolean f206452p0;

    /* renamed from: q0, reason: collision with root package name */
    QfilePinnedHeaderExpandableListView.a f206453q0;

    /* renamed from: r0, reason: collision with root package name */
    private View.OnClickListener f206454r0;

    /* renamed from: s0, reason: collision with root package name */
    private View.OnClickListener f206455s0;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.filemanager.activity.cloudfile.QfileCloudFileTabView$5, reason: invalid class name */
    /* loaded from: classes12.dex */
    class AnonymousClass5 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ WeiYunFileInfo f206456d;
        final /* synthetic */ QfileCloudFileTabView this$0;

        @Override // java.lang.Runnable
        public void run() {
            String historyGroupByTime = ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).getHistoryGroupByTime(this.f206456d.f209607i);
            if (!this.this$0.F.containsKey(historyGroupByTime)) {
                this.this$0.F.put(historyGroupByTime, new ArrayList());
            }
            List<WeiYunFileInfo> list = this.this$0.F.get(historyGroupByTime);
            if (list.contains(this.f206456d)) {
                return;
            }
            list.add(0, this.f206456d);
            this.this$0.C();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class b implements g {

        /* compiled from: P */
        /* loaded from: classes12.dex */
        class a implements View.OnClickListener {
            a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                ((QfileBaseTabView) QfileCloudFileTabView.this).f206606h = false;
                QfileCloudFileTabView.this.o0();
                EventCollector.getInstance().onViewClicked(view);
            }
        }

        b() {
        }

        @Override // com.tencent.mobileqq.filemanager.activity.cloudfile.QfileCloudFileTabView.g
        public View.OnClickListener a(TextView textView) {
            QfileCloudFileTabView.this.U = textView;
            return new a();
        }

        @Override // com.tencent.mobileqq.filemanager.activity.cloudfile.QfileCloudFileTabView.g
        public boolean b() {
            return QfileCloudFileTabView.this.W;
        }

        @Override // com.tencent.mobileqq.filemanager.activity.cloudfile.QfileCloudFileTabView.g
        public boolean c() {
            return QfileCloudFileTabView.this.f206452p0;
        }

        @Override // com.tencent.mobileqq.filemanager.activity.cloudfile.QfileCloudFileTabView.g
        public boolean isEnd() {
            return QfileCloudFileTabView.this.f206446j0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class c extends FMObserver {
        c() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.filemanager.app.FMObserver
        public void Q0(int i3, String str, String str2) {
            super.Q0(i3, str, str2);
            QfileCloudFileTabView.this.q0(false);
        }

        @Override // com.tencent.mobileqq.filemanager.app.FMObserver
        protected void R0(String str, boolean z16, int i3, String str2, List<WeiYunFileInfo> list, int i16) {
            String weiYunVideoThumb;
            QfileCloudFileTabView.this.f206447k0 = true;
            QfileCloudFileTabView.this.f206446j0 = z16;
            QfileCloudFileTabView.this.f206444h0 = i16;
            for (WeiYunFileInfo weiYunFileInfo : list) {
                int o06 = ah.o0(weiYunFileInfo.f209605f);
                if (o06 == 0) {
                    String weiYunPicThumb = ((IQQFileEngine) ((QfileBaseTabView) QfileCloudFileTabView.this).f206604e.getRuntimeService(IQQFileEngine.class)).getWeiYunPicThumb(weiYunFileInfo.f209603d, weiYunFileInfo.E, 3, weiYunFileInfo);
                    if (weiYunPicThumb != null) {
                        weiYunFileInfo.H = weiYunPicThumb;
                    }
                } else if (2 == o06 && (weiYunVideoThumb = ((IQQFileEngine) ((QfileBaseTabView) QfileCloudFileTabView.this).f206604e.getRuntimeService(IQQFileEngine.class)).getWeiYunVideoThumb(weiYunFileInfo.f209603d, weiYunFileInfo.E, 2, weiYunFileInfo)) != null) {
                    weiYunFileInfo.H = weiYunVideoThumb;
                }
            }
            if (!str.equals(QfileCloudFileTabView.this.E)) {
                return;
            }
            if (QfileCloudFileTabView.this.f206449m0) {
                QfileCloudFileTabView.this.M.clear();
            }
            QfileCloudFileTabView.this.M.addAll(list);
            if (!QfileCloudFileTabView.this.E.equalsIgnoreCase("picture")) {
                QfileCloudFileTabView.this.setListFooter();
            }
            QfileCloudFileTabView qfileCloudFileTabView = QfileCloudFileTabView.this;
            qfileCloudFileTabView.f206445i0 = str2;
            qfileCloudFileTabView.f206452p0 = true;
            qfileCloudFileTabView.u0();
            QfileCloudFileTabView.this.I0();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.filemanager.app.FMObserver
        public void T(boolean z16, long j3, long j16, String str, int i3) {
            QfileCloudFileTabView.this.N.notifyDataSetChanged();
        }

        @Override // com.tencent.mobileqq.filemanager.app.FMObserver
        protected void T0(Integer num, long j3, String str) {
            ah.C(j3, num.intValue(), str);
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class e implements View.OnClickListener {
        e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            QfileCloudFileTabView.this.G0(view, true);
            view.sendAccessibilityEvent(8);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class f implements View.OnClickListener {
        f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            QfileCloudFileTabView.this.G0(view, false);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public interface g {
        View.OnClickListener a(TextView textView);

        boolean b();

        boolean c();

        boolean isEnd();
    }

    public QfileCloudFileTabView(Context context, String str, int i3) {
        super(context);
        this.f206442f0 = null;
        this.f206443g0 = 15;
        this.f206444h0 = 0;
        this.f206447k0 = false;
        this.f206448l0 = null;
        this.f206449m0 = false;
        this.f206451o0 = null;
        this.f206452p0 = false;
        this.f206453q0 = new d();
        this.f206454r0 = new e();
        this.f206455s0 = new f();
        this.f206450n0 = i3;
        K0(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean F0(WeiYunFileInfo weiYunFileInfo, boolean z16) {
        if (weiYunFileInfo == null || ah.o0(((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).getExtension(weiYunFileInfo.f209605f)) != 0) {
            return false;
        }
        if (v() && ((com.tencent.mobileqq.filemanager.data.f.E(weiYunFileInfo) && z16) || (!com.tencent.mobileqq.filemanager.data.f.E(weiYunFileInfo) && !z16))) {
            return false;
        }
        if (v()) {
            if (z16) {
                com.tencent.mobileqq.filemanager.data.f.e(weiYunFileInfo);
                return true;
            }
            com.tencent.mobileqq.filemanager.data.f.I(weiYunFileInfo);
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G0(View view, boolean z16) {
        WeiYunFileInfo weiYunFileInfo = (WeiYunFileInfo) ((ob1.c) view.getTag()).f422335j;
        if (z16) {
            if (com.tencent.mobileqq.filemanager.data.f.E(weiYunFileInfo)) {
                com.tencent.mobileqq.filemanager.data.f.I(weiYunFileInfo);
            } else {
                com.tencent.mobileqq.filemanager.data.f.e(weiYunFileInfo);
                this.f206603d.G3(true);
                if (this.f206603d.j3() && !com.tencent.mobileqq.filemanager.data.f.w(com.tencent.mobileqq.filemanager.data.f.f207766l)) {
                    QQCustomDialog createNoTitleDialog = DialogUtil.createNoTitleDialog(this.f206603d, R.string.f0i);
                    createNoTitleDialog.setPositiveButton(R.string.i5e, new DialogUtil.DialogOnClickAdapter());
                    createNoTitleDialog.show();
                    com.tencent.mobileqq.filemanager.data.f.L(com.tencent.mobileqq.filemanager.data.f.f207766l);
                    FileManagerReporter.addData("0X800942F");
                }
            }
            k();
            p0();
        } else if (!w()) {
            if (QLog.isColorLevel()) {
                QLog.i(QfileBaseCloudFileTabView.f206414e0, 2, "click too fast , wait a minute.");
                return;
            }
            return;
        } else {
            if (v()) {
                ReportController.o(this.f206604e, "dc00898", "", "", "0X800A665", "0X800A665", 0, 0, "", "", "", "");
            }
            G();
            FileManagerReporter.addData("0X8004AE6");
            ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).openWeiYunFileBrowser(this.f206603d, j0(weiYunFileInfo), weiYunFileInfo);
        }
        f0(v());
    }

    private void J0() {
        if (this.f206448l0 == null) {
            this.f206448l0 = new a();
        }
        if (this.E.equalsIgnoreCase("document")) {
            if (this.f206603d.p3()) {
                this.f206603d.U2().W();
            } else {
                this.f206603d.U2().o();
            }
        } else if (this.E.equalsIgnoreCase("picture")) {
            if (this.f206603d.p3()) {
                this.f206603d.U2().L();
            } else {
                this.f206603d.U2().V();
            }
        } else if (this.E.equalsIgnoreCase("video")) {
            if (this.f206603d.p3()) {
                this.f206603d.U2().o0();
            } else {
                this.f206603d.U2().D();
            }
        } else if (this.E.equalsIgnoreCase("music")) {
            if (this.f206603d.p3()) {
                this.f206603d.U2().f0();
            } else {
                this.f206603d.U2().G();
            }
        } else if (this.E.equalsIgnoreCase("other")) {
            if (this.f206603d.p3()) {
                this.f206603d.U2().k();
            } else {
                this.f206603d.U2().d0();
            }
        }
        this.f206603d.P3(this.f206448l0);
    }

    private void K0(String str) {
        this.E = str;
        if (this.f206442f0 == null) {
            L0();
        }
        if (this.f206451o0 == null) {
            M0();
        }
        H0(false);
    }

    @Override // com.tencent.mobileqq.filemanager.activity.cloudfile.QfileBaseCloudFileTabView, com.tencent.mobileqq.filemanager.activity.fileassistant.QfileBaseTabView
    public void A() {
        super.A();
        if (this.E.equalsIgnoreCase("picture")) {
            setEditbarButton(true, true, false, true, true);
            J0();
            this.J.setOnIndexChangedListener(this.f206453q0);
        } else {
            setEditbarButton(false, true, false, true, true);
            J0();
        }
    }

    @Override // com.tencent.mobileqq.filemanager.activity.fileassistant.QfileBaseTabView
    public void B() {
        super.B();
        ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).deleteObserver(this.f206442f0);
    }

    protected void H0(boolean z16) {
        this.f206449m0 = z16;
        ((IQQFileEngine) this.f206604e.getRuntimeService(IQQFileEngine.class)).queryWeiyunFileList(this.f206450n0, this.E, 0, 15, this.f206445i0);
    }

    protected void I0() {
        E(new Runnable() { // from class: com.tencent.mobileqq.filemanager.activity.cloudfile.QfileCloudFileTabView.4
            @Override // java.lang.Runnable
            public void run() {
                QfileCloudFileTabView.this.F.clear();
                Iterator<WeiYunFileInfo> it = QfileCloudFileTabView.this.M.iterator();
                while (it.hasNext()) {
                    WeiYunFileInfo next = it.next();
                    String historyGroupByTime = ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).getHistoryGroupByTime(next.f209607i);
                    if (!QfileCloudFileTabView.this.F.containsKey(historyGroupByTime)) {
                        QfileCloudFileTabView.this.F.put(historyGroupByTime, new ArrayList());
                    }
                    QfileCloudFileTabView.this.F.get(historyGroupByTime).add(next);
                }
                QfileCloudFileTabView.this.C();
                QfileCloudFileTabView.this.setSelect(0);
                QfileCloudFileTabView.this.q0(true);
            }
        });
    }

    void L0() {
        if (this.f206442f0 != null) {
            ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).deleteObserver(this.f206442f0);
        }
        this.f206442f0 = new c();
        ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).addObserver(this.f206442f0);
    }

    void M0() {
        this.f206451o0 = new b();
    }

    public void N0() {
        this.f206603d.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.filemanager.activity.cloudfile.QfileCloudFileTabView.7
            @Override // java.lang.Runnable
            public void run() {
                QfileCloudFileTabView.this.k();
                QfileCloudFileTabView.this.p0();
            }
        });
    }

    @Override // com.tencent.mobileqq.filemanager.activity.cloudfile.QfileBaseCloudFileTabView
    protected boolean d0(WeiYunFileInfo weiYunFileInfo) {
        if (!this.M.contains(weiYunFileInfo)) {
            return false;
        }
        this.M.remove(weiYunFileInfo);
        String historyGroupByTime = ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).getHistoryGroupByTime(weiYunFileInfo.f209607i);
        if (!this.F.containsKey(historyGroupByTime)) {
            QLog.e(QfileBaseCloudFileTabView.f206414e0, 1, "delRecentFileRecords, fileEntities find, but recentRecords not find!");
            return false;
        }
        this.F.get(historyGroupByTime).remove(weiYunFileInfo);
        if (this.F.get(historyGroupByTime).size() == 0) {
            this.F.remove(historyGroupByTime);
        }
        C();
        return true;
    }

    @Override // com.tencent.mobileqq.filemanager.activity.cloudfile.QfileBaseCloudFileTabView
    protected ob1.d i0() {
        if (this.E.equalsIgnoreCase("picture")) {
            setEditbarButton(true, true, false, true, true);
            return new ob1.g(this.f206451o0, o(), this.F, this.S, this.f206454r0, this.f206455s0, this.f206415a0, this.f206417c0);
        }
        setEditbarButton(false, true, false, true, true);
        return new com.tencent.mobileqq.filemanager.activity.cloudfile.a(o(), this.F, o(), this.S, this.f206416b0, this.f206415a0, this.f206417c0);
    }

    @Override // com.tencent.mobileqq.filemanager.activity.cloudfile.QfileBaseCloudFileTabView
    public boolean m0() {
        return this.f206446j0;
    }

    @Override // com.tencent.mobileqq.filemanager.activity.cloudfile.QfileBaseCloudFileTabView
    protected void o0() {
        this.f206449m0 = false;
        if (!NetworkUtil.isNetworkAvailable(o())) {
            com.tencent.mobileqq.filemanager.util.d.e(R.string.b_o);
            return;
        }
        this.f206452p0 = false;
        ((IQQFileEngine) this.f206604e.getRuntimeService(IQQFileEngine.class)).queryWeiyunFileList(this.f206450n0, this.E, this.f206444h0 * 15, 15, this.f206445i0);
        t0();
    }

    @Override // com.tencent.mobileqq.filemanager.activity.fileassistant.QfileBaseTabView, android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        QfilePinnedHeaderExpandableListView qfilePinnedHeaderExpandableListView;
        super.onConfigurationChanged(configuration);
        ob1.d dVar = this.N;
        if (dVar != null && (qfilePinnedHeaderExpandableListView = this.J) != null && (dVar instanceof ob1.g)) {
            ob1.g gVar = (ob1.g) dVar;
            qfilePinnedHeaderExpandableListView.setGridSize(gVar.l());
            gVar.p();
        }
    }

    @Override // com.tencent.mobileqq.filemanager.activity.fileassistant.QfileBaseTabView, com.tencent.mobileqq.filemanager.activity.fileassistant.a
    public void onResume() {
        super.onResume();
        L0();
        if (this.f206447k0) {
            C();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class a extends t {
        a() {
        }

        @Override // com.tencent.mobileqq.filemanager.util.t
        public void a() {
            QfileCloudFileTabView.this.f206603d.U2().p0();
        }

        @Override // com.tencent.mobileqq.filemanager.util.t
        public void b() {
            QfileCloudFileTabView.this.f206603d.U2().n0();
        }

        @Override // com.tencent.mobileqq.filemanager.util.t
        public void c() {
            QfileCloudFileTabView.this.f206603d.U2().I();
        }

        @Override // com.tencent.mobileqq.filemanager.util.t
        public void e() {
            QfileCloudFileTabView.this.f206603d.U2().i0();
        }

        @Override // com.tencent.mobileqq.filemanager.util.t
        public void f() {
            QfileCloudFileTabView.this.f206603d.U2().m0();
        }

        @Override // com.tencent.mobileqq.filemanager.util.t
        public void d() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class d implements QfilePinnedHeaderExpandableListView.a {

        /* renamed from: a, reason: collision with root package name */
        private boolean f206461a;

        /* renamed from: b, reason: collision with root package name */
        private int f206462b;

        /* renamed from: c, reason: collision with root package name */
        private int f206463c;

        d() {
        }

        @Override // com.tencent.mobileqq.filemanager.widget.QfilePinnedHeaderExpandableListView.a
        public void b(int i3, int i16) {
            this.f206461a = false;
            this.f206462b = Integer.MIN_VALUE;
            this.f206463c = Integer.MAX_VALUE;
            WeiYunFileInfo weiYunFileInfo = (WeiYunFileInfo) QfileCloudFileTabView.this.N.getChild(i3, i16);
            if (weiYunFileInfo == null) {
                return;
            }
            boolean z16 = !com.tencent.mobileqq.filemanager.data.f.E(weiYunFileInfo);
            this.f206461a = z16;
            if (QfileCloudFileTabView.this.F0(weiYunFileInfo, z16)) {
                QfileCloudFileTabView.this.N0();
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
                this.f206463c = Math.min(i18, this.f206463c);
            } else {
                this.f206462b = Math.max(i18, this.f206462b);
            }
            for (int i19 = min; i19 <= max; i19++) {
                QfileCloudFileTabView qfileCloudFileTabView = QfileCloudFileTabView.this;
                qfileCloudFileTabView.F0((WeiYunFileInfo) qfileCloudFileTabView.N.getChild(i3, i19), this.f206461a);
            }
            for (int i26 = this.f206463c; i26 < min; i26++) {
                QfileCloudFileTabView qfileCloudFileTabView2 = QfileCloudFileTabView.this;
                qfileCloudFileTabView2.F0((WeiYunFileInfo) qfileCloudFileTabView2.N.getChild(i3, i26), !this.f206461a);
            }
            while (true) {
                max++;
                if (max <= this.f206462b) {
                    QfileCloudFileTabView qfileCloudFileTabView3 = QfileCloudFileTabView.this;
                    qfileCloudFileTabView3.F0((WeiYunFileInfo) qfileCloudFileTabView3.N.getChild(i3, max), !this.f206461a);
                } else {
                    QfileCloudFileTabView.this.N0();
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
